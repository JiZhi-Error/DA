package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cgf extends dpc {
    public String Mbb;
    public efl MlS;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(187876);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.Mbb != null) {
                aVar.e(2, this.Mbb);
            }
            if (this.MlS != null) {
                aVar.ni(3, this.MlS.computeSize());
                this.MlS.writeFields(aVar);
            }
            AppMethodBeat.o(187876);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.Mbb != null) {
                nh += g.a.a.b.b.a.f(2, this.Mbb);
            }
            if (this.MlS != null) {
                nh += g.a.a.a.nh(3, this.MlS.computeSize());
            }
            AppMethodBeat.o(187876);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(187876);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cgf cgf = (cgf) objArr[1];
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
                        cgf.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(187876);
                    return 0;
                case 2:
                    cgf.Mbb = aVar3.UbS.readString();
                    AppMethodBeat.o(187876);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        efl efl = new efl();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = efl.populateBuilderWithField(aVar5, efl, dpc.getNextFieldNumber(aVar5))) {
                        }
                        cgf.MlS = efl;
                    }
                    AppMethodBeat.o(187876);
                    return 0;
                default:
                    AppMethodBeat.o(187876);
                    return -1;
            }
        } else {
            AppMethodBeat.o(187876);
            return -1;
        }
    }
}
