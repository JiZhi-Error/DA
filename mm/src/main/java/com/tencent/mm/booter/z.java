package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.qs;
import com.tencent.mm.g.a.ua;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ca;
import java.util.HashSet;
import java.util.Locale;

public final class z {
    public static z gmQ = new z();
    public o.a appForegroundListener = new o.a() {
        /* class com.tencent.mm.booter.z.AnonymousClass3 */

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
        }
    };
    public an gmR = new an(ar.NSe + "staytime.cfg");
    public IListener gmS = new IListener<ua>() {
        /* class com.tencent.mm.booter.z.AnonymousClass1 */

        {
            AppMethodBeat.i(161270);
            this.__eventId = ua.class.getName().hashCode();
            AppMethodBeat.o(161270);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ua uaVar) {
            AppMethodBeat.i(19910);
            ua uaVar2 = uaVar;
            if (uaVar2 instanceof ua) {
                ca caVar = uaVar2.eau.dCM;
                z zVar = z.this;
                if (zVar.gmU != null && !zVar.gmW.contains(Long.valueOf(caVar.field_msgId)) && zVar.gmU.gnh.equals(caVar.field_talker)) {
                    zVar.gmW.add(Long.valueOf(caVar.field_msgId));
                    zVar.gmU.gnn++;
                    Log.i("MicroMsg.StayTimeReport", "sendMsg msgType:%d, SendCnt:%d", Integer.valueOf(caVar.getType()), Integer.valueOf(zVar.gmU.gnn));
                }
            }
            AppMethodBeat.o(19910);
            return false;
        }
    };
    public IListener gmT = new IListener<qs>() {
        /* class com.tencent.mm.booter.z.AnonymousClass2 */

        {
            AppMethodBeat.i(161271);
            this.__eventId = qs.class.getName().hashCode();
            AppMethodBeat.o(161271);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qs qsVar) {
            AppMethodBeat.i(19911);
            qs qsVar2 = qsVar;
            if (qsVar2 instanceof qs) {
                ca caVar = qsVar2.dXi.dCM;
                z zVar = z.this;
                if (zVar.gmU != null && !zVar.gmX.contains(Long.valueOf(caVar.field_msgSvrId)) && zVar.gmU.gnh.equals(caVar.field_talker)) {
                    zVar.gmX.add(Long.valueOf(caVar.field_msgSvrId));
                    zVar.gmU.gnm++;
                    Log.i("MicroMsg.StayTimeReport", "receiveMsg msgType:%d, recvCnt:%d", Integer.valueOf(caVar.getType()), Integer.valueOf(zVar.gmU.gnm));
                }
            }
            AppMethodBeat.o(19911);
            return false;
        }
    };
    public a gmU;
    public int gmV = 0;
    HashSet<Long> gmW = new HashSet<>();
    HashSet<Long> gmX = new HashSet<>();
    public long gmY;
    public long gmZ;
    public String gna;
    public long gnb = -1;
    public int gnc = 20;
    public int gnd = 24;
    private int gne = 30;
    private int gnf = 10800;
    private boolean hasInit = false;

    static {
        AppMethodBeat.i(19915);
        AppMethodBeat.o(19915);
    }

    public class a {
        public int dCm;
        public long enterTime;
        public String gnh;
        public int gni;
        public int gnj;
        public int gnk;
        public int gnl = 0;
        int gnm = 0;
        int gnn = 0;
        public long time;
        public int type;

        public a() {
        }

        public final String toString() {
            AppMethodBeat.i(19912);
            String format = String.format(Locale.US, "%d#%d#%d#%d#%d#%d#%d#%s#%d#%d#%d|", Integer.valueOf(this.type), Long.valueOf(this.time), Integer.valueOf(this.gni), Integer.valueOf(this.dCm), Integer.valueOf(this.gnj), Long.valueOf(this.enterTime), Integer.valueOf(this.gnk), this.gnh, Integer.valueOf(this.gnl), Integer.valueOf(this.gnm), Integer.valueOf(this.gnn));
            AppMethodBeat.o(19912);
            return format;
        }
    }

    private z() {
        AppMethodBeat.i(19913);
        AppMethodBeat.o(19913);
    }

    public final void CU(String str) {
        AppMethodBeat.i(19914);
        EventCenter.instance.removeListener(this.gmS);
        EventCenter.instance.removeListener(this.gmT);
        this.appForegroundListener.dead();
        this.gmX.clear();
        this.gmW.clear();
        if (str == null || this.gmU == null) {
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(this.gmU == null);
            Log.i("MicroMsg.StayTimeReport", "exitChattingUI chatUser or reprotingItem is null, chatUser:%s, reportingItem is null:%b", objArr);
            AppMethodBeat.o(19914);
        } else if (!str.equals(this.gmU.gnh)) {
            Log.i("MicroMsg.StayTimeReport", "exitChattingUI no startedUI: %s, start:", str, this.gmU.gnh);
            AppMethodBeat.o(19914);
        } else {
            this.gmU.time += Util.ticksToNow(this.gmY) / 1000;
            this.gmR.set(5, ((String) this.gmR.get(5, "")) + this.gmU.toString());
            if (this.gmU != null) {
                long j2 = this.gmR.getLong(4, 0);
                int ake = this.gmR.ake(6) + 1;
                this.gmR.setInt(6, ake);
                Log.i("MicroMsg.StayTimeReport", "exitChattingUI, chatUser:%s, type:%d, stayTime:%d, stayWebTime:%d, chattingReportCnt:%d", this.gmU.gnh, Integer.valueOf(this.gmU.type), Long.valueOf(this.gmU.time), Integer.valueOf(this.gmU.gnk), Integer.valueOf(ake));
                Log.i("MicroMsg.StayTimeReport", "exitChattingUI goBackHistoryStatus:%d, recnCnt:%d, sendCnt:%d", Integer.valueOf(this.gmU.gnl), Integer.valueOf(this.gmU.gnm), Integer.valueOf(this.gmU.gnn));
                if (Util.secondsToNow(j2) > ((long) this.gnf) || ake > this.gne) {
                    String str2 = ((String) this.gmR.get(5, "")) + "," + j2 + "," + Util.nowSecond();
                    Log.i("MicroMsg.StayTimeReport", "report （13062） %d: %s", 13062, str2);
                    h.INSTANCE.kvStat(13062, str2);
                    this.gmR.setInt(6, 0);
                    this.gmR.set(5, "");
                }
            }
            AppMethodBeat.o(19914);
        }
    }
}
