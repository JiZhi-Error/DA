package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public class IPCallRoundUrlHeadImage extends CdnImageView {
    public IPCallRoundUrlHeadImage(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IPCallRoundUrlHeadImage(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.mm.pluginsdk.ui.applet.CdnImageView
    public void setImageBitmapCompleted(Bitmap bitmap) {
        AppMethodBeat.i(25902);
        if (bitmap != null) {
            setImageBitmap(BitmapUtil.getRoundedCornerBitmap(bitmap, false, 0.5f * ((float) bitmap.getWidth())));
        }
        AppMethodBeat.o(25902);
    }
}
