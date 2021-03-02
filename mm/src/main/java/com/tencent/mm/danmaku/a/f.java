package com.tencent.mm.danmaku.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.c.a;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class f {
    a gNt;
    final SparseArray<BlockingQueue<com.tencent.mm.danmaku.b.a>> gOp = new SparseArray<>();
    private final BlockingQueue<com.tencent.mm.danmaku.b.a> gOq = new LinkedBlockingQueue();

    public f(a aVar) {
        AppMethodBeat.i(241643);
        this.gNt = aVar;
        AppMethodBeat.o(241643);
    }
}
