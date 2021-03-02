package com.google.a;

import com.google.a.a;
import com.google.a.ab;
import java.io.Serializable;

public abstract class z extends a implements Serializable {
    protected static boolean bVU = false;
    protected cc bTW = cc.HK();

    protected interface b extends a.b {
    }

    protected z() {
    }

    public static abstract class a<BuilderType extends a<BuilderType>> extends a.AbstractC0085a<BuilderType> {
        private cc bTW;
        private b bVV;

        protected a() {
            this((byte) 0);
        }

        private a(byte b2) {
            this.bTW = cc.HK();
            this.bVV = null;
        }

        @Override // com.google.a.b.a, com.google.a.a.AbstractC0085a, java.lang.Object
        public /* synthetic */ Object clone() {
            a aVar = (a) AQ().AM();
            aVar.c(Bm());
            return aVar;
        }
    }

    /* access modifiers changed from: protected */
    public Object writeReplace() {
        return new ab.f(this);
    }
}
