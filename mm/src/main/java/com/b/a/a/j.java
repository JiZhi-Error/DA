package com.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

final class j {
    private double[] cig = new double[4];
    final b cih = new b((byte) 0);
    private final b cii = new b((byte) 0);

    j() {
        AppMethodBeat.i(87966);
        AppMethodBeat.o(87966);
    }

    /* access modifiers changed from: package-private */
    public static class b {
        boolean ciA;
        double[] ciB;
        double ciC;
        int ciD;
        int ciE;
        boolean ciF;
        boolean ciG;
        double ciH;
        double ciI;
        double ciJ;
        double ciK;
        double ciL;
        double ciM;
        double ciN;
        double[] ciO;
        private boolean ciP;
        boolean ciQ;
        boolean ciR;
        double[] ciS;
        double[][] ciT;
        double ciU;
        double ciV;
        double ciW;
        boolean ciX;
        double ciY;
        double ciZ;
        double cij;
        double ciw;
        boolean cix;
        double[] ciy;
        double ciz;
        int cja;
        int cjb;
        double cjc;
        double[] cjd;
        double[] cje;
        boolean cjf;

        private b() {
            AppMethodBeat.i(87963);
            this.ciy = new double[2];
            this.ciB = new double[2];
            this.ciO = new double[2];
            this.ciS = new double[4];
            this.ciT = (double[][]) Array.newInstance(Double.TYPE, 4, 4);
            this.cjd = new double[2];
            this.cje = new double[2];
            AppMethodBeat.o(87963);
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        static /* synthetic */ void a(b bVar, b bVar2) {
            AppMethodBeat.i(87965);
            bVar.a(bVar2);
            AppMethodBeat.o(87965);
        }

        private void a(b bVar) {
            AppMethodBeat.i(87964);
            this.ciw = bVar.ciw;
            this.cix = bVar.cix;
            this.ciy = (double[]) bVar.ciy.clone();
            this.ciz = bVar.ciz;
            this.ciA = bVar.ciA;
            this.ciB = (double[]) bVar.ciB.clone();
            this.ciC = bVar.ciC;
            this.ciD = bVar.ciD;
            this.ciE = bVar.ciE;
            this.ciF = bVar.ciF;
            this.ciG = bVar.ciG;
            this.ciH = bVar.ciH;
            this.ciI = bVar.ciI;
            this.ciJ = bVar.ciJ;
            this.ciK = bVar.ciK;
            this.ciL = bVar.ciL;
            this.ciM = bVar.ciM;
            this.ciN = bVar.ciN;
            this.ciO = (double[]) bVar.ciO.clone();
            this.ciP = bVar.ciP;
            this.ciQ = bVar.ciQ;
            this.ciR = bVar.ciR;
            this.cij = bVar.cij;
            this.ciS = (double[]) bVar.ciS.clone();
            this.ciT[0] = (double[]) bVar.ciT[0].clone();
            this.ciT[1] = (double[]) bVar.ciT[1].clone();
            this.ciT[2] = (double[]) bVar.ciT[2].clone();
            this.ciT[3] = (double[]) bVar.ciT[3].clone();
            this.ciU = bVar.ciU;
            this.ciV = bVar.ciV;
            this.ciW = bVar.ciW;
            this.ciX = bVar.ciX;
            this.ciY = bVar.ciY;
            this.ciZ = bVar.ciZ;
            this.cja = bVar.cja;
            this.cjb = bVar.cjb;
            this.cjc = bVar.cjc;
            this.cjd = (double[]) bVar.cjd.clone();
            this.cje = (double[]) bVar.cje.clone();
            this.cjf = bVar.cjf;
            AppMethodBeat.o(87964);
        }
    }

    protected static class a {
        double cij;
        double cik;
        double cil;
        double[] cim = new double[2];
        double cin;
        double cio;
        int cip;
        double ciq;
        double cir;
        int cis;
        double cit;
        double ciu;
        double civ;
        int mType;

        protected a(int i2, double d2, double d3, double d4, double d5, double d6, int i3, double d7, int i4, double d8, double d9) {
            AppMethodBeat.i(87961);
            this.mType = i2;
            this.cij = d2;
            this.cik = d3;
            this.cil = d4;
            this.cin = d5;
            this.cio = d6;
            this.cip = i3;
            this.ciq = d7;
            this.cir = 0.0d;
            this.cis = i4;
            this.cit = 0.0d;
            this.ciu = d8;
            this.civ = d9;
            AppMethodBeat.o(87961);
        }

        public final String toString() {
            AppMethodBeat.i(87962);
            String str = String.valueOf(String.valueOf(this.mType)) + ',' + this.cij + ',' + this.cik + ',' + this.cil + ',' + this.cin + ',' + this.cio + ',' + this.cip + ',' + this.ciq + ',' + this.cir + ',' + this.cis + ',' + this.ciu + ',' + this.civ;
            AppMethodBeat.o(87962);
            return str;
        }
    }

