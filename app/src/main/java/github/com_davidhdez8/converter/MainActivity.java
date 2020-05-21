package github.com_davidhdez8.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.MessageFormat;

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
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                tv_Result.setText(celsiusToFahrenheit(Double.parseDouble(et_AddNumber.getText().toString())) + " Grados Fahrenheit");
                tv_Result2.setText(celsiusToKelvin(Double.parseDouble(et_AddNumber.getText().toString())) + " Grados Kelvin");
            }
        });

        btn_Fahrenheit = findViewById(R.id.btnFahrenheit);
        btn_Fahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_Result.setText(fahrenheitToCelsius(Double.parseDouble(et_AddNumber.getText().toString())) + " Grados Celsius");
                tv_Result2.setText(fahrenheitToKelvin(Double.parseDouble(et_AddNumber.getText().toString())) + " Grados Kelvin");
            }
        });

        btn_Kelvin = findViewById(R.id.btnKelvin);
        btn_Kelvin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_Result.setText(kelvinToCelsius(Double.parseDouble(et_AddNumber.getText().toString())) + " Grados Celsius");
                tv_Result2.setText(kelvinToFahrenheit(Double.parseDouble(et_AddNumber.getText().toString())) + " Grados Fahrenheit");
            }
        });
    }

    public double celsiusToFahrenheit(double a){
        double operationFahrenheit = (a*1.8)+32;
        return operationFahrenheit;
    }

    public double celsiusToKelvin(double a){
        double operationKelvin = a + 273.15;
        return operationKelvin;
    }

    public double fahrenheitToCelsius(double a){
        double operation = (a*1.8)+32;
        return operation;
    }

    public double fahrenheitToKelvin(double a){
        double operation = (a-32)/1.8+273;
        return operation;
    }

    public double kelvinToCelsius(double a){
        double operation = a - 273.15;
        return operation;
    }

    public double kelvinToFahrenheit(double a){
        double operation = (a*1.8)-459.67;
        return operation;
    }

}
