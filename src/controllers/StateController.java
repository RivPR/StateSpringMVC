package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.State;
import data.StateDAO;

@Controller
@SessionAttributes("current")
public class StateController {
	@Autowired
	private StateDAO stateDao;

	@ModelAttribute("current")
	public Integer initSessionObject(){
		return 1;
	}

	@RequestMapping(path="navigate.do", params="next")
	public ModelAndView next(@ModelAttribute("current") Integer current){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result2.jsp");
		mv.addObject("current", ++current);
		mv.addObject("state", stateDao.getStateByOrder(current));
		return mv;
	}
	@RequestMapping(path="navigate.do", params="previous")
	public ModelAndView prev(@ModelAttribute("current") Integer current){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result2.jsp");
		mv.addObject("current", --current);
		mv.addObject("state", stateDao.getStateByOrder(current));
		return mv;
	}

	@RequestMapping(path = "GetStateData.do", params = "name", method = RequestMethod.GET)
	public ModelAndView getByName(@RequestParam("name") String n) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result2.jsp");
		mv.addObject("state", stateDao.getStateByName(n));
		mv.addObject("current", stateDao.getStateByName(n).getNumber());
		return mv;
	}

	@RequestMapping(path = "GetStatePop.do", params = "name", method = RequestMethod.GET)
	public ModelAndView getByNamePop(@RequestParam("name") String n) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result2.jsp");
		mv.addObject("state", stateDao.getStateByName(n));
		mv.addObject("current", stateDao.getStateByName(n).getNumber());
		return mv;
	}

	@RequestMapping(path = "GetStateData.do", params = "abbrev", method = RequestMethod.GET)
	public ModelAndView getByAbbrev(@RequestParam("abbrev") String a) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result2.jsp");
		mv.addObject("state", stateDao.getStateByAbbreviation(a));
		mv.addObject("current", stateDao.getStateByAbbreviation(a).getNumber());
		return mv;
	}

	@RequestMapping(path = "NewState.do", method = RequestMethod.POST)
	public ModelAndView newState(State state) {
		ModelAndView mv = new ModelAndView();
		//state.setNumber(order);
		stateDao.addState(state);
		mv.setViewName("result2.jsp");
		
		
		return mv;
	}

}
