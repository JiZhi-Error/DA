package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import com.tencent.mm.plugin.facedetect.b.c;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.remoteservice.d;
import java.lang.ref.WeakReference;

public abstract class a {
    private d gVN = null;
    private Context mContext;
    private int sPn;
    protected com.tencent.mm.plugin.facedetect.b.d sPo = null;
    protected c sPp = null;
    protected WeakReference<f> sQl;
    protected boolean sQm = false;
    private int sQn = -1;
    private int sQo;
    protected com.tencent.mm.plugin.facedetect.b.a sQp = null;
    protected boolean sQq = false;

    a(Context context, f fVar, int i2, int i3) {
        this.mContext = context;
        this.sPn = i2;
        this.sQl = new WeakReference<>(fVar);
        this.sQo = 0;
        this.sQp = new com.tencent.mm.plugin.facedetect.b.a(i2, 0);
        this.sQn = FaceDetectReporter.HK(i2);
    }
}
