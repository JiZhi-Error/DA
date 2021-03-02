package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.view.View;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.DatePickerType;
import com.tencent.kinda.gen.KDate;
import com.tencent.kinda.gen.KDatePickerView;
import com.tencent.kinda.gen.KDatePickerViewOnSelectCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.picker.b;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class KindaDatePickerView extends MMKView<View> implements KDatePickerView {
    private static final String TAG = "KindaDatePickerView";
    private UIPageFragmentActivity activity;
    private KDatePickerViewOnSelectCallback callback;
    private b datePicker;
    private boolean isLongTerm = false;
    private Calendar mCalendar;
    private int mDay = -1;
    private TenpaySecureEditText mEditText;
    private int mMonthOfYear = -1;
    private String mShowResult = "";
    private DatePickerType mType = DatePickerType.BIRTH_DAY;
    private int mYear = -1;

    static /* synthetic */ String access$700(KindaDatePickerView kindaDatePickerView) {
        AppMethodBeat.i(214475);
        String encString = kindaDatePickerView.getEncString();
        AppMethodBeat.o(214475);
        return encString;
    }

    /* Return type fixed from 'android.widget.LinearLayout' to match base method */
    @Override // com.tencent.kinda.framework.widget.base.MMKView
    public View createView(Context context) {
        AppMethodBeat.i(214468);
        this.mEditText = new TenpaySecureEditText(context);
        this.mEditText.setInputType(0);
        this.mEditText.setFocusable(false);
        this.mEditText.setBackground(null);
        this.mEditText.setTextSize(0, MMKViewUtil.dpToPx(MMApplicationContext.getContext(), 17.0f));
        this.mEditText.setPadding(0, 0, 0, 0);
        this.mEditText.setTextColor(context.getResources().getColor(R.color.adw));
        if (context instanceof UIPageFragmentActivity) {
            this.activity = (UIPageFragmentActivity) context;
        }
        initDatePickerData();
        initDatePicker();
        LayoutWrapper layoutWrapper = new LayoutWrapper(context, this.mEditText);
        AppMethodBeat.o(214468);
        return layoutWrapper;
    }

    @Override // com.tencent.kinda.gen.KDatePickerView
    public void setOriginDate(int i2, int i3, int i4) {
        AppMethodBeat.i(18904);
        this.mYear = i2;
        this.mMonthOfYear = i3;
        this.mDay = i4;
        if (!this.isLongTerm || i2 != 9999) {
            this.mShowResult = String.format("%04d/%02d/%02d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            this.mEditText.setText(this.mShowResult);
            AppMethodBeat.o(18904);
            return;
        }
        this.mShowResult = MMApplicationContext.getContext().getString(R.string.ixn);
        this.mEditText.setText(this.mShowResult);
        AppMethodBeat.o(18904);
    }

    @Override // com.tencent.kinda.gen.KDatePickerView
    public void setStartDate(KDate kDate) {
    }

    @Override // com.tencent.kinda.gen.KDatePickerView
    public void setEndDate(KDate kDate) {
    }

    @Override // com.tencent.kinda.gen.KDatePickerView
    public KDate getStartDate() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KDatePickerView
    public KDate getEndDate() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KDatePickerView
    public void setFocus(boolean z) {
        AppMethodBeat.i(18905);
        if (!z) {
            if (this.datePicker != null) {
                this.datePicker.hide();
            }
            AppMethodBeat.o(18905);
        } else if (this.activity == null) {
            Log.e(TAG, "activity is null!");
            AppMethodBeat.o(18905);
        } else {
            this.activity.hideVKB();
            this.activity.hideTenpayKB();
            this.datePicker = new b(this.activity);
            setMinAndMaxDate(this.mType);
            this.datePicker.bg(true, true);
            this.datePicker.QSU = new b.a() {
                /* class com.tencent.kinda.framework.widget.base.KindaDatePickerView.AnonymousClass1 */

                @Override // com.tencent.mm.ui.widget.picker.b.a
                public void onResult(boolean z, int i2, int i3, int i4) {
                    AppMethodBeat.i(18902);
                    KindaDatePickerView.this.datePicker.hide();
                    KindaDatePickerView.this.mYear = i2;
                    KindaDatePickerView.this.mMonthOfYear = i3;
                    KindaDatePickerView.this.mDay = i4;
                    Log.d(KindaDatePickerView.TAG, "onDateChanged，year：" + i2 + "，month：" + i3 + "，day：" + i4 + "，hasSetResult：" + z);
                    if (z) {
                        if (!KindaDatePickerView.this.isLongTerm || i2 != 1) {
                            KindaDatePickerView.this.mShowResult = String.format("%04d/%02d/%02d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                        } else {
                            KindaDatePickerView.this.mYear = 9999;
                            KindaDatePickerView.this.mMonthOfYear = 12;
                            KindaDatePickerView.this.mDay = 31;
                            KindaDatePickerView.this.mShowResult = MMApplicationContext.getContext().getString(R.string.ixn);
                        }
                        KindaDatePickerView.this.mEditText.setText(KindaDatePickerView.this.mShowResult);
                        KindaDatePickerView.this.callback.onSelect(KindaDatePickerView.access$700(KindaDatePickerView.this));
                    }
                    AppMethodBeat.o(18902);
                }
            };
            if (this.mYear == 9999) {
                Log.i(TAG, "init long term");
                this.datePicker.aX(1, 1, 1);
            } else {
                this.datePicker.aX(this.mYear, this.mMonthOfYear, this.mDay);
            }
            this.datePicker.show();
            AppMethodBeat.o(18905);
        }
    }

    @Override // com.tencent.kinda.gen.KDatePickerView
    public boolean getFocus() {
        AppMethodBeat.i(18906);
        boolean isFocused = this.mEditText.isFocused();
        AppMethodBeat.o(18906);
        return isFocused;
    }

    @Override // com.tencent.kinda.gen.KDatePickerView
    public void setType(DatePickerType datePickerType) {
        AppMethodBeat.i(18907);
        this.mType = datePickerType;
        if (datePickerType == DatePickerType.BIRTH_DAY) {
            this.mEditText.setHint(R.string.ia1);
        } else if (datePickerType == DatePickerType.IDENTITY_VALID_DATE) {
            this.mEditText.setHint(R.string.i9j);
        }
        setMinAndMaxDate(datePickerType);
        AppMethodBeat.o(18907);
    }

    @Override // com.tencent.kinda.gen.KDatePickerView
    public DatePickerType getType() {
        return this.mType;
    }

    @Override // com.tencent.kinda.gen.KDatePickerView
    public void setValue(String str) {
    }

    @Override // com.tencent.kinda.gen.KDatePickerView
    public String getValue() {
        AppMethodBeat.i(18908);
        String encString = getEncString();
        AppMethodBeat.o(18908);
        return encString;
    }

    @Override // com.tencent.kinda.gen.KDatePickerView
    public void setCanBeLongTerm(boolean z) {
        AppMethodBeat.i(214469);
        this.isLongTerm = z;
        this.datePicker.setLongTermYear(z);
        AppMethodBeat.o(214469);
    }

    @Override // com.tencent.kinda.gen.KDatePickerView
    public boolean getCanBeLongTerm() {
        return this.isLongTerm;
    }

    @Override // com.tencent.kinda.gen.KDatePickerView
    public void setOnSelectCallback(KDatePickerViewOnSelectCallback kDatePickerViewOnSelectCallback) {
        this.callback = kDatePickerViewOnSelectCallback;
    }

    private void initDatePickerData() {
        AppMethodBeat.i(18909);
        String[] split = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date()).split("-");
        this.mYear = Util.safeParseInt(split[0]);
        this.mMonthOfYear = Util.safeParseInt(split[1]);
        this.mDay = Util.safeParseInt(split[2]);
        AppMethodBeat.o(18909);
    }

    private void initDatePicker() {
        AppMethodBeat.i(18910);
        if (this.activity == null) {
            Log.e(TAG, "activity is null!");
            AppMethodBeat.o(18910);
            return;
        }
        this.datePicker = new b(this.activity);
        AppMethodBeat.o(18910);
    }

    private void setMinAndMaxDate(DatePickerType datePickerType) {
        AppMethodBeat.i(18911);
        if (this.datePicker == null) {
            AppMethodBeat.o(18911);
        } else if (datePickerType == DatePickerType.BIRTH_DAY) {
            this.datePicker.aY(1900, 1, 1);
            String[] split = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date()).split("-");
            if (split.length >= 3) {
                this.datePicker.aZ(Util.safeParseInt(split[0]), Util.safeParseInt(split[1]), Util.safeParseInt(split[2]));
            }
            AppMethodBeat.o(18911);
        } else if (datePickerType == DatePickerType.IDENTITY_VALID_DATE) {
            String[] split2 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date()).split("-");
            if (split2.length >= 3) {
                this.datePicker.aY(Util.safeParseInt(split2[0]), Util.safeParseInt(split2[1]), Util.safeParseInt(split2[2]));
                this.datePicker.aZ(Util.safeParseInt(split2[0]) + 100, 12, 31);
            }
            if (this.isLongTerm) {
                this.datePicker.setLongTermYear(true);
            }
            AppMethodBeat.o(18911);
        } else {
            if (datePickerType == DatePickerType.IDENTITY_EFFECT_DATE) {
                String[] split3 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date()).split("-");
                if (split3.length >= 3) {
                    this.datePicker.aZ(Util.safeParseInt(split3[0]), Util.safeParseInt(split3[1]), Util.safeParseInt(split3[2]));
                    int safeParseInt = Util.safeParseInt(split3[0]) - 100;
                    if (safeParseInt <= 0) {
                        safeParseInt = 1;
                    }
                    this.datePicker.aY(safeParseInt, 1, 1);
                }
            }
            AppMethodBeat.o(18911);
        }
    }

    private String getEncString() {
        String str;
        AppMethodBeat.i(18912);
        if (!this.isLongTerm || this.mYear != 9999) {
            str = this.mEditText.get3DesEncrptData(this.mShowResult.replaceAll(FilePathGenerator.ANDROID_DIR_SEP, ""));
        } else {
            str = this.mEditText.get3DesEncrptData(String.format("%04d%02d%02d", Integer.valueOf(this.mYear), Integer.valueOf(this.mMonthOfYear), Integer.valueOf(this.mDay)));
        }
        AppMethodBeat.o(18912);
        return str;
    }

    @Override // com.tencent.kinda.gen.KDatePickerView
    public void setHint(String str) {
        AppMethodBeat.i(170116);
        if (this.mEditText != null) {
            this.mEditText.setHint(str);
        }
        AppMethodBeat.o(170116);
    }

    @Override // com.tencent.kinda.gen.KDatePickerView
    public KDate getSelectedDate() {
        AppMethodBeat.i(214470);
        KDate kDate = new KDate(this.mYear, this.mMonthOfYear, this.mDay);
        AppMethodBeat.o(214470);
        return kDate;
    }

    @Override // com.tencent.kinda.gen.KDatePickerView
    public long timeForDate(KDate kDate) {
        AppMethodBeat.i(214471);
        if (kDate != null) {
            Calendar calendar = calendar();
            calendar.clear();
            calendar.set(kDate.mYear, kDate.mMonth - 1, kDate.mDay);
            long timeInMillis = calendar.getTimeInMillis();
            AppMethodBeat.o(214471);
            return timeInMillis;
        }
        AppMethodBeat.o(214471);
        return 0;
    }

    @Override // com.tencent.kinda.gen.KDatePickerView
    public int yearOfNow() {
        AppMethodBeat.i(214472);
        Calendar calendar = calendar();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int i2 = calendar.get(1);
        AppMethodBeat.o(214472);
        return i2;
    }

    @Override // com.tencent.kinda.gen.KDatePickerView
    public KDate currentDate() {
        AppMethodBeat.i(214473);
        Calendar calendar = calendar();
        calendar.setTimeInMillis(System.currentTimeMillis());
        KDate kDate = new KDate(calendar.get(1), calendar.get(2) + 1, calendar.get(5));
        AppMethodBeat.o(214473);
        return kDate;
    }

    private Calendar calendar() {
        AppMethodBeat.i(214474);
        if (this.mCalendar == null) {
            this.mCalendar = Calendar.getInstance();
        }
        Calendar calendar = this.mCalendar;
        AppMethodBeat.o(214474);
        return calendar;
    }
}
