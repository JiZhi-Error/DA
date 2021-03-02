package com.tencent.mm.plugin.appbrand.preload;

import com.tencent.mm.kernel.c.a;
import org.json.JSONObject;

public interface IAppBrandBatchPreloadController extends a {
    String preload(JSONObject jSONObject, boolean z);
}
