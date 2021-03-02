package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d extends a {
    private String appId;
    private boolean isRetry = false;
    private String jsonString;
    private String sQu;
    private float sQv;
    private boolean sQw;

    d(Context context, f fVar, int i2, Bundle bundle) {
        super(context, fVar, i2, 0);
        AppMethodBeat.i(186363);
        this.sQq = true;
        this.appId = bundle.getString("appId", null);
        this.jsonString = bundle.getString("request_verify_pre_info", null);
        this.sQu = bundle.getString("feedbackUrl", null);
        this.sQv = bundle.getFloat("key_current_light", 0.0f);
        this.sQw = bundle.getBoolean("key_upload_video", false);
        AppMethodBeat.o(186363);
    }
}
