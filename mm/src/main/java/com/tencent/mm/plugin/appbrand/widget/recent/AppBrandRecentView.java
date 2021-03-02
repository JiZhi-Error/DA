package com.tencent.mm.plugin.appbrand.widget.recent;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recent.l;
import java.util.List;

public abstract class AppBrandRecentView extends RecyclerView {
    private e oBW;
    l.a oBX;

    public interface a<T> {
    }

    public interface b {
        boolean a(View view, e eVar, float f2, float f3);

        boolean b(View view, e eVar, float f2, float f3);
    }

    public interface c<T> {
        List<T> AC(int i2);
    }

    public interface d {
    }

    public interface e {
        void yL(int i2);
    }

    @Override // android.support.v7.widget.RecyclerView
    public abstract RecyclerView.a getAdapter();

    public abstract int getCount();

    public abstract b getOnItemClickListener();

    public abstract void refresh();

    public abstract void release();

    public abstract void setDataQuery(c cVar);

    public abstract void setOnItemClickListener(b bVar);

    public AppBrandRecentView(Context context) {
        super(context);
    }

    public AppBrandRecentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setSceneFactory(l.a aVar) {
        this.oBX = aVar;
    }

    public l.a getSceneFactory() {
        return this.oBX;
    }

    public void setRefreshListener(e eVar) {
        this.oBW = eVar;
    }

    public e getRefreshListener() {
        return this.oBW;
    }

    public enum f {
        RECENT_APP_BRAND,
        MY_APP_BRAND;

        public static f valueOf(String str) {
            AppMethodBeat.i(194386);
            f fVar = (f) Enum.valueOf(f.class, str);
            AppMethodBeat.o(194386);
            return fVar;
        }

        static {
            AppMethodBeat.i(194387);
            AppMethodBeat.o(194387);
        }
    }
}
