package com.tencent.mm.kernel;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.ac;
import com.tencent.mm.b.g;
import com.tencent.mm.b.i;
import com.tencent.mm.b.p;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.co;
import com.tencent.mm.g.a.hc;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cp;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.j;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ck;
import com.tencent.mm.storage.cq;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.g;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.y;
import com.tencent.recovery.wx.util.WXUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import junit.framework.Assert;

public final class a {
    private static boolean hpG = true;
    private static boolean hpH = false;
    static b hpJ = new b();
    private static String hpK = "NoResetUinStack";
    private static String hpL = null;
    private static boolean hpM;
    private static int hpV = -1;
    private c hpE;
    private ac hpF;
    byte[] hpI = new byte[0];
    public com.tencent.mm.model.a hpN;
    public e.c hpO;
    public int hpP;
    public boolean hpQ = false;
    private boolean hpR = false;
    public int hpS = 0;
    public int hpT;
    private List<bc> hpU = new LinkedList();
    long hpW;
    private volatile EnumC0363a hpX = EnumC0363a.NotReady;
    public volatile boolean hpY = false;
    private String hpZ = "";
    private Map<String, Integer> hqa = new HashMap();

    static {
        AppMethodBeat.i(132045);
        AppMethodBeat.o(132045);
    }

    public a(c cVar) {
        int i2;
        AppMethodBeat.i(132014);
        Assert.assertNotNull(hpJ);
        g.aAi();
        hpG = Util.nullAsNil((Integer) g.aAh().hqB.get(17)) != 0;
        if (f.KyZ) {
            i2 = 763;
        } else {
            i2 = 702;
        }
        j.e.a.Kzx = new bh(i2);
        this.hpE = cVar;
        AppMethodBeat.o(132014);
    }

    public static int getUin() {
        AppMethodBeat.i(132015);
        int a2 = b.a(hpJ);
        AppMethodBeat.o(132015);
        return a2;
    }

    public static String getSalt() {
        AppMethodBeat.i(196987);
        g.aAi();
        String a2 = g.aAh().azQ().a(ar.a.USERINFO_ACCOUNT_SALT_STRING_SYNC, (String) null);
        AppMethodBeat.o(196987);
        return a2;
    }

    public static String ayV() {
        AppMethodBeat.i(132016);
        String pVar = new p(b.a(hpJ)).toString();
        AppMethodBeat.o(132016);
        return pVar;
    }

    public static final int ayW() {
        AppMethodBeat.i(196988);
        int access$100 = b.access$100();
        AppMethodBeat.o(196988);
        return access$100;
    }

    public static String ayX() {
        return hpL;
    }

    public static String FL(String str) {
        hpL = str;
        return str;
    }

    public static boolean ayY() {
        return hpM;
    }

    public static void ayZ() {
        hpM = true;
    }

    public static String aza() {
        return hpK;
    }

    public static void FM(String str) {
        hpK = str;
    }

    static boolean qb(int i2) {
        return i2 != 0;
    }

    protected static void azb() {
        AppMethodBeat.i(132017);
        b.a(hpJ, 0);
        AppMethodBeat.o(132017);
    }

    protected static void azc() {
        AppMethodBeat.i(132018);
        b.a(hpJ, 0);
        AppMethodBeat.o(132018);
    }

    public final void aze() {
        AppMethodBeat.i(132020);
        Log.w("MMKernel.CoreAccount", "account storage release  uin:%s thread:%s stack:%s", p.getString(b.a(hpJ)), Thread.currentThread().getName(), Util.getStack());
        if (!azp()) {
            Log.i("MMKernel.CoreAccount", "Fatal crash error!!! status is not initialized when release(), this callStack is:%s, last reset stack is:%s", Util.getStack().toString(), hpK);
            AppMethodBeat.o(132020);
            return;
        }
        this.hpE.onAccountRelease();
        g.aAi();
        g.aAh().CL(null);
        azd();
        g.aAi();
        g.aAh().hqS.clear();
        AppMethodBeat.o(132020);
    }

