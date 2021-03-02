package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class den extends dpc {
    public b Loz;
    public cdg MJy;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(214319);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(214319);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.Loz != null) {
                aVar.c(2, this.Loz);
            }
            if (this.MJy != null) {
                aVar.ni(100, this.MJy.computeSize());
                this.MJy.writeFields(aVar);
            }
            AppMethodBeat.o(214319);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.Loz != null) {
                nh += g.a.a.b.b.a.b(2, this.Loz);
            }
            if (this.MJy != null) {
                nh += g.a.a.a.nh(100, this.MJy.computeSize());
            }
            AppMethodBeat.o(214319);
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
                AppMethodBeat.o(214319);
                throw bVar2;
            }
            AppMethodBeat.o(214319);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            den den = (den) objArr[1];
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
                        den.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(214319);
                    return 0;
                case 2:
                    den.Loz = aVar3.UbS.hPo();
                    AppMethodBeat.o(214319);
                    return 0;
                case 100:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cdg cdg = new cdg();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cdg.populateBuilderWithField(aVar5, cdg, dpc.getNextFieldNumber(aVar5))) {
                        }
                        den.MJy = cdg;
                    }
                    AppMethodBeat.o(214319);
                    return 0;
                default:
                    AppMethodBeat.o(214319);
                    return -1;
            }
        } else {
            AppMethodBeat.o(214319);
            return -1;
        }
    }
}
