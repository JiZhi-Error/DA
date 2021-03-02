package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.b;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.c.d;
import com.tencent.mm.kernel.c.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class c {
    private final ConcurrentHashMap<Class<? extends com.tencent.mm.kernel.b.a>, f> hqq = new ConcurrentHashMap<>();
    private final ArrayList<f> hqr = new ArrayList<>();
    private final ConcurrentHashMap<Class<? extends f>, ArrayList<Class<? extends com.tencent.mm.kernel.b.a>>> hqs = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Class<? extends com.tencent.mm.kernel.b.a>, Class<? extends f>> hqt = new ConcurrentHashMap<>();
    public com.tencent.mm.kernel.a.a.a<Class<? extends f>> hqu = new com.tencent.mm.kernel.a.a.a<>();
    private d hqv = new d();
    protected a hqw;
    public Class<? extends com.tencent.mm.kernel.b.a> hqx = null;
    private com.tencent.mm.kernel.a.a hqy;

    public interface a {
        void a(com.tencent.mm.kernel.c.a aVar);

        void b(f fVar);

        void b(com.tencent.mm.kernel.c.a aVar);

        void c(f fVar);

        void c(com.tencent.mm.kernel.c.a aVar);
    }

    public c() {
        AppMethodBeat.i(158284);
        this.hqv.a(new d.a() {
            /* class com.tencent.mm.kernel.c.AnonymousClass1 */

            @Override // com.tencent.mm.kernel.c.d.a
            public final void a(Class<? extends a> cls, com.tencent.mm.kernel.c.c cVar) {
                AppMethodBeat.i(158281);
                if ((cVar instanceof e) && c.this.hqw != null) {
                    c.this.hqw.a(cVar.aBe());
                }
                AppMethodBeat.o(158281);
            }

            @Override // com.tencent.mm.kernel.c.d.a
            public final void b(Class<? extends a> cls, com.tencent.mm.kernel.c.c cVar) {
                AppMethodBeat.i(158282);
                if ((cVar instanceof e) && c.this.hqw != null) {
                    c.this.hqw.b(cVar.aBe());
                }
                AppMethodBeat.o(158282);
            }

            @Override // com.tencent.mm.kernel.c.d.a
            public final void a(Class<? extends a> cls, a aVar) {
                AppMethodBeat.i(158283);
                if (c.this.hqw != null) {
                    c.this.hqw.c(aVar);
                }
                AppMethodBeat.o(158283);
            }
        });
        AppMethodBeat.o(158284);
    }

    public final synchronized f ad(Class<? extends f> cls) {
        f b2;
        AppMethodBeat.i(158285);
        b2 = b(cls, false);
        AppMethodBeat.o(158285);
        return b2;
    }

    private synchronized f b(Class<? extends f> cls, boolean z) {
        f fVar;
        AppMethodBeat.i(158286);
        Assert.assertNotNull(cls);
        try {
            f fVar2 = (f) cls.newInstance();
            if (z) {
                fVar2.markAsPendingPlugin();
            }
            fVar = a(fVar2);
            AppMethodBeat.o(158286);
        } catch (Exception e2) {
            j.printErrStackTrace("MMSkeleton.CorePlugins", e2, "Install plugin %s failed.", cls);
            fVar = null;
            AppMethodBeat.o(158286);
        }
        return fVar;
    }

    public final synchronized f FO(String str) {
        f x;
        AppMethodBeat.i(158287);
        x = x(str, false);
        AppMethodBeat.o(158287);
        return x;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.tencent.mm.kernel.c */
    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized f x(String str, boolean z) {
        f fVar;
        AppMethodBeat.i(158288);
        try {
            Class<?> cls = Class.forName(str);
            if (f.class.isAssignableFrom(cls)) {
                fVar = b(cls, z);
                AppMethodBeat.o(158288);
            } else {
                j.e("MMSkeleton.CorePlugins", "class string %s, not a Plugin", str);
                fVar = null;
                AppMethodBeat.o(158288);
            }
        } catch (ClassNotFoundException e2) {
            j.e("MMSkeleton.CorePlugins", "plugin %s not found.", str);
            h.aAl().aAe();
            new Object[1][0] = str;
            j.aAm();
        }
        return fVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.tencent.mm.kernel.c */
    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: java.util.concurrent.ConcurrentHashMap<java.lang.Class<? extends com.tencent.mm.kernel.b.a>, com.tencent.mm.kernel.b.f> */
    /* JADX WARN: Multi-variable type inference failed */
    private synchronized f a(f fVar) {
        f fVar2;
        AppMethodBeat.i(158289);
        if (ae(fVar.getClass())) {
            j.w("MMSkeleton.CorePlugins", "Plugin %s has been installed.", fVar.getClass());
            fVar2 = (f) ai(fVar.getClass());
            AppMethodBeat.o(158289);
        } else {
            Assert.assertNotNull(fVar);
            String[] ofProcesses = fVar.ofProcesses();
            if (ofProcesses != null && ofProcesses.length > 0) {
                g azG = h.aAl().aAe().azG();
                boolean z = false;
                for (String str : ofProcesses) {
                    z = azG.FY(str);
                    if (z) {
                        break;
                    }
                }
                if (!z) {
                    IllegalStateException illegalStateException = new IllegalStateException(String.format("Plugin %s can't install in process %s. It only support process %s.", fVar, azG.mProcessName, Arrays.asList(ofProcesses)));
                    AppMethodBeat.o(158289);
                    throw illegalStateException;
                }
            }
            this.hqq.put(fVar.getClass(), fVar);
            this.hqr.add(fVar);
            fVar.invokeInstalled();
            if (this.hqw != null) {
                this.hqw.b(fVar);
            }
            AppMethodBeat.o(158289);
            fVar2 = fVar;
        }
        return fVar2;
    }

    public final synchronized boolean ae(Class<? extends com.tencent.mm.kernel.b.a> cls) {
        boolean containsKey;
        AppMethodBeat.i(158290);
        containsKey = this.hqq.containsKey(cls);
        AppMethodBeat.o(158290);
        return containsKey;
    }

    public final synchronized void k(Class<? extends f> cls, Class<? extends com.tencent.mm.kernel.b.a> cls2) {
        AppMethodBeat.i(158291);
        Assert.assertNotNull(cls);
        Assert.assertNotNull(cls2);
        f fVar = this.hqq.get(cls);
        Assert.assertNotNull(fVar);
        ArrayList<Class<? extends com.tencent.mm.kernel.b.a>> arrayList = this.hqs.get(cls);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.hqs.put(cls, arrayList);
        }
        this.hqt.put(cls2, cls);
        arrayList.add(cls2);
        this.hqq.put(cls2, fVar);
        AppMethodBeat.o(158291);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T extends com.tencent.mm.kernel.c.a> T af(java.lang.Class<T> r7) {
        /*
        // Method dump skipped, instructions count: 108
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.kernel.c.af(java.lang.Class):com.tencent.mm.kernel.c.a");
    }

    public final <T extends a, N extends T> void a(Class<T> cls, com.tencent.mm.kernel.c.c<N> cVar) {
        AppMethodBeat.i(158293);
        this.hqv.c(cls, cVar);
        AppMethodBeat.o(158293);
    }

    public final void ag(Class<? extends a> cls) {
        AppMethodBeat.i(158294);
        this.hqv.ag(cls);
        AppMethodBeat.o(158294);
    }

    public final synchronized <T extends com.tencent.mm.kernel.b.a> T ah(Class<T> cls) {
        T t;
        AppMethodBeat.i(158295);
        com.tencent.mm.kernel.b.a ai = ai(cls);
        if (this.hqw != null) {
            this.hqw.c((f) ai);
        }
        t = ai == null ? (T) ((com.tencent.mm.kernel.b.a) f.ak(cls)) : (T) ai;
        AppMethodBeat.o(158295);
        return t;
    }

    private synchronized <T extends com.tencent.mm.kernel.b.a> T ai(Class<T> cls) {
        f fVar;
        AppMethodBeat.i(158296);
        Assert.assertNotNull(cls);
        fVar = this.hqq.get(cls);
        AppMethodBeat.o(158296);
        return fVar;
    }

    private synchronized boolean aj(Class<? extends com.tencent.mm.kernel.b.a> cls) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(158297);
            Assert.assertNotNull(cls);
            if (!ae(cls)) {
                j.w("MMSkeleton.CorePlugins", "Plugin " + cls + " must be installed!", new Object[0]);
                AppMethodBeat.o(158297);
            } else {
                z = true;
                AppMethodBeat.o(158297);
            }
        }
        return z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.tencent.mm.kernel.a.a.a<java.lang.Class<? extends com.tencent.mm.kernel.b.f>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void l(Class<? extends f> cls, Class<? extends com.tencent.mm.kernel.b.a> cls2) {
        AppMethodBeat.i(158298);
        Assert.assertNotNull(cls);
        Assert.assertNotNull(cls2);
        if (!aj(cls2)) {
            String format = String.format("depends plugin %s not install, plugin %s will not add in to dependency tree", cls2.getName(), cls.getName());
            j.e("MMSkeleton.CorePlugins", format, new Object[0]);
            IllegalAccessError illegalAccessError = new IllegalAccessError(format);
            AppMethodBeat.o(158298);
            throw illegalAccessError;
        }
        if (this.hqt.containsKey(cls2)) {
            cls2 = this.hqt.get(cls2);
        }
        this.hqu.z(cls, cls2);
        if (this.hqy == null) {
            this.hqy = h.aAl().aAe().azG().hqy;
        }
        f fVar = (f) ai(cls);
        f fVar2 = (f) ai(cls2);
        this.hqy.hrL.a(b.class, fVar, fVar2);
        this.hqy.hrL.a(com.tencent.mm.kernel.a.c.b.class, fVar, fVar2);
        AppMethodBeat.o(158298);
    }

    public final synchronized void azE() {
        AppMethodBeat.i(158299);
        Iterator<f> it = this.hqr.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!next.isDependencyMade()) {
                com.tencent.mm.kernel.a.a.k("make dependency for plugin %s...", next);
                next.invokeDependency();
            } else {
                com.tencent.mm.kernel.a.a.k("skip make dependency for plugin %s.", next);
            }
        }
        AppMethodBeat.o(158299);
    }

    public final synchronized List<f> azF() {
        return this.hqr;
    }
}
