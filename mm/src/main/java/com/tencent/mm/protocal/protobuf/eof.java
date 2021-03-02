package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class eof extends dop {
    public SKBuiltinBuffer_t BsI;
    public String KXr;
    public esg Llj;
    public eoe Lll;
    public int Scene;
    public String xNG;
    public String xNH;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32487);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.Llj == null) {
                b bVar = new b("Not all required fields were included: VoiceAttr");
                AppMethodBeat.o(32487);
                throw bVar;
            } else if (this.Lll == null) {
                b bVar2 = new b("Not all required fields were included: UploadCtx");
                AppMethodBeat.o(32487);
                throw bVar2;
            } else if (this.BsI == null) {
                b bVar3 = new b("Not all required fields were included: Data");
                AppMethodBeat.o(32487);
                throw bVar3;
            } else {
                if (this.BaseRequest != null) {
                    aVar.ni(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.KXr != null) {
                    aVar.e(2, this.KXr);
                }
                if (this.Llj != null) {
                    aVar.ni(3, this.Llj.computeSize());
                    this.Llj.writeFields(aVar);
                }
                if (this.Lll != null) {
                    aVar.ni(4, this.Lll.computeSize());
                    this.Lll.writeFields(aVar);
                }
                if (this.BsI != null) {
                    aVar.ni(5, this.BsI.computeSize());
                    this.BsI.writeFields(aVar);
                }
                aVar.aM(6, this.Scene);
                if (this.xNH != null) {
                    aVar.e(7, this.xNH);
                }
                if (this.xNG != null) {
                    aVar.e(8, this.xNG);
                }
                AppMethodBeat.o(32487);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KXr != null) {
                nh += g.a.a.b.b.a.f(2, this.KXr);
            }
            if (this.Llj != null) {
                nh += g.a.a.a.nh(3, this.Llj.computeSize());
            }
            if (this.Lll != null) {
                nh += g.a.a.a.nh(4, this.Lll.computeSize());
            }
            if (this.BsI != null) {
                nh += g.a.a.a.nh(5, this.BsI.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.Scene);
            if (this.xNH != null) {
                bu += g.a.a.b.b.a.f(7, this.xNH);
            }
            if (this.xNG != null) {
                bu += g.a.a.b.b.a.f(8, this.xNG);
            }
            AppMethodBeat.o(32487);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Llj == null) {
                b bVar4 = new b("Not all required fields were included: VoiceAttr");
                AppMethodBeat.o(32487);
                throw bVar4;
            } else if (this.Lll == null) {
                b bVar5 = new b("Not all required fields were included: UploadCtx");
                AppMethodBeat.o(32487);
                throw bVar5;
            } else if (this.BsI == null) {
                b bVar6 = new b("Not all required fields were included: Data");
                AppMethodBeat.o(32487);
                throw bVar6;
            } else {
                AppMethodBeat.o(32487);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eof eof = (eof) objArr[1];
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
                        eof.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32487);
                    return 0;
                case 2:
                    eof.KXr = aVar3.UbS.readString();
                    AppMethodBeat.o(32487);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        esg esg = new esg();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = esg.populateBuilderWithField(aVar5, esg, dop.getNextFieldNumber(aVar5))) {
                        }
                        eof.Llj = esg;
                    }
                    AppMethodBeat.o(32487);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        eoe eoe = new eoe();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = eoe.populateBuilderWithField(aVar6, eoe, dop.getNextFieldNumber(aVar6))) {
                        }
                        eof.Lll = eoe;
                    }
                    AppMethodBeat.o(32487);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = sKBuiltinBuffer_t.populateBuilderWithField(aVar7, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar7))) {
                        }
                        eof.BsI = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(32487);
                    return 0;
                case 6:
                    eof.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(32487);
                    return 0;
                case 7:
                    eof.xNH = aVar3.UbS.readString();
                    AppMethodBeat.o(32487);
                    return 0;
                case 8:
                    eof.xNG = aVar3.UbS.readString();
                    AppMethodBeat.o(32487);
                    return 0;
                default:
                    AppMethodBeat.o(32487);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32487);
            return -1;
        }
    }
}
