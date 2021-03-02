package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class cmg extends a {
    public aif KLY;
    public SKBuiltinBuffer_t KPW;
    public String KQi;
    public String KQv;
    public String UserName;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133178);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KPW == null) {
                b bVar = new b("Not all required fields were included: RandomEncryKey");
                AppMethodBeat.o(133178);
                throw bVar;
            } else if (this.KLY == null) {
                b bVar2 = new b("Not all required fields were included: CliPubECDHKey");
                AppMethodBeat.o(133178);
                throw bVar2;
            } else {
                if (this.KPW != null) {
                    aVar.ni(1, this.KPW.computeSize());
                    this.KPW.writeFields(aVar);
                }
                if (this.KLY != null) {
                    aVar.ni(2, this.KLY.computeSize());
                    this.KLY.writeFields(aVar);
                }
                if (this.UserName != null) {
                    aVar.e(3, this.UserName);
                }
                if (this.KQi != null) {
                    aVar.e(4, this.KQi);
                }
                if (this.KQv != null) {
                    aVar.e(5, this.KQv);
                }
                AppMethodBeat.o(133178);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.KPW != null ? g.a.a.a.nh(1, this.KPW.computeSize()) + 0 : 0;
            if (this.KLY != null) {
                nh += g.a.a.a.nh(2, this.KLY.computeSize());
            }
            if (this.UserName != null) {
                nh += g.a.a.b.b.a.f(3, this.UserName);
            }
            if (this.KQi != null) {
                nh += g.a.a.b.b.a.f(4, this.KQi);
            }
            if (this.KQv != null) {
                nh += g.a.a.b.b.a.f(5, this.KQv);
            }
            AppMethodBeat.o(133178);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KPW == null) {
                b bVar3 = new b("Not all required fields were included: RandomEncryKey");
                AppMethodBeat.o(133178);
                throw bVar3;
            } else if (this.KLY == null) {
                b bVar4 = new b("Not all required fields were included: CliPubECDHKey");
                AppMethodBeat.o(133178);
                throw bVar4;
            } else {
                AppMethodBeat.o(133178);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cmg cmg = (cmg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        cmg.KPW = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(133178);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aif aif = new aif();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aif.populateBuilderWithField(aVar5, aif, a.getNextFieldNumber(aVar5))) {
                        }
                        cmg.KLY = aif;
                    }
                    AppMethodBeat.o(133178);
                    return 0;
                case 3:
                    cmg.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(133178);
                    return 0;
                case 4:
                    cmg.KQi = aVar3.UbS.readString();
                    AppMethodBeat.o(133178);
                    return 0;
                case 5:
                    cmg.KQv = aVar3.UbS.readString();
                    AppMethodBeat.o(133178);
                    return 0;
                default:
                    AppMethodBeat.o(133178);
                    return -1;
            }
        } else {
            AppMethodBeat.o(133178);
            return -1;
        }
    }
}
