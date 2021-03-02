package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.al;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.widget.k;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMWebView;

public class b extends k {
    public b(MMWebView mMWebView) {
        super(mMWebView, (byte) 0);
        AppMethodBeat.i(80849);
        this.JyR = new a(this, (byte) 0);
        AppMethodBeat.o(80849);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
    public boolean baG(String str) {
        AppMethodBeat.i(80850);
        boolean baG = super.baG(str);
        AppMethodBeat.o(80850);
        return baG;
    }

    class a extends k.c {
        private a() {
            super();
        }

        /* synthetic */ a(b bVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k.c
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.i(80847);
            Log.i("MicroMsg.GameFloatWebViewClient", "onServiceConnected");
            if (b.this.iGY == null) {
                Log.e("MicroMsg.GameFloatWebViewClient", "onServiceConnected, activity destroyed");
                AppMethodBeat.o(80847);
                return;
            }
            try {
                b.this.JpV = e.a.H(iBinder);
                b.this.JpV.a(b.this.JyS, b.this.iGY.hashCode());
                b.this.giq();
                b.this.a(b.this.JpV, b.this.IRi);
                b.this.ghe();
                AppMethodBeat.o(80847);
            } catch (Exception e2) {
                Log.e("MicroMsg.GameFloatWebViewClient", "addCallback fail, ex = %s", e2.getMessage());
                AppMethodBeat.o(80847);
            }
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k.c
        public final void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.i(80848);
            super.onServiceDisconnected(componentName);
            AppMethodBeat.o(80848);
        }
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
    public void ghe() {
        AppMethodBeat.i(80851);
        try {
            this.JpV.a(this.JyF, true, (Bundle) null);
        } catch (Exception e2) {
            Log.w("MicroMsg.GameFloatWebViewClient", "postBinded, jumpToActivity, ex = " + e2.getMessage());
        }
        if (bbm(this.JyF)) {
            AppMethodBeat.o(80851);
            return;
        }
        Uri parse = Uri.parse(this.JyF);
        if (parse.getScheme() == null) {
            this.JyF += HttpWrapperBase.PROTOCAL_HTTP;
            parse = Uri.parse(this.JyF);
        }
        if (parse.getScheme().startsWith("http")) {
            Log.i("MicroMsg.GameFloatWebViewClient", "uri scheme not startwith http, scheme = " + parse.getScheme());
            this.JyD = new k.a(this.JyL ? "" : this.JyF);
            this.JyL = false;
            if (!this.Jyz && !this.IRi.has(this.JyF)) {
                if (baF(this.JyF)) {
                    azM(this.JyF);
                    this.JyG = this.JyF;
                }
                av(this.JyF, false);
                AppMethodBeat.o(80851);
            } else if (!al.aYH(this.JyF)) {
                Log.f("MicroMsg.GameFloatWebViewClient", "loadInitialUrl, canLoadUrl fail, url = " + this.JyF);
                baH(this.JyF);
                AppMethodBeat.o(80851);
            } else if (baF(this.JyF)) {
                azM(this.JyF);
                AppMethodBeat.o(80851);
            } else {
                this.iGY.loadUrl(this.JyF);
                AppMethodBeat.o(80851);
            }
        } else if (!al.aYH(this.JyF)) {
            baH(this.JyF);
            AppMethodBeat.o(80851);
        } else {
            this.iGY.loadUrl(this.JyF);
            AppMethodBeat.o(80851);
        }
    }
}
