package JhonLukas.Cardapioo.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import JhonLukas.Cardapioo.Entity.Food;
import JhonLukas.Cardapioo.Entity.FoodRequestDTO;
import JhonLukas.Cardapioo.Entity.FoodResponseDTO;
import JhonLukas.Cardapioo.Repository.Repository;

@RestController
@RequestMapping("food")
public class FoodController {

	@Autowired
	private Repository repository;

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping
	public List<FoodResponseDTO> getAll() {
		List<FoodResponseDTO> foodList = repository.findAll().stream()
				.map(JhonLukas.Cardapioo.Entity.FoodResponseDTO::new).collect(Collectors.toList());
		return foodList;

	}
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	public void saveFood(@RequestBody FoodRequestDTO data) {
		Food fooddata = new Food();
		fooddata.setTitle(data.title());
		fooddata.setImage(data.image());
		fooddata.setPrice(data.price());
		repository.save(fooddata);
	}

}
