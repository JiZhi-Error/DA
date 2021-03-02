package android.support.design.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.a;
import android.support.v7.widget.az;
import android.util.AttributeSet;
import android.view.View;

public class TabItem extends View {
    public final Drawable icon;
    public final CharSequence text;
    public final int uf;

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        az a2 = az.a(context, attributeSet, a.C0008a.TabItem);
        this.text = a2.getText(2);
        this.icon = a2.getDrawable(0);
        this.uf = a2.getResourceId(1, 0);
        a2.ayy.recycle();
    }
}
