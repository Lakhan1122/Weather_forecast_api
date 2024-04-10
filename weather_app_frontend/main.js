function getForecastSummary() {
    var cityName = document.getElementById('cityName').value;
    fetch('http://localhost:8080/api/weather/forecast-summary?cityName=' + cityName, {
        headers: {
            'Authorization': 'Basic ' + btoa('user:user@1008'),
            'clientId': '13', // Your client ID
            'clientSecret': 'lakhan' // Your client secret
        }
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.text();
    })
    .then(data => {
        document.getElementById('summary').innerText = data;
    })
    .catch(error => {
        console.error('There was a problem with the fetch operation:', error);
    });
}

function getHourlyForecast() {
    var cityName = document.getElementById('cityName').value;
    

    fetch('https://weatherforecastapi-production.up.railway.app/api/weather/hourly-forecast?cityName=' + cityName, {
        headers: {
            'Authorization': 'Basic ' + btoa('user:user@1008'),
            'clientId': '13', // Your client ID
            'clientSecret': 'lakhan' // Your client secret
        }
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.text();
    })
    .then(data => {
        document.getElementById('summary').innerText = data;
    })
    .catch(error => {
        console.error('There was a problem with the fetch operation:', error);
    });
    

}
