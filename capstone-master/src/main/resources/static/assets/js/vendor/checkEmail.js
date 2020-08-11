
$(document).ready(function () {
    // set initially button state hidden
    $("#btn").hide();
    // use keyup event on email field
    $("#email").keyup(function () {
        if (validateEmail()) {
// if the email is validated
// set input email border green
            $("#email").css("border", "2px solid green");
            // and set label 
                        $("#emailMsg").html("<p class='text-success'>Email hợp lệ</p>");
        } else {
            // if the email is not validated
            // set border red
            $("#email").css("border", "2px solid red");
            $("#emailMsg").html("<p class='text-danger'>Hãy nhập đúng email</p>");
        }
        buttonState();
    });
    // use keyup event on password
    $("#pass").keyup(function () {
        // check
        if (validatePassword()) {
// set input password border green
            $("#pass").css("border", "2px solid green");
            //set passMsg 
            $("#passMsg").html("<p class='text-success'>Password validated</p>");
        } else {
            // set input password border red
            $("#pass").css("border", "2px solid red");
            //set passMsg 
            $("#passMsg").html("<p class='text-danger'>Password not valid</p>");
        }
        buttonState();
    });
});

function buttonState() {
    if (validateEmail() && validatePassword()) {
// if the both email and password are validate
// then button should show visible
        $("#btn").show();
    } else {
        // if both email and pasword are not validated
        // button state should hidden
        $("#btn").hide();
    }
}
function validateEmail() {
    // get value of input email
    var email = $("#email").val();
    // use reular expression
    var reg = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
    if (reg.test(email)) {
        return true;
    } else {
        return false;
    }

}
function validatePassword() {
    //get input password value
    var pass = $("#pass").val();
    // check it s length
    if (pass.length > 7) {
        return true;
    } else {
        return false;
    }

}
