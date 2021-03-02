package com.tencent.mm.ui.base;

import android.content.Context;
import android.support.v4.view.q;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.Queue;

public abstract class d extends q {
    private Queue<View> ONZ;
    private int OOa = 0;
    public Context context;

    public abstract void Te(int i2);

    public abstract View a(View view, ViewGroup viewGroup, int i2);

    public abstract int evg();

    public d(Context context2) {
        this.context = context2;
        this.ONZ = new LinkedList();
    }

    @Override // android.support.v4.view.q
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.q
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        View a2 = a(this.ONZ.poll(), viewGroup, i2);
        if (a2.getLayoutParams() == null) {
            a2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        viewGroup.addView(a2);
        Log.v("MicroMsg.CustomPagerAdapter", "instantiateItem usetime: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return a2;
    }

    @Override // android.support.v4.view.q
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        View view = (View) obj;
        viewGroup.removeView(view);
        this.ONZ.add(view);
        Te(i2);
        Log.d("MicroMsg.CustomPagerAdapter", "recycle queue size %d", Integer.valueOf(this.ONZ.size()));
    }

    @Override // android.support.v4.view.q
    public void notifyDataSetChanged() {
        this.OOa = evg();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.q
    public int getItemPosition(Object obj) {
        if (this.OOa <= 0) {
            return super.getItemPosition(obj);
        }
        this.OOa--;
        return -2;
    }
}
