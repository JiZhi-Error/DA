package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dzp extends dop {
    public dzj MYE;
    public dqi MYF;
    public String izX;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125780);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.MYE == null) {
                b bVar = new b("Not all required fields were included: Action");
                AppMethodBeat.o(125780);
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
            if (this.MYF != null) {
                aVar.ni(4, this.MYF.computeSize());
                this.MYF.writeFields(aVar);
            }
            AppMethodBeat.o(125780);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.MYE != null) {
                nh += g.a.a.a.nh(2, this.MYE.computeSize());
            }
            if (this.izX != null) {
                nh += g.a.a.b.b.a.f(3, this.izX);
            }
            if (this.MYF != null) {
                nh += g.a.a.a.nh(4, this.MYF.computeSize());
            }
            AppMethodBeat.o(125780);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MYE == null) {
                b bVar2 = new b("Not all required fields were included: Action");
                AppMethodBeat.o(125780);
                throw bVar2;
            }
            AppMethodBeat.o(125780);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dzp dzp = (dzp) objArr[1];
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
                        dzp.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(125780);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dzj dzj = new dzj();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dzj.populateBuilderWithField(aVar5, dzj, dop.getNextFieldNumber(aVar5))) {
                        }
                        dzp.MYE = dzj;
                    }
                    AppMethodBeat.o(125780);
                    return 0;
                case 3:
                    dzp.izX = aVar3.UbS.readString();
                    AppMethodBeat.o(125780);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi.populateBuilderWithField(aVar6, dqi, dop.getNextFieldNumber(aVar6))) {
                        }
                        dzp.MYF = dqi;
                    }
                    AppMethodBeat.o(125780);
                    return 0;
                default:
                    AppMethodBeat.o(125780);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125780);
            return -1;
        }
    }
}
