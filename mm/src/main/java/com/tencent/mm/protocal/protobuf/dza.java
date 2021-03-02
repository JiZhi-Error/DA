package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dza extends dop {
    public dqi MYD;
    public dzj MYE;
    public dqi MYF;
    public int Scene;
    public String izX;
    public int xub;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125762);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.MYE == null) {
                b bVar = new b("Not all required fields were included: Action");
                AppMethodBeat.o(125762);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.MYE != null) {
                aVar.ni(2, this.MYE.computeSize());
                this.MYE.writeFields(aVar);
            }
            if (this.izX != null) {
                aVar.e(3, this.izX);
            }
            if (this.MYD != null) {
                aVar.ni(4, this.MYD.computeSize());
                this.MYD.writeFields(aVar);
            }
            aVar.aM(5, this.xub);
            if (this.MYF != null) {
                aVar.ni(6, this.MYF.computeSize());
                this.MYF.writeFields(aVar);
            }
            aVar.aM(7, this.Scene);
            AppMethodBeat.o(125762);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.MYE != null) {
                nh += g.a.a.a.nh(2, this.MYE.computeSize());
            }
            if (this.izX != null) {
                nh += g.a.a.b.b.a.f(3, this.izX);
            }
            if (this.MYD != null) {
                nh += g.a.a.a.nh(4, this.MYD.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.xub);
            if (this.MYF != null) {
                bu += g.a.a.a.nh(6, this.MYF.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.Scene);
            AppMethodBeat.o(125762);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MYE == null) {
                b bVar2 = new b("Not all required fields were included: Action");
                AppMethodBeat.o(125762);
                throw bVar2;
            }
            AppMethodBeat.o(125762);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dza dza = (dza) objArr[1];
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
                        dza.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(125762);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dzj dzj = new dzj();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dzj.populateBuilderWithField(aVar5, dzj, dop.getNextFieldNumber(aVar5))) {
                        }
                        dza.MYE = dzj;
                    }
                    AppMethodBeat.o(125762);
                    return 0;
                case 3:
                    dza.izX = aVar3.UbS.readString();
                    AppMethodBeat.o(125762);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi.populateBuilderWithField(aVar6, dqi, dop.getNextFieldNumber(aVar6))) {
                        }
                        dza.MYD = dqi;
                    }
                    AppMethodBeat.o(125762);
                    return 0;
                case 5:
                    dza.xub = aVar3.UbS.zi();
                    AppMethodBeat.o(125762);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dqi2.populateBuilderWithField(aVar7, dqi2, dop.getNextFieldNumber(aVar7))) {
                        }
                        dza.MYF = dqi2;
                    }
                    AppMethodBeat.o(125762);
                    return 0;
                case 7:
                    dza.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(125762);
                    return 0;
                default:
                    AppMethodBeat.o(125762);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125762);
            return -1;
        }
    }
}
