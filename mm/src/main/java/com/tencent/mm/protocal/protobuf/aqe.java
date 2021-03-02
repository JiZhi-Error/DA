package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class aqe extends dop {
    public b LCh;
    public app LCi;
    public int LCj;
    public int LCk;
    public app LCl;
    public int LCm;
    public String iAR;
    public String nickname;
    public String signature;
    public aov uli;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168948);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.nickname != null) {
                aVar.e(2, this.nickname);
            }
            if (this.LCh != null) {
                aVar.c(3, this.LCh);
            }
            if (this.iAR != null) {
                aVar.e(4, this.iAR);
            }
            if (this.uli != null) {
                aVar.ni(5, this.uli.computeSize());
                this.uli.writeFields(aVar);
            }
            if (this.signature != null) {
                aVar.e(6, this.signature);
            }
            if (this.LCi != null) {
                aVar.ni(7, this.LCi.computeSize());
                this.LCi.writeFields(aVar);
            }
            aVar.aM(8, this.LCj);
            aVar.aM(9, this.LCk);
            if (this.LCl != null) {
                aVar.ni(10, this.LCl.computeSize());
                this.LCl.writeFields(aVar);
            }
            aVar.aM(11, this.LCm);
            AppMethodBeat.o(168948);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.nickname != null) {
                nh += g.a.a.b.b.a.f(2, this.nickname);
            }
            if (this.LCh != null) {
                nh += g.a.a.b.b.a.b(3, this.LCh);
            }
            if (this.iAR != null) {
                nh += g.a.a.b.b.a.f(4, this.iAR);
            }
            if (this.uli != null) {
                nh += g.a.a.a.nh(5, this.uli.computeSize());
            }
            if (this.signature != null) {
                nh += g.a.a.b.b.a.f(6, this.signature);
            }
            if (this.LCi != null) {
                nh += g.a.a.a.nh(7, this.LCi.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(8, this.LCj) + g.a.a.b.b.a.bu(9, this.LCk);
            if (this.LCl != null) {
                bu += g.a.a.a.nh(10, this.LCl.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(11, this.LCm);
            AppMethodBeat.o(168948);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(168948);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aqe aqe = (aqe) objArr[1];
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
                        aqe.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(168948);
                    return 0;
                case 2:
                    aqe.nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(168948);
                    return 0;
                case 3:
                    aqe.LCh = aVar3.UbS.hPo();
                    AppMethodBeat.o(168948);
                    return 0;
                case 4:
                    aqe.iAR = aVar3.UbS.readString();
                    AppMethodBeat.o(168948);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        aqe.uli = aov;
                    }
                    AppMethodBeat.o(168948);
                    return 0;
                case 6:
                    aqe.signature = aVar3.UbS.readString();
                    AppMethodBeat.o(168948);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        app app = new app();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = app.populateBuilderWithField(aVar6, app, dop.getNextFieldNumber(aVar6))) {
                        }
                        aqe.LCi = app;
                    }
                    AppMethodBeat.o(168948);
                    return 0;
                case 8:
                    aqe.LCj = aVar3.UbS.zi();
                    AppMethodBeat.o(168948);
                    return 0;
                case 9:
                    aqe.LCk = aVar3.UbS.zi();
                    AppMethodBeat.o(168948);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        app app2 = new app();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = app2.populateBuilderWithField(aVar7, app2, dop.getNextFieldNumber(aVar7))) {
                        }
                        aqe.LCl = app2;
                    }
                    AppMethodBeat.o(168948);
                    return 0;
                case 11:
                    aqe.LCm = aVar3.UbS.zi();
                    AppMethodBeat.o(168948);
                    return 0;
                default:
                    AppMethodBeat.o(168948);
                    return -1;
            }
        } else {
            AppMethodBeat.o(168948);
            return -1;
        }
    }
}
