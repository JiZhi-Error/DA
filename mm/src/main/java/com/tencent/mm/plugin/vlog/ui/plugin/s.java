package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.ui.plugin.e;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.videocomposition.c;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 Q2\u00020\u00012\u00020\u0002:\u0001QB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0017H\u0002J\u000e\u0010C\u001a\u00020A2\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010D\u001a\u00020AH\u0002J\u0006\u0010E\u001a\u00020AJ\u0006\u0010F\u001a\u00020\u0017J\u0006\u0010G\u001a\u00020\u0017J\u0006\u00101\u001a\u00020\u0017J\u000e\u00101\u001a\u00020A2\u0006\u0010H\u001a\u00020\u0017J\b\u0010I\u001a\u00020\u0017H\u0016J\"\u0010J\u001a\u00020A2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u0017H\u0016J\u000e\u0010N\u001a\u00020A2\u0006\u0010=\u001a\u00020>J\u0006\u0010O\u001a\u00020AJ\u0006\u0010P\u001a\u00020AR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR#\u0010\u0012\u001a\n \u0013*\u0004\u0018\u00010\r0\r8BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0014\u0010\u000fR\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R#\u0010\u0018\u001a\n \u0013*\u0004\u0018\u00010\u00190\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001a\u0010\u001bR#\u0010\u001d\u001a\n \u0013*\u0004\u0018\u00010\u001e0\u001e8BX\u0002¢\u0006\f\n\u0004\b!\u0010\u0011\u001a\u0004\b\u001f\u0010 R\u000e\u0010\"\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R#\u0010$\u001a\n \u0013*\u0004\u0018\u00010\u001e0\u001e8BX\u0002¢\u0006\f\n\u0004\b&\u0010\u0011\u001a\u0004\b%\u0010 R\u001b\u0010'\u001a\u00020(8BX\u0002¢\u0006\f\n\u0004\b+\u0010\u0011\u001a\u0004\b)\u0010*R$\u0010-\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u00178B@BX\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u00101\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0016\u00105\u001a\n \u0013*\u0004\u0018\u00010606X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0010\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020<X\u0004¢\u0006\u0002\n\u0000¨\u0006R"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiEditPostPreviewPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewUpdateCallback;", "layout", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "context", "Landroid/content/Context;", "dialogView", "Landroid/view/View;", "getDialogView", "()Landroid/view/View;", "dialogView$delegate", "Lkotlin/Lazy;", "editorControlIconsContainer", "kotlin.jvm.PlatformType", "getEditorControlIconsContainer", "editorControlIconsContainer$delegate", "enable", "", "finishBtn", "Landroid/widget/Button;", "getFinishBtn", "()Landroid/widget/Button;", "finishBtn$delegate", "fullScreenThumbView", "Landroid/widget/ImageView;", "getFullScreenThumbView", "()Landroid/widget/ImageView;", "fullScreenThumbView$delegate", "halfScreenHeader", "halfScreenSelectBtn", "halfScreenThumbView", "getHalfScreenThumbView", "halfScreenThumbView$delegate", "helpDialog", "Landroid/support/design/widget/BottomSheetDialog;", "getHelpDialog", "()Landroid/support/design/widget/BottomSheetDialog;", "helpDialog$delegate", "value", "isFirstEnter", "()Z", "setFirstEnter", "(Z)V", "isNeedCropFullScreen", "isPreviewHalfScreen", "getLayout", "()Landroid/view/ViewGroup;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "thumbFetcher", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "thumbHeight", "", "thumbPath", "", "thumbWidth", "changePreviewMode", "", "halfScreen", "enablePreview", "ensureThumb", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "isEnablePreview", "isInHalfScreenMode", "need", "onBackPress", "onUpdate", "seekTo", "", "seekToOriginPosition", "onUpdateImage", "show", "showHelpDialogIfNeed", "Companion", "plugin-vlog_release"})
public final class s implements t, e.d {
    public static final a GHT = new a((byte) 0);
    public boolean GGS;
    private final View GHL;
    private final View GHM;
    private final kotlin.f GHN;
    private final kotlin.f GHO;
    private final kotlin.f GHP;
    private final kotlin.f GHQ;
    public boolean GHR;
    private final kotlin.f GHS;
    private ac GxA;
    private final MultiProcessMMKV cQe = MultiProcessMMKV.getMMKV("MultiEditPostPreviewPlugin");
    private final Context context;
    private boolean enable;
    private final int thumbHeight;
    public String thumbPath;
    private final int thumbWidth;
    private final kotlin.f vJA;
    private com.tencent.mm.videocomposition.g vNj;
    final ViewGroup wgq;
    private final com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;

