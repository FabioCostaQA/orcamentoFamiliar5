package principal;

public class MesOrcamento {

    static boolean receita = false;
    static boolean despesa = true;

    int mes;

    static final int QTD_RUBRICAS_RECEITA = 2;
    static final int QTD_RUBRICAS_DESPESA = 7;

    Rubrica receitas[] = new Rubrica[QTD_RUBRICAS_RECEITA];

    Rubrica despesas[] = new Rubrica[QTD_RUBRICAS_DESPESA];

    //Valores padrão
    final double[] receitaValoresPadrao = {8000, 7000};
    final double[] despesaValoresPadrao = {1000, 900, 800, 700, 600, 500, 400};

    //Receitas
    Rubrica salario1 = new Rubrica(false, "Salário 1", receitaValoresPadrao[0]);
    Rubrica salario2 = new Rubrica(false, "Salário 2", receitaValoresPadrao[1]);

    //Despesas
    Rubrica habitacao = new Rubrica(false, "Habitação", despesaValoresPadrao[0]);
    Rubrica saude = new Rubrica(false, "Saúde", despesaValoresPadrao[1]);
    Rubrica transporte = new Rubrica(false, "Transporte", despesaValoresPadrao[2]);
    Rubrica despesasPessoais = new Rubrica(false, "Despesas Pessoais", despesaValoresPadrao[3]);
    Rubrica educacao = new Rubrica(false, "Educação", despesaValoresPadrao[4]);
    Rubrica lazer = new Rubrica(false, "Lazer", despesaValoresPadrao[5]);
    Rubrica outros = new Rubrica(false, "Outros", despesaValoresPadrao[6]);


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

    public void restauraValoresOriginais() {
        double totalRubricas = 0;
        for (int i=0; i<getQuantidadeRubricas(despesa); i++)
            setValorRubricaPorIndice(despesa, i,despesaValoresPadrao[i]);
        for (int i=0; i<getQuantidadeRubricas(receita); i++)
            setValorRubricaPorIndice(receita, i,receitaValoresPadrao[i]);
    }

}
