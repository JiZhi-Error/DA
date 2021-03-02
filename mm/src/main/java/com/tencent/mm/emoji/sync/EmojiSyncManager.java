package com.tencent.mm.emoji.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014*\u0001\r\u0018\u0000 62\u00020\u0001:\u0003678B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\b\u0010&\u001a\u00020\u001bH\u0002J\b\u0010'\u001a\u00020#H\u0002J\u0006\u0010(\u001a\u00020#J\u0016\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u001bJ\u0006\u0010,\u001a\u00020#J\u0006\u0010-\u001a\u00020#J\u000e\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u00020\u0011J\u000e\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020\u0007J\u000e\u0010*\u001a\u00020#2\u0006\u00102\u001a\u00020\u001bJ\b\u00103\u001a\u00020#H\u0002J\u0006\u00104\u001a\u00020#J\u000e\u00105\u001a\u00020#2\u0006\u00101\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0004\n\u0002\u0010\u000eR2\u0010\u000f\u001a&\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u0011 \u0012*\u0012\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u0011\u0018\u00010\u00130\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0004¢\u0006\u0002\n\u0000R \u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00038F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000bR\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u001c@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u000b¨\u00069"}, hxF = {"Lcom/tencent/mm/emoji/sync/EmojiSyncManager;", "", "customType", "", "(I)V", "callbackQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/sync/SyncCallback;", "connectivityReceiver", "Landroid/content/BroadcastReceiver;", "getCustomType", "()I", "downloadCallback", "com/tencent/mm/emoji/sync/EmojiSyncManager$downloadCallback$1", "Lcom/tencent/mm/emoji/sync/EmojiSyncManager$downloadCallback$1;", "downloadList", "", "", "kotlin.jvm.PlatformType", "", "downloadQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/emoji/sync/EmojiDownLoadTask;", "<set-?>", "remainSize", "getRemainSize", "startNonWifi", "", "Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;", "syncState", "getSyncState", "()Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;", "totalSize", "getTotalSize", JsApiAddDownloadTask.NAME, "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "checkAutoStart", "checkBroken", "checkSync", "checkSyncEmoji", "start", "withBroken", "destroy", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "markBroken", "md5", "registerCallback", "callback", "force", "startInternal", "stop", "unregisterCallback", "Companion", "ConnectivityReceiver", "SyncState", "plugin-emojisdk_release"})
public final class EmojiSyncManager {
    private static long hcX;
    private static EmojiSyncManager hcY;
    private static EmojiSyncManager hcZ;
    public static final a hda = new a((byte) 0);
    private BroadcastReceiver aMq;
    public int cnR;
    private final com.tencent.mm.loader.g.d<c> hcQ = new com.tencent.mm.loader.g.d<>(new com.tencent.mm.loader.g.a.f(new com.tencent.mm.loader.g.a.a(Integer.MAX_VALUE), new com.tencent.mm.loader.g.a.g(1, (byte) 0), 1, "EmojiSync"));
    private final LinkedList<f> hcR = new LinkedList<>();
    public b hcS = b.Init;
    public final List<String> hcT = Collections.synchronizedList(new LinkedList());
    private boolean hcU;
    private final d hcV = new d(this);
    final int hcW;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;", "", "(Ljava/lang/String;I)V", "Init", "Syncing", "Wait", "WaitOffline", "End", "plugin-emojisdk_release"})
    public enum b {
        Init,
        Syncing,
        Wait,
        WaitOffline,
        End;

        static {
            AppMethodBeat.i(105739);
            AppMethodBeat.o(105739);
        }

        public static b valueOf(String str) {
            AppMethodBeat.i(105741);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(105741);
            return bVar;
        }
    }

    static {
        AppMethodBeat.i(105761);
        AppMethodBeat.o(105761);
    }

    public static final boolean awm() {
        AppMethodBeat.i(177055);
        boolean awm = a.awm();
        AppMethodBeat.o(177055);
        return awm;
    }

    public static final void zl(long j2) {
        AppMethodBeat.i(177054);
        a.zl(j2);
        AppMethodBeat.o(177054);
    }

