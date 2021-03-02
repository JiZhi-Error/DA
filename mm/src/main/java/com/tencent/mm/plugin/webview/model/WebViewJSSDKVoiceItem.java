package com.tencent.mm.plugin.webview.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoice.s;

public class WebViewJSSDKVoiceItem extends WebViewJSSDKFileItem {
    public static final Parcelable.Creator<WebViewJSSDKVoiceItem> CREATOR = new Parcelable.Creator<WebViewJSSDKVoiceItem>() {
        /* class com.tencent.mm.plugin.webview.model.WebViewJSSDKVoiceItem.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WebViewJSSDKVoiceItem[] newArray(int i2) {
            return new WebViewJSSDKVoiceItem[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WebViewJSSDKVoiceItem createFromParcel(Parcel parcel) {
            AppMethodBeat.i(79025);
            WebViewJSSDKVoiceItem webViewJSSDKVoiceItem = new WebViewJSSDKVoiceItem(parcel);
            AppMethodBeat.o(79025);
            return webViewJSSDKVoiceItem;
        }
    };

    public WebViewJSSDKVoiceItem() {
        this.mediaType = 2;
    }

    @Override // com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem
    public final WebViewJSSDKFileItem hXK() {
        AppMethodBeat.i(79026);
        this.laR = s.getFullPath(this.fileName);
        this.dJX = ay.aYY(this.laR);
        AppMethodBeat.o(79026);
        return this;
    }

    @Override // com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem
    public final String hXL() {
        return "speex";
    }

    @Override // com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem
    public final String getFileType() {
        return "voice";
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(79027);
        super.writeToParcel(parcel, i2);
        AppMethodBeat.o(79027);
    }

    protected WebViewJSSDKVoiceItem(Parcel parcel) {
        super(parcel);
    }

    static {
        AppMethodBeat.i(79028);
        AppMethodBeat.o(79028);
    }
}
