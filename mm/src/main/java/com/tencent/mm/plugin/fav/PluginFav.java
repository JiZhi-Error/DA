package com.tencent.mm.plugin.fav;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.wr;
import com.tencent.mm.g.c.ih;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.aa;
import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.ai;
import com.tencent.mm.plugin.fav.a.l;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.a.s;
import com.tencent.mm.plugin.fav.a.t;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.b.e.d;
import com.tencent.mm.plugin.fav.b.e.e;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.protocal.protobuf.amr;
import com.tencent.mm.protocal.protobuf.ane;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import com.tencent.wxmm.v2helper;
import java.util.List;

public class PluginFav extends f implements b, c, af {
    private o.a appForegroundListener = new o.a() {
        /* class com.tencent.mm.plugin.fav.PluginFav.AnonymousClass5 */

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(101537);
            if (g.aAc() && g.aAf().hpY) {
                g.aAf();
                if (!a.azj()) {
                    EventCenter.instance.publish(new wr());
                }
            }
            AppMethodBeat.o(101537);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(101538);
            if (g.aAc() && g.aAf().hpY) {
                g.aAf();
                a.azj();
            }
            AppMethodBeat.o(101538);
        }
    };
    private s sZA;
    private l sZB;
    private final int sZC = 26214400;
    private final int sZD = 25;
    private e sZE;
    private d sZF;
    private com.tencent.mm.plugin.fav.b.e.a sZG;
    private com.tencent.mm.plugin.fav.b.e.b sZH;
    private com.tencent.mm.plugin.fav.b.e.c sZI;
    private com.tencent.mm.plugin.fav.b.b.a sZJ = new com.tencent.mm.plugin.fav.b.b.a();
    private com.tencent.mm.plugin.fav.b.b.b sZK = new com.tencent.mm.plugin.fav.b.b.b();
    private IListener sZL = new IListener<wr>() {
        /* class com.tencent.mm.plugin.fav.PluginFav.AnonymousClass4 */

        {
            AppMethodBeat.i(161111);
            this.__eventId = wr.class.getName().hashCode();
            AppMethodBeat.o(161111);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(wr wrVar) {
            AppMethodBeat.i(101536);
            Log.i("MicroMsg.Fav.PluginFav", "runService");
            if (PluginFav.this.sZH != null) {
                PluginFav.this.sZH.run();
            }
            if (PluginFav.this.sZG != null) {
                PluginFav.this.sZG.run();
            }
            if (PluginFav.this.sZE != null) {
                PluginFav.this.sZE.run();
            }
            if (PluginFav.this.sZF != null) {
                PluginFav.this.sZF.run();
            }
            if (PluginFav.this.sZI != null) {
                PluginFav.this.sZI.run();
            }
            AppMethodBeat.o(101536);
            return false;
        }
    };
    private a sZv;
    private x sZw;
    private q sZx;
    private aa sZy;
    private t sZz;

    public PluginFav() {
        AppMethodBeat.i(101539);
        AppMethodBeat.o(101539);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(198780);
        y.a("favorite", "favorite", TPAudioFrame.TP_CH_STEREO_LEFT, 7776000000L, 3);
        AppMethodBeat.o(198780);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(com.tencent.mm.kernel.b.g gVar) {
    }

    @Override // com.tencent.mm.kernel.a.b.b
    public void parallelsDependency() {
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(101540);
        this.sZv = new a();
        ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("uploadfavitem", this.sZv);
        ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("resendfavitem", this.sZv);
        this.sZw = new com.tencent.mm.plugin.fav.b.f.d(ih.ajW());
        this.sZx = new com.tencent.mm.plugin.fav.b.f.a(ih.ajW());
        this.sZy = new com.tencent.mm.plugin.fav.b.f.e(ih.ajW());
        this.sZz = new com.tencent.mm.plugin.fav.b.f.c(ih.ajW());
        this.sZA = new com.tencent.mm.plugin.fav.b.f.b(ih.ajW());
        this.sZE = new com.tencent.mm.plugin.fav.b.e.e();
        this.sZF = new d();
        this.sZG = new com.tencent.mm.plugin.fav.b.e.a();
        this.sZH = new com.tencent.mm.plugin.fav.b.e.b();
        this.sZI = new com.tencent.mm.plugin.fav.b.e.c();
        this.sZB = new l();
        Log.i("MicroMsg.Fav.PluginFav", "init fav storage");
        ((n) g.ah(n.class)).getFTSTaskDaemon().a(-86016, new com.tencent.mm.plugin.fts.a.a.a() {
            /* class com.tencent.mm.plugin.fav.PluginFav.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.fts.a.a.a
            public final boolean execute() {
                AppMethodBeat.i(101533);
                com.tencent.mm.plugin.fav.b.a.a aVar = new com.tencent.mm.plugin.fav.b.a.a();
                ((n) g.ah(n.class)).registerIndexStorage(aVar);
                aVar.create();
                com.tencent.mm.plugin.fav.b.a.b bVar = new com.tencent.mm.plugin.fav.b.a.b();
                ((n) g.ah(n.class)).registerNativeLogic(6, bVar);
                bVar.create();
                AppMethodBeat.o(101533);
                return true;
            }

            @Override // com.tencent.mm.plugin.fts.a.a.a
            public final String getName() {
                return "InitFTSFavPluginTask";
            }
        });
        this.sZL.alive();
        this.sZJ.alive();
        this.appForegroundListener.alive();
        this.sZK.alive();
        checkDir();
        AppMethodBeat.o(101540);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(101541);
        this.sZL.dead();
        this.sZJ.dead();
        this.sZK.dead();
        this.appForegroundListener.dead();
        ai.cVb();
        ((n) g.ah(n.class)).unregisterIndexStorage(256);
        ((n) g.ah(n.class)).unregisterNativeLogic(6);
        ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("uploadfavitem", this.sZv);
        ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("resendfavitem", this.sZv);
        this.sZv = null;
        if (this.sZE != null) {
            com.tencent.mm.plugin.fav.b.e.e eVar = this.sZE;
            Log.i("MicroMsg.Fav.FavSendService", "stop");
            eVar.aax();
            eVar.dAJ.stopTimer();
            eVar.dAF = 0;
            g.azz().b(401, eVar);
            this.sZE = null;
        }
        if (this.sZF != null) {
            d dVar = this.sZF;
            Log.i("MicroMsg.Fav.FavModService", "stop");
            dVar.aax();
            dVar.dAJ.stopTimer();
            dVar.dAF = 0;
            g.azz().b(v2helper.EMethodSetAgcRxOn, dVar);
            this.sZF = null;
        }
        if (this.sZG != null) {
            com.tencent.mm.plugin.fav.b.e.a aVar = this.sZG;
            aVar.aax();
            aVar.dAJ.stopTimer();
            aVar.dAF = 0;
            g.aAi();
            g.aAg().b(aVar.iRt);
            this.sZG = null;
        }
        if (this.sZH != null) {
            com.tencent.mm.plugin.fav.b.e.b bVar = this.sZH;
            Log.i("MicroMsg.Fav.FavCheckCdnService", "stop");
            bVar.aax();
            bVar.dAJ.stopTimer();
            g.azz().b(404, bVar);
            g.aAg().b(bVar.iRt);
            this.sZH = null;
        }
        if (this.sZI != null) {
            com.tencent.mm.plugin.fav.b.e.c cVar = this.sZI;
            Log.i("MicroMsg.Fav.FavEditService", "stop");
            g.azz().b(v2helper.EMethodSetAgcRxOn, cVar);
            g.azz().b(401, cVar);
            cVar.tco.clear();
            this.sZI = null;
        }
        this.sZw = null;
        this.sZx = null;
        this.sZy = null;
        this.sZz = null;
        this.sZA = null;
        this.sZB = null;
        Log.i("MicroMsg.Fav.PluginFav", "release fav storage");
        AppMethodBeat.o(101541);
    }

    @Override // com.tencent.mm.plugin.fav.a.af
    public void checkFavItem(List<amr> list) {
        AppMethodBeat.i(101542);
        final com.tencent.mm.plugin.fav.b.d.a aVar = new com.tencent.mm.plugin.fav.b.d.a(list);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.fav.PluginFav.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(101534);
                g.azz().a(aVar, 0);
                AppMethodBeat.o(101534);
            }
        });
        AppMethodBeat.o(101542);
    }

    @Override // com.tencent.mm.plugin.fav.a.af
    public void checkFavItem(ane ane) {
        AppMethodBeat.i(101543);
        final com.tencent.mm.plugin.fav.b.d.a aVar = new com.tencent.mm.plugin.fav.b.d.a(ane);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.fav.PluginFav.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(101535);
                g.azz().a(aVar, 0);
                AppMethodBeat.o(101535);
            }
        });
        AppMethodBeat.o(101543);
    }

    @Override // com.tencent.mm.plugin.fav.a.af
    public x getFavItemInfoStorage() {
        return this.sZw;
    }

    @Override // com.tencent.mm.plugin.fav.a.af
    public q getFavCdnStorage() {
        return this.sZx;
    }

    @Override // com.tencent.mm.plugin.fav.a.af
    public s getFavConfigStorage() {
        return this.sZA;
    }

    @Override // com.tencent.mm.plugin.fav.a.af
    public t getFavEditInfoStorage() {
        return this.sZz;
    }

    @Override // com.tencent.mm.plugin.fav.a.af
    public aa getFavSearchStorage() {
        return this.sZy;
    }

    @Override // com.tencent.mm.plugin.fav.a.af
    public l getFavTagSetMgr() {
        return this.sZB;
    }

    @Override // com.tencent.mm.plugin.fav.a.af
    public int getFileSizeLimit(boolean z) {
        AppMethodBeat.i(101544);
        int aqs = com.tencent.mm.n.c.aqs();
        AppMethodBeat.o(101544);
        return aqs;
    }

    @Override // com.tencent.mm.plugin.fav.a.af
    public int getFileSizeLimitInMB(boolean z) {
        AppMethodBeat.i(101545);
        int fileSizeLimit = (getFileSizeLimit(z) / 1024) / 1024;
        AppMethodBeat.o(101545);
        return fileSizeLimit;
    }

    @Override // com.tencent.mm.plugin.fav.a.af
    public int getVideoSizeLimit(boolean z) {
        AppMethodBeat.i(101546);
        if (z) {
            try {
                String value = ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("InputLimitFavVideoSize");
                if (Util.isNullOrNil(value)) {
                    Log.i("MicroMsg.Fav.PluginFav", "getVideoSizeLimit nullOrNil");
                } else {
                    Log.i("MicroMsg.Fav.PluginFav", "getVideoSizeLimit ".concat(String.valueOf(value)));
                }
                int i2 = Util.getInt(value, 26214400);
                AppMethodBeat.o(101546);
                return i2;
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.Fav.PluginFav", th, "getVideoSizeLimit", new Object[0]);
            }
        }
        AppMethodBeat.o(101546);
        return 26214400;
    }

    @Override // com.tencent.mm.plugin.fav.a.af
    public int getVideoSizeLimitInMB(boolean z) {
        AppMethodBeat.i(101547);
        if (z) {
            try {
                String value = ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("InputLimitFavVideoSize");
                if (Util.isNullOrNil(value)) {
                    Log.i("MicroMsg.Fav.PluginFav", "getVideoSizeLimit nullOrNil");
                } else {
                    Log.i("MicroMsg.Fav.PluginFav", "getVideoSizeLimit ".concat(String.valueOf(value)));
                }
                int i2 = (Util.getInt(value, 26214400) / 1024) / 1024;
                AppMethodBeat.o(101547);
                return i2;
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.Fav.PluginFav", th, "getVideoSizeLimitInMB", new Object[0]);
            }
        }
        AppMethodBeat.o(101547);
        return 25;
    }

    public int getImageSizeLimit(boolean z) {
        AppMethodBeat.i(101548);
        if (z) {
            try {
                String value = ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("InputLimitFavImageSize");
                if (Util.isNullOrNil(value)) {
                    Log.i("MicroMsg.Fav.PluginFav", "getImageSizeLimit nullOrNil");
                } else {
                    Log.i("MicroMsg.Fav.PluginFav", "getImageSizeLimit ".concat(String.valueOf(value)));
                }
                int i2 = Util.getInt(value, 26214400);
                AppMethodBeat.o(101548);
                return i2;
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.Fav.PluginFav", th, "getImageSizeLimit", new Object[0]);
            }
        }
        AppMethodBeat.o(101548);
        return 26214400;
    }

    @Override // com.tencent.mm.plugin.fav.a.af
    public int getImageSizeLimitInMB(boolean z) {
        AppMethodBeat.i(101549);
        if (z) {
            try {
                String value = ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("InputLimitFavImageSize");
                if (Util.isNullOrNil(value)) {
                    Log.i("MicroMsg.Fav.PluginFav", "getImageSizeLimitInMB nullOrNil");
                } else {
                    Log.i("MicroMsg.Fav.PluginFav", "getImageSizeLimitInMB ".concat(String.valueOf(value)));
                }
                int i2 = (Util.getInt(value, 26214400) / 1024) / 1024;
                AppMethodBeat.o(101549);
                return i2;
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.Fav.PluginFav", th, "getImageSizeLimitInMB", new Object[0]);
            }
        }
        AppMethodBeat.o(101549);
        return 25;
    }

    @Override // com.tencent.mm.plugin.fav.a.af
    public int getFavSizeLimit(boolean z, int i2) {
        AppMethodBeat.i(101550);
        if (i2 == 2) {
            int imageSizeLimit = getImageSizeLimit(z);
            AppMethodBeat.o(101550);
            return imageSizeLimit;
        } else if (i2 == 4) {
            int videoSizeLimit = getVideoSizeLimit(z);
            AppMethodBeat.o(101550);
            return videoSizeLimit;
        } else {
            int fileSizeLimit = getFileSizeLimit(z);
            AppMethodBeat.o(101550);
            return fileSizeLimit;
        }
    }

    @Override // com.tencent.mm.plugin.fav.a.af
    public int getFavSizeLimitInMB(boolean z, int i2) {
        AppMethodBeat.i(101551);
        if (i2 == 2) {
            int imageSizeLimitInMB = getImageSizeLimitInMB(z);
            AppMethodBeat.o(101551);
            return imageSizeLimitInMB;
        } else if (i2 == 4) {
            int videoSizeLimitInMB = getVideoSizeLimitInMB(z);
            AppMethodBeat.o(101551);
            return videoSizeLimitInMB;
        } else {
            int fileSizeLimitInMB = getFileSizeLimitInMB(z);
            AppMethodBeat.o(101551);
            return fileSizeLimitInMB;
        }
    }

    @Override // com.tencent.mm.plugin.fav.a.af
    public ac getSendService() {
        return this.sZE;
    }

    @Override // com.tencent.mm.plugin.fav.a.af
    public d getModService() {
        return this.sZF;
    }

    @Override // com.tencent.mm.plugin.fav.a.af
    public com.tencent.mm.plugin.fav.b.e.a getFavCdnService() {
        return this.sZG;
    }

    @Override // com.tencent.mm.plugin.fav.a.af
    public com.tencent.mm.plugin.fav.b.e.b getCheckCdnService() {
        return this.sZH;
    }

    @Override // com.tencent.mm.plugin.fav.a.af
    public com.tencent.mm.plugin.fav.b.e.c getEditService() {
        return this.sZI;
    }

    private static void checkDir() {
        AppMethodBeat.i(101552);
        com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(com.tencent.mm.plugin.fav.a.b.cUm());
        if (!oVar.exists() || !oVar.isDirectory()) {
            Log.i("MicroMsg.Fav.PluginFav", "fav root dir not exists, try to make it");
            oVar.mkdirs();
        }
        com.tencent.mm.vfs.o oVar2 = new com.tencent.mm.vfs.o(com.tencent.mm.plugin.fav.a.b.cUf());
        if (!oVar2.exists() || !oVar2.isDirectory()) {
            Log.i("MicroMsg.Fav.PluginFav", "fav web dir not exists, try to make it");
            oVar2.mkdirs();
        }
        com.tencent.mm.vfs.o oVar3 = new com.tencent.mm.vfs.o(com.tencent.mm.plugin.fav.a.b.cUl());
        if (!oVar3.exists() || !oVar3.isDirectory()) {
            Log.i("MicroMsg.Fav.PluginFav", "fav attach dir not exists, try to make it");
            oVar3.mkdirs();
        }
        com.tencent.mm.vfs.o oVar4 = new com.tencent.mm.vfs.o(com.tencent.mm.plugin.fav.a.b.cUn());
        if (!oVar4.exists() || !oVar4.isDirectory()) {
            Log.i("MicroMsg.Fav.PluginFav", "fav voice dir not exists, try to make it");
            oVar4.mkdirs();
        }
        AppMethodBeat.o(101552);
    }
}
