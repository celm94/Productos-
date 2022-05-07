package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductoServicioImpl implements ProductoServicio{
    public static AtomicLong sequence =new AtomicLong();
    private static List<Productos> Lista =new ArrayList<Productos>(){{
        add(new Productos(sequence.incrementAndGet(),"audifonos,","sony","bluetooth","100"));
        add(new Productos(sequence.incrementAndGet(),"audifonos","apple", "inalambricos","500"));
    }};

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
        nuevoproducto.setId(sequence.incrementAndGet());
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
