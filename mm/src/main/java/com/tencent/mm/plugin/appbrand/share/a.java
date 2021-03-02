package com.tencent.mm.plugin.appbrand.share;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.sdk.platformtools.FileSeekingInputStream;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class a implements b.f {
    private int mHeight;
    private int mWidth;
    public k.a nMZ = k.a.DECODE_TYPE_DEFAULT;

    public a(int i2, int i3) {
        this.mWidth = i2;
        this.mHeight = i3;
    }

    @Override // com.tencent.mm.modelappbrand.a.b.f
    public final Bitmap w(InputStream inputStream) {
        Bitmap decodeStream;
        int i2;
        int i3;
        AppMethodBeat.i(48315);
        Log.d("MicroMsg.AppBrand.BitmapDecoderImpl", "decode type: %d.", Integer.valueOf(this.nMZ.ordinal()));
        try {
            if (!inputStream.markSupported()) {
                if (inputStream instanceof FileInputStream) {
                    inputStream = new FileSeekingInputStream((FileInputStream) inputStream);
                } else if (!inputStream.markSupported()) {
                    inputStream = new BufferedInputStream(inputStream);
                }
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            inputStream.mark(TPMediaCodecProfileLevel.HEVCHighTierLevel61);
            Bitmap decodeStream2 = BitmapFactory.decodeStream(inputStream, null, options);
            inputStream.reset();
            if (decodeStream2 != null) {
                Log.i("MicroMsg.AppBrand.BitmapDecoderImpl", "bitmap recycle %s", decodeStream2);
                decodeStream2.recycle();
            }
            if (options.outHeight <= 0 || options.outWidth <= 0) {
                Log.e("MicroMsg.AppBrand.BitmapDecoderImpl", "decode[%s] error, outHeight[%d] outWidth[%d]", inputStream, Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                    }
                }
                AppMethodBeat.o(48315);
                return null;
            }
            options.inSampleSize = (int) ((((double) options.outWidth) * 1.0d) / ((double) this.mWidth));
            if (options.inSampleSize <= 1) {
                options.inSampleSize = 1;
            }
            while (((options.outHeight * options.outWidth) / options.inSampleSize) / options.inSampleSize > 2764800) {
                options.inSampleSize++;
            }
            options.inJustDecodeBounds = false;
            options.inMutable = true;
            float f2 = ((float) options.outWidth) / ((float) options.outHeight);
            float f3 = ((float) this.mWidth) / ((float) this.mHeight);
            switch (this.nMZ) {
                case DECODE_TYPE_DEFAULT:
                    if (f2 > f3) {
                        int i4 = options.outHeight;
                        i2 = (int) (((((float) options.outHeight) * 1.0f) * ((float) this.mWidth)) / ((float) this.mHeight));
                        i3 = i4;
                    } else {
                        i2 = options.outWidth;
                        i3 = (int) (((((float) options.outWidth) * 1.0f) * ((float) this.mHeight)) / ((float) this.mWidth));
                    }
                    decodeStream = BitmapRegionDecoder.newInstance(inputStream, false).decodeRegion(new Rect(0, 0, i2, i3), options);
                    if (decodeStream == null) {
                        Log.e("MicroMsg.AppBrand.BitmapDecoderImpl", "get null result using RegionDecoder, origin[%dx%d], desire[%dx%d]", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), Integer.valueOf(i2), Integer.valueOf(i3));
                        try {
                            inputStream.reset();
                            decodeStream = com.tencent.mm.compatible.f.a.decodeStream(inputStream, null, options);
                            break;
                        } catch (IOException | OutOfMemoryError e3) {
                            Log.printErrStackTrace("MicroMsg.AppBrand.BitmapDecoderImpl", e3, "fallback using BitmapFactory", new Object[0]);
                            break;
                        }
                    }
                    break;
                case DECODE_TYPE_ORIGIN:
                    decodeStream = com.tencent.mm.compatible.f.a.decodeStream(inputStream, null, options);
                    break;
                default:
                    decodeStream = null;
                    break;
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                }
            }
            AppMethodBeat.o(48315);
            return decodeStream;
        } catch (IOException e5) {
            Log.e("MicroMsg.AppBrand.BitmapDecoderImpl", "%s", e5);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                }
            }
            AppMethodBeat.o(48315);
            return null;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e7) {
                }
            }
            AppMethodBeat.o(48315);
            throw th;
        }
    }

    @Override // com.tencent.mm.modelappbrand.a.c
    public final String Lb() {
        AppMethodBeat.i(48316);
        String format = String.format("Decoder_w%s_h%s", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight));
        AppMethodBeat.o(48316);
        return format;
    }
}
