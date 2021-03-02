package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ekc extends dpc {
    public String HHX;
    public boolean HIl;
    public String dQx;
    public int pTZ;
    public boolean pTt;
    public String pUa;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72601);
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
            aVar.cc(4, this.pTt);
            aVar.cc(5, this.HIl);
            if (this.HHX != null) {
                aVar.e(6, this.HHX);
            }
            if (this.dQx != null) {
                aVar.e(7, this.dQx);
            }
            AppMethodBeat.o(72601);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            int fS = nh + g.a.a.b.b.a.fS(4) + 1 + g.a.a.b.b.a.fS(5) + 1;
            if (this.HHX != null) {
                fS += g.a.a.b.b.a.f(6, this.HHX);
            }
            if (this.dQx != null) {
                fS += g.a.a.b.b.a.f(7, this.dQx);
            }
            AppMethodBeat.o(72601);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72601);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ekc ekc = (ekc) objArr[1];
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
                        ekc.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(72601);
                    return 0;
                case 2:
                    ekc.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(72601);
                    return 0;
                case 3:
                    ekc.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(72601);
                    return 0;
                case 4:
                    ekc.pTt = aVar3.UbS.yZ();
                    AppMethodBeat.o(72601);
                    return 0;
                case 5:
                    ekc.HIl = aVar3.UbS.yZ();
                    AppMethodBeat.o(72601);
                    return 0;
                case 6:
                    ekc.HHX = aVar3.UbS.readString();
                    AppMethodBeat.o(72601);
                    return 0;
                case 7:
                    ekc.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(72601);
                    return 0;
                default:
                    AppMethodBeat.o(72601);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72601);
            return -1;
        }
    }
}
