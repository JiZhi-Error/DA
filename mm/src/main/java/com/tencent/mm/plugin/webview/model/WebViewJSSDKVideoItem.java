package com.tencent.mm.plugin.webview.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import org.json.JSONException;
import org.json.JSONObject;

public class WebViewJSSDKVideoItem extends WebViewJSSDKFileItem implements Parcelable {
    public static final Parcelable.Creator<WebViewJSSDKVideoItem> CREATOR = new Parcelable.Creator<WebViewJSSDKVideoItem>() {
        /* class com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WebViewJSSDKVideoItem[] newArray(int i2) {
            return new WebViewJSSDKVideoItem[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WebViewJSSDKVideoItem createFromParcel(Parcel parcel) {
            AppMethodBeat.i(79020);
            WebViewJSSDKVideoItem webViewJSSDKVideoItem = new WebViewJSSDKVideoItem(parcel);
            AppMethodBeat.o(79020);
            return webViewJSSDKVideoItem;
        }
    };
    public int duration;

    public WebViewJSSDKVideoItem() {
        this.mediaType = 4;
    }

    @Override // com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem
    public final WebViewJSSDKFileItem hXK() {
        AppMethodBeat.i(79021);
        this.dJX = ay.aYY(this.laR);
        AppMethodBeat.o(79021);
        return this;
    }

    @Override // com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem
    public final void cb(JSONObject jSONObject) {
        AppMethodBeat.i(182697);
        super.cb(jSONObject);
        if (jSONObject != null) {
            this.duration = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
        }
        AppMethodBeat.o(182697);
    }

    @Override // com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem
    public final JSONObject hXJ() {
        AppMethodBeat.i(182698);
        JSONObject hXJ = super.hXJ();
        try {
            hXJ.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, this.duration);
        } catch (JSONException e2) {
        }
        AppMethodBeat.o(182698);
        return hXJ;
    }

    @Override // com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem
    public final String hXL() {
        return "mp4";
    }

    @Override // com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem
    public final String getFileType() {
        return "video";
    }

    protected WebViewJSSDKVideoItem(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(79022);
        this.duration = parcel.readInt();
        AppMethodBeat.o(79022);
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(79023);
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.duration);
        AppMethodBeat.o(79023);
    }

    static {
        AppMethodBeat.i(79024);
        AppMethodBeat.o(79024);
    }
}
