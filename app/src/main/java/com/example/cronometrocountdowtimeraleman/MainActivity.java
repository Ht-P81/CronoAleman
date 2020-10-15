package com.example.cronometrocountdowtimeraleman;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

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

    //Variable que contará regresivamente
    private CountDownTimer mCountDownTimer45;
    private CountDownTimer mCountDownTimer15;

     //Variable que marcará el contenido de la cuenta atras
    private long mTimeLeftInMillis45 = START_TIME_IN_MILLIS45;
    private long mTimeLeftInMillis15 = START_TIME_IN_MILLIS15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Enlazamos las variables creadas con elementos del layout
        mTextViewCountDown45 = findViewById(R.id.text_view_countown45);
        mTextViewCountDown15 = findViewById(R.id.text_view_countown15);
        mTextViewSerie = findViewById(R.id.tv_serie);
        mButtonStart = findViewById(R.id.button_start);
        mButtonPause = findViewById(R.id.button_pause);
        mButtonStop = findViewById(R.id.button_stop);

        //Creamos funcionalidad al botón start
        mButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer45();
                //startTimer15();

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
            }
        });

        //Actulizamos el crono si le damos a stop
        updateCountDownText45();
        updateCountDownText15();

    } //llave de cierre del metodo onCreate


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
}