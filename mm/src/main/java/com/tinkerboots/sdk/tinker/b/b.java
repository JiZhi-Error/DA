package com.tinkerboots.sdk.tinker.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.lib.b.a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import com.tinkerboots.sdk.b.d;
import java.io.File;

public final class b extends a {
    public b(Context context) {
        super(context);
    }

    @Override // com.tencent.tinker.lib.b.a
    public final int ij(String str, String str2) {
        int i2 = 0;
        AppMethodBeat.i(3447);
        ShareTinkerLog.v("Tinker.TinkerServerPatchListener", "receive a patch file: %s, file size:%d", str, Long.valueOf(SharePatchFileUtil.getFileOrDirectorySize(new File(str))));
        int ij = super.ij(str, str2);
        if (ij != 0) {
            i2 = ij;
        } else if (d.hwc()) {
            i2 = -20;
        }
        AppMethodBeat.o(3447);
        return i2;
    }
}
