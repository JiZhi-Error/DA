package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;

public class WXWebpageObject implements WXMediaMessage.IMediaObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXWebpageObject";
    public String canvasPageXml;
    public String extInfo;
    public String webpageUrl;

    public WXWebpageObject() {
    }

    public WXWebpageObject(String str) {
        AppMethodBeat.i(190403);
        this.webpageUrl = str;
        AppMethodBeat.o(190403);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        AppMethodBeat.i(4023);
        String str = this.webpageUrl;
        if (str == null || str.length() == 0 || this.webpageUrl.length() > 10240) {
            Log.e(TAG, "checkArgs fail, webpageUrl is invalid");
            AppMethodBeat.o(4023);
            return false;
        }
        AppMethodBeat.o(4023);
        return true;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        AppMethodBeat.i(4021);
        bundle.putString("_wxwebpageobject_extInfo", this.extInfo);
        bundle.putString("_wxwebpageobject_webpageUrl", this.webpageUrl);
        bundle.putString("_wxwebpageobject_canvaspagexml", this.canvasPageXml);
        AppMethodBeat.o(4021);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 5;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        AppMethodBeat.i(4022);
        this.extInfo = bundle.getString("_wxwebpageobject_extInfo");
        this.webpageUrl = bundle.getString("_wxwebpageobject_webpageUrl");
        this.canvasPageXml = bundle.getString("_wxwebpageobject_canvaspagexml");
        AppMethodBeat.o(4022);
    }
}
