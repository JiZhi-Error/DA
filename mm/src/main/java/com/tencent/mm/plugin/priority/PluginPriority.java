package com.tencent.mm.plugin.priority;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.ol;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.priority.model.a.a.a;
import com.tencent.mm.plugin.priority.model.a.c.d;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.tav.coremedia.TimeUtil;
import java.util.Calendar;

public class PluginPriority extends f implements b, c, com.tencent.mm.plugin.priority.a.a {
    private long AXP;
    private com.tencent.mm.plugin.priority.model.b AXQ;
    private com.tencent.mm.plugin.priority.model.a.c.c AXR;
    private com.tencent.mm.plugin.priority.model.a.b.c AXS;
    private d AXT;
    private com.tencent.mm.plugin.priority.model.a.b.d AXU;
    private com.tencent.mm.plugin.priority.model.a.a.c AXV;
    private com.tencent.mm.plugin.priority.model.a.a.b AXW;
    private com.tencent.mm.plugin.priority.model.d AXX;
    private com.tencent.mm.plugin.priority.model.a.c.b AXY;
    private com.tencent.mm.plugin.priority.model.a.b.b AXZ;
    private com.tencent.mm.plugin.priority.model.a.a.a AYa;
    private com.tencent.mm.plugin.priority.model.a.c.a AYb;
    private com.tencent.mm.plugin.priority.model.a.b.a AYc;
    private i.a AYd = new i.a() {
        /* class com.tencent.mm.plugin.priority.PluginPriority.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i.a
        public final void a(i iVar, i.c cVar) {
            AppMethodBeat.i(87765);
            if (cVar.zqn.equals("insert")) {
                for (int i2 = 0; i2 < cVar.hIs.size(); i2++) {
                    ca caVar = cVar.hIs.get(i2);
                    if (caVar.field_isSend == 0 && caVar.gAz()) {
                        ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).at(caVar);
                    } else if (caVar.field_isSend == 0 && caVar.dOQ()) {
                        ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).au(caVar);
                    }
                    if (PluginPriority.this.getC2CChatUsageLogic() != null) {
                        if (caVar.field_isSend == 1) {
                            ((PluginPriority) g.ah(PluginPriority.class)).getPriorityTaskRunner().a(new a.C1577a(caVar.field_talker, 1));
                        } else {
                            ((PluginPriority) g.ah(PluginPriority.class)).getPriorityTaskRunner().a(new a.C1577a(caVar.field_talker, 3));
                        }
                    }
                }
            }
            AppMethodBeat.o(87765);
        }
    };
    private IListener<ol> AYe = new IListener<ol>() {
        /* class com.tencent.mm.plugin.priority.PluginPriority.AnonymousClass2 */

        {
            AppMethodBeat.i(161633);
            this.__eventId = ol.class.getName().hashCode();
            AppMethodBeat.o(161633);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ol olVar) {
            AppMethodBeat.i(87766);
            ol olVar2 = olVar;
            switch (olVar2.dUx.action) {
                case 1:
                    if (!Util.isNullOrNil(olVar2.dUx.username) && PluginPriority.this.getC2CChatUsageLogic() != null) {
                        ((PluginPriority) g.ah(PluginPriority.class)).getPriorityTaskRunner().a(new a.C1577a(olVar2.dUx.username, olVar2.dUx.dUy));
                        break;
                    }
            }
            AppMethodBeat.o(87766);
            return false;
        }
    };
    private MStorageEx.IOnStorageChange wYb = new MStorageEx.IOnStorageChange() {
        /* class com.tencent.mm.plugin.priority.PluginPriority.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
        public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
            AppMethodBeat.i(87767);
            String str = (String) obj;
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(87767);
                return;
            }
            switch (i2) {
                case 5:
                    if (PluginPriority.this.getPriorityTaskRunner() != null) {
                        PluginPriority.this.getPriorityTaskRunner().a(new com.tencent.mm.plugin.priority.model.b.d(str));
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(87767);
        }
    };
    private MStorageEx.IOnStorageChange wYc = new MStorageEx.IOnStorageChange() {
        /* class com.tencent.mm.plugin.priority.PluginPriority.AnonymousClass4 */

        @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
        public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
            AppMethodBeat.i(87768);
            String str = (String) obj;
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(87768);
                return;
            }
            switch (i2) {
                case 5:
                    if (PluginPriority.this.getPriorityTaskRunner() != null) {
                        PluginPriority.this.getPriorityTaskRunner().a(new com.tencent.mm.plugin.priority.model.b.d(str));
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(87768);
        }
    };

