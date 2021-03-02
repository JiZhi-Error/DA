package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class efi extends a {
    public LinkedList<efj> NfE = new LinkedList<>();
    public LinkedList<efj> xuS = new LinkedList<>();

    public efi() {
        AppMethodBeat.i(186804);
        AppMethodBeat.o(186804);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(186805);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.xuS);
            aVar.e(2, 8, this.NfE);
            AppMethodBeat.o(186805);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.xuS) + 0 + g.a.a.a.c(2, 8, this.NfE);
            AppMethodBeat.o(186805);
            return c2;
        } else if (i2 == 2) {
            this.xuS.clear();
            this.NfE.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(186805);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            efi efi = (efi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        efj efj = new efj();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = efj.populateBuilderWithField(aVar4, efj, a.getNextFieldNumber(aVar4))) {
                        }
                        efi.xuS.add(efj);
                    }
                    AppMethodBeat.o(186805);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        efj efj2 = new efj();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = efj2.populateBuilderWithField(aVar5, efj2, a.getNextFieldNumber(aVar5))) {
                        }
                        efi.NfE.add(efj2);
                    }
                    AppMethodBeat.o(186805);
                    return 0;
                default:
                    AppMethodBeat.o(186805);
                    return -1;
            }
        } else {
            AppMethodBeat.o(186805);
            return -1;
        }
    }
}
