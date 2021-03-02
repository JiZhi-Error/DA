package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class w extends a {
    public String GaI;
    public String Gal;
    public String Gam;
    public String Gan;
    public String Gao;
    public String Gap;
    public LinkedList<String> Gbc = new LinkedList<>();
    public b Gbd;
    public LinkedList<r> Gbe = new LinkedList<>();
    public String Gbf;
    public String title;

    public w() {
        AppMethodBeat.i(222844);
        AppMethodBeat.o(222844);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(222845);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.GaI != null) {
                aVar.e(1, this.GaI);
            }
            if (this.Gao != null) {
                aVar.e(2, this.Gao);
            }
            if (this.Gap != null) {
                aVar.e(3, this.Gap);
            }
            if (this.Gal != null) {
                aVar.e(4, this.Gal);
            }
            if (this.Gam != null) {
                aVar.e(5, this.Gam);
            }
            if (this.Gan != null) {
                aVar.e(10, this.Gan);
            }
            aVar.e(13, 1, this.Gbc);
            if (this.Gbd != null) {
                aVar.ni(14, this.Gbd.computeSize());
                this.Gbd.writeFields(aVar);
            }
            aVar.e(15, 8, this.Gbe);
            if (this.Gbf != null) {
                aVar.e(16, this.Gbf);
            }
            if (this.title != null) {
                aVar.e(17, this.title);
            }
            AppMethodBeat.o(222845);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.GaI != null ? g.a.a.b.b.a.f(1, this.GaI) + 0 : 0;
            if (this.Gao != null) {
                f2 += g.a.a.b.b.a.f(2, this.Gao);
            }
            if (this.Gap != null) {
                f2 += g.a.a.b.b.a.f(3, this.Gap);
            }
            if (this.Gal != null) {
                f2 += g.a.a.b.b.a.f(4, this.Gal);
            }
            if (this.Gam != null) {
                f2 += g.a.a.b.b.a.f(5, this.Gam);
            }
            if (this.Gan != null) {
                f2 += g.a.a.b.b.a.f(10, this.Gan);
            }
            int c2 = f2 + g.a.a.a.c(13, 1, this.Gbc);
            if (this.Gbd != null) {
                c2 += g.a.a.a.nh(14, this.Gbd.computeSize());
            }
            int c3 = c2 + g.a.a.a.c(15, 8, this.Gbe);
            if (this.Gbf != null) {
                c3 += g.a.a.b.b.a.f(16, this.Gbf);
            }
            if (this.title != null) {
                c3 += g.a.a.b.b.a.f(17, this.title);
            }
            AppMethodBeat.o(222845);
            return c3;
        } else if (i2 == 2) {
            this.Gbc.clear();
            this.Gbe.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(222845);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            w wVar = (w) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    wVar.GaI = aVar3.UbS.readString();
                    AppMethodBeat.o(222845);
                    return 0;
                case 2:
                    wVar.Gao = aVar3.UbS.readString();
                    AppMethodBeat.o(222845);
                    return 0;
                case 3:
                    wVar.Gap = aVar3.UbS.readString();
                    AppMethodBeat.o(222845);
                    return 0;
                case 4:
                    wVar.Gal = aVar3.UbS.readString();
                    AppMethodBeat.o(222845);
                    return 0;
                case 5:
                    wVar.Gam = aVar3.UbS.readString();
                    AppMethodBeat.o(222845);
                    return 0;
                case 6:
                case 7:
                case 8:
                case 9:
                case 11:
                case 12:
                default:
                    AppMethodBeat.o(222845);
                    return -1;
                case 10:
                    wVar.Gan = aVar3.UbS.readString();
                    AppMethodBeat.o(222845);
                    return 0;
                case 13:
                    wVar.Gbc.add(aVar3.UbS.readString());
                    AppMethodBeat.o(222845);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        b bVar = new b();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bVar.populateBuilderWithField(aVar4, bVar, a.getNextFieldNumber(aVar4))) {
                        }
                        wVar.Gbd = bVar;
                    }
                    AppMethodBeat.o(222845);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        r rVar = new r();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = rVar.populateBuilderWithField(aVar5, rVar, a.getNextFieldNumber(aVar5))) {
                        }
                        wVar.Gbe.add(rVar);
                    }
                    AppMethodBeat.o(222845);
                    return 0;
                case 16:
                    wVar.Gbf = aVar3.UbS.readString();
                    AppMethodBeat.o(222845);
                    return 0;
                case 17:
                    wVar.title = aVar3.UbS.readString();
                    AppMethodBeat.o(222845);
                    return 0;
            }
        } else {
            AppMethodBeat.o(222845);
            return -1;
        }
    }
}
