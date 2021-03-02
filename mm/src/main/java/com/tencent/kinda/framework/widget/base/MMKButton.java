package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.FontStyle;
import com.tencent.kinda.gen.KButton;
import com.tencent.kinda.gen.KImage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;

public class MMKButton extends MMKView<KindaButtonImpl> implements KButton {
    public static final String TAG = "MMKView.MMKButton";
    private long disabledColor = -1;
    private MMKImage disabledImage;
    private FontStyle fontStyle = FontStyle.REGULAR;
    private boolean isEnableHighlight = true;
    private DynamicColor normalColor = new DynamicColor(-1, 0);
    private MMKImage normalImage;
    private long pressedColor = -1;
    private MMKImage pressedImage;
    private long selectedColor = -1;
    private MMKImage selectedImage;
    private long textDisabledColor = -1;
    private String textFontName;
    private DynamicColor textNormalColor = new DynamicColor(-1, 0);
    private long textPressedColor = -1;
    private long textSelectedColor = -1;
    private float textSize;

    public MMKButton() {
        AppMethodBeat.i(18995);
        AppMethodBeat.o(18995);
    }

    @Override // com.tencent.kinda.framework.widget.base.MMKView
    public KindaButtonImpl createView(Context context) {
        AppMethodBeat.i(18996);
        KindaButtonImpl kindaButtonImpl = new KindaButtonImpl(context);
        kindaButtonImpl.setClickable(true);
        kindaButtonImpl.setEnabled(true);
        AppMethodBeat.o(18996);
        return kindaButtonImpl;
    }

    @Override // com.tencent.kinda.gen.KButton
    public void setText(String str) {
        AppMethodBeat.i(18997);
        if (str != null) {
            ((KindaButtonImpl) getView()).setText(str);
        }
        AppMethodBeat.o(18997);
    }

    @Override // com.tencent.kinda.gen.KButton
    public String getText() {
        AppMethodBeat.i(18998);
        if (((KindaButtonImpl) getView()).getText() != null) {
            String charSequence = ((KindaButtonImpl) getView()).getText().toString();
            AppMethodBeat.o(18998);
            return charSequence;
        }
        AppMethodBeat.o(18998);
        return null;
    }

    @Override // com.tencent.kinda.gen.KButton
    public void setNormalColor(DynamicColor dynamicColor) {
        AppMethodBeat.i(18999);
        if (ColorUtil.getColorByModeNoCompat(this.normalColor) != ColorUtil.getColorByMode(dynamicColor)) {
            this.normalColor = dynamicColor;
            if (ColorUtil.getColorByModeNoCompat(dynamicColor) != 0) {
                this.pressedColor = ColorUtil.MergeColors(ColorUtil.getColorByModeNoCompat(dynamicColor), 436207616);
                if (ColorUtil.ifCompatKindaDarkModeDefaultColor()) {
                    this.disabledColor = Long.parseLong("14FFFFFF", 16);
                } else {
                    this.disabledColor = ColorUtil.MergeColors(ColorUtil.getColorByModeNoCompat(dynamicColor), 2583691263L);
                }
            }
            updateBackgroundWithColor();
            Log.i(TAG, "MMKButton[" + getText() + "] setNormalColor设置完成后，normalColor：" + this.normalColor + "，pressedColor：" + this.pressedColor + "，disabledColor：" + this.disabledColor);
            AppMethodBeat.o(18999);
            return;
        }
        Log.i(TAG, "MMKButton[" + getText() + "] setNormalColor设置相同值。");
        AppMethodBeat.o(18999);
    }

    @Override // com.tencent.kinda.gen.KButton
    public DynamicColor getNormalColor() {
        return this.normalColor;
    }

    @Override // com.tencent.kinda.gen.KButton
    public void setTextSize(float f2) {
        AppMethodBeat.i(19000);
        this.textSize = f2;
        if (f2 > 0.0f) {
            ((KindaButtonImpl) getView()).setTextSize(0, MMKViewUtil.dpToPx(MMApplicationContext.getContext(), f2));
        }
        AppMethodBeat.o(19000);
    }

    @Override // com.tencent.kinda.gen.KButton
    public float getTextSize() {
        return this.textSize;
    }

    public void setTextFont(String str) {
        AppMethodBeat.i(19001);
        if (str != null) {
            this.textFontName = str;
            ((KindaButtonImpl) getView()).setTextFont(Typeface.createFromAsset(MMApplicationContext.getContext().getAssets(), str));
            notifyChanged();
        }
        AppMethodBeat.o(19001);
    }

    public String getTextFont() {
        return this.textFontName;
    }

