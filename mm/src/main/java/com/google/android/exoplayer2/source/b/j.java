package com.google.android.exoplayer2.source.b;

import android.os.Handler;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.h.t;
import com.google.android.exoplayer2.source.b;
import com.google.android.exoplayer2.source.b.a.a;
import com.google.android.exoplayer2.source.b.c;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.q;
import com.google.android.exoplayer2.source.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.LinkedList;

/* access modifiers changed from: package-private */
public final class j implements g, t.a<com.google.android.exoplayer2.source.a.a>, t.d, m.b, o {
    boolean bcY;
    r bcq;
    private final int bvE;
    private final b bvH;
    final t bvK = new t("Loader:HlsSampleStreamWrapper");
    private final Runnable bvN = new Runnable() {
        /* class com.google.android.exoplayer2.source.b.j.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(62865);
            j.this.vV();
            AppMethodBeat.o(62865);
        }
    };
    m[] bvQ = new m[0];
    private int[] bvR = new int[0];
    boolean bvS;
    boolean bvT;
    int bvV;
    long bwa;
    private long bwb;
    boolean bwd;
    final LinkedList<f> byA = new LinkedList<>();
    Format byB;
    int byC;
    int byD;
    private boolean byE;
    boolean[] byF;
    private boolean[] byG;
    boolean byH;
    final b.a byl;
    private final a byw;
    final c byx;
    private final Format byy;
    private final c.b byz = new c.b();
    final Handler handler = new Handler();
    boolean released;
    final int trackType;

    public interface a extends o.a<j> {
        void a(a.C0114a aVar);

        void tf();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.h.t$c, long, long, java.io.IOException] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x010c  */
    @Override // com.google.android.exoplayer2.h.t.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ int a(com.google.android.exoplayer2.source.a.a r23, long r24, long r26, java.io.IOException r28) {
        /*
        // Method dump skipped, instructions count: 276
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.b.j.a(com.google.android.exoplayer2.h.t$c, long, long, java.io.IOException):int");
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.h.t$c, long, long] */
    @Override // com.google.android.exoplayer2.h.t.a
    public final /* synthetic */ void a(com.google.android.exoplayer2.source.a.a aVar, long j2, long j3) {
        AppMethodBeat.i(62884);
        com.google.android.exoplayer2.source.a.a aVar2 = aVar;
        c cVar = this.byx;
        if (aVar2 instanceof c.a) {
            c.a aVar3 = (c.a) aVar2;
            cVar.bxD = aVar3.data;
            cVar.a(aVar3.bxj.uri, aVar3.bxK, aVar3.bxL);
        }
        this.byl.a(aVar2.bxj, aVar2.type, this.trackType, aVar2.bxk, aVar2.bxl, aVar2.bxm, aVar2.bxn, aVar2.bxo, j2, j3, aVar2.vN());
        if (!this.bcY) {
            X(this.bwa);
            AppMethodBeat.o(62884);
            return;
        }
        this.byw.a(this);
        AppMethodBeat.o(62884);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.h.t$c, long, long, boolean] */
    @Override // com.google.android.exoplayer2.h.t.a
    public final /* synthetic */ void a(com.google.android.exoplayer2.source.a.a aVar, long j2, long j3, boolean z) {
        AppMethodBeat.i(62883);
        com.google.android.exoplayer2.source.a.a aVar2 = aVar;
        this.byl.b(aVar2.bxj, aVar2.type, this.trackType, aVar2.bxk, aVar2.bxl, aVar2.bxm, aVar2.bxn, aVar2.bxo, j2, j3, aVar2.vN());
        if (!z) {
            vU();
            if (this.bvV > 0) {
                this.byw.a(this);
            }
        }
        AppMethodBeat.o(62883);
    }

    @Override // com.google.android.exoplayer2.c.g
    public final /* synthetic */ com.google.android.exoplayer2.c.m dV(int i2) {
        AppMethodBeat.i(193638);
        m eG = eG(i2);
        AppMethodBeat.o(193638);
        return eG;
    }

    public j(int i2, a aVar, c cVar, com.google.android.exoplayer2.h.b bVar, long j2, Format format, int i3, b.a aVar2) {
        AppMethodBeat.i(62866);
        this.trackType = i2;
        this.byw = aVar;
        this.byx = cVar;
        this.bvH = bVar;
        this.byy = format;
        this.bvE = i3;
        this.byl = aVar2;
        this.bwa = j2;
        this.bwb = j2;
        AppMethodBeat.o(62866);
    }

    public final void vT() {
        AppMethodBeat.i(62867);
        if (!this.bcY) {
            X(this.bwa);
        }
        AppMethodBeat.o(62867);
    }

    public final boolean i(long j2, boolean z) {
        AppMethodBeat.i(62868);
        this.bwa = j2;
        if (z || vz() || !Z(j2)) {
            this.bwb = j2;
            this.bwd = false;
            this.byA.clear();
            if (this.bvK.isLoading()) {
                this.bvK.cancelLoading();
            } else {
                vU();
            }
            AppMethodBeat.o(62868);
            return true;
        }
        AppMethodBeat.o(62868);
        return false;
    }

    @Override // com.google.android.exoplayer2.source.o
    public final long vq() {
        long j2;
        AppMethodBeat.i(62869);
        if (this.bwd) {
            AppMethodBeat.o(62869);
            return Long.MIN_VALUE;
        } else if (vz()) {
            long j3 = this.bwb;
            AppMethodBeat.o(62869);
            return j3;
        } else {
            long j4 = this.bwa;
            f last = this.byA.getLast();
            if (!last.byj) {
                last = this.byA.size() > 1 ? this.byA.get(this.byA.size() - 2) : null;
            }
            if (last != null) {
                j2 = Math.max(j4, last.bxo);
            } else {
                j2 = j4;
            }
            for (m mVar : this.bvQ) {
                j2 = Math.max(j2, mVar.bwO.vy());
            }
            AppMethodBeat.o(62869);
            return j2;
        }
    }

    @Override // com.google.android.exoplayer2.h.t.d
    public final void vv() {
        AppMethodBeat.i(62870);
        vU();
        AppMethodBeat.o(62870);
    }

    public final void aT(boolean z) {
        this.byx.bxC = z;
    }

    /* access modifiers changed from: package-private */
    public final void vU() {
        AppMethodBeat.i(62871);
        for (m mVar : this.bvQ) {
            mVar.reset(this.byH);
        }
        this.byH = false;
        AppMethodBeat.o(62871);
    }

    @Override // com.google.android.exoplayer2.source.o
    public final boolean X(long j2) {
        f last;
        AppMethodBeat.i(62872);
        if (this.bwd || this.bvK.isLoading()) {
            AppMethodBeat.o(62872);
            return false;
        }
        c cVar = this.byx;
        if (this.byA.isEmpty()) {
            last = null;
        } else {
            last = this.byA.getLast();
        }
        if (this.bwb != -9223372036854775807L) {
            j2 = this.bwb;
        }
        cVar.a(last, j2, this.byz);
        boolean z = this.byz.bxN;
        com.google.android.exoplayer2.source.a.a aVar = this.byz.bxM;
        a.C0114a aVar2 = this.byz.bxO;
        this.byz.clear();
        if (z) {
            this.bwb = -9223372036854775807L;
            this.bwd = true;
            AppMethodBeat.o(62872);
            return true;
        } else if (aVar == null) {
            if (aVar2 != null) {
                this.byw.a(aVar2);
            }
            AppMethodBeat.o(62872);
            return false;
        } else {
            if (aVar instanceof f) {
                this.bwb = -9223372036854775807L;
                f fVar = (f) aVar;
                fVar.a(this);
                this.byA.add(fVar);
            }
            this.byl.a(aVar.bxj, aVar.type, this.trackType, aVar.bxk, aVar.bxl, aVar.bxm, aVar.bxn, aVar.bxo, this.bvK.a(aVar, this, this.bvE));
            AppMethodBeat.o(62872);
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.source.o
    public final long vr() {
        AppMethodBeat.i(62873);
        if (vz()) {
            long j2 = this.bwb;
            AppMethodBeat.o(62873);
            return j2;
        } else if (this.bwd) {
            AppMethodBeat.o(62873);
            return Long.MIN_VALUE;
        } else {
            long j3 = this.byA.getLast().bxo;
            AppMethodBeat.o(62873);
            return j3;
        }
    }

    public final m eG(int i2) {
        AppMethodBeat.i(62874);
        int length = this.bvQ.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.bvR[i3] == i2) {
                m mVar = this.bvQ[i3];
                AppMethodBeat.o(62874);
                return mVar;
            }
        }
        m mVar2 = new m(this.bvH);
        mVar2.bwY = this;
        this.bvR = Arrays.copyOf(this.bvR, length + 1);
        this.bvR[length] = i2;
        this.bvQ = (m[]) Arrays.copyOf(this.bvQ, length + 1);
        this.bvQ[length] = mVar2;
        AppMethodBeat.o(62874);
        return mVar2;
    }

    @Override // com.google.android.exoplayer2.c.g
    public final void uy() {
        AppMethodBeat.i(62875);
        this.bvS = true;
        this.handler.post(this.bvN);
        AppMethodBeat.o(62875);
    }

    @Override // com.google.android.exoplayer2.c.g
    public final void a(l lVar) {
    }

    @Override // com.google.android.exoplayer2.source.m.b
    public final void vw() {
        AppMethodBeat.i(62876);
        this.handler.post(this.bvN);
        AppMethodBeat.o(62876);
    }

    /* access modifiers changed from: package-private */
    public final void vV() {
        char c2;
        AppMethodBeat.i(62877);
        if (this.released || this.bcY || !this.bvS) {
            AppMethodBeat.o(62877);
            return;
        }
        for (m mVar : this.bvQ) {
            if (mVar.bwO.vG() == null) {
                AppMethodBeat.o(62877);
                return;
            }
        }
        int length = this.bvQ.length;
        int i2 = 0;
        int i3 = -1;
        char c3 = 0;
        while (i2 < length) {
            String str = this.bvQ[i2].bwO.vG().bdq;
            if (com.google.android.exoplayer2.i.j.by(str)) {
                c2 = 3;
            } else if (com.google.android.exoplayer2.i.j.bx(str)) {
                c2 = 2;
            } else if (com.google.android.exoplayer2.i.j.bz(str)) {
                c2 = 1;
            } else {
                c2 = 0;
            }
            if (c2 > c3) {
                i3 = i2;
            } else if (c2 != c3 || i3 == -1) {
                c2 = c3;
            } else {
                i3 = -1;
                c2 = c3;
            }
            i2++;
            c3 = c2;
        }
        q qVar = this.byx.bxA;
        int i4 = qVar.length;
        this.byD = -1;
        this.byF = new boolean[length];
        this.byG = new boolean[length];
        q[] qVarArr = new q[length];
        for (int i5 = 0; i5 < length; i5++) {
            Format vG = this.bvQ[i5].bwO.vG();
            String str2 = vG.bdq;
            boolean z = com.google.android.exoplayer2.i.j.by(str2) || com.google.android.exoplayer2.i.j.bx(str2);
            this.byG[i5] = z;
            this.byE = z | this.byE;
            if (i5 == i3) {
                Format[] formatArr = new Format[i4];
                for (int i6 = 0; i6 < i4; i6++) {
                    formatArr[i6] = a(qVar.bwD[i6], vG);
                }
                qVarArr[i5] = new q(formatArr);
                this.byD = i5;
            } else {
                qVarArr[i5] = new q(a((c3 != 3 || !com.google.android.exoplayer2.i.j.bx(vG.bdq)) ? null : this.byy, vG));
            }
        }
        this.bcq = new r(qVarArr);
        this.bcY = true;
        this.byw.tf();
        AppMethodBeat.o(62877);
    }

    /* access modifiers changed from: package-private */
    public final void p(int i2, boolean z) {
        int i3 = 1;
        AppMethodBeat.i(62878);
        com.google.android.exoplayer2.i.a.checkState(this.byF[i2] != z);
        this.byF[i2] = z;
        int i4 = this.bvV;
        if (!z) {
            i3 = -1;
        }
        this.bvV = i4 + i3;
        AppMethodBeat.o(62878);
    }

    private static Format a(Format format, Format format2) {
        AppMethodBeat.i(62879);
        if (format == null) {
            AppMethodBeat.o(62879);
            return format2;
        }
        String str = null;
        int bB = com.google.android.exoplayer2.i.j.bB(format2.bdq);
        if (bB == 1) {
            str = j(format.bdn, 1);
        } else if (bB == 2) {
            str = j(format.bdn, 2);
        }
        Format a2 = format2.a(format.id, str, format.bitrate, format.width, format.height, format.bdD, format.language);
        AppMethodBeat.o(62879);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final boolean vz() {
        return this.bwb != -9223372036854775807L;
    }

    private boolean Z(long j2) {
        AppMethodBeat.i(62880);
        int length = this.bvQ.length;
        for (int i2 = 0; i2 < length; i2++) {
            m mVar = this.bvQ[i2];
            mVar.rewind();
            if (mVar.f(j2, false) || (!this.byG[i2] && this.byE)) {
                mVar.vK();
            } else {
                AppMethodBeat.o(62880);
                return false;
            }
        }
        AppMethodBeat.o(62880);
        return true;
    }

    private static String j(String str, int i2) {
        AppMethodBeat.i(62881);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(62881);
            return null;
        }
        String[] split = str.split("(\\s*,\\s*)|(\\s*$)");
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            if (i2 == com.google.android.exoplayer2.i.j.bB(com.google.android.exoplayer2.i.j.bA(str2))) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            String sb2 = sb.toString();
            AppMethodBeat.o(62881);
            return sb2;
        }
        AppMethodBeat.o(62881);
        return null;
    }
}
