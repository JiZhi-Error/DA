package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.sdk.b.a.c;
import com.tencent.luggage.sdk.config.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a;
import com.tencent.mm.plugin.appbrand.page.k;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Util;

public class AppBrandMenuHeader extends LinearLayout {
    private View kHq;

    public AppBrandMenuHeader(Context context) {
        super(context);
        AppMethodBeat.i(47775);
        bh(context);
        AppMethodBeat.o(47775);
    }

    public AppBrandMenuHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(47776);
        bh(context);
        AppMethodBeat.o(47776);
    }

    private void bh(Context context) {
        AppMethodBeat.i(47777);
        this.kHq = LayoutInflater.from(context).inflate(R.layout.eb, this);
        AppMethodBeat.o(47777);
    }

    public void setPage(final ag agVar) {
        AppMethodBeat.i(47778);
        q runtime = agVar.getRuntime();
        ImageView imageView = (ImageView) this.kHq.findViewById(R.id.dt5);
        TextView textView = (TextView) this.kHq.findViewById(R.id.ft7);
        TextView textView2 = (TextView) this.kHq.findViewById(R.id.bl2);
        ImageView imageView2 = (ImageView) this.kHq.findViewById(R.id.g6q);
        ImageView imageView3 = (ImageView) this.kHq.findViewById(R.id.iut);
        ImageView imageView4 = (ImageView) this.kHq.findViewById(R.id.g37);
        if (!e.hP(agVar.getRuntime().bsB().leb) || ((b) g.af(b.class)).a(b.a.clicfg_scene_appbrand_menu, 0) != 1) {
            imageView3.setVisibility(8);
        } else {
            imageView3.setVisibility(0);
        }
        if (!e.hO(agVar.getRuntime().bsB().lec) || ((b) g.af(b.class)).a(b.a.clicfg_appbrand_show_official_flag, 0) != 1) {
            imageView4.setVisibility(8);
        } else {
            imageView4.setVisibility(0);
        }
        final TextView textView3 = (TextView) this.kHq.findViewById(R.id.hb9);
        View findViewById = this.kHq.findViewById(R.id.i5h);
        ImageView imageView5 = (ImageView) this.kHq.findViewById(R.id.i5e);
        TextView textView4 = (TextView) this.kHq.findViewById(R.id.i5c);
        View findViewById2 = this.kHq.findViewById(R.id.ftb);
        final k ad = k.ad(runtime);
        final Runnable c2 = ad.c(agVar);
        com.tencent.mm.modelappbrand.a.b.aXY().a(imageView, ad.bQA(), a.aXX(), new com.tencent.mm.modelappbrand.a.g());
        imageView.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.page.AppBrandMenuHeader.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(47771);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandMenuHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                c2.run();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandMenuHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(47771);
            }
        });
        findViewById2.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.page.AppBrandMenuHeader.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(47772);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandMenuHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                c2.run();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandMenuHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(47772);
            }
        });
        textView.getPaint().setFakeBoldText(true);
        textView.setText(ad.bQB());
        String bQC = ad.bQC();
        if (Util.isNullOrNil(bQC)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(bQC);
            textView2.setVisibility(0);
        }
        if (ad.bQD()) {
            imageView2.setVisibility(0);
        } else {
            imageView2.setVisibility(8);
        }
        ad.a(new k.a() {
            /* class com.tencent.mm.plugin.appbrand.page.AppBrandMenuHeader.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.appbrand.page.k.a
            public final void ady(String str) {
                AppMethodBeat.i(47773);
                if (Util.isNullOrNil(str)) {
                    textView3.setVisibility(8);
                    AppMethodBeat.o(47773);
                    return;
                }
                textView3.setText(str);
                textView3.setVisibility(0);
                AppMethodBeat.o(47773);
            }
        });
        k.b yI = ad.yI(a.C0775a.ah(agVar.getRuntime()).bSu());
        if (yI == null) {
            findViewById.setVisibility(8);
            AppMethodBeat.o(47778);
            return;
        }
        findViewById.setBackgroundResource(yI.nod);
        imageView5.setImageResource(yI.noe);
        textView4.setText(yI.desc);
        findViewById.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.page.AppBrandMenuHeader.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(47774);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandMenuHeader$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                new Runnable(agVar) {
                    /* class com.tencent.mm.plugin.appbrand.page.k.AnonymousClass6 */
                    final /* synthetic */ c msK;

                    {
                        this.msK = r2;
                    }

                    public final void run() {
                        AppMethodBeat.i(175026);
                        String str = this.msK.NP().ON().username;
                        if (Util.isNullOrNil(str)) {
                            AppMethodBeat.o(175026);
                            return;
                        }
                        Intent putExtra = new Intent(this.msK.getContext(), AppBrandAuthorizeUI.class).putExtra("key_username", str);
                        putExtra.putExtra("key_app_authorize_profile", true);
                        com.tencent.mm.br.c.b(this.msK.getContext(), "appbrand", ".ui.AppBrandAuthorizeUI", putExtra);
                        i.a(this.msK.getAppId(), this.msK.lBI, 34, "", Util.nowSecond(), 1, 0);
                        AppMethodBeat.o(175026);
                    }
                }.run();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandMenuHeader$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(47774);
            }
        });
        findViewById.setVisibility(0);
        AppMethodBeat.o(47778);
    }
}
