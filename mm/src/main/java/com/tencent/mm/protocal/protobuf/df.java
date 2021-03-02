package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class df extends a {
    public long Brn;
    public int CreateTime;
    public int KHs;
    public dqi KHt;
    public int KHu;
    public dqi KHv;
    public int KHw;
    public int xKb;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133144);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KHt == null) {
                b bVar = new b("Not all required fields were included: ChatRoomId");
                AppMethodBeat.o(133144);
                throw bVar;
            } else if (this.KHv == null) {
                b bVar2 = new b("Not all required fields were included: DigestContent");
                AppMethodBeat.o(133144);
                throw bVar2;
            } else {
                if (this.KHt != null) {
                    aVar.ni(1, this.KHt.computeSize());
                    this.KHt.writeFields(aVar);
                }
                aVar.bb(2, this.Brn);
                aVar.aM(3, this.KHs);
                aVar.aM(4, this.CreateTime);
                aVar.aM(5, this.KHu);
                if (this.KHv != null) {
                    aVar.ni(6, this.KHv.computeSize());
                    this.KHv.writeFields(aVar);
                }
                aVar.aM(7, this.KHw);
                aVar.aM(8, this.xKb);
                AppMethodBeat.o(133144);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = (this.KHt != null ? g.a.a.a.nh(1, this.KHt.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.Brn) + g.a.a.b.b.a.bu(3, this.KHs) + g.a.a.b.b.a.bu(4, this.CreateTime) + g.a.a.b.b.a.bu(5, this.KHu);
            if (this.KHv != null) {
                nh += g.a.a.a.nh(6, this.KHv.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(7, this.KHw) + g.a.a.b.b.a.bu(8, this.xKb);
            AppMethodBeat.o(133144);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KHt == null) {
                b bVar3 = new b("Not all required fields were included: ChatRoomId");
                AppMethodBeat.o(133144);
                throw bVar3;
            } else if (this.KHv == null) {
                b bVar4 = new b("Not all required fields were included: DigestContent");
                AppMethodBeat.o(133144);
                throw bVar4;
            } else {
                AppMethodBeat.o(133144);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            df dfVar = (df) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dqi.populateBuilderWithField(aVar4, dqi, a.getNextFieldNumber(aVar4))) {
                        }
                        dfVar.KHt = dqi;
                    }
                    AppMethodBeat.o(133144);
                    return 0;
                case 2:
                    dfVar.Brn = aVar3.UbS.zl();
                    AppMethodBeat.o(133144);
                    return 0;
                case 3:
                    dfVar.KHs = aVar3.UbS.zi();
                    AppMethodBeat.o(133144);
                    return 0;
                case 4:
                    dfVar.CreateTime = aVar3.UbS.zi();
                    AppMethodBeat.o(133144);
                    return 0;
                case 5:
                    dfVar.KHu = aVar3.UbS.zi();
                    AppMethodBeat.o(133144);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi2.populateBuilderWithField(aVar5, dqi2, a.getNextFieldNumber(aVar5))) {
                        }
                        dfVar.KHv = dqi2;
                    }
                    AppMethodBeat.o(133144);
                    return 0;
                case 7:
                    dfVar.KHw = aVar3.UbS.zi();
                    AppMethodBeat.o(133144);
                    return 0;
                case 8:
                    dfVar.xKb = aVar3.UbS.zi();
                    AppMethodBeat.o(133144);
                    return 0;
                default:
                    AppMethodBeat.o(133144);
                    return -1;
            }
        } else {
            AppMethodBeat.o(133144);
            return -1;
        }
    }
}
