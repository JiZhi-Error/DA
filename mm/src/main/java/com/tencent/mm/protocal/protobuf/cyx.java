package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cyx extends dpc {
    public String AesKey;
    public String LxW;
    public String MDU;
    public int MDY;
    public String MDZ;
    public int MEa;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(223890);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(223890);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.MDU != null) {
                aVar.e(2, this.MDU);
            }
            if (this.LxW != null) {
                aVar.e(3, this.LxW);
            }
            if (this.AesKey != null) {
                aVar.e(4, this.AesKey);
            }
            aVar.aM(6, this.MDY);
            if (this.MDZ != null) {
                aVar.e(8, this.MDZ);
            }
            aVar.aM(9, this.MEa);
            AppMethodBeat.o(223890);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.MDU != null) {
                nh += g.a.a.b.b.a.f(2, this.MDU);
            }
            if (this.LxW != null) {
                nh += g.a.a.b.b.a.f(3, this.LxW);
            }
            if (this.AesKey != null) {
                nh += g.a.a.b.b.a.f(4, this.AesKey);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.MDY);
            if (this.MDZ != null) {
                bu += g.a.a.b.b.a.f(8, this.MDZ);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(9, this.MEa);
            AppMethodBeat.o(223890);
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
                AppMethodBeat.o(223890);
                throw bVar2;
            }
            AppMethodBeat.o(223890);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cyx cyx = (cyx) objArr[1];
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
                        cyx.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(223890);
                    return 0;
                case 2:
                    cyx.MDU = aVar3.UbS.readString();
                    AppMethodBeat.o(223890);
                    return 0;
                case 3:
                    cyx.LxW = aVar3.UbS.readString();
                    AppMethodBeat.o(223890);
                    return 0;
                case 4:
                    cyx.AesKey = aVar3.UbS.readString();
                    AppMethodBeat.o(223890);
                    return 0;
                case 5:
                case 7:
                default:
                    AppMethodBeat.o(223890);
                    return -1;
                case 6:
                    cyx.MDY = aVar3.UbS.zi();
                    AppMethodBeat.o(223890);
                    return 0;
                case 8:
                    cyx.MDZ = aVar3.UbS.readString();
                    AppMethodBeat.o(223890);
                    return 0;
                case 9:
                    cyx.MEa = aVar3.UbS.zi();
                    AppMethodBeat.o(223890);
                    return 0;
            }
        } else {
            AppMethodBeat.o(223890);
            return -1;
        }
    }
}
