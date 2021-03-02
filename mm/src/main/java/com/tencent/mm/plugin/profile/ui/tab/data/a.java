package com.tencent.mm.plugin.profile.ui.tab.data;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.x;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.profile.ui.tab.list.a;
import com.tencent.mm.protocal.protobuf.ng;
import com.tencent.mm.protocal.protobuf.nh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileJumpLogic;", "", "()V", "jumpTo", "", "context", "Landroid/content/Context;", "jumpExtra", "Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileJumpLogic$BizProfileJumpExtra;", "BizProfileJumpExtra", "app_release"})
public final class a {
    public static final a BmH = new a();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileJumpLogic$BizProfileJumpExtra;", "", "()V", "baseInfo", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgBaseInfo;", "getBaseInfo", "()Lcom/tencent/mm/protocal/protobuf/BizAppMsgBaseInfo;", "setBaseInfo", "(Lcom/tencent/mm/protocal/protobuf/BizAppMsgBaseInfo;)V", "bizNickName", "", "getBizNickName", "()Ljava/lang/String;", "setBizNickName", "(Ljava/lang/String;)V", "bizUserName", "getBizUserName", "setBizUserName", "coverView", "Landroid/view/View;", "getCoverView", "()Landroid/view/View;", "setCoverView", "(Landroid/view/View;)V", "detailInfo", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgDetailInfo;", "getDetailInfo", "()Lcom/tencent/mm/protocal/protobuf/BizAppMsgDetailInfo;", "setDetailInfo", "(Lcom/tencent/mm/protocal/protobuf/BizAppMsgDetailInfo;)V", "app_release"})
    /* renamed from: com.tencent.mm.plugin.profile.ui.tab.data.a$a  reason: collision with other inner class name */
    public static final class C1596a {
        public String BmI = "";
        public View BmJ;
        public nh BmK;
        public ng BmL;
        public String sPQ = "";
    }

    static {
        AppMethodBeat.i(230715);
        AppMethodBeat.o(230715);
    }

    private a() {
    }

    public static void a(Context context, C1596a aVar) {
        AppMethodBeat.i(230714);
        p.h(context, "context");
        p.h(aVar, "jumpExtra");
        nh nhVar = aVar.BmK;
        if (nhVar == null) {
            AppMethodBeat.o(230714);
            return;
        }
        ng ngVar = aVar.BmL;
        a.c cVar = com.tencent.mm.plugin.profile.ui.tab.list.a.BmV;
        Log.i(com.tencent.mm.plugin.profile.ui.tab.list.a.TAG, "onClick jump to url:%s", nhVar.KSj);
        Intent intent = new Intent();
        String d2 = m.d(nhVar.KSj, 126, -1, 0);
        intent.putExtra("rawUrl", d2);
        intent.putExtra("useJs", true);
        intent.putExtra("vertical_scroll", true);
        intent.putExtra("geta8key_scene", 3);
        intent.putExtra("geta8key_username", aVar.BmI);
        String stringExtra = intent.getStringExtra("prePublishId");
        if (!Util.isNullOrNil(stringExtra)) {
            intent.putExtra("KPublisherId", stringExtra);
            intent.putExtra("prePublishId", stringExtra);
            intent.putExtra("preUsername", intent.getStringExtra("preUsername"));
            intent.putExtra("preChatName", intent.getStringExtra("preChatName"));
        } else {
            intent.putExtra("prePublishId", "brand_profile");
            intent.putExtra("KPublisherId", "brand_profile");
        }
        intent.putExtra("preChatTYPE", intent.getIntExtra("preChatTYPE", 0));
        int intExtra = intent.getIntExtra("KOpenArticleSceneFromScene", 10000);
        if (nhVar.iAb == 5) {
            com.tencent.mm.kernel.c.a af = g.af(b.class);
            p.g(af, "MMKernel.service(IBrandService::class.java)");
            if (((b) af).cld()) {
                intent.putExtra(e.b.OyQ, 126);
                intent.putExtra(e.b.OyR, intExtra);
                intent.putExtra("biz_video_session_id", ab.getSessionId());
                x xVar = new x();
                xVar.iAh = intent.getStringExtra("KPublisherId");
                xVar.dHc = aVar.BmI;
                xVar.iAg = aVar.sPQ;
                xVar.iAi.url = d2;
                xVar.iAi.title = nhVar.Title;
                xVar.iAi.iAq = "detail.videoDigest";
                xVar.iAi.iAo = nhVar.KSl;
                xVar.iAi.type = nhVar.iAb;
                xVar.iAi.time = ngVar != null ? (long) ngVar.CreateTime : 0;
                xVar.iAi.iAs = nhVar.KSx;
                xVar.iAi.videoWidth = nhVar.KSv;
                xVar.iAi.videoHeight = nhVar.KSw;
                xVar.iAi.vid = nhVar.KSu;
                xVar.t(intent);
                a.c cVar2 = com.tencent.mm.plugin.profile.ui.tab.list.a.BmV;
                Log.i(com.tencent.mm.plugin.profile.ui.tab.list.a.TAG, "jump to native video");
                int[] iArr = new int[2];
                View view = aVar.BmJ;
                if (view != null) {
                    int width = view.getWidth();
                    int height = view.getHeight();
                    view.getLocationInWindow(iArr);
                    intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                }
                intent.addFlags(268435456);
            }
        }
        if (!((b) g.af(b.class)).CR(6) || !((b) g.af(b.class)).a(context, d2, nhVar.iAb, 126, intExtra, intent)) {
            c.b(context, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(230714);
            return;
        }
        a.c cVar3 = com.tencent.mm.plugin.profile.ui.tab.list.a.BmV;
        Log.i(com.tencent.mm.plugin.profile.ui.tab.list.a.TAG, "jump to TmplWebview");
        AppMethodBeat.o(230714);
    }
}
