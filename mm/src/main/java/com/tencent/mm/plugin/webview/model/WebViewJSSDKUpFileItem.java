package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;

public class WebViewJSSDKUpFileItem extends WebViewJSSDKFileItem {
    public static final Parcelable.Creator<WebViewJSSDKUpFileItem> CREATOR = new Parcelable.Creator<WebViewJSSDKUpFileItem>() {
        /* class com.tencent.mm.plugin.webview.model.WebViewJSSDKUpFileItem.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WebViewJSSDKUpFileItem[] newArray(int i2) {
            return new WebViewJSSDKUpFileItem[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WebViewJSSDKUpFileItem createFromParcel(Parcel parcel) {
            AppMethodBeat.i(79016);
            WebViewJSSDKUpFileItem webViewJSSDKUpFileItem = new WebViewJSSDKUpFileItem((char) 0);
            AppMethodBeat.o(79016);
            return webViewJSSDKUpFileItem;
        }
    };
    public String ISo;
    public int fileType;

    /* synthetic */ WebViewJSSDKUpFileItem(char c2) {
        this((byte) 0);
    }

    public WebViewJSSDKUpFileItem() {
        this.fileType = -1;
        this.mediaType = 3;
    }

    @Override // com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem
    public final WebViewJSSDKFileItem hXK() {
        AppMethodBeat.i(79017);
        this.dJX = ay.aYY(this.laR);
        AppMethodBeat.o(79017);
        return this;
    }

    @Override // com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem
    public final void d(d dVar) {
        AppMethodBeat.i(79018);
        super.d(dVar);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new StringBuilder().append(this.fileType).toString());
        arrayList.add(this.ISo);
        arrayList.add(dVar.field_fileId);
        arrayList.add(dVar.field_aesKey);
        arrayList.add(new StringBuilder().append(dVar.field_fileLength).toString());
        Context context = MMApplicationContext.getContext();
        if (NetStatusUtil.isWifi(context)) {
            arrayList.add("1");
        } else if (NetStatusUtil.is3G(context)) {
            arrayList.add("4");
        } else if (NetStatusUtil.is4G(context)) {
            arrayList.add("5");
        } else if (NetStatusUtil.is5G(context)) {
            arrayList.add("6");
        } else if (NetStatusUtil.is2G(context)) {
            arrayList.add(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        } else if (NetStatusUtil.isWap(context)) {
            arrayList.add("2");
        } else {
            arrayList.add(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        Log.d("MicroMsg.WebViewJSSDKVoiceItem", "fileType=%d, initUrl=%s, field_fileId=%s", Integer.valueOf(this.fileType), this.ISo, dVar.field_fileId);
        h hVar = h.INSTANCE;
        h.r(12018, arrayList);
        String str = this.laR;
        if (!Util.isNullOrNil(str)) {
            o oVar = new o(str);
            if (oVar.exists()) {
                oVar.delete();
            }
        }
        AppMethodBeat.o(79018);
    }

    @Override // com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem
    public final String hXL() {
        return "file";
    }

    @Override // com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem
    public final String getFileType() {
        return "nomal";
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem
    public void writeToParcel(Parcel parcel, int i2) {
    }

    private WebViewJSSDKUpFileItem(byte b2) {
        this.fileType = -1;
    }

    static {
        AppMethodBeat.i(79019);
        AppMethodBeat.o(79019);
    }
}
