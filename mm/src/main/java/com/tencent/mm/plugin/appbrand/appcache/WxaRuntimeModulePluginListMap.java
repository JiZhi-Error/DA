package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.ArrayMap;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u0000 &2\u00020\u0001:\u0002&'B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0007\b\u0016¢\u0006\u0002\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\rJ\u001e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fJ\u0006\u0010\u001e\u001a\u00020\u001aJ\u0018\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0012H\u0016J&\u0010\"\u001a\u00020\u001a*\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00100\n2\u0006\u0010#\u001a\u00020\rH\u0002J\u0012\u0010$\u001a\b\u0012\u0004\u0012\u00020\r0\f*\u00020\u0003H\u0002J\u001a\u0010%\u001a\u00020\u001a*\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\nX\u0004¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00100\nX.¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;", "Landroid/os/Parcelable;", "p", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "isEmpty", "", "()Z", "mPrimaryMap", "Landroid/util/ArrayMap;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap$Namespace$MODULE;", "", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginPkgInfo;", "mSecondaryMap", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap$Namespace$PLUGIN;", "Ljava/util/LinkedList;", "size", "", "getSize", "()I", "describeContents", "getPluginList", "moduleName", "", "mergeUpdatedPlugin", "", "updated", "putPluginList", "list", "setupMapping", "writeToParcel", "dest", "flags", "addPluginInfoInstance", "plugin", "createModuleMappedPluginList", "writeModuleMappedPluginList", "Companion", "Namespace", "luggage-wxa-app_release"})
public final class WxaRuntimeModulePluginListMap implements Parcelable {
    public static final Parcelable.Creator<WxaRuntimeModulePluginListMap> CREATOR = new b();
    public static final a kOm = new a((byte) 0);
    public final ArrayMap<c.a, List<WxaPluginPkgInfo>> kOk;
    private ArrayMap<c.b, LinkedList<WxaPluginPkgInfo>> kOl;

    public final List<WxaPluginPkgInfo> Vz(String str) {
        AppMethodBeat.i(178653);
        p.h(str, "moduleName");
        List<WxaPluginPkgInfo> list = this.kOk.get(new c.a(str));
        AppMethodBeat.o(178653);
        return list;
    }

    public final void a(WxaPluginPkgInfo wxaPluginPkgInfo) {
        AppMethodBeat.i(178655);
        p.h(wxaPluginPkgInfo, "updated");
        ArrayMap<c.b, LinkedList<WxaPluginPkgInfo>> arrayMap = this.kOl;
        if (arrayMap == null) {
            p.btv("mSecondaryMap");
        }
        String str = wxaPluginPkgInfo.provider;
        p.g(str, "updated.provider");
        LinkedList<WxaPluginPkgInfo> linkedList = arrayMap.get(new c.b(str));
        if (linkedList != null) {
            for (T t : linkedList) {
                if (wxaPluginPkgInfo.isAssignable(t)) {
                    t.pkgPath = wxaPluginPkgInfo.pkgPath;
                    t.md5 = wxaPluginPkgInfo.md5;
                    t.stringVersion = wxaPluginPkgInfo.stringVersion;
                }
            }
            AppMethodBeat.o(178655);
            return;
        }
        AppMethodBeat.o(178655);
    }

    public final void bwB() {
        AppMethodBeat.i(178656);
        if (this.kOl == null) {
            this.kOl = new ArrayMap<>();
            Collection<List<WxaPluginPkgInfo>> values = this.kOk.values();
            p.g(values, "mPrimaryMap.values");
            for (T<WxaPluginPkgInfo> t : values) {
                p.g(t, "list");
                for (WxaPluginPkgInfo wxaPluginPkgInfo : t) {
                    ArrayMap<c.b, LinkedList<WxaPluginPkgInfo>> arrayMap = this.kOl;
                    if (arrayMap == null) {
                        p.btv("mSecondaryMap");
                    }
                    a(arrayMap, wxaPluginPkgInfo);
                }
            }
        }
        AppMethodBeat.o(178656);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(178657);
        p.h(parcel, "dest");
        parcel.writeInt(this.kOk.size());
        for (Map.Entry<c.a, List<WxaPluginPkgInfo>> entry : this.kOk.entrySet()) {
            List<WxaPluginPkgInfo> value = entry.getValue();
            parcel.writeString(entry.getKey().name);
            p.g(value, "value");
            parcel.writeInt(value.size());
            for (WxaPluginPkgInfo wxaPluginPkgInfo : value) {
                wxaPluginPkgInfo.writeToParcel(parcel, 0);
            }
        }
        AppMethodBeat.o(178657);
    }

    public WxaRuntimeModulePluginListMap(Parcel parcel) {
        p.h(parcel, "p");
        AppMethodBeat.i(178660);
        int readInt = parcel.readInt();
        this.kOk = new ArrayMap<>(readInt);
        this.kOl = new ArrayMap<>();
        for (int i2 = 0; i2 < readInt; i2++) {
            String readString = parcel.readString();
            if (readString == null) {
                p.hyc();
            }
            p.g(readString, "p.readString()!!");
            this.kOk.put(new c.a(readString), g(parcel));
        }
        AppMethodBeat.o(178660);
    }

