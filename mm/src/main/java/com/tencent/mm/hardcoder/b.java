package com.tencent.mm.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.a;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class b implements Runnable {
    private Queue<Object> hlp = new ConcurrentLinkedQueue();
    private boolean hlq = false;
    private Thread thread = null;

    public b() {
        AppMethodBeat.i(62452);
        AppMethodBeat.o(62452);
    }

    public final synchronized void start() {
        AppMethodBeat.i(62453);
        if (this.thread == null) {
            this.thread = new Thread(this);
            this.thread.setPriority(5);
            this.thread.start();
        }
        AppMethodBeat.o(62453);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 175
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:72)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:46)
        */
    public final void run() {
        /*
        // Method dump skipped, instructions count: 433
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.hardcoder.b.run():void");
    }

    public final void bc(Object obj) {
        AppMethodBeat.i(62455);
        if (this.hlp != null) {
            synchronized (this) {
                try {
                    this.hlp.add(obj);
                    notify();
                } finally {
                    AppMethodBeat.o(62455);
                }
            }
            return;
        }
        AppMethodBeat.o(62455);
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public final void finalize() {
        AppMethodBeat.i(62456);
        super.finalize();
        this.hlp.clear();
        AppMethodBeat.o(62456);
    }

    public static class a {
        public final int[] hln;
        public final List<a.b> hlr;
        public final int hls;
        public final int hlt;
        public final int hlu;
        public final long time;

        public a(long j2, List<a.b> list, int i2, int i3, int i4, int[] iArr) {
            this.time = j2;
            this.hlr = list;
            this.hls = i2;
            this.hlt = i3;
            this.hlu = i4;
            this.hln = iArr;
        }
    }
}
