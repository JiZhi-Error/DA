package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ech extends a {
    public ecg Ncw;
    public ecg Ncx;
    public ecg Ncy;
    public int Ncz;
    public int scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123655);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Ncw != null) {
                aVar.ni(1, this.Ncw.computeSize());
                this.Ncw.writeFields(aVar);
            }
            if (this.Ncx != null) {
                aVar.ni(2, this.Ncx.computeSize());
                this.Ncx.writeFields(aVar);
            }
            if (this.Ncy != null) {
                aVar.ni(3, this.Ncy.computeSize());
                this.Ncy.writeFields(aVar);
            }
            aVar.aM(4, this.scene);
            aVar.aM(5, this.Ncz);
            AppMethodBeat.o(123655);
            return 0;
        } else if (i2 == 1) {
            int nh = this.Ncw != null ? g.a.a.a.nh(1, this.Ncw.computeSize()) + 0 : 0;
            if (this.Ncx != null) {
                nh += g.a.a.a.nh(2, this.Ncx.computeSize());
            }
            if (this.Ncy != null) {
                nh += g.a.a.a.nh(3, this.Ncy.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.scene) + g.a.a.b.b.a.bu(5, this.Ncz);
            AppMethodBeat.o(123655);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123655);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ech ech = (ech) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ecg ecg = new ecg();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ecg.populateBuilderWithField(aVar4, ecg, a.getNextFieldNumber(aVar4))) {
                        }
                        ech.Ncw = ecg;
                    }
                    AppMethodBeat.o(123655);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ecg ecg2 = new ecg();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ecg2.populateBuilderWithField(aVar5, ecg2, a.getNextFieldNumber(aVar5))) {
                        }
                        ech.Ncx = ecg2;
                    }
                    AppMethodBeat.o(123655);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ecg ecg3 = new ecg();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ecg3.populateBuilderWithField(aVar6, ecg3, a.getNextFieldNumber(aVar6))) {
                        }
                        ech.Ncy = ecg3;
                    }
                    AppMethodBeat.o(123655);
                    return 0;
                case 4:
                    ech.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(123655);
                    return 0;
                case 5:
                    ech.Ncz = aVar3.UbS.zi();
                    AppMethodBeat.o(123655);
                    return 0;
                default:
                    AppMethodBeat.o(123655);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123655);
            return -1;
        }
    }
}
