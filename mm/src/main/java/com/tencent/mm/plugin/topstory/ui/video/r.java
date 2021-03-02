package com.tencent.mm.plugin.topstory.ui.video;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.i.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.d;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.topstory.a.a;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.topstory.ui.video.m;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.protocal.protobuf.eix;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.ArrayList;
import java.util.HashMap;

public final class r {
    private int Fdo = 0;
    public eiw GjK;
    b GlS;
    q GnX;
    public f GnY;
    public boolean GnZ;
    public boolean Goa;
    public boolean Gob = false;
    private d.a Goc = new d.a() {
        /* class com.tencent.mm.plugin.topstory.ui.video.r.AnonymousClass1 */

        @Override // com.tencent.mm.model.d.a
        public final void aTw() {
        }

        @Override // com.tencent.mm.model.d.a
        public final void aTx() {
        }

        @Override // com.tencent.mm.model.d.a
        public final void aTy() {
        }

        @Override // com.tencent.mm.model.d.a
        public final void aTz() {
        }
    };
    private boolean God;
    private boolean Goe;
    private d hWh = new d();

    public r() {
        AppMethodBeat.i(126212);
        AppMethodBeat.o(126212);
    }

    public final void a(f fVar, i.e eVar) {
        AppMethodBeat.i(126213);
        if (fVar == this.GnY || this.GlS == null) {
            AppMethodBeat.o(126213);
            return;
        }
        if (this.GnX == null) {
            this.GnX = fzG();
        }
        fzF();
        fVar.getVideoViewParent().addView(this.GnX);
        this.GnX.setVideoFooterView(fVar.getControlBar());
        this.GnX.setScaleType(eVar);
        this.GnX.setIMMVideoViewCallback(fVar.getVideoViewCallback());
        this.hWh.a(this.Goc);
        this.GnY = fVar;
        AppMethodBeat.o(126213);
    }

