package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.u;
import android.text.InputFilter;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.numberpad.a;

public final class s extends r implements a {
    private InputConnection otF;

    @Override // com.tencent.mm.plugin.appbrand.widget.input.r
    public final /* bridge */ /* synthetic */ boolean canScrollVertically(int i2) {
        AppMethodBeat.i(136469);
        boolean canScrollVertically = super.canScrollVertically(i2);
        AppMethodBeat.o(136469);
        return canScrollVertically;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab, com.tencent.mm.plugin.appbrand.widget.input.y, com.tencent.mm.plugin.appbrand.widget.input.r
    public final /* bridge */ /* synthetic */ boolean cbB() {
        AppMethodBeat.i(136470);
        boolean cbB = super.cbB();
        AppMethodBeat.o(136470);
        return cbB;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.r
    public final /* bridge */ /* synthetic */ void setGravity(int i2) {
        AppMethodBeat.i(136471);
        super.setGravity(i2);
        AppMethodBeat.o(136471);
    }

    public s(Context context) {
        super(context);
        AppMethodBeat.i(136461);
        super.setKeyListener(new NumberKeyListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.s.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public final char[] getAcceptedChars() {
                return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '.', 'X', 'x'};
            }

            public final int getInputType() {
                return (s.this.ouv ? 16 : 0) | 2;
            }
        });
        AppMethodBeat.o(136461);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.y
    public final void clearFocus() {
        AppMethodBeat.i(136462);
        cbW();
        AppMethodBeat.o(136462);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.y
    public final boolean requestFocus(int i2, Rect rect) {
        AppMethodBeat.i(136463);
        boolean a2 = a(i2, rect);
        AppMethodBeat.o(136463);
        return a2;
    }

    public final void setFilters(InputFilter[] inputFilterArr) {
        int i2 = 0;
        AppMethodBeat.i(136464);
        if (inputFilterArr == null) {
            inputFilterArr = new InputFilter[0];
        }
        InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length + 1)];
        while (i2 < inputFilterArr.length) {
            inputFilterArr2[i2] = inputFilterArr[i2];
            i2++;
        }
        inputFilterArr2[i2] = new InputFilter.AllCaps();
        super.setFilters(inputFilterArr2);
        AppMethodBeat.o(136464);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.y
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.numberpad.a
    public final InputConnection cbC() {
        AppMethodBeat.i(136465);
        InputConnection onCreateInputConnection = super.onCreateInputConnection(new EditorInfo());
        this.otF = onCreateInputConnection;
        AppMethodBeat.o(136465);
        return onCreateInputConnection;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.y
    public final void setPasswordMode(boolean z) {
        int i2;
        AppMethodBeat.i(136466);
        cbU();
        int inputType = getInputType() | 2;
        if (z) {
            i2 = inputType | 16;
        } else {
            i2 = inputType & -17;
        }
        setInputType(i2);
        super.setPasswordMode(z);
        cbV();
        AppMethodBeat.o(136466);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab
    public final v getInputPanel() {
        AppMethodBeat.i(136467);
        v da = v.da(this);
        AppMethodBeat.o(136467);
        return da;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.y
    public final void cbz() {
        AppMethodBeat.i(136468);
        if (!u.aD(this)) {
            AppMethodBeat.o(136468);
            return;
        }
        v inputPanel = getInputPanel();
        if (inputPanel != null) {
            inputPanel.setInputEditText(this);
        }
        AppMethodBeat.o(136468);
    }
}
