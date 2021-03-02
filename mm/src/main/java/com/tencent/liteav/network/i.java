package com.tencent.liteav.network;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;
import org.json.JSONObject;

public class i {

    /* renamed from: a  reason: collision with root package name */
    protected static i f992a = new i();

    /* renamed from: b  reason: collision with root package name */
    private Context f993b = null;

    /* renamed from: c  reason: collision with root package name */
    private long f994c = 3;

    static {
        AppMethodBeat.i(15466);
        AppMethodBeat.o(15466);
    }

    public static i a() {
        return f992a;
    }

    protected i() {
    }

    public void a(Context context) {
        AppMethodBeat.i(15456);
        if (this.f993b == null) {
            this.f993b = context.getApplicationContext();
        }
        AppMethodBeat.o(15456);
    }

    public String b() {
        AppMethodBeat.i(15457);
        try {
            if (this.f993b != null) {
                int e2 = f.e(this.f993b);
                if (e2 == 0) {
                    AppMethodBeat.o(15457);
                    return "";
                } else if (e2 == 1) {
                    AppMethodBeat.o(15457);
                    return "wifi:";
                } else if (e2 == 2) {
                    AppMethodBeat.o(15457);
                    return "4g:";
                } else if (e2 == 3) {
                    AppMethodBeat.o(15457);
                    return "3g:";
                } else if (e2 == 4) {
                    AppMethodBeat.o(15457);
                    return "2g:";
                } else if (e2 == 5) {
                    AppMethodBeat.o(15457);
                    return "ethernet:";
                } else {
                    AppMethodBeat.o(15457);
                    return "xg:";
                }
            }
        } catch (Exception e3) {
            TXCLog.e("UploadQualityData", "get network type failed." + e3.getMessage());
        }
        AppMethodBeat.o(15457);
        return "";
    }

