package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.view.View;
import com.tencent.f.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.plugin.finder.view.FinderVideoFrameView;
import com.tencent.mm.plugin.finder.view.m;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vfs.s;
import java.io.FileDescriptor;
import java.io.RandomAccessFile;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016JG\u0010\u0017\u001a\u00020\f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u00192!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\f0\u001cH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderNormalVideoCoverPreview;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoCoverPreview;", "context", "Landroid/content/Context;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "frameView", "Lcom/tencent/mm/plugin/finder/view/FinderVideoFrameView;", "seeker", "Lcom/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker;", "destroy", "", "getBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "getView", "Landroid/view/View;", "seekTo", "timeMs", "", "start", "onReady", "Lkotlin/Function0;", "onDestroy", "onSeekFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameUs", "plugin-finder_release"})
public final class f implements p {
    private FinderVideoFrameView wcP;
    private m wcQ;

    public f(Context context, cjl cjl) {
        p.h(context, "context");
        p.h(cjl, "media");
        AppMethodBeat.i(254064);
        this.wcP = new FinderVideoFrameView(context);
        String str = cjl.url;
        this.wcQ = new m(str == null ? "" : str, this.wcP.getTextureView());
        AppMethodBeat.o(254064);
    }

    @Override // com.tencent.mm.plugin.finder.video.p
    public final void a(a<x> aVar, a<x> aVar2, b<? super Long, x> bVar) {
        AppMethodBeat.i(254060);
        p.h(aVar, "onReady");
        p.h(aVar2, "onDestroy");
        p.h(bVar, "onSeekFrame");
        m mVar = this.wcQ;
        p.h(aVar, "onTextureReady");
        p.h(aVar2, "onTextureDestroy");
        p.h(bVar, "onSeekFrame");
        HandlerThread hz = d.hz("FinderVideoFrameSeeker_renderThread" + mVar.hashCode(), -2);
        p.g(hz, "SpecialThreadFactory.cre…READ_PRIORITY_FOREGROUND)");
        mVar.wpM = hz;
        HandlerThread handlerThread = mVar.wpM;
        if (handlerThread == null) {
            p.btv("ht");
        }
        handlerThread.start();
        HandlerThread handlerThread2 = mVar.wpM;
        if (handlerThread2 == null) {
            p.btv("ht");
        }
        mVar.handler = new MMHandler(handlerThread2.getLooper());
        mVar.jto = new c();
        mVar.wpL = new c();
        RandomAccessFile dB = s.dB(mVar.path, false);
        p.g(dB, "VFSFileOp.openRandomAccess(path, false)");
        FileDescriptor fd = dB.getFD();
        if (ae.gKv.gKi == 1) {
            c cVar = mVar.jto;
            if (cVar == null) {
                p.btv("extractor");
            }
            cVar.setDataSource(fd, 0, s.boW(mVar.path));
            c cVar2 = mVar.wpL;
            if (cVar2 == null) {
                p.btv("frameFlagExtractor");
            }
            cVar2.setDataSource(fd, 0, s.boW(mVar.path));
        } else {
            c cVar3 = mVar.jto;
            if (cVar3 == null) {
                p.btv("extractor");
            }
            cVar3.setDataSource(fd);
            c cVar4 = mVar.wpL;
            if (cVar4 == null) {
                p.btv("frameFlagExtractor");
            }
            cVar4.setDataSource(fd);
        }
        dB.close();
        c cVar5 = mVar.jto;
        if (cVar5 == null) {
            p.btv("extractor");
        }
        int trackCount = cVar5.getTrackCount();
        int i2 = 0;
        while (true) {
            if (i2 >= trackCount) {
                break;
            }
            c cVar6 = mVar.jto;
            if (cVar6 == null) {
                p.btv("extractor");
            }
            MediaFormat trackFormat = cVar6.getTrackFormat(i2);
            p.g(trackFormat, "extractor.getTrackFormat(i)");
            mVar.mediaFormat = trackFormat;
            MediaFormat mediaFormat = mVar.mediaFormat;
            if (mediaFormat == null) {
                p.btv("mediaFormat");
            }
            String string = mediaFormat.getString("mime");
            p.g(string, "mediaFormat.getString(MediaFormat.KEY_MIME)");
            mVar.mime = string;
            String str = mVar.mime;
            if (str == null) {
                p.btv("mime");
            }
            if (n.J(str, "video/", false)) {
                c cVar7 = mVar.jto;
                if (cVar7 == null) {
                    p.btv("extractor");
                }
                cVar7.selectTrack(i2);
                c cVar8 = mVar.wpL;
                if (cVar8 == null) {
                    p.btv("frameFlagExtractor");
                }
                cVar8.selectTrack(i2);
            } else {
                i2++;
            }
        }
        mVar.bec.setSurfaceTextureListener(new m.a(mVar, aVar2, bVar, aVar));
        AppMethodBeat.o(254060);
    }

