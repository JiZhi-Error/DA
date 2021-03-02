package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.g;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SupportErrorDialogFragment extends DialogFragment {
    private Dialog mDialog = null;
    private DialogInterface.OnCancelListener zzap = null;

    public static SupportErrorDialogFragment newInstance(Dialog dialog) {
        AppMethodBeat.i(10966);
        SupportErrorDialogFragment newInstance = newInstance(dialog, null);
        AppMethodBeat.o(10966);
        return newInstance;
    }

    public static SupportErrorDialogFragment newInstance(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(10967);
        SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
        Dialog dialog2 = (Dialog) Preconditions.checkNotNull(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        supportErrorDialogFragment.mDialog = dialog2;
        if (onCancelListener != null) {
            supportErrorDialogFragment.zzap = onCancelListener;
        }
        AppMethodBeat.o(10967);
        return supportErrorDialogFragment;
    }

    @Override // android.support.v4.app.DialogFragment
    public void onCancel(DialogInterface dialogInterface) {
        AppMethodBeat.i(10965);
        if (this.zzap != null) {
            this.zzap.onCancel(dialogInterface);
        }
        AppMethodBeat.o(10965);
    }

    @Override // android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        AppMethodBeat.i(10964);
        if (this.mDialog == null) {
            setShowsDialog(false);
        }
        Dialog dialog = this.mDialog;
        AppMethodBeat.o(10964);
        return dialog;
    }

    @Override // android.support.v4.app.DialogFragment
    public void show(g gVar, String str) {
        AppMethodBeat.i(10968);
        super.show(gVar, str);
        AppMethodBeat.o(10968);
    }
}
