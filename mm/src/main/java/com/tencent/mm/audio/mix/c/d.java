package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.e;
import java.lang.reflect.Array;

public class d implements h {
    protected static long duG = 0;
    protected static long duH = 0;
    protected static Object duI = new Object();
    protected int duA = 2;
    protected int duB = 2;
    protected boolean duC = false;
    protected boolean duD = false;
    protected boolean duE = false;
    protected String duF;
    protected byte[][] duJ = new byte[2][];
    protected i duK;
    protected String dus;
    protected i duv;
    protected int duw = 0;
    protected int dux = 0;
    protected int duy = 0;
    protected int duz = 44100;

    public d() {
        AppMethodBeat.i(136761);
        AppMethodBeat.o(136761);
    }

    static {
        AppMethodBeat.i(136766);
        AppMethodBeat.o(136766);
    }

    @Override // com.tencent.mm.audio.mix.c.h
    public final void G(int i2, int i3, int i4) {
        AppMethodBeat.i(136763);
        int i5 = this.duw;
        this.duw = i2;
        this.dux = i3;
        this.duy = i4;
        if (this.duz != this.duw) {
            if (this.duv == null) {
                this.duv = YQ();
                this.duv.l(this.duF, this.duw, this.duz);
            } else if (!(this.duv == null || i5 == this.duw)) {
                this.duv.release();
                this.duv = YQ();
                this.duv.l(this.duF, this.duw, this.duz);
            }
            if (this.dux == 2 && this.duA == 2) {
                if (this.duK == null) {
                    this.duK = YQ();
                    this.duK.l(this.duF + "RResample", this.duw, this.duz);
                } else if (!(this.duK == null || i5 == this.duw)) {
                    this.duK.release();
                    this.duK = YQ();
                    this.duK.l(this.duF + "RResample", this.duw, this.duz);
                }
            }
            this.duE = true;
        } else {
            this.duE = false;
            if (this.duv != null) {
                this.duv.release();
                this.duv = null;
            }
        }
        if (this.duB != this.duy) {
            this.duD = true;
        }
        if (this.duA != this.dux) {
            this.duC = true;
        }
        AppMethodBeat.o(136763);
    }

    @Override // com.tencent.mm.audio.mix.c.h
    public byte[] X(byte[] bArr) {
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        byte[] X;
        AppMethodBeat.i(136764);
        if (bArr == null) {
            AppMethodBeat.o(136764);
            return bArr;
        }
        if (!this.duD || (bArr2 = c.a(this.duy, this.duB, bArr)) == null) {
            bArr2 = null;
        }
        if (bArr2 == null) {
            bArr3 = bArr;
        } else {
            bArr3 = bArr2;
        }
        if (this.dux == 1 && this.duA == 2 && this.duE) {
            byte[] X2 = this.duv.X(bArr3);
            if (X2 != null) {
                bArr3 = X2;
            }
            byte[] b2 = c.b(this.dux, this.duA, this.duB, bArr3);
            if (b2 != null) {
                bArr3 = b2;
            }
            AppMethodBeat.o(136764);
            return bArr3;
        } else if (this.dux == 2 && this.duA == 2 && this.duE) {
            if (!(this.duv instanceof j)) {
                X = this.duv.X(bArr3);
            } else if (this.duA == 2) {
                int length = bArr3.length / 2;
                if (this.duJ == null || length != this.duJ.length) {
                    this.duJ = (byte[][]) Array.newInstance(Byte.TYPE, 2, length);
                }
                c.a(this.duB, bArr3, this.duJ);
                byte[] X3 = this.duv.X(this.duJ[0]);
                byte[] X4 = this.duK.X(this.duJ[1]);
                if (X3 == null || X4 == null) {
                    X = bArr3;
                } else {
                    X = c.a(this.duB, X3, X4);
                }
            } else {
                X = this.duv.X(bArr3);
            }
            if (X != null) {
                bArr3 = X;
            }
            AppMethodBeat.o(136764);
            return bArr3;
        } else {
            if (!this.duC || (bArr4 = c.b(this.dux, this.duA, this.duB, bArr3)) == null) {
                bArr4 = bArr3;
            }
            if (bArr4 != null) {
                bArr = bArr4;
            }
            if (this.duE) {
                synchronized (duI) {
                    try {
                        duG++;
                    } finally {
                        AppMethodBeat.o(136764);
                    }
                }
                System.nanoTime();
                byte[] X5 = this.duv.X(bArr);
                if (X5 != null) {
                    bArr = X5;
                }
                synchronized (duI) {
                    try {
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            AppMethodBeat.o(136764);
            return bArr;
        }
    }

    @Override // com.tencent.mm.audio.mix.c.h
    public void YR() {
    }

    @Override // com.tencent.mm.audio.mix.c.h
    public e YS() {
        return null;
    }

    @Override // com.tencent.mm.audio.mix.c.h
    public void flushCache() {
    }

    @Override // com.tencent.mm.audio.mix.c.h
    public void release() {
        AppMethodBeat.i(136765);
        if (this.duv != null) {
            this.duv.release();
            this.duv = null;
        }
        if (this.duK != null) {
            this.duK.release();
            this.duK = null;
        }
        AppMethodBeat.o(136765);
    }

    public i YQ() {
        AppMethodBeat.i(136762);
        j jVar = new j();
        AppMethodBeat.o(136762);
        return jVar;
    }
}
