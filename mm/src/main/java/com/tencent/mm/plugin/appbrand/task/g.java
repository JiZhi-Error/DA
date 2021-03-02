package com.tencent.mm.plugin.appbrand.task;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.game.f.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public enum g {
    WASERVICE(1, Integer.MAX_VALUE, c.class, ag.class),
    WAGAME(2, 2, com.tencent.mm.plugin.appbrand.game.c.class, d.class),
    NIL(0, 0, null, null);
    
    public final int code;
    public final int nPG;
    public final Class<? extends s> nPH;
    public final Class<? extends ac> nPI;

    public static g valueOf(String str) {
        AppMethodBeat.i(48430);
        g gVar = (g) Enum.valueOf(g.class, str);
        AppMethodBeat.o(48430);
        return gVar;
    }

    static {
        AppMethodBeat.i(48433);
        AppMethodBeat.o(48433);
    }

    private g(int i2, int i3, Class cls, Class cls2) {
        AppMethodBeat.i(227483);
        this.code = i2;
        if (this.code == 2) {
            this.nPG = bVW();
        } else {
            this.nPG = i3;
        }
        this.nPH = cls;
        this.nPI = cls2;
        AppMethodBeat.o(227483);
    }

    public final Intent K(Intent intent) {
        AppMethodBeat.i(227484);
        intent.putExtra("AppBrandServiceType", this.code);
        AppMethodBeat.o(227484);
        return intent;
    }

    public static g L(Intent intent) {
        AppMethodBeat.i(48431);
        int intExtra = intent.getIntExtra("AppBrandServiceType", NIL.code);
        g[] values = values();
        for (g gVar : values) {
            if (gVar.code == intExtra) {
                AppMethodBeat.o(48431);
                return gVar;
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException("AppBrandServiceType DeserializeFrom[Intent] Unreached Code");
        AppMethodBeat.o(48431);
        throw illegalStateException;
    }

    public static g j(AppBrandInitConfigWC appBrandInitConfigWC) {
        AppMethodBeat.i(48432);
        if (appBrandInitConfigWC.NA()) {
            g gVar = WAGAME;
            AppMethodBeat.o(48432);
            return gVar;
        }
        g gVar2 = WASERVICE;
        AppMethodBeat.o(48432);
        return gVar2;
    }

    public static g iD(boolean z) {
        if (z) {
            return WAGAME;
        }
        return WASERVICE;
    }

    public static g zm(int i2) {
        AppMethodBeat.i(227485);
        g[] values = values();
        for (g gVar : values) {
            if (gVar.code == i2) {
                AppMethodBeat.o(227485);
                return gVar;
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException("AppBrandServiceType DeserializeFrom[Int] Unreached Code");
        AppMethodBeat.o(227485);
        throw illegalStateException;
    }

    public static int bVW() {
        AppMethodBeat.i(227486);
        int a2 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_android_wagame_task_num, 2);
        Log.i("AppBrandServiceType", "getGameTaskExptNum exp:%d", Integer.valueOf(a2));
        if (a2 <= 0) {
            AppMethodBeat.o(227486);
            return 2;
        }
        AppMethodBeat.o(227486);
        return a2;
    }
}