    @Override // com.tencent.mm.plugin.finder.video.p
    public final void seekTo(long j2) {
        AppMethodBeat.i(254061);
        m mVar = this.wcQ;
        synchronized (mVar.lock) {
            try {
                mVar.wpN = j2;
                c cVar = mVar.wpL;
                if (cVar == null) {
                    p.btv("frameFlagExtractor");
                }
                cVar.seekTo(mVar.wpN * 1000, 0);
                c cVar2 = mVar.wpL;
                if (cVar2 == null) {
                    p.btv("frameFlagExtractor");
                }
                long sampleTime = cVar2.getSampleTime();
                if (sampleTime != mVar.wpO || mVar.wpQ < 0 || mVar.wpQ >= j2 * 1000) {
                    mVar.wpO = sampleTime;
                    c cVar3 = mVar.jto;
                    if (cVar3 == null) {
                        p.btv("extractor");
                    }
                    cVar3.seekTo(mVar.wpN * 1000, 0);
                    if (mVar.hki) {
                        MediaCodec mediaCodec = mVar.decoder;
                        if (mediaCodec != null) {
                            mediaCodec.flush();
                        }
                        MediaCodec mediaCodec2 = mVar.decoder;
                        if (mediaCodec2 != null) {
                            mediaCodec2.start();
                        }
                    }
                    Log.i(mVar.TAG, "lxl change taget, start sync time:" + (mVar.wpO / 1000) + ", target time:" + j2 + ", flush:" + mVar.hki);
                } else {
                    Log.i(mVar.TAG, "lxl same taget~");
                }
                if (!mVar.hki) {
                    MediaCodec mediaCodec3 = mVar.decoder;
                    if (mediaCodec3 != null) {
                        mediaCodec3.start();
                    }
                    mVar.hki = true;
                }
                mVar.lock.notify();
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(254061);
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.video.p
    public final void destroy() {
        AppMethodBeat.i(254062);
        m mVar = this.wcQ;
        mVar.releaseDecoder();
        c cVar = mVar.jto;
        if (cVar == null) {
            p.btv("extractor");
        }
        cVar.release();
        c cVar2 = mVar.wpL;
        if (cVar2 == null) {
            p.btv("frameFlagExtractor");
        }
        cVar2.release();
        HandlerThread handlerThread = mVar.wpM;
        if (handlerThread == null) {
            p.btv("ht");
        }
        handlerThread.quit();
        AppMethodBeat.o(254062);
    }

    @Override // com.tencent.mm.plugin.finder.video.p
    public final View getView() {
        return this.wcP;
    }

    @Override // com.tencent.mm.plugin.finder.video.p
    public final Bitmap getBitmap() {
        AppMethodBeat.i(254063);
        Bitmap bitmap = this.wcP.getTextureView().getBitmap();
        AppMethodBeat.o(254063);
        return bitmap;
    }
}
