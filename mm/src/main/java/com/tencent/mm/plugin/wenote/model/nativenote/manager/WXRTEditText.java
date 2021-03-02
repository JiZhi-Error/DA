package com.tencent.mm.plugin.wenote.model.nativenote.manager;

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
import com.tencent.mm.ce.g;
import com.tencent.mm.plugin.wenote.model.nativenote.a.a;
import com.tencent.mm.plugin.wenote.model.nativenote.b.c;
import com.tencent.mm.plugin.wenote.model.nativenote.c.b;
import com.tencent.mm.plugin.wenote.model.nativenote.c.d;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.i;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.k;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.m;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.n;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.edittext.PasterEditText;
import java.util.ArrayList;

public class WXRTEditText extends PasterEditText implements SpanWatcher {
    c JIp;
    private WXRTEditText JIq = null;
    private j JIr;
    private b JIs = null;
    public int afB = 0;
    private MTimerHandler cve = null;
    public boolean qPI = false;
    public int qPK = 0;
    private int qQW = -1;
    private int qQX = -1;
    private boolean qQY = false;
    private boolean qQZ;
    private boolean qRA = false;
    TextWatcher qRB = new TextWatcher() {
        /* class com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText.AnonymousClass2 */

        public final synchronized void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            String str;
            AppMethodBeat.i(30478);
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
            AppMethodBeat.o(30478);
        }

