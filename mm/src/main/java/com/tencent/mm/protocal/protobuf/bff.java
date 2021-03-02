package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bff extends dop {
    public int LON;
    public String egX;
    public String fuJ;
    public String fuK;
    public int msgType;
    public String yQE;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(214299);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.egX != null) {
                aVar.e(2, this.egX);
            }
            if (this.yQE != null) {
                aVar.e(3, this.yQE);
            }
            if (this.fuJ != null) {
                aVar.e(4, this.fuJ);
            }
            if (this.fuK != null) {
                aVar.e(5, this.fuK);
            }
            aVar.aM(6, this.msgType);
            aVar.aM(7, this.LON);
            AppMethodBeat.o(214299);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.egX != null) {
                nh += g.a.a.b.b.a.f(2, this.egX);
            }
            if (this.yQE != null) {
                nh += g.a.a.b.b.a.f(3, this.yQE);
            }
            if (this.fuJ != null) {
                nh += g.a.a.b.b.a.f(4, this.fuJ);
            }
            if (this.fuK != null) {
                nh += g.a.a.b.b.a.f(5, this.fuK);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.msgType) + g.a.a.b.b.a.bu(7, this.LON);
            AppMethodBeat.o(214299);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(214299);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bff bff = (bff) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        bff.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(214299);
                    return 0;
                case 2:
                    bff.egX = aVar3.UbS.readString();
                    AppMethodBeat.o(214299);
                    return 0;
                case 3:
                    bff.yQE = aVar3.UbS.readString();
                    AppMethodBeat.o(214299);
                    return 0;
                case 4:
                    bff.fuJ = aVar3.UbS.readString();
                    AppMethodBeat.o(214299);
                    return 0;
                case 5:
                    bff.fuK = aVar3.UbS.readString();
                    AppMethodBeat.o(214299);
                    return 0;
                case 6:
                    bff.msgType = aVar3.UbS.zi();
                    AppMethodBeat.o(214299);
                    return 0;
                case 7:
                    bff.LON = aVar3.UbS.zi();
                    AppMethodBeat.o(214299);
                    return 0;
                default:
                    AppMethodBeat.o(214299);
                    return -1;
            }
        } else {
            AppMethodBeat.o(214299);
            return -1;
        }
    }
}
