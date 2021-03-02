package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

public class WXWeWorkObject implements WXMediaMessage.IMediaObject {
    public static final int SUB_TYPE_MSG_RECORD = 1;
    private static final String TAG = "MicroMsg.SDK.WXWeWorkObject";
    public byte[] data;
    public String extInfo;
    public int subType;

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        return true;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        AppMethodBeat.i(3944);
        bundle.putByteArray("_wxenterprise_object_data", this.data);
        bundle.putString("_wxenterprise_object_extinfo", this.extInfo);
        bundle.putInt("_wxenterprise_object_subType", this.subType);
        AppMethodBeat.o(3944);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 49;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        AppMethodBeat.i(3945);
        this.data = bundle.getByteArray("_wxenterprise_object_data");
        this.extInfo = bundle.getString("_wxenterprise_object_extinfo");
        this.subType = bundle.getInt("_wxenterprise_object_subType");
        AppMethodBeat.o(3945);
    }
}
