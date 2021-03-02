package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class air extends dop {
    public String KLN;
    public int KMz;
    public SKBuiltinBuffer_t KPW;
    public String KPz;
    public String KQi;
    public String Lsi;
    public String Lsj;
    public int Lsk;
    public String rBI;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(155402);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.KPW == null) {
                b bVar = new b("Not all required fields were included: RandomEncryKey");
                AppMethodBeat.o(155402);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.KPW != null) {
                aVar.ni(2, this.KPW.computeSize());
                this.KPW.writeFields(aVar);
            }
            aVar.aM(3, this.KMz);
            if (this.KPz != null) {
                aVar.e(4, this.KPz);
            }
            if (this.rBI != null) {
                aVar.e(5, this.rBI);
            }
            if (this.KQi != null) {
                aVar.e(6, this.KQi);
            }
            if (this.Lsi != null) {
                aVar.e(7, this.Lsi);
            }
            if (this.KLN != null) {
                aVar.e(8, this.KLN);
            }
            if (this.Lsj != null) {
                aVar.e(9, this.Lsj);
            }
            aVar.aM(10, this.Lsk);
            AppMethodBeat.o(155402);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KPW != null) {
                nh += g.a.a.a.nh(2, this.KPW.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.KMz);
            if (this.KPz != null) {
                bu += g.a.a.b.b.a.f(4, this.KPz);
            }
            if (this.rBI != null) {
                bu += g.a.a.b.b.a.f(5, this.rBI);
            }
            if (this.KQi != null) {
                bu += g.a.a.b.b.a.f(6, this.KQi);
            }
            if (this.Lsi != null) {
                bu += g.a.a.b.b.a.f(7, this.Lsi);
            }
            if (this.KLN != null) {
                bu += g.a.a.b.b.a.f(8, this.KLN);
            }
            if (this.Lsj != null) {
                bu += g.a.a.b.b.a.f(9, this.Lsj);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(10, this.Lsk);
            AppMethodBeat.o(155402);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KPW == null) {
                b bVar2 = new b("Not all required fields were included: RandomEncryKey");
                AppMethodBeat.o(155402);
                throw bVar2;
            }
            AppMethodBeat.o(155402);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            air air = (air) objArr[1];
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
                        air.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(155402);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        air.KPW = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(155402);
                    return 0;
                case 3:
                    air.KMz = aVar3.UbS.zi();
                    AppMethodBeat.o(155402);
                    return 0;
                case 4:
                    air.KPz = aVar3.UbS.readString();
                    AppMethodBeat.o(155402);
                    return 0;
                case 5:
                    air.rBI = aVar3.UbS.readString();
                    AppMethodBeat.o(155402);
                    return 0;
                case 6:
                    air.KQi = aVar3.UbS.readString();
                    AppMethodBeat.o(155402);
                    return 0;
                case 7:
                    air.Lsi = aVar3.UbS.readString();
                    AppMethodBeat.o(155402);
                    return 0;
                case 8:
                    air.KLN = aVar3.UbS.readString();
                    AppMethodBeat.o(155402);
                    return 0;
                case 9:
                    air.Lsj = aVar3.UbS.readString();
                    AppMethodBeat.o(155402);
                    return 0;
                case 10:
                    air.Lsk = aVar3.UbS.zi();
                    AppMethodBeat.o(155402);
                    return 0;
                default:
                    AppMethodBeat.o(155402);
                    return -1;
            }
        } else {
            AppMethodBeat.o(155402);
            return -1;
        }
    }
}
