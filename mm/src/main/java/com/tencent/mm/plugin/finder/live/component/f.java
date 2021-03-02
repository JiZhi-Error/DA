package com.tencent.mm.plugin.finder.live.component;

import android.content.Context;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.live.component.d;
import com.tencent.mm.plugin.finder.live.component.e;
import com.tencent.mm.plugin.finder.live.widget.f;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.avp;
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020\nH\u0002J\u0018\u0010f\u001a\u00020b2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020\nH\u0002J\b\u0010g\u001a\u00020bH\u0002J\b\u0010h\u001a\u00020bH\u0016J\b\u0010i\u001a\u00020\u0005H\u0016J\n\u0010j\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010k\u001a\u00020b2\b\u0010l\u001a\u0004\u0018\u000104H\u0002J\b\u0010m\u001a\u00020bH\u0002J\b\u0010n\u001a\u00020bH\u0002J\b\u0010o\u001a\u00020bH\u0002J\b\u0010p\u001a\u00020bH\u0002J\b\u0010q\u001a\u00020bH\u0016J\u0018\u0010r\u001a\u00020b2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020\nH\u0016J\b\u0010s\u001a\u00020bH\u0002J\u0010\u0010t\u001a\u00020b2\u0006\u0010u\u001a\u00020vH\u0002J\u0010\u0010w\u001a\u00020b2\u0006\u0010u\u001a\u00020vH\u0002J\u001a\u0010x\u001a\u00020b2\b\u0010y\u001a\u0004\u0018\u00010%2\u0006\u0010z\u001a\u00020dH\u0002J\u0010\u0010{\u001a\u00020b2\u0006\u0010z\u001a\u00020dH\u0002J\b\u0010|\u001a\u00020bH\u0002J\u0010\u0010}\u001a\u00020b2\u0006\u0010~\u001a\u00020\u0014H\u0016J\b\u0010\u001a\u00020bH\u0002J\t\u0010\u0001\u001a\u00020bH\u0002J2\u0010\u0001\u001a\u00020b2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00142\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0013\u0010\u0001\u001a\u00020b2\b\u0010l\u001a\u0004\u0018\u000104H\u0002J\t\u0010\u0001\u001a\u00020bH\u0002J\u0012\u0010\u0001\u001a\u00020b2\u0007\u0010\u0001\u001a\u00020dH\u0016J\u0012\u0010\u0001\u001a\u00020b2\u0007\u0010\u0001\u001a\u00020\u0014H\u0016J\u001b\u0010\u0001\u001a\u00020b2\u0007\u0010\u0001\u001a\u00020d2\u0007\u0010\u0001\u001a\u00020dH\u0016J\u0012\u0010\u0001\u001a\u00020b2\u0007\u0010\u0001\u001a\u00020\nH\u0016J\u0012\u0010\u0001\u001a\u00020b2\u0007\u0010\u0001\u001a\u00020\nH\u0016R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0014XD¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0019\"\u0004\b,\u0010\u001bR\u001c\u0010-\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0019\"\u0004\b/\u0010\u001bR\u001c\u00100\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001f\"\u0004\b2\u0010!R\u001c\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010?\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001f\"\u0004\bA\u0010!R\u001c\u0010B\u001a\u0004\u0018\u000104X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u00106\"\u0004\bD\u00108R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010MX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010P\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0010\u0010U\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020WX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010X\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0019\"\u0004\bZ\u0010\u001bR\u001c\u0010[\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010<\"\u0004\b]\u0010>R\u001c\u0010^\u001a\u0004\u0018\u000104X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u00106\"\u0004\b`\u00108¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$ViewCallback;", "rootView", "Landroid/view/View;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$Presenter;", "(Landroid/view/View;Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$Presenter;)V", "LOTTERY_ANY_COMMENT", "", "LOTTERY_COMMENT", "LOTTERY_LIKE", "LOTTERY_SHOPPING", "LOTTERY_SPECIAL_COMMENT", "MAX_INPUT_CHINESE_LENGTH", "MAX_INPUT_CHINESE_SIZE", "MAX_INPUT_NUMBER_LENGTH", "MAX_INPUT_NUMBER_SIZE", "TAG", "", "getTAG", "()Ljava/lang/String;", "attendType", "getAttendType", "()Landroid/view/View;", "setAttendType", "(Landroid/view/View;)V", "attendTypeTxt", "Landroid/widget/TextView;", "getAttendTypeTxt", "()Landroid/widget/TextView;", "setAttendTypeTxt", "(Landroid/widget/TextView;)V", "commentTypeBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "confirmBtn", "Landroid/widget/Button;", "getConfirmBtn", "()Landroid/widget/Button;", "setConfirmBtn", "(Landroid/widget/Button;)V", "confirmBtnContainer", "getConfirmBtnContainer", "setConfirmBtnContainer", "descContainer", "getDescContainer", "setDescContainer", "descCount", "getDescCount", "setDescCount", "descTxt", "Landroid/widget/EditText;", "getDescTxt", "()Landroid/widget/EditText;", "setDescTxt", "(Landroid/widget/EditText;)V", "durationContainer", "Landroid/widget/RelativeLayout;", "getDurationContainer", "()Landroid/widget/RelativeLayout;", "setDurationContainer", "(Landroid/widget/RelativeLayout;)V", "durationTip", "getDurationTip", "setDurationTip", "durationTxt", "getDurationTxt", "setDurationTxt", "exception", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget;", "inputClose", "inputContainer", "inputDialogArea", "inputEt", "inputFinishBtn", "inputPage", "Landroid/view/ViewGroup;", "inputRoot", "leftInputHint", "lotteryType", "getLotteryType", "()I", "setLotteryType", "(I)V", "lotteryTypeBottomSheet", "menuItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "statement", "getStatement", "setStatement", "winnerContainer", "getWinnerContainer", "setWinnerContainer", "winnerTxt", "getWinnerTxt", "setWinnerTxt", "adjustConfirmBtnLayout", "", "show", "", "height", "adjustInputDialogLayout", "bottomInputFinish", "destroy", "getActivity", "getPresenter", "hideInput", "et", "hideInputAction", "hideInputPage", "initInputPage", "initNormalView", "initView", "keyboardChange", "openInputPage", "prepareCommentTypeMenu", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "prepareLotteryTypeMenu", "setBtnStatus", "btn", "enable", "setInputFinishBtnEnable", "setLotteryInfo", "showAlertDialog", "msg", "showAttendTypeBottomSheet", "showCommentBottomSheet", "showErrMsg", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCreateLotteryResponse;", "showInput", "showInputAction", "updateConfirmBtn", "canConfirm", "updateLotteryDesc", "desc", "updateLotteryDurationTips", "valid", "warning", "updateLotteryType", "type", "updateWinnerNumber", "cnt", "plugin-finder_release"})
public final class f implements d.b {
    private final String TAG = "FinderLiveLotteryCreateViewCallback";
    final MMActivity activity;
    private final View lJI;
    private Button nZi;
    int ugE = 1;
    final d.a ugO;
    final int ugR;
    final int ugS = 1;
    final int ugT = 2;
    final int ugU = 3;
    final int ugV = 4;
    private int ugW = 20;
    private int ugX = (this.ugW / 2);
    private int ugY = 8;
    private int ugZ = (this.ugY / 2);
    private View uha;
    TextView uhb;
    private RelativeLayout uhc;
    EditText uhd;
    private TextView uhe;
    private RelativeLayout uhf;
    EditText uhg;
    private View uhh;
    EditText uhi;
    private TextView uhj;
    private View uhk;
    private View uhl;
    com.tencent.mm.ui.widget.a.e uhm;
    com.tencent.mm.ui.widget.a.e uhn;
    private com.tencent.mm.plugin.finder.live.widget.f uho;
    private View uhp;
    ViewGroup uhq;
    private View uhr;
    private View uhs;
    private View uht;
    EditText uhu;
    private TextView uhv;
    private Button uhw;
    o.g uhx = new n(this);

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class m extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final m uhz = new m();

