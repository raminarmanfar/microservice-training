# Microservice Demo App.
## Hello world controller
* hello world get api
* hello world get api with custom message
## User controller
## Swagger
links to the swagger API:
* http://localhost:4000/api/api-docs
* http://localhost:4000/api/swagger-ui/index.html

### Accept xml
In order to get results in the XML format, send your request with the header: Accept: application/xml

### Accept language
Just add Accept-language: your-language (en, de, tr, fa) in the header of your request.
* Request-URI: http://localhost:4000/api/hello-world/i18n/ramin
* If no accept-language added en will be used by default.
