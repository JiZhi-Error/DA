package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.Preference;

public final class c extends Preference {
    String goe = null;
    private Context mContext = null;
    private TextView mPa = null;
    String mTitle = null;
    private View mView = null;
    private ImageView qyu = null;

    public c(Context context) {
        super(context);
        AppMethodBeat.i(64187);
        this.mContext = context;
        setLayoutResource(R.layout.vd);
        AppMethodBeat.o(64187);
    }

    public c(Context context, byte b2) {
        super(context);
        AppMethodBeat.i(64188);
        this.mContext = context;
        setLayoutResource(R.layout.vc);
        AppMethodBeat.o(64188);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(64189);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(64189);
        return view2;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(64190);
        super.onBindView(view);
        this.mPa = (TextView) view.findViewById(16908310);
        this.qyu = (ImageView) view.findViewById(R.id.b7n);
        this.mPa.setText(l.b(this.mContext, this.mTitle, this.mPa.getTextSize()));
        if (!Util.isNullOrNil(this.goe)) {
            this.qyu.setVisibility(0);
            g.aAi();
            as bjK = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjK(this.goe);
            if (bjK == null || ((int) bjK.gMZ) <= 0) {
                Log.d("MicroMsg.CollectPayInfoPreference", "Receiver in contactStg and try to get contact");
                final long nowMilliSecond = Util.nowMilliSecond();
                ay.a.iDq.a(this.goe, "", new ay.b.a() {
                    /* class com.tencent.mm.plugin.collect.ui.c.AnonymousClass1 */

                    @Override // com.tencent.mm.model.ay.b.a
                    public final void p(String str, boolean z) {
                        AppMethodBeat.i(64186);
                        if (z) {
                            Log.v("MicroMsg.CollectPayInfoPreference", "getContact suc; cost=" + (Util.nowMilliSecond() - nowMilliSecond) + " ms");
                            com.tencent.mm.aj.c.ap(str, 3);
                            p.aYD().Mg(str);
                        } else {
                            Log.w("MicroMsg.CollectPayInfoPreference", "getContact failed");
                        }
                        a.b.c(c.this.qyu, c.this.goe);
                        AppMethodBeat.o(64186);
                    }
                });
                AppMethodBeat.o(64190);
                return;
            }
            a.b.c(this.qyu, this.goe);
            AppMethodBeat.o(64190);
            return;
        }
        this.qyu.setVisibility(8);
        AppMethodBeat.o(64190);
    }
}
