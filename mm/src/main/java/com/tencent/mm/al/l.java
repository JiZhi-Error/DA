package com.tencent.mm.al;

import android.database.Cursor;
import android.net.Uri;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.api.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.protobuf.aam;
import com.tencent.mm.protocal.protobuf.dvm;
import com.tencent.mm.protocal.protobuf.dws;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import java.util.Iterator;
import java.util.LinkedList;

public final class l {
    private static long iOB = 0;
    private b.a gmA;
    public dvm iOA;
    private int iOu;
    private d iOv;
    private int iOw;
    private int iOx;
    private boolean iOy;
    private MStorageEx.IOnStorageChange iOz;
    private String userName;

    static /* synthetic */ void a(l lVar, String str, float f2, float f3, int i2) {
        AppMethodBeat.i(212173);
        a(str, 0, f2, f3, i2);
        AppMethodBeat.o(212173);
    }

    static /* synthetic */ void a(String str, int i2, LinkedList linkedList, int i3, dvm dvm) {
        AppMethodBeat.i(124100);
        a(str, i2, 0, 0.0f, 0.0f, 0, linkedList, i3, dvm, null);
        AppMethodBeat.o(124100);
    }

    protected l() {
        AppMethodBeat.i(124090);
        this.userName = null;
        this.iOu = 0;
        this.iOw = 2;
        this.iOx = 10;
        this.iOy = false;
        this.iOz = new MStorageEx.IOnStorageChange() {
            /* class com.tencent.mm.al.l.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
            public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
                AppMethodBeat.i(124086);
                if (obj == null || !(obj instanceof String)) {
                    Log.i("MicroMsg.ReportLocation", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i2), mStorageEx, obj);
                    AppMethodBeat.o(124086);
                    return;
                }
                if (l.this.userName.equals((String) obj) && l.this.iOu == 1) {
                    Log.i("MicroMsg.ReportLocation", "contactStgUpdate, %s", l.this.userName);
                    l.this.Ns(l.this.userName);
                    ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().remove(l.this.iOz);
                }
                AppMethodBeat.o(124086);
            }
        };
        this.gmA = new b.a() {
            /* class com.tencent.mm.al.l.AnonymousClass2 */
            long lastReportTime = 0;

            @Override // com.tencent.mm.modelgeo.b.a
            public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
                AppMethodBeat.i(124087);
                if (!z) {
                    AppMethodBeat.o(124087);
                    return true;
                }
                Log.i("MicroMsg.ReportLocation", "LBSManager notify. lat:%f, lng:%f", Float.valueOf(f3), Float.valueOf(f2));
                if (Util.nowSecond() >= this.lastReportTime + ((long) l.this.iOx)) {
                    l.a(l.this, l.this.userName, f3, f2, (int) d3);
                    this.lastReportTime = Util.nowSecond();
                }
                if (l.this.iOu == 2) {
                    l.this.aZU();
                }
                if (!l.this.iOy) {
                    l.this.iOy = true;
                    o.a(2013, f2, f3, (int) d3);
                }
                AppMethodBeat.o(124087);
                return true;
            }
        };
        this.iOx = Util.getInt(((a) g.af(a.class)).aqK().aj("BrandService", "continueLocationReportInterval"), 5);
        if (this.iOx < this.iOw) {
            this.iOx = this.iOw;
        }
        Log.i("MicroMsg.ReportLocation", "reportLocation interval %d", Integer.valueOf(this.iOx));
        AppMethodBeat.o(124090);
    }

    public final void a(final String str, final ca caVar, final int i2, final dvm dvm) {
        AppMethodBeat.i(124091);
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.al.l.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(124088);
                l.a(dvm, str);
                if (caVar == null || !caVar.gAt()) {
                    l.a(str, 10, (LinkedList) null, i2, dvm);
                    AppMethodBeat.o(124088);
                    return;
                }
                LinkedList linkedList = new LinkedList();
                u a2 = ((com.tencent.mm.plugin.biz.a.a) g.af(com.tencent.mm.plugin.biz.a.a.class)).a(caVar.field_msgId, caVar.field_content);
                if (a2 == null || Util.isNullOrNil(a2.iAd)) {
                    l.a(str, 10, (LinkedList) null, i2, dvm);
                    AppMethodBeat.o(124088);
                    return;
                }
                Iterator it = a2.iAd.iterator();
                while (it.hasNext()) {
                    v vVar = (v) it.next();
                    String str = vVar.url;
                    if (!Util.isNullOrNil(str)) {
                        Uri parse = Uri.parse(str);
                        try {
                            String queryParameter = parse.getQueryParameter("mid");
                            String queryParameter2 = parse.getQueryParameter("idx");
                            aam aam = new aam();
                            aam.iAQ = Util.getLong(queryParameter, 0);
                            aam.idx = Util.getInt(queryParameter2, 0);
                            aam.dNI = vVar.iAv;
                            aam.path = vVar.weappPath;
                            linkedList.add(aam);
                        } catch (UnsupportedOperationException e2) {
                            Log.w("MicroMsg.ReportLocation", "UnsupportedOperationException %s", e2.getMessage());
                        }
                    }
                }
                l.a(str, 10, linkedList, i2, dvm);
                AppMethodBeat.o(124088);
            }
        });
        AppMethodBeat.o(124091);
    }

    public final void a(final String str, final dvm dvm) {
        AppMethodBeat.i(124092);
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.al.l.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(124089);
                l.a(dvm, str);
                l.a(str, 12, (LinkedList) null, 0, dvm);
                AppMethodBeat.o(124089);
            }
        });
        AppMethodBeat.o(124092);
    }

    public static void a(dvm dvm, String str) {
        AppMethodBeat.i(124093);
        if (dvm == null || dvm.MWA <= 0) {
            AppMethodBeat.o(124093);
            return;
        }
        int min = Math.min(dvm.MWA, 30);
        dvm.MWD = 0;
        dvm.MWE = 0;
        Cursor H = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().H(str, min, 0L);
        while (H.moveToNext()) {
            ca caVar = new ca();
            caVar.convertFrom(H);
            if (caVar.field_isSend != 1) {
                if (caVar.gDj()) {
                    dvm.MWE++;
                } else {
                    bp.b Ky = bp.Ky(caVar.fqK);
                    if (Ky != null && Ky.iEp == 3) {
                        dvm.MWD++;
                    }
                }
            }
        }
        H.close();
        AppMethodBeat.o(124093);
    }

    public final void Np(String str) {
        AppMethodBeat.i(212169);
        a(str, 14, 0, 0.0f, 0.0f, 0, null, 0, this.iOA, null);
        AppMethodBeat.o(212169);
    }

    public static void a(String str, dws dws, int i2) {
        AppMethodBeat.i(124094);
        a(str, i2, 0, 0.0f, 0.0f, 0, null, 0, null, dws);
        AppMethodBeat.o(124094);
    }

    public static void Nq(String str) {
        AppMethodBeat.i(176139);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(176139);
            return;
        }
        if (g.Nh(str)) {
            ag.bat().a(str, null, 0, null);
        }
        AppMethodBeat.o(176139);
    }

    public static void Nr(String str) {
        AppMethodBeat.i(176140);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(176140);
            return;
        }
        if (g.Nh(str)) {
            ag.bat().a(str, (dvm) null);
        }
        AppMethodBeat.o(176140);
    }

    public final void Ns(String str) {
        AppMethodBeat.i(124095);
        Log.i("MicroMsg.ReportLocation", "Start report");
        this.userName = str;
        c fJ = g.fJ(str);
        if (fJ == null) {
            AppMethodBeat.o(124095);
            return;
        }
        if (this.iOu != 0) {
            aZU();
        }
        this.iOu = 0;
        if (fJ.Uz()) {
            Log.i("MicroMsg.ReportLocation", "need update contact %s", str);
            com.tencent.mm.aj.c.Mf(str);
        }
        c.b cG = fJ.cG(false);
        if (cG == null) {
            AppMethodBeat.o(124095);
        } else if (!cG.UB() || !fJ.Uy()) {
            if (cG.UB() && !fJ.Uy()) {
                a(str, 1, 0.0f, 0.0f, 0);
            }
            AppMethodBeat.o(124095);
        } else {
            this.iOv = d.bca();
            c.b cG2 = fJ.cG(false);
            if (cG2.dhz != null) {
                cG2.dhN = Util.getInt(cG2.dhz.optString("ReportLocationType"), 0) == 2;
            }
            this.iOu = cG2.dhN ? 3 : 2;
            if (d.bcc() || d.bcd()) {
                this.iOv.a(this.gmA, true);
                AppMethodBeat.o(124095);
                return;
            }
            a(str, 2, 0.0f, 0.0f, 0);
            AppMethodBeat.o(124095);
        }
    }

    public final void aZU() {
        AppMethodBeat.i(124096);
        Log.i("MicroMsg.ReportLocation", "Stop report");
        this.iOu = 0;
        if (this.iOv != null) {
            this.iOv.c(this.gmA);
        }
        if (g.aAf().azp()) {
            ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().remove(this.iOz);
        }
        AppMethodBeat.o(124096);
    }

    private static void a(String str, int i2, float f2, float f3, int i3) {
        AppMethodBeat.i(124097);
        a(str, 11, i2, f2, f3, i3, null);
        AppMethodBeat.o(124097);
    }

    private static void a(String str, int i2, int i3, float f2, float f3, int i4, LinkedList<aam> linkedList) {
        AppMethodBeat.i(212170);
        a(str, 11, i3, f2, f3, i4, null, 0, null, null);
        AppMethodBeat.o(212170);
    }

    public static void a(String str, int i2, int i3, float f2, float f3, int i4, LinkedList<aam> linkedList, int i5, dvm dvm, dws dws) {
        String format;
        AppMethodBeat.i(124099);
        if (i3 == 3) {
            format = "<event></event>";
        } else {
            format = String.format("<event><location><errcode>%d</errcode><data><latitude>%f</latitude><longitude>%f</longitude><precision>%d</precision></data></location></event>", Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i4));
        }
        Log.i("MicroMsg.ReportLocation", "doScene, info: %s", format);
        g.aAg().hqi.a(new w(str, i2, format, linkedList, i5, dvm, dws), 0);
        AppMethodBeat.o(124099);
    }

    static {
        AppMethodBeat.i(176144);
        AppMethodBeat.o(176144);
    }

    public static void a(as asVar, ca caVar, int i2, int i3, long j2) {
        AppMethodBeat.i(176141);
        iOB = j2;
        b.a(asVar, caVar, i2, i3, j2);
        AppMethodBeat.o(176141);
    }

    public static void S(ca caVar) {
        AppMethodBeat.i(212171);
        b.a(caVar, iOB);
        AppMethodBeat.o(212171);
    }

    public static void c(ca caVar, long j2) {
        AppMethodBeat.i(261599);
        b.a(caVar, j2);
        AppMethodBeat.o(261599);
    }
}
