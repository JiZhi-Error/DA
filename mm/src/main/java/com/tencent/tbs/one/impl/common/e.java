package com.tencent.tbs.one.impl.common;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public int f2564a;

    /* renamed from: b  reason: collision with root package name */
    public String f2565b;

    /* renamed from: c  reason: collision with root package name */
    public String f2566c;

    /* renamed from: d  reason: collision with root package name */
    public String f2567d;

    /* renamed from: e  reason: collision with root package name */
    public a[] f2568e;

    /* renamed from: f  reason: collision with root package name */
    public Pair<String, String>[] f2569f;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f2570a;

        /* renamed from: b  reason: collision with root package name */
        public String f2571b;

        /* renamed from: c  reason: collision with root package name */
        public String f2572c;

        /* renamed from: d  reason: collision with root package name */
        public b f2573d;
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f2574a;

        /* renamed from: b  reason: collision with root package name */
        public String f2575b;
    }

    private e(JSONObject jSONObject) {
        a aVar;
        AppMethodBeat.i(174253);
        this.f2564a = jSONObject.optInt("VERSIONCODE");
        this.f2565b = jSONObject.optString("RESOURCE");
        String optString = jSONObject.optString("ENTRY");
        if (!TextUtils.isEmpty(optString)) {
            String[] split = optString.split(":");
            if (split.length == 1) {
                this.f2566c = split[0];
            } else if (split.length >= 2) {
                this.f2566c = split[0];
                this.f2567d = split[1];
            }
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("FILES");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            int length = optJSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject == null) {
                    aVar = null;
                } else {
                    String optString2 = optJSONObject.optString("PATH");
                    if (TextUtils.isEmpty(optString2)) {
                        aVar = null;
                    } else {
                        aVar = new a();
                        aVar.f2570a = optString2;
                        aVar.f2571b = optJSONObject.optString("MD5");
                        aVar.f2572c = optJSONObject.optString("SEALED");
                        String optString3 = optJSONObject.optString("PARENT");
                        if (!TextUtils.isEmpty(optString3)) {
                            b bVar = new b();
                            String[] split2 = optString3.split(":");
                            if (split2.length == 1) {
                                bVar.f2575b = split2[0];
                            } else {
                                bVar.f2574a = split2[0];
                                bVar.f2575b = split2[1];
                            }
                            aVar.f2573d = bVar;
                        }
                    }
                }
                if (aVar != null) {
                    arrayList.add(aVar);
                }
            }
            this.f2568e = (a[]) arrayList.toArray(new a[0]);
        }
        a(jSONObject.optJSONArray("RECEIVERS"));
        AppMethodBeat.o(174253);
    }

    public static e a(File file) {
        FileInputStream fileInputStream;
        JSONException e2;
        IOException e3;
        FileNotFoundException e4;
        AppMethodBeat.i(174252);
        try {
            fileInputStream = new FileInputStream(file);
            try {
                e eVar = new e(new JSONObject(c.a(fileInputStream, ProtocolPackage.ServerEncoding)));
                c.a(fileInputStream);
                AppMethodBeat.o(174252);
                return eVar;
            } catch (FileNotFoundException e5) {
                e4 = e5;
                try {
                    TBSOneException tBSOneException = new TBSOneException(401, "Failed to open MANIFEST file " + file.getAbsolutePath(), e4);
                    AppMethodBeat.o(174252);
                    throw tBSOneException;
                } catch (Throwable th) {
                    th = th;
                    c.a(fileInputStream);
                    AppMethodBeat.o(174252);
                    throw th;
                }
            } catch (IOException e6) {
                e3 = e6;
                TBSOneException tBSOneException2 = new TBSOneException(402, "Failed to read MANIFEST file " + file.getAbsolutePath(), e3);
                AppMethodBeat.o(174252);
                throw tBSOneException2;
            } catch (JSONException e7) {
                e2 = e7;
                TBSOneException tBSOneException3 = new TBSOneException(403, "Failed to parse MANIFEST json from file " + file.getAbsolutePath() + ", " + e2.getMessage(), e2);
                AppMethodBeat.o(174252);
                throw tBSOneException3;
            }
        } catch (FileNotFoundException e8) {
            e4 = e8;
            fileInputStream = null;
            TBSOneException tBSOneException4 = new TBSOneException(401, "Failed to open MANIFEST file " + file.getAbsolutePath(), e4);
            AppMethodBeat.o(174252);
            throw tBSOneException4;
        } catch (IOException e9) {
            e3 = e9;
            TBSOneException tBSOneException22 = new TBSOneException(402, "Failed to read MANIFEST file " + file.getAbsolutePath(), e3);
            AppMethodBeat.o(174252);
            throw tBSOneException22;
        } catch (JSONException e10) {
            e2 = e10;
            TBSOneException tBSOneException32 = new TBSOneException(403, "Failed to parse MANIFEST json from file " + file.getAbsolutePath() + ", " + e2.getMessage(), e2);
            AppMethodBeat.o(174252);
            throw tBSOneException32;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            c.a(fileInputStream);
            AppMethodBeat.o(174252);
            throw th;
        }
    }

    private void a(JSONArray jSONArray) {
        AppMethodBeat.i(174254);
        if (jSONArray == null || jSONArray.length() <= 0) {
            AppMethodBeat.o(174254);
            return;
        }
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            String optString = optJSONObject.optString("CLASS");
            JSONArray optJSONArray = optJSONObject.optJSONArray("EVENTS");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length2 = optJSONArray.length();
                for (int i3 = 0; i3 < length2; i3++) {
                    arrayList.add(new Pair(optJSONArray.optString(i3), optString));
                }
            }
        }
        this.f2569f = (Pair[]) arrayList.toArray(new Pair[0]);
        AppMethodBeat.o(174254);
    }

    public final a a(String str) {
        AppMethodBeat.i(174251);
        a[] aVarArr = this.f2568e;
        for (a aVar : aVarArr) {
            if (aVar.f2570a.equals(str)) {
                AppMethodBeat.o(174251);
                return aVar;
            }
        }
        AppMethodBeat.o(174251);
        return null;
    }
}
