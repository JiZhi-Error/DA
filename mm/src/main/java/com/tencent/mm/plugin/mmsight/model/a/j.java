package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

@TargetApi(18)
@Deprecated
public final class j extends p {
    public j(String str) {
        super(str);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.p
    public final synchronized void f(MediaFormat mediaFormat) {
        AppMethodBeat.i(241183);
        try {
            if (this.mediaMuxer != null && this.zww == -1) {
                this.zww = this.mediaMuxer.addTrack(mediaFormat);
                Log.i("MicroMsg.MMSightAACSystemMediaMuxer", "addAACTrack, aacTrackIndex: %s", Integer.valueOf(this.zww));
                if (!this.isStart && this.zww != -1) {
                    Log.i("MicroMsg.MMSightAACSystemMediaMuxer", "start!");
                    this.mediaMuxer.start();
                    this.isStart = true;
                }
            }
            AppMethodBeat.o(241183);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMSightAACSystemMediaMuxer", "addAACTrack error: %s", e2.getMessage());
            AppMethodBeat.o(241183);
        }
    }
}
