package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ba.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a extends b {
    b Qhx;
    private d Qhy;
    AbstractC2112a Qhz;
    int aZW = 0;
    private View sc = null;

    /* renamed from: com.tencent.mm.ui.conversation.a.a$a  reason: collision with other inner class name */
    public interface AbstractC2112a {
        void aZq(String str);

        void nk(String str, String str2);
    }

    public a(Context context) {
        super(context);
        AppMethodBeat.i(38759);
        if (this.view != null) {
            this.sc = this.view.findViewById(R.id.i4);
            this.Qhy = new d();
            this.Qhy.QhD = this.sc;
            this.Qhy.QhE = (Button) this.view.findViewById(R.id.fh);
            this.Qhy.QhE.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.conversation.a.a.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(38755);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/ADBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (!(a.this.Qhx == null || a.this.Qhz == null)) {
                        a.this.Qhz.aZq(a.this.Qhx.aoa(a.this.aZW).QhC.id);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/ADBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(38755);
                }
            });
            this.sc.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.conversation.a.a.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(38756);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/ADBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (!(a.this.Qhx == null || a.this.Qhz == null)) {
                        c aoa = a.this.Qhx.aoa(a.this.aZW);
                        a.this.Qhz.nk(aoa.QhC.id, aoa.QhC.url);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/ADBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(38756);
                }
            });
        }
        AppMethodBeat.o(38759);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final int getLayoutId() {
        return R.layout.cl;
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void destroy() {
        AppMethodBeat.i(38760);
        if (g.aAf().azp()) {
            bg.aVF();
            c.azQ().remove(this.Qhx);
        }
        AppMethodBeat.o(38760);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void setVisibility(int i2) {
        AppMethodBeat.i(38761);
        if (this.sc != null) {
            this.sc.setVisibility(i2);
        }
        AppMethodBeat.o(38761);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void release() {
        this.Qhx = null;
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final boolean bYa() {
        boolean z;
        AppMethodBeat.i(38762);
        this.Qhx = new b((Context) this.Kgr.get());
        this.Qhz = new AbstractC2112a() {
            /* class com.tencent.mm.ui.conversation.a.a.AnonymousClass3 */

            @Override // com.tencent.mm.ui.conversation.a.a.AbstractC2112a
            public final void nk(String str, String str2) {
                AppMethodBeat.i(38757);
                com.tencent.mm.pluginsdk.k.a.a.gof();
                bg.aVF();
                c.aSM().d(new m(2, str));
                Log.d("MicroMsg.ADBanner", "jump to ".concat(String.valueOf(str2)));
                q.a.JSZ.a((Context) a.this.Kgr.get(), str2, true);
                AppMethodBeat.o(38757);
            }

            @Override // com.tencent.mm.ui.conversation.a.a.AbstractC2112a
            public final void aZq(String str) {
                AppMethodBeat.i(38758);
                com.tencent.mm.pluginsdk.k.a.a.gof();
                bg.aVF();
                c.aSM().d(new m(3, str));
                AppMethodBeat.o(38758);
            }
        };
        com.tencent.mm.pluginsdk.k.a.a ix = com.tencent.mm.pluginsdk.k.a.a.ix(MMApplicationContext.getContext());
        if (this.Qhx != null) {
            if (ix != null) {
                this.Qhx.QhB = ix;
                this.Qhx.anp();
                if (this.Qhx == null || this.Qhx.getCount() <= 0 || this.Qhx.aoa(0).a(this.Qhy) != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    Log.i("MicroMsg.ADBanner", "refreshAndReturnIsVisible[true]");
                    setVisibility(0);
                    AppMethodBeat.o(38762);
                    return true;
                }
            }
            setVisibility(8);
        }
        setVisibility(8);
        AppMethodBeat.o(38762);
        return false;
    }
}
