package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bjy extends dpc {
    public int KZh;
    public LinkedList<cpw> LTo = new LinkedList<>();
    public int Version;
    public int oTz;

    public bjy() {
        AppMethodBeat.i(32224);
        AppMethodBeat.o(32224);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32225);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32225);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.oTz);
            aVar.e(5, 8, this.LTo);
            aVar.aM(6, this.Version);
            aVar.aM(7, this.KZh);
            AppMethodBeat.o(32225);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.oTz) + g.a.a.a.c(5, 8, this.LTo) + g.a.a.b.b.a.bu(6, this.Version) + g.a.a.b.b.a.bu(7, this.KZh);
            AppMethodBeat.o(32225);
            return nh;
        } else if (i2 == 2) {
            this.LTo.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32225);
                throw bVar2;
            }
            AppMethodBeat.o(32225);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bjy bjy = (bjy) objArr[1];
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
                        bjy.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(32225);
                    return 0;
                case 2:
                    bjy.oTz = aVar3.UbS.zi();
                    AppMethodBeat.o(32225);
                    return 0;
                case 3:
                case 4:
                default:
                    AppMethodBeat.o(32225);
                    return -1;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cpw cpw = new cpw();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cpw.populateBuilderWithField(aVar5, cpw, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bjy.LTo.add(cpw);
                    }
                    AppMethodBeat.o(32225);
                    return 0;
                case 6:
                    bjy.Version = aVar3.UbS.zi();
                    AppMethodBeat.o(32225);
                    return 0;
                case 7:
                    bjy.KZh = aVar3.UbS.zi();
                    AppMethodBeat.o(32225);
                    return 0;
            }
        } else {
            AppMethodBeat.o(32225);
            return -1;
        }
    }
}
