package com.tencent.mm.plugin.webview.ui.tools.media;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.y;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.webview.model.c;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpShareVideoMsgFav;", "", "()V", "TAG", "", "doFav", "", "msgInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "data", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "mpShareVideoInfo", "Lcom/tencent/mm/protocal/protobuf/BaseMpShareVideoInfo;", "IPCInvoke_Fav", "plugin-webview_release"})
public final class f {
    public static final f JwB = new f();
    private static final String TAG = TAG;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class b<T> implements d<ResultType> {
        public static final b JwC = new b();

        static {
            AppMethodBeat.i(82663);
            AppMethodBeat.o(82663);
        }

        b() {
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* bridge */ /* synthetic */ void bn(Object obj) {
        }
    }

    static {
        AppMethodBeat.i(82666);
        AppMethodBeat.o(82666);
    }

    private f() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpShareVideoMsgFav$IPCInvoke_Fav;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"})
    static final class a implements com.tencent.mm.ipcinvoker.b<MpVideoDataParcelable, Bundle> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(MpVideoDataParcelable mpVideoDataParcelable, d<Bundle> dVar) {
            AppMethodBeat.i(82662);
            MpVideoDataParcelable mpVideoDataParcelable2 = mpVideoDataParcelable;
            p.h(mpVideoDataParcelable2, "data");
            p.h(dVar, "callback");
            f fVar = f.JwB;
            p.h(mpVideoDataParcelable2, "data");
            f.d(mpVideoDataParcelable2.JwD);
            AppMethodBeat.o(82662);
        }
    }

    public static void b(y yVar) {
        AppMethodBeat.i(82664);
        p.h(yVar, "msgInfo");
        MpVideoDataParcelable mpVideoDataParcelable = new MpVideoDataParcelable();
        mpVideoDataParcelable.JwD = yVar;
        h.a(MainProcessIPCService.dkO, mpVideoDataParcelable, a.class, b.JwC);
        AppMethodBeat.o(82664);
    }

    public static void d(jo joVar) {
        AppMethodBeat.i(210562);
        if (joVar == null) {
            Log.w(TAG, "doFav msgInfo is null");
            AppMethodBeat.o(210562);
            return;
        }
        cz czVar = new cz();
        ad.b G = ad.aVe().G(ad.JX(Util.nullAsNil(joVar.iAh)), true);
        if (G == null) {
            p.hyc();
        }
        G.l("sendAppMsgScene", 2);
        G.l("preChatName", joVar.ehR);
        G.l("prePublishId", joVar.iAh);
        G.l("preUsername", joVar.ehQ);
        G.l("referUrl", joVar.url);
        czVar.dFZ.dGf = 36;
        c.a(czVar, joVar);
        EventCenter.instance.publish(czVar);
        AppMethodBeat.o(210562);
    }
}
