package msalogin.domain;

import java.util.Date;
import lombok.Data;
import msalogin.infra.AbstractEvent;

@Data
public class SmartBankingUpdated extends AbstractEvent {

    private Long CustomerId;
    private String Status;
}
