import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Information {
    private int id;
    private int bank;
    private String first;
    private String last;
}