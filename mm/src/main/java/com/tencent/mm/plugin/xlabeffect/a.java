package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.e;
import com.tencent.rtmp.TXLiveConstants;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0003J\u0006\u0010\u0007\u001a\u00020\u0003J\b\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/xlabeffect/FaceTrackProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "textureWidth", "", "textureHeight", "(II)V", "getHeight", "getWidth", "refreshDrawSize", "", "setRotate", "degree", "updateTextureSize", "width", "height", "Companion", "plugin-xlabeffect_release"})
public final class a extends e {
    public static final C2013a JQX = new C2013a((byte) 0);

    static {
        AppMethodBeat.i(90504);
        AppMethodBeat.o(90504);
    }

    private a() {
        super(0, 0, 0, 0, 2, 1);
    }

    public /* synthetic */ a(byte b2) {
        this();
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/xlabeffect/FaceTrackProc$Companion;", "", "()V", "FACE_TRACK_SIZE", "", "plugin-xlabeffect_release"})
    /* renamed from: com.tencent.mm.plugin.xlabeffect.a$a  reason: collision with other inner class name */
    public static final class C2013a {
        private C2013a() {
        }

        public /* synthetic */ C2013a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void cZ(int i2, int i3) {
        AppMethodBeat.i(90501);
        boolean z = (i2 == this.hDn && i3 == this.hDo) ? false : true;
        super.cZ(i2, i3);
        if (z) {
            glf();
        }
        AppMethodBeat.o(90501);
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void qx(int i2) {
        AppMethodBeat.i(90502);
        boolean z = i2 != this.ijt;
        super.qx(i2);
        if (z) {
            glf();
        }
        AppMethodBeat.o(90502);
    }

    private final void glf() {
        int i2;
        int i3;
        int i4 = 320;
        AppMethodBeat.i(90503);
        if (this.hDo > this.hDn) {
            if (this.hDo <= 320) {
                i4 = this.hDo;
            }
            i3 = (this.hDn * i4) / this.hDo;
            i2 = i4;
        } else {
            if (this.hDn <= 320) {
                i4 = this.hDn;
            }
            i2 = (this.hDo * i4) / this.hDn;
            i3 = i4;
        }
        if (this.ijt % TXLiveConstants.RENDER_ROTATION_180 != 0) {
            cY(i2, i3);
            AppMethodBeat.o(90503);
            return;
        }
        cY(i3, i2);
        AppMethodBeat.o(90503);
    }

    public final int getWidth() {
        return this.hEp;
    }

    public final int getHeight() {
        return this.hEq;
    }
}
