package com.tencent.mm.plugin.finder.megavideo.floatball;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.f;
import com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoTimelineUI;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.report.af;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cns;
import com.tencent.mm.protocal.protobuf.cnu;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

public final class a extends f {
    private static final e lqt = new b();
    public static final C1215a uKD = new C1215a((byte) 0);
    private final Context context;

    /* renamed from: com.tencent.mm.plugin.finder.megavideo.floatball.a$a */
    public static final class C1215a {
        private C1215a() {
        }

        public /* synthetic */ C1215a(byte b2) {
            this();
        }

        /* renamed from: com.tencent.mm.plugin.finder.megavideo.floatball.a$a$a */
        public static final class C1216a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ com.tencent.mm.plugin.ball.c.b uKE;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C1216a(com.tencent.mm.plugin.ball.c.b bVar) {
                super(0);
                this.uKE = bVar;
            }

            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(248359);
                ArrayList<BallInfo> arrayList = new ArrayList();
                List<BallInfo> chQ = this.uKE.chQ();
                p.g(chQ, "floatBallService.ballInfoListSync");
                for (T t : chQ) {
                    if (t.type == 22 && t.agQ("KEY_FLOAT_BALL_VERSION") == 0) {
                        arrayList.add(t);
                    }
                }
                for (BallInfo ballInfo : arrayList) {
                    this.uKE.l(ballInfo);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(248359);
                return xVar;
            }
        }
    }

    public static final class b extends com.tencent.mm.plugin.ball.c.f {
        b() {
        }

        @Override // com.tencent.mm.plugin.ball.c.f, com.tencent.mm.plugin.ball.c.e
        public final void b(BallInfo ballInfo) {
            AppMethodBeat.i(248357);
            if (ballInfo != null) {
                C1215a aVar = a.uKD;
                p.h(ballInfo, "ballInfo");
                byte[] byteArrayExtra = ballInfo.getByteArrayExtra("KEY_FLOAT_BALL_INFO");
                cnu cnu = new cnu();
                try {
                    cnu.parseFrom(byteArrayExtra);
                } catch (Throwable th) {
                    Log.e("MegaVideoFloatBallHelper", "handleBallInfoClicked", th);
                }
                Intent intent = new Intent();
                LinkedList<FinderObject> linkedList = cnu.Muf;
                p.g(linkedList, "floatBallInfo.cacheNewVideoList");
                LinkedList<FinderObject> linkedList2 = linkedList;
                ArrayList arrayList = new ArrayList(j.a(linkedList2, 10));
                for (T t : linkedList2) {
                    p.g(t, LocaleUtil.ITALIAN);
                    arrayList.add(new bm((FinderObject) t));
                }
                y yVar = y.vXH;
                y.a(cnu.Muc, arrayList, cnu.lastBuffer, intent);
                intent.putExtra("KEY_ROUTER_UI", cnu.Mue);
                intent.putExtra("KEY_FLOAT_BALL_INFO", cnu.toByteArray());
                intent.putExtra("KEY_FLOAT_BALL_TASK_ORDER", ballInfo.getIntExtra("KEY_FLOAT_BALL_TASK_ORDER", 0));
                intent.putExtra("KEY_FLOAT_BALL_MINI_SESSION_ID", ballInfo.eT("KEY_FLOAT_BALL_MINI_SESSION_ID", ""));
                intent.putExtra("KEY_VIDEO_START_PLAY_TIME_MS", ((long) cnu.Mud) * 1000);
                intent.addFlags(536870912);
                FinderLongVideoTimelineUI.a aVar2 = FinderLongVideoTimelineUI.ubS;
                ((aj) g.ah(aj.class)).fillContextIdToIntent(8, 6, FinderLongVideoTimelineUI.a.IS(cnu.Mue), intent);
                com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                com.tencent.mm.plugin.finder.utils.a.d(context, intent, true);
                AppMethodBeat.o(248357);
                return;
            }
            AppMethodBeat.o(248357);
        }

        @Override // com.tencent.mm.plugin.ball.c.f, com.tencent.mm.plugin.ball.c.e
        public final void c(BallInfo ballInfo) {
            aoq aoq;
            LinkedList<aop> linkedList;
            aop aop;
            bei bei;
            cng cng;
            Long l = null;
            AppMethodBeat.i(248358);
            if (ballInfo != null) {
                byte[] byteArrayExtra = ballInfo.getByteArrayExtra("KEY_FLOAT_BALL_INFO");
                cnu cnu = new cnu();
                try {
                    cnu.parseFrom(byteArrayExtra);
                } catch (Throwable th) {
                    Log.e("MegaVideoFloatBallHelper", "handleBallInfoClicked", th);
                }
                FinderLongVideoTimelineUI.a aVar = FinderLongVideoTimelineUI.ubS;
                String fillContextIdToIntent = ((aj) g.ah(aj.class)).fillContextIdToIntent(8, 6, FinderLongVideoTimelineUI.a.IS(cnu.Mue), null);
                String eT = ballInfo.eT("KEY_FLOAT_BALL_MINI_SESSION_ID", "");
                LinkedList<FinderObject> linkedList2 = cnu.Muf;
                p.g(linkedList2, "floatBallInfo.cacheNewVideoList");
                FinderObject finderObject = (FinderObject) j.L(linkedList2, cnu.Muc);
                if (finderObject == null || (aoq = finderObject.attachmentList) == null || (linkedList = aoq.LAM) == null || (aop = (aop) j.kt(linkedList)) == null || (bei = aop.LAL) == null || (cng = bei.LIA) == null) {
                    AppMethodBeat.o(248358);
                    return;
                }
                p.g(cng, "floatBallInfo.cacheNewVi…ideo?.video ?: return@run");
                int intExtra = ballInfo.getIntExtra("KEY_FLOAT_BALL_TASK_ORDER", 0);
                af afVar = af.viA;
                p.g(eT, "miniSessionId");
                if (cng != null) {
                    l = Long.valueOf(cng.id);
                }
                String zs = d.zs(l.longValue());
                p.g(fillContextIdToIntent, "contextId");
                af.a(eT, intExtra, zs, "", fillContextIdToIntent, "");
                AppMethodBeat.o(248358);
                return;
            }
            AppMethodBeat.o(248358);
        }

        @Override // com.tencent.mm.plugin.ball.c.f, com.tencent.mm.plugin.ball.c.e
        public final void d(BallInfo ballInfo) {
        }
    }

    static {
        AppMethodBeat.i(248362);
        AppMethodBeat.o(248362);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void G(int i2, String str) {
        AppMethodBeat.i(248360);
        super.G(i2, str);
        ciw().hDa = 17;
        AppMethodBeat.o(248360);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean aGg() {
        return true;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void y(boolean z, int i2) {
        String str;
        String str2;
        String str3;
        cns cns;
        aoq aoq;
        LinkedList<aop> linkedList;
        aop aop;
        bei bei;
        AppMethodBeat.i(248361);
        super.y(z, i2);
        if (z) {
            byte[] byteArrayExtra = this.oWE.getByteArrayExtra("KEY_FLOAT_BALL_INFO");
            cnu cnu = new cnu();
            try {
                cnu.parseFrom(byteArrayExtra);
            } catch (Throwable th) {
                Log.e("MegaVideoFloatBallHelper", "handleBallInfoClicked", th);
            }
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.context);
            bbn dIx = fH != null ? fH.dIx() : null;
            LinkedList<FinderObject> linkedList2 = cnu.Muf;
            p.g(linkedList2, "floatBallInfo.cacheNewVideoList");
            FinderObject finderObject = (FinderObject) j.L(linkedList2, cnu.Muc);
            cng cng = (finderObject == null || (aoq = finderObject.attachmentList) == null || (linkedList = aoq.LAM) == null || (aop = (aop) j.kt(linkedList)) == null || (bei = aop.LAL) == null) ? null : bei.LIA;
            int cip = cip() + 1;
            long aWA = cl.aWA();
            String concat = "uin_".concat(String.valueOf(aWA));
            this.oWE.cy("KEY_FLOAT_BALL_TASK_ORDER", cip);
            this.oWE.eS("KEY_FLOAT_BALL_MINI_SESSION_ID", concat);
            this.oWE.X("KEY_FLOAT_BALL_VERSION", 1);
            af afVar = af.viA;
            int i3 = i2 == 2 ? 2 : 1;
            String zs = d.zs(cng != null ? cng.id : 0);
            if (dIx == null || (str = dIx.sessionId) == null) {
                str = "";
            }
            if (dIx == null || (str2 = dIx.sGQ) == null) {
                str2 = "";
            }
            if (dIx == null || (str3 = dIx.sGE) == null) {
                str3 = "";
            }
            af.a(aWA, i3, cip, zs, concat, str, str2, str3, d.zs((cng == null || (cns = cng.MtI) == null) ? 0 : cns.hFK));
        }
        AppMethodBeat.o(248361);
    }
}
