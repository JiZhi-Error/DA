package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.source.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import java.io.EOFException;
import java.nio.ByteBuffer;

public final class m implements com.google.android.exoplayer2.c.m {
    private final com.google.android.exoplayer2.i.m bin = new com.google.android.exoplayer2.i.m(32);
    private long bqQ;
    private final com.google.android.exoplayer2.h.b bvH;
    private final int bwN;
    public final l bwO = new l();
    private final l.a bwP = new l.a();
    private a bwQ = new a(0, this.bwN);
    private a bwR = this.bwQ;
    private a bwS = this.bwQ;
    private Format bwT;
    private boolean bwU;
    private Format bwV;
    private long bwW;
    public boolean bwX;
    public b bwY;

    public interface b {
        void vw();
    }

    public m(com.google.android.exoplayer2.h.b bVar) {
        AppMethodBeat.i(92696);
        this.bvH = bVar;
        this.bwN = bVar.wD();
        AppMethodBeat.o(92696);
    }

    public final void reset(boolean z) {
        AppMethodBeat.i(92697);
        this.bwO.reset(z);
        a(this.bwQ);
        this.bwQ = new a(0, this.bwN);
        this.bwR = this.bwQ;
        this.bwS = this.bwQ;
        this.bqQ = 0;
        this.bvH.trim();
        AppMethodBeat.o(92697);
    }

    public final void rewind() {
        AppMethodBeat.i(92699);
        this.bwO.rewind();
        this.bwR = this.bwQ;
        AppMethodBeat.o(92699);
    }

    public final void h(long j2, boolean z) {
        AppMethodBeat.i(196061);
        ad(this.bwO.g(j2, z));
        AppMethodBeat.o(196061);
    }

    public final void vK() {
        AppMethodBeat.i(92701);
        ad(this.bwO.vI());
        AppMethodBeat.o(92701);
    }

    public final void vL() {
        AppMethodBeat.i(92702);
        ad(this.bwO.vJ());
        AppMethodBeat.o(92702);
    }

    public final boolean f(long j2, boolean z) {
        AppMethodBeat.i(92703);
        boolean f2 = this.bwO.f(j2, z);
        AppMethodBeat.o(92703);
        return f2;
    }

    public final int a(k kVar, e eVar, boolean z, boolean z2, long j2) {
        AppMethodBeat.i(92704);
        switch (this.bwO.a(kVar, eVar, z, z2, this.bwT, this.bwP)) {
            case -5:
                this.bwT = kVar.bdF;
                AppMethodBeat.o(92704);
                return -5;
            case -4:
                if (!eVar.ud()) {
                    if (eVar.timeUs < j2) {
                        eVar.dK(Integer.MIN_VALUE);
                    }
                    if (eVar.uh()) {
                        a(eVar, this.bwP);
                    }
                    eVar.dM(this.bwP.size);
                    a(this.bwP.offset, eVar.aKP, this.bwP.size);
                }
                AppMethodBeat.o(92704);
                return -4;
            case -3:
                AppMethodBeat.o(92704);
                return -3;
            default:
                IllegalStateException illegalStateException = new IllegalStateException();
                AppMethodBeat.o(92704);
                throw illegalStateException;
        }
    }

    private void a(e eVar, l.a aVar) {
        long j2;
        long j3;
        int i2 = 1;
        AppMethodBeat.i(92705);
        long j4 = aVar.offset;
        this.bin.reset(1);
        a(j4, this.bin.data, 1);
        long j5 = j4 + 1;
        byte b2 = this.bin.data[0];
        boolean z = (b2 & 128) != 0;
        int i3 = b2 & Byte.MAX_VALUE;
        if (eVar.bhp.iv == null) {
            eVar.bhp.iv = new byte[16];
        }
        a(j5, eVar.bhp.iv, i3);
        long j6 = j5 + ((long) i3);
        if (z) {
            this.bin.reset(2);
            a(j6, this.bin.data, 2);
            i2 = this.bin.readUnsignedShort();
            j2 = j6 + 2;
        } else {
            j2 = j6;
        }
        int[] iArr = eVar.bhp.numBytesOfClearData;
        if (iArr == null || iArr.length < i2) {
            iArr = new int[i2];
        }
        int[] iArr2 = eVar.bhp.numBytesOfEncryptedData;
        if (iArr2 == null || iArr2.length < i2) {
            iArr2 = new int[i2];
        }
        if (z) {
            int i4 = i2 * 6;
            this.bin.reset(i4);
            a(j2, this.bin.data, i4);
            long j7 = j2 + ((long) i4);
            this.bin.setPosition(0);
            for (int i5 = 0; i5 < i2; i5++) {
                iArr[i5] = this.bin.readUnsignedShort();
                iArr2[i5] = this.bin.xk();
            }
            j3 = j7;
        } else {
            iArr[0] = 0;
            iArr2[0] = aVar.size - ((int) (j2 - aVar.offset));
            j3 = j2;
        }
        m.a aVar2 = aVar.bjS;
        eVar.bhp.a(i2, iArr, iArr2, aVar2.bih, eVar.bhp.iv, aVar2.big, aVar2.bhd, aVar2.bhe);
        int i6 = (int) (j3 - aVar.offset);
        aVar.offset += (long) i6;
        aVar.size -= i6;
        AppMethodBeat.o(92705);
    }

    private void a(long j2, ByteBuffer byteBuffer, int i2) {
        AppMethodBeat.i(92706);
        ac(j2);
        while (i2 > 0) {
            int min = Math.min(i2, (int) (this.bwR.bmy - j2));
            byteBuffer.put(this.bwR.bxa.data, this.bwR.ae(j2), min);
            i2 -= min;
            j2 += (long) min;
            if (j2 == this.bwR.bmy) {
                this.bwR = this.bwR.bxb;
            }
        }
        AppMethodBeat.o(92706);
    }

