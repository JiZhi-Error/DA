package com.tencent.mm.plugin.messenger.foundation.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.a;
import com.tencent.mm.co.c;

public final class ab {
    private static SparseArray<a> zqe = new SparseArray<>();
    private static c<aa> zqf;

    static {
        AppMethodBeat.i(43074);
        AppMethodBeat.o(43074);
    }

    /* access modifiers changed from: package-private */
    public static class a<T extends com.tencent.mm.bw.a> extends com.tencent.mm.co.a<y<T>> implements y<T> {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.y
        public final void a(final T t) {
            AppMethodBeat.i(43068);
            a(new a.AbstractC0297a<y<T>>() {
                /* class com.tencent.mm.plugin.messenger.foundation.a.ab.a.AnonymousClass1 */

                /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: com.tencent.mm.plugin.messenger.foundation.a.y */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(Object obj) {
                    AppMethodBeat.i(43066);
                    ((y) obj).a(t);
                    AppMethodBeat.o(43066);
                }
            });
            AppMethodBeat.o(43068);
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.y
        public final void b(final T t) {
            AppMethodBeat.i(43069);
            a(new a.AbstractC0297a<y<T>>() {
                /* class com.tencent.mm.plugin.messenger.foundation.a.ab.a.AnonymousClass2 */

                /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: com.tencent.mm.plugin.messenger.foundation.a.y */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(Object obj) {
                    AppMethodBeat.i(43067);
                    ((y) obj).b(t);
                    AppMethodBeat.o(43067);
                }
            });
            AppMethodBeat.o(43069);
        }
    }

    public static synchronized <T extends com.tencent.mm.bw.a> void a(int i2, y<T> yVar) {
        synchronized (ab.class) {
            AppMethodBeat.i(43070);
            a aVar = zqe.get(i2);
            if (aVar == null) {
                aVar = new a((byte) 0);
                zqe.put(i2, aVar);
            }
            aVar.add(yVar);
            AppMethodBeat.o(43070);
        }
    }

    public static synchronized void a(y yVar) {
        synchronized (ab.class) {
            AppMethodBeat.i(43071);
            a aVar = zqe.get(5);
            if (aVar != null) {
                aVar.remove(yVar);
                if (aVar.size() == 0) {
                    zqe.remove(5);
                }
            }
            AppMethodBeat.o(43071);
        }
    }

    public static synchronized <T extends com.tencent.mm.bw.a> void k(T t) {
        synchronized (ab.class) {
            AppMethodBeat.i(43072);
            a aVar = zqe.get(5);
            if (aVar != null) {
                aVar.a(t);
            }
            AppMethodBeat.o(43072);
        }
    }

    public static synchronized <T extends com.tencent.mm.bw.a> void b(int i2, T t) {
        synchronized (ab.class) {
            AppMethodBeat.i(43073);
            a aVar = zqe.get(i2);
            if (aVar != null) {
                aVar.b(t);
            }
            AppMethodBeat.o(43073);
        }
    }

    public static final c<aa> eiz() {
        return zqf;
    }

    public static final void b(c<aa> cVar) {
        zqf = cVar;
    }
}
