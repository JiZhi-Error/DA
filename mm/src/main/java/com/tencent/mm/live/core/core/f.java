package com.tencent.mm.live.core.core;

import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.b.c;
import com.tencent.mm.live.core.core.e;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.TXLiveConstants;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u0004\u0018\u00010\u0007J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u001a\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/live/core/core/LiveWatchDog;", "", "()V", "TAG", "", "qosInfoQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/live/core/core/model/LiveQosInfo;", "cleanQosQueue", "", "dumpLastQosInfo", "dumpQosInfoQueue", "fillQosInfo", "qosInfo", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/os/Bundle;", "genQosInfo", "bundle", "markQosInfo", "plugin-core_release"})
public final class f {
    private static final String TAG = TAG;
    private static final LinkedList<c> hyr = new LinkedList<>();
    public static final f hys = new f();

    static {
        AppMethodBeat.i(196417);
        AppMethodBeat.o(196417);
    }

    private f() {
    }

    public final synchronized void w(Bundle bundle) {
        long j2;
        long j3;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        float f2;
        int i17;
        int i18;
        String str;
        long j4 = 0;
        synchronized (this) {
            AppMethodBeat.i(196413);
            Log.i(TAG, "markQosInfo qosInfoQueue.size:" + hyr.size() + ' ' + bundle);
            LinkedList<c> linkedList = hyr;
            c cVar = new c((byte) 0);
            if (bundle != null) {
                e.j jVar = e.j.hyq;
                j2 = bundle.getLong(e.j.aDc(), 0);
            } else {
                j2 = 0;
            }
            if (bundle != null) {
                e.j jVar2 = e.j.hyq;
                j3 = bundle.getLong(e.j.aCY(), 0);
            } else {
                j3 = 0;
            }
            cVar.hyH = j3;
            if (bundle != null) {
                e.j jVar3 = e.j.hyq;
                i2 = bundle.getInt(e.j.aCZ(), 0);
            } else {
                i2 = 0;
            }
            cVar.role = i2;
            if (bundle != null) {
                e.j jVar4 = e.j.hyq;
                i3 = bundle.getInt(e.j.aDa(), 0);
            } else {
                i3 = 0;
            }
            cVar.mode = i3;
            if (bundle != null) {
                e.j jVar5 = e.j.hyq;
                i4 = bundle.getInt(e.j.aDi(), 0);
            } else {
                i4 = 0;
            }
            cVar.netType = i4;
            if (bundle != null) {
                e.j jVar6 = e.j.hyq;
                j4 = bundle.getLong(e.j.aDb(), 0);
            }
            cVar.timestamps = j4;
            cVar.hyX = (int) (j2 / 1000);
            cVar.hyV = System.currentTimeMillis() - j2;
            String string = bundle != null ? bundle.getString(TXLiveConstants.NET_STATUS_CPU_USAGE) : null;
            if (string != null) {
                cVar.hze = (float) Util.safeParseInt((String) j.ks(n.b(string, new String[]{FilePathGenerator.ANDROID_DIR_SEP})));
            }
            if (bundle != null) {
                i5 = bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_WIDTH);
            } else {
                i5 = 0;
            }
            cVar.width = i5;
            if (bundle != null) {
                i6 = bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_HEIGHT);
            } else {
                i6 = 0;
            }
            cVar.height = i6;
            if (bundle != null) {
                i7 = bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_FPS);
            } else {
                i7 = 0;
            }
            cVar.hyI = i7;
            if (bundle != null) {
                i8 = bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_GOP);
            } else {
                i8 = 0;
            }
            cVar.hyJ = i8;
            if (bundle != null) {
                i9 = bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_BITRATE);
            } else {
                i9 = 0;
            }
            cVar.hyK = i9;
            if (bundle != null) {
                i10 = bundle.getInt(TXLiveConstants.NET_STATUS_AUDIO_BITRATE);
            } else {
                i10 = 0;
            }
            cVar.hyL = i10;
            if (bundle != null) {
                i11 = bundle.getInt(TXLiveConstants.NET_STATUS_NET_SPEED);
            } else {
                i11 = 0;
            }
            cVar.hyM = i11;
            if (bundle != null) {
                i12 = bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_CACHE);
            } else {
                i12 = 0;
            }
            cVar.hyN = i12;
            if (bundle != null) {
                i13 = bundle.getInt(TXLiveConstants.NET_STATUS_AUDIO_CACHE);
            } else {
                i13 = 0;
            }
            cVar.hyO = i13;
            if (bundle != null) {
                i14 = bundle.getInt(TXLiveConstants.NET_STATUS_V_SUM_CACHE_SIZE);
            } else {
                i14 = 0;
            }
            cVar.hyP = i14;
            if (bundle != null) {
                i15 = bundle.getInt(TXLiveConstants.NET_STATUS_AV_PLAY_INTERVAL);
            } else {
                i15 = 0;
            }
            cVar.hyQ = i15;
            if (bundle != null) {
                i16 = bundle.getInt(TXLiveConstants.NET_STATUS_AV_RECV_INTERVAL);
            } else {
                i16 = 0;
            }
            cVar.hyR = i16;
            if (bundle != null) {
                f2 = bundle.getFloat(TXLiveConstants.NET_STATUS_AUDIO_CACHE_THRESHOLD);
            } else {
                f2 = 0.0f;
            }
            cVar.hyS = (int) f2;
            if (bundle != null) {
                i17 = bundle.getInt(TXLiveConstants.NET_STATUS_NET_JITTER);
            } else {
                i17 = 0;
            }
            cVar.hyT = i17;
            if (bundle != null) {
                i18 = bundle.getInt(TXLiveConstants.NET_STATUS_QUALITY_LEVEL);
            } else {
                i18 = 0;
            }
            cVar.hyU = i18;
            if (bundle == null || (str = bundle.getString(TXLiveConstants.NET_STATUS_SERVER_IP)) == null) {
                str = "";
            }
            cVar.hzc = str;
            linkedList.add(cVar);
            AppMethodBeat.o(196413);
        }
    }

    public final synchronized LinkedList<c> aDk() {
        LinkedList<c> linkedList;
        AppMethodBeat.i(196414);
        linkedList = new LinkedList<>(hyr);
        AppMethodBeat.o(196414);
        return linkedList;
    }

    public final synchronized c aDl() {
        c cVar;
        AppMethodBeat.i(196415);
        cVar = (c) j.kv(hyr);
        AppMethodBeat.o(196415);
        return cVar;
    }

    public final synchronized void aDm() {
        AppMethodBeat.i(196416);
        hyr.clear();
        AppMethodBeat.o(196416);
    }
}
