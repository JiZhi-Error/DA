package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class cts extends a {
    public int KZh;
    public SKBuiltinBuffer_t Lev;
    public abo Ley;
    public int Mzb;
    public int Mzc;
    public int Ret;
    public int oTW;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133187);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Ley == null) {
                b bVar = new b("Not all required fields were included: CmdList");
                AppMethodBeat.o(133187);
                throw bVar;
            } else if (this.Lev == null) {
                b bVar2 = new b("Not all required fields were included: KeyBuf");
                AppMethodBeat.o(133187);
                throw bVar2;
            } else {
                aVar.aM(1, this.Ret);
                if (this.Ley != null) {
                    aVar.ni(2, this.Ley.computeSize());
                    this.Ley.writeFields(aVar);
                }
                aVar.aM(3, this.KZh);
                if (this.Lev != null) {
                    aVar.ni(4, this.Lev.computeSize());
                    this.Lev.writeFields(aVar);
                }
                aVar.aM(5, this.oTW);
                aVar.aM(6, this.Mzb);
                aVar.aM(7, this.Mzc);
                AppMethodBeat.o(133187);
                return 0;
            }
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Ret) + 0;
            if (this.Ley != null) {
                bu += g.a.a.a.nh(2, this.Ley.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.KZh);
            if (this.Lev != null) {
                bu2 += g.a.a.a.nh(4, this.Lev.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(5, this.oTW) + g.a.a.b.b.a.bu(6, this.Mzb) + g.a.a.b.b.a.bu(7, this.Mzc);
            AppMethodBeat.o(133187);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Ley == null) {
                b bVar3 = new b("Not all required fields were included: CmdList");
                AppMethodBeat.o(133187);
                throw bVar3;
            } else if (this.Lev == null) {
                b bVar4 = new b("Not all required fields were included: KeyBuf");
                AppMethodBeat.o(133187);
                throw bVar4;
            } else {
                AppMethodBeat.o(133187);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cts cts = (cts) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cts.Ret = aVar3.UbS.zi();
                    AppMethodBeat.o(133187);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        abo abo = new abo();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = abo.populateBuilderWithField(aVar4, abo, a.getNextFieldNumber(aVar4))) {
                        }
                        cts.Ley = abo;
                    }
                    AppMethodBeat.o(133187);
                    return 0;
                case 3:
                    cts.KZh = aVar3.UbS.zi();
                    AppMethodBeat.o(133187);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar5))) {
                        }
                        cts.Lev = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(133187);
                    return 0;
                case 5:
                    cts.oTW = aVar3.UbS.zi();
                    AppMethodBeat.o(133187);
                    return 0;
                case 6:
                    cts.Mzb = aVar3.UbS.zi();
                    AppMethodBeat.o(133187);
                    return 0;
                case 7:
                    cts.Mzc = aVar3.UbS.zi();
                    AppMethodBeat.o(133187);
                    return 0;
                default:
                    AppMethodBeat.o(133187);
                    return -1;
            }
        } else {
            AppMethodBeat.o(133187);
            return -1;
        }
    }
}
