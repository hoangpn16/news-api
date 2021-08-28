// $.ajax({
//     url: 'https://news.plusplus.vn/news/getcontent?ID='+ id, // url where to submit the request
//     type: "GET", // type of action POST || GET
//     contentType: "application/json",
//     dataType: 'json', // data type
//     //data: JSON.stringify(data),
//     success: function (result) {
//         document.getElementById("og-title").content = result.title;
//         document.getElementById("og-image").content = result.avatar;
//         document.getElementById("og-des").content = result.description;
//         var url = "https://plusplus.vn/news-detail.html?id=" + id;
//         document.getElementById("og-url").content = url;
//         async: false;
//     },
//     error: function (xhr, resp, text) {
//         console.log(xhr, resp, text);

//     }

// });


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
var id = getUrlParameter('id');


function loadNews() {

    $.ajax({
        url: 'https://news.plusplus.vn/news/getcontent?ID=' + id, // url where to submit the request
        type: "GET", // type of action POST || GET
        contentType: "application/json",
        dataType: 'json', // data type
        //data: JSON.stringify(data),
        success: function (result) {
            document.getElementById("title-details").innerHTML = result.title;
            document.getElementById("content-news").innerHTML = result.content;
            // console.log(result.content);
            document.getElementById("og-title").content = result.title;
            document.getElementById("og-image").content = result.avatar;
            document.getElementById("og-des").content = result.description;
            var url = "https://plusplus.vn/news-detail.html?id=" + id;
            document.getElementById("og-url").content = url;
            $('#content-news').append(`<div style=" margin-bottom:10px" id="share-link" class="fb-share-button" data-size="large" 
            data-href="https://plusplus.vn/news-detail.html?id=`+ id + `"
            data-layout="button_count">
            </div>`);
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

// function load() {

//     $.ajax({
//         url: 'https://news.plusplus.vn/news/getcontent?ID='+id , // url where to submit the request
//         type: "GET", // type of action POST || GET
//         contentType: "application/json",
//         dataType: 'json', // data type
//         //data: JSON.stringify(data),
//         success: function (result) {
//                 // document.getElementsByTagName('meta')["title"].content = result.title;
//                 // document.getElementsByTagName('meta')["image"].content = result.avatar;
//                 // document.getElementsByTagName('meta')["description"].content = result.description;
//                 // var url ="https://plusplus.vn/news-details.html?id="+id;
//                 // document.getElementsByTagName('meta')["url"].content = url;
                // document.getElementById("og-title").content = result.title;
                // document.getElementById("og-image").content = result.avatar;
                // document.getElementById("og-des").content = result.description;
                // var url ="https://plusplus.vn/news-detail.html?id="+id;
                // document.getElementById("og-url").content = url;
//         },
//         error: function (xhr, resp, text) {
//             console.log(xhr, resp, text);
//         }

//     });

// }
// load()