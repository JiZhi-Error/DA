package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ay.f;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a extends b {
    private TextView And;
    private f Ane = null;
    private IListener lEl;
    private View oQL;
    private View oQM;

    static /* synthetic */ boolean a(a aVar) {
        AppMethodBeat.i(63202);
        boolean evf = aVar.evf();
        AppMethodBeat.o(63202);
        return evf;
    }

    public a(Context context) {
        super(context);
        AppMethodBeat.i(63196);
        if (this.view != null) {
            this.And = (TextView) this.view.findViewById(R.id.fpt);
            this.oQL = this.view.findViewById(R.id.fpu);
            this.oQM = this.view.findViewById(R.id.a29);
            this.And.setTextSize(0, (float) com.tencent.mm.cb.a.aG(MMApplicationContext.getContext(), R.dimen.hc));
            this.view.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.music.ui.a.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(63194);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/MusicBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    f bef = com.tencent.mm.ay.a.bef();
                    if (bef == null || !bef.jfu || TextUtils.isEmpty(bef.jfv)) {
                        Intent intent = new Intent();
                        h.INSTANCE.a(11992, 1);
                        intent.putExtra("key_scene", 1);
                        c.b((Context) a.this.Kgr.get(), "music", ".ui.MusicMainUI", intent);
                    } else {
                        String str = bef.jfv;
                        Log.i("MusicBanner", "barBackToWebView is true, start to jump Url:%s", str);
                        Intent intent2 = new Intent();
                        intent2.putExtra("rawUrl", str);
                        c.b((Context) a.this.Kgr.get(), "webview", ".ui.tools.WebViewUI", intent2);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/music/ui/MusicBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(63194);
                }
            });
        }
        this.lEl = new IListener<mx>() {
            /* class com.tencent.mm.plugin.music.ui.a.AnonymousClass2 */

            {
                AppMethodBeat.i(160408);
                this.__eventId = mx.class.getName().hashCode();
                AppMethodBeat.o(160408);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(mx mxVar) {
                AppMethodBeat.i(63195);
                switch (mxVar.dSE.action) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 7:
                        a.a(a.this);
                        break;
                }
                AppMethodBeat.o(63195);
                return false;
            }
        };
        EventCenter.instance.addListener(this.lEl);
        AppMethodBeat.o(63196);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final int getLayoutId() {
        return R.layout.bdq;
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void setVisibility(int i2) {
        AppMethodBeat.i(63197);
        if (this.view != null) {
            View findViewById = this.view.findViewById(R.id.fpu);
            if (i2 == 0) {
                if (com.tencent.mm.compatible.e.b.cx(MMApplicationContext.getContext())) {
                    Log.e("MicroMsg.MusicBanner", "isFloatWindowOpAllowed return true");
                    findViewById.setVisibility(8);
                    if (com.tencent.mm.ay.a.bec()) {
                        Log.i("MicroMsg.MusicBanner", "resume music to float ball");
                        com.tencent.mm.plugin.music.model.b.x(this.Ane);
                        AppMethodBeat.o(63197);
                        return;
                    }
                } else {
                    Log.e("MicroMsg.MusicBanner", "isFloatWindowOpAllowed return false");
                }
            }
            findViewById.setVisibility(i2);
        }
        AppMethodBeat.o(63197);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final boolean bYa() {
        AppMethodBeat.i(63198);
        boolean evf = evf();
        AppMethodBeat.o(63198);
        return evf;
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void destroy() {
        AppMethodBeat.i(63199);
        EventCenter.instance.removeListener(this.lEl);
        AppMethodBeat.o(63199);
    }

    private void aIa(String str) {
        AppMethodBeat.i(63200);
        if (this.And != null) {
            this.And.setText(str);
        }
        AppMethodBeat.o(63200);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final int getOrder() {
        return 1;
    }

    private boolean evf() {
        int i2;
        AppMethodBeat.i(63201);
        if (this.isFirst && this.ifo) {
            this.oQM.setBackgroundResource(R.drawable.azq);
            this.oQL.setBackground(null);
            this.And.setBackground(null);
        } else if (this.isFirst) {
            this.oQM.setBackgroundResource(R.drawable.a_9);
            this.oQL.setBackgroundResource(R.drawable.cao);
            this.And.setBackgroundResource(R.drawable.b9w);
        } else if (this.ifo) {
            this.oQM.setBackgroundResource(R.drawable.a_9);
            this.oQL.setBackgroundResource(R.drawable.b9w);
            this.And.setBackground(null);
        } else {
            this.oQM.setBackgroundResource(R.drawable.a_9);
            this.oQL.setBackground(null);
            this.And.setBackgroundResource(R.drawable.b9w);
        }
        if (com.tencent.mm.ay.a.bec()) {
            f bef = com.tencent.mm.ay.a.bef();
            this.Ane = bef;
            aIa(MMApplicationContext.getContext().getString(R.string.f7x) + MMApplicationContext.getContext().getString(R.string.f7y) + bef.jeX);
            if (bef.jfr) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            setVisibility(i2);
            this.Ane = null;
            if (!bef.jfr) {
                AppMethodBeat.o(63201);
                return true;
            }
            AppMethodBeat.o(63201);
            return false;
        } else if (com.tencent.mm.ay.a.bed()) {
            setVisibility(0);
            AppMethodBeat.o(63201);
            return true;
        } else {
            setVisibility(8);
            AppMethodBeat.o(63201);
            return false;
        }
    }
}
