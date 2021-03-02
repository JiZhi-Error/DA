package com.tencent.mm.plugin.finder.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.app.k;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000f\u0018\u0000 1*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u000201B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\u001f\u0010\u0014\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001dH\u0016J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0015H\u0002J\u0018\u0010%\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001dH\u0016J\u001a\u0010&\u001a\u0004\u0018\u00010#2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001dH\u0003J\u001f\u0010'\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0002\u0010(J\b\u0010)\u001a\u00020\u0015H\u0016J\u001f\u0010*\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00018\u0000H\u0007¢\u0006\u0002\u0010\u0017J\u0010\u0010+\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u001dH\u0002J\u0006\u0010,\u001a\u00020\u0015J\b\u0010-\u001a\u00020\u0015H\u0002J \u0010.\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010/\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u00062"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/adapter/DynamicPagerAdapter;", "FragmentType", "Lcom/tencent/mm/plugin/finder/view/adapter/StatePagerAdapterCp;", "viewPager", "Landroid/support/v4/view/ViewPager;", "manager", "Landroid/support/v4/app/FragmentManager;", "pageFragments", "", "(Landroid/support/v4/view/ViewPager;Landroid/support/v4/app/FragmentManager;Ljava/util/List;)V", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/tencent/mm/plugin/finder/view/adapter/DynamicPagerAdapter$ChangeAction;", "isUpdating", "", "getManager", "()Landroid/support/v4/app/FragmentManager;", "pendingAction", "pendingActionRunnable", "Ljava/lang/Runnable;", "pendingFragment", "addPendingActon", "", "fragment", "(Lcom/tencent/mm/plugin/finder/view/adapter/DynamicPagerAdapter$ChangeAction;Ljava/lang/Object;)V", "checkPendingAction", "finishUpdate", "container", "Landroid/view/ViewGroup;", "getCount", "", "getItem", "Landroid/support/v4/app/Fragment;", "position", "getItemPosition", "object", "", "handleNextPendingAction", "instantiateItem", "instantiateItemInner", "notifyAddItem", "(ILjava/lang/Object;)V", "notifyDataSetChanged", "notifyItemChange", "notifyRemoveItem", "onDestroy", "removePendingActions", "setPrimaryItem", "startUpdate", "ChangeAction", "Companion", "plugin-finder_release"})
public final class a<FragmentType> extends d {
    public static final b wrf = new b((byte) 0);
    private boolean gYQ;
    public final ViewPager uO;
    private C1328a wqZ;
    public List<C1328a> wra = new ArrayList();
    public List<FragmentType> wrb = new ArrayList();
    public Runnable wrc;
    private final g wrd;
    private final List<FragmentType> wre;

