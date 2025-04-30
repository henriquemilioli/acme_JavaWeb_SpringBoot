1) Abra o MySQL Workbench, conecte-se à instância 'Infnet' (usuário: root).
2) Execute o script create_tables.sql para criar o schema e tabelas.
3) Execute o script insert_data.sql para inserir registros de teste.
4) Na IDE, rode o Tomcat Local; o Hibernate criará/atualizará o schema.
5) Para testar exportação CSV, acesse /cotacao/export?produtoId={id}.
