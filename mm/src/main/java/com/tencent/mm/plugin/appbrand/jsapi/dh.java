package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import org.json.JSONObject;

public final class dh extends d<k> {
    public static final int CTRL_INDEX = 988;
    public static final String NAME = "jumpRedPacketEnvelopePreview";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(k kVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(261632);
        k kVar2 = kVar;
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(kVar2.getRuntime().mContext);
        if (castActivityOrNull == null) {
            kVar2.i(i2, h("fail:internal error invalid android context", null));
            AppMethodBeat.o(261632);
            return;
        }
        h.a(MainProcessIPCService.dkO, new Bundle(), a.class);
        String optString = jSONObject.optString("url");
        Log.i("MicroMsg.JsApiJumpRedPacketEnvelopePreview", "preview red packet envelope: %s", optString);
        Intent intent = new Intent();
        intent.putExtra("Chat_User", "1@fackuser");
        intent.putExtra("finish_direct", true);
        intent.putExtra("key_red_packet_preview_url", optString);
        c.f(castActivityOrNull, ".ui.chatting.ChattingUI", intent);
        kVar2.i(i2, h("ok", null));
        AppMethodBeat.o(261632);
    }

    public static class a implements k<Bundle, IPCVoid> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCVoid invoke(Bundle bundle) {
            AppMethodBeat.i(261631);
            ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).beforeJumpRedPacketPreviewUI();
            AppMethodBeat.o(261631);
            return null;
        }
    }
}
