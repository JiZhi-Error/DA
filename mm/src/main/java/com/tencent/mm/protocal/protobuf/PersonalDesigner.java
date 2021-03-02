package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public class PersonalDesigner extends a {
    public int DesignerUin;
    public String HeadUrl;
    public String Name;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104828);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.DesignerUin);
            if (this.Name != null) {
                aVar.e(2, this.Name);
            }
            if (this.HeadUrl != null) {
                aVar.e(3, this.HeadUrl);
            }
            AppMethodBeat.o(104828);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.DesignerUin) + 0;
            if (this.Name != null) {
                bu += g.a.a.b.b.a.f(2, this.Name);
            }
            if (this.HeadUrl != null) {
                bu += g.a.a.b.b.a.f(3, this.HeadUrl);
            }
            AppMethodBeat.o(104828);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(104828);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            PersonalDesigner personalDesigner = (PersonalDesigner) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    personalDesigner.DesignerUin = aVar3.UbS.zi();
                    AppMethodBeat.o(104828);
                    return 0;
                case 2:
                    personalDesigner.Name = aVar3.UbS.readString();
                    AppMethodBeat.o(104828);
                    return 0;
                case 3:
                    personalDesigner.HeadUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(104828);
                    return 0;
                default:
                    AppMethodBeat.o(104828);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104828);
            return -1;
        }
    }
}
