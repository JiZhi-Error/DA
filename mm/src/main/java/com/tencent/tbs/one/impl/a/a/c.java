package com.tencent.tbs.one.impl.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    AtomicBoolean f2336a = new AtomicBoolean();

    /* renamed from: b  reason: collision with root package name */
    d f2337b;

    /* renamed from: c  reason: collision with root package name */
    List<c> f2338c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private boolean f2339d;

    /* renamed from: e  reason: collision with root package name */
    private AtomicBoolean f2340e = new AtomicBoolean();

    /* renamed from: f  reason: collision with root package name */
    private List<Runnable> f2341f = new ArrayList();

    /* access modifiers changed from: package-private */
    public final void a() {
        if (!this.f2339d) {
            this.f2339d = true;
            if (this.f2338c == null || this.f2338c.size() <= 0) {
                b();
            } else {
                for (c cVar : this.f2338c) {
                    cVar.f2337b = this.f2337b;
                    cVar.f2341f.add(new Runnable() {
                        /* class com.tencent.tbs.one.impl.a.a.c.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(173944);
                            c cVar = c.this;
                            Iterator<c> it = cVar.f2338c.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (!it.next().f2336a.get()) {
                                        break;
                                    }
                                } else {
                                    cVar.b();
                                    break;
                                }
                            }
                            AppMethodBeat.o(173944);
                        }
                    });
                    cVar.a();
                }
            }
            this.f2337b.a();
        }
    }

    public final void a(int i2, String str, Throwable th) {
        d dVar = this.f2337b;
        if (dVar.f2343a != null) {
            dVar.f2343a.a(i2, str, th);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        if (this.f2340e.compareAndSet(false, true)) {
            this.f2337b.b(this);
        }
    }

    public final void b(c cVar) {
        this.f2338c.add(cVar);
    }

    public final void c() {
        if (this.f2336a.compareAndSet(false, true)) {
            for (Runnable runnable : this.f2341f) {
                runnable.run();
            }
            this.f2337b.b();
        }
    }
}