    public final void er(boolean z) {
        boolean z2;
        int i2;
        boolean z3;
        String str;
        String str2;
        boolean z4;
        boolean z5;
        String str3;
        boolean z6;
        boolean z7;
        int hashCode;
        int hashCode2;
        boolean z8;
        int i3;
        AppMethodBeat.i(132021);
        if (!z) {
            boolean z9 = WXHardCoderJNI.hcBootEnable;
            int i4 = WXHardCoderJNI.hcBootDelay;
            int i5 = WXHardCoderJNI.hcBootCPU;
            int i6 = WXHardCoderJNI.hcBootIO;
            if (WXHardCoderJNI.hcBootThr) {
                i3 = g.aAk().getProcessTid();
            } else {
                i3 = 0;
            }
            this.hpP = WXHardCoderJNI.startPerformance(z9, i4, i5, i6, i3, WXHardCoderJNI.hcBootTimeout, 101, WXHardCoderJNI.hcBootAction, "MMKernel.CoreAccount");
            Log.i("MMKernel.CoreAccount", "summerhardcoder startPerformance[%s] stack[%s]", Integer.valueOf(this.hpP), Util.getStack());
        }
        Log.i("MMKernel.CoreAccount", "UserStatusChange: clear");
        synchronized (this.hpU) {
            try {
                this.hpU.clear();
            } catch (Throwable th) {
                AppMethodBeat.o(132021);
                throw th;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        int a2 = b.a(hpJ);
        Log.i("MMKernel.CoreAccount", "dkacc setAccuin %s hash:%d thread:%d[%s] stack:%s", p.getString(a2), Integer.valueOf(i.ch(a2, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), Util.getStack());
        if (a2 != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            Log.w("MMKernel.CoreAccount", "setAccUin, Reset by MMCore.resetAccUin");
        } else {
            CrashReportFactory.setReportID(p.getString(a2));
            g.aAi();
            e aAh = g.aAh();
            AnonymousClass1 r18 = new Runnable() {
                /* class com.tencent.mm.kernel.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(132001);
                    a.a(a.this);
                    AppMethodBeat.o(132001);
                }
            };
            MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putBoolean("isLogin", true).apply();
            String messageDigest = g.getMessageDigest("mm".concat(String.valueOf(a2)).getBytes());
            String E = e.E(a2, messageDigest);
            Log.i("MMKernel.CoreStorage", "uinPath: %s, uinSaltPath: %s", messageDigest, E);
            boolean apn = com.tencent.mm.compatible.util.e.apn();
            if (E == null) {
                Log.w("MMKernel.CoreStorage", "Cannot generate account path, skip account renaming!");
                i2 = 6;
                z3 = false;
            } else if (!aAh.hqF.startsWith(com.tencent.mm.loader.j.b.aKD()) || !apn) {
                Log.w("MMKernel.CoreStorage", "SDCard not available, skip account renaming!");
                i2 = 1;
                z3 = false;
            } else {
                o oVar = new o(aAh.hqF + messageDigest);
                o oVar2 = new o(aAh.hqF + E);
                if (!oVar.isDirectory()) {
                    if (!oVar2.isDirectory()) {
                        oVar2.delete();
                    }
                    oVar2.mkdirs();
                    i2 = 5;
                    z3 = true;
                } else if (oVar2.isDirectory()) {
                    Log.i("MMKernel.CoreStorage", "Both uinPath exists, migration shall be taken.");
                    i2 = 2;
                    z3 = true;
                } else {
                    oVar2.delete();
                    Log.i("MMKernel.CoreStorage", "Move account directory: %s => %s", oVar, oVar2);
                    if (!oVar.am(oVar2)) {
                        Log.w("MMKernel.CoreStorage", "Failed to move uinPath, use old accPath");
                        i2 = 4;
                        z3 = false;
                    } else {
                        Log.i("MMKernel.CoreStorage", "Moved to new uinPath");
                        i2 = 3;
                        z3 = true;
                    }
                }
            }
            aAh.hqH = messageDigest;
            aAh.cachePath = ar.NSe + aAh.hqH + '/';
            if (z3) {
                str = E;
            } else {
                str = messageDigest;
            }
            aAh.hqJ = str;
            aAh.hqG = aAh.hqF + aAh.hqJ + '/';
            if (E == null) {
                str2 = messageDigest;
            } else {
                str2 = E;
            }
            aAh.hqI = str2;
            y.apG(i2);
            o oVar3 = new o(aAh.cachePath);
            Log.i("MMKernel.CoreStorage", "dkacc cachePath:" + aAh.cachePath + " accPath:" + aAh.hqG);
            if (!oVar3.exists()) {
                Log.w("MMKernel.CoreStorage", "setUin REBUILD data now ! DO NOT FUCKING TELL ME DB BROKEN !!! uin:%s data:%s sd:%s", p.getString(a2), aAh.cachePath, aAh.hqG);
                oVar3.mkdirs();
                if (!aAh.cachePath.equalsIgnoreCase(aAh.hqG)) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    String str4 = com.tencent.mm.loader.j.b.aKJ() + (messageDigest + "temp" + System.currentTimeMillis());
                    new o(aAh.hqG).am(new o(str4));
                    Log.i("MMKernel.CoreStorage", "find the old files and rename then %s" + (System.currentTimeMillis() - currentTimeMillis2), str4);
                }
                z4 = true;
            } else {
                z4 = false;
            }
            aAh.hqR = new cp(aAh.cachePath, z4);
            aAh.azJ();
            String str5 = aAh.cachePath + "MicroMsg.db";
            String str6 = aAh.cachePath + "EnMicroMsg.db";
            String str7 = aAh.cachePath + "EnMicroMsg2.db";
            aAh.CL(null);
            aAh.FP(str6);
            aAh.hqK = new h(new h.a() {
                /* class com.tencent.mm.kernel.e.AnonymousClass2 */

                @Override // com.tencent.mm.storagebase.h.a
                public final void azX() {
                    AppMethodBeat.i(132064);
                    if (e.this.hqM != null) {
                        Log.i("MMKernel.CoreStorage", "summer preCloseCallback userConfigStg: " + e.this.hqM);
                        e.this.hqM.gBI();
                        ao aoVar = e.this.hqM;
                        if (aoVar.mHandler != null) {
                            aoVar.mHandler.quit();
                        }
                    }
                    e.this.hqD.azX();
                    AppMethodBeat.o(132064);
                }

                @Override // com.tencent.mm.storagebase.h.a
                public final void azY() {
                    AppMethodBeat.i(132065);
                    e.this.hqD.azY();
                    AppMethodBeat.o(132065);
                }

                @Override // com.tencent.mm.storagebase.h.a
                public final void azZ() {
                    AppMethodBeat.i(132066);
                    e.this.hqD.azZ();
                    AppMethodBeat.o(132066);
                }
            });
            q.dr(true);
            if (!aAh.hqK.b(str5, str6, str7, (long) a2, e.getBaseDBFactories(), true)) {
                SQLiteException sQLiteException = new SQLiteException("main db init failed");
                AppMethodBeat.o(132021);
                throw sQLiteException;
            }
            String str8 = aAh.hqK.OtE;
            if (!Util.isNullOrNil(str8)) {
                Log.e("MMKernel.CoreStorage", "dbinit failed :".concat(String.valueOf(str8)));
                CrashReportFactory.reportRawMessage("init db Failed: [ " + str8 + "]", "DBinit");
            }
            h hVar = aAh.hqK;
            if (hVar.OtB != null) {
                z5 = hVar.OtB.OsV;
            } else {
                z5 = false;
            }
            if (z5) {
                aAh.hqQ = true;
            }
            aAh.hqM = new ao(aAh.hqK);
            aAh.hqO = new cq(aAh.hqK);
            aAh.hqK.OtD = new h.c() {
                /* class com.tencent.mm.kernel.e.AnonymousClass3 */

                @Override // com.tencent.mm.storagebase.h.c
                public final void aAa() {
                    AppMethodBeat.i(132067);
                    if (e.this.hqO != null) {
                        e.this.hqO.iFy.execSQL("TablesVersion", "delete from TablesVersion");
                        AppMethodBeat.o(132067);
                        return;
                    }
                    Log.e("MMKernel.CoreStorage", "tablesVersionStorage is null");
                    AppMethodBeat.o(132067);
                }
            };
            aAh.hqP = aAh.hqO.gEy();
            aAh.hqL = new h(aAh.hqE);
            q.dr(true);
            if (!aAh.hqL.b(str5, str6, str7, (long) a2, new HashMap<>(), true)) {
                com.tencent.mm.model.b bVar = new com.tencent.mm.model.b((byte) 0);
                AppMethodBeat.o(132021);
                throw bVar;
            }
            aAh.hqN = new ck(aAh.hqM);
            aAh.hqN.add(new MStorage.IOnStorageChange() {
                /* class com.tencent.mm.kernel.e.AnonymousClass4 */

                @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
                public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
                    AppMethodBeat.i(132068);
                    ae.DV(str);
                    AppMethodBeat.o(132068);
                }
            });
            aAh.hqN.gEr();
            r18.run();
            boolean z10 = apn && aAh.hqF.startsWith(com.tencent.mm.loader.j.b.aKD());
            g.a hYS = com.tencent.mm.vfs.g.hYQ().hYS();
            g.a nt = hYS.nt("account", messageDigest).nt("accountSalt", aAh.hqI);
            if (z10) {
                str3 = aAh.hqI;
            } else {
                str3 = messageDigest;
            }
            nt.nt("accountSd", str3);
            y.a(hYS, z10, E != null);
            y.a(hYS, aAh.hqF, z3);
            hYS.Dx(false);
            Log.i("VFS.Debug", "SetEnv ${account} = ".concat(String.valueOf(messageDigest)));
            y.Dz(z3);
            if (z4) {
                long longValue = ((Long) aAh.hqM.get(ar.a.USERINFO_INSTALL_FIRST_TIME_LONG, (Object) 0L)).longValue();
                int intValue = ((Integer) aAh.hqM.get(ar.a.USERINFO_INSTALL_FIRST_CLIENT_VERSION_INT, (Object) 0)).intValue();
                if (longValue > 0) {
                    Log.w("MMKernel.CoreStorage", "summerinstall new install but firsttime[%d] > 0", Long.valueOf(longValue));
                } else {
                    aAh.hqM.set(ar.a.USERINFO_INSTALL_FIRST_TIME_LONG, Long.valueOf(System.currentTimeMillis()));
                }
                if (intValue > 0) {
                    Log.w("MMKernel.CoreStorage", "summerinstall new install but version[%d] > 0", Integer.valueOf(intValue));
                } else {
                    aAh.hqM.set(ar.a.USERINFO_INSTALL_FIRST_CLIENT_VERSION_INT, Integer.valueOf(d.KyO));
                }
                Log.i("MMKernel.CoreStorage", "edw setAccUin, summerinstall time[%d]，version[%d], clientversion[%d]", (Long) aAh.hqM.get(ar.a.USERINFO_INSTALL_FIRST_TIME_LONG, (Object) 0L), (Integer) aAh.hqM.get(ar.a.USERINFO_INSTALL_FIRST_CLIENT_VERSION_INT, (Object) 0), Integer.valueOf(d.KyO));
            }
            if (!z) {
                g.aAi();
                String nullAsNil = Util.nullAsNil((String) g.aAh().azQ().get(2, (Object) null));
                Log.i("MMKernel.CoreAccount", "summerinit validateUsername username[%s]", nullAsNil);
                if (nullAsNil.length() <= 0) {
                    Log.e("MMKernel.CoreAccount", "username of acc stg not set: uin=" + b.a(hpJ));
                    azd();
                    b.a(hpJ, 0);
                    hpK = Util.getStack().toString();
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.kernel.a.AnonymousClass4 */

                        public final void run() {
                            AppMethodBeat.i(132004);
                            g.aAi().releaseAll();
                            AppMethodBeat.o(132004);
                        }
                    });
                    z8 = false;
                } else {
                    z8 = true;
                }
                if (!z8) {
                    com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(598, 21, 1, true);
                    Log.w("MMKernel.CoreAccount", "setAccUin, validateUsername false no need initialize!");
                }
            }
            EventCenter.instance.publish(new com.tencent.mm.g.a.cp());
            g.aAi();
            e aAh2 = g.aAh();
            e.c cVar = new e.c();
            int nullAsNil2 = Util.nullAsNil((Integer) aAh2.hqM.get(14, (Object) null));
            int i7 = d.KyO;
            Log.d("MMKernel.CoreStorage", "sVer: %s, cVer: %s.", Integer.toHexString(nullAsNil2), Integer.toHexString(i7));
            if (i7 == nullAsNil2) {
                z6 = false;
            } else if (i7 > 570425344 && nullAsNil2 <= 570425344) {
                z6 = true;
            } else if (i7 <= 570556456 || nullAsNil2 > 570556456) {
                z6 = false;
            } else {
                z6 = true;
            }
            if (z6) {
                aAh2.hqM.set(8197, "");
                aAh2.hqM.set(15, (Object) 0);
            }
            if (nullAsNil2 != i7) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (nullAsNil2 > 620822536 || nullAsNil2 == i7) {
                aAh2.hqM.set(274480, Boolean.FALSE);
                Log.i("MMKernel.CoreStorage", "[initialize] need not init emoji");
            } else {
                aAh2.hqM.set(274480, Boolean.TRUE);
                Log.i("MMKernel.CoreStorage", "[initialize] need init emoji");
            }
            if (nullAsNil2 != 0 && nullAsNil2 < 637599744) {
                aAh2.hqM.set(348162, Boolean.TRUE);
            }
            if (nullAsNil2 != i7) {
                Log.w("MMKernel.CoreStorage", "account storage version changed from " + Integer.toHexString(nullAsNil2) + " to " + Integer.toHexString(i7) + ", init=" + z6);
                if (((Integer) aAh2.hqB.get(37, 0)).intValue() == 0) {
                    aAh2.hqB.set(37, Integer.valueOf(nullAsNil2));
                }
                aAh2.hqM.set(30, Boolean.FALSE);
                aAh2.hqM.set(-2046825377, Boolean.FALSE);
                aAh2.hqM.set(-2046825369, Boolean.FALSE);
                aAh2.hqM.set(54, Boolean.FALSE);
                aAh2.hqM.set(-2046825368, Boolean.FALSE);
                aAh2.hqM.set(-2046825366, Boolean.TRUE);
                aAh2.hqM.set(62, Boolean.TRUE);
                MMApplicationContext.getContext().getSharedPreferences("update_config_prefs", com.tencent.mm.compatible.util.g.aps()).edit().clear().commit();
                if (nullAsNil2 == 0) {
                    aAh2.hqT = true;
                } else if ((-16777216 & nullAsNil2) == (-16777216 & i7)) {
                    Log.d("MMKernel.CoreStorage", "lock show_whatsnew by same major version");
                    MMEntryLock.lock("show_whatsnew");
                }
            } else {
                Log.d("MMKernel.CoreStorage", "lock show_whatsnew from else.");
                MMEntryLock.lock("show_whatsnew");
            }
            Log.i("MMKernel.CoreStorage", "unlock show_whatsnew from testWhatsNew, %s.", Boolean.valueOf(aAh2.hqM.getInt(ar.a.USERINFO_FINDER_WHATS_NEW_LOCAL_STYLE_INT_SYNC, -1) > 0));
            cVar.hrc = z7;
            cVar.hrd = nullAsNil2;
            this.hpO = cVar;
            Log.i("MMKernel.CoreAccount", "check is update :%b ", Boolean.valueOf(cVar.hrc));
            this.hpR = true;
            if (!this.hpQ) {
                azf();
                g.aAf().azr();
            }
            bf.iDu.aO(WXUtil.LAST_LOGIN_UIN, p.getString(a2));
            com.tencent.mm.plugin.report.e.INSTANCE.setUin(a2);
            Object[] objArr = new Object[2];
            if (getClass().getClassLoader() == null) {
                hashCode = -1;
            } else {
                hashCode = getClass().getClassLoader().hashCode();
            }
            objArr[0] = Integer.valueOf(hashCode);
            if (Thread.currentThread().getContextClassLoader() == null) {
                hashCode2 = -1;
            } else {
                hashCode2 = Thread.currentThread().getContextClassLoader().hashCode();
            }
            objArr[1] = Integer.valueOf(hashCode2);
            Log.i("MMKernel.CoreAccount", "SmcLogic.setUin, class loader %s, %s", objArr);
            this.hpN = new com.tencent.mm.model.a();
            Log.i("MMKernel.CoreAccount", "setAccUin done :%s", p.getString(a2));
            EventCenter.instance.publish(new hc());
            g.aAi();
            if (g.aAg().hqi != null) {
                g.aAi();
                if (g.aAg().hqi.iMw != null) {
                    g.aAi();
                    g.aAg().hqi.iMw.fz(true);
                    g.aAi();
                    com.tencent.mm.network.e aZh = g.aAg().hqi.iMw.aZh();
                    if (!(a2 == 0 || aZh == null || a2 == aZh.getUin())) {
                        Log.w("MMKernel.CoreAccount", "summerauth update acc info with acc stg: old acc uin=%d, this uin=%d", Integer.valueOf(aZh.getUin()), Integer.valueOf(a2));
                        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(148, 46, 1, false);
                        aZh.setUin(a2);
                    }
                }
            }
        }
        Log.i("MMKernel.CoreAccount", "start time check setUinImpl end total time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        Log.i("MMKernel.CoreAccount", "mAccountStatus to AccountHasReady");
        AppMethodBeat.o(132021);
    }

