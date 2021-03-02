package com.tencent.mm.plugin.expt.hellhound.a.a.a;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public final class a implements b {
    private WeakReference<RecyclerView> sCb;
    private Field sCc;
    private Field sCd;
    private Field sCe;
    private Method sCf;
    private Method sCg;
    private Method sCh;
    private Method sCi;
    private Method sCj;

    public a() {
        AppMethodBeat.i(169309);
        Log.w("HABBYGE-MALI.FinderFeedParamsCatcher", "FinderFeedParamsCatcher");
        try {
            this.sCc = Class.forName("com.tencent.mm.view.recyclerview.WxRecyclerAdapter").getDeclaredField("data");
            this.sCc.setAccessible(true);
            this.sCd = Class.forName("com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter").getDeclaredField("feed");
            this.sCd.setAccessible(true);
            this.sCe = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed").getDeclaredField("feedObject");
            this.sCe.setAccessible(true);
            Class<?> cls = Class.forName("com.tencent.mm.plugin.finder.storage.FeedData");
            this.sCf = cls.getDeclaredMethod("getId", new Class[0]);
            this.sCf.setAccessible(true);
            this.sCg = cls.getDeclaredMethod("getUserName", new Class[0]);
            this.sCg.setAccessible(true);
            this.sCh = cls.getDeclaredMethod("getNickName", new Class[0]);
            this.sCh.setAccessible(true);
            this.sCi = cls.getDeclaredMethod("getLikeCount", new Class[0]);
            this.sCi.setAccessible(true);
            this.sCj = cls.getDeclaredMethod("getCommentCount", new Class[0]);
            this.sCj.setAccessible(true);
            AppMethodBeat.o(169309);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.FinderFeedParamsCatcher", e2, "reflect crash: %s", e2.getMessage());
            AppMethodBeat.o(169309);
        }
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    public final void setRecyclerView(RecyclerView recyclerView) {
        AppMethodBeat.i(186068);
        this.sCb = new WeakReference<>(recyclerView);
        AppMethodBeat.o(186068);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    public final String ac(View view, int i2) {
        AppMethodBeat.i(169310);
        if (this.sCb == null) {
            Log.e("HABBYGE-MALI.FinderFeedParamsCatcher", "getFeedId, mRecyclerView == NULL !?");
            AppMethodBeat.o(169310);
            return null;
        }
        RecyclerView recyclerView = this.sCb.get();
        if (recyclerView == null) {
            AppMethodBeat.o(169310);
            return null;
        }
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter == null) {
            Log.e("HABBYGE-MALI.FinderFeedParamsCatcher", "getFeedId, RecyclerView.Adapter == NULL !?");
            AppMethodBeat.o(169310);
            return null;
        }
        String a2 = a(adapter, i2);
        AppMethodBeat.o(169310);
        return a2;
    }

    private String a(RecyclerView.a aVar, int i2) {
        AppMethodBeat.i(169311);
        try {
            Object obj = this.sCd.get(aVar);
            if (obj == null) {
                AppMethodBeat.o(169311);
                return null;
            }
            String zs = b.zs(((Long) this.sCf.invoke(obj, new Object[0])).longValue());
            AppMethodBeat.o(169311);
            return zs;
        } catch (Exception e2) {
            try {
                Object obj2 = this.sCc.get(aVar);
                if (obj2 == null) {
                    AppMethodBeat.o(169311);
                    return null;
                }
                ArrayList arrayList = (ArrayList) obj2;
                if (arrayList.isEmpty() || i2 < 0 || i2 >= arrayList.size()) {
                    AppMethodBeat.o(169311);
                    return null;
                }
                Object obj3 = arrayList.get(i2);
                if (obj3 == null) {
                    AppMethodBeat.o(169311);
                    return null;
                }
                String zs2 = b.zs(((Long) this.sCf.invoke(this.sCe.get(obj3), new Object[0])).longValue());
                AppMethodBeat.o(169311);
                return zs2;
            } catch (Exception e3) {
                AppMethodBeat.o(169311);
                return null;
            }
        }
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    public final void a(View view, PInt pInt, PInt pInt2, int i2) {
        AppMethodBeat.i(169312);
        pInt.value = 0;
        pInt2.value = 0;
        if (this.sCb == null) {
            AppMethodBeat.o(169312);
            return;
        }
        RecyclerView recyclerView = this.sCb.get();
        if (recyclerView == null) {
            AppMethodBeat.o(169312);
            return;
        }
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter == null) {
            Log.e("HABBYGE-MALI.FinderFeedParamsCatcher", "getFeedInfo, RecyclerView.Adapter==NULL !!");
            AppMethodBeat.o(169312);
            return;
        }
        try {
            Object obj = this.sCc.get(adapter);
            if (obj == null) {
                AppMethodBeat.o(169312);
                return;
            }
            Object obj2 = ((ArrayList) obj).get(i2);
            if (obj2 == null) {
                AppMethodBeat.o(169312);
                return;
            }
            Object obj3 = this.sCe.get(obj2);
            pInt.value = ((Integer) this.sCi.invoke(obj3, new Object[0])).intValue();
            pInt2.value = ((Integer) this.sCj.invoke(obj3, new Object[0])).intValue();
            AppMethodBeat.o(169312);
        } catch (Exception e2) {
            try {
                Object obj4 = this.sCd.get(adapter);
                if (obj4 == null) {
                    AppMethodBeat.o(169312);
                    return;
                }
                pInt.value = ((Integer) this.sCi.invoke(obj4, new Object[0])).intValue();
                pInt2.value = ((Integer) this.sCj.invoke(obj4, new Object[0])).intValue();
                AppMethodBeat.o(169312);
            } catch (Exception e3) {
                Log.printErrStackTrace("HABBYGE-MALI.FinderFeedParamsCatcher", e3, "getFeedInfo crash-1: %s", e3.getMessage());
                AppMethodBeat.o(169312);
            }
        }
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    public final String ad(View view, int i2) {
        AppMethodBeat.i(169313);
        if (this.sCb == null) {
            AppMethodBeat.o(169313);
            return null;
        }
        RecyclerView recyclerView = this.sCb.get();
        if (recyclerView == null) {
            AppMethodBeat.o(169313);
            return null;
        }
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter == null) {
            Log.e("HABBYGE-MALI.FinderFeedParamsCatcher", "getFeedUserName, RecyclerView.Adapter == NULL !?");
            AppMethodBeat.o(169313);
            return null;
        }
        try {
            Object obj = this.sCc.get(adapter);
            if (obj == null) {
                AppMethodBeat.o(169313);
                return null;
            }
            Object obj2 = ((ArrayList) obj).get(i2);
            if (obj2 == null) {
                AppMethodBeat.o(169313);
                return null;
            }
            String str = (String) this.sCg.invoke(this.sCe.get(obj2), new Object[0]);
            AppMethodBeat.o(169313);
            return str;
        } catch (Exception e2) {
            try {
                Object obj3 = this.sCd.get(adapter);
                if (obj3 == null) {
                    AppMethodBeat.o(169313);
                    return null;
                }
                String str2 = (String) this.sCg.invoke(obj3, new Object[0]);
                AppMethodBeat.o(169313);
                return str2;
            } catch (Exception e3) {
                Log.printErrStackTrace("HABBYGE-MALI.FinderFeedParamsCatcher", e3, "getFeedUserName crash-1: %s", e3.getMessage());
                AppMethodBeat.o(169313);
                return null;
            }
        }
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    public final String ae(View view, int i2) {
        AppMethodBeat.i(185578);
        if (this.sCb == null) {
            AppMethodBeat.o(185578);
            return null;
        }
        RecyclerView recyclerView = this.sCb.get();
        if (recyclerView == null) {
            AppMethodBeat.o(185578);
            return null;
        }
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter == null) {
            Log.e("HABBYGE-MALI.FinderFeedParamsCatcher", "getFeedUserName, RecyclerView.Adapter == NULL !?");
            AppMethodBeat.o(185578);
            return null;
        }
        try {
            Object obj = this.sCc.get(adapter);
            if (obj == null) {
                AppMethodBeat.o(185578);
                return null;
            }
            Object obj2 = ((ArrayList) obj).get(i2);
            if (obj2 == null) {
                AppMethodBeat.o(185578);
                return null;
            }
            String str = (String) this.sCh.invoke(this.sCe.get(obj2), new Object[0]);
            AppMethodBeat.o(185578);
            return str;
        } catch (Exception e2) {
            try {
                Object obj3 = this.sCd.get(adapter);
                if (obj3 == null) {
                    AppMethodBeat.o(185578);
                    return null;
                }
                String str2 = (String) this.sCh.invoke(obj3, new Object[0]);
                AppMethodBeat.o(185578);
                return str2;
            } catch (Exception e3) {
                Log.printErrStackTrace("HABBYGE-MALI.FinderFeedParamsCatcher", e3, "getFeedNickName crash-1: %s", e3.getMessage());
                AppMethodBeat.o(185578);
                return null;
            }
        }
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    public final boolean dP(View view) {
        return false;
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    public final String GY(int i2) {
        return null;
    }
}
