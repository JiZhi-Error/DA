package com.tencent.mm.plugin.profile.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.profile.model.WxaRegisterInfo;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;

public final class WxaBindWxaInfoUI extends MMActivity {
    private ListView mListView;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(50073);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            AppMethodBeat.o(50073);
            return;
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.WxaBindWxaInfoUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(50066);
                WxaBindWxaInfoUI.this.finish();
                AppMethodBeat.o(50066);
                return false;
            }
        });
        setMMTitle(R.string.py);
        setActionbarColor(getActionbarColor());
        String nullAsNil = Util.nullAsNil(getIntent().getStringExtra("register"));
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("wxa_register_info_list");
        View inflate = getLayoutInflater().inflate(R.layout.ccr, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.ipq)).setText(getString(R.string.pz, new Object[]{nullAsNil}));
        this.mListView = (ListView) findViewById(R.id.bke);
        this.mListView.addFooterView(inflate);
        this.mListView.setAdapter((ListAdapter) new b(getLayoutInflater(), parcelableArrayListExtra));
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.WxaBindWxaInfoUI.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(50067);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/WxaBindWxaInfoUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                a aVar = (a) adapterView.getAdapter().getItem(i2);
                if (aVar == null || 1 != aVar.type) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/WxaBindWxaInfoUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(50067);
                    return;
                }
                WxaAttributes.WxaEntryInfo wxaEntryInfo = aVar.BiN;
                r rVar = (r) g.af(r.class);
                if (rVar != null) {
                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                    appBrandStatObject.scene = 1135;
                    rVar.a(WxaBindWxaInfoUI.this.getContext(), wxaEntryInfo.username, (String) null, 0, -1, (String) null, appBrandStatObject);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/WxaBindWxaInfoUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(50067);
            }
        });
        getContentView().setBackgroundResource(R.color.a74);
        AppMethodBeat.o(50073);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.cct;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        public final String BcS;
        public final WxaAttributes.WxaEntryInfo BiN;
        public final boolean BiO;
        public final int type;

        /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0012 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.util.List<com.tencent.mm.plugin.profile.ui.WxaBindWxaInfoUI.a> fS(java.util.List<com.tencent.mm.plugin.profile.model.WxaRegisterInfo> r12) {
            /*
            // Method dump skipped, instructions count: 117
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.WxaBindWxaInfoUI.a.fS(java.util.List):java.util.List");
        }

        private a(int i2, String str, WxaAttributes.WxaEntryInfo wxaEntryInfo, boolean z) {
            this.type = i2;
            this.BcS = str;
            this.BiN = wxaEntryInfo;
            this.BiO = z;
        }
    }

    static class b extends BaseAdapter {
        private LayoutInflater mInflater;
        private List<a> opg;

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(50072);
            a UR = UR(i2);
            AppMethodBeat.o(50072);
            return UR;
        }

        public b(LayoutInflater layoutInflater, List<WxaRegisterInfo> list) {
            AppMethodBeat.i(50068);
            this.mInflater = layoutInflater;
            this.opg = a.fS(list);
            AppMethodBeat.o(50068);
        }

        public final int getCount() {
            AppMethodBeat.i(50069);
            int size = this.opg.size();
            AppMethodBeat.o(50069);
            return size;
        }

        private a UR(int i2) {
            AppMethodBeat.i(227872);
            a aVar = this.opg.get(i2);
            AppMethodBeat.o(227872);
            return aVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final int getItemViewType(int i2) {
            AppMethodBeat.i(227873);
            int i3 = UR(i2).type;
            AppMethodBeat.o(227873);
            return i3;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            a aVar;
            C1582b bVar;
            int i3;
            AppMethodBeat.i(50071);
            a UR = UR(i2);
            if (1 == UR.type) {
                if (view == 0 || !(view.getTag() instanceof C1582b)) {
                    view = this.mInflater.inflate(R.layout.er, viewGroup, false);
                    C1582b bVar2 = new C1582b((byte) 0);
                    bVar2.gBZ = (ImageView) view.findViewById(R.id.dt5);
                    bVar2.titleTv = (TextView) view.findViewById(R.id.gh0);
                    bVar2.hPW = (TextView) view.findViewById(R.id.hfo);
                    bVar2.jWr = view.findViewById(R.id.brt);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (C1582b) view.getTag();
                }
                WxaAttributes.WxaEntryInfo wxaEntryInfo = UR.BiN;
                com.tencent.mm.modelappbrand.a.b.aXY().a(bVar.gBZ, wxaEntryInfo.iconUrl, com.tencent.mm.modelappbrand.a.a.aXX(), com.tencent.mm.modelappbrand.a.g.iJB);
                bVar.titleTv.setText(Util.nullAsNil(wxaEntryInfo.title));
                if (Util.isNullOrNil(wxaEntryInfo.lgO)) {
                    bVar.hPW.setVisibility(4);
                } else {
                    bVar.hPW.setVisibility(0);
                    bVar.hPW.setText(wxaEntryInfo.lgO);
                }
                if (this.opg != null) {
                    View view2 = bVar.jWr;
                    if (UR.BiO) {
                        i3 = 8;
                    } else {
                        i3 = 0;
                    }
                    view2.setVisibility(i3);
                }
            } else {
                if (view == null || !(view.getTag() instanceof a)) {
                    view = this.mInflater.inflate(R.layout.ccs, viewGroup, false);
                    a aVar2 = new a((byte) 0);
                    aVar2.titleTv = (TextView) view.findViewById(R.id.ipq);
                    view.setTag(aVar2);
                    aVar = aVar2;
                } else {
                    aVar = (a) view.getTag();
                }
                aVar.titleTv.setText(UR.BcS);
            }
            AppMethodBeat.o(50071);
            return view;
        }

        /* renamed from: com.tencent.mm.plugin.profile.ui.WxaBindWxaInfoUI$b$b  reason: collision with other inner class name */
        static class C1582b {
            ImageView gBZ;
            TextView hPW;
            View jWr;
            TextView titleTv;

            private C1582b() {
            }

            /* synthetic */ C1582b(byte b2) {
                this();
            }
        }

        static class a {
            TextView titleTv;

            private a() {
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }
    }
}
