package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.ab;
import com.tencent.mm.plugin.sns.storage.ac;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.protocal.protobuf.bhr;
import com.tencent.mm.protocal.protobuf.bhs;
import com.tencent.mm.protocal.protobuf.brb;
import com.tencent.mm.protocal.protobuf.brc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class m {
    private static final m ElW = new m();
    private b ElX = aj.faP();
    public ac ElY = aj.faQ();
    public Map<String, String> ElZ = new HashMap();
    private Map<Long, String> aNT = new HashMap();

    static {
        AppMethodBeat.i(97409);
        AppMethodBeat.o(97409);
    }

    public static m feB() {
        return ElW;
    }

    private m() {
        AppMethodBeat.i(97400);
        new MMHandler("OpenCanvasMgr").postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(97397);
                m.a(m.this);
                AppMethodBeat.o(97397);
            }
        }, 5000);
        AppMethodBeat.o(97400);
    }

    public final String p(long j2, int i2, int i3) {
        AppMethodBeat.i(97401);
        Log.i("OpenCanvasMgr", "open pageId %d, preLoad %d", Long.valueOf(j2), Integer.valueOf(i2));
        if (j2 <= 0) {
            AppMethodBeat.o(97401);
            return "";
        }
        String str = "";
        if (i3 != 1) {
            str = JD(j2);
        }
        if (i2 != 1) {
            AppMethodBeat.o(97401);
            return str;
        } else if (TextUtils.isEmpty(str)) {
            X(j2, i2);
            AppMethodBeat.o(97401);
            return "";
        } else {
            AppMethodBeat.o(97401);
            return str;
        }
    }

    private String JD(long j2) {
        AppMethodBeat.i(97402);
        if (this.aNT.containsKey(Long.valueOf(j2))) {
            String str = this.aNT.get(Long.valueOf(j2));
            AppMethodBeat.o(97402);
            return str;
        }
        a aVar = new a();
        aVar.field_canvasId = j2;
        this.ElX.get(aVar, new String[0]);
        if (!TextUtils.isEmpty(aVar.field_canvasXml)) {
            this.aNT.put(Long.valueOf(j2), aVar.field_canvasXml);
            String str2 = aVar.field_canvasXml;
            AppMethodBeat.o(97402);
            return str2;
        }
        AppMethodBeat.o(97402);
        return "";
    }

    private void X(final long j2, final int i2) {
        AppMethodBeat.i(97403);
        final a aVar = new a();
        aVar.field_canvasId = j2;
        d.a aVar2 = new d.a();
        aVar2.iLN = new bhr();
        aVar2.iLO = new bhs();
        aVar2.uri = "/cgi-bin/mmoc-bin/adplayinfo/get_adcanvasinfo";
        aVar2.funcId = 1286;
        d aXF = aVar2.aXF();
        ((bhr) aXF.iLK.iLR).gTg = j2;
        aa.a(aXF, new aa.a() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m.AnonymousClass2 */

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, d dVar, q qVar) {
                AppMethodBeat.i(97398);
                if (i2 == 0 && i3 == 0) {
                    bhs bhs = (bhs) dVar.iLL.iLR;
                    Log.i("OpenCanvasMgr", "getCanvasInfo pageid %d ,xml %s", Long.valueOf(j2), bhs.LSf);
                    if (!TextUtils.isEmpty(bhs.LSf)) {
                        m.this.aNT.put(Long.valueOf(j2), bhs.LSf);
                        aVar.field_canvasXml = bhs.LSf;
                        m.this.ElX.a(aVar);
                    }
                    AppMethodBeat.o(97398);
                } else {
                    Log.e("OpenCanvasMgr", "cgi fail page id %d,preLoad %d, errType %d,errCode %d", Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i2), Integer.valueOf(i3));
                    AppMethodBeat.o(97398);
                }
                return 0;
            }
        });
        AppMethodBeat.o(97403);
    }

    public final void J(long j2, String str) {
        AppMethodBeat.i(97404);
        if (!TextUtils.isEmpty(str) && j2 > 0) {
            this.aNT.put(Long.valueOf(j2), str);
            a aVar = new a();
            aVar.field_canvasId = j2;
            aVar.field_canvasXml = str;
            this.ElX.a(aVar);
        }
        AppMethodBeat.o(97404);
    }

    public final String n(String str, String str2, int i2, int i3) {
        AppMethodBeat.i(97405);
        Log.i("OpenCanvasMgr", "open pageId %s, canvasExt %s, preLoad %d", str, str2, Integer.valueOf(i2));
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(97405);
            return "";
        }
        String str3 = "";
        if (i3 != 1) {
            str3 = kI(str, str2);
        }
        if (i2 != 1) {
            AppMethodBeat.o(97405);
            return str3;
        } else if (TextUtils.isEmpty(str3)) {
            ai(str, str2, i2);
            AppMethodBeat.o(97405);
            return "";
        } else {
            AppMethodBeat.o(97405);
            return str3;
        }
    }

    private String kI(String str, String str2) {
        String str3;
        AppMethodBeat.i(97406);
        if (!Util.isNullOrNil(str2)) {
            str3 = str + str2;
        } else {
            str3 = str;
        }
        if (this.ElZ.containsKey(str3)) {
            String str4 = this.ElZ.get(str3);
            AppMethodBeat.o(97406);
            return str4;
        }
        ab abVar = new ab();
        abVar.field_canvasId = str;
        abVar.field_canvasExt = str2;
        this.ElY.get(abVar, "canvasId", "canvasExt");
        if (!TextUtils.isEmpty(abVar.field_canvasXml)) {
            this.ElZ.put(str3, abVar.field_canvasXml);
            String str5 = abVar.field_canvasXml;
            AppMethodBeat.o(97406);
            return str5;
        }
        AppMethodBeat.o(97406);
        return "";
    }

    private void ai(final String str, String str2, final int i2) {
        AppMethodBeat.i(97407);
        final ab abVar = new ab();
        abVar.field_canvasId = str;
        d.a aVar = new d.a();
        aVar.iLN = new brb();
        aVar.iLO = new brc();
        aVar.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_getofficialcanvasinfo";
        aVar.funcId = 1890;
        d aXF = aVar.aXF();
        brb brb = (brb) aXF.iLK.iLR;
        brb.LYB = str;
        brb.LYC = str2;
        aa.a(aXF, new aa.a() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m.AnonymousClass3 */

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, d dVar, q qVar) {
                AppMethodBeat.i(97399);
                if (i2 == 0 && i3 == 0) {
                    String yO = ((brc) dVar.iLL.iLR).LYD.yO();
                    Log.i("OpenCanvasMgr", "getCanvasInfo pageid %s ,xml %s", str, yO);
                    if (!TextUtils.isEmpty(yO)) {
                        m.this.ElZ.put(str, yO);
                        abVar.field_canvasXml = yO;
                        m.this.ElY.a(abVar);
                    }
                    AppMethodBeat.o(97399);
                } else {
                    Log.e("OpenCanvasMgr", "cgi fail pageid %s,preLoad %d, errType %d,errCode %d", str, Integer.valueOf(i2), Integer.valueOf(i2), Integer.valueOf(i3));
                    AppMethodBeat.o(97399);
                }
                return 0;
            }
        });
        AppMethodBeat.o(97407);
    }

    static /* synthetic */ void a(m mVar) {
        AppMethodBeat.i(97408);
        Log.i("OpenCanvasMgr", "clearing old canvasInfo cache");
        ArrayList<a> arrayList = new ArrayList();
        Cursor all = mVar.ElX.getAll();
        if (all != null) {
            long currentTimeMillis = System.currentTimeMillis() - 777600000;
            while (all.moveToNext()) {
                a aVar = new a();
                aVar.convertFrom(all);
                if (aVar.field_createTime < currentTimeMillis) {
                    Log.i("OpenCanvasMgr", "ad canvas eliminate %d " + aVar.field_canvasId);
                    arrayList.add(aVar);
                }
            }
            all.close();
            for (a aVar2 : arrayList) {
                mVar.ElX.delete(aVar2, new String[0]);
            }
            ArrayList<ab> arrayList2 = new ArrayList();
            Cursor all2 = mVar.ElY.getAll();
            if (all2 != null) {
                long currentTimeMillis2 = System.currentTimeMillis() - 777600000;
                while (all2.moveToNext()) {
                    ab abVar = new ab();
                    abVar.convertFrom(all2);
                    if (abVar.field_createTime < currentTimeMillis2) {
                        Log.i("OpenCanvasMgr", "ux canvas eliminate %d " + abVar.field_canvasId);
                        arrayList2.add(abVar);
                    }
                }
                all2.close();
                for (ab abVar2 : arrayList2) {
                    mVar.ElY.delete(abVar2, new String[0]);
                }
            }
        }
        AppMethodBeat.o(97408);
    }
}
