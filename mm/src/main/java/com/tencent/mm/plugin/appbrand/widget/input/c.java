package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Rect;
import android.support.v4.e.b;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.widget.input.ab;
import com.tencent.mm.plugin.appbrand.widget.input.af;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.plugin.appbrand.widget.input.d.h;
import com.tencent.mm.plugin.appbrand.widget.input.p;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.g;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public abstract class c<Input extends EditText & ab> extends g implements aa {
    public af JtN;
    public ae JtO;
    final String JtP;
    public final View.OnFocusChangeListener JtR = new View.OnFocusChangeListener() {
        /* class com.tencent.mm.plugin.appbrand.widget.input.c.AnonymousClass1 */

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.i(136308);
            c.this.jg(z);
            if (z) {
                o.a(c.this.orG.get(), (ab) c.this.caS());
                ((ab) c.this.caS()).setInputId(c.this.orE);
                o.b(c.this.orG.get(), c.this);
            }
            AppMethodBeat.o(136308);
        }
    };
    private final c.a JtS = new p.a() {
        /* class com.tencent.mm.plugin.appbrand.widget.input.c.AnonymousClass2 */

        @Override // com.tencent.mm.ui.tools.b.c.a, com.tencent.mm.plugin.appbrand.widget.input.p.a
        public final void dv(String str) {
            AppMethodBeat.i(168762);
            if (c.this.caS() != null) {
                c.this.b((c) c.this.caS().getEditableText());
            }
            AppMethodBeat.o(168762);
        }
    };
    public final int orE;
    public final WeakReference<ac> orG;

    public abstract boolean afY(String str);

    /* access modifiers changed from: protected */
    public abstract h b(h hVar);

    public abstract Input caS();

    public abstract Rect caT();

    /* access modifiers changed from: protected */
    public abstract boolean jg(boolean z);

    c(String str, ac acVar, int i2) {
        this.JtP = str;
        this.orG = new WeakReference<>(acVar);
        this.orE = i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.aa
    public final int getInputId() {
        return this.orE;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.aa
    public final boolean caU() {
        return remove();
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.aa
    public final Input caV() {
        return caS();
    }

    public final boolean remove() {
        Input caS = caS();
        if (caS == null) {
            return false;
        }
        caS.b(this.JtR);
        caS.removeTextChangedListener(this);
        caS.destroy();
        ac acVar = this.orG.get();
        if (acVar == null) {
            return false;
        }
        g gVar = (g) acVar.bRe();
        if (gVar == null) {
            return false;
        }
        gVar.cV(caS);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.aa
    public final boolean A(ac acVar) {
        return acVar != null && acVar == this.orG.get();
    }

    /* access modifiers changed from: package-private */
    public final void a(Editable editable) {
        if (this.JtN != null) {
            this.JtN.a(editable == null ? "" : editable.toString(), Selection.getSelectionEnd(editable), af.a.COMPLETE);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.aa
    public final void zZ(int i2) {
        if (this.JtO != null) {
            this.JtO.Ab(i2);
        }
    }

    @Override // com.tencent.mm.ui.widget.g
    public final void afterTextChanged(Editable editable) {
        b(editable);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b(Editable editable) {
        if (this.JtN != null) {
            this.JtN.a(editable == null ? "" : editable.toString(), Selection.getSelectionEnd(editable), af.a.CHANGED);
        }
    }

    public final boolean a(h hVar) {
        h b2 = b(hVar);
        if (b2 == null) {
            return false;
        }
        if (b2.oxT == null) {
            b2.oxT = 140;
        } else if (b2.oxT.intValue() <= 0) {
            b2.oxT = Integer.MAX_VALUE;
        }
        if (caS() == null) {
            return false;
        }
        p.a(caS()).aoq(b2.oxT.intValue()).CN(false).a(f.a.MODE_CHINESE_AS_1).a(this.JtS);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.aa
    public final void a(String str, Integer num) {
        afY(str);
        Integer valueOf = Integer.valueOf(num == null ? -1 : num.intValue());
        eK(valueOf.intValue(), valueOf.intValue());
    }

    public final Editable cbn() {
        if (caS() == null) {
            return null;
        }
        return caS().getEditableText();
    }

    /* access modifiers changed from: protected */
    public final void eK(int i2, int i3) {
        b.a(caS(), i2, i3);
    }

    public enum a {
        ;
        
        private static final b<AbstractC0822a> JtU = new b<>();

        /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.c$a$a  reason: collision with other inner class name */
        public interface AbstractC0822a {
            c caX();
        }

        static {
            AppMethodBeat.i(177116);
            AppMethodBeat.o(177116);
        }

        public static a valueOf(String str) {
            AppMethodBeat.i(136311);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(136311);
            return aVar;
        }

        public static c a(String str, ac acVar, e eVar) {
            AppMethodBeat.i(136312);
            Iterator<AbstractC0822a> it = JtU.iterator();
            while (it.hasNext()) {
                c caX = it.next().caX();
                if (caX != null) {
                    AppMethodBeat.o(136312);
                    return caX;
                }
            }
            if ("digit".equalsIgnoreCase(str) || "idcard".equalsIgnoreCase(str) || "number".equalsIgnoreCase(str)) {
                d dVar = new d(str, acVar, eVar);
                AppMethodBeat.o(136312);
                return dVar;
            }
            AppMethodBeat.o(136312);
            return null;
        }
    }
}
