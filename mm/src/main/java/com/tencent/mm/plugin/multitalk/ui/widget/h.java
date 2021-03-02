package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\u0012J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000fH\u0002J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u000fJ\u000e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u000fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0004R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniStatusLayout;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "cameraStatusIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "context", "Landroid/content/Context;", "mStatusIconLayout", "muteStatusIcon", "getRootView", "()Landroid/view/View;", "setRootView", "showCameraIcon", "", "showMuteIcon", "refreshLayoutCauseDockChanged", "", "isDockerLeft", "refreshMiniView", "setDoubleIcon", "isMuteOn", "isCameraOn", "showSelfCameraIcon", "show", "showSelfMuteIcon", "plugin-multitalk_release"})
public final class h {
    private Context context = this.lJI.getContext();
    View lJI;
    private View zST;
    private WeImageView zSU = ((WeImageView) this.lJI.findViewById(R.id.fp3));
    private WeImageView zSV;
    boolean zSW;
    boolean zSX;

    public h(View view) {
        p.h(view, "rootView");
        AppMethodBeat.i(239786);
        this.lJI = view;
        WeImageView weImageView = this.zSU;
        if (weImageView != null) {
            weImageView.setImageResource(R.raw.icons_filled_video_call);
        }
        WeImageView weImageView2 = this.zSU;
        if (weImageView2 != null) {
            weImageView2.setIconColor(Color.parseColor("#07C160"));
        }
        WeImageView weImageView3 = this.zSU;
        if (weImageView3 != null) {
            weImageView3.setVisibility(8);
        }
        this.zSV = (WeImageView) this.lJI.findViewById(R.id.fp4);
        WeImageView weImageView4 = this.zSV;
        if (weImageView4 != null) {
            weImageView4.setImageResource(R.raw.icons_filled_mike);
        }
        WeImageView weImageView5 = this.zSV;
        if (weImageView5 != null) {
            Context context2 = this.context;
            if (context2 == null) {
                p.hyc();
            }
            weImageView5.setIconColor(context2.getResources().getColor(R.color.Brand));
        }
        WeImageView weImageView6 = this.zSV;
        if (weImageView6 != null) {
            weImageView6.setVisibility(8);
        }
        this.zST = this.lJI.findViewById(R.id.dtn);
        View view2 = this.zST;
        if (view2 != null) {
            view2.setVisibility(8);
            AppMethodBeat.o(239786);
            return;
        }
        AppMethodBeat.o(239786);
    }

    /* access modifiers changed from: package-private */
    public final void aa(boolean z, boolean z2) {
        AppMethodBeat.i(239785);
        View view = this.zST;
        if (view != null) {
            view.setVisibility(0);
        }
        WeImageView weImageView = this.zSV;
        if (weImageView != null) {
            weImageView.setVisibility(0);
        }
        WeImageView weImageView2 = this.zSU;
        if (weImageView2 != null) {
            weImageView2.setVisibility(0);
        }
        if (!z) {
            WeImageView weImageView3 = this.zSV;
            if (weImageView3 != null) {
                weImageView3.setImageResource(R.raw.icons_filled_mike);
            }
            WeImageView weImageView4 = this.zSV;
            if (weImageView4 != null) {
                Context context2 = this.context;
                if (context2 == null) {
                    p.hyc();
                }
                weImageView4.setIconColor(context2.getResources().getColor(R.color.Brand));
            }
        } else {
            WeImageView weImageView5 = this.zSV;
            if (weImageView5 != null) {
                weImageView5.setImageResource(R.raw.icons_filled_mike);
            }
            WeImageView weImageView6 = this.zSV;
            if (weImageView6 != null) {
                Context context3 = this.context;
                if (context3 == null) {
                    p.hyc();
                }
                weImageView6.setIconColor(context3.getResources().getColor(R.color.FG_2));
            }
        }
        if (z2) {
            WeImageView weImageView7 = this.zSU;
            if (weImageView7 != null) {
                weImageView7.setImageResource(R.raw.icons_filled_video_call);
            }
            WeImageView weImageView8 = this.zSU;
            if (weImageView8 != null) {
                Context context4 = this.context;
                if (context4 == null) {
                    p.hyc();
                }
                weImageView8.setIconColor(context4.getResources().getColor(R.color.Brand));
                AppMethodBeat.o(239785);
                return;
            }
            AppMethodBeat.o(239785);
            return;
        }
        WeImageView weImageView9 = this.zSU;
        if (weImageView9 != null) {
            weImageView9.setImageResource(R.raw.icons_filled_video_call);
        }
        WeImageView weImageView10 = this.zSU;
        if (weImageView10 != null) {
            Context context5 = this.context;
            if (context5 == null) {
                p.hyc();
            }
            weImageView10.setIconColor(context5.getResources().getColor(R.color.FG_2));
            AppMethodBeat.o(239785);
            return;
        }
        AppMethodBeat.o(239785);
    }
}