    public final void azf() {
        AppMethodBeat.i(132022);
        if (!this.hpR) {
            Log.i("MMKernel.CoreAccount", "no need do account initialized notify.");
            AppMethodBeat.o(132022);
            return;
        }
        this.hpR = false;
        Log.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized tid:%d, stack[%s]", Long.valueOf(Thread.currentThread().getId()), Util.getStack());
        long currentTimeMillis = System.currentTimeMillis();
        this.hpE.onAccountInitialized(this.hpO);
        Log.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized run tid[%d] take[%d]ms", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        azg();
        AppMethodBeat.o(132022);
    }

    public final void azg() {
        AppMethodBeat.i(132023);
        if (azp() && com.tencent.mm.kernel.a.c.aAu().hsa) {
            Log.i("MMKernel.CoreAccount", "Flush client version.");
            g.aAh().azI();
        }
        AppMethodBeat.o(132023);
    }

    public final synchronized ac azh() {
        ac acVar;
        AppMethodBeat.i(132024);
        if (this.hpF == null) {
            this.hpF = new ac();
        }
        acVar = this.hpF;
        AppMethodBeat.o(132024);
        return acVar;
    }

    public static boolean azi() {
        return hpH;
    }

    public static void es(boolean z) {
        hpH = z;
    }

