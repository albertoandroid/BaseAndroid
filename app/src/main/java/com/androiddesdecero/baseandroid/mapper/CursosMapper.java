package com.androiddesdecero.baseandroid.mapper;

import com.androiddesdecero.baseandroid.base.BaseMapper;
import com.androiddesdecero.baseandroid.data.response.CursoResponse;
import com.androiddesdecero.baseandroid.model.usecase.model.Curso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by albertopalomarrobledo on 22/2/19.
 */
/*
BaseMapper<p1,p2>
p1 es la respuesta de datos que recibe del servidor. en este caso LibroResponse
p2 es lo que ha de devolver. En este caso List<Libro>
 */
public class CursosMapper extends BaseMapper<CursoResponse, List<Curso>> {
    @Override
    public List<Curso> map(CursoResponse cursoResponse) {
        List<Curso> cursos = new ArrayList<>();
        if(cursoResponse != null && cursoResponse.getCurso()!= null){
            for(CursoResponse.DataCamposCursoResponse curso :cursoResponse.getCurso()){
                Curso curso1 = new Curso();
                curso1.setCurso_id(curso.getCurso_id());
                curso1.setNombre(curso.getNombre());
                cursos.add(curso1);
            }
        }
        return cursos;
    }
}
