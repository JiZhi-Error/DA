package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.m;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.o;
import com.tencent.mm.plugin.brandservice.ui.b.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.protocal.protobuf.dkr;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.protocal.protobuf.eqv;
import com.tencent.mm.protocal.protobuf.mr;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.e;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J>\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\"H\u0007J&\u0010#\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\n¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/model/BizTLRecFeedUtil;", "", "()V", "TAG", "", "allMsgEnd", "", "getAllMsgEnd", "()Z", "setAllMsgEnd", "(Z)V", "firstGroupEnd", "getFirstGroupEnd", "setFirstGroupEnd", "showRecFeedList", "getShowRecFeedList", "setShowRecFeedList", "initTag", "", "reporter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport;", "pos", "", FirebaseAnalytics.b.INDEX, "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "itemMsg", "Lcom/tencent/mm/protocal/protobuf/RecommendItemMsg;", "txtJumpLink", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "isShowBigPic", "cardMsg", "Lcom/tencent/mm/protocal/protobuf/RecommendCardMsg;", "onAppMsgClick", "recommendItem", "plugin-brandservice_release"})
public final class a {
    private static boolean pyI = true;
    private static boolean pyJ;
    private static boolean pyK;
    public static final a pyL = new a();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<no name provided>", "", "opType", "", "invoke"})
    static final class b extends q implements kotlin.g.a.b<Integer, x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ z prL;
        final /* synthetic */ int prP;
        final /* synthetic */ dlb puC;
        final /* synthetic */ int puW = 0;
        final /* synthetic */ f pyM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(dlb dlb, Context context, f fVar, z zVar, int i2, int i3) {
            super(1);
            this.puC = dlb;
            this.$context = context;
            this.pyM = fVar;
            this.prL = zVar;
            this.prP = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Integer num) {
            AppMethodBeat.i(195505);
            int intValue = num.intValue();
            if (!Util.isNullOrNil(this.puC.Luj)) {
                String str = this.puC.Luj;
                Intent intent = new Intent();
                intent.putExtra("rawUrl", m.d(str, 169, 200, 0));
                intent.putExtra("geta8key_scene", 56);
                c.b(this.$context, "webview", ".ui.tools.WebViewUI", intent);
                o oVar = o.iBV;
                o.Aa(25);
                this.pyM.b(this.prL, this.puW, intValue);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(195505);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(195509);
        AppMethodBeat.o(195509);
    }

    private a() {
    }

    public static boolean cni() {
        return pyI;
    }

    public static void kl(boolean z) {
        pyI = z;
    }

    public static boolean cnj() {
        return pyJ;
    }

    public static void km(boolean z) {
        pyJ = z;
    }

    public static boolean cnk() {
        return pyK;
    }

    public static void kn(boolean z) {
        pyK = z;
    }

    public static void a(f fVar, int i2, z zVar, dlb dlb, TextView textView, Context context) {
        boolean z;
        AppMethodBeat.i(195506);
        p.h(fVar, "reporter");
        p.h(zVar, "info");
        p.h(dlb, "itemMsg");
        p.h(textView, "txtJumpLink");
        p.h(context, "context");
        String str = dlb.Luk;
        if (!(str == null || n.aL(str))) {
            String str2 = dlb.Luj;
            if (str2 == null || n.aL(str2)) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                textView.setVisibility(0);
                textView.setText(dlb.Luk);
                d dVar = d.pMy;
                d.i(textView);
                textView.setOnClickListener(new View$OnClickListenerC0871a(new b(dlb, context, fVar, zVar, i2, 0)));
                AppMethodBeat.o(195506);
                return;
            }
        }
        textView.setVisibility(8);
        AppMethodBeat.o(195506);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.a$a  reason: collision with other inner class name */
    static final class View$OnClickListenerC0871a implements View.OnClickListener {
        final /* synthetic */ kotlin.g.a.b pwT;

        View$OnClickListenerC0871a(kotlin.g.a.b bVar) {
            this.pwT = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(195504);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/model/BizTLRecFeedUtil$initTag$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.pwT.invoke(24);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/model/BizTLRecFeedUtil$initTag$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(195504);
        }
    }

    public static void a(Context context, z zVar, dlb dlb) {
        AppMethodBeat.i(195507);
        p.h(context, "context");
        p.h(zVar, "info");
        p.h(dlb, "recommendItem");
        if (zVar.NQr == null || dlb.MOX == null || dlb.MOY == null) {
            Log.w("Micromsg.BizTimeLineRecFeedsHelper", "onAppMsgClick appMsg is null");
            AppMethodBeat.o(195507);
            return;
        }
        mr mrVar = dlb.MOX;
        cdu cdu = dlb.MOY;
        o oVar = o.iBV;
        o.Aa(21);
        Log.i("Micromsg.BizTimeLineRecFeedsHelper", "onClick jump to url:%s", cdu.KSj);
        Intent intent = new Intent();
        String d2 = m.d(cdu.KSj, 169, 200, 0);
        intent.putExtra("rawUrl", d2);
        intent.putExtra("geta8key_scene", 56);
        intent.putExtra("geta8key_username", mrVar.UserName);
        intent.putExtra("srcUsername", mrVar.UserName);
        intent.putExtra("srcDisplayname", mrVar.oUJ);
        intent.putExtra("prePublishId", "rec_feed");
        intent.putExtra("KPublisherId", "rec_feed");
        if (cdu.iAb == 5) {
            com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.brandservice.a.b.class);
            p.g(af, "MMKernel.service(IBrandService::class.java)");
            if (((com.tencent.mm.plugin.brandservice.a.b) af).cld()) {
                intent.putExtra(e.b.OyQ, 169);
                intent.putExtra(e.b.OyR, 200);
                intent.putExtra("biz_video_session_id", ab.getSessionId());
                com.tencent.mm.ag.x xVar = new com.tencent.mm.ag.x();
                xVar.iAh = intent.getStringExtra("KPublisherId");
                xVar.dHc = mrVar.UserName;
                xVar.iAg = mrVar.oUJ;
                xVar.iAi.url = d2;
                xVar.iAi.title = cdu.Title;
                xVar.iAi.iAq = cdu.KSh;
                xVar.iAi.iAo = cdu.KSl;
                xVar.iAi.type = cdu.iAb;
                xVar.iAi.time = (long) cdu.CreateTime;
                eqv eqv = cdu.Mjm;
                xVar.iAi.iAs = eqv.KSx;
                xVar.iAi.videoWidth = eqv.KSv;
                xVar.iAi.videoHeight = eqv.KSw;
                xVar.iAi.vid = eqv.KSu;
                xVar.t(intent);
                Log.i("Micromsg.BizTimeLineRecFeedsHelper", "jump to native video");
                intent.addFlags(268435456);
            }
        }
        if (!((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(1) || !((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(context, d2, cdu.iAb, 169, 200, intent)) {
            c.b(context, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(195507);
            return;
        }
        Log.i("Micromsg.BizTimeLineRecFeedsHelper", "jump to TmplWebview");
        AppMethodBeat.o(195507);
    }

    public static final boolean a(dkr dkr) {
        AppMethodBeat.i(195508);
        p.h(dkr, "cardMsg");
        boolean a2 = af.a(dkr);
        AppMethodBeat.o(195508);
        return a2;
    }
}
