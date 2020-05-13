function get_company_list(){
    var xhr = new XMLHttpRequest();
    xhr.open("GET",
             "http://18.220.100.7:8887/Authorization/v1/getCompany",
             true);
    xhr.onload = function () {
//        if (this.readyState == 4 && this.status == 200) {
            console.log(xhr.responseText);
            console.log(typeof xhr.responseText);
//        }
    };
}
