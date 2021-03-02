package com.tencent.mm.plugin.appbrand.share.widget;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.plugin.appbrand.ac.n;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.TbsListener;

public class WxaShareMessagePage extends LinearLayout implements LifecycleObserver, b.k {
    TextView mPa;
    public ImageView mvU;
    public ImageView nNj;
    IPCDynamicPageView nNk;
    ThreeDotsLoadingView nNl;
    public RelativeLayout nNm;
    ImageView nNn;
    MMSwitchBtn nNo;
    public ImageView nNp;
    public TextView nNq;
    k.b nNr;
    public k.c nNs;
    public View nNt;
    public boolean nNu;
    private ImageView nNv;

    public WxaShareMessagePage(Context context) {
        super(context);
        AppMethodBeat.i(48339);
        init(context);
        AppMethodBeat.o(48339);
    }

    public WxaShareMessagePage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(48340);
        init(context);
        AppMethodBeat.o(48340);
    }

    public WxaShareMessagePage(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(48341);
        init(context);
        AppMethodBeat.o(48341);
    }

    private void init(Context context) {
        AppMethodBeat.i(48342);
        View inflate = View.inflate(context, R.layout.cd0, this);
        this.nNt = inflate.findViewById(R.id.d9u);
        this.mvU = (ImageView) inflate.findViewById(R.id.bh7);
        this.nNj = (ImageView) inflate.findViewById(R.id.c4n);
        this.nNk = (IPCDynamicPageView) inflate.findViewById(R.id.jnz);
        this.mPa = (TextView) inflate.findViewById(R.id.ir3);
        this.nNv = (ImageView) inflate.findViewById(R.id.j51);
        this.nNl = (ThreeDotsLoadingView) inflate.findViewById(R.id.epy);
        View inflate2 = LayoutInflater.from(context).inflate(R.layout.ayf, (ViewGroup) inflate, false);
        this.nNp = (ImageView) inflate2.findViewById(R.id.hpp);
        this.nNq = (TextView) inflate2.findViewById(R.id.hpq);
        this.nNm = (RelativeLayout) inflate.findViewById(R.id.irh);
        this.nNn = (ImageView) inflate.findViewById(R.id.dza);
        this.nNo = (MMSwitchBtn) inflate.findViewById(R.id.irg);
        ((ViewGroup) inflate.findViewById(R.id.be3)).addView(inflate2);
        setGravity(17);
        this.nNn.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(180364);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/appbrand/share/widget/WxaShareMessagePage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (WxaShareMessagePage.this.nNs != null) {
                    WxaShareMessagePage.this.nNs.aXL();
                }
                a.a(this, "com/tencent/mm/plugin/appbrand/share/widget/WxaShareMessagePage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(180364);
            }
        });
        setTag(R.id.rh, Boolean.FALSE);
        this.nNo.setSwitchListener(new MMSwitchBtn.a() {
            /* class com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage.AnonymousClass2 */

            @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
            public final void onStatusChange(boolean z) {
                AppMethodBeat.i(180365);
                WxaShareMessagePage.this.setTag(R.id.rh, Boolean.valueOf(z));
                if (WxaShareMessagePage.this.nNs != null) {
                    WxaShareMessagePage.this.nNs.ft(z);
                }
                AppMethodBeat.o(180365);
            }
        });
        AppMethodBeat.o(48342);
    }

    public void setOnLoadImageResult(k.b bVar) {
        this.nNr = bVar;
    }

    @Override // com.tencent.mm.modelappbrand.a.b.k
    public final void aYg() {
    }

    @Override // com.tencent.mm.modelappbrand.a.b.k
    public final void I(Bitmap bitmap) {
        AppMethodBeat.i(48343);
        this.nNl.setVisibility(4);
        this.nNl.gZi();
        if (bitmap == null || bitmap.isRecycled()) {
            this.mvU.setImageBitmap(null);
            this.nNj.setVisibility(0);
        } else {
            this.mvU.setImageBitmap(bitmap);
            this.nNj.setVisibility(4);
        }
        if (this.nNr != null) {
            this.nNr.sD(0);
        }
        AppMethodBeat.o(48343);
    }

    @Override // com.tencent.mm.modelappbrand.a.b.k
    public final void oD() {
        AppMethodBeat.i(48344);
        this.nNl.setVisibility(4);
        this.nNl.gZi();
        this.mvU.setImageBitmap(null);
        this.nNj.setVisibility(0);
        if (this.nNr != null) {
            this.nNr.sD(1);
        }
        AppMethodBeat.o(48344);
    }

    @Override // com.tencent.mm.modelappbrand.a.b.k, com.tencent.mm.modelappbrand.a.c
    public final String Lb() {
        AppMethodBeat.i(48345);
        String cO = n.cO(this);
        AppMethodBeat.o(48345);
        return cO;
    }

    public void setImageUrl(String str) {
        AppMethodBeat.i(48346);
        this.nNl.setVisibility(0);
        this.nNl.gZh();
        this.nNj.setVisibility(4);
        this.mvU.setVisibility(0);
        if (this.nNu) {
            b.aXY().a(this, str, (b.h) null, ((k) g.af(k.class)).a(112, 90, k.a.DECODE_TYPE_ORIGIN));
            AppMethodBeat.o(48346);
            return;
        }
        b.aXY().a(this, str, (b.h) null, ((k) g.af(k.class)).m10do(112, 90));
        AppMethodBeat.o(48346);
    }

    public void setImageData(Bitmap bitmap) {
        AppMethodBeat.i(48347);
        this.mvU.setVisibility(0);
        this.nNl.setVisibility(4);
        this.nNj.setVisibility(4);
        if (bitmap == null || bitmap.isRecycled()) {
            this.mvU.setImageBitmap(null);
            AppMethodBeat.o(48347);
        } else if (this.nNu) {
            this.mvU.setImageBitmap(bitmap);
            AppMethodBeat.o(48347);
        } else {
            this.mvU.setImageBitmap(((k) g.af(k.class)).aXK().J(bitmap));
            AppMethodBeat.o(48347);
        }
    }

    public void setTitle(String str) {
        AppMethodBeat.i(48348);
        this.mPa.setText(str);
        AppMethodBeat.o(48348);
    }

    public ImageView getCoverImageView() {
        return this.mvU;
    }

    public ImageView getErrorImageView() {
        return this.nNj;
    }

    public IPCDynamicPageView getWidgetPageView() {
        return this.nNk;
    }

    public ThreeDotsLoadingView getLoadingView() {
        return this.nNl;
    }

    public int getWidgetWidth() {
        AppMethodBeat.i(48349);
        int zD = com.tencent.mm.plugin.appbrand.ac.g.zD(TbsListener.ErrorCode.EXCEED_INCR_UPDATE);
        AppMethodBeat.o(48349);
        return zD;
    }

    public int getWidgetHeight() {
        AppMethodBeat.i(48350);
        int zD = com.tencent.mm.plugin.appbrand.ac.g.zD(TXLiveConstants.RENDER_ROTATION_180);
        AppMethodBeat.o(48350);
        return zD;
    }

    public ImageView getVideoIcon() {
        return this.nNv;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onActivityDestroyed() {
        AppMethodBeat.i(227433);
        this.nNl.gZi();
        b.aXY().a(this);
        AppMethodBeat.o(227433);
    }
}
