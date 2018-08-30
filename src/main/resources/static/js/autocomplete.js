/*<![CDATA[*/

$(document).ready(function () {

  var currentPosition = -1;
  var elems = document.getElementById('suggestion-dropdown').childNodes;

  $('.suggestion-dropdown').width(
      String.valueOf($('#search').width())
  );

  $('#search').on('keyup', function (e) {
    // console.log('im here');

    if(e.keyCode === 38 || e.which === 38 || e.charCode === 38)
    {
      console.log('up');
      console.log(currentPosition);

      if(currentPosition === 0) currentPosition = elems.length;
      currentPosition--;
      // elems[currentPosition].style.backgroundColor = '#fffcfc';
      elems[currentPosition].style.backgroundColor = 'rgb(222, 226, 230)';

      $('#search').val(elems[currentPosition].innerHTML);

      for (var i = 0; i < elems.length; i++) {
        // if(currentPosition !== i) elems[i].style.backgroundColor = 'rgba(226, 226, 226, 0.2)';
        if(currentPosition !== i) elems[i].style.backgroundColor = 'white';
      }
    }

    else if(e.keyCode === 40 || e.which === 40 || e.charCode === 40)
    {
      // console.log('down');

      // console.log(elems);
      console.log(currentPosition);

      if(currentPosition === elems.length - 1) currentPosition = -1;

      currentPosition++;
      // elems[currentPosition].style.backgroundColor = '#fffcfc';
      elems[currentPosition].style.backgroundColor = 'rgb(222, 226, 230)';

      $('#search').val(elems[currentPosition].innerHTML);

      for (var i = 0; i < elems.length; i++) {
        // if(currentPosition !== i) elems[i].style.backgroundColor = 'rgba(226, 226, 226, 0.2)';
        if(currentPosition !== i) elems[i].style.backgroundColor = 'white';
      }
    }

    else sendSearchRequest();

  });

  function sendSearchRequest() {

    currentPosition = -1;

    var searchVal = "";

    if ($('#search').val() !== "") {
      searchVal = $('#search').val();
    }

    $('#suggestion-dropdown').html('');

    $.ajax({
      method: "GET",
      url: "http://localhost:8086/list/please",
      data: {searchQuery: searchVal}
    })
    .done(function (res) {
      populateSuggestionDropdown(res);
    });
  }

  function populateSuggestionDropdown(res) {
    var parsedObject = jQuery.parseJSON(JSON.stringify(res));
    var div;

    if (res !== null) {
      for (var i = 0; i < parsedObject.length; i++) {
        // console.log(parsedObject[i].firstname);

        div = document.createElement('div');
        div.innerHTML = parsedObject[i].firstname + " " + parsedObject[i].lastname;
        div.style.borderLeft = "1px solid rgba(222, 226, 230, 0.8)";
        div.style.borderRight = "1px solid rgba(222, 226, 230, 0.8)";
        div.style.borderBottom = "1px solid rgba(222, 226, 230, 0.8)";
        div.style.padding = "10px";

        div.onmouseover = function () {
          // this.style.backgroundColor = "#fffcfc";
          this.style.backgroundColor = "rgb(222, 226, 230)";
        };

        div.onmouseout = function () {
          // this.style.backgroundColor = "rgba(226, 226, 226, 0.2)";
          this.style.backgroundColor = "white";
        };

        div.onclick = function () {
          window.location.href = "/api/search?name="
              + this.innerHTML.split(" ")[0];
        };

        document.getElementById("suggestion-dropdown").appendChild(div);
      }
    }
  }

  $.ajax({
    url: "http://localhost:8086/image/source",
    success: function(data) {
      return "blaaa";
    }
  });
});
/*]]>*/