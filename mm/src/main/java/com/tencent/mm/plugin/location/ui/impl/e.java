package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.map.geolocation.sapp.TencentLocationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;

public final class e extends BaseAdapter {
    byte[] buffer = null;
    private Context context;
    boolean daZ = false;
    boolean idt = false;
    String key = "";
    boolean khr = false;
    String qLO = "";
    int va = 0;
    private double yIm;
    private double yIn;
    List<f> yMH = new ArrayList();
    private String yMI;
    private String yMJ;

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(56097);
        f Pz = Pz(i2);
        AppMethodBeat.o(56097);
        return Pz;
    }

    public e(Context context2) {
        AppMethodBeat.i(56089);
        this.context = context2;
        AppMethodBeat.o(56089);
    }

    public final void clean() {
        AppMethodBeat.i(56090);
        this.buffer = null;
        this.idt = false;
        this.key = "";
        this.yMH.clear();
        this.va = -1;
        AppMethodBeat.o(56090);
    }

    public final void edW() {
        this.buffer = null;
        this.idt = false;
        this.key = "";
    }

    public final void aDj(String str) {
        AppMethodBeat.i(56091);
        this.key = str;
        Log.i("MicroMsg.PoiAdapter", "initData key %s.", str);
        AppMethodBeat.o(56091);
    }

    public final void a(List<f> list, byte[] bArr, boolean z, String str) {
        AppMethodBeat.i(56092);
        if (this.key == null || !this.key.equals(str)) {
            Log.i("MicroMsg.PoiAdapter", "old key, dismiss it %s %s.", this.key, str);
            AppMethodBeat.o(56092);
            return;
        }
        int size = this.yMH.size();
        int i2 = size;
        for (f fVar : list) {
            fVar.yMZ = i2;
            i2++;
            this.yMH.add(fVar);
        }
        this.buffer = bArr;
        this.idt = z;
        notifyDataSetChanged();
        AppMethodBeat.o(56092);
    }

    public final int getCount() {
        AppMethodBeat.i(56093);
        int size = this.yMH.size();
        AppMethodBeat.o(56093);
        return size;
    }

    public final f Pz(int i2) {
        AppMethodBeat.i(56094);
        f fVar = this.yMH.get(i2);
        AppMethodBeat.o(56094);
        return fVar;
    }

    public final long getItemId(int i2) {
        return 0;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        Spannable spannable;
        Spannable spannable2;
        String str;
        AppMethodBeat.i(56095);
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.layout.bid, viewGroup, false);
            a aVar2 = new a();
            aVar2.yMK = view.findViewById(R.id.gdr);
            aVar2.titleView = (TextView) view.findViewById(R.id.gdt);
            aVar2.yMM = (TextView) view.findViewById(R.id.gds);
            aVar2.yML = view.findViewById(R.id.gdv);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        f fVar = this.yMH.get(i2);
        if (1 == fVar.type || 2 == fVar.type) {
            aVar.titleView.setText(Util.nullAs(fVar.yMN, ""));
            aVar.yMM.setVisibility(8);
        } else {
            aVar.yMM.setVisibility(0);
        }
        String string = Util.isNullOrNil(fVar.mName) ? this.context.getResources().getString(R.string.ekf) : fVar.mName;
        String str2 = "";
        if (Util.isNullOrNil(this.yMI) || !Util.nullAs(fVar.yMR, "").equals(this.yMI)) {
            str2 = Util.nullAs(fVar.yMR, "") + Util.nullAs(fVar.yMS, "");
        } else if (!Util.isNullOrNil(this.yMJ) && !Util.nullAs(fVar.yMS, "").equals(this.yMJ)) {
            str2 = Util.nullAs(fVar.yMS, "");
        }
        String str3 = (str2 + Util.nullAs(fVar.yMT, "")) + Util.nullAs(fVar.yMV, "");
        if (Util.isNullOrNil(str3)) {
            str3 = Util.nullAs(fVar.yMN, "");
        }
        if (!this.khr || Util.isNullOrNil(this.qLO)) {
            spannable = str3;
            spannable2 = string;
        } else {
            Spannable aDk = aDk(string);
            spannable = aDk(str3);
            spannable2 = aDk;
        }
        aVar.titleView.setText(spannable2);
        TextView textView = aVar.yMM;
        double d2 = fVar.cik;
        double d3 = fVar.cil;
        int distanceBetween = (int) TencentLocationUtils.distanceBetween(this.yIm, this.yIn, d2, d3);
        Log.d("MicroMsg.PoiAdapter", "mLat %s mLng %s lat %s lng %s dis %s.", Double.valueOf(this.yIm), Double.valueOf(this.yIn), Double.valueOf(d2), Double.valueOf(d3), Integer.valueOf(distanceBetween));
        if (distanceBetween < 100) {
            str = "100m内";
        } else if (distanceBetween >= 1000) {
            str = Util.safeFormatString("%.1fkm", Double.valueOf(((double) distanceBetween) / 1000.0d));
        } else {
            str = distanceBetween + "m";
        }
        if (!Util.isNullOrNil(spannable)) {
            str = str + APLogFileUtil.SEPARATOR_LOG + ((Object) spannable);
        }
        textView.setText(str);
        if (i2 == this.va) {
            aVar.yML.setVisibility(0);
        } else {
            aVar.yML.setVisibility(4);
        }
        AppMethodBeat.o(56095);
        return view;
    }

    private Spannable aDk(String str) {
        AppMethodBeat.i(56096);
        Spannable b2 = f.b(str, this.qLO);
        AppMethodBeat.o(56096);
        return b2;
    }

    public final void m(double d2, double d3) {
        this.yIm = d2;
        this.yIn = d3;
    }

    public final void iy(String str, String str2) {
        this.yMI = str;
        this.yMJ = str2;
    }

    static class a {
        TextView titleView;
        View yMK;
        View yML;
        TextView yMM;

        a() {
        }
    }
}
