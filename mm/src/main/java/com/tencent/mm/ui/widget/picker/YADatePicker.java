package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ck.a;
import com.tencent.mm.ui.as;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

public class YADatePicker extends FrameLayout {
    private static final String LOG_TAG = YADatePicker.class.getSimpleName();
    public final b QUb;

    public interface b {
        void a(int i2, int i3, int i4, d dVar);

        boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent);

        Parcelable f(Parcelable parcelable);

        CalendarView getCalendarView();

        boolean getCalendarViewShown();

        int getDayOfMonth();

        int getFirstDayOfWeek();

        int getMonth();

        boolean getSpinnersShown();

        int getYear();

        Calendar hcp();

        Calendar hcq();

        boolean isEnabled();

        void onConfigurationChanged(Configuration configuration);

        void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent);

        void onRestoreInstanceState(Parcelable parcelable);

        void setCalendarViewShown(boolean z);

        void setEnabled(boolean z);

        void setFirstDayOfWeek(int i2);

        void setMaxDate(long j2);

        void setMinDate(long j2);

        void setSpinnersShown(boolean z);

        void setValidationCallback(e eVar);
    }

    public interface d {
    }

    public interface e {
    }

    static {
        AppMethodBeat.i(159659);
        AppMethodBeat.o(159659);
    }

    public YADatePicker(Context context) {
        this(context, null);
    }

    public YADatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.ij);
    }

    public YADatePicker(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(159633);
        this.QUb = new c(this, context, attributeSet, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0296a.DatePicker, i2, 0);
        int i3 = obtainStyledAttributes.getInt(6, 0);
        obtainStyledAttributes.recycle();
        if (i3 != 0) {
            setFirstDayOfWeek(i3);
        }
        AppMethodBeat.o(159633);
    }

    @Keep
    public b getUIDelegate() {
        return this.QUb;
    }

    public void a(int i2, int i3, int i4, d dVar) {
        AppMethodBeat.i(159634);
        this.QUb.a(i2, i3, i4, dVar);
        AppMethodBeat.o(159634);
    }

    public int getYear() {
        AppMethodBeat.i(159635);
        int year = this.QUb.getYear();
        AppMethodBeat.o(159635);
        return year;
    }

    public int getMonth() {
        AppMethodBeat.i(159636);
        int month = this.QUb.getMonth();
        AppMethodBeat.o(159636);
        return month;
    }

    public int getDayOfMonth() {
        AppMethodBeat.i(159637);
        int dayOfMonth = this.QUb.getDayOfMonth();
        AppMethodBeat.o(159637);
        return dayOfMonth;
    }

    public long getMinDate() {
        AppMethodBeat.i(159638);
        long timeInMillis = this.QUb.hcp().getTimeInMillis();
        AppMethodBeat.o(159638);
        return timeInMillis;
    }

    public void setMinDate(long j2) {
        AppMethodBeat.i(159639);
        this.QUb.setMinDate(j2);
        AppMethodBeat.o(159639);
    }

    public long getMaxDate() {
        AppMethodBeat.i(159640);
        long timeInMillis = this.QUb.hcq().getTimeInMillis();
        AppMethodBeat.o(159640);
        return timeInMillis;
    }

    public void setMaxDate(long j2) {
        AppMethodBeat.i(159641);
        this.QUb.setMaxDate(j2);
        AppMethodBeat.o(159641);
    }

    public void setValidationCallback(e eVar) {
        AppMethodBeat.i(159642);
        this.QUb.setValidationCallback(eVar);
        AppMethodBeat.o(159642);
    }

    public boolean isEnabled() {
        AppMethodBeat.i(159643);
        boolean isEnabled = this.QUb.isEnabled();
        AppMethodBeat.o(159643);
        return isEnabled;
    }

    public void setEnabled(boolean z) {
        AppMethodBeat.i(159644);
        if (this.QUb.isEnabled() == z) {
            AppMethodBeat.o(159644);
            return;
        }
        super.setEnabled(z);
        this.QUb.setEnabled(z);
        AppMethodBeat.o(159644);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.i(159645);
        boolean dispatchPopulateAccessibilityEvent = this.QUb.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        AppMethodBeat.o(159645);
        return dispatchPopulateAccessibilityEvent;
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.i(159646);
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        this.QUb.onPopulateAccessibilityEvent(accessibilityEvent);
        AppMethodBeat.o(159646);
    }

    public CharSequence getAccessibilityClassName() {
        AppMethodBeat.i(159647);
        String name = YADatePicker.class.getName();
        AppMethodBeat.o(159647);
        return name;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(159648);
        super.onConfigurationChanged(configuration);
        this.QUb.onConfigurationChanged(configuration);
        AppMethodBeat.o(159648);
    }

    public int getFirstDayOfWeek() {
        AppMethodBeat.i(159649);
        int firstDayOfWeek = this.QUb.getFirstDayOfWeek();
        AppMethodBeat.o(159649);
        return firstDayOfWeek;
    }

    public void setFirstDayOfWeek(int i2) {
        AppMethodBeat.i(159650);
        if (i2 <= 0 || i2 > 7) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("firstDayOfWeek must be between 1 and 7");
            AppMethodBeat.o(159650);
            throw illegalArgumentException;
        }
        this.QUb.setFirstDayOfWeek(i2);
        AppMethodBeat.o(159650);
    }

    public boolean getCalendarViewShown() {
        AppMethodBeat.i(159651);
        boolean calendarViewShown = this.QUb.getCalendarViewShown();
        AppMethodBeat.o(159651);
        return calendarViewShown;
    }

    public void setCalendarViewShown(boolean z) {
        AppMethodBeat.i(159652);
        this.QUb.setCalendarViewShown(z);
        AppMethodBeat.o(159652);
    }

    public CalendarView getCalendarView() {
        AppMethodBeat.i(159653);
        CalendarView calendarView = this.QUb.getCalendarView();
        AppMethodBeat.o(159653);
        return calendarView;
    }

    public boolean getSpinnersShown() {
        AppMethodBeat.i(159654);
        boolean spinnersShown = this.QUb.getSpinnersShown();
        AppMethodBeat.o(159654);
        return spinnersShown;
    }

    public void setSpinnersShown(boolean z) {
        AppMethodBeat.i(159655);
        this.QUb.setSpinnersShown(z);
        AppMethodBeat.o(159655);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View, android.view.ViewGroup
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        AppMethodBeat.i(159656);
        dispatchThawSelfOnly(sparseArray);
        AppMethodBeat.o(159656);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        AppMethodBeat.i(159657);
        Parcelable f2 = this.QUb.f(super.onSaveInstanceState());
        AppMethodBeat.o(159657);
        return f2;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.i(159658);
        View.BaseSavedState baseSavedState = (View.BaseSavedState) parcelable;
        super.onRestoreInstanceState(baseSavedState.getSuperState());
        this.QUb.onRestoreInstanceState(baseSavedState);
        AppMethodBeat.o(159658);
    }

    /* access modifiers changed from: package-private */
    public static abstract class a implements b {
        protected YADatePicker QUc;
        protected Locale QUd;
        protected d QUe;
        protected e QUf;
        protected Context mContext;

        protected a(YADatePicker yADatePicker, Context context) {
            this.QUc = yADatePicker;
            this.mContext = context;
            f(Locale.getDefault());
        }

        /* access modifiers changed from: protected */
        public void f(Locale locale) {
            if (!locale.equals(this.QUd)) {
                this.QUd = locale;
            }
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.b
        public void setValidationCallback(e eVar) {
            this.QUf = eVar;
        }
    }

    public static class c extends a {
        public final NumberPicker QUg;
        public final NumberPicker QUh;
        public final NumberPicker QUi;
        private final LinearLayout QUj;
        private final EditText QUk;
        private final EditText QUl;
        private final EditText QUm;
        private final CalendarView QUn;
        private final DateFormat QUo = new SimpleDateFormat("MM/dd/yyyy");
        private int QUp;
        private Calendar QUq;
        private Calendar QUr;
        Calendar QUs;
        private boolean QUt = true;
        Calendar ozj;
        private String[] ozk;

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.a, com.tencent.mm.ui.widget.picker.YADatePicker.b
        public final /* bridge */ /* synthetic */ void setValidationCallback(e eVar) {
            AppMethodBeat.i(159626);
            super.setValidationCallback(eVar);
            AppMethodBeat.o(159626);
        }

        c(YADatePicker yADatePicker, Context context, AttributeSet attributeSet, int i2) {
            super(yADatePicker, context);
            AppMethodBeat.i(159596);
            this.QUc = yADatePicker;
            this.mContext = context;
            f(Locale.getDefault());
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0296a.DatePicker, i2, 0);
            boolean z = obtainStyledAttributes.getBoolean(16, true);
            boolean z2 = obtainStyledAttributes.getBoolean(1, true);
            int i3 = obtainStyledAttributes.getInt(17, 1900);
            int i4 = obtainStyledAttributes.getInt(5, 2100);
            String string = obtainStyledAttributes.getString(15);
            String string2 = obtainStyledAttributes.getString(14);
            int resourceId = obtainStyledAttributes.getResourceId(13, R.layout.yy);
            obtainStyledAttributes.recycle();
            ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(resourceId, (ViewGroup) this.QUc, true);
            AnonymousClass1 r7 = new NumberPicker.OnValueChangeListener() {
                /* class com.tencent.mm.ui.widget.picker.YADatePicker.c.AnonymousClass1 */

                public final void onValueChange(NumberPicker numberPicker, int i2, int i3) {
                    AppMethodBeat.i(159594);
                    c.a(c.this);
                    c.this.ozj.setTimeInMillis(c.this.QUs.getTimeInMillis());
                    if (numberPicker == c.this.QUg) {
                        int actualMaximum = c.this.ozj.getActualMaximum(5);
                        if (i2 == actualMaximum && i3 == 1) {
                            c.this.ozj.add(5, 1);
                        } else if (i2 == 1 && i3 == actualMaximum) {
                            c.this.ozj.add(5, -1);
                        } else {
                            c.this.ozj.add(5, i3 - i2);
                        }
                    } else if (numberPicker == c.this.QUh) {
                        if (i2 == 11 && i3 == 0) {
                            c.this.ozj.add(2, 1);
                        } else if (i2 == 0 && i3 == 11) {
                            c.this.ozj.add(2, -1);
                        } else {
                            c.this.ozj.add(2, i3 - i2);
                        }
                    } else if (numberPicker == c.this.QUi) {
                        c.this.ozj.set(1, i3);
                    } else {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
                        AppMethodBeat.o(159594);
                        throw illegalArgumentException;
                    }
                    c.this.ba(c.this.ozj.get(1), c.this.ozj.get(2), c.this.ozj.get(5));
                    c.this.hct();
                    c.this.hcu();
                    c.b(c.this);
                    AppMethodBeat.o(159594);
                }
            };
            this.QUj = (LinearLayout) this.QUc.findViewById(R.id.gby);
            this.QUn = (CalendarView) this.QUc.findViewById(R.id.ahz);
            this.QUn.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                /* class com.tencent.mm.ui.widget.picker.YADatePicker.c.AnonymousClass2 */

                public final void onSelectedDayChange(CalendarView calendarView, int i2, int i3, int i4) {
                    AppMethodBeat.i(159595);
                    c.this.ba(i2, i3, i4);
                    c.this.hct();
                    c.b(c.this);
                    AppMethodBeat.o(159595);
                }
            });
            this.QUg = (NumberPicker) this.QUc.findViewById(R.id.bkr);
            this.QUg.setFormatter(new i());
            this.QUg.setOnLongPressUpdateInterval(100);
            this.QUg.setOnValueChangedListener(r7);
            this.QUk = f.b(this.QUg);
            this.QUh = (NumberPicker) this.QUc.findViewById(R.id.fjl);
            this.QUh.setMinValue(0);
            this.QUh.setMaxValue(this.QUp - 1);
            this.QUh.setDisplayedValues(this.ozk);
            this.QUh.setOnLongPressUpdateInterval(200);
            this.QUh.setOnValueChangedListener(r7);
            this.QUl = f.b(this.QUh);
            this.QUi = (NumberPicker) this.QUc.findViewById(R.id.jsl);
            this.QUi.setOnLongPressUpdateInterval(100);
            this.QUi.setOnValueChangedListener(r7);
            this.QUm = f.b(this.QUi);
            if (z || z2) {
                setSpinnersShown(z);
                setCalendarViewShown(z2);
            } else {
                setSpinnersShown(true);
            }
            this.ozj.clear();
            if (TextUtils.isEmpty(string) || !a(string, this.ozj)) {
                this.ozj.set(i3, 0, 1);
            }
            setMinDate(this.ozj.getTimeInMillis());
            this.ozj.clear();
            if (TextUtils.isEmpty(string2) || !a(string2, this.ozj)) {
                this.ozj.set(i4, 11, 31);
            }
            setMaxDate(this.ozj.getTimeInMillis());
            this.QUs.setTimeInMillis(System.currentTimeMillis());
            a(this.QUs.get(1), this.QUs.get(2), this.QUs.get(5), null);
            hcs();
            if (this.QUc.getImportantForAccessibility() == 0) {
                this.QUc.setImportantForAccessibility(1);
            }
            AppMethodBeat.o(159596);
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.b
        public final void a(int i2, int i3, int i4, d dVar) {
            AppMethodBeat.i(159597);
            ba(i2, i3, i4);
            hct();
            hcu();
            this.QUe = dVar;
            AppMethodBeat.o(159597);
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.b
        public final int getYear() {
            AppMethodBeat.i(159598);
            int i2 = this.QUs.get(1);
            AppMethodBeat.o(159598);
            return i2;
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.b
        public final int getMonth() {
            AppMethodBeat.i(159599);
            int i2 = this.QUs.get(2);
            AppMethodBeat.o(159599);
            return i2;
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.b
        public final int getDayOfMonth() {
            AppMethodBeat.i(159600);
            int i2 = this.QUs.get(5);
            AppMethodBeat.o(159600);
            return i2;
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.b
        public final int getFirstDayOfWeek() {
            AppMethodBeat.i(159601);
            int firstDayOfWeek = this.QUn.getFirstDayOfWeek();
            AppMethodBeat.o(159601);
            return firstDayOfWeek;
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.b
        public final void setFirstDayOfWeek(int i2) {
            AppMethodBeat.i(159602);
            this.QUn.setFirstDayOfWeek(i2);
            AppMethodBeat.o(159602);
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.b
        public final Calendar hcp() {
            AppMethodBeat.i(159603);
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(this.QUn.getMinDate());
            AppMethodBeat.o(159603);
            return instance;
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.b
        public final void setMinDate(long j2) {
            AppMethodBeat.i(159604);
            this.ozj.setTimeInMillis(j2);
            if (this.ozj.get(1) != this.QUq.get(1) || this.ozj.get(6) == this.QUq.get(6)) {
                this.QUq.setTimeInMillis(j2);
                this.QUn.setMinDate(j2);
                if (this.QUs.before(this.QUq)) {
                    this.QUs.setTimeInMillis(this.QUq.getTimeInMillis());
                    hcu();
                }
                hct();
                AppMethodBeat.o(159604);
                return;
            }
            AppMethodBeat.o(159604);
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.b
        public final Calendar hcq() {
            AppMethodBeat.i(159605);
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(this.QUn.getMaxDate());
            AppMethodBeat.o(159605);
            return instance;
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.b
        public final void setMaxDate(long j2) {
            AppMethodBeat.i(159606);
            this.ozj.setTimeInMillis(j2);
            if (this.ozj.get(1) != this.QUr.get(1) || this.ozj.get(6) == this.QUr.get(6)) {
                this.QUr.setTimeInMillis(j2);
                this.QUn.setMaxDate(j2);
                if (this.QUs.after(this.QUr)) {
                    this.QUs.setTimeInMillis(this.QUr.getTimeInMillis());
                    hcu();
                }
                hct();
                AppMethodBeat.o(159606);
                return;
            }
            AppMethodBeat.o(159606);
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.b
        public final boolean isEnabled() {
            return this.QUt;
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.b
        public final void setEnabled(boolean z) {
            AppMethodBeat.i(159607);
            this.QUg.setEnabled(z);
            this.QUh.setEnabled(z);
            this.QUi.setEnabled(z);
            this.QUn.setEnabled(z);
            this.QUt = z;
            AppMethodBeat.o(159607);
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.b
        public final CalendarView getCalendarView() {
            return this.QUn;
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.b
        public final boolean getCalendarViewShown() {
            AppMethodBeat.i(159608);
            if (this.QUn.getVisibility() == 0) {
                AppMethodBeat.o(159608);
                return true;
            }
            AppMethodBeat.o(159608);
            return false;
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.b
        public final void setCalendarViewShown(boolean z) {
            AppMethodBeat.i(159609);
            this.QUn.setVisibility(z ? 0 : 8);
            AppMethodBeat.o(159609);
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.b
        public final boolean getSpinnersShown() {
            AppMethodBeat.i(159610);
            boolean isShown = this.QUj.isShown();
            AppMethodBeat.o(159610);
            return isShown;
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.b
        public final void setSpinnersShown(boolean z) {
            AppMethodBeat.i(159611);
            this.QUj.setVisibility(z ? 0 : 8);
            AppMethodBeat.o(159611);
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.b
        public final void onConfigurationChanged(Configuration configuration) {
            AppMethodBeat.i(159612);
            f(configuration.locale);
            AppMethodBeat.o(159612);
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.b
        public final Parcelable f(Parcelable parcelable) {
            AppMethodBeat.i(159613);
            SavedState savedState = new SavedState(parcelable, getYear(), getMonth(), getDayOfMonth(), (byte) 0);
            AppMethodBeat.o(159613);
            return savedState;
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.b
        public final void onRestoreInstanceState(Parcelable parcelable) {
            AppMethodBeat.i(159614);
            SavedState savedState = (SavedState) parcelable;
            ba(savedState.mYear, savedState.mMonth, savedState.mDay);
            hct();
            hcu();
            AppMethodBeat.o(159614);
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.b
        public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            AppMethodBeat.i(159615);
            onPopulateAccessibilityEvent(accessibilityEvent);
            AppMethodBeat.o(159615);
            return true;
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.b
        public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            AppMethodBeat.i(159616);
            accessibilityEvent.getText().add(DateUtils.formatDateTime(this.mContext, this.QUs.getTimeInMillis(), 20));
            AppMethodBeat.o(159616);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.a
        public final void f(Locale locale) {
            AppMethodBeat.i(159617);
            super.f(locale);
            this.ozj = a(this.ozj, locale);
            this.QUq = a(this.QUq, locale);
            this.QUr = a(this.QUr, locale);
            this.QUs = a(this.QUs, locale);
            this.QUp = this.ozj.getActualMaximum(2) + 1;
            this.ozk = new DateFormatSymbols().getShortMonths();
            if (hcr()) {
                this.ozk = new String[this.QUp];
                for (int i2 = 0; i2 < this.QUp; i2++) {
                    this.ozk[i2] = String.format("%d", Integer.valueOf(i2 + 1));
                }
            }
            AppMethodBeat.o(159617);
        }

        private boolean hcr() {
            AppMethodBeat.i(159618);
            boolean isDigit = Character.isDigit(this.ozk[0].charAt(0));
            AppMethodBeat.o(159618);
            return isDigit;
        }

        private static Calendar a(Calendar calendar, Locale locale) {
            AppMethodBeat.i(159619);
            if (calendar == null) {
                Calendar instance = Calendar.getInstance(locale);
                AppMethodBeat.o(159619);
                return instance;
            }
            long timeInMillis = calendar.getTimeInMillis();
            Calendar instance2 = Calendar.getInstance(locale);
            instance2.setTimeInMillis(timeInMillis);
            AppMethodBeat.o(159619);
            return instance2;
        }

        private void hcs() {
            char[] cArr;
            AppMethodBeat.i(159620);
            this.QUj.removeAllViews();
            if (Build.VERSION.SDK_INT < 17 || this.QUc.getLayoutDirection() == 0) {
                cArr = new char[]{'y', 'M', 'd'};
            } else {
                cArr = android.text.format.DateFormat.getDateFormatOrder(this.QUc.getContext());
            }
            int length = cArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                switch (cArr[i2]) {
                    case TPCodecParamers.TP_PROFILE_H264_MAIN /*{ENCODED_INT: 77}*/:
                        this.QUj.addView(this.QUh);
                        a(this.QUh, length, i2);
                        break;
                    case 'd':
                        this.QUj.addView(this.QUg);
                        a(this.QUg, length, i2);
                        break;
                    case 'y':
                        this.QUj.addView(this.QUi);
                        a(this.QUi, length, i2);
                        break;
                    default:
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(Arrays.toString(cArr));
                        AppMethodBeat.o(159620);
                        throw illegalArgumentException;
                }
            }
            AppMethodBeat.o(159620);
        }

        private boolean a(String str, Calendar calendar) {
            AppMethodBeat.i(159621);
            try {
                calendar.setTime(this.QUo.parse(str));
                AppMethodBeat.o(159621);
                return true;
            } catch (ParseException e2) {
                as.w(YADatePicker.LOG_TAG, "Date: " + str + " not in format: MM/dd/yyyy", new Object[0]);
                AppMethodBeat.o(159621);
                return false;
            }
        }

        /* access modifiers changed from: package-private */
        public final void ba(int i2, int i3, int i4) {
            AppMethodBeat.i(159622);
            this.QUs.set(i2, i3, i4);
            if (this.QUs.before(this.QUq)) {
                this.QUs.setTimeInMillis(this.QUq.getTimeInMillis());
                AppMethodBeat.o(159622);
                return;
            }
            if (this.QUs.after(this.QUr)) {
                this.QUs.setTimeInMillis(this.QUr.getTimeInMillis());
            }
            AppMethodBeat.o(159622);
        }

        /* access modifiers changed from: package-private */
        public final void hct() {
            AppMethodBeat.i(159623);
            if (this.QUs.equals(this.QUq)) {
                this.QUg.setMinValue(this.QUs.get(5));
                this.QUg.setMaxValue(this.QUs.getActualMaximum(5));
                this.QUg.setWrapSelectorWheel(false);
                this.QUh.setDisplayedValues(null);
                this.QUh.setMinValue(this.QUs.get(2));
                this.QUh.setMaxValue(this.QUs.getActualMaximum(2));
                this.QUh.setWrapSelectorWheel(false);
            } else if (this.QUs.equals(this.QUr)) {
                this.QUg.setMinValue(this.QUs.getActualMinimum(5));
                this.QUg.setMaxValue(this.QUs.get(5));
                this.QUg.setWrapSelectorWheel(false);
                this.QUh.setDisplayedValues(null);
                this.QUh.setMinValue(this.QUs.getActualMinimum(2));
                this.QUh.setMaxValue(this.QUs.get(2));
                this.QUh.setWrapSelectorWheel(false);
            } else {
                this.QUg.setMinValue(1);
                this.QUg.setMaxValue(this.QUs.getActualMaximum(5));
                this.QUg.setWrapSelectorWheel(true);
                this.QUh.setDisplayedValues(null);
                this.QUh.setMinValue(0);
                this.QUh.setMaxValue(11);
                this.QUh.setWrapSelectorWheel(true);
            }
            this.QUh.setDisplayedValues((String[]) Arrays.copyOfRange(this.ozk, this.QUh.getMinValue(), this.QUh.getMaxValue() + 1));
            this.QUi.setMinValue(this.QUq.get(1));
            this.QUi.setMaxValue(this.QUr.get(1));
            this.QUi.setWrapSelectorWheel(false);
            this.QUi.setValue(this.QUs.get(1));
            this.QUh.setValue(this.QUs.get(2));
            this.QUg.setValue(this.QUs.get(5));
            if (hcr()) {
                this.QUl.setRawInputType(2);
            }
            AppMethodBeat.o(159623);
        }

        /* access modifiers changed from: package-private */
        public final void hcu() {
            AppMethodBeat.i(159624);
            this.QUn.setDate(this.QUs.getTimeInMillis(), false, false);
            AppMethodBeat.o(159624);
        }

        private static void a(NumberPicker numberPicker, int i2, int i3) {
            int i4;
            AppMethodBeat.i(159625);
            if (i3 < i2 - 1) {
                i4 = 5;
            } else {
                i4 = 6;
            }
            EditText b2 = f.b(numberPicker);
            if (b2 != null) {
                b2.setImeOptions(i4);
            }
            AppMethodBeat.o(159625);
        }

        static /* synthetic */ void a(c cVar) {
            AppMethodBeat.i(159627);
            InputMethodManager inputMethodManager = (InputMethodManager) cVar.QUc.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                if (inputMethodManager.isActive(cVar.QUm)) {
                    cVar.QUm.clearFocus();
                    inputMethodManager.hideSoftInputFromWindow(cVar.QUc.getWindowToken(), 0);
                    AppMethodBeat.o(159627);
                    return;
                } else if (inputMethodManager.isActive(cVar.QUl)) {
                    cVar.QUl.clearFocus();
                    inputMethodManager.hideSoftInputFromWindow(cVar.QUc.getWindowToken(), 0);
                    AppMethodBeat.o(159627);
                    return;
                } else if (inputMethodManager.isActive(cVar.QUk)) {
                    cVar.QUk.clearFocus();
                    inputMethodManager.hideSoftInputFromWindow(cVar.QUc.getWindowToken(), 0);
                }
            }
            AppMethodBeat.o(159627);
        }

        static /* synthetic */ void b(c cVar) {
            AppMethodBeat.i(159628);
            cVar.QUc.sendAccessibilityEvent(4);
            if (cVar.QUe != null) {
                cVar.getYear();
                cVar.getMonth();
                cVar.getDayOfMonth();
            }
            AppMethodBeat.o(159628);
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.tencent.mm.ui.widget.picker.YADatePicker.SavedState.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ SavedState createFromParcel(Parcel parcel) {
                AppMethodBeat.i(159629);
                SavedState savedState = new SavedState(parcel, (byte) 0);
                AppMethodBeat.o(159629);
                return savedState;
            }
        };
        private final int mDay;
        private final int mMonth;
        private final int mYear;

        /* synthetic */ SavedState(Parcel parcel, byte b2) {
            this(parcel);
        }

        /* synthetic */ SavedState(Parcelable parcelable, int i2, int i3, int i4, byte b2) {
            this(parcelable, i2, i3, i4);
        }

        static {
            AppMethodBeat.i(159632);
            AppMethodBeat.o(159632);
        }

        private SavedState(Parcelable parcelable, int i2, int i3, int i4) {
            super(parcelable);
            this.mYear = i2;
            this.mMonth = i3;
            this.mDay = i4;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            AppMethodBeat.i(159630);
            this.mYear = parcel.readInt();
            this.mMonth = parcel.readInt();
            this.mDay = parcel.readInt();
            AppMethodBeat.o(159630);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(159631);
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.mYear);
            parcel.writeInt(this.mMonth);
            parcel.writeInt(this.mDay);
            AppMethodBeat.o(159631);
        }
    }
}
