package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.vendor.MIUI;
import com.tencent.mm.ui.widget.cedit.api.c;
import com.tencent.mm.ui.widget.edittext.PasterEditText;
import com.tencent.mm.ui.widget.edittext.a;
import java.util.List;

public class MMEditText extends PasterEditText implements com.tencent.mm.ui.widget.cedit.api.c {
    private InputConnection QCI;
    private boolean QCJ = false;
    private a QCK;
    private d QCL;
    private com.tencent.mm.ui.widget.edittext.a QCM;
    int qRC = 0;

    public interface a {
        void onBack();
    }

    public interface b {
        void boS();
    }

    public interface d {
        boolean aiD(int i2);
    }

    public MMEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public MMEditText(Context context) {
        super(context);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setEnableSendBtn(boolean z) {
        this.QCJ = z;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        AppMethodBeat.i(143354);
        this.QCI = super.onCreateInputConnection(editorInfo);
        if (this.QCI != null && this.QCJ) {
            editorInfo.imeOptions &= -1073741825;
            editorInfo.inputType &= -131073;
        }
        InputConnection inputConnection = this.QCI;
        AppMethodBeat.o(143354);
        return inputConnection;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public InputConnection getInputConnection() {
        return this.QCI;
    }

    public MMEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final void bol(String str) {
        InputFilter[] filters;
        int i2;
        AppMethodBeat.i(143355);
        getContext();
        int db = com.tencent.mm.ui.g.c.b.db(getText().toString(), getSelectionStart());
        getContext();
        int db2 = com.tencent.mm.ui.g.c.b.db(getText().toString(), getSelectionEnd());
        StringBuffer stringBuffer = new StringBuffer(getText());
        String str2 = stringBuffer.substring(0, db) + str + stringBuffer.substring(db2, stringBuffer.length());
        int i3 = -1;
        if (com.tencent.mm.compatible.util.d.oD(21) && (filters = getFilters()) != null) {
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
            setText(com.tencent.mm.ui.g.c.b.c(getContext(), str2, getTextSize()));
            setSelection(length2);
            AppMethodBeat.o(143355);
            return;
        }
        Log.d("MicroMsg.MMEditText", "exceed :%s, %s", Integer.valueOf(i3), Integer.valueOf(length2));
        AppMethodBeat.o(143355);
    }

    public final void gYD() {
        AppMethodBeat.i(205385);
        if (getInputConnection() != null) {
            getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
            getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
            AppMethodBeat.o(205385);
            return;
        }
        dispatchKeyEvent(new KeyEvent(0, 67));
        dispatchKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(205385);
    }

    public boolean requestFocus(int i2, Rect rect) {
        boolean z = false;
        AppMethodBeat.i(143356);
        try {
            z = super.requestFocus(i2, rect);
            AppMethodBeat.o(143356);
        } catch (IllegalStateException e2) {
            Log.e("MicroMsg.MMEditText", "[requestFocus] error:%s", e2);
            AppMethodBeat.o(143356);
        }
        return z;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setSelection(int i2) {
        AppMethodBeat.i(143357);
        try {
            super.setSelection(i2);
            AppMethodBeat.o(143357);
        } catch (IndexOutOfBoundsException e2) {
            Log.printErrStackTrace("MicroMsg.MMEditText", e2, "IndexOutOfBoundsExceptionindex = ".concat(String.valueOf(i2)), new Object[0]);
            AppMethodBeat.o(143357);
        }
    }

    public void setSelection(int i2, int i3) {
        AppMethodBeat.i(143358);
        super.setSelection(i2, i3);
        AppMethodBeat.o(143358);
    }

    @Override // com.tencent.mm.ui.widget.edittext.PasterEditText
    public boolean onTextContextMenuItem(int i2) {
        boolean z;
        AppMethodBeat.i(143359);
        try {
            z = super.onTextContextMenuItem(i2);
        } catch (IndexOutOfBoundsException e2) {
            Log.e("MicroMsg.MMEditText", "!!MMEditText IndexOutOfBoundsException %s", e2);
            z = false;
        } catch (NullPointerException e3) {
            Log.e("MicroMsg.MMEditText", "!!MMEditText NullPointerException %s", e3);
            AppMethodBeat.o(143359);
            return false;
        }
        if (i2 == 16908322) {
            this.qRC = 0;
            String obj = getText().toString();
            try {
                beu(obj);
            } catch (IndexOutOfBoundsException e4) {
                Log.e("MicroMsg.MMEditText", "!!MMEditText Exception %d", Integer.valueOf(this.qRC));
                if (this.qRC < 3) {
                    this.qRC++;
                    beu(" ".concat(String.valueOf(obj)));
                } else {
                    AppMethodBeat.o(143359);
                    throw e4;
                }
            }
        }
        AppMethodBeat.o(143359);
        return z;
    }

    private void beu(String str) {
        AppMethodBeat.i(143360);
        int selectionStart = getSelectionStart();
        setText(com.tencent.mm.ui.g.c.b.c(getContext(), str, getTextSize()));
        int length = getText().length() - str.length();
        if (length > 0) {
            int i2 = selectionStart + length;
            if (i2 <= getText().length()) {
                setSelection(i2);
            }
            AppMethodBeat.o(143360);
            return;
        }
        setSelection(selectionStart);
        AppMethodBeat.o(143360);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setBackListener(a aVar) {
        this.QCK = aVar;
    }

    public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(143361);
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.QCK == null);
        objArr[1] = Integer.valueOf(i2);
        Log.v("MicroMsg.MMEditText", "on onKeyPreIme, listener null ? %B keycode:%s", objArr);
        if (this.QCK != null && i2 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Log.v("MicroMsg.MMEditText", "on onKeyPreIme action down");
                KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    keyDispatcherState.startTracking(keyEvent, this);
                }
                AppMethodBeat.o(143361);
                return true;
            } else if (keyEvent.getAction() == 1) {
                Log.v("MicroMsg.MMEditText", "on onKeyPreIme action up");
                KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                if (keyDispatcherState2 != null) {
                    keyDispatcherState2.handleUpEvent(keyEvent);
                }
                if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                    Log.v("MicroMsg.MMEditText", "on onKeyPreIme action up is tracking");
                    this.QCK.onBack();
                    InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
                    if (inputMethodManager != null) {
                        inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
                    }
                    AppMethodBeat.o(143361);
                    return true;
                }
            }
        }
        if (this.QCL == null || !this.QCL.aiD(i2)) {
            boolean onKeyPreIme = super.onKeyPreIme(i2, keyEvent);
            AppMethodBeat.o(143361);
            return onKeyPreIme;
        }
        AppMethodBeat.o(143361);
        return true;
    }

    public static class c implements TextWatcher {
        private TextView QCP;
        public b QCQ = null;
        private boolean QCR = false;
        private final int limit;
        private EditText nBD;

        public c(EditText editText, TextView textView, int i2) {
            this.nBD = editText;
            this.QCP = textView;
            this.limit = i2;
        }

        public final void afterTextChanged(Editable editable) {
            int i2 = 0;
            AppMethodBeat.i(143352);
            String obj = editable.toString();
            String str = "";
            int i3 = 0;
            for (int i4 = 0; i4 < obj.length(); i4++) {
                if (Util.isChinese(obj.charAt(i4))) {
                    i3 += 2;
                } else {
                    i3++;
                }
                if (i3 > this.limit) {
                    break;
                }
                str = str + obj.charAt(i4);
            }
            if (i3 > this.limit) {
                try {
                    this.nBD.setText(str);
                    if (!this.QCR) {
                        this.nBD.setSelection(this.nBD.getText().toString().length());
                    } else {
                        this.nBD.setSelection(0);
                    }
                    this.QCR = false;
                } catch (Exception e2) {
                    this.QCR = true;
                    Log.e("MicroMsg.MMEditText", "error ".concat(String.valueOf(e2.getMessage())));
                    this.nBD.setText(str);
                    this.nBD.setSelection(0);
                }
            }
            int i5 = this.limit - i3;
            if (i5 >= 0) {
                i2 = i5;
            }
            if (this.QCP != null) {
                this.QCP.setText(new StringBuilder().append(i2 / 2).toString());
            }
            AppMethodBeat.o(143352);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AppMethodBeat.i(143353);
            if (this.QCQ != null) {
                this.QCQ.boS();
            }
            AppMethodBeat.o(143353);
        }
    }

    public static boolean gYE() {
        AppMethodBeat.i(205386);
        if (!MIUI.ifMIUI() || !com.tencent.mm.compatible.util.d.oD(28)) {
            AppMethodBeat.o(205386);
            return false;
        }
        AppMethodBeat.o(205386);
        return true;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final void a(final c.a aVar) {
        AppMethodBeat.i(205387);
        if (aVar == null) {
            AppMethodBeat.o(205387);
            return;
        }
        setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.ui.widget.MMEditText.AnonymousClass1 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(205384);
                if (textView instanceof com.tencent.mm.ui.widget.cedit.api.c) {
                    boolean ZY = aVar.ZY(i2);
                    AppMethodBeat.o(205384);
                    return ZY;
                }
                AppMethodBeat.o(205384);
                return false;
            }
        });
        AppMethodBeat.o(205387);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setKeyCodeEnterListener(d dVar) {
        this.QCL = dVar;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final void onPause() {
        AppMethodBeat.i(205388);
        if (this.QCM != null) {
            this.QCM.hby();
        }
        AppMethodBeat.o(205388);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final void destroy() {
        AppMethodBeat.i(205389);
        if (this.QCM != null) {
            this.QCM.destroy();
        }
        AppMethodBeat.o(205389);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final void a(List<String> list, List<String> list2, String str, a.e eVar) {
        AppMethodBeat.i(205390);
        a.C2143a aVar = new a.C2143a(this);
        if (list != null) {
            aVar.QPy.addAll(list);
        }
        if (list2 != null) {
            aVar.QHA.addAll(list2);
        }
        aVar.QPz = str;
        this.QCM = new com.tencent.mm.ui.widget.edittext.a(aVar, (byte) 0);
        this.QCM.QLI = eVar;
        AppMethodBeat.o(205390);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final void gYF() {
        AppMethodBeat.i(205391);
        if (this.QCM != null) {
            this.QCM.hby();
        }
        AppMethodBeat.o(205391);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final void CS(boolean z) {
        AppMethodBeat.i(205392);
        if (this.QCM != null) {
            if (!z) {
                com.tencent.mm.ui.widget.edittext.a aVar = this.QCM;
                aVar.mIsPause = true;
                aVar.hby();
                AppMethodBeat.o(205392);
                return;
            }
            com.tencent.mm.ui.widget.edittext.a aVar2 = this.QCM;
            aVar2.hby();
            aVar2.mIsPause = false;
        }
        AppMethodBeat.o(205392);
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
        return false;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final ViewParent gYI() {
        AppMethodBeat.i(205393);
        ViewParent parent = getParent();
        AppMethodBeat.o(205393);
        return parent;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(205394);
        if (this.QCM == null || onClickListener == null || onClickListener.getClass().getName().contains("SelectableEditTextHelper")) {
            super.setOnClickListener(onClickListener);
            AppMethodBeat.o(205394);
            return;
        }
        this.QCM.QPh = onClickListener;
        AppMethodBeat.o(205394);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        AppMethodBeat.i(205395);
        if (this.QCM == null || onFocusChangeListener == null || onFocusChangeListener.getClass().getName().contains("SelectableEditTextHelper")) {
            super.setOnFocusChangeListener(onFocusChangeListener);
            AppMethodBeat.o(205395);
            return;
        }
        this.QCM.QPg = onFocusChangeListener;
        AppMethodBeat.o(205395);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        AppMethodBeat.i(205396);
        if (this.QCM == null || onTouchListener == null || onTouchListener.getClass().getName().contains("SelectableEditTextHelper")) {
            super.setOnTouchListener(onTouchListener);
            AppMethodBeat.o(205396);
            return;
        }
        this.QCM.QPf = onTouchListener;
        AppMethodBeat.o(205396);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        AppMethodBeat.i(205397);
        if (this.QCM == null || onLongClickListener == null || onLongClickListener.getClass().getName().contains("SelectableEditTextHelper")) {
            super.setOnLongClickListener(onLongClickListener);
            AppMethodBeat.o(205397);
            return;
        }
        this.QCM.QPe = onLongClickListener;
        AppMethodBeat.o(205397);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final boolean gYJ() {
        AppMethodBeat.i(205398);
        boolean requestFocus = requestFocus();
        AppMethodBeat.o(205398);
        return requestFocus;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final Context gYK() {
        AppMethodBeat.i(205399);
        Context context = getContext();
        AppMethodBeat.o(205399);
        return context;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c
    public final int gYL() {
        AppMethodBeat.i(205400);
        int width = getWidth();
        AppMethodBeat.o(205400);
        return width;
    }
}
