var urlAPI = "/auth/connect";

$(document).ready(function() {
    $("#connection-form").submit(function(event) {
        event.preventDefault();

        var surname = $('#surname').val();
        var password = $('#password').val();

        $.ajax({
            url: urlAPI,
            type: "POST",
            data: JSON.stringify({
                surname: surname,
                password: password,
            }),
            headers: {
                'Accept':'application/json',
                'Content-Type':'application/json'
            },
            success: function(data, status){
                if(data.error) {
                    alert(data.msg);
                } else {
                    sessionStorage.setItem('user', JSON.stringify({
                        'id': data.data.userId,
                        'surname': data.data.surname
                    }));
                    window.location.href = "cardHome.html";
                }
            }
        });
    });
});