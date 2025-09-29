import br.com.fiap.moop.model.EnumModelo;
import br.com.fiap.moop.model.EnumStatus;
import lombok.Data;

@Data
public class MotoDTO {
    private Long id;
    private String placa;
    private String chassi;
    private String modelo; // vai receber descricao do EnumModelo
    private String status; // vai receber descricao do EnumStatus
    private Long id_galpao;

    public void setStatus(EnumStatus status2) {
        this.status = status2 != null ? status2.getDescricao() : null;
    }

    public void setModelo(EnumModelo modelo2) {
        this.modelo = modelo2 != null ? modelo2.getDescricao() : null;
    }
}
