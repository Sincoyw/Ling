/**
 * Created by heaven on 16-12-24.
 */

document.getElementById("buttonCheck").onclick = checkEmailExistOnClick;

function checkEmailExistOnClick(event) {
    var email = document.getElementById("inputSignUpEmail").value;
    if ("" !== email) {
        var xmlHttpRequest = new XMLHttpRequest();
        xmlHttpRequest.onreadystatechange = function (progressEvent) {
            if (this.readyState === 4 && this.status === 200) {
                if ("false" === this.responseText) {
                    event.target.innerText = "not exist";
                } else {
                    event.target.innerText = "exist";
                }
            }
        };
        xmlHttpRequest.open("GET", "/singUp/emailExistCheck?email=" + email, true);
        xmlHttpRequest.send();
        xmlHttpRequest = null;
    }
}