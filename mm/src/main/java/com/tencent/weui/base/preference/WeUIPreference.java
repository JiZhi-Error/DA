package com.tencent.weui.base.preference;

import android.content.SharedPreferences;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.preference.Preference;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.BaseActivity;
import com.tencent.mm.ui.as;

public abstract class WeUIPreference extends BaseActivity {
    private b SwW;
    protected ImageView bannerCloseBtn;
    protected TextView bannerTv;
    protected RelativeLayout bannerView;
    private boolean dirty = false;
    private boolean isRefreshing = false;
    private ListView list;
    private SharedPreferences sp;

    public abstract boolean a(a aVar, Preference preference);

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.BaseActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.BaseActivity
    public final int getLayoutId() {
        return R.layout.b_g;
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        this.SwW.notifyDataSetChanged();
        super.onResume();
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.SwW = new b(this, this.sp);
        this.list = (ListView) findViewById(16908298);
        this.bannerView = (RelativeLayout) findViewById(R.id.gg6);
        this.bannerTv = (TextView) findViewById(R.id.gg5);
        this.bannerCloseBtn = (ImageView) findViewById(R.id.gg4);
        int footerResourceId = getFooterResourceId();
        if (footerResourceId != -1) {
            this.list.addFooterView(getLayoutInflater().inflate(footerResourceId, (ViewGroup) null));
        }
        b bVar = this.SwW;
        bVar.Sxa = new Preference.OnPreferenceChangeListener() {
            /* class com.tencent.weui.base.preference.WeUIPreference.AnonymousClass1 */

            public final boolean onPreferenceChange(Preference preference, Object obj) {
                boolean z;
                AppMethodBeat.i(159997);
                if (!WeUIPreference.this.isRefreshing && preference.isEnabled() && preference.isSelectable()) {
                    WeUIPreference.this.isRefreshing = true;
                    if (preference instanceof CheckBoxPreference) {
                        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
                        checkBoxPreference.oD = checkBoxPreference.isChecked();
                        if (checkBoxPreference.isPersistent()) {
                            WeUIPreference.this.sp.edit().putBoolean(preference.getKey(), checkBoxPreference.isChecked()).commit();
                        }
                        WeUIPreference.this.dirty = true;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (preference.getKey() != null) {
                        WeUIPreference.this.a(WeUIPreference.this.SwW, preference);
                    }
                    if (z) {
                        WeUIPreference.this.SwW.notifyDataSetChanged();
                    }
                    WeUIPreference.this.isRefreshing = false;
                    if (z) {
                        AppMethodBeat.o(159997);
                        return true;
                    }
                }
                AppMethodBeat.o(159997);
                return false;
            }
        };
        bVar.notifyDataSetChanged();
        b bVar2 = this.SwW;
        bVar2.SwZ = true;
        c cVar = bVar2.SwY;
        XmlResourceParser xml = cVar.mContext.getResources().getXml(R.xml.f3182i);
        if (xml != null) {
            try {
                cVar.a(xml, bVar2);
            } finally {
                xml.close();
            }
        }
        bVar2.SwZ = false;
        bVar2.notifyDataSetChanged();
        this.list.setAdapter((ListAdapter) this.SwW);
        this.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.weui.base.preference.WeUIPreference.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(159998);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                a.b("com/tencent/weui/base/preference/WeUIPreference$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                Preference preference = (Preference) adapterView.getAdapter().getItem(i2);
                if (preference == null) {
                    a.a(this, "com/tencent/weui/base/preference/WeUIPreference$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(159998);
                    return;
                }
                if (preference.isEnabled() && preference.isSelectable()) {
                    if (preference instanceof CheckBoxPreference) {
                        a.a(this, "com/tencent/weui/base/preference/WeUIPreference$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(159998);
                        return;
                    } else if (preference.getKey() != null) {
                        WeUIPreference.this.a(WeUIPreference.this.SwW, preference);
                    }
                }
                a.a(this, "com/tencent/weui/base/preference/WeUIPreference$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(159998);
            }
        });
        this.list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.weui.base.preference.WeUIPreference.AnonymousClass3 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(159999);
                if (i2 < WeUIPreference.this.list.getHeaderViewsCount()) {
                    AppMethodBeat.o(159999);
                } else {
                    int headerViewsCount = i2 - WeUIPreference.this.list.getHeaderViewsCount();
                    if (headerViewsCount >= WeUIPreference.this.SwW.getCount()) {
                        as.e("MicroMsg.mmui.WeUIPreference", "itemlongclick, outofindex, %d, %d", Integer.valueOf(headerViewsCount), Integer.valueOf(WeUIPreference.this.SwW.getCount()));
                        AppMethodBeat.o(159999);
                    } else {
                        WeUIPreference.this.SwW.getItem(headerViewsCount);
                        b unused = WeUIPreference.this.SwW;
                        ListView unused2 = WeUIPreference.this.list;
                        AppMethodBeat.o(159999);
                    }
                }
                return false;
            }
        });
        this.list.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.weui.base.preference.WeUIPreference.AnonymousClass4 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
                View currentFocus;
                AppMethodBeat.i(160000);
                if (1 == i2 && (currentFocus = WeUIPreference.this.getCurrentFocus()) != null) {
                    currentFocus.clearFocus();
                }
                AppMethodBeat.o(160000);
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            }
        });
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    public final a hrD() {
        return this.SwW;
    }

    public int getFooterResourceId() {
        return -1;
    }
}
