package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bkz extends dpc {
    public String LTP;
    public int LTQ;
    public dpu LTS;
    public String LTT;
    public dps LTU;
    public long fvd;
    public int gsc;
    public String gsd;
    public int gse;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(101808);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(101808);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.LTP != null) {
                aVar.e(2, this.LTP);
            }
            aVar.aM(3, this.gsc);
            if (this.gsd != null) {
                aVar.e(4, this.gsd);
            }
            aVar.aM(5, this.gse);
            aVar.aM(6, this.LTQ);
            aVar.bb(7, this.fvd);
            if (this.LTS != null) {
                aVar.ni(8, this.LTS.computeSize());
                this.LTS.writeFields(aVar);
            }
            if (this.LTT != null) {
                aVar.e(9, this.LTT);
            }
            if (this.LTU != null) {
                aVar.ni(10, this.LTU.computeSize());
                this.LTU.writeFields(aVar);
            }
            AppMethodBeat.o(101808);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.LTP != null) {
                nh += g.a.a.b.b.a.f(2, this.LTP);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.gsc);
            if (this.gsd != null) {
                bu += g.a.a.b.b.a.f(4, this.gsd);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.gse) + g.a.a.b.b.a.bu(6, this.LTQ) + g.a.a.b.b.a.r(7, this.fvd);
            if (this.LTS != null) {
                bu2 += g.a.a.a.nh(8, this.LTS.computeSize());
            }
            if (this.LTT != null) {
                bu2 += g.a.a.b.b.a.f(9, this.LTT);
            }
            if (this.LTU != null) {
                bu2 += g.a.a.a.nh(10, this.LTU.computeSize());
            }
            AppMethodBeat.o(101808);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(101808);
                throw bVar2;
            }
            AppMethodBeat.o(101808);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bkz bkz = (bkz) objArr[1];
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
                        bkz.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(101808);
                    return 0;
                case 2:
                    bkz.LTP = aVar3.UbS.readString();
                    AppMethodBeat.o(101808);
                    return 0;
                case 3:
                    bkz.gsc = aVar3.UbS.zi();
                    AppMethodBeat.o(101808);
                    return 0;
                case 4:
                    bkz.gsd = aVar3.UbS.readString();
                    AppMethodBeat.o(101808);
                    return 0;
                case 5:
                    bkz.gse = aVar3.UbS.zi();
                    AppMethodBeat.o(101808);
                    return 0;
                case 6:
                    bkz.LTQ = aVar3.UbS.zi();
                    AppMethodBeat.o(101808);
                    return 0;
                case 7:
                    bkz.fvd = aVar3.UbS.zl();
                    AppMethodBeat.o(101808);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dpu dpu = new dpu();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dpu.populateBuilderWithField(aVar5, dpu, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bkz.LTS = dpu;
                    }
                    AppMethodBeat.o(101808);
                    return 0;
                case 9:
                    bkz.LTT = aVar3.UbS.readString();
                    AppMethodBeat.o(101808);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dps dps = new dps();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dps.populateBuilderWithField(aVar6, dps, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bkz.LTU = dps;
                    }
                    AppMethodBeat.o(101808);
                    return 0;
                default:
                    AppMethodBeat.o(101808);
                    return -1;
            }
        } else {
            AppMethodBeat.o(101808);
            return -1;
        }
    }
}
