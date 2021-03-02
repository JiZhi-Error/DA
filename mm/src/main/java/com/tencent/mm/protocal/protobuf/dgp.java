package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dgp extends a {
    public adw MLh;
    public coz MLj;
    public String dQx;
    public String pTL;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(200223);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dQx != null) {
                aVar.e(1, this.dQx);
            }
            aVar.aM(2, this.type);
            if (this.pTL != null) {
                aVar.e(3, this.pTL);
            }
            if (this.MLj != null) {
                aVar.ni(4, this.MLj.computeSize());
                this.MLj.writeFields(aVar);
            }
            if (this.MLh != null) {
                aVar.ni(5, this.MLh.computeSize());
                this.MLh.writeFields(aVar);
            }
            AppMethodBeat.o(200223);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.dQx != null ? g.a.a.b.b.a.f(1, this.dQx) + 0 : 0) + g.a.a.b.b.a.bu(2, this.type);
            if (this.pTL != null) {
                f2 += g.a.a.b.b.a.f(3, this.pTL);
            }
            if (this.MLj != null) {
                f2 += g.a.a.a.nh(4, this.MLj.computeSize());
            }
            if (this.MLh != null) {
                f2 += g.a.a.a.nh(5, this.MLh.computeSize());
            }
            AppMethodBeat.o(200223);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(200223);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dgp dgp = (dgp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dgp.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(200223);
                    return 0;
                case 2:
                    dgp.type = aVar3.UbS.zi();
                    AppMethodBeat.o(200223);
                    return 0;
                case 3:
                    dgp.pTL = aVar3.UbS.readString();
                    AppMethodBeat.o(200223);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        coz coz = new coz();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = coz.populateBuilderWithField(aVar4, coz, a.getNextFieldNumber(aVar4))) {
                        }
                        dgp.MLj = coz;
                    }
                    AppMethodBeat.o(200223);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        adw adw = new adw();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = adw.populateBuilderWithField(aVar5, adw, a.getNextFieldNumber(aVar5))) {
                        }
                        dgp.MLh = adw;
                    }
                    AppMethodBeat.o(200223);
                    return 0;
                default:
                    AppMethodBeat.o(200223);
                    return -1;
            }
        } else {
            AppMethodBeat.o(200223);
            return -1;
        }
    }
}
