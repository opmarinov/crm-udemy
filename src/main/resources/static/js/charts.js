window.onload = function () {
  var labels = {};
  var y = {};

  $.ajax({
    method: "GET",
    url: "http://localhost:8086/retrieve/contribution"
  })
  .done(function (res) {
    console.log(res);

    populatePieChart(res);
    populateBarChart(res);
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
      text: "GDP Growth Rate - 2016"
    },
    axisY: {
      title: "Growth Rate (in %)",
      suffix: "%",
      includeZero: false
    },
    axisX: {
      title: "Countries"
    },
    data: [{
      type: "column",
      dataPoints: result
    }]
  };
  $("#chartContainer2").CanvasJSChart(options);
}