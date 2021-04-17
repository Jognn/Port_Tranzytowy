package bdbt_portranzytowy.controllers;

import java.util.List;

import bdbt_portranzytowy.models.Towar;
import bdbt_portranzytowy.TowaryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	
	@Autowired
	private TowaryDAO towaryDao;
	
	@RequestMapping(value="/")
	public String viewHomePage(Model model) {
		List<Towar> listTowary = towaryDao.list();
		model.addAttribute("listTowary", listTowary);
		return "index";
	}
	
//	@RequestMapping(value="/error")
//	public String viewErrorPage(Model model) {
//		return "redirect:/";
//	}
	
	@RequestMapping(value="/new")
	public String showNowyTowar(Model model) {
		Towar towar = new Towar();
		model.addAttribute("towar", towar);
		return "nowy_towar";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@ModelAttribute("towar") Towar towar) {
		if(towar != null)
			towaryDao.add(towar);
		return "redirect:/";
	}
	
	@RequestMapping(value="/edit/{id}")
	public ModelAndView showEdytujTowar(@PathVariable(name = "id") int id){
		ModelAndView mav = new ModelAndView("edytuj_towar");
		Towar towar = towaryDao.get(id);
		mav.addObject("towar", towar);
		return mav;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@ModelAttribute("towar") Towar towar) {
		towaryDao.update(towar);
		return "redirect:/";
	}
	
	@RequestMapping(value="/delete/{id}")
	public String usun(@PathVariable(name="id")int id) {
		towaryDao.delete(id);
		return "redirect:/";
	}
	

}