    private void a(long j2, byte[] bArr, int i2) {
        AppMethodBeat.i(92707);
        ac(j2);
        int i3 = i2;
        while (i3 > 0) {
            int min = Math.min(i3, (int) (this.bwR.bmy - j2));
            System.arraycopy(this.bwR.bxa.data, this.bwR.ae(j2), bArr, i2 - i3, min);
            i3 -= min;
            j2 += (long) min;
            if (j2 == this.bwR.bmy) {
                this.bwR = this.bwR.bxb;
            }
        }
        AppMethodBeat.o(92707);
    }

    private void ac(long j2) {
        while (j2 >= this.bwR.bmy) {
            this.bwR = this.bwR.bxb;
        }
    }

    private void ad(long j2) {
        AppMethodBeat.i(92708);
        if (j2 == -1) {
            AppMethodBeat.o(92708);
            return;
        }
        while (j2 >= this.bwQ.bmy) {
            this.bvH.a(this.bwQ.bxa);
            this.bwQ = this.bwQ.vM();
        }
        if (this.bwR.boS < this.bwQ.boS) {
            this.bwR = this.bwQ;
        }
        AppMethodBeat.o(92708);
    }

    @Override // com.google.android.exoplayer2.c.m
    public final void f(Format format) {
        Format D;
        AppMethodBeat.i(92709);
        long j2 = this.bwW;
        if (format == null) {
            D = null;
        } else {
            D = (j2 == 0 || format.bdC == MAlarmHandler.NEXT_FIRE_INTERVAL) ? format : format.D(j2 + format.bdC);
        }
        boolean i2 = this.bwO.i(D);
        this.bwV = format;
        this.bwU = false;
        if (this.bwY != null && i2) {
            this.bwY.vw();
        }
        AppMethodBeat.o(92709);
    }

    @Override // com.google.android.exoplayer2.c.m
    public final int a(f fVar, int i2, boolean z) {
        AppMethodBeat.i(92710);
        int read = fVar.read(this.bwS.bxa.data, this.bwS.ae(this.bqQ), eE(i2));
        if (read != -1) {
            eF(read);
            AppMethodBeat.o(92710);
            return read;
        } else if (z) {
            AppMethodBeat.o(92710);
            return -1;
        } else {
            EOFException eOFException = new EOFException();
            AppMethodBeat.o(92710);
            throw eOFException;
        }
    }

    @Override // com.google.android.exoplayer2.c.m
    public final void a(com.google.android.exoplayer2.i.m mVar, int i2) {
        AppMethodBeat.i(92711);
        while (i2 > 0) {
            int eE = eE(i2);
            mVar.readBytes(this.bwS.bxa.data, this.bwS.ae(this.bqQ), eE);
            i2 -= eE;
            eF(eE);
        }
        AppMethodBeat.o(92711);
    }

    @Override // com.google.android.exoplayer2.c.m
    public final void a(long j2, int i2, int i3, int i4, m.a aVar) {
        AppMethodBeat.i(92712);
        if (this.bwU) {
            f(this.bwV);
        }
        if (this.bwX) {
            if ((i2 & 1) == 0 || !this.bwO.ab(j2)) {
                AppMethodBeat.o(92712);
                return;
            }
            this.bwX = false;
        }
        this.bwO.a(j2 + this.bwW, i2, (this.bqQ - ((long) i3)) - ((long) i4), i3, aVar);
        AppMethodBeat.o(92712);
    }

    private void a(a aVar) {
        AppMethodBeat.i(92713);
        if (!aVar.bwZ) {
            AppMethodBeat.o(92713);
            return;
        }
        com.google.android.exoplayer2.h.a[] aVarArr = new com.google.android.exoplayer2.h.a[((this.bwS.bwZ ? 1 : 0) + (((int) (this.bwS.boS - aVar.boS)) / this.bwN))];
        for (int i2 = 0; i2 < aVarArr.length; i2++) {
            aVarArr[i2] = aVar.bxa;
            aVar = aVar.vM();
        }
        this.bvH.a(aVarArr);
        AppMethodBeat.o(92713);
    }

    private int eE(int i2) {
        AppMethodBeat.i(92714);
        if (!this.bwS.bwZ) {
            this.bwS.a(this.bvH.wC(), new a(this.bwS.bmy, this.bwN));
        }
        int min = Math.min(i2, (int) (this.bwS.bmy - this.bqQ));
        AppMethodBeat.o(92714);
        return min;
    }

    private void eF(int i2) {
        this.bqQ += (long) i2;
        if (this.bqQ == this.bwS.bmy) {
            this.bwS = this.bwS.bxb;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        public final long bmy;
        public final long boS;
        public boolean bwZ;
        public com.google.android.exoplayer2.h.a bxa;
        public a bxb;

        public a(long j2, int i2) {
            AppMethodBeat.i(92695);
            this.boS = j2;
            this.bmy = ((long) i2) + j2;
            AppMethodBeat.o(92695);
        }

        public final void a(com.google.android.exoplayer2.h.a aVar, a aVar2) {
            this.bxa = aVar;
            this.bxb = aVar2;
            this.bwZ = true;
        }

        public final int ae(long j2) {
            return ((int) (j2 - this.boS)) + this.bxa.offset;
        }

        public final a vM() {
            this.bxa = null;
            a aVar = this.bxb;
            this.bxb = null;
            return aVar;
        }
    }
}