    public PluginPriority() {
        AppMethodBeat.i(87770);
        AppMethodBeat.o(87770);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(87771);
        ThreadPool.post(new a(this, (byte) 0), "Priority.InitPriorityTask");
        com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.priority.model.a(), "//priority");
        this.AYe.alive();
        ((l) g.af(l.class)).aST().add(this.wYb);
        ((l) g.af(l.class)).aSN().add(this.wYc);
        AppMethodBeat.o(87771);
    }

    @Override // com.tencent.mm.plugin.priority.a.a
    public com.tencent.mm.plugin.priority.model.a.c.a getC2CImgAutoDownloader() {
        return this.AYb;
    }

    class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(PluginPriority pluginPriority, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(87769);
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = g.aAh().azQ().getInt(ar.a.USERINFO_PRIORITY_DB_VERSION_INT, 0);
            if (i2 != 6) {
                Log.i("MicroMsg.Priority.PluginPriority", "New DB FILE %d %d", Integer.valueOf(i2), 6);
                g.aAi();
                s.deleteFile(aa.z(new o(g.aAh().cachePath, "MicroMsgPriority.db").her()));
                g.aAh().azQ().set(ar.a.USERINFO_PRIORITY_DB_VERSION_INT, (Object) 6);
            }
            PluginPriority pluginPriority = PluginPriority.this;
            g.aAi();
            pluginPriority.AXQ = new com.tencent.mm.plugin.priority.model.b(g.aAh().cachePath);
            PluginPriority.this.AXP = PluginPriority.this.AXQ.ag(16777217, 0);
            if (PluginPriority.this.AXP == 0) {
                PluginPriority.this.AXP = System.currentTimeMillis();
                PluginPriority.this.AXQ.ah(16777217, PluginPriority.this.AXP);
            }
            Log.i("MicroMsg.Priority.PluginPriority", "install priority time %s", com.tencent.mm.pluginsdk.i.f.formatTime(TimeUtil.YYYY2MM2DD_HH1MM1SS, PluginPriority.this.AXP / 1000));
            PluginPriority.this.AXR = new com.tencent.mm.plugin.priority.model.a.c.c(PluginPriority.this.AXQ);
            PluginPriority.this.AXS = new com.tencent.mm.plugin.priority.model.a.b.c(PluginPriority.this.AXQ);
            PluginPriority.this.AXT = new d(PluginPriority.this.AXQ);
            PluginPriority.this.AXU = new com.tencent.mm.plugin.priority.model.a.b.d(PluginPriority.this.AXQ);
            PluginPriority.this.AXV = new com.tencent.mm.plugin.priority.model.a.a.c(PluginPriority.this.AXQ);
            PluginPriority.this.AXW = new com.tencent.mm.plugin.priority.model.a.a.b(PluginPriority.this.AXQ);
            PluginPriority.this.AXX = new com.tencent.mm.plugin.priority.model.d();
            PluginPriority.this.AXY = new com.tencent.mm.plugin.priority.model.a.c.b();
            PluginPriority.this.AXZ = new com.tencent.mm.plugin.priority.model.a.b.b();
            PluginPriority.this.AYb = new com.tencent.mm.plugin.priority.model.a.c.a();
            PluginPriority.this.AYc = new com.tencent.mm.plugin.priority.model.a.b.a();
            PluginPriority.this.AYa = new com.tencent.mm.plugin.priority.model.a.a.a();
            com.tencent.mm.plugin.priority.model.d dVar = PluginPriority.this.AXX;
            Log.i("MicroMsg.Priority.PriorityTaskRunner", "start tick");
            dVar.HJ(0);
            long ag = PluginPriority.this.AXQ.ag(16777218, -1);
            long j2 = (long) Calendar.getInstance().get(5);
            if (j2 != ag) {
                String format = String.format("%d,%d", Long.valueOf(Util.nullAs((Long) g.aAh().azQ().get(ar.a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, (Object) null), 0)), Long.valueOf((long) Util.getInt(((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("ChatImgAutoDownloadMax"), 0)));
                Log.i("MicroMsg.Priority.PriorityReportLogic", "report16341 %s", format);
                com.tencent.mm.plugin.report.e.INSTANCE.kvStat(16341, format);
                PluginPriority.this.AXQ.ah(16777218, j2);
            }
            ((l) g.af(l.class)).eiy().a(PluginPriority.this.AYd, (Looper) null);
            com.tencent.mm.plugin.priority.model.a.c.c cVar = PluginPriority.this.AXR;
            String format2 = String.format("DELETE FROM %s WHERE createtime < ?", "C2CMsgAutoDownloadRes");
            cVar.AXQ.execSQL(format2, new String[]{String.valueOf(System.currentTimeMillis() - 7776000000L)});
            PluginPriority.this.AXX.a(new com.tencent.mm.plugin.priority.model.b.c());
            Log.i("MicroMsg.Priority.PluginPriority", "Init Priority Use Time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(87769);
        }
    }

    public com.tencent.mm.plugin.priority.model.d getPriorityTaskRunner() {
        return this.AXX;
    }

    public com.tencent.mm.plugin.priority.model.a.c.b getC2CMsgAutoDownloadImgLogic() {
        return this.AXY;
    }

    public com.tencent.mm.plugin.priority.model.a.b.b getC2CMsgAutoDownloadFileLogic() {
        return this.AXZ;
    }

    public com.tencent.mm.plugin.priority.model.a.c.c getC2CMsgAutoDownloadImgStorage() {
        return this.AXR;
    }

    public com.tencent.mm.plugin.priority.model.a.b.c getC2CMsgAutoDownloadFileStorage() {
        return this.AXS;
    }

    public com.tencent.mm.plugin.priority.model.a.a.c getC2CChatUsageStorage() {
        return this.AXV;
    }

    public com.tencent.mm.plugin.priority.model.a.a.b getC2CChatUsageResultStorage() {
        return this.AXW;
    }

    public d getC2CMsgImgUsageStorage() {
        return this.AXT;
    }

    public com.tencent.mm.plugin.priority.model.a.b.d getC2CMsgFileUsageStorage() {
        return this.AXU;
    }

    public com.tencent.mm.plugin.priority.model.a.b.a getC2CFileAutoDownloader() {
        return this.AYc;
    }

    public com.tencent.mm.plugin.priority.model.a.a.a getC2CChatUsageLogic() {
        return this.AYa;
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        boolean isOpen;
        AppMethodBeat.i(87772);
        this.AYe.dead();
        ((l) g.af(l.class)).aST().remove(this.wYb);
        ((l) g.af(l.class)).aSN().remove(this.wYc);
        ((l) g.af(l.class)).eiy().a(this.AYd);
        if (this.AYb != null) {
            com.tencent.mm.plugin.priority.model.a.c.a aVar = this.AYb;
            aVar.AYM = 0;
            q.bcS().a(aVar);
            aVar.iWS.dead();
            this.AYb = null;
        }
        if (this.AXY != null) {
            this.AXY = null;
        }
        if (this.AXX != null) {
            com.tencent.mm.plugin.priority.model.d dVar = this.AXX;
            dVar.AYo.clear();
            dVar.AYp.removeCallbacksAndMessages(null);
            dVar.AYp.quit();
            dVar.AYp = null;
            this.AXX = null;
        }
        if (this.AXR != null) {
            com.tencent.mm.plugin.priority.model.a.c.c cVar = this.AXR;
            cVar.AYx.close();
            cVar.AYG.close();
            cVar.AYI.close();
            cVar.AYJ.close();
            cVar.AYK.close();
            cVar.AYL.close();
            cVar.AYH.close();
            this.AXR = null;
        }
        if (this.AXT != null) {
            d dVar2 = this.AXT;
            dVar2.AYr.close();
            dVar2.AYs.close();
            dVar2.AYt.close();
        }
        if (this.AXQ != null) {
            com.tencent.mm.plugin.priority.model.b bVar = this.AXQ;
            Object[] objArr = new Object[2];
            objArr[0] = bVar.AYk;
            if (bVar.AYk == null) {
                isOpen = false;
            } else {
                isOpen = bVar.AYk.isOpen();
            }
            objArr[1] = Boolean.valueOf(isOpen);
            Log.w("MicroMsg.Priority.PriorityDB", "close db:%s isOpen:%b ", objArr);
            if (bVar.AYk != null && bVar.AYk.isOpen()) {
                Log.w("MicroMsg.Priority.PriorityDB", "close in trans :%b ", Boolean.valueOf(bVar.AYk.inTransaction()));
                while (bVar.AYk.inTransaction()) {
                    bVar.AYk.endTransaction();
                }
                bVar.AYl.close();
                bVar.AYm.close();
                bVar.AYn.close();
                bVar.AYk.close();
                bVar.AYk = null;
            }
            this.AXQ = null;
        }
        AppMethodBeat.o(87772);
    }

    @Override // com.tencent.mm.kernel.a.b.b
    public void parallelsDependency() {
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(87773);
        if (gVar.aBb()) {
            g.b(com.tencent.mm.plugin.comm.a.b.class, new a());
        }
        AppMethodBeat.o(87773);
    }

    public long getInstallPriorityTime() {
        return this.AXP;
    }

    public float getImgBorderPriority() {
        AppMethodBeat.i(87774);
        try {
            float a2 = ((float) ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmc2c_img_auto_download_border_priority, 30)) / 100.0f;
            AppMethodBeat.o(87774);
            return a2;
        } catch (Exception e2) {
            AppMethodBeat.o(87774);
            return 0.5f;
        }
    }

    public float getImgBgBorderPriority() {
        AppMethodBeat.i(87775);
        try {
            float a2 = ((float) ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmc2c_img_auto_download_bg_border_priority, 10)) / 100.0f;
            AppMethodBeat.o(87775);
            return a2;
        } catch (Exception e2) {
            AppMethodBeat.o(87775);
            return 0.1f;
        }
    }

    public float getFileBgBorderPriority() {
        AppMethodBeat.i(87776);
        try {
            float a2 = ((float) ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmc2c_file_auto_download_bg_border_priority, 5)) / 100.0f;
            AppMethodBeat.o(87776);
            return a2;
        } catch (Exception e2) {
            AppMethodBeat.o(87776);
            return 0.05f;
        }
    }

    public long getFileBgBorderSize() {
        AppMethodBeat.i(87777);
        try {
            long a2 = ((long) (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmc2c_file_auto_download_bg_border_size, 10) * 1024)) * 1024;
            AppMethodBeat.o(87777);
            return a2;
        } catch (Exception e2) {
            AppMethodBeat.o(87777);
            return 10485760;
        }
    }

    public com.tencent.mm.plugin.priority.model.b getPriorityDB() {
        return this.AXQ;
    }
}
