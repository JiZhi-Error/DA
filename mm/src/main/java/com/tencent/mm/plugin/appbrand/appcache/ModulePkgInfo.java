package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class ModulePkgInfo implements Parcelable, IPkgInfo, Cloneable {
    public static final Parcelable.Creator<ModulePkgInfo> CREATOR = new Parcelable.Creator<ModulePkgInfo>() {
        /* class com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ModulePkgInfo[] newArray(int i2) {
            return new ModulePkgInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ModulePkgInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(134269);
            ModulePkgInfo modulePkgInfo = new ModulePkgInfo(parcel);
            AppMethodBeat.o(134269);
            return modulePkgInfo;
        }
    };
    public static final String GAME_PLUGIN_SCRIPT = "/plugin.js";
    public static final String MAIN_MODULE_NAME = "__APP__";
    public static final String MODULE_WITHOUT_MULTI_PLUGIN_CODE = "__WITHOUT_MULTI_PLUGINCODE__";
    public static final String MODULE_WITHOUT_PLUGIN_CODE = "__WITHOUT_PLUGINCODE__";
    public static final String PLUGINCODE_ORIGIN_PREFIX = "__plugin__/";
    public static final String PLUGINCODE_PREFIX = "/__plugin__/";
    public static final String PLUGIN_CODE = "__PLUGINCODE__";
    public String[] aliases;
    public boolean independent;
    public String md5;
    public String name;
    public volatile String pkgPath;
    public int pkgVersion;

    @Override // com.tencent.mm.plugin.appbrand.appcache.IPkgInfo
    public String pkgPath() {
        return this.pkgPath;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.IPkgInfo
    public int pkgVersion() {
        return this.pkgVersion;
    }

    public String checksumMd5() {
        return this.md5;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.IPkgInfo
    public long lastModified() {
        AppMethodBeat.i(182973);
        if (s.YS(this.pkgPath)) {
            long boX = s.boX(this.pkgPath);
            AppMethodBeat.o(182973);
            return boX;
        }
        AppMethodBeat.o(182973);
        return 0;
    }

    public boolean isAssignable(ModulePkgInfo modulePkgInfo) {
        AppMethodBeat.i(182974);
        boolean equals = this.name.equals(modulePkgInfo.name);
        AppMethodBeat.o(182974);
        return equals;
    }

    @Override // java.lang.Object
    public ModulePkgInfo clone() {
        AppMethodBeat.i(182975);
        ModulePkgInfo modulePkgInfo = new ModulePkgInfo();
        modulePkgInfo.assignFrom(this);
        AppMethodBeat.o(182975);
        return modulePkgInfo;
    }

    public void assignFrom(ModulePkgInfo modulePkgInfo) {
        AppMethodBeat.i(182976);
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        modulePkgInfo.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        readFromParcel(obtain);
        obtain.recycle();
        AppMethodBeat.o(182976);
    }

    public long getPkgSize() {
        AppMethodBeat.i(182977);
        if (!s.YS(this.pkgPath)) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException();
            AppMethodBeat.o(182977);
            throw fileNotFoundException;
        }
        o oVar = new o(this.pkgPath);
        if (!oVar.isFile() || !oVar.canRead()) {
            AppMethodBeat.o(182977);
            return 0;
        }
        long length = oVar.length();
        AppMethodBeat.o(182977);
        return length;
    }

    public String toString() {
        AppMethodBeat.i(196150);
        String str = "ModulePkgInfo{pkgPath='" + this.pkgPath + '\'' + ", name='" + this.name + '\'' + ", md5='" + this.md5 + '\'' + ", independent=" + this.independent + ", aliases=" + Arrays.toString(this.aliases) + ", pkgVersion=" + this.pkgVersion + '}';
        AppMethodBeat.o(196150);
        return str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(134270);
        parcel.writeString(this.pkgPath);
        parcel.writeString(this.name);
        parcel.writeString(this.md5);
        parcel.writeByte((byte) (this.independent ? 1 : 0));
        parcel.writeStringArray(this.aliases);
        AppMethodBeat.o(134270);
    }

    public void readFromParcel(Parcel parcel) {
        AppMethodBeat.i(134271);
        this.pkgPath = parcel.readString();
        this.name = parcel.readString();
        this.md5 = parcel.readString();
        this.independent = parcel.readByte() != 0;
        this.aliases = parcel.createStringArray();
        AppMethodBeat.o(134271);
    }

    public ModulePkgInfo() {
    }

    private ModulePkgInfo(Parcel parcel) {
        AppMethodBeat.i(134272);
        readFromParcel(parcel);
        AppMethodBeat.o(134272);
    }

    static {
        AppMethodBeat.i(134274);
        AppMethodBeat.o(134274);
    }
}
