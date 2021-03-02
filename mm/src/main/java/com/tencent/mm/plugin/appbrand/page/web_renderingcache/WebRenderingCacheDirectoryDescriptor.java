package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WebRenderingCacheDirectoryDescriptor implements Parcelable {
    public static final Parcelable.Creator<WebRenderingCacheDirectoryDescriptor> CREATOR = new Parcelable.Creator<WebRenderingCacheDirectoryDescriptor>() {
        /* class com.tencent.mm.plugin.appbrand.page.web_renderingcache.WebRenderingCacheDirectoryDescriptor.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WebRenderingCacheDirectoryDescriptor[] newArray(int i2) {
            return new WebRenderingCacheDirectoryDescriptor[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WebRenderingCacheDirectoryDescriptor createFromParcel(Parcel parcel) {
            AppMethodBeat.i(47974);
            WebRenderingCacheDirectoryDescriptor webRenderingCacheDirectoryDescriptor = new WebRenderingCacheDirectoryDescriptor(parcel);
            AppMethodBeat.o(47974);
            return webRenderingCacheDirectoryDescriptor;
        }
    };
    public String nwn;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(47975);
        parcel.writeString(this.nwn);
        AppMethodBeat.o(47975);
    }

    public WebRenderingCacheDirectoryDescriptor() {
    }

    protected WebRenderingCacheDirectoryDescriptor(Parcel parcel) {
        AppMethodBeat.i(47976);
        this.nwn = parcel.readString();
        AppMethodBeat.o(47976);
    }

    static {
        AppMethodBeat.i(47977);
        AppMethodBeat.o(47977);
    }
}
