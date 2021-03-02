package com.tencent.tbs.one.impl.common;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public int f2555a;

    /* renamed from: b  reason: collision with root package name */
    private String f2556b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, a> f2557c;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f2558a;

        /* renamed from: b  reason: collision with root package name */
        public String f2559b;

        /* renamed from: c  reason: collision with root package name */
        public int f2560c;

        /* renamed from: d  reason: collision with root package name */
        public String f2561d;

        /* renamed from: e  reason: collision with root package name */
        public String f2562e;

        /* renamed from: f  reason: collision with root package name */
        public String[] f2563f;
    }

    private d(JSONObject jSONObject) {
        AppMethodBeat.i(174180);
        this.f2556b = jSONObject.optString("VERSIONNAME");
        this.f2555a = jSONObject.optInt("VERSIONCODE");
        JSONArray optJSONArray = jSONObject.optJSONArray("COMPONENTS");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            int length = optJSONArray.length();
            this.f2557c = new HashMap(length);
            for (int i2 = 0; i2 < length; i2++) {
                a a2 = a(optJSONArray.optJSONObject(i2));
                if (a2 != null) {
                    this.f2557c.put(a2.f2558a, a2);
                }
            }
        }
        AppMethodBeat.o(174180);
    }

    private static a a(JSONObject jSONObject) {
        a aVar = null;
        AppMethodBeat.i(174181);
        if (jSONObject == null) {
            AppMethodBeat.o(174181);
        } else {
            String optString = jSONObject.optString("NAME");
            if (TextUtils.isEmpty(optString)) {
                AppMethodBeat.o(174181);
            } else {
                aVar = new a();
                aVar.f2558a = optString;
                aVar.f2559b = jSONObject.optString("VERSIONNAME");
                aVar.f2560c = jSONObject.optInt("VERSIONCODE");
                aVar.f2561d = jSONObject.optString("URL");
                aVar.f2562e = jSONObject.optString("MD5");
                JSONArray optJSONArray = jSONObject.optJSONArray("DEPENDENCIES");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    aVar.f2563f = new String[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        aVar.f2563f[i2] = optJSONArray.optString(i2);
                    }
                }
                AppMethodBeat.o(174181);
            }
        }
        return aVar;
    }

    public static d a(File file) {
        FileInputStream fileInputStream;
        FileNotFoundException e2;
        AppMethodBeat.i(174177);
        try {
            fileInputStream = new FileInputStream(file);
            try {
                d a2 = a(fileInputStream);
                c.a(fileInputStream);
                AppMethodBeat.o(174177);
                return a2;
            } catch (FileNotFoundException e3) {
                e2 = e3;
                try {
                    TBSOneException tBSOneException = new TBSOneException(TbsListener.ErrorCode.THROWABLE_QBSDK_INIT, "Failed to open DEPS file", e2);
                    AppMethodBeat.o(174177);
                    throw tBSOneException;
                } catch (Throwable th) {
                    th = th;
                    c.a(fileInputStream);
                    AppMethodBeat.o(174177);
                    throw th;
                }
            }
        } catch (FileNotFoundException e4) {
            e2 = e4;
            fileInputStream = null;
            TBSOneException tBSOneException2 = new TBSOneException(TbsListener.ErrorCode.THROWABLE_QBSDK_INIT, "Failed to open DEPS file", e2);
            AppMethodBeat.o(174177);
            throw tBSOneException2;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            c.a(fileInputStream);
            AppMethodBeat.o(174177);
            throw th;
        }
    }

    private static d a(InputStream inputStream) {
        AppMethodBeat.i(174178);
        try {
            d a2 = a(c.a(inputStream, ProtocolPackage.ServerEncoding));
            AppMethodBeat.o(174178);
            return a2;
        } catch (IOException e2) {
            TBSOneException tBSOneException = new TBSOneException(TbsListener.ErrorCode.ERROR_CANLOADX5_RETURN_FALSE, "Failed to read DEPS contents", e2);
            AppMethodBeat.o(174178);
            throw tBSOneException;
        }
    }

    public static d a(String str) {
        AppMethodBeat.i(174179);
        try {
            d dVar = new d(new JSONObject(str));
            AppMethodBeat.o(174179);
            return dVar;
        } catch (JSONException e2) {
            TBSOneException tBSOneException = new TBSOneException(TbsListener.ErrorCode.ERROR_CANLOADX5_RETURN_NULL, "Failed to parse DEPS " + str + ", " + e2.getMessage(), e2);
            AppMethodBeat.o(174179);
            throw tBSOneException;
        }
    }

    public final a b(String str) {
        AppMethodBeat.i(174182);
        if (this.f2557c == null) {
            AppMethodBeat.o(174182);
            return null;
        }
        a aVar = this.f2557c.get(str);
        AppMethodBeat.o(174182);
        return aVar;
    }
}
