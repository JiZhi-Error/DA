package com.tencent.mm.ui.widget.cedit.edit;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.SystemClock;
import android.text.Editable;
import android.text.Layout;
import android.text.ParcelableSpan;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.KeyListener;
import android.text.method.MetaKeyKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.text.style.SuggestionSpan;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputMethodManager;
import android.widget.Magnifier;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.widget.cedit.edit.CustomTextView;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class b {
    int Clf = 0;
    boolean PPd;
    final ViewTreeObserver.OnDrawListener QIA = new ViewTreeObserver.OnDrawListener() {
        /* class com.tencent.mm.ui.widget.cedit.edit.b.AnonymousClass2 */

        public final void onDraw() {
            AppMethodBeat.i(205877);
            if (b.this.QIy != null) {
                b.this.QIo.post(b.this.QIz);
            }
            AppMethodBeat.o(205877);
        }
    };
    C2142b QIB;
    g QIC;
    h QID;
    boolean QIE;
    boolean QIF;
    boolean QIG;
    KeyListener QIH;
    boolean QII;
    long QIJ;
    boolean QIK;
    a QIL;
    boolean QIM = true;
    boolean QIN;
    boolean QIO;
    boolean QIP;
    boolean QIQ = true;
    boolean QIR;
    boolean QIS;
    boolean QIT;
    private d QIU;
    boolean QIV;
    boolean QIW;
    Runnable QIX;
    Drawable QIY = null;
    Drawable QIZ;
    final CustomTextView QIo;
    boolean QIr = true;
    j QIs;
    n QIt;
    ActionMode QIu;
    boolean QIv;
    boolean QIw;
    final boolean QIx;
    k QIy;
    final Runnable QIz = new Runnable() {
        /* class com.tencent.mm.ui.widget.cedit.edit.b.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(205876);
            k kVar = b.this.QIy;
            if (Build.VERSION.SDK_INT >= 28) {
                kVar.QKE.update();
            }
            AppMethodBeat.o(205876);
        }
    };
    Drawable QJa;
    Drawable QJb;
    l QJc;
    private float QJd;
    private float QJe;
    ActionMode.Callback QJf;
    ActionMode.Callback QJg;
    boolean QJh;
    int QJi;
    final c QJj = new c();
    Runnable QJk;
    private com.tencent.mm.ui.widget.cedit.c.b QJl;
    private com.tencent.mm.ui.widget.cedit.c.b QJm;
    private boolean QJn;
    private final c QJo = new c(this, (byte) 0);
    final Runnable QJp = new Runnable() {
        /* class com.tencent.mm.ui.widget.cedit.edit.b.AnonymousClass3 */

        public final void run() {
            AppMethodBeat.i(205878);
            if (b.this.QJy) {
                b.this.hak();
            }
            if (b.this.QIu != null && Build.VERSION.SDK_INT >= 23) {
                b.this.QIu.hide(0);
                Log.i("cmEdit.Editor", "mTextActionMode.hide(0)");
            }
            AppMethodBeat.o(205878);
        }
    };
    boolean QJq = false;
    private boolean QJr;
    final boolean QJs;
    int QJt;
    private float QJu = 1.0f;
    private int QJv;
    private int QJw;
    private com.tencent.mm.ui.widget.cedit.a.a QJx;
    boolean QJy = false;
    Rect mTempRect;

    /* access modifiers changed from: package-private */
    public interface d extends ViewTreeObserver.OnTouchModeChangeListener {
        boolean haB();

        boolean isActive();

        void show();
    }

    public interface p {
        void i(int i2, int i3, boolean z, boolean z2);
    }

    static /* synthetic */ void a(b bVar) {
        AppMethodBeat.i(206029);
        bVar.gZY();
        AppMethodBeat.o(206029);
    }

    static /* synthetic */ boolean b(b bVar) {
        AppMethodBeat.i(206032);
        boolean hap = bVar.hap();
        AppMethodBeat.o(206032);
        return hap;
    }

    static /* synthetic */ void c(b bVar) {
        AppMethodBeat.i(206033);
        bVar.gZX();
        AppMethodBeat.o(206033);
    }

    b(CustomTextView customTextView) {
        AppMethodBeat.i(205965);
        this.QIo = customTextView;
        this.QIo.setFilters(this.QIo.getFilters());
        this.QIx = false;
        this.QJr = false;
        this.QJs = false;
        this.QJv = (int) TypedValue.applyDimension(1, 45.0f, this.QIo.getContext().getResources().getDisplayMetrics());
        this.QJw = (int) TypedValue.applyDimension(1, 12.0f, this.QIo.getContext().getResources().getDisplayMetrics());
        AppMethodBeat.o(205965);
    }

    /* access modifiers changed from: package-private */
    public final void gZO() {
        AppMethodBeat.i(205966);
        if (this.QIC == null) {
            this.QIC = new g();
        }
        AppMethodBeat.o(205966);
    }

    /* access modifiers changed from: package-private */
    public final boolean isCursorVisible() {
        AppMethodBeat.i(205967);
        if (!this.QIM || !this.QIo.gZB()) {
            AppMethodBeat.o(205967);
            return false;
        }
        AppMethodBeat.o(205967);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void gZP() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        AppMethodBeat.i(205968);
        ViewGroup.LayoutParams layoutParams = this.QIo.getRootView().getLayoutParams();
        if (layoutParams instanceof WindowManager.LayoutParams) {
            WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) layoutParams;
            z = layoutParams2.type < 1000 || layoutParams2.type > 1999;
        } else {
            z = false;
        }
        if (!z || this.QIo.getLayout() == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2 || !isCursorVisible()) {
            z3 = false;
        } else {
            z3 = true;
        }
        this.QIv = z3;
        if (!z2 || !this.QIo.gZD()) {
            z4 = false;
        }
        this.QIw = z4;
        if (!this.QIv) {
            gZQ();
            if (this.QIs != null) {
                this.QIs.onDetached();
                this.QIs = null;
            }
        }
        if (!this.QIw) {
            gZE();
            if (this.QIt != null) {
                this.QIt.onDetached();
                this.QIt = null;
            }
        }
        AppMethodBeat.o(205968);
    }

    /* access modifiers changed from: package-private */
    public final void gZQ() {
        AppMethodBeat.i(205969);
        if (this.QIs != null) {
            this.QIs.hide();
        }
        AppMethodBeat.o(205969);
    }

    /* access modifiers changed from: package-private */
    public final void gZR() {
        AppMethodBeat.i(205970);
        if (this.QIL != null) {
            this.QIL.cancel();
        }
        AppMethodBeat.o(205970);
    }

    /* access modifiers changed from: package-private */
    public final void gZS() {
        AppMethodBeat.i(205971);
        if (this.QIL != null) {
            this.QIL.mCancelled = false;
            haz();
        }
        AppMethodBeat.o(205971);
    }

    /* access modifiers changed from: package-private */
    public final boolean gZT() {
        AppMethodBeat.i(205972);
        if (this.QIo.QGH instanceof PasswordTransformationMethod) {
            AppMethodBeat.o(205972);
            return true;
        }
        int inputType = this.QIo.getInputType();
        int i2 = inputType & 15;
        int i3 = inputType & 4080;
        if (i2 == 2 || i2 == 3 || i2 == 4 || i3 == 16 || i3 == 32 || i3 == 208 || i3 == 176) {
            AppMethodBeat.o(205972);
            return true;
        }
        AppMethodBeat.o(205972);
        return false;
    }

    private boolean gZU() {
        long lD;
        int i2;
        int i3;
        AppMethodBeat.i(205973);
        if (!this.QIo.gZC()) {
            AppMethodBeat.o(205973);
            return false;
        } else if (gZT()) {
            boolean gZJ = this.QIo.gZJ();
            AppMethodBeat.o(205973);
            return gZJ;
        } else {
            long gZZ = gZZ();
            int i4 = (int) (gZZ >>> 32);
            int i5 = (int) (gZZ & Util.MAX_32BIT_VALUE);
            if (i4 < 0 || i4 > this.QIo.getText().length()) {
                AppMethodBeat.o(205973);
                return false;
            } else if (i5 < 0 || i5 > this.QIo.getText().length()) {
                AppMethodBeat.o(205973);
                return false;
            } else {
                URLSpan[] uRLSpanArr = (URLSpan[]) ((Spanned) this.QIo.getText()).getSpans(i4, i5, URLSpan.class);
                if (uRLSpanArr.length > 0) {
                    URLSpan uRLSpan = uRLSpanArr[0];
                    i2 = ((Spanned) this.QIo.getText()).getSpanStart(uRLSpan);
                    i3 = ((Spanned) this.QIo.getText()).getSpanEnd(uRLSpan);
                } else {
                    com.tencent.mm.ui.widget.cedit.c.b wordIterator = getWordIterator();
                    wordIterator.i(this.QIo.getText(), i4, i5);
                    int bR = wordIterator.bR(i4, false);
                    int bS = wordIterator.bS(i5, false);
                    if (bR == -1 || bS == -1 || bR == bS) {
                        if (i4 < this.QIo.getText().length()) {
                            int bP = bP(i4, true);
                            lD = com.tencent.mm.ui.widget.cedit.util.c.lD(bP(bP, false), bP);
                        } else if (i4 - 1 >= 0) {
                            int bP2 = bP(i4, false);
                            lD = com.tencent.mm.ui.widget.cedit.util.c.lD(bP2, bP(bP2, true));
                        } else {
                            lD = com.tencent.mm.ui.widget.cedit.util.c.lD(i4, i4);
                        }
                        i2 = (int) (lD >>> 32);
                        i3 = (int) (lD & Util.MAX_32BIT_VALUE);
                    } else {
                        i2 = bR;
                        i3 = bS;
                    }
                }
                Selection.setSelection((Spannable) this.QIo.getText(), i2, i3);
                if (i3 > i2) {
                    AppMethodBeat.o(205973);
                    return true;
                }
                AppMethodBeat.o(205973);
                return false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final long lC(int i2, int i3) {
        AppMethodBeat.i(205974);
        Layout layout = this.QIo.getLayout();
        if (layout == null) {
            long lD = com.tencent.mm.ui.widget.cedit.util.c.lD(-1, -1);
            AppMethodBeat.o(205974);
            return lD;
        }
        CharSequence text = this.QIo.getText();
        int lineForOffset = layout.getLineForOffset(i2);
        while (lineForOffset > 0 && text.charAt(layout.getLineEnd(lineForOffset - 1) - 1) != '\n') {
            lineForOffset--;
        }
        int lineForOffset2 = layout.getLineForOffset(i3);
        while (lineForOffset2 < layout.getLineCount() - 1 && text.charAt(layout.getLineEnd(lineForOffset2) - 1) != '\n') {
            lineForOffset2++;
        }
        long lD2 = com.tencent.mm.ui.widget.cedit.util.c.lD(layout.getLineStart(lineForOffset), layout.getLineEnd(lineForOffset2));
        AppMethodBeat.o(205974);
        return lD2;
    }

    public final com.tencent.mm.ui.widget.cedit.c.b getWordIterator() {
        AppMethodBeat.i(205975);
        if (this.QJl == null) {
            this.QJl = new com.tencent.mm.ui.widget.cedit.c.b(this.QIo.getTextServicesLocale());
        }
        com.tencent.mm.ui.widget.cedit.c.b bVar = this.QJl;
        AppMethodBeat.o(205975);
        return bVar;
    }

    /* access modifiers changed from: package-private */
    public final com.tencent.mm.ui.widget.cedit.c.b gZV() {
        AppMethodBeat.i(205976);
        if (this.QJm == null) {
            this.QJm = new com.tencent.mm.ui.widget.cedit.c.b(this.QIo.getTextServicesLocale());
            this.QJn = true;
        }
        if (this.QJn) {
            CharSequence text = this.QIo.getText();
            this.QJm.i(text, 0, text.length());
            this.QJn = false;
        }
        com.tencent.mm.ui.widget.cedit.c.b bVar = this.QJm;
        AppMethodBeat.o(205976);
        return bVar;
    }

    /* access modifiers changed from: package-private */
    public final int bP(int i2, boolean z) {
        AppMethodBeat.i(205977);
        Layout layout = this.QIo.getLayout();
        if (layout == null) {
            AppMethodBeat.o(205977);
            return i2;
        } else if (z == layout.isRtlCharAt(i2)) {
            int offsetToLeftOf = layout.getOffsetToLeftOf(i2);
            AppMethodBeat.o(205977);
            return offsetToLeftOf;
        } else {
            int offsetToRightOf = layout.getOffsetToRightOf(i2);
            AppMethodBeat.o(205977);
            return offsetToRightOf;
        }
    }

    /* access modifiers changed from: package-private */
    public final l gZW() {
        AppMethodBeat.i(205978);
        if (this.QJc == null) {
            this.QJc = new l(this, (byte) 0);
        }
        l lVar = this.QJc;
        AppMethodBeat.o(205978);
        return lVar;
    }

    public final void a(p pVar) {
        AppMethodBeat.i(205979);
        gZW().a(pVar, false);
        AppMethodBeat.o(205979);
    }

    public final void b(p pVar) {
        AppMethodBeat.i(205980);
        gZW().c(pVar);
        AppMethodBeat.o(205980);
    }

    /* access modifiers changed from: package-private */
    public final boolean az(float f2, float f3) {
        AppMethodBeat.i(205981);
        Layout layout = this.QIo.getLayout();
        if (layout == null) {
            AppMethodBeat.o(205981);
            return false;
        }
        int cz = this.QIo.cz(f3);
        float cy = this.QIo.cy(f2);
        if (cy < layout.getLineLeft(cz)) {
            AppMethodBeat.o(205981);
            return false;
        } else if (cy > layout.getLineRight(cz)) {
            AppMethodBeat.o(205981);
            return false;
        } else {
            AppMethodBeat.o(205981);
            return true;
        }
    }

    private void gZX() {
        AppMethodBeat.i(205982);
        hao();
        int selectionStart = this.QIo.getSelectionStart();
        int selectionEnd = this.QIo.getSelectionEnd();
        ClipData.newPlainText(null, this.QIo.lA(selectionStart, selectionEnd));
        new e(this.QIo, selectionStart, selectionEnd);
        gZE();
        if (this.QIw) {
            hax().haN();
        }
        AppMethodBeat.o(205982);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0096  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean CY(boolean r7) {
        /*
        // Method dump skipped, instructions count: 162
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.widget.cedit.edit.b.CY(boolean):boolean");
    }

    private void gZY() {
        AppMethodBeat.i(205984);
        if (!ham()) {
            gZE();
            AppMethodBeat.o(205984);
            return;
        }
        haj();
        AppMethodBeat.o(205984);
    }

    /* access modifiers changed from: package-private */
    public final long gZZ() {
        AppMethodBeat.i(205985);
        n hax = hax();
        long lD = com.tencent.mm.ui.widget.cedit.util.c.lD(hax.QLb, hax.QLc);
        AppMethodBeat.o(205985);
        return lD;
    }

    /* access modifiers changed from: package-private */
    public final void af(boolean z, int i2) {
        boolean z2;
        int i3;
        int i4;
        boolean z3 = false;
        AppMethodBeat.i(205986);
        this.QIJ = SystemClock.uptimeMillis();
        had();
        if (z) {
            int selectionStart = this.QIo.getSelectionStart();
            int selectionEnd = this.QIo.getSelectionEnd();
            boolean z4 = this.QIN && selectionStart == 0 && selectionEnd == this.QIo.getText().length();
            if (!this.QIE || !this.QIo.hasSelection() || z4) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.QJh = z2;
            if (!this.QIE || selectionStart < 0 || selectionEnd < 0) {
                if (this.QIt == null || (i4 = this.QIt.QLb) < 0) {
                    i3 = -1;
                } else {
                    if (i4 > this.QIo.getText().length()) {
                        i4 = this.QIo.getText().length();
                    }
                    i3 = i4;
                }
                if (i3 >= 0) {
                    Selection.setSelection((Spannable) this.QIo.getText(), i3);
                }
                com.tencent.mm.ui.widget.cedit.b.d movementMethod = this.QIo.getMovementMethod();
                if (movementMethod != null) {
                    movementMethod.a(this.QIo, (Spannable) this.QIo.getText(), i2);
                }
                if (this.QIF && selectionStart >= 0 && selectionEnd >= 0) {
                    Selection.setSelection((Spannable) this.QIo.getText(), selectionStart, selectionEnd);
                }
                if (this.QIN) {
                    this.QIo.gZJ();
                }
                this.QIG = true;
            }
            this.QIE = false;
            this.QIF = false;
            haz();
            AppMethodBeat.o(205986);
            return;
        }
        gZQ();
        if (Build.VERSION.SDK_INT >= 24) {
            z3 = this.QIo.isTemporarilyDetached();
        }
        if (z3) {
            hav();
        } else {
            gZE();
        }
        if (this.QIt != null) {
            this.QIt.haN();
        }
        haa();
        AppMethodBeat.o(205986);
    }

    /* access modifiers changed from: package-private */
    public final void haa() {
        AppMethodBeat.i(205987);
        if (!this.QIo.gZD() && this.QIo.hasSelection()) {
            Selection.setSelection((Spannable) this.QIo.getText(), this.QIo.length(), this.QIo.length());
        }
        AppMethodBeat.o(205987);
    }

    /* access modifiers changed from: package-private */
    public final void hab() {
        AppMethodBeat.i(205988);
        hao();
        this.QJn = true;
        gZQ();
        if (this.QIt != null) {
            this.QIt.haN();
        }
        gZE();
        AppMethodBeat.o(205988);
    }

    /* access modifiers changed from: package-private */
    public final void ap(MotionEvent motionEvent) {
        AppMethodBeat.i(205989);
        switch (motionEvent.getActionMasked()) {
            case 2:
                aoA(-1);
                AppMethodBeat.o(205989);
                return;
            case 1:
            case 3:
                hac();
                break;
        }
        AppMethodBeat.o(205989);
    }

    /* access modifiers changed from: package-private */
    public final void aoA(int i2) {
        AppMethodBeat.i(205990);
        this.QIo.removeCallbacks(this.QJp);
        eXP();
        if (this.QIu != null && Build.VERSION.SDK_INT >= 23) {
            this.QIu.hide((long) i2);
        }
        AppMethodBeat.o(205990);
    }

    private void hac() {
        AppMethodBeat.i(205991);
        this.QIo.postDelayed(this.QJp, (long) ViewConfiguration.getDoubleTapTimeout());
        hao().haV();
        AppMethodBeat.o(205991);
    }

    /* access modifiers changed from: package-private */
    public final InputMethodManager getInputMethodManager() {
        AppMethodBeat.i(205992);
        if (Build.VERSION.SDK_INT >= 23) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.QIo.getContext().getSystemService(InputMethodManager.class);
            AppMethodBeat.o(205992);
            return inputMethodManager;
        }
        InputMethodManager inputMethodManager2 = (InputMethodManager) this.QIo.getContext().getSystemService("input_method");
        AppMethodBeat.o(205992);
        return inputMethodManager2;
    }

    public final void beginBatchEdit() {
        AppMethodBeat.i(205993);
        this.QIP = true;
        h hVar = this.QID;
        if (hVar != null) {
            int i2 = hVar.QIp + 1;
            hVar.QIp = i2;
            if (i2 == 1) {
                hVar.QKn = false;
                hVar.QKr = 0;
                if (hVar.mContentChanged) {
                    hVar.QKp = 0;
                    hVar.QKq = this.QIo.getText().length();
                    AppMethodBeat.o(205993);
                    return;
                }
                hVar.QKp = -1;
                hVar.QKq = -1;
                hVar.mContentChanged = false;
            }
        }
        AppMethodBeat.o(205993);
    }

    public final void endBatchEdit() {
        AppMethodBeat.i(205994);
        this.QIP = false;
        h hVar = this.QID;
        if (hVar != null) {
            int i2 = hVar.QIp - 1;
            hVar.QIp = i2;
            if (i2 == 0) {
                a(hVar);
            }
        }
        AppMethodBeat.o(205994);
    }

    /* access modifiers changed from: package-private */
    public final void had() {
        AppMethodBeat.i(205995);
        h hVar = this.QID;
        if (!(hVar == null || hVar.QIp == 0)) {
            hVar.QIp = 0;
            a(hVar);
        }
        AppMethodBeat.o(205995);
    }

    private void a(h hVar) {
        AppMethodBeat.i(205996);
        if (hVar.mContentChanged || hVar.QKo) {
            this.QIo.gZA();
            hae();
        } else if (hVar.QKn) {
            this.QIo.gZs();
        }
        haf();
        if (!ham()) {
            d hax = this.QIo.hasSelection() ? hax() : haw();
            if (hax != null && !hax.isActive() && !hax.haB()) {
                hax.show();
            }
        }
        AppMethodBeat.o(205996);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(ExtractedTextRequest extractedTextRequest, int i2, int i3, int i4, ExtractedText extractedText) {
        int i5;
        int i6;
        int i7;
        AppMethodBeat.i(205997);
        if (extractedTextRequest == null || extractedText == null) {
            AppMethodBeat.o(205997);
            return false;
        }
        CharSequence text = this.QIo.getText();
        if (text == null) {
            AppMethodBeat.o(205997);
            return false;
        }
        if (i2 != -2) {
            int length = text.length();
            if (i2 < 0) {
                extractedText.partialEndOffset = -1;
                extractedText.partialStartOffset = -1;
                i5 = length;
                i7 = 0;
            } else {
                i5 = i3 + i4;
                if (text instanceof Spanned) {
                    Spanned spanned = (Spanned) text;
                    Object[] spans = spanned.getSpans(i2, i5, ParcelableSpan.class);
                    int length2 = spans.length;
                    i6 = i2;
                    while (length2 > 0) {
                        length2--;
                        int spanStart = spanned.getSpanStart(spans[length2]);
                        if (spanStart >= i6) {
                            spanStart = i6;
                        }
                        int spanEnd = spanned.getSpanEnd(spans[length2]);
                        if (spanEnd > i5) {
                            i5 = spanEnd;
                        }
                        i6 = spanStart;
                    }
                } else {
                    i6 = i2;
                }
                extractedText.partialStartOffset = i6;
                extractedText.partialEndOffset = i5 - i4;
                if (i6 > length) {
                    i7 = length;
                } else if (i6 < 0) {
                    i7 = 0;
                } else {
                    i7 = i6;
                }
                if (i5 > length) {
                    i5 = length;
                } else if (i5 < 0) {
                    i5 = 0;
                }
            }
            if ((extractedTextRequest.flags & 1) != 0) {
                extractedText.text = text.subSequence(i7, i5);
            } else {
                extractedText.text = TextUtils.substring(text, i7, i5);
            }
        } else {
            extractedText.partialStartOffset = 0;
            extractedText.partialEndOffset = 0;
            extractedText.text = "";
        }
        extractedText.flags = 0;
        if (MetaKeyKeyListener.getMetaState(text, 2048) != 0) {
            extractedText.flags |= 2;
        }
        if (this.QIo.OSP) {
            extractedText.flags |= 1;
        }
        extractedText.startOffset = 0;
        extractedText.selectionStart = this.QIo.getSelectionStart();
        extractedText.selectionEnd = this.QIo.getSelectionEnd();
        if (Build.VERSION.SDK_INT >= 28) {
            extractedText.hint = this.QIo.getHint();
        }
        AppMethodBeat.o(205997);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean hae() {
        AppMethodBeat.i(205998);
        h hVar = this.QID;
        if (hVar == null) {
            AppMethodBeat.o(205998);
            return false;
        }
        boolean z = hVar.mContentChanged;
        if (z || hVar.QKo) {
            hVar.mContentChanged = false;
            hVar.QKo = false;
            ExtractedTextRequest extractedTextRequest = hVar.QKl;
            if (extractedTextRequest == null) {
                AppMethodBeat.o(205998);
                return false;
            }
            InputMethodManager inputMethodManager = getInputMethodManager();
            if (inputMethodManager == null) {
                AppMethodBeat.o(205998);
                return false;
            }
            if (hVar.QKp < 0 && !z) {
                hVar.QKp = -2;
            }
            if (a(extractedTextRequest, hVar.QKp, hVar.QKq, hVar.QKr, hVar.QKm)) {
                inputMethodManager.updateExtractedText(this.QIo, extractedTextRequest.token, hVar.QKm);
                hVar.QKp = -1;
                hVar.QKq = -1;
                hVar.QKr = 0;
                hVar.mContentChanged = false;
                AppMethodBeat.o(205998);
                return true;
            }
            AppMethodBeat.o(205998);
            return false;
        }
        AppMethodBeat.o(205998);
        return false;
    }

    private void haf() {
        InputMethodManager inputMethodManager;
        int i2;
        int i3;
        AppMethodBeat.i(205999);
        if (!(this.QID == null || this.QID.QIp > 0 || (inputMethodManager = getInputMethodManager()) == null)) {
            int selectionStart = this.QIo.getSelectionStart();
            int selectionEnd = this.QIo.getSelectionEnd();
            if (this.QIo.getText() instanceof Spannable) {
                Spannable spannable = (Spannable) this.QIo.getText();
                i3 = a.getComposingSpanStart(spannable);
                i2 = a.getComposingSpanEnd(spannable);
            } else {
                i2 = -1;
                i3 = -1;
            }
            inputMethodManager.updateSelection(this.QIo, selectionStart, selectionEnd, i3, i2);
        }
        AppMethodBeat.o(205999);
    }

    /* access modifiers changed from: package-private */
    public final void hag() {
        AppMethodBeat.i(206000);
        if (this.QIt != null) {
            this.QIt.haR();
        }
        if (this.QIs != null) {
            this.QIs.haK();
        }
        if (!ham()) {
            han();
        }
        AppMethodBeat.o(206000);
    }

    /* access modifiers changed from: package-private */
    public final void hah() {
        AppMethodBeat.i(206001);
        haA();
        if (this.QIY == null) {
            AppMethodBeat.o(206001);
            return;
        }
        Layout layout = this.QIo.getLayout();
        int selectionStart = this.QIo.getSelectionStart();
        int lineForOffset = layout.getLineForOffset(selectionStart);
        g(layout.getLineTop(lineForOffset), layout.getLineBottom(lineForOffset), layout.getPrimaryHorizontal(selectionStart));
        AppMethodBeat.o(206001);
    }

    /* access modifiers changed from: package-private */
    public final void hai() {
        AppMethodBeat.i(206002);
        if (has()) {
            this.QIS = false;
            AppMethodBeat.o(206002);
            return;
        }
        boolean hasSelection = this.QIo.hasSelection();
        n hax = hax();
        j haw = haw();
        if ((hax == null || !hax.haB()) && (haw == null || !haw.haB())) {
            if (hasSelection) {
                gZQ();
                if (ham()) {
                    if (this.QIS) {
                        hao().haU();
                    }
                } else if (hax == null || !hax.isActive()) {
                    hav();
                    hao().haU();
                } else {
                    if (Build.VERSION.SDK_INT >= 23 && this.QIu != null) {
                        this.QIu.invalidateContentRect();
                    }
                    hac();
                }
            } else if (haw == null || !haw.isActive()) {
                gZE();
            } else if (this.QIu != null && Build.VERSION.SDK_INT >= 23) {
                this.QIu.invalidateContentRect();
            }
            this.QIS = false;
            AppMethodBeat.o(206002);
            return;
        }
        this.QIS = false;
        AppMethodBeat.o(206002);
    }

    /* access modifiers changed from: package-private */
    public final void haj() {
        AppMethodBeat.i(206003);
        if (this.QJk != null) {
            this.QIo.removeCallbacks(this.QJk);
        }
        if (has()) {
            AppMethodBeat.o(206003);
            return;
        }
        gZE();
        if (Build.VERSION.SDK_INT >= 23) {
            new o(1);
        }
        hak();
        if (!ham() && haw() != null) {
            haw().show();
        }
        AppMethodBeat.o(206003);
    }

    /* access modifiers changed from: package-private */
    public final void hak() {
        AppMethodBeat.i(206004);
        if (this.QJx == null) {
            this.QJx = new com.tencent.mm.ui.widget.cedit.a.a(this.QIo);
        }
        this.QJx.show();
        this.QJy = true;
        AppMethodBeat.o(206004);
    }

    private void hal() {
        AppMethodBeat.i(206005);
        if (this.QJx != null) {
            com.tencent.mm.ui.widget.cedit.a.a aVar = this.QJx;
            try {
                Log.i("cmEdit.OperateWindow", "destroy OpWindow@%s", Integer.valueOf(aVar.hashCode()));
                aVar.dismiss();
                aVar.qQv.setContentView(null);
                aVar.QLB = true;
            } catch (Throwable th) {
            }
        }
        this.QJy = false;
        AppMethodBeat.o(206005);
    }

    private void eXP() {
        AppMethodBeat.i(206006);
        if (this.QJx != null) {
            this.QJx.dismiss();
        }
        AppMethodBeat.o(206006);
    }

    public final boolean ham() {
        return this.QIu == null && !this.QJy;
    }

    /* access modifiers changed from: package-private */
    public final void han() {
        AppMethodBeat.i(206007);
        if (this.QIu != null) {
            this.QIu.invalidate();
        }
        AppMethodBeat.o(206007);
    }

    /* access modifiers changed from: package-private */
    public final d hao() {
        AppMethodBeat.i(206008);
        if (this.QIU == null) {
            this.QIU = new d(this);
        }
        d dVar = this.QIU;
        AppMethodBeat.o(206008);
        return dVar;
    }

    private boolean hap() {
        AppMethodBeat.i(206009);
        if (this.QJk != null) {
            this.QIo.removeCallbacks(this.QJk);
        }
        if (has()) {
            AppMethodBeat.o(206009);
            return false;
        } else if (!haq()) {
            AppMethodBeat.o(206009);
            return false;
        } else if (this.QIo.hasSelection() || gZU()) {
            hav();
            hax().aoC(2);
            AppMethodBeat.o(206009);
            return true;
        } else {
            AppMethodBeat.o(206009);
            return false;
        }
    }

    private boolean haq() {
        AppMethodBeat.i(206010);
        if (!this.QIo.gZC() || !this.QIo.requestFocus()) {
            Log.w("cmEdit.CMTextView", "TextView does not support text selection. Selection cancelled.");
            AppMethodBeat.o(206010);
            return false;
        }
        AppMethodBeat.o(206010);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean har() {
        InputMethodManager inputMethodManager;
        AppMethodBeat.i(206011);
        if (has()) {
            AppMethodBeat.o(206011);
            return false;
        } else if (this.QIu != null) {
            han();
            AppMethodBeat.o(206011);
            return false;
        } else if (!haq() || !this.QIo.hasSelection()) {
            AppMethodBeat.o(206011);
            return false;
        } else {
            if (Build.VERSION.SDK_INT >= 23) {
                new o(0);
            }
            hak();
            this.QIo.gZB();
            if ((!ham()) && this.QIo.gZB() && !this.QIo.isTextSelectable() && this.QIQ && (inputMethodManager = getInputMethodManager()) != null) {
                inputMethodManager.showSoftInput(this.QIo, 0, null);
            }
            AppMethodBeat.o(206011);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean has() {
        AppMethodBeat.i(206012);
        InputMethodManager inputMethodManager = getInputMethodManager();
        if (inputMethodManager == null || !inputMethodManager.isFullscreenMode()) {
            AppMethodBeat.o(206012);
            return false;
        }
        AppMethodBeat.o(206012);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean hat() {
        SuggestionSpan[] suggestionSpanArr;
        AppMethodBeat.i(206013);
        for (SuggestionSpan suggestionSpan : (SuggestionSpan[]) ((Spannable) this.QIo.getText()).getSpans(this.QIo.getSelectionStart(), this.QIo.getSelectionEnd(), SuggestionSpan.class)) {
            if ((suggestionSpan.getFlags() & 1) != 0) {
                AppMethodBeat.o(206013);
                return true;
            }
        }
        AppMethodBeat.o(206013);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void aq(MotionEvent motionEvent) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(206014);
        hao();
        this.QIo.getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
        if (!this.QIN || !this.QIo.didTouchFocusSelect()) {
            z = false;
        } else {
            z = true;
        }
        gZQ();
        gZE();
        CharSequence text = this.QIo.getText();
        if (!z && text.length() > 0) {
            int offsetForPosition = this.QIo.getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
            if (this.QIT) {
                z2 = false;
            }
            if (z2) {
                Selection.setSelection((Spannable) text, offsetForPosition);
            }
            if (!has()) {
                if (hat()) {
                    if (this.QJk != null) {
                        this.QIo.removeCallbacks(this.QJk);
                        AppMethodBeat.o(206014);
                        return;
                    }
                } else if (this.QIv) {
                    if (z2) {
                        haw().show();
                        AppMethodBeat.o(206014);
                        return;
                    }
                    haw().hide();
                }
            }
        }
        AppMethodBeat.o(206014);
    }

    /* access modifiers changed from: protected */
    public final void gZE() {
        AppMethodBeat.i(206015);
        if (this.QIu != null) {
            this.QIu.finish();
        }
        this.QIo.removeCallbacks(this.QJp);
        if (this.QJy) {
            hau();
        }
        AppMethodBeat.o(206015);
    }

    private void hau() {
        AppMethodBeat.i(206016);
        hao();
        this.QIu = null;
        hal();
        if (!this.QIR) {
            Selection.setSelection((Spannable) this.QIo.getText(), this.QIo.getSelectionEnd());
        }
        if (this.QIt != null) {
            this.QIt.hide();
        }
        this.QIT = false;
        AppMethodBeat.o(206016);
    }

    /* access modifiers changed from: package-private */
    public final void hav() {
        AppMethodBeat.i(206017);
        if (!ham()) {
            this.QIS = true;
        }
        this.QIR = true;
        gZE();
        this.QIR = false;
        AppMethodBeat.o(206017);
    }

    public final j haw() {
        AppMethodBeat.i(206018);
        if (!this.QIv) {
            AppMethodBeat.o(206018);
            return null;
        }
        if (this.QIs == null) {
            this.QIs = new j();
            this.QIo.getViewTreeObserver().addOnTouchModeChangeListener(this.QIs);
        }
        j jVar = this.QIs;
        AppMethodBeat.o(206018);
        return jVar;
    }

    public final n hax() {
        AppMethodBeat.i(206019);
        if (!this.QIw) {
            AppMethodBeat.o(206019);
            return null;
        }
        if (this.QIt == null) {
            this.QIt = new n();
            this.QIo.getViewTreeObserver().addOnTouchModeChangeListener(this.QIt);
        }
        n nVar = this.QIt;
        AppMethodBeat.o(206019);
        return nVar;
    }

    private void g(int i2, int i3, float f2) {
        AppMethodBeat.i(206020);
        haA();
        int a2 = a(this.QIY, f2);
        this.QIY.setBounds(a2, i2 - this.mTempRect.top, this.QIY.getIntrinsicWidth() + a2, this.mTempRect.bottom + i3);
        AppMethodBeat.o(206020);
    }

    /* access modifiers changed from: package-private */
    public final int a(Drawable drawable, float f2) {
        int i2;
        AppMethodBeat.i(206021);
        float max = Math.max(0.5f, f2 - 0.5f);
        if (this.mTempRect == null) {
            this.mTempRect = new Rect();
        }
        int i3 = 0;
        if (drawable != null) {
            drawable.getPadding(this.mTempRect);
            i3 = drawable.getIntrinsicWidth();
        } else {
            this.mTempRect.setEmpty();
        }
        int scrollX = this.QIo.getScrollX();
        float f3 = max - ((float) scrollX);
        int width = (this.QIo.getWidth() - this.QIo.getCompoundPaddingLeft()) - this.QIo.getCompoundPaddingRight();
        if (f3 >= ((float) width) - 1.0f) {
            i2 = (width + scrollX) - (i3 - this.mTempRect.right);
        } else if (Math.abs(f3) <= 1.0f || (TextUtils.isEmpty(this.QIo.getText()) && ((float) (1048576 - scrollX)) <= ((float) width) + 1.0f && max <= 1.0f)) {
            i2 = scrollX - this.mTempRect.left;
        } else {
            i2 = ((int) max) - this.mTempRect.left;
        }
        AppMethodBeat.o(206021);
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final boolean hay() {
        AppMethodBeat.i(206022);
        if (!isCursorVisible() || !this.QIo.isFocused()) {
            AppMethodBeat.o(206022);
            return false;
        }
        int selectionStart = this.QIo.getSelectionStart();
        if (selectionStart < 0) {
            AppMethodBeat.o(206022);
            return false;
        }
        int selectionEnd = this.QIo.getSelectionEnd();
        if (selectionEnd < 0) {
            AppMethodBeat.o(206022);
            return false;
        } else if (selectionStart == selectionEnd) {
            AppMethodBeat.o(206022);
            return true;
        } else {
            AppMethodBeat.o(206022);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void haz() {
        AppMethodBeat.i(206023);
        if (hay()) {
            this.QIJ = SystemClock.uptimeMillis();
            if (this.QIL == null) {
                this.QIL = new a(this, (byte) 0);
            }
            this.QIo.removeCallbacks(this.QIL);
            this.QIo.postDelayed(this.QIL, 500);
            AppMethodBeat.o(206023);
            return;
        }
        if (this.QIL != null) {
            this.QIo.removeCallbacks(this.QIL);
        }
        AppMethodBeat.o(206023);
    }

    /* access modifiers changed from: package-private */
    public class a implements Runnable {
        boolean mCancelled;

        private a() {
        }

        /* synthetic */ a(b bVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(205879);
            if (this.mCancelled) {
                AppMethodBeat.o(205879);
                return;
            }
            b.this.QIo.removeCallbacks(this);
            if (b.this.hay()) {
                if (b.this.QIo.getLayout() != null) {
                    b.this.QIo.gZr();
                }
                b.this.QIo.postDelayed(this, 500);
            }
            AppMethodBeat.o(205879);
        }

        /* access modifiers changed from: package-private */
        public final void cancel() {
            AppMethodBeat.i(205880);
            if (!this.mCancelled) {
                b.this.QIo.removeCallbacks(this);
                this.mCancelled = true;
            }
            AppMethodBeat.o(205880);
        }
    }

    /* access modifiers changed from: package-private */
    public static class e {
        public CustomTextView QJE;
        public int end;
        public int start;

        public e(CustomTextView customTextView, int i2, int i3) {
            this.QJE = customTextView;
            this.start = i2;
            this.end = i3;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(DragEvent dragEvent) {
        boolean z = true;
        AppMethodBeat.i(206024);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        this.QIo.beginBatchEdit();
        try {
            int offsetForPosition = this.QIo.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
            Object localState = dragEvent.getLocalState();
            e eVar = null;
            if (localState instanceof e) {
                eVar = (e) localState;
            }
            if (eVar == null || eVar.QJE != this.QIo) {
                z = false;
            }
            if (!z || offsetForPosition < eVar.start || offsetForPosition >= eVar.end) {
                int length = this.QIo.getText().length();
                Selection.setSelection((Spannable) this.QIo.getText(), offsetForPosition);
                ((Editable) this.QIo.mText).replace(offsetForPosition, offsetForPosition, spannableStringBuilder);
                if (z) {
                    int i2 = eVar.start;
                    int i3 = eVar.end;
                    if (offsetForPosition <= i2) {
                        int length2 = this.QIo.getText().length() - length;
                        i2 += length2;
                        i3 += length2;
                    }
                    this.QIo.lB(i2, i3);
                    int max = Math.max(0, i2 - 1);
                    int min = Math.min(this.QIo.getText().length(), i2 + 1);
                    if (min > max + 1) {
                        CharSequence lA = this.QIo.lA(max, min);
                        if (Character.isSpaceChar(lA.charAt(0)) && Character.isSpaceChar(lA.charAt(1))) {
                            this.QIo.lB(max, max + 1);
                        }
                    }
                }
                this.QIo.endBatchEdit();
                AppMethodBeat.o(206024);
            }
        } finally {
            this.QIo.endBatchEdit();
            AppMethodBeat.o(206024);
        }
    }

    /* access modifiers changed from: package-private */
    public final void aA(float f2, float f3) {
        this.QJd = f2;
        this.QJe = f3;
    }

    /* access modifiers changed from: package-private */
    public class l implements ViewTreeObserver.OnPreDrawListener {
        int QJI;
        int QJJ;
        private boolean QJW;
        private p[] QKL;
        private boolean[] QKM;
        int QKN;
        int QKO;
        private int QKP;
        boolean QKQ;
        final int[] QKR;

        private l() {
            AppMethodBeat.i(205919);
            this.QKL = new p[7];
            this.QKM = new boolean[7];
            this.QJW = true;
            this.QKR = new int[2];
            AppMethodBeat.o(205919);
        }

        /* synthetic */ l(b bVar, byte b2) {
            this();
        }

        public final void a(p pVar, boolean z) {
            AppMethodBeat.i(205920);
            if (this.QKP == 0) {
                updatePosition();
                b.this.QIo.getViewTreeObserver().addOnPreDrawListener(this);
            }
            int i2 = -1;
            for (int i3 = 0; i3 < 7; i3++) {
                p pVar2 = this.QKL[i3];
                if (pVar2 == pVar) {
                    AppMethodBeat.o(205920);
                    return;
                }
                if (i2 < 0 && pVar2 == null) {
                    i2 = i3;
                }
            }
            this.QKL[i2] = pVar;
            this.QKM[i2] = z;
            this.QKP++;
            AppMethodBeat.o(205920);
        }

        public final void c(p pVar) {
            AppMethodBeat.i(205921);
            int i2 = 0;
            while (true) {
                if (i2 >= 7) {
                    break;
                } else if (this.QKL[i2] == pVar) {
                    this.QKL[i2] = null;
                    this.QKP--;
                    break;
                } else {
                    i2++;
                }
            }
            if (this.QKP == 0) {
                b.this.QIo.getViewTreeObserver().removeOnPreDrawListener(this);
            }
            AppMethodBeat.o(205921);
        }

        public final boolean onPreDraw() {
            p pVar;
            AppMethodBeat.i(205922);
            updatePosition();
            for (int i2 = 0; i2 < 7; i2++) {
                if ((this.QJW || this.QKQ || this.QKM[i2]) && (pVar = this.QKL[i2]) != null) {
                    pVar.i(this.QJI, this.QJJ, this.QJW, this.QKQ);
                }
            }
            this.QKQ = false;
            AppMethodBeat.o(205922);
            return true;
        }

        private void updatePosition() {
            AppMethodBeat.i(205923);
            b.this.QIo.getLocationInWindow(this.QKR);
            this.QJW = (this.QKR[0] == this.QJI && this.QKR[1] == this.QJJ) ? false : true;
            this.QJI = this.QKR[0];
            this.QJJ = this.QKR[1];
            b.this.QIo.getLocationOnScreen(this.QKR);
            this.QKN = this.QKR[0];
            this.QKO = this.QKR[1];
            AppMethodBeat.o(205923);
        }
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"NewApi"})
    public class o extends ActionMode.Callback2 {
        private final Path QLj = new Path();
        private final RectF QLk = new RectF();
        private final boolean QLl;
        private final int QLm;
        private final Map<MenuItem, View.OnClickListener> QLn = new HashMap();

        o(int i2) {
            AppMethodBeat.i(205958);
            this.QLl = i2 == 0 || (b.this.QIO && i2 == 2);
            if (this.QLl) {
                n hax = b.this.hax();
                if (hax.QKZ == null) {
                    b.this.CZ(false);
                    n.b(hax);
                    hax.hide();
                }
                this.QLm = Math.max(b.this.QIZ.getMinimumHeight(), b.this.QJa.getMinimumHeight());
                AppMethodBeat.o(205958);
                return;
            }
            j haw = b.this.haw();
            if (haw != null) {
                haw.haJ();
                this.QLm = b.this.QJb.getMinimumHeight();
                AppMethodBeat.o(205958);
                return;
            }
            this.QLm = 0;
            AppMethodBeat.o(205958);
        }

        public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            AppMethodBeat.i(205959);
            this.QLn.clear();
            actionMode.setTitle((CharSequence) null);
            actionMode.setSubtitle((CharSequence) null);
            actionMode.setTitleOptionalHint(true);
            if (b.this.QIo.gZF()) {
                menu.add(0, 16908320, 4, 17039363).setAlphabeticShortcut('x').setShowAsAction(2);
            }
            if (b.this.QIo.gZG()) {
                menu.add(0, 16908321, 5, 17039361).setAlphabeticShortcut('c').setShowAsAction(2);
            }
            if (b.this.QIo.gZH()) {
                menu.add(0, 16908322, 6, 17039371).setAlphabeticShortcut('v').setShowAsAction(2);
            }
            f(menu);
            ActionMode.Callback haS = haS();
            if (haS == null || haS.onCreateActionMode(actionMode, menu)) {
                if (this.QLl && !b.this.QIo.hasTransientState()) {
                    b.this.QIo.setHasTransientState(true);
                }
                AppMethodBeat.o(205959);
                return true;
            }
            Selection.setSelection((Spannable) b.this.QIo.getText(), b.this.QIo.getSelectionEnd());
            AppMethodBeat.o(205959);
            return false;
        }

        private ActionMode.Callback haS() {
            return this.QLl ? b.this.QJf : b.this.QJg;
        }

        public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            AppMethodBeat.i(205960);
            f(menu);
            ActionMode.Callback haS = haS();
            if (haS != null) {
                boolean onPrepareActionMode = haS.onPrepareActionMode(actionMode, menu);
                AppMethodBeat.o(205960);
                return onPrepareActionMode;
            }
            AppMethodBeat.o(205960);
            return true;
        }

        private void f(Menu menu) {
            AppMethodBeat.i(205961);
            boolean gZI = b.this.QIo.gZI();
            boolean z = menu.findItem(16908319) != null;
            if (!gZI || z) {
                if (!gZI && z) {
                    menu.removeItem(16908319);
                }
                AppMethodBeat.o(205961);
                return;
            }
            menu.add(0, 16908319, 8, 17039373).setShowAsAction(1);
            AppMethodBeat.o(205961);
        }

        public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            AppMethodBeat.i(205962);
            b.this.hao();
            menuItem.getItemId();
            menuItem.getTitle().toString();
            ActionMode.Callback haS = haS();
            if (haS != null && haS.onActionItemClicked(actionMode, menuItem)) {
                AppMethodBeat.o(205962);
                return true;
            } else if (menuItem.getGroupId() == 16908353) {
                com.tencent.mm.ui.widget.cedit.util.b.checkArgument(menuItem.getGroupId() == 16908353);
                b.this.hao();
                AppMethodBeat.o(205962);
                return true;
            } else {
                boolean onTextContextMenuItem = b.this.QIo.onTextContextMenuItem(menuItem.getItemId());
                AppMethodBeat.o(205962);
                return onTextContextMenuItem;
            }
        }

        public final void onDestroyActionMode(ActionMode actionMode) {
            AppMethodBeat.i(205963);
            b.this.hao();
            b.this.QIu = null;
            ActionMode.Callback haS = haS();
            if (haS != null) {
                haS.onDestroyActionMode(actionMode);
            }
            if (!b.this.QIR) {
                Selection.setSelection((Spannable) b.this.QIo.getText(), b.this.QIo.getSelectionEnd());
            }
            if (b.this.QIt != null) {
                b.this.QIt.hide();
            }
            this.QLn.clear();
            b.this.QIT = false;
            AppMethodBeat.o(205963);
        }

        public final void onGetContentRect(ActionMode actionMode, View view, Rect rect) {
            AppMethodBeat.i(205964);
            Log.i("cmEdit.Editor", "onGetContentRect mode:" + actionMode + ",view:" + view + ",outRect:" + rect);
            if (!view.equals(b.this.QIo) || b.this.QIo.getLayout() == null) {
                super.onGetContentRect(actionMode, view, rect);
                AppMethodBeat.o(205964);
                return;
            }
            if (b.this.QIo.getSelectionStart() != b.this.QIo.getSelectionEnd()) {
                this.QLj.reset();
                b.this.QIo.getLayout().getSelectionPath(b.this.QIo.getSelectionStart(), b.this.QIo.getSelectionEnd(), this.QLj);
                this.QLj.computeBounds(this.QLk, true);
                this.QLk.bottom += (float) this.QLm;
            } else {
                Layout layout = b.this.QIo.getLayout();
                int lineForOffset = layout.getLineForOffset(b.this.QIo.getSelectionStart());
                float a2 = (float) b.this.a((Drawable) null, layout.getPrimaryHorizontal(b.this.QIo.getSelectionStart()));
                this.QLk.set(a2, (float) layout.getLineTop(lineForOffset), a2, (float) (layout.getLineBottom(lineForOffset) + this.QLm));
            }
            int gZy = b.this.QIo.gZy();
            int gZz = b.this.QIo.gZz();
            rect.set((int) Math.floor((double) (this.QLk.left + ((float) gZy))), (int) Math.floor((double) (this.QLk.top + ((float) gZz))), (int) Math.ceil((double) (((float) gZy) + this.QLk.right)), (int) Math.ceil((double) (((float) gZz) + this.QLk.bottom)));
            AppMethodBeat.o(205964);
        }
    }

    final class c implements p {
        final CursorAnchorInfo.Builder QJB;
        final int[] QJC;
        final Matrix QJD;

        private c() {
            AppMethodBeat.i(205883);
            this.QJB = new CursorAnchorInfo.Builder();
            this.QJC = new int[2];
            this.QJD = new Matrix();
            AppMethodBeat.o(205883);
        }

        /* synthetic */ c(b bVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.ui.widget.cedit.edit.b.p
        public final void i(int i2, int i3, boolean z, boolean z2) {
            AppMethodBeat.i(205884);
            h hVar = b.this.QID;
            if (hVar == null || hVar.QIp > 0) {
                AppMethodBeat.o(205884);
                return;
            }
            InputMethodManager inputMethodManager = b.this.getInputMethodManager();
            if (inputMethodManager == null) {
                AppMethodBeat.o(205884);
            } else if (!inputMethodManager.isActive(b.this.QIo)) {
                AppMethodBeat.o(205884);
            } else {
                AppMethodBeat.o(205884);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class k {
        final Magnifier QKE;
        boolean QKF;
        float QKG;
        float QKH;
        float QKI;
        float QKJ;
        final ValueAnimator dgN;
        float riK;
        float riL;

        /* synthetic */ k(Magnifier magnifier, byte b2) {
            this(magnifier);
        }

        private k(Magnifier magnifier) {
            AppMethodBeat.i(205917);
            this.QKE = magnifier;
            this.dgN = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.dgN.setDuration(100L);
            this.dgN.setInterpolator(new LinearInterpolator());
            this.dgN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.ui.widget.cedit.edit.b.k.AnonymousClass1 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(205916);
                    k.this.QKI = k.this.QKG + ((k.this.riK - k.this.QKG) * valueAnimator.getAnimatedFraction());
                    k.this.QKJ = k.this.QKH + ((k.this.riL - k.this.QKH) * valueAnimator.getAnimatedFraction());
                    if (Build.VERSION.SDK_INT >= 28) {
                        k.this.QKE.show(k.this.QKI, k.this.QKJ);
                    }
                    AppMethodBeat.o(205916);
                }
            });
            AppMethodBeat.o(205917);
        }

        /* access modifiers changed from: package-private */
        public final void dismiss() {
            AppMethodBeat.i(205918);
            if (Build.VERSION.SDK_INT >= 28) {
                this.QKE.dismiss();
            }
            this.dgN.cancel();
            this.QKF = false;
            AppMethodBeat.o(205918);
        }
    }

    public abstract class f extends View implements p {
        protected int AiE;
        private int DAQ;
        protected Drawable QJF;
        protected Drawable QJG;
        private final PopupWindow QJH;
        private int QJI;
        private int QJJ;
        private int QJK;
        private int QJL;
        private float QJM;
        private float QJN;
        protected int QJO;
        protected int QJP;
        private float QJQ;
        private final float QJR;
        private int QJS;
        private int QJT;
        private int QJU;
        private int QJV;
        private boolean QJW;
        protected int QJX;
        protected int QJY;
        private float QJZ;
        private float QKa;
        private float QKb;
        private final int QKc;
        private final long[] QKd;
        private final int[] QKe;
        private int QKf;
        int QKg;
        private int irF;
        protected Drawable mDrawable;
        boolean okz;

        /* access modifiers changed from: protected */
        public abstract int Dc(boolean z);

        /* access modifiers changed from: protected */
        public abstract void Gn(int i2);

        /* access modifiers changed from: protected */
        public abstract int c(Drawable drawable, boolean z);

        /* access modifiers changed from: protected */
        public abstract void g(float f2, float f3, boolean z);

        public abstract int getCurrentCursorOffset();

        /* access modifiers changed from: protected */
        public abstract int getMagnifierHandleTrigger();

        /* synthetic */ f(b bVar, Drawable drawable, Drawable drawable2, int i2, byte b2) {
            this(drawable, drawable2, i2);
        }

        private f(Drawable drawable, Drawable drawable2, int i2) {
            super(b.this.QIo.getContext());
            this.AiE = -1;
            this.QJW = true;
            this.QJX = -1;
            this.QJY = -1;
            this.QJZ = -1.0f;
            this.QKd = new long[5];
            this.QKe = new int[5];
            this.QKf = 0;
            this.QKg = 0;
            this.irF = at.fromDPToPix(getContext(), 18);
            setId(i2);
            this.QJH = new PopupWindow(b.this.QIo.getContext(), (AttributeSet) null, (int) R.style.rq);
            this.QJH.setSplitTouchEnabled(true);
            this.QJH.setClippingEnabled(false);
            android.support.v4.widget.n.a(this.QJH, 1002);
            this.QJH.setWidth(-2);
            this.QJH.setHeight(-2);
            this.QJH.setContentView(this);
            b(drawable, drawable2);
            this.DAQ = b.this.QIo.getContext().getResources().getDimensionPixelSize(R.dimen.am_);
            int preferredHeight = getPreferredHeight();
            this.QJQ = -0.3f * ((float) preferredHeight);
            this.QJR = ((float) preferredHeight) * 0.7f;
            this.QKc = (int) (this.QJR - this.QJQ);
        }

        public float getIdealVerticalOffset() {
            return this.QJR;
        }

        /* access modifiers changed from: package-private */
        public final int getIdealFingerToCursorOffset() {
            return this.QKc;
        }

        /* access modifiers changed from: package-private */
        public final void b(Drawable drawable, Drawable drawable2) {
            this.QJF = drawable;
            this.QJG = drawable2;
            Db(true);
        }

        /* access modifiers changed from: protected */
        public void Db(boolean z) {
            Layout layout;
            if ((z || !this.okz) && (layout = b.this.QIo.getLayout()) != null) {
                int currentCursorOffset = getCurrentCursorOffset();
                boolean a2 = a(layout, currentCursorOffset);
                Drawable drawable = this.mDrawable;
                this.mDrawable = a2 ? this.QJG : this.QJF;
                this.QJO = c(this.mDrawable, a2);
                this.QJP = Dc(a2);
                if (drawable != this.mDrawable && isShowing()) {
                    this.QJI = ((c(layout, currentCursorOffset) - this.QJO) - getHorizontalOffset()) + getCursorOffset();
                    this.QJI += b.this.QIo.gZy();
                    this.QJW = true;
                    i(this.QJS, this.QJT, false, false);
                    postInvalidate();
                }
            }
        }

        private void aoB(int i2) {
            this.QKf = (this.QKf + 1) % 5;
            this.QKe[this.QKf] = i2;
            this.QKd[this.QKf] = SystemClock.uptimeMillis();
            this.QKg++;
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i2, int i3) {
            setMeasuredDimension(getPreferredWidth(), getPreferredHeight());
        }

        public void invalidate() {
            super.invalidate();
            if (isShowing()) {
                m(getCurrentCursorOffset(), true, false);
            }
        }

        /* access modifiers changed from: protected */
        public final int getPreferredWidth() {
            return Math.max(getDrawWidth(), this.DAQ);
        }

        /* access modifiers changed from: protected */
        public final int getPreferredHeight() {
            return Math.max(getDrawWidth(), this.DAQ);
        }

        public void show() {
            if (!isShowing()) {
                b.this.gZW().a(this, true);
                this.AiE = -1;
                m(getCurrentCursorOffset(), false, false);
            }
        }

        /* access modifiers changed from: protected */
        public void dismiss() {
            this.okz = false;
            this.QJH.dismiss();
            onDetached();
        }

        public final void hide() {
            dismiss();
            b.this.gZW().c(this);
        }

        public boolean isShowing() {
            return this.QJH.isShowing();
        }

        private boolean haC() {
            if (this.okz) {
                return true;
            }
            if (b.this.QIo.gZK()) {
                return false;
            }
            return b.this.QIo.ay((float) (this.QJI + this.QJO + getHorizontalOffset()), (float) this.QJJ);
        }

        private void setVisible(boolean z) {
            this.QJH.getContentView().setVisibility(z ? 0 : 4);
        }

        /* access modifiers changed from: protected */
        public boolean a(Layout layout, int i2) {
            return layout.isRtlCharAt(i2);
        }

        public float b(Layout layout, int i2) {
            return layout.getPrimaryHorizontal(i2);
        }

        /* access modifiers changed from: protected */
        public int b(Layout layout, int i2, float f2) {
            return b.this.QIo.B(i2, f2);
        }

        /* access modifiers changed from: protected */
        public void m(int i2, boolean z, boolean z2) {
            if (b.this.QIo.getLayout() == null) {
                b.this.gZP();
                return;
            }
            Layout layout = b.this.QIo.getLayout();
            boolean z3 = i2 != this.AiE;
            if (z3 || z) {
                if (z3) {
                    Gn(i2);
                    if (z2 && b.this.QIx) {
                        b.this.QIo.performHapticFeedback(9);
                    }
                    aoB(i2);
                }
                int lineForOffset = layout.getLineForOffset(i2);
                this.QJX = lineForOffset;
                this.QJI = ((c(layout, i2) - this.QJO) - getHorizontalOffset()) + getCursorOffset();
                this.QJJ = layout.getLineBottom(lineForOffset);
                this.QJI += b.this.QIo.gZy();
                this.QJJ += b.this.QIo.gZz();
                this.AiE = i2;
                this.QJW = true;
            }
        }

        /* access modifiers changed from: package-private */
        public int c(Layout layout, int i2) {
            return (int) (b(layout, i2) - 0.5f);
        }

        @Override // com.tencent.mm.ui.widget.cedit.edit.b.p
        public final void i(int i2, int i3, boolean z, boolean z2) {
            m(getCurrentCursorOffset(), z2, false);
            if (z || this.QJW) {
                if (this.okz) {
                    if (!(i2 == this.QJS && i3 == this.QJT)) {
                        this.QJM += (float) (i2 - this.QJS);
                        this.QJN += (float) (i3 - this.QJT);
                        this.QJS = i2;
                        this.QJT = i3;
                    }
                    haF();
                }
                if (haC()) {
                    int i4 = this.QJI + i2;
                    int i5 = this.QJJ + i3;
                    this.QJK = i4;
                    this.QJL = i5;
                    if (isShowing()) {
                        this.QJH.update(i4, i5, -1, -1);
                    } else {
                        this.QJH.showAtLocation(b.this.QIo, 0, i4, i5);
                    }
                } else if (isShowing()) {
                    dismiss();
                }
                this.QJW = false;
            }
        }

        public void setTargetWidth(int i2) {
            this.irF = i2;
        }

        private int getDrawWidth() {
            return this.mDrawable.getIntrinsicWidth();
        }

        private int getDrawHeight() {
            return this.mDrawable.getIntrinsicHeight();
        }

        /* access modifiers changed from: protected */
        public void onDraw(Canvas canvas) {
            int drawWidth = getDrawWidth();
            int drawHeight = getDrawHeight();
            int horizontalOffset = getHorizontalOffset();
            this.mDrawable.setBounds(horizontalOffset, 0, drawWidth + horizontalOffset, drawHeight);
            this.mDrawable.draw(canvas);
        }

        private int getHorizontalOffset() {
            int preferredWidth = getPreferredWidth();
            int drawWidth = getDrawWidth();
            switch (this.QJP) {
                case 3:
                    return 0;
                case 4:
                default:
                    return (preferredWidth - drawWidth) / 2;
                case 5:
                    return preferredWidth - drawWidth;
            }
        }

        /* access modifiers changed from: protected */
        public int getCursorOffset() {
            return 0;
        }

        private boolean haD() {
            if (b.this.QIy.QKF) {
                return true;
            }
            if (!(b.this.QIo.getRotation() == 0.0f && b.this.QIo.getRotationX() == 0.0f && b.this.QIo.getRotationY() == 0.0f)) {
                return false;
            }
            this.QKa = b.this.QIo.getScaleX();
            this.QKb = b.this.QIo.getScaleY();
            for (ViewParent parent = b.this.QIo.getParent(); parent != null; parent = parent.getParent()) {
                if (parent instanceof View) {
                    View view = (View) parent;
                    if (!(view.getRotation() == 0.0f && view.getRotationX() == 0.0f && view.getRotationY() == 0.0f)) {
                        return false;
                    }
                    this.QKa *= view.getScaleX();
                    this.QKb = view.getScaleY() * this.QKb;
                }
            }
            return true;
        }

        private boolean a(f fVar, Rect rect) {
            PopupWindow popupWindow = fVar.QJH;
            return Rect.intersects(new Rect(this.QJK, this.QJL, this.QJK + popupWindow.getContentView().getWidth(), popupWindow.getContentView().getHeight() + this.QJL), rect);
        }

        private f getOtherSelectionHandle() {
            n hax = b.this.hax();
            if (hax == null || !hax.isActive()) {
                return null;
            }
            if (hax.QKZ != this) {
                return hax.QKZ;
            }
            return hax.QLa;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:128:0x0350  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0068  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x0201  */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x0218  */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x0239  */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x025e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void ar(android.view.MotionEvent r12) {
            /*
            // Method dump skipped, instructions count: 864
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.widget.cedit.edit.b.f.ar(android.view.MotionEvent):void");
        }

        /* access modifiers changed from: protected */
        public final void haE() {
            if (b.this.QIy != null) {
                b.this.QIy.dismiss();
                b.this.QIK = false;
                b.this.gZS();
                setVisible(true);
                f otherSelectionHandle = getOtherSelectionHandle();
                if (otherSelectionHandle != null) {
                    otherSelectionHandle.setVisible(true);
                }
            }
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public boolean onTouchEvent(MotionEvent motionEvent) {
            float min;
            b.this.ap(motionEvent);
            switch (motionEvent.getActionMasked()) {
                case 0:
                    int currentCursorOffset = getCurrentCursorOffset();
                    this.QKg = 0;
                    aoB(currentCursorOffset);
                    l gZW = b.this.gZW();
                    this.QJS = gZW.QJI;
                    this.QJT = gZW.QJJ;
                    this.QJU = gZW.QKN;
                    this.QJV = gZW.QKO;
                    float rawX = (motionEvent.getRawX() - ((float) this.QJU)) + ((float) this.QJS);
                    float rawY = (motionEvent.getRawY() - ((float) this.QJV)) + ((float) this.QJT);
                    this.QJM = rawX - ((float) this.QJI);
                    this.QJN = rawY - ((float) this.QJJ);
                    this.okz = true;
                    this.QJY = -1;
                    break;
                case 1:
                    boolean isFromSource = motionEvent.isFromSource(4098);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    int i2 = this.QKf;
                    int min2 = Math.min(this.QKg, 5);
                    int i3 = 0;
                    while (i3 < min2 && uptimeMillis - this.QKd[i2] < 150) {
                        i3++;
                        i2 = ((this.QKf - i3) + 5) % 5;
                    }
                    if (i3 > 0 && i3 < min2 && uptimeMillis - this.QKd[i2] > 350) {
                        m(this.QKe[i2], false, isFromSource);
                    }
                    this.okz = false;
                    Db(false);
                    break;
                case 2:
                    float rawX2 = ((float) this.QJS) + (motionEvent.getRawX() - ((float) this.QJU));
                    float rawY2 = ((float) this.QJT) + (motionEvent.getRawY() - ((float) this.QJV));
                    float f2 = this.QJN - ((float) this.QJT);
                    float f3 = (rawY2 - ((float) this.QJJ)) - ((float) this.QJT);
                    if (f2 < this.QJR) {
                        min = Math.max(Math.min(f3, this.QJR), f2);
                    } else {
                        min = Math.min(Math.max(f3, this.QJR), f2);
                    }
                    this.QJN = min + ((float) this.QJT);
                    g((rawX2 - this.QJM) + ((float) this.QJO) + ((float) getHorizontalOffset()), (rawY2 - this.QJN) + this.QJQ, motionEvent.isFromSource(4098));
                    break;
                case 3:
                    this.okz = false;
                    Db(false);
                    break;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public void haF() {
        }

        public void onDetached() {
        }

        /* access modifiers changed from: protected */
        public void onSizeChanged(int i2, int i3, int i4, int i5) {
            super.onSizeChanged(i2, i3, i4, i5);
            if (Build.VERSION.SDK_INT >= 29) {
                setSystemGestureExclusionRects(Collections.singletonList(new Rect(0, 0, i2, i3)));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class i extends f {
        private boolean PkW = false;
        private float QKs;
        private float QKt;
        private Runnable QKu;
        private boolean QKv = false;
        private final int QKw = 255;
        private final int QKx = 0;

        static /* synthetic */ void a(i iVar) {
            AppMethodBeat.i(205904);
            iVar.haG();
            AppMethodBeat.o(205904);
        }

        i(Drawable drawable) {
            super(b.this, drawable, drawable, R.id.dz1, (byte) 0);
            AppMethodBeat.i(205887);
            AppMethodBeat.o(205887);
        }

        private void haG() {
            AppMethodBeat.i(205888);
            if (this.QKu == null) {
                this.QKu = new Runnable() {
                    /* class com.tencent.mm.ui.widget.cedit.edit.b.i.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(205886);
                        i.this.hide();
                        AppMethodBeat.o(205886);
                    }
                };
            } else {
                haH();
            }
            b.this.QIo.postDelayed(this.QKu, 4000);
            AppMethodBeat.o(205888);
        }

        private void haH() {
            AppMethodBeat.i(205889);
            if (this.QKu != null) {
                b.this.QIo.removeCallbacks(this.QKu);
            }
            AppMethodBeat.o(205889);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.widget.cedit.edit.b.f
        public final int c(Drawable drawable, boolean z) {
            AppMethodBeat.i(205890);
            int intrinsicWidth = drawable.getIntrinsicWidth() / 2;
            AppMethodBeat.o(205890);
            return intrinsicWidth;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.widget.cedit.edit.b.f
        public final int Dc(boolean z) {
            return 1;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.widget.cedit.edit.b.f
        public final int getCursorOffset() {
            AppMethodBeat.i(205891);
            int cursorOffset = super.getCursorOffset();
            if (b.this.QIY != null) {
                b.this.QIY.getPadding(b.this.mTempRect);
                cursorOffset += ((b.this.QIY.getIntrinsicWidth() - b.this.mTempRect.left) - b.this.mTempRect.right) / 2;
            }
            AppMethodBeat.o(205891);
            return cursorOffset;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.ui.widget.cedit.edit.b.f
        public final int c(Layout layout, int i2) {
            AppMethodBeat.i(205892);
            if (b.this.QIY != null) {
                int a2 = b.this.a(b.this.QIY, b(layout, i2)) + b.this.mTempRect.left;
                AppMethodBeat.o(205892);
                return a2;
            }
            int c2 = super.c(layout, i2);
            AppMethodBeat.o(205892);
            return c2;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.widget.cedit.edit.b.f
        public final void onMeasure(int i2, int i3) {
            AppMethodBeat.i(205893);
            super.onMeasure(i2, i3);
            AppMethodBeat.o(205893);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.ui.widget.cedit.edit.b.f
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z = true;
            AppMethodBeat.i(205894);
            if (!b.this.QIo.c(motionEvent, true)) {
                AppMethodBeat.o(205894);
                return true;
            }
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.QKs = motionEvent.getRawX();
                    this.QKt = motionEvent.getRawY();
                    ar(motionEvent);
                    break;
                case 1:
                    if (this.QKg <= 1) {
                        z = false;
                    }
                    if (!z) {
                        if (c.a(this.QKs, this.QKt, motionEvent.getRawX(), motionEvent.getRawY(), ViewConfiguration.get(b.this.QIo.getContext()).getScaledTouchSlop())) {
                            b.a(b.this);
                        }
                    } else if (b.this.QIu != null && Build.VERSION.SDK_INT >= 23) {
                        b.this.QIu.invalidateContentRect();
                    }
                    haG();
                    haE();
                    break;
                case 2:
                    ar(motionEvent);
                    break;
                case 3:
                    haG();
                    haE();
                    break;
            }
            AppMethodBeat.o(205894);
            return onTouchEvent;
        }

        @Override // com.tencent.mm.ui.widget.cedit.edit.b.f
        public final boolean isShowing() {
            AppMethodBeat.i(205895);
            if (this.QKv) {
                AppMethodBeat.o(205895);
                return false;
            }
            boolean isShowing = super.isShowing();
            AppMethodBeat.o(205895);
            return isShowing;
        }

        @Override // com.tencent.mm.ui.widget.cedit.edit.b.f
        public final void show() {
            AppMethodBeat.i(205896);
            super.show();
            this.QKv = false;
            this.mDrawable.setAlpha(this.QKw);
            AppMethodBeat.o(205896);
        }

        @Override // com.tencent.mm.ui.widget.cedit.edit.b.f
        public final void dismiss() {
            AppMethodBeat.i(205897);
            if (this.PkW) {
                this.QKv = true;
                this.mDrawable.setAlpha(0);
                AppMethodBeat.o(205897);
                return;
            }
            super.dismiss();
            this.QKv = false;
            AppMethodBeat.o(205897);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.widget.cedit.edit.b.f
        public final void Db(boolean z) {
            AppMethodBeat.i(205898);
            super.Db(z);
            this.mDrawable.setAlpha(this.QKw);
            AppMethodBeat.o(205898);
        }

        @Override // com.tencent.mm.ui.widget.cedit.edit.b.f
        public final int getCurrentCursorOffset() {
            AppMethodBeat.i(205899);
            int selectionStart = b.this.QIo.getSelectionStart();
            AppMethodBeat.o(205899);
            return selectionStart;
        }

        @Override // com.tencent.mm.ui.widget.cedit.edit.b.f
        public final void Gn(int i2) {
            AppMethodBeat.i(205900);
            Selection.setSelection((Spannable) b.this.QIo.getText(), i2);
            AppMethodBeat.o(205900);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.widget.cedit.edit.b.f
        public final void g(float f2, float f3, boolean z) {
            int i2 = -1;
            AppMethodBeat.i(205901);
            Layout layout = b.this.QIo.getLayout();
            if (layout != null) {
                if (this.QJY == -1) {
                    this.QJY = b.this.QIo.cz(f3);
                }
                int a2 = b.this.a(layout, this.QJY, f3);
                i2 = b(layout, a2, f2);
                this.QJY = a2;
            }
            m(i2, false, z);
            if (b.this.QIu != null) {
                b.this.han();
            }
            AppMethodBeat.o(205901);
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.ui.widget.cedit.edit.b.f
        public final void haF() {
            AppMethodBeat.i(205902);
            super.haF();
            haH();
            AppMethodBeat.o(205902);
        }

        @Override // com.tencent.mm.ui.widget.cedit.edit.b.f
        public final void onDetached() {
            AppMethodBeat.i(205903);
            super.onDetached();
            haH();
            AppMethodBeat.o(205903);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.widget.cedit.edit.b.f
        public final int getMagnifierHandleTrigger() {
            return 0;
        }
    }

    public final class m extends f {
        private final int QKS;
        private boolean QKT = false;
        private float QKU;
        private float QKV;
        private boolean QKW = false;
        private final float QKX;
        private final int[] QKY = new int[2];

        public m(Drawable drawable, Drawable drawable2, int i2, int i3) {
            super(b.this, drawable, drawable2, i2, (byte) 0);
            AppMethodBeat.i(205924);
            this.QKS = i3;
            this.QKX = (float) (ViewConfiguration.get(b.this.QIo.getContext()).getScaledTouchSlop() * 4);
            AppMethodBeat.o(205924);
        }

        private boolean haL() {
            return this.QKS == 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.widget.cedit.edit.b.f
        public final int c(Drawable drawable, boolean z) {
            AppMethodBeat.i(205925);
            if (z == haL()) {
                int intrinsicWidth = drawable.getIntrinsicWidth() / 4;
                AppMethodBeat.o(205925);
                return intrinsicWidth;
            }
            int intrinsicWidth2 = (drawable.getIntrinsicWidth() * 3) / 4;
            AppMethodBeat.o(205925);
            return intrinsicWidth2;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.widget.cedit.edit.b.f
        public final int Dc(boolean z) {
            AppMethodBeat.i(205926);
            if (z == haL()) {
                AppMethodBeat.o(205926);
                return 3;
            }
            AppMethodBeat.o(205926);
            return 5;
        }

        @Override // com.tencent.mm.ui.widget.cedit.edit.b.f
        public final int getCurrentCursorOffset() {
            AppMethodBeat.i(205927);
            if (haL()) {
                int selectionStart = b.this.QIo.getSelectionStart();
                AppMethodBeat.o(205927);
                return selectionStart;
            }
            int selectionEnd = b.this.QIo.getSelectionEnd();
            AppMethodBeat.o(205927);
            return selectionEnd;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.widget.cedit.edit.b.f
        public final void Gn(int i2) {
            AppMethodBeat.i(205928);
            if (haL()) {
                Selection.setSelection((Spannable) b.this.QIo.getText(), i2, b.this.QIo.getSelectionEnd());
            } else {
                Selection.setSelection((Spannable) b.this.QIo.getText(), b.this.QIo.getSelectionStart(), i2);
            }
            Db(false);
            if (b.this.QIu != null) {
                b.this.han();
            }
            AppMethodBeat.o(205928);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0135, code lost:
            if (r11.QJz.QIo.canScrollHorizontally(r9 ? -1 : 1) != false) goto L_0x0137;
         */
        @Override // com.tencent.mm.ui.widget.cedit.edit.b.f
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void g(float r12, float r13, boolean r14) {
            /*
            // Method dump skipped, instructions count: 723
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.widget.cedit.edit.b.m.g(float, float, boolean):void");
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.widget.cedit.edit.b.f
        public final void m(int i2, boolean z, boolean z2) {
            boolean z3;
            AppMethodBeat.i(205930);
            super.m(i2, z, z2);
            if (i2 != -1) {
                com.tencent.mm.ui.widget.cedit.c.b gZV = b.this.gZV();
                gZV.aoK(i2);
                if (!gZV.QLS.isBoundary(i2)) {
                    z3 = true;
                    this.QKT = z3;
                    AppMethodBeat.o(205930);
                }
            }
            z3 = false;
            this.QKT = z3;
            AppMethodBeat.o(205930);
        }

        @Override // com.tencent.mm.ui.widget.cedit.edit.b.f
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z = true;
            AppMethodBeat.i(205931);
            if (!b.this.QIo.c(motionEvent, true)) {
                AppMethodBeat.o(205931);
            } else {
                z = super.onTouchEvent(motionEvent);
                switch (motionEvent.getActionMasked()) {
                    case 0:
                        this.QKU = 0.0f;
                        this.QKV = -1.0f;
                        ar(motionEvent);
                        break;
                    case 1:
                    case 3:
                        haE();
                        break;
                    case 2:
                        ar(motionEvent);
                        break;
                }
                AppMethodBeat.o(205931);
            }
            return z;
        }

        private void bQ(int i2, boolean z) {
            boolean z2;
            boolean z3 = true;
            AppMethodBeat.i(205932);
            int selectionEnd = haL() ? b.this.QIo.getSelectionEnd() : b.this.QIo.getSelectionStart();
            if ((haL() && i2 >= selectionEnd) || (!haL() && i2 <= selectionEnd)) {
                this.QKU = 0.0f;
                Layout layout = b.this.QIo.getLayout();
                if (!(layout == null || i2 == selectionEnd)) {
                    float b2 = b(layout, i2);
                    if (!haL()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    float a2 = a(layout, selectionEnd, z2);
                    float b3 = b(layout, this.AiE);
                    if ((b3 < a2 && b2 < a2) || (b3 > a2 && b2 > a2)) {
                        int currentCursorOffset = getCurrentCursorOffset();
                        if (!haL()) {
                            Math.max(currentCursorOffset - 1, 0);
                        }
                        m(0, false, z);
                        AppMethodBeat.o(205932);
                        return;
                    }
                }
                b bVar = b.this;
                if (haL()) {
                    z3 = false;
                }
                i2 = bVar.bP(selectionEnd, z3);
            }
            m(i2, false, z);
            AppMethodBeat.o(205932);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.widget.cedit.edit.b.f
        public final boolean a(Layout layout, int i2) {
            AppMethodBeat.i(205933);
            if (!haL()) {
                i2 = Math.max(i2 - 1, 0);
            }
            boolean isRtlCharAt = layout.isRtlCharAt(i2);
            AppMethodBeat.o(205933);
            return isRtlCharAt;
        }

        @Override // com.tencent.mm.ui.widget.cedit.edit.b.f
        public final float b(Layout layout, int i2) {
            AppMethodBeat.i(205934);
            float a2 = a(layout, i2, haL());
            AppMethodBeat.o(205934);
            return a2;
        }

        private static float a(Layout layout, int i2, boolean z) {
            boolean z2;
            AppMethodBeat.i(205935);
            int lineForOffset = layout.getLineForOffset(i2);
            boolean isRtlCharAt = layout.isRtlCharAt(z ? i2 : Math.max(i2 - 1, 0));
            if (layout.getParagraphDirection(lineForOffset) == -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (isRtlCharAt == z2) {
                float primaryHorizontal = layout.getPrimaryHorizontal(i2);
                AppMethodBeat.o(205935);
                return primaryHorizontal;
            }
            float secondaryHorizontal = layout.getSecondaryHorizontal(i2);
            AppMethodBeat.o(205935);
            return secondaryHorizontal;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.widget.cedit.edit.b.f
        public final int b(Layout layout, int i2, float f2) {
            AppMethodBeat.i(205936);
            int offsetForHorizontal = layout.getOffsetForHorizontal(i2, b.this.QIo.cy(f2));
            AppMethodBeat.o(205936);
            return offsetForHorizontal;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.widget.cedit.edit.b.f
        public final int getMagnifierHandleTrigger() {
            AppMethodBeat.i(205937);
            if (haL()) {
                AppMethodBeat.o(205937);
                return 1;
            }
            AppMethodBeat.o(205937);
            return 2;
        }
    }

    public final int a(Layout layout, int i2, float f2) {
        AppMethodBeat.i(206025);
        int cz = this.QIo.cz(f2);
        if (layout == null || i2 > layout.getLineCount() || layout.getLineCount() <= 0 || i2 < 0) {
            AppMethodBeat.o(206025);
            return cz;
        } else if (Math.abs(cz - i2) >= 2) {
            AppMethodBeat.o(206025);
            return cz;
        } else {
            int lineBottom = layout.getLineBottom(i2) - layout.getLineTop(i2);
            int max = Math.max(0, Math.max(this.QJw, Math.min(this.QJv, ((int) (0.5f * ((float) (layout.getLineBottom(cz) - layout.getLineTop(cz))))) + lineBottom)) - lineBottom);
            float gZz = (float) this.QIo.gZz();
            if (cz > i2 && f2 >= ((float) (layout.getLineBottom(i2) + max)) + gZz) {
                AppMethodBeat.o(206025);
                return cz;
            } else if (cz >= i2 || f2 > ((float) (layout.getLineTop(i2) - max)) + gZz) {
                AppMethodBeat.o(206025);
                return i2;
            } else {
                AppMethodBeat.o(206025);
                return cz;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void haA() {
        AppMethodBeat.i(206026);
        if (this.QIY == null) {
            this.QIY = this.QIo.getTextCursorDrawable();
        }
        AppMethodBeat.o(206026);
    }

    public class j implements d {
        boolean QKA;
        private boolean QKB;
        private int QKC;
        private i QKz;

        public j() {
        }

        /* access modifiers changed from: package-private */
        public final void haI() {
            AppMethodBeat.i(205907);
            this.QKA = false;
            this.QKB = false;
            this.QKC = -1;
            haJ().haE();
            i.a(haJ());
            b.this.QIo.getParent().requestDisallowInterceptTouchEvent(false);
            AppMethodBeat.o(205907);
        }

        @Override // com.tencent.mm.ui.widget.cedit.edit.b.d
        public final void show() {
            AppMethodBeat.i(205908);
            haJ().show();
            long uptimeMillis = SystemClock.uptimeMillis() - CustomTextView.QGm;
            if (b.this.QJk != null && (this.QKA || b.this.QJj.haT() || b.this.hat())) {
                b.this.QIo.removeCallbacks(b.this.QJk);
            }
            if (!this.QKA && !b.this.QJj.haT() && !b.this.hat() && uptimeMillis < 15000 && b.this.ham()) {
                if (b.this.QJk == null) {
                    b.this.QJk = new Runnable() {
                        /* class com.tencent.mm.ui.widget.cedit.edit.b.j.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(205905);
                            b.this.haj();
                            AppMethodBeat.o(205905);
                        }
                    };
                }
                b.this.QIo.postDelayed(b.this.QJk, (long) (ViewConfiguration.getDoubleTapTimeout() + 1));
            }
            if (!this.QKA) {
                i.a(haJ());
            }
            if (b.this.QIt != null) {
                b.this.QIt.hide();
            }
            AppMethodBeat.o(205908);
        }

        public final void hide() {
            AppMethodBeat.i(205909);
            if (this.QKz != null) {
                this.QKz.hide();
            }
            AppMethodBeat.o(205909);
        }

        public final void onTouchModeChanged(boolean z) {
            AppMethodBeat.i(205910);
            if (!z) {
                hide();
            }
            AppMethodBeat.o(205910);
        }

        public final i haJ() {
            AppMethodBeat.i(205911);
            if (this.QKz == null) {
                b.this.CZ(false);
                this.QKz = new i(b.this.QJb);
            }
            i iVar = this.QKz;
            AppMethodBeat.o(205911);
            return iVar;
        }

        public final void onDetached() {
            AppMethodBeat.i(205912);
            b.this.QIo.getViewTreeObserver().removeOnTouchModeChangeListener(this);
            if (this.QKz != null) {
                this.QKz.onDetached();
            }
            AppMethodBeat.o(205912);
        }

        @Override // com.tencent.mm.ui.widget.cedit.edit.b.d
        public final boolean haB() {
            return this.QKA || (this.QKz != null && this.QKz.okz);
        }

        @Override // com.tencent.mm.ui.widget.cedit.edit.b.d
        public final boolean isActive() {
            AppMethodBeat.i(205913);
            if (this.QKz == null || !this.QKz.isShowing()) {
                AppMethodBeat.o(205913);
                return false;
            }
            AppMethodBeat.o(205913);
            return true;
        }

        public final void haK() {
            AppMethodBeat.i(205914);
            if (this.QKz != null) {
                this.QKz.invalidate();
            }
            AppMethodBeat.o(205914);
        }

        /* access modifiers changed from: package-private */
        public final void as(MotionEvent motionEvent) {
            float y;
            int i2;
            AppMethodBeat.i(205906);
            Layout layout = b.this.QIo.getLayout();
            if (this.QKC == -1) {
                i2 = b.this.a(layout, this.QKC, motionEvent.getY());
            } else {
                int[] iArr = new int[2];
                b.this.QIo.getLocationOnScreen(iArr);
                if (b.this.QJj.QLs) {
                    y = motionEvent.getRawY() - ((float) iArr[1]);
                } else {
                    y = motionEvent.getY();
                }
                int a2 = b.this.a(layout, this.QKC, y - ((float) haJ().getIdealFingerToCursorOffset()));
                if (this.QKB) {
                    i2 = a2;
                } else if (a2 < this.QKC) {
                    i2 = Math.min(this.QKC, b.this.a(layout, this.QKC, y));
                } else {
                    this.QKB = true;
                    i2 = a2;
                }
            }
            this.QKC = i2;
            int B = b.this.QIo.B(this.QKC, motionEvent.getX());
            int selectionStart = b.this.QIo.getSelectionStart();
            int selectionEnd = b.this.QIo.getSelectionEnd();
            if (!(B == selectionStart && B == selectionEnd)) {
                Selection.setSelection((Spannable) b.this.QIo.getText(), B);
                b.this.hah();
                if (b.this.QIx) {
                    b.this.QIo.performHapticFeedback(9);
                }
            }
            haJ().ar(motionEvent);
            AppMethodBeat.o(205906);
        }

        static /* synthetic */ void a(j jVar) {
            AppMethodBeat.i(205915);
            if (jVar.QKz != null) {
                jVar.QKz.b(b.this.QJb, b.this.QJb);
            }
            AppMethodBeat.o(205915);
        }
    }

    public class n implements d {
        private m QKZ;
        private m QLa;
        int QLb;
        int QLc;
        private boolean QLd;
        private int QLe = -1;
        private boolean QLf;
        private int QLg = -1;
        private boolean QLh = false;
        private int QLi = 0;

        static /* synthetic */ void b(n nVar) {
            AppMethodBeat.i(205956);
            nVar.haM();
            AppMethodBeat.o(205956);
        }

        n() {
            AppMethodBeat.i(205938);
            haN();
            AppMethodBeat.o(205938);
        }

        @Override // com.tencent.mm.ui.widget.cedit.edit.b.d
        public final void show() {
            AppMethodBeat.i(205939);
            if (b.this.QIo.gZK()) {
                AppMethodBeat.o(205939);
                return;
            }
            b.this.CZ(false);
            haM();
            AppMethodBeat.o(205939);
        }

        private void haM() {
            AppMethodBeat.i(205940);
            if (this.QKZ == null) {
                this.QKZ = new m(b.this.QIZ, b.this.QJa, R.id.hj3, 0);
            }
            if (this.QLa == null) {
                this.QLa = new m(b.this.QJa, b.this.QIZ, R.id.hj2, 1);
            }
            this.QKZ.show();
            this.QLa.show();
            b.this.gZQ();
            AppMethodBeat.o(205940);
        }

        public final void hide() {
            AppMethodBeat.i(205941);
            if (this.QKZ != null) {
                this.QKZ.hide();
            }
            if (this.QLa != null) {
                this.QLa.hide();
            }
            AppMethodBeat.o(205941);
        }

        public final void aoC(int i2) {
            AppMethodBeat.i(205942);
            show();
            this.QLi = i2;
            this.QLe = b.this.QIo.getOffsetForPosition(b.this.QJj.ovM, b.this.QJj.ovN);
            this.QLg = b.this.QIo.cz(b.this.QJj.ovN);
            hide();
            b.this.QIo.getParent().requestDisallowInterceptTouchEvent(true);
            b.this.QIo.cancelLongPress();
            AppMethodBeat.o(205942);
        }

        public final void onTouchEvent(MotionEvent motionEvent) {
            r2 = false;
            boolean z = false;
            AppMethodBeat.i(205943);
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            boolean isFromSource = motionEvent.isFromSource(8194);
            switch (motionEvent.getActionMasked()) {
                case 0:
                    if (b.this.has()) {
                        hide();
                        AppMethodBeat.o(205943);
                        return;
                    }
                    int offsetForPosition = b.this.QIo.getOffsetForPosition(x, y);
                    this.QLc = offsetForPosition;
                    this.QLb = offsetForPosition;
                    if (this.QLd) {
                        c cVar = b.this.QJj;
                        if (((!cVar.haT() || !cVar.QLu) ? null : 1) != null && (isFromSource || b.this.az(x, y) || b.this.QJj.QLs)) {
                            if ((b.this.QJj.QLt == 2 ? 1 : null) != null) {
                                b.b(b.this);
                            } else {
                                if ((b.this.QJj.QLt == 3 ? 1 : null) != null) {
                                    if (b.this.QJk != null) {
                                        b.this.QIo.removeCallbacks(b.this.QJk);
                                    }
                                    b.this.gZE();
                                    b bVar = b.this;
                                    if (bVar.QIo.gZC()) {
                                        if (bVar.gZT()) {
                                            z = bVar.QIo.gZJ();
                                        } else {
                                            long gZZ = bVar.gZZ();
                                            long lC = bVar.lC((int) (gZZ >>> 32), (int) (gZZ & Util.MAX_32BIT_VALUE));
                                            int i2 = (int) (lC >>> 32);
                                            int i3 = (int) (lC & Util.MAX_32BIT_VALUE);
                                            if (i2 < i3) {
                                                Selection.setSelection((Spannable) bVar.QIo.getText(), i2, i3);
                                                z = true;
                                            }
                                        }
                                    }
                                    if (z) {
                                        aoC(3);
                                    }
                                }
                            }
                            b.this.QII = true;
                        }
                    }
                    this.QLd = true;
                    this.QLf = true;
                    AppMethodBeat.o(205943);
                    return;
                case 1:
                    if (haQ()) {
                        at(motionEvent);
                        b.this.QIo.getParent().requestDisallowInterceptTouchEvent(false);
                        haO();
                        if (b.this.QIo.hasSelection()) {
                            b.this.hao().haU();
                            b.this.QIo.invalidate();
                            break;
                        }
                    }
                    break;
                case 2:
                    if (this.QLd) {
                        ViewConfiguration.get(b.this.QIo.getContext());
                        this.QLd = c.a(b.this.QJj.ovM, b.this.QJj.ovN, x, y, at.fromDPToPix(b.this.QIo.getContext(), 8));
                    }
                    if (this.QLf) {
                        this.QLf = !b.this.QJj.QLv;
                    }
                    if (isFromSource && !haQ()) {
                        int offsetForPosition2 = b.this.QIo.getOffsetForPosition(x, y);
                        if (b.this.QIo.hasSelection() && (!(this.QLf && this.QLe == offsetForPosition2) && offsetForPosition2 >= b.this.QIo.getSelectionStart() && offsetForPosition2 <= b.this.QIo.getSelectionEnd())) {
                            b.c(b.this);
                            AppMethodBeat.o(205943);
                            return;
                        } else if (this.QLe != offsetForPosition2) {
                            b.this.gZE();
                            aoC(1);
                            b.this.QII = true;
                            this.QLf = false;
                        }
                    }
                    if (this.QKZ == null || !this.QKZ.isShowing()) {
                        at(motionEvent);
                        AppMethodBeat.o(205943);
                        return;
                    }
                    break;
                case 5:
                case 6:
                    if (b.this.QIo.getContext().getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch.distinct")) {
                        int pointerCount = motionEvent.getPointerCount();
                        for (int i4 = 0; i4 < pointerCount; i4++) {
                            int offsetForPosition3 = b.this.QIo.getOffsetForPosition(motionEvent.getX(i4), motionEvent.getY(i4));
                            if (offsetForPosition3 < this.QLb) {
                                this.QLb = offsetForPosition3;
                            }
                            if (offsetForPosition3 > this.QLc) {
                                this.QLc = offsetForPosition3;
                            }
                        }
                        AppMethodBeat.o(205943);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(205943);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        private void at(MotionEvent motionEvent) {
            AppMethodBeat.i(205944);
            if (b.this.QIo.getLayout() != null) {
                switch (this.QLi) {
                    case 1:
                        au(motionEvent);
                        AppMethodBeat.o(205944);
                        return;
                    case 2:
                        av(motionEvent);
                        AppMethodBeat.o(205944);
                        return;
                    case 3:
                        aw(motionEvent);
                        break;
                }
            }
            AppMethodBeat.o(205944);
        }

        private void au(MotionEvent motionEvent) {
            AppMethodBeat.i(205945);
            N(this.QLe, b.this.QIo.getOffsetForPosition(motionEvent.getX(), motionEvent.getY()), motionEvent.isFromSource(4098));
            AppMethodBeat.o(205945);
        }

        private void av(MotionEvent motionEvent) {
            float f2;
            int a2;
            int b2;
            int a3;
            AppMethodBeat.i(205946);
            if (this.QLf) {
                AppMethodBeat.o(205946);
                return;
            }
            boolean isFromSource = motionEvent.isFromSource(8194);
            ViewConfiguration viewConfiguration = ViewConfiguration.get(b.this.QIo.getContext());
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (isFromSource) {
                a2 = b.this.QIo.cz(y);
            } else {
                if (this.QLh) {
                    f2 = y - (this.QKZ != null ? this.QKZ.getIdealVerticalOffset() : (float) viewConfiguration.getScaledTouchSlop());
                } else {
                    f2 = y;
                }
                a2 = b.this.a(b.this.QIo.getLayout(), this.QLg, f2);
                if (!this.QLh && a2 != this.QLg) {
                    this.QLh = true;
                    AppMethodBeat.o(205946);
                    return;
                }
            }
            int B = b.this.QIo.B(a2, x);
            if (this.QLe < B) {
                b2 = b.a(b.this, B);
                a3 = b.b(b.this, this.QLe);
            } else {
                b2 = b.b(b.this, B);
                a3 = b.a(b.this, this.QLe);
                if (a3 == b2) {
                    b2 = b.this.bP(b2, false);
                }
            }
            this.QLg = a2;
            N(a3, b2, motionEvent.isFromSource(4098));
            AppMethodBeat.o(205946);
        }

        private void aw(MotionEvent motionEvent) {
            AppMethodBeat.i(205947);
            int offsetForPosition = b.this.QIo.getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
            long lC = b.this.lC(Math.min(offsetForPosition, this.QLe), Math.max(offsetForPosition, this.QLe));
            N((int) (lC >>> 32), (int) (lC & Util.MAX_32BIT_VALUE), motionEvent.isFromSource(4098));
            AppMethodBeat.o(205947);
        }

        private void N(int i2, int i3, boolean z) {
            AppMethodBeat.i(205948);
            boolean z2 = z && b.this.QIx && !(b.this.QIo.getSelectionStart() == i2 && b.this.QIo.getSelectionEnd() == i3);
            Selection.setSelection((Spannable) b.this.QIo.getText(), i2, i3);
            if (z2) {
                b.this.QIo.performHapticFeedback(9);
            }
            AppMethodBeat.o(205948);
        }

        public final void haN() {
            AppMethodBeat.i(205949);
            this.QLc = -1;
            this.QLb = -1;
            haO();
            AppMethodBeat.o(205949);
        }

        private void haO() {
            AppMethodBeat.i(205950);
            this.QLe = -1;
            this.QLi = 0;
            this.QLh = false;
            int selectionStart = b.this.QIo.getSelectionStart();
            int selectionEnd = b.this.QIo.getSelectionEnd();
            if (selectionStart < 0 || selectionEnd < 0) {
                Selection.removeSelection((Spannable) b.this.QIo.getText());
                AppMethodBeat.o(205950);
                return;
            }
            if (selectionStart > selectionEnd) {
                Selection.setSelection((Spannable) b.this.QIo.getText(), selectionEnd, selectionStart);
            }
            AppMethodBeat.o(205950);
        }

        public final boolean haP() {
            return this.QKZ != null && this.QKZ.okz;
        }

        @Override // com.tencent.mm.ui.widget.cedit.edit.b.d
        public final boolean haB() {
            AppMethodBeat.i(205951);
            if (haQ() || haP() || (this.QLa != null && this.QLa.okz)) {
                AppMethodBeat.o(205951);
                return true;
            }
            AppMethodBeat.o(205951);
            return false;
        }

        public final boolean haQ() {
            return this.QLi != 0;
        }

        public final void onTouchModeChanged(boolean z) {
            AppMethodBeat.i(205952);
            if (!z) {
                hide();
            }
            AppMethodBeat.o(205952);
        }

        public final void onDetached() {
            AppMethodBeat.i(205953);
            b.this.QIo.getViewTreeObserver().removeOnTouchModeChangeListener(this);
            if (this.QKZ != null) {
                this.QKZ.onDetached();
            }
            if (this.QLa != null) {
                this.QLa.onDetached();
            }
            AppMethodBeat.o(205953);
        }

        @Override // com.tencent.mm.ui.widget.cedit.edit.b.d
        public final boolean isActive() {
            AppMethodBeat.i(205954);
            if (this.QKZ == null || !this.QKZ.isShowing()) {
                AppMethodBeat.o(205954);
                return false;
            }
            AppMethodBeat.o(205954);
            return true;
        }

        public final void haR() {
            AppMethodBeat.i(205955);
            if (this.QKZ != null) {
                this.QKZ.invalidate();
            }
            if (this.QLa != null) {
                this.QLa.invalidate();
            }
            AppMethodBeat.o(205955);
        }

        static /* synthetic */ void d(n nVar) {
            AppMethodBeat.i(205957);
            if (nVar.QKZ != null) {
                nVar.QKZ.b(b.this.QIZ, b.this.QJa);
                nVar.QLa.b(b.this.QJa, b.this.QIZ);
            }
            AppMethodBeat.o(205957);
        }
    }

    private static Drawable a(Context context, Drawable drawable, int i2) {
        AppMethodBeat.i(206027);
        if (!(drawable instanceof BitmapDrawable)) {
            AppMethodBeat.o(206027);
            return drawable;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth == 0 || intrinsicHeight == 0) {
            AppMethodBeat.o(206027);
            return drawable;
        }
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        float width = ((float) intrinsicWidth) / ((float) bitmap.getWidth());
        int fromDPToPix = at.fromDPToPix(context, i2);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), Bitmap.createScaledBitmap(bitmap, (int) (((((float) intrinsicWidth) / ((float) intrinsicHeight)) * ((float) fromDPToPix)) / width), (int) (((float) fromDPToPix) / width), true));
        AppMethodBeat.o(206027);
        return bitmapDrawable;
    }

    /* access modifiers changed from: package-private */
    public final void CZ(boolean z) {
        AppMethodBeat.i(206028);
        if (this.QJb == null || z) {
            this.QJb = this.QIo.getTextSelectHandle();
            if (this.QJb != null) {
                this.QJb = a(this.QIo.getContext(), this.QJb, 23);
                this.QJb.setTint(this.QIo.QHx);
            }
            if (this.QIv) {
                j.a(haw());
            }
        }
        if (this.QIZ == null || this.QJa == null || z) {
            this.QIZ = this.QIo.getTextSelectHandleLeft();
            this.QIZ = a(this.QIo.getContext(), this.QIZ, 21);
            this.QIZ.setTint(this.QIo.QHx);
            this.QJa = this.QIo.getTextSelectHandleRight();
            this.QJa = a(this.QIo.getContext(), this.QJa, 21);
            this.QJa.setTint(this.QIo.QHx);
            if (this.QIw) {
                n.d(hax());
            }
        }
        AppMethodBeat.o(206028);
    }

    /* renamed from: com.tencent.mm.ui.widget.cedit.edit.b$b  reason: collision with other inner class name */
    class C2142b {
        int Pc;
        long QJA;
        private RectF asb;
        int avh;
        final Paint mPaint = new Paint(1);
        final Path xT = new Path();

        public C2142b() {
            AppMethodBeat.i(205881);
            this.mPaint.setStyle(Paint.Style.FILL);
            AppMethodBeat.o(205881);
        }

        /* access modifiers changed from: package-private */
        public final void Da(boolean z) {
            AppMethodBeat.i(205882);
            if (b.this.QIo.getLayout() == null) {
                AppMethodBeat.o(205882);
                return;
            }
            if (this.asb == null) {
                this.asb = new RectF();
            }
            this.xT.computeBounds(this.asb, false);
            int compoundPaddingLeft = b.this.QIo.getCompoundPaddingLeft();
            int extendedPaddingTop = b.this.QIo.getExtendedPaddingTop() + b.this.QIo.CW(true);
            if (z) {
                b.this.QIo.postInvalidateOnAnimation(((int) this.asb.left) + compoundPaddingLeft, ((int) this.asb.top) + extendedPaddingTop, compoundPaddingLeft + ((int) this.asb.right), extendedPaddingTop + ((int) this.asb.bottom));
                AppMethodBeat.o(205882);
                return;
            }
            b.this.QIo.postInvalidate((int) this.asb.left, (int) this.asb.top, (int) this.asb.right, (int) this.asb.bottom);
            AppMethodBeat.o(205882);
        }

        /* access modifiers changed from: package-private */
        public final void stopAnimation() {
            b.this.QIB = null;
        }
    }

    /* access modifiers changed from: package-private */
    public static class g {
        CharSequence QKh;
        CustomTextView.c QKi;
        boolean QKj;
        LocaleList QKk;
        Bundle extras;
        int imeActionId;
        int imeOptions = 0;
        String privateImeOptions;

        g() {
        }
    }

    /* access modifiers changed from: package-private */
    public static class h {
        int QIp;
        ExtractedTextRequest QKl;
        final ExtractedText QKm = new ExtractedText();
        boolean QKn;
        boolean QKo;
        int QKp;
        int QKq;
        int QKr;
        boolean mContentChanged;

        h() {
            AppMethodBeat.i(205885);
            AppMethodBeat.o(205885);
        }
    }

    static /* synthetic */ int a(b bVar, int i2) {
        int i3;
        boolean z;
        AppMethodBeat.i(206030);
        if (bVar.gZV().aoF(bVar.gZV().aoD(i2))) {
            com.tencent.mm.ui.widget.cedit.c.b gZV = bVar.gZV();
            gZV.aoK(i2);
            i3 = i2;
            while (i3 != -1) {
                if (gZV.aoG(i3) || !gZV.aoF(i3)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    break;
                }
                i3 = gZV.aoD(i3);
            }
        } else {
            i3 = bVar.gZV().bS(i2, true);
        }
        if (i3 == -1) {
            AppMethodBeat.o(206030);
            return i2;
        }
        AppMethodBeat.o(206030);
        return i3;
    }

    static /* synthetic */ int b(b bVar, int i2) {
        int i3;
        boolean z;
        AppMethodBeat.i(206031);
        if (bVar.gZV().aoG(bVar.gZV().aoE(i2))) {
            com.tencent.mm.ui.widget.cedit.c.b gZV = bVar.gZV();
            gZV.aoK(i2);
            i3 = i2;
            while (i3 != -1) {
                if (!gZV.aoG(i3) || gZV.aoF(i3)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    break;
                }
                i3 = gZV.aoE(i3);
            }
        } else {
            i3 = bVar.gZV().bR(i2, true);
        }
        if (i3 == -1) {
            AppMethodBeat.o(206031);
            return i2;
        }
        AppMethodBeat.o(206031);
        return i3;
    }
}
