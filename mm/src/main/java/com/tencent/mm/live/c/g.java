package com.tencent.mm.live.c;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.live.b.a.n;
import com.tencent.mm.live.b.b.a;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.a.b;
import com.tencent.mm.live.d.e;
import com.tencent.mm.live.ui.dialog.LiveAnchorMicUserListView;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.bps;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.protocal.protobuf.cvb;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.u;
import com.tencent.smtt.sdk.WebView;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010 \u001a\u00020!J\b\u0010\"\u001a\u0004\u0018\u00010#J\b\u0010$\u001a\u00020!H\u0016J,\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\b\u0010)\u001a\u0004\u0018\u00010\t2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020.H\u0002J\u0006\u0010/\u001a\u00020!J\b\u00100\u001a\u00020!H\u0002J\u0006\u00101\u001a\u00020!J\u001a\u00102\u001a\u00020!2\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0006\u00107\u001a\u00020!J\b\u00108\u001a\u00020!H\u0016R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \f*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \f*\u0004\u0018\u00010\u00150\u0015X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \f*\u0004\u0018\u00010\u001a0\u001aX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n \f*\u0004\u0018\u00010\u001a0\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n \f*\u0004\u0018\u00010\u00150\u0015X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n \f*\u0004\u0018\u00010\u001f0\u001fX\u0004¢\u0006\u0002\n\u0000¨\u00069"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveAnchorMicPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "anchorMicIcon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "dialog", "Lcom/tencent/mm/live/ui/dialog/LiveMicDialog;", "liveAnchorMicView", "Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView;", "liveCallBtnRedDot", "liveCallLayout", "Landroid/widget/LinearLayout;", "liveCallingBtn", "liveCore", "Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "liveDescTv", "Landroid/widget/TextView;", "liveMicingDot", "liveStateTv", "stopCallLayout", "stopCallLayoutWrap", "Landroid/widget/RelativeLayout;", "dismissMicDialog", "", "getSelectUser", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "mount", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setMicBtnEnable", "enable", "", "showAudioMic", "showOutSideNormalView", "showVideoMic", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopMic", "unMount", "plugin-logic_release"})
public final class g extends a implements i {
    private final String TAG = "MicroMsg.LiveAnchorMicPlugin";
    final Context context;
    final LinearLayout hOD;
    private final LinearLayout hOE;
    private final ImageView hOF;
    private final ImageView hOG;
    final ImageView hOH;
    private final TextView hOI;
    private final TextView hOJ;
    final ImageView hOK;
    final RelativeLayout hOL;
    public final LiveAnchorMicUserListView hOM;
    public final com.tencent.mm.live.ui.dialog.a hON;
    private com.tencent.mm.live.core.core.a.b hOO;
    final b hOp;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "invoke"})
    static final class a extends q implements kotlin.g.a.b<a.C0371a, Boolean> {
        final /* synthetic */ cvb hOQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(cvb cvb) {
            super(1);
            this.hOQ = cvb;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(a.C0371a aVar) {
            AppMethodBeat.i(207909);
            a.C0371a aVar2 = aVar;
            p.h(aVar2, LocaleUtil.ITALIAN);
            Boolean valueOf = Boolean.valueOf(Util.isEqual(aVar2.hFJ, this.hOQ.MnR));
            AppMethodBeat.o(207909);
            return valueOf;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(207919);
        this.hOp = bVar;
        this.context = viewGroup.getContext();
        this.hOD = (LinearLayout) viewGroup.findViewById(R.id.el8);
        this.hOE = (LinearLayout) viewGroup.findViewById(R.id.ef_);
        this.hOF = (ImageView) viewGroup.findViewById(R.id.el7);
        this.hOG = (ImageView) viewGroup.findViewById(R.id.ef6);
        this.hOH = (ImageView) viewGroup.findViewById(R.id.ela);
        this.hOI = (TextView) viewGroup.findViewById(R.id.el9);
        this.hOJ = (TextView) viewGroup.findViewById(R.id.ejq);
        this.hOK = (ImageView) viewGroup.findViewById(R.id.ef7);
        this.hOL = (RelativeLayout) viewGroup.findViewById(R.id.efa);
        Context context2 = viewGroup.getContext();
        p.g(context2, "root.context");
        this.hOM = new LiveAnchorMicUserListView(context2);
        Context context3 = viewGroup.getContext();
        p.g(context3, "root.context");
        this.hON = new com.tencent.mm.live.ui.dialog.a(context3);
        b.a aVar = com.tencent.mm.live.core.core.a.b.hyv;
        viewGroup.getContext();
        this.hOO = b.a.aDo();
        this.hON.setContentView(this.hOM);
        this.hON.setOnDismissListener(new DialogInterface.OnDismissListener(this) {
            /* class com.tencent.mm.live.c.g.AnonymousClass1 */
            final /* synthetic */ g hOP;

            {
                this.hOP = r1;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(207900);
                x xVar = x.hJf;
                String aGm = x.aGm();
                x xVar2 = x.hJf;
                long j2 = x.aGr().hyH;
                x xVar3 = x.hJf;
                int size = x.aHa().hKT.size();
                boolean micPermission = this.hOP.hOM.getMicPermission();
                x xVar4 = x.hJf;
                e.a(aGm, j2, size, micPermission, x.aGX());
                AppMethodBeat.o(207900);
            }
        });
        this.hOM.setHideClickListener(new kotlin.g.a.a<kotlin.x>(this) {
            /* class com.tencent.mm.live.c.g.AnonymousClass2 */
            final /* synthetic */ g hOP;

            {
                this.hOP = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                AppMethodBeat.i(207901);
                this.hOP.hON.dismiss();
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(207901);
                return xVar;
            }
        });
        this.hOM.setCallMicListener(new m<Boolean, a.C0371a, kotlin.x>(this) {
            /* class com.tencent.mm.live.c.g.AnonymousClass3 */
            final /* synthetic */ g hOP;

            {
                this.hOP = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ kotlin.x invoke(Boolean bool, a.C0371a aVar) {
                String str;
                AppMethodBeat.i(207902);
                a.C0371a aVar2 = aVar;
                if (bool.booleanValue()) {
                    RelativeLayout relativeLayout = this.hOP.hOL;
                    p.g(relativeLayout, "stopCallLayoutWrap");
                    relativeLayout.setVisibility(0);
                    LinearLayout linearLayout = this.hOP.hOD;
                    p.g(linearLayout, "liveCallLayout");
                    linearLayout.setVisibility(4);
                    Bundle bundle = new Bundle();
                    if (aVar2 != null) {
                        str = aVar2.hFJ;
                    } else {
                        str = null;
                    }
                    bundle.putString("PARAM_LIVE_WXID", str);
                    this.hOP.hOp.statusChange(b.c.hLH, bundle);
                    x xVar = x.hJf;
                    x.zC(System.currentTimeMillis());
                    x xVar2 = x.hJf;
                    x xVar3 = x.hJf;
                    x.zD((long) x.aGr().LIa);
                } else {
                    this.hOP.aHr();
                    b.C0376b.a(this.hOP.hOp, b.c.hLL);
                    x xVar4 = x.hJf;
                    String aGm = x.aGm();
                    x xVar5 = x.hJf;
                    long j2 = x.aGr().hyH;
                    x xVar6 = x.hJf;
                    String aGt = x.aGt();
                    String aTY = z.aTY();
                    p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
                    x xVar7 = x.hJf;
                    e.a(aGm, j2, aGt, 9, 4, aTY, x.aGr().LIa);
                }
                kotlin.x xVar8 = kotlin.x.SXb;
                AppMethodBeat.o(207902);
                return xVar8;
            }
        });
        this.hOM.setMicPermissionListener(new kotlin.g.a.b<Boolean, kotlin.x>(this) {
            /* class com.tencent.mm.live.c.g.AnonymousClass4 */
            final /* synthetic */ g hOP;

            {
                this.hOP = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ kotlin.x invoke(Boolean bool) {
                AppMethodBeat.i(207903);
                this.hOP.eO(bool.booleanValue());
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(207903);
                return xVar;
            }
        });
        this.hOG.setImageDrawable(ar.e(viewGroup.getResources().getDrawable(R.raw.icons_filled_call), WebView.NIGHT_MODE_COLOR));
        this.hOF.setImageDrawable(ar.e(viewGroup.getResources().getDrawable(R.raw.icons_filled_call), -1));
        x xVar = x.hJf;
        x.aHa().hKM = new kotlin.g.a.b<Boolean, kotlin.x>(this) {
            /* class com.tencent.mm.live.c.g.AnonymousClass5 */
            final /* synthetic */ g hOP;

            {
                this.hOP = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ kotlin.x invoke(Boolean bool) {
                int i2;
                int i3 = 0;
                AppMethodBeat.i(207904);
                boolean booleanValue = bool.booleanValue();
                if (this.hOP.hON.isShowing()) {
                    this.hOP.hOM.aJf();
                } else {
                    ImageView imageView = this.hOP.hOK;
                    p.g(imageView, "liveMicingDot");
                    if (booleanValue) {
                        i2 = 0;
                    } else {
                        i2 = 4;
                    }
                    imageView.setVisibility(i2);
                    ImageView imageView2 = this.hOP.hOH;
                    p.g(imageView2, "liveCallBtnRedDot");
                    if (!booleanValue) {
                        i3 = 4;
                    }
                    imageView2.setVisibility(i3);
                }
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(207904);
                return xVar;
            }
        };
        x xVar2 = x.hJf;
        x.aHa().h(new kotlin.g.a.b<Boolean, kotlin.x>(this) {
            /* class com.tencent.mm.live.c.g.AnonymousClass6 */
            final /* synthetic */ g hOP;

            {
                this.hOP = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ kotlin.x invoke(Boolean bool) {
                AppMethodBeat.i(207905);
                bool.booleanValue();
                x xVar = x.hJf;
                x.aHa().aHk();
                u.makeText(this.hOP.context, com.tencent.mm.cb.a.aI(this.hOP.context, R.string.ej4), 0).show();
                this.hOP.aHr();
                this.hOP.hOM.aJc();
                this.hOP.hOM.aJd();
                this.hOP.hOM.aJf();
                kotlin.x xVar2 = kotlin.x.SXb;
                AppMethodBeat.o(207905);
                return xVar2;
            }
        });
        this.hOL.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.g.AnonymousClass7 */
            final /* synthetic */ g hOP;

            {
                this.hOP = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(207906);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveAnchorMicPlugin$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ImageView imageView = this.hOP.hOK;
                p.g(imageView, "liveMicingDot");
                imageView.setVisibility(4);
                ImageView imageView2 = this.hOP.hOH;
                p.g(imageView2, "liveCallBtnRedDot");
                imageView2.setVisibility(4);
                this.hOP.hOM.aJf();
                LiveAnchorMicUserListView.aJg();
                this.hOP.hON.show();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveAnchorMicPlugin$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(207906);
            }
        });
        this.hOF.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.g.AnonymousClass8 */
            final /* synthetic */ g hOP;

            {
                this.hOP = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(207907);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveAnchorMicPlugin$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ImageView imageView = this.hOP.hOK;
                p.g(imageView, "liveMicingDot");
                imageView.setVisibility(4);
                ImageView imageView2 = this.hOP.hOH;
                p.g(imageView2, "liveCallBtnRedDot");
                imageView2.setVisibility(4);
                this.hOP.hOM.aJf();
                LiveAnchorMicUserListView.aJg();
                this.hOP.hON.show();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveAnchorMicPlugin$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(207907);
            }
        });
        AppMethodBeat.o(207919);
    }

    /* access modifiers changed from: package-private */
    public final void aHr() {
        AppMethodBeat.i(207911);
        RelativeLayout relativeLayout = this.hOL;
        p.g(relativeLayout, "stopCallLayoutWrap");
        relativeLayout.setVisibility(8);
        LinearLayout linearLayout = this.hOD;
        p.g(linearLayout, "liveCallLayout");
        linearLayout.setVisibility(0);
        AppMethodBeat.o(207911);
    }

    /* access modifiers changed from: package-private */
    public final void eO(boolean z) {
        AppMethodBeat.i(207912);
        if (z) {
            ImageView imageView = this.hOF;
            Context context2 = this.hwr.getContext();
            p.g(context2, "root.context");
            imageView.setImageDrawable(ar.e(context2.getResources().getDrawable(R.raw.icons_filled_call), -1));
            TextView textView = this.hOI;
            p.g(textView, "liveDescTv");
            Context context3 = this.hwr.getContext();
            p.g(context3, "root.context");
            textView.setText(context3.getResources().getString(R.string.egn));
            AppMethodBeat.o(207912);
            return;
        }
        ImageView imageView2 = this.hOF;
        p.g(imageView2, "anchorMicIcon");
        Drawable drawable = imageView2.getDrawable();
        if (drawable != null) {
            drawable.clearColorFilter();
        }
        ImageView imageView3 = this.hOF;
        Context context4 = this.hwr.getContext();
        p.g(context4, "root.context");
        imageView3.setImageDrawable(context4.getResources().getDrawable(R.raw.icons_filled_mic_disable));
        TextView textView2 = this.hOI;
        p.g(textView2, "liveDescTv");
        Context context5 = this.hwr.getContext();
        p.g(context5, "root.context");
        textView2.setText(context5.getResources().getString(R.string.egn));
        AppMethodBeat.o(207912);
    }

    public final void aHs() {
        AppMethodBeat.i(207913);
        TextView textView = this.hOJ;
        p.g(textView, "liveStateTv");
        textView.setText(this.hwr.getContext().getString(R.string.eje));
        this.hOG.setImageDrawable(ar.e(this.hwr.getResources().getDrawable(R.raw.icons_filled_call), WebView.NIGHT_MODE_COLOR));
        AppMethodBeat.o(207913);
    }

    public final void aHt() {
        AppMethodBeat.i(207914);
        TextView textView = this.hOJ;
        p.g(textView, "liveStateTv");
        textView.setText(this.hwr.getContext().getString(R.string.ejd));
        this.hOG.setImageDrawable(ar.e(this.hwr.getResources().getDrawable(R.raw.icons_filled_video_call), WebView.NIGHT_MODE_COLOR));
        AppMethodBeat.o(207914);
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(207915);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (h.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                LiveAnchorMicUserListView.a(this.hOM);
                AppMethodBeat.o(207915);
                return;
            case 2:
                x xVar = x.hJf;
                x.qW(x.aGO() + 1);
                x xVar2 = x.hJf;
                x.re(x.aGX() + 1);
                LiveAnchorMicUserListView liveAnchorMicUserListView = this.hOM;
                liveAnchorMicUserListView.hVa = false;
                liveAnchorMicUserListView.hUX.notifyDataSetChanged();
                aHs();
                AppMethodBeat.o(207915);
                return;
            case 3:
                aHs();
                break;
            case 4:
                if (this.hOO.hAz.aDt()) {
                    LiveAnchorMicUserListView liveAnchorMicUserListView2 = this.hOM;
                    x xVar3 = x.hJf;
                    liveAnchorMicUserListView2.setMicUser(x.aHa().hKU);
                    RelativeLayout relativeLayout = this.hOL;
                    p.g(relativeLayout, "stopCallLayoutWrap");
                    relativeLayout.setVisibility(0);
                    LinearLayout linearLayout = this.hOD;
                    p.g(linearLayout, "liveCallLayout");
                    linearLayout.setVisibility(4);
                    aHt();
                    this.hOM.aJf();
                    AppMethodBeat.o(207915);
                    return;
                } else if (this.hOO.hAz.aDu()) {
                    LiveAnchorMicUserListView liveAnchorMicUserListView3 = this.hOM;
                    x xVar4 = x.hJf;
                    liveAnchorMicUserListView3.setMicUser(x.aHa().hKU);
                    RelativeLayout relativeLayout2 = this.hOL;
                    p.g(relativeLayout2, "stopCallLayoutWrap");
                    relativeLayout2.setVisibility(0);
                    LinearLayout linearLayout2 = this.hOD;
                    p.g(linearLayout2, "liveCallLayout");
                    linearLayout2.setVisibility(4);
                    aHs();
                    this.hOM.aJf();
                    AppMethodBeat.o(207915);
                    return;
                }
                break;
            default:
                AppMethodBeat.o(207915);
        }
        aHr();
        AppMethodBeat.o(207915);
    }

    @Override // com.tencent.mm.live.c.a
    public final void mount() {
        AppMethodBeat.i(207916);
        super.mount();
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(3806, this);
        AppMethodBeat.o(207916);
    }

    @Override // com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(207917);
        super.unMount();
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(3806, this);
        AppMethodBeat.o(207917);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        Integer num = null;
        AppMethodBeat.i(207918);
        Log.i(this.TAG, "errType:" + i2 + " errCode:" + i3);
        if (qVar instanceof com.tencent.mm.live.b.a.b) {
            if (i2 == 0 && i3 == 0) {
                civ aGr = ((com.tencent.mm.live.b.a.b) qVar).aGr();
                if (aGr != null) {
                    com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
                    com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", "mic permission default:" + aGr.Lml);
                    this.hOM.setDefaultMicState(aGr.Lml);
                    eO(aGr.Lml);
                    AppMethodBeat.o(207918);
                    return;
                }
                AppMethodBeat.o(207918);
                return;
            }
        } else if ((qVar instanceof n) && i2 == 0 && i3 == 0) {
            bps bps = ((n) qVar).hKl;
            LinkedList<cvb> linkedList = bps != null ? bps.LXL : null;
            String str2 = this.TAG;
            StringBuilder sb = new StringBuilder("userList.size:");
            if (linkedList != null) {
                num = Integer.valueOf(linkedList.size());
            }
            Log.i(str2, sb.append(num).toString());
            if (linkedList != null) {
                for (T t : linkedList) {
                    Log.i(this.TAG, "onlineMemberInfo.name:" + t.MnR + ", onlineMemberInfo.online:" + t.MAy);
                    if (!t.MAy) {
                        x xVar = x.hJf;
                        j.c((List) x.aHa().hKT, (kotlin.g.a.b) new a(t));
                    }
                }
            }
            d.h(new b(this));
        }
        AppMethodBeat.o(207918);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ g hOP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(g gVar) {
            super(0);
            this.hOP = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(207910);
            this.hOP.hOM.aJf();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(207910);
            return xVar;
        }
    }
}
