package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.MetaKeyKeyListener;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.appbrand.widget.base.d;
import com.tencent.mm.plugin.appbrand.widget.h.a;
import com.tencent.mm.plugin.appbrand.widget.input.ab;
import com.tencent.mm.plugin.appbrand.widget.input.ai;
import com.tencent.mm.plugin.appbrand.widget.input.aj;
import com.tencent.mm.sdk.platformtools.Log;

public final class q extends y {
    private a lSQ;
    private float mFs;
    private boolean otA = false;
    private MotionEvent otB;
    private boolean otC = false;
    final ag<q> otD = new ag<>(this);
    private final InputFilter otw = new InputFilter() {
        /* class com.tencent.mm.plugin.appbrand.widget.input.q.AnonymousClass4 */

        public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            Spannable spannableStringBuilder;
            AppMethodBeat.i(136435);
            if (TextUtils.isEmpty(charSequence) || q.this.lSQ == null) {
                AppMethodBeat.o(136435);
                return null;
            }
            if (charSequence instanceof Spannable) {
                spannableStringBuilder = (Spannable) charSequence;
            } else {
                spannableStringBuilder = new SpannableStringBuilder(charSequence);
            }
            spannableStringBuilder.setSpan(q.this.lSQ, 0, spannableStringBuilder.length(), 18);
            AppMethodBeat.o(136435);
            return spannableStringBuilder;
        }
    };
    private float otx = 0.0f;
    private float oty = 1.2f;
    private float otz = getTextSize();

    public q(Context context) {
        super(context);
        AppMethodBeat.i(136436);
        super.setSingleLine(false);
        super.setLineSpacing(0.0f, 1.0f);
        super.setVerticalScrollbarPosition(2);
        super.setSpannableFactory(new Spannable.Factory() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.q.AnonymousClass1 */

            public final Spannable newSpannable(CharSequence charSequence) {
                AppMethodBeat.i(136432);
                Spannable newSpannable = super.newSpannable(charSequence);
                if (q.this.lSQ != null && !TextUtils.isEmpty(newSpannable)) {
                    newSpannable.setSpan(q.this.lSQ, 0, newSpannable.length(), 18);
                }
                AppMethodBeat.o(136432);
                return newSpannable;
            }
        });
        super.a(new ab.c() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.q.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.widget.input.ab.c
            public final void cbA() {
                AppMethodBeat.i(136433);
                q.this.cbw();
                AppMethodBeat.o(136433);
            }
        });
        super.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.q.AnonymousClass3 */

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(136434);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputWidgetMultiLine$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                boolean caj = q.this.caj();
                com.tencent.mm.hellhoundlib.a.a.a(caj, this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputWidgetMultiLine$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(136434);
                return caj;
            }
        });
        this.mFs = (float) ViewConfiguration.get(context).getScaledTouchSlop();
        setAutoHeight(false);
        b(0.0f, false);
        AppMethodBeat.o(136436);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.widget.input.y
    public final Editable c(Editable editable) {
        AppMethodBeat.i(136437);
        Editable c2 = super.c(editable);
        if (this.lSQ != null && !TextUtils.isEmpty(c2)) {
            c2.setSpan(this.lSQ, 0, c2.length(), 18);
        }
        AppMethodBeat.o(136437);
        return c2;
    }

    public final void setAutoHeight(boolean z) {
        AppMethodBeat.i(136438);
        this.otA = z;
        setVerticalScrollBarEnabled(!this.otA);
        AppMethodBeat.o(136438);
    }

    /* access modifiers changed from: protected */
    public final void cbw() {
        AppMethodBeat.i(136439);
        if (this.otA) {
            if (getMeasuredHeight() > getMaxHeight()) {
                setMeasuredDimension(getMeasuredWidth(), getMaxHeight());
                AppMethodBeat.o(136439);
                return;
            } else if (getMeasuredHeight() < getMinHeight() && getMinHeight() > 0) {
                setMeasuredDimension(getMeasuredWidth(), getMinHeight());
            }
        }
        AppMethodBeat.o(136439);
    }

    public final void setGravity(int i2) {
        AppMethodBeat.i(136440);
        super.setGravity((i2 & -81 & -17) | 48);
        AppMethodBeat.o(136440);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.y
    public final void setSingleLine(boolean z) {
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.y
    public final void setInputType(int i2) {
        AppMethodBeat.i(136441);
        super.setInputType(131072 | i2);
        AppMethodBeat.o(136441);
    }

    public final void setFilters(InputFilter[] inputFilterArr) {
        int i2 = 0;
        AppMethodBeat.i(136442);
        if (this.otw != null) {
            if (inputFilterArr == null) {
                inputFilterArr = new InputFilter[0];
            }
            InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length + 1)];
            while (i2 < inputFilterArr.length) {
                inputFilterArr2[i2] = inputFilterArr[i2];
                i2++;
            }
            inputFilterArr2[i2] = this.otw;
            inputFilterArr = inputFilterArr2;
        }
        super.setFilters(inputFilterArr);
        AppMethodBeat.o(136442);
    }

    private void b(float f2, boolean z) {
        AppMethodBeat.i(136443);
        if (f2 <= 0.0f) {
            f2 = (this.oty * this.otz) + this.otx;
        }
        if (this.lSQ == null || this.lSQ.aX(f2)) {
            if (this.lSQ == null) {
                this.lSQ = new a(f2, 17);
            } else {
                this.lSQ.setHeight(f2);
            }
            if (!z) {
                AppMethodBeat.o(136443);
            } else if (hasFocus()) {
                invalidate();
                AppMethodBeat.o(136443);
            } else {
                cbT();
                AppMethodBeat.o(136443);
            }
        } else {
            AppMethodBeat.o(136443);
        }
    }

    @Deprecated
    public final float getLineSpacingMultiplier() {
        AppMethodBeat.i(136444);
        float lineSpacingMultiplier = super.getLineSpacingMultiplier();
        AppMethodBeat.o(136444);
        return lineSpacingMultiplier;
    }

    @Deprecated
    public final float getLineSpacingExtra() {
        AppMethodBeat.i(136445);
        float lineSpacingExtra = super.getLineSpacingExtra();
        AppMethodBeat.o(136445);
        return lineSpacingExtra;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.y
    public final void setTextSize(int i2, float f2) {
        AppMethodBeat.i(136446);
        super.setTextSize(i2, f2);
        this.otz = TypedValue.applyDimension(i2, f2, getResources().getDisplayMetrics());
        b(0.0f, true);
        AppMethodBeat.o(136446);
    }

    public final int getLineHeight() {
        AppMethodBeat.i(136447);
        if (this.lSQ != null) {
            int i2 = this.lSQ.height;
            AppMethodBeat.o(136447);
            return i2;
        }
        int lineHeight = super.getLineHeight();
        AppMethodBeat.o(136447);
        return lineHeight;
    }

    public final void setLineSpacing(float f2, float f3) {
        AppMethodBeat.i(136448);
        this.otx = f2;
        this.oty = f3;
        b(0.0f, true);
        AppMethodBeat.o(136448);
    }

    public final void setLineSpace(float f2) {
        AppMethodBeat.i(136449);
        setLineSpacing(f2, this.oty);
        AppMethodBeat.o(136449);
    }

    public final void setLineHeight(float f2) {
        AppMethodBeat.i(136450);
        if (f2 <= 0.0f) {
            AppMethodBeat.o(136450);
            return;
        }
        b(f2, true);
        AppMethodBeat.o(136450);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab
    public final View getInputPanel() {
        AppMethodBeat.i(136451);
        w dc = w.dc(this);
        AppMethodBeat.o(136451);
        return dc;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab
    public final boolean cbx() {
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab, com.tencent.mm.plugin.appbrand.widget.input.y
    public final boolean cby() {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.y
    public final void cbz() {
        AppMethodBeat.i(136452);
        aj.dg(this).restartInput(this);
        AppMethodBeat.o(136452);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.base.c, com.tencent.mm.plugin.appbrand.widget.input.y
    public final boolean caj() {
        AppMethodBeat.i(136453);
        if (!this.otA) {
            cbP();
            getMeasuredHeight();
        }
        if (isFocusable() || cbB()) {
            AppMethodBeat.o(136453);
            return false;
        }
        AppMethodBeat.o(136453);
        return true;
    }

    /* access modifiers changed from: protected */
    public final void onScrollChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(136454);
        super.onScrollChanged(i2, i3, i4, i5);
        AppMethodBeat.o(136454);
    }

    public final void scrollTo(int i2, int i3) {
        AppMethodBeat.i(136455);
        super.scrollTo(i2, i3);
        AppMethodBeat.o(136455);
    }

    public final void scrollBy(int i2, int i3) {
        AppMethodBeat.i(136456);
        super.scrollBy(i2, i3);
        AppMethodBeat.o(136456);
    }

    public final boolean canScrollVertically(int i2) {
        AppMethodBeat.i(136457);
        if (cbP() <= getHeight()) {
            AppMethodBeat.o(136457);
            return false;
        }
        boolean canScrollVertically = super.canScrollVertically(i2);
        AppMethodBeat.o(136457);
        return canScrollVertically;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int a2;
        boolean z;
        boolean z2;
        boolean z3;
        float x;
        float y;
        boolean z4;
        int max;
        ai.a[] aVarArr;
        AppMethodBeat.i(136458);
        if (!caj() || !(getParent() instanceof d)) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.otB = MotionEvent.obtain(motionEvent);
                    this.otC = true;
                    break;
                case 1:
                case 3:
                    this.otC = false;
                    if (this.otB != null) {
                        this.otB.recycle();
                        this.otB = null;
                    }
                    if (this.otC && (a2 = aj.a.a(this, motionEvent.getX(motionEvent.getActionIndex()), motionEvent.getY(motionEvent.getActionIndex()))) >= 0) {
                        setSelection(a2);
                    }
                    if (getParent() == null) {
                        AppMethodBeat.o(136458);
                        return true;
                    }
                    break;
                case 2:
                    if (this.otC) {
                        float x2 = this.otB.getX(this.otB.getActionIndex());
                        float y2 = this.otB.getY(this.otB.getActionIndex());
                        float x3 = motionEvent.getX(motionEvent.getActionIndex());
                        float y3 = motionEvent.getY(motionEvent.getActionIndex());
                        if (Math.abs(x2 - x3) > this.mFs || Math.abs(y2 - y3) > this.mFs) {
                            cancelLongPress();
                            setPressed(false);
                            this.otC = false;
                            break;
                        }
                    }
                    break;
            }
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(136458);
            return onTouchEvent;
        } else if (motionEvent.getActionMasked() != 0 || ((d) getParent()).L(motionEvent)) {
            ag<q> agVar = this.otD;
            com.tencent.mm.plugin.appbrand.widget.base.a.a(agVar.TAG, "processTouchEvent", motionEvent);
            EditText editText = (Input) agVar.ova;
            int actionIndex = motionEvent.getActionIndex();
            float x4 = motionEvent.getX(actionIndex);
            float y4 = motionEvent.getY(actionIndex);
            if (motionEvent.getActionMasked() == 0 || agVar.ovd != null) {
                boolean z5 = false;
                switch (motionEvent.getActionMasked()) {
                    case 0:
                        agVar.ovd = MotionEvent.obtain(motionEvent);
                        agVar.ovc = e.cv(editText);
                        if (editText != null) {
                            ViewParent parent = editText.getParent();
                            while (true) {
                                if (parent != null && (parent instanceof ViewGroup)) {
                                    if (((ViewGroup) parent).shouldDelayChildPressedState()) {
                                        z2 = true;
                                    } else {
                                        parent = parent.getParent();
                                    }
                                }
                            }
                        }
                        z2 = false;
                        editText.removeCallbacks(agVar.ovf);
                        if (z2) {
                            editText.postDelayed(agVar.ovf, (long) ViewConfiguration.getTapTimeout());
                        } else {
                            agVar.ovf.run();
                        }
                        z5 = true;
                        break;
                    case 1:
                        Log.v(agVar.TAG, "[apptouch] ACTION_UP, pointerDown %B", Boolean.valueOf(agVar.ove));
                        if (agVar.ove && agVar.ovd != null) {
                            e.f cv = e.cv((Input) agVar.ova);
                            if (agVar.ovc == null || Math.abs(agVar.ovc.x - cv.x) > 1.0f || Math.abs(agVar.ovc.y - cv.y) > 1.0f) {
                                Log.v(agVar.TAG, "[apptouch] check tap on ACTION_UP, but view has moved.");
                            } else if (!agVar.a(agVar.ovd, motionEvent)) {
                                Log.v(agVar.TAG, "[apptouch] check tap on ACTION_UP exceed tap scope");
                            } else {
                                ((ab) editText).Q(x4, y4);
                            }
                        }
                        agVar.cbX();
                        break;
                    case 2:
                        float f2 = agVar.ovb;
                        if (x4 < (-f2) || y4 < (-f2) || x4 >= ((float) editText.getWidth()) + f2 || y4 >= ((float) editText.getHeight()) + f2) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z || !agVar.a(agVar.ovd, motionEvent)) {
                            agVar.ove = false;
                            editText.removeCallbacks(agVar.ovf);
                            editText.removeCallbacks(agVar.ovg);
                            break;
                        } else {
                            z5 = true;
                            break;
                        }
                        break;
                    case 3:
                        agVar.cbX();
                        break;
                }
                EditText editText2 = (Input) agVar.ova;
                Editable text = agVar.ova.getText();
                if (editText2.canScrollVertically(-1) || editText2.canScrollVertically(1)) {
                    switch (motionEvent.getActionMasked()) {
                        case 0:
                            for (ai.a aVar : (ai.a[]) text.getSpans(0, text.length(), ai.a.class)) {
                                text.removeSpan(aVar);
                            }
                            text.setSpan(new ai.a(motionEvent.getX(), motionEvent.getY(), editText2.getScrollX(), editText2.getScrollY()), 0, 0, 17);
                            z3 = true;
                            break;
                        case 1:
                        case 3:
                            ai.a[] h2 = ai.h(editText2);
                            if (h2 == null || h2.length <= 0 || !h2[0].ovs) {
                                z3 = false;
                                break;
                            } else {
                                z3 = true;
                                break;
                            }
                        case 2:
                            ai.a[] aVarArr2 = (ai.a[]) text.getSpans(0, text.length(), ai.a.class);
                            if (aVarArr2.length > 0) {
                                if (!aVarArr2[0].ovr) {
                                    int scaledTouchSlop = ViewConfiguration.get(editText2.getContext()).getScaledTouchSlop();
                                    if (Math.abs(motionEvent.getX() - aVarArr2[0].mX) >= ((float) scaledTouchSlop) || Math.abs(motionEvent.getY() - aVarArr2[0].mY) >= ((float) scaledTouchSlop)) {
                                        aVarArr2[0].ovr = true;
                                    }
                                }
                                if (aVarArr2[0].ovr) {
                                    aVarArr2[0].ovs = true;
                                    if (((motionEvent.getMetaState() & 1) == 0 && MetaKeyKeyListener.getMetaState(text, 1) != 1 && MetaKeyKeyListener.getMetaState(text, 2048) == 0) ? false : true) {
                                        x = motionEvent.getX() - aVarArr2[0].mX;
                                        y = motionEvent.getY() - aVarArr2[0].mY;
                                    } else {
                                        x = aVarArr2[0].mX - motionEvent.getX();
                                        y = aVarArr2[0].mY - motionEvent.getY();
                                    }
                                    aVarArr2[0].mX = motionEvent.getX();
                                    aVarArr2[0].mY = motionEvent.getY();
                                    if (aVarArr2[0].ovt) {
                                        aVarArr2[0].ovt = false;
                                        aVarArr2[0].ovr = false;
                                    } else {
                                        int scrollX = ((int) x) + editText2.getScrollX();
                                        int scrollY = ((int) y) + editText2.getScrollY();
                                        int totalPaddingTop = editText2.getTotalPaddingTop() + editText2.getTotalPaddingBottom();
                                        Layout layout = editText2.getLayout();
                                        int max2 = Math.max(Math.min(scrollY, layout.getHeight() - (editText2.getHeight() - totalPaddingTop)), 0);
                                        int scrollX2 = editText2.getScrollX();
                                        int scrollY2 = editText2.getScrollY();
                                        int width = editText2.getWidth() - (editText2.getTotalPaddingLeft() + editText2.getTotalPaddingRight());
                                        int lineForVertical = layout.getLineForVertical(max2);
                                        Layout.Alignment paragraphAlignment = layout.getParagraphAlignment(lineForVertical);
                                        if (layout.getParagraphDirection(lineForVertical) > 0) {
                                            z4 = true;
                                        } else {
                                            z4 = false;
                                        }
                                        int i2 = width + 0;
                                        if (i2 >= width) {
                                            max = Math.max(Math.min(scrollX, 0), 0);
                                        } else if (paragraphAlignment == Layout.Alignment.ALIGN_CENTER) {
                                            max = 0 - ((width - i2) / 2);
                                        } else if ((!z4 || paragraphAlignment != Layout.Alignment.ALIGN_OPPOSITE) && (z4 || paragraphAlignment != Layout.Alignment.ALIGN_NORMAL)) {
                                            max = 0;
                                        } else {
                                            max = 0 - (width - i2);
                                        }
                                        editText2.scrollTo(max, max2);
                                        if (scrollX2 != editText2.getScrollX() || scrollY2 != editText2.getScrollY()) {
                                            editText2.cancelLongPress();
                                            aVarArr2[0].awK = true;
                                            z3 = true;
                                            break;
                                        } else if (aVarArr2[0].awK) {
                                            z3 = true;
                                            break;
                                        } else {
                                            ai.h(editText2);
                                        }
                                    }
                                }
                            }
                            break;
                        default:
                            z3 = false;
                            break;
                    }
                    boolean z6 = z3 | z5;
                    com.tencent.mm.plugin.appbrand.widget.base.a.a(agVar.TAG, "[textscroll] handled | ".concat(String.valueOf(z6)), motionEvent);
                    AppMethodBeat.o(136458);
                    return z6;
                }
                z3 = false;
                boolean z62 = z3 | z5;
                com.tencent.mm.plugin.appbrand.widget.base.a.a(agVar.TAG, "[textscroll] handled | ".concat(String.valueOf(z62)), motionEvent);
                AppMethodBeat.o(136458);
                return z62;
            }
            Log.v(agVar.TAG, "[textscroll] no pointer down before, just return");
            agVar.cbX();
            AppMethodBeat.o(136458);
            return false;
        } else {
            AppMethodBeat.o(136458);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab, com.tencent.mm.plugin.appbrand.widget.input.y
    public final void Q(float f2, float f3) {
        int a2;
        AppMethodBeat.i(136459);
        if (!isEnabled()) {
            AppMethodBeat.o(136459);
            return;
        }
        if (caj() && (a2 = aj.a.a(this, ((float) getScrollX()) + f2, ((float) getScrollY()) + f3)) >= 0) {
            setSelection(a2);
        }
        super.performClick();
        AppMethodBeat.o(136459);
    }

    public final boolean performHapticFeedback(int i2, int i3) {
        AppMethodBeat.i(136460);
        boolean performHapticFeedback = super.performHapticFeedback(i2, i3);
        AppMethodBeat.o(136460);
        return performHapticFeedback;
    }
}
