package JhonLukas.Cardapioo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import JhonLukas.Cardapioo.Entity.Food;

public interface Repository extends JpaRepository<Food,Long> {

}
