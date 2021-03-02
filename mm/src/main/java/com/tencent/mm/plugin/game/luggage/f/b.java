package com.tencent.mm.plugin.game.luggage.f;

import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;

public final class b extends WXWebpageObject {
    public String desc;
    public String iconUrl;
    public String jumpUrl;
    public String nickName;
    public String xxN;

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject, com.tencent.mm.opensdk.modelmsg.WXWebpageObject
    public final int type() {
        return 69;
    }
}
