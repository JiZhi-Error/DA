package com.google.android.gms.common.util;

import java.util.ArrayList;

public abstract class ObjectPoolBase<T> {
    private final ArrayList<T> zzaag;
    private final int zzaah;

    public ObjectPoolBase(int i2) {
        this.zzaag = new ArrayList<>(i2);
        this.zzaah = i2;
    }

    public final T aquire() {
        T remove;
        synchronized (this.zzaag) {
            int size = this.zzaag.size();
            remove = size > 0 ? this.zzaag.remove(size - 1) : newObject();
        }
        return remove;
    }

    /* access modifiers changed from: protected */
    public boolean cleanUpObject(T t) {
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract T newObject();

    public final boolean release(T t) {
        boolean z = false;
        synchronized (this.zzaag) {
            int size = this.zzaag.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.zzaag.get(i2) == t) {
                    String valueOf = String.valueOf(t);
                    throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 25).append("Object released already: ").append(valueOf).toString());
                }
            }
            if (size < this.zzaah && cleanUpObject(t)) {
                this.zzaag.add(t);
                z = true;
            }
        }
        return z;
    }
}
