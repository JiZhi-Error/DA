package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bo extends a {
    public LinkedList<egw> KFn = new LinkedList<>();
    public bm KFo;

    public bo() {
        AppMethodBeat.i(122483);
        AppMethodBeat.o(122483);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122484);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.KFn);
            if (this.KFo != null) {
                aVar.ni(2, this.KFo.computeSize());
                this.KFo.writeFields(aVar);
            }
            AppMethodBeat.o(122484);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.KFn) + 0;
            if (this.KFo != null) {
                c2 += g.a.a.a.nh(2, this.KFo.computeSize());
            }
            AppMethodBeat.o(122484);
            return c2;
        } else if (i2 == 2) {
            this.KFn.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(122484);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bo boVar = (bo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        egw egw = new egw();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = egw.populateBuilderWithField(aVar4, egw, a.getNextFieldNumber(aVar4))) {
                        }
                        boVar.KFn.add(egw);
                    }
                    AppMethodBeat.o(122484);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bm bmVar = new bm();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bmVar.populateBuilderWithField(aVar5, bmVar, a.getNextFieldNumber(aVar5))) {
                        }
                        boVar.KFo = bmVar;
                    }
                    AppMethodBeat.o(122484);
                    return 0;
                default:
                    AppMethodBeat.o(122484);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122484);
            return -1;
        }
    }
}
