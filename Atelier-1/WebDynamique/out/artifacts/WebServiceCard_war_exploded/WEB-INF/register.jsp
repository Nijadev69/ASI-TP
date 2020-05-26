<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Inscription</title>
    <link type="text/css" rel="stylesheet" href="../form.css" />
    <link rel="stylesheet" type="text/css" href="lib/Semantic-UI-CSS-master/semantic.min.css">

</head>
<body>
<div class="ui five column grid">
    <div class="row"></div>
    <div class="column"></div>
    <div class="column"></div>
    <div class="column">
        <form class="ui form" action="./register" method="POST">
            <h3 class="ui dividing header">Add Card</h3>
            <h4 class="${code} ? 'succes' : 'erreur'}">${resultat}</h4>
            <div class="field">
                <label>Name</label>
                <input id="name" type="text" name="name" placeholder="Name">
            </div>
            <div class="field">
                <label>Description</label>
                <input id="description" type="text" name="description" placeholder="Description">
            </div>
            <div class="field">
                <label>Image Url</label>
                <input id="imageUrl" type="text" name="imageUrl" placeholder="Image Url">
            </div>
            <div class="field">
                <label>Family</label>
                <input id="family" type="text" name="family" placeholder="Family">
            </div>
            <div class="field">
                <label>Hp</label>
                <input id="Hp" type="range" name="hp" placeholder="Hp" min="0" max="100" value="0" oninput="HpOutput.value = Hp.value">
                <output name="hpOutput" id="HpOutput">0</output>
            </div>
            <div class="field">
                <label>Energy</label>
                <input id="Energy" type="range" name="energy" placeholder="Energy" min="0" max="100" value="0" oninput="EnergyOutput.value = Energy.value">
                <output name="energyOutput" id="EnergyOutput">0</output>
            </div>
            <div class="field">
                <label>Attack</label>
                <input id="Attack" type="range" name="attack" placeholder="Attack" min="0" max="100" value="0" oninput="AttackOutput.value = Attack.value">
                <output name="attackOutput" id="AttackOutput">0</output>
            </div>
            <div class="field">
                <label>Defence</label>
                <input id="Defence" type="range" name="defence" placeholder="Defence" min="0" max="100" value="0" oninput="DefenceOutput.value = Defence.value">
                <output name="defenceOutput" id="DefenceOutput">0</output>
            </div>
            <button class="ui button" type="submit">Create card</button>
        </form>

    </div>

</div>
</body>
</html>