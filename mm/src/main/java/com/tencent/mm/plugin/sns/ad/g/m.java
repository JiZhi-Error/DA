package com.tencent.mm.plugin.sns.ad.g;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.cfy;
import com.tencent.mm.protocal.protobuf.dzz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class m implements i {
    public static int Dwb = 20480;
    public static int Dwc = 30720;
    public static int Dwd = 51200;
    public static int Dwe = 60;
    public static int Dwf = 1800;
    public static int Dwg = 43200;
    private int Dwa = 0;
    private long Dwh = 0;
    private dzz Dwi = new dzz();
    private boolean Dwj = false;
    private long Dwk = 0;
    private int Dwl = 0;
    private Random random = new Random(System.currentTimeMillis());

    public m() {
        AppMethodBeat.i(95031);
        AppMethodBeat.o(95031);
    }

    public final void a(final int i2, final Object... objArr) {
        AppMethodBeat.i(95032);
        aj.faB().execute(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ad.g.m.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(95026);
                cfy cfy = new cfy();
                cfy.MlF = i2;
                cfy.MlM = (int) (System.currentTimeMillis() / 1000);
                cfy.oTz = 1;
                String u = m.u(objArr);
                cfy.MlG = new b(u.getBytes());
                m.this.Dwi.KGB.add(cfy);
                Log.i("MicroMsg.SnsLogMgr", "snsadlog " + i2 + " " + u);
                if (m.this.Dwh == 0) {
                    m.this.Dwh = System.currentTimeMillis();
                }
                AppMethodBeat.o(95026);
            }
        });
        if (this.Dwj) {
            AppMethodBeat.o(95032);
            return;
        }
        this.Dwj = true;
        h.RTc.o(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ad.g.m.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(95027);
                aj.faB().execute(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ad.g.m.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(179066);
                        m.this.Dwj = false;
                        m.this.eXu();
                        AppMethodBeat.o(179066);
                    }
                });
                AppMethodBeat.o(95027);
            }
        }, 2000);
        AppMethodBeat.o(95032);
    }

    public final void eXu() {
        boolean z;
        int i2;
        AppMethodBeat.i(95033);
        if (!aj.DKh) {
            AppMethodBeat.o(95033);
            return;
        }
        g.aAi();
        int intValue = ((Integer) g.aAh().azQ().get(ar.a.BUSINESS_SNS_ADLOG_CNTTIME_INT, (Object) 0)).intValue();
        g.aAi();
        int intValue2 = ((Integer) g.aAh().azQ().get(ar.a.BUSINESS_SNS_ADLOG_FREQUENCY_INT, (Object) -1)).intValue();
        if (intValue2 > Dwg || intValue2 < 0) {
            intValue2 = this.random.nextInt((Dwf - Dwe) + 1) + Dwe;
        }
        if ((System.currentTimeMillis() / 1000) - ((long) intValue) > ((long) intValue2)) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            eXv();
            Log.d("MicroMsg.SnsLogMgr", "pass report ");
            AppMethodBeat.o(95033);
            return;
        }
        p faH = aj.faH();
        Log.i("MicroMsg.SnsKvReportStg", " getLast ".concat(String.valueOf("select rowid from SnsReportKv order by rowid desc  limit 1")));
        Cursor rawQuery = faH.iFy.rawQuery("select rowid from SnsReportKv order by rowid desc  limit 1", null, 2);
        if (rawQuery.moveToFirst()) {
            i2 = rawQuery.getInt(0);
        } else {
            i2 = 0;
        }
        rawQuery.close();
        this.Dwa = i2;
        eXw();
        eXv();
        AppMethodBeat.o(95033);
    }

    private void eXv() {
        AppMethodBeat.i(95034);
        aj.faB().execute(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ad.g.m.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(95028);
                if (System.currentTimeMillis() - m.this.Dwh >= Util.MILLSECONDS_OF_MINUTE || m.this.Dwi.KGB.size() > 1000) {
                    if (m.this.Dwi != null && m.this.Dwi.KGB.size() > 0) {
                        m.d(m.this);
                    }
                    m.this.Dwh = 0;
                }
                AppMethodBeat.o(95028);
            }
        });
        AppMethodBeat.o(95034);
    }

    private void eXw() {
        AppMethodBeat.i(95035);
        aj.faB().execute(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ad.g.m.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(95029);
                m.e(m.this);
                AppMethodBeat.o(95029);
            }
        });
        AppMethodBeat.o(95035);
    }

    public static String u(Object... objArr) {
        String str;
        AppMethodBeat.i(95036);
        if (objArr == null || objArr.length <= 0) {
            Log.w("MicroMsg.SnsLogMgr", "vals is null, use '' as value");
            str = "";
        } else {
            StringBuilder sb = new StringBuilder();
            int length = objArr.length - 1;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.valueOf(objArr[i2])).append(',');
            }
            sb.append(String.valueOf(objArr[length]));
            str = sb.toString();
        }
        AppMethodBeat.o(95036);
        return str;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(95037);
        if (qVar.getType() == 1802 && (qVar instanceof h)) {
            h hVar = (h) qVar;
            if (i2 == 0 && i3 == 0) {
                g.aAi();
                g.aAh().azQ().set(ar.a.BUSINESS_SNS_ADLOG_CNTTIME_INT, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                eXw();
                AppMethodBeat.o(95037);
                return;
            }
            List<cfy> list = hVar.nZr;
            p faH = aj.faH();
            dzz dzz = new dzz();
            for (cfy cfy : list) {
                dzz.KGB.add(cfy);
            }
            faH.a(dzz);
        }
        AppMethodBeat.o(95037);
    }

    static /* synthetic */ void d(m mVar) {
        AppMethodBeat.i(95038);
        if (mVar.Dwi.KGB.size() > 0) {
            Log.i("MicroMsg.SnsLogMgr", "trigerSave " + mVar.Dwi.KGB.size());
            aj.faH().a(mVar.Dwi);
            mVar.Dwi.KGB.clear();
        }
        AppMethodBeat.o(95038);
    }

    static /* synthetic */ void e(m mVar) {
        int i2;
        String str;
        int i3;
        AppMethodBeat.i(95039);
        if (Util.ticksToNow(mVar.Dwk) >= 100 || mVar.Dwl <= 0) {
            mVar.Dwl = Dwb;
            if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                mVar.Dwl = Dwd;
            }
            if (NetStatusUtil.is3G(MMApplicationContext.getContext()) || NetStatusUtil.is4G(MMApplicationContext.getContext())) {
                mVar.Dwl = Dwc;
            }
            if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
                mVar.Dwl = Dwb;
            }
            mVar.Dwk = SystemClock.elapsedRealtime();
            i2 = mVar.Dwl;
        } else {
            i2 = mVar.Dwl;
        }
        LinkedList linkedList = new LinkedList();
        dzz iH = aj.faH().iH(i2, mVar.Dwa);
        if (iH.KGB.size() == 0) {
            str = "read from memery";
            i3 = 0;
            while (mVar.Dwi.KGB.size() > 0) {
                cfy remove = mVar.Dwi.KGB.remove();
                if (remove.MlG.zy.length + i3 >= i2) {
                    break;
                }
                i3 += remove.MlG.zy.length;
                linkedList.add(remove);
            }
        } else {
            str = "read from db";
            i3 = 0;
            while (iH.KGB.size() > 0) {
                cfy remove2 = iH.KGB.remove();
                linkedList.add(remove2);
                i3 = remove2.MlG.zy.length + i3;
            }
        }
        if (linkedList.size() == 0) {
            Log.i("MicroMsg.SnsLogMgr", "nothing for report");
            AppMethodBeat.o(95039);
            return;
        }
        Log.i("MicroMsg.SnsLogMgr", "size " + i3 + " " + linkedList.size() + " " + i2 + " logItemList.LogList.size  " + mVar.Dwi.KGB.size() + " label:  " + str);
        h hVar = new h(linkedList);
        g.aAi();
        g.aAg().hqi.a(hVar, 0);
        AppMethodBeat.o(95039);
    }
}
