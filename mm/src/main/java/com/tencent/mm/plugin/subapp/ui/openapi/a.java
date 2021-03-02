package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.ArrayList;
import java.util.List;

public final class a extends BaseAdapter implements MStorage.IOnStorageChange {
    private List<g> Dcn;
    boolean FMo = false;
    private int FMp = 0;
    private Context context;

    public a(Context context2, int i2) {
        AppMethodBeat.i(29123);
        this.context = context2;
        this.FMp = i2;
        init();
        AppMethodBeat.o(29123);
    }

    private void init() {
        AppMethodBeat.i(29124);
        this.Dcn = new ArrayList();
        Cursor rawQuery = ao.eAS().rawQuery("select * from AppInfo where status = " + this.FMp + " and (appType is null or appType not like ',1,')", new String[0]);
        if (rawQuery == null) {
            Log.e("MicroMsg.AppInfoStorage", "getAppByStatusExcludeByType: curosr is null");
            rawQuery = null;
        }
        if (rawQuery != null) {
            int count = rawQuery.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                rawQuery.moveToPosition(i2);
                g gVar = new g();
                gVar.convertFrom(rawQuery);
                if (h.s(this.context, gVar.field_appId)) {
                    this.Dcn.add(gVar);
                }
            }
            rawQuery.close();
        }
        AppMethodBeat.o(29124);
    }

    public final void we(boolean z) {
        AppMethodBeat.i(29125);
        this.FMo = z;
        notifyDataSetChanged();
        AppMethodBeat.o(29125);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        d dVar;
        AppMethodBeat.i(29126);
        if (view == null) {
            dVar = new d();
            view = View.inflate(this.context, R.layout.gd, null);
            dVar.gBZ = (ImageView) view.findViewById(R.id.tl);
            dVar.FMJ = (TextView) view.findViewById(R.id.tk);
            dVar.gxs = (TextView) view.findViewById(R.id.tm);
            dVar.FMK = view.findViewById(R.id.tn);
            view.setTag(dVar);
        } else {
            dVar = (d) view.getTag();
        }
        dVar.FMK.setVisibility(4);
        if (Ox(i2)) {
            dVar.gBZ.setVisibility(4);
            dVar.FMJ.setVisibility(4);
            dVar.gxs.setVisibility(4);
            AppMethodBeat.o(29126);
        } else {
            g gVar = (g) getItem(i2);
            dVar.gBZ.setVisibility(0);
            Bitmap c2 = h.c(gVar.field_appId, 1, com.tencent.mm.cb.a.getDensity(this.context));
            if (c2 == null) {
                dVar.gBZ.setBackgroundResource(R.drawable.ba4);
            } else {
                dVar.gBZ.setBackgroundDrawable(new BitmapDrawable(c2));
            }
            dVar.gxs.setVisibility(0);
            dVar.gxs.setText(h.a(this.context, gVar, (String) null));
            if (this.FMo) {
                dVar.FMJ.setVisibility(0);
            } else {
                dVar.FMJ.setVisibility(8);
            }
            AppMethodBeat.o(29126);
        }
        return view;
    }

    public final int getCount() {
        AppMethodBeat.i(29127);
        int realCount = getRealCount() + dWu();
        AppMethodBeat.o(29127);
        return realCount;
    }

    public final boolean Ox(int i2) {
        AppMethodBeat.i(29128);
        int size = this.Dcn.size();
        if (i2 < size || i2 >= size + dWu()) {
            AppMethodBeat.o(29128);
            return false;
        }
        AppMethodBeat.o(29128);
        return true;
    }

    public final Object getItem(int i2) {
        AppMethodBeat.i(29129);
        if (Ox(i2)) {
            AppMethodBeat.o(29129);
            return null;
        }
        g gVar = this.Dcn.get(i2);
        AppMethodBeat.o(29129);
        return gVar;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    private int getRealCount() {
        AppMethodBeat.i(29130);
        int size = this.Dcn.size();
        AppMethodBeat.o(29130);
        return size;
    }

    private int dWu() {
        AppMethodBeat.i(29131);
        int realCount = (4 - (getRealCount() % 4)) % 4;
        AppMethodBeat.o(29131);
        return realCount;
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(29132);
        init();
        super.notifyDataSetChanged();
        AppMethodBeat.o(29132);
    }
}
