package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cas extends a {
    public ehz MfV;
    public dgp MfW;
    public dgp MfX;
    public String dQx;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(200207);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MfV != null) {
                aVar.ni(1, this.MfV.computeSize());
                this.MfV.writeFields(aVar);
            }
            if (this.dQx != null) {
                aVar.e(2, this.dQx);
            }
            if (this.MfW != null) {
                aVar.ni(3, this.MfW.computeSize());
                this.MfW.writeFields(aVar);
            }
            if (this.MfX != null) {
                aVar.ni(4, this.MfX.computeSize());
                this.MfX.writeFields(aVar);
            }
            AppMethodBeat.o(200207);
            return 0;
        } else if (i2 == 1) {
            int nh = this.MfV != null ? g.a.a.a.nh(1, this.MfV.computeSize()) + 0 : 0;
            if (this.dQx != null) {
                nh += g.a.a.b.b.a.f(2, this.dQx);
            }
            if (this.MfW != null) {
                nh += g.a.a.a.nh(3, this.MfW.computeSize());
            }
            if (this.MfX != null) {
                nh += g.a.a.a.nh(4, this.MfX.computeSize());
            }
            AppMethodBeat.o(200207);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(200207);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cas cas = (cas) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ehz ehz = new ehz();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ehz.populateBuilderWithField(aVar4, ehz, a.getNextFieldNumber(aVar4))) {
                        }
                        cas.MfV = ehz;
                    }
                    AppMethodBeat.o(200207);
                    return 0;
                case 2:
                    cas.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(200207);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dgp dgp = new dgp();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dgp.populateBuilderWithField(aVar5, dgp, a.getNextFieldNumber(aVar5))) {
                        }
                        cas.MfW = dgp;
                    }
                    AppMethodBeat.o(200207);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dgp dgp2 = new dgp();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dgp2.populateBuilderWithField(aVar6, dgp2, a.getNextFieldNumber(aVar6))) {
                        }
                        cas.MfX = dgp2;
                    }
                    AppMethodBeat.o(200207);
                    return 0;
                default:
                    AppMethodBeat.o(200207);
                    return -1;
            }
        } else {
            AppMethodBeat.o(200207);
            return -1;
        }
    }
}
