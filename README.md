# Thymeleaf Fragments Custom

## Maven

	mvn clean package

	java -jar target/thymeleaf-fragments-custom.jar

## Docker

	docker build -t thymeleaf-fragments-custom .

	docker run -it --rm -p 8080:8080 --name thymeleaf-fragments-custom thymeleaf-fragments-custom

### Redis Cache

Adicionei o Redis Cache ao Dashboard para controle da cor do sistema, lembrar de iniciar o redis localhost:6379, não coloquei no docker compose pois ele obriga e iniciar e finalizar aplicação e redis sempre ao mesmo tempo, deixei separado pois assim posso subir o redis, reiniciar a aplicação pra testar se o valor fica em cache e quando volta acompanho o log, por isso deixei manual

	docker run --name redis -p 6379:6379 -d redis

### Verificar logs do Redis

	docker exec -it redis redis-cli
	
	(redis) > GET layoutColor::color
	
	"\xac\xed\x00\x05t\x00\bw3-indigo"
	
	(redis) > monitor
	
	"GET" "layoutColor::color"
	"DEL" "layoutColor::color"
	"GET" "layoutColor::color"
	"SET" "layoutColor::color" "\xac\xed\x00\x05t\x00\bw3-green" "PX" "864000000"
	"GET" "layoutColor::color"
