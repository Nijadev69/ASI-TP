var cards;
var imgUrlFamily = "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/DC_Comics_logo.png/280px-DC_Comics_logo.png";
var selectedCard;

$(document ).ready(function(){
    var urlAPI = "/cards/" + JSON.parse(sessionStorage.getItem('user')).id + "/list";

    $.ajax({
        url: urlAPI,
        type: "GET",
        headers: {
            'Accept':'application/json',
            'Content-Type':'application/json'
        },
        success: function(data, status){
            data.forEach(function(card) {
                cards = data;
                addCardToList(imgUrlFamily, card.family, card.imgUrl, card.name, card. description, card.hp, card.energy, card.attack, card.defence, 100);
            });
        }
    });
});




function fillCurrentCard(imgUrlFamily,familyName,imgUrl,name,description,hp,energy,attack,defence,price){
    //FILL THE CURRENT CARD
    $('#cardFamilyImgId')[0].src=imgUrlFamily;
    $('#cardFamilyNameId')[0].innerText=familyName;
    $('#cardImgId')[0].src=imgUrl;
    $('#cardNameId')[0].innerText=name;
    $('#cardDescriptionId')[0].innerText=description;
    $('#cardHPId')[0].innerText=hp+" HP";
    $('#cardEnergyId')[0].innerText=energy+" Energy";
    $('#cardAttackId')[0].innerText=attack+" Attack";
    $('#cardDefenceId')[0].innerText=defence+" Defence";
    $('#cardPriceId')[0].innerText=price+" $";
};

function changeSelectedCard(name) {
    selectedCard = name;
    cards.forEach(function(card) {
       if(card.name == name) {
           fillCurrentCard(imgUrlFamily, card.family, card.imgUrl, card.name, card.description, card.hp, card.energy, card.attack, card.defence, 100);
       }
    });
}

function addCardToList(imgUrlFamily,familyName,imgUrl,name,description,hp,energy,attack,defence,price){

    content="\
    <td> \
    <img  class='ui avatar image' src='"+imgUrl+"'> <span>"+name+" </span> \
   </td> \
    <td>"+description+"</td> \
    <td>"+familyName+"</td> \
    <td>"+hp+"</td> \
    <td>"+energy+"</td> \
    <td>"+attack+"</td> \
    <td>"+defence+"</td> \
    <td>"+price+"$</td>\
    <td>\
        <div class='ui vertical animated button' onclick=\"changeSelectedCard('" + name + "')\" tabindex='0'>\
            <div class='hidden content'>Sell</div>\
    <div class='visible content'>\
        <i class='shop icon'></i>\
    </div>\
    </div>\
    </td>";

    $('#cardListId tr:last').after('<tr>'+content+'</tr>');
};

function putCardOnSale() {
    var urlAPI = "/cards/sell/" + selectedCard;

    $.ajax({
        url: urlAPI,
        type: "PATCH",
        headers: {
            'Accept':'application/json',
            'Content-Type':'application/json'
        },
        success: function(data, status){
            alert('Carte mise en vente');
        }
    });
}