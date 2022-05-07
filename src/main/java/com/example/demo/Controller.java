package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")


public class Controller {
    @Autowired
    ProductoServicio productoServicio;

    @GetMapping()
    public List<Productos> Listar(){
        List<Productos> Lista = productoServicio.Listar();
        return Lista;
    }

    @GetMapping("/{id}")
    public Productos Buscar(@PathVariable Long id){
        Productos busqueda = productoServicio.Buscar(id);

        return busqueda;
    }

    @PostMapping("/{crear}")
    public void Crear(@RequestBody Productos productos){
        productoServicio.Crear(productos);
    }

    @GetMapping("/{actualizar}")
    public Productos Actualizar(@RequestBody Productos productos){
        Productos actualizar = productoServicio.Actualizar(productos);
        return actualizar;
    }

    @GetMapping("/{borrar}/{id}")
    public void Borrar(@PathVariable long id){
        productoServicio.Borrar(id);
    }


}
