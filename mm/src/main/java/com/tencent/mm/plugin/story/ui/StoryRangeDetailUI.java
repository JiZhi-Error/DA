package com.tencent.mm.plugin.story.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.story.i.j;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0003\u0019\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\fH\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/StoryRangeDetailUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "adapter", "Lcom/tencent/mm/plugin/story/ui/StoryRangeDetailUI$ContactsAdapter;", "blackList", "Ljava/util/ArrayList;", "", "contactLV", "Landroid/widget/ListView;", "groupList", ch.COL_LOCALID, "", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "titile", "userNames", "getLayoutId", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "prepareData", "Companion", "ContactsAdapter", "ViewHolder", "plugin-story_release"})
public final class StoryRangeDetailUI extends MMActivity {
    public static final a Fxl = new a((byte) 0);
    private static final String TAG = TAG;
    private j Fqr;
    private b Fxj;
    private String Fxk;
    private int ecf;
    private final ArrayList<String> gCp = new ArrayList<>();
    private final ArrayList<String> haH = new ArrayList<>();
    private final ArrayList<String> ldu = new ArrayList<>();
    private ListView yCT;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/StoryRangeDetailUI$ViewHolder;", "", "()V", "avatarIV", "Lcom/tencent/mm/ui/base/MaskLayout;", "getAvatarIV$plugin_story_release", "()Lcom/tencent/mm/ui/base/MaskLayout;", "setAvatarIV$plugin_story_release", "(Lcom/tencent/mm/ui/base/MaskLayout;)V", "catalog", "Landroid/widget/TextView;", "getCatalog$plugin_story_release", "()Landroid/widget/TextView;", "setCatalog$plugin_story_release", "(Landroid/widget/TextView;)V", "nickTV", "getNickTV$plugin_story_release", "setNickTV$plugin_story_release", "weixinTV", "getWeixinTV$plugin_story_release", "setWeixinTV$plugin_story_release", "plugin-story_release"})
    static final class c {
        TextView Fxp;
        MaskLayout gAN;
        TextView gwR;
        TextView yuS;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public StoryRangeDetailUI() {
        AppMethodBeat.i(119656);
        AppMethodBeat.o(119656);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/StoryRangeDetailUI$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(119657);
        AppMethodBeat.o(119657);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0068, code lost:
        if (r0 != false) goto L_0x006a;
     */
    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r7) {
        /*
        // Method dump skipped, instructions count: 211
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.ui.StoryRangeDetailUI.onCreate(android.os.Bundle):void");
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(119654);
        setMMTitle(this.Fxk);
        View findViewById = findViewById(R.id.h4);
        if (findViewById == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.ListView");
            AppMethodBeat.o(119654);
            throw tVar;
        }
        this.yCT = (ListView) findViewById;
        ListView listView = this.yCT;
        if (listView != null) {
            listView.setBackgroundColor(getResources().getColor(R.color.afz));
        }
        ListView listView2 = this.yCT;
        ViewParent parent = listView2 != null ? listView2.getParent() : null;
        if (parent == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(119654);
            throw tVar2;
        }
        ((View) parent).setBackgroundColor(getResources().getColor(R.color.afz));
        setBackBtn(new d(this));
        showOptionMenu(false);
        if (!(this.gCp == null || this.gCp.size() == 0)) {
            this.Fxj = new b(this, this.gCp);
            ListView listView3 = this.yCT;
            if (listView3 != null) {
                listView3.setAdapter((ListAdapter) this.Fxj);
            }
            ListView listView4 = this.yCT;
            if (listView4 != null) {
                listView4.setVisibility(0);
            }
            ListView listView5 = this.yCT;
            if (listView5 != null) {
                listView5.setOnItemClickListener(new e(this));
                AppMethodBeat.o(119654);
                return;
            }
        }
        AppMethodBeat.o(119654);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class d implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ StoryRangeDetailUI Fxq;

        d(StoryRangeDetailUI storyRangeDetailUI) {
            this.Fxq = storyRangeDetailUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(119651);
            this.Fxq.finish();
            AppMethodBeat.o(119651);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "parent", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
    public static final class e implements AdapterView.OnItemClickListener {
        final /* synthetic */ StoryRangeDetailUI Fxq;

        e(StoryRangeDetailUI storyRangeDetailUI) {
            this.Fxq = storyRangeDetailUI;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            AppMethodBeat.i(119652);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(adapterView);
            bVar.bm(view);
            bVar.pH(i2);
            bVar.zo(j2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StoryRangeDetailUI$initView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
            b bVar2 = this.Fxq.Fxj;
            Object item = bVar2 != null ? bVar2.getItem(i2) : null;
            if (item == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.contact.RContact");
                AppMethodBeat.o(119652);
                throw tVar;
            }
            Intent intent = new Intent();
            intent.putExtra("Contact_User", ((com.tencent.mm.contact.c) item).getUsername());
            intent.putExtra("CONTACT_INFO_UI_SOURCE", 12);
            com.tencent.mm.br.c.b(this.Fxq.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StoryRangeDetailUI$initView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(119652);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        b bVar;
        AppMethodBeat.i(119655);
        super.onResume();
        if (this.Fxj == null || (bVar = this.Fxj) == null) {
            AppMethodBeat.o(119655);
            return;
        }
        bVar.notifyDataSetChanged();
        AppMethodBeat.o(119655);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.c0u;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u0011\u001a\u00020\fH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\fH\u0016J\"\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/StoryRangeDetailUI$ContactsAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "userNames", "", "", "(Landroid/content/Context;Ljava/util/List;)V", "cstg", "Lcom/tencent/mm/storage/IContactStorage;", "list", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/contact/RContact;", "normal", "Landroid/content/res/ColorStateList;", "spuser", "getCount", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-story_release"})
    public static final class b extends BaseAdapter {
        private bv EBg;
        private final HashMap<Integer, com.tencent.mm.contact.c> Fxm = new HashMap<>();
        private ColorStateList Fxn;
        private ColorStateList Fxo;
        private Context context;

        /* JADX WARNING: Removed duplicated region for block: B:30:0x00ca  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00cf  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00d6  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00ee  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00f3  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x00fa  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0103  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x0108  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public b(android.content.Context r9, java.util.List<java.lang.String> r10) {
            /*
            // Method dump skipped, instructions count: 286
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.ui.StoryRangeDetailUI.b.<init>(android.content.Context, java.util.List):void");
        }

        public final int getCount() {
            AppMethodBeat.i(119647);
            int size = this.Fxm.size();
            AppMethodBeat.o(119647);
            return size;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(119648);
            if (i2 < 0) {
                AppMethodBeat.o(119648);
                return null;
            }
            com.tencent.mm.contact.c cVar = this.Fxm.get(Integer.valueOf(i2));
            AppMethodBeat.o(119648);
            return cVar;
        }

        public final long getItemId(int i2) {
            return 0;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            c cVar;
            ColorStateList colorStateList;
            AppMethodBeat.i(119649);
            p.h(viewGroup, "parent");
            if (view == null) {
                view = View.inflate(this.context, R.layout.c0t, null);
                c cVar2 = new c();
                if (view == null) {
                    p.hyc();
                }
                View findViewById = view.findViewById(R.id.bdr);
                if (findViewById == null) {
                    t tVar = new t("null cannot be cast to non-null type android.widget.TextView");
                    AppMethodBeat.o(119649);
                    throw tVar;
                }
                cVar2.yuS = (TextView) findViewById;
                View findViewById2 = view.findViewById(R.id.bdo);
                if (findViewById2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.MaskLayout");
                    AppMethodBeat.o(119649);
                    throw tVar2;
                }
                cVar2.gAN = (MaskLayout) findViewById2;
                View findViewById3 = view.findViewById(R.id.bdw);
                if (findViewById3 == null) {
                    t tVar3 = new t("null cannot be cast to non-null type android.widget.TextView");
                    AppMethodBeat.o(119649);
                    throw tVar3;
                }
                cVar2.gwR = (TextView) findViewById3;
                View findViewById4 = view.findViewById(R.id.bdm);
                if (findViewById4 == null) {
                    t tVar4 = new t("null cannot be cast to non-null type android.widget.TextView");
                    AppMethodBeat.o(119649);
                    throw tVar4;
                }
                cVar2.Fxp = (TextView) findViewById4;
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                Object tag = view.getTag();
                if (tag == null) {
                    t tVar5 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.StoryRangeDetailUI.ViewHolder");
                    AppMethodBeat.o(119649);
                    throw tVar5;
                }
                cVar = (c) tag;
            }
            getItem(i2);
            com.tencent.mm.contact.c cVar3 = (com.tencent.mm.contact.c) getItem(i2);
            TextView textView = cVar.yuS;
            if (textView == null) {
                p.hyc();
            }
            textView.setVisibility(8);
            TextView textView2 = cVar.gwR;
            if (textView2 == null) {
                p.hyc();
            }
            if (cVar3 == null) {
                p.hyc();
            }
            if (!ab.JE(cVar3.getUsername())) {
                colorStateList = this.Fxn;
            } else {
                colorStateList = this.Fxo;
            }
            textView2.setTextColor(colorStateList);
            MaskLayout maskLayout = cVar.gAN;
            if (maskLayout == null) {
                p.hyc();
            }
            View contentView = maskLayout.getContentView();
            if (contentView == null) {
                t tVar6 = new t("null cannot be cast to non-null type android.widget.ImageView");
                AppMethodBeat.o(119649);
                throw tVar6;
            }
            a.b.A((ImageView) contentView, cVar3.getUsername());
            TextView textView3 = cVar.Fxp;
            if (textView3 == null) {
                p.hyc();
            }
            textView3.setVisibility(8);
            MaskLayout maskLayout2 = cVar.gAN;
            if (maskLayout2 == null) {
                p.hyc();
            }
            maskLayout2.setVisibility(0);
            TextView textView4 = cVar.gwR;
            if (textView4 == null) {
                p.hyc();
            }
            Context context2 = this.context;
            String arJ = cVar3.arJ();
            TextView textView5 = cVar.gwR;
            if (textView5 == null) {
                p.hyc();
            }
            textView4.setText(com.tencent.mm.pluginsdk.ui.span.l.b(context2, arJ, textView5.getTextSize()));
            TextView textView6 = cVar.gwR;
            if (textView6 == null) {
                p.hyc();
            }
            textView6.setVisibility(0);
            AppMethodBeat.o(119649);
            return view;
        }
    }
}
