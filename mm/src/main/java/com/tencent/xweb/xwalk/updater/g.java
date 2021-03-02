package com.tencent.xweb.xwalk.updater;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.AsyncTask;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.xweb.XWebCoreContentProvider;
import com.tencent.xweb.ah;
import com.tencent.xweb.util.h;
import com.tencent.xweb.xwalk.c;
import com.tencent.xweb.xwalk.p;
import com.tencent.xweb.xwalk.updater.a;
import com.tencent.xweb.xwalk.updater.j;
import java.util.HashMap;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater;

public final class g extends AsyncTask<String, Integer, Integer> {
    static XWalkUpdater SHJ;
    private static String SJr = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private HashMap<String, String> SJq;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(Integer num) {
        AppMethodBeat.i(154581);
        Integer num2 = num;
        if (num2.intValue() == 2) {
            if (!NetworkUtil.isNetworkAvailable()) {
                c hte = ah.hte();
                if (hte != null) {
                    hte.bXL();
                }
                XWalkEnvironment.addXWalkInitializeLog("network not available!!");
            } else {
                XWalkEnvironment.addXWalkInitializeLog("doFetchUpdateConfigNew begin!!");
                j.a aVar = new j.a();
                aVar.mUrl = XWalkEnvironment.getXWalkUpdateConfigUrl();
                aVar.mFilePath = XWalkEnvironment.getUpdateConfigFullPath();
                aVar.SJE = true;
                j.a(aVar, new b() {
                    /* class com.tencent.xweb.xwalk.updater.g.AnonymousClass1 */

                    @Override // com.tencent.xweb.xwalk.updater.b
                    public final void hvu() {
                        AppMethodBeat.i(207363);
                        XWebCoreScheduler.hvW().hvG();
                        h.hup();
                        AppMethodBeat.o(207363);
                    }

                    @Override // com.tencent.xweb.xwalk.updater.b
                    public final void a(final j.c cVar) {
                        AppMethodBeat.i(154571);
                        final a.b bsS = a.bsS(cVar.mFilePath);
                        if (bsS == null) {
                            h.OQ(35);
                            h.huq();
                            h.dz(15123, "0,201201," + cVar.SJG + "," + cVar.mNetWorkType + "," + cVar.mRetryTimes + "," + cVar.baN + "," + cVar.mTotalSize);
                            XWalkEnvironment.addXWalkInitializeLog("ConfigParser failed ");
                            c hte = ah.hte();
                            if (hte != null) {
                                hte.bXL();
                            }
                            AppMethodBeat.o(154571);
                            return;
                        }
                        new AsyncTask<Void, Void, Integer>() {
                            /* class com.tencent.xweb.xwalk.updater.g.AnonymousClass1.AnonymousClass1 */

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
                            /* access modifiers changed from: protected */
                            @Override // android.os.AsyncTask
                            public final /* synthetic */ Integer doInBackground(Void[] voidArr) {
                                AppMethodBeat.i(207362);
                                Integer rI = rI();
                                AppMethodBeat.o(207362);
                                return rI;
                            }

                            private Integer rI() {
                                AppMethodBeat.i(207361);
                                try {
                                    com.tencent.xweb.a.a(bsS.SIL, bsS.SIJ);
                                    p.hQ("cfg_update", 0);
                                } catch (Exception e2) {
                                    XWalkEnvironment.addXWalkInitializeLog("apply cmds failed , " + e2.getMessage());
                                }
                                XWalkEnvironment.addXWalkInitializeLog("doFetchUpdateConfigNew onTaskSucceed!!");
                                h.OV(cVar.baN);
                                h.dz(15123, bsS.SIJ + ",201201," + cVar.SJG + "," + cVar.mNetWorkType + "," + cVar.mRetryTimes + "," + cVar.baN + "," + cVar.mTotalSize + "," + g.SJr);
                                XWebCoreScheduler.hvW().a(bsS);
                                i.hvV().a(bsS);
                                g.hvU();
                                AppMethodBeat.o(207361);
                                return null;
                            }
                        }.execute(new Void[0]);
                        AppMethodBeat.o(154571);
                    }

                    @Override // com.tencent.xweb.xwalk.updater.b
                    public final void b(j.c cVar) {
                        AppMethodBeat.i(154572);
                        c hte = ah.hte();
                        if (hte != null) {
                            hte.bXL();
                        }
                        h.OQ(35);
                        h.huq();
                        h.dz(15123, "0,201201," + cVar.SJG + "," + cVar.mNetWorkType + "," + cVar.mRetryTimes + "," + cVar.baN + "," + cVar.mTotalSize + "," + g.SJr);
                        XWalkEnvironment.addXWalkInitializeLog("get config onTaskFailed ");
                        AppMethodBeat.o(154572);
                    }
                });
            }
        }
        super.onPostExecute(num2);
        AppMethodBeat.o(154581);
    }

