package com.tencent.mm.plugin.voip.video.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ(\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u0003R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/videoprocessing/SpatioTemporalFilterData;", "", "width", "", "height", "SpatioTemporalFilterData", "Ljava/nio/ByteBuffer;", "dataType", "(IILjava/nio/ByteBuffer;I)V", "reset", "", "mBuffer", "type", "Companion", "ISpatioTemporalFilterData", "plugin-voip_release"})
public final class b {
    public static final a HpE = new a((byte) 0);
    public ByteBuffer HpD;
    public int dataType;
    public int height;
    public int width;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/videoprocessing/SpatioTemporalFilterData$ISpatioTemporalFilterData;", "", "getSpatioTemporalFilterData", "", "SpatioTemporalFilterData", "Lcom/tencent/mm/plugin/voip/video/videoprocessing/SpatioTemporalFilterData;", "plugin-voip_release"})
    /* renamed from: com.tencent.mm.plugin.voip.video.d.b$b  reason: collision with other inner class name */
    public interface AbstractC1893b {
        void a(b bVar);
    }

    static {
        AppMethodBeat.i(236376);
        AppMethodBeat.o(236376);
    }

    public /* synthetic */ b() {
        this(0, 0, null);
    }

    public b(int i2, int i3, ByteBuffer byteBuffer) {
        this.width = i2;
        this.height = i3;
        this.HpD = byteBuffer;
        this.dataType = 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/videoprocessing/SpatioTemporalFilterData$Companion;", "", "()V", "STFILTER_NOSCREENOUT", "", "STFILTER_NOUSE", "STFILTER_SCREENOUT", "STFILTER_USE", "TYPE_DEFAULT", "plugin-voip_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
