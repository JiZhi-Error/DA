package com.tencent.mm.plugin.fav.ui.a;

import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.fav.a.w;
import java.util.Set;

public abstract class a extends BaseAdapter implements AdapterView.OnItemClickListener {
    protected long lastUpdateTime;
    protected Set<Integer> thd;
    protected w the;
    protected AbstractC1046a thf;
    protected int type;

    /* renamed from: com.tencent.mm.plugin.fav.ui.a.a$a  reason: collision with other inner class name */
    public interface AbstractC1046a {
        void cWe();
    }

    public abstract void boE();

    public abstract void cWm();

    public abstract boolean isEmpty();

    public final int getType() {
        return this.type;
    }

    public final long cWk() {
        return this.lastUpdateTime;
    }

    public final void a(AbstractC1046a aVar) {
        this.thf = aVar;
    }

    public final void cWl() {
        if (this.thf != null) {
            this.thf.cWe();
        }
    }

    public final void k(Set<Integer> set) {
        this.thd = set;
    }

    public final void a(w wVar) {
        this.the = wVar;
    }
}
