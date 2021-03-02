package com.tencent.matrix;

import android.app.Application;
import android.os.Handler;
import com.tencent.matrix.e.c;
import com.tencent.matrix.g.c;
import java.util.HashSet;
import java.util.Iterator;

public class b {
    private static volatile b cPH;
    public final Application application;
    public final HashSet<com.tencent.matrix.e.b> cqP;
    private final c pluginListener;

    /* synthetic */ b(Application application2, c cVar, HashSet hashSet, byte b2) {
        this(application2, cVar, hashSet);
    }

    private b(Application application2, c cVar, HashSet<com.tencent.matrix.e.b> hashSet) {
        this.application = application2;
        this.pluginListener = cVar;
        this.cqP = hashSet;
        a aVar = a.INSTANCE;
        Application application3 = this.application;
        if (aVar.isInit) {
            com.tencent.matrix.g.c.e("Matrix.AppActiveDelegate", "has inited!", new Object[0]);
        } else {
            aVar.isInit = true;
            if (com.tencent.matrix.g.b.TP() != null) {
                aVar.handler = new Handler(com.tencent.matrix.g.b.TP().getLooper());
            }
            application3.registerComponentCallbacks(aVar.cPD);
            application3.registerActivityLifecycleCallbacks(aVar.cPD);
        }
        Iterator<com.tencent.matrix.e.b> it = hashSet.iterator();
        while (it.hasNext()) {
            com.tencent.matrix.e.b next = it.next();
            next.init(this.application, this.pluginListener);
            this.pluginListener.b(next);
        }
    }

    public static void a(c.a aVar) {
        com.tencent.matrix.g.c.b(aVar);
    }

    public static boolean isInstalled() {
        return cPH != null;
    }

    public static b a(b bVar) {
        synchronized (b.class) {
            if (cPH == null) {
                cPH = bVar;
            } else {
                com.tencent.matrix.g.c.e("Matrix.Matrix", "Matrix instance is already set. this invoking will be ignored", new Object[0]);
            }
        }
        return cPH;
    }

    public static b RG() {
        if (cPH != null) {
            return cPH;
        }
        throw new RuntimeException("you must init Matrix sdk first");
    }

    public final <T extends com.tencent.matrix.e.b> T Y(Class<T> cls) {
        String name = cls.getName();
        Iterator<com.tencent.matrix.e.b> it = this.cqP.iterator();
        while (it.hasNext()) {
            T t = (T) it.next();
            if (t.getClass().getName().equals(name)) {
                return t;
            }
        }
        return null;
    }

    public static class a {
        final Application application;
        HashSet<com.tencent.matrix.e.b> cqP = new HashSet<>();
        com.tencent.matrix.e.c pluginListener;

        public a(Application application2) {
            if (application2 == null) {
                throw new RuntimeException("matrix init, application is null");
            }
            this.application = application2;
        }

        public final a a(com.tencent.matrix.e.b bVar) {
            String tag = bVar.getTag();
            Iterator<com.tencent.matrix.e.b> it = this.cqP.iterator();
            while (it.hasNext()) {
                if (tag.equals(it.next().getTag())) {
                    throw new RuntimeException(String.format("plugin with tag %s is already exist", tag));
                }
            }
            this.cqP.add(bVar);
            return this;
        }
    }
}
