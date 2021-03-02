package com.tencent.mm.plugin.r;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.ab;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.g.a.jh;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.api.e;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.am;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.r.a.a;
import com.tencent.mm.pluginsdk.model.app.ac;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.et;
import com.tencent.mm.protocal.protobuf.eu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.s;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class a implements com.tencent.mm.kernel.api.bucket.a, b, c, e, com.tencent.mm.kernel.b.c {
    private static volatile a ANq;
    private static HashMap<Integer, h.b> baseDBFactories;
    private d ANr;
    private f ANs;
    private i ANt;
    private j ANu;
    private l ANv;
    private n ANw;
    private com.tencent.mm.pluginsdk.model.app.e ANx;
    private IListener ANy = new IListener<jh>() {
        /* class com.tencent.mm.plugin.r.a.AnonymousClass4 */

        {
            AppMethodBeat.i(161788);
            this.__eventId = jh.class.getName().hashCode();
            AppMethodBeat.o(161788);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(jh jhVar) {
            AppMethodBeat.i(151515);
            a.eAU().add(jhVar.dOa.appId);
            AppMethodBeat.o(151515);
            return false;
        }
    };

    private a() {
        AppMethodBeat.i(151516);
        a.C1616a.a(new com.tencent.mm.plugin.r.a.a() {
            /* class com.tencent.mm.plugin.r.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.r.a.a
            public final g aJw(String str) {
                AppMethodBeat.i(151501);
                if (!com.tencent.mm.kernel.g.aAc()) {
                    AppMethodBeat.o(151501);
                    return null;
                }
                g bdG = a.eAS().bdG(str);
                AppMethodBeat.o(151501);
                return bdG;
            }

            @Override // com.tencent.mm.plugin.r.a.a
            public final g aJx(String str) {
                AppMethodBeat.i(151502);
                a.eAR();
                if (str == null || str.length() == 0) {
                    AppMethodBeat.o(151502);
                    return null;
                }
                LinkedList linkedList = new LinkedList();
                linkedList.add(str);
                ac acVar = new ac(linkedList);
                d.a aVar = new d.a();
                aVar.iLN = new et();
                aVar.iLO = new eu();
                aVar.uri = "/cgi-bin/micromsg-bin/appcenter";
                aVar.funcId = 452;
                aVar.iLP = 0;
                aVar.respCmdId = 0;
                com.tencent.mm.ak.d aXF = aVar.aXF();
                et etVar = (et) aXF.iLK.iLR;
                byte[] gmB = acVar.gmB();
                if (gmB != null) {
                    etVar.ReqBuf = new SKBuiltinBuffer_t().setBuffer(gmB);
                }
                etVar.oUv = 7;
                c.a e2 = ab.e(aXF);
                if (e2 == null) {
                    Log.e("MicroMsg.AppInfoService", "getSync resp == null");
                    AppMethodBeat.o(151502);
                    return null;
                }
                Log.e("MicroMsg.AppInfoService", "call getAppInfoList cgi result, errType = %d, errCode = %d", Integer.valueOf(e2.errType), Integer.valueOf(e2.errCode));
                if (e2.errType == 0 && e2.errCode == 0) {
                    acVar.cB(z.a(((eu) e2.iLC).KIk));
                    acVar.onGYNetEnd(0, e2.errType, e2.errCode, e2.errMsg, aXF, new byte[0]);
                    com.tencent.mm.plugin.r.a.a eAZ = a.C1616a.eAZ();
                    if (eAZ == null) {
                        Log.e("MicroMsg.AppInfoService", "getISubCorePluginBase() == null");
                        AppMethodBeat.o(151502);
                        return null;
                    }
                    g aJw = eAZ.aJw(str);
                    AppMethodBeat.o(151502);
                    return aJw;
                }
                AppMethodBeat.o(151502);
                return null;
            }

            @Override // com.tencent.mm.plugin.r.a.a
            public final Cursor eAW() {
                AppMethodBeat.i(151503);
                Cursor rawQuery = a.eAS().rawQuery(new StringBuilder("select * from AppInfo where status = 5 order by modifyTime asc").toString(), new String[0]);
                if (rawQuery == null) {
                    Log.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
                    AppMethodBeat.o(151503);
                    return null;
                }
                AppMethodBeat.o(151503);
                return rawQuery;
            }

            @Override // com.tencent.mm.plugin.r.a.a
            public final Cursor H(int[] iArr) {
                AppMethodBeat.i(151504);
                j eAS = a.eAS();
                String str = "select * from AppInfo where ";
                for (int i2 = 0; i2 <= 0; i2++) {
                    str = str + " status = " + iArr[0];
                }
                Cursor rawQuery = eAS.rawQuery(str + " order by status desc, modifyTime asc", new String[0]);
                if (rawQuery == null) {
                    Log.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
                    AppMethodBeat.o(151504);
                    return null;
                }
                AppMethodBeat.o(151504);
                return rawQuery;
            }

            @Override // com.tencent.mm.plugin.r.a.a
            public final Bitmap a(String str, int i2, float f2) {
                AppMethodBeat.i(151505);
                a.eAS();
                if (str == null || str.length() == 0) {
                    Log.e("MicroMsg.AppInfoStorage", "getIcon : invalid argument");
                    AppMethodBeat.o(151505);
                    return null;
                } else if (str.equals("wx7fa037cc7dfabad5")) {
                    Bitmap decodeResource = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), R.drawable.e8);
                    AppMethodBeat.o(151505);
                    return decodeResource;
                } else {
                    String gF = j.gF(str, i2);
                    if (!s.YS(gF)) {
                        Log.e("MicroMsg.AppInfoStorage", "icon does not exist, iconPath = " + gF + ", iconType = " + i2);
                        AppMethodBeat.o(151505);
                        return null;
                    }
                    Bitmap decodeFile = BackwardSupportUtil.BitmapFactory.decodeFile(gF, f2);
                    AppMethodBeat.o(151505);
                    return decodeFile;
                }
            }

            @Override // com.tencent.mm.plugin.r.a.a
            public final void eZ(String str, int i2) {
                AppMethodBeat.i(151506);
                a.eAQ().gD(str, i2);
                AppMethodBeat.o(151506);
            }

            @Override // com.tencent.mm.plugin.r.a.a
            public final void aJz(String str) {
                AppMethodBeat.i(151507);
                a.eAR().bdF(str);
                AppMethodBeat.o(151507);
            }

            @Override // com.tencent.mm.plugin.r.a.a
            public final void e(g gVar) {
                AppMethodBeat.i(151508);
                j eAS = a.eAS();
                if (!(gVar == null || gVar.field_status == 5)) {
                    gVar.field_status = 3;
                    Log.i("MicroMsg.AppInfoStorage", "setBlack package name = %s", gVar.field_packageName);
                    eAS.a(gVar, new String[0]);
                }
                AppMethodBeat.o(151508);
            }

            @Override // com.tencent.mm.plugin.r.a.a
            public final void f(g gVar) {
                AppMethodBeat.i(151509);
                j eAS = a.eAS();
                if (gVar == null || gVar.field_status != 3) {
                    AppMethodBeat.o(151509);
                    return;
                }
                gVar.field_status = 4;
                eAS.a(gVar, new String[0]);
                AppMethodBeat.o(151509);
            }

            @Override // com.tencent.mm.plugin.r.a.a
            public final void g(g gVar) {
                AppMethodBeat.i(151510);
                a.eAS().a(gVar, new String[0]);
                AppMethodBeat.o(151510);
            }

            @Override // com.tencent.mm.plugin.r.a.a
            public final j eAX() {
                AppMethodBeat.i(263521);
                j eAS = a.eAS();
                AppMethodBeat.o(263521);
                return eAS;
            }

            @Override // com.tencent.mm.plugin.r.a.a
            public final void bg(LinkedList<String> linkedList) {
                AppMethodBeat.i(151512);
                a.eAR().bF(linkedList);
                AppMethodBeat.o(151512);
            }

            @Override // com.tencent.mm.plugin.r.a.a
            public final Cursor hG(int i2, int i3) {
                AppMethodBeat.i(151513);
                Cursor hG = a.eAS().hG(i2, i3);
                AppMethodBeat.o(151513);
                return hG;
            }

            @Override // com.tencent.mm.plugin.r.a.a
            public final Cursor eAY() {
                AppMethodBeat.i(151514);
                j eAS = a.eAS();
                StringBuilder sb = new StringBuilder(256);
                sb.append("select * from AppInfo");
                sb.append(" where ");
                sb.append("serviceAppType > 0");
                Cursor rawQuery = eAS.rawQuery(sb.toString(), new String[0]);
                if (rawQuery == null) {
                    Log.e("MicroMsg.AppInfoStorage", "getAllServices : cursor is null");
                    AppMethodBeat.o(151514);
                    return null;
                }
                Log.d("MicroMsg.AppInfoStorage", "getAllServices count = %d", Integer.valueOf(rawQuery.getCount()));
                AppMethodBeat.o(151514);
                return rawQuery;
            }

            @Override // com.tencent.mm.plugin.r.a.a
            public final String aJy(String str) {
                AppMethodBeat.i(223698);
                a.eAS();
                String gF = j.gF(str, 1);
                AppMethodBeat.o(223698);
                return gF;
            }
        });
        AppMethodBeat.o(151516);
    }

    public static a eAN() {
        AppMethodBeat.i(151517);
        if (ANq == null) {
            synchronized (a.class) {
                try {
                    if (ANq == null) {
                        ANq = new a();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(151517);
                    throw th;
                }
            }
        }
        a aVar = ANq;
        AppMethodBeat.o(151517);
        return aVar;
    }

    @Override // com.tencent.mm.kernel.api.b
    public final List<String> aAo() {
        AppMethodBeat.i(151518);
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, "openapi/", "openapi_cache/");
        AppMethodBeat.o(151518);
        return linkedList;
    }

    public static String eAO() {
        AppMethodBeat.i(151519);
        String str = com.tencent.mm.kernel.g.aAh().hqG + "openapi/";
        AppMethodBeat.o(151519);
        return str;
    }

    public static String eAP() {
        AppMethodBeat.i(223700);
        String str = com.tencent.mm.kernel.g.aAh().hqG + "openapi_cache/";
        AppMethodBeat.o(223700);
        return str;
    }

    public static com.tencent.mm.pluginsdk.model.app.d cgO() {
        AppMethodBeat.i(151520);
        com.tencent.mm.kernel.g.aAf().azk();
        if (eAN().ANr == null) {
            eAN().ANr = new com.tencent.mm.pluginsdk.model.app.d(com.tencent.mm.kernel.g.aAh().hqK);
        }
        com.tencent.mm.pluginsdk.model.app.d dVar = eAN().ANr;
        AppMethodBeat.o(151520);
        return dVar;
    }

    public static f eAQ() {
        AppMethodBeat.i(151521);
        com.tencent.mm.kernel.g.aAf().azk();
        if (eAN().ANs == null) {
            eAN().ANs = new f();
        }
        f fVar = eAN().ANs;
        AppMethodBeat.o(151521);
        return fVar;
    }

    public static i eAR() {
        AppMethodBeat.i(151522);
        com.tencent.mm.kernel.g.aAf().azk();
        if (eAN().ANt == null) {
            eAN().ANt = new i();
        }
        i iVar = eAN().ANt;
        AppMethodBeat.o(151522);
        return iVar;
    }

    public static j eAS() {
        AppMethodBeat.i(151523);
        com.tencent.mm.kernel.g.aAf().azk();
        if (eAN().ANu == null) {
            eAN().ANu = new j(com.tencent.mm.kernel.g.aAh().hqK);
        }
        j jVar = eAN().ANu;
        AppMethodBeat.o(151523);
        return jVar;
    }

    public static l eAT() {
        AppMethodBeat.i(151524);
        com.tencent.mm.kernel.g.aAf().azk();
        if (eAN().ANv == null) {
            eAN().ANv = new l(com.tencent.mm.kernel.g.aAh().hqK);
        }
        l lVar = eAN().ANv;
        AppMethodBeat.o(151524);
        return lVar;
    }

    public static n eAU() {
        AppMethodBeat.i(151525);
        com.tencent.mm.kernel.g.aAf().azk();
        if (eAN().ANw == null) {
            eAN().ANw = new n();
        }
        n nVar = eAN().ANw;
        AppMethodBeat.o(151525);
        return nVar;
    }

    public static com.tencent.mm.pluginsdk.model.app.e eAV() {
        AppMethodBeat.i(151526);
        com.tencent.mm.kernel.g.aAf().azk();
        if (eAN().ANx == null) {
            eAN().ANx = new com.tencent.mm.pluginsdk.model.app.e();
        }
        com.tencent.mm.pluginsdk.model.app.e eVar = eAN().ANx;
        AppMethodBeat.o(151526);
        return eVar;
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(151527);
        am.a.iDo = eAR();
        EventCenter.instance.addListener(this.ANy);
        AppMethodBeat.o(151527);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(151528);
        i iVar = eAN().ANt;
        if (iVar != null) {
            eAV().b(7, iVar);
        }
        f fVar = eAN().ANs;
        if (fVar != null) {
            fVar.JVN.clear();
            fVar.hiK.clear();
            fVar.JVO.clear();
        }
        n nVar = eAN().ANw;
        if (nVar != null) {
            Log.d("MicroMsg.AppSettingService", "stop service");
            nVar.JWp.clear();
            eAV().b(1, nVar);
        }
        if (this.ANx != null) {
            com.tencent.mm.pluginsdk.model.app.e eVar = this.ANx;
            com.tencent.mm.kernel.g.aAg().hqi.b(452, eVar);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.pluginsdk.model.app.e.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(151660);
                    e.this.iMA.clear();
                    AppMethodBeat.o(151660);
                }
            });
        }
        if (eAN().ANu != null) {
            eAN().ANu.JWf.clear();
        }
        EventCenter.instance.removeListener(this.ANy);
        Log.i("XPinOpenApi", "onAccountRelease");
        AppMethodBeat.o(151528);
    }

    static {
        AppMethodBeat.i(151530);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("APPATTACHINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.r.a.AnonymousClass2 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.pluginsdk.model.app.d.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("APPINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.r.a.AnonymousClass3 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return j.SQL_CREATE;
            }
        });
        AppMethodBeat.o(151530);
    }

    @Override // com.tencent.mm.kernel.api.a
    public HashMap<Integer, h.b> collectDatabaseFactory() {
        return baseDBFactories;
    }

    @Override // com.tencent.mm.kernel.api.e
    public void onDataBaseOpened(h hVar, h hVar2) {
    }

    @Override // com.tencent.mm.kernel.api.e
    public void onDataBaseClosed(h hVar, h hVar2) {
        AppMethodBeat.i(151529);
        this.ANr = null;
        this.ANu = null;
        Log.i("XPinOpenApi", "onDataBaseClosed");
        AppMethodBeat.o(151529);
    }
}
