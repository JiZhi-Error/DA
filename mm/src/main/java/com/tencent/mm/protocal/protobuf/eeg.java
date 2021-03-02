package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class eeg extends a {
    public long Id;
    public eeh Ney;
    public eeh Nez;
    public int oUv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(118471);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Ney == null) {
                b bVar = new b("Not all required fields were included: SyncMsgDetail");
                AppMethodBeat.o(118471);
                throw bVar;
            }
            aVar.bb(1, this.Id);
            aVar.aM(2, this.oUv);
            if (this.Ney != null) {
                aVar.ni(3, this.Ney.computeSize());
                this.Ney.writeFields(aVar);
            }
            if (this.Nez != null) {
                aVar.ni(4, this.Nez.computeSize());
                this.Nez.writeFields(aVar);
            }
            AppMethodBeat.o(118471);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.Id) + 0 + g.a.a.b.b.a.bu(2, this.oUv);
            if (this.Ney != null) {
                r += g.a.a.a.nh(3, this.Ney.computeSize());
            }
            if (this.Nez != null) {
                r += g.a.a.a.nh(4, this.Nez.computeSize());
            }
            AppMethodBeat.o(118471);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Ney == null) {
                b bVar2 = new b("Not all required fields were included: SyncMsgDetail");
                AppMethodBeat.o(118471);
                throw bVar2;
            }
            AppMethodBeat.o(118471);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eeg eeg = (eeg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eeg.Id = aVar3.UbS.zl();
                    AppMethodBeat.o(118471);
                    return 0;
                case 2:
                    eeg.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(118471);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eeh eeh = new eeh();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eeh.populateBuilderWithField(aVar4, eeh, a.getNextFieldNumber(aVar4))) {
                        }
                        eeg.Ney = eeh;
                    }
                    AppMethodBeat.o(118471);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eeh eeh2 = new eeh();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eeh2.populateBuilderWithField(aVar5, eeh2, a.getNextFieldNumber(aVar5))) {
                        }
                        eeg.Nez = eeh2;
                    }
                    AppMethodBeat.o(118471);
                    return 0;
                default:
                    AppMethodBeat.o(118471);
                    return -1;
            }
        } else {
            AppMethodBeat.o(118471);
            return -1;
        }
    }
}
