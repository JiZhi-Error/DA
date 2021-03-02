package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bk extends dpc {
    public g xIz;
    public cc xLA;
    public String xLr;
    public LinkedList<ae> xLs = new LinkedList<>();
    public cs xLt;
    public ch xLu;
    public ce xLv;
    public dm xLw;
    public LinkedList<af> xLx = new LinkedList<>();
    public dr xLy;
    public cg xLz;

    public bk() {
        AppMethodBeat.i(41760);
        AppMethodBeat.o(41760);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41761);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(41761);
                throw bVar;
            } else if (this.xIz == null) {
                b bVar2 = new b("Not all required fields were included: AppItem");
                AppMethodBeat.o(41761);
                throw bVar2;
            } else if (this.xLr == null) {
                b bVar3 = new b("Not all required fields were included: BackGroundURL");
                AppMethodBeat.o(41761);
                throw bVar3;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.xIz != null) {
                    aVar.ni(2, this.xIz.computeSize());
                    this.xIz.writeFields(aVar);
                }
                if (this.xLr != null) {
                    aVar.e(3, this.xLr);
                }
                aVar.e(4, 8, this.xLs);
                if (this.xLt != null) {
                    aVar.ni(5, this.xLt.computeSize());
                    this.xLt.writeFields(aVar);
                }
                if (this.xLu != null) {
                    aVar.ni(7, this.xLu.computeSize());
                    this.xLu.writeFields(aVar);
                }
                if (this.xLv != null) {
                    aVar.ni(8, this.xLv.computeSize());
                    this.xLv.writeFields(aVar);
                }
                if (this.xLw != null) {
                    aVar.ni(9, this.xLw.computeSize());
                    this.xLw.writeFields(aVar);
                }
                aVar.e(10, 8, this.xLx);
                if (this.xLy != null) {
                    aVar.ni(11, this.xLy.computeSize());
                    this.xLy.writeFields(aVar);
                }
                if (this.xLz != null) {
                    aVar.ni(12, this.xLz.computeSize());
                    this.xLz.writeFields(aVar);
                }
                if (this.xLA != null) {
                    aVar.ni(13, this.xLA.computeSize());
                    this.xLA.writeFields(aVar);
                }
                AppMethodBeat.o(41761);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.xIz != null) {
                nh += g.a.a.a.nh(2, this.xIz.computeSize());
            }
            if (this.xLr != null) {
                nh += g.a.a.b.b.a.f(3, this.xLr);
            }
            int c2 = nh + g.a.a.a.c(4, 8, this.xLs);
            if (this.xLt != null) {
                c2 += g.a.a.a.nh(5, this.xLt.computeSize());
            }
            if (this.xLu != null) {
                c2 += g.a.a.a.nh(7, this.xLu.computeSize());
            }
            if (this.xLv != null) {
                c2 += g.a.a.a.nh(8, this.xLv.computeSize());
            }
            if (this.xLw != null) {
                c2 += g.a.a.a.nh(9, this.xLw.computeSize());
            }
            int c3 = c2 + g.a.a.a.c(10, 8, this.xLx);
            if (this.xLy != null) {
                c3 += g.a.a.a.nh(11, this.xLy.computeSize());
            }
            if (this.xLz != null) {
                c3 += g.a.a.a.nh(12, this.xLz.computeSize());
            }
            if (this.xLA != null) {
                c3 += g.a.a.a.nh(13, this.xLA.computeSize());
            }
            AppMethodBeat.o(41761);
            return c3;
        } else if (i2 == 2) {
            this.xLs.clear();
            this.xLx.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar4 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(41761);
                throw bVar4;
            } else if (this.xIz == null) {
                b bVar5 = new b("Not all required fields were included: AppItem");
                AppMethodBeat.o(41761);
                throw bVar5;
            } else if (this.xLr == null) {
                b bVar6 = new b("Not all required fields were included: BackGroundURL");
                AppMethodBeat.o(41761);
                throw bVar6;
            } else {
                AppMethodBeat.o(41761);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bk bkVar = (bk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        BaseResponse baseResponse = new BaseResponse();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, dpc.getNextFieldNumber(aVar4))) {
                        }
                        bkVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(41761);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        g gVar = new g();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = gVar.populateBuilderWithField(aVar5, gVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bkVar.xIz = gVar;
                    }
                    AppMethodBeat.o(41761);
                    return 0;
                case 3:
                    bkVar.xLr = aVar3.UbS.readString();
                    AppMethodBeat.o(41761);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ae aeVar = new ae();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = aeVar.populateBuilderWithField(aVar6, aeVar, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bkVar.xLs.add(aeVar);
                    }
                    AppMethodBeat.o(41761);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        cs csVar = new cs();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = csVar.populateBuilderWithField(aVar7, csVar, dpc.getNextFieldNumber(aVar7))) {
                        }
                        bkVar.xLt = csVar;
                    }
                    AppMethodBeat.o(41761);
                    return 0;
                case 6:
                default:
                    AppMethodBeat.o(41761);
                    return -1;
                case 7:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        ch chVar = new ch();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = chVar.populateBuilderWithField(aVar8, chVar, dpc.getNextFieldNumber(aVar8))) {
                        }
                        bkVar.xLu = chVar;
                    }
                    AppMethodBeat.o(41761);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        ce ceVar = new ce();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = ceVar.populateBuilderWithField(aVar9, ceVar, dpc.getNextFieldNumber(aVar9))) {
                        }
                        bkVar.xLv = ceVar;
                    }
                    AppMethodBeat.o(41761);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        dm dmVar = new dm();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = dmVar.populateBuilderWithField(aVar10, dmVar, dpc.getNextFieldNumber(aVar10))) {
                        }
                        bkVar.xLw = dmVar;
                    }
                    AppMethodBeat.o(41761);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        af afVar = new af();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = afVar.populateBuilderWithField(aVar11, afVar, dpc.getNextFieldNumber(aVar11))) {
                        }
                        bkVar.xLx.add(afVar);
                    }
                    AppMethodBeat.o(41761);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        dr drVar = new dr();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = drVar.populateBuilderWithField(aVar12, drVar, dpc.getNextFieldNumber(aVar12))) {
                        }
                        bkVar.xLy = drVar;
                    }
                    AppMethodBeat.o(41761);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh10 = aVar3.awh(intValue);
                    int size10 = awh10.size();
                    for (int i12 = 0; i12 < size10; i12++) {
                        cg cgVar = new cg();
                        g.a.a.a.a aVar13 = new g.a.a.a.a(awh10.get(i12), unknownTagHandler);
                        for (boolean z10 = true; z10; z10 = cgVar.populateBuilderWithField(aVar13, cgVar, dpc.getNextFieldNumber(aVar13))) {
                        }
                        bkVar.xLz = cgVar;
                    }
                    AppMethodBeat.o(41761);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh11 = aVar3.awh(intValue);
                    int size11 = awh11.size();
                    for (int i13 = 0; i13 < size11; i13++) {
                        cc ccVar = new cc();
                        g.a.a.a.a aVar14 = new g.a.a.a.a(awh11.get(i13), unknownTagHandler);
                        for (boolean z11 = true; z11; z11 = ccVar.populateBuilderWithField(aVar14, ccVar, dpc.getNextFieldNumber(aVar14))) {
                        }
                        bkVar.xLA = ccVar;
                    }
                    AppMethodBeat.o(41761);
                    return 0;
            }
        } else {
            AppMethodBeat.o(41761);
            return -1;
        }
    }
}