    public static boolean azj() {
        String str;
        AppMethodBeat.i(132025);
        if (hpG) {
            Object[] objArr = new Object[2];
            g.aAi();
            if (g.aAf() != null) {
                g.aAi();
                g.aAf();
                str = p.getString(b.a(hpJ));
            } else {
                str = "-1";
            }
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(g.aAf().azp());
            Log.w("MMKernel.CoreAccount", "account holded :%s init:%b", objArr);
        }
        boolean z = hpG;
        AppMethodBeat.o(132025);
        return z;
    }

    public static void hold() {
        String str;
        AppMethodBeat.i(132026);
        Object[] objArr = new Object[3];
        g.aAi();
        if (g.aAf() != null) {
            g.aAi();
            g.aAf();
            str = p.getString(b.a(hpJ));
        } else {
            str = "-1";
        }
        objArr[0] = str;
        objArr[1] = Util.getStack();
        objArr[2] = Boolean.valueOf(g.aAf().azp());
        Log.w("MMKernel.CoreAccount", " HOLD ACCOUNT! uin:%s stack:%s init:%b", objArr);
        hpG = true;
        g.aAi();
        g.aAh().hqB.set(17, 1);
        AppMethodBeat.o(132026);
    }

    public static void unhold() {
        String str;
        AppMethodBeat.i(132027);
        Object[] objArr = new Object[2];
        g.aAi();
        if (g.aAf() != null) {
            g.aAi();
            g.aAf();
            str = p.getString(b.a(hpJ));
        } else {
            str = "-1";
        }
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(g.aAf().azp());
        Log.w("MMKernel.CoreAccount", " UN HOLD ACCOUNT! uin:%s init:%b", objArr);
        hpG = false;
        g.aAi();
        g.aAh().hqB.set(17, 0);
        AppMethodBeat.o(132027);
    }

