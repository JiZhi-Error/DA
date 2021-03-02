package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.Locale;

public final class AssetReader extends AbsReader {
    public static final Parcelable.Creator<AssetReader> CREATOR = new Parcelable.Creator<AssetReader>() {
        /* class com.tencent.mm.plugin.appbrand.appcache.AssetReader.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AssetReader[] newArray(int i2) {
            return new AssetReader[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AssetReader createFromParcel(Parcel parcel) {
            AppMethodBeat.i(182223);
            AssetReader assetReader = new AssetReader(parcel);
            AppMethodBeat.o(182223);
            return assetReader;
        }
    };
    public static final AssetReader kKj = new AssetReader();
    private final WxaPkgWrappingInfo kKi;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.o
    public final InputStream openRead(String str) {
        AppMethodBeat.i(139821);
        InputStream openRead = ay.openRead(str);
        AppMethodBeat.o(139821);
        return openRead;
    }

    public AssetReader() {
        AppMethodBeat.i(139822);
        this.kKi = new WxaPkgWrappingInfo();
        this.kKi.kNY = true;
        this.kKi.kNW = 0;
        this.kKi.pkgVersion = ay.VERSION;
        this.kKi.md5 = "";
        AppMethodBeat.o(139822);
    }

    static {
        AppMethodBeat.i(139824);
        AppMethodBeat.o(139824);
    }

    public final String toString() {
        AppMethodBeat.i(139823);
        String format = String.format(Locale.ENGLISH, "AssetReader[%d][%s]", Integer.valueOf(bvd()), bvb());
        AppMethodBeat.o(139823);
        return format;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
    }

    private AssetReader(Parcel parcel) {
        this();
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.o
    public final /* bridge */ /* synthetic */ IPkgInfo bve() {
        return this.kKi;
    }
}
