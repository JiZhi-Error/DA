package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class awc extends dpc {
    public String LGA;
    public String LGB;
    public int LGC;
    public String LGD;
    public String LGE;
    public String LGF;
    public String LGG;
    public String LGH;
    public String LGI;
    public String LGw;
    public LinkedList<axg> LGy = new LinkedList<>();
    public String LGz;
    public LinkedList<fhe> Lhs = new LinkedList<>();
    public LinkedList<fhh> Vjd = new LinkedList<>();
    public int continueFlag;
    public int gAZ;
    public long liveId;
    public b tVM;
    public String ukr;
    public String vtD;

    public awc() {
        AppMethodBeat.i(209522);
        AppMethodBeat.o(209522);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209523);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.gAZ);
            aVar.e(3, 8, this.LGy);
            if (this.tVM != null) {
                aVar.c(4, this.tVM);
            }
            aVar.aM(5, this.continueFlag);
            if (this.LGz != null) {
                aVar.e(6, this.LGz);
            }
            if (this.LGA != null) {
                aVar.e(7, this.LGA);
            }
            if (this.LGB != null) {
                aVar.e(8, this.LGB);
            }
            aVar.aM(9, this.LGC);
            if (this.LGD != null) {
                aVar.e(10, this.LGD);
            }
            aVar.bb(11, this.liveId);
            if (this.LGE != null) {
                aVar.e(12, this.LGE);
            }
            if (this.LGF != null) {
                aVar.e(13, this.LGF);
            }
            if (this.LGG != null) {
                aVar.e(14, this.LGG);
            }
            if (this.ukr != null) {
                aVar.e(15, this.ukr);
            }
            if (this.vtD != null) {
                aVar.e(16, this.vtD);
            }
            if (this.LGH != null) {
                aVar.e(17, this.LGH);
            }
            if (this.LGI != null) {
                aVar.e(18, this.LGI);
            }
            if (this.LGw != null) {
                aVar.e(20, this.LGw);
            }
            aVar.e(21, 8, this.Vjd);
            aVar.e(22, 8, this.Lhs);
            AppMethodBeat.o(209523);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.gAZ) + g.a.a.a.c(3, 8, this.LGy);
            if (this.tVM != null) {
                nh += g.a.a.b.b.a.b(4, this.tVM);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.continueFlag);
            if (this.LGz != null) {
                bu += g.a.a.b.b.a.f(6, this.LGz);
            }
            if (this.LGA != null) {
                bu += g.a.a.b.b.a.f(7, this.LGA);
            }
            if (this.LGB != null) {
                bu += g.a.a.b.b.a.f(8, this.LGB);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(9, this.LGC);
            if (this.LGD != null) {
                bu2 += g.a.a.b.b.a.f(10, this.LGD);
            }
            int r = bu2 + g.a.a.b.b.a.r(11, this.liveId);
            if (this.LGE != null) {
                r += g.a.a.b.b.a.f(12, this.LGE);
            }
            if (this.LGF != null) {
                r += g.a.a.b.b.a.f(13, this.LGF);
            }
            if (this.LGG != null) {
                r += g.a.a.b.b.a.f(14, this.LGG);
            }
            if (this.ukr != null) {
                r += g.a.a.b.b.a.f(15, this.ukr);
            }
            if (this.vtD != null) {
                r += g.a.a.b.b.a.f(16, this.vtD);
            }
            if (this.LGH != null) {
                r += g.a.a.b.b.a.f(17, this.LGH);
            }
            if (this.LGI != null) {
                r += g.a.a.b.b.a.f(18, this.LGI);
            }
            if (this.LGw != null) {
                r += g.a.a.b.b.a.f(20, this.LGw);
            }
            int c2 = r + g.a.a.a.c(21, 8, this.Vjd) + g.a.a.a.c(22, 8, this.Lhs);
            AppMethodBeat.o(209523);
            return c2;
        } else if (i2 == 2) {
            this.LGy.clear();
            this.Vjd.clear();
            this.Lhs.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209523);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            awc awc = (awc) objArr[1];
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
                        awc.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(209523);
                    return 0;
                case 2:
                    awc.gAZ = aVar3.UbS.zi();
                    AppMethodBeat.o(209523);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        axg axg = new axg();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = axg.populateBuilderWithField(aVar5, axg, dpc.getNextFieldNumber(aVar5))) {
                        }
                        awc.LGy.add(axg);
                    }
                    AppMethodBeat.o(209523);
                    return 0;
                case 4:
                    awc.tVM = aVar3.UbS.hPo();
                    AppMethodBeat.o(209523);
                    return 0;
                case 5:
                    awc.continueFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(209523);
                    return 0;
                case 6:
                    awc.LGz = aVar3.UbS.readString();
                    AppMethodBeat.o(209523);
                    return 0;
                case 7:
                    awc.LGA = aVar3.UbS.readString();
                    AppMethodBeat.o(209523);
                    return 0;
                case 8:
                    awc.LGB = aVar3.UbS.readString();
                    AppMethodBeat.o(209523);
                    return 0;
                case 9:
                    awc.LGC = aVar3.UbS.zi();
                    AppMethodBeat.o(209523);
                    return 0;
                case 10:
                    awc.LGD = aVar3.UbS.readString();
                    AppMethodBeat.o(209523);
                    return 0;
                case 11:
                    awc.liveId = aVar3.UbS.zl();
                    AppMethodBeat.o(209523);
                    return 0;
                case 12:
                    awc.LGE = aVar3.UbS.readString();
                    AppMethodBeat.o(209523);
                    return 0;
                case 13:
                    awc.LGF = aVar3.UbS.readString();
                    AppMethodBeat.o(209523);
                    return 0;
                case 14:
                    awc.LGG = aVar3.UbS.readString();
                    AppMethodBeat.o(209523);
                    return 0;
                case 15:
                    awc.ukr = aVar3.UbS.readString();
                    AppMethodBeat.o(209523);
                    return 0;
                case 16:
                    awc.vtD = aVar3.UbS.readString();
                    AppMethodBeat.o(209523);
                    return 0;
                case 17:
                    awc.LGH = aVar3.UbS.readString();
                    AppMethodBeat.o(209523);
                    return 0;
                case 18:
                    awc.LGI = aVar3.UbS.readString();
                    AppMethodBeat.o(209523);
                    return 0;
                case 19:
                default:
                    AppMethodBeat.o(209523);
                    return -1;
                case 20:
                    awc.LGw = aVar3.UbS.readString();
                    AppMethodBeat.o(209523);
                    return 0;
                case 21:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        fhh fhh = new fhh();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = fhh.populateBuilderWithField(aVar6, fhh, dpc.getNextFieldNumber(aVar6))) {
                        }
                        awc.Vjd.add(fhh);
                    }
                    AppMethodBeat.o(209523);
                    return 0;
                case 22:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        fhe fhe = new fhe();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = fhe.populateBuilderWithField(aVar7, fhe, dpc.getNextFieldNumber(aVar7))) {
                        }
                        awc.Lhs.add(fhe);
                    }
                    AppMethodBeat.o(209523);
                    return 0;
            }
        } else {
            AppMethodBeat.o(209523);
            return -1;
        }
    }
}
