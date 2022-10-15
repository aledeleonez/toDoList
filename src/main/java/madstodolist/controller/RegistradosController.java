package madstodolist.controller;

import madstodolist.authentication.ManagerUserSession;
import madstodolist.controller.exception.TareaNotFoundException;
import madstodolist.controller.exception.UsuarioNoLogeadoException;
import madstodolist.model.Tarea;
import madstodolist.model.Usuario;
import madstodolist.model.UsuarioRepository;
import madstodolist.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/registrados/:{id}")
    public String usuariosRegistradosId(@PathVariable(value = "id") Long idUsuario, Model model){
        Usuario usuario = usuarioService.findById(idUsuario);
        model.addAttribute("usuario", usuario);
        if (usuario == null) {
            throw new UsuarioNoLogeadoException();
        }
        return "descripcionUsuario";
    }
}
