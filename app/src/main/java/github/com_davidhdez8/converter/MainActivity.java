package github.com_davidhdez8.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn_Celsius;
    private Button btn_Fahrenheit;
    private Button btn_Kelvin;

    private TextView tv_Result;
    private TextView tv_Result2;

    private EditText et_AddNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_Result = findViewById(R.id.tvResult);
        tv_Result2 = findViewById(R.id.tvResult2);

        et_AddNumber = findViewById(R.id.etAddNumber);
        btn_Celsius = findViewById(R.id.btnCelsius);
        btn_Celsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_Result.setText(String.format("%s Grados Fahrenheit", celsiusToFahrenheit(Float.parseFloat(et_AddNumber.getText().toString()))));
                tv_Result2.setText(String.format("%s Grados Kelvin", celsiusToKelvin(Float.parseFloat(et_AddNumber.getText().toString()))));
            }
        });

        btn_Fahrenheit = findViewById(R.id.btnFahrenheit);
        btn_Fahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_Result.setText(String.format("%s Grados Celsius", fahrenheitToCelsius(Float.parseFloat(et_AddNumber.getText().toString()))));
                tv_Result2.setText(String.format("%s Grados Kelvin", fahrenheitToKelvin(Float.parseFloat(et_AddNumber.getText().toString()))));
            }
        });

        btn_Kelvin = findViewById(R.id.btnKelvin);
        btn_Kelvin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_Result.setText(String.format("%s Grados Celsius", kelvinToCelsius(Float.parseFloat(et_AddNumber.getText().toString()))));
                tv_Result2.setText(String.format("%s Grados Fahrenheit", kelvinToFahrenheit(Float.parseFloat(et_AddNumber.getText().toString()))));
            }
        });
    }

    public float celsiusToFahrenheit(float a){
        return (float) ((a*1.8)+32);
    }

    public float celsiusToKelvin(float a){
        return (float) (a + 273.15);
    }

    public float fahrenheitToCelsius(float a){
        return (float) ((a*1.8)+32);
    }

    public float fahrenheitToKelvin(float a){
        return (float) ((a-32)/1.8+273);
    }

    public float kelvinToCelsius(float a){
        return (float) (a - 273.15);
    }

    public float kelvinToFahrenheit(float a){
        return (float) ((a*1.8)-459.67);
    }
}
