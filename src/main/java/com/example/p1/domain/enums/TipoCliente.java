package com.example.p1.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Fisíca"),
	PESSOAJURIDICA(2, "Pessoa Juridica");
	
	private int cod;
	private String descrição;
	
	private TipoCliente(int cod, String descrição) {
		this.cod = cod;
		this.descrição = descrição;
	}
		
		public int getCod() {
		return cod;
	}

	public String getDescrição() {
		return descrição;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (TipoCliente x : TipoCliente.values()) {
		if(cod.equals(x.getCod()));
		return x;
	}
	
		throw new IllegalArgumentException("id invalido" + cod);
	}
	
	}
  



