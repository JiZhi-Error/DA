package com.tencent.kinda.framework.widget.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.yoga.android.YogaLayout;
import com.tencent.kinda.framework.animate.KindaGlobalAnimator;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.Align;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.IUIPagePlatformDelegate;
import com.tencent.kinda.gen.KPoint;
import com.tencent.kinda.gen.KView;
import com.tencent.kinda.gen.KViewOnClickCallback;
import com.tencent.kinda.gen.KViewOnLongClickCallback;
import com.tencent.kinda.gen.KViewOnTouchCallback;
import com.tencent.kinda.gen.PositionType;
import com.tencent.kinda.gen.TouchAction;
import com.tencent.kinda.gen.TouchEvent;
import com.tencent.kinda.gen.Visible;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;

public class MMKView<T extends View> extends ViewBase implements MMKViewBase<T>, KView {
    public static final String TAG = "base_MMKView";
    protected DynamicColor backgroundColor = new DynamicColor(0, 0);
    private Drawable backgroundDrawable;
    protected DynamicColor borderColor = new DynamicColor(0, 0);
    protected DynamicColor borderPressedColor = new DynamicColor(0, 0);
    protected float borderRadius;
    protected float borderWidth;
    private float bottomLeftBorderRadius = 0.0f;
    private float bottomRightBorderRadius = 0.0f;
    private String id;
    private MMKViewBackgroundBorderDrawable internalDrawable;
    private boolean isHighlight;
    private KViewAnimatorProxy mAnimatorProxy = new KViewAnimatorProxy(this);
    protected Context mContext;
    private KViewOnClickCallback onClickCallback;
    private KViewOnLongClickCallback onLongClickCallback;
    private KViewOnTouchCallback onTouchCallback;
    protected DynamicColor shadowColor = new DynamicColor(0, 0);
    protected float shadowOffset;
    protected float shadowRadius;
    private DynamicColor tmpSaveBgColor;
    private float topLeftBorderRadius = 0.0f;
    private float topRightBorderRadius = 0.0f;
    protected T view;

    static /* synthetic */ MMKViewBackgroundBorderDrawable access$200(MMKView mMKView) {
        AppMethodBeat.i(214567);
        MMKViewBackgroundBorderDrawable checkIfNeedCreateBorderDrawable = mMKView.checkIfNeedCreateBorderDrawable();
        AppMethodBeat.o(214567);
        return checkIfNeedCreateBorderDrawable;
    }

    public MMKView() {
        AppMethodBeat.i(19126);
        AppMethodBeat.o(19126);
    }

    private MMKViewBackgroundBorderDrawable checkIfNeedCreateBorderDrawable() {
        AppMethodBeat.i(19127);
        if (this.internalDrawable == null) {
            this.internalDrawable = new MMKViewBackgroundBorderDrawable(getView());
        }
        MMKViewBackgroundBorderDrawable mMKViewBackgroundBorderDrawable = this.internalDrawable;
        AppMethodBeat.o(19127);
        return mMKViewBackgroundBorderDrawable;
    }

    public T createView(Context context) {
        AppMethodBeat.i(19128);
        T t = (T) new View(context);
        AppMethodBeat.o(19128);
        return t;
    }

    @Override // com.tencent.kinda.framework.widget.base.MMKViewBase
    public final T getView() {
        return this.view;
    }

    @Override // com.tencent.kinda.gen.KView
    public final void initWithPlatformDelegate(IUIPagePlatformDelegate iUIPagePlatformDelegate) {
        AppMethodBeat.i(19129);
        if (iUIPagePlatformDelegate instanceof UIPagePlatformDelegateImpl) {
            setView(createView(((UIPagePlatformDelegateImpl) iUIPagePlatformDelegate).getContext()));
            this.mContext = MMApplicationContext.getContext();
        }
        AppMethodBeat.o(19129);
    }

