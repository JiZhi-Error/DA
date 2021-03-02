package com.tencent.mm.plugin.offline;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class a<T> {
    protected List<WeakReference<T>> AIc = new ArrayList();

    public final void dM(T t) {
        if (this.AIc != null) {
            this.AIc = new ArrayList();
        }
        this.AIc.add(new WeakReference<>(t));
    }

    public final void dN(T t) {
        T t2;
        if (this.AIc != null) {
            for (int i2 = 0; i2 < this.AIc.size(); i2++) {
                WeakReference<T> weakReference = this.AIc.get(i2);
                if (!(weakReference == null || (t2 = weakReference.get()) == null || !t2.equals(t))) {
                    weakReference.clear();
                    this.AIc.remove(weakReference);
                }
            }
        }
    }
}
