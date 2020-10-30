package com.example.cronometrocountdowtimeraleman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

public class CronosEntrenar extends AppCompatActivity {

    //Variable final que marcará la cantidad de la cuenta regresiva
    private static final long START_TIME_IN_MILLIS45 = 45000; //45 SEGUNDOS, EN MILI Segundos
    private static final long START_TIME_IN_MILLIS15 = 15000; //15 SEGUNDOS, EN MILI Segundos

    //Variables que servirán para operar y asignar a los elementos de la activity
    private TextView mTextViewCountDown45;
    private TextView mTextViewCountDown15;
    private TextView mTextViewSerie;
    private int numSerie = 1;
    private Button mButtonStart;
    private Button mButtonPause;
    private Button mButtonStop;
    private Button mButtonResetTrainning;
    private static CheckBox mEjercicio1;
    private static CheckBox mEjercicio2;
    private static CheckBox mEjercicio3;
    private static CheckBox mEjercicio4;
    private static CheckBox mEjercicio5;
    private static CheckBox mEjercicio6;
    private static CheckBox mEjercicio7;
    private static CheckBox mEjercicio8;
    private static CheckBox mEjercicio9;
    private static CheckBox mEjercicio10;
    private static CheckBox mEjercicio11;
    private static CheckBox mEjercicio12;
    private Set<String> ejerciciosSuperiores;
    private Set<String> ejerciciosCardio;
    private ArrayList<String> ejerciciosMarcados;
    private ArrayList<CheckBox> checkBoxes;
    private int num = 0; //Para incrementar el número al recorrer los checkboxes


    //Variable que contará regresivamente
    private CountDownTimer mCountDownTimer45;
    private CountDownTimer mCountDownTimer15;

