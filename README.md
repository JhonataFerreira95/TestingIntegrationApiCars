## Nota

- Rode no `bash` o testing para o `maven`:

    ```bash

        ./mvnw verify -Dspring.profiles.active=test

    ```

- Resumo testings:

    > Testes executados localmente: 17, com 1 falha → 16 passaram. Teste com falha: CarroControllerIntegrationTest.deveListarCarrosInseridosViaSql.

    ![testing](/assets/Screenshot_1.png)