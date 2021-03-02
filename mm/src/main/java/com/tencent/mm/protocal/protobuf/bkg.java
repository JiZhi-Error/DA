package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bkg extends dpc {
    public boolean LTt;
    public int LTu;
    public int LTv;
    public un LTw;
    public boolean LTx;
    public int pTZ;
    public String pUa;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(114007);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(114007);
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
            aVar.cc(4, this.LTt);
            aVar.aM(5, this.LTu);
            aVar.aM(6, this.LTv);
            if (this.LTw != null) {
                aVar.ni(7, this.LTw.computeSize());
                this.LTw.writeFields(aVar);
            }
            aVar.cc(8, this.LTx);
            AppMethodBeat.o(114007);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            int fS = nh + g.a.a.b.b.a.fS(4) + 1 + g.a.a.b.b.a.bu(5, this.LTu) + g.a.a.b.b.a.bu(6, this.LTv);
            if (this.LTw != null) {
                fS += g.a.a.a.nh(7, this.LTw.computeSize());
            }
            int fS2 = fS + g.a.a.b.b.a.fS(8) + 1;
            AppMethodBeat.o(114007);
            return fS2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(114007);
                throw bVar2;
            }
            AppMethodBeat.o(114007);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bkg bkg = (bkg) objArr[1];
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
                        bkg.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(114007);
                    return 0;
                case 2:
                    bkg.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(114007);
                    return 0;
                case 3:
                    bkg.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(114007);
                    return 0;
                case 4:
                    bkg.LTt = aVar3.UbS.yZ();
                    AppMethodBeat.o(114007);
                    return 0;
                case 5:
                    bkg.LTu = aVar3.UbS.zi();
                    AppMethodBeat.o(114007);
                    return 0;
                case 6:
                    bkg.LTv = aVar3.UbS.zi();
                    AppMethodBeat.o(114007);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        un unVar = new un();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = unVar.populateBuilderWithField(aVar5, unVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bkg.LTw = unVar;
                    }
                    AppMethodBeat.o(114007);
                    return 0;
                case 8:
                    bkg.LTx = aVar3.UbS.yZ();
                    AppMethodBeat.o(114007);
                    return 0;
                default:
                    AppMethodBeat.o(114007);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114007);
            return -1;
        }
    }
}
