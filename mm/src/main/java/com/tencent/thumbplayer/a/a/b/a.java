package com.tencent.thumbplayer.a.a.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;
import com.tencent.thumbplayer.utils.g;
import com.tencent.thumbplayer.utils.j;
import java.util.Arrays;
import java.util.HashSet;

public final class a {
    private static int[] RXZ = new int[0];

    static /* synthetic */ void j(HashSet hashSet) {
        AppMethodBeat.i(188915);
        i(hashSet);
        AppMethodBeat.o(188915);
    }

    private static synchronized void i(HashSet<String> hashSet) {
        synchronized (a.class) {
            AppMethodBeat.i(188913);
            if (hashSet != null && hashSet.size() > 0) {
                Object[] array = hashSet.toArray();
                RXZ = new int[array.length];
                for (int i2 = 0; i2 < array.length; i2++) {
                    if (array[i2] instanceof String) {
                        RXZ[i2] = Integer.parseInt((String) array[i2]);
                    } else {
                        RXZ[i2] = -1;
                    }
                }
            }
            g.i("TPDrmCapability", "TPDrmCapability, read sp ret:" + Arrays.toString(RXZ));
            AppMethodBeat.o(188913);
        }
    }

    public static void init(Context context) {
        AppMethodBeat.i(188914);
        g.i("TPDrmCapability", "TPDrmCapability, init");
        if (!TPPlayerMgr.isThumbPlayerEnable()) {
            AppMethodBeat.o(188914);
            return;
        }
        g.i("TPDrmCapability", "TPDrmCapability, read sp.");
        final SharedPreferences sharedPreferences = context.getSharedPreferences("DRM_CAP", 0);
        i((HashSet) sharedPreferences.getStringSet("DRM_CAP_LIST", new HashSet()));
        j.getScheduledExecutorServiceInstance().execute(new Runnable() {
            /* class com.tencent.thumbplayer.a.a.b.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(188912);
                int[] dRMCapabilities = TPThumbplayerCapabilityHelper.getDRMCapabilities();
                g.i("TPDrmCapability", "TPThumbplayerCapabilityHelper, drm cap:" + Arrays.toString(dRMCapabilities));
                if (dRMCapabilities.length == 0) {
                    AppMethodBeat.o(188912);
                    return;
                }
                HashSet hashSet = new HashSet();
                for (int i2 : dRMCapabilities) {
                    if (i2 == 0) {
                        i2 = 0;
                    } else if (1 == i2) {
                        i2 = 1;
                    } else if (2 == i2) {
                        i2 = 2;
                    } else if (3 == i2) {
                        i2 = 3;
                    }
                    hashSet.add(String.valueOf(i2));
                }
                a.j(hashSet);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putStringSet("DRM_CAP_LIST", hashSet);
                edit.apply();
                AppMethodBeat.o(188912);
            }
        });
        AppMethodBeat.o(188914);
    }

    public static synchronized boolean aqY(int i2) {
        boolean z = false;
        synchronized (a.class) {
            int[] iArr = RXZ;
            int length = iArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                } else if (iArr[i3] == i2) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
        }
        return z;
    }

    public static synchronized int[] getDRMCapabilities() {
        int[] iArr;
        synchronized (a.class) {
            iArr = RXZ;
        }
        return iArr;
    }
}
