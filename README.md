# Sistema-Acoes
Projeto final da disciplina de JEE no curso de Arquitetura de Software

O sistema trata de forma simples a compra de ações por pessoas físicas.
- Uma Empresa possui um número limitado de ações para serem vendidas;
- As Empresas podem emitir novas ações porém não podemos diminuir o número de ações atuais;
- Cada ação pode pertencer a somente um Comprador;
- Uma Ação deve possuir a informação de quando foi comprada e de qual seu valor inicial e atual, juntamente das informações do seu Comprador;
- Um Comprador pode possuir várias Ações;
- O sistema precisa tratar de forma assíncrona a compra e venda das Ações;
- Durante uma compra ou venda, seu Comprador antigo e o novo precisam receber um email com a informação adequada sobre a operação;

Para simular o projeto é preciso:

Iniciar Docker MongoDB

```
docker run -p 27017:27017 --name mongodb -d mongo
```

Documentação dos métodos da API

```
http://localhost:8080/swagger-ui.html
```
Configurar o email e senha no arquivo EmailSender.java

```
final String fromEmail = "******";
final String password = "*********";
```


OBS: Para o envio do email de forma assíncrona, foi implementado uma thread separada ao invés de uma fila de mensagens.
