package jesuitas.dam.entregaobligatoriapedidosmuyimportrante;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int cantidadSOLO = 0;
    int cantidadCONLECHE = 0;
    int cantidadCORTADO = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bar1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_carrito:

                Intent intent = new Intent(this, pantalla2.class);
                intent.putExtra(getString(R.string.cantidadCafeSolo), String.valueOf(cantidadSOLO));
                intent.putExtra(getString(R.string.cantidadCafeConLeche), String.valueOf(cantidadCONLECHE));
                intent.putExtra(getString(R.string.cantidadCafeCortado), String.valueOf(cantidadCORTADO));
                startActivity(intent);
                return true;
            case R.id.action_delete:
                TextView cambiarTexto1 = findViewById(R.id.cantidadCafeSolo);
                TextView cambiarTexto2 = findViewById(R.id.textView4);
                TextView cambiarTexto3 = findViewById(R.id.textView5);
                cambiarTexto1.setText("0");
                cambiarTexto2.setText("0");
                cambiarTexto3.setText("0");
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    public void decremeto1(View view) {
        cantidadSOLO--;
        TextView cambiarTextodecre = findViewById(R.id.cantidadCafeSolo);
        cambiarTextodecre.setText(String.valueOf(cantidadSOLO));
    }

    public void incremento1(View view) {
        cantidadSOLO++;
        TextView cambiarTextoincre = findViewById(R.id.cantidadCafeSolo);
        cambiarTextoincre.setText(String.valueOf(cantidadSOLO));
    }
    public void decremeto2(View view) {
        cantidadCONLECHE--;
        TextView cambiarTextodecre = findViewById(R.id.textView4);
        cambiarTextodecre.setText(String.valueOf(cantidadCONLECHE));
    }

    public void incremento2(View view) {
        cantidadCONLECHE++;
        TextView cambiarTextoincre = findViewById(R.id.textView4);
        cambiarTextoincre.setText(String.valueOf(cantidadCONLECHE));
    }

    public void decremeto3(View view) {
        cantidadCORTADO--;
        TextView cambiarTextodecre = findViewById(R.id.textView5);
        cambiarTextodecre.setText(String.valueOf(cantidadCORTADO));
    }

    public void incremento3(View view) {
        cantidadCORTADO++;
        TextView cambiarTextoincre = findViewById(R.id.textView5);
        cambiarTextoincre.setText(String.valueOf(cantidadCORTADO));
    }
}