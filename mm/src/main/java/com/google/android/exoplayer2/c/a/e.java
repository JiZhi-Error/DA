package com.google.android.exoplayer2.c.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.a.d;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.video.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e extends d {
    private final m biB = new m(k.bGT);
    private final m biC = new m(4);
    private int biD;
    private boolean bik;
    private int frameType;

    public e(com.google.android.exoplayer2.c.m mVar) {
        super(mVar);
        AppMethodBeat.i(91993);
        AppMethodBeat.o(91993);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.c.a.d
    public final boolean a(m mVar) {
        AppMethodBeat.i(91994);
        int readUnsignedByte = mVar.readUnsignedByte();
        int i2 = (readUnsignedByte >> 4) & 15;
        int i3 = readUnsignedByte & 15;
        if (i3 != 7) {
            d.a aVar = new d.a("Video format not supported: ".concat(String.valueOf(i3)));
            AppMethodBeat.o(91994);
            throw aVar;
        }
        this.frameType = i2;
        if (i2 != 5) {
            AppMethodBeat.o(91994);
            return true;
        }
        AppMethodBeat.o(91994);
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.c.a.d
    public final void a(m mVar, long j2) {
        int i2;
        AppMethodBeat.i(91995);
        int readUnsignedByte = mVar.readUnsignedByte();
        long xf = (((long) mVar.xf()) * 1000) + j2;
        if (readUnsignedByte != 0 || this.bik) {
            if (readUnsignedByte == 1 && this.bik) {
                byte[] bArr = this.biC.data;
                bArr[0] = 0;
                bArr[1] = 0;
                bArr[2] = 0;
                int i3 = 4 - this.biD;
                int i4 = 0;
                while (mVar.xd() > 0) {
                    mVar.readBytes(this.biC.data, i3, this.biD);
                    this.biC.setPosition(0);
                    int xk = this.biC.xk();
                    this.biB.setPosition(0);
                    this.biA.a(this.biB, 4);
                    this.biA.a(mVar, xk);
                    i4 = i4 + 4 + xk;
                }
                com.google.android.exoplayer2.c.m mVar2 = this.biA;
                if (this.frameType == 1) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                mVar2.a(xf, i2, i4, 0, null);
            }
            AppMethodBeat.o(91995);
            return;
        }
        m mVar3 = new m(new byte[mVar.xd()]);
        mVar.readBytes(mVar3.data, 0, mVar.xd());
        a K = a.K(mVar3);
        this.biD = K.biD;
        this.biA.f(Format.a((String) null, "video/avc", K.width, K.height, K.bds, K.bHl));
        this.bik = true;
        AppMethodBeat.o(91995);
    }
}