    /* access modifiers changed from: protected */
    public final void a(long j2, double d2, double d3, float f2, boolean z, boolean z2) {
        int i2;
        AppMethodBeat.i(87967);
        double d4 = (double) j2;
        double[] dArr = {d2, d3};
        double d5 = (double) (f2 * f2);
        double[] dArr2 = {0.0d, 0.0d};
        if (z) {
            i2 = 3;
        } else {
            i2 = 5;
        }
        double[] dArr3 = {d2, d3};
        this.cih.ciX = true;
        this.cih.cje[0] = 3.0d;
        this.cih.cje[1] = 1.2d;
        this.cih.cjc = 0.5d;
        this.cih.ciw = 1.2d;
        this.cih.ciC = 4.0d;
        this.cih.ciD = 0;
        this.cih.ciF = true;
        this.cih.ciE = i2;
        this.cih.cix = false;
        this.cih.ciA = false;
        this.cih.ciL = 40.0d;
        this.cih.ciM = 0.15707963267948966d;
        this.cih.ciN = 1.0d;
        this.cih.cjd[0] = 400.0d;
        this.cih.cjd[1] = 1.0d;
        this.cih.ciQ = z2;
        this.cih.ciR = false;
        this.cih.ciG = true;
        this.cih.ciH = 0.3333333333333333d;
        this.cih.ciI = 5.0d;
        this.cih.ciJ = 0.5d;
        this.cih.ciK = 1.0d;
        this.cih.ciY = 0.5d;
        this.cih.ciZ = 1.0d;
        this.cih.cja = 0;
        this.cih.cjb = 2;
        this.cih.cjf = false;
        this.cih.ciO[0] = dArr3[0];
        this.cih.ciO[1] = dArr3[1];
        double[] dArr4 = new double[2];
        a(0, dArr, dArr4);
        this.cih.cij = d4;
        this.cih.ciS[0] = dArr4[0];
        this.cih.ciS[1] = dArr4[1];
        this.cih.ciS[2] = dArr2[0];
        this.cih.ciS[3] = dArr2[1];
        this.cih.ciU = 0.0d;
        this.cih.ciV = 1.0d;
        this.cih.ciW = 1.005d;
        this.cih.ciT[0][0] = d5;
        this.cih.ciT[0][1] = 0.0d;
        this.cih.ciT[0][2] = 0.0d;
        this.cih.ciT[0][3] = 0.0d;
        this.cih.ciT[1][0] = 0.0d;
        this.cih.ciT[1][1] = d5;
        this.cih.ciT[1][2] = 0.0d;
        this.cih.ciT[1][3] = 0.0d;
        this.cih.ciT[2][0] = 0.0d;
        this.cih.ciT[2][1] = 0.0d;
        this.cih.ciT[2][2] = 1.0d;
        this.cih.ciT[2][3] = 0.0d;
        this.cih.ciT[3][0] = 0.0d;
        this.cih.ciT[3][1] = 0.0d;
        this.cih.ciT[3][2] = 0.0d;
        this.cih.ciT[3][3] = 1.0d;
        bK(z);
        AppMethodBeat.o(87967);
    }

    /* access modifiers changed from: protected */
    public final void bK(boolean z) {
        AppMethodBeat.i(87968);
        bL(!z);
        AppMethodBeat.o(87968);
    }

    private void bL(boolean z) {
        AppMethodBeat.i(87969);
        if (this.cih.ciX != z) {
            this.cih.ciX = z;
            if (z) {
                this.cih.ciw = this.cih.cje[1];
                this.cih.ciN = this.cih.cjd[1];
                a(this.cih.cij, true);
                AppMethodBeat.o(87969);
                return;
            }
            this.cih.ciw = this.cih.cje[0];
            this.cih.ciN = this.cih.cjd[0];
            a(this.cih.cij, true);
        }
        AppMethodBeat.o(87969);
    }

