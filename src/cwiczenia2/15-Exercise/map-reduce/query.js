var mapper = function () {
  if (!this.credit) return;

  this.credit.forEach(function (credit) {
    emit(credit.currency, {
      count: 1,
      balance: parseFloat(credit.balance) || 0,
    });
  });
};

var reducer = function (key, values) {
  var redecedValue = {
    count: 0,
    balance: 0,
  }

  values.forEach(function (value) {
    redecedValue.count += value.count;
    redecedValue.balance += value.balance;
  });

  return redecedValue;
}

var finalizer = function (key, reducedValue) {
  reducedValue.avg = (reducedValue.balance / reducedValue.count).toFixed(2);
  reducedValue.sum = reducedValue.balance;
  delete reducedValue.balance;
  return reducedValue;
}

db.people.mapReduce(mapper, reducer, {
  query: {
    "nationality": "Poland",
    "sex": "Female"
  },
  out: "polish_women_credit_card_amount",
  finalize: finalizer
});