    /* access modifiers changed from: protected */
    public final void setView(T t) {
        this.view = t;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setViewId(String str) {
        AppMethodBeat.i(19130);
        this.id = str;
        this.flexAttr.setTestId(str);
        MMKViewUtil.setId4KindaImplView(this.mContext, str, getView());
        AppMethodBeat.o(19130);
    }

    @Override // com.tencent.kinda.gen.KView
    public String getViewId() {
        AppMethodBeat.i(19131);
        if (Util.isNullOrNil(this.id)) {
            AppMethodBeat.o(19131);
            return "";
        }
        String str = this.id;
        AppMethodBeat.o(19131);
        return str;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setWidth(float f2) {
        AppMethodBeat.i(19132);
        if (KindaGlobalAnimator.hasAnimate()) {
            this.mAnimatorProxy.setWidth(f2);
            AppMethodBeat.o(19132);
            return;
        }
        this.flexAttr.setWidth(f2);
        AppMethodBeat.o(19132);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getWidth() {
        AppMethodBeat.i(19133);
        float width = this.flexAttr.getWidth();
        AppMethodBeat.o(19133);
        return width;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setHeight(float f2) {
        AppMethodBeat.i(19134);
        if (KindaGlobalAnimator.hasAnimate()) {
            this.mAnimatorProxy.setHeight(f2);
            AppMethodBeat.o(19134);
            return;
        }
        this.flexAttr.setHeight(f2);
        AppMethodBeat.o(19134);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getHeight() {
        AppMethodBeat.i(19135);
        float height = this.flexAttr.getHeight();
        AppMethodBeat.o(19135);
        return height;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setAlignSelf(Align align) {
        AppMethodBeat.i(19136);
        this.flexAttr.setAlignSelf(align);
        AppMethodBeat.o(19136);
    }

    @Override // com.tencent.kinda.gen.KView
    public Align getAlignSelf() {
        AppMethodBeat.i(19137);
        Align alignSelf = this.flexAttr.getAlignSelf();
        AppMethodBeat.o(19137);
        return alignSelf;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setFlexBasis(float f2) {
        AppMethodBeat.i(19138);
        this.flexAttr.setFlexBasis(f2);
        AppMethodBeat.o(19138);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getFlexBasis() {
        AppMethodBeat.i(19139);
        float flexBasis = this.flexAttr.getFlexBasis();
        AppMethodBeat.o(19139);
        return flexBasis;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setPositionType(PositionType positionType) {
        AppMethodBeat.i(19140);
        this.flexAttr.setPositionType(positionType);
        AppMethodBeat.o(19140);
    }

    @Override // com.tencent.kinda.gen.KView
    public PositionType getPositionType() {
        AppMethodBeat.i(19141);
        PositionType positionType = this.flexAttr.getPositionType();
        AppMethodBeat.o(19141);
        return positionType;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setLeft(float f2) {
        AppMethodBeat.i(19142);
        if (KindaGlobalAnimator.hasAnimate()) {
            this.mAnimatorProxy.setLeft(f2);
            AppMethodBeat.o(19142);
            return;
        }
        this.flexAttr.setLeft(f2);
        AppMethodBeat.o(19142);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getLeft() {
        AppMethodBeat.i(19143);
        if (isViewLayout()) {
            float pxToDp = MMKViewUtil.pxToDp(getView().getContext(), (float) getView().getLeft());
            AppMethodBeat.o(19143);
            return pxToDp;
        }
        float left = this.flexAttr.getLeft();
        AppMethodBeat.o(19143);
        return left;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setTop(float f2) {
        AppMethodBeat.i(19144);
        if (KindaGlobalAnimator.hasAnimate()) {
            this.mAnimatorProxy.setTop(f2);
            AppMethodBeat.o(19144);
            return;
        }
        this.flexAttr.setTop(f2);
        AppMethodBeat.o(19144);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getTop() {
        AppMethodBeat.i(19145);
        if (isViewLayout()) {
            float pxToDp = MMKViewUtil.pxToDp(getView().getContext(), (float) getView().getTop());
            AppMethodBeat.o(19145);
            return pxToDp;
        }
        float top = this.flexAttr.getTop();
        AppMethodBeat.o(19145);
        return top;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setRight(float f2) {
        AppMethodBeat.i(19146);
        if (KindaGlobalAnimator.hasAnimate()) {
            this.mAnimatorProxy.setRight(f2);
            AppMethodBeat.o(19146);
            return;
        }
        this.flexAttr.setRight(f2);
        AppMethodBeat.o(19146);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getRight() {
        AppMethodBeat.i(19147);
        if (isViewLayout()) {
            float pxToDp = MMKViewUtil.pxToDp(getView().getContext(), (float) getView().getRight());
            AppMethodBeat.o(19147);
            return pxToDp;
        }
        float right = this.flexAttr.getRight();
        AppMethodBeat.o(19147);
        return right;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setBottom(float f2) {
        AppMethodBeat.i(19148);
        if (KindaGlobalAnimator.hasAnimate()) {
            this.mAnimatorProxy.setBottom(f2);
            AppMethodBeat.o(19148);
            return;
        }
        this.flexAttr.setBottom(f2);
        AppMethodBeat.o(19148);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getBottom() {
        AppMethodBeat.i(19149);
        if (isViewLayout()) {
            float pxToDp = MMKViewUtil.pxToDp(getView().getContext(), (float) getView().getBottom());
            AppMethodBeat.o(19149);
            return pxToDp;
        }
        float bottom = this.flexAttr.getBottom();
        AppMethodBeat.o(19149);
        return bottom;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setMinWidth(float f2) {
        AppMethodBeat.i(19150);
        this.flexAttr.setMinWidth(f2);
        AppMethodBeat.o(19150);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getMinWidth() {
        AppMethodBeat.i(19151);
        float minWidth = this.flexAttr.getMinWidth();
        AppMethodBeat.o(19151);
        return minWidth;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setMaxWidth(float f2) {
        AppMethodBeat.i(19152);
        this.flexAttr.setMaxWidth(f2);
        AppMethodBeat.o(19152);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getMaxWidth() {
        AppMethodBeat.i(19153);
        float maxWidth = this.flexAttr.getMaxWidth();
        AppMethodBeat.o(19153);
        return maxWidth;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setMinHeight(float f2) {
        AppMethodBeat.i(19154);
        this.flexAttr.setMinHeight(f2);
        AppMethodBeat.o(19154);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getMinHeight() {
        AppMethodBeat.i(19155);
        float minHeight = this.flexAttr.getMinHeight();
        AppMethodBeat.o(19155);
        return minHeight;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setMaxHeight(float f2) {
        AppMethodBeat.i(19156);
        this.flexAttr.setMaxHeight(f2);
        AppMethodBeat.o(19156);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getMaxHeight() {
        AppMethodBeat.i(19157);
        float maxHeight = this.flexAttr.getMaxHeight();
        AppMethodBeat.o(19157);
        return maxHeight;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setAspectRatio(float f2) {
        AppMethodBeat.i(19158);
        this.flexAttr.setAspectRatio(f2);
        AppMethodBeat.o(19158);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getAspectRatio() {
        AppMethodBeat.i(19159);
        float aspectRatio = this.flexAttr.getAspectRatio();
        AppMethodBeat.o(19159);
        return aspectRatio;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setFlexGrow(float f2) {
        AppMethodBeat.i(19160);
        this.flexAttr.setFlexGrow(f2);
        AppMethodBeat.o(19160);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getFlexGrow() {
        AppMethodBeat.i(19161);
        float flexGrow = this.flexAttr.getFlexGrow();
        AppMethodBeat.o(19161);
        return flexGrow;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setFlexShrink(float f2) {
        AppMethodBeat.i(19162);
        this.flexAttr.setFlexShrink(f2);
        AppMethodBeat.o(19162);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getFlexShrink() {
        AppMethodBeat.i(19163);
        float flexShrink = this.flexAttr.getFlexShrink();
        AppMethodBeat.o(19163);
        return flexShrink;
    }

    @Override // com.tencent.kinda.gen.KView
    @SuppressLint({"ClickableViewAccessibility"})
    public void setEnableHighLight(boolean z) {
        AppMethodBeat.i(19164);
        this.isHighlight = z;
        if (getView() != null && this.isHighlight) {
            getView().setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.kinda.framework.widget.base.MMKView.AnonymousClass1 */

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(19121);
                    if (MMKView.this.isHighlight) {
                        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                            MMKView.this.tmpSaveBgColor = MMKView.this.backgroundColor;
                            MMKView.access$200(MMKView.this).setBackgroundColor(MMKView.this.mContext.getResources().getColor(R.color.x5));
                            MMKView.this.setViewBackground(MMKView.this.backgroundDrawable);
                        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                            MMKView.access$200(MMKView.this).setBackgroundColor((int) ColorUtil.getColorByMode(MMKView.this.tmpSaveBgColor));
                            MMKView.this.setViewBackground(MMKView.this.backgroundDrawable);
                        }
                    }
                    if (MMKView.this.onTouchCallback != null) {
                        TouchAction touchAction = TouchAction.DOWN;
                        switch (motionEvent.getAction()) {
                            case 0:
                                touchAction = TouchAction.DOWN;
                                break;
                            case 1:
                                touchAction = TouchAction.UP;
                                break;
                            case 2:
                                touchAction = TouchAction.MOVE;
                                break;
                        }
                        MMKView.this.onTouchCallback.onTouch(new TouchEvent(motionEvent.getX(), motionEvent.getY(), touchAction));
                    }
                    AppMethodBeat.o(19121);
                    return false;
                }
            });
        }
        AppMethodBeat.o(19164);
    }

    @Override // com.tencent.kinda.gen.KView
    public boolean getEnableHighLight() {
        return this.isHighlight;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setAlpha(float f2) {
        AppMethodBeat.i(19165);
        if (KindaGlobalAnimator.hasAnimate()) {
            this.mAnimatorProxy.setAlpha(f2);
            AppMethodBeat.o(19165);
            return;
        }
        getView().setAlpha(f2);
        AppMethodBeat.o(19165);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getAlpha() {
        AppMethodBeat.i(19166);
        float alpha = getView().getAlpha();
        AppMethodBeat.o(19166);
        return alpha;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setTranslateX(float f2) {
        AppMethodBeat.i(19167);
        if (KindaGlobalAnimator.hasAnimate()) {
            this.mAnimatorProxy.setTranslateX(f2);
            AppMethodBeat.o(19167);
            return;
        }
        getView().setTranslationX(f2);
        AppMethodBeat.o(19167);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getTranslateX() {
        AppMethodBeat.i(19168);
        float translationX = getView().getTranslationX();
        AppMethodBeat.o(19168);
        return translationX;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setTranslateY(float f2) {
        AppMethodBeat.i(19169);
        if (KindaGlobalAnimator.hasAnimate()) {
            this.mAnimatorProxy.setTranslateY(f2);
            AppMethodBeat.o(19169);
            return;
        }
        getView().setTranslationY(f2);
        AppMethodBeat.o(19169);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getTranslateY() {
        AppMethodBeat.i(19170);
        float translationY = getView().getTranslationY();
        AppMethodBeat.o(19170);
        return translationY;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setRotation(float f2) {
        AppMethodBeat.i(19171);
        if (KindaGlobalAnimator.hasAnimate()) {
            this.mAnimatorProxy.setRotation(f2);
            AppMethodBeat.o(19171);
            return;
        }
        getView().setRotation(f2);
        AppMethodBeat.o(19171);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getRotation() {
        AppMethodBeat.i(19172);
        float rotation = getView().getRotation();
        AppMethodBeat.o(19172);
        return rotation;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setScaleX(float f2) {
        AppMethodBeat.i(19173);
        if (KindaGlobalAnimator.hasAnimate()) {
            this.mAnimatorProxy.setScaleX(f2);
            AppMethodBeat.o(19173);
            return;
        }
        getView().setScaleX(f2);
        AppMethodBeat.o(19173);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getScaleX() {
        AppMethodBeat.i(19174);
        float scaleX = getView().getScaleX();
        AppMethodBeat.o(19174);
        return scaleX;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setScaleY(float f2) {
        AppMethodBeat.i(19175);
        if (KindaGlobalAnimator.hasAnimate()) {
            this.mAnimatorProxy.setScaleY(f2);
            AppMethodBeat.o(19175);
            return;
        }
        getView().setScaleY(f2);
        AppMethodBeat.o(19175);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getScaleY() {
        AppMethodBeat.i(19176);
        float scaleY = getView().getScaleY();
        AppMethodBeat.o(19176);
        return scaleY;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setLeftPercent(float f2) {
        AppMethodBeat.i(19177);
        this.flexAttr.setLeftPercent(f2);
        AppMethodBeat.o(19177);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getLeftPercent() {
        AppMethodBeat.i(19178);
        float leftPercent = this.flexAttr.getLeftPercent();
        AppMethodBeat.o(19178);
        return leftPercent;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setTopPercent(float f2) {
        AppMethodBeat.i(19179);
        this.flexAttr.setTopPercent(f2);
        AppMethodBeat.o(19179);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getTopPercent() {
        AppMethodBeat.i(19180);
        float topPercent = this.flexAttr.getTopPercent();
        AppMethodBeat.o(19180);
        return topPercent;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setRightPercent(float f2) {
        AppMethodBeat.i(19181);
        this.flexAttr.setRightPercent(f2);
        AppMethodBeat.o(19181);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getRightPercent() {
        AppMethodBeat.i(19182);
        float rightPercent = this.flexAttr.getRightPercent();
        AppMethodBeat.o(19182);
        return rightPercent;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setBottomPercent(float f2) {
        AppMethodBeat.i(19183);
        this.flexAttr.setBottomPercent(f2);
        AppMethodBeat.o(19183);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getBottomPercent() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setWidthPercent(float f2) {
        AppMethodBeat.i(19184);
        this.flexAttr.setWidthPercent(f2);
        AppMethodBeat.o(19184);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getWidthPercent() {
        AppMethodBeat.i(19185);
        float widthPercent = this.flexAttr.getWidthPercent();
        AppMethodBeat.o(19185);
        return widthPercent;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setHeightPercent(float f2) {
        AppMethodBeat.i(19186);
        this.flexAttr.setHeightPercent(f2);
        AppMethodBeat.o(19186);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getHeightPercent() {
        AppMethodBeat.i(19187);
        float heightPercent = this.flexAttr.getHeightPercent();
        AppMethodBeat.o(19187);
        return heightPercent;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setMarginLeftPercent(float f2) {
        AppMethodBeat.i(19188);
        this.flexAttr.setMarginLeftPercent(f2);
        AppMethodBeat.o(19188);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getMarginLeftPercent() {
        AppMethodBeat.i(19189);
        float marginLeftPercent = this.flexAttr.getMarginLeftPercent();
        AppMethodBeat.o(19189);
        return marginLeftPercent;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setMarginTopPercent(float f2) {
        AppMethodBeat.i(19190);
        this.flexAttr.setMarginTopPercent(f2);
        AppMethodBeat.o(19190);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getMarginTopPercent() {
        AppMethodBeat.i(19191);
        float marginTopPercent = this.flexAttr.getMarginTopPercent();
        AppMethodBeat.o(19191);
        return marginTopPercent;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setMarginRightPercent(float f2) {
        AppMethodBeat.i(19192);
        this.flexAttr.setMarginRightPercent(f2);
        AppMethodBeat.o(19192);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getMarginRightPercent() {
        AppMethodBeat.i(19193);
        float marginRightPercent = this.flexAttr.getMarginRightPercent();
        AppMethodBeat.o(19193);
        return marginRightPercent;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setMarginBottomPercent(float f2) {
        AppMethodBeat.i(19194);
        this.flexAttr.setMarginBottomPercent(f2);
        AppMethodBeat.o(19194);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getMarginBottomPercent() {
        AppMethodBeat.i(19195);
        float marginBottomPercent = this.flexAttr.getMarginBottomPercent();
        AppMethodBeat.o(19195);
        return marginBottomPercent;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setPaddingLeftPercent(float f2) {
        AppMethodBeat.i(19196);
        this.flexAttr.setPaddingLeftPercent(f2);
        AppMethodBeat.o(19196);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getPaddingLeftPercent() {
        AppMethodBeat.i(19197);
        float paddingLeftPercent = this.flexAttr.getPaddingLeftPercent();
        AppMethodBeat.o(19197);
        return paddingLeftPercent;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setPaddingTopPercent(float f2) {
        AppMethodBeat.i(19198);
        this.flexAttr.setPaddingTopPercent(f2);
        AppMethodBeat.o(19198);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getPaddingTopPercent() {
        AppMethodBeat.i(19199);
        float paddingTopPercent = this.flexAttr.getPaddingTopPercent();
        AppMethodBeat.o(19199);
        return paddingTopPercent;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setPaddingRightPercent(float f2) {
        AppMethodBeat.i(19200);
        this.flexAttr.setPaddingRightPercent(f2);
        AppMethodBeat.o(19200);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getPaddingRightPercent() {
        AppMethodBeat.i(19201);
        float paddingRightPercent = this.flexAttr.getPaddingRightPercent();
        AppMethodBeat.o(19201);
        return paddingRightPercent;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setPaddingBottomPercent(float f2) {
        AppMethodBeat.i(19202);
        this.flexAttr.setPaddingBottomPercent(f2);
        AppMethodBeat.o(19202);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getPaddingBottomPercent() {
        AppMethodBeat.i(19203);
        float paddingBottomPercent = this.flexAttr.getPaddingBottomPercent();
        AppMethodBeat.o(19203);
        return paddingBottomPercent;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setMarginLeft(float f2) {
        AppMethodBeat.i(19204);
        if (KindaGlobalAnimator.hasAnimate()) {
            this.mAnimatorProxy.setMarginLeft(f2);
            AppMethodBeat.o(19204);
            return;
        }
        this.flexAttr.setMarginLeft(f2);
        if (getView().getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) getView().getLayoutParams()).leftMargin = (int) MMKViewUtil.dpToPx(this.mContext, getMarginLeft());
        }
        AppMethodBeat.o(19204);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getMarginLeft() {
        AppMethodBeat.i(19205);
        float marginLeft = this.flexAttr.getMarginLeft();
        AppMethodBeat.o(19205);
        return marginLeft;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setMarginTop(float f2) {
        AppMethodBeat.i(19206);
        if (KindaGlobalAnimator.hasAnimate()) {
            this.mAnimatorProxy.setMarginTop(f2);
            AppMethodBeat.o(19206);
            return;
        }
        this.flexAttr.setMarginTop(f2);
        if (getView().getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) getView().getLayoutParams()).topMargin = (int) MMKViewUtil.dpToPx(this.mContext, getMarginTop());
        }
        AppMethodBeat.o(19206);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getMarginTop() {
        AppMethodBeat.i(19207);
        float marginTop = this.flexAttr.getMarginTop();
        AppMethodBeat.o(19207);
        return marginTop;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setMarginRight(float f2) {
        AppMethodBeat.i(19208);
        if (KindaGlobalAnimator.hasAnimate()) {
            this.mAnimatorProxy.setMarginRight(f2);
            AppMethodBeat.o(19208);
            return;
        }
        this.flexAttr.setMarginRight(f2);
        if (getView().getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) getView().getLayoutParams()).rightMargin = (int) MMKViewUtil.dpToPx(this.mContext, getMarginRight());
        }
        AppMethodBeat.o(19208);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getMarginRight() {
        AppMethodBeat.i(19209);
        float marginRight = this.flexAttr.getMarginRight();
        AppMethodBeat.o(19209);
        return marginRight;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setMarginBottom(float f2) {
        AppMethodBeat.i(19210);
        if (KindaGlobalAnimator.hasAnimate()) {
            this.mAnimatorProxy.setMarginBottom(f2);
            AppMethodBeat.o(19210);
            return;
        }
        this.flexAttr.setMarginBottom(f2);
        if (getView().getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) getView().getLayoutParams()).bottomMargin = (int) MMKViewUtil.dpToPx(this.mContext, getMarginBottom());
        }
        AppMethodBeat.o(19210);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getMarginBottom() {
        AppMethodBeat.i(19211);
        float marginBottom = this.flexAttr.getMarginBottom();
        AppMethodBeat.o(19211);
        return marginBottom;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setPaddingLeft(float f2) {
        AppMethodBeat.i(19212);
        this.flexAttr.setPaddingLeft(f2);
        AppMethodBeat.o(19212);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getPaddingLeft() {
        AppMethodBeat.i(19213);
        float paddingLeft = this.flexAttr.getPaddingLeft();
        AppMethodBeat.o(19213);
        return paddingLeft;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setPaddingTop(float f2) {
        AppMethodBeat.i(19214);
        this.flexAttr.setPaddingTop(f2);
        AppMethodBeat.o(19214);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getPaddingTop() {
        AppMethodBeat.i(19215);
        float paddingTop = this.flexAttr.getPaddingTop();
        AppMethodBeat.o(19215);
        return paddingTop;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setPaddingRight(float f2) {
        AppMethodBeat.i(19216);
        this.flexAttr.setPaddingRight(f2);
        AppMethodBeat.o(19216);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getPaddingRight() {
        AppMethodBeat.i(19217);
        float paddingRight = this.flexAttr.getPaddingRight();
        AppMethodBeat.o(19217);
        return paddingRight;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setPaddingBottom(float f2) {
        AppMethodBeat.i(19218);
        this.flexAttr.setPaddingBottom(f2);
        AppMethodBeat.o(19218);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getPaddingBottom() {
        AppMethodBeat.i(19219);
        float paddingBottom = this.flexAttr.getPaddingBottom();
        AppMethodBeat.o(19219);
        return paddingBottom;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setBackgroundColor(DynamicColor dynamicColor) {
        AppMethodBeat.i(19220);
        if (KindaGlobalAnimator.hasAnimate()) {
            Log.d(TAG, "进入动画setBackgroundColor，KView：" + this + "，value：" + Long.toHexString(ColorUtil.absColor(ColorUtil.getColorByMode(dynamicColor))));
            this.mAnimatorProxy.setBackgroundColor(dynamicColor);
            AppMethodBeat.o(19220);
            return;
        }
        Log.d(TAG, "进入View设置属性的setBackgroundColor，KView：" + this + "，value：" + Long.toHexString(ColorUtil.absColor(ColorUtil.getColorByMode(dynamicColor))));
        this.backgroundColor = dynamicColor;
        if (ColorUtil.getColorByMode(this.backgroundColor) >= 0) {
            checkIfNeedCreateBorderDrawable().setBackgroundColor(MMKViewUtil.argbColor(ColorUtil.getColorByMode(this.backgroundColor)));
            setViewBackground(this.backgroundDrawable);
        }
        AppMethodBeat.o(19220);
    }

    @Override // com.tencent.kinda.gen.KView
    public DynamicColor getBackgroundColor() {
        return this.backgroundColor;
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
        AppMethodBeat.i(19221);
        getView().setClickable(z);
        AppMethodBeat.o(19221);
    }

    @Override // com.tencent.kinda.gen.KView
    public boolean getClickable() {
        AppMethodBeat.i(19222);
        boolean isClickable = getView().isClickable();
        AppMethodBeat.o(19222);
        return isClickable;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setVisible(Visible visible) {
        AppMethodBeat.i(19223);
        switch (visible) {
            case VISIBLE:
                getView().setVisibility(0);
                this.flexAttr.setVisibility(0);
                resumeYogaNode();
                break;
            case INVISIBLE:
                getView().setVisibility(4);
                this.flexAttr.setVisibility(4);
                break;
            case GONE:
                getView().setVisibility(8);
                this.flexAttr.setVisibility(8);
                removeYogaNode();
                break;
        }
        notifyChanged();
        AppMethodBeat.o(19223);
    }

    private void removeYogaNode() {
        AppMethodBeat.i(19224);
        if (node().getParent() != null) {
            node().getParent().removeChildAt(node().getParent().indexOf(node()));
        }
        AppMethodBeat.o(19224);
    }

    private void resumeYogaNode() {
        AppMethodBeat.i(19225);
        if (node().getParent() != null) {
            AppMethodBeat.o(19225);
            return;
        }
        if (getView().getParent() != null && (getView().getParent() instanceof YogaLayout)) {
            YogaLayout yogaLayout = (YogaLayout) getView().getParent();
            yogaLayout.getYogaNode().addChildAt(node(), yogaLayout.indexOfChild(getView()));
        }
        AppMethodBeat.o(19225);
    }

    @Override // com.tencent.kinda.gen.KView
    public Visible getVisible() {
        AppMethodBeat.i(19226);
        switch (getView().getVisibility()) {
            case 0:
                Visible visible = Visible.VISIBLE;
                AppMethodBeat.o(19226);
                return visible;
            case 4:
                Visible visible2 = Visible.INVISIBLE;
                AppMethodBeat.o(19226);
                return visible2;
            case 8:
                Visible visible3 = Visible.GONE;
                AppMethodBeat.o(19226);
                return visible3;
            default:
                Visible visible4 = Visible.VISIBLE;
                AppMethodBeat.o(19226);
                return visible4;
        }
    }

    @Override // com.tencent.kinda.gen.KView
    public void setBorderWidth(float f2) {
        AppMethodBeat.i(19227);
        this.borderWidth = f2;
        if (this.borderWidth > 0.0f) {
            checkIfNeedCreateBorderDrawable().setBorderWidth((float) a.fromDPToPix(MMApplicationContext.getContext(), (int) f2));
            setViewBackground(this.backgroundDrawable);
        }
        AppMethodBeat.o(19227);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getBorderWidth() {
        return this.borderWidth;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setBorderColor(DynamicColor dynamicColor) {
        AppMethodBeat.i(19228);
        this.borderColor = dynamicColor;
        if (ColorUtil.getColorByMode(this.borderColor) >= 0) {
            checkIfNeedCreateBorderDrawable().setBorderColor(MMKViewUtil.argbColor(ColorUtil.getColorByMode(this.borderColor)));
            setViewBackground(this.backgroundDrawable);
        }
        AppMethodBeat.o(19228);
    }

    @Override // com.tencent.kinda.gen.KView
    public DynamicColor getBorderColor() {
        return this.borderColor;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setBorderPressedColor(DynamicColor dynamicColor) {
        AppMethodBeat.i(19229);
        this.borderPressedColor = dynamicColor;
        if (ColorUtil.getColorByMode(this.borderPressedColor) >= 0) {
            checkIfNeedCreateBorderDrawable().setBorderPressedColor(MMKViewUtil.argbColor(ColorUtil.getColorByMode(this.borderPressedColor)));
            setViewBackground(this.backgroundDrawable);
        }
        AppMethodBeat.o(19229);
    }

    @Override // com.tencent.kinda.gen.KView
    public DynamicColor getBorderPressedColor() {
        return this.borderPressedColor;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setCornerRadius(float f2) {
        AppMethodBeat.i(19230);
        this.borderRadius = f2;
        if (this.borderRadius >= 0.0f) {
            checkIfNeedCreateBorderDrawable().setBorderRadius((float) a.fromDPToPix(MMApplicationContext.getContext(), (int) this.borderRadius));
            setViewBackground(this.backgroundDrawable);
        }
        AppMethodBeat.o(19230);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getCornerRadius() {
        return this.borderRadius;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setTopLeftCornerRadius(float f2) {
        AppMethodBeat.i(19231);
        this.topLeftBorderRadius = f2;
        if (this.topLeftBorderRadius >= 0.0f) {
            checkIfNeedCreateBorderDrawable().setTopLeftBorderRadius((float) a.fromDPToPix(MMApplicationContext.getContext(), (int) this.topLeftBorderRadius));
        }
        AppMethodBeat.o(19231);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getTopLeftCornerRadius() {
        return this.topLeftBorderRadius;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setTopRightCornerRadius(float f2) {
        AppMethodBeat.i(19232);
        this.topRightBorderRadius = f2;
        if (this.topRightBorderRadius >= 0.0f) {
            checkIfNeedCreateBorderDrawable().setTopRightBorderRadius((float) a.fromDPToPix(MMApplicationContext.getContext(), (int) this.topRightBorderRadius));
        }
        AppMethodBeat.o(19232);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getTopRightCornerRadius() {
        return this.topRightBorderRadius;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setBottomLeftCornerRadius(float f2) {
        AppMethodBeat.i(19233);
        this.bottomLeftBorderRadius = f2;
        if (this.bottomLeftBorderRadius >= 0.0f) {
            checkIfNeedCreateBorderDrawable().setBottomLeftBorderRadius((float) a.fromDPToPix(MMApplicationContext.getContext(), (int) this.bottomLeftBorderRadius));
        }
        AppMethodBeat.o(19233);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getBottomLeftCornerRadius() {
        return this.bottomLeftBorderRadius;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setBottomRightCornerRadius(float f2) {
        AppMethodBeat.i(19234);
        this.bottomRightBorderRadius = f2;
        if (this.bottomRightBorderRadius >= 0.0f) {
            checkIfNeedCreateBorderDrawable().setBottomRightBorderRadius((float) a.fromDPToPix(MMApplicationContext.getContext(), (int) this.bottomRightBorderRadius));
        }
        AppMethodBeat.o(19234);
    }

    @Override // com.tencent.kinda.gen.KView
    public float getBottomRightCornerRadius() {
        return this.bottomRightBorderRadius;
    }

    @Override // com.tencent.kinda.gen.KView
    public void setShadowColor(DynamicColor dynamicColor) {
        this.shadowColor = dynamicColor;
    }

    @Override // com.tencent.kinda.gen.KView
    public DynamicColor getShadowColor() {
        return this.shadowColor;
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
    public void setOnClickCallback(KViewOnClickCallback kViewOnClickCallback) {
        AppMethodBeat.i(19235);
        this.onClickCallback = kViewOnClickCallback;
        getView().setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.kinda.framework.widget.base.MMKView.AnonymousClass2 */
            private byte _hellAccFlag_;

            public void onClick(View view) {
                AppMethodBeat.i(19122);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/kinda/framework/widget/base/MMKView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (MMKView.this.onClickCallback != null) {
                    MMKView.this.onClickCallback.onClick(MMKView.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/kinda/framework/widget/base/MMKView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(19122);
            }
        });
        AppMethodBeat.o(19235);
    }

    @Override // com.tencent.kinda.gen.KView
    public void setOnLongClickCallback(KViewOnLongClickCallback kViewOnLongClickCallback) {
        AppMethodBeat.i(19236);
        this.onLongClickCallback = kViewOnLongClickCallback;
        getView().setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.tencent.kinda.framework.widget.base.MMKView.AnonymousClass3 */
            private byte _hellAccFlag_;

            public boolean onLongClick(View view) {
                AppMethodBeat.i(19123);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/kinda/framework/widget/base/MMKView$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                if (MMKView.this.onLongClickCallback != null) {
                    MMKView.this.onLongClickCallback.onLongClick(MMKView.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/kinda/framework/widget/base/MMKView$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(19123);
                return false;
            }
        });
        AppMethodBeat.o(19236);
    }

    @Override // com.tencent.kinda.gen.KView
    public void setOnTouchCallback(KViewOnTouchCallback kViewOnTouchCallback) {
        AppMethodBeat.i(19237);
        this.onTouchCallback = kViewOnTouchCallback;
        if (getView() != null) {
            getView().setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.kinda.framework.widget.base.MMKView.AnonymousClass4 */

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(19124);
                    if (MMKView.this.onTouchCallback != null) {
                        TouchAction touchAction = TouchAction.DOWN;
                        switch (motionEvent.getAction()) {
                            case 0:
                                touchAction = TouchAction.DOWN;
                                break;
                            case 1:
                                touchAction = TouchAction.UP;
                                break;
                            case 2:
                                touchAction = TouchAction.MOVE;
                                break;
                        }
                        MMKView.this.onTouchCallback.onTouch(new TouchEvent(motionEvent.getX(), motionEvent.getY(), touchAction));
                    }
                    AppMethodBeat.o(19124);
                    return false;
                }
            });
        }
        AppMethodBeat.o(19237);
    }

    /* access modifiers changed from: protected */
    public void setViewBackground(Drawable drawable) {
        AppMethodBeat.i(19238);
        this.backgroundDrawable = drawable;
        if (this.backgroundDrawable == null && this.internalDrawable != null) {
            getView().setBackground(this.internalDrawable);
            AppMethodBeat.o(19238);
        } else if (this.internalDrawable != null || this.backgroundDrawable == null) {
            if (this.internalDrawable != null) {
                this.internalDrawable.setInsetDrawable(this.backgroundDrawable);
                getView().setBackground(this.internalDrawable);
            }
            AppMethodBeat.o(19238);
        } else {
            getView().setBackground(this.backgroundDrawable);
            AppMethodBeat.o(19238);
        }
    }

    /* access modifiers changed from: protected */
    public void notifyChanged() {
        AppMethodBeat.i(19239);
        if (node().isMeasureDefined() && !node().isDirty()) {
            node().dirty();
        }
        getView().requestLayout();
        AppMethodBeat.o(19239);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.kinda.framework.widget.base.ViewBase
    public void onFlexAttribute() {
        AppMethodBeat.i(19240);
        notifyChanged();
        AppMethodBeat.o(19240);
    }

    @Override // com.tencent.kinda.gen.KView
    public void setAccessibilityString(String str) {
        AppMethodBeat.i(19241);
        getView().setContentDescription(str);
        AppMethodBeat.o(19241);
    }

    @Override // com.tencent.kinda.gen.KView
    public String getAccessibilityString() {
        AppMethodBeat.i(19242);
        if (getView().getContentDescription() == null) {
            AppMethodBeat.o(19242);
            return "";
        }
        String str = (String) getView().getContentDescription();
        AppMethodBeat.o(19242);
        return str;
    }

    @Override // com.tencent.kinda.gen.KView
    public void addBlurEffect(int i2) {
    }

    @Override // com.tencent.kinda.gen.KView
    public void removeBlurEffect() {
    }

    @Override // com.tencent.kinda.gen.KView
    public KPoint convertPointToView(KPoint kPoint, KView kView) {
        AppMethodBeat.i(19243);
        if (kPoint == null || getView() == null || getView().getContext() == null) {
            Log.e(TAG, "%s call convertPointToView params illegal! point: %s, getView(): %s.", this, kPoint, getView());
            KPoint kPoint2 = new KPoint(0.0f, 0.0f);
            AppMethodBeat.o(19243);
            return kPoint2;
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        getView().getLocationOnScreen(iArr);
        if (kView == null) {
            iArr2[1] = ao.getStatusBarHeight(getView().getContext());
        } else {
            ((MMKView) kView).getView().getLocationOnScreen(iArr2);
        }
        KPoint kPoint3 = new KPoint(MMKViewUtil.pxToDp(getView().getContext(), ((float) (iArr[0] - iArr2[0])) + kPoint.mX), MMKViewUtil.pxToDp(getView().getContext(), ((float) (iArr[1] - iArr2[1])) + kPoint.mY));
        AppMethodBeat.o(19243);
        return kPoint3;
    }

    @Override // com.tencent.kinda.gen.KView
    public float getFrameOriginX() {
        AppMethodBeat.i(214565);
        if (getView() == null || getView().getContext() == null) {
            Log.e(TAG, "%s call convertPointToView params illegal!, getView(): %s.", this, getView());
            AppMethodBeat.o(214565);
            return 0.0f;
        }
        Log.i(TAG, " get getFrameOriginX getView().getLeft(): %s.", Integer.valueOf(getView().getLeft()));
        float E = (float) a.E(getView().getContext(), getView().getLeft());
        AppMethodBeat.o(214565);
        return E;
    }

    @Override // com.tencent.kinda.gen.KView
    public float getFrameOriginY() {
        AppMethodBeat.i(214566);
        if (getView() == null || getView().getContext() == null) {
            Log.e(TAG, "%s call convertPointToView params illegal!, getView(): %s.", this, getView());
            AppMethodBeat.o(214566);
            return 0.0f;
        }
        Log.i(TAG, " get getFrameOriginY getView().getTop(): %s.", Integer.valueOf(getView().getTop()));
        float E = (float) a.E(getView().getContext(), getView().getTop());
        AppMethodBeat.o(214566);
        return E;
    }

    @Override // com.tencent.kinda.gen.KView
    public KPoint convertPointToScreen(KPoint kPoint) {
        AppMethodBeat.i(19244);
        KPoint convertPointToView = convertPointToView(kPoint, null);
        AppMethodBeat.o(19244);
        return convertPointToView;
    }

    private boolean isViewLayout() {
        AppMethodBeat.i(19245);
        T view2 = getView();
        if (view2 == null) {
            AppMethodBeat.o(19245);
            return false;
        } else if (view2.getLeft() == 0 && view2.getTop() == 0 && view2.getRight() == 0 && view2.getBottom() == 0) {
            AppMethodBeat.o(19245);
            return false;
        } else {
            AppMethodBeat.o(19245);
            return true;
        }
    }

    public KViewOnClickCallback getOnClickCallback() {
        return this.onClickCallback;
    }

    @Override // com.tencent.kinda.gen.KView
    public void requestLayout() {
    }

    @Override // com.tencent.kinda.gen.KView
    public void setIsRefreshing(boolean z) {
    }

    @Override // com.tencent.kinda.gen.KView
    public boolean getIsRefreshing() {
        return false;
    }
}