        public final synchronized void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AppMethodBeat.i(30479);
            WXRTEditText.this.qRo = true;
            AppMethodBeat.o(30479);
        }

        public final synchronized void afterTextChanged(Editable editable) {
            String str;
            AppMethodBeat.i(30480);
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
            if (WXRTEditText.this.JIp != null && !WXRTEditText.this.qQZ && !str.equals(obj)) {
                Spannable cDG = WXRTEditText.this.cDG();
                WXRTEditText.this.qRd = obj;
                c cVar = WXRTEditText.this.JIp;
                WXRTEditText wXRTEditText = WXRTEditText.this.JIq;
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
            AppMethodBeat.o(30480);
        }
    };
    int qRC = 0;
    private int qRa;
    private int qRb;
    private String qRc;
    public String qRd = "";
    private Spannable qRe;
    int qRf = 0;
    public RecyclerView.v qRh;
    private boolean qRi;
    private boolean qRj;
    private boolean qRk;
    private boolean qRl;
    private boolean qRm;
    private boolean qRn = false;
    private boolean qRo;
    public boolean qRq = false;
    public boolean qRr = false;
    private int qRs = -1;
    private Paint qRt = null;
    private boolean qRv = false;
    private Path qRw = null;
    private int qRx = -1;
    private int qRy = -1;
    private int qRz = -1;

    static /* synthetic */ void m(WXRTEditText wXRTEditText) {
        AppMethodBeat.i(30517);
        wXRTEditText.setParagraphsAreUp2Date(false);
        AppMethodBeat.o(30517);
    }

    static /* synthetic */ void n(WXRTEditText wXRTEditText) {
        AppMethodBeat.i(30518);
        wXRTEditText.cDL();
        AppMethodBeat.o(30518);
    }

    static /* synthetic */ void p(WXRTEditText wXRTEditText) {
        AppMethodBeat.i(30519);
        wXRTEditText.cDN();
        AppMethodBeat.o(30519);
    }

    public WXRTEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(30482);
        init();
        AppMethodBeat.o(30482);
    }

    public WXRTEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(30483);
        init();
        AppMethodBeat.o(30483);
    }

    public void setMaxHeight(int i2) {
        AppMethodBeat.i(30484);
        super.setMaxHeight(i2);
        AppMethodBeat.o(30484);
    }

    private void init() {
        AppMethodBeat.i(30485);
        this.JIq = this;
        removeTextChangedListener(this.qRB);
        addTextChangedListener(this.qRB);
        setMovementMethod(i.gka());
        this.qRs = -1;
        this.qRt = new Paint(1);
        this.qRt.setColor(1347529272);
        this.JIs = new b();
        this.qRw = new Path();
        this.qRx = -1;
        this.qRy = -1;
        this.qRz = -1;
        if (e.isEnabled()) {
            setHighlightColor(0);
            setCustomSelectionActionModeCallback(new ActionMode.Callback() {
                /* class com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText.AnonymousClass1 */

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
        AppMethodBeat.o(30485);
    }

    public void setRichTextEditing(String str) {
        AppMethodBeat.i(30486);
        cDH();
        if (!Util.isNullOrNil(str)) {
            setSpannableText(a.alS(str));
        } else {
            setText("");
        }
        cDI();
        AppMethodBeat.o(30486);
    }

    public void setSpannableText(Spanned spanned) {
        AppMethodBeat.i(30487);
        cDH();
        cDJ();
        super.setText(spanned, TextView.BufferType.EDITABLE);
        cDK();
        cDL();
        u.a(this, new t[0]);
        cDI();
        AppMethodBeat.o(30487);
    }

    public void setText(String str) {
        AppMethodBeat.i(30488);
        cDH();
        super.setText((CharSequence) str);
        cDI();
        AppMethodBeat.o(30488);
    }

    public void setTextWithoutIgnore(String str) {
        AppMethodBeat.i(30489);
        super.setText((CharSequence) str);
        AppMethodBeat.o(30489);
    }

    public final void cDF() {
        AppMethodBeat.i(30490);
        if (this.JIp != null) {
            this.JIp.e(true, 50);
            this.JIp.Fv(1);
        }
        AppMethodBeat.o(30490);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(30491);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(30491);
        return dispatchTouchEvent;
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        AppMethodBeat.i(30492);
        this.qRA = false;
        this.qQW = -1;
        this.qQX = -1;
        super.onFocusChanged(z, i2, rect);
        if (this.JIp != null) {
            this.JIp.a(this, z, getRecyclerItemPosition());
        }
        if (z && !this.qRA) {
            onSelectionChanged(getSelectionStart(), getSelectionEnd());
        }
        AppMethodBeat.o(30492);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(30493);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0022, code lost:
        if (r5.qQW != r6) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0026, code lost:
        if (r5.qQX == r7) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0028, code lost:
        r5.qQW = r6;
        r5.qQX = r7;
        super.onSelectionChanged(r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002f, code lost:
        if (r7 <= r6) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0031, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0032, code lost:
        r5.qRj = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0036, code lost:
        if (r5.qRk != false) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003a, code lost:
        if (r5.qRl != false) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003c, code lost:
        r5.qRm = true;
        com.tencent.mm.plugin.wenote.model.nativenote.spans.u.a(r5, new com.tencent.mm.plugin.wenote.model.nativenote.spans.t[0]);
        r5.qRm = false;
        setParagraphsAreUp2Date(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004a, code lost:
        if (r5.JIp == null) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004c, code lost:
        r5.qRn = true;
        r5.JIp.a(r5, r6, r7);
        r5.qRn = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0059, code lost:
        if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.isEnabled() == false) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005d, code lost:
        if (r5.qRv != false) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0063, code lost:
        if (hasFocus() == false) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0067, code lost:
        if (r5.qRs < 0) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0069, code lost:
        fz(r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0076, code lost:
        if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.gjW().FB(r5.qRs) != 1) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0078, code lost:
        r0 = com.tencent.mm.plugin.wenote.model.nativenote.c.e.gjW();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x007e, code lost:
        if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.mHasInit == false) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0080, code lost:
        r0.f(true, 0);
        r0.cEc();
        r0.cEa();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x008b, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(30493);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x008f, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        r5.qRA = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        if (r6 >= 0) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSelectionChanged(int r6, int r7) {
        /*
        // Method dump skipped, instructions count: 145
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText.onSelectionChanged(int, int):void");
    }

    public final Spannable cDG() {
        AppMethodBeat.i(30494);
        CharSequence text = super.getText();
        if (text == null) {
            text = "";
        }
        a aVar = new a(text);
        AppMethodBeat.o(30494);
        return aVar;
    }

    public String getSelectedText() {
        AppMethodBeat.i(30495);
        Editable text = getText();
        e selection = getSelection();
        if (selection.avh < 0 || selection.Pc < 0 || selection.Pc > text.length()) {
            AppMethodBeat.o(30495);
            return null;
        }
        String charSequence = text.subSequence(selection.avh, selection.Pc).toString();
        AppMethodBeat.o(30495);
        return charSequence;
    }

    public e getSelection() {
        AppMethodBeat.i(30496);
        e eVar = new e(getSelectionStart(), getSelectionEnd());
        AppMethodBeat.o(30496);
        return eVar;
    }

    public final String a(i iVar) {
        AppMethodBeat.i(30497);
        if (iVar == i.JIv) {
            String obj = getText().toString();
            AppMethodBeat.o(30497);
            return obj;
        } else if (iVar == i.JIw) {
            String a2 = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(getText());
            AppMethodBeat.o(30497);
            return a2;
        } else {
            AppMethodBeat.o(30497);
            return "";
        }
    }

    public int getRecyclerItemPosition() {
        AppMethodBeat.i(30498);
        if (this.qRh.lQ() == -1) {
            AppMethodBeat.o(30498);
            return 0;
        }
        int lQ = this.qRh.lQ();
        AppMethodBeat.o(30498);
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
        AppMethodBeat.i(30499);
        if (i2 == 16908319) {
            this.JIp.gjK();
            AppMethodBeat.o(30499);
            return true;
        }
        if (i2 == 16908321 || i2 == 16908320) {
            f.clearData();
        } else if (i2 == 16908322) {
            getContext();
            int cDn = f.cDn();
            if (cDn == 2) {
                f.clearData();
            } else if (cDn == 3) {
                this.JIp.b(this);
                AppMethodBeat.o(30499);
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
                        AppMethodBeat.o(30499);
                        throw e2;
                    }
                }
            }
            if (i2 == 16908322 && this.qPI) {
                if (this.JIp != null) {
                    this.JIp.e(false, 0);
                    this.JIp.Fv(0);
                }
                this.qPI = false;
            }
            AppMethodBeat.o(30499);
            return onTextContextMenuItem;
        } catch (NullPointerException e3) {
            Log.e("noteeditor.WXRTEditText", "!!MMEditText NullPointerException %s", e3);
            AppMethodBeat.o(30499);
            return false;
        }
    }

    private void b(Spannable spannable) {
        AppMethodBeat.i(30500);
        int selectionStart = getSelectionStart();
        setSpannableText(g.gxZ().a(getContext(), spannable, getTextSize()));
        int length = getText().length() - spannable.length();
        if (length > 0) {
            int i2 = selectionStart + length;
            if (i2 <= getText().length()) {
                setSelection(i2);
            }
            AppMethodBeat.o(30500);
            return;
        }
        setSelection(selectionStart);
        AppMethodBeat.o(30500);
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
        AppMethodBeat.i(30501);
        this.qRi = true;
        if ((obj instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.g) && (obj instanceof ParagraphStyle)) {
            setParagraphsAreUp2Date(false);
        }
        AppMethodBeat.o(30501);
    }

    public void onSpanRemoved(Spannable spannable, Object obj, int i2, int i3) {
        AppMethodBeat.i(30502);
        this.qRi = true;
        if ((obj instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.g) && (obj instanceof ParagraphStyle)) {
            setParagraphsAreUp2Date(false);
        }
        AppMethodBeat.o(30502);
    }

    public void onSpanChanged(Spannable spannable, Object obj, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(30503);
        this.qRi = true;
        if ((obj instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.g) && (obj instanceof ParagraphStyle)) {
            setParagraphsAreUp2Date(false);
        }
        AppMethodBeat.o(30503);
    }

    public final <V, C extends com.tencent.mm.plugin.wenote.model.nativenote.spans.g<V>> void a(t<V, C> tVar, V v) {
        AppMethodBeat.i(30504);
        if (this.qRn || this.qRk) {
            AppMethodBeat.o(30504);
            return;
        }
        Spannable cDG = this.qQZ ? null : cDG();
        tVar.a(this, v);
        synchronized (this) {
            try {
                if (this.JIp != null && !this.qQZ) {
                    Spannable cDG2 = cDG();
                    c cVar = this.JIp;
                    getSelectionStart();
                    getSelectionEnd();
                    getSelectionStart();
                    cVar.a(this, cDG, cDG2, getSelectionEnd());
                }
                this.qRo = true;
            } finally {
                AppMethodBeat.o(30504);
            }
        }
    }

    private void cDL() {
        AppMethodBeat.i(30505);
        Editable text = getText();
        if (text.getSpans(0, text.length(), getClass()) != null) {
            text.setSpan(this, 0, text.length(), 18);
        }
        AppMethodBeat.o(30505);
    }

    private synchronized void setParagraphsAreUp2Date(boolean z) {
        if (!this.qRm) {
            this.qRl = z;
        }
    }

    public e getParagraphsInSelection() {
        int i2;
        int i3;
        int i4 = 0;
        AppMethodBeat.i(30506);
        j rTLayout = getRTLayout();
        e eVar = new e(this);
        int lineForOffset = rTLayout.getLineForOffset(eVar.avh);
        if (eVar.isEmpty()) {
            i2 = eVar.Pc;
        } else {
            i2 = eVar.Pc - 1;
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
        e eVar2 = new e(i3, i4);
        AppMethodBeat.o(30506);
        return eVar2;
    }

    public ArrayList<n> getParagraphs() {
        AppMethodBeat.i(30507);
        ArrayList<n> arrayList = getRTLayout().qRJ;
        AppMethodBeat.o(30507);
        return arrayList;
    }

    private j getRTLayout() {
        j jVar;
        AppMethodBeat.i(30508);
        synchronized (this) {
            try {
                if (this.JIr == null || this.qRo) {
                    this.JIr = new j(getText());
                    this.qRo = false;
                }
                jVar = this.JIr;
            } finally {
                AppMethodBeat.o(30508);
            }
        }
        return jVar;
    }

    public String getCurrentEditorCursorParagraphStr() {
        AppMethodBeat.i(30509);
        e paragraphsInSelection = getParagraphsInSelection();
        String trim = getText().subSequence(paragraphsInSelection.avh, paragraphsInSelection.Pc).toString().trim();
        AppMethodBeat.o(30509);
        return trim;
    }

    public m[] getCurrentEditorCursorNumberSpan() {
        AppMethodBeat.i(30510);
        e paragraphsInSelection = getParagraphsInSelection();
        m[] mVarArr = (m[]) getText().getSpans(paragraphsInSelection.avh, paragraphsInSelection.Pc, m.class);
        AppMethodBeat.o(30510);
        return mVarArr;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c2 A[Catch:{ Exception -> 0x0154 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r17) {
        /*
        // Method dump skipped, instructions count: 570
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText.onDraw(android.graphics.Canvas):void");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        AppMethodBeat.i(30512);
        if (e.isEnabled()) {
            Editable text = getText();
            if (text == null) {
                cDN();
                AppMethodBeat.o(30512);
                return true;
            }
            int length = text.length();
            int offsetForPosition = getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
            if (length < 0 || offsetForPosition < 0 || offsetForPosition > length) {
                cDN();
                AppMethodBeat.o(30512);
                return true;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    int x = (int) motionEvent.getX();
                    Layout layout = getLayout();
                    int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((int) motionEvent.getY()), (float) x);
                    k[] kVarArr = (k[]) getText().getSpans(offsetForHorizontal, offsetForHorizontal + 1, k.class);
                    if (e.gjW().isEditable() && x < b.cDE() && kVarArr.length != 0) {
                        Log.i("noteeditor.WXRTEditText", "clicked todo");
                        this.JIp.gjJ();
                        kVarArr[0].a(this, text, motionEvent, kVarArr[0]);
                        break;
                    } else {
                        cDN();
                        this.JIs.a(1, motionEvent.getRawX(), motionEvent.getRawY(), motionEvent.getX(), motionEvent.getY(), offsetForPosition);
                        cDM();
                        this.cve.startTimer(500, 0);
                        break;
                    }
                    break;
                case 1:
                    cDM();
                    if (this.JIs != null) {
                        b bVar = this.JIs;
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
                        int type = this.JIs.getType();
                        cDN();
                        if (type == 2) {
                            if (!e.gjW().isEditable()) {
                                d gjX = e.gjW().gjX();
                                if (e.gjW().cEb() && gjX.getSelectType() == 1 && gjX.bNu == this.qRs && gjX.startOffset == offsetForPosition) {
                                    z3 = true;
                                }
                                fz(offsetForPosition, offsetForPosition);
                                e gjW = e.gjW();
                                if (e.mHasInit) {
                                    gjW.cEc();
                                    gjW.cEa();
                                    gjW.f(true, 50);
                                    gjW.ln(true);
                                    gjW.lm(z3);
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
                                if (this.JIp != null) {
                                    this.JIp.e(true, 50);
                                    this.JIp.Fv(1);
                                }
                                fz(offsetForPosition, offsetForPosition);
                                e.gjW().I(z2, z);
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
            AppMethodBeat.o(30512);
            return true;
        }
        if (motionEvent.getAction() == 1 && this.JIp != null) {
            this.JIp.e(true, 300);
            this.JIp.Fv(1);
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(30512);
        return onTouchEvent;
    }

    private void cDM() {
        AppMethodBeat.i(30513);
        if (this.cve == null) {
            this.cve = new MTimerHandler(new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText.AnonymousClass3 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(30481);
                    if (WXRTEditText.this.JIs != null && WXRTEditText.this.JIs.getType() == 1) {
                        int i2 = WXRTEditText.this.JIs.qSf;
                        WXRTEditText.p(WXRTEditText.this);
                        WXRTEditText.this.ah(i2, false);
                    }
                    AppMethodBeat.o(30481);
                    return true;
                }
            }, false);
            AppMethodBeat.o(30513);
            return;
        }
        this.cve.stopTimer();
        AppMethodBeat.o(30513);
    }

    public final void ah(int i2, boolean z) {
        int i3;
        int i4;
        AppMethodBeat.i(30514);
        Editable text = getText();
        if (text == null) {
            AppMethodBeat.o(30514);
            return;
        }
        Layout layout = getLayout();
        if (layout == null) {
            AppMethodBeat.o(30514);
            return;
        }
        int length = text.length();
        if (i2 < 0 || i2 > length) {
            AppMethodBeat.o(30514);
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
            AppMethodBeat.o(30514);
            return;
        }
        if (e.gjW().isEditable()) {
            requestFocus();
            setIgnoreSelectChangeByMultiSelect(true);
            setSelection(i4, i3);
            setIgnoreSelectChangeByMultiSelect(false);
            if (this.JIp != null) {
                this.JIp.e(true, 50);
                this.JIp.Fv(1);
            }
        }
        fz(i4, i3);
        e.gjW().I(true, true);
        AppMethodBeat.o(30514);
    }

    private void cDN() {
        AppMethodBeat.i(30515);
        if (this.JIs == null) {
            this.JIs = new b();
            AppMethodBeat.o(30515);
            return;
        }
        this.JIs.reset();
        AppMethodBeat.o(30515);
    }

    private void fz(int i2, int i3) {
        AppMethodBeat.i(30516);
        if (this.qRf == 2) {
            e.gjW().B(this.qRs, 1, this.qRs, 1);
            AppMethodBeat.o(30516);
        } else if (this.qRf == 1) {
            e.gjW().B(this.qRs, 0, this.qRs, 0);
            AppMethodBeat.o(30516);
        } else {
            e gjW = e.gjW();
            int i4 = this.qRs;
            gjW.B(i4, i2, i4, i3);
            AppMethodBeat.o(30516);
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
}
