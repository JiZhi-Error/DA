package com.tencent.mm.plugin.game.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.b.g;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import g.a.a.c.a;
import java.util.LinkedList;

public final class b extends dpc {
    public int op;
    public long xue;
    public g xuf;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(40861);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(40861);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.op);
            aVar.bb(3, this.xue);
            if (this.xuf != null) {
                aVar.ni(4, this.xuf.computeSize());
                this.xuf.writeFields(aVar);
            }
            AppMethodBeat.o(40861);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.op) + g.a.a.b.b.a.r(3, this.xue);
            if (this.xuf != null) {
                nh += g.a.a.a.nh(4, this.xuf.computeSize());
            }
            AppMethodBeat.o(40861);
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
                AppMethodBeat.o(40861);
                throw bVar2;
            }
            AppMethodBeat.o(40861);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            b bVar3 = (b) objArr[1];
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
                        bVar3.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(40861);
                    return 0;
                case 2:
                    bVar3.op = aVar3.UbS.zi();
                    AppMethodBeat.o(40861);
                    return 0;
                case 3:
                    bVar3.xue = aVar3.UbS.zl();
                    AppMethodBeat.o(40861);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        g gVar = new g();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = gVar.populateBuilderWithField(aVar5, gVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bVar3.xuf = gVar;
                    }
                    AppMethodBeat.o(40861);
                    return 0;
                default:
                    AppMethodBeat.o(40861);
                    return -1;
            }
        } else {
            AppMethodBeat.o(40861);
            return -1;
        }
    }
}
