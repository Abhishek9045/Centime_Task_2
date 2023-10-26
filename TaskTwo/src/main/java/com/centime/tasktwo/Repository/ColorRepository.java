package com.centime.tasktwo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.centime.tasktwo.model.ColorEntity;

public interface ColorRepository extends JpaRepository<ColorEntity, Long> {
	List<ColorEntity> findByParentId(Long parentId);
}
