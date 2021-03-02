package com.tencent.mm.plugin.recordvideo.plugin.cropvideo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.mmsight.segment.c;
import com.tencent.mm.plugin.recordvideo.background.provider.WeSeeProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.cropvideo.EditVideoSeekBarView;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u0000 Y2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001YB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0015J\u000e\u00100\u001a\u00020.2\u0006\u00101\u001a\u00020\u0017J\u0018\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u00152\u0006\u00104\u001a\u00020\u0015H\u0002J\u0010\u00105\u001a\u00020$2\u0006\u00106\u001a\u00020\u0015H\u0002J\n\u00107\u001a\u0004\u0018\u00010$H\u0016J\b\u00108\u001a\u00020\u0017H\u0016J\u0012\u00109\u001a\u00020.2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010<\u001a\u00020.H\u0002J\b\u0010=\u001a\u00020.H\u0002J\b\u0010>\u001a\u00020.H\u0002J \u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020\u00172\u0006\u0010A\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\u000eH\u0016J \u0010C\u001a\u00020.2\u0006\u0010@\u001a\u00020\u00172\u0006\u0010A\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\u000eH\u0016J\u0018\u0010D\u001a\u00020.2\u0006\u0010A\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\u000eH\u0016J \u0010E\u001a\u00020.2\u0006\u0010@\u001a\u00020\u00172\u0006\u0010A\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\u000eH\u0016J\b\u0010F\u001a\u00020.H\u0016J\b\u0010G\u001a\u00020.H\u0016J\u001f\u0010H\u001a\u00020.2\b\u0010I\u001a\u0004\u0018\u00010\u00152\b\u0010J\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010KJ\u0016\u0010L\u001a\u00020.2\u0006\u0010M\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010N\u001a\u00020.2\u0006\u0010O\u001a\u00020\u0017J\u0016\u0010P\u001a\u00020.2\u0006\u0010Q\u001a\u00020\u00152\u0006\u0010R\u001a\u00020\u0015J\u0010\u0010S\u001a\u00020.2\u0006\u0010T\u001a\u00020\u0015H\u0016J\b\u0010U\u001a\u00020.H\u0002J\u0006\u0010V\u001a\u00020.J\b\u0010W\u001a\u00020.H\u0002J\u0018\u0010X\u001a\u00020.2\u0006\u0010A\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\u000eH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006Z"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/mmsight/segment/ISegmentSeekBar$OnSeekBarChangedListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "cropBtn", "Landroid/widget/ImageView;", "cropEnd", "", "cropRecyclerThumbSeekBar", "Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView;", "cropStart", "dialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "entranceNum", "", "finderEnable", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "jumpHideAnimation", "longVideoTv", "Landroid/widget/TextView;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "phoenixDialog", "secondCutEnable", "sourceVideoPath", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "weseeArrowBtn", "weseeBtn", "weseeEnable", "weseeWrapper", "changeThumbBarPercent", "", "currentTime", "forceCropVideo", "isForce", "getSmaller", "a", "b", "getString", "resId", "name", "onBackPress", "onClick", "v", "Landroid/view/View;", "onClickFinder", "onClickSecondCut", "onClickWesee", "onDown", "left", "start", "end", "onMove", "onRecyclerChanged", "onUp", "release", "reset", "resetConfirmStyle", "bgStyleResId", "textColor", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "setCaptureInfo", "captureInfo", "setJumpHideAnimation", "jump", "setUIParams", "seekbarHeight", "bgResId", "setVisibility", "visibility", "showBottomSheet", "showWeSeeBtn", "startLoadThumbBitmap", "synCropInfo", "Companion", "plugin-recordvideo_release"})
public final class a implements View.OnClickListener, c.b, t {
    public static final C1650a BSG = new C1650a((byte) 0);
    private float BSA;
    private float BSB = 1.0f;
    private boolean BSC;
    private boolean BSD;
    private boolean BSE;
    private int BSF;
    private final ImageView BSr;
    public final EditVideoSeekBarView BSs;
    private final ViewGroup BSt = ((ViewGroup) this.parent.findViewById(R.id.jr4));
    private final ImageView BSu = ((ImageView) this.parent.findViewById(R.id.e4i));
    private final ImageView BSv = ((ImageView) this.parent.findViewById(R.id.e57));
    private final TextView BSw = ((TextView) this.parent.findViewById(R.id.ix_));
    public com.tencent.mm.media.widget.camerarecordview.b.b BSx;
    private com.tencent.mm.ui.widget.a.d BSy;
    public boolean BSz;
    private String iqd = "";
    private com.tencent.mm.ui.widget.a.d kvo;
    ViewGroup parent;
    public RecordConfigProvider wdm;
    private com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;

    static {
        AppMethodBeat.i(75702);
        AppMethodBeat.o(75702);
    }

