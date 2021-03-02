package com.tencent.mm.plugin.priority.model.a.b;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.b.f;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.ib;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.util.c;
import com.tencent.mm.vfs.o;
import com.tencent.smtt.sdk.TbsListener;
import java.util.Calendar;
import java.util.Iterator;

public final class a implements i, j, d {
    public String AYB = "";
    f AYC;

    public final void start() {
        AppMethodBeat.i(87828);
        Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "start to download next file");
        ((PluginPriority) g.ah(PluginPriority.class)).getPriorityTaskRunner().a(new C1578a(this, (byte) 0));
        AppMethodBeat.o(87828);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(87829);
        if (qVar.equals(this.AYC) && this.AYB.equals(String.valueOf(this.AYC.msgId))) {
            g.azz().b(TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, this);
            this.AYB = "";
            start();
            if (i2 == 0 && i3 == 0) {
                e.INSTANCE.idkeyStat(1241, 2, 1, false);
                AppMethodBeat.o(87829);
                return;
            }
            e.INSTANCE.idkeyStat(1241, 4, 1, false);
        }
        AppMethodBeat.o(87829);
    }

    @Override // com.tencent.mm.ak.j
    public final void a(int i2, int i3, q qVar) {
        AppMethodBeat.i(87830);
        Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "onSceneProgressEnd %s %s %s", this.AYB, Integer.valueOf(i3), Integer.valueOf(i2));
        AppMethodBeat.o(87830);
    }

    @Override // com.tencent.mm.plugin.record.a.d
    public final void a(int i2, com.tencent.mm.plugin.record.a.j jVar) {
        AppMethodBeat.i(87831);
        if (jVar.field_dataId.equals(this.AYB)) {
            switch (jVar.field_status) {
                case 2:
                    a(jVar, true);
                    e.INSTANCE.idkeyStat(1241, 3, 1, false);
                    break;
                case 3:
                case 4:
                    a(jVar, false);
                    e.INSTANCE.idkeyStat(1241, 5, 1, false);
                    break;
            }
            ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this);
            this.AYB = "";
            start();
        }
        AppMethodBeat.o(87831);
    }

    private static void a(com.tencent.mm.plugin.record.a.j jVar, boolean z) {
        AppMethodBeat.i(87832);
        if (1 == jVar.field_type && (jVar.field_fileType == com.tencent.mm.i.a.gpO || jVar.field_fileType == com.tencent.mm.i.a.MediaType_FILE)) {
            try {
                ((b) g.af(b.class)).a(true, jVar.field_dataId, ((l) g.af(l.class)).eiy().Hb(Long.valueOf(jVar.field_mediaId.split("@")[2]).longValue()).field_msgSvrId, z);
                AppMethodBeat.o(87832);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(87832);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.priority.model.a.b.a$a  reason: collision with other inner class name */
    public class C1578a extends com.tencent.mm.plugin.priority.model.b.a {
        private C1578a() {
        }

        /* synthetic */ C1578a(a aVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.priority.model.b.a
        public final String getName() {
            return "Priority.C2CFileAutoDownloadTask";
        }

        public final void run() {
            ib ibVar;
            int i2;
            String str;
            AppMethodBeat.i(87827);
            b.a aVar = b.a.clicfg_mmc2c_file_auto_download_flag;
            c cVar = c.QYz;
            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(aVar, c.hdd()) == 0) {
                Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "not auto download expt flag");
                AppMethodBeat.o(87827);
            } else if (!a.eCR()) {
                Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "not auto download condition");
                AppMethodBeat.o(87827);
            } else if (!Util.isNullOrNil(a.this.AYB)) {
                Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "Downloading %s", a.this.AYB);
                AppMethodBeat.o(87827);
            } else {
                long fileBgBorderSize = ((PluginPriority) g.ah(PluginPriority.class)).getFileBgBorderSize();
                float fileBgBorderPriority = ((PluginPriority) g.ah(PluginPriority.class)).getFileBgBorderPriority();
                b.a aVar2 = b.a.clicfg_mmc2c_chat_file_auto_download_flag;
                c cVar2 = c.QYz;
                boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(aVar2, c.hde());
                ib eCX = ((PluginPriority) g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().eCX();
                if (eCX != null) {
                    ibVar = eCX;
                    i2 = 1;
                } else if (!a2) {
                    ibVar = ((PluginPriority) g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().b(fileBgBorderPriority, fileBgBorderSize);
                    i2 = 2;
                } else {
                    ibVar = ((PluginPriority) g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().s(((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmc2c_chat_file_auto_download_bg_rank, 20), ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmc2c_chat_file_auto_download_bg_score, 10.0f));
                    i2 = 3;
                }
                if (ibVar == null) {
                    Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "autodownloadfile is null %d %.2f", Long.valueOf(fileBgBorderSize), Float.valueOf(fileBgBorderPriority));
                    AppMethodBeat.o(87827);
                    return;
                }
                final ca aJ = ((l) g.af(l.class)).eiy().aJ(ibVar.KLZ, ibVar.KMf);
                if (!ab.Eq(aJ.field_talker) || aJ.field_isSend != 0) {
                    str = aJ.field_content;
                } else {
                    str = bp.Kt(aJ.field_content);
                }
                final k.b HD = k.b.HD(str);
                if (HD == null) {
                    Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "appMsgContent is null");
                    c c2CMsgAutoDownloadFileStorage = ((PluginPriority) g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage();
                    String str2 = ibVar.Id;
                    long j2 = ibVar.KMf;
                    c2CMsgAutoDownloadFileStorage.AYG.bindString(1, str2);
                    c2CMsgAutoDownloadFileStorage.AYG.bindLong(2, j2);
                    Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "delete %s img %s %s", Integer.valueOf(c2CMsgAutoDownloadFileStorage.AYG.executeUpdateDelete()), str2, Long.valueOf(j2));
                    AppMethodBeat.o(87827);
                    return;
                }
                if (ibVar.KMb == 2) {
                    com.tencent.mm.pluginsdk.model.app.c Mp = com.tencent.mm.plugin.r.a.cgO().Mp(Long.valueOf(ibVar.Id).longValue());
                    if (Mp == null) {
                        Mp = new com.tencent.mm.pluginsdk.model.app.c();
                        Mp.field_fileFullPath = com.tencent.mm.plugin.priority.a.a.a.aB(com.tencent.mm.loader.j.b.aKM(), HD.title, HD.iwJ);
                        Mp.field_appId = HD.appId;
                        Mp.field_sdkVer = (long) HD.sdkVer;
                        Mp.field_mediaSvrId = HD.dCK;
                        Mp.field_totalLen = (long) HD.iwI;
                        Mp.field_status = 101;
                        Mp.field_isUpload = false;
                        Mp.field_createTime = Util.nowMilliSecond();
                        Mp.field_lastModifyTime = Util.nowSecond();
                        Mp.field_msgInfoId = Long.valueOf(ibVar.Id).longValue();
                        Mp.field_netTimes = 0;
                        Mp.field_type = (long) HD.iwM;
                        com.tencent.mm.plugin.r.a.cgO().insert(Mp);
                    }
                    o oVar = new o(Mp.field_fileFullPath);
                    if (!oVar.exists() || oVar.length() != Mp.field_totalLen) {
                        ((PluginPriority) g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().l(ibVar.Id, ibVar.KMf, 2);
                        a.this.AYB = ibVar.Id;
                        h.RTc.aV(new Runnable() {
                            /* class com.tencent.mm.plugin.priority.model.a.b.a.C1578a.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(87826);
                                a.this.AYC = new f(aJ.field_msgId, HD.dCK, (j) null);
                                a.this.AYC.qJf = true;
                                g.azz().a(TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, a.this);
                                g.azz().a(a.this.AYC, 0);
                                AppMethodBeat.o(87826);
                            }
                        });
                        e.INSTANCE.idkeyStat(1241, 0, 1, false);
                    } else {
                        Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "file already exist");
                        ((PluginPriority) g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().l(ibVar.Id, ibVar.KMf, 5);
                        e.INSTANCE.idkeyStat(1241, 8, 1, false);
                        AppMethodBeat.o(87827);
                        return;
                    }
                } else {
                    Iterator<aml> it = p.aKY(HD.ixl).iAd.iterator();
                    while (it.hasNext()) {
                        aml next = it.next();
                        if (next.dLl.equals(ibVar.Id)) {
                            ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(a.this);
                            if (p.b(next, aJ.field_msgId, true)) {
                                a.this.AYB = ibVar.Id;
                                e.INSTANCE.idkeyStat(1241, 1, 1, false);
                            } else {
                                ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(a.this);
                            }
                        }
                    }
                }
                if (!Util.isNullOrNil(a.this.AYB)) {
                    if (i2 == 1) {
                        e.INSTANCE.idkeyStat(1241, 6, 1, false);
                    } else if (i2 == 2) {
                        e.INSTANCE.idkeyStat(1241, 7, 1, false);
                    } else if (i2 == 3) {
                        e.INSTANCE.idkeyStat(1241, 9, 1, false);
                    }
                    Log.i("MicroMsg.Priority.C2CFileAutoDownloader", "downloading file way:%d currentId %s", Integer.valueOf(i2), a.this.AYB);
                }
                AppMethodBeat.o(87827);
            }
        }
    }

    public static boolean eCR() {
        AppMethodBeat.i(87833);
        if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            AppMethodBeat.o(87833);
            return false;
        }
        Calendar instance = Calendar.getInstance();
        int i2 = instance.get(11);
        int i3 = instance.get(12);
        if (i2 == 1 && i3 >= 30) {
            g.aAf();
            if (i3 >= (Math.abs(com.tencent.mm.kernel.a.getUin()) % 30) + 30) {
                AppMethodBeat.o(87833);
                return true;
            }
            AppMethodBeat.o(87833);
            return false;
        } else if (i2 < 2 || i2 > 6) {
            AppMethodBeat.o(87833);
            return false;
        } else {
            AppMethodBeat.o(87833);
            return true;
        }
    }
}
