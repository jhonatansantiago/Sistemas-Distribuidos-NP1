# SistemasDistribuidos
Questão 3

Faça um programa cliente/servidor multithread onde:
- O servidor funcione como um controle de estoque mantendo uma relação dos nomes dos produtos e
das quantidades.
- O cliente envia para o servidor um nome e uma quantidade. Se o valor for positivo indica entrada no
estoque e se for negativo indica saída do estoque.
- O servidor recebe os dados do cliente e procede da seguinte forma:
    - Se o nome do produto não existe ainda no cadastro, cadastrá-lo somente se for entrada no
    estoque. Caso contrário enviar mensagem para o cliente dizendo “produto inexistente”.
    - Se o produto existe realizar a operação de entrada ou saída no estoque, atualizando a quantidade
    e posteriormente enviando mensagem para o cliente dizendo “estoque atualizado e quantidade
    de _____”. Só realizar a operação de saída do estoque se a quantidade ficar maior ou igual a zero.
    Caso isto não seja possível, enviar mensagem para o cliente dizendo “não é possível fazer a saída
    de estoque – quantidade menor que o valor desejado”.
    - Se o nome do produto for “terminar” o servidor deve ser finalizado.