    /* access modifiers changed from: protected */
    public final void a(a aVar) {
        boolean z;
        double d2;
        double sqrt;
        double sqrt2;
        boolean z2;
        boolean z3;
        double d3;
        AppMethodBeat.i(87970);
        if (aVar.cio <= 0.0d) {
            AppMethodBeat.o(87970);
            return;
        }
        if (this.cih.cix) {
            double d4 = aVar.cij - this.cih.ciz;
            if (d4 < -10.0d) {
                AppMethodBeat.o(87970);
                return;
            } else if (d4 <= 0.0d) {
                aVar.cij = this.cih.ciz + 0.5d;
            }
        }
        double[] dArr = new double[2];
        a(0, new double[]{aVar.cik, aVar.cil}, dArr);
        aVar.cim[0] = dArr[0];
        aVar.cim[1] = dArr[1];
        if (this.cih.ciX) {
            if (aVar.mType != 3 || this.cih.cix) {
                if (aVar.mType == 3) {
                    double d5 = aVar.cij - this.cih.ciz;
                    if (d5 > 0.0d) {
                        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, 2, 2);
                        double[] dArr3 = new double[2];
                        double d6 = dArr[0] - this.cih.ciy[0];
                        double d7 = dArr[1] - this.cih.ciy[1];
                        if (this.cih.ciQ) {
                            d6 = (d6 * Math.cos(this.cih.ciU)) - (Math.sin(this.cih.ciU) * d7);
                            d7 = (d7 * Math.cos(this.cih.ciU)) + (Math.sin(this.cih.ciU) * d6);
                        }
                        double sqrt3 = Math.sqrt((d6 * d6) + (d7 * d7));
                        double d8 = sqrt3 / this.cih.ciL;
                        double d9 = d8 * d8;
                        if (d9 <= 0.0625d) {
                            d9 = 0.0625d;
                        }
                        double d10 = sqrt3 * this.cih.ciM;
                        double d11 = d10 * d10;
                        if (d11 <= 0.0625d) {
                            d11 = 0.0625d;
                        }
                        double d12 = (d9 + d11) / d5;
                        a(new double[]{this.cih.ciT[2][2], this.cih.ciT[2][3], this.cih.ciT[3][2], this.cih.ciT[3][3]}, this.cig);
                        dArr2[0][0] = this.cig[0];
                        dArr2[0][1] = this.cig[1];
                        dArr2[1][0] = this.cig[2];
                        dArr2[1][1] = this.cig[3];
                        double d13 = (d6 / d5) - this.cih.ciS[2];
                        double d14 = (d7 / d5) - this.cih.ciS[3];
                        if (Math.sqrt((d13 * d14 * dArr2[1][0]) + (d13 * d13 * dArr2[0][0]) + (d13 * d14 * dArr2[0][1]) + (d14 * d14 * dArr2[1][1])) > 2.0d) {
                            this.cih.ciT[2][2] = this.cih.ciN;
                            this.cih.ciT[2][3] = 0.0d;
                            this.cih.ciT[3][2] = 0.0d;
                            this.cih.ciT[3][3] = this.cih.ciN;
                            dArr2[0][0] = 1.0d / this.cih.ciN;
                            dArr2[0][1] = 0.0d;
                            dArr2[1][0] = 0.0d;
                            dArr2[1][1] = 1.0d / this.cih.ciN;
                        }
                        dArr3[0] = (dArr2[0][0] * this.cih.ciS[2]) + (dArr2[0][1] * this.cih.ciS[3]);
                        dArr3[1] = (dArr2[1][0] * this.cih.ciS[2]) + (dArr2[1][1] * this.cih.ciS[3]);
                        double[] dArr4 = dArr2[0];
                        dArr4[0] = dArr4[0] + (1.0d / d12);
                        double[] dArr5 = dArr2[1];
                        dArr5[1] = dArr5[1] + (1.0d / d12);
                        dArr3[0] = (d6 / (d5 * d12)) + dArr3[0];
                        dArr3[1] = (d7 / (d12 * d5)) + dArr3[1];
                        a(new double[]{dArr2[0][0], dArr2[0][1], dArr2[1][0], dArr2[1][1]}, this.cig);
                        this.cih.ciT[2][2] = this.cig[0];
                        this.cih.ciT[2][3] = this.cig[1];
                        this.cih.ciT[3][2] = this.cig[2];
                        this.cih.ciT[3][3] = this.cig[3];
                        this.cih.ciS[2] = (this.cih.ciT[2][2] * dArr3[0]) + (this.cih.ciT[2][3] * dArr3[1]);
                        this.cih.ciS[3] = (this.cih.ciT[3][2] * dArr3[0]) + (this.cih.ciT[3][3] * dArr3[1]);
                        a(aVar.cij, false);
                    }
                } else {
                    double d15 = 0.0d;
                    double d16 = 0.0d;
                    double[] dArr6 = new double[2];
                    double[] dArr7 = new double[2];
                    a(aVar.cij, false);
                    if (this.cih.ciG) {
                        if (!this.cih.ciA) {
                            z2 = true;
                            z3 = true;
                        } else {
                            dArr6[0] = this.cih.ciS[0] - this.cih.ciB[0];
                            dArr6[1] = this.cih.ciS[1] - this.cih.ciB[1];
                            dArr7[0] = dArr[0] - this.cih.ciB[0];
                            dArr7[1] = dArr[1] - this.cih.ciB[1];
                            d16 = Math.sqrt((dArr6[0] * dArr6[0]) + (dArr6[1] * dArr6[1]));
                            d15 = Math.sqrt((dArr7[0] * dArr7[0]) + (dArr7[1] * dArr7[1]));
                            if (d15 > this.cih.ciI && d16 > this.cih.ciI) {
                                double d17 = d15 / d16;
                                double d18 = d15 - d16;
                                double sqrt4 = Math.sqrt(this.cih.ciT[0][0] + this.cih.ciT[1][1]);
                                if (d16 > 3.0d * this.cih.ciI) {
                                    if (d18 < 0.0d) {
                                        d18 = -d18;
                                    }
                                    double d19 = d18 / sqrt4;
                                    double atan2 = Math.atan2(dArr7[1], dArr7[0]) - Math.atan2(dArr6[1], dArr6[0]);
                                    if (atan2 > 3.141592653589793d) {
                                        atan2 -= 6.283185307179586d;
                                    } else if (atan2 < -3.141592653589793d) {
                                        atan2 += 6.283185307179586d;
                                    }
                                    if (atan2 < 0.0d) {
                                        atan2 = -atan2;
                                    }
                                    double sqrt5 = atan2 / Math.sqrt(this.cih.ciV);
                                    double sqrt6 = Math.sqrt((sqrt5 * sqrt5) + (d19 * d19));
                                    if (sqrt6 < this.cih.ciC) {
                                        this.cih.cja = 0;
                                    } else if (d19 < this.cih.ciC) {
                                        b bVar = this.cih;
                                        int i2 = bVar.cja + 1;
                                        bVar.cja = i2;
                                        if (i2 >= this.cih.cjb) {
                                            this.cih.cja = 0;
                                            sqrt6 = d19;
                                        }
                                    }
                                    if (sqrt6 > this.cih.ciC) {
                                        z2 = false;
                                        z3 = false;
                                    } else {
                                        z2 = true;
                                        z3 = true;
                                    }
                                } else if (d17 < this.cih.ciH || 1.0d / d17 < this.cih.ciH) {
                                    z2 = false;
                                    z3 = false;
                                } else {
                                    z2 = true;
                                    z3 = false;
                                }
                            } else if ((d15 >= this.cih.ciI || aVar.mType != 2) && (d15 >= this.cih.ciI * 0.5d || aVar.mType != 1)) {
                                z2 = true;
                                z3 = false;
                            } else {
                                z2 = false;
                                z3 = false;
                            }
                        }
                        if (z2) {
                            if (this.cih.ciA) {
                                if (d15 < d16) {
                                    d3 = this.cih.ciJ;
                                } else {
                                    d3 = this.cih.ciK;
                                }
                                double d20 = d3 + ((d16 / d15) * (1.0d - d3));
                                dArr[0] = this.cih.ciB[0] + (dArr7[0] * d20);
                                dArr[1] = (d20 * dArr7[1]) + this.cih.ciB[1];
                            }
                            if (z3) {
                                a(dArr);
                            } else {
                                this.cih.ciB[0] = dArr[0];
                                this.cih.ciB[1] = dArr[1];
                            }
                            this.cih.ciS[0] = dArr[0];
                            this.cih.ciS[1] = dArr[1];
                            this.cih.ciT[0][0] = aVar.cio * aVar.cio;
                            this.cih.ciT[0][1] = 0.0d;
                            this.cih.ciT[1][0] = 0.0d;
                            this.cih.ciT[1][1] = aVar.cio * aVar.cio;
                        }
                    } else {
                        b.a(this.cii, this.cih);
                        b(aVar.cij, false);
                        if (!this.cii.ciF) {
                            double d21 = dArr[0] - this.cii.ciS[0];
                            double d22 = dArr[1] - this.cii.ciS[1];
                            double[][] dArr8 = (double[][]) Array.newInstance(Double.TYPE, 2, 2);
                            double d23 = 1.0d / ((this.cii.ciT[0][0] * this.cii.ciT[1][1]) - (this.cii.ciT[0][1] * this.cii.ciT[1][0]));
                            dArr8[0][0] = this.cii.ciT[1][1] * d23;
                            dArr8[1][1] = this.cii.ciT[0][0] * d23;
                            dArr8[0][1] = (-this.cii.ciT[0][1]) * d23;
                            dArr8[1][0] = d23 * (-this.cii.ciT[1][0]);
                            sqrt = Math.sqrt((dArr8[1][1] * d22 * d22) + (d21 * 2.0d * d22 * dArr8[1][0]) + (d21 * d21 * dArr8[0][0]));
                        } else if (!this.cih.ciA) {
                            sqrt = 0.0d;
                        } else {
                            double d24 = this.cih.ciB[0] - this.cii.ciS[0];
                            double d25 = this.cih.ciB[1] - this.cii.ciS[1];
                            double d26 = this.cih.ciB[0] - dArr[0];
                            double d27 = this.cih.ciB[1] - dArr[1];
                            sqrt = Math.abs(Math.sqrt((d24 * d24) + (d25 * d25)) - Math.sqrt((d26 * d26) + (d27 * d27))) / Math.sqrt((this.cih.ciT[0][0] * this.cih.ciT[0][0]) + (this.cih.ciT[1][1] * this.cih.ciT[1][1]));
                        }
                        if (sqrt > this.cih.ciC) {
                            b.a(this.cii, this.cih);
                            b(aVar.cij, true);
                            if (this.cih.ciF) {
                                double d28 = this.cih.ciB[0] - this.cii.ciS[0];
                                double d29 = this.cih.ciB[1] - this.cii.ciS[1];
                                double d30 = this.cih.ciB[0] - dArr[0];
                                double d31 = this.cih.ciB[1] - dArr[1];
                                sqrt2 = Math.abs(Math.sqrt((d28 * d28) + (d29 * d29)) - Math.sqrt((d30 * d30) + (d31 * d31))) / Math.sqrt((this.cii.ciT[0][0] * this.cii.ciT[0][0]) + (this.cii.ciT[1][1] * this.cii.ciT[1][1]));
                            } else {
                                double d32 = dArr[0] - this.cii.ciS[0];
                                double d33 = dArr[1] - this.cii.ciS[1];
                                double[][] dArr9 = (double[][]) Array.newInstance(Double.TYPE, 2, 2);
                                double d34 = 1.0d / ((this.cii.ciT[0][0] * this.cii.ciT[1][1]) - (this.cii.ciT[0][1] * this.cii.ciT[1][0]));
                                dArr9[0][0] = this.cii.ciT[1][1] * d34;
                                dArr9[1][1] = this.cii.ciT[0][0] * d34;
                                dArr9[0][1] = (-this.cii.ciT[0][1]) * d34;
                                dArr9[1][0] = d34 * (-this.cii.ciT[1][0]);
                                sqrt2 = Math.sqrt((dArr9[1][1] * d33 * d33) + (d32 * 2.0d * d33 * dArr9[1][0]) + (d32 * d32 * dArr9[0][0]));
                            }
                            if (sqrt2 <= this.cii.ciC) {
                                b.a(this.cih, this.cii);
                                this.cih.ciD = 0;
                                a(dArr);
                            } else if (this.cih.ciD < this.cih.ciE) {
                                this.cih.ciD++;
                            } else {
                                b.a(this.cih, this.cii);
                                this.cih.ciD = 0;
                            }
                        } else {
                            b.a(this.cih, this.cii);
                            this.cih.ciD = 0;
                            a(dArr);
                        }
                        this.cih.ciS[0] = dArr[0];
                        this.cih.ciS[1] = dArr[1];
                        this.cih.ciT[0][0] = aVar.cio * aVar.cio;
                        this.cih.ciT[0][1] = 0.0d;
                        this.cih.ciT[1][0] = 0.0d;
                        this.cih.ciT[1][1] = aVar.cio * aVar.cio;
                    }
                }
            }
            if (aVar.mType == 3) {
                this.cih.ciy[0] = dArr[0];
                this.cih.ciy[1] = dArr[1];
                this.cih.ciz = aVar.cij;
                this.cih.cix = true;
                AppMethodBeat.o(87970);
                return;
            }
        } else if (aVar.mType != 3) {
            boolean z4 = false;
            double[] dArr10 = new double[2];
            double[] dArr11 = new double[2];
            double[] dArr12 = new double[2];
            a(aVar.cij, false);
            if (!this.cih.ciA) {
                z = true;
                z4 = false;
                this.cih.ciD = 0;
            } else {
                double[][] dArr13 = (double[][]) Array.newInstance(Double.TYPE, 2, 2);
                dArr10[0] = aVar.cim[0] - this.cih.ciS[0];
                dArr10[1] = aVar.cim[1] - this.cih.ciS[1];
                a(new double[]{this.cih.ciT[0][0], this.cih.ciT[0][1], this.cih.ciT[1][0], this.cih.ciT[1][1]}, this.cig);
                dArr13[0][0] = this.cig[0];
                dArr13[0][1] = this.cig[1];
                dArr13[1][0] = this.cig[2];
                dArr13[1][1] = this.cig[3];
                if (Math.sqrt((dArr10[0] * dArr10[0] * dArr13[0][0]) + (2.0d * dArr10[0] * dArr10[1] * dArr13[1][0]) + (dArr10[1] * dArr10[1] * dArr13[1][1])) > this.cih.ciC) {
                    b bVar2 = this.cih;
                    int i3 = bVar2.ciD + 1;
                    bVar2.ciD = i3;
                    if (i3 >= this.cih.ciE) {
                        z = true;
                        z4 = false;
                        this.cih.ciD = 0;
                    } else {
                        z = false;
                    }
                } else {
                    this.cih.ciD = 0;
                    z = true;
                    z4 = true;
                }
            }
            if (z) {
                if (!z4) {
                    this.cih.ciS[0] = aVar.cim[0];
                    this.cih.ciS[1] = aVar.cim[1];
                    this.cih.ciS[2] = 0.0d;
                    this.cih.ciS[3] = 0.0d;
                    this.cih.ciT[0][0] = aVar.cio * aVar.cio;
                    this.cih.ciT[0][1] = 0.0d;
                    this.cih.ciT[0][2] = 0.0d;
                    this.cih.ciT[0][3] = 0.0d;
                    this.cih.ciT[1][0] = 0.0d;
                    this.cih.ciT[1][1] = this.cih.ciT[0][0];
                    this.cih.ciT[1][2] = 0.0d;
                    this.cih.ciT[1][2] = 0.0d;
                    this.cih.ciT[2][0] = 0.0d;
                    this.cih.ciT[2][1] = 0.0d;
                    this.cih.ciT[2][2] = this.cih.ciN;
                    this.cih.ciT[2][3] = 0.0d;
                    this.cih.ciT[3][0] = 0.0d;
                    this.cih.ciT[3][1] = 0.0d;
                    this.cih.ciT[3][2] = 0.0d;
                    this.cih.ciT[3][3] = this.cih.ciN;
                    this.cih.ciB[0] = aVar.cim[0];
                    this.cih.ciB[1] = aVar.cim[1];
                    this.cih.ciA = true;
                    AppMethodBeat.o(87970);
                    return;
                }
                double[][] dArr14 = (double[][]) Array.newInstance(Double.TYPE, 4, 4);
                double[] dArr15 = new double[2];
                dArr11[0] = this.cih.ciS[0] - this.cih.ciB[0];
                dArr11[1] = this.cih.ciS[1] - this.cih.ciB[1];
                dArr12[0] = aVar.cim[0] - this.cih.ciB[0];
                dArr12[1] = aVar.cim[1] - this.cih.ciB[1];
                double sqrt7 = Math.sqrt((dArr12[0] * dArr12[0]) + (dArr12[1] * dArr12[1]));
                double sqrt8 = Math.sqrt((dArr11[1] * dArr11[1]) + (dArr11[0] * dArr11[0]));
                if (sqrt7 < sqrt8) {
                    d2 = this.cih.ciY;
                } else {
                    d2 = this.cih.ciZ;
                }
                if (a(this.cih.ciT, dArr14)) {
                    double d35 = 1.0d / (aVar.cio * aVar.cio);
                    double[] dArr16 = new double[4];
                    if (this.cih.cjf) {
                        double d36 = d2 + ((sqrt8 / sqrt7) * (1.0d - d2));
                        dArr15[0] = this.cih.ciB[0] + (dArr12[0] * d36);
                        dArr15[1] = (d36 * dArr12[1]) + this.cih.ciB[1];
                    } else {
                        dArr15[0] = (this.cih.ciS[0] * (1.0d - d2)) + (aVar.cim[0] * d2);
                        dArr15[1] = (d2 * aVar.cim[1]) + (this.cih.ciS[1] * (1.0d - d2));
                    }
                    for (int i4 = 0; i4 < 4; i4++) {
                        dArr16[i4] = 0.0d;
                        for (int i5 = 0; i5 < 4; i5++) {
                            dArr16[i4] = dArr16[i4] + (dArr14[i4][i5] * this.cih.ciS[i5]);
                        }
                    }
                    double[] dArr17 = dArr14[0];
                    dArr17[0] = dArr17[0] + d35;
                    double[] dArr18 = dArr14[1];
                    dArr18[1] = dArr18[1] + d35;
                    if (a(dArr14, this.cih.ciT)) {
                        dArr16[0] = dArr16[0] + (dArr15[0] * d35);
                        dArr16[1] = dArr16[1] + (dArr15[1] * d35);
                        for (int i6 = 0; i6 < 4; i6++) {
                            this.cih.ciS[i6] = 0.0d;
                            for (int i7 = 0; i7 < 4; i7++) {
                                double[] dArr19 = this.cih.ciS;
                                dArr19[i6] = dArr19[i6] + (this.cih.ciT[i6][i7] * dArr16[i7]);
                            }
                        }
                        this.cih.ciB[0] = dArr15[0];
                        this.cih.ciB[1] = dArr15[1];
                    }
                }
            }
        }
        AppMethodBeat.o(87970);
    }

