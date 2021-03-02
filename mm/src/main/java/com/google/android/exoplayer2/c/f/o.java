package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.c.f.v;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.u;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o implements v {
    private u bnh;
    private int bqr;
    private final h brY;
    private final l brZ = new l(new byte[10]);
    private boolean bsa;
    private boolean bsb;
    private boolean bsc;
    private int bsd;
    private int bse;
    private boolean bsf;
    private int state = 0;
    private long timeUs;

    public o(h hVar) {
        AppMethodBeat.i(92265);
        this.brY = hVar;
        AppMethodBeat.o(92265);
    }

    @Override // com.google.android.exoplayer2.c.f.v
    public final void a(u uVar, g gVar, v.d dVar) {
        AppMethodBeat.i(92266);
        this.bnh = uVar;
        this.brY.a(gVar, dVar);
        AppMethodBeat.o(92266);
    }

    @Override // com.google.android.exoplayer2.c.f.v
    public final void uK() {
        AppMethodBeat.i(92267);
        this.state = 0;
        this.bqr = 0;
        this.bsc = false;
        this.brY.uK();
        AppMethodBeat.o(92267);
    }

    @Override // com.google.android.exoplayer2.c.f.v
    public final void a(m mVar, boolean z) {
        int i2;
        boolean z2;
        int i3;
        AppMethodBeat.i(92268);
        if (z) {
            switch (this.state) {
                case 3:
                    if (this.bse != -1) {
                        new StringBuilder("Unexpected start indicator: expected ").append(this.bse).append(" more bytes");
                    }
                    this.brY.uL();
                    break;
            }
            setState(1);
        }
        while (mVar.xd() > 0) {
            switch (this.state) {
                case 0:
                    mVar.eZ(mVar.xd());
                    break;
                case 1:
                    if (!a(mVar, this.brZ.data, 9)) {
                        break;
                    } else {
                        this.brZ.setPosition(0);
                        if (this.brZ.em(24) != 1) {
                            this.bse = -1;
                            z2 = false;
                        } else {
                            this.brZ.en(8);
                            int em = this.brZ.em(16);
                            this.brZ.en(5);
                            this.bsf = this.brZ.uI();
                            this.brZ.en(2);
                            this.bsa = this.brZ.uI();
                            this.bsb = this.brZ.uI();
                            this.brZ.en(6);
                            this.bsd = this.brZ.em(8);
                            if (em == 0) {
                                this.bse = -1;
                            } else {
                                this.bse = ((em + 6) - 9) - this.bsd;
                            }
                            z2 = true;
                        }
                        if (z2) {
                            i3 = 2;
                        } else {
                            i3 = 0;
                        }
                        setState(i3);
                        break;
                    }
                case 2:
                    if (a(mVar, this.brZ.data, Math.min(10, this.bsd)) && a(mVar, (byte[]) null, this.bsd)) {
                        this.brZ.setPosition(0);
                        this.timeUs = -9223372036854775807L;
                        if (this.bsa) {
                            this.brZ.en(4);
                            this.brZ.en(1);
                            this.brZ.en(1);
                            long em2 = (((long) this.brZ.em(3)) << 30) | ((long) (this.brZ.em(15) << 15)) | ((long) this.brZ.em(15));
                            this.brZ.en(1);
                            if (!this.bsc && this.bsb) {
                                this.brZ.en(4);
                                this.brZ.en(1);
                                this.brZ.en(1);
                                this.brZ.en(1);
                                this.bnh.ao((((long) this.brZ.em(3)) << 30) | ((long) (this.brZ.em(15) << 15)) | ((long) this.brZ.em(15)));
                                this.bsc = true;
                            }
                            this.timeUs = this.bnh.ao(em2);
                        }
                        this.brY.c(this.timeUs, this.bsf);
                        setState(3);
                        break;
                    }
                case 3:
                    int xd = mVar.xd();
                    if (this.bse == -1) {
                        i2 = 0;
                    } else {
                        i2 = xd - this.bse;
                    }
                    if (i2 > 0) {
                        xd -= i2;
                        mVar.eY(mVar.position + xd);
                    }
                    this.brY.t(mVar);
                    if (this.bse == -1) {
                        break;
                    } else {
                        this.bse -= xd;
                        if (this.bse != 0) {
                            break;
                        } else {
                            this.brY.uL();
                            setState(1);
                            break;
                        }
                    }
            }
        }
        AppMethodBeat.o(92268);
    }

    private void setState(int i2) {
        this.state = i2;
        this.bqr = 0;
    }

    private boolean a(m mVar, byte[] bArr, int i2) {
        AppMethodBeat.i(92269);
        int min = Math.min(mVar.xd(), i2 - this.bqr);
        if (min <= 0) {
            AppMethodBeat.o(92269);
            return true;
        }
        if (bArr == null) {
            mVar.eZ(min);
        } else {
            mVar.readBytes(bArr, this.bqr, min);
        }
        this.bqr = min + this.bqr;
        if (this.bqr == i2) {
            AppMethodBeat.o(92269);
            return true;
        }
        AppMethodBeat.o(92269);
        return false;
    }
}
