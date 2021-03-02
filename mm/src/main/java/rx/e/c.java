package rx.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
import rx.e;
import rx.i;

public final class c<T> extends AtomicReference<a<T>> implements d.a<T> {
    public final rx.internal.a.c<T> Ukv = rx.internal.a.c.hQG();
    public rx.b.b<b<T>> UoA = rx.b.c.hQD();
    volatile Object Uox;
    rx.b.b<b<T>> Uoy = rx.b.c.hQD();
    rx.b.b<b<T>> Uoz = rx.b.c.hQD();
    boolean active = true;

    @Override // rx.b.b
    public final /* synthetic */ void cA(Object obj) {
        boolean z;
        AppMethodBeat.i(90421);
        i iVar = (i) obj;
        final b<T> bVar = new b<>(iVar);
        iVar.b(rx.f.d.e(new rx.b.a() {
            /* class rx.e.c.AnonymousClass1 */

            @Override // rx.b.a
            public final void call() {
                AppMethodBeat.i(90411);
                c.this.a(bVar);
                AppMethodBeat.o(90411);
            }
        }));
        this.Uoy.cA(bVar);
        if (!iVar.Ukg.UnB) {
            while (true) {
                a aVar = (a) get();
                if (!aVar.terminated) {
                    int length = aVar.UoD.length;
                    b[] bVarArr = new b[(length + 1)];
                    System.arraycopy(aVar.UoD, 0, bVarArr, 0, length);
                    bVarArr[length] = bVar;
                    if (compareAndSet(aVar, new a(aVar.terminated, bVarArr))) {
                        this.Uoz.cA(bVar);
                        z = true;
                        break;
                    }
                } else {
                    this.UoA.cA(bVar);
                    z = false;
                    break;
                }
            }
            if (z && iVar.Ukg.UnB) {
                a(bVar);
            }
        }
        AppMethodBeat.o(90421);
    }

    public c() {
        super(a.UoG);
        AppMethodBeat.i(90418);
        AppMethodBeat.o(90418);
    }

    /* access modifiers changed from: package-private */
    public final void a(b<T> bVar) {
        a aVar;
        b[] bVarArr;
        a aVar2;
        int i2;
        AppMethodBeat.i(90419);
        do {
            aVar = (a) get();
            if (!aVar.terminated) {
                b<T>[] bVarArr2 = aVar.UoD;
                int length = bVarArr2.length;
                if (length == 1 && bVarArr2[0] == bVar) {
                    aVar2 = a.UoG;
                } else if (length == 0) {
                    aVar2 = aVar;
                } else {
                    b[] bVarArr3 = new b[(length - 1)];
                    int i3 = 0;
                    int i4 = 0;
                    while (true) {
                        if (i3 < length) {
                            b<T> bVar2 = bVarArr2[i3];
                            if (bVar2 == bVar) {
                                i2 = i4;
                            } else if (i4 == length - 1) {
                                aVar2 = aVar;
                                break;
                            } else {
                                i2 = i4 + 1;
                                bVarArr3[i4] = bVar2;
                            }
                            i3++;
                            i4 = i2;
                        } else if (i4 == 0) {
                            aVar2 = a.UoG;
                        } else {
                            if (i4 < length - 1) {
                                bVarArr = new b[i4];
                                System.arraycopy(bVarArr3, 0, bVarArr, 0, i4);
                            } else {
                                bVarArr = bVarArr3;
                            }
                            aVar2 = new a(aVar.terminated, bVarArr);
                        }
                    }
                }
                if (aVar2 == aVar) {
                    break;
                }
            } else {
                AppMethodBeat.o(90419);
                return;
            }
        } while (!compareAndSet(aVar, aVar2));
        AppMethodBeat.o(90419);
    }

    /* access modifiers changed from: protected */
    public static final class a<T> {
        static final b[] UoE = new b[0];
        static final a UoF = new a(true, UoE);
        static final a UoG = new a(false, UoE);
        final b[] UoD;
        final boolean terminated;

        static {
            AppMethodBeat.i(90412);
            AppMethodBeat.o(90412);
        }

        public a(boolean z, b[] bVarArr) {
            this.terminated = z;
            this.UoD = bVarArr;
        }
    }

    /* access modifiers changed from: protected */
    public static final class b<T> implements e<T> {
        final i<? super T> UkG;
        boolean Ukt;
        boolean UoH;
        boolean gvP = true;
        List<Object> kwB;

        public b(i<? super T> iVar) {
            this.UkG = iVar;
        }

        @Override // rx.e
        public final void gL(T t) {
            AppMethodBeat.i(90413);
            this.UkG.gL(t);
            AppMethodBeat.o(90413);
        }

        @Override // rx.e
        public final void onError(Throwable th) {
            AppMethodBeat.i(90414);
            this.UkG.onError(th);
            AppMethodBeat.o(90414);
        }

        @Override // rx.e
        public final void hQw() {
            AppMethodBeat.i(90415);
            this.UkG.hQw();
            AppMethodBeat.o(90415);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
            r2.UoH = true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void gP(java.lang.Object r3) {
            /*
                r2 = this;
                r1 = 90416(0x16130, float:1.267E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r1)
                boolean r0 = r2.UoH
                if (r0 != 0) goto L_0x002b
                monitor-enter(r2)
                r0 = 0
                r2.gvP = r0     // Catch:{ all -> 0x0034 }
                boolean r0 = r2.Ukt     // Catch:{ all -> 0x0034 }
                if (r0 == 0) goto L_0x0027
                java.util.List<java.lang.Object> r0 = r2.kwB     // Catch:{ all -> 0x0034 }
                if (r0 != 0) goto L_0x001d
                java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0034 }
                r0.<init>()     // Catch:{ all -> 0x0034 }
                r2.kwB = r0     // Catch:{ all -> 0x0034 }
            L_0x001d:
                java.util.List<java.lang.Object> r0 = r2.kwB     // Catch:{ all -> 0x0034 }
                r0.add(r3)     // Catch:{ all -> 0x0034 }
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
            L_0x0026:
                return
            L_0x0027:
                monitor-exit(r2)
                r0 = 1
                r2.UoH = r0
            L_0x002b:
                rx.i<? super T> r0 = r2.UkG
                rx.internal.a.c.a(r0, r3)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
                goto L_0x0026
            L_0x0034:
                r0 = move-exception
                monitor-exit(r2)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.e.c.b.gP(java.lang.Object):void");
        }

        /* access modifiers changed from: package-private */
        public final void gQ(Object obj) {
            AppMethodBeat.i(90417);
            if (obj != null) {
                rx.internal.a.c.a(this.UkG, obj);
            }
            AppMethodBeat.o(90417);
        }
    }

    /* access modifiers changed from: package-private */
    public final b<T>[] gO(Object obj) {
        AppMethodBeat.i(90420);
        this.Uox = obj;
        this.active = false;
        if (((a) get()).terminated) {
            b<T>[] bVarArr = a.UoE;
            AppMethodBeat.o(90420);
            return bVarArr;
        }
        b<T>[] bVarArr2 = ((a) getAndSet(a.UoF)).UoD;
        AppMethodBeat.o(90420);
        return bVarArr2;
    }
}
