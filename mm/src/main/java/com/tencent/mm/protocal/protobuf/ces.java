package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ces extends dop {
    public LinkedList<String> MjX = new LinkedList<>();
    public int MjZ;
    public fdg Mka;
    public int Mkk;
    public String Mkl;
    public String Url;
    public String jfi;

    public ces() {
        AppMethodBeat.i(123614);
        AppMethodBeat.o(123614);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123615);
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
            if (this.Url != null) {
                aVar.e(5, this.Url);
            }
            if (this.Mkl != null) {
                aVar.e(6, this.Mkl);
            }
            aVar.aM(7, this.MjZ);
            if (this.Mka != null) {
                aVar.ni(8, this.Mka.computeSize());
                this.Mka.writeFields(aVar);
            }
            AppMethodBeat.o(123615);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.jfi != null) {
                nh += g.a.a.b.b.a.f(2, this.jfi);
            }
            int c2 = nh + g.a.a.a.c(3, 1, this.MjX) + g.a.a.b.b.a.bu(4, this.Mkk);
            if (this.Url != null) {
                c2 += g.a.a.b.b.a.f(5, this.Url);
            }
            if (this.Mkl != null) {
                c2 += g.a.a.b.b.a.f(6, this.Mkl);
            }
            int bu = c2 + g.a.a.b.b.a.bu(7, this.MjZ);
            if (this.Mka != null) {
                bu += g.a.a.a.nh(8, this.Mka.computeSize());
            }
            AppMethodBeat.o(123615);
            return bu;
        } else if (i2 == 2) {
            this.MjX.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123615);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ces ces = (ces) objArr[1];
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
                        ces.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(123615);
                    return 0;
                case 2:
                    ces.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(123615);
                    return 0;
                case 3:
                    ces.MjX.add(aVar3.UbS.readString());
                    AppMethodBeat.o(123615);
                    return 0;
                case 4:
                    ces.Mkk = aVar3.UbS.zi();
                    AppMethodBeat.o(123615);
                    return 0;
                case 5:
                    ces.Url = aVar3.UbS.readString();
                    AppMethodBeat.o(123615);
                    return 0;
                case 6:
                    ces.Mkl = aVar3.UbS.readString();
                    AppMethodBeat.o(123615);
                    return 0;
                case 7:
                    ces.MjZ = aVar3.UbS.zi();
                    AppMethodBeat.o(123615);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        fdg fdg = new fdg();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = fdg.populateBuilderWithField(aVar5, fdg, dop.getNextFieldNumber(aVar5))) {
                        }
                        ces.Mka = fdg;
                    }
                    AppMethodBeat.o(123615);
                    return 0;
                default:
                    AppMethodBeat.o(123615);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123615);
            return -1;
        }
    }
}
