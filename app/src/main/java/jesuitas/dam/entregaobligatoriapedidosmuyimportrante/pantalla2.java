package jesuitas.dam.entregaobligatoriapedidosmuyimportrante;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class pantalla2 extends AppCompatActivity {

    public static final int TEXT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bar2,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_carrito:

                Intent intent = new Intent(this, pantalla2.class);
                intent.putExtra("cantidadCafeSolo", R.id.cantidadCafeSolo);
                intent.putExtra("cantidadCafeConLeche", R.id.textView4);
                intent.putExtra("cantidadCafeCortado", R.id.textView5);
                startActivityForResult(intent, TEXT_REQUEST);
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

}