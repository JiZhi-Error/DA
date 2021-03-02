package com.tencent.mm.plugin.webview.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import org.json.JSONException;
import org.json.JSONObject;

public class WebViewJSSDKImageItem extends WebViewJSSDKFileItem implements Parcelable {
    public static final Parcelable.Creator<WebViewJSSDKImageItem> CREATOR = new Parcelable.Creator<WebViewJSSDKImageItem>() {
        /* class com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WebViewJSSDKImageItem[] newArray(int i2) {
            return new WebViewJSSDKImageItem[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WebViewJSSDKImageItem createFromParcel(Parcel parcel) {
            AppMethodBeat.i(79010);
            WebViewJSSDKImageItem webViewJSSDKImageItem = new WebViewJSSDKImageItem(parcel);
            AppMethodBeat.o(79010);
            return webViewJSSDKImageItem;
        }
    };
    public boolean xlR;

    public WebViewJSSDKImageItem() {
        this.mediaType = 1;
    }

    public final void hXM() {
        AppMethodBeat.i(79011);
        if (!new o(this.laR).exists()) {
            Log.i("MicroMsg.WebViewJSSDkImageItem", "Original file not existed");
            AppMethodBeat.o(79011);
            return;
        }
        if (this.lPx == null) {
            this.lPx = ay.aYW(new StringBuilder().append(System.currentTimeMillis()).toString());
        } else if (this.lPx.equals(this.laR)) {
            Log.i("MicroMsg.WebViewJSSDkImageItem", "Thumb file is original file");
            AppMethodBeat.o(79011);
            return;
        }
        Bitmap extractThumbNail = BitmapUtil.extractThumbNail(this.laR, 640, 640, false);
        if (extractThumbNail != null) {
            Log.i("MicroMsg.WebViewJSSDkImageItem", "extract thumbnail bitmap");
            Bitmap rotate = BitmapUtil.rotate(extractThumbNail, (float) BackwardSupportUtil.ExifHelper.getExifOrientation(this.laR));
            if (rotate != null) {
                try {
                    BitmapUtil.saveBitmapToImage(rotate, 100, Bitmap.CompressFormat.JPEG, this.lPx, true);
                } catch (Exception e2) {
                    Log.e("MicroMsg.WebViewJSSDkImageItem", "save bitmap to file failed : %s", e2.getMessage());
                }
            }
        }
        Log.i("MicroMsg.WebViewJSSDkImageItem", "Thumb Path: %s", this.lPx);
        AppMethodBeat.o(79011);
    }

    @Override // com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem
    public final WebViewJSSDKFileItem hXK() {
        AppMethodBeat.i(79012);
        this.dJX = ay.aYY(this.laR);
        hXM();
        AppMethodBeat.o(79012);
        return this;
    }

    @Override // com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem
    public final String hXL() {
        return "jpeg";
    }

    @Override // com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem
    public final void cb(JSONObject jSONObject) {
        AppMethodBeat.i(182695);
        super.cb(jSONObject);
        if (jSONObject != null) {
            this.xlR = jSONObject.optBoolean("isGif");
        }
        AppMethodBeat.o(182695);
    }

    @Override // com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem
    public final JSONObject hXJ() {
        AppMethodBeat.i(182696);
        JSONObject hXJ = super.hXJ();
        try {
            hXJ.put("isGif", this.xlR);
        } catch (JSONException e2) {
        }
        AppMethodBeat.o(182696);
        return hXJ;
    }

    @Override // com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem
    public final String getFileType() {
        return "image";
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(79013);
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.xlR ? 1 : 0);
        AppMethodBeat.o(79013);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected WebViewJSSDKImageItem(Parcel parcel) {
        super(parcel);
        boolean z = true;
        AppMethodBeat.i(79014);
        this.xlR = parcel.readInt() != 1 ? false : z;
        AppMethodBeat.o(79014);
    }

    static {
        AppMethodBeat.i(79015);
        AppMethodBeat.o(79015);
    }
}
