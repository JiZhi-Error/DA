package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.sdk.platformtools.Log;

public final class w {
    i.e BOo = i.e.DEFAULT;
    int mEX;
    int mEY;
    public int mEZ;
    public boolean mEe;
    public int mFa;
    int videoHeight;
    int videoWidth;

    public final void reset() {
        this.mEY = 0;
        this.mEX = 0;
        this.videoHeight = 0;
        this.videoWidth = 0;
        this.mFa = 0;
        this.mEZ = 0;
    }

    public final boolean a(i.e eVar) {
        boolean z;
        AppMethodBeat.i(169170);
        if (this.BOo == eVar) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.ViewSizeCache", "set scale type old[%s] new[%s]", this.BOo, eVar);
        this.BOo = eVar;
        reset();
        if (!z) {
            AppMethodBeat.o(169170);
            return true;
        }
        AppMethodBeat.o(169170);
        return false;
    }

    public final boolean y(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(134103);
        if (this.mEX == i2 && this.mEY == i3 && this.videoWidth == i4 && this.videoHeight == i5) {
            AppMethodBeat.o(134103);
            return true;
        }
        this.mEX = i2;
        this.mEY = i3;
        this.videoWidth = i4;
        this.videoHeight = i5;
        float f2 = (((float) this.videoWidth) * 1.0f) / ((float) this.videoHeight);
        float f3 = (((float) this.mEX) * 1.0f) / ((float) this.mEY);
        if (this.BOo != i.e.DEFAULT) {
            if (this.BOo == i.e.CONTAIN) {
                ck(f2);
            } else if (this.BOo == i.e.FILL) {
                gsI();
            } else if (this.BOo == i.e.COVER) {
                cl(f2);
            }
            Log.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", Integer.valueOf(this.mEX), Integer.valueOf(this.mEY), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.mEZ), Integer.valueOf(this.mFa), Float.valueOf(f3), Float.valueOf(f2));
            AppMethodBeat.o(134103);
            return false;
        }
        ar(f2, f3);
        Log.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", Integer.valueOf(this.mEX), Integer.valueOf(this.mEY), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.mEZ), Integer.valueOf(this.mFa), Float.valueOf(f3), Float.valueOf(f2));
        AppMethodBeat.o(134103);
        return false;
    }

    private void ck(float f2) {
        if (this.mEX < this.mEY) {
            this.mFa = (int) (((float) this.mEX) / f2);
            this.mEZ = this.mEX;
            if (this.mFa > this.mEY) {
                this.mEZ = (int) (((float) this.mEY) * f2);
                this.mFa = this.mEY;
                return;
            }
            return;
        }
        this.mEZ = (int) (((float) this.mEY) * f2);
        this.mFa = this.mEY;
        if (this.mEZ > this.mEX) {
            this.mFa = (int) (((float) this.mEX) / f2);
            this.mEZ = this.mEX;
        }
    }

    private void cl(float f2) {
        if (this.mEX > this.mEY) {
            this.mFa = (int) (((float) this.mEX) / f2);
            this.mEZ = this.mEX;
            if (this.mFa < this.mEY) {
                this.mEZ = (int) (((float) this.mEY) * f2);
                this.mFa = this.mEY;
                return;
            }
            return;
        }
        this.mEZ = (int) (((float) this.mEY) * f2);
        this.mFa = this.mEY;
        if (this.mEZ < this.mEX) {
            this.mFa = (int) (((float) this.mEX) / f2);
            this.mEZ = this.mEX;
        }
    }

    private void gsI() {
        this.mFa = this.mEY;
        this.mEZ = this.mEX;
    }

    private void ar(float f2, float f3) {
        AppMethodBeat.i(134104);
        if (!this.mEe) {
            if (this.mEX < this.mEY) {
                this.mFa = (int) (((float) this.mEX) / f2);
                this.mEZ = this.mEX;
                AppMethodBeat.o(134104);
                return;
            }
            this.mEZ = (int) (((float) this.mEY) * f2);
            this.mFa = this.mEY;
            AppMethodBeat.o(134104);
        } else if (((double) Math.abs(f2 - f3)) > 0.05d) {
            if (this.mEX < this.mEY) {
                this.mFa = (int) (((float) this.mEX) / f2);
                this.mEZ = this.mEX;
                AppMethodBeat.o(134104);
                return;
            }
            this.mEZ = (int) (((float) this.mEY) * f2);
            this.mFa = this.mEY;
            AppMethodBeat.o(134104);
        } else if (this.mEX > this.mEY) {
            this.mFa = (int) (((float) this.mEX) / f2);
            this.mEZ = this.mEX;
            AppMethodBeat.o(134104);
        } else {
            this.mEZ = (int) (((float) this.mEY) * f2);
            this.mFa = this.mEY;
            AppMethodBeat.o(134104);
        }
    }
}