    private final List<WxaPluginPkgInfo> g(Parcel parcel) {
        AppMethodBeat.i(178658);
        LinkedList linkedList = new LinkedList();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            WxaPluginPkgInfo createFromParcel = WxaPluginPkgInfo.CREATOR.createFromParcel(parcel);
            ArrayMap<c.b, LinkedList<WxaPluginPkgInfo>> arrayMap = this.kOl;
            if (arrayMap == null) {
                p.btv("mSecondaryMap");
            }
            p.g(createFromParcel, "p");
            a(arrayMap, createFromParcel);
            linkedList.add(createFromParcel);
        }
        LinkedList linkedList2 = linkedList;
        AppMethodBeat.o(178658);
        return linkedList2;
    }

    public WxaRuntimeModulePluginListMap() {
        AppMethodBeat.i(178661);
        this.kOk = new ArrayMap<>();
        AppMethodBeat.o(178661);
    }

    public final int describeContents() {
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;", "luggage-wxa-app_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;", "luggage-wxa-app_release"})
    public static final class b implements Parcelable.Creator<WxaRuntimeModulePluginListMap> {
        b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WxaRuntimeModulePluginListMap createFromParcel(Parcel parcel) {
            AppMethodBeat.i(178645);
            p.h(parcel, "source");
            WxaRuntimeModulePluginListMap wxaRuntimeModulePluginListMap = new WxaRuntimeModulePluginListMap(parcel);
            AppMethodBeat.o(178645);
            return wxaRuntimeModulePluginListMap;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WxaRuntimeModulePluginListMap[] newArray(int i2) {
            return new WxaRuntimeModulePluginListMap[i2];
        }
    }

    static {
        AppMethodBeat.i(178662);
        AppMethodBeat.o(178662);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b2\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap$Namespace;", "", "()V", "MODULE", "PLUGIN", "luggage-wxa-app_release"})
    static abstract class c {

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap$Namespace$PLUGIN;", "", "provider", "", "(Ljava/lang/String;)V", "getProvider", "()Ljava/lang/String;", "component1", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "luggage-wxa-app_release"})
        public static final class b {
            private final String provider;

            public final String toString() {
                AppMethodBeat.i(178652);
                String str = "PLUGIN(provider=" + this.provider + ")";
                AppMethodBeat.o(178652);
                return str;
            }

            public b(String str) {
                p.h(str, "provider");
                AppMethodBeat.i(178651);
                this.provider = str;
                AppMethodBeat.o(178651);
            }

            public final int hashCode() {
                AppMethodBeat.i(178649);
                int hashCode = this.provider.hashCode();
                AppMethodBeat.o(178649);
                return hashCode;
            }

            public final boolean equals(Object obj) {
                String str = null;
                AppMethodBeat.i(178650);
                b bVar = (b) (!(obj instanceof b) ? null : obj);
                if (bVar != null) {
                    str = bVar.provider;
                }
                boolean j2 = p.j(str, this.provider);
                AppMethodBeat.o(178650);
                return j2;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap$Namespace$MODULE;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "luggage-wxa-app_release"})
        public static final class a {
            final String name;

            public a(String str) {
                p.h(str, "name");
                AppMethodBeat.i(178648);
                String Vw = WxaPkgWrappingInfo.Vw(str);
                if (Vw == null) {
                    p.hyc();
                }
                this.name = Vw;
                AppMethodBeat.o(178648);
            }

            public final int hashCode() {
                AppMethodBeat.i(178646);
                int hashCode = this.name.hashCode();
                AppMethodBeat.o(178646);
                return hashCode;
            }

            public final boolean equals(Object obj) {
                String str = null;
                AppMethodBeat.i(178647);
                a aVar = (a) (!(obj instanceof a) ? null : obj);
                if (aVar != null) {
                    str = aVar.name;
                }
                boolean j2 = p.j(str, this.name);
                AppMethodBeat.o(178647);
                return j2;
            }
        }
    }

    private static void a(ArrayMap<c.b, LinkedList<WxaPluginPkgInfo>> arrayMap, WxaPluginPkgInfo wxaPluginPkgInfo) {
        AppMethodBeat.i(178659);
        String str = wxaPluginPkgInfo.provider;
        p.g(str, "plugin.provider");
        c.b bVar = new c.b(str);
        LinkedList<WxaPluginPkgInfo> linkedList = arrayMap.get(bVar);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            arrayMap.put(bVar, linkedList);
        }
        p.g(linkedList, "this[namespace] ?: Linke… { this[namespace] = it }");
        linkedList.add(wxaPluginPkgInfo);
        AppMethodBeat.o(178659);
    }

    public final boolean isEmpty() {
        AppMethodBeat.i(178654);
        if (this.kOk.size() <= 0) {
            AppMethodBeat.o(178654);
            return true;
        }
        AppMethodBeat.o(178654);
        return false;
    }
}
