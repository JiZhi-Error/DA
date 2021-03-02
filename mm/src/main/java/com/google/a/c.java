package com.google.a;

import com.google.a.aw;

public abstract class c<MessageType extends aw> implements bj<MessageType> {
    private static final r bNc = r.Gd();

    private static MessageType b(MessageType messagetype) {
        ca caVar;
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        if (messagetype instanceof b) {
            caVar = ((b) messagetype).yD();
        } else {
            caVar = new ca();
        }
        af afVar = new af(caVar.getMessage());
        afVar.bXr = messagetype;
        throw afVar;
    }

    private MessageType d(g gVar, r rVar) {
        try {
            h yQ = gVar.yQ();
            MessageType messagetype = (MessageType) ((aw) d(yQ, rVar));
            try {
                yQ.fF(0);
                return messagetype;
            } catch (af e2) {
                e2.bXr = messagetype;
                throw e2;
            }
        } catch (af e3) {
            throw e3;
        }
    }

    private MessageType a(byte[] bArr, int i2, r rVar) {
        try {
            h c2 = h.c(bArr, 0, i2, false);
            MessageType messagetype = (MessageType) ((aw) d(c2, rVar));
            try {
                c2.fF(0);
                return messagetype;
            } catch (af e2) {
                e2.bXr = messagetype;
                throw e2;
            }
        } catch (af e3) {
            throw e3;
        }
    }

    @Override // com.google.a.bj
    public final /* synthetic */ Object y(byte[] bArr) {
        return b(a(bArr, bArr.length, bNc));
    }

    @Override // com.google.a.bj
    public final /* synthetic */ Object e(g gVar, r rVar) {
        return b(d(gVar, rVar));
    }
}