    public void a(String str, long j2, long j3, long j4, float f2, float f3, float f4) {
        JSONObject jSONObject;
        JSONArray jSONArray;
        AppMethodBeat.i(15458);
        if (!(c.a().a("Network", "QualityDataCacheCount") > 0)) {
            AppMethodBeat.o(15458);
            return;
        }
        TXCLog.e("UploadQualityData", String.format("updateQualityData: accessID = %s serverType = %d totalTime = %d networkRTT = %d avgBlockCnt = %f avgVideoQue = %f avgAudioQue = %f", str, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)));
        if (b(str)) {
            AppMethodBeat.o(15458);
            return;
        }
        try {
            SharedPreferences sharedPreferences = this.f993b.getSharedPreferences("com.tencent.liteav.network", 0);
            JSONObject c2 = c(sharedPreferences.getString("34238512-C08C-4931-A000-40E1D8B5BA5B", ""));
            JSONObject optJSONObject = c2.optJSONObject(str);
            if (optJSONObject == null) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = optJSONObject;
            }
            String str2 = j2 == 3 ? "DomainArrayData" : "OriginArrayData";
            JSONArray optJSONArray = jSONObject.optJSONArray(str2);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("totalTime", j3);
            jSONObject2.put("networkRTT", j4);
            jSONObject2.put("avgBlockCnt", (double) f2);
            jSONObject2.put("avgVideoQue", (double) f3);
            jSONObject2.put("avgAudioQue", (double) f4);
            optJSONArray.put(jSONObject2);
            int length = optJSONArray.length();
            if (((long) length) > this.f994c) {
                jSONArray = new JSONArray();
                for (int i2 = (int) (((long) length) - this.f994c); i2 < length; i2++) {
                    jSONArray.put(optJSONArray.get(i2));
                }
            } else {
                jSONArray = optJSONArray;
            }
            jSONObject.put(str2, jSONArray);
            c2.put(str, jSONObject);
            sharedPreferences.edit().putString("34238512-C08C-4931-A000-40E1D8B5BA5B", c2.toString()).commit();
            AppMethodBeat.o(15458);
        } catch (Exception e2) {
            TXCLog.e("UploadQualityData", "build json object failed.", e2);
            AppMethodBeat.o(15458);
        }
    }

    public boolean c() {
        AppMethodBeat.i(15459);
        d();
        String b2 = b();
        String str = "isDomainAddressBetter: accessID = " + b2 + " minQualityDataCount = " + this.f994c;
        a a2 = a(b2, true);
        a a3 = a(b2, false);
        if (a2 != null) {
            str = String.format("%s \n isDomainAddressBetter：domainQualityData count = %d avgNetworkRTT = %f avgBlockCount = %f avgVideoQueue = %f avgAudioQueue = %f", str, Long.valueOf(a2.f999e), Float.valueOf(a2.f995a), Float.valueOf(a2.f996b), Float.valueOf(a2.f997c), Float.valueOf(a2.f998d));
        }
        if (a3 != null) {
            str = String.format("%s \n isDomainAddressBetter：originQualityData count = %d avgNetworkRTT = %f avgBlockCount = %f avgVideoQueue = %f avgAudioQueue = %f", str, Long.valueOf(a3.f999e), Float.valueOf(a3.f995a), Float.valueOf(a3.f996b), Float.valueOf(a3.f997c), Float.valueOf(a3.f998d));
        }
        TXCLog.e("UploadQualityData", str);
        if (a2 == null || a2.f999e < this.f994c || a3 == null || a3.f999e < this.f994c) {
            AppMethodBeat.o(15459);
            return false;
        } else if (a2.f996b >= a3.f996b || a2.f997c >= a3.f997c || a2.f998d >= a3.f998d) {
            AppMethodBeat.o(15459);
            return false;
        } else {
            AppMethodBeat.o(15459);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public float f995a = 0.0f;

        /* renamed from: b  reason: collision with root package name */
        public float f996b = 0.0f;

        /* renamed from: c  reason: collision with root package name */
        public float f997c = 0.0f;

        /* renamed from: d  reason: collision with root package name */
        public float f998d = 0.0f;

        /* renamed from: e  reason: collision with root package name */
        public long f999e = 0;

        protected a() {
        }
    }

    private a a(String str, boolean z) {
        AppMethodBeat.i(15460);
        if (b(str)) {
            AppMethodBeat.o(15460);
            return null;
        }
        try {
            String string = this.f993b.getSharedPreferences("com.tencent.liteav.network", 0).getString("34238512-C08C-4931-A000-40E1D8B5BA5B", "");
            if (b(string)) {
                AppMethodBeat.o(15460);
                return null;
            }
            JSONObject optJSONObject = new JSONObject(string).optJSONObject(str);
            if (optJSONObject == null) {
                AppMethodBeat.o(15460);
                return null;
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray(z ? "DomainArrayData" : "OriginArrayData");
            if (optJSONArray == null) {
                AppMethodBeat.o(15460);
                return null;
            }
            long length = (long) optJSONArray.length();
            if (length == 0) {
                AppMethodBeat.o(15460);
                return null;
            }
            String str2 = "";
            float f2 = 0.0f;
            float f3 = 0.0f;
            float f4 = 0.0f;
            float f5 = 0.0f;
            for (int i2 = 0; ((long) i2) < length; i2++) {
                JSONObject jSONObject = optJSONArray.getJSONObject(i2);
                f2 += (float) jSONObject.optLong("networkRTT");
                f3 = (float) (((double) f3) + jSONObject.optDouble("avgBlockCnt"));
                f4 = (float) (((double) f4) + jSONObject.optDouble("avgVideoQue"));
                f5 = (float) (((double) f5) + jSONObject.optDouble("avgAudioQue"));
                str2 = String.format("%s \n isDomainAddressBetter：itemData domain = %b NetworkRTT = %d avgBlockCount = %f avgVideoQueue = %f avgAudioQueue = %f", str2, Boolean.valueOf(z), Long.valueOf(jSONObject.optLong("networkRTT")), Double.valueOf(jSONObject.optDouble("avgBlockCnt")), Double.valueOf(jSONObject.optDouble("avgVideoQue")), Double.valueOf(jSONObject.optDouble("avgAudioQue")));
            }
            a aVar = new a();
            aVar.f995a = f2 / ((float) length);
            aVar.f996b = f3 / ((float) length);
            aVar.f997c = f4 / ((float) length);
            aVar.f998d = f5 / ((float) length);
            aVar.f999e = length;
            AppMethodBeat.o(15460);
            return aVar;
        } catch (Exception e2) {
            TXCLog.e("UploadQualityData", "get quality data failed.", e2);
            AppMethodBeat.o(15460);
            return null;
        }
    }

    private boolean b(String str) {
        AppMethodBeat.i(15461);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(15461);
            return true;
        }
        AppMethodBeat.o(15461);
        return false;
    }

    private JSONObject c(String str) {
        AppMethodBeat.i(15462);
        if (!b(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                AppMethodBeat.o(15462);
                return jSONObject;
            } catch (Exception e2) {
                TXCLog.e("UploadQualityData", "failed to parse json string", e2);
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        AppMethodBeat.o(15462);
        return jSONObject2;
    }

    private void d() {
        AppMethodBeat.i(15463);
        this.f994c = c.a().a("Network", "QualityDataCacheCount");
        if (this.f994c == -1 || this.f994c < 3) {
            this.f994c = 3;
        }
        AppMethodBeat.o(15463);
    }

    public long a(String str) {
        AppMethodBeat.i(15464);
        if (this.f993b != null) {
            long j2 = this.f993b.getSharedPreferences("com.tencent.liteav.network", 0).getLong(str, 0);
            AppMethodBeat.o(15464);
            return j2;
        }
        AppMethodBeat.o(15464);
        return 0;
    }

    public void a(String str, long j2) {
        AppMethodBeat.i(15465);
        if (this.f993b != null) {
            this.f993b.getSharedPreferences("com.tencent.liteav.network", 0).edit().putLong(str, j2).commit();
        }
        AppMethodBeat.o(15465);
    }
}
