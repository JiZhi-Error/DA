package com.tencent.mm.plugin.sns.waid;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;
import java.util.Iterator;
import org.json.JSONObject;

public class WaidProvider extends ContentProvider {
    private static final String AUTHORITY = WeChatAuthorities.AUTHORITIES_WAIDPROVIDER();
    private static String[] FgM = {"pkg", "appWaid", "errCode"};
    private long FgN;
    private int FgO = 0;
    private a FgP;
    private volatile boolean FgQ = false;
    private final Object mLock = new Object();
    private UriMatcher mUriMatcher = new UriMatcher(-1);

    public WaidProvider() {
        AppMethodBeat.i(100598);
        AppMethodBeat.o(100598);
    }

    static {
        AppMethodBeat.i(100606);
        AppMethodBeat.o(100606);
    }

    public boolean onCreate() {
        AppMethodBeat.i(100599);
        this.mUriMatcher.addURI(AUTHORITY, "appWaid", 1);
        this.FgN = System.currentTimeMillis();
        this.FgP = new a();
        a aVar = this.FgP;
        try {
            Log.i("InitTaskMgr", "start");
            Iterator<Runnable> it = aVar.FgH.iterator();
            while (it.hasNext()) {
                aVar.FgJ.post(it.next());
            }
            aVar.FgH.clear();
            aVar.FgI.quitSafely();
        } catch (Exception e2) {
            Log.e("InitTaskMgr", "startInit exp=" + e2.toString());
        }
        Log.i("ad.waid.WaidProvider", "onCreate, this.hash=" + hashCode());
        AppMethodBeat.o(100599);
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.i(100602);
        Cursor b2 = b(uri, strArr2);
        AppMethodBeat.o(100602);
        return b2;
    }

