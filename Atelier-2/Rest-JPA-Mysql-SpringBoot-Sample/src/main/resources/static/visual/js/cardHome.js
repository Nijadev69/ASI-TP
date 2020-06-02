$(document ).ready(function(){
    if(sessionStorage.getItem('user')) {
        let user = JSON.parse(sessionStorage.getItem('user'));
        $('#userNameId').text(user.surname);
    } else {
        window.location.href = '/visual/login.html';
    }

    $("#playButtonId").click(function(){
        alert("Play button clicked ");
    });
    $("#buyButtonId").click(function(){
        window.location.href = '/visual/cardOnSale.html';
    });    
    $("#sellButtonId").click(function(){
        window.location.href = '/visual/myCards.html';
    });

    var urlAPI = "/user/" + JSON.parse(sessionStorage.getItem('user')).id + '/money';

    $.ajax({
        url: urlAPI,
        type: "GET",
        success: function(data, status){
            $('#cash').text(data.data.money);
        }
    });
});

