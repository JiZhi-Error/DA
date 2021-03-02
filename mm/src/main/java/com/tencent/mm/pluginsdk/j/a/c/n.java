package com.tencent.mm.pluginsdk.j.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.a.c.f;
import com.tencent.mm.pluginsdk.j.a.c.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.SdcardUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class n extends f<l> {
    private final com.tencent.f.b Kac;
    protected final c Kad;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.pluginsdk.j.a.c.f$b] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.pluginsdk.j.a.c.f
    public /* bridge */ /* synthetic */ f.d a(l lVar) {
        AppMethodBeat.i(152046);
        f.d a2 = a(lVar);
        AppMethodBeat.o(152046);
        return a2;
    }

    public n(String str, c cVar) {
        this(str, cVar, (byte) 0);
    }

    private n(String str, c cVar, byte b2) {
        AppMethodBeat.i(184268);
        this.Kac = new f.a(str, 4, 4, new c());
        this.Kad = cVar;
        AppMethodBeat.o(184268);
    }

    /* access modifiers changed from: package-private */
    public final void bef(String str) {
        AppMethodBeat.i(152043);
        super.Zb(str);
        AppMethodBeat.o(152043);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.pluginsdk.j.a.c.f
    public final com.tencent.f.b gnM() {
        return this.Kac;
    }

    /* access modifiers changed from: protected */
    public f.d a(l lVar) {
        AppMethodBeat.i(152044);
        Log.i("MicroMsg.ResDownloader.NetworkWorker", "request.class = " + lVar.getClass().getSimpleName());
        q.a.goa();
        a c2 = q.c(lVar);
        if (c2 == null) {
            Log.i("MicroMsg.ResDownloader.NetworkWorker", "get null handler from plugin, use default handler");
            c2 = new b(lVar);
        }
        c2.Kag = this.Kad;
        AppMethodBeat.o(152044);
        return c2;
    }

    public void shutdown() {
        AppMethodBeat.i(152045);
        this.Kac.shutdownNow();
        for (String str : this.JZN.keySet()) {
            Future<?> future = this.JZN.get(str);
            if (future != null) {
                future.cancel(true);
            }
        }
        this.pendingRequests.clear();
        this.JZN.clear();
        AppMethodBeat.o(152045);
    }

    /* access modifiers changed from: package-private */
    public static class b extends a<l> {
        b(l lVar) {
            super(lVar);
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.e
        public final String avy() {
            return "ResDownload";
        }
    }

    public static abstract class a<Req extends l> extends f.d<Req> implements e {
        private static final ThreadLocal<j> Kae = new ThreadLocal<j>() {
            /* class com.tencent.mm.pluginsdk.j.a.c.n.a.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            public final /* synthetic */ j initialValue() {
                AppMethodBeat.i(152035);
                j jVar = new j();
                AppMethodBeat.o(152035);
                return jVar;
            }
        };
        private final int JYA;
        private final AtomicInteger Kaf = new AtomicInteger(this.JYA);
        public volatile c Kag;

        protected a(Req req) {
            super(req);
            this.JYA = req.JYA;
        }

        /* access modifiers changed from: protected */
        public m a(j jVar) {
            if (!bwr()) {
                return j.a(this);
            }
            s beg = q.a.goa().beg(gnA());
            if (beg != null) {
                beg.field_status = 1;
                q.a.goa().h(beg);
            }
            return j.a(this);
        }

        /* access modifiers changed from: protected */
        public boolean bwr() {
            return true;
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.f.d
        public final void run() {
            m a2 = a(Kae.get());
            if (a2 != null) {
                this.Kag.a(this, a2);
                return;
            }
            Log.e("MicroMsg.ResDownloader.NetworkWorker", "groupId = %s, performer get null response", avy());
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.e
        public boolean bwo() {
            return false;
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.e
        public boolean bwp() {
            return true;
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.e
        public boolean bwq() {
            return false;
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.e
        public String getURL() {
            return ((l) bwt()).url;
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.e
        public final String gnU() {
            return "GET";
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.e
        public final Collection<b> gnV() {
            Map<String, String> requestHeaders = ((l) bwt()).getRequestHeaders();
            if (requestHeaders == null || requestHeaders.size() == 0) {
                return null;
            }
            Set<String> keySet = requestHeaders.keySet();
            if (keySet == null || keySet.size() == 0) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            for (String str : keySet) {
                String str2 = requestHeaders.get(str);
                if (!Util.isNullOrNil(str2)) {
                    linkedList.add(new b(str, str2));
                }
            }
            return linkedList;
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.e
        public final int getConnectTimeout() {
            return ((l) bwt()).getConnectTimeout();
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.e
        public final int getReadTimeout() {
            return ((l) bwt()).getReadTimeout();
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.e
        public final int gnW() {
            return ((l) bwt()).gnW();
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.e
        public final String gnX() {
            return "application/x-www-form-urlencoded;charset=utf-8";
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.e
        public final String gnA() {
            return ((l) bwt()).JYs;
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.e
        public final String getFilePath() {
            return ((l) bwt()).getFilePath();
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.e
        public boolean bws() {
            boolean z;
            if (this.Kaf.decrementAndGet() > 0) {
                z = true;
            } else {
                z = false;
            }
            this.Kag.C(gnA(), this.JYA, this.Kaf.get());
            return z;
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.e
        public boolean AX(long j2) {
            this.Kag.O(gnA(), j2);
            long availableExternalMemorySize2 = SdcardUtil.getAvailableExternalMemorySize2();
            Log.i("MicroMsg.ResDownloader.NetworkWorker", "%s: get available size = %d", gnA(), Long.valueOf(availableExternalMemorySize2));
            return availableExternalMemorySize2 >= j2;
        }
    }

    static final class c extends PriorityBlockingQueue<Runnable> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.util.concurrent.BlockingQueue, java.util.Queue, java.util.concurrent.PriorityBlockingQueue
        public final /* synthetic */ boolean offer(Runnable runnable) {
            AppMethodBeat.i(152040);
            Runnable runnable2 = runnable;
            boolean offer = super.offer(runnable2);
            Log.d("MicroMsg.ResDownloader.NetworkWorker.BlockingQueue", "offer() | tid = %d | " + aF(runnable2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(152040);
            return offer;
        }

        public c() {
            super(11, new Comparator<Runnable>() {
                /* class com.tencent.mm.pluginsdk.j.a.c.n.c.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(Runnable runnable, Runnable runnable2) {
                    int i2;
                    AppMethodBeat.i(152036);
                    Runnable runnable3 = runnable;
                    Runnable runnable4 = runnable2;
                    if (!(runnable3 instanceof f.c) || !(runnable4 instanceof f.c) || !(((f.c) runnable3).JZP instanceof l) || !(((f.c) runnable4).JZP instanceof l)) {
                        i2 = 0;
                    } else {
                        l lVar = (l) ((f.c) runnable3).JZP;
                        l lVar2 = (l) ((f.c) runnable4).JZP;
                        int i3 = lVar.priority - lVar2.priority;
                        if (!lVar.gnI() || !lVar2.gnI()) {
                            i2 = i3;
                        } else {
                            i2 = i3 != 0 ? i3 : ((int) (Math.random() * 50.0d)) - 25;
                        }
                    }
                    int i4 = 0 - i2;
                    AppMethodBeat.o(152036);
                    return i4;
                }
            });
            AppMethodBeat.i(152037);
            AppMethodBeat.o(152037);
        }

        private static String aF(Runnable runnable) {
            AppMethodBeat.i(152038);
            if (!(runnable instanceof f.c)) {
                String format = String.format("unknown runnable = %s", runnable);
                AppMethodBeat.o(152038);
                return format;
            } else if (((f.c) runnable).JZP instanceof l) {
                String format2 = String.format("priority = %d, urlKey = %s", Integer.valueOf(((l) ((f.c) runnable).JZP).priority), ((f.c) runnable).JZP.gnA());
                AppMethodBeat.o(152038);
                return format2;
            } else {
                String format3 = String.format("unknown request = %s", ((f.c) runnable).JZP);
                AppMethodBeat.o(152038);
                return format3;
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.BlockingQueue, java.util.concurrent.PriorityBlockingQueue
        public final /* synthetic */ Runnable poll(long j2, TimeUnit timeUnit) {
            AppMethodBeat.i(152039);
            Runnable runnable = (Runnable) super.poll(j2, timeUnit);
            if (runnable != null) {
                Log.d("MicroMsg.ResDownloader.NetworkWorker.BlockingQueue", "poll(long, TimeUnit) | tid = %d | " + aF(runnable), Long.valueOf(Thread.currentThread().getId()));
            }
            AppMethodBeat.o(152039);
            return runnable;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0093, code lost:
        if (r3 != false) goto L_0x0095;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int b(com.tencent.mm.pluginsdk.j.a.c.l r10) {
        /*
        // Method dump skipped, instructions count: 167
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.j.a.c.n.b(com.tencent.mm.pluginsdk.j.a.c.l):int");
    }
}
