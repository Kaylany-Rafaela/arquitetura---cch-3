import java.util.Stack;

// Memento: armazena o estado do editor
class Memento {
    private final String estado;

    public Memento(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}

// Originator: editor de texto
class EditorTexto {
    private String conteudo = "";

    public void digitar(String texto) {
        conteudo += texto;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void restaurar(Memento memento) {
        this.conteudo = memento.getEstado();
    }

    public Memento salvar() {
        return new Memento(conteudo);
    }
}

// Caretaker: gerencia os mementos (histórico de versões)
class Historico {
    private final Stack<Memento> historico = new Stack<>();

    public void salvarEstado(Memento memento) {
        historico.push(memento);
    }

    public Memento desfazer() {
        if (!historico.isEmpty()) {
            return historico.pop();
        }
        return null;
    }
}

