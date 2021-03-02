package android.support.design.card;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.a;
import android.support.design.internal.f;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import com.tencent.mm.R;

public class MaterialCardView extends CardView {
    private final a hX;

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.ul);
    }

    public MaterialCardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray a2 = f.a(context, attributeSet, a.C0008a.MaterialCardView, i2, R.style.a4d, new int[0]);
        this.hX = new a(this);
        a aVar = this.hX;
        aVar.strokeColor = a2.getColor(0, -1);
        aVar.strokeWidth = a2.getDimensionPixelSize(1, 0);
        aVar.bc();
        aVar.be();
        a2.recycle();
    }

    public void setStrokeColor(int i2) {
        a aVar = this.hX;
        aVar.strokeColor = i2;
        aVar.bc();
    }

    public int getStrokeColor() {
        return this.hX.strokeColor;
    }

    public void setStrokeWidth(int i2) {
        a aVar = this.hX;
        aVar.strokeWidth = i2;
        aVar.bc();
        aVar.be();
    }

    public int getStrokeWidth() {
        return this.hX.strokeWidth;
    }

    @Override // android.support.v7.widget.CardView
    public void setRadius(float f2) {
        super.setRadius(f2);
        this.hX.bc();
    }
}
