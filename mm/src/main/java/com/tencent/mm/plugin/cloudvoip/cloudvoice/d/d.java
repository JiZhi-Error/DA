package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.graphics.SurfaceTexture;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\r\u000eJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H&J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView;", "", "getSameLayerSurfaceHeight", "", "getSameLayerSurfaceWidth", "setLogicSurfaceSize", "", "surfaceWidth", "surfaceHeight", "setSameLayerSurfaceSize", "setSurfaceTexture", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "ISameLayerScaleOpenVoiceView", "SameLayerCallback", "cloudvoice_release"})
public interface d {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView$ISameLayerScaleOpenVoiceView;", "", "setSameLayerCallback", "", "callback", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView$SameLayerCallback;", "cloudvoice_release"})
    public interface a {
        void setSameLayerCallback(b bVar);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView$SameLayerCallback;", "", "onVideoSizeChanged", "", "width", "", "height", "cloudvoice_release"})
    public interface b {
        void eq(int i2, int i3);
    }

    void fq(int i2, int i3);

    void fr(int i2, int i3);

    void setSurfaceTexture(SurfaceTexture surfaceTexture);
}
