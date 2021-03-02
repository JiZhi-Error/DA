package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class ctr extends a {
    public String KLO;
    public int Leu;
    public SKBuiltinBuffer_t Lev;
    public abo MyZ;
    public int Mza;
    public int Scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133186);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MyZ == null) {
                b bVar = new b("Not all required fields were included: Oplog");
                AppMethodBeat.o(133186);
                throw bVar;
            } else if (this.Lev == null) {
                b bVar2 = new b("Not all required fields were included: KeyBuf");
                AppMethodBeat.o(133186);
                throw bVar2;
            } else {
                if (this.MyZ != null) {
                    aVar.ni(1, this.MyZ.computeSize());
                    this.MyZ.writeFields(aVar);
                }
                aVar.aM(2, this.Leu);
                if (this.Lev != null) {
                    aVar.ni(3, this.Lev.computeSize());
                    this.Lev.writeFields(aVar);
                }
                aVar.aM(4, this.Scene);
                if (this.KLO != null) {
                    aVar.e(5, this.KLO);
                }
                aVar.aM(6, this.Mza);
                AppMethodBeat.o(133186);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = (this.MyZ != null ? g.a.a.a.nh(1, this.MyZ.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.Leu);
            if (this.Lev != null) {
                nh += g.a.a.a.nh(3, this.Lev.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.Scene);
            if (this.KLO != null) {
                bu += g.a.a.b.b.a.f(5, this.KLO);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.Mza);
            AppMethodBeat.o(133186);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MyZ == null) {
                b bVar3 = new b("Not all required fields were included: Oplog");
                AppMethodBeat.o(133186);
                throw bVar3;
            } else if (this.Lev == null) {
                b bVar4 = new b("Not all required fields were included: KeyBuf");
                AppMethodBeat.o(133186);
                throw bVar4;
            } else {
                AppMethodBeat.o(133186);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ctr ctr = (ctr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        abo abo = new abo();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = abo.populateBuilderWithField(aVar4, abo, a.getNextFieldNumber(aVar4))) {
                        }
                        ctr.MyZ = abo;
                    }
                    AppMethodBeat.o(133186);
                    return 0;
                case 2:
                    ctr.Leu = aVar3.UbS.zi();
                    AppMethodBeat.o(133186);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar5))) {
                        }
                        ctr.Lev = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(133186);
                    return 0;
                case 4:
                    ctr.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(133186);
                    return 0;
                case 5:
                    ctr.KLO = aVar3.UbS.readString();
                    AppMethodBeat.o(133186);
                    return 0;
                case 6:
                    ctr.Mza = aVar3.UbS.zi();
                    AppMethodBeat.o(133186);
                    return 0;
                default:
                    AppMethodBeat.o(133186);
                    return -1;
            }
        } else {
            AppMethodBeat.o(133186);
            return -1;
        }
    }
}
