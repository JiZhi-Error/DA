package com.tencent.mm.plugin.taskbar;

import android.graphics.Bitmap;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.cru;
import java.util.List;

public interface d extends a {
    void addOrUpdateTaskInfoByBitmap(String str, int i2, cru cru, Bitmap bitmap, byte[] bArr);

    MultiTaskInfo getTaskInfoById(String str);

    List<MultiTaskInfo> getTaskInfoByType(int i2);

    void removeTaskInfo(String str, boolean z, int i2);

    void updateTaskInfoByBitmap(String str, int i2, cru cru, Bitmap bitmap, byte[] bArr, boolean z);
}
