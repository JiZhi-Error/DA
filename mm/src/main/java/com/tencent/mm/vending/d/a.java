package com.tencent.mm.vending.d;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class a {
    Bundle mExtras = null;

    public a(Intent intent) {
        AppMethodBeat.i(74872);
        this.mExtras = intent.getExtras();
        AppMethodBeat.o(74872);
    }

    public final int getIntExtra(String str, int i2) {
        AppMethodBeat.i(74873);
        if (this.mExtras == null) {
            AppMethodBeat.o(74873);
            return i2;
        }
        int i3 = this.mExtras.getInt(str, i2);
        AppMethodBeat.o(74873);
        return i3;
    }

    public final String getStringExtra(String str) {
        AppMethodBeat.i(74874);
        if (this.mExtras == null) {
            AppMethodBeat.o(74874);
            return null;
        }
        String string = this.mExtras.getString(str);
        AppMethodBeat.o(74874);
        return string;
    }

    public final ArrayList<String> getStringArrayListExtra(String str) {
        AppMethodBeat.i(74875);
        if (this.mExtras == null) {
            AppMethodBeat.o(74875);
            return null;
        }
        ArrayList<String> stringArrayList = this.mExtras.getStringArrayList(str);
        AppMethodBeat.o(74875);
        return stringArrayList;
    }
}
