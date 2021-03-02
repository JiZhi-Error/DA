package com.tencent.mm.plugin.game.luggage.g;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.e;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.f.h;
import com.tencent.luggage.d.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class f extends i {
    public MMActivity pQZ;
    public Map<String, i> xxQ = new ConcurrentHashMap();
    Map<String, Integer> xxR = new ConcurrentHashMap();
    public a xxS;
    public FrameLayout xxT;
    public View xxU;
    public i xxV;
    private String xxW;
    private Dialog xxX;

    public interface a {
        boolean Lw();

        void Oa(int i2);

        void Ob(int i2);

        int dTE();

        String dTF();

        void setPageChanging(boolean z);
    }

    static /* synthetic */ void a(f fVar, String str) {
        AppMethodBeat.i(186951);
        fVar.ed(str, 2);
        AppMethodBeat.o(186951);
    }

    public f(j jVar, Bundle bundle) {
        super(jVar, null, bundle);
        AppMethodBeat.i(186939);
        if (this.mContext instanceof MMActivity) {
            this.pQZ = (MMActivity) this.mContext;
        }
        String string = bundle.getString("game_tab_key");
        if (!Util.isNullOrNil(string)) {
            this.xxQ.put(string, this);
        }
        this.xxV = this;
        this.xyT = this;
        a((i) this, string);
        if (gbC() != null) {
            gbC().gbW();
        }
        this.xxW = bundle.getString("game_pre_inject_data");
        this.mParams.remove("game_pre_inject_data");
        if (this.xxX == null) {
            this.xxX = new e(this.mContext, R.style.ku);
            this.xxX.setCanceledOnTouchOutside(true);
        }
        AppMethodBeat.o(186939);
    }

    public final void setPageChanging(boolean z) {
        AppMethodBeat.i(186940);
        if (this.xxS != null) {
            this.xxS.setPageChanging(z);
        }
        AppMethodBeat.o(186940);
    }

    @Override // com.tencent.mm.plugin.game.luggage.g.i, com.tencent.luggage.d.h, com.tencent.luggage.d.s, com.tencent.mm.plugin.webview.luggage.g
    public final View Lf() {
        AppMethodBeat.i(186941);
        View Lf = super.Lf();
        this.xxU = Lf;
        this.xxT = new FrameLayout(this.mContext);
        this.xxT.addView(Lf, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout = this.xxT;
        AppMethodBeat.o(186941);
        return frameLayout;
    }

    @Override // com.tencent.mm.plugin.game.luggage.g.i, com.tencent.luggage.d.h, com.tencent.mm.plugin.webview.luggage.g
    public final void onForeground() {
        AppMethodBeat.i(186942);
        if (this.xxV == null) {
            AppMethodBeat.o(186942);
            return;
        }
        ed(b(this.xxV), 1);
        if (this.xxV instanceof f) {
            Log.i("MicroMsg.GameTabWebPage", "GameTabWebPage onForeground, url:%s", this.xxV.coX());
            super.onForeground();
        } else {
            Log.i("MicroMsg.GameTabWebPage", "onForeground, url:%s", this.xxV.coX());
            this.xxV.Li();
        }
        if (this.xxX != null) {
            this.xxX.show();
        }
        h.RTc.n(new Runnable() {
            /* class com.tencent.mm.plugin.game.luggage.g.f.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(186936);
                if (f.this.xxX != null) {
                    f.this.xxX.dismiss();
                }
                AppMethodBeat.o(186936);
            }
        }, 50);
        AppMethodBeat.o(186942);
    }

    @Override // com.tencent.mm.plugin.game.luggage.g.i, com.tencent.luggage.d.h, com.tencent.mm.plugin.webview.luggage.g
    public final void onBackground() {
        AppMethodBeat.i(186943);
        if (this.xxV == null) {
            AppMethodBeat.o(186943);
        } else if (this.xxV instanceof f) {
            Log.i("MicroMsg.GameTabWebPage", "GameTabWebPage onBackground, url:%s", this.xxV.coX());
            super.onBackground();
            a((i) this);
            AppMethodBeat.o(186943);
        } else {
            Log.i("MicroMsg.GameTabWebPage", "onBackground, url:%s", this.xxV.coX());
            this.xxV.Lj();
            a(this.xxV);
            AppMethodBeat.o(186943);
        }
    }

    @Override // com.tencent.luggage.d.h, com.tencent.luggage.d.s
    public final void destroy() {
        AppMethodBeat.i(186944);
        super.destroy();
        for (i iVar : this.xxQ.values()) {
            if (iVar != null && !(iVar instanceof f)) {
                iVar.destroy();
            }
        }
        this.xxQ.clear();
        AppMethodBeat.o(186944);
    }

    @Override // com.tencent.mm.plugin.game.luggage.g.i, com.tencent.luggage.d.h, com.tencent.mm.plugin.webview.luggage.g
    public final void onDestroy() {
        AppMethodBeat.i(186945);
        Log.i("MicroMsg.GameTabWebPage", "onDestroy");
        if (this.xxX != null) {
            this.xxX.dismiss();
            this.xxX = null;
        }
        super.onDestroy();
        AppMethodBeat.o(186945);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.game.luggage.g.i
    public final String dTC() {
        return this.xxW;
    }

    /* access modifiers changed from: package-private */
    public final String b(i iVar) {
        AppMethodBeat.i(186947);
        if (iVar == null) {
            AppMethodBeat.o(186947);
            return "";
        }
        for (Map.Entry<String, i> entry : this.xxQ.entrySet()) {
            if (iVar == entry.getValue()) {
                String key = entry.getKey();
                AppMethodBeat.o(186947);
                return key;
            }
        }
        AppMethodBeat.o(186947);
        return "";
    }

    public final void a(final i iVar, final String str) {
        AppMethodBeat.i(186948);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(186948);
            return;
        }
        iVar.xza = new i.a() {
            /* class com.tencent.mm.plugin.game.luggage.g.f.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.game.luggage.g.i.a
            public final void dTD() {
                AppMethodBeat.i(186938);
                f.this.mHandler.postUI(new Runnable() {
                    /* class com.tencent.mm.plugin.game.luggage.g.f.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        int i2;
                        String str;
                        AppMethodBeat.i(186937);
                        Object[] objArr = new Object[1];
                        f fVar = f.this;
                        if (fVar.xxS != null) {
                            i2 = fVar.xxS.dTE();
                        } else {
                            i2 = 0;
                        }
                        objArr[0] = Integer.valueOf(i2);
                        String format = String.format("javascript:(function(){ window.wgclient = window.wgclient || {}; window.wgclient.__gameTabHeight__= %d; })()", objArr);
                        Log.i("MicroMsg.GameTabWebPage", "tabKey:%s, jsStr_1:%s", str, format);
                        iVar.cT(format);
                        Object[] objArr2 = new Object[1];
                        f fVar2 = f.this;
                        if (fVar2.xxS != null) {
                            str = fVar2.xxS.dTF();
                        } else {
                            str = "";
                        }
                        objArr2[0] = str;
                        String format2 = String.format("javascript:(function(){ window.wgclient = window.wgclient || {}; window.wgclient.__gameTabInfo__= %s; })()", objArr2);
                        Log.i("MicroMsg.GameTabWebPage", "tabKey:%s, jsStr_2:%s", str, format2);
                        iVar.cT(format2);
                        f.a(f.this, str);
                        AppMethodBeat.o(186937);
                    }
                });
                AppMethodBeat.o(186938);
            }
        };
        AppMethodBeat.o(186948);
    }

    /* access modifiers changed from: package-private */
    public final void ed(String str, int i2) {
        AppMethodBeat.i(186949);
        Integer num = this.xxR.get(str);
        if (num == null) {
            this.xxR.put(str, Integer.valueOf(i2));
        } else {
            this.xxR.put(str, Integer.valueOf(num.intValue() | i2));
        }
        azI(str);
        AppMethodBeat.o(186949);
    }

    private void azI(String str) {
        AppMethodBeat.i(186950);
        if (Util.isNullOrNil(str) || !this.xxR.containsKey(str) || !this.xxQ.containsKey(str)) {
            AppMethodBeat.o(186950);
            return;
        }
        if (this.xxR.get(str).intValue() == 3) {
            this.xxR.put(str, 4);
            this.xxQ.get(str).cT("javascript:(function(){ window.__gameTabFirstShow__= 1; })()");
            Log.i("MicroMsg.GameTabWebPage", "injectTabFirstShow, tabKey:%s", str);
        }
        AppMethodBeat.o(186950);
    }

    private static void a(i iVar) {
        AppMethodBeat.i(186946);
        if (iVar.ITi.isShown()) {
            iVar.zc(false);
        }
        AppMethodBeat.o(186946);
    }
}
