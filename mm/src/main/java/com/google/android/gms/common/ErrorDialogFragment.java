package com.google.android.gms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ErrorDialogFragment extends DialogFragment {
    private Dialog mDialog = null;
    private DialogInterface.OnCancelListener zzap = null;

    public static ErrorDialogFragment newInstance(Dialog dialog) {
        AppMethodBeat.i(10904);
        ErrorDialogFragment newInstance = newInstance(dialog, null);
        AppMethodBeat.o(10904);
        return newInstance;
    }

    public static ErrorDialogFragment newInstance(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(10905);
        ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
        Dialog dialog2 = (Dialog) Preconditions.checkNotNull(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        errorDialogFragment.mDialog = dialog2;
        if (onCancelListener != null) {
            errorDialogFragment.zzap = onCancelListener;
        }
        AppMethodBeat.o(10905);
        return errorDialogFragment;
    }

    public void onCancel(DialogInterface dialogInterface) {
        AppMethodBeat.i(10903);
        if (this.zzap != null) {
            this.zzap.onCancel(dialogInterface);
        }
        AppMethodBeat.o(10903);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AppMethodBeat.i(10902);
        if (this.mDialog == null) {
            setShowsDialog(false);
        }
        Dialog dialog = this.mDialog;
        AppMethodBeat.o(10902);
        return dialog;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        AppMethodBeat.i(10906);
        super.show(fragmentManager, str);
        AppMethodBeat.o(10906);
    }
}
