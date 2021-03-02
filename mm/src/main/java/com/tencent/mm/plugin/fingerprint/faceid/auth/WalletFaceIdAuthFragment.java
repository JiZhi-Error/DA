package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class WalletFaceIdAuthFragment extends AppCompatDialogFragment {
    private Dialog mDialog;
    private a wEx;
    private Bundle wEy;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(64226);
        getDialog().requestWindowFeature(1);
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        AppMethodBeat.o(64226);
        return onCreateView;
    }

    @Override // android.support.v7.app.AppCompatDialogFragment, android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        AppMethodBeat.i(64227);
        this.mDialog = new WalletFaceIdDialog(getActivity(), this.wEx, this.wEy);
        this.mDialog.setCancelable(false);
        Dialog dialog = this.mDialog;
        AppMethodBeat.o(64227);
        return dialog;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        AppMethodBeat.i(64228);
        super.onPause();
        Log.d("MicroMsg.WalletFaceIdAuthFragment", "on pause");
        AppMethodBeat.o(64228);
    }

    @Override // android.support.v4.app.Fragment, android.support.v4.app.DialogFragment
    public void onStop() {
        AppMethodBeat.i(64229);
        super.onStop();
        Log.d("MicroMsg.WalletFaceIdAuthFragment", "on stop");
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
        AppMethodBeat.o(64229);
    }
}
