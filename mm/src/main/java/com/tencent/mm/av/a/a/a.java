package com.tencent.mm.av.a.a;

import com.tencent.f.b;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.j;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public final class a {
    public static j tv(int i2) {
        AppMethodBeat.i(182799);
        C0274a aVar = new C0274a("image_loader_default", i2, i2, new com.tencent.mm.av.a.e.a());
        AppMethodBeat.o(182799);
        return aVar;
    }

    public static Executor bdc() {
        AppMethodBeat.i(182800);
        b bqp = h.RTc.bqp("image_loader_ImageTempFile");
        AppMethodBeat.o(182800);
        return bqp;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.av.a.a.a$a  reason: collision with other inner class name */
    public static class C0274a extends b implements j {
        private ReentrantLock ibI = new ReentrantLock();
        private Condition ibJ = this.ibI.newCondition();
        private BlockingQueue<Runnable> ibK;
        private boolean isPaused;

        public C0274a(String str, int i2, int i3, BlockingQueue<Runnable> blockingQueue) {
            super(str, i2, i3, blockingQueue, null);
            AppMethodBeat.i(182797);
            this.ibK = blockingQueue;
            AppMethodBeat.o(182797);
        }

        @Override // com.tencent.f.b
        public final void beforeExecute(Thread thread, Runnable runnable) {
            AppMethodBeat.i(130378);
            super.beforeExecute(thread, runnable);
            this.ibI.lock();
            while (this.isPaused) {
                try {
                    this.ibJ.await();
                } catch (Exception e2) {
                    thread.interrupt();
                    Log.w("MicroMsg.imageloader.DefaultThreadPoolExecutor", "[cpan] before execute exception:%s", e2.toString());
                    return;
                } finally {
                    this.ibI.unlock();
                    AppMethodBeat.o(130378);
                }
            }
        }

        @Override // com.tencent.f.b
        public final void afterExecute(Runnable runnable, Throwable th) {
            AppMethodBeat.i(182798);
            super.afterExecute(runnable, th);
            AppMethodBeat.o(182798);
        }

        @Override // com.tencent.mm.av.a.c.j
        public final void pause() {
            AppMethodBeat.i(130379);
            this.ibI.lock();
            try {
                this.isPaused = true;
            } finally {
                this.ibI.unlock();
                AppMethodBeat.o(130379);
            }
        }

        @Override // com.tencent.mm.av.a.c.j
        public final void resume() {
            AppMethodBeat.i(130380);
            this.ibI.lock();
            try {
                this.isPaused = false;
                this.ibJ.signalAll();
            } finally {
                this.ibI.unlock();
                AppMethodBeat.o(130380);
            }
        }

        @Override // com.tencent.f.b
        public final void execute(Runnable runnable) {
            AppMethodBeat.i(130381);
            super.execute(runnable);
            AppMethodBeat.o(130381);
        }

        @Override // com.tencent.mm.av.a.c.j
        public final boolean YY() {
            return this.isPaused;
        }

        @Override // com.tencent.mm.av.a.c.j
        public final void remove(Object obj) {
            AppMethodBeat.i(130382);
            if (this.ibK != null) {
                this.ibK.remove(obj);
            }
            AppMethodBeat.o(130382);
        }

        @Override // com.tencent.f.b, com.tencent.mm.av.a.c.j
        public final boolean isShutdown() {
            AppMethodBeat.i(130383);
            boolean isShutdown = super.isShutdown();
            AppMethodBeat.o(130383);
            return isShutdown;
        }
    }
}
