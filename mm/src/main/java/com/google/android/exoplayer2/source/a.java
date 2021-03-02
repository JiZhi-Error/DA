package com.google.android.exoplayer2.source;

import android.util.Pair;
import com.google.android.exoplayer2.w;

abstract class a extends w {
    private final int bva;

    /* access modifiers changed from: protected */
    public abstract int ag(Object obj);

    /* access modifiers changed from: protected */
    public abstract int ev(int i2);

    /* access modifiers changed from: protected */
    public abstract int ew(int i2);

    /* access modifiers changed from: protected */
    public abstract int ex(int i2);

    /* access modifiers changed from: protected */
    public abstract int ey(int i2);

    /* access modifiers changed from: protected */
    public abstract Object ez(int i2);

    /* access modifiers changed from: protected */
    public abstract w vk();

    public a(int i2) {
        this.bva = i2;
    }

    @Override // com.google.android.exoplayer2.w
    public final int aZ(int i2, int i3) {
        int ew = ew(i2);
        int ey = ey(ew);
        int aZ = vk().aZ(i2 - ey, i3 == 2 ? 0 : i3);
        if (aZ != -1) {
            return ey + aZ;
        }
        int i4 = ew + 1;
        if (i4 < this.bva) {
            return ey(i4);
        }
        return i3 != 2 ? -1 : 0;
    }

    @Override // com.google.android.exoplayer2.w
    public final w.b a(int i2, w.b bVar, boolean z, long j2) {
        int ew = ew(i2);
        int ey = ey(ew);
        int ex = ex(ew);
        vk().a(i2 - ey, bVar, z, j2);
        bVar.bey += ex;
        bVar.bez += ex;
        return bVar;
    }

    @Override // com.google.android.exoplayer2.w
    public final w.a a(int i2, w.a aVar, boolean z) {
        int ev = ev(i2);
        int ey = ey(ev);
        vk().a(i2 - ex(ev), aVar, z);
        aVar.bdi = ey + aVar.bdi;
        if (z) {
            aVar.bcT = Pair.create(ez(ev), aVar.bcT);
        }
        return aVar;
    }

    @Override // com.google.android.exoplayer2.w
    public final int ae(Object obj) {
        int ae;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        int ag = ag(obj2);
        if (ag == -1 || (ae = vk().ae(obj3)) == -1) {
            return -1;
        }
        return ex(ag) + ae;
    }
}
