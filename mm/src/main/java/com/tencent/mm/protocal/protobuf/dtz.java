package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dtz extends dpc {
    public long KMm;
    public String MVJ;
    public int MVK;
    public String MvT;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(207016);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.MVJ != null) {
                aVar.e(3, this.MVJ);
            }
            if (this.MvT != null) {
                aVar.e(4, this.MvT);
            }
            aVar.bb(5, this.KMm);
            aVar.aM(6, this.MVK);
            AppMethodBeat.o(207016);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.MVJ != null) {
                nh += g.a.a.b.b.a.f(3, this.MVJ);
            }
            if (this.MvT != null) {
                nh += g.a.a.b.b.a.f(4, this.MvT);
            }
            int r = nh + g.a.a.b.b.a.r(5, this.KMm) + g.a.a.b.b.a.bu(6, this.MVK);
            AppMethodBeat.o(207016);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(207016);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dtz dtz = (dtz) objArr[1];
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
                        dtz.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(207016);
                    return 0;
                case 2:
                default:
                    AppMethodBeat.o(207016);
                    return -1;
                case 3:
                    dtz.MVJ = aVar3.UbS.readString();
                    AppMethodBeat.o(207016);
                    return 0;
                case 4:
                    dtz.MvT = aVar3.UbS.readString();
                    AppMethodBeat.o(207016);
                    return 0;
                case 5:
                    dtz.KMm = aVar3.UbS.zl();
                    AppMethodBeat.o(207016);
                    return 0;
                case 6:
                    dtz.MVK = aVar3.UbS.zi();
                    AppMethodBeat.o(207016);
                    return 0;
            }
        } else {
            AppMethodBeat.o(207016);
            return -1;
        }
    }
}
