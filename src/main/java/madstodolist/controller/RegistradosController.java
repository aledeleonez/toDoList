package madstodolist.controller;

import madstodolist.authentication.ManagerUserSession;
import madstodolist.model.Tarea;
import madstodolist.model.Usuario;
import madstodolist.model.UsuarioRepository;
import madstodolist.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RegistradosController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/registrados")
    public String usuariosRegistrados(Model model){
        List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        return "registrados";
    }
}
