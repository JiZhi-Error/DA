package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public class LogoImageView extends ImageView {
    MMHandler handler = new MMHandler() {
        /* class com.tencent.mm.plugin.nearlife.ui.LogoImageView.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            Bitmap bitmap;
            AppMethodBeat.i(26593);
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null || bArr.length == 0) {
                Log.e("MicroMsg.LogoImageView", "handleMsg fail, data is null");
                AppMethodBeat.o(26593);
                return;
            }
            Bitmap decodeByteArray = BitmapUtil.decodeByteArray(bArr);
            String str = LogoImageView.this.imagePath + g.getMessageDigest(LogoImageView.this.url.getBytes());
            Log.d("MicroMsg.LogoImageView", "filePath  %s", str);
            s.f(str, bArr, bArr.length);
            if (decodeByteArray == null || LogoImageView.this.targetWidth <= 0 || LogoImageView.this.targetHeight <= 0) {
                bitmap = decodeByteArray;
            } else {
                bitmap = BitmapUtil.extractThumbNail(decodeByteArray, LogoImageView.this.targetHeight, LogoImageView.this.targetWidth, true, false);
            }
            LogoImageView.this.setImageBitmap(bitmap);
            AppMethodBeat.o(26593);
        }
    };
    String imagePath;
    int targetHeight;
    int targetWidth;
    String url = null;

    public LogoImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(26595);
        AppMethodBeat.o(26595);
    }

    static class a implements Runnable {
        private MMHandler handler;
        private String url;

        a(String str, MMHandler mMHandler) {
            this.url = str;
            this.handler = mMHandler;
        }

        public final void run() {
            AppMethodBeat.i(26594);
            byte[] httpGet = Util.httpGet(this.url);
            Message obtain = Message.obtain();
            obtain.obj = httpGet;
            this.handler.sendMessage(obtain);
            AppMethodBeat.o(26594);
        }
    }
}
