package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import java.security.InvalidParameterException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

public final class c extends View {
    protected static int gBc = 32;
    protected static int gBd;
    protected static int gBe = 1;
    protected static int gBf;
    protected static int gBg = 10;
    protected static int gBh;
    protected static int gBi;
    protected static int gBj;
    protected boolean gBA = false;
    protected int gBB = -1;
    protected int gBC = -1;
    protected int gBD = -1;
    protected int gBE = -1;
    protected int gBF = -1;
    protected int gBG = -1;
    protected int gBH = -1;
    protected int gBI = 1;
    protected int gBJ = 7;
    protected int gBK = this.gBJ;
    private int gBL = 0;
    protected Boolean gBM;
    protected int gBN = gBc;
    protected int gBO = 0;
    final Time gBP;
    private final Calendar gBQ;
    private final Boolean gBR;
    private DateFormatSymbols gBS = new DateFormatSymbols();
    private a gBT;
    protected Paint gBk;
    protected Paint gBl;
    protected Paint gBm;
    protected Paint gBn;
    protected Paint gBo;
    protected int gBp;
    protected int gBq;
    protected int gBr;
    protected int gBs;
    protected int gBt;
    protected int gBu;
    protected int gBv;
    protected int gBw;
    protected int gBx;
    private final StringBuilder gBy;
    protected boolean gBz = false;
    Collection<com.tencent.mm.chatroom.d.a> guY = new ArrayList();
    private final Calendar mCalendar;
    private Context mContext;
    protected int mMonth;
    public int mNumRows = 6;
    protected int mPadding = 80;
    protected int mWidth;
    protected int mYear;

    public interface a {
        void b(com.tencent.mm.chatroom.d.a aVar);
    }

    public c(Context context, TypedArray typedArray) {
        super(context);
        AppMethodBeat.i(12992);
        this.mContext = context;
        Resources resources = context.getResources();
        this.gBQ = Calendar.getInstance();
        this.mCalendar = Calendar.getInstance();
        this.gBP = new Time(Time.getCurrentTimezone());
        this.gBP.setToNow();
        this.gBp = typedArray.getColor(2, resources.getColor(R.color.a2u));
        this.gBq = typedArray.getColor(5, resources.getColor(R.color.a2u));
        this.gBr = typedArray.getColor(3, resources.getColor(R.color.a2u));
        this.gBs = typedArray.getColor(3, resources.getColor(R.color.a2v));
        this.gBt = typedArray.getColor(6, resources.getColor(R.color.a2u));
        this.gBv = typedArray.getColor(7, resources.getColor(R.color.a2u));
        this.gBw = typedArray.getColor(4, resources.getColor(R.color.zq));
        this.gBx = typedArray.getColor(8, resources.getColor(R.color.a6r));
        this.gBu = typedArray.getColor(9, resources.getColor(R.color.a6s));
        this.gBM = Boolean.valueOf(typedArray.getBoolean(11, false));
        this.gBy = new StringBuilder(50);
        gBf = typedArray.getDimensionPixelSize(18, resources.getDimensionPixelSize(R.dimen.amb));
        gBj = typedArray.getDimensionPixelSize(20, resources.getDimensionPixelSize(R.dimen.amd));
        gBh = typedArray.getDimensionPixelSize(19, resources.getDimensionPixelSize(R.dimen.amc));
        gBi = typedArray.getDimensionPixelOffset(14, resources.getDimensionPixelOffset(R.dimen.a8x));
        gBd = typedArray.getDimensionPixelSize(17, resources.getDimensionPixelOffset(R.dimen.aii));
        this.gBN = (typedArray.getDimensionPixelSize(0, resources.getDimensionPixelOffset(R.dimen.uo)) - gBi) / 6;
        this.gBO = typedArray.getDimensionPixelSize(1, resources.getDimensionPixelOffset(R.dimen.w8));
        this.gBR = Boolean.valueOf(typedArray.getBoolean(12, true));
        this.gBn = new Paint();
        this.gBn.setAntiAlias(true);
        this.gBn.setTextSize((float) gBj);
        this.gBn.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        this.gBn.setColor(this.gBs);
        this.gBn.setTextAlign(Paint.Align.LEFT);
        this.gBn.setStyle(Paint.Style.FILL);
        this.gBm = new Paint();
        this.gBm.setFakeBoldText(true);
        this.gBm.setAntiAlias(true);
        this.gBm.setColor(this.gBu);
        this.gBm.setTextAlign(Paint.Align.CENTER);
        this.gBm.setStyle(Paint.Style.FILL);
        this.gBo = new Paint();
        this.gBo.setFakeBoldText(true);
        this.gBo.setAntiAlias(true);
        this.gBo.setColor(this.gBx);
        this.gBo.setTextAlign(Paint.Align.CENTER);
        this.gBo.setStyle(Paint.Style.FILL);
        this.gBk = new Paint();
        this.gBk.setAntiAlias(true);
        this.gBk.setTextSize((float) gBh);
        this.gBk.setColor(this.gBs);
        this.gBk.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        this.gBk.setStyle(Paint.Style.FILL);
        this.gBk.setTextAlign(Paint.Align.CENTER);
        this.gBk.setFakeBoldText(true);
        this.gBl = new Paint();
        this.gBl.setAntiAlias(true);
        this.gBl.setTextSize((float) gBf);
        this.gBl.setStyle(Paint.Style.FILL);
        this.gBl.setTextAlign(Paint.Align.CENTER);
        this.gBl.setFakeBoldText(false);
        AppMethodBeat.o(12992);
    }

