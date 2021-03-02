package com.tencent.mm.plugin.mmsight.model;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.TXLiveConstants;

public final class d extends OrientationEventListener {
    private int lastOrientation = -1;
    private int orientation = -1;
    private int ztE = -1;
    private long ztF = 0;
    private long ztG = 0;
    public a ztH;

    public interface a {
        void onOrientationChange(int i2);
    }

    public d(Context context) {
        super(context);
    }

    public d(Context context, byte b2) {
        super(context, 2);
    }

    public final void a(a aVar) {
        this.ztH = aVar;
    }

    public final void onOrientationChanged(int i2) {
        AppMethodBeat.i(89356);
        if (!k.zuv) {
            AppMethodBeat.o(89356);
        } else if (Util.ticksToNow(this.ztG) < 2000) {
            Log.v("MicroMsg.DeviceOrientationListener", "onOrientationChanged, not reach DETECT_THRESHOLD");
            AppMethodBeat.o(89356);
        } else if (i2 < 0 || i2 > 360) {
            Log.d("MicroMsg.DeviceOrientationListener", "orientation out of range, ignore");
            AppMethodBeat.o(89356);
        } else {
            if (Math.abs(this.ztE - i2) >= 30 || Util.ticksToNow(this.ztF) >= 300) {
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
                if (this.ztH != null) {
                    this.ztH.onOrientationChange(this.orientation);
                }
            }
            AppMethodBeat.o(89356);
        }
    }

    public final void enable() {
        AppMethodBeat.i(89357);
        Log.i("MicroMsg.DeviceOrientationListener", "enable, config isEnableLandscapeMode: %s", Boolean.valueOf(k.zuv));
        if (k.zuv) {
            super.enable();
            this.ztG = Util.currentTicks();
        }
        AppMethodBeat.o(89357);
    }

    public final int getOrientation() {
        if (!k.zuv) {
            return 0;
        }
        return this.orientation;
    }

    public final int ejw() {
        int i2;
        AppMethodBeat.i(89358);
        int orientation2 = getOrientation();
        if (orientation2 <= 60 || orientation2 >= 300) {
            i2 = 0;
        } else if (orientation2 <= 120) {
            i2 = 90;
        } else if (orientation2 <= 210) {
            i2 = TXLiveConstants.RENDER_ROTATION_180;
        } else {
            i2 = 270;
        }
        AppMethodBeat.o(89358);
        return i2;
    }

    public final boolean isLandscape() {
        AppMethodBeat.i(89359);
        if (!k.zuv) {
            AppMethodBeat.o(89359);
            return false;
        }
        long ticksToNow = Util.ticksToNow(this.ztG);
        Log.i("MicroMsg.DeviceOrientationListener", "isLandscape, tickToNow: %s, orientation: %s", Long.valueOf(ticksToNow), Integer.valueOf(this.orientation));
        if (ticksToNow < 2000) {
            AppMethodBeat.o(89359);
            return false;
        } else if (this.orientation < 0) {
            AppMethodBeat.o(89359);
            return false;
        } else if (this.orientation == 90 || this.orientation == 270) {
            AppMethodBeat.o(89359);
            return true;
        } else {
            AppMethodBeat.o(89359);
            return false;
        }
    }

    public final void reset() {
        AppMethodBeat.i(89360);
        Log.i("MicroMsg.DeviceOrientationListener", "reset");
        this.lastOrientation = -1;
        this.orientation = -1;
        this.ztE = -1;
        AppMethodBeat.o(89360);
    }
}
