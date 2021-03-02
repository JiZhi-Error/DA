package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.live.view.adapter.r;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 32\u00020\u0001:\u00013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0014J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0014J0\u0010\u0014\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u000fH\u0002J\b\u0010\u001d\u001a\u00020\u000fH\u0014J\b\u0010\u001e\u001a\u00020\u000fH\u0002J\b\u0010\u001f\u001a\u00020\u000fH\u0002J\b\u0010 \u001a\u00020\u000fH\u0002J\u0012\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\"H\u0014J\b\u0010&\u001a\u00020\"H\u0014J\u0012\u0010'\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001a\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u0010-\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\tH\u0002J\b\u00101\u001a\u00020\u000fH\u0002J\b\u00102\u001a\u00020\u000fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI19;", "Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;", "()V", "inputView", "Lcom/tencent/mm/pluginsdk/ui/MultiSelectContactView;", "maxRoomCount", "", "selectUserSet", "Ljava/util/HashSet;", "", "createInitAdapter", "Lcom/tencent/mm/ui/contact/MMInitContactAdapter;", "createSearchAdapter", "Lcom/tencent/mm/ui/contact/MMBaseSearchContactAdapter;", "fakeDarkMode", "", "getLayoutId", "getSearchRange", "", "getTitleString", "handleItemClick", "parent", "Landroid/widget/AdapterView;", "view", "Landroid/view/View;", "position", "id", "", "handleSelect", "initData", "initMenu", "initSelectView", "initViews", "isItemCheck", "", "item", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "isSearchBarInTop", "isShowAlphabetScrollBar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSelectChange", NativeProtocol.WEB_DIALOG_ACTION, "userName", "selectUser", "contact", "Lcom/tencent/mm/storage/Contact;", ch.COL_USERNAME, "setSubTitle", "updateMenu", "Companion", "plugin-finder_release"})
public final class OccupyFinderUI19 extends MMBaseSelectContactUI {
    private static final String TAG = TAG;
    public static final a UJq = new a((byte) 0);
    private MultiSelectContactView UJo;
    private int UJp;
    private HashMap _$_findViewCache;
    private final HashSet<String> jVV = new HashSet<>();

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(260338);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(260338);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(260337);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(260337);
        return view;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public OccupyFinderUI19() {
        AppMethodBeat.i(260334);
        AppMethodBeat.o(260334);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI19$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(260335);
        AppMethodBeat.o(260335);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ OccupyFinderUI19 UJr;

        b(OccupyFinderUI19 occupyFinderUI19) {
            this.UJr = occupyFinderUI19;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(260324);
            OccupyFinderUI19.a(this.UJr);
            AppMethodBeat.o(260324);
            return true;
        }
    }

