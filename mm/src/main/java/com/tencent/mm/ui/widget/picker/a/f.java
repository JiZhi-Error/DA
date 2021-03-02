package com.tencent.mm.ui.widget.picker.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class f extends d {
    private c QUv = this.QUv;
    public boolean QUx;
    private int jJW;
    private int jJX;
    private Context mContext;

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.ui.widget.picker.a.e, com.tencent.mm.ui.widget.picker.a.d
    public final /* synthetic */ Integer getItem(int i2) {
        AppMethodBeat.i(198511);
        Integer uH = uH(i2);
        AppMethodBeat.o(198511);
        return uH;
    }

    public f(int i2, int i3, Context context) {
        super(i2, i3);
        AppMethodBeat.i(198508);
        this.mContext = context;
        if (this.QUv == null) {
            this.QUv = new a();
        }
        this.jJW = i2;
        this.jJX = i3;
        AppMethodBeat.o(198508);
    }

    @Override // com.tencent.mm.ui.widget.picker.a.d
    public final int getMinValue() {
        return this.jJW;
    }

    @Override // com.tencent.mm.ui.widget.picker.a.d
    public final int getMaxValue() {
        return this.jJX;
    }

    @Override // com.tencent.mm.ui.widget.picker.a.d
    public final Integer uH(int i2) {
        AppMethodBeat.i(198509);
        if (i2 < 0 || i2 >= getItemsCount()) {
            AppMethodBeat.o(198509);
            return null;
        } else if (this.QUx) {
            Integer valueOf = Integer.valueOf((this.jJW + i2) - 1);
            AppMethodBeat.o(198509);
            return valueOf;
        } else {
            Integer valueOf2 = Integer.valueOf(this.jJW + i2);
            AppMethodBeat.o(198509);
            return valueOf2;
        }
    }

    @Override // com.tencent.mm.ui.widget.picker.a.e, com.tencent.mm.ui.widget.picker.a.d
    public final String uG(int i2) {
        AppMethodBeat.i(198510);
        if (i2 != 0 || !this.QUx) {
            String uG = super.uG(i2);
            AppMethodBeat.o(198510);
            return uG;
        }
        String string = this.mContext.getString(R.string.fmf);
        AppMethodBeat.o(198510);
        return string;
    }

    @Override // com.tencent.mm.ui.widget.picker.a.e, com.tencent.mm.ui.widget.picker.a.d
    public final int getItemsCount() {
        if (this.QUx) {
            return (this.jJX - this.jJW) + 1 + 1;
        }
        return (this.jJX - this.jJW) + 1;
    }

    class a implements c {
        a() {
        }

        @Override // com.tencent.mm.ui.widget.picker.a.c
        public final String Sf(String str) {
            return str;
        }
    }
}