    @Override // com.tencent.kinda.gen.KButton
    public void setTextNormalColor(DynamicColor dynamicColor) {
        AppMethodBeat.i(19002);
        if (ColorUtil.getColorByModeNoCompat(this.textNormalColor) != ColorUtil.getColorByMode(dynamicColor, ColorUtil.MMViewType.MMKButtonText)) {
            this.textNormalColor = dynamicColor;
            long colorByModeNoCompat = 2566914048L | (ColorUtil.getColorByModeNoCompat(dynamicColor) & 16777215);
            this.textPressedColor = colorByModeNoCompat;
            this.textDisabledColor = colorByModeNoCompat;
            Log.d(TAG, "100mango pressedColor" + Long.toString(this.textPressedColor) + "disableColor" + Long.toString(this.textDisabledColor));
            Log.d(TAG, "100mango pressedColor" + Long.toHexString(this.textPressedColor) + "disableColor" + Long.toHexString(this.textDisabledColor));
            updateTextColor();
        }
        AppMethodBeat.o(19002);
    }

    @Override // com.tencent.kinda.gen.KButton
    public DynamicColor getTextNormalColor() {
        return this.textNormalColor;
    }

    private void updateTextColor() {
        AppMethodBeat.i(19003);
        if (ColorUtil.getColorByModeNoCompat(this.textNormalColor) >= 0 || this.textSelectedColor >= 0 || this.textPressedColor >= 0 || this.textDisabledColor >= 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (this.textSelectedColor >= 0) {
                arrayList.add(new int[]{16842913});
                arrayList2.add(Integer.valueOf(MMKViewUtil.argbColor(this.textSelectedColor)));
            }
            if (this.isEnableHighlight && this.textPressedColor >= 0) {
                arrayList.add(new int[]{16842919});
                arrayList2.add(Integer.valueOf(MMKViewUtil.argbColor(this.textPressedColor)));
            }
            if (this.textDisabledColor >= 0) {
                arrayList.add(new int[]{-16842910});
                arrayList2.add(Integer.valueOf(MMKViewUtil.argbColor(this.textDisabledColor)));
            }
            if (ColorUtil.getColorByModeNoCompat(this.textNormalColor) >= 0) {
                arrayList.add(new int[0]);
                arrayList2.add(Integer.valueOf(MMKViewUtil.argbColor(ColorUtil.getColorByModeNoCompat(this.textNormalColor))));
            }
            int[] iArr = new int[arrayList2.size()];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr[i2] = ((Integer) arrayList2.get(i2)).intValue();
            }
            int[][] iArr2 = new int[arrayList.size()][];
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                iArr2[i3] = (int[]) arrayList.get(i3);
            }
            ((KindaButtonImpl) getView()).setTextColor(new ColorStateList(iArr2, iArr));
        }
        AppMethodBeat.o(19003);
    }

    @Override // com.tencent.kinda.gen.KButton
    public void setNormalImage(KImage kImage) {
        AppMethodBeat.i(19004);
        if (kImage instanceof MMKImage) {
            this.normalImage = (MMKImage) kImage;
            updateBackgroundWithImage();
        }
        AppMethodBeat.o(19004);
    }

    @Override // com.tencent.kinda.gen.KButton
    public KImage getNormalImage() {
        return this.normalImage;
    }

    @Override // com.tencent.kinda.gen.KButton
    public void setPressedImage(KImage kImage) {
        AppMethodBeat.i(19005);
        if (kImage instanceof MMKImage) {
            this.pressedImage = (MMKImage) kImage;
            updateBackgroundWithImage();
        }
        AppMethodBeat.o(19005);
    }

    @Override // com.tencent.kinda.gen.KButton
    public KImage getPressedImage() {
        return this.pressedImage;
    }

    @Override // com.tencent.kinda.gen.KButton
    public void setSelectedImage(KImage kImage) {
        AppMethodBeat.i(19006);
        if (kImage instanceof MMKImage) {
            this.selectedImage = (MMKImage) kImage;
            updateBackgroundWithImage();
        }
        AppMethodBeat.o(19006);
    }

    @Override // com.tencent.kinda.gen.KButton
    public KImage getSelectedImage() {
        return this.selectedImage;
    }

    @Override // com.tencent.kinda.gen.KButton
    public void setDisabledImage(KImage kImage) {
        AppMethodBeat.i(19007);
        if (kImage instanceof MMKImage) {
            this.disabledImage = (MMKImage) kImage;
            updateBackgroundWithImage();
        }
        AppMethodBeat.o(19007);
    }

    @Override // com.tencent.kinda.gen.KButton
    public KImage getDisabledImage() {
        return this.disabledImage;
    }

    @Override // com.tencent.kinda.gen.KButton
    public void setEnable(boolean z) {
        AppMethodBeat.i(19008);
        ((KindaButtonImpl) getView()).setEnabled(z);
        ((KindaButtonImpl) getView()).setClickable(z);
        AppMethodBeat.o(19008);
    }

    @Override // com.tencent.kinda.gen.KButton
    public boolean getEnable() {
        AppMethodBeat.i(19009);
        boolean isEnabled = ((KindaButtonImpl) getView()).isEnabled();
        AppMethodBeat.o(19009);
        return isEnabled;
    }

    private void updateBackgroundWithImage() {
        AppMethodBeat.i(19010);
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (this.isEnableHighlight && this.pressedImage != null && !this.pressedImage.isNetworkImage()) {
            stateListDrawable.addState(new int[]{16842919}, this.pressedImage.getDrawable());
        }
        if (this.selectedImage != null && !this.selectedImage.isNetworkImage()) {
            stateListDrawable.addState(new int[]{16842913}, this.selectedImage.getDrawable());
        }
        if (this.disabledImage != null && !this.disabledImage.isNetworkImage()) {
            stateListDrawable.addState(new int[]{-16842910}, this.disabledImage.getDrawable());
        }
        if (this.normalImage != null && !this.normalImage.isNetworkImage()) {
            stateListDrawable.addState(new int[0], this.normalImage.getDrawable());
        }
        ((KindaButtonImpl) getView()).setImageDrawable(stateListDrawable);
        AppMethodBeat.o(19010);
    }

    private void updateBackgroundWithColor() {
        AppMethodBeat.i(19011);
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (this.isEnableHighlight && this.pressedColor >= 0) {
            int[] iArr = {16842919};
            stateListDrawable.addState(iArr, new BackgroundColorDrawable(MMKViewUtil.argbColor(this.pressedColor)));
        }
        if (this.selectedColor >= 0) {
            int[] iArr2 = {16842913};
            stateListDrawable.addState(iArr2, new BackgroundColorDrawable(MMKViewUtil.argbColor(this.selectedColor)));
        }
        if (this.disabledColor >= 0) {
            int[] iArr3 = {-16842910};
            stateListDrawable.addState(iArr3, new BackgroundColorDrawable(MMKViewUtil.argbColor(this.disabledColor)));
        }
        if (ColorUtil.getColorByMode(this.normalColor) >= 0) {
            stateListDrawable.addState(new int[0], new BackgroundColorDrawable(MMKViewUtil.argbColor(ColorUtil.getColorByModeNoCompat(this.normalColor))));
        }
        setViewBackground(stateListDrawable);
        AppMethodBeat.o(19011);
    }

    /* access modifiers changed from: package-private */
    public static class BackgroundColorDrawable extends Drawable {
        private int color;

        BackgroundColorDrawable(int i2) {
            this.color = i2;
        }

        public void draw(Canvas canvas) {
            AppMethodBeat.i(18993);
            canvas.drawColor(this.color);
            AppMethodBeat.o(18993);
        }

        public void setAlpha(int i2) {
        }

        public void setColorFilter(ColorFilter colorFilter) {
        }

        public int getOpacity() {
            AppMethodBeat.i(18994);
            if (this.color == 0) {
                AppMethodBeat.o(18994);
                return -2;
            } else if (Color.alpha(this.color) > 0) {
                AppMethodBeat.o(18994);
                return -3;
            } else {
                AppMethodBeat.o(18994);
                return -1;
            }
        }
    }

    @Override // com.tencent.kinda.gen.KButton
    public void setFontStyle(FontStyle fontStyle2) {
        AppMethodBeat.i(214512);
        this.fontStyle = fontStyle2;
        updateTypeface();
        AppMethodBeat.o(214512);
    }

    @Override // com.tencent.kinda.gen.KButton
    public FontStyle getFontStyle() {
        return this.fontStyle;
    }

    @Override // com.tencent.kinda.gen.KButton
    public void setExpandHitWidth(long j2) {
    }

    @Override // com.tencent.kinda.gen.KButton
    public long getExpandHitWidth() {
        return 0;
    }

    @Override // com.tencent.kinda.gen.KButton
    public void setExpandHitHeight(long j2) {
    }

    @Override // com.tencent.kinda.gen.KButton
    public long getExpandHitHeight() {
        return 0;
    }

    @Override // com.tencent.kinda.gen.KView, com.tencent.kinda.framework.widget.base.MMKView
    public void setEnableHighLight(boolean z) {
        this.isEnableHighlight = z;
    }

    private void updateTypeface() {
        int i2;
        AppMethodBeat.i(214513);
        if (this.textFontName != null) {
            if (this.textFontName.equalsIgnoreCase("WeChat-Sans-SS-Light")) {
                i2 = 2;
            } else if (this.textFontName.equalsIgnoreCase("WeChat-Sans-SS-Medium")) {
                i2 = 0;
            } else if (this.textFontName.equalsIgnoreCase("WeChat-Sans-SS-Regular")) {
                i2 = 3;
            } else if (this.textFontName.equalsIgnoreCase("WeChat-Sans-SS-Bold")) {
                i2 = 1;
            } else {
                i2 = -1;
            }
            if (i2 != -1) {
                try {
                    ((KindaButtonImpl) getView()).getKButtonTextView().setTypeface(Typeface.createFromAsset(MMApplicationContext.getContext().getAssets(), f.aqk(i2)));
                    AppMethodBeat.o(214513);
                    return;
                } catch (Exception e2) {
                    Log.e(TAG, "setTypeface() Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
                    AppMethodBeat.o(214513);
                    return;
                }
            }
        }
        if (this.fontStyle == FontStyle.REGULAR) {
            ((KindaButtonImpl) getView()).getKButtonTextView().setTypeface(null, 0);
            AppMethodBeat.o(214513);
            return;
        }
        ((KindaButtonImpl) getView()).getKButtonTextView().setTypeface(null, 1);
        AppMethodBeat.o(214513);
    }
}
