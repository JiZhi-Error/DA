package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class aka extends dop {
    public String Ltk;
    public int Scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(56245);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.Ltk != null) {
                aVar.e(2, this.Ltk);
            }
            aVar.aM(3, this.Scene);
            AppMethodBeat.o(56245);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.Ltk != null) {
                nh += g.a.a.b.b.a.f(2, this.Ltk);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.Scene);
            AppMethodBeat.o(56245);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(56245);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aka aka = (aka) objArr[1];
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
                        aka.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(56245);
                    return 0;
                case 2:
                    aka.Ltk = aVar3.UbS.readString();
                    AppMethodBeat.o(56245);
                    return 0;
                case 3:
                    aka.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(56245);
                    return 0;
                default:
                    AppMethodBeat.o(56245);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56245);
            return -1;
        }
    }
}
