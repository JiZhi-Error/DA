package com.tencent.mm.plugin.multitask;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.protocal.protobuf.cru;

public interface d extends com.tencent.mm.kernel.b.a {
    public static final a zZe = a.zZf;

    void addTaskInfo(String str, int i2, cru cru, byte[] bArr, crt crt);

    void addTaskInfoByBitmap(String str, int i2, cru cru, Bitmap bitmap, byte[] bArr, crt crt);

    Point getMultiTaskFloatBallPosition();

    void getMultiTaskInfoList(com.tencent.mm.plugin.multitask.c.a aVar);

    String getMultiTaskItemPosition(String str, int i2, int i3);

    MultiTaskInfo getTaskInfoById(String str);

    boolean hasTaskInfo(MultiTaskInfo multiTaskInfo);

    boolean isDataEmpty();

    boolean isMultiTaskMode();

    void registerMultiTaskUIC(int i2, Class<? extends MultiTaskUIComponent> cls);

    void removeTaskInfoAndCoverImg(String str);

    void reportMultiTaskInfo(int i2, crt crt);

    void sendMultiTaskEvent(int i2, String str, int i3);

    void updateTaskInfoByBitmap(String str, int i2, cru cru, Bitmap bitmap, byte[] bArr);

    void updateTaskInfoByTitle(String str, int i2, cru cru, byte[] bArr);

    public static final class b {
        public static /* synthetic */ void a(d dVar, int i2) {
            AppMethodBeat.i(200283);
            dVar.sendMultiTaskEvent(i2, "", 0);
            AppMethodBeat.o(200283);
        }
    }

    public static final class a {
        static final /* synthetic */ a zZf = new a();

        static {
            AppMethodBeat.i(200282);
            AppMethodBeat.o(200282);
        }

        private a() {
        }
    }
}
