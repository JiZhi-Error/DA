package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bna extends dop {
    public int LVB;
    public ahd LVC;
    public LinkedList<akh> LVD = new LinkedList<>();
    public int LVE;
    public String LVF;
    public int Scene;

    public bna() {
        AppMethodBeat.i(220702);
        AppMethodBeat.o(220702);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(220703);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.LVC == null) {
                b bVar = new b("Not all required fields were included: DeviceType");
                AppMethodBeat.o(220703);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.LVB);
            aVar.aM(3, this.Scene);
            if (this.LVC != null) {
                aVar.ni(4, this.LVC.computeSize());
                this.LVC.writeFields(aVar);
            }
            aVar.e(5, 8, this.LVD);
            aVar.aM(6, this.LVE);
            if (this.LVF != null) {
                aVar.e(7, this.LVF);
            }
            AppMethodBeat.o(220703);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LVB) + g.a.a.b.b.a.bu(3, this.Scene);
            if (this.LVC != null) {
                nh += g.a.a.a.nh(4, this.LVC.computeSize());
            }
            int c2 = nh + g.a.a.a.c(5, 8, this.LVD) + g.a.a.b.b.a.bu(6, this.LVE);
            if (this.LVF != null) {
                c2 += g.a.a.b.b.a.f(7, this.LVF);
            }
            AppMethodBeat.o(220703);
            return c2;
        } else if (i2 == 2) {
            this.LVD.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.LVC == null) {
                b bVar2 = new b("Not all required fields were included: DeviceType");
                AppMethodBeat.o(220703);
                throw bVar2;
            }
            AppMethodBeat.o(220703);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bna bna = (bna) objArr[1];
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
                        bna.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(220703);
                    return 0;
                case 2:
                    bna.LVB = aVar3.UbS.zi();
                    AppMethodBeat.o(220703);
                    return 0;
                case 3:
                    bna.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(220703);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ahd ahd = new ahd();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ahd.populateBuilderWithField(aVar5, ahd, dop.getNextFieldNumber(aVar5))) {
                        }
                        bna.LVC = ahd;
                    }
                    AppMethodBeat.o(220703);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        akh akh = new akh();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = akh.populateBuilderWithField(aVar6, akh, dop.getNextFieldNumber(aVar6))) {
                        }
                        bna.LVD.add(akh);
                    }
                    AppMethodBeat.o(220703);
                    return 0;
                case 6:
                    bna.LVE = aVar3.UbS.zi();
                    AppMethodBeat.o(220703);
                    return 0;
                case 7:
                    bna.LVF = aVar3.UbS.readString();
                    AppMethodBeat.o(220703);
                    return 0;
                default:
                    AppMethodBeat.o(220703);
                    return -1;
            }
        } else {
            AppMethodBeat.o(220703);
            return -1;
        }
    }
}
