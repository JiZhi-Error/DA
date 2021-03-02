package com.tencent.mm.plugin.editor.model.nativenote.manager;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public class g implements Serializable {
    public int Pc;
    public int avh;

    public g(int i2, int i3) {
        AppMethodBeat.i(181779);
        this.avh = i2;
        this.Pc = i3;
        if (this.avh > this.Pc) {
            int i4 = this.Pc;
            this.Pc = this.avh;
            this.avh = i4;
        }
        AppMethodBeat.o(181779);
    }

    public g(EditText editText) {
        this(editText.getSelectionStart(), editText.getSelectionEnd());
        AppMethodBeat.i(181780);
        AppMethodBeat.o(181780);
    }

    public final boolean isEmpty() {
        return this.avh == this.Pc;
    }

    public final g fy(int i2, int i3) {
        AppMethodBeat.i(181781);
        this.avh = Math.max(0, this.avh - i2);
        this.Pc += i3;
        AppMethodBeat.o(181781);
        return this;
    }

    public String toString() {
        AppMethodBeat.i(181782);
        String str = "[" + this.avh + ", " + this.Pc + "]";
        AppMethodBeat.o(181782);
        return str;
    }
}
