package com.tencent.mm.plugin.luckymoney.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public final class c {
    private boolean zeA = false;
    private boolean zeB = false;
    private TextView zeC;
    private List<d> zez = new LinkedList();

    public c() {
        AppMethodBeat.i(65609);
        AppMethodBeat.o(65609);
    }

    public final void a(d dVar) {
        AppMethodBeat.i(65610);
        if (dVar == null) {
            AppMethodBeat.o(65610);
            return;
        }
        if (!this.zez.contains(dVar)) {
            this.zez.add(dVar);
        }
        AppMethodBeat.o(65610);
    }

    public final void t(TextView textView) {
        if (textView != null) {
            this.zeC = textView;
        }
    }

    public final void b(d dVar) {
        AppMethodBeat.i(213410);
        if (dVar == null) {
            AppMethodBeat.o(213410);
            return;
        }
        for (int i2 = 0; i2 < this.zez.size(); i2++) {
            if (this.zez.get(i2).getInputViewId() == dVar.getInputViewId()) {
                this.zez.remove(i2);
            }
        }
        AppMethodBeat.o(213410);
    }

    public final void clear() {
        AppMethodBeat.i(65611);
        this.zez.clear();
        this.zeC = null;
        AppMethodBeat.o(65611);
    }

    public final boolean egj() {
        AppMethodBeat.i(65612);
        this.zeB = false;
        this.zeA = false;
        for (int i2 = 0; i2 < this.zez.size(); i2++) {
            d dVar = this.zez.get(i2);
            int eeH = dVar.eeH();
            if (eeH != 0) {
                dVar.onError();
                aDD(dVar.PA(eeH));
                this.zeB = true;
            } else {
                dVar.restore();
            }
        }
        if (!this.zeB && this.zeC != null) {
            this.zeC.setVisibility(8);
            this.zeA = false;
        }
        boolean z = this.zeB;
        AppMethodBeat.o(65612);
        return z;
    }

    public final boolean egk() {
        AppMethodBeat.i(65613);
        for (int i2 = 0; i2 < this.zez.size(); i2++) {
            if (this.zez.get(i2).eeH() != 0) {
                AppMethodBeat.o(65613);
                return true;
            }
        }
        AppMethodBeat.o(65613);
        return false;
    }

    private void aDD(String str) {
        AppMethodBeat.i(65614);
        if (this.zeC != null && !Util.isNullOrNil(str)) {
            if (!this.zeA) {
                this.zeC.setText(str);
            }
            this.zeC.setVisibility(0);
            this.zeA = true;
        }
        AppMethodBeat.o(65614);
    }

    public final void aeu(String str) {
        AppMethodBeat.i(65615);
        if (this.zeC == null || Util.isNullOrNil(str)) {
            if (this.zeC != null) {
                this.zeC.setVisibility(8);
                this.zeA = false;
            }
            AppMethodBeat.o(65615);
            return;
        }
        this.zeC.setText(str);
        this.zeC.setVisibility(0);
        this.zeA = true;
        AppMethodBeat.o(65615);
    }
}
