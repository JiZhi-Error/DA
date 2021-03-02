package com.tencent.tbs.one.impl.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.concurrent.Callable;

public abstract class b<T> extends a<T> {

    /* renamed from: b  reason: collision with root package name */
    final File f2348b;

    /* renamed from: c  reason: collision with root package name */
    final long f2349c = 10000;

    /* renamed from: d  reason: collision with root package name */
    j f2350d;

    public b(File file) {
        this.f2348b = file;
    }

    private void d() {
        if (this.f2350d != null) {
            this.f2350d.a();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tbs.one.impl.a.a
    public final void a() {
        m.d(new Runnable() {
            /* class com.tencent.tbs.one.impl.a.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(173894);
                try {
                    b bVar = b.this;
                    File file = b.this.f2348b;
                    AnonymousClass1 r2 = new Callable<Boolean>() {
                        /* class com.tencent.tbs.one.impl.a.b.AnonymousClass1.AnonymousClass1 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // java.util.concurrent.Callable
                        public final /* synthetic */ Boolean call() {
                            AppMethodBeat.i(173895);
                            Boolean valueOf = Boolean.valueOf(!b.this.f2326a);
                            AppMethodBeat.o(173895);
                            return valueOf;
                        }
                    };
                    bVar.f2350d = (j) j.a(new Callable<j>(r2, file) {
                        /* class com.tencent.tbs.one.impl.a.j.AnonymousClass1 */

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ Callable f2367a;

                        /* renamed from: b  reason: collision with root package name */
                        final /* synthetic */ File f2368b;

                        {
                            this.f2367a = r1;
                            this.f2368b = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // java.util.concurrent.Callable
                        public final /* synthetic */ j call() {
                            AppMethodBeat.i(173924);
                            if (!((Boolean) this.f2367a.call()).booleanValue()) {
                                Exception exc = new Exception("Aborted");
                                AppMethodBeat.o(173924);
                                throw exc;
                            }
                            j a2 = j.a(this.f2368b);
                            AppMethodBeat.o(173924);
                            return a2;
                        }
                    }, file, b.this.f2349c);
                    b.this.c();
                    AppMethodBeat.o(173894);
                } catch (Exception e2) {
                    b.this.a(e2);
                    AppMethodBeat.o(173894);
                }
            }
        });
    }

    @Override // com.tencent.tbs.one.impl.a.a
    public void a(int i2, String str, Throwable th) {
        d();
        super.a(i2, str, th);
    }

    public abstract void a(Exception exc);

    @Override // com.tencent.tbs.one.impl.a.a
    public void a(T t) {
        d();
        super.a((Object) t);
    }

    public abstract void c();
}
