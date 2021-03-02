package com.tencent.mm.vfs;

import android.os.Bundle;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.mm.vfs.SchemeResolver;
import com.tencent.mm.vfs.k;
import com.tencent.stubs.logger.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* access modifiers changed from: package-private */
public final class l implements k {
    private static final f Rdd = new f(new NativeFileSystem(""));
    final Map<String, m> Rde;
    final Map<String, f> Rdf;
    final Map<String, f> Rdg;
    final SortedMap<String, String> Rdh;
    final List<a> Rdi;
    final Map<String, String> Rdj;
    final f Rdk;
    private Map<String, SchemeResolver> Rdl;
    private Map<String, FileSystem> Rdm;
    private Map<String, FileSystem> Rdn;
    private Map<String, String> Rdo;
    private List<k.a> Rdp;

    /* access modifiers changed from: package-private */
    public static final class a extends k.a implements Comparable<String> {
        final int Rdq;
        FileSystem.b Rdr;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(String str) {
            AppMethodBeat.i(13217);
            int compareTo = this.basePath.compareTo(str);
            AppMethodBeat.o(13217);
            return compareTo;
        }

        a(String str, String str2, int i2, FileSystem.b bVar) {
            super(str, str2);
            this.Rdq = i2;
            this.Rdr = bVar;
        }
    }

    static {
        AppMethodBeat.i(13227);
        AppMethodBeat.o(13227);
    }

    l() {
        AppMethodBeat.i(13218);
        this.Rdl = null;
        this.Rdm = null;
        this.Rdn = null;
        this.Rdo = null;
        this.Rdp = null;
        this.Rde = Collections.emptyMap();
        this.Rdf = Collections.emptyMap();
        this.Rdg = Collections.emptyMap();
        this.Rdh = new TreeMap();
        this.Rdi = Collections.emptyList();
        this.Rdj = Collections.emptyMap();
        this.Rdk = Rdd;
        AppMethodBeat.o(13218);
    }

    private l(Map<String, m> map, Map<String, f> map2, Map<String, f> map3, SortedMap<String, String> sortedMap, Map<String, String> map4, f fVar) {
        AppMethodBeat.i(187732);
        this.Rdl = null;
        this.Rdm = null;
        this.Rdn = null;
        this.Rdo = null;
        this.Rdp = null;
        this.Rde = map;
        this.Rdf = map2;
        this.Rdg = map3;
        this.Rdh = sortedMap;
        this.Rdi = a(map2, sortedMap, map4);
        this.Rdj = map4;
        this.Rdk = (fVar == null || fVar.RbM == null) ? Rdd : fVar;
        AppMethodBeat.o(187732);
    }

    /* access modifiers changed from: package-private */
    public final l a(Map<String, m> map, Map<String, f> map2, Map<String, f> map3, SortedMap<String, String> sortedMap, Map<String, String> map4, f fVar) {
        Map hashMap;
        Map hashMap2;
        Map hashMap3;
        SortedMap treeMap;
        f fVar2;
        Map hashMap4;
        AppMethodBeat.i(187733);
        if (map.isEmpty()) {
            hashMap = this.Rde;
        } else {
            hashMap = new HashMap(this.Rde);
            e(hashMap, map);
        }
        if (map2.isEmpty()) {
            hashMap2 = this.Rdf;
        } else {
            hashMap2 = new HashMap(this.Rdf);
            e(hashMap2, map2);
        }
        if (map3.isEmpty()) {
            hashMap3 = this.Rdg;
        } else {
            hashMap3 = new HashMap(this.Rdg);
            e(hashMap3, map3);
        }
        if (sortedMap.isEmpty()) {
            treeMap = this.Rdh;
        } else {
            treeMap = new TreeMap((SortedMap) this.Rdh);
            e(treeMap, sortedMap);
        }
        if (fVar == null) {
            fVar2 = this.Rdk;
        } else {
            fVar2 = fVar;
        }
        if (map4.isEmpty()) {
            hashMap4 = this.Rdj;
        } else {
            hashMap4 = new HashMap(this.Rdj);
            e(hashMap4, map4);
            for (m mVar : hashMap.values()) {
                mVar.Rdt = null;
            }
            for (f fVar3 : hashMap2.values()) {
                fVar3.RbK = null;
            }
            for (f fVar4 : hashMap3.values()) {
                fVar4.RbK = null;
            }
            fVar2.RbK = null;
        }
        l lVar = new l(hashMap, hashMap2, hashMap3, treeMap, hashMap4, fVar2);
        if (map2.isEmpty()) {
            lVar.Rdm = this.Rdm;
        }
        if (map4.isEmpty()) {
            lVar.Rdo = this.Rdo;
        }
        AppMethodBeat.o(187733);
        return lVar;
    }

