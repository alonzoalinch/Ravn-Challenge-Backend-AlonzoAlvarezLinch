package challenge.ravn.response;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class SalesResponse {
    private String author;
    private String revenue;
}
