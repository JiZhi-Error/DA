package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.bg;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.v;
import com.tencent.mm.protocal.g;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;

public final class i {

    public static final class c {
        public int resourceId = 0;
        public int textColor = Integer.MIN_VALUE;
        public int textSize = Integer.MIN_VALUE;
        public boolean zgx = false;
        public int zgy = 0;
        public cbe zgz;
    }

    /* access modifiers changed from: package-private */
    public interface d {
        void a(Context context, ViewGroup viewGroup, bg bgVar);
    }

    public static void a(Context context, ViewGroup viewGroup, bg bgVar, c cVar) {
        AppMethodBeat.i(65785);
        if (bgVar == null) {
            AppMethodBeat.o(65785);
            return;
        }
        a(context, viewGroup, bgVar, cVar, bgVar.type);
        AppMethodBeat.o(65785);
    }

    public static void a(Context context, ViewGroup viewGroup, bg bgVar, c cVar, String str) {
        AppMethodBeat.i(65786);
        if (viewGroup == null || bgVar == null) {
            AppMethodBeat.o(65786);
        } else if (bgVar.gGn == 0) {
            Log.i("MicroMsg.LuckyMoneyOperationViewMgr", "operInfo enable:" + bgVar.gGn);
            viewGroup.setVisibility(8);
            AppMethodBeat.o(65786);
        } else if (!bgVar.type.equalsIgnoreCase(str)) {
            Log.i("MicroMsg.LuckyMoneyOperationViewMgr", "not match type:" + bgVar.type + ", " + str);
            viewGroup.setVisibility(8);
            AppMethodBeat.o(65786);
        } else if (str.equalsIgnoreCase("Text") || str.equalsIgnoreCase("Native")) {
            e eVar = new e();
            eVar.zgs = cVar;
            eVar.a(context, viewGroup, bgVar);
            AppMethodBeat.o(65786);
        } else if (str.equalsIgnoreCase("Pic")) {
            a aVar = new a();
            aVar.zgs = cVar;
            aVar.a(context, viewGroup, bgVar);
            AppMethodBeat.o(65786);
        } else {
            if (str.equalsIgnoreCase("Appid")) {
                b bVar = new b();
                bVar.zgs = cVar;
                bVar.a(context, viewGroup, bgVar);
            }
            AppMethodBeat.o(65786);
        }
    }

    /* access modifiers changed from: package-private */
    public static class e implements d {
        c zgs;

        e() {
        }

