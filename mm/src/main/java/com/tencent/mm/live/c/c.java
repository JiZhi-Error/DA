package com.tencent.mm.live.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.d.a;
import com.tencent.mm.live.b.r;
import com.tencent.mm.live.b.u;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.d.d;
import com.tencent.mm.live.d.e;
import com.tencent.mm.live.ui.LiveUIC;
import com.tencent.mm.live.ui.LiveUID;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.protocal.protobuf.xf;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import java.util.Arrays;
import kotlin.g.a.b;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010%\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0013H\u0016J,\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\b\u0010-\u001a\u0004\u0018\u00010\t2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020'H\u0016J\b\u00101\u001a\u00020'H\u0002J\b\u00102\u001a\u00020'H\u0002J\b\u00103\u001a\u00020'H\u0002J\b\u00104\u001a\u00020'H\u0002J\b\u00105\u001a\u00020'H\u0016J\u000e\u00106\u001a\u00020'2\u0006\u00107\u001a\u000208J\u001a\u00109\u001a\u00020'2\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0017J\u0006\u0010>\u001a\u00020'J\u0006\u0010?\u001a\u00020'J\u0006\u0010@\u001a\u00020'J\b\u0010A\u001a\u00020'H\u0016J\u0010\u0010B\u001a\u00020'2\b\u0010C\u001a\u0004\u0018\u00010\tJ\u000e\u0010D\u001a\u00020'2\u0006\u0010E\u001a\u00020\tR\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveAfterPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "backBtn", "Landroid/widget/ImageView;", "commentCountTv", "Landroid/widget/TextView;", "commentGroup", "Landroid/widget/LinearLayout;", "finishBtn", "Landroid/widget/Button;", "isJumpForStartLive", "", "likeCountTv", "likeGroup", "liveDurationTv", "liveNameTv", "liveOverTv", "replayCheckGroup", "replayGroup", "rootContent", "toReplay", "visitorCountTv", "visitorGroup", "visitorTv", "isLiveAnchor", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "isReplayClosed", "isReplayDeprecated", "isReplayGenerated", "mount", "", "onBackPress", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pause", "replayClosed", "replayDeprecated", "replayGenerated", "replayGenerating", "resume", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchFinishMode", "switchReplayMode", "switchVisitorReplayMode", "unMount", "updateBgByUsername", ch.COL_USERNAME, "updateDataInfo", "title", "plugin-logic_release"})
public final class c extends a implements i {
    private final String TAG = "MicroMsg.LiveAfterPlugin";
    private final Button gwO;
    private final ImageView hNZ;
    private final TextView hOa;
    private final TextView hOb;
    private final TextView hOc;
    private final TextView hOd;
    private final TextView hOe;
    private final TextView hOf;
    private final TextView hOg;
    private final LinearLayout hOh;
    private final LinearLayout hOi;
    private final LinearLayout hOj;
    public final LinearLayout hOk;
    public final LinearLayout hOl;
    final RelativeLayout hOm;
    private boolean hOn;
    private boolean hOo;
    final b hOp;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/graphics/Bitmap;", "invoke"})
    static final class a extends q implements b<Bitmap, x> {
        final /* synthetic */ c hOt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(c cVar) {
            super(1);
            this.hOt = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Bitmap bitmap) {
            AppMethodBeat.i(207883);
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null) {
                RelativeLayout relativeLayout = this.hOt.hOm;
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                relativeLayout.setBackground(new BitmapDrawable(context.getResources(), bitmap2));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(207883);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(final RelativeLayout relativeLayout, b bVar) {
        super(relativeLayout, bVar);
        p.h(relativeLayout, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(207892);
        this.hOp = bVar;
        View findViewById = relativeLayout.findViewById(R.id.ed7);
        p.g(findViewById, "root.findViewById(R.id.live_after_back_btn)");
        this.hNZ = (ImageView) findViewById;
        View findViewById2 = relativeLayout.findViewById(R.id.ees);
        p.g(findViewById2, "root.findViewById(R.id.live_after_title)");
        this.hOa = (TextView) findViewById2;
        View findViewById3 = relativeLayout.findViewById(R.id.edy);
        p.g(findViewById3, "root.findViewById(R.id.live_after_over_tv)");
        this.hOb = (TextView) findViewById3;
        View findViewById4 = relativeLayout.findViewById(R.id.eev);
        p.g(findViewById4, "root.findViewById(R.id.live_after_visitor)");
        this.hOc = (TextView) findViewById4;
        View findViewById5 = relativeLayout.findViewById(R.id.eew);
        p.g(findViewById5, "root.findViewById(R.id.live_after_visitor_count)");
        this.hOd = (TextView) findViewById5;
        View findViewById6 = relativeLayout.findViewById(R.id.ed9);
        p.g(findViewById6, "root.findViewById(R.id.live_after_comment_count)");
        this.hOe = (TextView) findViewById6;
        View findViewById7 = relativeLayout.findViewById(R.id.edi);
        p.g(findViewById7, "root.findViewById(R.id.live_after_like_count)");
        this.hOf = (TextView) findViewById7;
        View findViewById8 = relativeLayout.findViewById(R.id.ed_);
        p.g(findViewById8, "root.findViewById(R.id.live_after_duration_tv)");
        this.hOg = (TextView) findViewById8;
        View findViewById9 = relativeLayout.findViewById(R.id.edf);
        p.g(findViewById9, "root.findViewById(R.id.l…after_info_visitor_group)");
        this.hOh = (LinearLayout) findViewById9;
        View findViewById10 = relativeLayout.findViewById(R.id.edb);
        p.g(findViewById10, "root.findViewById(R.id.l…after_info_comment_group)");
        this.hOi = (LinearLayout) findViewById10;
        View findViewById11 = relativeLayout.findViewById(R.id.edd);
        p.g(findViewById11, "root.findViewById(R.id.live_after_info_like_group)");
        this.hOj = (LinearLayout) findViewById11;
        View findViewById12 = relativeLayout.findViewById(R.id.ee3);
        p.g(findViewById12, "root.findViewById(R.id.live_after_replay_group)");
        this.hOk = (LinearLayout) findViewById12;
        View findViewById13 = relativeLayout.findViewById(R.id.ee6);
        p.g(findViewById13, "root.findViewById(R.id.l…fter_replay_switch_group)");
        this.hOl = (LinearLayout) findViewById13;
        View findViewById14 = relativeLayout.findViewById(R.id.eeu);
        p.g(findViewById14, "root.findViewById(R.id.live_after_ui_root_group)");
        this.hOm = (RelativeLayout) findViewById14;
        View findViewById15 = relativeLayout.findViewById(R.id.edz);
        p.g(findViewById15, "root.findViewById(R.id.live_after_replay_btn)");
        this.gwO = (Button) findViewById15;
        this.hOl.setVisibility(8);
        this.hOk.setVisibility(8);
        ImageView imageView = this.hNZ;
        Context context = relativeLayout.getContext();
        p.g(context, "root.context");
        imageView.setImageDrawable(ar.e(context.getResources().getDrawable(R.raw.icons_filled_back), -1));
        if (this.hOp.getLiveRole() == 0) {
            TextView textView = this.hOc;
            Context context2 = relativeLayout.getContext();
            p.g(context2, "root.context");
            textView.setText(context2.getResources().getString(R.string.ef6));
        } else {
            TextView textView2 = this.hOc;
            Context context3 = relativeLayout.getContext();
            p.g(context3, "root.context");
            textView2.setText(context3.getResources().getString(R.string.ef5));
            this.hOh.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.live.c.c.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(207874);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveAfterPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Intent intent = new Intent(relativeLayout.getContext(), LiveUIC.class);
                    Context context = relativeLayout.getContext();
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/live/plugin/LiveAfterPlugin$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/live/plugin/LiveAfterPlugin$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveAfterPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(207874);
                }
            });
        }
        this.hOi.setOnClickListener(AnonymousClass2.hOr);
        this.hOj.setOnClickListener(AnonymousClass3.hOs);
        this.hNZ.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.c.AnonymousClass4 */
            final /* synthetic */ c hOt;