    public EmojiSyncManager(int i2) {
        AppMethodBeat.i(105760);
        this.hcW = i2;
        AppMethodBeat.o(105760);
    }

    public static final /* synthetic */ boolean f(EmojiSyncManager emojiSyncManager) {
        AppMethodBeat.i(105763);
        boolean awi = emojiSyncManager.awi();
        AppMethodBeat.o(105763);
        return awi;
    }

    public static final /* synthetic */ void g(EmojiSyncManager emojiSyncManager) {
        AppMethodBeat.i(105764);
        emojiSyncManager.startInternal();
        AppMethodBeat.o(105764);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\b\u0010\f\u001a\u00020\rH\u0007J\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/emoji/sync/EmojiSyncManager$Companion;", "", "()V", "MaxNoWifiCount", "", "captureSyncMgr", "Lcom/tencent/mm/emoji/sync/EmojiSyncManager;", "customSyncMgr", "noWifiCount", "addNoWifiSize", "", "size", "checkNoWifiSize", "", "getCaptureSyncMgr", "getCustomSyncMgr", "plugin-emojisdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void zl(long j2) {
            AppMethodBeat.i(177052);
            Log.i(e.TAG, "addNoWifiSize " + j2 + ", " + EmojiSyncManager.hcX);
            if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                EmojiSyncManager.hcX += j2;
            }
            AppMethodBeat.o(177052);
        }

        public static boolean awm() {
            AppMethodBeat.i(177053);
            Log.i(e.TAG, "checkNoWifiSize " + (EmojiSyncManager.hcX / 1048576) + "MB");
            if (EmojiSyncManager.hcX < 52428800) {
                AppMethodBeat.o(177053);
                return true;
            }
            AppMethodBeat.o(177053);
            return false;
        }

        public static EmojiSyncManager awn() {
            AppMethodBeat.i(105736);
            EmojiSyncManager emojiSyncManager = EmojiSyncManager.hcY;
            if (emojiSyncManager == null) {
                emojiSyncManager = new EmojiSyncManager(0);
                EmojiSyncManager.hcY = emojiSyncManager;
            }
            AppMethodBeat.o(105736);
            return emojiSyncManager;
        }

