package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.ag.k;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0007J\b\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006H\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareReportDetailsStore;", "", "()V", "MAP", "Lcom/tencent/mm/algorithm/LRUMap;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareReportDetails;", "getReportDetails", "shareActionId", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "setReportDetails", "details", "plugin-appbrand-integration_release"})
public final class aa {
    private static final f<String, z> msR = new c(100);
    public static final aa msS = new aa();

    static {
        AppMethodBeat.i(228548);
        AppMethodBeat.o(228548);
    }

    private aa() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/share/ShareReportDetailsStore$init$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/message/OnAppBrandAppMessageRetransmitEvent;", "callback", "", "event", "plugin-appbrand-integration_release"})
    public static final class a extends IListener<com.tencent.mm.ag.aa> {
        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(com.tencent.mm.ag.aa aaVar) {
            k.b bVar;
            String str;
            AppMethodBeat.i(228544);
            com.tencent.mm.ag.aa aaVar2 = aaVar;
            if (aaVar2 == null || (bVar = aaVar2.iAX) == null) {
                AppMethodBeat.o(228544);
                return false;
            }
            String str2 = bVar.izn;
            if (!(str2 == null || str2.length() == 0)) {
                String str3 = bVar.izn;
                p.g(str3, "appMsgContent.appbrandShareActionId");
                z zVar = new z();
                if (e.contains(new Integer[]{2, 3}, Integer.valueOf(bVar.izk))) {
                    zVar.msM = 1;
                    zVar.msN = bVar.title;
                    zVar.msO = bVar.izh;
                    com.tencent.mm.ag.a aVar = (com.tencent.mm.ag.a) bVar.as(com.tencent.mm.ag.a.class);
                    if (aVar != null) {
                        str = aVar.imageUrl;
                    } else {
                        str = null;
                    }
                    zVar.msP = str;
                } else {
                    zVar.msM = 0;
                    zVar.msN = bVar.title;
                    zVar.msP = bVar.thumburl;
                }
                aa.a(str3, zVar);
            }
            AppMethodBeat.o(228544);
            return true;
        }
    }

    public static final void init() {
        AppMethodBeat.i(228545);
        EventCenter.instance.add(new a());
        AppMethodBeat.o(228545);
    }

    public static final z aaM(String str) {
        z zVar;
        AppMethodBeat.i(228546);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(228546);
            return null;
        }
        synchronized (msR) {
            try {
                zVar = msR.get(str);
            } finally {
                AppMethodBeat.o(228546);
            }
        }
        return zVar;
    }

    public static final void a(String str, z zVar) {
        AppMethodBeat.i(228547);
        p.h(str, "shareActionId");
        p.h(zVar, "details");
        zVar.dCC = str;
        synchronized (msR) {
            try {
                msR.put(str, zVar);
            } finally {
                AppMethodBeat.o(228547);
            }
        }
    }
}
