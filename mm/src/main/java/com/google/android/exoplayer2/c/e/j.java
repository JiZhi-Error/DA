package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e.h;
import com.google.android.exoplayer2.c.e.k;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;

/* access modifiers changed from: package-private */
public final class j extends h {
    private a bpK;
    private int bpL;
    private boolean bpM;
    private k.d bpN;
    private k.b bpO;

    j() {
    }

    public static boolean r(m mVar) {
        AppMethodBeat.i(92172);
        try {
            boolean a2 = k.a(1, mVar, true);
            AppMethodBeat.o(92172);
            return a2;
        } catch (o e2) {
            AppMethodBeat.o(92172);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.c.e.h
    public final void reset(boolean z) {
        AppMethodBeat.i(92173);
        super.reset(z);
        if (z) {
            this.bpK = null;
            this.bpN = null;
            this.bpO = null;
        }
        this.bpL = 0;
        this.bpM = false;
        AppMethodBeat.o(92173);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.c.e.h
    public final void U(long j2) {
        boolean z;
        int i2 = 0;
        AppMethodBeat.i(92174);
        super.U(j2);
        if (j2 != 0) {
            z = true;
        } else {
            z = false;
        }
        this.bpM = z;
        if (this.bpN != null) {
            i2 = this.bpN.bqg;
        }
        this.bpL = i2;
        AppMethodBeat.o(92174);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.c.e.h
    public final long s(m mVar) {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(92175);
        if ((mVar.data[0] & 1) == 1) {
            AppMethodBeat.o(92175);
            return -1;
        }
        byte b2 = mVar.data[0];
        a aVar = this.bpK;
        if (!aVar.bpR[(b2 >> 1) & (255 >>> (8 - aVar.bpS))].bpY) {
            i2 = aVar.bpP.bqg;
        } else {
            i2 = aVar.bpP.bqh;
        }
        if (this.bpM) {
            i3 = (this.bpL + i2) / 4;
        }
        long j2 = (long) i3;
        mVar.eY(mVar.limit + 4);
        mVar.data[mVar.limit - 4] = (byte) ((int) (j2 & 255));
        mVar.data[mVar.limit - 3] = (byte) ((int) ((j2 >>> 8) & 255));
        mVar.data[mVar.limit - 2] = (byte) ((int) ((j2 >>> 16) & 255));
        mVar.data[mVar.limit - 1] = (byte) ((int) ((j2 >>> 24) & 255));
        this.bpM = true;
        this.bpL = i2;
        long j3 = (long) i3;
        AppMethodBeat.o(92175);
        return j3;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.c.e.h
    public final boolean a(m mVar, long j2, h.a aVar) {
        a aVar2;
        long j3;
        AppMethodBeat.i(92176);
        if (this.bpK != null) {
            AppMethodBeat.o(92176);
            return false;
        }
        if (this.bpN == null) {
            k.a(1, mVar, false);
            long xg = mVar.xg();
            int readUnsignedByte = mVar.readUnsignedByte();
            long xg2 = mVar.xg();
            int xh = mVar.xh();
            int xh2 = mVar.xh();
            int xh3 = mVar.xh();
            int readUnsignedByte2 = mVar.readUnsignedByte();
            this.bpN = new k.d(xg, readUnsignedByte, xg2, xh, xh2, xh3, (int) Math.pow(2.0d, (double) (readUnsignedByte2 & 15)), (int) Math.pow(2.0d, (double) ((readUnsignedByte2 & 240) >> 4)), (mVar.readUnsignedByte() & 1) > 0, Arrays.copyOf(mVar.data, mVar.limit));
            aVar2 = null;
        } else if (this.bpO == null) {
            k.a(3, mVar, false);
            String readString = mVar.readString((int) mVar.xg());
            long xg3 = mVar.xg();
            String[] strArr = new String[((int) xg3)];
            int length = readString.length() + 11 + 4;
            for (int i2 = 0; ((long) i2) < xg3; i2++) {
                strArr[i2] = mVar.readString((int) mVar.xg());
                length = length + 4 + strArr[i2].length();
            }
            if ((mVar.readUnsignedByte() & 1) == 0) {
                o oVar = new o("framing bit expected to be set");
                AppMethodBeat.o(92176);
                throw oVar;
            }
            this.bpO = new k.b(readString, strArr, length + 1);
            aVar2 = null;
        } else {
            byte[] bArr = new byte[mVar.limit];
            System.arraycopy(mVar.data, 0, bArr, 0, mVar.limit);
            int i3 = this.bpN.channels;
            k.a(5, mVar, false);
            int readUnsignedByte3 = mVar.readUnsignedByte() + 1;
            i iVar = new i(mVar.data);
            iVar.en(mVar.position * 8);
            for (int i4 = 0; i4 < readUnsignedByte3; i4++) {
                if (iVar.em(24) != 5653314) {
                    o oVar2 = new o("expected code book to start with [0x56, 0x43, 0x42] at " + ((iVar.bpI * 8) + iVar.bpJ));
                    AppMethodBeat.o(92176);
                    throw oVar2;
                }
                int em = iVar.em(16);
                int em2 = iVar.em(24);
                long[] jArr = new long[em2];
                boolean uI = iVar.uI();
                if (!uI) {
                    boolean uI2 = iVar.uI();
                    for (int i5 = 0; i5 < jArr.length; i5++) {
                        if (!uI2 || iVar.uI()) {
                            jArr[i5] = (long) (iVar.em(5) + 1);
                        } else {
                            jArr[i5] = 0;
                        }
                    }
                } else {
                    int em3 = iVar.em(5) + 1;
                    int i6 = 0;
                    while (i6 < jArr.length) {
                        int em4 = iVar.em(k.eo(em2 - i6));
                        for (int i7 = 0; i7 < em4 && i6 < jArr.length; i7++) {
                            jArr[i6] = (long) em3;
                            i6++;
                        }
                        em3++;
                    }
                }
                int em5 = iVar.em(4);
                if (em5 > 2) {
                    o oVar3 = new o("lookup type greater than 2 not decodable: ".concat(String.valueOf(em5)));
                    AppMethodBeat.o(92176);
                    throw oVar3;
                }
                if (em5 == 1 || em5 == 2) {
                    iVar.en(32);
                    iVar.en(32);
                    int em6 = iVar.em(4) + 1;
                    iVar.en(1);
                    if (em5 != 1) {
                        j3 = (long) (em2 * em);
                    } else if (em != 0) {
                        j3 = (long) Math.floor(Math.pow((double) ((long) em2), 1.0d / ((double) ((long) em))));
                    } else {
                        j3 = 0;
                    }
                    iVar.en((int) (j3 * ((long) em6)));
                }
                new k.a(em, em2, jArr, em5, uI);
            }
            int em7 = iVar.em(6) + 1;
            for (int i8 = 0; i8 < em7; i8++) {
                if (iVar.em(16) != 0) {
                    o oVar4 = new o("placeholder of time domain transforms not zeroed out");
                    AppMethodBeat.o(92176);
                    throw oVar4;
                }
            }
            k.c(iVar);
            k.b(iVar);
            k.a(i3, iVar);
            k.c[] a2 = k.a(iVar);
            if (!iVar.uI()) {
                o oVar5 = new o("framing bit after modes not set as expected");
                AppMethodBeat.o(92176);
                throw oVar5;
            }
            aVar2 = new a(this.bpN, this.bpO, bArr, a2, k.eo(a2.length - 1));
        }
        this.bpK = aVar2;
        if (this.bpK == null) {
            AppMethodBeat.o(92176);
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.bpK.bpP.data);
        arrayList.add(this.bpK.bpQ);
        aVar.bdF = Format.a(null, "audio/vorbis", this.bpK.bpP.bqe, -1, this.bpK.bpP.channels, (int) this.bpK.bpP.sampleRate, arrayList, null, null);
        AppMethodBeat.o(92176);
        return true;
    }

    static final class a {
        public final k.b bpO;
        public final k.d bpP;
        public final byte[] bpQ;
        public final k.c[] bpR;
        public final int bpS;

        public a(k.d dVar, k.b bVar, byte[] bArr, k.c[] cVarArr, int i2) {
            this.bpP = dVar;
            this.bpO = bVar;
            this.bpQ = bArr;
            this.bpR = cVarArr;
            this.bpS = i2;
        }
    }
}
