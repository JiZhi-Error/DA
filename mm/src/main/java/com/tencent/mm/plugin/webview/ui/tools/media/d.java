package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.y;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.z;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.e;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J.\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ@\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoTransmit;", "", "()V", "TAG", "", "doSendAppMsg", "", "data", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "", "toUser", "msgInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "appendText", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Landroid/os/Bundle;", "transmitMpVideoMsg", "context", "Landroid/content/Context;", "imgUrl", "desc", "title", "url", "fromScene", "", "IPCInvoke_SendAppMsg", "plugin-webview_release"})
public final class d {
    public static final d Jwx = new d();
    private static final String TAG = TAG;

    static {
        AppMethodBeat.i(82657);
        AppMethodBeat.o(82657);
    }

    private d() {
    }

    public static void a(Context context, String str, String str2, String str3, String str4, int i2) {
        AppMethodBeat.i(82654);
        p.h(context, "context");
        HashMap hashMap = new HashMap();
        String nullAsNil = Util.nullAsNil(str);
        p.g(nullAsNil, "Util.nullAsNil(imgUrl)");
        hashMap.put("img_url", nullAsNil);
        String nullAsNil2 = Util.nullAsNil(str2);
        p.g(nullAsNil2, "Util.nullAsNil(desc)");
        hashMap.put("desc", nullAsNil2);
        String nullAsNil3 = Util.nullAsNil(str3);
        p.g(nullAsNil3, "Util.nullAsNil(title)");
        hashMap.put("title", nullAsNil3);
        String nullAs = Util.nullAs(str4, e.p.Ozp);
        p.g(nullAs, "Util.nullAs(url, Constan…ewUI.MP_VIDEO_UPDATE_URL)");
        hashMap.put("url", nullAs);
        Log.i(TAG, "transmitMpVideoMsg, img_url=%s, desc=%s, title=%s, url=%s", hashMap.get("img_url"), hashMap.get("desc"), hashMap.get("title"), str4);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("scene_from", i2);
        intent.putExtra("is_mp_video", true);
        intent.putExtra("Retr_Msg_Type", 1);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("webview_params", hashMap);
        c.c(context, ".ui.transmit.SelectConversationUI", intent, 3);
        AppMethodBeat.o(82654);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/media/MPVideoTransmit$IPCInvoke_SendAppMsg;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"})
    public static final class a implements com.tencent.mm.ipcinvoker.b<MpVideoDataParcelable, Bundle> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(MpVideoDataParcelable mpVideoDataParcelable, com.tencent.mm.ipcinvoker.d<Bundle> dVar) {
            AppMethodBeat.i(82652);
            MpVideoDataParcelable mpVideoDataParcelable2 = mpVideoDataParcelable;
            p.h(mpVideoDataParcelable2, "data");
            p.h(dVar, "callback");
            d dVar2 = d.Jwx;
            boolean a2 = d.a(mpVideoDataParcelable2);
            Bundle bundle = new Bundle();
            bundle.putBoolean("ret", a2);
            dVar.bn(bundle);
            AppMethodBeat.o(82652);
        }
    }

    public static void b(String str, y yVar, String str2, com.tencent.mm.ipcinvoker.d<Bundle> dVar) {
        AppMethodBeat.i(82655);
        p.h(str, "toUser");
        p.h(yVar, "msgInfo");
        p.h(dVar, "callback");
        MpVideoDataParcelable mpVideoDataParcelable = new MpVideoDataParcelable();
        mpVideoDataParcelable.toUser = str;
        mpVideoDataParcelable.msd = str2;
        mpVideoDataParcelable.JwD = yVar;
        h.a(MainProcessIPCService.dkO, mpVideoDataParcelable, a.class, dVar);
        AppMethodBeat.o(82655);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ y Jwy;

        b(y yVar) {
            this.Jwy = yVar;
        }

        public final void run() {
            AppMethodBeat.i(82653);
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("MpShareVideoImage", 2);
            byte[] decodeBytes = mmkv.decodeBytes(this.Jwy.KOf);
            String bdu = s.bdu(this.Jwy.iAo);
            if (decodeBytes != null) {
                com.tencent.mm.vfs.s.C(bdu, decodeBytes);
            }
            mmkv.clearAll();
            AppMethodBeat.o(82653);
        }
    }

    public static boolean a(MpVideoDataParcelable mpVideoDataParcelable) {
        AppMethodBeat.i(82656);
        p.h(mpVideoDataParcelable, "data");
        y yVar = mpVideoDataParcelable.JwD;
        if (yVar == null) {
            Log.w(TAG, "doSendAppMsg msgInfo is null");
            AppMethodBeat.o(82656);
            return false;
        }
        z zVar = new z();
        zVar.webpageUrl = yVar.url;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = zVar;
        wXMediaMessage.title = yVar.title;
        com.tencent.mm.plugin.webview.a.a.aj(new b(yVar));
        tt ttVar = new tt();
        ttVar.eaf.dCE = wXMediaMessage;
        ttVar.eaf.toUser = mpVideoDataParcelable.toUser;
        ttVar.eaf.dMG = 2;
        ttVar.eaf.eag = yVar.dHc;
        ttVar.eaf.eah = yVar.iAg;
        try {
            ttVar.eaf.eam = Util.nullAsNil(yVar.iAh);
            String JX = ad.JX(ttVar.eaf.eam);
            ad.b G = ad.aVe().G(JX, true);
            if (G == null) {
                p.hyc();
            }
            G.l("sendAppMsgScene", 2);
            G.l("preChatName", yVar.ehR);
            G.l("prePublishId", yVar.iAh);
            G.l("preUsername", yVar.ehQ);
            G.l("_DATA_CENTER_ITEM_SHOW_TYPE", -1);
            G.l("_tmpl_webview_transfer_scene", 11);
            G.l("_DATA_CENTER_VID", yVar.KOf);
            G.l("_DATA_CENTER__DULATION", Integer.valueOf(yVar.videoDuration));
            G.l("_DATA_CENTER_VIDEO_WIDTH", Integer.valueOf(yVar.width));
            G.l("_DATA_CENTER_VIDEO_HEIGHT", Integer.valueOf(yVar.height));
            G.l("_DATA_CENTER_COVER_URL", yVar.iAo);
            G.l("_DATA_CENTER_VIDEO_PLAY_URL", yVar.videoUrl);
            G.l("_DATA_CENTER_VIDEO_MP_URL", yVar.KOe);
            G.l("_DATA_CENTER_IS_MP_SHARE_VIDEO", Boolean.TRUE);
            ttVar.eaf.sessionId = JX;
        } catch (Exception e2) {
            Log.e(TAG, "init bunddata failed : %s", e2.getMessage());
        }
        boolean publish = EventCenter.instance.publish(ttVar);
        if (!Util.isNullOrNil(mpVideoDataParcelable.msd)) {
            tw twVar = new tw();
            twVar.eaq.dkV = mpVideoDataParcelable.toUser;
            twVar.eaq.content = mpVideoDataParcelable.msd;
            twVar.eaq.type = ab.JG(mpVideoDataParcelable.toUser);
            twVar.eaq.flags = 0;
            EventCenter.instance.publish(twVar);
        }
        AppMethodBeat.o(82656);
        return publish;
    }
}
