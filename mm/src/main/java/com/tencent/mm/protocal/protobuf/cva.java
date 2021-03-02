package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class cva extends a {
    public b KOi;
    public int KOj;
    public int MAt;
    public String MAu;
    public SKBuiltinBuffer_t MAv;
    public int MAw;
    public int MAx;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32359);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MAv == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: ClientKey");
                AppMethodBeat.o(32359);
                throw bVar;
            }
            aVar.aM(1, this.MAt);
            if (this.KOi != null) {
                aVar.c(2, this.KOi);
            }
            if (this.MAu != null) {
                aVar.e(3, this.MAu);
            }
            if (this.MAv != null) {
                aVar.ni(4, this.MAv.computeSize());
                this.MAv.writeFields(aVar);
            }
            aVar.aM(5, this.MAw);
            aVar.aM(6, this.MAx);
            aVar.aM(7, this.KOj);
            AppMethodBeat.o(32359);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MAt) + 0;
            if (this.KOi != null) {
                bu += g.a.a.b.b.a.b(2, this.KOi);
            }
            if (this.MAu != null) {
                bu += g.a.a.b.b.a.f(3, this.MAu);
            }
            if (this.MAv != null) {
                bu += g.a.a.a.nh(4, this.MAv.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.MAw) + g.a.a.b.b.a.bu(6, this.MAx) + g.a.a.b.b.a.bu(7, this.KOj);
            AppMethodBeat.o(32359);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MAv == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: ClientKey");
                AppMethodBeat.o(32359);
                throw bVar2;
            }
            AppMethodBeat.o(32359);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cva cva = (cva) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cva.MAt = aVar3.UbS.zi();
                    AppMethodBeat.o(32359);
                    return 0;
                case 2:
                    cva.KOi = aVar3.UbS.hPo();
                    AppMethodBeat.o(32359);
                    return 0;
                case 3:
                    cva.MAu = aVar3.UbS.readString();
                    AppMethodBeat.o(32359);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        cva.MAv = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(32359);
                    return 0;
                case 5:
                    cva.MAw = aVar3.UbS.zi();
                    AppMethodBeat.o(32359);
                    return 0;
                case 6:
                    cva.MAx = aVar3.UbS.zi();
                    AppMethodBeat.o(32359);
                    return 0;
                case 7:
                    cva.KOj = aVar3.UbS.zi();
                    AppMethodBeat.o(32359);
                    return 0;
                default:
                    AppMethodBeat.o(32359);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32359);
            return -1;
        }
    }
}
