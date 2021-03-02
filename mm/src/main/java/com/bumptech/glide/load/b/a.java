package com.bumptech.glide.load.b;

import android.os.Process;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.b.p;
import com.bumptech.glide.load.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* access modifiers changed from: package-private */
public final class a {
    private final boolean aCC;
    final ReferenceQueue<p<?>> aFA;
    p.a aFB;
    volatile boolean aFC;
    volatile AbstractC0067a aFD;
    private final Executor aFy;
    final Map<g, b> aFz;

    /* renamed from: com.bumptech.glide.load.b.a$a  reason: collision with other inner class name */
    interface AbstractC0067a {
    }

    a(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new ThreadFactory() {
            /* class com.bumptech.glide.load.b.a.AnonymousClass1 */

            public final Thread newThread(final Runnable runnable) {
                AppMethodBeat.i(204455);
                Thread thread = new Thread(new Runnable() {
                    /* class com.bumptech.glide.load.b.a.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(204454);
                        Process.setThreadPriority(10);
                        runnable.run();
                        AppMethodBeat.o(204454);
                    }
                }, "glide-active-resources");
                AppMethodBeat.o(204455);
                return thread;
            }
        }));
        AppMethodBeat.i(76918);
        AppMethodBeat.o(76918);
    }

    private a(boolean z, Executor executor) {
        AppMethodBeat.i(204456);
        this.aFz = new HashMap();
        this.aFA = new ReferenceQueue<>();
        this.aCC = z;
        this.aFy = executor;
        executor.execute(new Runnable() {
            /* class com.bumptech.glide.load.b.a.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(76915);
                a aVar = a.this;
                while (!aVar.aFC) {
                    try {
                        aVar.a((b) aVar.aFA.remove());
                        AbstractC0067a aVar2 = aVar.aFD;
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                    }
                }
                AppMethodBeat.o(76915);
            }
        });
        AppMethodBeat.o(204456);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(g gVar, p<?> pVar) {
        AppMethodBeat.i(76919);
        b put = this.aFz.put(gVar, new b(gVar, pVar, this.aFA, this.aCC));
        if (put != null) {
            put.reset();
        }
        AppMethodBeat.o(76919);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(g gVar) {
        AppMethodBeat.i(204457);
        b remove = this.aFz.remove(gVar);
        if (remove != null) {
            remove.reset();
        }
        AppMethodBeat.o(204457);
    }

    /* access modifiers changed from: package-private */
    public final synchronized p<?> b(g gVar) {
        p<?> pVar;
        AppMethodBeat.i(204458);
        b bVar = this.aFz.get(gVar);
        if (bVar == null) {
            pVar = null;
            AppMethodBeat.o(204458);
        } else {
            pVar = (p) bVar.get();
            if (pVar == null) {
                a(bVar);
            }
            AppMethodBeat.o(204458);
        }
        return pVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(b bVar) {
        AppMethodBeat.i(76920);
        synchronized (this.aFB) {
            try {
                synchronized (this) {
                    try {
                        this.aFz.remove(bVar.aFH);
                        if (bVar.aFI && bVar.aFJ != null) {
                            p<?> pVar = new p<>(bVar.aFJ, true, false);
                            pVar.a(bVar.aFH, this.aFB);
                            this.aFB.b(bVar.aFH, pVar);
                            AppMethodBeat.o(76920);
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(76920);
                        throw th;
                    }
                }
            } finally {
                AppMethodBeat.o(76920);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b extends WeakReference<p<?>> {
        final g aFH;
        final boolean aFI;
        v<?> aFJ;

        b(g gVar, p<?> pVar, ReferenceQueue<? super p<?>> referenceQueue, boolean z) {
            super(pVar, referenceQueue);
            AppMethodBeat.i(76916);
            this.aFH = (g) j.checkNotNull(gVar, "Argument must not be null");
            this.aFJ = (!pVar.aFI || !z) ? null : (v) j.checkNotNull(pVar.aFJ, "Argument must not be null");
            this.aFI = pVar.aFI;
            AppMethodBeat.o(76916);
        }

        /* access modifiers changed from: package-private */
        public final void reset() {
            AppMethodBeat.i(76917);
            this.aFJ = null;
            clear();
            AppMethodBeat.o(76917);
        }
    }
}
