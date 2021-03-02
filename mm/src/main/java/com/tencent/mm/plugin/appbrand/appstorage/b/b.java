package com.tencent.mm.plugin.appbrand.appstorage.b;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.appusage.x;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0019J\u001e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004J(\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0019H\u0002J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appstorage/compatibility/AppBrandScopedStorageTransfer;", "", "()V", "appBrandTargetFolder", "", "appId", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "rootPath", "tasks", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/appstorage/compatibility/AppBrandTransferTask;", "Lkotlin/collections/ArrayList;", OpenSDKTool4Assistant.EXTRA_UIN, "getUin", "()Ljava/lang/String;", "setUin", "(Ljava/lang/String;)V", "commit", "", "getKey", "into", "path", "isTransferred", "", "taskPaths", "nonFlattenedFSPath", "nonFlattenedOpenFSPath", "nonFlattenedClientFSPath", "tryTransfer", "Lcom/tencent/mm/plugin/appbrand/appstorage/compatibility/TransferTaskResult;", "task", "hasLocalRecord", "hasSyncRecord", "fakeNative", "with", "Companion", "plugin-appbrand-integration_release"})
public final class b {
    public static final a kTO = new a((byte) 0);
    public String appId;
    public final MultiProcessMMKV cQe = MultiProcessMMKV.getMMKV("MicroMsg.AppBrand.AppBrandScopedStorageTransfer");
    public final String jpM;
    public String kTM;
    public final ArrayList<c> kTN = new ArrayList<>();
    public String uin;

    static {
        AppMethodBeat.i(175119);
        AppMethodBeat.o(175119);
    }

    public b() {
        AppMethodBeat.i(175118);
        String absolutePath = new File(Environment.getExternalStorageDirectory(), "tencent/MicroMsg").getAbsolutePath();
        p.g(absolutePath, "java.io.File(Environment…t/MicroMsg\").absolutePath");
        this.jpM = a.Wr(absolutePath);
        AppMethodBeat.o(175118);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appstorage/compatibility/AppBrandScopedStorageTransfer$Companion;", "", "()V", "ID_KEY", "", "ID_KEY_DISAPPROVED", "ID_KEY_DISAPPROVED_NEED_TRANSFER", "ID_KEY_DISAPPROVED_NO_NEED_TRANSFER", "ID_KEY_FAIL", "ID_KEY_NO_NEED", "ID_KEY_START", "ID_KEY_SUCCESS", "TAG", "", "tryHardToGetCanonicalPath", "path", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static String Wr(String str) {
            String absolutePath;
            AppMethodBeat.i(175114);
            p.h(str, "path");
            File file = new File(str);
            try {
                absolutePath = file.getCanonicalPath();
            } catch (Throwable th) {
                absolutePath = file.getAbsolutePath();
            }
            AppMethodBeat.o(175114);
            return absolutePath;
        }
    }

    private static e a(c cVar, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(228119);
        try {
            e d2 = cVar.d(z, z2, z3);
            AppMethodBeat.o(228119);
            return d2;
        } catch (Exception e2) {
            if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.DEBUG) {
                Exception exc = e2;
                AppMethodBeat.o(228119);
                throw exc;
            }
            Log.printErrStackTrace("MicroMsg.AppBrand.AppBrandScopedStorageTransfer", e2, "tryTransfer", new Object[0]);
            e eVar = new e(false, true, String.valueOf(e2.getMessage()));
            AppMethodBeat.o(228119);
            return eVar;
        }
    }

    public final void commit() {
        boolean z;
        WxaAttributes.a bAn;
        AppMethodBeat.i(175116);
        StringBuilder sb = new StringBuilder("commit() with appId:");
        String str = this.appId;
        if (str == null) {
            p.btv("appId");
        }
        Log.i("MicroMsg.AppBrand.AppBrandScopedStorageTransfer", sb.append(str).toString());
        long currentTimeMillis = System.currentTimeMillis();
        h.INSTANCE.dN(1323, 3);
        String str2 = this.appId;
        if (str2 == null) {
            p.btv("appId");
        }
        String Xy = y.Xy(str2);
        if (Xy == null) {
            Log.w("MicroMsg.AppBrand.AppBrandScopedStorageTransfer", "commit: appId -> username failed");
            AppMethodBeat.o(175116);
            return;
        }
        com.tencent.mm.plugin.appbrand.appusage.b Ws = ((k) n.W(k.class)).Ws(Xy);
        if (Ws == null || Ws.field_updateTime == 0) {
            z = false;
        } else {
            z = true;
        }
        boolean bm = ((x) n.W(x.class)).bm(Xy, 0);
        WxaAttributes d2 = n.buC().d(Xy, new String[0]);
        boolean bAt = (d2 == null || (bAn = d2.bAn()) == null) ? false : bAn.bAt();
        Iterator<T> it = this.kTN.iterator();
        boolean z2 = true;
        while (it.hasNext()) {
            z2 = a(it.next(), z, bm, bAt).kTW & z2;
        }
        MultiProcessMMKV multiProcessMMKV = this.cQe;
        StringBuilder sb2 = new StringBuilder();
        String str3 = this.appId;
        if (str3 == null) {
            p.btv("appId");
        }
        StringBuilder append = sb2.append(str3);
        String str4 = this.uin;
        if (str4 == null) {
            p.btv(OpenSDKTool4Assistant.EXTRA_UIN);
        }
        multiProcessMMKV.putBoolean(append.append(str4).toString(), z2);
        long currentTimeMillis2 = System.currentTimeMillis();
        StringBuilder sb3 = new StringBuilder("commit() done with appId:");
        String str5 = this.appId;
        if (str5 == null) {
            p.btv("appId");
        }
        Log.i("MicroMsg.AppBrand.AppBrandScopedStorageTransfer", sb3.append(str5).append(" cost:").append(currentTimeMillis2 - currentTimeMillis).append("ms, res = [%b]").toString(), Boolean.valueOf(z2));
        if (z2) {
            h.INSTANCE.dN(1323, 0);
            AppMethodBeat.o(175116);
            return;
        }
        h.INSTANCE.dN(1323, 1);
        AppMethodBeat.o(175116);
    }

    public final b Wq(String str) {
        AppMethodBeat.i(175117);
        p.h(str, "appId");
        this.appId = str;
        AppMethodBeat.o(175117);
        return this;
    }
}
