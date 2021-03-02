package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import com.tencent.f.h;
import com.tencent.f.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.vfs.s;

public class CdnImageView extends MMImageView implements com.tencent.mm.ui.g.a {
    private String KeO;
    private String KeP;
    private boolean KeQ;
    private boolean KeR;
    private d KeS;
    private MMHandler handler;
    private float iaU;
    private int targetHeight;
    private int targetWidth;
    private String url;

    public CdnImageView(Context context) {
        this(context, null);
    }

    public CdnImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CdnImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(152166);
        this.url = null;
        this.KeR = false;
        this.handler = new MMHandler() {
            /* class com.tencent.mm.pluginsdk.ui.applet.CdnImageView.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(152164);
                String nullAs = Util.nullAs(message.getData().getString("k_url"), "");
                CdnImageView.this.url = Util.nullAs(CdnImageView.this.url, "");
                if (Util.isNullOrNil(CdnImageView.this.url) && Util.isNullOrNil(nullAs)) {
                    CdnImageView.this.setImageBitmap(null);
                    CdnImageView.this.setImageBitmapCompleted(null);
                    AppMethodBeat.o(152164);
                } else if (!CdnImageView.this.url.equals(nullAs)) {
                    Log.d("MicroMsg.CdnImageView", "hy: url not equal. abort this msg");
                    AppMethodBeat.o(152164);
                } else {
                    byte[] byteArray = message.getData().getByteArray("k_data");
                    if (byteArray == null || byteArray.length == 0) {
                        Log.e("MicroMsg.CdnImageView", "handleMsg fail, data is null");
                        AppMethodBeat.o(152164);
                        return;
                    }
                    Bitmap decodeByteArray = BitmapUtil.decodeByteArray(byteArray);
                    q.bcQ();
                    com.tencent.mm.av.d.g(CdnImageView.this.url, decodeByteArray);
                    if (CdnImageView.this.KeR) {
                        CdnImageView.a(CdnImageView.this, decodeByteArray);
                    }
                    if (decodeByteArray != null && CdnImageView.this.targetWidth > 0 && CdnImageView.this.targetHeight > 0) {
                        decodeByteArray = BitmapUtil.extractThumbNail(decodeByteArray, CdnImageView.this.targetHeight, CdnImageView.this.targetWidth, true, false);
                    }
                    if (CdnImageView.this.KeQ && decodeByteArray != null) {
                        if (CdnImageView.this.iaU > 0.0f) {
                            decodeByteArray = BitmapUtil.getRoundedCornerBitmap(decodeByteArray, false, ((float) decodeByteArray.getWidth()) * CdnImageView.this.iaU);
                        } else {
                            decodeByteArray = BitmapUtil.getRoundedCornerBitmap(decodeByteArray, false, ((float) decodeByteArray.getWidth()) * 0.5f);
                        }
                    }
                    if (decodeByteArray != null) {
                        CdnImageView.this.setImageBitmap(decodeByteArray);
                    }
                    CdnImageView.this.setImageBitmapCompleted(decodeByteArray);
                    AppMethodBeat.o(152164);
                }
            }
        };
        AppMethodBeat.o(152166);
    }

    public void setImageBitmapCompleted(Bitmap bitmap) {
    }

    public void setUseSdcardCache(boolean z) {
        this.KeR = z;
    }

    public void setImgSavedPath(String str) {
        this.KeO = str;
    }

    public void setImgSavedDir(String str) {
        this.KeP = str;
    }

    public void setUrl(String str) {
        AppMethodBeat.i(152167);
        s(str, 0, 0, -1);
        AppMethodBeat.o(152167);
    }

    public final void gI(String str, int i2) {
        AppMethodBeat.i(152168);
        s(str, 0, 0, i2);
        AppMethodBeat.o(152168);
    }

    @Override // com.tencent.mm.ui.g.a
    public final void aM(String str, int i2, int i3) {
        AppMethodBeat.i(152169);
        s(str, i2, i3, -1);
        AppMethodBeat.o(152169);
    }

    public final void mB(String str, String str2) {
        AppMethodBeat.i(152170);
        b(str, -1, 0, 0, str2);
        AppMethodBeat.o(152170);
    }

    public final void s(String str, int i2, int i3, int i4) {
        AppMethodBeat.i(152171);
        b(str, i2, i3, i4, null);
        AppMethodBeat.o(152171);
    }

    private void b(String str, int i2, int i3, int i4, String str2) {
        Bitmap bitmapNative;
        AppMethodBeat.i(152172);
        this.url = str;
        this.targetWidth = i2;
        this.targetHeight = i3;
        if (!Util.isNullOrNil(str2)) {
            this.KeO = str2;
        }
        if (!Util.isNullOrNil(this.KeO) && (bitmapNative = BitmapUtil.getBitmapNative(this.KeO)) != null && bitmapNative.getWidth() > 0 && bitmapNative.getHeight() > 0) {
            setImageBitmap(bitmapNative);
            setImageBitmapCompleted(bitmapNative);
            AppMethodBeat.o(152172);
        } else if (str == null || str.length() == 0) {
            setVisibility(8);
            AppMethodBeat.o(152172);
        } else if (str.startsWith("http")) {
            gJ(str, i4);
            AppMethodBeat.o(152172);
        } else {
            beM(str);
            AppMethodBeat.o(152172);
        }
    }

    private String getCacheFilePath() {
        String str;
        AppMethodBeat.i(152173);
        if (!Util.isNullOrNil(this.KeO)) {
            str = this.KeO;
        } else if (!Util.isNullOrNil(this.KeP)) {
            str = this.KeP + g.getMessageDigest(this.url.getBytes());
        } else {
            s.boN(getAccImagesPath());
            str = getAccImagesPath() + g.getMessageDigest(this.url.getBytes());
        }
        AppMethodBeat.o(152173);
        return str;
    }

    public void setRoundCorner(boolean z) {
        this.KeQ = z;
    }

    public void setRoundCornerRate(float f2) {
        this.iaU = f2;
    }

    private void beM(String str) {
        Bitmap bitmap;
        AppMethodBeat.i(152174);
        if (!s.YS(str)) {
            setVisibility(8);
            AppMethodBeat.o(152174);
            return;
        }
        if (this.targetWidth <= 0 || this.targetHeight <= 0) {
            bitmap = BitmapUtil.getBitmapNative(str);
        } else {
            bitmap = BitmapUtil.extractThumbNail(str, this.targetWidth, this.targetHeight, true);
        }
        if (bitmap == null) {
            setVisibility(8);
            AppMethodBeat.o(152174);
            return;
        }
        if (this.KeQ && bitmap != null) {
            if (this.iaU > 0.0f) {
                bitmap = BitmapUtil.getRoundedCornerBitmap(bitmap, false, ((float) bitmap.getWidth()) * this.iaU);
            } else {
                bitmap = BitmapUtil.getRoundedCornerBitmap(bitmap, false, ((float) bitmap.getWidth()) * 0.5f);
            }
        }
        setImageBitmap(bitmap);
        setImageBitmapCompleted(bitmap);
        AppMethodBeat.o(152174);
    }

    private boolean gpu() {
        AppMethodBeat.i(152175);
        try {
            String cacheFilePath = getCacheFilePath();
            Log.d("MicroMsg.CdnImageView", "useSdcardCache, path: %s", cacheFilePath);
            if (s.YS(cacheFilePath)) {
                Bitmap bitmapNative = BitmapUtil.getBitmapNative(cacheFilePath);
                Log.d("MicroMsg.CdnImageView", "get bitmap from cache path: %s", bitmapNative);
                if (bitmapNative != null) {
                    if (this.targetWidth > 0 && this.targetHeight > 0) {
                        bitmapNative = BitmapUtil.extractThumbNail(bitmapNative, this.targetHeight, this.targetWidth, true, false);
                    }
                    if (this.KeQ && bitmapNative != null) {
                        if (this.iaU > 0.0f) {
                            bitmapNative = BitmapUtil.getRoundedCornerBitmap(bitmapNative, false, ((float) bitmapNative.getWidth()) * this.iaU);
                        } else {
                            bitmapNative = BitmapUtil.getRoundedCornerBitmap(bitmapNative, false, ((float) bitmapNative.getWidth()) * 0.5f);
                        }
                    }
                    setImageBitmap(bitmapNative);
                    setImageBitmapCompleted(bitmapNative);
                    AppMethodBeat.o(152175);
                    return true;
                }
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.CdnImageView", e2, "setBitmapFromLocalCache error: %s", e2.getMessage());
        }
        AppMethodBeat.o(152175);
        return false;
    }

    private void gJ(String str, int i2) {
        AppMethodBeat.i(152176);
        q.bcQ();
        Bitmap EP = com.tencent.mm.av.d.EP(str);
        if (EP != null) {
            if (this.targetWidth > 0 && this.targetHeight > 0) {
                EP = BitmapUtil.extractThumbNail(EP, this.targetWidth, this.targetHeight, true, false);
            }
            if (this.KeQ && EP != null) {
                if (this.iaU > 0.0f) {
                    EP = BitmapUtil.getRoundedCornerBitmap(EP, false, ((float) EP.getWidth()) * this.iaU);
                } else {
                    EP = BitmapUtil.getRoundedCornerBitmap(EP, false, ((float) EP.getWidth()) * 0.5f);
                }
            }
            setImageBitmap(EP);
            setImageBitmapCompleted(EP);
            AppMethodBeat.o(152176);
        } else if (!this.KeR || !gpu()) {
            if (i2 > 0) {
                setImageResource(i2);
            } else {
                setImageBitmap(null);
            }
            this.KeS = h.RTc.aY(new a(str, this.handler));
            AppMethodBeat.o(152176);
        } else {
            AppMethodBeat.o(152176);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(223848);
        super.onDetachedFromWindow();
        if (this.KeS != null) {
            this.KeS.cancel(false);
        }
        AppMethodBeat.o(223848);
    }

    private String getAccImagesPath() {
        AppMethodBeat.i(152177);
        String str = b.aKJ() + "wallet_images/";
        AppMethodBeat.o(152177);
        return str;
    }

    /* access modifiers changed from: package-private */
    public static class a implements com.tencent.f.i.h {
        private MMHandler handler;
        private String url;

        a(String str, MMHandler mMHandler) {
            this.url = str;
            this.handler = mMHandler;
        }

        public final void run() {
            AppMethodBeat.i(152165);
            byte[] httpGet = Util.httpGet(this.url);
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putByteArray("k_data", httpGet);
            bundle.putString("k_url", this.url);
            obtain.setData(bundle);
            this.handler.sendMessage(obtain);
            AppMethodBeat.o(152165);
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "CdnImageView_download";
        }
    }

    static /* synthetic */ void a(CdnImageView cdnImageView, Bitmap bitmap) {
        AppMethodBeat.i(152178);
        if (bitmap != null) {
            try {
                String cacheFilePath = cdnImageView.getCacheFilePath();
                Log.d("MicroMsg.CdnImageView", "useSdcardCache, path: %s", cacheFilePath);
                BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, cacheFilePath, false);
                AppMethodBeat.o(152178);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.CdnImageView", e2, "saveBitmapToLocalCache error: %s", e2.getMessage());
            }
        }
        AppMethodBeat.o(152178);
    }
}
