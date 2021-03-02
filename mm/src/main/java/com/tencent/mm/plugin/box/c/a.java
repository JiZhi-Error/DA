package com.tencent.mm.plugin.box.c;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.e;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.box.webview.BoxWebView;
import com.tencent.mm.plugin.box.webview.b;
import com.tencent.mm.plugin.box.webview.c;
import com.tencent.mm.plugin.box.webview.d;
import com.tencent.mm.protocal.protobuf.qt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a extends e implements b {
    private qt plO;
    private FrameLayout plP;
    private d plQ;
    private BoxWebView plR;
    private b plS;

    public a(Context context, qt qtVar) {
        super(context, R.style.ft);
        this.plO = qtVar;
    }

    @Override // android.support.v7.app.e
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(76333);
        super.onCreate(bundle);
        getWindow().setLayout(-1, -1);
        getWindow().addFlags(67108864);
        getWindow().setDimAmount(0.5f);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ll, (ViewGroup) null, false);
        inflate.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.box.c.a.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(76331);
                a.this.dismiss();
                AppMethodBeat.o(76331);
                return true;
            }
        });
        setContentView(inflate, new ViewGroup.LayoutParams(-1, -1));
        this.plP = (FrameLayout) inflate.findViewById(R.id.jkn);
        this.plS = new b(this);
        this.plR = new BoxWebView(MMApplicationContext.getContext());
        this.plQ = new d(this);
        this.plR.a(new com.tencent.mm.plugin.box.webview.a(), new c(this.plO, this.plS));
        this.plR.addJavascriptInterface(this.plQ, "boxJSApi");
        Log.i("MicroMsg.Box.BoxHomeUI", "start to load url %s", this.plO.Url);
        this.plR.loadUrl(this.plO.Url);
        this.plP.addView(this.plR);
        setCancelable(true);
        setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.plugin.box.c.a.AnonymousClass2 */

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(76332);
                Log.i("MicroMsg.Box.BoxHomeUI", "dismiss dialog");
                if (a.this.plS != null) {
                    b bVar = a.this.plS;
                    if (bVar.plV != null) {
                        g.azz().a(bVar.plV);
                    }
                    g.azz().b(1869, bVar);
                }
                if (a.this.plR != null) {
                    a.this.plR.removeJavascriptInterface("boxJSApi");
                    a.this.plR.destroy();
                    a.this.plR = null;
                }
                AppMethodBeat.o(76332);
            }
        });
        getWindow().setWindowAnimations(R.style.fs);
        com.tencent.mm.plugin.box.a.a.pl(1);
        AppMethodBeat.o(76333);
    }

    @Override // com.tencent.mm.plugin.box.c.b
    public final BoxWebView ckY() {
        return this.plR;
    }

    @Override // com.tencent.mm.plugin.box.c.b
    public final com.tencent.mm.plugin.box.webview.e ckZ() {
        return this.plS;
    }

    @Override // com.tencent.mm.plugin.box.c.b
    public final d cla() {
        return this.plQ;
    }

    @Override // com.tencent.mm.plugin.box.c.b
    public final Context getActivityContext() {
        AppMethodBeat.i(76334);
        Context context = getContext();
        AppMethodBeat.o(76334);
        return context;
    }
}