    static {
        AppMethodBeat.i(255143);
        AppMethodBeat.o(255143);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(ViewPager viewPager, g gVar, List<FragmentType> list) {
        super(gVar);
        p.h(viewPager, "viewPager");
        p.h(gVar, "manager");
        p.h(list, "pageFragments");
        AppMethodBeat.i(255142);
        this.uO = viewPager;
        this.wrd = gVar;
        this.wre = list;
        AppMethodBeat.o(255142);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/adapter/DynamicPagerAdapter$Companion;", "", "()V", "IS_ENABLE_PENDING", "", "PENDING_LIMIT", "", "PENDING_TIME_LIMIT", "TAG", "", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.view.adapter.d
    public final Fragment getItem(int i2) {
        AppMethodBeat.i(255133);
        FragmentType fragmenttype = this.wre.get(i2);
        if (fragmenttype == null) {
            t tVar = new t("null cannot be cast to non-null type android.support.v4.app.Fragment");
            AppMethodBeat.o(255133);
            throw tVar;
        }
        FragmentType fragmenttype2 = fragmenttype;
        if (fragmenttype2 instanceof FinderHomeTabFragment) {
            Log.i("Finder.DynamicAdapter", "getItem " + i2 + " fragment:" + fragmenttype2.title + " tabType:" + fragmenttype2.dLS);
        }
        AppMethodBeat.o(255133);
        return fragmenttype2;
    }

    @Override // android.support.v4.view.q
    public final int getCount() {
        AppMethodBeat.i(255134);
        int size = this.wre.size();
        AppMethodBeat.o(255134);
        return size;
    }

    @Override // android.support.v4.view.q, com.tencent.mm.plugin.finder.view.adapter.d
    public final Object instantiateItem(ViewGroup viewGroup, int i2) {
        Object obj;
        Fragment.SavedState savedState;
        AppMethodBeat.i(255135);
        p.h(viewGroup, "container");
        Log.i("Finder.DynamicAdapter", "instantiateItem " + i2 + " action:" + this.wqZ);
        C1328a aVar = this.wqZ;
        if (aVar == null || !aVar.lCr) {
            Object instantiateItem = super.instantiateItem(viewGroup, i2);
            AppMethodBeat.o(255135);
            return instantiateItem;
        } else if (i2 == this.mFragments.size()) {
            Object instantiateItem2 = super.instantiateItem(viewGroup, i2);
            AppMethodBeat.o(255135);
            return instantiateItem2;
        } else {
            ArrayList<Fragment> arrayList = this.mFragments;
            if (i2 < arrayList.size()) {
                if (this.mCurTransaction == null) {
                    this.mCurTransaction = this.wrt.beginTransaction();
                }
                Fragment item = getItem(i2);
                if (this.mSavedState.size() > i2 && (savedState = this.mSavedState.get(i2)) != null) {
                    item.setInitialSavedState(savedState);
                }
                item.setMenuVisibility(false);
                item.setUserVisibleHint(false);
                arrayList.add(i2, item);
                StringBuilder sb = new StringBuilder("instantiateItemInner: title:");
                if (item == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment");
                    AppMethodBeat.o(255135);
                    throw tVar;
                }
                Log.i("Finder.DynamicAdapter", sb.append(((FinderHomeTabFragment) item).title).append(" tabType:").append(((FinderHomeTabFragment) item).dLS).toString());
                k kVar = this.mCurTransaction;
                if (kVar != null) {
                    kVar.a(viewGroup.getId(), item);
                }
                obj = item;
            } else {
                obj = null;
            }
            if (obj == null) {
                obj = super.instantiateItem(viewGroup, i2);
            }
            AppMethodBeat.o(255135);
            return obj;
        }
    }

    @Override // android.support.v4.view.q, com.tencent.mm.plugin.finder.view.adapter.d
    public final void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        AppMethodBeat.i(255136);
        p.h(viewGroup, "container");
        p.h(obj, "object");
        StringBuilder append = new StringBuilder("setPrimaryItem ").append(i2).append("  changePosition ");
        C1328a aVar = this.wqZ;
        Log.i("Finder.DynamicAdapter", append.append(aVar != null ? Integer.valueOf(aVar.wrg) : null).append(", obj:").append(obj).append(' ').append("title:").append(((FinderHomeTabFragment) obj).title).append(" tabType:").append(((FinderHomeTabFragment) obj).dLS).toString());
        super.setPrimaryItem(viewGroup, i2, obj);
        C1328a aVar2 = this.wqZ;
        if (aVar2 != null) {
            if (aVar2.wrg == i2) {
                Log.i("Finder.DynamicAdapter", "setPrimaryItem action null");
                this.wqZ = null;
            }
            AppMethodBeat.o(255136);
            return;
        }
        AppMethodBeat.o(255136);
    }

    @Override // android.support.v4.view.q
    public final int getItemPosition(Object obj) {
        C1328a aVar;
        AppMethodBeat.i(255137);
        p.h(obj, "object");
        int itemPosition = super.getItemPosition(obj);
        Log.i("Finder.DynamicAdapter", "getItemPosition : position ".concat(String.valueOf(itemPosition)));
        if ((obj instanceof Fragment) && (aVar = this.wqZ) != null) {
            itemPosition = this.wre.indexOf(obj);
            Log.i("Finder.DynamicAdapter", "getItemPosition : newPosition " + itemPosition + " changePosition :" + aVar.wrg);
            if (itemPosition == -1) {
                itemPosition = -2;
            } else if (itemPosition >= aVar.wrg) {
                Log.i("Finder.DynamicAdapter", "use new ".concat(String.valueOf(itemPosition)));
            } else {
                Log.i("Finder.DynamicAdapter", "unchanged");
                itemPosition = -1;
            }
        }
        AppMethodBeat.o(255137);
        return itemPosition;
    }

    @Override // android.support.v4.view.q, com.tencent.mm.plugin.finder.view.adapter.d
    public final void finishUpdate(ViewGroup viewGroup) {
        AppMethodBeat.i(255138);
        p.h(viewGroup, "container");
        super.finishUpdate(viewGroup);
        Log.i("Finder.DynamicAdapter", "finishUpdate");
        this.gYQ = false;
        AppMethodBeat.o(255138);
    }

    @Override // android.support.v4.view.q, com.tencent.mm.plugin.finder.view.adapter.d
    public final void startUpdate(ViewGroup viewGroup) {
        AppMethodBeat.i(255139);
        p.h(viewGroup, "container");
        this.gYQ = true;
        super.startUpdate(viewGroup);
        Log.i("Finder.DynamicAdapter", "startUpdate");
        AppMethodBeat.o(255139);
    }

    @Override // android.support.v4.view.q
    public final void notifyDataSetChanged() {
        AppMethodBeat.i(255140);
        this.gYQ = true;
        Log.i("Finder.DynamicAdapter", "notifyDataSetChanged");
        super.notifyDataSetChanged();
        AppMethodBeat.o(255140);
    }

    public final void a(C1328a aVar, FragmentType fragmenttype) {
        AppMethodBeat.i(255141);
        p.h(aVar, NativeProtocol.WEB_DIALOG_ACTION);
        this.wqZ = aVar;
        Log.i("Finder.DynamicAdapter", "notifyItemChange isAdd:" + aVar.lCr + " position " + aVar.wrg);
        if (aVar.lCr) {
            int i2 = aVar.wrg;
            if (fragmenttype != null) {
                if (i2 < 0 || i2 > this.wre.size()) {
                    Log.e("Finder.DynamicAdapter", "notifyAddItem index out of range");
                } else {
                    List<FragmentType> list = this.wre;
                    if (!(!this.wre.contains(fragmenttype))) {
                        list = null;
                    }
                    if (list != null) {
                        list.add(i2, fragmenttype);
                    }
                    notifyDataSetChanged();
                    AppMethodBeat.o(255141);
                    return;
                }
            }
            AppMethodBeat.o(255141);
            return;
        }
        int i3 = aVar.wrg;
        if (i3 < 0 || i3 >= this.wre.size()) {
            Log.e("Finder.DynamicAdapter", "notifyRemoveItem index out of range");
            AppMethodBeat.o(255141);
            return;
        }
        this.wre.remove(i3);
        notifyDataSetChanged();
        AppMethodBeat.o(255141);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/adapter/DynamicPagerAdapter$ChangeAction;", "", "isAdd", "", "changePosition", "", "(ZI)V", "getChangePosition", "()I", "()Z", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.view.adapter.a$a  reason: collision with other inner class name */
    public static final class C1328a {
        final boolean lCr;
        final int wrg;

        public C1328a(boolean z, int i2) {
            this.lCr = z;
            this.wrg = i2;
        }
    }
}
