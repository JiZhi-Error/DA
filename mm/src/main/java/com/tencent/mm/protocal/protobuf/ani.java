package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class ani extends a {
    public int Leu;
    public SKBuiltinBuffer_t Lev;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127482);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Lev == null) {
                b bVar = new b("Not all required fields were included: KeyBuf");
                AppMethodBeat.o(127482);
                throw bVar;
            }
            aVar.aM(1, this.Leu);
            if (this.Lev != null) {
                aVar.ni(3, this.Lev.computeSize());
                this.Lev.writeFields(aVar);
            }
            AppMethodBeat.o(127482);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Leu) + 0;
            if (this.Lev != null) {
                bu += g.a.a.a.nh(3, this.Lev.computeSize());
            }
            AppMethodBeat.o(127482);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Lev == null) {
                b bVar2 = new b("Not all required fields were included: KeyBuf");
                AppMethodBeat.o(127482);
                throw bVar2;
            }
            AppMethodBeat.o(127482);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ani ani = (ani) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ani.Leu = aVar3.UbS.zi();
                    AppMethodBeat.o(127482);
                    return 0;
                case 2:
                default:
                    AppMethodBeat.o(127482);
                    return -1;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        ani.Lev = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(127482);
                    return 0;
            }
        } else {
            AppMethodBeat.o(127482);
            return -1;
        }
    }
}