    private void a(double d2, boolean z) {
        double d3 = d2 - this.cih.cij;
        double d4 = d3 * d3;
        if (z) {
            this.cih.ciT[2][2] = this.cih.ciN;
            this.cih.ciT[2][3] = 0.0d;
            this.cih.ciT[3][2] = 0.0d;
            this.cih.ciT[3][3] = this.cih.ciN;
        } else {
            double d5 = 1.0d;
            if (d3 > 0.5d) {
                for (double d6 = 0.0d; d6 < d3; d6 += 1.0d) {
                    d5 *= this.cih.ciw;
                }
            }
            double[] dArr = this.cih.ciT[2];
            dArr[2] = dArr[2] * d5;
            double[] dArr2 = this.cih.ciT[2];
            dArr2[3] = dArr2[3] * d5;
            double[] dArr3 = this.cih.ciT[3];
            dArr3[2] = dArr3[2] * d5;
            double[] dArr4 = this.cih.ciT[3];
            dArr4[3] = d5 * dArr4[3];
        }
        if (d3 > 0.5d) {
            double d7 = 1.0d;
            for (double d8 = 0.0d; d8 < d3; d8 += 1.0d) {
                d7 *= this.cih.ciW;
            }
            b bVar = this.cih;
            bVar.ciV = d7 * bVar.ciV;
        }
        this.cih.ciS[0] = this.cih.ciS[0] + (this.cih.ciS[2] * d3);
        this.cih.ciS[1] = this.cih.ciS[1] + (this.cih.ciS[3] * d3);
        if (this.cih.ciX) {
            this.cih.ciT[0][0] = this.cih.ciT[0][0] + (this.cih.ciT[2][2] * d4);
            this.cih.ciT[0][1] = this.cih.ciT[0][1] + (this.cih.ciT[2][3] * d4);
            this.cih.ciT[1][0] = this.cih.ciT[1][0] + (this.cih.ciT[3][2] * d4);
            this.cih.ciT[1][1] = this.cih.ciT[1][1] + (this.cih.ciT[3][3] * d4);
        } else {
            this.cih.ciT[0][0] = this.cih.ciT[0][0] + ((this.cih.ciT[0][2] + this.cih.ciT[2][0]) * d3) + (this.cih.ciT[2][2] * d4);
            this.cih.ciT[1][1] = this.cih.ciT[1][1] + ((this.cih.ciT[1][3] + this.cih.ciT[3][1]) * d3) + (d4 * this.cih.ciT[3][3]);
            this.cih.ciT[0][2] = this.cih.ciT[0][2] + (this.cih.ciT[2][2] * d3);
            this.cih.ciT[2][0] = this.cih.ciT[2][0] + (this.cih.ciT[2][2] * d3);
            this.cih.ciT[1][3] = this.cih.ciT[1][3] + (this.cih.ciT[3][3] * d3);
            this.cih.ciT[3][1] = this.cih.ciT[3][1] + (d3 * this.cih.ciT[3][3]);
        }
        this.cih.cij = d2;
    }

