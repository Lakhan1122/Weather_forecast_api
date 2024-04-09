# Weather Forecast Application

## Overview
The Weather Forecast Application is a web-based tool that allows users to retrieve weather forecast summaries and hourly forecasts for specific cities.

### Deployment
The application is deployed and accessible at [https://weatherforecastapi-production.up.railway.app](https://weatherforecastapi-production.up.railway.app).

## Features
- **Forecast Summary:** Retrieve a summary of the weather forecast for a specific city.
- **Hourly Forecast:** Get detailed hourly weather forecasts for a specific city.

## Technologies Used
- **Frontend:** HTML, CSS, JavaScript
- **Backend:** Spring Boot
- **External APIs:** OpenWeatherMap API, RapidAPI

## Installation
1. Clone the repository:
   ```
   git clone https://github.com/Lakhan1122/weather-forecast.git
   ```
2. Navigate to the project directory:
   ```
   cd weather-forecast
   ```


## Usage
1. Start the backend server:
   ```
   // Assuming Maven is installed
   mvn spring-boot:run
   ```
2. Open the frontend in a web browser:
   ```
   // If running locally
   open index.html
   ```
3. Enter the city name and click on the respective buttons to retrieve the forecast summary and hourly forecast.

## Configuration
- **API Keys:** Obtain API keys for OpenWeatherMap API and RapidAPI and replace them in the respective configuration files (`application.properties`, `RapidAPIConfig.java`).
- **Server URL:** Update the backend server URL in the frontend JavaScript files (`main.js`) if deploying to a different server.

## Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgements
- Thanks to [OpenWeatherMap](https://openweathermap.org/) and [RapidAPI](https://rapidapi.com/) for providing weather data APIs.

