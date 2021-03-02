package com.tencent.mm.plugin.game.ui.tab;

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
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.model.aj;
import com.tencent.mm.sdk.platformtools.Util;

public final class a extends BaseAdapter {
    private Context mContext;
    private String xXy;
    private GameTabData xYP;

    public a(Context context) {
        this.mContext = context;
    }

    public final void a(GameTabData gameTabData, String str) {
        AppMethodBeat.i(42431);
        this.xYP = gameTabData;
        this.xXy = str;
        notifyDataSetChanged();
        AppMethodBeat.o(42431);
    }

    public final int getCount() {
        AppMethodBeat.i(42432);
        if (this.xYP == null) {
            AppMethodBeat.o(42432);
            return 0;
        }
        int size = this.xYP.avn().size();
        AppMethodBeat.o(42432);
        return size;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(42433);
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.ast, viewGroup, false);
        C1409a aVar = new C1409a(inflate);
        GameTabData.TabItem tabItem = this.xYP.avn().get(i2);
        if (tabItem != null) {
            aVar.hbb.setText(tabItem.title);
            if (Util.nullAsNil(this.xXy).equalsIgnoreCase(tabItem.xHB)) {
                if (!Util.isNullOrNil(tabItem.xHH)) {
                    c.a aVar2 = new c.a();
                    aVar2.jbf = true;
                    aVar2.fullPath = aj.xHL + g.getMessageDigest(tabItem.xHH.getBytes());
                    com.tencent.mm.av.a.a.bdb().a(tabItem.xHH, aVar.kc, aVar2.bdv());
                }
            } else if (!Util.isNullOrNil(tabItem.xHG)) {
                c.a aVar3 = new c.a();
                aVar3.jbf = true;
                aVar3.fullPath = aj.xHL + g.getMessageDigest(tabItem.xHG.getBytes());
                com.tencent.mm.av.a.a.bdb().a(tabItem.xHG, aVar.kc, aVar3.bdv());
            }
        }
        inflate.setTag(tabItem);
        AppMethodBeat.o(42433);
        return inflate;
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.tab.a$a  reason: collision with other inner class name */
    public class C1409a {
        TextView hbb;
        ImageView kc;

        public C1409a(View view) {
            AppMethodBeat.i(42430);
            this.hbb = (TextView) view.findViewById(R.id.abf);
            this.kc = (ImageView) view.findViewById(R.id.abc);
            AppMethodBeat.o(42430);
        }
    }

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(42434);
        GameTabData.TabItem tabItem = this.xYP.avn().get(i2);
        AppMethodBeat.o(42434);
        return tabItem;
    }
}
