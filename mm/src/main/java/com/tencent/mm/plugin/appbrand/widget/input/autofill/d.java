package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.widget.input.ab;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.h;
import com.tencent.mm.plugin.appbrand.widget.input.d.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class d {

    public static final class a extends s {
        private static final int CTRL_INDEX = 207;
        public static final String NAME = "onKeyboardDropdownOperate";
    }

    public static <Input extends EditText & ab> void a(ac acVar, Input input, a.C0823a aVar) {
        AppMethodBeat.i(136644);
        if (!input.cby()) {
            AppMethodBeat.o(136644);
            return;
        }
        final WeakReference weakReference = new WeakReference(acVar);
        final WeakReference weakReference2 = new WeakReference(input);
        AnonymousClass1 r2 = new h() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.autofill.d.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.widget.input.autofill.h
            public final void a(String str, h.a aVar) {
                AppMethodBeat.i(136643);
                EditText editText = (EditText) weakReference2.get();
                ac acVar = (ac) weakReference.get();
                if (editText == null || acVar == null) {
                    AppMethodBeat.o(136643);
                    return;
                }
                int inputId = ((ab) editText).getInputId();
                a aVar2 = new a();
                HashMap hashMap = new HashMap();
                hashMap.put("id", str);
                hashMap.put("type", aVar.name().toLowerCase());
                hashMap.put("inputId", Integer.valueOf(inputId));
                aVar2.g(acVar).L(hashMap).bEo();
                AppMethodBeat.o(136643);
            }
        };
        b autoFillController = input.getAutoFillController();
        autoFillController.N(aVar.oxt);
        autoFillController.a(r2);
        autoFillController.a("screen".equalsIgnoreCase(aVar.oxs) ? f.SCREEN : f.VIEW);
        AppMethodBeat.o(136644);
    }
}
