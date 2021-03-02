package com.tencent.mm.plugin.location.ui;

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

public class SimpleImageView extends ImageView {
    public MMHandler handler = new MMHandler() {
        /* class com.tencent.mm.plugin.location.ui.SimpleImageView.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            Bitmap bitmap;
            AppMethodBeat.i(55928);
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null || bArr.length == 0) {
                Log.e("MicroMsg.SimpleImageView", "handleMsg fail, data is null");
                AppMethodBeat.o(55928);
                return;
            }
            Bitmap decodeByteArray = BitmapUtil.decodeByteArray(bArr);
            String str = SimpleImageView.this.imagePath + g.getMessageDigest(SimpleImageView.this.url.getBytes());
            Log.d("MicroMsg.SimpleImageView", "filePath  %s", str);
            s.f(str, bArr, bArr.length);
            if (decodeByteArray == null || SimpleImageView.this.targetWidth <= 0 || SimpleImageView.this.targetHeight <= 0) {
                bitmap = decodeByteArray;
            } else {
                bitmap = BitmapUtil.extractThumbNail(decodeByteArray, SimpleImageView.this.targetHeight, SimpleImageView.this.targetWidth, true, false);
            }
            SimpleImageView.this.setImageBitmap(bitmap);
            AppMethodBeat.o(55928);
        }
    };
    public String imagePath;
    public int targetHeight;
    public int targetWidth;
    public String url = null;

    public SimpleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(55930);
        AppMethodBeat.o(55930);
    }

    public static class a implements Runnable {
        private MMHandler handler;
        private String url;

        public a(String str, MMHandler mMHandler) {
            this.url = str;
            this.handler = mMHandler;
        }

        public final void run() {
            AppMethodBeat.i(55929);
            byte[] httpGet = Util.httpGet(this.url);
            Message obtain = Message.obtain();
            obtain.obj = httpGet;
            this.handler.sendMessage(obtain);
            AppMethodBeat.o(55929);
        }
    }
}
