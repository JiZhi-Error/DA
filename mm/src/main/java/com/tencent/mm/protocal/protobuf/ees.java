package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ees extends dop {
    public LinkedList<Integer> MNJ = new LinkedList<>();
    public String MVO;
    public String MVP;
    public String dHx;
    public String dNI;

    public ees() {
        AppMethodBeat.i(123656);
        AppMethodBeat.o(123656);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123657);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.dNI != null) {
                aVar.e(2, this.dNI);
            }
            aVar.e(3, 2, this.MNJ);
            if (this.MVO != null) {
                aVar.e(4, this.MVO);
            }
            if (this.dHx != null) {
                aVar.e(5, this.dHx);
            }
            if (this.MVP != null) {
                aVar.e(6, this.MVP);
            }
            AppMethodBeat.o(123657);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.dNI != null) {
                nh += g.a.a.b.b.a.f(2, this.dNI);
            }
            int c2 = nh + g.a.a.a.c(3, 2, this.MNJ);
            if (this.MVO != null) {
                c2 += g.a.a.b.b.a.f(4, this.MVO);
            }
            if (this.dHx != null) {
                c2 += g.a.a.b.b.a.f(5, this.dHx);
            }
            if (this.MVP != null) {
                c2 += g.a.a.b.b.a.f(6, this.MVP);
            }
            AppMethodBeat.o(123657);
            return c2;
        } else if (i2 == 2) {
            this.MNJ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123657);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ees ees = (ees) objArr[1];
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
                        ees.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(123657);
                    return 0;
                case 2:
                    ees.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(123657);
                    return 0;
                case 3:
                    ees.MNJ.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(123657);
                    return 0;
                case 4:
                    ees.MVO = aVar3.UbS.readString();
                    AppMethodBeat.o(123657);
                    return 0;
                case 5:
                    ees.dHx = aVar3.UbS.readString();
                    AppMethodBeat.o(123657);
                    return 0;
                case 6:
                    ees.MVP = aVar3.UbS.readString();
                    AppMethodBeat.o(123657);
                    return 0;
                default:
                    AppMethodBeat.o(123657);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123657);
            return -1;
        }
    }
}