package com.tencent.mm.plugin.appbrand.widget.sms;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.numberpad.a;

public class VerifyCodeEditText extends AppCompatEditText implements a {
    public VerifyCodeEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VerifyCodeEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // android.support.v7.widget.AppCompatEditText
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.numberpad.a
    public final InputConnection cbC() {
        AppMethodBeat.i(169541);
        InputConnection onCreateInputConnection = super.onCreateInputConnection(new EditorInfo());
        AppMethodBeat.o(169541);
        return onCreateInputConnection;
    }
}
