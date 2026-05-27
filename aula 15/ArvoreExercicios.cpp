#include <iostream>
#include <cstdlib>
using namespace std;
 
typedef struct no {
    int valor;
    struct no *esq;
    struct no *dir;
} Arvore;
 
Arvore *inserir(int valor, Arvore *raiz) {
    if (raiz) {
        if (valor < raiz->valor) {
            raiz->esq = inserir(valor, raiz->esq);
        } else {
            raiz->dir = inserir(valor, raiz->dir);            
        }
        return raiz;
    } else {
        //alocar memoria
        Arvore *novo = (Arvore*)malloc(sizeof(Arvore));
        //depositar valores
        novo->valor = valor;
        novo->esq = NULL;
        novo->dir = NULL;
        //retornar o elemento criado
        return novo;
    }
}
 
void red(Arvore *raiz) {
    if (raiz) {
        cout << raiz->valor << endl;
        red(raiz->esq);
        red(raiz->dir);
    }
}
 
void erd(Arvore *raiz) {
    if (raiz) {
        erd(raiz->esq);
        cout << raiz->valor << endl;
        erd(raiz->dir);
    }
}
 
void edr(Arvore *raiz) {
    if (raiz) {
        edr(raiz->esq);
        edr(raiz->dir);
        cout << raiz->valor << endl;
    }
}
// 1. contar numeros pares
int contarPares(Arvore *raiz) {
    if (raiz) {
        if (raiz->valor % 2 == 0) {
            return 1 + contarPares(raiz->esq) + contarPares(raiz->dir);
        } else {
            return contarPares(raiz->esq) + contarPares(raiz->dir);
        }
    }
    return 0;
}
// 2. contar nodos folhas
int contarFolhas(Arvore *raiz) {
    if (raiz) {
        if (raiz->esq == NULL && raiz->dir == NULL) {
            return 1;
        }
        return contarFolhas(raiz->esq) + contarFolhas(raiz->dir);
    }
    return 0;
}
// 3. ver se o valor está contido na árvore
bool contido(int valor, Arvore *raiz) {
    if (raiz) {
        if (valor == raiz->valor) {
            return true;
        }
        if (valor < raiz->valor) {
            return contido(valor, raiz->esq);
        } else {
            return contido(valor, raiz->dir);
        }
    }
    return false;
}
 
//4. contar nodos
int contarNaoFolhas(Arvore *raiz) {
    if (raiz) {
        if (raiz->esq != NULL || raiz->dir != NULL) {
            return 1 + contarNaoFolhas(raiz->esq) + contarNaoFolhas(raiz->dir);
        }
    }
    return 0;
}

void exibir(Arvore *raiz, int nivel) {
    if (raiz) {
        //tudo para direita
        exibir(raiz->dir, nivel + 1);
 
        //exibir o nodo dentro de seu nivel
        for (int i = 0; i < nivel; i++) {
            cout << "   ";
        }
        cout << raiz->valor << "(" << nivel << ")" << endl;
 
        //tudo para esquerda
        exibir(raiz->esq, nivel + 1);
    }
}
 
int contarNos(Arvore *raiz) {
    if (raiz) {
        return 1 + contarNos(raiz->esq) + contarNos(raiz->dir);
    }
    return 0;
}
 
int main() {
    Arvore *raiz = NULL;
 
    raiz = inserir(100, raiz);
    raiz = inserir(50, raiz);
    raiz = inserir(200, raiz);
    raiz = inserir(20, raiz);
    raiz = inserir(70, raiz);
    raiz = inserir(250, raiz);
    raiz = inserir(150, raiz);
 
    //red(raiz);
    //erd(raiz);
    //edr(raiz);
 
    exibir(raiz, 0);
    cout << "Total de elementos: " << contarNos(raiz) << endl;
   
    cout << "--- ESTRUTURA DA ARVORE (De lado) ---\n";
    exibir(raiz, 0);
    cout << "-------------------------------------\n\n";

    // 2) Mostra o total de nós na árvore (função que você já tinha)
    cout << "Total de elementos na arvore: " << contarNos(raiz) << "\n\n";

    // Teste do Método 1: Contar números pares
    cout << "1) Qtd. de numeros pares......: " << contarPares(raiz) << endl;

    // Teste do Método 2: Contar nós folhas
    cout << "2) Qtd. de nodos folhas.......: " << contarFolhas(raiz) << endl;

    // Teste do Método 3: Verificar se um valor está contido na árvore
    int valorParaBuscar = 70;
    cout << "3) O valor " << valorParaBuscar << " esta na arvore? : ";
    if (contido(valorParaBuscar, raiz)) {
        cout << "Sim (true / 1)" << endl;
    } else {
        cout << "Nao (false / 0)" << endl;
    }

    // Teste do Método 4: Contar nós não-folhas
    cout << "4) Qtd. de nodos NAO folhas...: " << contarNaoFolhas(raiz) << endl;
    cout << "------------------------------------\n";

    return 1;
}
 
