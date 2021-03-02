package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class avg extends dpc {
    public String LFw;
    public long LFx;
    public String session_id;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209499);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.LFw != null) {
                aVar.e(2, this.LFw);
            }
            aVar.bb(3, this.LFx);
            if (this.session_id != null) {
                aVar.e(4, this.session_id);
            }
            AppMethodBeat.o(209499);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.LFw != null) {
                nh += g.a.a.b.b.a.f(2, this.LFw);
            }
            int r = nh + g.a.a.b.b.a.r(3, this.LFx);
            if (this.session_id != null) {
                r += g.a.a.b.b.a.f(4, this.session_id);
            }
            AppMethodBeat.o(209499);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209499);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            avg avg = (avg) objArr[1];
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
                        avg.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(209499);
                    return 0;
                case 2:
                    avg.LFw = aVar3.UbS.readString();
                    AppMethodBeat.o(209499);
                    return 0;
                case 3:
                    avg.LFx = aVar3.UbS.zl();
                    AppMethodBeat.o(209499);
                    return 0;
                case 4:
                    avg.session_id = aVar3.UbS.readString();
                    AppMethodBeat.o(209499);
                    return 0;
                default:
                    AppMethodBeat.o(209499);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209499);
            return -1;
        }
    }
}
