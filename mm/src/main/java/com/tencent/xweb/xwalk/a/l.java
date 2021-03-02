package com.tencent.xweb.xwalk.a;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.ai;
import com.tencent.xweb.util.h;
import com.tencent.xweb.xwalk.a.a;
import com.tencent.xweb.xwalk.p;
import com.tencent.xweb.xwalk.updater.Scheduler;
import com.tencent.xweb.xwalk.updater.a;
import com.tencent.xweb.xwalk.updater.j;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkLibraryLoader;

public final class l extends AsyncTask<String, Integer, Integer> {
    String SHX = "";
    j SHY = null;
    private final Object SIa = new Object();
    a SIb = new a();
    private Map<String, b> SIc = new HashMap();
    private int SId = 0;
    private int SIe = 0;
    private int SIf = 0;
    private int SIg = 0;
    private int SIh = 0;
    boolean SIi = false;

    public static class a {
        public int SIk = 0;
        public int errCode = 0;
    }

    public static class b {
        public boolean Cch = false;
        public AsyncTask jpQ = null;
        public int type = 1;
    }

    public l() {
        AppMethodBeat.i(154522);
        AppMethodBeat.o(154522);
    }

    static /* synthetic */ boolean a(l lVar) {
        AppMethodBeat.i(154532);
        boolean hvt = lVar.hvt();
        AppMethodBeat.o(154532);
        return hvt;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(Integer num) {
        AppMethodBeat.i(154529);
        Integer num2 = num;
        if (num2.intValue() == -2 || num2.intValue() == -3 || num2.intValue() == -4) {
            b(5, num2.intValue(), null);
        } else if (!b(2, 1, null)) {
            XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "status change to fetch config failed");
        } else {
            j.a aVar = new j.a();
            aVar.mUrl = XWalkEnvironment.getPluginConfigUrl();
            aVar.mFilePath = XWalkEnvironment.getPluginUpdateConfigFilePath();
            aVar.SJE = true;
            j.a(aVar, new com.tencent.xweb.xwalk.updater.b() {
                /* class com.tencent.xweb.xwalk.a.l.AnonymousClass1 */

                @Override // com.tencent.xweb.xwalk.updater.b
                public final void hvu() {
                    AppMethodBeat.i(207342);
                    k.OY(System.currentTimeMillis());
                    h.huy();
                    AppMethodBeat.o(207342);
                }

                @Override // com.tencent.xweb.xwalk.updater.b
                public final void a(j.c cVar) {
                    a.d l;
                    boolean z;
                    AppMethodBeat.i(154512);
                    h.huz();
                    String str = cVar.mFilePath;
                    if (str == null) {
                        XWalkInitializer.addXWalkInitializeLog("parse plugin config failed ,path is empty");
                        l = null;
                    } else {
                        File file = new File(str);
                        if (!file.exists()) {
                            XWalkInitializer.addXWalkInitializeLog("parse plugin config failed ,file not exist");
                            l = null;
                        } else {
                            l = com.tencent.xweb.xwalk.updater.a.l(file, com.tencent.xweb.xwalk.updater.a.a(file, (int) file.length(), "<Plugins>"));
                        }
                    }
                    if (l == null) {
                        XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "parse plugin config failed");
                        h.huB();
                        l.a(l.this, -6);
                        AppMethodBeat.o(154512);
                        return;
                    }
                    h.dO(l.SIJ, false);
                    com.tencent.xweb.b.a(l.SIL, l.SIJ);
                    p.hQ("plugin_update", 0);
                    if (l.SIN == null || l.SIN.length == 0) {
                        XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "plugin config contains no plugin");
                        l.a(l.this, -7);
                        AppMethodBeat.o(154512);
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    for (g gVar : h.hvo()) {
                        if (gVar == null) {
                            XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "process plugin null");
                        } else {
                            a.C2235a bsQ = a.bsQ(gVar.getPluginName());
                            if (l.a(l.this) && !l.this.SHX.equals(gVar.getPluginName())) {
                                XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "set only update " + l.this.SHX + ", skip " + gVar.getPluginName());
                            } else if (!ai.htj() || gVar.hvi()) {
                                int hvk = gVar.hvk();
                                l.a(l.this);
                                a.e a2 = a(l, gVar.getPluginName(), hvk, l.a(l.this));
                                if (a2 == null) {
                                    XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "no matched plugin version, skip " + gVar.getPluginName());
                                    bsQ.e(null);
                                } else {
                                    com.tencent.xweb.xwalk.updater.c cVar2 = new com.tencent.xweb.xwalk.updater.c();
                                    cVar2.version = a2.version;
                                    cVar2.SJl = false;
                                    a.c a3 = a(a2, hvk);
                                    if (a3 != null) {
                                        int i2 = a2.SIv;
                                        if (XWalkEnvironment.getApplicationContext() == null) {
                                            Log.e(gVar.getPluginName(), "canDownloadPatch, context is null");
                                            z = false;
                                        } else {
                                            SharedPreferences sharedPreferencesForPluginVersionInfo = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(gVar.getPluginName());
                                            if (sharedPreferencesForPluginVersionInfo == null) {
                                                Log.e(gVar.getPluginName(), "canDownloadPatch, sp is null");
                                                z = false;
                                            } else if (sharedPreferencesForPluginVersionInfo.getInt(XWalkEnvironment.SP_KEY_PLUGIN_PATCH_DOWNLOAD_COUNT_PREFIX.concat(String.valueOf(i2)), 0) <= 1) {
                                                Log.i(gVar.getPluginName(), "canDownloadPatch, ret = true");
                                                z = true;
                                            } else {
                                                Log.i(gVar.getPluginName(), "canDownloadPatch, ret = false");
                                                z = false;
                                            }
                                        }
                                        if (z) {
                                            cVar2.SIw = a3.SIw;
                                            cVar2.SID = a3.SID;
                                            cVar2.path = gVar.ca(cVar2.version, true);
                                            cVar2.SIE = a3.SIE;
                                            cVar2.bUseCdn = a3.bUseCdn;
                                            cVar2.SJc = true;
                                            cVar2.SIv = a2.SIv;
                                            cVar2.SIG = a2.SIG;
                                            cVar2.SIH = a2.SIH;
                                            cVar2.SII = a2.SII;
                                            if (cVar2.path != null || cVar2.path.isEmpty()) {
                                                XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "download path is empty, skip " + gVar.getPluginName());
                                                bsQ.e(null);
                                            } else {
                                                cVar2.SJf = Scheduler.a(a2, gVar.getPluginName());
                                                com.tencent.xweb.xwalk.updater.c d2 = bsQ.d(cVar2);
                                                if (l.a(l.this) || bsQ.Ew(true)) {
                                                    h.s(903, (long) (bsQ.hvd() + 160), 1);
                                                    if (!l.a(l.this) && !NetworkUtil.isNetworkAvailable()) {
                                                        XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "network is not available, skip " + gVar.getPluginName());
                                                    } else if (l.a(l.this) || d2.SIE || NetworkUtil.isWifiAvailable()) {
                                                        b bVar = new b();
                                                        c cVar3 = new c(l.this, gVar, d2);
                                                        XWalkLibraryLoader.WXFileDownloaderTask wXFileDownloaderTask = new XWalkLibraryLoader.WXFileDownloaderTask(false, cVar3, d2.SIw, d2.path, d2.SJc ? 2 : 1);
                                                        if (!d2.bUseCdn || !wXFileDownloaderTask.isValid()) {
                                                            XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "use default file downloader, plugin: " + gVar.getPluginName() + " isPatch: " + d2.SJc);
                                                            bVar.jpQ = new XWalkLibraryLoader.HttpDownloadTask(false, cVar3, d2.SIw, d2.path);
                                                            bVar.type = 1;
                                                        } else {
                                                            XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "use wx file downloader, plugin: " + gVar.getPluginName() + " isPatch: " + d2.SJc);
                                                            bVar.jpQ = wXFileDownloaderTask;
                                                            bVar.type = 2;
                                                        }
                                                        hashMap.put(gVar.getPluginName(), bVar);
                                                        if (d2.SJc) {
                                                            int i3 = a2.SIv;
                                                            if (XWalkEnvironment.getApplicationContext() == null) {
                                                                Log.e(gVar.getPluginName(), "recordPatchDownloadInfo, context is null");
                                                            } else {
                                                                SharedPreferences sharedPreferencesForPluginVersionInfo2 = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(gVar.getPluginName());
                                                                if (sharedPreferencesForPluginVersionInfo2 == null) {
                                                                    Log.e(gVar.getPluginName(), "recordPatchDownloadInfo, sp is null");
                                                                } else {
                                                                    String concat = XWalkEnvironment.SP_KEY_PLUGIN_PATCH_DOWNLOAD_COUNT_PREFIX.concat(String.valueOf(i3));
                                                                    int i4 = sharedPreferencesForPluginVersionInfo2.getInt(concat, 0);
                                                                    SharedPreferences.Editor edit = sharedPreferencesForPluginVersionInfo2.edit();
                                                                    edit.putInt(concat, i4 + 1);
                                                                    edit.commit();
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "can not use cellular, skip " + gVar.getPluginName());
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    cVar2.SIw = a2.SIw;
                                    cVar2.SID = a2.SID;
                                    cVar2.path = gVar.ca(cVar2.version, false);
                                    cVar2.SIE = a2.SIE;
                                    cVar2.bUseCdn = a2.bUseCdn;
                                    cVar2.SJc = false;
                                    cVar2.SIv = a2.SIv;
                                    cVar2.SIG = a2.SIG;
                                    cVar2.SIH = a2.SIH;
                                    cVar2.SII = a2.SII;
                                    if (cVar2.path != null) {
                                    }
                                    XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "download path is empty, skip " + gVar.getPluginName());
                                    bsQ.e(null);
                                }
                            } else {
                                XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "forbid download code, skip " + gVar.getPluginName());
                                bsQ.e(null);
                            }
                        }
                    }
                    if (hashMap.size() == 0) {
                        XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "no available update, no task");
                        l.a(l.this, -8);
                        AppMethodBeat.o(154512);
                        return;
                    }
                    l.a(l.this, hashMap);
                    AppMethodBeat.o(154512);
                }

