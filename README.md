# Ledger Wallet

`wallet` provide a http server to register all your transactions and retrieve a history per hour.

### Requirements

`java`
`springboot`
`docker`

HTTP server default port `:8080`, it may not start if this port is already affected.
You can change this setting in `application.properties`

### Usage example

- Find json collection in the project path `/walletApp/com.postman_collection.json`

## Example curl

```sh
# Create wallet
curl -k -X POST 'http://localhost:8080/api/v1/wallet'
# response would be a walledId 

# Add new transactions
curl -k -X POST 'http://localhost:8080/api/v1/wallet/transaction' -d '{
	"walletId": "4d6295ce-5aec-4dda-8aa4-86f8ea20e11f",
    "dateTime": "2019-10-05T15:00:00+00:00",
    "amount": 400.0
}'

curl -k -X POST 'http://localhost:8080/api/v1/wallet/transaction' -d '{
	"walletId": "4d6295ce-5aec-4dda-8aa4-86f8ea20e11f",
    "dateTime": "2019-10-05T16:00:00+00:00",
    "amount": 402.0
}'

curl -k -X POST 'http://localhost:8080/api/v1/wallet/transaction' -d '{
	"walletId": "4d6295ce-5aec-4dda-8aa4-86f8ea20e11f",
    "dateTime": "2019-10-05T17:00:00+00:00",
    "amount": 40.0
}'

# Fetch wallet history
curl -k -X POST 'http://localhost:8080/api/v1/wallet/history' -d '{
	"walletId": "4d6295ce-5aec-4dda-8aa4-86f8ea20e11f",
    "startDateTime": "2019-10-05T13:00:00+00:00",
    "endDateTime": "2019-10-05T17:00:00+00:00"
}'

```

