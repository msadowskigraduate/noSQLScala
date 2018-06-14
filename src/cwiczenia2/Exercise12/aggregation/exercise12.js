/**
 * Created by esadowska on 14/06/2018.
 */
db.people.find().forEach(function(data) {
    db.people.update({
        "_id": data._id
    }, {
        "$set": {
            "weight": parseFloat(data.weight),
            "height": parseFloat(data.height),
        }
    });
});

db.people.aggregate([
    {
        $group: {
            _id: '$sex',
            avgHeight: { $avg: '$height' },
            avgWeight: { $avg: '$weight'},
            count: { $sum: 1 }
        }
    }
]);
