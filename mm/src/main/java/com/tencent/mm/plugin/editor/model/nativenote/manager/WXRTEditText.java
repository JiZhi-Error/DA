package com.tencent.mm.plugin.editor.model.nativenote.manager;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.Layout;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ParagraphStyle;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ce.g;
import com.tencent.mm.plugin.editor.model.nativenote.a.a;
import com.tencent.mm.plugin.editor.model.nativenote.b.c;
import com.tencent.mm.plugin.editor.model.nativenote.c.b;
import com.tencent.mm.plugin.editor.model.nativenote.c.d;
import com.tencent.mm.plugin.editor.model.nativenote.c.e;
import com.tencent.mm.plugin.editor.model.nativenote.spans.f;
import com.tencent.mm.plugin.editor.model.nativenote.spans.h;
import com.tencent.mm.plugin.editor.model.nativenote.spans.k;
import com.tencent.mm.plugin.editor.model.nativenote.spans.l;
import com.tencent.mm.plugin.editor.model.nativenote.spans.s;
import com.tencent.mm.plugin.editor.model.nativenote.spans.t;
import com.tencent.mm.plugin.editor.model.nativenote.spans.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.edittext.PasterEditText;
import java.util.ArrayList;

public class WXRTEditText extends PasterEditText implements SpanWatcher {
    public int afB = 0;
    private MTimerHandler cve = null;
    public boolean qPI = false;
    public int qPK = 0;
    private c qQV;
    private int qQW = -1;
    private int qQX = -1;
    private boolean qQY = false;
    private boolean qQZ;
    private boolean qRA = false;
    TextWatcher qRB = new TextWatcher() {
        /* class com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText.AnonymousClass2 */

        public final synchronized void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            String str;
            AppMethodBeat.i(181783);
            if (WXRTEditText.this.qRc == null) {
                str = "";
            } else {
                str = WXRTEditText.this.qRc;
            }
            if (!WXRTEditText.this.qQZ && !charSequence.toString().equals(str)) {
                WXRTEditText.this.qRa = WXRTEditText.this.getSelectionStart();
                WXRTEditText.this.qRb = WXRTEditText.this.getSelectionEnd();
                WXRTEditText.this.qRc = charSequence.toString();
                WXRTEditText.this.qRd = WXRTEditText.this.qRc;
                WXRTEditText.this.qRe = WXRTEditText.this.cDG();
            }
            AppMethodBeat.o(181783);
        }

