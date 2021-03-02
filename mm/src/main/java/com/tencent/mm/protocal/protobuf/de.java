package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class de extends a {
    public int Brl;
    public long Brn;
    public int CreateTime;
    public dqi KHl;
    public dqi KHm;
    public dqi KHn;
    public int KHo;
    public SKBuiltinBuffer_t KHp;
    public String KHq;
    public String KHr;
    public int KHs;
    public int oTW;
    public int xKb;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133143);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KHl == null) {
                b bVar = new b("Not all required fields were included: FromUserName");
                AppMethodBeat.o(133143);
                throw bVar;
            } else if (this.KHm == null) {
                b bVar2 = new b("Not all required fields were included: ToUserName");
                AppMethodBeat.o(133143);
                throw bVar2;
            } else if (this.KHn == null) {
                b bVar3 = new b("Not all required fields were included: Content");
                AppMethodBeat.o(133143);
                throw bVar3;
            } else if (this.KHp == null) {
                b bVar4 = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(133143);
                throw bVar4;
            } else {
                aVar.aM(1, this.Brl);
                if (this.KHl != null) {
                    aVar.ni(2, this.KHl.computeSize());
                    this.KHl.writeFields(aVar);
                }
                if (this.KHm != null) {
                    aVar.ni(3, this.KHm.computeSize());
                    this.KHm.writeFields(aVar);
                }
                aVar.aM(4, this.xKb);
                if (this.KHn != null) {
                    aVar.ni(5, this.KHn.computeSize());
                    this.KHn.writeFields(aVar);
                }
                aVar.aM(6, this.oTW);
                aVar.aM(7, this.KHo);
                if (this.KHp != null) {
                    aVar.ni(8, this.KHp.computeSize());
                    this.KHp.writeFields(aVar);
                }
                aVar.aM(9, this.CreateTime);
                if (this.KHq != null) {
                    aVar.e(10, this.KHq);
                }
                if (this.KHr != null) {
                    aVar.e(11, this.KHr);
                }
                aVar.bb(12, this.Brn);
                aVar.aM(13, this.KHs);
                AppMethodBeat.o(133143);
                return 0;
            }
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Brl) + 0;
            if (this.KHl != null) {
                bu += g.a.a.a.nh(2, this.KHl.computeSize());
            }
            if (this.KHm != null) {
                bu += g.a.a.a.nh(3, this.KHm.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.xKb);
            if (this.KHn != null) {
                bu2 += g.a.a.a.nh(5, this.KHn.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(6, this.oTW) + g.a.a.b.b.a.bu(7, this.KHo);
            if (this.KHp != null) {
                bu3 += g.a.a.a.nh(8, this.KHp.computeSize());
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(9, this.CreateTime);
            if (this.KHq != null) {
                bu4 += g.a.a.b.b.a.f(10, this.KHq);
            }
            if (this.KHr != null) {
                bu4 += g.a.a.b.b.a.f(11, this.KHr);
            }
            int r = bu4 + g.a.a.b.b.a.r(12, this.Brn) + g.a.a.b.b.a.bu(13, this.KHs);
            AppMethodBeat.o(133143);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KHl == null) {
                b bVar5 = new b("Not all required fields were included: FromUserName");
                AppMethodBeat.o(133143);
                throw bVar5;
            } else if (this.KHm == null) {
                b bVar6 = new b("Not all required fields were included: ToUserName");
                AppMethodBeat.o(133143);
                throw bVar6;
            } else if (this.KHn == null) {
                b bVar7 = new b("Not all required fields were included: Content");
                AppMethodBeat.o(133143);
                throw bVar7;
            } else if (this.KHp == null) {
                b bVar8 = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(133143);
                throw bVar8;
            } else {
                AppMethodBeat.o(133143);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            de deVar = (de) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    deVar.Brl = aVar3.UbS.zi();
                    AppMethodBeat.o(133143);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dqi.populateBuilderWithField(aVar4, dqi, a.getNextFieldNumber(aVar4))) {
                        }
                        deVar.KHl = dqi;
                    }
                    AppMethodBeat.o(133143);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi2.populateBuilderWithField(aVar5, dqi2, a.getNextFieldNumber(aVar5))) {
                        }
                        deVar.KHm = dqi2;
                    }
                    AppMethodBeat.o(133143);
                    return 0;
                case 4:
                    deVar.xKb = aVar3.UbS.zi();
                    AppMethodBeat.o(133143);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi3 = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi3.populateBuilderWithField(aVar6, dqi3, a.getNextFieldNumber(aVar6))) {
                        }
                        deVar.KHn = dqi3;
                    }
                    AppMethodBeat.o(133143);
                    return 0;
                case 6:
                    deVar.oTW = aVar3.UbS.zi();
                    AppMethodBeat.o(133143);
                    return 0;
                case 7:
                    deVar.KHo = aVar3.UbS.zi();
                    AppMethodBeat.o(133143);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = sKBuiltinBuffer_t.populateBuilderWithField(aVar7, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar7))) {
                        }
                        deVar.KHp = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(133143);
                    return 0;
                case 9:
                    deVar.CreateTime = aVar3.UbS.zi();
                    AppMethodBeat.o(133143);
                    return 0;
                case 10:
                    deVar.KHq = aVar3.UbS.readString();
                    AppMethodBeat.o(133143);
                    return 0;
                case 11:
                    deVar.KHr = aVar3.UbS.readString();
                    AppMethodBeat.o(133143);
                    return 0;
                case 12:
                    deVar.Brn = aVar3.UbS.zl();
                    AppMethodBeat.o(133143);
                    return 0;
                case 13:
                    deVar.KHs = aVar3.UbS.zi();
                    AppMethodBeat.o(133143);
                    return 0;
                default:
                    AppMethodBeat.o(133143);
                    return -1;
            }
        } else {
            AppMethodBeat.o(133143);
            return -1;
        }
    }
}
