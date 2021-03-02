package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class djz extends dop {
    public String Cyk;
    public int MlF;
    public String hid;
    public String hie;
    public String hif;
    public String hig;
    public String hih;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152666);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.hid != null) {
                aVar.e(2, this.hid);
            }
            if (this.hie != null) {
                aVar.e(3, this.hie);
            }
            if (this.hif != null) {
                aVar.e(4, this.hif);
            }
            if (this.hig != null) {
                aVar.e(5, this.hig);
            }
            if (this.hih != null) {
                aVar.e(6, this.hih);
            }
            aVar.aM(7, this.MlF);
            if (this.Cyk != null) {
                aVar.e(8, this.Cyk);
            }
            AppMethodBeat.o(152666);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.hid != null) {
                nh += g.a.a.b.b.a.f(2, this.hid);
            }
            if (this.hie != null) {
                nh += g.a.a.b.b.a.f(3, this.hie);
            }
            if (this.hif != null) {
                nh += g.a.a.b.b.a.f(4, this.hif);
            }
            if (this.hig != null) {
                nh += g.a.a.b.b.a.f(5, this.hig);
            }
            if (this.hih != null) {
                nh += g.a.a.b.b.a.f(6, this.hih);
            }
            int bu = nh + g.a.a.b.b.a.bu(7, this.MlF);
            if (this.Cyk != null) {
                bu += g.a.a.b.b.a.f(8, this.Cyk);
            }
            AppMethodBeat.o(152666);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152666);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            djz djz = (djz) objArr[1];
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
                        djz.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(152666);
                    return 0;
                case 2:
                    djz.hid = aVar3.UbS.readString();
                    AppMethodBeat.o(152666);
                    return 0;
                case 3:
                    djz.hie = aVar3.UbS.readString();
                    AppMethodBeat.o(152666);
                    return 0;
                case 4:
                    djz.hif = aVar3.UbS.readString();
                    AppMethodBeat.o(152666);
                    return 0;
                case 5:
                    djz.hig = aVar3.UbS.readString();
                    AppMethodBeat.o(152666);
                    return 0;
                case 6:
                    djz.hih = aVar3.UbS.readString();
                    AppMethodBeat.o(152666);
                    return 0;
                case 7:
                    djz.MlF = aVar3.UbS.zi();
                    AppMethodBeat.o(152666);
                    return 0;
                case 8:
                    djz.Cyk = aVar3.UbS.readString();
                    AppMethodBeat.o(152666);
                    return 0;
                default:
                    AppMethodBeat.o(152666);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152666);
            return -1;
        }
    }
}
