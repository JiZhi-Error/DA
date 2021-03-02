package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class esk extends a {
    public String KXr;
    public SKBuiltinBuffer_t Nlq;
    public int NpA;
    public int jeU;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(148667);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Nlq == null) {
                b bVar = new b("Not all required fields were included: Text");
                AppMethodBeat.o(148667);
                throw bVar;
            }
            if (this.Nlq != null) {
                aVar.ni(1, this.Nlq.computeSize());
                this.Nlq.writeFields(aVar);
            }
            if (this.KXr != null) {
                aVar.e(2, this.KXr);
            }
            aVar.aM(3, this.jeU);
            aVar.aM(4, this.NpA);
            AppMethodBeat.o(148667);
            return 0;
        } else if (i2 == 1) {
            int nh = this.Nlq != null ? g.a.a.a.nh(1, this.Nlq.computeSize()) + 0 : 0;
            if (this.KXr != null) {
                nh += g.a.a.b.b.a.f(2, this.KXr);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.jeU) + g.a.a.b.b.a.bu(4, this.NpA);
            AppMethodBeat.o(148667);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Nlq == null) {
                b bVar2 = new b("Not all required fields were included: Text");
                AppMethodBeat.o(148667);
                throw bVar2;
            }
            AppMethodBeat.o(148667);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            esk esk = (esk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        esk.Nlq = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(148667);
                    return 0;
                case 2:
                    esk.KXr = aVar3.UbS.readString();
                    AppMethodBeat.o(148667);
                    return 0;
                case 3:
                    esk.jeU = aVar3.UbS.zi();
                    AppMethodBeat.o(148667);
                    return 0;
                case 4:
                    esk.NpA = aVar3.UbS.zi();
                    AppMethodBeat.o(148667);
                    return 0;
                default:
                    AppMethodBeat.o(148667);
                    return -1;
            }
        } else {
            AppMethodBeat.o(148667);
            return -1;
        }
    }
}