    static l by(Bundle bundle) {
        AppMethodBeat.i(13222);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("sl");
        Bundle bundle2 = bundle.getBundle("sm");
        HashMap hashMap = new HashMap();
        if (!(parcelableArrayList == null || bundle2 == null)) {
            for (String str : bundle2.keySet()) {
                int i2 = bundle2.getInt(str);
                if (i2 >= 0 && i2 < parcelableArrayList.size()) {
                    hashMap.put(str, new m((SchemeResolver) parcelableArrayList.get(i2)));
                }
            }
        }
        Bundle bundle3 = bundle.getBundle("fs");
        HashMap hashMap2 = new HashMap();
        if (bundle3 != null) {
            bundle3.setClassLoader(bundle.getClassLoader());
            for (String str2 : bundle3.keySet()) {
                hashMap2.put(str2, new f((FileSystem) bundle3.getParcelable(str2)));
            }
        }
        Bundle bundle4 = bundle.getBundle("mfs");
        HashMap hashMap3 = new HashMap();
        if (bundle4 != null) {
            bundle4.setClassLoader(bundle.getClassLoader());
            for (String str3 : bundle4.keySet()) {
                hashMap3.put(str3, new f((FileSystem) bundle4.getParcelable(str3)));
            }
        }
        Bundle bundle5 = bundle.getBundle(WeChatBrands.Business.GROUP_MP);
        TreeMap treeMap = new TreeMap();
        if (bundle5 != null) {
            bundle5.setClassLoader(bundle.getClassLoader());
            for (String str4 : bundle5.keySet()) {
                treeMap.put(str4, bundle5.getString(str4));
            }
        }
        Bundle bundle6 = bundle.getBundle("env");
        HashMap hashMap4 = new HashMap();
        if (bundle6 != null) {
            for (String str5 : bundle6.keySet()) {
                hashMap4.put(str5, bundle6.getString(str5));
            }
        }
        FileSystem fileSystem = (FileSystem) bundle.getParcelable("root");
        l lVar = new l(hashMap, hashMap2, hashMap3, treeMap, hashMap4, fileSystem == null ? null : new f(fileSystem));
        AppMethodBeat.o(13222);
        return lVar;
    }

