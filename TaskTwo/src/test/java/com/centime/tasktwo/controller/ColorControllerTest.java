package com.centime.tasktwo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.centime.tasktwo.Repository.ColorRepository;
import com.centime.tasktwo.dto.NestedEntity;
import com.centime.tasktwo.model.ColorEntity;

class ColorControllerTest {

	@Mock
	private ColorRepository colorRepository;

	@InjectMocks
	private ColorController colorController;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testInsertData() {
		ColorEntity entityToSave = new ColorEntity(1L, 0L, "TestEntity", "TestColor");

		ResponseEntity<Void> responseEntity = colorController.insertData(entityToSave);

		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		verify(colorRepository, times(1)).save(entityToSave);
	}

	@Test
	void testGetDataById() {
		Long entityId = 1L;
		ColorEntity mockEntity = new ColorEntity(entityId, 0L, "TestEntity", "TestColor");

		when(colorRepository.findById(entityId)).thenReturn(Optional.of(mockEntity));

		ResponseEntity<ColorEntity> responseEntity = colorController.getDataById(entityId);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(mockEntity, responseEntity.getBody());
	}

	@Test
	void testGetDataByIdNotFound() {
		Long entityId = 1L;

		when(colorRepository.findById(entityId)).thenReturn(Optional.empty());

		ResponseEntity<ColorEntity> responseEntity = colorController.getDataById(entityId);

		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
		assertNull(responseEntity.getBody()); // Ensure the response body is null for a not found scenario
	}

	@Test
	void testGetAllData() {
		List<ColorEntity> mockEntities = Arrays.asList(new ColorEntity(1L, 0L, "Entity1", "Color1"),
				new ColorEntity(2L, 0L, "Entity2", "Color2"));

		when(colorRepository.findAll()).thenReturn(mockEntities);

		ResponseEntity<List<NestedEntity>> responseEntity = colorController.getAllData();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

		List<NestedEntity> nestedEntities = responseEntity.getBody();
		assertEquals(2, nestedEntities.size());

		assertEquals("Entity1", nestedEntities.get(0).getName());
		assertEquals("Color1", nestedEntities.get(0).getColor());

		assertEquals("Entity2", nestedEntities.get(1).getName());
		assertEquals("Color2", nestedEntities.get(1).getColor());
	}

}
