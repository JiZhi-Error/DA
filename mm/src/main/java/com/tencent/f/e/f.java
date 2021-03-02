package com.tencent.f.e;

import android.os.Handler;
import android.os.Looper;
import com.tencent.f.d;
import com.tencent.f.d.b;
import com.tencent.f.j.a;
import com.tencent.f.j.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;

public final class f<E> extends e<E> {
    @Override // com.tencent.f.e.e
    public final /* synthetic */ e a(a aVar) {
        AppMethodBeat.i(183311);
        f<R> c2 = c(aVar);
        AppMethodBeat.o(183311);
        return c2;
    }

    f() {
    }

    f(E e2) {
        super(e2);
    }

    public final <R> f<R> c(a<E, R> aVar) {
        AppMethodBeat.i(183306);
        Objects.requireNonNull(aVar);
        f<R> fVar = new f<>();
        fVar.RTN = hmr();
        fVar.RTQ = this;
        this.RTR = fVar;
        this.RTO = aVar;
        AppMethodBeat.o(183306);
        return fVar;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.f.e.e
    public final a<Throwable, ?> hmo() {
        while (this != null && this.RTP == null) {
            this = (f<E>) this.RTR;
        }
        if (this != null) {
            return this.RTP;
        }
        return null;
    }

    public final void begin() {
        AppMethodBeat.i(183307);
        if (!this.pCM.compareAndSet(false, true)) {
            d.RSS.w("Pipeline", "this pipeline has begin.", new Object[0]);
            AppMethodBeat.o(183307);
            return;
        }
        while (this.RTQ != null) {
            this = (f<E>) this.RTQ;
        }
        this.b(this.RTO);
        AppMethodBeat.o(183307);
    }

    @Override // com.tencent.f.e.e
    public final g hmr() {
        AppMethodBeat.i(183309);
        if (this.RTN == null) {
            g hmt = hmt();
            AppMethodBeat.o(183309);
            return hmt;
        }
        g gVar = this.RTN;
        AppMethodBeat.o(183309);
        return gVar;
    }

    public final f<E> hms() {
        this.RTN = RTH;
        return this;
    }

    private g hmt() {
        AppMethodBeat.i(183310);
        if (a.hmE() == null && Looper.myLooper() == null) {
            RuntimeException runtimeException = new RuntimeException(String.format("fail to create DefaultScheduler. Current thread[%s-%s] without a Looper or Serial.", Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId())));
            AppMethodBeat.o(183310);
            throw runtimeException;
        }
        AnonymousClass1 r0 = new g() {
            /* class com.tencent.f.e.f.AnonymousClass1 */
            private com.tencent.f.d.a RTV;

            {
                AppMethodBeat.i(183302);
                this.RTV = a.hmE() == null ? new b(new Handler(Looper.myLooper())) : new c(a.hmE());
                AppMethodBeat.o(183302);
            }

            public final void execute(Runnable runnable) {
                AppMethodBeat.i(183303);
                this.RTV.post(runnable);
                AppMethodBeat.o(183303);
            }

            @Override // com.tencent.f.e.g
            public final String getTag() {
                AppMethodBeat.i(183304);
                if (this.RTV instanceof c) {
                    String serialTag = this.RTV.getSerialTag();
                    AppMethodBeat.o(183304);
                    return serialTag;
                }
                String j2 = a.j(this.RTV.getLooper());
                AppMethodBeat.o(183304);
                return j2;
            }

            @Override // com.tencent.f.e.g
            public final void onShutdown() {
                AppMethodBeat.i(183305);
                this.RTV.removeCallbacksAndMessages(null);
                AppMethodBeat.o(183305);
            }
        };
        AppMethodBeat.o(183310);
        return r0;
    }

    @Override // com.tencent.f.e.e
    public final E take() {
        e eVar;
        String str;
        AppMethodBeat.i(183308);
        if (this.RTM == null) {
            a hmE = a.hmE();
            if (hmE == null) {
                str = a.j(Looper.myLooper());
                eVar = this;
            } else {
                str = hmE.tag;
                eVar = this;
            }
            while (eVar.RTQ != null) {
                if (eVar.RTN.getTag().equals(str)) {
                    RuntimeException runtimeException = new RuntimeException("this pipeline will happen dead lock in future. please to check it. serialTag=".concat(String.valueOf(str)));
                    AppMethodBeat.o(183308);
                    throw runtimeException;
                }
                eVar = eVar.RTQ;
            }
        }
        begin();
        E e2 = (E) super.take();
        AppMethodBeat.o(183308);
        return e2;
    }

    @Override // com.tencent.f.e.e
    public final /* bridge */ /* synthetic */ e hmq() {
        this.RTN = RTJ;
        return this;
    }
}
