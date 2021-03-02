package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cvq extends a {
    public int LDk;
    public int LYP;
    public cvs LYQ;
    public int MAZ;
    public cvr MBa;
    public int MBb;
    public int MBc;
    public int MBd;
    public String app_id;
    public String jHa;
    public int zqk;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152631);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.jHa != null) {
                aVar.e(1, this.jHa);
            }
            aVar.aM(2, this.MAZ);
            if (this.MBa != null) {
                aVar.ni(3, this.MBa.computeSize());
                this.MBa.writeFields(aVar);
            }
            aVar.aM(4, this.LYP);
            if (this.LYQ != null) {
                aVar.ni(5, this.LYQ.computeSize());
                this.LYQ.writeFields(aVar);
            }
            aVar.aM(6, this.MBb);
            aVar.aM(7, this.MBc);
            aVar.aM(8, this.zqk);
            aVar.aM(9, this.MBd);
            if (this.app_id != null) {
                aVar.e(10, this.app_id);
            }
            aVar.aM(11, this.LDk);
            AppMethodBeat.o(152631);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.jHa != null ? g.a.a.b.b.a.f(1, this.jHa) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MAZ);
            if (this.MBa != null) {
                f2 += g.a.a.a.nh(3, this.MBa.computeSize());
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.LYP);
            if (this.LYQ != null) {
                bu += g.a.a.a.nh(5, this.LYQ.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.MBb) + g.a.a.b.b.a.bu(7, this.MBc) + g.a.a.b.b.a.bu(8, this.zqk) + g.a.a.b.b.a.bu(9, this.MBd);
            if (this.app_id != null) {
                bu2 += g.a.a.b.b.a.f(10, this.app_id);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(11, this.LDk);
            AppMethodBeat.o(152631);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152631);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cvq cvq = (cvq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cvq.jHa = aVar3.UbS.readString();
                    AppMethodBeat.o(152631);
                    return 0;
                case 2:
                    cvq.MAZ = aVar3.UbS.zi();
                    AppMethodBeat.o(152631);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cvr cvr = new cvr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cvr.populateBuilderWithField(aVar4, cvr, a.getNextFieldNumber(aVar4))) {
                        }
                        cvq.MBa = cvr;
                    }
                    AppMethodBeat.o(152631);
                    return 0;
                case 4:
                    cvq.LYP = aVar3.UbS.zi();
                    AppMethodBeat.o(152631);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cvs cvs = new cvs();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cvs.populateBuilderWithField(aVar5, cvs, a.getNextFieldNumber(aVar5))) {
                        }
                        cvq.LYQ = cvs;
                    }
                    AppMethodBeat.o(152631);
                    return 0;
                case 6:
                    cvq.MBb = aVar3.UbS.zi();
                    AppMethodBeat.o(152631);
                    return 0;
                case 7:
                    cvq.MBc = aVar3.UbS.zi();
                    AppMethodBeat.o(152631);
                    return 0;
                case 8:
                    cvq.zqk = aVar3.UbS.zi();
                    AppMethodBeat.o(152631);
                    return 0;
                case 9:
                    cvq.MBd = aVar3.UbS.zi();
                    AppMethodBeat.o(152631);
                    return 0;
                case 10:
                    cvq.app_id = aVar3.UbS.readString();
                    AppMethodBeat.o(152631);
                    return 0;
                case 11:
                    cvq.LDk = aVar3.UbS.zi();
                    AppMethodBeat.o(152631);
                    return 0;
                default:
                    AppMethodBeat.o(152631);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152631);
            return -1;
        }
    }
}
