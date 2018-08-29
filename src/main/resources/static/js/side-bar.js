var sideBarWidth = 0;
var expanded = false;

$(document).ready(function () {
  sideBarWidth = $('.side-bar').width() - 54;  // 54 is the minimum width of the sidebar aka how much u wanna see from the sidebar when it's hidden
  $('.side-bar-logout').css({"width": $('.side-bar').width() + "px", "transition": "0.2s"});
});

function expandSideBar() {
  var width = "-" + sideBarWidth + "px";

  console.log(width);

  if (!expanded) {
    $('.side-bar').css({"left": "0", "transition": "0.2s"});
    $('.side-bar-icons > i').css({"opacity": "0", "transition": "0.2s"});
    $('.side-bar-logout').css({"width": $('.side-bar').width() + "px", "transition": "0.2s"});
    $('.side-bar-logout').css({"text-align": "center", "transition": "0.2s"});

    expanded = true;
  }
  else {
    $('.side-bar').css({"left": width, "transition": "0.2s"});  ///was 40px;
    $('.side-bar-icons > i').css({"opacity": "1", "transition": "0.2s"});
    $('.side-bar-logout').css({"width": "+" +  $('.side-bar').width() + "px", "transition": "0.2s"});
    $('.side-bar-logout').css({"text-align": "right", "transition": "0.2s"});

    expanded = false;
  }
}