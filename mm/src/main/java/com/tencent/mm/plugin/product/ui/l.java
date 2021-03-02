package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.product.b.n;
import java.util.List;

public final class l extends BaseAdapter {
    List<n.a> BbL;
    private Context mContext;

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(67043);
        n.a Uy = Uy(i2);
        AppMethodBeat.o(67043);
        return Uy;
    }

    public l(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        AppMethodBeat.i(67040);
        if (this.BbL != null) {
            int size = this.BbL.size();
            AppMethodBeat.o(67040);
            return size;
        }
        AppMethodBeat.o(67040);
        return 0;
    }

    private n.a Uy(int i2) {
        AppMethodBeat.i(67041);
        n.a aVar = this.BbL.get(i2);
        AppMethodBeat.o(67041);
        return aVar;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        m mVar;
        AppMethodBeat.i(67042);
        n.a Uy = Uy(i2);
        if (view == null || view.getTag() == null) {
            m mVar2 = new m();
            view = View.inflate(this.mContext, R.layout.bj_, null);
            mVar2.titleTv = (TextView) view.findViewById(R.id.f9o);
            mVar2.gBZ = (ImageView) view.findViewById(R.id.f9n);
            view.setTag(mVar2);
            mVar = mVar2;
        } else {
            mVar = (m) view.getTag();
        }
        mVar.BbM = Uy;
        mVar.titleTv.setText(Uy.title);
        mVar.gBZ.setImageBitmap(u.a(new c(Uy.iconUrl)));
        u.a(mVar);
        AppMethodBeat.o(67042);
        return view;
    }
}