    public g(XWalkUpdater xWalkUpdater, HashMap<String, String> hashMap) {
        AppMethodBeat.i(154573);
        SHJ = xWalkUpdater;
        this.SJq = hashMap;
        if (hashMap != null) {
            String str = hashMap.get("UpdaterCheckType");
            SJr = str;
            if (str != null && SJr.equals("1")) {
                Scheduler.hvE();
            } else if (SJr != null && SJr.equals("2")) {
                Scheduler.hvE();
                h.OQ(93);
            } else if (SJr == null || !SJr.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                SJr = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            } else {
                XWebCoreScheduler.hvW().hvJ().SIE = true;
                h.OQ(94);
            }
        }
        XWalkInitializer.addXWalkInitializeLog("XWalkUpdateChecker notify received !! mNotifyType = " + SJr);
        AppMethodBeat.o(154573);
    }

    private static boolean a(XWebCoreScheduler xWebCoreScheduler) {
        AppMethodBeat.i(207364);
        c hvJ = xWebCoreScheduler.hvJ();
        if (hvR()) {
            AppMethodBeat.o(207364);
            return false;
        }
        if (!XWalkEnvironment.isSelfProvider()) {
            hvS();
            XWalkUpdater.ErrorInfo updateRuntimeFromProvider = SHJ.updateRuntimeFromProvider(xWebCoreScheduler);
            try {
                String packageName = XWalkEnvironment.getPackageName();
                String str = updateRuntimeFromProvider.errorCode + "," + packageName + "," + updateRuntimeFromProvider.targetVer + "," + updateRuntimeFromProvider.readFileListFailedCount + "," + updateRuntimeFromProvider.noMatchedVersionCount + "," + updateRuntimeFromProvider.copyFailedCount + "," + updateRuntimeFromProvider.md5FailedCount + "," + updateRuntimeFromProvider.extractFailedCount + "," + updateRuntimeFromProvider.setVersionFailedCount + "," + updateRuntimeFromProvider.extractRetryFailedCount;
                ContentResolver contentResolver = XWalkEnvironment.getContentResolver();
                if (contentResolver != null) {
                    Uri d2 = XWebCoreContentProvider.d("com.tencent.mm", packageName, 3, 0, "");
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("15626", str);
                    contentResolver.insert(d2, contentValues);
                }
            } catch (Exception e2) {
                XWalkInitializer.addXWalkInitializeLog("_doStartUpdate report error");
            }
            if (updateRuntimeFromProvider.errorCode == 0) {
                p.hQ("finished", 0);
                a((Scheduler) xWebCoreScheduler);
                AppMethodBeat.o(207364);
                return true;
            } else if (updateRuntimeFromProvider.errorCode == -10) {
                a(updateRuntimeFromProvider.errorCode, xWebCoreScheduler);
                AppMethodBeat.o(207364);
                return false;
            } else {
                hvT();
            }
        }
        XWalkInitializer.addXWalkInitializeLog("_doStartUpdate go on");
        if (!NetworkUtil.isNetworkAvailable()) {
            c hte = ah.hte();
            if (hte != null) {
                hte.bXK();
            }
            AppMethodBeat.o(207364);
            return false;
        } else if (hvJ.SIE || NetworkUtil.isWifiAvailable()) {
            if (hvS()) {
                if (SHJ.updateXWalkRuntime(xWebCoreScheduler.f(hvJ))) {
                    AppMethodBeat.o(207364);
                    return true;
                }
                XWalkInitializer.addXWalkInitializeLog("start update failed");
                hvT();
            }
            AppMethodBeat.o(207364);
            return false;
        } else {
            XWalkInitializer.addXWalkInitializeLog("current network is not wifi , this scheduler not support mobile data");
            c hte2 = ah.hte();
            if (hte2 != null) {
                hte2.bXK();
            }
            AppMethodBeat.o(207364);
            return false;
        }
    }

