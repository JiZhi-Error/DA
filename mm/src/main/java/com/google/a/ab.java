package com.google.a;

import com.google.a.ab;
import com.google.a.ab.a;
import com.google.a.aw;
import com.google.a.b;
import com.google.a.cj;
import com.google.a.x;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ab<MessageType extends ab<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends b<MessageType, BuilderType> {
    private static Map<Object, ab<?, ?>> bVZ = new ConcurrentHashMap();
    protected cd bVX = cd.HR();
    protected int bVY = -1;

    public interface c extends ax {
    }

    public enum e {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    /* access modifiers changed from: protected */
    public abstract Object Go();

    private MessageType Gm() {
        e eVar = e.GET_DEFAULT_INSTANCE;
        return (MessageType) ((ab) Go());
    }

    public final BuilderType Gn() {
        e eVar = e.NEW_BUILDER;
        return (BuilderType) ((a) Go());
    }

    public String toString() {
        String obj = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ").append(obj);
        ay.a(this, sb, 0);
        return sb.toString();
    }

    public int hashCode() {
        if (this.bNb != 0) {
            return this.bNb;
        }
        this.bNb = bm.Hl().av(this).hashCode(this);
        return this.bNb;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Gm().getClass().isInstance(obj)) {
            return false;
        }
        return bm.Hl().av(this).equals(this, (ab) obj);
    }

    /* access modifiers changed from: protected */
    public final Object Gp() {
        return Go();
    }

    /* access modifiers changed from: package-private */
    public final Object Gq() {
        e eVar = e.BUILD_MESSAGE_INFO;
        return Go();
    }

    static <T extends ab<?, ?>> T F(Class<T> cls) {
        ab<?, ?> abVar = bVZ.get(cls);
        if (abVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                abVar = (T) bVZ.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (abVar == null) {
            abVar = (T) ((ab) ch.J(cls)).Gm();
            if (abVar == null) {
                throw new IllegalStateException();
            }
            bVZ.put(cls, abVar);
        }
        return (T) abVar;
    }

    public static abstract class a<MessageType extends ab<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends b.a<MessageType, BuilderType> {
        private final MessageType bWa;
        protected MessageType bWb;
        protected boolean bWc;

        private static void a(MessageType messagetype, MessageType messagetype2) {
            bm.Hl().av(messagetype).n(messagetype, messagetype2);
        }

        public final BuilderType a(MessageType messagetype) {
            if (this.bWc) {
                MessageType messagetype2 = this.bWb;
                e eVar = e.NEW_MUTABLE_INSTANCE;
                MessageType messagetype3 = (MessageType) ((ab) messagetype2.Gp());
                a(messagetype3, this.bWb);
                this.bWb = messagetype3;
                this.bWc = false;
            }
            a(this.bWb, messagetype);
            return this;
        }

        @Override // com.google.a.b.a, java.lang.Object
        public /* synthetic */ Object clone() {
            MessageType messagetype;
            a Gn = this.bWa.Gn();
            if (this.bWc) {
                messagetype = this.bWb;
            } else {
                MessageType messagetype2 = this.bWb;
                bm.Hl().av(messagetype2).ap(messagetype2);
                this.bWc = true;
                messagetype = this.bWb;
            }
            Gn.a((ab) messagetype);
            return Gn;
        }
    }

    public static abstract class b<MessageType extends b<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>> extends ab<MessageType, BuilderType> implements c<MessageType, BuilderType> {
        protected x<d> bWd = x.Gj();

        /* access modifiers changed from: package-private */
        public final x<d> Gr() {
            if (this.bWd.bUC) {
                this.bWd = this.bWd.clone();
            }
            return this.bWd;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class d implements x.a<d> {
        final cj.a bWe;
        final boolean bWf;
        final boolean bWg;
        final int number;

        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return this.number - ((d) obj).number;
        }

        @Override // com.google.a.x.a
        public final int getNumber() {
            return this.number;
        }

        @Override // com.google.a.x.a
        public final cj.a FE() {
            return this.bWe;
        }

        @Override // com.google.a.x.a
        public final cj.b FD() {
            return this.bWe.caU;
        }

        @Override // com.google.a.x.a
        public final boolean FJ() {
            return this.bWf;
        }

        @Override // com.google.a.x.a
        public final boolean FK() {
            return this.bWg;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.google.a.ab$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.a.x.a
        public final aw.a a(aw.a aVar, aw awVar) {
            return ((a) aVar).a((ab) awVar);
        }
    }

    static Object a(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static final class f implements Serializable {
        private final Class<?> bUq;
        private final String bWp = this.bUq.getName();
        private final byte[] bWq;

        f(aw awVar) {
            this.bUq = awVar.getClass();
            this.bWq = awVar.toByteArray();
        }

        /* access modifiers changed from: protected */
        public final Object readResolve() {
            try {
                Field declaredField = Gt().getDeclaredField("DEFAULT_INSTANCE");
                declaredField.setAccessible(true);
                return ((aw) declaredField.get(null)).AO().x(this.bWq).Bo();
            } catch (ClassNotFoundException e2) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.bWp, e2);
            } catch (NoSuchFieldException e3) {
                return Gs();
            } catch (SecurityException e4) {
                throw new RuntimeException("Unable to call DEFAULT_INSTANCE in " + this.bWp, e4);
            } catch (IllegalAccessException e5) {
                throw new RuntimeException("Unable to call parsePartialFrom", e5);
            } catch (af e6) {
                throw new RuntimeException("Unable to understand proto buffer", e6);
            }
        }

        @Deprecated
        private Object Gs() {
            try {
                Field declaredField = Gt().getDeclaredField("defaultInstance");
                declaredField.setAccessible(true);
                return ((aw) declaredField.get(null)).AO().x(this.bWq).Bo();
            } catch (ClassNotFoundException e2) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.bWp, e2);
            } catch (NoSuchFieldException e3) {
                throw new RuntimeException("Unable to find defaultInstance in " + this.bWp, e3);
            } catch (SecurityException e4) {
                throw new RuntimeException("Unable to call defaultInstance in " + this.bWp, e4);
            } catch (IllegalAccessException e5) {
                throw new RuntimeException("Unable to call parsePartialFrom", e5);
            } catch (af e6) {
                throw new RuntimeException("Unable to understand proto buffer", e6);
            }
        }

        private Class<?> Gt() {
            return this.bUq != null ? this.bUq : Class.forName(this.bWp);
        }
    }
}
