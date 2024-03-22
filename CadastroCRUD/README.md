CRUD CADASTRO DE PESSOAS UTILIZANDO JAVA

Este é um projeto CRUD (Create, Read, Update, Delete) de cadastro de pessoas desenvolvido em Java, utilizando o Maven como gerenciador de build e dependências. O Maven é escolhido por sua capacidade de configurar as dependências dos projetos através do arquivo pom.xml, o que facilita a gestão e o compartilhamento de projetos Java.

TECNOLOGIAS UTILIZADAS

Maven: Gerenciador de build e dependências.
JUnit: Framework de testes unitários.
javax.servlet: API para criar aplicativos web em Java.
Hibernate: Framework de mapeamento objeto-relacional (ORM).
javax.faces (JSF): Framework de interface de usuário para aplicativos web Java.
Jakarta: Especificações padrão para tecnologias Java EE.
PostgreSQL: Banco de dados utilizado.
Tomcat: Servidor web e container Servlet utilizado.
Maven Plugins: Plugins utilizados para compilar, testar e empacotar o projeto.
 
ARQUITETURA

O projeto utiliza o padrão arquitetural MVC (Model-View-Controller) para melhor organização:
DAO (Data Access Object): Classes responsáveis pela interação com o banco de dados.
Controller: Classes que recebem e processam as requisições, chamando as classes adequadas.
Model: Classes que representam as entidades do sistema, como Pessoa e Endereço.
Beans: Classes que servem como modelos de dados para as páginas JSF, permitindo a ligação entre a
interface e a lógica de negócios.
JPA Utils: Classe para configuração e gerenciamento do JPA (Java Persistence API).

CONFIGURAÇÕES

persistence.xml: Arquivo de configuração do Hibernate com as informações de conexão com o banco de
dados PostgreSQL.
faces-config.xml: Arquivo de configuração do JSF, onde são definidas as configurações de navegação e
mapeamentos de beans.
web.xml: Arquivo de configuração do webapp, onde são configurados servlets, filtros, listeners, etc.

INTERFACES

index.html: Página inicial com botões para acessar a página de cadastro e consulta.
consulta.html: Página para listar, editar e excluir registros de pessoas.
cadastro.html: Página para cadastrar novas pessoas, incluindo informações de pessoa e endereço.

OBSERVAÇÕES

O projeto utiliza o framework JSF (JavaServer Faces) para o desenvolvimento das interfaces.
Os comentários no código estão presentes apenas onde necessário, seguindo uma abordagem de arquitetura limpa
para manter o código o mais claro possível.
Para compilar e executar o projeto, pode-se utilizar o servidor Tomcat.

DOCKER

Um arquivo Dockerfile está incluso no projeto para facilitar a criação de uma imagem Docker chamada
cadastro_crud_img. Este Dockerfile contém as instruções para configurar o ambiente do projeto e criar a imagem
Docker pronta para ser executada.