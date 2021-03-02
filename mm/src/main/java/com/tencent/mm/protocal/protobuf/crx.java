package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class crx extends dpc {
    public String MwX;
    public long MwZ;
    public String uFc;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256708);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.bb(2, this.MwZ);
            if (this.uFc != null) {
                aVar.e(3, this.uFc);
            }
            if (this.MwX != null) {
                aVar.e(4, this.MwX);
            }
            AppMethodBeat.o(256708);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.MwZ);
            if (this.uFc != null) {
                nh += g.a.a.b.b.a.f(3, this.uFc);
            }
            if (this.MwX != null) {
                nh += g.a.a.b.b.a.f(4, this.MwX);
            }
            AppMethodBeat.o(256708);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(256708);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            crx crx = (crx) objArr[1];
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
                        crx.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(256708);
                    return 0;
                case 2:
                    crx.MwZ = aVar3.UbS.zl();
                    AppMethodBeat.o(256708);
                    return 0;
                case 3:
                    crx.uFc = aVar3.UbS.readString();
                    AppMethodBeat.o(256708);
                    return 0;
                case 4:
                    crx.MwX = aVar3.UbS.readString();
                    AppMethodBeat.o(256708);
                    return 0;
                default:
                    AppMethodBeat.o(256708);
                    return -1;
            }
        } else {
            AppMethodBeat.o(256708);
            return -1;
        }
    }
}
