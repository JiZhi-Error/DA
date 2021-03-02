package com.tencent.mm.plugin.eggspring.ui;

import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001e\u0018\u00002\u00020\u0001B¥\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u0007¢\u0006\u0002\u0010\u001dR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010+R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010+R\u0011\u0010\u0012\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b/\u0010#R\u0011\u0010\u0011\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b0\u0010#R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010(R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010+R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010+R\u0011\u0010\u0018\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b4\u0010#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010+R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\u001c\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b8\u0010&¨\u00069"}, hxF = {"Lcom/tencent/mm/plugin/eggspring/ui/SpringLuckyEggViewBinding;", "", "root", "Landroid/view/ViewGroup;", "loadingAnimator", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "bottomBrandTitleClickableIndicator", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "bottomBrandTitle", "Landroid/widget/TextView;", "bottomBrandSubtitle", "bottomBackgroundImage", "Landroid/widget/ImageView;", "brandName", "brandLogo", "cardRoot", "cardContainer", "cardTitle", "cardSubtitle", "acceptButton", "Landroid/widget/Button;", "cardMediaContainer", "cardCover", "mediaContainer", "moneyValue", "moneyContainer", "videoView", "Lcom/tencent/mm/plugin/eggspring/ui/SpringEggVideoView;", "volumeSwitch", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/gif/MMAnimateView;Lcom/tencent/mm/ui/widget/imageview/WeImageView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/ImageView;Landroid/widget/TextView;Lcom/tencent/mm/plugin/gif/MMAnimateView;Landroid/view/ViewGroup;Landroid/view/ViewGroup;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/Button;Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/gif/MMAnimateView;Landroid/view/ViewGroup;Landroid/widget/TextView;Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/eggspring/ui/SpringEggVideoView;Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "getAcceptButton", "()Landroid/widget/Button;", "getBottomBackgroundImage", "()Landroid/widget/ImageView;", "getBottomBrandSubtitle", "()Landroid/widget/TextView;", "getBottomBrandTitle", "getBottomBrandTitleClickableIndicator", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getBrandLogo", "()Lcom/tencent/mm/plugin/gif/MMAnimateView;", "getBrandName", "getCardContainer", "()Landroid/view/ViewGroup;", "getCardCover", "getCardMediaContainer", "getCardRoot", "getCardSubtitle", "getCardTitle", "getLoadingAnimator", "getMediaContainer", "getMoneyContainer", "getMoneyValue", "getRoot", "getVideoView", "()Lcom/tencent/mm/plugin/eggspring/ui/SpringEggVideoView;", "getVolumeSwitch", "plugin-eggspring_release"})
public final class c {
    final ViewGroup hwr;
    final TextView pYm;
    final TextView pYo;
    final MMAnimateView qVF;
    final WeImageView qVG;
    final TextView qVH;
    final TextView qVI;
    final ImageView qVJ;
    final MMAnimateView qVK;
    final ViewGroup qVL;
    final ViewGroup qVM;
    final TextView qVN;
    final Button qVO;
    final ViewGroup qVP;
    final MMAnimateView qVQ;
    final ViewGroup qVR;
    final TextView qVS;
    final ViewGroup qVT;
    final SpringEggVideoView qVU;
    final WeImageView qVV;

    public c(ViewGroup viewGroup, MMAnimateView mMAnimateView, WeImageView weImageView, TextView textView, TextView textView2, ImageView imageView, TextView textView3, MMAnimateView mMAnimateView2, ViewGroup viewGroup2, ViewGroup viewGroup3, TextView textView4, TextView textView5, Button button, ViewGroup viewGroup4, MMAnimateView mMAnimateView3, ViewGroup viewGroup5, TextView textView6, ViewGroup viewGroup6, SpringEggVideoView springEggVideoView, WeImageView weImageView2) {
        p.h(viewGroup, "root");
        p.h(mMAnimateView, "loadingAnimator");
        p.h(weImageView, "bottomBrandTitleClickableIndicator");
        p.h(textView, "bottomBrandTitle");
        p.h(textView2, "bottomBrandSubtitle");
        p.h(imageView, "bottomBackgroundImage");
        p.h(textView3, "brandName");
        p.h(mMAnimateView2, "brandLogo");
        p.h(viewGroup2, "cardRoot");
        p.h(viewGroup3, "cardContainer");
        p.h(textView4, "cardTitle");
        p.h(textView5, "cardSubtitle");
        p.h(button, "acceptButton");
        p.h(viewGroup4, "cardMediaContainer");
        p.h(mMAnimateView3, "cardCover");
        p.h(viewGroup5, "mediaContainer");
        p.h(textView6, "moneyValue");
        p.h(viewGroup6, "moneyContainer");
        p.h(springEggVideoView, "videoView");
        p.h(weImageView2, "volumeSwitch");
        AppMethodBeat.i(194624);
        this.hwr = viewGroup;
        this.qVF = mMAnimateView;
        this.qVG = weImageView;
        this.qVH = textView;
        this.qVI = textView2;
        this.qVJ = imageView;
        this.pYm = textView3;
        this.qVK = mMAnimateView2;
        this.qVL = viewGroup2;
        this.qVM = viewGroup3;
        this.qVN = textView4;
        this.pYo = textView5;
        this.qVO = button;
        this.qVP = viewGroup4;
        this.qVQ = mMAnimateView3;
        this.qVR = viewGroup5;
        this.qVS = textView6;
        this.qVT = viewGroup6;
        this.qVU = springEggVideoView;
        this.qVV = weImageView2;
        AppMethodBeat.o(194624);
    }
}
