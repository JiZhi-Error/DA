package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i;
import java.util.LinkedList;

public abstract class j extends f {
    private final LinkedList<a> nvA = new LinkedList<a>() {
        /* class com.tencent.mm.plugin.appbrand.page.capsulebar.j.AnonymousClass1 */

        @Override // java.util.List, java.util.LinkedList
        public final boolean remove(Object obj) {
            AppMethodBeat.i(135289);
            boolean remove = super.remove(obj);
            j.a(j.this);
            AppMethodBeat.o(135289);
            return remove;
        }
    };

    static /* synthetic */ void a(j jVar) {
        CharSequence charSequence;
        int i2;
        Drawable drawable = null;
        a peekFirst = jVar.nvA.peekFirst();
        if (peekFirst == null) {
            charSequence = null;
        } else {
            charSequence = peekFirst.Me;
        }
        jVar.E(charSequence);
        if (peekFirst != null) {
            drawable = peekFirst.mDrawable;
        }
        jVar.y(drawable);
        if (peekFirst == null) {
            i2 = Integer.MIN_VALUE;
        } else {
            i2 = peekFirst.mStatus;
        }
        jVar.yS(i2);
    }

    public final i.a bSB() {
        a aVar = new a();
        this.nvA.addFirst(aVar);
        return aVar;
    }

    /* access modifiers changed from: protected */
    public final class a implements i.a {
        CharSequence Me = null;
        Drawable mDrawable = null;
        int mStatus = Integer.MIN_VALUE;

        protected a() {
        }

        @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.i.a
        public final void setLogo(final Drawable drawable) {
            AppMethodBeat.i(135296);
            j.this.P(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.page.capsulebar.j.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(135290);
                    a.this.mDrawable = drawable;
                    if (a.a(a.this)) {
                        j.this.y(a.this.mDrawable);
                    }
                    AppMethodBeat.o(135290);
                }
            });
            AppMethodBeat.o(135296);
        }

        @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.i.a
        public final void setLogo(final int i2) {
            AppMethodBeat.i(135297);
            j.this.P(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.page.capsulebar.j.a.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(135291);
                    try {
                        a.this.setLogo(b.l(j.this.getContext(), i2));
                        AppMethodBeat.o(135291);
                    } catch (Resources.NotFoundException e2) {
                        a.this.setLogo((Drawable) null);
                        AppMethodBeat.o(135291);
                    }
                }
            });
            AppMethodBeat.o(135297);
        }

        @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.i.a
        public final void setDescription(final CharSequence charSequence) {
            AppMethodBeat.i(135298);
            j.this.P(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.page.capsulebar.j.a.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(135292);
                    a.this.Me = charSequence;
                    if (a.a(a.this)) {
                        j.this.E(charSequence);
                    }
                    AppMethodBeat.o(135292);
                }
            });
            AppMethodBeat.o(135298);
        }

        @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.i.a
        public final void yT(final int i2) {
            AppMethodBeat.i(135299);
            j.this.P(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.page.capsulebar.j.a.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(135293);
                    try {
                        a.this.setDescription(j.this.getContext().getResources().getString(i2));
                        AppMethodBeat.o(135293);
                    } catch (Resources.NotFoundException e2) {
                        a.this.setDescription(null);
                        AppMethodBeat.o(135293);
                    }
                }
            });
            AppMethodBeat.o(135299);
        }

        @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.i.a
        public final void setStatus(final int i2) {
            AppMethodBeat.i(135300);
            j.this.P(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.page.capsulebar.j.a.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(135294);
                    a.this.mStatus = i2;
                    if (a.a(a.this)) {
                        j.this.yS(i2);
                    }
                    AppMethodBeat.o(135294);
                }
            });
            AppMethodBeat.o(135300);
        }

        @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.i.a
        public final void dismiss() {
            AppMethodBeat.i(135301);
            j.this.P(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.page.capsulebar.j.a.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(135295);
                    j.this.nvA.remove(a.this);
                    AppMethodBeat.o(135295);
                }
            });
            AppMethodBeat.o(135301);
        }

        static /* synthetic */ boolean a(a aVar) {
            AppMethodBeat.i(135302);
            if (j.this.nvA.peekFirst() == aVar) {
                AppMethodBeat.o(135302);
                return true;
            }
            AppMethodBeat.o(135302);
            return false;
        }
    }
}
