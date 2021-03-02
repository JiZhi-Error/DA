package com.tencent.mm.plugin.recordvideo;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.e;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.background.d;
import com.tencent.mm.plugin.recordvideo.background.provider.a;
import com.tencent.mm.plugin.recordvideo.background.provider.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.y;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\u0012\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\u001c\u0010\u001a\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u001c\u0010\u001e\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016R\u0010\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/PluginVideoEditor;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/recordvideo/IPluginVideoEditor;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "Lcom/tencent/mm/kernel/api/bucket/ICoreStorageCallbackBucket;", "()V", "appForegroundListener", "com/tencent/mm/plugin/recordvideo/PluginVideoEditor$appForegroundListener$1", "Lcom/tencent/mm/plugin/recordvideo/PluginVideoEditor$appForegroundListener$1;", "videoEditorDataStorage", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditDataStorage;", "collectDatabaseFactory", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "configure", "", Scopes.PROFILE, "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "execute", "getVideoEditorDataStorage", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "onDataBaseClosed", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "readOnlyDB", "onDataBaseOpened", "plugin-recordvideo_release"})
public final class PluginVideoEditor extends f implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, d, a {
    private com.tencent.mm.plugin.recordvideo.background.d BJm;
    private final a BJn = new a();

    public PluginVideoEditor() {
        AppMethodBeat.i(75051);
        AppMethodBeat.o(75051);
    }

