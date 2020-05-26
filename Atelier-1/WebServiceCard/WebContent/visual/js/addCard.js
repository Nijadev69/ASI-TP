var urlAPI = "/rest/servicescard/add";

$(document).ready(function() {
    $("#add-card-form").submit(function(event) {
        event.preventDefault();

        var name = $('#name').val();
        var description = $('#description').val();
        var family = $('#family').val();
        var hp = $('#Hp').val();
        var energy = $('#energy').val();
        var attack = $('#attack').val();
        var defense = $('#defense').val();
        var imgUrl = $('#imageUrl').val();

        $.ajax({
            url: urlAPI,
            type: "POST",
            data: JSON.stringify({
                name: name,
                description: description,
                family: family,
                hp: hp,
                energy: energy,
                attack: attack,
                defence: defense,
                imgUrl: imgUrl
            }),
            headers: {
                'Accept':'application/json',
                'Content-Type':'application/json'
            },
            success: function(data, status){
                console.log(data);
            }
        });
    });
});
