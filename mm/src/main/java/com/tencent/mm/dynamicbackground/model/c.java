package com.tencent.mm.dynamicbackground.model;

import android.content.Context;
import android.graphics.Point;
import kotlin.l;

@l(hxD = {1, 1, 11}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH&¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/dynamicbackground/model/DynamicBgService;", "Lcom/tencent/mm/dynamicbackground/model/DynamicBgCrashListener;", "getDisplayRealSize", "Landroid/graphics/Point;", "context", "Landroid/content/Context;", "getSleepTimeInMsPerFrame", "", "isEnableNativeDynamicBackground", "", "loadDynamicBgLibrary", "", "setEnableNativeDynamicBackground", "enable", "dynamicbg_release"})
public interface c extends b {
    boolean atB();

    void atC();

    void atD();

    float atM();

    Point az(Context context);
}
