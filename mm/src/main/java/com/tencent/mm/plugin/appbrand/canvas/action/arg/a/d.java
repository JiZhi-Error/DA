package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionWrapper;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.sdk.SynchronizedPool;

public final class d {
    private static d lad = new d();
    public SynchronizedPool<DrawCanvasArg> laa = new SynchronizedPool<>(5);
    public SynchronizedPool<DrawActionWrapper> lab = new SynchronizedPool<>(500);

    static {
        AppMethodBeat.i(145320);
        AppMethodBeat.o(145320);
    }

    private d() {
        AppMethodBeat.i(145319);
        AppMethodBeat.o(145319);
    }

    public static d bzo() {
        return lad;
    }
}
