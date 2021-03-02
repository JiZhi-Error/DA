package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class czl extends a {
    public int MEJ;
    public SKBuiltinBuffer_t MEK;
    public int MEL;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(134248);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MEJ);
            if (this.MEK != null) {
                aVar.ni(2, this.MEK.computeSize());
                this.MEK.writeFields(aVar);
            }
            aVar.aM(3, this.MEL);
            AppMethodBeat.o(134248);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MEJ) + 0;
            if (this.MEK != null) {
                bu += g.a.a.a.nh(2, this.MEK.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.MEL);
            AppMethodBeat.o(134248);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(134248);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            czl czl = (czl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    czl.MEJ = aVar3.UbS.zi();
                    AppMethodBeat.o(134248);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        czl.MEK = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(134248);
                    return 0;
                case 3:
                    czl.MEL = aVar3.UbS.zi();
                    AppMethodBeat.o(134248);
                    return 0;
                default:
                    AppMethodBeat.o(134248);
                    return -1;
            }
        } else {
            AppMethodBeat.o(134248);
            return -1;
        }
    }
}
