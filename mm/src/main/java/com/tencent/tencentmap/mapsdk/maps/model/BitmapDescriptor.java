package com.tencent.tencentmap.mapsdk.maps.model;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class BitmapDescriptor {
    private BitmapFormator bitmapFormator = null;

    public interface BitmapFormator {

        @Retention(RetentionPolicy.SOURCE)
        public @interface BitmapFormatType {
            public static final int FORMAT_ASSET = 2;
            public static final int FORMAT_BITMAP = 7;
            public static final int FORMAT_DEFAULT = 5;
            public static final int FORMAT_DEFAULT_F = 6;
            public static final int FORMAT_FILE = 3;
            public static final int FORMAT_FONT_TEXT = 9;
            public static final int FORMAT_NONE = -1;
            public static final int FORMAT_PATH = 4;
            public static final int FORMAT_RESOURCE = 1;
            public static final int FORMAT_URL = 8;
        }

        Bitmap getBitmap(Context context);

        String getBitmapId();

        int getFormateType();

        void setScale(int i2);
    }

    public BitmapDescriptor(BitmapFormator bitmapFormator2) {
        this.bitmapFormator = bitmapFormator2;
    }

    public final BitmapFormator getFormater() {
        return this.bitmapFormator;
    }

    public final Bitmap getBitmap(Context context) {
        AppMethodBeat.i(173082);
        if (this.bitmapFormator == null) {
            AppMethodBeat.o(173082);
            return null;
        }
        Bitmap bitmap = this.bitmapFormator.getBitmap(context);
        AppMethodBeat.o(173082);
        return bitmap;
    }
}
