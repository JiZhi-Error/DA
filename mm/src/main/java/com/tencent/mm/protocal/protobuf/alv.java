package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class alv extends a {
    public efk Lux;
    public int xuA;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117867);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Lux != null) {
                aVar.ni(1, this.Lux.computeSize());
                this.Lux.writeFields(aVar);
            }
            aVar.aM(2, this.xuA);
            AppMethodBeat.o(117867);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.Lux != null ? g.a.a.a.nh(1, this.Lux.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.xuA);
            AppMethodBeat.o(117867);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117867);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            alv alv = (alv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        efk efk = new efk();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = efk.populateBuilderWithField(aVar4, efk, a.getNextFieldNumber(aVar4))) {
                        }
                        alv.Lux = efk;
                    }
                    AppMethodBeat.o(117867);
                    return 0;
                case 2:
                    alv.xuA = aVar3.UbS.zi();
                    AppMethodBeat.o(117867);
                    return 0;
                default:
                    AppMethodBeat.o(117867);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117867);
            return -1;
        }
    }
}
