package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class boq extends dop {
    public ahc KCP;
    public String KCy;
    public String wOK;
    public String wOL;
    public String wOM;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32243);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.wOK != null) {
                aVar.e(2, this.wOK);
            }
            if (this.wOL != null) {
                aVar.e(3, this.wOL);
            }
            if (this.wOM != null) {
                aVar.e(4, this.wOM);
            }
            if (this.KCy != null) {
                aVar.e(5, this.KCy);
            }
            if (this.KCP != null) {
                aVar.ni(6, this.KCP.computeSize());
                this.KCP.writeFields(aVar);
            }
            AppMethodBeat.o(32243);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.wOK != null) {
                nh += g.a.a.b.b.a.f(2, this.wOK);
            }
            if (this.wOL != null) {
                nh += g.a.a.b.b.a.f(3, this.wOL);
            }
            if (this.wOM != null) {
                nh += g.a.a.b.b.a.f(4, this.wOM);
            }
            if (this.KCy != null) {
                nh += g.a.a.b.b.a.f(5, this.KCy);
            }
            if (this.KCP != null) {
                nh += g.a.a.a.nh(6, this.KCP.computeSize());
            }
            AppMethodBeat.o(32243);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32243);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            boq boq = (boq) objArr[1];
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
                        boq.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32243);
                    return 0;
                case 2:
                    boq.wOK = aVar3.UbS.readString();
                    AppMethodBeat.o(32243);
                    return 0;
                case 3:
                    boq.wOL = aVar3.UbS.readString();
                    AppMethodBeat.o(32243);
                    return 0;
                case 4:
                    boq.wOM = aVar3.UbS.readString();
                    AppMethodBeat.o(32243);
                    return 0;
                case 5:
                    boq.KCy = aVar3.UbS.readString();
                    AppMethodBeat.o(32243);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ahc ahc = new ahc();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ahc.populateBuilderWithField(aVar5, ahc, dop.getNextFieldNumber(aVar5))) {
                        }
                        boq.KCP = ahc;
                    }
                    AppMethodBeat.o(32243);
                    return 0;
                default:
                    AppMethodBeat.o(32243);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32243);
            return -1;
        }
    }
}
