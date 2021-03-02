package com.qq.wx.voice.embed.recognizer;

import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;

/* access modifiers changed from: package-private */
public final class h extends Handler {
    private /* synthetic */ g cgt;

    h(g gVar) {
        this.cgt = gVar;
    }

    public final void handleMessage(Message message) {
        AppMethodBeat.i(76769);
        switch (message.what) {
            case 100:
                this.cgt.cgu.onGetError(message.getData().getInt(OpenSDKTool4Assistant.EXTRA_ERROR_CODE));
                AppMethodBeat.o(76769);
                return;
            case 200:
                this.cgt.cgu.a((a) message.obj);
                break;
        }
        AppMethodBeat.o(76769);
    }
}
