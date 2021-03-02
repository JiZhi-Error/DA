package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0006*\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\u00060\tH\b\u001a$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0005*\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t\u001aF\u0010\f\u001a\u0002H\r\"\u0004\b\u0000\u0010\u0006\"\u0010\b\u0001\u0010\r*\n\u0012\u0006\b\u0000\u0012\u0002H\u00060\u000e*\u00020\u00072\u0006\u0010\u000f\u001a\u0002H\r2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\u00060\tH\b¢\u0006\u0002\u0010\u0010\u001a2\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0005*\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00122\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t\u001a3\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u0002H\u00060\u0014\"\u0004\b\u0000\u0010\u0006*\u00020\u00162\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\u00060\tH\b\u001a*\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\n0\u0014*\u00020\u00162\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t\"\u0013\u0010\u0000\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0018"}, hxF = {"myNfcAdapter", "Landroid/nfc/NfcAdapter;", "getMyNfcAdapter", "()Landroid/nfc/NfcAdapter;", "map", "", "R", "Lorg/json/JSONArray;", "transform", "Lkotlin/Function1;", "", "mapRecursive", "mapTo", "C", "", "destination", "(Lorg/json/JSONArray;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "mapToRecursive", "", "toMap", "", "", "Lorg/json/JSONObject;", "toMapRecursive", "luggage-commons-jsapi-nfc-ext_release"})
public final class a {
    private static List<Object> a(JSONArray jSONArray, b<Object, ? extends Object> bVar) {
        AppMethodBeat.i(183706);
        p.h(jSONArray, "$this$mapRecursive");
        p.h(bVar, "transform");
        List<Object> a2 = a(jSONArray, new ArrayList(jSONArray.length()), bVar);
        AppMethodBeat.o(183706);
        return a2;
    }

    private static List<Object> a(JSONArray jSONArray, List<Object> list, b<Object, ? extends Object> bVar) {
        AppMethodBeat.i(183707);
        p.h(jSONArray, "$this$mapToRecursive");
        p.h(list, "destination");
        p.h(bVar, "transform");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            Object obj = jSONArray.get(i2);
            p.g(obj, "get(index)");
            Object invoke = bVar.invoke(obj);
            if (invoke instanceof JSONObject) {
                invoke = a((JSONObject) invoke, bVar);
            } else if (invoke instanceof JSONArray) {
                invoke = a((JSONArray) invoke, bVar);
            }
            list.add(invoke);
        }
        AppMethodBeat.o(183707);
        return list;
    }

    public static final Map<String, Object> a(JSONObject jSONObject, b<Object, ? extends Object> bVar) {
        AppMethodBeat.i(183708);
        p.h(jSONObject, "$this$toMapRecursive");
        p.h(bVar, "transform");
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        p.g(keys, "keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            p.g(obj, "get(it)");
            Object invoke = bVar.invoke(obj);
            HashMap hashMap2 = hashMap;
            p.g(next, LocaleUtil.ITALIAN);
            if (invoke instanceof JSONObject) {
                invoke = a((JSONObject) invoke, bVar);
            } else if (invoke instanceof JSONArray) {
                invoke = a((JSONArray) invoke, bVar);
            }
            hashMap2.put(next, invoke);
        }
        HashMap hashMap3 = hashMap;
        AppMethodBeat.o(183708);
        return hashMap3;
    }
}
