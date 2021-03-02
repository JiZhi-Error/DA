package android.support.design.widget;

import android.graphics.Outline;

public final class c extends b {
    public final void getOutline(Outline outline) {
        copyBounds(this.rect);
        outline.setOval(this.rect);
    }
}
