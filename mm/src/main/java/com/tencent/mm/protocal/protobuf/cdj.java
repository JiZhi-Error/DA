package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cdj extends dop {
    public LinkedList<con> KGQ = new LinkedList<>();
    public dqi KGR;
    public cbr KGU;
    public int Mjh;
    public String Mji;
    public int gsq;

    public cdj() {
        AppMethodBeat.i(101819);
        AppMethodBeat.o(101819);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(101820);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.KGR == null) {
                b bVar = new b("Not all required fields were included: ChatRoomName");
                AppMethodBeat.o(101820);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.gsq);
            aVar.e(3, 8, this.KGQ);
            if (this.KGR != null) {
                aVar.ni(4, this.KGR.computeSize());
                this.KGR.writeFields(aVar);
            }
            aVar.aM(5, this.Mjh);
            if (this.Mji != null) {
                aVar.e(6, this.Mji);
            }
            if (this.KGU != null) {
                aVar.ni(7, this.KGU.computeSize());
                this.KGU.writeFields(aVar);
            }
            AppMethodBeat.o(101820);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.gsq) + g.a.a.a.c(3, 8, this.KGQ);
            if (this.KGR != null) {
                nh += g.a.a.a.nh(4, this.KGR.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.Mjh);
            if (this.Mji != null) {
                bu += g.a.a.b.b.a.f(6, this.Mji);
            }
            if (this.KGU != null) {
                bu += g.a.a.a.nh(7, this.KGU.computeSize());
            }
            AppMethodBeat.o(101820);
            return bu;
        } else if (i2 == 2) {
            this.KGQ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KGR == null) {
                b bVar2 = new b("Not all required fields were included: ChatRoomName");
                AppMethodBeat.o(101820);
                throw bVar2;
            }
            AppMethodBeat.o(101820);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cdj cdj = (cdj) objArr[1];
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
                        cdj.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(101820);
                    return 0;
                case 2:
                    cdj.gsq = aVar3.UbS.zi();
                    AppMethodBeat.o(101820);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        con con = new con();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = con.populateBuilderWithField(aVar5, con, dop.getNextFieldNumber(aVar5))) {
                        }
                        cdj.KGQ.add(con);
                    }
                    AppMethodBeat.o(101820);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi.populateBuilderWithField(aVar6, dqi, dop.getNextFieldNumber(aVar6))) {
                        }
                        cdj.KGR = dqi;
                    }
                    AppMethodBeat.o(101820);
                    return 0;
                case 5:
                    cdj.Mjh = aVar3.UbS.zi();
                    AppMethodBeat.o(101820);
                    return 0;
                case 6:
                    cdj.Mji = aVar3.UbS.readString();
                    AppMethodBeat.o(101820);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        cbr cbr = new cbr();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = cbr.populateBuilderWithField(aVar7, cbr, dop.getNextFieldNumber(aVar7))) {
                        }
                        cdj.KGU = cbr;
                    }
                    AppMethodBeat.o(101820);
                    return 0;
                default:
                    AppMethodBeat.o(101820);
                    return -1;
            }
        } else {
            AppMethodBeat.o(101820);
            return -1;
        }
    }
}
