package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.widget.BaseAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class a extends BaseAdapter implements d {
    private int Fby = 0;
    HashMap<Object, Integer> Fbz = new HashMap<>();

    public final boolean hasStableIds() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final void dT(Object obj) {
        HashMap<Object, Integer> hashMap = this.Fbz;
        int i2 = this.Fby;
        this.Fby = i2 + 1;
        hashMap.put(obj, Integer.valueOf(i2));
    }

    /* access modifiers changed from: protected */
    public final void hk(List<?> list) {
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            dT(it.next());
        }
    }

    public final long getItemId(int i2) {
        if (i2 < 0 || i2 >= this.Fbz.size()) {
            return -1;
        }
        return (long) this.Fbz.get(getItem(i2)).intValue();
    }
}
