package com.c.a.c;

public final class k<V> extends b implements j {
    private transient V[] cql;
    private transient long[] cqy;
    protected final j cqz = this;

    /* access modifiers changed from: protected */
    @Override // com.c.a.c.b
    public final int hw(int i2) {
        int hw = super.hw(i2);
        this.cql = (V[]) new Object[hw];
        this.cqy = new long[hw];
        return hw;
    }

    /* access modifiers changed from: protected */
    @Override // com.c.a.c.b
    public final int capacity() {
        return this.cql.length;
    }

    public final V a(long j2, V v) {
        boolean d2;
        V v2 = null;
        int aV = aV(j2);
        boolean z = true;
        if (aV < 0) {
            aV = (-aV) - 1;
            v2 = (V) aF(this.cql[aV]);
            z = false;
            d2 = false;
        } else {
            d2 = d(this.cql, aV);
        }
        this.cqy[aV] = j2;
        V[] vArr = this.cql;
        if (v == null) {
            v = (V) n.cqF;
        }
        vArr[aV] = v;
        if (z) {
            bO(d2);
        }
        return v2;
    }

    /* access modifiers changed from: protected */
    @Override // com.c.a.c.b
    public final void hx(int i2) {
        int length = this.cqy.length;
        long[] jArr = this.cqy;
        V[] vArr = this.cql;
        this.cqy = new long[i2];
        this.cql = (V[]) new Object[i2];
        while (true) {
            length--;
            if (length <= 0) {
                return;
            }
            if (b(vArr, length)) {
                long j2 = jArr[length];
                int aV = aV(j2);
                this.cqy[aV] = j2;
                this.cql[aV] = vArr[length];
            }
        }
    }

    public final V get(long j2) {
        int index = index(j2);
        if (index < 0) {
            return null;
        }
        return (V) aF(this.cql[index]);
    }

    private static <V> V aF(V v) {
        if (v == n.cqF) {
            return null;
        }
        return v;
    }

    @Override // com.c.a.c.b
    public final void clear() {
        super.clear();
        long[] jArr = this.cqy;
        V[] vArr = this.cql;
        int length = jArr.length;
        while (true) {
            int i2 = length - 1;
            if (length > 0) {
                jArr[i2] = 0;
                vArr[i2] = null;
                length = i2;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final int index(long j2) {
        long[] jArr = this.cqy;
        V[] vArr = this.cql;
        int length = jArr.length;
        int aU = Integer.MAX_VALUE & this.cqz.aU(j2);
        int i2 = aU % length;
        if (!d(vArr, i2) && (c(vArr, i2) || jArr[i2] != j2)) {
            int i3 = (aU % (length - 2)) + 1;
            while (true) {
                i2 -= i3;
                if (i2 < 0) {
                    i2 += length;
                }
                if (d(vArr, i2) || (!c(vArr, i2) && jArr[i2] == j2)) {
                    break;
                }
            }
        }
        if (d(vArr, i2)) {
            return -1;
        }
        return i2;
    }

    private int aV(long j2) {
        V[] vArr = this.cql;
        long[] jArr = this.cqy;
        int length = jArr.length;
        int aU = this.cqz.aU(j2) & Integer.MAX_VALUE;
        int i2 = aU % length;
        if (d(vArr, i2)) {
            return i2;
        }
        if (b(vArr, i2) && jArr[i2] == j2) {
            return (-i2) - 1;
        }
        int i3 = (aU % (length - 2)) + 1;
        int i4 = c(vArr, i2) ? i2 : -1;
        do {
            i2 -= i3;
            if (i2 < 0) {
                i2 += length;
            }
            if (i4 == -1 && c(vArr, i2)) {
                i4 = i2;
            }
            if (!b(vArr, i2)) {
                break;
            }
        } while (jArr[i2] != j2);
        if (c(vArr, i2)) {
            while (!d(vArr, i2) && (c(vArr, i2) || jArr[i2] != j2)) {
                i2 -= i3;
                if (i2 < 0) {
                    i2 += length;
                }
            }
        }
        if (b(vArr, i2)) {
            return (-i2) - 1;
        }
        return i4 != -1 ? i4 : i2;
    }

    private static boolean b(Object[] objArr, int i2) {
        Object obj = objArr[i2];
        return (obj == null || obj == n.cqE) ? false : true;
    }

    private static boolean c(Object[] objArr, int i2) {
        return objArr[i2] == n.cqE;
    }

    private static boolean d(Object[] objArr, int i2) {
        return objArr[i2] == null;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        if (kVar.size() == size()) {
            return a(new a(kVar));
        }
        return false;
    }

    public final int hashCode() {
        b bVar = new b();
        a(bVar);
        return bVar.f111h;
    }

    final class b implements l<V> {

        /* renamed from: h  reason: collision with root package name */
        int f111h;

        b() {
        }

        @Override // com.c.a.c.l
        public final boolean b(long j2, V v) {
            this.f111h += k.this.cqz.aU(j2) ^ com.c.a.a.a.a.ax(v);
            return true;
        }
    }

    static final class a<V> implements l<V> {
        private final k<V> cqA;

        a(k<V> kVar) {
            this.cqA = kVar;
        }

        @Override // com.c.a.c.l
        public final boolean b(long j2, V v) {
            boolean z;
            if (this.cqA.index(j2) >= 0) {
                V v2 = this.cqA.get(j2);
                if (v == v2 || (v != null && v.equals(v2))) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: V[] */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    @Override // com.c.a.c.b
    public final void removeAt(int i2) {
        this.cql[i2] = n.cqE;
        super.removeAt(i2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.c.a.c.s<V> */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean a(s<V> sVar) {
        V[] vArr = this.cql;
        int length = vArr.length;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return true;
            }
            if (b(vArr, i2) && !sVar.aD(aF(vArr[i2]))) {
                return false;
            }
            length = i2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.c.a.c.l<V> */
    /* JADX WARN: Multi-variable type inference failed */
    private boolean a(l<V> lVar) {
        long[] jArr = this.cqy;
        V[] vArr = this.cql;
        int length = jArr.length;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return true;
            }
            if (b(vArr, i2) && !lVar.b(jArr[i2], aF(vArr[i2]))) {
                return false;
            }
            length = i2;
        }
    }

    @Override // com.c.a.c.j
    public final int aU(long j2) {
        return (int) ((j2 >> 32) ^ j2);
    }

    @Override // com.c.a.c.b, java.lang.Object
    public final /* bridge */ /* synthetic */ Object clone() {
        k kVar = (k) super.clone();
        kVar.cql = (V[]) ((Object[]) this.cql.clone());
        return kVar;
    }
}
