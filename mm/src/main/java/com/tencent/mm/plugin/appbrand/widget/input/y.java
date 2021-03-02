package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.style.AlignmentSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.widget.base.c;
import com.tencent.mm.plugin.appbrand.widget.input.a.b;
import com.tencent.mm.plugin.appbrand.widget.input.ab;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.b;
import com.tencent.mm.plugin.appbrand.widget.input.k;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.Locale;
import java.util.Map;

@SuppressLint({"AppCompatCustomView"})
public abstract class y extends EditText implements c, ab {
    private volatile int osn = -1;
    InputConnection otU;
    private final a ouA = new a(this, (byte) 0);
    private final PasswordTransformationMethod ouB = new m();
    private final z ouC = new z(this);
    private boolean ouD;
    private int ouE = 0;
    private boolean ouF = false;
    private final int[] ouG = new int[2];
    private boolean ouH = false;
    private ab.b ouI;
    char ouJ = 0;
    boolean ouv = false;
    private final b ouw;
    private final Map<ab.a, Object> oux = new android.support.v4.e.a();
    private final Map<View.OnFocusChangeListener, Object> ouy = new android.support.v4.e.a();
    private final Map<ab.c, Object> ouz = new android.support.v4.e.a();

    /* access modifiers changed from: protected */
    public abstract void cbz();

