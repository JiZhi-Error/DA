package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.sdk.platformtools.SimpleObjectPool;

public abstract class b {
    private SimpleObjectPool<a> kZX = new SimpleObjectPool<>(100);

    public abstract a bzm();

    public final a bzl() {
        a acquire = this.kZX.acquire();
        if (acquire == null) {
            return bzm();
        }
        return acquire;
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.kZX.release(aVar);
        }
    }
}
