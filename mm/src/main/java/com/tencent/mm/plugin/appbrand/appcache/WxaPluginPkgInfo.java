package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;
import java.util.List;

public class WxaPluginPkgInfo implements Parcelable, IPkgInfo {
    public static final Parcelable.Creator<WxaPluginPkgInfo> CREATOR = new Parcelable.Creator<WxaPluginPkgInfo>() {
        /* class com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WxaPluginPkgInfo[] newArray(int i2) {
            return new WxaPluginPkgInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WxaPluginPkgInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(178561);
            WxaPluginPkgInfo wxaPluginPkgInfo = new WxaPluginPkgInfo(parcel);
            AppMethodBeat.o(178561);
            return wxaPluginPkgInfo;
        }
    };
    public static final String PREFIX_EXTENDED = "__extended__/";
    public static final String PREFIX_NORMAL = "__plugin__/";
    public List<Integer> contexts;
    public String md5;
    public volatile String pkgPath;
    public String prefixPath;
    public String provider;
    public String stringVersion;
    public int version;

    @Override // com.tencent.mm.plugin.appbrand.appcache.IPkgInfo
    public String pkgPath() {
        return this.pkgPath;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.IPkgInfo
    public int pkgVersion() {
        return this.version;
    }

    public String checksumMd5() {
        return this.md5;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.IPkgInfo
    public long lastModified() {
        AppMethodBeat.i(178562);
        if (s.YS(this.pkgPath)) {
            long boX = s.boX(this.pkgPath);
            AppMethodBeat.o(178562);
            return boX;
        }
        AppMethodBeat.o(178562);
        return 0;
    }

    public WxaPluginPkgInfo() {
    }

    public boolean isAssignable(WxaPluginPkgInfo wxaPluginPkgInfo) {
        AppMethodBeat.i(178563);
        boolean equals = this.provider.equals(wxaPluginPkgInfo.provider);
        AppMethodBeat.o(178563);
        return equals;
    }

    @Override // java.lang.Object
    public WxaPluginPkgInfo clone() {
        AppMethodBeat.i(178564);
        WxaPluginPkgInfo wxaPluginPkgInfo = new WxaPluginPkgInfo();
        wxaPluginPkgInfo.assignFrom(this);
        AppMethodBeat.o(178564);
        return wxaPluginPkgInfo;
    }

    public void assignFrom(WxaPluginPkgInfo wxaPluginPkgInfo) {
        AppMethodBeat.i(178565);
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        wxaPluginPkgInfo.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        readFromParcel(obtain);
        obtain.recycle();
        AppMethodBeat.o(178565);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(178566);
        parcel.writeString(this.pkgPath);
        parcel.writeString(this.provider);
        parcel.writeInt(this.version);
        parcel.writeString(this.md5);
        parcel.writeString(this.prefixPath);
        parcel.writeString(this.stringVersion);
        parcel.writeList(this.contexts);
        AppMethodBeat.o(178566);
    }

    public void readFromParcel(Parcel parcel) {
        AppMethodBeat.i(178567);
        this.pkgPath = parcel.readString();
        this.provider = parcel.readString();
        this.version = parcel.readInt();
        this.md5 = parcel.readString();
        this.prefixPath = parcel.readString();
        this.stringVersion = parcel.readString();
        if (this.contexts == null) {
            this.contexts = new LinkedList();
        }
        parcel.readList(this.contexts, Integer.class.getClassLoader());
        AppMethodBeat.o(178567);
    }

    private WxaPluginPkgInfo(Parcel parcel) {
        AppMethodBeat.i(178568);
        readFromParcel(parcel);
        AppMethodBeat.o(178568);
    }

    static {
        AppMethodBeat.i(178570);
        AppMethodBeat.o(178570);
    }
}
