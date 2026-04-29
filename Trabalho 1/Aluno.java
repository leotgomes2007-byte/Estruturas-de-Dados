public class Aluno {
 
    public String Nome;
    public String Curso;
    public String Sexo;
    public int AnoIngresso;
 
    public Aluno(String nome, String curso, String sexo, int anoIngresso) {
        Nome = nome;
        Curso = curso;
        Sexo = sexo;
        AnoIngresso = anoIngresso;
    }
 
    public String getNome()        { return Nome; }
    public String getCurso()       { return Curso; }
    public String getSexo()        { return Sexo; }
    public int    getAnoIngresso() { return AnoIngresso; }
 
    // reescrevemos toString para exibir um objeto completo da classe
    @Override
    public String toString() {
        return "Aluno [Nome=" + Nome + ", Curso=" + Curso + ", Sexo=" + Sexo + ", AnoIngresso=" + AnoIngresso + "]";
    }
 
    // reescreve equals para definir o atributo identificador do aluno
    @Override
    public boolean equals(Object obj) {
        Aluno a = (Aluno) obj;
        return this.Nome.equals(a.Nome); // dois alunos são iguais se tiverem o mesmo nome
    }
}
