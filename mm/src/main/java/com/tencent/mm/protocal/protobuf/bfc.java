package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bfc extends dop {
    public String LOM;
    public int LON;
    public String egX;
    public String fuJ;
    public String fuK;
    public int msgType;
    public String yQE;
    public String yXR;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(214295);
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
            if (this.LOM != null) {
                aVar.e(4, this.LOM);
            }
            if (this.fuJ != null) {
                aVar.e(5, this.fuJ);
            }
            if (this.fuK != null) {
                aVar.e(6, this.fuK);
            }
            if (this.yXR != null) {
                aVar.e(7, this.yXR);
            }
            aVar.aM(8, this.msgType);
            aVar.aM(9, this.LON);
            AppMethodBeat.o(214295);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.egX != null) {
                nh += g.a.a.b.b.a.f(2, this.egX);
            }
            if (this.yQE != null) {
                nh += g.a.a.b.b.a.f(3, this.yQE);
            }
            if (this.LOM != null) {
                nh += g.a.a.b.b.a.f(4, this.LOM);
            }
            if (this.fuJ != null) {
                nh += g.a.a.b.b.a.f(5, this.fuJ);
            }
            if (this.fuK != null) {
                nh += g.a.a.b.b.a.f(6, this.fuK);
            }
            if (this.yXR != null) {
                nh += g.a.a.b.b.a.f(7, this.yXR);
            }
            int bu = nh + g.a.a.b.b.a.bu(8, this.msgType) + g.a.a.b.b.a.bu(9, this.LON);
            AppMethodBeat.o(214295);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(214295);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bfc bfc = (bfc) objArr[1];
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
                        bfc.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(214295);
                    return 0;
                case 2:
                    bfc.egX = aVar3.UbS.readString();
                    AppMethodBeat.o(214295);
                    return 0;
                case 3:
                    bfc.yQE = aVar3.UbS.readString();
                    AppMethodBeat.o(214295);
                    return 0;
                case 4:
                    bfc.LOM = aVar3.UbS.readString();
                    AppMethodBeat.o(214295);
                    return 0;
                case 5:
                    bfc.fuJ = aVar3.UbS.readString();
                    AppMethodBeat.o(214295);
                    return 0;
                case 6:
                    bfc.fuK = aVar3.UbS.readString();
                    AppMethodBeat.o(214295);
                    return 0;
                case 7:
                    bfc.yXR = aVar3.UbS.readString();
                    AppMethodBeat.o(214295);
                    return 0;
                case 8:
                    bfc.msgType = aVar3.UbS.zi();
                    AppMethodBeat.o(214295);
                    return 0;
                case 9:
                    bfc.LON = aVar3.UbS.zi();
                    AppMethodBeat.o(214295);
                    return 0;
                default:
                    AppMethodBeat.o(214295);
                    return -1;
            }
        } else {
            AppMethodBeat.o(214295);
            return -1;
        }
    }
}
