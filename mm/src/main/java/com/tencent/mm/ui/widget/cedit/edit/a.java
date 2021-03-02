package com.tencent.mm.ui.widget.cedit.edit;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.cedit.edit.b;

public final class a extends BaseInputConnection {
    private final CustomTextView QIo;
    private int QIp;
    private InputMethodManager QIq;

    public a(CustomTextView customTextView) {
        super(customTextView, true);
        this.QIo = customTextView;
    }

    public final Editable getEditable() {
        AppMethodBeat.i(205864);
        CustomTextView customTextView = this.QIo;
        if (customTextView != null) {
            Editable editableText = customTextView.getEditableText();
            AppMethodBeat.o(205864);
            return editableText;
        }
        AppMethodBeat.o(205864);
        return null;
    }

    public final boolean beginBatchEdit() {
        AppMethodBeat.i(205865);
        synchronized (this) {
            try {
                if (this.QIp >= 0) {
                    this.QIo.beginBatchEdit();
                    this.QIp++;
                    return true;
                }
                AppMethodBeat.o(205865);
                return false;
            } finally {
                AppMethodBeat.o(205865);
            }
        }
    }

    public final boolean endBatchEdit() {
        AppMethodBeat.i(205866);
        synchronized (this) {
            try {
                if (this.QIp > 0) {
                    this.QIo.endBatchEdit();
                    this.QIp--;
                    return true;
                }
                AppMethodBeat.o(205866);
                return false;
            } finally {
                AppMethodBeat.o(205866);
            }
        }
    }

    public final void closeConnection() {
        AppMethodBeat.i(205867);
        super.closeConnection();
        synchronized (this) {
            while (this.QIp > 0) {
                try {
                    endBatchEdit();
                } finally {
                    AppMethodBeat.o(205867);
                }
            }
            this.QIp = -1;
        }
    }

    public final boolean clearMetaKeyStates(int i2) {
        AppMethodBeat.i(205868);
        Editable editable = getEditable();
        if (editable == null) {
            AppMethodBeat.o(205868);
            return false;
        }
        KeyListener keyListener = this.QIo.getKeyListener();
        if (keyListener != null) {
            try {
                keyListener.clearMetaKeyState(this.QIo, editable, i2);
            } catch (AbstractMethodError e2) {
            }
        }
        AppMethodBeat.o(205868);
        return true;
    }

    public final boolean commitCompletion(CompletionInfo completionInfo) {
        AppMethodBeat.i(205869);
        Log.v("cmEdit.EditableInputConnection", "commitCompletion ".concat(String.valueOf(completionInfo)));
        this.QIo.beginBatchEdit();
        this.QIo.endBatchEdit();
        AppMethodBeat.o(205869);
        return true;
    }

    public final boolean commitCorrection(CorrectionInfo correctionInfo) {
        AppMethodBeat.i(205870);
        Log.v("cmEdit.EditableInputConnection", "commitCorrection".concat(String.valueOf(correctionInfo)));
        this.QIo.beginBatchEdit();
        CustomTextView customTextView = this.QIo;
        if (customTextView.QHs != null) {
            b bVar = customTextView.QHs;
            if (bVar.QIB == null) {
                bVar.QIB = new b.C2142b();
            } else {
                bVar.QIB.Da(false);
            }
            b.C2142b bVar2 = bVar.QIB;
            bVar2.avh = correctionInfo.getOffset();
            bVar2.Pc = bVar2.avh + correctionInfo.getNewText().length();
            bVar2.QJA = SystemClock.uptimeMillis();
            if (bVar2.avh < 0 || bVar2.Pc < 0) {
                bVar2.stopAnimation();
            }
        }
        this.QIo.endBatchEdit();
        AppMethodBeat.o(205870);
        return true;
    }

