package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class t extends i implements DialogInterface {
    private ImageView OTM;
    private View jBN;
    private Context mContext;
    private TextView oBs;
    private int style;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private t(Context context, int i2, int i3) {
        super(context, i2);
        int i4 = R.layout.bah;
        AppMethodBeat.i(205240);
        this.mContext = context;
        this.style = i3;
        switch (this.style) {
            case 1:
                i4 = R.layout.bai;
                break;
            case 2:
                i4 = R.layout.bac;
                break;
        }
        this.jBN = View.inflate(this.mContext, i4, null);
        this.oBs = (TextView) this.jBN.findViewById(R.id.fm5);
        this.OTM = (ImageView) this.jBN.findViewById(R.id.dt5);
        setCanceledOnTouchOutside(true);
        AppMethodBeat.o(205240);
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(142227);
        super.onCreate(bundle);
        setContentView(this.jBN, new LinearLayout.LayoutParams(-1, -1));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        onWindowAttributesChanged(attributes);
        AppMethodBeat.o(142227);
    }

    public static t a(CharSequence charSequence, final Context context, int i2, DialogInterface.OnDismissListener onDismissListener) {
        int i3 = R.style.a6a;
        AppMethodBeat.i(205241);
        switch (i2) {
            case 1:
                i3 = R.style.a66;
                break;
        }
        final t tVar = new t(context, i3, i2);
        tVar.oBs.setText(charSequence);
        tVar.setCanceledOnTouchOutside(true);
        tVar.show();
        tVar.setOnDismissListener(onDismissListener);
        new MMHandler(Looper.getMainLooper()) {
            /* class com.tencent.mm.ui.base.t.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(142225);
                if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                    tVar.dismiss();
                    AppMethodBeat.o(142225);
                    return;
                }
                AppMethodBeat.o(142225);
            }
        }.sendEmptyMessageDelayed(0, 1000);
        AppMethodBeat.o(205241);
        return tVar;
    }

    @Override // com.tencent.mm.ui.base.i
    public final void dismiss() {
        AppMethodBeat.i(142229);
        try {
            super.dismiss();
            AppMethodBeat.o(142229);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMTipsDialog", "dismiss exception, e = " + e2.getMessage());
            AppMethodBeat.o(142229);
        }
    }
}
