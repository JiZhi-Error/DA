package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
public final class b extends BaseAdapter {
    private List<z> PdW;
    boolean PdX = false;
    private Context context;
    private c rFu;

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(34227);
        z alZ = alZ(i2);
        AppMethodBeat.o(34227);
        return alZ;
    }

    public b(Context context2) {
        AppMethodBeat.i(34220);
        this.context = context2;
        this.PdW = new ArrayList();
        c.a aVar = new c.a();
        aVar.jbq = R.drawable.biz;
        this.rFu = aVar.bdv();
        ad(null);
        AppMethodBeat.o(34220);
    }

    public final void ad(List<z> list) {
        AppMethodBeat.i(34221);
        this.PdW.clear();
        if (!(list == null || list.size() == 0)) {
            this.PdW.addAll(list);
        }
        if (this.PdX) {
            this.PdW.add(gMN());
        }
        this.PdW.add(gMM());
        Log.d("MicroMsg.AppInfoListAdapter", "updateData mDeviceInfoList.size() = %d.", Integer.valueOf(this.PdW.size()));
        AppMethodBeat.o(34221);
    }

    private z gMM() {
        AppMethodBeat.i(34222);
        z zVar = new z();
        zVar.resId = R.drawable.cmw;
        zVar.gCv = this.context.getString(R.string.gvb);
        AppMethodBeat.o(34222);
        return zVar;
    }

    private z gMN() {
        AppMethodBeat.i(34223);
        z zVar = new z();
        zVar.resId = R.drawable.cmx;
        zVar.gCv = this.context.getString(R.string.b2o);
        AppMethodBeat.o(34223);
        return zVar;
    }

    public final int getCount() {
        AppMethodBeat.i(34224);
        int size = this.PdW.size();
        AppMethodBeat.o(34224);
        return size;
    }

    private z alZ(int i2) {
        AppMethodBeat.i(34225);
        z zVar = this.PdW.get(i2);
        AppMethodBeat.o(34225);
        return zVar;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        as asVar;
        AppMethodBeat.i(34226);
        z alZ = alZ(i2);
        if (view == null) {
            as asVar2 = new as();
            view = View.inflate(viewGroup.getContext(), R.layout.bq8, null);
            asVar2.rII = view.findViewById(R.id.be3);
            asVar2.kgE = (TextView) view.findViewById(R.id.ft9);
            asVar2.nnL = (ImageView) view.findViewById(R.id.dtb);
            asVar2.Pjb = (TextView) view.findViewById(R.id.hjx);
            asVar2.Plh = (SendDataToDeviceProgressBar) view.findViewById(R.id.hjw);
            asVar2.Plh.setVisibility(4);
            view.setTag(asVar2);
            asVar = asVar2;
        } else {
            asVar = (as) view.getTag();
        }
        asVar.kgE.setText(alZ.gCv);
        Log.v("MicroMsg.AppInfoListAdapter", "position(%s), name(%s).", Integer.valueOf(i2), alZ.gCv);
        if (alZ.resId != 0) {
            asVar.nnL.setImageResource(alZ.resId);
        } else {
            Bitmap c2 = h.c(alZ.appId, 1, a.getDensity(this.context));
            if (c2 == null || c2.isRecycled()) {
                q.bcV().a(alZ.iconUrl, asVar.nnL, this.rFu);
            } else {
                asVar.nnL.setImageBitmap(c2);
            }
        }
        asVar.rII.setTag(Integer.valueOf(i2));
        AppMethodBeat.o(34226);
        return view;
    }
}
