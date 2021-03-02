package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.x;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cmb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J6\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u001e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgTransmit;", "", "()V", "TAG", "", "doSendAppMsg", "", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "", "toUser", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "appendText", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Landroid/os/Bundle;", "transmitBizVideoMsg", "context", "Landroid/content/Context;", "msg", "IPCInvoke_SendAppMsg", "plugin-brandservice_release"})
public final class g {
    private static final String TAG = TAG;
    public static final g pKI = new g();

    static {
        AppMethodBeat.i(7300);
        AppMethodBeat.o(7300);
    }

    private g() {
    }

    public static void a(Context context, x xVar, b bVar) {
        String str;
        String str2 = null;
        AppMethodBeat.i(7297);
        p.h(context, "context");
        p.h(xVar, "msg");
        p.h(bVar, "controller");
        HashMap hashMap = new HashMap();
        if (bVar.cpW()) {
            HashMap hashMap2 = hashMap;
            cmb cmb = bVar.pHB;
            String nullAsNil = Util.nullAsNil(cmb != null ? cmb.iAo : null);
            p.g(nullAsNil, "Util.nullAsNil(controlle…aliciousTitleInfo?.cover)");
            hashMap2.put("img_url", nullAsNil);
            HashMap hashMap3 = hashMap;
            cmb cmb2 = bVar.pHB;
            if (cmb2 != null) {
                str = cmb2.iAq;
            } else {
                str = null;
            }
            String nullAsNil2 = Util.nullAsNil(str);
            p.g(nullAsNil2, "Util.nullAsNil(controlle…liciousTitleInfo?.digest)");
            hashMap3.put("desc", nullAsNil2);
            HashMap hashMap4 = hashMap;
            cmb cmb3 = bVar.pHB;
            if (cmb3 != null) {
                str2 = cmb3.title;
            }
            String nullAsNil3 = Util.nullAsNil(str2);
            p.g(nullAsNil3, "Util.nullAsNil(controlle…aliciousTitleInfo?.title)");
            hashMap4.put("title", nullAsNil3);
        } else {
            String nullAsNil4 = Util.nullAsNil(xVar.iAi.iAo);
            p.g(nullAsNil4, "Util.nullAsNil(msg.item.cover)");
            hashMap.put("img_url", nullAsNil4);
            String nullAsNil5 = Util.nullAsNil(xVar.iAi.iAq);
            p.g(nullAsNil5, "Util.nullAsNil(msg.item.digest)");
            hashMap.put("desc", nullAsNil5);
            String nullAsNil6 = Util.nullAsNil(xVar.iAi.title);
            p.g(nullAsNil6, "Util.nullAsNil(msg.item.title)");
            hashMap.put("title", nullAsNil6);
        }
        HashMap hashMap5 = hashMap;
        String str3 = bVar.url;
        if (str3 == null) {
            p.hyc();
        }
        hashMap5.put("url", str3);
        Log.i(TAG, "transmitBizVideoMsg, img_url=%s, desc=%s, title=%s, url=%s", hashMap.get("img_url"), hashMap.get("desc"), hashMap.get("title"), bVar.url);
        h.INSTANCE.idkeyStat(157, 5, 1, false);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("scene_from", 2);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("webview_params", hashMap);
        intent.putExtra("Retr_Msg_Type", 2);
        c.c(context, ".ui.transmit.SelectConversationUI", intent, 2);
        AppMethodBeat.o(7297);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgTransmit$IPCInvoke_SendAppMsg;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
    static final class a implements com.tencent.mm.ipcinvoker.b<AppMsgDataParcelable, Bundle> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(AppMsgDataParcelable appMsgDataParcelable, d<Bundle> dVar) {
            AppMethodBeat.i(7296);
            AppMsgDataParcelable appMsgDataParcelable2 = appMsgDataParcelable;
            p.h(appMsgDataParcelable2, "data");
            p.h(dVar, "callback");
            g gVar = g.pKI;
            boolean c2 = g.c(appMsgDataParcelable2);
            Bundle bundle = new Bundle();
            bundle.putBoolean("ret", c2);
            dVar.bn(bundle);
            AppMethodBeat.o(7296);
        }
    }

