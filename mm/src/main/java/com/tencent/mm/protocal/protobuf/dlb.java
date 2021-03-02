package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dlb extends a {
    public String KWw;
    public String Luj;
    public String Luk;
    public String MOI;
    public mr MOX;
    public cdu MOY;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212300);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MOX != null) {
                aVar.ni(1, this.MOX.computeSize());
                this.MOX.writeFields(aVar);
            }
            if (this.MOY != null) {
                aVar.ni(2, this.MOY.computeSize());
                this.MOY.writeFields(aVar);
            }
            if (this.KWw != null) {
                aVar.e(3, this.KWw);
            }
            if (this.Luk != null) {
                aVar.e(4, this.Luk);
            }
            if (this.Luj != null) {
                aVar.e(5, this.Luj);
            }
            if (this.MOI != null) {
                aVar.e(6, this.MOI);
            }
            AppMethodBeat.o(212300);
            return 0;
        } else if (i2 == 1) {
            int nh = this.MOX != null ? g.a.a.a.nh(1, this.MOX.computeSize()) + 0 : 0;
            if (this.MOY != null) {
                nh += g.a.a.a.nh(2, this.MOY.computeSize());
            }
            if (this.KWw != null) {
                nh += g.a.a.b.b.a.f(3, this.KWw);
            }
            if (this.Luk != null) {
                nh += g.a.a.b.b.a.f(4, this.Luk);
            }
            if (this.Luj != null) {
                nh += g.a.a.b.b.a.f(5, this.Luj);
            }
            if (this.MOI != null) {
                nh += g.a.a.b.b.a.f(6, this.MOI);
            }
            AppMethodBeat.o(212300);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212300);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dlb dlb = (dlb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        mr mrVar = new mr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = mrVar.populateBuilderWithField(aVar4, mrVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dlb.MOX = mrVar;
                    }
                    AppMethodBeat.o(212300);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cdu cdu = new cdu();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cdu.populateBuilderWithField(aVar5, cdu, a.getNextFieldNumber(aVar5))) {
                        }
                        dlb.MOY = cdu;
                    }
                    AppMethodBeat.o(212300);
                    return 0;
                case 3:
                    dlb.KWw = aVar3.UbS.readString();
                    AppMethodBeat.o(212300);
                    return 0;
                case 4:
                    dlb.Luk = aVar3.UbS.readString();
                    AppMethodBeat.o(212300);
                    return 0;
                case 5:
                    dlb.Luj = aVar3.UbS.readString();
                    AppMethodBeat.o(212300);
                    return 0;
                case 6:
                    dlb.MOI = aVar3.UbS.readString();
                    AppMethodBeat.o(212300);
                    return 0;
                default:
                    AppMethodBeat.o(212300);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212300);
            return -1;
        }
    }
}
