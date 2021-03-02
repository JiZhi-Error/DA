package com.github.henryye.nativeiv;

import android.graphics.Bitmap;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Keep
public class ImageDecodeConfig {
    @Keep
    public Bitmap.Config mConfig = Bitmap.Config.ARGB_8888;
    @Keep
    public int mPreferredHeight = 0;
    @Keep
    public double mPreferredScale = 0.0d;
    @Keep
    public int mPreferredWidth = 0;
    @Keep
    public boolean mPremultiplyAlpha = true;
    @Keep
    public ReferrerPolicy mReferrerPolicy = ReferrerPolicy.NOT_SET;

    @Keep
    public enum ReferrerPolicy {
        NOT_SET,
        NO_REFERRER,
        ORIGIN;

        public static ReferrerPolicy valueOf(String str) {
            AppMethodBeat.i(219799);
            ReferrerPolicy referrerPolicy = (ReferrerPolicy) Enum.valueOf(ReferrerPolicy.class, str);
            AppMethodBeat.o(219799);
            return referrerPolicy;
        }

        static {
            AppMethodBeat.i(219800);
            AppMethodBeat.o(219800);
        }
    }

    @Keep
    public int getNativeConfig() {
        AppMethodBeat.i(127340);
        switch (AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[this.mConfig.ordinal()]) {
            case 1:
                AppMethodBeat.o(127340);
                return 1;
            case 2:
                AppMethodBeat.o(127340);
                return 4;
            case 3:
                AppMethodBeat.o(127340);
                return 7;
            case 4:
                AppMethodBeat.o(127340);
                return 8;
            default:
                AppMethodBeat.o(127340);
                return 1;
        }
    }

    /* renamed from: com.github.henryye.nativeiv.ImageDecodeConfig$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config = new int[Bitmap.Config.values().length];

        static {
            AppMethodBeat.i(127339);
            baB = new int[ReferrerPolicy.values().length];
            try {
                baB[ReferrerPolicy.NO_REFERRER.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                baB[ReferrerPolicy.ORIGIN.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ALPHA_8.ordinal()] = 4;
                AppMethodBeat.o(127339);
            } catch (NoSuchFieldError e7) {
                AppMethodBeat.o(127339);
            }
        }
    }

    @Keep
    public int getNativeReferrerPolicy() {
        AppMethodBeat.i(219801);
        switch (this.mReferrerPolicy) {
            case NO_REFERRER:
                AppMethodBeat.o(219801);
                return 1;
            case ORIGIN:
                AppMethodBeat.o(219801);
                return 2;
            default:
                AppMethodBeat.o(219801);
                return 0;
        }
    }

    @Keep
    public static ImageDecodeConfig createConfig(Bitmap.Config config, boolean z) {
        AppMethodBeat.i(127341);
        ImageDecodeConfig imageDecodeConfig = new ImageDecodeConfig();
        imageDecodeConfig.mPremultiplyAlpha = z;
        imageDecodeConfig.mConfig = config;
        AppMethodBeat.o(127341);
        return imageDecodeConfig;
    }

    @Keep
    public static Object createConfig(int i2, boolean z, int i3, int i4, int i5, double d2) {
        AppMethodBeat.i(219802);
        ImageDecodeConfig imageDecodeConfig = new ImageDecodeConfig();
        imageDecodeConfig.mPremultiplyAlpha = z;
        if (i2 == 8) {
            imageDecodeConfig.mConfig = Bitmap.Config.ALPHA_8;
        } else if (i2 == 4) {
            imageDecodeConfig.mConfig = Bitmap.Config.RGB_565;
        } else if (i2 == 7) {
            imageDecodeConfig.mConfig = Bitmap.Config.ARGB_4444;
        } else {
            imageDecodeConfig.mConfig = Bitmap.Config.ARGB_8888;
        }
        if (i3 == 0) {
            imageDecodeConfig.mReferrerPolicy = ReferrerPolicy.NOT_SET;
        } else if (i3 == 1) {
            imageDecodeConfig.mReferrerPolicy = ReferrerPolicy.NO_REFERRER;
        } else if (i3 == 2) {
            imageDecodeConfig.mReferrerPolicy = ReferrerPolicy.ORIGIN;
        }
        imageDecodeConfig.mPreferredWidth = i4;
        imageDecodeConfig.mPreferredHeight = i5;
        imageDecodeConfig.mPreferredScale = d2;
        AppMethodBeat.o(219802);
        return imageDecodeConfig;
    }

    public String toString() {
        AppMethodBeat.i(219803);
        String str = "ImageDecodeConfig{mConfig=" + this.mConfig + ", mPremultiplyAlpha=" + this.mPremultiplyAlpha + ", mReferrerPolicy=" + this.mReferrerPolicy + ", mPreferredWidth=" + this.mPreferredWidth + ", mPreferredHeight=" + this.mPreferredHeight + ", mPreferredScale=" + this.mPreferredScale + '}';
        AppMethodBeat.o(219803);
        return str;
    }
}
