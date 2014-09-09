package no.uio.inf5750.assignment1_bdher.controller;

import no.uio.inf5750.assignment1_bdher.dao.MessageDao;
import no.uio.inf5750.assignment1_bdher.model.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class BaseController {

	@Autowired
	private MessageDao messageDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		model.addAttribute("info", "Leave a message using the form");
		// Spring uses InternalResourceViewResolver and return back index.jsp
		return "index";
	}

	/*
	 * Saves a message in the database
	 */
	@RequestMapping(value = "/send", method = RequestMethod.GET)
	public String send(@RequestParam(value = "author") String author, @RequestParam(value = "content") String content,
			ModelMap model) {
		Message msg = new Message();
		msg.setAuthor(author);
		msg.setContent(content);
		int id = messageDao.save(msg);
		model.addAttribute("info", "Message id of stored message=" + id);
		return "index";
	}

	/*
	 * Prints the last message entered
	 */
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(ModelMap model) {
		Message message = messageDao.getLast();
		if (message != null) {
			model.addAttribute("message", message.getContent());
			model.addAttribute("author", message.getAuthor());
		} else {
			model.addAttribute("info", "No message found");
		}
		// Spring uses InternalResourceViewResolver and return back index.jsp
		return "index";
	}

	/*
	 * Prints the message with a given id
	 */
	@RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
	public String readId(@PathVariable int id, ModelMap model) {
		Message message = messageDao.get(id);
		if (message != null) {
			model.addAttribute("info", "Message number " + id);
			model.addAttribute("message", message.getContent());
			model.addAttribute("author", message.getAuthor());
		} else {
			model.addAttribute("info", "No message found");
		}
		// Spring uses InternalResourceViewResolver and return back index.jsp
		return "index";
	}

	@RequestMapping(value = "/welcome/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {

		model.addAttribute("message", "Welcome " + name);
		return "index";

	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(ModelMap model) {
		model.addAttribute("name", "Unknown visitor");
		return "hello";
	}

	@RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
	public String helloName(@PathVariable String name, ModelMap model) {
		model.addAttribute("name", name);
		return "hello";
	}

}
