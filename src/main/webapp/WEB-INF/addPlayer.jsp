<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Player</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1>Add Player</h1>
    <form method="post" action="add-player">
        <div class="form-group">
            <label for="region">Region:</label>
            <input type="text" class="form-control ${not empty results['regionInvalid'] ? results['regionInvalid'] : ''}" id="region" name="region" value="">
            <span class="invalid-feedback">${not empty results['regionError'] ? results['regionError'] : ''}</span>
        </div>
        <div class="form-group">
            <label for="team">Team:</label>
            <input type="text" class="form-control ${not empty results['teamInvalid'] ? results['teamInvalid'] : ''}" id="team" name="team" value="">
            <span class="invalid-feedback">${not empty results['teamError'] ? results['teamError'] : ''}</span>
        </div>
        <div class="form-group">
            <label for="player">Player:</label>
            <input type="text" class="form-control ${not empty results['playerInvalid'] ? results['playerInvalid'] : ''}" id="player" name="player" value="">
            <span class="invalid-feedback">${not empty results['playerError'] ? results['playerError'] : ''}</span>
        </div>
        <div class="form-group">
            <label for="acs">ACS:</label>
            <input type="text" class="form-control ${not empty results['acsInvalid'] ? results['acsInvalid'] : ''}" id="acs" name="acs" value="">
            <span class="invalid-feedback">${not empty results['acsError'] ? results['acsError'] : ''}</span>
        </div>
        <div class="form-group">
            <label for="kd">Kill/Death Ratio:</label>
            <input type="text" class="form-control ${not empty results['kdInvalid'] ? results['kdInvalid'] : ''}" id="kd" name="kd" value="">
            <span class="invalid-feedback">${not empty results['kdError'] ? results['kdError'] : ''}</span>
        </div>
        <div class="form-group">
            <label for="kast">Kill/Death/Assist/Trade Ratio:</label>
            <input type="text" class="form-control ${not empty results['kastInvalid'] ? results['kastInvalid'] : ''}" id="kast" name="kast" value="">
            <span class="invalid-feedback">${not empty results['kdaError'] ? results['kdaError'] : ''}</span>
        </div>
        <div class="form-group">
            <label for="hs">Headshot %:</label>
            <input type="text" class="form-control ${not empty results['hsInvalid'] ? results['hsInvalid'] : ''}" id="hs" name="hs" value="">
            <span class="invalid-feedback">${not empty results['hsError'] ? results['hsError'] : ''}</span>
        </div>
        <div class="form-group">
            <label for="clutches">Clutches:</label>
            <input type="text" class="form-control ${not empty results['clutchesInvalid'] ? results['clutchesInvalid'] : ''}" id="clutches" name="clutches" value="">
            <span class="invalid-feedback">${not empty results['clutchesError'] ? results['clutchesError'] : ''}</span>
        </div>
        <div class="form-group">
            <label for="k">Kills:</label>
            <input type="text" class="form-control ${not empty results['kInvalid'] ? results['kInvalid'] : ''}" id="k" name="k" value="">
            <span class="invalid-feedback">${not empty results['kError'] ? results['kError'] : ''}</span>
        </div>
        <div class="form-group">
            <label for="d">Deaths:</label>
            <input type="text" class="form-control ${not empty results['dInvalid'] ? results['dInvalid'] : ''}" id="d" name="d" value="">
            <span class="invalid-feedback">${not empty results['dError'] ? results['dError'] : ''}</span>
        </div>
        <div class="form-group">
            <label for="a">Assists:</label>
            <input type="text" class="form-control ${not empty results['aInvalid'] ? results['aInvalid'] : ''}" id="a" name="a" value="">
            <span class="invalid-feedback">${not empty results['aError'] ? results['aError'] : ''}</span>
        </div>
        <div class="form-group">
            <label for="openingDuelWinRate">Opening Duel Win Rate:</label>
            <input type="text" class="form-control ${not empty results['openingDuelWinRateInvalid'] ? results['openingDuelWinRateInvalid'] : ''}" id="openingDuelWinRate" name="openingDuelWinRate" value="">
            <span class="invalid-feedback">${not empty results['openingDuelWinRateError'] ? results['openingDuelWinRateError'] : ''}</span>
        </div>

        <button class="w-100 btn btn-primary btn-lg" type="submit">Create new player</button>
    </form>
</div>
</div>
</body>
</html>
