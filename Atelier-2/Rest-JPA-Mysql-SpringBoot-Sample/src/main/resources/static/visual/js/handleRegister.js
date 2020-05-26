
var urlApi = "http://localhost:8080/user";
$(document).ready(function() {
    $("#register-form").submit(function(event) {
        event.preventDefault();

        var name = $('#name').val();
        var surname = $('#surname').val();
        var password = $('#password').val();
        var rePassword = $('#rePassword').val();

        if(rePassword !== password){
            $('#error').css("color", "red");
            $('#error').html("Les mots de passe ne sont pas identiques.");
        } else {
            $.ajax({
                url: urlApi,
                type: "POST",
                data: JSON.stringify({
                    surname: surname,
                    name: name,
                    password: password,
                }),
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                success: function (data, status) {
                    console.log(data);
                    $('#error').css("color", "green");
                    $('#error').html("L'utilisateur a bien été enregistré en base de données.");
                    window.location.href = '/visual/login.html';
                }
            });
        }
    });
});