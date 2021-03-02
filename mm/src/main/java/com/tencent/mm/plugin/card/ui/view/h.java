package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.b.a.a.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.p;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.d.q;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public abstract class h implements ab {
    protected MMActivity pQZ;
    protected g qjU;

    public abstract boolean cxx();

    public abstract boolean cxy();

    public h(g gVar, MMActivity mMActivity) {
        this.qjU = gVar;
        this.pQZ = mMActivity;
    }

    @Override // com.tencent.mm.plugin.card.ui.view.ab
    public void c(ViewGroup viewGroup, final b bVar) {
        if (cxx()) {
            TextView textView = (TextView) viewGroup.findViewById(R.id.b5f);
            String str = this.qjU.code;
            if (bVar.csK() || (!Util.isNullOrNil(str) && str.length() <= 40)) {
                textView.setText(n.akl(str));
                if (bVar.csF()) {
                    textView.setVisibility(0);
                    textView.setOnLongClickListener(new View.OnLongClickListener() {
                        /* class com.tencent.mm.plugin.card.ui.view.h.AnonymousClass1 */

                        public final boolean onLongClick(View view) {
                            AppMethodBeat.i(113672);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            a.b("com/tencent/mm/plugin/card/ui/view/CardBaseCodeViewController$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                            if (view.getId() == R.id.b5f) {
                                q.TF(bVar.csR().code);
                                com.tencent.mm.ui.base.h.cD(h.this.pQZ, p.getString(R.string.ta));
                            }
                            a.a(false, (Object) this, "com/tencent/mm/plugin/card/ui/view/CardBaseCodeViewController$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                            AppMethodBeat.o(113672);
                            return false;
                        }
                    });
                    this.qjU.d(c.CARDCODEREFRESHACTION_ENTERCHANGE);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
        if (cxy()) {
            LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(R.id.b53);
            if (bVar == null || bVar.csQ() == null || bVar.csQ().Lfe == null || Util.isNullOrNil(bVar.csQ().Lfe.title)) {
                linearLayout.setVisibility(8);
                return;
            }
            viewGroup.findViewById(R.id.b4v).setVisibility(8);
            linearLayout.setVisibility(0);
            abz abz = bVar.csQ().Lfe;
            TextView textView2 = (TextView) viewGroup.findViewById(R.id.b55);
            textView2.setText(abz.title);
            String str2 = bVar.csQ().ixw;
            if (!Util.isNullOrNil(str2)) {
                textView2.setTextColor(l.ake(str2));
            }
            TextView textView3 = (TextView) viewGroup.findViewById(R.id.b54);
            String str3 = abz.pRZ;
            if (!TextUtils.isEmpty(str3)) {
                if (textView3 != null) {
                    textView3.setText(str3);
                    textView3.setVisibility(0);
                }
            } else if (textView3 != null) {
                textView3.setVisibility(8);
            }
            linearLayout.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.card.ui.view.h.AnonymousClass2 */

                public final void onClick(View view) {
                    int i2;
                    int i3;
                    AppMethodBeat.i(113673);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/card/ui/view/CardBaseCodeViewController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (bVar.csJ()) {
                        j.b bVar2 = new j.b();
                        com.tencent.mm.plugin.card.d.b.a(h.this.qjU.pQZ, bVar2.pRN, bVar2.pRO, false, bVar);
                    } else {
                        abz abz = bVar.csQ().Lfe;
                        if (abz != null && !Util.isNullOrNil(abz.Lep) && !Util.isNullOrNil(abz.Leo)) {
                            if (h.this.pQZ.getIntent() != null) {
                                i2 = h.this.pQZ.getIntent().getIntExtra("key_from_scene", 3);
                            } else {
                                i2 = 3;
                            }
                            if (h.this.pQZ.getIntent() != null) {
                                i3 = h.this.pQZ.getIntent().getIntExtra("key_from_appbrand_type", 0);
                            } else {
                                i3 = 0;
                            }
                            com.tencent.mm.plugin.card.d.b.a(bVar.csU(), abz, i2, i3);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11941, 20, bVar.csU(), bVar.csV(), "", abz.title);
                        } else if (abz != null && !TextUtils.isEmpty(abz.url)) {
                            com.tencent.mm.plugin.card.d.b.a(h.this.qjU.pQZ, l.Y(abz.url, abz.LfD), 1);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11941, 9, bVar.csU(), bVar.csV(), "", abz.title);
                            if (l.a(abz, bVar.csU())) {
                                l.akj(bVar.csU());
                                com.tencent.mm.plugin.card.d.b.b(h.this.qjU.pQZ, bVar.csQ().gTG);
                            }
                        }
                    }
                    t.finish();
                    a.a(this, "com/tencent/mm/plugin/card/ui/view/CardBaseCodeViewController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(113673);
                }
            });
        }
    }

    @Override // com.tencent.mm.plugin.card.ui.view.ab
    public boolean g(b bVar) {
        return true;
    }

    @Override // com.tencent.mm.plugin.card.ui.view.ab
    public void n(ViewGroup viewGroup) {
    }
}
