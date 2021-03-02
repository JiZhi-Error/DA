package com.tencent.mm.plugin.game.media.background;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;

public class GameFakeVideoView extends VideoPlayerTextureView {
    public GameFakeVideoView(Context context) {
        super(context);
    }

    public GameFakeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GameFakeVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView
    public final void l(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(41208);
        super.l(surfaceTexture);
        if (this.rso != null) {
            this.rso.fh(getCurrentPosition(), getDuration());
        }
        AppMethodBeat.o(41208);
    }

    public void setKeepScreenOn(boolean z) {
        AppMethodBeat.i(41209);
        super.setKeepScreenOn(z);
        AppMethodBeat.o(41209);
    }
}
