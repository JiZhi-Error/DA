package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.u;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u0000 \u00042\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0005¢\u0006\u0002\u0010\u0002¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/SettingHelper;", "", "()V", "ChoiceItem", "Companion", "DebugBoxPref", "DebugChoicePref", "DebugClickPref", "IPreferenceEvent", "plugin-finder_release"})
public final class j {
    public static final b vQd = new b((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/SettingHelper$IPreferenceEvent;", "", "doSomething", "", "refresh", "plugin-finder_release"})
    public interface f {
        void dAo();

        void refresh();
    }

    static {
        AppMethodBeat.i(252820);
        AppMethodBeat.o(252820);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/SettingHelper$Companion;", "", "()V", "TAG", "", "VERSION_TAG", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/SettingHelper$DebugClickPref;", "Lcom/tencent/mm/ui/base/preference/Preference;", "Lcom/tencent/mm/plugin/finder/ui/SettingHelper$IPreferenceEvent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/base/preference/MMPreference;", "config", "Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "(Lcom/tencent/mm/ui/base/preference/MMPreference;Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;)V", "getActivity", "()Lcom/tencent/mm/ui/base/preference/MMPreference;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "doSomething", "", "refresh", "plugin-finder_release"})
    public static final class e extends Preference implements f {
        private final com.tencent.mm.plugin.finder.storage.config.e vQf;
        private final MMPreference vQj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(MMPreference mMPreference, com.tencent.mm.plugin.finder.storage.config.e eVar) {
            super(mMPreference);
            String str;
            p.h(mMPreference, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            p.h(eVar, "config");
            AppMethodBeat.i(252819);
            this.vQj = mMPreference;
            this.vQf = eVar;
            String dyq = this.vQf.dyq();
            if (dyq == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(252819);
                throw tVar;
            }
            String upperCase = dyq.toUpperCase();
            p.g(upperCase, "(this as java.lang.String).toUpperCase()");
            if (upperCase.compareTo("T5") >= 0) {
                str = "🌟" + this.vQf.title;
            } else {
                str = this.vQf.title;
            }
            setTitle(str);
            setKey(this.vQf.title);
            this.vQj.getPreferenceScreen().c(this);
            AppMethodBeat.o(252819);
        }

        @Override // com.tencent.mm.plugin.finder.ui.j.f
        public final void dAo() {
            AppMethodBeat.i(252818);
            String str = "doSomething " + getTitle() + " onClick";
            Log.i("SettingHelper", str);
            u.makeText(this.vQj, str, 1).show();
            this.vQf.Lc(0);
            AppMethodBeat.o(252818);
        }

        @Override // com.tencent.mm.plugin.finder.ui.j.f
        public final void refresh() {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/SettingHelper$DebugBoxPref;", "Lcom/tencent/mm/ui/base/preference/CheckBoxPreference;", "Lcom/tencent/mm/plugin/finder/ui/SettingHelper$IPreferenceEvent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/base/preference/MMPreference;", "config", "Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "(Lcom/tencent/mm/ui/base/preference/MMPreference;Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;)V", "getActivity", "()Lcom/tencent/mm/ui/base/preference/MMPreference;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "doSomething", "", "refresh", "plugin-finder_release"})
    public static final class c extends CheckBoxPreference implements f {
        private final com.tencent.mm.plugin.finder.storage.config.e vQf;
        private final MMPreference vQj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(MMPreference mMPreference, com.tencent.mm.plugin.finder.storage.config.e eVar) {
            super(mMPreference);
            String str;
            p.h(mMPreference, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            p.h(eVar, "config");
            AppMethodBeat.i(252814);
            this.vQj = mMPreference;
            this.vQf = eVar;
            String dyq = this.vQf.dyq();
            if (dyq == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(252814);
                throw tVar;
            }
            String upperCase = dyq.toUpperCase();
            p.g(upperCase, "(this as java.lang.String).toUpperCase()");
            if (upperCase.compareTo("T5") >= 0) {
                str = "🌟" + this.vQf.title;
            } else {
                str = this.vQf.title;
            }
            setTitle(str);
            setKey(this.vQf.title);
            setChecked(this.vQf.vFI == 1);
            this.vQj.getPreferenceScreen().c(this);
            AppMethodBeat.o(252814);
        }

        @Override // com.tencent.mm.plugin.finder.ui.j.f
        public final void refresh() {
            boolean z = true;
            AppMethodBeat.i(252812);
            if (this.vQf.vFI != 1) {
                z = false;
            }
            setChecked(z);
            AppMethodBeat.o(252812);
        }

        @Override // com.tencent.mm.plugin.finder.ui.j.f
        public final void dAo() {
            AppMethodBeat.i(252813);
            String str = "doSomething " + getTitle() + " isChecked: " + isChecked();
            Log.i("SettingHelper", str);
            u.makeText(this.vQj, str, 1).show();
            this.vQf.Lc(isChecked() ? 1 : 0);
            refresh();
            AppMethodBeat.o(252813);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/SettingHelper$DebugChoicePref;", "Lcom/tencent/mm/ui/base/preference/Preference;", "Lcom/tencent/mm/plugin/finder/ui/SettingHelper$IPreferenceEvent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/base/preference/MMPreference;", "config", "Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "(Lcom/tencent/mm/ui/base/preference/MMPreference;Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;)V", "getActivity", "()Lcom/tencent/mm/ui/base/preference/MMPreference;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "operation", "Lcom/tencent/mm/plugin/finder/ui/SettingHelper$ChoiceItem;", "getOperation", "()Lcom/tencent/mm/plugin/finder/ui/SettingHelper$ChoiceItem;", "setOperation", "(Lcom/tencent/mm/plugin/finder/ui/SettingHelper$ChoiceItem;)V", "doSomething", "", "refresh", "plugin-finder_release"})
    public static final class d extends Preference implements f {
        private final com.tencent.mm.plugin.finder.storage.config.e vQf;
        private final MMPreference vQj;
        private a vQk = new a(this.vQj, this.vQf);

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(MMPreference mMPreference, com.tencent.mm.plugin.finder.storage.config.e eVar) {
            super(mMPreference);
            String str;
            p.h(mMPreference, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            p.h(eVar, "config");
            AppMethodBeat.i(252817);
            this.vQj = mMPreference;
            this.vQf = eVar;
            String dyq = this.vQf.dyq();
            if (dyq == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(252817);
                throw tVar;
            }
            String upperCase = dyq.toUpperCase();
            p.g(upperCase, "(this as java.lang.String).toUpperCase()");
            if (upperCase.compareTo("T5") >= 0) {
                str = "🌟" + this.vQf.title;
            } else {
                str = this.vQf.title;
            }
            setTitle(str);
            setKey(this.vQf.title);
            setSummary(String.valueOf(this.vQk.getValue()));
            this.vQj.getPreferenceScreen().c(this);
            AppMethodBeat.o(252817);
        }

        @Override // com.tencent.mm.plugin.finder.ui.j.f
        public final void refresh() {
            AppMethodBeat.i(252815);
            setSummary(String.valueOf(this.vQk.getValue()));
            AppMethodBeat.o(252815);
        }

        @Override // com.tencent.mm.plugin.finder.ui.j.f
        public final void dAo() {
            AppMethodBeat.i(252816);
            a aVar = this.vQk;
            MMPreference mMPreference = this.vQj;
            d dVar = this;
            p.h(mMPreference, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            p.h(dVar, "operation");
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            List<String> list = aVar.vQe;
            if (list == null) {
                p.hyc();
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                List<String> list2 = aVar.vQe;
                if (list2 == null) {
                    p.hyc();
                }
                linkedList.add(list2.get(i2));
                linkedList2.add(Integer.valueOf(i2));
            }
            h.a(mMPreference, "", linkedList, linkedList2, "", new a.C1299a(aVar, dVar, mMPreference));
            AppMethodBeat.o(252816);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/SettingHelper$ChoiceItem;", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "config", "Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;)V", "_items", "", "", "getActivity", "()Landroid/app/Activity;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "value", "getValue", "()Ljava/lang/String;", "showAlert", "", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "operation", "Lcom/tencent/mm/plugin/finder/ui/SettingHelper$IPreferenceEvent;", "plugin-finder_release"})
    public static final class a {
        private final Activity activity;
        List<String> vQe = this.vQf.dyo();
        final com.tencent.mm.plugin.finder.storage.config.e vQf;

        public a(Activity activity2, com.tencent.mm.plugin.finder.storage.config.e eVar) {
            p.h(activity2, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            p.h(eVar, "config");
            AppMethodBeat.i(252811);
            this.activity = activity2;
            this.vQf = eVar;
            AppMethodBeat.o(252811);
        }

        public final String getValue() {
            AppMethodBeat.i(252810);
            int i2 = this.vQf.vFI;
            List<String> list = this.vQe;
            if (list == null) {
                AppMethodBeat.o(252810);
                return "";
            } else if (i2 < 0 || i2 >= list.size()) {
                String dyp = this.vQf.dyp();
                AppMethodBeat.o(252810);
                return dyp;
            } else {
                String str = list.get(i2);
                AppMethodBeat.o(252810);
                return str;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "whichButton", "", "<anonymous parameter 1>", "onClick"})
        /* renamed from: com.tencent.mm.plugin.finder.ui.j$a$a  reason: collision with other inner class name */
        static final class C1299a implements h.e {
            final /* synthetic */ a vQg;
            final /* synthetic */ f vQh;
            final /* synthetic */ MMPreference vQi;

            C1299a(a aVar, f fVar, MMPreference mMPreference) {
                this.vQg = aVar;
                this.vQh = fVar;
                this.vQi = mMPreference;
            }

            @Override // com.tencent.mm.ui.base.h.e
            public final void cy(int i2, int i3) {
                AppMethodBeat.i(252809);
                try {
                    this.vQg.vQf.Lc(i2);
                    this.vQh.refresh();
                    this.vQi.getPreferenceScreen().notifyDataSetChanged();
                    AppMethodBeat.o(252809);
                } catch (Exception e2) {
                    Log.printErrStackTrace("SettingHelper", e2, "", new Object[0]);
                    AppMethodBeat.o(252809);
                }
            }
        }
    }
}
