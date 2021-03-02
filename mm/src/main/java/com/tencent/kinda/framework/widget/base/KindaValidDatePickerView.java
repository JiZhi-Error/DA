package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.widget.EditText;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.KValidDatePickerView;
import com.tencent.kinda.gen.KValidDatePickerViewOnSelectCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.picker.b;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class KindaValidDatePickerView extends MMKView<EditText> implements KValidDatePickerView {
    private UIPageFragmentActivity activity;
    KValidDatePickerViewOnSelectCallback callback;
    private b datePicker;
    private TenpaySecureEditText mEditText;
    private int mMonthOfYear = -1;
    private String mSelected;
    private int mYear = -1;

    /* Return type fixed from 'com.tenpay.android.wechat.TenpaySecureEditText' to match base method */
    @Override // com.tencent.kinda.framework.widget.base.MMKView
    public EditText createView(Context context) {
        AppMethodBeat.i(18975);
        this.mEditText = new TenpaySecureEditText(context);
        this.mEditText.setInputType(0);
        this.mEditText.setFocusable(false);
        this.mEditText.setBackground(null);
        this.mEditText.setIsValidThru(true);
        this.mEditText.setHint(R.string.i9o);
        this.mEditText.setPadding(0, 0, 0, 0);
        this.mEditText.setTextSize(0, MMKViewUtil.dpToPx(context, 17.0f));
        if (context instanceof UIPageFragmentActivity) {
            this.activity = (UIPageFragmentActivity) context;
        }
        TenpaySecureEditText tenpaySecureEditText = this.mEditText;
        AppMethodBeat.o(18975);
        return tenpaySecureEditText;
    }

    @Override // com.tencent.kinda.gen.KValidDatePickerView
    public void setOnSelectCallback(KValidDatePickerViewOnSelectCallback kValidDatePickerViewOnSelectCallback) {
        this.callback = kValidDatePickerViewOnSelectCallback;
    }

    @Override // com.tencent.kinda.gen.KValidDatePickerView
    public void setFocus(boolean z) {
        AppMethodBeat.i(18976);
        if (z) {
            this.activity.hideVKB();
            this.activity.hideTenpayKB();
            this.datePicker = new b(this.activity);
            this.datePicker.bg(true, false);
            this.datePicker.QSU = new b.a() {
                /* class com.tencent.kinda.framework.widget.base.KindaValidDatePickerView.AnonymousClass1 */

                @Override // com.tencent.mm.ui.widget.picker.b.a
                public void onResult(boolean z, int i2, int i3, int i4) {
                    AppMethodBeat.i(18974);
                    KindaValidDatePickerView.this.datePicker.hide();
                    if (z) {
                        String hcf = KindaValidDatePickerView.this.datePicker.hcf();
                        if (Util.isNullOrNil(hcf)) {
                            AppMethodBeat.o(18974);
                            return;
                        }
                        String[] split = hcf.split("-");
                        if (split.length < 2) {
                            AppMethodBeat.o(18974);
                            return;
                        }
                        Log.d(MMKView.TAG, "result: %s", hcf);
                        KindaValidDatePickerView.this.mYear = Util.safeParseInt(split[0]);
                        KindaValidDatePickerView.this.mMonthOfYear = Util.safeParseInt(split[1]) - 1;
                        Log.d(MMKView.TAG, "year: %s, month: %s", Integer.valueOf(KindaValidDatePickerView.this.mYear), Integer.valueOf(KindaValidDatePickerView.this.mMonthOfYear));
                        DecimalFormat decimalFormat = new DecimalFormat("00");
                        KindaValidDatePickerView.this.mEditText.setText(decimalFormat.format((long) (KindaValidDatePickerView.this.mMonthOfYear + 1)) + decimalFormat.format((long) KindaValidDatePickerView.this.mYear).substring(2));
                        KindaValidDatePickerView.this.mSelected = decimalFormat.format((long) KindaValidDatePickerView.this.mYear).substring(2) + decimalFormat.format((long) (KindaValidDatePickerView.this.mMonthOfYear + 1));
                        KindaValidDatePickerView.this.callback.onSelect(KindaValidDatePickerView.this.mSelected);
                    }
                    AppMethodBeat.o(18974);
                }
            };
            String[] split = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date()).split("-");
            if (split.length >= 3) {
                this.datePicker.aY(Util.safeParseInt(split[0]), Util.safeParseInt(split[1]), Util.safeParseInt(split[2]));
                this.datePicker.aZ(Util.safeParseInt(split[0]) + 30, 12, 31);
            } else {
                this.datePicker.aY(Util.safeParseInt(split[0]), 1, 1);
                this.datePicker.aZ(Util.safeParseInt(split[0]) + 30, 12, 31);
            }
            this.datePicker.aX(this.mYear, this.mMonthOfYear + 1, 1);
            this.datePicker.show();
            AppMethodBeat.o(18976);
            return;
        }
        if (this.datePicker != null) {
            this.datePicker.hide();
        }
        AppMethodBeat.o(18976);
    }

    @Override // com.tencent.kinda.gen.KValidDatePickerView
    public boolean getFocus() {
        AppMethodBeat.i(18977);
        boolean isFocused = this.mEditText.isFocused();
        AppMethodBeat.o(18977);
        return isFocused;
    }

    @Override // com.tencent.kinda.gen.KValidDatePickerView
    public String getText() {
        return this.mSelected;
    }
}
