# ChestShopLogger
With ChestShopLogger you can log all your ChestShops into a MySQL database.
That database is searchable by players in-game, and can be used to find available shops and their prices.

The transaction data is also logged into the database, and can be used by developers; for example, in a web interface.

## Acknowledgements
- @[ColorizedMind](https://github.com/ColorizedMind)
- @[frdmn](https://github.com/frdmn)
- @Henning Storck

## Features
* Log each ChestShop into the database
* Log transactions into the database
* Delete logged ChestShops (and the related transactions), after they were removed from the map
* Search through the database in-game through the command `/shop`

## Installation
1. Make sure, that the ChestShop plugin is running on your server
2. Upload the plugin files into your plugins directory
3. Restart your server / load the plugin
4. Enter your MySQL access data into the `config.yml`
5. Restart your server / reload the plugin
6. Recreate every ChestShop to initialize them

## Permissions
Permission | Purpose | Default
--- | --- | ---
`chestshoplogger.tp` | Allows a player to teleport to a specific shop | _none_
`chestshoplogger.coords` | Allows a player to view the shop coords | _none_
`chestshoplogger.find` | Allows a player to search for shops | _none_

## Configuration
```yml
database:
  host: localhost
  port: 3306
  user: root
  password: ''
  database: cslogger
  ssl: 'false'
  tableVersion: 2
```

## License
[GPL 3.0](LICENSE)
