package orc.iclass.mvc.dao;

import orc.iclass.mvc.dto.OrderDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<String> selectOrderByEmail();
    int insert(OrderDto vo);
    List<OrderDto> selectByEmail(String email);
    OrderDto selectByBidx(int bidx);

}
