package com.tencent.mm.wallet_core.ui.formview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.c;
import com.tenpay.android.wechat.TenpaySecureEditText;

public final class EditHintPasswdView extends RelativeLayout implements View.OnFocusChangeListener {
    private static final int RvS = R.drawable.si;
    private static final int RvT = R.drawable.sj;
    private int RvU;
    private int RvV;
    private int RvW;
    private int RvX;
    private a RvY;
    private View.OnFocusChangeListener ktK;
    public TenpaySecureEditText mEditText;
    private int zOa;

    public interface a {
        void onInputValidChange(boolean z);
    }

    static /* synthetic */ boolean c(EditHintPasswdView editHintPasswdView) {
        AppMethodBeat.i(73129);
        boolean bql = editHintPasswdView.bql();
        AppMethodBeat.o(73129);
        return bql;
    }

    public EditHintPasswdView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        AppMethodBeat.i(73116);
        this.mEditText = null;
        this.RvU = 6;
        this.zOa = 1;
        this.RvV = RvS;
        this.RvW = 1;
        this.RvY = null;
        this.ktK = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C2011a.PwdAttr, i2, 0);
        this.zOa = obtainStyledAttributes.getInteger(3, 1);
        this.RvV = obtainStyledAttributes.getResourceId(0, RvS);
        this.RvW = obtainStyledAttributes.getInteger(1, 1);
        this.RvX = obtainStyledAttributes.getInteger(2, 1);
        obtainStyledAttributes.recycle();
        bh(context);
        TenpaySecureEditText.setSalt(f.hhV());
        AppMethodBeat.o(73116);
    }

    public EditHintPasswdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public EditHintPasswdView(Context context) {
        super(context);
        AppMethodBeat.i(73117);
        this.mEditText = null;
        this.RvU = 6;
        this.zOa = 1;
        this.RvV = RvS;
        this.RvW = 1;
        this.RvY = null;
        this.ktK = null;
        bh(context);
        AppMethodBeat.o(73117);
    }

    public final String getMd5Value() {
        AppMethodBeat.i(73118);
        if (this.mEditText != null) {
            String mD5String = MD5Util.getMD5String(this.mEditText.getText().toString());
            AppMethodBeat.o(73118);
            return mD5String;
        }
        Log.w("MicroMsg.EditHintPasswdView", "hy: edit view is null");
        AppMethodBeat.o(73118);
        return "";
    }

    private void bh(Context context) {
        AppMethodBeat.i(73119);
        this.mEditText = (TenpaySecureEditText) aa.jQ(context).inflate(R.layout.auc, (ViewGroup) this, true).findViewById(R.id.jf4);
        if (this.RvV == RvS && ao.isDarkMode()) {
            this.RvV = RvT;
        }
        if (this.RvX == 1) {
            this.RvV = R.color.ac_;
        }
        b.a(this.mEditText, this.zOa, this.RvX == 1);
        this.RvU = getNumberSize();
        if (this.mEditText != null) {
            this.mEditText.setBackgroundResource(this.RvV);
            this.mEditText.setImeOptions(6);
            this.mEditText.setInputType(128);
            this.mEditText.addTextChangedListener(new TextWatcher() {
                /* class com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.AnonymousClass1 */

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void afterTextChanged(Editable editable) {
                    AppMethodBeat.i(73115);
                    if (EditHintPasswdView.this.RvY != null) {
                        EditHintPasswdView.this.RvY.onInputValidChange(EditHintPasswdView.c(EditHintPasswdView.this));
                    }
                    AppMethodBeat.o(73115);
                }
            });
            this.mEditText.setOnFocusChangeListener(this);
            this.mEditText.setClickable(false);
            this.mEditText.setLongClickable(false);
            super.setEnabled(true);
            super.setClickable(true);
            AppMethodBeat.o(73119);
            return;
        }
        Log.e("MicroMsg.EditHintPasswdView", "hy: no edit text view");
        AppMethodBeat.o(73119);
    }

    public final void aqo(int i2) {
        boolean z = true;
        AppMethodBeat.i(214344);
        this.RvX = i2;
        if (this.RvX == 1) {
            this.RvV = R.color.ac_;
        } else if (ao.isDarkMode()) {
            this.RvV = RvT;
        } else {
            this.RvV = RvS;
        }
        this.mEditText.setBackgroundResource(this.RvV);
        TenpaySecureEditText tenpaySecureEditText = this.mEditText;
        int i3 = this.zOa;
        if (this.RvX != 1) {
            z = false;
        }
        b.a(tenpaySecureEditText, i3, z);
        AppMethodBeat.o(214344);
    }

    private boolean bql() {
        AppMethodBeat.i(73120);
        if (this.mEditText == null || this.mEditText.getInputLength() != this.RvU) {
            AppMethodBeat.o(73120);
            return false;
        }
        AppMethodBeat.o(73120);
        return true;
    }

    private int getNumberSize() {
        AppMethodBeat.i(73121);
        switch (this.zOa) {
            case 1:
                AppMethodBeat.o(73121);
                return 6;
            case 2:
            case 5:
            case 6:
            case 7:
            default:
                Log.i("MicroMsg.EditHintPasswdView", "hy: error or not set format. use default");
                AppMethodBeat.o(73121);
                return 6;
            case 3:
                AppMethodBeat.o(73121);
                return 3;
            case 4:
                AppMethodBeat.o(73121);
                return 4;
            case 8:
                AppMethodBeat.o(73121);
                return 4;
        }
    }

    public final void hhY() {
        AppMethodBeat.i(73122);
        this.mEditText.requestFocus();
        AppMethodBeat.o(73122);
    }

    public final void setOnInputValidListener(a aVar) {
        this.RvY = aVar;
    }

    public final a getOnEditInputValidListener() {
        return this.RvY;
    }

    public final void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.ktK = onFocusChangeListener;
    }

    public final View.OnFocusChangeListener getOnFocusChangeListener() {
        return this.ktK;
    }

    public final void setEncrType(int i2) {
        this.RvW = i2;
    }

    public final int getEncrType() {
        return this.RvW;
    }

    public final void setEditTextSize(float f2) {
        AppMethodBeat.i(73123);
        if (this.mEditText != null) {
            this.mEditText.setTextSize(f2);
        }
        AppMethodBeat.o(73123);
    }

    public final void setEditTextMaxLength(int i2) {
        AppMethodBeat.i(73124);
        if (this.mEditText != null) {
            InputFilter[] filters = this.mEditText.getFilters();
            InputFilter[] inputFilterArr = new InputFilter[(filters.length + 1)];
            for (int i3 = 0; i3 < filters.length; i3++) {
                inputFilterArr[i3] = filters[i3];
            }
            inputFilterArr[inputFilterArr.length - 1] = new InputFilter.LengthFilter(i2);
            this.mEditText.setFilters(inputFilterArr);
        }
        AppMethodBeat.o(73124);
    }

    public final String getText() {
        AppMethodBeat.i(73125);
        if (this.mEditText != null) {
            String a2 = c.a.a(this.RvW, this.mEditText);
            AppMethodBeat.o(73125);
            return a2;
        }
        Log.w("MicroMsg.EditHintPasswdView", "hy: no edit view");
        AppMethodBeat.o(73125);
        return "";
    }

    public final void eIj() {
        AppMethodBeat.i(73126);
        if (this.mEditText != null) {
            this.mEditText.ClearInput();
        }
        AppMethodBeat.o(73126);
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        int makeMeasureSpec;
        int i4;
        AppMethodBeat.i(73127);
        setMeasuredDimension(getDefaultSize(BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 960.0f), i2), getDefaultSize(BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 720.0f), i3));
        if (this.RvX == 0) {
            int measuredWidth = getMeasuredWidth();
            int i5 = this.RvU == 0 ? measuredWidth / 6 : measuredWidth / this.RvU;
            i4 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
            setMeasuredDimension(getDefaultSize(measuredWidth, i4), getDefaultSize(i5, makeMeasureSpec2));
            makeMeasureSpec = makeMeasureSpec2;
        } else {
            int measuredWidth2 = getMeasuredWidth();
            int fromDPToPix = (measuredWidth2 - (com.tencent.mm.cb.a.fromDPToPix(getContext(), 8) * (this.RvU - 1))) / this.RvU;
            int makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredWidth2 + 1, 1073741824);
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(fromDPToPix, 1073741824);
            setMeasuredDimension(getDefaultSize(measuredWidth2, makeMeasureSpec3), getDefaultSize(fromDPToPix, makeMeasureSpec));
            i4 = makeMeasureSpec3;
        }
        super.onMeasure(i4, makeMeasureSpec);
        AppMethodBeat.o(73127);
    }

    public final void onFocusChange(View view, boolean z) {
        AppMethodBeat.i(73128);
        if (this.ktK != null) {
            this.ktK.onFocusChange(this, z);
        }
        if (this.RvY != null) {
            this.RvY.onInputValidChange(bql());
        }
        AppMethodBeat.o(73128);
    }

    public final int getFormat() {
        return this.zOa;
    }
}
