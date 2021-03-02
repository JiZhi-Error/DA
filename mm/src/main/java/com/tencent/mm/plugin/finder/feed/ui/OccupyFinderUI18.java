package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI14;
import com.tencent.mm.plugin.finder.live.view.adapter.n;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 22\u00020\u0001:\u00012B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0014J\b\u0010\b\u001a\u00020\tH\u0014J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0014J0\u0010\u0013\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u000bH\u0002J\b\u0010\u001c\u001a\u00020\u000bH\u0014J\b\u0010\u001d\u001a\u00020\u000bH\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u001fH\u0014J\b\u0010#\u001a\u00020\u001fH\u0014J\u0012\u0010$\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\r2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020,H\u0002J\u001a\u0010-\u001a\u00020\u000b2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\rH\u0014J\b\u00101\u001a\u00020\u000bH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u00063"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI18;", "Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;", "()V", "selectUserSet", "Ljava/util/HashSet;", "", "createInitAdapter", "Lcom/tencent/mm/ui/contact/MMInitContactAdapter;", "createSearchAdapter", "Lcom/tencent/mm/ui/contact/MMBaseSearchContactAdapter;", "fakeDarkMode", "", "getLayoutId", "", "getSearchRange", "", "getSelectedChatroomsUsername", "", "getTitleString", "handleItemClick", "parent", "Landroid/widget/AdapterView;", "view", "Landroid/view/View;", "position", "id", "", "handleSelect", "initData", "initMenu", "isItemCheck", "", "item", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "isSearchBarInTop", "isShowAlphabetScrollBar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSelectChange", NativeProtocol.WEB_DIALOG_ACTION, ch.COL_USERNAME, "selectUser", "contact", "Lcom/tencent/mm/storage/Contact;", "setHeaderView", "contentLV", "Landroid/widget/ListView;", "visibility", "updateMenu", "Companion", "plugin-finder_release"})
public final class OccupyFinderUI18 extends MMBaseSelectContactUI {
    public static final a UJm = new a((byte) 0);
    private HashMap _$_findViewCache;
    private final HashSet<String> jVV = new HashSet<>();

