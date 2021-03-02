package com.tencent.mm.loader.e.b;

import android.view.View;
import com.tencent.mm.loader.h.a.a;
import java.lang.ref.WeakReference;

public final class g<T> {
    public int height = 0;
    private WeakReference<T> iaF;
    a iaG = a.aKt();
    final int iaH;
    public int width = 0;

    public g(T t) {
        this.iaF = new WeakReference<>(t);
        if (t != null) {
            this.iaH = t.hashCode();
        } else {
            this.iaH = hashCode();
        }
    }

    public g(T t, a aVar) {
        this.iaF = new WeakReference<>(t);
        if (t != null) {
            this.iaH = t.hashCode();
        } else {
            this.iaH = hashCode();
        }
        this.iaG = aVar;
    }

    public final T get() {
        if (this.iaF == null) {
            return null;
        }
        return this.iaF.get();
    }

    public final View getView() {
        T t;
        if (this.iaF == null || (t = this.iaF.get()) == null || !(t instanceof View)) {
            return null;
        }
        return t;
    }
}
