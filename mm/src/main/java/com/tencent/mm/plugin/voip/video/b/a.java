package com.tencent.mm.plugin.voip.video.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ0\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u0003R\u0012\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyData;", "", "width", "", "height", "fbType", "mBuffer", "Ljava/nio/ByteBuffer;", "dataType", "(IIILjava/nio/ByteBuffer;I)V", "reset", "", "type", "Companion", "IFaceBeautyData", "plugin-voip_release"})
public final class a {
    public static final C1890a Hld = new C1890a((byte) 0);
    public int Hlc;
    public int dataType;
    public int height;
    public ByteBuffer iEK;
    public int width;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyData$IFaceBeautyData;", "", "getFaceBeautyData", "", "faceBeautyData", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyData;", "plugin-voip_release"})
    public interface b {
        void a(a aVar);
    }

    static {
        AppMethodBeat.i(115962);
        AppMethodBeat.o(115962);
    }

    public a(int i2, int i3, int i4, ByteBuffer byteBuffer) {
        this.width = i2;
        this.height = i3;
        this.Hlc = i4;
        this.iEK = byteBuffer;
        this.dataType = 0;
    }

    public /* synthetic */ a() {
        this(0, 0, -1, null);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyData$Companion;", "", "()V", "FB_NONE", "", "FB_ONLYSTFitler", "FB_SELF_STUDY", "FB_YT", "TYPE_DEFAULT", "TYPE_HW", "TYPE_SOFT", "plugin-voip_release"})
    /* renamed from: com.tencent.mm.plugin.voip.video.b.a$a  reason: collision with other inner class name */
    public static final class C1890a {
        private C1890a() {
        }

        public /* synthetic */ C1890a(byte b2) {
            this();
        }
    }

    public final void a(int i2, int i3, int i4, ByteBuffer byteBuffer, int i5) {
        this.width = i2;
        this.height = i3;
        this.iEK = byteBuffer;
        this.Hlc = i4;
        this.dataType = i5;
    }
}
