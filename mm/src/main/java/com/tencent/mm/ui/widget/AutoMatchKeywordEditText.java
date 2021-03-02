package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class AutoMatchKeywordEditText extends MMEditText {
    private a QBG;
    private int QBH;
    private int QBI;

    public interface a {
        void b(EditText editText, int i2, int i3);
    }

    public AutoMatchKeywordEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(143304);
        init();
        AppMethodBeat.o(143304);
    }

    public AutoMatchKeywordEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(143305);
        init();
        AppMethodBeat.o(143305);
    }

    private void init() {
        AppMethodBeat.i(143306);
        this.QBH = getSelectionStart();
        this.QBI = getSelectionEnd();
        AppMethodBeat.o(143306);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(143307);
        super.onDraw(canvas);
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        if (!(this.QBH == selectionStart && this.QBI == selectionEnd)) {
            this.QBH = selectionStart;
            this.QBI = selectionEnd;
            if (this.QBG != null) {
                this.QBG.b(this, getSelectionStart(), getSelectionEnd());
            }
        }
        AppMethodBeat.o(143307);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c, com.tencent.mm.ui.widget.MMEditText
    public void setSelection(int i2) {
        AppMethodBeat.i(143308);
        Log.d("MicroMsg.AutoMatchKeywordEditText", "setSelection");
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        super.setSelection(i2);
        this.QBH = getSelectionStart();
        this.QBI = getSelectionEnd();
        if (!((selectionStart == getSelectionStart() && selectionEnd == getSelectionEnd()) || this.QBG == null)) {
            this.QBG.b(this, getSelectionStart(), getSelectionEnd());
        }
        AppMethodBeat.o(143308);
    }

    @Override // com.tencent.mm.ui.widget.MMEditText
    public void setSelection(int i2, int i3) {
        AppMethodBeat.i(143309);
        Log.d("MicroMsg.AutoMatchKeywordEditText", "setSelection.");
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        super.setSelection(i2, i3);
        this.QBH = getSelectionStart();
        this.QBI = getSelectionEnd();
        if (!((selectionStart == getSelectionStart() && selectionEnd == getSelectionEnd()) || this.QBG == null)) {
            this.QBG.b(this, getSelectionStart(), getSelectionEnd());
        }
        AppMethodBeat.o(143309);
    }

    public void extendSelection(int i2) {
        AppMethodBeat.i(143310);
        Log.d("MicroMsg.AutoMatchKeywordEditText", "extendSelection");
        super.extendSelection(i2);
        this.QBH = getSelectionStart();
        this.QBI = getSelectionEnd();
        AppMethodBeat.o(143310);
    }

    public boolean moveCursorToVisibleOffset() {
        AppMethodBeat.i(143311);
        Log.d("MicroMsg.AutoMatchKeywordEditText", "moveCursorToVisibleOffset");
        boolean moveCursorToVisibleOffset = super.moveCursorToVisibleOffset();
        AppMethodBeat.o(143311);
        return moveCursorToVisibleOffset;
    }

    public boolean performAccessibilityAction(int i2, Bundle bundle) {
        AppMethodBeat.i(143312);
        Log.d("MicroMsg.AutoMatchKeywordEditText", "performAccessibilityAction");
        boolean performAccessibilityAction = super.performAccessibilityAction(i2, bundle);
        AppMethodBeat.o(143312);
        return performAccessibilityAction;
    }

    public boolean onDragEvent(DragEvent dragEvent) {
        AppMethodBeat.i(143313);
        Log.d("MicroMsg.AutoMatchKeywordEditText", "onDragEvent");
        boolean onDragEvent = super.onDragEvent(dragEvent);
        AppMethodBeat.o(143313);
        return onDragEvent;
    }

    public a getOnSelectionChangeListener() {
        return this.QBG;
    }

    public void setOnSelectionChangeListener(a aVar) {
        this.QBG = aVar;
    }
}
