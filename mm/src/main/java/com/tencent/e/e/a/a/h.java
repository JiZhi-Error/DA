package com.tencent.e.e.a.a;

import android.content.Context;
import com.qq.taf.jce.JceInputStream;
import com.tencent.e.f.b;
import com.tencent.e.f.c;
import com.tencent.e.f.f;
import com.tencent.e.f.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class h {
    private static final j<h> AEL = new j<h>() {
        /* class com.tencent.e.e.a.a.h.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.e.f.j
        public final /* synthetic */ h oR() {
            AppMethodBeat.i(138403);
            h hVar = new h();
            AppMethodBeat.o(138403);
            return hVar;
        }
    };
    public Context mContext;
    public boolean mInit = false;

    public static class a {
        public com.tencent.e.e.a.b.a RNd;
        public List<String> RNe;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(138409);
        AppMethodBeat.o(138409);
    }

    public static h hkK() {
        AppMethodBeat.i(138404);
        h hVar = AEL.get();
        AppMethodBeat.o(138404);
        return hVar;
    }

    public final void init(Context context) {
        this.mContext = context;
        this.mInit = true;
    }

    public final String ms(int i2, int i3) {
        AppMethodBeat.i(138405);
        String mt = mt(i2, i3);
        File dir = this.mContext.getDir("turingmm", 0);
        if (dir == null) {
            AppMethodBeat.o(138405);
            return "";
        }
        File[] listFiles = dir.listFiles();
        if (listFiles == null) {
            AppMethodBeat.o(138405);
            return "";
        }
        ArrayList<File> arrayList = new ArrayList();
        for (File file : listFiles) {
            if (file.getName().startsWith(mt)) {
                arrayList.add(file);
            }
        }
        if (arrayList.size() <= 2) {
            AppMethodBeat.o(138405);
            return "";
        }
        ArrayList arrayList2 = new ArrayList();
        for (File file2 : arrayList) {
            String[] split = file2.getName().split("_");
            if (split.length == 2 && split[0].equals(mt)) {
                arrayList2.add(Long.valueOf(Long.parseLong(split[1])));
            }
        }
        if (arrayList2.size() <= 2) {
            AppMethodBeat.o(138405);
            return "";
        }
        Collections.sort(arrayList2);
        String str = dir.getAbsolutePath() + File.separator + mt + "_" + arrayList2.get(0);
        AppMethodBeat.o(138405);
        return str;
    }

    public final Map<String, com.tencent.e.e.a.b.a> hkL() {
        com.tencent.e.e.a.b.a aVar;
        AppMethodBeat.i(138406);
        HashMap hashMap = new HashMap();
        File dir = this.mContext.getDir("turingmm", 0);
        if (dir == null) {
            AppMethodBeat.o(138406);
        } else {
            File[] listFiles = dir.listFiles();
            if (listFiles == null) {
                AppMethodBeat.o(138406);
            } else {
                for (File file : listFiles) {
                    try {
                        byte[] o = c.o(f.aa(new File(file.getAbsolutePath())), c.hkP());
                        if (o == null) {
                            aVar = null;
                        } else {
                            byte[] cV = b.cV(o);
                            if (cV == null) {
                                aVar = null;
                            } else {
                                aVar = new com.tencent.e.e.a.b.a();
                                aVar.readFrom(new JceInputStream(cV));
                            }
                        }
                        if (aVar == null) {
                            NullPointerException nullPointerException = new NullPointerException("csGroupRecord is null.");
                            AppMethodBeat.o(138406);
                            throw nullPointerException;
                        }
                        hashMap.put(file.getAbsolutePath(), aVar);
                    } catch (Throwable th) {
                        file.deleteOnExit();
                    }
                }
                AppMethodBeat.o(138406);
            }
        }
        return hashMap;
    }

    public static a i(Map<String, com.tencent.e.e.a.b.a> map, int i2) {
        AppMethodBeat.i(138407);
        if (map == null) {
            AppMethodBeat.o(138407);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        com.tencent.e.e.a.b.a aVar = null;
        for (String str : map.keySet()) {
            com.tencent.e.e.a.b.a aVar2 = map.get(str);
            if (aVar2 != null && aVar2.requestType == i2) {
                arrayList.add(str);
                if (aVar == null) {
                    aVar = aVar2;
                } else {
                    aVar.RNn.addAll(aVar2.RNn);
                }
            }
        }
        if (aVar != null) {
            a aVar3 = new a((byte) 0);
            aVar3.RNd = aVar;
            aVar3.RNe = arrayList;
            AppMethodBeat.o(138407);
            return aVar3;
        }
        AppMethodBeat.o(138407);
        return null;
    }

    public static String mt(int i2, int i3) {
        AppMethodBeat.i(138408);
        String str = i2 + "00" + i3;
        AppMethodBeat.o(138408);
        return str;
    }
}
