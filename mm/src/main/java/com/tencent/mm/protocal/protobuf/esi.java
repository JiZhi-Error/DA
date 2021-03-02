package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class esi extends a {
    public int BsG;
    public int Npx;
    public int Npy;
    public SKBuiltinBuffer_t Npz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32499);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Npz == null) {
                b bVar = new b("Not all required fields were included: PieceData");
                AppMethodBeat.o(32499);
                throw bVar;
            }
            aVar.aM(1, this.BsG);
            aVar.aM(2, this.Npx);
            aVar.aM(3, this.Npy);
            if (this.Npz != null) {
                aVar.ni(4, this.Npz.computeSize());
                this.Npz.writeFields(aVar);
            }
            AppMethodBeat.o(32499);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.BsG) + 0 + g.a.a.b.b.a.bu(2, this.Npx) + g.a.a.b.b.a.bu(3, this.Npy);
            if (this.Npz != null) {
                bu += g.a.a.a.nh(4, this.Npz.computeSize());
            }
            AppMethodBeat.o(32499);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Npz == null) {
                b bVar2 = new b("Not all required fields were included: PieceData");
                AppMethodBeat.o(32499);
                throw bVar2;
            }
            AppMethodBeat.o(32499);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            esi esi = (esi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    esi.BsG = aVar3.UbS.zi();
                    AppMethodBeat.o(32499);
                    return 0;
                case 2:
                    esi.Npx = aVar3.UbS.zi();
                    AppMethodBeat.o(32499);
                    return 0;
                case 3:
                    esi.Npy = aVar3.UbS.zi();
                    AppMethodBeat.o(32499);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        esi.Npz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(32499);
                    return 0;
                default:
                    AppMethodBeat.o(32499);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32499);
            return -1;
        }
    }
}
