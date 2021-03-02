package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.service.f;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0014¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/live/model/RoomLivePageFloatBallHelper;", "Lcom/tencent/mm/plugin/ball/service/PageFloatBallHelper;", "pageAdapter", "Lcom/tencent/mm/plugin/ball/adapter/IFloatBallPageAdapter;", "(Lcom/tencent/mm/plugin/ball/adapter/IFloatBallPageAdapter;)V", "initReportInfo", "", "isSupportFloatBallMenu", "", "isSupportSwipeToFloatBall", "onCreate", "floatBallType", "", "floatBallKey", "", "onEnterPageWithoutFloatBall", "onExitPage", "onReceivedFinishWhenSwitchBallEvent", "Companion", "plugin-logic_release"})
public final class w extends f {
    public static final a hIp = new a((byte) 0);

    static {
        AppMethodBeat.i(207702);
        AppMethodBeat.o(207702);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/live/model/RoomLivePageFloatBallHelper$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w(com.tencent.mm.plugin.ball.a.f fVar) {
        super(fVar);
        p.h(fVar, "pageAdapter");
        AppMethodBeat.i(207701);
        AppMethodBeat.o(207701);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGf() {
        AppMethodBeat.i(207697);
        ((b) g.af(b.class)).jS(true);
        super.aGf();
        AppMethodBeat.o(207697);
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
        AppMethodBeat.i(207698);
        super.G(i2, str);
        ciw().hDa = 16;
        civ();
        AppMethodBeat.o(207698);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGi() {
        AppMethodBeat.i(207699);
        super.aGi();
        this.oXA.hb(false);
        AppMethodBeat.o(207699);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGj() {
        AppMethodBeat.i(207700);
        ((b) g.af(b.class)).jS(false);
        this.oWE.oWs.opType = 4;
        super.aGj();
        AppMethodBeat.o(207700);
    }
}
