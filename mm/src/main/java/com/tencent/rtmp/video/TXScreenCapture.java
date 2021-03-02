package com.tencent.rtmp.video;

import android.annotation.TargetApi;
import android.content.Intent;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.screencapture.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;

public class TXScreenCapture {

    @TargetApi(21)
    public static class TXScreenCaptureAssistantActivity extends HellActivity {
        private static final int REQUEST_CODE = 100;
        private static final String TAG = "TXScreenCaptureAssistantActivity";
        private MediaProjectionManager mMediaProjectionManager;

        @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            AppMethodBeat.at(this, z);
        }

        @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
        public void onCreate(Bundle bundle) {
            AppMethodBeat.i(13941);
            super.onCreate(bundle);
            TXCLog.i(TAG, "onCreate ".concat(String.valueOf(this)));
            requestWindowFeature(1);
            this.mMediaProjectionManager = (MediaProjectionManager) getApplicationContext().getSystemService("media_projection");
            try {
                startActivityForResult(this.mMediaProjectionManager.createScreenCaptureIntent(), 100);
                AppMethodBeat.o(13941);
            } catch (Exception e2) {
                TXCLog.e(TAG, "start permission activity failed. ".concat(String.valueOf(e2)));
                c.a(this).a((MediaProjection) null);
                finish();
                AppMethodBeat.o(13941);
            }
        }

        public void onActivityResult(int i2, int i3, Intent intent) {
            AppMethodBeat.i(13943);
            TXCLog.i(TAG, "onActivityResult ".concat(String.valueOf(this)));
            c.a(this).a(this.mMediaProjectionManager.getMediaProjection(i3, intent));
            finish();
            AppMethodBeat.o(13943);
        }

        @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
        public void onDestroy() {
            AppMethodBeat.i(222656);
            super.onDestroy();
            TXCLog.i(TAG, "onDestroy ".concat(String.valueOf(this)));
            AppMethodBeat.o(222656);
        }
    }
}
