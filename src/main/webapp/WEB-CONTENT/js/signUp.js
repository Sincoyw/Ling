/**
 * Created by heaven on 16-12-24.
 */

function checkEmailExistOnClick(event) {
    var email = document.getElementById("inputSignUpEmail").value;
    if ("" !== email) {
        var xmlHttpRequest = new XMLHttpRequest();
        xmlHttpRequest.onreadystatechange = function (progressEvent) {
            if (this.readyState === 4 && this.status === 200) {
                console.log("response:" + this.responseText);
            }
        };
        xmlHttpRequest.open("GET", "/singUp/emailExistCheck?email=" + email, true);
        xmlHttpRequest.send();
        xmlHttpRequest = null;
    }
}