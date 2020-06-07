$(document ).ready(function(){
    if(sessionStorage.getItem('user')) {
        let user = JSON.parse(sessionStorage.getItem('user'));
        $('#userNameId').text(user.surname);

         var urlAPI = "/users/" + JSON.parse(sessionStorage.getItem('user')).id;
        $.ajax({
            url: urlAPI,
            type: "GET",
            headers: {
                'Accept':'application/json',
                'Content-Type':'application/json'
            },
            success: function(data, status){
                $('#money-value').text(data.money + '$');
            }
        });

    } else {
        window.location.href = 'login.html';
    }

    $("#playButtonId").click(function(){
        alert("Play button clicked ");
        //TO DO
    });    
    $("#buyButtonId").click(function(){
        window.location.href = 'cardOnSale.html';
    });    
    $("#sellButtonId").click(function(){
        window.location.href = 'myCards.html';
    });    
});

