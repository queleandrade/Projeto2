import java.util.ArrayList;

public class ScreenShopping extends Screen{
	ScreenClient telaCliente;
	int pageMinhasCompras;
	int pageMinhasVendas;
	
	public ScreenShopping(ScreenClient telaCliente) {
		super();
		this.telaCliente = telaCliente;
	}
	
	public void telaComprar(Announcement produto,Shipping frete,int qntProd) {
		System.out.println("*** Tela de Compra ***\n");
		
		String produtoNome = "NENHUM";
		if(produto instanceof AnnouncementBook) produtoNome = ((AnnouncementBook) produto).getBookName();
		else if(produto instanceof AnnouncementMagazine) produtoNome = ((AnnouncementMagazine) produto).getMagazineName();
		else if(produto instanceof AnnouncementMagazineSubscription) produtoNome = ((AnnouncementMagazineSubscription) produto).getMagazineName();
		else if(produto instanceof AnnouncementBookCollection) produtoNome = ((AnnouncementBookCollection) produto).getBookCollectionName();
		
		String money = String.format("%.2f", qntProd * (produto != null ? produto.getValue() : 0));
		
		System.out.println("Produto     -> " + produtoNome);
		System.out.println("Quantidade  -> " + qntProd);
		System.out.println("Valor Total -> R$ " + mascara(money,"dinheiro"));
		System.out.println("Frete       -> " + (frete == null ? "NENHUM\n" : frete.getCompany() + "\n"));
		
		System.out.println("(1) Informar código do produto");
		System.out.println("(2) Informar código do frete");
		System.out.println("(3) Informar quantidade do produto");
		System.out.println("(4) Finalizar compra");
		System.out.println("(5) Voltar para Área do Cliente\n");
		
		int[] options = new int[]{1,2,3,4,5} ;

		int option = takeIntInPrompt("Digite a opção desejada -> ","Opção não existente!\n",options,telaCliente.telaPrincipal.input);

		telaCliente.telaPrincipal.input.nextLine();

		if(option == 1) {
			String codProd = requestString("\nDigite o código do produto -> ", "Erro no código do produto!\n", telaCliente.telaPrincipal.input);
			int posProd = telaCliente.telaPrincipal.findAnuncioById(codProd);
			if(posProd != -1) {
				produto = telaCliente.telaPrincipal.anuncios.get(posProd);
				if(qntProd == 0)qntProd = 1;
			}
			else {
				System.out.println("\n###################################\n");
				System.out.println("Info -> Nenhum produto cadastrado com este código");
			}
			System.out.println("\n###################################\n");
			telaComprar(produto,frete,qntProd);
		}
		else if(option == 2) {
			String codFrete = requestString("\nDigite o código do frete -> ", "Erro no código do frete!\n", telaCliente.telaPrincipal.input);
			int posFrete = telaCliente.telaPrincipal.findFreteById(codFrete);
			if(posFrete != -1)frete = telaCliente.telaPrincipal.fretes.get(posFrete);
			else {
				System.out.println("\n###################################\n");
				System.out.println("Info -> Nenhum frete cadastrado com este código");
			}
			System.out.println("\n###################################\n");
			telaComprar(produto,frete,qntProd);
		}
		else if(option == 3){
			int novoQntProd = requestInt("\nDigite a quantidade desejada -> ", "Erro na quantidade desejada!", telaCliente.telaPrincipal.input);
			qntProd = novoQntProd;
			System.out.println("\n###################################\n");
			telaComprar(produto,frete,qntProd);
		}
		else if(option == 4) {
			if(qntProd == 0 || produto == null || frete == null) {
				System.out.println("\n###################################\n");
				System.out.println("Info -> É necessário um produto e um frete para finalizar a comprar");
				System.out.println("\n###################################\n");
				telaComprar(produto,frete,qntProd);
			}
			else {
				addSale(produto,frete,qntProd);
				System.out.println("\n###################################\n");
				System.out.println("Info -> Compra realizada com sucesso");
				System.out.println("\n###################################\n");
				telaCliente.telaCliente();
			}
		}
		else if(option == 5) {
			System.out.println("\n###################################\n");
			telaCliente.telaCliente();
		}
	}
	
	public void addSale(Announcement produto,Shipping frete,int qntProd) {
		User vendedor = produto.getAdvertiser();
		User comprador = telaCliente.telaPrincipal.usuarioAtual;
		Shopping novaCompra = new Shopping(produto, comprador, vendedor, frete,qntProd);
		vendedor.addSales(novaCompra);
		comprador.addShopping(novaCompra);
		telaCliente.telaPrincipal.vendas.add(novaCompra);
	}
	
