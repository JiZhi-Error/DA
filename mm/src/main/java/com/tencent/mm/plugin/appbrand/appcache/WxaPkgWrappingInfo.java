package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class WxaPkgWrappingInfo extends ModulePkgInfo implements Parcelable, Iterable<ModulePkgInfo> {
    public static final Parcelable.Creator<WxaPkgWrappingInfo> CREATOR = new Parcelable.Creator<WxaPkgWrappingInfo>() {
        /* class com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo.AnonymousClass2 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WxaPkgWrappingInfo[] newArray(int i2) {
            return new WxaPkgWrappingInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WxaPkgWrappingInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(178555);
            WxaPkgWrappingInfo wxaPkgWrappingInfo = new WxaPkgWrappingInfo(parcel);
            AppMethodBeat.o(178555);
            return wxaPkgWrappingInfo;
        }
    };
    static a kNV;
    public int kNW;
    public long kNX;
    @Deprecated
    public boolean kNY;
    public final LinkedList<ModulePkgInfo> kNZ;
    private volatile transient Map<String, String> kOa;
    public WxaRuntimeModulePluginListMap kOb;

    public interface a {
        ModulePkgInfo b(List<ModulePkgInfo> list, String str, String str2);
    }

    static {
        AppMethodBeat.i(134298);
        WxaPkgWrappingInfo.class.getClassLoader();
        j.Ed("appbrandcommon");
        AppMethodBeat.o(134298);
    }

    public static void a(a aVar) {
        kNV = aVar;
    }

    /* access modifiers changed from: package-private */
    public final void Vv(String str) {
        AppMethodBeat.i(178556);
        synchronized (this.kNZ) {
            try {
                if (!this.kNZ.isEmpty() && this.kOa == null) {
                    this.kOa = new ArrayMap();
                    Iterator<ModulePkgInfo> it = this.kNZ.iterator();
                    while (it.hasNext()) {
                        ModulePkgInfo next = it.next();
                        next.pkgVersion = this.pkgVersion;
                        String Vw = Vw(next.name);
                        Log.i("Luggage.WXA.WxaPkgWrappingInfo", "setupModuleEnv, appId:%s, module mapped %s -> %s", str, next.name, Vw);
                        if (!Vw.equals(next.name)) {
                            this.kOa.put(Vw, next.name);
                            next.name = Vw;
                        }
                    }
                    Log.i("Luggage.WXA.WxaPkgWrappingInfo", "setupModuleEnv, appId:%s, NameMap.size:%d", str, Integer.valueOf(this.kOa.size()));
                    AppMethodBeat.o(178556);
                }
            } finally {
                AppMethodBeat.o(178556);
            }
        }
    }

    public static String Vw(String str) {
        AppMethodBeat.i(178557);
        if (ModulePkgInfo.MAIN_MODULE_NAME.equals(str)) {
            AppMethodBeat.o(178557);
            return str;
        }
        String We = n.We(str);
        AppMethodBeat.o(178557);
        return We;
    }

    public final String cv(String str, String str2) {
        String str3;
        AppMethodBeat.i(178558);
        if (ModulePkgInfo.MAIN_MODULE_NAME.equals(str2)) {
            AppMethodBeat.o(178558);
            return str2;
        }
        synchronized (this.kNZ) {
            try {
                if (this.kOa == null) {
                    Vv(str);
                }
                str3 = this.kOa.get(str2);
                if (TextUtils.isEmpty(str3)) {
                    str3 = str2;
                }
            } catch (Throwable th) {
                AppMethodBeat.o(178558);
                throw th;
            }
        }
        Log.i("Luggage.WXA.WxaPkgWrappingInfo", "getModuleNameForURLFetch appId:%s, retrace module %s -> %s", str, str2, str3);
        AppMethodBeat.o(178558);
        return str3;
    }

    @Override // java.lang.Iterable
    public final Iterator<ModulePkgInfo> iterator() {
        AppMethodBeat.i(178559);
        AnonymousClass1 r0 = new Iterator<ModulePkgInfo>() {
            /* class com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo.AnonymousClass1 */
            private boolean kOc = false;
            private Iterator<ModulePkgInfo> kOd = null;

            public final boolean hasNext() {
                AppMethodBeat.i(178553);
                if (!this.kOc) {
                    AppMethodBeat.o(178553);
                    return true;
                }
                if (this.kOd == null) {
                    this.kOd = WxaPkgWrappingInfo.this.kNZ.iterator();
                }
                boolean hasNext = this.kOd.hasNext();
                AppMethodBeat.o(178553);
                return hasNext;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.Iterator
            public final /* bridge */ /* synthetic */ ModulePkgInfo next() {
                AppMethodBeat.i(178554);
                if (!this.kOc) {
                    this.kOc = true;
                    WxaPkgWrappingInfo wxaPkgWrappingInfo = WxaPkgWrappingInfo.this;
                    AppMethodBeat.o(178554);
                    return wxaPkgWrappingInfo;
                }
                ModulePkgInfo next = this.kOd.next();
                AppMethodBeat.o(178554);
                return next;
            }
        };
        AppMethodBeat.o(178559);
        return r0;
    }

    public static WxaPkgWrappingInfo Vx(String str) {
        AppMethodBeat.i(134290);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(134290);
            return null;
        }
        o oVar = new o(str);
        if (!oVar.exists() || oVar.isDirectory()) {
            Log.e("MicroMsg.WxaPkgWrappingInfo#obtain", "wxPkg invalid, path = %s ", str);
            AppMethodBeat.o(134290);
            return null;
        }
        WxaPkgWrappingInfo wxaPkgWrappingInfo = new WxaPkgWrappingInfo();
        wxaPkgWrappingInfo.pkgPath = str;
        wxaPkgWrappingInfo.kNY = false;
        wxaPkgWrappingInfo.md5 = n(oVar);
        AppMethodBeat.o(134290);
        return wxaPkgWrappingInfo;
    }

    public static WxaPkgWrappingInfo Vy(String str) {
        AppMethodBeat.i(134292);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.WxaPkgWrappingInfo#obtainPluginCode", "pkgPath null!");
            AppMethodBeat.o(134292);
            return null;
        }
        WxaPkgWrappingInfo wxaPkgWrappingInfo = new WxaPkgWrappingInfo();
        wxaPkgWrappingInfo.pkgPath = str;
        wxaPkgWrappingInfo.kNY = false;
        wxaPkgWrappingInfo.md5 = g.getMD5(str);
        AppMethodBeat.o(134292);
        return wxaPkgWrappingInfo;
    }

    public WxaPkgWrappingInfo() {
        AppMethodBeat.i(134293);
        this.kNZ = new LinkedList<>();
        this.kOb = null;
        this.name = ModulePkgInfo.MAIN_MODULE_NAME;
        this.independent = true;
        AppMethodBeat.o(134293);
    }

    public WxaPkgWrappingInfo(Parcel parcel) {
        this();
        AppMethodBeat.i(134294);
        readFromParcel(parcel);
        AppMethodBeat.o(134294);
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo
    public final boolean isAssignable(ModulePkgInfo modulePkgInfo) {
        AppMethodBeat.i(178560);
        if (!(modulePkgInfo instanceof WxaPkgWrappingInfo)) {
            boolean isAssignable = super.isAssignable(modulePkgInfo);
            AppMethodBeat.o(178560);
            return isAssignable;
        } else if (!super.isAssignable(modulePkgInfo) || this.pkgVersion != modulePkgInfo.pkgVersion) {
            AppMethodBeat.o(178560);
            return false;
        } else {
            AppMethodBeat.o(178560);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo
    public final String toString() {
        AppMethodBeat.i(134295);
        String str = "WxaPkgWrappingInfo{pkgDebugType=" + this.kNW + ", pkgVersion=" + this.pkgVersion + ", pkgCreateTime=" + this.kNX + ", localPkg=" + this.kNY + ", md5='" + this.md5 + '\'' + ", pkgPath='" + this.pkgPath + '\'' + '}';
        AppMethodBeat.o(134295);
        return str;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo
    public final int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo
    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(134296);
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.kNW);
        parcel.writeInt(this.pkgVersion);
        parcel.writeLong(this.kNX);
        parcel.writeByte(this.kNY ? (byte) 1 : 0);
        parcel.writeTypedList(this.kNZ);
        parcel.writeParcelable(this.kOb, 0);
        AppMethodBeat.o(134296);
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo
    public final void readFromParcel(Parcel parcel) {
        AppMethodBeat.i(134297);
        super.readFromParcel(parcel);
        this.kNW = parcel.readInt();
        this.pkgVersion = parcel.readInt();
        this.kNX = parcel.readLong();
        this.kNY = parcel.readByte() != 0;
        parcel.readTypedList(this.kNZ, ModulePkgInfo.CREATOR);
        this.kOb = (WxaRuntimeModulePluginListMap) parcel.readParcelable(WxaRuntimeModulePluginListMap.class.getClassLoader());
        AppMethodBeat.o(134297);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String n(com.tencent.mm.vfs.o r7) {
        /*
        // Method dump skipped, instructions count: 108
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo.n(com.tencent.mm.vfs.o):java.lang.String");
    }
}
