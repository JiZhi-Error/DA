package com.tencent.mm.plugin.expt.hellhound.a.b.c;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.el;
import com.tencent.mm.g.b.a.ll;
import com.tencent.mm.g.b.a.lm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.b.d.i;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/HellFinderReport;", "", "()V", "Companion", "plugin-expt_release"})
public final class a {
    public static final C1016a sGv = new C1016a((byte) 0);

    static {
        AppMethodBeat.i(221024);
        AppMethodBeat.o(221024);
    }

    public static final void a(b bVar) {
        AppMethodBeat.i(221025);
        C1016a.a(bVar);
        AppMethodBeat.o(221025);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eJ*\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0011H\u0007J\u0006\u0010\u0015\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/HellFinderReport$Companion;", "", "()V", "TAG", "", "report19943", "", "statistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/StayTimeStatistics;", "report19944", "feed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "report19945", "clickFeed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ClickFeed;", "report21053OnClickOnSnsAd", "feedId", "", "liveId", "userName", "pos", "reportGiftOnReturn", "plugin-expt_release"})
    /* renamed from: com.tencent.mm.plugin.expt.hellhound.a.b.c.a$a  reason: collision with other inner class name */
    public static final class C1016a {
        private C1016a() {
        }

        public /* synthetic */ C1016a(byte b2) {
            this();
        }

        public static void a(b bVar) {
            String str;
            String str2;
            String str3;
            AppMethodBeat.i(221021);
            p.h(bVar, "statistics");
            el elVar = new el();
            elVar.re(bVar.sessionId);
            elVar.rf(com.tencent.mm.plugin.expt.hellhound.core.b.aoX(bVar.dMl));
            elVar.mb(bVar.sGC);
            elVar.mc(bVar.sGD);
            elVar.ma(bVar.sGB);
            elVar.rg(bVar.sGE);
            elVar.ri(com.tencent.mm.plugin.expt.hellhound.core.b.cND());
            if (p.j(elVar.afB(), "FinderTopicFeedUI")) {
                StringBuilder append = new StringBuilder().append(elVar.afB());
                if (bVar.sGG) {
                    str3 = "_POI";
                } else {
                    str3 = "";
                }
                elVar.rf(append.append(str3).toString());
            }
            elVar.rh(bVar.sGF);
            elVar.md((long) bVar.dYn);
            String str4 = bVar.extraInfo;
            if (str4 == null || (str = n.j(str4, ",", ";", false)) == null) {
                str = "";
            }
            elVar.rj(str);
            String str5 = bVar.sGH;
            if (str5 == null || (str2 = n.j(str5, ",", ";", false)) == null) {
                str2 = "";
            }
            elVar.rk(str2);
            h.RTc.ba(new RunnableC1017a(elVar));
            AppMethodBeat.o(221021);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.expt.hellhound.a.b.c.a$a$a  reason: collision with other inner class name */
        public static final class RunnableC1017a implements Runnable {
            final /* synthetic */ el sGw;

            RunnableC1017a(el elVar) {
                this.sGw = elVar;
            }

            public final void run() {
                AppMethodBeat.i(221018);
                this.sGw.bfK();
                Log.i("HABBYGE-MALI.HellFinderReport", "report[19943]: sessionId=" + this.sGw.getSessionId() + ", page=" + this.sGw.afB() + ", enterTimeMs=" + this.sGw.afC() + ", exitTimeMs=" + this.sGw.afD() + ", stayTimeMs=" + this.sGw.afo() + ", sid=" + this.sGw.afE() + ", reportType=" + this.sGw.afF() + ", contextId=" + this.sGw.ack() + ", finderContextId=" + this.sGw.afG() + ", extraInfo=" + this.sGw.getExtraInfo() + ",  enterSourceInfo=" + this.sGw.afH());
                AppMethodBeat.o(221018);
            }
        }

        public static void a(i iVar) {
            float f2;
            float f3;
            AppMethodBeat.i(221022);
            p.h(iVar, "feed");
            lm lmVar = new lm();
            lmVar.yN(iVar.sessionId);
            lmVar.yO(iVar.feedId);
            lmVar.uX(iVar.sHt);
            lmVar.uY(iVar.sHu);
            lmVar.lX(iVar.sHv);
            if (iVar.sGL <= 0.0f) {
                f2 = 100.0f;
            } else {
                f2 = iVar.sGL;
            }
            ae aeVar = ae.SYK;
            String format = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f2 / 100.0f)}, 1));
            p.g(format, "java.lang.String.format(format, *args)");
            lmVar.yP(format);
            if (lmVar.aiO() == -1) {
                lmVar.lX(0);
            }
            if (iVar.sGM <= 0.0f) {
                c.a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                f3 = ((iVar.width * iVar.height) * 100.0f) / com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEI;
            } else {
                f3 = iVar.sGM;
            }
            ae aeVar2 = ae.SYK;
            String format2 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f3 / 100.0f)}, 1));
            p.g(format2, "java.lang.String.format(format, *args)");
            lmVar.yQ(format2);
            lmVar.yR(iVar.sGQ);
            lmVar.lY(iVar.scene);
            lmVar.uZ(iVar.sGJ);
            lmVar.va(iVar.sHw);
            lmVar.lZ(iVar.sHx);
            lmVar.ma(iVar.kf);
            lmVar.yS(iVar.sGR);
            h.RTc.ba(new b(lmVar, iVar));
            AppMethodBeat.o(221022);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.expt.hellhound.a.b.c.a$a$b */
        static final class b implements Runnable {
            final /* synthetic */ lm sGx;
            final /* synthetic */ i sGy;

            b(lm lmVar, i iVar) {
                this.sGx = lmVar;
                this.sGy = iVar;
            }

            public final void run() {
                AppMethodBeat.i(221019);
                this.sGx.eOp();
                Log.i("HABBYGE-MALI.HellFinderReport", "report[19944]:\nsessionId=" + this.sGx.getSessionId() + '\n' + "feedId=" + this.sGx.adk() + '\n' + "name=" + this.sGy.nickName + '\n' + "startExposureMs=" + this.sGx.aiM() + '\n' + "endExposureMs=" + this.sGx.aiN() + '\n' + "itemExposureTimeMs=" + this.sGx.aiP() + '\n' + "screenExposureAreaWeigth=" + this.sGx.aiG() + '\n' + "disAppearType=" + this.sGx.aiO() + '\n' + "contextId=" + this.sGx.acj() + '\n' + "scene=" + this.sGx.getScene() + '\n' + "updataTimeMs=" + this.sGx.aiD() + '\n' + "itemPos=" + this.sGx.aiQ() + '\n' + "itemArrayIndex=" + this.sGx.aiL() + '\n' + "itemBufffer=" + this.sGx.aiK() + '\n' + "itemExposureAreaWeigth=" + this.sGx.aiF());
                AppMethodBeat.o(221019);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.expt.hellhound.a.b.c.a$a$c */
        public static final class c implements Runnable {
            final /* synthetic */ com.tencent.mm.plugin.expt.hellhound.a.b.d.a sGA;
            final /* synthetic */ ll sGz;

            public c(ll llVar, com.tencent.mm.plugin.expt.hellhound.a.b.d.a aVar) {
                this.sGz = llVar;
                this.sGA = aVar;
            }

            public final void run() {
                AppMethodBeat.i(221020);
                this.sGz.eOp();
                Log.i("HABBYGE-MALI.HellFinderReport", "report[19945]:\nsessionId=" + this.sGz.getSessionId() + '\n' + "clickFeedId=" + this.sGz.aiC() + '\n' + "position=" + this.sGA.position + '\n' + "nickName=" + this.sGA.nickName + '\n' + "scene=" + this.sGz.getScene() + '\n' + "updateTimeMs=" + this.sGz.aiD() + '\n' + "clickTimeMs=" + this.sGz.aiE() + '\n' + "itemExposureAreaWeigth=" + this.sGz.aiF() + '\n' + "screenExposureAreaWeigth=" + this.sGz.aiG() + '\n' + "itemDirection=" + this.sGz.aiH() + '\n' + "itemIndex=" + this.sGz.aiI() + '\n' + "shotScreenJson=" + this.sGz.aiJ() + '\n' + "contextId=" + this.sGz.acj() + '\n' + "itemBufffer=" + this.sGz.aiK() + '\n' + "itemArrayIndex=" + this.sGz.aiL());
                AppMethodBeat.o(221020);
            }
        }

        public static void reportGiftOnReturn() {
            AppMethodBeat.i(221023);
            c.a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
            if (!(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEC)) {
                AppMethodBeat.o(221023);
                return;
            }
            ((aj) g.ah(aj.class)).reportGiftOnReturn();
            AppMethodBeat.o(221023);
        }
    }

    public static final void report21053OnClickOnSnsAd(long j2, long j3, String str, long j4) {
        AppMethodBeat.i(221026);
        ((aj) g.ah(aj.class)).report21053OnClickOnSnsAd(j2, j3, str, j4);
        AppMethodBeat.o(221026);
    }
}
