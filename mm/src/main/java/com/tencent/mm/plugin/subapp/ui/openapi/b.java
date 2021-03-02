package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.List;

public final class b extends BaseAdapter implements MStorage.IOnStorageChange {
    private List<g> Dcn;
    boolean FMo = false;
    private Context context;

    public b(Context context2, List<g> list) {
        this.context = context2;
        this.Dcn = list;
    }

    public final void we(boolean z) {
        AppMethodBeat.i(29157);
        this.FMo = z;
        notifyDataSetChanged();
        AppMethodBeat.o(29157);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        c cVar;
        AppMethodBeat.i(29158);
        if (view == null) {
            cVar = new c();
            view = View.inflate(this.context, R.layout.gd, null);
            cVar.gBZ = (ImageView) view.findViewById(R.id.tl);
            cVar.FMJ = (TextView) view.findViewById(R.id.tk);
            cVar.gxs = (TextView) view.findViewById(R.id.tm);
            cVar.FMK = view.findViewById(R.id.tn);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        cVar.FMK.setVisibility(4);
        if (Ox(i2)) {
            cVar.gBZ.setVisibility(4);
            cVar.FMJ.setVisibility(4);
            cVar.gxs.setVisibility(4);
            AppMethodBeat.o(29158);
        } else {
            g gVar = (g) getItem(i2);
            cVar.gBZ.setVisibility(0);
            Bitmap c2 = h.c(gVar.field_appId, 5, a.getDensity(this.context));
            if (c2 == null) {
                cVar.gBZ.setBackgroundResource(R.drawable.ba4);
            } else {
                cVar.gBZ.setBackgroundDrawable(new BitmapDrawable(c2));
            }
            cVar.gxs.setVisibility(0);
            cVar.gxs.setText(h.a(this.context, gVar, (String) null));
            if (this.FMo) {
                cVar.FMJ.setVisibility(0);
            } else {
                cVar.FMJ.setVisibility(8);
            }
            AppMethodBeat.o(29158);
        }
        return view;
    }

    public final int getCount() {
        AppMethodBeat.i(29159);
        int realCount = getRealCount() + dWu();
        AppMethodBeat.o(29159);
        return realCount;
    }

    public final boolean Ox(int i2) {
        AppMethodBeat.i(29160);
        int size = this.Dcn.size();
        if (i2 < size || i2 >= size + dWu()) {
            AppMethodBeat.o(29160);
            return false;
        }
        AppMethodBeat.o(29160);
        return true;
    }

    public final Object getItem(int i2) {
        AppMethodBeat.i(29161);
        if (Ox(i2)) {
            AppMethodBeat.o(29161);
            return null;
        }
        g gVar = this.Dcn.get(i2);
        AppMethodBeat.o(29161);
        return gVar;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    private int getRealCount() {
        AppMethodBeat.i(29162);
        int size = this.Dcn.size();
        AppMethodBeat.o(29162);
        return size;
    }

    private int dWu() {
        AppMethodBeat.i(29163);
        int realCount = (4 - (getRealCount() % 4)) % 4;
        AppMethodBeat.o(29163);
        return realCount;
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(29164);
        notifyDataSetChanged();
        AppMethodBeat.o(29164);
    }
}
