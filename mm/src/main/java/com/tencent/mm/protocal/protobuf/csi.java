package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class csi extends a {
    public csl Mxp;
    public csj Mxq;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256723);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.type);
            if (this.Mxp != null) {
                aVar.ni(2, this.Mxp.computeSize());
                this.Mxp.writeFields(aVar);
            }
            if (this.Mxq != null) {
                aVar.ni(101, this.Mxq.computeSize());
                this.Mxq.writeFields(aVar);
            }
            AppMethodBeat.o(256723);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.type) + 0;
            if (this.Mxp != null) {
                bu += g.a.a.a.nh(2, this.Mxp.computeSize());
            }
            if (this.Mxq != null) {
                bu += g.a.a.a.nh(101, this.Mxq.computeSize());
            }
            AppMethodBeat.o(256723);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(256723);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            csi csi = (csi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    csi.type = aVar3.UbS.zi();
                    AppMethodBeat.o(256723);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        csl csl = new csl();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = csl.populateBuilderWithField(aVar4, csl, a.getNextFieldNumber(aVar4))) {
                        }
                        csi.Mxp = csl;
                    }
                    AppMethodBeat.o(256723);
                    return 0;
                case 101:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        csj csj = new csj();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = csj.populateBuilderWithField(aVar5, csj, a.getNextFieldNumber(aVar5))) {
                        }
                        csi.Mxq = csj;
                    }
                    AppMethodBeat.o(256723);
                    return 0;
                default:
                    AppMethodBeat.o(256723);
                    return -1;
            }
        } else {
            AppMethodBeat.o(256723);
            return -1;
        }
    }
}
