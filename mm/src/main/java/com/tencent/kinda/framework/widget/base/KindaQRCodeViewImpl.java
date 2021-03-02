package com.tencent.kinda.framework.widget.base;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.kinda.gen.KQRCodeView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.a.a;
import com.tencent.mm.sdk.platformtools.Log;

public class KindaQRCodeViewImpl extends BaseKindaCodeView implements KQRCodeView {
    /* access modifiers changed from: protected */
    @Override // com.tencent.kinda.framework.widget.base.BaseKindaCodeView
    public Bitmap getNewBitmap(String str) {
        AppMethodBeat.i(18937);
        if (TextUtils.isEmpty(str)) {
            Log.e(MMKView.TAG, "kinda getBitmap mQRcode == null");
            AppMethodBeat.o(18937);
            return null;
        }
        Bitmap a2 = a.a(this.mContext, str, 12, 3, 0.0d);
        AppMethodBeat.o(18937);
        return a2;
    }
}
