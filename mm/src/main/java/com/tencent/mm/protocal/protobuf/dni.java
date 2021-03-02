package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dni extends dop {
    public ahd LVC;
    public LinkedList<aki> MQB = new LinkedList<>();
    public long rNK;
    public long rNL;

    public dni() {
        AppMethodBeat.i(220722);
        AppMethodBeat.o(220722);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(220723);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.LVC == null) {
                b bVar = new b("Not all required fields were included: DeviceType");
                AppMethodBeat.o(220723);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.bb(2, this.rNK);
            aVar.bb(3, this.rNL);
            aVar.e(4, 8, this.MQB);
            if (this.LVC != null) {
                aVar.ni(5, this.LVC.computeSize());
                this.LVC.writeFields(aVar);
            }
            AppMethodBeat.o(220723);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.rNK) + g.a.a.b.b.a.r(3, this.rNL) + g.a.a.a.c(4, 8, this.MQB);
            if (this.LVC != null) {
                nh += g.a.a.a.nh(5, this.LVC.computeSize());
            }
            AppMethodBeat.o(220723);
            return nh;
        } else if (i2 == 2) {
            this.MQB.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.LVC == null) {
                b bVar2 = new b("Not all required fields were included: DeviceType");
                AppMethodBeat.o(220723);
                throw bVar2;
            }
            AppMethodBeat.o(220723);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dni dni = (dni) objArr[1];
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
                        dni.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(220723);
                    return 0;
                case 2:
                    dni.rNK = aVar3.UbS.zl();
                    AppMethodBeat.o(220723);
                    return 0;
                case 3:
                    dni.rNL = aVar3.UbS.zl();
                    AppMethodBeat.o(220723);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aki aki = new aki();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aki.populateBuilderWithField(aVar5, aki, dop.getNextFieldNumber(aVar5))) {
                        }
                        dni.MQB.add(aki);
                    }
                    AppMethodBeat.o(220723);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ahd ahd = new ahd();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ahd.populateBuilderWithField(aVar6, ahd, dop.getNextFieldNumber(aVar6))) {
                        }
                        dni.LVC = ahd;
                    }
                    AppMethodBeat.o(220723);
                    return 0;
                default:
                    AppMethodBeat.o(220723);
                    return -1;
            }
        } else {
            AppMethodBeat.o(220723);
            return -1;
        }
    }
}
