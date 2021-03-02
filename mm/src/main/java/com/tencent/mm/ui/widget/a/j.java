package com.tencent.mm.ui.widget.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.as;

public class j extends ProgressDialog {
    private TextView NIC = ((TextView) this.mContentView.findViewById(R.id.glf));
    private View mContentView = View.inflate(this.mContext, R.layout.bjs, null);
    private Context mContext;
    private ProgressBar olQ = ((ProgressBar) this.mContentView.findViewById(R.id.gle));

    public j(Context context) {
        super(context, R.style.a66);
        AppMethodBeat.i(159392);
        this.mContext = context;
        setCanceledOnTouchOutside(true);
        AppMethodBeat.o(159392);
    }

    public static j b(Context context, CharSequence charSequence, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(198294);
        j jVar = new j(context);
        jVar.setMessage(charSequence);
        jVar.setCancelable(z);
        jVar.setOnCancelListener(null);
        jVar.setCanceledOnTouchOutside(false);
        AppMethodBeat.o(198294);
        return jVar;
    }

    public static j b(Context context, CharSequence charSequence, boolean z) {
        AppMethodBeat.i(159394);
        j b2 = b(context, charSequence, z, null);
        b2.show();
        AppMethodBeat.o(159394);
        return b2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(159395);
        super.onCreate(bundle);
        setContentView(this.mContentView, new LinearLayout.LayoutParams(-1, -1));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        onWindowAttributesChanged(attributes);
        AppMethodBeat.o(159395);
    }

    public void setCancelable(boolean z) {
        AppMethodBeat.i(159396);
        super.setCancelable(z);
        setCanceledOnTouchOutside(z);
        AppMethodBeat.o(159396);
    }

    public void setMessage(CharSequence charSequence) {
        AppMethodBeat.i(159397);
        this.NIC.setText(charSequence);
        AppMethodBeat.o(159397);
    }

    public void show() {
        AppMethodBeat.i(159398);
        try {
            super.show();
            AppMethodBeat.o(159398);
        } catch (Exception e2) {
            as.printErrStackTrace("WeUI.WeUIProgresssDialog", e2, "", new Object[0]);
            AppMethodBeat.o(159398);
        }
    }

    public void dismiss() {
        AppMethodBeat.i(159399);
        try {
            super.dismiss();
            AppMethodBeat.o(159399);
        } catch (Exception e2) {
            as.e("WeUI.WeUIProgresssDialog", "dismiss exception, e = " + e2.getMessage(), new Object[0]);
            AppMethodBeat.o(159399);
        }
    }
}
