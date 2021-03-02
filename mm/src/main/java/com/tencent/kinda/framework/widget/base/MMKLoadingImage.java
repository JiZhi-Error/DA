package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.kinda.gen.KLoadingImage;
import com.tencent.kinda.gen.LoadingImageStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable;

public class MMKLoadingImage extends MMKView<LinearLayout> implements KLoadingImage {
    private CircleProgressDrawable circleProgressDrawable;
    private LoadingImageStyle loadingImageStype;
    private ProgressBar progressBar;

    @Override // com.tencent.kinda.framework.widget.base.MMKView
    public LinearLayout createView(Context context) {
        AppMethodBeat.i(19084);
        LinearLayout linearLayout = new LinearLayout(context);
        this.progressBar = new ProgressBar(context);
        this.circleProgressDrawable = new CircleProgressDrawable(context);
        this.circleProgressDrawable.setStrokeColor(R.color.ty);
        this.progressBar.setIndeterminateDrawable(this.circleProgressDrawable);
        this.progressBar.setVisibility(8);
        linearLayout.addView(this.progressBar, new LinearLayout.LayoutParams(-1, -1));
        AppMethodBeat.o(19084);
        return linearLayout;
    }

    @Override // com.tencent.kinda.gen.KLoadingImage
    public void startAnimating() {
        AppMethodBeat.i(19085);
        this.circleProgressDrawable.cbk();
        this.circleProgressDrawable.start();
        this.progressBar.setVisibility(0);
        AppMethodBeat.o(19085);
    }

    @Override // com.tencent.kinda.gen.KLoadingImage
    public void stopAnimating() {
        AppMethodBeat.i(19086);
        this.circleProgressDrawable.stop();
        this.progressBar.setVisibility(8);
        AppMethodBeat.o(19086);
    }

    @Override // com.tencent.kinda.gen.KLoadingImage
    public void setStyle(LoadingImageStyle loadingImageStyle) {
        AppMethodBeat.i(19087);
        this.loadingImageStype = loadingImageStyle;
        if (loadingImageStyle == LoadingImageStyle.WHITE) {
            this.circleProgressDrawable.setStrokeColor(R.color.ag1);
        } else if (loadingImageStyle == LoadingImageStyle.WHITELARGE) {
            this.circleProgressDrawable.setStrokeColor(R.color.ag1);
        } else if (loadingImageStyle == LoadingImageStyle.GRAY) {
            this.circleProgressDrawable.setStrokeColor(R.color.ty);
        }
        this.progressBar.setIndeterminateDrawable(this.circleProgressDrawable);
        AppMethodBeat.o(19087);
    }

    @Override // com.tencent.kinda.gen.KLoadingImage
    public LoadingImageStyle getStyle() {
        return this.loadingImageStype;
    }
}
