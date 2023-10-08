package orc.iclass.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDto {
    private String email;
    private String pcode;
    private int quantity;
    private Date orderDate;
    private int bidx;
}
