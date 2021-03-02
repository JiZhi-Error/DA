package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bm extends dpc {
    public String xJu;
    public LinkedList<ao> xLC = new LinkedList<>();
    public b xLD;
    public boolean xLE;

    public bm() {
        AppMethodBeat.i(41763);
        AppMethodBeat.o(41763);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41764);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(41764);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.xLC);
            if (this.xLD != null) {
                aVar.c(3, this.xLD);
            }
            aVar.cc(4, this.xLE);
            if (this.xJu != null) {
                aVar.e(5, this.xJu);
            }
            AppMethodBeat.o(41764);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.xLC);
            if (this.xLD != null) {
                nh += g.a.a.b.b.a.b(3, this.xLD);
            }
            int fS = nh + g.a.a.b.b.a.fS(4) + 1;
            if (this.xJu != null) {
                fS += g.a.a.b.b.a.f(5, this.xJu);
            }
            AppMethodBeat.o(41764);
            return fS;
        } else if (i2 == 2) {
            this.xLC.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(41764);
                throw bVar2;
            }
            AppMethodBeat.o(41764);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bm bmVar = (bm) objArr[1];
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
                        bmVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(41764);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ao aoVar = new ao();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aoVar.populateBuilderWithField(aVar5, aoVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bmVar.xLC.add(aoVar);
                    }
                    AppMethodBeat.o(41764);
                    return 0;
                case 3:
                    bmVar.xLD = aVar3.UbS.hPo();
                    AppMethodBeat.o(41764);
                    return 0;
                case 4:
                    bmVar.xLE = aVar3.UbS.yZ();
                    AppMethodBeat.o(41764);
                    return 0;
                case 5:
                    bmVar.xJu = aVar3.UbS.readString();
                    AppMethodBeat.o(41764);
                    return 0;
                default:
                    AppMethodBeat.o(41764);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41764);
            return -1;
        }
    }
}