    private void b(double d2, boolean z) {
        double d3 = d2 - this.cii.cij;
        double d4 = d3 * d3;
        if (z) {
            this.cii.ciT[2][2] = this.cii.ciN;
            this.cii.ciT[2][3] = 0.0d;
            this.cii.ciT[3][2] = 0.0d;
            this.cii.ciT[3][3] = this.cii.ciN;
        } else {
            double d5 = 1.0d;
            if (d3 > 0.5d) {
                for (double d6 = 0.0d; d6 < d3; d6 += 1.0d) {
                    d5 *= this.cii.ciw;
                }
            }
            double[] dArr = this.cii.ciT[2];
            dArr[2] = dArr[2] * d5;
            double[] dArr2 = this.cii.ciT[2];
            dArr2[3] = dArr2[3] * d5;
            double[] dArr3 = this.cii.ciT[3];
            dArr3[2] = dArr3[2] * d5;
            double[] dArr4 = this.cii.ciT[3];
            dArr4[3] = d5 * dArr4[3];
        }
        if (d3 > 0.5d) {
            double d7 = 1.0d;
            for (double d8 = 0.0d; d8 < d3; d8 += 1.0d) {
                d7 *= this.cii.ciW;
            }
            b bVar = this.cii;
            bVar.ciV = d7 * bVar.ciV;
        }
        this.cii.ciS[0] = this.cii.ciS[0] + (this.cii.ciS[2] * d3);
        this.cii.ciS[1] = this.cii.ciS[1] + (this.cii.ciS[3] * d3);
        if (this.cii.ciX) {
            this.cii.ciT[0][0] = this.cii.ciT[0][0] + (this.cii.ciT[2][2] * d4);
            this.cii.ciT[0][1] = this.cii.ciT[0][1] + (this.cii.ciT[2][3] * d4);
            this.cii.ciT[1][0] = this.cii.ciT[1][0] + (this.cii.ciT[3][2] * d4);
            this.cii.ciT[1][1] = this.cii.ciT[1][1] + (this.cii.ciT[3][3] * d4);
        } else {
            this.cii.ciT[0][0] = this.cii.ciT[0][0] + ((this.cii.ciT[0][2] + this.cii.ciT[2][0]) * d3) + (this.cii.ciT[2][2] * d4);
            this.cii.ciT[1][1] = this.cii.ciT[1][1] + ((this.cii.ciT[1][3] + this.cii.ciT[3][1]) * d3) + (d4 * this.cii.ciT[3][3]);
            this.cii.ciT[0][2] = this.cii.ciT[0][2] + (this.cii.ciT[2][2] * d3);
            this.cii.ciT[2][0] = this.cii.ciT[2][0] + (this.cii.ciT[2][2] * d3);
            this.cii.ciT[1][3] = this.cii.ciT[1][3] + (this.cii.ciT[3][3] * d3);
            this.cii.ciT[3][1] = this.cii.ciT[3][1] + (d3 * this.cii.ciT[3][3]);
        }
        this.cii.cij = d2;
    }

