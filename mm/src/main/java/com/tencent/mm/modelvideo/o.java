package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.an.e;
import com.tencent.mm.an.f;
import com.tencent.mm.app.o;
import com.tencent.mm.blink.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.Iterator;

public class o implements bd {
    private static HashMap<Integer, h.b> baseDBFactories = new HashMap<>();
    private static MMHandler jrW = null;
    private o.a appForegroundListener = new o.a() {
        /* class com.tencent.mm.modelvideo.o.AnonymousClass1 */

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(126925);
            if (g.aAc() && g.aAf().hpY) {
                g.aAf();
                if (!a.azj()) {
                    b.ake().arrange(new Runnable() {
                        /* class com.tencent.mm.modelvideo.o.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(126924);
                            o.bho().run();
                            AppMethodBeat.o(126924);
                        }
                    });
                }
            }
            AppMethodBeat.o(126925);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(126926);
            if (g.aAc() && g.aAf().hpY) {
                g.aAf();
                a.azj();
            }
            AppMethodBeat.o(126926);
        }
    };
    private volatile v jrP = new v();
    private volatile t jrQ;
    private volatile x jrR;
    private volatile y.a jrS = null;
    private volatile l jrT = null;
    private volatile k jrU = null;
    private volatile m jrV = null;
    private e jrX = null;
    private i jrY = null;
    private p jrZ = new p();

    public o() {
        AppMethodBeat.i(126928);
        AppMethodBeat.o(126928);
    }

    static {
        AppMethodBeat.i(126943);
        Iterator<t.c> it = t.d.iYu.iterator();
        while (it.hasNext()) {
            final t.c next = it.next();
            baseDBFactories.put(Integer.valueOf(next.table.hashCode()), new h.b() {
                /* class com.tencent.mm.modelvideo.o.AnonymousClass2 */

                @Override // com.tencent.mm.storagebase.h.b
                public final String[] getSQLs() {
                    return next.iYr;
                }
            });
        }
        baseDBFactories.put(Integer.valueOf("VIDEOPLAYHISTORY_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.modelvideo.o.AnonymousClass3 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return x.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("SIGHTDRAFTSINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.modelvideo.o.AnonymousClass4 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return l.SQL_CREATE;
            }
        });
        AppMethodBeat.o(126943);
    }

    public static o bhi() {
        AppMethodBeat.i(126929);
        o oVar = (o) com.tencent.mm.model.y.at(o.class);
        AppMethodBeat.o(126929);
        return oVar;
    }

    public static synchronized t bhj() {
        t tVar;
        synchronized (o.class) {
            AppMethodBeat.i(126930);
            if (!g.aAc()) {
                com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
                AppMethodBeat.o(126930);
                throw bVar;
            }
            if (bhi().jrQ == null) {
                bhi().jrQ = new t(g.aAh().hqK);
            }
            tVar = bhi().jrQ;
            AppMethodBeat.o(126930);
        }
        return tVar;
    }

    public static e bhk() {
        boolean z;
        int i2 = 0;
        AppMethodBeat.i(126931);
        g.aAf().azk();
        if (bhi().jrX == null) {
            bhi().jrX = new e();
        }
        if (f.baR().iRo == null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            com.tencent.mm.an.a baR = f.baR();
            e eVar = bhi().jrX;
            baR.iRo = eVar;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(baR.hashCode());
            if (eVar != null) {
                i2 = eVar.hashCode();
            }
            objArr[1] = Integer.valueOf(i2);
            Log.i("MicroMsg.CdnTransportEngine", "set cdn online video callback hash[%d] onlineVideoCallback[%d]", objArr);
        }
        e eVar2 = bhi().jrX;
        AppMethodBeat.o(126931);
        return eVar2;
    }

    public static i bhl() {
        AppMethodBeat.i(126932);
        g.aAf().azk();
        if (bhi().jrY == null) {
            bhi().jrY = new i();
        }
        i iVar = bhi().jrY;
        AppMethodBeat.o(126932);
        return iVar;
    }

