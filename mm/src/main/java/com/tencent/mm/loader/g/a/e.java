package com.tencent.mm.loader.g.a;

import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.d;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/loader/loader/cfg/LoaderCoreFactory;", "", "()V", "DEFAULT_THREAD_POOL_SIZE", "", "DEFAULT_THREAD_PRIORITY", "TAG", "", "getTAG", "()Ljava/lang/String;", "_instance", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getInstance", "newLoader", "configuration", "Lcom/tencent/mm/loader/loader/cfg/TaskLoaderConfiguration;", "libimageloader_release"})
public final class e {
    private static final String TAG = TAG;
    private static volatile d<c> ibL;
    public static final e ibM = new e();

    private e() {
    }

    public static d<c> aKh() {
        if (ibL == null) {
            synchronized (aa.bp(d.class)) {
                ibL = new d<>(new f(new a(Integer.MAX_VALUE), new g(3), new g(3), new g(3), 3, "imageLoader"));
                x xVar = x.SXb;
            }
        }
        d<c> dVar = ibL;
        if (dVar == null) {
            p.hyc();
        }
        return dVar;
    }

    public static d<c> a(f fVar) {
        p.h(fVar, "configuration");
        return new d<>(fVar);
    }
}
