package com.google.android.exoplayer2.g;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.q;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;
import java.util.Comparator;

public abstract class b implements f {
    private int aHK;
    protected final q bEd;
    protected final int[] bEe;
    private final long[] bEf;
    final Format[] bwD;
    protected final int length;

    public b(q qVar, int... iArr) {
        com.google.android.exoplayer2.i.a.checkState(iArr.length > 0);
        this.bEd = (q) com.google.android.exoplayer2.i.a.checkNotNull(qVar);
        this.length = iArr.length;
        this.bwD = new Format[this.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.bwD[i2] = qVar.bwD[iArr[i2]];
        }
        Arrays.sort(this.bwD, new a((byte) 0));
        this.bEe = new int[this.length];
        for (int i3 = 0; i3 < this.length; i3++) {
            this.bEe[i3] = qVar.j(this.bwD[i3]);
        }
        this.bEf = new long[this.length];
    }

    @Override // com.google.android.exoplayer2.g.f
    public final q wy() {
        return this.bEd;
    }

    @Override // com.google.android.exoplayer2.g.f
    public final int length() {
        return this.bEe.length;
    }

    @Override // com.google.android.exoplayer2.g.f
    public final Format eU(int i2) {
        return this.bwD[i2];
    }

    @Override // com.google.android.exoplayer2.g.f
    public final int eV(int i2) {
        return this.bEe[i2];
    }

    public final int j(Format format) {
        for (int i2 = 0; i2 < this.length; i2++) {
            if (this.bwD[i2] == format) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.g.f
    public final int indexOf(int i2) {
        for (int i3 = 0; i3 < this.length; i3++) {
            if (this.bEe[i3] == i2) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.g.f
    public final Format wz() {
        return this.bwD[getSelectedIndex()];
    }

    @Override // com.google.android.exoplayer2.g.f
    public final int wA() {
        return this.bEe[getSelectedIndex()];
    }

    @Override // com.google.android.exoplayer2.g.f
    public final boolean k(int i2, long j2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean l = l(i2, elapsedRealtime);
        for (int i3 = 0; i3 < this.length && !l; i3++) {
            l = i3 != i2 && !l(i3, elapsedRealtime);
        }
        if (!l) {
            return false;
        }
        long[] jArr = this.bEf;
        jArr[i2] = Math.max(jArr[i2], elapsedRealtime + Util.MILLSECONDS_OF_MINUTE);
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean l(int i2, long j2) {
        return this.bEf[i2] > j2;
    }

    public int hashCode() {
        if (this.aHK == 0) {
            this.aHK = (System.identityHashCode(this.bEd) * 31) + Arrays.hashCode(this.bEe);
        }
        return this.aHK;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.bEd == bVar.bEd && Arrays.equals(this.bEe, bVar.bEe);
    }

    static final class a implements Comparator<Format> {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(Format format, Format format2) {
            return format2.bitrate - format.bitrate;
        }
    }
}
