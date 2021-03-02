package com.tencent.mm.plugin.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.j;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public final class b {
    public final int rdt;
    public final int rdu;
    public final Executor rdv;

    public static class a {
        int rdt;
        int rdu;
        Executor rdv;
    }

    public b(a aVar) {
        this.rdt = aVar.rdt;
        this.rdu = aVar.rdu;
        this.rdv = aVar.rdv;
    }

    /* renamed from: com.tencent.mm.plugin.emoji.sync.b$b  reason: collision with other inner class name */
    public static class C0960b extends com.tencent.f.b implements j {
        private ReentrantLock ibI = new ReentrantLock();
        private boolean isPaused;
        private Condition rdw = this.ibI.newCondition();

        public C0960b(int i2, int i3, BlockingQueue<Runnable> blockingQueue) {
            super("bkg_loader_default", i2, i3, blockingQueue);
            AppMethodBeat.i(108747);
            AppMethodBeat.o(108747);
        }

        @Override // com.tencent.f.b
        public final void beforeExecute(Thread thread, Runnable runnable) {
            AppMethodBeat.i(108748);
            super.beforeExecute(thread, runnable);
            this.ibI.lock();
            while (this.isPaused) {
                try {
                    this.rdw.await();
                } catch (Exception e2) {
                    thread.interrupt();
                    Log.w("MicroMsg.imageloader.DefaultThreadPoolExecutor", "[cpan] before execute exception:%s", e2.toString());
                    return;
                } finally {
                    this.ibI.unlock();
                    AppMethodBeat.o(108748);
                }
            }
        }

        @Override // com.tencent.mm.av.a.c.j
        public final void pause() {
            AppMethodBeat.i(108749);
            this.ibI.lock();
            try {
                this.isPaused = true;
            } finally {
                this.ibI.unlock();
                AppMethodBeat.o(108749);
            }
        }

        @Override // com.tencent.mm.av.a.c.j
        public final void resume() {
            AppMethodBeat.i(108750);
            this.ibI.lock();
            try {
                this.isPaused = false;
                this.rdw.signalAll();
            } finally {
                this.ibI.unlock();
                AppMethodBeat.o(108750);
            }
        }

        @Override // com.tencent.f.b
        public final void execute(Runnable runnable) {
            AppMethodBeat.i(108751);
            super.execute(runnable);
            AppMethodBeat.o(108751);
        }

        @Override // com.tencent.mm.av.a.c.j
        public final boolean YY() {
            return this.isPaused;
        }

        @Override // com.tencent.mm.av.a.c.j
        public final void remove(Object obj) {
        }

        @Override // com.tencent.f.b, com.tencent.mm.av.a.c.j
        public final boolean isShutdown() {
            AppMethodBeat.i(108752);
            boolean isShutdown = super.isShutdown();
            AppMethodBeat.o(108752);
            return isShutdown;
        }
    }
}
