package com.tencent.f.h;

import com.tencent.f.i.d;
import com.tencent.f.i.k;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a implements d {
    private final AtomicBoolean RUo = new AtomicBoolean(false);

    /* renamed from: com.tencent.f.h.a$a  reason: collision with other inner class name */
    public interface AbstractC0138a {
        void h(k<?> kVar);
    }

    /* access modifiers changed from: protected */
    public abstract AbstractC0138a hmw();

    /* access modifiers changed from: protected */
    public abstract void onShutdown();

    a() {
    }

    public final void shutdown() {
        if (this.RUo.compareAndSet(false, true)) {
            onShutdown();
        }
    }

    @Override // com.tencent.f.h.d
    public final boolean isShutdown() {
        return this.RUo.get();
    }

    /* renamed from: f */
    public final <V> d<V> g(k<V> kVar) {
        if (this.RUo.get()) {
            com.tencent.f.d.RSQ.g(kVar.getKey(), kVar.RUM, getName());
        } else if (!kVar.isCancelled()) {
            hmw().h(kVar);
            return kVar;
        } else {
            com.tencent.f.d.RSS.w("[BasePool#input] task=%s pool=%s", kVar.getKey() + "#" + kVar.RUM, getName());
        }
        return null;
    }
}
