package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class apj extends dop {
    public String LBr;
    public String clientId;
    public long commentId;
    public String content;
    public long hFK;
    public String objectNonceId;
    public int opType;
    public long replyCommentId;
    public int scene;
    public String sessionBuffer;
    public int tCE;
    public long tuf;
    public aov uli;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168942);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.username != null) {
                aVar.e(2, this.username);
            }
            aVar.bb(3, this.hFK);
            if (this.content != null) {
                aVar.e(4, this.content);
            }
            aVar.bb(5, this.commentId);
            aVar.bb(6, this.replyCommentId);
            if (this.LBr != null) {
                aVar.e(7, this.LBr);
            }
            aVar.aM(8, this.opType);
            if (this.clientId != null) {
                aVar.e(9, this.clientId);
            }
            aVar.bb(10, this.tuf);
            aVar.aM(11, this.scene);
            if (this.objectNonceId != null) {
                aVar.e(12, this.objectNonceId);
            }
            if (this.uli != null) {
                aVar.ni(13, this.uli.computeSize());
                this.uli.writeFields(aVar);
            }
            if (this.sessionBuffer != null) {
                aVar.e(14, this.sessionBuffer);
            }
            aVar.aM(15, this.tCE);
            AppMethodBeat.o(168942);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.username != null) {
                nh += g.a.a.b.b.a.f(2, this.username);
            }
            int r = nh + g.a.a.b.b.a.r(3, this.hFK);
            if (this.content != null) {
                r += g.a.a.b.b.a.f(4, this.content);
            }
            int r2 = r + g.a.a.b.b.a.r(5, this.commentId) + g.a.a.b.b.a.r(6, this.replyCommentId);
            if (this.LBr != null) {
                r2 += g.a.a.b.b.a.f(7, this.LBr);
            }
            int bu = r2 + g.a.a.b.b.a.bu(8, this.opType);
            if (this.clientId != null) {
                bu += g.a.a.b.b.a.f(9, this.clientId);
            }
            int r3 = bu + g.a.a.b.b.a.r(10, this.tuf) + g.a.a.b.b.a.bu(11, this.scene);
            if (this.objectNonceId != null) {
                r3 += g.a.a.b.b.a.f(12, this.objectNonceId);
            }
            if (this.uli != null) {
                r3 += g.a.a.a.nh(13, this.uli.computeSize());
            }
            if (this.sessionBuffer != null) {
                r3 += g.a.a.b.b.a.f(14, this.sessionBuffer);
            }
            int bu2 = r3 + g.a.a.b.b.a.bu(15, this.tCE);
            AppMethodBeat.o(168942);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(168942);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            apj apj = (apj) objArr[1];
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
                        apj.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(168942);
                    return 0;
                case 2:
                    apj.username = aVar3.UbS.readString();
                    AppMethodBeat.o(168942);
                    return 0;
                case 3:
                    apj.hFK = aVar3.UbS.zl();
                    AppMethodBeat.o(168942);
                    return 0;
                case 4:
                    apj.content = aVar3.UbS.readString();
                    AppMethodBeat.o(168942);
                    return 0;
                case 5:
                    apj.commentId = aVar3.UbS.zl();
                    AppMethodBeat.o(168942);
                    return 0;
                case 6:
                    apj.replyCommentId = aVar3.UbS.zl();
                    AppMethodBeat.o(168942);
                    return 0;
                case 7:
                    apj.LBr = aVar3.UbS.readString();
                    AppMethodBeat.o(168942);
                    return 0;
                case 8:
                    apj.opType = aVar3.UbS.zi();
                    AppMethodBeat.o(168942);
                    return 0;
                case 9:
                    apj.clientId = aVar3.UbS.readString();
                    AppMethodBeat.o(168942);
                    return 0;
                case 10:
                    apj.tuf = aVar3.UbS.zl();
                    AppMethodBeat.o(168942);
                    return 0;
                case 11:
                    apj.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(168942);
                    return 0;
                case 12:
                    apj.objectNonceId = aVar3.UbS.readString();
                    AppMethodBeat.o(168942);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        apj.uli = aov;
                    }
                    AppMethodBeat.o(168942);
                    return 0;
                case 14:
                    apj.sessionBuffer = aVar3.UbS.readString();
                    AppMethodBeat.o(168942);
                    return 0;
                case 15:
                    apj.tCE = aVar3.UbS.zi();
                    AppMethodBeat.o(168942);
                    return 0;
                default:
                    AppMethodBeat.o(168942);
                    return -1;
            }
        } else {
            AppMethodBeat.o(168942);
            return -1;
        }
    }
}