    private void a(double[] dArr) {
        boolean z;
        AppMethodBeat.i(87971);
        if (this.cih.ciQ && this.cih.ciA) {
            double d2 = this.cih.cjc;
            double[] dArr2 = {this.cih.ciS[0] - this.cih.ciB[0], this.cih.ciS[1] - this.cih.ciB[1]};
            double[] dArr3 = {dArr[0] - this.cih.ciB[0], dArr[1] - this.cih.ciB[1]};
            double sqrt = Math.sqrt((dArr2[0] * dArr2[0]) + (dArr2[1] * dArr2[1]));
            double sqrt2 = Math.sqrt((dArr3[0] * dArr3[0]) + (dArr3[1] * dArr3[1]));
            if (sqrt > this.cih.ciI && sqrt2 > this.cih.ciI) {
                double atan2 = Math.atan2(dArr3[1], dArr3[0]) - Math.atan2(dArr2[1], dArr2[0]);
                if (atan2 > 3.141592653589793d) {
                    atan2 -= 6.283185307179586d;
                } else if (atan2 < -3.141592653589793d) {
                    atan2 += 6.283185307179586d;
                }
                b bVar = this.cih;
                bVar.ciU = (d2 * atan2) + bVar.ciU;
                if (atan2 * atan2 > 4.0d * this.cih.ciV) {
                    z = true;
                } else {
                    z = false;
                }
                double sqrt3 = Math.sqrt(this.cih.ciT[0][0] + this.cih.ciT[1][1]);
                if (sqrt >= sqrt2) {
                    sqrt = sqrt2;
                }
                double d3 = sqrt3 / sqrt;
                if (z) {
                    this.cih.ciV = d3 * d3;
                } else {
                    this.cih.ciV = 1.0d / ((1.0d / (d3 * d3)) + (1.0d / this.cih.ciV));
                }
            }
        }
        this.cih.ciB[0] = dArr[0];
        this.cih.ciB[1] = dArr[1];
        this.cih.ciA = true;
        AppMethodBeat.o(87971);
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, double[] dArr, double[] dArr2) {
        AppMethodBeat.i(87972);
        switch (i2) {
            case 0:
                dArr2[0] = (dArr[1] - this.cih.ciO[1]) * 6378137.0d * Math.cos(this.cih.ciO[0]);
                dArr2[1] = (dArr[0] - this.cih.ciO[0]) * 6378137.0d;
                AppMethodBeat.o(87972);
                return;
            case 1:
                dArr2[0] = (dArr[1] / 6378137.0d) + this.cih.ciO[0];
                dArr2[1] = (dArr[0] / (Math.cos(this.cih.ciO[0]) * 6378137.0d)) + this.cih.ciO[1];
                break;
        }
        AppMethodBeat.o(87972);
    }

