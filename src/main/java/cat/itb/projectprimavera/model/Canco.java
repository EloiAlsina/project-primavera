package cat.itb.projectprimavera.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


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
