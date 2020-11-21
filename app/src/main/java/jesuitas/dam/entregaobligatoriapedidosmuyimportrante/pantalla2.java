package jesuitas.dam.entregaobligatoriapedidosmuyimportrante;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

public class pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String fecha = (day_string +
                getString(R.string._barra) + month_string + getString(R.string._barra) + year_string);

        TextView t = findViewById(R.id.textView7);
        t.setText(fecha);


        int hora = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        String hour_string = Integer.toString(hora);
        String minute_string = Integer.toString(minute);
        String time = (hour_string +
                ":" + minute_string);

        TextView t2 = findViewById(R.id.textView3);
        t2.setText(time);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bar2,menu);
        return true;
    }

    public void displayToast(String text) {
        Toast.makeText(getApplicationContext(), text,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_like:

                Intent intent2 = getIntent();
                String cantidadCafeSolo = intent2.getStringExtra(getString(R.string.cantidadCafeSolo));
                String cantidadCafeConLeche = intent2.getStringExtra(getString(R.string.cantidadCafeConLeche));
                String cantidadCafeCortado  = intent2.getStringExtra(getString(R.string.cantidadCafeCortado));

                RadioButton rg = findViewById(R.id.aDomicilio);
                RadioButton rg2 = findViewById(R.id.local);
                boolean checked = rg.isChecked();
                boolean checked2 = rg2.isChecked();

                if(!checked && !checked2){
                    displayToast(getString(R.string.no_has_seleccionado_modo_de_entrega));
                } else{
                    Intent intent = new Intent(this, pantalla3.class);
                    intent.putExtra(getString(R.string.cantidadCafeSolo), cantidadCafeSolo);
                    intent.putExtra(getString(R.string.cantidadCafeConLeche), cantidadCafeConLeche);
                    intent.putExtra(getString(R.string.cantidadCafeCortado), cantidadCafeCortado);

                    if(checked){
                        RadioButton aDomicilio = findViewById(R.id.aDomicilio);
                        String adomicilio = (String) aDomicilio.getText();
                        intent.putExtra(getString(R.string.modoEntrega), adomicilio);
                    }else{
                        RadioButton Local = findViewById(R.id.local);
                        String local = (String) Local.getText();
                        intent.putExtra(getString(R.string.modoEntrega), local);
                    }

                    TextView textView = findViewById(R.id.textView7);
                    String fecha = (String) textView.getText();
                    intent.putExtra(getString(R.string.fecha), fecha);

                    TextView textView2 = findViewById(R.id.textView3);
                    String time = (String) textView2.getText();
                    intent.putExtra(getString(R.string.time), time);

                    startActivity(intent);
                    return true;
                }
        }
        return super.onOptionsItemSelected(item);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked.
        switch (view.getId()) {
            case R.id.aDomicilio:
                if (checked)
                break;
            case R.id.local:
                if (checked)
                break;
            default:
                break;
        }
    }

    public void showTimePicker(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(),getString(R.string.timePicker));
    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),getString(R.string.datePicker));
    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String fecha = ( day_string+
                getString(R.string._barra) +  month_string+ getString(R.string._barra) + year_string);
        TextView t = findViewById(R.id.textView7);
        t.setText(fecha);
    }

    public void processTimePickerResult(int hora, int minute) {
        String hour_string = Integer.toString(hora);
        String minute_string = Integer.toString(minute);
        String time = (hour_string +
                ":" + minute_string);
        TextView t2 = findViewById(R.id.textView3);
        t2.setText(time);

    }
}