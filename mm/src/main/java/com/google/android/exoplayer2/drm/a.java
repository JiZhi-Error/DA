package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import com.google.android.exoplayer2.drm.c;

@TargetApi(16)
public interface a<T extends c> {

    /* renamed from: com.google.android.exoplayer2.drm.a$a  reason: collision with other inner class name */
    public static class C0105a extends Exception {
    }

    int getState();

    C0105a uq();

    T ur();
}
