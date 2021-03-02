package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cfd extends dpc {
    public cjb LFH;
    public b LFp;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(207490);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(207490);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.LFp != null) {
                aVar.c(2, this.LFp);
            }
            if (this.LFH != null) {
                aVar.ni(3, this.LFH.computeSize());
                this.LFH.writeFields(aVar);
            }
            AppMethodBeat.o(207490);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.LFp != null) {
                nh += g.a.a.b.b.a.b(2, this.LFp);
            }
            if (this.LFH != null) {
                nh += g.a.a.a.nh(3, this.LFH.computeSize());
            }
            AppMethodBeat.o(207490);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(207490);
                throw bVar2;
            }
            AppMethodBeat.o(207490);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cfd cfd = (cfd) objArr[1];
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
                        cfd.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(207490);
                    return 0;
                case 2:
                    cfd.LFp = aVar3.UbS.hPo();
                    AppMethodBeat.o(207490);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cjb cjb = new cjb();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cjb.populateBuilderWithField(aVar5, cjb, dpc.getNextFieldNumber(aVar5))) {
                        }
                        cfd.LFH = cjb;
                    }
                    AppMethodBeat.o(207490);
                    return 0;
                default:
                    AppMethodBeat.o(207490);
                    return -1;
            }
        } else {
            AppMethodBeat.o(207490);
            return -1;
        }
    }
}
