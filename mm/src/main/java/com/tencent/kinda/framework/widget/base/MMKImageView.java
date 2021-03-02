package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.KImage;
import com.tencent.kinda.gen.KImageView;
import com.tencent.kinda.gen.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c;
import com.tencent.smtt.sdk.WebView;

public class MMKImageView extends MMKView<CdnImageView> implements KImageView {
    private byte[] ImageData;
    private MMKImage defaultImage = new MMKImage();
    private MMKImage image = new MMKImage();
    private ScaleType scaleType;
    private DynamicColor tintColor = new DynamicColor(0, 0);

    public MMKImageView() {
        AppMethodBeat.i(19052);
        AppMethodBeat.o(19052);
    }

    @Override // com.tencent.kinda.gen.KImageView
    public void setTintColor(DynamicColor dynamicColor) {
        AppMethodBeat.i(162114);
        if (ColorUtil.getColorByModeNoCompat(this.tintColor) != ColorUtil.getColorByMode(dynamicColor)) {
            this.tintColor = dynamicColor;
            Drawable drawable = ((CdnImageView) getView()).getDrawable();
            if (drawable != null) {
                drawable.setColorFilter((int) ColorUtil.getColorByMode(this.tintColor), PorterDuff.Mode.SRC_ATOP);
                setIconColor((int) ColorUtil.getColorByMode(this.tintColor), drawable);
                ((CdnImageView) getView()).setImageDrawable(drawable);
            }
            notifyChanged();
        }
        AppMethodBeat.o(162114);
    }

    @Override // com.tencent.kinda.gen.KImageView
    public DynamicColor getTintColor() {
        return this.tintColor;
    }

    @Override // com.tencent.kinda.framework.widget.base.MMKView
    public CdnImageView createView(Context context) {
        AppMethodBeat.i(19053);
        CdnImageView cdnImageView = new CdnImageView(context);
        cdnImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        cdnImageView.setAdjustViewBounds(true);
        cdnImageView.setImgSavedPath(c.hgG());
        this.image.setNeedGetNetworkImageImmediately(false);
        this.defaultImage.setNeedGetNetworkImageImmediately(false);
        cdnImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        AppMethodBeat.o(19053);
        return cdnImageView;
    }

    @Override // com.tencent.kinda.gen.KImageView
    public void setUrl(String str) {
        AppMethodBeat.i(19054);
        this.image.setSvgUrl(str, this.tintColor);
        setImage(this.image);
        AppMethodBeat.o(19054);
    }

    @Override // com.tencent.kinda.gen.KImageView
    public String getUrl() {
        AppMethodBeat.i(19055);
        String url = this.image.getUrl();
        AppMethodBeat.o(19055);
        return url;
    }

    @Override // com.tencent.kinda.gen.KImageView
    public void setDefaultUrl(String str) {
        AppMethodBeat.i(19056);
        if (this.defaultImage == null) {
            this.defaultImage = new MMKImage();
        }
        this.defaultImage.setUrl(str);
        if ((this.image == null || Util.isNullOrNil(this.image.getUrl())) && !Util.isNullOrNil(this.defaultImage.getUrl())) {
            if (this.defaultImage.isNetworkImage()) {
                ((CdnImageView) getView()).setUrl(this.defaultImage.getUrl());
            } else {
                ((CdnImageView) getView()).setImageBitmap(this.defaultImage.getBitmap());
            }
        }
        setCornerRadius(2.0f);
        AppMethodBeat.o(19056);
    }

    @Override // com.tencent.kinda.gen.KImageView
    public String getDefaultUrl() {
        AppMethodBeat.i(19057);
        String url = this.defaultImage.getUrl();
        AppMethodBeat.o(19057);
        return url;
    }

    @Override // com.tencent.kinda.gen.KImageView
    public void setDarkModeUrl(String str) {
        AppMethodBeat.i(214536);
        this.image.setDarkModeUrl(str);
        setImage(this.image);
        AppMethodBeat.o(214536);
    }

    @Override // com.tencent.kinda.gen.KImageView
    public String getDarkModeUrl() {
        AppMethodBeat.i(214537);
        String darkUrl = this.image.getDarkUrl();
        AppMethodBeat.o(214537);
        return darkUrl;
    }

