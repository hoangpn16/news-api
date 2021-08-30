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
function loadBlog() {

    $.ajax({
        url: 'http://localhost:8090/getBlogsDetail?ID='+id, // url where to submit the request
        type: "GET", // type of action POST || GET
        contentType: "application/json",
        dataType: 'json', // data type
        //data: JSON.stringify(data),
        success: function (result) {
            // you can see the result from the console
            // tab of the developer tools
            document.getElementById("title-blogs").innerHTML = result.title;
            document.getElementById("content-blogs").innerHTML = result.content;
            document.getElementById("author").innerHTML = result.author;
            document.getElementById("viewPost").innerHTML = result.viewPost;
            document.getElementById("likePost").innerHTML = result.likePost;
            document.getElementById("avatar").setAttribute("src", result.avatar);
            
            var addParam = function (url, param, value) {
                param = encodeURIComponent(param);
                var a = document.createElement('a');
                param += (value ? "=" + encodeURIComponent(value) : "");
                a.href = url;
                a.search += (a.search ? "&" : "") + param;
                return a.href;
            }
        },
        error: function (xhr, resp, text) {
            console.log(xhr, resp, text);
        }

    });

    $.ajax({
        url: 'http://localhost:8090/getBlogs?pageNum=0', // url where to submit the request
        type: "GET", // type of action POST || GET
        contentType: "application/json",
        dataType: 'json', // data type
        //data: JSON.stringify(data),
        success: function (result) {
            // you can see the result from the console
            // tab of the developer tools
            // console.log(pageNum + 1)
            console.log(result)
            for (let i = 0; i < result.length; i++) {
                document.getElementsByClassName("title-recents")[i].innerHTML = result[i].title;
                document.getElementsByClassName("title-recents")[i].setAttribute("href", "/blog-detail.html?id=" + result[i].id);
            }
            var addParam = function (url, param, value) {
                param = encodeURIComponent(param);
                var a = document.createElement('a');
                param += (value ? "=" + encodeURIComponent(value) : "");
                a.href = url;
                a.search += (a.search ? "&" : "") + param;
                return a.href;
            }
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

(function (d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s);
    js.id = id;
    js.src = 'https://connect.facebook.net/vi_VN/sdk/xfbml.customerchat.js';
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));


loadBlog();


