package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.nearlife.b.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class a extends BaseAdapter {
    protected String AAT = "";
    private ArrayList<b> AAZ = new ArrayList<>();
    private HashSet<String> ABa = new HashSet<>();
    ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> ABb = null;
    private Map<BackwardSupportUtil.ExifHelper.LatLongData, SKBuiltinBuffer_t> ABc;
    private Map<BackwardSupportUtil.ExifHelper.LatLongData, Integer> ABd;
    private Map<String, BackwardSupportUtil.ExifHelper.LatLongData> ABe;
    BackwardSupportUtil.ExifHelper.LatLongData ABf;
    boolean ABg = true;
    int ABh = 0;
    View.OnClickListener dec;
    Context mContext;
    String mKey = "";
    boolean xrR = false;

    public a(Context context, View.OnClickListener onClickListener, String str, boolean z) {
        this.mContext = context;
        this.dec = onClickListener;
        this.mKey = str;
        this.xrR = z;
        this.ABb = new ArrayList<>();
        this.ABc = new HashMap();
        this.ABd = new HashMap();
        this.ABe = new HashMap();
    }

    public final void ewZ() {
        this.AAZ.clear();
        this.ABa.clear();
        this.ABd.clear();
        this.ABc.clear();
        this.ABe.clear();
        this.ABh = 0;
        notifyDataSetChanged();
    }

    public final void a(b bVar, int i2) {
        if (!this.ABa.contains(bVar.AAG) && i2 <= this.AAZ.size()) {
            this.AAZ.add(i2, bVar);
            this.ABa.add(bVar.AAG);
            this.ABe.put(bVar.AAG, this.ABf);
        }
    }

    public final void a(BackwardSupportUtil.ExifHelper.LatLongData latLongData, List<b> list) {
        Log.i("MicroMsg.BaseLifeAdapter", "mkey %s addlifes %d", this.mKey, Integer.valueOf(list.size()));
        for (b bVar : list) {
            if (!this.ABa.contains(bVar.AAG)) {
                this.AAZ.add(bVar);
                this.ABa.add(bVar.AAG);
                this.ABe.put(bVar.AAG, latLongData);
            }
        }
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.AAZ.size();
    }

    /* renamed from: Tv */
    public final b getItem(int i2) {
        if (i2 < 0 || i2 >= this.AAZ.size()) {
            return new b("", new chj());
        }
        return this.AAZ.get(i2);
    }

    public long getItemId(int i2) {
        return 0;
    }

    public static String fF(List<dqi> list) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < list.size(); i2++) {
            dqi dqi = list.get(i2);
            if (dqi != null && dqi.MTo != null && !dqi.MTo.equals("") && !dqi.MTo.toLowerCase().equals(BuildConfig.COMMAND)) {
                stringBuffer.append(dqi.MTo);
                if (i2 < list.size() - 1) {
                    stringBuffer.append("·");
                }
            }
        }
        return stringBuffer.toString();
    }

    public final void aIu(String str) {
        if (str != null) {
            this.AAT = str;
        }
    }

    public final String exa() {
        return this.AAT;
    }

    public final void aF(ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> arrayList) {
        if (arrayList != null) {
            this.ABb = arrayList;
        }
    }

    public final SKBuiltinBuffer_t a(BackwardSupportUtil.ExifHelper.LatLongData latLongData) {
        if (this.ABc.containsKey(latLongData)) {
            return this.ABc.get(latLongData);
        }
        return null;
    }

    public final int b(BackwardSupportUtil.ExifHelper.LatLongData latLongData) {
        if (this.ABd.containsKey(latLongData)) {
            return this.ABd.get(latLongData).intValue();
        }
        return 1;
    }

    public final boolean exb() {
        Iterator<BackwardSupportUtil.ExifHelper.LatLongData> it = this.ABb.iterator();
        while (it.hasNext()) {
            if (b(it.next()) > 0) {
                return true;
            }
        }
        if (this.ABg) {
            return b(this.ABf) > 0;
        }
        return false;
    }

    public final void a(BackwardSupportUtil.ExifHelper.LatLongData latLongData, int i2, SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        int i3 = 0;
        Object[] objArr = new Object[4];
        objArr[0] = Float.valueOf(latLongData.latitude);
        objArr[1] = Float.valueOf(latLongData.longtitude);
        objArr[2] = Integer.valueOf(i2);
        if (sKBuiltinBuffer_t != null) {
            i3 = sKBuiltinBuffer_t.getILen();
        }
        objArr[3] = Integer.valueOf(i3);
        Log.d("MicroMsg.BaseLifeAdapter", "set flag & buf, lat:%f long:%f flag:%d len:%d", objArr);
        if (this.ABb.contains(latLongData) || (this.ABf != null && this.ABf.equals(latLongData))) {
            this.ABd.put(latLongData, Integer.valueOf(i2));
            this.ABc.put(latLongData, sKBuiltinBuffer_t);
        }
    }

    public final BackwardSupportUtil.ExifHelper.LatLongData aIv(String str) {
        if (this.ABe.containsKey(str)) {
            return this.ABe.get(str);
        }
        return null;
    }

    public final boolean aIw(String str) {
        String trim = str.trim();
        Iterator<b> it = this.AAZ.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (!Util.isNullOrNil(next.Title) && trim.equals(next.Title.trim())) {
                return true;
            }
        }
        return false;
    }

    public final int aIx(String str) {
        Iterator<b> it = this.AAZ.iterator();
        int i2 = -1;
        while (it.hasNext()) {
            i2++;
            if (it.next().AAG.equals(str)) {
                break;
            }
        }
        return i2;
    }
}
