package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u000eJ\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016R\u000e\u0010\u0005\u001a\u00020\u0002X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, hxF = {"Lkotlinx/serialization/internal/IntArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([I)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class z extends av<int[]> {
    int[] bYo;
    int position;

    public z(int[] iArr) {
        p.h(iArr, "bufferWithData");
        AppMethodBeat.i(225560);
        this.bYo = iArr;
        this.position = iArr.length;
        ensureCapacity(10);
        AppMethodBeat.o(225560);
    }

    @Override // kotlinx.a.b.av
    public final int getPosition() {
        return this.position;
    }

    @Override // kotlinx.a.b.av
    public final void ensureCapacity(int i2) {
        AppMethodBeat.i(225558);
        if (this.bYo.length < i2) {
            int[] copyOf = Arrays.copyOf(this.bYo, j.mZ(i2, this.bYo.length * 2));
            p.g(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            this.bYo = copyOf;
        }
        AppMethodBeat.o(225558);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlinx.a.b.av
    public final /* synthetic */ int[] build() {
        AppMethodBeat.i(225559);
        int[] copyOf = Arrays.copyOf(this.bYo, this.position);
        p.g(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        AppMethodBeat.o(225559);
        return copyOf;
    }
}
