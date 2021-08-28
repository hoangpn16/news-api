//var pageNum = 0;
//var number = pageNum+1;
//document.getElementById('clickNext').onclick = function () {
//    pageNum++;
//    number++;
//    console.log(pageNum);
//    // document.getElementById('clickNext').setAttribute("href", "/news.html?pagenum=" + pageNum);
//    loadPage();
//
//    // break;
//};
//
//document.getElementById('clickPrevious').onclick = function () {
//    pageNum--;
//    console.log(pageNum);
//    // document.getElementById('clickNext').setAttribute("href", "/news.html?pagenum=" + pageNum);
//    loadPage();
//    // break;
//};
//
//function loadPage() {
//
//    $.ajax({
//        url: 'https://news.plusplus.vn/news/getdata?pageNum=' + pageNum, // url where to submit the request
//        type: "GET", // type of action POST || GET
//        contentType: "application/json",
//        dataType: 'json', // data type
//        //data: JSON.stringify(data),
//        success: function (result) {
//            // you can see the result from the console
//            // tab of the developer tools
//            console.log(result)
//            for (let i = 0; i < result.length; i++) {
//                // console.log(pageNum);
//                // console.log(result);
//                document.getElementsByClassName("title")[i].innerHTML = result[i].title;
//                document.getElementsByClassName("blog-date")[i].innerHTML = result[i].timePosting;
//                document.getElementsByClassName("author")[i].innerHTML = result[i].author;
//                document.getElementsByClassName("blog-desc")[i].innerHTML = result[i].description;
//                var oImg = document.getElementsByClassName("blog-img1")[i].setAttribute("src", result[i].avatar);
//                var link = document.getElementsByClassName("blog-btn")[i];
//                link.setAttribute("href", "/news-detail.html?id=" + result[i].id);
//                var linkiOmg = document.getElementsByClassName("link-img")[i];
//                linkiOmg.setAttribute("href", "/news-detail.html?id=" + result[i].id);
//                document.getElementsByClassName("title")[i].setAttribute("href", "/news-detail.html?id="+ result[i].id);
//            }
//            var addParam = function (url, param, value) {
//                param = encodeURIComponent(param);
//                var a = document.createElement('a');
//                param += (value ? "=" + encodeURIComponent(value) : "");
//                a.href = url;
//                a.search += (a.search ? "&" : "") + param;
//                return a.href;
//            }
//        },
//        error: function (xhr, resp, text) {
//            console.log(xhr, resp, text);
//        }
//
//    });
//    $.ajax({
//        url: 'https://news.plusplus.vn/news/getdata?pageNum='+number, // url where to submit the request
//        type: "GET", // type of action POST || GET
//        contentType: "application/json",
//        dataType: 'json', // data type
//        //data: JSON.stringify(data),
//        success: function (result) {
//            // you can see the result from the console
//            // tab of the developer tools
//            // console.log(pageNum + 1)
//            console.log(result)
//            for (let i = 0; i < result.length; i++) {
//                document.getElementsByClassName("title-recents")[i].innerHTML = result[i].title;
//                document.getElementsByClassName("title-recents")[i].setAttribute("href", "/news-detail.html?id="+ result[i].id);
//            }
//            var addParam = function (url, param, value) {
//                param = encodeURIComponent(param);
//                var a = document.createElement('a');
//                param += (value ? "=" + encodeURIComponent(value) : "");
//                a.href = url;
//                a.search += (a.search ? "&" : "") + param;
//                return a.href;
//            }
//        },
//        error: function (xhr, resp, text) {
//            console.log(xhr, resp, text);
//        }
//
//    });
//
//}
//
//window.fbAsyncInit = function () {
//    FB.init({
//        appId: '481256309709126',
//        autoLogAppEvents: true,
//        xfbml: true,
//        version: 'v2.11'
//    });
//};
//
//(function (d, s, id) {
//    var js, fjs = d.getElementsByTagName(s)[0];
//    if (d.getElementById(id)) return;
//    js = d.createElement(s);
//    js.id = id;
//    js.src = 'https://connect.facebook.net/vi_VN/sdk/xfbml.customerchat.js';
//    fjs.parentNode.insertBefore(js, fjs);
//}(document, 'script', 'facebook-jssdk'));
//
//
//loadPage();
//
//
