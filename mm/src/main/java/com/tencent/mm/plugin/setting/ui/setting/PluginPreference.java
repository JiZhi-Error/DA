package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class PluginPreference extends Preference implements e.a {
    private String Bgn;
    String CZi;
    String CZj;
    private int CZk;
    private int CZl;
    boolean CZm;
    private MMActivity gte;
    private ImageView keC;
    int sUb;

    static /* synthetic */ void a(PluginPreference pluginPreference) {
        AppMethodBeat.i(73918);
        pluginPreference.eNP();
        AppMethodBeat.o(73918);
    }

    public PluginPreference(Context context) {
        this(context, null);
    }

    public PluginPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(73911);
        this.Bgn = "";
        this.CZk = -1;
        this.CZl = 8;
        this.CZm = false;
        this.keC = null;
        this.sUb = 255;
        this.gte = (MMActivity) context;
        setLayoutResource(R.layout.b8j);
        p.aYn().a(this);
        AppMethodBeat.o(73911);
    }

    public final boolean aNc(String str) {
        AppMethodBeat.i(73912);
        as Kn = ((l) g.af(l.class)).aSN().Kn(str);
        if (Kn == null || ((int) Kn.gMZ) == 0) {
            Log.e("MicroMsg.PluginPreference", "plugin do not exist");
            AppMethodBeat.o(73912);
            return false;
        }
        this.CZi = Kn.field_username;
        this.CZj = Kn.arI();
        setKey("settings_plugins_list_#" + this.CZi);
        AppMethodBeat.o(73912);
        return true;
    }

    public final boolean jT(String str, String str2) {
        AppMethodBeat.i(73913);
        this.CZi = str;
        this.CZj = str2;
        setKey("settings_plugins_list_#" + this.CZi);
        AppMethodBeat.o(73913);
        return true;
    }

    private void eNP() {
        AppMethodBeat.i(73914);
        if (this.keC != null) {
            a.b.c(this.keC, this.CZi);
        }
        AppMethodBeat.o(73914);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(73915);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.b9i, viewGroup2);
        AppMethodBeat.o(73915);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(73916);
        super.onBindView(view);
        this.keC = (ImageView) view.findViewById(R.id.dvz);
        this.keC.setAlpha(this.sUb);
        TextView textView = (TextView) view.findViewById(R.id.ikq);
        if (textView != null) {
            textView.setVisibility(this.CZl);
            textView.setText(this.Bgn);
            if (this.CZk != -1) {
                textView.setBackgroundDrawable(com.tencent.mm.cb.a.l(this.gte, this.CZk));
            }
        }
        TextView textView2 = (TextView) view.findViewById(R.id.fvx);
        if (textView2 != null) {
            textView2.setVisibility(this.CZm ? 0 : 8);
        }
        eNP();
        AppMethodBeat.o(73916);
    }

    @Override // com.tencent.mm.aj.e.a
    public final void Mr(String str) {
        AppMethodBeat.i(73917);
        if (this.CZi != null && this.CZi.equals(str)) {
            new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.tencent.mm.plugin.setting.ui.setting.PluginPreference.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(73910);
                    PluginPreference.a(PluginPreference.this);
                    AppMethodBeat.o(73910);
                }
            });
        }
        AppMethodBeat.o(73917);
    }
}
