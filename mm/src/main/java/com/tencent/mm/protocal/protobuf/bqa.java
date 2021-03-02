package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bqa extends dpc {
    public c Iah;
    public String LSG;
    public int pTZ;
    public String pUa;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91492);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.pTZ);
            if (this.pUa != null) {
                aVar.e(3, this.pUa);
            }
            if (this.Iah != null) {
                aVar.ni(4, this.Iah.computeSize());
                this.Iah.writeFields(aVar);
            }
            if (this.LSG != null) {
                aVar.e(5, this.LSG);
            }
            AppMethodBeat.o(91492);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            if (this.Iah != null) {
                nh += g.a.a.a.nh(4, this.Iah.computeSize());
            }
            if (this.LSG != null) {
                nh += g.a.a.b.b.a.f(5, this.LSG);
            }
            AppMethodBeat.o(91492);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91492);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bqa bqa = (bqa) objArr[1];
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
                        bqa.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91492);
                    return 0;
                case 2:
                    bqa.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(91492);
                    return 0;
                case 3:
                    bqa.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(91492);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        c cVar = new c();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cVar.populateBuilderWithField(aVar5, cVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bqa.Iah = cVar;
                    }
                    AppMethodBeat.o(91492);
                    return 0;
                case 5:
                    bqa.LSG = aVar3.UbS.readString();
                    AppMethodBeat.o(91492);
                    return 0;
                default:
                    AppMethodBeat.o(91492);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91492);
            return -1;
        }
    }
}
