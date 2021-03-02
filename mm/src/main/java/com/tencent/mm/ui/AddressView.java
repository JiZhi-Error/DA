package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.u;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.c;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class AddressView extends View implements a.AbstractC2024a, e.a {
    private static final String TAG = "MicroMsg.AddressView";
    public final int AVATAR_LAYOUT_WIDTH;
    public final int AVATAR_PADDING;
    public final int AVATAR_START_POS;
    public final int AVATAR_WIDTH;
    public final int COMMON_PADDING;
    public final int DESCRIPTION_PADDING;
    public final float DESCRIPTION_TEXT_SIZE;
    private int NAME_RIGHT_PADDING;
    public final float NAME_TEXT_SIZE;
    public final int TEXT_TOP_PADDING;
    public final int WEIBO_ICON_SIZE;
    Drawable avatarDrawable;
    Context context;
    float density;
    String description;
    private Paint.FontMetrics descriptionFontMetrics;
    private TextPaint descriptionPaint;
    CharSequence destNickName;
    private TextPaint displayNamePaint;
    Drawable drawable;
    private Paint.FontMetrics fm;
    StaticLayout layout;
    a mergeCallback;
    boolean nameIsSpanned;
    boolean needInvaildate;
    BitmapDrawable needMask;
    boolean needUpdatePostion;
    CharSequence nickName;
    private int nickNameCurrentTextColor;
    int nickNameHeight;
    private ColorStateList nickNameTextColor;
    int nickNameWidth;
    StaticLayout nickNamelayout;

    public interface a {
    }

    public AddressView(Context context2) {
        this(context2, null, 0);
    }

    public AddressView(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public AddressView(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(32901);
        this.drawable = getResources().getDrawable(R.drawable.bnl);
        this.needUpdatePostion = true;
        this.mergeCallback = null;
        this.AVATAR_LAYOUT_WIDTH = 0;
        this.AVATAR_WIDTH = 0;
        this.NAME_TEXT_SIZE = (float) com.tencent.mm.cb.a.aG(context2, R.dimen.is);
        this.DESCRIPTION_TEXT_SIZE = (float) com.tencent.mm.cb.a.aG(context2, R.dimen.kc);
        this.WEIBO_ICON_SIZE = getResources().getDimensionPixelSize(R.dimen.k3);
        this.AVATAR_START_POS = 0;
        this.AVATAR_PADDING = 0;
        this.COMMON_PADDING = 0;
        this.DESCRIPTION_PADDING = getResources().getDimensionPixelSize(R.dimen.hw) * 2;
        this.TEXT_TOP_PADDING = getResources().getDimensionPixelSize(R.dimen.kb);
        this.NAME_RIGHT_PADDING = getResources().getDimensionPixelSize(R.dimen.f3060e);
        if (this.displayNamePaint == null) {
            this.displayNamePaint = generateOnePaint();
        }
        AppMethodBeat.o(32901);
    }

    public void setNickNameTextColor(ColorStateList colorStateList) {
        this.nickNameTextColor = colorStateList;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(32902);
        super.onDraw(canvas);
        if (this.mergeCallback != null) {
            getShowAreaWidth();
        }
        updatePosition();
        if (this.avatarDrawable != null) {
            this.avatarDrawable.draw(canvas);
        }
        if (this.needMask != null) {
            this.needMask.draw(canvas);
        }
        if (this.nameIsSpanned) {
            canvas.save();
            canvas.translate((float) (this.AVATAR_LAYOUT_WIDTH + this.AVATAR_PADDING), (float) ((getHeight() - this.nickNameHeight) / 2));
            this.nickNamelayout.draw(canvas);
            canvas.restore();
            AppMethodBeat.o(32902);
            return;
        }
        if (!Util.isNullOrNil(this.description)) {
            if (this.destNickName != null) {
                canvas.drawText(this.destNickName, 0, this.destNickName.length(), (float) (this.AVATAR_LAYOUT_WIDTH + this.AVATAR_PADDING), ((float) this.TEXT_TOP_PADDING) + (((((float) getHeight()) - (this.fm.bottom - this.fm.top)) / 2.0f) - (this.fm.top / 3.0f)), this.displayNamePaint);
                int width = getWidth();
                float measureText = this.descriptionPaint.measureText(this.description);
                String str = this.description;
                if (measureText > ((float) (width - this.DESCRIPTION_PADDING))) {
                    int i2 = 1;
                    while (true) {
                        if (i2 >= this.description.length()) {
                            break;
                        }
                        String substring = this.description.substring(0, i2);
                        if (this.descriptionPaint.measureText(substring) >= ((float) (width - this.DESCRIPTION_PADDING))) {
                            str = str + "...";
                            break;
                        } else {
                            i2++;
                            str = substring;
                        }
                    }
                }
                canvas.drawText(str, 0, str.length(), (float) (this.AVATAR_LAYOUT_WIDTH + this.AVATAR_PADDING), ((float) this.TEXT_TOP_PADDING) + (((((float) getHeight()) - (this.descriptionFontMetrics.bottom - this.descriptionFontMetrics.top)) / 2.0f) - ((float) ((int) (((double) this.descriptionFontMetrics.top) * 1.7d)))), (Paint) this.descriptionPaint);
                AppMethodBeat.o(32902);
                return;
            }
        } else if (this.destNickName != null) {
            canvas.drawText(this.destNickName, 0, this.destNickName.length(), (float) (this.AVATAR_LAYOUT_WIDTH + this.AVATAR_PADDING), ((((float) getHeight()) - (this.fm.bottom - this.fm.top)) / 2.0f) - this.fm.top, this.displayNamePaint);
        }
        AppMethodBeat.o(32902);
    }

    public void setName(CharSequence charSequence) {
        AppMethodBeat.i(32903);
        if (this.nickName == null || !this.nickName.equals(charSequence)) {
            this.needInvaildate = true;
        }
        this.nickName = charSequence;
        this.nameIsSpanned = charSequence instanceof Spanned;
        getFontMetrics();
        AppMethodBeat.o(32903);
    }

    private Paint.FontMetrics getFontMetrics() {
        AppMethodBeat.i(32904);
        if (this.displayNamePaint == null) {
            this.displayNamePaint = generateOnePaint();
        }
        if (this.fm == null) {
            this.fm = this.displayNamePaint.getFontMetrics();
        }
        Paint.FontMetrics fontMetrics = this.fm;
        AppMethodBeat.o(32904);
        return fontMetrics;
    }

    public void setMergeCallback(a aVar) {
        if (aVar != null) {
            this.needInvaildate = true;
        }
        this.mergeCallback = aVar;
    }

    public void setDescription(String str) {
        AppMethodBeat.i(32905);
        this.description = str;
        if (this.descriptionPaint == null) {
            this.descriptionPaint = generateDescriptionPaint();
            this.descriptionFontMetrics = this.descriptionPaint.getFontMetrics();
        }
        AppMethodBeat.o(32905);
    }

    public float getNickNameSize() {
        return this.NAME_TEXT_SIZE;
    }

    public CharSequence getNickName() {
        return this.nickName;
    }

    public float getDesiredWidth(CharSequence charSequence, TextPaint textPaint) {
        AppMethodBeat.i(32906);
        if (charSequence instanceof Spanned) {
            float desiredWidth = Layout.getDesiredWidth(charSequence, textPaint);
            AppMethodBeat.o(32906);
            return desiredWidth;
        }
        if (charSequence == null) {
            Log.w(TAG, "source is null, set it empty.");
            charSequence = "";
        }
        float measureText = textPaint.measureText(charSequence, 0, charSequence.length());
        AppMethodBeat.o(32906);
        return measureText;
    }

    public void updatePositionFlag() {
        AppMethodBeat.i(32907);
        this.needUpdatePostion = true;
        if (this.needInvaildate) {
            invalidate();
            this.needInvaildate = false;
        }
        AppMethodBeat.o(32907);
    }

    private int getShowAreaWidth() {
        AppMethodBeat.i(32908);
        int textAreaWidth = (getTextAreaWidth() - getPaddingLeft()) - this.NAME_RIGHT_PADDING;
        AppMethodBeat.o(32908);
        return textAreaWidth;
    }

    public void updatePosition() {
        AppMethodBeat.i(32909);
        if (!this.needUpdatePostion) {
            AppMethodBeat.o(32909);
            return;
        }
        this.nickNameWidth = (getTextAreaWidth() - getPaddingLeft()) - this.NAME_RIGHT_PADDING;
        if (((int) getDesiredWidth(this.nickName, this.displayNamePaint)) > this.nickNameWidth) {
            this.destNickName = TextUtils.ellipsize(this.nickName, this.displayNamePaint, (float) this.nickNameWidth, TextUtils.TruncateAt.END);
        } else {
            this.destNickName = this.nickName;
            this.nickNameWidth = (int) getDesiredWidth(this.destNickName, this.displayNamePaint);
        }
        if (this.nickName instanceof Spanned) {
            this.nickNamelayout = new StaticLayout(this.destNickName, this.displayNamePaint, getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            this.nickNameHeight = this.nickNamelayout.getHeight();
        } else {
            this.nickNamelayout = null;
            Paint.FontMetrics fontMetrics = getFontMetrics();
            this.nickNameHeight = ((int) Math.ceil((double) (fontMetrics.descent - fontMetrics.top))) + 2;
        }
        this.needUpdatePostion = false;
        AppMethodBeat.o(32909);
    }

    public int getTextAreaWidth() {
        AppMethodBeat.i(32910);
        int measuredWidth = (getMeasuredWidth() - this.AVATAR_LAYOUT_WIDTH) - this.AVATAR_PADDING;
        AppMethodBeat.o(32910);
        return measuredWidth;
    }

    public int fromDPToPix(Context context2, int i2) {
        AppMethodBeat.i(32911);
        int round = Math.round(getDensity(context2) * ((float) i2));
        AppMethodBeat.o(32911);
        return round;
    }

    public float getDensity(Context context2) {
        AppMethodBeat.i(32912);
        if (context2 == null) {
            context2 = getContext();
        }
        if (this.density < 0.0f) {
            this.density = context2.getResources().getDisplayMetrics().density;
        }
        float f2 = this.density;
        AppMethodBeat.o(32912);
        return f2;
    }

    public void setMaskBitmap(Bitmap bitmap) {
        AppMethodBeat.i(32913);
        this.needMask = new BitmapDrawable(getResources(), bitmap);
        AppMethodBeat.o(32913);
    }

    @Override // com.tencent.mm.pluginsdk.ui.a.AbstractC2024a
    public void setImageDrawable(Drawable drawable2) {
        AppMethodBeat.i(32914);
        this.avatarDrawable = drawable2;
        if (drawable2 != null) {
            this.avatarDrawable.setCallback(this);
        }
        AppMethodBeat.o(32914);
    }

    @Override // com.tencent.mm.pluginsdk.ui.a.AbstractC2024a
    public Drawable getDrawable() {
        return this.avatarDrawable;
    }

    public void resumeAvatarLoad() {
        AppMethodBeat.i(32915);
        if (this.avatarDrawable != null) {
            ((c) this.avatarDrawable).goJ();
        }
        AppMethodBeat.o(32915);
    }

    public void stopAvatarLoad() {
        AppMethodBeat.i(32916);
        if (this.avatarDrawable != null) {
            ((c) this.avatarDrawable).goI();
        }
        AppMethodBeat.o(32916);
    }

    @Override // com.tencent.mm.pluginsdk.ui.e.a
    public void onScrollStateChanged(boolean z) {
        AppMethodBeat.i(32917);
        if (z) {
            stopAvatarLoad();
            AppMethodBeat.o(32917);
            return;
        }
        resumeAvatarLoad();
        AppMethodBeat.o(32917);
    }

    public void invalidateDrawable(Drawable drawable2) {
        AppMethodBeat.i(32918);
        invalidate();
        AppMethodBeat.o(32918);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        AppMethodBeat.i(32919);
        updateTextColors();
        super.drawableStateChanged();
        AppMethodBeat.o(32919);
    }

    public void updateTextColors() {
        int colorForState;
        AppMethodBeat.i(32920);
        if (!(this.nickNameTextColor == null || (colorForState = this.nickNameTextColor.getColorForState(getDrawableState(), 0)) == this.nickNameCurrentTextColor)) {
            this.nickNameCurrentTextColor = colorForState;
            if (this.displayNamePaint == null) {
                this.displayNamePaint = generateOnePaint();
            }
            this.displayNamePaint.setColor(this.nickNameCurrentTextColor);
        }
        AppMethodBeat.o(32920);
    }

    private TextPaint generateOnePaint() {
        AppMethodBeat.i(32921);
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(this.NAME_TEXT_SIZE);
        textPaint.setColor(getContext().getResources().getColor(R.color.FG_0));
        AppMethodBeat.o(32921);
        return textPaint;
    }

    private TextPaint generateDescriptionPaint() {
        AppMethodBeat.i(32922);
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(this.DESCRIPTION_TEXT_SIZE);
        textPaint.setColor(getResources().getColor(R.color.uj));
        AppMethodBeat.o(32922);
        return textPaint;
    }

    @Override // com.tencent.mm.pluginsdk.ui.a.AbstractC2024a
    public void doInvalidate() {
        AppMethodBeat.i(32923);
        invalidate();
        AppMethodBeat.o(32923);
    }

    @TargetApi(14)
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.i(32924);
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence contentDescription = getContentDescription();
        if (Util.isNullOrNil((String) contentDescription)) {
            contentDescription = this.nickName;
        }
        accessibilityEvent.getText().add(contentDescription);
        AppMethodBeat.o(32924);
    }

    private void installAccessibilityDelegate() {
        AppMethodBeat.i(32925);
        u.a(this, new android.support.v4.view.a() {
            /* class com.tencent.mm.ui.AddressView.AnonymousClass1 */

            @Override // android.support.v4.view.a
            public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                AppMethodBeat.i(32899);
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
                CharSequence contentDescription = AddressView.this.getContentDescription();
                if (Util.isNullOrNil((String) contentDescription)) {
                    contentDescription = AddressView.this.nickName;
                }
                accessibilityEvent.getText().add(contentDescription);
                AppMethodBeat.o(32899);
            }

            @Override // android.support.v4.view.a
            public final void onInitializeAccessibilityNodeInfo(View view, android.support.v4.view.a.c cVar) {
                AppMethodBeat.i(32900);
                super.onInitializeAccessibilityNodeInfo(view, cVar);
                CharSequence contentDescription = AddressView.this.getContentDescription();
                if (Util.isNullOrNil((String) contentDescription)) {
                    contentDescription = AddressView.this.nickName;
                }
                cVar.setText(contentDescription);
                AppMethodBeat.o(32900);
            }
        });
        AppMethodBeat.o(32925);
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        AppMethodBeat.i(32926);
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        CharSequence contentDescription = getContentDescription();
        if (Util.isNullOrNil((String) contentDescription)) {
            contentDescription = this.nickName;
        }
        accessibilityNodeInfo.setText(contentDescription);
        AppMethodBeat.o(32926);
    }
}
