package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class chu extends a {
    public int Mne = 0;
    public ctg Mnf;
    public chw Mng;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(200210);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Mne);
            if (this.Mnf != null) {
                aVar.ni(2, this.Mnf.computeSize());
                this.Mnf.writeFields(aVar);
            }
            if (this.Mng != null) {
                aVar.ni(3, this.Mng.computeSize());
                this.Mng.writeFields(aVar);
            }
            AppMethodBeat.o(200210);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Mne) + 0;
            if (this.Mnf != null) {
                bu += g.a.a.a.nh(2, this.Mnf.computeSize());
            }
            if (this.Mng != null) {
                bu += g.a.a.a.nh(3, this.Mng.computeSize());
            }
            AppMethodBeat.o(200210);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(200210);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            chu chu = (chu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    chu.Mne = aVar3.UbS.zi();
                    AppMethodBeat.o(200210);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ctg ctg = new ctg();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ctg.populateBuilderWithField(aVar4, ctg, a.getNextFieldNumber(aVar4))) {
                        }
                        chu.Mnf = ctg;
                    }
                    AppMethodBeat.o(200210);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        chw chw = new chw();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = chw.populateBuilderWithField(aVar5, chw, a.getNextFieldNumber(aVar5))) {
                        }
                        chu.Mng = chw;
                    }
                    AppMethodBeat.o(200210);
                    return 0;
                default:
                    AppMethodBeat.o(200210);
                    return -1;
            }
        } else {
            AppMethodBeat.o(200210);
            return -1;
        }
    }
}
