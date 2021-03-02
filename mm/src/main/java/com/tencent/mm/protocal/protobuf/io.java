package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class io extends dop {
    public int KMC;
    public LinkedList<adi> KMD = new LinkedList<>();
    public String KME;
    public String KMF;
    public String KMG;
    public String KMH;
    public int Scene;
    public long oTS;

    public io() {
        AppMethodBeat.i(32131);
        AppMethodBeat.o(32131);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32132);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.KMC);
            aVar.e(3, 8, this.KMD);
            if (this.KME != null) {
                aVar.e(4, this.KME);
            }
            if (this.KMF != null) {
                aVar.e(5, this.KMF);
            }
            aVar.aM(6, this.Scene);
            aVar.bb(7, this.oTS);
            if (this.KMG != null) {
                aVar.e(8, this.KMG);
            }
            if (this.KMH != null) {
                aVar.e(9, this.KMH);
            }
            AppMethodBeat.o(32132);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KMC) + g.a.a.a.c(3, 8, this.KMD);
            if (this.KME != null) {
                nh += g.a.a.b.b.a.f(4, this.KME);
            }
            if (this.KMF != null) {
                nh += g.a.a.b.b.a.f(5, this.KMF);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.Scene) + g.a.a.b.b.a.r(7, this.oTS);
            if (this.KMG != null) {
                bu += g.a.a.b.b.a.f(8, this.KMG);
            }
            if (this.KMH != null) {
                bu += g.a.a.b.b.a.f(9, this.KMH);
            }
            AppMethodBeat.o(32132);
            return bu;
        } else if (i2 == 2) {
            this.KMD.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32132);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            io ioVar = (io) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        ioVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32132);
                    return 0;
                case 2:
                    ioVar.KMC = aVar3.UbS.zi();
                    AppMethodBeat.o(32132);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        adi adi = new adi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = adi.populateBuilderWithField(aVar5, adi, dop.getNextFieldNumber(aVar5))) {
                        }
                        ioVar.KMD.add(adi);
                    }
                    AppMethodBeat.o(32132);
                    return 0;
                case 4:
                    ioVar.KME = aVar3.UbS.readString();
                    AppMethodBeat.o(32132);
                    return 0;
                case 5:
                    ioVar.KMF = aVar3.UbS.readString();
                    AppMethodBeat.o(32132);
                    return 0;
                case 6:
                    ioVar.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(32132);
                    return 0;
                case 7:
                    ioVar.oTS = aVar3.UbS.zl();
                    AppMethodBeat.o(32132);
                    return 0;
                case 8:
                    ioVar.KMG = aVar3.UbS.readString();
                    AppMethodBeat.o(32132);
                    return 0;
                case 9:
                    ioVar.KMH = aVar3.UbS.readString();
                    AppMethodBeat.o(32132);
                    return 0;
                default:
                    AppMethodBeat.o(32132);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32132);
            return -1;
        }
    }
}
