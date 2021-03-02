package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bvl extends dop {
    public String MbA;
    public String MbB;
    public String aid;
    public String gTk;
    public int pTI;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(192781);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.pTI);
            if (this.MbA != null) {
                aVar.e(3, this.MbA);
            }
            if (this.aid != null) {
                aVar.e(4, this.aid);
            }
            if (this.MbB != null) {
                aVar.e(5, this.MbB);
            }
            if (this.gTk != null) {
                aVar.e(6, this.gTk);
            }
            AppMethodBeat.o(192781);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTI);
            if (this.MbA != null) {
                nh += g.a.a.b.b.a.f(3, this.MbA);
            }
            if (this.aid != null) {
                nh += g.a.a.b.b.a.f(4, this.aid);
            }
            if (this.MbB != null) {
                nh += g.a.a.b.b.a.f(5, this.MbB);
            }
            if (this.gTk != null) {
                nh += g.a.a.b.b.a.f(6, this.gTk);
            }
            AppMethodBeat.o(192781);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(192781);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bvl bvl = (bvl) objArr[1];
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
                        bvl.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(192781);
                    return 0;
                case 2:
                    bvl.pTI = aVar3.UbS.zi();
                    AppMethodBeat.o(192781);
                    return 0;
                case 3:
                    bvl.MbA = aVar3.UbS.readString();
                    AppMethodBeat.o(192781);
                    return 0;
                case 4:
                    bvl.aid = aVar3.UbS.readString();
                    AppMethodBeat.o(192781);
                    return 0;
                case 5:
                    bvl.MbB = aVar3.UbS.readString();
                    AppMethodBeat.o(192781);
                    return 0;
                case 6:
                    bvl.gTk = aVar3.UbS.readString();
                    AppMethodBeat.o(192781);
                    return 0;
                default:
                    AppMethodBeat.o(192781);
                    return -1;
            }
        } else {
            AppMethodBeat.o(192781);
            return -1;
        }
    }
}
