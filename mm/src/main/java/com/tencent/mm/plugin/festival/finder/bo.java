package com.tencent.mm.plugin.festival.finder;

import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.festival.model.ag;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0002()B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0012\u001a\u00020\u0013J+\u0010\u0014\u001a\u00020\u00152!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00110\u0017H\u0002J\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0013J\u0006\u0010\u001d\u001a\u00020\u0015J\u0006\u0010\u001e\u001a\u00020\u0015J\b\u0010\u001f\u001a\u00020\u0015H\u0016J\b\u0010 \u001a\u00020\u0015H\u0016J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0011H\u0016J\u001a\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0017R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¤\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalLiveCanvasOverlayElementsPluginBase;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderBaseLivePlugin;", "Lcom/tencent/mm/plugin/festival/model/IForbiddenCallback;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "elementsViewContact", "Lcom/tencent/mm/plugin/festival/finder/FestivalLiveCanvasOverlayElementsPluginBase$ElementsViewContract;", "getElementsViewContact", "()Lcom/tencent/mm/plugin/festival/finder/FestivalLiveCanvasOverlayElementsPluginBase$ElementsViewContract;", "hideUiFlag", "", "checkCanShowElements", "", "modifyHideUiFlag", "", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "flag", "onForbiddenChange", "isBitFlagSet", "onLiveRestart", "onLiveRestartCompleted", "pause", "resume", "setVisible", "visible", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "ElementsViewContract", "HIDE_UI_FLAG", "plugin-festival_release"})
public abstract class bo extends p implements ag {
    private int Uwu;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalLiveCanvasOverlayElementsPluginBase$ElementsViewContract;", "", "pause", "", "resume", "plugin-festival_release"})
    public interface a {
        void pause();

        void resume();
    }

    /* access modifiers changed from: protected */
    public abstract a dsw();

