package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class oy extends dpc {
    public int KUq;
    public long KVL;
    public int KVM;
    public int KVN;
    public long KVO;
    public LinkedList<ow> KVP = new LinkedList<>();
    public int KVQ;
    public LinkedList<dkn> KVR = new LinkedList<>();
    public dkm KVS;
    public String KVe;
    public String buffer;
    public int cSx;
    public int oKV;

    public oy() {
        AppMethodBeat.i(124440);
        AppMethodBeat.o(124440);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124441);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(124441);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.bb(2, this.KVL);
            aVar.aM(3, this.KVM);
            aVar.aM(4, this.KVN);
            aVar.bb(5, this.KVO);
            aVar.aM(6, this.KUq);
            aVar.e(7, 8, this.KVP);
            aVar.aM(8, this.KVQ);
            if (this.KVe != null) {
                aVar.e(9, this.KVe);
            }
            aVar.aM(10, this.oKV);
            aVar.aM(11, this.cSx);
            aVar.e(12, 8, this.KVR);
            if (this.buffer != null) {
                aVar.e(14, this.buffer);
            }
            if (this.KVS != null) {
                aVar.ni(16, this.KVS.computeSize());
                this.KVS.writeFields(aVar);
            }
            AppMethodBeat.o(124441);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.KVL) + g.a.a.b.b.a.bu(3, this.KVM) + g.a.a.b.b.a.bu(4, this.KVN) + g.a.a.b.b.a.r(5, this.KVO) + g.a.a.b.b.a.bu(6, this.KUq) + g.a.a.a.c(7, 8, this.KVP) + g.a.a.b.b.a.bu(8, this.KVQ);
            if (this.KVe != null) {
                nh += g.a.a.b.b.a.f(9, this.KVe);
            }
            int bu = nh + g.a.a.b.b.a.bu(10, this.oKV) + g.a.a.b.b.a.bu(11, this.cSx) + g.a.a.a.c(12, 8, this.KVR);
            if (this.buffer != null) {
                bu += g.a.a.b.b.a.f(14, this.buffer);
            }
            if (this.KVS != null) {
                bu += g.a.a.a.nh(16, this.KVS.computeSize());
            }
            AppMethodBeat.o(124441);
            return bu;
        } else if (i2 == 2) {
            this.KVP.clear();
            this.KVR.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(124441);
                throw bVar2;
            }
            AppMethodBeat.o(124441);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            oy oyVar = (oy) objArr[1];
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
                        oyVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(124441);
                    return 0;
                case 2:
                    oyVar.KVL = aVar3.UbS.zl();
                    AppMethodBeat.o(124441);
                    return 0;
                case 3:
                    oyVar.KVM = aVar3.UbS.zi();
                    AppMethodBeat.o(124441);
                    return 0;
                case 4:
                    oyVar.KVN = aVar3.UbS.zi();
                    AppMethodBeat.o(124441);
                    return 0;
                case 5:
                    oyVar.KVO = aVar3.UbS.zl();
                    AppMethodBeat.o(124441);
                    return 0;
                case 6:
                    oyVar.KUq = aVar3.UbS.zi();
                    AppMethodBeat.o(124441);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ow owVar = new ow();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = owVar.populateBuilderWithField(aVar5, owVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        oyVar.KVP.add(owVar);
                    }
                    AppMethodBeat.o(124441);
                    return 0;
                case 8:
                    oyVar.KVQ = aVar3.UbS.zi();
                    AppMethodBeat.o(124441);
                    return 0;
                case 9:
                    oyVar.KVe = aVar3.UbS.readString();
                    AppMethodBeat.o(124441);
                    return 0;
                case 10:
                    oyVar.oKV = aVar3.UbS.zi();
                    AppMethodBeat.o(124441);
                    return 0;
                case 11:
                    oyVar.cSx = aVar3.UbS.zi();
                    AppMethodBeat.o(124441);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dkn dkn = new dkn();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dkn.populateBuilderWithField(aVar6, dkn, dpc.getNextFieldNumber(aVar6))) {
                        }
                        oyVar.KVR.add(dkn);
                    }
                    AppMethodBeat.o(124441);
                    return 0;
                case 13:
                case 15:
                default:
                    AppMethodBeat.o(124441);
                    return -1;
                case 14:
                    oyVar.buffer = aVar3.UbS.readString();
                    AppMethodBeat.o(124441);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dkm dkm = new dkm();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dkm.populateBuilderWithField(aVar7, dkm, dpc.getNextFieldNumber(aVar7))) {
                        }
                        oyVar.KVS = dkm;
                    }
                    AppMethodBeat.o(124441);
                    return 0;
            }
        } else {
            AppMethodBeat.o(124441);
            return -1;
        }
    }
}
