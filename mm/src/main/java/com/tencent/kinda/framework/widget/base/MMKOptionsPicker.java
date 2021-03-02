package com.tencent.kinda.framework.widget.base;

import com.tencent.kinda.gen.KOptionPicker;
import com.tencent.kinda.gen.Option;
import com.tencent.kinda.gen.VoidBoolOptionCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.c;
import java.util.ArrayList;

public class MMKOptionsPicker implements KOptionPicker {
    private c optionPicker;

    @Override // com.tencent.kinda.gen.KOptionPicker
    public void showImpl(ArrayList<Option> arrayList, VoidBoolOptionCallback voidBoolOptionCallback) {
    }

    @Override // com.tencent.kinda.gen.KOptionPicker
    public void hide() {
        AppMethodBeat.i(19094);
        if (this.optionPicker != null) {
            this.optionPicker.hide();
        }
        AppMethodBeat.o(19094);
    }
}
