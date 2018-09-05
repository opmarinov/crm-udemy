var data;

window.onload = function () {

  /// Make a call to the rest end point to retrieve the data for the charts.
  $.ajax({
    method: "GET",
    url: "http://localhost:8086/retrieve/contribution"
  })
  .done(function (res) {
    console.log(res);
    data = res;

    ///Initialize with the pie chart.
    populatePieChart(res)
  });


  $('#selectChart')
  .change(function () {
    var str = "";
    $( "select option:selected" ).each(function() {
      str += $( this ).val();
    });

    if(str === 'Pie')
      populatePieChart(data);
    if(str === 'Bar')
      populateBarChart(data);
    if(str === 'Line')
      populateLineChart(data);

    console.log('Hey i changed! ', str);
  });


};

function populatePieChart(result) {

  var options = {
    animationEnabled: true,
    title: {
      text: "Contribution Chart"
    },
    data: [{
      type: "doughnut",
      innerRadius: "40%",
      showInLegend: true,
      legendText: "{label}",
      indexLabel: "{label}: #percent%",
      dataPoints:
        result
    }]
  };
  $("#chartContainer").CanvasJSChart(options);
}


function populateBarChart(result) {
  var options = {
    animationEnabled: true,
    title: {
      text: "Contribution Chart"
    },
    axisY: {
      title: "All in all",
      includeZero: true
    },
    axisX: {
      title: "Employees"
    },
    data: [{
      type: "column",
      dataPoints: result
    }]
  };
  $("#chartContainer").CanvasJSChart(options);
}

/*$('select').change(function() {
  console.log('Hey i changed!');
  var val = $('secelct').val();

  if(val === 'Pie')
    populatePieChart(data);
  if(val === 'Bar')
    populateBarChart(data);
});*/

function populateLineChart(result){
  var options = {
    animationEnabled: true,
    title:{
      text: "Contribution"
    },
    axisY: {
      includeZero: true
    },
    data: [{
      type: "spline",
      dataPoints: result
    }]
  };
  $("#chartContainer").CanvasJSChart(options);
}