package com.tencent.mm.ui.widget.cedit.edit;

import android.view.ActionMode;
import android.view.textclassifier.TextClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.cedit.edit.b;
import java.util.Objects;

public final class d {
    private final b QHs;
    private final CustomTextView QIo = this.QHs.QIo;
    private TextClassification QLx;

    d(b bVar) {
        AppMethodBeat.i(206034);
        this.QHs = (b) Objects.requireNonNull(bVar);
        AppMethodBeat.o(206034);
    }

    /* access modifiers changed from: package-private */
    public final void haU() {
        b.n hax;
        AppMethodBeat.i(206035);
        c(this.QIo);
        this.QLx = null;
        if (this.QHs.har() && (hax = this.QHs.hax()) != null && (this.QIo.isTextSelectable() || this.QIo.gZB())) {
            hax.show();
        }
        this.QHs.QIS = false;
        AppMethodBeat.o(206035);
    }

    /* access modifiers changed from: package-private */
    public final void haV() {
        AppMethodBeat.i(206036);
        this.QLx = null;
        ActionMode actionMode = this.QHs.QIu;
        if (actionMode != null) {
            actionMode.invalidate();
        }
        AppMethodBeat.o(206036);
    }

    private static CharSequence c(CustomTextView customTextView) {
        AppMethodBeat.i(206037);
        CharSequence text = customTextView.getText();
        if (text != null) {
            AppMethodBeat.o(206037);
            return text;
        }
        AppMethodBeat.o(206037);
        return "";
    }
}
