package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.a.a;
import com.tencent.rtmp.a.b;
import java.util.List;

public class TXImageSprite implements a {
    private Context mContext;
    private a mImageSprite;

    public TXImageSprite(Context context) {
        AppMethodBeat.i(13548);
        this.mContext = context.getApplicationContext();
        TXCDRApi.initCrashReport(context);
        AppMethodBeat.o(13548);
    }

    @Override // com.tencent.rtmp.a.a
    public void setVTTUrlAndImageUrls(String str, List<String> list) {
        AppMethodBeat.i(13549);
        if (this.mImageSprite != null) {
            release();
        }
        if (!(str == null || list == null || list.size() == 0)) {
            TXCDRApi.txReportDAU(this.mContext, com.tencent.liteav.basic.datareport.a.bC);
            this.mImageSprite = new b();
            this.mImageSprite.setVTTUrlAndImageUrls(str, list);
        }
        AppMethodBeat.o(13549);
    }

    @Override // com.tencent.rtmp.a.a
    public Bitmap getThumbnail(float f2) {
        AppMethodBeat.i(13550);
        if (this.mImageSprite != null) {
            Bitmap thumbnail = this.mImageSprite.getThumbnail(f2);
            AppMethodBeat.o(13550);
            return thumbnail;
        }
        AppMethodBeat.o(13550);
        return null;
    }

    @Override // com.tencent.rtmp.a.a
    public void release() {
        AppMethodBeat.i(13551);
        if (this.mImageSprite != null) {
            this.mImageSprite.release();
            this.mImageSprite = null;
        }
        AppMethodBeat.o(13551);
    }
}
