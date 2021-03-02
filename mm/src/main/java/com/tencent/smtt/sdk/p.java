package com.tencent.smtt.sdk;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.TbsCoreSettings;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2101a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2102b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f2103c;

    public p() {
        AppMethodBeat.i(188241);
        this.f2101a = false;
        this.f2102b = false;
        this.f2103c = null;
        this.f2103c = new HashMap();
        AppMethodBeat.o(188241);
    }

    public synchronized void a(String str, byte b2) {
        AppMethodBeat.i(188242);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(188242);
        } else {
            String str2 = "";
            if (b2 == 1) {
                str2 = "_begin";
            } else if (b2 == 2) {
                str2 = "_end";
            }
            this.f2103c.put(str + str2, String.valueOf(System.currentTimeMillis()));
            AppMethodBeat.o(188242);
        }
    }

    public synchronized void a(String str, long j2) {
        AppMethodBeat.i(188243);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(188243);
        } else {
            this.f2103c.put(str, String.valueOf(j2));
            AppMethodBeat.o(188243);
        }
    }

    public JSONObject a() {
        AppMethodBeat.i(188244);
        JSONObject jSONObject = new JSONObject();
        if (this.f2103c != null) {
            try {
                for (Map.Entry<String, String> entry : this.f2103c.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(188244);
        return jSONObject;
    }

    public synchronized boolean a(int i2, String str) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(188245);
            if (!x.a().b()) {
                z = false;
                AppMethodBeat.o(188245);
            } else if ((!this.f2102b || !this.f2101a) && System.currentTimeMillis() % 10 != 0) {
                AppMethodBeat.o(188245);
            } else {
                this.f2102b = true;
                this.f2101a = true;
                this.f2103c.put("is_first_init_tbs", String.valueOf(this.f2102b));
                this.f2103c.put("is_first_init_x5", String.valueOf(this.f2101a));
                this.f2103c.put("x5_webview_id", Integer.toString(i2));
                this.f2103c.put("current_url", str);
                if (QbSdk.mSettings != null && QbSdk.mSettings.containsKey(TbsCoreSettings.TBS_SETTINGS_APP_SCENE_ID)) {
                    this.f2103c.put(TbsCoreSettings.TBS_SETTINGS_APP_SCENE_ID, new StringBuilder().append(QbSdk.mSettings.get(TbsCoreSettings.TBS_SETTINGS_APP_SCENE_ID)).toString());
                }
                TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy().setTbsInitPerformanceData(i2, this.f2103c);
                AppMethodBeat.o(188245);
            }
        }
        return z;
    }
}
