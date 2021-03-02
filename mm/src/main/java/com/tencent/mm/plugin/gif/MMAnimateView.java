package com.tencent.mm.plugin.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.ki;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class MMAnimateView extends AppCompatImageView {
    private float mDensity;
    private String qXi;
    private int ydM;
    private int ydN;
    private boolean ydO;
    public boolean ydP;

    public MMAnimateView(Context context) {
        this(context, null);
    }

    public MMAnimateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMAnimateView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.ydM = R.drawable.emoji_download_icon;
        this.ydN = R.drawable.f3080me;
        this.ydO = true;
        this.mDensity = 0.0f;
        this.ydP = false;
    }

    @Override // android.support.v7.widget.AppCompatImageView
    public void setImageResource(int i2) {
        AppMethodBeat.i(104591);
        a(getResources(), i2, true);
        AppMethodBeat.o(104591);
    }

    @Override // android.support.v7.widget.AppCompatImageView
    public void setBackgroundResource(int i2) {
        AppMethodBeat.i(104592);
        a(getResources(), i2, false);
        AppMethodBeat.o(104592);
    }

    public void setImageFilePath(String str) {
        AppMethodBeat.i(104593);
        hV(str, null);
        AppMethodBeat.o(104593);
    }

    public final void hU(String str, String str2) {
        AppMethodBeat.i(104594);
        hV(str, str2);
        AppMethodBeat.o(104594);
    }

    public void setDefaultImageResource(int i2) {
        this.ydM = i2;
    }

    public void setDefaultBackgroundResource(int i2) {
        this.ydM = i2;
    }

    public float getEmojiDensityScale() {
        AppMethodBeat.i(104596);
        if (this.mDensity == 0.0f) {
            this.mDensity = a.getDensity(MMApplicationContext.getContext()) / 2.0f;
            if (this.mDensity < 1.0f) {
                this.mDensity = 1.0f;
            } else if (this.mDensity > 2.0f) {
                this.mDensity = 2.0f;
            }
        }
        float f2 = this.mDensity;
        AppMethodBeat.o(104596);
        return f2;
    }

    public int getEmojiDensity() {
        return 320;
    }

    public String getCacheKey() {
        return this.qXi;
    }

    public void setCacheKey(String str) {
        this.qXi = str;
    }

    public final void a(boolean z, boolean z2, int i2, int[] iArr, String str, String str2) {
        e eVar;
        AppMethodBeat.i(104597);
        if (!Util.isNullOrNil(str2)) {
            setCacheKey(str2);
            c dXx = c.dXx();
            Context context = getContext();
            if (TextUtils.isEmpty(str)) {
                eVar = null;
            } else {
                if (dXx.ydJ.get(str2) == null || dXx.ydJ.get(str2).get() == null) {
                    eVar = null;
                } else {
                    eVar = dXx.ydJ.get(str2).get();
                }
                if (eVar == null) {
                    eVar = new e(context, z, z2, i2, iArr, str);
                    dXx.ydJ.put(str2, new WeakReference<>(eVar));
                }
            }
            if (eVar != null) {
                eVar.yeC = z2;
                if (z == eVar.gNC) {
                    eVar.start();
                } else {
                    eVar.rmJ = 0;
                    eVar.yeE = 0;
                    eVar.gNC = true;
                    eVar.start();
                }
                setImageDrawable(eVar);
                AppMethodBeat.o(104597);
                return;
            }
            Log.e("MicroMsg.GIF.MMGIFImageView", "can not get drawable.");
            AppMethodBeat.o(104597);
            return;
        }
        e eVar2 = new e(getContext(), z, z2, i2, iArr, str);
        eVar2.start();
        setImageDrawable(eVar2);
        AppMethodBeat.o(104597);
    }

    private void a(Resources resources, int i2, boolean z) {
        b dVar;
        AppMethodBeat.i(104598);
        try {
            if (!Util.isNullOrNil((String) null)) {
                setCacheKey(null);
                dVar = c.dXx().c(resources, i2);
            } else {
                dVar = new d(resources, i2);
            }
            if (z) {
                setImageDrawable(dVar);
                AppMethodBeat.o(104598);
                return;
            }
            setBackgroundDrawable(dVar);
            AppMethodBeat.o(104598);
        } catch (IOException e2) {
            Log.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFResource failed. %s" + e2.toString());
            if (z) {
                super.setImageResource(i2);
                AppMethodBeat.o(104598);
                return;
            }
            super.setBackgroundResource(i2);
            AppMethodBeat.o(104598);
        }
    }

    public final void a(String str, k kVar) {
        AppMethodBeat.i(104599);
        try {
            d dVar = new d(str);
            setImageDrawable(dVar);
            dVar.yek = Integer.MAX_VALUE;
            dVar.yem = kVar;
            AppMethodBeat.o(104599);
        } catch (MMGIFException e2) {
            try {
                a(e2);
                if (e2.getErrorCode() == 103) {
                    Bitmap decodeStream = BitmapUtil.decodeStream(s.openRead(str));
                    if (decodeStream != null) {
                        decodeStream.setDensity(getEmojiDensity());
                        setImageBitmap(decodeStream);
                        AppMethodBeat.o(104599);
                        return;
                    }
                    Log.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed bitmap is null. show default and delete file. path:%s", str);
                    init();
                    s.deleteFile(str);
                    AppMethodBeat.o(104599);
                    return;
                }
            } catch (FileNotFoundException e3) {
                Log.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + e3.toString());
            }
            Log.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + e2.toString());
            init();
            AppMethodBeat.o(104599);
        } catch (IOException e4) {
            Log.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + e4.toString());
            init();
            AppMethodBeat.o(104599);
        }
    }

    public final void hV(String str, String str2) {
        Drawable dVar;
        AppMethodBeat.i(104600);
        try {
            if (ImgUtil.isWXGF(str)) {
                h hVar = new h(s.aW(str, 0, -1));
                hVar.start();
                setImageDrawable(hVar);
                AppMethodBeat.o(104600);
                return;
            }
            if (!Util.isNullOrNil(str2)) {
                setCacheKey(str2);
                dVar = c.dXx().hT(getCacheKey(), str);
            } else {
                dVar = new d(str, this.ydP);
            }
            setImageDrawable(dVar);
            AppMethodBeat.o(104600);
        } catch (MMGIFException e2) {
            try {
                a(e2);
                if (e2.getErrorCode() == 103) {
                    try {
                        Bitmap decodeFile = BitmapUtil.decodeFile(str, null);
                        if (decodeFile != null) {
                            decodeFile.setDensity(getEmojiDensity());
                            setImageBitmap(decodeFile);
                            AppMethodBeat.o(104600);
                            return;
                        }
                        Log.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failedbitmap is null. show default and delete file. path %s", str);
                        init();
                        s.deleteFile(str);
                        AppMethodBeat.o(104600);
                        return;
                    } catch (OutOfMemoryError e3) {
                        Log.printErrStackTrace("MicroMsg.GIF.MMGIFImageView", e3, "setMMGIFFilePath failed, oom happened. show default. path %s", str);
                        init();
                        AppMethodBeat.o(104600);
                    }
                }
                AppMethodBeat.o(104600);
            } catch (Exception e4) {
                Log.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed1. %s", Util.stackTraceToString(e4));
                AppMethodBeat.o(104600);
            }
        } catch (IOException e5) {
            Log.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed3. %s", Util.stackTraceToString(e5));
            s.deleteFile(str);
            init();
            AppMethodBeat.o(104600);
        } catch (NullPointerException e6) {
            init();
            AppMethodBeat.o(104600);
        }
    }

    public final void g(byte[] bArr, String str) {
        b dVar;
        AppMethodBeat.i(104601);
        if (bArr == null) {
            try {
                Log.e("MicroMsg.GIF.MMGIFImageView", "[setMMGIFFileByteArray] bytes is null! src:%s cacheKey:%s", Boolean.TRUE, str);
                AppMethodBeat.o(104601);
            } catch (MMGIFException e2) {
                a(e2);
                if (e2.getErrorCode() == 103) {
                    Bitmap decodeByteArray = BitmapUtil.decodeByteArray(bArr);
                    if (decodeByteArray != null) {
                        decodeByteArray.setDensity(getEmojiDensity());
                        setImageBitmap(decodeByteArray);
                        AppMethodBeat.o(104601);
                        return;
                    }
                    Log.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed bitmap is null. bytes %s", bArr.toString());
                    init();
                    AppMethodBeat.o(104601);
                    return;
                }
                Log.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed. %s", e2.toString());
                init();
                AppMethodBeat.o(104601);
            } catch (IOException e3) {
                Log.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed. %s", e3.toString());
                init();
                AppMethodBeat.o(104601);
            }
        } else {
            if (!Util.isNullOrNil(str)) {
                setCacheKey(str);
                dVar = c.dXx().s(getCacheKey(), bArr);
            } else {
                if (ImgUtil.isWXGF(bArr)) {
                    dVar = new h(bArr);
                } else {
                    dVar = new d(bArr);
                }
                dVar.start();
            }
            setImageDrawable(dVar);
            AppMethodBeat.o(104601);
        }
    }

    public final void init() {
        AppMethodBeat.i(104602);
        this.ydO = e.apn();
        if (this.ydO) {
            if (this.ydM > 0) {
                super.setImageResource(this.ydM);
                AppMethodBeat.o(104602);
                return;
            }
        } else if (this.ydN > 0) {
            super.setImageResource(this.ydN);
        }
        AppMethodBeat.o(104602);
    }

    public int getIntrinsicWidth() {
        AppMethodBeat.i(104603);
        if (getDrawable() == null) {
            AppMethodBeat.o(104603);
            return 0;
        }
        int intrinsicWidth = getDrawable().getIntrinsicWidth();
        AppMethodBeat.o(104603);
        return intrinsicWidth;
    }

    public int getIntrinsicHeight() {
        AppMethodBeat.i(104604);
        if (getDrawable() == null) {
            AppMethodBeat.o(104604);
            return 0;
        }
        int intrinsicHeight = getDrawable().getIntrinsicHeight();
        AppMethodBeat.o(104604);
        return intrinsicHeight;
    }

    public final boolean isRunning() {
        AppMethodBeat.i(104605);
        if (getDrawable() == null || !(getDrawable() instanceof b)) {
            AppMethodBeat.o(104605);
            return false;
        }
        boolean isRunning = ((b) getDrawable()).isRunning();
        AppMethodBeat.o(104605);
        return isRunning;
    }

    public final void start() {
        AppMethodBeat.i(104606);
        if (getDrawable() != null && (getDrawable() instanceof b)) {
            ((b) getDrawable()).start();
        }
        AppMethodBeat.o(104606);
    }

    public final void pause() {
        AppMethodBeat.i(104607);
        if (getDrawable() != null && (getDrawable() instanceof b)) {
            ((b) getDrawable()).pause();
        }
        AppMethodBeat.o(104607);
    }

    public final void resume() {
        AppMethodBeat.i(104608);
        if (getDrawable() != null && (getDrawable() instanceof b)) {
            ((b) getDrawable()).resume();
        }
        AppMethodBeat.o(104608);
    }

    public final void stop() {
        AppMethodBeat.i(104609);
        if (getDrawable() != null && (getDrawable() instanceof b)) {
            ((b) getDrawable()).stop();
        }
        AppMethodBeat.o(104609);
    }

    public static void a(MMGIFException mMGIFException) {
        AppMethodBeat.i(104610);
        ki kiVar = new ki();
        kiVar.dPs.errorCode = mMGIFException.getErrorCode();
        EventCenter.instance.publish(kiVar);
        AppMethodBeat.o(104610);
    }

    public final void recycle() {
        AppMethodBeat.i(104611);
        if (getDrawable() != null && (getDrawable() instanceof d)) {
            ((d) getDrawable()).recycle();
        }
        AppMethodBeat.o(104611);
    }

    public final void c(InputStream inputStream, String str) {
        b bVar = null;
        AppMethodBeat.i(104595);
        try {
            if (!Util.isNullOrNil(str)) {
                setCacheKey(str);
                c dXx = c.dXx();
                String cacheKey = getCacheKey();
                if (inputStream != null) {
                    Log.d("MicroMsg.GIF.MMAnimateDrawableCacheMgr", "stream key:%s", cacheKey);
                    if (dXx.ydK.get(cacheKey) != null) {
                        bVar = dXx.ydK.get(cacheKey).get();
                    }
                    if (bVar == null) {
                        bVar = new d(inputStream);
                        dXx.ydK.put(cacheKey, new WeakReference<>(bVar));
                    }
                }
            } else {
                bVar = new d(inputStream);
            }
            setImageDrawable(bVar);
            AppMethodBeat.o(104595);
        } catch (MMGIFException e2) {
            a(e2);
            if (e2.getErrorCode() == 103) {
                Bitmap decodeStream = BitmapUtil.decodeStream(inputStream);
                if (decodeStream != null) {
                    decodeStream.setDensity(getEmojiDensity());
                    setImageBitmap(decodeStream);
                    AppMethodBeat.o(104595);
                    return;
                }
                Log.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failedbitmap is null. bytes %s");
                init();
                AppMethodBeat.o(104595);
                return;
            }
            Log.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failed. %s", e2.toString());
            init();
            AppMethodBeat.o(104595);
        } catch (IOException e3) {
            Log.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failed. %s", e3.toString());
            init();
            AppMethodBeat.o(104595);
        }
    }
}
