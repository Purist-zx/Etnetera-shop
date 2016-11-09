package cz.etn.etnshop.controller;

import cz.etn.etnshop.dao.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import cz.etn.etnshop.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView showProductsList() {
		ModelAndView modelAndView = new ModelAndView("product/list");
		modelAndView.addObject("products", productService.getProducts());
		return modelAndView;
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product, BindingResult bindingResult) {
		if (bindingResult.hasErrors()){
			//TODO: return error page
			return "redirect:/product/list";
		}
		productService.addProduct(product);
		return "redirect:/product/list";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String editProduct() {
		return "product/edit";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
	public String editProduct(@PathVariable("id") String id, @RequestParam("newName")String newName, @RequestParam("newSerialNumber")String newSerialNumber) {
		Product product = new Product();
		try {
			product.setId(Integer.parseInt(id));
			product.setName(newName);
			product.setSerialNumber(Long.parseLong(newSerialNumber));
		}catch (NumberFormatException ex){
			//TODO: return error page
			return "product/edit";
		}
		productService.updateProduct(product);
		return "redirect:/product/list";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView findProducts(@RequestParam("text")String text) {
		ModelAndView modelAndView = new ModelAndView("product/search");
		List<Product> found = productService.findProducts(text);
		modelAndView.addObject("products", found);
		return modelAndView;
	}
}
