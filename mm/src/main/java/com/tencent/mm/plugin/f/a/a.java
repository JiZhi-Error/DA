package com.tencent.mm.plugin.f.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.f.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.List;

public abstract class a {
    /* access modifiers changed from: protected */
    public abstract List<com.tencent.mm.plugin.f.b.a> ap(ca caVar);

    /* access modifiers changed from: protected */
    public abstract String info();

    public final void ao(ca caVar) {
        int i2 = 0;
        if (caVar != null) {
            List<com.tencent.mm.plugin.f.b.a> ar = b.crW().crX().ar(caVar);
            List<com.tencent.mm.plugin.f.b.a> ap = ap(caVar);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int a2 = a(ar, ap, arrayList, arrayList2);
            Object[] objArr = new Object[6];
            objArr[0] = info();
            objArr[1] = Integer.valueOf(a2);
            objArr[2] = Integer.valueOf(ar != null ? ar.size() : 0);
            if (ap != null) {
                i2 = ap.size();
            }
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = Integer.valueOf(arrayList.size());
            objArr[5] = Integer.valueOf(arrayList2.size());
            Log.i("MicroMsg.AbstractMsgHandler", "%s handle compare[%d] db[%d] create[%d] insert[%d] update[%d]", objArr);
            if (a2 >= 0) {
                if (!arrayList.isEmpty()) {
                    b.crW().crX().cQ(arrayList);
                }
                if (!arrayList2.isEmpty()) {
                    b.crW().crX().cR(arrayList2);
                }
            }
        }
    }

    private static int a(List<com.tencent.mm.plugin.f.b.a> list, List<com.tencent.mm.plugin.f.b.a> list2, List<com.tencent.mm.plugin.f.b.a> list3, List<com.tencent.mm.plugin.f.b.a> list4) {
        if (list2 == null || list2.isEmpty()) {
            return -1;
        }
        if (list == null || list.isEmpty()) {
            for (com.tencent.mm.plugin.f.b.a aVar : list2) {
                list3.add(aVar);
            }
            return 0;
        }
        int size = list.size();
        int size2 = list2.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size2) {
            com.tencent.mm.plugin.f.b.a aVar2 = list2.get(i2);
            if (aVar2 == null) {
                break;
            }
            com.tencent.mm.plugin.f.b.a aVar3 = i3 < size ? list.get(i3) : null;
            if (aVar3 == null) {
                break;
            } else if (aVar2.field_msgSubType != aVar3.field_msgSubType) {
                if (aVar2.field_msgSubType >= aVar3.field_msgSubType) {
                    break;
                }
                list3.add(aVar2);
                i2++;
            } else {
                if (!Util.isEqual(aVar2.field_path, aVar3.field_path)) {
                    aVar2.systemRowid = aVar3.systemRowid;
                    list4.add(aVar2);
                } else if (!Util.isEqual(aVar2.field_size, aVar3.field_size)) {
                    aVar2.systemRowid = aVar3.systemRowid;
                    list4.add(aVar2);
                }
                i2++;
                i3++;
            }
        }
        return 1;
    }

    protected static com.tencent.mm.plugin.f.b.a aq(ca caVar) {
        com.tencent.mm.plugin.f.b.a aVar = new com.tencent.mm.plugin.f.b.a();
        aVar.field_msgId = caVar.field_msgId;
        aVar.field_msgType = caVar.getType();
        aVar.field_username = caVar.field_talker;
        aVar.field_msgtime = caVar.field_createTime;
        return aVar;
    }

    /* access modifiers changed from: protected */
    public final String bxr(String str) {
        if (Util.isNullOrNil(str)) {
            return "";
        }
        String str2 = g.aAh().hqF;
        int indexOf = str.indexOf(str2);
        if (indexOf < 0) {
            return str;
        }
        String substring = str.substring(indexOf + str2.length());
        Log.d("MicroMsg.AbstractMsgHandler", "%s cut down result[%s] root[%s] path[%s]", info(), substring, str2, str);
        return substring;
    }
}
