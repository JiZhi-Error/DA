package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.a.a;
import com.tencent.mm.ui.tools.v;

public class MMTabView extends ViewGroup {
    private TextView OEK;
    private ImageView OHV;
    private int index;
    private TextView jVO;
    public int jcu;
    private int padding;

    public MMTabView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(141468);
        this.jcu = 3;
        this.padding = 0;
        init();
        AppMethodBeat.o(141468);
    }

    public MMTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(141469);
        this.jcu = 3;
        this.padding = 0;
        init();
        AppMethodBeat.o(141469);
    }

    private MMTabView(Context context) {
        super(context);
        AppMethodBeat.i(141470);
        this.jcu = 3;
        this.padding = 0;
        init();
        AppMethodBeat.o(141470);
    }

    public MMTabView(Context context, int i2) {
        this(context);
        AppMethodBeat.i(141471);
        this.index = i2;
        gIW();
        AppMethodBeat.o(141471);
    }

    public final void gIW() {
        AppMethodBeat.i(141472);
        Log.d("MicroMsg.MMTabView", "jacks build : %d desc, unread: %s", Integer.valueOf(this.index), getUnread());
        a.C2075a.OLX.a(this, getText(), getUnread(), this.index);
        AppMethodBeat.o(141472);
    }

    private void init() {
        int i2;
        AppMethodBeat.i(141473);
        this.padding = getResources().getDimensionPixelSize(R.dimen.kb);
        String applicationLanguage = LocaleUtil.getApplicationLanguage();
        boolean isChineseAppLang = LocaleUtil.isChineseAppLang();
        boolean equalsIgnoreCase = applicationLanguage.equalsIgnoreCase(LocaleUtil.ENGLISH);
        if (isChineseAppLang) {
            i2 = (int) (com.tencent.mm.cb.a.ez(getContext()) * ((float) com.tencent.mm.cb.a.fromDPToPix(getContext(), 2)));
        } else {
            i2 = 0;
        }
        this.jVO = new TextView(getContext());
        this.jVO.setSingleLine();
        this.jVO.setEllipsize(TextUtils.TruncateAt.END);
        this.jVO.setTextColor(getResources().getColorStateList(R.color.afp));
        this.jVO.setTextSize(0, (float) com.tencent.mm.cb.a.aG(getContext(), R.dimen.hc));
        this.jVO.setText("");
        if (isChineseAppLang) {
            this.jVO.setTextSize(0, ((float) i2) + this.jVO.getTextSize());
            this.jVO.setTypeface(null, 0);
        } else if (equalsIgnoreCase) {
            this.jVO.setTypeface(null, 1);
        }
        addView(this.jVO);
        this.OHV = new ImageView(getContext());
        this.OHV.setBackgroundResource(R.drawable.b1a);
        this.OHV.setVisibility(4);
        addView(this.OHV);
        this.OEK = new TextView(getContext());
        this.OEK.setTextColor(getResources().getColor(R.color.ag2));
        this.OEK.setTextSize(1, 11.0f);
        this.OEK.setBackgroundResource(v.kH(getContext()));
        this.OEK.setTypeface(Typeface.DEFAULT_BOLD);
        this.OEK.setGravity(17);
        this.OEK.setVisibility(4);
        addView(this.OEK);
        setBackgroundResource(R.drawable.b9x);
        AppMethodBeat.o(141473);
    }

    public void setText(int i2) {
        AppMethodBeat.i(141474);
        this.jVO.setText(i2);
        AppMethodBeat.o(141474);
    }

    public void setText(String str) {
        AppMethodBeat.i(141475);
        this.jVO.setText(str);
        AppMethodBeat.o(141475);
    }

    public void setTextColor(int i2) {
        AppMethodBeat.i(141476);
        this.jVO.setTextColor(i2);
        AppMethodBeat.o(141476);
    }

    public String getText() {
        AppMethodBeat.i(141477);
        String charSequence = this.jVO.getText().toString();
        AppMethodBeat.o(141477);
        return charSequence;
    }

    public String getUnread() {
        AppMethodBeat.i(141478);
        String charSequence = this.OEK.getText().toString();
        AppMethodBeat.o(141478);
        return charSequence;
    }

    public void setUnread(final String str) {
        AppMethodBeat.i(141479);
        if (Util.isNullOrNil(str)) {
            this.OEK.setVisibility(4);
            AppMethodBeat.o(141479);
            return;
        }
        this.OEK.setVisibility(0);
        this.OEK.post(new Runnable() {
            /* class com.tencent.mm.ui.MMTabView.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(141467);
                MMTabView.this.OEK.setText(str);
                MMTabView.this.OEK.setBackgroundResource(v.aQ(MMTabView.this.getContext(), Integer.parseInt(str)));
                MMTabView.this.gIW();
                AppMethodBeat.o(141467);
            }
        });
        AppMethodBeat.o(141479);
    }

    public final void Bk(boolean z) {
        AppMethodBeat.i(141480);
        this.OHV.setVisibility(z ? 0 : 4);
        AppMethodBeat.o(141480);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int makeMeasureSpec;
        AppMethodBeat.i(141481);
        int size = (View.MeasureSpec.getSize(i2) - getPaddingLeft()) - getPaddingRight();
        int size2 = (View.MeasureSpec.getSize(i3) - getPaddingTop()) - getPaddingBottom();
        if (View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        this.jVO.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), makeMeasureSpec);
        this.OHV.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), makeMeasureSpec);
        this.OEK.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), makeMeasureSpec);
        setMeasuredDimension(size, size2);
        AppMethodBeat.o(141481);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(141482);
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int measuredWidth = (i6 - this.jVO.getMeasuredWidth()) / 2;
        int measuredWidth2 = this.jVO.getMeasuredWidth() + measuredWidth;
        int measuredHeight = (i7 - this.jVO.getMeasuredHeight()) / 2;
        this.jVO.layout(measuredWidth, measuredHeight, measuredWidth2, this.jVO.getMeasuredHeight() + measuredHeight);
        int i8 = this.padding + measuredWidth2;
        int measuredHeight2 = (i7 - this.OHV.getMeasuredHeight()) / 2;
        this.OHV.layout(i8, measuredHeight2, this.OHV.getMeasuredWidth() + i8, this.OHV.getMeasuredHeight() + measuredHeight2);
        if (measuredWidth - this.padding < this.OEK.getMeasuredWidth()) {
            int measuredWidth3 = i6 - this.OEK.getMeasuredWidth();
            int measuredHeight3 = (i7 - this.OEK.getMeasuredHeight()) / 2;
            this.OEK.layout(measuredWidth3, measuredHeight3, this.OEK.getMeasuredWidth() + measuredWidth3, this.OEK.getMeasuredHeight() + measuredHeight3);
            AppMethodBeat.o(141482);
            return;
        }
        int i9 = this.padding + measuredWidth2;
        int measuredHeight4 = (i7 - this.OEK.getMeasuredHeight()) / 2;
        this.OEK.layout(i9, measuredHeight4, this.OEK.getMeasuredWidth() + i9, this.OEK.getMeasuredHeight() + measuredHeight4);
        AppMethodBeat.o(141482);
    }
}