    public static x bhm() {
        AppMethodBeat.i(126933);
        if (!g.aAc()) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(126933);
            throw bVar;
        }
        if (bhi().jrR == null) {
            bhi().jrR = new x(g.aAh().hqK);
        }
        x xVar = bhi().jrR;
        AppMethodBeat.o(126933);
        return xVar;
    }

    public static synchronized l bhn() {
        l lVar;
        synchronized (o.class) {
            AppMethodBeat.i(126934);
            if (!g.aAc()) {
                com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
                AppMethodBeat.o(126934);
                throw bVar;
            }
            if (bhi().jrT == null) {
                bhi().jrT = new l(g.aAh().hqK);
            }
            lVar = bhi().jrT;
            AppMethodBeat.o(126934);
        }
        return lVar;
    }

    public static y.a bho() {
        AppMethodBeat.i(126935);
        if (!g.aAc()) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(126935);
            throw bVar;
        }
        if (bhi().jrS == null) {
            bhi().jrS = new y.a();
        }
        y.a aVar = bhi().jrS;
        AppMethodBeat.o(126935);
        return aVar;
    }

    public static m bhp() {
        AppMethodBeat.i(126936);
        if (!g.aAc()) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(126936);
            throw bVar;
        }
        if (bhi().jrV == null) {
            bhi().jrV = new m();
        }
        m mVar = bhi().jrV;
        AppMethodBeat.o(126936);
        return mVar;
    }

    private static void bhq() {
        AppMethodBeat.i(126937);
        if (jrW == null || jrW.isQuit()) {
            MMHandler mMHandler = new MMHandler("Short-Video-Decoder-Thread-" + System.currentTimeMillis());
            jrW = mMHandler;
            mMHandler.setLogging(false);
        }
        AppMethodBeat.o(126937);
    }

    public static boolean g(Runnable runnable, long j2) {
        AppMethodBeat.i(126938);
        if (runnable == null) {
            AppMethodBeat.o(126938);
            return false;
        }
        bhq();
        if (j2 > 0) {
            jrW.postDelayed(runnable, j2);
        } else {
            jrW.post(runnable);
        }
        AppMethodBeat.o(126938);
        return true;
    }

    public static boolean I(Runnable runnable) {
        AppMethodBeat.i(126939);
        if (runnable == null) {
            AppMethodBeat.o(126939);
            return true;
        }
        bhq();
        if (jrW == null) {
            Log.e("MicroMsg.SubCoreVideo", "short video decoder handler is null");
            AppMethodBeat.o(126939);
            return false;
        }
        jrW.removeCallbacks(runnable);
        AppMethodBeat.o(126939);
        return true;
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(126940);
        Log.i("MicroMsg.SubCoreVideo", "%d onAccountRelease ", Integer.valueOf(hashCode()));
        bho().b(this.jrZ);
        this.appForegroundListener.dead();
        try {
            if (bhi().jrS != null) {
                y.a aVar = bhi().jrS;
                aVar.dAF = 0;
                if (aVar.jta != null) {
                    g.azz().a(aVar.jta);
                }
                if (aVar.jtb != null) {
                    g.azz().a(aVar.jtb);
                }
                g.azz().b(149, aVar);
                g.azz().b(150, aVar);
                bhj().a(aVar);
                aVar.jtc.clear();
            }
            if (bhi().jrV != null) {
                m mVar = bhi().jrV;
                mVar.dAF = 0;
                Log.i("MicroMsg.SightMassSendService", "stop, cur cdn client id %s", mVar.jrq);
                if (!Util.isNullOrNil(mVar.jrq)) {
                    f.baQ().Ob(mVar.jrq);
                }
            }
            if (bhi().jrY != null) {
                i iVar = bhi().jrY;
                iVar.stopDownload();
                iVar.jra.clear();
            }
            if (bhi().jrX != null) {
                bhi().jrX.release();
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SubCoreVideo", e2, "", new Object[0]);
        }
        h.d.b(43, this.jrP);
        h.d.b(44, this.jrP);
        h.d.b(62, this.jrP);
        h.d.b(486539313, this.jrP);
        if (jrW != null) {
            jrW.removeCallbacksAndMessages(null);
        }
        try {
            y.a bho = bho();
            Log.i("MicroMsg.VideoService", "quitVideoSendThread");
            if (bho.jsV != null) {
                try {
                    bho.jsV.quit();
                    bho.jsW = false;
                    bho.jsV = null;
                    AppMethodBeat.o(126940);
                    return;
                } catch (Exception e3) {
                    Log.e("MicroMsg.VideoService", "quitVideoSendThread error: %s", e3.getMessage());
                }
            }
            AppMethodBeat.o(126940);
        } catch (Exception e4) {
            Log.e("MicroMsg.SubCoreVideo", "onAccountRelease, quitVideoSendThread error: %s", e4.getMessage());
            AppMethodBeat.o(126940);
        }
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(126941);
        Log.i("MicroMsg.SubCoreVideo", "%d onAccountPostReset ", Integer.valueOf(hashCode()));
        bho().a(this.jrZ);
        this.appForegroundListener.alive();
        h.d.a(43, this.jrP);
        h.d.a(44, this.jrP);
        h.d.a(62, this.jrP);
        h.d.a(486539313, this.jrP);
        if (jrW != null) {
            jrW.removeCallbacksAndMessages(null);
        }
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.modelvideo.o.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(126927);
                if (!g.aAc()) {
                    AppMethodBeat.o(126927);
                    return;
                }
                t bhj = o.bhj();
                String str = "UPDATE videoinfo2 SET status = 198, lastmodifytime = " + (System.currentTimeMillis() / 1000) + " WHERE masssendid > 0  AND status = 200";
                Log.i("MicroMsg.VideoInfoStorage", "fail all massSendInfos, sql %s", str);
                bhj.iFy.execSQL("videoinfo2", str);
                o.bhn().db.execSQL("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 1 WHERE fileStatus = 6");
                l bhn = o.bhn();
                if (1209600000 <= 0) {
                    Log.w("MicroMsg.SightDraftStorage", "keep 0 sight draft");
                    bhn.db.execSQL("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 7 WHERE fileStatus = 1");
                } else {
                    long nowMilliSecond = Util.nowMilliSecond() - 1209600000;
                    Log.i("MicroMsg.SightDraftStorage", "check delete ITEM, create time %d", Long.valueOf(nowMilliSecond));
                    bhn.db.execSQL("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 7 WHERE fileStatus = 1 AND createTime < ".concat(String.valueOf(nowMilliSecond)));
                }
                for (j jVar : o.bhn().bhd()) {
                    Log.i("MicroMsg.SubCoreVideo", "do delete sight draft file, name %s", jVar.field_fileName);
                    s.deleteFile(k.Qh(jVar.field_fileName));
                    s.deleteFile(k.Qi(jVar.field_fileName));
                }
                AppMethodBeat.o(126927);
            }
        });
        com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(k.bhc());
        if (!oVar.exists() || !oVar.isDirectory()) {
            oVar.mkdirs();
        }
        AppMethodBeat.o(126941);
    }

    public static String getAccVideoPath() {
        AppMethodBeat.i(126942);
        StringBuilder sb = new StringBuilder();
        g.aAi();
        String k = s.k(sb.append(g.aAh().hqG).append("video/").toString(), true);
        AppMethodBeat.o(126942);
        return k;
    }

    public static String bhr() {
        AppMethodBeat.i(240874);
        StringBuilder sb = new StringBuilder();
        g.aAi();
        String k = s.k(sb.append(g.aAh().hqG).append("subvideo/").toString(), true);
        AppMethodBeat.o(240874);
        return k;
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }
}
