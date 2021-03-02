package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class euw extends dop {
    public int Leu;
    public SKBuiltinBuffer_t Lev;
    public int LsZ;
    public long Lta;
    public String MKC;
    public long NpN;
    public etn NsX;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115925);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.Lev == null) {
                b bVar = new b("Not all required fields were included: KeyBuf");
                AppMethodBeat.o(115925);
                throw bVar;
            } else if (this.NsX == null) {
                b bVar2 = new b("Not all required fields were included: OpLog");
                AppMethodBeat.o(115925);
                throw bVar2;
            } else {
                if (this.BaseRequest != null) {
                    aVar.ni(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.MKC != null) {
                    aVar.e(2, this.MKC);
                }
                aVar.aM(3, this.LsZ);
                if (this.Lev != null) {
                    aVar.ni(4, this.Lev.computeSize());
                    this.Lev.writeFields(aVar);
                }
                if (this.NsX != null) {
                    aVar.ni(5, this.NsX.computeSize());
                    this.NsX.writeFields(aVar);
                }
                aVar.bb(6, this.Lta);
                aVar.aM(7, this.Leu);
                aVar.bb(8, this.NpN);
                AppMethodBeat.o(115925);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.MKC != null) {
                nh += g.a.a.b.b.a.f(2, this.MKC);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.LsZ);
            if (this.Lev != null) {
                bu += g.a.a.a.nh(4, this.Lev.computeSize());
            }
            if (this.NsX != null) {
                bu += g.a.a.a.nh(5, this.NsX.computeSize());
            }
            int r = bu + g.a.a.b.b.a.r(6, this.Lta) + g.a.a.b.b.a.bu(7, this.Leu) + g.a.a.b.b.a.r(8, this.NpN);
            AppMethodBeat.o(115925);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Lev == null) {
                b bVar3 = new b("Not all required fields were included: KeyBuf");
                AppMethodBeat.o(115925);
                throw bVar3;
            } else if (this.NsX == null) {
                b bVar4 = new b("Not all required fields were included: OpLog");
                AppMethodBeat.o(115925);
                throw bVar4;
            } else {
                AppMethodBeat.o(115925);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            euw euw = (euw) objArr[1];
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
                        euw.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(115925);
                    return 0;
                case 2:
                    euw.MKC = aVar3.UbS.readString();
                    AppMethodBeat.o(115925);
                    return 0;
                case 3:
                    euw.LsZ = aVar3.UbS.zi();
                    AppMethodBeat.o(115925);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        euw.Lev = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(115925);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        etn etn = new etn();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = etn.populateBuilderWithField(aVar6, etn, dop.getNextFieldNumber(aVar6))) {
                        }
                        euw.NsX = etn;
                    }
                    AppMethodBeat.o(115925);
                    return 0;
                case 6:
                    euw.Lta = aVar3.UbS.zl();
                    AppMethodBeat.o(115925);
                    return 0;
                case 7:
                    euw.Leu = aVar3.UbS.zi();
                    AppMethodBeat.o(115925);
                    return 0;
                case 8:
                    euw.NpN = aVar3.UbS.zl();
                    AppMethodBeat.o(115925);
                    return 0;
                default:
                    AppMethodBeat.o(115925);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115925);
            return -1;
        }
    }
}
