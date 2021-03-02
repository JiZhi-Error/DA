package com.tencent.mm.ui.base.preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.DialogPreference;
import com.tencent.mm.ui.base.preference.EditPreference;
import com.tencent.mm.ui.base.preference.Preference;

public abstract class MMPreference extends MMActivity {
    public static final String TAG = "MicroMsg.mmui.MMPreference";
    private byte _hellAccFlag_;
    private h adapter;
    protected ImageView bannerCloseBtn;
    protected TextView bannerTv;
    protected RelativeLayout bannerView;
    private boolean dirty = false;
    private boolean isRefreshing = false;
    private ListView list;
    private SharedPreferences sp;

    public abstract int getResourceId();

    public abstract boolean onPreferenceTreeClick(f fVar, Preference preference);

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b_g;
    }

    /* access modifiers changed from: protected */
    public boolean autoRefresh() {
        return true;
    }

    public boolean dirty() {
        return this.dirty;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        if (autoRefresh()) {
            this.adapter.notifyDataSetChanged();
        }
        super.onResume();
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.list = (ListView) findViewById(16908298);
        this.adapter = createAdapter(this.sp);
        this.bannerView = (RelativeLayout) findViewById(R.id.gg6);
        this.bannerTv = (TextView) findViewById(R.id.gg5);
        this.bannerCloseBtn = (ImageView) findViewById(R.id.gg4);
        doPrepareData();
        int headerResourceId = getHeaderResourceId();
        View headerView = getHeaderView();
        if (headerResourceId != -1) {
            this.list.addHeaderView(getLayoutInflater().inflate(headerResourceId, (ViewGroup) null));
        } else if (headerView != null) {
            if (headerView.getLayoutParams() != null) {
                headerView.setLayoutParams(new AbsListView.LayoutParams(headerView.getLayoutParams()));
            } else {
                Log.e(TAG, "[arthurdan.mmpreference] Notice!!! header.getLayoutParams() is null!!!\n");
            }
            this.list.addHeaderView(headerView);
        }
        int footerResourceId = getFooterResourceId();
        View footerView = getFooterView();
        if (footerResourceId != -1) {
            this.list.addFooterView(getLayoutInflater().inflate(footerResourceId, (ViewGroup) null));
        } else if (footerView != null) {
            if (footerView.getLayoutParams() != null) {
                footerView.setLayoutParams(new AbsListView.LayoutParams(footerView.getLayoutParams()));
            } else {
                Log.e(TAG, "[arthurdan.mmpreference] Notice!!! footer.getLayoutParams() is null!!!\n");
            }
            this.list.addFooterView(footerView);
        }
        View bottomView = getBottomView();
        if (bottomView != null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.gg2);
            frameLayout.addView(bottomView);
            frameLayout.setVisibility(0);
        }
        setupList();
    }

    private void setupList() {
        this.adapter.b(new Preference.a() {
            /* class com.tencent.mm.ui.base.preference.MMPreference.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.preference.Preference.a
            public final boolean a(Preference preference, Object obj) {
                boolean z;
                AppMethodBeat.i(142585);
                if (!MMPreference.this.isRefreshing && preference.isEnabled() && preference.OZu) {
                    MMPreference.this.isRefreshing = true;
                    if (preference instanceof CheckBoxPreference) {
                        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
                        checkBoxPreference.setChecked(checkBoxPreference.isChecked());
                        if (checkBoxPreference.OZw) {
                            MMPreference.this.sp.edit().putBoolean(preference.mKey, checkBoxPreference.isChecked()).commit();
                        }
                        MMPreference.this.dirty = true;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (preference.mKey != null) {
                        MMPreference.this.onPreferenceTreeClick(MMPreference.this.adapter, preference);
                    }
                    if (z) {
                        MMPreference.this.adapter.notifyDataSetChanged();
                    }
                    MMPreference.this.isRefreshing = false;
                    if (z) {
                        AppMethodBeat.o(142585);
                        return true;
                    }
                }
                AppMethodBeat.o(142585);
                return false;
            }
        });
        int resourceId = getResourceId();
        if (resourceId != -1) {
            this.adapter.addPreferencesFromResource(resourceId);
        }
        this.list.setAdapter((ListAdapter) this.adapter);
        this.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.ui.base.preference.MMPreference.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(142588);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                a.b("com/tencent/mm/ui/base/preference/MMPreference$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                final Preference preference = (Preference) adapterView.getAdapter().getItem(i2);
                if (preference == null) {
                    a.a(this, "com/tencent/mm/ui/base/preference/MMPreference$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(142588);
                    return;
                }
                if (preference.isEnabled() && preference.OZu) {
                    if (preference instanceof CheckBoxPreference) {
                        a.a(this, "com/tencent/mm/ui/base/preference/MMPreference$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(142588);
                        return;
                    }
                    if (preference instanceof DialogPreference) {
                        final DialogPreference dialogPreference = (DialogPreference) preference;
                        dialogPreference.showDialog();
                        dialogPreference.OXB = new DialogPreference.a() {
                            /* class com.tencent.mm.ui.base.preference.MMPreference.AnonymousClass2.AnonymousClass1 */

                            @Override // com.tencent.mm.ui.base.preference.DialogPreference.a
                            public final void gLD() {
                                AppMethodBeat.i(142586);
                                MMPreference.this.dirty = true;
                                if (dialogPreference.OZw) {
                                    MMPreference.this.sp.edit().putString(preference.mKey, dialogPreference.getValue()).commit();
                                }
                                MMPreference.this.adapter.notifyDataSetChanged();
                                AppMethodBeat.o(142586);
                            }
                        };
                    }
                    if (preference instanceof EditPreference) {
                        final EditPreference editPreference = (EditPreference) preference;
                        editPreference.showDialog();
                        editPreference.OXD = new EditPreference.a() {
                            /* class com.tencent.mm.ui.base.preference.MMPreference.AnonymousClass2.AnonymousClass2 */

                            @Override // com.tencent.mm.ui.base.preference.EditPreference.a
                            public final void gLD() {
                                AppMethodBeat.i(142587);
                                MMPreference.this.dirty = true;
                                if (editPreference.OZw) {
                                    MMPreference.this.sp.edit().putString(preference.mKey, editPreference.value).commit();
                                }
                                MMPreference.this.adapter.notifyDataSetChanged();
                                AppMethodBeat.o(142587);
                            }
                        };
                    }
                    if (preference.mKey != null) {
                        MMPreference.this.onPreferenceTreeClick(MMPreference.this.adapter, preference);
                    }
                }
                a.a(this, "com/tencent/mm/ui/base/preference/MMPreference$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(142588);
            }
        });
        this.list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.ui.base.preference.MMPreference.AnonymousClass3 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(142589);
                if (i2 < MMPreference.this.list.getHeaderViewsCount()) {
                    AppMethodBeat.o(142589);
                    return false;
                }
                int headerViewsCount = i2 - MMPreference.this.list.getHeaderViewsCount();
                if (headerViewsCount >= MMPreference.this.adapter.getCount()) {
                    Log.e(MMPreference.TAG, "itemlongclick, outofindex, %d, %d", Integer.valueOf(headerViewsCount), Integer.valueOf(MMPreference.this.adapter.getCount()));
                    AppMethodBeat.o(142589);
                    return false;
                }
                boolean onPreferenceTreeLongClick = MMPreference.this.onPreferenceTreeLongClick(MMPreference.this.adapter, (Preference) MMPreference.this.adapter.getItem(headerViewsCount), MMPreference.this.list);
                AppMethodBeat.o(142589);
                return onPreferenceTreeLongClick;
            }
        });
        this.list.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.ui.base.preference.MMPreference.AnonymousClass4 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
                View currentFocus;
                AppMethodBeat.i(142590);
                if (1 == i2 && (currentFocus = MMPreference.this.getCurrentFocus()) != null) {
                    currentFocus.clearFocus();
                }
                AppMethodBeat.o(142590);
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            }
        });
    }

    /* access modifiers changed from: protected */
    public void doPrepareData() {
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    public f getPreferenceScreen() {
        return this.adapter;
    }

    public SharedPreferences getDefaultSharedPreferences() {
        return this.sp;
    }

    public boolean onPreferenceTreeLongClick(f fVar, Preference preference, View view) {
        return false;
    }

    public boolean onSetToTop() {
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(this.list);
        Object obj = new Object();
        a.a(obj, bl.axQ(), "com/tencent/mm/ui/base/preference/MMPreference", "onSetToTop", "()Z", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
        a.a(obj, "com/tencent/mm/ui/base/preference/MMPreference", "onSetToTop", "()Z", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        return true;
    }

    public void setSelection(int i2) {
        this.list.setSelection(i2);
    }

    public int getHeaderResourceId() {
        return -1;
    }

    public View getHeaderView() {
        return null;
    }

    public int getFooterResourceId() {
        return -1;
    }

    public View getFooterView() {
        return null;
    }

    public View getBottomView() {
        return null;
    }

    public void releaseUI() {
        this.list.setAdapter((ListAdapter) null);
    }

    public void createUI() {
        this.list.setAdapter((ListAdapter) this.adapter);
    }

    public h createAdapter(SharedPreferences sharedPreferences) {
        return new h(this, getListView(), sharedPreferences);
    }

    public void updateAdapter(h hVar) {
        this.adapter = hVar;
        setupList();
    }

    public ListView getListView() {
        return this.list;
    }
}
