package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e;
import com.tencent.mm.sdk.platformtools.Log;

public final class b {
    protected int mEX;
    protected int mEY;
    protected int mEZ;
    public boolean mEe;
    protected int mFa;
    e.h mwG = e.h.DEFAULT;
    protected int videoHeight;
    protected int videoWidth;

    public final void reset() {
        this.mEY = 0;
        this.mEX = 0;
        this.videoHeight = 0;
        this.videoWidth = 0;
        this.mFa = 0;
        this.mEZ = 0;
    }

    public final boolean y(int i2, int i3, int i4, int i5) {
        b bVar;
        AppMethodBeat.i(235189);
        if (this.mEX == i2 && this.mEY == i3 && this.videoWidth == i4 && this.videoHeight == i5) {
            AppMethodBeat.o(235189);
            return true;
        }
        this.mEX = i2;
        this.mEY = i3;
        this.videoWidth = i4;
        this.videoHeight = i5;
        float f2 = (((float) this.videoWidth) * 1.0f) / ((float) this.videoHeight);
        float f3 = (((float) this.mEX) * 1.0f) / ((float) this.mEY);
        if (this.mwG != e.h.DEFAULT) {
            if (this.mwG == e.h.CONTAIN) {
                if (this.mEX < this.mEY) {
                    this.mFa = (int) (((float) this.mEX) / f2);
                    this.mEZ = this.mEX;
                    if (this.mFa > this.mEY) {
                        bVar = this;
                        bVar.mEZ = (int) (((float) bVar.mEY) * f2);
                        bVar.mFa = bVar.mEY;
                    }
                } else {
                    this.mEZ = (int) (((float) this.mEY) * f2);
                    this.mFa = this.mEY;
                    if (this.mEZ > this.mEX) {
                        this.mFa = (int) (((float) this.mEX) / f2);
                        this.mEZ = this.mEX;
                    }
                }
                Log.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", Integer.valueOf(this.mEX), Integer.valueOf(this.mEY), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.mEZ), Integer.valueOf(this.mFa), Float.valueOf(f3), Float.valueOf(f2));
                AppMethodBeat.o(235189);
                return false;
            }
            if (this.mwG == e.h.FILL) {
                this.mFa = this.mEY;
                this.mEZ = this.mEX;
            } else if (this.mwG == e.h.COVER) {
                if (this.mEX > this.mEY) {
                    this.mFa = (int) (((float) this.mEX) / f2);
                    this.mEZ = this.mEX;
                    if (this.mFa < this.mEY) {
                        bVar = this;
                        bVar.mEZ = (int) (((float) bVar.mEY) * f2);
                        bVar.mFa = bVar.mEY;
                    }
                } else {
                    this.mEZ = (int) (((float) this.mEY) * f2);
                    this.mFa = this.mEY;
                    if (this.mEZ < this.mEX) {
                        this.mFa = (int) (((float) this.mEX) / f2);
                        this.mEZ = this.mEX;
                    }
                }
            }
            Log.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", Integer.valueOf(this.mEX), Integer.valueOf(this.mEY), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.mEZ), Integer.valueOf(this.mFa), Float.valueOf(f3), Float.valueOf(f2));
            AppMethodBeat.o(235189);
            return false;
        }
        if (!this.mEe) {
            if (this.mEX < this.mEY) {
                this.mFa = (int) (((float) this.mEX) / f2);
                this.mEZ = this.mEX;
            } else {
                this.mEZ = (int) (((float) this.mEY) * f2);
                this.mFa = this.mEY;
            }
        } else if (((double) Math.abs(f2 - f3)) > 0.05d) {
            if (this.mEX < this.mEY) {
                this.mFa = (int) (((float) this.mEX) / f2);
                this.mEZ = this.mEX;
            } else {
                this.mEZ = (int) (((float) this.mEY) * f2);
                this.mFa = this.mEY;
            }
        } else if (this.mEX > this.mEY) {
            this.mFa = (int) (((float) this.mEX) / f2);
            this.mEZ = this.mEX;
        } else {
            bVar = this;
            bVar.mEZ = (int) (((float) bVar.mEY) * f2);
            bVar.mFa = bVar.mEY;
        }
        Log.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", Integer.valueOf(this.mEX), Integer.valueOf(this.mEY), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.mEZ), Integer.valueOf(this.mFa), Float.valueOf(f3), Float.valueOf(f2));
        AppMethodBeat.o(235189);
        return false;
    }
}
