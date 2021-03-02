package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.rtmp.sharp.jni.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class h extends BaseAdapter implements f {
    private Preference.a OXy;
    private final i OYR;
    private final LinkedList<String> OYS = new LinkedList<>();
    private final HashMap<String, Preference> OYT = new HashMap<>();
    private final HashSet<String> OYU = new HashSet<>();
    private final LinkedList<String> OYV = new LinkedList<>();
    private final HashMap<String, Integer> OYW = new HashMap<>();
    private final HashMap<String, String> OYX = new HashMap<>();
    public a OYY;
    private int[] OYZ = new int[0];
    private boolean OZa = false;
    private boolean OZb = false;
    private long OZc = 0;
    public long OZd = 0;
    protected final Context context;
    private ListView krb;
    private MMHandler mHandler = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.ui.base.preference.h.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(205294);
            h.a(h.this);
            h.this.OZc = System.currentTimeMillis();
            AppMethodBeat.o(205294);
        }
    };
    private final SharedPreferences sp;

    public interface a {
        int UX(int i2);

        boolean UY(int i2);

        int UZ(int i2);

        View getView(int i2, View view, ViewGroup viewGroup);
    }

    static /* synthetic */ void a(h hVar) {
        AppMethodBeat.i(205300);
        hVar.gLN();
        AppMethodBeat.o(205300);
    }

    public h(Context context2, ListView listView, SharedPreferences sharedPreferences) {
        AppMethodBeat.i(142591);
        this.OYR = new i(context2);
        this.context = context2;
        this.krb = listView;
        this.sp = sharedPreferences;
        AppMethodBeat.o(142591);
    }

    private static String f(Preference preference) {
        AppMethodBeat.i(142592);
        String str = preference.getClass().getName() + "L" + preference.getLayoutResource() + QLog.TAG_REPORTLEVEL_COLORUSER + preference.OZG;
        AppMethodBeat.o(142592);
        return str;
    }

    @Override // com.tencent.mm.ui.base.preference.f
    public final int indexOf(String str) {
        AppMethodBeat.i(142594);
        int indexOf = this.OYS.indexOf(str);
        AppMethodBeat.o(142594);
        return indexOf;
    }

    @Override // com.tencent.mm.ui.base.preference.f
    public final int bmj(String str) {
        AppMethodBeat.i(142595);
        if (this.OYV == null) {
            AppMethodBeat.o(142595);
            return -1;
        }
        int indexOf = this.OYV.indexOf(str);
        AppMethodBeat.o(142595);
        return indexOf;
    }

    @Override // com.tencent.mm.ui.base.preference.f
    public final void c(Preference preference) {
        AppMethodBeat.i(259384);
        a(preference, -1);
        AppMethodBeat.o(259384);
    }

    @Override // com.tencent.mm.ui.base.preference.f
    public final void d(Preference preference) {
        AppMethodBeat.i(142597);
        b(preference, -1);
        AppMethodBeat.o(142597);
    }

    @Override // com.tencent.mm.ui.base.preference.f
    public final void a(Preference preference, int i2) {
        AppMethodBeat.i(142598);
        b(preference, i2);
        if (!this.OZa) {
            notifyDataSetChanged();
        }
        AppMethodBeat.o(142598);
    }

    private void b(Preference preference, int i2) {
        AppMethodBeat.i(142599);
        String g2 = g(preference);
        this.OYT.put(g2, preference);
        LinkedList<String> linkedList = this.OYS;
        if (i2 == -1) {
            i2 = this.OYS.size();
        }
        linkedList.add(i2, g2);
        if (!this.OYW.containsKey(f(preference)) && this.OZa) {
            this.OYW.put(f(preference), Integer.valueOf(this.OYW.size()));
        }
        if (preference.OZx != null) {
            this.OYX.put(preference.OZx + "|" + preference.mKey, preference.mKey);
        }
        AppMethodBeat.o(142599);
    }

    @Override // com.tencent.mm.ui.base.preference.f
    public final Preference bmg(String str) {
        AppMethodBeat.i(142600);
        Preference preference = this.OYT.get(str);
        AppMethodBeat.o(142600);
        return preference;
    }

    @Override // com.tencent.mm.ui.base.preference.f
    /* renamed from: do  reason: not valid java name */
    public final CheckBoxPreference m39do(String str, boolean z) {
        AppMethodBeat.i(142601);
        if (z) {
            if (!this.OYU.contains(str)) {
                this.OYU.add(str);
            } else {
                AppMethodBeat.o(142601);
                return null;
            }
        } else if (!this.OYU.remove(str)) {
            AppMethodBeat.o(142601);
            return null;
        }
        notifyDataSetChanged();
        AppMethodBeat.o(142601);
        return null;
    }

    @Override // com.tencent.mm.ui.base.preference.f
    public final boolean bmh(String str) {
        AppMethodBeat.i(205296);
        if (!this.OYU.contains(str)) {
            AppMethodBeat.o(205296);
            return true;
        }
        AppMethodBeat.o(205296);
        return false;
    }

    @Override // com.tencent.mm.ui.base.preference.f
    public final boolean e(Preference preference) {
        AppMethodBeat.i(142602);
        if (preference == null) {
            AppMethodBeat.o(142602);
            return false;
        }
        String g2 = g(preference);
        this.OYS.remove(g2);
        this.OYT.remove(g2);
        this.OYU.remove(preference.mKey);
        notifyDataSetChanged();
        AppMethodBeat.o(142602);
        return true;
    }

    @Override // com.tencent.mm.ui.base.preference.f
    public final boolean bmi(String str) {
        AppMethodBeat.i(142603);
        boolean e2 = e(bmg(str));
        AppMethodBeat.o(142603);
        return e2;
    }

    @Override // com.tencent.mm.ui.base.preference.f
    public final void removeAll() {
        AppMethodBeat.i(142604);
        this.OYV.clear();
        this.OYT.clear();
        this.OYS.clear();
        this.OYU.clear();
        notifyDataSetChanged();
        AppMethodBeat.o(142604);
    }

    @Override // com.tencent.mm.ui.base.preference.f
    public final void addPreferencesFromResource(int i2) {
        AppMethodBeat.i(142605);
        this.OZa = true;
        this.OYR.a(i2, this);
        this.OZa = false;
        if (this.krb != null) {
            this.krb.setAdapter((ListAdapter) this);
        }
        notifyDataSetChanged();
        AppMethodBeat.o(142605);
    }

    public final void b(Preference.a aVar) {
        AppMethodBeat.i(142606);
        this.OXy = aVar;
        notifyDataSetChanged();
        AppMethodBeat.o(142606);
    }

    private void gLL() {
        AppMethodBeat.i(205297);
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.OYV.size(); i2++) {
            Preference preference = this.OYT.get(this.OYV.get(i2));
            if ((preference instanceof PreferenceCategory) && Util.isNullOrNil(preference.mKey) && i2 != 0) {
                Preference preference2 = this.OYT.get(this.OYV.get(i2 - 1));
                if (preference2 instanceof PreferenceCategory) {
                    if (Util.isNullOrNil(preference2.mKey) && (preference2.getTitle() == null || preference2.getTitle().toString().trim().length() <= 0)) {
                        hashSet.add(g(preference2));
                    } else if (Util.isNullOrNil(preference.mKey) && (preference.getTitle() == null || preference.getTitle().toString().trim().length() <= 0)) {
                        hashSet.add(g(preference));
                    }
                }
            }
        }
        this.OYV.removeAll(hashSet);
        AppMethodBeat.o(205297);
    }

    private void gLM() {
        AppMethodBeat.i(205298);
        this.OYV.clear();
        Iterator<String> it = this.OYS.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!this.OYU.contains(next)) {
                if (this.OYT.get(next) == null) {
                    Log.e("MicroMsg.MMPreferenceAdapter", "not found pref by key ".concat(String.valueOf(next)));
                } else {
                    this.OYV.add(next);
                }
            }
        }
        if (!this.OYV.isEmpty()) {
            this.OYT.get(this.OYV.get(0));
        }
        AppMethodBeat.o(205298);
    }

    private static boolean alM(int i2) {
        return i2 == R.layout.b8j || i2 == R.layout.b_v || i2 == R.layout.b_y;
    }

    @Override // com.tencent.mm.ui.base.preference.f
    public void notifyDataSetChanged() {
        boolean z;
        AppMethodBeat.i(142607);
        if (ao.gJK()) {
            int a2 = ((b) g.af(b.class)).a(b.a.clicfg_hwmagic_mmpreference_notify_switch, 1);
            Log.d("MicroMsg.MMPreferenceAdapter", "isHWMagicMMPreferenceNotifySwt() swt:%s", Integer.valueOf(a2));
            if (a2 == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Log.d("MicroMsg.MMPreferenceAdapter", "MMPreferenceAdapter notifyDataSetChanged %s %s %s", Integer.valueOf(hashCode()), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.OZd));
                long currentTimeMillis = System.currentTimeMillis();
                if (this.OZd == 0 || currentTimeMillis - this.OZd <= 5000 || currentTimeMillis - this.OZc >= 1000) {
                    gLN();
                    this.OZc = currentTimeMillis;
                    AppMethodBeat.o(142607);
                    return;
                }
                boolean hasMessages = this.mHandler.hasMessages(1);
                Log.i("MicroMsg.MMPreferenceAdapter", "ignore notifyDataSetChanged(%s %s), had:%s", Long.valueOf(this.OZc), Long.valueOf(currentTimeMillis), Boolean.valueOf(hasMessages));
                if (!hasMessages) {
                    this.mHandler.sendEmptyMessageDelayed(1, 1000);
                }
                AppMethodBeat.o(142607);
                return;
            }
        }
        gLN();
        AppMethodBeat.o(142607);
    }

    private void gLN() {
        AppMethodBeat.i(205299);
        gLM();
        gLL();
        this.OYZ = new int[this.OYV.size()];
        if (this.OYZ.length <= 0) {
            AppMethodBeat.o(205299);
        } else if (this.OYZ.length == 1) {
            int layoutResource = this.OYT.get(this.OYV.get(0)).getLayoutResource();
            Preference preference = this.OYT.get(this.OYV.get(0));
            if (!alM(layoutResource)) {
                this.OYZ[0] = 4;
            } else if (preference instanceof CheckBoxPreference) {
                int[] iArr = this.OYZ;
                iArr[0] = iArr[0] | 8;
                int[] iArr2 = this.OYZ;
                iArr2[0] = iArr2[0] | 1;
            } else {
                this.OYZ[0] = 3;
            }
            a(this.OYT.get(this.OYV.get(0)), this.sp);
            super.notifyDataSetChanged();
            AppMethodBeat.o(205299);
        } else {
            for (int i2 = 0; i2 < this.OYV.size(); i2++) {
                a(this.OYT.get(this.OYV.get(i2)), this.sp);
                Preference preference2 = this.OYT.get(this.OYV.get(i2));
                int layoutResource2 = preference2.getLayoutResource();
                if (alM(layoutResource2)) {
                    if (preference2 instanceof CheckBoxPreference) {
                        int[] iArr3 = this.OYZ;
                        iArr3[i2] = iArr3[i2] | 8;
                    }
                    if (i2 == 0) {
                        int[] iArr4 = this.OYZ;
                        iArr4[i2] = iArr4[i2] | 1;
                        int[] iArr5 = this.OYZ;
                        iArr5[i2] = iArr5[i2] | 16;
                    } else {
                        if (i2 == this.OYV.size() - 1) {
                            int[] iArr6 = this.OYZ;
                            iArr6[i2] = iArr6[i2] | 2;
                        }
                        int layoutResource3 = this.OYT.get(this.OYV.get(i2 - 1)).getLayoutResource();
                        if (layoutResource3 != R.layout.b8j || layoutResource3 == R.layout.b_v || layoutResource3 == R.layout.b_y) {
                            int[] iArr7 = this.OYZ;
                            iArr7[i2] = iArr7[i2] | 1;
                        }
                    }
                } else if (layoutResource2 != R.layout.b_7) {
                    int[] iArr8 = this.OYZ;
                    iArr8[i2] = iArr8[i2] | 4;
                    if (i2 == 0) {
                        int[] iArr9 = this.OYZ;
                        iArr9[i2] = iArr9[i2] | 16;
                    } else {
                        int layoutResource4 = this.OYT.get(this.OYV.get(i2 - 1)).getLayoutResource();
                        if (alM(layoutResource4) || layoutResource4 == R.layout.b_7) {
                            int[] iArr10 = this.OYZ;
                            int i3 = i2 - 1;
                            iArr10[i3] = iArr10[i3] | 2;
                        }
                    }
                } else if (i2 == 0) {
                    int[] iArr11 = this.OYZ;
                    iArr11[i2] = iArr11[i2] | 4;
                    int[] iArr12 = this.OYZ;
                    iArr12[i2] = iArr12[i2] | 16;
                } else {
                    int layoutResource5 = this.OYT.get(this.OYV.get(i2 - 1)).getLayoutResource();
                    if (layoutResource5 == R.layout.b8j || layoutResource5 == R.layout.b_v || layoutResource5 == R.layout.b_y) {
                        int[] iArr13 = this.OYZ;
                        int i4 = i2 - 1;
                        iArr13[i4] = iArr13[i4] | 2;
                    }
                }
            }
            super.notifyDataSetChanged();
            AppMethodBeat.o(205299);
        }
    }

    private static void a(Preference preference, SharedPreferences sharedPreferences) {
        AppMethodBeat.i(142608);
        if (preference instanceof CheckBoxPreference) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
            if (checkBoxPreference.OZw) {
                checkBoxPreference.setChecked(sharedPreferences.getBoolean(preference.mKey, ((CheckBoxPreference) preference).isChecked()));
            }
        }
        if (preference instanceof DialogPreference) {
            DialogPreference dialogPreference = (DialogPreference) preference;
            if (dialogPreference.OZw) {
                dialogPreference.setValue(sharedPreferences.getString(preference.mKey, null));
            }
        }
        if (preference instanceof EditPreference) {
            EditPreference editPreference = (EditPreference) preference;
            if (editPreference.OZw) {
                editPreference.value = sharedPreferences.getString(preference.mKey, null);
                editPreference.setSummary(editPreference.value);
            }
        }
        AppMethodBeat.o(142608);
    }

    public int getCount() {
        AppMethodBeat.i(142609);
        if (this.OYY != null) {
            int UX = this.OYY.UX(this.OYV.size());
            AppMethodBeat.o(142609);
            return UX;
        }
        int size = this.OYV.size();
        AppMethodBeat.o(142609);
        return size;
    }

    public Object getItem(int i2) {
        AppMethodBeat.i(142610);
        if (this.OYY != null) {
            if (this.OYY.UY(i2)) {
                AppMethodBeat.o(142610);
                return null;
            }
            i2 = this.OYY.UZ(i2);
        }
        Preference preference = this.OYT.get(this.OYV.get(i2));
        AppMethodBeat.o(142610);
        return preference;
    }

    public long getItemId(int i2) {
        return 0;
    }

    public int getViewTypeCount() {
        AppMethodBeat.i(142611);
        if (!this.OZb) {
            this.OZb = true;
        }
        int max = Math.max(1, this.OYW.size());
        AppMethodBeat.o(142611);
        return max;
    }

    public int getItemViewType(int i2) {
        AppMethodBeat.i(142612);
        if (i2 > this.OYV.size() - 1) {
            AppMethodBeat.o(142612);
            return -1;
        }
        Integer num = this.OYW.get(f(this.OYT.get(this.OYV.get(i2))));
        if (num == null) {
            AppMethodBeat.o(142612);
            return -1;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(142612);
        return intValue;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(142613);
        if (this.OYY != null) {
            if (this.OYY.UY(i2)) {
                View view2 = this.OYY.getView(i2, view, viewGroup);
                AppMethodBeat.o(142613);
                return view2;
            }
            i2 = this.OYY.UZ(i2);
        }
        if (i2 > this.OYV.size()) {
            AppMethodBeat.o(142613);
            return view;
        }
        Preference preference = this.OYT.get(this.OYV.get(i2));
        if (preference instanceof CheckBoxPreference) {
            preference.a(this.OXy);
        }
        if (!this.OYW.containsKey(f(preference))) {
            view = null;
        }
        View view3 = preference.getView(view, viewGroup);
        int i3 = this.OYZ[i2];
        View findViewById = view3.findViewById(R.id.be9);
        View findViewById2 = view3.findViewById(R.id.it2);
        if (findViewById == null) {
            Log.d("MicroMsg.MMPreferenceAdapter", "find content view error");
        }
        if (findViewById != null) {
            View findViewById3 = findViewById.findViewById(R.id.iqp);
            findViewById.getPaddingLeft();
            findViewById.getPaddingRight();
            findViewById.getPaddingTop();
            findViewById.getPaddingBottom();
            int paddingLeft = view3.getPaddingLeft();
            int paddingRight = view3.getPaddingRight();
            int paddingTop = view3.getPaddingTop();
            int paddingBottom = view3.getPaddingBottom();
            if ((i3 & 2) != 0) {
                int paddingLeft2 = findViewById.getPaddingLeft();
                findViewById.setBackground(at.aN(this.context, R.attr.sg));
                findViewById.setPadding(paddingLeft2, 0, 0, 0);
                if (!(findViewById3 == null || findViewById3.getBackground() == null)) {
                    findViewById3.setBackground(null);
                }
            } else if (findViewById3 != null) {
                int paddingTop2 = findViewById3.getPaddingTop();
                int paddingBottom2 = findViewById3.getPaddingBottom();
                findViewById3.setBackground(at.aN(this.context, R.attr.sg));
                findViewById3.setPadding(0, paddingTop2, 0, paddingBottom2);
                if (!(findViewById == null || findViewById.getBackground() == null)) {
                    findViewById.setBackground(null);
                }
            }
            view3.setBackgroundResource(R.drawable.asu);
            view3.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
        if (findViewById2 != null) {
            if ((i3 & 1) != 0) {
                findViewById2.setVisibility(0);
            } else {
                findViewById2.setVisibility(8);
            }
        }
        AppMethodBeat.o(142613);
        return view3;
    }

    private static String g(Preference preference) {
        AppMethodBeat.i(142593);
        if (preference.mKey == null || preference.mKey.length() <= 0) {
            String str = "_anonymous_pref@" + preference.hashCode();
            AppMethodBeat.o(142593);
            return str;
        }
        String str2 = preference.mKey;
        AppMethodBeat.o(142593);
        return str2;
    }
}
