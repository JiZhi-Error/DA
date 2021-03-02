package com.tencent.mm.plugin.sight.encode.ui;

import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class d implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener, l {
    public TextView DpM;
    public View DpN;
    private com.tencent.mm.plugin.fts.a.a.a DpO;
    InputMethodManager DpP;
    public b DpQ = b.normal;
    public a DpR;
    private MMHandler handler = new MMHandler(Looper.getMainLooper());
    public EditText xrL;

    public interface a {
        void eWm();

        void eWn();

        void gK(List<String> list);
    }

    public d() {
        AppMethodBeat.i(28746);
        AppMethodBeat.o(28746);
    }

    public enum b {
        search,
        normal;

        public static b valueOf(String str) {
            AppMethodBeat.i(28744);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(28744);
            return bVar;
        }

        static {
            AppMethodBeat.i(28745);
            AppMethodBeat.o(28745);
        }
    }

    public final boolean eWi() {
        return this.DpQ == b.search;
    }

    public final void onFocusChange(View view, boolean z) {
        AppMethodBeat.i(28747);
        if (!z) {
            this.xrL.clearFocus();
            Util.hideVKB(this.xrL);
        }
        AppMethodBeat.o(28747);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(28748);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sight/encode/ui/MainSightSelectContactSearchHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (view.getId() == R.id.hde) {
            if (!eWi()) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightSelectContactSearchHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(28748);
                return;
            }
            eWj();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightSelectContactSearchHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28748);
    }

    public final void eWj() {
        AppMethodBeat.i(28749);
        if (eWi()) {
            eWl();
            AppMethodBeat.o(28749);
            return;
        }
        eWk();
        AppMethodBeat.o(28749);
    }

    private void eWk() {
        AppMethodBeat.i(28750);
        if (eWi()) {
            AppMethodBeat.o(28750);
            return;
        }
        this.DpQ = b.search;
        this.DpN.setVisibility(0);
        if (this.DpR != null) {
            this.DpR.eWm();
        }
        this.xrL.requestFocus();
        this.DpP.showSoftInput(this.xrL, 0);
        AppMethodBeat.o(28750);
    }

    public final void eWl() {
        AppMethodBeat.i(28751);
        if (!eWi()) {
            AppMethodBeat.o(28751);
            return;
        }
        this.xrL.setText("");
        this.xrL.clearFocus();
        Util.hideVKB(this.xrL);
        this.DpQ = b.normal;
        this.DpN.setVisibility(8);
        if (this.DpR != null) {
            this.DpR.eWn();
        }
        AppMethodBeat.o(28751);
    }

    @Override // com.tencent.mm.plugin.fts.a.l
    public final void b(k kVar) {
        AppMethodBeat.i(28752);
        if (kVar.resultCode == 0) {
            if (kVar.wXb == null || this.DpR == null) {
                AppMethodBeat.o(28752);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (m mVar : kVar.wXb) {
                arrayList.add(mVar.wVX);
            }
            this.DpR.gK(arrayList);
        }
        AppMethodBeat.o(28752);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public final void afterTextChanged(Editable editable) {
        AppMethodBeat.i(28753);
        if (Util.isNullOrNil(editable.toString())) {
            AppMethodBeat.o(28753);
            return;
        }
        String obj = editable.toString();
        Log.i("MicroMsg.MainSightSelectContactSearchHelper", "doSearch: query=%s", obj);
        if (this.DpO != null) {
            ((n) g.ah(n.class)).cancelSearchTask(this.DpO);
            this.DpO = null;
        }
        this.DpO = ((n) g.ah(n.class)).search(2, j.a(obj, new int[]{131072, 131075}, null, 3, new HashSet(), com.tencent.mm.plugin.fts.a.c.b.wXy, this, this.handler));
        AppMethodBeat.o(28753);
    }
}
