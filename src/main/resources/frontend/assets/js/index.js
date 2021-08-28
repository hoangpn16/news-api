function indexNews() {
    $.ajax({
        url: 'https://news.plusplus.vn/news/getdata?pageNum=0', // url where to submit the request
        type: "GET", // type of action POST || GET
        contentType: "application/json",
        dataType: 'json', // data type
        //data: JSON.stringify(data),
        success: function (result) {
            // you can see the result from the console
            // tab of the developer tools
            console.log(result)
            for (let i = 0; i < result.length; i++) {
                document.getElementsByClassName("title1")[i].innerHTML = result[i].title;
                document.getElementsByClassName("img-part1")[i].setAttribute("src", result[i].avatar);
                var linkiOmg = document.getElementsByClassName("link-img")[i];
                linkiOmg.setAttribute("href", "/news-detail.html?id=" + result[i].id);
                document.getElementsByClassName("title1")[i].setAttribute("href", "/news-detail.html?id=" + result[i].id);
                
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
indexNews();