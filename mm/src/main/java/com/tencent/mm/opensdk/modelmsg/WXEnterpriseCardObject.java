package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;

public class WXEnterpriseCardObject implements WXMediaMessage.IMediaObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXEnterpriseCardObject";
    public String cardInfo;
    public int msgType;

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        AppMethodBeat.i(3999);
        String str = this.cardInfo;
        if (str == null || str.length() == 0) {
            Log.e(TAG, "checkArgs fail, cardInfo is invalid");
            AppMethodBeat.o(3999);
            return false;
        }
        AppMethodBeat.o(3999);
        return true;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        AppMethodBeat.i(3997);
        bundle.putInt("_wxenterprisecard_msgtype", this.msgType);
        bundle.putString("_wxenterprisecard_cardinfo", this.cardInfo);
        AppMethodBeat.o(3997);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 45;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        AppMethodBeat.i(3998);
        this.msgType = bundle.getInt("_wxenterprisecard_msgtype");
        this.cardInfo = bundle.getString("_wxenterprisecard_cardinfo");
        AppMethodBeat.o(3998);
    }
}
