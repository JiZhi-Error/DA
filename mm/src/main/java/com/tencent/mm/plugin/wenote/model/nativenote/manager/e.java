package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public class e implements Serializable {
    public int Pc;
    public int avh;

    public e(int i2, int i3) {
        AppMethodBeat.i(30459);
        this.avh = i2;
        this.Pc = i3;
        if (this.avh > this.Pc) {
            int i4 = this.Pc;
            this.Pc = this.avh;
            this.avh = i4;
        }
        AppMethodBeat.o(30459);
    }

    public e(EditText editText) {
        this(editText.getSelectionStart(), editText.getSelectionEnd());
        AppMethodBeat.i(30460);
        AppMethodBeat.o(30460);
    }

    public final boolean isEmpty() {
        return this.avh == this.Pc;
    }

    public final e kt(int i2, int i3) {
        AppMethodBeat.i(30461);
        this.avh = Math.max(0, this.avh - i2);
        this.Pc += i3;
        AppMethodBeat.o(30461);
        return this;
    }

    public String toString() {
        AppMethodBeat.i(30462);
        String str = "[" + this.avh + ", " + this.Pc + "]";
        AppMethodBeat.o(30462);
        return str;
    }
}
