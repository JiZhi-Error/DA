package android.support.v7.app;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class AppCompatDialogFragment extends DialogFragment {
    @Override // android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        return new e(getContext(), getTheme());
    }

    @Override // android.support.v4.app.DialogFragment
    public void setupDialog(Dialog dialog, int i2) {
        if (dialog instanceof e) {
            e eVar = (e) dialog;
            switch (i2) {
                case 1:
                case 2:
                    break;
                default:
                    return;
                case 3:
                    dialog.getWindow().addFlags(24);
                    break;
            }
            eVar.gR();
            return;
        }
        super.setupDialog(dialog, i2);
    }
}
