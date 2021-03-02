package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class dru extends a {
    public long KZg;
    public String KZj;
    public int KZk;
    public String LUZ;
    public int MUr;
    public LinkedList<eou> MUs = new LinkedList<>();
    public chl MlQ;
    public int Scene;

    public dru() {
        AppMethodBeat.i(117908);
        AppMethodBeat.o(117908);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117909);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LUZ == null) {
                b bVar = new b("Not all required fields were included: KeyWord");
                AppMethodBeat.o(117909);
                throw bVar;
            }
            aVar.bb(1, this.KZg);
            if (this.LUZ != null) {
                aVar.e(2, this.LUZ);
            }
            aVar.aM(3, this.KZk);
            if (this.MlQ != null) {
                aVar.ni(4, this.MlQ.computeSize());
                this.MlQ.writeFields(aVar);
            }
            aVar.aM(5, this.MUr);
            aVar.e(6, 8, this.MUs);
            aVar.aM(7, this.Scene);
            if (this.KZj != null) {
                aVar.e(8, this.KZj);
            }
            AppMethodBeat.o(117909);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.KZg) + 0;
            if (this.LUZ != null) {
                r += g.a.a.b.b.a.f(2, this.LUZ);
            }
            int bu = r + g.a.a.b.b.a.bu(3, this.KZk);
            if (this.MlQ != null) {
                bu += g.a.a.a.nh(4, this.MlQ.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.MUr) + g.a.a.a.c(6, 8, this.MUs) + g.a.a.b.b.a.bu(7, this.Scene);
            if (this.KZj != null) {
                bu2 += g.a.a.b.b.a.f(8, this.KZj);
            }
            AppMethodBeat.o(117909);
            return bu2;
        } else if (i2 == 2) {
            this.MUs.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.LUZ == null) {
                b bVar2 = new b("Not all required fields were included: KeyWord");
                AppMethodBeat.o(117909);
                throw bVar2;
            }
            AppMethodBeat.o(117909);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dru dru = (dru) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dru.KZg = aVar3.UbS.zl();
                    AppMethodBeat.o(117909);
                    return 0;
                case 2:
                    dru.LUZ = aVar3.UbS.readString();
                    AppMethodBeat.o(117909);
                    return 0;
                case 3:
                    dru.KZk = aVar3.UbS.zi();
                    AppMethodBeat.o(117909);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        chl chl = new chl();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = chl.populateBuilderWithField(aVar4, chl, a.getNextFieldNumber(aVar4))) {
                        }
                        dru.MlQ = chl;
                    }
                    AppMethodBeat.o(117909);
                    return 0;
                case 5:
                    dru.MUr = aVar3.UbS.zi();
                    AppMethodBeat.o(117909);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eou eou = new eou();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eou.populateBuilderWithField(aVar5, eou, a.getNextFieldNumber(aVar5))) {
                        }
                        dru.MUs.add(eou);
                    }
                    AppMethodBeat.o(117909);
                    return 0;
                case 7:
                    dru.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(117909);
                    return 0;
                case 8:
                    dru.KZj = aVar3.UbS.readString();
                    AppMethodBeat.o(117909);
                    return 0;
                default:
                    AppMethodBeat.o(117909);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117909);
            return -1;
        }
    }
}
