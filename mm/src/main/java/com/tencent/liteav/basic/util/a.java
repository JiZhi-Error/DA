package com.tencent.liteav.basic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadLocal<T> f447a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private final AbstractC0156a<T> f448b;

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<T> f449c = new WeakReference<>(null);

    /* renamed from: com.tencent.liteav.basic.util.a$a  reason: collision with other inner class name */
    public interface AbstractC0156a<T> {
        T a();
    }

    public a(AbstractC0156a<T> aVar) {
        AppMethodBeat.i(14741);
        this.f448b = aVar;
        AppMethodBeat.o(14741);
    }

    public T a() {
        AppMethodBeat.i(14742);
        T t = this.f447a.get();
        if (t == null) {
            t = b();
            this.f447a.set(t);
        }
        AppMethodBeat.o(14742);
        return t;
    }

    private T b() {
        AppMethodBeat.i(14743);
        T t = this.f449c.get();
        if (t == null) {
            synchronized (this) {
                try {
                    t = this.f449c.get();
                    if (t == null) {
                        t = this.f448b.a();
                        this.f449c = new WeakReference<>(t);
                    }
                } finally {
                    AppMethodBeat.o(14743);
                }
            }
        }
        return t;
    }
}
