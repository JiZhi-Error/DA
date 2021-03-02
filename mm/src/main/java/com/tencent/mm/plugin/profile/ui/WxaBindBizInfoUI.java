package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
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
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WxaBindBizInfoUI extends MMActivity {
    private TextView Bdb;
    private ListView mListView;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(50065);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            AppMethodBeat.o(50065);
            return;
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.WxaBindBizInfoUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(50058);
                WxaBindBizInfoUI.this.finish();
                AppMethodBeat.o(50058);
                return false;
            }
        }, R.raw.actionbar_icon_dark_back);
        setMMTitle(R.string.pl);
        setActionbarColor(getActionbarColor());
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("wxa_entry_info_list");
        String stringExtra = getIntent().getStringExtra("register");
        View inflate = getLayoutInflater().inflate(R.layout.jc, (ViewGroup) null);
        this.Bdb = (TextView) inflate.findViewById(R.id.ipq);
        this.Bdb.setText(Util.isNullOrNil(stringExtra) ? getString(R.string.pl) : stringExtra);
        this.mListView = (ListView) findViewById(R.id.bke);
        this.mListView.addHeaderView(inflate);
        this.mListView.setAdapter((ListAdapter) new a(getLayoutInflater(), parcelableArrayListExtra));
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.WxaBindBizInfoUI.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(50059);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/WxaBindBizInfoUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                WxaAttributes.WxaEntryInfo wxaEntryInfo = (WxaAttributes.WxaEntryInfo) adapterView.getAdapter().getItem(i2);
                if (wxaEntryInfo == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/WxaBindBizInfoUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(50059);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("Contact_User", wxaEntryInfo.username);
                intent.putExtra("key_start_biz_profile_from_app_brand_profile", true);
                intent.putExtra("key_use_new_contact_profile", true);
                intent.putExtra("force_get_contact", true);
                c.b(WxaBindBizInfoUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/WxaBindBizInfoUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(50059);
            }
        });
        getContentView().setBackgroundResource(R.color.a74);
        AppMethodBeat.o(50065);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.cco;
    }

    static class a extends BaseAdapter {
        private LayoutInflater mInflater;
        private List<WxaAttributes.WxaEntryInfo> opg = new LinkedList();

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(50064);
            WxaAttributes.WxaEntryInfo Uz = Uz(i2);
            AppMethodBeat.o(50064);
            return Uz;
        }

        public a(LayoutInflater layoutInflater, List<WxaAttributes.WxaEntryInfo> list) {
            AppMethodBeat.i(50060);
            this.mInflater = layoutInflater;
            if (list != null) {
                this.opg.addAll(list);
            }
            AppMethodBeat.o(50060);
        }

        public final int getCount() {
            AppMethodBeat.i(50061);
            int size = this.opg.size();
            AppMethodBeat.o(50061);
            return size;
        }

        private WxaAttributes.WxaEntryInfo Uz(int i2) {
            AppMethodBeat.i(50062);
            WxaAttributes.WxaEntryInfo wxaEntryInfo = this.opg.get(i2);
            AppMethodBeat.o(50062);
            return wxaEntryInfo;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C1581a aVar;
            int i3;
            AppMethodBeat.i(50063);
            if (view == null) {
                view = this.mInflater.inflate(R.layout.er, viewGroup, false);
                C1581a aVar2 = new C1581a((byte) 0);
                aVar2.gBZ = (ImageView) view.findViewById(R.id.dt5);
                aVar2.titleTv = (TextView) view.findViewById(R.id.gh0);
                aVar2.hPW = (TextView) view.findViewById(R.id.hfo);
                aVar2.jWr = view.findViewById(R.id.brt);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (C1581a) view.getTag();
            }
            WxaAttributes.WxaEntryInfo Uz = Uz(i2);
            com.tencent.mm.modelappbrand.a.b.aXY().a(aVar.gBZ, Uz.iconUrl, com.tencent.mm.modelappbrand.a.a.aXX(), g.iJB);
            aVar.titleTv.setText(Util.nullAsNil(Uz.title));
            if (Util.isNullOrNil(Uz.lgO)) {
                aVar.hPW.setVisibility(8);
            } else {
                aVar.hPW.setVisibility(0);
                aVar.hPW.setText(Uz.lgO);
            }
            if (this.opg != null) {
                View view2 = aVar.jWr;
                if (this.opg.size() - 1 == i2) {
                    i3 = 8;
                } else {
                    i3 = 0;
                }
                view2.setVisibility(i3);
            }
            AppMethodBeat.o(50063);
            return view;
        }

        /* renamed from: com.tencent.mm.plugin.profile.ui.WxaBindBizInfoUI$a$a  reason: collision with other inner class name */
        static class C1581a {
            ImageView gBZ;
            TextView hPW;
            View jWr;
            TextView titleTv;

            private C1581a() {
            }

            /* synthetic */ C1581a(byte b2) {
                this();
            }
        }
    }
}
