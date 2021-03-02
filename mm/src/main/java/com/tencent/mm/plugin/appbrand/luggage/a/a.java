package com.tencent.mm.plugin.appbrand.luggage.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.sdk.platformtools.FileSeekingInputStream;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class a implements b.f {
    private int height;
    private int left;
    private int top;
    private int width;

    public a(int i2, int i3, int i4, int i5) {
        this.left = i2;
        this.top = i3;
        this.width = i4;
        this.height = i5;
    }

    @Override // com.tencent.mm.modelappbrand.a.b.f
    public final Bitmap w(InputStream inputStream) {
        AppMethodBeat.i(134891);
        try {
            if (this.width < 0 || this.height < 0) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                    }
                }
                AppMethodBeat.o(134891);
                return null;
            }
            if (!inputStream.markSupported()) {
                if (inputStream instanceof FileInputStream) {
                    inputStream = new FileSeekingInputStream((FileInputStream) inputStream);
                } else if (!inputStream.markSupported()) {
                    inputStream = new BufferedInputStream(inputStream);
                }
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inMutable = true;
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(inputStream, false);
            Bitmap decodeRegion = newInstance.decodeRegion(new Rect(this.left, this.top, this.left + this.width, this.top + this.height), options);
            newInstance.recycle();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                }
            }
            AppMethodBeat.o(134891);
            return decodeRegion;
        } catch (IOException e4) {
            Log.e("MicroMsg.AppBrand.BitmapRegionDecoderImpl", "%s", android.util.Log.getStackTraceString(e4));
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
        } catch (IllegalArgumentException e6) {
            Log.e("MicroMsg.AppBrand.BitmapRegionDecoderImpl", "%s", android.util.Log.getStackTraceString(e6));
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e7) {
                }
            }
        } catch (OutOfMemoryError e8) {
            Log.e("MicroMsg.AppBrand.BitmapRegionDecoderImpl", "%s", android.util.Log.getStackTraceString(e8));
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e9) {
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e10) {
                }
            }
            AppMethodBeat.o(134891);
            throw th;
        }
        AppMethodBeat.o(134891);
        return null;
    }

    @Override // com.tencent.mm.modelappbrand.a.c
    public final String Lb() {
        AppMethodBeat.i(134892);
        String format = String.format("Decoder_x%s_y%s_w%s_h%s", Integer.valueOf(this.left), Integer.valueOf(this.top), Integer.valueOf(this.width), Integer.valueOf(this.height));
        AppMethodBeat.o(134892);
        return format;
    }
}
