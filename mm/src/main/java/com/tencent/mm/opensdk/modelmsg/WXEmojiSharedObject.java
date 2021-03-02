package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;

public class WXEmojiSharedObject implements WXMediaMessage.IMediaObject {
    private static final String TAG = "MicroMsg.SDK.WXEmojiSharedObject";
    public int packageflag;
    public String packageid;
    public String thumburl;
    public String url;

    public WXEmojiSharedObject() {
    }

    public WXEmojiSharedObject(String str, int i2, String str2, String str3) {
        AppMethodBeat.i(190392);
        this.thumburl = str;
        this.packageflag = i2;
        this.packageid = str2;
        this.url = str3;
        AppMethodBeat.o(190392);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        AppMethodBeat.i(3996);
        if (TextUtils.isEmpty(this.packageid) || TextUtils.isEmpty(this.thumburl) || TextUtils.isEmpty(this.url) || this.packageflag == -1) {
            Log.e(TAG, "checkArgs fail, packageid or thumburl is invalid");
            AppMethodBeat.o(3996);
            return false;
        }
        AppMethodBeat.o(3996);
        return true;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        AppMethodBeat.i(3994);
        bundle.putString("_wxemojisharedobject_thumburl", this.thumburl);
        bundle.putInt("_wxemojisharedobject_packageflag", this.packageflag);
        bundle.putString("_wxemojisharedobject_packageid", this.packageid);
        bundle.putString("_wxemojisharedobject_url", this.url);
        AppMethodBeat.o(3994);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 15;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        AppMethodBeat.i(3995);
        this.thumburl = bundle.getString("_wxwebpageobject_thumburl");
        this.packageflag = bundle.getInt("_wxwebpageobject_packageflag");
        this.packageid = bundle.getString("_wxwebpageobject_packageid");
        this.url = bundle.getString("_wxwebpageobject_url");
        AppMethodBeat.o(3995);
    }
}
