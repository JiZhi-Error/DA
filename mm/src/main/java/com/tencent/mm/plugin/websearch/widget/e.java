package com.tencent.mm.plugin.websearch.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hr;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.widget.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.c;
import java.util.HashSet;
import java.util.Set;

public final class e {
    private static final e IIg = new e();
    Set<WidgetData> IIh = new HashSet();
    b IIi;
    boolean VC;

    static {
        AppMethodBeat.i(116644);
        AppMethodBeat.o(116644);
    }

    public static e fYV() {
        AppMethodBeat.i(116640);
        if (!MMApplicationContext.isMMProcess()) {
            RuntimeException runtimeException = new RuntimeException("can not call this out of mm process");
            AppMethodBeat.o(116640);
            throw runtimeException;
        }
        e eVar = IIg;
        AppMethodBeat.o(116640);
        return eVar;
    }

    public e() {
        AppMethodBeat.i(116641);
        g.aAi();
        this.IIi = new b(g.aAh().hqK);
        fYW();
        AppMethodBeat.o(116641);
    }

    /* access modifiers changed from: package-private */
    public final void fYW() {
        AppMethodBeat.i(116642);
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.websearch.widget.e.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(116639);
                a aVar = a.C0356a.hnM;
                c Fu = a.Fu("100458");
                if (Fu == null) {
                    Log.i("WidgetSafeModeProxyImpl", "ABTEST_LAYERID_SEARCH_WIDGET_SAFE_MODE_SWITCH item is null");
                    AppMethodBeat.o(116639);
                    return;
                }
                e.this.VC = Fu.isValid() && "1".equals(Fu.gzz().get("isOpen"));
                AppMethodBeat.o(116639);
            }
        }, "WidgetSafeModeProxyImpl");
        AppMethodBeat.o(116642);
    }

    public final void b(WidgetData widgetData, String str) {
        AppMethodBeat.i(116643);
        if (this.IIh.contains(widgetData)) {
            u.i("WidgetSafeModeProxyImpl", "widget js error appid %s, err %s", widgetData.IFG.iIA, str);
            v.pl(31);
            hr vt = new hr().vt(widgetData.IFG.iIA);
            vt.eBS = (long) widgetData.IFG.serviceType;
            vt.eMi = 20;
            vt.eMj = System.currentTimeMillis();
            vt.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).vv(str).bfK();
            com.tencent.mm.plugin.websearch.widget.a.a aVar = new com.tencent.mm.plugin.websearch.widget.a.a();
            aVar.field_appid = widgetData.IFG.iIA;
            if (this.IIi.get(aVar, new String[0])) {
                aVar.field_pkgVersion = widgetData.IFG.version;
                aVar.field_jsExceptionCount++;
                this.IIi.update(aVar, new String[0]);
                AppMethodBeat.o(116643);
                return;
            }
            aVar.field_pkgVersion = widgetData.IFG.version;
            aVar.field_jsExceptionCount = 1;
            aVar.field_beginTimestamp = System.currentTimeMillis();
            this.IIi.insert(aVar);
        }
        AppMethodBeat.o(116643);
    }
}
