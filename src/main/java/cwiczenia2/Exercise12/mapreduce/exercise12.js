var mapper = function () {
    emit(this.sex,
        { height: parseFloat(this.height),
          weight: parseFloat(this.weight),
          count: 1
        }
    );
};

var reducer = function (key, values) {
    var reductor = {
        count: 0,
        height: 0,
        weight: 0
    };

    values.forEach(function (value) {
        reductor.height = reductor.height + value.height;
        reductor.weight = reductor.weight + value.weight;
        reductor.count = reductor.count + value.count;
    });
    return reductor;
};

var mean = function (key, result) {
    result.height = result.height / result.count;
    result.weight = result.weight / result.count;
    return result;
};

printjson(db.people.mapReduce(mapper, reducer, {
    out: 'weight_mean_avg',
    finalize: mean,
}));
