package com.google.a;

import com.google.a.a;
import com.google.a.ab;
import com.google.a.ae;
import com.google.a.ah;
import com.google.a.at;
import com.google.a.ba;
import com.google.a.cc;
import com.google.a.cj;
import com.google.a.l;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class ac extends a implements Serializable {
    protected static boolean bVU = false;
    protected cc bTW;

    /* access modifiers changed from: protected */
    public interface b extends a.b {
    }

    public interface e extends az {
    }

    /* access modifiers changed from: protected */
    public abstract f Ay();

    /* access modifiers changed from: protected */
    public abstract at.a a(b bVar);

    protected ac() {
        this.bTW = cc.HK();
    }

    protected ac(a<?> aVar) {
        this.bTW = aVar.Ax();
    }

    @Override // com.google.a.aw
    public bj<? extends ac> AK() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    @Override // com.google.a.az
    public final l.a AS() {
        return Ay().bNK;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Map<l.f, Object> bE(boolean z) {
        boolean z2;
        TreeMap treeMap = new TreeMap();
        List<l.f> fields = Ay().bNK.getFields();
        int i2 = 0;
        while (i2 < fields.size()) {
            l.f fVar = fields.get(i2);
            l.j jVar = fVar.bSU;
            if (jVar != null) {
                i2 += jVar.bTQ - 1;
                if (((ae.a) a(Ay().e(jVar).bWG, this, new Object[0])).getNumber() == 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    f.c e2 = Ay().e(jVar);
                    int number = ((ae.a) a(e2.bWG, this, new Object[0])).getNumber();
                    if (number > 0) {
                        fVar = e2.bNK.gz(number);
                    } else {
                        fVar = null;
                    }
                } else {
                    i2++;
                }
            } else {
                if (fVar.FJ()) {
                    List list = (List) f(fVar);
                    if (!list.isEmpty()) {
                        treeMap.put(fVar, list);
                    }
                } else if (!e(fVar)) {
                }
                i2++;
            }
            if (!z || fVar.bSS.bTz != l.f.a.STRING) {
                treeMap.put(fVar, f(fVar));
                i2++;
            } else {
                treeMap.put(fVar, Ay().i(fVar).c(this));
                i2++;
            }
        }
        return treeMap;
    }

    @Override // com.google.a.a, com.google.a.ax
    public boolean isInitialized() {
        for (l.f fVar : Ay().bNK.getFields()) {
            if (fVar.FH() && !e(fVar)) {
                return false;
            }
            if (fVar.bSS.bTz == l.f.a.MESSAGE) {
                if (fVar.FJ()) {
                    for (at atVar : (List) f(fVar)) {
                        if (!atVar.isInitialized()) {
                            return false;
                        }
                    }
                    continue;
                } else if (e(fVar) && !((at) f(fVar)).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.google.a.az
    public Map<l.f, Object> FS() {
        return Collections.unmodifiableMap(bE(false));
    }

    /* access modifiers changed from: package-private */
    public Map<l.f, Object> Gu() {
        return Collections.unmodifiableMap(bE(true));
    }

    @Override // com.google.a.az
    public boolean e(l.f fVar) {
        return Ay().i(fVar).d(this);
    }

    @Override // com.google.a.az
    public Object f(l.f fVar) {
        return Ay().i(fVar).b(this);
    }

    @Override // com.google.a.az
    public cc Ax() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    protected static ae.d Gv() {
        return ad.GE();
    }

    protected static ae.d a(ae.d dVar) {
        int size = dVar.size();
        return dVar.gE(size == 0 ? 10 : size * 2);
    }

    @Override // com.google.a.aw, com.google.a.a
    public void a(i iVar) {
        ba.a(this, Gu(), iVar);
    }

    @Override // com.google.a.aw, com.google.a.a
    public int yC() {
        int i2 = this.bNa;
        if (i2 != -1) {
            return i2;
        }
        this.bNa = ba.a(this, Gu());
        return this.bNa;
    }

    /* access modifiers changed from: protected */
    public void Gw() {
    }

    /* access modifiers changed from: protected */
    @Override // com.google.a.a
    public final at.a a(final a.b bVar) {
        return a((b) new b() {
            /* class com.google.a.ac.AnonymousClass1 */

            @Override // com.google.a.a.b
            public final void yH() {
                bVar.yH();
            }
        });
    }

    public static abstract class a<BuilderType extends a<BuilderType>> extends a.AbstractC0085a<BuilderType> {
        private cc bTW;
        private b bWt;
        private a<BuilderType>.C0086a bWu;
        boolean bWv;

        /* access modifiers changed from: protected */
        public abstract f Ay();

        protected a() {
            this(null);
        }

        protected a(b bVar) {
            this.bTW = cc.HK();
            this.bWt = bVar;
        }

        /* access modifiers changed from: protected */
        public final void Gy() {
            if (this.bWt != null) {
                this.bWv = true;
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.a.AbstractC0085a
        public final void yF() {
            this.bWv = true;
        }

        /* renamed from: Bl */
        public BuilderType yG() {
            BuilderType buildertype = (BuilderType) ((a) AQ().AM());
            buildertype.c(Bm());
            return buildertype;
        }

        @Override // com.google.a.az, com.google.a.at.a
        public l.a AS() {
            return Ay().bNK;
        }

        @Override // com.google.a.az
        public Map<l.f, Object> FS() {
            return Collections.unmodifiableMap(Gz());
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private Map<l.f, Object> Gz() {
            TreeMap treeMap = new TreeMap();
            List<l.f> fields = Ay().bNK.getFields();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= fields.size()) {
                    return treeMap;
                }
                l.f fVar = fields.get(i3);
                l.j jVar = fVar.bSU;
                if (jVar != null) {
                    i3 += jVar.bTQ - 1;
                    if (a(jVar)) {
                        fVar = b(jVar);
                    } else {
                        i2 = i3 + 1;
                    }
                } else {
                    if (fVar.FJ()) {
                        List list = (List) f(fVar);
                        if (!list.isEmpty()) {
                            treeMap.put(fVar, list);
                        }
                    } else if (!e(fVar)) {
                    }
                    i2 = i3 + 1;
                }
                treeMap.put(fVar, f(fVar));
                i2 = i3 + 1;
            }
        }

        @Override // com.google.a.at.a
        public at.a h(l.f fVar) {
            return Ay().i(fVar).GD();
        }

        @Override // com.google.a.a.AbstractC0085a
        public final boolean a(l.j jVar) {
            return Ay().e(jVar).c(this);
        }

        @Override // com.google.a.a.AbstractC0085a
        public final l.f b(l.j jVar) {
            return Ay().e(jVar).f(this);
        }

        @Override // com.google.a.az
        public boolean e(l.f fVar) {
            return Ay().i(fVar).c(this);
        }

        @Override // com.google.a.az
        public Object f(l.f fVar) {
            Object b2 = Ay().i(fVar).b(this);
            if (fVar.FJ()) {
                return Collections.unmodifiableList((List) b2);
            }
            return b2;
        }

        /* renamed from: d */
        public BuilderType f(l.f fVar, Object obj) {
            Ay().i(fVar).a(this, obj);
            return this;
        }

        /* renamed from: c */
        public BuilderType e(l.f fVar, Object obj) {
            Ay().i(fVar).b(this, obj);
            return this;
        }

        /* renamed from: d */
        public BuilderType a(cc ccVar) {
            return f(cc.ac(this.bTW).ae(ccVar).Bp());
        }

        @Override // com.google.a.ax
        public boolean isInitialized() {
            for (l.f fVar : AS().getFields()) {
                if (fVar.FH() && !e(fVar)) {
                    return false;
                }
                if (fVar.bSS.bTz == l.f.a.MESSAGE) {
                    if (fVar.FJ()) {
                        for (at atVar : (List) f(fVar)) {
                            if (!atVar.isInitialized()) {
                                return false;
                            }
                        }
                        continue;
                    } else if (e(fVar) && !((at) f(fVar)).isInitialized()) {
                        return false;
                    }
                }
            }
            return true;
        }

        @Override // com.google.a.az
        public final cc Ax() {
            return this.bTW;
        }

        /* renamed from: com.google.a.ac$a$a  reason: collision with other inner class name */
        class C0086a implements b {
            private C0086a() {
            }

            /* synthetic */ C0086a(a aVar, byte b2) {
                this();
            }

            @Override // com.google.a.a.b
            public final void yH() {
                a.this.onChanged();
            }
        }

        /* access modifiers changed from: protected */
        public final b GA() {
            if (this.bWu == null) {
                this.bWu = new C0086a(this, (byte) 0);
            }
            return this.bWu;
        }

        /* access modifiers changed from: protected */
        public final void onChanged() {
            if (this.bWv && this.bWt != null) {
                this.bWt.yH();
                this.bWv = false;
            }
        }

        /* renamed from: e */
        public BuilderType f(cc ccVar) {
            this.bTW = ccVar;
            onChanged();
            return this;
        }
    }

    public static abstract class d<MessageType extends d> extends ac implements e<MessageType> {
        final x<l.f> bWd;

        protected d() {
            this.bWd = x.Gi();
        }

        protected d(c<MessageType, ?> cVar) {
            super(cVar);
            this.bWd = c.a((c) cVar);
        }

        @Override // com.google.a.a, com.google.a.ax, com.google.a.ac
        public boolean isInitialized() {
            return ac.super.isInitialized() && this.bWd.isInitialized();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final void Gw() {
            this.bWd.yK();
        }

        protected class a {
            private final Iterator<Map.Entry<l.f, Object>> bWx;
            private Map.Entry<l.f, Object> bWy;
            private final boolean bWz;

            /* synthetic */ a(d dVar, byte b2) {
                this();
            }

            private a() {
                this.bWx = d.this.bWd.iterator();
                if (this.bWx.hasNext()) {
                    this.bWy = this.bWx.next();
                }
                this.bWz = false;
            }

            public final void b(i iVar) {
                while (this.bWy != null && this.bWy.getKey().bSP.bPE < 536870912) {
                    l.f key = this.bWy.getKey();
                    if (!this.bWz || key.FE().caU != cj.b.MESSAGE || key.FJ()) {
                        x.a(key, this.bWy.getValue(), iVar);
                    } else if (this.bWy instanceof ah.a) {
                        iVar.b(key.bSP.bPE, ((ah.a) this.bWy).GP().yI());
                    } else {
                        iVar.b(key.bSP.bPE, (at) this.bWy.getValue());
                    }
                    if (this.bWx.hasNext()) {
                        this.bWy = this.bWx.next();
                    } else {
                        this.bWy = null;
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public final d<MessageType>.a GC() {
            return new a(this, (byte) 0);
        }

        @Override // com.google.a.az, com.google.a.ac
        public final Map<l.f, Object> FS() {
            Map bE = bE(false);
            bE.putAll(this.bWd.FS());
            return Collections.unmodifiableMap(bE);
        }

        @Override // com.google.a.ac
        public final Map<l.f, Object> Gu() {
            Map bE = bE(false);
            bE.putAll(this.bWd.FS());
            return Collections.unmodifiableMap(bE);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.ac
        public final boolean a(h hVar, cc.a aVar, r rVar, int i2) {
            cc.a aVar2;
            if (hVar.bNr) {
                aVar2 = null;
            } else {
                aVar2 = aVar;
            }
            return ba.a(hVar, aVar2, rVar, AS(), new ba.b(this.bWd), i2);
        }

        @Override // com.google.a.az, com.google.a.ac
        public final boolean e(l.f fVar) {
            if (!fVar.bSP.Cp()) {
                return ac.super.e(fVar);
            }
            g(fVar);
            return this.bWd.a(fVar);
        }

        @Override // com.google.a.az, com.google.a.ac
        public final Object f(l.f fVar) {
            if (!fVar.bSP.Cp()) {
                return ac.super.f(fVar);
            }
            g(fVar);
            Object b2 = this.bWd.b(fVar);
            if (b2 != null) {
                return b2;
            }
            if (fVar.FJ()) {
                return Collections.emptyList();
            }
            if (fVar.bSS.bTz == l.f.a.MESSAGE) {
                return m.c(fVar.FN());
            }
            return fVar.getDefaultValue();
        }

        private void g(l.f fVar) {
            if (fVar.bSs != AS()) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }
    }

    public static abstract class c<MessageType extends d, BuilderType extends c<MessageType, BuilderType>> extends a<BuilderType> implements e<MessageType> {
        x<l.f> bWd = x.Gj();

        protected c() {
        }

        protected c(b bVar) {
            super(bVar);
        }

        private void GB() {
            if (this.bWd.bUC) {
                this.bWd = this.bWd.clone();
            }
        }

        @Override // com.google.a.ax, com.google.a.ac.a
        public boolean isInitialized() {
            return super.isInitialized() && this.bWd.isInitialized();
        }

        @Override // com.google.a.az, com.google.a.ac.a
        public final Map<l.f, Object> FS() {
            Map Gz = Gz();
            Gz.putAll(this.bWd.FS());
            return Collections.unmodifiableMap(Gz);
        }

        /* access modifiers changed from: protected */
        public final void a(d dVar) {
            GB();
            this.bWd.a(dVar.bWd);
            onChanged();
        }

        @Override // com.google.a.az, com.google.a.ac.a
        public final Object f(l.f fVar) {
            if (!fVar.bSP.Cp()) {
                return super.f(fVar);
            }
            g(fVar);
            Object b2 = this.bWd.b(fVar);
            if (b2 != null) {
                return b2;
            }
            if (fVar.bSS.bTz == l.f.a.MESSAGE) {
                return m.c(fVar.FN());
            }
            return fVar.getDefaultValue();
        }

        @Override // com.google.a.az, com.google.a.ac.a
        public final boolean e(l.f fVar) {
            if (!fVar.bSP.Cp()) {
                return super.e(fVar);
            }
            g(fVar);
            return this.bWd.a(fVar);
        }

        /* renamed from: r */
        public BuilderType f(l.f fVar, Object obj) {
            if (!fVar.bSP.Cp()) {
                return (BuilderType) ((c) super.f(fVar, obj));
            }
            g(fVar);
            GB();
            this.bWd.a(fVar, obj);
            onChanged();
            return this;
        }

        /* renamed from: q */
        public BuilderType e(l.f fVar, Object obj) {
            if (!fVar.bSP.Cp()) {
                return (BuilderType) ((c) super.e(fVar, obj));
            }
            g(fVar);
            GB();
            this.bWd.b(fVar, obj);
            onChanged();
            return this;
        }

        @Override // com.google.a.ac.a, com.google.a.at.a
        public final at.a h(l.f fVar) {
            if (fVar.bSP.Cp()) {
                return m.d(fVar.FN());
            }
            return super.h(fVar);
        }

        private void g(l.f fVar) {
            if (fVar.bSs != AS()) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }

        static /* synthetic */ x a(c cVar) {
            cVar.bWd.yK();
            return cVar.bWd;
        }
    }

    /* access modifiers changed from: private */
    public static Method b(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e2);
        }
    }

    /* access modifiers changed from: private */
    public static Object a(Method method, Object obj, Object... objArr) {
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

    /* access modifiers changed from: protected */
    public final an Gx() {
        throw new RuntimeException("No map fields found in " + getClass().getName());
    }

    public static final class f {
        final l.a bNK;
        private final a[] bWB;
        private String[] bWC;
        private final c[] bWD;
        private volatile boolean initialized = false;

        /* access modifiers changed from: package-private */
        public interface a {
            at.a GD();

            void a(a aVar, Object obj);

            Object b(a aVar);

            Object b(ac acVar);

            void b(a aVar, Object obj);

            Object c(ac acVar);

            boolean c(a aVar);

            boolean d(ac acVar);
        }

        public f(l.a aVar, String[] strArr) {
            this.bNK = aVar;
            this.bWC = strArr;
            this.bWB = new a[aVar.getFields().size()];
            this.bWD = new c[aVar.Fy().size()];
        }

        public final f h(Class<? extends ac> cls, Class<? extends a> cls2) {
            if (!this.initialized) {
                synchronized (this) {
                    if (!this.initialized) {
                        int length = this.bWB.length;
                        for (int i2 = 0; i2 < length; i2++) {
                            l.f fVar = this.bNK.getFields().get(i2);
                            String str = fVar.bSU != null ? this.bWC[fVar.bSU.index + length] : null;
                            if (fVar.FJ()) {
                                if (fVar.bSS.bTz == l.f.a.MESSAGE) {
                                    if (fVar.FG()) {
                                        this.bWB[i2] = new b(fVar, cls);
                                    } else {
                                        this.bWB[i2] = new C0087f(this.bWC[i2], cls, cls2);
                                    }
                                } else if (fVar.bSS.bTz == l.f.a.ENUM) {
                                    this.bWB[i2] = new d(fVar, this.bWC[i2], cls, cls2);
                                } else {
                                    this.bWB[i2] = new e(this.bWC[i2], cls, cls2);
                                }
                            } else if (fVar.bSS.bTz == l.f.a.MESSAGE) {
                                this.bWB[i2] = new i(fVar, this.bWC[i2], cls, cls2, str);
                            } else if (fVar.bSS.bTz == l.f.a.ENUM) {
                                this.bWB[i2] = new g(fVar, this.bWC[i2], cls, cls2, str);
                            } else if (fVar.bSS.bTz == l.f.a.STRING) {
                                this.bWB[i2] = new j(fVar, this.bWC[i2], cls, cls2, str);
                            } else {
                                this.bWB[i2] = new h(fVar, this.bWC[i2], cls, cls2, str);
                            }
                        }
                        int length2 = this.bWD.length;
                        for (int i3 = 0; i3 < length2; i3++) {
                            this.bWD[i3] = new c(this.bNK, this.bWC[i3 + length], cls, cls2);
                        }
                        this.initialized = true;
                        this.bWC = null;
                    }
                }
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        public static class c {
            final l.a bNK;
            final Method bWG;
            private final Method bWH;
            private final Method bWI;

            c(l.a aVar, String str, Class<? extends ac> cls, Class<? extends a> cls2) {
                this.bNK = aVar;
                this.bWG = ac.b(cls, "get" + str + "Case", new Class[0]);
                this.bWH = ac.b(cls2, "get" + str + "Case", new Class[0]);
                this.bWI = ac.b(cls2, "clear".concat(String.valueOf(str)), new Class[0]);
            }

            public final boolean c(a aVar) {
                if (((ae.a) ac.a(this.bWH, aVar, new Object[0])).getNumber() == 0) {
                    return false;
                }
                return true;
            }

            public final l.f f(a aVar) {
                int number = ((ae.a) ac.a(this.bWH, aVar, new Object[0])).getNumber();
                if (number > 0) {
                    return this.bNK.gz(number);
                }
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        public static class h implements a {
            protected final l.f bWE;
            protected final Method bWG;
            protected final Method bWH;
            protected final Method bWI;
            protected final Class<?> bWR;
            protected final Method bWS;
            protected final Method bWT;
            protected final Method bXf;
            protected final Method bXg;
            protected final Method bXh;
            protected final boolean bXi;
            protected final boolean bXj;

            h(l.f fVar, String str, Class<? extends ac> cls, Class<? extends a> cls2, String str2) {
                boolean z;
                boolean z2;
                Method method;
                Method method2;
                Method method3;
                Method method4 = null;
                this.bWE = fVar;
                if (fVar.bSU != null) {
                    z = true;
                } else {
                    z = false;
                }
                this.bXi = z;
                if (fVar.bSr.FQ() == l.g.a.PROTO2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.bXj = z2 || (!this.bXi && fVar.bSS.bTz == l.f.a.MESSAGE);
                this.bWS = ac.b(cls, "get".concat(String.valueOf(str)), new Class[0]);
                this.bWT = ac.b(cls2, "get".concat(String.valueOf(str)), new Class[0]);
                this.bWR = this.bWS.getReturnType();
                this.bXf = ac.b(cls2, "set".concat(String.valueOf(str)), new Class[]{this.bWR});
                if (this.bXj) {
                    method = ac.b(cls, "has".concat(String.valueOf(str)), new Class[0]);
                } else {
                    method = null;
                }
                this.bXg = method;
                if (this.bXj) {
                    method2 = ac.b(cls2, "has".concat(String.valueOf(str)), new Class[0]);
                } else {
                    method2 = null;
                }
                this.bXh = method2;
                this.bWI = ac.b(cls2, "clear".concat(String.valueOf(str)), new Class[0]);
                if (this.bXi) {
                    method3 = ac.b(cls, "get" + str2 + "Case", new Class[0]);
                } else {
                    method3 = null;
                }
                this.bWG = method3;
                this.bWH = this.bXi ? ac.b(cls2, "get" + str2 + "Case", new Class[0]) : method4;
            }

            @Override // com.google.a.ac.f.a
            public Object b(ac acVar) {
                return ac.a(this.bWS, acVar, new Object[0]);
            }

            @Override // com.google.a.ac.f.a
            public Object b(a aVar) {
                return ac.a(this.bWT, aVar, new Object[0]);
            }

            @Override // com.google.a.ac.f.a
            public Object c(ac acVar) {
                return b(acVar);
            }

            @Override // com.google.a.ac.f.a
            public void a(a aVar, Object obj) {
                ac.a(this.bXf, aVar, new Object[]{obj});
            }

            @Override // com.google.a.ac.f.a
            public final void b(a aVar, Object obj) {
                throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
            }

            @Override // com.google.a.ac.f.a
            public final boolean d(ac acVar) {
                if (!this.bXj) {
                    return this.bXi ? ((ae.a) ac.a(this.bWG, acVar, new Object[0])).getNumber() == this.bWE.bSP.bPE : !b(acVar).equals(this.bWE.getDefaultValue());
                }
                return ((Boolean) ac.a(this.bXg, acVar, new Object[0])).booleanValue();
            }

            @Override // com.google.a.ac.f.a
            public final boolean c(a aVar) {
                if (!this.bXj) {
                    return this.bXi ? ((ae.a) ac.a(this.bWH, aVar, new Object[0])).getNumber() == this.bWE.bSP.bPE : !b(aVar).equals(this.bWE.getDefaultValue());
                }
                return ((Boolean) ac.a(this.bXh, aVar, new Object[0])).booleanValue();
            }

            @Override // com.google.a.ac.f.a
            public at.a GD() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }
        }

        /* access modifiers changed from: package-private */
        public static class e implements a {
            protected final Method bWI;
            protected final Class bWR = this.bWU.getReturnType();
            protected final Method bWS;
            protected final Method bWT;
            protected final Method bWU;
            protected final Method bWV;
            protected final Method bWW;
            protected final Method bWX;
            protected final Method bWY;
            protected final Method bWZ;

            e(String str, Class<? extends ac> cls, Class<? extends a> cls2) {
                this.bWS = ac.b(cls, "get" + str + "List", new Class[0]);
                this.bWT = ac.b(cls2, "get" + str + "List", new Class[0]);
                this.bWU = ac.b(cls, "get".concat(String.valueOf(str)), new Class[]{Integer.TYPE});
                this.bWV = ac.b(cls2, "get".concat(String.valueOf(str)), new Class[]{Integer.TYPE});
                this.bWW = ac.b(cls2, "set".concat(String.valueOf(str)), new Class[]{Integer.TYPE, this.bWR});
                this.bWX = ac.b(cls2, "add".concat(String.valueOf(str)), new Class[]{this.bWR});
                this.bWY = ac.b(cls, "get" + str + "Count", new Class[0]);
                this.bWZ = ac.b(cls2, "get" + str + "Count", new Class[0]);
                this.bWI = ac.b(cls2, "clear".concat(String.valueOf(str)), new Class[0]);
            }

            @Override // com.google.a.ac.f.a
            public Object b(ac acVar) {
                return ac.a(this.bWS, acVar, new Object[0]);
            }

            @Override // com.google.a.ac.f.a
            public Object b(a aVar) {
                return ac.a(this.bWT, aVar, new Object[0]);
            }

            @Override // com.google.a.ac.f.a
            public final Object c(ac acVar) {
                return b(acVar);
            }

            public Object a(ac acVar, int i2) {
                return ac.a(this.bWU, acVar, new Object[]{Integer.valueOf(i2)});
            }

            public Object a(a aVar, int i2) {
                return ac.a(this.bWV, aVar, new Object[]{Integer.valueOf(i2)});
            }

            @Override // com.google.a.ac.f.a
            public void b(a aVar, Object obj) {
                ac.a(this.bWX, aVar, new Object[]{obj});
            }

            @Override // com.google.a.ac.f.a
            public final boolean d(ac acVar) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            @Override // com.google.a.ac.f.a
            public final boolean c(a aVar) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            public final int e(ac acVar) {
                return ((Integer) ac.a(this.bWY, acVar, new Object[0])).intValue();
            }

            public final int g(a aVar) {
                return ((Integer) ac.a(this.bWZ, aVar, new Object[0])).intValue();
            }

            @Override // com.google.a.ac.f.a
            public at.a GD() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }

            @Override // com.google.a.ac.f.a
            public final void a(a aVar, Object obj) {
                ac.a(this.bWI, aVar, new Object[0]);
                for (Object obj2 : (List) obj) {
                    b(aVar, obj2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public static class b implements a {
            private final l.f bWE;
            private final at bWF;

            b(l.f fVar, Class<? extends ac> cls) {
                this.bWE = fVar;
                this.bWF = ((ac) ac.a(ac.b(cls, "getDefaultInstance", new Class[0]), (Object) null, new Object[0])).Gx().bXW.Ha();
            }

            private at C(at atVar) {
                if (atVar == null) {
                    return null;
                }
                return !this.bWF.getClass().isInstance(atVar) ? this.bWF.AL().c(atVar).Bn() : atVar;
            }

            @Override // com.google.a.ac.f.a
            public final Object b(ac acVar) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < acVar.Gx().GW().size(); i2++) {
                    arrayList.add(acVar.Gx().GW().get(i2));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.a.ac.f.a
            public final Object b(a aVar) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < d(aVar).GW().size(); i2++) {
                    arrayList.add(d(aVar).GW().get(i2));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.a.ac.f.a
            public final Object c(ac acVar) {
                return b(acVar);
            }

            @Override // com.google.a.ac.f.a
            public final void b(a aVar, Object obj) {
                e(aVar).GX().add(C((at) obj));
            }

            @Override // com.google.a.ac.f.a
            public final boolean d(ac acVar) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            @Override // com.google.a.ac.f.a
            public final boolean c(a aVar) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            @Override // com.google.a.ac.f.a
            public final at.a GD() {
                return this.bWF.AM();
            }

            private static an<?, ?> d(a aVar) {
                throw new RuntimeException("No map fields found in " + aVar.getClass().getName());
            }

            private static an<?, ?> e(a aVar) {
                throw new RuntimeException("No map fields found in " + aVar.getClass().getName());
            }

            @Override // com.google.a.ac.f.a
            public final void a(a aVar, Object obj) {
                e(aVar).GX().clear();
                for (Object obj2 : (List) obj) {
                    b(aVar, obj2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public static final class g extends h {
            private l.d bWJ;
            private Method bWK = ac.b(this.bWR, "valueOf", new Class[]{l.e.class});
            private Method bWL = ac.b(this.bWR, "getValueDescriptor", new Class[0]);
            private boolean bWM;
            private Method bXc;
            private Method bXd;
            private Method bXe;

            g(l.f fVar, String str, Class<? extends ac> cls, Class<? extends a> cls2, String str2) {
                super(fVar, str, cls, cls2, str2);
                this.bWJ = fVar.FO();
                this.bWM = fVar.bSr.FR();
                if (this.bWM) {
                    this.bXc = ac.b(cls, "get" + str + "Value", new Class[0]);
                    this.bXd = ac.b(cls2, "get" + str + "Value", new Class[0]);
                    this.bXe = ac.b(cls2, "set" + str + "Value", new Class[]{Integer.TYPE});
                }
            }

            @Override // com.google.a.ac.f.a, com.google.a.ac.f.h
            public final Object b(ac acVar) {
                if (!this.bWM) {
                    return ac.a(this.bWL, super.b(acVar), new Object[0]);
                }
                return this.bWJ.gB(((Integer) ac.a(this.bXc, acVar, new Object[0])).intValue());
            }

            @Override // com.google.a.ac.f.a, com.google.a.ac.f.h
            public final Object b(a aVar) {
                if (!this.bWM) {
                    return ac.a(this.bWL, super.b(aVar), new Object[0]);
                }
                return this.bWJ.gB(((Integer) ac.a(this.bXd, aVar, new Object[0])).intValue());
            }

            @Override // com.google.a.ac.f.a, com.google.a.ac.f.h
            public final void a(a aVar, Object obj) {
                if (this.bWM) {
                    ac.a(this.bXe, aVar, new Object[]{Integer.valueOf(((l.e) obj).bSM.bPE)});
                    return;
                }
                super.a(aVar, ac.a(this.bWK, (Object) null, new Object[]{obj}));
            }
        }

        /* access modifiers changed from: package-private */
        public static final class d extends e {
            private l.d bWJ;
            private final Method bWK = ac.b(this.bWR, "valueOf", new Class[]{l.e.class});
            private final Method bWL = ac.b(this.bWR, "getValueDescriptor", new Class[0]);
            private boolean bWM;
            private Method bWN;
            private Method bWO;
            private Method bWP;
            private Method bWQ;

            d(l.f fVar, String str, Class<? extends ac> cls, Class<? extends a> cls2) {
                super(str, cls, cls2);
                this.bWJ = fVar.FO();
                this.bWM = fVar.bSr.FR();
                if (this.bWM) {
                    this.bWN = ac.b(cls, "get" + str + "Value", new Class[]{Integer.TYPE});
                    this.bWO = ac.b(cls2, "get" + str + "Value", new Class[]{Integer.TYPE});
                    this.bWP = ac.b(cls2, "set" + str + "Value", new Class[]{Integer.TYPE, Integer.TYPE});
                    this.bWQ = ac.b(cls2, "add" + str + "Value", new Class[]{Integer.TYPE});
                }
            }

            @Override // com.google.a.ac.f.a, com.google.a.ac.f.e
            public final Object b(ac acVar) {
                ArrayList arrayList = new ArrayList();
                int e2 = e(acVar);
                for (int i2 = 0; i2 < e2; i2++) {
                    arrayList.add(a(acVar, i2));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.a.ac.f.a, com.google.a.ac.f.e
            public final Object b(a aVar) {
                ArrayList arrayList = new ArrayList();
                int g2 = g(aVar);
                for (int i2 = 0; i2 < g2; i2++) {
                    arrayList.add(a(aVar, i2));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.a.ac.f.e
            public final Object a(ac acVar, int i2) {
                if (!this.bWM) {
                    return ac.a(this.bWL, super.a(acVar, i2), new Object[0]);
                }
                return this.bWJ.gB(((Integer) ac.a(this.bWN, acVar, new Object[]{Integer.valueOf(i2)})).intValue());
            }

            @Override // com.google.a.ac.f.e
            public final Object a(a aVar, int i2) {
                if (!this.bWM) {
                    return ac.a(this.bWL, super.a(aVar, i2), new Object[0]);
                }
                return this.bWJ.gB(((Integer) ac.a(this.bWO, aVar, new Object[]{Integer.valueOf(i2)})).intValue());
            }

            @Override // com.google.a.ac.f.a, com.google.a.ac.f.e
            public final void b(a aVar, Object obj) {
                if (this.bWM) {
                    ac.a(this.bWQ, aVar, new Object[]{Integer.valueOf(((l.e) obj).bSM.bPE)});
                    return;
                }
                super.b(aVar, ac.a(this.bWK, (Object) null, new Object[]{obj}));
            }
        }

        /* access modifiers changed from: package-private */
        public static final class j extends h {
            private final Method bXk;
            private final Method bXl;
            private final Method bXm;

            j(l.f fVar, String str, Class<? extends ac> cls, Class<? extends a> cls2, String str2) {
                super(fVar, str, cls, cls2, str2);
                this.bXk = ac.b(cls, "get" + str + "Bytes", new Class[0]);
                this.bXl = ac.b(cls2, "get" + str + "Bytes", new Class[0]);
                this.bXm = ac.b(cls2, "set" + str + "Bytes", new Class[]{g.class});
            }

            @Override // com.google.a.ac.f.a, com.google.a.ac.f.h
            public final Object c(ac acVar) {
                return ac.a(this.bXk, acVar, new Object[0]);
            }

            @Override // com.google.a.ac.f.a, com.google.a.ac.f.h
            public final void a(a aVar, Object obj) {
                if (obj instanceof g) {
                    ac.a(this.bXm, aVar, new Object[]{obj});
                    return;
                }
                super.a(aVar, obj);
            }
        }

        /* access modifiers changed from: package-private */
        public static final class i extends h {
            private final Method bXa = ac.b(this.bWR, "newBuilder", new Class[0]);
            private final Method bXb;

            i(l.f fVar, String str, Class<? extends ac> cls, Class<? extends a> cls2, String str2) {
                super(fVar, str, cls, cls2, str2);
                this.bXb = ac.b(cls2, "get" + str + "Builder", new Class[0]);
            }

            @Override // com.google.a.ac.f.a, com.google.a.ac.f.h
            public final at.a GD() {
                return (at.a) ac.a(this.bXa, (Object) null, new Object[0]);
            }

            @Override // com.google.a.ac.f.a, com.google.a.ac.f.h
            public final void a(a aVar, Object obj) {
                if (!this.bWR.isInstance(obj)) {
                    obj = ((at.a) ac.a(this.bXa, (Object) null, new Object[0])).c((at) obj).Bm();
                }
                super.a(aVar, obj);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.google.a.ac$f$f  reason: collision with other inner class name */
        public static final class C0087f extends e {
            private final Method bXa = ac.b(this.bWR, "newBuilder", new Class[0]);
            private final Method bXb;

            C0087f(String str, Class<? extends ac> cls, Class<? extends a> cls2) {
                super(str, cls, cls2);
                this.bXb = ac.b(cls2, "get" + str + "Builder", new Class[]{Integer.TYPE});
            }

            @Override // com.google.a.ac.f.a, com.google.a.ac.f.e
            public final at.a GD() {
                return (at.a) ac.a(this.bXa, (Object) null, new Object[0]);
            }

            @Override // com.google.a.ac.f.a, com.google.a.ac.f.e
            public final void b(a aVar, Object obj) {
                if (!this.bWR.isInstance(obj)) {
                    obj = ((at.a) ac.a(this.bXa, (Object) null, new Object[0])).c((at) obj).Bn();
                }
                super.b(aVar, obj);
            }
        }

        /* access modifiers changed from: package-private */
        public final a i(l.f fVar) {
            if (fVar.bSs != this.bNK) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            } else if (!fVar.bSP.Cp()) {
                return this.bWB[fVar.index];
            } else {
                throw new IllegalArgumentException("This type does not have extensions.");
            }
        }

        /* access modifiers changed from: package-private */
        public final c e(l.j jVar) {
            if (jVar.bSs == this.bNK) {
                return this.bWD[jVar.index];
            }
            throw new IllegalArgumentException("OneofDescriptor does not match message type.");
        }
    }

    /* access modifiers changed from: protected */
    public Object writeReplace() {
        return new ab.f(this);
    }

    protected static int d(int i2, Object obj) {
        if (obj instanceof String) {
            return i.f(i2, (String) obj);
        }
        return i.c(i2, (g) obj);
    }

    protected static int ar(Object obj) {
        if (obj instanceof String) {
            return i.cb((String) obj);
        }
        return i.b((g) obj);
    }

    protected static void a(i iVar, int i2, Object obj) {
        if (obj instanceof String) {
            iVar.e(i2, (String) obj);
        } else {
            iVar.a(i2, (g) obj);
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(h hVar, cc.a aVar, r rVar, int i2) {
        if (hVar.bNr) {
            return hVar.fG(i2);
        }
        return aVar.a(i2, hVar);
    }
}
