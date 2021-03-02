package com.tencent.mm.plugin.location.model;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.location.model.a.c;
import com.tencent.mm.plugin.location.model.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.aka;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.protocal.protobuf.ejg;
import com.tencent.mm.protocal.protobuf.eox;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class q implements i, com.tencent.mm.bi.b {
    public b.a gmA = new b.a() {
        /* class com.tencent.mm.plugin.location.model.q.AnonymousClass2 */

        @Override // com.tencent.mm.modelgeo.b.a
        public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
            AppMethodBeat.i(55759);
            if (!z) {
                AppMethodBeat.o(55759);
                return false;
            }
            Log.d("MicorMsg.TrackRefreshManager", "onGetlocatoin fLongitude:%f, fLatitude:%f, locType:%d, speed:%f", Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i2), Double.valueOf(d2));
            if (q.this.yGR) {
                q.this.yGR = false;
                q.this.yGT = System.currentTimeMillis();
                long j2 = q.this.yGT - q.this.yGS;
                Log.d("MicorMsg.TrackRefreshManager", "locate time:%d", Long.valueOf(j2));
                h.INSTANCE.a(10997, PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT, "", 0, Long.valueOf(j2));
            }
            if (!(q.this.yGJ == null || q.this.yGJ.NmV == null)) {
                q.this.yGJ.NmV.KUu = (double) f3;
                q.this.yGJ.NmV.KUt = (double) f2;
            }
            AppMethodBeat.o(55759);
            return true;
        }
    };
    public d iOv;
    public boolean isStart = false;
    public boolean isTimeout = false;
    MMHandler mHandler = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.plugin.location.model.q.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(55758);
            super.handleMessage(message);
            if (message == null) {
                AppMethodBeat.o(55758);
                return;
            }
            q qVar = q.this;
            switch (message.what) {
                case 1:
                    qVar.eda();
                    break;
            }
            AppMethodBeat.o(55758);
        }
    };
    private int qwL;
    public String rgD = "";
    private String yFs;
    public double yFu = -1000.0d;
    public double yFv = -1000.0d;
    public int yFw = -1;
    private int yGE = 0;
    private int yGF = 1000;
    public k yGG;
    public HashSet<WeakReference<b>> yGH = new HashSet<>();
    public int yGI = 1;
    public eox yGJ;
    public LocationInfo yGK = new LocationInfo((byte) 0);
    public boolean yGL = false;
    public boolean yGM = false;
    public int yGN = this.yGI;
    boolean yGO = false;
    public a yGP = null;
    public int yGQ = -1;
    public boolean yGR = true;
    public long yGS = 0;
    long yGT = 0;
    public k.a yGU = new k.a() {
        /* class com.tencent.mm.plugin.location.model.q.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.location.model.k.a
        public final void w(double d2) {
            if (q.this.yGJ != null) {
                q.this.yGJ.NmV.MIv = d2;
            }
        }
    };

    public interface a {
        void bTS();
    }

    public interface b {
        void a(dmb dmb);

        void edc();

        void edd();

        void onError(int i2, String str);
    }

    public q() {
        AppMethodBeat.i(55760);
        AppMethodBeat.o(55760);
    }

    public final void stop() {
        AppMethodBeat.i(55761);
        Log.i("MicorMsg.TrackRefreshManager", "stop location");
        if (this.iOv != null) {
            this.iOv.c(this.gmA);
        }
        if (this.yGG != null) {
            this.yGG.b(this.yGU);
        }
        g.azz().b(com.tencent.mm.plugin.appbrand.jsapi.k.i.CTRL_INDEX, this);
        g.azz().b(490, this);
        g.azz().b(com.tencent.mm.plugin.appbrand.jsapi.y.d.CTRL_INDEX, this);
        this.yGI = 1;
        this.isStart = false;
        this.yGQ = -1;
        AppMethodBeat.o(55761);
    }

    public final boolean ecV() {
        AppMethodBeat.i(55762);
        if (!edb() || !this.yGL) {
            AppMethodBeat.o(55762);
            return false;
        }
        AppMethodBeat.o(55762);
        return true;
    }

    private void et(String str, int i2) {
        AppMethodBeat.i(55763);
        Log.d("MicorMsg.TrackRefreshManager", "exitTrack, scene=%d", Integer.valueOf(i2));
        com.tencent.mm.plugin.location.model.a.a aVar = new com.tencent.mm.plugin.location.model.a.a(str);
        ((aka) aVar.rr.iLK.iLR).Scene = i2;
        g.azz().a(aVar, 0);
        this.yFs = "";
        AppMethodBeat.o(55763);
    }

    public final void Px(int i2) {
        com.tencent.mm.plugin.location.a.a aCZ;
        AppMethodBeat.i(55764);
        Log.i("MicorMsg.TrackRefreshManager", "track endTrack");
        if (edb()) {
            et(this.yFs, i2);
        }
        if (!Util.isNullOrNil(this.rgD) && (aCZ = n.ecS().aCZ(this.rgD)) != null) {
            aCZ.dTe.remove(z.aTY());
            n.ecS().a(this.rgD, aCZ.dTe, aCZ.latitude, aCZ.longitude, aCZ.yFq, null, null);
        }
        n.ecS().aDa("");
        this.yFs = "";
        this.rgD = "";
        this.yGL = false;
        this.yGM = false;
        this.yFu = -1000.0d;
        this.yFv = -1000.0d;
        this.yFw = -1;
        this.yGQ = -1;
        AppMethodBeat.o(55764);
    }

    private void ecW() {
        AppMethodBeat.i(55765);
        Log.d("MicorMsg.TrackRefreshManager", "trigerRefresh");
        if (edb()) {
            Log.d("MicorMsg.TrackRefreshManager", "trigerRefresh, joinSuccess");
            this.iOv = d.bca();
            this.iOv.b(this.gmA, true);
            if (this.yGG == null) {
                this.yGG = n.ecT();
            }
            this.yGG.a(this.yGU);
            eda();
        }
        AppMethodBeat.o(55765);
    }

    public final void ecX() {
        AppMethodBeat.i(55766);
        Log.d("MicorMsg.TrackRefreshManager", "resume refresh");
        this.yGO = false;
        ecW();
        AppMethodBeat.o(55766);
    }

    @Override // com.tencent.mm.bi.b
    public final String bgL() {
        return this.rgD;
    }

    public final List<String> ecY() {
        AppMethodBeat.i(55767);
        LinkedList<String> PY = n.ecS().PY(this.rgD);
        AppMethodBeat.o(55767);
        return PY;
    }

    public final void ecZ() {
        if (this.yGI == 1) {
            this.yGI = 3;
        } else if (this.yGI == 3) {
            this.yGI = 2;
        }
    }

    public final void eda() {
        boolean z = true;
        AppMethodBeat.i(55768);
        if (!this.isStart || !this.yGL || this.yGK == null) {
            StringBuilder append = new StringBuilder("error to exit refresh isStart: ").append(this.isStart).append(" isShared: ").append(this.yGL).append(" ");
            if (this.yGK != null) {
                z = false;
            }
            Log.e("MicorMsg.TrackRefreshManager", append.append(z).toString());
            AppMethodBeat.o(55768);
        } else if (this.yGJ == null || this.yGJ.NmV.KUu == -1000.0d || this.yGJ.NmV.KUt == -1000.0d) {
            Log.e("MicorMsg.TrackRefreshManager", "error to get my location ");
            this.mHandler.sendEmptyMessageDelayed(1, (long) this.yGF);
            AppMethodBeat.o(55768);
        } else {
            String aTY = z.aTY();
            ejg ejg = new ejg();
            ejg.MCE = this.yGK.yFx;
            ejg.KUu = this.yGK.yFu;
            ejg.KUt = this.yGK.yFv;
            ejg.Name = aTY;
            this.yGJ.Username = aTY;
            this.yGJ.NmV.MIv = n.ecT().ecL();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("refreshLoopImpl, [trackRoomId:" + this.yFs + "]");
            switch (this.yGI) {
                case 0:
                    stringBuffer.append("track upload_status  MMRefreshTrackRoomUpload ");
                    break;
                case 1:
                    stringBuffer.append("track upload_status  MMRefreshTrackRoomDownload ");
                    break;
                case 2:
                    stringBuffer.append("track upload_status  MMRefreshTrackRoomUploadAndDownLoad ");
                    break;
                case 3:
                    stringBuffer.append("track upload_status  MMRefreshTrackRoomFirstUpload ");
                    stringBuffer.append("[ trackItem " + ejg.KUu + " " + ejg.KUt + " ]");
                    break;
            }
            stringBuffer.append("[ mMyPosiItem " + this.yGJ.NmV.KUu + " " + this.yGJ.NmV.KUt + " " + this.yGJ.NmV.MIv + " ]");
            Log.d("MicorMsg.TrackRefreshManager", stringBuffer.toString());
            String str = this.yFs;
            int i2 = this.yGI;
            eox eox = this.yGJ;
            int i3 = this.qwL + 1;
            this.qwL = i3;
            g.azz().a(new c(str, i2, eox, i3, ejg), 0);
            AppMethodBeat.o(55768);
        }
    }

    public final boolean edb() {
        AppMethodBeat.i(55769);
        if (!Util.isNullOrNil(this.yFs)) {
            AppMethodBeat.o(55769);
            return true;
        }
        AppMethodBeat.o(55769);
        return false;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        boolean z;
        AppMethodBeat.i(55770);
        Log.d("MicorMsg.TrackRefreshManager", "onSceneEnd scene type %d errType %d errCode %d", Integer.valueOf(qVar.getType()), Integer.valueOf(i2), Integer.valueOf(i3));
        if (qVar.getType() == 490) {
            if (i3 == 0 || i3 >= 1000) {
                this.yFs = ((com.tencent.mm.plugin.location.model.a.b) qVar).yFs;
                n.ecS().aDa(this.yFs);
                if (edb()) {
                    Log.i("MicorMsg.TrackRefreshManager", "join sucess %s", this.yFs);
                    LinkedList<String> PY = com.tencent.mm.bi.d.jpA.PY(this.rgD);
                    PY.add(z.aTY());
                    if (this.yGK != null) {
                        com.tencent.mm.bi.d.jpA.a(this.rgD, PY, this.yGK.yFu, this.yGK.yFv, this.yGK.yFx, "", "");
                    } else {
                        com.tencent.mm.bi.d.jpA.a(this.rgD, PY, -1000.0d, -1000.0d, "", "", "");
                    }
                    if (this.yGH != null) {
                        Iterator<WeakReference<b>> it = this.yGH.iterator();
                        while (it.hasNext()) {
                            WeakReference<b> next = it.next();
                            if (!(next == null || next.get() == null)) {
                                next.get().edc();
                            }
                        }
                    }
                    eda();
                    AppMethodBeat.o(55770);
                    return;
                }
            } else {
                if (i3 == 17 && this.yGH != null) {
                    Iterator<WeakReference<b>> it2 = this.yGH.iterator();
                    while (it2.hasNext()) {
                        WeakReference<b> next2 = it2.next();
                        if (!(next2 == null || next2.get() == null)) {
                            next2.get().edd();
                        }
                    }
                }
                if (this.yGH != null) {
                    Iterator<WeakReference<b>> it3 = this.yGH.iterator();
                    while (it3.hasNext()) {
                        WeakReference<b> next3 = it3.next();
                        if (!(next3 == null || next3.get() == null)) {
                            next3.get().onError(0, ((com.tencent.mm.plugin.location.model.a.b) qVar).qwG);
                        }
                    }
                    AppMethodBeat.o(55770);
                    return;
                }
            }
        } else if (i2 == 0 && i3 == 0) {
            if (qVar.getType() == 492) {
                dmb dmb = ((c) qVar).yHe;
                if (!(dmb == null || dmb.BaseResponse == null)) {
                    if (dmb.BaseResponse.Ret == 12) {
                        this.isTimeout = true;
                        if (this.yGP != null) {
                            this.yGP.bTS();
                        }
                    } else {
                        this.isTimeout = false;
                    }
                    Log.d("MicorMsg.TrackRefreshManager", "refresh track room, timeout = %b, ret = %d", Boolean.valueOf(this.isTimeout), Integer.valueOf(dmb.BaseResponse.Ret));
                }
                if (this.yGE > 0) {
                    h.INSTANCE.a(10997, "9", "", Integer.valueOf(this.yGE), 0);
                }
                this.yGE = 0;
                this.yGF = ((c) qVar).yHb;
                int i4 = ((c) qVar).yHf;
                if (this.yGH != null && (i4 == 2 || i4 == 1 || i4 == 3)) {
                    Iterator<WeakReference<b>> it4 = this.yGH.iterator();
                    while (it4.hasNext()) {
                        WeakReference<b> next4 = it4.next();
                        if (!(next4 == null || next4.get() == null)) {
                            next4.get().a(((c) qVar).yHe);
                        }
                    }
                }
                if (this.yGI == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    ecZ();
                }
                this.mHandler.removeMessages(1);
                if (edb() && !this.yGO && !this.isTimeout) {
                    this.mHandler.sendEmptyMessageDelayed(1, (long) this.yGF);
                }
                AppMethodBeat.o(55770);
                return;
            } else if (qVar.getType() == 491) {
                n.ecS().aDa("");
            }
        } else if (qVar.getType() == 492) {
            this.yGE++;
            this.mHandler.removeMessages(1);
            if (this.yGE >= 10) {
                this.mHandler.removeMessages(1);
                if (this.yGH != null) {
                    Iterator<WeakReference<b>> it5 = this.yGH.iterator();
                    while (it5.hasNext()) {
                        WeakReference<b> next5 = it5.next();
                        if (!(next5 == null || next5.get() == null)) {
                            next5.get().onError(1, ((c) qVar).qwG);
                        }
                    }
                    AppMethodBeat.o(55770);
                    return;
                }
            } else if (edb() && !this.yGO) {
                dmb dmb2 = ((c) qVar).yHe;
                if (!(dmb2 == null || dmb2.BaseResponse == null)) {
                    if (dmb2.BaseResponse.Ret == 12) {
                        this.isTimeout = true;
                        if (this.yGP != null) {
                            this.yGP.bTS();
                        }
                    } else {
                        this.isTimeout = false;
                    }
                    Log.d("MicorMsg.TrackRefreshManager", "refresh track room, in error status, timeout = %b, ret = %d", Boolean.valueOf(this.isTimeout), Integer.valueOf(dmb2.BaseResponse.Ret));
                }
                if (!this.isTimeout) {
                    this.mHandler.sendEmptyMessageDelayed(1, (long) this.yGF);
                }
                AppMethodBeat.o(55770);
                return;
            }
        }
        AppMethodBeat.o(55770);
    }
}
