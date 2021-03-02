package com.tencent.mm.plugin.recordvideo.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.e.d;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.i;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.g;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.m;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010 \u001a\u00020\u000bH\u0002J\u0006\u0010!\u001a\u00020\u000bJ\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u00020#H\u0002J\u000e\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u000bJ\u0010\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u0019H\u0002J\u000e\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020#R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "backgrounndSilent", "", "exoPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "fakeImageView", "Landroid/widget/ImageView;", "fakeMusicInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "fakeVideoInfo", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "loopingFrame", "startTime", "", "stopTime", "storyFrameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/StoryFrameRetriever;", "useFakeImage", "videoHeight", "", "videoPlaying", "videoRotation", "videoWidth", "checkFakeVideoMatchScreenRatio", "isBackgroundSilent", "pauseFakeLayer", "", "playAudio", "playFakeLayer", "mute", "requestLoopFakeFrame", "frameRetriever", "setFakeVideoInfo", "videoEditData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "stopFakeLayer", "plugin-recordvideo_release"})
public final class FakeVideoViewLayer extends RelativeLayout {
    private v BTI;
    private aio BYr;
    private AudioCacheInfo BYs;
    public boolean BYt;
    private ImageView BYu;
    private g BYv;
    private boolean BYw;
    private boolean BYx;
    private int BYy;
    private final String TAG = "MicroMsg.FakeVideoViewLayer";
    private long hlh;
    private long startTime;
    private int videoHeight;
    private int videoWidth;

