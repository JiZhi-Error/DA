package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Looper;
import android.os.Process;
import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bk.e;
import com.tencent.mm.bk.g;
import com.tencent.mm.compatible.i.a;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.bp;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class m extends Thread {
    private static int gsi;
    private static HashMap<String, b> qQI = new HashMap<>();
    private static Object qQJ = new byte[0];
    private static QueueWorkerThread qQK;
    private int JVd;
    private a JVe;
    private Context context;
    private Intent intent;
    private boolean isStop;
    private List<String> qQA;
    private List<String> qQB;
    private List<Integer> qQC;
    private List<String> qQy;
    private List<Integer> qQz;
    private String talker;
    private int[] vRR = new int[29];

    public interface a {
        void gmA();
    }

    static /* synthetic */ void gC(String str, int i2) {
        AppMethodBeat.i(127166);
        gA(str, i2);
        AppMethodBeat.o(127166);
    }

    static /* synthetic */ void h(boolean z, String str, String str2) {
        AppMethodBeat.i(127167);
        g(z, str, str2);
        AppMethodBeat.o(127167);
    }

    static {
        AppMethodBeat.i(127169);
        AppMethodBeat.o(127169);
    }

    public m(Context context2, List<String> list, Intent intent2, String str, int i2, a aVar) {
        AppMethodBeat.i(127144);
        this.context = context2;
        this.qQy = list;
        this.intent = intent2;
        this.qQz = new ArrayList();
        this.qQA = new ArrayList();
        this.qQB = new ArrayList();
        this.qQC = new ArrayList();
        this.JVe = aVar;
        this.talker = str;
        this.JVd = i2;
        AppMethodBeat.o(127144);
    }

    public final void run() {
        AppMethodBeat.i(127145);
        if (this.qQy == null || this.qQy.size() <= 0) {
            av(this.context, this.intent);
        } else {
            for (int i2 = 0; i2 < this.qQy.size() && !this.isStop; i2++) {
                Log.i("MicroMsg.ImportMultiVideo", "start to import %s", this.qQy.get(i2));
                Intent intent2 = new Intent();
                intent2.setData(Uri.parse("file://" + this.qQy.get(i2)));
                av(this.context, intent2);
            }
        }
        if (this.JVe != null && !this.isStop) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.pluginsdk.model.m.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(127141);
                    a aVar = m.this.JVe;
                    List unused = m.this.qQz;
                    List unused2 = m.this.qQA;
                    List unused3 = m.this.qQB;
                    List unused4 = m.this.qQC;
                    aVar.gmA();
                    AppMethodBeat.o(127141);
                }
            });
        }
        AppMethodBeat.o(127145);
    }

    private void av(Context context2, Intent intent2) {
        int i2;
        boolean z;
        a.C0304a aVar;
        AppMethodBeat.i(127146);
        String Qv = t.Qv(this.talker);
        o.bhj();
        String Qx = t.Qx(Qv);
        o.bhj();
        String Qw = t.Qw(Qv);
        int i3 = 0;
        VideoTransPara videoTransPara = null;
        boolean is2G = NetStatusUtil.is2G(MMApplicationContext.getContext());
        String i4 = com.tencent.mm.compatible.i.a.i(context2, intent2);
        if (Util.isNullOrNil(i4)) {
            Log.e("MicroMsg.ImportMultiVideo", "GetVideoMetadata filed.");
            a(-50005, Qv, i4, 0, (VideoTransPara) null, intent2);
            AppMethodBeat.o(127146);
            return;
        }
        boolean Sx = c.Sx(i4);
        int boW = (int) s.boW(i4);
        if (Sx) {
            Log.i("MicroMsg.ImportMultiVideo", "mp4 format: %s", Boolean.valueOf(Sx));
            PInt pInt = new PInt();
            videoTransPara = a(i4, pInt);
            i2 = pInt.value;
        } else {
            if (boW > (is2G ? 10485760 : z.gmL())) {
                i2 = -5;
            } else {
                Log.i("MicroMsg.ImportMultiVideo", "mp4 format: %s", Boolean.valueOf(Sx));
                i2 = 1;
            }
        }
        Log.i("MicroMsg.ImportMultiVideo", "check remuxing, ret %d isMp4 %b length %d config:%s", Integer.valueOf(i2), Boolean.valueOf(Sx), Integer.valueOf(boW), Integer.valueOf(z.gmL()));
        switch (i2) {
            case -6:
            case -4:
            case -3:
            case -2:
                a(-50002, Qv, i4, 0, (VideoTransPara) null, intent2);
                AppMethodBeat.o(127146);
                return;
            case -5:
                a(-50008, Qv, i4, 0, (VideoTransPara) null, intent2);
                AppMethodBeat.o(127146);
                return;
            case -1:
                a(-50007, Qv, i4, 0, (VideoTransPara) null, intent2);
                AppMethodBeat.o(127146);
                return;
            case 0:
                z = true;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                if (boW <= z.gmL()) {
                    z = false;
                    break;
                } else {
                    a(-50002, Qv, i4, 0, (VideoTransPara) null, intent2);
                    AppMethodBeat.o(127146);
                    return;
                }
            default:
                Log.e("MicroMsg.ImportMultiVideo", "unknown check type");
                a(-50001, Qv, i4, 0, (VideoTransPara) null, intent2);
                AppMethodBeat.o(127146);
                return;
        }
        try {
            aVar = com.tencent.mm.compatible.i.a.j(context2, intent2);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ImportMultiVideo", e2, "", new Object[0]);
            aVar = null;
        }
        if (aVar == null) {
            Log.e("MicroMsg.ImportMultiVideo", "GetVideoMetadata filed.");
            a(-50005, Qv, i4, 0, (VideoTransPara) null, intent2);
            AppMethodBeat.o(127146);
            return;
        }
        if (!z) {
            s.nw(i4, Qw);
            gA(Qw, this.JVd);
            g(false, i4, Qw);
        } else {
            i3 = -50006;
        }
        int videoMsToSec = Util.videoMsToSec((long) aVar.duration);
        boolean z2 = true;
        if (aVar.bitmap != null) {
            try {
                BitmapUtil.saveBitmapToImage(aVar.bitmap, 60, Bitmap.CompressFormat.JPEG, Qx, true);
                z2 = false;
                zI(true);
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.ImportMultiVideo", e3, "", new Object[0]);
            }
        }
        if (z2) {
            try {
                zI(false);
                BitmapUtil.saveBitmapToImage(BitmapUtil.createColorBitmap(WebView.NIGHT_MODE_COLOR, 320, 480), 60, Bitmap.CompressFormat.JPEG, Qx, true);
            } catch (Exception e4) {
                Log.printErrStackTrace("MicroMsg.ImportMultiVideo", e4, "", new Object[0]);
            }
        }
        if (!z && !s.YS(Qw)) {
            i3 = -50003;
        }
        if (!s.YS(Qx)) {
            i3 = -50004;
        }
        a(i3, Qv, i4, videoMsToSec, videoTransPara, intent2);
        AppMethodBeat.o(127146);
    }

    public final void gmu() {
        AppMethodBeat.i(127147);
        this.isStop = true;
        interrupt();
        AppMethodBeat.o(127147);
    }

    private void a(int i2, String str, String str2, int i3, VideoTransPara videoTransPara, Intent intent2) {
        AppMethodBeat.i(127148);
        Log.i("MicroMsg.ImportMultiVideo", "finish to import %s to %s | ret %d | duration %d", str2, str, Integer.valueOf(i2), Integer.valueOf(i3));
        d(i2, str, str2, i3);
        if (i2 == -50002) {
            gmw();
            a(this.talker, str, str2, intent2, i3, 141);
            AppMethodBeat.o(127148);
        } else if (i2 == -50008) {
            gmy();
            a(this.talker, str, str2, intent2, i3, 140);
            AppMethodBeat.o(127148);
        } else if (i2 == -50006) {
            b bVar = new b((byte) 0);
            synchronized (qQJ) {
                try {
                    qQI.put(str, bVar);
                } finally {
                    AppMethodBeat.o(127148);
                }
            }
            if (u.r(str, this.talker, str2) < 0) {
                a(this.talker, str, str2, intent2, i3, TbsListener.ErrorCode.NEEDDOWNLOAD_3);
                Log.e("MicroMsg.ImportMultiVideo", "prepare");
                synchronized (qQJ) {
                    try {
                        qQI.remove(str);
                    } finally {
                        AppMethodBeat.o(127148);
                    }
                }
                return;
            }
            if (qQK == null) {
                qQK = new QueueWorkerThread(5, "remuxing-thread-" + System.currentTimeMillis(), 1, Looper.getMainLooper());
            }
            bVar.fileName = str;
            bVar.jpP = str2;
            o.bhj();
            bVar.kTQ = t.Qw(str);
            bVar.JVd = this.JVd;
            bVar.toUser = this.talker;
            bVar.jsd = videoTransPara;
            bVar.vRR = this.vRR;
            bVar.zzJ = e.QW(str2);
            bVar.JVg = new g();
            qQK.add(bVar);
            AppMethodBeat.o(127148);
        } else if (i2 < 0) {
            gmx();
            a(this.talker, str, str2, intent2, i3, TbsListener.ErrorCode.NEEDDOWNLOAD_3);
            AppMethodBeat.o(127148);
        } else {
            u.c(str, i3, this.talker, str2);
            u.QG(str);
            int i4 = this.JVd == 1 ? 8 : 1;
            o.bhj();
            n.bhh().a(str2, t.Qw(str), this.talker, "", "", i4, 2);
            AppMethodBeat.o(127148);
        }
    }

    private void a(String str, String str2, String str3, Intent intent2, int i2, int i3) {
        AppMethodBeat.i(127149);
        ca caVar = new ca();
        caVar.setStatus(5);
        caVar.Cy(str);
        caVar.setCreateTime(bp.Kw(str));
        caVar.nv(1);
        caVar.Cz(str2);
        caVar.setType(43);
        long aC = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().aC(caVar);
        Log.i("MicroMsg.ImportMultiVideo", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", Long.valueOf(caVar.field_msgId), Long.valueOf(caVar.field_msgSvrId), caVar.field_talker, Integer.valueOf(caVar.getType()), Integer.valueOf(caVar.field_isSend), caVar.field_imgPath, Integer.valueOf(caVar.field_status), Long.valueOf(caVar.field_createTime));
        if (-1 == aC) {
            Log.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] :%s", str);
            AppMethodBeat.o(127149);
            return;
        }
        if (u.QN(str2) == null) {
            o.bhj();
            String Qx = t.Qx(str2);
            try {
                a.C0304a j2 = com.tencent.mm.compatible.i.a.j(this.context, intent2);
                if (j2 == null || j2.bitmap == null) {
                    BitmapUtil.saveBitmapToImage(BitmapUtil.createColorBitmap(WebView.NIGHT_MODE_COLOR, 320, 480), 60, Bitmap.CompressFormat.JPEG, Qx, true);
                } else {
                    i2 = Util.videoMsToSec((long) j2.duration);
                    BitmapUtil.saveBitmapToImage(j2.bitmap, 60, Bitmap.CompressFormat.JPEG, Qx, true);
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.ImportMultiVideo", e2, "", new Object[0]);
            }
            int Qy = t.Qy(Qx);
            o.bhj();
            int Qy2 = t.Qy(t.Qw(str2));
            com.tencent.mm.modelvideo.s sVar = new com.tencent.mm.modelvideo.s();
            sVar.fileName = str2;
            if (Qy2 <= 0) {
                Qy2 = 0;
            }
            sVar.iKP = Qy2;
            sVar.jsl = Qy;
            sVar.iFw = i2;
            sVar.dWq = str;
            sVar.jsh = (String) com.tencent.mm.kernel.g.aAh().azQ().get(2, "");
            sVar.createTime = Util.nowSecond();
            sVar.jsm = Util.nowSecond();
            sVar.jst = null;
            sVar.jpP = str3;
            if (!Util.isNullOrNil(str3)) {
                sVar.jsr = 1;
            }
            sVar.jsu = -1;
            sVar.status = i3;
            sVar.jso = (int) aC;
            if (!o.bhj().b(sVar)) {
                Log.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] localMsgId:%s", Long.valueOf(aC));
            }
        }
        AppMethodBeat.o(127149);
    }

    /* access modifiers changed from: package-private */
    public static final class b implements QueueWorkerThread.ThreadObject {
        int JVd;
        g JVg;
        String fileName;
        String jpP;
        VideoTransPara jsd;
        String kTQ;
        private int outputHeight;
        private int outputWidth;
        int qQP;
        private boolean qQQ;
        private int qQR;
        String toUser;
        int[] vRR;
        private boolean zzJ;

        private b() {
            this.qQR = 0;
            this.zzJ = false;
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        public final boolean doInBackground() {
            boolean z;
            AppMethodBeat.i(127142);
            synchronized (m.qQJ) {
                try {
                    z = !m.qQI.containsKey(this.fileName);
                } catch (Throwable th) {
                    AppMethodBeat.o(127142);
                    throw th;
                }
            }
            if (!z) {
                z = u.QN(this.fileName) == null;
            }
            if (z) {
                Log.w("MicroMsg.ImportMultiVideo", "remuxing job has been removed, filename %s", this.fileName);
                AppMethodBeat.o(127142);
                return true;
            }
            int unused = m.gsi = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcEncodeVideoEnable, WXHardCoderJNI.hcEncodeVideoDelay, WXHardCoderJNI.hcEncodeVideoCPU, WXHardCoderJNI.hcEncodeVideoIO, WXHardCoderJNI.hcEncodeVideoThr ? Process.myTid() : 0, WXHardCoderJNI.hcEncodeVideoTimeout, 603, WXHardCoderJNI.hcEncodeVideoAction, "MicroMsg.ImportMultiVideo");
            Log.i("MicroMsg.ImportMultiVideo", "hardcoder summerPerformance startPerformance: %s", Integer.valueOf(m.gsi));
            if (this.jsd == null || this.jsd.isDefault) {
                int[] iArr = new int[2];
                m.g(this.jpP, iArr);
                this.outputWidth = iArr[0];
                this.outputHeight = iArr[1];
            } else {
                this.outputWidth = this.jsd.width;
                this.outputHeight = this.jsd.height;
            }
            PString pString = new PString();
            PInt pInt = new PInt();
            if (!((com.tencent.mm.plugin.m.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.m.a.a.class)).aSV().a(this.jpP, pString, pInt) || s.nw(pString.value, this.kTQ) < 0) {
                long currentTicks = Util.currentTicks();
                boolean z2 = false;
                try {
                    d dVar = new d();
                    dVar.setDataSource(this.jpP);
                    int i2 = Util.getInt(dVar.extractMetadata(18), 0);
                    int i3 = Util.getInt(dVar.extractMetadata(19), 0);
                    this.qQP = Math.round(((float) Util.getInt(dVar.extractMetadata(9), 0)) / 1000.0f);
                    z2 = c.kz(i2, i3);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.ImportMultiVideo", e2, "", new Object[0]);
                }
                Log.i("MicroMsg.ImportMultiVideo", "forceMediaCodec :%s", Boolean.valueOf(z2));
                if (this.jsd != null) {
                    Log.i("MicroMsg.ImportMultiVideo", "remuxing new para %s", this.jsd);
                    if (com.tencent.mm.plugin.sight.base.c.Dmb) {
                        this.jsd.videoBitrate = (int) (((double) this.jsd.videoBitrate) * 0.915d);
                    }
                    if (this.zzJ || z2) {
                        h.INSTANCE.idkeyStat(354, 245, 1, false);
                        if (e.a(this.jpP, this.kTQ, this.jsd) < 0) {
                            h.INSTANCE.idkeyStat(354, 246, 1, false);
                        }
                    } else {
                        this.qQP = SightVideoJNI.remuxingVFS(this.jpP, this.kTQ, this.outputWidth, this.outputHeight, this.jsd.videoBitrate, this.jsd.iSV, 8, this.jsd.iSU, 25.0f, (float) this.jsd.fps, null, 0, com.tencent.mm.plugin.sight.base.c.Dmb, 0, 51);
                    }
                } else {
                    Log.w("MicroMsg.ImportMultiVideo", "remuxing but new para is null. %s", this.fileName);
                    if (com.tencent.mm.plugin.sight.base.c.Dmb) {
                        com.tencent.mm.plugin.sight.base.c.Dmd = (int) (((double) com.tencent.mm.plugin.sight.base.c.Dmd) * 0.915d);
                    }
                    if (this.zzJ || z2) {
                        this.jsd = new VideoTransPara();
                        this.jsd.width = this.outputWidth;
                        this.jsd.height = this.outputHeight;
                        this.jsd.videoBitrate = com.tencent.mm.plugin.sight.base.c.Dmd;
                        this.jsd.iSV = com.tencent.mm.plugin.sight.base.c.Dmc;
                        this.jsd.iSU = 2;
                        this.jsd.fps = (int) com.tencent.mm.plugin.sight.base.c.Dme;
                        this.jsd.duration = e.hj(this.jpP);
                        e.a(this.jpP, this.kTQ, this.jsd);
                    } else {
                        this.qQP = SightVideoJNI.remuxingVFS(this.jpP, this.kTQ, this.outputWidth, this.outputHeight, com.tencent.mm.plugin.sight.base.c.Dmd, com.tencent.mm.plugin.sight.base.c.Dmc, 8, 2, 25.0f, com.tencent.mm.plugin.sight.base.c.Dme, null, 0, com.tencent.mm.plugin.sight.base.c.Dmb, 0, 51);
                    }
                }
                this.qQR = (int) Util.ticksToNow(currentTicks);
                Log.i("MicroMsg.ImportMultiVideo", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", this.jpP, this.kTQ, Integer.valueOf(this.qQP), Integer.valueOf(this.outputWidth), Integer.valueOf(this.outputHeight));
                this.qQQ = this.qQP >= 0;
                PInt pInt2 = new PInt();
                PInt pInt3 = new PInt();
                if (this.qQP <= 0 && u.a(this.kTQ, pInt2, pInt3)) {
                    this.qQP = pInt2.value;
                }
                if (this.qQQ && (((this.jsd.iTh & 1) != 0 && !this.zzJ) || (((this.jsd.iTh & 2) != 0 && this.zzJ) || this.jsd.iTg == 1))) {
                    Log.i("MicroMsg.ImportMultiVideo", "hseasun:[hardcoder] hwenc qp add metadata flag", Integer.valueOf(m.gsi));
                    SightVideoJNI.addReportMetadata(this.kTQ, this.vRR, this.jsd.iTg, this.jsd.iTh);
                }
                if (!this.qQQ) {
                    Log.w("MicroMsg.ImportMultiVideo", "remuxing video error, copy source video to send.");
                    s.deleteFile(this.kTQ);
                    s.nw(this.jpP, this.kTQ);
                } else {
                    Log.i("MicroMsg.ImportMultiVideo", "remuxing video sucess,insert to media duplication storage");
                    try {
                        String name = new com.tencent.mm.vfs.o(this.kTQ).getName();
                        String str = this.kTQ + ".tmp";
                        PInt pInt4 = new PInt(0);
                        if (com.tencent.mm.plugin.a.e.b(this.kTQ, str, pInt4)) {
                            boolean deleteFile = s.deleteFile(this.kTQ);
                            com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(str);
                            Log.i("MicroMsg.ImportMultiVideo", "fast start success. delOld[%b] rename[%b] path[%s] target[%s]", Boolean.valueOf(deleteFile), Boolean.valueOf(s.bo(oVar.getParent() + FilePathGenerator.ANDROID_DIR_SEP, oVar.getName(), name)), aa.z(oVar.her()), this.kTQ);
                            h.INSTANCE.idkeyStat(354, 30, 1, false);
                        } else {
                            if (pInt4.value != 1) {
                                h.INSTANCE.idkeyStat(354, 31, 1, false);
                            } else {
                                h.INSTANCE.idkeyStat(354, 32, 1, false);
                                h.INSTANCE.a(13836, 600, Long.valueOf(Util.nowSecond()), this.kTQ);
                            }
                            Log.i("MicroMsg.ImportMultiVideo", "fast start fail. msg[%d] importpath[%s] targetPath[%s]", Integer.valueOf(pInt4.value), this.jpP, this.kTQ);
                        }
                        ((com.tencent.mm.plugin.m.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.m.a.a.class)).aSV().ar(this.jpP, this.kTQ, this.qQP);
                    } catch (Exception e3) {
                        Log.e("MicroMsg.ImportMultiVideo", "fast start exception e[%s]", e3.toString());
                    }
                }
                if (m.gsi != 0) {
                    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEncodeVideoEnable, m.gsi);
                    Log.i("MicroMsg.ImportMultiVideo", "hardcoder summerPerformance stopPerformance %s", Integer.valueOf(m.gsi));
                    int unused2 = m.gsi = 0;
                }
                AppMethodBeat.o(127142);
                return true;
            }
            Log.i("MicroMsg.ImportMultiVideo", "copy remuxing file success, do not remuxing again.");
            this.qQP = pInt.value;
            this.qQQ = true;
            AppMethodBeat.o(127142);
            return true;
        }

        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        public final boolean onPostExecute() {
            int i2;
            int i3;
            AppMethodBeat.i(127143);
            Log.i("MicroMsg.ImportMultiVideo", "onPostExecute");
            synchronized (m.qQJ) {
                try {
                    m.qQI.remove(this.fileName);
                } catch (Throwable th) {
                    AppMethodBeat.o(127143);
                    throw th;
                }
            }
            if (this.qQQ) {
                m.gB(this.kTQ, this.JVd);
            } else {
                m.gC(this.kTQ, this.JVd);
            }
            m.h(this.qQQ, this.jpP, this.kTQ);
            if (com.tencent.mm.plugin.sight.base.c.Dmb) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            m.b(i2, this.qQR, this.jpP, this.kTQ, this.qQP);
            if (this.JVd == 1) {
                i3 = 8;
            } else {
                i3 = 1;
            }
            n.bhh().a(this.jpP, this.kTQ, this.toUser, "", "", i3, this.qQQ ? 1 : 3);
            Log.i("MicroMsg.ImportMultiVideo", "updateVideo");
            u.u(this.fileName, this.qQP, 43);
            u.QG(this.fileName);
            AppMethodBeat.o(127143);
            return false;
        }
    }

    public static void d(String str, int[] iArr) {
        AppMethodBeat.i(127150);
        b(str, iArr, 640, 480);
        AppMethodBeat.o(127150);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void g(java.lang.String r9, int[] r10) {
        /*
        // Method dump skipped, instructions count: 194
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.model.m.g(java.lang.String, int[]):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(java.lang.String r8, int[] r9, int r10, int r11) {
        /*
        // Method dump skipped, instructions count: 185
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.model.m.b(java.lang.String, int[], int, int):void");
    }

    private synchronized void d(int i2, String str, String str2, int i3) {
        AppMethodBeat.i(127153);
        this.qQz.add(Integer.valueOf(i2));
        this.qQA.add(str);
        this.qQB.add(str2);
        this.qQC.add(Integer.valueOf(i3));
        AppMethodBeat.o(127153);
    }

    public static void gmv() {
        int size;
        AppMethodBeat.i(127154);
        synchronized (qQJ) {
            try {
                size = qQI.size();
                qQI.clear();
            } catch (Throwable th) {
                AppMethodBeat.o(127154);
                throw th;
            }
        }
        if (qQK == null) {
            Log.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, worker is null, setCount %d", Integer.valueOf(size));
            AppMethodBeat.o(127154);
            return;
        }
        Log.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, setCount %d, workerJobCount %d", Integer.valueOf(size), Integer.valueOf(qQK.getQueueSize()));
        qQK.clear();
        qQK = null;
        AppMethodBeat.o(127154);
    }

    public static boolean bdr(String str) {
        boolean containsKey;
        AppMethodBeat.i(127155);
        synchronized (qQJ) {
            try {
                containsKey = qQI.containsKey(str);
            } catch (Throwable th) {
                AppMethodBeat.o(127155);
                throw th;
            }
        }
        Log.i("MicroMsg.ImportMultiVideo", "check %s is remuxing, ret %B", str, Boolean.valueOf(containsKey));
        AppMethodBeat.o(127155);
        return containsKey;
    }

    public static void bds(String str) {
        boolean z = true;
        AppMethodBeat.i(127156);
        synchronized (qQJ) {
            try {
                if (qQI.remove(str) == null) {
                    z = false;
                }
                Log.i("MicroMsg.ImportMultiVideo", "remove remuxing job, filename %s, ret %B", str, Boolean.valueOf(z));
            } finally {
                AppMethodBeat.o(127156);
            }
        }
    }

    private int[] a(String str, VideoTransPara videoTransPara) {
        AppMethodBeat.i(240891);
        int[] iArr = {0, 0, 0};
        iArr[0] = videoTransPara.videoBitrate;
        iArr[1] = videoTransPara.width;
        iArr[2] = videoTransPara.height;
        if ((videoTransPara.iTg == 1 || videoTransPara.iTg == 2) && (videoTransPara.iTq == 2 || videoTransPara.iTq == 4 || videoTransPara.iTq == 1)) {
            this.vRR = AdaptiveAdjustBitrate.a(str, videoTransPara.height, videoTransPara.width, videoTransPara.fps, videoTransPara.videoBitrate, 10.0f, 0.0f, videoTransPara.iTq, videoTransPara.iTi, videoTransPara.iTj, videoTransPara.iTk, videoTransPara.iTl, videoTransPara.iTm, videoTransPara.iTn, videoTransPara.iTo, false);
            if (this.vRR != null) {
                iArr[0] = this.vRR[0] * 1000;
            }
            if (this.vRR[5] > 0) {
                iArr[1] = this.vRR[1];
                iArr[2] = this.vRR[2];
            }
            Log.i("MicroMsg.ImportMultiVideo", "ABA: Adaptive Bitrate Methods:videoBitrate [%d]  targetWidth [%d]  targetHeight [%d]", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(iArr[2]));
            o.bhk();
            com.tencent.mm.an.e.s(this.vRR);
            AppMethodBeat.o(240891);
            return iArr;
        }
        Log.i("MicroMsg.ImportMultiVideo", "c2c ABA: No use ABA algorithm");
        AppMethodBeat.o(240891);
        return iArr;
    }

    private VideoTransPara a(String str, PInt pInt) {
        int gmL;
        double apH;
        AppMethodBeat.i(127157);
        if (com.tencent.mm.modelcontrol.e.baZ().Oh(str)) {
            Log.i("MicroMsg.ImportMultiVideo", "check remuxing, this video had wx meta do not remuxing. %s ", str);
            pInt.value = 1;
            gmz();
            AppMethodBeat.o(127157);
            return null;
        }
        VideoTransPara QX = e.QX(str);
        Boolean valueOf = Boolean.valueOf(e.QW(str));
        Log.d("MicroMsg.ImportMultiVideo", "check remuxing old para %s", QX);
        VideoTransPara c2 = com.tencent.mm.modelcontrol.e.baZ().c(QX);
        if (c2 == null) {
            Log.i("MicroMsg.ImportMultiVideo", "get C2C album video para is null. old para %s", QX);
            pInt.value = -5;
            AppMethodBeat.o(127157);
            return null;
        }
        Log.d("MicroMsg.ImportMultiVideo", "check remuxing new para %s", c2);
        int[] a2 = a(str, c2);
        c2.videoBitrate = a2[0];
        c2.width = a2[1];
        c2.height = a2[2];
        if (QX.videoBitrate <= 640000 || c2.videoBitrate > QX.videoBitrate) {
            Log.i("MicroMsg.ImportMultiVideo", "new bitrate is bigger than old bitrate %s %s", c2, QX);
            if (valueOf.booleanValue()) {
                pInt.value = 0;
                AppMethodBeat.o(127157);
                return QX;
            }
            pInt.value = 1;
            AppMethodBeat.o(127157);
            return null;
        } else if (QX.fps < 45 || QX.duration * 1000 < 180000) {
            if (valueOf.booleanValue()) {
                pInt.value = 0;
            } else {
                boolean is2G = NetStatusUtil.is2G(MMApplicationContext.getContext());
                int i2 = c2.width;
                int i3 = c2.height;
                if (is2G) {
                    gmL = 10485760;
                } else {
                    gmL = z.gmL();
                }
                if (is2G) {
                    apH = 60000.0d;
                } else {
                    com.tencent.mm.n.a aVar = com.tencent.mm.n.a.gLV;
                    apH = (double) (com.tencent.mm.n.a.apH() * 1000);
                }
                pInt.value = SightVideoJNI.shouldRemuxingVFS(str, i2, i3, gmL, apH, 1000000);
            }
            AppMethodBeat.o(127157);
            return c2;
        } else {
            pInt.value = -6;
            AppMethodBeat.o(127157);
            return null;
        }
    }

    private void zI(boolean z) {
        int i2;
        AppMethodBeat.i(127158);
        if (this.JVd == 1) {
            if (z) {
                i2 = 217;
            } else {
                i2 = 218;
            }
        } else if (z) {
            i2 = 231;
        } else {
            i2 = 232;
        }
        Log.d("MicroMsg.ImportMultiVideo", "report video thumb reportId : " + i2 + " had Thumb : " + z + " importType : " + this.JVd);
        h.INSTANCE.idkeyStat(106, (long) i2, 1, false);
        AppMethodBeat.o(127158);
    }

    private void gmw() {
        int i2;
        AppMethodBeat.i(127159);
        if (this.JVd == 1) {
            i2 = 230;
        } else {
            i2 = 245;
        }
        Log.d("MicroMsg.ImportMultiVideo", "report video too big reportId : " + i2 + " importType : " + this.JVd);
        h.INSTANCE.idkeyStat(106, (long) i2, 1, false);
        AppMethodBeat.o(127159);
    }

    private void gmx() {
        int i2;
        AppMethodBeat.i(127160);
        if (this.JVd == 1) {
            i2 = 229;
        } else {
            i2 = 244;
        }
        Log.d("MicroMsg.ImportMultiVideo", "report video file error reportId : " + i2 + " importType : " + this.JVd);
        h.INSTANCE.idkeyStat(106, (long) i2, 1, false);
        AppMethodBeat.o(127160);
    }

    private static void gA(String str, int i2) {
        int i3;
        int i4;
        int i5;
        AppMethodBeat.i(127161);
        if (i2 == 1) {
            i3 = TbsListener.ErrorCode.COPY_INSTALL_SUCCESS;
            i4 = 228;
            i5 = 219;
        } else {
            i3 = TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_SUCCESS;
            i4 = 242;
            i5 = 233;
        }
        long boW = s.boW(str);
        int nullAsNil = Util.nullAsNil((Integer) h.a((int) (boW / 1024), new int[]{512, 1024, 2048, 5120, 8192, Task.EXTRAS_LIMIT_BYTES, 15360, 20480}, i3, i4));
        h.INSTANCE.idkeyStat(106, (long) nullAsNil, 1, false);
        h.INSTANCE.idkeyStat(106, (long) i5, 1, false);
        Log.d("MicroMsg.ImportMultiVideo", "report no compress video report id : " + nullAsNil + " file len : " + (boW / 1024) + "K");
        AppMethodBeat.o(127161);
    }

    private static void gmy() {
        AppMethodBeat.i(127162);
        h.INSTANCE.idkeyStat(106, 210, 1, false);
        AppMethodBeat.o(127162);
    }

    private static void gmz() {
        AppMethodBeat.i(127163);
        h.INSTANCE.idkeyStat(422, 51, 1, false);
        AppMethodBeat.o(127163);
    }

    private static void g(boolean z, String str, String str2) {
        AppMethodBeat.i(127164);
        com.tencent.mm.modelvideo.a.k(z ? 1 : 0, str, str2);
        AppMethodBeat.o(127164);
    }

    static /* synthetic */ void gB(String str, int i2) {
        AppMethodBeat.i(127165);
        if (i2 == 2) {
            long boW = s.boW(str);
            int nullAsNil = Util.nullAsNil((Integer) h.a((int) (boW / 1024), new int[]{512, 1024, 2048, 5120, 8192, Task.EXTRAS_LIMIT_BYTES, 15360, 20480}, 247, 255));
            h.INSTANCE.idkeyStat(106, (long) nullAsNil, 1, false);
            h.INSTANCE.idkeyStat(106, 246, 1, false);
            Log.d("MicroMsg.ImportMultiVideo", "report compress video report id : " + nullAsNil + " file len : " + (boW / 1024) + "K");
        }
        AppMethodBeat.o(127165);
    }

    static /* synthetic */ void b(int i2, int i3, String str, String str2, int i4) {
        AppMethodBeat.i(127168);
        long boW = s.boW(str);
        if (boW > 0) {
            long boW2 = s.boW(str2);
            int i5 = (int) ((100 * boW2) / boW);
            Log.i("MicroMsg.ImportMultiVideo", "kv report video compression isNew[%d], oriSize[%d], remuxingSize[%d], compressionRatio[%d], bitrate[%d], preset[%d], retDuration[%d]", Integer.valueOf(i2), Long.valueOf(boW), Long.valueOf(boW2), Integer.valueOf(i5), Integer.valueOf(i3), 0, Integer.valueOf(i4));
            h.INSTANCE.a(13432, Integer.valueOf(i2), Long.valueOf(boW), Long.valueOf(boW2), Integer.valueOf(i5), Integer.valueOf(i3), 0, Integer.valueOf(i4));
            AppMethodBeat.o(127168);
            return;
        }
        Log.e("MicroMsg.ImportMultiVideo", "file canot be empty");
        AppMethodBeat.o(127168);
    }
}