	public void menuListagem(int page,String type) {
		User usuario = telaCliente.telaPrincipal.usuarioAtual;
		
		ArrayList<Shopping> compras = usuario.getMyShopping();
		
		ArrayList<Shopping> vendas = usuario.getMySales();
		
		int contador;

		int atualPage = type == "compras" ? pageMinhasCompras : pageMinhasVendas ;

		int total = type == "compras" ? compras.size() : vendas.size();

		int totalPages = (int) Math.ceil((float)total/telaCliente.telaPrincipal.itensPorPagina);

		atualPage = page < 1 ? 1 : (page > totalPages ? totalPages : page);

		if(type == "compras")pageMinhasCompras = atualPage;
		else pageMinhasVendas = atualPage;
			
		int limitFor = atualPage == totalPages ? (total - (totalPages - 1)*telaCliente.telaPrincipal.itensPorPagina) : telaCliente.telaPrincipal.itensPorPagina;

		int optionProx = -1;

		int optionAnt = -1;

		int optionVolt = -1;

		System.out.printf("*** %s ***\n\n",type == "compras" ? "Minhas Compras" : "Minhas Vendas");
		System.out.printf("Página atual      -> %d\n",atualPage);
		System.out.printf("Total de Páginas  -> %d\n",totalPages);
		if(type == "compras")System.out.printf("Total de Compras  -> %d\n\n",total);
		else System.out.printf("Total de Vendas   -> %d\n\n",total);
		
		for(contador = 0 ; contador < limitFor ; contador++) {
			int posicaoItem = contador + ((atualPage - 1)*telaCliente.telaPrincipal.itensPorPagina);
			Shopping compra = type == "compras" ? compras.get(posicaoItem) : vendas.get(posicaoItem);
			System.out.printf("(%d) %sProduto: %s - Quantidade: %s\n",contador + 1,(contador + 1) < 10 ? " " : "",compra.getProductName(),compra.getQuantity());
		}
		
		if(atualPage == totalPages && totalPages > 1) {
			System.out.printf("(%d) %sAnterior \n",++contador,contador > 9 ? "" : " ");
			optionAnt = contador;
		}
		else if (atualPage < totalPages && atualPage == 1) {
			System.out.printf("(%d) %sPróxima \n",++contador,contador > 9 ? "" : " ");
			optionProx = contador;
		}
		else if (atualPage < totalPages && atualPage > 1) {
			System.out.printf("(%d) %sAnterior \n",++contador,contador > 9 ? "" : " ");
			optionAnt = contador;
			System.out.printf("(%d) %sPróxima \n",++contador,contador > 9 ? "" : " ");
			optionProx = contador;
		}
		
		System.out.printf("(%d) %sVoltar para Área do Cliente\n\n",++contador,contador > 9 ? "" : " ");
	
		optionVolt = contador;

		int options[] = new int[contador];

		for(int i = 0; i < contador;i++)options[i] = i + 1;

		int option = takeIntInPrompt("Digite o indice para detalhes -> ","Opção não existente!\n",options,telaCliente.telaPrincipal.input);

		telaCliente.telaPrincipal.input.nextLine();

		System.out.println("\n###################################\n");
		
		if(option == optionProx)menuListagem(atualPage + 1,type);
		else if(option == optionAnt)menuListagem(atualPage - 1,type);
		else if(option == optionVolt)telaCliente.telaCliente();
		else if(option <= limitFor && option >= 1) {
			int posItem = (option - 1) + ((atualPage - 1)*telaCliente.telaPrincipal.itensPorPagina);
			if(type == "compras") {
				Shopping itemCompra = telaCliente.telaPrincipal.usuarioAtual.getMyShopping().get(posItem);
				detalharCompra(itemCompra);
			}
			else {
				Shopping itemVenda = telaCliente.telaPrincipal.usuarioAtual.getMySales().get(posItem);
				detalharVenda(itemVenda);
			}
			
		}
	}
	
	public void detalharCompra(Shopping item) {
		System.out.println("*** Detalhes da Compra ***\n");
		System.out.println(item);
		System.out.println("\n(1) Voltar para Minhas Compras\n");

		int options[] = {1};

		takeIntInPrompt("Digite a opção desejada -> ","Opção não existente!\n",options,telaCliente.telaPrincipal.input);

		System.out.println("\n###################################\n");

		menuListagem(pageMinhasCompras,"compras");
	}
	
	public void detalharVenda(Shopping item) {
		System.out.println("*** Detalhes da Venda ***\n");
		System.out.println(item);
		System.out.println("\n(1) Voltar para Minhas Vendas\n");

		int options[] = {1};

		takeIntInPrompt("Digite a opção desejada -> ","Opção não existente!\n",options,telaCliente.telaPrincipal.input);

		System.out.println("\n###################################\n");

		menuListagem(pageMinhasVendas,"vendas");
	}

}
