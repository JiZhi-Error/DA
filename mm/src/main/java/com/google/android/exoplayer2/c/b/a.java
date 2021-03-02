package com.google.android.exoplayer2.c.b;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Stack;

final class a implements b {
    private final byte[] biE = new byte[8];
    private final Stack<C0100a> biF = new Stack<>();
    private final f biG = new f();
    private c biH;
    private int biI;
    private int biJ;
    private long biK;

    a() {
        AppMethodBeat.i(91999);
        AppMethodBeat.o(91999);
    }

    @Override // com.google.android.exoplayer2.c.b.b
    public final void a(c cVar) {
        this.biH = cVar;
    }

    @Override // com.google.android.exoplayer2.c.b.b
    public final void reset() {
        AppMethodBeat.i(92000);
        this.biI = 0;
        this.biF.clear();
        this.biG.reset();
        AppMethodBeat.o(92000);
    }

    @Override // com.google.android.exoplayer2.c.b.b
    public final boolean c(f fVar) {
        String str;
        double longBitsToDouble;
        AppMethodBeat.i(92001);
        com.google.android.exoplayer2.i.a.checkState(this.biH != null);
        while (true) {
            if (this.biF.isEmpty() || fVar.getPosition() < this.biF.peek().biL) {
                if (this.biI == 0) {
                    long a2 = this.biG.a(fVar, true, false, 4);
                    if (a2 == -2) {
                        fVar.uv();
                        while (true) {
                            fVar.b(this.biE, 0, 4);
                            int ea = f.ea(this.biE[0]);
                            if (ea != -1 && ea <= 4) {
                                int a3 = (int) f.a(this.biE, ea, false);
                                if (this.biH.dY(a3)) {
                                    fVar.dP(ea);
                                    a2 = (long) a3;
                                }
                            }
                            fVar.dP(1);
                        }
                    }
                    if (a2 == -1) {
                        AppMethodBeat.o(92001);
                        return false;
                    }
                    this.biJ = (int) a2;
                    this.biI = 1;
                }
                if (this.biI == 1) {
                    this.biK = this.biG.a(fVar, false, true, 8);
                    this.biI = 2;
                }
                int dX = this.biH.dX(this.biJ);
                switch (dX) {
                    case 0:
                        fVar.dP((int) this.biK);
                        this.biI = 0;
                    case 1:
                        long position = fVar.getPosition();
                        this.biF.add(new C0100a(this.biJ, this.biK + position, (byte) 0));
                        this.biH.f(this.biJ, position, this.biK);
                        this.biI = 0;
                        AppMethodBeat.o(92001);
                        return true;
                    case 2:
                        if (this.biK > 8) {
                            o oVar = new o("Invalid integer size: " + this.biK);
                            AppMethodBeat.o(92001);
                            throw oVar;
                        }
                        this.biH.i(this.biJ, a(fVar, (int) this.biK));
                        this.biI = 0;
                        AppMethodBeat.o(92001);
                        return true;
                    case 3:
                        if (this.biK > 2147483647L) {
                            o oVar2 = new o("String element size: " + this.biK);
                            AppMethodBeat.o(92001);
                            throw oVar2;
                        }
                        c cVar = this.biH;
                        int i2 = this.biJ;
                        int i3 = (int) this.biK;
                        if (i3 == 0) {
                            str = "";
                        } else {
                            byte[] bArr = new byte[i3];
                            fVar.readFully(bArr, 0, i3);
                            str = new String(bArr);
                        }
                        cVar.d(i2, str);
                        this.biI = 0;
                        AppMethodBeat.o(92001);
                        return true;
                    case 4:
                        this.biH.a(this.biJ, (int) this.biK, fVar);
                        this.biI = 0;
                        AppMethodBeat.o(92001);
                        return true;
                    case 5:
                        if (this.biK == 4 || this.biK == 8) {
                            c cVar2 = this.biH;
                            int i4 = this.biJ;
                            int i5 = (int) this.biK;
                            long a4 = a(fVar, i5);
                            if (i5 == 4) {
                                longBitsToDouble = (double) Float.intBitsToFloat((int) a4);
                            } else {
                                longBitsToDouble = Double.longBitsToDouble(a4);
                            }
                            cVar2.b(i4, longBitsToDouble);
                            this.biI = 0;
                            AppMethodBeat.o(92001);
                            return true;
                        }
                        o oVar3 = new o("Invalid float size: " + this.biK);
                        AppMethodBeat.o(92001);
                        throw oVar3;
                    default:
                        o oVar4 = new o("Invalid element type ".concat(String.valueOf(dX)));
                        AppMethodBeat.o(92001);
                        throw oVar4;
                }
            } else {
                this.biH.dZ(this.biF.pop().biJ);
                AppMethodBeat.o(92001);
                return true;
            }
        }
    }

    private long a(f fVar, int i2) {
        AppMethodBeat.i(92002);
        fVar.readFully(this.biE, 0, i2);
        long j2 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j2 = (j2 << 8) | ((long) (this.biE[i3] & 255));
        }
        AppMethodBeat.o(92002);
        return j2;
    }

    /* renamed from: com.google.android.exoplayer2.c.b.a$a  reason: collision with other inner class name */
    static final class C0100a {
        final int biJ;
        final long biL;

        /* synthetic */ C0100a(int i2, long j2, byte b2) {
            this(i2, j2);
        }

        private C0100a(int i2, long j2) {
            this.biJ = i2;
            this.biL = j2;
        }
    }
}
