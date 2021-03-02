package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class nb extends dop {
    public int KND;
    public long KRC;
    public String KRD;
    public String KRE;
    public nd KRG;
    public String KRH;
    public String KRI;
    public int KRJ;
    public int KRK;
    public b KRc;
    public long KRi;
    public GoodsObject KRl;
    public mu KRo;
    public int mode;
    public int type;
    public String xve;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212229);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.KRc != null) {
                aVar.c(2, this.KRc);
            }
            aVar.aM(11, this.type);
            aVar.aM(12, this.mode);
            aVar.bb(18, this.KRi);
            if (this.KRl != null) {
                aVar.ni(21, this.KRl.computeSize());
                this.KRl.writeFields(aVar);
            }
            aVar.aM(22, this.KND);
            if (this.KRG != null) {
                aVar.ni(23, this.KRG.computeSize());
                this.KRG.writeFields(aVar);
            }
            if (this.KRo != null) {
                aVar.ni(26, this.KRo.computeSize());
                this.KRo.writeFields(aVar);
            }
            aVar.bb(27, this.KRC);
            if (this.KRD != null) {
                aVar.e(28, this.KRD);
            }
            if (this.KRE != null) {
                aVar.e(29, this.KRE);
            }
            if (this.xve != null) {
                aVar.e(30, this.xve);
            }
            if (this.KRH != null) {
                aVar.e(31, this.KRH);
            }
            if (this.KRI != null) {
                aVar.e(32, this.KRI);
            }
            aVar.aM(33, this.KRJ);
            aVar.aM(34, this.KRK);
            AppMethodBeat.o(212229);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KRc != null) {
                nh += g.a.a.b.b.a.b(2, this.KRc);
            }
            int bu = nh + g.a.a.b.b.a.bu(11, this.type) + g.a.a.b.b.a.bu(12, this.mode) + g.a.a.b.b.a.r(18, this.KRi);
            if (this.KRl != null) {
                bu += g.a.a.a.nh(21, this.KRl.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(22, this.KND);
            if (this.KRG != null) {
                bu2 += g.a.a.a.nh(23, this.KRG.computeSize());
            }
            if (this.KRo != null) {
                bu2 += g.a.a.a.nh(26, this.KRo.computeSize());
            }
            int r = bu2 + g.a.a.b.b.a.r(27, this.KRC);
            if (this.KRD != null) {
                r += g.a.a.b.b.a.f(28, this.KRD);
            }
            if (this.KRE != null) {
                r += g.a.a.b.b.a.f(29, this.KRE);
            }
            if (this.xve != null) {
                r += g.a.a.b.b.a.f(30, this.xve);
            }
            if (this.KRH != null) {
                r += g.a.a.b.b.a.f(31, this.KRH);
            }
            if (this.KRI != null) {
                r += g.a.a.b.b.a.f(32, this.KRI);
            }
            int bu3 = r + g.a.a.b.b.a.bu(33, this.KRJ) + g.a.a.b.b.a.bu(34, this.KRK);
            AppMethodBeat.o(212229);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212229);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            nb nbVar = (nb) objArr[1];
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
                        nbVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(212229);
                    return 0;
                case 2:
                    nbVar.KRc = aVar3.UbS.hPo();
                    AppMethodBeat.o(212229);
                    return 0;
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 19:
                case 20:
                case 24:
                case 25:
                default:
                    AppMethodBeat.o(212229);
                    return -1;
                case 11:
                    nbVar.type = aVar3.UbS.zi();
                    AppMethodBeat.o(212229);
                    return 0;
                case 12:
                    nbVar.mode = aVar3.UbS.zi();
                    AppMethodBeat.o(212229);
                    return 0;
                case 18:
                    nbVar.KRi = aVar3.UbS.zl();
                    AppMethodBeat.o(212229);
                    return 0;
                case 21:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        GoodsObject goodsObject = new GoodsObject();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = goodsObject.populateBuilderWithField(aVar5, goodsObject, dop.getNextFieldNumber(aVar5))) {
                        }
                        nbVar.KRl = goodsObject;
                    }
                    AppMethodBeat.o(212229);
                    return 0;
                case 22:
                    nbVar.KND = aVar3.UbS.zi();
                    AppMethodBeat.o(212229);
                    return 0;
                case 23:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        nd ndVar = new nd();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ndVar.populateBuilderWithField(aVar6, ndVar, dop.getNextFieldNumber(aVar6))) {
                        }
                        nbVar.KRG = ndVar;
                    }
                    AppMethodBeat.o(212229);
                    return 0;
                case 26:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        mu muVar = new mu();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = muVar.populateBuilderWithField(aVar7, muVar, dop.getNextFieldNumber(aVar7))) {
                        }
                        nbVar.KRo = muVar;
                    }
                    AppMethodBeat.o(212229);
                    return 0;
                case 27:
                    nbVar.KRC = aVar3.UbS.zl();
                    AppMethodBeat.o(212229);
                    return 0;
                case 28:
                    nbVar.KRD = aVar3.UbS.readString();
                    AppMethodBeat.o(212229);
                    return 0;
                case 29:
                    nbVar.KRE = aVar3.UbS.readString();
                    AppMethodBeat.o(212229);
                    return 0;
                case 30:
                    nbVar.xve = aVar3.UbS.readString();
                    AppMethodBeat.o(212229);
                    return 0;
                case 31:
                    nbVar.KRH = aVar3.UbS.readString();
                    AppMethodBeat.o(212229);
                    return 0;
                case 32:
                    nbVar.KRI = aVar3.UbS.readString();
                    AppMethodBeat.o(212229);
                    return 0;
                case 33:
                    nbVar.KRJ = aVar3.UbS.zi();
                    AppMethodBeat.o(212229);
                    return 0;
                case 34:
                    nbVar.KRK = aVar3.UbS.zi();
                    AppMethodBeat.o(212229);
                    return 0;
            }
        } else {
            AppMethodBeat.o(212229);
            return -1;
        }
    }
}
