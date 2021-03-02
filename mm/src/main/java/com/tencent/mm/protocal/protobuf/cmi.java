package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cmi extends dpc {
    public LinkedList<cmk> MrF = new LinkedList<>();
    public int wOi;
    public int wOj;

    public cmi() {
        AppMethodBeat.i(32341);
        AppMethodBeat.o(32341);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32342);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32342);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.MrF);
            aVar.aM(3, this.wOj);
            aVar.aM(4, this.wOi);
            AppMethodBeat.o(32342);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.MrF) + g.a.a.b.b.a.bu(3, this.wOj) + g.a.a.b.b.a.bu(4, this.wOi);
            AppMethodBeat.o(32342);
            return nh;
        } else if (i2 == 2) {
            this.MrF.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32342);
                throw bVar2;
            }
            AppMethodBeat.o(32342);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cmi cmi = (cmi) objArr[1];
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
                        cmi.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(32342);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cmk cmk = new cmk();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cmk.populateBuilderWithField(aVar5, cmk, dpc.getNextFieldNumber(aVar5))) {
                        }
                        cmi.MrF.add(cmk);
                    }
                    AppMethodBeat.o(32342);
                    return 0;
                case 3:
                    cmi.wOj = aVar3.UbS.zi();
                    AppMethodBeat.o(32342);
                    return 0;
                case 4:
                    cmi.wOi = aVar3.UbS.zi();
                    AppMethodBeat.o(32342);
                    return 0;
                default:
                    AppMethodBeat.o(32342);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32342);
            return -1;
        }
    }
}
