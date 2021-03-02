package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dkn extends a {
    public ahh KVG;
    public int MOr;
    public int MOs;
    public String MOt;
    public String buffer;
    public String dQx;
    public String xml;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212290);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xml != null) {
                aVar.e(1, this.xml);
            }
            aVar.aM(2, this.MOr);
            aVar.aM(3, this.MOs);
            if (this.MOt != null) {
                aVar.e(4, this.MOt);
            }
            if (this.dQx != null) {
                aVar.e(5, this.dQx);
            }
            if (this.buffer != null) {
                aVar.e(6, this.buffer);
            }
            if (this.KVG != null) {
                aVar.ni(7, this.KVG.computeSize());
                this.KVG.writeFields(aVar);
            }
            AppMethodBeat.o(212290);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.xml != null ? g.a.a.b.b.a.f(1, this.xml) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MOr) + g.a.a.b.b.a.bu(3, this.MOs);
            if (this.MOt != null) {
                f2 += g.a.a.b.b.a.f(4, this.MOt);
            }
            if (this.dQx != null) {
                f2 += g.a.a.b.b.a.f(5, this.dQx);
            }
            if (this.buffer != null) {
                f2 += g.a.a.b.b.a.f(6, this.buffer);
            }
            if (this.KVG != null) {
                f2 += g.a.a.a.nh(7, this.KVG.computeSize());
            }
            AppMethodBeat.o(212290);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212290);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dkn dkn = (dkn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dkn.xml = aVar3.UbS.readString();
                    AppMethodBeat.o(212290);
                    return 0;
                case 2:
                    dkn.MOr = aVar3.UbS.zi();
                    AppMethodBeat.o(212290);
                    return 0;
                case 3:
                    dkn.MOs = aVar3.UbS.zi();
                    AppMethodBeat.o(212290);
                    return 0;
                case 4:
                    dkn.MOt = aVar3.UbS.readString();
                    AppMethodBeat.o(212290);
                    return 0;
                case 5:
                    dkn.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(212290);
                    return 0;
                case 6:
                    dkn.buffer = aVar3.UbS.readString();
                    AppMethodBeat.o(212290);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ahh ahh = new ahh();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ahh.populateBuilderWithField(aVar4, ahh, a.getNextFieldNumber(aVar4))) {
                        }
                        dkn.KVG = ahh;
                    }
                    AppMethodBeat.o(212290);
                    return 0;
                default:
                    AppMethodBeat.o(212290);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212290);
            return -1;
        }
    }
}
