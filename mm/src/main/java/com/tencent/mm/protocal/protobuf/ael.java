package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ael extends dop {
    public String LpJ;
    public String LpK;
    public chk LpL;
    public LinkedList<dqi> LpM = new LinkedList<>();
    public String LpN;
    public String LpO;
    public String Name;
    public int oTz;

    public ael() {
        AppMethodBeat.i(32181);
        AppMethodBeat.o(32181);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32182);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.LpL == null) {
                b bVar = new b("Not all required fields were included: Loc");
                AppMethodBeat.o(32182);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.Name != null) {
                aVar.e(2, this.Name);
            }
            if (this.LpJ != null) {
                aVar.e(3, this.LpJ);
            }
            if (this.LpK != null) {
                aVar.e(4, this.LpK);
            }
            if (this.LpL != null) {
                aVar.ni(5, this.LpL.computeSize());
                this.LpL.writeFields(aVar);
            }
            aVar.aM(6, this.oTz);
            aVar.e(7, 8, this.LpM);
            if (this.LpN != null) {
                aVar.e(8, this.LpN);
            }
            if (this.LpO != null) {
                aVar.e(9, this.LpO);
            }
            AppMethodBeat.o(32182);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.Name != null) {
                nh += g.a.a.b.b.a.f(2, this.Name);
            }
            if (this.LpJ != null) {
                nh += g.a.a.b.b.a.f(3, this.LpJ);
            }
            if (this.LpK != null) {
                nh += g.a.a.b.b.a.f(4, this.LpK);
            }
            if (this.LpL != null) {
                nh += g.a.a.a.nh(5, this.LpL.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.oTz) + g.a.a.a.c(7, 8, this.LpM);
            if (this.LpN != null) {
                bu += g.a.a.b.b.a.f(8, this.LpN);
            }
            if (this.LpO != null) {
                bu += g.a.a.b.b.a.f(9, this.LpO);
            }
            AppMethodBeat.o(32182);
            return bu;
        } else if (i2 == 2) {
            this.LpM.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.LpL == null) {
                b bVar2 = new b("Not all required fields were included: Loc");
                AppMethodBeat.o(32182);
                throw bVar2;
            }
            AppMethodBeat.o(32182);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ael ael = (ael) objArr[1];
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
                        ael.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32182);
                    return 0;
                case 2:
                    ael.Name = aVar3.UbS.readString();
                    AppMethodBeat.o(32182);
                    return 0;
                case 3:
                    ael.LpJ = aVar3.UbS.readString();
                    AppMethodBeat.o(32182);
                    return 0;
                case 4:
                    ael.LpK = aVar3.UbS.readString();
                    AppMethodBeat.o(32182);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        chk chk = new chk();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = chk.populateBuilderWithField(aVar5, chk, dop.getNextFieldNumber(aVar5))) {
                        }
                        ael.LpL = chk;
                    }
                    AppMethodBeat.o(32182);
                    return 0;
                case 6:
                    ael.oTz = aVar3.UbS.zi();
                    AppMethodBeat.o(32182);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi.populateBuilderWithField(aVar6, dqi, dop.getNextFieldNumber(aVar6))) {
                        }
                        ael.LpM.add(dqi);
                    }
                    AppMethodBeat.o(32182);
                    return 0;
                case 8:
                    ael.LpN = aVar3.UbS.readString();
                    AppMethodBeat.o(32182);
                    return 0;
                case 9:
                    ael.LpO = aVar3.UbS.readString();
                    AppMethodBeat.o(32182);
                    return 0;
                default:
                    AppMethodBeat.o(32182);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32182);
            return -1;
        }
    }
}
