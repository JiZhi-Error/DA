package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.s;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0010J8\u0010\u0011\u001a*\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00100\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012j\u0002`\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0002J \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013J,\u0010\u0019\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0010\u0012\u0004\u0012\u00020\u00140\u0012j\u0002`\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J.\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\"\u0010\u001e\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0010\u0012\u0004\u0012\u00020\u00140\u0012j\u0002`\u001aH\u0002J\"\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\u0018\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00100\u0013J\u0016\u0010!\u001a\u0004\u0018\u00010\u000e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NdefMessageConverter;", "", "()V", "MAP_KEY_MESSAGES", "", "MAP_KEY_RECORDS", "NDEF_RECORD_FIELD_ID", "NDEF_RECORD_FIELD_PAYLOAD", "NDEF_RECORD_FIELD_TNF", "NDEF_RECORD_FIELD_TYPE", "PARAM_LANGUAGE", "PARAM_TEXT", "TAG", "map2Message", "Landroid/nfc/NdefMessage;", "messageMap", "", "message2MessageMap", "Lkotlin/Pair;", "", "Ljava/nio/ByteBuffer;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/MessageMap;", "message", "messages2Map", "messages", "record2RecordMap", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/RecordMap;", "record", "Landroid/nfc/NdefRecord;", "recordMap2Record", "recordMap", "texts2Message", "textAndLanguages", "uris2Message", "uris", "luggage-commons-jsapi-nfc-ext_release"})
public final class c {
    public static final c mju = new c();

    static {
        AppMethodBeat.i(183705);
        AppMethodBeat.o(183705);
    }

    private c() {
    }