    private static <K, V> void e(Map<K, V> map, Map<K, V> map2) {
        AppMethodBeat.i(13223);
        for (Map.Entry<K, V> entry : map2.entrySet()) {
            if (entry.getValue() == null) {
                map.remove(entry.getKey());
            } else {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        AppMethodBeat.o(13223);
    }

    private static List<a> a(Map<String, f> map, SortedMap<String, String> sortedMap, Map<String, String> map2) {
        AppMethodBeat.i(13224);
        ArrayList arrayList = new ArrayList(sortedMap.size());
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            f fVar = map.get(value);
            if (fVar == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("FileSystem '" + value + "' for mount point '" + key + "' not exist.");
                AppMethodBeat.o(13224);
                throw illegalArgumentException;
            }
            String aa = aa.aa(key, map2);
            if (aa != null) {
                arrayList.add(new a(aa, value, -1, fVar.RbK));
            }
        }
        a[] aVarArr = (a[]) arrayList.toArray(new a[0]);
        Arrays.sort(aVarArr, new Comparator<a>() {
            /* class com.tencent.mm.vfs.l.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(a aVar, a aVar2) {
                AppMethodBeat.i(13215);
                int compareTo = aVar.basePath.compareTo(aVar2.basePath);
                AppMethodBeat.o(13215);
                return compareTo;
            }
        });
        for (int i2 = 1; i2 < aVarArr.length; i2++) {
            a aVar = aVarArr[i2];
            String str = aVar.basePath;
            int i3 = i2 - 1;
            a aVar2 = aVarArr[i3];
            if (!aVar.basePath.equals(aVar2.basePath)) {
                do {
                    a aVar3 = aVarArr[i3];
                    if (str.startsWith(aVar3.basePath) && str.charAt(aVar3.basePath.length()) == '/') {
                        break;
                    }
                    i3 = aVar3.Rdq;
                } while (i3 >= 0);
            } else {
                Log.w("VFS.ResolverState", "Oops, duplicated mount point detected: " + aVar.toString() + " <=> " + aVar2.toString());
                i3 = aVar2.Rdq;
            }
            if (i3 >= 0) {
                aVarArr[i2] = new a(aVar.basePath, aVar.Rdc, i3, aVar.Rdr);
            }
        }
        List<a> asList = Arrays.asList(aVarArr);
        AppMethodBeat.o(13224);
        return asList;
    }

    @Override // com.tencent.mm.vfs.k
    public final Map<String, FileSystem> hec() {
        AppMethodBeat.i(187734);
        if (this.Rdm == null) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, f> entry : this.Rdf.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue().RbM);
            }
            this.Rdm = hashMap;
        }
        Map<String, FileSystem> map = this.Rdm;
        AppMethodBeat.o(187734);
        return map;
    }

    @Override // com.tencent.mm.vfs.k
    public final Map<String, String> hej() {
        AppMethodBeat.i(13225);
        if (this.Rdo == null) {
            this.Rdo = Collections.unmodifiableMap(this.Rdj);
        }
        Map<String, String> map = this.Rdo;
        AppMethodBeat.o(13225);
        return map;
    }

    @Override // com.tencent.mm.vfs.k
    public final FileSystem.b boT(String str) {
        AppMethodBeat.i(187735);
        f fVar = this.Rdf.get(str);
        if (fVar == null) {
            AppMethodBeat.o(187735);
            return null;
        }
        if (fVar.RbK == null) {
            fVar.RbK = fVar.RbM.cj(hej());
        }
        FileSystem.b bVar = fVar.RbK;
        AppMethodBeat.o(187735);
        return bVar;
    }

    public final SchemeResolver.a boV(String str) {
        AppMethodBeat.i(187736);
        m mVar = this.Rde.get(str);
        if (mVar == null) {
            AppMethodBeat.o(187736);
            return null;
        }
        if (mVar.Rdt == null) {
            SchemeResolver schemeResolver = mVar.Rds;
            hej();
            mVar.Rdt = schemeResolver.hel();
        }
        SchemeResolver.a aVar = mVar.Rdt;
        AppMethodBeat.o(187736);
        return aVar;
    }

    @Override // com.tencent.mm.vfs.k
    public final List<k.a> hek() {
        AppMethodBeat.i(187737);
        if (this.Rdp == null) {
            this.Rdp = Collections.unmodifiableList(this.Rdi);
        }
        List<k.a> list = this.Rdp;
        AppMethodBeat.o(187737);
        return list;
    }

    public final String toString() {
        AppMethodBeat.i(13226);
        String str = "schemes: " + this.Rde.size() + ", fileSystems: " + this.Rdf.size() + ", mountPoints: " + this.Rdh.size() + " (" + this.Rdi + " active), envVars: " + this.Rdj.size();
        AppMethodBeat.o(13226);
        return str;
    }

    @Override // com.tencent.mm.vfs.k
    public final Pair<FileSystem.b, String> boU(String str) {
        a aVar;
        FileSystem.b bVar;
        AppMethodBeat.i(187738);
        List<a> list = this.Rdi;
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(187738);
            return null;
        }
        String q = aa.q(str, true, false);
        int binarySearch = Collections.binarySearch(list, q);
        if (binarySearch >= 0) {
            aVar = list.get(binarySearch);
            q = "";
        } else {
            int i2 = (-binarySearch) - 2;
            while (true) {
                if (i2 >= 0) {
                    aVar = list.get(i2);
                    if (q.startsWith(aVar.basePath) && q.charAt(aVar.basePath.length()) == '/') {
                        break;
                    }
                    i2 = aVar.Rdq;
                } else {
                    aVar = null;
                    break;
                }
            }
            if (i2 >= 0) {
                q = q.substring(aVar.basePath.length() + 1);
            } else if (!q.isEmpty() && q.charAt(0) == '/') {
                q = q.substring(1);
            }
        }
        if (aVar == null) {
            if (this.Rdk.RbK == null) {
                this.Rdk.RbK = this.Rdk.RbM.cj(hej());
            }
            bVar = this.Rdk.RbK;
        } else {
            if (aVar.Rdr == null) {
                aVar.Rdr = boT(aVar.Rdc);
            }
            bVar = aVar.Rdr;
        }
        Pair<FileSystem.b, String> pair = new Pair<>(bVar, q);
        AppMethodBeat.o(187738);
        return pair;
    }
}
