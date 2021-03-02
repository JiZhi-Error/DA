package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;

public interface s {
    ColorStateList getSupportImageTintList();

    PorterDuff.Mode getSupportImageTintMode();

    void setSupportImageTintList(ColorStateList colorStateList);

    void setSupportImageTintMode(PorterDuff.Mode mode);
}
