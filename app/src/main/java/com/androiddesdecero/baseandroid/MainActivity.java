package com.androiddesdecero.baseandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.androiddesdecero.baseandroid.base.BaseCallback;
import com.androiddesdecero.baseandroid.data.request.CrearCursoRequest;
import com.androiddesdecero.baseandroid.data.response.CrearCursoResponse;
import com.androiddesdecero.baseandroid.model.usecase.CrearCursoUseCase;
import com.androiddesdecero.baseandroid.model.usecase.GetCursosArrayUseCase;
import com.androiddesdecero.baseandroid.model.usecase.GetCursosUseCase;
import com.androiddesdecero.baseandroid.model.usecase.GetTokenLogin;
import com.androiddesdecero.baseandroid.model.usecase.model.Curso;
import com.androiddesdecero.baseandroid.util.MessageParser;

import java.util.List;

import static com.androiddesdecero.baseandroid.util.MessageParser.ERROR_GET_TOKEN;

public class MainActivity extends AppCompatActivity {

    GetTokenLogin getTokenLogin = new GetTokenLogin();
    GetCursosUseCase getCursosUseCase = new GetCursosUseCase();
    GetCursosArrayUseCase getCursosArrayUseCase = new GetCursosArrayUseCase();
    CrearCursoUseCase crearCursoUseCase = new CrearCursoUseCase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getData("s");
        //getCursos();
        //getCursosArray();
        crearCurso();
    }

    private void crearCurso(){
        BaseCallback callback = new BaseCallback(){

            @Override
            public void onSuccess(Object o, int httpCode) {
                Log.d("TAG1", "1" + httpCode + " " + "Creado correctamente");

            }

            @Override
            public void onError(Bundle errorInfo, Integer httpCode) {
                Log.d("TAG1", "1" + httpCode + " " + "No Creado correctamente");

            }

            @Override
            public void always() {

            }
        };
        CrearCursoRequest crearCursoRequest = new CrearCursoRequest();
        crearCursoRequest.setNombre("Curso Dagger22222");
        crearCursoRequest.setProfesor_id("8");
        startCrearCurso(crearCursoRequest, callback);
    }

    public void startCrearCurso(CrearCursoRequest cursoRequest, BaseCallback callback){
        crearCursoUseCase.getData(cursoRequest, callback);
    }

    private void getCursosArray(){
        BaseCallback callback = new BaseCallback<List<Curso>>() {
            @Override
            public void onSuccess(List<Curso> cursos, int httpCode) {
                Log.d("TAG1", "1" + httpCode + " " + cursos.get(0).getNombre());

            }

            @Override
            public void onError(Bundle errorInfo, Integer httpCode) {
                Log.d("TAG1", "100" + "ERROR");

            }

            @Override
            public void always() {
                Log.d("TAG1", "1" + "always");

            }
        };
        startGetCursoArrayData(callback);
    }

    public void startGetCursoArrayData(BaseCallback callback){
        getCursosArrayUseCase.getData(callback);
    }

    private void getCursos(){
        BaseCallback callback = new BaseCallback<List<Curso>>() {
            @Override
            public void onSuccess(List<Curso> cursos, int httpCode) {
                Log.d("TAG1", "1" + httpCode + " " + cursos.get(0).getNombre());

            }

            @Override
            public void onError(Bundle errorInfo, Integer httpCode) {
                Log.d("TAG1", "100" + "ERROR");

            }

            @Override
            public void always() {
                Log.d("TAG1", "1" + "always");

            }
        };
        startGetCursoData(callback);
    }

    public void startGetCursoData(BaseCallback callback){
        getCursosUseCase.getData(callback);
    }

    private void getData(String user){
        BaseCallback callback = new BaseCallback() {
            @Override
            public void onSuccess(Object o, int httpCode) {
                Log.d("TAG1", "1" + httpCode + " " + o.toString());
            }

            @Override
            public void onError(Bundle errorInfo, Integer httpCode) {
                Log.d("TAG1", "100" + " ERROR: " + errorInfo.getString(MessageParser.BUNDLE_TYPE));

            }

            @Override
            public void always() {
                Log.d("TAG1", "1" + "always");

            }
        };
        startGetData(user, callback);
    }

    public void startGetData(String user, BaseCallback callback){
        getTokenLogin.getData(user, callback);
    }
}


/*
1.- Configurar Gradle
    -> Librerías Dagger y Retrofit
    -> Configurar productFlavors mock, qa, pro
2.- Configurar en Projects
    -> añadir ficheros de mock, qa y pro.
3.- Dagger
4.- BaseApplication, BaseActivity, BaseCallback, BaseMapper
5.- data->Api->Retrofit
6-> Repository, data repository y mockdatarepository
7.-> BaseMapper
8->Response
9-> mapper
10-> UseCase

 */
/*
Nuevo Caso de Uso
1.- Creamos UseCase ejemplo GetCursoUseCase
2.- DataRepository añadimos void getCurso(BaseCallbac callback);
3.- Añadimos método getCurso(BaseCallback callback) a MockDataRepository y el resto de repositorios.
4.- Añadimos json, de respuesta mocketada
5.- Creamos CursosMapper
6.- Creamos CursoResponse
 */