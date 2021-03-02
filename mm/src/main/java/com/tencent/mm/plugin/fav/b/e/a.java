package com.tencent.mm.plugin.fav.b.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.http.HttpClientWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class a implements o {
    private Queue<c> dAA = new LinkedList();
    private Map<String, f.a> dAC = new HashMap();
    boolean dAE = false;
    public int dAF = 0;
    long dAG = 0;
    public MTimerHandler dAJ = new MTimerHandler(g.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.fav.b.e.a.AnonymousClass5 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(101589);
            try {
                a.this.bck();
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Fav.FavCdnService", e2, "", new Object[0]);
            }
            AppMethodBeat.o(101589);
            return false;
        }

        public final String toString() {
            AppMethodBeat.i(101590);
            String str = super.toString() + "|scenePusher";
            AppMethodBeat.o(101590);
            return str;
        }
    }, false);
    public p iRt = new p.a() {
        /* class com.tencent.mm.plugin.fav.b.e.a.AnonymousClass1 */

        @Override // com.tencent.mm.network.p
        public final void onNetworkChange(int i2) {
            AppMethodBeat.i(101584);
            try {
                boolean isWifi = NetStatusUtil.isWifi(MMApplicationContext.getContext());
                Log.i("MicroMsg.Fav.FavCdnService", "onNetworkChange st:%d isWifi:%B, lastIsWifi:%B", Integer.valueOf(i2), Boolean.valueOf(isWifi), Boolean.valueOf(a.this.tcf));
                if (i2 == 4 || i2 == 6) {
                    if (a.this.tcf && !isWifi) {
                        a aVar = a.this;
                        Log.i("MicroMsg.Fav.FavCdnService", "pauseAll");
                        Cursor cUL = ((af) g.ah(af.class)).getFavCdnStorage().cUL();
                        if (cUL != null && cUL.moveToFirst()) {
                            while (cUL.moveToNext()) {
                                c cVar = new c();
                                cVar.convertFrom(cUL);
                                Log.i("MicroMsg.Fav.FavCdnService", "pauseAll, pauseUpload dataId:%s", cVar.field_dataId);
                                cVar.field_status = 4;
                                ((af) g.ah(af.class)).getFavCdnStorage().a(cVar, "dataId");
                                com.tencent.mm.an.f.baQ().Ob(cVar.field_dataId);
                                a.h(((af) g.ah(af.class)).getFavCdnStorage().asa(cVar.field_dataId));
                                aVar.ase(cVar.field_dataId);
                            }
                            cUL.close();
                        }
                        Cursor cUM = ((af) g.ah(af.class)).getFavCdnStorage().cUM();
                        if (cUM != null && cUM.moveToFirst()) {
                            while (cUM.moveToNext()) {
                                c cVar2 = new c();
                                cVar2.convertFrom(cUM);
                                Log.i("MicroMsg.Fav.FavCdnService", "pauseAll, pauseDownload dataId:%s", cVar2.field_dataId);
                                cVar2.field_status = 4;
                                ((af) g.ah(af.class)).getFavCdnStorage().a(cVar2, "dataId");
                                com.tencent.mm.an.f.baQ().Oc(cVar2.field_dataId);
                                a.h(((af) g.ah(af.class)).getFavCdnStorage().asa(cVar2.field_dataId));
                                aVar.ase(cVar2.field_dataId);
                            }
                        }
                        if (cUM != null) {
                            cUM.close();
                        }
                    }
                    if (!a.this.tcf && isWifi) {
                        a aVar2 = a.this;
                        Log.i("MicroMsg.Fav.FavCdnService", "startAll");
                        ((af) g.ah(af.class)).getFavCdnStorage().startAll();
                        aVar2.run();
                    }
                    a.this.tcf = isWifi;
                    AppMethodBeat.o(101584);
                    return;
                }
                a.this.tcf = isWifi;
                AppMethodBeat.o(101584);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Fav.FavCdnService", e2, "", new Object[0]);
                AppMethodBeat.o(101584);
            }
        }
    };
    private g.a iZc = new g.a() {
        /* class com.tencent.mm.plugin.fav.b.e.a.AnonymousClass6 */

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, com.tencent.mm.i.c cVar, d dVar, boolean z) {
            int i3;
            AppMethodBeat.i(101591);
            if (cVar != null) {
                Log.i("MicroMsg.Fav.FavCdnService", "cdn transfer callback, mediaid=%s, totallen=%d, offset=%d", cVar.mediaId, Long.valueOf(cVar.field_toltalLength), Long.valueOf(cVar.field_finishedLength));
            }
            String str2 = "";
            if (cVar != null) {
                str2 = cVar.mediaId;
            } else if (dVar != null) {
                str2 = dVar.mediaId;
            }
            if (i2 == -21006 || i2 == -21005) {
                a.this.ase(str2);
                AppMethodBeat.o(101591);
                return 0;
            }
            if (!Util.isNullOrNil(str2)) {
                str = str2;
            }
            c asa = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(str);
            if (asa == null) {
                Log.e("MicroMsg.Fav.FavCdnService", "klem onCdnCallback info null");
                a.this.ase(str);
                AppMethodBeat.o(101591);
                return 0;
            }
            if (i2 != 0) {
                Log.w("MicroMsg.Fav.FavCdnService", "cdn transfer callback, startRet=%d", Integer.valueOf(i2));
                h.INSTANCE.a(10660, Integer.valueOf(asa.field_type), Integer.valueOf(i2));
                asa.field_status = 4;
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(asa, new String[0]);
                a.h(asa);
                a.this.ase(str);
            } else if (cVar != null) {
                asa.field_offset = (int) cVar.field_finishedLength;
                asa.field_totalLen = (int) cVar.field_toltalLength;
                asa.field_status = 1;
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(asa, new String[0]);
            } else if (dVar != null) {
                if (dVar.field_retCode >= 0) {
                    asa.field_status = 3;
                    if (1 == asa.field_type) {
                        String str3 = asa.field_path + ".temp";
                        String str4 = asa.field_path;
                        int i4 = asa.field_dataType;
                        if (!(str3 == null || str4 == null)) {
                            if (i4 != -2 || a.alH(str3) || !a.fI(str3, str4)) {
                                com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(str3);
                                com.tencent.mm.vfs.o oVar2 = new com.tencent.mm.vfs.o(str4);
                                if (oVar.exists()) {
                                    Log.i("MicroMsg.Fav.FavCdnService", "rename file suc:%b, old:%s, new:%s", Boolean.valueOf(oVar.am(oVar2)), str3, oVar2);
                                }
                            } else {
                                Log.i("MicroMsg.Fav.FavCdnService", "renameAndCopyFile write amr head ok!");
                            }
                        }
                    } else {
                        asa.field_cdnKey = dVar.field_aesKey;
                        asa.field_cdnUrl = dVar.field_fileId;
                    }
                    ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(asa, new String[0]);
                    a.a(asa, dVar);
                    ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().b(asa, "dataId");
                    a.this.tcd.remove(asa.field_dataId);
                    Log.i("MicroMsg.Fav.FavCdnService", "transfer done, mediaid=%s, md5=%s aeskey=%s completeInfo=%s", dVar.mediaId, str, dVar.field_aesKey, dVar.toString());
                } else {
                    Log.e("MicroMsg.Fav.FavCdnService", "transfer error, mediaid=%s, retCode:%d", dVar.mediaId, Integer.valueOf(dVar.field_retCode));
                    C1045a aVar = a.this.tcd.get(asa.field_dataId);
                    if (aVar != null) {
                        aVar.errCode = dVar.field_retCode;
                    }
                    if (-6101 != dVar.field_retCode) {
                        switch (dVar.field_retCode) {
                            case -5103015:
                                h.INSTANCE.idkeyStat(141, 8, 1, true);
                                break;
                            case -21020:
                                h.INSTANCE.idkeyStat(141, 7, 1, true);
                                break;
                            case -21014:
                                h.INSTANCE.idkeyStat(141, 6, 1, true);
                                break;
                            case -21009:
                                h.INSTANCE.idkeyStat(141, 5, 1, true);
                                break;
                            case -21000:
                                h.INSTANCE.idkeyStat(141, 4, 1, true);
                                break;
                            case HttpClientWrapper.RET_CODE_UNKOWN_HOST /*{ENCODED_INT: -10005}*/:
                                h.INSTANCE.idkeyStat(141, 3, 1, true);
                                break;
                            case HttpClientWrapper.RET_CODE_ILLEGAL_STATE /*{ENCODED_INT: -10003}*/:
                                h.INSTANCE.idkeyStat(141, 2, 1, true);
                                break;
                            default:
                                h.INSTANCE.idkeyStat(141, 0, 1, true);
                                break;
                        }
                    } else {
                        asa.field_extFlag |= 1;
                        h.INSTANCE.idkeyStat(141, 1, 1, true);
                        Object[] objArr = new Object[4];
                        objArr[0] = dVar.mediaId;
                        if (aVar != null) {
                            i3 = aVar.jNv;
                        } else {
                            i3 = 1;
                        }
                        objArr[1] = Integer.valueOf(i3);
                        objArr[2] = Integer.valueOf(asa.field_type);
                        objArr[3] = Integer.valueOf(asa.field_dataType);
                        Log.e("MicroMsg.Fav.FavCdnService", "transfer error, mediaid=%s, retCode:-6101,try time = %d,info.field_type: %d , info.field_dataType: %d", objArr);
                    }
                    asa.field_status = 4;
                    h.INSTANCE.a(10660, Integer.valueOf(asa.field_type), Integer.valueOf(dVar.field_retCode));
                    ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(asa, new String[0]);
                    a.h(asa);
                }
                a.a(a.this, str);
                h.INSTANCE.a(10625, 1, dVar.field_fileId, "", dVar.field_transInfo);
            }
            AppMethodBeat.o(101591);
            return 0;
        }

        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            return null;
        }
    };
    boolean running = false;
    Map<String, C1045a> tcd = new HashMap();
    Set<String> tce = new HashSet();
    boolean tcf = NetStatusUtil.isWifi(MMApplicationContext.getContext());
    int tcg = 0;
    boolean tch = true;
    private Runnable tci = new Runnable() {
        /* class com.tencent.mm.plugin.fav.b.e.a.AnonymousClass4 */

        public final void run() {
            AppMethodBeat.i(101587);
            long currentTimeMillis = System.currentTimeMillis() - a.this.dAG;
            if (a.this.running) {
                if (currentTimeMillis < 300000) {
                    AppMethodBeat.o(101587);
                    return;
                }
                Log.e("MicroMsg.Fav.FavCdnService", "klem ERR: Try Run service runningFlag:" + a.this.running + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + a.this.running);
            }
            Log.i("MicroMsg.Fav.FavCdnService", "do run cdn job, wait time %d", Long.valueOf(currentTimeMillis));
            a.this.dAE = false;
            a.this.running = true;
            a.this.tcg = 0;
            a.this.dAF = 3;
            a.this.dAJ.startTimer(100);
            AppMethodBeat.o(101587);
        }

        public final String toString() {
            AppMethodBeat.i(101588);
            String str = super.toString() + "|run";
            AppMethodBeat.o(101588);
            return str;
        }
    };

    static /* synthetic */ void a(a aVar, String str) {
        AppMethodBeat.i(101607);
        aVar.ase(str);
        AppMethodBeat.o(101607);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.fav.b.e.a$a  reason: collision with other inner class name */
    public class C1045a {
        int errCode;
        int jNv;
        long tcm;

        private C1045a() {
            this.errCode = 0;
        }

        /* synthetic */ C1045a(a aVar, byte b2) {
            this();
        }
    }

    public a() {
        AppMethodBeat.i(101592);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().a(this.iRt);
        AppMethodBeat.o(101592);
    }

    @Override // com.tencent.mm.plugin.fav.a.o
    public final void mx(final boolean z) {
        AppMethodBeat.i(101593);
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.fav.b.e.a.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(101585);
                a.this.tch = z;
                a.this.tcg = 0;
                AppMethodBeat.o(101585);
            }
        });
        AppMethodBeat.o(101593);
    }

    @Override // com.tencent.mm.plugin.fav.a.o
    public final void arY(final String str) {
        AppMethodBeat.i(101594);
        Log.i("MicroMsg.Fav.FavCdnService", "add force job %s", str);
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.fav.b.e.a.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(101586);
                a.this.tce.add(str);
                AppMethodBeat.o(101586);
            }
        });
        AppMethodBeat.o(101594);
    }

    @Override // com.tencent.mm.plugin.fav.a.o
    public final void run() {
        AppMethodBeat.i(101595);
        Log.i("MicroMsg.Fav.FavCdnService", "run fav cdn server");
        com.tencent.mm.kernel.g.aAk().getWorkerHandler().removeCallbacks(this.tci);
        com.tencent.mm.kernel.g.aAk().postToWorker(this.tci);
        AppMethodBeat.o(101595);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0407  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bck() {
        /*
        // Method dump skipped, instructions count: 1063
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fav.b.e.a.bck():void");
    }

    private static void g(c cVar) {
        AppMethodBeat.i(101597);
        if (1 == cVar.field_type) {
            cVar.field_status = 2;
        } else {
            cVar.field_status = 4;
        }
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(cVar, "dataId");
        h(cVar);
        AppMethodBeat.o(101597);
    }

    @Override // com.tencent.mm.plugin.fav.a.o
    public final void pauseDownload(String str) {
        AppMethodBeat.i(101598);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(101598);
            return;
        }
        if (this.dAC.containsKey(str)) {
            com.tencent.mm.an.f.baQ().Oc(str);
            Log.i("MicroMsg.Fav.FavCdnService", "pause download md5%s", str);
            h(((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(str));
            ase(str);
        }
        AppMethodBeat.o(101598);
    }

    @Override // com.tencent.mm.plugin.fav.a.o
    public final void arZ(String str) {
        AppMethodBeat.i(101599);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(101599);
            return;
        }
        com.tencent.mm.an.f.baQ().Ob(str);
        Log.i("MicroMsg.Fav.FavCdnService", "pause upload md5%s", str);
        h(((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(str));
        ase(str);
        AppMethodBeat.o(101599);
    }

    public final void aax() {
        AppMethodBeat.i(101600);
        this.dAA.clear();
        this.dAC.clear();
        this.running = false;
        this.dAE = false;
        AppMethodBeat.o(101600);
    }

    private static int a(c cVar, int i2) {
        AppMethodBeat.i(101601);
        if (cVar.field_totalLen > 26214400) {
            int i3 = com.tencent.mm.i.a.gpR;
            AppMethodBeat.o(101601);
            return i3;
        } else if ((cVar.field_extFlag & 1) == 0) {
            AppMethodBeat.o(101601);
            return i2;
        } else {
            Log.w("MicroMsg.Fav.FavCdnService", "NEED To Exchange Type, defType %d", Integer.valueOf(i2));
            if (com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO == i2) {
                int i4 = com.tencent.mm.i.a.MediaType_FAVORITE_FILE;
                AppMethodBeat.o(101601);
                return i4;
            }
            int i5 = com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO;
            AppMethodBeat.o(101601);
            return i5;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a A[SYNTHETIC, Splitter:B:17:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003f A[SYNTHETIC, Splitter:B:20:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008f A[SYNTHETIC, Splitter:B:43:0x008f] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0094 A[SYNTHETIC, Splitter:B:46:0x0094] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00c3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean fI(java.lang.String r8, java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 198
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fav.b.e.a.fI(java.lang.String, java.lang.String):boolean");
    }

    static boolean alH(String str) {
        AppMethodBeat.i(101603);
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = s.dB(str, false);
            byte[] bArr = new byte[6];
            if (randomAccessFile.read(bArr, 0, 6) == -1) {
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e2) {
                        Log.printErrStackTrace("MicroMsg.Fav.FavCdnService", e2, "", new Object[0]);
                    }
                }
                AppMethodBeat.o(101603);
                return false;
            }
            String str2 = new String(bArr);
            Log.i("MicroMsg.Fav.FavCdnService", "head " + str2 + "   AmrFileOperator.AMR_NB_HEAD #!AMR\n");
            boolean endsWith = str2.endsWith("#!AMR\n");
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e3) {
                    Log.printErrStackTrace("MicroMsg.Fav.FavCdnService", e3, "", new Object[0]);
                }
            }
            AppMethodBeat.o(101603);
            return endsWith;
        } catch (Exception e4) {
            Log.printErrStackTrace("MicroMsg.Fav.FavCdnService", e4, "", new Object[0]);
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e5) {
                    Log.printErrStackTrace("MicroMsg.Fav.FavCdnService", e5, "", new Object[0]);
                }
            }
            AppMethodBeat.o(101603);
            return false;
        } catch (Throwable th) {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e6) {
                    Log.printErrStackTrace("MicroMsg.Fav.FavCdnService", e6, "", new Object[0]);
                }
            }
            AppMethodBeat.o(101603);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final void ase(String str) {
        AppMethodBeat.i(101604);
        this.dAE = false;
        this.dAC.remove(str);
        pauseDownload(str);
        if (this.dAF > 0) {
            bck();
            AppMethodBeat.o(101604);
            return;
        }
        Log.i("MicroMsg.Fav.FavCdnService", "klem stopFlag <= 0 , Stop Service");
        aax();
        AppMethodBeat.o(101604);
    }

    static void h(c cVar) {
        AppMethodBeat.i(101605);
        if (cVar.field_type == 0) {
            b.b(cVar);
            AppMethodBeat.o(101605);
        } else if (cVar.field_type == 1) {
            b.c(cVar);
            AppMethodBeat.o(101605);
        } else {
            AppMethodBeat.o(101605);
        }
    }

    @Override // com.tencent.mm.plugin.fav.a.o
    public final void d(c cVar) {
        AppMethodBeat.i(101606);
        if (cVar != null) {
            this.dAA.add(cVar);
        }
        AppMethodBeat.o(101606);
    }

    static /* synthetic */ void a(c cVar, d dVar) {
        AppMethodBeat.i(101608);
        if (((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage() == null) {
            Log.e("MicroMsg.Fav.FavCdnService", "klem onCdnTranFinish getFavItemInfoStorage null!");
            AppMethodBeat.o(101608);
            return;
        }
        com.tencent.mm.plugin.fav.a.g DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(cVar.field_favLocalId);
        if (DY == null) {
            Log.e("MicroMsg.Fav.FavCdnService", "klem onCdnTranFinish item info null!");
            AppMethodBeat.o(101608);
            return;
        }
        Iterator<aml> it = DY.field_favProto.ppH.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            aml next = it.next();
            if (!cVar.field_dataId.equals(next.dLl)) {
                if (cVar.field_dataId.equals(b.arI(next.dLl))) {
                    next.bgi(cVar.field_cdnKey);
                    next.bgh(cVar.field_cdnUrl);
                    DY.field_xml = com.tencent.mm.plugin.fav.a.g.t(DY);
                    ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(DY, ch.COL_LOCALID);
                    Log.i("MicroMsg.Fav.FavCdnService", "klem onCdnTranFinish thumb key and url updated, md5:%s, cdnUrl:%s", cVar.field_dataId, cVar.field_cdnUrl);
                    break;
                }
            } else {
                next.bgk(cVar.field_cdnKey);
                next.bgj(cVar.field_cdnUrl);
                if (cVar.field_type == 0 && cVar.cUr()) {
                    Log.i("MicroMsg.Fav.FavCdnService", "video stream, id:%s", dVar.field_videoFileId);
                    next.bgy(dVar.field_videoFileId);
                }
                DY.field_xml = com.tencent.mm.plugin.fav.a.g.t(DY);
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(DY, ch.COL_LOCALID);
                Log.i("MicroMsg.Fav.FavCdnService", "klem onCdnTranFinish data key and url updated, md5:%s, cdnUrl:%s", cVar.field_dataId, cVar.field_cdnUrl);
            }
        }
        h(cVar);
        AppMethodBeat.o(101608);
    }
}
