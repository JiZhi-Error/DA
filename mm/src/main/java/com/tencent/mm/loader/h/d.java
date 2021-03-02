package com.tencent.mm.loader.h;

import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;

public final class d<K, V> {
    private f<K, V> icd;

    public d(int i2) {
        this.icd = new c(i2);
    }

    public final V aT(K k) {
        if (this.icd != null) {
            return this.icd.aT(k);
        }
        throw new NullPointerException("mData == null");
    }

    public final void clear() {
        if (this.icd == null) {
            throw new NullPointerException("mData == null");
        }
        this.icd.trimToSize(-1);
    }

    public final synchronized boolean check(K k) {
        if (this.icd == null) {
            throw new NullPointerException("mData == null");
        }
        return this.icd.check(k);
    }

    public final V get(K k) {
        if (this.icd != null) {
            return this.icd.get(k);
        }
        throw new NullPointerException("mData == null");
    }

    public final V put(K k, V v) {
        if (this.icd != null) {
            return this.icd.put(k, v);
        }
        throw new NullPointerException("mData == null");
    }

    public final V remove(K k) {
        if (this.icd != null) {
            return this.icd.remove(k);
        }
        throw new NullPointerException("mData == null");
    }

    public final synchronized String toString() {
        if (this.icd == null) {
            throw new NullPointerException("mData == null");
        }
        return this.icd.toString();
    }
}
