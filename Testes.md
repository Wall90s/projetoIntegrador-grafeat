## Primeiros Passos: 1 - Cadastrar Usuário
Devemos cadastrar um usuário, pois devido a implementação de Spring Security (um framework para Java, que provê autenticação, autorização e muitas outras funcionalidades) se torna obrigatório, por questões de segurança e proteção de dados. O usuário então deve inserir, nome, email, foto, localidade, data de nascimento (padrão americano yyyy-mm-dd ex: 1980/03/23) e tipo de pagamento (Pix, Saque)
- Obrigatórios: nome, usuario(email), senha, foto, tipo de pagamento
- Opcionais: localidade

Após inserir todas as informações essenciais, se for bem-sucedido irá aparecer *"201 Created"* e o id será criado automaticamente, único e intransferível.
Como mostra a prévia, a senha será codificada.

Se for malsucedido a mensagem *"400 Bad Request"* aparecerá, normalmente isso ocorre quando os elementos obrigatórios não estão sendo atendidos ou verifique se a senha possui o **mínimo de 8 caracteres**.

</br>

![cadastrarUsuario](https://user-images.githubusercontent.com/123910027/229010510-ec8d227d-3b89-4376-b961-c133e73b68d3.png)

## 2 - Logar Usuário

Depois do cadastro precisamos validar este login, onde o Vendedor deve inserir corretamente um email e senha (padrão, descriptografada) persistidos no banco de dados.

Se o sistema encontrar e aparecerá *”200 OK”*  e o token baseado no email e a senha (ex: Basic abcdefghijklmnopqrstuvwxyz) será gerado, válido por 30 minutos, após esse período é necessário outro login.

Caso o sistema não encontre o aparecerá *”404 Not Found”* o que significa que as informações não estão cadastradas no banco de dados, cadastre e tente novamente.

![logarUsuario](https://user-images.githubusercontent.com/123910027/229016452-b5f20910-67aa-4eea-8bcb-952ac759c4a3.png)

## 3 - Atualização de Usuário
Caso seja necessário, o Vendedor poderá alterar suas informações, basta inserir as informações que deseja alterar:

![atualizarUsuario](https://user-images.githubusercontent.com/123910027/229018900-4133cfb3-8386-46ab-b292-eeb4c935a811.png)

## 1 - Cadastrar Categoria: 

Devido ao relacionamento de classes, não podemos cadastrar um Produto sem antes adicionar uma categoria , pois o @OneToMany (Um para muitos) ou seja, uma categoria que possui muitos produtos, ao ser requisitada irá obrigatoriamente trazer produto junto com ela (relação bidimensional) e o mesmo acontece em produto como veremos mais a frente.

Insira um nome da categoria e uma descrição sobre ela, se for bem-secedido um id de categoria será gerado.

![adicionarCategoria](https://user-images.githubusercontent.com/123910027/229019662-c03d5ed2-b31c-470a-a2b7-0b79e2b8b6ed.png)

## 2 - Atualização de Categoria
Caso seja necessário, o sistema possibilitará a atualização de categoria:

![atualizarCategoria](https://user-images.githubusercontent.com/123910027/229020889-b4632e9e-11df-4e3c-a5f5-97a54d81c587.png)


## 1 - Cadastrar Produto

![adicionarProduto](https://user-images.githubusercontent.com/123910027/229021747-5bc5c197-ef93-4da0-bc02-84d88db9fe37.png)

