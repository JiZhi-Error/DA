package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.view.u;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.page.aj;

public final class ah {
    final g ovi;
    boolean ovj = false;
    boolean ovk = false;
    boolean ovl = false;
    private final a<ViewGroup, g> ovm = new a<ViewGroup, g>() {
        /* class com.tencent.mm.plugin.appbrand.widget.input.ah.AnonymousClass1 */

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.plugin.appbrand.widget.input.ah.a
        public final boolean dd(View view) {
            AppMethodBeat.i(136580);
            if (view.getId() == R.id.pm) {
                AppMethodBeat.o(136580);
                return true;
            }
            AppMethodBeat.o(136580);
            return false;
        }

        /* Return type fixed from 'android.view.View' to match base method */
        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.plugin.appbrand.widget.input.ah.a
        public final /* synthetic */ g de(View view) {
            AppMethodBeat.i(136581);
            g gVar = (g) view.findViewById(R.id.pn);
            AppMethodBeat.o(136581);
            return gVar;
        }
    };
    final a<ViewGroup, aj> ovn = new a<ViewGroup, aj>() {
        /* class com.tencent.mm.plugin.appbrand.widget.input.ah.AnonymousClass2 */

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.plugin.appbrand.widget.input.ah.a
        public final boolean dd(View view) {
            return view instanceof aj;
        }

        /* Return type fixed from 'android.view.View' to match base method */
        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.plugin.appbrand.widget.input.ah.a
        public final /* bridge */ /* synthetic */ aj de(View view) {
            return (aj) view;
        }
    };

    public ah(g gVar) {
        AppMethodBeat.i(136582);
        this.ovi = gVar;
        AppMethodBeat.o(136582);
    }

    static abstract class a<Source extends View, Target extends View> {
        private Target Sg;

        /* access modifiers changed from: package-private */
        public abstract boolean dd(View view);

        /* access modifiers changed from: package-private */
        public abstract Target de(View view);

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final Target df(Source source) {
            if (this.Sg != null && u.aD(this.Sg)) {
                return this.Sg;
            }
            if (source == null || !u.aD(source)) {
                return null;
            }
            for (ViewParent parent = source.getParent(); parent instanceof View; parent = parent.getParent()) {
                if (dd((View) parent)) {
                    Target de = de((View) parent);
                    this.Sg = de;
                    return de;
                }
            }
            return null;
        }
    }
}
