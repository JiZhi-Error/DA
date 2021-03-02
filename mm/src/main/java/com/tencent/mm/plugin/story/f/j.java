package com.tencent.mm.plugin.story.f;

import android.graphics.Point;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.df;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.g.a.xc;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.f;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.story.PluginStory;
import com.tencent.mm.plugin.story.c.a.g;
import com.tencent.mm.plugin.story.f.c.e;
import com.tencent.mm.plugin.story.f.e;
import com.tencent.mm.plugin.story.f.o;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.plugin.story.i.i;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.plugin.story.i.m;
import com.tencent.mm.plugin.story.i.o;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.s;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.File;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\u0018\u0000 C2\u00020\u0001:\u0003BCDB\u0005¢\u0006\u0002\u0010\u0002J\b\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u0002042\u0006\u00106\u001a\u00020\u0018H\u0016J\u0016\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0017H\u0016J\u0006\u00108\u001a\u00020\nJ\u0010\u00109\u001a\u0002042\u0006\u0010:\u001a\u00020\nH\u0016J\b\u0010;\u001a\u000204H\u0016J\u0010\u0010<\u001a\u0002042\u0006\u0010=\u001a\u00020\nH\u0016J\b\u0010>\u001a\u000204H\u0002J\b\u0010?\u001a\u000204H\u0002J\b\u0010@\u001a\u000204H\u0002J\b\u0010A\u001a\u000204H\u0002R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00060\u0015R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R&\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006E"}, hxF = {"Lcom/tencent/mm/plugin/story/model/StoryCore;", "Lcom/tencent/mm/model/ISubCore;", "()V", "appForegroundListener", "Lcom/tencent/mm/plugin/story/model/StoryCore$AppForegroundListener;", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isAccInit", "", "lock", "", "needResetDb", "storyAsyncQueueMgr", "Lcom/tencent/mm/plugin/story/model/StoryAsyncQueueMgr;", "storyCleanListener", "Lcom/tencent/mm/plugin/story/PluginStory$StoryCleanListener;", "storyCommentStorage", "Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage;", "storyConfigChangeListener", "Lcom/tencent/mm/plugin/story/model/StoryCore$ConfigChangedListener;", "storyDBFactories", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "getStoryDBFactories", "()Ljava/util/HashMap;", "setStoryDBFactories", "(Ljava/util/HashMap;)V", "storyEditorDataStorage", "Lcom/tencent/mm/plugin/story/storage/StoryEditorDataStorage;", "storyExtInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage;", "storyHistoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage;", "storyInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage;", "storyLoader", "Lcom/tencent/mm/plugin/story/model/download/StoryLoader;", "storyRoomInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryRoomInfoStorage;", "storyServer", "Lcom/tencent/mm/plugin/story/model/StoryLogic$StoryServer;", "storySyncListener", "Lcom/tencent/mm/plugin/story/PluginStory$StorySynclistener;", "storyUploadManager", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager;", "storyVideoCacheStorage", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCacheStorage;", "taskThread", "checkDir", "", "clearPluginData", "pluginFlag", "getBaseDBFactories", "isValid", "onAccountPostReset", "updated", "onAccountRelease", "onSdcardMount", "mounted", "parpareTaskThread", "removeDirtyDB", "resetDb", "updateConfigs", "AppForegroundListener", "Companion", "ConfigChangedListener", "plugin-story_release"})
public final class j implements bd {
    private static String DKR = "";
    private static final int DLb = 103;
    private static final int Fmt = 150;
    private static final IListener<fp> Fmu = new c();
    private static boolean Fmv = false;
    private static boolean Fmw = false;
    private static long Fmx = -1;
    public static final b Fmy = new b((byte) 0);
    private static final String TAG = TAG;
    private static final Point imX = new Point();
    private boolean DKP;
    private HashMap<Integer, h.b> Fmd = new HashMap<>();
    private k Fme;
    private g Fmf;
    private m Fmg;
    private com.tencent.mm.plugin.story.i.b Fmh;
    private o Fmi;
    private i Fmj;
    private com.tencent.mm.plugin.story.f.g.c Fmk;
    private e Fml;
    private e Fmm;
    private o.a Fmn;
    private PluginStory.c Fmo = new PluginStory.c();
    private PluginStory.b Fmp = new PluginStory.b();
    private d Fmq = new d();
    private a Fmr = new a();
    private MMHandler Fms = new MMHandler("SnsCore_task_handler");
    private final MMHandler handler = new MMHandler(Looper.getMainLooper());
    private h hqK;
    private final byte[] lock = new byte[0];
    private boolean tnN;