    public abstract String getTAG();

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "invoke"})
    static final class b extends q implements kotlin.g.a.b<Integer, Integer> {
        public static final b Uwv = new b();

        static {
            AppMethodBeat.i(262818);
            AppMethodBeat.o(262818);
        }

        b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Integer invoke(Integer num) {
            AppMethodBeat.i(262817);
            Integer valueOf = Integer.valueOf(num.intValue() | 32);
            AppMethodBeat.o(262817);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "invoke"})
    static final class c extends q implements kotlin.g.a.b<Integer, Integer> {
        public static final c Uww = new c();

        static {
            AppMethodBeat.i(262820);
            AppMethodBeat.o(262820);
        }

        c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Integer invoke(Integer num) {
            AppMethodBeat.i(262819);
            Integer valueOf = Integer.valueOf(num.intValue() & -33);
            AppMethodBeat.o(262819);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "invoke"})
    static final class d extends q implements kotlin.g.a.b<Integer, Integer> {
        public static final d Uwx = new d();

        static {
            AppMethodBeat.i(262822);
            AppMethodBeat.o(262822);
        }

        d() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Integer invoke(Integer num) {
            AppMethodBeat.i(262821);
            Integer valueOf = Integer.valueOf(num.intValue() | 64);
            AppMethodBeat.o(262821);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "invoke"})
    static final class e extends q implements kotlin.g.a.b<Integer, Integer> {
        public static final e Uwy = new e();

        static {
            AppMethodBeat.i(262824);
            AppMethodBeat.o(262824);
        }

        e() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Integer invoke(Integer num) {
            AppMethodBeat.i(262823);
            Integer valueOf = Integer.valueOf(num.intValue() & -65);
            AppMethodBeat.o(262823);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "invoke"})
    static final class f extends q implements kotlin.g.a.b<Integer, Integer> {
        public static final f Uwz = new f();

        static {
            AppMethodBeat.i(262826);
            AppMethodBeat.o(262826);
        }

        f() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Integer invoke(Integer num) {
            AppMethodBeat.i(262825);
            Integer valueOf = Integer.valueOf(num.intValue() | 2);
            AppMethodBeat.o(262825);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "invoke"})
    static final class g extends q implements kotlin.g.a.b<Integer, Integer> {
        public static final g UwA = new g();

        static {
            AppMethodBeat.i(262828);
            AppMethodBeat.o(262828);
        }

        g() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Integer invoke(Integer num) {
            AppMethodBeat.i(262827);
            Integer valueOf = Integer.valueOf(num.intValue() & -3);
            AppMethodBeat.o(262827);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "invoke"})
    public static final class h extends q implements kotlin.g.a.b<Integer, Integer> {
        public static final h UwB = new h();

        static {
            AppMethodBeat.i(262830);
            AppMethodBeat.o(262830);
        }

        h() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Integer invoke(Integer num) {
            AppMethodBeat.i(262829);
            Integer valueOf = Integer.valueOf(num.intValue() & -25);
            AppMethodBeat.o(262829);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "invoke"})
    public static final class i extends q implements kotlin.g.a.b<Integer, Integer> {
        public static final i UwC = new i();

        static {
            AppMethodBeat.i(262832);
            AppMethodBeat.o(262832);
        }

        i() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Integer invoke(Integer num) {
            AppMethodBeat.i(262831);
            Integer valueOf = Integer.valueOf(num.intValue() | 16);
            AppMethodBeat.o(262831);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "invoke"})
    public static final class j extends q implements kotlin.g.a.b<Integer, Integer> {
        public static final j UwD = new j();

        static {
            AppMethodBeat.i(262834);
            AppMethodBeat.o(262834);
        }

        j() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Integer invoke(Integer num) {
            AppMethodBeat.i(262833);
            Integer valueOf = Integer.valueOf(num.intValue() | 8);
            AppMethodBeat.o(262833);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "invoke"})
    public static final class k extends q implements kotlin.g.a.b<Integer, Integer> {
        public static final k UwE = new k();

        static {
            AppMethodBeat.i(262836);
            AppMethodBeat.o(262836);
        }

        k() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Integer invoke(Integer num) {
            AppMethodBeat.i(262835);
            Integer valueOf = Integer.valueOf(num.intValue() | 4);
            AppMethodBeat.o(262835);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "invoke"})
    public static final class l extends q implements kotlin.g.a.b<Integer, Integer> {
        public static final l UwF = new l();

        static {
            AppMethodBeat.i(262838);
            AppMethodBeat.o(262838);
        }

        l() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Integer invoke(Integer num) {
            AppMethodBeat.i(262837);
            Integer valueOf = Integer.valueOf(num.intValue() & -5);
            AppMethodBeat.o(262837);
            return valueOf;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bo(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
    }

    public final boolean gFa() {
        return this.Uwu == 0;
    }

    private final void Z(kotlin.g.a.b<? super Integer, Integer> bVar) {
        boolean gFa = gFa();
        this.Uwu = bVar.invoke(Integer.valueOf(this.Uwu)).intValue();
        boolean gFa2 = gFa();
        if (gFa == gFa2) {
            return;
        }
        if (gFa2) {
            dsw().resume();
            rg(0);
            return;
        }
        dsw().pause();
    }

    @Override // com.tencent.mm.plugin.festival.model.ag
    public final void Fe(boolean z) {
        Log.i(getTAG(), "onForbiddenChange(" + z + ')');
        if (z) {
            Z(b.Uwv);
            rg(8);
            return;
        }
        Z(c.Uww);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void rg(int i2) {
        if (com.tencent.mm.ac.d.cW(this.Uwu, 32)) {
            super.rg(8);
        } else {
            super.rg(i2);
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final void pause() {
        Z(f.Uwz);
        super.pause();
    }

    @Override // com.tencent.mm.live.c.a
    public final void resume() {
        Z(g.UwA);
        super.resume();
    }

    @Override // com.tencent.mm.live.c.a
    public void statusChange(b.c cVar, Bundle bundle) {
        p.h(cVar, "status");
        switch (bp.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                Z(h.UwB);
                return;
            case 2:
                Z(i.UwC);
                return;
            case 3:
                Z(j.UwD);
                return;
            case 4:
                Z(k.UwE);
                rg(4);
                return;
            case 5:
                Z(l.UwF);
                return;
            default:
                return;
        }
    }

    public final void gFb() {
        Z(d.Uwx);
    }

    public final void gFc() {
        Z(e.Uwy);
    }
}
