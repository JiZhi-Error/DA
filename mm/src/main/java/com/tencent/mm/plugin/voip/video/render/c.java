package com.tencent.mm.plugin.voip.video.render;

import android.content.Context;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H&J\b\u0010\u000e\u001a\u00020\u0005H&¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "", "getContext", "Landroid/content/Context;", "onLocalDataRendererAvailable", "", "ret", "", "width", "height", "onRendererDrawPerFrameCost", "time", "", "type", "onStartCameraError", "plugin-voip_release"})
public interface c {
    void aB(int i2, int i3, int i4);

    void ag(long j2, int i2);

    void fFE();

    Context getContext();
}
