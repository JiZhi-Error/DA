package com.tencent.mm.plugin.multitask.ui.minusscreen.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.view.u;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.as;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitask.ui.uic.MultiTaskUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u000e\u0018\u0000 }2\u00020\u0001:\u0004|}~B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u0013H\u0016J\u0010\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u0013H\u0016J8\u0010I\u001a\u00020D2\u0006\u0010J\u001a\u00020\u00132\u0006\u0010K\u001a\u00020\u00132\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020M2\u0006\u0010O\u001a\u00020M2\u0006\u0010P\u001a\u00020MH\u0016J\u0012\u0010Q\u001a\u00020G2\n\u0010R\u001a\u00060 R\u00020\u0000J\u001c\u0010S\u001a\u00020G2\u0006\u0010H\u001a\u00020\u00132\n\u0010T\u001a\u00060$R\u00020\u0000H\u0016J0\u0010U\u001a\u00020D2\u0006\u0010H\u001a\u00020\u00132\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020M2\u0006\u0010O\u001a\u00020M2\u0006\u0010P\u001a\u00020MH\u0016J6\u0010V\u001a\u00020D2\u0006\u0010H\u001a\u00020\u00132\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020M2\u0006\u0010O\u001a\u00020M2\u0006\u0010P\u001a\u00020M2\u0006\u0010W\u001a\u00020MJ6\u0010X\u001a\u00020D2\u0006\u0010H\u001a\u00020\u00132\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020M2\u0006\u0010O\u001a\u00020M2\u0006\u0010P\u001a\u00020M2\u0006\u0010W\u001a\u00020MJ6\u0010Y\u001a\u00020D2\u0006\u0010H\u001a\u00020\u00132\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020M2\u0006\u0010O\u001a\u00020M2\u0006\u0010P\u001a\u00020M2\u0006\u0010Z\u001a\u00020MJ6\u0010[\u001a\u00020G2\u0006\u0010H\u001a\u00020\u00132\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020M2\u0006\u0010O\u001a\u00020M2\u0006\u0010P\u001a\u00020M2\u0006\u0010W\u001a\u00020MJ \u0010\\\u001a\u00020D2\u0006\u0010E\u001a\u00020\u00132\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020^H\u0016J\u0010\u0010`\u001a\u00020D2\u0006\u0010E\u001a\u00020\u0013H\u0016J\u0010\u0010a\u001a\u00020G2\u0006\u0010H\u001a\u00020\u0013H\u0014J\u001e\u0010b\u001a\u00020D2\u0006\u0010E\u001a\u00020\u00132\f\u0010c\u001a\b\u0012\u0004\u0012\u00020e0dH\u0016J\u0016\u0010f\u001a\u00020G2\u000e\u0010g\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130dJ \u0010h\u001a\u00020G2\u0006\u0010i\u001a\u00020D2\u0006\u0010j\u001a\u00020D2\u0006\u0010k\u001a\u00020DH\u0002J\u0006\u0010l\u001a\u00020GJ\u0010\u0010m\u001a\u00020G2\u0006\u0010n\u001a\u00020\u0013H\u0016J\b\u0010o\u001a\u00020GH\u0016J\"\u0010p\u001a\u00020G2\u0010\u0010q\u001a\f\u0012\b\u0012\u00060 R\u00020\u00000r2\u0006\u0010n\u001a\u00020\u0013H\u0002J\u0014\u0010s\u001a\u00020G2\n\u0010R\u001a\u00060 R\u00020\u0000H\u0002J\u001e\u0010s\u001a\u00020D2\n\u0010R\u001a\u00060 R\u00020\u00002\b\u0010n\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010t\u001a\u00020DH\u0002J\b\u0010u\u001a\u00020DH\u0002J\b\u0010v\u001a\u00020DH\u0002J\b\u0010w\u001a\u00020DH\u0002J\b\u0010x\u001a\u00020DH\u0016J\u0010\u0010y\u001a\u00020G2\u0006\u0010E\u001a\u00020\u0013H\u0016J\u0010\u0010z\u001a\u00020G2\u0006\u0010H\u001a\u00020\u0013H\u0004J\b\u0010{\u001a\u00020GH\u0016R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8TX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8DX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR.\u0010\u0011\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0013`\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018RJ\u0010\u0019\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00140\u0012j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014`\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R.\u0010\u001c\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0013`\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018RZ\u0010\u001f\u001aB\u0012\u001c\u0012\u001a\u0012\b\u0012\u00060 R\u00020\u00000\u0012j\f\u0012\b\u0012\u00060 R\u00020\u0000`\u00140\u0012j \u0012\u001c\u0012\u001a\u0012\b\u0012\u00060 R\u00020\u00000\u0012j\f\u0012\b\u0012\u00060 R\u00020\u0000`\u0014`\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018RZ\u0010#\u001aB\u0012\u001c\u0012\u001a\u0012\b\u0012\u00060$R\u00020\u00000\u0012j\f\u0012\b\u0012\u00060$R\u00020\u0000`\u00140\u0012j \u0012\u001c\u0012\u001a\u0012\b\u0012\u00060$R\u00020\u00000\u0012j\f\u0012\b\u0012\u00060$R\u00020\u0000`\u0014`\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R.\u0010'\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0013`\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0016\"\u0004\b)\u0010\u0018RZ\u0010*\u001aB\u0012\u001c\u0012\u001a\u0012\b\u0012\u00060+R\u00020\u00000\u0012j\f\u0012\b\u0012\u00060+R\u00020\u0000`\u00140\u0012j \u0012\u001c\u0012\u001a\u0012\b\u0012\u00060+R\u00020\u00000\u0012j\f\u0012\b\u0012\u00060+R\u00020\u0000`\u0014`\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R*\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0016\"\u0004\b0\u0010\u0018R)\u00101\u001a\u001a\u0012\b\u0012\u00060 R\u00020\u00000\u0012j\f\u0012\b\u0012\u00060 R\u00020\u0000`\u0014¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0016R)\u00103\u001a\u001a\u0012\b\u0012\u00060+R\u00020\u00000\u0012j\f\u0012\b\u0012\u00060+R\u00020\u0000`\u0014¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0016R*\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0016\"\u0004\b7\u0010\u0018R.\u00108\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0013`\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0016\"\u0004\b:\u0010\u0018R\u0014\u0010;\u001a\u00020\f8DX\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020\f8TX\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\u000e¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator;", "Landroid/support/v7/widget/SimpleItemAnimator;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onItemListener", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "(Landroid/support/v7/widget/RecyclerView;Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "addDelay", "", "getAddDelay", "()J", "changeDelay", "getChangeDelay", "mAddAnimations", "Ljava/util/ArrayList;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Lkotlin/collections/ArrayList;", "getMAddAnimations", "()Ljava/util/ArrayList;", "setMAddAnimations", "(Ljava/util/ArrayList;)V", "mAdditionsList", "getMAdditionsList", "setMAdditionsList", "mChangeAnimations", "getMChangeAnimations", "setMChangeAnimations", "mChangesList", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$ChangeInfo;", "getMChangesList", "setMChangesList", "mLayoutsList", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$LayoutInfo;", "getMLayoutsList", "setMLayoutsList", "mMoveAnimations", "getMMoveAnimations", "setMMoveAnimations", "mMovesList", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$MoveInfo;", "getMMovesList", "setMMovesList", "mPendingAdditions", "getMPendingAdditions", "setMPendingAdditions", "mPendingChanges", "getMPendingChanges", "mPendingMoves", "getMPendingMoves", "mPendingRemovals", "getMPendingRemovals", "setMPendingRemovals", "mRemoveAnimations", "getMRemoveAnimations", "setMRemoveAnimations", "moveDelay", "getMoveDelay", "getOnItemListener", "()Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "removeDelay", "getRemoveDelay", "animateAdd", "", "viewHolder", "animateAddImpl", "", "holder", "animateChange", "oldHolder", "newHolder", "fromX", "", "fromY", "toX", "toY", "animateChangeImpl", "changeInfo", "animateLayoutImpl", "info", "animateMove", "animateMove1", "moveType", "animateMove2", "animateMove3", "finalY", "animateMoveImpl", "animatePersistence", "preInfo", "Landroid/support/v7/widget/RecyclerView$ItemAnimator$ItemHolderInfo;", "postInfo", "animateRemove", "animateRemoveImpl", "canReuseUpdatedViewHolder", "payloads", "", "", "cancelAll", "viewHolders", "checkRefreshLayout", "removalsPending", "movesPending", "changesPending", "dispatchFinishedWhenDone", "endAnimation", "item", "endAnimations", "endChangeAnimation", "infoList", "", "endChangeAnimationIfNecessary", "isAddAnimation", "isChangeAnimation", "isMoveAnimation", "isRemoveAnimation", "isRunning", "onAnimationFinished", "resetAnimation", "runPendingAnimations", "ChangeInfo", "Companion", "LayoutInfo", "MoveInfo", "ui-multitask_release"})
public final class a extends as {
    public static final b AdS = new b((byte) 0);
    private static TimeInterpolator amk;
    ArrayList<ArrayList<c>> AdQ = new ArrayList<>();
    private final com.tencent.mm.plugin.multitask.ui.minusscreen.d.a AdR;
    final String TAG = "MicroMsg.MultiTask.MinusAnimator";
    private ArrayList<RecyclerView.v> aml = new ArrayList<>();
    private ArrayList<RecyclerView.v> amm = new ArrayList<>();
    private final ArrayList<d> amn = new ArrayList<>();
    private final ArrayList<C1526a> amo = new ArrayList<>();
    ArrayList<ArrayList<RecyclerView.v>> amp = new ArrayList<>();
    ArrayList<ArrayList<d>> amq = new ArrayList<>();
    ArrayList<ArrayList<C1526a>> amr = new ArrayList<>();
    ArrayList<RecyclerView.v> ams = new ArrayList<>();
    ArrayList<RecyclerView.v> amt = new ArrayList<>();
    ArrayList<RecyclerView.v> amu = new ArrayList<>();
    ArrayList<RecyclerView.v> amv = new ArrayList<>();
    final RecyclerView hak;

    static {
        AppMethodBeat.i(236500);
        AppMethodBeat.o(236500);
    }

    public a(RecyclerView recyclerView, com.tencent.mm.plugin.multitask.ui.minusscreen.d.a aVar) {
        p.h(recyclerView, "recyclerView");
        AppMethodBeat.i(236499);
        this.hak = recyclerView;
        this.AdR = aVar;
        AppMethodBeat.o(236499);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0004\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000e¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$MoveInfo;", "", "holder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "fromX", "", "fromY", "toX", "toY", "moveType", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator;Landroid/support/v7/widget/RecyclerView$ViewHolder;IIIII)V", "getFromX", "()I", "setFromX", "(I)V", "getFromY", "setFromY", "getHolder", "()Landroid/support/v7/widget/RecyclerView$ViewHolder;", "setHolder", "(Landroid/support/v7/widget/RecyclerView$ViewHolder;)V", "getMoveType", "getToX", "setToX", "getToY", "setToY", "ui-multitask_release"})
    public final class d {
        final /* synthetic */ a AdV;
        int amK;
        int amL;
        int amM;
        int amN;
        RecyclerView.v amO;
        final int oMi;

        public /* synthetic */ d(a aVar, RecyclerView.v vVar, int i2, int i3, int i4, int i5) {
            this(aVar, vVar, i2, i3, i4, i5, 0);
        }

        public d(a aVar, RecyclerView.v vVar, int i2, int i3, int i4, int i5, int i6) {
            p.h(vVar, "holder");
            this.AdV = aVar;
            AppMethodBeat.i(236457);
            this.amO = vVar;
            this.amK = i2;
            this.amL = i3;
            this.amM = i4;
            this.amN = i5;
            this.oMi = i6;
            AppMethodBeat.o(236457);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0019\b\u0004\u0018\u00002\u00020\u0001BI\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001a\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R\u001a\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$ChangeInfo;", "", "oldHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "newHolder", "fromX", "", "fromY", "toX", "toY", "newTransX", "", "newTransY", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator;Landroid/support/v7/widget/RecyclerView$ViewHolder;Landroid/support/v7/widget/RecyclerView$ViewHolder;IIIIFF)V", "getFromX", "()I", "setFromX", "(I)V", "getFromY", "setFromY", "getNewHolder", "()Landroid/support/v7/widget/RecyclerView$ViewHolder;", "setNewHolder", "(Landroid/support/v7/widget/RecyclerView$ViewHolder;)V", "getNewTransX", "()F", "setNewTransX", "(F)V", "getNewTransY", "setNewTransY", "getOldHolder", "setOldHolder", "getToX", "setToX", "getToY", "setToY", "ui-multitask_release"})
    /* renamed from: com.tencent.mm.plugin.multitask.ui.minusscreen.a.a$a  reason: collision with other inner class name */
    public final class C1526a {
        float AdT;
        float AdU;
        RecyclerView.v amI;
        RecyclerView.v amJ;
        int amK;
        int amL;
        int amM;
        int amN;

        public C1526a(RecyclerView.v vVar, RecyclerView.v vVar2, int i2, int i3, int i4, int i5, float f2, float f3) {
            this.amI = vVar;
            this.amJ = vVar2;
            this.amK = i2;
            this.amL = i3;
            this.amM = i4;
            this.amN = i5;
            this.AdT = f2;
            this.AdU = f3;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0004\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$LayoutInfo;", "", "holder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "fromWidth", "", "toWidth", "animator", "Landroid/animation/ValueAnimator;", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator;Landroid/support/v7/widget/RecyclerView$ViewHolder;IILandroid/animation/ValueAnimator;)V", "getAnimator", "()Landroid/animation/ValueAnimator;", "setAnimator", "(Landroid/animation/ValueAnimator;)V", "getFromWidth", "()I", "setFromWidth", "(I)V", "getHolder", "()Landroid/support/v7/widget/RecyclerView$ViewHolder;", "setHolder", "(Landroid/support/v7/widget/RecyclerView$ViewHolder;)V", "getToWidth", "setToWidth", "ui-multitask_release"})
    public final class c {
        final /* synthetic */ a AdV;
        int AdW;
        int AdX;
        RecyclerView.v amO;
        ValueAnimator animator;

        /* JADX WARN: Incorrect types in method signature: (Landroid/support/v7/widget/RecyclerView$v;IILandroid/animation/ValueAnimator;)V */
        private c(a aVar, RecyclerView.v vVar, int i2, int i3) {
            p.h(vVar, "holder");
            this.AdV = aVar;
            AppMethodBeat.i(236456);
            this.amO = vVar;
            this.AdW = i2;
            this.AdX = i3;
            this.animator = null;
            AppMethodBeat.o(236456);
        }

        public /* synthetic */ c(a aVar, RecyclerView.v vVar, int i2, int i3, byte b2) {
            this(aVar, vVar, i2, i3);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public final void jD() {
        boolean z;
        boolean z2;
        boolean z3;
        RecyclerView.v vVar;
        AppMethodBeat.i(236478);
        Log.d(this.TAG, "runPendingAnimations");
        boolean z4 = !this.aml.isEmpty();
        if (!this.amn.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (!this.amo.isEmpty()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!this.amm.isEmpty()) {
            z3 = true;
        } else {
            z3 = false;
        }
        Iterator<RecyclerView.v> it = this.aml.iterator();
        while (it.hasNext()) {
            RecyclerView.v next = it.next();
            p.g(next, "holder");
            p.h(next, "holder");
            View view = next.aus;
            p.g(view, "holder.itemView");
            ViewPropertyAnimator animate = view.animate();
            this.amu.add(next);
            animate.setDuration(ly()).alpha(0.0f).setListener(new k(this, next, animate, view)).start();
        }
        this.aml.clear();
        if (z) {
            ArrayList<d> arrayList = new ArrayList<>();
            arrayList.addAll(this.amn);
            this.amq.add(arrayList);
            this.amn.clear();
            o oVar = new o(this, arrayList);
            if (z4) {
                View view2 = arrayList.get(0).amO.aus;
                p.g(view2, "moves[0].holder.itemView");
                u.a(view2, oVar, ly());
            } else {
                oVar.run();
            }
        }
        if (z2) {
            ArrayList<C1526a> arrayList2 = new ArrayList<>();
            arrayList2.addAll(this.amo);
            this.amr.add(arrayList2);
            this.amo.clear();
            n nVar = new n(this, arrayList2);
            if (!z4 || (vVar = arrayList2.get(0).amI) == null) {
                nVar.run();
            } else {
                u.a(vVar.aus, nVar, ly());
            }
        }
        if (z3) {
            ArrayList<RecyclerView.v> arrayList3 = new ArrayList<>();
            arrayList3.addAll(this.amm);
            this.amp.add(arrayList3);
            this.amm.clear();
            m mVar = new m(this, arrayList3);
            if (z4 || z || z2) {
                View view3 = arrayList3.get(0).aus;
                p.g(view3, "additions[0].itemView");
                u.a(view3, mVar, ly());
            } else {
                mVar.run();
            }
        }
        l(z4, z, z2);
        AppMethodBeat.o(236478);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class o implements Runnable {
        final /* synthetic */ a AdV;
        final /* synthetic */ ArrayList Aem;

        o(a aVar, ArrayList arrayList) {
            this.AdV = aVar;
            this.Aem = arrayList;
        }

        public final void run() {
            AppMethodBeat.i(236477);
            Iterator it = this.Aem.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                a aVar = this.AdV;
                RecyclerView.v vVar = dVar.amO;
                int i2 = dVar.amK;
                int i3 = dVar.amL;
                int i4 = dVar.amM;
                int i5 = dVar.amN;
                int i6 = dVar.oMi;
                p.h(vVar, "holder");
                String str = aVar.TAG;
                StringBuilder append = new StringBuilder("animateMoveImpl pos:").append(vVar.lR()).append(" fromX:").append(i2).append(" fromY:").append(i3).append(" toX:").append(i4).append(" toY:").append(i5).append(" holder.left:");
                View view = vVar.aus;
                p.g(view, "holder.itemView");
                StringBuilder append2 = append.append(view.getLeft()).append(" holder.top:");
                View view2 = vVar.aus;
                p.g(view2, "holder.itemView");
                Log.d(str, append2.append(view2.getTop()).toString());
                RecyclerView.a adapter = aVar.hak.getAdapter();
                int itemCount = adapter != null ? adapter.getItemCount() : 0;
                View view3 = vVar.aus;
                p.g(view3, "holder.itemView");
                int i7 = i4 - i2;
                int i8 = i5 - i3;
                if (i7 != 0) {
                    if (itemCount <= 3 && i6 == 1) {
                        view3.animate().translationX((float) i4);
                    } else if (itemCount > 3 || i6 != 2) {
                        view3.animate().translationX(0.0f);
                    } else {
                        view3.animate().translationX(0.0f);
                    }
                }
                if (i8 != 0) {
                    if (itemCount <= 3 && i6 == 1) {
                        view3.animate().translationY((float) i5);
                    } else if (itemCount > 3 || i6 != 2) {
                        view3.animate().translationY(0.0f);
                    } else {
                        view3.animate().translationY((float) i5);
                    }
                }
                ViewPropertyAnimator animate = view3.animate();
                aVar.amt.add(vVar);
                animate.setDuration(aVar.lv()).setListener(new j(aVar, vVar, i7, view3, i8, animate)).start();
            }
            this.Aem.clear();
            this.AdV.amq.remove(this.Aem);
            AppMethodBeat.o(236477);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class n implements Runnable {
        final /* synthetic */ a AdV;
        final /* synthetic */ ArrayList Ael;

        n(a aVar, ArrayList arrayList) {
            this.AdV = aVar;
            this.Ael = arrayList;
        }

        public final void run() {
            View view;
            View view2;
            AppMethodBeat.i(236476);
            Iterator it = this.Ael.iterator();
            while (it.hasNext()) {
                C1526a aVar = (C1526a) it.next();
                a aVar2 = this.AdV;
                p.g(aVar, "change");
                p.h(aVar, "changeInfo");
                RecyclerView.v vVar = aVar.amI;
                if (vVar != null) {
                    view = vVar.aus;
                } else {
                    view = null;
                }
                RecyclerView.v vVar2 = aVar.amJ;
                if (vVar2 != null) {
                    view2 = vVar2.aus;
                } else {
                    view2 = null;
                }
                float f2 = aVar.AdT;
                float f3 = aVar.AdU;
                if (view != null) {
                    ViewPropertyAnimator duration = view.animate().setDuration(aVar2.lA());
                    aVar2.amv.add(aVar.amI);
                    duration.translationX(((float) aVar.amM) - ((float) aVar.amK));
                    duration.translationY(((float) aVar.amN) - ((float) aVar.amL));
                    duration.alpha(0.0f).setListener(new f(aVar2, aVar, duration, view, f2, f3)).start();
                }
                if (view2 != null) {
                    ViewPropertyAnimator animate = view2.animate();
                    aVar2.amv.add(aVar.amJ);
                    animate.translationX(0.0f).translationY(0.0f).setDuration(aVar2.lA()).alpha(1.0f).setListener(new g(aVar2, aVar, animate, view2, f2, f3)).start();
                }
            }
            this.Ael.clear();
            this.AdV.amr.remove(this.Ael);
            AppMethodBeat.o(236476);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class m implements Runnable {
        final /* synthetic */ a AdV;
        final /* synthetic */ ArrayList Aek;

        m(a aVar, ArrayList arrayList) {
            this.AdV = aVar;
            this.Aek = arrayList;
        }

        public final void run() {
            AppMethodBeat.i(236475);
            Iterator it = this.Aek.iterator();
            while (it.hasNext()) {
                RecyclerView.v vVar = (RecyclerView.v) it.next();
                a aVar = this.AdV;
                p.g(vVar, "holder");
                p.h(vVar, "holder");
                View view = vVar.aus;
                p.g(view, "holder.itemView");
                ViewPropertyAnimator animate = view.animate();
                aVar.ams.add(vVar);
                animate.alpha(1.0f).setDuration(aVar.lx()).setListener(new e(aVar, vVar, view, animate)).start();
            }
            this.Aek.clear();
            this.AdV.amp.remove(this.Aek);
            AppMethodBeat.o(236475);
        }
    }

    private final void l(boolean z, boolean z2, boolean z3) {
        RecyclerView.v vVar;
        View view;
        AppMethodBeat.i(236479);
        RecyclerView.a adapter = this.hak.getAdapter();
        int itemCount = adapter != null ? adapter.getItemCount() : 0;
        if (itemCount >= 2) {
            ArrayList<c> arrayList = new ArrayList<>();
            if (itemCount == 2) {
                int childCount = this.hak.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = this.hak.getChildAt(i2);
                    RecyclerView.v bu = this.hak.bu(childAt);
                    if (bu != null) {
                        com.tencent.mm.view.recyclerview.h hVar = (com.tencent.mm.view.recyclerview.h) (!(bu instanceof com.tencent.mm.view.recyclerview.h) ? null : bu);
                        if (!(hVar == null || ((com.tencent.mm.plugin.multitask.ui.minusscreen.b.a) hVar.hgv()) == null)) {
                            p.g(childAt, "child");
                            int width = childAt.getWidth();
                            MultiTaskUIC.a aVar = MultiTaskUIC.Ago;
                            if (width < MultiTaskUIC.AfY) {
                                p.g(bu, "viewHolder");
                                View view2 = bu.aus;
                                p.g(view2, "viewHolder.itemView");
                                int width2 = view2.getWidth();
                                MultiTaskUIC.a aVar2 = MultiTaskUIC.Ago;
                                arrayList.add(new c(this, bu, width2, MultiTaskUIC.AfY, (byte) 0));
                            }
                        }
                    }
                }
            } else if (itemCount >= 3) {
                int childCount2 = this.hak.getChildCount();
                for (int i3 = 0; i3 < childCount2; i3++) {
                    View childAt2 = this.hak.getChildAt(i3);
                    RecyclerView.v bu2 = this.hak.bu(childAt2);
                    if (bu2 != null) {
                        com.tencent.mm.view.recyclerview.h hVar2 = (com.tencent.mm.view.recyclerview.h) (!(bu2 instanceof com.tencent.mm.view.recyclerview.h) ? null : bu2);
                        if (!(hVar2 == null || ((com.tencent.mm.plugin.multitask.ui.minusscreen.b.a) hVar2.hgv()) == null)) {
                            p.g(childAt2, "child");
                            int width3 = childAt2.getWidth();
                            MultiTaskUIC.a aVar3 = MultiTaskUIC.Ago;
                            if (width3 > MultiTaskUIC.qmd) {
                                p.g(bu2, "viewHolder");
                                View view3 = bu2.aus;
                                p.g(view3, "viewHolder.itemView");
                                int width4 = view3.getWidth();
                                MultiTaskUIC.a aVar4 = MultiTaskUIC.Ago;
                                arrayList.add(new c(this, bu2, width4, MultiTaskUIC.qmd, (byte) 0));
                            }
                        }
                    }
                }
            }
            this.AdQ.add(arrayList);
            l lVar = new l(this, arrayList);
            if (z || z2 || z3) {
                c cVar = (c) kotlin.a.j.kt(arrayList);
                if (cVar == null || (vVar = cVar.amO) == null || (view = vVar.aus) == null) {
                    AppMethodBeat.o(236479);
                    return;
                }
                u.a(view, lVar, ly());
                AppMethodBeat.o(236479);
                return;
            }
            lVar.run();
        }
        AppMethodBeat.o(236479);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class l implements Runnable {
        final /* synthetic */ a AdV;
        final /* synthetic */ ArrayList Aej;

        l(a aVar, ArrayList arrayList) {
            this.AdV = aVar;
            this.Aej = arrayList;
        }

        public final void run() {
            AppMethodBeat.i(236474);
            Iterator it = this.Aej.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                a aVar = this.AdV;
                RecyclerView.v vVar = cVar.amO;
                p.g(cVar, "info");
                p.h(vVar, "holder");
                p.h(cVar, "info");
                View view = vVar.aus;
                p.g(view, "holder.itemView");
                View findViewById = vVar.aus.findViewById(R.id.fnq);
                Log.d(aVar.TAG, "animateLayoutImpl adapterPosition:" + vVar.lR() + " width:" + view.getLayoutParams().width + " height:" + view.getLayoutParams().height + " fromWidth:" + cVar.AdW + " toWidth:" + cVar.AdX);
                if (Math.abs(cVar.AdW - cVar.AdX) > 1) {
                    ValueAnimator ofInt = ValueAnimator.ofInt(cVar.AdW, cVar.AdX);
                    ofInt.addUpdateListener(new h(aVar, findViewById, view, cVar));
                    ofInt.addListener(new i(ofInt, aVar, findViewById, view, cVar));
                    p.g(ofInt, LocaleUtil.ITALIAN);
                    ofInt.setDuration(aVar.lv());
                    ofInt.start();
                    cVar.animator = ofInt;
                } else {
                    p.g(findViewById, "imgView");
                    ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                    int i2 = cVar.AdX;
                    MultiTaskUIC.a aVar2 = MultiTaskUIC.Ago;
                    MultiTaskUIC.a aVar3 = MultiTaskUIC.Ago;
                    layoutParams.height = kotlin.h.a.cR(((float) (i2 - MultiTaskUIC.AfV)) * MultiTaskUIC.Agn);
                    view.getLayoutParams().width = cVar.AdX;
                    ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                    MultiTaskUIC.a aVar4 = MultiTaskUIC.Ago;
                    layoutParams2.height = kotlin.h.a.cR(((float) cVar.AdX) * MultiTaskUIC.scale);
                    view.requestLayout();
                }
            }
            this.Aej.clear();
            this.AdV.AdQ.remove(this.Aej);
            AppMethodBeat.o(236474);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.f, android.support.v7.widget.as
    public final boolean f(RecyclerView.v vVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        RecyclerView.a adapter;
        RecyclerView.a adapter2;
        AppMethodBeat.i(236480);
        p.h(vVar, "viewHolder");
        p.h(cVar, "preInfo");
        p.h(cVar2, "postInfo");
        Log.d(this.TAG, "animatePersistence layoutPosition:" + vVar.lQ() + " adapterPosition:" + vVar.lR() + " hashCode:" + vVar.hashCode());
        if (cVar.left != cVar2.left || cVar.top != cVar2.top) {
            if (!erD()) {
                RecyclerView.a adapter3 = this.hak.getAdapter();
                if (adapter3 != null && adapter3.getItemCount() == 2 && vVar.lR() == 1) {
                    int i2 = cVar.left;
                    int i3 = cVar.top;
                    MultiTaskUIC.a aVar = MultiTaskUIC.Ago;
                    int i4 = MultiTaskUIC.Agf;
                    MultiTaskUIC.a aVar2 = MultiTaskUIC.Ago;
                    b(vVar, i2, i3, i4, MultiTaskUIC.Age);
                    AppMethodBeat.o(236480);
                    return true;
                }
                RecyclerView.a adapter4 = this.hak.getAdapter();
                if (adapter4 != null && adapter4.getItemCount() == 3) {
                    if (vVar.lR() == 1) {
                        int i5 = cVar.left;
                        int i6 = cVar.top;
                        MultiTaskUIC.a aVar3 = MultiTaskUIC.Ago;
                        b(vVar, i5, i6, 0, MultiTaskUIC.Agh);
                        AppMethodBeat.o(236480);
                        return true;
                    } else if (vVar.lR() == 2) {
                        int i7 = cVar.left;
                        int i8 = cVar.top;
                        int i9 = cVar2.left;
                        int i10 = cVar2.top;
                        MultiTaskUIC.a aVar4 = MultiTaskUIC.Ago;
                        a(vVar, i7, i8, i9, i10, MultiTaskUIC.Agh);
                        AppMethodBeat.o(236480);
                        return true;
                    }
                }
            }
            if (erD() && (adapter = this.hak.getAdapter()) != null && adapter.getItemCount() == 3) {
                vVar.lR();
                if (vVar.lR() == 2) {
                    int i11 = cVar.left;
                    int i12 = cVar.top;
                    int i13 = cVar2.left;
                    int i14 = cVar2.top;
                    MultiTaskUIC.a aVar5 = MultiTaskUIC.Ago;
                    a(vVar, i11, i12, i13, i14, MultiTaskUIC.Agh);
                    AppMethodBeat.o(236480);
                    return true;
                }
            }
            boolean a2 = a(vVar, cVar.left, cVar.top, cVar2.left, cVar2.top);
            AppMethodBeat.o(236480);
            return a2;
        } else if (erD() || (adapter2 = this.hak.getAdapter()) == null || adapter2.getItemCount() != 2 || vVar.lR() != 1) {
            x(vVar);
            AppMethodBeat.o(236480);
            return false;
        } else {
            int i15 = cVar.left;
            int i16 = cVar.top;
            MultiTaskUIC.a aVar6 = MultiTaskUIC.Ago;
            int i17 = MultiTaskUIC.Agf;
            MultiTaskUIC.a aVar7 = MultiTaskUIC.Ago;
            int i18 = MultiTaskUIC.Age;
            p.h(vVar, "holder");
            View view = vVar.aus;
            p.g(view, "holder.itemView");
            View view2 = vVar.aus;
            p.g(view2, "holder.itemView");
            int translationX = ((int) view2.getTranslationX()) + i15;
            View view3 = vVar.aus;
            p.g(view3, "holder.itemView");
            int translationY = i16 + ((int) view3.getTranslationY());
            e(vVar);
            View view4 = vVar.aus;
            p.g(view4, "holder.itemView");
            int left = translationX - view4.getLeft();
            View view5 = vVar.aus;
            p.g(view5, "holder.itemView");
            int top = translationY - view5.getTop();
            if (left != 0) {
                view.setTranslationX((float) left);
            }
            if (top != 0) {
                view.setTranslationY((float) top);
            }
            this.amn.add(new d(this, vVar, translationX, translationY, i17, i18, 1));
            String str = this.TAG;
            StringBuilder append = new StringBuilder("animateMove2 fromX:").append(translationX).append(" fromY:").append(translationY).append(" toX:").append(i17).append(" toY:").append(i18).append(" deltaX:").append(left).append(" deltaY:").append(top).append(" holder.left:");
            View view6 = vVar.aus;
            p.g(view6, "holder.itemView");
            StringBuilder append2 = append.append(view6.getLeft()).append(" holder.top:");
            View view7 = vVar.aus;
            p.g(view7, "holder.itemView");
            Log.d(str, append2.append(view7.getTop()).append(" holder.position:").append(vVar.lR()).toString());
            AppMethodBeat.o(236480);
            return true;
        }
    }

    private final boolean erD() {
        AppMethodBeat.i(236481);
        if (this.amm.size() > 0) {
            AppMethodBeat.o(236481);
            return true;
        }
        AppMethodBeat.o(236481);
        return false;
    }

    @Override // android.support.v7.widget.as
    public final boolean b(RecyclerView.v vVar) {
        RecyclerView.v ch;
        AppMethodBeat.i(236482);
        p.h(vVar, "viewHolder");
        Log.d(this.TAG, "animateRemove layoutPosition:" + vVar.lQ() + " adapterPosition:" + vVar.lR() + " hashCode:" + vVar.hashCode());
        e(vVar);
        this.aml.add(vVar);
        RecyclerView.a adapter = this.hak.getAdapter();
        if (adapter != null && adapter.getItemCount() == 3) {
            Log.d(this.TAG, "animateRemove layoutPosition:" + vVar.lQ());
            if (vVar.lQ() == 2) {
                RecyclerView.v ch2 = this.hak.ch(1);
                if (ch2 != null) {
                    Log.d(this.TAG, "animateRemove add moveInfo from adapterPosition 1");
                    ArrayList<d> arrayList = this.amn;
                    p.g(ch2, LocaleUtil.ITALIAN);
                    View view = ch2.aus;
                    p.g(view, "it.itemView");
                    int left = view.getLeft();
                    View view2 = ch2.aus;
                    p.g(view2, "it.itemView");
                    int top = view2.getTop();
                    View view3 = ch2.aus;
                    p.g(view3, "it.itemView");
                    int left2 = view3.getLeft();
                    MultiTaskUIC.a aVar = MultiTaskUIC.Ago;
                    arrayList.add(new d(this, ch2, left, top, left2, MultiTaskUIC.Agh, 1));
                }
                RecyclerView.v ch3 = this.hak.ch(2);
                if (ch3 != null) {
                    Log.d(this.TAG, "animateRemove add moveInfo from adapterPosition 2");
                    ArrayList<d> arrayList2 = this.amn;
                    p.g(ch3, LocaleUtil.ITALIAN);
                    View view4 = ch3.aus;
                    p.g(view4, "it.itemView");
                    int left3 = view4.getLeft();
                    View view5 = ch3.aus;
                    p.g(view5, "it.itemView");
                    int top2 = view5.getTop();
                    View view6 = ch3.aus;
                    p.g(view6, "it.itemView");
                    int left4 = view6.getLeft();
                    MultiTaskUIC.a aVar2 = MultiTaskUIC.Ago;
                    arrayList2.add(new d(this, ch3, left3, top2, left4, MultiTaskUIC.Agh, 1));
                }
            } else if (vVar.lQ() == 1 && (ch = this.hak.ch(1)) != null) {
                Log.d(this.TAG, "animateRemove add moveInfo from adapterPosition 1");
                ArrayList<d> arrayList3 = this.amn;
                p.g(ch, LocaleUtil.ITALIAN);
                View view7 = ch.aus;
                p.g(view7, "it.itemView");
                int left5 = view7.getLeft();
                View view8 = ch.aus;
                p.g(view8, "it.itemView");
                int top3 = view8.getTop();
                View view9 = ch.aus;
                p.g(view9, "it.itemView");
                int left6 = view9.getLeft();
                MultiTaskUIC.a aVar3 = MultiTaskUIC.Ago;
                arrayList3.add(new d(this, ch, left5, top3, left6, MultiTaskUIC.Agh, 1));
            }
        }
        AppMethodBeat.o(236482);
        return true;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$animateRemoveImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animator", "Landroid/animation/Animator;", "onAnimationStart", "ui-multitask_release"})
    public static final class k extends AnimatorListenerAdapter {
        final /* synthetic */ a AdV;
        final /* synthetic */ View hCI;
        final /* synthetic */ RecyclerView.v wrN;
        final /* synthetic */ ViewPropertyAnimator wrO;

        k(a aVar, RecyclerView.v vVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.AdV = aVar;
            this.wrN = vVar;
            this.wrO = viewPropertyAnimator;
            this.hCI = view;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(236472);
            p.h(animator, "animator");
            this.AdV.A(this.wrN);
            AppMethodBeat.o(236472);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(236473);
            p.h(animator, "animator");
            this.wrO.setListener(null);
            this.hCI.setAlpha(1.0f);
            this.AdV.w(this.wrN);
            this.AdV.amu.remove(this.wrN);
            this.AdV.jE();
            AppMethodBeat.o(236473);
        }
    }

    @Override // android.support.v7.widget.as
    public final boolean c(RecyclerView.v vVar) {
        int i2;
        View findViewById;
        AppMethodBeat.i(236483);
        p.h(vVar, "viewHolder");
        String str = this.TAG;
        StringBuilder append = new StringBuilder("animateAdd layoutPosition:").append(vVar.lQ()).append(" adapterPosition:").append(vVar.lR()).append(" hashCode:").append(vVar.hashCode()).append(" itemCount:");
        RecyclerView.a adapter = this.hak.getAdapter();
        Log.d(str, append.append(adapter != null ? Integer.valueOf(adapter.getItemCount()) : null).toString());
        e(vVar);
        View view = vVar.aus;
        p.g(view, "viewHolder.itemView");
        view.setAlpha(0.0f);
        this.amm.add(vVar);
        RecyclerView.a adapter2 = this.hak.getAdapter();
        if (adapter2 != null) {
            i2 = adapter2.getItemCount();
        } else {
            i2 = 0;
        }
        if (i2 == 2) {
            if (vVar.lQ() == 1) {
                ArrayList<d> arrayList = this.amn;
                View view2 = vVar.aus;
                p.g(view2, "viewHolder.itemView");
                int left = view2.getLeft();
                View view3 = vVar.aus;
                p.g(view3, "viewHolder.itemView");
                int top = view3.getTop();
                MultiTaskUIC.a aVar = MultiTaskUIC.Ago;
                int i3 = MultiTaskUIC.Agf;
                MultiTaskUIC.a aVar2 = MultiTaskUIC.Ago;
                arrayList.add(new d(this, vVar, left, top, i3, MultiTaskUIC.Age, 1));
            }
        } else if (i2 == 3) {
            ArrayList<d> arrayList2 = this.amn;
            View view4 = vVar.aus;
            p.g(view4, "viewHolder.itemView");
            int left2 = view4.getLeft();
            View view5 = vVar.aus;
            p.g(view5, "viewHolder.itemView");
            int top2 = view5.getTop();
            MultiTaskUIC.a aVar3 = MultiTaskUIC.Ago;
            arrayList2.add(new d(this, vVar, left2, top2, 0, MultiTaskUIC.Agh, 1));
            RecyclerView.v ch = this.hak.ch(2);
            if (ch != null) {
                ArrayList<d> arrayList3 = this.amn;
                p.g(ch, LocaleUtil.ITALIAN);
                View view6 = ch.aus;
                p.g(view6, "it.itemView");
                int left3 = view6.getLeft();
                View view7 = ch.aus;
                p.g(view7, "it.itemView");
                int top3 = view7.getTop();
                View view8 = ch.aus;
                p.g(view8, "it.itemView");
                int left4 = view8.getLeft();
                MultiTaskUIC.a aVar4 = MultiTaskUIC.Ago;
                arrayList3.add(new d(this, ch, left3, top3, left4, MultiTaskUIC.Agh, 1));
            }
        } else if (i2 >= 4 && (findViewById = vVar.aus.findViewById(R.id.e24)) != null) {
            findViewById.setTranslationX(0.0f);
            findViewById.setTranslationY(0.0f);
        }
        AppMethodBeat.o(236483);
        return true;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$animateAddImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "ui-multitask_release"})
    public static final class e extends AnimatorListenerAdapter {
        final /* synthetic */ a AdV;
        final /* synthetic */ View hCI;
        final /* synthetic */ RecyclerView.v wrN;
        final /* synthetic */ ViewPropertyAnimator wrO;

        e(a aVar, RecyclerView.v vVar, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.AdV = aVar;
            this.wrN = vVar;
            this.hCI = view;
            this.wrO = viewPropertyAnimator;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(236458);
            p.h(animator, "animator");
            AppMethodBeat.o(236458);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(236459);
            p.h(animator, "animator");
            this.hCI.setAlpha(1.0f);
            AppMethodBeat.o(236459);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(236460);
            p.h(animator, "animator");
            this.wrO.setListener(null);
            this.AdV.y(this.wrN);
            this.AdV.ams.remove(this.wrN);
            this.AdV.jE();
            AppMethodBeat.o(236460);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$animateLayoutImpl$1$1"})
    static final class h implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ a AdV;
        final /* synthetic */ View Aee;
        final /* synthetic */ c Aef;
        final /* synthetic */ View tBN;

        h(a aVar, View view, View view2, c cVar) {
            this.AdV = aVar;
            this.Aee = view;
            this.tBN = view2;
            this.Aef = cVar;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(236465);
            p.g(valueAnimator, "animation");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(236465);
                throw tVar;
            }
            int intValue = ((Integer) animatedValue).intValue();
            View view = this.Aee;
            p.g(view, "imgView");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            MultiTaskUIC.a aVar = MultiTaskUIC.Ago;
            MultiTaskUIC.a aVar2 = MultiTaskUIC.Ago;
            layoutParams.height = kotlin.h.a.cR(((float) (intValue - MultiTaskUIC.AfV)) * MultiTaskUIC.Agn);
            this.tBN.getLayoutParams().width = intValue;
            ViewGroup.LayoutParams layoutParams2 = this.tBN.getLayoutParams();
            MultiTaskUIC.a aVar3 = MultiTaskUIC.Ago;
            layoutParams2.height = kotlin.h.a.cR(((float) intValue) * MultiTaskUIC.scale);
            this.tBN.requestLayout();
            AppMethodBeat.o(236465);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$animateLayoutImpl$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "ui-multitask_release"})
    public static final class i extends AnimatorListenerAdapter {
        final /* synthetic */ a AdV;
        final /* synthetic */ View Aee;
        final /* synthetic */ c Aef;
        final /* synthetic */ ValueAnimator Aeg;
        final /* synthetic */ View tBN;

        i(ValueAnimator valueAnimator, a aVar, View view, View view2, c cVar) {
            this.Aeg = valueAnimator;
            this.AdV = aVar;
            this.Aee = view;
            this.tBN = view2;
            this.Aef = cVar;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(236466);
            p.h(animator, "animator");
            AppMethodBeat.o(236466);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(236467);
            p.h(animator, "animator");
            View view = this.Aee;
            p.g(view, "imgView");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            int i2 = this.Aef.AdX;
            MultiTaskUIC.a aVar = MultiTaskUIC.Ago;
            MultiTaskUIC.a aVar2 = MultiTaskUIC.Ago;
            layoutParams.height = kotlin.h.a.cR(((float) (i2 - MultiTaskUIC.AfV)) * MultiTaskUIC.Agn);
            this.tBN.getLayoutParams().width = this.Aef.AdX;
            ViewGroup.LayoutParams layoutParams2 = this.tBN.getLayoutParams();
            MultiTaskUIC.a aVar3 = MultiTaskUIC.Ago;
            layoutParams2.height = kotlin.h.a.cR(((float) this.Aef.AdX) * MultiTaskUIC.scale);
            this.tBN.requestLayout();
            AppMethodBeat.o(236467);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(236468);
            p.h(animator, "animator");
            this.Aeg.removeListener(this);
            this.Aef.animator = null;
            AppMethodBeat.o(236468);
        }
    }

    @Override // android.support.v7.widget.as
    public final boolean a(RecyclerView.v vVar, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(236484);
        p.h(vVar, "holder");
        View view = vVar.aus;
        p.g(view, "holder.itemView");
        View view2 = vVar.aus;
        p.g(view2, "holder.itemView");
        int translationX = i2 + ((int) view2.getTranslationX());
        View view3 = vVar.aus;
        p.g(view3, "holder.itemView");
        int translationY = i3 + ((int) view3.getTranslationY());
        e(vVar);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            x(vVar);
            AppMethodBeat.o(236484);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX(-((float) i6));
        }
        if (i7 != 0) {
            view.setTranslationY(-((float) i7));
        }
        this.amn.add(new d(this, vVar, translationX, translationY, i4, i5));
        String str = this.TAG;
        StringBuilder append = new StringBuilder("animateMove fromX:").append(translationX).append(" fromY:").append(translationY).append(" toX:").append(i4).append(" toY:").append(i5).append(" deltaX:").append(i6).append(" deltaY:").append(i7).append(" holder.left:");
        View view4 = vVar.aus;
        p.g(view4, "holder.itemView");
        StringBuilder append2 = append.append(view4.getLeft()).append(" holder.top:");
        View view5 = vVar.aus;
        p.g(view5, "holder.itemView");
        Log.d(str, append2.append(view5.getTop()).append(" holder.position:").append(vVar.lR()).toString());
        AppMethodBeat.o(236484);
        return true;
    }

    private boolean b(RecyclerView.v vVar, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(236485);
        p.h(vVar, "holder");
        View view = vVar.aus;
        p.g(view, "holder.itemView");
        View view2 = vVar.aus;
        p.g(view2, "holder.itemView");
        int translationX = i2 + ((int) view2.getTranslationX());
        View view3 = vVar.aus;
        p.g(view3, "holder.itemView");
        int translationY = i3 + ((int) view3.getTranslationY());
        e(vVar);
        View view4 = vVar.aus;
        p.g(view4, "holder.itemView");
        int left = translationX - view4.getLeft();
        View view5 = vVar.aus;
        p.g(view5, "holder.itemView");
        int top = translationY - view5.getTop();
        if (left == 0 && top == 0) {
            x(vVar);
            AppMethodBeat.o(236485);
            return false;
        }
        if (left != 0) {
            view.setTranslationX((float) left);
        }
        if (top != 0) {
            view.setTranslationY((float) top);
        }
        this.amn.add(new d(this, vVar, translationX, translationY, i4, i5, 1));
        String str = this.TAG;
        StringBuilder append = new StringBuilder("animateMove1 fromX:").append(translationX).append(" fromY:").append(translationY).append(" toX:").append(i4).append(" toY:").append(i5).append(" deltaX:").append(left).append(" deltaY:").append(top).append(" holder.left:");
        View view6 = vVar.aus;
        p.g(view6, "holder.itemView");
        StringBuilder append2 = append.append(view6.getLeft()).append(" holder.top:");
        View view7 = vVar.aus;
        p.g(view7, "holder.itemView");
        Log.d(str, append2.append(view7.getTop()).append(" holder.position:").append(vVar.lR()).toString());
        AppMethodBeat.o(236485);
        return true;
    }

    private boolean a(RecyclerView.v vVar, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(236486);
        p.h(vVar, "holder");
        View view = vVar.aus;
        p.g(view, "holder.itemView");
        View view2 = vVar.aus;
        p.g(view2, "holder.itemView");
        int translationX = i2 + ((int) view2.getTranslationX());
        View view3 = vVar.aus;
        p.g(view3, "holder.itemView");
        int translationY = i3 + ((int) view3.getTranslationY());
        e(vVar);
        int i7 = i4 - translationX;
        int i8 = i5 - translationY;
        if (i7 == 0 && i8 == 0) {
            x(vVar);
            AppMethodBeat.o(236486);
            return false;
        }
        if (i7 != 0) {
            view.setTranslationX(-((float) i7));
        }
        if (i8 != 0) {
            view.setTranslationY(-((float) i8));
        }
        this.amn.add(new d(this, vVar, translationX, i5, i4, i6, 2));
        String str = this.TAG;
        StringBuilder append = new StringBuilder("animateMove3 fromX:").append(translationX).append(" fromY:").append(translationY).append(" toX:").append(i4).append(" toY:").append(i5).append(" deltaX:").append(i7).append(" deltaY:").append(i8).append(" holder.left:");
        View view4 = vVar.aus;
        p.g(view4, "holder.itemView");
        StringBuilder append2 = append.append(view4.getLeft()).append(" holder.top:");
        View view5 = vVar.aus;
        p.g(view5, "holder.itemView");
        Log.d(str, append2.append(view5.getTop()).append(" holder.position:").append(vVar.lR()).toString());
        AppMethodBeat.o(236486);
        return true;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$animateMoveImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "ui-multitask_release"})
    public static final class j extends AnimatorListenerAdapter {
        final /* synthetic */ a AdV;
        final /* synthetic */ int Aeh;
        final /* synthetic */ int Aei;
        final /* synthetic */ View hCI;
        final /* synthetic */ RecyclerView.v wrN;
        final /* synthetic */ ViewPropertyAnimator wrO;

        j(a aVar, RecyclerView.v vVar, int i2, View view, int i3, ViewPropertyAnimator viewPropertyAnimator) {
            this.AdV = aVar;
            this.wrN = vVar;
            this.Aeh = i2;
            this.hCI = view;
            this.Aei = i3;
            this.wrO = viewPropertyAnimator;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(236469);
            p.h(animator, "animator");
            this.AdV.B(this.wrN);
            AppMethodBeat.o(236469);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(236470);
            p.h(animator, "animator");
            if (this.Aeh != 0) {
                this.hCI.setTranslationX(0.0f);
            }
            if (this.Aei != 0) {
                this.hCI.setTranslationY(0.0f);
            }
            AppMethodBeat.o(236470);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(236471);
            p.h(animator, "animator");
            this.wrO.setListener(null);
            this.AdV.x(this.wrN);
            this.AdV.amt.remove(this.wrN);
            this.AdV.jE();
            AppMethodBeat.o(236471);
        }
    }

    @Override // android.support.v7.widget.as
    public final boolean a(RecyclerView.v vVar, RecyclerView.v vVar2, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(236487);
        p.h(vVar, "oldHolder");
        p.h(vVar2, "newHolder");
        if (vVar == vVar2) {
            boolean a2 = a(vVar, i2, i3, i4, i5);
            AppMethodBeat.o(236487);
            return a2;
        }
        View view = vVar.aus;
        p.g(view, "oldHolder.itemView");
        float translationX = view.getTranslationX();
        View view2 = vVar.aus;
        p.g(view2, "oldHolder.itemView");
        float translationY = view2.getTranslationY();
        View view3 = vVar.aus;
        p.g(view3, "oldHolder.itemView");
        float alpha = view3.getAlpha();
        e(vVar);
        View view4 = vVar.aus;
        p.g(view4, "oldHolder.itemView");
        view4.setTranslationX(translationX);
        View view5 = vVar.aus;
        p.g(view5, "oldHolder.itemView");
        view5.setTranslationY(translationY);
        View view6 = vVar.aus;
        p.g(view6, "oldHolder.itemView");
        view6.setAlpha(alpha);
        e(vVar2);
        View view7 = vVar2.aus;
        p.g(view7, "newHolder.itemView");
        view7.setTranslationX(-((float) ((int) (((float) (i4 - i2)) - translationX))));
        View view8 = vVar2.aus;
        p.g(view8, "newHolder.itemView");
        view8.setTranslationY(-((float) ((int) (((float) (i5 - i3)) - translationY))));
        View view9 = vVar2.aus;
        p.g(view9, "newHolder.itemView");
        view9.setAlpha(0.0f);
        RecyclerView.a adapter = this.hak.getAdapter();
        int itemCount = adapter != null ? adapter.getItemCount() : 0;
        if ((itemCount == 2 || itemCount == 3) && i2 == i4 && i3 == i5) {
            this.amo.add(new C1526a(vVar, vVar2, i2, i3, i4, i5, translationX, translationY));
        } else {
            this.amo.add(new C1526a(vVar, vVar2, i2, i3, i4, i5, 0.0f, 0.0f));
        }
        AppMethodBeat.o(236487);
        return true;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$animateChangeImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animator", "Landroid/animation/Animator;", "onAnimationStart", "ui-multitask_release"})
    public static final class f extends AnimatorListenerAdapter {
        final /* synthetic */ a AdV;
        final /* synthetic */ C1526a AdY;
        final /* synthetic */ ViewPropertyAnimator AdZ;
        final /* synthetic */ float Aea;
        final /* synthetic */ float Aeb;
        final /* synthetic */ View hCI;

        f(a aVar, C1526a aVar2, ViewPropertyAnimator viewPropertyAnimator, View view, float f2, float f3) {
            this.AdV = aVar;
            this.AdY = aVar2;
            this.AdZ = viewPropertyAnimator;
            this.hCI = view;
            this.Aea = f2;
            this.Aeb = f3;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(236461);
            p.h(animator, "animator");
            AppMethodBeat.o(236461);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(236462);
            p.h(animator, "animator");
            this.AdZ.setListener(null);
            this.hCI.setAlpha(1.0f);
            this.hCI.setTranslationX(this.Aea);
            this.hCI.setTranslationY(this.Aeb);
            this.AdV.z(this.AdY.amI);
            this.AdV.amv.remove(this.AdY.amI);
            this.AdV.jE();
            AppMethodBeat.o(236462);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$animateChangeImpl$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animator", "Landroid/animation/Animator;", "onAnimationStart", "ui-multitask_release"})
    public static final class g extends AnimatorListenerAdapter {
        final /* synthetic */ a AdV;
        final /* synthetic */ C1526a AdY;
        final /* synthetic */ float Aea;
        final /* synthetic */ float Aeb;
        final /* synthetic */ ViewPropertyAnimator Aec;
        final /* synthetic */ View Aed;

        g(a aVar, C1526a aVar2, ViewPropertyAnimator viewPropertyAnimator, View view, float f2, float f3) {
            this.AdV = aVar;
            this.AdY = aVar2;
            this.Aec = viewPropertyAnimator;
            this.Aed = view;
            this.Aea = f2;
            this.Aeb = f3;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(236463);
            p.h(animator, "animator");
            AppMethodBeat.o(236463);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(236464);
            p.h(animator, "animator");
            this.Aec.setListener(null);
            this.Aed.setAlpha(1.0f);
            this.Aed.setTranslationX(this.Aea);
            this.Aed.setTranslationY(this.Aeb);
            this.AdV.z(this.AdY.amJ);
            this.AdV.amv.remove(this.AdY.amJ);
            this.AdV.jE();
            AppMethodBeat.o(236464);
        }
    }

    private final void a(List<C1526a> list, RecyclerView.v vVar) {
        AppMethodBeat.i(236488);
        for (int size = list.size() - 1; size >= 0; size--) {
            C1526a aVar = list.get(size);
            if (a(aVar, vVar) && aVar.amI == null && aVar.amJ == null) {
                list.remove(aVar);
            }
        }
        AppMethodBeat.o(236488);
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public final void d(RecyclerView.v vVar) {
        AppMethodBeat.i(236491);
        p.h(vVar, "item");
        Log.d(this.TAG, "endAnimation " + vVar.lR());
        View view = vVar.aus;
        p.g(view, "item.itemView");
        View findViewById = vVar.aus.findViewById(R.id.fnq);
        view.animate().cancel();
        for (int size = this.amn.size() - 1; size >= 0; size--) {
            d dVar = this.amn.get(size);
            p.g(dVar, "mPendingMoves[i]");
            if (dVar.amO == vVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                x(vVar);
                this.amn.remove(size);
                Log.d(this.TAG, "endAnimation, reset");
            }
        }
        a(this.amo, vVar);
        if (this.aml.remove(vVar)) {
            view.setAlpha(1.0f);
            w(vVar);
        }
        if (this.amm.remove(vVar)) {
            view.setAlpha(1.0f);
            y(vVar);
        }
        for (int size2 = this.amr.size() - 1; size2 >= 0; size2--) {
            ArrayList<C1526a> arrayList = this.amr.get(size2);
            p.g(arrayList, "mChangesList[i]");
            ArrayList<C1526a> arrayList2 = arrayList;
            a(arrayList2, vVar);
            if (arrayList2.isEmpty()) {
                this.amr.remove(size2);
            }
        }
        for (int size3 = this.amq.size() - 1; size3 >= 0; size3--) {
            ArrayList<d> arrayList3 = this.amq.get(size3);
            p.g(arrayList3, "mMovesList[i]");
            ArrayList<d> arrayList4 = arrayList3;
            int size4 = arrayList4.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                d dVar2 = arrayList4.get(size4);
                p.g(dVar2, "moves[j]");
                if (dVar2.amO == vVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    x(vVar);
                    arrayList4.remove(size4);
                    if (arrayList4.isEmpty()) {
                        this.amq.remove(size3);
                    }
                    Log.d(this.TAG, "endAnimations,move reset!");
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.amp.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.v> arrayList5 = this.amp.get(size5);
            p.g(arrayList5, "mAdditionsList[i]");
            ArrayList<RecyclerView.v> arrayList6 = arrayList5;
            if (arrayList6.remove(vVar)) {
                view.setAlpha(1.0f);
                y(vVar);
                if (arrayList6.isEmpty()) {
                    this.amp.remove(size5);
                }
            }
        }
        for (int size6 = this.AdQ.size() - 1; size6 >= 0; size6--) {
            ArrayList<c> arrayList7 = this.AdQ.get(size6);
            p.g(arrayList7, "mLayoutsList[i]");
            ArrayList<c> arrayList8 = arrayList7;
            int size7 = arrayList8.size() - 1;
            while (true) {
                if (size7 < 0) {
                    break;
                }
                c cVar = arrayList8.get(size7);
                p.g(cVar, "layouts[j]");
                c cVar2 = cVar;
                if (cVar2.amO == vVar) {
                    p.g(findViewById, "imgView");
                    ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                    int i2 = cVar2.AdW;
                    MultiTaskUIC.a aVar = MultiTaskUIC.Ago;
                    MultiTaskUIC.a aVar2 = MultiTaskUIC.Ago;
                    layoutParams.height = kotlin.h.a.cR(((float) (i2 - MultiTaskUIC.AfV)) * MultiTaskUIC.Agn);
                    view.getLayoutParams().width = cVar2.AdW;
                    ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                    MultiTaskUIC.a aVar3 = MultiTaskUIC.Ago;
                    layoutParams2.height = kotlin.h.a.cR(((float) cVar2.AdW) * MultiTaskUIC.scale);
                    view.requestLayout();
                    arrayList8.remove(size7);
                    if (arrayList8.isEmpty()) {
                        this.AdQ.remove(size6);
                    }
                } else {
                    size7--;
                }
            }
        }
        this.amu.remove(vVar);
        this.ams.remove(vVar);
        this.amv.remove(vVar);
        this.amt.remove(vVar);
        jE();
        AppMethodBeat.o(236491);
    }

    private void e(RecyclerView.v vVar) {
        AppMethodBeat.i(236492);
        p.h(vVar, "holder");
        if (amk == null) {
            amk = new ValueAnimator().getInterpolator();
        }
        ViewPropertyAnimator animate = vVar.aus.animate();
        p.g(animate, "holder.itemView.animate()");
        animate.setInterpolator(amk);
        d(vVar);
        AppMethodBeat.o(236492);
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public final boolean isRunning() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        AppMethodBeat.i(236493);
        if (!(!this.amm.isEmpty())) {
            if (!this.amo.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (!this.amn.isEmpty()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    if (!this.aml.isEmpty()) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (!z3) {
                        if (!this.amt.isEmpty()) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (!z4) {
                            if (!this.amu.isEmpty()) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (!z5) {
                                if (!this.ams.isEmpty()) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                if (!z6) {
                                    if (!this.amv.isEmpty()) {
                                        z7 = true;
                                    } else {
                                        z7 = false;
                                    }
                                    if (!z7) {
                                        if (!this.amq.isEmpty()) {
                                            z8 = true;
                                        } else {
                                            z8 = false;
                                        }
                                        if (!z8) {
                                            if (!this.amp.isEmpty()) {
                                                z9 = true;
                                            } else {
                                                z9 = false;
                                            }
                                            if (!z9) {
                                                if (!this.amr.isEmpty()) {
                                                    z10 = true;
                                                } else {
                                                    z10 = false;
                                                }
                                                if (!z10) {
                                                    AppMethodBeat.o(236493);
                                                    return false;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(236493);
        return true;
    }

    public final void jE() {
        AppMethodBeat.i(236494);
        if (!isRunning()) {
            lC();
        }
        AppMethodBeat.o(236494);
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public final void o(RecyclerView.v vVar) {
        AppMethodBeat.i(236495);
        p.h(vVar, "viewHolder");
        super.o(vVar);
        com.tencent.mm.plugin.multitask.ui.minusscreen.d.a aVar = this.AdR;
        if (aVar != null) {
            aVar.ac(vVar);
            AppMethodBeat.o(236495);
            return;
        }
        AppMethodBeat.o(236495);
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public final void jF() {
        AppMethodBeat.i(236496);
        Log.d(this.TAG, "endAnimations");
        for (int size = this.amn.size() - 1; size >= 0; size--) {
            d dVar = this.amn.get(size);
            p.g(dVar, "mPendingMoves[i]");
            d dVar2 = dVar;
            View view = dVar2.amO.aus;
            p.g(view, "item.holder.itemView");
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            x(dVar2.amO);
            this.amn.remove(size);
            Log.d(this.TAG, "endAnimations, pending move reset!");
        }
        for (int size2 = this.aml.size() - 1; size2 >= 0; size2--) {
            RecyclerView.v vVar = this.aml.get(size2);
            p.g(vVar, "mPendingRemovals[i]");
            w(vVar);
            this.aml.remove(size2);
        }
        for (int size3 = this.amm.size() - 1; size3 >= 0; size3--) {
            RecyclerView.v vVar2 = this.amm.get(size3);
            p.g(vVar2, "mPendingAdditions[i]");
            RecyclerView.v vVar3 = vVar2;
            View view2 = vVar3.aus;
            p.g(view2, "item.itemView");
            view2.setAlpha(1.0f);
            y(vVar3);
            this.amm.remove(size3);
        }
        for (int size4 = this.amo.size() - 1; size4 >= 0; size4--) {
            C1526a aVar = this.amo.get(size4);
            p.g(aVar, "mPendingChanges[i]");
            a(aVar);
        }
        this.amo.clear();
        if (!isRunning()) {
            AppMethodBeat.o(236496);
            return;
        }
        for (int size5 = this.amq.size() - 1; size5 >= 0; size5--) {
            ArrayList<d> arrayList = this.amq.get(size5);
            p.g(arrayList, "mMovesList[i]");
            ArrayList<d> arrayList2 = arrayList;
            for (int size6 = arrayList2.size() - 1; size6 >= 0; size6--) {
                d dVar3 = arrayList2.get(size6);
                p.g(dVar3, "moves[j]");
                d dVar4 = dVar3;
                View view3 = dVar4.amO.aus;
                p.g(view3, "item.itemView");
                view3.setTranslationY(0.0f);
                view3.setTranslationX(0.0f);
                x(dVar4.amO);
                arrayList2.remove(size6);
                if (arrayList2.isEmpty()) {
                    this.amq.remove(arrayList2);
                }
                Log.d(this.TAG, "endAnimations, moveReset Translation");
            }
        }
        for (int size7 = this.amp.size() - 1; size7 >= 0; size7--) {
            ArrayList<RecyclerView.v> arrayList3 = this.amp.get(size7);
            p.g(arrayList3, "mAdditionsList[i]");
            ArrayList<RecyclerView.v> arrayList4 = arrayList3;
            for (int size8 = arrayList4.size() - 1; size8 >= 0; size8--) {
                RecyclerView.v vVar4 = arrayList4.get(size8);
                p.g(vVar4, "additions[j]");
                RecyclerView.v vVar5 = vVar4;
                View view4 = vVar5.aus;
                p.g(view4, "item.itemView");
                view4.setAlpha(1.0f);
                y(vVar5);
                arrayList4.remove(size8);
                if (arrayList4.isEmpty()) {
                    this.amp.remove(arrayList4);
                }
            }
        }
        for (int size9 = this.amr.size() - 1; size9 >= 0; size9--) {
            ArrayList<C1526a> arrayList5 = this.amr.get(size9);
            p.g(arrayList5, "mChangesList[i]");
            ArrayList<C1526a> arrayList6 = arrayList5;
            for (int size10 = arrayList6.size() - 1; size10 >= 0; size10--) {
                C1526a aVar2 = arrayList6.get(size10);
                p.g(aVar2, "changes[j]");
                a(aVar2);
                if (arrayList6.isEmpty()) {
                    this.amr.remove(arrayList6);
                }
            }
        }
        n(this.amu);
        n(this.amt);
        n(this.ams);
        n(this.amv);
        lC();
        AppMethodBeat.o(236496);
    }

    private static void n(List<? extends RecyclerView.v> list) {
        View view;
        ViewPropertyAnimator animate;
        AppMethodBeat.i(236497);
        p.h(list, "viewHolders");
        for (int size = list.size() - 1; size >= 0; size--) {
            RecyclerView.v vVar = (RecyclerView.v) list.get(size);
            if (!(vVar == null || (view = vVar.aus) == null || (animate = view.animate()) == null)) {
                animate.cancel();
            }
        }
        AppMethodBeat.o(236497);
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public final boolean a(RecyclerView.v vVar, List<? extends Object> list) {
        AppMethodBeat.i(236498);
        p.h(vVar, "viewHolder");
        p.h(list, "payloads");
        if ((!list.isEmpty()) || super.a(vVar, list)) {
            AppMethodBeat.o(236498);
            return true;
        }
        AppMethodBeat.o(236498);
        return false;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/animation/MinusAnimator$Companion;", "", "()V", "DEBUG", "", "sDefaultInterpolator", "Landroid/animation/TimeInterpolator;", "ui-multitask_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    private final void a(C1526a aVar) {
        AppMethodBeat.i(236489);
        if (aVar.amI != null) {
            a(aVar, aVar.amI);
        }
        if (aVar.amJ != null) {
            a(aVar, aVar.amJ);
        }
        AppMethodBeat.o(236489);
    }

    private final boolean a(C1526a aVar, RecyclerView.v vVar) {
        AppMethodBeat.i(236490);
        if (aVar.amJ == vVar) {
            aVar.amJ = null;
        } else if (aVar.amI == vVar) {
            aVar.amI = null;
        } else {
            AppMethodBeat.o(236490);
            return false;
        }
        if (vVar != null) {
            View view = vVar.aus;
            p.g(view, "it.itemView");
            view.setAlpha(1.0f);
            View view2 = vVar.aus;
            p.g(view2, "it.itemView");
            view2.setTranslationX(aVar.AdT);
            View view3 = vVar.aus;
            p.g(view3, "it.itemView");
            view3.setTranslationY(aVar.AdU);
            Log.d(this.TAG, "endAnimations,change reset!, transX: " + aVar.AdT + " transY: " + aVar.AdU);
        }
        z(vVar);
        AppMethodBeat.o(236490);
        return true;
    }
}
