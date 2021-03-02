package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ejt extends dop {
    public String Cru;
    public String Njb;
    public String Njc;
    public String Njd;
    public String Nje;
    public int bDZ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72590);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.bDZ);
            if (this.Njb != null) {
                aVar.e(3, this.Njb);
            }
            if (this.Njc != null) {
                aVar.e(4, this.Njc);
            }
            if (this.Cru != null) {
                aVar.e(5, this.Cru);
            }
            if (this.Njd != null) {
                aVar.e(6, this.Njd);
            }
            if (this.Nje != null) {
                aVar.e(7, this.Nje);
            }
            AppMethodBeat.o(72590);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.bDZ);
            if (this.Njb != null) {
                nh += g.a.a.b.b.a.f(3, this.Njb);
            }
            if (this.Njc != null) {
                nh += g.a.a.b.b.a.f(4, this.Njc);
            }
            if (this.Cru != null) {
                nh += g.a.a.b.b.a.f(5, this.Cru);
            }
            if (this.Njd != null) {
                nh += g.a.a.b.b.a.f(6, this.Njd);
            }
            if (this.Nje != null) {
                nh += g.a.a.b.b.a.f(7, this.Nje);
            }
            AppMethodBeat.o(72590);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72590);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ejt ejt = (ejt) objArr[1];
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
                        ejt.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(72590);
                    return 0;
                case 2:
                    ejt.bDZ = aVar3.UbS.zi();
                    AppMethodBeat.o(72590);
                    return 0;
                case 3:
                    ejt.Njb = aVar3.UbS.readString();
                    AppMethodBeat.o(72590);
                    return 0;
                case 4:
                    ejt.Njc = aVar3.UbS.readString();
                    AppMethodBeat.o(72590);
                    return 0;
                case 5:
                    ejt.Cru = aVar3.UbS.readString();
                    AppMethodBeat.o(72590);
                    return 0;
                case 6:
                    ejt.Njd = aVar3.UbS.readString();
                    AppMethodBeat.o(72590);
                    return 0;
                case 7:
                    ejt.Nje = aVar3.UbS.readString();
                    AppMethodBeat.o(72590);
                    return 0;
                default:
                    AppMethodBeat.o(72590);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72590);
            return -1;
        }
    }
}
