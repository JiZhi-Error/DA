package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\u0016J\u0018\u0010\u0017\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "errIv", "Landroid/widget/ImageView;", "errTv", "Landroid/widget/TextView;", "root", "Landroid/view/View;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "setCigError", "errMsg", "errCode", "", "setPlayError", "plugin-brandservice_release"})
public final class MPVideoErrorView extends RelativeLayout {
    private final String TAG = "MicroMsg.MPVideoErrorView";
    View gvQ;
    TextView pIG;
    ImageView pIH;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MPVideoErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(7252);
        View.inflate(context, R.layout.bbt, this);
        View findViewById = findViewById(R.id.a9y);
        p.g(findViewById, "findViewById(R.id.biz_video_play_err_info_tv)");
        this.pIG = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.a9x);
        p.g(findViewById2, "findViewById(R.id.biz_video_play_err_info_iv)");
        this.pIH = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.h8v);
        p.g(findViewById3, "findViewById(R.id.root)");
        this.gvQ = findViewById3;
        AppMethodBeat.o(7252);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ MPVideoErrorView pII;
        final /* synthetic */ b pIJ;

        a(MPVideoErrorView mPVideoErrorView, b bVar) {
            this.pII = mPVideoErrorView;
            this.pIJ = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(7249);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.pII.setVisibility(8);
            this.pIJ.cpT();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(7249);
        }
    }

    public final void setPlayError$505cff1c(String str) {
        AppMethodBeat.i(7250);
        this.pIH.setBackgroundResource(R.drawable.c0h);
        this.pIG.setText(str);
        this.gvQ.setClickable(false);
        AppMethodBeat.o(7250);
    }

    public final void setCigError$505cff1c(String str) {
        AppMethodBeat.i(259602);
        this.pIH.setBackgroundResource(R.drawable.c0j);
        if (!Util.isNullOrNil(str)) {
            this.pIG.setText(getContext().getString(R.string.f3r) + ' ' + str);
        } else {
            this.pIG.setText(getContext().getString(R.string.f3r));
        }
        this.gvQ.setClickable(true);
        AppMethodBeat.o(259602);
    }
}
