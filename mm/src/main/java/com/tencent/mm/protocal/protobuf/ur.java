package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ur extends a {
    public String Leh;
    public String Lei;
    public String Lej;
    public int Lek;
    public String Lel;
    public un Lem;
    public String Len;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(113968);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Leh != null) {
                aVar.e(1, this.Leh);
            }
            if (this.Lei != null) {
                aVar.e(2, this.Lei);
            }
            if (this.Lej != null) {
                aVar.e(3, this.Lej);
            }
            aVar.aM(4, this.Lek);
            if (this.Lel != null) {
                aVar.e(5, this.Lel);
            }
            if (this.Lem != null) {
                aVar.ni(6, this.Lem.computeSize());
                this.Lem.writeFields(aVar);
            }
            if (this.Len != null) {
                aVar.e(7, this.Len);
            }
            AppMethodBeat.o(113968);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Leh != null ? g.a.a.b.b.a.f(1, this.Leh) + 0 : 0;
            if (this.Lei != null) {
                f2 += g.a.a.b.b.a.f(2, this.Lei);
            }
            if (this.Lej != null) {
                f2 += g.a.a.b.b.a.f(3, this.Lej);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.Lek);
            if (this.Lel != null) {
                bu += g.a.a.b.b.a.f(5, this.Lel);
            }
            if (this.Lem != null) {
                bu += g.a.a.a.nh(6, this.Lem.computeSize());
            }
            if (this.Len != null) {
                bu += g.a.a.b.b.a.f(7, this.Len);
            }
            AppMethodBeat.o(113968);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(113968);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ur urVar = (ur) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    urVar.Leh = aVar3.UbS.readString();
                    AppMethodBeat.o(113968);
                    return 0;
                case 2:
                    urVar.Lei = aVar3.UbS.readString();
                    AppMethodBeat.o(113968);
                    return 0;
                case 3:
                    urVar.Lej = aVar3.UbS.readString();
                    AppMethodBeat.o(113968);
                    return 0;
                case 4:
                    urVar.Lek = aVar3.UbS.zi();
                    AppMethodBeat.o(113968);
                    return 0;
                case 5:
                    urVar.Lel = aVar3.UbS.readString();
                    AppMethodBeat.o(113968);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        un unVar = new un();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = unVar.populateBuilderWithField(aVar4, unVar, a.getNextFieldNumber(aVar4))) {
                        }
                        urVar.Lem = unVar;
                    }
                    AppMethodBeat.o(113968);
                    return 0;
                case 7:
                    urVar.Len = aVar3.UbS.readString();
                    AppMethodBeat.o(113968);
                    return 0;
                default:
                    AppMethodBeat.o(113968);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113968);
            return -1;
        }
    }
}
