# Notification for turn off power

It's project about turn off power in Ukraininan houses. People need system which can send notifications, when light can turn off. Yasno is analog for this, but Notification for turn off power (NFTOP) "have" electronic devices in powerplants. It check count of power in powerplants and send message to Telegram Bot. If result of devices are "small" - system send notification to users, where ligh can turn off.

## Languages and technologies of use
Prerequisites: 
- **Java** - API
- **Angular** - Front-End
- **Python** - Telegram Bot
- **PostgreSQL** - database
- **Docker** - run local database

## Installation

1. Clone the repository:
```
git clone https://github.com/kor-nicholas/NotificationForTurnOffPower
```

2. Install the required Python packages:
```
cd NotificationForTurnOffPowerBot
```
```
pip install -r requirements.txt
```

3. Set up configuration:
    - Set up API:
        Add information about database in NotificationForTurnOffPower/NotificationForTurnOffPowerAPI/src/main/resources/application.properties: 
        - spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
        - spring.datasource.username=postgres
        - spring.datasource.password=myPassword
    - Set up Telegram Bot:
        Add .env file and write (without **"**):
        - BOT_TOKEN = your token from BotFather
        - ADMINS = 123456789,123456789

## Usage

1. Start container with local PostgreSQL
```
docker run --name psql-container -p 5432:5432 -e POSTGRES_PASSWORD=myPassword -d postgres
```
- --name psql-container - official name of PosgreSQL container
- -p 5432:5432 - port for PosgreSQL
- -e POSTGRES_PASSWORD=myPassword - set up pass for local PosgreSQL database (use to set up API)
- -d postgres - set up username for local PosgreSQL database (use to set up API)

2. Start API: Open NotificationForTurnOffPowerAPI project in Intellij IDEA or other IDEA and run project
After compilling ypur project starts on http://localhost:8080

3. Start Telegram Bot:
Open new terminal and write:
```
cd NotificationForTurnOffPowerBot
python app.py
```

4. Start Angular project:
Open new terminal and write:
```
cd NotificationForTurnOffPowerAngular
ng serve
```
After compilling your project starts on http://localhost:4200

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please create an issue or submit a pull request.





 