     //Variable que marcará el contenido de la cuenta atras
    private long mTimeLeftInMillis45 = START_TIME_IN_MILLIS45;
    private long mTimeLeftInMillis15 = START_TIME_IN_MILLIS15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronos);

        checkBoxes = new ArrayList<>();
        //
        ejerciciosSuperiores = new LinkedHashSet<>();
        ejerciciosCardio = new LinkedHashSet<>();
        ejerciciosMarcados = new ArrayList<>();
        //

        //Enlazamos las variables creadas con elementos del layout
        mTextViewCountDown45 = findViewById(R.id.tv_countown45);
        mTextViewCountDown15 = findViewById(R.id.tv_countown15);
        mTextViewSerie = findViewById(R.id.tv_numero_serie);
        mButtonStart = findViewById(R.id.btn_start);
        mButtonPause = findViewById(R.id.btn_pause);
        mButtonStop = findViewById(R.id.btn_stop);
        mButtonResetTrainning = findViewById(R.id.btn_restart);

        checkBoxes.add(mEjercicio1 = findViewById(R.id.cb1));
        checkBoxes.add(mEjercicio2 = findViewById(R.id.cb2));
        checkBoxes.add(mEjercicio3 = findViewById(R.id.cb3));
        checkBoxes.add(mEjercicio4 = findViewById(R.id.cb4));
        checkBoxes.add(mEjercicio5 = findViewById(R.id.cb5));
        checkBoxes.add(mEjercicio6 = findViewById(R.id.cb6));
        checkBoxes.add(mEjercicio7 = findViewById(R.id.cb7));
        checkBoxes.add(mEjercicio8 = findViewById(R.id.cb8));
        checkBoxes.add(mEjercicio9 = findViewById(R.id.cb9));
        checkBoxes.add(mEjercicio10 = findViewById(R.id.cb10));
        checkBoxes.add(mEjercicio11 = findViewById(R.id.cb11));
        checkBoxes.add(mEjercicio12 = findViewById(R.id.cb12));

        cargarPreferencias();


        //Recepcionamos el bundle envíado desde el MainActivity
        Bundle informacion = getIntent().getExtras();

        /*if(informacion != null){
            ejerciciosSuperiores = informacion.getStringArrayList("ejerciciosSuperiores");
            ejerciciosCardio = informacion.getStringArrayList("ejerciciosCardio");
        }*/


        for(String ejercicio : ejerciciosSuperiores){
            checkBoxes.get(num).setVisibility(View.VISIBLE);
            checkBoxes.get(num).setText(ejercicio);
            num++;
        }

        for(String ejercicio : ejerciciosCardio){
            checkBoxes.get(num).setVisibility(View.VISIBLE);
            checkBoxes.get(num).setText(ejercicio);
            num++;
        }

        /*for(int i = 0; i < ejerciciosSuperiores.size(); i++){
            checkBoxes.get(num).setVisibility(View.VISIBLE);
            checkBoxes.get(num).setText(ejerciciosSuperiores.);
            num++;
        }*/


        /*for(int i = 0; i < ejerciciosCardio.size(); i++){
            checkBoxes.get(num).setVisibility(View.VISIBLE);
            checkBoxes.get(num).setText(ejerciciosCardio.get(i));
            num++;
        }*/



        //Creamos las variables para recoger la información de tipo String cada bundle envíado.

        /*String ObtenerNombre1 = informacion.getString("NombreEjercicio1"); //El fallo cuando pulsamos el boton A ENTRENAR dice que es aqui
        String ObtenerNombre2 = informacion.getString("NombreEjercicio2");
        String ObtenerNombre3 = informacion.getString("NombreEjercicio3");
        String ObtenerNombre4 = informacion.getString("NombreEjercicio4");
        String ObtenerNombre5 = informacion.getString("NombreEjercicio5");
        String ObtenerNombre6 = informacion.getString("NombreEjercicio6");

        //Recogemos en otro bundle la información enviada de tipo boolean
        boolean ejercio1Check = informacion.getBoolean("ejercicio1Check");
        boolean ejercio2Check = informacion.getBoolean("ejercicio2Check");
        boolean ejercio3Check = informacion.getBoolean("ejercicio3Check");
        boolean ejercio4Check = informacion.getBoolean("ejercicio4Check");
        boolean ejercio5Check = informacion.getBoolean("ejercicio5Check");
        boolean ejercio6Check = informacion.getBoolean("ejercicio6Check");*/


        //Si el ejercicio es distinto de null (se ha envíado al menos uno) que ponga los textos de los strings
        /*if(ObtenerNombre1 != null){
            //Si ejercicio1Check fue seleccionado, que recoja la información del string del bundle y lo haga visible
            if(ejercio1Check == true){
                mEjercicio1.setVisibility(View.VISIBLE);
                mEjercicio1.setText(ObtenerNombre1);
            //Sino fue seleccionado la visibilidad la pone "GONE" quiere decir que no mostrará nada (ya que no se seleccionó)
            }else {
                mEjercicio1.setVisibility(View.GONE);
            }

            if(ejercio2Check == true){
                mEjercicio2.setVisibility(View.VISIBLE);
                mEjercicio2.setText(ObtenerNombre2);
            }else {
                mEjercicio2.setVisibility(View.GONE);
            }

            if(ejercio3Check == true){
                mEjercicio3.setVisibility(View.VISIBLE);
                mEjercicio3.setText(ObtenerNombre3);
            }else {
                mEjercicio3.setVisibility(View.GONE);
            }

            if(ejercio4Check == true){
                mEjercicio4.setVisibility(View.VISIBLE);
                mEjercicio4.setText(ObtenerNombre4);
            }else {
                mEjercicio4.setVisibility(View.GONE);
            }

            if(ejercio5Check == true){
                mEjercicio5.setVisibility(View.VISIBLE);
                mEjercicio5.setText(ObtenerNombre5);
            }else {
                mEjercicio5.setVisibility(View.GONE);
            }

            if(ejercio6Check == true){
                mEjercicio6.setVisibility(View.VISIBLE);
                mEjercicio6.setText(ObtenerNombre6);
            }else {
                mEjercicio6.setVisibility(View.GONE);
            }

        }*/


        //Creamos funcionalidad al botón start
        mButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer45();

            }
        });

        //Creamos funcionalidad al boton pause
        mButtonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseTimer45();
                pauseTimer15();
            }
        });

        //Creamos funcionalidad al boton stop
        mButtonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseTimer45();
                pauseTimer15();
                resetTimer45();
                resetTimer15();
                reseteoSeries();
            }
        });

        mButtonResetTrainning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reseteoEntrenamiento();
            }
        });

        //Actulizamos el crono si le damos a stop
        updateCountDownText45();
        updateCountDownText15();

    } //llave de cierre del metodo onCreate

    private void cargarPreferencias() {
        SharedPreferences preferencias = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        ejerciciosSuperiores = preferencias.getStringSet("ejerciciosSuperiores", null);
        ejerciciosCardio = preferencias.getStringSet("ejerciciosCardio", null);
    }


    //Desarrollo de los metods invocados
    //Este método es el más importante, se instancia un objeto de tipo CountDowntimer
    private void startTimer45(){
        //pasamos por parámetro al constructor del objeto CountDownTimer la variable que es igual
        // a la variable final que guarda el tiempo asignado tambien le ponemos los intervalos segundos X1000
        mCountDownTimer45 = new CountDownTimer(mTimeLeftInMillis45, 1000) {
            //Se insertan automáticamente estos dos métodos
            @Override
            public void onTick(long millisUntilFinished) {
                //variable auxiliar que iguale a la final con el tiempo a ejecutar en milisegundos
                mTimeLeftInMillis45 = millisUntilFinished;
                //actualización de la cuenta regresiva
                updateCountDownText45();
            }

            @Override
            public void onFinish() {

                startTimer15();
            }
        }.start();
    }

    //Este método es el más importante, se instancia un objeto de tipo CountDowntimer
    private void startTimer15(){
        //pasamos por parámetro al constructor del objeto CountDownTimer la variable que es igual
        // a la variable final que guarda el tiempo asignado tambien le ponemos los intervalos segundos X1000
        mCountDownTimer15 = new CountDownTimer(mTimeLeftInMillis15, 1000) {
            //Se insertan automáticamente estos dos métodos
            @Override
            public void onTick(long millisUntilFinished) {
                //variable auxiliar que iguale a la final con el tiempo a ejecutar en milisegundos
                mTimeLeftInMillis15 = millisUntilFinished;
                //actualización de la cuenta regresiva
                updateCountDownText15();
            }

            @Override
            public void onFinish() {
                numSerie++;

                if(numSerie < 10){
                    mTextViewSerie.setText("0"+numSerie);
                }else{
                    mTextViewSerie.setText(numSerie);
                }

                //Reset de cronómetros
                pauseTimer45();
                pauseTimer15();
                resetTimer45();
                resetTimer15();

                //Iniciamos la cuenta de nuevo la cuenta
                startTimer45();
            }
        }.start();
    }


    //Aquí paramos la cuenta regresiva
    private void pauseTimer45(){
        mCountDownTimer45.cancel();
    }

    //Aquí paramos la cuenta regresiva
    private void pauseTimer15(){
        mCountDownTimer15.cancel();
    }

    //Aquí reiniciamos la cuenta regresiva
    private void resetTimer45(){
            mTimeLeftInMillis45 = START_TIME_IN_MILLIS45;
            updateCountDownText45();
    }

    //Aquí reiniciamos la cuenta regresiva
    private void resetTimer15(){
        mTimeLeftInMillis15 = START_TIME_IN_MILLIS15;
        updateCountDownText15();
    }

    //Metodo para actulizar la cuenta del crono
    private void updateCountDownText45(){
        //esta línea es para ver si son minutos, entonces la private static final long START_TIME_IN_MILLIS = sería + de 60000
        int minutes = (int) (mTimeLeftInMillis45 / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis45 / 1000) % 60;

        //ahora lo pasamos a una cadena de String
        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);

        //Esa cadena de String se la pasamos a la variable asignada para el elemento textView_countdown)
        mTextViewCountDown45.setText(timeLeftFormatted);

    }


    //Metodo para actulizar la cuenta del crono
    private void updateCountDownText15(){
        //esta línea es para ver si son minutos, entonces la private static final long START_TIME_IN_MILLIS = sería + de 60000
        int minutes15 = (int) (mTimeLeftInMillis15 / 1000) / 60;
        int seconds15 = (int) (mTimeLeftInMillis15 / 1000) % 60;

        //ahora lo pasamos a una cadena de String
        String timeLeftFormatted15 = String.format(Locale.getDefault(),"%02d:%02d", minutes15, seconds15);

        //Esa cadena de String se la pasamos a la variable asignada para el elemento textView_countdown)
        mTextViewCountDown15.setText(timeLeftFormatted15);

    }

    //Metodo para resetear el contador de series
    private void reseteoSeries(){
        numSerie = 1;
        mTextViewSerie.setText("01");
    }

    //Metodo para el reseteo de entrenamiento
    private void reseteoEntrenamiento(){

        //Que recorra los ejerciciosSuperiores y si checboxkes tiene algo que los ponga GONE
        for(int i = 0; i<ejerciciosSuperiores.size(); i++){
            if(checkBoxes != null) {
                checkBoxes.get(num).setVisibility(View.GONE);
                num++;
            }
        }

        for(int i = 0; i<ejerciciosCardio.size(); i++){
            if(checkBoxes != null) {
                checkBoxes.get(num).setVisibility(View.GONE);
                num++;
            }
        }

    }
}