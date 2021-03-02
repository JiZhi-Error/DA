package com.tencent.mm.ui.widget.cedit.api;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.g.c.b;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.cedit.api.c;
import com.tencent.mm.ui.widget.cedit.edit.CustomTextView;
import com.tencent.mm.ui.widget.edittext.a;
import java.util.HashMap;
import java.util.List;

public class MMCustomEditText extends PasterEditTextCompact implements c {
    private static final String QCU = "^[\\u0001-\\u00b7\\u4E00-\\u9FA5\\ue001-\\ue537\\u2005-\\u2027\\u3001-\\u3011\\uff01-\\uffe5\\u2100-\\u2900[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]]+$".substring(1, 149);
    private InputConnection QCI;
    private boolean QCJ;
    private MMEditText.a QCK;
    private MMEditText.d QCL;
    private boolean QFP;
    private a QFQ;
    int qRC;

    public MMCustomEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(205451);
        this.QCJ = false;
        this.QFP = false;
        this.qRC = 0;
        this.QFQ = new a() {
            /* class com.tencent.mm.ui.widget.cedit.api.MMCustomEditText.AnonymousClass2 */

            @Override // com.tencent.mm.ui.widget.cedit.api.a
            public final void a(Throwable th, String str, String str2) {
                AppMethodBeat.i(205450);
                HashMap hashMap = new HashMap();
                hashMap.put("Content", str);
                hashMap.put("Exception", th.toString());
                hashMap.put("Stack", th.getStackTrace());
                h.INSTANCE.e("CustomEditView", str2, hashMap);
                AppMethodBeat.o(205450);
            }
        };
        AppMethodBeat.o(205451);
    }

    @Override // com.tencent.mm.ui.widget.cedit.edit.CustomTextView
    public final void b(Context context, AttributeSet attributeSet, int i2, int i3) {
        AppMethodBeat.i(205452);
        try {
            super.b(context, attributeSet, i2, i3);
            AppMethodBeat.o(205452);
        } catch (Throwable th) {
            Log.e("MicroMsg.MMCustomEditText", "init crash:%s", Util.stackTraceToString(th));
            b.aow(0);
            this.QFP = true;
            AppMethodBeat.o(205452);
        }
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setEnableSendBtn(boolean z) {
        this.QCJ = z;
    }

    @Override // com.tencent.mm.ui.widget.cedit.edit.CustomTextView
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        AppMethodBeat.i(205453);
        this.QCI = super.onCreateInputConnection(editorInfo);
        if (this.QCI != null && this.QCJ) {
            editorInfo.imeOptions &= -1073741825;
            editorInfo.inputType &= -131073;
        }
        InputConnection inputConnection = this.QCI;
        AppMethodBeat.o(205453);
        return inputConnection;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public InputConnection getInputConnection() {
        return this.QCI;
    }

    public MMCustomEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.QCJ = false;
        this.QFP = false;
        this.qRC = 0;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final void bol(String str) {
        InputFilter[] filters;
        int i2;
        AppMethodBeat.i(205454);
        getContext();
        int db = b.db(getText().toString(), getSelectionStart());
        getContext();
        int db2 = b.db(getText().toString(), getSelectionEnd());
        StringBuffer stringBuffer = new StringBuffer(getText());
        String str2 = stringBuffer.substring(0, db) + str + stringBuffer.substring(db2, stringBuffer.length());
        int i3 = -1;
        if (d.oD(21) && (filters = getFilters()) != null) {
            int length = filters.length;
            int i4 = 0;
            while (i4 < length) {
                InputFilter inputFilter = filters[i4];
                if (inputFilter instanceof InputFilter.LengthFilter) {
                    i2 = ((InputFilter.LengthFilter) inputFilter).getMax();
                } else {
                    i2 = i3;
                }
                i4++;
                i3 = i2;
            }
        }
        int length2 = str.length() + db;
        if (i3 <= 0 || length2 <= i3) {
            setText(b.c(getContext(), str2, getTextSize()));
            setSelection(length2);
            AppMethodBeat.o(205454);
            return;
        }
        Log.d("MicroMsg.MMCustomEditText", "exceed :%s, %s", Integer.valueOf(i3), Integer.valueOf(length2));
        AppMethodBeat.o(205454);
    }

    public boolean requestFocus(int i2, Rect rect) {
        boolean z = false;
        AppMethodBeat.i(205455);
        try {
            z = super.requestFocus(i2, rect);
            AppMethodBeat.o(205455);
        } catch (IllegalStateException e2) {
            Log.e("MicroMsg.MMCustomEditText", "[requestFocus] error:%s", e2);
            AppMethodBeat.o(205455);
        }
        return z;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c, com.tencent.mm.ui.widget.cedit.edit.CustomEditText
    public void setSelection(int i2) {
        AppMethodBeat.i(205456);
        try {
            super.setSelection(i2);
            AppMethodBeat.o(205456);
        } catch (IndexOutOfBoundsException e2) {
            Log.printErrStackTrace("MicroMsg.MMCustomEditText", e2, "IndexOutOfBoundsExceptionindex = ".concat(String.valueOf(i2)), new Object[0]);
            AppMethodBeat.o(205456);
        }
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.PasterEditTextCompact, com.tencent.mm.ui.widget.cedit.edit.CustomTextView
    public boolean onTextContextMenuItem(int i2) {
        boolean z;
        AppMethodBeat.i(205457);
        try {
            z = super.onTextContextMenuItem(i2);
        } catch (IndexOutOfBoundsException e2) {
            Log.e("MicroMsg.MMCustomEditText", "!!MMEditText IndexOutOfBoundsException %s", e2);
            z = false;
        } catch (NullPointerException e3) {
            Log.e("MicroMsg.MMCustomEditText", "!!MMEditText NullPointerException %s", e3);
            AppMethodBeat.o(205457);
            return false;
        }
        if (i2 == 16908322) {
            this.qRC = 0;
            String obj = getText().toString();
            try {
                beu(obj);
            } catch (IndexOutOfBoundsException e4) {
                Log.e("MicroMsg.MMCustomEditText", "!!MMEditText Exception %d", Integer.valueOf(this.qRC));
                if (this.qRC < 3) {
                    this.qRC++;
                    beu(" ".concat(String.valueOf(obj)));
                } else {
                    AppMethodBeat.o(205457);
                    throw e4;
                }
            }
        }
        AppMethodBeat.o(205457);
        return z;
    }

    private void beu(String str) {
        AppMethodBeat.i(205458);
        int selectionStart = getSelectionStart();
        setText(b.c(getContext(), str, getTextSize()));
        int length = getText().length() - str.length();
        if (length > 0) {
            int i2 = selectionStart + length;
            if (i2 <= getText().length()) {
                setSelection(i2);
            }
            AppMethodBeat.o(205458);
            return;
        }
        setSelection(selectionStart);
        AppMethodBeat.o(205458);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setBackListener(MMEditText.a aVar) {
        this.QCK = aVar;
    }

    @Override // com.tencent.mm.ui.widget.cedit.edit.CustomTextView
    public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(205459);
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.QCK == null);
        objArr[1] = Integer.valueOf(i2);
        Log.v("MicroMsg.MMCustomEditText", "on onKeyPreIme, listener null ? %B keycode:%s", objArr);
        if (this.QCK != null && i2 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Log.v("MicroMsg.MMCustomEditText", "on onKeyPreIme action down");
                KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    keyDispatcherState.startTracking(keyEvent, this);
                }
                AppMethodBeat.o(205459);
                return true;
            } else if (keyEvent.getAction() == 1) {
                Log.v("MicroMsg.MMCustomEditText", "on onKeyPreIme action up");
                KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                if (keyDispatcherState2 != null) {
                    keyDispatcherState2.handleUpEvent(keyEvent);
                }
                if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                    Log.v("MicroMsg.MMCustomEditText", "on onKeyPreIme action up is tracking");
                    this.QCK.onBack();
                    InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
                    if (inputMethodManager != null) {
                        inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
                    }
                    AppMethodBeat.o(205459);
                    return true;
                }
            }
        }
        if (this.QCL == null || !this.QCL.aiD(i2)) {
            boolean onKeyPreIme = super.onKeyPreIme(i2, keyEvent);
            AppMethodBeat.o(205459);
            return onKeyPreIme;
        }
        AppMethodBeat.o(205459);
        return true;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final void a(final c.a aVar) {
        AppMethodBeat.i(205460);
        if (aVar == null) {
            AppMethodBeat.o(205460);
            return;
        }
        setOnEditorActionListener(new CustomTextView.c() {
            /* class com.tencent.mm.ui.widget.cedit.api.MMCustomEditText.AnonymousClass1 */

            @Override // com.tencent.mm.ui.widget.cedit.edit.CustomTextView.c
            public final boolean a(CustomTextView customTextView, int i2) {
                AppMethodBeat.i(205449);
                if (customTextView instanceof c) {
                    boolean ZY = aVar.ZY(i2);
                    AppMethodBeat.o(205449);
                    return ZY;
                }
                AppMethodBeat.o(205449);
                return false;
            }
        });
        AppMethodBeat.o(205460);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setKeyCodeEnterListener(MMEditText.d dVar) {
        this.QCL = dVar;
    }

    public void setEditCrashListener(a aVar) {
        this.QFQ = aVar;
    }

    static {
        AppMethodBeat.i(205472);
        AppMethodBeat.o(205472);
    }

    private String getFilterText() {
        AppMethodBeat.i(205461);
        Editable text = getText();
        if (text == null) {
            AppMethodBeat.o(205461);
            return "";
        }
        String replaceAll = text.toString().replaceAll(QCU, "*");
        AppMethodBeat.o(205461);
        return replaceAll;
    }

    @Override // com.tencent.mm.ui.widget.cedit.edit.CustomTextView
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(205462);
        try {
            super.onDraw(canvas);
            AppMethodBeat.o(205462);
        } catch (Throwable th) {
            String filterText = getFilterText();
            Log.e("MicroMsg.MMCustomEditText", "[onDraw] text:%s, e:%s", filterText, th);
            if (this.QFQ != null) {
                this.QFQ.a(th, filterText, "onDraw");
            }
            b.aow(2);
            com.tencent.mm.util.c cVar = com.tencent.mm.util.c.QYz;
            if (com.tencent.mm.util.c.hdg()) {
                AppMethodBeat.o(205462);
                throw th;
            } else {
                AppMethodBeat.o(205462);
            }
        }
    }

    @Override // com.tencent.mm.ui.widget.cedit.edit.CustomTextView
    public boolean onPreDraw() {
        boolean z = false;
        AppMethodBeat.i(205463);
        try {
            z = super.onPreDraw();
            AppMethodBeat.o(205463);
        } catch (Throwable th) {
            Log.e("MicroMsg.MMCustomEditText", "onPreDraw err:%s", Util.stackTraceToString(th));
            b.aow(8);
            AppMethodBeat.o(205463);
        }
        return z;
    }

    @Override // com.tencent.mm.ui.widget.cedit.edit.CustomTextView
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(205464);
        try {
            super.onMeasure(i2, i3);
            AppMethodBeat.o(205464);
        } catch (Throwable th) {
            String filterText = getFilterText();
            Log.e("MicroMsg.MMCustomEditText", "[onMeasure] text:%s, e:%s", filterText, th);
            if (this.QFQ != null) {
                this.QFQ.a(th, filterText, "onMeasure");
            }
            b.aow(1);
            com.tencent.mm.util.c cVar = com.tencent.mm.util.c.QYz;
            if (com.tencent.mm.util.c.hdg()) {
                AppMethodBeat.o(205464);
                throw th;
            } else {
                AppMethodBeat.o(205464);
            }
        }
    }

    @Override // com.tencent.mm.ui.widget.cedit.edit.CustomTextView
    public final void a(CharSequence charSequence, TextView.BufferType bufferType, boolean z, int i2) {
        AppMethodBeat.i(205465);
        try {
            super.a(charSequence, bufferType, z, i2);
            AppMethodBeat.o(205465);
        } catch (Throwable th) {
            String filterText = getFilterText();
            Log.e("MicroMsg.MMCustomEditText", "[setText] text:%s, e:%s", filterText, th);
            if (this.QFQ != null) {
                this.QFQ.a(th, filterText, "setText");
            }
            b.aow(3);
            com.tencent.mm.util.c cVar = com.tencent.mm.util.c.QYz;
            if (com.tencent.mm.util.c.hdg()) {
                AppMethodBeat.o(205465);
                throw th;
            } else {
                AppMethodBeat.o(205465);
            }
        }
    }

    @Override // com.tencent.mm.ui.widget.cedit.edit.CustomTextView
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        AppMethodBeat.i(205466);
        try {
            z = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(205466);
        } catch (Throwable th) {
            String filterText = getFilterText();
            Log.e("MicroMsg.MMCustomEditText", "[onTouchEvent] text:%s, e:%s", filterText, th);
            if (this.QFQ != null) {
                this.QFQ.a(th, filterText, "onTouchEvent");
            }
            b.aow(4);
            com.tencent.mm.util.c cVar = com.tencent.mm.util.c.QYz;
            if (com.tencent.mm.util.c.hdg()) {
                AppMethodBeat.o(205466);
                throw th;
            }
            AppMethodBeat.o(205466);
        }
        return z;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final void onPause() {
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final void destroy() {
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final void a(List<String> list, List<String> list2, String str, a.e eVar) {
        AppMethodBeat.i(205467);
        setReuseBrands(list);
        setReuseItems(list2);
        setHighlightColor(getContext().getResources().getColor(R.color.a6q));
        setMenuCallback(eVar);
        AppMethodBeat.o(205467);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final void gYF() {
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final void CS(boolean z) {
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final void refresh(boolean z) {
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final View gYG() {
        return this;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setPasterLen(int i2) {
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final boolean gYH() {
        return this.QFP;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final ViewParent gYI() {
        AppMethodBeat.i(205468);
        ViewParent parent = getParent();
        AppMethodBeat.o(205468);
        return parent;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final boolean gYJ() {
        AppMethodBeat.i(205469);
        boolean requestFocus = requestFocus();
        AppMethodBeat.o(205469);
        return requestFocus;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final Context gYK() {
        AppMethodBeat.i(205470);
        Context context = getContext();
        AppMethodBeat.o(205470);
        return context;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final int gYL() {
        AppMethodBeat.i(205471);
        int width = getWidth();
        AppMethodBeat.o(205471);
        return width;
    }
}
