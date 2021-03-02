package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ahr extends dop {
    public int KZk;
    public cyb Lrv;
    public int Lrw;
    public int oUv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152536);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.Lrv == null) {
                b bVar = new b("Not all required fields were included: Package");
                AppMethodBeat.o(152536);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.Lrv != null) {
                aVar.ni(2, this.Lrv.computeSize());
                this.Lrv.writeFields(aVar);
            }
            aVar.aM(3, this.KZk);
            aVar.aM(4, this.Lrw);
            aVar.aM(5, this.oUv);
            AppMethodBeat.o(152536);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.Lrv != null) {
                nh += g.a.a.a.nh(2, this.Lrv.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.KZk) + g.a.a.b.b.a.bu(4, this.Lrw) + g.a.a.b.b.a.bu(5, this.oUv);
            AppMethodBeat.o(152536);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Lrv == null) {
                b bVar2 = new b("Not all required fields were included: Package");
                AppMethodBeat.o(152536);
                throw bVar2;
            }
            AppMethodBeat.o(152536);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ahr ahr = (ahr) objArr[1];
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
                        ahr.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(152536);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cyb cyb = new cyb();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cyb.populateBuilderWithField(aVar5, cyb, dop.getNextFieldNumber(aVar5))) {
                        }
                        ahr.Lrv = cyb;
                    }
                    AppMethodBeat.o(152536);
                    return 0;
                case 3:
                    ahr.KZk = aVar3.UbS.zi();
                    AppMethodBeat.o(152536);
                    return 0;
                case 4:
                    ahr.Lrw = aVar3.UbS.zi();
                    AppMethodBeat.o(152536);
                    return 0;
                case 5:
                    ahr.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(152536);
                    return 0;
                default:
                    AppMethodBeat.o(152536);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152536);
            return -1;
        }
    }
}
