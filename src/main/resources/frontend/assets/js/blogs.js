//function clickJava() {
//    cateID = 1;
//    loadBlogsbyCate();
//}
//
//function clickBackend() {
//    cateID = 4;
//    loadBlogsbyCate();
//}
//function clickPython() {
//    cateID = 2;
//    loadBlogsbyCate();
//}
//function clickFrontend() {
//    cateID = 3;
//    loadBlogsbyCate();
//}
//function clickAI() {
//    cateID = 5;
//    loadBlogsbyCate();
//}
//function clickOther() {
//    cateID = 6;
//    loadBlogsbyCate();
//}
//
//function clickAll() {
//    loadBlogs();
//}
//
//// switch(expression) {
////     case 1:
////       // code block
////       break;
////     case y:
////       // code block
////       break;
////     default:
////       // code block
////   }
//
//function loadBlogs() {
//    // var output = document.getElementById('output');
//    // var products = []
//    $.ajax({
//        url: 'http://localhost:8090/getBlogs', // url where to submit the request
//        type: "GET", // type of action POST || GET
//        contentType: "application/json",
//        dataType: 'json', // data type
//        //data: JSON.stringify(data),
//
//        success: function (result) {
//            // you can see the result from the console
//            // tab of the developer tools
//
//            for(let i = 1; i < result.length; i++){
//                // console.log(result[keys]);
//                // products.push(result[keys]);
//                $('#output').append(`<div  class="col-lg-4 col-md-6 grid-item mb-30 ">
//                <div class="courses-item mb-30">
//                    <div class="img-part">
//                        <a class="link-img" href=""> <img class="img-part1" style="display: block;
//                            max-width:200px;
//                            max-height:300px;
//                            width: auto;
//                            height: auto;" src="" alt=""></a>
//                    </div>
//                    <div  class="content-part">
//                        <h4 class="title1"><a href=""></a></h4>
//                        <p class="des" style="margin: 0;"> </p>
//                        <div class="bottom-part">
//                            <div class="info-meta">
//                                <ul>
//                                    <li class="view"><i class="fa fa-eye"></i> </li>
//                                    <li class="like"><i class="fa fa-thumbs-up  ml-30"></i> </li>
//                                    <li class="date"><i class="date  ml-60"></i> </li>
//                                </ul>
//                            </div>
//                            <div class="btn-part">
//                                <a class="button-parth" href=""><i class="flaticon-right-arrow"></i></a>
//                            </div>
//                        </div>
//                    </div>
//                </div>
//            </div>`);
//
//            }
//            //   console.log(result)
//              for (let i = 0; i < result.length; i++) {
//                  document.getElementsByClassName("title1")[i].innerHTML = result[i].title;
//                  document.getElementsByClassName("des")[i].innerHTML = result[i].description;
//                  document.getElementsByClassName("img-part1")[i].setAttribute("src", result[i].avatar);
//                  document.getElementsByClassName("fa fa-eye")[i].innerHTML =" "+ result[i].viewPost;
//                  document.getElementsByClassName("fa fa-thumbs-up  ml-30")[i].innerHTML = " " +result[i].likePost;
//                  // document.getElementsByClassName("date  ml-60")[i].innerHTML = " " +result[i].time_posting.toString();
//                  document.getElementsByClassName("button-parth")[i].setAttribute("href", "../blog-detail.html?id=" +result[i].id );
//                  document.getElementsByClassName("link-img")[i].setAttribute("href", "../blog-detail.html?id=" +result[i].id );
//
//                  // document.getElementById("all").setAttribute("href", "https://m.facebook.com");
//              }
//
//        },
//
//    });
//
//
//}
//loadBlogs();
//function loadBlogsbyCate() {
//    $('#output').remove();
//    $('#add').append(`<div  id= "output"  class="row grid">`);
//    $.ajax({
//        url: 'http://localhost:8090/getBlogsByCate?CategoryID=' + cateID, // url where to submit the request
//        type: "GET", // type of action POST || GET
//        contentType: "application/json",
//        dataType: 'json', // data type
//        //data: JSON.stringify(data),
//        success: function (result) {
//            // you can see the result from the console
//            // tab of the developer tools
//            // console.log(pageNum + 1)
//            for(let i = 1; i < result.length; i++){
//                // console.log(result[keys]);
//                // products.push(result[keys]);
//                $('#output').append(`<div  class="col-lg-4 col-md-6 grid-item mb-30 ">
//                <div class="courses-item mb-30">
//                    <div class="img-part">
//                        <a class="link-img" href=""> <img class="img-part1" style="display: block;
//                            max-width:200px;
//                            max-height:300px;
//                            width: auto;
//                            height: auto;" src="" alt=""></a>
//                    </div>
//                    <div  class="content-part">
//                        <h4 class="title1"><a href=""></a></h4>
//                        <p class="des" style="margin: 0;"> </p>
//                        <div class="bottom-part">
//                            <div class="info-meta">
//                                <ul>
//                                    <li class="view"><i class="fa fa-eye"></i> </li>
//                                    <li class="like"><i class="fa fa-thumbs-up  ml-30"></i> </li>
//                                    <li class="date"><i class="date  ml-60"></i> </li>
//                                </ul>
//                            </div>
//                            <div class="btn-part">
//                                <a class="button-parth" href=""><i class="flaticon-right-arrow"></i></a>
//                            </div>
//                        </div>
//                    </div>
//                </div>
//            </div>`);
//
//            }
//              for (let i = 0; i < result.length; i++) {
//                  document.getElementsByClassName("title1")[i].innerHTML = result[i].title;
//                  document.getElementsByClassName("des")[i].innerHTML = result[i].description;
//                  document.getElementsByClassName("img-part1")[i].setAttribute("src", result[i].avatar);
//                  document.getElementsByClassName("fa fa-eye")[i].innerHTML =" "+ result[i].viewPost;
//                  document.getElementsByClassName("fa fa-thumbs-up  ml-30")[i].innerHTML = " " +result[i].likePost;
//                  // document.getElementsByClassName("date  ml-60")[i].innerHTML = " " +result[i].time_posting.toString();
//                  document.getElementsByClassName("button-parth")[i].setAttribute("href", "../blog-detail.html?id=" +result[i].id );
//                  document.getElementsByClassName("link-img")[i].setAttribute("href", "../blog-detail.html?id=" +result[i].id );
//
//                  // document.getElementById("all").setAttribute("href", "https://m.facebook.com");
//              }
//
//        },
//
//
//    });
//}
//
//
