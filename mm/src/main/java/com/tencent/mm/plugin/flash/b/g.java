package com.tencent.mm.plugin.flash.b;

import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import java.util.HashMap;
import org.json.JSONObject;

public interface g {
    void c(TextView textView, String str);

    long cSK();

    void dLd();

    JSONObject dT(String str, int i2);

    void h(Intent intent, Activity activity);

    void onNetworkRequestEvent(String str, String str2, HashMap<String, String> hashMap, YtSDKKitFramework.IYtSDKKitNetResponseParser iYtSDKKitNetResponseParser);

    void r(TextView textView);

    void release();

    void reset();
}