    @Override // com.tencent.kinda.gen.KImageView
    public void setImage(KImage kImage) {
        AppMethodBeat.i(19058);
        if (kImage != null && (kImage instanceof MMKImage)) {
            this.image = (MMKImage) kImage;
            if (this.image.isNetworkImage()) {
                ((CdnImageView) getView()).setUrl(this.image.getUrl());
            } else if (this.image.getBitmap() != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(MMApplicationContext.getContext().getResources(), this.image.getBitmap());
                if (ColorUtil.getColorByMode(this.tintColor) != 0) {
                    bitmapDrawable.setColorFilter((int) ColorUtil.getColorByMode(this.tintColor), PorterDuff.Mode.SRC_ATOP);
                    setIconColor((int) ColorUtil.getColorByMode(this.tintColor), bitmapDrawable);
                }
                ((CdnImageView) getView()).setImageDrawable(bitmapDrawable);
            } else if (this.image.getDrawable() != null) {
                Drawable drawable = this.image.getDrawable();
                if (ColorUtil.getColorByMode(this.tintColor) != 0) {
                    drawable.setColorFilter((int) ColorUtil.getColorByMode(this.tintColor), PorterDuff.Mode.SRC_ATOP);
                    setIconColor((int) ColorUtil.getColorByMode(this.tintColor), drawable);
                }
                ((CdnImageView) getView()).setImageDrawable(drawable);
            }
            notifyChanged();
        }
        AppMethodBeat.o(19058);
    }

    @Override // com.tencent.kinda.gen.KImageView
    public KImage getImage() {
        return this.image;
    }

    @Override // com.tencent.kinda.gen.KImageView
    public void setScaleType(ScaleType scaleType2) {
        AppMethodBeat.i(19059);
        this.scaleType = scaleType2;
        switch (scaleType2) {
            case FILL:
                ((CdnImageView) getView()).setScaleType(ImageView.ScaleType.FIT_XY);
                break;
            case ASPECTFIT:
                ((CdnImageView) getView()).setScaleType(ImageView.ScaleType.FIT_CENTER);
                break;
            case ASPECTFILL:
                ((CdnImageView) getView()).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                break;
            case CENTER:
                ((CdnImageView) getView()).setScaleType(ImageView.ScaleType.CENTER);
                break;
        }
        notifyChanged();
        AppMethodBeat.o(19059);
    }

    @Override // com.tencent.kinda.gen.KImageView
    public ScaleType getScaleType() {
        return this.scaleType;
    }

    @Override // com.tencent.kinda.gen.KImageView
    public void setImageData(byte[] bArr) {
        AppMethodBeat.i(19060);
        if (bArr != null) {
            this.ImageData = bArr;
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(this.ImageData, 0, this.ImageData.length);
            setHeight((float) decodeByteArray.getHeight());
            ((CdnImageView) getView()).setImageBitmap(decodeByteArray);
        }
        AppMethodBeat.o(19060);
    }

    @Override // com.tencent.kinda.gen.KImageView
    public byte[] getImageData() {
        return this.ImageData;
    }

    private void setIconColor(int i2, Drawable drawable) {
        int i3;
        AppMethodBeat.i(214538);
        if (drawable != null) {
            if (i2 != 0) {
                i3 = (16777215 & i2) | WebView.NIGHT_MODE_COLOR;
            } else {
                i3 = i2;
            }
            int alpha = Color.alpha(i2);
            drawable.mutate().setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_ATOP));
            if (i2 != 0) {
                drawable.setAlpha(alpha);
            }
        }
        AppMethodBeat.o(214538);
    }

    @Override // com.tencent.kinda.gen.KView, com.tencent.kinda.framework.widget.base.MMKView
    public void setCornerRadius(float f2) {
        AppMethodBeat.i(258823);
        super.setCornerRadius(f2);
        if ((getView() instanceof CdnImageView) && getWidth() > 0.0f) {
            ((CdnImageView) getView()).setRoundCorner(true);
            ((CdnImageView) getView()).setRoundCornerRate(f2 / getWidth());
        }
        AppMethodBeat.o(258823);
    }
}
