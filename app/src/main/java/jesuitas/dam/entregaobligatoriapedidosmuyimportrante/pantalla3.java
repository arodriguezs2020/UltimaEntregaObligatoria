package jesuitas.dam.entregaobligatoriapedidosmuyimportrante;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class pantalla3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    private String spinnerLabel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla3);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Spinner spinner = findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bar3,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_email:

            AlertDialog.Builder myAlertBuilder = new
                    AlertDialog.Builder(pantalla3.this);


            myAlertBuilder.setMessage(R.string.estas_seguro);

            myAlertBuilder.setPositiveButton(R.string._ok, new
                    DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // User clicked OK button.

                            EditText Nombre = findViewById(R.id.editText);
                            EditText Direccion = findViewById(R.id.editText2);
                            EditText Telefono = findViewById(R.id.editText3);
                            String nombre = Nombre.getText().toString();
                            String direccion = Direccion.getText().toString();
                            String telefono = Telefono.getText().toString();

                            String[] correo = {getString(R.string.pedidos_mitienda_com)};
                            String message = getString(R.string.pedido_de) + nombre;

                            Intent intent2 = getIntent();
                            String cantidadCafeSolo = intent2.getStringExtra(getString(R.string.cantidadCafeSolo));
                            String cantidadCafeConLeche = intent2.getStringExtra(getString(R.string.cantidadCafeConLeche));
                            String cantidadCafeCortado = intent2.getStringExtra(getString(R.string.cantidadCafeCortado));
                            String modoEntrega = intent2.getStringExtra(getString(R.string.modoEntrega));
                            String fecha = intent2.getStringExtra(getString(R.string._fecha));
                            String time = intent2.getStringExtra(getString(R.string.time));

                            String mensaje = getString(R.string.mi_pedido)
                                    + cantidadCafeConLeche + getString(R.string.cafes_con_leche)
                                    + cantidadCafeSolo + getString(R.string.cafes_solos)
                                    + cantidadCafeCortado + getString(R.string.cafes_cortados)
                                    + getString(R.string.la_fecha_de_entrega_es) + fecha + getString(R.string.y_la) + getString(R.string.hora_de_entrega) + time + "\n"
                                    + getString(R.string.modo_de_entrega) + modoEntrega + "\n"
                                    + getString(R.string.direccion) + direccion + "\n"
                                    + getString(R.string.numero_de_telefono) + telefono + "(" + spinnerLabel + ")";

                            Intent sendIntent = new Intent();

                            sendIntent.setAction(Intent.ACTION_SENDTO);
                            sendIntent.setData(Uri.parse(getString(R.string.mailto)));
                            sendIntent.putExtra(Intent.EXTRA_TEXT, mensaje);
                            sendIntent.putExtra(Intent.EXTRA_EMAIL, correo);
                            sendIntent.putExtra(Intent.EXTRA_SUBJECT, message);
                            startActivity(sendIntent);
                        }
                    });
            myAlertBuilder.setNegativeButton(R.string.cancelar, new
                    DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // User cancelled the dialog.
                            displayToast(getString(R.string.revise_el_pedido));
                        }
                    });

            myAlertBuilder.show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
        spinnerLabel = adapterView.getItemAtPosition(i).toString();
        displayToast(spinnerLabel);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}