    public final boolean performEditorAction(int i2) {
        b.g gVar;
        AppMethodBeat.i(205871);
        Log.v("cmEdit.EditableInputConnection", "performEditorAction ".concat(String.valueOf(i2)));
        CustomTextView customTextView = this.QIo;
        if (customTextView.QHs == null) {
            gVar = null;
        } else {
            gVar = customTextView.QHs.QIC;
        }
        if (gVar != null) {
            if (gVar.QKi == null || !gVar.QKi.a(customTextView, i2)) {
                if (i2 == 5) {
                    View focusSearch = customTextView.focusSearch(2);
                    if (focusSearch != null && !focusSearch.requestFocus(2)) {
                        IllegalStateException illegalStateException = new IllegalStateException("focus search returned a view that wasn't able to take focus!");
                        AppMethodBeat.o(205871);
                        throw illegalStateException;
                    }
                } else if (i2 == 7) {
                    View focusSearch2 = customTextView.focusSearch(1);
                    if (focusSearch2 != null && !focusSearch2.requestFocus(1)) {
                        IllegalStateException illegalStateException2 = new IllegalStateException("focus search returned a view that wasn't able to take focus!");
                        AppMethodBeat.o(205871);
                        throw illegalStateException2;
                    }
                } else if (i2 == 6) {
                    InputMethodManager inputMethodManager = customTextView.getInputMethodManager();
                    if (inputMethodManager != null && inputMethodManager.isActive(customTextView)) {
                        inputMethodManager.hideSoftInputFromWindow(customTextView.getWindowToken(), 0);
                    }
                }
            }
            AppMethodBeat.o(205871);
            return true;
        }
        Object invoke = new com.tencent.mm.ui.widget.cedit.util.a(customTextView, "getViewRootImpl", new Class[0]).invoke(new Object[0]);
        if (invoke != null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            new com.tencent.mm.ui.widget.cedit.util.a(invoke, "dispatchKeyFromIme", KeyEvent.class).invoke(new KeyEvent(uptimeMillis, uptimeMillis, 0, 66, 0, 0, -1, 0, 22));
            new com.tencent.mm.ui.widget.cedit.util.a(invoke, "dispatchKeyFromIme", KeyEvent.class).invoke(new KeyEvent(SystemClock.uptimeMillis(), uptimeMillis, 1, 66, 0, 0, -1, 0, 22));
        }
        AppMethodBeat.o(205871);
        return true;
    }

    public final boolean performContextMenuAction(int i2) {
        AppMethodBeat.i(205872);
        Log.v("cmEdit.EditableInputConnection", "performContextMenuAction ".concat(String.valueOf(i2)));
        this.QIo.beginBatchEdit();
        this.QIo.onTextContextMenuItem(i2);
        this.QIo.endBatchEdit();
        AppMethodBeat.o(205872);
        return true;
    }

    public final ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i2) {
        AppMethodBeat.i(205873);
        if (this.QIo != null) {
            ExtractedText extractedText = new ExtractedText();
            if (this.QIo.extractText(extractedTextRequest, extractedText)) {
                if ((i2 & 1) != 0) {
                    this.QIo.setExtracting(extractedTextRequest);
                }
                AppMethodBeat.o(205873);
                return extractedText;
            }
        }
        AppMethodBeat.o(205873);
        return null;
    }

    public final boolean performPrivateCommand(String str, Bundle bundle) {
        return true;
    }

    public final boolean commitText(CharSequence charSequence, int i2) {
        AppMethodBeat.i(205874);
        if (this.QIo == null) {
            boolean commitText = super.commitText(charSequence, i2);
            AppMethodBeat.o(205874);
            return commitText;
        }
        try {
            boolean commitText2 = super.commitText(charSequence, i2);
            AppMethodBeat.o(205874);
            return commitText2;
        } catch (Throwable th) {
            Log.e("cmEdit.EditableInputConnection", "commitText err:%s", Util.stackTraceToString(th));
            com.tencent.mm.ui.widget.cedit.api.b.aow(6);
            AppMethodBeat.o(205874);
            return false;
        }
    }

    public final boolean requestCursorUpdates(int i2) {
        AppMethodBeat.i(205875);
        Log.v("cmEdit.EditableInputConnection", "requestUpdateCursorAnchorInfo ".concat(String.valueOf(i2)));
        int i3 = i2 & -4;
        if (i3 != 0) {
            Log.d("cmEdit.EditableInputConnection", "Rejecting requestUpdateCursorAnchorInfo due to unknown flags. cursorUpdateMode=" + i2 + " unknownFlags=" + i3);
            AppMethodBeat.o(205875);
            return false;
        }
        if (this.QIq == null) {
            this.QIo.getContext().getSystemService("input_method");
        }
        if (this.QIq == null) {
            AppMethodBeat.o(205875);
            return false;
        }
        Log.i("cmEdit.EditableInputConnection", "requestCursorUpdates");
        if (!((i2 & 1) == 0 || this.QIo == null || this.QIo.isInLayout())) {
            this.QIo.requestLayout();
        }
        AppMethodBeat.o(205875);
        return true;
    }
}
