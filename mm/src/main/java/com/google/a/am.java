package com.google.a;

/* access modifiers changed from: package-private */
public final class am implements bs {
    private static final av bXR = new av() {
        /* class com.google.a.am.AnonymousClass1 */

        @Override // com.google.a.av
        public final boolean C(Class<?> cls) {
            return false;
        }

        @Override // com.google.a.av
        public final au D(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }
    };
    private final av bXQ;

    private am(av avVar) {
        this.bXQ = (av) ae.checkNotNull(avVar, "messageInfoFactory");
    }

    @Override // com.google.a.bs
    public final <T> br<T> G(Class<T> cls) {
        bt.I(cls);
        au D = this.bXQ.D(cls);
        if (D.Hf()) {
            if (ab.class.isAssignableFrom(cls)) {
                return bc.a(bt.Hr(), v.Gg(), D.Hg());
            }
            return bc.a(bt.Hp(), v.Gh(), D.Hg());
        } else if (ab.class.isAssignableFrom(cls)) {
            if (a(D)) {
                return bb.a(D, bh.Hj(), al.GT(), bt.Hr(), v.Gg(), as.Hc());
            }
            return bb.a(D, bh.Hj(), al.GT(), bt.Hr(), null, as.Hc());
        } else if (a(D)) {
            return bb.a(D, bh.Hi(), al.GS(), bt.Hp(), v.Gh(), as.Hb());
        } else {
            return bb.a(D, bh.Hi(), al.GS(), bt.Hq(), null, as.Hb());
        }
    }

    private static boolean a(au auVar) {
        return auVar.He() == bl.PROTO2;
    }

    static class a implements av {
        private av[] bXS;

        a(av... avVarArr) {
            this.bXS = avVarArr;
        }

        @Override // com.google.a.av
        public final boolean C(Class<?> cls) {
            for (av avVar : this.bXS) {
                if (avVar.C(cls)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.a.av
        public final au D(Class<?> cls) {
            av[] avVarArr = this.bXS;
            for (av avVar : avVarArr) {
                if (avVar.C(cls)) {
                    return avVar.D(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }
    }

    private static av GU() {
        try {
            return (av) Class.forName("com.google.a.j").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e2) {
            return bXR;
        }
    }

    public am() {
        this(new a(aa.Gl(), GU()));
    }
}
