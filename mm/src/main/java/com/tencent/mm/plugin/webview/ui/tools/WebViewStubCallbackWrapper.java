package com.tencent.mm.plugin.webview.ui.tools;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.f;

public class WebViewStubCallbackWrapper implements Parcelable {
    public static final Parcelable.Creator<WebViewStubCallbackWrapper> CREATOR = new Parcelable.Creator<WebViewStubCallbackWrapper>() {
        /* class com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WebViewStubCallbackWrapper[] newArray(int i2) {
            return new WebViewStubCallbackWrapper[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WebViewStubCallbackWrapper createFromParcel(Parcel parcel) {
            AppMethodBeat.i(80035);
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                WebViewStubCallbackWrapper webViewStubCallbackWrapper = new WebViewStubCallbackWrapper(readStrongBinder, (byte) 0);
                AppMethodBeat.o(80035);
                return webViewStubCallbackWrapper;
            }
            AppMethodBeat.o(80035);
            return null;
        }
    };
    public f JhP;
    public int id;

    /* synthetic */ WebViewStubCallbackWrapper(IBinder iBinder, byte b2) {
        this(iBinder);
    }

    public WebViewStubCallbackWrapper(f fVar, int i2) {
        this.JhP = fVar;
        this.id = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(80036);
        parcel.writeStrongBinder(this.JhP.asBinder());
        AppMethodBeat.o(80036);
    }

    private WebViewStubCallbackWrapper(IBinder iBinder) {
        AppMethodBeat.i(80037);
        this.JhP = f.a.I(iBinder);
        AppMethodBeat.o(80037);
    }

    static {
        AppMethodBeat.i(80038);
        AppMethodBeat.o(80038);
    }

    public boolean equals(Object obj) {
        if ((obj instanceof WebViewStubCallbackWrapper) && ((WebViewStubCallbackWrapper) obj).id == this.id) {
            return true;
        }
        return false;
    }
}
