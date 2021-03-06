package principal;

public class MesOrcamento {

    static boolean receita = false;
    static boolean despesa = true;

    int mes;

    //Receitas
    Rubrica salario1 = new Rubrica(false, "Salário 1", 8000);
    Rubrica salario2 = new Rubrica(false, "Salário 2", 7000);

    //Despesas
    Rubrica habitacao = new Rubrica(false, "Habitação", 1000);
    Rubrica saude = new Rubrica(false, "Saúde", 900);
    Rubrica transporte = new Rubrica(false, "Transporte", 800);
    Rubrica despesasPessoais = new Rubrica(false, "Despesas Pessoais", 700);
    Rubrica educacao = new Rubrica(false, "Educação", 600);
    Rubrica lazer = new Rubrica(false, "Lazer", 500);
    Rubrica outros = new Rubrica(false, "Outros", 400);

    static final int QTD_RUBRICAS_RECEITA = 2;
    static final int QTD_RUBRICAS_DESPESA = 7;

    Rubrica receitas[] = new Rubrica[QTD_RUBRICAS_RECEITA];

    Rubrica despesas[] = new Rubrica[QTD_RUBRICAS_DESPESA];

    public MesOrcamento(int m) {
        mes = m;

        receitas[0] = salario1;
        receitas[1] = salario2;

        despesas[0] = habitacao;
        despesas[1] = saude;
        despesas[2] = transporte;
        despesas[3] = despesasPessoais;
        despesas[4] = educacao;
        despesas[5] = lazer;
        despesas[6] = outros;
    }

    public int getQuantidadeRubricas(boolean tipoRubrica) {
        if (tipoRubrica == despesa)
            return despesas.length;

        return receitas.length;
    }

    public double getTotalRubricas(boolean tipoRubrica) {
        double totalRubricas = 0;
        for (int i=0; i<getQuantidadeRubricas(tipoRubrica); i++) {
            if (tipoRubrica == despesa)
                totalRubricas += despesas[i].getValor();
            else
                totalRubricas += receitas[i].getValor();
        }
        return totalRubricas;
    }

    public double getValorRubricaPorIndice(boolean tipoRubrica, int indice) {
        if (tipoRubrica == despesa)
            return despesas[indice].getValor();

        return receitas[indice].getValor();
    }

    public void setValorRubricaPorIndice(boolean tipoRubrica, int indice, double valor) {
        if (tipoRubrica == despesa)
            despesas[indice].setValor(valor);
        else
            receitas[indice].setValor(valor);
    }

    public String getlabelAmigavelRubricaPorIndice(boolean tipoRubrica, int indice) {
        if (tipoRubrica == despesa)
            return despesas[indice].getlabelAmigavelRubrica();

        return receitas[indice].getlabelAmigavelRubrica();
    }

    public double getSaldoDisponivel() {
        return getTotalRubricas(receita) - getTotalRubricas(despesa);
    }

}
