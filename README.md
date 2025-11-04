# Atividade_final_lorenzon

Todos os trabalhos deverão conter:
• Persistência de objetos utilizando alguma forma de persistir objetos, no mínimo serialização nativa do Java;
o Observar documentação da disciplina e estudos de caso de persistências;
• Uso de coleção ArrayList para armazenar dados;
o Observar exercício e código Biblioteca, além do código exemplo na pasta sintaxes do MAV;
• Abstrações em arquivos distintos, separados e organização de pacotes com característica de domínio;
o Observar material de DDD disponibilizado na disciplina;
o Observar material de SOLID, disponibilizado na disciplina;
• Aplicação de interfaces como contratos de comportamento (programação para implementação);
o Observar material de herança, disponibilizado na disciplina;
• Uso de herança e injeção para modelar as descendências de especializações naturais das interfaces e abstrações;
o Observar material de herança, disponibilizado na disciplina;
• Implementação de polimorfismo com sobrecarga, overide, coerção, subtipo e generics;
o Observar material de herança, disponibilizado na disciplina;
• Aplicar tratamento de exceções (quando e como usar trow, throws, try/catch/finally para evitar falhas não
tratadas);
o Criar suas próprias exceções;
o Observar material disponibilizado na disciplina;
• Buscar aplicação dos princípios SOLID e boas práticas de organização de código.
o O material SOLID é/foi apresentado em explanações em sala de aula e disponibilizado documentação no
material da disciplina;
• Minimizar profundidade e horizontalidade de código, aderindo a Object Calisthenics e Clean Code para
programação. Complexidade ciclomática: evitar métodos longos ou excessivamente aninhados;
o Manter métodos curtos e coesos. Métodos próximos de 100 linhas devem ser refatorados em funções
menores;
o O material destes princípios é/foi apresentado em explanações em sala de aula e disponibilizado
documentação no material da disciplina;
• Conhecer e observar possibilidade de implementar padrões de projetos para situações de construção, avaliando
encaixe de padrões: Singleton, Builder, Factory, Strategy e Observer.
o O material destes padrões é/foi apresentado em explanações em sala de aula e disponibilizado
documentação no material da disciplina;
• Encapsular de forma inteligente e prática, não são getters e setters que encapsulam;
• Não utilizar protected para atributos. Evitar o uso para métodos;
• Reduzir o uso de herança profunda e praticar a injeção por composição;
• Legibilidade do código, com nomenclaturas claras, comentários necessários ee eliminação de comentários
redundantes;
o Será avaliado o uso adequado de comentários: apenas quando forem necessários para explicar regras de
negócio, decisões de design ou documentação;
• Opcionalmente aplicar JavaDoc para documentar métodos e interfaces públicas;
• Codificar com o pensamento de capacidade de testabilidade individualizada de métodos, redução de
complexidade e padronização em geral do código;
• Uma classe de aplicação AppTester que demonstra por “menu” de opções as funcionalidades do sistema. Esta
aplicação deve seguir codificação enxuta, usando métodos static de segmentação de construção;
o Ferramentas Teclado e Video devem ser exploradas e utilizadas obrigatoriamente;
▪ Podem ser copiadas isoladamente para um projeto do zero, encaixados na sua estrutura.

o trabalho sera sobre um E-commerce de Roupas
Uma loja de roupas online precisa gerenciar clientes, produtos, carrinhos de compra e pedidos. O sistema deve
considerar categorias diferentes de produtos e permitir aplicar descontos ou promoções. Sugestão de entidades:
Produto, Cliente, Carrinho, Pedido;