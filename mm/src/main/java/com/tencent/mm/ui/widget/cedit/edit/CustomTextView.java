package com.tencent.mm.ui.widget.cedit.edit;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.os.UserHandle;
import android.text.BoringLayout;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Layout;
import android.text.ParcelableSpan;
import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DateKeyListener;
import android.text.method.DateTimeKeyListener;
import android.text.method.DialerKeyListener;
import android.text.method.DigitsKeyListener;
import android.text.method.KeyListener;
import android.text.method.MetaKeyKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TextKeyListener;
import android.text.method.TimeKeyListener;
import android.text.method.TransformationMethod;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.ParagraphStyle;
import android.text.style.SuggestionSpan;
import android.text.style.URLSpan;
import android.text.style.UpdateAppearance;
import android.text.util.Linkify;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassificationContext;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.view.textservice.TextServicesManager;
import android.widget.RemoteViews;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.cedit.edit.b;
import com.tencent.mm.ui.widget.cedit.util.ParcelableParcel;
import com.tencent.mm.ui.widget.edittext.a;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

@RemoteViews.RemoteView
public class CustomTextView extends View implements ViewTreeObserver.OnPreDrawListener {
    public static final BoringLayout.Metrics OVU = new BoringLayout.Metrics();
    private static final float[] QGi = new float[2];
    private static final InputFilter[] QGj = new InputFilter[0];
    private static final Spanned QGk = new SpannedString("");
    private static final int[] QGl = {16843597};
    static long QGm;
    private static final SparseIntArray QHw;
    private static final RectF alw = new RectF();
    private ColorStateList BpJ;
    @ViewDebug.ExportedProperty(category = "text")
    private int Ku;
    boolean OSP;
    private int OVC;
    private boolean OVD;
    private BoringLayout OVE;
    @ViewDebug.ExportedProperty(category = "text")
    private int OVm;
    private Editable.Factory OVn;
    private Spannable.Factory OVo;
    private TextUtils.TruncateAt OVp;
    private CharSequence OVq;
    public Layout OVt;
    private float OVu;
    private float OVv;
    private int OVw;
    private int OVx;
    private int OVy;
    private int OVz;
    private TextDirectionHeuristic Om;
    private int On;
    private int Oo;
    b QGA;
    private int QGB;
    public Spannable QGC;
    private TextView.BufferType QGD;
    private CharSequence QGE;
    private Layout QGF;
    private com.tencent.mm.ui.widget.cedit.b.d QGG;
    TransformationMethod QGH;
    private boolean QGI;
    private a QGJ;
    private boolean QGK;
    private boolean QGL;
    private int QGM;
    private boolean QGN;
    private boolean QGO;
    boolean QGP;
    private boolean QGQ;
    private int QGR;
    private boolean QGS;
    private int QGT;
    private int QGU;
    private int QGV;
    private int QGW;
    private int QGX;
    private int QGY;
    private BoringLayout.Metrics QGZ;
    private ColorStateList QGn;
    private ColorStateList QGo;
    private int QGp;
    private boolean QGq;
    private float QGr;
    private float QGs;
    private float QGt;
    private boolean QGu;
    private boolean QGv;
    private TextClassifier QGw;
    private TextClassifier QGx;
    private TextClassificationContext QGy;
    private boolean QGz;
    private Set<String> QHA;
    private Set<String> QHB;
    private BoringLayout.Metrics QHa;
    private BoringLayout QHb;
    private InputFilter[] QHc;
    private UserHandle QHd;
    private volatile Locale QHe;
    private Path QHf;
    private Paint QHg;
    private boolean QHh;
    int QHi;
    private Drawable QHj;
    int QHk;
    private Drawable QHl;
    int QHm;
    private Drawable QHn;
    int QHo;
    private Drawable QHp;
    private int QHq;
    private boolean QHr;
    b QHs;
    private int QHt;
    private TextView QHu;
    private TextWatcher QHv;
    int QHx;
    boolean QHy;
    private a.e QHz;
    private long UC;
    private int aly;
    private TextPaint ayn;
    private ArrayList<TextWatcher> mListeners;
    private int mMaxWidth;
    private int mMinWidth;
    private Scroller mScroller;
    private Rect mTempRect;
    @ViewDebug.ExportedProperty(category = "text")
    public CharSequence mText;
    private int nYW;
    int oEF;

    public interface c {
        boolean a(CustomTextView customTextView, int i2);
    }

    static /* synthetic */ void a(CustomTextView customTextView, CharSequence charSequence, int i2, int i3, int i4) {
        AppMethodBeat.i(205862);
        customTextView.a(charSequence, i2, i3, i4);
        AppMethodBeat.o(205862);
    }

    static {
        AppMethodBeat.i(205863);
        com.tencent.mm.ui.widget.cedit.util.d.haY();
        AnonymousClass2 r0 = new SparseIntArray() {
            /* class com.tencent.mm.ui.widget.cedit.edit.CustomTextView.AnonymousClass2 */

            public final void put(int i2, int i3) {
                AppMethodBeat.i(205554);
                try {
                    super.put(i2, i3);
                    AppMethodBeat.o(205554);
                } catch (Throwable th) {
                    AppMethodBeat.o(205554);
                }
            }
        };
        QHw = r0;
        r0.put(5, 5);
        QHw.put(4, 4);
        QHw.put(6, 6);
        QHw.put(7, 7);
        QHw.put(1, 1);
        try {
            QHw.put(89, 89);
        } catch (Throwable th) {
        }
        QHw.put(2, 2);
        QHw.put(68, 68);
        QHw.put(3, 3);
        QHw.put(88, 88);
        QHw.put(65, 65);
        QHw.put(34, 34);
        QHw.put(35, 35);
        QHw.put(36, 36);
        QHw.put(37, 37);
        QHw.put(69, 69);
        QHw.put(84, 84);
        QHw.put(70, 70);
        QHw.put(71, 71);
        QHw.put(83, 83);
        AppMethodBeat.o(205863);
    }

    /* access modifiers changed from: package-private */
    public static class b {
        ColorStateList Kr;
        final Rect OVZ = new Rect();
        int OWe;
        int OWf;
        int OWg;
        int OWh;
        int OWi;
        int OWj;
        int OWk;
        int OWl;
        int OWm;
        final Drawable[] QHE = new Drawable[4];
        BlendMode QHF;
        boolean QHG;
        Drawable QHH;
        Drawable QHI;
        Drawable QHJ;
        Drawable QHK;
        Drawable QHL;
        boolean QHM;
        boolean QHN;
        int QHO;
        int QHP;
        int QHQ;
        int QHR;
        int QHS = -1;
        boolean acU;

        public b(Context context) {
            boolean z;
            AppMethodBeat.i(205564);
            if (context.getApplicationInfo().targetSdkVersion < 17) {
                z = true;
            } else {
                z = false;
            }
            this.QHM = z;
            this.QHN = false;
            AppMethodBeat.o(205564);
        }
    }

