package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cnl extends a {
    public String MtR;
    public coc MtS;
    public cnp MtT;
    public coc MtU;
    public String description;
    public LinkedList<cod> media = new LinkedList<>();
    public int mediaType;

    public cnl() {
        AppMethodBeat.i(209738);
        AppMethodBeat.o(209738);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209739);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.description != null) {
                aVar.e(1, this.description);
            }
            aVar.e(2, 8, this.media);
            aVar.aM(3, this.mediaType);
            if (this.MtR != null) {
                aVar.e(4, this.MtR);
            }
            if (this.MtS != null) {
                aVar.ni(5, this.MtS.computeSize());
                this.MtS.writeFields(aVar);
            }
            if (this.MtT != null) {
                aVar.ni(6, this.MtT.computeSize());
                this.MtT.writeFields(aVar);
            }
            if (this.MtU != null) {
                aVar.ni(7, this.MtU.computeSize());
                this.MtU.writeFields(aVar);
            }
            AppMethodBeat.o(209739);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.description != null ? g.a.a.b.b.a.f(1, this.description) + 0 : 0) + g.a.a.a.c(2, 8, this.media) + g.a.a.b.b.a.bu(3, this.mediaType);
            if (this.MtR != null) {
                f2 += g.a.a.b.b.a.f(4, this.MtR);
            }
            if (this.MtS != null) {
                f2 += g.a.a.a.nh(5, this.MtS.computeSize());
            }
            if (this.MtT != null) {
                f2 += g.a.a.a.nh(6, this.MtT.computeSize());
            }
            if (this.MtU != null) {
                f2 += g.a.a.a.nh(7, this.MtU.computeSize());
            }
            AppMethodBeat.o(209739);
            return f2;
        } else if (i2 == 2) {
            this.media.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209739);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cnl cnl = (cnl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cnl.description = aVar3.UbS.readString();
                    AppMethodBeat.o(209739);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cod cod = new cod();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cod.populateBuilderWithField(aVar4, cod, a.getNextFieldNumber(aVar4))) {
                        }
                        cnl.media.add(cod);
                    }
                    AppMethodBeat.o(209739);
                    return 0;
                case 3:
                    cnl.mediaType = aVar3.UbS.zi();
                    AppMethodBeat.o(209739);
                    return 0;
                case 4:
                    cnl.MtR = aVar3.UbS.readString();
                    AppMethodBeat.o(209739);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        coc coc = new coc();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = coc.populateBuilderWithField(aVar5, coc, a.getNextFieldNumber(aVar5))) {
                        }
                        cnl.MtS = coc;
                    }
                    AppMethodBeat.o(209739);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cnp cnp = new cnp();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cnp.populateBuilderWithField(aVar6, cnp, a.getNextFieldNumber(aVar6))) {
                        }
                        cnl.MtT = cnp;
                    }
                    AppMethodBeat.o(209739);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        coc coc2 = new coc();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = coc2.populateBuilderWithField(aVar7, coc2, a.getNextFieldNumber(aVar7))) {
                        }
                        cnl.MtU = coc2;
                    }
                    AppMethodBeat.o(209739);
                    return 0;
                default:
                    AppMethodBeat.o(209739);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209739);
            return -1;
        }
    }
}
