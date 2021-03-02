package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cud extends dpc {
    public String KJw;
    public LinkedList<cuh> Mzs = new LinkedList<>();
    public String Mzt;
    public boolean Mzu;
    public boolean Mzv;
    public boolean Mzw;
    public LinkedList<cue> Mzx = new LinkedList<>();
    public boolean Mzy;
    public String ixZ;
    public boolean lHF;
    public int lHG;
    public int lHH;
    public String lHI;
    public String lHJ;

    public cud() {
        AppMethodBeat.i(82461);
        AppMethodBeat.o(82461);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82462);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(82462);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(3, 8, this.Mzs);
            if (this.ixZ != null) {
                aVar.e(4, this.ixZ);
            }
            if (this.Mzt != null) {
                aVar.e(5, this.Mzt);
            }
            if (this.KJw != null) {
                aVar.e(6, this.KJw);
            }
            aVar.cc(8, this.Mzu);
            aVar.cc(9, this.Mzv);
            aVar.cc(10, this.Mzw);
            aVar.e(11, 8, this.Mzx);
            aVar.cc(12, this.Mzy);
            aVar.cc(13, this.lHF);
            aVar.aM(14, this.lHG);
            aVar.aM(15, this.lHH);
            if (this.lHI != null) {
                aVar.e(16, this.lHI);
            }
            if (this.lHJ != null) {
                aVar.e(17, this.lHJ);
            }
            AppMethodBeat.o(82462);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(3, 8, this.Mzs);
            if (this.ixZ != null) {
                nh += g.a.a.b.b.a.f(4, this.ixZ);
            }
            if (this.Mzt != null) {
                nh += g.a.a.b.b.a.f(5, this.Mzt);
            }
            if (this.KJw != null) {
                nh += g.a.a.b.b.a.f(6, this.KJw);
            }
            int fS = nh + g.a.a.b.b.a.fS(8) + 1 + g.a.a.b.b.a.fS(9) + 1 + g.a.a.b.b.a.fS(10) + 1 + g.a.a.a.c(11, 8, this.Mzx) + g.a.a.b.b.a.fS(12) + 1 + g.a.a.b.b.a.fS(13) + 1 + g.a.a.b.b.a.bu(14, this.lHG) + g.a.a.b.b.a.bu(15, this.lHH);
            if (this.lHI != null) {
                fS += g.a.a.b.b.a.f(16, this.lHI);
            }
            if (this.lHJ != null) {
                fS += g.a.a.b.b.a.f(17, this.lHJ);
            }
            AppMethodBeat.o(82462);
            return fS;
        } else if (i2 == 2) {
            this.Mzs.clear();
            this.Mzx.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(82462);
                throw bVar2;
            }
            AppMethodBeat.o(82462);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cud cud = (cud) objArr[1];
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
                        cud.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(82462);
                    return 0;
                case 2:
                case 7:
                default:
                    AppMethodBeat.o(82462);
                    return -1;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cuh cuh = new cuh();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cuh.populateBuilderWithField(aVar5, cuh, dpc.getNextFieldNumber(aVar5))) {
                        }
                        cud.Mzs.add(cuh);
                    }
                    AppMethodBeat.o(82462);
                    return 0;
                case 4:
                    cud.ixZ = aVar3.UbS.readString();
                    AppMethodBeat.o(82462);
                    return 0;
                case 5:
                    cud.Mzt = aVar3.UbS.readString();
                    AppMethodBeat.o(82462);
                    return 0;
                case 6:
                    cud.KJw = aVar3.UbS.readString();
                    AppMethodBeat.o(82462);
                    return 0;
                case 8:
                    cud.Mzu = aVar3.UbS.yZ();
                    AppMethodBeat.o(82462);
                    return 0;
                case 9:
                    cud.Mzv = aVar3.UbS.yZ();
                    AppMethodBeat.o(82462);
                    return 0;
                case 10:
                    cud.Mzw = aVar3.UbS.yZ();
                    AppMethodBeat.o(82462);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cue cue = new cue();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cue.populateBuilderWithField(aVar6, cue, dpc.getNextFieldNumber(aVar6))) {
                        }
                        cud.Mzx.add(cue);
                    }
                    AppMethodBeat.o(82462);
                    return 0;
                case 12:
                    cud.Mzy = aVar3.UbS.yZ();
                    AppMethodBeat.o(82462);
                    return 0;
                case 13:
                    cud.lHF = aVar3.UbS.yZ();
                    AppMethodBeat.o(82462);
                    return 0;
                case 14:
                    cud.lHG = aVar3.UbS.zi();
                    AppMethodBeat.o(82462);
                    return 0;
                case 15:
                    cud.lHH = aVar3.UbS.zi();
                    AppMethodBeat.o(82462);
                    return 0;
                case 16:
                    cud.lHI = aVar3.UbS.readString();
                    AppMethodBeat.o(82462);
                    return 0;
                case 17:
                    cud.lHJ = aVar3.UbS.readString();
                    AppMethodBeat.o(82462);
                    return 0;
            }
        } else {
            AppMethodBeat.o(82462);
            return -1;
        }
    }
}
