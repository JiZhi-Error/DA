package com.tencent.mm.plugin.festival.finder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Vibrator;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.b.o;
import com.tencent.mm.plugin.finder.live.model.m;
import com.tencent.mm.plugin.finder.live.model.n;
import com.tencent.mm.plugin.finder.live.model.t;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.protocal.protobuf.auy;
import com.tencent.mm.protocal.protobuf.avc;
import com.tencent.mm.protocal.protobuf.avi;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.awd;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.ArrayList;
import kotlin.g.b.z;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002jkB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010P\u001a\u00020&2\u0006\u00102\u001a\u00020\u0017J\b\u0010Q\u001a\u00020\u0007H\u0016J \u0010R\u001a\u00020&2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020\u00022\u0006\u0010V\u001a\u00020\u0017H\u0002J(\u0010W\u001a\u00020&2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020\u00022\u0006\u0010V\u001a\u00020\u00172\u0006\u0010X\u001a\u00020YH\u0002J \u0010Z\u001a\u00020&2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020\u00022\u0006\u0010V\u001a\u00020\u0017H\u0002J \u0010[\u001a\u00020&2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020\u00022\u0006\u0010V\u001a\u00020\\H\u0002J \u0010]\u001a\u00020&2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020\u00022\u0006\u0010V\u001a\u00020\u0017H\u0002J \u0010^\u001a\u00020&2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020\u00022\u0006\u0010V\u001a\u00020\u0017H\u0002J\u0018\u0010_\u001a\u00020&2\u0006\u0010U\u001a\u00020\u00022\u0006\u0010`\u001a\u00020\u0007H\u0016J \u0010a\u001a\u00020&2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020\u00022\u0006\u0010V\u001a\u00020\\H\u0002J \u0010b\u001a\u00020&2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020\u00022\u0006\u0010V\u001a\u00020\\H\u0002J\u0018\u0010c\u001a\u00020\u00022\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020\u0007H\u0016J\u000e\u0010g\u001a\u00020&2\u0006\u00102\u001a\u00020\u0017J\u0014\u0010h\u001a\u00020&2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170iR\u001b\u0010\u0006\u001a\u00020\u00078FX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u00078FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000f\u0010\tR\u001b\u0010\u0011\u001a\u00020\r8FX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0012\u0010\u0013R!\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\r8FX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001d\u0010\u0013RL\u0010\u001f\u001a4\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R7\u0010+\u001a\u001f\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020&\u0018\u00010,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100RL\u00101\u001a4\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\r¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020&\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010(\"\u0004\b4\u0010*R\u001b\u00105\u001a\u0002068FX\u0002¢\u0006\f\n\u0004\b9\u0010\u000b\u001a\u0004\b7\u00108R\u001b\u0010:\u001a\u0002068FX\u0002¢\u0006\f\n\u0004\b<\u0010\u000b\u001a\u0004\b;\u00108R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010\u0005R\u001b\u0010@\u001a\u0002068FX\u0002¢\u0006\f\n\u0004\bB\u0010\u000b\u001a\u0004\bA\u00108R\u000e\u0010C\u001a\u00020DX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010E\u001a\u00020F8FX\u0002¢\u0006\f\n\u0004\bI\u0010\u000b\u001a\u0004\bG\u0010HR\u001b\u0010J\u001a\u0002068FX\u0002¢\u0006\f\n\u0004\bL\u0010\u000b\u001a\u0004\bK\u00108R\u001b\u0010M\u001a\u00020\r8FX\u0002¢\u0006\f\n\u0004\bO\u0010\u000b\u001a\u0004\bN\u0010\u0013¨\u0006l"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveCommentAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveCommentAdapter$LiveCommentItemHolder;", "roomData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;)V", "GIFT_ICON_SIZE", "", "getGIFT_ICON_SIZE", "()I", "GIFT_ICON_SIZE$delegate", "Lkotlin/Lazy;", "TAG", "", "TEXT_PADDING_LEFT", "getTEXT_PADDING_LEFT", "TEXT_PADDING_LEFT$delegate", "annoucement", "getAnnoucement", "()Ljava/lang/String;", "annoucement$delegate", "commentList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "Lkotlin/collections/ArrayList;", "getCommentList", "()Ljava/util/ArrayList;", "contentFontSize", "giftStr", "getGiftStr", "giftStr$delegate", "onItemClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "msg", "Landroid/view/View;", "view", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onItemDoubleClickListener", "Lkotlin/Function1;", "getOnItemDoubleClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemDoubleClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onItemLongClickListener", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "getOnItemLongClickListener", "setOnItemLongClickListener", "rankNoticeImageSpan", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan;", "getRankNoticeImageSpan", "()Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan;", "rankNoticeImageSpan$delegate", "rewardImageSpan", "getRewardImageSpan", "rewardImageSpan$delegate", "getRoomData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "setRoomData", "sysAnnoucementImageSpan", "getSysAnnoucementImageSpan", "sysAnnoucementImageSpan$delegate", "userNameSpan", "Landroid/text/style/ForegroundColorSpan;", "vibrator", "Landroid/os/Vibrator;", "getVibrator", "()Landroid/os/Vibrator;", "vibrator$delegate", "welcomeImageSpan", "getWelcomeImageSpan", "welcomeImageSpan$delegate", "welcomeTag", "getWelcomeTag", "welcomeTag$delegate", "appendComment", "getItemCount", "onBindAtMsg", "context", "Landroid/content/Context;", "holder", "commentData", "onBindComboLiveRewardMsg", "payloadContent", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgComboLiveRewardInfo;", "onBindRewardRankNoticeMsg", "onBindSysMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "onBindTextMsg", "onBindTickleMsg", "onBindViewHolder", "position", "onBindVisistorJoinLive", "onBindWelcomeMsg", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "removeComment", "updateComments", "", "LiveCommentItemHolder", "LiveHeightSpan", "plugin-festival_release"})
public final class s extends RecyclerView.a<b> {
    private final String TAG = "Finder.FinderLiveCommentAdapter";
    final ArrayList<t> hXy = new ArrayList<>();
    private final kotlin.f uAd = kotlin.g.ah(c.Usq);
    private final kotlin.f uAe = kotlin.g.ah(a.Usp);
    private final int uAf;
    private final ForegroundColorSpan uAg;
    private final kotlin.f uAh;
    kotlin.g.a.m<? super t, ? super String, x> uAi;
    kotlin.g.a.m<? super t, ? super View, x> uAj;
    kotlin.g.a.b<? super t, x> uAk;
    private final kotlin.f uAl;
    private final kotlin.f uAm;
    private final kotlin.f uAn;
    private final kotlin.f uAo;
    private final kotlin.f uAp;
    private final kotlin.f uAq;
    private final kotlin.f uAr;
    private com.tencent.mm.plugin.finder.live.viewmodel.g uAs;

    private int diE() {
        AppMethodBeat.i(262235);
        int intValue = ((Number) this.uAd.getValue()).intValue();
        AppMethodBeat.o(262235);
        return intValue;
    }

    private com.tencent.mm.plugin.finder.live.model.m diI() {
        AppMethodBeat.i(262240);
        com.tencent.mm.plugin.finder.live.model.m mVar = (com.tencent.mm.plugin.finder.live.model.m) this.uAo.getValue();
        AppMethodBeat.o(262240);
        return mVar;
    }

    public final int diF() {
        AppMethodBeat.i(262236);
        int intValue = ((Number) this.uAe.getValue()).intValue();
        AppMethodBeat.o(262236);
        return intValue;
    }

    public final String diG() {
        AppMethodBeat.i(262237);
        String str = (String) this.uAl.getValue();
        AppMethodBeat.o(262237);
        return str;
    }

    public final String diH() {
        AppMethodBeat.i(262239);
        String str = (String) this.uAn.getValue();
        AppMethodBeat.o(262239);
        return str;
    }

    public final String diJ() {
        AppMethodBeat.i(262241);
        String str = (String) this.uAp.getValue();
        AppMethodBeat.o(262241);
        return str;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u0016\u0010\u0006\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u00072\u000e\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n¨\u0006\u000b"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete", "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveCommentAdapter$onBindComboLiveRewardMsg$1$1"})
    static final class f<T, R> implements com.tencent.mm.loader.f.e<com.tencent.mm.plugin.finder.loader.o, Bitmap> {
        final /* synthetic */ Context $context$inlined;
        final /* synthetic */ s Ust;
        final /* synthetic */ b Usu;
        final /* synthetic */ z.f Usv;
        final /* synthetic */ z.f Usw;
        final /* synthetic */ com.tencent.mm.pluginsdk.ui.span.m Usx;
        final /* synthetic */ auy uAB;
        final /* synthetic */ String uAz;

        f(s sVar, String str, b bVar, auy auy, Context context, z.f fVar, z.f fVar2, com.tencent.mm.pluginsdk.ui.span.m mVar) {
            this.Ust = sVar;
            this.uAz = str;
            this.Usu = bVar;
            this.uAB = auy;
            this.$context$inlined = context;
            this.Usv = fVar;
            this.Usw = fVar2;
            this.Usx = mVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.h.a.a, com.tencent.mm.loader.e.b.g, java.lang.Object] */
        @Override // com.tencent.mm.loader.f.e
        public final /* synthetic */ void a(com.tencent.mm.loader.h.a.a<com.tencent.mm.plugin.finder.loader.o> aVar, com.tencent.mm.loader.e.b.g gVar, Bitmap bitmap) {
            AppMethodBeat.i(262219);
            final Bitmap bitmap2 = bitmap;
            View view = this.Usu.aus;
            kotlin.g.b.p.g(view, "holder.itemView");
            if (!kotlin.g.b.p.j(view.getTag(), this.uAB.LFP)) {
                String str = this.Ust.TAG;
                StringBuilder sb = new StringBuilder("onBindComboLiveRewardMsg tag:");
                View view2 = this.Usu.aus;
                kotlin.g.b.p.g(view2, "holder.itemView");
                Log.i(str, sb.append(view2.getTag()).append(",payload id:").append(this.uAB.LFP).toString());
                AppMethodBeat.o(262219);
            } else if (bitmap2 != null) {
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.festival.finder.s.f.AnonymousClass1 */
                    final /* synthetic */ f Usy;

                    {
                        this.Usy = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(262218);
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(this.Usy.$context$inlined.getResources(), bitmap2);
                        bitmapDrawable.setBounds(0, 0, this.Usy.Ust.diF(), this.Usy.Ust.diF());
                        com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(bitmapDrawable, 1);
                        int length = this.Usy.Usw.SYG.length() + this.Usy.Ust.diJ().length() + this.Usy.Usv.SYG.length() + 1;
                        this.Usy.Usx.setSpan(aVar, length, length + 1, 33);
                        this.Usy.Usu.uAu.aw(this.Usy.Usx);
                        this.Usy.Usu.uAu.invalidate();
                        x xVar = x.SXb;
                        AppMethodBeat.o(262218);
                        return xVar;
                    }
                });
                AppMethodBeat.o(262219);
            } else {
                Log.i(this.Ust.TAG, "onBindComboLiveRewardMsg resource is null!");
                AppMethodBeat.o(262219);
            }
        }
    }

    public s(com.tencent.mm.plugin.finder.live.viewmodel.g gVar) {
        int i2;
        kotlin.g.b.p.h(gVar, "roomData");
        AppMethodBeat.i(262245);
        this.uAs = gVar;
        Context context = MMApplicationContext.getContext();
        kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
        this.uAg = new ForegroundColorSpan(context.getResources().getColor(R.color.aga));
        this.uAh = kotlin.g.ah(q.UsA);
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
            i2 = 17;
        } else {
            i2 = 15;
        }
        this.uAf = i2;
        this.uAl = kotlin.g.ah(d.Usr);
        this.uAm = kotlin.g.ah(new p(this));
        this.uAn = kotlin.g.ah(C1068s.UsB);
        this.uAo = kotlin.g.ah(new r(this));
        this.uAp = kotlin.g.ah(e.Uss);
        this.uAq = kotlin.g.ah(new o(this));
        this.uAr = kotlin.g.ah(new n(this));
        AppMethodBeat.o(262245);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ b a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(262242);
        kotlin.g.b.p.h(viewGroup, "viewGroup");
        View inflate = View.inflate(viewGroup.getContext(), R.layout.cdk, null);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.topMargin = at.fromDPToPix(viewGroup.getContext(), 4);
        kotlin.g.b.p.g(inflate, "itemView");
        inflate.setLayoutParams(marginLayoutParams);
        ((HardTouchableLayout) inflate).setOnInterceptTouchEventCallback(new m());
        ((HardTouchableLayout) inflate).setEnableScale(false);
        b bVar = new b(inflate);
        AppMethodBeat.o(262242);
        return bVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(b bVar, int i2) {
        aus aus;
        String str;
        String string;
        FinderContact finderContact;
        String str2;
        FinderContact finderContact2;
        FinderContact finderContact3;
        int i3;
        com.tencent.mm.pluginsdk.ui.span.m mVar;
        String str3;
        int i4;
        avi avi;
        avi avi2;
        avi avi3;
        AppMethodBeat.i(262244);
        b bVar2 = bVar;
        kotlin.g.b.p.h(bVar2, "holder");
        Context context = MMApplicationContext.getContext();
        View view = bVar2.aus;
        kotlin.g.b.p.g(view, "holder.itemView");
        view.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = bVar2.uAu.getLayoutParams();
        layoutParams.width = -2;
        bVar2.uAu.setLayoutParams(layoutParams);
        View view2 = bVar2.aus;
        kotlin.g.b.p.g(view2, "holder.itemView");
        view2.setTag(Integer.valueOf(this.hXy.get(i2).getType()));
        int type = this.hXy.get(i2).getType();
        o.c cVar = o.c.hGH;
        if (type == o.c.aFn()) {
            kotlin.g.b.p.g(context, "context");
            t tVar = this.hXy.get(i2);
            kotlin.g.b.p.g(tVar, "commentList[position]");
            t tVar2 = tVar;
            com.tencent.mm.plugin.finder.convert.d dVar = com.tencent.mm.plugin.finder.convert.d.tyZ;
            TextPaint paint = bVar2.uAu.getPaint();
            kotlin.g.b.p.g(paint, "holder.contentTv.paint");
            ax axVar = ax.UuB;
            CharSequence a2 = com.tencent.mm.plugin.finder.convert.d.a(context, paint, ax.cC(tVar2.csW(), tVar2.dfr()));
            String content = tVar2.getContent();
            avn dfs = tVar2.dfs();
            boolean z = (dfs == null || (avi3 = dfs.LDK) == null || avi3.LFV != 1) ? false : true;
            if (dfs == null || (avi2 = dfs.LDK) == null) {
                i3 = 0;
            } else {
                i3 = avi2.LFX;
            }
            if (z) {
                if (i3 <= 0) {
                    z = false;
                }
                Log.i(this.TAG, "onBindTextMsg isBadgeUser,badgeLevel:".concat(String.valueOf(i3)));
            }
            String string2 = context.getString(R.string.efi, a2);
            kotlin.g.b.p.g(string2, "context.getString(R.stri…w_content_tmpl, userName)");
            if (z) {
                str3 = context.getString(R.string.cxk, Integer.valueOf(i3));
                kotlin.g.b.p.g(str3, "context.getString(R.stri…_badge_level, badgeLevel)");
                mVar = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.c(context, str3 + string2 + content));
                com.tencent.mm.plugin.finder.utils.m mVar2 = com.tencent.mm.plugin.finder.utils.m.vVH;
                com.tencent.mm.plugin.finder.live.model.g bd = com.tencent.mm.plugin.finder.utils.m.bd(i3, str3);
                bd.ag(str3, str3, String.valueOf(i3));
                bd.atC((dfs == null || (avi = dfs.LDK) == null) ? null : avi.LFY);
                mVar.a(bd, str3, 0);
                ViewParent parent = bVar2.uAu.getParent();
                if (parent == null) {
                    kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
                    AppMethodBeat.o(262244);
                    throw tVar3;
                }
                RelativeLayout relativeLayout = (RelativeLayout) parent;
                relativeLayout.setPadding(0, relativeLayout.getPaddingTop(), relativeLayout.getPaddingRight(), relativeLayout.getPaddingBottom());
            } else {
                mVar = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.c(context, string2 + content));
                ViewParent parent2 = bVar2.uAu.getParent();
                if (parent2 == null) {
                    kotlin.t tVar4 = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
                    AppMethodBeat.o(262244);
                    throw tVar4;
                }
                RelativeLayout relativeLayout2 = (RelativeLayout) parent2;
                ViewParent parent3 = bVar2.uAu.getParent();
                if (parent3 == null) {
                    kotlin.t tVar5 = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
                    AppMethodBeat.o(262244);
                    throw tVar5;
                }
                ((RelativeLayout) parent3).setPadding(diE(), relativeLayout2.getPaddingTop(), relativeLayout2.getPaddingRight(), relativeLayout2.getPaddingBottom());
                str3 = "";
            }
            int length = str3.length();
            if (length >= mVar.length()) {
                i4 = 0;
            } else {
                i4 = length;
            }
            mVar.a(this.uAg, string2, i4);
            bVar2.uAu.aw(mVar);
            bVar2.uAu.setTextSize((float) this.uAf);
            bVar2.cBH.setBackground(context.getResources().getDrawable(R.drawable.cts));
        } else {
            o.c cVar2 = o.c.hGH;
            if (type != o.c.aFo()) {
                o.c cVar3 = o.c.hGH;
                if (type != o.c.aFr()) {
                    o.c cVar4 = o.c.hGH;
                    if (type != o.c.aFs()) {
                        o.c cVar5 = o.c.hGH;
                        if (type == o.c.aFw()) {
                            kotlin.g.b.p.g(context, "context");
                            t tVar6 = this.hXy.get(i2);
                            if (tVar6 == null) {
                                kotlin.t tVar7 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.model.FinderLiveTextMsg");
                                AppMethodBeat.o(262244);
                                throw tVar7;
                            }
                            com.tencent.mm.pluginsdk.ui.span.m mVar3 = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.c(context, context.getString(R.string.cr0) + ' ' + ((com.tencent.mm.plugin.finder.live.model.r) tVar6).uke.content));
                            mVar3.a(diI(), diH(), 0);
                            z.f fVar = new z.f();
                            ViewParent parent4 = bVar2.uAu.getParent();
                            if (parent4 == null) {
                                kotlin.t tVar8 = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
                                AppMethodBeat.o(262244);
                                throw tVar8;
                            }
                            fVar.SYG = (T) ((RelativeLayout) parent4);
                            bVar2.uAu.aw(mVar3);
                            bVar2.uAu.setTextSize((float) this.uAf);
                            bVar2.uAu.setVisibility(0);
                            bVar2.uAu.post(new l(bVar2, fVar, mVar3));
                            bVar2.cBH.setBackground(context.getResources().getDrawable(R.drawable.cts));
                        } else {
                            o.c cVar6 = o.c.hGH;
                            if (type == o.c.aFp()) {
                                kotlin.g.b.p.g(context, "context");
                                t tVar9 = this.hXy.get(i2);
                                if (tVar9 == null) {
                                    kotlin.t tVar10 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.model.FinderLiveTextMsg");
                                    AppMethodBeat.o(262244);
                                    throw tVar10;
                                }
                                awq awq = ((com.tencent.mm.plugin.finder.live.model.r) tVar9).uke;
                                ViewParent parent5 = bVar2.uAu.getParent();
                                if (parent5 == null) {
                                    kotlin.t tVar11 = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
                                    AppMethodBeat.o(262244);
                                    throw tVar11;
                                }
                                RelativeLayout relativeLayout3 = (RelativeLayout) parent5;
                                ViewParent parent6 = bVar2.uAu.getParent();
                                if (parent6 == null) {
                                    kotlin.t tVar12 = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
                                    AppMethodBeat.o(262244);
                                    throw tVar12;
                                }
                                ((RelativeLayout) parent6).setPadding(diE(), relativeLayout3.getPaddingTop(), relativeLayout3.getPaddingRight(), relativeLayout3.getPaddingBottom());
                                Object[] objArr = new Object[1];
                                com.tencent.mm.plugin.finder.convert.d dVar2 = com.tencent.mm.plugin.finder.convert.d.tyZ;
                                TextPaint paint2 = bVar2.uAu.getPaint();
                                kotlin.g.b.p.g(paint2, "holder.contentTv.paint");
                                ax axVar2 = ax.UuB;
                                avn avn = awq.LHp;
                                String str4 = (avn == null || (finderContact3 = avn.contact) == null) ? null : finderContact3.username;
                                avn avn2 = awq.LHp;
                                if (avn2 == null || (finderContact2 = avn2.contact) == null) {
                                    str2 = null;
                                } else {
                                    str2 = finderContact2.nickname;
                                }
                                objArr[0] = com.tencent.mm.plugin.finder.convert.d.a(context, paint2, ax.cC(str4, str2));
                                bVar2.uAu.aw(com.tencent.mm.pluginsdk.ui.span.l.c(context, context.getString(R.string.efk, objArr)));
                                bVar2.uAu.setVisibility(0);
                                bVar2.cBH.setBackground(context.getResources().getDrawable(R.drawable.cts));
                            } else {
                                o.c cVar7 = o.c.hGH;
                                if (type == o.c.aFq()) {
                                    kotlin.g.b.p.g(context, "context");
                                    t tVar13 = this.hXy.get(i2);
                                    if (tVar13 == null) {
                                        kotlin.t tVar14 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.model.FinderLiveTextMsg");
                                        AppMethodBeat.o(262244);
                                        throw tVar14;
                                    }
                                    a(context, bVar2, ((com.tencent.mm.plugin.finder.live.model.r) tVar13).uke);
                                } else if (type == 20002) {
                                    kotlin.g.b.p.g(context, "context");
                                    t tVar15 = this.hXy.get(i2);
                                    kotlin.g.b.p.g(tVar15, "commentList[position]");
                                    t tVar16 = tVar15;
                                    Object[] objArr2 = new Object[2];
                                    String dfr = tVar16.dfr();
                                    if (dfr == null) {
                                        dfr = "";
                                    }
                                    objArr2[0] = dfr;
                                    com.tencent.mm.plugin.finder.utils.m mVar4 = com.tencent.mm.plugin.finder.utils.m.vVH;
                                    objArr2[1] = com.tencent.mm.plugin.finder.utils.m.b(tVar16);
                                    String string3 = context.getString(R.string.cze, objArr2);
                                    kotlin.g.b.p.g(string3, "context.getString(R.stri…l.getAtName(commentData))");
                                    com.tencent.mm.plugin.finder.utils.m mVar5 = com.tencent.mm.plugin.finder.utils.m.vVH;
                                    if (com.tencent.mm.plugin.finder.utils.m.a(tVar16)) {
                                        bVar2.cBH.setBackground(context.getResources().getDrawable(R.drawable.zl));
                                    } else {
                                        bVar2.cBH.setBackground(context.getResources().getDrawable(R.drawable.cts));
                                    }
                                    String content2 = tVar16.getContent();
                                    String string4 = context.getString(R.string.efi, string3);
                                    kotlin.g.b.p.g(string4, "context.getString(R.stri…w_content_tmpl, userName)");
                                    com.tencent.mm.pluginsdk.ui.span.m mVar6 = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.c(context, string4 + content2));
                                    mVar6.a(this.uAg, string4, 0);
                                    bVar2.uAu.aw(mVar6);
                                    ViewParent parent7 = bVar2.uAu.getParent();
                                    if (parent7 == null) {
                                        kotlin.t tVar17 = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
                                        AppMethodBeat.o(262244);
                                        throw tVar17;
                                    }
                                    RelativeLayout relativeLayout4 = (RelativeLayout) parent7;
                                    ViewParent parent8 = bVar2.uAu.getParent();
                                    if (parent8 == null) {
                                        kotlin.t tVar18 = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
                                        AppMethodBeat.o(262244);
                                        throw tVar18;
                                    }
                                    ((RelativeLayout) parent8).setPadding(diE(), relativeLayout4.getPaddingTop(), relativeLayout4.getPaddingRight(), relativeLayout4.getPaddingBottom());
                                    bVar2.uAu.aw(mVar6);
                                    bVar2.uAu.setTextSize((float) this.uAf);
                                } else if (type == 20001) {
                                    kotlin.g.b.p.g(context, "context");
                                    t tVar19 = this.hXy.get(i2);
                                    kotlin.g.b.p.g(tVar19, "commentList[position]");
                                    t tVar20 = tVar19;
                                    com.tencent.mm.plugin.finder.utils.m mVar7 = com.tencent.mm.plugin.finder.utils.m.vVH;
                                    at atVar = at.Uuv;
                                    com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = at.dfZ();
                                    if (dfZ != null) {
                                        aus = dfZ.UQh;
                                    } else {
                                        aus = null;
                                    }
                                    if (com.tencent.mm.plugin.finder.utils.m.a(tVar20, aus)) {
                                        bVar2.cBH.setBackground(context.getResources().getDrawable(R.drawable.zl));
                                        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                                        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
                                        aAh.azQ().get(ar.a.USERINFO_PAT_SUFFIX_STRING_SYNC, "");
                                        String string5 = context.getString(R.string.czq);
                                        kotlin.g.b.p.g(string5, "context.getString(R.string.finder_live_ticke_me)");
                                        Vibrator vibrator = (Vibrator) this.uAh.getValue();
                                        if (vibrator != null) {
                                            vibrator.vibrate(10);
                                            string = string5;
                                        } else {
                                            string = string5;
                                        }
                                    } else {
                                        Object[] objArr3 = new Object[1];
                                        com.tencent.mm.plugin.finder.utils.m mVar8 = com.tencent.mm.plugin.finder.utils.m.vVH;
                                        avn a3 = com.tencent.mm.plugin.finder.utils.m.a(context, tVar20);
                                        if (a3 == null || (finderContact = a3.contact) == null) {
                                            str = null;
                                        } else {
                                            str = finderContact.nickname;
                                        }
                                        objArr3[0] = str;
                                        string = context.getString(R.string.czr, objArr3);
                                        kotlin.g.b.p.g(string, "context.getString(R.stri…Data)?.contact?.nickname)");
                                        bVar2.cBH.setBackground(context.getResources().getDrawable(R.drawable.cts));
                                    }
                                    com.tencent.mm.pluginsdk.ui.span.m mVar9 = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.c(context, context.getString(R.string.cr0) + ' ' + string));
                                    mVar9.a(diI(), context.getString(R.string.cr0), 0);
                                    z.f fVar2 = new z.f();
                                    ViewParent parent9 = bVar2.uAu.getParent();
                                    if (parent9 == null) {
                                        kotlin.t tVar21 = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
                                        AppMethodBeat.o(262244);
                                        throw tVar21;
                                    }
                                    fVar2.SYG = (T) ((RelativeLayout) parent9);
                                    ViewParent parent10 = bVar2.uAu.getParent();
                                    if (parent10 == null) {
                                        kotlin.t tVar22 = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
                                        AppMethodBeat.o(262244);
                                        throw tVar22;
                                    }
                                    ((RelativeLayout) parent10).setPadding(0, fVar2.SYG.getPaddingTop(), fVar2.SYG.getPaddingRight(), fVar2.SYG.getPaddingBottom());
                                    bVar2.uAu.aw(mVar9);
                                    bVar2.uAu.setTextSize((float) this.uAf);
                                    bVar2.uAu.setVisibility(0);
                                    bVar2.uAu.post(new h(bVar2, fVar2, mVar9));
                                } else if (type == 20013) {
                                    t tVar23 = this.hXy.get(i2);
                                    kotlin.g.b.p.g(tVar23, "commentList[position]");
                                    t tVar24 = tVar23;
                                    Object dft = tVar24.dft();
                                    if (!(dft instanceof auy)) {
                                        Log.e(this.TAG, "onBindComboLiveRewardMsg payloadContent isn't FinderLiveAppMsgComboLiveRewardInfo");
                                        AppMethodBeat.o(262244);
                                        return;
                                    }
                                    View view3 = bVar2.aus;
                                    kotlin.g.b.p.g(view3, "holder.itemView");
                                    view3.setTag(((auy) dft).LFP);
                                    kotlin.g.b.p.g(context, "context");
                                    auy auy = (auy) dft;
                                    String str5 = auy.content;
                                    awd awd = auy.LFN;
                                    String str6 = awd != null ? awd.name : null;
                                    int i5 = auy.LFO;
                                    awd awd2 = auy.LFN;
                                    String str7 = awd2 != null ? awd2.LGJ : null;
                                    Log.i(this.TAG, "onBindComboLiveRewardMsg giftContent " + str5 + ",comboCount:" + i5 + ",giftThumbUrl is empty:" + (str7 == null));
                                    z.f fVar3 = new z.f();
                                    com.tencent.mm.plugin.finder.convert.d dVar3 = com.tencent.mm.plugin.finder.convert.d.tyZ;
                                    TextPaint paint3 = bVar2.uAu.getPaint();
                                    kotlin.g.b.p.g(paint3, "holder.contentTv.paint");
                                    ax axVar3 = ax.UuB;
                                    fVar3.SYG = (T) com.tencent.mm.plugin.finder.convert.d.a(context, paint3, ax.cC(tVar24.csW(), tVar24.dfr()));
                                    z.f fVar4 = new z.f();
                                    T t = (T) context.getString(R.string.cxn, str6);
                                    kotlin.g.b.p.g(t, "context.getString(R.stri…sg_gift_prefix, giftName)");
                                    fVar4.SYG = t;
                                    com.tencent.mm.pluginsdk.ui.span.m mVar10 = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.c(context, context.getString(R.string.cxm, ((CharSequence) fVar3.SYG) + ' ' + ((String) fVar4.SYG) + ' ' + "x".concat(String.valueOf(i5)))));
                                    mVar10.a((com.tencent.mm.plugin.finder.live.model.m) this.uAq.getValue(), diJ(), 0);
                                    if (str7 != null) {
                                        com.tencent.mm.plugin.finder.loader.m mVar11 = com.tencent.mm.plugin.finder.loader.m.uJa;
                                        com.tencent.mm.plugin.finder.loader.m.djY().bQ(new com.tencent.mm.plugin.finder.loader.a(str7)).a(new f(this, str7, bVar2, auy, context, fVar3, fVar4, mVar10)).vC();
                                    }
                                    ViewParent parent11 = bVar2.uAu.getParent();
                                    if (parent11 == null) {
                                        kotlin.t tVar25 = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
                                        AppMethodBeat.o(262244);
                                        throw tVar25;
                                    }
                                    RelativeLayout relativeLayout5 = (RelativeLayout) parent11;
                                    relativeLayout5.setPadding(0, relativeLayout5.getPaddingTop(), relativeLayout5.getPaddingRight(), relativeLayout5.getPaddingBottom());
                                    bVar2.uAu.aw(mVar10);
                                    bVar2.uAu.setTextSize((float) this.uAf);
                                    bVar2.cBH.setBackground(context.getResources().getDrawable(R.drawable.cts));
                                } else if (type == 20014) {
                                    kotlin.g.b.p.g(context, "context");
                                    t tVar26 = this.hXy.get(i2);
                                    kotlin.g.b.p.g(tVar26, "commentList[position]");
                                    t tVar27 = tVar26;
                                    Object dft2 = tVar27.dft();
                                    if (!(dft2 instanceof avc)) {
                                        Log.e(this.TAG, "onBindRewardRankNoticeMsg payloadContent isn't FinderLiveAppMsgRewardRankingNoticeInfo");
                                    } else {
                                        int i6 = ((avc) dft2).LFT;
                                        Log.e(this.TAG, "onBindRewardRankNoticeMsg ranking_position ".concat(String.valueOf(i6)));
                                        if (i6 > 0) {
                                            com.tencent.mm.plugin.finder.convert.d dVar4 = com.tencent.mm.plugin.finder.convert.d.tyZ;
                                            TextPaint paint4 = bVar2.uAu.getPaint();
                                            kotlin.g.b.p.g(paint4, "holder.contentTv.paint");
                                            ax axVar4 = ax.UuB;
                                            CharSequence a4 = com.tencent.mm.plugin.finder.convert.d.a(context, paint4, ax.cC(tVar27.csW(), tVar27.dfr()));
                                            String string6 = context.getString(R.string.cxo, Integer.valueOf(i6));
                                            kotlin.g.b.p.g(string6, "context.getString(R.stri…rd_rank_content, rankPos)");
                                            com.tencent.mm.pluginsdk.ui.span.m mVar12 = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.c(context, context.getString(R.string.cr1, a4 + ' ' + string6)));
                                            mVar12.a((com.tencent.mm.plugin.finder.live.model.m) this.uAr.getValue(), diG(), 0);
                                            ViewParent parent12 = bVar2.uAu.getParent();
                                            if (parent12 == null) {
                                                kotlin.t tVar28 = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
                                                AppMethodBeat.o(262244);
                                                throw tVar28;
                                            }
                                            RelativeLayout relativeLayout6 = (RelativeLayout) parent12;
                                            relativeLayout6.setPadding(0, relativeLayout6.getPaddingTop(), relativeLayout6.getPaddingRight(), relativeLayout6.getPaddingBottom());
                                            bVar2.uAu.aw(mVar12);
                                            bVar2.uAu.setTextSize((float) this.uAf);
                                            bVar2.cBH.setBackground(context.getResources().getDrawable(R.drawable.cts));
                                        }
                                    }
                                } else {
                                    Log.i(this.TAG, "invalid type:" + this.hXy.get(i2).getType() + ",pos:" + i2);
                                    View view4 = bVar2.aus;
                                    kotlin.g.b.p.g(view4, "holder.itemView");
                                    view4.setVisibility(8);
                                }
                            }
                        }
                    }
                }
            }
            kotlin.g.b.p.g(context, "context");
            t tVar29 = this.hXy.get(i2);
            if (tVar29 == null) {
                kotlin.t tVar30 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.model.FinderLiveTextMsg");
                AppMethodBeat.o(262244);
                throw tVar30;
            }
            a(context, bVar2, ((com.tencent.mm.plugin.finder.live.model.r) tVar29).uke);
        }
        t tVar31 = (t) kotlin.a.j.L(this.hXy, i2);
        View view5 = bVar2.aus;
        kotlin.g.b.p.g(view5, "holder.itemView");
        view5.setClickable(true);
        View view6 = bVar2.aus;
        if (view6 == null) {
            kotlin.t tVar32 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.HardTouchableLayout");
            AppMethodBeat.o(262244);
            throw tVar32;
        }
        ((HardTouchableLayout) view6).setOnSingleClickListener(new i(this, tVar31, i2, bVar2));
        View view7 = bVar2.aus;
        if (view7 == null) {
            kotlin.t tVar33 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.HardTouchableLayout");
            AppMethodBeat.o(262244);
            throw tVar33;
        }
        ((HardTouchableLayout) view7).setOnLongClickListener(new j(this, bVar2, tVar31, i2));
        View view8 = bVar2.aus;
        if (view8 == null) {
            kotlin.t tVar34 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.HardTouchableLayout");
            AppMethodBeat.o(262244);
            throw tVar34;
        }
        ((HardTouchableLayout) view8).setOnDoubleClickListener(new k(this, i2));
        AppMethodBeat.o(262244);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class h implements Runnable {
        final /* synthetic */ b Usz;
        final /* synthetic */ z.f uoL;
        final /* synthetic */ com.tencent.mm.pluginsdk.ui.span.m uoM;

        h(b bVar, z.f fVar, com.tencent.mm.pluginsdk.ui.span.m mVar) {
            this.Usz = bVar;
            this.uoL = fVar;
            this.uoM = mVar;
        }

        public final void run() {
            AppMethodBeat.i(262221);
            if (this.Usz.uAu.getLineCount() > 1) {
                ViewParent parent = this.Usz.uAu.getParent();
                if (parent == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
                    AppMethodBeat.o(262221);
                    throw tVar;
                }
                ((RelativeLayout) parent).setPadding(0, this.uoL.SYG.getPaddingTop(), 0, this.uoL.SYG.getPaddingBottom());
                this.Usz.uAu.setSpacingAdd(5);
                SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(this.uoM);
                valueOf.setSpan(new LeadingMarginSpan.Standard(0, at.fromDPToPix(MMApplicationContext.getContext(), 11)), 0, this.uoM.length(), 33);
                this.Usz.uAu.aw(valueOf);
            }
            AppMethodBeat.o(262221);
        }
    }

    private final void a(Context context, b bVar, awq awq) {
        AppMethodBeat.i(262238);
        com.tencent.mm.pluginsdk.ui.span.m mVar = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.c(context, context.getString(R.string.cr1, awq.content)));
        mVar.a((com.tencent.mm.plugin.finder.live.model.m) this.uAm.getValue(), diG(), 0);
        z.f fVar = new z.f();
        ViewParent parent = bVar.uAu.getParent();
        if (parent == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
            AppMethodBeat.o(262238);
            throw tVar;
        }
        fVar.SYG = (T) ((RelativeLayout) parent);
        bVar.uAu.aw(mVar);
        bVar.uAu.setTextSize((float) this.uAf);
        bVar.uAu.post(new g(bVar, fVar, mVar));
        bVar.cBH.setBackground(context.getResources().getDrawable(R.drawable.cts));
        AppMethodBeat.o(262238);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class g implements Runnable {
        final /* synthetic */ b Usz;
        final /* synthetic */ z.f uoL;
        final /* synthetic */ com.tencent.mm.pluginsdk.ui.span.m uoM;

        g(b bVar, z.f fVar, com.tencent.mm.pluginsdk.ui.span.m mVar) {
            this.Usz = bVar;
            this.uoL = fVar;
            this.uoM = mVar;
        }

        public final void run() {
            AppMethodBeat.i(262220);
            if (this.Usz.uAu.getLineCount() > 1) {
                this.uoL.SYG.setPadding(0, this.uoL.SYG.getPaddingTop(), 0, this.uoL.SYG.getPaddingBottom());
                this.Usz.uAu.setSpacingAdd(5);
                SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(this.uoM);
                valueOf.setSpan(new LeadingMarginSpan.Standard(0, at.fromDPToPix(MMApplicationContext.getContext(), 6)), 0, this.uoM.length(), 33);
                this.Usz.uAu.aw(valueOf);
                AppMethodBeat.o(262220);
                return;
            }
            this.uoL.SYG.setPadding(0, this.uoL.SYG.getPaddingTop(), this.uoL.SYG.getPaddingRight(), this.uoL.SYG.getPaddingBottom());
            AppMethodBeat.o(262220);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class l implements Runnable {
        final /* synthetic */ b Usz;
        final /* synthetic */ z.f uoL;
        final /* synthetic */ com.tencent.mm.pluginsdk.ui.span.m uoM;

        l(b bVar, z.f fVar, com.tencent.mm.pluginsdk.ui.span.m mVar) {
            this.Usz = bVar;
            this.uoL = fVar;
            this.uoM = mVar;
        }

        public final void run() {
            AppMethodBeat.i(262225);
            if (this.Usz.uAu.getLineCount() > 1) {
                this.uoL.SYG.setPadding(0, this.uoL.SYG.getPaddingTop(), 0, this.uoL.SYG.getPaddingBottom());
                this.Usz.uAu.setSpacingAdd(5);
                SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(this.uoM);
                valueOf.setSpan(new LeadingMarginSpan.Standard(0, at.fromDPToPix(MMApplicationContext.getContext(), 11)), 0, this.uoM.length(), 33);
                this.Usz.uAu.aw(valueOf);
                AppMethodBeat.o(262225);
                return;
            }
            this.uoL.SYG.setPadding(0, this.uoL.SYG.getPaddingTop(), this.uoL.SYG.getPaddingRight(), this.uoL.SYG.getPaddingBottom());
            AppMethodBeat.o(262225);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalFinderLiveCommentAdapter$onCreateViewHolder$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnInterceptTouchEventCallback;", "isIntercept", "", "event", "Landroid/view/MotionEvent;", "plugin-festival_release"})
    public static final class m implements HardTouchableLayout.c {
        m() {
        }

        @Override // com.tencent.mm.view.HardTouchableLayout.c
        public final boolean S(MotionEvent motionEvent) {
            AppMethodBeat.i(262226);
            kotlin.g.b.p.h(motionEvent, "event");
            AppMethodBeat.o(262226);
            return false;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(262243);
        int size = this.hXy.size();
        AppMethodBeat.o(262243);
        return size;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalFinderLiveCommentAdapter$onBindViewHolder$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-festival_release"})
    public static final class i implements HardTouchableLayout.g {
        final /* synthetic */ s Ust;
        final /* synthetic */ b Usz;
        final /* synthetic */ int gUj;
        final /* synthetic */ t uAH;

        i(s sVar, t tVar, int i2, b bVar) {
            this.Ust = sVar;
            this.uAH = tVar;
            this.gUj = i2;
            this.Usz = bVar;
        }

        @Override // com.tencent.mm.view.HardTouchableLayout.g
        public final void b(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(262222);
            kotlin.g.b.p.h(view, "view");
            if (this.uAH != null) {
                Log.i(this.Ust.TAG, "topComment,content:" + this.uAH.getContent() + ",position:" + this.gUj);
                kotlin.g.a.m<? super t, ? super View, x> mVar = this.Ust.uAj;
                if (mVar != null) {
                    t tVar = this.uAH;
                    View view2 = this.Usz.aus;
                    kotlin.g.b.p.g(view2, "holder.itemView");
                    mVar.invoke(tVar, view2);
                    AppMethodBeat.o(262222);
                    return;
                }
                AppMethodBeat.o(262222);
                return;
            }
            Log.w(this.Ust.TAG, "OnClick IndexOutOfBounds! position:" + this.gUj + " commentList.size:" + this.Ust.hXy.size() + " view:" + view);
            AppMethodBeat.o(262222);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalFinderLiveCommentAdapter$onBindViewHolder$2", "Lcom/tencent/mm/view/HardTouchableLayout$OnLongClickListener;", "onLongClick", "", "view", "Landroid/view/View;", "plugin-festival_release"})
    public static final class j implements HardTouchableLayout.d {
        final /* synthetic */ s Ust;
        final /* synthetic */ b Usz;
        final /* synthetic */ int gUj;
        final /* synthetic */ t uAH;

        j(s sVar, b bVar, t tVar, int i2) {
            this.Ust = sVar;
            this.Usz = bVar;
            this.uAH = tVar;
            this.gUj = i2;
        }

        @Override // com.tencent.mm.view.HardTouchableLayout.d
        public final void ea(View view) {
            AppMethodBeat.i(262223);
            kotlin.g.b.p.h(view, "view");
            String obj = this.Usz.uAu.hiT().toString();
            if (this.uAH != null) {
                kotlin.g.a.m<? super t, ? super String, x> mVar = this.Ust.uAi;
                if (mVar != null) {
                    mVar.invoke(this.uAH, obj);
                    AppMethodBeat.o(262223);
                    return;
                }
                AppMethodBeat.o(262223);
                return;
            }
            Log.w(this.Ust.TAG, "OnLongClick IndexOutOfBounds! position:" + this.gUj + " commentList.size:" + this.Ust.hXy.size() + " view:" + view);
            AppMethodBeat.o(262223);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalFinderLiveCommentAdapter$onBindViewHolder$3", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-festival_release"})
    public static final class k implements HardTouchableLayout.b {
        final /* synthetic */ s Ust;
        final /* synthetic */ int gUj;

        k(s sVar, int i2) {
            this.Ust = sVar;
            this.gUj = i2;
        }

        @Override // com.tencent.mm.view.HardTouchableLayout.b
        public final void a(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(262224);
            kotlin.g.b.p.h(view, "view");
            kotlin.g.b.p.h(motionEvent, "e");
            t tVar = (t) kotlin.a.j.L(this.Ust.hXy, this.gUj);
            if (tVar != null) {
                kotlin.g.a.b<? super t, x> bVar = this.Ust.uAk;
                if (bVar != null) {
                    bVar.invoke(tVar);
                    AppMethodBeat.o(262224);
                    return;
                }
                AppMethodBeat.o(262224);
                return;
            }
            Log.w(this.Ust.TAG, "onDoubleClick IndexOutOfBounds! position:" + this.gUj + " commentList.size:" + this.Ust.hXy.size() + " view:" + view);
            AppMethodBeat.o(262224);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveCommentAdapter$LiveCommentItemHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bgView", "getBgView", "()Landroid/view/View;", "contentTv", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "getContentTv", "()Lcom/tencent/neattextview/textview/view/NeatTextView;", "plugin-festival_release"})
    public static final class b extends RecyclerView.v {
        final View cBH;
        final NeatTextView uAu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            kotlin.g.b.p.h(view, "itemView");
            AppMethodBeat.i(262211);
            View findViewById = view.findViewById(R.id.egb);
            kotlin.g.b.p.g(findViewById, "itemView.findViewById(R.…_comment_item_content_tv)");
            this.uAu = (NeatTextView) findViewById;
            View findViewById2 = view.findViewById(R.id.eg9);
            kotlin.g.b.p.g(findViewById2, "itemView.findViewById(R.id.live_comment_container)");
            this.cBH = findViewById2;
            AppMethodBeat.o(262211);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        public static final c Usq = new c();

        static {
            AppMethodBeat.i(262213);
            AppMethodBeat.o(262213);
        }

        c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(262212);
            Context context = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
            Integer valueOf = Integer.valueOf(context.getResources().getDimensionPixelSize(R.dimen.ct));
            AppMethodBeat.o(262212);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        public static final a Usp = new a();

        static {
            AppMethodBeat.i(262210);
            AppMethodBeat.o(262210);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(262209);
            Context context = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
            Integer valueOf = Integer.valueOf(context.getResources().getDimensionPixelSize(R.dimen.ce));
            AppMethodBeat.o(262209);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/os/Vibrator;", "invoke"})
    static final class q extends kotlin.g.b.q implements kotlin.g.a.a<Vibrator> {
        public static final q UsA = new q();

        static {
            AppMethodBeat.i(262231);
            AppMethodBeat.o(262231);
        }

        q() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Vibrator invoke() {
            AppMethodBeat.i(262230);
            Object systemService = MMApplicationContext.getContext().getSystemService("vibrator");
            if (systemService == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.os.Vibrator");
                AppMethodBeat.o(262230);
                throw tVar;
            }
            Vibrator vibrator = (Vibrator) systemService;
            AppMethodBeat.o(262230);
            return vibrator;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        public static final d Usr = new d();

        static {
            AppMethodBeat.i(262215);
            AppMethodBeat.o(262215);
        }

        d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(262214);
            Context context = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
            String string = context.getResources().getString(R.string.cr2);
            AppMethodBeat.o(262214);
            return string;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan;", "invoke"})
    static final class p extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.live.model.m> {
        final /* synthetic */ s Ust;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(s sVar) {
            super(0);
            this.Ust = sVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.live.model.m invoke() {
            AppMethodBeat.i(262229);
            m.a aVar = com.tencent.mm.plugin.finder.live.model.m.ujk;
            String diG = this.Ust.diG();
            kotlin.g.b.p.g(diG, "annoucement");
            Drawable atF = m.a.atF(diG);
            String diG2 = this.Ust.diG();
            kotlin.g.b.p.g(diG2, "annoucement");
            n.a aVar2 = com.tencent.mm.plugin.finder.live.model.n.ujr;
            float f2 = com.tencent.mm.plugin.finder.live.model.n.ujp;
            n.a aVar3 = com.tencent.mm.plugin.finder.live.model.n.ujr;
            float f3 = com.tencent.mm.plugin.finder.live.model.n.ujp;
            Context context = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
            int color = context.getResources().getColor(R.color.BW_100_Alpha_0_3);
            n.a aVar4 = com.tencent.mm.plugin.finder.live.model.n.ujr;
            int i2 = com.tencent.mm.plugin.finder.live.model.n.ujn;
            Context context2 = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context2, "MMApplicationContext.getContext()");
            int color2 = context2.getResources().getColor(R.color.ag2);
            n.a aVar5 = com.tencent.mm.plugin.finder.live.model.n.ujr;
            com.tencent.mm.plugin.finder.live.model.m mVar = new com.tencent.mm.plugin.finder.live.model.m(atF, new com.tencent.mm.plugin.finder.live.model.n(diG2, f2, f3, color, i2, color2, com.tencent.mm.plugin.finder.live.model.n.ujo));
            AppMethodBeat.o(262229);
            return mVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.festival.finder.s$s  reason: collision with other inner class name */
    static final class C1068s extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        public static final C1068s UsB = new C1068s();

        static {
            AppMethodBeat.i(262234);
            AppMethodBeat.o(262234);
        }

        C1068s() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(262233);
            Context context = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
            String string = context.getResources().getString(R.string.cr0);
            AppMethodBeat.o(262233);
            return string;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan;", "invoke"})
    static final class r extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.live.model.m> {
        final /* synthetic */ s Ust;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(s sVar) {
            super(0);
            this.Ust = sVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.live.model.m invoke() {
            AppMethodBeat.i(262232);
            m.a aVar = com.tencent.mm.plugin.finder.live.model.m.ujk;
            String diH = this.Ust.diH();
            kotlin.g.b.p.g(diH, "welcomeTag");
            Drawable atF = m.a.atF(diH);
            String diH2 = this.Ust.diH();
            kotlin.g.b.p.g(diH2, "welcomeTag");
            n.a aVar2 = com.tencent.mm.plugin.finder.live.model.n.ujr;
            float f2 = com.tencent.mm.plugin.finder.live.model.n.ujp;
            n.a aVar3 = com.tencent.mm.plugin.finder.live.model.n.ujr;
            float f3 = com.tencent.mm.plugin.finder.live.model.n.ujp;
            Context context = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
            int color = context.getResources().getColor(R.color.BW_100_Alpha_0_3);
            n.a aVar4 = com.tencent.mm.plugin.finder.live.model.n.ujr;
            int i2 = com.tencent.mm.plugin.finder.live.model.n.ujn;
            Context context2 = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context2, "MMApplicationContext.getContext()");
            int color2 = context2.getResources().getColor(R.color.ag2);
            n.a aVar5 = com.tencent.mm.plugin.finder.live.model.n.ujr;
            com.tencent.mm.plugin.finder.live.model.m mVar = new com.tencent.mm.plugin.finder.live.model.m(atF, new com.tencent.mm.plugin.finder.live.model.n(diH2, f2, f3, color, i2, color2, com.tencent.mm.plugin.finder.live.model.n.ujo));
            AppMethodBeat.o(262232);
            return mVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        public static final e Uss = new e();

        static {
            AppMethodBeat.i(262217);
            AppMethodBeat.o(262217);
        }

        e() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(262216);
            Context context = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
            String string = context.getResources().getString(R.string.cxl);
            AppMethodBeat.o(262216);
            return string;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan;", "invoke"})
    static final class o extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.live.model.m> {
        final /* synthetic */ s Ust;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(s sVar) {
            super(0);
            this.Ust = sVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.live.model.m invoke() {
            AppMethodBeat.i(262228);
            m.a aVar = com.tencent.mm.plugin.finder.live.model.m.ujk;
            String diJ = this.Ust.diJ();
            kotlin.g.b.p.g(diJ, "giftStr");
            Drawable atF = m.a.atF(diJ);
            String diJ2 = this.Ust.diJ();
            kotlin.g.b.p.g(diJ2, "giftStr");
            n.a aVar2 = com.tencent.mm.plugin.finder.live.model.n.ujr;
            float f2 = com.tencent.mm.plugin.finder.live.model.n.ujp;
            n.a aVar3 = com.tencent.mm.plugin.finder.live.model.n.ujr;
            float f3 = com.tencent.mm.plugin.finder.live.model.n.ujp;
            Context context = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
            int color = context.getResources().getColor(R.color.BW_100_Alpha_0_3);
            n.a aVar4 = com.tencent.mm.plugin.finder.live.model.n.ujr;
            int i2 = com.tencent.mm.plugin.finder.live.model.n.ujn;
            Context context2 = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context2, "MMApplicationContext.getContext()");
            int color2 = context2.getResources().getColor(R.color.ag2);
            n.a aVar5 = com.tencent.mm.plugin.finder.live.model.n.ujr;
            com.tencent.mm.plugin.finder.live.model.m mVar = new com.tencent.mm.plugin.finder.live.model.m(atF, new com.tencent.mm.plugin.finder.live.model.n(diJ2, f2, f3, color, i2, color2, com.tencent.mm.plugin.finder.live.model.n.ujo));
            AppMethodBeat.o(262228);
            return mVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan;", "invoke"})
    static final class n extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.live.model.m> {
        final /* synthetic */ s Ust;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(s sVar) {
            super(0);
            this.Ust = sVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.live.model.m invoke() {
            AppMethodBeat.i(262227);
            m.a aVar = com.tencent.mm.plugin.finder.live.model.m.ujk;
            String diG = this.Ust.diG();
            kotlin.g.b.p.g(diG, "annoucement");
            Drawable atF = m.a.atF(diG);
            String diG2 = this.Ust.diG();
            kotlin.g.b.p.g(diG2, "annoucement");
            n.a aVar2 = com.tencent.mm.plugin.finder.live.model.n.ujr;
            float f2 = com.tencent.mm.plugin.finder.live.model.n.ujp;
            n.a aVar3 = com.tencent.mm.plugin.finder.live.model.n.ujr;
            float f3 = com.tencent.mm.plugin.finder.live.model.n.ujp;
            Context context = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
            int color = context.getResources().getColor(R.color.BW_100_Alpha_0_3);
            n.a aVar4 = com.tencent.mm.plugin.finder.live.model.n.ujr;
            int i2 = com.tencent.mm.plugin.finder.live.model.n.ujn;
            Context context2 = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context2, "MMApplicationContext.getContext()");
            int color2 = context2.getResources().getColor(R.color.ag2);
            n.a aVar5 = com.tencent.mm.plugin.finder.live.model.n.ujr;
            com.tencent.mm.plugin.finder.live.model.m mVar = new com.tencent.mm.plugin.finder.live.model.m(atF, new com.tencent.mm.plugin.finder.live.model.n(diG2, f2, f3, color, i2, color2, com.tencent.mm.plugin.finder.live.model.n.ujo));
            AppMethodBeat.o(262227);
            return mVar;
        }
    }
}
