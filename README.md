# marvel-java-api

Os seguintes endpoints foram implementados, porém os parâmetros (filtros) não foram criados:

   - /v1/public/characters
   - /v1/public/characters/{characterId}
   - /v1/public/characters/{characterId}/comics
   - /v1/public/characters/{characterId}/events
   - /v1/public/characters/{characterId}/series
   - /v1/public/characters/{characterId}/stories

## Tecnologias Utilizadas
- Java 13
- Spring Boot
- Postgresql
- Maven

## Como Executar
- Clonar o projeto;
- Configurar as variáveis de ambiente POSTGRES_PASSWORD e POSTGRES_USERNAME para execução e inserção da modelagem no banco de dados;
- Executar a aplicação e acessar http://localhost:8080/swagger-ui.html 
