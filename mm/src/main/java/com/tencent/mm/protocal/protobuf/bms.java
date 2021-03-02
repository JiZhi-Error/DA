package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bms extends dpc {
    public int LVs;
    public String LVt;
    public int LVu;
    public LinkedList<ajf> oTA = new LinkedList<>();
    public int oTz;

    public bms() {
        AppMethodBeat.i(104792);
        AppMethodBeat.o(104792);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104793);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(104793);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.oTz);
            aVar.e(3, 8, this.oTA);
            aVar.aM(4, this.LVs);
            if (this.LVt != null) {
                aVar.e(5, this.LVt);
            }
            aVar.aM(6, this.LVu);
            AppMethodBeat.o(104793);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.oTz) + g.a.a.a.c(3, 8, this.oTA) + g.a.a.b.b.a.bu(4, this.LVs);
            if (this.LVt != null) {
                nh += g.a.a.b.b.a.f(5, this.LVt);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.LVu);
            AppMethodBeat.o(104793);
            return bu;
        } else if (i2 == 2) {
            this.oTA.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(104793);
                throw bVar2;
            }
            AppMethodBeat.o(104793);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bms bms = (bms) objArr[1];
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
                        bms.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(104793);
                    return 0;
                case 2:
                    bms.oTz = aVar3.UbS.zi();
                    AppMethodBeat.o(104793);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ajf ajf = new ajf();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ajf.populateBuilderWithField(aVar5, ajf, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bms.oTA.add(ajf);
                    }
                    AppMethodBeat.o(104793);
                    return 0;
                case 4:
                    bms.LVs = aVar3.UbS.zi();
                    AppMethodBeat.o(104793);
                    return 0;
                case 5:
                    bms.LVt = aVar3.UbS.readString();
                    AppMethodBeat.o(104793);
                    return 0;
                case 6:
                    bms.LVu = aVar3.UbS.zi();
                    AppMethodBeat.o(104793);
                    return 0;
                default:
                    AppMethodBeat.o(104793);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104793);
            return -1;
        }
    }
}