    public static synchronized boolean hvR() {
        boolean hvR;
        synchronized (g.class) {
            AppMethodBeat.i(154575);
            hvR = h.hvR();
            AppMethodBeat.o(154575);
        }
        return hvR;
    }

    public static synchronized boolean hvS() {
        boolean hvS;
        synchronized (g.class) {
            AppMethodBeat.i(207365);
            hvS = h.hvS();
            AppMethodBeat.o(207365);
        }
        return hvS;
    }

    public static synchronized void hvT() {
        synchronized (g.class) {
            AppMethodBeat.i(154577);
            h.hvT();
            AppMethodBeat.o(154577);
        }
    }

    public static void a(Scheduler scheduler) {
        AppMethodBeat.i(207366);
        XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        hvT();
        if (scheduler != null) {
            scheduler.e(null);
        }
        AppMethodBeat.o(207366);
    }

    public static void a(int i2, Scheduler scheduler) {
        AppMethodBeat.i(207367);
        hvT();
        if (scheduler != null) {
            scheduler.atj(i2);
        }
        AppMethodBeat.o(207367);
    }

    static void hvU() {
        AppMethodBeat.i(207368);
        if (XWebCoreScheduler.hvW().Ew(true)) {
            b(XWebCoreScheduler.hvW());
            AppMethodBeat.o(207368);
        } else if (i.hvV().Ew(true)) {
            b(i.hvV());
            AppMethodBeat.o(207368);
        } else {
            p.hQ("finished", -5);
            AppMethodBeat.o(207368);
        }
    }

    private static void b(XWebCoreScheduler xWebCoreScheduler) {
        AppMethodBeat.i(207369);
        XWalkEnvironment.addXWalkInitializeLog("try update after config " + xWebCoreScheduler.toString());
        if (hvR()) {
            AppMethodBeat.o(207369);
            return;
        }
        h.aJ(903, 160);
        c hte = ah.hte();
        if (hte != null) {
            hte.bXJ();
        }
        a(xWebCoreScheduler);
        AppMethodBeat.o(207369);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final /* synthetic */ Integer doInBackground(String[] strArr) {
        boolean z = true;
        AppMethodBeat.i(154582);
        if (!XWalkEnvironment.hasInstalledAvailableVersion() && !XWebCoreScheduler.hvW().hvz()) {
            XWalkEnvironment.addXWalkInitializeLog("isNeedFecthConfig: true because no scheduler and no availableVersion ");
        } else if (!Scheduler.Ev(false).hvI() || hvR()) {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(154582);
            return 2;
        } else if (XWebCoreScheduler.hvW().Ew(false) || i.hvV().Ew(false)) {
            XWalkEnvironment.addXWalkInitializeLog("fetch config before update");
            h.s(903, 159, 1);
            AppMethodBeat.o(154582);
            return 2;
        } else {
            AppMethodBeat.o(154582);
            return 0;
        }
    }
}