    private Cursor b(Uri uri, String[] strArr) {
        String str;
        String str2;
        int i2 = 1;
        AppMethodBeat.i(204052);
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String str3 = "";
            String str4 = "";
            a flw = flw();
            if (strArr != null && strArr.length > 0) {
                str4 = Util.nullAsNil(strArr[0]).trim();
            }
            Log.i("ad.waid.WaidProvider", "handleQuery queryPkg=" + str4 + ", callingPkg=" + flw.FgU + ", thread.hash=" + Thread.currentThread().hashCode());
            PInt pInt = new PInt();
            if (!a(pInt)) {
                Log.e("ad.waid.WaidProvider", "checkWXEnv failed");
                MatrixCursor aj = aj("", "", -1);
                AppMethodBeat.o(204052);
                return aj;
            }
            if (TextUtils.isEmpty(flw.FgU)) {
                Log.e("ad.waid.WaidProvider", "handleQuery callingPkg empty");
                str2 = "";
            } else if (!b.fls()) {
                Log.e("ad.waid.WaidProvider", "handleQuery isExptWaidEnable==false");
                str2 = "";
                i2 = 2;
            } else if (this.mUriMatcher.match(uri) != 1) {
                Log.e("ad.waid.WaidProvider", "handleQuery uriMatch failed");
                i2 = 3;
                str2 = "";
            } else {
                if (TextUtils.isEmpty(str4)) {
                    str = flw.FgU;
                } else {
                    str = str4;
                }
                if (!flw.FgU.equals(str)) {
                    Log.e("ad.waid.WaidProvider", "handleQuery queryPkg!=callingPkg, queryPkg=" + str + ", callingPkg=" + flw.FgU);
                    i2 = 4;
                    str2 = str;
                } else {
                    str3 = b.aRz(str);
                    Log.i("ad.waid.WaidProvider", "handleQuery, appWaid=".concat(String.valueOf(str3)));
                    if (TextUtils.isEmpty(str3)) {
                        i2 = 5;
                        str2 = str;
                    } else {
                        str2 = str;
                        i2 = 0;
                    }
                }
            }
            int currentTimeMillis2 = (int) (System.currentTimeMillis() - currentTimeMillis);
            String str5 = flw.FgU;
            int i3 = flw.FgT;
            int i4 = pInt.value;
            if (!b.flv()) {
                Log.e("ad.waid.WaidReporter", "reportQuery isWxEnvInitDone==false");
            } else {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("callPkg", str5);
                    jSONObject.put("callPkgType", i3);
                    jSONObject.put("queryPkg", str4);
                    jSONObject.put("errCode", i2);
                    jSONObject.put("waitInit", i4);
                    jSONObject.put("timeCost", currentTimeMillis2);
                    String aRB = c.aRB(jSONObject.toString());
                    Log.i("ad.waid.WaidReporter", "reportQuery data=".concat(String.valueOf(aRB)));
                    h.INSTANCE.a(18666, 2000, aRB);
                } catch (Throwable th) {
                    Log.e("ad.waid.WaidReporter", "reportQuery exp=" + android.util.Log.getStackTraceString(th));
                }
            }
            c.a(flw, str4);
            MatrixCursor aj2 = aj(str2, Util.nullAsNil(str3), i2);
            AppMethodBeat.o(204052);
            return aj2;
        } catch (Throwable th2) {
            Log.e("ad.waid.WaidProvider", "handleQuery exp=" + th2.toString());
            AppMethodBeat.o(204052);
            return null;
        }
    }

    private static MatrixCursor aj(String str, String str2, int i2) {
        AppMethodBeat.i(204053);
        MatrixCursor matrixCursor = new MatrixCursor(FgM, 1);
        MatrixCursor.RowBuilder newRow = matrixCursor.newRow();
        newRow.add("pkg", str);
        newRow.add("appWaid", str2);
        newRow.add("errCode", Integer.valueOf(i2));
        AppMethodBeat.o(204053);
        return matrixCursor;
    }

    private a flw() {
        AppMethodBeat.i(204054);
        a aVar = new a();
        try {
            aVar.FgR = getCallingPackage();
        } catch (Throwable th) {
            Log.e("ad.waid.WaidProvider", "getCallingPkg exp=" + th.toString());
        }
        try {
            aVar.FgS = getContext().getPackageManager().getPackagesForUid(Binder.getCallingUid());
        } catch (Throwable th2) {
            Log.e("ad.waid.WaidProvider", "getCallingUid exp=" + th2.toString());
        }
        if (aVar.FgS != null && aVar.FgS.length > 0) {
            if (!TextUtils.isEmpty(aVar.FgR)) {
                String[] strArr = aVar.FgS;
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        aVar.FgT = 4;
                        aVar.FgU = aVar.FgS[0];
                        AppMethodBeat.o(204054);
                        break;
                    }
                    String str = strArr[i2];
                    if (aVar.FgR.equals(str)) {
                        if (aVar.FgS.length > 1) {
                            aVar.FgT = 2;
                        } else {
                            aVar.FgT = 3;
                        }
                        aVar.FgU = str;
                        AppMethodBeat.o(204054);
                    } else {
                        i2++;
                    }
                }
            } else {
                aVar.FgT = 1;
                aVar.FgU = aVar.FgS[0];
                AppMethodBeat.o(204054);
            }
        } else {
            aVar.FgT = 5;
            aVar.FgU = aVar.FgR;
            AppMethodBeat.o(204054);
        }
        return aVar;
    }

    /* access modifiers changed from: protected */
    public static class a {
        String FgR;
        String[] FgS;
        int FgT;
        String FgU;

        protected a() {
        }
    }

    private synchronized boolean a(PInt pInt) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(204055);
            Log.i("ad.waid.WaidProvider", "checkWXEnv start, isInitDone=" + b.flv() + ", mIsWxEnvCheckEnd=" + this.FgQ);
            if (b.flv()) {
                this.FgQ = true;
                AppMethodBeat.o(204055);
            } else {
                this.FgQ = false;
                pInt.value = 1;
                new b(this).start();
                Log.i("ad.waid.WaidProvider", "begin wait");
                long currentTimeMillis = System.currentTimeMillis();
                while (!this.FgQ) {
                    synchronized (this.mLock) {
                        try {
                            this.mLock.wait();
                        } catch (Exception e2) {
                            Log.e("ad.waid.WaidProvider", "wait exp=" + e2.toString());
                        }
                        try {
                        } catch (Throwable th) {
                            AppMethodBeat.o(204055);
                            throw th;
                        }
                    }
                }
                Log.i("ad.waid.WaidProvider", "after wait, timeCost=" + (System.currentTimeMillis() - currentTimeMillis) + ", fromOnCreate=" + (System.currentTimeMillis() - this.FgN) + ", waitIdx=" + this.FgO);
                this.FgO++;
                if (!b.flv()) {
                    this.FgQ = false;
                    Log.e("ad.waid.WaidProvider", "checkWXEnv expired");
                    AppMethodBeat.o(204055);
                    z = false;
                } else {
                    Log.i("ad.waid.WaidProvider", "checkWXEnv succ");
                    AppMethodBeat.o(204055);
                }
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public class b extends Thread {
        private int FgV = 12000;
        final /* synthetic */ WaidProvider FgW;
        private int dKi = 0;

        public b(WaidProvider waidProvider) {
            int i2 = 2000;
            this.FgW = waidProvider;
            AppMethodBeat.i(204049);
            int i3 = 12000 - (waidProvider.FgO * 4000);
            this.FgV = i3 >= 2000 ? i3 : i2;
            AppMethodBeat.o(204049);
        }

        public final void run() {
            AppMethodBeat.i(204050);
            Log.i("ad.waid.WaidProvider", "CheckThread run, thread.hash=" + hashCode());
            while (!b.flv()) {
                Log.d("ad.waid.WaidProvider", "wait, delay=200");
                try {
                    Thread.sleep(200);
                    this.dKi += 200;
                } catch (Exception e2) {
                }
                if (this.dKi >= this.FgV) {
                    Log.e("ad.waid.WaidProvider", "wait expired, expiredDuration=" + this.FgV);
                    flx();
                    AppMethodBeat.o(204050);
                    return;
                }
            }
            Log.i("ad.waid.WaidProvider", "init done");
            flx();
            AppMethodBeat.o(204050);
        }

        private void flx() {
            AppMethodBeat.i(204051);
            synchronized (this.FgW.mLock) {
                try {
                    Log.i("ad.waid.WaidProvider", "break Wait, waitTime=" + this.dKi);
                    this.FgW.FgQ = true;
                    this.FgW.mLock.notifyAll();
                } finally {
                    AppMethodBeat.o(204051);
                }
            }
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        AppMethodBeat.i(100600);
        AppMethodBeat.o(100600);
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        AppMethodBeat.i(100601);
        AppMethodBeat.o(100601);
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }
}
