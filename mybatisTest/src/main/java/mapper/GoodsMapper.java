package mapper;

import bean.Goods;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsMapper {
    @Select("SELECT * FROM goods")
//    @ResultType(bean.Goods.class)
    @ResultMap("goodsMap")
    List<Goods> selectAll();
}
