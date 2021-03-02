package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class fav extends dpc {
    public int KZk;
    public int MRg;
    public String MaZ;
    public int NwM;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117956);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.MaZ == null) {
                b bVar = new b("Not all required fields were included: Json");
                AppMethodBeat.o(117956);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.NwM);
            aVar.aM(3, this.KZk);
            if (this.MaZ != null) {
                aVar.e(4, this.MaZ);
            }
            aVar.aM(5, this.MRg);
            AppMethodBeat.o(117956);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.NwM) + g.a.a.b.b.a.bu(3, this.KZk);
            if (this.MaZ != null) {
                nh += g.a.a.b.b.a.f(4, this.MaZ);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.MRg);
            AppMethodBeat.o(117956);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MaZ == null) {
                b bVar2 = new b("Not all required fields were included: Json");
                AppMethodBeat.o(117956);
                throw bVar2;
            }
            AppMethodBeat.o(117956);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fav fav = (fav) objArr[1];
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
                        fav.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(117956);
                    return 0;
                case 2:
                    fav.NwM = aVar3.UbS.zi();
                    AppMethodBeat.o(117956);
                    return 0;
                case 3:
                    fav.KZk = aVar3.UbS.zi();
                    AppMethodBeat.o(117956);
                    return 0;
                case 4:
                    fav.MaZ = aVar3.UbS.readString();
                    AppMethodBeat.o(117956);
                    return 0;
                case 5:
                    fav.MRg = aVar3.UbS.zi();
                    AppMethodBeat.o(117956);
                    return 0;
                default:
                    AppMethodBeat.o(117956);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117956);
            return -1;
        }
    }
}
