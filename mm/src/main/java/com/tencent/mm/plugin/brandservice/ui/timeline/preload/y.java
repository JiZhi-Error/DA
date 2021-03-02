package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.ad.c;
import com.tencent.mm.plugin.webcanvas.m;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.d.b.a.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\r\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J.\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00172\u0006\u0010\u0018\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019J2\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00042\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100!J<\u0010\"\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00042\u000e\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00172\u0014\u0010 \u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00100!J\u0010\u0010%\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0013\u001a\u00020\u0004J\u0010\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\u0013\u001a\u00020\u0004J!\u0010(\u001a\u00020)2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010*R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0004\n\u0002\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "idGetting", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "idLock", "Ljava/util/concurrent/locks/ReentrantLock;", "manager", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$manager$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$manager$1;", "clearAll", "", "dispatchEvent", "appId", "url", "event", "data", "getAllCaches", "", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "(Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getId", "inject", "type", "", "script", "onCallback", "Lkotlin/Function1;", "invoke", "func", NativeProtocol.WEB_DIALOG_PARAMS, "match", "matchAll", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyLitePrefetchDomainInfo;", "shouldPrefetch", "", "(Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-brandservice_release"})
public final class y {
    private static final String TAG = TAG;
    private static final ReentrantLock pFc;
    private static final Condition pFd;
    private static final c pFe = new c();
    public static final y pFf = new y();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H@"}, hxF = {"getAllCaches", "", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "continuation", "Lkotlin/coroutines/Continuation;", "", ""})
    @f(c = "com.tencent.mm.plugin.brandservice.ui.timeline.preload.WebPrefetcherManifest", f = "WebPrefetcherManifest.kt", hxM = {WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO}, m = "getAllCaches")
    public static final class a extends kotlin.d.b.a.d {
        Object L$0;
        int label;
        Object pED;
        final /* synthetic */ y pFg;
        /* synthetic */ Object result;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(y yVar, kotlin.d.d dVar) {
            super(dVar);
            this.pFg = yVar;
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            AppMethodBeat.i(195747);
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object b2 = this.pFg.b(null, this);
            AppMethodBeat.o(195747);
            return b2;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H@"}, hxF = {"shouldPrefetch", "", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "url", "", "continuation", "Lkotlin/coroutines/Continuation;", ""})
    @f(c = "com.tencent.mm.plugin.brandservice.ui.timeline.preload.WebPrefetcherManifest", f = "WebPrefetcherManifest.kt", hxM = {69}, m = "shouldPrefetch")
    public static final class d extends kotlin.d.b.a.d {
        Object L$0;
        int label;
        Object pED;
        Object pEE;
        final /* synthetic */ y pFg;
        /* synthetic */ Object result;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(y yVar, kotlin.d.d dVar) {
            super(dVar);
            this.pFg = yVar;
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            AppMethodBeat.i(195751);
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object a2 = this.pFg.a(null, null, this);
            AppMethodBeat.o(195751);
            return a2;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "bizId", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$getId$1$1"})
    public static final class b extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ com.tencent.mm.plugin.ad.a pEr;
        final /* synthetic */ String pFh;
        final /* synthetic */ z.f pFi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(com.tencent.mm.plugin.ad.a aVar, String str, z.f fVar) {
            super(1);
            this.pEr = aVar;
            this.pFh = str;
            this.pFi = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(195748);
            String str2 = str;
            y yVar = y.pFf;
            ReentrantLock reentrantLock = y.pFc;
            reentrantLock.lock();
            try {
                String str3 = str2;
                if (!(str3 == null || str3.length() == 0) && (!p.j(str2, BuildConfig.COMMAND)) && (!p.j(str2, "undefined"))) {
                    this.pFi.SYG = (T) ("_manifest_" + c.getHost(this.pFh) + '_' + str2);
                }
                y yVar2 = y.pFf;
                y.pFd.signalAll();
                x xVar = x.SXb;
                reentrantLock.unlock();
                x xVar2 = x.SXb;
                AppMethodBeat.o(195748);
                return xVar2;
            } catch (Throwable th) {
                reentrantLock.unlock();
                AppMethodBeat.o(195748);
                throw th;
            }
        }
    }

    static {
        AppMethodBeat.i(195761);
        ReentrantLock reentrantLock = new ReentrantLock();
        pFc = reentrantLock;
        pFd = reentrantLock.newCondition();
        AppMethodBeat.o(195761);
    }

    private y() {
    }

    public static com.tencent.mm.plugin.ad.a aiu(String str) {
        AppMethodBeat.i(195752);
        p.h(str, "url");
        c.a aVar = com.tencent.mm.plugin.ad.c.ICA;
        v vVar = v.pDG;
        com.tencent.mm.plugin.ad.a a2 = c.a.a(str, v.coq());
        AppMethodBeat.o(195752);
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0073 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.protocal.protobuf.bhc aiv(java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 201
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.preload.y.aiv(java.lang.String):com.tencent.mm.protocal.protobuf.bhc");
    }

    public final synchronized String a(String str, com.tencent.mm.plugin.ad.a aVar) {
        T t;
        AppMethodBeat.i(195754);
        p.h(str, "url");
        p.h(aVar, "manifest");
        z.f fVar = new z.f();
        fVar.SYG = null;
        ReentrantLock reentrantLock = pFc;
        reentrantLock.lock();
        try {
            pFe.a(aVar, "getId", j.listOf(str), new b(aVar, str, fVar));
            pFd.await(100, TimeUnit.MILLISECONDS);
            reentrantLock.unlock();
            if (fVar.SYG != null) {
                Log.d(TAG, "getId:" + ((String) fVar.SYG) + " result " + str);
            }
            if (fVar.SYG == null && n.J(str, "https://view.inews.qq.com/", false)) {
                Log.e(TAG, "getId fail:".concat(String.valueOf(str)));
            }
            t = fVar.SYG;
            AppMethodBeat.o(195754);
        } catch (Throwable th) {
            reentrantLock.unlock();
            AppMethodBeat.o(195754);
            throw th;
        }
        return t;
    }

    public static void clearAll() {
        AppMethodBeat.i(195757);
        c cVar = pFe;
        synchronized (((com.tencent.mm.plugin.ad.c) cVar).IBO) {
            try {
                HashMap<String, Integer> hashMap = ((com.tencent.mm.plugin.ad.c) cVar).IBO;
                LinkedHashMap linkedHashMap = new LinkedHashMap(ae.atJ(hashMap.size()));
                for (T t : hashMap.entrySet()) {
                    T t2 = t;
                    t2.getKey();
                    cVar.xX(((Number) t2.getValue()).intValue()).destroy();
                    linkedHashMap.put(x.SXb, t.getValue());
                }
                ((com.tencent.mm.plugin.ad.c) cVar).IBO.clear();
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(195757);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(com.tencent.mm.plugin.ad.a r3, java.lang.String r4, kotlin.g.a.b<? super java.lang.String, kotlin.x> r5) {
        /*
            r2 = 195758(0x2fcae, float:2.74315E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            java.lang.String r0 = "manifest"
            kotlin.g.b.p.h(r3, r0)
            java.lang.String r0 = "script"
            kotlin.g.b.p.h(r4, r0)
            java.lang.String r0 = "onCallback"
            kotlin.g.b.p.h(r5, r0)
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.y$c r0 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.y.pFe
            java.lang.String r1 = "manifest"
            kotlin.g.b.p.h(r3, r1)
            java.lang.String r1 = "script"
            kotlin.g.b.p.h(r4, r1)
            java.lang.String r1 = "onCallback"
            kotlin.g.b.p.h(r5, r1)
            java.util.concurrent.ConcurrentLinkedDeque<com.tencent.mm.plugin.ad.d> r0 = r0.ICu
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r1 = r0.iterator()
        L_0x0034:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x0046
            java.lang.Object r0 = r1.next()
            com.tencent.mm.plugin.ad.d r0 = (com.tencent.mm.plugin.ad.d) r0
            boolean r0 = r0.a(r3, r4, r5)
            if (r0 == 0) goto L_0x0034
        L_0x0046:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.preload.y.b(com.tencent.mm.plugin.ad.a, java.lang.String, kotlin.g.a.b):void");
    }

    public static void a(com.tencent.mm.plugin.ad.a aVar, String str, List<? extends Object> list, kotlin.g.a.b<? super String, x> bVar) {
        AppMethodBeat.i(195759);
        p.h(aVar, "manifest");
        p.h(str, "func");
        p.h(list, NativeProtocol.WEB_DIALOG_PARAMS);
        p.h(bVar, "onCallback");
        pFe.a(aVar, str, list, bVar);
        AppMethodBeat.o(195759);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002f, code lost:
        if ((r6 == null || kotlin.n.n.aL(r6)) == false) goto L_0x0031;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void k(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
            r4 = 195760(0x2fcb0, float:2.74318E-40)
            r2 = 1
            r1 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            java.lang.String r0 = "event"
            kotlin.g.b.p.h(r7, r0)
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.y$c r3 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.y.pFe
            java.lang.String r0 = "event"
            kotlin.g.b.p.h(r7, r0)
            r0 = r5
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0021
            boolean r0 = kotlin.n.n.aL(r0)
            if (r0 == 0) goto L_0x004f
        L_0x0021:
            r0 = r2
        L_0x0022:
            if (r0 == 0) goto L_0x0031
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r6 == 0) goto L_0x002e
            boolean r0 = kotlin.n.n.aL(r6)
            if (r0 == 0) goto L_0x0051
        L_0x002e:
            r0 = r2
        L_0x002f:
            if (r0 != 0) goto L_0x004b
        L_0x0031:
            java.util.concurrent.ConcurrentLinkedDeque<com.tencent.mm.plugin.ad.d> r0 = r3.ICu
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r1 = r0.iterator()
        L_0x0039:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x004b
            java.lang.Object r0 = r1.next()
            com.tencent.mm.plugin.ad.d r0 = (com.tencent.mm.plugin.ad.d) r0
            boolean r0 = r0.S(r5, r7, r8)
            if (r0 == 0) goto L_0x0039
        L_0x004b:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return
        L_0x004f:
            r0 = r1
            goto L_0x0022
        L_0x0051:
            r0 = r1
            goto L_0x002f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.preload.y.k(java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherManifest$manager$1", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine;", "clearCache", "", "domain", "", "plugin-brandservice_release"})
    public static final class c extends com.tencent.mm.plugin.ad.c {
        c() {
            AppMethodBeat.i(195750);
            m.IAG.fWP();
            a(new a());
            a(new l());
            AppMethodBeat.o(195750);
        }

        @Override // com.tencent.mm.plugin.ad.c
        public final void aer(String str) {
            AppMethodBeat.i(195749);
            p.h(str, "domain");
            c.ahS(str);
            AppMethodBeat.o(195749);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(com.tencent.mm.plugin.ad.a r9, java.lang.String r10, kotlin.d.d<? super java.lang.Boolean> r11) {
        /*
        // Method dump skipped, instructions count: 162
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.preload.y.a(com.tencent.mm.plugin.ad.a, java.lang.String, kotlin.d.d):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0063, code lost:
        if (r0 == null) goto L_0x0065;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0079 A[LOOP:0: B:23:0x0077->B:24:0x0079, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(com.tencent.mm.plugin.ad.a r8, kotlin.d.d<? super java.util.List<java.lang.String>> r9) {
        /*
        // Method dump skipped, instructions count: 162
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.preload.y.b(com.tencent.mm.plugin.ad.a, kotlin.d.d):java.lang.Object");
    }
}