    public j() {
        AppMethodBeat.i(118712);
        this.Fmd.put(Integer.valueOf(k.TABLE.hashCode()), AnonymousClass1.Fmz);
        this.Fmd.put(Integer.valueOf("StoryExtItem".hashCode()), AnonymousClass2.FmA);
        this.Fmd.put(Integer.valueOf("StoryCommentSync".hashCode()), AnonymousClass3.FmB);
        this.Fmd.put(Integer.valueOf("StoryVideoCacheInfo".hashCode()), AnonymousClass4.FmC);
        this.Fmd.put(Integer.valueOf("StoryEditorInfo".hashCode()), AnonymousClass5.FmD);
        this.Fmd.put(Integer.valueOf("StoryRoomInfo".hashCode()), AnonymousClass6.FmE);
        this.Fmd.put(Integer.valueOf(i.TABLE.hashCode()), AnonymousClass7.FmF);
        AppMethodBeat.o(118712);
    }

    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        AppMethodBeat.i(118709);
        if (this.DKP) {
            AppMethodBeat.o(118709);
            return;
        }
        this.DKP = true;
        this.tnN = true;
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class);
        p.g(ah, "plugin(IPluginStory::class.java)");
        s.boN(((com.tencent.mm.plugin.story.api.e) ah).getAccStoryPath());
        com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class);
        p.g(ah2, "plugin(IPluginStory::class.java)");
        s.boN(((com.tencent.mm.plugin.story.api.e) ah2).getAccStoryTmpPath());
        EventCenter.instance.addListener(this.Fmo);
        EventCenter.instance.addListener(this.Fmp);
        com.tencent.mm.pluginsdk.cmd.b.a(new h(), "//story");
        com.tencent.mm.plugin.story.f.g.c foi = b.foi();
        foi.ibn.a(foi.FqB);
        foi.vSA.a(foi.FqC);
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(351, foi);
        g fod = b.fod();
        fod.add(fod);
        com.tencent.mm.plugin.story.f.b.b bVar = com.tencent.mm.plugin.story.f.b.b.Fom;
        if (s.YS(com.tencent.mm.plugin.story.f.b.b.Fod) && !s.YS(com.tencent.mm.plugin.story.f.b.b.DNm)) {
            s.nx(com.tencent.mm.plugin.story.f.b.b.Fod, com.tencent.mm.plugin.story.f.b.b.DNm);
        }
        byte[] aW = s.aW(com.tencent.mm.plugin.story.f.b.b.DNm, 0, -1);
        if (aW != null) {
            if (!(aW.length == 0)) {
                com.tencent.mm.plugin.story.f.b.b.Fof.parseFrom(aW);
            }
        }
        com.tencent.mm.kernel.b aAg2 = com.tencent.mm.kernel.g.aAg();
        p.g(aAg2, "network()");
        aAg2.azz().a(f.CTRL_INDEX, bVar);
        com.tencent.mm.kernel.b aAg3 = com.tencent.mm.kernel.g.aAg();
        p.g(aAg3, "network()");
        aAg3.azz().a(764, bVar);
        com.tencent.mm.plugin.story.f.b.b.fbQ();
        b.fon();
        com.tencent.mm.plugin.story.f.f.a.FpB.init();
        Fmu.alive();
        l lVar = l.FmK;
        l.reset();
        l lVar2 = l.FmK;
        s.boN(l.m31for() + "coming/");
        s.boN(l.m31for() + "pic/");
        s.boN(l.m31for() + "video/");
        com.tencent.mm.plugin.story.api.p.FkJ = com.tencent.mm.plugin.story.f.d.e.FoL;
        EventCenter.instance.addListener(this.Fmq);
        this.Fmr.alive();
        AppMethodBeat.o(118709);
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
        AppMethodBeat.i(118710);
        this.Fmr.dead();
        EventCenter.instance.removeListener(this.Fmo);
        EventCenter.instance.removeListener(this.Fmp);
        EventCenter.instance.removeListener(this.Fmq);
        com.tencent.mm.pluginsdk.cmd.b.V("//story");
        com.tencent.mm.plugin.story.f.g.c foi = b.foi();
        foi.ibn.b(foi.FqB);
        foi.vSA.b(foi.FqC);
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(351, foi);
        g fod = b.fod();
        fod.remove(fod);
        com.tencent.mm.plugin.story.f.b.b bVar = com.tencent.mm.plugin.story.f.b.b.Fom;
        com.tencent.mm.plugin.story.f.b.b.foR();
        com.tencent.mm.kernel.b aAg2 = com.tencent.mm.kernel.g.aAg();
        p.g(aAg2, "network()");
        aAg2.azz().b(f.CTRL_INDEX, bVar);
        com.tencent.mm.kernel.b aAg3 = com.tencent.mm.kernel.g.aAg();
        p.g(aAg3, "network()");
        aAg3.azz().b(764, bVar);
        com.tencent.mm.plugin.story.f.f.a aVar = com.tencent.mm.plugin.story.f.f.a.FpB;
        Log.i(com.tencent.mm.plugin.story.f.f.a.TAG, "destroy: ");
        b.fod().remove(aVar);
        b.foc().remove(aVar);
        com.tencent.mm.plugin.story.f.f.a.ndV.clear();
        com.tencent.mm.plugin.story.f.f.a.Fpz.dead();
        com.tencent.mm.plugin.story.f.b.b bVar2 = com.tencent.mm.plugin.story.f.b.b.Fom;
        com.tencent.mm.plugin.story.f.b.b.g(com.tencent.mm.plugin.story.f.f.a.FpA);
        Fmu.dead();
        AppMethodBeat.o(118710);
    }

    private static void fax() {
        AppMethodBeat.i(222907);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        String[] list = new File(aAh.azM()).list();
        if (list != null) {
            for (String str : list) {
                Log.i(TAG, "removeDirtyDB file:%s", str);
                if (str != null && n.e(str, "StoryMicroMsg")) {
                    Log.i(TAG, "removeDirtyDB will delete:%s", str);
                    s.deleteFile(str);
                }
            }
        }
        AppMethodBeat.o(222907);
    }

    public static boolean isValid() {
        AppMethodBeat.i(118711);
        boolean azp = com.tencent.mm.kernel.g.aAf().azp();
        AppMethodBeat.o(118711);
        return azp;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\u0006J\u0006\u0010\u0017\u001a\u00020\tJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0006\u0010\u001a\u001a\u00020\u000fJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u0006J\u0006\u0010 \u001a\u00020\u0004J\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u000206J\u0006\u00107\u001a\u00020\u000fJ\u0006\u00108\u001a\u00020\u000fJ\b\u00109\u001a\u00020:H\u0002J\f\u0010;\u001a\b\u0012\u0004\u0012\u00020=0<J\u000e\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AJ\u000e\u0010B\u001a\u00020:2\u0006\u0010C\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, hxF = {"Lcom/tencent/mm/plugin/story/model/StoryCore$Companion;", "", "()V", "MULTI_THUMB_IMAGEVIEW_OFFSET", "", "TAG", "", "THUMBNAIL_SIZE_LIMIT", "allReadTime", "", "exptChangeListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "fileSys", "initAbTest", "", "multiThumbDisplaySize", "screenSize", "Landroid/graphics/Point;", "singleThumbDisplaySize", "storyIsOpen", "getAccStoryCachePath", "getAccStoryPath", "getAllStoryReadTime", "getCore", "Lcom/tencent/mm/plugin/story/model/StoryCore;", "getCropTypeWithCPU", "getDataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "getRemuxType", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig$StoryProcessType;", "getSelfName", "getSelfUin", "getStoryAsyncQueueMgr", "Lcom/tencent/mm/plugin/story/model/StoryAsyncQueueMgr;", "getStoryCommentStorage", "Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage;", "getStoryEditorDataStorage", "Lcom/tencent/mm/plugin/story/storage/StoryEditorDataStorage;", "getStoryExtInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage;", "getStoryHistoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage;", "getStoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage;", "getStoryRoominfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryRoomInfoStorage;", "getStoryServer", "Lcom/tencent/mm/plugin/story/model/StoryLogic$StoryServer;", "getStoryUploadManager", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager;", "getStoryVideoCacheStorage", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCacheStorage;", "getWorkingHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isInValid", "isShowStory", "loadStoryStatus", "", "loader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "loaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "scene", "Lcom/tencent/mm/plugin/story/model/download/LoaderScene;", "setAllStoryReadTime", "time", "plugin-story_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }

        private static j fob() {
            AppMethodBeat.i(118685);
            j jVar = (j) y.at(j.class);
            if (jVar instanceof j) {
                boolean unused = jVar.DKP;
                if (jVar.tnN) {
                    synchronized (jVar.lock) {
                        try {
                            String str = j.TAG;
                            StringBuilder sb = new StringBuilder("getCore need reset DB now ");
                            Thread currentThread = Thread.currentThread();
                            p.g(currentThread, "Thread.currentThread()");
                            StringBuilder append = sb.append(currentThread.getName()).append(" ");
                            Thread currentThread2 = Thread.currentThread();
                            p.g(currentThread2, "Thread.currentThread()");
                            Log.i(str, append.append(currentThread2.getId()).append(" ").append(jVar.hashCode()).toString());
                            if (jVar.tnN) {
                                j.e(jVar);
                                jVar.tnN = false;
                                Log.i(j.TAG, "resetdb done");
                            }
                            x xVar = x.SXb;
                        } catch (Throwable th) {
                            AppMethodBeat.o(118685);
                            throw th;
                        }
                    }
                }
            }
            p.g(jVar, "theCore");
            AppMethodBeat.o(118685);
            return jVar;
        }

        private static h getDataDB() {
            AppMethodBeat.i(118686);
            h hVar = fob().hqK;
            if (hVar == null) {
                p.hyc();
            }
            AppMethodBeat.o(118686);
            return hVar;
        }

        public static k foc() {
            AppMethodBeat.i(118687);
            com.tencent.mm.kernel.g.aAf().azk();
            if (fob().Fme == null) {
                fob().Fme = new k(getDataDB());
            }
            k kVar = fob().Fme;
            if (kVar == null) {
                p.hyc();
            }
            AppMethodBeat.o(118687);
            return kVar;
        }

        public static g fod() {
            AppMethodBeat.i(118688);
            com.tencent.mm.kernel.g.aAf().azk();
            if (fob().Fmf == null) {
                fob().Fmf = new g(getDataDB());
            }
            g gVar = fob().Fmf;
            if (gVar == null) {
                p.hyc();
            }
            AppMethodBeat.o(118688);
            return gVar;
        }

        public static m foe() {
            AppMethodBeat.i(118689);
            com.tencent.mm.kernel.g.aAf().azk();
            if (fob().Fmg == null) {
                fob().Fmg = new m(getDataDB());
            }
            m mVar = fob().Fmg;
            if (mVar == null) {
                p.hyc();
            }
            AppMethodBeat.o(118689);
            return mVar;
        }

        public static com.tencent.mm.plugin.story.i.b fof() {
            AppMethodBeat.i(118690);
            com.tencent.mm.kernel.g.aAf().azk();
            if (fob().Fmh == null) {
                fob().Fmh = new com.tencent.mm.plugin.story.i.b(getDataDB());
            }
            com.tencent.mm.plugin.story.i.b bVar = fob().Fmh;
            if (bVar == null) {
                p.hyc();
            }
            AppMethodBeat.o(118690);
            return bVar;
        }

        public static com.tencent.mm.plugin.story.i.o fog() {
            AppMethodBeat.i(118691);
            com.tencent.mm.kernel.g.aAf().azk();
            if (fob().Fmi == null) {
                fob().Fmi = new com.tencent.mm.plugin.story.i.o(getDataDB());
            }
            com.tencent.mm.plugin.story.i.o oVar = fob().Fmi;
            if (oVar == null) {
                p.hyc();
            }
            AppMethodBeat.o(118691);
            return oVar;
        }

        public static i foh() {
            AppMethodBeat.i(118692);
            com.tencent.mm.kernel.g.aAf().azk();
            if (fob().Fmj == null) {
                fob().Fmj = new i(getDataDB());
            }
            i iVar = fob().Fmj;
            if (iVar == null) {
                p.hyc();
            }
            AppMethodBeat.o(118692);
            return iVar;
        }

        public static MMHandler eJP() {
            AppMethodBeat.i(118693);
            MMHandlerThread aAk = com.tencent.mm.kernel.g.aAk();
            p.g(aAk, "MMKernel.getPizzaWorkerThread()");
            MMHandler workerHandler = aAk.getWorkerHandler();
            p.g(workerHandler, "MMKernel.getPizzaWorkerThread().workerHandler");
            AppMethodBeat.o(118693);
            return workerHandler;
        }

        public static com.tencent.mm.plugin.story.f.g.c foi() {
            AppMethodBeat.i(118694);
            com.tencent.mm.kernel.g.aAf().azk();
            if (fob().Fmk == null) {
                fob().Fmk = new com.tencent.mm.plugin.story.f.g.c();
            }
            com.tencent.mm.plugin.story.f.g.c cVar = fob().Fmk;
            if (cVar == null) {
                p.hyc();
            }
            AppMethodBeat.o(118694);
            return cVar;
        }

        public static e foj() {
            AppMethodBeat.i(118695);
            com.tencent.mm.kernel.g.aAf().azk();
            if (fob().Fml == null) {
                j fob = fob();
                StringBuilder sb = new StringBuilder();
                com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                p.g(aAh, "MMKernel.storage()");
                StringBuilder append = sb.append(aAh.azM());
                e.a aVar = e.FlV;
                fob.Fml = new e(append.append(e.fnM()).toString());
            }
            e eVar = fob().Fml;
            if (eVar == null) {
                p.hyc();
            }
            AppMethodBeat.o(118695);
            return eVar;
        }

        public static com.tencent.mm.loader.d<com.tencent.mm.plugin.story.f.c.d> fok() {
            AppMethodBeat.i(118696);
            com.tencent.mm.kernel.g.aAf().azk();
            if (fob().Fmm == null) {
                fob().Fmm = new com.tencent.mm.plugin.story.f.c.e();
            }
            com.tencent.mm.plugin.story.f.c.e eVar = fob().Fmm;
            if (eVar == null) {
                p.hyc();
            }
            com.tencent.mm.loader.d<com.tencent.mm.plugin.story.f.c.d> dVar = eVar.FoE;
            AppMethodBeat.o(118696);
            return dVar;
        }

        public static com.tencent.mm.loader.c.e a(com.tencent.mm.plugin.story.f.c.a aVar) {
            AppMethodBeat.i(118697);
            p.h(aVar, "scene");
            com.tencent.mm.kernel.g.aAf().azk();
            if (fob().Fmm == null) {
                fob().Fmm = new com.tencent.mm.plugin.story.f.c.e();
            }
            com.tencent.mm.plugin.story.f.c.e eVar = fob().Fmm;
            if (eVar == null) {
                p.hyc();
            }
            p.h(aVar, "scene");
            switch (com.tencent.mm.plugin.story.f.c.f.$EnumSwitchMapping$0[aVar.ordinal()]) {
                case 1:
                case 2:
                    com.tencent.mm.loader.c.e eVar2 = eVar.FoH;
                    AppMethodBeat.o(118697);
                    return eVar2;
                case 3:
                    com.tencent.mm.loader.c.e eVar3 = eVar.FoG;
                    AppMethodBeat.o(118697);
                    return eVar3;
                default:
                    kotlin.m mVar = new kotlin.m();
                    AppMethodBeat.o(118697);
                    throw mVar;
            }
        }

        public static o.a fol() {
            AppMethodBeat.i(118698);
            com.tencent.mm.kernel.g.aAf().azk();
            if (fob().Fmn == null) {
                fob().Fmn = new o.a();
            }
            o.a aVar = fob().Fmn;
            if (aVar == null) {
                p.hyc();
            }
            AppMethodBeat.o(118698);
            return aVar;
        }

        public static boolean isInValid() {
            AppMethodBeat.i(118699);
            fob();
            if (!j.isValid()) {
                AppMethodBeat.o(118699);
                return true;
            }
            AppMethodBeat.o(118699);
            return false;
        }

        public static String fau() {
            AppMethodBeat.i(118700);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            String str = (String) aAh.azQ().get(2);
            if (str == null) {
                Log.i(j.TAG, "error getSelfName " + Util.getStack());
            }
            if (str == null) {
                str = "";
            }
            AppMethodBeat.o(118700);
            return str;
        }

        public static String getAccStoryPath() {
            AppMethodBeat.i(118701);
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class);
            p.g(ah, "plugin<IPluginStory>(IPluginStory::class.java)");
            String accStoryPath = ((com.tencent.mm.plugin.story.api.e) ah).getAccStoryPath();
            p.g(accStoryPath, "plugin<IPluginStory>(IPl…:class.java).accStoryPath");
            AppMethodBeat.o(118701);
            return accStoryPath;
        }

        public static String getAccStoryCachePath() {
            AppMethodBeat.i(118702);
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class);
            p.g(ah, "plugin<IPluginStory>(IPluginStory::class.java)");
            String accStoryCachePath = ((com.tencent.mm.plugin.story.api.e) ah).getAccStoryCachePath();
            p.g(accStoryCachePath, "plugin<IPluginStory>(IPl…s.java).accStoryCachePath");
            AppMethodBeat.o(118702);
            return accStoryCachePath;
        }

        public static g.a fom() {
            AppMethodBeat.i(118703);
            g.a aVar = (g.a) com.tencent.mm.plugin.story.c.a.g.Fls.aLT();
            AppMethodBeat.o(118703);
            return aVar;
        }

        static void fon() {
            int i2;
            boolean z;
            AppMethodBeat.i(118704);
            j.Fmv = true;
            int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_story_open, 1);
            Log.d(j.TAG, "loadStoryCheck %s local_debug %s", Integer.valueOf(a2), Boolean.FALSE);
            com.tencent.mm.storage.c Fu = com.tencent.mm.model.c.d.aXu().Fu("100481");
            p.g(Fu, "abTestItem");
            if (!Fu.isValid() || !p.j("1", Fu.gzz().get(WeChatBrands.Business.GROUP_OPEN))) {
                i2 = a2;
            } else {
                i2 = 1;
            }
            if (i2 == 1) {
                z = true;
            } else {
                z = false;
            }
            j.Fmw = z;
            AppMethodBeat.o(118704);
        }

        public static boolean foo() {
            AppMethodBeat.i(118705);
            if (com.tencent.mm.plugin.textstatus.a.p.fvC()) {
                AppMethodBeat.o(118705);
                return false;
            }
            if (!j.Fmv) {
                fon();
            }
            boolean z = j.Fmw;
            AppMethodBeat.o(118705);
            return z;
        }

        public static long fop() {
            AppMethodBeat.i(118706);
            if (j.Fmx == -1) {
                com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                p.g(aAh, "MMKernel.storage()");
                j.Fmx = aAh.azQ().a(ar.a.USERINFO_STORY_SNS_ALL_READ_TIME_LONG, 0);
            }
            long j2 = j.Fmx;
            AppMethodBeat.o(118706);
            return j2;
        }
    }

    static {
        AppMethodBeat.i(118713);
        AppMethodBeat.o(118713);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/model/StoryCore$Companion$exptChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "callback", "", "event", "plugin-story_release"})
    public static final class c extends IListener<fp> {
        c() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(fp fpVar) {
            AppMethodBeat.i(118684);
            b bVar = j.Fmy;
            b.fon();
            AppMethodBeat.o(118684);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/story/model/StoryCore$ConfigChangedListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/DynamicConfigUpdatedEvent;", "(Lcom/tencent/mm/plugin/story/model/StoryCore;)V", "callback", "", "event", "plugin-story_release"})
    public final class d extends IListener<df> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public d() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(df dfVar) {
            AppMethodBeat.i(118707);
            Log.i(j.TAG, "dynamicCfg changed, will loadConfig.");
            j.fnW();
            AppMethodBeat.o(118707);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/story/model/StoryCore$AppForegroundListener;", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "(Lcom/tencent/mm/plugin/story/model/StoryCore;)V", "onAppBackground", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "", "onAppForeground", "plugin-story_release"})
    public final class a extends o.a {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(118682);
            xc xcVar = new xc();
            xcVar.edy.state = 1;
            EventCenter.instance.publish(xcVar);
            AppMethodBeat.o(118682);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(118683);
            xc xcVar = new xc();
            xcVar.edy.state = 0;
            EventCenter.instance.publish(xcVar);
            AppMethodBeat.o(118683);
        }
    }

    public static final /* synthetic */ void fnW() {
        com.tencent.mm.plugin.story.c.a.a aVar = com.tencent.mm.plugin.story.c.a.a.FkW;
        com.tencent.mm.plugin.story.c.a.b bVar = com.tencent.mm.plugin.story.c.a.b.FkY;
        com.tencent.mm.plugin.story.c.a.c cVar = com.tencent.mm.plugin.story.c.a.c.FkZ;
        com.tencent.mm.plugin.story.c.a.d dVar = com.tencent.mm.plugin.story.c.a.d.Flc;
        com.tencent.mm.plugin.story.c.a.f fVar = com.tencent.mm.plugin.story.c.a.f.Flq;
        com.tencent.mm.plugin.story.c.a.g gVar = com.tencent.mm.plugin.story.c.a.g.Fls;
    }

    public static final /* synthetic */ void e(j jVar) {
        AppMethodBeat.i(118714);
        if (jVar.hqK == null) {
            jVar.hqK = new h();
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            String str = aAh.azM() + "StoryMicroMsg.db";
            h hVar = jVar.hqK;
            if (hVar == null) {
                p.hyc();
            }
            if (!hVar.a(str, jVar.Fmd, true)) {
                fax();
            }
        }
        AppMethodBeat.o(118714);
    }
}
