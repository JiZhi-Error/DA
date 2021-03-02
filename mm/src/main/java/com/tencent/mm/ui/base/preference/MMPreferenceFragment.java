package com.tencent.mm.ui.base.preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.preference.DialogPreference;
import com.tencent.mm.ui.base.preference.EditPreference;
import com.tencent.mm.ui.base.preference.Preference;

public abstract class MMPreferenceFragment extends MMFragment {
    private int OZf = 0;
    private int OZg = 0;
    protected boolean OZh;
    protected h adapter;
    private boolean dirty = false;
    private boolean isRefreshing = false;
    protected ListView list;
    private SharedPreferences sp;

    public abstract int getResourceId();

    public abstract boolean onPreferenceTreeClick(f fVar, Preference preference);

    @Override // com.tencent.mm.ui.MMFragment
    public int getLayoutId() {
        return R.layout.b_0;
    }

    @Override // com.tencent.mm.ui.MMFragment
    public View getLayoutView() {
        b.aBh();
        return b.c(getContext(), R.layout.b_0);
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onResume() {
        super.onResume();
        if (this.adapter != null) {
            this.adapter.notifyDataSetChanged();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.OZh = false;
        this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.list = (ListView) findViewById(16908298);
        this.adapter = new h(getContext(), this.list, this.sp);
        this.adapter.b(new Preference.a() {
            /* class com.tencent.mm.ui.base.preference.MMPreferenceFragment.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.preference.Preference.a
            public final boolean a(Preference preference, Object obj) {
                boolean z;
                AppMethodBeat.i(142614);
                if (!MMPreferenceFragment.this.isRefreshing && preference.isEnabled() && preference.OZu) {
                    MMPreferenceFragment.this.isRefreshing = true;
                    if (preference instanceof CheckBoxPreference) {
                        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
                        checkBoxPreference.setChecked(checkBoxPreference.isChecked());
                        if (checkBoxPreference.OZw) {
                            MMPreferenceFragment.this.sp.edit().putBoolean(preference.mKey, checkBoxPreference.isChecked()).commit();
                        }
                        MMPreferenceFragment.this.dirty = true;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (preference.mKey != null) {
                        MMPreferenceFragment.this.onPreferenceTreeClick(MMPreferenceFragment.this.adapter, preference);
                    }
                    if (z) {
                        MMPreferenceFragment.this.adapter.notifyDataSetChanged();
                    }
                    MMPreferenceFragment.this.isRefreshing = false;
                    if (z) {
                        AppMethodBeat.o(142614);
                        return true;
                    }
                }
                AppMethodBeat.o(142614);
                return false;
            }
        });
        this.list.setAdapter((ListAdapter) this.adapter);
        this.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.ui.base.preference.MMPreferenceFragment.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(142617);
                if (i2 < MMPreferenceFragment.this.list.getHeaderViewsCount()) {
                    AppMethodBeat.o(142617);
                    return;
                }
                final Preference preference = (Preference) MMPreferenceFragment.this.adapter.getItem(i2 - MMPreferenceFragment.this.list.getHeaderViewsCount());
                if (preference.isEnabled() && preference.OZu) {
                    if (preference instanceof CheckBoxPreference) {
                        AppMethodBeat.o(142617);
                        return;
                    }
                    if (preference instanceof DialogPreference) {
                        final DialogPreference dialogPreference = (DialogPreference) preference;
                        dialogPreference.showDialog();
                        dialogPreference.OXB = new DialogPreference.a() {
                            /* class com.tencent.mm.ui.base.preference.MMPreferenceFragment.AnonymousClass2.AnonymousClass1 */

                            @Override // com.tencent.mm.ui.base.preference.DialogPreference.a
                            public final void gLD() {
                                AppMethodBeat.i(142615);
                                MMPreferenceFragment.this.dirty = true;
                                if (dialogPreference.OZw) {
                                    MMPreferenceFragment.this.sp.edit().putString(preference.mKey, dialogPreference.getValue()).commit();
                                }
                                MMPreferenceFragment.this.adapter.notifyDataSetChanged();
                                AppMethodBeat.o(142615);
                            }
                        };
                    }
                    if (preference instanceof EditPreference) {
                        final EditPreference editPreference = (EditPreference) preference;
                        editPreference.showDialog();
                        editPreference.OXD = new EditPreference.a() {
                            /* class com.tencent.mm.ui.base.preference.MMPreferenceFragment.AnonymousClass2.AnonymousClass2 */

                            @Override // com.tencent.mm.ui.base.preference.EditPreference.a
                            public final void gLD() {
                                AppMethodBeat.i(142616);
                                MMPreferenceFragment.this.dirty = true;
                                if (editPreference.OZw) {
                                    MMPreferenceFragment.this.sp.edit().putString(preference.mKey, editPreference.value).commit();
                                }
                                MMPreferenceFragment.this.adapter.notifyDataSetChanged();
                                AppMethodBeat.o(142616);
                            }
                        };
                    }
                    if (preference.mKey != null) {
                        MMPreferenceFragment.this.onPreferenceTreeClick(MMPreferenceFragment.this.adapter, preference);
                    }
                }
                AppMethodBeat.o(142617);
            }
        });
        this.list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.ui.base.preference.MMPreferenceFragment.AnonymousClass3 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(142618);
                if (i2 < MMPreferenceFragment.this.list.getHeaderViewsCount()) {
                    AppMethodBeat.o(142618);
                    return false;
                }
                h hVar = MMPreferenceFragment.this.adapter;
                boolean onPreferenceTreeLongClick = MMPreferenceFragment.this.onPreferenceTreeLongClick(MMPreferenceFragment.this.adapter, (Preference) hVar.getItem(i2 - MMPreferenceFragment.this.list.getHeaderViewsCount()), MMPreferenceFragment.this.list);
                AppMethodBeat.o(142618);
                return onPreferenceTreeLongClick;
            }
        });
        if (this.OZg != 0) {
            this.list.setSelectionFromTop(0, this.OZg);
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    public final void gLO() {
        int resourceId;
        if (!this.OZh && (resourceId = getResourceId()) != -1) {
            this.adapter.addPreferencesFromResource(resourceId);
            this.OZh = true;
        }
    }

    public boolean onPreferenceTreeLongClick(f fVar, Preference preference, View view) {
        return false;
    }
}
