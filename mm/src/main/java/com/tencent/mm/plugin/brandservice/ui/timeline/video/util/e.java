package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.x;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.webview.model.c;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.cmb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgFav;", "", "()V", "TAG", "", "doFav", "", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "IPCInvoke_Fav", "plugin-brandservice_release"})
public final class e {
    private static final String TAG = TAG;
    public static final e pKG = new e();

    static {
        AppMethodBeat.i(7291);
        AppMethodBeat.o(7291);
    }

    private e() {
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgFav$IPCInvoke_Fav;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
    public static final class a implements b<AppMsgDataParcelable, Bundle> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(AppMsgDataParcelable appMsgDataParcelable, d<Bundle> dVar) {
            AppMethodBeat.i(7288);
            AppMsgDataParcelable appMsgDataParcelable2 = appMsgDataParcelable;
            p.h(appMsgDataParcelable2, "data");
            p.h(dVar, "callback");
            e eVar = e.pKG;
            e.a(appMsgDataParcelable2);
            AppMethodBeat.o(7288);
        }
    }

    public static void a(x xVar, com.tencent.mm.plugin.brandservice.ui.timeline.video.b bVar) {
        int i2;
        String str;
        String str2;
        String str3;
        AppMethodBeat.i(7289);
        p.h(xVar, "msgInfo");
        p.h(bVar, "controller");
        AppMsgDataParcelable appMsgDataParcelable = new AppMsgDataParcelable();
        appMsgDataParcelable.url = bVar.url;
        appMsgDataParcelable.pHv = xVar;
        if (bVar.cpW()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        appMsgDataParcelable.pKf = i2;
        cmb cmb = bVar.pHB;
        if (cmb != null) {
            str = cmb.title;
        } else {
            str = null;
        }
        appMsgDataParcelable.pKg = str;
        cmb cmb2 = bVar.pHB;
        if (cmb2 != null) {
            str2 = cmb2.iAq;
        } else {
            str2 = null;
        }
        appMsgDataParcelable.pKh = str2;
        cmb cmb3 = bVar.pHB;
        if (cmb3 != null) {
            str3 = cmb3.iAo;
        } else {
            str3 = null;
        }
        appMsgDataParcelable.pKi = str3;
        h.a(MainProcessIPCService.dkO, appMsgDataParcelable, a.class, null);
        AppMethodBeat.o(7289);
    }

    public static void a(AppMsgDataParcelable appMsgDataParcelable) {
        boolean z;
        AppMethodBeat.i(7290);
        p.h(appMsgDataParcelable, "data");
        x xVar = appMsgDataParcelable.pHv;
        if (xVar == null) {
            Log.w(TAG, "doFav msgInfo is null");
            AppMethodBeat.o(7290);
            return;
        }
        if (appMsgDataParcelable.pKf == 1) {
            z = true;
        } else {
            z = false;
        }
        cz czVar = new cz();
        c.a aVar = new c.a();
        aVar.url = appMsgDataParcelable.url;
        aVar.IXu = new amt();
        aVar.IXu.iwe = 1;
        aVar.IXu.iwc = xVar.iAi.type;
        aVar.IXu.vid = xVar.iAi.vid;
        aVar.IXu.videoWidth = xVar.iAi.videoWidth;
        aVar.IXu.videoHeight = xVar.iAi.videoHeight;
        aVar.IXu.duration = xVar.iAi.iAs;
        aVar.IXu.iwd = (int) xVar.iAi.time;
        aVar.IXu.iwg = xVar.iwg;
        if (Util.isNullOrNil(xVar.dHc)) {
            aVar.IXu.dHc = xVar.ajO();
            aVar.IXu.iAg = aa.getDisplayName(xVar.ajO());
        } else {
            aVar.IXu.dHc = xVar.dHc;
            aVar.IXu.iAg = xVar.iAg;
        }
        if (z) {
            aVar.thumbUrl = appMsgDataParcelable.pKi;
            aVar.title = appMsgDataParcelable.pKg;
            aVar.desc = appMsgDataParcelable.pKh;
        } else {
            aVar.thumbUrl = xVar.iAi.iAo;
            aVar.title = xVar.iAi.title;
            aVar.desc = xVar.iAi.iAq;
        }
        aVar.IXu.iAo = aVar.thumbUrl;
        ad.b G = ad.aVe().G(ad.JX(Util.nullAsNil(xVar.iAh)), true);
        if (G == null) {
            p.hyc();
        }
        G.l("sendAppMsgScene", 2);
        G.l("preChatName", xVar.ajO());
        G.l("preMsgIndex", Integer.valueOf(xVar.iAf));
        G.l("prePublishId", xVar.iAh);
        G.l("preUsername", xVar.ajO());
        G.l("referUrl", appMsgDataParcelable.url);
        czVar.dFZ.dGf = 36;
        c.a(czVar, aVar);
        EventCenter.instance.publish(czVar);
        AppMethodBeat.o(7290);
    }
}
