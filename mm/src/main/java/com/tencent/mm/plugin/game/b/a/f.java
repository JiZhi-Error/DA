package com.tencent.mm.plugin.game.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class f extends dpc {
    public String xuk;
    public String xut;
    public LinkedList<String> xuu = new LinkedList<>();
    public LinkedList<g> xuv = new LinkedList<>();
    public int xuw;
    public int xux;
    public int xuy;

    public f() {
        AppMethodBeat.i(204102);
        AppMethodBeat.o(204102);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(204103);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(204103);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.xut != null) {
                aVar.e(2, this.xut);
            }
            aVar.e(3, 1, this.xuu);
            aVar.e(4, 8, this.xuv);
            aVar.aM(5, this.xuw);
            aVar.aM(6, this.xux);
            if (this.xuk != null) {
                aVar.e(7, this.xuk);
            }
            aVar.aM(8, this.xuy);
            AppMethodBeat.o(204103);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.xut != null) {
                nh += g.a.a.b.b.a.f(2, this.xut);
            }
            int c2 = nh + g.a.a.a.c(3, 1, this.xuu) + g.a.a.a.c(4, 8, this.xuv) + g.a.a.b.b.a.bu(5, this.xuw) + g.a.a.b.b.a.bu(6, this.xux);
            if (this.xuk != null) {
                c2 += g.a.a.b.b.a.f(7, this.xuk);
            }
            int bu = c2 + g.a.a.b.b.a.bu(8, this.xuy);
            AppMethodBeat.o(204103);
            return bu;
        } else if (i2 == 2) {
            this.xuu.clear();
            this.xuv.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(204103);
                throw bVar2;
            }
            AppMethodBeat.o(204103);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            f fVar = (f) objArr[1];
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
                        fVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(204103);
                    return 0;
                case 2:
                    fVar.xut = aVar3.UbS.readString();
                    AppMethodBeat.o(204103);
                    return 0;
                case 3:
                    fVar.xuu.add(aVar3.UbS.readString());
                    AppMethodBeat.o(204103);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        g gVar = new g();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = gVar.populateBuilderWithField(aVar5, gVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        fVar.xuv.add(gVar);
                    }
                    AppMethodBeat.o(204103);
                    return 0;
                case 5:
                    fVar.xuw = aVar3.UbS.zi();
                    AppMethodBeat.o(204103);
                    return 0;
                case 6:
                    fVar.xux = aVar3.UbS.zi();
                    AppMethodBeat.o(204103);
                    return 0;
                case 7:
                    fVar.xuk = aVar3.UbS.readString();
                    AppMethodBeat.o(204103);
                    return 0;
                case 8:
                    fVar.xuy = aVar3.UbS.zi();
                    AppMethodBeat.o(204103);
                    return 0;
                default:
                    AppMethodBeat.o(204103);
                    return -1;
            }
        } else {
            AppMethodBeat.o(204103);
            return -1;
        }
    }
}
