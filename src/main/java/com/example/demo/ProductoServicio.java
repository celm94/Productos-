package com.example.demo;

import java.util.List;

public interface ProductoServicio {
    public List<Productos> Listar();
    public Productos Buscar(long id);
    public void Crear(Productos nuevoproducto);
    public Productos Actualizar(Productos actualizarproducto);
    public void Borrar(long id);
}
