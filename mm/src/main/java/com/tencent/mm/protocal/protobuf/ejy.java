package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ejy extends dpc {
    public String Nji;
    public LinkedList<cbp> Njk = new LinkedList<>();
    public boolean chA;
    public int pTZ;
    public String pUa;

    public ejy() {
        AppMethodBeat.i(72595);
        AppMethodBeat.o(72595);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72596);
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
            aVar.e(4, 8, this.Njk);
            aVar.cc(5, this.chA);
            if (this.Nji != null) {
                aVar.e(6, this.Nji);
            }
            AppMethodBeat.o(72596);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            int c2 = nh + g.a.a.a.c(4, 8, this.Njk) + g.a.a.b.b.a.fS(5) + 1;
            if (this.Nji != null) {
                c2 += g.a.a.b.b.a.f(6, this.Nji);
            }
            AppMethodBeat.o(72596);
            return c2;
        } else if (i2 == 2) {
            this.Njk.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72596);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ejy ejy = (ejy) objArr[1];
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
                        ejy.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(72596);
                    return 0;
                case 2:
                    ejy.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(72596);
                    return 0;
                case 3:
                    ejy.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(72596);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cbp cbp = new cbp();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cbp.populateBuilderWithField(aVar5, cbp, dpc.getNextFieldNumber(aVar5))) {
                        }
                        ejy.Njk.add(cbp);
                    }
                    AppMethodBeat.o(72596);
                    return 0;
                case 5:
                    ejy.chA = aVar3.UbS.yZ();
                    AppMethodBeat.o(72596);
                    return 0;
                case 6:
                    ejy.Nji = aVar3.UbS.readString();
                    AppMethodBeat.o(72596);
                    return 0;
                default:
                    AppMethodBeat.o(72596);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72596);
            return -1;
        }
    }
}
