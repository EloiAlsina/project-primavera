package cat.itb.projectprimavera.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Canco {
    @NotNull
    @NotEmpty
    private String nomCanco;
    @NotNull
    @NotEmpty
    private String grupCanco;








}
