var urlAPI = "/cards/all"
var cards;
var selectedCard;

$(document ).ready(function(){
    fillCurrentCard("https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/DC_Comics_logo.png/280px-DC_Comics_logo.png","DC comics","http://www.guinnessworldrecords.com/images/superlative/superheroes/GWR-Superheroes-SUPERMAN.svg","SUPERMAN","The origin story of Superman relates that he was born Kal-El on the planet Krypton, before being rocketed to Earth as an infant by his scientist father Jor-El, moments before Krypton's destruction. Discovered and adopted by a farm couple from Kansas, the child is raised as Clark Kent and imbued with a strong moral compass. Early in his childhood, he displays various superhuman abilities, which, upon reaching maturity, he resolves to use for the benefit of humanity through a 'Superman' identity.",50,100,17,8,100);

    $.ajax({
        url: urlAPI,
        type: "GET",
        headers: {
            'Accept':'application/json',
            'Content-Type':'application/json'
        },
        success: function(data, status){
            data.forEach(function(card){
                cards = data;
                if(card.onSale == true){
                    addCardToList("https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/DC_Comics_logo.png/280px-DC_Comics_logo.png",card.family,card.imgUrl,card.name,card.description,card.hp,card.energy,card.attack,card.defence,100);
                }
            })
        }
    });

    urlAPI = "/users/" + JSON.parse(sessionStorage.getItem('user')).id;
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
            fillCurrentCard(card.imgUrl, card.family, card.imgUrl, card.name, card.description, card.hp, card.energy, card.attack, card.defence, 100);
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
        <div class='ui vertical animated button' tabindex='0'>\
            <div class='hidden content' onclick=\"changeSelectedCard('" + name + "')\">Buy</div>\
        <div class='visible content'>\
            <i class='shop icon'></i>\
    </div>\
    </div>\
    </td>";
    
    $('#cardListId tr:last').after('<tr>'+content+'</tr>');
};

function buyCard(){
    $.ajax({
        url: "/cards/buy/" + selectedCard + "/" + JSON.parse(sessionStorage.getItem('user')).id,
        type: "PATCH",
        headers: {
            'Accept':'application/json',
            'Content-Type':'application/json'
        },
        success : function(response, textStatus, jqXhr) {
            console.log("Card Successfully Patched!");
            location.reload();
        },
    });
}