    private static void a(double[] dArr, double[] dArr2) {
        double d2 = 1.0d / ((dArr[0] * dArr[3]) - (dArr[1] * dArr[2]));
        dArr2[0] = dArr[3] * d2;
        dArr2[3] = dArr[0] * d2;
        dArr2[1] = (-dArr[1]) * d2;
        dArr2[2] = d2 * (-dArr[2]);
    }

    private static boolean a(double[][] dArr, double[][] dArr2) {
        double[][] dArr3 = (double[][]) Array.newInstance(Double.TYPE, 4, 4);
        dArr3[0][0] = ((((((dArr[1][1] * dArr[2][2]) * dArr[3][3]) - ((dArr[1][1] * dArr[2][3]) * dArr[3][2])) - ((dArr[2][1] * dArr[1][2]) * dArr[3][3])) + ((dArr[2][1] * dArr[1][3]) * dArr[3][2])) + ((dArr[3][1] * dArr[1][2]) * dArr[2][3])) - ((dArr[3][1] * dArr[1][3]) * dArr[2][2]);
        dArr3[1][0] = (((((((-dArr[1][0]) * dArr[2][2]) * dArr[3][3]) + ((dArr[1][0] * dArr[2][3]) * dArr[3][2])) + ((dArr[2][0] * dArr[1][2]) * dArr[3][3])) - ((dArr[2][0] * dArr[1][3]) * dArr[3][2])) - ((dArr[3][0] * dArr[1][2]) * dArr[2][3])) + (dArr[3][0] * dArr[1][3] * dArr[2][2]);
        dArr3[2][0] = ((((((dArr[1][0] * dArr[2][1]) * dArr[3][3]) - ((dArr[1][0] * dArr[2][3]) * dArr[3][1])) - ((dArr[2][0] * dArr[1][1]) * dArr[3][3])) + ((dArr[2][0] * dArr[1][3]) * dArr[3][1])) + ((dArr[3][0] * dArr[1][1]) * dArr[2][3])) - ((dArr[3][0] * dArr[1][3]) * dArr[2][1]);
        dArr3[3][0] = (((((((-dArr[1][0]) * dArr[2][1]) * dArr[3][2]) + ((dArr[1][0] * dArr[2][2]) * dArr[3][1])) + ((dArr[2][0] * dArr[1][1]) * dArr[3][2])) - ((dArr[2][0] * dArr[1][2]) * dArr[3][1])) - ((dArr[3][0] * dArr[1][1]) * dArr[2][2])) + (dArr[3][0] * dArr[1][2] * dArr[2][1]);
        dArr3[0][1] = (((((((-dArr[0][1]) * dArr[2][2]) * dArr[3][3]) + ((dArr[0][1] * dArr[2][3]) * dArr[3][2])) + ((dArr[2][1] * dArr[0][2]) * dArr[3][3])) - ((dArr[2][1] * dArr[0][3]) * dArr[3][2])) - ((dArr[3][1] * dArr[0][2]) * dArr[2][3])) + (dArr[3][1] * dArr[0][3] * dArr[2][2]);
        dArr3[1][1] = ((((((dArr[0][0] * dArr[2][2]) * dArr[3][3]) - ((dArr[0][0] * dArr[2][3]) * dArr[3][2])) - ((dArr[2][0] * dArr[0][2]) * dArr[3][3])) + ((dArr[2][0] * dArr[0][3]) * dArr[3][2])) + ((dArr[3][0] * dArr[0][2]) * dArr[2][3])) - ((dArr[3][0] * dArr[0][3]) * dArr[2][2]);
        dArr3[2][1] = (((((((-dArr[0][0]) * dArr[2][1]) * dArr[3][3]) + ((dArr[0][0] * dArr[2][3]) * dArr[3][1])) + ((dArr[2][0] * dArr[0][1]) * dArr[3][3])) - ((dArr[2][0] * dArr[0][3]) * dArr[3][1])) - ((dArr[3][0] * dArr[0][1]) * dArr[2][3])) + (dArr[3][0] * dArr[0][3] * dArr[2][1]);
        dArr3[3][1] = ((((((dArr[0][0] * dArr[2][1]) * dArr[3][2]) - ((dArr[0][0] * dArr[2][2]) * dArr[3][1])) - ((dArr[2][0] * dArr[0][1]) * dArr[3][2])) + ((dArr[2][0] * dArr[0][2]) * dArr[3][1])) + ((dArr[3][0] * dArr[0][1]) * dArr[2][2])) - ((dArr[3][0] * dArr[0][2]) * dArr[2][1]);
        dArr3[0][2] = ((((((dArr[0][1] * dArr[1][2]) * dArr[3][3]) - ((dArr[0][1] * dArr[1][3]) * dArr[3][2])) - ((dArr[1][1] * dArr[0][2]) * dArr[3][3])) + ((dArr[1][1] * dArr[0][3]) * dArr[3][2])) + ((dArr[3][1] * dArr[0][2]) * dArr[1][3])) - ((dArr[3][1] * dArr[0][3]) * dArr[1][2]);
        dArr3[1][2] = (((((((-dArr[0][0]) * dArr[1][2]) * dArr[3][3]) + ((dArr[0][0] * dArr[1][3]) * dArr[3][2])) + ((dArr[1][0] * dArr[0][2]) * dArr[3][3])) - ((dArr[1][0] * dArr[0][3]) * dArr[3][2])) - ((dArr[3][0] * dArr[0][2]) * dArr[1][3])) + (dArr[3][0] * dArr[0][3] * dArr[1][2]);
        dArr3[2][2] = ((((((dArr[0][0] * dArr[1][1]) * dArr[3][3]) - ((dArr[0][0] * dArr[1][3]) * dArr[3][1])) - ((dArr[1][0] * dArr[0][1]) * dArr[3][3])) + ((dArr[1][0] * dArr[0][3]) * dArr[3][1])) + ((dArr[3][0] * dArr[0][1]) * dArr[1][3])) - ((dArr[3][0] * dArr[0][3]) * dArr[1][1]);
        dArr3[3][2] = (((((((-dArr[0][0]) * dArr[1][1]) * dArr[3][2]) + ((dArr[0][0] * dArr[1][2]) * dArr[3][1])) + ((dArr[1][0] * dArr[0][1]) * dArr[3][2])) - ((dArr[1][0] * dArr[0][2]) * dArr[3][1])) - ((dArr[3][0] * dArr[0][1]) * dArr[1][2])) + (dArr[3][0] * dArr[0][2] * dArr[1][1]);
        dArr3[0][3] = (((((((-dArr[0][1]) * dArr[1][2]) * dArr[2][3]) + ((dArr[0][1] * dArr[1][3]) * dArr[2][2])) + ((dArr[1][1] * dArr[0][2]) * dArr[2][3])) - ((dArr[1][1] * dArr[0][3]) * dArr[2][2])) - ((dArr[2][1] * dArr[0][2]) * dArr[1][3])) + (dArr[2][1] * dArr[0][3] * dArr[1][2]);
        dArr3[1][3] = ((((((dArr[0][0] * dArr[1][2]) * dArr[2][3]) - ((dArr[0][0] * dArr[1][3]) * dArr[2][2])) - ((dArr[1][0] * dArr[0][2]) * dArr[2][3])) + ((dArr[1][0] * dArr[0][3]) * dArr[2][2])) + ((dArr[2][0] * dArr[0][2]) * dArr[1][3])) - ((dArr[2][0] * dArr[0][3]) * dArr[1][2]);
        dArr3[2][3] = (((((((-dArr[0][0]) * dArr[1][1]) * dArr[2][3]) + ((dArr[0][0] * dArr[1][3]) * dArr[2][1])) + ((dArr[1][0] * dArr[0][1]) * dArr[2][3])) - ((dArr[1][0] * dArr[0][3]) * dArr[2][1])) - ((dArr[2][0] * dArr[0][1]) * dArr[1][3])) + (dArr[2][0] * dArr[0][3] * dArr[1][1]);
        dArr3[3][3] = ((((((dArr[0][0] * dArr[1][1]) * dArr[2][2]) - ((dArr[0][0] * dArr[1][2]) * dArr[2][1])) - ((dArr[1][0] * dArr[0][1]) * dArr[2][2])) + ((dArr[1][0] * dArr[0][2]) * dArr[2][1])) + ((dArr[2][0] * dArr[0][1]) * dArr[1][2])) - ((dArr[2][0] * dArr[0][2]) * dArr[1][1]);
        double d2 = (dArr[0][0] * dArr3[0][0]) + (dArr[0][1] * dArr3[1][0]) + (dArr[0][2] * dArr3[2][0]) + (dArr[0][3] * dArr3[3][0]);
        if (d2 == 0.0d) {
            return false;
        }
        double d3 = 1.0d / d2;
        for (int i2 = 0; i2 < 4; i2++) {
            for (int i3 = 0; i3 < 4; i3++) {
                dArr2[i2][i3] = dArr3[i2][i3] * d3;
            }
        }
        return true;
    }
}
