package com.tencent.mm.plugin.appbrand.appcache;

import android.util.ArrayMap;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 <2\u00020\u0001:\u0001<B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00120\u001eH\u0016J\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u0012H\u0002J\u0018\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020&H\u0002J\"\u0010'\u001a\u0004\u0018\u00010\u00162\u0006\u0010(\u001a\u00020\t2\u000e\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160*H\u0002J\u0010\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001eH\u0016J\u0014\u0010,\u001a\u00020\u001a2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.J\u0014\u00100\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\tH\u0016J\u0014\u00101\u001a\u0004\u0018\u0001022\b\u0010\u001c\u001a\u0004\u0018\u00010\tH\u0016J\b\u00103\u001a\u00020\u001aH\u0016J!\u00104\u001a\u0002H5\"\u0004\b\u0000\u001052\f\u00106\u001a\b\u0012\u0004\u0012\u0002H50*H\u0002¢\u0006\u0002\u00107J!\u00108\u001a\u0002H5\"\u0004\b\u0000\u001052\f\u00106\u001a\b\u0012\u0004\u0012\u0002H50*H\u0002¢\u0006\u0002\u00107J\u000e\u00109\u001a\u0004\u0018\u000102*\u00020\nH\u0002J\u0014\u0010:\u001a\u00020\n*\u00020\u001f2\u0006\u0010;\u001a\u00020\u0016H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \r*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00120\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00160\bX\u0004¢\u0006\u0002\n\u0000¨\u0006="}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimePkgMergeDirReader;", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "closed", "", "filesMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;", "filesMapInitialized", "hostWxaAppId", "kotlin.jvm.PlatformType", "lock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "modulesMap", "Landroid/util/ArrayMap;", "Lcom/tencent/mm/plugin/appbrand/appcache/ModulePkgInfo;", "pkgWrappingInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "pkgsMap", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg;", "canAccessFile", "reqURL", "close", "", "findAppropriateModuleInfo", "resourcePath", "getMainPkgInfo", "", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg$Info;", "getModuleList", "guardedMergeModule", "module", "guardedMergePlugin", "hostModule", "plugin", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginPkgInfo;", "guardedObtainPkgInstance", "name", "lazyCreator", "Lkotlin/Function0;", "listAllFilenames", "mergeNewComingPkgList", "_pkgList", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "openReadPartialInfo", "openReadStream", "Ljava/io/InputStream;", "refreshModuleList", "requireRead", "T", "block", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "requireWrite", "openRead", "toFileEntry", "wxaPkg", "Companion", "luggage-wechat-full-sdk_release"})
public final class bn implements q {
    public static final a kOt = new a((byte) 0);
    public volatile boolean closed;
    private final String kOn;
    private final WxaPkgWrappingInfo kOo;
    private ArrayMap<String, ModulePkgInfo> kOp;
    private final ConcurrentHashMap<String, WxaPkg> kOq;
    private final ConcurrentHashMap<String, q.a> kOr;
    private boolean kOs;
    private final ReentrantReadWriteLock lock;

    static {
        AppMethodBeat.i(183032);
        AppMethodBeat.o(183032);
    }

