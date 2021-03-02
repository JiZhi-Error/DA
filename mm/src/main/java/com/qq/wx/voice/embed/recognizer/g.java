package com.qq.wx.voice.embed.recognizer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;

/* access modifiers changed from: package-private */
public final class g {

    /* renamed from: b  reason: collision with root package name */
    Handler f122b = new h(this);
    c cgu;

    public g() {
        AppMethodBeat.i(76770);
        AppMethodBeat.o(76770);
    }

    public final void a(int i2) {
        AppMethodBeat.i(76771);
        Message obtainMessage = this.f122b.obtainMessage(100);
        Bundle bundle = new Bundle();
        bundle.putInt(OpenSDKTool4Assistant.EXTRA_ERROR_CODE, i2);
        obtainMessage.setData(bundle);
        this.f122b.sendMessage(obtainMessage);
        AppMethodBeat.o(76771);
    }
}
