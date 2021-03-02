package com.tencent.mm.plugin.priority.model.a.c;

import android.content.IntentFilter;
import android.net.TrafficStats;
import android.os.Process;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.an.f;
import com.tencent.mm.av.e;
import com.tencent.mm.av.g;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.pg;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.protocal.protobuf.ic;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ca;
import com.tencent.mm.util.c;
import java.util.Calendar;

public final class a implements e.a, com.tencent.mm.plugin.priority.a.a.a.b {
    public long AYM = 0;
    int AYN = 0;
    int AYO = 0;
    boolean AYP = false;
    long AYQ = 0;
    long AYR = 0;
    public IListener iWS = new IListener<pg>() {
        /* class com.tencent.mm.plugin.priority.model.a.c.a.AnonymousClass1 */

        {
            AppMethodBeat.i(161634);
            this.__eventId = pg.class.getName().hashCode();
            AppMethodBeat.o(161634);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(pg pgVar) {
            int i2;
            a aVar;
            String str;
            AppMethodBeat.i(87843);
            pg pgVar2 = pgVar;
            a aVar2 = a.this;
            int i3 = a.this.AYO;
            if (pgVar2.dVo.pause) {
                i2 = 1;
            } else {
                i2 = -1;
            }
            aVar2.AYO = i2 + i3;
            if (a.this.AYO < 0) {
                a.this.AYO = 0;
                Log.e("MicroMsg.Priority.C2CImgAutoDownloader", "pauseCnt < 0");
            }
            if (a.this.AYO == 0) {
                aVar = a.this;
                str = "";
            } else {
                aVar = a.this;
                if (pgVar2.dVo.pause) {
                    str = Util.nullAs(pgVar2.dVo.talker, a.this.talker);
                } else {
                    str = a.this.talker;
                }
            }
            aVar.talker = str;
            Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "req pause: %b count: %d talker %s", Boolean.valueOf(pgVar2.dVo.pause), Integer.valueOf(a.this.AYO), a.this.talker);
            a.this.start();
            AppMethodBeat.o(87843);
            return false;
        }
    };
    public String talker = "";
    int uid = Process.myUid();

    public a() {
        AppMethodBeat.i(87846);
        this.iWS.alive();
        this.AYN = R.drawable.c3h;
        AppMethodBeat.o(87846);
    }