    @Override // com.tencent.mm.kernel.b.f
    public final void configure(g gVar) {
        AppMethodBeat.i(237235);
        y.b("recordPlugin", "recordPlugin", 259200000, 99);
        AppMethodBeat.o(237235);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public final void execute(g gVar) {
        ConfigurationInfo configurationInfo;
        AppMethodBeat.i(75045);
        c.a aVar = com.tencent.mm.media.k.c.ilt;
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        p.h(context, "context");
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            if (activityManager != null) {
                configurationInfo = activityManager.getDeviceConfigurationInfo();
            } else {
                configurationInfo = null;
            }
            if (configurationInfo != null) {
                int i2 = (configurationInfo.reqGlEsVersion & -65536) >> 16;
                MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("mmkv_gl_key");
                int decodeInt = mmkv.decodeInt("support_egl_context_client_version", 3);
                Log.i("MicroMsg.GLEnvironmentUtil", "egl support version " + configurationInfo.getGlEsVersion() + "   configurationInfo.reqGlEsVersion : " + configurationInfo.reqGlEsVersion + "   major:" + i2 + "  curVersion:" + decodeInt);
                if (decodeInt >= 3 && i2 == 2) {
                    Log.i("MicroMsg.GLEnvironmentUtil", "markEglVersion2");
                    e eVar = e.ilC;
                    e.aNq();
                }
                if (!mmkv.decodeBool("has_reported_egl_version", false)) {
                    Log.i("MicroMsg.GLEnvironmentUtil", "markEglVersion3");
                    e eVar2 = e.ilC;
                    e.aNr();
                    mmkv.encode("has_reported_egl_version", true);
                }
                if (i2 >= 3) {
                    i2 = 3;
                }
                if (i2 <= 2) {
                    i2 = 2;
                }
                mmkv.encode("support_egl_context_client_version", i2);
            }
            if (configurationInfo == null) {
                Log.e("MicroMsg.GLEnvironmentUtil", "configurationInfo == null");
            }
            if (!((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_gles_version_enable, true)) {
                MultiProcessMMKV.getMMKV("mmkv_gl_key").encode("support_egl_context_client_version", 3);
                AppMethodBeat.o(75045);
                return;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.GLEnvironmentUtil", e2, "", new Object[0]);
        }
        AppMethodBeat.o(75045);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(75046);
        this.BJn.alive();
        com.tencent.mm.plugin.recordvideo.background.f fVar = com.tencent.mm.plugin.recordvideo.background.f.BKw;
        com.tencent.mm.plugin.recordvideo.background.f.eIX();
        AppMethodBeat.o(75046);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
        AppMethodBeat.i(75047);
        this.BJn.dead();
        AppMethodBeat.o(75047);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    static final class b implements h.b {
        public static final b BJo = new b();

        static {
            AppMethodBeat.i(75042);
            AppMethodBeat.o(75042);
        }

        b() {
        }

        @Override // com.tencent.mm.storagebase.h.b
        public final String[] getSQLs() {
            AppMethodBeat.i(75041);
            d.a aVar = com.tencent.mm.plugin.recordvideo.background.d.BKl;
            String[] strArr = com.tencent.mm.plugin.recordvideo.background.d.SQL_CREATE;
            AppMethodBeat.o(75041);
            return strArr;
        }
    }

    @Override // com.tencent.mm.kernel.api.a
    public final HashMap<Integer, h.b> collectDatabaseFactory() {
        AppMethodBeat.i(75048);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        c.a aVar = com.tencent.mm.plugin.recordvideo.background.c.BKh;
        hashMap.put(Integer.valueOf(com.tencent.mm.plugin.recordvideo.background.c.TABLE.hashCode()), b.BJo);
        b.a aVar2 = com.tencent.mm.plugin.recordvideo.background.provider.b.BMF;
        hashMap.put(Integer.valueOf(com.tencent.mm.plugin.recordvideo.background.provider.b.TABLE.hashCode()), c.BJp);
        AppMethodBeat.o(75048);
        return hashMap;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    static final class c implements h.b {
        public static final c BJp = new c();

        static {
            AppMethodBeat.i(75044);
            AppMethodBeat.o(75044);
        }

        c() {
        }

        @Override // com.tencent.mm.storagebase.h.b
        public final String[] getSQLs() {
            AppMethodBeat.i(75043);
            a.C1645a aVar = com.tencent.mm.plugin.recordvideo.background.provider.a.BMs;
            String[] strArr = com.tencent.mm.plugin.recordvideo.background.provider.a.SQL_CREATE;
            AppMethodBeat.o(75043);
            return strArr;
        }
    }

    @Override // com.tencent.mm.kernel.api.e
    public final void onDataBaseOpened(h hVar, h hVar2) {
        AppMethodBeat.i(75049);
        if (hVar == null) {
            p.hyc();
        }
        this.BJm = new com.tencent.mm.plugin.recordvideo.background.d(hVar);
        AppMethodBeat.o(75049);
    }

    @Override // com.tencent.mm.kernel.api.e
    public final void onDataBaseClosed(h hVar, h hVar2) {
    }

    public final com.tencent.mm.plugin.recordvideo.background.d getVideoEditorDataStorage() {
        AppMethodBeat.i(75050);
        com.tencent.mm.kernel.g.aAf().azk();
        if (this.BJm == null) {
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            h dataDB = aAh.getDataDB();
            p.g(dataDB, "MMKernel.storage().dataDB");
            this.BJm = new com.tencent.mm.plugin.recordvideo.background.d(dataDB);
        }
        com.tencent.mm.plugin.recordvideo.background.d dVar = this.BJm;
        if (dVar == null) {
            p.hyc();
        }
        AppMethodBeat.o(75050);
        return dVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/recordvideo/PluginVideoEditor$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "onAppBackground", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "", "onAppForeground", "plugin-recordvideo_release"})
    public static final class a extends o.a {
        a() {
        }

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(75039);
            if (com.tencent.mm.kernel.g.aAc()) {
                com.tencent.mm.kernel.a aAf = com.tencent.mm.kernel.g.aAf();
                p.g(aAf, "account()");
                if (aAf.azq() && !com.tencent.mm.kernel.a.azj()) {
                    com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                    p.g(aAh, "storage()");
                    Object obj = aAh.azQ().get(ar.a.USERINFO_VIDEO_RECORD_CLEAN_BG_MIX_TASK_TIME_LONG, (Object) 0L);
                    if (obj == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.Long");
                        AppMethodBeat.o(75039);
                        throw tVar;
                    } else if (Util.secondsToNow(Util.nullAsNil((Long) obj)) > 86400) {
                        com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
                        p.g(aAh2, "storage()");
                        aAh2.azQ().set(ar.a.USERINFO_VIDEO_RECORD_CLEAN_BG_MIX_TASK_TIME_LONG, Long.valueOf(Util.nowSecond()));
                        com.tencent.mm.plugin.recordvideo.background.e eVar = com.tencent.mm.plugin.recordvideo.background.e.BKp;
                        com.tencent.mm.plugin.recordvideo.background.e.eIU();
                    }
                }
            }
            AppMethodBeat.o(75039);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(75040);
            if (com.tencent.mm.kernel.g.aAc()) {
                com.tencent.mm.kernel.a aAf = com.tencent.mm.kernel.g.aAf();
                p.g(aAf, "account()");
                if (aAf.azq()) {
                    com.tencent.mm.kernel.a.azj();
                }
            }
            AppMethodBeat.o(75040);
        }
    }
}