        static {
            AppMethodBeat.i(245953);
            AppMethodBeat.o(245953);
        }

        m() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "ok", "", "invoke"})
    static final class s extends kotlin.g.b.q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ f uhy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(f fVar) {
            super(1);
            this.uhy = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(245959);
            bool.booleanValue();
            MMActivity mMActivity = this.uhy.activity;
            if (mMActivity != null) {
                mMActivity.finish();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(245959);
            return xVar;
        }
    }

    public f(View view, MMActivity mMActivity, d.a aVar) {
        kotlin.g.b.p.h(view, "rootView");
        kotlin.g.b.p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(245971);
        this.lJI = view;
        this.activity = mMActivity;
        this.ugO = aVar;
        AppMethodBeat.o(245971);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class h implements View.OnClickListener {
        final /* synthetic */ f uhy;

        h(f fVar) {
            this.uhy = fVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(245948);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            f fVar = this.uhy;
            fVar.uhm = new com.tencent.mm.ui.widget.a.e((Context) fVar.activity, 1, false);
            com.tencent.mm.ui.widget.a.e eVar = fVar.uhm;
            if (eVar != null) {
                eVar.a(new q(fVar));
            }
            com.tencent.mm.ui.widget.a.e eVar2 = fVar.uhm;
            if (eVar2 != null) {
                eVar2.a(fVar.uhx);
            }
            com.tencent.mm.ui.widget.a.e eVar3 = fVar.uhm;
            if (eVar3 != null) {
                eVar3.dGm();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245948);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class i implements View.OnClickListener {
        final /* synthetic */ f uhy;

        i(f fVar) {
            this.uhy = fVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(245949);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            EditText editText = this.uhy.uhd;
            if (editText != null) {
                editText.requestFocus();
            }
            f.e(this.uhy.uhd);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245949);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class j implements View.OnClickListener {
        final /* synthetic */ f uhy;

        j(f fVar) {
            this.uhy = fVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(245950);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            EditText editText = this.uhy.uhg;
            if (editText != null) {
                editText.requestFocus();
            }
            f.e(this.uhy.uhg);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245950);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class k implements View.OnClickListener {
        final /* synthetic */ f uhy;

        k(f fVar) {
            this.uhy = fVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(245951);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            EditText editText = this.uhy.uhi;
            if (editText != null) {
                editText.requestFocus();
            }
            f.e(this.uhy.uhi);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245951);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class l implements View.OnClickListener {
        final /* synthetic */ f uhy;

        l(f fVar) {
            this.uhy = fVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(245952);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            y yVar = y.vXH;
            if (y.isFastClick()) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(245952);
                return;
            }
            this.uhy.dfh();
            d.a aVar = this.uhy.ugO;
            if (aVar != null) {
                aVar.dff();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initNormalView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245952);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ f uhy;

        a(f fVar) {
            this.uhy = fVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(245941);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initInputPage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.uhy.dfi();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initInputPage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245941);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ f uhy;

        b(f fVar) {
            this.uhy = fVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(245942);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initInputPage$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.uhy.dfi();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initInputPage$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245942);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ f uhy;

        c(f fVar) {
            this.uhy = fVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(245943);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initInputPage$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            EditText editText = this.uhy.uhu;
            if (editText != null) {
                editText.requestFocus();
            }
            f.e(this.uhy.uhu);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initInputPage$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245943);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ f uhy;

        d(f fVar) {
            this.uhy = fVar;
        }

        public final void onClick(View view) {
            String str;
            Editable text;
            AppMethodBeat.i(245944);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initInputPage$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            f fVar = this.uhy;
            EditText editText = fVar.uhu;
            if (editText == null || (text = editText.getText()) == null || (str = text.toString()) == null) {
                str = "";
            }
            y yVar = y.vXH;
            String awt = y.awt(str);
            String str2 = awt;
            if (str2 == null || str2.length() == 0) {
                fVar.dfi();
            } else {
                fVar.ugE = 1;
                TextView textView = fVar.uhb;
                if (textView != null) {
                    textView.setText(fVar.activity.getResources().getString(R.string.cuy) + '\"' + awt + '\"');
                }
                d.a aVar = fVar.ugO;
                if (aVar != null) {
                    aVar.IZ(fVar.ugE);
                }
                d.a aVar2 = fVar.ugO;
                if (aVar2 != null) {
                    aVar2.atu(awt);
                }
                ViewGroup viewGroup = fVar.uhq;
                if (viewGroup != null) {
                    viewGroup.setVisibility(4);
                }
                f.d(fVar.uhu);
                com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.a(s.f.WRITE_SPECIFY_COMMENT_CONTENT_SUCC, awt);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateViewCallback$initInputPage$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245944);
        }
    }

    /* access modifiers changed from: package-private */
    public final void nl(boolean z) {
        AppMethodBeat.i(245961);
        Button button = this.uhw;
        if (button != null) {
            button.setEnabled(z);
        }
        a(this.uhw, z);
        AppMethodBeat.o(245961);
    }

    static void d(EditText editText) {
        Object obj;
        Context context;
        IBinder iBinder = null;
        AppMethodBeat.i(245962);
        if (editText == null || (context = editText.getContext()) == null) {
            obj = null;
        } else {
            obj = context.getSystemService("input_method");
        }
        InputMethodManager inputMethodManager = (InputMethodManager) obj;
        if (inputMethodManager != null) {
            if (editText != null) {
                iBinder = editText.getWindowToken();
            }
            inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
            AppMethodBeat.o(245962);
            return;
        }
        AppMethodBeat.o(245962);
    }

    @Override // com.tencent.mm.plugin.finder.live.component.d.b
    public final void keyboardChange(boolean z, int i2) {
        AppMethodBeat.i(245963);
        if (!z) {
            dfh();
        }
        View view = this.uhr;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams != null) {
                marginLayoutParams.bottomMargin = i2;
            }
            ViewGroup viewGroup = this.uhq;
            if (viewGroup != null) {
                viewGroup.updateViewLayout(this.uhr, marginLayoutParams);
            }
        }
        View view2 = this.uhk;
        ViewGroup.LayoutParams layoutParams2 = view2 != null ? view2.getLayoutParams() : null;
        if (!(layoutParams2 instanceof RelativeLayout.LayoutParams)) {
            layoutParams2 = null;
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams2;
        Context context = MMApplicationContext.getContext();
        kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.cr);
        if (layoutParams3 != null) {
            if (z) {
                int i3 = au.az(MMApplicationContext.getContext()).y;
                View view3 = this.uhk;
                int height = view3 != null ? view3.getHeight() : 0;
                int[] iArr = new int[2];
                View view4 = this.uhh;
                if (view4 != null) {
                    view4.getLocationOnScreen(iArr);
                }
                int i4 = iArr[1];
                View view5 = this.uhh;
                int height2 = view5 != null ? view5.getHeight() : 0;
                Log.i(this.TAG, "adjustConfirmBtnLayout screenHeight:" + i3 + ",confirmBtnContainerH:" + height + ",descContainerY:" + i4 + ",itemHeight:" + height2 + ",height:" + i2);
                if (height == 0 || i4 == 0 || ((i3 - dimensionPixelOffset) - height) - (height2 + i4) <= i2) {
                    View view6 = this.uhh;
                    if (view6 != null) {
                        int id = view6.getId();
                        layoutParams3.removeRule(2);
                        layoutParams3.removeRule(12);
                        layoutParams3.addRule(3, id);
                        layoutParams3.bottomMargin = 0;
                    }
                } else {
                    layoutParams3.removeRule(2);
                    layoutParams3.removeRule(3);
                    layoutParams3.addRule(12);
                    layoutParams3.bottomMargin = i2;
                }
            } else {
                View view7 = this.uhl;
                if (view7 != null) {
                    int id2 = view7.getId();
                    layoutParams3.removeRule(3);
                    layoutParams3.removeRule(12);
                    layoutParams3.bottomMargin = 0;
                    layoutParams3.addRule(2, id2);
                }
            }
            View view8 = this.uhk;
            ViewParent parent = view8 != null ? view8.getParent() : null;
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            ViewGroup viewGroup2 = (ViewGroup) parent;
            if (viewGroup2 != null) {
                viewGroup2.updateViewLayout(this.uhk, layoutParams3);
                AppMethodBeat.o(245963);
                return;
            }
        }
        AppMethodBeat.o(245963);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class q implements o.f {
        final /* synthetic */ f uhy;

        q(f fVar) {
            this.uhy = fVar;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(245957);
            com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.a(s.f.CLICK_JOIN_CONDITION, "");
            f fVar = this.uhy;
            kotlin.g.b.p.g(mVar, "menu");
            mVar.d(fVar.ugS, fVar.activity.getResources().getString(R.string.cuo));
            mVar.d(fVar.ugT, fVar.activity.getResources().getString(R.string.cvy));
            mVar.d(fVar.ugU, fVar.activity.getResources().getString(R.string.cvn));
            AppMethodBeat.o(245957);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class r implements o.f {
        final /* synthetic */ f uhy;

        r(f fVar) {
            this.uhy = fVar;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(245958);
            f fVar = this.uhy;
            kotlin.g.b.p.g(mVar, "menu");
            mVar.d(fVar.ugS, fVar.activity.getResources().getString(R.string.cuo));
            mVar.d(fVar.ugT, fVar.activity.getResources().getString(R.string.cvy));
            AppMethodBeat.o(245958);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
    static final class n implements o.g {
        final /* synthetic */ f uhy;

        n(f fVar) {
            this.uhy = fVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(245954);
            Integer valueOf = menuItem != null ? Integer.valueOf(menuItem.getItemId()) : null;
            int i3 = this.uhy.ugR;
            if (valueOf != null && valueOf.intValue() == i3) {
                com.tencent.mm.ui.widget.a.e eVar = this.uhy.uhm;
                if (eVar != null) {
                    eVar.bMo();
                }
                f fVar = this.uhy;
                fVar.uhn = new com.tencent.mm.ui.widget.a.e((Context) fVar.activity, 1, false);
                com.tencent.mm.ui.widget.a.e eVar2 = fVar.uhn;
                if (eVar2 != null) {
                    eVar2.a(new r(fVar));
                }
                com.tencent.mm.ui.widget.a.e eVar3 = fVar.uhn;
                if (eVar3 != null) {
                    eVar3.a(fVar.uhx);
                }
                com.tencent.mm.ui.widget.a.e eVar4 = fVar.uhn;
                if (eVar4 != null) {
                    eVar4.dGm();
                    AppMethodBeat.o(245954);
                    return;
                }
                AppMethodBeat.o(245954);
                return;
            }
            int i4 = this.uhy.ugU;
            if (valueOf != null && valueOf.intValue() == i4) {
                TextView textView = this.uhy.uhb;
                if (textView != null) {
                    textView.setText(menuItem.getTitle());
                }
                this.uhy.ugE = 2;
                d.a aVar = this.uhy.ugO;
                if (aVar != null) {
                    aVar.IZ(this.uhy.ugE);
                }
                d.a aVar2 = this.uhy.ugO;
                if (aVar2 != null) {
                    aVar2.atu("");
                }
                com.tencent.mm.ui.widget.a.e eVar5 = this.uhy.uhm;
                if (eVar5 != null) {
                    eVar5.bMo();
                }
                com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.a(s.f.CLICK_LIKE, "");
                AppMethodBeat.o(245954);
                return;
            }
            int i5 = this.uhy.ugV;
            if (valueOf != null && valueOf.intValue() == i5) {
                TextView textView2 = this.uhy.uhb;
                if (textView2 != null) {
                    textView2.setText(menuItem.getTitle());
                }
                this.uhy.ugE = 3;
                d.a aVar3 = this.uhy.ugO;
                if (aVar3 != null) {
                    aVar3.IZ(this.uhy.ugE);
                }
                d.a aVar4 = this.uhy.ugO;
                if (aVar4 != null) {
                    aVar4.atu("");
                }
                com.tencent.mm.ui.widget.a.e eVar6 = this.uhy.uhm;
                if (eVar6 != null) {
                    eVar6.bMo();
                    AppMethodBeat.o(245954);
                    return;
                }
                AppMethodBeat.o(245954);
                return;
            }
            int i6 = this.uhy.ugS;
            if (valueOf != null && valueOf.intValue() == i6) {
                TextView textView3 = this.uhy.uhb;
                if (textView3 != null) {
                    textView3.setText(menuItem.getTitle());
                }
                this.uhy.ugE = 1;
                d.a aVar5 = this.uhy.ugO;
                if (aVar5 != null) {
                    aVar5.IZ(this.uhy.ugE);
                }
                d.a aVar6 = this.uhy.ugO;
                if (aVar6 != null) {
                    aVar6.atu("");
                }
                com.tencent.mm.ui.widget.a.e eVar7 = this.uhy.uhn;
                if (eVar7 != null) {
                    eVar7.bMo();
                }
                com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.a(s.f.CLICK_ANY_COMMENT, "");
                AppMethodBeat.o(245954);
                return;
            }
            int i7 = this.uhy.ugT;
            if (valueOf == null) {
                AppMethodBeat.o(245954);
                return;
            }
            if (valueOf.intValue() == i7) {
                com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.a(s.f.CLICK_SPECIFY_COMMENT_CONTENT, "");
                f fVar2 = this.uhy;
                ViewGroup viewGroup = fVar2.uhq;
                if (viewGroup != null) {
                    viewGroup.setVisibility(0);
                }
                EditText editText = fVar2.uhu;
                if (editText != null) {
                    editText.post(new o(fVar2));
                }
                com.tencent.mm.ui.widget.a.e eVar8 = this.uhy.uhn;
                if (eVar8 != null) {
                    eVar8.bMo();
                    AppMethodBeat.o(245954);
                    return;
                }
            }
            AppMethodBeat.o(245954);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class o implements Runnable {
        final /* synthetic */ f uhy;

        o(f fVar) {
            this.uhy = fVar;
        }

        public final void run() {
            AppMethodBeat.i(245955);
            EditText editText = this.uhy.uhu;
            if (editText != null) {
                editText.requestFocus();
            }
            f.e(this.uhy.uhu);
            AppMethodBeat.o(245955);
        }
    }

    /* access modifiers changed from: package-private */
    public final void dfi() {
        AppMethodBeat.i(245965);
        ViewGroup viewGroup = this.uhq;
        if (viewGroup != null) {
            viewGroup.setVisibility(4);
        }
        d(this.uhu);
        AppMethodBeat.o(245965);
    }

    @Override // com.tencent.mm.plugin.finder.live.component.d.b
    public final void N(boolean z, boolean z2) {
        AppMethodBeat.i(245966);
        if (!z) {
            EditText editText = this.uhd;
            Editable text = editText != null ? editText.getText() : null;
            if (!(text == null || text.length() == 0) && z2) {
                TextView textView = this.uhe;
                if (textView != null) {
                    Context context = this.lJI.getContext();
                    kotlin.g.b.p.g(context, "rootView.context");
                    textView.setTextColor(context.getResources().getColor(R.color.q5));
                    AppMethodBeat.o(245966);
                    return;
                }
                AppMethodBeat.o(245966);
                return;
            }
        }
        TextView textView2 = this.uhe;
        if (textView2 != null) {
            Context context2 = this.lJI.getContext();
            kotlin.g.b.p.g(context2, "rootView.context");
            textView2.setTextColor(context2.getResources().getColor(R.color.BW_0_Alpha_0_5));
            AppMethodBeat.o(245966);
            return;
        }
        AppMethodBeat.o(245966);
    }

    @Override // com.tencent.mm.plugin.finder.live.component.d.b
    public final void nk(boolean z) {
        AppMethodBeat.i(245967);
        Log.i(this.TAG, "updateConfirmBtn canConfirm:".concat(String.valueOf(z)));
        Button button = this.nZi;
        if (button != null) {
            button.setEnabled(z);
        }
        a(this.nZi, z);
        AppMethodBeat.o(245967);
    }

    @Override // com.tencent.mm.plugin.finder.live.component.d.b
    public final void destroy() {
        AppMethodBeat.i(260390);
        dfi();
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        com.tencent.mm.plugin.finder.utils.m.bD(this.activity);
        AppMethodBeat.o(260390);
    }

    private final void a(Button button, boolean z) {
        AppMethodBeat.i(245968);
        if (z) {
            if (ao.isDarkMode()) {
                if (button != null) {
                    Context context = this.lJI.getContext();
                    kotlin.g.b.p.g(context, "rootView.context");
                    button.setTextColor(context.getResources().getColor(R.color.BW_100_Alpha_0_8));
                    AppMethodBeat.o(245968);
                    return;
                }
                AppMethodBeat.o(245968);
            } else if (button != null) {
                Context context2 = this.lJI.getContext();
                kotlin.g.b.p.g(context2, "rootView.context");
                button.setTextColor(context2.getResources().getColor(R.color.am));
                AppMethodBeat.o(245968);
            } else {
                AppMethodBeat.o(245968);
            }
        } else if (ao.isDarkMode()) {
            if (button != null) {
                Context context3 = this.lJI.getContext();
                kotlin.g.b.p.g(context3, "rootView.context");
                button.setTextColor(context3.getResources().getColor(R.color.BW_100_Alpha_0_2));
                AppMethodBeat.o(245968);
                return;
            }
            AppMethodBeat.o(245968);
        } else if (button != null) {
            Context context4 = this.lJI.getContext();
            kotlin.g.b.p.g(context4, "rootView.context");
            button.setTextColor(context4.getResources().getColor(R.color.BW_0_Alpha_0_2));
            AppMethodBeat.o(245968);
        } else {
            AppMethodBeat.o(245968);
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.component.d.b
    public final void a(int i2, String str, avp avp) {
        avr avr;
        String str2;
        avr avr2;
        boolean z = false;
        Integer num = null;
        AppMethodBeat.i(245969);
        Log.i(this.TAG, "showErrMsg errorPage is empty:" + ((avp != null ? avp.LCg : null) == null) + ",type:" + ((avp == null || (avr2 = avp.LCg) == null) ? null : Integer.valueOf(avr2.type)) + ",errMsg:" + str);
        if (avp != null) {
            avr = avp.LCg;
        } else {
            avr = null;
        }
        if (avr == null) {
            u.makeText(this.activity, this.lJI.getResources().getString(R.string.cry), 0).show();
            AppMethodBeat.o(245969);
            return;
        }
        avr avr3 = avp != null ? avp.LCg : null;
        if (avr3 != null) {
            num = Integer.valueOf(avr3.type);
        }
        if (num != null && num.intValue() == 1) {
            if (avr3 == null || (str2 = avr3.dQx) == null) {
                str2 = "";
            }
            kotlin.g.b.p.g(str2, "errPage?.wording ?: \"\"");
            String str3 = str2;
            if (str3 == null || str3.length() == 0) {
                z = true;
            }
            if (z) {
                str2 = this.lJI.getResources().getString(R.string.cry);
                kotlin.g.b.p.g(str2, "rootView.resources.getSt…live_create_lottery_fail)");
            }
            com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
            com.tencent.mm.plugin.finder.spam.a.avm(str2);
            AppMethodBeat.o(245969);
        } else if (num == null) {
            AppMethodBeat.o(245969);
        } else {
            if (num.intValue() == 2) {
                if (this.uho == null) {
                    View findViewById = this.lJI.findViewById(R.id.cwh);
                    kotlin.g.b.p.g(findViewById, "rootView.findViewById(R.…nder_live_post_forbidden)");
                    this.uho = new com.tencent.mm.plugin.finder.live.widget.f(findViewById);
                }
                com.tencent.mm.plugin.finder.live.widget.f fVar = this.uho;
                if (fVar != null) {
                    f.c cVar = com.tencent.mm.plugin.finder.live.widget.f.uGx;
                    fVar.a(com.tencent.mm.plugin.finder.live.widget.f.djJ(), avr3, i2, new s(this));
                    AppMethodBeat.o(245969);
                    return;
                }
            }
            AppMethodBeat.o(245969);
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.component.d.b
    public final void atw(String str) {
        AppMethodBeat.i(245970);
        kotlin.g.b.p.h(str, "msg");
        com.tencent.mm.ac.d.h(new p(str));
        AppMethodBeat.o(245970);
    }

    @Override // com.tencent.mm.plugin.finder.live.component.d.b
    public final void initView() {
        View view;
        View view2;
        View view3;
        EditText editText;
        TextView textView;
        Button button;
        TextPaint textPaint;
        AppMethodBeat.i(245960);
        this.uha = this.lJI.findViewById(R.id.vg);
        this.uhb = (TextView) this.lJI.findViewById(R.id.vj);
        this.uhc = (RelativeLayout) this.lJI.findViewById(R.id.bv6);
        this.uhd = (EditText) this.lJI.findViewById(R.id.bv_);
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        com.tencent.mm.plugin.finder.utils.m.a(this.uhd, null, this.ugY, this.ugZ, new C1179f(this));
        this.uhe = (TextView) this.lJI.findViewById(R.id.bv8);
        TextView textView2 = this.uhe;
        if (textView2 != null) {
            ae aeVar = ae.SYK;
            String string = this.activity.getResources().getString(R.string.cv7);
            kotlin.g.b.p.g(string, "activity.resources.getSt…ve_lottery_duration_tips)");
            e.a aVar = e.ugM;
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(e.ugK)}, 1));
            kotlin.g.b.p.g(format, "java.lang.String.format(format, *args)");
            textView2.setText(format);
        }
        this.uhf = (RelativeLayout) this.lJI.findViewById(R.id.jo7);
        this.uhg = (EditText) this.lJI.findViewById(R.id.joa);
        com.tencent.mm.plugin.finder.utils.m mVar2 = com.tencent.mm.plugin.finder.utils.m.vVH;
        com.tencent.mm.plugin.finder.utils.m.a(this.uhg, null, this.ugY, this.ugZ, new g(this));
        this.uhh = this.lJI.findViewById(R.id.bmr);
        this.uhi = (EditText) this.lJI.findViewById(R.id.bn8);
        this.uhj = (TextView) this.lJI.findViewById(R.id.bn0);
        this.uhk = this.lJI.findViewById(R.id.b_5);
        this.uhl = this.lJI.findViewById(R.id.i51);
        this.nZi = (Button) this.lJI.findViewById(R.id.b_4);
        Button button2 = this.nZi;
        ao.a(button2 != null ? button2.getPaint() : null, 0.8f);
        nk(false);
        View view4 = this.uha;
        if (view4 != null) {
            view4.setOnClickListener(new h(this));
        }
        RelativeLayout relativeLayout = this.uhc;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new i(this));
        }
        RelativeLayout relativeLayout2 = this.uhf;
        if (relativeLayout2 != null) {
            relativeLayout2.setOnClickListener(new j(this));
        }
        View view5 = this.uhh;
        if (view5 != null) {
            view5.setOnClickListener(new k(this));
        }
        Button button3 = this.nZi;
        if (button3 != null) {
            button3.setOnClickListener(new l(this));
        }
        com.tencent.mm.plugin.finder.utils.m mVar3 = com.tencent.mm.plugin.finder.utils.m.vVH;
        com.tencent.mm.plugin.finder.utils.m.a(this.uhi, this.uhj, this.ugW, this.ugX, m.uhz);
        Window window = this.activity.getWindow();
        kotlin.g.b.p.g(window, "activity.window");
        View decorView = window.getDecorView();
        if (decorView == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(245960);
            throw tVar;
        }
        this.uhp = LayoutInflater.from(this.activity).inflate(R.layout.ad9, (ViewGroup) decorView, true);
        View view6 = this.uhp;
        this.uhq = view6 != null ? (ViewGroup) view6.findViewById(R.id.dyx) : null;
        ViewGroup viewGroup = this.uhq;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(new a(this));
        }
        ViewGroup viewGroup2 = this.uhq;
        if (viewGroup2 != null) {
            view = viewGroup2.findViewById(R.id.bqn);
        } else {
            view = null;
        }
        this.uhr = view;
        ViewGroup viewGroup3 = this.uhq;
        if (viewGroup3 != null) {
            view2 = viewGroup3.findViewById(R.id.b3z);
        } else {
            view2 = null;
        }
        this.uhs = view2;
        View view7 = this.uhs;
        if (view7 != null) {
            view7.setOnClickListener(new b(this));
        }
        ViewGroup viewGroup4 = this.uhq;
        if (viewGroup4 != null) {
            view3 = viewGroup4.findViewById(R.id.dym);
        } else {
            view3 = null;
        }
        this.uht = view3;
        View view8 = this.uht;
        if (view8 != null) {
            view8.setOnClickListener(new c(this));
        }
        View view9 = this.uht;
        if (view9 != null) {
            editText = (EditText) view9.findViewById(R.id.dyp);
        } else {
            editText = null;
        }
        this.uhu = editText;
        View view10 = this.uht;
        if (view10 != null) {
            textView = (TextView) view10.findViewById(R.id.ea9);
        } else {
            textView = null;
        }
        this.uhv = textView;
        ViewGroup viewGroup5 = this.uhq;
        if (viewGroup5 != null) {
            button = (Button) viewGroup5.findViewById(R.id.d50);
        } else {
            button = null;
        }
        this.uhw = button;
        Button button4 = this.uhw;
        if (button4 != null) {
            textPaint = button4.getPaint();
        } else {
            textPaint = null;
        }
        ao.a(textPaint, 0.8f);
        Button button5 = this.uhw;
        if (button5 != null) {
            button5.setOnClickListener(new d(this));
        }
        nl(false);
        com.tencent.mm.plugin.finder.utils.m mVar4 = com.tencent.mm.plugin.finder.utils.m.vVH;
        com.tencent.mm.plugin.finder.utils.m.a(this.uhu, this.uhv, this.ugW, this.ugX, new e(this));
        ViewGroup viewGroup6 = this.uhq;
        if (viewGroup6 != null) {
            viewGroup6.setVisibility(8);
        }
        dfh();
        AppMethodBeat.o(245960);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.finder.live.component.f$f  reason: collision with other inner class name */
    static final class C1179f extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ f uhy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1179f(f fVar) {
            super(0);
            this.uhy = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(245946);
            this.uhy.dfh();
            x xVar = x.SXb;
            AppMethodBeat.o(245946);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class g extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ f uhy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(f fVar) {
            super(0);
            this.uhy = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(245947);
            this.uhy.dfh();
            x xVar = x.SXb;
            AppMethodBeat.o(245947);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ f uhy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(f fVar) {
            super(0);
            this.uhy = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            String str;
            boolean z;
            boolean z2;
            Editable text;
            AppMethodBeat.i(245945);
            f fVar = this.uhy;
            y yVar = y.vXH;
            EditText editText = this.uhy.uhu;
            if (editText == null || (text = editText.getText()) == null || (str = text.toString()) == null) {
                str = "";
            }
            String awt = y.awt(str);
            if (awt == null || awt.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                z2 = true;
            } else {
                z2 = false;
            }
            fVar.nl(z2);
            x xVar = x.SXb;
            AppMethodBeat.o(245945);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class p extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ String uhA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(String str) {
            super(0);
            this.uhA = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(245956);
            com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
            com.tencent.mm.plugin.finder.spam.a.avm(this.uhA);
            x xVar = x.SXb;
            AppMethodBeat.o(245956);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0098  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dfh() {
        /*
        // Method dump skipped, instructions count: 156
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.component.f.dfh():void");
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.c
    public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
        return this.activity;
    }

    public static final /* synthetic */ void e(EditText editText) {
        Context context;
        AppMethodBeat.i(245972);
        InputMethodManager inputMethodManager = (InputMethodManager) ((editText == null || (context = editText.getContext()) == null) ? null : context.getSystemService("input_method"));
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(editText, 0);
            AppMethodBeat.o(245972);
            return;
        }
        AppMethodBeat.o(245972);
    }
}
