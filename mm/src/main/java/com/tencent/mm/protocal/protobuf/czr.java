package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class czr extends dop {
    public String AOT;
    public int APa;
    public String APl;
    public bf Lcc;
    public int MEV;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91575);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.MEV);
            if (this.AOT != null) {
                aVar.e(3, this.AOT);
            }
            aVar.aM(4, this.APa);
            if (this.APl != null) {
                aVar.e(5, this.APl);
            }
            if (this.Lcc != null) {
                aVar.ni(6, this.Lcc.computeSize());
                this.Lcc.writeFields(aVar);
            }
            AppMethodBeat.o(91575);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MEV);
            if (this.AOT != null) {
                nh += g.a.a.b.b.a.f(3, this.AOT);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.APa);
            if (this.APl != null) {
                bu += g.a.a.b.b.a.f(5, this.APl);
            }
            if (this.Lcc != null) {
                bu += g.a.a.a.nh(6, this.Lcc.computeSize());
            }
            AppMethodBeat.o(91575);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91575);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            czr czr = (czr) objArr[1];
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
                        czr.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91575);
                    return 0;
                case 2:
                    czr.MEV = aVar3.UbS.zi();
                    AppMethodBeat.o(91575);
                    return 0;
                case 3:
                    czr.AOT = aVar3.UbS.readString();
                    AppMethodBeat.o(91575);
                    return 0;
                case 4:
                    czr.APa = aVar3.UbS.zi();
                    AppMethodBeat.o(91575);
                    return 0;
                case 5:
                    czr.APl = aVar3.UbS.readString();
                    AppMethodBeat.o(91575);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bf bfVar = new bf();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bfVar.populateBuilderWithField(aVar5, bfVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        czr.Lcc = bfVar;
                    }
                    AppMethodBeat.o(91575);
                    return 0;
                default:
                    AppMethodBeat.o(91575);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91575);
            return -1;
        }
    }
}
