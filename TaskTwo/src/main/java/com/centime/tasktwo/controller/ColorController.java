package com.centime.tasktwo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.centime.tasktwo.Repository.ColorRepository;
import com.centime.tasktwo.dto.NestedEntity;
import com.centime.tasktwo.model.ColorEntity;

@RestController
@RequestMapping("/api")
public class ColorController {

	@Autowired
	ColorRepository colorRepo;

	@PostMapping("/insertData")
	public ResponseEntity<Void> insertData(@RequestBody ColorEntity entity) {
		colorRepo.save(entity);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/getDataById/{id}")
	public ResponseEntity<ColorEntity> getDataById(@PathVariable Long id) {
		ColorEntity entity = new ColorEntity();
		try {
			entity = colorRepo.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(entity, entity == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}

	@GetMapping("/getAllData")
	public ResponseEntity<List<NestedEntity>> getAllData() {

		List<ColorEntity> entities = colorRepo.findAll();

//		List<ColorEntity> entities = createEntities();

		Map<Long, List<ColorEntity>> entityMap = entities.stream()
				.collect(Collectors.groupingBy(ColorEntity::getParentId));

		// Assuming top-level entities have parentId 0
		List<ColorEntity> topLevelEntities = entityMap.get(0L); 

		List<NestedEntity> result = topLevelEntities.stream().map(entity -> buildNestedEntity(entity, entityMap))
				.collect(Collectors.toList());

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	private static NestedEntity buildNestedEntity(ColorEntity entity, Map<Long, List<ColorEntity>> entityMap) {
		NestedEntity nestedEntity = new NestedEntity(entity.getName(), entity.getColor());

		if (entityMap.containsKey(entity.getId())) {
			List<ColorEntity> children = entityMap.get(entity.getId());
			nestedEntity.setSubClasses(
					children.stream().map(child -> buildNestedEntity(child, entityMap)).collect(Collectors.toList()));
		}

		return nestedEntity;
	} 

	private static List<ColorEntity> createEntities() {
		List<ColorEntity> entities = new ArrayList<>();
		entities.add(new ColorEntity(1L, 0L, "Warrior", "red"));
		entities.add(new ColorEntity(2L, 0L, "Wizard", "green"));
		entities.add(new ColorEntity(3L, 0L, "Priest", "white"));
		entities.add(new ColorEntity(4L, 0L, "Rogue", "yellow"));
		entities.add(new ColorEntity(5L, 1L, "Fighter", "blue"));
		entities.add(new ColorEntity(6L, 1L, "Paladin", "lightblue"));
		entities.add(new ColorEntity(7L, 1L, "Ranger", "lightgreen"));
		entities.add(new ColorEntity(8L, 2L, "Mage", "grey"));
		entities.add(new ColorEntity(9L, 2L, "Specialist wizard", "lightgrey"));
		entities.add(new ColorEntity(10L, 3L, "Cleric", "red"));
		entities.add(new ColorEntity(11L, 3L, "Druid", "green"));
		entities.add(new ColorEntity(12L, 3L, "Priest of specific mythos", "white"));
		entities.add(new ColorEntity(13L, 4L, "Thief", "yellow"));
		entities.add(new ColorEntity(14L, 4L, "Bard", "blue"));
		entities.add(new ColorEntity(15L, 13L, "Assassin", "lighblue"));
		return entities;
	}



}
