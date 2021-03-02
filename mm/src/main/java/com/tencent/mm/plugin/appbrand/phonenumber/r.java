package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eJ.\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000eJ\"\u0010\u0012\u001a\u00020\n2\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u0015J\u0016\u0010\u0016\u001a\u00020\n2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000eJ\u0010\u0010\u0017\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItemsManager;", "", "()V", "PHONE_ITEMS", "", "TAG", "mmKv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "addPhone", "", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getPhoneNumbers", "", "process", "phoneItems", "oldPhoneItems", "removePhone", "delPhoneItems", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "savePhoneNumbers", "selectPhone", "updatePhoneItem", "luggage-wechat-full-sdk_release"})
public final class r {
    private static final MultiProcessMMKV nzB = MultiProcessMMKV.getMMKV("MicroMsg.PhoneItemsManager");
    public static final r nzC = new r();

    static {
        AppMethodBeat.i(148084);
        AppMethodBeat.o(148084);
    }

    private r() {
    }

    public static List<PhoneItem> j(List<PhoneItem> list, List<PhoneItem> list2) {
        boolean z;
        AppMethodBeat.i(148078);
        if (list == null) {
            AppMethodBeat.o(148078);
            return null;
        }
        if (list2 != null) {
            Iterator<PhoneItem> it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PhoneItem next = it.next();
                if (next.nzz) {
                    Iterator<PhoneItem> it2 = list.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z = false;
                            break;
                        }
                        PhoneItem next2 = it2.next();
                        if (p.j(next.dSf, next2.dSf)) {
                            next2.nzz = true;
                            z = true;
                            break;
                        }
                    }
                }
            }
        }
        z = false;
        if (!z && list.size() > 0) {
            list.get(0).nzz = true;
        }
        Log.v("MicroMsg.PhoneItemsManager", "init oldphoneItems:%s", list2);
        Log.v("MicroMsg.PhoneItemsManager", "init phoneItems:%s", list);
        AppMethodBeat.o(148078);
        return list;
    }

    public static List<PhoneItem> bTy() {
        JSONArray jSONArray;
        AppMethodBeat.i(148079);
        try {
            jSONArray = new JSONArray(nzB.getString("PhoneItemsManager#PhoneItems", "{}"));
        } catch (Exception e2) {
            Log.e("MicroMsg.PhoneItemsManager", "e:%s", e2);
            jSONArray = null;
        }
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                PhoneItem.a aVar = PhoneItem.nzA;
                String string = jSONArray.getString(i2);
                p.g(string, "jsonArray.getString(i)");
                PhoneItem aet = PhoneItem.a.aet(string);
                if (aet != null) {
                    arrayList.add(aet);
                }
            }
        }
        Log.d("MicroMsg.PhoneItemsManager", "get %s", String.valueOf(jSONArray));
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(148079);
        return arrayList2;
    }

    public static void bQ(List<PhoneItem> list) {
        AppMethodBeat.i(148080);
        if (list == null) {
            AppMethodBeat.o(148080);
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (PhoneItem phoneItem : list) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mobile", phoneItem.dSf);
            jSONObject.put("show_mobile", phoneItem.nzt);
            jSONObject.put("need_auth", phoneItem.nzw);
            jSONObject.put("allow_send_sms", phoneItem.nzx);
            jSONObject.put("encryptedData", phoneItem.nzu);
            jSONObject.put("iv", phoneItem.bxK);
            jSONObject.put("cloud_id", phoneItem.nzv);
            jSONObject.put("is_wechat", phoneItem.nzy);
            jSONObject.put("is_check", phoneItem.nzz);
            String jSONObject2 = jSONObject.toString();
            p.g(jSONObject2, "jsonObject.toString()");
            jSONArray.put(jSONObject2);
        }
        nzB.putString("PhoneItemsManager#PhoneItems", jSONArray.toString());
        nzB.commit();
        Log.d("MicroMsg.PhoneItemsManager", "savePhoneNumbers %s", jSONArray.toString());
        AppMethodBeat.o(148080);
    }

    public static void b(PhoneItem phoneItem) {
        AppMethodBeat.i(148081);
        List<PhoneItem> bTy = bTy();
        if (phoneItem != null) {
            for (PhoneItem phoneItem2 : bTy) {
                phoneItem2.nzz = false;
            }
            for (PhoneItem phoneItem3 : bTy) {
                if (p.j(phoneItem.dSf, phoneItem3.dSf)) {
                    phoneItem3.nzz = true;
                }
            }
        }
        bQ(bTy);
        Log.v("MicroMsg.PhoneItemsManager", "uninit phoneItems:%s", bTy);
        AppMethodBeat.o(148081);
    }

    public static void c(PhoneItem phoneItem) {
        AppMethodBeat.i(148082);
        p.h(phoneItem, "phoneItem");
        ArrayList arrayList = (ArrayList) bTy();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PhoneItem) it.next()).nzz = false;
        }
        if (arrayList.contains(phoneItem)) {
            arrayList.set(arrayList.indexOf(phoneItem), phoneItem);
        } else {
            arrayList.add(phoneItem);
        }
        bQ(arrayList);
        AppMethodBeat.o(148082);
    }

    public final synchronized void K(ArrayList<PhoneItem> arrayList) {
        boolean z;
        AppMethodBeat.i(148083);
        if (arrayList == null) {
            Log.w("MicroMsg.PhoneItemsManager", "delPhoneItems is null");
            AppMethodBeat.o(148083);
        } else {
            ArrayList arrayList2 = (ArrayList) bTy();
            Iterator<PhoneItem> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.remove(it.next());
            }
            Iterator it2 = arrayList2.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (((PhoneItem) it2.next()).nzz) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z && arrayList2.size() > 0) {
                ((PhoneItem) arrayList2.get(0)).nzz = true;
            }
            Log.v("MicroMsg.PhoneItemsManager", "remove phoneItems:%s", arrayList2);
            bQ(arrayList2);
            AppMethodBeat.o(148083);
        }
    }
}