    static {
        AppMethodBeat.i(191381);
        AppMethodBeat.o(191381);
    }

    private final View fDs() {
        AppMethodBeat.i(191370);
        View view = (View) this.GHN.getValue();
        AppMethodBeat.o(191370);
        return view;
    }

    private final Button fDt() {
        AppMethodBeat.i(191371);
        Button button = (Button) this.vJA.getValue();
        AppMethodBeat.o(191371);
        return button;
    }

    private final ImageView fDu() {
        AppMethodBeat.i(191372);
        ImageView imageView = (ImageView) this.GHP.getValue();
        AppMethodBeat.o(191372);
        return imageView;
    }

    private final ImageView fDv() {
        AppMethodBeat.i(191373);
        ImageView imageView = (ImageView) this.GHQ.getValue();
        AppMethodBeat.o(191373);
        return imageView;
    }

    private final android.support.design.widget.a fDw() {
        AppMethodBeat.i(191374);
        android.support.design.widget.a aVar = (android.support.design.widget.a) this.GHS.getValue();
        AppMethodBeat.o(191374);
        return aVar;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "thumb", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPostPreviewPlugin$ensureThumb$2$1"})
    public static final class d extends q implements m<Long, Bitmap, x> {
        final /* synthetic */ s GHU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(s sVar) {
            super(2);
            this.GHU = sVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Long l, Bitmap bitmap) {
            AppMethodBeat.i(191362);
            l.longValue();
            Bitmap bitmap2 = bitmap;
            s.a(this.GHU).setImageBitmap(bitmap2);
            s.b(this.GHU).setImageBitmap(bitmap2);
            x xVar = x.SXb;
            AppMethodBeat.o(191362);
            return xVar;
        }
    }

    public s(ViewGroup viewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar) {
        p.h(viewGroup, "layout");
        p.h(dVar, "status");
        AppMethodBeat.i(191380);
        this.wgq = viewGroup;
        this.wgr = dVar;
        Context context2 = this.wgq.getContext();
        p.g(context2, "layout.context");
        this.context = context2;
        View findViewById = this.wgq.findViewById(R.id.dn2);
        p.g(findViewById, "layout.findViewById(R.id.half_screen_select_btn)");
        this.GHL = findViewById;
        View findViewById2 = this.wgq.findViewById(R.id.dmy);
        p.g(findViewById2, "layout.findViewById(R.id.half_screen_header)");
        this.GHM = findViewById2;
        this.GHN = kotlin.g.ah(new c(this));
        this.vJA = kotlin.g.ah(new e(this));
        this.GHO = kotlin.g.ah(new b(this));
        this.GHP = kotlin.g.ah(new g(this));
        this.GHQ = kotlin.g.ah(new f(this));
        this.thumbWidth = com.tencent.mm.cb.a.aG(this.context, R.dimen.bx);
        this.thumbHeight = com.tencent.mm.cb.a.aG(this.context, R.dimen.c8);
        this.GHS = kotlin.g.ah(new h(this));
        this.GHL.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.s.AnonymousClass1 */
            final /* synthetic */ s GHU;

            {
                this.GHU = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(191358);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPostPreviewPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                s.a(this.GHU, !this.GHU.GGS);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPostPreviewPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(191358);
            }
        });
        this.GHM.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.s.AnonymousClass2 */
            final /* synthetic */ s GHU;