        public static EmojiSyncManager awo() {
            AppMethodBeat.i(105737);
            EmojiSyncManager emojiSyncManager = EmojiSyncManager.hcZ;
            if (emojiSyncManager == null) {
                emojiSyncManager = new EmojiSyncManager(1);
                EmojiSyncManager.hcZ = emojiSyncManager;
            }
            AppMethodBeat.o(105737);
            return emojiSyncManager;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/emoji/sync/EmojiSyncManager$downloadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/emoji/sync/EmojiDownLoadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojisdk_release"})
    public static final class d implements com.tencent.mm.loader.g.f<c> {
        final /* synthetic */ EmojiSyncManager hdb;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(EmojiSyncManager emojiSyncManager) {
            this.hdb = emojiSyncManager;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.g.c, com.tencent.mm.loader.g.j] */
        @Override // com.tencent.mm.loader.g.f
        public final /* synthetic */ void a(c cVar, j jVar) {
            AppMethodBeat.i(105747);
            c cVar2 = cVar;
            p.h(cVar2, "task");
            p.h(jVar, "status");
            Log.i(e.TAG, this.hdb.hcW + " onLoaderFin: " + cVar2.gWm.getMd5() + ' ' + jVar);
            if (jVar == j.OK) {
                this.hdb.hcT.remove(cVar2.gWm.getMd5());
            } else if (jVar == j.Fail) {
                this.hdb.hcT.remove(cVar2.gWm.getMd5());
            }
            if (this.hdb.hcT.size() > 0) {
                com.tencent.mm.ac.d.h(new a(this));
                a aVar = EmojiSyncManager.hda;
                a.zl(s.boW(cVar2.gWm.hYx()));
                if (!EmojiSyncManager.f(this.hdb)) {
                    this.hdb.stop();
                    AppMethodBeat.o(105747);
                    return;
                }
            } else {
                this.hdb.hcS = b.End;
                this.hdb.hcU = false;
                com.tencent.mm.ac.d.h(new b(this));
            }
            AppMethodBeat.o(105747);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ d hdl;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar) {
                super(0);
                this.hdl = dVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(105745);
                for (f fVar : this.hdl.hdb.hcR) {
                    fVar.awp();
                }
                x xVar = x.SXb;
                AppMethodBeat.o(105745);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class b extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ d hdl;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(d dVar) {
                super(0);
                this.hdl = dVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(105746);
                for (f fVar : this.hdl.hdb.hcR) {
                    fVar.a(this.hdl.hdb.hcS);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(105746);
                return xVar;
            }
        }
    }

    public final void init() {
        AppMethodBeat.i(105752);
        Log.i(e.TAG, "init customType: " + this.hcW);
        this.hcQ.a(this.hcV);
        this.aMq = new ConnectivityReceiver();
        MMApplicationContext.getContext().registerReceiver(this.aMq, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        AppMethodBeat.o(105752);
    }

    public final void destroy() {
        AppMethodBeat.i(105753);
        Log.i(e.TAG, "destroy customType: " + this.hcW);
        this.hcQ.b(this.hcV);
        this.hcQ.clean();
        if (this.aMq != null) {
            MMApplicationContext.getContext().unregisterReceiver(this.aMq);
            this.aMq = null;
        }
        AppMethodBeat.o(105753);
    }

    public final void start(boolean z) {
        AppMethodBeat.i(105754);
        if (!MMApplicationContext.isMainProcess()) {
            AppMethodBeat.o(105754);
            return;
        }
        this.hcU = z;
        if (this.hcS != b.Syncing) {
            List<String> list = this.hcT;
            p.g(list, "downloadList");
            if ((!list.isEmpty()) && awi()) {
                startInternal();
            }
        }
        AppMethodBeat.o(105754);
    }

    public final void stop() {
        AppMethodBeat.i(105755);
        Log.i(e.TAG, this.hcW + " stop: " + NetStatusUtil.isWifi(MMApplicationContext.getContext()));
        this.hcU = false;
        this.hcQ.clean();
        if (!this.hcT.isEmpty()) {
            this.hcS = b.Wait;
            com.tencent.mm.ac.d.h(new g(this));
        }
        AppMethodBeat.o(105755);
    }

    private void n(EmojiInfo emojiInfo) {
        AppMethodBeat.i(105756);
        p.h(emojiInfo, "emojiInfo");
        Log.i(e.TAG, this.hcW + " addDownloadTask: " + emojiInfo.getMd5());
        this.hcQ.c(new c(emojiInfo));
        AppMethodBeat.o(105756);
    }

    public final void eg(boolean z) {
        AppMethodBeat.i(105757);
        if (!MMApplicationContext.isMainProcess()) {
            AppMethodBeat.o(105757);
            return;
        }
        Log.i(e.TAG, this.hcW + " checkSyncEmoji: true " + z);
        com.tencent.mm.ac.d.b("EmojiSyncManager_checkBrokenEmoji", new c(this, z));
        AppMethodBeat.o(105757);
    }

    private final void startInternal() {
        AppMethodBeat.i(105758);
        Log.i(e.TAG, this.hcW + " startInternal: " + this.hcU + ' ' + NetStatusUtil.isWifi(MMApplicationContext.getContext()) + ' ' + "size is " + this.hcT.size());
        com.tencent.mm.emoji.loader.a.b bVar = com.tencent.mm.emoji.loader.a.b.gVU;
        com.tencent.mm.emoji.loader.a.b.clear();
        List<String> list = this.hcT;
        p.g(list, "downloadList");
        List<String> list2 = list;
        synchronized (list2) {
            try {
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class);
                    p.g(ah, "plugin(IPluginEmoji::class.java)");
                    EmojiInfo amm = ((com.tencent.mm.plugin.emoji.b.d) ah).getProvider().amm(it.next());
                    if (amm != null) {
                        n(amm);
                    }
                }
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(105758);
                throw th;
            }
        }
        this.hcS = b.Syncing;
        com.tencent.mm.ac.d.h(new f(this));
        AppMethodBeat.o(105758);
    }

    private final boolean awi() {
        AppMethodBeat.i(105759);
        if (this.hcU || NetStatusUtil.isWifi(MMApplicationContext.getContext()) || a.awm()) {
            AppMethodBeat.o(105759);
            return true;
        }
        AppMethodBeat.o(105759);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"Lcom/tencent/mm/emoji/sync/EmojiSyncManager$ConnectivityReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/tencent/mm/emoji/sync/EmojiSyncManager;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-emojisdk_release"})
    public final class ConnectivityReceiver extends BroadcastReceiver {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public ConnectivityReceiver() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(105738);
            p.h(context, "context");
            p.h(intent, "intent");
            if (!NetStatusUtil.isConnected(context)) {
                EmojiSyncManager.this.stop();
                AppMethodBeat.o(105738);
            } else if (NetStatusUtil.isWifi(context)) {
                EmojiSyncManager.this.start(false);
                AppMethodBeat.o(105738);
            } else {
                if (!EmojiSyncManager.this.hcU) {
                    EmojiSyncManager.this.stop();
                }
                AppMethodBeat.o(105738);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ EmojiSyncManager hdb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(EmojiSyncManager emojiSyncManager) {
            super(0);
            this.hdb = emojiSyncManager;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(105750);
            for (f fVar : this.hdb.hcR) {
                fVar.a(this.hdb.hcS);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(105750);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ EmojiSyncManager hdb;
        final /* synthetic */ f hdm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(EmojiSyncManager emojiSyncManager, f fVar) {
            super(0);
            this.hdb = emojiSyncManager;
            this.hdm = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(105748);
            this.hdb.hcR.add(this.hdm);
            x xVar = x.SXb;
            AppMethodBeat.o(105748);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ EmojiSyncManager hdb;
        final /* synthetic */ f hdm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(EmojiSyncManager emojiSyncManager, f fVar) {
            super(0);
            this.hdb = emojiSyncManager;
            this.hdm = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(105751);
            this.hdb.hcR.remove(this.hdm);
            x xVar = x.SXb;
            AppMethodBeat.o(105751);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ EmojiSyncManager hdb;
        final /* synthetic */ boolean hdi;
        final /* synthetic */ boolean hdj = true;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(EmojiSyncManager emojiSyncManager, boolean z) {
            super(0);
            this.hdb = emojiSyncManager;
            this.hdi = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            ArrayList auO;
            AppMethodBeat.i(105744);
            if (this.hdi) {
                EmojiSyncManager.d(this.hdb);
            }
            this.hdb.hcT.clear();
            if (this.hdb.hcW == 1) {
                bj gCJ = bj.gCJ();
                p.g(gCJ, "EmojiStorageMgr.getInstance()");
                List<EmojiInfo> AN = gCJ.cgN().AN(true);
                p.g(AN, "EmojiStorageMgr.getInsta…getCaptureEmojiList(true)");
                ArrayList arrayList = new ArrayList();
                for (T t : AN) {
                    T t2 = t;
                    p.g(t2, LocaleUtil.ITALIAN);
                    if (t2.hYs() == EmojiInfo.a.STATUS_SUCCESS) {
                        arrayList.add(t);
                    }
                }
                auO = arrayList;
            } else {
                com.tencent.mm.emoji.b.j auL = com.tencent.mm.emoji.b.j.auL();
                p.g(auL, "EmojiStorageCache.getInstance()");
                auO = auL.auO();
            }
            if (auO == null) {
                auO = new ArrayList();
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : auO) {
                EmojiInfo emojiInfo = (EmojiInfo) obj;
                p.g(emojiInfo, LocaleUtil.ITALIAN);
                if (!s.YS(emojiInfo.hYy()) || emojiInfo.getState() == EmojiInfo.Vlf) {
                    arrayList2.add(obj);
                }
            }
            List list = this.hdb.hcT;
            ArrayList<EmojiInfo> arrayList3 = arrayList2;
            ArrayList arrayList4 = new ArrayList(kotlin.a.j.a(arrayList3, 10));
            for (EmojiInfo emojiInfo2 : arrayList3) {
                p.g(emojiInfo2, LocaleUtil.ITALIAN);
                arrayList4.add(emojiInfo2.getMd5());
            }
            list.addAll(arrayList4);
            this.hdb.cnR = auO.size();
            Log.i(e.TAG, this.hdb.hcW + " checkSyncEmoji: total size " + this.hdb.cnR + ", need download size " + this.hdb.hcT.size());
            if (this.hdb.hcT.size() <= 0) {
                this.hdb.hcS = b.End;
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.emoji.sync.EmojiSyncManager.c.AnonymousClass2 */
                    final /* synthetic */ c hdk;

                    {
                        this.hdk = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(105743);
                        for (f fVar : this.hdk.hdb.hcR) {
                            fVar.a(this.hdk.hdb.hcS);
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(105743);
                        return xVar;
                    }
                });
            } else if (!this.hdj || !EmojiSyncManager.f(this.hdb)) {
                this.hdb.hcS = b.Wait;
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.emoji.sync.EmojiSyncManager.c.AnonymousClass1 */
                    final /* synthetic */ c hdk;

                    {
                        this.hdk = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(105742);
                        for (f fVar : this.hdk.hdb.hcR) {
                            fVar.a(this.hdk.hdb.hcS);
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(105742);
                        return xVar;
                    }
                });
            } else {
                EmojiSyncManager.g(this.hdb);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(105744);
            return xVar;
        }
    }

    public static final /* synthetic */ void d(EmojiSyncManager emojiSyncManager) {
        boolean z = false;
        AppMethodBeat.i(105762);
        if (emojiSyncManager.hcW == 1) {
            ArrayList<EmojiInfo> dU = com.tencent.mm.emoji.b.j.auL().dU(false);
            if (dU == null) {
                AppMethodBeat.o(105762);
                return;
            }
            ArrayList<EmojiInfo> arrayList = new ArrayList();
            for (T t : dU) {
                T t2 = t;
                p.g(t2, LocaleUtil.ITALIAN);
                if (!s.YS(t2.hYy())) {
                    arrayList.add(t);
                }
            }
            boolean z2 = false;
            for (EmojiInfo emojiInfo : arrayList) {
                p.g(emojiInfo, LocaleUtil.ITALIAN);
                emojiInfo.setState(EmojiInfo.Vlf);
                com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class);
                p.g(ah, "plugin(IPluginEmoji::class.java)");
                ((com.tencent.mm.plugin.emoji.b.d) ah).getProvider().updateEmojiInfo(emojiInfo);
                z2 = true;
            }
            if (z2) {
                com.tencent.mm.emoji.b.j.auL().dY(true);
                AppMethodBeat.o(105762);
                return;
            }
        } else {
            com.tencent.mm.emoji.b.j auL = com.tencent.mm.emoji.b.j.auL();
            p.g(auL, "EmojiStorageCache.getInstance()");
            ArrayList<EmojiInfo> auO = auL.auO();
            if (auO == null) {
                AppMethodBeat.o(105762);
                return;
            }
            ArrayList<EmojiInfo> arrayList2 = new ArrayList();
            for (T t3 : auO) {
                T t4 = t3;
                p.g(t4, LocaleUtil.ITALIAN);
                if (!s.YS(t4.hYy())) {
                    arrayList2.add(t3);
                }
            }
            for (EmojiInfo emojiInfo2 : arrayList2) {
                p.g(emojiInfo2, LocaleUtil.ITALIAN);
                emojiInfo2.setState(EmojiInfo.Vlf);
                com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class);
                p.g(ah2, "plugin(IPluginEmoji::class.java)");
                ((com.tencent.mm.plugin.emoji.b.d) ah2).getProvider().updateEmojiInfo(emojiInfo2);
                z = true;
            }
            if (z) {
                com.tencent.mm.emoji.b.j.auL().dW(true);
            }
        }
        AppMethodBeat.o(105762);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ EmojiSyncManager hdb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(EmojiSyncManager emojiSyncManager) {
            super(0);
            this.hdb = emojiSyncManager;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(105749);
            for (f fVar : this.hdb.hcR) {
                fVar.a(this.hdb.hcS);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(105749);
            return xVar;
        }
    }
}
