package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.Spanned;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.f;
import java.lang.ref.WeakReference;

public final class p extends c {
    private p(WeakReference<EditText> weakReference) {
        super(weakReference);
    }

    public static p a(EditText editText) {
        AppMethodBeat.i(136430);
        p pVar = new p(new WeakReference(editText));
        AppMethodBeat.o(136430);
        return pVar;
    }

    @Override // com.tencent.mm.ui.tools.b.c
    public final f a(int i2, f.a aVar) {
        AppMethodBeat.i(136431);
        b bVar = new b(i2, aVar);
        AppMethodBeat.o(136431);
        return bVar;
    }

    final class b extends f {
        private final int otr;
        private final f.a ots;

        b(int i2, f.a aVar) {
            super(i2, aVar);
            this.otr = i2;
            this.ots = aVar;
        }

        @Override // com.tencent.mm.ui.tools.f
        public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            boolean z = false;
            AppMethodBeat.i(136429);
            if (a(spanned.subSequence(0, i4).toString() + spanned.subSequence(i5, spanned.length()).toString(), this.ots) + a(charSequence.subSequence(i2, i3).toString(), this.ots) > this.otr) {
                z = true;
            }
            if (z) {
                charSequence = charSequence.subSequence(i2, Math.max(i2, Math.min(this.otr - (spanned.length() - (i5 - i4)), i3)));
            }
            if (z && Util.isNullOrNil(charSequence)) {
                EditText editText = p.this.QxL == null ? null : (EditText) p.this.QxL.get();
                final c.a aVar = p.this.QxP;
                if (!(editText == null || aVar == null)) {
                    final String obj = editText.getText() != null ? editText.getText().toString() : "";
                    editText.post(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.widget.input.p.b.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(136428);
                            aVar.dv(obj);
                            AppMethodBeat.o(136428);
                        }
                    });
                }
            }
            AppMethodBeat.o(136429);
            return charSequence;
        }
    }

    public static abstract class a implements c.a {
        @Override // com.tencent.mm.ui.tools.b.c.a
        public final void Tw(String str) {
        }

        @Override // com.tencent.mm.ui.tools.b.c.a
        public final void Tx(String str) {
        }

        @Override // com.tencent.mm.ui.tools.b.c.a
        public void dv(String str) {
        }
    }
}
