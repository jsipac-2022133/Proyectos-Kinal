package modelo;

public class TipoTarjeta {
    private int idTipoTarjeta;
    private String tipoTarjeta;

    public TipoTarjeta() {
    }

    public TipoTarjeta(int idTipoTarjeta, String tipoTarjeta) {
        this.idTipoTarjeta = idTipoTarjeta;
        this.tipoTarjeta = tipoTarjeta;
    }

    public int getIdTipoTarjeta() {
        return idTipoTarjeta;
    }

    public void setIdTipoTarjeta(int idTipoTarjeta) {
        this.idTipoTarjeta = idTipoTarjeta;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }
}
