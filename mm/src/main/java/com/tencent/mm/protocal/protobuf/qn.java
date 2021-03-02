package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class qn extends dop {
    public int KCx;
    public String KCy;
    public String KSV;
    public cjz KXs;
    public dqu KXt;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32149);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.KSV != null) {
                aVar.e(2, this.KSV);
            }
            if (this.KXs != null) {
                aVar.ni(3, this.KXs.computeSize());
                this.KXs.writeFields(aVar);
            }
            if (this.KXt != null) {
                aVar.ni(4, this.KXt.computeSize());
                this.KXt.writeFields(aVar);
            }
            aVar.aM(5, this.KCx);
            if (this.KCy != null) {
                aVar.e(6, this.KCy);
            }
            AppMethodBeat.o(32149);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KSV != null) {
                nh += g.a.a.b.b.a.f(2, this.KSV);
            }
            if (this.KXs != null) {
                nh += g.a.a.a.nh(3, this.KXs.computeSize());
            }
            if (this.KXt != null) {
                nh += g.a.a.a.nh(4, this.KXt.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.KCx);
            if (this.KCy != null) {
                bu += g.a.a.b.b.a.f(6, this.KCy);
            }
            AppMethodBeat.o(32149);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32149);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            qn qnVar = (qn) objArr[1];
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
                        qnVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32149);
                    return 0;
                case 2:
                    qnVar.KSV = aVar3.UbS.readString();
                    AppMethodBeat.o(32149);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cjz cjz = new cjz();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cjz.populateBuilderWithField(aVar5, cjz, dop.getNextFieldNumber(aVar5))) {
                        }
                        qnVar.KXs = cjz;
                    }
                    AppMethodBeat.o(32149);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqu dqu = new dqu();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqu.populateBuilderWithField(aVar6, dqu, dop.getNextFieldNumber(aVar6))) {
                        }
                        qnVar.KXt = dqu;
                    }
                    AppMethodBeat.o(32149);
                    return 0;
                case 5:
                    qnVar.KCx = aVar3.UbS.zi();
                    AppMethodBeat.o(32149);
                    return 0;
                case 6:
                    qnVar.KCy = aVar3.UbS.readString();
                    AppMethodBeat.o(32149);
                    return 0;
                default:
                    AppMethodBeat.o(32149);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32149);
            return -1;
        }
    }
}
