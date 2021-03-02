package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bzz;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.dw;
import com.tencent.mm.protocal.protobuf.he;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class g extends d<cnb> {
    private he EnQ;
    private dw EnR;
    private a EnS;
    private int Eny = 0;
    private int Enz = 0;
    private List<cnb> list = new ArrayList();
    private String path = "";
    private String yFy = "";

    public interface a {
        void a(List<cnb> list, Map<Integer, Integer> map, Map<Integer, Integer> map2, int i2, int i3, he heVar);

        void ffi();
    }

    public g(a aVar) {
        AppMethodBeat.i(97712);
        this.EnS = aVar;
        AppMethodBeat.o(97712);
    }

    @Override // com.tencent.mm.plugin.sns.ui.d
    public final void gZ(List<cnb> list2) {
        int i2;
        AppMethodBeat.i(97713);
        if (this.EnS != null) {
            if (list2 != null) {
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                hashMap.clear();
                hashMap2.clear();
                int size = list2.size();
                Log.d("MicroMsg.ArtistAdapterHelper", "initFixType ".concat(String.valueOf(size)));
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (i3 < size) {
                    String str = list2.get(i3).Desc;
                    if (i3 + 1 >= size) {
                        i2 = 1;
                    } else if (!str.equals(list2.get(i3 + 1).Desc)) {
                        i2 = 1;
                    } else if (i3 + 2 >= size) {
                        i2 = 2;
                    } else if (!str.equals(list2.get(i3 + 2).Desc)) {
                        i2 = 2;
                    } else {
                        i2 = 3;
                    }
                    hashMap.put(Integer.valueOf(i4), Integer.valueOf(i5));
                    hashMap2.put(Integer.valueOf(i4), Integer.valueOf(i2));
                    i5 += i2;
                    i4++;
                    i3 = i2 + i3;
                }
                this.Eny = i4 + 1;
                this.Enz = list2.size();
                Log.d("MicroMsg.ArtistAdapterHelper", "icount " + this.Eny);
                this.list = list2;
                this.EnS.a(this.list, hashMap, hashMap2, this.Enz, this.Eny, this.EnQ);
                AppMethodBeat.o(97713);
                return;
            }
            this.EnS.ffi();
        }
        AppMethodBeat.o(97713);
    }

    @Override // com.tencent.mm.plugin.sns.ui.d
    public final List<cnb> anm() {
        AppMethodBeat.i(97714);
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.clear();
            this.EnR = null;
            String str = this.path + this.yFy + "_ARTISTF.mm";
            if (s.YS(str)) {
                this.EnR = (dw) new dw().parseFrom(s.aW(str, 0, -1));
            }
            if (this.EnR == null) {
                String str2 = this.path + this.yFy + "_ARTIST.mm";
                this.EnR = com.tencent.mm.plugin.sns.j.a.aPO(new String(s.aW(str2, 0, (int) s.boW(str2))));
                if (this.EnR == null) {
                    s.deleteFile(str2);
                    AppMethodBeat.o(97714);
                    return null;
                }
                s.deleteFile(str);
                byte[] byteArray = this.EnR.toByteArray();
                s.f(str, byteArray, byteArray.length);
            }
            if (this.EnR == null) {
                AppMethodBeat.o(97714);
                return null;
            }
            Iterator<bzz> it = this.EnR.GroupList.iterator();
            while (it.hasNext()) {
                bzz next = it.next();
                String str3 = next.Name;
                Iterator<cnb> it2 = next.LoV.iterator();
                while (it2.hasNext()) {
                    cnb next2 = it2.next();
                    next2.Desc = str3;
                    arrayList.add(next2);
                }
            }
            this.EnQ = this.EnR.KHT;
            AppMethodBeat.o(97714);
            return arrayList;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ArtistAdapterHelper", e2, "loadData failed.", new Object[0]);
            AppMethodBeat.o(97714);
            return null;
        }
    }

    public final void kO(String str, String str2) {
        AppMethodBeat.i(97715);
        this.yFy = str;
        this.path = str2;
        pN(true);
        AppMethodBeat.o(97715);
    }
}
