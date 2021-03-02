package com.tencent.mm.ui.widget.happybubble;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ae.a;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;

public class LabelsView extends ViewGroup implements View.OnClickListener {
    private static final int QQR = R.id.ih2;
    private static final int QQS = R.id.ih4;
    private ColorStateList BpJ;
    private boolean OYB = false;
    private Drawable QQC;
    private int QQD = -2;
    private int QQE = -2;
    private int QQF = 17;
    private int QQG;
    private int QQH;
    private int QQI;
    private int QQJ;
    private int QQK;
    private int QQL;
    private e QQM;
    private int QQN;
    private int QQO;
    private int QQP = 1;
    private boolean QQQ;
    private ArrayList<Object> QQT = new ArrayList<>();
    private ArrayList<Integer> QQU = new ArrayList<>();
    private ArrayList<Integer> QQV = new ArrayList<>();
    private b QQW;
    private c QQX;
    private d QQY;
    private float gPN;
    private Context mContext;
    private int pME;

    public interface a<T> {
        CharSequence a(TextView textView, int i2, T t);
    }

    public interface b {
        void j(Object obj, int i2);
    }

    public interface c {
    }

    public interface d {
        boolean hbR();
    }

    public enum e {
        NONE(1),
        SINGLE(2),
        SINGLE_IRREVOCABLY(3),
        MULTI(4);
        
        int value;

        public static e valueOf(String str) {
            AppMethodBeat.i(143561);
            e eVar = (e) Enum.valueOf(e.class, str);
            AppMethodBeat.o(143561);
            return eVar;
        }

        static {
            AppMethodBeat.i(143562);
            AppMethodBeat.o(143562);
        }

        private e(int i2) {
            this.value = i2;
        }

        static e aph(int i2) {
            switch (i2) {
                case 1:
                    return NONE;
                case 2:
                    return SINGLE;
                case 3:
                    return SINGLE_IRREVOCABLY;
                case 4:
                    return MULTI;
                default:
                    return NONE;
            }
        }
    }

