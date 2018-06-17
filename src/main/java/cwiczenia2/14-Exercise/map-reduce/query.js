var mapper = function () {
  var calculateBMI = function (weight, height) {
    return (weight / Math.pow(height / 100, 2));
  }

  var weight = parseFloat(this.weight);
  var height = parseFloat(this.height);

  emit(this.nationality, {
    count: 1,
    sum: calculateBMI(weight, height),
    min: calculateBMI(weight, height),
    max: calculateBMI(weight, height),
  });
};

var reducer = function (key, values) {
  var redecedValue = {
    count: 0,
    sum: 0,
    min: values[0].min,
    max: values[0].max,
  }

  values.forEach(function (value) {
    redecedValue.count += value.count;
    redecedValue.sum += value.sum;
    redecedValue.min = Math.min(redecedValue.min, value.min);
    redecedValue.max = Math.max(redecedValue.max, value.max);
  });

  return redecedValue;
}

var finalizer = function (key, reducedValue) {
  reducedValue.avg = reducedValue.sum / reducedValue.count;
  delete reducedValue.sum;
  return reducedValue;
}

db.people.mapReduce(mapper, reducer, {
  out: 'bmi_nationality_stats',
  finalize: finalizer,
});