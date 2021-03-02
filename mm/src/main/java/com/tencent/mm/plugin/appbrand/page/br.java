package com.tencent.mm.plugin.appbrand.page;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.luggage.sdk.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.page.a.e;
import com.tencent.mm.plugin.appbrand.page.bq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class br extends at implements bq {
    private ac cwK;
    private boolean kDZ = false;
    private boolean mDestroyed = false;
    private final an nqV = new an() {
        /* class com.tencent.mm.plugin.appbrand.page.br.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.page.an
        public final void cW(String str) {
            AppMethodBeat.i(147527);
            if (!br.this.nuq) {
                Log.i("Luggage.MPWebViewRenderEngineLegacyImpl", "[perf] PageFrame[%s] ready cost %dms", str, Long.valueOf(Util.currentTicks() - br.this.nuv));
            }
            br.this.nuq = true;
            super.cW(str);
            br.this.cwK.P(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.page.br.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(147526);
                    br.d(br.this);
                    AppMethodBeat.o(147526);
                }
            });
            AppMethodBeat.o(147527);
        }
    };
    private String nsu = null;
    private bq.a nup;
    private volatile boolean nuq = false;
    private boolean nur = false;
    private final LinkedList<Runnable> nus = new LinkedList<>();
    private boolean nut = false;
    private boolean nuu = false;
    private long nuv = 0;

    static /* synthetic */ void d(br brVar) {
        AppMethodBeat.i(169510);
        brVar.bSt();
        AppMethodBeat.o(169510);
    }

    br(bb bbVar) {
        super(bbVar);
        AppMethodBeat.i(147534);
        ((bc) bbVar).setAppBrandWebViewClient(this.nqV);
        bSs();
        AppMethodBeat.o(147534);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb, com.tencent.mm.plugin.appbrand.page.at
    public final void setOnTrimListener(aq aqVar) {
        AppMethodBeat.i(147536);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(147536);
        throw unsupportedOperationException;
    }

    private void bSt() {
        AppMethodBeat.i(229962);
        final LinkedList linkedList = new LinkedList(this.nus);
        this.nus.clear();
        Log.i("Luggage.MPWebViewRenderEngineLegacyImpl", "executeDeferredEvaluations %s size %d, hash[%d]", this.nsu, Integer.valueOf(linkedList.size()), Integer.valueOf(hashCode()));
        c.a("executeDeferredEvaluations", new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.br.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(147529);
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
                AppMethodBeat.o(147529);
            }
        });
        AppMethodBeat.o(229962);
    }

    private void ah(Runnable runnable) {
        AppMethodBeat.i(147537);
        if (this.nuq) {
            bSt();
            runnable.run();
            AppMethodBeat.o(147537);
            return;
        }
        this.nus.addLast(runnable);
        AppMethodBeat.o(147537);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.o, com.tencent.mm.plugin.appbrand.page.at
    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(147538);
        a(null, str, valueCallback);
        AppMethodBeat.o(147538);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i, com.tencent.mm.plugin.appbrand.page.at
    public final void a(final URL url, final String str, final ValueCallback<String> valueCallback) {
        AppMethodBeat.i(229964);
        if (TextUtils.isEmpty(str) || this.mDestroyed) {
            if (valueCallback != null) {
                valueCallback.onReceiveValue("FATAL");
            }
            AppMethodBeat.o(229964);
            return;
        }
        m.runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.br.AnonymousClass4 */

            public final void run() {
                String str;
                AppMethodBeat.i(147530);
                if (url != null) {
                    if (br.this.cwK == null) {
                        str = null;
                    } else {
                        str = br.this.cwK.lBI;
                    }
                    Log.i("Luggage.MPWebViewRenderEngineLegacyImpl", "evaluateJavascript sourceURL:%s, componentURL:%s, componentId:%d, hash:%d", url, str, Integer.valueOf(br.this.cwK == null ? 0 : br.this.cwK.getComponentId()), Integer.valueOf(br.this.hashCode()));
                }
                br.this.a(str, valueCallback);
                AppMethodBeat.o(147530);
            }
        });
        AppMethodBeat.o(229964);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bq
    public final void a(final String str, final ValueCallback<String> valueCallback) {
        AppMethodBeat.i(147539);
        if (this.nuq) {
            this.nsV.evaluateJavascript(str, valueCallback);
            AppMethodBeat.o(147539);
            return;
        }
        this.nus.addLast(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.br.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(147531);
                br.this.nsV.evaluateJavascript(str, valueCallback);
                AppMethodBeat.o(147531);
            }
        });
        AppMethodBeat.o(147539);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bq
    public final void ag(Runnable runnable) {
        AppMethodBeat.i(147540);
        if (this.nuq) {
            bSt();
            runnable.run();
            AppMethodBeat.o(147540);
            return;
        }
        this.nus.addLast(runnable);
        AppMethodBeat.o(147540);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bq
    public final void a(bq.a aVar) {
        AppMethodBeat.i(147541);
        this.cwK = aVar.bSn();
        this.nup = aVar;
        this.nqV.cwK = this.cwK;
        this.nus.clear();
        AppMethodBeat.o(147541);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bq
    public final boolean bSg() {
        return this.nut;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bq
    public final boolean bsX() {
        return this.kDZ;
    }

    private void ip(boolean z) {
        AppMethodBeat.i(169509);
        if (!this.nur) {
            this.nuv = Util.currentTicks();
            this.nup.in(z);
            this.nur = true;
            if (z) {
                this.nut = true;
            }
        }
        AppMethodBeat.o(169509);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bq
    public final boolean bSr() {
        return this.nuq;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bq
    public final void bRA() {
        AppMethodBeat.i(147542);
        Log.i("Luggage.MPWebViewRenderEngineLegacyImpl", "dispatchPreload");
        ip(true);
        ah(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.br.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(147532);
                br.this.nup.im(true);
                br.this.kDZ = true;
                AppMethodBeat.o(147532);
            }
        });
        AppMethodBeat.o(147542);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bq
    public final void bSq() {
        AppMethodBeat.i(147543);
        this.nuu = false;
        this.nut = false;
        an anVar = this.nqV;
        String bSm = this.nup.bSm();
        this.nsu = bSm;
        anVar.nsu = bSm;
        bSs();
        Log.i("Luggage.MPWebViewRenderEngineLegacyImpl", "dispatchInit %s, mPageFrameReady %b, mPageFrameLoaded %b", this.nsu, Boolean.valueOf(this.nuq), Boolean.valueOf(this.nur));
        ip(false);
        ah(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.br.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(147533);
                br.this.nup.im(false);
                AppMethodBeat.o(147533);
            }
        });
        AppMethodBeat.o(147543);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb, com.tencent.mm.plugin.appbrand.page.at
    public final void onForeground() {
        AppMethodBeat.i(147544);
        super.onForeground();
        Og();
        AppMethodBeat.o(147544);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb, com.tencent.mm.plugin.appbrand.page.at
    public final void onBackground() {
        AppMethodBeat.i(147545);
        super.onBackground();
        AppMethodBeat.o(147545);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i, com.tencent.mm.plugin.appbrand.page.bb, com.tencent.mm.plugin.appbrand.page.at
    public final void destroy() {
        AppMethodBeat.i(147546);
        this.mDestroyed = true;
        super.destroy();
        this.nus.clear();
        AppMethodBeat.o(147546);
    }

    @Override // com.tencent.luggage.sdk.b.a.b.a.a
    public final boolean Og() {
        AppMethodBeat.i(147547);
        if (!this.nuu) {
            AppMethodBeat.o(147547);
            return false;
        }
        this.nur = false;
        this.nuq = false;
        bSq();
        ah(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.br.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(229961);
                br.this.nup.bSk();
                AppMethodBeat.o(229961);
            }
        });
        AppMethodBeat.o(147547);
        return true;
    }

    private void bSs() {
        AppMethodBeat.i(147535);
        if (this.nsV.R(e.class) != null) {
            AppMethodBeat.o(147535);
            return;
        }
        this.nsV.setOnTrimListener(new aq() {
            /* class com.tencent.mm.plugin.appbrand.page.br.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.page.aq
            public final boolean bSa() {
                AppMethodBeat.i(147528);
                boolean z = br.this.nup != null && br.this.nup.bSl();
                if (z) {
                    br.g(br.this);
                }
                AppMethodBeat.o(147528);
                return z;
            }
        });
        AppMethodBeat.o(147535);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb, com.tencent.mm.plugin.appbrand.page.at
    public final void setAppBrandInfo(Map<String, String> map) {
        AppMethodBeat.i(229963);
        this.nsV.setAppBrandInfo(map);
        AppMethodBeat.o(229963);
    }

    static /* synthetic */ void g(br brVar) {
        AppMethodBeat.i(169511);
        Log.i("Luggage.MPWebViewRenderEngineLegacyImpl", "[wxa_reload]dispatchTrimmed %s", brVar.nsu);
        brVar.nuu = true;
        brVar.nuq = false;
        brVar.nur = false;
        brVar.nut = false;
        brVar.kDZ = false;
        brVar.nsV.setOnTrimListener(null);
        brVar.nus.clear();
        AppMethodBeat.o(169511);
    }
}
