package com.tencent.kinda.framework.widget.base;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.framework.widget.tools.ResourcesUtils;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.KImage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.hardcoder.g;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.d;
import com.tencent.mm.network.x;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.InputStream;

public class MMKImage implements KImage {
    private static final String PATTERN_FILE = "file://";
    private static final String PATTERN_HTTP = "http://";
    private static final String PATTERN_HTTPS = "https://";
    private final ImageInfo darkImage = new ImageInfo();
    private final ImageInfo lightImage = new ImageInfo();

    /* access modifiers changed from: package-private */
    public static class ImageInfo {
        Drawable drawable;
        float height = -1.0f;
        Bitmap imageBitmap;
        boolean isNetworkImage = false;
        boolean isSvgUrl;
        int localResId;
        private int mSvgColor;
        boolean needGetNetworkImageImmediately = false;
        String url;
        float width = -1.0f;

        ImageInfo() {
        }

        /* access modifiers changed from: package-private */
        public void parse() {
            int resId;
            AppMethodBeat.i(214520);
            if (this.url == null) {
                AppMethodBeat.o(214520);
                return;
            }
            if (this.url.startsWith(MMKImage.PATTERN_FILE)) {
                this.imageBitmap = BitmapUtil.getBitmapNative(this.url.replaceFirst(MMKImage.PATTERN_FILE, ""));
            } else if (this.url.startsWith("http://") || this.url.startsWith("https://")) {
                this.isNetworkImage = true;
                if (this.needGetNetworkImageImmediately) {
                    try {
                        this.imageBitmap = getImageFromNet(this.url);
                    } catch (Exception e2) {
                        this.imageBitmap = null;
                    }
                }
            } else {
                this.localResId = ResourcesUtils.getDrawableId(MMApplicationContext.getContext(), this.url);
                if ((this.localResId == 0 || this.isSvgUrl) && (resId = ResourcesUtils.getResId(MMApplicationContext.getContext(), this.url, ShareConstants.DEXMODE_RAW)) != 0) {
                    this.localResId = resId;
                }
                this.imageBitmap = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), this.localResId);
                if (this.imageBitmap == null) {
                    try {
                        this.drawable = MMApplicationContext.getContext().getResources().getDrawable(this.localResId);
                    } catch (Resources.NotFoundException e3) {
                        this.drawable = null;
                    }
                }
            }
            if (this.imageBitmap != null) {
                this.width = (float) this.imageBitmap.getWidth();
                this.height = (float) this.imageBitmap.getHeight();
            }
            AppMethodBeat.o(214520);
        }

        private Bitmap getImageFromNet(String str) {
            InputStream inputStream;
            AppMethodBeat.i(214521);
            if (!Util.isNullOrNil(str)) {
                if (str.startsWith("http://")) {
                    x a2 = d.a(str, null);
                    a2.setConnectTimeout(10000);
                    a2.setReadTimeout(g.sHCENCODEVIDEOTIMEOUT);
                    a2.setRequestMethod("GET");
                    if (a2.getResponseCode() == 200) {
                        inputStream = a2.getInputStream();
                    }
                    inputStream = null;
                } else {
                    if (str.startsWith("https://")) {
                        aa RR = d.RR(str);
                        RR.setConnectTimeout(10000);
                        RR.setReadTimeout(g.sHCENCODEVIDEOTIMEOUT);
                        RR.jFs.setRequestMethod("GET");
                        inputStream = RR.jFs.getInputStream();
                    }
                    inputStream = null;
                }
                if (inputStream != null) {
                    Bitmap decodeStream = MMBitmapFactory.decodeStream(inputStream);
                    AppMethodBeat.o(214521);
                    return decodeStream;
                }
            }
            AppMethodBeat.o(214521);
            return null;
        }

        public float getWidth() {
            AppMethodBeat.i(214522);
            if (this.imageBitmap != null) {
                float width2 = (float) this.imageBitmap.getWidth();
                AppMethodBeat.o(214522);
                return width2;
            }
            AppMethodBeat.o(214522);
            return 0.0f;
        }

        public float getHeight() {
            AppMethodBeat.i(214523);
            if (this.imageBitmap != null) {
                float height2 = (float) this.imageBitmap.getHeight();
                AppMethodBeat.o(214523);
                return height2;
            }
            AppMethodBeat.o(214523);
            return 0.0f;
        }

        public void setSvgUrl(String str, DynamicColor dynamicColor) {
            AppMethodBeat.i(214524);
            this.isSvgUrl = true;
            this.url = str;
            parse();
            if (!(this.drawable == null || dynamicColor == null)) {
                setIconColor((int) ColorUtil.getColorByMode(dynamicColor));
                this.mSvgColor = (int) ColorUtil.getColorByMode(dynamicColor);
            }
            AppMethodBeat.o(214524);
        }

        public Bitmap getBitmap() {
            AppMethodBeat.i(214525);
            if (!Util.isNullOrNil(this.url) && this.imageBitmap == null && !this.isNetworkImage) {
                parse();
            }
            Bitmap bitmap = this.imageBitmap;
            AppMethodBeat.o(214525);
            return bitmap;
        }

        public Drawable getDrawable() {
            AppMethodBeat.i(214526);
            if (!Util.isNullOrNil(this.url) && ((this.imageBitmap == null || this.drawable == null) && !this.isNetworkImage)) {
                parse();
            }
            if (this.imageBitmap != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(MMApplicationContext.getContext().getResources(), this.imageBitmap);
                AppMethodBeat.o(214526);
                return bitmapDrawable;
            } else if (this.drawable != null) {
                setIconColor(this.mSvgColor);
                Drawable drawable2 = this.drawable;
                AppMethodBeat.o(214526);
                return drawable2;
            } else {
                AppMethodBeat.o(214526);
                return null;
            }
        }

        public void drawableTint(DynamicColor dynamicColor) {
            AppMethodBeat.i(214527);
            if (!(this.drawable == null || dynamicColor == null)) {
                this.drawable.setColorFilter((int) ColorUtil.getColorByMode(dynamicColor), PorterDuff.Mode.SRC_ATOP);
                this.mSvgColor = (int) ColorUtil.getColorByMode(dynamicColor);
            }
            AppMethodBeat.o(214527);
        }

        public void setIconColor(int i2) {
            int i3;
            AppMethodBeat.i(214528);
            if (this.drawable != null) {
                if (i2 != 0) {
                    i3 = (16777215 & i2) | WebView.NIGHT_MODE_COLOR;
                } else {
                    i3 = i2;
                }
                int alpha = Color.alpha(i2);
                this.drawable.mutate().setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_ATOP));
                if (i2 != 0) {
                    this.drawable.setAlpha(alpha);
                }
            }
            AppMethodBeat.o(214528);
        }
    }

    public MMKImage() {
        AppMethodBeat.i(214529);
        AppMethodBeat.o(214529);
    }

    private ImageInfo getImage() {
        AppMethodBeat.i(214530);
        if (!ao.isDarkMode() || Util.isNullOrNil(this.darkImage.url)) {
            ImageInfo imageInfo = this.lightImage;
            AppMethodBeat.o(214530);
            return imageInfo;
        }
        ImageInfo imageInfo2 = this.darkImage;
        AppMethodBeat.o(214530);
        return imageInfo2;
    }

    @Override // com.tencent.kinda.gen.KImage
    public void setUrl(String str) {
        AppMethodBeat.i(19043);
        if (str.equals("PaidDetail_WeChatPay.png")) {
            AppMethodBeat.o(19043);
            return;
        }
        this.lightImage.url = str;
        this.lightImage.parse();
        AppMethodBeat.o(19043);
    }

    @Override // com.tencent.kinda.gen.KImage
    public void setDarkModeUrl(String str) {
        AppMethodBeat.i(214531);
        this.darkImage.url = str;
        this.darkImage.parse();
        AppMethodBeat.o(214531);
    }

    @Override // com.tencent.kinda.gen.KImage
    public String getUrl() {
        AppMethodBeat.i(214532);
        String str = getImage().url;
        AppMethodBeat.o(214532);
        return str;
    }

    public String getDarkUrl() {
        return this.darkImage.url;
    }

    @Override // com.tencent.kinda.gen.KImage
    public float getWidth() {
        AppMethodBeat.i(19044);
        float width = getImage().getWidth();
        AppMethodBeat.o(19044);
        return width;
    }

    @Override // com.tencent.kinda.gen.KImage
    public float getHeight() {
        AppMethodBeat.i(19045);
        float height = getImage().getHeight();
        AppMethodBeat.o(19045);
        return height;
    }

    @Override // com.tencent.kinda.gen.KImage
    public void stretchImage(float f2, float f3) {
    }

    @Override // com.tencent.kinda.gen.KImage
    public void setSvgUrl(String str, DynamicColor dynamicColor) {
        AppMethodBeat.i(19050);
        getImage().setSvgUrl(str, dynamicColor);
        AppMethodBeat.o(19050);
    }

    public Bitmap getBitmap() {
        AppMethodBeat.i(19047);
        Bitmap bitmap = getImage().getBitmap();
        AppMethodBeat.o(19047);
        return bitmap;
    }

    public Drawable getDrawable() {
        AppMethodBeat.i(19048);
        Drawable drawable = getImage().getDrawable();
        AppMethodBeat.o(19048);
        return drawable;
    }

    public boolean isNetworkImage() {
        AppMethodBeat.i(214533);
        boolean z = getImage().isNetworkImage;
        AppMethodBeat.o(214533);
        return z;
    }

    public void setNeedGetNetworkImageImmediately(boolean z) {
        this.lightImage.needGetNetworkImageImmediately = z;
        this.darkImage.needGetNetworkImageImmediately = z;
    }

    public boolean isNeedGetNetworkImageImmediately() {
        AppMethodBeat.i(214534);
        boolean z = getImage().needGetNetworkImageImmediately;
        AppMethodBeat.o(214534);
        return z;
    }

    public void drawableTint(DynamicColor dynamicColor) {
        AppMethodBeat.i(160762);
        getImage().drawableTint(dynamicColor);
        AppMethodBeat.o(160762);
    }

    private void setIconColor(int i2) {
        AppMethodBeat.i(214535);
        getImage().setIconColor(i2);
        AppMethodBeat.o(214535);
    }
}
