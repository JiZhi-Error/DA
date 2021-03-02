package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.f;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.video.c;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.o;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i implements f.a {
    LinkedList<ca> jra = new LinkedList<>();
    long jrb = 0;
    private int jrc = 0;
    private int jrd = 0;
    public boolean jre = false;
    boolean jrf = false;
    private boolean jrg = false;
    private boolean jrh = false;
    f jri = null;
    long jrj = 0;

    public i() {
        AppMethodBeat.i(126879);
        AppMethodBeat.o(126879);
    }

    public final void stopDownload() {
        AppMethodBeat.i(126880);
        Log.i("MicroMsg.PreloadVideoService", "%d stop download", Integer.valueOf(hashCode()));
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.modelvideo.i.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(126876);
                if (i.this.jri != null) {
                    i.this.jri.stop();
                }
                i.this.jri = null;
                AppMethodBeat.o(126876);
            }
        });
        AppMethodBeat.o(126880);
    }

    public final void fP(boolean z) {
        AppMethodBeat.i(126882);
        this.jrf = z;
        if (this.jrf) {
            stopDownload();
        }
        AppMethodBeat.o(126882);
    }

    @Override // com.tencent.mm.modelvideo.f.a
    public final void a(final f fVar, boolean z, int i2, int i3) {
        AppMethodBeat.i(126883);
        if (fVar == null) {
            Log.e("MicroMsg.PreloadVideoService", "%d on preload finish but scene is null?", Integer.valueOf(hashCode()));
            AppMethodBeat.o(126883);
            return;
        }
        if (this.jri != fVar) {
            Log.w("MicroMsg.PreloadVideoService", "%d on preload finish, but scene callback not same object.", Integer.valueOf(hashCode()));
        }
        Log.i("MicroMsg.PreloadVideoService", "%d preload video[%s] finish success[%b] range[%d, %d]", Integer.valueOf(hashCode()), fVar.bha(), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3));
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.modelvideo.i.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(126878);
                long j2 = fVar.msgId;
                synchronized (i.this.jra) {
                    try {
                        Iterator<ca> it = i.this.jra.iterator();
                        while (it.hasNext()) {
                            ca next = it.next();
                            if (next != null && next.field_msgId == j2) {
                                Log.i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", Integer.valueOf(i.this.hashCode()), Long.valueOf(j2));
                                it.remove();
                            }
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(126878);
                        throw th;
                    }
                }
                i.this.fQ(true);
                if (i.this.jri != null) {
                    i.this.jri.jqL = null;
                }
                i.this.jri = null;
                i.a(i.this);
                i.this.startDownload();
                AppMethodBeat.o(126878);
            }
        });
        AppMethodBeat.o(126883);
    }

    public final void fQ(boolean z) {
        AppMethodBeat.i(126884);
        if (z) {
            this.jrc = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_C2C_HAD_PRELOAD_COUNT_INT, (Object) 0)).intValue();
            this.jrc++;
            g.aAh().azQ().set(ar.a.USERINFO_C2C_HAD_PRELOAD_COUNT_INT, Integer.valueOf(this.jrc));
            AppMethodBeat.o(126884);
            return;
        }
        this.jrd = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_SNS_HAD_PRELOAD_COUNT_INT, (Object) 0)).intValue();
        this.jrd++;
        g.aAh().azQ().set(ar.a.USERINFO_SNS_HAD_PRELOAD_COUNT_INT, Integer.valueOf(this.jrd));
        AppMethodBeat.o(126884);
    }

    public final void a(String str, int i2, long j2, String str2, String str3, int i3, String str4, String str5, String str6) {
        AppMethodBeat.i(126886);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Util.nowSecond()).append(",");
        stringBuffer.append(Util.nowSecond()).append(",");
        stringBuffer.append(0).append(",");
        stringBuffer.append(str).append(",");
        stringBuffer.append(i2).append(",");
        stringBuffer.append(0).append(",");
        stringBuffer.append(j2).append(",");
        stringBuffer.append(",");
        stringBuffer.append(str2).append(",");
        stringBuffer.append(str3).append(",");
        stringBuffer.append(i3).append(",");
        stringBuffer.append(str4).append(",");
        stringBuffer.append(str5).append(",");
        stringBuffer.append(c.aTR(str6));
        String stringBuffer2 = stringBuffer.toString();
        Log.d("MicroMsg.PreloadVideoService", "%d rpt content[%s]", Integer.valueOf(hashCode()), stringBuffer2);
        new hb(stringBuffer2).bfK();
        AppMethodBeat.o(126886);
    }

    public final void startDownload() {
        AppMethodBeat.i(126881);
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.modelvideo.i.AnonymousClass2 */

            /* JADX WARNING: Code restructure failed: missing block: B:3:0x002e, code lost:
                if (r3.efy.calling != false) goto L_0x0030;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                // Method dump skipped, instructions count: 837
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvideo.i.AnonymousClass2.run():void");
            }
        });
        AppMethodBeat.o(126881);
    }

    public final boolean fR(boolean z) {
        int i2;
        int a2;
        boolean z2;
        int i3 = 1000;
        AppMethodBeat.i(126885);
        this.jrb = ((Long) g.aAh().azQ().get(ar.a.USERINFO_HAD_PRELOAD_TIME_LONG, (Object) -1L)).longValue();
        if (Util.milliSecondsToNow(this.jrb) >= Util.MILLSECONDS_OF_DAY) {
            this.jrb = Util.nowMilliSecond();
            g.aAh().azQ().set(ar.a.USERINFO_HAD_PRELOAD_TIME_LONG, Long.valueOf(this.jrb));
            g.aAh().azQ().set(ar.a.USERINFO_C2C_HAD_PRELOAD_COUNT_INT, (Object) 0);
            g.aAh().azQ().set(ar.a.USERINFO_SNS_HAD_PRELOAD_COUNT_INT, (Object) 0);
            this.jrh = false;
            this.jrg = false;
        }
        this.jrc = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_C2C_HAD_PRELOAD_COUNT_INT, (Object) 0)).intValue();
        this.jrd = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_SNS_HAD_PRELOAD_COUNT_INT, (Object) 0)).intValue();
        if (z) {
            i2 = this.jrc;
            a2 = ((a) g.af(a.class)).aqJ().getInt("C2CMaxPreloadVideo", 100);
        } else {
            i2 = this.jrd;
            a2 = ((b) g.af(b.class)).a(b.a.clicfg_timeline_max_preload, 1000);
        }
        if (a2 > 0) {
            i3 = a2;
        }
        if (i2 >= i3) {
            z2 = true;
        } else {
            z2 = false;
        }
        Log.i("MicroMsg.PreloadVideoService", "%d check more preload count result[%b] config[%d] hadPreloadCount[%d %d %d] ", Integer.valueOf(hashCode()), Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(this.jrc), Integer.valueOf(this.jrd));
        if (z2) {
            if (z) {
                if (!this.jrg) {
                    this.jrg = true;
                    h.INSTANCE.idkeyStat(354, 127, 1, false);
                }
            } else if (!this.jrh) {
                this.jrh = true;
                h.INSTANCE.idkeyStat(354, 128, 1, false);
            }
        }
        AppMethodBeat.o(126885);
        return z2;
    }

    static /* synthetic */ boolean a(i iVar) {
        AppMethodBeat.i(126887);
        long currentTicks = Util.currentTicks();
        long nowSecond = Util.nowSecond() - (((long) ((a) g.af(a.class)).aqJ().getInt("PreLoadVideoExpiredTime", 1)) * 86400);
        Log.i("MicroMsg.PreloadVideoService", "%d start to delete expired file limit[%d] status[%d] expiredTime[%d] isC2C[%b]", Integer.valueOf(iVar.hashCode()), 1, 111, Long.valueOf(nowSecond), Boolean.TRUE);
        List<s> e2 = o.bhj().e(111, 1, nowSecond);
        if (e2.isEmpty()) {
            AppMethodBeat.o(126887);
            return false;
        }
        int i2 = 0;
        for (s sVar : e2) {
            if (sVar != null) {
                o.bhj();
                String Qw = t.Qw(sVar.getFileName());
                if (!Util.isNullOrNil(Qw)) {
                    o oVar = new o(Qw);
                    if (oVar.exists()) {
                        long length = oVar.length();
                        Log.i("MicroMsg.PreloadVideoService", "%s file[%d %d] lastmodifytime[%d] path[%s]", sVar.getFileName(), Long.valueOf(length), Integer.valueOf(sVar.dRQ), Long.valueOf(sVar.jsm), Qw);
                        if (length > 0 && length <= ((long) sVar.dRQ)) {
                            oVar.delete();
                            i2++;
                        }
                    }
                }
                sVar.dRQ = 0;
                sVar.cSx = 1;
                u.f(sVar);
                i2 = i2;
            }
        }
        h.INSTANCE.idkeyStat(354, 144, (long) i2, false);
        Log.i("MicroMsg.PreloadVideoService", "%d delete expire file size %d delete count %d costTime[%d]", Integer.valueOf(iVar.hashCode()), Integer.valueOf(e2.size()), Integer.valueOf(i2), Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(126887);
        return false;
    }
}
