package android.support.v4.graphics;

import android.graphics.Bitmap;
import android.os.Build;

public final class a {
    public static int c(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            return bitmap.getAllocationByteCount();
        }
        return bitmap.getByteCount();
    }
}
