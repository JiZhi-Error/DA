package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ekp extends dop {
    public cds NjO;
    public LinkedList<eg> NjP = new LinkedList<>();
    public String link;
    public int scene;

    public ekp() {
        AppMethodBeat.i(152712);
        AppMethodBeat.o(152712);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152713);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.link != null) {
                aVar.e(2, this.link);
            }
            aVar.aM(3, this.scene);
            if (this.NjO != null) {
                aVar.ni(4, this.NjO.computeSize());
                this.NjO.writeFields(aVar);
            }
            aVar.e(5, 8, this.NjP);
            AppMethodBeat.o(152713);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.link != null) {
                nh += g.a.a.b.b.a.f(2, this.link);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.scene);
            if (this.NjO != null) {
                bu += g.a.a.a.nh(4, this.NjO.computeSize());
            }
            int c2 = bu + g.a.a.a.c(5, 8, this.NjP);
            AppMethodBeat.o(152713);
            return c2;
        } else if (i2 == 2) {
            this.NjP.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152713);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ekp ekp = (ekp) objArr[1];
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
                        ekp.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(152713);
                    return 0;
                case 2:
                    ekp.link = aVar3.UbS.readString();
                    AppMethodBeat.o(152713);
                    return 0;
                case 3:
                    ekp.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(152713);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cds cds = new cds();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cds.populateBuilderWithField(aVar5, cds, dop.getNextFieldNumber(aVar5))) {
                        }
                        ekp.NjO = cds;
                    }
                    AppMethodBeat.o(152713);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        eg egVar = new eg();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = egVar.populateBuilderWithField(aVar6, egVar, dop.getNextFieldNumber(aVar6))) {
                        }
                        ekp.NjP.add(egVar);
                    }
                    AppMethodBeat.o(152713);
                    return 0;
                default:
                    AppMethodBeat.o(152713);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152713);
            return -1;
        }
    }
}
