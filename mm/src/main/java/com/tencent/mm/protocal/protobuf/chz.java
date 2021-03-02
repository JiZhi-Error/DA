package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class chz extends a {
    public PersonalDesigner LVe;
    public String Lso;
    public chy Mnr;
    public cib Mns;
    public String Name;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104818);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Lso != null) {
                aVar.e(1, this.Lso);
            }
            if (this.Mnr != null) {
                aVar.ni(2, this.Mnr.computeSize());
                this.Mnr.writeFields(aVar);
            }
            if (this.Name != null) {
                aVar.e(3, this.Name);
            }
            if (this.LVe != null) {
                aVar.ni(4, this.LVe.computeSize());
                this.LVe.writeFields(aVar);
            }
            if (this.Mns != null) {
                aVar.ni(5, this.Mns.computeSize());
                this.Mns.writeFields(aVar);
            }
            AppMethodBeat.o(104818);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Lso != null ? g.a.a.b.b.a.f(1, this.Lso) + 0 : 0;
            if (this.Mnr != null) {
                f2 += g.a.a.a.nh(2, this.Mnr.computeSize());
            }
            if (this.Name != null) {
                f2 += g.a.a.b.b.a.f(3, this.Name);
            }
            if (this.LVe != null) {
                f2 += g.a.a.a.nh(4, this.LVe.computeSize());
            }
            if (this.Mns != null) {
                f2 += g.a.a.a.nh(5, this.Mns.computeSize());
            }
            AppMethodBeat.o(104818);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(104818);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            chz chz = (chz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    chz.Lso = aVar3.UbS.readString();
                    AppMethodBeat.o(104818);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        chy chy = new chy();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = chy.populateBuilderWithField(aVar4, chy, a.getNextFieldNumber(aVar4))) {
                        }
                        chz.Mnr = chy;
                    }
                    AppMethodBeat.o(104818);
                    return 0;
                case 3:
                    chz.Name = aVar3.UbS.readString();
                    AppMethodBeat.o(104818);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        PersonalDesigner personalDesigner = new PersonalDesigner();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = personalDesigner.populateBuilderWithField(aVar5, personalDesigner, a.getNextFieldNumber(aVar5))) {
                        }
                        chz.LVe = personalDesigner;
                    }
                    AppMethodBeat.o(104818);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cib cib = new cib();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cib.populateBuilderWithField(aVar6, cib, a.getNextFieldNumber(aVar6))) {
                        }
                        chz.Mns = cib;
                    }
                    AppMethodBeat.o(104818);
                    return 0;
                default:
                    AppMethodBeat.o(104818);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104818);
            return -1;
        }
    }
}
