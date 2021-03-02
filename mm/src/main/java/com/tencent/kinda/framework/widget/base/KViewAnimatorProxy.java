package com.tencent.kinda.framework.widget.base;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import com.tencent.kinda.framework.animate.KindaGlobalAnimator;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.gen.Align;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.IUIPagePlatformDelegate;
import com.tencent.kinda.gen.KPoint;
import com.tencent.kinda.gen.KView;
import com.tencent.kinda.gen.KViewOnClickCallback;
import com.tencent.kinda.gen.KViewOnLongClickCallback;
import com.tencent.kinda.gen.KViewOnTouchCallback;
import com.tencent.kinda.gen.PositionType;
import com.tencent.kinda.gen.Visible;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class KViewAnimatorProxy implements KView {
    private KView mKView;

    public KViewAnimatorProxy(KView kView) {
        this.mKView = kView;
    }

    @Override // com.tencent.kinda.gen.KView
    public void initWithPlatformDelegate(IUIPagePlatformDelegate iUIPagePlatformDelegate) {
    }

    @Override // com.tencent.kinda.gen.KView
    public void setViewId(String str) {
    }

    @Override // com.tencent.kinda.gen.KView
    public String getViewId() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setWidth(float f2) {
        AppMethodBeat.i(18809);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mKView, "width", this.mKView.getWidth(), f2);
        ofFloat.setDuration(KindaGlobalAnimator.animateDuration());
        KindaGlobalAnimator.addAnimator(ofFloat);
        AppMethodBeat.o(18809);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getWidth() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setHeight(float f2) {
        AppMethodBeat.i(18810);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mKView, "height", this.mKView.getHeight(), f2);
        ofFloat.setDuration(KindaGlobalAnimator.animateDuration());
        KindaGlobalAnimator.addAnimator(ofFloat);
        AppMethodBeat.o(18810);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getHeight() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setLeft(float f2) {
        AppMethodBeat.i(18811);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mKView, "left", this.mKView.getLeft(), f2);
        ofFloat.setDuration(KindaGlobalAnimator.animateDuration());
        KindaGlobalAnimator.addAnimator(ofFloat);
        AppMethodBeat.o(18811);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getLeft() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setTop(float f2) {
        AppMethodBeat.i(18812);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mKView, "top", this.mKView.getTop(), f2);
        ofFloat.setDuration(KindaGlobalAnimator.animateDuration());
        KindaGlobalAnimator.addAnimator(ofFloat);
        AppMethodBeat.o(18812);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getTop() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setRight(float f2) {
        AppMethodBeat.i(18813);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mKView, "right", this.mKView.getRight(), f2);
        ofFloat.setDuration(KindaGlobalAnimator.animateDuration());
        KindaGlobalAnimator.addAnimator(ofFloat);
        AppMethodBeat.o(18813);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getRight() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setBottom(float f2) {
        AppMethodBeat.i(18814);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mKView, "bottom", this.mKView.getBottom(), f2);
        ofFloat.setDuration(KindaGlobalAnimator.animateDuration());
        KindaGlobalAnimator.addAnimator(ofFloat);
        AppMethodBeat.o(18814);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getBottom() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setMinWidth(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getMinWidth() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setMaxWidth(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getMaxWidth() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setMinHeight(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getMinHeight() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setMaxHeight(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getMaxHeight() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setMarginLeft(float f2) {
        AppMethodBeat.i(178770);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mKView, "marginLeft", this.mKView.getMarginLeft(), f2);
        ofFloat.setDuration(KindaGlobalAnimator.animateDuration());
        KindaGlobalAnimator.addAnimator(ofFloat);
        AppMethodBeat.o(178770);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getMarginLeft() {
        AppMethodBeat.i(178771);
        float marginLeft = this.mKView.getMarginLeft();
        AppMethodBeat.o(178771);
        return marginLeft;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setMarginTop(float f2) {
        AppMethodBeat.i(214461);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mKView, "marginTop", this.mKView.getMarginTop(), f2);
        ofFloat.setDuration(KindaGlobalAnimator.animateDuration());
        KindaGlobalAnimator.addAnimator(ofFloat);
        AppMethodBeat.o(214461);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getMarginTop() {
        AppMethodBeat.i(214462);
        float marginTop = this.mKView.getMarginTop();
        AppMethodBeat.o(214462);
        return marginTop;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setMarginRight(float f2) {
        AppMethodBeat.i(214463);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mKView, "marginRight", this.mKView.getMarginRight(), f2);
        ofFloat.setDuration(KindaGlobalAnimator.animateDuration());
        KindaGlobalAnimator.addAnimator(ofFloat);
        AppMethodBeat.o(214463);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getMarginRight() {
        AppMethodBeat.i(214464);
        float marginRight = this.mKView.getMarginRight();
        AppMethodBeat.o(214464);
        return marginRight;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setMarginBottom(float f2) {
        AppMethodBeat.i(214465);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mKView, "marginBottom", this.mKView.getMarginBottom(), f2);
        ofFloat.setDuration(KindaGlobalAnimator.animateDuration());
        KindaGlobalAnimator.addAnimator(ofFloat);
        AppMethodBeat.o(214465);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getMarginBottom() {
        AppMethodBeat.i(214466);
        float marginBottom = this.mKView.getMarginBottom();
        AppMethodBeat.o(214466);
        return marginBottom;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setPaddingLeft(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getPaddingLeft() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setPaddingTop(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getPaddingTop() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setPaddingRight(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getPaddingRight() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setPaddingBottom(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getPaddingBottom() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setBackgroundColor(DynamicColor dynamicColor) {
        AppMethodBeat.i(18815);
        ValueAnimator ofFloat = ValueAnimator.ofFloat((float) ColorUtil.getColorByMode(this.mKView.getBackgroundColor()), (float) ColorUtil.getColorByMode(dynamicColor));
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.kinda.framework.widget.base.KViewAnimatorProxy.AnonymousClass1 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(18808);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                KViewAnimatorProxy.this.mKView.setBackgroundColor(new DynamicColor((long) floatValue, 0));
                Log.d(MMKView.TAG, "已经给背景颜色设置动画KView：" + KViewAnimatorProxy.this.mKView + "，value：" + Long.toHexString(ColorUtil.absColor((long) floatValue)));
                AppMethodBeat.o(18808);
            }
        });
        KindaGlobalAnimator.addAnimator(ofFloat);
        AppMethodBeat.o(18815);
    }

    @Override // com.tencent.kinda.gen.KView
    public DynamicColor getBackgroundColor() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setAccessible(boolean z) {
    }

    @Override // com.tencent.kinda.gen.KView
    public boolean getAccessible() {
        return false;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setClickable(boolean z) {
    }

    @Override // com.tencent.kinda.gen.KView
    public boolean getClickable() {
        return false;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setVisible(Visible visible) {
    }

    @Override // com.tencent.kinda.gen.KView
    public Visible getVisible() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setBorderWidth(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getBorderWidth() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setBorderColor(DynamicColor dynamicColor) {
    }

    @Override // com.tencent.kinda.gen.KView
    public DynamicColor getBorderColor() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setBorderPressedColor(DynamicColor dynamicColor) {
    }

    @Override // com.tencent.kinda.gen.KView
    public DynamicColor getBorderPressedColor() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setCornerRadius(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getCornerRadius() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setTopLeftCornerRadius(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getTopLeftCornerRadius() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setTopRightCornerRadius(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getTopRightCornerRadius() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setBottomLeftCornerRadius(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getBottomLeftCornerRadius() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setBottomRightCornerRadius(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getBottomRightCornerRadius() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setShadowColor(DynamicColor dynamicColor) {
    }

    @Override // com.tencent.kinda.gen.KView
    public DynamicColor getShadowColor() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setShadowOffset(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getShadowOffset() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setShadowRadius(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getShadowRadius() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setAlpha(float f2) {
        AppMethodBeat.i(18816);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mKView, "alpha", this.mKView.getAlpha(), f2);
        ofFloat.setDuration(KindaGlobalAnimator.animateDuration());
        KindaGlobalAnimator.addAnimator(ofFloat);
        AppMethodBeat.o(18816);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getAlpha() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setTranslateX(float f2) {
        AppMethodBeat.i(18817);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mKView, "translateX", this.mKView.getTranslateX(), f2);
        ofFloat.setDuration(KindaGlobalAnimator.animateDuration());
        KindaGlobalAnimator.addAnimator(ofFloat);
        AppMethodBeat.o(18817);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getTranslateX() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setTranslateY(float f2) {
        AppMethodBeat.i(18818);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mKView, "translateY", this.mKView.getTranslateY(), f2);
        ofFloat.setDuration(KindaGlobalAnimator.animateDuration());
        KindaGlobalAnimator.addAnimator(ofFloat);
        AppMethodBeat.o(18818);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getTranslateY() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setRotation(float f2) {
        AppMethodBeat.i(18819);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mKView, "rotation", this.mKView.getRotation(), f2);
        ofFloat.setDuration(KindaGlobalAnimator.animateDuration());
        KindaGlobalAnimator.addAnimator(ofFloat);
        AppMethodBeat.o(18819);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getRotation() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setScaleX(float f2) {
        AppMethodBeat.i(18820);
        Log.d(MMKView.TAG, "setScaleX此时进入动画setter状态。");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mKView, "scaleX", this.mKView.getScaleX(), f2);
        ofFloat.setDuration(KindaGlobalAnimator.animateDuration());
        KindaGlobalAnimator.addAnimator(ofFloat);
        AppMethodBeat.o(18820);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getScaleX() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setScaleY(float f2) {
        AppMethodBeat.i(18821);
        Log.d(MMKView.TAG, "setScaleY此时进入动画setter状态。");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mKView, "scaleY", this.mKView.getScaleY(), f2);
        ofFloat.setDuration(KindaGlobalAnimator.animateDuration());
        KindaGlobalAnimator.addAnimator(ofFloat);
        AppMethodBeat.o(18821);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getScaleY() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setLeftPercent(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getLeftPercent() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setTopPercent(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getTopPercent() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setRightPercent(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getRightPercent() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setBottomPercent(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getBottomPercent() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setWidthPercent(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getWidthPercent() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setHeightPercent(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getHeightPercent() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setMarginLeftPercent(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getMarginLeftPercent() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setMarginTopPercent(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getMarginTopPercent() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setMarginRightPercent(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getMarginRightPercent() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setMarginBottomPercent(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getMarginBottomPercent() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setPaddingLeftPercent(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getPaddingLeftPercent() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setPaddingTopPercent(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getPaddingTopPercent() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setPaddingRightPercent(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getPaddingRightPercent() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setPaddingBottomPercent(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getPaddingBottomPercent() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setAlignSelf(Align align) {
    }

    @Override // com.tencent.kinda.gen.KView
    public Align getAlignSelf() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setFlexBasis(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getFlexBasis() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setPositionType(PositionType positionType) {
    }

    @Override // com.tencent.kinda.gen.KView
    public PositionType getPositionType() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setAspectRatio(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getAspectRatio() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setFlexGrow(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getFlexGrow() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setFlexShrink(float f2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public float getFlexShrink() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setEnableHighLight(boolean z) {
    }

    @Override // com.tencent.kinda.gen.KView
    public boolean getEnableHighLight() {
        return false;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setAccessibilityString(String str) {
    }

    @Override // com.tencent.kinda.gen.KView
    public String getAccessibilityString() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setOnClickCallback(KViewOnClickCallback kViewOnClickCallback) {
    }

    @Override // com.tencent.kinda.gen.KView
    public void setOnLongClickCallback(KViewOnLongClickCallback kViewOnLongClickCallback) {
    }

    @Override // com.tencent.kinda.gen.KView
    public void setOnTouchCallback(KViewOnTouchCallback kViewOnTouchCallback) {
    }

    @Override // com.tencent.kinda.gen.KView
    public void addBlurEffect(int i2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public void removeBlurEffect() {
    }

    @Override // com.tencent.kinda.gen.KView
    public KPoint convertPointToView(KPoint kPoint, KView kView) {
        return null;
    }

    @Override // com.tencent.kinda.gen.KView
    public KPoint convertPointToScreen(KPoint kPoint) {
        return null;
    }

    @Override // com.tencent.kinda.gen.KView
    public float getFrameOriginX() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public float getFrameOriginY() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public boolean getIsRefreshing() {
        return false;
    }

    @Override // com.tencent.kinda.gen.KView
    public void requestLayout() {
    }

    @Override // com.tencent.kinda.gen.KView
    public void setIsRefreshing(boolean z) {
    }
}
