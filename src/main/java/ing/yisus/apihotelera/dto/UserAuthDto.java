package ing.yisus.apihotelera.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserAuthDto {
    private String username;
    private String password;
}