    private void f(Canvas canvas) {
        AppMethodBeat.i(12993);
        int i2 = gBi - (gBh / 2);
        int i3 = (this.mWidth - (this.mPadding * 2)) / (this.gBJ * 2);
        for (int i4 = 0; i4 < this.gBJ; i4++) {
            int i5 = (this.gBI + i4) % this.gBJ;
            int i6 = (((i4 * 2) + 1) * i3) + this.mPadding;
            this.gBQ.set(7, i5);
            canvas.drawText(this.gBS.getShortWeekdays()[this.gBQ.get(7)].toUpperCase(Locale.getDefault()), (float) i6, (float) i2, this.gBk);
        }
        AppMethodBeat.o(12993);
    }

    private int ans() {
        return (this.gBL < this.gBI ? this.gBL + this.gBJ : this.gBL) - this.gBI;
    }

    private String getMonthAndYearString() {
        AppMethodBeat.i(12994);
        this.gBy.setLength(0);
        long timeInMillis = this.mCalendar.getTimeInMillis();
        String formatDateRange = DateUtils.formatDateRange(getContext(), timeInMillis, timeInMillis, 52);
        AppMethodBeat.o(12994);
        return formatDateRange;
    }

    private boolean a(int i2, Time time) {
        return this.mYear < time.year || (this.mYear == time.year && this.mMonth < time.month) || (this.mMonth == time.month && i2 < time.monthDay);
    }

