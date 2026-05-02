//Exercicio de revisão

//1) um diabetico tem fator de correção(boolus) de carboidrato.O sistema precisa solicitar o boulusAlimentar de correção(dg
// / ml por carboidato) e aquantidade ingerido.
//por exemplo

//entrada
//nome:Alexandre
//boulusAlimentar = 15
//quantidadeInsulinaMax = 13
//carboidrato = 30 g

//processo de saída
//quantidadedeInsulina= carboidrato/boulus
//quantidadeMaximaCarboidrata = boulus * quantidadeInsulinaMaxima
//restanteInsulinaDia = quantidadeInsulina - maximaInsulina
//restanteCarboidratoDia = quantidadeMaxima -carboidrato

#include <stdio.h>
#include <stdlib.h>

int main() {
    char nome[100];
    int boulusAlimentar;
    int quantidadeInsulinaMax;
    int carboidrato;

    int quantidadedeInsulina;
    int quantidadeMaximaCarboidrata ;
    int restanteInsulinaDia;
    int restanteCarboidratoDia;
    
    printf("olá Informe seus dados\n");

    printf("nome:");
    gets(nome);

    printf("boulos alimentar:");
    scanf("%d", &boulusAlimentar);

    printf("Quantidade de insulina maxima:");
    scanf("%d" &quantidadeInsulinaMax);

    printf("Carboidratos:");
    scanf("%d",&carboidrato);

    quantidadedeInsulina = (int)carboidrato / boulusAlimentar;
    quantidadeMaximaCarboidrata = boulusAlimentar * quantidadeInsulinaMax;
    restanteInsulinaDia = quantidadeInsulinaMax - quantidadedeInsulina;
    restanteCarboidratoDia = quantidadeMaximaCarboidrata - carboidrato;

    printf("Quantidade de insulina para essa refeiçao: %d\n",quantidadedeInsulina);
    printf("Quantidade maxima de carboidrado dia:%d\n",quantidadeMaximaCarboidrata);
    printf("Ainda restam %d unidades de insulina no dia\n",restanteInsulinaDia);
    printf("Ainda restam %d de carboidrato no dia\n",restanteCarboidratoDia);

    return 1;
}
