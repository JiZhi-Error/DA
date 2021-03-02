package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class by extends dpc {
    public boolean xMb;
    public int xMc;
    public LinkedList<g> xMf = new LinkedList<>();

    public by() {
        AppMethodBeat.i(41782);
        AppMethodBeat.o(41782);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41783);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(41783);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.xMf);
            aVar.cc(3, this.xMb);
            aVar.aM(4, this.xMc);
            AppMethodBeat.o(41783);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.xMf) + g.a.a.b.b.a.fS(3) + 1 + g.a.a.b.b.a.bu(4, this.xMc);
            AppMethodBeat.o(41783);
            return nh;
        } else if (i2 == 2) {
            this.xMf.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(41783);
                throw bVar2;
            }
            AppMethodBeat.o(41783);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            by byVar = (by) objArr[1];
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
                        byVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(41783);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        g gVar = new g();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = gVar.populateBuilderWithField(aVar5, gVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        byVar.xMf.add(gVar);
                    }
                    AppMethodBeat.o(41783);
                    return 0;
                case 3:
                    byVar.xMb = aVar3.UbS.yZ();
                    AppMethodBeat.o(41783);
                    return 0;
                case 4:
                    byVar.xMc = aVar3.UbS.zi();
                    AppMethodBeat.o(41783);
                    return 0;
                default:
                    AppMethodBeat.o(41783);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41783);
            return -1;
        }
    }
}
