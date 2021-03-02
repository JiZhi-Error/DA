package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class kg extends dop {
    public eck KDj;
    public int eaQ;
    public LinkedList<va> iAd = new LinkedList<>();

    public kg() {
        AppMethodBeat.i(113940);
        AppMethodBeat.o(113940);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(113941);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 8, this.iAd);
            if (this.KDj != null) {
                aVar.ni(3, this.KDj.computeSize());
                this.KDj.writeFields(aVar);
            }
            aVar.aM(4, this.eaQ);
            AppMethodBeat.o(113941);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.iAd);
            if (this.KDj != null) {
                nh += g.a.a.a.nh(3, this.KDj.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.eaQ);
            AppMethodBeat.o(113941);
            return bu;
        } else if (i2 == 2) {
            this.iAd.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(113941);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            kg kgVar = (kg) objArr[1];
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
                        kgVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(113941);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        va vaVar = new va();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = vaVar.populateBuilderWithField(aVar5, vaVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        kgVar.iAd.add(vaVar);
                    }
                    AppMethodBeat.o(113941);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        eck eck = new eck();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = eck.populateBuilderWithField(aVar6, eck, dop.getNextFieldNumber(aVar6))) {
                        }
                        kgVar.KDj = eck;
                    }
                    AppMethodBeat.o(113941);
                    return 0;
                case 4:
                    kgVar.eaQ = aVar3.UbS.zi();
                    AppMethodBeat.o(113941);
                    return 0;
                default:
                    AppMethodBeat.o(113941);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113941);
            return -1;
        }
    }
}
