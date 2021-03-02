package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.TXLiveConstants;

public final class i extends OrientationEventListener {
    a Gnj;
    private int lastOrientation = -1;
    private int orientation = -1;
    private int ztE = -1;
    private long ztF = 0;
    private long ztG = 0;

    public interface a {
        void onOrientationChange(int i2);
    }

    public i(Context context) {
        super(context);
    }

    public final void onOrientationChanged(int i2) {
        AppMethodBeat.i(126095);
        if (Util.ticksToNow(this.ztG) < 2000) {
            Log.v("MicroMsg.TopStory.TopStoryDeviceOrientationListener", "onOrientationChanged, not reach DETECT_THRESHOLD");
            AppMethodBeat.o(126095);
            return;
        }
        Log.d("MicroMsg.TopStory.TopStoryDeviceOrientationListener", "onOrientationChanged: %s", Integer.valueOf(i2));
        if (Math.abs(this.ztE - i2) >= 60 && Util.ticksToNow(this.ztF) >= 1000) {
            this.ztE = i2;
            this.ztF = Util.currentTicks();
            if (i2 <= 60 || i2 >= 300) {
                if (i2 <= 30 || i2 >= 330) {
                    this.orientation = 0;
                }
            } else if (i2 < 30 || i2 > 150) {
                if (i2 < 120 || i2 > 240) {
                    if (i2 >= 210 && i2 <= 330 && i2 >= 240 && i2 <= 300) {
                        this.orientation = 270;
                    }
                } else if (i2 >= 150 && i2 <= 210) {
                    this.orientation = TXLiveConstants.RENDER_ROTATION_180;
                }
            } else if (i2 >= 60 && i2 <= 120) {
                this.orientation = 90;
            }
            if (this.Gnj != null) {
                this.Gnj.onOrientationChange(this.orientation);
            }
        }
        AppMethodBeat.o(126095);
    }

    public final void enable() {
        AppMethodBeat.i(126096);
        super.enable();
        this.ztG = Util.currentTicks();
        AppMethodBeat.o(126096);
    }
}
