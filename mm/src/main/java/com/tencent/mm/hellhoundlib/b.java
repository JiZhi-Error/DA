package com.tencent.mm.hellhoundlib;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

public final class b {
    public static boolean be(Object obj) {
        return (obj instanceof Activity) || (obj instanceof Context) || (obj instanceof Fragment) || (obj instanceof android.app.Fragment);
    }
}