    public static Map<String, Object> bE(List<NdefMessage> list) {
        AppMethodBeat.i(183699);
        p.h(list, "messages");
        Log.d("MicroMsg.AppBrand.NdefMessageConverter", "messages2Map, messages: ".concat(String.valueOf(list)));
        List<NdefMessage> list2 = list;
        ArrayList arrayList = new ArrayList(j.a(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(a((NdefMessage) it.next()));
        }
        ArrayList arrayList2 = arrayList;
        o[] oVarArr = new o[1];
        ArrayList<o> arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(j.a(arrayList3, 10));
        for (o oVar : arrayList3) {
            arrayList4.add(oVar.first);
        }
        oVarArr[0] = s.U("messages", arrayList4);
        Map<String, Object> f2 = ae.f(oVarArr);
        int i2 = 0;
        for (Object obj : arrayList2) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            int i4 = 0;
            for (Object obj2 : ((o) obj).second) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    j.hxH();
                }
                f2.put("payload-" + i2 + '-' + i4, (ByteBuffer) obj2);
                i4 = i5;
            }
            i2 = i3;
        }
        Log.d("MicroMsg.AppBrand.NdefMessageConverter", "messages2Map, map: ".concat(String.valueOf(f2)));
        AppMethodBeat.o(183699);
        return f2;
    }

    public static NdefMessage Q(Map<String, ? extends Object> map) {
        int i2 = 0;
        NdefMessage ndefMessage = null;
        AppMethodBeat.i(183700);
        p.h(map, "messageMap");
        Log.d("MicroMsg.AppBrand.NdefMessageConverter", "map2Message, messageMap: ".concat(String.valueOf(map)));
        Object obj = map.get("records");
        if (!(obj instanceof List)) {
            obj = null;
        }
        List list = (List) obj;
        if (list == null) {
            AppMethodBeat.o(183700);
        } else {
            List list2 = list;
            ArrayList arrayList = new ArrayList(j.a(list2, 10));
            Iterator it = list2.iterator();
            while (true) {
                if (it.hasNext()) {
                    Object next = it.next();
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        j.hxH();
                    }
                    Map map2 = (Map) next;
                    Log.d("MicroMsg.AppBrand.NdefMessageConverter", "map2Message, index: " + i2 + ", map: " + map2);
                    Object obj2 = map.get("payload-".concat(String.valueOf(i2)));
                    if (!(obj2 instanceof ByteBuffer)) {
                        obj2 = null;
                    }
                    ByteBuffer byteBuffer = (ByteBuffer) obj2;
                    if (byteBuffer == null) {
                        AppMethodBeat.o(183700);
                        break;
                    }
                    Log.d("MicroMsg.AppBrand.NdefMessageConverter", "map2Message, byteBuffer: ".concat(String.valueOf(byteBuffer)));
                    arrayList.add(a(s.U(map2, byteBuffer)));
                    i2 = i3;
                } else {
                    ArrayList arrayList2 = arrayList;
                    Log.d("MicroMsg.AppBrand.NdefMessageConverter", "map2Message, records: ".concat(String.valueOf(arrayList2)));
                    try {
                        Object[] array = arrayList2.toArray(new NdefRecord[0]);
                        if (array == null) {
                            t tVar = new t("null cannot be cast to non-null type kotlin.Array<T>");
                            AppMethodBeat.o(183700);
                            throw tVar;
                        }
                        ndefMessage = new NdefMessage((NdefRecord[]) array);
                        AppMethodBeat.o(183700);
                    } catch (Exception e2) {
                        Log.w("MicroMsg.AppBrand.NdefMessageConverter", "create NdefMessage failed since ".concat(String.valueOf(e2)));
                    }
                }
            }
        }
        return ndefMessage;
    }

    public static NdefMessage bF(List<String> list) {
        NdefMessage ndefMessage;
        AppMethodBeat.i(183701);
        p.h(list, "uris");
        List<String> list2 = list;
        ArrayList arrayList = new ArrayList(j.a(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(NdefRecord.createUri((String) it.next()));
            } catch (Exception e2) {
                Log.w("MicroMsg.AppBrand.NdefMessageConverter", "createUri failed since ".concat(String.valueOf(e2)));
                AppMethodBeat.o(183701);
                return null;
            }
        }
        Object[] array = arrayList.toArray(new NdefRecord[0]);
        if (array == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(183701);
            throw tVar;
        }
        try {
            ndefMessage = new NdefMessage((NdefRecord[]) array);
        } catch (Exception e3) {
            Log.w("MicroMsg.AppBrand.NdefMessageConverter", "create NdefMessage failed since ".concat(String.valueOf(e3)));
            ndefMessage = null;
        }
        AppMethodBeat.o(183701);
        return ndefMessage;
    }

    public static NdefMessage bG(List<? extends Map<String, String>> list) {
        NdefMessage ndefMessage;
        AppMethodBeat.i(183702);
        p.h(list, "textAndLanguages");
        List<? extends Map<String, String>> list2 = list;
        ArrayList arrayList = new ArrayList(j.a(list2, 10));
        for (T t : list2) {
            String str = (String) t.get("text");
            if (str == null) {
                AppMethodBeat.o(183702);
                return null;
            }
            String str2 = (String) t.get(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
            if (str2 == null) {
                AppMethodBeat.o(183702);
                return null;
            }
            try {
                arrayList.add(NdefRecord.createTextRecord(str2, str));
            } catch (Exception e2) {
                Log.w("MicroMsg.AppBrand.NdefMessageConverter", "createTextRecord failed since ".concat(String.valueOf(e2)));
                AppMethodBeat.o(183702);
                return null;
            }
        }
        Object[] array = arrayList.toArray(new NdefRecord[0]);
        if (array == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(183702);
            throw tVar;
        }
        try {
            ndefMessage = new NdefMessage((NdefRecord[]) array);
        } catch (Exception e3) {
            Log.w("MicroMsg.AppBrand.NdefMessageConverter", "create NdefMessage failed since ".concat(String.valueOf(e3)));
            ndefMessage = null;
        }
        AppMethodBeat.o(183702);
        return ndefMessage;
    }

    private static o<List<Map<String, Object>>, List<ByteBuffer>> a(NdefMessage ndefMessage) {
        AppMethodBeat.i(183703);
        Log.d("MicroMsg.AppBrand.NdefMessageConverter", "message2MessageMap, message: ".concat(String.valueOf(ndefMessage)));
        NdefRecord[] records = ndefMessage.getRecords();
        p.g(records, "message.records");
        ArrayList arrayList = new ArrayList(records.length);
        for (NdefRecord ndefRecord : records) {
            p.g(ndefRecord, LocaleUtil.ITALIAN);
            Log.d("MicroMsg.AppBrand.NdefMessageConverter", "record2RecordMap, record: ".concat(String.valueOf(ndefRecord)));
            byte[] encode = Base64.encode(ndefRecord.getType(), 2);
            p.g(encode, "Base64.encode(record.type, Base64.NO_WRAP)");
            Charset charset = StandardCharsets.UTF_8;
            p.g(charset, "StandardCharsets.UTF_8");
            byte[] encode2 = Base64.encode(ndefRecord.getId(), 2);
            p.g(encode2, "Base64.encode(record.id, Base64.NO_WRAP)");
            Charset charset2 = StandardCharsets.UTF_8;
            p.g(charset2, "StandardCharsets.UTF_8");
            Map e2 = ae.e(s.U("tnf", Short.valueOf(ndefRecord.getTnf())), s.U("type", new String(encode, charset)), s.U("id", new String(encode2, charset2)));
            Log.d("MicroMsg.AppBrand.NdefMessageConverter", "record2RecordMap, map: ".concat(String.valueOf(e2)));
            arrayList.add(s.U(e2, x.aP(ndefRecord.getPayload())));
        }
        ArrayList arrayList2 = arrayList;
        ArrayList<o> arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(j.a(arrayList3, 10));
        for (o oVar : arrayList3) {
            arrayList4.add(oVar.first);
        }
        ArrayList arrayList5 = arrayList4;
        ArrayList<o> arrayList6 = arrayList2;
        ArrayList arrayList7 = new ArrayList(j.a(arrayList6, 10));
        for (o oVar2 : arrayList6) {
            arrayList7.add(oVar2.second);
        }
        o<List<Map<String, Object>>, List<ByteBuffer>> U = s.U(arrayList5, arrayList7);
        Log.d("MicroMsg.AppBrand.NdefMessageConverter", "message2MessageMap, messageMap: ".concat(String.valueOf(U)));
        AppMethodBeat.o(183703);
        return U;
    }

    private static NdefRecord a(o<? extends Map<String, ? extends Object>, ? extends ByteBuffer> oVar) {
        byte[] bArr;
        byte[] bArr2;
        NdefRecord ndefRecord = null;
        AppMethodBeat.i(183704);
        Log.d("MicroMsg.AppBrand.NdefMessageConverter", "recordMap2Record, recordMap: ".concat(String.valueOf(oVar)));
        A a2 = oVar.first;
        B b2 = oVar.second;
        Object obj = a2.get("tnf");
        if (!(obj instanceof Integer)) {
            obj = null;
        }
        Integer num = (Integer) obj;
        if (num != null) {
            int intValue = num.intValue();
            Object obj2 = a2.get("type");
            if (!(obj2 instanceof String)) {
                obj2 = null;
            }
            String str = (String) obj2;
            if (str != null) {
                bArr = Base64.decode(str, 2);
            } else {
                bArr = null;
            }
            Object obj3 = a2.get("id");
            if (!(obj3 instanceof String)) {
                obj3 = null;
            }
            String str2 = (String) obj3;
            if (str2 != null) {
                bArr2 = Base64.decode(str2, 2);
            } else {
                bArr2 = null;
            }
            try {
                ndefRecord = new NdefRecord((short) intValue, bArr, bArr2, d.p(b2));
            } catch (Exception e2) {
                Log.w("MicroMsg.AppBrand.NdefMessageConverter", "recordMap2Record failed since ".concat(String.valueOf(e2)));
            }
            AppMethodBeat.o(183704);
        } else {
            AppMethodBeat.o(183704);
        }
        return ndefRecord;
    }
}
