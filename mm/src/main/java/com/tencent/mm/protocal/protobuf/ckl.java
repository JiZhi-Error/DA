package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class ckl extends a {
    public erc Lce;
    public LinkedList<ckm> MpX = new LinkedList<>();

    public ckl() {
        AppMethodBeat.i(140928);
        AppMethodBeat.o(140928);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(140929);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Lce == null) {
                b bVar = new b("Not all required fields were included: matrix");
                AppMethodBeat.o(140929);
                throw bVar;
            }
            aVar.e(1, 8, this.MpX);
            if (this.Lce != null) {
                aVar.ni(2, this.Lce.computeSize());
                this.Lce.writeFields(aVar);
            }
            AppMethodBeat.o(140929);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.MpX) + 0;
            if (this.Lce != null) {
                c2 += g.a.a.a.nh(2, this.Lce.computeSize());
            }
            AppMethodBeat.o(140929);
            return c2;
        } else if (i2 == 2) {
            this.MpX.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Lce == null) {
                b bVar2 = new b("Not all required fields were included: matrix");
                AppMethodBeat.o(140929);
                throw bVar2;
            }
            AppMethodBeat.o(140929);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ckl ckl = (ckl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ckm ckm = new ckm();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ckm.populateBuilderWithField(aVar4, ckm, a.getNextFieldNumber(aVar4))) {
                        }
                        ckl.MpX.add(ckm);
                    }
                    AppMethodBeat.o(140929);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        erc erc = new erc();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = erc.populateBuilderWithField(aVar5, erc, a.getNextFieldNumber(aVar5))) {
                        }
                        ckl.Lce = erc;
                    }
                    AppMethodBeat.o(140929);
                    return 0;
                default:
                    AppMethodBeat.o(140929);
                    return -1;
            }
        } else {
            AppMethodBeat.o(140929);
            return -1;
        }
    }
}
