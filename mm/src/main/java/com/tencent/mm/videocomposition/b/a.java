package com.tencent.mm.videocomposition.b;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.os.Process;
import android.util.ArrayMap;
import android.util.Size;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.videocomposition.c.b;
import com.tencent.mm.videocomposition.d;
import com.tencent.mm.videocomposition.j;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import com.tencent.tavkit.composition.video.ImageCollection;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@l(hxD = {1, 1, 15}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J&\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010&\u001a\u00020'H\u0016J\u0006\u0010\u000f\u001a\u00020\u0010J(\u0010(\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020!0 H&J\u0018\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR,\u0010\t\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006."}, hxF = {"Lcom/tencent/mm/videocomposition/render/BaseMultiVideoCompositionEffect;", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect$Filter;", "()V", "assetSize", "Landroid/util/Size;", "getAssetSize", "()Landroid/util/Size;", "setAssetSize", "(Landroid/util/Size;)V", "cacheTextureInfo", "Landroid/util/ArrayMap;", "Lkotlin/Pair;", "", "Ljava/util/LinkedList;", "Lcom/tencent/tav/coremedia/TextureInfo;", "renderContext", "Landroid/opengl/EGLContext;", "getRenderContext", "()Landroid/opengl/EGLContext;", "setRenderContext", "(Landroid/opengl/EGLContext;)V", "setThreadPriority", "", "apply", "Lcom/tencent/tavkit/ciimage/CIImage;", "effect", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect;", "imageCollection", "Lcom/tencent/tavkit/composition/video/ImageCollection;", "renderInfo", "Lcom/tencent/tavkit/composition/video/RenderInfo;", "createInputTrackList", "", "Lcom/tencent/mm/videocomposition/TrackRenderInfo;", "context", "Lcom/tencent/tavkit/ciimage/CIContext;", "pts", "", "release", "", "renderTracks", "trackList", "updateAssetSize", "width", "height", "Companion", "video_composition_release"})
public abstract class a implements TAVVideoMixEffect.Filter {
    public static final C2156a RhV = new C2156a((byte) 0);
    private ArrayMap<o<Integer, Integer>, LinkedList<TextureInfo>> RhR = new ArrayMap<>();
    private EGLContext RhS;
    Size RhT;
    private boolean RhU;

    public abstract TextureInfo a(CIContext cIContext, long j2, List<j> list);

    public a() {
        EGLContext eGLContext = EGL14.EGL_NO_CONTEXT;
        p.g(eGLContext, "EGL14.EGL_NO_CONTEXT");
        this.RhS = eGLContext;
        this.RhT = new Size(0, 0);
        b.i("BaseMultiVideoCompositionEffect", "init: ".concat(String.valueOf(this)), new Object[0]);
    }

    @l(hxD = {1, 1, 15}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/videocomposition/render/BaseMultiVideoCompositionEffect$Companion;", "", "()V", "TAG", "", "video_composition_release"})
    /* renamed from: com.tencent.mm.videocomposition.b.a$a  reason: collision with other inner class name */
    public static final class C2156a {
        private C2156a() {
        }

        public /* synthetic */ C2156a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter
    public CIImage apply(TAVVideoMixEffect tAVVideoMixEffect, ImageCollection imageCollection, RenderInfo renderInfo) {
        CIContext ciContext;
        TextureInfo newTextureInfo;
        if (renderInfo == null || (ciContext = renderInfo.getCiContext()) == null) {
            return null;
        }
        p.g(ciContext, "renderInfo?.ciContext ?: return null");
        if (!this.RhU) {
            b.i("BaseMultiVideoCompositionEffect", "set render thread priority ".concat(String.valueOf(this)), new Object[0]);
            Process.setThreadPriority(-4);
            this.RhU = true;
        }
        if (this.RhT.getWidth() == 0 || this.RhT.getHeight() == 0) {
            lY(renderInfo.getRenderWidth(), renderInfo.getRenderHeight());
            b.e("BaseMultiVideoCompositionEffect", "assetsSize error %s, update as renderSize", this.RhT);
        }
        EGLContext eglContext = ciContext.getRenderContext().eglContext();
        p.g(eglContext, "context.renderContext.eglContext()");
        this.RhS = eglContext;
        CMTime time = renderInfo.getTime();
        p.g(time, "renderInfo.time");
        long timeUs = time.getTimeUs() / 1000;
        if (imageCollection == null) {
            return null;
        }
        LinkedList<o> linkedList = new LinkedList();
        for (ImageCollection.TrackImagePair trackImagePair : imageCollection.getVideoChannelImages()) {
            p.g(trackImagePair, LocaleUtil.ITALIAN);
            TAVVideoCompositionTrack track = trackImagePair.getTrack();
            if (track == null) {
                throw new t("null cannot be cast to non-null type com.tencent.tavkit.composition.TAVClip");
            }
            TAVClip tAVClip = (TAVClip) track;
            if (!(tAVClip.getResource() instanceof TAVEmptyResource)) {
                CMTime startTime = tAVClip.getStartTime();
                p.g(startTime, "clip.startTime");
                long timeUs2 = startTime.getTimeUs() / 1000;
                CMTime duration = tAVClip.getDuration();
                p.g(duration, "clip.duration");
                long timeUs3 = (duration.getTimeUs() / 1000) + timeUs2 + 1;
                if (timeUs2 <= timeUs && timeUs3 > timeUs) {
                    Object extraTrackInfo = tAVClip.getExtraTrackInfo("key_extra_track");
                    if (!(extraTrackInfo instanceof d)) {
                        extraTrackInfo = null;
                    }
                    d dVar = (d) extraTrackInfo;
                    if (dVar != null) {
                        linkedList.add(new o(dVar, trackImagePair.getImage()));
                    }
                }
            }
        }
        LinkedList linkedList2 = new LinkedList();
        for (o oVar : linkedList) {
            B b2 = oVar.second;
            int i2 = (int) b2.getSize().width;
            int i3 = (int) b2.getSize().height;
            if (i2 > 0 && i3 > 0) {
                o oVar2 = new o(Integer.valueOf(i2), Integer.valueOf(i3));
                LinkedList<TextureInfo> linkedList3 = this.RhR.get(oVar2);
                LinkedList<TextureInfo> linkedList4 = linkedList3;
                if (!(linkedList4 == null || linkedList4.isEmpty())) {
                    newTextureInfo = linkedList3.removeFirst();
                } else {
                    newTextureInfo = CIContext.newTextureInfo(oVar2.first.intValue(), oVar2.second.intValue());
                }
                oVar.second.applyFlip(false, true);
                ciContext.convertImageToTexture(oVar.second, newTextureInfo);
                oVar.second.reset();
                p.g(newTextureInfo, "sourceTextureInfo");
                linkedList2.add(new j(oVar.first, newTextureInfo));
            }
        }
        LinkedList<j> linkedList5 = linkedList2;
        TextureInfo a2 = a(ciContext, timeUs, linkedList5);
        for (j jVar : linkedList5) {
            o<Integer, Integer> oVar3 = new o<>(Integer.valueOf(jVar.texture.width), Integer.valueOf(jVar.texture.height));
            ArrayMap<o<Integer, Integer>, LinkedList<TextureInfo>> arrayMap = this.RhR;
            LinkedList<TextureInfo> linkedList6 = arrayMap.get(oVar3);
            if (linkedList6 == null) {
                linkedList6 = new LinkedList<>();
                arrayMap.put(oVar3, linkedList6);
            }
            linkedList6.add(jVar.texture);
        }
        CIImage cIImage = new CIImage(a2);
        cIImage.applyFlip(false, true);
        cIImage.applyFillInFrame(new CGRect(0.0f, 0.0f, (float) renderInfo.getRenderWidth(), (float) renderInfo.getRenderHeight()), TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
        return cIImage;
    }

    public void lY(int i2, int i3) {
        b.i("BaseMultiVideoCompositionEffect", "updateRenderSize width:" + i2 + ", height:" + i3, new Object[0]);
        this.RhT = new Size(i2, i3);
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter
    public void release() {
        b.i("BaseMultiVideoCompositionEffect", "release: ".concat(String.valueOf(this)), new Object[0]);
        ArrayList<TextureInfo> arrayList = new ArrayList();
        for (Map.Entry<o<Integer, Integer>, LinkedList<TextureInfo>> entry : this.RhR.entrySet()) {
            kotlin.a.j.a((Collection) arrayList, (Iterable) entry.getValue());
        }
        for (TextureInfo textureInfo : arrayList) {
            textureInfo.release();
        }
        this.RhR.clear();
    }
}
