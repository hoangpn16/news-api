

var getUrlParameter = function getUrlParameter(sParam) {
    var sPageURL = window.location.search.substring(1),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return typeof sParameterName[1] === undefined ? true : decodeURIComponent(sParameterName[1]);
        }
    }
    return false;
};
var id = getUrlParameter('ID');


function loadNews() {

    $.ajax({
        url: 'http://localhost:8090/news/getcontent?ID=' + id, // url where to submit the request
        type: "GET", // type of action POST || GET
        contentType: "application/json",
        dataType: 'json', // data type
        //data: JSON.stringify(data),
        success: function (result) {
            document.getElementById("content-news").innerHTML = result.content;
            // document.getElementById("share-link").setAttribute("data-href", "/news-detail.html?id="+id);
        },
        error: function (xhr, resp, text) {
            console.log(xhr, resp, text);
        }

    });

}

window.fbAsyncInit = function () {
    FB.init({
        appId: '481256309709126',
        autoLogAppEvents: true,
        xfbml: true,
        version: 'v2.11'
    });
};
loadNews();
(function (d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s);
    js.id = id;
    js.src = 'https://connect.facebook.net/vi_VN/sdk/xfbml.customerchat.js';
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));