    public final void a(b bVar, eiw eiw, String str, int i2) {
        AppMethodBeat.i(126214);
        if (eiw.NiI != null) {
            eiw.NiI.dEF = false;
        }
        Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "replay video %s %s %s", eiw.psI, eiw.title, str);
        bVar.fyB().b(bVar.fyD());
        bVar.fyB().fzB();
        bVar.fyB().a(eiw, i2, str);
        this.GnX.setKeepScreenOn(true);
        this.GnX.fzE();
        this.GnX.aTG(str);
        this.GjK = eiw;
        this.GnZ = true;
        this.Goa = false;
        ((PluginTopStoryUI) g.ah(PluginTopStoryUI.class)).getVideoPlayProgressMap().put(eiw.psI, 0);
        AppMethodBeat.o(126214);
    }

    private void fzF() {
        AppMethodBeat.i(126215);
        if (this.GnX.getParent() != null) {
            ((ViewGroup) this.GnX.getParent()).removeView(this.GnX);
        }
        AppMethodBeat.o(126215);
    }

    private q fzG() {
        AppMethodBeat.i(126216);
        q qVar = new q(this.GlS.eeF(), this.GlS);
        qVar.setRootPath(this.GlS.fyC());
        qVar.setIOnlineVideoProxy(new b(this, (byte) 0));
        qVar.setReporter(new c(this, (byte) 0));
        AppMethodBeat.o(126216);
        return qVar;
    }

    /* access modifiers changed from: package-private */
    public class c implements i.c {
        private c() {
        }

        /* synthetic */ c(r rVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.c
        public final void yU(long j2) {
            AppMethodBeat.i(126210);
            e.INSTANCE.idkeyStat(600, j2, 1, false);
            AppMethodBeat.o(126210);
        }

        @Override // com.tencent.mm.pluginsdk.ui.i.c
        public final void DX(String str) {
            AppMethodBeat.i(126211);
            e.INSTANCE.kvStat(14349, str);
            AppMethodBeat.o(126211);
        }
    }

    private void requestAudioFocus() {
        AppMethodBeat.i(126217);
        this.hWh.a(this.Goc);
        AppMethodBeat.o(126217);
    }

    private void abandonAudioFocus() {
        AppMethodBeat.i(126218);
        this.hWh.fp(false);
        AppMethodBeat.o(126218);
    }

    public final boolean dFG() {
        AppMethodBeat.i(126219);
        if (this.GnX != null) {
            boolean isPlaying = this.GnX.isPlaying();
            AppMethodBeat.o(126219);
            return isPlaying;
        }
        AppMethodBeat.o(126219);
        return false;
    }

    public final void setMute(boolean z) {
        AppMethodBeat.i(126220);
        if (this.GnX != null) {
            this.GnX.setMute(z);
        }
        AppMethodBeat.o(126220);
    }

    public final void eYd() {
        AppMethodBeat.i(126221);
        if (this.GnX != null) {
            requestAudioFocus();
            this.GnX.setKeepScreenOn(true);
            this.GnX.play();
            this.Goa = false;
        }
        AppMethodBeat.o(126221);
    }

    public final void cXa() {
        AppMethodBeat.i(126222);
        if (this.GnX != null) {
            abandonAudioFocus();
            this.GnX.setKeepScreenOn(false);
            this.GnX.pause();
            this.Goa = true;
        }
        AppMethodBeat.o(126222);
    }

    public final void stopPlay() {
        AppMethodBeat.i(126223);
        if (this.GnX != null) {
            Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "stop play");
            abandonAudioFocus();
            this.GnX.fzD();
            this.GnX.setKeepScreenOn(false);
            this.GnX.stop();
            this.GjK = null;
            this.GnZ = false;
            this.Goa = false;
            if (this.GlS != null) {
                this.GlS.fyB().b(this.GlS.fyD());
                this.GlS.fyB().fzB();
            }
            if (this.GnY != null) {
                this.GnY.fzb();
            }
        }
        AppMethodBeat.o(126223);
    }

    public final void d(b bVar) {
        this.Fdo++;
        this.GlS = bVar;
    }

    public final void onUIResume() {
        AppMethodBeat.i(126224);
        if (this.GnX != null) {
            this.GnX.onUIResume();
            if (this.GnY != null) {
                this.GnY.fza();
            }
        }
        AppMethodBeat.o(126224);
    }

    public final void onUIPause() {
        AppMethodBeat.i(126225);
        if (this.GnX != null) {
            this.GnX.onUIPause();
        }
        AppMethodBeat.o(126225);
    }

    public final void onUIDestroy() {
        AppMethodBeat.i(126226);
        this.Fdo--;
        Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onUIDestroy %d", Integer.valueOf(this.Fdo));
        if (this.Fdo <= 0) {
            if (this.GnX != null) {
                stopPlay();
                this.GnX.onUIDestroy();
            }
            this.GlS = null;
        }
        AppMethodBeat.o(126226);
    }

    public final void onError(String str) {
        AppMethodBeat.i(126227);
        if (this.GnX != null && this.GnX.getSessionId().equals(str)) {
            stopPlay();
        }
        AppMethodBeat.o(126227);
    }

    public final void jp(int i2, int i3) {
        AppMethodBeat.i(126228);
        if (i2 == 0) {
            if (this.GnZ && this.Goe) {
                this.Goe = false;
                eYd();
                AppMethodBeat.o(126228);
                return;
            }
        } else if (i3 == 0) {
            if (this.GnZ && dFG()) {
                this.Goe = true;
                cXa();
                AppMethodBeat.o(126228);
                return;
            }
        } else if (i3 == 1 && this.God && this.GnZ && this.Goa) {
            this.God = false;
            eYd();
            this.GnY.fyX();
        }
        AppMethodBeat.o(126228);
    }

    public final void aTH(String str) {
        AppMethodBeat.i(126229);
        com.tencent.mm.plugin.topstory.a.b.b bVar = this.GlS.fyB().GnT;
        if (bVar != null) {
            bVar.Gjq = 1;
        }
        if (this.GnX != null && this.GnX.getSessionId().equals(str)) {
            if (this.GjK != null) {
                ((PluginTopStoryUI) g.ah(PluginTopStoryUI.class)).getVideoPlayProgressMap().remove(this.GjK.psI);
            }
            stopPlay();
        }
        com.tencent.mm.plugin.websearch.api.a.a.pl(26);
        AppMethodBeat.o(126229);
    }

    public final int getCurrPosSec() {
        AppMethodBeat.i(126230);
        if (this.GnX != null) {
            int currPosSec = this.GnX.getCurrPosSec();
            AppMethodBeat.o(126230);
            return currPosSec;
        }
        AppMethodBeat.o(126230);
        return 0;
    }

    public final int getVideoDurationSec() {
        AppMethodBeat.i(126231);
        if (this.GnX != null) {
            int videoDurationSec = this.GnX.getVideoDurationSec();
            AppMethodBeat.o(126231);
            return videoDurationSec;
        }
        AppMethodBeat.o(126231);
        return 0;
    }

    public final int getCurrPosMs() {
        AppMethodBeat.i(126232);
        if (this.GnX != null) {
            int currPosMs = this.GnX.getCurrPosMs();
            AppMethodBeat.o(126232);
            return currPosMs;
        }
        AppMethodBeat.o(126232);
        return 0;
    }

    /* access modifiers changed from: package-private */
    public class b implements com.tencent.mm.modelvideo.b {
        private eix Goj;

        private b() {
        }

        /* synthetic */ b(r rVar, byte b2) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x008f  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x017a  */
        @Override // com.tencent.mm.modelvideo.b
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void p(java.lang.String r11, java.lang.String r12, java.lang.String r13) {
            /*
            // Method dump skipped, instructions count: 398
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.topstory.ui.video.r.b.p(java.lang.String, java.lang.String, java.lang.String):void");
        }

        @Override // com.tencent.mm.modelvideo.b
        public final void he(String str) {
            AppMethodBeat.i(126207);
            o.bhk().m(str, null);
            AppMethodBeat.o(126207);
        }

        @Override // com.tencent.mm.modelvideo.b
        public final void requestVideoData(String str, int i2, int i3) {
            AppMethodBeat.i(126208);
            if (this.Goj == null || ((long) (i2 + i3)) > this.Goj.NiK) {
                o.bhk();
                com.tencent.mm.an.e.r(str, i2, i3);
                AppMethodBeat.o(126208);
                return;
            }
            AppMethodBeat.o(126208);
        }

        @Override // com.tencent.mm.modelvideo.b
        public final boolean isVideoDataAvailable(String str, int i2, int i3) {
            boolean z;
            com.tencent.mm.plugin.topstory.a.b.b bVar;
            AppMethodBeat.i(126209);
            if (this.Goj == null || ((long) (i2 + i3)) > this.Goj.NiK) {
                z = false;
            } else {
                z = true;
            }
            if (i2 == 0 && z && r.this.GlS != null && (bVar = r.this.GlS.fyB().GnT) != null && bVar.GjC == 0) {
                bVar.GjC = System.currentTimeMillis() - bVar.Gjm;
                bVar.GjD = (long) i2;
                bVar.GjE = (long) (i2 + i3);
                Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "firstDataAvailable %d %d %d", Long.valueOf(bVar.Gjz), Integer.valueOf(i2), Integer.valueOf(i3));
            }
            if (!z) {
                z = o.bhk().isVideoDataAvailable(str, i2, i3);
            }
            AppMethodBeat.o(126209);
            return z;
        }

        @Override // com.tencent.mm.modelvideo.b
        public final void a(b.a aVar) {
        }
    }

    class a implements h.a {
        boolean Gog;
        private boolean Goh;

        private a() {
        }

        /* synthetic */ a(r rVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.i.h.a
        public final void Ds(String str) {
        }

        @Override // com.tencent.mm.i.h.a
        public final void a(final String str, final long j2, final long j3, final String str2) {
            AppMethodBeat.i(236394);
            if (!this.Gog) {
                this.Gog = true;
                if (r.this.GlS != null) {
                    final com.tencent.mm.plugin.sight.base.a aNx = com.tencent.mm.plugin.sight.base.e.aNx(r.this.GlS.fyC() + str + ".mp4");
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.topstory.ui.video.r.a.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(126197);
                            if (!(r.this.GnX == null || r.this.GlS == null)) {
                                com.tencent.mm.plugin.topstory.a.b.b bVar = r.this.GlS.fyB().GnT;
                                if (bVar != null && bVar.Gjz == 0) {
                                    bVar.Gjz = System.currentTimeMillis() - bVar.Gjm;
                                    bVar.GjA = j2;
                                    bVar.GjB = j2 + j3;
                                    bVar.GjF = aNx;
                                    Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onMoovReady %d %d %d", Long.valueOf(bVar.Gjz), Long.valueOf(j2), Long.valueOf(j3));
                                }
                                r.this.GnX.AI(j2);
                            }
                            AppMethodBeat.o(126197);
                        }
                    });
                }
                AppMethodBeat.o(236394);
                return;
            }
            AppMethodBeat.o(236394);
        }

        @Override // com.tencent.mm.i.h.a
        public final void onDataAvailable(final String str, final long j2, final long j3) {
            AppMethodBeat.i(126202);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.topstory.ui.video.r.a.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(126198);
                    if (r.this.GnX != null) {
                        r.this.GnX.onDataAvailable(str, j2, j3);
                    }
                    AppMethodBeat.o(126198);
                }
            });
            AppMethodBeat.o(126202);
        }

        @Override // com.tencent.mm.i.h.a
        public final void i(final String str, final long j2, final long j3) {
            AppMethodBeat.i(126203);
            if (r.this.GlS != null) {
                m fyE = r.this.GlS.fyE();
                if (fyE.GnA.containsKey(str)) {
                    eix eix = fyE.GnA.get(str);
                    eix.mediaId = str;
                    eix.Niv = j3;
                    eix.NiK = j2;
                    eix.NiL = m.au(eix.NiK, eix.Niv);
                    fyE.GnA.put(str, eix);
                }
                com.tencent.mm.plugin.topstory.a.b.b bVar = r.this.GlS.fyB().GnT;
                if (bVar != null) {
                    bVar.GjG = j3;
                }
            }
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.topstory.ui.video.r.a.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(126199);
                    if (r.this.GnX != null) {
                        r.this.GnX.i(str, j2, j3);
                    }
                    if (r.av((j2 * 100) / j3, j2)) {
                        a.this.fzH();
                    }
                    AppMethodBeat.o(126199);
                }
            });
            AppMethodBeat.o(126203);
        }

        public final void fzH() {
            int i2;
            eix eix;
            AppMethodBeat.i(126204);
            if (!this.Goh && r.this.GjK != null && r.this.GlS != null && (r.this.GlS.fyA().cGF() || ai.isFreeSimCard())) {
                Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startPreload");
                this.Goh = true;
                m fyE = r.this.GlS.fyE();
                eiw eiw = r.this.GjK;
                n fyO = fyE.GlS.fyO();
                ArrayList<eiw> arrayList = new ArrayList();
                synchronized (fyO) {
                    try {
                        int size = fyO.GW().size();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= size) {
                                i2 = -1;
                                break;
                            } else if (eiw.psI.equals(fyO.GW().get(i3).psI)) {
                                i2 = i3;
                                break;
                            } else {
                                i3++;
                            }
                        }
                        if (i2 >= 0 && i2 + 1 < size) {
                            for (int i4 = i2 + 1; i4 < size; i4++) {
                                arrayList.add(fyO.GW().get(i4));
                            }
                        }
                    } finally {
                        AppMethodBeat.o(126204);
                    }
                }
                HashMap hashMap = new HashMap();
                for (eiw eiw2 : arrayList) {
                    String bu = com.tencent.mm.plugin.topstory.ui.c.bu(eiw2.psI, eiw2.Nip);
                    if (fyE.GnA.containsKey(bu)) {
                        eix = fyE.GnA.get(bu);
                    } else {
                        eix = new eix();
                        eix.mediaId = bu;
                        eix.Niv = eiw2.Niv;
                    }
                    hashMap.put(bu, eix);
                    int au = (int) m.au(a.C1837a.Gjb.longValue(), eiw2.Niv);
                    if (au < 20) {
                        au = 20;
                    } else if (au > 100) {
                        au = 100;
                    }
                    if (eix.NiL < ((long) au)) {
                        String str = eiw2.videoUrl;
                        h hVar = new h();
                        hVar.taskName = "task_TopStoryPreloadMgr";
                        hVar.field_mediaId = bu;
                        hVar.url = str;
                        hVar.gqO = 2;
                        hVar.gqU = 2;
                        hVar.gqP = 3;
                        hVar.gqZ = au;
                        hVar.field_preloadRatio = au;
                        hVar.concurrentCount = 4;
                        hVar.field_fullpath = fyE.GlS.fyC() + bu + ".mp4";
                        hVar.gqy = new m.d(fyE, (byte) 0);
                        hVar.gqQ = new m.c(fyE, (byte) 0);
                        f.baQ().b(hVar, -1);
                        Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Preload video %s from %s to %s", bu, Long.valueOf(eix.NiL), Integer.valueOf(au));
                    } else {
                        Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Already Preload video %s %s", bu, Long.valueOf(eix.NiL));
                    }
                    if (hashMap.size() == 6) {
                        break;
                    }
                }
                fyE.GnB.clear();
                fyE.GnB.addAll(hashMap.keySet());
                fyE.GnA.putAll(hashMap);
                ThreadPool.post(new m.a(fyE.Gnz), "TopStory.DeleteVideoCacheTask");
            }
        }

        @Override // com.tencent.mm.i.h.a
        public final void a(final String str, final int i2, com.tencent.mm.i.d dVar) {
            int i3;
            int i4;
            AppMethodBeat.i(126205);
            if (com.tencent.mm.plugin.topstory.a.h.fxR() && r.this.Gob) {
                r.this.Gob = false;
                i2 = 404;
            }
            Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onFinish %s %d", str, Integer.valueOf(i2));
            if (r.this.GlS != null) {
                m fyE = r.this.GlS.fyE();
                if (fyE.GnA.containsKey(str)) {
                    eix eix = fyE.GnA.get(str);
                    if (i2 == 0) {
                        eix.mediaId = str;
                        eix.NiK = eix.Niv;
                        eix.NiL = m.au(eix.NiK, eix.Niv);
                        fyE.GnA.put(str, eix);
                    }
                    Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "onCurrentVideoDownloadFinish onFinish %s %d %s %d", str, Long.valueOf(eix.NiL), Util.getSizeMB(eix.NiK, 100.0d), Integer.valueOf(i2));
                }
            }
            try {
                eiw acd = r.this.GlS.fyO().acd(r.this.GlS.fyH());
                int ape = n.ape();
                if (dVar == null) {
                    dVar = new com.tencent.mm.i.d();
                }
                Object[] objArr = new Object[17];
                objArr[0] = Integer.valueOf(acd.NiF);
                objArr[1] = Integer.valueOf(i2);
                objArr[2] = 2;
                objArr[3] = Long.valueOf(dVar.field_startTime);
                objArr[4] = Long.valueOf(dVar.field_endTime);
                objArr[5] = Integer.valueOf(dVar.field_averageSpeed);
                objArr[6] = Integer.valueOf(dVar.field_averageConnectCost);
                objArr[7] = Integer.valueOf(dVar.field_firstConnectCost);
                objArr[8] = Integer.valueOf(dVar.field_moovFailReason);
                objArr[9] = Integer.valueOf(dVar.field_httpStatusCode);
                objArr[10] = dVar.field_clientIP;
                objArr[11] = dVar.field_serverIP;
                objArr[12] = dVar.field_xErrorNo;
                objArr[13] = Integer.valueOf(dVar.field_cSeqCheck);
                objArr[14] = Integer.valueOf(dVar.field_isCrossNet ? 1 : 0);
                if (dVar.field_usePrivateProtocol) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                objArr[15] = Integer.valueOf(i3);
                objArr[16] = Integer.valueOf(ape);
                String format = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", objArr);
                Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportKvTopStoryCdnDownloadError 16270 %s", format);
                e.INSTANCE.kvStat(16270, format);
                if (i2 != 0) {
                    doc doc = new doc();
                    StringBuilder sb = new StringBuilder();
                    sb.append("videoplayfailreport=1");
                    sb.append("&vt=").append(acd.NiF);
                    sb.append("&errorcode=").append(i2);
                    sb.append("&filetype=2");
                    sb.append("&startdownloadtime=").append(dVar.field_startTime);
                    sb.append("&enddownloadtime=").append(dVar.field_endTime);
                    sb.append("&averagespeed=").append(dVar.field_averageSpeed);
                    sb.append("&averageconnectcost=").append(dVar.field_averageConnectCost);
                    sb.append("&firstconnectcost=").append(dVar.field_firstConnectCost);
                    sb.append("&moovfailreason=").append(dVar.field_moovFailReason);
                    sb.append("&httpstatuscode=").append(dVar.field_httpStatusCode);
                    sb.append("&clientip=").append(dVar.field_clientIP);
                    sb.append("&serverip=").append(dVar.field_serverIP);
                    sb.append("&xerrno=").append(dVar.field_xErrorNo);
                    sb.append("&cseqresult=").append(dVar.field_cSeqCheck);
                    sb.append("&crossnet=").append(dVar.field_isCrossNet ? 1 : 0);
                    StringBuilder append = sb.append("&privateprotocol=");
                    if (dVar.field_usePrivateProtocol) {
                        i4 = 1;
                    } else {
                        i4 = 0;
                    }
                    append.append(i4);
                    sb.append("&nettype=").append(ape);
                    sb.append("&cdnsourcetype=").append(acd.NiB);
                    sb.append("&cdnscene=").append(acd.NiA);
                    sb.append("&expand=").append(acd.Nir);
                    doc.MRe = sb.toString();
                    doc.MRs = dVar.field_httpResponseHeader;
                    doc.xLk = acd.videoUrl;
                    doc.MRt = acd.NiD;
                    Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "NetSceneWebSearchReport16270 [logString:%s], [header:%s], [url:%s], [bypass:%s]", doc.MRe, doc.MRs, doc.xLk, doc.MRt);
                    g.azz().a(new ad(doc), 0);
                }
            } catch (Exception e2) {
            }
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.topstory.ui.video.r.a.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(126200);
                    if (!(r.this.GnX == null || r.this.GlS == null)) {
                        com.tencent.mm.plugin.topstory.a.b.b bVar = r.this.GlS.fyB().GnT;
                        if (bVar != null && bVar.Gjy == 0) {
                            bVar.Gjy = System.currentTimeMillis() - bVar.Gjm;
                        }
                        r.this.GnX.ax(str, i2);
                        if (i2 != 0) {
                            com.tencent.mm.plugin.websearch.api.a.a.pl(9);
                            AppMethodBeat.o(126200);
                            return;
                        }
                        com.tencent.mm.plugin.websearch.api.a.a.pl(27);
                    }
                    AppMethodBeat.o(126200);
                }
            });
            AppMethodBeat.o(126205);
        }
    }

    public static boolean av(long j2, long j3) {
        if (j2 >= 50 || j3 > 5242880) {
            return true;
        }
        return false;
    }

    static /* synthetic */ h a(String str, String str2, String str3, a aVar) {
        AppMethodBeat.i(126233);
        h hVar = new h();
        hVar.taskName = "task_TopStoryVideoViewMgr";
        hVar.field_mediaId = str;
        hVar.url = str2;
        hVar.gqU = 1;
        hVar.gqP = 3;
        hVar.concurrentCount = 4;
        hVar.field_fullpath = str3;
        hVar.gre = aVar;
        AppMethodBeat.o(126233);
        return hVar;
    }
}
