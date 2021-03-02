package com.tencent.mm.plugin.recordvideo.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/model/RecordVideoManager;", "", "()V", "displayHeight", "", "getDisplayHeight", "()I", "setDisplayHeight", "(I)V", "displayWidth", "getDisplayWidth", "setDisplayWidth", "getWorkingHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "plugin-recordvideo_release"})
public final class a {
    public static final a BOO = new a();
    private static int displayHeight = au.az(MMApplicationContext.getContext()).y;
    private static int displayWidth = au.az(MMApplicationContext.getContext()).x;

    static {
        AppMethodBeat.i(75395);
        AppMethodBeat.o(75395);
    }

    private a() {
    }

    public static void VA(int i2) {
        displayWidth = i2;
    }

    public static int eJO() {
        return displayWidth;
    }

    public static void BC(int i2) {
        displayHeight = i2;
    }

    public static int getDisplayHeight() {
        return displayHeight;
    }

    public static MMHandler eJP() {
        AppMethodBeat.i(75394);
        MMHandlerThread aAk = g.aAk();
        p.g(aAk, "MMKernel.getPizzaWorkerThread()");
        MMHandler workerHandler = aAk.getWorkerHandler();
        p.g(workerHandler, "MMKernel.getPizzaWorkerThread().workerHandler");
        AppMethodBeat.o(75394);
        return workerHandler;
    }
}
