package com.tencent.mm.plugin.priority;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.av.q;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.priority.model.a.a.a;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.ib;
import com.tencent.mm.protocal.protobuf.ic;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.o;
import com.tencent.tav.coremedia.TimeUtil;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public final class a implements com.tencent.mm.plugin.comm.a.b {
    @Override // com.tencent.mm.plugin.comm.a.b
    public final void b(long j2, boolean z, boolean z2) {
        AppMethodBeat.i(87786);
        if (com.tencent.mm.kernel.g.aAc() && ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner() != null) {
            ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner().a(new d(j2, z, z2));
        }
        AppMethodBeat.o(87786);
    }

    class d extends com.tencent.mm.plugin.priority.model.b.a {
        private boolean ifz;
        private boolean isSuccess;
        private long msgId;

        public d(long j2, boolean z, boolean z2) {
            this.msgId = j2;
            this.isSuccess = z;
            this.ifz = z2;
        }

        @Override // com.tencent.mm.plugin.priority.model.b.a
        public final String getName() {
            return "Priority.onC2CImgDownloadedTask";
        }

        public final void run() {
            AppMethodBeat.i(87782);
            ca Hb = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(this.msgId);
            if (Hb.field_createTime <= ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getInstallPriorityTime()) {
                Log.i("MicroMsg.Priority.PriorityService", "onC2CImgDownloaded time condition not support %s", com.tencent.mm.pluginsdk.i.f.formatTime(TimeUtil.YYYY2MM2DD_HH1MM1SS, Hb.field_createTime / 1000));
                AppMethodBeat.o(87782);
                return;
            }
            if (((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic() != null) {
                ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
                boolean z = this.isSuccess;
                boolean z2 = this.ifz;
                if (z) {
                    ic HM = ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().HM(Hb.field_msgId);
                    if (HM == null) {
                        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "sender img %d", Long.valueOf(Hb.field_msgId));
                        AppMethodBeat.o(87782);
                        return;
                    } else if (HM.oTW == 3) {
                        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "already auto download msgid %d", Long.valueOf(Hb.field_msgId));
                        AppMethodBeat.o(87782);
                        return;
                    } else {
                        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 20, 1, false);
                        if (HM != null) {
                            long currentTimeMillis = System.currentTimeMillis();
                            com.tencent.mm.av.g G = q.bcR().G(Hb.field_talker, HM.KMf);
                            HM.KMn = G.iKP;
                            com.tencent.mm.plugin.priority.model.c.a(1, currentTimeMillis, 0, HM);
                            com.tencent.mm.plugin.priority.model.a.c.c c2CMsgAutoDownloadImgStorage = ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage();
                            long j2 = HM.KMm;
                            int i2 = G.iKP;
                            c2CMsgAutoDownloadImgStorage.AYK.bindLong(1, currentTimeMillis);
                            c2CMsgAutoDownloadImgStorage.AYK.bindLong(2, 3);
                            c2CMsgAutoDownloadImgStorage.AYK.bindLong(3, (long) i2);
                            c2CMsgAutoDownloadImgStorage.AYK.bindLong(4, j2);
                            Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "updateStatusAndDownloadTime %d res %d %d %d", Integer.valueOf(c2CMsgAutoDownloadImgStorage.AYK.executeUpdateDelete()), Long.valueOf(j2), Long.valueOf(currentTimeMillis), 3);
                            if (com.tencent.mm.plugin.priority.a.a.a.hL(HM.KMd, 1)) {
                                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 21, 1, false);
                                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 22, (long) G.iKP, false);
                            }
                            if (com.tencent.mm.plugin.priority.a.a.a.hL(HM.KMd, 8)) {
                                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 23, 1, false);
                                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 24, (long) G.iKP, false);
                            }
                            if (com.tencent.mm.plugin.priority.a.a.a.hL(HM.KMd, 2) || com.tencent.mm.plugin.priority.a.a.a.hL(HM.KMd, 4)) {
                                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 25, 1, false);
                                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 26, (long) G.iKP, false);
                            }
                            if (com.tencent.mm.plugin.priority.a.a.a.hL(HM.KMd, 16)) {
                                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 27, 1, false);
                                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 28, (long) G.iKP, false);
                            }
                            if (com.tencent.mm.plugin.priority.a.a.a.hL(HM.KMd, 32)) {
                                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 29, 1, false);
                                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 30, (long) G.iKP, false);
                            }
                            if (com.tencent.mm.plugin.priority.a.a.a.hL(HM.KMd, 64)) {
                                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 33, 1, false);
                                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 34, (long) G.iKP, false);
                            }
                            if (com.tencent.mm.plugin.priority.a.a.a.hL(HM.KMd, 128)) {
                                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 35, 1, false);
                                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 36, (long) G.iKP, false);
                            }
                            AppMethodBeat.o(87782);
                            return;
                        }
                        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 31, 1, false);
                        AppMethodBeat.o(87782);
                        return;
                    }
                } else {
                    if (z2) {
                        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "updateStatus download cancel %d", Long.valueOf(Hb.field_msgId));
                        ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().R(Hb.field_msgId, 1);
                    } else {
                        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "updateStatus download fail %d", Long.valueOf(Hb.field_msgId));
                        ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().R(Hb.field_msgId, 4);
                    }
                    com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 32, 1, false);
                }
            }
            AppMethodBeat.o(87782);
        }
    }

    @Override // com.tencent.mm.plugin.comm.a.b
    public final void as(ca caVar) {
        AppMethodBeat.i(87787);
        if (com.tencent.mm.kernel.g.aAc() && ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner() != null) {
            ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner().a(new e(caVar));
        }
        AppMethodBeat.o(87787);
    }

    class e extends com.tencent.mm.plugin.priority.model.b.a {
        private ca dTX;

        public e(ca caVar) {
            this.dTX = caVar;
        }

        @Override // com.tencent.mm.plugin.priority.model.b.a
        public final String getName() {
            return "Priority.onC2CImgOpenTask";
        }

        public final void run() {
            int i2;
            AppMethodBeat.i(87783);
            if (this.dTX.field_createTime <= ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getInstallPriorityTime()) {
                Log.i("MicroMsg.Priority.PriorityService", "onC2CImgOpen time condition not support %s", com.tencent.mm.pluginsdk.i.f.formatTime(TimeUtil.YYYY2MM2DD_HH1MM1SS, this.dTX.field_createTime / 1000));
                AppMethodBeat.o(87783);
                return;
            }
            if (((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic() != null) {
                ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
                ca caVar = this.dTX;
                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 10, 1, false);
                ic HM = ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().HM(caVar.field_msgId);
                if (HM == null) {
                    Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "This Image Sender is Me");
                    com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 13, 1, false);
                    AppMethodBeat.o(87783);
                    return;
                } else if (HM.KMi > 0) {
                    Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "onImgOpen img already use %d", Long.valueOf(caVar.field_msgId));
                    AppMethodBeat.o(87783);
                    return;
                } else {
                    if (ab.Eq(caVar.field_talker)) {
                        ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgImgUsageStorage().jq(HM.KLZ, "@all");
                    }
                    ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgImgUsageStorage().jq(HM.KLZ, HM.KMa);
                    HM.KMi = System.currentTimeMillis();
                    com.tencent.mm.plugin.priority.model.a.c.c c2CMsgAutoDownloadImgStorage = ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage();
                    long j2 = caVar.field_msgId;
                    long j3 = HM.KMi;
                    c2CMsgAutoDownloadImgStorage.AYL.bindLong(1, j3);
                    c2CMsgAutoDownloadImgStorage.AYL.bindLong(2, j2);
                    Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "updateOpenTime %d res %d %d", Integer.valueOf(c2CMsgAutoDownloadImgStorage.AYL.executeUpdateDelete()), Long.valueOf(j2), Long.valueOf(j3));
                    if (HM.oTW == 3) {
                        i2 = 1;
                        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 14, 1, false);
                    } else if (HM.oTW == 2) {
                        i2 = 3;
                        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 16, 1, false);
                    } else if (HM.oTW == 4) {
                        i2 = 4;
                        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 17, 1, false);
                    } else if (HM.oTW == 5) {
                        i2 = 5;
                        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 18, 1, false);
                    } else {
                        i2 = 2;
                        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(957, 15, 1, false);
                    }
                    com.tencent.mm.plugin.priority.model.c.a(2, HM.KMi, i2, HM);
                }
            }
            AppMethodBeat.o(87783);
        }
    }

    @Override // com.tencent.mm.plugin.comm.a.b
    public final void at(ca caVar) {
        AppMethodBeat.i(87788);
        if (com.tencent.mm.kernel.g.aAc() && ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner() != null) {
            ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner().a(new com.tencent.mm.plugin.priority.model.b.b(caVar));
        }
        AppMethodBeat.o(87788);
    }

    @Override // com.tencent.mm.plugin.comm.a.b
    public final void a(ca caVar, Runnable runnable) {
        AppMethodBeat.i(87789);
        if (com.tencent.mm.kernel.g.aAc() && ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner() != null) {
            ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner().a(new f(caVar, new WeakReference(runnable)));
        }
        AppMethodBeat.o(87789);
    }

    class f extends com.tencent.mm.plugin.priority.model.b.a {
        private WeakReference<Runnable> AYh;
        private ca dTX;

        f(ca caVar, WeakReference<Runnable> weakReference) {
            this.dTX = caVar;
            this.AYh = weakReference;
        }

        @Override // com.tencent.mm.plugin.priority.model.b.a
        public final String getName() {
            return "Priority.onC2CImgScrollTask";
        }

        public final void run() {
            AppMethodBeat.i(87784);
            if (this.dTX.field_createTime <= ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getInstallPriorityTime()) {
                Log.i("MicroMsg.Priority.PriorityService", "onC2CImgScroll time condition not support %s", com.tencent.mm.pluginsdk.i.f.formatTime(TimeUtil.YYYY2MM2DD_HH1MM1SS, this.dTX.field_createTime / 1000));
                AppMethodBeat.o(87784);
                return;
            }
            Log.i("MicroMsg.Priority.PriorityService", "C2CImgScrollTask Start To Auto Download %d MsgId %d", 32, Long.valueOf(this.dTX.field_msgId));
            if (this.AYh.get() != null) {
                this.AYh.get().run();
            }
            ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
            ca caVar = this.dTX;
            ic HM = ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().HM(caVar.field_msgId);
            if (HM == null) {
                Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "This Image Sender is Me");
                AppMethodBeat.o(87784);
                return;
            }
            if (HM.oTW == 1) {
                ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().m(caVar.field_msgId, 32, 2);
            }
            AppMethodBeat.o(87784);
        }
    }

    @Override // com.tencent.mm.plugin.comm.a.b
    public final void a(boolean z, String str, long j2, boolean z2) {
        AppMethodBeat.i(87790);
        if (com.tencent.mm.kernel.g.aAc() && ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner() != null) {
            ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner().a(new C1576a(z, str, j2, z2));
        }
        AppMethodBeat.o(87790);
    }

    @Override // com.tencent.mm.plugin.comm.a.b
    public final void Z(String str, long j2) {
        AppMethodBeat.i(87791);
        if (com.tencent.mm.kernel.g.aAc() && ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner() != null) {
            ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner().a(new b(str, j2));
        }
        AppMethodBeat.o(87791);
    }

    @Override // com.tencent.mm.plugin.comm.a.b
    public final void au(ca caVar) {
        AppMethodBeat.i(87792);
        if (com.tencent.mm.kernel.g.aAc() && ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner() != null) {
            ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner().a(new c(caVar));
        }
        AppMethodBeat.o(87792);
    }

    class c extends com.tencent.mm.plugin.priority.model.b.a {
        private ca dTX;

        @Override // com.tencent.mm.plugin.priority.model.b.a
        public final String getName() {
            return "C2CFileReceiveTask";
        }

        public c(ca caVar) {
            this.dTX = caVar;
        }

        public final void run() {
            String str;
            String str2;
            double[] jr;
            int jt;
            AppMethodBeat.i(87781);
            if (this.dTX.field_createTime <= ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getInstallPriorityTime()) {
                Log.i("MicroMsg.Priority.PriorityService", "onC2CFileReceive time condition not support %s", com.tencent.mm.pluginsdk.i.f.formatTime(TimeUtil.YYYY2MM2DD_HH1MM1SS, this.dTX.field_createTime / 1000));
                AppMethodBeat.o(87781);
                return;
            }
            if (((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic() != null) {
                ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic();
                ca caVar = this.dTX;
                String str3 = caVar.field_talker;
                if (!ab.Eq(caVar.field_talker) || caVar.field_isSend != 0) {
                    str = caVar.field_content;
                    str2 = str3;
                } else {
                    str = bp.Kt(caVar.field_content);
                    str2 = Util.nullAs(bp.Ks(caVar.field_content), "");
                }
                k.b HD = k.b.HD(str);
                if (HD == null) {
                    Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "appMsgContent is null");
                    AppMethodBeat.o(87781);
                    return;
                }
                if (!ab.Eq(caVar.field_talker) || caVar.field_isSend != 0) {
                    jr = ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgFileUsageStorage().jr(caVar.field_talker, caVar.field_talker);
                    jt = ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgFileUsageStorage().jt(caVar.field_talker, caVar.field_talker);
                } else {
                    jr = ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgFileUsageStorage().jr(caVar.field_talker, "@all");
                    jt = ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgFileUsageStorage().jt(caVar.field_talker, "@all");
                }
                double max = Math.max(Math.max(jr[0], jr[1]), jr[2]);
                if (HD.type == 6) {
                    String valueOf = String.valueOf(caVar.field_msgId);
                    if (((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().be(valueOf, caVar.field_msgSvrId)) {
                        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "file already exist msg %s %s", Long.valueOf(caVar.field_msgId), Long.valueOf(caVar.field_msgSvrId));
                        AppMethodBeat.o(87781);
                        return;
                    }
                    ib ibVar = new ib();
                    ibVar.Id = valueOf;
                    ibVar.KLZ = caVar.field_talker;
                    ibVar.KMa = str2;
                    ibVar.KMb = 2;
                    ibVar.KMc = caVar.field_createTime;
                    ibVar.KMd = jt < 2 ? 1 : 0;
                    ibVar.oTW = 1;
                    ibVar.KMe = 0;
                    ibVar.KMf = caVar.field_msgSvrId;
                    ibVar.KMg = (long) HD.iwI;
                    ibVar.KMh = HD.iwJ;
                    ibVar.KMj = max;
                    ibVar.KMk = 1;
                    ibVar.KMl = HD.dCK;
                    com.tencent.mm.pluginsdk.model.app.c bdx = com.tencent.mm.plugin.r.a.cgO().bdx(HD.dCK);
                    if (bdx != null) {
                        o oVar = new o(bdx.field_fileFullPath);
                        if (oVar.exists() && oVar.length() == bdx.field_totalLen) {
                            ibVar.KMe = System.currentTimeMillis();
                            ibVar.oTW = 6;
                        }
                    }
                    Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "insert auto download file %s %s %s %s %.2f", ibVar.KLZ, Util.getSizeMB(ibVar.KMg), ibVar.KMh, Integer.valueOf(ibVar.KMd), Double.valueOf(ibVar.KMj));
                    ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().a(ibVar);
                    if (ab.Eq(ibVar.KLZ)) {
                        ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgFileUsageStorage().jp(ibVar.KLZ, "@all");
                    }
                    ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgFileUsageStorage().jp(ibVar.KLZ, ibVar.KMa);
                    com.tencent.mm.plugin.priority.model.c.a(3, System.currentTimeMillis(), ibVar.oTW, ibVar);
                    AppMethodBeat.o(87781);
                    return;
                } else if (HD.type == 19) {
                    Iterator<aml> it = p.aKY(HD.ixl).iAd.iterator();
                    while (it.hasNext()) {
                        aml next = it.next();
                        if (next.dataType == 8) {
                            String str4 = next.dLl;
                            if (((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().be(str4, caVar.field_msgSvrId)) {
                                Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "file already exist msg %s %s", str4, Long.valueOf(caVar.field_msgSvrId));
                            } else {
                                ib ibVar2 = new ib();
                                ibVar2.Id = str4;
                                ibVar2.KLZ = caVar.field_talker;
                                ibVar2.KMa = str2;
                                ibVar2.KMb = 3;
                                ibVar2.KMc = caVar.field_createTime;
                                ibVar2.KMd = jt < 2 ? 1 : 0;
                                ibVar2.oTW = 1;
                                ibVar2.KMe = 0;
                                ibVar2.KMf = caVar.field_msgSvrId;
                                ibVar2.KMg = next.LvI;
                                ibVar2.KMh = next.LvC;
                                ibVar2.KMj = max;
                                ibVar2.KMk = 1;
                                ibVar2.KMl = next.KuR;
                                Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "insert auto download file %s %s %s %s %.2f", ibVar2.KLZ, Util.getSizeMB(ibVar2.KMg), ibVar2.KMh, Integer.valueOf(ibVar2.KMd), Double.valueOf(ibVar2.KMj));
                                ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().a(ibVar2);
                                if (ab.Eq(ibVar2.KLZ)) {
                                    ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgFileUsageStorage().jp(ibVar2.KLZ, "@all");
                                }
                                ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgFileUsageStorage().jp(ibVar2.KLZ, ibVar2.KMa);
                                com.tencent.mm.plugin.priority.model.c.a(3, System.currentTimeMillis(), ibVar2.oTW, ibVar2);
                            }
                        }
                    }
                }
            }
            AppMethodBeat.o(87781);
        }
    }

    class b extends com.tencent.mm.plugin.priority.model.b.a {
        private long dTS;
        private String id;

        public b(String str, long j2) {
            this.id = str;
            this.dTS = j2;
        }

        @Override // com.tencent.mm.plugin.priority.model.b.a
        public final String getName() {
            return "Priority.C2CFileOpenTask";
        }

        public final void run() {
            AppMethodBeat.i(87780);
            if (((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic() != null) {
                ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic();
                String str = this.id;
                long j2 = this.dTS;
                ib bf = ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().bf(str, j2);
                if (bf == null) {
                    Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "This File Sender is Me");
                    AppMethodBeat.o(87780);
                    return;
                } else if (bf.KMi > 0) {
                    Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "onFileOpen file already use %s %s", str, Long.valueOf(j2));
                    AppMethodBeat.o(87780);
                    return;
                } else {
                    if (ab.Eq(bf.KLZ)) {
                        ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgFileUsageStorage().jq(bf.KLZ, "@all");
                    }
                    ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgFileUsageStorage().jq(bf.KLZ, bf.KMa);
                    bf.KMi = System.currentTimeMillis();
                    com.tencent.mm.plugin.priority.model.a.b.c c2CMsgAutoDownloadFileStorage = ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage();
                    long j3 = bf.KMi;
                    c2CMsgAutoDownloadFileStorage.AYL.bindLong(1, j3);
                    c2CMsgAutoDownloadFileStorage.AYL.bindString(2, str);
                    c2CMsgAutoDownloadFileStorage.AYL.bindLong(3, j2);
                    Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "updateOpenTime %s res %s %s %s", Integer.valueOf(c2CMsgAutoDownloadFileStorage.AYL.executeUpdateDelete()), str, Long.valueOf(j2), Long.valueOf(j3));
                    com.tencent.mm.plugin.priority.model.c.a(2, System.currentTimeMillis(), bf.oTW, bf);
                }
            }
            AppMethodBeat.o(87780);
        }
    }

    @Override // com.tencent.mm.plugin.comm.a.b
    public final void akR(String str) {
        AppMethodBeat.i(87793);
        cV(str, 1);
        AppMethodBeat.o(87793);
    }

    @Override // com.tencent.mm.plugin.comm.a.b
    public final void cV(String str, int i2) {
        AppMethodBeat.i(174312);
        if (com.tencent.mm.kernel.g.aAc() && ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner() != null) {
            ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner().a(new g(str, i2));
        }
        AppMethodBeat.o(174312);
    }

    /* access modifiers changed from: package-private */
    public class g extends com.tencent.mm.plugin.priority.model.b.a {
        private String AYi;
        private int score;

        public g(String str, int i2) {
            this.AYi = str;
            this.score = i2;
        }

        @Override // com.tencent.mm.plugin.priority.model.b.a
        public final String getName() {
            return "Priority.C2CMsgConsumeTask";
        }

        public final void run() {
            AppMethodBeat.i(87785);
            if (((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CChatUsageLogic() != null) {
                ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getPriorityTaskRunner().a(new a.C1577a(this.AYi, this.score, (byte) 0));
            }
            AppMethodBeat.o(87785);
        }
    }

    /* renamed from: com.tencent.mm.plugin.priority.a$a  reason: collision with other inner class name */
    class C1576a extends com.tencent.mm.plugin.priority.model.b.a {
        private long dTS;
        private String id;
        private boolean ifz = false;
        private boolean isSuccess;
        private boolean qJf;

        public C1576a(boolean z, String str, long j2, boolean z2) {
            this.qJf = z;
            this.id = str;
            this.dTS = j2;
            this.isSuccess = z2;
        }

        @Override // com.tencent.mm.plugin.priority.model.b.a
        public final String getName() {
            return "Priority.onC2CFileDownloadedTask";
        }

        public final void run() {
            int i2;
            AppMethodBeat.i(87779);
            if (((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic() != null) {
                ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileLogic();
                boolean z = this.qJf;
                String str = this.id;
                long j2 = this.dTS;
                boolean z2 = this.isSuccess;
                boolean z3 = this.ifz;
                if (z2) {
                    ib bf = ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().bf(str, j2);
                    if (bf == null) {
                        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "sender file %s %s", str, Long.valueOf(j2));
                        AppMethodBeat.o(87779);
                        return;
                    } else if (bf.oTW == 1 || bf.oTW == 2 || bf.oTW == 4) {
                        if (!z) {
                            i2 = 5;
                        } else {
                            i2 = 3;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        com.tencent.mm.plugin.priority.model.c.a(1, currentTimeMillis, i2, bf);
                        com.tencent.mm.plugin.priority.model.a.b.c c2CMsgAutoDownloadFileStorage = ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage();
                        String str2 = bf.Id;
                        long j3 = bf.KMf;
                        c2CMsgAutoDownloadFileStorage.AYK.bindLong(1, currentTimeMillis);
                        c2CMsgAutoDownloadFileStorage.AYK.bindLong(2, (long) i2);
                        c2CMsgAutoDownloadFileStorage.AYK.bindString(3, str2);
                        c2CMsgAutoDownloadFileStorage.AYK.bindLong(4, j3);
                        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "updateStatusAndDownloadTime %s res %s %s %s %s", Integer.valueOf(c2CMsgAutoDownloadFileStorage.AYK.executeUpdateDelete()), str2, Long.valueOf(j3), Long.valueOf(currentTimeMillis), Integer.valueOf(i2));
                        AppMethodBeat.o(87779);
                        return;
                    } else {
                        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "already auto download msgid %s %s", str, Long.valueOf(j2));
                        AppMethodBeat.o(87779);
                        return;
                    }
                } else if (z3) {
                    Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "updateStatus download cancel %s %s", str, Long.valueOf(j2));
                    ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().l(str, j2, 1);
                    AppMethodBeat.o(87779);
                    return;
                } else {
                    Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "updateStatus download fail %s %s", str, Long.valueOf(j2));
                    ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().l(str, j2, 4);
                }
            }
            AppMethodBeat.o(87779);
        }
    }

    @Override // com.tencent.mm.plugin.comm.a.b
    public final List<Pair<String, String>> cAL() {
        AppMethodBeat.i(87794);
        new com.tencent.mm.plugin.priority.model.b.c().run();
        List<Pair<String, String>> eCW = ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CChatUsageResultStorage().eCW();
        AppMethodBeat.o(87794);
        return eCW;
    }

    @Override // com.tencent.mm.plugin.comm.a.b
    public final List<Pair<String, String>> Ci(long j2) {
        AppMethodBeat.i(87795);
        List<Pair<String, String>> HK = ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgFileUsageStorage().HK(j2);
        AppMethodBeat.o(87795);
        return HK;
    }

    @Override // com.tencent.mm.plugin.comm.a.b
    public final List<Pair<String, String>> Cj(long j2) {
        AppMethodBeat.i(87796);
        List<Pair<String, String>> HK = ((PluginPriority) com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CMsgImgUsageStorage().HK(j2);
        AppMethodBeat.o(87796);
        return HK;
    }
}