    static {
        AppMethodBeat.i(260320);
        AppMethodBeat.o(260320);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(260323);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(260323);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(260322);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(260322);
        return view;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class c extends q implements kotlin.g.a.b<String, Boolean> {
        final /* synthetic */ String hLl;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(String str) {
            super(1);
            this.hLl = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(String str) {
            AppMethodBeat.i(260308);
            String str2 = str;
            p.h(str2, LocaleUtil.ITALIAN);
            Boolean valueOf = Boolean.valueOf(Util.isEqual(this.hLl, str2));
            AppMethodBeat.o(260308);
            return valueOf;
        }
    }

    public OccupyFinderUI18() {
        AppMethodBeat.i(260319);
        AppMethodBeat.o(260319);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ OccupyFinderUI18 UJn;

        b(OccupyFinderUI18 occupyFinderUI18) {
            this.UJn = occupyFinderUI18;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(260307);
            OccupyFinderUI18.a(this.UJn);
            AppMethodBeat.o(260307);
            return true;
        }
    }

    private final void ani() {
        AppMethodBeat.i(260309);
        int size = this.jVV.size();
        if (size > 0) {
            enableOptionMenu(1, true);
            updateOptionMenuText(1, getString(R.string.jc2, new Object[]{Integer.valueOf(size)}));
            AppMethodBeat.o(260309);
            return;
        }
        enableOptionMenu(1, false);
        updateOptionMenuText(1, getString(R.string.d00));
        AppMethodBeat.o(260309);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.cf_;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(260310);
        super.onCreate(bundle);
        setTheme(R.style.a0);
        setActionbarColor(getResources().getColor(R.color.w));
        setNavigationbarColor(getResources().getColor(R.color.w));
        hYJ();
        hYK();
        addTextOptionMenu(1, getString(R.string.d00), new b(this), null, t.b.FINDER_LIVE);
        ani();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.jVV.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        hYI().it(arrayList);
        AppMethodBeat.o(260310);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void amZ() {
        AppMethodBeat.i(260311);
        super.amZ();
        Intent intent = getIntent();
        OccupyFinderUI14.a aVar = OccupyFinderUI14.ueB;
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(OccupyFinderUI14.hSP());
        ArrayList<String> arrayList = stringArrayListExtra;
        if (!(arrayList == null || arrayList.isEmpty())) {
            this.jVV.addAll(stringArrayListExtra);
        }
        AppMethodBeat.o(260311);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final boolean bmz() {
        return false;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final boolean bmA() {
        return false;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final String bmB() {
        AppMethodBeat.i(260312);
        String string = getContext().getString(R.string.h7g);
        p.g(string, "context.getString(R.string.sns_label_group_title)");
        AppMethodBeat.o(260312);
        return string;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final com.tencent.mm.ui.contact.q bmC() {
        AppMethodBeat.i(260313);
        n nVar = new n(this, (byte) 0);
        AppMethodBeat.o(260313);
        return nVar;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final o bmD() {
        AppMethodBeat.i(260314);
        com.tencent.mm.plugin.finder.live.view.adapter.p pVar = new com.tencent.mm.plugin.finder.live.view.adapter.p(this);
        AppMethodBeat.o(260314);
        return pVar;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final int[] egI() {
        return new int[]{131075};
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void a(ListView listView, int i2) {
        AppMethodBeat.i(260315);
        super.a(listView, i2);
        AppMethodBeat.o(260315);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c
    public final void T(int i2, String str) {
        AppMethodBeat.i(260316);
        if (i2 == 1) {
            j.a((Iterable) this.jVV, (kotlin.g.a.b) new c(str));
            gUP().notifyDataSetChanged();
            ani();
        }
        AppMethodBeat.o(260316);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void M(View view, int i2) {
        AppMethodBeat.i(260317);
        ListView contentLV = getContentLV();
        p.g(contentLV, "getContentLV()");
        int headerViewsCount = i2 - contentLV.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            Log.i("MicroMsg.FinderLiveMultiSelectChatRoomUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", Integer.valueOf(headerViewsCount), Integer.valueOf(i2));
            AppMethodBeat.o(260317);
            return;
        }
        com.tencent.mm.ui.contact.a.a anH = gUP().getItem(headerViewsCount);
        if (anH == null) {
            AppMethodBeat.o(260317);
        } else if (anH.eFa() == null) {
            AppMethodBeat.o(260317);
        } else {
            as eFa = anH.eFa();
            p.g(eFa, "baseContactDataItem.contact");
            if (eFa.aFQ() == 1) {
                AppMethodBeat.o(260317);
                return;
            }
            as eFa2 = anH.eFa();
            p.g(eFa2, "contact");
            String username = eFa2.getUsername();
            if (username == null) {
                username = "";
            }
            gUW();
            hYI().bev(username);
            if (this.jVV.contains(username)) {
                this.jVV.remove(username);
            } else {
                this.jVV.add(username);
            }
            gUQ().notifyDataSetChanged();
            ani();
            AppMethodBeat.o(260317);
        }
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.contact.n
    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(260318);
        p.h(aVar, "item");
        if (!aVar.eWh() || aVar.eFa() == null) {
            AppMethodBeat.o(260318);
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (T t : this.jVV) {
            as eFa = aVar.eFa();
            p.g(eFa, "item.contact");
            if (Util.isEqual((String) t, eFa.getUsername())) {
                arrayList.add(t);
            }
        }
        if (!(arrayList.isEmpty())) {
            AppMethodBeat.o(260318);
            return true;
        }
        AppMethodBeat.o(260318);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI18$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void a(OccupyFinderUI18 occupyFinderUI18) {
        AppMethodBeat.i(260321);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(occupyFinderUI18.jVV);
        Intent intent = new Intent();
        OccupyFinderUI14.a aVar = OccupyFinderUI14.ueB;
        intent.putStringArrayListExtra(OccupyFinderUI14.hSP(), arrayList);
        occupyFinderUI18.setResult(-1, intent);
        occupyFinderUI18.finish();
        occupyFinderUI18.ani();
        occupyFinderUI18.gUP().notifyDataSetChanged();
        AppMethodBeat.o(260321);
    }
}
