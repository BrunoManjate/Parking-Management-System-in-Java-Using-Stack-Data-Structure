
public class Parque_Automovel 
{
	private String modelo, marca,tipoA, matricula, tipoP,bi;
	private byte numH;

	
	public Parque_Automovel(String bi,String tipoA, String modelo, String marca, String matricula,byte numH,String tipoP) 
	{
		this.bi = bi;
		this.tipoA = tipoA;
		this.modelo = modelo;
		this.marca = marca;
		this.matricula = matricula;
		this.numH = numH;
		this.tipoP = tipoP;
	}
	

	public Parque_Automovel()
	{
		this("", "", "", "", "", (byte)0, "");
	}
	
	
	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getTipoA() {
		return tipoA;
	}


	public void setTipoA(String tipoA) {
		this.tipoA = tipoA;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getTipoP() {
		return tipoP;
	}


	public void setTipoP(String tipoP) {
		this.tipoP = tipoP;
	}


	public String getBi() {
		return bi;
	}


	public void setBi(String bi) {
		this.bi = bi;
	}


	public byte getNumH() {
		return numH;
	}


	public void setNumH(byte numH) {
		this.numH = numH;
	}

    
	public float valorAutomovel()
	{
		if(tipoA.equalsIgnoreCase("Ligeiro"))
			return 500 * numH;
		else
			if(tipoA.equalsIgnoreCase("Pesado"))
				return 1000 * numH;
			else
				return 250 * numH;
	}
	
	public String toString() 
	{
		return "Bilhete de Identidade : "+bi+"\nTipo de Automovel : "+tipoA+"\nModelo do Automovel "+modelo+"\nMatricula do Automovel : "+matricula+"\nNumero de Horas de Estacionamento : "+numH+"\nForma de Pagamento : "+tipoP+"\nValor a Pagar "+valorAutomovel()+" MT";
	}
}