    public final void start() {
        AppMethodBeat.i(87847);
        if (this.AYM != 0) {
            g H = q.bcR().H(this.talker, this.AYM);
            if (q.bcS().a(H.localId, this.AYM, H.iXp)) {
                Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "Downloading %d", Long.valueOf(this.AYM));
                AppMethodBeat.o(87847);
                return;
            }
            this.AYM = 0;
            if (H.fQW == 1) {
                Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "Not In DownloadImgService Queue, Already Downloaded, Force Cancel curMsgId %d", Long.valueOf(this.AYM));
                ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().R(this.AYM, 5);
            } else {
                Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "Not In DownloadImgService Queue, Not Downloaded, Force Cancel curMsgId %d", Long.valueOf(this.AYM));
                ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().R(this.AYM, 1);
            }
        }
        ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner().a(new C1579a(this, (byte) 0));
        AppMethodBeat.o(87847);
    }

    @Override // com.tencent.mm.av.e.a
    public final void a(long j2, long j3, int i2, int i3, Object obj, int i4, int i5, com.tencent.mm.ak.q qVar) {
    }

    @Override // com.tencent.mm.plugin.priority.a.a.a.b
    public final void b(long j2, long j3, boolean z) {
        AppMethodBeat.i(87848);
        if (!z) {
            Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "imglocalId " + j2 + " msglocalid " + j3 + " false");
            AppMethodBeat.o(87848);
        } else if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            Log.v("MicroMsg.Priority.C2CImgAutoDownloader", "is wifi pass count");
            AppMethodBeat.o(87848);
        } else {
            long nullAs = Util.nullAs((Long) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, (Object) null), 0);
            long safeParseLong = Util.safeParseLong((String) DateFormat.format("M", System.currentTimeMillis()));
            Log.d("MicroMsg.Priority.C2CImgAutoDownloader", "img " + j2 + " msgLocalId: " + j3 + " has been downloaded current %d month %d", Long.valueOf(1 + nullAs), Long.valueOf(safeParseLong));
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, Long.valueOf(nullAs + 1));
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_AUTOGETBIG_IMG_CURRENT_DATE_LONG, Long.valueOf(safeParseLong));
            AppMethodBeat.o(87848);
        }
    }

    @Override // com.tencent.mm.av.e.a
    public final void a(long j2, long j3, int i2, int i3, Object obj, int i4, int i5, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(87849);
        if (i4 == 0 && i5 == 0) {
            b(j2, j3, true);
            ((com.tencent.mm.plugin.comm.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).b(j3, true, false);
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 54, 1, false);
        } else {
            Log.e("MicroMsg.Priority.C2CImgAutoDownloader", "img " + j2 + "msgLocalId " + j3 + " download failed");
            ((com.tencent.mm.plugin.comm.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).b(j3, false, false);
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 53, 1, false);
        }
        this.AYM = 0;
        Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "normal download mode check network stat");
        this.AYP = true;
        this.AYQ = TrafficStats.getUidRxBytes(this.uid);
        this.AYR = TrafficStats.getUidTxBytes(this.uid);
        ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner().b(new b(this, (byte) 0));
        AppMethodBeat.o(87849);
    }

    @Override // com.tencent.mm.av.e.a
    public final void a(long j2, long j3, int i2, int i3, Object obj) {
        AppMethodBeat.i(87850);
        Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "onImgTaskCanceled %d", Long.valueOf(j3));
        this.AYM = 0;
        ((com.tencent.mm.plugin.comm.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).b(j3, false, true);
        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 57, 1, false);
        AppMethodBeat.o(87850);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.priority.model.a.c.a$a  reason: collision with other inner class name */
    public class C1579a extends com.tencent.mm.plugin.priority.model.b.a {
        private C1579a() {
        }

        /* synthetic */ C1579a(a aVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.priority.model.b.a
        public final String getName() {
            return "Priority.C2CImgAutoDownloaderTask";
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public final void run() {
            ic icVar;
            int i2;
            int a2;
            boolean z;
            AppMethodBeat.i(87844);
            if (!com.tencent.mm.plugin.priority.a.a.a.a.eCR()) {
                Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "not auto download condition");
                AppMethodBeat.o(87844);
            } else if (a.this.AYM != 0 || a.this.AYP) {
                Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "Downloading %d pauseOnMonitor %b", Long.valueOf(a.this.AYM), Boolean.valueOf(a.this.AYP));
                AppMethodBeat.o(87844);
            } else {
                float imgBorderPriority = ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getImgBorderPriority();
                float imgBgBorderPriority = ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getImgBgBorderPriority();
                int i3 = 0;
                b.a aVar = b.a.clicfg_mmc2c_chat_img_auto_download_flag;
                c cVar = c.QYz;
                if (!((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(aVar, c.hde())) {
                    if (!Util.isNullOrNil(a.this.talker)) {
                        icVar = ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().j(a.this.talker, imgBorderPriority);
                        i3 = 1;
                    } else {
                        icVar = null;
                    }
                    if (icVar == null) {
                        icVar = ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().bH(imgBorderPriority);
                        i3 = 2;
                    }
                    if (icVar == null) {
                        icVar = ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().eCZ();
                        i3 = 4;
                    }
                    if (icVar == null && a.eCY()) {
                        ic bG = ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().bG(imgBgBorderPriority);
                        Object[] objArr = new Object[1];
                        if (MMApplicationContext.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("plugged", -1) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        objArr[0] = Boolean.valueOf(z);
                        Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "bg normal download %b", objArr);
                        icVar = bG;
                        i2 = 3;
                    }
                    i2 = i3;
                } else {
                    int a3 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmc2c_chat_img_auto_download_rank, 10);
                    float a4 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmc2c_chat_img_auto_download_score, 10.0f);
                    if (!Util.isNullOrNil(a.this.talker)) {
                        icVar = ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().b(a.this.talker, a3, a4);
                        i3 = 5;
                    } else {
                        icVar = null;
                    }
                    if (icVar == null) {
                        icVar = ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().t(a3, a4);
                        i3 = 6;
                    }
                    if (icVar == null) {
                        icVar = ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().eCZ();
                        i3 = 4;
                    }
                    if (icVar == null && a.eCY()) {
                        icVar = ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().t(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmc2c_chat_img_auto_download_bg_rank, 20), ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmc2c_chat_img_auto_download_bg_score, 10.0f));
                        i2 = 7;
                    }
                    i2 = i3;
                }
                if (icVar == null) {
                    a.this.AYM = 0;
                    Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "autoDownloadRes is null");
                    AppMethodBeat.o(87844);
                    return;
                }
                a.this.AYM = icVar.KMm;
                Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "curMsgId %d priority %.2f prioritytype %d way %d borderPriority %.2f bgBorderPriority %.2f", Long.valueOf(a.this.AYM), Double.valueOf(icVar.KMj), Integer.valueOf(icVar.KMk), Integer.valueOf(i2), Float.valueOf(imgBorderPriority), Float.valueOf(imgBgBorderPriority));
                ca Hb = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(a.this.AYM);
                g G = q.bcR().G(Hb.field_talker, Hb.field_msgSvrId);
                if (G.fQW == 1) {
                    Log.i("MicroMsg.Priority.C2CImgAutoDownloader", a.this.AYM + " already has hd thumb");
                    ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().R(a.this.AYM, 5);
                    a.this.AYM = 0;
                    a.this.start();
                    AppMethodBeat.o(87844);
                    return;
                }
                f.baQ().iRE.add("image_" + Hb.field_msgId);
                if (Util.isNullOrNil(a.this.talker) || !a.this.talker.equals(Hb.field_talker)) {
                    a2 = q.bcS().a(G.localId, Hb.field_msgId, 0, Long.valueOf(a.this.AYM), a.this.AYN, a.this, 60000, false);
                    Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "start download cdnautostart %d %s result=%d", Long.valueOf(a.this.AYM), "image_" + Hb.field_msgId, Integer.valueOf(a2));
                } else {
                    a2 = q.bcS().a(G.localId, Hb.field_msgId, 0, Long.valueOf(a.this.AYM), a.this.AYN, a.this, 60000, true);
                    Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "start download cdnautostart %d %s %s result=%d", Long.valueOf(a.this.AYM), "image_" + Hb.field_msgId, a.this.talker, Integer.valueOf(a2));
                }
                switch (a2) {
                    case -4:
                    case -3:
                    case 0:
                        ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().R(a.this.AYM, 2);
                        if (i2 == 3) {
                            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 52, 1, false);
                            AppMethodBeat.o(87844);
                            return;
                        } else if (i2 == 1) {
                            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 50, 1, false);
                            AppMethodBeat.o(87844);
                            return;
                        } else if (i2 == 4) {
                            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 57, 1, false);
                            AppMethodBeat.o(87844);
                            return;
                        } else if (i2 == 5) {
                            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 58, 1, false);
                            AppMethodBeat.o(87844);
                            return;
                        } else if (i2 == 6) {
                            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 59, 1, false);
                            AppMethodBeat.o(87844);
                            return;
                        } else if (i2 == 7) {
                            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 60, 1, false);
                            AppMethodBeat.o(87844);
                            return;
                        } else {
                            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 51, 1, false);
                            AppMethodBeat.o(87844);
                            return;
                        }
                    case -2:
                        ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().R(a.this.AYM, 3);
                        if (i2 == 3) {
                            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 55, 1, false);
                        } else if (i2 == 7) {
                            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 61, 1, false);
                        }
                        a.this.AYM = 0;
                        a.this.start();
                        AppMethodBeat.o(87844);
                        return;
                    case -1:
                        ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().R(a.this.AYM, 4);
                        if (i2 == 3) {
                            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 56, 1, false);
                        } else if (i2 == 7) {
                            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 62, 1, false);
                        }
                        a.this.AYM = 0;
                        a.this.start();
                        break;
                }
                AppMethodBeat.o(87844);
            }
        }
    }

    public static boolean eCY() {
        AppMethodBeat.i(87851);
        if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            AppMethodBeat.o(87851);
            return false;
        }
        Calendar instance = Calendar.getInstance();
        int i2 = instance.get(11);
        int i3 = instance.get(12);
        if (i2 == 1) {
            com.tencent.mm.kernel.g.aAf();
            if (i3 >= Math.abs(com.tencent.mm.kernel.a.getUin()) % 30) {
                AppMethodBeat.o(87851);
                return true;
            }
            AppMethodBeat.o(87851);
            return false;
        } else if (i2 < 2 || i2 > 6) {
            AppMethodBeat.o(87851);
            return false;
        } else {
            AppMethodBeat.o(87851);
            return true;
        }
    }

    class b extends com.tencent.mm.plugin.priority.model.b.a {
        private b() {
        }

        /* synthetic */ b(a aVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.priority.model.b.a
        public final String getName() {
            return "Priority.CheckNetworkNetStatTask";
        }

        public final void run() {
            AppMethodBeat.i(87845);
            long uidRxBytes = TrafficStats.getUidRxBytes(a.this.uid);
            long uidTxBytes = TrafficStats.getUidTxBytes(a.this.uid);
            long j2 = (uidRxBytes - a.this.AYQ) + (uidTxBytes - a.this.AYR);
            if (j2 <= 20480) {
                a.this.AYP = false;
                a.this.start();
                AppMethodBeat.o(87845);
                return;
            }
            Log.i("MicroMsg.Priority.C2CImgAutoDownloader", "byteDelta %d", Long.valueOf(j2));
            a.this.AYQ = uidRxBytes;
            a.this.AYR = uidTxBytes;
            ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner().b(new b());
            AppMethodBeat.o(87845);
        }
    }
}
