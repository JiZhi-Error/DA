package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cdu extends a {
    public int CreateTime;
    public String KSh;
    public String KSj;
    public String KSl;
    public String KSm;
    public String KSn;
    public eqv Mjm;
    public esh Mjn;
    public dbp Mjo;
    public String Title;
    public int iAb;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212281);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            if (this.KSh != null) {
                aVar.e(2, this.KSh);
            }
            if (this.KSj != null) {
                aVar.e(3, this.KSj);
            }
            if (this.KSl != null) {
                aVar.e(4, this.KSl);
            }
            if (this.KSm != null) {
                aVar.e(5, this.KSm);
            }
            if (this.KSn != null) {
                aVar.e(6, this.KSn);
            }
            aVar.aM(7, this.iAb);
            aVar.aM(8, this.CreateTime);
            if (this.Mjm != null) {
                aVar.ni(9, this.Mjm.computeSize());
                this.Mjm.writeFields(aVar);
            }
            if (this.Mjn != null) {
                aVar.ni(10, this.Mjn.computeSize());
                this.Mjn.writeFields(aVar);
            }
            if (this.Mjo != null) {
                aVar.ni(11, this.Mjo.computeSize());
                this.Mjo.writeFields(aVar);
            }
            AppMethodBeat.o(212281);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Title != null ? g.a.a.b.b.a.f(1, this.Title) + 0 : 0;
            if (this.KSh != null) {
                f2 += g.a.a.b.b.a.f(2, this.KSh);
            }
            if (this.KSj != null) {
                f2 += g.a.a.b.b.a.f(3, this.KSj);
            }
            if (this.KSl != null) {
                f2 += g.a.a.b.b.a.f(4, this.KSl);
            }
            if (this.KSm != null) {
                f2 += g.a.a.b.b.a.f(5, this.KSm);
            }
            if (this.KSn != null) {
                f2 += g.a.a.b.b.a.f(6, this.KSn);
            }
            int bu = f2 + g.a.a.b.b.a.bu(7, this.iAb) + g.a.a.b.b.a.bu(8, this.CreateTime);
            if (this.Mjm != null) {
                bu += g.a.a.a.nh(9, this.Mjm.computeSize());
            }
            if (this.Mjn != null) {
                bu += g.a.a.a.nh(10, this.Mjn.computeSize());
            }
            if (this.Mjo != null) {
                bu += g.a.a.a.nh(11, this.Mjo.computeSize());
            }
            AppMethodBeat.o(212281);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212281);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cdu cdu = (cdu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cdu.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(212281);
                    return 0;
                case 2:
                    cdu.KSh = aVar3.UbS.readString();
                    AppMethodBeat.o(212281);
                    return 0;
                case 3:
                    cdu.KSj = aVar3.UbS.readString();
                    AppMethodBeat.o(212281);
                    return 0;
                case 4:
                    cdu.KSl = aVar3.UbS.readString();
                    AppMethodBeat.o(212281);
                    return 0;
                case 5:
                    cdu.KSm = aVar3.UbS.readString();
                    AppMethodBeat.o(212281);
                    return 0;
                case 6:
                    cdu.KSn = aVar3.UbS.readString();
                    AppMethodBeat.o(212281);
                    return 0;
                case 7:
                    cdu.iAb = aVar3.UbS.zi();
                    AppMethodBeat.o(212281);
                    return 0;
                case 8:
                    cdu.CreateTime = aVar3.UbS.zi();
                    AppMethodBeat.o(212281);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eqv eqv = new eqv();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eqv.populateBuilderWithField(aVar4, eqv, a.getNextFieldNumber(aVar4))) {
                        }
                        cdu.Mjm = eqv;
                    }
                    AppMethodBeat.o(212281);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        esh esh = new esh();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = esh.populateBuilderWithField(aVar5, esh, a.getNextFieldNumber(aVar5))) {
                        }
                        cdu.Mjn = esh;
                    }
                    AppMethodBeat.o(212281);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dbp dbp = new dbp();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dbp.populateBuilderWithField(aVar6, dbp, a.getNextFieldNumber(aVar6))) {
                        }
                        cdu.Mjo = dbp;
                    }
                    AppMethodBeat.o(212281);
                    return 0;
                default:
                    AppMethodBeat.o(212281);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212281);
            return -1;
        }
    }
}
