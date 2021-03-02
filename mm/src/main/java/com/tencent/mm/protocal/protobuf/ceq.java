package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ceq extends dop {
    public LinkedList<String> MjX = new LinkedList<>();
    public int MjY;
    public int MjZ;
    public fdg Mka;
    public int Mkk;
    public String Mkl;
    public String jfi;

    public ceq() {
        AppMethodBeat.i(123611);
        AppMethodBeat.o(123611);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123612);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.jfi != null) {
                aVar.e(2, this.jfi);
            }
            aVar.e(3, 1, this.MjX);
            aVar.aM(4, this.Mkk);
            if (this.Mkl != null) {
                aVar.e(6, this.Mkl);
            }
            aVar.aM(7, this.MjY);
            aVar.aM(8, this.MjZ);
            if (this.Mka != null) {
                aVar.ni(9, this.Mka.computeSize());
                this.Mka.writeFields(aVar);
            }
            AppMethodBeat.o(123612);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.jfi != null) {
                nh += g.a.a.b.b.a.f(2, this.jfi);
            }
            int c2 = nh + g.a.a.a.c(3, 1, this.MjX) + g.a.a.b.b.a.bu(4, this.Mkk);
            if (this.Mkl != null) {
                c2 += g.a.a.b.b.a.f(6, this.Mkl);
            }
            int bu = c2 + g.a.a.b.b.a.bu(7, this.MjY) + g.a.a.b.b.a.bu(8, this.MjZ);
            if (this.Mka != null) {
                bu += g.a.a.a.nh(9, this.Mka.computeSize());
            }
            AppMethodBeat.o(123612);
            return bu;
        } else if (i2 == 2) {
            this.MjX.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123612);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ceq ceq = (ceq) objArr[1];
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
                        ceq.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(123612);
                    return 0;
                case 2:
                    ceq.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(123612);
                    return 0;
                case 3:
                    ceq.MjX.add(aVar3.UbS.readString());
                    AppMethodBeat.o(123612);
                    return 0;
                case 4:
                    ceq.Mkk = aVar3.UbS.zi();
                    AppMethodBeat.o(123612);
                    return 0;
                case 5:
                default:
                    AppMethodBeat.o(123612);
                    return -1;
                case 6:
                    ceq.Mkl = aVar3.UbS.readString();
                    AppMethodBeat.o(123612);
                    return 0;
                case 7:
                    ceq.MjY = aVar3.UbS.zi();
                    AppMethodBeat.o(123612);
                    return 0;
                case 8:
                    ceq.MjZ = aVar3.UbS.zi();
                    AppMethodBeat.o(123612);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        fdg fdg = new fdg();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = fdg.populateBuilderWithField(aVar5, fdg, dop.getNextFieldNumber(aVar5))) {
                        }
                        ceq.Mka = fdg;
                    }
                    AppMethodBeat.o(123612);
                    return 0;
            }
        } else {
            AppMethodBeat.o(123612);
            return -1;
        }
    }
}
