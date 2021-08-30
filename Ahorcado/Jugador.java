package ar.edu.unlam.pb1.ahorcado;

public class Jugador {
	private String name;
	private Boolean turno;
	private Integer vidas;
	private String palabra;
	private Character letra;
	private Character palabraOculta[];
	
	

	public Jugador(String nombre,String palabra) {
		this.name=nombre;
		this.turno=Boolean.FALSE;
		this.vidas=6;
		this.palabra=palabra;
		this.palabraOculta = new Character[this.palabra.length()];
		for(int i=0;i<palabra.length();i++) {
			palabraOculta[i]='-';
		}
	}
	
	public String getPalabraOculta() {
		String palabra="";
		for(int i=0;i<this.palabra.length();i++) {
			palabra+=palabraOculta[i];
		}
		return palabra;
	}

	public void setPalabraOculta(Character letra) {
		this.letra=letra;
		for(int i=0;i<this.palabra.length();i++) {
			if(letra==palabra.charAt(i)) {
				this.palabraOculta[i]=letra;
			}
		}
	}

	
	public Character getLetra() {
		return letra;
	}

	public void setLetra(Character letra) {
		this.letra = letra;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getVidas() {
		return vidas;
	}


	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	
	public void pierdeVida() {
		this.vidas-=1;
	}
	
	public void turnar() {
		if(turno) {
			turno=Boolean.FALSE;
		}else if(!turno) {
			turno=Boolean.TRUE;
		}
	}
	
	public Boolean getTurno() {
		return turno;
	}
	
	public String toString() {
		return this.getName() + "-" + this.getPalabra() + " - " + this.getVidas();
	}
}
