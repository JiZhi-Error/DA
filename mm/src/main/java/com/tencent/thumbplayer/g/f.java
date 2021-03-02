package com.tencent.thumbplayer.g;

import android.os.ParcelFileDescriptor;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import java.util.Map;

final class f {

    /* access modifiers changed from: package-private */
    public static class a {
        TPDownloadParamData Sbv;
        String name;
        String url;

        a() {
        }
    }

    /* access modifiers changed from: package-private */
    public static class l {
        TPCaptureParams SbN;
        TPCaptureCallBack SbO;

        l() {
        }
    }

    /* access modifiers changed from: package-private */
    public static class b {
        Map<String, String> Sbw;
        ParcelFileDescriptor Sbx;
        ITPMediaAsset Sby;
        String url;

        b() {
        }
    }

    /* access modifiers changed from: package-private */
    public static class c {
        boolean RVI;
        long SbA = -1;
        long Sbz = 0;

        c() {
        }
    }

    /* access modifiers changed from: package-private */
    public static class h {
        TPDownloadParamData SbH;
        String mimeType;
        String name;
        String url;

        h() {
        }
    }

    /* access modifiers changed from: package-private */
    public static class j {
        long SbK;
        TPVideoInfo SbL;
        ITPMediaAsset Sby;
        int mode;
        String url;

        j() {
        }
    }

    static class i {
        long SbI;
        Object SbJ;
        long edr;

        i() {
        }
    }

    /* access modifiers changed from: package-private */
    public static class d {
        Object SbB;
        Object SbC;
        Object SbD;
        Object SbE;
        int bca;

        d() {
        }
    }

    /* access modifiers changed from: package-private */
    public static class m {
        int height;
        int width;

        m() {
        }
    }

    /* access modifiers changed from: package-private */
    public static class k {
        TPTrackInfo[] SbM;

        k() {
        }
    }

    /* access modifiers changed from: package-private */
    public static class g {
        TPProgramInfo[] SbG;

        g() {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.thumbplayer.g.f$f  reason: collision with other inner class name */
    public static class C2210f {
        int SbF;
        String fileKey;
        long requestEnd;
        long requestStart;

        C2210f() {
        }
    }

    /* access modifiers changed from: package-private */
    public static class e {
        int SbF;
        long length;
        long offset;

        e() {
        }
    }
}
