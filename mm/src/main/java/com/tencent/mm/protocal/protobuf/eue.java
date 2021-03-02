package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class eue extends a {
    public euk NpJ;
    public euk NpK;
    public int NrE;
    public esr NrF;
    public esr NrG;
    public int NrH;
    public int NrI;
    public int NrJ;
    public int NrK;
    public SKBuiltinBuffer_t NrL;
    public int NrM;
    public esr NrN;
    public int NrO;
    public int NrP;
    public int NrQ;
    public int NrR;
    public int NrS;
    public int NrT;
    public SKBuiltinBuffer_t NrU;
    public SKBuiltinBuffer_t NrV;
    public int NrW;
    public SKBuiltinBuffer_t NrX;
    public int NrY;
    public int NrZ;
    public dmm Nrx;
    public ahk Nry;
    public int Nsa;
    public cez Nsb;
    public SKBuiltinBuffer_t Nsc;
    public int Nsd;
    public String Nse;
    public int Nsf;
    public LinkedList<euf> Nsg = new LinkedList<>();
    public bqy Nsh;
    public int yqc;

    public eue() {
        AppMethodBeat.i(115899);
        AppMethodBeat.o(115899);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115900);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NpJ == null) {
                b bVar = new b("Not all required fields were included: PeerId");
                AppMethodBeat.o(115900);
                throw bVar;
            } else if (this.NpK == null) {
                b bVar2 = new b("Not all required fields were included: CapInfo");
                AppMethodBeat.o(115900);
                throw bVar2;
            } else {
                if (this.NpJ != null) {
                    aVar.ni(1, this.NpJ.computeSize());
                    this.NpJ.writeFields(aVar);
                }
                if (this.NpK != null) {
                    aVar.ni(2, this.NpK.computeSize());
                    this.NpK.writeFields(aVar);
                }
                aVar.aM(3, this.NrE);
                if (this.NrF != null) {
                    aVar.ni(4, this.NrF.computeSize());
                    this.NrF.writeFields(aVar);
                }
                if (this.NrG != null) {
                    aVar.ni(5, this.NrG.computeSize());
                    this.NrG.writeFields(aVar);
                }
                aVar.aM(6, this.NrH);
                aVar.aM(7, this.NrI);
                aVar.aM(8, this.NrJ);
                aVar.aM(9, this.NrK);
                if (this.NrL != null) {
                    aVar.ni(10, this.NrL.computeSize());
                    this.NrL.writeFields(aVar);
                }
                aVar.aM(11, this.NrM);
                if (this.NrN != null) {
                    aVar.ni(12, this.NrN.computeSize());
                    this.NrN.writeFields(aVar);
                }
                aVar.aM(13, this.NrO);
                aVar.aM(14, this.NrP);
                aVar.aM(15, this.NrQ);
                aVar.aM(16, this.NrR);
                aVar.aM(17, this.NrS);
                aVar.aM(18, this.yqc);
                aVar.aM(19, this.NrT);
                if (this.NrU != null) {
                    aVar.ni(20, this.NrU.computeSize());
                    this.NrU.writeFields(aVar);
                }
                if (this.NrV != null) {
                    aVar.ni(21, this.NrV.computeSize());
                    this.NrV.writeFields(aVar);
                }
                aVar.aM(22, this.NrW);
                if (this.NrX != null) {
                    aVar.ni(23, this.NrX.computeSize());
                    this.NrX.writeFields(aVar);
                }
                aVar.aM(24, this.NrY);
                aVar.aM(25, this.NrZ);
                aVar.aM(26, this.Nsa);
                if (this.Nsb != null) {
                    aVar.ni(27, this.Nsb.computeSize());
                    this.Nsb.writeFields(aVar);
                }
                if (this.Nsc != null) {
                    aVar.ni(28, this.Nsc.computeSize());
                    this.Nsc.writeFields(aVar);
                }
                aVar.aM(29, this.Nsd);
                if (this.Nse != null) {
                    aVar.e(30, this.Nse);
                }
                aVar.aM(31, this.Nsf);
                aVar.e(32, 8, this.Nsg);
                if (this.Nrx != null) {
                    aVar.ni(33, this.Nrx.computeSize());
                    this.Nrx.writeFields(aVar);
                }
                if (this.Nry != null) {
                    aVar.ni(34, this.Nry.computeSize());
                    this.Nry.writeFields(aVar);
                }
                if (this.Nsh != null) {
                    aVar.ni(35, this.Nsh.computeSize());
                    this.Nsh.writeFields(aVar);
                }
                AppMethodBeat.o(115900);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.NpJ != null ? g.a.a.a.nh(1, this.NpJ.computeSize()) + 0 : 0;
            if (this.NpK != null) {
                nh += g.a.a.a.nh(2, this.NpK.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.NrE);
            if (this.NrF != null) {
                bu += g.a.a.a.nh(4, this.NrF.computeSize());
            }
            if (this.NrG != null) {
                bu += g.a.a.a.nh(5, this.NrG.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.NrH) + g.a.a.b.b.a.bu(7, this.NrI) + g.a.a.b.b.a.bu(8, this.NrJ) + g.a.a.b.b.a.bu(9, this.NrK);
            if (this.NrL != null) {
                bu2 += g.a.a.a.nh(10, this.NrL.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(11, this.NrM);
            if (this.NrN != null) {
                bu3 += g.a.a.a.nh(12, this.NrN.computeSize());
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(13, this.NrO) + g.a.a.b.b.a.bu(14, this.NrP) + g.a.a.b.b.a.bu(15, this.NrQ) + g.a.a.b.b.a.bu(16, this.NrR) + g.a.a.b.b.a.bu(17, this.NrS) + g.a.a.b.b.a.bu(18, this.yqc) + g.a.a.b.b.a.bu(19, this.NrT);
            if (this.NrU != null) {
                bu4 += g.a.a.a.nh(20, this.NrU.computeSize());
            }
            if (this.NrV != null) {
                bu4 += g.a.a.a.nh(21, this.NrV.computeSize());
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(22, this.NrW);
            if (this.NrX != null) {
                bu5 += g.a.a.a.nh(23, this.NrX.computeSize());
            }
            int bu6 = bu5 + g.a.a.b.b.a.bu(24, this.NrY) + g.a.a.b.b.a.bu(25, this.NrZ) + g.a.a.b.b.a.bu(26, this.Nsa);
            if (this.Nsb != null) {
                bu6 += g.a.a.a.nh(27, this.Nsb.computeSize());
            }
            if (this.Nsc != null) {
                bu6 += g.a.a.a.nh(28, this.Nsc.computeSize());
            }
            int bu7 = bu6 + g.a.a.b.b.a.bu(29, this.Nsd);
            if (this.Nse != null) {
                bu7 += g.a.a.b.b.a.f(30, this.Nse);
            }
            int bu8 = bu7 + g.a.a.b.b.a.bu(31, this.Nsf) + g.a.a.a.c(32, 8, this.Nsg);
            if (this.Nrx != null) {
                bu8 += g.a.a.a.nh(33, this.Nrx.computeSize());
            }
            if (this.Nry != null) {
                bu8 += g.a.a.a.nh(34, this.Nry.computeSize());
            }
            if (this.Nsh != null) {
                bu8 += g.a.a.a.nh(35, this.Nsh.computeSize());
            }
            AppMethodBeat.o(115900);
            return bu8;
        } else if (i2 == 2) {
            this.Nsg.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.NpJ == null) {
                b bVar3 = new b("Not all required fields were included: PeerId");
                AppMethodBeat.o(115900);
                throw bVar3;
            } else if (this.NpK == null) {
                b bVar4 = new b("Not all required fields were included: CapInfo");
                AppMethodBeat.o(115900);
                throw bVar4;
            } else {
                AppMethodBeat.o(115900);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eue eue = (eue) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        euk euk = new euk();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = euk.populateBuilderWithField(aVar4, euk, a.getNextFieldNumber(aVar4))) {
                        }
                        eue.NpJ = euk;
                    }
                    AppMethodBeat.o(115900);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        euk euk2 = new euk();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = euk2.populateBuilderWithField(aVar5, euk2, a.getNextFieldNumber(aVar5))) {
                        }
                        eue.NpK = euk2;
                    }
                    AppMethodBeat.o(115900);
                    return 0;
                case 3:
                    eue.NrE = aVar3.UbS.zi();
                    AppMethodBeat.o(115900);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        esr esr = new esr();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = esr.populateBuilderWithField(aVar6, esr, a.getNextFieldNumber(aVar6))) {
                        }
                        eue.NrF = esr;
                    }
                    AppMethodBeat.o(115900);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        esr esr2 = new esr();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = esr2.populateBuilderWithField(aVar7, esr2, a.getNextFieldNumber(aVar7))) {
                        }
                        eue.NrG = esr2;
                    }
                    AppMethodBeat.o(115900);
                    return 0;
                case 6:
                    eue.NrH = aVar3.UbS.zi();
                    AppMethodBeat.o(115900);
                    return 0;
                case 7:
                    eue.NrI = aVar3.UbS.zi();
                    AppMethodBeat.o(115900);
                    return 0;
                case 8:
                    eue.NrJ = aVar3.UbS.zi();
                    AppMethodBeat.o(115900);
                    return 0;
                case 9:
                    eue.NrK = aVar3.UbS.zi();
                    AppMethodBeat.o(115900);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = sKBuiltinBuffer_t.populateBuilderWithField(aVar8, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar8))) {
                        }
                        eue.NrL = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(115900);
                    return 0;
                case 11:
                    eue.NrM = aVar3.UbS.zi();
                    AppMethodBeat.o(115900);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        esr esr3 = new esr();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = esr3.populateBuilderWithField(aVar9, esr3, a.getNextFieldNumber(aVar9))) {
                        }
                        eue.NrN = esr3;
                    }
                    AppMethodBeat.o(115900);
                    return 0;
                case 13:
                    eue.NrO = aVar3.UbS.zi();
                    AppMethodBeat.o(115900);
                    return 0;
                case 14:
                    eue.NrP = aVar3.UbS.zi();
                    AppMethodBeat.o(115900);
                    return 0;
                case 15:
                    eue.NrQ = aVar3.UbS.zi();
                    AppMethodBeat.o(115900);
                    return 0;
                case 16:
                    eue.NrR = aVar3.UbS.zi();
                    AppMethodBeat.o(115900);
                    return 0;
                case 17:
                    eue.NrS = aVar3.UbS.zi();
                    AppMethodBeat.o(115900);
                    return 0;
                case 18:
                    eue.yqc = aVar3.UbS.zi();
                    AppMethodBeat.o(115900);
                    return 0;
                case 19:
                    eue.NrT = aVar3.UbS.zi();
                    AppMethodBeat.o(115900);
                    return 0;
                case 20:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar10, sKBuiltinBuffer_t2, a.getNextFieldNumber(aVar10))) {
                        }
                        eue.NrU = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(115900);
                    return 0;
                case 21:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t3 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = sKBuiltinBuffer_t3.populateBuilderWithField(aVar11, sKBuiltinBuffer_t3, a.getNextFieldNumber(aVar11))) {
                        }
                        eue.NrV = sKBuiltinBuffer_t3;
                    }
                    AppMethodBeat.o(115900);
                    return 0;
                case 22:
                    eue.NrW = aVar3.UbS.zi();
                    AppMethodBeat.o(115900);
                    return 0;
                case 23:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t4 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = sKBuiltinBuffer_t4.populateBuilderWithField(aVar12, sKBuiltinBuffer_t4, a.getNextFieldNumber(aVar12))) {
                        }
                        eue.NrX = sKBuiltinBuffer_t4;
                    }
                    AppMethodBeat.o(115900);
                    return 0;
                case 24:
                    eue.NrY = aVar3.UbS.zi();
                    AppMethodBeat.o(115900);
                    return 0;
                case 25:
                    eue.NrZ = aVar3.UbS.zi();
                    AppMethodBeat.o(115900);
                    return 0;
                case 26:
                    eue.Nsa = aVar3.UbS.zi();
                    AppMethodBeat.o(115900);
                    return 0;
                case 27:
                    LinkedList<byte[]> awh10 = aVar3.awh(intValue);
                    int size10 = awh10.size();
                    for (int i12 = 0; i12 < size10; i12++) {
                        cez cez = new cez();
                        g.a.a.a.a aVar13 = new g.a.a.a.a(awh10.get(i12), unknownTagHandler);
                        for (boolean z10 = true; z10; z10 = cez.populateBuilderWithField(aVar13, cez, a.getNextFieldNumber(aVar13))) {
                        }
                        eue.Nsb = cez;
                    }
                    AppMethodBeat.o(115900);
                    return 0;
                case 28:
                    LinkedList<byte[]> awh11 = aVar3.awh(intValue);
                    int size11 = awh11.size();
                    for (int i13 = 0; i13 < size11; i13++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t5 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar14 = new g.a.a.a.a(awh11.get(i13), unknownTagHandler);
                        for (boolean z11 = true; z11; z11 = sKBuiltinBuffer_t5.populateBuilderWithField(aVar14, sKBuiltinBuffer_t5, a.getNextFieldNumber(aVar14))) {
                        }
                        eue.Nsc = sKBuiltinBuffer_t5;
                    }
                    AppMethodBeat.o(115900);
                    return 0;
                case 29:
                    eue.Nsd = aVar3.UbS.zi();
                    AppMethodBeat.o(115900);
                    return 0;
                case 30:
                    eue.Nse = aVar3.UbS.readString();
                    AppMethodBeat.o(115900);
                    return 0;
                case 31:
                    eue.Nsf = aVar3.UbS.zi();
                    AppMethodBeat.o(115900);
                    return 0;
                case 32:
                    LinkedList<byte[]> awh12 = aVar3.awh(intValue);
                    int size12 = awh12.size();
                    for (int i14 = 0; i14 < size12; i14++) {
                        euf euf = new euf();
                        g.a.a.a.a aVar15 = new g.a.a.a.a(awh12.get(i14), unknownTagHandler);
                        for (boolean z12 = true; z12; z12 = euf.populateBuilderWithField(aVar15, euf, a.getNextFieldNumber(aVar15))) {
                        }
                        eue.Nsg.add(euf);
                    }
                    AppMethodBeat.o(115900);
                    return 0;
                case 33:
                    LinkedList<byte[]> awh13 = aVar3.awh(intValue);
                    int size13 = awh13.size();
                    for (int i15 = 0; i15 < size13; i15++) {
                        dmm dmm = new dmm();
                        g.a.a.a.a aVar16 = new g.a.a.a.a(awh13.get(i15), unknownTagHandler);
                        for (boolean z13 = true; z13; z13 = dmm.populateBuilderWithField(aVar16, dmm, a.getNextFieldNumber(aVar16))) {
                        }
                        eue.Nrx = dmm;
                    }
                    AppMethodBeat.o(115900);
                    return 0;
                case 34:
                    LinkedList<byte[]> awh14 = aVar3.awh(intValue);
                    int size14 = awh14.size();
                    for (int i16 = 0; i16 < size14; i16++) {
                        ahk ahk = new ahk();
                        g.a.a.a.a aVar17 = new g.a.a.a.a(awh14.get(i16), unknownTagHandler);
                        for (boolean z14 = true; z14; z14 = ahk.populateBuilderWithField(aVar17, ahk, a.getNextFieldNumber(aVar17))) {
                        }
                        eue.Nry = ahk;
                    }
                    AppMethodBeat.o(115900);
                    return 0;
                case 35:
                    LinkedList<byte[]> awh15 = aVar3.awh(intValue);
                    int size15 = awh15.size();
                    for (int i17 = 0; i17 < size15; i17++) {
                        bqy bqy = new bqy();
                        g.a.a.a.a aVar18 = new g.a.a.a.a(awh15.get(i17), unknownTagHandler);
                        for (boolean z15 = true; z15; z15 = bqy.populateBuilderWithField(aVar18, bqy, a.getNextFieldNumber(aVar18))) {
                        }
                        eue.Nsh = bqy;
                    }
                    AppMethodBeat.o(115900);
                    return 0;
                default:
                    AppMethodBeat.o(115900);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115900);
            return -1;
        }
    }
}