            {
                this.hOt = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(207879);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveAfterPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.C0376b.a(this.hOt.hOp, b.c.hLD);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveAfterPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(207879);
            }
        });
        this.gwO.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.c.AnonymousClass5 */
            final /* synthetic */ c hOt;

            {
                this.hOt = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(207880);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveAfterPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.C0376b.a(this.hOt.hOp, b.c.hLD);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveAfterPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(207880);
            }
        });
        this.hOl.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.live.c.c.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(207881);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveAfterPlugin$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(relativeLayout.getContext(), LiveUID.class);
                intent.putExtra("FROM_SENCE", 2);
                Context context = relativeLayout.getContext();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/live/plugin/LiveAfterPlugin$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/live/plugin/LiveAfterPlugin$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                if (p.j(com.tencent.mm.live.b.x.aGt(), z.aTY())) {
                    d.aID();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveAfterPlugin$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(207881);
            }
        });
        AppMethodBeat.o(207892);
    }

    public final void a(LiveConfig liveConfig) {
        AppMethodBeat.i(207884);
        p.h(liveConfig, "config");
        this.hOn = liveConfig.aBC() == LiveConfig.hvV;
        AppMethodBeat.o(207884);
    }

    private void Hb(String str) {
        int aWB;
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(207885);
        p.h(str, "title");
        this.hOb.setText(str);
        TextView textView = this.hOa;
        Context context = this.hwr.getContext();
        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
        textView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(context, com.tencent.mm.live.b.x.aHe(), this.hOa.getTextSize()));
        TextView textView2 = this.hOd;
        com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
        textView2.setText(String.valueOf(com.tencent.mm.live.b.x.aGr().LIa));
        TextView textView3 = this.hOe;
        com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
        textView3.setText(String.valueOf(com.tencent.mm.live.b.x.aGr().MnH));
        TextView textView4 = this.hOf;
        com.tencent.mm.live.b.x xVar4 = com.tencent.mm.live.b.x.hJf;
        textView4.setText(String.valueOf(com.tencent.mm.live.b.x.aGr().LXG));
        com.tencent.mm.live.b.x xVar5 = com.tencent.mm.live.b.x.hJf;
        if (com.tencent.mm.live.b.x.aGr().Gaz > 0) {
            com.tencent.mm.live.b.x xVar6 = com.tencent.mm.live.b.x.hJf;
            if (com.tencent.mm.live.b.x.aGr().pSb > 0) {
                com.tencent.mm.live.b.x xVar7 = com.tencent.mm.live.b.x.hJf;
                aWB = com.tencent.mm.live.b.x.aGr().pSb;
            } else {
                aWB = cl.aWB();
            }
            com.tencent.mm.live.b.x xVar8 = com.tencent.mm.live.b.x.hJf;
            int i2 = aWB - com.tencent.mm.live.b.x.aGr().Gaz;
            u.a aVar = u.hIn;
            if (i2 >= 3600) {
                z = true;
            } else {
                z = false;
            }
            String a2 = u.a.a(i2, ":", z, false, false, 24);
            Log.i(this.TAG, "endTime:" + aWB + ", duration:" + i2 + ", formatDuration:" + a2);
            TextView textView5 = this.hOg;
            ae aeVar = ae.SYK;
            String string = this.hwr.getContext().getString(R.string.ees);
            p.g(string, "root.context.getString(R…ring.live_after_duration)");
            String format = String.format(string, Arrays.copyOf(new Object[]{a2}, 1));
            p.g(format, "java.lang.String.format(format, *args)");
            textView5.setText(format);
        }
        com.tencent.mm.live.b.x xVar9 = com.tencent.mm.live.b.x.hJf;
        civ aGr = com.tencent.mm.live.b.x.aGr();
        if (TextUtils.isEmpty(aGr.MnL) || !Util.isEqual(aGr.MnM, aGr.MnL)) {
            z2 = false;
        }
        if (z2) {
            aHq();
            AppMethodBeat.o(207885);
            return;
        }
        com.tencent.mm.live.b.x xVar10 = com.tencent.mm.live.b.x.hJf;
        if (com.tencent.mm.live.b.x.aGr().MnK) {
            aHq();
            AppMethodBeat.o(207885);
            return;
        }
        this.hOl.setVisibility(8);
        this.hOk.setVisibility(0);
        AppMethodBeat.o(207885);
    }

    public final void aHq() {
        AppMethodBeat.i(207886);
        this.hOl.setVisibility(8);
        this.hOk.setVisibility(0);
        AppMethodBeat.o(207886);
    }

    @Override // com.tencent.mm.live.c.a
    public final void mount() {
    }

    @Override // com.tencent.mm.live.c.a
    public final void resume() {
        AppMethodBeat.i(207887);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(3806, this);
        AppMethodBeat.o(207887);
    }

    @Override // com.tencent.mm.live.c.a
    public final void pause() {
        AppMethodBeat.i(207888);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(3806, this);
        AppMethodBeat.o(207888);
    }

    @Override // com.tencent.mm.live.c.a
    public final void unMount() {
    }

    @Override // com.tencent.mm.live.c.a
    @SuppressLint({"SourceLockedOrientationActivity"})
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(207890);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (d.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
            case 2:
                r rVar = r.hIg;
                r.aGb();
                Context context = this.hwr.getContext();
                p.g(context, "root.context");
                String string = context.getResources().getString(R.string.eeu);
                p.g(string, "root.context.resources.g…R.string.live_after_over)");
                Hb(string);
                rg(0);
                com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                String aGt = com.tencent.mm.live.b.x.aGt();
                a.C0373a aVar = com.tencent.mm.live.b.d.a.hLg;
                Context context2 = this.hwr.getContext();
                p.g(context2, "root.context");
                a.C0373a.a(aGt, context2.getResources().getColor(R.color.xg), new a(this));
                Context context3 = this.hwr.getContext();
                if (context3 == null) {
                    t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(207890);
                    throw tVar;
                }
                ((Activity) context3).setRequestedOrientation(1);
                AppMethodBeat.o(207890);
                return;
            case 3:
            case 4:
            case 5:
                this.hOo = true;
                rg(4);
                break;
        }
        AppMethodBeat.o(207890);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        String string;
        int aWB;
        xf xfVar;
        AppMethodBeat.i(207891);
        if (qVar instanceof com.tencent.mm.live.b.a.b) {
            if (i2 == 0 && i3 == 0) {
                civ aGr = ((com.tencent.mm.live.b.a.b) qVar).aGr();
                if (com.tencent.mm.ac.d.cW(1, (aGr == null || (xfVar = aGr.MnQ) == null) ? 0 : (int) xfVar.Btv)) {
                    Context context = this.hwr.getContext();
                    p.g(context, "root.context");
                    string = context.getResources().getString(R.string.eer);
                } else {
                    Context context2 = this.hwr.getContext();
                    p.g(context2, "root.context");
                    string = context2.getResources().getString(R.string.eeu);
                }
                p.g(string, "if (cutLive) root.contex…R.string.live_after_over)");
                Hb(string);
                if (this.hOo && this.hOp.getLiveRole() == 1) {
                    this.hOo = false;
                    com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                    if (com.tencent.mm.live.b.x.aGr().pSb > 0) {
                        com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
                        aWB = com.tencent.mm.live.b.x.aGr().pSb;
                    } else {
                        aWB = cl.aWB();
                    }
                    com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
                    int i4 = aWB - com.tencent.mm.live.b.x.aGr().Gaz;
                    com.tencent.mm.live.b.x xVar4 = com.tencent.mm.live.b.x.hJf;
                    String aGm = com.tencent.mm.live.b.x.aGm();
                    com.tencent.mm.live.b.x xVar5 = com.tencent.mm.live.b.x.hJf;
                    long j2 = com.tencent.mm.live.b.x.aGr().hyH;
                    com.tencent.mm.live.b.x xVar6 = com.tencent.mm.live.b.x.hJf;
                    String str2 = com.tencent.mm.live.b.x.aGr().LpF;
                    com.tencent.mm.live.b.x xVar7 = com.tencent.mm.live.b.x.hJf;
                    int i5 = com.tencent.mm.live.b.x.aGr().LIa;
                    com.tencent.mm.live.b.x xVar8 = com.tencent.mm.live.b.x.hJf;
                    int aGM = com.tencent.mm.live.b.x.aGM();
                    com.tencent.mm.live.b.x xVar9 = com.tencent.mm.live.b.x.hJf;
                    int i6 = com.tencent.mm.live.b.x.aGr().MnH;
                    com.tencent.mm.live.b.x xVar10 = com.tencent.mm.live.b.x.hJf;
                    int i7 = com.tencent.mm.live.b.x.aGr().LXG;
                    com.tencent.mm.live.b.x xVar11 = com.tencent.mm.live.b.x.hJf;
                    int aGO = com.tencent.mm.live.b.x.aGO();
                    com.tencent.mm.live.b.x xVar12 = com.tencent.mm.live.b.x.hJf;
                    e.a(aGm, j2, str2, i5, aGM, i6, i7, aGO, com.tencent.mm.live.b.x.aGr().MnK, (long) i4);
                    AppMethodBeat.o(207891);
                    return;
                }
            }
        } else if (qVar instanceof com.tencent.mm.live.b.a.r) {
            if (i2 == 0 && i3 == 0) {
                Log.i(this.TAG, "open replay success");
                AppMethodBeat.o(207891);
                return;
            }
            Log.i(this.TAG, "open replay fail");
        }
        AppMethodBeat.o(207891);
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        AppMethodBeat.i(207889);
        if (this.hwr.getVisibility() == 0) {
            b.C0376b.a(this.hOp, b.c.hLD);
            AppMethodBeat.o(207889);
            return true;
        }
        AppMethodBeat.o(207889);
        return false;
    }
}
