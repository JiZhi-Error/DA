package com.tencent.weui.base.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.as;
import com.tencent.rtmp.sharp.jni.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class b extends BaseAdapter implements a {
    private final LinkedList<String> OYS = new LinkedList<>();
    private final HashMap<String, Preference> OYT = new HashMap<>();
    private final HashSet<String> OYU = new HashSet<>();
    private final LinkedList<String> OYV = new LinkedList<>();
    private final HashMap<String, Integer> OYW = new HashMap<>();
    private final HashMap<String, String> OYX = new HashMap<>();
    private int[] OYZ = new int[0];
    private boolean OZb = false;
    final c SwY;
    boolean SwZ = false;
    Preference.OnPreferenceChangeListener Sxa;
    private final Context context;
    private final SharedPreferences sp;

    public b(Context context2, SharedPreferences sharedPreferences) {
        AppMethodBeat.i(160001);
        this.SwY = new c(context2);
        this.context = context2;
        this.sp = sharedPreferences;
        AppMethodBeat.o(160001);
    }

    private static String b(Preference preference) {
        AppMethodBeat.i(160002);
        String str = preference.getClass().getName() + "L" + preference.getLayoutResource() + QLog.TAG_REPORTLEVEL_COLORUSER + preference.getWidgetLayoutResource();
        AppMethodBeat.o(160002);
        return str;
    }

    private static String c(Preference preference) {
        AppMethodBeat.i(160003);
        if (preference.getKey() == null || preference.getKey().length() <= 0) {
            String str = "_anonymous_pref@" + preference.hashCode();
            AppMethodBeat.o(160003);
            return str;
        }
        String key = preference.getKey();
        AppMethodBeat.o(160003);
        return key;
    }

    private static boolean alM(int i2) {
        return i2 == R.layout.b8j || i2 == R.layout.b_v || i2 == R.layout.b_y;
    }

    private static void a(Preference preference, SharedPreferences sharedPreferences) {
        AppMethodBeat.i(160004);
        if (preference instanceof CheckBoxPreference) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
            if (checkBoxPreference.isPersistent()) {
                checkBoxPreference.oD = sharedPreferences.getBoolean(preference.getKey(), ((CheckBoxPreference) preference).isChecked());
            }
        }
        AppMethodBeat.o(160004);
    }

    @Override // com.tencent.weui.base.preference.a
    public final void a(Preference preference) {
        AppMethodBeat.i(160005);
        a(preference, -1);
        if (!this.SwZ) {
            notifyDataSetChanged();
        }
        AppMethodBeat.o(160005);
    }

    private void a(Preference preference, int i2) {
        AppMethodBeat.i(160006);
        String c2 = c(preference);
        this.OYT.put(c2, preference);
        LinkedList<String> linkedList = this.OYS;
        if (i2 == -1) {
            i2 = this.OYS.size();
        }
        linkedList.add(i2, c2);
        if (!this.OYW.containsKey(b(preference)) && !this.OZb) {
            this.OYW.put(b(preference), Integer.valueOf(this.OYW.size()));
        }
        if (preference.getDependency() != null) {
            this.OYX.put(preference.getDependency() + "|" + preference.getKey(), preference.getKey());
        }
        AppMethodBeat.o(160006);
    }

    @Override // com.tencent.weui.base.preference.a
    public final Preference brv(String str) {
        AppMethodBeat.i(198549);
        Preference preference = this.OYT.get(str);
        AppMethodBeat.o(198549);
        return preference;
    }

    public final int getCount() {
        AppMethodBeat.i(160008);
        int size = this.OYV.size();
        AppMethodBeat.o(160008);
        return size;
    }

    public final Object getItem(int i2) {
        AppMethodBeat.i(160009);
        Preference preference = this.OYT.get(this.OYV.get(i2));
        AppMethodBeat.o(160009);
        return preference;
    }

    public final long getItemId(int i2) {
        return 0;
    }

    public final int getViewTypeCount() {
        AppMethodBeat.i(160010);
        if (!this.OZb) {
            this.OZb = true;
        }
        int max = Math.max(1, this.OYW.size());
        AppMethodBeat.o(160010);
        return max;
    }

    public final int getItemViewType(int i2) {
        AppMethodBeat.i(160011);
        if (i2 > this.OYV.size()) {
            AppMethodBeat.o(160011);
            return -1;
        }
        Integer num = this.OYW.get(b(this.OYT.get(this.OYV.get(i2))));
        if (num == null) {
            AppMethodBeat.o(160011);
            return -1;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(160011);
        return intValue;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        int i3;
        int i4;
        AppMethodBeat.i(160012);
        if (i2 > this.OYV.size()) {
            AppMethodBeat.o(160012);
        } else {
            Preference preference = this.OYT.get(this.OYV.get(i2));
            if (preference instanceof CheckBoxPreference) {
                preference.setOnPreferenceChangeListener(this.Sxa);
            }
            if (!this.OYW.containsKey(b(preference))) {
                view = null;
            }
            view = preference.getView(view, viewGroup);
            int i5 = this.OYZ[i2];
            View findViewById = view.findViewById(R.id.be9);
            if (findViewById == null) {
                as.d("MicroMsg.WeUIPreferenceAdapter", "find content view error", new Object[0]);
                AppMethodBeat.o(160012);
            } else {
                View findViewById2 = view.findViewById(16908312);
                if ((i5 & 4) == 0) {
                    int i6 = 0;
                    int paddingLeft = findViewById.getPaddingLeft();
                    int paddingRight = findViewById.getPaddingRight();
                    int paddingTop = findViewById.getPaddingTop();
                    int paddingBottom = findViewById.getPaddingBottom();
                    int paddingLeft2 = view.getPaddingLeft();
                    int paddingRight2 = view.getPaddingRight();
                    int paddingTop2 = view.getPaddingTop();
                    int paddingBottom2 = view.getPaddingBottom();
                    if ((i5 & 8) != 0) {
                        if (i2 == this.OYV.size() - 1 || (i2 == this.OYV.size() - 2 && (getItem(this.OYV.size() - 1) instanceof PreferenceCategory))) {
                            i4 = R.drawable.aij;
                        } else if ((i5 & 2) != 0) {
                            i4 = R.drawable.aij;
                        } else {
                            i4 = R.drawable.b9w;
                        }
                        i3 = R.color.afz;
                        i6 = i4;
                    } else if ((i5 & 16) != 0 || (i5 & 2) == 0) {
                        i6 = R.drawable.b9w;
                        i3 = R.drawable.asu;
                    } else {
                        i3 = R.drawable.asu;
                    }
                    findViewById.setBackgroundResource(i6);
                    findViewById.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    if (findViewById2 != null) {
                        findViewById2.setBackgroundResource(i6);
                    }
                    view.setBackgroundResource(i3);
                    view.setPadding(paddingLeft2, paddingTop2, paddingRight2, paddingBottom2);
                }
                AppMethodBeat.o(160012);
            }
        }
        return view;
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.i(160007);
        this.OYV.clear();
        Iterator<String> it = this.OYS.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!this.OYU.contains(next)) {
                if (this.OYT.get(next) == null) {
                    as.e("MicroMsg.WeUIPreferenceAdapter", "not found pref by key ".concat(String.valueOf(next)), new Object[0]);
                } else {
                    this.OYV.add(next);
                }
            }
        }
        if (!this.OYV.isEmpty() && alM(this.OYT.get(this.OYV.get(0)).getLayoutResource())) {
            a(new PreferenceSmallCategory(this.context), 0);
        }
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.OYV.size(); i2++) {
            this.OYT.get(this.OYV.get(i2));
            if (i2 != 0) {
                this.OYT.get(this.OYV.get(i2 - 1));
            }
        }
        this.OYV.removeAll(hashSet);
        this.OYZ = new int[this.OYV.size()];
        if (this.OYZ.length <= 0) {
            AppMethodBeat.o(160007);
        } else if (this.OYZ.length == 1) {
            int layoutResource = this.OYT.get(this.OYV.get(0)).getLayoutResource();
            Preference preference = this.OYT.get(this.OYV.get(0));
            if (!alM(layoutResource)) {
                this.OYZ[0] = 4;
            } else if (preference instanceof CheckBoxPreference) {
                int[] iArr = this.OYZ;
                iArr[0] = iArr[0] | 8;
            } else {
                this.OYZ[0] = 3;
            }
            a(this.OYT.get(this.OYV.get(0)), this.sp);
            super.notifyDataSetChanged();
            AppMethodBeat.o(160007);
        } else {
            for (int i3 = 0; i3 < this.OYV.size(); i3++) {
                a(this.OYT.get(this.OYV.get(i3)), this.sp);
                Preference preference2 = this.OYT.get(this.OYV.get(i3));
                int layoutResource2 = preference2.getLayoutResource();
                if (alM(layoutResource2)) {
                    if (preference2 instanceof CheckBoxPreference) {
                        int[] iArr2 = this.OYZ;
                        iArr2[i3] = iArr2[i3] | 8;
                    } else if (i3 == 0) {
                        int[] iArr3 = this.OYZ;
                        iArr3[i3] = iArr3[i3] | 1;
                    } else {
                        if (i3 == this.OYV.size() - 1) {
                            int[] iArr4 = this.OYZ;
                            iArr4[i3] = iArr4[i3] | 2;
                        }
                        int layoutResource3 = this.OYT.get(this.OYV.get(i3 - 1)).getLayoutResource();
                        if (layoutResource3 != R.layout.b8j || layoutResource3 == R.layout.b_v || layoutResource3 == R.layout.b_y) {
                            int[] iArr5 = this.OYZ;
                            iArr5[i3] = iArr5[i3] | 1;
                        }
                    }
                } else if (layoutResource2 != R.layout.b_7) {
                    int[] iArr6 = this.OYZ;
                    iArr6[i3] = iArr6[i3] | 4;
                    if (i3 != 0) {
                        int layoutResource4 = this.OYT.get(this.OYV.get(i3 - 1)).getLayoutResource();
                        if (alM(layoutResource4) || layoutResource4 == R.layout.b_7) {
                            int[] iArr7 = this.OYZ;
                            int i4 = i3 - 1;
                            iArr7[i4] = iArr7[i4] | 2;
                        }
                    }
                } else if (i3 == 0) {
                    int[] iArr8 = this.OYZ;
                    iArr8[i3] = iArr8[i3] | 4;
                } else {
                    int[] iArr9 = this.OYZ;
                    iArr9[i3] = iArr9[i3] | 16;
                    int layoutResource5 = this.OYT.get(this.OYV.get(i3 - 1)).getLayoutResource();
                    if (layoutResource5 == R.layout.b8j || layoutResource5 == R.layout.b_v || layoutResource5 == R.layout.b_y) {
                        int[] iArr10 = this.OYZ;
                        int i5 = i3 - 1;
                        iArr10[i5] = iArr10[i5] | 2;
                    }
                }
            }
            super.notifyDataSetChanged();
            AppMethodBeat.o(160007);
        }
    }
}
