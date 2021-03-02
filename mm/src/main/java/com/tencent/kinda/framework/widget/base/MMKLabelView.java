package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.BaselineAdjustmentAlign;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.Ellipsize;
import com.tencent.kinda.gen.FontStyle;
import com.tencent.kinda.gen.KLabelView;
import com.tencent.kinda.gen.TextAlign;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;
import com.tencent.mm.wallet_core.ui.f;

public class MMKLabelView extends MMKView<TextView> implements KLabelView {
    private Ellipsize ellipsize;
    private FontStyle fontStyle = FontStyle.REGULAR;
    private int maxLength = -1;
    private MMKRichText richText;
    private TextAlign textAlign = TextAlign.LEFT;
    private DynamicColor textColor = new DynamicColor(-1, 0);
    private String textFontName;

    public MMKLabelView() {
        AppMethodBeat.i(19063);
        AppMethodBeat.o(19063);
    }

    private void updateTypeface() {
        int i2;
        AppMethodBeat.i(19064);
        if (this.textFontName != null) {
            if (this.textFontName.equalsIgnoreCase("WeChat-Sans-SS-Light")) {
                i2 = 2;
            } else if (this.textFontName.equalsIgnoreCase("WeChat-Sans-SS-Medium")) {
                i2 = 0;
            } else if (this.textFontName.equalsIgnoreCase("WeChat-Sans-SS-Regular")) {
                i2 = 3;
            } else if (this.textFontName.equalsIgnoreCase("WeChat-Sans-SS-Bold")) {
                i2 = 1;
            } else if (this.textFontName.equalsIgnoreCase("WeChat-Sans-Std-Medium")) {
                i2 = 4;
            } else if (this.textFontName.equalsIgnoreCase("WeChat-Sans-Std-Light")) {
                i2 = 6;
            } else if (this.textFontName.equalsIgnoreCase("WeChat-Sans-Std-Bold")) {
                i2 = 5;
            } else if (this.textFontName.equalsIgnoreCase("WeChat-Sans-Std-Regular")) {
                i2 = 7;
            } else {
                i2 = -1;
            }
            if (i2 != -1) {
                try {
                    ((TextView) getView()).setTypeface(Typeface.createFromAsset(MMApplicationContext.getContext().getAssets(), f.aqk(i2)));
                    AppMethodBeat.o(19064);
                    return;
                } catch (Exception e2) {
                    Log.e(MMKView.TAG, "setTypeface() Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
                    AppMethodBeat.o(19064);
                    return;
                }
            }
        }
        if (this.fontStyle == FontStyle.BOLD) {
            ((TextView) getView()).setTypeface(null, 1);
            AppMethodBeat.o(19064);
        } else if (this.fontStyle == FontStyle.MEDIUM) {
            ao.a(((TextView) getView()).getPaint(), 0.8f);
            AppMethodBeat.o(19064);
        } else {
            ((TextView) getView()).setTypeface(null, 0);
            AppMethodBeat.o(19064);
        }
    }

    @Override // com.tencent.kinda.framework.widget.base.MMKView
    public TextView createView(Context context) {
        AppMethodBeat.i(19065);
        TextView textView = new TextView(context);
        textView.setOnTouchListener(new o());
        textView.setGravity(19);
        if (ColorUtil.ifCompatKindaDarkModeDefaultColor()) {
            textView.setTextColor(context.getResources().getColor(R.color.a2x));
            this.textColor = new DynamicColor(Long.parseLong("E6000000", 16), Long.parseLong("CCFFFFFF", 16));
        }
        AppMethodBeat.o(19065);
        return textView;
    }

    @Override // com.tencent.kinda.gen.KLabelView
    public void setFontStyle(FontStyle fontStyle2) {
        AppMethodBeat.i(19066);
        this.fontStyle = fontStyle2;
        updateTypeface();
        AppMethodBeat.o(19066);
    }

    @Override // com.tencent.kinda.gen.KLabelView
    public FontStyle getFontStyle() {
        return this.fontStyle;
    }

    @Override // com.tencent.kinda.gen.KLabelView
    public void setLines(int i2) {
        AppMethodBeat.i(19067);
        if (i2 > 0) {
            ((TextView) getView()).setMaxLines(i2);
            notifyChanged();
        }
        AppMethodBeat.o(19067);
    }

    @Override // com.tencent.kinda.gen.KLabelView
    public int getLines() {
        AppMethodBeat.i(19068);
        int lineCount = ((TextView) getView()).getLineCount();
        AppMethodBeat.o(19068);
        return lineCount;
    }

    @Override // com.tencent.kinda.gen.KLabelView
    public void setText(String str) {
        AppMethodBeat.i(19069);
        if (str != null) {
            ((TextView) getView()).setText(l.b(MMApplicationContext.getContext(), str, ((TextView) getView()).getTextSize()));
            notifyChanged();
        }
        AppMethodBeat.o(19069);
    }

    @Override // com.tencent.kinda.gen.KLabelView
    public String getText() {
        AppMethodBeat.i(19070);
        Log.d(MMKView.TAG, "MMKLabelView getText ");
        CharSequence text = ((TextView) getView()).getText();
        if (text != null) {
            String charSequence = text.toString();
            AppMethodBeat.o(19070);
            return charSequence;
        }
        AppMethodBeat.o(19070);
        return null;
    }

    @Override // com.tencent.kinda.gen.KLabelView
    public void setTextSize(float f2) {
        AppMethodBeat.i(19071);
        if (f2 > 0.0f) {
            ((TextView) getView()).setTextSize(0, MMKViewUtil.dpToPx(MMApplicationContext.getContext(), f2));
            notifyChanged();
        }
        AppMethodBeat.o(19071);
    }

    @Override // com.tencent.kinda.gen.KLabelView
    public float getTextSize() {
        AppMethodBeat.i(19072);
        float E = (float) a.E(MMApplicationContext.getContext(), (int) ((TextView) getView()).getTextSize());
        AppMethodBeat.o(19072);
        return E;
    }

    @Override // com.tencent.kinda.gen.KLabelView
    public void setTextColor(DynamicColor dynamicColor) {
        AppMethodBeat.i(19073);
        this.textColor = dynamicColor;
        Log.d("MMKLabelView", "setTextColor: " + Integer.toHexString(MMKViewUtil.argbColor(ColorUtil.getColorByMode(dynamicColor, ColorUtil.MMViewType.MMKLabelViewText))));
        ((TextView) getView()).setTextColor(MMKViewUtil.argbColor(ColorUtil.getColorByMode(dynamicColor, ColorUtil.MMViewType.MMKLabelViewText)));
        notifyChanged();
        AppMethodBeat.o(19073);
    }

    @Override // com.tencent.kinda.gen.KLabelView
    public DynamicColor getTextColor() {
        return this.textColor;
    }

    @Override // com.tencent.kinda.gen.KLabelView
    public void setTextFont(String str) {
        AppMethodBeat.i(19074);
        if (str != null) {
            this.textFontName = str;
            updateTypeface();
        }
        AppMethodBeat.o(19074);
    }

    @Override // com.tencent.kinda.gen.KLabelView
    public String getTextFont() {
        return this.textFontName;
    }

    @Override // com.tencent.kinda.gen.KLabelView
    public void setEllipsize(Ellipsize ellipsize2) {
        AppMethodBeat.i(19075);
        this.ellipsize = ellipsize2;
        switch (ellipsize2) {
            case TAIL:
                ((TextView) getView()).setEllipsize(TextUtils.TruncateAt.END);
                break;
            case HEAD:
                ((TextView) getView()).setEllipsize(TextUtils.TruncateAt.START);
                break;
            case MIDDLE:
                ((TextView) getView()).setEllipsize(TextUtils.TruncateAt.MIDDLE);
                break;
        }
        notifyChanged();
        AppMethodBeat.o(19075);
    }

    @Override // com.tencent.kinda.gen.KLabelView
    public Ellipsize getEllipsize() {
        return this.ellipsize;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.kinda.gen.KLabelView
    public void setTextAlign(TextAlign textAlign2) {
        AppMethodBeat.i(19076);
        if (textAlign2 != null) {
            this.textAlign = textAlign2;
            int gravity = ((TextView) getView()).getGravity();
            switch (this.textAlign) {
                case LEFT:
                    ((TextView) getView()).setGravity(gravity | 3);
                    AppMethodBeat.o(19076);
                    return;
                case CENTER:
                    ((TextView) getView()).setGravity(17);
                    AppMethodBeat.o(19076);
                    return;
                case RIGHT:
                    ((TextView) getView()).setGravity(gravity | 5);
                    break;
            }
        }
        AppMethodBeat.o(19076);
    }

    @Override // com.tencent.kinda.gen.KLabelView
    public TextAlign getTextAlign() {
        return this.textAlign;
    }

    @Override // com.tencent.kinda.gen.KLabelView
    public void setMaxLength(int i2) {
        AppMethodBeat.i(19077);
        if (i2 >= 0) {
            this.maxLength = i2;
            ((TextView) getView()).setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.maxLength)});
        }
        AppMethodBeat.o(19077);
    }

    @Override // com.tencent.kinda.gen.KLabelView
    public int getMaxLength() {
        return this.maxLength;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.kinda.framework.widget.base.MMKView
    public void notifyChanged() {
        AppMethodBeat.i(19078);
        super.notifyChanged();
        AppMethodBeat.o(19078);
    }

    @Override // com.tencent.kinda.gen.KLabelView
    public void setAdjustsFontSizeToFitWidth(boolean z) {
    }

    @Override // com.tencent.kinda.gen.KLabelView
    public boolean getAdjustsFontSizeToFitWidth() {
        return false;
    }

    @Override // com.tencent.kinda.gen.KLabelView
    public void setBaselineAdjustment(BaselineAdjustmentAlign baselineAdjustmentAlign) {
    }

    @Override // com.tencent.kinda.gen.KLabelView
    public BaselineAdjustmentAlign getBaselineAdjustment() {
        return null;
    }
}
