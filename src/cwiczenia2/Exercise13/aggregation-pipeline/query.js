db.people.aggregate([
  {
    $group: {
      _id: '$job',
      count: { $sum: 1 },
    },
  },
]);
