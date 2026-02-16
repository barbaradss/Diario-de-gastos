public class Gasto {
    private String descricao;
    private String categoria;
    private double valor;
    private String data;

    public Gasto( String descricao, String categoria, double valor, String data){
        this.descricao = descricao;
        this.categoria = categoria;
        this.valor = valor;
        this.data = data;
    }

    public String getDescricao(){
        return descricao;
    }

    public String getCategoria(){
        return categoria;
    }

    public double getValor(){
        return valor;
    }

    public String getData(){
        return data;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    public void setValor(double valor){
        this.valor = valor;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Descrição: " + descricao +
                " | Categoria: " + categoria +
                " | Valor: " + valor +
                " | Data: " + data;
    }

}
