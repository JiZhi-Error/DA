package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.luckymoney.model.y;
import java.util.LinkedList;
import java.util.List;

public abstract class f extends BaseAdapter {
    protected Context mContext;
    protected LayoutInflater mInflater;
    protected List<y> yQe = new LinkedList();

    public f(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public final void fq(List<y> list) {
        if (list == null) {
            this.yQe = new LinkedList();
        } else {
            this.yQe = list;
        }
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.yQe.size();
    }

    public final void a(y yVar) {
        this.yQe.remove(yVar);
    }

    /* renamed from: PT */
    public final y getItem(int i2) {
        return this.yQe.get(i2);
    }

    public long getItemId(int i2) {
        return (long) i2;
    }
}