                @Override // com.tencent.xweb.xwalk.updater.b
                public final void b(j.c cVar) {
                    AppMethodBeat.i(154513);
                    XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "plugin config download failed: " + cVar.SJG);
                    h.huA();
                    l.a(l.this, -5);
                    AppMethodBeat.o(154513);
                }

                private static a.e a(a.d dVar, String str, int i2, boolean z) {
                    AppMethodBeat.i(207343);
                    if (dVar == null || dVar.SIN == null || dVar.SIN.length == 0 || str == null || str.isEmpty()) {
                        Log.e("XWalkPluginUp", "findMatchedPluginInfo params error");
                        AppMethodBeat.o(207343);
                        return null;
                    }
                    a.e[] eVarArr = dVar.SIN;
                    for (a.e eVar : eVarArr) {
                        if (str.equals(eVar.SIO) && eVar.version > i2 && eVar.SCE.Ep(z)) {
                            AppMethodBeat.o(207343);
                            return eVar;
                        }
                    }
                    AppMethodBeat.o(207343);
                    return null;
                }

                private static a.c a(a.e eVar, int i2) {
                    if (eVar == null || eVar.SIB == null || eVar.SIB.length == 0) {
                        return null;
                    }
                    a.c[] cVarArr = eVar.SIB;
                    for (a.c cVar : cVarArr) {
                        if (cVar.SIM == i2) {
                            return cVar;
                        }
                    }
                    return null;
                }
            });
        }
        super.onPostExecute(num2);
        AppMethodBeat.o(154529);
    }

    public final void a(HashMap<String, String> hashMap, String str, j jVar) {
        String str2;
        AppMethodBeat.i(207345);
        if (!(hashMap == null || (str2 = hashMap.get("UpdaterCheckType")) == null || !str2.equals("1"))) {
            k.OY(0);
        }
        this.SHX = str;
        this.SHY = jVar;
        AppMethodBeat.o(207345);
    }

    public final void hR(String str, int i2) {
        boolean z;
        AppMethodBeat.i(154524);
        XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "onNotifyResult: " + str + " install retCode: " + i2);
        synchronized (this.SIa) {
            try {
                if (this.SIb.SIk != 5) {
                    switch (i2) {
                        case -3:
                            this.SIe++;
                            break;
                        case -2:
                            this.SIg++;
                            break;
                        case -1:
                            this.SIf++;
                            break;
                        case 0:
                            this.SIh++;
                            break;
                    }
                    this.SIc.get(str).Cch = true;
                    Iterator<Map.Entry<String, b>> it = this.SIc.entrySet().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            b value = it.next().getValue();
                            if (value != null && !value.Cch) {
                                z = false;
                            }
                        } else {
                            z = true;
                        }
                    }
                    int i3 = this.SIb.SIk;
                    if (z) {
                        this.SIc.clear();
                        this.SIb.SIk = 5;
                        if (this.SIf > 0 || this.SIg > 0) {
                            this.SIb.errCode = -9;
                        }
                    }
                    be(i3, this.SIb.SIk, this.SIb.errCode);
                    AppMethodBeat.o(154524);
                }
            } finally {
                AppMethodBeat.o(154524);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean b(int i2, int i3, Map<String, b> map) {
        int i4;
        int i5;
        int i6;
        AppMethodBeat.i(154525);
        synchronized (this.SIa) {
            try {
                i4 = this.SIb.SIk;
                if (i2 > i4) {
                    this.SIb.SIk = i2;
                    if (i3 != 1) {
                        this.SIb.errCode = i3;
                    }
                    if (this.SIb.SIk == 4) {
                        if (this.SIc.size() == 0) {
                            this.SIb.SIk = 5;
                        } else {
                            for (Map.Entry<String, b> entry : this.SIc.entrySet()) {
                                b value = entry.getValue();
                                if (value != null && !value.Cch) {
                                    value.jpQ.cancel(true);
                                }
                            }
                        }
                    } else if (this.SIb.SIk == 3 && map != null) {
                        for (Map.Entry<String, b> entry2 : map.entrySet()) {
                            String key = entry2.getKey();
                            b value2 = entry2.getValue();
                            this.SIc.put(key, value2);
                            if (value2.type == 1) {
                                ((XWalkLibraryLoader.HttpDownloadTask) value2.jpQ).execute(new Void[0]);
                            } else if (value2.type == 2) {
                                ((XWalkLibraryLoader.WXFileDownloaderTask) value2.jpQ).execute(new Void[0]);
                            } else {
                                this.SIc.remove(key);
                            }
                        }
                        this.SId = this.SIc.size();
                    }
                }
                i5 = this.SIb.SIk;
                i6 = this.SIb.errCode;
            } catch (Throwable th) {
                AppMethodBeat.o(154525);
                throw th;
            }
        }
        be(i4, i5, i6);
        if (i5 > i4) {
            AppMethodBeat.o(154525);
            return true;
        }
        AppMethodBeat.o(154525);
        return false;
    }

    private void be(int i2, int i3, int i4) {
        AppMethodBeat.i(154526);
        if (i3 <= i2) {
            Log.i("XWalkPluginUp", "status not changed, return");
            AppMethodBeat.o(154526);
            return;
        }
        Log.i("XWalkPluginUp", "change status from " + i2 + " to " + i3 + " errcode: " + i4);
        if (hvt()) {
            if (i2 == 0 && i3 == 1) {
                this.SHY.hst();
            } else if (i2 != 0 && i3 == 5) {
                this.SHY.asR(i4);
            }
        }
        if (i3 == 5) {
            h.dz(15718, this.SIb.errCode + "," + this.SId + "," + this.SIe + "," + this.SIf + "," + this.SIg + "," + this.SIh);
            k.hvs();
            this.SIi = true;
        }
        AppMethodBeat.o(154526);
    }

    /* access modifiers changed from: package-private */
    public final boolean hvt() {
        AppMethodBeat.i(154527);
        if (this.SHX == null || this.SHX.isEmpty() || this.SHY == null) {
            AppMethodBeat.o(154527);
            return false;
        }
        AppMethodBeat.o(154527);
        return true;
    }

    public static class c implements XWalkLibraryLoader.DownloadListener {
        private l SHZ;
        private g SIl;
        private com.tencent.xweb.xwalk.updater.c SIm;
        private boolean SIn;

        c(l lVar, g gVar, com.tencent.xweb.xwalk.updater.c cVar) {
            AppMethodBeat.i(207344);
            this.SHZ = lVar;
            this.SIl = gVar;
            this.SIm = cVar;
            if (cVar != null) {
                this.SIn = cVar.SJc;
                AppMethodBeat.o(207344);
                return;
            }
            this.SIn = false;
            AppMethodBeat.o(207344);
        }

        @Override // org.xwalk.core.XWalkLibraryLoader.DownloadListener
        public final void onDownloadStarted(int i2) {
            AppMethodBeat.i(154517);
            h.dJ(this.SIl.getPluginName(), this.SIn);
            AppMethodBeat.o(154517);
        }

        @Override // org.xwalk.core.XWalkLibraryLoader.DownloadListener
        public final void onDownloadUpdated(int i2) {
            AppMethodBeat.i(154518);
            l lVar = this.SHZ;
            String pluginName = this.SIl.getPluginName();
            if (lVar.SIb.SIk == 3 && lVar.hvt() && lVar.SHX.equals(pluginName)) {
                lVar.SHY.asQ(i2);
            }
            AppMethodBeat.o(154518);
        }

        @Override // org.xwalk.core.XWalkLibraryLoader.DownloadListener
        public final void onDownloadCancelled() {
            AppMethodBeat.i(154519);
            this.SHZ.hR(this.SIl.getPluginName(), -3);
            h.dL(this.SIl.getPluginName(), this.SIn);
            a.bsQ(this.SIl.getPluginName()).e(null);
            AppMethodBeat.o(154519);
        }

        @Override // org.xwalk.core.XWalkLibraryLoader.DownloadListener
        public final void onDownloadCompleted(XWalkLibraryLoader.DownloadInfo downloadInfo) {
            AppMethodBeat.i(154520);
            h.dK(this.SIl.getPluginName(), this.SIn);
            a.bsQ(this.SIl.getPluginName()).e(null);
            new AsyncTask<Void, Void, Integer>() {
                /* class com.tencent.xweb.xwalk.a.l.c.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public final /* synthetic */ void onPostExecute(Integer num) {
                    AppMethodBeat.i(154515);
                    if (num.intValue() == 0) {
                        c.this.SHZ.hR(c.this.SIl.getPluginName(), 0);
                        AppMethodBeat.o(154515);
                        return;
                    }
                    c.this.SHZ.hR(c.this.SIl.getPluginName(), -2);
                    AppMethodBeat.o(154515);
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
                /* access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public final /* synthetic */ Integer doInBackground(Void[] voidArr) {
                    AppMethodBeat.i(154516);
                    if (c.this.SIl == null && c.this.SIm == null) {
                        AppMethodBeat.o(154516);
                        return -1;
                    }
                    Integer valueOf = Integer.valueOf(c.this.SIl.a(c.this.SIm));
                    AppMethodBeat.o(154516);
                    return valueOf;
                }
            }.execute(new Void[0]);
            AppMethodBeat.o(154520);
        }

        @Override // org.xwalk.core.XWalkLibraryLoader.DownloadListener
        public final void onDownloadFailed(XWalkLibraryLoader.DownloadInfo downloadInfo) {
            AppMethodBeat.i(154521);
            this.SHZ.hR(this.SIl.getPluginName(), -1);
            h.dL(this.SIl.getPluginName(), this.SIn);
            a.bsQ(this.SIl.getPluginName()).e(null);
            AppMethodBeat.o(154521);
        }
    }

    /* access modifiers changed from: protected */
    public final void onPreExecute() {
        AppMethodBeat.i(154528);
        b(1, 1, null);
        super.onPreExecute();
        AppMethodBeat.o(154528);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final /* synthetic */ Integer doInBackground(String[] strArr) {
        boolean z;
        long j2;
        boolean z2;
        AppMethodBeat.i(154530);
        if (!NetworkUtil.isNetworkAvailable()) {
            XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "network not available");
            AppMethodBeat.o(154530);
            return -2;
        }
        if (a.bsQ(XWalkEnvironment.XWALK_PLUGIN_NAME_PDF).hvB()) {
            XWalkEnvironment.addXWalkInitializeLog("in plugin free fetch config timezone");
        }
        Iterator<g> it = h.hvo().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            g next = it.next();
            if (next != null && a.bsQ(next.getPluginName()).Ew(false)) {
                z = true;
                break;
            }
        }
        if (z) {
            XWalkEnvironment.addXWalkInitializeLog("has plugin need update, fetch pluginconfig first");
            z2 = true;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            SharedPreferences sharedPreferencesForPluginUpdateInfo = XWalkEnvironment.getSharedPreferencesForPluginUpdateInfo();
            if (sharedPreferencesForPluginUpdateInfo == null) {
                XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "get time sp is null");
                j2 = 0;
            } else {
                j2 = sharedPreferencesForPluginUpdateInfo.getLong(XWalkEnvironment.SP_KEY_PLUGIN_UPDATE_CONFIG_LAST_FETCH_TIME, 0);
            }
            if (currentTimeMillis - j2 >= ((long) XWalkEnvironment.getPluginUpdatePeriod()) || currentTimeMillis < j2) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        if (!z2) {
            XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "too close, no need to fetch");
            AppMethodBeat.o(154530);
            return -3;
        } else if (k.hvr()) {
            XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "is updating by others, return");
            AppMethodBeat.o(154530);
            return -4;
        } else {
            SharedPreferences sharedPreferencesForPluginUpdateInfo2 = XWalkEnvironment.getSharedPreferencesForPluginUpdateInfo();
            if (sharedPreferencesForPluginUpdateInfo2 != null) {
                int myPid = Process.myPid();
                SharedPreferences.Editor edit = sharedPreferencesForPluginUpdateInfo2.edit();
                edit.putInt(XWalkEnvironment.SP_KEY_PLUGIN_UPDATE_PROCESS_ID, myPid);
                edit.commit();
                XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "plugin update progress start pid ".concat(String.valueOf(myPid)));
            }
            if (com.tencent.xweb.internal.c.cl("plugin_clear_old_versions", Util.MILLSECONDS_OF_DAY)) {
                XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "try clear old plugin versions");
                h.hvq();
            } else {
                XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "no need to clear old plugin versions");
            }
            if (com.tencent.xweb.internal.c.cl("plugin_check_files", 43200000)) {
                XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "try check plugin files");
                h.hvj();
            } else {
                XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "no need to check plugin files");
            }
            AppMethodBeat.o(154530);
            return 0;
        }
    }

    static /* synthetic */ boolean a(l lVar, int i2) {
        AppMethodBeat.i(154531);
        boolean b2 = lVar.b(5, i2, null);
        AppMethodBeat.o(154531);
        return b2;
    }

    static /* synthetic */ boolean a(l lVar, Map map) {
        AppMethodBeat.i(154533);
        boolean b2 = lVar.b(3, 1, map);
        AppMethodBeat.o(154533);
        return b2;
    }
}
