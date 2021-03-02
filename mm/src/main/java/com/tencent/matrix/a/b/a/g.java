package com.tencent.matrix.a.b.a;

import android.os.SystemClock;
import com.tencent.matrix.a.b.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public interface g {
    void Se();

    void Sf();

    int Sg();

    void ba(long j2);

    void d(c cVar);

    void onForeground(boolean z);

    public static abstract class a<RECORD extends a> {
        public boolean cTp = false;
        public boolean cTq = true;
        public final long time = SystemClock.uptimeMillis();

        /* renamed from: com.tencent.matrix.a.b.a.g$a$a  reason: collision with other inner class name */
        public static abstract class AbstractC0209a<RECORD extends a> {
            public final RECORD cTr;
            public final RECORD cTs;
            public final RECORD cTt = Si();
            public final long cTu;

            /* access modifiers changed from: protected */
            public abstract RECORD Si();

            public AbstractC0209a(RECORD record, RECORD record2) {
                this.cTr = record;
                this.cTs = record2;
                this.cTu = record2.time - record.time;
                this.cTt.cTp = true;
            }

            public final boolean isValid() {
                return this.cTr.cTq && this.cTs.cTq;
            }
        }

        public static abstract class c<ENTRY> {
            boolean cTq = true;

            public static abstract class b<DIGIT extends Number> extends c<b> {
                public DIGIT cTz;

                public abstract DIGIT a(DIGIT digit);

                public static <DIGIT extends Number> b<DIGIT> b(DIGIT digit) {
                    if (digit instanceof Integer) {
                        return new C0215c((Integer) digit);
                    }
                    if (digit instanceof Long) {
                        return new d((Long) digit);
                    }
                    if (digit instanceof Float) {
                        return new C0214b((Float) digit);
                    }
                    if (digit instanceof Double) {
                        return new C0213a((Double) digit);
                    }
                    throw new RuntimeException("unsupported digit: " + digit.getClass());
                }

                public b(DIGIT digit) {
                    this.cTz = digit;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    return this.cTz.equals(((b) obj).cTz);
                }

                public int hashCode() {
                    return Objects.hash(this.cTz);
                }

                public String toString() {
                    return String.valueOf(this.cTz);
                }

                /* access modifiers changed from: package-private */
                /* renamed from: com.tencent.matrix.a.b.a.g$a$c$b$c  reason: collision with other inner class name */
                public static class C0215c extends b<Integer> {
                    /* Return type fixed from 'java.lang.Number' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Number] */
                    @Override // com.tencent.matrix.a.b.a.g.a.c.b
                    public final /* synthetic */ Integer a(Integer num) {
                        return Integer.valueOf(((Integer) this.cTz).intValue() - num.intValue());
                    }

                    public C0215c(Integer num) {
                        super(num);
                    }
                }

                /* access modifiers changed from: package-private */
                public static class d extends b<Long> {
                    /* Return type fixed from 'java.lang.Number' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Number] */
                    @Override // com.tencent.matrix.a.b.a.g.a.c.b
                    public final /* synthetic */ Long a(Long l) {
                        return Long.valueOf(((Long) this.cTz).longValue() - l.longValue());
                    }

                    public d(Long l) {
                        super(l);
                    }
                }

                /* access modifiers changed from: package-private */
                /* renamed from: com.tencent.matrix.a.b.a.g$a$c$b$b  reason: collision with other inner class name */
                public static class C0214b extends b<Float> {
                    /* Return type fixed from 'java.lang.Number' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Number] */
                    @Override // com.tencent.matrix.a.b.a.g.a.c.b
                    public final /* synthetic */ Float a(Float f2) {
                        return Float.valueOf(((Float) this.cTz).floatValue() - f2.floatValue());
                    }

                    public C0214b(Float f2) {
                        super(f2);
                    }
                }

                /* access modifiers changed from: package-private */
                /* renamed from: com.tencent.matrix.a.b.a.g$a$c$b$a  reason: collision with other inner class name */
                public static class C0213a extends b<Double> {
                    /* Return type fixed from 'java.lang.Number' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Number] */
                    @Override // com.tencent.matrix.a.b.a.g.a.c.b
                    public final /* synthetic */ Double a(Double d2) {
                        return Double.valueOf(((Double) this.cTz).doubleValue() - d2.doubleValue());
                    }

                    public C0213a(Double d2) {
                        super(d2);
                    }
                }
            }

            /* renamed from: com.tencent.matrix.a.b.a.g$a$c$a  reason: collision with other inner class name */
            public static class C0212a<BEAN> extends c<C0212a> {
                public static final C0212a<?> cTy = new C0212a<Void>() {
                    /* class com.tencent.matrix.a.b.a.g.a.c.C0212a.AnonymousClass1 */
                };
                public BEAN value = null;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    return Objects.equals(String.valueOf(this.value), String.valueOf(((C0212a) obj).value));
                }

                public int hashCode() {
                    return Objects.hash(this.value);
                }

                public String toString() {
                    return String.valueOf(this.value);
                }
            }

            /* renamed from: com.tencent.matrix.a.b.a.g$a$c$c  reason: collision with other inner class name */
            public static class C0216c<ITEM extends c> extends c<C0216c> {
                public List<ITEM> list;

                public static <ITEM extends c> C0216c<ITEM> J(List<ITEM> list2) {
                    C0216c<ITEM> cVar = new C0216c<>();
                    cVar.list = list2;
                    return cVar;
                }

                public static C0216c<b<Integer>> r(int[] iArr) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 : iArr) {
                        arrayList.add(b.b(Integer.valueOf(i2)));
                    }
                    C0216c<b<Integer>> cVar = new C0216c<>();
                    cVar.list = arrayList;
                    return cVar;
                }

                public static <ITEM extends c> C0216c<ITEM> Sn() {
                    C0216c<ITEM> cVar = new C0216c<>();
                    cVar.list = new ArrayList();
                    return cVar;
                }

                private C0216c() {
                }
            }
        }

        public interface b<ENTRY extends c> {

            /* renamed from: com.tencent.matrix.a.b.a.g$a$b$b  reason: collision with other inner class name */
            public static class C0211b<DIGIT extends Number> implements b<c.b<DIGIT>> {
                static final C0211b cTw = new C0211b();

                public static <DIGIT extends Number> c.b<DIGIT> a(c.b<DIGIT> bVar, c.b<DIGIT> bVar2) {
                    return c.b.b(bVar2.a(bVar.cTz));
                }
            }

            /* renamed from: com.tencent.matrix.a.b.a.g$a$b$a  reason: collision with other inner class name */
            public static class C0210a<BEAN> implements b<c.C0212a<BEAN>> {
                static final C0210a cTv = new C0210a();

                public static <BEAN> c.C0212a<BEAN> a(c.C0212a<BEAN> aVar, c.C0212a<BEAN> aVar2) {
                    return (aVar2 == aVar || aVar2.equals(aVar)) ? (c.C0212a<BEAN>) c.C0212a.cTy : aVar2;
                }
            }

            public static class c<ENTRY extends c> implements b<c.C0216c<ENTRY>> {
                static final c cTx = new c();

                public static <ENTRY extends c> c.C0216c<ENTRY> a(c.C0216c<ENTRY> cVar, c.C0216c<ENTRY> cVar2) {
                    boolean z;
                    c.C0216c<ENTRY> Sn = c.C0216c.Sn();
                    for (int i2 = 0; i2 < cVar2.list.size(); i2++) {
                        ITEM item = cVar2.list.get(i2);
                        if (item instanceof c.b) {
                            if (cVar.list.size() > i2) {
                                ITEM item2 = cVar.list.get(i2);
                                if (item2 instanceof c.b) {
                                    Sn.list.add(C0211b.a((c.b) item2, (c.b) item));
                                }
                            }
                            List<ITEM> list = Sn.list;
                            c.b b2 = c.b.b(((c.b) item).cTz);
                            b2.cTq = false;
                            list.add(b2);
                        } else if ((item instanceof c.C0212a) && !cVar.list.contains(item)) {
                            Iterator<ITEM> it = cVar.list.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z = false;
                                    break;
                                }
                                ITEM next = it.next();
                                if ((next instanceof c.C0212a) && C0210a.a((c.C0212a) next, (c.C0212a) item) == c.C0212a.cTy) {
                                    z = true;
                                    break;
                                }
                            }
                            if (!z) {
                                Sn.list.add(item);
                            }
                        }
                    }
                    return Sn;
                }
            }
        }
    }
}