            {
                this.GHU = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(191359);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPostPreviewPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                s.f(this.GHU);
                s.g(this.GHU).show();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPostPreviewPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(191359);
            }
        });
        AppMethodBeat.o(191380);
    }

    public static final /* synthetic */ ImageView a(s sVar) {
        AppMethodBeat.i(191383);
        ImageView fDu = sVar.fDu();
        AppMethodBeat.o(191383);
        return fDu;
    }

    public static final /* synthetic */ void a(s sVar, boolean z) {
        AppMethodBeat.i(191386);
        sVar.wG(z);
        AppMethodBeat.o(191386);
    }

    public static final /* synthetic */ ImageView b(s sVar) {
        AppMethodBeat.i(191384);
        ImageView fDv = sVar.fDv();
        AppMethodBeat.o(191384);
        return fDv;
    }

    public static final /* synthetic */ void f(s sVar) {
        AppMethodBeat.i(191387);
        sVar.fDx();
        AppMethodBeat.o(191387);
    }

    public static final /* synthetic */ android.support.design.widget.a g(s sVar) {
        AppMethodBeat.i(191388);
        android.support.design.widget.a fDw = sVar.fDw();
        AppMethodBeat.o(191388);
        return fDw;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void aSs() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final String name() {
        return null;
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
        AppMethodBeat.i(191382);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(191382);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiEditPostPreviewPlugin$Companion;", "", "()V", "PREVIEW_MODE_FULL", "", "PREVIEW_MODE_HALF", "PREVIEW_MODE_LOCK", "PREVIEW_MODE_WIDE_VIDEO", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private final boolean fDq() {
        AppMethodBeat.i(191368);
        boolean z = this.cQe.getBoolean("isFirstEnter", false);
        AppMethodBeat.o(191368);
        return z;
    }

    private final void fDr() {
        AppMethodBeat.i(191369);
        this.cQe.putBoolean("isFirstEnter", true);
        AppMethodBeat.o(191369);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/support/design/widget/BottomSheetDialog;", "invoke"})
    static final class h extends q implements kotlin.g.a.a<android.support.design.widget.a> {
        final /* synthetic */ s GHU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(s sVar) {
            super(0);
            this.GHU = sVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class a implements View.OnClickListener {
            final /* synthetic */ android.support.design.widget.a GHV;

            a(android.support.design.widget.a aVar) {
                this.GHV = aVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(191366);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPostPreviewPlugin$helpDialog$2$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.GHV.hide();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MultiEditPostPreviewPlugin$helpDialog$2$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(191366);
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ android.support.design.widget.a invoke() {
            AppMethodBeat.i(191367);
            android.support.design.widget.a aVar = new android.support.design.widget.a(this.GHU.context);
            s.d(this.GHU).findViewById(R.id.dp6).setOnClickListener(new a(aVar));
            aVar.setContentView(s.d(this.GHU));
            AppMethodBeat.o(191367);
            return aVar;
        }
    }

    public final void wF(boolean z) {
        AppMethodBeat.i(191375);
        this.enable = z;
        if (z) {
            this.GHL.setVisibility(0);
            AppMethodBeat.o(191375);
            return;
        }
        this.GHL.setVisibility(8);
        AppMethodBeat.o(191375);
    }

    public final void wG(boolean z) {
        AppMethodBeat.i(191376);
        this.GGS = z;
        if (this.GGS) {
            this.GHM.setVisibility(0);
            this.GHL.setVisibility(8);
            View fDs = fDs();
            p.g(fDs, "editorControlIconsContainer");
            fDs.setVisibility(8);
            Button fDt = fDt();
            p.g(fDt, "finishBtn");
            fDt.setText(this.context.getString(R.string.x_));
        } else {
            this.GHM.setVisibility(8);
            this.GHL.setVisibility(0);
            View fDs2 = fDs();
            p.g(fDs2, "editorControlIconsContainer");
            fDs2.setVisibility(0);
            Button fDt2 = fDt();
            p.g(fDt2, "finishBtn");
            fDt2.setText(this.context.getString(R.string.x5));
        }
        com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar = this.wgr;
        d.c cVar = d.c.BVA;
        Bundle bundle = new Bundle();
        bundle.putInt("PARAM_1_INT", this.GGS ? 2 : 1);
        dVar.a(cVar, bundle);
        AppMethodBeat.o(191376);
    }

    private final void fDx() {
        Bitmap dZ;
        float f2;
        AppMethodBeat.i(191377);
        String str = this.thumbPath;
        if (!(str == null || (dZ = com.tencent.mm.plugin.gallery.a.a.dZ(com.tencent.mm.vfs.s.k(this.thumbPath, false), Math.max(this.thumbWidth, this.thumbHeight))) == null)) {
            try {
                int l = new android.support.e.a(com.tencent.mm.vfs.s.openRead(str)).l(android.support.e.a.TAG_ORIENTATION);
                Matrix matrix = new Matrix();
                switch (l) {
                    case 3:
                        f2 = 180.0f;
                        break;
                    case 4:
                    case 5:
                    case 7:
                    default:
                        f2 = 0.0f;
                        break;
                    case 6:
                        f2 = 90.0f;
                        break;
                    case 8:
                        f2 = 270.0f;
                        break;
                }
                matrix.postRotate(f2);
                Bitmap createBitmap = Bitmap.createBitmap(dZ, 0, 0, dZ.getWidth(), dZ.getHeight(), matrix, true);
                fDu().setImageBitmap(createBitmap);
                fDv().setImageBitmap(createBitmap);
            } catch (Exception e2) {
                Log.e("MicroMsg.MultiEditPostPreviewPlugin", "cannot decode thumbnail from " + this.thumbPath + ", " + e2.getLocalizedMessage());
            }
        }
        ac acVar = this.GxA;
        if (acVar != null) {
            com.tencent.mm.videocomposition.g gVar = this.vNj;
            if (gVar != null) {
                gVar.destroy();
            }
            c.a aVar = com.tencent.mm.videocomposition.c.RgU;
            this.vNj = c.a.b(((ad) j.ks(acVar.Gzn)).GzA);
            com.tencent.mm.videocomposition.g gVar2 = this.vNj;
            if (gVar2 != null) {
                gVar2.setSize(this.thumbWidth, this.thumbHeight);
            }
            com.tencent.mm.videocomposition.g gVar3 = this.vNj;
            if (gVar3 != null) {
                gVar3.b(j.listOf((Object) 0L), new d(this));
                AppMethodBeat.o(191377);
                return;
            }
            AppMethodBeat.o(191377);
            return;
        }
        AppMethodBeat.o(191377);
    }

    public final void fDy() {
        AppMethodBeat.i(191378);
        if (!fDq() && this.enable) {
            fDr();
            fDx();
            fDw().show();
        }
        AppMethodBeat.o(191378);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        AppMethodBeat.i(191379);
        if (this.GGS) {
            wG(false);
            AppMethodBeat.o(191379);
            return true;
        }
        AppMethodBeat.o(191379);
        return false;
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.d
    public final void a(ac acVar, long j2, boolean z) {
        this.GxA = acVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c extends q implements kotlin.g.a.a<View> {
        final /* synthetic */ s GHU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(s sVar) {
            super(0);
            this.GHU = sVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(191361);
            View findViewById = this.GHU.wgq.findViewById(R.id.bx3);
            AppMethodBeat.o(191361);
            return findViewById;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e extends q implements kotlin.g.a.a<Button> {
        final /* synthetic */ s GHU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(s sVar) {
            super(0);
            this.GHU = sVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Button invoke() {
            AppMethodBeat.i(191363);
            Button button = (Button) this.GHU.wgq.findViewById(R.id.bxh);
            AppMethodBeat.o(191363);
            return button;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends q implements kotlin.g.a.a<View> {
        final /* synthetic */ s GHU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(s sVar) {
            super(0);
            this.GHU = sVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(191360);
            View inflate = View.inflate(this.GHU.context, R.layout.a0v, null);
            AppMethodBeat.o(191360);
            return inflate;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class g extends q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ s GHU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(s sVar) {
            super(0);
            this.GHU = sVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(191365);
            ImageView imageView = (ImageView) s.d(this.GHU).findViewById(R.id.dn0);
            AppMethodBeat.o(191365);
            return imageView;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class f extends q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ s GHU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(s sVar) {
            super(0);
            this.GHU = sVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(191364);
            ImageView imageView = (ImageView) s.d(this.GHU).findViewById(R.id.dby);
            AppMethodBeat.o(191364);
            return imageView;
        }
    }

    public static final /* synthetic */ View d(s sVar) {
        AppMethodBeat.i(191385);
        View view = (View) sVar.GHO.getValue();
        AppMethodBeat.o(191385);
        return view;
    }
}
