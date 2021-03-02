package com.tencent.thumbplayer.e.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoaderListener;
import com.tencent.thumbplayer.api.resourceloader.TPAssetResourceLoadingContentInformationRequest;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLFileSystem;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLIOUtil;
import com.tencent.thumbplayer.e.a.c;
import com.tencent.thumbplayer.utils.g;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public final class b implements a {
    private static String TAG = "TPAssetResourceLoader";
    private ITPAssetResourceLoaderListener RZT;
    private long RZU = 0;
    private String RZV = "";
    private String RZW = "";
    private String RZX = ".mp4";
    private int RZY = 0;
    private ArrayList<d> RZZ;
    private TPAssetResourceLoadingContentInformationRequest Saa;
    private HandlerThread Sab;
    private a Sac;
    private String mContentType = "";
    private Context mContext;
    private HandlerThread mHandlerThread;

    static /* synthetic */ long a(b bVar, long j2, long j3) {
        if (j3 > 0) {
            return j3 - j2;
        }
        long j4 = bVar.RZU;
        if (j4 <= 0) {
            return TPAudioFrame.TP_CH_STEREO_LEFT;
        }
        return j4 - j2;
    }

    static /* synthetic */ void a(b bVar, d dVar) {
        AppMethodBeat.i(189258);
        bVar.a(dVar);
        AppMethodBeat.o(189258);
    }

    static /* synthetic */ void e(b bVar) {
        AppMethodBeat.i(189259);
        bVar.hnC();
        AppMethodBeat.o(189259);
    }

    public b(Context context, Looper looper) {
        AppMethodBeat.i(189243);
        this.mContext = context;
        this.RZZ = new ArrayList<>();
        if (looper == null) {
            this.mHandlerThread = new HandlerThread("TPAssetResourceLoader-callbackThread");
            this.mHandlerThread.start();
            looper = this.mHandlerThread.getLooper();
        }
        this.Sac = new a(looper);
        this.Sab = new HandlerThread("TPAssetResourceLoader-dataWriteThread");
        this.Sab.start();
        AppMethodBeat.o(189243);
    }

    @Override // com.tencent.thumbplayer.e.a.a
    public final void a(ITPAssetResourceLoaderListener iTPAssetResourceLoaderListener) {
        this.RZT = iTPAssetResourceLoaderListener;
    }

    @Override // com.tencent.thumbplayer.e.a.a
    public final void hnB() {
        AppMethodBeat.i(189244);
        if (this.RZT == null) {
            g.e(TAG, "listener not set");
            AppMethodBeat.o(189244);
            return;
        }
        this.Saa = new TPAssetResourceLoadingContentInformationRequest();
        this.RZT.fillInContentInformation(this.Saa);
        this.mContentType = this.Saa.contentType;
        this.RZU = this.Saa.dataTotalSize;
        this.RZV = this.Saa.dataFilePath;
        g.i(TAG, "proxy start, mDataTotalSize: " + this.RZU + " businessPath:" + this.RZV);
        AppMethodBeat.o(189244);
    }

    @Override // com.tencent.thumbplayer.e.a.a
    public final int onStartReadData(int i2, String str, long j2, long j3) {
        AppMethodBeat.i(189245);
        if (this.RZT == null) {
            g.e(TAG, "listener not set");
            AppMethodBeat.o(189245);
            return 0;
        }
        g.i(TAG, "onStartReadData, fileId:" + i2 + ", fileKey:" + str + ", requestStart:" + j2 + ", requestEnd:" + j3);
        int i3 = this.RZY + 1;
        C2205b bVar = new C2205b((byte) 0);
        bVar.requestStart = j2;
        bVar.requestEnd = j3;
        bVar.fileKey = str;
        e(256, i2, i3, bVar);
        this.RZY = i3;
        int i4 = this.RZY;
        AppMethodBeat.o(189245);
        return i4;
    }

    @Override // com.tencent.thumbplayer.e.a.a
    public final int k(int i2, long j2, long j3) {
        AppMethodBeat.i(189246);
        int min = (int) Math.min((long) OF(j2), j3);
        if (min <= 0) {
            AppMethodBeat.o(189246);
            return -1;
        }
        g.d(TAG, "onReadData, fileId: " + i2 + " readOffset: " + j2 + " readLength:" + j3 + " readyLength:" + min);
        AppMethodBeat.o(189246);
        return min;
    }

    @Override // com.tencent.thumbplayer.e.a.a
    public final int onStopReadData(int i2, String str, int i3) {
        AppMethodBeat.i(189247);
        if (this.RZT == null) {
            g.e(TAG, "listener not set");
            AppMethodBeat.o(189247);
        } else {
            e(CdnLogic.kAppTypeFestivalImage, i3, 0, null);
            AppMethodBeat.o(189247);
        }
        return 0;
    }

    @Override // com.tencent.thumbplayer.e.a.a
    public final long getDataTotalSize(int i2, String str) {
        return this.RZU;
    }

    @Override // com.tencent.thumbplayer.e.a.a
    public final String getContentType(int i2, String str) {
        return this.mContentType;
    }

    @Override // com.tencent.thumbplayer.e.a.a
    public final void reset() {
        AppMethodBeat.i(189249);
        g.i(TAG, "reset start");
        hnC();
        this.RZU = 0;
        this.mContentType = "";
        this.RZV = "";
        if (!TextUtils.isEmpty(this.RZW)) {
            try {
                new File(this.RZW).deleteOnExit();
                this.RZW = "";
                AppMethodBeat.o(189249);
                return;
            } catch (Exception e2) {
                g.e(TAG, "reset, delete cache file has exception:" + e2.toString());
            }
        }
        AppMethodBeat.o(189249);
    }

    @Override // com.tencent.thumbplayer.e.a.a
    public final void release() {
        AppMethodBeat.i(189250);
        g.i(TAG, "release start");
        reset();
        if (this.mHandlerThread != null) {
            this.mHandlerThread.quit();
            this.mHandlerThread = null;
        }
        if (this.Sab != null) {
            this.Sab.quit();
            this.Sab = null;
        }
        this.RZZ = null;
        AppMethodBeat.o(189250);
    }

    private synchronized d arw(int i2) {
        d dVar;
        AppMethodBeat.i(189251);
        if (this.RZZ != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.RZZ.size()) {
                    AppMethodBeat.o(189251);
                    dVar = null;
                    break;
                }
                dVar = this.RZZ.get(i3);
                if (dVar.San.getRequestNum() == i2) {
                    AppMethodBeat.o(189251);
                    break;
                }
                i3++;
            }
        } else {
            AppMethodBeat.o(189251);
            dVar = null;
        }
        return dVar;
    }

    private synchronized int OF(long j2) {
        int i2 = 0;
        synchronized (this) {
            AppMethodBeat.i(189252);
            if (this.RZZ == null) {
                AppMethodBeat.o(189252);
            } else {
                int i3 = 0;
                for (int i4 = 0; i4 < this.RZZ.size(); i4++) {
                    i3 = Math.max(i3, this.RZZ.get(i4).San.OF(j2));
                }
                AppMethodBeat.o(189252);
                i2 = i3;
            }
        }
        return i2;
    }

    private synchronized void hnC() {
        AppMethodBeat.i(189253);
        if (this.RZZ != null) {
            Iterator<d> it = this.RZZ.iterator();
            while (it.hasNext()) {
                d next = it.next();
                next.hnD();
                this.RZT.didCancelLoadingRequest(next);
            }
            this.RZZ.clear();
        }
        AppMethodBeat.o(189253);
    }

    private synchronized void a(d dVar) {
        AppMethodBeat.i(189254);
        if (this.RZZ != null) {
            this.RZZ.add(dVar);
        }
        AppMethodBeat.o(189254);
    }

    private synchronized void b(d dVar) {
        AppMethodBeat.i(189255);
        if (this.RZZ != null) {
            this.RZZ.remove(dVar);
        }
        AppMethodBeat.o(189255);
    }

    private void e(int i2, int i3, int i4, Object obj) {
        AppMethodBeat.i(189256);
        if (this.Sac != null) {
            Message obtainMessage = this.Sac.obtainMessage();
            obtainMessage.what = i2;
            obtainMessage.arg1 = i3;
            obtainMessage.arg2 = i4;
            obtainMessage.obj = obj;
            this.Sac.sendMessage(obtainMessage);
        }
        AppMethodBeat.o(189256);
    }

    /* access modifiers changed from: package-private */
    public class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(189242);
            g.d(b.TAG, "mCallbackForResourceLoaderHandler msg : " + message.what);
            if (b.this.RZT == null) {
                AppMethodBeat.o(189242);
                return;
            }
            switch (message.what) {
                case 256:
                    g.i(b.TAG, "start read data");
                    C2205b bVar = (C2205b) message.obj;
                    long j2 = bVar.requestStart;
                    long j3 = bVar.requestEnd;
                    int i2 = message.arg1;
                    int i3 = message.arg2;
                    g.i(b.TAG, "start read data, requestStart: " + j2 + " requestEnd:" + j3 + " requestId:" + i3);
                    long a2 = b.a(b.this, j2, j3);
                    if (a2 <= 0) {
                        g.e(b.TAG, "requestLength invalid, check requestStart and requestEnd");
                        AppMethodBeat.o(189242);
                        return;
                    }
                    boolean z = false;
                    if (b.this.RZU > 0 && a2 + j2 >= b.this.RZU) {
                        z = true;
                    }
                    if (z) {
                        b.e(b.this);
                    }
                    d dVar = new d(j2, a2, i3, z);
                    Looper looper = b.this.Sab.getLooper();
                    c cVar = dVar.San;
                    cVar.Saj = new c.b(looper);
                    dVar.San.Sak = b.this.Mf(i2);
                    dVar.Saa = b.this.Saa;
                    if (b.this.RZT.shouldWaitForLoadingOfRequestedResource(dVar)) {
                        b.a(b.this, dVar);
                        g.i(b.TAG, "add to mLoadingRequests, requestId: ".concat(String.valueOf(i3)));
                    }
                    AppMethodBeat.o(189242);
                    return;
                case CdnLogic.kAppTypeFestivalImage:
                    g.i(b.TAG, "stop read data");
                    b.a(b.this, message.arg1);
                    break;
            }
            AppMethodBeat.o(189242);
        }
    }

    /* renamed from: com.tencent.thumbplayer.e.a.b$b  reason: collision with other inner class name */
    static class C2205b {
        String fileKey;
        long requestEnd;
        long requestStart;

        private C2205b() {
        }

        /* synthetic */ C2205b(byte b2) {
            this();
        }
    }

    @Override // com.tencent.thumbplayer.e.a.a
    public final String Mf(int i2) {
        AppMethodBeat.i(189248);
        String str = this.RZV;
        if (!TextUtils.isEmpty(str)) {
            AppMethodBeat.o(189248);
            return str;
        }
        Context context = this.mContext;
        if (TextUtils.isEmpty(this.RZW)) {
            File externalCacheFile = TPDLFileSystem.getExternalCacheFile(context, "resourceLoader", new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "-" + i2 + this.RZX);
            TPDLIOUtil.createFile(externalCacheFile);
            this.RZW = externalCacheFile.getAbsolutePath();
        }
        String str2 = this.RZW;
        AppMethodBeat.o(189248);
        return str2;
    }

    static /* synthetic */ void a(b bVar, int i2) {
        AppMethodBeat.i(189257);
        d arw = bVar.arw(i2);
        if (arw == null) {
            g.e(TAG, "TPAssetLoader can't find the request " + i2 + " with current loading requests");
            AppMethodBeat.o(189257);
            return;
        }
        arw.hnD();
        g.i(TAG, "handleStopReadData, cancel the loading request with id ".concat(String.valueOf(i2)));
        bVar.b(arw);
        bVar.RZT.didCancelLoadingRequest(arw);
        AppMethodBeat.o(189257);
    }
}
