package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;

public class WXVideoObject implements WXMediaMessage.IMediaObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXVideoObject";
    public String videoLowBandUrl;
    public String videoUrl;

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str;
        AppMethodBeat.i(3969);
        String str2 = this.videoUrl;
        if ((str2 == null || str2.length() == 0) && ((str = this.videoLowBandUrl) == null || str.length() == 0)) {
            Log.e(TAG, "both arguments are null");
            AppMethodBeat.o(3969);
            return false;
        }
        String str3 = this.videoUrl;
        if (str3 == null || str3.length() <= 10240) {
            String str4 = this.videoLowBandUrl;
            if (str4 == null || str4.length() <= 10240) {
                AppMethodBeat.o(3969);
                return true;
            }
            Log.e(TAG, "checkArgs fail, videoLowBandUrl is too long");
            AppMethodBeat.o(3969);
            return false;
        }
        Log.e(TAG, "checkArgs fail, videoUrl is too long");
        AppMethodBeat.o(3969);
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        AppMethodBeat.i(3967);
        bundle.putString("_wxvideoobject_videoUrl", this.videoUrl);
        bundle.putString("_wxvideoobject_videoLowBandUrl", this.videoLowBandUrl);
        AppMethodBeat.o(3967);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 4;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        AppMethodBeat.i(3968);
        this.videoUrl = bundle.getString("_wxvideoobject_videoUrl");
        this.videoLowBandUrl = bundle.getString("_wxvideoobject_videoLowBandUrl");
        AppMethodBeat.o(3968);
    }
}
