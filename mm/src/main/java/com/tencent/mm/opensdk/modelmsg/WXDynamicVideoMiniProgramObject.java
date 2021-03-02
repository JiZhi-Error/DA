package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXDynamicVideoMiniProgramObject extends WXMiniProgramObject {
    private static final String TAG = "MicroMsg.SDK.WXDynamicVideoMiniProgramObject";
    public String appThumbUrl;
    public String videoSource;

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject, com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject
    public boolean checkArgs() {
        AppMethodBeat.i(4016);
        if (b.b(this.webpageUrl)) {
            Log.e(TAG, "webPageUrl is null");
            AppMethodBeat.o(4016);
            return false;
        } else if (b.b(this.userName)) {
            Log.e(TAG, "userName is null");
            AppMethodBeat.o(4016);
            return false;
        } else {
            int i2 = this.miniprogramType;
            if (i2 < 0 || i2 > 2) {
                Log.e(TAG, "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW");
                AppMethodBeat.o(4016);
                return false;
            }
            AppMethodBeat.o(4016);
            return true;
        }
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject, com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject
    public void serialize(Bundle bundle) {
        AppMethodBeat.i(4014);
        bundle.putString("_wxminiprogram_webpageurl", this.webpageUrl);
        bundle.putString("_wxminiprogram_username", this.userName);
        bundle.putString("_wxminiprogram_path", this.path);
        bundle.putString("_wxminiprogram_videoSource", this.videoSource);
        bundle.putString("_wxminiprogram_appThumbUrl", this.appThumbUrl);
        bundle.putBoolean("_wxminiprogram_withsharetiket", this.withShareTicket);
        bundle.putInt("_wxminiprogram_type", this.miniprogramType);
        bundle.putInt("_wxminiprogram_disableforward", this.disableforward);
        AppMethodBeat.o(4014);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject, com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject
    public int type() {
        return 46;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject, com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject
    public void unserialize(Bundle bundle) {
        AppMethodBeat.i(4015);
        this.webpageUrl = bundle.getString("_wxminiprogram_webpageurl");
        this.userName = bundle.getString("_wxminiprogram_username");
        this.path = bundle.getString("_wxminiprogram_path");
        this.videoSource = bundle.getString("_wxminiprogram_videoSource");
        this.appThumbUrl = bundle.getString("_wxminiprogram_appThumbUrl");
        this.withShareTicket = bundle.getBoolean("_wxminiprogram_withsharetiket");
        this.miniprogramType = bundle.getInt("_wxminiprogram_type");
        this.disableforward = bundle.getInt("_wxminiprogram_disableforward");
        AppMethodBeat.o(4015);
    }
}
