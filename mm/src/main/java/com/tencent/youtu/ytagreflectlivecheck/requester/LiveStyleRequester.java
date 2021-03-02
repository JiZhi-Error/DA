package com.tencent.youtu.ytagreflectlivecheck.requester;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;

public interface LiveStyleRequester {

    public static class LiveStyleAndroidData {
        public String android_apilevel = new StringBuilder().append(Build.VERSION.SDK_INT).toString();
        public String android_version = Build.VERSION.RELEASE;
        public String build_brand = Build.BRAND;
        public String build_device = Build.DEVICE;
        public String build_display = Build.DISPLAY;
        public String build_hardware = Build.HARDWARE;
        public String build_model = Build.MODEL;
        public String build_product = Build.PRODUCT;
        public float lux = 0.0f;

        public LiveStyleAndroidData() {
            AppMethodBeat.i(43401);
            AppMethodBeat.o(43401);
        }
    }

    public static class SeleceData {
        public LiveStyleAndroidData android_data = new LiveStyleAndroidData();
        public int change_point_num = 2;
        public int platform = 2;
        public int protocal = 1;
        public String reflect_param = " version 2 ";
        public String version = YTAGReflectLiveCheckInterface.VERSION;

        public SeleceData(float f2) {
            AppMethodBeat.i(43402);
            this.android_data.lux = f2;
            AppMethodBeat.o(43402);
        }
    }

    public static class YTLiveStyleReq {
        public String app_id;
        public SeleceData select_data;

        public YTLiveStyleReq(float f2, String str) {
            AppMethodBeat.i(43403);
            this.select_data = new SeleceData(f2);
            this.app_id = str;
            AppMethodBeat.o(43403);
        }
    }
}
