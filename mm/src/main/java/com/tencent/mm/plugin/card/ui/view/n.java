package com.tencent.mm.plugin.card.ui.view;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.card.b.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.aie;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public final class n extends h {
    public n(g gVar, MMActivity mMActivity) {
        super(gVar, mMActivity);
    }

    @Override // com.tencent.mm.plugin.card.ui.view.ab
    public final int getLayoutId() {
        return R.layout.ma;
    }

    @Override // com.tencent.mm.plugin.card.ui.view.ab, com.tencent.mm.plugin.card.ui.view.h
    public final boolean g(b bVar) {
        AppMethodBeat.i(113692);
        if (!bVar.csR().LcG) {
            Log.e("MicroMsg.CardDynamicQrCodeController", "isCanGetAndShowCode false : is_commom_card false!ban card show!");
            AppMethodBeat.o(113692);
            return false;
        }
        abz abz = bVar.csR().LcF;
        if (abz == null || Util.isNullOrNil(abz.title)) {
            AppMethodBeat.o(113692);
            return true;
        }
        Log.e("MicroMsg.CardDynamicQrCodeController", "isCanGetAndShowCode false : unavailable_qrcode_field is not null  !ban card show!");
        AppMethodBeat.o(113692);
        return false;
    }

    @Override // com.tencent.mm.plugin.card.ui.view.ab, com.tencent.mm.plugin.card.ui.view.h
    public final void n(ViewGroup viewGroup) {
        AppMethodBeat.i(113693);
        viewGroup.findViewById(R.id.b5_).setVisibility(8);
        viewGroup.findViewById(R.id.b58).setVisibility(0);
        AppMethodBeat.o(113693);
    }

    @Override // com.tencent.mm.plugin.card.ui.view.ab, com.tencent.mm.plugin.card.ui.view.h
    public final void c(ViewGroup viewGroup, b bVar) {
        AppMethodBeat.i(113694);
        super.c(viewGroup, bVar);
        d(viewGroup, bVar);
        AppMethodBeat.o(113694);
    }

    /* access modifiers changed from: package-private */
    public final void d(final ViewGroup viewGroup, b bVar) {
        AppMethodBeat.i(113695);
        aie aie = bVar.csQ().Lff;
        View findViewById = viewGroup.findViewById(R.id.b5b);
        if (aie == null || !aie.LrM) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
            if (!Util.isNullOrNil(aie.LrN)) {
                ((TextView) viewGroup.findViewById(R.id.b5c)).setText(aie.LrN);
                ((ImageView) viewGroup.findViewById(R.id.b5a)).setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.card.ui.view.n.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(113689);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        a.b("com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        View findViewById = viewGroup.findViewById(R.id.b5_);
                        if (((Button) viewGroup.findViewById(R.id.b4u)).getVisibility() == 0 && findViewById.getVisibility() == 0) {
                            a.a(this, "com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(113689);
                            return;
                        }
                        if (findViewById.getVisibility() == 0) {
                            if (!l.isNetworkAvailable(n.this.pQZ.getContext())) {
                                d.a(n.this.pQZ, n.this.pQZ.getString(R.string.aor), false);
                                a.a(this, "com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(113689);
                                return;
                            }
                            findViewById.setVisibility(8);
                            viewGroup.findViewById(R.id.b58).setVisibility(0);
                        }
                        n.this.qjU.d(c.CARDCODEREFRESHACTION_DOREFRESH);
                        a.a(this, "com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(113689);
                    }
                });
                AppMethodBeat.o(113695);
                return;
            }
        }
        AppMethodBeat.o(113695);
    }

    @Override // com.tencent.mm.plugin.card.ui.view.h
    public final boolean cxx() {
        return false;
    }

    @Override // com.tencent.mm.plugin.card.ui.view.h
    public final boolean cxy() {
        return true;
    }

    @Override // com.tencent.mm.plugin.card.ui.view.ab
    public final void a(ViewGroup viewGroup, final b bVar) {
        AppMethodBeat.i(113696);
        am.cug().ctj();
        viewGroup.findViewById(R.id.b5_).setVisibility(0);
        viewGroup.findViewById(R.id.b58).setVisibility(8);
        final abz abz = bVar.csR().LcF;
        if (abz != null) {
            viewGroup.findViewById(R.id.b5e).setVisibility(0);
            if (!Util.isNullOrNil(abz.title)) {
                Button button = (Button) viewGroup.findViewById(R.id.b4u);
                button.setText(abz.title);
                button.setVisibility(0);
                a(button, bVar);
                button.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.card.ui.view.n.AnonymousClass2 */

                    public final void onClick(View view) {
                        int i2;
                        AppMethodBeat.i(113690);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        a.b("com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (!Util.isNullOrNil(abz.Lep) && !Util.isNullOrNil(abz.Leo)) {
                            int intExtra = n.this.pQZ.getIntent() != null ? n.this.pQZ.getIntent().getIntExtra("key_from_scene", 3) : 3;
                            if (n.this.pQZ.getIntent() != null) {
                                i2 = n.this.pQZ.getIntent().getIntExtra("key_from_appbrand_type", 0);
                            } else {
                                i2 = 0;
                            }
                            com.tencent.mm.plugin.card.d.b.a(bVar.csU(), abz, intExtra, i2);
                            h.INSTANCE.a(11941, 20, bVar.csU(), bVar.csV(), "", abz.title);
                        } else if (!Util.isNullOrNil(abz.url)) {
                            com.tencent.mm.plugin.card.d.b.a(n.this.pQZ, l.Y(abz.url, abz.LfD), 1);
                            h hVar = h.INSTANCE;
                            Object[] objArr = new Object[5];
                            objArr[0] = 9;
                            objArr[1] = bVar.csU();
                            objArr[2] = bVar.csV();
                            objArr[3] = "";
                            objArr[4] = abz.title != null ? abz.title : "";
                            hVar.a(11941, objArr);
                        } else {
                            d.a(n.this.pQZ, n.this.pQZ.getString(R.string.atv), true);
                        }
                        a.a(this, "com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(113690);
                    }
                });
                if (!Util.isNullOrNil(abz.pRY)) {
                    ((TextView) viewGroup.findViewById(R.id.b4w)).setText(abz.pRY);
                }
                TextView textView = (TextView) viewGroup.findViewById(R.id.b5d);
                if (!Util.isNullOrNil(abz.pRZ)) {
                    textView.setText(abz.pRZ);
                    textView.setVisibility(0);
                    AppMethodBeat.o(113696);
                    return;
                }
                textView.setVisibility(8);
            }
        }
        AppMethodBeat.o(113696);
    }

    @Override // com.tencent.mm.plugin.card.ui.view.ab
    public final void b(final ViewGroup viewGroup, final b bVar) {
        AppMethodBeat.i(113697);
        Log.i("MicroMsg.CardDynamicQrCodeController", "onScreenShot! ");
        final View findViewById = viewGroup.findViewById(R.id.b5_);
        if (findViewById.getVisibility() == 0) {
            Log.e("MicroMsg.CardDynamicQrCodeController", "code_qr_disable_layout is visible! do not show hint!");
            AppMethodBeat.o(113697);
            return;
        }
        findViewById.setVisibility(0);
        View findViewById2 = viewGroup.findViewById(R.id.b5b);
        if (findViewById2.getVisibility() == 0) {
            findViewById2.setVisibility(8);
        }
        final ImageView imageView = (ImageView) viewGroup.findViewById(R.id.b58);
        imageView.setVisibility(8);
        final View findViewById3 = viewGroup.findViewById(R.id.b5e);
        findViewById3.setVisibility(0);
        ((TextView) viewGroup.findViewById(R.id.b4w)).setText(this.pQZ.getResources().getString(R.string.any));
        final Button button = (Button) viewGroup.findViewById(R.id.b4u);
        button.setVisibility(0);
        a(button, bVar);
        g cug = am.cug();
        if (bVar == null) {
            Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport do nothing return !cardInfo is null!");
        } else {
            cug.ctj();
            k ajo = am.cue().ajo(bVar.csU());
            if (ajo != null) {
                Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport currentCode cardId =%s,codeId=%s", ajo.field_card_id, ajo.field_code_id);
                if (am.cue().fr(bVar.csU(), ajo.field_code_id)) {
                    cug.a(bVar.csU(), ajo.field_code_id, c.CARDCODEREFRESHACTION_SNAPSHOT);
                } else {
                    Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport delete failue! do not report! cardId =%s,codeId=%s", ajo.field_card_id, ajo.field_code_id);
                }
            } else {
                Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport  failue! currentCode is null!");
            }
        }
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.card.ui.view.n.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(113691);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                findViewById.setVisibility(8);
                findViewById3.setVisibility(8);
                imageView.setVisibility(0);
                button.setVisibility(8);
                n.this.qjU.d(c.CARDCODEREFRESHACTION_SNAPSHOT);
                n.this.d(viewGroup, bVar);
                a.a(this, "com/tencent/mm/plugin/card/ui/view/CardDynamicQrCodeController$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(113691);
            }
        });
        AppMethodBeat.o(113697);
    }

    private void a(Button button, b bVar) {
        AppMethodBeat.i(113698);
        String str = bVar.csQ().ixw;
        if (!Util.isNullOrNil(str)) {
            int ake = l.ake(str);
            button.setText(this.pQZ.getResources().getString(R.string.anz));
            button.setTextColor(ake);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(this.pQZ.getResources().getColor(R.color.hp));
            gradientDrawable.setStroke(2, ake);
            gradientDrawable.setCornerRadius(8.0f);
            button.setBackground(gradientDrawable);
        }
        AppMethodBeat.o(113698);
    }
}
