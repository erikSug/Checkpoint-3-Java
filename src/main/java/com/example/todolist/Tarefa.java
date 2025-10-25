package com.example.todolist;

public class Tarefa {
    private String tarefaId;
    private String titulo;
    private String projeto;
    private String prioridade;
    private String data;
    private String responsavel;

    public Tarefa(String tarefaId, String titulo, String projeto, String prioridade, String data, String responsavel){
        this.tarefaId = tarefaId;
        this.titulo = titulo;
        this.projeto = projeto;
        this.prioridade = prioridade;
        this.data = data;
        this.responsavel = responsavel;
    }
    public String getTarefaId() {
        return tarefaId;
    }

    public void setTarefaId(String tarefaId) {
        this.tarefaId = tarefaId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getProjeto() {
        return projeto;
    }

    public void setProjeto(String projeto) {
        this.projeto = projeto;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

}
