package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class zg extends a {
    public cfl IoL;
    public cfl IoM;
    public String KYs;
    public int LkA;
    public String Lkz;
    public String dQx;
    public String title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(177332);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.dQx != null) {
                aVar.e(2, this.dQx);
            }
            if (this.IoL != null) {
                aVar.ni(3, this.IoL.computeSize());
                this.IoL.writeFields(aVar);
            }
            if (this.IoM != null) {
                aVar.ni(4, this.IoM.computeSize());
                this.IoM.writeFields(aVar);
            }
            if (this.Lkz != null) {
                aVar.e(5, this.Lkz);
            }
            if (this.KYs != null) {
                aVar.e(6, this.KYs);
            }
            aVar.aM(7, this.LkA);
            AppMethodBeat.o(177332);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0;
            if (this.dQx != null) {
                f2 += g.a.a.b.b.a.f(2, this.dQx);
            }
            if (this.IoL != null) {
                f2 += g.a.a.a.nh(3, this.IoL.computeSize());
            }
            if (this.IoM != null) {
                f2 += g.a.a.a.nh(4, this.IoM.computeSize());
            }
            if (this.Lkz != null) {
                f2 += g.a.a.b.b.a.f(5, this.Lkz);
            }
            if (this.KYs != null) {
                f2 += g.a.a.b.b.a.f(6, this.KYs);
            }
            int bu = f2 + g.a.a.b.b.a.bu(7, this.LkA);
            AppMethodBeat.o(177332);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(177332);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            zg zgVar = (zg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    zgVar.title = aVar3.UbS.readString();
                    AppMethodBeat.o(177332);
                    return 0;
                case 2:
                    zgVar.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(177332);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cfl cfl = new cfl();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cfl.populateBuilderWithField(aVar4, cfl, a.getNextFieldNumber(aVar4))) {
                        }
                        zgVar.IoL = cfl;
                    }
                    AppMethodBeat.o(177332);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cfl cfl2 = new cfl();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cfl2.populateBuilderWithField(aVar5, cfl2, a.getNextFieldNumber(aVar5))) {
                        }
                        zgVar.IoM = cfl2;
                    }
                    AppMethodBeat.o(177332);
                    return 0;
                case 5:
                    zgVar.Lkz = aVar3.UbS.readString();
                    AppMethodBeat.o(177332);
                    return 0;
                case 6:
                    zgVar.KYs = aVar3.UbS.readString();
                    AppMethodBeat.o(177332);
                    return 0;
                case 7:
                    zgVar.LkA = aVar3.UbS.zi();
                    AppMethodBeat.o(177332);
                    return 0;
                default:
                    AppMethodBeat.o(177332);
                    return -1;
            }
        } else {
            AppMethodBeat.o(177332);
            return -1;
        }
    }
}
