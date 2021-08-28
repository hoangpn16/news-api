//function loadBlogs() {
//
//    $.ajax({
//        url: 'http://localhost:8090/getBlogsByAuthor', // url where to submit the request
//        type: "GET", // type of action POST || GET
//        contentType: "application/json",
//        dataType: 'json', // data type
//        //data: JSON.stringify(data),
//        success: function (result) {
//            // you can see the result from the console
//            // tab of the developer tools
//            for (let i = 0; i < result.length; i++) {
//                document.getElementsByClassName("title1")[i].innerHTML = result[i].title;
//                document.getElementsByClassName("des")[i].innerHTML = result[i].description;
//                document.getElementsByClassName("img-part1")[i].setAttribute("src", result[i].avatar);
//                document.getElementsByClassName("fa fa-eye")[i].innerHTML =" "+ result[i].view;
//                document.getElementsByClassName("fa fa-thumbs-up  ml-30")[i].innerHTML = " " +result[i].like;
//                // document.getElementsByClassName("date  ml-60")[i].innerHTML = " " +result[i].time_posting.toString();
//                document.getElementsByClassName("button-parth")[i].setAttribute("href", "https://techmaster.vn/posts");
//                document.getElementsByClassName("link-img")[i].setAttribute("href", "https://facebook.com");
//                // document.getElementsByClassName("link-title")[i].setAttribute("href", "https://m.facebook.com");
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
//loadBlogs();