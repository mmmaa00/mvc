package Controller;
import java.util.List;
import Controller.EmployeeController;
import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;     
import Model.Employee;

public class Controller {
	EmployeeController empC;
	
	@RequestMapping("/empform")
	public String showform(Model m) {
		m.addAttribute("command", new Employee());
		return "empform";
	}
	
	@RequestMapping(value="/post", method = RequestMethod.POST) 
	public String post(@ModelAttribute("emp") Employee emp) {
		empC.post(emp);
		return "redirect:/viewemp";
	}
	
	@RequestMapping("/viewemp")
	public String viewemp(Model m) {
		List<Employee> listEmp = empC.getEmployees();
		m.addAttribute("list", listEmp);
		return "viewemp";
	}
	
	@RequestMapping(value="/editemp/{id}")
	public String update(@PathVariable int id, Model m) {
		Employee emp = empC.getEmpById(id);
		m.addAttribute("command", emp);
		return "empeditform";
	}
	
	@RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("emp") Employee emp){    
        empC.update(emp);    
        return "redirect:/viewemp";    
    }    
   
	
    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
        empC.delete(id);    
        return "redirect:/viewemp";    
    }     
	
}
