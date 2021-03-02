package com.tencent.mm.plugin.finder.live.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.service.f;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\bJ\b\u0010\u0012\u001a\u00020\u0006H\u0014¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/FinderLivePageFloatBallHelper;", "Lcom/tencent/mm/plugin/ball/service/PageFloatBallHelper;", "pageAdapter", "Lcom/tencent/mm/plugin/ball/adapter/IFloatBallPageAdapter;", "(Lcom/tencent/mm/plugin/ball/adapter/IFloatBallPageAdapter;)V", "initReportInfo", "", "isSupportFloatBallMenu", "", "isSupportSwipeToFloatBall", "onCreate", "floatBallType", "", "floatBallKey", "", "onEnterPageWithoutFloatBall", "onExitPage", "hideFloatBall", "onReceivedFinishWhenSwitchBallEvent", "Companion", "plugin-finder_release"})
public final class j extends f {
    private static String uzR;
    public static final a uzS = new a((byte) 0);

    static {
        AppMethodBeat.i(247557);
        AppMethodBeat.o(247557);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/FinderLivePageFloatBallHelper$Companion;", "", "()V", "TAG", "", "activateUIKey", "getActivateUIKey", "()Ljava/lang/String;", "setActivateUIKey", "(Ljava/lang/String;)V", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(com.tencent.mm.plugin.ball.a.f fVar) {
        super(fVar);
        p.h(fVar, "pageAdapter");
        AppMethodBeat.i(247556);
        AppMethodBeat.o(247556);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGf() {
        AppMethodBeat.i(247551);
        ((b) g.af(b.class)).jS(true);
        super.aGf();
        AppMethodBeat.o(247551);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean aGg() {
        return false;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean aGh() {
        return false;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void G(int i2, String str) {
        AppMethodBeat.i(247552);
        super.G(i2, str);
        ciw().hDa = 15;
        civ();
        AppMethodBeat.o(247552);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGi() {
        AppMethodBeat.i(247553);
        super.aGi();
        this.oXA.hb(false);
        AppMethodBeat.o(247553);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGj() {
        AppMethodBeat.i(247554);
        ((b) g.af(b.class)).jS(false);
        this.oWE.oWs.opType = 4;
        super.aGj();
        AppMethodBeat.o(247554);
    }

    public final void nA(boolean z) {
        AppMethodBeat.i(247555);
        ((b) g.af(b.class)).jS(z);
        this.oWE.oWs.opType = 4;
        super.aGj();
        AppMethodBeat.o(247555);
    }
}
