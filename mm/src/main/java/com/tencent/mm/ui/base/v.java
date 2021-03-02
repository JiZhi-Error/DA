package com.tencent.mm.ui.base;

import android.support.v4.view.q;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public abstract class v extends q {
    public SparseArray<Object> OUA = new SparseArray<>();
    public Queue<View> OUy = new LinkedList();
    public HashMap<Object, Integer> OUz = new HashMap<>();

    public abstract MultiTouchImageView NQ(int i2);

    public abstract WxImageView NR(int i2);

    public abstract Object h(int i2, View view);

    @Override // android.support.v4.view.q
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        View view = null;
        if (this.OUy.size() > 0) {
            view = this.OUy.poll();
        }
        Object h2 = h(i2, view);
        Log.i("MicroMsg.MMViewPagerAdapter", "instantiateItem object %s, parent %s, position: %s.", Integer.valueOf(h2.hashCode()), ((View) h2).getParent(), Integer.valueOf(i2));
        this.OUz.put(h2, Integer.valueOf(i2));
        this.OUA.put(i2, h2);
        if (((View) h2).getParent() == null) {
            viewGroup.addView((View) h2);
        }
        Log.i("MicroMsg.MMViewPagerAdapter", "instantiateItem spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return h2;
    }

    @Override // android.support.v4.view.q
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Log.d("MicroMsg.MMViewPagerAdapter", "destroyItem position %s", Integer.valueOf(i2));
        Log.i("MicroMsg.MMViewPagerAdapter", "destroyItem object %s", Integer.valueOf(obj.hashCode()));
        this.OUy.add((View) obj);
        this.OUz.remove(obj);
        this.OUA.remove(i2);
    }

    @Override // android.support.v4.view.q
    public int getItemPosition(Object obj) {
        if (this.OUz.containsKey(obj)) {
            return this.OUz.get(obj).intValue();
        }
        return -2;
    }

    @Override // android.support.v4.view.q
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public final View abm(int i2) {
        Object obj = this.OUA.get(i2);
        if (obj != null) {
            return (View) obj;
        }
        return null;
    }

    public final void reset() {
        this.OUy.clear();
        this.OUz.clear();
        this.OUA.clear();
    }

    public int firstItemPosForDetermine() {
        return -1;
    }

    public int lastItemPosForDetermine() {
        return -1;
    }

    public void detach() {
        reset();
    }
}
