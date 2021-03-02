package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class dkg extends a {
    public eaq MOf;
    public dqi MOg;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125759);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MOf == null) {
                b bVar = new b("Not all required fields were included: SnsRecommendObject");
                AppMethodBeat.o(125759);
                throw bVar;
            }
            if (this.MOf != null) {
                aVar.ni(1, this.MOf.computeSize());
                this.MOf.writeFields(aVar);
            }
            if (this.MOg != null) {
                aVar.ni(2, this.MOg.computeSize());
                this.MOg.writeFields(aVar);
            }
            AppMethodBeat.o(125759);
            return 0;
        } else if (i2 == 1) {
            int nh = this.MOf != null ? g.a.a.a.nh(1, this.MOf.computeSize()) + 0 : 0;
            if (this.MOg != null) {
                nh += g.a.a.a.nh(2, this.MOg.computeSize());
            }
            AppMethodBeat.o(125759);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MOf == null) {
                b bVar2 = new b("Not all required fields were included: SnsRecommendObject");
                AppMethodBeat.o(125759);
                throw bVar2;
            }
            AppMethodBeat.o(125759);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dkg dkg = (dkg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eaq eaq = new eaq();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eaq.populateBuilderWithField(aVar4, eaq, a.getNextFieldNumber(aVar4))) {
                        }
                        dkg.MOf = eaq;
                    }
                    AppMethodBeat.o(125759);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi.populateBuilderWithField(aVar5, dqi, a.getNextFieldNumber(aVar5))) {
                        }
                        dkg.MOg = dqi;
                    }
                    AppMethodBeat.o(125759);
                    return 0;
                default:
                    AppMethodBeat.o(125759);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125759);
            return -1;
        }
    }
}
