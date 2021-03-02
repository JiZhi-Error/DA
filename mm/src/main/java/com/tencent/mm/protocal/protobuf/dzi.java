package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dzi extends a {
    public int CreateTime;
    public int IsNotRichText;
    public dmo KHJ;
    public String LsY;
    public String MKC;
    public String MYQ;
    public String MYR;
    public int MYS;
    public int MYT;
    public long MYU;
    public long MYV;
    public SKBuiltinBuffer_t MYW;
    public int MYX;
    public LinkedList<dzu> MYY = new LinkedList<>();
    public int MYZ;
    public String iAc;
    public int oUv;
    public int xub;

    public dzi() {
        AppMethodBeat.i(125770);
        AppMethodBeat.o(125770);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125771);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MKC != null) {
                aVar.e(1, this.MKC);
            }
            if (this.LsY != null) {
                aVar.e(2, this.LsY);
            }
            if (this.MYQ != null) {
                aVar.e(3, this.MYQ);
            }
            if (this.MYR != null) {
                aVar.e(4, this.MYR);
            }
            aVar.aM(5, this.oUv);
            aVar.aM(6, this.xub);
            aVar.aM(7, this.CreateTime);
            if (this.iAc != null) {
                aVar.e(8, this.iAc);
            }
            aVar.aM(9, this.MYS);
            aVar.aM(10, this.MYT);
            aVar.aM(11, this.IsNotRichText);
            aVar.bb(12, this.MYU);
            aVar.bb(13, this.MYV);
            if (this.MYW != null) {
                aVar.ni(14, this.MYW.computeSize());
                this.MYW.writeFields(aVar);
            }
            aVar.aM(15, this.MYX);
            if (this.KHJ != null) {
                aVar.ni(16, this.KHJ.computeSize());
                this.KHJ.writeFields(aVar);
            }
            aVar.e(17, 8, this.MYY);
            aVar.aM(18, this.MYZ);
            AppMethodBeat.o(125771);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MKC != null ? g.a.a.b.b.a.f(1, this.MKC) + 0 : 0;
            if (this.LsY != null) {
                f2 += g.a.a.b.b.a.f(2, this.LsY);
            }
            if (this.MYQ != null) {
                f2 += g.a.a.b.b.a.f(3, this.MYQ);
            }
            if (this.MYR != null) {
                f2 += g.a.a.b.b.a.f(4, this.MYR);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.oUv) + g.a.a.b.b.a.bu(6, this.xub) + g.a.a.b.b.a.bu(7, this.CreateTime);
            if (this.iAc != null) {
                bu += g.a.a.b.b.a.f(8, this.iAc);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(9, this.MYS) + g.a.a.b.b.a.bu(10, this.MYT) + g.a.a.b.b.a.bu(11, this.IsNotRichText) + g.a.a.b.b.a.r(12, this.MYU) + g.a.a.b.b.a.r(13, this.MYV);
            if (this.MYW != null) {
                bu2 += g.a.a.a.nh(14, this.MYW.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(15, this.MYX);
            if (this.KHJ != null) {
                bu3 += g.a.a.a.nh(16, this.KHJ.computeSize());
            }
            int c2 = bu3 + g.a.a.a.c(17, 8, this.MYY) + g.a.a.b.b.a.bu(18, this.MYZ);
            AppMethodBeat.o(125771);
            return c2;
        } else if (i2 == 2) {
            this.MYY.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125771);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dzi dzi = (dzi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dzi.MKC = aVar3.UbS.readString();
                    AppMethodBeat.o(125771);
                    return 0;
                case 2:
                    dzi.LsY = aVar3.UbS.readString();
                    AppMethodBeat.o(125771);
                    return 0;
                case 3:
                    dzi.MYQ = aVar3.UbS.readString();
                    AppMethodBeat.o(125771);
                    return 0;
                case 4:
                    dzi.MYR = aVar3.UbS.readString();
                    AppMethodBeat.o(125771);
                    return 0;
                case 5:
                    dzi.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(125771);
                    return 0;
                case 6:
                    dzi.xub = aVar3.UbS.zi();
                    AppMethodBeat.o(125771);
                    return 0;
                case 7:
                    dzi.CreateTime = aVar3.UbS.zi();
                    AppMethodBeat.o(125771);
                    return 0;
                case 8:
                    dzi.iAc = aVar3.UbS.readString();
                    AppMethodBeat.o(125771);
                    return 0;
                case 9:
                    dzi.MYS = aVar3.UbS.zi();
                    AppMethodBeat.o(125771);
                    return 0;
                case 10:
                    dzi.MYT = aVar3.UbS.zi();
                    AppMethodBeat.o(125771);
                    return 0;
                case 11:
                    dzi.IsNotRichText = aVar3.UbS.zi();
                    AppMethodBeat.o(125771);
                    return 0;
                case 12:
                    dzi.MYU = aVar3.UbS.zl();
                    AppMethodBeat.o(125771);
                    return 0;
                case 13:
                    dzi.MYV = aVar3.UbS.zl();
                    AppMethodBeat.o(125771);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        dzi.MYW = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(125771);
                    return 0;
                case 15:
                    dzi.MYX = aVar3.UbS.zi();
                    AppMethodBeat.o(125771);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dmo dmo = new dmo();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dmo.populateBuilderWithField(aVar5, dmo, a.getNextFieldNumber(aVar5))) {
                        }
                        dzi.KHJ = dmo;
                    }
                    AppMethodBeat.o(125771);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dzu dzu = new dzu();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dzu.populateBuilderWithField(aVar6, dzu, a.getNextFieldNumber(aVar6))) {
                        }
                        dzi.MYY.add(dzu);
                    }
                    AppMethodBeat.o(125771);
                    return 0;
                case 18:
                    dzi.MYZ = aVar3.UbS.zi();
                    AppMethodBeat.o(125771);
                    return 0;
                default:
                    AppMethodBeat.o(125771);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125771);
            return -1;
        }
    }
}