    public LabelsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(143563);
        this.mContext = context;
        f(context, attributeSet);
        hbM();
        AppMethodBeat.o(143563);
    }

    public LabelsView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(143564);
        this.mContext = context;
        f(context, attributeSet);
        hbM();
        AppMethodBeat.o(143564);
    }

    private void f(Context context, AttributeSet attributeSet) {
        AppMethodBeat.i(143565);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0244a.labels_view);
            this.QQM = e.aph(obtainStyledAttributes.getInt(16, 1));
            this.QQN = obtainStyledAttributes.getInteger(14, 0);
            this.QQO = obtainStyledAttributes.getInteger(15, 0);
            this.pME = obtainStyledAttributes.getInteger(13, 0);
            this.QQQ = obtainStyledAttributes.getBoolean(0, false);
            this.QQF = obtainStyledAttributes.getInt(2, this.QQF);
            this.QQD = obtainStyledAttributes.getLayoutDimension(11, this.QQD);
            this.QQE = obtainStyledAttributes.getLayoutDimension(4, this.QQE);
            if (obtainStyledAttributes.hasValue(3)) {
                this.BpJ = obtainStyledAttributes.getColorStateList(3);
            } else {
                this.BpJ = ColorStateList.valueOf(WebView.NIGHT_MODE_COLOR);
            }
            this.gPN = obtainStyledAttributes.getDimension(10, (float) hbQ());
            if (obtainStyledAttributes.hasValue(5)) {
                int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(5, 0);
                this.QQJ = dimensionPixelOffset;
                this.QQI = dimensionPixelOffset;
                this.QQH = dimensionPixelOffset;
                this.QQG = dimensionPixelOffset;
            } else {
                this.QQG = obtainStyledAttributes.getDimensionPixelOffset(7, cB(10.0f));
                this.QQH = obtainStyledAttributes.getDimensionPixelOffset(9, cB(5.0f));
                this.QQI = obtainStyledAttributes.getDimensionPixelOffset(8, cB(10.0f));
                this.QQJ = obtainStyledAttributes.getDimensionPixelOffset(6, cB(5.0f));
            }
            this.QQL = obtainStyledAttributes.getDimensionPixelOffset(12, cB(5.0f));
            this.QQK = obtainStyledAttributes.getDimensionPixelOffset(18, cB(5.0f));
            if (obtainStyledAttributes.hasValue(1)) {
                int resourceId = obtainStyledAttributes.getResourceId(1, 0);
                if (resourceId != 0) {
                    this.QQC = getResources().getDrawable(resourceId);
                } else {
                    this.QQC = new ColorDrawable(obtainStyledAttributes.getColor(1, 0));
                }
            } else {
                this.QQC = getResources().getDrawable(R.drawable.rf);
            }
            this.OYB = obtainStyledAttributes.getBoolean(17, false);
            obtainStyledAttributes.recycle();
        }
        AppMethodBeat.o(143565);
    }

    private void hbM() {
        AppMethodBeat.i(143566);
        if (isInEditMode()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("Label 1");
            arrayList.add("Label 2");
            arrayList.add("Label 3");
            arrayList.add("Label 4");
            arrayList.add("Label 5");
            arrayList.add("Label 6");
            arrayList.add("Label 7");
            setLabels(arrayList);
        }
        AppMethodBeat.o(143566);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(143567);
        if (this.OYB) {
            int childCount = getChildCount();
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                measureChild(childAt, i2, i3);
                i5 += childAt.getMeasuredWidth();
                if (i6 != childCount - 1) {
                    i5 += this.QQK;
                }
                i4 = Math.max(i4, childAt.getMeasuredHeight());
            }
            setMeasuredDimension(lH(i2, i5 + getPaddingLeft() + getPaddingRight()), lH(i3, getPaddingTop() + i4 + getPaddingBottom()));
            AppMethodBeat.o(143567);
            return;
        }
        int childCount2 = getChildCount();
        int size = (View.MeasureSpec.getSize(i2) - getPaddingLeft()) - getPaddingRight();
        int i7 = 1;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < childCount2; i12++) {
            View childAt2 = getChildAt(i12);
            measureChild(childAt2, i2, i3);
            if (childAt2.getMeasuredWidth() + i10 > size) {
                i7++;
                if (this.pME > 0 && i7 > this.pME) {
                    break;
                }
                i11 = i11 + this.QQL + i8;
                i9 = Math.max(i9, i10);
                i8 = 0;
                i10 = 0;
            }
            i10 += childAt2.getMeasuredWidth();
            i8 = Math.max(i8, childAt2.getMeasuredHeight());
            if (i12 != childCount2 - 1) {
                if (this.QQK + i10 > size) {
                    i7++;
                    if (this.pME > 0 && i7 > this.pME) {
                        break;
                    }
                    i11 = i11 + this.QQL + i8;
                    i9 = Math.max(i9, i10);
                    i8 = 0;
                    i10 = 0;
                } else {
                    i10 += this.QQK;
                }
            }
        }
        this.QQP = i7;
        setMeasuredDimension(lH(i2, Math.max(i9, i10) + getPaddingLeft() + getPaddingRight()), lH(i3, i11 + i8 + getPaddingTop() + getPaddingBottom()));
        AppMethodBeat.o(143567);
    }

    private int lH(int i2, int i3) {
        AppMethodBeat.i(143568);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            i3 = size;
        } else if (mode == Integer.MIN_VALUE) {
            i3 = Math.min(i3, size);
        }
        int resolveSizeAndState = resolveSizeAndState(Math.max(i3, getSuggestedMinimumWidth()), i2, 0);
        AppMethodBeat.o(143568);
        return resolveSizeAndState;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(143569);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i6 = i4 - i2;
        int i7 = 0;
        int i8 = 1;
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (!this.OYB && i6 < childAt.getMeasuredWidth() + paddingLeft + getPaddingRight()) {
                i8++;
                if (this.pME > 0 && i8 > this.pME) {
                    break;
                }
                paddingLeft = getPaddingLeft();
                paddingTop = paddingTop + this.QQL + i7;
                i7 = 0;
            }
            childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
            paddingLeft = paddingLeft + childAt.getMeasuredWidth() + this.QQK;
            i7 = Math.max(i7, childAt.getMeasuredHeight());
        }
        AppMethodBeat.o(143569);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        AppMethodBeat.i(143570);
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_super_state", super.onSaveInstanceState());
        if (this.BpJ != null) {
            bundle.putParcelable("key_text_color_state", this.BpJ);
        }
        bundle.putFloat("key_text_size_state", this.gPN);
        bundle.putInt("key_label_width_state", this.QQD);
        bundle.putInt("key_label_height_state", this.QQE);
        bundle.putInt("key_label_gravity_state", this.QQF);
        bundle.putIntArray("key_padding_state", new int[]{this.QQG, this.QQH, this.QQI, this.QQJ});
        bundle.putInt("key_word_margin_state", this.QQK);
        bundle.putInt("key_line_margin_state", this.QQL);
        bundle.putInt("key_select_type_state", this.QQM.value);
        bundle.putInt("key_max_select_state", this.QQN);
        bundle.putInt("key_min_select_state", this.QQO);
        bundle.putInt("key_max_lines_state", this.pME);
        bundle.putBoolean("key_indicator_state", this.QQQ);
        if (!this.QQU.isEmpty()) {
            bundle.putIntegerArrayList("key_select_labels_state", this.QQU);
        }
        if (!this.QQV.isEmpty()) {
            bundle.putIntegerArrayList("key_select_compulsory_state", this.QQV);
        }
        bundle.putBoolean("key_single_line_state", this.OYB);
        AppMethodBeat.o(143570);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.i(143571);
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable("key_super_state"));
            ColorStateList colorStateList = (ColorStateList) bundle.getParcelable("key_text_color_state");
            if (colorStateList != null) {
                setLabelTextColor(colorStateList);
            }
            setLabelTextSize(bundle.getFloat("key_text_size_state", this.gPN));
            this.QQD = bundle.getInt("key_label_width_state", this.QQD);
            this.QQE = bundle.getInt("key_label_height_state", this.QQE);
            setLabelGravity(bundle.getInt("key_label_gravity_state", this.QQF));
            int[] intArray = bundle.getIntArray("key_padding_state");
            if (intArray != null && intArray.length == 4) {
                int i2 = intArray[0];
                int i3 = intArray[1];
                int i4 = intArray[2];
                int i5 = intArray[3];
                if (!(this.QQG == i2 && this.QQH == i3 && this.QQI == i4 && this.QQJ == i5)) {
                    this.QQG = i2;
                    this.QQH = i3;
                    this.QQI = i4;
                    this.QQJ = i5;
                    int childCount = getChildCount();
                    for (int i6 = 0; i6 < childCount; i6++) {
                        ((TextView) getChildAt(i6)).setPadding(i2, i3, i4, i5);
                    }
                }
            }
            setWordMargin(bundle.getInt("key_word_margin_state", this.QQK));
            setLineMargin(bundle.getInt("key_line_margin_state", this.QQL));
            setSelectType(e.aph(bundle.getInt("key_select_type_state", this.QQM.value)));
            setMaxSelect(bundle.getInt("key_max_select_state", this.QQN));
            setMinSelect(bundle.getInt("key_min_select_state", this.QQO));
            setMaxLines(bundle.getInt("key_max_lines_state", this.pME));
            setIndicator(bundle.getBoolean("key_indicator_state", this.QQQ));
            setSingleLine(bundle.getBoolean("key_single_line_state", this.OYB));
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("key_select_compulsory_state");
            if (integerArrayList != null && !integerArrayList.isEmpty()) {
                setCompulsorys(integerArrayList);
            }
            ArrayList<Integer> integerArrayList2 = bundle.getIntegerArrayList("key_select_labels_state");
            if (integerArrayList2 != null && !integerArrayList2.isEmpty()) {
                int size = integerArrayList2.size();
                int[] iArr = new int[size];
                for (int i7 = 0; i7 < size; i7++) {
                    iArr[i7] = integerArrayList2.get(i7).intValue();
                }
                setSelects(iArr);
            }
            AppMethodBeat.o(143571);
            return;
        }
        super.onRestoreInstanceState(parcelable);
        AppMethodBeat.o(143571);
    }

    public void setLabels(List<String> list) {
        AppMethodBeat.i(143572);
        a(list, new a<String>() {
            /* class com.tencent.mm.ui.widget.happybubble.LabelsView.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.widget.TextView, int, java.lang.Object] */
            @Override // com.tencent.mm.ui.widget.happybubble.LabelsView.a
            public final /* synthetic */ CharSequence a(TextView textView, int i2, String str) {
                AppMethodBeat.i(206158);
                String trim = str.trim();
                AppMethodBeat.o(206158);
                return trim;
            }
        });
        AppMethodBeat.o(143572);
    }

    public final <T> void a(List<T> list, a<T> aVar) {
        AppMethodBeat.i(143573);
        hbP();
        removeAllViews();
        this.QQT.clear();
        if (list != null) {
            this.QQT.addAll(list);
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                a(list.get(i2), i2, aVar);
            }
            hbN();
        }
        if (this.QQM == e.SINGLE_IRREVOCABLY) {
            setSelects(0);
        }
        AppMethodBeat.o(143573);
    }

    public <T> List<T> getLabels() {
        return this.QQT;
    }

    private <T> void a(T t, int i2, a<T> aVar) {
        AppMethodBeat.i(143574);
        TextView textView = new TextView(this.mContext);
        textView.setPadding(this.QQG, this.QQH, this.QQI, this.QQJ);
        textView.setTextSize(0, this.gPN);
        textView.setGravity(this.QQF);
        textView.setTextColor(this.BpJ);
        textView.setBackgroundDrawable(this.QQC.getConstantState().newDrawable());
        textView.setTag(QQR, t);
        textView.setTag(QQS, Integer.valueOf(i2));
        textView.setOnClickListener(this);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        addView(textView, this.QQD, this.QQE);
        textView.setText(aVar.a(textView, i2, t));
        AppMethodBeat.o(143574);
    }

    private void hbN() {
        AppMethodBeat.i(143575);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            ((TextView) getChildAt(i2)).setClickable(this.QQW != null || this.QQM != e.NONE);
        }
        AppMethodBeat.o(143575);
    }

    public void onClick(View view) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(143576);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/happybubble/LabelsView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (!this.QQQ && this.QQM != e.NONE) {
                if (textView.isSelected()) {
                    if ((this.QQM == e.MULTI && this.QQV.contains((Integer) textView.getTag(QQS))) || (this.QQM == e.MULTI && this.QQU.size() <= this.QQO)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z || this.QQM == e.SINGLE_IRREVOCABLY) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2 && !F(textView)) {
                        b(textView, false);
                    }
                } else if (this.QQM == e.SINGLE || this.QQM == e.SINGLE_IRREVOCABLY) {
                    if (!F(textView)) {
                        hbP();
                        b(textView, true);
                    }
                } else if (this.QQM == e.MULTI && ((this.QQN <= 0 || this.QQN > this.QQU.size()) && !F(textView))) {
                    b(textView, true);
                }
            }
            if (this.QQW != null) {
                this.QQW.j(textView.getTag(QQR), ((Integer) textView.getTag(QQS)).intValue());
            }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/happybubble/LabelsView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(143576);
    }

    private void b(TextView textView, boolean z) {
        AppMethodBeat.i(143577);
        if (textView.isSelected() != z) {
            textView.setSelected(z);
            if (z) {
                this.QQU.add((Integer) textView.getTag(QQS));
            } else {
                this.QQU.remove((Integer) textView.getTag(QQS));
            }
            if (this.QQX != null) {
                textView.getTag(QQR);
                ((Integer) textView.getTag(QQS)).intValue();
            }
        }
        AppMethodBeat.o(143577);
    }

    private boolean F(TextView textView) {
        AppMethodBeat.i(143578);
        if (this.QQY != null) {
            d dVar = this.QQY;
            textView.getTag(QQR);
            textView.isSelected();
            textView.isSelected();
            ((Integer) textView.getTag(QQS)).intValue();
            if (dVar.hbR()) {
                AppMethodBeat.o(143578);
                return true;
            }
        }
        AppMethodBeat.o(143578);
        return false;
    }

    public final void hbO() {
        AppMethodBeat.i(143579);
        if (this.QQM != e.SINGLE_IRREVOCABLY) {
            if (this.QQM != e.MULTI || this.QQV.isEmpty()) {
                hbP();
            } else {
                int childCount = getChildCount();
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < childCount; i2++) {
                    if (!this.QQV.contains(Integer.valueOf(i2))) {
                        b((TextView) getChildAt(i2), false);
                        arrayList.add(Integer.valueOf(i2));
                    }
                }
                this.QQU.removeAll(arrayList);
                AppMethodBeat.o(143579);
                return;
            }
        }
        AppMethodBeat.o(143579);
    }

    private void hbP() {
        AppMethodBeat.i(143580);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            b((TextView) getChildAt(i2), false);
        }
        this.QQU.clear();
        AppMethodBeat.o(143580);
    }

    public void setSelects(List<Integer> list) {
        AppMethodBeat.i(143581);
        if (list != null) {
            int size = list.size();
            int[] iArr = new int[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = list.get(i2).intValue();
            }
            setSelects(iArr);
        }
        AppMethodBeat.o(143581);
    }

    public void setSelects(int... iArr) {
        AppMethodBeat.i(143582);
        if (this.QQM != e.NONE) {
            ArrayList arrayList = new ArrayList();
            int childCount = getChildCount();
            int i2 = (this.QQM == e.SINGLE || this.QQM == e.SINGLE_IRREVOCABLY) ? 1 : this.QQN;
            for (int i3 : iArr) {
                if (i3 < childCount) {
                    TextView textView = (TextView) getChildAt(i3);
                    if (!arrayList.contains(textView)) {
                        b(textView, true);
                        arrayList.add(textView);
                    }
                    if (i2 > 0 && arrayList.size() == i2) {
                        break;
                    }
                }
            }
            for (int i4 = 0; i4 < childCount; i4++) {
                TextView textView2 = (TextView) getChildAt(i4);
                if (!arrayList.contains(textView2)) {
                    b(textView2, false);
                }
            }
        }
        AppMethodBeat.o(143582);
    }

    public void setCompulsorys(List<Integer> list) {
        AppMethodBeat.i(143583);
        if (this.QQM == e.MULTI && list != null) {
            this.QQV.clear();
            this.QQV.addAll(list);
            hbP();
            setSelects(list);
        }
        AppMethodBeat.o(143583);
    }

    public void setCompulsorys(int... iArr) {
        AppMethodBeat.i(143584);
        if (this.QQM == e.MULTI && iArr != null) {
            ArrayList arrayList = new ArrayList(iArr.length);
            for (int i2 : iArr) {
                arrayList.add(Integer.valueOf(i2));
            }
            setCompulsorys(arrayList);
        }
        AppMethodBeat.o(143584);
    }

    public List<Integer> getCompulsorys() {
        return this.QQV;
    }

    public List<Integer> getSelectLabels() {
        return this.QQU;
    }

    public <T> List<T> getSelectLabelDatas() {
        AppMethodBeat.i(143585);
        ArrayList arrayList = new ArrayList();
        int size = this.QQU.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object tag = getChildAt(this.QQU.get(i2).intValue()).getTag(QQR);
            if (tag != null) {
                arrayList.add(tag);
            }
        }
        AppMethodBeat.o(143585);
        return arrayList;
    }

    public void setLabelBackgroundResource(int i2) {
        AppMethodBeat.i(143586);
        setLabelBackgroundDrawable(getResources().getDrawable(i2));
        AppMethodBeat.o(143586);
    }

    public void setLabelBackgroundColor(int i2) {
        AppMethodBeat.i(143587);
        setLabelBackgroundDrawable(new ColorDrawable(i2));
        AppMethodBeat.o(143587);
    }

    public void setLabelBackgroundDrawable(Drawable drawable) {
        AppMethodBeat.i(143588);
        this.QQC = drawable;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            ((TextView) getChildAt(i2)).setBackgroundDrawable(this.QQC.getConstantState().newDrawable());
        }
        AppMethodBeat.o(143588);
    }

    public int getTextPaddingLeft() {
        return this.QQG;
    }

    public int getTextPaddingTop() {
        return this.QQH;
    }

    public int getTextPaddingRight() {
        return this.QQI;
    }

    public int getTextPaddingBottom() {
        return this.QQJ;
    }

    public void setLabelTextSize(float f2) {
        AppMethodBeat.i(143589);
        if (this.gPN != f2) {
            this.gPN = f2;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                ((TextView) getChildAt(i2)).setTextSize(0, f2);
            }
        }
        AppMethodBeat.o(143589);
    }

    public float getLabelTextSize() {
        return this.gPN;
    }

    public void setLabelTextColor(int i2) {
        AppMethodBeat.i(143590);
        setLabelTextColor(ColorStateList.valueOf(i2));
        AppMethodBeat.o(143590);
    }

    public void setLabelTextColor(ColorStateList colorStateList) {
        AppMethodBeat.i(143591);
        this.BpJ = colorStateList;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            ((TextView) getChildAt(i2)).setTextColor(this.BpJ);
        }
        AppMethodBeat.o(143591);
    }

    public ColorStateList getLabelTextColor() {
        return this.BpJ;
    }

    public void setLabelGravity(int i2) {
        AppMethodBeat.i(143592);
        if (this.QQF != i2) {
            this.QQF = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                ((TextView) getChildAt(i3)).setGravity(i2);
            }
        }
        AppMethodBeat.o(143592);
    }

    public int getLabelGravity() {
        return this.QQF;
    }

    public void setLineMargin(int i2) {
        AppMethodBeat.i(143593);
        if (this.QQL != i2) {
            this.QQL = i2;
            requestLayout();
        }
        AppMethodBeat.o(143593);
    }

    public int getLineMargin() {
        return this.QQL;
    }

    public void setWordMargin(int i2) {
        AppMethodBeat.i(143594);
        if (this.QQK != i2) {
            this.QQK = i2;
            requestLayout();
        }
        AppMethodBeat.o(143594);
    }

    public int getWordMargin() {
        return this.QQK;
    }

    public void setSelectType(e eVar) {
        AppMethodBeat.i(143595);
        if (this.QQM != eVar) {
            this.QQM = eVar;
            hbP();
            if (this.QQM == e.SINGLE_IRREVOCABLY) {
                setSelects(0);
            }
            if (this.QQM != e.MULTI) {
                this.QQV.clear();
            }
            hbN();
        }
        AppMethodBeat.o(143595);
    }

    public e getSelectType() {
        return this.QQM;
    }

    public void setMaxSelect(int i2) {
        AppMethodBeat.i(143596);
        if (this.QQN != i2) {
            this.QQN = i2;
            if (this.QQM == e.MULTI) {
                hbP();
            }
        }
        AppMethodBeat.o(143596);
    }

    public int getMaxSelect() {
        return this.QQN;
    }

    public void setMinSelect(int i2) {
        this.QQO = i2;
    }

    public int getMinSelect() {
        return this.QQO;
    }

    public void setMaxLines(int i2) {
        AppMethodBeat.i(143597);
        if (this.pME != i2) {
            this.pME = i2;
            requestLayout();
        }
        AppMethodBeat.o(143597);
    }

    public int getMaxLines() {
        return this.pME;
    }

    public void setIndicator(boolean z) {
        this.QQQ = z;
    }

    public void setSingleLine(boolean z) {
        AppMethodBeat.i(143598);
        if (this.OYB != z) {
            this.OYB = z;
            requestLayout();
        }
        AppMethodBeat.o(143598);
    }

    public void setOnLabelClickListener(b bVar) {
        AppMethodBeat.i(143599);
        this.QQW = bVar;
        hbN();
        AppMethodBeat.o(143599);
    }

    public void setOnLabelSelectChangeListener(c cVar) {
        this.QQX = cVar;
    }

    public void setOnSelectChangeIntercept(d dVar) {
        this.QQY = dVar;
    }

    private int hbQ() {
        AppMethodBeat.i(143600);
        int applyDimension = (int) TypedValue.applyDimension(2, 14.0f, getResources().getDisplayMetrics());
        AppMethodBeat.o(143600);
        return applyDimension;
    }

    private int cB(float f2) {
        AppMethodBeat.i(143601);
        int applyDimension = (int) TypedValue.applyDimension(1, f2, getResources().getDisplayMetrics());
        AppMethodBeat.o(143601);
        return applyDimension;
    }

    public int getLineCount() {
        return this.QQP;
    }
}
