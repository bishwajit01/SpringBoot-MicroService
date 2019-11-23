package com.vikram.bishwajit.resource;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikram.bishwajit.model.CatalogItem;

/**
 * @author bvikram2
 *
 */
@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@GetMapping("all")
	public List<CatalogItem> getCatalog() {
		return Collections.singletonList(new CatalogItem("Bala", "About baldness", 4.3));
	}

	@GetMapping("{userId}")
	public List<CatalogItem> getCatalogByUserId(@PathVariable("userId") String id) {
		return Collections.singletonList(new CatalogItem("Bala2", "About baldness", 3.3));
	}
}
