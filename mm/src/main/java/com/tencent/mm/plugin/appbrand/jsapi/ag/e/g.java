package com.tencent.mm.plugin.appbrand.jsapi.ag.e;

import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g implements f {
    private int mEX;
    private int mEY;
    private int mEZ;
    private int mFa;
    private String mLh;
    private float mLi;
    private float mLj;
    private int videoHeight;
    private int videoWidth;

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.f
    public final float QH() {
        return this.mLi;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.f
    public final float QI() {
        return this.mLj;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.f
    public final boolean a(String str, int i2, int i3, int i4, int i5) {
        g gVar;
        AppMethodBeat.i(139600);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, scale type is null");
            AppMethodBeat.o(139600);
            return false;
        } else if (i2 == 0 || i3 == 0 || i4 == 0 || i5 == 0) {
            Log.w("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, width or height is 0");
            AppMethodBeat.o(139600);
            return false;
        } else if (str.equalsIgnoreCase(this.mLh) && this.mEX == i2 && this.mEY == i3 && this.videoWidth == i4 && this.videoHeight == i5) {
            Log.w("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, same as last calculated");
            AppMethodBeat.o(139600);
            return true;
        } else {
            this.mLh = str;
            this.mEX = i2;
            this.mEY = i3;
            this.videoWidth = i4;
            this.videoHeight = i5;
            float f2 = (((float) this.videoWidth) * 1.0f) / ((float) this.videoHeight);
            float f3 = (((float) this.mEX) * 1.0f) / ((float) this.mEY);
            if (this.mLh.equalsIgnoreCase("contain")) {
                if (this.mEX < this.mEY) {
                    this.mFa = (int) (((float) this.mEX) / f2);
                    this.mEZ = this.mEX;
                    if (this.mFa > this.mEY) {
                        gVar = this;
                    }
                } else {
                    this.mEZ = (int) (((float) this.mEY) * f2);
                    this.mFa = this.mEY;
                    if (this.mEZ > this.mEX) {
                        this.mFa = (int) (((float) this.mEX) / f2);
                        this.mEZ = this.mEX;
                    }
                }
                this.mLi = (((float) this.mEZ) * 1.0f) / ((float) this.mEX);
                this.mLj = (((float) this.mFa) * 1.0f) / ((float) this.mEY);
                Log.d("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, screen[%d, %d], video[%d, %d], measure[%d, %d], scale[%f, %f]", Integer.valueOf(this.mEX), Integer.valueOf(this.mEY), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.mEZ), Integer.valueOf(this.mFa), Float.valueOf(this.mLi), Float.valueOf(this.mLj));
                AppMethodBeat.o(139600);
                return true;
            }
            if (this.mLh.equalsIgnoreCase("fill")) {
                this.mFa = this.mEY;
                this.mEZ = this.mEX;
            } else if (this.mLh.equalsIgnoreCase("cover")) {
                if (this.mEX > this.mEY) {
                    this.mFa = (int) (((float) this.mEX) / f2);
                    this.mEZ = this.mEX;
                    if (this.mFa < this.mEY) {
                        gVar = this;
                    }
                } else {
                    this.mEZ = (int) (((float) this.mEY) * f2);
                    this.mFa = this.mEY;
                    if (this.mEZ < this.mEX) {
                        this.mFa = (int) (((float) this.mEX) / f2);
                        this.mEZ = this.mEX;
                    }
                }
            } else if (((double) Math.abs(f2 - f3)) > 0.05d) {
                if (this.mEX < this.mEY) {
                    this.mFa = (int) (((float) this.mEX) / f2);
                    this.mEZ = this.mEX;
                } else {
                    this.mEZ = (int) (f2 * ((float) this.mEY));
                    this.mFa = this.mEY;
                }
            } else if (this.mEX > this.mEY) {
                this.mFa = (int) (((float) this.mEX) / f2);
                this.mEZ = this.mEX;
            } else {
                gVar = this;
            }
            this.mLi = (((float) this.mEZ) * 1.0f) / ((float) this.mEX);
            this.mLj = (((float) this.mFa) * 1.0f) / ((float) this.mEY);
            Log.d("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, screen[%d, %d], video[%d, %d], measure[%d, %d], scale[%f, %f]", Integer.valueOf(this.mEX), Integer.valueOf(this.mEY), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.mEZ), Integer.valueOf(this.mFa), Float.valueOf(this.mLi), Float.valueOf(this.mLj));
            AppMethodBeat.o(139600);
            return true;
            gVar.mEZ = (int) (f2 * ((float) gVar.mEY));
            gVar.mFa = gVar.mEY;
            this.mLi = (((float) this.mEZ) * 1.0f) / ((float) this.mEX);
            this.mLj = (((float) this.mFa) * 1.0f) / ((float) this.mEY);
            Log.d("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, screen[%d, %d], video[%d, %d], measure[%d, %d], scale[%f, %f]", Integer.valueOf(this.mEX), Integer.valueOf(this.mEY), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.mEZ), Integer.valueOf(this.mFa), Float.valueOf(this.mLi), Float.valueOf(this.mLj));
            AppMethodBeat.o(139600);
            return true;
        }
    }
}
