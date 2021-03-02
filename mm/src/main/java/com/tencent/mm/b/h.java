package com.tencent.mm.b;

import com.tencent.mm.b.f;
import com.tencent.mm.sdk.platformtools.LruCache;

public class h<K, O> extends LruCache<K, O> implements f<K, O> {
    private f.b<K, O> dgK = null;
    private f.c<K, O> dgL = null;

    public h(int i2) {
        super(i2);
    }

    @Override // com.tencent.mm.b.f
    public final void x(K k, O o) {
        if (o != null && k != null) {
            put(k, o);
        }
    }

    @Override // com.tencent.mm.b.f
    public void clear() {
        trimToSize(-1);
    }

    @Override // com.tencent.mm.b.f
    public final O aT(K k) {
        return (O) get(k);
    }

    public h(int i2, f.b<K, O> bVar) {
        super(i2);
        this.dgK = bVar;
    }

    public h(int i2, f.b<K, O> bVar, f.c<K, O> cVar) {
        super(i2);
        this.dgK = bVar;
        this.dgL = cVar;
    }

    @Override // com.tencent.mm.b.f, com.tencent.mm.sdk.platformtools.LruCache
    public void trimToSize(int i2) {
        super.trimToSize(i2);
    }

    @Override // com.tencent.mm.sdk.platformtools.LruCache
    public O create(K k) {
        return (O) super.create(k);
    }

    @Override // com.tencent.mm.sdk.platformtools.LruCache
    public void entryRemoved(boolean z, K k, O o, O o2) {
        super.entryRemoved(z, k, o, o2);
        if (this.dgK != null) {
            this.dgK.c(k, o, o2);
        }
    }

    @Override // com.tencent.mm.b.f, com.tencent.mm.sdk.platformtools.LruCache
    public int sizeOf(K k, O o) {
        if (this.dgL != null) {
            return this.dgL.y(k, o);
        }
        return super.sizeOf(k, o);
    }

    @Override // com.tencent.mm.b.f
    public void a(f.a<K, O> aVar) {
        clear();
    }
}
