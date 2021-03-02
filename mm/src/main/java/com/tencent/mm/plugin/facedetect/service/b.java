package com.tencent.mm.plugin.facedetect.service;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.facedetect.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class b extends a {
    String mAppId = "";
    long sQI = -1;

    @Override // com.tencent.mm.plugin.facedetect.service.a
    public final void aj(Intent intent) {
        AppMethodBeat.i(103871);
        this.sQI = intent.getLongExtra("k_bio_id", -1);
        this.mAppId = intent.getStringExtra("key_app_id");
        Log.i("MicroMsg.FaceDetectServiceControllerMp", "hy: got bioid: %d, appid: %s", Long.valueOf(this.sQI), this.mAppId);
        Log.i("MicroMsg.FaceDetectServiceControllerMp", "hy: requesting release and send video");
        if (!a.cTF().sUx || !(a.cTF().cTI() == a.EnumC1037a.STARTED || a.cTF().cTI() == a.EnumC1037a.STOPPING || a.cTF().cTI() == a.EnumC1037a.STOPPED)) {
            Log.i("MicroMsg.FaceDetectServiceControllerMp", "hy: not recording video");
            AppMethodBeat.o(103871);
            return;
        }
        final long currentTicks = Util.currentTicks();
        a.cTF().a(new a.b() {
            /* class com.tencent.mm.plugin.facedetect.service.b.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.facedetect.e.a.b
            public final void arD(String str) {
                AppMethodBeat.i(103870);
                Log.i("MicroMsg.FaceDetectServiceControllerMp", "hy: video release done. using: %d ms. file path: %s", Long.valueOf(Util.ticksToNow(currentTicks)), str);
                if (Util.isNullOrNil(str)) {
                    AppMethodBeat.o(103870);
                    return;
                }
                Intent intent = new Intent(MMApplicationContext.getContext(), FaceUploadVideoService.class);
                intent.putExtra("key_video_file_name", str);
                intent.putExtra("k_bio_id", b.this.sQI);
                intent.putExtra("key_app_id", b.this.mAppId);
                c.startService(intent);
                AppMethodBeat.o(103870);
            }
        });
        AppMethodBeat.o(103871);
    }
}
