package com.tencent.mm.ui.d;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class a extends b {
    boolean ONP = false;
    b.EnumC0443b ONQ = null;
    String ONR = "";
    String mUrl = null;
    String mWording = null;

    public a(Context context, b.EnumC0443b bVar) {
        super(context);
        AppMethodBeat.i(33849);
        this.ONQ = bVar;
        setVisibility(8);
        refresh();
        AppMethodBeat.o(33849);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final int getLayoutId() {
        return R.layout.tx;
    }

    private void refresh() {
        AppMethodBeat.i(33850);
        setVisibility(8);
        h.RTc.aY(new Runnable() {
            /* class com.tencent.mm.ui.d.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(232758);
                bg.aVF().aTo();
                final boolean a2 = com.tencent.mm.model.b.b.a(a.this.ONQ);
                h.RTc.aV(new Runnable() {
                    /* class com.tencent.mm.ui.d.a.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(232757);
                        if (a2) {
                            Log.i("MicroMsg.ChattingMonitoredBanner", "hy: start show banner: %s, %s, %s, %b", a.this.ONQ, a.this.mWording, a.this.mUrl, Boolean.valueOf(a.this.ONP));
                            if (a.this.ONQ == b.EnumC0443b.Chatting) {
                                a aVar = a.this;
                                bg.aVF().aTo();
                                aVar.mWording = com.tencent.mm.model.b.b.aWZ();
                                a aVar2 = a.this;
                                bg.aVF().aTo();
                                aVar2.mUrl = com.tencent.mm.model.b.b.aXa();
                                a aVar3 = a.this;
                                bg.aVF().aTo();
                                aVar3.ONP = com.tencent.mm.model.b.b.aXb();
                            } else {
                                a aVar4 = a.this;
                                bg.aVF().aTo();
                                aVar4.mWording = com.tencent.mm.model.b.b.aWW();
                                a aVar5 = a.this;
                                bg.aVF().aTo();
                                aVar5.mUrl = com.tencent.mm.model.b.b.aWX();
                                a aVar6 = a.this;
                                bg.aVF().aTo();
                                aVar6.ONP = com.tencent.mm.model.b.b.aWY();
                            }
                            TextView textView = (TextView) a.this.getView().findViewById(R.id.ax9);
                            ImageView imageView = (ImageView) a.this.getView().findViewById(R.id.b4d);
                            if (!Util.isNullOrNil(a.this.mWording)) {
                                textView.setText(a.this.mWording);
                            } else {
                                textView.setText(R.string.a06);
                            }
                            textView.setSelected(true);
                            if (!Util.isNullOrNil(a.this.mUrl)) {
                                a.this.getView().findViewById(R.id.fjk).setBackgroundResource(R.drawable.azq);
                                imageView.setImageResource(R.drawable.aj3);
                                textView.setTextColor(MMApplicationContext.getContext().getResources().getColor(R.color.BW_50));
                            } else {
                                a.this.getView().findViewById(R.id.fjk).setBackgroundResource(R.color.abm);
                                imageView.setImageResource(R.drawable.aj2);
                                textView.setTextColor(MMApplicationContext.getContext().getResources().getColor(R.color.ag2));
                            }
                            a.this.getView().setOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.ui.d.a.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(232755);
                                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/banner/ChattingMonitoredBanner$1$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    a.a(a.this, 1);
                                    a aVar = a.this;
                                    String str = a.this.mUrl;
                                    if (Util.isNullOrNil(str)) {
                                        Log.e("MicroMsg.ChattingMonitoredBanner", "hy: not provide url");
                                    } else {
                                        Intent intent = new Intent();
                                        intent.putExtra("rawUrl", str);
                                        intent.putExtra("showShare", false);
                                        intent.putExtra("show_bottom", false);
                                        c.b((Context) aVar.Kgr.get(), "webview", ".ui.tools.WebViewUI", intent);
                                    }
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/banner/ChattingMonitoredBanner$1$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(232755);
                                }
                            });
                            if (a.this.getView().getVisibility() != 0) {
                                a aVar7 = a.this;
                                StringBuilder sb = new StringBuilder();
                                g.aAf();
                                aVar7.ONR = sb.append(com.tencent.mm.kernel.a.getUin()).append("_").append(System.currentTimeMillis()).toString();
                                a.a(a.this, 0);
                            }
                            a.this.setVisibility(0);
                            if (a.this.ONP) {
                                imageView.setVisibility(0);
                                imageView.setOnClickListener(new View.OnClickListener() {
                                    /* class com.tencent.mm.ui.d.a.AnonymousClass1.AnonymousClass1.AnonymousClass2 */

                                    public final void onClick(View view) {
                                        AppMethodBeat.i(232756);
                                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                        bVar.bm(view);
                                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/banner/ChattingMonitoredBanner$1$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                        Log.i("MicroMsg.ChattingMonitoredBanner", "hy: user required close the banner");
                                        a.a(a.this, 2);
                                        bg.aVF().aTo().c(b.EnumC0443b.Main);
                                        bg.aVF().aTo().c(b.EnumC0443b.Chatting);
                                        a.this.setVisibility(8);
                                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/banner/ChattingMonitoredBanner$1$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                        AppMethodBeat.o(232756);
                                    }
                                });
                                AppMethodBeat.o(232757);
                                return;
                            }
                            imageView.setVisibility(8);
                            AppMethodBeat.o(232757);
                            return;
                        }
                        Log.i("MicroMsg.ChattingMonitoredBanner", "hy: should not show banner");
                        a.this.setVisibility(8);
                        AppMethodBeat.o(232757);
                    }
                });
                AppMethodBeat.o(232758);
            }
        });
        AppMethodBeat.o(33850);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void setVisibility(int i2) {
        AppMethodBeat.i(33851);
        super.setVisibility(i2);
        getView().findViewById(R.id.fjk).setVisibility(i2);
        AppMethodBeat.o(33851);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final boolean bYa() {
        AppMethodBeat.i(33852);
        refresh();
        boolean bYa = super.bYa();
        AppMethodBeat.o(33852);
        return bYa;
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void destroy() {
    }

    static /* synthetic */ void a(a aVar, int i2) {
        int i3 = 1;
        AppMethodBeat.i(232759);
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
        Object[] objArr = new Object[3];
        objArr[0] = aVar.ONR;
        objArr[1] = Integer.valueOf(i2);
        if (aVar.ONQ == b.EnumC0443b.Main) {
            i3 = 0;
        }
        objArr[2] = Integer.valueOf(i3);
        hVar.a(14439, objArr);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(633, (long) i2, 1, false);
        AppMethodBeat.o(232759);
    }
}
