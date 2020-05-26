$('#cardFamilyImgId')[0].src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/DC_Comics_logo.png/280px-DC_Comics_logo.png";
$('#cardFamilyNameId')[0].innerText="DC comics";
$('#cardImgId')[0].src="http://www.guinnessworldrecords.com/images/superlative/superheroes/GWR-Superheroes-SUPERMAN.svg";
$('#cardNameId')[0].innerText="SUPERMAN";
$('#cardDescriptionId')[0].innerText="The origin story of Superman relates that he was born Kal-El on the planet Krypton, before being rocketed to Earth as an infant by his scientist father Jor-El, moments before Krypton's destruction. Discovered and adopted by a farm couple from Kansas, the child is raised as Clark Kent and imbued with a strong moral compass. Early in his childhood, he displays various superhuman abilities, which, upon reaching maturity, he resolves to use for the benefit of humanity through a 'Superman' identity.";
$('#cardHPId')[0].innerText="50 HP";
$('#cardEnergyId')[0].innerText="100 Energy";
$('#cardAttackId')[0].innerText="17 Attack";
$('#cardDefenceId')[0].innerText="80 Defence";

var urlAPI = "/rest/servicescard/find";

function searchCard() {
    var name = $('#card-name').val();

    $.ajax({
        url: urlAPI,
        type: "GET",
        data: {
            name: name,
        },
        headers: {
            'Accept':'application/json',
            'Content-Type':'application/json'
        },
        success: function(data, status){
            $('#cardFamilyImgId')[0].src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/DC_Comics_logo.png/280px-DC_Comics_logo.png";
            $('#cardFamilyNameId')[0].innerText=data.family;
            $('#cardImgId')[0].src=data.imgUrl;
            $('#cardNameId')[0].innerText=data.name;
            $('#cardDescriptionId')[0].innerText=data.description;
            $('#cardHPId')[0].innerText=data.hp + " HP";
            $('#cardEnergyId')[0].innerText=data.energy + " Energy";
            $('#cardAttackId')[0].innerText=data.attack + " Attack";
            $('#cardDefenceId')[0].innerText=data.defence + " Defence";
        }
    });
}

$(document).ready(function() {
    $("#search-form").submit(function(event) {
        searchCard();
    });
});
