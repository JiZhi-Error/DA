package com.tencent.mm.plugin.vlog.player;

import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.vlog.model.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\r\b&\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010;\u001a\u00020<2\u0006\u0010\b\u001a\u00020\tH&J\b\u0010=\u001a\u00020\tH&J\b\u0010>\u001a\u00020\tH&J\b\u0010?\u001a\u00020<H&J\u001a\u0010@\u001a\u00020<2\u0006\u0010A\u001a\u00020#2\b\b\u0002\u0010B\u001a\u00020\tH&J\b\u0010C\u001a\u00020<H&J\u0010\u0010D\u001a\u00020<2\u0006\u0010E\u001a\u00020#H&J\b\u0010F\u001a\u00020<H&J\b\u0010G\u001a\u00020<H&J\b\u0010H\u001a\u00020<H&R\u001a\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\u001f\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u0014R\u0011\u0010\"\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0012\"\u0004\b(\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\r\"\u0004\b,\u0010\u000fR\u001a\u0010-\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\r\"\u0004\b/\u0010\u000fR\u001a\u00100\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\r\"\u0004\b2\u0010\u000fR\u001a\u00103\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0012\"\u0004\b5\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0012\"\u0004\b7\u0010\u0014R\u001a\u00108\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0012\"\u0004\b:\u0010\u0014¨\u0006I"}, hxF = {"Lcom/tencent/mm/plugin/vlog/player/MaterialPlayer;", "", "texture", "", "drawWidth", "drawHeight", "material", "Lcom/tencent/mm/plugin/vlog/model/Material;", "mute", "", "(IIILcom/tencent/mm/plugin/vlog/model/Material;Z)V", "active", "getActive", "()Z", "setActive", "(Z)V", "cropBottom", "getCropBottom", "()I", "setCropBottom", "(I)V", "cropLeft", "getCropLeft", "setCropLeft", "cropRight", "getCropRight", "setCropRight", "cropTop", "getCropTop", "setCropTop", "getDrawHeight", "setDrawHeight", "getDrawWidth", "setDrawWidth", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "getDuration", "()J", "height", "getHeight", "setHeight", "getMaterial", "()Lcom/tencent/mm/plugin/vlog/model/Material;", "getMute", "setMute", "prepared", "getPrepared", "setPrepared", "ready", "getReady", "setReady", FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, "getRotate", "setRotate", "getTexture", "setTexture", "width", "getWidth", "setWidth", "enableMute", "", "isMirror", "isOES", "pause", "playing", "pts", "updateTex", "prepare", "readyAt", "seekTime", "release", "resume", "stop", "plugin-vlog_release"})
public abstract class b {
    boolean GBl;
    final s GBm;
    int Gxi;
    boolean active;
    boolean bcY;
    int cropBottom;
    int cropLeft;
    int cropRight;
    int cropTop;
    int dYT;
    int hEp;
    int hEq;
    int height;
    boolean isb;
    int width;

    public abstract void KV(long j2);

    public abstract void O(long j2, boolean z);

    public abstract void pause();

    public abstract void prepare();

    public abstract void release();

    public abstract void resume();

    public abstract void stop();

    public abstract void wC(boolean z);

    public /* synthetic */ b(int i2, int i3, int i4, s sVar) {
        this(i2, i3, i4, sVar, true);
    }

    public b(int i2, int i3, int i4, s sVar, boolean z) {
        p.h(sVar, "material");
        this.Gxi = i2;
        this.hEp = i3;
        this.hEq = i4;
        this.GBm = sVar;
        this.isb = z;
        this.cropLeft = -1;
        this.cropTop = -1;
        this.cropRight = -1;
        this.cropBottom = -1;
    }
}
