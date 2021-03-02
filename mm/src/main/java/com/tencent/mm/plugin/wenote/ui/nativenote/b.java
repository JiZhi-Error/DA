package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;

public final class b extends com.tencent.mm.pluginsdk.ui.b.b {
    private View oQL;
    private View oQM;
    private TextView titleTv = null;

    public b(Context context) {
        super(context);
        AppMethodBeat.i(30810);
        if (this.view != null) {
            this.titleTv = (TextView) this.view.findViewById(R.id.jn0);
            this.oQL = this.view.findViewById(R.id.jn1);
            this.oQM = this.view.findViewById(R.id.a29);
            this.titleTv.setTextSize(0, (float) a.aG(this.titleTv.getContext(), R.dimen.hc));
            this.view.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wenote.ui.nativenote.b.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(30809);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("WNNoteBanner", "click WNNoteBanner");
                    q gjP = h.gjO().gjP();
                    if (gjP == null) {
                        Log.i("WNNoteBanner", "keepTopItem is null");
                        b.this.setVisibility(8);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(30809);
                        return;
                    }
                    com.tencent.mm.plugin.wenote.b.a.a(gjP);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(30809);
                }
            });
        }
        AppMethodBeat.o(30810);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final int getLayoutId() {
        return R.layout.cc_;
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final int getOrder() {
        return 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void destroy() {
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void setVisibility(int i2) {
        AppMethodBeat.i(30811);
        if (this.view != null) {
            this.view.findViewById(R.id.jn1).setVisibility(i2);
        }
        AppMethodBeat.o(30811);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final boolean bYa() {
        boolean z;
        AppMethodBeat.i(30812);
        try {
            if (h.gjO().gjP() != null) {
                long currentTimeMillis = System.currentTimeMillis();
                bg.aVF();
                if (currentTimeMillis - ((Long) c.azQ().get(ar.a.USERINFO_WENOTE_KEEP_TOP_DATA_LAST_REPORT_TIME_LONG_SYNC, (Object) 0L)).longValue() > Util.MILLSECONDS_OF_DAY) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(18728, 1);
                    bg.aVF();
                    c.azQ().set(ar.a.USERINFO_WENOTE_KEEP_TOP_DATA_LAST_REPORT_TIME_LONG_SYNC, Long.valueOf(currentTimeMillis));
                }
            }
        } catch (Throwable th) {
        }
        q gjP = h.gjO().gjP();
        if (this.isFirst && this.ifo) {
            this.oQM.setBackgroundResource(R.drawable.azq);
            this.oQL.setBackground(null);
            this.titleTv.setBackground(null);
        } else if (this.isFirst) {
            this.oQM.setBackgroundResource(R.drawable.a_9);
            this.oQL.setBackgroundResource(R.drawable.cao);
            this.titleTv.setBackgroundResource(R.drawable.b9w);
        } else if (this.ifo) {
            this.oQM.setBackgroundResource(R.drawable.a_9);
            this.oQL.setBackgroundResource(R.drawable.b9w);
            this.titleTv.setBackground(null);
        } else {
            this.oQM.setBackgroundResource(R.drawable.a_9);
            this.oQL.setBackground(null);
            this.titleTv.setBackgroundResource(R.drawable.b9w);
        }
        if (gjP != null && gjP.JHR && gjP.JHT > 0 && !Util.isNullOrNil(gjP.JHV)) {
            z = true;
        } else if (gjP == null || gjP.JHR || f.HT(gjP.JHS) == null) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            String str = gjP.JHU;
            if (this.titleTv != null) {
                this.titleTv.setText(str);
            }
            setVisibility(0);
            AppMethodBeat.o(30812);
            return true;
        }
        if (gjP != null) {
            h.gjO().c(null);
        }
        setVisibility(8);
        AppMethodBeat.o(30812);
        return false;
    }
}
