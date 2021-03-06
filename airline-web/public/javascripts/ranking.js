function showRankingCanvas() {
	setActiveDiv($("#rankingCanvas"))
	highlightTab($('#rankingCanvasTab'))
	
	loadRanking()
}

function loadRanking() {
	var airlineId = activeAirline ? activeAirline.id : null
	$('#rankingCanvas .table').hide() //hide all tables until they are loaded
	$.ajax({
		type: 'GET',
		url: "rankings",
	    contentType: 'application/json; charset=utf-8',
	    dataType: 'json',
	    success: function(allRankings) {
	    	$.each(allRankings, function(rankingType, rankings) {
	    		updateRankingTable(rankingType, rankings)
	    	})
	    	$('#rankingCanvas .table').fadeIn(200)
	    },
	    error: function(jqXHR, textStatus, errorThrown) {
            console.log(JSON.stringify(jqXHR));
            console.log("AJAX error: " + textStatus + ' : ' + errorThrown);
	    }
	});
}

function updateRankingTable(rankingType, rankings) {
	//locate which table
	var rankingTable;
	if (rankingType == "PASSENGER") {
		rankingTable = $('#passengerRank')
	} else if (rankingType == "PASSENGER_MILE") {
		rankingTable = $('#passengerMileRank')
	} else if (rankingType == "REPUTATION") {
		rankingTable = $('#reputationRank')
	} else if (rankingType == "SERVICE_QUALITY") {
		rankingTable = $('#serviceQualityRank')
	} else if (rankingType == "LINK_COUNT") {
		rankingTable = $('#linkCountRank')
	} else {
		console.log("Unknown ranking type " + rankingType)
	}
	
	if (rankingTable) {
		rankingTable.children('.table-row').remove()
		var maxEntry = 20
		var currentAirlineRanking;
		$.each(rankings, function(index, ranking) {
			if (index < maxEntry) {
				rankingTable.append(getRankingRow(ranking))
			}
			if (activeAirline && ranking.airlineId == activeAirline.id) {
				currentAirlineRanking = ranking
			}
		})
		
		if (currentAirlineRanking) {
			rankingTable.append(getDividerRow())
			rankingTable.append(getRankingRow(currentAirlineRanking)) //lastly append a row of current airline
		}
		
	}
}

function getRankingRow(ranking) {
	var row = $("<div class='table-row'></div>")
	row.append("<div class='cell'>" + ranking.rank + "</div>")
	row.append("<div class='cell'>" + getMovementLabel(ranking.movement) + "</div>")
	row.append("<div class='cell'>" + getAirlineLogoImg(ranking.airlineId) + ranking.airlineName + "</div>")
	row.append("<div class='cell' style='text-align: right;'>" + ranking.rankedValue + "</div>")
	
	
	return row
}

function getDividerRow() {
	var row = $("<div class='table-row'></div>")
	row.append("<div class='cell' style='border-top: 1px solid #6093e7;'></div>")
	row.append("<div class='cell' style='border-top: 1px solid #6093e7;'></div>")
	row.append("<div class='cell' style='border-top: 1px solid #6093e7;'></div>")
	row.append("<div class='cell' style='border-top: 1px solid #6093e7;'></div>")
	
	return row
}


function getMovementLabel(movement) {
	if (movement == 0) {
		return '-'
	} else if (movement < 0) { //going up in ranking
		return "<img src='assets/images/icons/12px/arrow-090.png'/>" + movement * -1
	} else {
		return "<img src='assets/images/icons/12px/arrow-270.png'/>" + movement
	}
}