    private final void ani() {
        AppMethodBeat.i(260325);
        HashSet<String> hashSet = this.jVV;
        if (!(hashSet == null || hashSet.isEmpty())) {
            enableOptionMenu(1, true);
            AppCompatActivity context = getContext();
            p.g(context, "context");
            updateOptionMenuText(1, context.getResources().getString(R.string.jc2, Integer.valueOf(this.jVV.size())));
            AppMethodBeat.o(260325);
            return;
        }
        enableOptionMenu(1, false);
        updateOptionMenuText(1, getString(R.string.d00));
        AppMethodBeat.o(260325);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void amZ() {
        AppMethodBeat.i(260326);
        super.amZ();
        this.UJp = getIntent().getIntExtra("KEY_LUCKY_MONEY_CHAT_ROOM_MAX_COUNT", 0);
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra("KEY_LUCKY_MONEY_CHAT_ROOM_USERNAME");
        this.jVV.clear();
        if (stringArrayListExtra != null) {
            for (T t : stringArrayListExtra) {
                T t2 = t;
                if (!(t2 == null || t2.length() == 0)) {
                    this.jVV.add(t);
                }
            }
        }
        Log.i(TAG, "initData maxRoomCount:" + this.UJp + ",selectUserSet size:" + this.jVV.size());
        AppMethodBeat.o(260326);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(260327);
        super.onCreate(bundle);
        setTheme(R.style.a0);
        setActionbarColor(getResources().getColor(R.color.w));
        setNavigationbarColor(getResources().getColor(R.color.w));
        hYJ();
        hYK();
        addTextOptionMenu(1, getString(R.string.d00), new b(this), null, t.b.FINDER_LIVE);
        ani();
        this.UJo = (MultiSelectContactView) findViewById(R.id.bcg);
        MultiSelectContactView multiSelectContactView = this.UJo;
        if (multiSelectContactView != null) {
            multiSelectContactView.hYa();
        }
        MultiSelectContactView multiSelectContactView2 = this.UJo;
        if (multiSelectContactView2 != null) {
            multiSelectContactView2.hYb();
        }
        hYI().it(new ArrayList(this.jVV));
        TextView mMSubTitle = getMMSubTitle();
        if (mMSubTitle != null) {
            setMMSubTitle(getString(R.string.jbx));
            mMSubTitle.setTextColor(getResources().getColor(R.color.BW_100_Alpha_0_5));
        }
        AppMethodBeat.o(260327);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final o bmD() {
        AppMethodBeat.i(260328);
        r rVar = new r(this);
        AppMethodBeat.o(260328);
        return rVar;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final boolean bmz() {
        return false;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final q bmC() {
        AppMethodBeat.i(260329);
        com.tencent.mm.plugin.finder.live.view.adapter.q qVar = new com.tencent.mm.plugin.finder.live.view.adapter.q(this);
        qVar.hYH();
        com.tencent.mm.plugin.finder.live.view.adapter.q qVar2 = qVar;
        AppMethodBeat.o(260329);
        return qVar2;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final boolean bmA() {
        return false;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final String bmB() {
        AppMethodBeat.i(260330);
        String string = getContext().getString(R.string.jby);
        p.g(string, "context.getString(R.stri…t_room_lucky_money_title)");
        AppMethodBeat.o(260330);
        return string;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.cfc;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void M(View view, int i2) {
        AppMethodBeat.i(260331);
        ListView contentLV = getContentLV();
        p.g(contentLV, "getContentLV()");
        int headerViewsCount = i2 - contentLV.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            Log.i(TAG, "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", Integer.valueOf(headerViewsCount), Integer.valueOf(i2));
            AppMethodBeat.o(260331);
            return;
        }
        com.tencent.mm.ui.contact.a.a anH = gUP().getItem(headerViewsCount);
        if (anH == null) {
            AppMethodBeat.o(260331);
        } else if (anH.eFa() == null) {
            AppMethodBeat.o(260331);
        } else {
            as eFa = anH.eFa();
            p.g(eFa, "baseContactDataItem.contact");
            if (eFa.aFQ() == 1) {
                AppMethodBeat.o(260331);
                return;
            }
            as eFa2 = anH.eFa();
            p.g(eFa2, "contact");
            String username = eFa2.getUsername();
            if (username == null) {
                username = "";
            }
            gUW();
            if (this.jVV.contains(username)) {
                this.jVV.remove(username);
                hYI().bev(username);
            } else if (this.jVV.size() < this.UJp) {
                this.jVV.add(username);
                hYI().bev(username);
            }
            gUW();
            gUQ().notifyDataSetChanged();
            ani();
            AppMethodBeat.o(260331);
        }
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c
    public final void T(int i2, String str) {
        AppMethodBeat.i(260332);
        if (i2 == 1) {
            HashSet<String> hashSet = this.jVV;
            if (hashSet == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                AppMethodBeat.o(260332);
                throw tVar;
            }
            af.eV(hashSet).remove(str);
            gUP().notifyDataSetChanged();
            ani();
        }
        AppMethodBeat.o(260332);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final int[] egI() {
        return new int[]{131075};
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.contact.n
    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(260333);
        if (aVar == null || !aVar.eWh() || aVar.eFa() == null) {
            AppMethodBeat.o(260333);
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
            AppMethodBeat.o(260333);
            return true;
        }
        AppMethodBeat.o(260333);
        return false;
    }

    public static final /* synthetic */ void a(OccupyFinderUI19 occupyFinderUI19) {
        AppMethodBeat.i(260336);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(occupyFinderUI19.jVV);
        Intent intent = new Intent();
        intent.putStringArrayListExtra("KEY_LUCKY_MONEY_CHAT_ROOM_USERNAME", arrayList);
        occupyFinderUI19.setResult(-1, intent);
        occupyFinderUI19.finish();
        occupyFinderUI19.ani();
        occupyFinderUI19.gUP().notifyDataSetChanged();
        AppMethodBeat.o(260336);
    }
}