    private void g(Canvas canvas) {
        AppMethodBeat.i(12995);
        int i2 = (((this.gBN + gBf) / 2) - gBe) + gBi;
        int i3 = (this.mWidth - (this.mPadding * 2)) / (this.gBJ * 2);
        int ans = ans();
        int i4 = 1;
        while (i4 <= this.gBK && (i4 <= this.gBH || -1 == this.gBH)) {
            int i5 = this.mPadding + (((ans * 2) + 1) * i3);
            if ((this.mMonth == this.gBD && this.gBB == i4 && this.gBF == this.mYear) || ((this.mMonth == this.gBE && this.gBC == i4 && this.gBG == this.mYear) || (this.gBz && this.gBH == i4 && this.gBB == -1))) {
                if (this.gBM.booleanValue()) {
                    canvas.drawRoundRect(new RectF((float) (i5 - gBd), (float) ((i2 - (gBf / 3)) - gBd), (float) (gBd + i5), (float) ((i2 - (gBf / 3)) + gBd)), 10.0f, 10.0f, this.gBo);
                } else {
                    canvas.drawCircle((float) i5, (float) (i2 - (gBf / 3)), (float) gBd, this.gBo);
                }
                if (this.gBz && this.gBH == i4 && this.gBB == -1) {
                    this.gBl.setColor(this.gBx);
                    this.gBl.setTypeface(Typeface.defaultFromStyle(0));
                    this.gBl.setTextSize(30.0f);
                    canvas.drawText(this.mContext.getResources().getString(R.string.hp7), (float) i5, (float) (i2 + 12 + gBd), this.gBl);
                }
            }
            this.gBl.setTextSize((float) gBf);
            if (!this.gBz || this.gBH != i4) {
                this.gBl.setColor(this.gBt);
                this.gBl.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.gBB != -1 && this.gBC != -1 && this.gBF == this.gBG && this.gBD == this.gBE && this.gBB == this.gBC && i4 == this.gBB && this.mMonth == this.gBD && this.mYear == this.gBF) {
                this.gBl.setColor(this.gBx);
            }
            if (this.gBB != -1 && this.gBC != -1 && this.gBF == this.gBG && this.gBF == this.mYear && ((this.mMonth == this.gBD && this.gBE == this.gBD && ((this.gBB < this.gBC && i4 > this.gBB && i4 < this.gBC) || (this.gBB > this.gBC && i4 < this.gBB && i4 > this.gBC))) || ((this.gBD < this.gBE && this.mMonth == this.gBD && i4 > this.gBB) || ((this.gBD < this.gBE && this.mMonth == this.gBE && i4 < this.gBC) || ((this.gBD > this.gBE && this.mMonth == this.gBD && i4 < this.gBB) || (this.gBD > this.gBE && this.mMonth == this.gBE && i4 > this.gBC)))))) {
                this.gBl.setColor(this.gBx);
            }
            if (!(this.gBB == -1 || this.gBC == -1 || this.gBF == this.gBG || (!((this.gBF == this.mYear && this.mMonth == this.gBD) || (this.gBG == this.mYear && this.mMonth == this.gBE)) || ((this.gBD >= this.gBE || this.mMonth != this.gBD || i4 >= this.gBB) && ((this.gBD >= this.gBE || this.mMonth != this.gBE || i4 <= this.gBC) && ((this.gBD <= this.gBE || this.mMonth != this.gBD || i4 <= this.gBB) && (this.gBD <= this.gBE || this.mMonth != this.gBE || i4 >= this.gBC))))))) {
                this.gBl.setColor(this.gBx);
            }
            if (this.gBB != -1 && this.gBC != -1 && this.gBF == this.gBG && this.mYear == this.gBF && ((this.mMonth > this.gBD && this.mMonth < this.gBE && this.gBD < this.gBE) || (this.mMonth < this.gBD && this.mMonth > this.gBE && this.gBD > this.gBE))) {
                this.gBl.setColor(this.gBx);
            }
            if (!(this.gBB == -1 || this.gBC == -1 || this.gBF == this.gBG || ((this.gBF >= this.gBG || ((this.mMonth <= this.gBD || this.mYear != this.gBF) && (this.mMonth >= this.gBE || this.mYear != this.gBG))) && (this.gBF <= this.gBG || ((this.mMonth >= this.gBD || this.mYear != this.gBF) && (this.mMonth <= this.gBE || this.mYear != this.gBG)))))) {
                this.gBl.setColor(this.gBx);
            }
            if (!this.gBR.booleanValue() && a(i4, this.gBP) && this.gBP.month == this.mMonth && this.gBP.year == this.mYear) {
                this.gBl.setColor(this.gBv);
                this.gBl.setTypeface(Typeface.defaultFromStyle(2));
            }
            for (com.tencent.mm.chatroom.d.a aVar : this.guY) {
                if (aVar.grV == i4 && aVar.month == this.mMonth && aVar.year == this.mYear) {
                    this.gBl.setColor(this.gBw);
                    this.gBl.setTypeface(Typeface.defaultFromStyle(0));
                }
            }
            if ((this.mMonth == this.gBD && this.gBB == i4 && this.gBF == this.mYear) || ((this.mMonth == this.gBE && this.gBC == i4 && this.gBG == this.mYear) || (this.gBz && this.gBH == i4 && this.gBB == -1))) {
                this.gBl.setTypeface(Typeface.defaultFromStyle(0));
                this.gBl.setColor(-1);
            }
            canvas.drawText(String.format("%d", Integer.valueOf(i4)), (float) i5, (float) i2, this.gBl);
            ans++;
            if (ans == this.gBJ) {
                ans = 0;
                i2 += this.gBN;
            }
            i4++;
        }
        AppMethodBeat.o(12995);
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(12997);
        setMeasuredDimension(View.MeasureSpec.getSize(i2), (this.gBN * this.mNumRows) + gBi + this.gBO);
        AppMethodBeat.o(12997);
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.mWidth = i2;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        com.tencent.mm.chatroom.d.a aVar;
        AppMethodBeat.i(12998);
        if (motionEvent.getAction() == 1) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int i2 = this.mPadding;
            if (x >= ((float) i2) && x <= ((float) (this.mWidth - this.mPadding))) {
                int ans = (((int) (((x - ((float) i2)) * ((float) this.gBJ)) / ((float) ((this.mWidth - i2) - this.mPadding)))) - ans()) + 1 + ((((int) (y - ((float) gBi))) / this.gBN) * this.gBJ);
                if (this.mMonth <= 11 && this.mMonth >= 0 && com.tencent.mm.chatroom.h.a.cr(this.mMonth, this.mYear) >= ans && ans > 0) {
                    com.tencent.mm.chatroom.d.a aVar2 = new com.tencent.mm.chatroom.d.a(this.mYear, this.mMonth, ans);
                    Iterator<com.tencent.mm.chatroom.d.a> it = this.guY.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            aVar = null;
                            break;
                        }
                        aVar = it.next();
                        if (aVar.equals(aVar2)) {
                            break;
                        }
                    }
                } else {
                    aVar = null;
                }
            } else {
                aVar = null;
            }
            if (!(aVar == null || this.gBT == null || (!this.gBR.booleanValue() && aVar.month == this.gBP.month && aVar.year == this.gBP.year && aVar.grV < this.gBP.monthDay))) {
                this.gBT.b(aVar);
            }
        }
        AppMethodBeat.o(12998);
        return true;
    }

    public final void setMarkDate(Collection<com.tencent.mm.chatroom.d.a> collection) {
        AppMethodBeat.i(12999);
        if (collection != null) {
            this.guY = collection;
            AppMethodBeat.o(12999);
            return;
        }
        Log.e("MicroMsg.SimpleMonthView", "markDateList is null");
        AppMethodBeat.o(12999);
    }

    public final void setMonthParams(HashMap<String, Integer> hashMap) {
        int i2 = 0;
        AppMethodBeat.i(13000);
        if (hashMap.containsKey("month") || hashMap.containsKey("year")) {
            setTag(hashMap);
            if (hashMap.containsKey("height")) {
                this.gBN = hashMap.get("height").intValue();
                if (this.gBN < gBg) {
                    this.gBN = gBg;
                }
            }
            if (hashMap.containsKey("selected_begin_day")) {
                this.gBB = hashMap.get("selected_begin_day").intValue();
            }
            if (hashMap.containsKey("selected_last_day")) {
                this.gBC = hashMap.get("selected_last_day").intValue();
            }
            if (hashMap.containsKey("selected_begin_month")) {
                this.gBD = hashMap.get("selected_begin_month").intValue();
            }
            if (hashMap.containsKey("selected_last_month")) {
                this.gBE = hashMap.get("selected_last_month").intValue();
            }
            if (hashMap.containsKey("selected_begin_year")) {
                this.gBF = hashMap.get("selected_begin_year").intValue();
            }
            if (hashMap.containsKey("selected_last_year")) {
                this.gBG = hashMap.get("selected_last_year").intValue();
            }
            this.mMonth = hashMap.get("month").intValue();
            this.mYear = hashMap.get("year").intValue();
            this.gBz = false;
            this.gBH = -1;
            this.mCalendar.set(2, this.mMonth);
            this.mCalendar.set(1, this.mYear);
            this.mCalendar.set(5, 1);
            this.gBL = this.mCalendar.get(7);
            if (hashMap.containsKey("week_start")) {
                this.gBI = hashMap.get("week_start").intValue();
            } else {
                this.gBI = this.mCalendar.getFirstDayOfWeek();
            }
            this.gBK = com.tencent.mm.chatroom.h.a.cr(this.mMonth, this.mYear);
            for (int i3 = 0; i3 < this.gBK; i3++) {
                int i4 = i3 + 1;
                Time time = this.gBP;
                if (this.mYear == time.year && this.mMonth == time.month && i4 == time.monthDay) {
                    this.gBz = true;
                    this.gBH = i4;
                }
                this.gBA = a(i4, this.gBP);
            }
            int ans = ans();
            int i5 = (this.gBK + ans) / this.gBJ;
            if ((ans + this.gBK) % this.gBJ > 0) {
                i2 = 1;
            }
            this.mNumRows = i5 + i2;
            AppMethodBeat.o(13000);
            return;
        }
        InvalidParameterException invalidParameterException = new InvalidParameterException("You must specify month and year for this view");
        AppMethodBeat.o(13000);
        throw invalidParameterException;
    }

    public final void setOnDayClickListener(a aVar) {
        this.gBT = aVar;
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(12996);
        int i2 = (((this.mWidth - (this.mPadding * 2)) / (this.gBJ * 2)) + this.mPadding) - (gBj / 2);
        int i3 = ((gBi - gBj) / 2) + gBj;
        StringBuilder sb = new StringBuilder(getMonthAndYearString().toLowerCase());
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        canvas.drawText(sb.toString(), (float) i2, (float) i3, this.gBn);
        canvas.drawLine(0.0f, (float) gBi, (float) this.mWidth, (float) (gBi + 1), this.gBn);
        f(canvas);
        g(canvas);
        AppMethodBeat.o(12996);
    }
}
