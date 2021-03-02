package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bqs extends dpc {
    public int LUO;
    public cys LYn;
    public int LYo;
    public int pTZ;
    public String pUa;
    public int qGg;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(114031);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(114031);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.pTZ);
            if (this.pUa != null) {
                aVar.e(3, this.pUa);
            }
            aVar.aM(4, this.qGg);
            aVar.aM(5, this.LUO);
            if (this.LYn != null) {
                aVar.ni(6, this.LYn.computeSize());
                this.LYn.writeFields(aVar);
            }
            aVar.aM(7, this.LYo);
            AppMethodBeat.o(114031);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.qGg) + g.a.a.b.b.a.bu(5, this.LUO);
            if (this.LYn != null) {
                bu += g.a.a.a.nh(6, this.LYn.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.LYo);
            AppMethodBeat.o(114031);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(114031);
                throw bVar2;
            }
            AppMethodBeat.o(114031);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bqs bqs = (bqs) objArr[1];
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
                        bqs.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(114031);
                    return 0;
                case 2:
                    bqs.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(114031);
                    return 0;
                case 3:
                    bqs.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(114031);
                    return 0;
                case 4:
                    bqs.qGg = aVar3.UbS.zi();
                    AppMethodBeat.o(114031);
                    return 0;
                case 5:
                    bqs.LUO = aVar3.UbS.zi();
                    AppMethodBeat.o(114031);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cys cys = new cys();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cys.populateBuilderWithField(aVar5, cys, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bqs.LYn = cys;
                    }
                    AppMethodBeat.o(114031);
                    return 0;
                case 7:
                    bqs.LYo = aVar3.UbS.zi();
                    AppMethodBeat.o(114031);
                    return 0;
                default:
                    AppMethodBeat.o(114031);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114031);
            return -1;
        }
    }
}