    public final void azk() {
        AppMethodBeat.i(132028);
        if (!azp()) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(132028);
            throw bVar;
        }
        AppMethodBeat.o(132028);
    }

    public final void a(bc bcVar) {
        AppMethodBeat.i(132029);
        Log.i("MMKernel.CoreAccount", "UserStatusChange: add %s", bcVar);
        synchronized (this.hpU) {
            try {
                if (!this.hpU.contains(bcVar)) {
                    this.hpU.add(bcVar);
                }
            } finally {
                AppMethodBeat.o(132029);
            }
        }
    }

    public final void b(bc bcVar) {
        AppMethodBeat.i(132030);
        Log.i("MMKernel.CoreAccount", "UserStatusChange: remove %s", bcVar);
        synchronized (this.hpU) {
            try {
                this.hpU.remove(bcVar);
            } finally {
                AppMethodBeat.o(132030);
            }
        }
    }

    public final void azl() {
        AppMethodBeat.i(132031);
        new MMHandler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.tencent.mm.kernel.a.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(132002);
                bc[] bcVarArr = new bc[a.this.hpU.size()];
                a.this.hpU.toArray(bcVarArr);
                for (bc bcVar : bcVarArr) {
                    bcVar.aVw();
                }
                AppMethodBeat.o(132002);
            }
        });
        AppMethodBeat.o(132031);
    }

    public final void cU(int i2, int i3) {
        AppMethodBeat.i(132032);
        boolean z = (this.hpS == i2 && this.hpT == i3) ? false : true;
        Log.d("MMKernel.CoreAccount", "online status, %d, %d, %d ,%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.hpT), Integer.valueOf(this.hpS));
        if (!z) {
            AppMethodBeat.o(132032);
            return;
        }
        this.hpS = i2;
        this.hpT = i3;
        new MMHandler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.tencent.mm.kernel.a.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(132003);
                a.this.azl();
                AppMethodBeat.o(132003);
            }
        });
        AppMethodBeat.o(132032);
    }

    public static void qc(int i2) {
        AppMethodBeat.i(132033);
        if (hpV == -1 || hpV != i2) {
            hpV = i2;
            apK().edit().putInt("notification.user.state", i2).commit();
            Log.i("MMKernel.CoreAccount", "[NOTIFICATION SETTINGS]save UserStatus: %d", Integer.valueOf(i2));
            AppMethodBeat.o(132033);
            return;
        }
        AppMethodBeat.o(132033);
    }

    public static int azm() {
        AppMethodBeat.i(132034);
        int i2 = apK().getInt("notification.user.state", 0);
        AppMethodBeat.o(132034);
        return i2;
    }

    public static SharedPreferences apK() {
        AppMethodBeat.i(132035);
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("notify_key_pref_settings", com.tencent.mm.compatible.util.g.aps());
        AppMethodBeat.o(132035);
        return sharedPreferences;
    }

    public final boolean azn() {
        AppMethodBeat.i(132036);
        boolean qd = qd(this.hpS);
        AppMethodBeat.o(132036);
        return qd;
    }

    public static boolean qd(int i2) {
        return (i2 & 1) != 0;
    }

    public final void initialize() {
        AppMethodBeat.i(132038);
        if (azp()) {
            AppMethodBeat.o(132038);
            return;
        }
        synchronized (this.hpI) {
            try {
                if (!azp()) {
                    int a2 = b.a(hpJ);
                    if (a2 != 0) {
                        this.hpW = SystemClock.elapsedRealtime();
                        Log.w("MMKernel.CoreAccount", "auto set up account storage uin: %d, stack: %s", Integer.valueOf(a2), Util.getStack());
                        er(false);
                    }
                    AppMethodBeat.o(132038);
                }
            } finally {
                AppMethodBeat.o(132038);
            }
        }
    }

    /* renamed from: com.tencent.mm.kernel.a$a */
    public enum EnumC0363a {
        NotReady,
        AccountHasReady;

        public static EnumC0363a valueOf(String str) {
            AppMethodBeat.i(132006);
            EnumC0363a aVar = (EnumC0363a) Enum.valueOf(EnumC0363a.class, str);
            AppMethodBeat.o(132006);
            return aVar;
        }

        static {
            AppMethodBeat.i(132007);
            AppMethodBeat.o(132007);
        }
    }

    public static boolean azo() {
        AppMethodBeat.i(132039);
        if (b.a(hpJ) != 0) {
            AppMethodBeat.o(132039);
            return true;
        }
        AppMethodBeat.o(132039);
        return false;
    }

    public final boolean azp() {
        return this.hpX == EnumC0363a.AccountHasReady;
    }

    public final boolean azq() {
        return this.hpY;
    }

    public final void azr() {
        AppMethodBeat.i(132040);
        Log.i("MMKernel.CoreAccount", "summerasyncinit setInitializedNotifyAllDone[%b] to true stack[%s]", Boolean.valueOf(this.hpY), Util.getStack());
        this.hpY = true;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Log.i("MMKernel.CoreAccount", "summerhardcoder setInitializedNotifyAllDone [%d %d] take[%d]ms, stack[%s]", Long.valueOf(this.hpW), Long.valueOf(elapsedRealtime), Long.valueOf(elapsedRealtime - this.hpW), Util.getStack());
        EventCenter.instance.publish(new co());
        AppMethodBeat.o(132040);
    }

    public static final class b {
        private static boolean hqg = true;
        private an hqf;
        private boolean mLoaded = false;
        private int uin = 0;

        b() {
        }

        static /* synthetic */ int a(b bVar) {
            AppMethodBeat.i(132012);
            int uin2 = bVar.getUin();
            AppMethodBeat.o(132012);
            return uin2;
        }

        static /* synthetic */ void a(b bVar, int i2) {
            AppMethodBeat.i(132013);
            bVar.setUin(i2);
            AppMethodBeat.o(132013);
        }

        static /* synthetic */ int access$100() {
            AppMethodBeat.i(196986);
            int azw = azw();
            AppMethodBeat.o(196986);
            return azw;
        }

        private synchronized int getUin() {
            int i2;
            AppMethodBeat.i(132008);
            if (!this.mLoaded) {
                azv();
                this.mLoaded = true;
            }
            i2 = this.uin;
            AppMethodBeat.o(132008);
            return i2;
        }

        public final synchronized void a(an anVar) {
            this.hqf = anVar;
        }

        private synchronized void setUin(int i2) {
            AppMethodBeat.i(132009);
            Log.i("MMKernel.CoreAccount", "Uin From %s To %s hash:%d thread:%d[%s] stack:%s", p.getString(this.uin), p.getString(i2), Integer.valueOf(i.ch(i2, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), Util.getStack());
            Assert.assertNotNull(this.hqf);
            a(this.hqf, i2);
            this.uin = i2;
            AppMethodBeat.o(132009);
        }

        private synchronized void azv() {
            int i2 = 0;
            synchronized (this) {
                AppMethodBeat.i(132010);
                Assert.assertNotNull(this.hqf);
                an anVar = this.hqf;
                if (anVar == null) {
                    Log.w("MMKernel.CoreAccount", "summer read detault uin exception sysCfg is null!");
                } else {
                    Integer num = (Integer) anVar.get(1);
                    if (num == null) {
                        if (anVar.NRI) {
                            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(148, 40, 1, false);
                        }
                        Integer valueOf = Integer.valueOf(azw());
                        if (valueOf != null) {
                            Log.i("MMKernel.CoreAccount", "summer read detault uin[%d], bakUin[%d] sysCfg.isOpenException[%b]", num, valueOf, Boolean.valueOf(anVar.NRI));
                            if (hqg) {
                                Log.w("MMKernel.CoreAccount", "summer read detault uin exception backup uin[%d], stack[%s]", valueOf, Util.getStack());
                                com.tencent.mm.plugin.report.e.INSTANCE.a(11911, Integer.valueOf(Util.nullAsNil(valueOf)));
                                hqg = false;
                            }
                            a(anVar, valueOf.intValue());
                            num = valueOf;
                        }
                    }
                    Log.i("MMKernel.CoreAccount", "summer getDefaultUin uin[%d]", Integer.valueOf(Util.nullAsNil(num)));
                    i2 = Util.nullAsNil(num);
                }
                this.uin = i2;
                AppMethodBeat.o(132010);
            }
        }

        private static int azw() {
            AppMethodBeat.i(196985);
            int i2 = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.aps()).getInt("default_uin", 0);
            AppMethodBeat.o(196985);
            return i2;
        }

        private static void a(an anVar, int i2) {
            AppMethodBeat.i(132011);
            Log.i("MMKernel.CoreAccount", "setSysUin uin: %d, stack: %s", Integer.valueOf(i2), Util.getStack());
            if (!MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.aps()).edit().putInt("default_uin", i2).commit()) {
                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(148, 150, 1, false);
                Log.e("MMKernel.CoreAccount", "uin_sp save fail");
            }
            MultiProcessMMKV.getMMKV("system_config_prefs").encode("default_uin", i2);
            anVar.set(1, Integer.valueOf(i2));
            anVar.gBH();
            AppMethodBeat.o(132011);
        }
    }

    public static int azs() {
        AppMethodBeat.i(132041);
        Integer valueOf = Integer.valueOf(MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.aps()).getInt("default_uin", 0));
        if (valueOf.intValue() == 0) {
            valueOf = Integer.valueOf(MultiProcessMMKV.getMMKV("system_config_prefs").decodeInt("default_uin", 0));
            if (valueOf.intValue() != 0) {
                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(148, 151, 1, false);
                Log.e("MMKernel.CoreAccount", "getUinFromSharedPreferences get from sp fail");
            }
        }
        int intValue = valueOf.intValue();
        AppMethodBeat.o(132041);
        return intValue;
    }

    public static String azt() {
        AppMethodBeat.i(132042);
        g.aAi();
        if (Util.isNullOrNil(g.aAf().hpZ)) {
            g.aAi();
            g.aAf().hpZ = q.aoG() + "_" + System.currentTimeMillis();
        }
        g.aAi();
        String str = g.aAf().hpZ;
        AppMethodBeat.o(132042);
        return str;
    }

    public static void azu() {
        AppMethodBeat.i(132043);
        g.aAi();
        g.aAf().hpZ = "";
        g.aAi();
        g.aAf().hqa.clear();
        AppMethodBeat.o(132043);
    }

    public static int FN(String str) {
        int intValue;
        AppMethodBeat.i(132044);
        g.aAi();
        if (g.aAf().hqa.get(str) == null) {
            intValue = 0;
        } else {
            g.aAi();
            intValue = g.aAf().hqa.get(str).intValue();
        }
        int nowSecond = (int) Util.nowSecond();
        if (intValue == 0) {
            g.aAi();
            g.aAf().hqa.put(str, Integer.valueOf(nowSecond));
            AppMethodBeat.o(132044);
            return intValue;
        }
        int i2 = nowSecond - intValue;
        g.aAi();
        g.aAf().hqa.put(str, Integer.valueOf(nowSecond));
        if (i2 >= 0) {
            AppMethodBeat.o(132044);
            return i2;
        }
        AppMethodBeat.o(132044);
        return 0;
    }

    private void azd() {
        AppMethodBeat.i(132019);
        this.hpX = EnumC0363a.NotReady;
        this.hpY = false;
        Log.i("MMKernel.CoreAccount", "mAccountStatus to NotReady");
        MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putBoolean("isLogin", false).commit();
        Log.w("MMKernel.CoreAccount", "[arthurdan.AccountNR] account storage reset! uin:%d, resetStack is:%s, resetTime:%s", Integer.valueOf(b.a(hpJ)), hpK, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(new Date()));
        AppMethodBeat.o(132019);
    }

    public final void release() {
        AppMethodBeat.i(132037);
        synchronized (this.hpI) {
            try {
                aze();
            } finally {
                AppMethodBeat.o(132037);
            }
        }
    }

    static /* synthetic */ void a(a aVar) {
        aVar.hpX = EnumC0363a.AccountHasReady;
    }
}
