package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dtp extends dop {
    public cat KPD;
    public cax MVD;
    public SKBuiltinBuffer_t Mgl;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32428);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.KPD == null) {
                b bVar = new b("Not all required fields were included: HardDevice");
                AppMethodBeat.o(32428);
                throw bVar;
            } else if (this.MVD == null) {
                b bVar2 = new b("Not all required fields were included: HardDeviceMsg");
                AppMethodBeat.o(32428);
                throw bVar2;
            } else if (this.Mgl == null) {
                b bVar3 = new b("Not all required fields were included: SessionBuffer");
                AppMethodBeat.o(32428);
                throw bVar3;
            } else {
                if (this.BaseRequest != null) {
                    aVar.ni(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.KPD != null) {
                    aVar.ni(2, this.KPD.computeSize());
                    this.KPD.writeFields(aVar);
                }
                if (this.MVD != null) {
                    aVar.ni(3, this.MVD.computeSize());
                    this.MVD.writeFields(aVar);
                }
                if (this.Mgl != null) {
                    aVar.ni(4, this.Mgl.computeSize());
                    this.Mgl.writeFields(aVar);
                }
                AppMethodBeat.o(32428);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KPD != null) {
                nh += g.a.a.a.nh(2, this.KPD.computeSize());
            }
            if (this.MVD != null) {
                nh += g.a.a.a.nh(3, this.MVD.computeSize());
            }
            if (this.Mgl != null) {
                nh += g.a.a.a.nh(4, this.Mgl.computeSize());
            }
            AppMethodBeat.o(32428);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KPD == null) {
                b bVar4 = new b("Not all required fields were included: HardDevice");
                AppMethodBeat.o(32428);
                throw bVar4;
            } else if (this.MVD == null) {
                b bVar5 = new b("Not all required fields were included: HardDeviceMsg");
                AppMethodBeat.o(32428);
                throw bVar5;
            } else if (this.Mgl == null) {
                b bVar6 = new b("Not all required fields were included: SessionBuffer");
                AppMethodBeat.o(32428);
                throw bVar6;
            } else {
                AppMethodBeat.o(32428);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dtp dtp = (dtp) objArr[1];
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
                        dtp.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32428);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cat cat = new cat();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cat.populateBuilderWithField(aVar5, cat, dop.getNextFieldNumber(aVar5))) {
                        }
                        dtp.KPD = cat;
                    }
                    AppMethodBeat.o(32428);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cax cax = new cax();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cax.populateBuilderWithField(aVar6, cax, dop.getNextFieldNumber(aVar6))) {
                        }
                        dtp.MVD = cax;
                    }
                    AppMethodBeat.o(32428);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = sKBuiltinBuffer_t.populateBuilderWithField(aVar7, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar7))) {
                        }
                        dtp.Mgl = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(32428);
                    return 0;
                default:
                    AppMethodBeat.o(32428);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32428);
            return -1;
        }
    }
}
