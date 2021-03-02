package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class k extends a {
    public String appId;
    public String brandName;
    public String jgX;
    public String jgY;
    public String jgZ;
    public String jha;
    public String jhb;
    public String jhc;
    public String jhd;
    public String jhe;
    public String jhf;
    public String jhg;
    public String jhh;
    public String jhi;
    public String jhj;
    public String jhk;
    public String jhl;
    public l jhm;
    public int zpS;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(150806);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.appId != null) {
                aVar.e(1, this.appId);
            }
            if (this.jgX != null) {
                aVar.e(2, this.jgX);
            }
            if (this.jgY != null) {
                aVar.e(3, this.jgY);
            }
            if (this.jgZ != null) {
                aVar.e(4, this.jgZ);
            }
            if (this.jha != null) {
                aVar.e(5, this.jha);
            }
            if (this.jhb != null) {
                aVar.e(6, this.jhb);
            }
            if (this.brandName != null) {
                aVar.e(7, this.brandName);
            }
            if (this.jhc != null) {
                aVar.e(8, this.jhc);
            }
            if (this.jhd != null) {
                aVar.e(9, this.jhd);
            }
            if (this.jhe != null) {
                aVar.e(10, this.jhe);
            }
            if (this.jhf != null) {
                aVar.e(11, this.jhf);
            }
            if (this.jhg != null) {
                aVar.e(12, this.jhg);
            }
            if (this.jhh != null) {
                aVar.e(13, this.jhh);
            }
            if (this.jhi != null) {
                aVar.e(14, this.jhi);
            }
            if (this.jhj != null) {
                aVar.e(16, this.jhj);
            }
            if (this.jhk != null) {
                aVar.e(17, this.jhk);
            }
            if (this.jhl != null) {
                aVar.e(18, this.jhl);
            }
            if (this.jhm != null) {
                aVar.ni(19, this.jhm.computeSize());
                this.jhm.writeFields(aVar);
            }
            aVar.aM(20, this.zpS);
            AppMethodBeat.o(150806);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.appId != null ? g.a.a.b.b.a.f(1, this.appId) + 0 : 0;
            if (this.jgX != null) {
                f2 += g.a.a.b.b.a.f(2, this.jgX);
            }
            if (this.jgY != null) {
                f2 += g.a.a.b.b.a.f(3, this.jgY);
            }
            if (this.jgZ != null) {
                f2 += g.a.a.b.b.a.f(4, this.jgZ);
            }
            if (this.jha != null) {
                f2 += g.a.a.b.b.a.f(5, this.jha);
            }
            if (this.jhb != null) {
                f2 += g.a.a.b.b.a.f(6, this.jhb);
            }
            if (this.brandName != null) {
                f2 += g.a.a.b.b.a.f(7, this.brandName);
            }
            if (this.jhc != null) {
                f2 += g.a.a.b.b.a.f(8, this.jhc);
            }
            if (this.jhd != null) {
                f2 += g.a.a.b.b.a.f(9, this.jhd);
            }
            if (this.jhe != null) {
                f2 += g.a.a.b.b.a.f(10, this.jhe);
            }
            if (this.jhf != null) {
                f2 += g.a.a.b.b.a.f(11, this.jhf);
            }
            if (this.jhg != null) {
                f2 += g.a.a.b.b.a.f(12, this.jhg);
            }
            if (this.jhh != null) {
                f2 += g.a.a.b.b.a.f(13, this.jhh);
            }
            if (this.jhi != null) {
                f2 += g.a.a.b.b.a.f(14, this.jhi);
            }
            if (this.jhj != null) {
                f2 += g.a.a.b.b.a.f(16, this.jhj);
            }
            if (this.jhk != null) {
                f2 += g.a.a.b.b.a.f(17, this.jhk);
            }
            if (this.jhl != null) {
                f2 += g.a.a.b.b.a.f(18, this.jhl);
            }
            if (this.jhm != null) {
                f2 += g.a.a.a.nh(19, this.jhm.computeSize());
            }
            int bu = f2 + g.a.a.b.b.a.bu(20, this.zpS);
            AppMethodBeat.o(150806);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(150806);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            k kVar = (k) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    kVar.appId = aVar3.UbS.readString();
                    AppMethodBeat.o(150806);
                    return 0;
                case 2:
                    kVar.jgX = aVar3.UbS.readString();
                    AppMethodBeat.o(150806);
                    return 0;
                case 3:
                    kVar.jgY = aVar3.UbS.readString();
                    AppMethodBeat.o(150806);
                    return 0;
                case 4:
                    kVar.jgZ = aVar3.UbS.readString();
                    AppMethodBeat.o(150806);
                    return 0;
                case 5:
                    kVar.jha = aVar3.UbS.readString();
                    AppMethodBeat.o(150806);
                    return 0;
                case 6:
                    kVar.jhb = aVar3.UbS.readString();
                    AppMethodBeat.o(150806);
                    return 0;
                case 7:
                    kVar.brandName = aVar3.UbS.readString();
                    AppMethodBeat.o(150806);
                    return 0;
                case 8:
                    kVar.jhc = aVar3.UbS.readString();
                    AppMethodBeat.o(150806);
                    return 0;
                case 9:
                    kVar.jhd = aVar3.UbS.readString();
                    AppMethodBeat.o(150806);
                    return 0;
                case 10:
                    kVar.jhe = aVar3.UbS.readString();
                    AppMethodBeat.o(150806);
                    return 0;
                case 11:
                    kVar.jhf = aVar3.UbS.readString();
                    AppMethodBeat.o(150806);
                    return 0;
                case 12:
                    kVar.jhg = aVar3.UbS.readString();
                    AppMethodBeat.o(150806);
                    return 0;
                case 13:
                    kVar.jhh = aVar3.UbS.readString();
                    AppMethodBeat.o(150806);
                    return 0;
                case 14:
                    kVar.jhi = aVar3.UbS.readString();
                    AppMethodBeat.o(150806);
                    return 0;
                case 15:
                default:
                    AppMethodBeat.o(150806);
                    return -1;
                case 16:
                    kVar.jhj = aVar3.UbS.readString();
                    AppMethodBeat.o(150806);
                    return 0;
                case 17:
                    kVar.jhk = aVar3.UbS.readString();
                    AppMethodBeat.o(150806);
                    return 0;
                case 18:
                    kVar.jhl = aVar3.UbS.readString();
                    AppMethodBeat.o(150806);
                    return 0;
                case 19:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        l lVar = new l();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = lVar.populateBuilderWithField(aVar4, lVar, a.getNextFieldNumber(aVar4))) {
                        }
                        kVar.jhm = lVar;
                    }
                    AppMethodBeat.o(150806);
                    return 0;
                case 20:
                    kVar.zpS = aVar3.UbS.zi();
                    AppMethodBeat.o(150806);
                    return 0;
            }
        } else {
            AppMethodBeat.o(150806);
            return -1;
        }
    }
}