    static /* synthetic */ String a(Editable editable, PBool pBool, PInt pInt) {
        String str;
        pInt.value = 0;
        pBool.value = false;
        if (editable == null || editable.length() <= 0) {
            return null;
        }
        String obj = editable.toString();
        int length = editable.length();
        int i2 = 0;
        while (i2 < length) {
            int codePointAt = obj.codePointAt(i2);
            b.a ys = com.tencent.mm.plugin.appbrand.widget.input.a.a.cce().ys(codePointAt);
            if (ys == null || ys.owH == 0) {
                str = obj;
            } else {
                str = obj.replace(new String(Character.toChars(codePointAt)), new StringBuilder().append(Character.toChars(ys.owH)).append(ys.owI != 0 ? Character.toChars(ys.owI) : "").toString());
                pBool.value = true;
                pInt.value++;
            }
            i2++;
            obj = str;
        }
        return obj;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab
    public int getInputId() {
        return this.osn;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab
    public void setInputId(int i2) {
        this.osn = i2;
    }

    public String toString() {
        return String.format(Locale.US, "[%s|%s]", getClass().getSimpleName(), Integer.valueOf(getInputId()));
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab
    public final View getView() {
        return this;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab
    public boolean cby() {
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab
    public com.tencent.mm.plugin.appbrand.widget.input.autofill.b getAutoFillController() {
        return this.ouw;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab
    public void Q(float f2, float f3) {
        throw new IllegalStateException("Should implement performClick(float, float) in this class!");
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab
    public final void a(ab.a aVar) {
        this.oux.put(aVar, this);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab
    public final void a(View.OnFocusChangeListener onFocusChangeListener) {
        if (onFocusChangeListener != null) {
            this.ouy.put(onFocusChangeListener, this);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab
    public final void b(View.OnFocusChangeListener onFocusChangeListener) {
        if (onFocusChangeListener != null) {
            this.ouy.remove(onFocusChangeListener);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab
    public final void a(ab.c cVar) {
        this.ouz.put(cVar, this);
    }

    public void setOnComposingDismissedListener(com.tencent.mm.plugin.appbrand.widget.input.c.b bVar) {
        this.ouC.ouT = bVar;
    }

    public y(Context context) {
        super(context);
        setBackgroundDrawable(null);
        setIncludeFontPadding(false);
        Aj(3);
        setSingleLine(true);
        setTextCursorDrawable(R.drawable.e7);
        setTextIsSelectable(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT >= 16) {
            setLineSpacing(0.0f, 1.0f);
        }
        setTypeface(Typeface.SANS_SERIF);
        super.addTextChangedListener(this.ouA);
        super.setPadding(0, 0, 0, 0);
        super.setEditableFactory(new Editable.Factory() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.y.AnonymousClass1 */

            public final Editable newEditable(CharSequence charSequence) {
                AppMethodBeat.i(136555);
                Editable c2 = y.this.c(super.newEditable(charSequence));
                AppMethodBeat.o(136555);
                return c2;
            }
        });
        if (cby()) {
            this.ouw = new com.tencent.mm.plugin.appbrand.widget.input.autofill.b(this);
        } else {
            this.ouw = null;
        }
        this.ouD = true;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.base.c
    public boolean caj() {
        return false;
    }

    private void Aj(int i2) {
        Layout.Alignment alignment;
        int i3;
        setGravity((getGravity() & -8388612 & -8388614) | i2);
        int gravity = getGravity();
        CharSequence hint = getHint();
        if (!TextUtils.isEmpty(hint)) {
            Spannable H = aj.H(hint);
            switch (gravity & 7) {
                case 1:
                    alignment = Layout.Alignment.ALIGN_CENTER;
                    break;
                case 5:
                    alignment = Layout.Alignment.ALIGN_OPPOSITE;
                    break;
                default:
                    alignment = Layout.Alignment.ALIGN_NORMAL;
                    break;
            }
            H.setSpan(new AlignmentSpan.Standard(alignment), 0, getHint().length(), 18);
            super.setHint(H);
            if (Build.VERSION.SDK_INT >= 17) {
                switch (AnonymousClass3.bDD[alignment.ordinal()]) {
                    case 1:
                        i3 = 4;
                        break;
                    case 2:
                        i3 = 6;
                        break;
                    default:
                        i3 = 5;
                        break;
                }
                super.setTextAlignment(i3);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.y$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] bDD = new int[Layout.Alignment.values().length];

        static {
            AppMethodBeat.i(136560);
            try {
                bDD[Layout.Alignment.ALIGN_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                bDD[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
                AppMethodBeat.o(136560);
            } catch (NoSuchFieldError e3) {
                AppMethodBeat.o(136560);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Editable c(Editable editable) {
        return this.ouC.c(editable);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab
    public final int Ak(int i2) {
        int paddingTop = getPaddingTop() + ((int) (((float) i2) * (((float) getLineHeight()) + getLineSpacingExtra())));
        Log.d("MicroMsg.AppBrand.WebEditText", "calculateLinePosition, lineNumber %d, returnHeight %d, layout %s", Integer.valueOf(i2), Integer.valueOf(paddingTop), getLayout());
        return paddingTop;
    }

    public final int cbP() {
        return Ak(getLineCount()) + getPaddingBottom();
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab
    public final void cbQ() {
        Aj(3);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab
    public final void cbR() {
        Aj(5);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab
    public final void cbS() {
        Aj(1);
    }

    public void setSelection(int i2) {
        if (getEditableText() != null) {
            super.setSelection(Math.min(i2, getEditableText().length()));
        }
    }

    public void setSelection(int i2, int i3) {
        int i4;
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 >= getEditableText().length()) {
            i4 = getEditableText().length();
        } else {
            i4 = i2;
        }
        if (i3 < i4) {
            i3 = i4;
        }
        if (i3 >= getEditableText().length()) {
            i3 = getEditableText().length();
        }
        super.setSelection(i4, i3);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        final InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection == null) {
            return null;
        }
        this.otU = new InputConnectionWrapper(onCreateInputConnection) {
            /* class com.tencent.mm.plugin.appbrand.widget.input.y.AnonymousClass2 */

            public final boolean setComposingText(CharSequence charSequence, int i2) {
                AppMethodBeat.i(136556);
                if (!TextUtils.isEmpty(charSequence)) {
                    y.this.ouJ = charSequence.charAt(charSequence.length() - 1);
                }
                boolean composingText = super.setComposingText(charSequence, i2);
                AppMethodBeat.o(136556);
                return composingText;
            }

            public final boolean commitText(CharSequence charSequence, int i2) {
                AppMethodBeat.i(136557);
                if (!TextUtils.isEmpty(charSequence)) {
                    y.this.ouJ = charSequence.charAt(charSequence.length() - 1);
                }
                boolean commitText = super.commitText(charSequence, i2);
                AppMethodBeat.o(136557);
                return commitText;
            }

            public final boolean deleteSurroundingText(int i2, int i3) {
                AppMethodBeat.i(136558);
                y.this.ouJ = '\b';
                boolean deleteSurroundingText = super.deleteSurroundingText(i2, i3);
                AppMethodBeat.o(136558);
                return deleteSurroundingText;
            }

            public final boolean finishComposingText() {
                Editable editableText;
                AppMethodBeat.i(136559);
                if (onCreateInputConnection instanceof BaseInputConnection) {
                    editableText = ((BaseInputConnection) onCreateInputConnection).getEditable();
                } else {
                    editableText = y.this.getEditableText();
                }
                boolean I = aj.I(editableText);
                boolean finishComposingText = super.finishComposingText();
                if (finishComposingText && y.this.otU == this && I) {
                    z zVar = y.this.ouC;
                    zVar.kAn.removeCallbacks(zVar.ouU);
                    if (zVar.ouS) {
                        zVar.ouU.run();
                    }
                }
                AppMethodBeat.o(136559);
                return finishComposingText;
            }
        };
        editorInfo.imeOptions |= 268435456;
        if (getImeOptions() != 0) {
            editorInfo.imeOptions &= -1073741825;
        }
        return this.otU;
    }

    @Override // android.widget.TextView, android.widget.EditText
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
    }

    public void setMinHeight(int i2) {
        if (getMinHeight() != i2) {
            super.setMinHeight(i2);
        }
    }

    public void setMaxHeight(int i2) {
        if (getMaxHeight() != i2) {
            super.setMaxHeight(i2);
        }
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        Log.v("MicroMsg.AppBrand.WebEditText", "[scrollUp] input onMeasure");
        super.onMeasure(i2, i3);
        if (!this.ouz.isEmpty()) {
            for (Object obj : this.ouz.keySet().toArray()) {
                getMeasuredWidth();
                getMeasuredHeight();
                ((ab.c) obj).cbA();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Log.v("MicroMsg.AppBrand.WebEditText", "[scrollUp] input onLayout");
        super.onLayout(z, i2, i3, i4, i5);
    }

    /* access modifiers changed from: package-private */
    public final void cbT() {
        cbU();
        setText(getEditableText());
        cbV();
    }

    /* access modifiers changed from: package-private */
    public final void cbU() {
        this.ouE++;
    }

    /* access modifiers changed from: package-private */
    public final void cbV() {
        this.ouE = Math.max(0, this.ouE - 1);
    }

    private void F(CharSequence charSequence) {
        Editable editableText = getEditableText();
        if (editableText == null) {
            setText(charSequence, TextView.BufferType.EDITABLE);
            return;
        }
        clearComposingText();
        if (TextUtils.isEmpty(charSequence)) {
            editableText.clear();
        } else {
            editableText.replace(0, editableText.length(), charSequence);
        }
    }

    public final void G(CharSequence charSequence) {
        cbU();
        F(charSequence);
        cbV();
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab
    public final void G(ac acVar) {
        if (this.ouw != null) {
            com.tencent.mm.plugin.appbrand.widget.input.autofill.c cVar = this.ouw.owb;
            cVar.owm = acVar;
            k C = k.C(acVar);
            k.a aVar = cVar.owl;
            if (aVar != null && !C.osQ.containsKey(aVar)) {
                C.osQ.put(aVar, C);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab
    public final void H(ac acVar) {
        if (this.ouw != null) {
            k.C(acVar).a(this.ouw.owb.owl);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab
    public void setFixed(boolean z) {
        this.ouF = z;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab
    public boolean cbB() {
        return this.ouF;
    }

    @Override // android.widget.TextView
    public final void setTextCursorDrawable(int i2) {
        try {
            new com.tencent.mm.compatible.loader.c(this, "mCursorDrawableRes", TextView.class.getName()).set(Integer.valueOf(i2));
        } catch (Exception e2) {
            Log.d("MicroMsg.AppBrand.WebEditText", "setTextCursorDrawable, exp = %s", Util.stackTraceToString(e2));
        }
    }

    public void setPasswordMode(boolean z) {
        cbU();
        this.ouv = z;
        setTransformationMethod(z ? this.ouB : null);
        cbV();
    }

    public void setInputType(int i2) {
        if (getInputType() != i2) {
            super.setInputType(i2);
        }
    }

    public void setSingleLine(boolean z) {
    }

    public final void setTextSize(float f2) {
        setTextSize(0, f2);
    }

    public void setTextSize(int i2, float f2) {
        super.setTextSize(i2, f2);
    }

    public void setTypeface(Typeface typeface) {
        super.setTypeface(typeface);
    }

    public void setTypeface(Typeface typeface, int i2) {
        super.setTypeface(typeface, i2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public int getAutofillType() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final class a implements TextWatcher {
        final Map<TextWatcher, Object> ouM;

        private a() {
            AppMethodBeat.i(136562);
            this.ouM = new android.support.v4.e.a();
            AppMethodBeat.o(136562);
        }

        /* synthetic */ a(y yVar, byte b2) {
            this();
        }

        private static <T> void a(CharSequence charSequence, int i2, int i3, Class<T> cls) {
            SpannableStringBuilder spannableStringBuilder;
            Object[] spans;
            AppMethodBeat.i(136563);
            try {
                if ((charSequence instanceof SpannableStringBuilder) && (spans = (spannableStringBuilder = (SpannableStringBuilder) charSequence).getSpans(i2, i2 + i3, cls)) != null && spans.length > 0) {
                    for (Object obj : spans) {
                        spannableStringBuilder.removeSpan(obj);
                    }
                }
                AppMethodBeat.o(136563);
            } catch (Throwable th) {
                AppMethodBeat.o(136563);
            }
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AppMethodBeat.i(136564);
            if (!y.d(y.this) && !this.ouM.isEmpty()) {
                for (TextWatcher textWatcher : (TextWatcher[]) this.ouM.keySet().toArray(new TextWatcher[this.ouM.size()])) {
                    textWatcher.beforeTextChanged(charSequence, i2, i3, i4);
                }
            }
            AppMethodBeat.o(136564);
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AppMethodBeat.i(136565);
            if (!y.d(y.this)) {
                a(charSequence, i2, i4, StyleSpan.class);
                a(charSequence, i2, i4, RelativeSizeSpan.class);
                a(charSequence, i2, i4, AlignmentSpan.class);
                if (!this.ouM.isEmpty()) {
                    for (TextWatcher textWatcher : (TextWatcher[]) this.ouM.keySet().toArray(new TextWatcher[this.ouM.size()])) {
                        textWatcher.onTextChanged(charSequence, i2, i3, i4);
                    }
                }
            }
            AppMethodBeat.o(136565);
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(136566);
            f.cbc();
            if (f.cbd()) {
                PBool pBool = new PBool();
                PInt pInt = new PInt();
                final String a2 = y.a(editable, pBool, pInt);
                final int i2 = pInt.value;
                if (pBool.value && !Util.isNullOrNil(a2)) {
                    final int selectionEnd = Selection.getSelectionEnd(editable);
                    final boolean d2 = y.d(y.this);
                    y.this.post(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.widget.input.y.a.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(136561);
                            if (d2) {
                                y.this.G(a2);
                            } else {
                                y.this.setText(a2);
                            }
                            try {
                                y.this.setSelection(Math.min(selectionEnd + i2, a2.length()));
                                AppMethodBeat.o(136561);
                            } catch (Exception e2) {
                                Log.e("MicroMsg.AppBrand.WebEditText", "replace softBank to unicode, setSelection ", e2);
                                AppMethodBeat.o(136561);
                            }
                        }
                    });
                    AppMethodBeat.o(136566);
                    return;
                }
            }
            if (!y.d(y.this)) {
                y.this.ouE = 0;
                if (!this.ouM.isEmpty()) {
                    for (TextWatcher textWatcher : (TextWatcher[]) this.ouM.keySet().toArray(new TextWatcher[this.ouM.size()])) {
                        textWatcher.afterTextChanged(editable);
                    }
                }
            }
            AppMethodBeat.o(136566);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab
    public void addTextChangedListener(TextWatcher textWatcher) {
        a aVar = this.ouA;
        if (textWatcher != null) {
            aVar.ouM.put(textWatcher, aVar);
        }
    }

    public void removeTextChangedListener(TextWatcher textWatcher) {
        a aVar = this.ouA;
        if (textWatcher != null) {
            aVar.ouM.remove(textWatcher);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.oux.isEmpty()) {
            for (ab.a aVar : (ab.a[]) this.oux.keySet().toArray(new ab.a[this.oux.size()])) {
                aVar.iE();
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab
    public void setOnKeyUpPostImeListener(ab.b bVar) {
        this.ouI = bVar;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (this.ouH || this.ouI == null || !this.ouI.Aa(i2)) {
            return super.onKeyUp(i2, keyEvent);
        }
        return true;
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 67) {
            this.ouJ = '\b';
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        if (onKeyDown && i2 == 66) {
            this.ouJ = '\n';
        }
        this.ouH = onKeyDown;
        return onKeyDown;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab
    public char getLastKeyPressed() {
        return this.ouJ;
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (!z) {
            clearComposingText();
        }
        if (z) {
            cbz();
        }
        if (!this.ouy.isEmpty()) {
            for (View.OnFocusChangeListener onFocusChangeListener : (View.OnFocusChangeListener[]) this.ouy.keySet().toArray(new View.OnFocusChangeListener[this.ouy.size()])) {
                onFocusChangeListener.onFocusChange(this, z);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void cbW() {
        super.clearFocus();
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i2, Rect rect) {
        return super.requestFocus(i2, rect);
    }

    public void clearFocus() {
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setFocusableInTouchMode(true);
            ((ViewGroup) getParent()).setDescendantFocusability(131072);
        }
        super.clearFocus();
    }

    public boolean requestFocus(int i2, Rect rect) {
        if (130 == i2 && rect == null && (getParent() instanceof ViewGroup)) {
            ((ViewGroup) getParent()).setDescendantFocusability(TPMediaCodecProfileLevel.HEVCMainTierLevel52);
            ((ViewGroup) getParent()).setFocusableInTouchMode(false);
        }
        try {
            return super.requestFocus(i2, rect);
        } catch (RuntimeException e2) {
            Log.e("MicroMsg.AppBrand.WebEditText", "requestFocus e=%s", e2);
            try {
                return super.requestFocus(i2, rect);
            } catch (RuntimeException e3) {
                Log.e("MicroMsg.AppBrand.WebEditText", "requestFocus try again e=%s", e3);
                return false;
            }
        }
    }

    @Deprecated
    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        if (this.ouy == null) {
            super.setOnFocusChangeListener(onFocusChangeListener);
        } else {
            a(onFocusChangeListener);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab
    public final void destroy() {
        this.oux.clear();
        this.ouz.clear();
        this.ouy.clear();
        this.ouA.ouM.clear();
        if (this.ouw != null) {
            com.tencent.mm.plugin.appbrand.widget.input.autofill.b bVar = this.ouw;
            com.tencent.mm.plugin.appbrand.widget.input.autofill.c cVar = bVar.owb;
            k.C(cVar.owm).a(cVar.owl);
            bVar.owe = null;
            bVar.ovZ.dismiss();
        }
        super.setOnFocusChangeListener(null);
    }

    static /* synthetic */ boolean d(y yVar) {
        return yVar.ouE > 0;
    }
}
