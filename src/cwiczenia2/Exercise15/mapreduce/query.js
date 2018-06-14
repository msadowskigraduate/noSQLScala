var mapper = function () {
  if (!this.credit) return;

  this.credit.forEach(function (credit) {
    emit(credit.currency, {
      count: 1,
      balance: parseFloat(credit.balance) || 0,
    });
  });
};

var reduceFunction = function (key, values) {
  var reductor = {
    count: 0,
    balance: 0,
  }

  values.forEach(function (value) {
    reductor.count += value.count;
    reductor.balance += value.balance;
  });

  return reductor;
}

var finalize = function (key, value) {
  value.avg = (value.balance / value.count).toFixed(2);
  value.sum = value.balance;
  delete value.balance;
  return value;
}

db.people.mapReduce(mapper, reduceFunction, {
  query: {
    "nationality": "Poland",
    "sex": "Female"
  },
  out: "credit_amount_for_polish_woman",
  finalize: finalize
});
