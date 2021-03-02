package com.tencent.mm.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.ae.a;
import com.tencent.mm.view.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0016\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010#\u001a\u00020\nH\u0016J\b\u0010$\u001a\u00020\nH\u0016J\n\u0010%\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020)H\u0002J\u001a\u0010*\u001a\u00020)2\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010+\u001a\u00020\nH\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020\nH\u0016J\u0010\u0010.\u001a\u00020)2\u0006\u0010-\u001a\u00020\nH\u0016J\u0010\u0010/\u001a\u00020)2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020\u0017H\u0016R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001f¨\u00063"}, hxF = {"Lcom/tencent/mm/view/MediaBannerIndicator;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/view/IMediaBannerIndicator;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "count", "currentIndex", "indicatorMargin", "getIndicatorMargin", "()I", "setIndicatorMargin", "(I)V", "indicatorWidth", "getIndicatorWidth", "setIndicatorWidth", "isShowOnlyOneIndicator", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/view/IMediaBannerIndicator$OnSelectedPageListener;", "selectDrawable", "Landroid/graphics/drawable/Drawable;", "getSelectDrawable", "()Landroid/graphics/drawable/Drawable;", "setSelectDrawable", "(Landroid/graphics/drawable/Drawable;)V", "unSelectDrawable", "getUnSelectDrawable", "setUnSelectDrawable", "getCount", "getCurrentIndex", "getOnSelectedPageListener", "getView", "Landroid/view/View;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "initAttribute", "defStyle", "setCount", "value", "setCurrentIndex", "setOnSelectedPageListener", "setShowOnlyOneIndicator", "isShow", "Companion", "libmmui_release"})
public class MediaBannerIndicator extends LinearLayout implements h {
    public static final a RjZ = new a((byte) 0);
    private int RjU = ((int) getResources().getDimension(R.dimen.a9d));
    private int RjV = ((int) getResources().getDimension(R.dimen.bt));
    private Drawable RjW = getContext().getDrawable(R.drawable.ash);
    private Drawable RjX = getContext().getDrawable(R.drawable.a6z);
    private h.a RjY;
    private int count;
    private int currentIndex;
    private boolean wsp;

    static {
        AppMethodBeat.i(164560);
        AppMethodBeat.o(164560);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/view/MediaBannerIndicator$Companion;", "", "()V", "TAG", "", "libmmui_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public int getIndicatorWidth() {
        return this.RjU;
    }

    public void setIndicatorWidth(int i2) {
        this.RjU = i2;
    }

    public int getIndicatorMargin() {
        return this.RjV;
    }

    public void setIndicatorMargin(int i2) {
        this.RjV = i2;
    }

    public Drawable getSelectDrawable() {
        return this.RjW;
    }

    public void setSelectDrawable(Drawable drawable) {
        this.RjW = drawable;
    }

    public Drawable getUnSelectDrawable() {
        return this.RjX;
    }

    public void setUnSelectDrawable(Drawable drawable) {
        this.RjX = drawable;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaBannerIndicator(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(164557);
        setOrientation(0);
        setGravity(17);
        AppMethodBeat.o(164557);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaBannerIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(164558);
        setOrientation(0);
        setGravity(17);
        b(attributeSet, 0);
        AppMethodBeat.o(164558);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaBannerIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(164559);
        setOrientation(0);
        setGravity(17);
        b(attributeSet, i2);
        AppMethodBeat.o(164559);
    }

    private final void b(AttributeSet attributeSet, int i2) {
        AppMethodBeat.i(204979);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.C0244a.MediaBannerIndicator, i2, 0);
        setIndicatorMargin((int) obtainStyledAttributes.getDimension(0, getResources().getDimension(R.dimen.bt)));
        setIndicatorWidth((int) obtainStyledAttributes.getDimension(3, getResources().getDimension(R.dimen.a9d)));
        if (obtainStyledAttributes.hasValue(1)) {
            setSelectDrawable(obtainStyledAttributes.getDrawable(1));
        }
        if (obtainStyledAttributes.hasValue(2)) {
            setUnSelectDrawable(obtainStyledAttributes.getDrawable(2));
        }
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(204979);
    }

    @Override // com.tencent.mm.view.h
    public void setShowOnlyOneIndicator(boolean z) {
        this.wsp = z;
    }

    @Override // com.tencent.mm.view.h
    public void setCount(int i2) {
        AppMethodBeat.i(164555);
        removeAllViews();
        this.count = i2;
        if (i2 > 1 || (i2 > 0 && this.wsp)) {
            setVisibility(0);
            this.currentIndex = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                ImageView imageView = new ImageView(getContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                if (this.currentIndex == i3) {
                    imageView.setImageDrawable(getSelectDrawable());
                } else {
                    imageView.setImageDrawable(getUnSelectDrawable());
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getIndicatorWidth(), getIndicatorWidth());
                layoutParams.leftMargin = getIndicatorMargin();
                layoutParams.rightMargin = getIndicatorMargin();
                layoutParams.gravity = 17;
                addView(imageView, layoutParams);
            }
        } else {
            setVisibility(8);
        }
        AppMethodBeat.o(164555);
    }

    @Override // com.tencent.mm.view.h
    public int getCount() {
        return this.count;
    }

    @Override // com.tencent.mm.view.h
    public void setCurrentIndex(int i2) {
        AppMethodBeat.i(164556);
        View childAt = getChildAt(this.currentIndex);
        if (!(childAt instanceof ImageView)) {
            childAt = null;
        }
        ImageView imageView = (ImageView) childAt;
        if (imageView != null) {
            imageView.setImageDrawable(getUnSelectDrawable());
            View childAt2 = getChildAt(i2);
            if (!(childAt2 instanceof ImageView)) {
                childAt2 = null;
            }
            ImageView imageView2 = (ImageView) childAt2;
            if (imageView2 != null) {
                imageView2.setImageDrawable(getSelectDrawable());
            }
        }
        this.currentIndex = i2;
        AppMethodBeat.o(164556);
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    @Override // com.tencent.mm.view.h
    public View getView() {
        return this;
    }

    @Override // com.tencent.mm.view.h
    public void setOnSelectedPageListener(h.a aVar) {
        AppMethodBeat.i(204980);
        p.h(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.RjY = aVar;
        AppMethodBeat.o(204980);
    }

    public h.a getOnSelectedPageListener() {
        return this.RjY;
    }
}
