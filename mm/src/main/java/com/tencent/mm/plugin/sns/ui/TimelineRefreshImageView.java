package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;

public class TimelineRefreshImageView extends ImageView {
    public TimelineRefreshImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TimelineRefreshImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void destroyDrawingCache() {
        AppMethodBeat.i(99766);
        super.destroyDrawingCache();
        Log.d("MicroMsg.TimelineRefreshImageView", "destroyDrawingCache, width: %s, height: %s, hash: %s", Integer.valueOf(getWidth()), Integer.valueOf(getHeight()), Integer.valueOf(hashCode()));
        AppMethodBeat.o(99766);
    }

    public void buildDrawingCache(boolean z) {
        String format;
        AppMethodBeat.i(99765);
        try {
            Field declaredField = View.class.getDeclaredField(z ? "mDrawingCache" : "mUnscaledDrawingCache");
            declaredField.setAccessible(true);
            Bitmap bitmap = (Bitmap) declaredField.get(this);
            if (bitmap == null) {
                format = "cache is null";
            } else {
                format = String.format("cache.width: %s, cache.height: %s, width: %s, height: %s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
            }
            Log.d("MicroMsg.TimelineRefreshImageView", format);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.TimelineRefreshImageView", e2, "", new Object[0]);
            Log.e("MicroMsg.TimelineRefreshImageView", "checkIfCanReuseDrawingCache error: %s", e2.getMessage());
        }
        Log.d("MicroMsg.TimelineRefreshImageView", "buildDrawingCache, autoScale: %s, width: %s, height: %s, hash: %s", Boolean.valueOf(z), Integer.valueOf(getWidth()), Integer.valueOf(getHeight()), Integer.valueOf(hashCode()));
        super.buildDrawingCache(z);
        AppMethodBeat.o(99765);
    }
}
