package com.tencent.mm.plugin.finder.storage.config;

import android.arch.lifecycle.MutableLiveData;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.finder.storage.config.item.b;
import com.tencent.mm.plugin.finder.storage.config.item.e;
import com.tencent.mm.plugin.finder.storage.config.item.f;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 ;*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001;B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J0\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0017\u001a\u00020\u00052\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u001cJ\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001f\u001a\u00020\u0005J\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010!\u001a\u00020\"J/\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\bJ\b\u0010$\u001a\u00020\tH\u0016J\b\u0010%\u001a\u00020\rH\u0002J\"\u0010&\u001a\u00020\u00112\u0018\u0010'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050)0(H\u0002J\u0006\u0010*\u001a\u00020\tJ\b\u0010+\u001a\u00020\tH\u0002J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00050\u001cH\u0016J\"\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\bH\u0016J\u001e\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u0002012\f\u00102\u001a\b\u0012\u0004\u0012\u00028\u000003H\u0016J\u0010\u00104\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\rH\u0016J\b\u00105\u001a\u00020\u0011H\u0016J\u0010\u00106\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\rH\u0002J\b\u00107\u001a\u00020\u0005H\u0016J\r\u00108\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00109J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010:\u001a\u00020\u0005R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0004¢\u0006\u0002\n\u0000R)\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\bX\u000e¢\u0006\u0002\n\u0000R.\u0010\u0012\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0018\u00010\u0013j\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0018\u0001`\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u00028\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/config/FinderFakeConfig;", "T", "Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "defValue", "title", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "booleanWrapper", "Lkotlin/Function1;", "", "chosenData", "Landroid/arch/lifecycle/MutableLiveData;", "clickListener", "", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.b.INDEX, "", "configItemList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/storage/config/item/ConfigItem;", "Lkotlin/collections/ArrayList;", "Ljava/lang/Object;", "keyName", "realConfig", "versionTag", "bindDebugConfig", "configDataList", "", "configDataNameList", "bindDynaConfig", "dyConfigKey", "bindExpConfig", "expKey", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "bindOnClick", "booleanValue", "initChosenIndex", "initFakeConfigItemList", "config", "Ljava/util/LinkedList;", "Lkotlin/Pair;", "isDebug", "isSettingUIOpen", "itemNameList", "map", "wrapper", "observe", "owner", "Landroid/arch/lifecycle/LifecycleOwner;", "observer", "Landroid/arch/lifecycle/Observer;", "onItemClick", "reset", "saveConfig", "svrValue", "value", "()Ljava/lang/Object;", "tag", "Companion", "plugin-finder_release"})
public class b<T> extends e {
    private static final String TAG = TAG;
    private static final MultiProcessMMKV cQe = MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY");
    public static final a vFD = new a((byte) 0);
    private final MutableLiveData<T> vFA = new MutableLiveData<>();
    private String vFB = "";
    private final T vFC;
    private String vFw;
    private ArrayList<com.tencent.mm.plugin.finder.storage.config.item.a<T>> vFx;
    private com.tencent.mm.plugin.finder.storage.config.item.a<T> vFy;
    private kotlin.g.a.b<? super Integer, x> vFz = d.vFF;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "T", FirebaseAnalytics.b.INDEX, "", "invoke"})
    static final class d extends q implements kotlin.g.a.b<Integer, x> {
        public static final d vFF = new d();

        static {
            AppMethodBeat.i(251907);
            AppMethodBeat.o(251907);
        }

        d() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Integer num) {
            AppMethodBeat.i(251906);
            num.intValue();
            x xVar = x.SXb;
            AppMethodBeat.o(251906);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(T t, String str) {
        super(str);
        p.h(str, "title");
        AppMethodBeat.i(251921);
        this.vFC = t;
        AppMethodBeat.o(251921);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/config/FinderFakeConfig$Companion;", "", "()V", "FINDER_CONFIG_USER_KEY", "", "TAG", "getTAG", "()Ljava/lang/String;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(251922);
        AppMethodBeat.o(251922);
    }

    public final b<T> d(b.a aVar) {
        AppMethodBeat.i(251908);
        p.h(aVar, "expKey");
        this.vFy = new f(this.vFC, aVar, new c(this));
        AppMethodBeat.o(251908);
        return this;
    }

    public final b<T> avD(String str) {
        AppMethodBeat.i(251909);
        p.h(str, "dyConfigKey");
        this.vFy = new e(this.vFC, str, new C1283b(this));
        AppMethodBeat.o(251909);
        return this;
    }

    public final b<T> b(String str, List<? extends T> list, List<String> list2) {
        AppMethodBeat.i(251910);
        p.h(str, "keyName");
        p.h(list, "configDataList");
        p.h(list2, "configDataNameList");
        this.vFw = str;
        b.a aVar = com.tencent.mm.plugin.finder.storage.config.item.b.vFL;
        ax(b.a.n(list, list2));
        this.vFI = dyr();
        AppMethodBeat.o(251910);
        return this;
    }

    public final b<T> H(kotlin.g.a.b<? super Integer, x> bVar) {
        AppMethodBeat.i(251911);
        p.h(bVar, "clickListener");
        this.vFz = bVar;
        AppMethodBeat.o(251911);
        return this;
    }

    public final b<T> avE(String str) {
        AppMethodBeat.i(251912);
        p.h(str, "tag");
        this.vFB = str;
        AppMethodBeat.o(251912);
        return this;
    }

    @Override // com.tencent.mm.plugin.finder.storage.config.e
    public final List<String> dyo() {
        AppMethodBeat.i(251913);
        LinkedList linkedList = new LinkedList();
        ArrayList<com.tencent.mm.plugin.finder.storage.config.item.a<T>> arrayList = this.vFx;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                linkedList.add(it.next().name);
            }
        }
        com.tencent.mm.plugin.finder.storage.config.item.a<T> aVar = this.vFy;
        if (aVar != null) {
            linkedList.add(aVar.name + ':' + ((Object) aVar.value()));
        }
        LinkedList linkedList2 = linkedList;
        AppMethodBeat.o(251913);
        return linkedList2;
    }

    @Override // com.tencent.mm.plugin.finder.storage.config.e
    public final String dyp() {
        String str;
        AppMethodBeat.i(251914);
        com.tencent.mm.plugin.finder.storage.config.item.a<T> aVar = this.vFy;
        if (aVar == null || (aVar.name + ':' + ((Object) aVar.value())) == null) {
            str = "None";
        }
        AppMethodBeat.o(251914);
        return str;
    }

    @Override // com.tencent.mm.plugin.finder.storage.config.e
    public final String dyq() {
        return this.vFB;
    }

    private final void ax(LinkedList<o<T, String>> linkedList) {
        AppMethodBeat.i(251915);
        if (this.vFx == null) {
            this.vFx = new ArrayList<>();
        }
        for (T t : linkedList) {
            ArrayList<com.tencent.mm.plugin.finder.storage.config.item.a<T>> arrayList = this.vFx;
            if (arrayList != null) {
                arrayList.add(new com.tencent.mm.plugin.finder.storage.config.item.a<>(t.first, t.second));
            }
        }
        AppMethodBeat.o(251915);
    }

    private final int dyr() {
        o oVar;
        AppMethodBeat.i(251916);
        if (this.vFw != null) {
            oVar = new o(Integer.valueOf(cQe.getInt(this.vFw, -1)), "get from mmkv");
            int intValue = oVar.first.intValue();
            ArrayList<com.tencent.mm.plugin.finder.storage.config.item.a<T>> arrayList = this.vFx;
            if (intValue >= (arrayList != null ? arrayList.size() : 0)) {
                oVar = new o(-1, "reset_default");
            }
        } else {
            oVar = new o(-1, BuildConfig.KINDA_DEFAULT);
        }
        Log.i(TAG, "code:" + hashCode() + "  keyName " + this.vFw + " initChosenIndex " + oVar.first.intValue() + " reason " + ((String) oVar.second) + " defValue:" + ((Object) this.vFC));
        int intValue2 = oVar.first.intValue();
        AppMethodBeat.o(251916);
        return intValue2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v13, resolved type: android.arch.lifecycle.MutableLiveData<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.plugin.finder.storage.config.e
    public void Lc(int i2) {
        int i3;
        int i4;
        com.tencent.mm.plugin.finder.storage.config.item.a aVar;
        AppMethodBeat.i(251917);
        ArrayList<com.tencent.mm.plugin.finder.storage.config.item.a<T>> arrayList = this.vFx;
        if (arrayList != null) {
            i3 = arrayList.size();
        } else {
            i3 = 0;
        }
        if (i2 > i3) {
            i4 = -1;
        } else {
            i4 = i2;
        }
        this.vFI = i4;
        ArrayList<com.tencent.mm.plugin.finder.storage.config.item.a<T>> arrayList2 = this.vFx;
        if (!(arrayList2 == null || (aVar = (com.tencent.mm.plugin.finder.storage.config.item.a) j.L(arrayList2, this.vFI)) == null)) {
            this.vFA.setValue(aVar.value());
        }
        Ld(i2);
        if (KB()) {
            Log.i(TAG, "code:" + hashCode() + "  keyName " + this.vFw + " onItemClick click: " + i2 + " chosenIndex: " + this.vFI + " defValue:" + ((Object) this.vFC));
        }
        this.vFz.invoke(Integer.valueOf(i2));
        AppMethodBeat.o(251917);
    }

    private final void Ld(int i2) {
        AppMethodBeat.i(251918);
        String str = this.vFw;
        if (str != null) {
            cQe.putInt(str, i2).commit();
            AppMethodBeat.o(251918);
            return;
        }
        AppMethodBeat.o(251918);
    }

    public void reset() {
        AppMethodBeat.i(251919);
        Log.i(TAG, "code:" + hashCode() + "  keyName " + this.vFw + " reset");
        this.vFI = -1;
        Ld(this.vFI);
        AppMethodBeat.o(251919);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [A, T] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0110  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T value() {
        /*
        // Method dump skipped, instructions count: 275
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.storage.config.b.value():java.lang.Object");
    }

    private static boolean KB() {
        return BuildInfo.DEBUG;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "T", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b vFE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(b bVar) {
            super(0);
            this.vFE = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: android.arch.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(251905);
            this.vFE.vFA.postValue(this.vFE.value());
            x xVar = x.SXb;
            AppMethodBeat.o(251905);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "T", "invoke"})
    /* renamed from: com.tencent.mm.plugin.finder.storage.config.b$b  reason: collision with other inner class name */
    static final class C1283b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b vFE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1283b(b bVar) {
            super(0);
            this.vFE = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: android.arch.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(251904);
            this.vFE.vFA.postValue(this.vFE.value());
            x xVar = x.SXb;
            AppMethodBeat.o(251904);
            return xVar;
        }
    }
}
