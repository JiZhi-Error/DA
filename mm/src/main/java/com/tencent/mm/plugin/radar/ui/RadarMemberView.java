package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.radar.b.c;
import com.tencent.mm.protocal.protobuf.djb;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.e;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.t;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006*\u00010\u0018\u0000 c2\u00020\u0001:\u0002cdB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010T\u001a\u00020+H\u0002J\u0006\u0010U\u001a\u00020VJ\b\u0010W\u001a\u00020VH\u0002J\u0010\u0010X\u001a\u00020V2\u0006\u00108\u001a\u000209H\u0002J \u0010Y\u001a\u00020V2\u0006\u0010Z\u001a\u00020\u00142\u0006\u00108\u001a\u0002092\b\u0010H\u001a\u0004\u0018\u00010IJ\b\u0010[\u001a\u00020VH\u0002J\u000e\u0010\\\u001a\u00020V2\u0006\u00104\u001a\u000205J\u0010\u0010]\u001a\u00020V2\u0006\u0010^\u001a\u00020_H\u0002J\u001c\u0010`\u001a\u00020V2\b\u00108\u001a\u0004\u0018\u0001092\b\u0010H\u001a\u0004\u0018\u00010IH\u0002J\u0016\u0010a\u001a\u00020V2\u0006\u0010b\u001a\u00020_2\u0006\u0010H\u001a\u00020IR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u0019\u0010\u0016R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010\u0012\u001a\u0004\b#\u0010$R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010,\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b.\u0010\u0012\u001a\u0004\b-\u0010$R\u0010\u0010/\u001a\u000200X\u0004¢\u0006\u0004\n\u0002\u00101R\u0011\u00102\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\b2\u00103R\u0010\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0004¢\u0006\u0002\n\u0000R\u001c\u00108\u001a\u0004\u0018\u000109X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001b\u0010>\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b@\u0010\u0012\u001a\u0004\b?\u0010$R\u001b\u0010A\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\bC\u0010\u0012\u001a\u0004\bB\u0010\u001fR\u001b\u0010D\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\bF\u0010\u0012\u001a\u0004\bE\u0010$R\u0010\u0010G\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010H\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0010\u0010N\u001a\u0004\u0018\u00010OX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000¨\u0006e"}, hxF = {"Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "alert", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "avatarCopy", "Landroid/widget/ImageView;", "getAvatarCopy", "()Landroid/widget/ImageView;", "avatarCopy$delegate", "Lkotlin/Lazy;", "avatarCopyContainer", "Landroid/view/View;", "getAvatarCopyContainer", "()Landroid/view/View;", "avatarCopyContainer$delegate", "avatarHolder", "getAvatarHolder", "avatarHolder$delegate", "avatarItem", "confirmBtn", "Landroid/widget/Button;", "getConfirmBtn", "()Landroid/widget/Button;", "confirmBtn$delegate", "confirmBtnDisabled", "Landroid/widget/TextView;", "getConfirmBtnDisabled", "()Landroid/widget/TextView;", "confirmBtnDisabled$delegate", "contact", "Lcom/tencent/mm/storage/Contact;", "contentET", "Landroid/widget/EditText;", "dismissing", "", "exposeTv", "getExposeTv", "exposeTv$delegate", "handler", "com/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1;", "isShowing", "()Z", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "mOnModifyNameClickListener", "Landroid/view/View$OnClickListener;", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getMember", "()Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "setMember", "(Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "memberNameTv", "getMemberNameTv", "memberNameTv$delegate", "modifyNameBtn", "getModifyNameBtn", "modifyNameBtn$delegate", "sayHiTv", "getSayHiTv", "sayHiTv$delegate", "sendDialog", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getState", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "setState", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;)V", "stranger", "Lcom/tencent/mm/storage/Stranger;", "tipTV", "toPosCache", "", "wordcntTV", "dealModRemarkName", "dismiss", "", "hideAll", "initView", "popup", "view", "reset", "setListener", "showModifyDialog", "name", "", "switchState", "updateState", ch.COL_USERNAME, "Companion", "OnConfirmBtnClickListener", "plugin-radar_release"})
public final class RadarMemberView extends RelativeLayout {
    private static final int BzL = 0;
    private static final int BzM = 1;
    public static final a BzN = new a((byte) 0);
    private static final String TAG = TAG;
    private final kotlin.f BzA = i.aq(this, R.id.gq0);
    private final kotlin.f BzB = i.aq(this, R.id.gq5);
    private final kotlin.f BzC = i.aq(this, R.id.gq4);
    private final kotlin.f BzD = i.aq(this, R.id.gqg);
    private int[] BzE;
    private final kotlin.f BzF = i.aq(this, R.id.c6w);
    private cn BzG;
    private b BzH;
    private final View.OnClickListener BzI = new h(this);
    private final d BzJ = new d(this);
    private TextView BzK;
    private djb Bzb;
    private c.e Bzc;
    private View Bzv;
    private final kotlin.f Bzw = i.aq(this, R.id.gqa);
    private final kotlin.f Bzx = i.aq(this, R.id.gpw);
    private final kotlin.f Bzy = i.aq(this, R.id.gpv);
    private final kotlin.f Bzz = i.aq(this, R.id.gpz);
    private as contact;
    private boolean jLA;
    private View kdm;
    private com.tencent.mm.ui.widget.a.d kdo;
    private EditText nBD;
    private TextView xcs;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "", "onClick", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "onDismissed", "plugin-radar_release"})
    public interface b {
        void a(djb djb, c.e eVar);

        void b(djb djb, c.e eVar);
    }

    private final ImageView getAvatarCopy() {
        AppMethodBeat.i(138611);
        ImageView imageView = (ImageView) this.Bzx.getValue();
        AppMethodBeat.o(138611);
        return imageView;
    }

    private final View getAvatarCopyContainer() {
        AppMethodBeat.i(138612);
        View view = (View) this.Bzy.getValue();
        AppMethodBeat.o(138612);
        return view;
    }

    private final View getAvatarHolder() {
        AppMethodBeat.i(138610);
        View view = (View) this.Bzw.getValue();
        AppMethodBeat.o(138610);
        return view;
    }

    private final Button getConfirmBtn() {
        AppMethodBeat.i(138613);
        Button button = (Button) this.Bzz.getValue();
        AppMethodBeat.o(138613);
        return button;
    }

    private final TextView getConfirmBtnDisabled() {
        AppMethodBeat.i(138614);
        TextView textView = (TextView) this.BzA.getValue();
        AppMethodBeat.o(138614);
        return textView;
    }

    private final TextView getExposeTv() {
        AppMethodBeat.i(138618);
        TextView textView = (TextView) this.BzF.getValue();
        AppMethodBeat.o(138618);
        return textView;
    }

    private final TextView getMemberNameTv() {
        AppMethodBeat.i(138615);
        TextView textView = (TextView) this.BzB.getValue();
        AppMethodBeat.o(138615);
        return textView;
    }

    private final Button getModifyNameBtn() {
        AppMethodBeat.i(138616);
        Button button = (Button) this.BzC.getValue();
        AppMethodBeat.o(138616);
        return button;
    }

    private final TextView getSayHiTv() {
        AppMethodBeat.i(138617);
        TextView textView = (TextView) this.BzD.getValue();
        AppMethodBeat.o(138617);
        return textView;
    }

    public static final /* synthetic */ void a(RadarMemberView radarMemberView, c.e eVar) {
        AppMethodBeat.i(138631);
        radarMemberView.a(eVar);
        AppMethodBeat.o(138631);
    }

    public static final /* synthetic */ Button b(RadarMemberView radarMemberView) {
        AppMethodBeat.i(138628);
        Button confirmBtn = radarMemberView.getConfirmBtn();
        AppMethodBeat.o(138628);
        return confirmBtn;
    }

    public static final /* synthetic */ void j(RadarMemberView radarMemberView) {
        AppMethodBeat.i(138632);
        radarMemberView.reset();
        AppMethodBeat.o(138632);
    }

    public final c.e getState() {
        return this.Bzc;
    }

    public final void setState(c.e eVar) {
        this.Bzc = eVar;
    }

    public final djb getMember() {
        return this.Bzb;
    }

    public final void setMember(djb djb) {
        this.Bzb = djb;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class h implements View.OnClickListener {
        final /* synthetic */ RadarMemberView BzO;

        h(RadarMemberView radarMemberView) {
            this.BzO = radarMemberView;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00be, code lost:
            if (r0 != false) goto L_0x00c0;
         */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x00fd  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r11) {
            /*
            // Method dump skipped, instructions count: 274
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.radar.ui.RadarMemberView.h.onClick(android.view.View):void");
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
    public static final class d extends MMHandler {
        final /* synthetic */ RadarMemberView BzO;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(RadarMemberView radarMemberView) {
            this.BzO = radarMemberView;
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(138595);
            p.h(message, "msg");
            if (message.what == RadarMemberView.BzL) {
                RadarMemberView radarMemberView = this.BzO;
                this.BzO.getMember();
                RadarMemberView.a(radarMemberView, this.BzO.getState());
                AppMethodBeat.o(138595);
                return;
            }
            if (message.what == RadarMemberView.BzM) {
                this.BzO.setVisibility(4);
                RadarMemberView.j(this.BzO);
                View view = this.BzO.Bzv;
                if (view != null) {
                    view.setVisibility(0);
                }
                b bVar = this.BzO.BzH;
                if (bVar != null) {
                    bVar.b(this.BzO.getMember(), this.BzO.getState());
                    AppMethodBeat.o(138595);
                    return;
                }
            }
            AppMethodBeat.o(138595);
        }
    }

    public final boolean isShowing() {
        AppMethodBeat.i(138619);
        if (getVisibility() == 0) {
            AppMethodBeat.o(138619);
            return true;
        }
        AppMethodBeat.o(138619);
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RadarMemberView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(138626);
        AppMethodBeat.o(138626);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RadarMemberView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(138627);
        AppMethodBeat.o(138627);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ RadarMemberView BzO;
        final /* synthetic */ djb BzP;

        e(RadarMemberView radarMemberView, djb djb) {
            this.BzO = radarMemberView;
            this.BzP = djb;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(138596);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/radar/ui/RadarMemberView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.BzO.getState() == null || this.BzO.BzH == null) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/radar/ui/RadarMemberView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(138596);
                return;
            }
            b bVar2 = this.BzO.BzH;
            if (bVar2 != null) {
                bVar2.a(this.BzP, this.BzO.getState());
            }
            this.BzO.dismiss();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/radar/ui/RadarMemberView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(138596);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
    static final class f implements View.OnTouchListener {
        final /* synthetic */ RadarMemberView BzO;

        f(RadarMemberView radarMemberView) {
            this.BzO = radarMemberView;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(138597);
            if (view != RadarMemberView.b(this.BzO)) {
                p.g(motionEvent, "event");
                if (motionEvent.getAction() == 1 && this.BzO.isShowing()) {
                    this.BzO.dismiss();
                }
            }
            AppMethodBeat.o(138597);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g implements View.OnClickListener {
        final /* synthetic */ RadarMemberView BzO;

        g(RadarMemberView radarMemberView) {
            this.BzO = radarMemberView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(138598);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/radar/ui/RadarMemberView$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            as asVar = this.BzO.contact;
            intent.putExtra("k_username", asVar != null ? asVar.getUsername() : null);
            intent.putExtra("showShare", false);
            ae aeVar = ae.SYK;
            String str = e.C2115e.OyU;
            p.g(str, "ConstantsUI.ExposeUI.KExposeH5Url");
            String format = String.format(str, Arrays.copyOf(new Object[]{38}, 1));
            p.g(format, "java.lang.String.format(format, *args)");
            intent.putExtra("rawUrl", format);
            com.tencent.mm.br.c.b(this.BzO.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/radar/ui/RadarMemberView$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(138598);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0037, code lost:
        if (kotlin.g.b.p.j(r4, r1) != false) goto L_0x0039;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(java.lang.String r4, com.tencent.mm.plugin.radar.b.c.e r5) {
        /*
            r3 = this;
            r1 = 0
            r2 = 138620(0x21d7c, float:1.94248E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            java.lang.String r0 = "username"
            kotlin.g.b.p.h(r4, r0)
            java.lang.String r0 = "state"
            kotlin.g.b.p.h(r5, r0)
            boolean r0 = r3.isShowing()
            if (r0 == 0) goto L_0x001d
            boolean r0 = r3.jLA
            if (r0 == 0) goto L_0x0021
        L_0x001d:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0020:
            return
        L_0x0021:
            com.tencent.mm.protocal.protobuf.djb r0 = r3.Bzb
            if (r0 == 0) goto L_0x0040
            java.lang.String r0 = r0.LuX
        L_0x0027:
            boolean r0 = kotlin.g.b.p.j(r4, r0)
            if (r0 != 0) goto L_0x0039
            com.tencent.mm.protocal.protobuf.djb r0 = r3.Bzb
            if (r0 == 0) goto L_0x0033
            java.lang.String r1 = r0.UserName
        L_0x0033:
            boolean r0 = kotlin.g.b.p.j(r4, r1)
            if (r0 == 0) goto L_0x003c
        L_0x0039:
            r3.a(r5)
        L_0x003c:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0020
        L_0x0040:
            r0 = r1
            goto L_0x0027
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.radar.ui.RadarMemberView.c(java.lang.String, com.tencent.mm.plugin.radar.b.c$e):void");
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private final void a(c.e eVar) {
        AppMethodBeat.i(138621);
        getExposeTv().setVisibility(0);
        if (eVar == null) {
            AppMethodBeat.o(138621);
            return;
        }
        switch (c.$EnumSwitchMapping$0[eVar.ordinal()]) {
            case 1:
                getMemberNameTv().setVisibility(0);
                getModifyNameBtn().setVisibility(0);
                getConfirmBtn().setText(R.string.ft_);
                getConfirmBtn().setVisibility(0);
                getConfirmBtnDisabled().setVisibility(8);
                getSayHiTv().setVisibility(8);
                AppMethodBeat.o(138621);
                return;
            case 2:
                getMemberNameTv().setVisibility(0);
                getModifyNameBtn().setVisibility(0);
                getConfirmBtnDisabled().setText(R.string.ftg);
                getConfirmBtn().setVisibility(8);
                getConfirmBtnDisabled().setVisibility(0);
                getSayHiTv().setVisibility(8);
                AppMethodBeat.o(138621);
                return;
            case 3:
                getMemberNameTv().setVisibility(0);
                getModifyNameBtn().setVisibility(0);
                getConfirmBtnDisabled().setText(R.string.fsx);
                getConfirmBtn().setVisibility(8);
                getConfirmBtnDisabled().setVisibility(0);
                getSayHiTv().setVisibility(8);
                AppMethodBeat.o(138621);
                return;
            case 4:
                getMemberNameTv().setVisibility(0);
                getModifyNameBtn().setVisibility(0);
                getConfirmBtn().setText(R.string.fsw);
                getConfirmBtn().setVisibility(0);
                getConfirmBtnDisabled().setVisibility(8);
                getSayHiTv().setText(getContext().getString(R.string.ft8));
                getSayHiTv().setVisibility(0);
                break;
        }
        AppMethodBeat.o(138621);
    }

    public final void setListener(b bVar) {
        AppMethodBeat.i(138622);
        p.h(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.BzH = bVar;
        AppMethodBeat.o(138622);
    }

    public final void a(View view, djb djb, c.e eVar) {
        String ajy;
        SpannableString b2;
        AppMethodBeat.i(138623);
        p.h(view, "view");
        p.h(djb, "member");
        Log.d(TAG, "popup");
        this.Bzc = eVar;
        this.Bzb = djb;
        Button confirmBtn = getConfirmBtn();
        if (confirmBtn != null) {
            confirmBtn.setOnClickListener(new e(this, djb));
        }
        getModifyNameBtn().setOnClickListener(this.BzI);
        setOnTouchListener(new f(this));
        getExposeTv().setOnClickListener(new g(this));
        g gVar = g.BAY;
        String b3 = g.b(djb);
        if (!n.aL(b3)) {
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af, "service(IMessengerStorage::class.java)");
            this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(b3);
        }
        as asVar = this.contact;
        if (asVar == null || !asVar.arv()) {
            com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af2, "service(IMessengerStorage::class.java)");
            this.BzG = ((com.tencent.mm.plugin.messenger.foundation.a.l) af2).aSO().aEZ(b3);
            cn cnVar = this.BzG;
            ajy = cnVar != null ? cnVar.ajy() : null;
        } else {
            as asVar2 = this.contact;
            ajy = asVar2 != null ? asVar2.ajy() : null;
        }
        TextView memberNameTv = getMemberNameTv();
        if (this.contact == null || Util.isNullOrNil(ajy)) {
            b2 = com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), djb.oUJ, getMemberNameTv().getTextSize());
        } else {
            b2 = com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), ajy, getMemberNameTv().getTextSize());
        }
        memberNameTv.setText(b2);
        getMemberNameTv().setVisibility(4);
        getModifyNameBtn().setVisibility(4);
        reset();
        this.Bzv = view;
        View view2 = this.Bzv;
        if (view2 == null) {
            p.hyc();
        }
        View findViewById = view2.findViewById(R.id.gqc);
        p.g(findViewById, "avatarItem!!.findViewByI…ar_result_item_avatar_iv)");
        ImageView imageView = (ImageView) findViewById;
        View view3 = this.Bzv;
        if (view3 == null) {
            p.hyc();
        }
        View findViewById2 = view3.findViewById(R.id.gpv);
        p.g(findViewById2, "avatarItem!!.findViewByI…d.radar_avatar_container)");
        View view4 = this.Bzv;
        if (view4 == null) {
            p.hyc();
        }
        view4.setVisibility(4);
        getAvatarCopy().setImageDrawable(imageView.getDrawable());
        getAvatarCopyContainer().setVisibility(0);
        int[] iArr = new int[2];
        findViewById2.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        getAvatarHolder().getLocationInWindow(iArr2);
        this.BzE = iArr2;
        setVisibility(0);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setFillAfter(true);
        animationSet.setRepeatCount(1);
        animationSet.setDuration(500);
        float height = ((float) getAvatarHolder().getHeight()) / ((float) findViewById2.getHeight());
        TranslateAnimation translateAnimation = new TranslateAnimation((float) iArr[0], ((float) iArr2[0]) - (((float) ((findViewById2.getWidth() - findViewById2.getHeight()) / 2)) * height), (float) iArr[1], (float) iArr2[1]);
        animationSet.addAnimation(new ScaleAnimation(1.0f, height, 1.0f, height));
        animationSet.addAnimation(translateAnimation);
        animationSet.setAnimationListener(new i(this));
        getAvatarCopyContainer().startAnimation(animationSet);
        AppMethodBeat.o(138623);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/radar/ui/RadarMemberView$popup$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
    public static final class i implements Animation.AnimationListener {
        final /* synthetic */ RadarMemberView BzO;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        i(RadarMemberView radarMemberView) {
            this.BzO = radarMemberView;
        }

        public final void onAnimationStart(Animation animation) {
            AppMethodBeat.i(138600);
            p.h(animation, "animation");
            AppMethodBeat.o(138600);
        }

        public final void onAnimationRepeat(Animation animation) {
            AppMethodBeat.i(138601);
            p.h(animation, "animation");
            AppMethodBeat.o(138601);
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.i(138602);
            p.h(animation, "animation");
            Log.d(RadarMemberView.TAG, "popup animation end");
            this.BzO.BzJ.sendEmptyMessage(RadarMemberView.BzL);
            AppMethodBeat.o(138602);
        }
    }

    public final void dismiss() {
        AppMethodBeat.i(138624);
        Log.d(TAG, "dismiss");
        if (this.jLA) {
            AppMethodBeat.o(138624);
            return;
        }
        this.jLA = true;
        View view = this.Bzv;
        if (view == null) {
            p.hyc();
        }
        View findViewById = view.findViewById(R.id.gpv);
        p.g(findViewById, "avatarItem!!.findViewByI…d.radar_avatar_container)");
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setFillAfter(true);
        animationSet.setRepeatCount(1);
        animationSet.setDuration(500);
        int[] iArr = this.BzE;
        int[] iArr2 = new int[2];
        findViewById.getLocationInWindow(iArr2);
        float height = ((float) getAvatarHolder().getHeight()) / ((float) findViewById.getHeight());
        float width = ((float) ((findViewById.getWidth() - findViewById.getHeight()) / 2)) * height;
        if (iArr == null) {
            p.hyc();
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(((float) iArr[0]) - width, (float) iArr2[0], (float) iArr[1], (float) iArr2[1]);
        animationSet.addAnimation(new ScaleAnimation(height, 1.0f, height, 1.0f));
        animationSet.addAnimation(translateAnimation);
        animationSet.setAnimationListener(new c(this));
        getMemberNameTv().setVisibility(4);
        getModifyNameBtn().setVisibility(4);
        getConfirmBtn().setVisibility(8);
        getConfirmBtnDisabled().setVisibility(8);
        getSayHiTv().setVisibility(8);
        getExposeTv().setVisibility(8);
        getAvatarCopyContainer().startAnimation(animationSet);
        AppMethodBeat.o(138624);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/radar/ui/RadarMemberView$dismiss$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
    public static final class c implements Animation.AnimationListener {
        final /* synthetic */ RadarMemberView BzO;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(RadarMemberView radarMemberView) {
            this.BzO = radarMemberView;
        }

        public final void onAnimationStart(Animation animation) {
            AppMethodBeat.i(138592);
            p.h(animation, "animation");
            AppMethodBeat.o(138592);
        }

        public final void onAnimationRepeat(Animation animation) {
            AppMethodBeat.i(138593);
            p.h(animation, "animation");
            AppMethodBeat.o(138593);
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.i(138594);
            p.h(animation, "animation");
            Log.d(RadarMemberView.TAG, "dismiss animation end");
            this.BzO.jLA = false;
            this.BzO.BzJ.sendEmptyMessage(RadarMemberView.BzM);
            AppMethodBeat.o(138594);
        }
    }

    private final void reset() {
        AppMethodBeat.i(138625);
        getAvatarCopyContainer().setVisibility(8);
        getMemberNameTv().setVisibility(4);
        getModifyNameBtn().setVisibility(4);
        getConfirmBtn().setVisibility(8);
        getConfirmBtnDisabled().setVisibility(8);
        getSayHiTv().setVisibility(8);
        getExposeTv().setVisibility(8);
        AppMethodBeat.o(138625);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/radar/ui/RadarMemberView$showModifyDialog$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-radar_release"})
    public static final class j implements TextWatcher {
        final /* synthetic */ RadarMemberView BzO;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        j(RadarMemberView radarMemberView) {
            this.BzO = radarMemberView;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AppMethodBeat.i(138603);
            p.h(charSequence, "s");
            AppMethodBeat.o(138603);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AppMethodBeat.i(138604);
            p.h(charSequence, "s");
            AppMethodBeat.o(138604);
        }

        public final void afterTextChanged(Editable editable) {
            Button button;
            boolean z = false;
            AppMethodBeat.i(138605);
            p.h(editable, "s");
            int length = 50 - editable.length();
            if (length < 0) {
                length = 0;
            }
            TextView textView = this.BzO.BzK;
            if (textView != null) {
                textView.setText(String.valueOf(length));
            }
            com.tencent.mm.ui.widget.a.d dVar = this.BzO.kdo;
            if (dVar == null || (button = dVar.getButton(-1)) == null) {
                AppMethodBeat.o(138605);
                return;
            }
            if (editable.length() > 0) {
                z = true;
            }
            button.setEnabled(z);
            AppMethodBeat.o(138605);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    public static final class m implements DialogInterface.OnClickListener {
        final /* synthetic */ RadarMemberView BzO;

        m(RadarMemberView radarMemberView) {
            this.BzO = radarMemberView;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(138608);
            if (this.BzO.kdo != null) {
                com.tencent.mm.ui.widget.a.d dVar = this.BzO.kdo;
                if (dVar != null) {
                    dVar.dismiss();
                }
                this.BzO.kdo = null;
            }
            RadarMemberView.i(this.BzO);
            AppMethodBeat.o(138608);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    public static final class l implements DialogInterface.OnClickListener {
        final /* synthetic */ RadarMemberView BzO;

        l(RadarMemberView radarMemberView) {
            this.BzO = radarMemberView;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(138607);
            com.tencent.mm.ui.widget.a.d dVar = this.BzO.kdo;
            if (dVar != null) {
                dVar.dismiss();
            }
            this.BzO.kdo = null;
            AppMethodBeat.o(138607);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class k implements Runnable {
        final /* synthetic */ RadarMemberView BzO;

        k(RadarMemberView radarMemberView) {
            this.BzO = radarMemberView;
        }

        public final void run() {
            AppMethodBeat.i(138606);
            if (this.BzO.getContext() instanceof Activity) {
                a aVar = RadarMemberView.BzN;
                Context context = this.BzO.getContext();
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(138606);
                    throw tVar;
                }
                Activity activity = (Activity) context;
                p.h(activity, "ac");
                Object systemService = activity.getSystemService("input_method");
                if (!(systemService instanceof InputMethodManager)) {
                    systemService = null;
                }
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                if (inputMethodManager == null) {
                    AppMethodBeat.o(138606);
                    return;
                }
                View currentFocus = activity.getCurrentFocus();
                if (currentFocus == null) {
                    AppMethodBeat.o(138606);
                    return;
                }
                p.g(currentFocus, "ac.currentFocus ?: return");
                if (currentFocus.getWindowToken() == null) {
                    AppMethodBeat.o(138606);
                    return;
                }
                inputMethodManager.toggleSoftInput(0, 2);
            }
            AppMethodBeat.o(138606);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$Companion;", "", "()V", "ANIMATION_DISMISS_END", "", "ANIMATION_POPUP_END", "TAG", "", "showVKB", "", "ac", "Landroid/app/Activity;", "plugin-radar_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(138609);
        AppMethodBeat.o(138609);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a8, code lost:
        if (r0 != false) goto L_0x00aa;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ boolean i(com.tencent.mm.plugin.radar.ui.RadarMemberView r10) {
        /*
        // Method dump skipped, instructions count: 347
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.radar.ui.RadarMemberView.i(com.tencent.mm.plugin.radar.ui.RadarMemberView):boolean");
    }

    public static final /* synthetic */ void a(RadarMemberView radarMemberView, String str) {
        EditText editText;
        TextView textView;
        AppMethodBeat.i(138630);
        radarMemberView.kdm = View.inflate(radarMemberView.getContext(), R.layout.bqa, null);
        View view = radarMemberView.kdm;
        radarMemberView.xcs = view != null ? (TextView) view.findViewById(R.id.hku) : null;
        TextView textView2 = radarMemberView.xcs;
        if (textView2 != null) {
            textView2.setText("");
        }
        View view2 = radarMemberView.kdm;
        if (view2 != null) {
            editText = (EditText) view2.findViewById(R.id.hkt);
        } else {
            editText = null;
        }
        radarMemberView.nBD = editText;
        View view3 = radarMemberView.kdm;
        if (view3 != null) {
            textView = (TextView) view3.findViewById(R.id.joi);
        } else {
            textView = null;
        }
        radarMemberView.BzK = textView;
        TextView textView3 = radarMemberView.BzK;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        EditText editText2 = radarMemberView.nBD;
        if (editText2 != null) {
            editText2.setText(str);
        }
        TextView textView4 = radarMemberView.BzK;
        if (textView4 != null) {
            textView4.setText("50");
        }
        EditText editText3 = radarMemberView.nBD;
        if (editText3 != null) {
            editText3.setFilters(com.tencent.mm.pluginsdk.ui.tools.l.KvQ);
        }
        EditText editText4 = radarMemberView.nBD;
        if (editText4 != null) {
            editText4.addTextChangedListener(new j(radarMemberView));
        }
        radarMemberView.kdo = com.tencent.mm.ui.base.h.a(radarMemberView.getContext(), radarMemberView.getContext().getString(R.string.ft5), radarMemberView.kdm, new m(radarMemberView), new l(radarMemberView));
        EditText editText5 = radarMemberView.nBD;
        if (editText5 != null) {
            editText5.post(new k(radarMemberView));
            AppMethodBeat.o(138630);
            return;
        }
        AppMethodBeat.o(138630);
    }
}