        public final synchronized void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AppMethodBeat.i(181784);
            WXRTEditText.this.qRo = true;
            AppMethodBeat.o(181784);
        }

        public final synchronized void afterTextChanged(Editable editable) {
            String str;
            AppMethodBeat.i(181785);
            Log.d("noteeditor.WXRTEditText", "afterTextChanged");
            String obj = editable.toString();
            if (WXRTEditText.this.qRd == null) {
                str = "";
            } else {
                str = WXRTEditText.this.qRd;
            }
            if (WXRTEditText.this.qRf != 0) {
                WXRTEditText.this.qRd = "";
            }
            if (!WXRTEditText.this.qQZ && WXRTEditText.this.getSelection().avh == WXRTEditText.this.getSelection().Pc && (((!str.endsWith("\n") && (str + "\n").equals(obj)) || (str.endsWith("\n") && !str.endsWith("\n\n") && str.equals(obj))) && ((ParagraphStyle[]) WXRTEditText.this.getText().getSpans(str.length(), str.length(), ParagraphStyle.class)).length > 0)) {
                int selectionStart = WXRTEditText.this.getSelectionStart();
                WXRTEditText.this.qQZ = true;
                WXRTEditText.this.getText().append((CharSequence) "\n");
                WXRTEditText.this.qQZ = false;
                WXRTEditText.this.setSelection(selectionStart);
            }
            if (WXRTEditText.this.qQV != null && !WXRTEditText.this.qQZ && !str.equals(obj)) {
                Spannable cDG = WXRTEditText.this.cDG();
                WXRTEditText.this.qRd = obj;
                c cVar = WXRTEditText.this.qQV;
                WXRTEditText wXRTEditText = WXRTEditText.this.qRg;
                Spannable spannable = WXRTEditText.this.qRe;
                int unused = WXRTEditText.this.qRa;
                int unused2 = WXRTEditText.this.qRb;
                WXRTEditText.this.getSelectionStart();
                cVar.a(wXRTEditText, spannable, cDG, WXRTEditText.this.getSelectionEnd());
            }
            WXRTEditText.this.qRo = true;
            WXRTEditText.this.qRi = true;
            WXRTEditText.m(WXRTEditText.this);
            WXRTEditText.n(WXRTEditText.this);
            AppMethodBeat.o(181785);
        }
    };
    int qRC = 0;
    private int qRa;
    private int qRb;
    private String qRc;
    public String qRd = "";
    private Spannable qRe;
    private int qRf = 0;
    private WXRTEditText qRg = null;
    public RecyclerView.v qRh;
    private boolean qRi;
    private boolean qRj;
    private boolean qRk;
    private boolean qRl;
    private boolean qRm;
    private boolean qRn = false;
    private boolean qRo;
    private i qRp;
    public boolean qRq = false;
    public boolean qRr = false;
    private int qRs = -1;
    private Paint qRt = null;
    private b qRu = null;
    private boolean qRv = false;
    private Path qRw = null;
    private int qRx = -1;
    private int qRy = -1;
    private int qRz = -1;

    static /* synthetic */ void m(WXRTEditText wXRTEditText) {
        AppMethodBeat.i(181823);
        wXRTEditText.setParagraphsAreUp2Date(false);
        AppMethodBeat.o(181823);
    }

    static /* synthetic */ void n(WXRTEditText wXRTEditText) {
        AppMethodBeat.i(181824);
        wXRTEditText.cDL();
        AppMethodBeat.o(181824);
    }

    static /* synthetic */ void p(WXRTEditText wXRTEditText) {
        AppMethodBeat.i(181825);
        wXRTEditText.cDN();
        AppMethodBeat.o(181825);
    }

    public WXRTEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(181787);
        init();
        AppMethodBeat.o(181787);
    }

    public WXRTEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(181788);
        init();
        AppMethodBeat.o(181788);
    }

    public void setMaxHeight(int i2) {
        AppMethodBeat.i(181789);
        super.setMaxHeight(i2);
        AppMethodBeat.o(181789);
    }

    private void init() {
        AppMethodBeat.i(181790);
        this.qRg = this;
        removeTextChangedListener(this.qRB);
        addTextChangedListener(this.qRB);
        setMovementMethod(f.cEv());
        this.qRs = -1;
        this.qRt = new Paint(1);
        this.qRt.setColor(1347529272);
        this.qRu = new b();
        this.qRw = new Path();
        this.qRx = -1;
        this.qRy = -1;
        this.qRz = -1;
        if (e.isEnabled()) {
            setHighlightColor(0);
            setCustomSelectionActionModeCallback(new ActionMode.Callback() {
                /* class com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText.AnonymousClass1 */

                public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                    return false;
                }

                public final void onDestroyActionMode(ActionMode actionMode) {
                }

                public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                    return false;
                }

                public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                    return false;
                }
            });
        }
        AppMethodBeat.o(181790);
    }

    public void setRichTextEditing(String str) {
        AppMethodBeat.i(181792);
        cDH();
        if (!Util.isNullOrNil(str)) {
            setSpannableText(a.alS(str));
        } else {
            setText("");
        }
        cDI();
        AppMethodBeat.o(181792);
    }

    public void setSpannableText(Spanned spanned) {
        AppMethodBeat.i(181793);
        cDH();
        cDJ();
        super.setText(spanned, TextView.BufferType.EDITABLE);
        cDK();
        cDL();
        u.a(this, new t[0]);
        cDI();
        AppMethodBeat.o(181793);
    }

    public void setText(String str) {
        AppMethodBeat.i(181794);
        cDH();
        super.setText((CharSequence) str);
        cDI();
        AppMethodBeat.o(181794);
    }

    public void setTextWithoutIgnore(String str) {
        AppMethodBeat.i(181795);
        super.setText((CharSequence) str);
        AppMethodBeat.o(181795);
    }

    public final void cDF() {
        AppMethodBeat.i(181796);
        if (this.qQV != null) {
            this.qQV.e(true, 50);
            this.qQV.Fv(1);
        }
        AppMethodBeat.o(181796);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(181797);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(181797);
        return dispatchTouchEvent;
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        AppMethodBeat.i(181798);
        this.qRA = false;
        this.qQW = -1;
        this.qQX = -1;
        super.onFocusChanged(z, i2, rect);
        if (this.qQV != null) {
            this.qQV.a(this, z, getRecyclerItemPosition());
        }
        if (z && !this.qRA) {
            onSelectionChanged(getSelectionStart(), getSelectionEnd());
        }
        AppMethodBeat.o(181798);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(181799);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
        if (r5.qQW != r6) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0027, code lost:
        if (r5.qQX == r7) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0029, code lost:
        r5.qQW = r6;
        r5.qQX = r7;
        super.onSelectionChanged(r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
        if (r7 <= r6) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0032, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0033, code lost:
        r5.qRj = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0037, code lost:
        if (r5.qRk != false) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003b, code lost:
        if (r5.qRl != false) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003d, code lost:
        r5.qRm = true;
        com.tencent.mm.plugin.editor.model.nativenote.spans.u.a(r5, new com.tencent.mm.plugin.editor.model.nativenote.spans.t[0]);
        r5.qRm = false;
        setParagraphsAreUp2Date(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004b, code lost:
        if (r5.qQV == null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004d, code lost:
        r5.qRn = true;
        r5.qQV.a(r5, r6, r7);
        r5.qRn = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005a, code lost:
        if (com.tencent.mm.plugin.editor.model.nativenote.c.e.isEnabled() == false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005e, code lost:
        if (r5.qRv != false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0064, code lost:
        if (hasFocus() == false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0068, code lost:
        if (r5.qRs < 0) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x006a, code lost:
        fz(r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0077, code lost:
        if (com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().FB(r5.qRs) != 1) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0079, code lost:
        r0 = com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x007f, code lost:
        if (com.tencent.mm.plugin.editor.model.nativenote.c.e.mHasInit == false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0081, code lost:
        r0.f(true, 0);
        r0.cEc();
        r0.cEa();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x008c, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(181799);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0090, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        r5.qRA = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        if (r6 >= 0) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSelectionChanged(int r6, int r7) {
        /*
        // Method dump skipped, instructions count: 146
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText.onSelectionChanged(int, int):void");
    }

    public final Spannable cDG() {
        AppMethodBeat.i(181800);
        CharSequence text = super.getText();
        if (text == null) {
            text = "";
        }
        a aVar = new a(text);
        AppMethodBeat.o(181800);
        return aVar;
    }

    public String getSelectedText() {
        AppMethodBeat.i(181801);
        Editable text = getText();
        g selection = getSelection();
        if (selection.avh < 0 || selection.Pc < 0 || selection.Pc > text.length()) {
            AppMethodBeat.o(181801);
            return null;
        }
        String charSequence = text.subSequence(selection.avh, selection.Pc).toString();
        AppMethodBeat.o(181801);
        return charSequence;
    }

    public g getSelection() {
        AppMethodBeat.i(181802);
        g gVar = new g(getSelectionStart(), getSelectionEnd());
        AppMethodBeat.o(181802);
        return gVar;
    }

    public final String a(h hVar) {
        AppMethodBeat.i(181803);
        if (hVar == h.qRF) {
            String obj = getText().toString();
            AppMethodBeat.o(181803);
            return obj;
        } else if (hVar == h.qRG) {
            String a2 = com.tencent.mm.plugin.editor.model.nativenote.a.b.a(getText());
            AppMethodBeat.o(181803);
            return a2;
        } else {
            AppMethodBeat.o(181803);
            return "";
        }
    }

    public int getRecyclerItemPosition() {
        AppMethodBeat.i(181804);
        if (this.qRh.lQ() == -1) {
            AppMethodBeat.o(181804);
            return 0;
        }
        int lQ = this.qRh.lQ();
        AppMethodBeat.o(181804);
        return lQ;
    }

    public int getEditTextType() {
        return this.qRf;
    }

    public void setEditTextType(int i2) {
        this.qRf = i2;
    }

    @Override // com.tencent.mm.ui.widget.edittext.PasterEditText
    public boolean onTextContextMenuItem(int i2) {
        AppMethodBeat.i(181805);
        if (i2 == 16908319) {
            this.qQV.cDj();
            AppMethodBeat.o(181805);
            return true;
        }
        if (i2 == 16908321 || i2 == 16908320) {
            b.clearData();
        } else if (i2 == 16908322) {
            getContext();
            int cDn = b.cDn();
            if (cDn == 2) {
                b.clearData();
            } else if (cDn == 3) {
                this.qQV.b(this);
                AppMethodBeat.o(181805);
                return true;
            }
        }
        try {
            boolean onTextContextMenuItem = super.onTextContextMenuItem(i2);
            if (i2 == 16908322) {
                this.qRC = 0;
                Editable text = getText();
                try {
                    b(text);
                } catch (IndexOutOfBoundsException e2) {
                    Log.e("noteeditor.WXRTEditText", "!!MMEditText Exception %d", Integer.valueOf(this.qRC));
                    if (this.qRC < 3) {
                        this.qRC++;
                        b(new SpannableStringBuilder(TextUtils.concat(" ", text)));
                    } else {
                        AppMethodBeat.o(181805);
                        throw e2;
                    }
                }
            }
            if (i2 == 16908322 && this.qPI) {
                if (this.qQV != null) {
                    this.qQV.e(false, 0);
                    this.qQV.Fv(0);
                }
                this.qPI = false;
            }
            AppMethodBeat.o(181805);
            return onTextContextMenuItem;
        } catch (NullPointerException e3) {
            Log.e("noteeditor.WXRTEditText", "!!MMEditText NullPointerException %s", e3);
            AppMethodBeat.o(181805);
            return false;
        }
    }

    private void b(Spannable spannable) {
        AppMethodBeat.i(181806);
        int selectionStart = getSelectionStart();
        setSpannableText(g.gxZ().a(getContext(), spannable, getTextSize()));
        int length = getText().length() - spannable.length();
        if (length > 0) {
            int i2 = selectionStart + length;
            if (i2 <= getText().length()) {
                setSelection(i2);
            }
            AppMethodBeat.o(181806);
            return;
        }
        setSelection(selectionStart);
        AppMethodBeat.o(181806);
    }

    public final synchronized void cDH() {
        this.qQZ = true;
    }

    public final synchronized void cDI() {
        this.qQZ = false;
    }

    public final synchronized void cDJ() {
        this.qQY = true;
    }

    public final synchronized void cDK() {
        this.qQY = false;
    }

    public void onSpanAdded(Spannable spannable, Object obj, int i2, int i3) {
        AppMethodBeat.i(181807);
        this.qRi = true;
        if ((obj instanceof h) && (obj instanceof ParagraphStyle)) {
            setParagraphsAreUp2Date(false);
        }
        AppMethodBeat.o(181807);
    }

    public void onSpanRemoved(Spannable spannable, Object obj, int i2, int i3) {
        AppMethodBeat.i(181808);
        this.qRi = true;
        if ((obj instanceof h) && (obj instanceof ParagraphStyle)) {
            setParagraphsAreUp2Date(false);
        }
        AppMethodBeat.o(181808);
    }

    public void onSpanChanged(Spannable spannable, Object obj, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(181809);
        this.qRi = true;
        if ((obj instanceof h) && (obj instanceof ParagraphStyle)) {
            setParagraphsAreUp2Date(false);
        }
        AppMethodBeat.o(181809);
    }

    public final <V, C extends h<V>> void a(t<V, C> tVar, V v) {
        AppMethodBeat.i(181810);
        if (this.qRn || this.qRk) {
            AppMethodBeat.o(181810);
            return;
        }
        Spannable cDG = this.qQZ ? null : cDG();
        tVar.a(this, v);
        synchronized (this) {
            try {
                if (this.qQV != null && !this.qQZ) {
                    Spannable cDG2 = cDG();
                    c cVar = this.qQV;
                    getSelectionStart();
                    getSelectionEnd();
                    getSelectionStart();
                    cVar.a(this, cDG, cDG2, getSelectionEnd());
                }
                this.qRo = true;
            } finally {
                AppMethodBeat.o(181810);
            }
        }
    }

    private void cDL() {
        AppMethodBeat.i(181811);
        Editable text = getText();
        if (text.getSpans(0, text.length(), getClass()) != null) {
            text.setSpan(this, 0, text.length(), 18);
        }
        AppMethodBeat.o(181811);
    }

    private synchronized void setParagraphsAreUp2Date(boolean z) {
        if (!this.qRm) {
            this.qRl = z;
        }
    }

    public g getParagraphsInSelection() {
        int i2;
        int i3;
        int i4 = 0;
        AppMethodBeat.i(181812);
        i rTLayout = getRTLayout();
        g gVar = new g(this);
        int lineForOffset = rTLayout.getLineForOffset(gVar.avh);
        if (gVar.isEmpty()) {
            i2 = gVar.Pc;
        } else {
            i2 = gVar.Pc - 1;
        }
        int lineForOffset2 = rTLayout.getLineForOffset(i2);
        if (rTLayout.qRI == 0 || lineForOffset < 0) {
            i3 = 0;
        } else if (lineForOffset < rTLayout.qRI) {
            i3 = rTLayout.qRJ.get(lineForOffset).avh;
        } else {
            i3 = rTLayout.qRJ.get(rTLayout.qRI - 1).Pc - 1;
        }
        if (rTLayout.qRI != 0 && lineForOffset2 >= 0) {
            i4 = lineForOffset2 < rTLayout.qRI ? rTLayout.qRJ.get(lineForOffset2).Pc : rTLayout.qRJ.get(rTLayout.qRI - 1).Pc - 1;
        }
        g gVar2 = new g(i3, i4);
        AppMethodBeat.o(181812);
        return gVar2;
    }

    public ArrayList<l> getParagraphs() {
        AppMethodBeat.i(181813);
        ArrayList<l> arrayList = getRTLayout().qRJ;
        AppMethodBeat.o(181813);
        return arrayList;
    }

    private i getRTLayout() {
        i iVar;
        AppMethodBeat.i(181814);
        synchronized (this) {
            try {
                if (this.qRp == null || this.qRo) {
                    this.qRp = new i(getText());
                    this.qRo = false;
                }
                iVar = this.qRp;
            } finally {
                AppMethodBeat.o(181814);
            }
        }
        return iVar;
    }

    public String getCurrentEditorCursorParagraphStr() {
        AppMethodBeat.i(181815);
        g paragraphsInSelection = getParagraphsInSelection();
        String trim = getText().subSequence(paragraphsInSelection.avh, paragraphsInSelection.Pc).toString().trim();
        AppMethodBeat.o(181815);
        return trim;
    }

    public k[] getCurrentEditorCursorNumberSpan() {
        AppMethodBeat.i(181816);
        g paragraphsInSelection = getParagraphsInSelection();
        k[] kVarArr = (k[]) getText().getSpans(paragraphsInSelection.avh, paragraphsInSelection.Pc, k.class);
        AppMethodBeat.o(181816);
        return kVarArr;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c4 A[Catch:{ Exception -> 0x0156 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r17) {
        /*
        // Method dump skipped, instructions count: 572
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText.onDraw(android.graphics.Canvas):void");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        AppMethodBeat.i(181818);
        if (e.isEnabled()) {
            Editable text = getText();
            if (text == null) {
                cDN();
                AppMethodBeat.o(181818);
                return true;
            }
            int length = text.length();
            int offsetForPosition = getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
            if (length < 0 || offsetForPosition < 0 || offsetForPosition > length) {
                cDN();
                AppMethodBeat.o(181818);
                return true;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    int x = (int) motionEvent.getX();
                    Layout layout = getLayout();
                    int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((int) motionEvent.getY()), (float) x);
                    s[] sVarArr = (s[]) getText().getSpans(offsetForHorizontal, offsetForHorizontal + 1, s.class);
                    if (e.cDT().isEditable() && x < f.cDE() && sVarArr.length != 0) {
                        Log.i("noteeditor.WXRTEditText", "clicked todo");
                        sVarArr[0].a(this, text, motionEvent, sVarArr[0]);
                        break;
                    } else {
                        cDN();
                        this.qRu.a(1, motionEvent.getRawX(), motionEvent.getRawY(), motionEvent.getX(), motionEvent.getY(), offsetForPosition);
                        cDM();
                        this.cve.startTimer(500, 0);
                        break;
                    }
                    break;
                case 1:
                    cDM();
                    if (this.qRu != null) {
                        b bVar = this.qRu;
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float x2 = motionEvent.getX();
                        float y = motionEvent.getY();
                        bVar.qSg = rawX;
                        bVar.qSh = rawY;
                        bVar.qSi = x2;
                        bVar.qSj = y;
                        if (bVar.qcr == 1) {
                            bVar.qSk = offsetForPosition;
                        } else {
                            bVar.qSk = 0;
                        }
                        int type = this.qRu.getType();
                        cDN();
                        if (type == 2) {
                            if (!e.cDT().isEditable()) {
                                d cDV = e.cDT().cDV();
                                if (e.cDT().cEb() && cDV.getSelectType() == 1 && cDV.bNu == this.qRs && cDV.startOffset == offsetForPosition) {
                                    z3 = true;
                                }
                                fz(offsetForPosition, offsetForPosition);
                                e cDT = e.cDT();
                                if (e.mHasInit) {
                                    cDT.cEc();
                                    cDT.cEa();
                                    cDT.f(true, 50);
                                    cDT.ln(true);
                                    cDT.lm(z3);
                                    break;
                                }
                            } else {
                                if (!hasFocus()) {
                                    requestFocus();
                                    z = false;
                                    z2 = false;
                                } else if (getSelectionStart() == getSelectionEnd() && offsetForPosition == getSelectionStart()) {
                                    z = true;
                                    z2 = true;
                                } else {
                                    z = false;
                                    z2 = true;
                                }
                                setIgnoreSelectChangeByMultiSelect(true);
                                setSelection(offsetForPosition);
                                setIgnoreSelectChangeByMultiSelect(false);
                                if (this.qQV != null) {
                                    this.qQV.e(true, 50);
                                    this.qQV.Fv(1);
                                }
                                fz(offsetForPosition, offsetForPosition);
                                e.cDT().I(z2, z);
                                break;
                            }
                        }
                    }
                    break;
                case 3:
                    cDN();
                    cDM();
                    break;
            }
            AppMethodBeat.o(181818);
            return true;
        }
        if (motionEvent.getAction() == 1 && this.qQV != null) {
            this.qQV.e(true, 300);
            this.qQV.Fv(1);
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(181818);
        return onTouchEvent;
    }

    private void cDM() {
        AppMethodBeat.i(181819);
        if (this.cve == null) {
            this.cve = new MTimerHandler(new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText.AnonymousClass3 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(181786);
                    if (WXRTEditText.this.qRu != null && WXRTEditText.this.qRu.getType() == 1) {
                        int i2 = WXRTEditText.this.qRu.qSf;
                        WXRTEditText.p(WXRTEditText.this);
                        WXRTEditText.this.ah(i2, false);
                    }
                    AppMethodBeat.o(181786);
                    return true;
                }
            }, false);
            AppMethodBeat.o(181819);
            return;
        }
        this.cve.stopTimer();
        AppMethodBeat.o(181819);
    }

    public final void ah(int i2, boolean z) {
        int i3;
        int i4;
        AppMethodBeat.i(181820);
        Editable text = getText();
        if (text == null) {
            AppMethodBeat.o(181820);
            return;
        }
        Layout layout = getLayout();
        if (layout == null) {
            AppMethodBeat.o(181820);
            return;
        }
        int length = text.length();
        if (i2 < 0 || i2 > length) {
            AppMethodBeat.o(181820);
            return;
        }
        if (length == 0) {
            i3 = 0;
            i4 = 0;
        } else {
            if (i2 < length) {
                if (z || text.charAt(i2) != '\n') {
                    i3 = layout.getOffsetToRightOf(i2);
                    i4 = i2;
                }
            } else if (i2 == length && z) {
                i4 = layout.getOffsetToLeftOf(i2);
                i3 = i2;
            }
            i3 = i2;
            i4 = i2;
        }
        if (i4 < 0 || i4 > length || i3 < 0 || i3 > length) {
            AppMethodBeat.o(181820);
            return;
        }
        if (e.cDT().isEditable()) {
            requestFocus();
            setIgnoreSelectChangeByMultiSelect(true);
            setSelection(i4, i3);
            setIgnoreSelectChangeByMultiSelect(false);
            if (this.qQV != null) {
                this.qQV.e(true, 50);
                this.qQV.Fv(1);
            }
        }
        fz(i4, i3);
        e.cDT().I(true, true);
        AppMethodBeat.o(181820);
    }

    private void cDN() {
        AppMethodBeat.i(181821);
        if (this.qRu == null) {
            this.qRu = new b();
            AppMethodBeat.o(181821);
            return;
        }
        this.qRu.reset();
        AppMethodBeat.o(181821);
    }

    private void fz(int i2, int i3) {
        AppMethodBeat.i(181822);
        if (this.qRf == 2) {
            e.cDT().B(this.qRs, 1, this.qRs, 1);
            AppMethodBeat.o(181822);
        } else if (this.qRf == 1) {
            e.cDT().B(this.qRs, 0, this.qRs, 0);
            AppMethodBeat.o(181822);
        } else {
            e cDT = e.cDT();
            int i4 = this.qRs;
            cDT.B(i4, i2, i4, i3);
            AppMethodBeat.o(181822);
        }
    }

    public int getPosInDataList() {
        return this.qRs;
    }

    public void setPosInDataList(int i2) {
        this.qRs = i2;
    }

    public void setIgnoreSelectChangeByMultiSelect(boolean z) {
        this.qRv = z;
    }

    public final void a(c cVar) {
        AppMethodBeat.i(181791);
        if (this.qRf == 0) {
            setTextSize(0, (float) com.tencent.mm.cb.a.aG(getContext(), R.dimen.is));
        }
        f.setTextSize(getTextSize());
        this.qQV = cVar;
        AppMethodBeat.o(181791);
    }
}
