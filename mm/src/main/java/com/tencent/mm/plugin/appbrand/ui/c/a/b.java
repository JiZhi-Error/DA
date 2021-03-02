package com.tencent.mm.plugin.appbrand.ui.c.a;

import com.facebook.appevents.UserDataStore;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.stats.netstats.NetstatsParserPatterns;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.m;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.vfs.s;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0004\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002 !B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J&\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J0\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002J8\u0010\u0017\u001a\u00020\u00162\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u000bH\u0007J7\u0010\u001a\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001c\u001a\u00020\u00162\u0016\u0010\u001d\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\u001e\"\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfo;", UserDataStore.DATE_OF_BIRTH, "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "guard", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "deleteAll", "", "appId", "", "versionType", "version", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY;", "fillInitConfig", "", "initConfigWC", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "getScreenshotFilePath", "appVersion", "isDarkMode", "", "updateInfo", "info", "screenshotFilePath", "updateNotify", "item", "isNotify", "keys", "", "(Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfo;Z[Ljava/lang/String;)Z", "Companion", "VERSION_QUERY", "plugin-appbrand-integration_release"})
public final class b extends MAutoStorage<a> {
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(a.iBg, "AppBrandFakeNativeSplashScreenshot")};
    private static final String[] kJX = {"appId", "versionType", "appVersion", "isDarkMode"};
    public static final a ogd = new a((byte) 0);
    private final ISQLiteDatabase db;
    private final ReentrantReadWriteLock ogc = new ReentrantReadWriteLock();

    public static final boolean bZg() {
        AppMethodBeat.i(229593);
        boolean bZg = a.bZg();
        AppMethodBeat.o(229593);
        return bZg;
    }

    public final int afy(String str) {
        AppMethodBeat.i(229589);
        int a2 = a(this, str, 0, (AbstractC0806b) null, 6);
        AppMethodBeat.o(229589);
        return a2;
    }

    public final int ct(String str, int i2) {
        AppMethodBeat.i(229588);
        int a2 = a(this, str, i2, (AbstractC0806b) null, 4);
        AppMethodBeat.o(229588);
        return a2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8G¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR \u0010\f\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u000e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\b¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$Companion;", "", "()V", "KEYS", "", "", "[Ljava/lang/String;", "SCREENSHOT_ROOT", "()Ljava/lang/String;", "SWITCH_ON", "", "()Z", "TABLE_CREATE", "kotlin.jvm.PlatformType", "TAG", OpenSDKTool4Assistant.EXTRA_UIN, "getUin", "generateDir", "appId", "generateFilePath", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static String afz(String str) {
            AppMethodBeat.i(229577);
            String str2 = bZh() + '/' + str;
            AppMethodBeat.o(229577);
            return str2;
        }

        private static String bZh() {
            AppMethodBeat.i(229578);
            StringBuilder append = new StringBuilder().append(com.tencent.mm.loader.j.b.aKB()).append("appbrand/runtime_snapshots/");
            a aVar = b.ogd;
            String sb = append.append(getUin()).toString();
            s.boN(sb);
            AppMethodBeat.o(229578);
            return sb;
        }

        private static String getUin() {
            int ayW;
            AppMethodBeat.i(229579);
            h azG = g.aAe().azG();
            p.g(azG, "MMKernel.process().current()");
            if (azG.aBb()) {
                p.g(g.aAf(), "MMKernel.account()");
                ayW = com.tencent.mm.kernel.a.getUin();
            } else {
                ayW = com.tencent.mm.kernel.a.ayW();
            }
            String pVar = new com.tencent.mm.b.p(ayW).toString();
            p.g(pVar, "if (MMKernel.process().c…(it).toString()\n        }");
            AppMethodBeat.o(229579);
            return pVar;
        }

        public static boolean bZg() {
            AppMethodBeat.i(229580);
            boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_fakenative_use_snapshot_loading, BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE);
            AppMethodBeat.o(229580);
            return a2;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.iBg, "AppBrandFakeNativeSplashScreenshot", m.INDEX_CREATE);
        p.h(iSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        AppMethodBeat.i(229591);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(229591);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, boolean, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean updateNotify(a aVar, boolean z, String[] strArr) {
        AppMethodBeat.i(229590);
        a aVar2 = aVar;
        p.h(strArr, "keys");
        if (aVar2 == null) {
            AppMethodBeat.o(229590);
            return false;
        }
        if (strArr.length >= 0) {
            aVar2.systemRowid = -1;
        }
        boolean updateNotify = super.updateNotify(aVar2, z, (String[]) Arrays.copyOf(strArr, strArr.length));
        AppMethodBeat.o(229590);
        return updateNotify;
    }

    static {
        AppMethodBeat.i(229592);
        AppMethodBeat.o(229592);
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:311)
        	at jadx.core.dex.instructions.InvokeNode.isSame(InvokeNode.java:77)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    public final boolean a(java.lang.String r12, int r13, int r14, boolean r15, java.lang.String r16) {
        /*
        // Method dump skipped, instructions count: 182
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.ui.c.a.b.a(java.lang.String, int, int, boolean, java.lang.String):boolean");
    }

    public final String a(String str, int i2, int i3, boolean z) {
        String str2;
        AppMethodBeat.i(229585);
        ReentrantReadWriteLock.ReadLock readLock = this.ogc.readLock();
        readLock.lock();
        try {
            String str3 = str;
            if (!(str3 == null || str3.length() == 0)) {
                a aVar = new a();
                aVar.field_appId = str;
                aVar.field_versionType = i2;
                aVar.field_appVersion = i3;
                aVar.field_isDarkMode = z;
                String[] strArr = kJX;
                if (super.get(aVar, (String[]) Arrays.copyOf(strArr, strArr.length))) {
                    str2 = aVar.field_screenshotFilePath;
                    return str2;
                }
            }
            str2 = null;
            return str2;
        } finally {
            readLock.unlock();
            AppMethodBeat.o(229585);
        }
    }

    public static /* synthetic */ int a(b bVar, String str, int i2, AbstractC0806b bVar2, int i3) {
        AppMethodBeat.i(229587);
        if ((i3 & 2) != 0) {
            i2 = -1;
        }
        int a2 = bVar.a(str, i2, (i3 & 4) != 0 ? AbstractC0806b.a.oge : bVar2);
        AppMethodBeat.o(229587);
        return a2;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x012a A[LOOP:2: B:39:0x0128->B:40:0x012a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x015e A[LOOP:4: B:55:0x0158->B:57:0x015e, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.lang.String r12, int r13, com.tencent.mm.plugin.appbrand.ui.c.a.b.AbstractC0806b r14) {
        /*
        // Method dump skipped, instructions count: 401
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.ui.c.a.b.a(java.lang.String, int, com.tencent.mm.plugin.appbrand.ui.c.a.b$b):int");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY;", "", "()V", NetstatsParserPatterns.TYPE_BOTH_PATTERN, "EQUAL", "LESS", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY$ALL;", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY$LESS;", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY$EQUAL;", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.c.a.b$b  reason: collision with other inner class name */
    public static abstract class AbstractC0806b {

        @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY$EQUAL;", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY;", "version", "", "(I)V", "getVersion", "()I", "component1", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "", "plugin-appbrand-integration_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.ui.c.a.b$b$b  reason: collision with other inner class name */
        public static final class C0807b extends AbstractC0806b {
            final int version;

            public final boolean equals(Object obj) {
                return this == obj || ((obj instanceof C0807b) && this.version == ((C0807b) obj).version);
            }

            public final int hashCode() {
                return this.version;
            }

            public final String toString() {
                AppMethodBeat.i(229582);
                String str = "EQUAL(version=" + this.version + ")";
                AppMethodBeat.o(229582);
                return str;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY$ALL;", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY;", "()V", "plugin-appbrand-integration_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.ui.c.a.b$b$a */
        public static final class a extends AbstractC0806b {
            public static final a oge = new a();

            static {
                AppMethodBeat.i(229581);
                AppMethodBeat.o(229581);
            }

            private a() {
                super((byte) 0);
            }
        }

        private AbstractC0806b() {
        }

        public /* synthetic */ AbstractC0806b(byte b2) {
            this();
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY$LESS;", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$VERSION_QUERY;", "version", "", "(I)V", "getVersion", "()I", "component1", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "", "plugin-appbrand-integration_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.ui.c.a.b$b$c */
        public static final class c extends AbstractC0806b {
            final int version;

            public final boolean equals(Object obj) {
                return this == obj || ((obj instanceof c) && this.version == ((c) obj).version);
            }

            public final int hashCode() {
                return this.version;
            }

            public final String toString() {
                AppMethodBeat.i(229583);
                String str = "LESS(version=" + this.version + ")";
                AppMethodBeat.o(229583);
                return str;
            }

            public c(int i2) {
                super((byte) 0);
                this.version = i2;
            }
        }
    }
}
