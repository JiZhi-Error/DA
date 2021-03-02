package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a;
import java.util.List;

public final class t extends BaseAdapter {
    private List<String> Kgd;
    private List<String> jWf;
    private Context mContext;

    public t(Context context, List<String> list, List<String> list2) {
        this.mContext = context;
        this.jWf = list2;
        this.Kgd = list;
    }

    public final int getCount() {
        AppMethodBeat.i(31423);
        int size = this.jWf.size();
        AppMethodBeat.o(31423);
        return size;
    }

    public final Object getItem(int i2) {
        AppMethodBeat.i(31424);
        String str = this.jWf.get(i2);
        AppMethodBeat.o(31424);
        return str;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(31425);
        if (view == null) {
            view = View.inflate(this.mContext, R.layout.pi, null);
            aVar = gn(view);
        } else {
            a aVar2 = (a) view.getTag();
            if (aVar2 == null) {
                aVar = gn(view);
            } else {
                aVar = aVar2;
            }
        }
        int size = this.jWf.size() % 4;
        if (i2 >= 0 && i2 < this.jWf.size() && i2 < this.Kgd.size()) {
            aVar.gvv.setVisibility(0);
            aVar.kgE.setVisibility(0);
            a.b.c(aVar.gvv, this.Kgd.get(i2));
            aVar.kgE.setText(this.jWf.get(i2));
            aVar.kgE.setText(((com.tencent.mm.plugin.emoji.b.a) g.af(com.tencent.mm.plugin.emoji.b.a.class)).a(this.mContext, this.jWf.get(i2), aVar.kgE.getTextSize()));
            if (this.jWf.size() <= 12 || i2 < this.jWf.size() - size) {
                aVar.kgE.setPadding(0, 0, 0, 0);
            } else {
                aVar.kgE.setPadding(0, 0, 0, com.tencent.mm.cb.a.aG(this.mContext, R.dimen.be));
            }
        }
        AppMethodBeat.o(31425);
        return view;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        public ImageView gvv;
        public TextView kgE;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    private static a gn(View view) {
        AppMethodBeat.i(31426);
        a aVar = new a((byte) 0);
        aVar.gvv = (ImageView) view.findViewById(R.id.ari);
        aVar.kgE = (TextView) view.findViewById(R.id.arl);
        view.setTag(aVar);
        AppMethodBeat.o(31426);
        return aVar;
    }
}
