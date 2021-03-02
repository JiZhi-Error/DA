package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class czn extends dpc {
    public exi LQB;
    public String LQv;
    public String LQw;
    public String MER;
    public int rBL;
    public String rBM;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91572);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91572);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.LQw != null) {
                aVar.e(2, this.LQw);
            }
            aVar.aM(3, this.rBL);
            if (this.rBM != null) {
                aVar.e(4, this.rBM);
            }
            if (this.LQv != null) {
                aVar.e(5, this.LQv);
            }
            if (this.MER != null) {
                aVar.e(6, this.MER);
            }
            if (this.LQB != null) {
                aVar.ni(7, this.LQB.computeSize());
                this.LQB.writeFields(aVar);
            }
            AppMethodBeat.o(91572);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.LQw != null) {
                nh += g.a.a.b.b.a.f(2, this.LQw);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.rBL);
            if (this.rBM != null) {
                bu += g.a.a.b.b.a.f(4, this.rBM);
            }
            if (this.LQv != null) {
                bu += g.a.a.b.b.a.f(5, this.LQv);
            }
            if (this.MER != null) {
                bu += g.a.a.b.b.a.f(6, this.MER);
            }
            if (this.LQB != null) {
                bu += g.a.a.a.nh(7, this.LQB.computeSize());
            }
            AppMethodBeat.o(91572);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91572);
                throw bVar2;
            }
            AppMethodBeat.o(91572);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            czn czn = (czn) objArr[1];
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
                        czn.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91572);
                    return 0;
                case 2:
                    czn.LQw = aVar3.UbS.readString();
                    AppMethodBeat.o(91572);
                    return 0;
                case 3:
                    czn.rBL = aVar3.UbS.zi();
                    AppMethodBeat.o(91572);
                    return 0;
                case 4:
                    czn.rBM = aVar3.UbS.readString();
                    AppMethodBeat.o(91572);
                    return 0;
                case 5:
                    czn.LQv = aVar3.UbS.readString();
                    AppMethodBeat.o(91572);
                    return 0;
                case 6:
                    czn.MER = aVar3.UbS.readString();
                    AppMethodBeat.o(91572);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        exi exi = new exi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = exi.populateBuilderWithField(aVar5, exi, dpc.getNextFieldNumber(aVar5))) {
                        }
                        czn.LQB = exi;
                    }
                    AppMethodBeat.o(91572);
                    return 0;
                default:
                    AppMethodBeat.o(91572);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91572);
            return -1;
        }
    }
}
