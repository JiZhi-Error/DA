package com.tencent.mm.plugin.music.e;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.d;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.model.b.c;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.plugin.music.model.notification.MMMusicPlayerService;
import com.tencent.mm.plugin.music.model.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bth;
import com.tencent.mm.protocal.protobuf.zb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class m extends g implements i, e {
    private int AjF;
    private List<String> AjG = new ArrayList();
    private com.tencent.mm.plugin.music.model.notification.b AjH = new com.tencent.mm.plugin.music.model.notification.b();
    private com.tencent.mm.plugin.music.model.b.b AjI;
    private com.tencent.mm.plugin.music.model.b.a AjJ;
    private c AjK;
    private boolean AjL;
    private Object lockObj = new Object();
    private int mode = 1;

    public m() {
        AppMethodBeat.i(62966);
        AppMethodBeat.o(62966);
    }

    @Override // com.tencent.mm.plugin.music.e.g, com.tencent.mm.plugin.music.e.a
    public final void init() {
        AppMethodBeat.i(62967);
        super.init();
        g.aAg().hqi.a(520, this);
        g.aAg().hqi.a(769, this);
        com.tencent.mm.plugin.music.model.notification.b bVar = this.AjH;
        Log.i("MicroMsg.Music.MMMusicNotificationHelper", "initMusicPlayerService");
        bVar.lEl = new IListener<mx>() {
            /* class com.tencent.mm.plugin.music.model.notification.b.AnonymousClass1 */

            {
                AppMethodBeat.i(160407);
                this.__eventId = mx.class.getName().hashCode();
                AppMethodBeat.o(160407);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(mx mxVar) {
                AppMethodBeat.i(63117);
                mx mxVar2 = mxVar;
                if (b.this.AkZ != null) {
                    Log.i("MicroMsg.Music.MMMusicNotificationHelper", "event.data.action:%d", Integer.valueOf(mxVar2.dSE.action));
                    switch (mxVar2.dSE.action) {
                        case 0:
                        case 1:
                        case 11:
                            if (b.this.AkZ != null) {
                                a etY = ((e) com.tencent.mm.plugin.music.f.c.b.aS(e.class)).etY();
                                if (etY != null) {
                                    b.this.AkZ.d(etY);
                                    break;
                                } else {
                                    Log.e("MicroMsg.Music.MMMusicNotificationHelper", "music is null, return");
                                    break;
                                }
                            }
                            break;
                        case 2:
                            if (b.this.AkZ != null && !mxVar2.dSE.dSH) {
                                b.this.AkZ.stop();
                                break;
                            }
                        case 3:
                            if (b.this.AkZ != null) {
                                a etY2 = ((e) com.tencent.mm.plugin.music.f.c.b.aS(e.class)).etY();
                                if (etY2 != null) {
                                    b.this.AkZ.e(etY2);
                                    break;
                                } else {
                                    Log.e("MicroMsg.Music.MMMusicNotificationHelper", "music is null, return");
                                    break;
                                }
                            }
                            break;
                        case 4:
                            if (b.this.AkZ != null) {
                                b.this.AkZ.stop();
                                break;
                            }
                            break;
                        case 7:
                            List<String> eua = ((e) com.tencent.mm.plugin.music.f.c.b.aS(e.class)).eua();
                            int eue = ((e) com.tencent.mm.plugin.music.f.c.b.aS(e.class)).eue();
                            if (((eua != null && eua.size() - 1 == eue) || ((e) com.tencent.mm.plugin.music.f.c.b.aS(e.class)).getMode() == 1) && b.this.AkZ != null) {
                                MMMusicPlayerService mMMusicPlayerService = b.this.AkZ;
                                Log.i("MicroMsg.Music.MMMusicPlayerService", "end");
                                a aVar = mMMusicPlayerService.Alg;
                                if (!aVar.isInit) {
                                    Log.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, close err");
                                } else if (aVar.AkZ == null) {
                                    Log.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
                                } else {
                                    Log.i("MicroMsg.Music.MMMusicNotification", "end");
                                    MMHandlerThread.removeRunnable(aVar.Alb);
                                    MMHandlerThread.postToMainThreadDelayed(aVar.Alb, 2000);
                                }
                                MMHandlerThread.removeRunnable(mMMusicPlayerService.Alh);
                                MMHandlerThread.postToMainThreadDelayed(mMMusicPlayerService.Alh, Util.MILLSECONDS_OF_MINUTE);
                                break;
                            }
                    }
                } else {
                    b.this.euJ();
                }
                AppMethodBeat.o(63117);
                return false;
            }
        };
        bVar.lEl.alive();
        AppMethodBeat.o(62967);
    }

    @Override // com.tencent.mm.plugin.music.e.a
    public final void release() {
        AppMethodBeat.i(62968);
        this.AjG.clear();
        g.aAg().hqi.b(520, this);
        g.aAg().hqi.b(940, this);
        g.aAg().hqi.b(769, this);
        com.tencent.mm.plugin.music.model.notification.b bVar = this.AjH;
        Log.i("MicroMsg.Music.MMMusicNotificationHelper", "uninitMusicPlayerService");
        Intent intent = new Intent();
        intent.setClass(MMApplicationContext.getContext(), MMMusicPlayerService.class);
        MMApplicationContext.getContext().stopService(intent);
        bVar.AkZ = null;
        bVar.lEl.dead();
        AppMethodBeat.o(62968);
    }

    @Override // com.tencent.mm.plugin.music.e.g, com.tencent.mm.plugin.music.e.a
    public final boolean i(f fVar) {
        AppMethodBeat.i(62969);
        if (fVar == null) {
            Log.e("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper is false, do not start music");
            AppMethodBeat.o(62969);
            return false;
        }
        com.tencent.mm.plugin.music.model.e.a etY = etY();
        if (etY == null || !com.tencent.mm.plugin.music.model.m.b(etY)) {
            Log.e("MicroMsg.Music.MusicWechatPrivateLogic", "music or url is null, do not start music");
            this.Ajw.u(fVar);
            AppMethodBeat.o(62969);
            return false;
        } else if (etY.field_isBlock == 1) {
            Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "not play music, music is block %s", etY.field_musicId);
            this.Ajw.u(fVar);
            com.tencent.mm.plugin.music.model.d.e.a(fVar, true);
            AppMethodBeat.o(62969);
            return false;
        } else {
            Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicType %d", Integer.valueOf(etY.field_musicType));
            Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "music protocol:%s", etY.field_protocol);
            etY.playUrl = fVar.playUrl;
            if (this.AjJ != null) {
                g.aAg().hqi.a(this.AjJ);
            }
            g.aAg().hqi.a(940, this);
            this.AjJ = new com.tencent.mm.plugin.music.model.b.a(etY.field_musicType, etY);
            g.aAg().hqi.a(this.AjJ, 0);
            if (com.tencent.mm.plugin.music.model.a.b.c(etY)) {
                Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "get shake music new url to play");
                String str = etY.playUrl;
                if (TextUtils.isEmpty(str)) {
                    Log.e("MicroMsg.Music.MusicWechatPrivateLogic", "GetShakeMusicUrl, url is null");
                } else {
                    if (this.AjK != null) {
                        g.aAg().hqi.a(this.AjK);
                        this.AjK = null;
                    }
                    Log.e("MicroMsg.Music.MusicWechatPrivateLogic", "GetShakeMusicUrl, url is %s", str);
                    this.AjK = new c(str);
                    g.aAg().hqi.a(this.AjK, 0);
                    h.INSTANCE.idkeyStat(558, 213, 1, true);
                }
                AppMethodBeat.o(62969);
                return false;
            }
            AppMethodBeat.o(62969);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.music.e.g, com.tencent.mm.plugin.music.e.a
    public final f j(f fVar) {
        boolean z;
        AppMethodBeat.i(62970);
        String S = com.tencent.mm.plugin.music.h.b.S(fVar);
        synchronized (this.lockObj) {
            try {
                if (this.AjG != null) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= this.AjG.size()) {
                            z = false;
                            break;
                        } else if (S.equals(this.AjG.get(i2))) {
                            this.AjF = i2;
                            z = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (this.AjG.size() > 1 && fVar.jfq) {
                        this.mode = 2;
                    }
                } else {
                    z = false;
                }
            } finally {
                AppMethodBeat.o(62970);
            }
        }
        if (z) {
            fVar = etU();
        } else {
            synchronized (this.lockObj) {
                try {
                    this.AjG.clear();
                    this.AjG.add(com.tencent.mm.plugin.music.h.b.S(fVar));
                } finally {
                    AppMethodBeat.o(62970);
                }
            }
            this.AjF = 0;
            o.euD().F(fVar);
            if (this.mode == 2) {
                eum();
            }
        }
        return fVar;
    }

    @Override // com.tencent.mm.plugin.music.e.g, com.tencent.mm.plugin.music.e.a
    public final f k(f fVar) {
        AppMethodBeat.i(62971);
        if (fVar == null && this.AjG.size() == 0) {
            Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper is null && musicList's size is 0");
            AppMethodBeat.o(62971);
            return null;
        }
        if (fVar == null) {
            fVar = etU();
        } else {
            synchronized (this.lockObj) {
                try {
                    this.AjG.clear();
                    this.AjG.add(com.tencent.mm.plugin.music.h.b.S(fVar));
                } finally {
                    AppMethodBeat.o(62971);
                }
            }
            this.AjF = 0;
            o.euD().F(fVar);
            if (this.mode == 2) {
                eum();
            }
        }
        return fVar;
    }

    @Override // com.tencent.mm.plugin.music.e.g, com.tencent.mm.plugin.music.e.a
    public final void m(f fVar) {
        AppMethodBeat.i(219816);
        super.m(fVar);
        o.euD().F(fVar);
        AppMethodBeat.o(219816);
    }

    @Override // com.tencent.mm.plugin.music.e.g, com.tencent.mm.plugin.music.e.a
    public final f y(List<f> list, int i2) {
        AppMethodBeat.i(62972);
        if (list == null || list.size() == 0 || i2 >= list.size()) {
            Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "music wrapper list error");
            AppMethodBeat.o(62972);
            return null;
        }
        synchronized (this.lockObj) {
            try {
                this.AjG.clear();
                for (int i3 = 0; i3 < list.size(); i3++) {
                    f fVar = list.get(i3);
                    this.AjG.add(com.tencent.mm.plugin.music.h.b.S(fVar));
                    o.euD().F(fVar);
                }
            } finally {
                AppMethodBeat.o(62972);
            }
        }
        this.AjF = i2;
        this.mode = 2;
        Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "startPlayNewMusicList:%d", Integer.valueOf(this.AjF));
        f etU = etU();
        if (etU.dvv > 0) {
            String S = com.tencent.mm.plugin.music.h.b.S(etU);
            com.tencent.mm.plugin.music.model.e.b euD = o.euD();
            ContentValues contentValues = new ContentValues();
            contentValues.put("startTime", (Integer) 0);
            euD.db.update("Music", contentValues, "musicId=?", new String[]{S});
            com.tencent.mm.plugin.music.model.e.a aVar = euD.AlG.get(S);
            if (aVar != null) {
                aVar.field_startTime = 0;
            }
        }
        return etU;
    }

    @Override // com.tencent.mm.plugin.music.e.g, com.tencent.mm.plugin.music.e.a
    public final void l(f fVar) {
        AppMethodBeat.i(62973);
        if (fVar != null) {
            synchronized (this.lockObj) {
                try {
                    this.AjG.clear();
                    this.AjG.add(com.tencent.mm.plugin.music.h.b.S(fVar));
                } catch (Throwable th) {
                    AppMethodBeat.o(62973);
                    throw th;
                }
            }
            this.AjF = 0;
            o.euD().F(fVar);
            AppMethodBeat.o(62973);
            return;
        }
        Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "shake music item is null");
        AppMethodBeat.o(62973);
    }

    @Override // com.tencent.mm.plugin.music.e.g, com.tencent.mm.plugin.music.e.a
    public final synchronized void i(List<f> list, boolean z) {
        AppMethodBeat.i(62974);
        if (list == null || list.size() == 0) {
            Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "appendMusicList error");
            AppMethodBeat.o(62974);
        } else {
            synchronized (this.lockObj) {
                if (z) {
                    try {
                        this.AjG.clear();
                    } catch (Throwable th) {
                        AppMethodBeat.o(62974);
                        throw th;
                    }
                }
                for (f fVar : list) {
                    this.AjG.add(com.tencent.mm.plugin.music.h.b.S(fVar));
                    o.euD().F(fVar);
                }
            }
            AppMethodBeat.o(62974);
        }
    }

    @Override // com.tencent.mm.plugin.music.e.e
    public final com.tencent.mm.plugin.music.model.e.a aHL(String str) {
        AppMethodBeat.i(62975);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(62975);
            return null;
        }
        com.tencent.mm.plugin.music.model.e.a aHW = o.euD().aHW(str);
        if (aHW != null) {
            this.AjG.add(str);
            Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "getMusicByDBMusicId, music data exist in db , id:%s", str);
        } else {
            Log.e("MicroMsg.Music.MusicWechatPrivateLogic", "getMusicByDBMusicId, music data not exist in db , id:%s", str);
        }
        AppMethodBeat.o(62975);
        return aHW;
    }

    @Override // com.tencent.mm.plugin.music.e.e
    public final List<String> eua() {
        return this.AjG;
    }

    @Override // com.tencent.mm.plugin.music.e.e
    public final com.tencent.mm.plugin.music.model.e.a etY() {
        com.tencent.mm.plugin.music.model.e.a aVar = null;
        AppMethodBeat.i(62976);
        synchronized (this.lockObj) {
            try {
                if (this.AjG.size() != 0) {
                    if (this.AjG.size() <= this.AjF) {
                        AppMethodBeat.o(62976);
                    } else {
                        aVar = o.euD().aHW(this.AjG.get(this.AjF));
                        AppMethodBeat.o(62976);
                    }
                }
            } finally {
                AppMethodBeat.o(62976);
            }
        }
        return aVar;
    }

    @Override // com.tencent.mm.plugin.music.e.g, com.tencent.mm.plugin.music.e.a
    public final f etU() {
        AppMethodBeat.i(62977);
        synchronized (this.lockObj) {
            try {
                if (this.AjG.size() == 0) {
                    return null;
                }
                if (this.AjG.size() <= this.AjF) {
                    AppMethodBeat.o(62977);
                    return null;
                }
                com.tencent.mm.plugin.music.model.e.a aHW = o.euD().aHW(this.AjG.get(this.AjF));
                if (aHW != null) {
                    f euO = aHW.euO();
                    AppMethodBeat.o(62977);
                    return euO;
                }
                AppMethodBeat.o(62977);
                return null;
            } finally {
                AppMethodBeat.o(62977);
            }
        }
    }

    @Override // com.tencent.mm.plugin.music.e.e
    public final boolean etZ() {
        AppMethodBeat.i(62978);
        com.tencent.mm.plugin.music.model.e.a etY = etY();
        if (etY != null) {
            switch (etY.field_musicType) {
                case 1:
                case 4:
                case 6:
                case 8:
                case 9:
                case 10:
                    AppMethodBeat.o(62978);
                    return true;
            }
        }
        AppMethodBeat.o(62978);
        return false;
    }

    @Override // com.tencent.mm.plugin.music.e.e
    public final void eub() {
        this.mode = 1;
    }

    private void eum() {
        AppMethodBeat.i(62980);
        ThreadPool.post(new a(this, (byte) 0), "music_get_list_task");
        AppMethodBeat.o(62980);
    }

    @Override // com.tencent.mm.plugin.music.e.e
    public final int getMode() {
        return this.mode;
    }

    @Override // com.tencent.mm.plugin.music.e.e
    public final void SO(int i2) {
        AppMethodBeat.i(62981);
        if (this.AjG.size() == 0) {
            AppMethodBeat.o(62981);
            return;
        }
        int size = (i2 - 100000) % this.AjG.size();
        if (size < 0) {
            size += this.AjG.size();
        }
        if (size != this.AjF) {
            this.AjF = size;
            this.Ajw.s(null);
        }
        AppMethodBeat.o(62981);
    }

    @Override // com.tencent.mm.plugin.music.e.e
    public final void euc() {
        AppMethodBeat.i(62982);
        if (this.mode == 1) {
            AppMethodBeat.o(62982);
            return;
        }
        this.AjF++;
        this.AjF %= this.AjG.size();
        this.Ajw.sl(true);
        this.Ajw.s(null);
        AppMethodBeat.o(62982);
    }

    @Override // com.tencent.mm.plugin.music.e.e
    public final void eud() {
        AppMethodBeat.i(62983);
        if (this.mode == 1) {
            AppMethodBeat.o(62983);
            return;
        }
        this.AjF = (this.AjF + this.AjG.size()) - 1;
        this.AjF %= this.AjG.size();
        this.Ajw.sl(true);
        this.Ajw.s(null);
        AppMethodBeat.o(62983);
    }

    @Override // com.tencent.mm.plugin.music.e.e
    public final int eue() {
        return this.AjF;
    }

    @Override // com.tencent.mm.plugin.music.e.e
    public final void euf() {
        AppMethodBeat.i(62984);
        if (!this.Ajw.etW().bec()) {
            Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "really exit music");
            this.mode = 1;
        }
        AppMethodBeat.o(62984);
    }

    @Override // com.tencent.mm.plugin.music.e.e
    public final boolean eug() {
        AppMethodBeat.i(62985);
        if (this.AjG.size() <= 0 || this.mode != 2) {
            AppMethodBeat.o(62985);
            return false;
        }
        AppMethodBeat.o(62985);
        return true;
    }

    @Override // com.tencent.mm.plugin.music.e.g, com.tencent.mm.plugin.music.e.a
    public final boolean hWq() {
        AppMethodBeat.i(261717);
        com.tencent.mm.util.c cVar = com.tencent.mm.util.c.QYz;
        if (Util.getInt(com.tencent.mm.util.c.axY(com.tencent.mm.util.c.np("musicplayer", "useQQMusicPlayer")), 0) == 1) {
            AppMethodBeat.o(261717);
            return true;
        }
        AppMethodBeat.o(261717);
        return false;
    }

    @Override // com.tencent.mm.plugin.music.e.g, com.tencent.mm.plugin.music.e.a
    public final String aiK(String str) {
        AppMethodBeat.i(62987);
        String aiK = com.tencent.mm.plugin.music.model.a.b.aiK(str);
        Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "contain shake tag playUrl:%s", aiK);
        String aHS = com.tencent.mm.plugin.music.model.a.b.aHS(aiK);
        AppMethodBeat.o(62987);
        return aHS;
    }

    @Override // com.tencent.mm.plugin.music.e.g, com.tencent.mm.plugin.music.e.a
    public final URL aHK(String str) {
        AppMethodBeat.i(62988);
        URL url = new d.b(str).url;
        AppMethodBeat.o(62988);
        return url;
    }

    @Override // com.tencent.mm.plugin.music.e.g, com.tencent.mm.plugin.music.e.a
    public final void n(f fVar) {
        AppMethodBeat.i(62989);
        super.n(fVar);
        com.tencent.mm.plugin.music.model.d.e.euK();
        com.tencent.mm.plugin.music.model.d.e.iJF = System.currentTimeMillis();
        com.tencent.mm.plugin.music.model.d.e.g(etY());
        AppMethodBeat.o(62989);
    }

    @Override // com.tencent.mm.plugin.music.e.g, com.tencent.mm.plugin.music.e.a
    public final void o(f fVar) {
        AppMethodBeat.i(62990);
        super.o(fVar);
        com.tencent.mm.plugin.music.model.d.e.iJF = System.currentTimeMillis();
        AppMethodBeat.o(62990);
    }

    @Override // com.tencent.mm.plugin.music.e.g, com.tencent.mm.plugin.music.e.a
    public final void p(f fVar) {
        AppMethodBeat.i(62991);
        super.p(fVar);
        com.tencent.mm.plugin.music.model.d.e.bdY();
        AppMethodBeat.o(62991);
    }

    @Override // com.tencent.mm.plugin.music.e.g, com.tencent.mm.plugin.music.e.a
    public final void q(f fVar) {
        AppMethodBeat.i(62992);
        super.q(fVar);
        com.tencent.mm.plugin.music.model.d.e.euK();
        AppMethodBeat.o(62992);
    }

    @Override // com.tencent.mm.plugin.music.e.g, com.tencent.mm.plugin.music.e.a
    public final void r(f fVar) {
        AppMethodBeat.i(62993);
        super.r(fVar);
        com.tencent.mm.plugin.music.model.d.e.euK();
        if (this.mode == 2 && (this.AjF < this.AjG.size() - 1 || fVar.jfq)) {
            mx mxVar = new mx();
            mxVar.dSE.action = 15;
            mxVar.dSE.state = "";
            EventCenter.instance.asyncPublish(mxVar, Looper.getMainLooper());
            euc();
        }
        AppMethodBeat.o(62993);
    }

    @Override // com.tencent.mm.plugin.music.e.g, com.tencent.mm.plugin.music.e.a
    public final void a(f fVar, int i2) {
        AppMethodBeat.i(62994);
        super.a(fVar, i2);
        com.tencent.mm.plugin.music.model.d.e.euK();
        AppMethodBeat.o(62994);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(62995);
        if (qVar instanceof com.tencent.mm.plugin.music.model.b.a) {
            Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "onSceneEnd errCode:%d", Integer.valueOf(i3));
            g.aAg().hqi.b(940, this);
            if (i2 == 4 && i3 == -24) {
                zb zbVar = ((com.tencent.mm.plugin.music.model.b.a) qVar).AkT;
                if (etY() != null && zbVar.jeV.equals(etY().field_musicId)) {
                    this.Ajw.bea();
                }
                com.tencent.mm.plugin.music.model.e.b euD = o.euD();
                String str2 = zbVar.jeV;
                ContentValues contentValues = new ContentValues();
                contentValues.put("isBlock", (Integer) 1);
                euD.db.update("Music", contentValues, "musicId=?", new String[]{str2});
                com.tencent.mm.plugin.music.model.e.a aVar = euD.AlG.get(str2);
                if (aVar != null) {
                    aVar.field_isBlock = 1;
                }
                Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "onSceneEnd music is block %s", etY().field_musicId);
                AppMethodBeat.o(62995);
                return;
            }
        } else if (qVar instanceof com.tencent.mm.plugin.music.model.b.b) {
            if (i2 == 0 && i3 == 0) {
                final com.tencent.mm.plugin.music.model.b.b bVar = (com.tencent.mm.plugin.music.model.b.b) qVar;
                bth bth = bVar.AkU;
                String str3 = bVar.AkC.field_musicId;
                if (bth != null && str3 != null) {
                    Iterator<String> it = this.AjG.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        final String next = it.next();
                        if (next.equals(str3)) {
                            final String b2 = z.b(bth.LZW);
                            final String b3 = z.b(bth.LZX);
                            final String b4 = z.b(bth.LZV);
                            com.tencent.f.h.RTc.aX(new Runnable() {
                                /* class com.tencent.mm.plugin.music.e.m.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(219815);
                                    o.euD().b(next, b2, b3, b4, bVar.AkV, bVar.AkW);
                                    AppMethodBeat.o(219815);
                                }
                            });
                            Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "get response %s %s %s", b2, b3, b4);
                            if (!Util.isNullOrNil(b3)) {
                                mx mxVar = new mx();
                                mxVar.dSE.action = 6;
                                mxVar.dSE.dSF = bVar.AkC.field_musicId;
                                EventCenter.instance.asyncPublish(mxVar, Looper.getMainLooper());
                                AppMethodBeat.o(62995);
                                return;
                            }
                        }
                    }
                }
                AppMethodBeat.o(62995);
                return;
            }
            AppMethodBeat.o(62995);
            return;
        } else if (qVar instanceof c) {
            Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetShakeMusicUrl onSceneEnd errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
            c cVar = (c) qVar;
            Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "getShakeMusicUrlScene callback, playUrl:%s, tempPlayUrl:%s", cVar.playUrl, cVar.AkY);
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.plugin.music.model.a.b.ja(cVar.playUrl, cVar.AkY);
            } else {
                h.INSTANCE.idkeyStat(558, 214, 1, true);
            }
            com.tencent.mm.plugin.music.model.e.a etY = etY();
            if (etY != null && !TextUtils.isEmpty(etY.playUrl) && etY.playUrl.equalsIgnoreCase(cVar.playUrl)) {
                Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "music playUrl is same, start to play shake music");
                this.Ajw.t(etY.euO());
                AppMethodBeat.o(62995);
                return;
            } else if (etY != null) {
                Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "music playUrl is diff, don't play, current playUrl is %s, netscene playUrl is %s", etY.playUrl, cVar.playUrl);
            }
        }
        AppMethodBeat.o(62995);
    }

    @Override // com.tencent.mm.plugin.music.e.e
    public final void a(com.tencent.mm.plugin.music.model.e.a aVar, boolean z, boolean z2) {
        AppMethodBeat.i(219817);
        if (aVar == null) {
            AppMethodBeat.o(219817);
            return;
        }
        if (this.AjI != null) {
            g.aAg().hqi.a(this.AjI);
            this.AjI = null;
        }
        if (aVar.field_songId > 0 || !TextUtils.isEmpty(aVar.field_songMId)) {
            this.AjI = new com.tencent.mm.plugin.music.model.b.b(aVar, z, z2);
            g.aAg().hqi.a(this.AjI, 0);
            AppMethodBeat.o(219817);
            return;
        }
        Log.e("MicroMsg.Music.MusicWechatPrivateLogic", "can't get songId and mid is empty");
        h.INSTANCE.kvStat(10911, "1");
        AppMethodBeat.o(219817);
    }

    /* access modifiers changed from: package-private */
    public class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(m mVar, byte b2) {
            this();
        }

        public final void run() {
            List list;
            AppMethodBeat.i(62964);
            long currentTimeMillis = System.currentTimeMillis();
            m.this.AjL = true;
            f etU = m.this.etU();
            ArrayList arrayList = new ArrayList();
            Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper.MusicType:%d", Integer.valueOf(etU.jeT));
            switch (etU.jeT) {
                case 1:
                    mw mwVar = new mw();
                    mwVar.dSw.action = -5;
                    EventCenter.instance.publish(mwVar);
                    list = mwVar.dSx.dLA;
                    break;
                case 2:
                case 3:
                case 5:
                case 7:
                default:
                    list = null;
                    break;
                case 4:
                    mw mwVar2 = new mw();
                    mwVar2.dSw.action = -4;
                    EventCenter.instance.publish(mwVar2);
                    list = mwVar2.dSx.dLA;
                    break;
                case 6:
                    hb hbVar = new hb();
                    hbVar.dLm.type = 18;
                    EventCenter.instance.publish(hbVar);
                    list = hbVar.dLn.dLA;
                    break;
                case 8:
                    mw mwVar3 = new mw();
                    mwVar3.dSw.action = -6;
                    mwVar3.dSw.dSy = etU;
                    EventCenter.instance.publish(mwVar3);
                    list = mwVar3.dSx.dLA;
                    break;
            }
            if (list != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    f fVar = (f) list.get(i2);
                    if (fVar == null) {
                        Log.e("MicroMsg.Music.MusicWechatPrivateLogic", "wrapper is null, continue");
                    } else {
                        o.euD().F(fVar);
                        arrayList.add(com.tencent.mm.plugin.music.h.b.S(fVar));
                    }
                }
            }
            Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetMusicWrapperListTask run time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            m.this.AjL = false;
            b bVar = new b(m.this, (byte) 0);
            bVar.AjR = arrayList;
            MMHandlerThread.postToMainThread(bVar);
            AppMethodBeat.o(62964);
        }
    }

    class b implements Runnable {
        List<String> AjR;

        private b() {
        }

        /* synthetic */ b(m mVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(62965);
            String S = com.tencent.mm.plugin.music.h.b.S(m.this.etU());
            int i2 = m.this.AjF;
            boolean z = false;
            for (int i3 = 0; i3 < this.AjR.size(); i3++) {
                if (this.AjR.get(i3).equals(S)) {
                    i2 = i3;
                    z = true;
                }
            }
            if (!z) {
                AppMethodBeat.o(62965);
                return;
            }
            synchronized (m.this.lockObj) {
                for (int i4 = i2 + 1; i4 < this.AjR.size(); i4++) {
                    try {
                        m.this.AjG.add(this.AjR.get(i4));
                    } catch (Throwable th) {
                        AppMethodBeat.o(62965);
                        throw th;
                    }
                }
                for (int i5 = 0; i5 < i2; i5++) {
                    m.this.AjG.add(this.AjR.get(i5));
                }
            }
            Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetMusicWrapperListTask currentMusicSize=%d currentMusicIndex=%d", Integer.valueOf(m.this.AjG.size()), Integer.valueOf(m.this.AjF));
            mx mxVar = new mx();
            mxVar.dSE.action = 5;
            EventCenter.instance.publish(mxVar);
            AppMethodBeat.o(62965);
        }
    }

    @Override // com.tencent.mm.plugin.music.e.e
    public final void Pl(int i2) {
        AppMethodBeat.i(62979);
        h.INSTANCE.idkeyStat(285, 2, 1, false);
        if (this.mode != 1) {
            this.mode = 1;
            mx mxVar = new mx();
            mxVar.dSE.action = 5;
            EventCenter.instance.publish(mxVar);
            com.tencent.mm.plugin.music.model.d.e.at(2, 1, i2);
            AppMethodBeat.o(62979);
        } else if (this.AjL) {
            Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "already running get list");
            AppMethodBeat.o(62979);
        } else {
            this.mode = 2;
            if (this.AjG.size() <= 1) {
                eum();
            } else {
                mx mxVar2 = new mx();
                mxVar2.dSE.action = 5;
                EventCenter.instance.publish(mxVar2);
            }
            com.tencent.mm.plugin.music.model.d.e.at(1, 2, i2);
            AppMethodBeat.o(62979);
        }
    }
}
