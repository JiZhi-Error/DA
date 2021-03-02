package com.tencent.mm.plugin.vlog.ui.thumb;

import java.util.LinkedList;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u0016H&J\b\u00101\u001a\u00020\u0004H&J\u0006\u00102\u001a\u00020.R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0018\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0018\"\u0004\b\u001f\u0010\u001cR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u000eR\u001a\u0010(\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001a\u0010*\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000e¨\u00063"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "", "()V", "dragging", "", "getDragging", "()Z", "setDragging", "(Z)V", "drawWidth", "", "getDrawWidth", "()I", "setDrawWidth", "(I)V", "frameCount", "", "getFrameCount", "()F", "setFrameCount", "(F)V", "frameDuration", "", "getFrameDuration", "()J", "frameEndMs", "getFrameEndMs", "setFrameEndMs", "(J)V", "frameStartMs", "getFrameStartMs", "setFrameStartMs", "frames", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameInfo;", "getFrames", "()Ljava/util/LinkedList;", "height", "getHeight", "setHeight", "isSelected", "setSelected", "width", "getWidth", "setWidth", "cropToPlayRange", "", "start", "end", "isEmpty", "updateFrameInfo", "plugin-vlog_release"})
public abstract class a {
    public long GOD;
    public long GOE;
    public float GOF = 1.0f;
    final LinkedList<e> GOG = new LinkedList<>();
    public boolean GOH;
    public int hEp;
    public int height;
    public int width;

    public final long fEu() {
        return this.GOE - this.GOD;
    }

    public final void fEv() {
        int i2;
        long fEu = (long) (((float) fEu()) / this.GOF);
        int ceil = (int) Math.ceil((double) this.GOF);
        this.GOG.clear();
        if (fEu >= 1000) {
            i2 = 500;
        } else {
            i2 = 200;
        }
        for (int i3 = 0; i3 < ceil; i3++) {
            e eVar = new e();
            eVar.Asv = kotlin.h.a.L((double) ((((float) (((((long) i3) * fEu) + this.GOD) + (fEu / 2))) * 1.0f) / ((float) i2))) * ((long) i2);
            if (eVar.Asv >= this.GOE) {
                eVar.Asv = ((this.GOE - 1) / ((long) i2)) * ((long) i2);
            }
            this.GOG.add(eVar);
        }
    }
}
