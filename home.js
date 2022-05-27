//setup jQuery Plugin
var jQueryScript = document.createElement('script');
jQueryScript.setAttribute('src', 'https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js');
document.head.appendChild(jQueryScript);
setTimeout(function() {
    $(document).ready(function() {
        clockUpdate();
        setInterval(clockUpdate, 1000);
    })

//life clock https://codepen.io/iiSeptum/pen/LYWYop 27-05-2022
    function clockUpdate() {
        var date = new Date();
        $('.digital-clock').css({'color': '#fff', 'text-shadow': '0 0 6px #ff0'});
        function addZero(x) {
            if (x < 10) {
                return x = '0' + x;
            } else {
                return x;
            }
        }
//timeframe for the clock https://codepen.io/iiSeptum/pen/LYWYop 27-05-2022
        function twelveHour(x) {
            if (x > 24) {
                return x = x - 24;
            } else if (x == 0) {
                return x = 24;
            } else {
                return x;
            }
        }

        var h = addZero(twelveHour(date.getHours()));
        var m = addZero(date.getMinutes());
        var s = addZero(date.getSeconds());

        $('.digital-clock').text(h + ':' + m + ':' + s)
    }
}, 100);