package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.ipc.e;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public enum b implements p {
    INSTANCE;

    public static b valueOf(String str) {
        AppMethodBeat.i(227195);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(227195);
        return bVar;
    }

    static {
        AppMethodBeat.i(227197);
        AppMethodBeat.o(227197);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.p
    public final h.b a(String str, Map<String, String> map, h.a aVar) {
        AppMethodBeat.i(227196);
        if (str == null || !str.equals("wxaapp_msgchannel")) {
            Log.e("MicroMsg.WxaAppMsgChannelHandler", "subType is err, return");
            AppMethodBeat.o(227196);
            return null;
        }
        Log.i("MicroMsg.WxaAppMsgChannelHandler", "consumeNewXml subType:%s", str);
        String a2 = z.a(aVar.heO.KHn);
        if (Util.isNullOrNil(a2)) {
            Log.w("MicroMsg.WxaAppMsgChannelHandler", "msg content is null");
            AppMethodBeat.o(227196);
            return null;
        } else if (map.get(".sysmsg.wxaapp_msgchannel") == null) {
            AppMethodBeat.o(227196);
            return null;
        } else {
            String str2 = map.get(".sysmsg.wxaapp_msgchannel.msg_id");
            String str3 = map.get(".sysmsg.wxaapp_msgchannel.sender_openid");
            String str4 = map.get(".sysmsg.wxaapp_msgchannel.receiver_openid");
            String str5 = map.get(".sysmsg.wxaapp_msgchannel.appid");
            int i2 = Util.getInt(map.get(".sysmsg.wxaapp_msgchannel.msg_type"), 0);
            String str6 = map.get(".sysmsg.wxaapp_msgchannel.msg_content");
            long j2 = Util.getLong(map.get(".sysmsg.wxaapp_msgchannel.send_time"), 0);
            Log.i("MicroMsg.WxaAppMsgChannelHandler", "handle addMsg.MsgId:%s", new StringBuilder().append(aVar.heO.Brn).toString());
            Log.i("MicroMsg.WxaAppMsgChannelHandler", "handle wxaapp_msgchannel xml:%s", a2);
            Log.i("MicroMsg.WxaAppMsgChannelHandler", "msgId:%s, senderOpenId:%s, receiverOpenId:%s, appId:%s, msgType:%d, msgContent:%s, sendTime:%d", str2, str3, str4, str5, Integer.valueOf(i2), str6, Long.valueOf(j2));
            WxaAppMsgChannel wxaAppMsgChannel = new WxaAppMsgChannel();
            wxaAppMsgChannel.msgId = str2;
            wxaAppMsgChannel.ngf = str3;
            wxaAppMsgChannel.ngg = str4;
            wxaAppMsgChannel.appId = str5;
            wxaAppMsgChannel.msgType = i2;
            wxaAppMsgChannel.dWG = str6;
            wxaAppMsgChannel.lhG = j2;
            e.b(str5, wxaAppMsgChannel);
            AppMethodBeat.o(227196);
            return null;
        }
    }
}
