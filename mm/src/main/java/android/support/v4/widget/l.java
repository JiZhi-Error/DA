package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;

public final class l {
    public static ColorStateList a(ImageView imageView) {
        if (Build.VERSION.SDK_INT >= 21) {
            return imageView.getImageTintList();
        }
        if (imageView instanceof s) {
            return ((s) imageView).getSupportImageTintList();
        }
        return null;
    }

    public static void a(ImageView imageView, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            imageView.setImageTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable drawable = imageView.getDrawable();
                boolean z = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? false : true;
                if (drawable != null && z) {
                    if (drawable.isStateful()) {
                        drawable.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable(drawable);
                }
            }
        } else if (imageView instanceof s) {
            ((s) imageView).setSupportImageTintList(colorStateList);
        }
    }

    public static PorterDuff.Mode b(ImageView imageView) {
        if (Build.VERSION.SDK_INT >= 21) {
            return imageView.getImageTintMode();
        }
        if (imageView instanceof s) {
            return ((s) imageView).getSupportImageTintMode();
        }
        return null;
    }

    public static void a(ImageView imageView, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            imageView.setImageTintMode(mode);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable drawable = imageView.getDrawable();
                boolean z = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? false : true;
                if (drawable != null && z) {
                    if (drawable.isStateful()) {
                        drawable.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable(drawable);
                }
            }
        } else if (imageView instanceof s) {
            ((s) imageView).setSupportImageTintMode(mode);
        }
    }
}
