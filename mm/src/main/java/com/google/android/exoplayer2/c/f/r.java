package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.c.f.v;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.u;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r implements v {
    private int bqr;
    private final q bsm;
    private final m bsn = new m(32);
    private int bso;
    private boolean bsp;
    private boolean bsq;

    public r(q qVar) {
        AppMethodBeat.i(92279);
        this.bsm = qVar;
        AppMethodBeat.o(92279);
    }

    @Override // com.google.android.exoplayer2.c.f.v
    public final void a(u uVar, g gVar, v.d dVar) {
        AppMethodBeat.i(92280);
        this.bsm.a(uVar, gVar, dVar);
        this.bsq = true;
        AppMethodBeat.o(92280);
    }

    @Override // com.google.android.exoplayer2.c.f.v
    public final void uK() {
        this.bsq = true;
    }

    @Override // com.google.android.exoplayer2.c.f.v
    public final void a(m mVar, boolean z) {
        int i2;
        AppMethodBeat.i(92281);
        if (z) {
            i2 = mVar.readUnsignedByte() + mVar.position;
        } else {
            i2 = -1;
        }
        if (this.bsq) {
            if (!z) {
                AppMethodBeat.o(92281);
                return;
            }
            this.bsq = false;
            mVar.setPosition(i2);
            this.bqr = 0;
        }
        while (mVar.xd() > 0) {
            if (this.bqr < 3) {
                if (this.bqr == 0) {
                    int readUnsignedByte = mVar.readUnsignedByte();
                    mVar.setPosition(mVar.position - 1);
                    if (readUnsignedByte == 255) {
                        this.bsq = true;
                        AppMethodBeat.o(92281);
                        return;
                    }
                }
                int min = Math.min(mVar.xd(), 3 - this.bqr);
                mVar.readBytes(this.bsn.data, this.bqr, min);
                this.bqr = min + this.bqr;
                if (this.bqr == 3) {
                    this.bsn.reset(3);
                    this.bsn.eZ(1);
                    int readUnsignedByte2 = this.bsn.readUnsignedByte();
                    int readUnsignedByte3 = this.bsn.readUnsignedByte();
                    this.bsp = (readUnsignedByte2 & 128) != 0;
                    this.bso = (((readUnsignedByte2 & 15) << 8) | readUnsignedByte3) + 3;
                    if (this.bsn.capacity() < this.bso) {
                        byte[] bArr = this.bsn.data;
                        this.bsn.reset(Math.min(4098, Math.max(this.bso, bArr.length * 2)));
                        System.arraycopy(bArr, 0, this.bsn.data, 0, 3);
                    }
                }
            } else {
                int min2 = Math.min(mVar.xd(), this.bso - this.bqr);
                mVar.readBytes(this.bsn.data, this.bqr, min2);
                this.bqr = min2 + this.bqr;
                if (this.bqr != this.bso) {
                    continue;
                } else {
                    if (!this.bsp) {
                        this.bsn.reset(this.bso);
                    } else if (x.m(this.bsn.data, this.bso, -1) != 0) {
                        this.bsq = true;
                        AppMethodBeat.o(92281);
                        return;
                    } else {
                        this.bsn.reset(this.bso - 4);
                    }
                    this.bsm.t(this.bsn);
                    this.bqr = 0;
                }
            }
        }
        AppMethodBeat.o(92281);
    }
}
