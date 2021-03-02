package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class clm extends dpc {
    public long BPd;
    public LinkedList<clp> MqJ = new LinkedList<>();

    public clm() {
        AppMethodBeat.i(169920);
        AppMethodBeat.o(169920);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169921);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(169921);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.bb(2, this.BPd);
            aVar.e(3, 8, this.MqJ);
            AppMethodBeat.o(169921);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.BPd) + g.a.a.a.c(3, 8, this.MqJ);
            AppMethodBeat.o(169921);
            return nh;
        } else if (i2 == 2) {
            this.MqJ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(169921);
                throw bVar2;
            }
            AppMethodBeat.o(169921);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            clm clm = (clm) objArr[1];
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
                        clm.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(169921);
                    return 0;
                case 2:
                    clm.BPd = aVar3.UbS.zl();
                    AppMethodBeat.o(169921);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        clp clp = new clp();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = clp.populateBuilderWithField(aVar5, clp, dpc.getNextFieldNumber(aVar5))) {
                        }
                        clm.MqJ.add(clp);
                    }
                    AppMethodBeat.o(169921);
                    return 0;
                default:
                    AppMethodBeat.o(169921);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169921);
            return -1;
        }
    }
}
