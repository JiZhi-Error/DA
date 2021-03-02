package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.i;

public final class f extends i implements View.OnClickListener {
    private View.OnClickListener Cuz;
    protected View jBN;
    private int mScene;

    private f(Context context) {
        this(context, (byte) 0);
    }

    private f(Context context, byte b2) {
        super(context, R.style.a6_);
        AppMethodBeat.i(68111);
        this.mScene = 0;
        this.jBN = View.inflate(context, R.layout.bmu, null);
        setContentView(this.jBN);
        ((Button) this.jBN.findViewById(R.id.aib)).setOnClickListener(this);
        ((Button) this.jBN.findViewById(R.id.duo)).setOnClickListener(this);
        AppMethodBeat.o(68111);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(68112);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/remittance/ui/RemittanceChargeDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (view.getId() != R.id.g3k) {
            Log.i("RemittanceChargeDialog", "click cancel");
            dismiss();
        }
        if (view.getId() == R.id.aib) {
            if (this.mScene == 1) {
                h.INSTANCE.a(12689, 11, 1);
            } else {
                h.INSTANCE.a(12689, 2, 1);
            }
        }
        a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceChargeDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(68112);
    }

    public static void a(Context context, int i2, String str, double d2) {
        AppMethodBeat.i(68113);
        Log.i("RemittanceChargeDialog", "showAlert");
        f fVar = new f(context);
        fVar.mScene = i2;
        Log.i("RemittanceChargeDialog", "showTips");
        TextView textView = (TextView) fVar.findViewById(R.id.h1u);
        if (Util.isNullOrNil(str)) {
            Log.e("RemittanceChargeDialog", "desc is null");
        } else {
            textView.setText(str);
            textView.setVisibility(0);
        }
        ((TextView) fVar.findViewById(R.id.dya)).setText(context.getResources().getString(R.string.g3j, com.tencent.mm.wallet_core.ui.f.D(d2)));
        fVar.findViewById(R.id.io_).setVisibility(0);
        fVar.findViewById(R.id.dyb).setVisibility(0);
        fVar.show();
        com.tencent.mm.ui.base.h.a(context, fVar);
        AppMethodBeat.o(68113);
    }

    public static f a(Context context, int i2, double d2, double d3, double d4, String str, View.OnClickListener onClickListener) {
        AppMethodBeat.i(68114);
        Log.i("RemittanceChargeDialog", "showCostDetail");
        f fVar = new f(context);
        fVar.mScene = i2;
        if (d2 == 0.0d) {
            Log.i("RemittanceChargeDialog", "showCostDetail ::: remian_fee = 0");
        }
        ((TextView) fVar.findViewById(R.id.h2z)).setText(com.tencent.mm.wallet_core.ui.f.D(d2));
        ((TextView) fVar.findViewById(R.id.c5g)).setText(com.tencent.mm.wallet_core.ui.f.D(d3));
        if (d4 == 0.0d) {
            Log.e("RemittanceChargeDialog", "showCostDetail ::: transaction_costs = 0");
        }
        ((TextView) fVar.findViewById(R.id.iux)).setText(com.tencent.mm.wallet_core.ui.f.D(d4));
        fVar.findViewById(R.id.h12).setVisibility(0);
        if (!Util.isNullOrNil(str)) {
            TextView textView = (TextView) fVar.findViewById(R.id.h1u);
            textView.setText(str);
            textView.setVisibility(0);
        }
        fVar.findViewById(R.id.ion).setVisibility(0);
        fVar.Cuz = onClickListener;
        fVar.findViewById(R.id.g3k).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.f.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(68110);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/remittance/ui/RemittanceChargeDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (f.this.Cuz != null) {
                    f.this.Cuz.onClick(view);
                    f.this.dismiss();
                }
                a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceChargeDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68110);
            }
        });
        fVar.show();
        com.tencent.mm.ui.base.h.a(context, fVar);
        if (i2 == 1) {
            h.INSTANCE.a(12689, 10, 1);
        } else {
            h.INSTANCE.a(12689, 1, 1);
        }
        AppMethodBeat.o(68114);
        return fVar;
    }
}
