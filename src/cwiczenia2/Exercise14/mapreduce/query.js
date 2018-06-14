var mapper = function () {
  var bmiCalc = function (weight, height) {
    return (weight/Math.pow(height/100, 2));
  }

  var weight = parseFloat(this.weight);
  var height = parseFloat(this.height);

  emit(this.nationality, {
    count: 1,
    sum: bmiCalc(weight, height),
    min: bmiCalc(weight, height),
    max: bmiCalc(weight, height),
  });
};

var reducer = function (key, values) {
  var reductor = {
    count: 0,
    sum: 0,
    min: values[0].min,
    max: values[0].max,
  };

  values.forEach(function (value) {
    reductor.count = reductor.count + value.count;
    reductor.sum = reductor.sum + value.sum;
    reductor.min = Math.min(reductor.min, value.min);
    reductor.max = Math.max(reductor.max, value.max);
  });

  return reductor;
};

var finalizer = function (key, value) {
  value.avg = value.sum / value.count;
  delete value.sum;
  return value;
};

db.people.mapReduce(mapper, reducer, {
  out: 'bmi_per_country',
  finalize: finalizer,
});