package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dmf extends dpc {
    public ctc LTd;
    public String MPM;
    public int MPN;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104376);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(104376);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.MPM != null) {
                aVar.e(2, this.MPM);
            }
            if (this.LTd != null) {
                aVar.ni(3, this.LTd.computeSize());
                this.LTd.writeFields(aVar);
            }
            aVar.aM(4, this.MPN);
            AppMethodBeat.o(104376);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.MPM != null) {
                nh += g.a.a.b.b.a.f(2, this.MPM);
            }
            if (this.LTd != null) {
                nh += g.a.a.a.nh(3, this.LTd.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.MPN);
            AppMethodBeat.o(104376);
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
                AppMethodBeat.o(104376);
                throw bVar2;
            }
            AppMethodBeat.o(104376);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dmf dmf = (dmf) objArr[1];
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
                        dmf.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(104376);
                    return 0;
                case 2:
                    dmf.MPM = aVar3.UbS.readString();
                    AppMethodBeat.o(104376);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ctc ctc = new ctc();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ctc.populateBuilderWithField(aVar5, ctc, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dmf.LTd = ctc;
                    }
                    AppMethodBeat.o(104376);
                    return 0;
                case 4:
                    dmf.MPN = aVar3.UbS.zi();
                    AppMethodBeat.o(104376);
                    return 0;
                default:
                    AppMethodBeat.o(104376);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104376);
            return -1;
        }
    }
}
