package com.tencent.mm.plugin.gallery.model;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class s {
    public static final Uri BASE_URI = Uri.parse("content://com.open.gallery.smart.provider");
    public int eT;
    public ContentResolver hwt;
    public boolean xjF;
    public boolean xjG;
    public List<GalleryItem.MediaItem> xjH;

    public static class g {
        public String data;
        public String type;
        public long xjW;
        public long xjX;
    }

    public interface h {
        void f(List<g> list, boolean z);
    }

    public static abstract class i {
        public int mType;
    }

    /* synthetic */ s(byte b2) {
        this();
    }

    static {
        AppMethodBeat.i(111376);
        AppMethodBeat.o(111376);
    }

    private s() {
        AppMethodBeat.i(111368);
        this.eT = 100;
        this.xjH = new ArrayList();
        this.hwt = MMApplicationContext.getContext().getContentResolver();
        AppMethodBeat.o(111368);
    }

    /* access modifiers changed from: package-private */
    public static class j {
        static s xjY = new s((byte) 0);

        static {
            AppMethodBeat.i(111367);
            AppMethodBeat.o(111367);
        }
    }

    public static s dRv() {
        return j.xjY;
    }

    public static String[] dRw() {
        return new String[]{"categoryID", "categoryName", "albumID", "albumName", "albumCapacity", "coverID", "coverData", "albumTag"};
    }

    public static c eV(List<a> list) {
        AppMethodBeat.i(111369);
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (a aVar : list) {
            d dVar = aVar.xjI;
            List list2 = (List) hashMap.get(dVar);
            if (list2 == null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(aVar);
                hashMap.put(dVar, arrayList2);
                arrayList.add(dVar);
            } else {
                list2.add(aVar);
            }
        }
        c cVar = new c(arrayList, hashMap);
        AppMethodBeat.o(111369);
        return cVar;
    }

    public final boolean dRx() {
        boolean z;
        AppMethodBeat.i(173743);
        try {
            Bundle call = this.hwt.call(BASE_URI, "isSmartGalleryAvailable", (String) null, (Bundle) null);
            if (call != null) {
                z = call.getBoolean("isSmartGalleryAvailable");
                Log.i("MicroMsg.SmartGalleryQueryUtil", "isCategoryInfoValid res: %s.", Boolean.valueOf(z));
                AppMethodBeat.o(173743);
                return z;
            }
        } catch (Exception e2) {
        }
        Cursor query = this.hwt.query(BASE_URI.buildUpon().appendEncodedPath("albums").build(), dRw(), null, null, null);
        if (query != null) {
            Log.i("MicroMsg.SmartGalleryQueryUtil", "cursor not null.");
            if (query.moveToNext()) {
                Log.i("MicroMsg.SmartGalleryQueryUtil", "isCategoryInfoValid");
                z = true;
            } else {
                z = false;
            }
            query.close();
        } else {
            z = false;
        }
        AppMethodBeat.o(173743);
        return z;
    }

    public static List<i> n(List<a> list, String str) {
        AppMethodBeat.i(111370);
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        a aVar = null;
        for (a aVar2 : list) {
            if (aVar2.xjN == null || !aVar2.xjN.xjO) {
                d dVar = aVar2.xjI;
                List list2 = (List) hashMap.get(dVar);
                if (list2 == null) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(aVar2);
                    hashMap.put(dVar, arrayList2);
                } else {
                    list2.add(aVar2);
                }
            } else {
                aVar = aVar2;
            }
        }
        for (d dVar2 : hashMap.keySet()) {
            arrayList.add(dVar2);
            arrayList.addAll((Collection) hashMap.get(dVar2));
        }
        if (aVar != null) {
            arrayList.add(new d("OCR", MMApplicationContext.getContext().getResources().getString(R.string.h2s)));
            aVar.albumName = MMApplicationContext.getContext().getResources().getString(R.string.h2r, str);
            arrayList.add(aVar);
        }
        AppMethodBeat.o(111370);
        return arrayList;
    }

    public static class d extends i {
        public String xjT;
        public String xjU;

        d() {
            this.mType = 0;
        }

        d(String str, String str2) {
            this();
            this.xjT = str;
            this.xjU = str2;
        }

        public final int hashCode() {
            AppMethodBeat.i(111363);
            int hashCode = ((this.xjT.hashCode() + 629) * 37) + this.xjU.hashCode();
            AppMethodBeat.o(111363);
            return hashCode;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(111364);
            if (!(obj instanceof d) || !this.xjU.equals(((d) obj).xjU) || !this.xjT.equals(((d) obj).xjT)) {
                AppMethodBeat.o(111364);
                return false;
            }
            AppMethodBeat.o(111364);
            return true;
        }
    }

    public static class a extends i {
        public String albumName;
        public d xjI;
        public String xjJ;
        public int xjK;
        public long xjL;
        public String xjM;
        public b xjN;

        public a() {
            this.mType = 1;
        }

        public final void hD(String str, String str2) {
            AppMethodBeat.i(111360);
            this.xjI = new d(str, str2);
            AppMethodBeat.o(111360);
        }

        public final String toString() {
            AppMethodBeat.i(111361);
            String str = "[albumID " + this.xjJ + " albumName " + this.albumName + " albumCapacity " + this.xjK + " albumCoverId " + this.xjL + " albumCoverData " + this.xjM + " albumTag " + this.xjN + "]";
            AppMethodBeat.o(111361);
            return str;
        }
    }

    public static class f extends i {
        public f() {
            this.mType = 2;
        }
    }

    public static class c {
        public List<d> xjR;
        public Map<d, List<a>> xjS;

        public c(List<d> list, Map<d, List<a>> map) {
            this.xjR = list;
            this.xjS = map;
        }
    }

    public static List<GalleryItem.MediaItem> w(List<Long> list, int i2) {
        AppMethodBeat.i(111371);
        ArrayList arrayList = new ArrayList();
        if (Util.isNullOrNil(list)) {
            Log.i("MicroMsg.SmartGalleryQueryUtil", "getFavMediaItemByIds, ids is invalid.");
            AppMethodBeat.o(111371);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        while (true) {
            int size = i3 + 20 < list.size() ? i3 + 20 : list.size();
            ArrayList<com.tencent.mm.plugin.fav.a.g> a2 = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(list.subList(i3, size), null, null, null);
            if (a2 != null && a2.size() > 0) {
                arrayList2.addAll(a2);
            }
            if (size >= list.size()) {
                break;
            }
            i3 = size;
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.fav.a.g gVar = (com.tencent.mm.plugin.fav.a.g) it.next();
            if (gVar.field_favProto.ppH.size() != 0) {
                for (int size2 = gVar.field_favProto.ppH.size() - 1; size2 >= 0; size2--) {
                    aml aml = gVar.field_favProto.ppH.get(size2);
                    if (com.tencent.mm.vfs.s.YS(com.tencent.mm.plugin.fav.a.b.d(aml))) {
                        switch (i2) {
                            case 1:
                                if (aml.dataType == 2) {
                                    GalleryItem.MediaItem a3 = GalleryItem.MediaItem.a(1, -1, com.tencent.mm.plugin.fav.a.b.d(aml), "", "image/fav");
                                    a3.xja = gVar.field_updateTime;
                                    arrayList.add(a3);
                                    break;
                                } else {
                                    break;
                                }
                            case 2:
                                if (aml.dataType != 4 && aml.dataType != 15) {
                                    break;
                                } else {
                                    GalleryItem.MediaItem a4 = GalleryItem.MediaItem.a(2, -1, com.tencent.mm.plugin.fav.a.b.d(aml), "", "video/fav");
                                    a4.xja = gVar.field_updateTime;
                                    arrayList.add(a4);
                                    break;
                                }
                                break;
                            case 3:
                                if (aml.dataType == 2 || aml.dataType == 4 || aml.dataType == 15) {
                                    if (aml.dataType == 2) {
                                        GalleryItem.MediaItem a5 = GalleryItem.MediaItem.a(1, -1, com.tencent.mm.plugin.fav.a.b.d(aml), "", "image/fav");
                                        a5.xja = gVar.field_updateTime;
                                        arrayList.add(a5);
                                        break;
                                    } else {
                                        GalleryItem.MediaItem a6 = GalleryItem.MediaItem.a(2, -1, com.tencent.mm.plugin.fav.a.b.d(aml), "", "video/fav");
                                        a6.xja = gVar.field_updateTime;
                                        arrayList.add(a6);
                                        break;
                                    }
                                } else {
                                    break;
                                }
                                break;
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(111371);
        return arrayList;
    }

    public static class b {
        public e xhZ;
        public boolean xjO = false;
        public boolean xjP = false;
        public boolean xjQ;

        public final String toString() {
            AppMethodBeat.i(111362);
            String str = "isOcr: " + this.xjO + " cropArea: " + (this.xhZ == null ? "" : this.xhZ.toString()) + " coverIsVideo: " + this.xjP;
            AppMethodBeat.o(111362);
            return str;
        }
    }

    public static class e {
        public String id;
        double pKw;
        double pKx;
        double pKy;
        double pKz;
        int xjV = 0;

        public final boolean equals(Object obj) {
            AppMethodBeat.i(111365);
            if (obj == null) {
                AppMethodBeat.o(111365);
                return false;
            }
            boolean equals = ((e) obj).id.equals(this.id);
            AppMethodBeat.o(111365);
            return equals;
        }

        public final String toString() {
            AppMethodBeat.i(111366);
            String str = "crop area info -> cropType:" + this.xjV + " left:" + this.pKw + " top:" + this.pKx + " right:" + this.pKy + " bottom:" + this.pKz + " id:" + this.id;
            AppMethodBeat.o(111366);
            return str;
        }
    }

    public static b hC(String str, String str2) {
        boolean z;
        AppMethodBeat.i(111372);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(111372);
            return null;
        }
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.xjO = jSONObject.optBoolean("ocr", false);
            JSONObject optJSONObject = jSONObject.optJSONObject("cropArea");
            if (optJSONObject != null) {
                int optInt = optJSONObject.optInt("cropType", 0);
                double optDouble = optJSONObject.optDouble("left", -1.0d);
                double optDouble2 = optJSONObject.optDouble("top", -1.0d);
                double optDouble3 = optJSONObject.optDouble("right", -1.0d);
                double optDouble4 = optJSONObject.optDouble("bottom", -1.0d);
                e eVar = new e();
                eVar.xjV = optInt;
                eVar.pKw = optDouble;
                eVar.pKx = optDouble2;
                eVar.pKy = optDouble3;
                eVar.pKz = optDouble4;
                eVar.id = str2;
                bVar.xhZ = eVar;
            }
            if (3 == jSONObject.optInt("coverType", 1)) {
                z = true;
            } else {
                z = false;
            }
            bVar.xjP = z;
            bVar.xjQ = jSONObject.optBoolean("favorite", false);
        } catch (JSONException e2) {
            Log.e("MicroMsg.SmartGalleryQueryUtil", "parse album json error, msg: %s.", e2.getMessage(), e2);
        }
        AppMethodBeat.o(111372);
        return bVar;
    }

    public final void dRy() {
        AppMethodBeat.i(111373);
        Log.i("MicroMsg.SmartGalleryQueryUtil", "clearSelectedMediaPath");
        this.xjH.clear();
        AppMethodBeat.o(111373);
    }

    public final void eW(List<GalleryItem.MediaItem> list) {
        AppMethodBeat.i(111374);
        dRy();
        this.xjH.addAll(list);
        AppMethodBeat.o(111374);
    }

    public final int dRz() {
        AppMethodBeat.i(111375);
        int size = this.xjH.size();
        AppMethodBeat.o(111375);
        return size;
    }

    static LinkedList<GalleryItem.AlbumItem> ap(ArrayList<a> arrayList) {
        AppMethodBeat.i(173744);
        LinkedList<GalleryItem.AlbumItem> linkedList = new LinkedList<>();
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            linkedList.add(new GalleryItem.PrivateAlbumItem(it.next()));
        }
        AppMethodBeat.o(173744);
        return linkedList;
    }
}
