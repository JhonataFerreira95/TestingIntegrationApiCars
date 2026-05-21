## Nota

- Rode no `bash` o testing para o `maven`:

    ```bash

        ./mvnw verify -Dspring.profiles.active=test

    ```

- Resumo dos testes:

    - `deveSalvarCarroComSucesso`
    - `deveRejeitarCarroComPrecoNegativo`
    - `deveRejeitarCarroSemModelo`
    - `deveBuscarCarroPorIdExistente`
    - `deveRetornar404QuandoIdNaoExiste`
    - `deveListarTodosOsCarros`
    - `deveAtualizarCarroComSucesso`
    - `deveRetornar404AoAtualizarCarroInexistente`
    - `deveExcluirCarroComSucesso`
    - `deveListarCarrosInseridosViaSql` (Skipado) 
    - `saveDeveDelegarParaRepositoryERetornarCarroSalvo`
    - `updateDeveDelegarParaRepositoryERetornarCarroAtualizado`
    - `updateDevelancarExcecaoQuandoIdNaoExiste`
    - `deleteByIdDeveDelegarParaRepositoryComIdInformado`
    - `findByIdDeveRetornarCarroQuandoEncontrado`
    - `findByIdDeveRetornarOptionalVazioQuandoNaoEncontrado`
    - `findAllDeveRetornarListaDeCarrosDoRepository`

    > Testes executados localmente: 17, com 0 falha → 17 passaram, 1 skipado.
    ![testing](/assets/Screenshot_1.png)