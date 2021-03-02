package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class wf extends dop {
    public int Lba = 4;
    public b Lhb;
    public b Lhc;
    public String qwM;
    public int yRL;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91410);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.yRL);
            if (this.Lhb != null) {
                aVar.c(3, this.Lhb);
            }
            if (this.Lhc != null) {
                aVar.c(4, this.Lhc);
            }
            if (this.qwM != null) {
                aVar.e(5, this.qwM);
            }
            aVar.aM(6, this.Lba);
            AppMethodBeat.o(91410);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.yRL);
            if (this.Lhb != null) {
                nh += g.a.a.b.b.a.b(3, this.Lhb);
            }
            if (this.Lhc != null) {
                nh += g.a.a.b.b.a.b(4, this.Lhc);
            }
            if (this.qwM != null) {
                nh += g.a.a.b.b.a.f(5, this.qwM);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.Lba);
            AppMethodBeat.o(91410);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91410);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            wf wfVar = (wf) objArr[1];
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
                        wfVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91410);
                    return 0;
                case 2:
                    wfVar.yRL = aVar3.UbS.zi();
                    AppMethodBeat.o(91410);
                    return 0;
                case 3:
                    wfVar.Lhb = aVar3.UbS.hPo();
                    AppMethodBeat.o(91410);
                    return 0;
                case 4:
                    wfVar.Lhc = aVar3.UbS.hPo();
                    AppMethodBeat.o(91410);
                    return 0;
                case 5:
                    wfVar.qwM = aVar3.UbS.readString();
                    AppMethodBeat.o(91410);
                    return 0;
                case 6:
                    wfVar.Lba = aVar3.UbS.zi();
                    AppMethodBeat.o(91410);
                    return 0;
                default:
                    AppMethodBeat.o(91410);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91410);
            return -1;
        }
    }
}
