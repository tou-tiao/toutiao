package com.fzu.repository;

import com.fzu.pojo.Exclusive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExclusiveRepository extends JpaRepository<Exclusive, Long> {

    Exclusive findById(Long eclusiveId);

    @Query("select p from Exclusive p where p.user.id = ?1")
    List<Exclusive> findByOwnUserId(Long userId);// 根据用户id 查找其拥有的独家号

    Exclusive findByPublicName(String publicName);
    /**
     * 通过参数搜索匹配的独家号(模糊查询)
     * @param queryParam 查询参数
     * @return 符合的独家号
     */
    @Query("select p from Exclusive p where p.publicName like CONCAT('%',:queryParam,'%')")
    List<Exclusive> findByParam(@Param("queryParam") String queryParam);
}
