package com.tencent.mm.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class r extends ProgressDialog {
    public r(Context context, int i2) {
        super(context, i2);
    }

    public void dismiss() {
        AppMethodBeat.i(142120);
        try {
            super.dismiss();
            AppMethodBeat.o(142120);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMSafeProgressDialog", "dismiss exception, e = " + e2.getMessage());
            AppMethodBeat.o(142120);
        }
    }
}
