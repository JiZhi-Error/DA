package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bhi extends dop {
    public int KHa;
    public int KJS;
    public String KLR;
    public SKBuiltinBuffer_t KLh;
    public int KMd;
    public SKBuiltinBuffer_t LRA;
    public int LRB;
    public String LRC;
    public int LRD;
    public SKBuiltinBuffer_t LRE;
    public String LRF;
    public String LRG;
    public String LRa;
    public String LRb;
    public int LRd;
    public String LRe;
    public dqi LRu;
    public dqi LRv;
    public dqi LRw;
    public dqi LRx;
    public String LRy;
    public int LRz;
    public int Ljb;
    public int Ljc;
    public int OpCode;
    public int Scene;
    public String UserName;
    public String pLm;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152552);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.OpCode);
            if (this.KLh != null) {
                aVar.ni(3, this.KLh.computeSize());
                this.KLh.writeFields(aVar);
            }
            if (this.LRu != null) {
                aVar.ni(4, this.LRu.computeSize());
                this.LRu.writeFields(aVar);
            }
            if (this.LRv != null) {
                aVar.ni(5, this.LRv.computeSize());
                this.LRv.writeFields(aVar);
            }
            if (this.LRw != null) {
                aVar.ni(6, this.LRw.computeSize());
                this.LRw.writeFields(aVar);
            }
            if (this.LRx != null) {
                aVar.ni(7, this.LRx.computeSize());
                this.LRx.writeFields(aVar);
            }
            if (this.LRy != null) {
                aVar.e(8, this.LRy);
            }
            aVar.aM(9, this.LRz);
            aVar.aM(10, this.Scene);
            if (this.UserName != null) {
                aVar.e(11, this.UserName);
            }
            if (this.KLR != null) {
                aVar.e(12, this.KLR);
            }
            if (this.LRA != null) {
                aVar.ni(13, this.LRA.computeSize());
                this.LRA.writeFields(aVar);
            }
            aVar.aM(14, this.KMd);
            aVar.aM(15, this.LRd);
            aVar.aM(16, this.KHa);
            if (this.pLm != null) {
                aVar.e(17, this.pLm);
            }
            aVar.aM(18, this.Ljb);
            aVar.aM(19, this.Ljc);
            aVar.aM(20, this.LRB);
            if (this.LRC != null) {
                aVar.e(21, this.LRC);
            }
            aVar.aM(22, this.LRD);
            if (this.LRE != null) {
                aVar.ni(23, this.LRE.computeSize());
                this.LRE.writeFields(aVar);
            }
            if (this.LRe != null) {
                aVar.e(24, this.LRe);
            }
            aVar.aM(25, this.KJS);
            if (this.LRa != null) {
                aVar.e(26, this.LRa);
            }
            if (this.LRb != null) {
                aVar.e(27, this.LRb);
            }
            if (this.LRF != null) {
                aVar.e(28, this.LRF);
            }
            if (this.LRG != null) {
                aVar.e(29, this.LRG);
            }
            AppMethodBeat.o(152552);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.OpCode);
            if (this.KLh != null) {
                nh += g.a.a.a.nh(3, this.KLh.computeSize());
            }
            if (this.LRu != null) {
                nh += g.a.a.a.nh(4, this.LRu.computeSize());
            }
            if (this.LRv != null) {
                nh += g.a.a.a.nh(5, this.LRv.computeSize());
            }
            if (this.LRw != null) {
                nh += g.a.a.a.nh(6, this.LRw.computeSize());
            }
            if (this.LRx != null) {
                nh += g.a.a.a.nh(7, this.LRx.computeSize());
            }
            if (this.LRy != null) {
                nh += g.a.a.b.b.a.f(8, this.LRy);
            }
            int bu = nh + g.a.a.b.b.a.bu(9, this.LRz) + g.a.a.b.b.a.bu(10, this.Scene);
            if (this.UserName != null) {
                bu += g.a.a.b.b.a.f(11, this.UserName);
            }
            if (this.KLR != null) {
                bu += g.a.a.b.b.a.f(12, this.KLR);
            }
            if (this.LRA != null) {
                bu += g.a.a.a.nh(13, this.LRA.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(14, this.KMd) + g.a.a.b.b.a.bu(15, this.LRd) + g.a.a.b.b.a.bu(16, this.KHa);
            if (this.pLm != null) {
                bu2 += g.a.a.b.b.a.f(17, this.pLm);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(18, this.Ljb) + g.a.a.b.b.a.bu(19, this.Ljc) + g.a.a.b.b.a.bu(20, this.LRB);
            if (this.LRC != null) {
                bu3 += g.a.a.b.b.a.f(21, this.LRC);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(22, this.LRD);
            if (this.LRE != null) {
                bu4 += g.a.a.a.nh(23, this.LRE.computeSize());
            }
            if (this.LRe != null) {
                bu4 += g.a.a.b.b.a.f(24, this.LRe);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(25, this.KJS);
            if (this.LRa != null) {
                bu5 += g.a.a.b.b.a.f(26, this.LRa);
            }
            if (this.LRb != null) {
                bu5 += g.a.a.b.b.a.f(27, this.LRb);
            }
            if (this.LRF != null) {
                bu5 += g.a.a.b.b.a.f(28, this.LRF);
            }
            if (this.LRG != null) {
                bu5 += g.a.a.b.b.a.f(29, this.LRG);
            }
            AppMethodBeat.o(152552);
            return bu5;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152552);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bhi bhi = (bhi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        bhi.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(152552);
                    return 0;
                case 2:
                    bhi.OpCode = aVar3.UbS.zi();
                    AppMethodBeat.o(152552);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        bhi.KLh = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(152552);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi.populateBuilderWithField(aVar6, dqi, dop.getNextFieldNumber(aVar6))) {
                        }
                        bhi.LRu = dqi;
                    }
                    AppMethodBeat.o(152552);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dqi2.populateBuilderWithField(aVar7, dqi2, dop.getNextFieldNumber(aVar7))) {
                        }
                        bhi.LRv = dqi2;
                    }
                    AppMethodBeat.o(152552);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        dqi dqi3 = new dqi();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = dqi3.populateBuilderWithField(aVar8, dqi3, dop.getNextFieldNumber(aVar8))) {
                        }
                        bhi.LRw = dqi3;
                    }
                    AppMethodBeat.o(152552);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        dqi dqi4 = new dqi();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = dqi4.populateBuilderWithField(aVar9, dqi4, dop.getNextFieldNumber(aVar9))) {
                        }
                        bhi.LRx = dqi4;
                    }
                    AppMethodBeat.o(152552);
                    return 0;
                case 8:
                    bhi.LRy = aVar3.UbS.readString();
                    AppMethodBeat.o(152552);
                    return 0;
                case 9:
                    bhi.LRz = aVar3.UbS.zi();
                    AppMethodBeat.o(152552);
                    return 0;
                case 10:
                    bhi.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(152552);
                    return 0;
                case 11:
                    bhi.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(152552);
                    return 0;
                case 12:
                    bhi.KLR = aVar3.UbS.readString();
                    AppMethodBeat.o(152552);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar10, sKBuiltinBuffer_t2, dop.getNextFieldNumber(aVar10))) {
                        }
                        bhi.LRA = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(152552);
                    return 0;
                case 14:
                    bhi.KMd = aVar3.UbS.zi();
                    AppMethodBeat.o(152552);
                    return 0;
                case 15:
                    bhi.LRd = aVar3.UbS.zi();
                    AppMethodBeat.o(152552);
                    return 0;
                case 16:
                    bhi.KHa = aVar3.UbS.zi();
                    AppMethodBeat.o(152552);
                    return 0;
                case 17:
                    bhi.pLm = aVar3.UbS.readString();
                    AppMethodBeat.o(152552);
                    return 0;
                case 18:
                    bhi.Ljb = aVar3.UbS.zi();
                    AppMethodBeat.o(152552);
                    return 0;
                case 19:
                    bhi.Ljc = aVar3.UbS.zi();
                    AppMethodBeat.o(152552);
                    return 0;
                case 20:
                    bhi.LRB = aVar3.UbS.zi();
                    AppMethodBeat.o(152552);
                    return 0;
                case 21:
                    bhi.LRC = aVar3.UbS.readString();
                    AppMethodBeat.o(152552);
                    return 0;
                case 22:
                    bhi.LRD = aVar3.UbS.zi();
                    AppMethodBeat.o(152552);
                    return 0;
                case 23:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t3 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = sKBuiltinBuffer_t3.populateBuilderWithField(aVar11, sKBuiltinBuffer_t3, dop.getNextFieldNumber(aVar11))) {
                        }
                        bhi.LRE = sKBuiltinBuffer_t3;
                    }
                    AppMethodBeat.o(152552);
                    return 0;
                case 24:
                    bhi.LRe = aVar3.UbS.readString();
                    AppMethodBeat.o(152552);
                    return 0;
                case 25:
                    bhi.KJS = aVar3.UbS.zi();
                    AppMethodBeat.o(152552);
                    return 0;
                case 26:
                    bhi.LRa = aVar3.UbS.readString();
                    AppMethodBeat.o(152552);
                    return 0;
                case 27:
                    bhi.LRb = aVar3.UbS.readString();
                    AppMethodBeat.o(152552);
                    return 0;
                case 28:
                    bhi.LRF = aVar3.UbS.readString();
                    AppMethodBeat.o(152552);
                    return 0;
                case 29:
                    bhi.LRG = aVar3.UbS.readString();
                    AppMethodBeat.o(152552);
                    return 0;
                default:
                    AppMethodBeat.o(152552);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152552);
            return -1;
        }
    }
}
