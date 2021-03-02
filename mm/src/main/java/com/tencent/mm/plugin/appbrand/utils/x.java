package com.tencent.mm.plugin.appbrand.utils;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.sqlitelint.config.SharePluginInfo;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class x {

    public static class a implements m {
        public int ldb = Integer.MAX_VALUE;
        public String ohk = "__nativeBuffers__";
        public String ohl = "key";
        public String ohm = "id";
        public String ohn = "base64";
    }

    public static ByteBuffer aP(byte[] bArr) {
        AppMethodBeat.i(140855);
        if (bArr == null) {
            AppMethodBeat.o(140855);
            return null;
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
        allocateDirect.put(bArr, 0, bArr.length);
        allocateDirect.rewind();
        AppMethodBeat.o(140855);
        return allocateDirect;
    }

    public static ByteBuffer q(ByteBuffer byteBuffer) {
        AppMethodBeat.i(221353);
        if (byteBuffer == null) {
            AppMethodBeat.o(221353);
            return byteBuffer;
        } else if (byteBuffer.isDirect()) {
            AppMethodBeat.o(221353);
            return byteBuffer;
        } else if (!byteBuffer.hasArray()) {
            AppMethodBeat.o(221353);
            return byteBuffer;
        } else {
            ByteBuffer aP = aP(byteBuffer.array());
            AppMethodBeat.o(221353);
            return aP;
        }
    }

    public enum b {
        OK,
        FAIL_SIZE_EXCEED_LIMIT;

        public static b valueOf(String str) {
            AppMethodBeat.i(140853);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(140853);
            return bVar;
        }

        static {
            AppMethodBeat.i(140854);
            AppMethodBeat.o(140854);
        }
    }

    public static final b a(i iVar, Map map, a aVar) {
        boolean z;
        int i2;
        boolean z2;
        JSONException e2;
        int nativeBufferId;
        boolean z3 = false;
        AppMethodBeat.i(140856);
        if (iVar == null || map == null) {
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(iVar == null);
            if (map == null) {
                z3 = true;
            }
            objArr[1] = Boolean.valueOf(z3);
            Log.e("MicroMsg.NativeBufferUtil", "processNativeBufferToJs fail, invalid argument, jsruntime is null:[%b], map is null:[%b]", objArr);
            b bVar = b.OK;
            AppMethodBeat.o(140856);
            return bVar;
        }
        if (aVar == null) {
            aVar = new a();
        }
        k kVar = (k) iVar.R(k.class);
        JSONArray jSONArray = new JSONArray();
        Iterator it = map.entrySet().iterator();
        boolean z4 = false;
        int i3 = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value != null && (value instanceof ByteBuffer)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(aVar.ohl, str);
                    if (kVar == null || (nativeBufferId = kVar.getNativeBufferId()) == -1) {
                        jSONObject.put(aVar.ohn, new String(Base64.encode(d.p((ByteBuffer) value), 2), StandardCharsets.UTF_8));
                        i2 = i3;
                    } else {
                        ByteBuffer byteBuffer = (ByteBuffer) value;
                        if (byteBuffer == null) {
                            Log.w("MicroMsg.NativeBufferUtil", "processNativeBufferToJs byteBuffer is null");
                        } else {
                            kVar.setNativeBuffer(nativeBufferId, byteBuffer);
                            jSONObject.put(aVar.ohm, nativeBufferId);
                            i2 = i3 + byteBuffer.capacity();
                        }
                    }
                    try {
                        jSONArray.put(jSONObject);
                        z2 = true;
                    } catch (JSONException e3) {
                        e2 = e3;
                        Log.w("MicroMsg.NativeBufferUtil", "processNativeBuffer JSONException :%s", e2.getMessage());
                        z2 = z4;
                        it.remove();
                        z4 = z2;
                        i3 = i2;
                    }
                } catch (JSONException e4) {
                    e2 = e4;
                    i2 = i3;
                    Log.w("MicroMsg.NativeBufferUtil", "processNativeBuffer JSONException :%s", e2.getMessage());
                    z2 = z4;
                    it.remove();
                    z4 = z2;
                    i3 = i2;
                }
                it.remove();
                z4 = z2;
                i3 = i2;
            }
        }
        Object[] objArr2 = new Object[2];
        if (kVar != null) {
            z = true;
        } else {
            z = false;
        }
        objArr2[0] = Boolean.valueOf(z);
        objArr2[1] = Integer.valueOf(i3);
        Log.d("MicroMsg.NativeBufferUtil", "ToJs useX5JSCore %b,bufferSize %d", objArr2);
        if (i3 > aVar.ldb) {
            Log.e("MicroMsg.NativeBufferUtil", "bufferSize exceed the limit, bufferSize = %d, limit = %d", Integer.valueOf(i3), Integer.valueOf(aVar.ldb));
            b bVar2 = b.FAIL_SIZE_EXCEED_LIMIT;
            AppMethodBeat.o(140856);
            return bVar2;
        }
        if (z4) {
            map.put(aVar.ohk, jSONArray);
        }
        b bVar3 = b.OK;
        AppMethodBeat.o(140856);
        return bVar3;
    }

    public static final b a(i iVar, p pVar, JSONObject jSONObject, a aVar) {
        int i2;
        AppMethodBeat.i(221354);
        if (iVar == null || jSONObject == null) {
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(iVar == null);
            objArr[1] = Boolean.valueOf(jSONObject == null);
            Log.e("MicroMsg.NativeBufferUtil", "processNativeBufferToJs fail, invalid argument, jsruntime is null:[%b], data is null:[%b]", objArr);
            b bVar = b.OK;
            AppMethodBeat.o(221354);
            return bVar;
        }
        if (aVar == null) {
            aVar = new a();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(aVar.ohk);
        if (optJSONArray == null) {
            b bVar2 = b.OK;
            AppMethodBeat.o(221354);
            return bVar2;
        }
        jSONObject.remove(aVar.ohk);
        int length = optJSONArray.length();
        int i3 = 0;
        int i4 = 0;
        while (i4 < length) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString(aVar.ohl);
                if (!Util.isNullOrNil(optString)) {
                    int optInt = optJSONObject.optInt(aVar.ohm, -1);
                    if (optInt == -1) {
                        try {
                            String optString2 = optJSONObject.optString(aVar.ohn, "");
                            if (Util.isNullOrNil(optString2)) {
                                Log.i("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs base64 is null");
                                jSONObject.put(optString, ByteBuffer.allocate(0));
                                i2 = i3;
                            } else {
                                jSONObject.put(optString, ByteBuffer.wrap(Base64.decode(optString2.getBytes(Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET)), 2)));
                                i2 = i3;
                            }
                        } catch (JSONException e2) {
                            Log.w("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs JSONException :%s", e2.getMessage());
                        }
                    } else {
                        k kVar = (k) iVar.R(k.class);
                        if (kVar == null) {
                            Log.w("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs bufferAddon is null, not support");
                            i2 = i3;
                        } else {
                            ByteBuffer N = pVar == null ? kVar.N(optInt, false) : pVar.a(optString, kVar, optInt);
                            if (N == null) {
                                Log.w("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs byteBuffer is null");
                                i2 = i3;
                            } else {
                                N.position(0);
                                jSONObject.put(optString, N);
                                i2 = N.capacity() + i3;
                            }
                        }
                    }
                    i4++;
                    i3 = i2;
                }
            }
            i2 = i3;
            i4++;
            i3 = i2;
        }
        Log.d("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs bufferSize %d", Integer.valueOf(i3));
        if (i3 > aVar.ldb) {
            Log.e("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs fail, size exceed limit, bufferSize = %d, limit = %d", Integer.valueOf(i3), Integer.valueOf(aVar.ldb));
            b bVar3 = b.FAIL_SIZE_EXCEED_LIMIT;
            AppMethodBeat.o(221354);
            return bVar3;
        }
        b bVar4 = b.OK;
        AppMethodBeat.o(221354);
        return bVar4;
    }

    public static void m(f fVar, String str) {
        AppMethodBeat.i(140858);
        HashMap hashMap = new HashMap();
        hashMap.put("message", "convert native buffer parameter fail, event=" + str + ", error=native buffer exceed size limit");
        hashMap.put(SharePluginInfo.ISSUE_KEY_STACK, "");
        fVar.co("onError", new JSONObject(hashMap).toString());
        AppMethodBeat.o(140858);
    }
}
