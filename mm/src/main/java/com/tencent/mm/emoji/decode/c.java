package com.tencent.mm.emoji.decode;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/emoji/decode/FramePicker;", "", "frameCount", "", "(I)V", "TAG", "", "allFrameValid", "", "getAllFrameValid", "()Z", "setAllFrameValid", "(Z)V", "getFrameCount", "()I", "<set-?>", "frameSum", "getFrameSum", "frameTimeList", "", "getFrameTimeList", "()[I", "findFrameIndex", "time", "setFrameTime", "", FirebaseAnalytics.b.INDEX, "plugin-emojisdk_release"})
public final class c {
    private final String TAG;
    private final int frameCount;
    private final int[] gUH;
    boolean gUI;
    private int gUJ;

    private /* synthetic */ c() {
        this(1);
    }

    public c(int i2) {
        AppMethodBeat.i(199862);
        this.frameCount = i2;
        this.TAG = "MicroMsg.FramePicker";
        this.gUH = new int[this.frameCount];
        AppMethodBeat.o(199862);
    }

    public final void cz(int i2, int i3) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(199861);
        int i4 = this.frameCount;
        if (i2 < 0 || i4 <= i2) {
            Log.i(this.TAG, "setFrameTime: invalid index ".concat(String.valueOf(i2)));
        }
        this.gUJ -= this.gUH[i2];
        this.gUH[i2] = i3;
        this.gUJ += this.gUH[i2];
        int[] iArr = this.gUH;
        int length = iArr.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                z2 = true;
                break;
            }
            if (iArr[i5] > 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                break;
            }
            i5++;
        }
        this.gUI = z2;
        AppMethodBeat.o(199861);
    }

    public final int pe(int i2) {
        int i3 = -1;
        if (this.frameCount > 0 && (this.gUI || i2 <= this.gUJ)) {
            if (this.gUI) {
                i2 %= this.gUJ;
            }
            int i4 = this.gUH[0];
            i3 = 0;
            while (i4 < i2) {
                i3++;
                i4 += this.gUH[i3];
            }
        }
        return i3;
    }
}
