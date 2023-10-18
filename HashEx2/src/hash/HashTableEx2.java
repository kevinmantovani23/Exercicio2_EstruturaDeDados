package hash;

public class HashTableEx2 {
	Hash_Ex2[] tabela;
	static int TAM_MAX = 50;
	int pos;

	public HashTableEx2() {
		tabela = new Hash_Ex2[TAM_MAX];
		for (int i = 0; i < TAM_MAX; i++) {
			tabela[i] = new Hash_Ex2();
		}
	}

	private int chavealt(int chave) {
		int v = chave;
		v %= TAM_MAX;
		return v;
	}

	public boolean cheia() {
		boolean cheia = true;
		for (int i = 0; i < TAM_MAX; i++) {
			if (!tabela[i].ocupado) {
				cheia = false;
				break;
			}
		}
		return cheia;
	}

	public void inserir(int item, String objeto) {
		if (cheia()) {
			System.out.println("A Hash esta cheia!");
			return;
		}
		pos = chavealt(item);

		while (pos <= TAM_MAX) {
			if (tabela[pos].ocupado) {
				if (tabela[pos].item == item) {
					System.out.println("Esse item já existe.");
					return;
				}
			}
			if (!tabela[pos].ocupado) {
				tabela[pos].item = item;
				tabela[pos].dado = objeto;
				tabela[pos].ocupado = true;
				System.out.println("Item colocado.");
				return;
			}
			if (pos == TAM_MAX - 1) {
				pos = -1;
			}
			pos++;
		}

	}

	public void buscaNome(String nome) {
		int pos = 0;
		if (tabela[pos].ocupado) {
			if (tabela[pos].dado == nome)
				System.out.println("O nome consta na posicao " + pos);
			return;
		}
		while (pos < TAM_MAX) {
			pos++;
			if (tabela[pos].ocupado && tabela[pos].dado == nome) {
				System.out.println("O nome consta na posicao " + pos);
				return;
			}
			if (pos == TAM_MAX - 1) {
				System.out.println("O nome nao consta.");
				return;
			}
		}
	}

	public void apagarNome(String nome) {
		for (int pos = 0; pos < TAM_MAX; pos++) {
			if (tabela[pos].dado == nome) {
				tabela[pos].dado = "";
				tabela[pos].item = 0;
				tabela[pos].ocupado = false;
				System.out.println("Nome apagado.");
			}
		}
	}

	public void printar() {
		for (int i = 0; i < TAM_MAX; i++) {
			if (tabela[i].dado != "_") {
				System.out.println("Hash[" + i + "]: (" + tabela[i].item + ", " + tabela[i].dado + ")");
			}
		}
	}
}