        @Override // com.tencent.mm.plugin.luckymoney.ui.i.d
        public final void a(final Context context, ViewGroup viewGroup, final bg bgVar) {
            AppMethodBeat.i(65784);
            if (Util.isNullOrNil(bgVar.name)) {
                AppMethodBeat.o(65784);
                return;
            }
            View inflate = LayoutInflater.from(context).inflate(R.layout.b4f, viewGroup, true);
            TextView textView = (TextView) inflate.findViewById(R.id.f4w);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.f4v);
            if (!Util.isNullOrNil(bgVar.iconUrl)) {
                af.o(imageView, bgVar.iconUrl);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (this.zgs == null || this.zgs.textSize == Integer.MIN_VALUE) {
                textView.setTextSize(0, (float) context.getResources().getDimensionPixelSize(R.dimen.hc));
            } else {
                textView.setTextSize(0, (float) this.zgs.textSize);
            }
            textView.setGravity(17);
            textView.setText(bgVar.name);
            if (!Util.isNullOrNil(bgVar.content)) {
                textView.setTextColor(MMApplicationContext.getContext().getResources().getColor(R.color.x0));
                textView.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.i.e.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(65783);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyOperationViewMgr$TextOperationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        h.INSTANCE.a(11701, 14, 0, 0, 0, 2, Integer.valueOf(bgVar.yXT));
                        if (e.this.zgs != null) {
                            g.gH(e.this.zgs.zgy, 1);
                        }
                        if (e.this.zgs != null && e.this.zgs.zgx) {
                            h.INSTANCE.a(13051, Integer.valueOf(e.this.zgs.zgy), 2, "", "", "", bgVar.content, bgVar.type, "", "", Integer.valueOf(e.this.zgs.resourceId));
                        }
                        if (bgVar.type.equals("Native")) {
                            Log.i("MicroMsg.LuckyMoneyOperationViewMgr", "go native:" + bgVar.content);
                            if ("weixin://festival/gotoshake".equalsIgnoreCase(bgVar.content)) {
                                Log.i("MicroMsg.LuckyMoneyOperationViewMgr", " go new year shake");
                            }
                        } else {
                            f.p(context, bgVar.content, true);
                        }
                        h hVar = h.INSTANCE;
                        Object[] objArr = new Object[6];
                        objArr[0] = 2;
                        objArr[1] = bgVar.content;
                        objArr[2] = e.this.zgs.zgz != null ? e.this.zgs.zgz.MgB : "";
                        objArr[3] = com.tencent.mm.plugin.luckymoney.a.c.yOW;
                        objArr[4] = 0;
                        objArr[5] = com.tencent.mm.plugin.luckymoney.a.c.openId;
                        hVar.a(16589, objArr);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyOperationViewMgr$TextOperationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(65783);
                    }
                });
            }
            if (!(this.zgs == null || this.zgs.textColor == Integer.MIN_VALUE)) {
                textView.setTextColor(this.zgs.textColor);
            }
            viewGroup.setVisibility(0);
            h.INSTANCE.a(11701, 14, 0, 0, 0, 1, Integer.valueOf(bgVar.yXT));
            if (this.zgs != null) {
                g.gH(this.zgs.zgy, 0);
            }
            AppMethodBeat.o(65784);
        }
    }

    /* access modifiers changed from: package-private */
    public static class b implements d {
        c zgs;

        b() {
        }

        @Override // com.tencent.mm.plugin.luckymoney.ui.i.d
        public final void a(final Context context, ViewGroup viewGroup, final bg bgVar) {
            AppMethodBeat.i(65782);
            if (Util.isNullOrNil(bgVar.name)) {
                AppMethodBeat.o(65782);
                return;
            }
            TextView textView = new TextView(context);
            if (this.zgs == null || this.zgs.textColor == Integer.MIN_VALUE) {
                textView.setTextColor(context.getResources().getColor(R.color.ae6));
            } else {
                textView.setTextColor(this.zgs.textColor);
            }
            if (this.zgs == null || this.zgs.textSize == Integer.MIN_VALUE) {
                textView.setTextSize(0, (float) context.getResources().getDimensionPixelSize(R.dimen.hc));
            } else {
                textView.setTextSize(0, (float) this.zgs.textSize);
            }
            textView.setGravity(17);
            textView.setText(bgVar.name);
            if (!Util.isNullOrNil(bgVar.content)) {
                textView.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.i.b.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(65781);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyOperationViewMgr$BizOperationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        h.INSTANCE.a(11701, 14, 0, 0, 0, 2, Integer.valueOf(bgVar.yXT));
                        if (bgVar.yXU != 1) {
                            ((com.tencent.mm.pluginsdk.i) com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.i.class)).a(context, bgVar.content, new v() {
                                /* class com.tencent.mm.plugin.luckymoney.ui.i.b.AnonymousClass1.AnonymousClass1 */

                                @Override // com.tencent.mm.pluginsdk.ui.applet.v
                                public final void wK(int i2) {
                                    AppMethodBeat.i(65780);
                                    switch (i2) {
                                        case -2:
                                        case 1:
                                            f.ao(context, bgVar.content);
                                            break;
                                    }
                                    AppMethodBeat.o(65780);
                                }
                            }).show();
                        } else {
                            f.am(context, bgVar.content);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyOperationViewMgr$BizOperationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(65781);
                    }
                });
            }
            viewGroup.addView(textView, new ViewGroup.LayoutParams(-2, -2));
            viewGroup.setVisibility(0);
            h.INSTANCE.a(11701, 14, 0, 0, 0, 1, Integer.valueOf(bgVar.yXT));
            AppMethodBeat.o(65782);
        }
    }

    /* access modifiers changed from: package-private */
    public static class a implements d {
        c zgs;

        a() {
        }

        @Override // com.tencent.mm.plugin.luckymoney.ui.i.d
        public final void a(final Context context, ViewGroup viewGroup, final bg bgVar) {
            AppMethodBeat.i(65779);
            if (Util.isNullOrNil(bgVar.name)) {
                Log.w("MicroMsg.LuckyMoneyOperationViewMgr", "BannerPicOperationView attach iconUrl null");
                viewGroup.setVisibility(8);
                AppMethodBeat.o(65779);
                return;
            }
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            af.o(imageView, bgVar.name);
            if (!Util.isNullOrNil(bgVar.content)) {
                imageView.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.i.a.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(65778);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyOperationViewMgr$BannerPicOperationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        h.INSTANCE.a(11701, 14, 0, 0, 0, 2, Integer.valueOf(bgVar.yXT));
                        if (a.this.zgs != null) {
                            g.gH(a.this.zgs.zgy, 1);
                        }
                        f.p(context, bgVar.content, true);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyOperationViewMgr$BannerPicOperationView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(65778);
                    }
                });
            }
            imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            viewGroup.addView(imageView);
            viewGroup.setVisibility(0);
            h.INSTANCE.a(11701, 14, 0, 0, 0, 1, Integer.valueOf(bgVar.yXT));
            if (this.zgs != null) {
                g.gH(this.zgs.zgy, 0);
            }
            AppMethodBeat.o(65779);
        }
    }
}
