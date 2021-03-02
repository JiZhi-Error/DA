package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.database.DataSetObserver;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Filter;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.ab;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.h;
import com.tencent.mm.plugin.appbrand.widget.input.d.a;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;

public final class b {
    final ab ovY;
    public final e ovZ;
    private final Filter.FilterListener owa;
    public final c owb;
    private final a owc;
    private f owd = f.VIEW;
    public a owe;
    private int owf;
    private int owg;

    public b(ab abVar) {
        AppMethodBeat.i(136630);
        this.ovY = abVar;
        this.ovZ = new e(abVar.getContext());
        this.owb = new c(abVar, this.ovZ);
        this.ovY.a(new ab.a() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.autofill.b.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.widget.input.ab.a
            public final void iE() {
                AppMethodBeat.i(136621);
                b.this.ccc();
                AppMethodBeat.o(136621);
            }
        });
        this.ovY.a(new ab.c() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.autofill.b.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.widget.input.ab.c
            public final void cbA() {
                AppMethodBeat.i(136622);
                b.this.ccc();
                AppMethodBeat.o(136622);
            }
        });
        this.ovY.a(new View.OnFocusChangeListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.autofill.b.AnonymousClass3 */

            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(136623);
                if (z) {
                    b.this.ccd();
                    AppMethodBeat.o(136623);
                    return;
                }
                b bVar = b.this;
                if (bVar.ovZ.arA.isShowing()) {
                    bVar.ovZ.dismiss();
                    ((g) bVar.ovZ.ows.getAdapter()).ccb();
                }
                AppMethodBeat.o(136623);
            }
        });
        this.ovY.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.autofill.b.AnonymousClass4 */
            private boolean owi = false;

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(136624);
                this.owi = b.this.ovZ.arA.isShowing();
                AppMethodBeat.o(136624);
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(136625);
                if (!this.owi || b.this.ovZ.arA.isShowing()) {
                    if (!b.this.ovZ.arA.isShowing()) {
                        b.this.ccd();
                    }
                    b.this.J(editable);
                    AppMethodBeat.o(136625);
                    return;
                }
                AppMethodBeat.o(136625);
            }
        });
        this.owa = new Filter.FilterListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.autofill.b.AnonymousClass5 */

            public final void onFilterComplete(int i2) {
                AppMethodBeat.i(136626);
                if (i2 <= 0) {
                    b.this.ovZ.dismiss();
                    AppMethodBeat.o(136626);
                    return;
                }
                if (b.this.ovZ.arA.isShowing()) {
                    b.this.ovZ.show();
                }
                AppMethodBeat.o(136626);
            }
        };
        this.owc = new a() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.autofill.b.AnonymousClass6 */

            @Override // com.tencent.mm.plugin.appbrand.widget.input.autofill.b.a, com.tencent.mm.plugin.appbrand.widget.input.autofill.h
            public final void a(String str, h.a aVar) {
                AppMethodBeat.i(136627);
                if (aVar == h.a.DELETE) {
                    b.this.J(b.this.ovY.getText());
                }
                super.a(str, aVar);
                AppMethodBeat.o(136627);
            }
        };
        AppMethodBeat.o(136630);
    }

    /* access modifiers changed from: package-private */
    public final void J(CharSequence charSequence) {
        AppMethodBeat.i(136631);
        if (this.owe == null) {
            AppMethodBeat.o(136631);
            return;
        }
        this.owe.getFilter().filter(charSequence, this.owa);
        AppMethodBeat.o(136631);
    }

    /* access modifiers changed from: package-private */
    public final void N(ArrayList<a.b> arrayList) {
        AppMethodBeat.i(136632);
        this.owe = new a(this.ovY.getContext(), arrayList);
        this.owe.ovR = this.owc;
        e eVar = this.ovZ;
        a aVar = this.owe;
        if (eVar.mObserver == null) {
            eVar.mObserver = new AutoFillListPopupWindowBase.c(eVar, (byte) 0);
        } else if (eVar.GO != null) {
            eVar.GO.unregisterDataSetObserver(eVar.mObserver);
        }
        eVar.GO = aVar;
        if (eVar.GO != null) {
            aVar.registerDataSetObserver(eVar.mObserver);
        }
        if (eVar.ows != null) {
            eVar.ows.setAdapter(eVar.GO);
        }
        AppMethodBeat.o(136632);
    }

    /* access modifiers changed from: package-private */
    public final void a(h hVar) {
        this.owc.owk = hVar;
    }

    /* access modifiers changed from: package-private */
    public final void ccc() {
        AppMethodBeat.i(136633);
        switch (this.owd) {
            case SCREEN:
                this.ovZ.akZ = KeyBoardUtil.getScreenWH(this.ovY.getContext())[0];
                break;
            case VIEW:
                this.ovZ.akZ = this.ovY.getView().getMeasuredWidth();
                break;
        }
        if (this.owf != 0) {
            this.ovZ.are = this.owf;
            this.ovZ.akZ -= this.owf;
        }
        if (this.owg != 0) {
            this.ovZ.akZ -= this.owg;
        }
        AppMethodBeat.o(136633);
    }

    public final void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        AppMethodBeat.i(136634);
        this.ovZ.setOnDismissListener(onDismissListener);
        AppMethodBeat.o(136634);
    }

    /* access modifiers changed from: package-private */
    public final void a(f fVar) {
        AppMethodBeat.i(136635);
        if (fVar != null) {
            this.owd = fVar;
        }
        ccc();
        AppMethodBeat.o(136635);
    }

    /* access modifiers changed from: package-private */
    public final void ccd() {
        AppMethodBeat.i(136636);
        if (this.owe == null) {
            AppMethodBeat.o(136636);
            return;
        }
        CharSequence text = this.ovY.getText();
        if (!Util.isNullOrNil(text)) {
            J(text);
        }
        this.ovZ.arp = this.ovY.getView();
        this.ovZ.show();
        ((g) this.ovZ.ows.getAdapter()).a(this);
        c cVar = this.owb;
        cVar.Ao(2);
        cVar.own = Integer.MIN_VALUE;
        if (!Util.isNullOrNil(text)) {
            cVar.owo = true;
        }
        AutoFillListPopupWindowBase.a aVar = cVar.ovZ.ows;
        if (aVar != null) {
            aVar.getAdapter().registerDataSetObserver(new DataSetObserver() {
                /* class com.tencent.mm.plugin.appbrand.widget.input.autofill.c.AnonymousClass2 */

                public final void onChanged() {
                    AppMethodBeat.i(136639);
                    if (!c.this.ovZ.arA.isShowing()) {
                        AppMethodBeat.o(136639);
                        return;
                    }
                    c.this.Ao(1);
                    AppMethodBeat.o(136639);
                }
            });
        }
        AppMethodBeat.o(136636);
    }

    /* access modifiers changed from: package-private */
    public static class a implements h {
        h owk;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.input.autofill.h
        public void a(String str, h.a aVar) {
            AppMethodBeat.i(136629);
            if (this.owk != null) {
                this.owk.a(str, aVar);
            }
            AppMethodBeat.o(136629);
        }
    }
}
