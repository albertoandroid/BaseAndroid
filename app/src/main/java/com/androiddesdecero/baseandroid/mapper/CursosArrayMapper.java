package com.androiddesdecero.baseandroid.mapper;

import com.androiddesdecero.baseandroid.base.BaseMapper;
import com.androiddesdecero.baseandroid.data.response.CursoResponse;
import com.androiddesdecero.baseandroid.data.response.CursoResponseArray;
import com.androiddesdecero.baseandroid.model.usecase.model.Curso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by albertopalomarrobledo on 22/2/19.
 */

public class CursosArrayMapper extends BaseMapper<CursoResponseArray[], List<Curso>> {

    @Override
    public List<Curso> map(CursoResponseArray[] cursoResponseArrays) {
        List<Curso> cursos = new ArrayList<>();
        if(cursoResponseArrays != null){
            for(CursoResponseArray curso :cursoResponseArrays){
                Curso curso1 = new Curso();
                curso1.setCurso_id(curso.getCurso_id());
                curso1.setNombre(curso.getNombre());
                cursos.add(curso1);
            }
        }
        return cursos;
    }
}
