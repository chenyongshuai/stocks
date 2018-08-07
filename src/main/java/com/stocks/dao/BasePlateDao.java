package com.stocks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.stocks.entity.BasePlate;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月21日 下午1:32:50 
  * @version：   1.0.0
  * @describe:    
  */
public interface BasePlateDao {
	/**
	 * 
	 * @param userNo
	 * @param buid
	 * @return List<BasePlate>
	 */
	@Select("select buid,plate_name,plate_desc,plate_no,user_no from base_plate where user_no=#{userNo} and buid=#{buid}")
	List<BasePlate> getByUserAndPlate(@Param(value="userNo")String userNo, @Param(value="buid")String buid);
	
	/**
	 * 
	 * @param userNo
	 * @return List<BasePlate>
	 */
	@Select("select buid,plate_name,plate_desc,plate_no,user_no,create_date from base_plate where user_no=#{userNo}")
	List<BasePlate> getByUser(@Param(value="userNo")String userNo);
	
	/**
	 * 
	 * @param userNo
	 * @return int
	 */
	@Select("select count(*) cnt from base_plate where user_no=#{userNo}")
	int getCount(@Param(value="userNo")String userNo);
	/**
	 * 
	 * @param plate
	 * @return int
	 */
	@Insert("insert into base_plate value(UUID(),#{plateName},#{plateDesc},#{plateNo},#{userNo},CURRENT_TIMESTAMP,CURRENT_TIMESTAMP)")
	int addPlate(BasePlate plate);
	/**
	 * 
	 * @param plate
	 * @return int
	 */
	@Update("update c set plate_name =#{plateName},plate_desc=#{plateDesc},plate_no=#{plateNo},update_date =CURRENT_TIMESTAMP where buid=#{buid}")
	int editPlate(BasePlate plate);
	/**
	 * 
	 * @param plateBuid
	 * @return int
	 */
	@Delete("<script>delete from base_plate where buid in <foreach collection=\"buidList\" open=\"(\" close=\")\" item=\"buid\" separator=\",\">#{buid}</foreach></script>")
	int delPlate(@Param(value="buidList") String[] buidList);
	
	
}
