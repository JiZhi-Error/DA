package com.google.a;

import com.google.a.aw;
import com.google.a.b;
import com.google.a.b.a;
import com.google.a.g;
import java.io.IOException;

public abstract class b<MessageType extends b<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> implements aw {
    protected int bNb = 0;

    @Override // com.google.a.aw
    public final g yI() {
        try {
            g.f fE = g.fE(yC());
            a(fE.bNn);
            return fE.yS();
        } catch (IOException e2) {
            throw new RuntimeException(bW("ByteString"), e2);
        }
    }

    @Override // com.google.a.aw
    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[yC()];
            i C = i.C(bArr);
            a(C);
            C.zA();
            return bArr;
        } catch (IOException e2) {
            throw new RuntimeException(bW("byte array"), e2);
        }
    }

    /* access modifiers changed from: package-private */
    public ca yD() {
        return new ca();
    }

    private String bW(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    public static abstract class a<MessageType extends b<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> implements aw.a {
        /* access modifiers changed from: protected */
        public abstract BuilderType a(MessageType messagetype);

        /* renamed from: b */
        public abstract BuilderType c(h hVar, r rVar);

        /* renamed from: yG */
        public abstract BuilderType clone();

        public BuilderType a(h hVar) {
            return c(hVar, r.Gd());
        }

        public BuilderType b(g gVar, r rVar) {
            try {
                h yQ = gVar.yQ();
                c(yQ, rVar);
                yQ.fF(0);
                return this;
            } catch (af e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException(bX("ByteString"), e3);
            }
        }

        /* renamed from: w */
        public BuilderType x(byte[] bArr) {
            return n(bArr, 0, bArr.length);
        }

        private String bX(String str) {
            return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
        }

        public BuilderType n(byte[] bArr, int i2, int i3) {
            try {
                h c2 = h.c(bArr, i2, i3, false);
                a(c2);
                c2.fF(0);
                return this;
            } catch (af e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException(bX("byte array"), e3);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.a.b$a<MessageType extends com.google.a.b<MessageType, BuilderType>, BuilderType extends com.google.a.b$a<MessageType, BuilderType>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.a.aw.a
        public final /* synthetic */ aw.a a(aw awVar) {
            if (AP().getClass().isInstance(awVar)) {
                return a((b) awVar);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
    }
}