    public a(ViewGroup viewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar) {
        p.h(viewGroup, "parent");
        p.h(dVar, "status");
        AppMethodBeat.i(75701);
        this.parent = viewGroup;
        this.wgr = dVar;
        View findViewById = this.parent.findViewById(R.id.bx5);
        p.g(findViewById, "parent.findViewById(R.id.editor_crop_video)");
        this.BSr = (ImageView) findViewById;
        View findViewById2 = this.parent.findViewById(R.id.bx4);
        p.g(findViewById2, "parent.findViewById(R.id.editor_crop_bar)");
        this.BSs = (EditVideoSeekBarView) findViewById2;
        this.BSr.setImageDrawable(ar.m(this.parent.getContext(), R.raw.icons_filled_crop, -1));
        this.BSr.setOnClickListener(this);
        this.BSs.setCancelButtonClickListener(this);
        this.BSs.setFinishButtonClickListener(this);
        ViewGroup.LayoutParams layoutParams = this.BSs.getLayoutParams();
        if (layoutParams == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(75701);
            throw tVar;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.bottomMargin += au.aD(this.parent.getContext());
        this.BSs.setLayoutParams(layoutParams2);
        AppMethodBeat.o(75701);
    }

    public static final /* synthetic */ void e(a aVar) {
        AppMethodBeat.i(237367);
        aVar.eKK();
        AppMethodBeat.o(237367);
    }

    public static final /* synthetic */ void f(a aVar) {
        AppMethodBeat.i(237368);
        aVar.eKL();
        AppMethodBeat.o(237368);
    }

    public static final /* synthetic */ void g(a aVar) {
        AppMethodBeat.i(237369);
        aVar.eKM();
        AppMethodBeat.o(237369);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void aSs() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onDetach() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(237366);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(237366);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
    /* renamed from: com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a$a  reason: collision with other inner class name */
    public static final class C1650a {
        private C1650a() {
        }

        public /* synthetic */ C1650a(byte b2) {
            this();
        }
    }

    private void eKJ() {
        Context context;
        ViewGroup.LayoutParams layoutParams;
        Context context2 = null;
        AppMethodBeat.i(237362);
        ViewGroup viewGroup = this.BSt;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        ViewGroup viewGroup2 = this.BSt;
        if (viewGroup2 != null) {
            viewGroup2.setOnClickListener(this);
        }
        ImageView imageView = this.BSu;
        if (imageView != null) {
            imageView.setImageDrawable(ar.m(this.parent.getContext(), R.raw.icons_filled_wesee, -1));
        }
        ImageView imageView2 = this.BSv;
        if (imageView2 != null) {
            imageView2.setImageDrawable(ar.m(this.parent.getContext(), R.raw.icons_filled_arrow, -1));
        }
        ViewGroup viewGroup3 = this.BSt;
        if (viewGroup3 != null) {
            context = viewGroup3.getContext();
        } else {
            context = null;
        }
        if (ao.aQ(context)) {
            ViewGroup viewGroup4 = this.BSt;
            if (viewGroup4 != null) {
                layoutParams = viewGroup4.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(237362);
                throw tVar;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i2 = marginLayoutParams.topMargin;
            ViewGroup viewGroup5 = this.BSt;
            if (viewGroup5 != null) {
                context2 = viewGroup5.getContext();
            }
            marginLayoutParams.topMargin = ao.aP(context2) + i2;
            ViewGroup viewGroup6 = this.BSt;
            if (viewGroup6 != null) {
                viewGroup6.setLayoutParams(marginLayoutParams);
                AppMethodBeat.o(237362);
                return;
            }
        }
        AppMethodBeat.o(237362);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(75690);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.bw3) {
            this.BSs.zDX.reset();
            d.b.a(this.wgr, d.c.BVt);
            this.BSs.animate().alpha(0.0f).setDuration(100).setListener(new c(this));
            ViewGroup viewGroup = this.BSt;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.bw6) {
            ae(this.BSA, this.BSB);
            d.b.a(this.wgr, d.c.BVu);
            if (!this.BSz) {
                this.BSs.animate().alpha(0.0f).setDuration(100).setListener(new d(this));
            }
            ViewGroup viewGroup2 = this.BSt;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(8);
            }
            com.tencent.mm.media.widget.camerarecordview.b.b bVar2 = this.BSx;
            if (bVar2 != null) {
                int i2 = bVar2.iqg - bVar2.dvv;
                com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.x("KEY_VIDEO_CROP_DURATION_MS_INT", Integer.valueOf((int) (((float) i2) * (this.BSB - this.BSA))));
                com.tencent.mm.plugin.recordvideo.d.g gVar = com.tencent.mm.plugin.recordvideo.d.g.BXY;
                com.tencent.mm.plugin.recordvideo.d.g.Ic((long) (((float) i2) * this.BSA));
                com.tencent.mm.plugin.recordvideo.d.g gVar2 = com.tencent.mm.plugin.recordvideo.d.g.BXY;
                com.tencent.mm.plugin.recordvideo.d.g.Id((long) (((float) i2) * this.BSB));
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.bx5) {
            tg(false);
            com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
            com.tencent.mm.plugin.recordvideo.d.c.aLu("KEY_CLICK_VIDEO_CROP_COUNT_INT");
        } else if (valueOf != null && valueOf.intValue() == R.id.jr4) {
            if (!WeChatBrands.Business.Entries.MomentChannels.checkAvailable(view.getContext())) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(75690);
                return;
            } else if (this.BSF >= 2) {
                com.tencent.mm.plugin.recordvideo.d.c cVar3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.eKZ();
                z.a aVar = new z.a();
                aVar.SYB = true;
                com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e(this.parent.getContext(), 1, true);
                eVar.a(new i(this, eVar));
                eVar.a(new j(this, aVar, eVar));
                eVar.b(new k(aVar));
                eVar.dGm();
            } else if (this.BSC) {
                eKK();
            } else if (this.BSD) {
                eKL();
            } else if (this.BSE) {
                eKM();
            }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(75690);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin$onClick$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-recordvideo_release"})
    public static final class c extends AnimatorListenerAdapter {
        final /* synthetic */ a BSH;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(a aVar) {
            this.BSH = aVar;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(75685);
            p.h(animator, "animation");
            this.BSH.BSs.setVisibility(8);
            this.BSH.BSs.setAlpha(1.0f);
            AppMethodBeat.o(75685);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin$onClick$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-recordvideo_release"})
    public static final class d extends AnimatorListenerAdapter {
        final /* synthetic */ a BSH;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(a aVar) {
            this.BSH = aVar;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(75686);
            p.h(animator, "animation");
            this.BSH.BSs.setVisibility(8);
            this.BSH.BSs.setAlpha(1.0f);
            AppMethodBeat.o(75686);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class i implements o.f {
        final /* synthetic */ a BSH;
        final /* synthetic */ com.tencent.mm.ui.widget.a.e nkZ;

        i(a aVar, com.tencent.mm.ui.widget.a.e eVar) {
            this.BSH = aVar;
            this.nkZ = eVar;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(237359);
            this.nkZ.setFooterView(null);
            mVar.clear();
            if (this.BSH.BSC) {
                Context context = this.BSH.parent.getContext();
                p.g(context, "parent.context");
                mVar.d(0, context.getResources().getString(R.string.bq5));
            }
            if (this.BSH.BSE) {
                Context context2 = this.BSH.parent.getContext();
                p.g(context2, "parent.context");
                mVar.d(2, context2.getResources().getString(R.string.bq6));
            }
            if (this.BSH.BSD) {
                Context context3 = this.BSH.parent.getContext();
                p.g(context3, "parent.context");
                mVar.d(1, context3.getResources().getString(R.string.bq7));
            }
            AppMethodBeat.o(237359);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "i", "", "onMMMenuItemSelected"})
    static final class j implements o.g {
        final /* synthetic */ a BSH;
        final /* synthetic */ z.a BSK;
        final /* synthetic */ com.tencent.mm.ui.widget.a.e nkZ;

        j(a aVar, z.a aVar2, com.tencent.mm.ui.widget.a.e eVar) {
            this.BSH = aVar;
            this.BSK = aVar2;
            this.nkZ = eVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(237360);
            p.h(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case 0:
                    this.BSK.SYB = false;
                    a.e(this.BSH);
                    com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                    com.tencent.mm.plugin.recordvideo.d.c.HZ(1);
                    break;
                case 1:
                    this.BSK.SYB = false;
                    a.f(this.BSH);
                    com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                    com.tencent.mm.plugin.recordvideo.d.c.HZ(2);
                    break;
                case 2:
                    this.BSK.SYB = false;
                    a.g(this.BSH);
                    com.tencent.mm.plugin.recordvideo.d.c cVar3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                    com.tencent.mm.plugin.recordvideo.d.c.HZ(4);
                    break;
            }
            this.nkZ.bMo();
            AppMethodBeat.o(237360);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    static final class k implements e.b {
        final /* synthetic */ z.a BSK;

        k(z.a aVar) {
            this.BSK = aVar;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(237361);
            if (this.BSK.SYB) {
                com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.HZ(3);
            }
            AppMethodBeat.o(237361);
        }
    }

    private final void eKK() {
        String str;
        String str2 = null;
        AppMethodBeat.i(237363);
        com.tencent.mm.plugin.recordvideo.d.g gVar = com.tencent.mm.plugin.recordvideo.d.g.BXY;
        com.tencent.mm.plugin.recordvideo.d.g.VQ(3);
        com.tencent.mm.plugin.recordvideo.d.g gVar2 = com.tencent.mm.plugin.recordvideo.d.g.BXY;
        com.tencent.mm.plugin.recordvideo.d.g.ax(3, 1);
        Intent intent = new Intent();
        ((aj) com.tencent.mm.kernel.g.ah(aj.class)).fillContextIdToIntent(4, 5, 44, intent);
        aj ajVar = (aj) com.tencent.mm.kernel.g.ah(aj.class);
        Context context = this.parent.getContext();
        intent.putExtra("key_finder_sns_post_type", 2);
        intent.putExtra("key_finder_post_router", 6);
        intent.putExtra("key_finder_post_from", 6);
        com.tencent.mm.media.widget.camerarecordview.b.b bVar = this.BSx;
        if (bVar != null) {
            str = bVar.iqd;
        } else {
            str = null;
        }
        if (str != null) {
            com.tencent.mm.media.widget.camerarecordview.b.b bVar2 = this.BSx;
            if (bVar2 != null) {
                str2 = bVar2.iqd;
            }
        } else {
            com.tencent.mm.media.widget.camerarecordview.b.b bVar3 = this.BSx;
            if (bVar3 != null) {
                str2 = bVar3.iqh;
            }
        }
        intent.putExtra("key_finder_post_sns_video_path", str2);
        ajVar.enterFinderPostRouterUI(context, intent);
        AppMethodBeat.o(237363);
    }

    private final void eKL() {
        AppMethodBeat.i(237364);
        com.tencent.mm.plugin.recordvideo.e.i iVar = com.tencent.mm.plugin.recordvideo.e.i.Ciy;
        Context context = this.parent.getContext();
        p.g(context, "parent.context");
        boolean gQ = com.tencent.mm.plugin.recordvideo.e.i.gQ(context);
        com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_IS_CLICK_WESEE_BTN", 1);
        this.kvo = com.tencent.mm.ui.base.h.c(this.parent.getContext(), gQ ? getString(R.string.va) : getString(R.string.v9), "", getString(R.string.x_), getString(R.string.sz), new g(this, gQ), new h(this, gQ));
        AppMethodBeat.o(237364);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
    public static final class g implements DialogInterface.OnClickListener {
        final /* synthetic */ a BSH;
        final /* synthetic */ boolean BSJ;

        g(a aVar, boolean z) {
            this.BSH = aVar;
            this.BSJ = z;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            String str;
            String str2;
            AppMethodBeat.i(237357);
            if (this.BSH.kvo != null) {
                com.tencent.mm.ui.widget.a.d dVar = this.BSH.kvo;
                if (dVar == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.app.Dialog");
                    AppMethodBeat.o(237357);
                    throw tVar;
                } else if (dVar.isShowing()) {
                    com.tencent.mm.ui.widget.a.d dVar2 = this.BSH.kvo;
                    if (dVar2 != null) {
                        dVar2.dismiss();
                    }
                    Log.i("MicroMsg.EditCropVideoPlugin", "click ok dismiss dialog");
                }
            }
            Log.i("MicroMsg.EditCropVideoPlugin", "dialog ok isInstallWeSee:" + this.BSJ);
            com.tencent.mm.media.widget.camerarecordview.b.b bVar = this.BSH.BSx;
            if (bVar != null) {
                str = bVar.iqd;
            } else {
                str = null;
            }
            if (str != null) {
                com.tencent.mm.media.widget.camerarecordview.b.b bVar2 = this.BSH.BSx;
                str2 = bVar2 != null ? bVar2.iqd : null;
            } else {
                com.tencent.mm.media.widget.camerarecordview.b.b bVar3 = this.BSH.BSx;
                if (bVar3 != null) {
                    str2 = bVar3.iqh;
                } else {
                    str2 = null;
                }
            }
            if (this.BSJ) {
                com.tencent.mm.plugin.recordvideo.d.g gVar = com.tencent.mm.plugin.recordvideo.d.g.BXY;
                com.tencent.mm.plugin.recordvideo.d.g.VQ(2);
                com.tencent.mm.plugin.recordvideo.d.g gVar2 = com.tencent.mm.plugin.recordvideo.d.g.BXY;
                com.tencent.mm.plugin.recordvideo.d.g.ax(3, 1);
                com.tencent.mm.plugin.recordvideo.e.i iVar = com.tencent.mm.plugin.recordvideo.e.i.Ciy;
                Context context = this.BSH.parent.getContext();
                p.g(context, "parent.context");
                if (str2 == null) {
                    p.hyc();
                }
                p.h(context, "context");
                p.h(str2, "videoPath");
                s.a(context, new Intent(), com.tencent.mm.plugin.recordvideo.e.i.Io(cl.aWz()), str2);
                com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.x("KEY_WESEE_DIALOG_OPERATION", 1);
                Intent intent = new Intent();
                Context context2 = this.BSH.parent.getContext();
                if (context2 == null) {
                    kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(237357);
                    throw tVar2;
                }
                ((Activity) context2).setResult(-2, intent);
                Context context3 = this.BSH.parent.getContext();
                if (context3 == null) {
                    kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(237357);
                    throw tVar3;
                }
                ((Activity) context3).finish();
                Log.d("MicroMsg.EditCropVideoPlugin", "set RESULT_VIDEO_FINISH");
                AppMethodBeat.o(237357);
                return;
            }
            WeSeeProvider.a aVar = WeSeeProvider.BME;
            String bfE = s.bfE(str2);
            p.g(bfE, "TakePhotoUtil.parseWeSeeUri(videoPath)");
            WeSeeProvider.a.bg(bfE, System.currentTimeMillis());
            com.tencent.mm.plugin.recordvideo.e.i iVar2 = com.tencent.mm.plugin.recordvideo.e.i.Ciy;
            Context context4 = this.BSH.parent.getContext();
            p.g(context4, "parent.context");
            com.tencent.mm.plugin.recordvideo.e.i.gR(context4);
            com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
            com.tencent.mm.plugin.recordvideo.d.c.x("KEY_WESEE_DIALOG_OPERATION", 3);
            AppMethodBeat.o(237357);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
    public static final class h implements DialogInterface.OnClickListener {
        final /* synthetic */ a BSH;
        final /* synthetic */ boolean BSJ;

        h(a aVar, boolean z) {
            this.BSH = aVar;
            this.BSJ = z;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(237358);
            if (this.BSJ) {
                com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.x("KEY_WESEE_DIALOG_OPERATION", 2);
            } else {
                com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.x("KEY_WESEE_DIALOG_OPERATION", 4);
            }
            Log.i("MicroMsg.EditCropVideoPlugin", "dialog cancel");
            if (this.BSH.kvo != null) {
                com.tencent.mm.ui.widget.a.d dVar = this.BSH.kvo;
                if (dVar == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.app.Dialog");
                    AppMethodBeat.o(237358);
                    throw tVar;
                } else if (dVar.isShowing()) {
                    com.tencent.mm.ui.widget.a.d dVar2 = this.BSH.kvo;
                    if (dVar2 != null) {
                        dVar2.dismiss();
                    }
                    Log.i("MicroMsg.EditCropVideoPlugin", "click no dismiss dialog");
                }
            }
            AppMethodBeat.o(237358);
        }
    }

    private final void eKM() {
        AppMethodBeat.i(237365);
        com.tencent.mm.plugin.recordvideo.e.a aVar = com.tencent.mm.plugin.recordvideo.e.a.ChV;
        Context context = this.parent.getContext();
        p.g(context, "parent.context");
        boolean G = com.tencent.mm.plugin.recordvideo.e.a.G(context, "com.tencent.phoenix", "A24DC0755072F64C480DC06DCD3412BF");
        this.BSy = com.tencent.mm.ui.base.h.c(this.parent.getContext(), G ? getString(R.string.uu) : getString(R.string.ut), "", getString(R.string.x_), getString(R.string.sz), new e(this, G), new f(this));
        AppMethodBeat.o(237365);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
    public static final class e implements DialogInterface.OnClickListener {
        final /* synthetic */ a BSH;
        final /* synthetic */ boolean BSI;

        e(a aVar, boolean z) {
            this.BSH = aVar;
            this.BSI = z;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            String str;
            String str2 = null;
            int i3 = 0;
            AppMethodBeat.i(237355);
            if (this.BSH.BSy != null) {
                com.tencent.mm.ui.widget.a.d dVar = this.BSH.BSy;
                if (dVar == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.app.Dialog");
                    AppMethodBeat.o(237355);
                    throw tVar;
                } else if (dVar.isShowing()) {
                    com.tencent.mm.ui.widget.a.d dVar2 = this.BSH.BSy;
                    if (dVar2 != null) {
                        dVar2.dismiss();
                    }
                    Log.i("MicroMsg.EditCropVideoPlugin", "click ok dismiss dialog");
                }
            }
            Log.i("MicroMsg.EditCropVideoPlugin", "dialog ok isInstall:" + this.BSI);
            com.tencent.mm.media.widget.camerarecordview.b.b bVar = this.BSH.BSx;
            if (bVar != null) {
                str = bVar.iqd;
            } else {
                str = null;
            }
            if (str != null) {
                com.tencent.mm.media.widget.camerarecordview.b.b bVar2 = this.BSH.BSx;
                if (bVar2 != null) {
                    str2 = bVar2.iqd;
                }
            } else {
                com.tencent.mm.media.widget.camerarecordview.b.b bVar3 = this.BSH.BSx;
                if (bVar3 != null) {
                    str2 = bVar3.iqh;
                }
            }
            if (this.BSI) {
                com.tencent.mm.plugin.recordvideo.e.h hVar = com.tencent.mm.plugin.recordvideo.e.h.Cix;
                if (str2 == null) {
                    p.hyc();
                }
                com.tencent.mm.plugin.recordvideo.e.g gVar = com.tencent.mm.plugin.recordvideo.e.g.Ciw;
                int eMQ = com.tencent.mm.plugin.recordvideo.e.g.eMQ();
                RecordConfigProvider recordConfigProvider = this.BSH.wdm;
                if (recordConfigProvider == null) {
                    p.hyc();
                }
                VideoTransPara videoTransPara = recordConfigProvider.BOm;
                int i4 = videoTransPara != null ? videoTransPara.videoBitrate : 0;
                RecordConfigProvider recordConfigProvider2 = this.BSH.wdm;
                if (recordConfigProvider2 == null) {
                    p.hyc();
                }
                VideoTransPara videoTransPara2 = recordConfigProvider2.BOm;
                int i5 = videoTransPara2 != null ? videoTransPara2.width : 0;
                RecordConfigProvider recordConfigProvider3 = this.BSH.wdm;
                if (recordConfigProvider3 == null) {
                    p.hyc();
                }
                VideoTransPara videoTransPara3 = recordConfigProvider3.BOm;
                if (videoTransPara3 != null) {
                    i3 = videoTransPara3.height;
                }
                Intent b2 = com.tencent.mm.plugin.recordvideo.e.h.b("moments", str2, eMQ, i4, i5, i3);
                com.tencent.mm.plugin.recordvideo.e.h hVar2 = com.tencent.mm.plugin.recordvideo.e.h.Cix;
                Context context = this.BSH.parent.getContext();
                p.g(context, "parent.context");
                com.tencent.mm.plugin.recordvideo.e.h.ao(context, b2);
                Intent intent = new Intent();
                Context context2 = this.BSH.parent.getContext();
                if (context2 == null) {
                    kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(237355);
                    throw tVar2;
                }
                ((Activity) context2).setResult(-2, intent);
                Context context3 = this.BSH.parent.getContext();
                if (context3 == null) {
                    kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(237355);
                    throw tVar3;
                }
                ((Activity) context3).finish();
                Log.d("MicroMsg.EditCropVideoPlugin", "set RESULT_VIDEO_FINISH");
                AppMethodBeat.o(237355);
                return;
            }
            com.tencent.mm.plugin.recordvideo.e.a aVar = com.tencent.mm.plugin.recordvideo.e.a.ChV;
            Context context4 = this.BSH.parent.getContext();
            p.g(context4, "parent.context");
            StringBuilder sb = new StringBuilder();
            com.tencent.mm.plugin.recordvideo.e.g gVar2 = com.tencent.mm.plugin.recordvideo.e.g.Ciw;
            com.tencent.mm.plugin.recordvideo.e.a.bt(context4, sb.append(com.tencent.mm.plugin.recordvideo.e.g.eMR()).append("moments1").toString());
            AppMethodBeat.o(237355);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
    public static final class f implements DialogInterface.OnClickListener {
        final /* synthetic */ a BSH;

        f(a aVar) {
            this.BSH = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(237356);
            Log.i("MicroMsg.EditCropVideoPlugin", "dialog cancel");
            if (this.BSH.BSy != null) {
                com.tencent.mm.ui.widget.a.d dVar = this.BSH.BSy;
                if (dVar == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.app.Dialog");
                    AppMethodBeat.o(237356);
                    throw tVar;
                } else if (dVar.isShowing()) {
                    com.tencent.mm.ui.widget.a.d dVar2 = this.BSH.BSy;
                    if (dVar2 != null) {
                        dVar2.dismiss();
                    }
                    Log.i("MicroMsg.EditCropVideoPlugin", "click no dismiss dialog");
                }
            }
            AppMethodBeat.o(237356);
        }
    }

    private final String getString(int i2) {
        AppMethodBeat.i(75691);
        if (this.parent.getContext() != null) {
            String string = this.parent.getContext().getString(i2);
            p.g(string, "parent.context.getString(resId)");
            AppMethodBeat.o(75691);
            return string;
        }
        AppMethodBeat.o(75691);
        return "";
    }

    private static int hW(int i2, int i3) {
        return i2 > i3 ? i3 : i2;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.c.b
    public final void W(float f2, float f3) {
        AppMethodBeat.i(75692);
        Log.d("MicroMsg.EditCropVideoPlugin", "onRecyclerChanged : " + f2 + ' ' + f3);
        this.BSA = f2;
        this.BSB = f3;
        ae(f2, f3);
        AppMethodBeat.o(75692);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.c.b
    public final void X(float f2, float f3) {
        AppMethodBeat.i(75693);
        Log.d("MicroMsg.EditCropVideoPlugin", "onDown : " + f2 + ' ' + f3);
        d.b.a(this.wgr, d.c.BVr);
        AppMethodBeat.o(75693);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.c.b
    public final void Y(float f2, float f3) {
        AppMethodBeat.i(75694);
        Log.d("MicroMsg.EditCropVideoPlugin", "onUp : " + f2 + ' ' + f3);
        this.BSA = f2;
        this.BSB = f3;
        ae(f2, f3);
        AppMethodBeat.o(75694);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.c.b
    public final void Z(float f2, float f3) {
        AppMethodBeat.i(75695);
        Log.d("MicroMsg.EditCropVideoPlugin", "onMove : " + f2 + ' ' + f3);
        AppMethodBeat.o(75695);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(75696);
        this.BSr.setVisibility(i2);
        AppMethodBeat.o(75696);
    }

    private final void ae(float f2, float f3) {
        float f4 = 0.0f;
        AppMethodBeat.i(75697);
        com.tencent.mm.media.widget.camerarecordview.b.b bVar = this.BSx;
        if (bVar != null) {
            int i2 = bVar.iqg - bVar.dvv;
            float f5 = (f3 - f2) * ((float) i2);
            RecordConfigProvider recordConfigProvider = this.wdm;
            if (recordConfigProvider == null) {
                p.hyc();
            }
            int i3 = recordConfigProvider.BOv + 250;
            com.tencent.mm.media.widget.camerarecordview.b.b bVar2 = this.BSx;
            if (bVar2 == null) {
                p.hyc();
            }
            float hW = f5 - ((float) hW(i3, bVar2.iqg));
            if (hW >= 0.0f) {
                f4 = hW;
            }
            int round = Math.round(((float) i2) * f3) - (((int) f4) / 2);
            Bundle bundle = new Bundle();
            bundle.putInt("EDIT_CROP_VIDEO_LENGTH_START_TIME_INT", Math.round(((float) i2) * f2) + (((int) f4) / 2));
            bundle.putInt("EDIT_CROP_VIDEO_LENGTH_END_TIME_INT", round);
            this.wgr.a(d.c.BVp, bundle);
            AppMethodBeat.o(75697);
            return;
        }
        AppMethodBeat.o(75697);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        AppMethodBeat.i(75698);
        ViewGroup viewGroup = this.BSt;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        if (this.BSs.getVisibility() == 0) {
            d.b.a(this.wgr, d.c.BVt);
            this.BSs.animate().alpha(0.0f).setDuration(100).setListener(new b(this));
            AppMethodBeat.o(75698);
            return true;
        }
        AppMethodBeat.o(75698);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin$onBackPress$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-recordvideo_release"})
    public static final class b extends AnimatorListenerAdapter {
        final /* synthetic */ a BSH;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(a aVar) {
            this.BSH = aVar;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(75684);
            p.h(animator, "animation");
            this.BSH.BSs.setVisibility(8);
            this.BSH.BSs.setAlpha(1.0f);
            AppMethodBeat.o(75684);
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
        AppMethodBeat.i(75699);
        this.iqd = "";
        this.BSs.release();
        AppMethodBeat.o(75699);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
        AppMethodBeat.i(75700);
        this.BSs.release();
        if (this.kvo != null) {
            com.tencent.mm.ui.widget.a.d dVar = this.kvo;
            if (dVar == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.app.Dialog");
                AppMethodBeat.o(75700);
                throw tVar;
            } else if (dVar.isShowing()) {
                com.tencent.mm.ui.widget.a.d dVar2 = this.kvo;
                if (dVar2 != null) {
                    dVar2.dismiss();
                }
                Log.i("MicroMsg.EditCropVideoPlugin", "release dismiss dialog");
            }
        }
        AppMethodBeat.o(75700);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final String name() {
        return "plugin_video_crop";
    }

    public final void tg(boolean z) {
        String str;
        RecordConfigProvider recordConfigProvider;
        boolean z2;
        boolean z3;
        String string;
        com.tencent.mm.media.widget.camerarecordview.b.b bVar;
        int i2;
        AppMethodBeat.i(75689);
        String str2 = this.iqd;
        com.tencent.mm.media.widget.camerarecordview.b.b bVar2 = this.BSx;
        if (bVar2 != null) {
            str = bVar2.iqd;
        } else {
            str = null;
        }
        if ((!p.j(str2, str)) && (bVar = this.BSx) != null) {
            this.iqd = bVar.iqd;
            EditVideoSeekBarView editVideoSeekBarView = this.BSs;
            String str3 = bVar.iqd;
            RecordConfigProvider recordConfigProvider2 = this.wdm;
            if (recordConfigProvider2 == null) {
                p.hyc();
            }
            int hW = hW(recordConfigProvider2.BOv, bVar.iqg);
            RecordConfigProvider recordConfigProvider3 = this.wdm;
            if (recordConfigProvider3 == null) {
                p.hyc();
            }
            VideoTransPara videoTransPara = recordConfigProvider3.BOm;
            if (videoTransPara != null) {
                i2 = videoTransPara.minDuration;
            } else {
                i2 = 0;
            }
            p.h(str3, "path");
            if (!editVideoSeekBarView.hasInit) {
                editVideoSeekBarView.hasInit = true;
                editVideoSeekBarView.zDX.aFp(str3);
                VideoTransPara videoTransPara2 = new VideoTransPara();
                videoTransPara2.duration = hW / 1000;
                videoTransPara2.minDuration = i2;
                editVideoSeekBarView.zDX.setVideoTransPara(videoTransPara2);
                editVideoSeekBarView.zDX.setOnPreparedListener(EditVideoSeekBarView.b.BSM);
            }
            this.BSs.setThumbBarSeekListener(this);
            RecordConfigProvider recordConfigProvider4 = this.wdm;
            if (recordConfigProvider4 == null) {
                p.hyc();
            }
            this.BSB = (((float) hW(recordConfigProvider4.BOv, bVar.iqg)) * 1.0f) / ((float) bVar.iqg);
        }
        this.BSs.setVisibility(0);
        Log.d("MicroMsg.EditCropVideoPlugin", "forceCropVideo isForce: ".concat(String.valueOf(z)));
        Bundle bundle = new Bundle();
        if (z && (recordConfigProvider = this.wdm) != null && recordConfigProvider.scene == 2) {
            boolean z4 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_to_finder_enable, 1) == 1;
            boolean showPostEntry = ((aj) com.tencent.mm.kernel.g.ah(aj.class)).showPostEntry();
            boolean equals = TextUtils.equals(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_clip_page_weishi_promotion_entrance, AppEventsConstants.EVENT_PARAM_VALUE_NO), "1");
            boolean z5 = MMApplicationContext.getDefaultPreference().getBoolean("wesee_switch", false);
            com.tencent.mm.plugin.recordvideo.e.g gVar = com.tencent.mm.plugin.recordvideo.e.g.Ciw;
            this.BSE = com.tencent.mm.plugin.recordvideo.e.g.eMP();
            if (!z4 || !showPostEntry) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.BSC = z2;
            if (equals || z5) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.BSD = z3;
            Log.i("MicroMsg.EditCropVideoPlugin", "sns2FinderEnable:" + z4 + ", showPostEntry:" + showPostEntry + ", showWeseeEntry:" + equals + ", weseeCommandSwitch:" + z5);
            if (this.BSC) {
                this.BSF++;
            }
            if (this.BSD) {
                this.BSF++;
            }
            if (this.BSE) {
                this.BSF++;
            }
            if (this.BSF >= 2) {
                TextView textView = this.BSw;
                if (textView != null) {
                    Context context = this.parent.getContext();
                    p.g(context, "parent.context");
                    textView.setText(context.getResources().getString(R.string.bq4));
                }
                ImageView imageView = this.BSu;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                eKJ();
                if (this.BSD) {
                    bundle.putBoolean("EDIT_CROP_VIDEO_SHOW_WESEE_SWITCH_BOOLEAN", true);
                    WeSeeProvider.a aVar = WeSeeProvider.BME;
                    WeSeeProvider.a.delete();
                    com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                    com.tencent.mm.plugin.recordvideo.d.c.x("KEY_IS_SHOW_WESEE_BTN", 1);
                }
                com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.HY(3);
            } else if (this.BSC || this.BSE) {
                TextView textView2 = this.BSw;
                if (textView2 != null) {
                    if (this.BSC) {
                        Context context2 = this.parent.getContext();
                        p.g(context2, "parent.context");
                        string = context2.getResources().getString(R.string.bpx);
                    } else {
                        Context context3 = this.parent.getContext();
                        p.g(context3, "parent.context");
                        string = context3.getResources().getString(R.string.bq9);
                    }
                    textView2.setText(string);
                }
                ImageView imageView2 = this.BSu;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
                eKJ();
                com.tencent.mm.plugin.recordvideo.d.c cVar3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.x("KEY_IS_SHOW_WESEE_BTN", 2);
                com.tencent.mm.plugin.recordvideo.d.c cVar4 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.HY(3);
            } else if (this.BSD) {
                TextView textView3 = this.BSw;
                if (textView3 != null) {
                    Context context4 = this.parent.getContext();
                    p.g(context4, "parent.context");
                    textView3.setText(context4.getResources().getString(R.string.bqb));
                }
                ImageView imageView3 = this.BSu;
                if (imageView3 != null) {
                    imageView3.setVisibility(0);
                }
                bundle.putBoolean("EDIT_CROP_VIDEO_SHOW_WESEE_SWITCH_BOOLEAN", true);
                eKJ();
                WeSeeProvider.a aVar2 = WeSeeProvider.BME;
                WeSeeProvider.a.delete();
                com.tencent.mm.plugin.recordvideo.d.c cVar5 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.x("KEY_IS_SHOW_WESEE_BTN", 1);
                com.tencent.mm.plugin.recordvideo.d.c cVar6 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.HY(2);
            } else {
                com.tencent.mm.plugin.recordvideo.d.c cVar7 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.HY(1);
            }
            com.tencent.mm.plugin.recordvideo.e.i iVar = com.tencent.mm.plugin.recordvideo.e.i.Ciy;
            Context context5 = this.parent.getContext();
            p.g(context5, "parent.context");
            if (com.tencent.mm.plugin.recordvideo.e.i.gQ(context5)) {
                com.tencent.mm.plugin.recordvideo.d.c cVar8 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.x("KEY_IS_INSTALL_WESEE", 1);
            } else {
                com.tencent.mm.plugin.recordvideo.d.c cVar9 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.x("KEY_IS_INSTALL_WESEE", 2);
            }
            com.tencent.mm.plugin.recordvideo.d.c cVar10 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
            com.tencent.mm.plugin.recordvideo.d.c.x("KEY_IS_CLICK_WESEE_BTN", 2);
        }
        this.wgr.a(d.c.BVn, bundle);
        AppMethodBeat.o(75689);
    }
}