    public CustomTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.ny);
    }

    public CustomTextView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public TextView getAdaptText() {
        return this.QHu;
    }

    public void setAdaptText(TextView textView) {
        AppMethodBeat.i(205571);
        this.QHu = textView;
        this.QHu.addTextChangedListener(this.QHv);
        AppMethodBeat.o(205571);
    }

    public CustomTextView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        AppMethodBeat.i(205572);
        this.OVn = Editable.Factory.getInstance();
        this.OVo = Spannable.Factory.getInstance();
        this.QGB = -1;
        this.QGD = TextView.BufferType.NORMAL;
        this.QGL = false;
        this.QGM = -1;
        this.QGN = false;
        this.Ku = 8388659;
        this.QGS = true;
        this.OVu = 1.0f;
        this.OVv = 0.0f;
        this.On = 0;
        this.Oo = 0;
        this.OVw = Integer.MAX_VALUE;
        this.OVx = 1;
        this.OVy = 0;
        this.OVz = 1;
        this.QGU = this.OVw;
        this.QGV = this.OVx;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.QGW = 2;
        this.mMinWidth = 0;
        this.QGX = 2;
        this.OVC = -1;
        this.OVD = true;
        this.QGY = -1;
        this.QHc = QGj;
        this.oEF = 1714664933;
        this.QHh = true;
        this.QHi = 16843618;
        this.QHk = 16843461;
        this.QHm = 16843462;
        this.QHo = 16843463;
        this.QHq = -1;
        this.QHt = 0;
        this.aly = 0;
        this.QHv = new TextWatcher() {
            /* class com.tencent.mm.ui.widget.cedit.edit.CustomTextView.AnonymousClass1 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(205553);
                ((Editable) CustomTextView.this.getText()).insert(CustomTextView.this.getSelectionStart(), editable.toString());
                AppMethodBeat.o(205553);
            }
        };
        this.QHx = getContext().getResources().getColor(R.color.kn);
        this.QHy = false;
        this.QHA = new HashSet();
        this.QHB = new HashSet();
        b(context, attributeSet, i2, i3);
        AppMethodBeat.o(205572);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x069c  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x06c0  */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x06d3  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x06e6  */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x06f9  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x071e  */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x0806  */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x0811  */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x0820  */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x082f  */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x083e  */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x084e  */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x0866  */
    /* JADX WARNING: Removed duplicated region for block: B:329:0x08a0  */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x08dd  */
    /* JADX WARNING: Removed duplicated region for block: B:338:0x08ec  */
    /* JADX WARNING: Removed duplicated region for block: B:341:0x08fb  */
    /* JADX WARNING: Removed duplicated region for block: B:344:0x090a  */
    /* JADX WARNING: Removed duplicated region for block: B:347:0x0919  */
    /* JADX WARNING: Removed duplicated region for block: B:355:0x0937  */
    /* JADX WARNING: Removed duplicated region for block: B:357:0x0942  */
    /* JADX WARNING: Removed duplicated region for block: B:360:0x095f  */
    /* JADX WARNING: Removed duplicated region for block: B:363:0x096c  */
    /* JADX WARNING: Removed duplicated region for block: B:365:0x0975  */
    /* JADX WARNING: Removed duplicated region for block: B:368:0x098c  */
    /* JADX WARNING: Removed duplicated region for block: B:371:0x0999  */
    /* JADX WARNING: Removed duplicated region for block: B:373:0x09a1  */
    /* JADX WARNING: Removed duplicated region for block: B:375:0x09aa  */
    /* JADX WARNING: Removed duplicated region for block: B:377:0x09b3  */
    /* JADX WARNING: Removed duplicated region for block: B:441:0x0b39  */
    /* JADX WARNING: Removed duplicated region for block: B:442:0x0b42  */
    /* JADX WARNING: Removed duplicated region for block: B:443:0x0b4b  */
    /* JADX WARNING: Removed duplicated region for block: B:451:0x0b76  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.content.Context r41, android.util.AttributeSet r42, int r43, int r44) {
        /*
        // Method dump skipped, instructions count: 2972
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.widget.cedit.edit.CustomTextView.b(android.content.Context, android.util.AttributeSet, int, int):void");
    }

    private void setTextInternal(CharSequence charSequence) {
        this.mText = charSequence;
        this.QGC = charSequence instanceof Spannable ? (Spannable) charSequence : null;
    }

    private void a(Typeface typeface, String str, int i2, int i3, int i4) {
        AppMethodBeat.i(205574);
        if (typeface == null && str != null) {
            a(Typeface.create(str, 0), i3, i4);
            AppMethodBeat.o(205574);
        } else if (typeface != null) {
            a(typeface, i3, i4);
            AppMethodBeat.o(205574);
        } else {
            switch (i2) {
                case 1:
                    a(Typeface.SANS_SERIF, i3, i4);
                    AppMethodBeat.o(205574);
                    return;
                case 2:
                    a(Typeface.SERIF, i3, i4);
                    AppMethodBeat.o(205574);
                    return;
                case 3:
                    a(Typeface.MONOSPACE, i3, i4);
                    AppMethodBeat.o(205574);
                    return;
                default:
                    a((Typeface) null, i3, i4);
                    AppMethodBeat.o(205574);
                    return;
            }
        }
    }

    @SuppressLint({"Range"})
    private void a(Typeface typeface, int i2, int i3) {
        AppMethodBeat.i(205575);
        if (i3 >= 0) {
            Math.min(1000, i3);
        }
        setTypeface(typeface, i2);
        AppMethodBeat.o(205575);
    }

    public void setEnabled(boolean z) {
        InputMethodManager inputMethodManager;
        InputMethodManager inputMethodManager2;
        AppMethodBeat.i(205576);
        if (z == isEnabled()) {
            AppMethodBeat.o(205576);
            return;
        }
        if (!z && (inputMethodManager2 = getInputMethodManager()) != null && inputMethodManager2.isActive(this)) {
            inputMethodManager2.hideSoftInputFromWindow(getWindowToken(), 0);
        }
        super.setEnabled(z);
        if (z && (inputMethodManager = getInputMethodManager()) != null) {
            inputMethodManager.restartInput(this);
        }
        if (this.QHs != null) {
            this.QHs.gZP();
            this.QHs.haz();
        }
        AppMethodBeat.o(205576);
    }

    private void setTypeface(Typeface typeface, int i2) {
        Typeface create;
        int i3;
        float f2;
        boolean z = false;
        AppMethodBeat.i(205577);
        if (i2 > 0) {
            if (typeface == null) {
                create = Typeface.defaultFromStyle(i2);
            } else {
                create = Typeface.create(typeface, i2);
            }
            setTypeface(create);
            if (create != null) {
                i3 = create.getStyle();
            } else {
                i3 = 0;
            }
            int i4 = (i3 ^ -1) & i2;
            TextPaint textPaint = this.ayn;
            if ((i4 & 1) != 0) {
                z = true;
            }
            textPaint.setFakeBoldText(z);
            TextPaint textPaint2 = this.ayn;
            if ((i4 & 2) != 0) {
                f2 = -0.25f;
            } else {
                f2 = 0.0f;
            }
            textPaint2.setTextSkewX(f2);
            AppMethodBeat.o(205577);
            return;
        }
        this.ayn.setFakeBoldText(false);
        this.ayn.setTextSkewX(0.0f);
        setTypeface(typeface);
        AppMethodBeat.o(205577);
    }

    /* access modifiers changed from: protected */
    public boolean getDefaultEditable() {
        return false;
    }

    /* access modifiers changed from: protected */
    public com.tencent.mm.ui.widget.cedit.b.d getDefaultMovementMethod() {
        return null;
    }

    @ViewDebug.CapturedViewProperty
    public CharSequence getText() {
        return this.mText;
    }

    public int length() {
        AppMethodBeat.i(205578);
        int length = this.mText.length();
        AppMethodBeat.o(205578);
        return length;
    }

    public Editable getEditableText() {
        if (this.mText instanceof Editable) {
            return (Editable) this.mText;
        }
        return null;
    }

    public CharSequence getTransformed() {
        return this.OVq;
    }

    public int getLineHeight() {
        AppMethodBeat.i(205579);
        int fontMetricsInt = (int) ((((long) (((((float) this.ayn.getFontMetricsInt(null)) * this.OVu) + this.OVv) * 1.6777216E7f)) + 8388608) >> 24);
        AppMethodBeat.o(205579);
        return fontMetricsInt;
    }

    public final Layout getLayout() {
        return this.OVt;
    }

    public final KeyListener getKeyListener() {
        if (this.QHs == null) {
            return null;
        }
        return this.QHs.QIH;
    }

    public void setKeyListener(KeyListener keyListener) {
        AppMethodBeat.i(205580);
        this.QGN = true;
        setKeyListenerOnly(keyListener);
        gZp();
        if (keyListener != null) {
            gZL();
            gZo();
        } else if (this.QHs != null) {
            this.QHs.Clf = 0;
        }
        InputMethodManager inputMethodManager = getInputMethodManager();
        if (inputMethodManager != null) {
            inputMethodManager.restartInput(this);
        }
        AppMethodBeat.o(205580);
    }

    private void gZo() {
        AppMethodBeat.i(205581);
        try {
            this.QHs.Clf = this.QHs.QIH.getInputType();
        } catch (IncompatibleClassChangeError e2) {
            this.QHs.Clf = 1;
        }
        setInputTypeSingleLine(this.OSP);
        AppMethodBeat.o(205581);
    }

    private void setKeyListenerOnly(KeyListener keyListener) {
        AppMethodBeat.i(205582);
        if (this.QHs == null && keyListener == null) {
            AppMethodBeat.o(205582);
            return;
        }
        gZL();
        if (this.QHs.QIH != keyListener) {
            this.QHs.QIH = keyListener;
            if (keyListener != null && !(this.mText instanceof Editable)) {
                setText(this.mText);
            }
            a((Editable) this.mText, this.QHc);
        }
        AppMethodBeat.o(205582);
    }

    public final com.tencent.mm.ui.widget.cedit.b.d getMovementMethod() {
        return this.QGG;
    }

    public final void setMovementMethod(com.tencent.mm.ui.widget.cedit.b.d dVar) {
        AppMethodBeat.i(205583);
        if (this.QGG != dVar) {
            this.QGG = dVar;
            if (dVar != null && this.QGC == null) {
                setText(this.mText);
            }
            gZp();
            if (this.QHs != null) {
                this.QHs.gZP();
            }
        }
        AppMethodBeat.o(205583);
    }

    private void gZp() {
        AppMethodBeat.i(205584);
        if (this.QGG == null && (this.QHs == null || this.QHs.QIH == null)) {
            setClickable(false);
            setLongClickable(false);
            AppMethodBeat.o(205584);
            return;
        }
        setFocusable(true);
        setClickable(true);
        setLongClickable(true);
        AppMethodBeat.o(205584);
    }

    public final TransformationMethod getTransformationMethod() {
        return this.QGH;
    }

    public final void setTransformationMethod(TransformationMethod transformationMethod) {
        AppMethodBeat.i(205585);
        if (transformationMethod == this.QGH) {
            AppMethodBeat.o(205585);
            return;
        }
        if (!(this.QGH == null || this.QGC == null)) {
            this.QGC.removeSpan(this.QGH);
        }
        this.QGH = transformationMethod;
        this.QGI = false;
        setText(this.mText);
        this.Om = getTextDirectionHeuristic();
        AppMethodBeat.o(205585);
    }

    public int getCompoundPaddingTop() {
        AppMethodBeat.i(205586);
        b bVar = this.QGA;
        if (bVar == null || bVar.QHE[1] == null) {
            int paddingTop = getPaddingTop();
            AppMethodBeat.o(205586);
            return paddingTop;
        }
        int paddingTop2 = bVar.OWe + getPaddingTop() + bVar.OWm;
        AppMethodBeat.o(205586);
        return paddingTop2;
    }

    public int getCompoundPaddingBottom() {
        AppMethodBeat.i(205587);
        b bVar = this.QGA;
        if (bVar == null || bVar.QHE[3] == null) {
            int paddingBottom = getPaddingBottom();
            AppMethodBeat.o(205587);
            return paddingBottom;
        }
        int paddingBottom2 = bVar.OWf + getPaddingBottom() + bVar.OWm;
        AppMethodBeat.o(205587);
        return paddingBottom2;
    }

    public int getCompoundPaddingLeft() {
        AppMethodBeat.i(205588);
        b bVar = this.QGA;
        if (bVar == null || bVar.QHE[0] == null) {
            int paddingLeft = getPaddingLeft();
            AppMethodBeat.o(205588);
            return paddingLeft;
        }
        int paddingLeft2 = bVar.OWg + getPaddingLeft() + bVar.OWm;
        AppMethodBeat.o(205588);
        return paddingLeft2;
    }

    public int getCompoundPaddingRight() {
        AppMethodBeat.i(205589);
        b bVar = this.QGA;
        if (bVar == null || bVar.QHE[2] == null) {
            int paddingRight = getPaddingRight();
            AppMethodBeat.o(205589);
            return paddingRight;
        }
        int paddingRight2 = bVar.OWh + getPaddingRight() + bVar.OWm;
        AppMethodBeat.o(205589);
        return paddingRight2;
    }

    public int getCompoundPaddingStart() {
        AppMethodBeat.i(205590);
        switch (getLayoutDirection()) {
            case 1:
                int compoundPaddingRight = getCompoundPaddingRight();
                AppMethodBeat.o(205590);
                return compoundPaddingRight;
            default:
                int compoundPaddingLeft = getCompoundPaddingLeft();
                AppMethodBeat.o(205590);
                return compoundPaddingLeft;
        }
    }

    public int getCompoundPaddingEnd() {
        AppMethodBeat.i(205591);
        switch (getLayoutDirection()) {
            case 1:
                int compoundPaddingLeft = getCompoundPaddingLeft();
                AppMethodBeat.o(205591);
                return compoundPaddingLeft;
            default:
                int compoundPaddingRight = getCompoundPaddingRight();
                AppMethodBeat.o(205591);
                return compoundPaddingRight;
        }
    }

    public int getExtendedPaddingTop() {
        AppMethodBeat.i(205592);
        if (this.OVx != 1) {
            int compoundPaddingTop = getCompoundPaddingTop();
            AppMethodBeat.o(205592);
            return compoundPaddingTop;
        }
        if (this.OVt == null) {
            gLs();
        }
        if (this.OVt.getLineCount() <= this.OVw) {
            int compoundPaddingTop2 = getCompoundPaddingTop();
            AppMethodBeat.o(205592);
            return compoundPaddingTop2;
        }
        int compoundPaddingTop3 = getCompoundPaddingTop();
        int height = (getHeight() - compoundPaddingTop3) - getCompoundPaddingBottom();
        int lineTop = this.OVt.getLineTop(this.OVw);
        if (lineTop >= height) {
            AppMethodBeat.o(205592);
            return compoundPaddingTop3;
        }
        int i2 = this.Ku & 112;
        if (i2 == 48) {
            AppMethodBeat.o(205592);
            return compoundPaddingTop3;
        } else if (i2 == 80) {
            int i3 = (compoundPaddingTop3 + height) - lineTop;
            AppMethodBeat.o(205592);
            return i3;
        } else {
            int i4 = compoundPaddingTop3 + ((height - lineTop) / 2);
            AppMethodBeat.o(205592);
            return i4;
        }
    }

    public int getExtendedPaddingBottom() {
        AppMethodBeat.i(205593);
        if (this.OVx != 1) {
            int compoundPaddingBottom = getCompoundPaddingBottom();
            AppMethodBeat.o(205593);
            return compoundPaddingBottom;
        }
        if (this.OVt == null) {
            gLs();
        }
        if (this.OVt.getLineCount() <= this.OVw) {
            int compoundPaddingBottom2 = getCompoundPaddingBottom();
            AppMethodBeat.o(205593);
            return compoundPaddingBottom2;
        }
        int compoundPaddingTop = getCompoundPaddingTop();
        int compoundPaddingBottom3 = getCompoundPaddingBottom();
        int height = (getHeight() - compoundPaddingTop) - compoundPaddingBottom3;
        int lineTop = this.OVt.getLineTop(this.OVw);
        if (lineTop >= height) {
            AppMethodBeat.o(205593);
            return compoundPaddingBottom3;
        }
        int i2 = this.Ku & 112;
        if (i2 == 48) {
            int i3 = (compoundPaddingBottom3 + height) - lineTop;
            AppMethodBeat.o(205593);
            return i3;
        } else if (i2 == 80) {
            AppMethodBeat.o(205593);
            return compoundPaddingBottom3;
        } else {
            int i4 = compoundPaddingBottom3 + ((height - lineTop) / 2);
            AppMethodBeat.o(205593);
            return i4;
        }
    }

    public int getTotalPaddingLeft() {
        AppMethodBeat.i(205594);
        int compoundPaddingLeft = getCompoundPaddingLeft();
        AppMethodBeat.o(205594);
        return compoundPaddingLeft;
    }

    public int getTotalPaddingRight() {
        AppMethodBeat.i(205595);
        int compoundPaddingRight = getCompoundPaddingRight();
        AppMethodBeat.o(205595);
        return compoundPaddingRight;
    }

    public int getTotalPaddingStart() {
        AppMethodBeat.i(205596);
        int compoundPaddingStart = getCompoundPaddingStart();
        AppMethodBeat.o(205596);
        return compoundPaddingStart;
    }

    public int getTotalPaddingEnd() {
        AppMethodBeat.i(205597);
        int compoundPaddingEnd = getCompoundPaddingEnd();
        AppMethodBeat.o(205597);
        return compoundPaddingEnd;
    }

    public int getTotalPaddingTop() {
        AppMethodBeat.i(205598);
        int extendedPaddingTop = getExtendedPaddingTop() + CW(true);
        AppMethodBeat.o(205598);
        return extendedPaddingTop;
    }

    public int getTotalPaddingBottom() {
        int a2;
        int height;
        AppMethodBeat.i(205599);
        int extendedPaddingBottom = getExtendedPaddingBottom();
        int i2 = 0;
        int i3 = this.Ku & 112;
        Layout layout = this.OVt;
        if (i3 != 80 && (height = layout.getHeight()) < (a2 = a(layout))) {
            i2 = i3 == 48 ? a2 - height : (a2 - height) >> 1;
        }
        int i4 = i2 + extendedPaddingBottom;
        AppMethodBeat.o(205599);
        return i4;
    }

    private void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        boolean z = true;
        AppMethodBeat.i(205600);
        b bVar = this.QGA;
        if (bVar != null) {
            if (bVar.QHH != null) {
                bVar.QHH.setCallback(null);
            }
            bVar.QHH = null;
            if (bVar.QHI != null) {
                bVar.QHI.setCallback(null);
            }
            bVar.QHI = null;
            bVar.QHQ = 0;
            bVar.QHO = 0;
            bVar.QHR = 0;
            bVar.QHP = 0;
        }
        if ((drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) ? false : true) {
            if (bVar == null) {
                bVar = new b(getContext());
                this.QGA = bVar;
            }
            this.QGA.QHN = false;
            if (!(bVar.QHE[0] == drawable || bVar.QHE[0] == null)) {
                bVar.QHE[0].setCallback(null);
            }
            bVar.QHE[0] = drawable;
            if (!(bVar.QHE[1] == drawable2 || bVar.QHE[1] == null)) {
                bVar.QHE[1].setCallback(null);
            }
            bVar.QHE[1] = drawable2;
            if (!(bVar.QHE[2] == drawable3 || bVar.QHE[2] == null)) {
                bVar.QHE[2].setCallback(null);
            }
            bVar.QHE[2] = drawable3;
            if (!(bVar.QHE[3] == drawable4 || bVar.QHE[3] == null)) {
                bVar.QHE[3].setCallback(null);
            }
            bVar.QHE[3] = drawable4;
            Rect rect = bVar.OVZ;
            int[] drawableState = getDrawableState();
            if (drawable != null) {
                drawable.setState(drawableState);
                drawable.copyBounds(rect);
                drawable.setCallback(this);
                bVar.OWg = rect.width();
                bVar.OWk = rect.height();
            } else {
                bVar.OWk = 0;
                bVar.OWg = 0;
            }
            if (drawable3 != null) {
                drawable3.setState(drawableState);
                drawable3.copyBounds(rect);
                drawable3.setCallback(this);
                bVar.OWh = rect.width();
                bVar.OWl = rect.height();
            } else {
                bVar.OWl = 0;
                bVar.OWh = 0;
            }
            if (drawable2 != null) {
                drawable2.setState(drawableState);
                drawable2.copyBounds(rect);
                drawable2.setCallback(this);
                bVar.OWe = rect.height();
                bVar.OWi = rect.width();
            } else {
                bVar.OWi = 0;
                bVar.OWe = 0;
            }
            if (drawable4 != null) {
                drawable4.setState(drawableState);
                drawable4.copyBounds(rect);
                drawable4.setCallback(this);
                bVar.OWf = rect.height();
                bVar.OWj = rect.width();
            }
            bVar.OWj = 0;
            bVar.OWf = 0;
        } else if (bVar != null) {
            if (bVar.OWm == 0 && !bVar.acU && !bVar.QHG) {
                z = false;
            }
            if (!z) {
                this.QGA = null;
            } else {
                for (int length = bVar.QHE.length - 1; length >= 0; length--) {
                    if (bVar.QHE[length] != null) {
                        bVar.QHE[length].setCallback(null);
                    }
                    bVar.QHE[length] = null;
                }
                bVar.OWk = 0;
                bVar.OWg = 0;
                bVar.OWl = 0;
                bVar.OWh = 0;
                bVar.OWi = 0;
                bVar.OWe = 0;
                bVar.OWj = 0;
                bVar.OWf = 0;
            }
        }
        if (bVar != null) {
            bVar.QHK = drawable;
            bVar.QHL = drawable3;
        }
        this.QGB = -1;
        gZq();
        invalidate();
        requestLayout();
        AppMethodBeat.o(205600);
    }

    public Drawable[] getCompoundDrawables() {
        AppMethodBeat.i(205601);
        b bVar = this.QGA;
        if (bVar != null) {
            Drawable[] drawableArr = (Drawable[]) bVar.QHE.clone();
            AppMethodBeat.o(205601);
            return drawableArr;
        }
        Drawable[] drawableArr2 = {null, null, null, null};
        AppMethodBeat.o(205601);
        return drawableArr2;
    }

    public Drawable[] getCompoundDrawablesRelative() {
        b bVar = this.QGA;
        if (bVar != null) {
            return new Drawable[]{bVar.QHH, bVar.QHE[1], bVar.QHI, bVar.QHE[3]};
        }
        return new Drawable[]{null, null, null, null};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        if (r0 != null) goto L_0x000c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setCompoundDrawablePadding(int r4) {
        /*
            r3 = this;
            r2 = 205602(0x32322, float:2.8811E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            com.tencent.mm.ui.widget.cedit.edit.CustomTextView$b r0 = r3.QGA
            if (r4 != 0) goto L_0x0018
            if (r0 == 0) goto L_0x000e
        L_0x000c:
            r0.OWm = r4
        L_0x000e:
            r3.invalidate()
            r3.requestLayout()
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        L_0x0018:
            if (r0 != 0) goto L_0x000c
            com.tencent.mm.ui.widget.cedit.edit.CustomTextView$b r0 = new com.tencent.mm.ui.widget.cedit.edit.CustomTextView$b
            android.content.Context r1 = r3.getContext()
            r0.<init>(r1)
            r3.QGA = r0
            goto L_0x000c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.widget.cedit.edit.CustomTextView.setCompoundDrawablePadding(int):void");
    }

    public int getCompoundDrawablePadding() {
        b bVar = this.QGA;
        if (bVar != null) {
            return bVar.OWm;
        }
        return 0;
    }

    public void setCompoundDrawableTintList(ColorStateList colorStateList) {
        AppMethodBeat.i(205603);
        if (this.QGA == null) {
            this.QGA = new b(getContext());
        }
        this.QGA.Kr = colorStateList;
        this.QGA.QHG = true;
        gZq();
        AppMethodBeat.o(205603);
    }

    public ColorStateList getCompoundDrawableTintList() {
        if (this.QGA != null) {
            return this.QGA.Kr;
        }
        return null;
    }

    public void setCompoundDrawableTintMode(PorterDuff.Mode mode) {
    }

    public void setCompoundDrawableTintBlendMode(BlendMode blendMode) {
        AppMethodBeat.i(205604);
        if (this.QGA == null) {
            this.QGA = new b(getContext());
        }
        this.QGA.QHF = blendMode;
        this.QGA.acU = true;
        gZq();
        AppMethodBeat.o(205604);
    }

    public PorterDuff.Mode getCompoundDrawableTintMode() {
        return null;
    }

    public BlendMode getCompoundDrawableTintBlendMode() {
        if (this.QGA != null) {
            return this.QGA.QHF;
        }
        return null;
    }

    private void gZq() {
        AppMethodBeat.i(205605);
        if (this.QGA == null) {
            AppMethodBeat.o(205605);
            return;
        }
        if (this.QGA.QHG || this.QGA.acU) {
            ColorStateList colorStateList = this.QGA.Kr;
            boolean z = this.QGA.QHG;
            int[] drawableState = getDrawableState();
            Drawable[] drawableArr = this.QGA.QHE;
            for (Drawable drawable : drawableArr) {
                if (!(drawable == null || drawable == this.QGA.QHJ)) {
                    drawable.mutate();
                    if (z) {
                        drawable.setTintList(colorStateList);
                    }
                    if (drawable.isStateful()) {
                        drawable.setState(drawableState);
                    }
                }
            }
        }
        AppMethodBeat.o(205605);
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(205606);
        if (!(i2 == getPaddingLeft() && i4 == getPaddingRight() && i3 == getPaddingTop() && i5 == getPaddingBottom())) {
            gLr();
        }
        super.setPadding(i2, i3, i4, i5);
        invalidate();
        AppMethodBeat.o(205606);
    }

    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(205607);
        if (!(i2 == getPaddingStart() && i4 == getPaddingEnd() && i3 == getPaddingTop() && i5 == getPaddingBottom())) {
            gLr();
        }
        super.setPaddingRelative(i2, i3, i4, i5);
        invalidate();
        AppMethodBeat.o(205607);
    }

    public void setFirstBaselineToTopHeight(int i2) {
        int i3;
        AppMethodBeat.i(205608);
        com.tencent.mm.ui.widget.cedit.util.b.aL(i2);
        Paint.FontMetricsInt fontMetricsInt = getPaint().getFontMetricsInt();
        if (getIncludeFontPadding()) {
            i3 = fontMetricsInt.top;
        } else {
            i3 = fontMetricsInt.ascent;
        }
        if (i2 > Math.abs(i3)) {
            setPadding(getPaddingLeft(), i2 - (-i3), getPaddingRight(), getPaddingBottom());
        }
        AppMethodBeat.o(205608);
    }

    public void setLastBaselineToBottomHeight(int i2) {
        int i3;
        AppMethodBeat.i(205609);
        com.tencent.mm.ui.widget.cedit.util.b.aL(i2);
        Paint.FontMetricsInt fontMetricsInt = getPaint().getFontMetricsInt();
        if (getIncludeFontPadding()) {
            i3 = fontMetricsInt.bottom;
        } else {
            i3 = fontMetricsInt.descent;
        }
        if (i2 > Math.abs(i3)) {
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), i2 - i3);
        }
        AppMethodBeat.o(205609);
    }

    public int getFirstBaselineToTopHeight() {
        AppMethodBeat.i(205610);
        int paddingTop = getPaddingTop() - getPaint().getFontMetricsInt().top;
        AppMethodBeat.o(205610);
        return paddingTop;
    }

    public int getLastBaselineToBottomHeight() {
        AppMethodBeat.i(205611);
        int paddingBottom = getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
        AppMethodBeat.o(205611);
        return paddingBottom;
    }

    public void setTextSelectHandle(Drawable drawable) {
        AppMethodBeat.i(205612);
        com.tencent.mm.ui.widget.cedit.util.b.checkNotNull(drawable, "The text select handle should not be null.");
        this.QHp = drawable;
        this.QHo = 0;
        if (this.QHs != null) {
            this.QHs.CZ(true);
        }
        AppMethodBeat.o(205612);
    }

    public void setTextSelectHandle(int i2) {
        AppMethodBeat.i(205613);
        com.tencent.mm.ui.widget.cedit.util.b.checkArgument(i2 != 0, "The text select handle should be a valid drawable resource id.");
        setTextSelectHandle(getContext().getDrawable(i2));
        AppMethodBeat.o(205613);
    }

    public Drawable getTextSelectHandle() {
        AppMethodBeat.i(205614);
        if (this.QHp == null && this.QHo != 0) {
            this.QHp = getContext().getDrawable(R.drawable.bv1);
        }
        Drawable drawable = this.QHp;
        AppMethodBeat.o(205614);
        return drawable;
    }

    public void setTextSelectHandleLeft(Drawable drawable) {
        AppMethodBeat.i(205615);
        com.tencent.mm.ui.widget.cedit.util.b.checkNotNull(drawable, "The left text select handle should not be null.");
        this.QHl = drawable;
        this.QHk = 0;
        if (this.QHs != null) {
            this.QHs.CZ(true);
        }
        AppMethodBeat.o(205615);
    }

    public void setTextSelectHandleLeft(int i2) {
        AppMethodBeat.i(205616);
        com.tencent.mm.ui.widget.cedit.util.b.checkArgument(i2 != 0, "The text select left handle should be a valid drawable resource id.");
        setTextSelectHandleLeft(getContext().getDrawable(i2));
        AppMethodBeat.o(205616);
    }

    public Drawable getTextSelectHandleLeft() {
        AppMethodBeat.i(205617);
        if (this.QHl == null && this.QHk != 0) {
            this.QHl = getContext().getDrawable(R.drawable.bv0);
        }
        Drawable drawable = this.QHl;
        AppMethodBeat.o(205617);
        return drawable;
    }

    public void setTextSelectHandleRight(Drawable drawable) {
        AppMethodBeat.i(205618);
        com.tencent.mm.ui.widget.cedit.util.b.checkNotNull(drawable, "The right text select handle should not be null.");
        this.QHn = drawable;
        this.QHm = 0;
        if (this.QHs != null) {
            this.QHs.CZ(true);
        }
        AppMethodBeat.o(205618);
    }

    public void setTextSelectHandleRight(int i2) {
        AppMethodBeat.i(205619);
        com.tencent.mm.ui.widget.cedit.util.b.checkArgument(i2 != 0, "The text select right handle should be a valid drawable resource id.");
        setTextSelectHandleRight(getContext().getDrawable(i2));
        AppMethodBeat.o(205619);
    }

    public Drawable getTextSelectHandleRight() {
        AppMethodBeat.i(205620);
        if (this.QHn == null && this.QHm != 0) {
            this.QHn = getContext().getDrawable(R.drawable.bv2);
        }
        Drawable drawable = this.QHn;
        AppMethodBeat.o(205620);
        return drawable;
    }

    public void setTextCursorDrawable(Drawable drawable) {
        AppMethodBeat.i(205621);
        this.QHj = drawable;
        this.QHi = 0;
        if (this.QHs != null) {
            this.QHs.haA();
        }
        AppMethodBeat.o(205621);
    }

    public void setTextCursorDrawable(int i2) {
        AppMethodBeat.i(205622);
        setTextCursorDrawable(i2 != 0 ? getContext().getDrawable(i2) : null);
        AppMethodBeat.o(205622);
    }

    public Drawable getTextCursorDrawable() {
        AppMethodBeat.i(205623);
        if (this.QHj == null && this.QHi != 0) {
            this.QHj = getContext().getDrawable(this.QHi);
        }
        Drawable drawable = this.QHj;
        AppMethodBeat.o(205623);
        return drawable;
    }

    /* access modifiers changed from: package-private */
    public static class d {
        ColorStateList BpJ;
        int QGM;
        float QGr;
        float QGs;
        float QGt;
        int QHX;
        ColorStateList QHY;
        ColorStateList QHZ;
        LocaleList QIa;
        boolean QIb;
        int QIc;
        int QId;
        int QIe;
        boolean QIf;
        boolean QIg;
        boolean QIh;
        boolean QIi;
        boolean QIj;
        boolean QIk;
        float QIl;
        String QIm;
        String QIn;
        Typeface alr;
        String lal;
        int mAk;
        int nYW;

        private d() {
            this.QHX = 1711528645;
            this.BpJ = null;
            this.QHY = null;
            this.QHZ = null;
            this.mAk = -1;
            this.QGM = -1;
            this.QIa = null;
            this.lal = null;
            this.alr = null;
            this.QIb = false;
            this.QIc = -1;
            this.QId = 0;
            this.QIe = -1;
            this.QIf = false;
            this.nYW = 0;
            this.QGs = 0.0f;
            this.QGt = 0.0f;
            this.QGr = 0.0f;
            this.QIg = false;
            this.QIh = false;
            this.QIi = false;
            this.QIj = false;
            this.QIk = false;
            this.QIl = 0.0f;
            this.QIm = null;
            this.QIn = null;
        }

        /* synthetic */ d(byte b2) {
            this();
        }

        public final String toString() {
            AppMethodBeat.i(205570);
            String str = "TextAppearanceAttributes {\n    mTextColorHighlight:" + this.QHX + "\n    mTextColor:" + this.BpJ + "\n    mTextColorHint:" + this.QHY + "\n    mTextColorLink:" + this.QHZ + "\n    mTextSize:" + this.mAk + "\n    mTextSizeUnit:" + this.QGM + "\n    mTextLocales:" + this.QIa + "\n    mFontFamily:" + this.lal + "\n    mFontTypeface:" + this.alr + "\n    mFontFamilyExplicit:" + this.QIb + "\n    mTypefaceIndex:" + this.QIc + "\n    mTextStyle:" + this.QId + "\n    mFontWeight:" + this.QIe + "\n    mAllCaps:" + this.QIf + "\n    mShadowColor:" + this.nYW + "\n    mShadowDx:" + this.QGs + "\n    mShadowDy:" + this.QGt + "\n    mShadowRadius:" + this.QGr + "\n    mHasElegant:" + this.QIg + "\n    mElegant:" + this.QIh + "\n    mHasFallbackLineSpacing:" + this.QIi + "\n    mFallbackLineSpacing:" + this.QIj + "\n    mHasLetterSpacing:" + this.QIk + "\n    mLetterSpacing:" + this.QIl + "\n    mFontFeatureSettings:" + this.QIm + "\n    mFontVariationSettings:" + this.QIn + "\n}";
            AppMethodBeat.o(205570);
            return str;
        }
    }

    private static void a(Context context, TypedArray typedArray, d dVar) {
        AppMethodBeat.i(205624);
        if (typedArray == null) {
            AppMethodBeat.o(205624);
            return;
        }
        int indexCount = typedArray.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArray.getIndex(i2);
            int i3 = QHw.get(index, -1);
            if (i3 != -1) {
                if (i3 == 5) {
                    dVar.QHX = typedArray.getColor(index, dVar.QHX);
                } else if (i3 == 4) {
                    dVar.BpJ = typedArray.getColorStateList(index);
                } else if (i3 == 6) {
                    dVar.QHY = typedArray.getColorStateList(index);
                } else if (i3 == 7) {
                    dVar.QHZ = typedArray.getColorStateList(index);
                } else if (i3 == 1) {
                    dVar.mAk = typedArray.getDimensionPixelSize(index, dVar.mAk);
                    if (Build.VERSION.SDK_INT >= 22) {
                        dVar.QGM = typedArray.peekValue(index).getComplexUnit();
                    }
                } else if (i3 == 89) {
                    String string = typedArray.getString(index);
                    if (string != null && Build.VERSION.SDK_INT >= 24) {
                        LocaleList forLanguageTags = LocaleList.forLanguageTags(string);
                        if (!forLanguageTags.isEmpty()) {
                            dVar.QIa = forLanguageTags;
                        }
                    }
                } else if (i3 == 2) {
                    dVar.QIc = typedArray.getInt(index, dVar.QIc);
                    if (dVar.QIc != -1 && !dVar.QIb) {
                        dVar.lal = null;
                    }
                } else if (i3 == 68) {
                    if (!context.isRestricted()) {
                        try {
                            if (Build.VERSION.SDK_INT >= 26) {
                                dVar.alr = typedArray.getFont(index);
                            }
                        } catch (Resources.NotFoundException | UnsupportedOperationException e2) {
                        }
                    }
                    if (dVar.alr == null) {
                        dVar.lal = typedArray.getString(index);
                    }
                    dVar.QIb = true;
                } else if (i3 == 3) {
                    dVar.QId = typedArray.getInt(index, dVar.QId);
                } else if (i3 == 88) {
                    dVar.QIe = typedArray.getInt(index, dVar.QIe);
                } else if (i3 == 65) {
                    dVar.QIf = typedArray.getBoolean(index, dVar.QIf);
                } else if (i3 == 34) {
                    dVar.nYW = typedArray.getInt(index, dVar.nYW);
                } else if (i3 == 35) {
                    dVar.QGs = typedArray.getFloat(index, dVar.QGs);
                } else if (i3 == 36) {
                    dVar.QGt = typedArray.getFloat(index, dVar.QGt);
                } else if (i3 == 37) {
                    dVar.QGr = typedArray.getFloat(index, dVar.QGr);
                } else if (i3 == 69) {
                    dVar.QIg = true;
                    dVar.QIh = typedArray.getBoolean(index, dVar.QIh);
                } else if (i3 == 84) {
                    dVar.QIi = true;
                    dVar.QIj = typedArray.getBoolean(index, dVar.QIj);
                } else if (i3 == 70) {
                    dVar.QIk = true;
                    dVar.QIl = typedArray.getFloat(index, dVar.QIl);
                } else if (i3 == 71) {
                    dVar.QIm = typedArray.getString(index);
                } else if (i3 == 83) {
                    dVar.QIn = typedArray.getString(index);
                }
            }
        }
        AppMethodBeat.o(205624);
    }

    public Locale getTextLocale() {
        AppMethodBeat.i(205625);
        Locale textLocale = this.ayn.getTextLocale();
        AppMethodBeat.o(205625);
        return textLocale;
    }

    public LocaleList getTextLocales() {
        AppMethodBeat.i(205626);
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList textLocales = this.ayn.getTextLocales();
            AppMethodBeat.o(205626);
            return textLocales;
        }
        AppMethodBeat.o(205626);
        return null;
    }

    public void setTextLocale(Locale locale) {
        AppMethodBeat.i(205627);
        this.QGL = true;
        this.ayn.setTextLocale(locale);
        if (this.OVt != null) {
            gLr();
            requestLayout();
            invalidate();
        }
        AppMethodBeat.o(205627);
    }

    public void setTextLocales(LocaleList localeList) {
        AppMethodBeat.i(205628);
        this.QGL = true;
        if (Build.VERSION.SDK_INT >= 24) {
            this.ayn.setTextLocales(localeList);
        } else if (localeList != null && localeList.size() > 0) {
            this.ayn.setTextLocale(localeList.get(0));
        }
        if (this.OVt != null) {
            gLr();
            requestLayout();
            invalidate();
        }
        AppMethodBeat.o(205628);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(205629);
        super.onConfigurationChanged(configuration);
        if (!this.QGL) {
            if (Build.VERSION.SDK_INT >= 24) {
                this.ayn.setTextLocales(LocaleList.getDefault());
            } else {
                this.ayn.setTextLocale(Locale.getDefault());
            }
            if (this.OVt != null) {
                gLr();
                requestLayout();
                invalidate();
            }
        }
        AppMethodBeat.o(205629);
    }

    @ViewDebug.ExportedProperty(category = "text")
    public float getTextSize() {
        AppMethodBeat.i(205630);
        float textSize = this.ayn.getTextSize();
        AppMethodBeat.o(205630);
        return textSize;
    }

    @ViewDebug.ExportedProperty(category = "text")
    public float getScaledTextSize() {
        AppMethodBeat.i(205631);
        float textSize = this.ayn.getTextSize() / this.ayn.density;
        AppMethodBeat.o(205631);
        return textSize;
    }

    @ViewDebug.ExportedProperty(category = "text", mapping = {@ViewDebug.IntToString(from = 0, to = "NORMAL"), @ViewDebug.IntToString(from = 1, to = "BOLD"), @ViewDebug.IntToString(from = 2, to = "ITALIC"), @ViewDebug.IntToString(from = 3, to = "BOLD_ITALIC")})
    public int getTypefaceStyle() {
        AppMethodBeat.i(205632);
        Typeface typeface = this.ayn.getTypeface();
        if (typeface != null) {
            int style = typeface.getStyle();
            AppMethodBeat.o(205632);
            return style;
        }
        AppMethodBeat.o(205632);
        return 0;
    }

    public void setTextSize(float f2) {
        AppMethodBeat.i(205633);
        setTextSize(2, f2);
        AppMethodBeat.o(205633);
    }

    private void setRawTextSize$254d549(float f2) {
        AppMethodBeat.i(205635);
        if (f2 != this.ayn.getTextSize()) {
            this.ayn.setTextSize(f2);
            if (this.OVt != null) {
                gLr();
                requestLayout();
                invalidate();
            }
        }
        AppMethodBeat.o(205635);
    }

    public int getTextSizeUnit() {
        return this.QGM;
    }

    public float getTextScaleX() {
        AppMethodBeat.i(205636);
        float textScaleX = this.ayn.getTextScaleX();
        AppMethodBeat.o(205636);
        return textScaleX;
    }

    public void setTextScaleX(float f2) {
        AppMethodBeat.i(205637);
        if (f2 != this.ayn.getTextScaleX()) {
            this.QGK = true;
            this.ayn.setTextScaleX(f2);
            if (this.OVt != null) {
                gLr();
                requestLayout();
                invalidate();
            }
        }
        AppMethodBeat.o(205637);
    }

    public void setTypeface(Typeface typeface) {
        AppMethodBeat.i(205638);
        if (this.ayn.getTypeface() != typeface) {
            this.ayn.setTypeface(typeface);
            if (this.OVt != null) {
                gLr();
                requestLayout();
                invalidate();
            }
        }
        AppMethodBeat.o(205638);
    }

    public Typeface getTypeface() {
        AppMethodBeat.i(205639);
        Typeface typeface = this.ayn.getTypeface();
        AppMethodBeat.o(205639);
        return typeface;
    }

    public void setElegantTextHeight(boolean z) {
        AppMethodBeat.i(205640);
        if (z != this.ayn.isElegantTextHeight()) {
            this.ayn.setElegantTextHeight(z);
            if (this.OVt != null) {
                gLr();
                requestLayout();
                invalidate();
            }
        }
        AppMethodBeat.o(205640);
    }

    public void setFallbackLineSpacing(boolean z) {
        AppMethodBeat.i(205641);
        if (this.QGP != z) {
            this.QGP = z;
            if (this.OVt != null) {
                gLr();
                requestLayout();
                invalidate();
            }
        }
        AppMethodBeat.o(205641);
    }

    public float getLetterSpacing() {
        AppMethodBeat.i(205642);
        float letterSpacing = this.ayn.getLetterSpacing();
        AppMethodBeat.o(205642);
        return letterSpacing;
    }

    public void setLetterSpacing(float f2) {
        AppMethodBeat.i(205643);
        if (f2 != this.ayn.getLetterSpacing()) {
            this.ayn.setLetterSpacing(f2);
            if (this.OVt != null) {
                gLr();
                requestLayout();
                invalidate();
            }
        }
        AppMethodBeat.o(205643);
    }

    public String getFontFeatureSettings() {
        AppMethodBeat.i(205644);
        String fontFeatureSettings = this.ayn.getFontFeatureSettings();
        AppMethodBeat.o(205644);
        return fontFeatureSettings;
    }

    public String getFontVariationSettings() {
        AppMethodBeat.i(205645);
        if (Build.VERSION.SDK_INT >= 26) {
            String fontVariationSettings = this.ayn.getFontVariationSettings();
            AppMethodBeat.o(205645);
            return fontVariationSettings;
        }
        AppMethodBeat.o(205645);
        return "";
    }

    public void setBreakStrategy(int i2) {
        AppMethodBeat.i(205646);
        this.On = i2;
        if (this.OVt != null) {
            gLr();
            requestLayout();
            invalidate();
        }
        AppMethodBeat.o(205646);
    }

    public void setFontFeatureSettings(String str) {
        AppMethodBeat.i(205647);
        if (str != this.ayn.getFontFeatureSettings()) {
            this.ayn.setFontFeatureSettings(str);
            if (this.OVt != null) {
                gLr();
                requestLayout();
                invalidate();
            }
        }
        AppMethodBeat.o(205647);
    }

    public void setTextColor(int i2) {
        AppMethodBeat.i(205648);
        this.BpJ = ColorStateList.valueOf(i2);
        updateTextColors();
        AppMethodBeat.o(205648);
    }

    public void setTextColor(ColorStateList colorStateList) {
        AppMethodBeat.i(205649);
        if (colorStateList == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(205649);
            throw nullPointerException;
        }
        this.BpJ = colorStateList;
        updateTextColors();
        AppMethodBeat.o(205649);
    }

    public final ColorStateList getTextColors() {
        return this.BpJ;
    }

    public final int getCurrentTextColor() {
        return this.OVm;
    }

    public void setHighlightColor(int i2) {
        AppMethodBeat.i(205650);
        if (this.oEF != i2) {
            this.oEF = i2;
            invalidate();
        }
        AppMethodBeat.o(205650);
    }

    public void setHandleColorRes(int i2) {
        this.QHx = i2;
    }

    public int getHighlightColor() {
        return this.oEF;
    }

    public final void setShowSoftInputOnFocus(boolean z) {
        AppMethodBeat.i(205651);
        gZL();
        this.QHs.QIQ = z;
        AppMethodBeat.o(205651);
    }

    public final boolean getShowSoftInputOnFocus() {
        return this.QHs == null || this.QHs.QIQ;
    }

    public float getShadowRadius() {
        return this.QGr;
    }

    public float getShadowDx() {
        return this.QGs;
    }

    public float getShadowDy() {
        return this.QGt;
    }

    public int getShadowColor() {
        return this.nYW;
    }

    public TextPaint getPaint() {
        return this.ayn;
    }

    public final void setAutoLinkMask(int i2) {
        this.QGR = i2;
    }

    public final void setLinksClickable(boolean z) {
        this.QGS = z;
    }

    public final boolean getLinksClickable() {
        return this.QGS;
    }

    public URLSpan[] getUrls() {
        AppMethodBeat.i(205652);
        if (this.mText instanceof Spanned) {
            URLSpan[] uRLSpanArr = (URLSpan[]) ((Spanned) this.mText).getSpans(0, this.mText.length(), URLSpan.class);
            AppMethodBeat.o(205652);
            return uRLSpanArr;
        }
        URLSpan[] uRLSpanArr2 = new URLSpan[0];
        AppMethodBeat.o(205652);
        return uRLSpanArr2;
    }

    public final void setHintTextColor(int i2) {
        AppMethodBeat.i(205653);
        this.QGn = ColorStateList.valueOf(i2);
        updateTextColors();
        AppMethodBeat.o(205653);
    }

    public final void setHintTextColor(ColorStateList colorStateList) {
        AppMethodBeat.i(205654);
        this.QGn = colorStateList;
        updateTextColors();
        AppMethodBeat.o(205654);
    }

    public final ColorStateList getHintTextColors() {
        return this.QGn;
    }

    public final int getCurrentHintTextColor() {
        return this.QGn != null ? this.QGp : this.OVm;
    }

    public final void setLinkTextColor(int i2) {
        AppMethodBeat.i(205655);
        this.QGo = ColorStateList.valueOf(i2);
        updateTextColors();
        AppMethodBeat.o(205655);
    }

    public final void setLinkTextColor(ColorStateList colorStateList) {
        AppMethodBeat.i(205656);
        this.QGo = colorStateList;
        updateTextColors();
        AppMethodBeat.o(205656);
    }

    public final ColorStateList getLinkTextColors() {
        return this.QGo;
    }

    public void setGravity(int i2) {
        int i3;
        boolean z;
        int i4 = 0;
        AppMethodBeat.i(205657);
        if ((i2 & 8388615) == 0) {
            i3 = 8388611 | i2;
        } else {
            i3 = i2;
        }
        if ((i3 & 112) == 0) {
            i3 |= 48;
        }
        if ((i3 & 8388615) != (this.Ku & 8388615)) {
            z = true;
        } else {
            z = false;
        }
        if (i3 != this.Ku) {
            invalidate();
        }
        this.Ku = i3;
        if (this.OVt != null && z) {
            int width = this.OVt.getWidth();
            if (this.QGF != null) {
                i4 = this.QGF.getWidth();
            }
            BoringLayout.Metrics metrics = OVU;
            a(width, i4, metrics, metrics, ((getRight() - getLeft()) - getCompoundPaddingLeft()) - getCompoundPaddingRight(), true);
        }
        AppMethodBeat.o(205657);
    }

    public int getGravity() {
        return this.Ku;
    }

    public int getPaintFlags() {
        AppMethodBeat.i(205658);
        int flags = this.ayn.getFlags();
        AppMethodBeat.o(205658);
        return flags;
    }

    public void setPaintFlags(int i2) {
        AppMethodBeat.i(205659);
        if (this.ayn.getFlags() != i2) {
            this.ayn.setFlags(i2);
            if (this.OVt != null) {
                gLr();
                requestLayout();
                invalidate();
            }
        }
        AppMethodBeat.o(205659);
    }

    public void setHorizontallyScrolling(boolean z) {
        AppMethodBeat.i(205660);
        if (this.QGQ != z) {
            this.QGQ = z;
            if (this.OVt != null) {
                gLr();
                requestLayout();
                invalidate();
            }
        }
        AppMethodBeat.o(205660);
    }

    public boolean getHorizontallyScrolling() {
        return this.QGQ;
    }

    public void setMinLines(int i2) {
        AppMethodBeat.i(205661);
        this.OVy = i2;
        this.OVz = 1;
        requestLayout();
        invalidate();
        AppMethodBeat.o(205661);
    }

    public int getMinLines() {
        if (this.OVz == 1) {
            return this.OVy;
        }
        return -1;
    }

    public void setMinHeight(int i2) {
        AppMethodBeat.i(205662);
        this.OVy = i2;
        this.OVz = 2;
        requestLayout();
        invalidate();
        AppMethodBeat.o(205662);
    }

    public int getMinHeight() {
        if (this.OVz == 2) {
            return this.OVy;
        }
        return -1;
    }

    public void setMaxLines(int i2) {
        AppMethodBeat.i(205663);
        this.OVw = i2;
        this.OVx = 1;
        requestLayout();
        invalidate();
        AppMethodBeat.o(205663);
    }

    public int getMaxLines() {
        if (this.OVx == 1) {
            return this.OVw;
        }
        return -1;
    }

    public void setMaxHeight(int i2) {
        AppMethodBeat.i(205664);
        this.OVw = i2;
        this.OVx = 2;
        requestLayout();
        invalidate();
        AppMethodBeat.o(205664);
    }

    public int getMaxHeight() {
        if (this.OVx == 2) {
            return this.OVw;
        }
        return -1;
    }

    public void setLines(int i2) {
        AppMethodBeat.i(205665);
        this.OVy = i2;
        this.OVw = i2;
        this.OVz = 1;
        this.OVx = 1;
        requestLayout();
        invalidate();
        AppMethodBeat.o(205665);
    }

    public void setHeight(int i2) {
        AppMethodBeat.i(205666);
        this.OVy = i2;
        this.OVw = i2;
        this.OVz = 2;
        this.OVx = 2;
        requestLayout();
        invalidate();
        AppMethodBeat.o(205666);
    }

    public void setMinEms(int i2) {
        AppMethodBeat.i(205667);
        this.mMinWidth = i2;
        this.QGX = 1;
        requestLayout();
        invalidate();
        AppMethodBeat.o(205667);
    }

    public int getMinEms() {
        if (this.QGX == 1) {
            return this.mMinWidth;
        }
        return -1;
    }

    public void setMinWidth(int i2) {
        AppMethodBeat.i(205668);
        this.mMinWidth = i2;
        this.QGX = 2;
        requestLayout();
        invalidate();
        AppMethodBeat.o(205668);
    }

    public int getMinWidth() {
        if (this.QGX == 2) {
            return this.mMinWidth;
        }
        return -1;
    }

    public void setMaxEms(int i2) {
        AppMethodBeat.i(205669);
        this.mMaxWidth = i2;
        this.QGW = 1;
        requestLayout();
        invalidate();
        AppMethodBeat.o(205669);
    }

    public int getMaxEms() {
        if (this.QGW == 1) {
            return this.mMaxWidth;
        }
        return -1;
    }

    public void setMaxWidth(int i2) {
        AppMethodBeat.i(205670);
        this.mMaxWidth = i2;
        this.QGW = 2;
        requestLayout();
        invalidate();
        AppMethodBeat.o(205670);
    }

    public int getMaxWidth() {
        if (this.QGW == 2) {
            return this.mMaxWidth;
        }
        return -1;
    }

    public void setEms(int i2) {
        AppMethodBeat.i(205671);
        this.mMinWidth = i2;
        this.mMaxWidth = i2;
        this.QGX = 1;
        this.QGW = 1;
        requestLayout();
        invalidate();
        AppMethodBeat.o(205671);
    }

    public void setWidth(int i2) {
        AppMethodBeat.i(205672);
        this.mMinWidth = i2;
        this.mMaxWidth = i2;
        this.QGX = 2;
        this.QGW = 2;
        requestLayout();
        invalidate();
        AppMethodBeat.o(205672);
    }

    public float getLineSpacingMultiplier() {
        return this.OVu;
    }

    public float getLineSpacingExtra() {
        return this.OVv;
    }

    @SuppressLint({"RestrictedApi"})
    public void setLineHeight(int i2) {
        AppMethodBeat.i(205673);
        com.tencent.mm.ui.widget.cedit.util.b.aL(i2);
        int fontMetricsInt = getPaint().getFontMetricsInt(null);
        if (i2 != fontMetricsInt) {
            float f2 = (float) (i2 - fontMetricsInt);
            if (!(this.OVv == f2 && this.OVu == 1.0f)) {
                this.OVv = f2;
                this.OVu = 1.0f;
                if (this.OVt != null) {
                    gLr();
                    requestLayout();
                    invalidate();
                }
            }
        }
        AppMethodBeat.o(205673);
    }

    public final void append(CharSequence charSequence) {
        AppMethodBeat.i(205674);
        int length = charSequence.length();
        if (!(this.mText instanceof Editable)) {
            setText(this.mText, TextView.BufferType.EDITABLE);
        }
        ((Editable) this.mText).append(charSequence, 0, length);
        if (this.QGR != 0 && Linkify.addLinks(this.QGC, this.QGR) && this.QGS && !gZD()) {
            setMovementMethod(com.tencent.mm.ui.widget.cedit.b.c.haX());
        }
        AppMethodBeat.o(205674);
    }

    private void updateTextColors() {
        boolean z;
        int colorForState;
        int colorForState2;
        AppMethodBeat.i(205675);
        int[] drawableState = getDrawableState();
        int colorForState3 = this.BpJ.getColorForState(drawableState, 0);
        if (colorForState3 != this.OVm) {
            this.OVm = colorForState3;
            z = true;
        } else {
            z = false;
        }
        if (!(this.QGo == null || (colorForState2 = this.QGo.getColorForState(drawableState, 0)) == this.ayn.linkColor)) {
            this.ayn.linkColor = colorForState2;
            z = true;
        }
        if (!(this.QGn == null || (colorForState = this.QGn.getColorForState(drawableState, 0)) == this.QGp)) {
            this.QGp = colorForState;
            if (this.mText.length() == 0) {
                z = true;
            }
        }
        if (z) {
            invalidate();
        }
        AppMethodBeat.o(205675);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        AppMethodBeat.i(205676);
        super.drawableStateChanged();
        if ((this.BpJ != null && this.BpJ.isStateful()) || ((this.QGn != null && this.QGn.isStateful()) || (this.QGo != null && this.QGo.isStateful()))) {
            updateTextColors();
        }
        if (this.QGA != null) {
            int[] drawableState = getDrawableState();
            Drawable[] drawableArr = this.QGA.QHE;
            for (Drawable drawable : drawableArr) {
                if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
                    invalidateDrawable(drawable);
                }
            }
        }
        AppMethodBeat.o(205676);
    }

    public void drawableHotspotChanged(float f2, float f3) {
        AppMethodBeat.i(205677);
        super.drawableHotspotChanged(f2, f3);
        if (this.QGA != null) {
            Drawable[] drawableArr = this.QGA.QHE;
            for (Drawable drawable : drawableArr) {
                if (drawable != null) {
                    drawable.setHotspot(f2, f3);
                }
            }
        }
        AppMethodBeat.o(205677);
    }

    public Parcelable onSaveInstanceState() {
        int i2;
        int i3;
        AppMethodBeat.i(205678);
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        boolean freezesText = getFreezesText();
        boolean z = false;
        if (this.mText != null) {
            i3 = getSelectionStart();
            int selectionEnd = getSelectionEnd();
            if (i3 >= 0 || selectionEnd >= 0) {
                i2 = selectionEnd;
                z = true;
            } else {
                i2 = selectionEnd;
            }
        } else {
            i2 = -1;
            i3 = -1;
        }
        if (freezesText || z) {
            SavedState savedState = new SavedState(onSaveInstanceState);
            if (freezesText) {
                if (this.mText instanceof Spanned) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.mText);
                    if (this.QHs != null) {
                        h(spannableStringBuilder);
                    }
                    savedState.text = spannableStringBuilder;
                } else {
                    savedState.text = this.mText.toString();
                }
            }
            if (z) {
                savedState.QHT = i3;
                savedState.QHU = i2;
            }
            if (isFocused() && i3 >= 0 && i2 >= 0) {
                savedState.QHV = true;
            }
            AppMethodBeat.o(205678);
            return savedState;
        }
        AppMethodBeat.o(205678);
        return onSaveInstanceState;
    }

    private static void h(Spannable spannable) {
        AppMethodBeat.i(205679);
        Object[] objArr = (SuggestionSpan[]) spannable.getSpans(0, spannable.length(), SuggestionSpan.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            int flags = objArr[i2].getFlags();
            if (!((flags & 1) == 0 || (flags & 2) == 0)) {
                spannable.removeSpan(objArr[i2]);
            }
        }
        AppMethodBeat.o(205679);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.i(205680);
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            AppMethodBeat.o(205680);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.text != null) {
            setText(savedState.text);
        }
        if (savedState.QHT >= 0 && savedState.QHU >= 0 && this.QGC != null) {
            int length = this.mText.length();
            if (savedState.QHT > length || savedState.QHU > length) {
                String str = "";
                if (savedState.text != null) {
                    str = "(restored) ";
                }
                Log.e("cmEdit.CMTextView", "Saved cursor position " + savedState.QHT + FilePathGenerator.ANDROID_DIR_SEP + savedState.QHU + " out of range for " + str + "text " + ((Object) this.mText));
            } else {
                Selection.setSelection(this.QGC, savedState.QHT, savedState.QHU);
                if (savedState.QHV) {
                    gZL();
                    this.QHs.QIE = true;
                }
            }
        }
        if (savedState.QHW != null) {
            gZL();
            savedState.QHW.aBu.setDataPosition(0);
        }
        AppMethodBeat.o(205680);
    }

    public void setFreezesText(boolean z) {
        this.QGq = z;
    }

    public boolean getFreezesText() {
        return this.QGq;
    }

    public final void setEditableFactory(Editable.Factory factory) {
        AppMethodBeat.i(205681);
        this.OVn = factory;
        setText(this.mText);
        AppMethodBeat.o(205681);
    }

    public final void setSpannableFactory(Spannable.Factory factory) {
        AppMethodBeat.i(205682);
        this.OVo = factory;
        setText(this.mText);
        AppMethodBeat.o(205682);
    }

    public final void setText(CharSequence charSequence) {
        AppMethodBeat.i(205683);
        setText(charSequence, this.QGD);
        AppMethodBeat.o(205683);
    }

    public final void setTextKeepState(CharSequence charSequence) {
        AppMethodBeat.i(205684);
        TextView.BufferType bufferType = this.QGD;
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        int length = charSequence.length();
        setText(charSequence, bufferType);
        if ((selectionStart >= 0 || selectionEnd >= 0) && this.QGC != null) {
            Selection.setSelection(this.QGC, Math.max(0, Math.min(selectionStart, length)), Math.max(0, Math.min(selectionEnd, length)));
        }
        AppMethodBeat.o(205684);
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        AppMethodBeat.i(205685);
        a(charSequence, bufferType, true, 0);
        AppMethodBeat.o(205685);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:103:0x003d */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0109, code lost:
        if (r11.QGG != null) goto L_0x010b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ef A[LOOP:1: B:61:0x00ed->B:62:0x00ef, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0180  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.CharSequence r12, android.widget.TextView.BufferType r13, boolean r14, int r15) {
        /*
        // Method dump skipped, instructions count: 399
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.widget.cedit.edit.CustomTextView.a(java.lang.CharSequence, android.widget.TextView$BufferType, boolean, int):void");
    }

    public final void setText(int i2) {
        AppMethodBeat.i(205687);
        setText(getContext().getResources().getText(i2));
        AppMethodBeat.o(205687);
    }

    public final void setHint(CharSequence charSequence) {
        boolean z;
        AppMethodBeat.i(205688);
        setHintInternal(charSequence);
        if (this.QHs != null) {
            InputMethodManager inputMethodManager = getInputMethodManager();
            if (inputMethodManager == null || !inputMethodManager.isActive(this)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                this.QHs.hae();
            }
        }
        AppMethodBeat.o(205688);
    }

    private void setHintInternal(CharSequence charSequence) {
        AppMethodBeat.i(205689);
        this.QGE = TextUtils.stringOrSpannedString(charSequence);
        if (this.OVt != null) {
            IR();
        }
        if (this.mText.length() == 0) {
            invalidate();
        }
        if (this.QHs != null) {
            this.mText.length();
        }
        AppMethodBeat.o(205689);
    }

    public final void setHint(int i2) {
        AppMethodBeat.i(205690);
        setHint(getContext().getResources().getText(i2));
        AppMethodBeat.o(205690);
    }

    @ViewDebug.CapturedViewProperty
    public CharSequence getHint() {
        return this.QGE;
    }

    private static boolean aox(int i2) {
        return (131087 & i2) == 131073;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x003a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r1v1 */
    private CharSequence ax(CharSequence charSequence) {
        Spannable spannable;
        AppMethodBeat.i(205691);
        if (charSequence instanceof Spanned) {
            if (charSequence instanceof Spannable) {
                spannable = (Spannable) charSequence;
            } else {
                spannable = this.OVo.newSpannable(charSequence);
            }
            SuggestionSpan[] suggestionSpanArr = (SuggestionSpan[]) spannable.getSpans(0, charSequence.length(), SuggestionSpan.class);
            if (suggestionSpanArr.length == 0) {
                AppMethodBeat.o(205691);
                return charSequence;
            }
            for (SuggestionSpan suggestionSpan : suggestionSpanArr) {
                spannable.removeSpan(suggestionSpan);
            }
        } else {
            spannable = charSequence;
        }
        AppMethodBeat.o(205691);
        return spannable;
    }

    public void setInputType(int i2) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        AppMethodBeat.i(205692);
        boolean aoy = aoy(getInputType());
        boolean aoz = aoz(getInputType());
        bO(i2, false);
        boolean aoy2 = aoy(i2);
        boolean aoz2 = aoz(i2);
        if (aoy2) {
            setTransformationMethod(PasswordTransformationMethod.getInstance());
            a((Typeface) null, (String) null, 3, 0, -1);
            z = false;
        } else if (aoz2) {
            if (this.QGH == PasswordTransformationMethod.getInstance()) {
                z = true;
            } else {
                z = false;
            }
            a((Typeface) null, (String) null, 3, 0, -1);
        } else {
            if (aoy || aoz) {
                a((Typeface) null, (String) null, -1, 0, -1);
                if (this.QGH == PasswordTransformationMethod.getInstance()) {
                    z = true;
                }
            }
            z = false;
        }
        if (!aox(i2)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.OSP != z2 || z) {
            if (!aoy2) {
                z3 = true;
            }
            r(z2, z3, true);
        }
        if (!isSuggestionsEnabled()) {
            setTextInternal(ax(this.mText));
        }
        InputMethodManager inputMethodManager = getInputMethodManager();
        if (inputMethodManager != null) {
            inputMethodManager.restartInput(this);
        }
        AppMethodBeat.o(205692);
    }

    private static boolean aoy(int i2) {
        int i3 = i2 & 4095;
        return i3 == 129 || i3 == 225 || i3 == 18;
    }

    private static boolean aoz(int i2) {
        return (i2 & 4095) == 145;
    }

    public void setRawInputType(int i2) {
        AppMethodBeat.i(205693);
        if (i2 == 0 && this.QHs == null) {
            AppMethodBeat.o(205693);
            return;
        }
        gZL();
        this.QHs.Clf = i2;
        AppMethodBeat.o(205693);
    }

    private Locale getCustomLocaleForKeyListenerOrNull() {
        AppMethodBeat.i(205694);
        if (!this.QGO) {
            AppMethodBeat.o(205694);
            return null;
        }
        LocaleList imeHintLocales = getImeHintLocales();
        if (imeHintLocales == null) {
            AppMethodBeat.o(205694);
            return null;
        } else if (Build.VERSION.SDK_INT >= 24) {
            Locale locale = imeHintLocales.get(0);
            AppMethodBeat.o(205694);
            return locale;
        } else {
            AppMethodBeat.o(205694);
            return null;
        }
    }

    private void bO(int i2, boolean z) {
        KeyListener instance;
        TextKeyListener.Capitalize capitalize;
        boolean z2 = true;
        AppMethodBeat.i(205695);
        int i3 = i2 & 15;
        DigitsKeyListener digitsKeyListener = null;
        if (i3 == 1) {
            boolean z3 = (32768 & i2) != 0;
            if ((i2 & 4096) != 0) {
                capitalize = TextKeyListener.Capitalize.CHARACTERS;
            } else if ((i2 & 8192) != 0) {
                capitalize = TextKeyListener.Capitalize.WORDS;
            } else if ((i2 & 16384) != 0) {
                capitalize = TextKeyListener.Capitalize.SENTENCES;
            } else {
                capitalize = TextKeyListener.Capitalize.NONE;
            }
            instance = TextKeyListener.getInstance(z3, capitalize);
        } else if (i3 == 2) {
            Locale customLocaleForKeyListenerOrNull = getCustomLocaleForKeyListenerOrNull();
            if (Build.VERSION.SDK_INT >= 26) {
                boolean z4 = (i2 & 4096) != 0;
                if ((i2 & 8192) == 0) {
                    z2 = false;
                }
                digitsKeyListener = DigitsKeyListener.getInstance(customLocaleForKeyListenerOrNull, z4, z2);
            }
            if (customLocaleForKeyListenerOrNull != null) {
                int inputType = digitsKeyListener.getInputType();
                if ((inputType & 15) != 2) {
                    if ((i2 & 16) != 0) {
                        inputType |= 128;
                    }
                    i2 = inputType;
                }
            }
            instance = digitsKeyListener;
        } else if (i3 == 4) {
            Locale customLocaleForKeyListenerOrNull2 = getCustomLocaleForKeyListenerOrNull();
            switch (i2 & 4080) {
                case 16:
                    if (Build.VERSION.SDK_INT >= 26) {
                        instance = DateKeyListener.getInstance(customLocaleForKeyListenerOrNull2);
                        break;
                    }
                    instance = null;
                    break;
                case 32:
                    if (Build.VERSION.SDK_INT >= 26) {
                        instance = TimeKeyListener.getInstance(customLocaleForKeyListenerOrNull2);
                        break;
                    }
                    instance = null;
                    break;
                default:
                    if (Build.VERSION.SDK_INT >= 26) {
                        instance = DateTimeKeyListener.getInstance(customLocaleForKeyListenerOrNull2);
                        break;
                    }
                    instance = null;
                    break;
            }
            if (this.QGO) {
                i2 = instance.getInputType();
            }
        } else if (i3 == 3) {
            instance = DialerKeyListener.getInstance();
        } else {
            instance = TextKeyListener.getInstance();
        }
        setRawInputType(i2);
        this.QGN = false;
        if (z) {
            gZL();
            this.QHs.QIH = instance;
            AppMethodBeat.o(205695);
            return;
        }
        setKeyListenerOnly(instance);
        AppMethodBeat.o(205695);
    }

    public int getInputType() {
        if (this.QHs == null) {
            return 0;
        }
        return this.QHs.Clf;
    }

    public void setImeOptions(int i2) {
        AppMethodBeat.i(205696);
        gZL();
        this.QHs.gZO();
        this.QHs.QIC.imeOptions = i2;
        AppMethodBeat.o(205696);
    }

    public int getImeOptions() {
        if (this.QHs == null || this.QHs.QIC == null) {
            return 0;
        }
        return this.QHs.QIC.imeOptions;
    }

    public CharSequence getImeActionLabel() {
        if (this.QHs == null || this.QHs.QIC == null) {
            return null;
        }
        return this.QHs.QIC.QKh;
    }

    public int getImeActionId() {
        if (this.QHs == null || this.QHs.QIC == null) {
            return 0;
        }
        return this.QHs.QIC.imeActionId;
    }

    public void setOnEditorActionListener(c cVar) {
        AppMethodBeat.i(205697);
        gZL();
        this.QHs.gZO();
        this.QHs.QIC.QKi = cVar;
        AppMethodBeat.o(205697);
    }

    public void setPrivateImeOptions(String str) {
        AppMethodBeat.i(205698);
        gZL();
        this.QHs.gZO();
        this.QHs.QIC.privateImeOptions = str;
        AppMethodBeat.o(205698);
    }

    public String getPrivateImeOptions() {
        if (this.QHs == null || this.QHs.QIC == null) {
            return null;
        }
        return this.QHs.QIC.privateImeOptions;
    }

    public void setInputExtras(int i2) {
        AppMethodBeat.i(205699);
        gZL();
        XmlResourceParser xml = getResources().getXml(i2);
        this.QHs.gZO();
        this.QHs.QIC.extras = new Bundle();
        getResources().parseBundleExtras(xml, this.QHs.QIC.extras);
        AppMethodBeat.o(205699);
    }

    public Bundle getInputExtras(boolean z) {
        AppMethodBeat.i(205700);
        if (this.QHs != null || z) {
            gZL();
            if (this.QHs.QIC == null) {
                if (!z) {
                    AppMethodBeat.o(205700);
                    return null;
                }
                this.QHs.gZO();
            }
            if (this.QHs.QIC.extras == null) {
                if (!z) {
                    AppMethodBeat.o(205700);
                    return null;
                }
                this.QHs.QIC.extras = new Bundle();
            }
            Bundle bundle = this.QHs.QIC.extras;
            AppMethodBeat.o(205700);
            return bundle;
        }
        AppMethodBeat.o(205700);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setImeHintLocales(android.os.LocaleList r6) {
        /*
        // Method dump skipped, instructions count: 153
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.widget.cedit.edit.CustomTextView.setImeHintLocales(android.os.LocaleList):void");
    }

    public LocaleList getImeHintLocales() {
        if (this.QHs == null || this.QHs.QIC == null) {
            return null;
        }
        return this.QHs.QIC.QKk;
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        AppMethodBeat.i(205703);
        if (inputFilterArr == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(205703);
            throw illegalArgumentException;
        }
        this.QHc = inputFilterArr;
        if (this.mText instanceof Editable) {
            a((Editable) this.mText, inputFilterArr);
        }
        AppMethodBeat.o(205703);
    }

    private void a(Editable editable, InputFilter[] inputFilterArr) {
        char c2;
        AppMethodBeat.i(205704);
        if (this.QHs != null) {
            boolean z = this.QHs.QIH instanceof InputFilter;
            if (z) {
                c2 = 1;
            } else {
                c2 = 0;
            }
            if (c2 > 0) {
                InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length + 1)];
                System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, inputFilterArr.length);
                if (z) {
                    inputFilterArr2[inputFilterArr.length + 0] = (InputFilter) this.QHs.QIH;
                }
                editable.setFilters(inputFilterArr2);
                AppMethodBeat.o(205704);
                return;
            }
        }
        editable.setFilters(inputFilterArr);
        AppMethodBeat.o(205704);
    }

    public InputFilter[] getFilters() {
        return this.QHc;
    }

    private int a(Layout layout) {
        int extendedPaddingTop;
        AppMethodBeat.i(205705);
        if (layout == this.QGF) {
            extendedPaddingTop = getCompoundPaddingTop() + getCompoundPaddingBottom();
        } else {
            extendedPaddingTop = getExtendedPaddingTop() + getExtendedPaddingBottom();
        }
        int measuredHeight = getMeasuredHeight() - extendedPaddingTop;
        AppMethodBeat.o(205705);
        return measuredHeight;
    }

    /* access modifiers changed from: package-private */
    public final int CW(boolean z) {
        int a2;
        int height;
        AppMethodBeat.i(205706);
        int i2 = 0;
        int i3 = this.Ku & 112;
        Layout layout = this.OVt;
        if (!z && this.mText.length() == 0 && this.QGF != null) {
            layout = this.QGF;
        }
        if (i3 != 48 && (height = layout.getHeight()) < (a2 = a(layout))) {
            i2 = i3 == 80 ? a2 - height : (a2 - height) >> 1;
        }
        AppMethodBeat.o(205706);
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final void gZr() {
        float f2 = 1.0f;
        AppMethodBeat.i(205707);
        if (this.QHh) {
            gZs();
            AppMethodBeat.o(205707);
            return;
        }
        int compoundPaddingLeft = getCompoundPaddingLeft();
        int CW = CW(true) + getExtendedPaddingTop();
        if (this.QHs.QIY == null) {
            synchronized (alw) {
                try {
                    float ceil = (float) Math.ceil((double) this.ayn.getStrokeWidth());
                    if (ceil >= 1.0f) {
                        f2 = ceil;
                    }
                    float f3 = f2 / 2.0f;
                    this.QHf.computeBounds(alw, false);
                    invalidate((int) Math.floor((double) ((((float) compoundPaddingLeft) + alw.left) - f3)), (int) Math.floor((double) ((((float) CW) + alw.top) - f3)), (int) Math.ceil((double) (((float) compoundPaddingLeft) + alw.right + f3)), (int) Math.ceil((double) (f3 + ((float) CW) + alw.bottom)));
                } finally {
                    AppMethodBeat.o(205707);
                }
            }
            return;
        }
        Rect bounds = this.QHs.QIY.getBounds();
        invalidate(bounds.left + compoundPaddingLeft, bounds.top + CW, compoundPaddingLeft + bounds.right, bounds.bottom + CW);
        AppMethodBeat.o(205707);
    }

    /* access modifiers changed from: package-private */
    public final void gZs() {
        AppMethodBeat.i(205708);
        int selectionEnd = getSelectionEnd();
        aV(selectionEnd, selectionEnd, selectionEnd);
        AppMethodBeat.o(205708);
    }

    private void aV(int i2, int i3, int i4) {
        AppMethodBeat.i(205709);
        if (i2 >= 0 || i3 >= 0 || i4 >= 0) {
            lz(Math.min(Math.min(i2, i3), i4), Math.max(Math.max(i2, i3), i4));
        }
        AppMethodBeat.o(205709);
    }

    private void lz(int i2, int i3) {
        int i4;
        AppMethodBeat.i(205710);
        if (this.OVt == null) {
            invalidate();
            AppMethodBeat.o(205710);
            return;
        }
        int lineForOffset = this.OVt.getLineForOffset(i2);
        int lineTop = this.OVt.getLineTop(lineForOffset);
        if (lineForOffset > 0) {
            lineTop -= this.OVt.getLineDescent(lineForOffset - 1);
        }
        if (i2 != i3) {
            lineForOffset = this.OVt.getLineForOffset(i3);
        }
        int lineBottom = this.OVt.getLineBottom(lineForOffset);
        if (this.QHs == null || this.QHs.QIY == null) {
            i4 = lineTop;
        } else {
            Rect bounds = this.QHs.QIY.getBounds();
            i4 = Math.min(lineTop, bounds.top);
            lineBottom = Math.max(lineBottom, bounds.bottom);
        }
        int compoundPaddingLeft = getCompoundPaddingLeft();
        int extendedPaddingTop = getExtendedPaddingTop() + CW(true);
        invalidate(compoundPaddingLeft + getScrollX(), i4 + extendedPaddingTop, (getWidth() - getCompoundPaddingRight()) + getScrollY(), lineBottom + extendedPaddingTop);
        AppMethodBeat.o(205710);
    }

    private void gZt() {
        AppMethodBeat.i(205711);
        if (!this.QGu) {
            getViewTreeObserver().addOnPreDrawListener(this);
            this.QGu = true;
        }
        AppMethodBeat.o(205711);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(205713);
        super.onAttachedToWindow();
        if (this.QHs != null) {
            b bVar = this.QHs;
            ViewTreeObserver viewTreeObserver = bVar.QIo.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                if (bVar.QIs != null) {
                    viewTreeObserver.addOnTouchModeChangeListener(bVar.QIs);
                }
                if (bVar.QIt != null) {
                    bVar.QIt.haN();
                    viewTreeObserver.addOnTouchModeChangeListener(bVar.QIt);
                }
                viewTreeObserver.addOnDrawListener(bVar.QIA);
            }
            if (bVar.QIo.hasSelection()) {
                bVar.hai();
            }
            bVar.gZS();
        }
        if (this.QGv) {
            getViewTreeObserver().addOnPreDrawListener(this);
            this.QGv = false;
        }
        post(new Runnable() {
            /* class com.tencent.mm.ui.widget.cedit.edit.CustomTextView.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(205555);
                CustomTextView customTextView = CustomTextView.this;
                boolean gZN = customTextView.gZN();
                Log.i("cmEdit.CMTextView", "checkInitAdaptEdt isNeedReuseMenuItems:".concat(String.valueOf(gZN)));
                if (gZN) {
                    boolean isAttachedToWindow = customTextView.isAttachedToWindow();
                    Log.i("cmEdit.CMTextView", "checkInitAdaptEdt isWindowAttached:".concat(String.valueOf(isAttachedToWindow)));
                    if (isAttachedToWindow) {
                        Log.i("cmEdit.CMTextView", "checkInitAdaptEdt mIsInitAdapt:" + customTextView.QHy);
                        if (!customTextView.QHy) {
                            customTextView.QHy = true;
                            try {
                                AdaptEditText adaptEditText = new AdaptEditText(customTextView.getContext());
                                if (customTextView.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) customTextView.getParent()).addView(adaptEditText);
                                    adaptEditText.setVisibility(8);
                                    customTextView.setAdaptText(adaptEditText);
                                }
                                AppMethodBeat.o(205555);
                                return;
                            } catch (Throwable th) {
                                Log.e("cmEdit.CMTextView", "initAdapt err:%s", Util.stackTraceToString(th));
                                com.tencent.mm.ui.widget.cedit.api.b.aow(7);
                            }
                        }
                    }
                }
                AppMethodBeat.o(205555);
            }
        });
        AppMethodBeat.o(205713);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(205714);
        super.onDetachedFromWindow();
        if (this.QGu) {
            getViewTreeObserver().removeOnPreDrawListener(this);
            this.QGv = true;
        }
        this.QGB = -1;
        if (this.QHs != null) {
            b bVar = this.QHs;
            bVar.gZR();
            if (bVar.QIs != null) {
                bVar.QIs.onDetached();
            }
            if (bVar.QIt != null) {
                bVar.QIt.onDetached();
            }
            if (bVar.QIX != null) {
                bVar.QIo.removeCallbacks(bVar.QIX);
            }
            if (bVar.QJk != null) {
                bVar.QIo.removeCallbacks(bVar.QJk);
            }
            bVar.QIo.removeCallbacks(bVar.QJp);
            ViewTreeObserver viewTreeObserver = bVar.QIo.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnDrawListener(bVar.QIA);
            }
            bVar.gZQ();
            bVar.hav();
        }
        AppMethodBeat.o(205714);
    }

    public void onScreenStateChanged(int i2) {
        AppMethodBeat.i(205715);
        super.onScreenStateChanged(i2);
        if (this.QHs != null) {
            b bVar = this.QHs;
            switch (i2) {
                case 1:
                    bVar.gZS();
                    AppMethodBeat.o(205715);
                    return;
                case 0:
                    bVar.gZR();
                    break;
            }
        }
        AppMethodBeat.o(205715);
    }

    /* access modifiers changed from: protected */
    public boolean isPaddingOffsetRequired() {
        return (this.QGr == 0.0f && this.QGA == null) ? false : true;
    }

    /* access modifiers changed from: protected */
    public int getLeftPaddingOffset() {
        AppMethodBeat.i(205716);
        int compoundPaddingLeft = (getCompoundPaddingLeft() - getPaddingLeft()) + ((int) Math.min(0.0f, this.QGs - this.QGr));
        AppMethodBeat.o(205716);
        return compoundPaddingLeft;
    }

    /* access modifiers changed from: protected */
    public int getTopPaddingOffset() {
        AppMethodBeat.i(205717);
        int min = (int) Math.min(0.0f, this.QGt - this.QGr);
        AppMethodBeat.o(205717);
        return min;
    }

    /* access modifiers changed from: protected */
    public int getBottomPaddingOffset() {
        AppMethodBeat.i(205718);
        int max = (int) Math.max(0.0f, this.QGt + this.QGr);
        AppMethodBeat.o(205718);
        return max;
    }

    /* access modifiers changed from: protected */
    public int getRightPaddingOffset() {
        AppMethodBeat.i(205719);
        int max = (-(getCompoundPaddingRight() - getPaddingRight())) + ((int) Math.max(0.0f, this.QGs + this.QGr));
        AppMethodBeat.o(205719);
        return max;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        AppMethodBeat.i(205720);
        boolean verifyDrawable = super.verifyDrawable(drawable);
        if (!verifyDrawable && this.QGA != null) {
            for (Drawable drawable2 : this.QGA.QHE) {
                if (drawable == drawable2) {
                    AppMethodBeat.o(205720);
                    return true;
                }
            }
        }
        AppMethodBeat.o(205720);
        return verifyDrawable;
    }

    public void jumpDrawablesToCurrentState() {
        AppMethodBeat.i(205721);
        super.jumpDrawablesToCurrentState();
        if (this.QGA != null) {
            Drawable[] drawableArr = this.QGA.QHE;
            for (Drawable drawable : drawableArr) {
                if (drawable != null) {
                    drawable.jumpToCurrentState();
                }
            }
        }
        AppMethodBeat.o(205721);
    }

    public void invalidateDrawable(Drawable drawable) {
        boolean z = false;
        AppMethodBeat.i(205722);
        if (verifyDrawable(drawable)) {
            Rect bounds = drawable.getBounds();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            b bVar = this.QGA;
            if (bVar != null) {
                if (drawable == bVar.QHE[0]) {
                    int compoundPaddingTop = getCompoundPaddingTop();
                    int compoundPaddingBottom = getCompoundPaddingBottom();
                    scrollX += getPaddingLeft();
                    scrollY += compoundPaddingTop + (((((getBottom() - getTop()) - compoundPaddingBottom) - compoundPaddingTop) - bVar.OWk) / 2);
                    z = true;
                } else if (drawable == bVar.QHE[2]) {
                    int compoundPaddingTop2 = getCompoundPaddingTop();
                    int compoundPaddingBottom2 = getCompoundPaddingBottom();
                    scrollX += ((getRight() - getLeft()) - getPaddingRight()) - bVar.OWh;
                    scrollY += compoundPaddingTop2 + (((((getBottom() - getTop()) - compoundPaddingBottom2) - compoundPaddingTop2) - bVar.OWl) / 2);
                    z = true;
                } else if (drawable == bVar.QHE[1]) {
                    int compoundPaddingLeft = getCompoundPaddingLeft();
                    scrollX += compoundPaddingLeft + (((((getRight() - getLeft()) - getCompoundPaddingRight()) - compoundPaddingLeft) - bVar.OWi) / 2);
                    scrollY += getPaddingTop();
                    z = true;
                } else if (drawable == bVar.QHE[3]) {
                    int compoundPaddingLeft2 = getCompoundPaddingLeft();
                    scrollX += compoundPaddingLeft2 + (((((getRight() - getLeft()) - getCompoundPaddingRight()) - compoundPaddingLeft2) - bVar.OWj) / 2);
                    scrollY += ((getBottom() - getTop()) - getPaddingBottom()) - bVar.OWf;
                    z = true;
                }
            }
            if (z) {
                invalidate(bounds.left + scrollX, bounds.top + scrollY, scrollX + bounds.right, scrollY + bounds.bottom);
            }
        }
        if (!z) {
            super.invalidateDrawable(drawable);
        }
        AppMethodBeat.o(205722);
    }

    public boolean hasOverlappingRendering() {
        AppMethodBeat.i(205723);
        if ((getBackground() == null || getBackground().getCurrent() == null) && this.QGC == null && !hasSelection() && !isHorizontalFadingEdgeEnabled() && this.nYW == 0) {
            AppMethodBeat.o(205723);
            return false;
        }
        AppMethodBeat.o(205723);
        return true;
    }

    public final boolean isTextSelectable() {
        if (this.QHs == null) {
            return false;
        }
        return this.QHs.QIO;
    }

    public void setTextIsSelectable(boolean z) {
        AppMethodBeat.i(205724);
        if (z || this.QHs != null) {
            gZL();
            if (this.QHs.QIO == z) {
                AppMethodBeat.o(205724);
                return;
            }
            this.QHs.QIO = z;
            setFocusableInTouchMode(z);
            if (Build.VERSION.SDK_INT >= 26) {
                setFocusable(16);
            } else {
                setFocusable(z);
            }
            setClickable(z);
            setLongClickable(z);
            setMovementMethod(z ? com.tencent.mm.ui.widget.cedit.b.a.haX() : null);
            setText(this.mText, z ? TextView.BufferType.SPANNABLE : TextView.BufferType.NORMAL);
            this.QHs.gZP();
            AppMethodBeat.o(205724);
            return;
        }
        AppMethodBeat.o(205724);
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState;
        AppMethodBeat.i(205725);
        if (this.OSP) {
            onCreateDrawableState = super.onCreateDrawableState(i2);
        } else {
            onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
            mergeDrawableStates(onCreateDrawableState, QGl);
        }
        if (isTextSelectable()) {
            int length = onCreateDrawableState.length;
            for (int i3 = 0; i3 < length; i3++) {
                if (onCreateDrawableState[i3] == 16842919) {
                    int[] iArr = new int[(length - 1)];
                    System.arraycopy(onCreateDrawableState, 0, iArr, 0, i3);
                    System.arraycopy(onCreateDrawableState, i3 + 1, iArr, i3, (length - i3) - 1);
                    AppMethodBeat.o(205725);
                    return iArr;
                }
            }
        }
        AppMethodBeat.o(205725);
        return onCreateDrawableState;
    }

    private Path getUpdatedHighlightPath() {
        boolean z = true;
        AppMethodBeat.i(205726);
        Path path = null;
        Paint paint = this.QHg;
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        if (this.QGG != null && ((isFocused() || isPressed()) && selectionStart >= 0)) {
            if (selectionStart != selectionEnd) {
                if (this.QHh) {
                    if (this.QHf == null) {
                        this.QHf = new Path();
                    }
                    this.QHf.reset();
                    this.OVt.getSelectionPath(selectionStart, selectionEnd, this.QHf);
                    this.QHh = false;
                }
                paint.setColor(this.oEF);
                paint.setStyle(Paint.Style.FILL);
                path = this.QHf;
            } else if (this.QHs != null) {
                b bVar = this.QHs;
                if (!bVar.isCursorVisible() || (!bVar.QIK && (SystemClock.uptimeMillis() - bVar.QIJ) % 1000 >= 500)) {
                    z = false;
                }
                if (z) {
                    if (this.QHh) {
                        if (this.QHf == null) {
                            this.QHf = new Path();
                        }
                        this.QHf.reset();
                        this.OVt.getCursorPath(selectionStart, this.QHf, this.mText);
                        this.QHs.hah();
                        this.QHh = false;
                    }
                    paint.setColor(this.OVm);
                    paint.setStyle(Paint.Style.STROKE);
                    path = this.QHf;
                }
            }
        }
        AppMethodBeat.o(205726);
        return path;
    }

    public int getHorizontalOffsetForDrawables() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f2;
        float f3;
        boolean z;
        boolean z2;
        InputMethodManager inputMethodManager;
        AppMethodBeat.i(205727);
        super.onDraw(canvas);
        int compoundPaddingLeft = getCompoundPaddingLeft();
        int compoundPaddingTop = getCompoundPaddingTop();
        int compoundPaddingRight = getCompoundPaddingRight();
        int compoundPaddingBottom = getCompoundPaddingBottom();
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int right = getRight();
        int left = getLeft();
        int bottom = getBottom();
        int top = getTop();
        int horizontalOffsetForDrawables = getHorizontalOffsetForDrawables();
        b bVar = this.QGA;
        if (bVar != null) {
            int i2 = ((bottom - top) - compoundPaddingBottom) - compoundPaddingTop;
            int i3 = ((right - left) - compoundPaddingRight) - compoundPaddingLeft;
            if (bVar.QHE[0] != null) {
                canvas.save();
                canvas.translate((float) (horizontalOffsetForDrawables + getPaddingLeft() + scrollX), (float) (scrollY + compoundPaddingTop + ((i2 - bVar.OWk) / 2)));
                bVar.QHE[0].draw(canvas);
                canvas.restore();
            }
            if (bVar.QHE[2] != null) {
                canvas.save();
                canvas.translate((float) (((((scrollX + right) - left) - getPaddingRight()) - bVar.OWh) + 0), (float) (((i2 - bVar.OWl) / 2) + scrollY + compoundPaddingTop));
                bVar.QHE[2].draw(canvas);
                canvas.restore();
            }
            if (bVar.QHE[1] != null) {
                canvas.save();
                canvas.translate((float) (scrollX + compoundPaddingLeft + ((i3 - bVar.OWi) / 2)), (float) (getPaddingTop() + scrollY));
                bVar.QHE[1].draw(canvas);
                canvas.restore();
            }
            if (bVar.QHE[3] != null) {
                canvas.save();
                canvas.translate((float) (((i3 - bVar.OWj) / 2) + scrollX + compoundPaddingLeft), (float) ((((scrollY + bottom) - top) - getPaddingBottom()) - bVar.OWf));
                bVar.QHE[3].draw(canvas);
                canvas.restore();
            }
        }
        int i4 = this.OVm;
        if (this.OVt == null) {
            gLs();
        }
        Layout layout = this.OVt;
        if (this.QGE != null && this.mText.length() == 0) {
            if (this.QGn != null) {
                i4 = this.QGp;
            }
            layout = this.QGF;
        }
        this.ayn.setColor(i4);
        this.ayn.drawableState = getDrawableState();
        canvas.save();
        int extendedPaddingTop = getExtendedPaddingTop();
        int extendedPaddingBottom = getExtendedPaddingBottom();
        int height = this.OVt.getHeight() - (((getBottom() - getTop()) - compoundPaddingBottom) - compoundPaddingTop);
        float f4 = (float) (compoundPaddingLeft + scrollX);
        if (scrollY == 0) {
            f2 = 0.0f;
        } else {
            f2 = (float) (extendedPaddingTop + scrollY);
        }
        float compoundPaddingRight2 = (float) (((right - left) - getCompoundPaddingRight()) + scrollX);
        int i5 = (bottom - top) + scrollY;
        if (scrollY == height) {
            extendedPaddingBottom = 0;
        }
        float f5 = (float) (i5 - extendedPaddingBottom);
        if (this.QGr != 0.0f) {
            f4 += Math.min(0.0f, this.QGs - this.QGr);
            f3 = Math.max(0.0f, this.QGs + this.QGr) + compoundPaddingRight2;
            f2 += Math.min(0.0f, this.QGt - this.QGr);
            f5 = Math.max(0.0f, this.QGt + this.QGr) + f5;
        } else {
            f3 = compoundPaddingRight2;
        }
        canvas.clipRect(f4, f2, f3, f5);
        int i6 = 0;
        int i7 = 0;
        if ((this.Ku & 112) != 48) {
            i6 = CW(false);
            i7 = CW(true);
        }
        canvas.translate((float) compoundPaddingLeft, (float) (extendedPaddingTop + i6));
        int i8 = i7 - i6;
        Path updatedHighlightPath = getUpdatedHighlightPath();
        if (this.QHs != null) {
            b bVar2 = this.QHs;
            Paint paint = this.QHg;
            int selectionStart = bVar2.QIo.getSelectionStart();
            int selectionEnd = bVar2.QIo.getSelectionEnd();
            b.h hVar = bVar2.QID;
            if (hVar != null && hVar.QIp == 0 && (inputMethodManager = bVar2.getInputMethodManager()) != null && inputMethodManager.isActive(bVar2.QIo) && (hVar.mContentChanged || hVar.QKo)) {
                bVar2.hae();
            }
            if (bVar2.QIB != null) {
                b.C2142b bVar3 = bVar2.QIB;
                Layout layout2 = b.this.QIo.getLayout();
                if (layout2 == null) {
                    z = false;
                } else {
                    int length = b.this.QIo.getText().length();
                    int min = Math.min(length, bVar3.avh);
                    int min2 = Math.min(length, bVar3.Pc);
                    bVar3.xT.reset();
                    layout2.getSelectionPath(min, min2, bVar3.xT);
                    z = true;
                }
                if (z) {
                    long uptimeMillis = SystemClock.uptimeMillis() - bVar3.QJA;
                    if (uptimeMillis > 400) {
                        z2 = false;
                    } else {
                        bVar3.mPaint.setColor((((int) ((1.0f - (((float) uptimeMillis) / 400.0f)) * ((float) Color.alpha(b.this.QIo.oEF)))) << 24) + (b.this.QIo.oEF & 16777215));
                        z2 = true;
                    }
                    if (z2) {
                        if (i8 != 0) {
                            canvas.translate(0.0f, (float) i8);
                        }
                        canvas.drawPath(bVar3.xT, bVar3.mPaint);
                        if (i8 != 0) {
                            canvas.translate(0.0f, (float) (-i8));
                        }
                        bVar3.Da(true);
                    }
                }
                bVar3.stopAnimation();
                bVar3.Da(false);
            }
            if (!(updatedHighlightPath == null || selectionStart != selectionEnd || bVar2.QIY == null)) {
                boolean z3 = i8 != 0;
                if (z3) {
                    canvas.translate(0.0f, (float) i8);
                }
                if (bVar2.QIY != null) {
                    bVar2.QIY.draw(canvas);
                }
                if (z3) {
                    canvas.translate(0.0f, (float) (-i8));
                }
                updatedHighlightPath = null;
            }
            layout.draw(canvas, updatedHighlightPath, paint, i8);
        } else {
            layout.draw(canvas, updatedHighlightPath, this.QHg, i8);
        }
        canvas.restore();
        AppMethodBeat.o(205727);
    }

    public void getFocusedRect(Rect rect) {
        AppMethodBeat.i(205728);
        if (this.OVt == null) {
            super.getFocusedRect(rect);
            AppMethodBeat.o(205728);
            return;
        }
        int selectionEnd = getSelectionEnd();
        if (selectionEnd < 0) {
            super.getFocusedRect(rect);
            AppMethodBeat.o(205728);
            return;
        }
        int selectionStart = getSelectionStart();
        if (selectionStart < 0 || selectionStart >= selectionEnd) {
            int lineForOffset = this.OVt.getLineForOffset(selectionEnd);
            rect.top = this.OVt.getLineTop(lineForOffset);
            rect.bottom = this.OVt.getLineBottom(lineForOffset);
            rect.left = ((int) this.OVt.getPrimaryHorizontal(selectionEnd)) - 2;
            rect.right = rect.left + 4;
        } else {
            int lineForOffset2 = this.OVt.getLineForOffset(selectionStart);
            int lineForOffset3 = this.OVt.getLineForOffset(selectionEnd);
            rect.top = this.OVt.getLineTop(lineForOffset2);
            rect.bottom = this.OVt.getLineBottom(lineForOffset3);
            if (lineForOffset2 == lineForOffset3) {
                rect.left = (int) this.OVt.getPrimaryHorizontal(selectionStart);
                rect.right = (int) this.OVt.getPrimaryHorizontal(selectionEnd);
            } else {
                if (this.QHh) {
                    if (this.QHf == null) {
                        this.QHf = new Path();
                    }
                    this.QHf.reset();
                    this.OVt.getSelectionPath(selectionStart, selectionEnd, this.QHf);
                    this.QHh = false;
                }
                synchronized (alw) {
                    try {
                        this.QHf.computeBounds(alw, true);
                        rect.left = ((int) alw.left) - 1;
                        rect.right = ((int) alw.right) + 1;
                    } catch (Throwable th) {
                        AppMethodBeat.o(205728);
                        throw th;
                    }
                }
            }
        }
        int compoundPaddingLeft = getCompoundPaddingLeft();
        int extendedPaddingTop = getExtendedPaddingTop();
        if ((this.Ku & 112) != 48) {
            extendedPaddingTop += CW(false);
        }
        rect.offset(compoundPaddingLeft, extendedPaddingTop);
        rect.bottom = getExtendedPaddingBottom() + rect.bottom;
        AppMethodBeat.o(205728);
    }

    public int getLineCount() {
        AppMethodBeat.i(205729);
        if (this.OVt != null) {
            int lineCount = this.OVt.getLineCount();
            AppMethodBeat.o(205729);
            return lineCount;
        }
        AppMethodBeat.o(205729);
        return 0;
    }

    public int getBaseline() {
        AppMethodBeat.i(205730);
        if (this.OVt == null) {
            int baseline = super.getBaseline();
            AppMethodBeat.o(205730);
            return baseline;
        }
        int baselineOffset = getBaselineOffset() + this.OVt.getLineBaseline(0);
        AppMethodBeat.o(205730);
        return baselineOffset;
    }

    /* access modifiers changed from: package-private */
    public int getBaselineOffset() {
        AppMethodBeat.i(205731);
        int i2 = 0;
        if ((this.Ku & 112) != 48) {
            i2 = CW(true);
        }
        int extendedPaddingTop = i2 + getExtendedPaddingTop();
        AppMethodBeat.o(205731);
        return extendedPaddingTop;
    }

    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i2) {
        AppMethodBeat.i(205732);
        if (this.QGC != null && this.QGS) {
            int offsetForPosition = getOffsetForPosition(motionEvent.getX(i2), motionEvent.getY(i2));
            if (((ClickableSpan[]) this.QGC.getSpans(offsetForPosition, offsetForPosition, ClickableSpan.class)).length > 0 && Build.VERSION.SDK_INT >= 24) {
                PointerIcon systemIcon = PointerIcon.getSystemIcon(getContext(), 1002);
                AppMethodBeat.o(205732);
                return systemIcon;
            }
        }
        if ((isTextSelectable() || gZB()) && Build.VERSION.SDK_INT >= 24) {
            PointerIcon systemIcon2 = PointerIcon.getSystemIcon(getContext(), 1008);
            AppMethodBeat.o(205732);
            return systemIcon2;
        }
        PointerIcon onResolvePointerIcon = super.onResolvePointerIcon(motionEvent, i2);
        AppMethodBeat.o(205732);
        return onResolvePointerIcon;
    }

    public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
        boolean z = false;
        AppMethodBeat.i(205733);
        if (i2 == 4) {
            if (this.QHs != null && !this.QHs.ham()) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    z = true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        gZE();
                        z = true;
                    }
                }
            }
            if (z) {
                AppMethodBeat.o(205733);
                return true;
            }
        }
        boolean onKeyPreIme = super.onKeyPreIme(i2, keyEvent);
        AppMethodBeat.o(205733);
        return onKeyPreIme;
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(205734);
        if (a(i2, keyEvent, (KeyEvent) null) == 0) {
            boolean onKeyDown = super.onKeyDown(i2, keyEvent);
            AppMethodBeat.o(205734);
            return onKeyDown;
        }
        AppMethodBeat.o(205734);
        return true;
    }

    public boolean onKeyMultiple(int i2, int i3, KeyEvent keyEvent) {
        AppMethodBeat.i(205735);
        KeyEvent changeAction = KeyEvent.changeAction(keyEvent, 0);
        int a2 = a(i2, changeAction, keyEvent);
        if (a2 == 0) {
            boolean onKeyMultiple = super.onKeyMultiple(i2, i3, keyEvent);
            AppMethodBeat.o(205735);
            return onKeyMultiple;
        } else if (a2 == -1) {
            AppMethodBeat.o(205735);
            return true;
        } else {
            int i4 = i3 - 1;
            KeyEvent changeAction2 = KeyEvent.changeAction(keyEvent, 1);
            if (a2 == 1) {
                this.QHs.QIH.onKeyUp(this, (Editable) this.mText, i2, changeAction2);
                while (true) {
                    i4--;
                    if (i4 <= 0) {
                        break;
                    }
                    this.QHs.QIH.onKeyDown(this, (Editable) this.mText, i2, changeAction);
                    this.QHs.QIH.onKeyUp(this, (Editable) this.mText, i2, changeAction2);
                }
            } else if (a2 == 2) {
                int i5 = i4;
                while (true) {
                    i5--;
                    if (i5 <= 0) {
                        break;
                    }
                    this.QGG.a(this, this.QGC, i2, changeAction);
                }
            }
            AppMethodBeat.o(205735);
            return true;
        }
    }

    private boolean gZu() {
        int i2;
        AppMethodBeat.i(205736);
        if (getKeyListener() == null) {
            AppMethodBeat.o(205736);
            return false;
        } else if (this.OSP) {
            AppMethodBeat.o(205736);
            return true;
        } else if (this.QHs != null && (this.QHs.Clf & 15) == 1 && ((i2 = this.QHs.Clf & 4080) == 32 || i2 == 48)) {
            AppMethodBeat.o(205736);
            return true;
        } else {
            AppMethodBeat.o(205736);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:127:0x01e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(int r7, android.view.KeyEvent r8, android.view.KeyEvent r9) {
        /*
        // Method dump skipped, instructions count: 578
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.widget.cedit.edit.CustomTextView.a(int, android.view.KeyEvent, android.view.KeyEvent):int");
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        InputMethodManager inputMethodManager;
        AppMethodBeat.i(205738);
        if (!isEnabled()) {
            boolean onKeyUp = super.onKeyUp(i2, keyEvent);
            AppMethodBeat.o(205738);
            return onKeyUp;
        }
        if (!KeyEvent.isModifierKey(i2)) {
            this.QGz = false;
        }
        switch (i2) {
            case 23:
                if (keyEvent.hasNoModifiers() && !hasOnClickListeners() && this.QGG != null && (this.mText instanceof Editable) && this.OVt != null && onCheckIsTextEditor()) {
                    InputMethodManager inputMethodManager2 = getInputMethodManager();
                    a(inputMethodManager2);
                    if (inputMethodManager2 != null && getShowSoftInputOnFocus()) {
                        inputMethodManager2.showSoftInput(this, 0);
                    }
                }
                boolean onKeyUp2 = super.onKeyUp(i2, keyEvent);
                AppMethodBeat.o(205738);
                return onKeyUp2;
            case 66:
            case 160:
                if (keyEvent.hasNoModifiers()) {
                    if (!(this.QHs == null || this.QHs.QIC == null || this.QHs.QIC.QKi == null || !this.QHs.QIC.QKj)) {
                        this.QHs.QIC.QKj = false;
                        if (this.QHs.QIC.QKi.a(this, 0)) {
                            AppMethodBeat.o(205738);
                            return true;
                        }
                    }
                    if (((keyEvent.getFlags() & 16) != 0 || gZu()) && !hasOnClickListeners()) {
                        View focusSearch = focusSearch(130);
                        if (focusSearch != null) {
                            if (!focusSearch.requestFocus(130)) {
                                IllegalStateException illegalStateException = new IllegalStateException("focus search returned a view that wasn't able to take focus!");
                                AppMethodBeat.o(205738);
                                throw illegalStateException;
                            }
                            super.onKeyUp(i2, keyEvent);
                            AppMethodBeat.o(205738);
                            return true;
                        } else if (!((keyEvent.getFlags() & 16) == 0 || (inputMethodManager = getInputMethodManager()) == null || !inputMethodManager.isActive(this))) {
                            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
                        }
                    }
                    boolean onKeyUp3 = super.onKeyUp(i2, keyEvent);
                    AppMethodBeat.o(205738);
                    return onKeyUp3;
                }
                break;
        }
        if (this.QHs == null || this.QHs.QIH == null || !this.QHs.QIH.onKeyUp(this, (Editable) this.mText, i2, keyEvent)) {
            boolean onKeyUp4 = super.onKeyUp(i2, keyEvent);
            AppMethodBeat.o(205738);
            return onKeyUp4;
        }
        AppMethodBeat.o(205738);
        return true;
    }

    public boolean onCheckIsTextEditor() {
        return (this.QHs == null || this.QHs.Clf == 0) ? false : true;
    }

    public View focusSearch(int i2) {
        AppMethodBeat.i(205739);
        try {
            View focusSearch = super.focusSearch(i2);
            AppMethodBeat.o(205739);
            return focusSearch;
        } catch (Throwable th) {
            Log.e("cmEdit.CMTextView", "focusSearch err", th);
            AppMethodBeat.o(205739);
            return null;
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        AppMethodBeat.i(205740);
        if (onCheckIsTextEditor() && isEnabled()) {
            b bVar = this.QHs;
            if (bVar.QID == null) {
                bVar.QID = new b.h();
            }
            editorInfo.inputType = getInputType();
            if (this.QHs.QIC != null) {
                editorInfo.imeOptions = this.QHs.QIC.imeOptions;
                editorInfo.privateImeOptions = this.QHs.QIC.privateImeOptions;
                editorInfo.actionLabel = this.QHs.QIC.QKh;
                editorInfo.actionId = this.QHs.QIC.imeActionId;
                editorInfo.extras = this.QHs.QIC.extras;
                if (Build.VERSION.SDK_INT >= 24) {
                    editorInfo.hintLocales = this.QHs.QIC.QKk;
                }
            } else {
                editorInfo.imeOptions = 0;
                if (Build.VERSION.SDK_INT >= 24) {
                    editorInfo.hintLocales = null;
                }
            }
            if ((editorInfo.imeOptions & 255) == 0) {
                if ((editorInfo.imeOptions & 134217728) != 0) {
                    editorInfo.imeOptions |= 5;
                } else {
                    editorInfo.imeOptions |= 6;
                }
                if (!gZu()) {
                    editorInfo.imeOptions |= 1073741824;
                }
            }
            if (aox(editorInfo.inputType)) {
                editorInfo.imeOptions |= 1073741824;
            }
            editorInfo.hintText = this.QGE;
            if (this.mText instanceof Editable) {
                a aVar = new a(this);
                editorInfo.initialSelStart = getSelectionStart();
                editorInfo.initialSelEnd = getSelectionEnd();
                editorInfo.initialCapsMode = aVar.getCursorCapsMode(getInputType());
                AppMethodBeat.o(205740);
                return aVar;
            }
        }
        AppMethodBeat.o(205740);
        return null;
    }

    public final boolean extractText(ExtractedTextRequest extractedTextRequest, ExtractedText extractedText) {
        AppMethodBeat.i(205741);
        gZL();
        boolean a2 = this.QHs.a(extractedTextRequest, -1, -1, -1, extractedText);
        AppMethodBeat.o(205741);
        return a2;
    }

    public void setExtractedText(ExtractedText extractedText) {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(205742);
        Editable editableText = getEditableText();
        if (extractedText.text != null) {
            if (editableText == null) {
                setText(extractedText.text, TextView.BufferType.EDITABLE);
            } else {
                int length = editableText.length();
                if (extractedText.partialStartOffset >= 0) {
                    length = editableText.length();
                    int i4 = extractedText.partialStartOffset;
                    if (i4 > length) {
                        i4 = length;
                    }
                    int i5 = extractedText.partialEndOffset;
                    if (i5 > length) {
                        i2 = i4;
                    } else {
                        length = i5;
                        i2 = i4;
                    }
                } else {
                    i2 = 0;
                }
                Object[] spans = editableText.getSpans(i2, length, ParcelableSpan.class);
                int length2 = spans.length;
                while (length2 > 0) {
                    length2--;
                    editableText.removeSpan(spans[length2]);
                }
                if (!TextUtils.equals(editableText.subSequence(i2, length), extractedText.text)) {
                    editableText.replace(i2, length, extractedText.text);
                } else if (extractedText.text instanceof Spanned) {
                    TextUtils.copySpansFrom((Spanned) extractedText.text, 0, length - i2, Object.class, editableText, i2);
                }
            }
        }
        Spannable spannable = (Spannable) getText();
        int length3 = spannable.length();
        int i6 = extractedText.selectionStart;
        if (i6 < 0) {
            i6 = 0;
        } else if (i6 > length3) {
            i6 = length3;
        }
        int i7 = extractedText.selectionEnd;
        if (i7 >= 0) {
            if (i7 > length3) {
                i3 = length3;
            } else {
                i3 = i7;
            }
        }
        Selection.setSelection(spannable, i6, i3);
        if ((extractedText.flags & 2) != 0) {
            com.tencent.mm.ui.widget.cedit.util.d.a(this, spannable);
        } else {
            com.tencent.mm.ui.widget.cedit.util.d.b(this, spannable);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            setHintInternal(extractedText.hint);
        }
        AppMethodBeat.o(205742);
    }

    public void setExtracting(ExtractedTextRequest extractedTextRequest) {
        AppMethodBeat.i(205743);
        if (this.QHs.QID != null) {
            this.QHs.QID.QKl = extractedTextRequest;
        }
        this.QHs.gZQ();
        gZE();
        if (this.QHs.QIt != null) {
            this.QHs.QIt.haN();
        }
        AppMethodBeat.o(205743);
    }

    public final void beginBatchEdit() {
        AppMethodBeat.i(205744);
        if (this.QHs != null) {
            this.QHs.beginBatchEdit();
        }
        AppMethodBeat.o(205744);
    }

    public final void endBatchEdit() {
        AppMethodBeat.i(205745);
        if (this.QHs != null) {
            this.QHs.endBatchEdit();
        }
        AppMethodBeat.o(205745);
    }

    private void gLr() {
        AppMethodBeat.i(205746);
        if ((this.OVt instanceof BoringLayout) && this.OVE == null) {
            this.OVE = (BoringLayout) this.OVt;
        }
        if ((this.QGF instanceof BoringLayout) && this.QHb == null) {
            this.QHb = (BoringLayout) this.QGF;
        }
        this.QHa = null;
        this.QGZ = null;
        if (this.QHs != null) {
            this.QHs.gZP();
        }
        AppMethodBeat.o(205746);
    }

    private void gLs() {
        int i2;
        AppMethodBeat.i(205747);
        int right = ((getRight() - getLeft()) - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        if (right <= 0) {
            right = 0;
        }
        if (this.QGQ) {
            i2 = 1048576;
        } else {
            i2 = right;
        }
        BoringLayout.Metrics metrics = OVU;
        a(i2, right, metrics, metrics, right, false);
        AppMethodBeat.o(205747);
    }

    private Layout.Alignment getLayoutAlignment() {
        AppMethodBeat.i(205748);
        Layout.Alignment alignment = null;
        switch (getTextAlignment()) {
            case 1:
                switch (this.Ku & 8388615) {
                    case 1:
                        alignment = Layout.Alignment.ALIGN_CENTER;
                        break;
                    case 3:
                        Log.i("cmEdit.CMTextView", "getTextAlignment() Gravity.LEFT");
                        break;
                    case 5:
                        Log.i("cmEdit.CMTextView", "getTextAlignment() Gravity.RIGHT");
                        break;
                    case 8388611:
                        alignment = Layout.Alignment.ALIGN_NORMAL;
                        break;
                    case 8388613:
                        alignment = Layout.Alignment.ALIGN_OPPOSITE;
                        break;
                    default:
                        alignment = Layout.Alignment.ALIGN_NORMAL;
                        break;
                }
            case 2:
                alignment = Layout.Alignment.ALIGN_NORMAL;
                break;
            case 3:
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
                break;
            case 4:
                alignment = Layout.Alignment.ALIGN_CENTER;
                break;
            case 5:
                Log.i("cmEdit.CMTextView", "getTextAlignment() TEXT_ALIGNMENT_VIEW_START");
                break;
            case 6:
                Log.i("cmEdit.CMTextView", "getTextAlignment() TEXT_ALIGNMENT_VIEW_END");
                break;
            default:
                alignment = Layout.Alignment.ALIGN_NORMAL;
                break;
        }
        AppMethodBeat.o(205748);
        return alignment;
    }

    private void a(int i2, int i3, BoringLayout.Metrics metrics, BoringLayout.Metrics metrics2, int i4, boolean z) {
        int i5;
        int i6;
        boolean z2;
        int i7;
        BoringLayout.Metrics metrics3;
        AppMethodBeat.i(205749);
        this.QGU = this.OVw;
        this.QGV = this.OVx;
        this.QHh = true;
        if (i2 < 0) {
            i5 = 0;
        } else {
            i5 = i2;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        Layout.Alignment layoutAlignment = getLayoutAlignment();
        boolean z3 = this.OSP && this.OVt != null && (layoutAlignment == Layout.Alignment.ALIGN_NORMAL || layoutAlignment == Layout.Alignment.ALIGN_OPPOSITE);
        if (z3) {
            i6 = this.OVt.getParagraphDirection(0);
        } else {
            i6 = 0;
        }
        boolean z4 = this.OVp != null && getKeyListener() == null;
        TextUtils.TruncateAt truncateAt = this.OVp;
        if (this.Om == null) {
            this.Om = getTextDirectionHeuristic();
        }
        this.OVt = a(i5, metrics, i4, layoutAlignment, z4, truncateAt, truncateAt == this.OVp);
        if (this.OVp != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.QGF = null;
        if (this.QGE != null) {
            if (z2) {
                i7 = i5;
            } else {
                i7 = i3;
            }
            if (metrics2 == OVU) {
                metrics3 = BoringLayout.isBoring(this.QGE, this.ayn, this.QHa);
                if (metrics3 != null) {
                    this.QHa = metrics3;
                }
            } else {
                metrics3 = metrics2;
            }
            if (metrics3 != null) {
                if (metrics3.width <= i7 && (!z2 || metrics3.width <= i4)) {
                    if (this.QHb != null) {
                        this.QGF = this.QHb.replaceOrMake(this.QGE, this.ayn, i7, layoutAlignment, this.OVu, this.OVv, metrics3, this.OVD);
                    } else {
                        this.QGF = BoringLayout.make(this.QGE, this.ayn, i7, layoutAlignment, this.OVu, this.OVv, metrics3, this.OVD);
                    }
                    this.QHb = (BoringLayout) this.QGF;
                } else if (z2 && metrics3.width <= i7) {
                    if (this.QHb != null) {
                        this.QGF = this.QHb.replaceOrMake(this.QGE, this.ayn, i7, layoutAlignment, this.OVu, this.OVv, metrics3, this.OVD, this.OVp, i4);
                    } else {
                        this.QGF = BoringLayout.make(this.QGE, this.ayn, i7, layoutAlignment, this.OVu, this.OVv, metrics3, this.OVD, this.OVp, i4);
                    }
                }
            }
            if (this.QGF == null) {
                this.QGF = new StaticLayout(this.QGE, 0, this.QGE.length(), this.ayn, i7, layoutAlignment, this.OVu, this.OVv, this.OVD, z2 ? truncateAt : null, z2 ? i4 : 0);
            }
        }
        if (z || (z3 && i6 != this.OVt.getParagraphDirection(0))) {
            gZt();
        }
        if (this.QHs != null) {
            this.QHs.gZP();
        }
        AppMethodBeat.o(205749);
    }

    private boolean gZv() {
        AppMethodBeat.i(205750);
        if (isTextSelectable() || this.QGC != null) {
            AppMethodBeat.o(205750);
            return true;
        }
        AppMethodBeat.o(205750);
        return false;
    }

    private Layout a(int i2, BoringLayout.Metrics metrics, int i3, Layout.Alignment alignment, boolean z, TextUtils.TruncateAt truncateAt, boolean z2) {
        BoringLayout.Metrics metrics2;
        BoringLayout make;
        TextUtils.TruncateAt truncateAt2;
        AppMethodBeat.i(205751);
        Layout layout = null;
        if (gZv()) {
            CharSequence charSequence = this.mText;
            CharSequence charSequence2 = this.OVq;
            TextPaint textPaint = this.ayn;
            float f2 = this.OVu;
            float f3 = this.OVv;
            boolean z3 = this.OVD;
            if (getKeyListener() == null) {
                truncateAt2 = truncateAt;
            } else {
                truncateAt2 = null;
            }
            layout = new DynamicLayout(charSequence, charSequence2, textPaint, i2, alignment, f2, f3, z3, truncateAt2, i3);
        } else {
            if (metrics == OVU) {
                metrics2 = BoringLayout.isBoring(this.OVq, this.ayn, this.QGZ);
                if (metrics2 != null) {
                    this.QGZ = metrics2;
                }
            } else {
                metrics2 = metrics;
            }
            if (metrics2 != null) {
                if (metrics2.width <= i2 && (truncateAt == null || metrics2.width <= i3)) {
                    if (!z2 || this.OVE == null) {
                        make = BoringLayout.make(this.OVq, this.ayn, i2, alignment, this.OVu, this.OVv, metrics2, this.OVD);
                    } else {
                        make = this.OVE.replaceOrMake(this.OVq, this.ayn, i2, alignment, this.OVu, this.OVv, metrics2, this.OVD);
                    }
                    if (z2) {
                        this.OVE = make;
                        layout = make;
                    } else {
                        layout = make;
                    }
                } else if (z && metrics2.width <= i2) {
                    layout = (!z2 || this.OVE == null) ? BoringLayout.make(this.OVq, this.ayn, i2, alignment, this.OVu, this.OVv, metrics2, this.OVD, truncateAt, i3) : this.OVE.replaceOrMake(this.OVq, this.ayn, i2, alignment, this.OVu, this.OVv, metrics2, this.OVD, truncateAt, i3);
                }
            }
        }
        if (layout == null) {
            layout = new StaticLayout(this.OVq, 0, this.OVq.length(), this.ayn, i2, alignment, this.OVu, this.OVv, this.OVD, z ? truncateAt : null, z ? i3 : 0);
        }
        AppMethodBeat.o(205751);
        return layout;
    }

    private static int b(Layout layout) {
        AppMethodBeat.i(205752);
        int lineCount = layout.getLineCount();
        CharSequence text = layout.getText();
        float f2 = 0.0f;
        for (int i2 = 0; i2 < lineCount - 1; i2++) {
            if (text.charAt(layout.getLineEnd(i2) - 1) != '\n') {
                AppMethodBeat.o(205752);
                return -1;
            }
        }
        for (int i3 = 0; i3 < lineCount; i3++) {
            f2 = Math.max(f2, layout.getLineWidth(i3));
        }
        int ceil = (int) Math.ceil((double) f2);
        AppMethodBeat.o(205752);
        return ceil;
    }

    public void setIncludeFontPadding(boolean z) {
        AppMethodBeat.i(205753);
        if (this.OVD != z) {
            this.OVD = z;
            if (this.OVt != null) {
                gLr();
                requestLayout();
                invalidate();
            }
        }
        AppMethodBeat.o(205753);
    }

    public boolean getIncludeFontPadding() {
        return this.OVD;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r13, int r14) {
        /*
        // Method dump skipped, instructions count: 527
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.widget.cedit.edit.CustomTextView.onMeasure(int, int):void");
    }

    private int getDesiredHeight() {
        boolean z = true;
        AppMethodBeat.i(205755);
        int a2 = a(this.OVt, true);
        Layout layout = this.QGF;
        if (this.OVp == null) {
            z = false;
        }
        int max = Math.max(a2, a(layout, z));
        AppMethodBeat.o(205755);
        return max;
    }

    private int a(Layout layout, boolean z) {
        int i2;
        AppMethodBeat.i(205756);
        if (layout == null) {
            AppMethodBeat.o(205756);
            return 0;
        }
        int height = layout.getHeight();
        b bVar = this.QGA;
        if (bVar != null) {
            height = Math.max(Math.max(height, bVar.OWk), bVar.OWl);
        }
        int lineCount = layout.getLineCount();
        int compoundPaddingBottom = getCompoundPaddingBottom() + getCompoundPaddingTop();
        int i3 = height + compoundPaddingBottom;
        if (this.OVx != 1) {
            i3 = Math.min(i3, this.OVw);
            i2 = lineCount;
        } else if (!z || lineCount <= this.OVw || (!(layout instanceof DynamicLayout) && !(layout instanceof BoringLayout))) {
            i2 = lineCount;
        } else {
            int lineTop = layout.getLineTop(this.OVw);
            if (bVar != null) {
                lineTop = Math.max(Math.max(lineTop, bVar.OWk), bVar.OWl);
            }
            int i4 = lineTop + compoundPaddingBottom;
            i2 = this.OVw;
            i3 = i4;
        }
        if (this.OVz != 1) {
            i3 = Math.max(i3, this.OVy);
        } else if (i2 < this.OVy) {
            i3 += (this.OVy - i2) * getLineHeight();
        }
        int max = Math.max(i3, getSuggestedMinimumHeight());
        AppMethodBeat.o(205756);
        return max;
    }

    private void gZw() {
        boolean z = true;
        AppMethodBeat.i(205757);
        boolean z2 = false;
        if (this.OVt != null) {
            if (getLayoutParams().width == -2) {
                invalidate();
                z2 = true;
            }
            if (getLayoutParams().height == -2) {
                if (getDesiredHeight() == getHeight()) {
                    z = z2;
                }
                z2 = z;
            } else if (getLayoutParams().height == -1 && this.OVC >= 0 && getDesiredHeight() != this.OVC) {
                z2 = true;
            }
        }
        if (z2) {
            requestLayout();
        }
        AppMethodBeat.o(205757);
    }

    private void IR() {
        int width;
        AppMethodBeat.i(205758);
        if ((getLayoutParams().width != -2 || (this.QGW == this.QGX && this.mMaxWidth == this.mMinWidth)) && ((this.QGE == null || this.QGF != null) && ((getRight() - getLeft()) - getCompoundPaddingLeft()) - getCompoundPaddingRight() > 0)) {
            int height = this.OVt.getHeight();
            int width2 = this.OVt.getWidth();
            if (this.QGF == null) {
                width = 0;
            } else {
                width = this.QGF.getWidth();
            }
            BoringLayout.Metrics metrics = OVU;
            a(width2, width, metrics, metrics, ((getRight() - getLeft()) - getCompoundPaddingLeft()) - getCompoundPaddingRight(), false);
            if (this.OVp != TextUtils.TruncateAt.MARQUEE) {
                if (getLayoutParams().height != -2 && getLayoutParams().height != -1) {
                    invalidate();
                    AppMethodBeat.o(205758);
                    return;
                } else if (this.OVt.getHeight() == height && (this.QGF == null || this.QGF.getHeight() == height)) {
                    invalidate();
                    AppMethodBeat.o(205758);
                    return;
                }
            }
            requestLayout();
            invalidate();
            AppMethodBeat.o(205758);
            return;
        }
        gLr();
        requestLayout();
        invalidate();
        AppMethodBeat.o(205758);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(205759);
        super.onLayout(z, i2, i3, i4, i5);
        if (this.QGY >= 0) {
            int i6 = this.QGY;
            this.QGY = -1;
            bringPointIntoView(Math.min(i6, this.mText.length()));
        }
        AppMethodBeat.o(205759);
    }

    private boolean gZx() {
        AppMethodBeat.i(205760);
        if (!TextUtils.isEmpty(this.mText) || TextUtils.isEmpty(this.QGE)) {
            AppMethodBeat.o(205760);
            return false;
        }
        AppMethodBeat.o(205760);
        return true;
    }

    private boolean bringPointIntoView(int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z;
        AppMethodBeat.i(205761);
        if (isLayoutRequested()) {
            this.QGY = i2;
            AppMethodBeat.o(205761);
            return false;
        }
        Layout layout = gZx() ? this.QGF : this.OVt;
        if (layout == null) {
            AppMethodBeat.o(205761);
            return false;
        }
        int lineForOffset = layout.getLineForOffset(i2);
        switch (AnonymousClass5.bDD[layout.getParagraphAlignment(lineForOffset).ordinal()]) {
            case 1:
                i3 = layout.getParagraphDirection(lineForOffset);
                break;
            case 2:
                i3 = -layout.getParagraphDirection(lineForOffset);
                break;
            default:
                i3 = 0;
                break;
        }
        int primaryHorizontal = (int) layout.getPrimaryHorizontal(i2);
        int lineTop = layout.getLineTop(lineForOffset);
        int lineTop2 = layout.getLineTop(lineForOffset + 1);
        int floor = (int) Math.floor((double) layout.getLineLeft(lineForOffset));
        int ceil = (int) Math.ceil((double) layout.getLineRight(lineForOffset));
        int height = layout.getHeight();
        int right = ((getRight() - getLeft()) - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        int bottom = ((getBottom() - getTop()) - getExtendedPaddingTop()) - getExtendedPaddingBottom();
        if (!this.QGQ && ceil - floor > right && ceil > primaryHorizontal) {
            ceil = Math.max(primaryHorizontal, floor + right);
        }
        int i9 = (lineTop2 - lineTop) / 2;
        if (i9 > bottom / 4) {
            i4 = bottom / 4;
        } else {
            i4 = i9;
        }
        if (i9 > right / 4) {
            i9 = right / 4;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        if (lineTop - scrollY < i4) {
            scrollY = lineTop - i4;
        }
        if (lineTop2 - scrollY > bottom - i4) {
            i5 = lineTop2 - (bottom - i4);
        } else {
            i5 = scrollY;
        }
        if (height - i5 < bottom) {
            i5 = height - bottom;
        }
        if (0 - i5 > 0) {
            i6 = 0;
        } else {
            i6 = i5;
        }
        if (i3 != 0) {
            if (primaryHorizontal - scrollX < i9) {
                i7 = primaryHorizontal - i9;
            } else {
                i7 = scrollX;
            }
            if (primaryHorizontal - i7 > right - i9) {
                i7 = primaryHorizontal - (right - i9);
            }
        } else {
            i7 = scrollX;
        }
        if (i3 < 0) {
            if (floor - i7 > 0) {
                i8 = floor;
            } else {
                i8 = i7;
            }
            if (ceil - i8 < right) {
                i8 = ceil - right;
            }
        } else if (i3 > 0) {
            if (ceil - i7 < right) {
                i8 = ceil - right;
            } else {
                i8 = i7;
            }
            if (floor - i8 > 0) {
                i8 = floor;
            }
        } else if (ceil - floor <= right) {
            i8 = floor - ((right - (ceil - floor)) / 2);
        } else if (primaryHorizontal > ceil - i9) {
            i8 = ceil - right;
        } else if (primaryHorizontal < floor + i9) {
            i8 = floor;
        } else if (floor > i7) {
            i8 = floor;
        } else if (ceil < i7 + right) {
            i8 = ceil - right;
        } else {
            if (primaryHorizontal - i7 < i9) {
                i8 = primaryHorizontal - i9;
            } else {
                i8 = i7;
            }
            if (primaryHorizontal - i8 > right - i9) {
                i8 = primaryHorizontal - (right - i9);
            }
        }
        if (i8 == getScrollX() && i6 == getScrollY()) {
            z = false;
        } else {
            if (this.mScroller == null) {
                scrollTo(i8, i6);
            } else {
                int scrollX2 = i8 - getScrollX();
                int scrollY2 = i6 - getScrollY();
                if (AnimationUtils.currentAnimationTimeMillis() - this.UC > 250) {
                    this.mScroller.startScroll(getScrollX(), getScrollY(), scrollX2, scrollY2);
                    awakenScrollBars(this.mScroller.getDuration());
                    invalidate();
                } else {
                    if (!this.mScroller.isFinished()) {
                        this.mScroller.abortAnimation();
                    }
                    scrollBy(scrollX2, scrollY2);
                }
                this.UC = AnimationUtils.currentAnimationTimeMillis();
            }
            z = true;
        }
        if (isFocused()) {
            if (this.mTempRect == null) {
                this.mTempRect = new Rect();
            }
            this.mTempRect.set(primaryHorizontal - 2, lineTop, primaryHorizontal + 2, lineTop2);
            c(this.mTempRect, lineForOffset);
            this.mTempRect.offset(getScrollX(), getScrollY());
            if (requestRectangleOnScreen(this.mTempRect)) {
                z = true;
            }
        }
        AppMethodBeat.o(205761);
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.ui.widget.cedit.edit.CustomTextView$5  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] bDD = new int[Layout.Alignment.values().length];

        static {
            AppMethodBeat.i(205557);
            try {
                bDD[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                bDD[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                bDD[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
                AppMethodBeat.o(205557);
            } catch (NoSuchFieldError e4) {
                AppMethodBeat.o(205557);
            }
        }
    }

    public void computeScroll() {
        AppMethodBeat.i(205762);
        if (this.mScroller != null && this.mScroller.computeScrollOffset()) {
            postInvalidate();
        }
        AppMethodBeat.o(205762);
    }

    private void c(Rect rect, int i2) {
        AppMethodBeat.i(205763);
        s(rect);
        if (i2 == 0) {
            rect.top -= getExtendedPaddingTop();
        }
        if (i2 == this.OVt.getLineCount() - 1) {
            rect.bottom += getExtendedPaddingBottom();
        }
        AppMethodBeat.o(205763);
    }

    private void s(Rect rect) {
        AppMethodBeat.i(205764);
        int gZy = gZy();
        rect.left += gZy;
        rect.right = gZy + rect.right;
        int gZz = gZz();
        rect.top += gZz;
        rect.bottom = gZz + rect.bottom;
        AppMethodBeat.o(205764);
    }

    /* access modifiers changed from: package-private */
    public final int gZy() {
        AppMethodBeat.i(205765);
        int compoundPaddingLeft = getCompoundPaddingLeft() - getScrollX();
        AppMethodBeat.o(205765);
        return compoundPaddingLeft;
    }

    /* access modifiers changed from: package-private */
    public final int gZz() {
        AppMethodBeat.i(205766);
        int extendedPaddingTop = getExtendedPaddingTop() - getScrollY();
        if ((this.Ku & 112) != 48) {
            extendedPaddingTop += CW(false);
        }
        AppMethodBeat.o(205766);
        return extendedPaddingTop;
    }

    @ViewDebug.ExportedProperty(category = "text")
    public int getSelectionStart() {
        AppMethodBeat.i(205767);
        int selectionStart = Selection.getSelectionStart(getText());
        AppMethodBeat.o(205767);
        return selectionStart;
    }

    @ViewDebug.ExportedProperty(category = "text")
    public int getSelectionEnd() {
        AppMethodBeat.i(205768);
        int selectionEnd = Selection.getSelectionEnd(getText());
        AppMethodBeat.o(205768);
        return selectionEnd;
    }

    public final boolean hasSelection() {
        AppMethodBeat.i(205769);
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        if (selectionStart < 0 || selectionEnd <= 0 || selectionStart == selectionEnd) {
            AppMethodBeat.o(205769);
            return false;
        }
        AppMethodBeat.o(205769);
        return true;
    }

    /* access modifiers changed from: package-private */
    public String getSelectedText() {
        AppMethodBeat.i(205770);
        if (!hasSelection()) {
            AppMethodBeat.o(205770);
            return null;
        }
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        String valueOf = String.valueOf(selectionStart > selectionEnd ? this.mText.subSequence(selectionEnd, selectionStart) : this.mText.subSequence(selectionStart, selectionEnd));
        AppMethodBeat.o(205770);
        return valueOf;
    }

    public void setAllCaps(boolean z) {
        AppMethodBeat.i(205771);
        if (!z) {
            setTransformationMethod(null);
        }
        AppMethodBeat.o(205771);
    }

    public void setSingleLine(boolean z) {
        AppMethodBeat.i(205772);
        setInputTypeSingleLine(z);
        r(z, true, true);
        AppMethodBeat.o(205772);
    }

    private void setInputTypeSingleLine(boolean z) {
        if (this.QHs != null && (this.QHs.Clf & 15) == 1) {
            if (z) {
                this.QHs.Clf &= -131073;
                return;
            }
            this.QHs.Clf |= 131072;
        }
    }

    private void r(boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(205773);
        this.OSP = z;
        if (z) {
            setLines(1);
            setHorizontallyScrolling(true);
            if (z2) {
                setTransformationMethod(SingleLineTransformationMethod.getInstance());
                AppMethodBeat.o(205773);
                return;
            }
        } else {
            if (z3) {
                setMaxLines(Integer.MAX_VALUE);
            }
            setHorizontallyScrolling(false);
            if (z2) {
                setTransformationMethod(null);
            }
        }
        AppMethodBeat.o(205773);
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        AppMethodBeat.i(205774);
        if (this.OVp != truncateAt) {
            this.OVp = truncateAt;
            if (this.OVt != null) {
                gLr();
                requestLayout();
                invalidate();
            }
        }
        AppMethodBeat.o(205774);
    }

    @ViewDebug.ExportedProperty
    public TextUtils.TruncateAt getEllipsize() {
        return this.OVp;
    }

    public void setSelectAllOnFocus(boolean z) {
        AppMethodBeat.i(205775);
        gZL();
        this.QHs.QIN = z;
        if (z && !(this.mText instanceof Spannable)) {
            setText(this.mText, TextView.BufferType.SPANNABLE);
        }
        AppMethodBeat.o(205775);
    }

    public void setCursorVisible(boolean z) {
        AppMethodBeat.i(205776);
        if (!z || this.QHs != null) {
            gZL();
            if (this.QHs.QIM != z) {
                this.QHs.QIM = z;
                invalidate();
                this.QHs.haz();
                this.QHs.gZP();
            }
            AppMethodBeat.o(205776);
            return;
        }
        AppMethodBeat.o(205776);
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
        AppMethodBeat.i(205777);
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(textWatcher);
        AppMethodBeat.o(205777);
    }

    public void removeTextChangedListener(TextWatcher textWatcher) {
        int indexOf;
        AppMethodBeat.i(205778);
        if (this.mListeners != null && (indexOf = this.mListeners.indexOf(textWatcher)) >= 0) {
            this.mListeners.remove(indexOf);
        }
        AppMethodBeat.o(205778);
    }

    private void a(CharSequence charSequence, int i2, int i3, int i4) {
        AppMethodBeat.i(205779);
        if (this.mListeners != null) {
            ArrayList<TextWatcher> arrayList = this.mListeners;
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                arrayList.get(i5).beforeTextChanged(charSequence, i2, i3, i4);
            }
        }
        Class<?> cls = null;
        try {
            cls = Class.forName("android.text.style.SpellCheckSpan");
        } catch (Throwable th) {
        }
        if (cls != null) {
            a(i2, i2 + i3, cls);
        }
        a(i2, i2 + i3, SuggestionSpan.class);
        AppMethodBeat.o(205779);
    }

    private <T> void a(int i2, int i3, Class<T> cls) {
        AppMethodBeat.i(205780);
        if (!(this.mText instanceof Editable)) {
            AppMethodBeat.o(205780);
            return;
        }
        Editable editable = (Editable) this.mText;
        Object[] spans = editable.getSpans(i2, i3, cls);
        int length = spans.length;
        for (int i4 = 0; i4 < length; i4++) {
            int spanStart = editable.getSpanStart(spans[i4]);
            if (editable.getSpanEnd(spans[i4]) == i2 || spanStart == i3) {
                break;
            }
            editable.removeSpan(spans[i4]);
        }
        AppMethodBeat.o(205780);
    }

    private void b(CharSequence charSequence, int i2, int i3, int i4) {
        AppMethodBeat.i(205781);
        if (this.mListeners != null) {
            ArrayList<TextWatcher> arrayList = this.mListeners;
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                arrayList.get(i5).onTextChanged(charSequence, i2, i3, i4);
            }
        }
        if (this.QHs != null) {
            this.QHs.hab();
        }
        AppMethodBeat.o(205781);
    }

    /* access modifiers changed from: package-private */
    public final void e(Editable editable) {
        AppMethodBeat.i(205782);
        if (this.mListeners != null) {
            ArrayList<TextWatcher> arrayList = this.mListeners;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.get(i2).afterTextChanged(editable);
            }
        }
        AppMethodBeat.o(205782);
    }

    /* access modifiers changed from: package-private */
    public final void gZA() {
        AppMethodBeat.i(205783);
        invalidate();
        int selectionStart = getSelectionStart();
        if (selectionStart >= 0 || (this.Ku & 112) == 80) {
            gZt();
        }
        gZw();
        if (selectionStart >= 0) {
            this.QHh = true;
            if (this.QHs != null) {
                this.QHs.haz();
            }
            bringPointIntoView(selectionStart);
        }
        AppMethodBeat.o(205783);
    }

    /* access modifiers changed from: package-private */
    public final void c(CharSequence charSequence, int i2, int i3, int i4) {
        AppMethodBeat.i(205784);
        QGm = 0;
        b.h hVar = this.QHs == null ? null : this.QHs.QID;
        if (hVar == null || hVar.QIp == 0) {
            gZA();
        }
        if (hVar != null) {
            hVar.mContentChanged = true;
            if (hVar.QKp < 0) {
                hVar.QKp = i2;
                hVar.QKq = i2 + i3;
            } else {
                hVar.QKp = Math.min(hVar.QKp, i2);
                hVar.QKq = Math.max(hVar.QKq, (i2 + i3) - hVar.QKr);
            }
            hVar.QKr += i4 - i3;
        }
        b(charSequence, i2, i3, i4);
        AppMethodBeat.o(205784);
    }

    /* access modifiers changed from: package-private */
    public final void a(Spanned spanned, Object obj, int i2, int i3, int i4, int i5) {
        b.h hVar;
        int i6;
        boolean z;
        int i7 = -1;
        AppMethodBeat.i(205785);
        if (this.QHs == null) {
            hVar = null;
        } else {
            hVar = this.QHs.QID;
        }
        if (obj == Selection.SELECTION_END) {
            if (i2 >= 0 || i3 >= 0) {
                aV(Selection.getSelectionStart(spanned), i2, i3);
                gZw();
                gZt();
                if (this.QHs != null) {
                    this.QHs.haz();
                }
            }
            i6 = i3;
            z = true;
        } else {
            i6 = -1;
            z = false;
        }
        if (obj == Selection.SELECTION_START) {
            if (i2 >= 0 || i3 >= 0) {
                aV(Selection.getSelectionEnd(spanned), i2, i3);
            }
            i7 = i3;
            z = true;
        }
        if (z) {
            this.QHh = true;
            if (this.QHs != null && !isFocused()) {
                this.QHs.QIF = true;
            }
            if ((spanned.getSpanFlags(obj) & 512) == 0) {
                if (i7 < 0) {
                    Selection.getSelectionStart(spanned);
                }
                if (i6 < 0) {
                    Selection.getSelectionEnd(spanned);
                }
                if (this.QHs != null) {
                    this.QHs.hai();
                    if (!hasSelection() && this.QHs.ham() && hasTransientState()) {
                        setHasTransientState(false);
                    }
                }
                sendAccessibilityEvent(8192);
            }
        }
        if ((obj instanceof UpdateAppearance) || (obj instanceof ParagraphStyle) || (obj instanceof CharacterStyle)) {
            if (hVar == null || hVar.QIp == 0) {
                invalidate();
                this.QHh = true;
                gZw();
            } else {
                hVar.mContentChanged = true;
            }
            if (this.QHs != null) {
                this.QHs.hag();
            }
        }
        if (MetaKeyKeyListener.isMetaTracker(spanned, obj)) {
            this.QHh = true;
            if (hVar != null && MetaKeyKeyListener.isSelectingMetaTracker(spanned, obj)) {
                hVar.QKo = true;
            }
            if (Selection.getSelectionStart(spanned) >= 0) {
                if (hVar == null || hVar.QIp == 0) {
                    gZs();
                } else {
                    hVar.QKn = true;
                }
            }
        }
        if (!(!(obj instanceof ParcelableSpan) || hVar == null || hVar.QKl == null)) {
            if (hVar.QIp != 0) {
                if (i2 >= 0) {
                    if (hVar.QKp > i2) {
                        hVar.QKp = i2;
                    }
                    if (hVar.QKp > i4) {
                        hVar.QKp = i4;
                    }
                }
                if (i3 >= 0) {
                    if (hVar.QKp > i3) {
                        hVar.QKp = i3;
                    }
                    if (hVar.QKp > i5) {
                        hVar.QKp = i5;
                        AppMethodBeat.o(205785);
                        return;
                    }
                }
            } else {
                hVar.mContentChanged = true;
            }
        }
        AppMethodBeat.o(205785);
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        AppMethodBeat.i(205786);
        if (Build.VERSION.SDK_INT < 24 || !isTemporarilyDetached()) {
            if (this.QHs != null) {
                this.QHs.af(z, i2);
            }
            if (z && this.QGC != null) {
                MetaKeyKeyListener.resetMetaState(this.QGC);
            }
            if (this.QGH != null) {
                this.QGH.onFocusChanged(this, this.mText, z, i2, rect);
            }
            super.onFocusChanged(z, i2, rect);
            AppMethodBeat.o(205786);
            return;
        }
        super.onFocusChanged(z, i2, rect);
        AppMethodBeat.o(205786);
    }

    public void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(205787);
        super.onWindowFocusChanged(z);
        if (this.QHs != null) {
            b bVar = this.QHs;
            if (z) {
                if (bVar.QIL != null) {
                    bVar.QIL.mCancelled = false;
                    bVar.haz();
                }
                if (bVar.QIo.hasSelection() && !bVar.has()) {
                    bVar.hai();
                    AppMethodBeat.o(205787);
                    return;
                }
            } else {
                if (bVar.QIL != null) {
                    bVar.QIL.cancel();
                }
                if (bVar.QIC != null) {
                    bVar.QIC.QKj = false;
                }
                bVar.gZQ();
                bVar.hav();
                bVar.had();
                bVar.haa();
            }
        }
        AppMethodBeat.o(205787);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i2) {
        AppMethodBeat.i(205788);
        super.onVisibilityChanged(view, i2);
        if (!(this.QHs == null || i2 == 0)) {
            this.QHs.gZQ();
            gZE();
        }
        AppMethodBeat.o(205788);
    }

    public void clearComposingText() {
        AppMethodBeat.i(205789);
        if (this.mText instanceof Spannable) {
            BaseInputConnection.removeComposingSpans(this.QGC);
        }
        AppMethodBeat.o(205789);
    }

    public void setSelected(boolean z) {
        AppMethodBeat.i(205790);
        isSelected();
        super.setSelected(z);
        AppMethodBeat.o(205790);
    }

    /* access modifiers changed from: package-private */
    public final boolean c(MotionEvent motionEvent, boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(205791);
        if (this.QHq == -1) {
            this.QHq = motionEvent.getPointerId(0);
            this.QHr = z;
            z2 = true;
        } else if (this.QHq == motionEvent.getPointerId(0)) {
            z2 = true;
        } else if (this.QHr && z) {
            z2 = true;
        }
        if (motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3) {
            this.QHq = -1;
        }
        AppMethodBeat.o(205791);
        return z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:156:0x02b5  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0079  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r13) {
        /*
        // Method dump skipped, instructions count: 730
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.widget.cedit.edit.CustomTextView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(205793);
        if (!(this.QGG == null || !(this.mText instanceof Spannable) || this.OVt == null)) {
            try {
                if (this.QGG.a(this, motionEvent)) {
                    AppMethodBeat.o(205793);
                    return true;
                }
            } catch (AbstractMethodError e2) {
            }
        }
        boolean onGenericMotionEvent = super.onGenericMotionEvent(motionEvent);
        AppMethodBeat.o(205793);
        return onGenericMotionEvent;
    }

    public boolean showContextMenu() {
        AppMethodBeat.i(205794);
        if (this.QHs != null) {
            this.QHs.aA(Float.NaN, Float.NaN);
        }
        boolean showContextMenu = super.showContextMenu();
        AppMethodBeat.o(205794);
        return showContextMenu;
    }

    public boolean showContextMenu(float f2, float f3) {
        AppMethodBeat.i(205795);
        if (this.QHs != null) {
            this.QHs.aA(f2, f3);
        }
        boolean showContextMenu = super.showContextMenu(f2, f3);
        AppMethodBeat.o(205795);
        return showContextMenu;
    }

    /* access modifiers changed from: package-private */
    public final boolean gZB() {
        AppMethodBeat.i(205796);
        if (!(this.mText instanceof Editable) || !onCheckIsTextEditor() || !isEnabled()) {
            AppMethodBeat.o(205796);
            return false;
        }
        AppMethodBeat.o(205796);
        return true;
    }

    public final boolean didTouchFocusSelect() {
        return this.QHs != null && this.QHs.QIG;
    }

    public void cancelLongPress() {
        AppMethodBeat.i(205797);
        super.cancelLongPress();
        if (this.QHs != null) {
            this.QHs.PPd = true;
        }
        AppMethodBeat.o(205797);
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(205798);
        boolean onTrackballEvent = super.onTrackballEvent(motionEvent);
        AppMethodBeat.o(205798);
        return onTrackballEvent;
    }

    public void setScroller(Scroller scroller) {
        this.mScroller = scroller;
    }

    /* access modifiers changed from: protected */
    public float getLeftFadingEdgeStrength() {
        AppMethodBeat.i(205799);
        if (getLineCount() == 1) {
            float lineLeft = getLayout().getLineLeft(0);
            if (lineLeft > ((float) getScrollX())) {
                AppMethodBeat.o(205799);
                return 0.0f;
            }
            float ax = ax((float) getScrollX(), lineLeft);
            AppMethodBeat.o(205799);
            return ax;
        }
        float leftFadingEdgeStrength = super.getLeftFadingEdgeStrength();
        AppMethodBeat.o(205799);
        return leftFadingEdgeStrength;
    }

    /* access modifiers changed from: protected */
    public float getRightFadingEdgeStrength() {
        AppMethodBeat.i(205800);
        if (getLineCount() == 1) {
            float scrollX = (float) (getScrollX() + ((getWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight()));
            float lineRight = getLayout().getLineRight(0);
            if (lineRight < scrollX) {
                AppMethodBeat.o(205800);
                return 0.0f;
            }
            float ax = ax(scrollX, lineRight);
            AppMethodBeat.o(205800);
            return ax;
        }
        float rightFadingEdgeStrength = super.getRightFadingEdgeStrength();
        AppMethodBeat.o(205800);
        return rightFadingEdgeStrength;
    }

    private float ax(float f2, float f3) {
        AppMethodBeat.i(205801);
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (horizontalFadingEdgeLength == 0) {
            AppMethodBeat.o(205801);
            return 0.0f;
        }
        float abs = Math.abs(f2 - f3);
        if (abs > ((float) horizontalFadingEdgeLength)) {
            AppMethodBeat.o(205801);
            return 1.0f;
        }
        float f4 = abs / ((float) horizontalFadingEdgeLength);
        AppMethodBeat.o(205801);
        return f4;
    }

    /* access modifiers changed from: protected */
    public int computeHorizontalScrollRange() {
        AppMethodBeat.i(205802);
        if (this.OVt == null) {
            int computeHorizontalScrollRange = super.computeHorizontalScrollRange();
            AppMethodBeat.o(205802);
            return computeHorizontalScrollRange;
        } else if (!this.OSP || (this.Ku & 7) != 3) {
            int width = this.OVt.getWidth();
            AppMethodBeat.o(205802);
            return width;
        } else {
            int lineWidth = (int) this.OVt.getLineWidth(0);
            AppMethodBeat.o(205802);
            return lineWidth;
        }
    }

    /* access modifiers changed from: protected */
    public int computeVerticalScrollRange() {
        AppMethodBeat.i(205803);
        if (this.OVt != null) {
            int height = this.OVt.getHeight();
            AppMethodBeat.o(205803);
            return height;
        }
        int computeVerticalScrollRange = super.computeVerticalScrollRange();
        AppMethodBeat.o(205803);
        return computeVerticalScrollRange;
    }

    /* access modifiers changed from: protected */
    public int computeVerticalScrollExtent() {
        AppMethodBeat.i(205804);
        int height = (getHeight() - getCompoundPaddingTop()) - getCompoundPaddingBottom();
        AppMethodBeat.o(205804);
        return height;
    }

    @Override // android.view.View
    public void findViewsWithText(ArrayList<View> arrayList, CharSequence charSequence, int i2) {
        AppMethodBeat.i(205805);
        super.findViewsWithText(arrayList, charSequence, i2);
        if (!arrayList.contains(this) && (i2 & 1) != 0 && !TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(this.mText)) {
            if (this.mText.toString().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                arrayList.add(this);
            }
        }
        AppMethodBeat.o(205805);
    }

    public boolean onKeyShortcut(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(205806);
        if (!keyEvent.hasModifiers(4096)) {
            if (keyEvent.hasModifiers(4097)) {
                switch (i2) {
                    case 50:
                        if (gZH()) {
                            boolean onTextContextMenuItem = onTextContextMenuItem(16908337);
                            AppMethodBeat.o(205806);
                            return onTextContextMenuItem;
                        }
                        break;
                }
            }
        } else {
            switch (i2) {
                case 29:
                    if (gZC()) {
                        boolean onTextContextMenuItem2 = onTextContextMenuItem(16908319);
                        AppMethodBeat.o(205806);
                        return onTextContextMenuItem2;
                    }
                    break;
                case 31:
                    if (gZG()) {
                        boolean onTextContextMenuItem3 = onTextContextMenuItem(16908321);
                        AppMethodBeat.o(205806);
                        return onTextContextMenuItem3;
                    }
                    break;
                case 50:
                    if (gZH()) {
                        boolean onTextContextMenuItem4 = onTextContextMenuItem(16908322);
                        AppMethodBeat.o(205806);
                        return onTextContextMenuItem4;
                    }
                    break;
                case 52:
                    if (gZF()) {
                        boolean onTextContextMenuItem5 = onTextContextMenuItem(16908320);
                        AppMethodBeat.o(205806);
                        return onTextContextMenuItem5;
                    }
                    break;
            }
        }
        boolean onKeyShortcut = super.onKeyShortcut(i2, keyEvent);
        AppMethodBeat.o(205806);
        return onKeyShortcut;
    }

    /* access modifiers changed from: package-private */
    public final boolean gZC() {
        AppMethodBeat.i(205807);
        if (this.mText.length() == 0 || this.QHs == null || !this.QHs.QIw) {
            AppMethodBeat.o(205807);
            return false;
        }
        AppMethodBeat.o(205807);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean gZD() {
        AppMethodBeat.i(205808);
        if (this.QGG == null || !this.QGG.canSelectArbitrarily()) {
            AppMethodBeat.o(205808);
            return false;
        } else if (gZB() || (isTextSelectable() && (this.mText instanceof Spannable) && isEnabled())) {
            AppMethodBeat.o(205808);
            return true;
        } else {
            AppMethodBeat.o(205808);
            return false;
        }
    }

    public final void setTextOperationUser(UserHandle userHandle) {
        AppMethodBeat.i(205810);
        if (Objects.equals(this.QHd, userHandle)) {
            AppMethodBeat.o(205810);
            return;
        }
        if (userHandle != null) {
            Process.myUserHandle().equals(userHandle);
        }
        this.QHd = userHandle;
        this.QHe = null;
        AppMethodBeat.o(205810);
    }

    /* access modifiers changed from: package-private */
    public final TextServicesManager getTextServicesManagerForUser() {
        AppMethodBeat.i(205811);
        if (Build.VERSION.SDK_INT >= 23) {
            TextServicesManager textServicesManager = (TextServicesManager) bj(TextServicesManager.class);
            AppMethodBeat.o(205811);
            return textServicesManager;
        }
        TextServicesManager textServicesManager2 = (TextServicesManager) getContext().getSystemService("textservices");
        AppMethodBeat.o(205811);
        return textServicesManager2;
    }

    /* access modifiers changed from: package-private */
    public final ClipboardManager getClipboardManagerForUser() {
        AppMethodBeat.i(205812);
        if (Build.VERSION.SDK_INT >= 23) {
            getContext().getPackageName();
            ClipboardManager clipboardManager = (ClipboardManager) bj(ClipboardManager.class);
            AppMethodBeat.o(205812);
            return clipboardManager;
        }
        ClipboardManager clipboardManager2 = (ClipboardManager) getContext().getSystemService("clipboard");
        AppMethodBeat.o(205812);
        return clipboardManager2;
    }

    /* access modifiers changed from: package-private */
    public final TextClassificationManager getTextClassificationManagerForUser() {
        AppMethodBeat.i(205813);
        if (Build.VERSION.SDK_INT >= 26) {
            getContext().getPackageName();
            TextClassificationManager textClassificationManager = (TextClassificationManager) bj(TextClassificationManager.class);
            AppMethodBeat.o(205813);
            return textClassificationManager;
        }
        AppMethodBeat.o(205813);
        return null;
    }

    private <T> T bj(Class<T> cls) {
        AppMethodBeat.i(205814);
        if (this.QHd != null || Build.VERSION.SDK_INT < 23) {
            AppMethodBeat.o(205814);
            return null;
        }
        T t = (T) getContext().getSystemService(cls);
        AppMethodBeat.o(205814);
        return t;
    }

    public Locale getTextServicesLocale() {
        AppMethodBeat.i(205815);
        Locale CX = CX(false);
        AppMethodBeat.o(205815);
        return CX;
    }

    /* access modifiers changed from: protected */
    public boolean jw() {
        return true;
    }

    public Locale getSpellCheckerLocale() {
        AppMethodBeat.i(205816);
        Locale CX = CX(true);
        AppMethodBeat.o(205816);
        return CX;
    }

    public com.tencent.mm.ui.widget.cedit.c.b getWordIterator() {
        AppMethodBeat.i(205817);
        if (this.QHs != null) {
            com.tencent.mm.ui.widget.cedit.c.b wordIterator = this.QHs.getWordIterator();
            AppMethodBeat.o(205817);
            return wordIterator;
        }
        AppMethodBeat.o(205817);
        return null;
    }

    public CharSequence getAccessibilityClassName() {
        AppMethodBeat.i(205818);
        String name = CustomTextView.class.getName();
        AppMethodBeat.o(205818);
        return name;
    }

    @Override // android.view.View
    public void autofill(AutofillValue autofillValue) {
        AppMethodBeat.i(205819);
        if (Build.VERSION.SDK_INT < 26 || (autofillValue.isText() && gZB())) {
            CharSequence charSequence = null;
            if (Build.VERSION.SDK_INT >= 26) {
                charSequence = autofillValue.getTextValue();
            }
            a(charSequence, this.QGD, true, 0);
            CharSequence text = getText();
            if (text instanceof Spannable) {
                Selection.setSelection((Spannable) text, text.length());
            }
            AppMethodBeat.o(205819);
            return;
        }
        Log.w("cmEdit.CMTextView", autofillValue + " could not be autofilled into " + this);
        AppMethodBeat.o(205819);
    }

    public int getAutofillType() {
        AppMethodBeat.i(205820);
        if (gZB()) {
            AppMethodBeat.o(205820);
            return 1;
        }
        AppMethodBeat.o(205820);
        return 0;
    }

    public AutofillValue getAutofillValue() {
        AppMethodBeat.i(205821);
        if (gZB()) {
            CharSequence n = com.tencent.mm.ui.widget.cedit.util.c.n(getText(), 100000);
            if (Build.VERSION.SDK_INT >= 26) {
                AutofillValue forText = AutofillValue.forText(n);
                AppMethodBeat.o(205821);
                return forText;
            }
        }
        AppMethodBeat.o(205821);
        return null;
    }

    public void addExtraDataToAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
        RectF characterBounds;
        AppMethodBeat.i(205822);
        if (bundle == null || !str.equals("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY")) {
            AppMethodBeat.o(205822);
            return;
        }
        int i2 = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX", -1);
        int i3 = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH", -1);
        if (i3 <= 0 || i2 < 0 || i2 >= this.mText.length()) {
            Log.e("cmEdit.CMTextView", "Invalid arguments for accessibility character locations");
            AppMethodBeat.o(205822);
            return;
        }
        RectF[] rectFArr = new RectF[i3];
        CursorAnchorInfo.Builder builder = new CursorAnchorInfo.Builder();
        a(builder, i2, i2 + i3, (float) gZy(), (float) gZz());
        CursorAnchorInfo build = builder.setMatrix(null).build();
        for (int i4 = 0; i4 < i3; i4++) {
            if ((build.getCharacterBoundsFlags(i2 + i4) & 1) == 1 && (characterBounds = build.getCharacterBounds(i2 + i4)) != null) {
                rectFArr[i4] = characterBounds;
            }
        }
        accessibilityNodeInfo.getExtras().putParcelableArray(str, rectFArr);
        AppMethodBeat.o(205822);
    }

    private void a(CursorAnchorInfo.Builder builder, int i2, int i3, float f2, float f3) {
        float f4;
        float f5;
        AppMethodBeat.i(205823);
        int lineForOffset = this.OVt.getLineForOffset(i2);
        int lineForOffset2 = this.OVt.getLineForOffset(i3 - 1);
        for (int i4 = lineForOffset; i4 <= lineForOffset2; i4++) {
            int lineStart = this.OVt.getLineStart(i4);
            int lineEnd = this.OVt.getLineEnd(i4);
            int max = Math.max(lineStart, i2);
            int min = Math.min(lineEnd, i3);
            boolean z = this.OVt.getParagraphDirection(i4) == 1;
            float[] fArr = new float[(min - max)];
            this.OVt.getPaint().getTextWidths(this.OVq, max, min, fArr);
            float lineTop = (float) this.OVt.getLineTop(i4);
            float lineBottom = (float) this.OVt.getLineBottom(i4);
            for (int i5 = max; i5 < min; i5++) {
                float f6 = fArr[i5 - max];
                boolean isRtlCharAt = this.OVt.isRtlCharAt(i5);
                float primaryHorizontal = this.OVt.getPrimaryHorizontal(i5);
                float secondaryHorizontal = this.OVt.getSecondaryHorizontal(i5);
                if (z) {
                    if (isRtlCharAt) {
                        f4 = secondaryHorizontal - f6;
                        f5 = secondaryHorizontal;
                    } else {
                        float f7 = primaryHorizontal + f6;
                        f4 = primaryHorizontal;
                        f5 = f7;
                    }
                } else if (!isRtlCharAt) {
                    float f8 = secondaryHorizontal + f6;
                    f4 = secondaryHorizontal;
                    f5 = f8;
                } else {
                    f4 = primaryHorizontal - f6;
                    f5 = primaryHorizontal;
                }
                float f9 = f4 + f2;
                float f10 = f5 + f2;
                float f11 = lineTop + f3;
                float f12 = lineBottom + f3;
                boolean ay = ay(f9, f11);
                boolean ay2 = ay(f10, f12);
                int i6 = 0;
                if (ay || ay2) {
                    i6 = 1;
                }
                if (!ay || !ay2) {
                    i6 |= 2;
                }
                if (isRtlCharAt) {
                    i6 |= 4;
                }
                builder.addCharacterBounds(i5, f9, f11, f10, f12, i6);
            }
        }
        AppMethodBeat.o(205823);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0015 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x0015 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r0v10, types: [android.view.View] */
    public final boolean ay(float f2, float f3) {
        AppMethodBeat.i(205824);
        synchronized (QGi) {
            try {
                float[] fArr = QGi;
                fArr[0] = f2;
                fArr[1] = f3;
                CustomTextView customTextView = this;
                while (customTextView != null) {
                    if (customTextView != this) {
                        fArr[0] = fArr[0] - ((float) customTextView.getScrollX());
                        fArr[1] = fArr[1] - ((float) customTextView.getScrollY());
                    }
                    if (fArr[0] < 0.0f || fArr[1] < 0.0f || fArr[0] > ((float) customTextView.getWidth()) || fArr[1] > ((float) customTextView.getHeight())) {
                        return false;
                    }
                    if (!customTextView.getMatrix().isIdentity()) {
                        customTextView.getMatrix().mapPoints(fArr);
                    }
                    fArr[0] = fArr[0] + ((float) customTextView.getLeft());
                    fArr[1] = fArr[1] + ((float) customTextView.getTop());
                    ViewParent parent = customTextView.getParent();
                    if (parent instanceof View) {
                        customTextView = (View) parent;
                    } else {
                        customTextView = 0;
                    }
                }
                AppMethodBeat.o(205824);
                return true;
            } finally {
                AppMethodBeat.o(205824);
            }
        }
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.i(205825);
        if (accessibilityEvent.getEventType() == 4096) {
            AppMethodBeat.o(205825);
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
        AppMethodBeat.o(205825);
    }

    /* access modifiers changed from: package-private */
    public InputMethodManager getInputMethodManager() {
        AppMethodBeat.i(205826);
        if (Build.VERSION.SDK_INT >= 23) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(InputMethodManager.class);
            AppMethodBeat.o(205826);
            return inputMethodManager;
        }
        InputMethodManager inputMethodManager2 = (InputMethodManager) getContext().getSystemService("input_method");
        AppMethodBeat.o(205826);
        return inputMethodManager2;
    }

    public boolean onTextContextMenuItem(int i2) {
        int i3;
        AutofillManager autofillManager;
        AppMethodBeat.i(205827);
        int length = this.mText.length();
        if (isFocused()) {
            int selectionStart = getSelectionStart();
            int selectionEnd = getSelectionEnd();
            i3 = Math.max(0, Math.min(selectionStart, selectionEnd));
            length = Math.max(0, Math.max(selectionStart, selectionEnd));
        } else {
            i3 = 0;
        }
        switch (i2) {
            case 16908319:
                boolean hasSelection = hasSelection();
                gZJ();
                if (this.QHs != null && hasSelection) {
                    this.QHs.hao().haV();
                }
                AppMethodBeat.o(205827);
                return true;
            case 16908320:
                if (a(ClipData.newPlainText(null, lA(i3, length)))) {
                    lB(i3, length);
                } else {
                    Toast.makeText(getContext(), "剪贴失败", 0).show();
                }
                AppMethodBeat.o(205827);
                return true;
            case 16908321:
                int selectionStart2 = getSelectionStart();
                int selectionEnd2 = getSelectionEnd();
                if (a(ClipData.newPlainText(null, lA(Math.max(0, Math.min(selectionStart2, selectionEnd2)), Math.max(0, Math.max(selectionStart2, selectionEnd2)))))) {
                    gZE();
                } else {
                    Toast.makeText(getContext(), "剪贴失败", 0).show();
                }
                AppMethodBeat.o(205827);
                return true;
            case 16908322:
                M(i3, length, true);
                AppMethodBeat.o(205827);
                return true;
            case 16908337:
                M(i3, length, false);
                AppMethodBeat.o(205827);
                return true;
            case 16908338:
                AppMethodBeat.o(205827);
                return true;
            case 16908339:
                AppMethodBeat.o(205827);
                return true;
            case 16908340:
                if (this.QHs != null) {
                    b bVar = this.QHs;
                    bVar.gZQ();
                    Selection.setSelection((Spannable) bVar.QIo.getText(), (bVar.QIo.getSelectionStart() + bVar.QIo.getSelectionEnd()) / 2);
                }
                AppMethodBeat.o(205827);
                return true;
            case 16908341:
                String selectedText = getSelectedText();
                if (selectedText != null && !selectedText.isEmpty()) {
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("text/plain");
                    intent.removeExtra("android.intent.extra.TEXT");
                    intent.putExtra("android.intent.extra.TEXT", (String) com.tencent.mm.ui.widget.cedit.util.c.n(selectedText, 100000));
                    Context context = getContext();
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(Intent.createChooser(intent, null));
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/widget/cedit/edit/CustomTextView", "shareSelectedText", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/widget/cedit/edit/CustomTextView", "shareSelectedText", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    Selection.setSelection(this.QGC, getSelectionEnd());
                }
                AppMethodBeat.o(205827);
                return true;
            case 16908355:
                if (Build.VERSION.SDK_INT >= 26 && (autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class)) != null) {
                    autofillManager.requestAutofill(this);
                }
                gZE();
                AppMethodBeat.o(205827);
                return true;
            default:
                AppMethodBeat.o(205827);
                return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final CharSequence lA(int i2, int i3) {
        AppMethodBeat.i(205828);
        CharSequence ax = ax(this.OVq.subSequence(i2, i3));
        AppMethodBeat.o(205828);
        return ax;
    }

    public boolean performLongClick() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(205829);
        if (this.QHs != null) {
            this.QHs.QIV = true;
        }
        if (super.performLongClick()) {
            z = true;
            z2 = true;
        } else {
            z = false;
            z2 = false;
        }
        if (this.QHs != null) {
            boolean CY = this.QHs.CY(z2);
            z2 |= CY;
            Log.i("cmEdit.CMTextView", "editor performLongClick handled =".concat(String.valueOf(CY)));
            this.QHs.QIV = false;
        }
        if (z2) {
            if (!z) {
                performHapticFeedback(0);
            }
            if (this.QHs != null) {
                this.QHs.QII = true;
            }
        }
        AppMethodBeat.o(205829);
        return z2;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(205830);
        super.onScrollChanged(i2, i3, i4, i5);
        if (this.QHs != null) {
            b bVar = this.QHs;
            if (bVar.QJc != null) {
                bVar.QJc.QKQ = true;
            }
            if (bVar.QIu != null && Build.VERSION.SDK_INT >= 23) {
                bVar.QIu.invalidateContentRect();
            }
        }
        AppMethodBeat.o(205830);
    }

    private boolean isSuggestionsEnabled() {
        if (this.QHs == null || (this.QHs.Clf & 15) != 1 || (this.QHs.Clf & 524288) > 0) {
            return false;
        }
        int i2 = this.QHs.Clf & 4080;
        return i2 == 0 || i2 == 48 || i2 == 80 || i2 == 64 || i2 == 160;
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        AppMethodBeat.i(205831);
        gZL();
        this.QHs.QJf = callback;
        AppMethodBeat.o(205831);
    }

    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        if (this.QHs == null) {
            return null;
        }
        return this.QHs.QJf;
    }

    public void setCustomInsertionActionModeCallback(ActionMode.Callback callback) {
        AppMethodBeat.i(205832);
        gZL();
        this.QHs.QJg = callback;
        AppMethodBeat.o(205832);
    }

    public ActionMode.Callback getCustomInsertionActionModeCallback() {
        if (this.QHs == null) {
            return null;
        }
        return this.QHs.QJg;
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        this.QGw = textClassifier;
    }

    public TextClassifier getTextClassifier() {
        AppMethodBeat.i(205833);
        if (this.QGw == null) {
            TextClassificationManager textClassificationManagerForUser = getTextClassificationManagerForUser();
            if (textClassificationManagerForUser != null && Build.VERSION.SDK_INT >= 26) {
                TextClassifier textClassifier = textClassificationManagerForUser.getTextClassifier();
                AppMethodBeat.o(205833);
                return textClassifier;
            } else if (Build.VERSION.SDK_INT >= 26) {
                TextClassifier textClassifier2 = TextClassifier.NO_OP;
                AppMethodBeat.o(205833);
                return textClassifier2;
            }
        }
        TextClassifier textClassifier3 = this.QGw;
        AppMethodBeat.o(205833);
        return textClassifier3;
    }

    /* access modifiers changed from: package-private */
    public TextClassifier getTextClassificationSession() {
        String str;
        AppMethodBeat.i(205834);
        if (Build.VERSION.SDK_INT >= 28 && (this.QGx == null || this.QGx.isDestroyed())) {
            TextClassificationManager textClassificationManagerForUser = getTextClassificationManagerForUser();
            if (textClassificationManagerForUser != null) {
                if (gZB()) {
                    str = "edittext";
                } else if (isTextSelectable()) {
                    str = "textview";
                } else {
                    str = "nosel-textview";
                }
                this.QGy = new TextClassificationContext.Builder(getContext().getPackageName(), str).build();
                if (this.QGw == null) {
                    this.QGx = textClassificationManagerForUser.createTextClassificationSession(this.QGy);
                }
            } else {
                this.QGx = TextClassifier.NO_OP;
            }
        }
        TextClassifier textClassifier = this.QGx;
        AppMethodBeat.o(205834);
        return textClassifier;
    }

    /* access modifiers changed from: package-private */
    public TextClassificationContext getTextClassificationContext() {
        return this.QGy;
    }

    public final void gZE() {
        AppMethodBeat.i(205835);
        if (this.QHs != null) {
            this.QHs.gZE();
        }
        AppMethodBeat.o(205835);
    }

    public final void aoA(int i2) {
        AppMethodBeat.i(205836);
        if (this.QHs != null) {
            this.QHs.aoA(i2);
        }
        AppMethodBeat.o(205836);
    }

    /* access modifiers changed from: package-private */
    public final boolean gZH() {
        AppMethodBeat.i(205839);
        if (!(this.mText instanceof Editable) || this.QHs == null || this.QHs.QIH == null || getSelectionStart() < 0 || getSelectionEnd() < 0 || !getClipboardManagerForUser().hasPrimaryClip()) {
            AppMethodBeat.o(205839);
            return false;
        }
        AppMethodBeat.o(205839);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean gZI() {
        AppMethodBeat.i(205840);
        if (!gZC() || (this.QGH instanceof PasswordTransformationMethod) || (getSelectionStart() == 0 && getSelectionEnd() == this.mText.length())) {
            AppMethodBeat.o(205840);
            return false;
        }
        AppMethodBeat.o(205840);
        return true;
    }

    public final boolean gZJ() {
        AppMethodBeat.i(205841);
        if (this.QHs != null) {
            aoA(500);
        }
        int length = this.mText.length();
        Selection.setSelection(this.QGC, 0, length);
        if (length > 0) {
            AppMethodBeat.o(205841);
            return true;
        }
        AppMethodBeat.o(205841);
        return false;
    }

    private void M(int i2, int i3, boolean z) {
        String charSequence;
        AppMethodBeat.i(205842);
        ClipData primaryClip = getClipboardManagerForUser().getPrimaryClip();
        if (primaryClip != null) {
            boolean z2 = false;
            for (int i4 = 0; i4 < primaryClip.getItemCount(); i4++) {
                if (z) {
                    charSequence = primaryClip.getItemAt(i4).coerceToStyledText(getContext());
                } else {
                    CharSequence coerceToText = primaryClip.getItemAt(i4).coerceToText(getContext());
                    charSequence = coerceToText instanceof Spanned ? coerceToText.toString() : coerceToText;
                }
                if (charSequence != null) {
                    if (!z2) {
                        Selection.setSelection(this.QGC, i3);
                        ((Editable) this.mText).replace(i2, i3, charSequence);
                        z2 = true;
                    } else {
                        ((Editable) this.mText).insert(getSelectionEnd(), "\n");
                        ((Editable) this.mText).insert(getSelectionEnd(), charSequence);
                    }
                }
            }
            QGm = 0;
        }
        AppMethodBeat.o(205842);
    }

    private boolean a(ClipData clipData) {
        AppMethodBeat.i(205843);
        try {
            getClipboardManagerForUser().setPrimaryClip(clipData);
            QGm = SystemClock.uptimeMillis();
            AppMethodBeat.o(205843);
            return true;
        } catch (Throwable th) {
            AppMethodBeat.o(205843);
            return false;
        }
    }

    public final int getOffsetForPosition(float f2, float f3) {
        AppMethodBeat.i(205844);
        if (getLayout() == null) {
            AppMethodBeat.o(205844);
            return -1;
        }
        int B = B(cz(f3), f2);
        AppMethodBeat.o(205844);
        return B;
    }

    /* access modifiers changed from: package-private */
    public final float cy(float f2) {
        AppMethodBeat.i(205845);
        float min = Math.min((float) ((getWidth() - getTotalPaddingRight()) - 1), Math.max(0.0f, f2 - ((float) getTotalPaddingLeft()))) + ((float) getScrollX());
        AppMethodBeat.o(205845);
        return min;
    }

    /* access modifiers changed from: package-private */
    public final int cz(float f2) {
        AppMethodBeat.i(205846);
        int lineForVertical = getLayout().getLineForVertical((int) (Math.min((float) ((getHeight() - getTotalPaddingBottom()) - 1), Math.max(0.0f, f2 - ((float) getTotalPaddingTop()))) + ((float) getScrollY())));
        AppMethodBeat.o(205846);
        return lineForVertical;
    }

    /* access modifiers changed from: package-private */
    public final int B(int i2, float f2) {
        AppMethodBeat.i(205847);
        int offsetForHorizontal = getLayout().getOffsetForHorizontal(i2, cy(f2));
        AppMethodBeat.o(205847);
        return offsetForHorizontal;
    }

    public boolean onDragEvent(DragEvent dragEvent) {
        AppMethodBeat.i(205848);
        switch (dragEvent.getAction()) {
            case 1:
                if (this.QHs == null || !this.QHs.QIv) {
                    AppMethodBeat.o(205848);
                    return false;
                }
                AppMethodBeat.o(205848);
                return true;
            case 2:
                if (this.mText instanceof Spannable) {
                    Selection.setSelection(this.QGC, getOffsetForPosition(dragEvent.getX(), dragEvent.getY()));
                }
                AppMethodBeat.o(205848);
                return true;
            case 3:
                if (this.QHs != null) {
                    this.QHs.a(dragEvent);
                }
                AppMethodBeat.o(205848);
                return true;
            case 4:
            default:
                AppMethodBeat.o(205848);
                return true;
            case 5:
                requestFocus();
                AppMethodBeat.o(205848);
                return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean gZK() {
        if (this.QHs == null) {
            return false;
        }
        b.h hVar = this.QHs.QID;
        if (hVar == null) {
            return this.QHs.QIP;
        }
        if (hVar.QIp > 0) {
            return true;
        }
        return false;
    }

    public void onRtlPropertiesChanged(int i2) {
        AppMethodBeat.i(205849);
        super.onRtlPropertiesChanged(i2);
        TextDirectionHeuristic textDirectionHeuristic = getTextDirectionHeuristic();
        if (this.Om != textDirectionHeuristic) {
            this.Om = textDirectionHeuristic;
            if (this.OVt != null) {
                IR();
            }
        }
        AppMethodBeat.o(205849);
    }

    private void a(InputMethodManager inputMethodManager) {
        AppMethodBeat.i(205851);
        if (inputMethodManager != null) {
            inputMethodManager.viewClicked(this);
        }
        AppMethodBeat.o(205851);
    }

    /* access modifiers changed from: protected */
    public final void lB(int i2, int i3) {
        AppMethodBeat.i(205852);
        ((Editable) this.mText).delete(i2, i3);
        AppMethodBeat.o(205852);
    }

    private void gZL() {
        AppMethodBeat.i(205853);
        if (this.QHs == null) {
            this.QHs = new b(this);
        }
        AppMethodBeat.o(205853);
    }

    public CharSequence getIterableTextForAccessibility() {
        return this.mText;
    }

    private void gZM() {
        AppMethodBeat.i(205854);
        if (!(this.mText instanceof Spannable)) {
            setText(this.mText, TextView.BufferType.SPANNABLE);
        }
        AppMethodBeat.o(205854);
    }

    public int getAccessibilitySelectionStart() {
        AppMethodBeat.i(205855);
        int selectionStart = getSelectionStart();
        AppMethodBeat.o(205855);
        return selectionStart;
    }

    public int getAccessibilitySelectionEnd() {
        AppMethodBeat.i(205856);
        int selectionEnd = getSelectionEnd();
        AppMethodBeat.o(205856);
        return selectionEnd;
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.tencent.mm.ui.widget.cedit.edit.CustomTextView.SavedState.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ SavedState createFromParcel(Parcel parcel) {
                AppMethodBeat.i(205565);
                SavedState savedState = new SavedState(parcel, (byte) 0);
                AppMethodBeat.o(205565);
                return savedState;
            }
        };
        int QHT;
        int QHU;
        boolean QHV;
        ParcelableParcel QHW;
        CharSequence text;
        CharSequence wz;

        /* synthetic */ SavedState(Parcel parcel, byte b2) {
            this(parcel);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
            this.QHT = -1;
            this.QHU = -1;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(205566);
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.QHT);
            parcel.writeInt(this.QHU);
            parcel.writeInt(this.QHV ? 1 : 0);
            TextUtils.writeToParcel(this.text, parcel, i2);
            if (this.wz == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                TextUtils.writeToParcel(this.wz, parcel, i2);
            }
            if (this.QHW == null) {
                parcel.writeInt(0);
                AppMethodBeat.o(205566);
                return;
            }
            parcel.writeInt(1);
            this.QHW.writeToParcel(parcel, i2);
            AppMethodBeat.o(205566);
        }

        public String toString() {
            AppMethodBeat.i(205567);
            String str = "TextView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " start=" + this.QHT + " end=" + this.QHU;
            if (this.text != null) {
                str = str + " text=" + ((Object) this.text);
            }
            String str2 = str + "}";
            AppMethodBeat.o(205567);
            return str2;
        }

        static {
            AppMethodBeat.i(205569);
            AppMethodBeat.o(205569);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            AppMethodBeat.i(205568);
            this.QHT = -1;
            this.QHU = -1;
            this.QHT = parcel.readInt();
            this.QHU = parcel.readInt();
            this.QHV = parcel.readInt() != 0;
            this.text = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                this.wz = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            }
            if (parcel.readInt() != 0) {
                this.QHW = ParcelableParcel.CREATOR.createFromParcel(parcel);
            }
            AppMethodBeat.o(205568);
        }
    }

    /* access modifiers changed from: package-private */
    public class a implements SpanWatcher, TextWatcher {
        private CharSequence QHD;

        private a() {
        }

        /* synthetic */ a(CustomTextView customTextView, byte b2) {
            this();
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AppMethodBeat.i(205558);
            if (com.tencent.mm.ui.widget.cedit.util.d.haZ() && CustomTextView.this.OVq != null) {
                this.QHD = CustomTextView.this.OVq.toString();
            }
            CustomTextView.a(CustomTextView.this, charSequence, i2, i3, i4);
            AppMethodBeat.o(205558);
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AppMethodBeat.i(205559);
            CustomTextView.this.c(charSequence, i2, i3, i4);
            if (com.tencent.mm.ui.widget.cedit.util.d.haZ() && (CustomTextView.this.isFocused() || (CustomTextView.this.isSelected() && CustomTextView.this.isShown()))) {
                CharSequence charSequence2 = this.QHD;
                AccessibilityEvent obtain = AccessibilityEvent.obtain(16);
                obtain.setFromIndex(i2);
                obtain.setRemovedCount(i3);
                obtain.setAddedCount(i4);
                obtain.setBeforeText(charSequence2);
                CustomTextView.this.sendAccessibilityEventUnchecked(obtain);
                this.QHD = null;
            }
            AppMethodBeat.o(205559);
        }

        public void afterTextChanged(Editable editable) {
            AppMethodBeat.i(205560);
            CustomTextView.this.e(editable);
            if (MetaKeyKeyListener.getMetaState(editable, 2048) != 0) {
                com.tencent.mm.ui.widget.cedit.util.d.b(CustomTextView.this, editable);
            }
            AppMethodBeat.o(205560);
        }

        public void onSpanChanged(Spannable spannable, Object obj, int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(205561);
            CustomTextView.this.a(spannable, obj, i2, i4, i3, i5);
            AppMethodBeat.o(205561);
        }

        public void onSpanAdded(Spannable spannable, Object obj, int i2, int i3) {
            AppMethodBeat.i(205562);
            CustomTextView.this.a(spannable, obj, -1, i2, -1, i3);
            AppMethodBeat.o(205562);
        }

        public void onSpanRemoved(Spannable spannable, Object obj, int i2, int i3) {
            AppMethodBeat.i(205563);
            CustomTextView.this.a(spannable, obj, i2, -1, i3, -1);
            AppMethodBeat.o(205563);
        }
    }

    public void setMenuCallback(a.e eVar) {
        this.QHz = eVar;
    }

    public a.e getMenuCallback() {
        return this.QHz;
    }

    public b getEditor() {
        return this.QHs;
    }

    public void setReuseItems(List<String> list) {
        AppMethodBeat.i(205857);
        if (list != null) {
            this.QHA.clear();
            this.QHA.addAll(list);
        }
        AppMethodBeat.o(205857);
    }

    public Set<String> getReuseItems() {
        return this.QHA;
    }

    public final boolean gZN() {
        AppMethodBeat.i(205858);
        if (getReuseItems().size() <= 0 || Build.BRAND == null || !getReuseBrands().contains(Build.BRAND.toLowerCase()) || Build.VERSION.SDK_INT < 23) {
            AppMethodBeat.o(205858);
            return false;
        }
        AppMethodBeat.o(205858);
        return true;
    }

    public void setReuseBrands(List<String> list) {
        AppMethodBeat.i(205859);
        if (list != null) {
            this.QHB.clear();
            this.QHB.addAll(list);
        }
        AppMethodBeat.o(205859);
    }

    public Set<String> getReuseBrands() {
        return this.QHB;
    }

    public boolean performAccessibilityAction(int i2, Bundle bundle) {
        boolean performLongClick;
        int i3;
        boolean z;
        int length;
        boolean z2 = true;
        AppMethodBeat.i(205860);
        switch (i2) {
            case 16:
                if (!isEnabled()) {
                    AppMethodBeat.o(205860);
                    return false;
                }
                if (isClickable() || isLongClickable()) {
                    if (isFocusable() && !isFocused()) {
                        requestFocus();
                    }
                    performClick();
                    z = true;
                } else {
                    z = false;
                }
                if (this.QGG != null || onCheckIsTextEditor()) {
                    if (this.mText == null || !(this.mText instanceof Spannable)) {
                        z2 = false;
                    }
                    if (z2 && this.OVt != null && ((gZB() || isTextSelectable()) && isFocused())) {
                        InputMethodManager inputMethodManager = getInputMethodManager();
                        a(inputMethodManager);
                        if (!isTextSelectable() && this.QHs.QIQ && inputMethodManager != null) {
                            z |= inputMethodManager.showSoftInput(this, 0);
                        }
                    }
                }
                AppMethodBeat.o(205860);
                return z;
            case 32:
                if (isLongClickable()) {
                    if (!isEnabled() || this.QGD != TextView.BufferType.EDITABLE) {
                        performLongClick = performLongClick();
                    } else {
                        this.QHs.QIW = true;
                        try {
                            performLongClick = performLongClick();
                            this.QHs.QIW = false;
                        } catch (Throwable th) {
                            this.QHs.QIW = false;
                            AppMethodBeat.o(205860);
                            throw th;
                        }
                    }
                    AppMethodBeat.o(205860);
                    return performLongClick;
                }
                boolean performAccessibilityAction = super.performAccessibilityAction(i2, bundle);
                AppMethodBeat.o(205860);
                return performAccessibilityAction;
            case 256:
            case 512:
                gZM();
                boolean performAccessibilityAction2 = super.performAccessibilityAction(i2, bundle);
                AppMethodBeat.o(205860);
                return performAccessibilityAction2;
            case 16384:
                if (isFocused() && gZG() && onTextContextMenuItem(16908321)) {
                    AppMethodBeat.o(205860);
                    return true;
                }
                if (isFocused() || !gZH() || !onTextContextMenuItem(16908322)) {
                    AppMethodBeat.o(205860);
                    return false;
                }
                AppMethodBeat.o(205860);
                return true;
            case 32768:
                if (isFocused()) {
                    break;
                }
                AppMethodBeat.o(205860);
                return false;
            case 65536:
                if (!isFocused() || !gZF() || !onTextContextMenuItem(16908320)) {
                    AppMethodBeat.o(205860);
                    return false;
                }
                AppMethodBeat.o(205860);
                return true;
            case 131072:
                gZM();
                CharSequence iterableTextForAccessibility = getIterableTextForAccessibility();
                if (iterableTextForAccessibility == null) {
                    AppMethodBeat.o(205860);
                    return false;
                }
                int i4 = bundle != null ? bundle.getInt("ACTION_ARGUMENT_SELECTION_START_INT", -1) : -1;
                if (bundle != null) {
                    i3 = bundle.getInt("ACTION_ARGUMENT_SELECTION_END_INT", -1);
                } else {
                    i3 = -1;
                }
                if (!(getSelectionStart() == i4 && getSelectionEnd() == i3)) {
                    if (i4 == i3 && i3 == -1) {
                        Selection.removeSelection((Spannable) iterableTextForAccessibility);
                        AppMethodBeat.o(205860);
                        return true;
                    } else if (i4 >= 0 && i4 <= i3 && i3 <= iterableTextForAccessibility.length()) {
                        Selection.setSelection((Spannable) iterableTextForAccessibility, i4, i3);
                        if (this.QHs != null) {
                            this.QHs.hao().haU();
                        }
                        AppMethodBeat.o(205860);
                        return true;
                    }
                }
                AppMethodBeat.o(205860);
                return false;
            case TPMediaCodecProfileLevel.HEVCHighTierLevel6 /*{ENCODED_INT: 2097152}*/:
                if (!isEnabled() || this.QGD != TextView.BufferType.EDITABLE) {
                    AppMethodBeat.o(205860);
                    return false;
                }
                setText(bundle != null ? bundle.getCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE") : null);
                if (this.mText != null && (length = this.mText.length()) > 0) {
                    Selection.setSelection(this.QGC, length);
                }
                AppMethodBeat.o(205860);
                return true;
            default:
                boolean performAccessibilityAction3 = super.performAccessibilityAction(i2, bundle);
                AppMethodBeat.o(205860);
                return performAccessibilityAction3;
        }
    }

    public void setTextSize(int i2, float f2) {
        boolean z;
        Resources resources;
        AppMethodBeat.i(205634);
        if (!jw() || this.aly == 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            Context context = getContext();
            if (context == null) {
                resources = Resources.getSystem();
            } else {
                resources = context.getResources();
            }
            this.QGM = i2;
            setRawTextSize$254d549(TypedValue.applyDimension(i2, f2, resources.getDisplayMetrics()));
        }
        AppMethodBeat.o(205634);
    }

    public void setError(CharSequence charSequence) {
        AppMethodBeat.i(205702);
        gZL();
        AppMethodBeat.o(205702);
    }

    public boolean onPreDraw() {
        int i2;
        int floor;
        int i3;
        AppMethodBeat.i(205712);
        if (this.OVt == null) {
            gLs();
        }
        if (this.QGG != null) {
            int selectionEnd = getSelectionEnd();
            if (!(this.QHs == null || this.QHs.QIt == null || !this.QHs.QIt.haP())) {
                selectionEnd = getSelectionStart();
            }
            if (selectionEnd < 0 && (this.Ku & 112) == 80) {
                selectionEnd = this.mText.length();
            }
            if (selectionEnd >= 0) {
                bringPointIntoView(selectionEnd);
            }
        } else {
            Layout layout = gZx() ? this.QGF : this.OVt;
            if ((this.Ku & 112) == 80) {
                i2 = layout.getLineCount() - 1;
            } else {
                i2 = 0;
            }
            Layout.Alignment paragraphAlignment = layout.getParagraphAlignment(i2);
            int paragraphDirection = layout.getParagraphDirection(i2);
            int right = ((getRight() - getLeft()) - getCompoundPaddingLeft()) - getCompoundPaddingRight();
            int bottom = ((getBottom() - getTop()) - getExtendedPaddingTop()) - getExtendedPaddingBottom();
            int height = layout.getHeight();
            if (paragraphAlignment != Layout.Alignment.ALIGN_NORMAL) {
                Layout.Alignment alignment = Layout.Alignment.ALIGN_OPPOSITE;
            }
            if (paragraphAlignment == Layout.Alignment.ALIGN_CENTER) {
                int floor2 = (int) Math.floor((double) layout.getLineLeft(i2));
                int ceil = (int) Math.ceil((double) layout.getLineRight(i2));
                if (ceil - floor2 < right) {
                    floor = ((ceil + floor2) / 2) - (right / 2);
                } else {
                    floor = paragraphDirection < 0 ? ceil - right : floor2;
                }
            } else {
                floor = (int) Math.floor((double) layout.getLineLeft(i2));
            }
            if (height < bottom || (this.Ku & 112) != 80) {
                i3 = 0;
            } else {
                i3 = height - bottom;
            }
            if (!(floor == getScrollX() && i3 == getScrollY())) {
                scrollTo(floor, i3);
            }
        }
        if (this.QHs != null && this.QHs.QJh) {
            this.QHs.hai();
            this.QHs.QJh = false;
        }
        getViewTreeObserver().removeOnPreDrawListener(this);
        this.QGu = false;
        this.QGv = false;
        AppMethodBeat.o(205712);
        return true;
    }

    private Locale CX(boolean z) {
        AppMethodBeat.i(205809);
        AsyncTask.execute(new Runnable() {
            /* class com.tencent.mm.ui.widget.cedit.edit.CustomTextView.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(205556);
                CustomTextView.a(CustomTextView.this);
                AppMethodBeat.o(205556);
            }
        });
        if (this.QHe != null || z) {
            Locale locale = this.QHe;
            AppMethodBeat.o(205809);
            return locale;
        }
        Locale locale2 = Locale.getDefault();
        AppMethodBeat.o(205809);
        return locale2;
    }

    /* access modifiers changed from: package-private */
    public final boolean gZF() {
        AppMethodBeat.i(205837);
        if (this.QGH instanceof PasswordTransformationMethod) {
            AppMethodBeat.o(205837);
            return false;
        } else if (this.mText.length() <= 0 || !hasSelection() || !(this.mText instanceof Editable) || this.QHs == null || this.QHs.QIH == null) {
            AppMethodBeat.o(205837);
            return false;
        } else {
            AppMethodBeat.o(205837);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean gZG() {
        AppMethodBeat.i(205838);
        if (this.QGH instanceof PasswordTransformationMethod) {
            AppMethodBeat.o(205838);
            return false;
        } else if (this.mText.length() <= 0 || !hasSelection() || this.QHs == null) {
            AppMethodBeat.o(205838);
            return false;
        } else {
            AppMethodBeat.o(205838);
            return true;
        }
    }

    public TextDirectionHeuristic getTextDirectionHeuristic() {
        DecimalFormatSymbols decimalFormatSymbols;
        String str = null;
        AppMethodBeat.i(205850);
        if (this.QGH instanceof PasswordTransformationMethod) {
            TextDirectionHeuristic textDirectionHeuristic = TextDirectionHeuristics.LTR;
            AppMethodBeat.o(205850);
            return textDirectionHeuristic;
        } else if (this.QHs == null || (this.QHs.Clf & 15) != 3) {
            boolean z = getLayoutDirection() == 1;
            switch (getTextDirection()) {
                case 2:
                    TextDirectionHeuristic textDirectionHeuristic2 = TextDirectionHeuristics.ANYRTL_LTR;
                    AppMethodBeat.o(205850);
                    return textDirectionHeuristic2;
                case 3:
                    TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.LTR;
                    AppMethodBeat.o(205850);
                    return textDirectionHeuristic3;
                case 4:
                    TextDirectionHeuristic textDirectionHeuristic4 = TextDirectionHeuristics.RTL;
                    AppMethodBeat.o(205850);
                    return textDirectionHeuristic4;
                case 5:
                    TextDirectionHeuristic textDirectionHeuristic5 = TextDirectionHeuristics.LOCALE;
                    AppMethodBeat.o(205850);
                    return textDirectionHeuristic5;
                case 6:
                    TextDirectionHeuristic textDirectionHeuristic6 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                    AppMethodBeat.o(205850);
                    return textDirectionHeuristic6;
                case 7:
                    TextDirectionHeuristic textDirectionHeuristic7 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    AppMethodBeat.o(205850);
                    return textDirectionHeuristic7;
                default:
                    if (z) {
                        TextDirectionHeuristic textDirectionHeuristic8 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                        AppMethodBeat.o(205850);
                        return textDirectionHeuristic8;
                    }
                    TextDirectionHeuristic textDirectionHeuristic9 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                    AppMethodBeat.o(205850);
                    return textDirectionHeuristic9;
            }
        } else {
            if (Build.VERSION.SDK_INT >= 24) {
                decimalFormatSymbols = DecimalFormatSymbols.getInstance(getTextLocale());
            } else {
                decimalFormatSymbols = null;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                str = decimalFormatSymbols.getDigitStrings()[0];
            }
            byte directionality = Character.getDirectionality(str.codePointAt(0));
            if (directionality == 1 || directionality == 2) {
                TextDirectionHeuristic textDirectionHeuristic10 = TextDirectionHeuristics.RTL;
                AppMethodBeat.o(205850);
                return textDirectionHeuristic10;
            }
            TextDirectionHeuristic textDirectionHeuristic11 = TextDirectionHeuristics.LTR;
            AppMethodBeat.o(205850);
            return textDirectionHeuristic11;
        }
    }

    static /* synthetic */ void a(CustomTextView customTextView) {
        AppMethodBeat.i(205861);
        if (customTextView.getTextServicesManagerForUser() != null) {
            customTextView.QHe = null;
        }
        AppMethodBeat.o(205861);
    }
}
