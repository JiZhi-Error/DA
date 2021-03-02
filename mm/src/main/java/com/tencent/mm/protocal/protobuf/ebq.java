package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ebq extends dop {
    public String FhU;
    public int Nbr;
    public int Nbs;
    public String hFF;
    public int scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91696);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.scene);
            if (this.FhU != null) {
                aVar.e(3, this.FhU);
            }
            if (this.hFF != null) {
                aVar.e(4, this.hFF);
            }
            aVar.aM(5, this.Nbr);
            aVar.aM(6, this.Nbs);
            AppMethodBeat.o(91696);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.scene);
            if (this.FhU != null) {
                nh += g.a.a.b.b.a.f(3, this.FhU);
            }
            if (this.hFF != null) {
                nh += g.a.a.b.b.a.f(4, this.hFF);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.Nbr) + g.a.a.b.b.a.bu(6, this.Nbs);
            AppMethodBeat.o(91696);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91696);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ebq ebq = (ebq) objArr[1];
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
                        ebq.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91696);
                    return 0;
                case 2:
                    ebq.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(91696);
                    return 0;
                case 3:
                    ebq.FhU = aVar3.UbS.readString();
                    AppMethodBeat.o(91696);
                    return 0;
                case 4:
                    ebq.hFF = aVar3.UbS.readString();
                    AppMethodBeat.o(91696);
                    return 0;
                case 5:
                    ebq.Nbr = aVar3.UbS.zi();
                    AppMethodBeat.o(91696);
                    return 0;
                case 6:
                    ebq.Nbs = aVar3.UbS.zi();
                    AppMethodBeat.o(91696);
                    return 0;
                default:
                    AppMethodBeat.o(91696);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91696);
            return -1;
        }
    }
}
