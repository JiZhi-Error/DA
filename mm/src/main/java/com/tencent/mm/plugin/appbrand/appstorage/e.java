package com.tencent.mm.plugin.appbrand.appstorage;

import android.content.SharedPreferences;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.as;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.ArrayList;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0014H\u0002R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer;", "Lcom/tencent/mm/model/IDataTransfer;", "appid", "", "(Ljava/lang/String;)V", "appBrandMMKVStorage", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "kotlin.jvm.PlatformType", "mAppId", "mUin", "", "clearOldSchemeData", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "getTag", "markHadTransferToMMKV", "needTransfer", "", "sVer", "", "reportTransferResult", "bytesMatch", "sizeMatch", "transfer", "transferToMMKV", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer$Result;", "storageId", "Companion", "Result", "plugin-appbrand-integration_release"})
public final class e extends as {
    private static final String AbE = AbE;
    private static final String Abi = Abi;
    private static final String AgF = AgF;
    public static final a AkJ = new a((byte) 0);
    private final h Abe = ((com.tencent.luggage.sdk.customize.a) com.tencent.luggage.a.e.M(com.tencent.luggage.sdk.customize.a.class)).dD(this.mAppId);
    private final String mAppId;
    private final long mUin = new p(((com.tencent.mm.plugin.appbrand.appstorage.a.a) g.af(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).Wp(this.mAppId)).longValue();

    public e(String str) {
        kotlin.g.b.p.h(str, "appid");
        AppMethodBeat.i(50216);
        this.mAppId = str;
        AppMethodBeat.o(50216);
    }

    @Override // com.tencent.mm.model.as
    public final void transfer(int i2) {
        boolean z;
        b bVar;
        String str;
        AppMethodBeat.i(50213);
        if (!f.kRZ.bxl()) {
            Log.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] isNeedTransfer = false");
            AppMethodBeat.o(50213);
            return;
        }
        SharedPreferences defaultPreference = MMApplicationContext.getDefaultPreference();
        if (f.kRZ.bxj()) {
            Log.i("MicroMsg.AppBrandKVStorageTransfer", "rollback phases, clear [had transfer to mmkv] flag");
            defaultPreference.edit().putBoolean(a.e(Abi, this.mUin, this.mAppId), false).apply();
            this.Abe.VJ(this.mAppId);
            AppMethodBeat.o(50213);
            return;
        }
        boolean z2 = defaultPreference.getBoolean(a.e(Abi, this.mUin, this.mAppId), false);
        if (z2 && f.kRZ.bxi()) {
            kotlin.g.b.p.g(defaultPreference, "sharedPreferences");
            a(defaultPreference);
            defaultPreference.edit().putBoolean(a.e(AgF, this.mUin, this.mAppId), true).apply();
            AppMethodBeat.o(50213);
        } else if (z2) {
            Log.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] had transfer to mmkv, return");
            AppMethodBeat.o(50213);
        } else {
            Log.i("MicroMsg.AppBrandKVStorageTransfer", "start transfer");
            long j2 = 0;
            long j3 = 0;
            int i3 = 0;
            h.INSTANCE.F(1016, 0);
            long currentTimeMillis = System.currentTimeMillis();
            Log.i("MicroMsg.AppBrandKVStorageTransfer", "clear MMKV");
            this.Abe.VJ(this.mAppId);
            int[] VK = n.NK().VK(this.mAppId);
            kotlin.g.b.p.g(VK, "SubCoreAppBrand.getAppKV…).getAllStorageId(mAppId)");
            int VL = n.NK().VL(this.mAppId);
            for (int i4 : VK) {
                Object obj = n.NK().Z(i4, this.mAppId)[0];
                if (!(obj instanceof ArrayList)) {
                    obj = null;
                }
                ArrayList arrayList = (ArrayList) obj;
                if (arrayList == null) {
                    bVar = new b(0, 0, 0);
                } else if (arrayList.size() == 0) {
                    bVar = new b(0, 0, 0);
                } else {
                    Log.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] key size = " + arrayList.size());
                    long j4 = 0;
                    long j5 = 0;
                    for (Object obj2 : arrayList) {
                        if (!(obj2 instanceof String)) {
                            obj2 = null;
                        }
                        String str2 = (String) obj2;
                        if (str2 == null) {
                            str = "";
                        } else {
                            str = str2;
                        }
                        long currentTimeMillis2 = System.currentTimeMillis();
                        Object[] l = n.NK().l(i4, this.mAppId, str);
                        kotlin.g.b.p.g(l, "SubCoreAppBrand.getAppKV…t(storageId, mAppId, key)");
                        long currentTimeMillis3 = (System.currentTimeMillis() - currentTimeMillis2) + j4;
                        Object obj3 = l[1];
                        Object obj4 = l[2];
                        if ((!kotlin.g.b.p.j(str, "")) && l[0] == p.a.NONE && (obj3 instanceof String) && (obj4 instanceof String)) {
                            long currentTimeMillis4 = System.currentTimeMillis();
                            this.Abe.c(i4, this.mAppId, str, (String) obj3, (String) obj4);
                            j5 += System.currentTimeMillis() - currentTimeMillis4;
                        }
                        j5 = j5;
                        j4 = currentTimeMillis3;
                    }
                    bVar = new b(j4, j5, arrayList.size());
                }
                j2 += bVar.Alj;
                j3 += bVar.Alk;
                i3 += bVar.size;
            }
            long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
            if (5000 < currentTimeMillis5) {
                h.INSTANCE.F(1016, 12);
            } else {
                h.INSTANCE.F(1016, 11);
            }
            Log.i("MicroMsg.AppBrandKVStorageTransfer", "finish transfer, cost total time= " + currentTimeMillis5 + " ms read time = " + j2 + " ms, write time = " + j3 + " ms");
            int VL2 = this.Abe.VL(this.mAppId);
            int VU = this.Abe.VU(this.mAppId);
            Log.i("MicroMsg.AppBrandKVStorageTransfer", "newbytes =" + VL2 + " oldbytes =" + VL + "  newsize =" + VU + "  oldsize =" + i3 + ' ');
            boolean z3 = VL2 == VL;
            if (VU == i3) {
                z = true;
            } else {
                z = false;
            }
            if (z3 && z) {
                h.INSTANCE.F(1016, 1);
            } else if (!z3 && !z) {
                h.INSTANCE.F(1016, 4);
            } else if (!z3) {
                h.INSTANCE.F(1016, 3);
            } else if (!z) {
                h.INSTANCE.F(1016, 2);
            }
            if (VU != i3) {
                IllegalStateException illegalStateException = new IllegalStateException("tansfer failed ");
                if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    AppMethodBeat.o(50213);
                    throw illegalStateException2;
                }
                Log.printErrStackTrace("MicroMsg.AppBrandKVStorageTransfer", illegalStateException, "transfer failed", new Object[0]);
            }
            Log.i("MicroMsg.AppBrandKVStorageTransfer", "finish transfer, prev ");
            h.INSTANCE.a(16335, this.mAppId, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(VL2), Integer.valueOf(this.Abe.VU(this.mAppId)));
            kotlin.g.b.p.g(defaultPreference, "sharedPreferences");
            defaultPreference.edit().putBoolean(a.e(Abi, this.mUin, this.mAppId), true).apply();
            if (f.kRZ.bxi()) {
                a(defaultPreference);
                defaultPreference.edit().putBoolean(a.e(AgF, this.mUin, this.mAppId), true).apply();
            }
            AppMethodBeat.o(50213);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer$Result;", "", "readTime", "", "writeTime", "size", "", "(JJI)V", "getReadTime", "()J", "setReadTime", "(J)V", "getSize", "()I", "getWriteTime", "setWriteTime", "component1", "component2", "component3", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-appbrand-integration_release"})
    static final class b {
        long Alj;
        long Alk;
        final int size;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    if (!(this.Alj == bVar.Alj && this.Alk == bVar.Alk && this.size == bVar.size)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            long j2 = this.Alj;
            long j3 = this.Alk;
            return (((((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.size;
        }

        public final String toString() {
            AppMethodBeat.i(50212);
            String str = "Result(readTime=" + this.Alj + ", writeTime=" + this.Alk + ", size=" + this.size + ")";
            AppMethodBeat.o(50212);
            return str;
        }

        public b(long j2, long j3, int i2) {
            this.Alj = j2;
            this.Alk = j3;
            this.size = i2;
        }
    }

    private final void a(SharedPreferences sharedPreferences) {
        AppMethodBeat.i(50214);
        if (sharedPreferences.getBoolean(a.e(AbE, this.mUin, this.mAppId), false)) {
            Log.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] had clear old scheme data, return");
            AppMethodBeat.o(50214);
            return;
        }
        Log.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] clear old scheme data");
        n.NK().VJ(this.mAppId);
        sharedPreferences.edit().putBoolean(a.e(AbE, this.mUin, this.mAppId), true).apply();
        AppMethodBeat.o(50214);
    }

    @Override // com.tencent.mm.model.as
    public final boolean rT(int i2) {
        boolean z = false;
        AppMethodBeat.i(50215);
        if (!MMApplicationContext.getDefaultPreference().getBoolean(a.e(AgF, this.mUin, this.mAppId), false)) {
            z = true;
        }
        Log.i("MicroMsg.AppBrandKVStorageTransfer", "needTransfer ".concat(String.valueOf(z)));
        AppMethodBeat.o(50215);
        return z;
    }

    @Override // com.tencent.mm.model.as
    public final String getTag() {
        return "MicroMsg.AppBrandKVStorageTransfer";
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer$Companion;", "", "()V", "KEY_HAD_CLEAN_OLD_SCHEME", "", "KEY_HAD_FINISH_TRANSFER", "KEY_HAD_TRANSFER_TO_MMKV", "TAG", "getKey", "key", OpenSDKTool4Assistant.EXTRA_UIN, "", "appId", "getStorageScheme", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static String e(String str, long j2, String str2) {
            AppMethodBeat.i(50210);
            kotlin.g.b.p.h(str, "key");
            kotlin.g.b.p.h(str2, "appId");
            String str3 = str + '#' + j2 + '#' + str2;
            AppMethodBeat.o(50210);
            return str3;
        }

        public static int bxm(String str) {
            int i2;
            AppMethodBeat.i(50211);
            kotlin.g.b.p.h(str, "appId");
            SharedPreferences defaultPreference = MMApplicationContext.getDefaultPreference();
            long longValue = new com.tencent.mm.b.p(((com.tencent.mm.plugin.appbrand.appstorage.a.a) g.af(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).Wp(str)).longValue();
            if (defaultPreference.getBoolean(e(e.AgF, longValue, str), false)) {
                i2 = 2;
            } else if (!defaultPreference.getBoolean(e(e.Abi, longValue, str), false) || f.kRZ.bxj()) {
                i2 = 1;
            } else {
                i2 = 3;
            }
            Log.i("MicroMsg.AppBrandKVStorageTransfer", "getStorageScheme:".concat(String.valueOf(i2)));
            AppMethodBeat.o(50211);
            return i2;
        }
    }

    static {
        AppMethodBeat.i(50217);
        AppMethodBeat.o(50217);
    }
}
