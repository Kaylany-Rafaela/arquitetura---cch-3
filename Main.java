// Teste da aplicação
public class Main {
    public static void main(String[] args) {
        EditorTexto editor = new EditorTexto();
        Historico historico = new Historico();

        editor.digitar("Olá, ");
        historico.salvarEstado(editor.salvar());

        editor.digitar("mundo!");
        historico.salvarEstado(editor.salvar());

        System.out.println("Conteúdo atual: " + editor.getConteudo());

        // Desfazer uma vez
        editor.restaurar(historico.desfazer());
        System.out.println("Após desfazer: " + editor.getConteudo());

        // Desfazer novamente
        editor.restaurar(historico.desfazer());
        System.out.println("Após desfazer novamente: " + editor.getConteudo());
    }
}
