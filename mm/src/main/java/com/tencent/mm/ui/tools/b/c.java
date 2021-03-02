package com.tencent.mm.ui.tools.b;

import android.text.InputFilter;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class c extends a {
    protected boolean QxK = true;
    public WeakReference<EditText> QxL;
    protected int QxM;
    protected int QxN;
    protected ArrayList<InputFilter> QxO;
    public a QxP;
    protected String mText;
    protected f.a ots;

    public interface a {
        void Tw(String str);

        void Tx(String str);

        void dv(String str);
    }

    public c(WeakReference<EditText> weakReference) {
        this.QxL = weakReference;
        this.ots = f.a.MODE_CHINESE_AS_2;
        this.QxK = false;
    }

    public c(String str) {
        this.mText = str;
        this.ots = f.a.MODE_CHINESE_AS_2;
        this.QxK = false;
    }

    public static c f(EditText editText) {
        AppMethodBeat.i(133841);
        c cVar = new c(new WeakReference(editText));
        AppMethodBeat.o(133841);
        return cVar;
    }

    public final c lv(int i2, int i3) {
        this.QxN = i2;
        this.QxM = i3;
        return this;
    }

    public final c aoq(int i2) {
        this.QxN = 0;
        this.QxM = i2;
        return this;
    }

    public final c a(f.a aVar) {
        this.ots = aVar;
        return this;
    }

    public final c CN(boolean z) {
        this.QxK = z;
        return this;
    }

    public final void a(a aVar) {
        AppMethodBeat.i(133842);
        this.QxP = aVar;
        dSw();
        AppMethodBeat.o(133842);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.tools.b.a
    public int bCj() {
        boolean z;
        AppMethodBeat.i(133843);
        if (Util.isNullOrNil(this.mText)) {
            if (this.QxL == null) {
                AppMethodBeat.o(133843);
                return 1;
            }
            this.mText = this.QxL.get().getText().toString().trim();
        }
        int a2 = f.a(this.mText, this.ots);
        if (a2 < 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Log.w("MicroMsg.InputTextBoundaryCheck", "you are crazy =.=!that is 2 GB character!");
            AppMethodBeat.o(133843);
            return 2;
        } else if (a2 < this.QxN) {
            AppMethodBeat.o(133843);
            return 1;
        } else if (a2 > this.QxM) {
            AppMethodBeat.o(133843);
            return 2;
        } else {
            AppMethodBeat.o(133843);
            return 0;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.tools.b.a
    public void dSw() {
        AppMethodBeat.i(133844);
        if (!this.QxK) {
            if (this.QxL == null) {
                Log.w("MicroMsg.InputTextBoundaryCheck", "edit text view is null");
                AppMethodBeat.o(133844);
                return;
            } else if (Util.isNullOrNil(this.QxO)) {
                this.QxL.get().setFilters(new InputFilter[]{a(this.QxM, this.ots)});
            } else {
                this.QxO.add(a(this.QxM, this.ots));
                this.QxL.get().setFilters((InputFilter[]) this.QxO.toArray(new InputFilter[this.QxO.size()]));
            }
        }
        if (this.QxP != null) {
            switch (bCj()) {
                case 0:
                    this.QxP.Tw(this.mText);
                    AppMethodBeat.o(133844);
                    return;
                case 1:
                    this.QxP.Tx(this.mText);
                    AppMethodBeat.o(133844);
                    return;
                case 2:
                    this.QxP.dv(this.mText);
                    break;
            }
        }
        AppMethodBeat.o(133844);
    }

    /* access modifiers changed from: protected */
    public f a(int i2, f.a aVar) {
        AppMethodBeat.i(133845);
        f fVar = new f(i2, aVar);
        AppMethodBeat.o(133845);
        return fVar;
    }
}
