package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;

public final class g extends Dialog implements DialogInterface {
    private LinearLayout NIA;
    private a QAA = null;
    private Button QAB;
    private Context mContext;

    public interface a {
        void gUb();
    }

    private g(Context context) {
        super(context, R.style.a66);
        AppMethodBeat.i(180117);
        this.mContext = context;
        this.NIA = (LinearLayout) View.inflate(this.mContext, R.layout.c3k, null);
        this.QAB = (Button) this.NIA.findViewById(R.id.irn);
        ImageView imageView = (ImageView) this.NIA.findViewById(R.id.iri);
        if (LocaleUtil.isChineseAppLang()) {
            imageView.setImageResource(R.drawable.cp6);
        } else {
            imageView.setImageResource(R.drawable.cp7);
        }
        this.QAB.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.transmit.g.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(180115);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/transmit/TodoIntroduceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.grouptodo.TodoIntroduceView", "click i know");
                g.this.dismiss();
                if (g.this.QAA != null) {
                    g.this.QAA.gUb();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/transmit/TodoIntroduceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(180115);
            }
        });
        AppMethodBeat.o(180117);
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(180118);
        super.onCreate(bundle);
        setContentView(this.NIA);
        AppMethodBeat.o(180118);
    }

    public final void show() {
        AppMethodBeat.i(180119);
        try {
            super.show();
            AppMethodBeat.o(180119);
        } catch (Exception e2) {
            Log.e("MicroMsg.grouptodo.TodoIntroduceView", "%s:%s", e2.getClass().getSimpleName(), e2.getMessage());
            AppMethodBeat.o(180119);
        }
    }

    public final void dismiss() {
        AppMethodBeat.i(180120);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.tencent.mm.ui.transmit.g.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(180116);
                    g.this.dismiss();
                    AppMethodBeat.o(180116);
                }
            });
            Log.e("MicroMsg.grouptodo.TodoIntroduceView", "dialog dismiss error!");
            AppMethodBeat.o(180120);
            return;
        }
        try {
            if (this.mContext == null || !(this.mContext instanceof Activity)) {
                super.dismiss();
            } else if (!((Activity) this.mContext).isFinishing()) {
                super.dismiss();
                AppMethodBeat.o(180120);
                return;
            }
            AppMethodBeat.o(180120);
        } catch (Exception e2) {
            Log.e("MicroMsg.grouptodo.TodoIntroduceView", "dismiss exception, e = " + e2.getMessage());
            AppMethodBeat.o(180120);
        }
    }

    public static void a(Context context, a aVar) {
        AppMethodBeat.i(180121);
        g gVar = new g(context);
        gVar.QAA = aVar;
        gVar.setCancelable(false);
        gVar.show();
        AppMethodBeat.o(180121);
    }
}