    public static final /* synthetic */ void a(FakeVideoViewLayer fakeVideoViewLayer, g gVar) {
        AppMethodBeat.i(237511);
        fakeVideoViewLayer.a(gVar);
        AppMethodBeat.o(237511);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FakeVideoViewLayer(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(75864);
        AppMethodBeat.o(75864);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FakeVideoViewLayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(75865);
        AppMethodBeat.o(75865);
    }

    public final void setFakeVideoInfo(c cVar) {
        boolean z;
        String str;
        boolean z2 = true;
        AppMethodBeat.i(75858);
        p.h(cVar, "videoEditData");
        aio aio = new aio();
        try {
            aio.parseFrom(cVar.field_baseItemData);
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
            aio = null;
        }
        aio aio2 = aio;
        if (aio2 == null) {
            AppMethodBeat.o(75858);
            return;
        }
        this.videoWidth = cVar.field_targetWidth;
        this.videoHeight = cVar.field_targetHeight;
        this.BYy = cVar.field_videoRotate;
        Log.i(this.TAG, "LogStory: setFakeVideoInfo " + aio2.timeStamp);
        this.BYr = aio2;
        if (this.BYu == null) {
            ImageView imageView = new ImageView(getContext());
            if (this.BYy == 90 || this.BYy == 270) {
                int i2 = this.videoHeight;
                this.videoHeight = this.videoWidth;
                this.videoWidth = i2;
            }
            if (this.videoWidth > this.videoHeight) {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else {
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            this.BYu = imageView;
        }
        removeAllViews();
        aio aio3 = this.BYr;
        if (aio3 == null || (str = aio3.videoPath) == null) {
            z = false;
        } else {
            d dVar = d.Cin;
            d.a aLQ = d.aLQ(str);
            z = aLQ != null ? aLQ.Cio : false;
        }
        this.BYx = !aio2.iqf && !z;
        Log.i(this.TAG, "useFakeImage:" + this.BYx + ", isCaptureVideo:" + aio2.iqf + ", matchScreenRatio:" + z);
        if (this.BYx) {
            addView(this.BYu, new RelativeLayout.LayoutParams(-1, -1));
            ImageView imageView2 = this.BYu;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
        } else {
            e eVar = e.BKp;
            Context context = getContext();
            p.g(context, "context");
            e.a(aio2, context, this);
            ImageView imageView3 = this.BYu;
            if (imageView3 != null) {
                imageView3.setVisibility(8);
            }
        }
        if (aio2.iiv != null) {
            AudioCacheInfo audioCacheInfo = new AudioCacheInfo();
            audioCacheInfo.BOX = aio2.BOX;
            audioCacheInfo.aXa = aio2.aXa;
            audioCacheInfo.cachePath = aio2.iiv;
            audioCacheInfo.musicUrl = aio2.musicUrl;
            this.BYs = audioCacheInfo;
        } else {
            this.BYs = null;
        }
        if (!(aio2.idq == 0 || aio2.idq == 2)) {
            z2 = false;
        }
        this.BYt = z2;
        this.startTime = aio2.startTime;
        this.hlh = aio2.endTime;
        this.BYw = false;
        AppMethodBeat.o(75858);
    }

    private final void a(g gVar) {
        Bitmap bitmap;
        AppMethodBeat.i(237510);
        if (!this.BYw) {
            Log.i(this.TAG, "requestLoopFakeFrame stop");
            AppMethodBeat.o(237510);
        } else if (!p.j(gVar, this.BYv)) {
            Log.i(this.TAG, "requestLoopFakeFrame frameRetriever not match");
            AppMethodBeat.o(237510);
        } else {
            aio aio = this.BYr;
            if ((aio == null || !aio.iqf) && this.BYx) {
                com.tencent.mm.plugin.recordvideo.ui.editor.b.a cJu = gVar.cJu();
                ImageView imageView = this.BYu;
                if (imageView != null) {
                    if (cJu != null) {
                        bitmap = cJu.bitmap;
                    } else {
                        bitmap = null;
                    }
                    imageView.setImageBitmap(bitmap);
                }
                ImageView imageView2 = this.BYu;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
                if (cJu != null) {
                    Long valueOf = Long.valueOf(cJu.CgA);
                    long longValue = valueOf.longValue();
                    Long l = (1 > longValue ? 1 : (1 == longValue ? 0 : -1)) <= 0 && (1000 > longValue ? 1 : (1000 == longValue ? 0 : -1)) >= 0 && this.BYw && p.j(gVar, this.BYv) ? valueOf : null;
                    if (l != null) {
                        long longValue2 = l.longValue();
                        ImageView imageView3 = this.BYu;
                        if (imageView3 != null) {
                            imageView3.postDelayed(new a(this, gVar), longValue2);
                            AppMethodBeat.o(237510);
                            return;
                        }
                        AppMethodBeat.o(237510);
                        return;
                    }
                }
                AppMethodBeat.o(237510);
                return;
            }
            Log.i(this.TAG, "requestLoopFakeFrame local capture video or not useFakeImage");
            AppMethodBeat.o(237510);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer$requestLoopFakeFrame$2$1"})
    public static final class a implements Runnable {
        final /* synthetic */ g BYA;
        final /* synthetic */ FakeVideoViewLayer BYz;

        a(FakeVideoViewLayer fakeVideoViewLayer, g gVar) {
            this.BYz = fakeVideoViewLayer;
            this.BYA = gVar;
        }

        public final void run() {
            AppMethodBeat.i(75857);
            FakeVideoViewLayer.a(this.BYz, this.BYA);
            AppMethodBeat.o(75857);
        }
    }

    public final void tv(boolean z) {
        aio aio;
        AppMethodBeat.i(75860);
        String str = this.TAG;
        StringBuilder sb = new StringBuilder("LogStory: playFakeLayer ");
        aio aio2 = this.BYr;
        Log.i(str, sb.append(aio2 != null ? Long.valueOf(aio2.timeStamp) : null).toString());
        v vVar = this.BTI;
        if (vVar != null) {
            vVar.stop();
        }
        v vVar2 = this.BTI;
        if (vVar2 != null) {
            vVar2.release();
        }
        if (this.BYs != null && !z) {
            playAudio();
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof MMAnimateView) {
                ((MMAnimateView) childAt).resume();
            } else if (childAt instanceof m) {
                ((m) childAt).resume();
            }
        }
        if (!this.BYx || (aio = this.BYr) == null) {
            AppMethodBeat.o(75860);
            return;
        }
        g gVar = this.BYv;
        if (gVar != null) {
            gVar.destroy();
        }
        ImageView imageView = this.BYu;
        if (imageView != null) {
            imageView.setImageBitmap(null);
        }
        e eVar = e.BKp;
        Context context = getContext();
        p.g(context, "context");
        this.BYv = e.a(aio, context, this.videoWidth, this.videoHeight, this.BYy);
        g gVar2 = this.BYv;
        if (gVar2 != null) {
            gVar2.start();
            this.BYw = true;
            a(gVar2);
            AppMethodBeat.o(75860);
            return;
        }
        AppMethodBeat.o(75860);
    }

    public final void eLA() {
        AppMethodBeat.i(75861);
        String str = this.TAG;
        StringBuilder sb = new StringBuilder("LogStory: pauseFakeLayer ");
        aio aio = this.BYr;
        Log.i(str, sb.append(aio != null ? Long.valueOf(aio.timeStamp) : null).toString());
        v vVar = this.BTI;
        if (vVar != null) {
            vVar.aO(false);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof MMAnimateView) {
                ((MMAnimateView) childAt).pause();
            } else if (childAt instanceof m) {
                ((m) childAt).CfV = false;
            }
        }
        this.BYw = false;
        ImageView imageView = this.BYu;
        if (imageView != null) {
            imageView.setImageBitmap(null);
        }
        ImageView imageView2 = this.BYu;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        g gVar = this.BYv;
        if (gVar != null) {
            gVar.destroy();
        }
        this.BYv = null;
        AppMethodBeat.o(75861);
    }

    public final void eLB() {
        AppMethodBeat.i(75862);
        String str = this.TAG;
        StringBuilder sb = new StringBuilder("LogStory: stopFakeLayer ");
        aio aio = this.BYr;
        Log.i(str, sb.append(aio != null ? Long.valueOf(aio.timeStamp) : null).toString());
        v vVar = this.BTI;
        if (vVar != null) {
            vVar.stop();
        }
        v vVar2 = this.BTI;
        if (vVar2 != null) {
            vVar2.release();
        }
        this.BTI = null;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof MMAnimateView) {
                ((MMAnimateView) childAt).stop();
            } else if (childAt instanceof m) {
                ((m) childAt).CfV = false;
            }
        }
        this.BYw = false;
        ImageView imageView = this.BYu;
        if (imageView != null) {
            imageView.setImageBitmap(null);
        }
        ImageView imageView2 = this.BYu;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        g gVar = this.BYv;
        if (gVar != null) {
            gVar.destroy();
        }
        this.BYv = null;
        AppMethodBeat.o(75862);
    }

    private final void playAudio() {
        AppMethodBeat.i(75863);
        com.google.android.exoplayer2.g.c cVar = new com.google.android.exoplayer2.g.c(new a.C0111a(new com.google.android.exoplayer2.h.l()));
        String h2 = x.h(getContext(), getContext().getString(R.string.wx));
        this.BTI = com.google.android.exoplayer2.g.a(getContext(), cVar);
        try {
            i.a aVar = i.BPL;
            AudioCacheInfo audioCacheInfo = this.BYs;
            if (audioCacheInfo == null) {
                p.hyc();
            }
            p.g(h2, "userAgent");
            com.google.android.exoplayer2.source.e eVar = new com.google.android.exoplayer2.source.e(i.a.a(audioCacheInfo, h2), this.startTime, this.hlh * 1000);
            v vVar = this.BTI;
            if (vVar != null) {
                vVar.aO(true);
            }
            v vVar2 = this.BTI;
            if (vVar2 != null) {
                vVar2.a(eVar);
            }
            v vVar3 = this.BTI;
            if (vVar3 != null) {
                vVar3.setRepeatMode(2);
                AppMethodBeat.o(75863);
                return;
            }
            AppMethodBeat.o(75863);
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "", new Object[0]);
            AppMethodBeat.o(75863);
        }
    }
}
