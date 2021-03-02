package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.plugin.location.a.a;
import com.tencent.mm.plugin.location.model.f;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.plugin.location.model.q;
import com.tencent.mm.plugin.location.ui.MyLocationButton;
import com.tencent.mm.plugin.location.ui.ShareHeader;
import com.tencent.mm.plugin.location.ui.TipSayingWidget;
import com.tencent.mm.plugin.location.ui.VolumeMeter;
import com.tencent.mm.plugin.location.ui.i;
import com.tencent.mm.plugin.location.ui.j;
import com.tencent.mm.plugin.location.ui.k;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.protocal.protobuf.ejg;
import com.tencent.mm.protocal.protobuf.eox;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class h extends k implements j.a {
    private b.a gmA = new b.a() {
        /* class com.tencent.mm.plugin.location.ui.impl.h.AnonymousClass5 */

        @Override // com.tencent.mm.modelgeo.b.a
        public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
            AppMethodBeat.i(56118);
            if (!z) {
                AppMethodBeat.o(56118);
                return false;
            }
            Log.d("MicroMsg.ShareMapUI", "onGetLocation, latitude=%f, longtitude=%f, speed=%f", Float.valueOf(f3), Float.valueOf(f2), Double.valueOf(d2));
            if (f.v(d2) && !h.this.yNq.yKf) {
                Log.d("MicroMsg.ShareMapUI", "set driving mode");
                h.this.yNq.yKi = false;
                h.this.yNq.qI(true);
                h.this.yNo.edg();
            }
            AppMethodBeat.o(56118);
            return true;
        }
    };
    private IListener qCu = new IListener<zj>() {
        /* class com.tencent.mm.plugin.location.ui.impl.h.AnonymousClass6 */

        {
            AppMethodBeat.i(160953);
            this.__eventId = zj.class.getName().hashCode();
            AppMethodBeat.o(160953);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zj zjVar) {
            AppMethodBeat.i(56120);
            boolean a2 = a(zjVar);
            AppMethodBeat.o(56120);
            return a2;
        }

        private boolean a(zj zjVar) {
            AppMethodBeat.i(56119);
            if (!g.aAc()) {
                AppMethodBeat.o(56119);
                return false;
            }
            if (zjVar.efx.dKy == 3) {
                h.this.yNq.qJ(false);
                h.this.yNr.stop();
                h.this.yNr.Px(2);
                i.edv();
                h.this.activity.finish();
            }
            AppMethodBeat.o(56119);
            return true;
        }
    };
    private PowerManager.WakeLock wakeLock;
    private View yIU;
    private k.a yKp = new k.a() {
        /* class com.tencent.mm.plugin.location.ui.impl.h.AnonymousClass1 */
    };
    private q.b yNA = new q.b() {
        /* class com.tencent.mm.plugin.location.ui.impl.h.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.location.model.q.b
        public final void edc() {
            AppMethodBeat.i(56113);
            Log.i("MicroMsg.ShareMapUI", "onJoinSucess");
            q qVar = h.this.yNr;
            qVar.yGL = true;
            qVar.ecZ();
            qVar.eda();
            h.this.yNq.qJ(true);
            if (h.this.yNt != null) {
                h.this.yNt.edt();
            }
            AppMethodBeat.o(56113);
        }

        @Override // com.tencent.mm.plugin.location.model.q.b
        public final void a(dmb dmb) {
            AppMethodBeat.i(56114);
            h.a(h.this, dmb);
            AppMethodBeat.o(56114);
        }

        @Override // com.tencent.mm.plugin.location.model.q.b
        public final void onError(int i2, String str) {
            AppMethodBeat.i(56115);
            Log.v("MicroMsg.ShareMapUI", "onError type %d msg %s", Integer.valueOf(i2), str);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(10997, "7", "", 0, 0);
            j jVar = h.this.yNs;
            Log.d("MicroMsg.TrackPoiDialogMgr", "showErrorDialog, errMsg=%s", str);
            Context context = MMApplicationContext.getContext();
            String str2 = null;
            if (!Util.isNullOrNil(str)) {
                str2 = str;
            } else if (i2 == 0) {
                str2 = context.getString(R.string.ekp);
            } else if (i2 == 1) {
                str2 = context.getString(R.string.ekv);
            } else if (i2 == 2) {
                str2 = context.getString(R.string.ekw);
            }
            com.tencent.mm.ui.base.h.a(jVar.mContext, str2, "", jVar.mResources.getString(R.string.x_), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener(i2) {
                /* class com.tencent.mm.plugin.location.ui.j.AnonymousClass5 */
                final /* synthetic */ int val$type;

                {
                    this.val$type = r2;
                }

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(55960);
                    if (j.this.yJV != null) {
                        j.this.yJV.Py(this.val$type);
                    }
                    AppMethodBeat.o(55960);
                }
            });
            AppMethodBeat.o(56115);
        }

        @Override // com.tencent.mm.plugin.location.model.q.b
        public final void edd() {
            AppMethodBeat.i(56116);
            h.this.yNq.qJ(false);
            h.this.yNr.stop();
            h.this.yNr.Px(3);
            i.edv();
            h.this.activity.finish();
            h.this.activity.overridePendingTransition(R.anim.dp, R.anim.dr);
            AppMethodBeat.o(56116);
        }
    };
    private q.a yNB = new q.a() {
        /* class com.tencent.mm.plugin.location.ui.impl.h.AnonymousClass4 */

        @Override // com.tencent.mm.plugin.location.model.q.a
        public final void bTS() {
            AppMethodBeat.i(56117);
            h hVar = h.this;
            d.a aVar = new d.a(hVar.activity);
            aVar.aoS(R.string.hrk);
            aVar.aoV(R.string.x_).c(new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.location.ui.impl.h.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(56112);
                    h.this.yNq.qJ(false);
                    h.this.yNr.stop();
                    h.this.yNr.Px(2);
                    i.edv();
                    h.this.activity.finish();
                    AppMethodBeat.o(56112);
                }
            });
            aVar.hbn().show();
            AppMethodBeat.o(56117);
        }
    };
    private HashMap<String, eox> yNC = new HashMap<>();
    private Button yNn;
    MyLocationButton yNo;
    private TipSayingWidget yNp;
    k yNq;
    q yNr = n.ecR();
    j yNs;
    i yNt;
    private com.tencent.mm.plugin.location.ui.g yNu;
    private com.tencent.mm.modelgeo.d yNv = com.tencent.mm.modelgeo.d.bca();
    private ShareHeader yNw;
    private String yNx;
    private long yNy = 0;
    private long yNz = 0;

    @Override // com.tencent.mm.plugin.location.ui.impl.a, com.tencent.mm.plugin.location.ui.impl.k, com.tencent.mm.plugin.k.a
    public final boolean edH() {
        return true;
    }

    public h(Activity activity) {
        super(activity);
        AppMethodBeat.i(56125);
        AppMethodBeat.o(56125);
    }

    @Override // com.tencent.mm.plugin.location.ui.impl.a, com.tencent.mm.plugin.location.ui.impl.k, com.tencent.mm.plugin.k.a
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(56126);
        super.onCreate(bundle);
        Log.i("MicroMsg.ShareMapUI", "onCreate");
        this.yNy = System.currentTimeMillis();
        EventCenter.instance.addListener(this.qCu);
        AppMethodBeat.o(56126);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x02d1  */
    @Override // com.tencent.mm.plugin.location.ui.impl.a, com.tencent.mm.plugin.location.ui.impl.k
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void edG() {
        /*
        // Method dump skipped, instructions count: 763
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.location.ui.impl.h.edG():void");
    }

    @Override // com.tencent.mm.plugin.location.ui.impl.a, com.tencent.mm.plugin.location.ui.impl.k, com.tencent.mm.plugin.k.a
    public final void onResume() {
        boolean z;
        AppMethodBeat.i(56128);
        Log.i("MicroMsg.ShareMapUI", "resume");
        super.onResume();
        this.wakeLock.acquire();
        q qVar = this.yNr;
        Log.d("MicorMsg.TrackRefreshManager", "resume isPuase:" + qVar.yGM);
        if (qVar.yGM) {
            qVar.yGS = System.currentTimeMillis();
            qVar.iOv.a(qVar.gmA);
            qVar.yGG.a(qVar.yGU);
        }
        qVar.yGM = false;
        qVar.ecX();
        q qVar2 = this.yNr;
        com.tencent.mm.plugin.k.d dVar = this.yKV.yHR;
        qVar2.yGI = qVar2.yGN;
        Log.d("MicorMsg.TrackRefreshManager", "resumeStatus upload_status  " + qVar2.yGI + " %f %f %d ", Double.valueOf(qVar2.yFu), Double.valueOf(qVar2.yFv), Integer.valueOf(qVar2.yFw));
        if (qVar2.yFu == -1000.0d || qVar2.yFv == -1000.0d || qVar2.yFw == -1) {
            z = false;
        } else {
            dVar.getIController().setCenter(qVar2.yFu, qVar2.yFv);
            dVar.getIController().setZoom(qVar2.yFw);
            z = true;
        }
        if (z) {
            this.yNo.setAnimToSelf(false);
            this.yNo.edg();
            this.yNq.yKi = false;
            this.yNq.yKc = true;
        }
        q qVar3 = this.yNr;
        com.tencent.mm.plugin.k.d dVar2 = this.yKV.yHR;
        if (qVar3.yGQ != -1) {
            dVar2.getIController().setZoom(qVar3.yGQ);
        }
        if (this.yNv != null) {
            this.yNv.a(this.gmA);
        }
        if (this.yNq != null) {
            this.yNq.onResume();
        }
        AppMethodBeat.o(56128);
    }

    @Override // com.tencent.mm.plugin.location.ui.impl.a, com.tencent.mm.plugin.location.ui.impl.k, com.tencent.mm.plugin.k.a
    public final void onPause() {
        AppMethodBeat.i(56129);
        Log.i("MicroMsg.ShareMapUI", "pause");
        super.onPause();
        this.wakeLock.release();
        q qVar = this.yNr;
        Log.d("MicorMsg.TrackRefreshManager", "pause isShared:" + qVar.yGL);
        if (!qVar.yGL) {
            qVar.iOv.c(qVar.gmA);
            qVar.yGG.b(qVar.yGU);
            qVar.yGM = true;
            qVar.yGR = true;
        }
        q qVar2 = this.yNr;
        com.tencent.mm.plugin.k.d dVar = this.yKV.yHR;
        qVar2.yGN = qVar2.yGI;
        qVar2.yGI = 0;
        Log.d("MicorMsg.TrackRefreshManager", "saveStatus pause_save_upload_status: " + qVar2.yGN);
        if (qVar2.edb()) {
            qVar2.yFu = (((double) dVar.getMapCenterX()) * 1.0d) / 1000000.0d;
            qVar2.yFv = (((double) dVar.getMapCenterY()) * 1.0d) / 1000000.0d;
            qVar2.yFw = dVar.getZoom();
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(10997, "17", 0, 0, Long.valueOf(System.currentTimeMillis() - this.yNy));
        this.yNy = System.currentTimeMillis();
        if (this.yNv != null) {
            this.yNv.c(this.gmA);
        }
        if (this.yNq != null) {
            this.yNq.onPause();
        }
        AppMethodBeat.o(56129);
    }

    @Override // com.tencent.mm.plugin.location.ui.impl.a, com.tencent.mm.plugin.location.ui.impl.k, com.tencent.mm.plugin.k.a
    public final void onDestroy() {
        AppMethodBeat.i(56130);
        super.onDestroy();
        q qVar = this.yNr;
        q.b bVar = this.yNA;
        Iterator<WeakReference<q.b>> it = qVar.yGH.iterator();
        while (true) {
            if (it.hasNext()) {
                WeakReference<q.b> next = it.next();
                if (next != null && next.get() != null && next.get().equals(bVar)) {
                    qVar.yGH.remove(next);
                    break;
                }
            } else {
                break;
            }
        }
        EventCenter.instance.removeListener(this.qCu);
        this.yNr.yGP = null;
        if (this.yNt != null) {
            i iVar = this.yNt;
            iVar.yJL.b(iVar);
            VolumeMeter volumeMeter = iVar.yJy;
            volumeMeter.yKv.removeCallbacks(volumeMeter);
            volumeMeter.yKv.post(volumeMeter.yKJ);
        }
        if (this.yNq != null) {
            this.yNq.destroy();
        }
        if (this.yNo != null) {
            com.tencent.mm.modelgeo.d.bca().c(this.yNo.gmA);
        }
        Log.i("MicroMsg.ShareMapUI", "onDestory");
        AppMethodBeat.o(56130);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.location.ui.impl.a, com.tencent.mm.plugin.location.ui.impl.k
    public final void edF() {
        AppMethodBeat.i(56131);
        super.edF();
        AppMethodBeat.o(56131);
    }

    @Override // com.tencent.mm.plugin.location.ui.j.a
    public final void edx() {
        AppMethodBeat.i(56132);
        this.yNr.yGQ = this.yKV.yHR.getZoom();
        this.activity.finish();
        AppMethodBeat.o(56132);
    }

    private void edX() {
        AppMethodBeat.i(56133);
        hideVKB();
        this.yNq.qJ(false);
        this.yNr.stop();
        this.yNr.Px(3);
        i.edv();
        this.yNr.yGQ = this.yKV.yHR.getZoom();
        this.activity.finish();
        AppMethodBeat.o(56133);
    }

    @Override // com.tencent.mm.plugin.location.ui.j.a
    public final void edy() {
        AppMethodBeat.i(56134);
        this.yNq.qJ(false);
        this.yNr.stop();
        this.yNr.Px(0);
        i.edv();
        this.activity.finish();
        AppMethodBeat.o(56134);
    }

    @Override // com.tencent.mm.plugin.location.ui.j.a
    public final void Py(int i2) {
        AppMethodBeat.i(56135);
        if (i2 == 0) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(10997, "8", "", 0, 0);
            edX();
            AppMethodBeat.o(56135);
        } else if (i2 == 1) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(10997, "8", "", 0, 0);
            edX();
            AppMethodBeat.o(56135);
        } else {
            if (i2 == 2) {
                edX();
            }
            AppMethodBeat.o(56135);
        }
    }

    @Override // com.tencent.mm.plugin.location.ui.impl.a, com.tencent.mm.plugin.k.a
    public final void onBackPressed() {
        AppMethodBeat.i(56136);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(10997, "11", 0, 0, 0);
        this.yNs.edw();
        AppMethodBeat.o(56136);
    }

    @Override // com.tencent.mm.plugin.location.ui.impl.a, com.tencent.mm.plugin.k.a
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(56137);
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(56137);
        return dispatchKeyEvent;
    }

    @Override // com.tencent.mm.plugin.location.ui.impl.k
    public final void edY() {
        AppMethodBeat.i(56138);
        super.edY();
        if (this.yNq != null) {
            this.yNq.yKi = false;
            this.yNq.qI(false);
            this.yNo.edg();
        }
        AppMethodBeat.o(56138);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.location.ui.impl.k
    public final void edZ() {
        AppMethodBeat.i(56139);
        super.edZ();
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(10997, "1", "", 0, 0);
        AppMethodBeat.o(56139);
    }

    static /* synthetic */ void a(h hVar, dmb dmb) {
        a aVar;
        AppMethodBeat.i(56140);
        Log.d("MicroMsg.ShareMapUI", "refreshSuccess, timeout = %b", Boolean.valueOf(hVar.yNr.isTimeout));
        LinkedList<eox> linkedList = dmb.MPF;
        LinkedList<eox> linkedList2 = new LinkedList();
        a aCZ = n.ecS().aCZ(hVar.rgD);
        if (aCZ == null) {
            a aVar2 = new a();
            aVar2.latitude = -1000.0d;
            aVar2.longitude = -1000.0d;
            aVar = aVar2;
        } else {
            aVar = aCZ;
        }
        LinkedList<String> linkedList3 = new LinkedList<>();
        for (eox eox : linkedList) {
            linkedList3.add(eox.Username);
        }
        if (!linkedList3.contains(z.aTY())) {
            linkedList3.add(z.aTY());
        }
        n.ecS().a(hVar.rgD, linkedList3, aVar.latitude, aVar.longitude, aVar.yFq, "", "");
        for (eox eox2 : linkedList) {
            if (Math.abs(eox2.NmV.KUt) > 180.0d || Math.abs(eox2.NmV.KUu) > 90.0d) {
                eox eox3 = hVar.yNC.get(eox2.Username);
                if (eox3 != null) {
                    linkedList2.add(eox3);
                    Log.i("MicroMsg.ShareMapUI", "error from server get latlng %s %f %f and use old one %f %f", eox2.Username, Double.valueOf(eox2.NmV.KUu), Double.valueOf(eox2.NmV.KUt), Double.valueOf(eox3.NmV.KUu), Double.valueOf(eox3.NmV.KUt));
                } else {
                    Log.i("MicroMsg.ShareMapUI", "error from server get latlng %s %f %f cannot user old one", eox2.Username, Double.valueOf(eox2.NmV.KUu), Double.valueOf(eox2.NmV.KUt));
                }
            } else {
                linkedList2.add(eox2);
            }
        }
        hVar.yNC.clear();
        for (eox eox4 : linkedList2) {
            hVar.yNC.put(eox4.Username, eox4);
        }
        int size = linkedList2.size();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(z.aTY());
        if (size >= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("refreshSuccess, count =  ".concat(String.valueOf(size)));
            for (int i2 = 0; i2 < linkedList2.size(); i2++) {
                eox eox5 = (eox) linkedList2.get(i2);
                sb.append("[" + eox5.Username + " ] ");
                sb.append(eox5.NmV.MIv + " ");
                sb.append(eox5.NmV.KUu + " ");
                sb.append(eox5.NmV.KUt + " ");
                arrayList.add(eox5.Username);
            }
            Log.v("MicroMsg.ShareMapUI", "refreshSuccess TrackRoom num: " + sb.toString());
            if (hVar.yNq != null) {
                hVar.yNq.fm(linkedList2);
            }
        }
        if (hVar.yNq.yKe) {
            k kVar = hVar.yNq;
            ejg ejg = dmb.MPG;
            if (kVar.yKh == null) {
                kVar.yKh = new ejg();
            }
            if (ejg != null) {
                Log.d("MicroMsg.TrackPointViewMgrImpl", "set trackitem  " + ejg.KUu + " " + ejg.KUt);
                kVar.yKh.MCE = ejg.MCE;
                kVar.yKh.KUu = ejg.KUu;
                kVar.yKh.KUt = ejg.KUt;
            }
        }
        hVar.yNu.aw(arrayList);
        AppMethodBeat.o(56140);
    }
}
