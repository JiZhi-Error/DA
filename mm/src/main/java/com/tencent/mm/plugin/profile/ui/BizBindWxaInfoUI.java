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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class BizBindWxaInfoUI extends MMActivity {
    private TextView Bdb;
    private ListView Bdc;
    private String Bdd;
    private String Bde;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(50057);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            AppMethodBeat.o(50057);
            return;
        }
        this.Bdd = getIntent().getStringExtra("extra_username");
        this.Bde = getIntent().getStringExtra("extra_appid");
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.BizBindWxaInfoUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(50050);
                BizBindWxaInfoUI.this.finish();
                AppMethodBeat.o(50050);
                return false;
            }
        });
        setMMTitle(R.string.b9w);
        setActionbarColor(getActionbarColor());
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("extra_wxa_entry_info_list");
        View inflate = getLayoutInflater().inflate(R.layout.jc, (ViewGroup) null);
        this.Bdb = (TextView) inflate.findViewById(R.id.ipq);
        TextView textView = this.Bdb;
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(parcelableArrayListExtra != null ? parcelableArrayListExtra.size() : 0);
        textView.setText(getString(R.string.ago, objArr));
        this.Bdc = (ListView) findViewById(R.id.bke);
        this.Bdc.addHeaderView(inflate);
        this.Bdc.setAdapter((ListAdapter) new a(getLayoutInflater(), parcelableArrayListExtra));
        this.Bdc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.BizBindWxaInfoUI.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(50051);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/BizBindWxaInfoUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                WxaAttributes.WxaEntryInfo wxaEntryInfo = (WxaAttributes.WxaEntryInfo) adapterView.getAdapter().getItem(i2);
                if (wxaEntryInfo == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/BizBindWxaInfoUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(50051);
                    return;
                }
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1020;
                appBrandStatObject.dCw = BizBindWxaInfoUI.this.Bdd;
                ((r) g.af(r.class)).a(BizBindWxaInfoUI.this, wxaEntryInfo.username, null, 0, 0, null, appBrandStatObject, BizBindWxaInfoUI.this.Bde);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/BizBindWxaInfoUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(50051);
            }
        });
        getContentView().setBackgroundResource(R.color.a74);
        AppMethodBeat.o(50057);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.jd;
    }

    static class a extends BaseAdapter {
        private LayoutInflater mInflater;
        private List<WxaAttributes.WxaEntryInfo> opg = new LinkedList();

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(50056);
            WxaAttributes.WxaEntryInfo Uz = Uz(i2);
            AppMethodBeat.o(50056);
            return Uz;
        }

        public a(LayoutInflater layoutInflater, List<WxaAttributes.WxaEntryInfo> list) {
            AppMethodBeat.i(50052);
            this.mInflater = layoutInflater;
            if (list != null) {
                this.opg.addAll(list);
            }
            AppMethodBeat.o(50052);
        }

        public final int getCount() {
            AppMethodBeat.i(50053);
            int size = this.opg.size();
            AppMethodBeat.o(50053);
            return size;
        }

        private WxaAttributes.WxaEntryInfo Uz(int i2) {
            AppMethodBeat.i(50054);
            WxaAttributes.WxaEntryInfo wxaEntryInfo = this.opg.get(i2);
            AppMethodBeat.o(50054);
            return wxaEntryInfo;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C1580a aVar;
            int i3;
            AppMethodBeat.i(50055);
            if (view == null) {
                view = this.mInflater.inflate(R.layout.e8, viewGroup, false);
                C1580a aVar2 = new C1580a((byte) 0);
                aVar2.gBZ = (ImageView) view.findViewById(R.id.dt5);
                aVar2.titleTv = (TextView) view.findViewById(R.id.gh0);
                aVar2.jWr = view.findViewById(R.id.brt);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (C1580a) view.getTag();
            }
            WxaAttributes.WxaEntryInfo Uz = Uz(i2);
            com.tencent.mm.modelappbrand.a.b.aXY().a(aVar.gBZ, Uz.iconUrl, com.tencent.mm.modelappbrand.a.a.aXX(), com.tencent.mm.modelappbrand.a.g.iJB);
            aVar.titleTv.setText(Util.nullAsNil(Uz.title));
            if (this.opg != null) {
                View view2 = aVar.jWr;
                if (this.opg.size() - 1 == i2) {
                    i3 = 8;
                } else {
                    i3 = 0;
                }
                view2.setVisibility(i3);
            }
            AppMethodBeat.o(50055);
            return view;
        }

        /* renamed from: com.tencent.mm.plugin.profile.ui.BizBindWxaInfoUI$a$a  reason: collision with other inner class name */
        static class C1580a {
            ImageView gBZ;
            View jWr;
            TextView titleTv;

            private C1580a() {
            }

            /* synthetic */ C1580a(byte b2) {
                this();
            }
        }
    }
}
