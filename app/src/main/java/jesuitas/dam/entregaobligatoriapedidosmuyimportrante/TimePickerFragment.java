package jesuitas.dam.entregaobligatoriapedidosmuyimportrante;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener{
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker.
        final Calendar c = Calendar.getInstance();
        int hora = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of DatePickerDialog and return it.
        return new TimePickerDialog(getActivity(), this, hora, minute,true);
    }
    @Override
    public void onTimeSet(TimePicker view, int hora, int minute) {
        pantalla2 activity = (pantalla2) getActivity();
        activity.processTimePickerResult(hora, minute);
    }
}
