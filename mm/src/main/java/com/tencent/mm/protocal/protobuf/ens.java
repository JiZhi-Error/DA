package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ens extends dop {
    public boolean NlA;
    public int hil;
    public String jfi;
    public int oUu;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123666);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.jfi != null) {
                aVar.e(2, this.jfi);
            }
            aVar.aM(3, this.oUu);
            aVar.cc(4, this.NlA);
            aVar.aM(5, this.hil);
            AppMethodBeat.o(123666);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.jfi != null) {
                nh += g.a.a.b.b.a.f(2, this.jfi);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.oUu) + g.a.a.b.b.a.fS(4) + 1 + g.a.a.b.b.a.bu(5, this.hil);
            AppMethodBeat.o(123666);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123666);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ens ens = (ens) objArr[1];
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
                        ens.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(123666);
                    return 0;
                case 2:
                    ens.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(123666);
                    return 0;
                case 3:
                    ens.oUu = aVar3.UbS.zi();
                    AppMethodBeat.o(123666);
                    return 0;
                case 4:
                    ens.NlA = aVar3.UbS.yZ();
                    AppMethodBeat.o(123666);
                    return 0;
                case 5:
                    ens.hil = aVar3.UbS.zi();
                    AppMethodBeat.o(123666);
                    return 0;
                default:
                    AppMethodBeat.o(123666);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123666);
            return -1;
        }
    }
}
