package com.tencent.mm.plugin.voip.video;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;

public final class f {
    private v2protocal GYA = new v2protocal(new MMHandler(Looper.myLooper()));
    public int HhG = 0;
    public boolean Hjo = false;
    private int Hjp;
    private int Hjq;
    private ArrayList<a> mCallbackList = new ArrayList<>();

    public interface a {
        void a(int[] iArr, boolean z, int i2);
    }

    public f() {
        AppMethodBeat.i(115701);
        AppMethodBeat.o(115701);
    }

    private static int[] cp(byte[] bArr) {
        AppMethodBeat.i(235836);
        int length = (bArr.length % 4 == 0 ? 0 : 1) + (bArr.length / 4);
        ByteBuffer allocate = ByteBuffer.allocate(length * 4);
        allocate.put(bArr);
        allocate.order(ByteOrder.nativeOrder());
        allocate.rewind();
        int[] iArr = new int[length];
        allocate.asIntBuffer().get(iArr);
        AppMethodBeat.o(235836);
        return iArr;
    }

    private static byte[] M(int[] iArr) {
        AppMethodBeat.i(235837);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.asIntBuffer().put(iArr);
        byte[] array = allocate.array();
        AppMethodBeat.o(235837);
        return array;
    }

    public final void xx(boolean z) {
        AppMethodBeat.i(235838);
        int[] iArr = new int[2];
        if (z) {
            iArr[0] = 1;
            iArr[1] = 0;
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
        }
        byte[] M = M(iArr);
        if (this.GYA.setAppCmd(13, M, M.length) >= 0) {
            int[] cp = cp(M);
            int i2 = cp[0];
            int i3 = cp[1];
            if (i2 + i3 != 0) {
                new b();
                b bVar = new b();
                bVar.Hjr = i2 & 65535;
                bVar.Hjs = (i2 >> 16) & 65535;
                bVar.Hjt = i3 & 65535;
                bVar.Hju = (i3 >> 16) & 65535;
                Log.d("MicroMsg.VoipFaceDetector", "detect face, location:%s", bVar);
                Iterator<a> it = this.mCallbackList.iterator();
                while (it.hasNext()) {
                    it.next().a(new int[]{bVar.Hjr, bVar.Hjs, bVar.Hjt, bVar.Hju}, this.Hjo, this.HhG);
                }
                AppMethodBeat.o(235838);
                return;
            }
            Iterator<a> it2 = this.mCallbackList.iterator();
            while (it2.hasNext()) {
                it2.next().a(null, this.Hjo, this.HhG);
            }
        }
        AppMethodBeat.o(235838);
    }

    public final void setPreviewSize(int i2, int i3) {
        this.Hjq = i3;
        this.Hjp = i2;
    }

    public final void a(a aVar) {
        AppMethodBeat.i(235839);
        if (!this.mCallbackList.contains(aVar)) {
            this.mCallbackList.add(aVar);
        }
        AppMethodBeat.o(235839);
    }

    public final void b(a aVar) {
        AppMethodBeat.i(115702);
        if (this.mCallbackList.contains(aVar)) {
            this.mCallbackList.remove(aVar);
        }
        AppMethodBeat.o(115702);
    }

    class b {
        int Hjr;
        int Hjs;
        int Hjt;
        int Hju;

        public b() {
        }

        public final String toString() {
            AppMethodBeat.i(115700);
            String format = String.format("topLeftX:%d, topLeftY:%d, rightBottomX:%d, rightBottomY:%d", Integer.valueOf(this.Hjr), Integer.valueOf(this.Hjs), Integer.valueOf(this.Hjt), Integer.valueOf(this.Hju));
            AppMethodBeat.o(115700);
            return format;
        }
    }
}
