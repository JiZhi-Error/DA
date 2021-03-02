package android.support.design.card;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

final class a {
    private final MaterialCardView hY;
    int strokeColor;
    int strokeWidth;

    public a(MaterialCardView materialCardView) {
        this.hY = materialCardView;
    }

    /* access modifiers changed from: package-private */
    public final void bc() {
        this.hY.setForeground(bd());
    }

    private Drawable bd() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.hY.getRadius());
        if (this.strokeColor != -1) {
            gradientDrawable.setStroke(this.strokeWidth, this.strokeColor);
        }
        return gradientDrawable;
    }

    /* access modifiers changed from: package-private */
    public final void be() {
        this.hY.setContentPadding(this.hY.getContentPaddingLeft() + this.strokeWidth, this.hY.getContentPaddingTop() + this.strokeWidth, this.hY.getContentPaddingRight() + this.strokeWidth, this.hY.getContentPaddingBottom() + this.strokeWidth);
    }
}
