$(document ).ready(function(){
    if(sessionStorage.getItem('user')) {
        let user = JSON.parse(sessionStorage.getItem('user'));
        $('#userNameId').text(user.surname);
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

