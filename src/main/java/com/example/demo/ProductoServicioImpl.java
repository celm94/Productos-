package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServicioImpl implements ProductoServicio{
    private static List<Productos> Lista =new ArrayList<Productos>();

    @Override
    public List<Productos> Listar() {
        return Lista;
    }

    @Override
    public Productos Buscar(long id) {
        for(Productos busqueda: Lista){
            if(busqueda.getId()==id)
                return busqueda;
        }
        return null;
    }

    @Override
    public void Crear(Productos nuevoproducto) {
        int cont=0;
        nuevoproducto.setId(cont++);
        Lista.add(nuevoproducto);

    }

    @Override
    public Productos Actualizar(Productos actualizarproducto) {
        for(Productos actualizar: Lista){
            if(actualizar.getId()== actualizarproducto.getId()){
                actualizar.setNombre(actualizarproducto.getNombre());
                actualizar.setMarca(actualizarproducto.getMarca());
                actualizar.setDescripcion(actualizarproducto.getDescripcion());
                actualizar.setPrecio(actualizarproducto.getPrecio());
                return actualizar;
            }

        }
        return null;
    }

    @Override
    public void Borrar(long id) {
        for(Productos borrar: Lista){
            if(borrar.getId()==id){
                Lista.remove(borrar);
            }
        }
    }
}
