<h1 align="center">Projeto JavaEE - DM110</h1>

### :books: Descrição

<p>Projeto da disciplina DM110 - Desenvolvimento JavaEE </p>
<p>Trata-se de um projeto simples que se utiliza dos conhecimentos relacionados a Java EE adquiridos na disciplina DM110 da pós-graduação. A ideia principal é criar de forma concisa um serviço para realização de um CRUD completo de produtos no banco de dados HyperSQL, esse serviço conta com auditoria integral de todas as operações e chamadas realizadas ao decorrer da utilização. É válido ressaltar que as tabelas do banco de dados HyperSQL possuem o problema de lock, ou seja, somente um usuário pode acessar e manipular a tabela e o banco por vez.</p>

### :computer: Arquitetura geral do projeto

<p align="center">
    ![Arquitetura DM110png](https://github.com/user-attachments/assets/1e51dc61-d805-421b-8d44-450aa6b6301d)
</p>

#### :hammer_and_wrench: Recursos utilizados na construção
- [Eclipse IDE for Enterprise Java and Web Developers](https://www.eclipse.org/downloads/packages/)
- [JDK 17](https://www.oracle.com/java/technologies/downloads/#java17)
- [Wildfly](https://www.wildfly.org/)
- [Maven](https://maven.apache.org/index.html)
- [Lombok](https://projectlombok.org)
- [HyperSQL](http://hsqldb.org)
- [Postman](https://www.postman.com/)

#### :building_construction: Diagrama de classes UML do projeto

![DM110](https://github.com/user-attachments/assets/b35d1547-af9e-41d2-aa2d-1ffd036a8def)

#### :building_construction: Diagrama Entidade Relacionamento (DER) do banco de dados

![DM110_DERpng](https://github.com/user-attachments/assets/d0206a39-1ad2-4626-b1e7-f55137ade5b9)

<p>Para a tabela Product, tabela principal do banco de dados onde serão realizadas as operações, possui as seguintes definições para seus atributos:</p>

- code: Código de registro do produto(chave primária);
- name: Nome do produto;
- description: Breve descrição acerca do produto;
- price: Valor do produto;
- category: Categoria do produto (ex. Limpeza, Alimentação…).

<p>A tabela Audit é utilizada internamente pelo sistema para realizar toda a auditoria do sistema, permitindo rastrear os fluxos das operações realizadas. Ela possui as seguintes definições para seus atributos:</p>

- id: Código identificador do log registrado (chave primária);
- registerCode: Código do produto no qual está sendo realizada alguma operação (chave estrangeira);
- operation: Operação que foi realizada('Create','Update','Read','Delete');
- timestamp: Data e hora onde aconteceu a operação.
    
### :computer: Rotas disponíveis na API REST
<p>Esse sistema backend disponibiliza endpoints para utilização em outros sistemas, dessa forma acessando os endpoints você poderá manipular e trabalhar com as operações mais básicas relacionadas a estes produtos.</p>

<p>Todas as operações realizadas são auditadas, aumentando o nível de controle e maturidade da plataforma.</p>

<p>Abaixo se encontra a relação de endpoints, Método HTTP relacionado e descrição: </p>

| Endpoint |Metodo| Descrição |
|---|---|---|
| `/product` | POST |Utilizado para realizar a criação do(s) produto(s)|
| `/product` | GET |Utilizado para realizar a recuperação de todos produtos|
| `/product/{code}` | GET|Utilizado para realizar a recuperação de um produto especifico|
| `/product/{code}`|PUT |Utilizado para realizar a atualização de um produto especifico|
| `/product/{code}`| DELETE |Utilizado para realizar a remoção de um produto especifico|

## :gear: Autores

* **Flávio Henrique Madureira Bergamini** - [Flávio](https://github.com/flaviobergamini)
* **Gabriel Ilian Fonseca Barboza** - [Gabriel](https://github.com/G-ilian) 
