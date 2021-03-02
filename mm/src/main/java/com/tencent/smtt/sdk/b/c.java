package com.tencent.smtt.sdk.b;

import android.content.Context;
import android.os.Bundle;

public interface c {
    boolean canLoadVideo(Context context);

    boolean canLoadX5(Context context, boolean z, boolean z2);

    boolean canLoadX5FirstTimeThirdApp(Context context);

    boolean canUseVideoFeatrue(Context context, int i2);

    String[] getDexLoaderFileList(Context context, Context context2, String str);

    String getLibraryPath();

    String getTbsCoreVersionString();

    Bundle incrUpdate(Context context, Bundle bundle);

    boolean init(Context context);

    boolean isX5Disabled(Context context, int i2, int i3);

    boolean isX5DisabledSync(Context context);

    Object onMiscCallExtension(Context context, String str, Bundle bundle);

    boolean useSoftWare();
}