    public static void a(String str, x xVar, String str2, b bVar, d<Bundle> dVar) {
        int i2;
        String str3;
        String str4;
        String str5 = null;
        AppMethodBeat.i(7298);
        p.h(str, "toUser");
        p.h(xVar, "msgInfo");
        p.h(bVar, "controller");
        p.h(dVar, "callback");
        AppMsgDataParcelable appMsgDataParcelable = new AppMsgDataParcelable();
        appMsgDataParcelable.toUser = str;
        appMsgDataParcelable.url = bVar.url;
        appMsgDataParcelable.msd = str2;
        appMsgDataParcelable.pHv = xVar;
        if (bVar.cpW()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        appMsgDataParcelable.pKf = i2;
        cmb cmb = bVar.pHB;
        if (cmb != null) {
            str3 = cmb.title;
        } else {
            str3 = null;
        }
        appMsgDataParcelable.pKg = str3;
        cmb cmb2 = bVar.pHB;
        if (cmb2 != null) {
            str4 = cmb2.iAq;
        } else {
            str4 = null;
        }
        appMsgDataParcelable.pKh = str4;
        cmb cmb3 = bVar.pHB;
        if (cmb3 != null) {
            str5 = cmb3.iAo;
        }
        appMsgDataParcelable.pKi = str5;
        com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, appMsgDataParcelable, a.class, dVar);
        AppMethodBeat.o(7298);
    }

    public static boolean c(AppMsgDataParcelable appMsgDataParcelable) {
        AppMethodBeat.i(7299);
        p.h(appMsgDataParcelable, "data");
        x xVar = appMsgDataParcelable.pHv;
        if (xVar == null) {
            Log.w(TAG, "doSendAppMsg msgInfo is null");
            AppMethodBeat.o(7299);
            return false;
        }
        boolean z = appMsgDataParcelable.pKf == 1;
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = appMsgDataParcelable.url;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXWebpageObject;
        if (z) {
            wXMediaMessage.title = appMsgDataParcelable.pKg;
            wXMediaMessage.description = appMsgDataParcelable.pKh;
        } else {
            wXMediaMessage.title = xVar.iAi.title;
            wXMediaMessage.description = xVar.iAi.iAq;
        }
        tt ttVar = new tt();
        ttVar.eaf.dCE = wXMediaMessage;
        ttVar.eaf.toUser = appMsgDataParcelable.toUser;
        ttVar.eaf.dMG = 2;
        if (Util.isNullOrNil(xVar.dHc)) {
            ttVar.eaf.eag = xVar.ajO();
            ttVar.eaf.eah = aa.getDisplayName(xVar.ajO());
        } else {
            ttVar.eaf.eag = xVar.dHc;
            ttVar.eaf.eah = xVar.iAg;
        }
        try {
            ttVar.eaf.eaj = appMsgDataParcelable.url;
            ttVar.eaf.eam = Util.nullAsNil(xVar.iAh);
            String JX = ad.JX(ttVar.eaf.eam);
            ad.b G = ad.aVe().G(JX, true);
            if (G == null) {
                p.hyc();
            }
            G.l("sendAppMsgScene", 2);
            G.l("preChatName", xVar.ajO());
            G.l("preMsgIndex", Integer.valueOf(xVar.iAf));
            G.l("prePublishId", xVar.iAh);
            G.l("preUsername", xVar.ajO());
            int i2 = xVar.iAi.type;
            if (i2 != -1) {
                G.l("_DATA_CENTER_ITEM_SHOW_TYPE", Integer.valueOf(i2));
                G.l("_tmpl_webview_transfer_scene", 11);
            }
            if (xVar.iAi.type == 5) {
                G.l("_DATA_CENTER_VID", xVar.iAi.vid);
                G.l("_DATA_CENTER_FUNC_FLAG", Integer.valueOf(xVar.iwg));
                G.l("_DATA_CENTER_PUB_TIME", Integer.valueOf((int) xVar.iAi.time));
                G.l("_DATA_CENTER__DULATION", Integer.valueOf(xVar.iAi.iAs));
                G.l("_DATA_CENTER_VIDEO_WIDTH", Integer.valueOf(xVar.iAi.videoWidth));
                G.l("_DATA_CENTER_VIDEO_HEIGHT", Integer.valueOf(xVar.iAi.videoHeight));
                if (z) {
                    G.l("_DATA_CENTER_COVER_URL", appMsgDataParcelable.pKi);
                    G.l("_DATA_CENTER_DESC", appMsgDataParcelable.pKh);
                } else {
                    G.l("_DATA_CENTER_COVER_URL", xVar.iAi.iAo);
                    G.l("_DATA_CENTER_DESC", xVar.iAi.iAq);
                }
            }
            ttVar.eaf.sessionId = JX;
            ttVar.eaf.eak = appMsgDataParcelable.url;
        } catch (Exception e2) {
            Log.e(TAG, "init bunddata failed : %s", e2.getMessage());
        }
        boolean publish = EventCenter.instance.publish(ttVar);
        if (!Util.isNullOrNil(appMsgDataParcelable.msd)) {
            tw twVar = new tw();
            twVar.eaq.dkV = appMsgDataParcelable.toUser;
            twVar.eaq.content = appMsgDataParcelable.msd;
            twVar.eaq.type = ab.JG(appMsgDataParcelable.toUser);
            twVar.eaq.flags = 0;
            EventCenter.instance.publish(twVar);
        }
        AppMethodBeat.o(7299);
        return publish;
    }
}
