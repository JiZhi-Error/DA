package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.l.b.a.b.h.a;
import kotlin.l.b.a.b.h.h;
import kotlin.l.b.a.b.h.j;
import kotlin.l.b.a.b.h.l;
import kotlin.l.b.a.b.h.q;
import kotlin.l.b.a.b.h.z;

public abstract class i extends a implements Serializable {

    public interface d extends r {
    }

    protected i() {
    }

    protected i(byte b2) {
    }

    @Override // kotlin.l.b.a.b.h.q
    public s<? extends q> hEs() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    /* access modifiers changed from: protected */
    public boolean a(e eVar, f fVar, g gVar, int i2) {
        return eVar.a(i2, fVar);
    }

    /* access modifiers changed from: protected */
    public void Gw() {
    }

    public static abstract class a<MessageType extends i, BuilderType extends a> extends a.AbstractC2337a<BuilderType> {
        public d TwK = d.TDp;

        public abstract BuilderType a(MessageType messagetype);

        /* renamed from: hED */
        public abstract MessageType hEy();

        protected a() {
        }

        /* renamed from: hEE */
        public BuilderType hEF() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }
    }

    public static abstract class c<MessageType extends c<MessageType>> extends i implements d<MessageType> {
        protected final h<e> TDA;

        protected c() {
            this.TDA = h.hJx();
        }

        protected c(b<MessageType, ?> bVar) {
            this.TDA = b.a(bVar);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.l.b.a.b.h.i$f<MessageType extends kotlin.l.b.a.b.h.i$c<MessageType>, Type> */
        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> boolean c(f<MessageType, Type> fVar) {
            b(fVar);
            h<e> hVar = this.TDA;
            e eVar = fVar.TDH;
            if (!eVar.FJ()) {
                return hVar.TDy.get(eVar) != null;
            }
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }

        public final <Type> int d(f<MessageType, List<Type>> fVar) {
            b(fVar);
            h<e> hVar = this.TDA;
            e eVar = fVar.TDH;
            if (!eVar.FJ()) {
                throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
            }
            Object a2 = hVar.a(eVar);
            if (a2 == null) {
                return 0;
            }
            return ((List) a2).size();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.l.b.a.b.h.i$f<MessageType extends kotlin.l.b.a.b.h.i$c<MessageType>, Type> */
        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> Type e(f<MessageType, Type> fVar) {
            b(fVar);
            Type<Object> type = (Type) this.TDA.a(fVar.TDH);
            if (type == null) {
                return fVar.aEX;
            }
            if (!fVar.TDH.bWf) {
                return (Type) fVar.fw(type);
            }
            if (fVar.TDH.TDE.TEG != z.b.ENUM) {
                return type;
            }
            Type type2 = (Type) new ArrayList();
            for (Object obj : type) {
                type2.add(fVar.fw(obj));
            }
            return type2;
        }

        public final <Type> Type a(f<MessageType, List<Type>> fVar, int i2) {
            b(fVar);
            h<e> hVar = this.TDA;
            e eVar = fVar.TDH;
            if (!eVar.FJ()) {
                throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
            }
            Object a2 = hVar.a(eVar);
            if (a2 != null) {
                return (Type) fVar.fw(((List) a2).get(i2));
            }
            throw new IndexOutOfBoundsException();
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0052  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00ba  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x0153  */
        /* JADX WARNING: Removed duplicated region for block: B:6:0x002d  */
        @Override // kotlin.l.b.a.b.h.i
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(kotlin.l.b.a.b.h.e r9, kotlin.l.b.a.b.h.f r10, kotlin.l.b.a.b.h.g r11, int r12) {
            /*
            // Method dump skipped, instructions count: 362
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.h.i.c.a(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.f, kotlin.l.b.a.b.h.g, int):boolean");
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.l.b.a.b.h.i
        public final void Gw() {
            this.TDA.yK();
        }

        public class a {
            private final Iterator<Map.Entry<e, Object>> bWx;
            private Map.Entry<e, Object> bWy;
            private final boolean bWz;

            /* synthetic */ a(c cVar, byte b2) {
                this();
            }

            private a() {
                AppMethodBeat.i(59472);
                h hVar = c.this.TDA;
                this.bWx = hVar.bUD ? (Iterator<Map.Entry<FieldDescriptorType, Object>>) new l.b(hVar.TDy.entrySet().iterator()) : (Iterator<Map.Entry<FieldDescriptorType, Object>>) hVar.TDy.entrySet().iterator();
                if (this.bWx.hasNext()) {
                    this.bWy = this.bWx.next();
                }
                this.bWz = false;
                AppMethodBeat.o(59472);
            }

            public final void b(int i2, f fVar) {
                AppMethodBeat.i(59473);
                while (this.bWy != null && this.bWy.getKey().number < i2) {
                    e key = this.bWy.getKey();
                    if (!this.bWz || key.TDE.TEG != z.b.MESSAGE || key.bWf) {
                        h.a(key, this.bWy.getValue(), fVar);
                    } else {
                        fVar.b(key.number, (q) this.bWy.getValue());
                    }
                    if (this.bWx.hasNext()) {
                        this.bWy = this.bWx.next();
                    } else {
                        this.bWy = null;
                    }
                }
                AppMethodBeat.o(59473);
            }
        }

        /* access modifiers changed from: protected */
        public final c<MessageType>.a hJC() {
            return new a(this, (byte) 0);
        }

        private void b(f<MessageType, ?> fVar) {
            if (fVar.TDF != hEy()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }
    }

    public static abstract class b<MessageType extends c<MessageType>, BuilderType extends b<MessageType, BuilderType>> extends a<MessageType, BuilderType> implements d<MessageType> {
        protected h<e> TDA = h.hJy();
        private boolean TDB;

        protected b() {
        }

        /* renamed from: hFq */
        public BuilderType hEF() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        /* access modifiers changed from: protected */
        public final void a(MessageType messagetype) {
            if (!this.TDB) {
                this.TDA = this.TDA.hJz();
                this.TDB = true;
            }
            h<e> hVar = this.TDA;
            h hVar2 = messagetype.TDA;
            for (int i2 = 0; i2 < hVar2.TDy.Hx(); i2++) {
                hVar.b(hVar2.TDy.gM(i2));
            }
            for (Object obj : hVar2.TDy.Hy()) {
                hVar.b((Map.Entry) obj);
            }
        }

        static /* synthetic */ h a(b bVar) {
            bVar.TDA.yK();
            bVar.TDB = false;
            return bVar.TDA;
        }
    }

    public static <ContainingType extends q, Type> f<ContainingType, Type> a(ContainingType containingtype, Type type, q qVar, int i2, z.a aVar, Class cls) {
        return new f<>(containingtype, type, qVar, new e(i2, aVar, false), cls);
    }

    public static <ContainingType extends q, Type> f<ContainingType, Type> a(ContainingType containingtype, q qVar, int i2, z.a aVar, Class cls) {
        return new f<>(containingtype, Collections.emptyList(), qVar, new e(i2, aVar, true), cls);
    }

    /* access modifiers changed from: package-private */
    public static final class e implements h.a<e> {
        final j.b<?> TDD = null;
        final z.a TDE;
        final boolean bWf;
        final boolean bWg;
        final int number;

        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return this.number - ((e) obj).number;
        }

        e(int i2, z.a aVar, boolean z) {
            this.number = i2;
            this.TDE = aVar;
            this.bWf = z;
            this.bWg = false;
        }

        @Override // kotlin.l.b.a.b.h.h.a
        public final int getNumber() {
            return this.number;
        }

        @Override // kotlin.l.b.a.b.h.h.a
        public final z.a hJA() {
            return this.TDE;
        }

        @Override // kotlin.l.b.a.b.h.h.a
        public final z.b hJB() {
            return this.TDE.TEG;
        }

        @Override // kotlin.l.b.a.b.h.h.a
        public final boolean FJ() {
            return this.bWf;
        }

        @Override // kotlin.l.b.a.b.h.h.a
        public final boolean FK() {
            return this.bWg;
        }

        @Override // kotlin.l.b.a.b.h.h.a
        public final q.a a(q.a aVar, q qVar) {
            AppMethodBeat.i(59474);
            a a2 = ((a) aVar).a((i) qVar);
            AppMethodBeat.o(59474);
            return a2;
        }
    }

    static Method b(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e2) {
            String valueOf = String.valueOf(String.valueOf(cls.getName()));
            String valueOf2 = String.valueOf(String.valueOf(str));
            throw new RuntimeException(new StringBuilder(valueOf.length() + 45 + valueOf2.length()).append("Generated message class \"").append(valueOf).append("\" missing method \"").append(valueOf2).append("\".").toString(), e2);
        }
    }

    static Object c(Method method, Object... objArr) {
        try {
            return method.invoke(null, objArr);
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

    public static class f<ContainingType extends q, Type> {
        final ContainingType TDF;
        final q TDG;
        final e TDH;
        final Class TDI;
        final Method TDJ;
        final Type aEX;

        f(ContainingType containingtype, Type type, q qVar, e eVar, Class cls) {
            AppMethodBeat.i(59475);
            if (containingtype == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Null containingTypeDefaultInstance");
                AppMethodBeat.o(59475);
                throw illegalArgumentException;
            } else if (eVar.TDE == z.a.MESSAGE && qVar == null) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Null messageDefaultInstance");
                AppMethodBeat.o(59475);
                throw illegalArgumentException2;
            } else {
                this.TDF = containingtype;
                this.aEX = type;
                this.TDG = qVar;
                this.TDH = eVar;
                this.TDI = cls;
                if (j.a.class.isAssignableFrom(cls)) {
                    this.TDJ = i.b(cls, "valueOf", Integer.TYPE);
                    AppMethodBeat.o(59475);
                    return;
                }
                this.TDJ = null;
                AppMethodBeat.o(59475);
            }
        }

        /* access modifiers changed from: package-private */
        public final Object fw(Object obj) {
            AppMethodBeat.i(59476);
            if (this.TDH.TDE.TEG == z.b.ENUM) {
                Object c2 = i.c(this.TDJ, (Integer) obj);
                AppMethodBeat.o(59476);
                return c2;
            }
            AppMethodBeat.o(59476);
            return obj;
        }

        /* access modifiers changed from: package-private */
        public final Object fx(Object obj) {
            AppMethodBeat.i(59477);
            if (this.TDH.TDE.TEG == z.b.ENUM) {
                Integer valueOf = Integer.valueOf(((j.a) obj).getNumber());
                AppMethodBeat.o(59477);
                return valueOf;
            }
            AppMethodBeat.o(59477);
            return obj;
        }
    }
}
