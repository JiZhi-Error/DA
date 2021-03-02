package com.tencent.mm.plugin.taskbar.ui.a;

import android.content.Context;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\rH\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/dynamicbackground/DynamicBgServiceImpl;", "Lcom/tencent/mm/dynamicbackground/model/DynamicBgService;", "()V", "getDisplayRealSize", "Landroid/graphics/Point;", "context", "Landroid/content/Context;", "getSleepTimeInMsPerFrame", "", "isEnableNativeDynamicBackground", "", "isInitCrash", "loadDynamicBgLibrary", "", "markDrawEndPoint", "markDrawStartPoint", "markWillCrash", "needMarkDrawPoint", "onInitCrash", "onInitEnd", "onInitStart", "setEnableNativeDynamicBackground", "enable", "willCrash", "Companion", "plugin-taskbar_release"})
public final class e implements c {
    public static final a FVf = new a((byte) 0);

    static {
        AppMethodBeat.i(238491);
        AppMethodBeat.o(238491);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/dynamicbackground/DynamicBgServiceImpl$Companion;", "", "()V", "TAG", "", "plugin-taskbar_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.dynamicbackground.model.c
    public final Point az(Context context) {
        AppMethodBeat.i(238478);
        p.h(context, "context");
        Point az = ao.az(context);
        p.g(az, "UIUtils.getDisplayRealSize(context)");
        AppMethodBeat.o(238478);
        return az;
    }

    @Override // com.tencent.mm.dynamicbackground.model.c
    public final float atM() {
        AppMethodBeat.i(238479);
        a aVar = a.FUZ;
        float fuY = a.fuY();
        AppMethodBeat.o(238479);
        return fuY;
    }

    @Override // com.tencent.mm.dynamicbackground.model.c
    public final void atD() {
        AppMethodBeat.i(238480);
        Log.i("MicroMsg.DynamicBgServiceImpl", "alvinluo loadDynamicBgLibrary");
        if (com.tencent.mm.plugin.taskbar.e.atB()) {
            c.fve();
        }
        try {
            System.loadLibrary("dynamicBg");
            AppMethodBeat.o(238480);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.DynamicBgServiceImpl", th, "alvinluo DynamicBackgroundNative exception", new Object[0]);
            c.fvd();
            AppMethodBeat.o(238480);
        }
    }

    @Override // com.tencent.mm.dynamicbackground.model.c
    public final boolean atB() {
        AppMethodBeat.i(238481);
        boolean atB = com.tencent.mm.plugin.taskbar.e.atB();
        AppMethodBeat.o(238481);
        return atB;
    }

    @Override // com.tencent.mm.dynamicbackground.model.b
    public final boolean atI() {
        AppMethodBeat.i(238482);
        boolean atI = c.atI();
        AppMethodBeat.o(238482);
        return atI;
    }

    @Override // com.tencent.mm.dynamicbackground.model.b
    public final void atL() {
        AppMethodBeat.i(238483);
        c.atL();
        AppMethodBeat.o(238483);
    }

    @Override // com.tencent.mm.dynamicbackground.model.b
    public final void atK() {
        AppMethodBeat.i(238484);
        c.atK();
        AppMethodBeat.o(238484);
    }

    @Override // com.tencent.mm.dynamicbackground.model.b
    public final void atF() {
        AppMethodBeat.i(238485);
        c.atF();
        AppMethodBeat.o(238485);
    }

    @Override // com.tencent.mm.dynamicbackground.model.b
    public final boolean atJ() {
        AppMethodBeat.i(238486);
        boolean atJ = c.atJ();
        AppMethodBeat.o(238486);
        return atJ;
    }

    @Override // com.tencent.mm.dynamicbackground.model.b
    public final void atG() {
        AppMethodBeat.i(238487);
        c.fvd();
        AppMethodBeat.o(238487);
    }

    @Override // com.tencent.mm.dynamicbackground.model.b
    public final void atH() {
        AppMethodBeat.i(238488);
        c.fvf();
        AppMethodBeat.o(238488);
    }

    @Override // com.tencent.mm.dynamicbackground.model.c
    public final void atC() {
        AppMethodBeat.i(238489);
        com.tencent.mm.plugin.taskbar.e.wj(false);
        AppMethodBeat.o(238489);
    }

    @Override // com.tencent.mm.dynamicbackground.model.b
    public final boolean atE() {
        AppMethodBeat.i(238490);
        boolean fvg = c.fvg();
        AppMethodBeat.o(238490);
        return fvg;
    }
}