    public static final bn O(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(183035);
        bn O = a.O(appBrandRuntime);
        AppMethodBeat.o(183035);
        return O;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;", "invoke"})
    public static final class d extends kotlin.g.b.q implements kotlin.g.a.b<q.a, x> {
        final /* synthetic */ bn kOu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(bn bnVar) {
            super(1);
            this.kOu = bnVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(q.a aVar) {
            AppMethodBeat.i(230049);
            q.a aVar2 = aVar;
            p.h(aVar2, LocaleUtil.ITALIAN);
            aVar2.kKF = this.kOu.kOn;
            aVar2.appVersion = this.kOu.kOo.pkgVersion();
            aVar2.kKG = this.kOu.kOo.checksumMd5();
            x xVar = x.SXb;
            AppMethodBeat.o(230049);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;", "invoke"})
    public static final class f extends kotlin.g.b.q implements kotlin.g.a.b<q.a, x> {
        final /* synthetic */ WxaPluginPkgInfo kOx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(WxaPluginPkgInfo wxaPluginPkgInfo) {
            super(1);
            this.kOx = wxaPluginPkgInfo;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(q.a aVar) {
            AppMethodBeat.i(230050);
            q.a aVar2 = aVar;
            p.h(aVar2, LocaleUtil.ITALIAN);
            aVar2.kKF = this.kOx.provider;
            aVar2.appVersion = this.kOx.pkgVersion();
            aVar2.kKG = this.kOx.checksumMd5();
            x xVar = x.SXb;
            AppMethodBeat.o(230050);
            return xVar;
        }
    }

    public bn(AppBrandRuntime appBrandRuntime) {
        p.h(appBrandRuntime, "rt");
        AppMethodBeat.i(183031);
        this.kOn = appBrandRuntime.getAppId();
        m d2 = appBrandRuntime.d(AppBrandSysConfigLU.class, false);
        if (d2 == null) {
            p.hyc();
        }
        WxaPkgWrappingInfo wxaPkgWrappingInfo = ((AppBrandSysConfigLU) d2).leE;
        if (wxaPkgWrappingInfo == null) {
            p.hyc();
        }
        this.kOo = wxaPkgWrappingInfo;
        this.kOq = new ConcurrentHashMap<>();
        this.kOr = new ConcurrentHashMap<>(100);
        Log.i("Luggage.FULL.WxaRuntimePkgMergeDirReader", "<init> appId:" + appBrandRuntime.getAppId() + ", pkg:" + this.kOo);
        this.lock = new ReentrantReadWriteLock();
        AppMethodBeat.o(183031);
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:311)
        	at jadx.core.dex.instructions.IfNode.isSame(IfNode.java:122)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    public final <T> T t(kotlin.g.a.a<? extends T> r7) {
        /*
            r6 = this;
            r5 = 183018(0x2caea, float:2.56463E-40)
            r1 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            java.util.concurrent.locks.ReentrantReadWriteLock r3 = r6.lock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r4 = r3.readLock()
            int r0 = r3.getWriteHoldCount()
            if (r0 != 0) goto L_0x0020
            int r0 = r3.getReadHoldCount()
        L_0x0017:
            r2 = r1
        L_0x0018:
            if (r2 >= r0) goto L_0x0022
            r4.unlock()
            int r2 = r2 + 1
            goto L_0x0018
        L_0x0020:
            r0 = r1
            goto L_0x0017
        L_0x0022:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r2 = r3.writeLock()
            r2.lock()
            java.lang.Object r3 = r7.invoke()     // Catch:{ all -> 0x004b }
        L_0x002d:
            if (r1 >= r0) goto L_0x0035
            r4.lock()
            int r1 = r1 + 1
            goto L_0x002d
        L_0x0035:
            r2.unlock()
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            return r3
        L_0x003c:
            if (r1 >= r0) goto L_0x0044
            r4.lock()
            int r1 = r1 + 1
            goto L_0x003c
        L_0x0044:
            r2.unlock()
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            throw r3
        L_0x004b:
            r3 = move-exception
            goto L_0x003c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appcache.bn.t(kotlin.g.a.a):java.lang.Object");
    }

    private final <T> T u(kotlin.g.a.a<? extends T> aVar) {
        AppMethodBeat.i(183019);
        ReentrantReadWriteLock.ReadLock readLock = this.lock.readLock();
        readLock.lock();
        try {
            return (T) aVar.invoke();
        } finally {
            readLock.unlock();
            AppMethodBeat.o(183019);
        }
    }

    private final WxaPkg h(String str, kotlin.g.a.a<WxaPkg> aVar) {
        AppMethodBeat.i(230052);
        WxaPkg wxaPkg = this.kOq.get(str);
        if (wxaPkg == null) {
            wxaPkg = aVar.invoke();
            if (wxaPkg != null) {
                wxaPkg.bvf();
                Log.i("Luggage.FULL.WxaRuntimePkgMergeDirReader", "guardedObtainPkgInstance, appId:" + this.kOn + ", name:" + str + ", pkgInnerVersion:" + wxaPkg.version());
                this.kOq.put(str, wxaPkg);
                AppMethodBeat.o(230052);
                return wxaPkg;
            }
            wxaPkg = null;
        }
        AppMethodBeat.o(230052);
        return wxaPkg;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.q
    public final void bvy() {
        AppMethodBeat.i(183021);
        if (this.kOs) {
            AppMethodBeat.o(183021);
            return;
        }
        t(new k(this));
        this.kOs = true;
        AppMethodBeat.o(183021);
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.q
    public final WxaPkg UT(String str) {
        AppMethodBeat.i(183022);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(183022);
            return null;
        }
        WxaPkg wxaPkg = (WxaPkg) u(new c(this, str));
        AppMethodBeat.o(183022);
        return wxaPkg;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.q
    public final boolean UW(String str) {
        AppMethodBeat.i(183023);
        if (UV(str) != null) {
            AppMethodBeat.o(183023);
            return true;
        }
        AppMethodBeat.o(183023);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.q
    public final InputStream UU(String str) {
        AppMethodBeat.i(183025);
        q.a UV = UV(str);
        if (UV != null) {
            InputStream UR = UV.kKH.UR(UV.fileName);
            AppMethodBeat.o(183025);
            return UR;
        }
        AppMethodBeat.o(183025);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.q
    public final q.a UV(String str) {
        AppMethodBeat.i(183026);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(183026);
            return null;
        }
        q.a aVar = (q.a) u(new j(this, str));
        AppMethodBeat.o(183026);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.q
    public final void close() {
        AppMethodBeat.i(183027);
        t(new b(this));
        this.closed = true;
        AppMethodBeat.o(183027);
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.q
    public final List<ModulePkgInfo> bvz() {
        AppMethodBeat.i(183028);
        LinkedList<ModulePkgInfo> linkedList = this.kOo.kNZ;
        p.g(linkedList, "pkgWrappingInfo.moduleList");
        LinkedList<ModulePkgInfo> linkedList2 = linkedList;
        AppMethodBeat.o(183028);
        return linkedList2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.q
    public final List<String> bvA() {
        AppMethodBeat.i(230053);
        List<String> list = (List) u(new h(this));
        AppMethodBeat.o(230053);
        return list;
    }

    private static q.a a(WxaPkg.Info info, WxaPkg wxaPkg) {
        AppMethodBeat.i(183030);
        q.a aVar = new q.a();
        aVar.kKH = wxaPkg;
        aVar.kKI = wxaPkg.bwh();
        aVar.fileName = info.fileName;
        aVar.kKJ = info.kKJ;
        aVar.kKK = info.kKK;
        AppMethodBeat.o(183030);
        return aVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u000e\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u000bH\u0007J\f\u0010\f\u001a\u00020\u0004*\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimePkgMergeDirReader$Companion;", "", "()V", "TAG", "", "getPluginFileAccessPrefixMergedWithModule", "hostModule", "plugin", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginPkgInfo;", "getMergeDirReader", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimePkgMergeDirReader;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "realPrefixForRuntimeAccess", "luggage-wechat-full-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static bn O(AppBrandRuntime appBrandRuntime) {
            AppMethodBeat.i(183003);
            p.h(appBrandRuntime, "$this$getMergeDirReader");
            r M = bg.M(appBrandRuntime);
            if (!(M instanceof bg)) {
                M = null;
            }
            bg bgVar = (bg) M;
            q bwy = bgVar != null ? bgVar.bwy() : null;
            if (!(bwy instanceof bn)) {
                bwy = null;
            }
            bn bnVar = (bn) bwy;
            AppMethodBeat.o(183003);
            return bnVar;
        }

        static String b(WxaPluginPkgInfo wxaPluginPkgInfo) {
            AppMethodBeat.i(183004);
            String str = wxaPluginPkgInfo.prefixPath;
            if (!(str == null || str.length() == 0)) {
                String str2 = wxaPluginPkgInfo.prefixPath;
                p.g(str2, "this.prefixPath");
                AppMethodBeat.o(183004);
                return str2;
            }
            String str3 = WxaPluginPkgInfo.PREFIX_EXTENDED + wxaPluginPkgInfo.provider;
            AppMethodBeat.o(183004);
            return str3;
        }

        public static String a(String str, WxaPluginPkgInfo wxaPluginPkgInfo) {
            AppMethodBeat.i(183005);
            p.h(str, "hostModule");
            p.h(wxaPluginPkgInfo, "plugin");
            if (p.j(str, ModulePkgInfo.MAIN_MODULE_NAME)) {
                String b2 = b(wxaPluginPkgInfo);
                AppMethodBeat.o(183005);
                return b2;
            } else if (n.a((CharSequence) str, '/')) {
                String str2 = str + b(wxaPluginPkgInfo);
                AppMethodBeat.o(183005);
                return str2;
            } else {
                String str3 = str + '/' + b(wxaPluginPkgInfo);
                AppMethodBeat.o(183005);
                return str3;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class i extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ bn kOu;
        final /* synthetic */ LinkedList kOy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(bn bnVar, LinkedList linkedList) {
            super(0);
            this.kOu = bnVar;
            this.kOy = linkedList;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            Object obj;
            AppMethodBeat.i(183012);
            Iterator it = this.kOy.iterator();
            while (it.hasNext()) {
                IPkgInfo iPkgInfo = (IPkgInfo) it.next();
                if (!(iPkgInfo instanceof ModulePkgInfo) && (iPkgInfo instanceof WxaPluginPkgInfo)) {
                    WxaRuntimeModulePluginListMap wxaRuntimeModulePluginListMap = this.kOu.kOo.kOb;
                    if (wxaRuntimeModulePluginListMap == null) {
                        p.hyc();
                    }
                    wxaRuntimeModulePluginListMap.a((WxaPluginPkgInfo) iPkgInfo);
                    it.remove();
                }
            }
            for (IPkgInfo iPkgInfo2 : this.kOy) {
                if (iPkgInfo2 == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo");
                    AppMethodBeat.o(183012);
                    throw tVar;
                }
                ModulePkgInfo modulePkgInfo = (ModulePkgInfo) iPkgInfo2;
                Iterator it2 = this.kOu.kOo.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    Object next = it2.next();
                    if (p.j(((ModulePkgInfo) next).name, modulePkgInfo.name)) {
                        obj = next;
                        break;
                    }
                }
                if (obj == null) {
                    p.hyc();
                }
                ModulePkgInfo modulePkgInfo2 = (ModulePkgInfo) obj;
                modulePkgInfo2.pkgPath = modulePkgInfo.pkgPath;
                modulePkgInfo2.md5 = modulePkgInfo.md5;
                bn.a(this.kOu, modulePkgInfo);
                WxaRuntimeModulePluginListMap wxaRuntimeModulePluginListMap2 = this.kOu.kOo.kOb;
                if (wxaRuntimeModulePluginListMap2 != null) {
                    String str = modulePkgInfo.name;
                    p.g(str, "module.name");
                    List<WxaPluginPkgInfo> Vz = wxaRuntimeModulePluginListMap2.Vz(str);
                    if (Vz != null) {
                        Iterator<T> it3 = Vz.iterator();
                        while (it3.hasNext()) {
                            bn bnVar = this.kOu;
                            String str2 = modulePkgInfo.name;
                            p.g(str2, "module.name");
                            bn.a(bnVar, str2, it3.next());
                        }
                    }
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(183012);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg;", "invoke"})
    public static final class e extends kotlin.g.b.q implements kotlin.g.a.a<WxaPkg> {
        final /* synthetic */ ModulePkgInfo kOw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(ModulePkgInfo modulePkgInfo) {
            super(0);
            this.kOw = modulePkgInfo;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ WxaPkg invoke() {
            AppMethodBeat.i(183009);
            WxaPkg wxaPkg = new WxaPkg(this.kOw.pkgPath);
            AppMethodBeat.o(183009);
            return wxaPkg;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg;", "invoke"})
    public static final class g extends kotlin.g.b.q implements kotlin.g.a.a<WxaPkg> {
        final /* synthetic */ WxaPluginPkgInfo kOx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(WxaPluginPkgInfo wxaPluginPkgInfo) {
            super(0);
            this.kOx = wxaPluginPkgInfo;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ WxaPkg invoke() {
            AppMethodBeat.i(183010);
            WxaPkg wxaPkg = new WxaPkg(this.kOx.pkgPath);
            AppMethodBeat.o(183010);
            return wxaPkg;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class k extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ bn kOu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(bn bnVar) {
            super(0);
            this.kOu = bnVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            v vVar;
            AppMethodBeat.i(183017);
            this.kOu.kOo.Vv(this.kOu.kOn);
            WxaRuntimeModulePluginListMap wxaRuntimeModulePluginListMap = this.kOu.kOo.kOb;
            if (wxaRuntimeModulePluginListMap != null) {
                wxaRuntimeModulePluginListMap.bwB();
            }
            bn bnVar = this.kOu;
            ArrayMap arrayMap = new ArrayMap(this.kOu.kOo.kNZ.size() + 1);
            Iterator<ModulePkgInfo> it = this.kOu.kOo.iterator();
            while (it.hasNext()) {
                ModulePkgInfo next = it.next();
                arrayMap.put(next.name, next);
            }
            bnVar.kOp = arrayMap;
            Iterator<ModulePkgInfo> it2 = this.kOu.kOo.iterator();
            while (it2.hasNext()) {
                ModulePkgInfo next2 = it2.next();
                if (s.YS(next2.pkgPath)) {
                    bn bnVar2 = this.kOu;
                    p.g(next2, "module");
                    bn.a(bnVar2, next2);
                    WxaRuntimeModulePluginListMap wxaRuntimeModulePluginListMap2 = this.kOu.kOo.kOb;
                    if (wxaRuntimeModulePluginListMap2 != null) {
                        String str = next2.name;
                        p.g(str, "module.name");
                        vVar = wxaRuntimeModulePluginListMap2.Vz(str);
                    } else {
                        vVar = null;
                    }
                    if (vVar == null) {
                        vVar = v.SXr;
                    }
                    for (WxaPluginPkgInfo wxaPluginPkgInfo : vVar) {
                        bn bnVar3 = this.kOu;
                        String str2 = next2.name;
                        p.g(str2, "module.name");
                        bn.a(bnVar3, str2, wxaPluginPkgInfo);
                    }
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(183017);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg;", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<WxaPkg> {
        final /* synthetic */ bn kOu;
        final /* synthetic */ String kOv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(bn bnVar, String str) {
            super(0);
            this.kOu = bnVar;
            this.kOv = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ WxaPkg invoke() {
            AppMethodBeat.i(183007);
            q.a aVar = (q.a) this.kOu.kOr.get(this.kOv);
            WxaPkg wxaPkg = aVar != null ? aVar.kKH : null;
            if (wxaPkg != null) {
                AppMethodBeat.o(183007);
                return wxaPkg;
            }
            for (Map.Entry entry : this.kOu.kOr.entrySet()) {
                q.a aVar2 = (q.a) entry.getValue();
                if (n.J((String) entry.getKey(), this.kOv, false)) {
                    WxaPkg wxaPkg2 = aVar2.kKH;
                    AppMethodBeat.o(183007);
                    return wxaPkg2;
                }
            }
            AppMethodBeat.o(183007);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;", "invoke"})
    public static final class j extends kotlin.g.b.q implements kotlin.g.a.a<q.a> {
        final /* synthetic */ bn kOu;
        final /* synthetic */ String kOv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(bn bnVar, String str) {
            super(0);
            this.kOu = bnVar;
            this.kOv = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ q.a invoke() {
            AppMethodBeat.i(183016);
            q.a aVar = (q.a) this.kOu.kOr.get(this.kOv);
            if (aVar == null) {
                aVar = null;
                String[] strArr = {com.tencent.mm.plugin.appbrand.appstorage.n.We(this.kOv), LaunchParcel.Wf(this.kOv)};
                for (int i2 = 0; i2 < 2; i2++) {
                    String str = strArr[i2];
                    if (!(p.j(str, this.kOv) || (aVar = (q.a) this.kOu.kOr.get(str)) == null)) {
                        break;
                    }
                }
            }
            AppMethodBeat.o(183016);
            return aVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ bn kOu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(bn bnVar) {
            super(0);
            this.kOu = bnVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(183006);
            Set<Map.Entry> entrySet = this.kOu.kOq.entrySet();
            p.g(entrySet, "pkgsMap.entries");
            for (Map.Entry entry : entrySet) {
                ((WxaPkg) entry.getValue()).close();
            }
            this.kOu.kOq.clear();
            this.kOu.kOr.clear();
            x xVar = x.SXb;
            AppMethodBeat.o(183006);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Ljava/util/LinkedList;", "", "invoke"})
    static final class h extends kotlin.g.b.q implements kotlin.g.a.a<LinkedList<String>> {
        final /* synthetic */ bn kOu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(bn bnVar) {
            super(0);
            this.kOu = bnVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ LinkedList<String> invoke() {
            AppMethodBeat.i(230051);
            LinkedList linkedList = new LinkedList();
            for (Map.Entry entry : this.kOu.kOr.entrySet()) {
                String str = (String) entry.getKey();
                if (((q.a) entry.getValue()).fileName != null) {
                    linkedList.add(str);
                }
            }
            AppMethodBeat.o(230051);
            return linkedList;
        }
    }

    public static final /* synthetic */ void a(bn bnVar, ModulePkgInfo modulePkgInfo) {
        AppMethodBeat.i(183033);
        String str = modulePkgInfo.name;
        p.g(str, "module.name");
        WxaPkg h2 = bnVar.h(str, new e(modulePkgInfo));
        if (h2 == null) {
            p.hyc();
        }
        d dVar = new d(bnVar);
        String str2 = modulePkgInfo.name;
        p.g(str2, "module.name");
        q.a aVar = new q.a();
        aVar.kKH = h2;
        aVar.kKI = h2.bwh();
        aVar.fileName = modulePkgInfo.name;
        dVar.invoke(aVar);
        bnVar.kOr.put(str2, aVar);
        for (WxaPkg.Info info : h2.bwi()) {
            String str3 = info.fileName;
            p.g(str3, "info.fileName");
            p.g(info, "info");
            q.a a2 = a(info, h2);
            dVar.invoke(a2);
            bnVar.kOr.put(str3, a2);
        }
        AppMethodBeat.o(183033);
    }

    public static final /* synthetic */ void a(bn bnVar, String str, WxaPluginPkgInfo wxaPluginPkgInfo) {
        String str2;
        AppMethodBeat.i(183034);
        String a2 = a.a(str, wxaPluginPkgInfo);
        if (bnVar.kOr.get(a2) == null) {
            String str3 = wxaPluginPkgInfo.provider;
            p.g(str3, "plugin.provider");
            WxaPkg h2 = bnVar.h(str3, new g(wxaPluginPkgInfo));
            if (h2 == null) {
                p.hyc();
            }
            f fVar = new f(wxaPluginPkgInfo);
            q.a aVar = new q.a();
            aVar.kKH = h2;
            aVar.kKI = h2.bwh();
            fVar.invoke(aVar);
            bnVar.kOr.put(a2, aVar);
            String str4 = wxaPluginPkgInfo.prefixPath;
            if (str4 == null || str4.length() == 0) {
                int length = a2.length() - a.b(wxaPluginPkgInfo).length();
                if (a2 == null) {
                    t tVar = new t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(183034);
                    throw tVar;
                }
                a2 = a2.substring(0, length);
                p.g(a2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            if (n.a((CharSequence) a2, '/')) {
                int length2 = a2.length() - 1;
                if (a2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(183034);
                    throw tVar2;
                }
                String substring = a2.substring(0, length2);
                p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                str2 = substring;
            } else {
                str2 = a2;
            }
            for (WxaPkg.Info info : h2.bwi()) {
                String str5 = str2 + com.tencent.mm.plugin.appbrand.appstorage.n.We(info.fileName);
                p.g(info, "info");
                q.a a3 = a(info, h2);
                fVar.invoke(a3);
                bnVar.kOr.put(str5, a3);
            }
        }
        AppMethodBeat.o(183034);
    }
}
