package i.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import java.io.InputStream;

public final class b {
    public int NcY;
    public int Upw;
    public InputStream Upx;

    public final int g(short[] sArr, int i2) {
        AppMethodBeat.i(155362);
        short s = sArr[i2];
        int i3 = (this.Upw >>> 11) * s;
        if ((this.NcY ^ Integer.MIN_VALUE) < (Integer.MIN_VALUE ^ i3)) {
            this.Upw = i3;
            sArr[i2] = (short) (s + ((2048 - s) >>> 5));
            if ((this.Upw & WebView.NIGHT_MODE_COLOR) == 0) {
                this.NcY = (this.NcY << 8) | this.Upx.read();
                this.Upw <<= 8;
            }
            AppMethodBeat.o(155362);
            return 0;
        }
        this.Upw -= i3;
        this.NcY -= i3;
        sArr[i2] = (short) (s - (s >>> 5));
        if ((this.Upw & WebView.NIGHT_MODE_COLOR) == 0) {
            this.NcY = (this.NcY << 8) | this.Upx.read();
            this.Upw <<= 8;
        }
        AppMethodBeat.o(155362);
        return 1;
    }

    public static void c(short[] sArr) {
        for (int i2 = 0; i2 < sArr.length; i2++) {
            sArr[i2] = 1024;
        }
    }
}
