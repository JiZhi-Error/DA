package com.tencent.kinda.framework.widget.base;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.kinda.gen.KBarCodeView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.a.a;
import com.tencent.mm.sdk.platformtools.Log;

public class KindaBarCodeViewImpl extends BaseKindaCodeView implements KBarCodeView {
    /* access modifiers changed from: protected */
    @Override // com.tencent.kinda.framework.widget.base.BaseKindaCodeView
    public Bitmap getNewBitmap(String str) {
        AppMethodBeat.i(18855);
        if (TextUtils.isEmpty(str)) {
            Log.e(MMKView.TAG, "getBarcodeBitmap mBarcode == null");
            AppMethodBeat.o(18855);
            return null;
        }
        Bitmap b2 = a.b(this.mContext, str, 5, 0);
        AppMethodBeat.o(18855);
        return b2;
    }
}
