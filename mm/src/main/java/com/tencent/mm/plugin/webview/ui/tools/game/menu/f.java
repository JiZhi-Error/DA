package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;

public final class f extends BaseAdapter {
    private static final String xEu = (b.aKJ() + "Game/HvMenu/");
    m HMc;
    private Context mContext;

    static {
        AppMethodBeat.i(81003);
        AppMethodBeat.o(81003);
    }

    public f(Context context) {
        this.mContext = context;
    }

    public final void a(m mVar) {
        AppMethodBeat.i(80999);
        this.HMc = mVar;
        notifyDataSetChanged();
        AppMethodBeat.o(80999);
    }

    public final int getCount() {
        AppMethodBeat.i(81000);
        if (this.HMc == null) {
            AppMethodBeat.o(81000);
            return 0;
        }
        int size = this.HMc.size();
        AppMethodBeat.o(81000);
        return size;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(81001);
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.arj, viewGroup, false);
        a aVar = new a(inflate);
        n nVar = (n) this.HMc.ORD.get(i2);
        if (!(nVar == null || nVar.getItemId() == -1)) {
            String charSequence = nVar.getTitle().toString();
            if (!Util.isNullOrNil(charSequence)) {
                String[] split = charSequence.split("__", 2);
                if (split.length == 1) {
                    aVar.hbb.setText(split[0]);
                } else {
                    aVar.hbb.setText(split[0]);
                    String str = split[1];
                    if (str.startsWith("http")) {
                        c.a aVar2 = new c.a();
                        aVar2.jbf = true;
                        aVar2.fullPath = xEu + g.getMessageDigest(str.getBytes());
                        com.tencent.mm.av.a.a.bdb().a(str, aVar.kc, aVar2.bdv());
                    } else {
                        aVar.kc.setImageResource(MMApplicationContext.getResources().getIdentifier(str, "drawable", MMApplicationContext.getPackageName()));
                    }
                }
                inflate.setTag(nVar);
                AppMethodBeat.o(81001);
                return inflate;
            }
        }
        inflate.setTag(null);
        AppMethodBeat.o(81001);
        return inflate;
    }

    public class a {
        TextView hbb;
        ImageView kc;

        public a(View view) {
            AppMethodBeat.i(80998);
            this.hbb = (TextView) view.findViewById(R.id.ipm);
            this.kc = (ImageView) view.findViewById(R.id.dt5);
            AppMethodBeat.o(80998);
        }
    }

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(81002);
        n nVar = (n) this.HMc.ORD.get(i2);
        AppMethodBeat.o(81002);
        return nVar;
    }
}
