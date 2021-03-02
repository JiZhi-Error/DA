package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.x;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.model.ad;
import com.tencent.mm.protocal.protobuf.cmb;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgShareToTimeLine;", "", "()V", "TAG", "", "doSetTimelineData", "", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "sessionId", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Landroid/os/Bundle;", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "IPCInvoke_ShareToTimeLine", "plugin-brandservice_release"})
public final class f {
    private static final String TAG = TAG;
    public static final f pKH = new f();

    static {
        AppMethodBeat.i(7295);
        AppMethodBeat.o(7295);
    }

    private f() {
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgShareToTimeLine$IPCInvoke_ShareToTimeLine;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
    public static final class a implements b<AppMsgDataParcelable, Bundle> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(AppMsgDataParcelable appMsgDataParcelable, d<Bundle> dVar) {
            AppMethodBeat.i(7292);
            AppMsgDataParcelable appMsgDataParcelable2 = appMsgDataParcelable;
            p.h(appMsgDataParcelable2, "data");
            p.h(dVar, "callback");
            f fVar = f.pKH;
            f.b(appMsgDataParcelable2);
            dVar.bn(new Bundle());
            AppMethodBeat.o(7292);
        }
    }

    public static void a(x xVar, com.tencent.mm.plugin.brandservice.ui.timeline.video.b bVar, String str, d<Bundle> dVar) {
        int i2;
        String str2;
        String str3;
        String str4 = null;
        AppMethodBeat.i(7293);
        p.h(xVar, "msgInfo");
        p.h(bVar, "controller");
        p.h(str, "sessionId");
        p.h(dVar, "callback");
        AppMsgDataParcelable appMsgDataParcelable = new AppMsgDataParcelable();
        appMsgDataParcelable.url = bVar.url;
        appMsgDataParcelable.sessionId = str;
        appMsgDataParcelable.pHv = xVar;
        if (bVar.cpW()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        appMsgDataParcelable.pKf = i2;
        cmb cmb = bVar.pHB;
        if (cmb != null) {
            str2 = cmb.title;
        } else {
            str2 = null;
        }
        appMsgDataParcelable.pKg = str2;
        cmb cmb2 = bVar.pHB;
        if (cmb2 != null) {
            str3 = cmb2.iAq;
        } else {
            str3 = null;
        }
        appMsgDataParcelable.pKh = str3;
        cmb cmb3 = bVar.pHB;
        if (cmb3 != null) {
            str4 = cmb3.iAo;
        }
        appMsgDataParcelable.pKi = str4;
        h.a(MainProcessIPCService.dkO, appMsgDataParcelable, a.class, dVar);
        AppMethodBeat.o(7293);
    }

    public static void b(AppMsgDataParcelable appMsgDataParcelable) {
        AppMethodBeat.i(7294);
        p.h(appMsgDataParcelable, "data");
        x xVar = appMsgDataParcelable.pHv;
        if (xVar == null) {
            Log.w(TAG, "doFav msgInfo is null");
            AppMethodBeat.o(7294);
            return;
        }
        boolean z = appMsgDataParcelable.pKf == 1;
        ad.b G = ad.aVe().G(appMsgDataParcelable.sessionId, true);
        G.l("sendAppMsgScene", 2);
        G.l("preChatName", xVar.ajO());
        G.l("preMsgIndex", Integer.valueOf(xVar.iAf));
        G.l("prePublishId", xVar.iAh);
        G.l("preUsername", xVar.ajO());
        G.l("url", appMsgDataParcelable.url);
        G.l("referUrl", appMsgDataParcelable.url);
        int i2 = xVar.iAi.type;
        if (i2 != -1) {
            G.l("_DATA_CENTER_ITEM_SHOW_TYPE", Integer.valueOf(i2));
            if (xVar.iAi.type == 5) {
                G.l("_DATA_CENTER_VID", xVar.iAi.vid);
                G.l("_DATA_CENTER_PUB_TIME", Integer.valueOf((int) xVar.iAi.time));
                G.l("_DATA_CENTER__DULATION", Integer.valueOf(xVar.iAi.iAs));
                if (z) {
                    G.l("_DATA_CENTER_DESC", appMsgDataParcelable.pKh);
                    G.l("_DATA_CENTER_COVER_URL", appMsgDataParcelable.pKi);
                } else {
                    G.l("_DATA_CENTER_DESC", xVar.iAi.iAq);
                    G.l("_DATA_CENTER_COVER_URL", xVar.iAi.iAo);
                }
                G.l("_DATA_CENTER_VIDEO_WIDTH", Integer.valueOf(xVar.iAi.videoWidth));
                G.l("_DATA_CENTER_VIDEO_HEIGHT", Integer.valueOf(xVar.iAi.videoHeight));
                G.l("_DATA_SHOW_NATIVE_PAGE", 1);
                G.l("_DATA_CENTER_FUNC_FLAG", Integer.valueOf(xVar.iwg));
            }
            G.l("_tmpl_webview_transfer_scene", 10);
        }
        AppMethodBeat.o(7294);
    }
}
