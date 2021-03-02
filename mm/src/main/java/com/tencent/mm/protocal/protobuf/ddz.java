package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ddz extends dpc {
    public LinkedList<cye> MJa = new LinkedList<>();
    public String dNI;
    public int version;

    public ddz() {
        AppMethodBeat.i(123637);
        AppMethodBeat.o(123637);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123638);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(123638);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.dNI != null) {
                aVar.e(2, this.dNI);
            }
            aVar.aM(3, this.version);
            aVar.e(4, 8, this.MJa);
            AppMethodBeat.o(123638);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.dNI != null) {
                nh += g.a.a.b.b.a.f(2, this.dNI);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.version) + g.a.a.a.c(4, 8, this.MJa);
            AppMethodBeat.o(123638);
            return bu;
        } else if (i2 == 2) {
            this.MJa.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(123638);
                throw bVar2;
            }
            AppMethodBeat.o(123638);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ddz ddz = (ddz) objArr[1];
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
                        ddz.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(123638);
                    return 0;
                case 2:
                    ddz.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(123638);
                    return 0;
                case 3:
                    ddz.version = aVar3.UbS.zi();
                    AppMethodBeat.o(123638);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cye cye = new cye();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cye.populateBuilderWithField(aVar5, cye, dpc.getNextFieldNumber(aVar5))) {
                        }
                        ddz.MJa.add(cye);
                    }
                    AppMethodBeat.o(123638);
                    return 0;
                default:
                    AppMethodBeat.o(123638);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123638);
            return -1;
        }
    }
}
