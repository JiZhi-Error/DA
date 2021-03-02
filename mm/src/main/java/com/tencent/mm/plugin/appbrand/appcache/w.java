package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Bundle;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.abd;
import com.tencent.mm.g.a.abf;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.j.a.c.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u0007H\u0002¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/PkgDownloadCDNDownloaderQualityReporter;", "", "()V", "setup", "", "cronetProfile", "Lcom/tencent/mars/cdn/CdnLogic$WebPageProfile;", "Lcom/tencent/mm/pluginsdk/res/downloader/model/NetworkResponse;", "ConstantsIDKey", "plugin-appbrand-integration_release"})
public final class w {
    public static final w kLe = new w();

    static {
        AppMethodBeat.i(227989);
        AppMethodBeat.o(227989);
    }

    private w() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/appbrand/appcache/PkgDownloadCDNDownloaderQualityReporter$setup$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/WxaPkgCDNDownloaderEventEvent;", "callback", "", "event", "plugin-appbrand-integration_release"})
    public static final class a extends IListener<abd> {
        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(abd abd) {
            abd.a aVar;
            AppMethodBeat.i(227986);
            abd abd2 = abd;
            if (x.a((abd2 == null || (aVar = abd2.eit) == null) ? null : aVar.eiu)) {
                if (abd2 == null) {
                    p.hyc();
                }
                switch (abd2.eit.event) {
                    case 1:
                        h.INSTANCE.dN(368, 74);
                        break;
                    case 2:
                        if (abd2.eit.eiv != null) {
                            m mVar = abd2.eit.eiv;
                            p.g(mVar, "event.data.response");
                            if (mVar.getStatus() == 2) {
                                h.INSTANCE.dN(368, 75);
                                w wVar = w.kLe;
                                CdnLogic.WebPageProfile b2 = w.b(abd2.eit.eiv);
                                if (b2 != null && b2.socketReused) {
                                    h.INSTANCE.dN(368, 76);
                                    break;
                                }
                            }
                        }
                        h.INSTANCE.dN(368, 77);
                        w wVar2 = w.kLe;
                        CdnLogic.WebPageProfile b3 = w.b(abd2.eit.eiv);
                        if (b3 != null && b3.socketReused) {
                            h.INSTANCE.dN(368, 78);
                            break;
                        }
                }
            }
            AppMethodBeat.o(227986);
            return false;
        }
    }

    public static final void setup() {
        AppMethodBeat.i(227988);
        EventCenter.instance.add(new a());
        EventCenter.instance.add(new b());
        AppMethodBeat.o(227988);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/appbrand/appcache/PkgDownloadCDNDownloaderQualityReporter$setup$2", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/WxaPkgPreConnectCDNEventEvent;", "callback", "", "event", "plugin-appbrand-integration_release"})
    public static final class b extends IListener<abf> {
        b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(abf abf) {
            abf.a aVar;
            CdnLogic.C2CDownloadResult c2CDownloadResult;
            CdnLogic.CronetTaskResult cronetTaskResult;
            CdnLogic.C2CDownloadResult c2CDownloadResult2;
            abf.a aVar2;
            AppMethodBeat.i(227987);
            abf abf2 = abf;
            Integer valueOf = (abf2 == null || (aVar2 = abf2.eiy) == null) ? null : Integer.valueOf(aVar2.event);
            if (valueOf != null && valueOf.intValue() == 1) {
                h.INSTANCE.dN(368, 71);
            } else if (valueOf != null && valueOf.intValue() == 2) {
                abf.a aVar3 = abf2.eiy;
                if ((aVar3 == null || (c2CDownloadResult2 = aVar3.eiz) == null || c2CDownloadResult2.httpStatusCode != 200) && ((aVar = abf2.eiy) == null || (c2CDownloadResult = aVar.eiz) == null || (cronetTaskResult = c2CDownloadResult.cronetTaskResult) == null || cronetTaskResult.statusCode != 200)) {
                    h.INSTANCE.dN(368, 73);
                } else {
                    h.INSTANCE.dN(368, 72);
                }
            }
            AppMethodBeat.o(227987);
            return false;
        }
    }

    public static final /* synthetic */ CdnLogic.WebPageProfile b(m mVar) {
        Bundle extras;
        AppMethodBeat.i(227990);
        if (mVar == null || (extras = mVar.getExtras()) == null) {
            AppMethodBeat.o(227990);
            return null;
        }
        CdnLogic.WebPageProfile webPageProfile = (CdnLogic.WebPageProfile) extras.getParcelable("RESPONSE_KEY_CRONET_PERFORMANCE");
        AppMethodBeat.o(227990);
        return webPageProfile;
    }
}
