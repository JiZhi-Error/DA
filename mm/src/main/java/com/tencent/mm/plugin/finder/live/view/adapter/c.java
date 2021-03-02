package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Vibrator;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.live.model.m;
import com.tencent.mm.plugin.finder.live.model.n;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.auy;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.fgm;
import com.tencent.mm.protocal.protobuf.fgn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.at;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.ArrayList;
import kotlin.g.b.z;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u0001\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010m\u001a\u0002062\u0006\u0010N\u001a\u00020\u001dJ\b\u0010n\u001a\u00020\u0007H\u0016J \u0010o\u001a\u00020<2\u0006\u0010C\u001a\u00020p2\u0006\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020\u0007H\u0002J\u0018\u0010t\u001a\u00020<2\u0006\u0010C\u001a\u00020p2\u0006\u0010q\u001a\u00020rH\u0002J \u0010u\u001a\u0002062\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020\u00022\u0006\u0010y\u001a\u00020\u001dH\u0002J(\u0010z\u001a\u0002062\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020\u00022\u0006\u0010y\u001a\u00020\u001d2\u0006\u0010{\u001a\u00020|H\u0002J \u0010}\u001a\u0002062\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020\u00022\u0006\u0010y\u001a\u00020\u001dH\u0002J \u0010~\u001a\u0002062\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020\u00022\u0006\u0010y\u001a\u00020\u001dH\u0002J \u0010\u001a\u0002062\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020\u00022\u0006\u0010y\u001a\u00020\u001dH\u0002J\"\u0010\u0001\u001a\u0002062\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020\u00022\u0007\u0010y\u001a\u00030\u0001H\u0002J!\u0010\u0001\u001a\u0002062\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020\u00022\u0006\u0010y\u001a\u00020\u001dH\u0002J!\u0010\u0001\u001a\u0002062\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020\u00022\u0006\u0010y\u001a\u00020\u001dH\u0002J\u001a\u0010\u0001\u001a\u0002062\u0006\u0010x\u001a\u00020\u00022\u0007\u0010\u0001\u001a\u00020\u0007H\u0016J\"\u0010\u0001\u001a\u0002062\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020\u00022\u0007\u0010y\u001a\u00030\u0001H\u0002J\"\u0010\u0001\u001a\u0002062\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020\u00022\u0007\u0010y\u001a\u00030\u0001H\u0002J!\u0010\u0001\u001a\u0002062\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020\u00022\u0006\u0010y\u001a\u00020\u001dH\u0002J\u001c\u0010\u0001\u001a\u00020\u00022\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0007H\u0016J\u000f\u0010\u0001\u001a\u0002062\u0006\u0010N\u001a\u00020\u001dJ\u0018\u0010Z\u001a\u0002062\u0006\u0010C\u001a\u00020\u001d2\u0006\u0010x\u001a\u00020\u0002H\u0002J\u0016\u0010\u0001\u001a\u0002062\r\u0010\u001b\u001a\t\u0012\u0004\u0012\u00020\u001d0\u0001J\u000b\u0010\u0001\u001a\u000206*\u00020\u0002R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\u00078FX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\r\u0010\tR\u001b\u0010\u000f\u001a\u00020\u00078FX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0010\u0010\tR\u000e\u0010\u0012\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00078FX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0015\u0010\tR\u001b\u0010\u0017\u001a\u00020\u00138FX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R!\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020\u00138FX\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b#\u0010\u0019R\u001a\u0010%\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\t\"\u0004\b'\u0010(R\u001b\u0010)\u001a\u00020*8FX\u0002¢\u0006\f\n\u0004\b-\u0010\u000b\u001a\u0004\b+\u0010,R\u001b\u0010.\u001a\u00020\u00138FX\u0002¢\u0006\f\n\u0004\b0\u0010\u000b\u001a\u0004\b/\u0010\u0019R9\u00101\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0004\u0012\u000206\u0018\u000102X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@RL\u0010A\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(C\u0012\u0013\u0012\u00110D¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(E\u0012\u0004\u0012\u000206\u0018\u00010BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR7\u0010J\u001a\u001f\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(C\u0012\u0004\u0012\u000206\u0018\u000102X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u00108\"\u0004\bL\u0010:RL\u0010M\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(C\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(N\u0012\u0004\u0012\u000206\u0018\u00010BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010G\"\u0004\bP\u0010IR\u001b\u0010Q\u001a\u00020*8FX\u0002¢\u0006\f\n\u0004\bS\u0010\u000b\u001a\u0004\bR\u0010,R\u001b\u0010T\u001a\u00020*8FX\u0002¢\u0006\f\n\u0004\bV\u0010\u000b\u001a\u0004\bU\u0010,R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010\u0005R\u001a\u0010Z\u001a\u00020<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010>\"\u0004\b\\\u0010@R\u001b\u0010]\u001a\u00020*8FX\u0002¢\u0006\f\n\u0004\b_\u0010\u000b\u001a\u0004\b^\u0010,R\u000e\u0010`\u001a\u00020aX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010b\u001a\u00020c8FX\u0002¢\u0006\f\n\u0004\bf\u0010\u000b\u001a\u0004\bd\u0010eR\u001b\u0010g\u001a\u00020*8FX\u0002¢\u0006\f\n\u0004\bi\u0010\u000b\u001a\u0004\bh\u0010,R\u001b\u0010j\u001a\u00020\u00138FX\u0002¢\u0006\f\n\u0004\bl\u0010\u000b\u001a\u0004\bk\u0010\u0019¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$LiveCommentItemHolder;", "roomData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;)V", "GIFT_ICON_SIZE", "", "getGIFT_ICON_SIZE", "()I", "GIFT_ICON_SIZE$delegate", "Lkotlin/Lazy;", "LUCKY_MONEY_HEIGHT_SIZE", "getLUCKY_MONEY_HEIGHT_SIZE", "LUCKY_MONEY_HEIGHT_SIZE$delegate", "LUCKY_MONEY_WIDTH_SIZE", "getLUCKY_MONEY_WIDTH_SIZE", "LUCKY_MONEY_WIDTH_SIZE$delegate", "TAG", "", "TEXT_PADDING_LEFT", "getTEXT_PADDING_LEFT", "TEXT_PADDING_LEFT$delegate", "annoucement", "getAnnoucement", "()Ljava/lang/String;", "annoucement$delegate", "commentList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "Lkotlin/collections/ArrayList;", "getCommentList", "()Ljava/util/ArrayList;", "contentFontSize", "giftStr", "getGiftStr", "giftStr$delegate", "lineMaxWidth", "getLineMaxWidth", "setLineMaxWidth", "(I)V", "locationSpan", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan;", "getLocationSpan", "()Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan;", "locationSpan$delegate", "locationTag", "getLocationTag", "locationTag$delegate", "luckyMoneyClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "sendId", "", "getLuckyMoneyClickListener", "()Lkotlin/jvm/functions/Function1;", "setLuckyMoneyClickListener", "(Lkotlin/jvm/functions/Function1;)V", "micEnable", "", "getMicEnable", "()Z", "setMicEnable", "(Z)V", "onItemClickListener", "Lkotlin/Function2;", "msg", "Landroid/view/View;", "view", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onItemDoubleClickListener", "getOnItemDoubleClickListener", "setOnItemDoubleClickListener", "onItemLongClickListener", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "getOnItemLongClickListener", "setOnItemLongClickListener", "rankNoticeImageSpan", "getRankNoticeImageSpan", "rankNoticeImageSpan$delegate", "rewardImageSpan", "getRewardImageSpan", "rewardImageSpan$delegate", "getRoomData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "setRoomData", "runTestCode", "getRunTestCode", "setRunTestCode", "sysAnnoucementImageSpan", "getSysAnnoucementImageSpan", "sysAnnoucementImageSpan$delegate", "userNameSpan", "Landroid/text/style/ForegroundColorSpan;", "vibrator", "Landroid/os/Vibrator;", "getVibrator", "()Landroid/os/Vibrator;", "vibrator$delegate", "welcomeImageSpan", "getWelcomeImageSpan", "welcomeImageSpan$delegate", "welcomeTag", "getWelcomeTag", "welcomeTag$delegate", "appendComment", "getItemCount", "giftSingleLine", "", "tv", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "maxIndex", "matchRules", "onBindAtMsg", "context", "Landroid/content/Context;", "holder", "commentData", "onBindComboLiveRewardMsg", "payloadContent", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgComboLiveRewardInfo;", "onBindRecvLuckyMoneyMsg", "onBindRewardRankNoticeMsg", "onBindSendLuckyMoneyMsg", "onBindSysMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "onBindTextMsg", "onBindTickleMsg", "onBindViewHolder", "position", "onBindVisistorJoinLive", "onBindWelcomeMsg", "onBinderLocationMsg", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "removeComment", "updateComments", "", "reset", "LiveCommentItemHolder", "LiveHeightSpan", "plugin-finder_release"})
public final class c extends RecyclerView.a<b> {
    private final String TAG = "Finder.FinderLiveCommentAdapter";
    private final kotlin.f UOd = kotlin.g.ah(u.UOm);
    private final kotlin.f UOe = kotlin.g.ah(t.UOl);
    public int UOf;
    public boolean UOg;
    public kotlin.g.a.b<? super String, kotlin.x> UOh;
    private final kotlin.f UOi;
    private final kotlin.f UOj;
    private boolean UOk;
    public final ArrayList<com.tencent.mm.plugin.finder.live.model.t> hXy = new ArrayList<>();
    private final kotlin.f uAd = kotlin.g.ah(C1197c.uAv);
    private final kotlin.f uAe = kotlin.g.ah(a.uAt);
    private final int uAf;
    private final ForegroundColorSpan uAg;
    private final kotlin.f uAh;
    kotlin.g.a.m<? super com.tencent.mm.plugin.finder.live.model.t, ? super String, kotlin.x> uAi;
    public kotlin.g.a.m<? super com.tencent.mm.plugin.finder.live.model.t, ? super View, kotlin.x> uAj;
    public kotlin.g.a.b<? super com.tencent.mm.plugin.finder.live.model.t, kotlin.x> uAk;
    private final kotlin.f uAl;
    private final kotlin.f uAm;
    private final kotlin.f uAn;
    private final kotlin.f uAo;
    private final kotlin.f uAp;
    private final kotlin.f uAq;
    private final kotlin.f uAr;
    private com.tencent.mm.plugin.finder.live.viewmodel.g uAs;

    private int diE() {
        AppMethodBeat.i(247760);
        int intValue = ((Number) this.uAd.getValue()).intValue();
        AppMethodBeat.o(247760);
        return intValue;
    }

    private com.tencent.mm.plugin.finder.live.model.m diI() {
        AppMethodBeat.i(247765);
        com.tencent.mm.plugin.finder.live.model.m mVar = (com.tencent.mm.plugin.finder.live.model.m) this.uAo.getValue();
        AppMethodBeat.o(247765);
        return mVar;
    }

    private int hTK() {
        AppMethodBeat.i(260904);
        int intValue = ((Number) this.UOd.getValue()).intValue();
        AppMethodBeat.o(260904);
        return intValue;
    }

    private int hTL() {
        AppMethodBeat.i(260905);
        int intValue = ((Number) this.UOe.getValue()).intValue();
        AppMethodBeat.o(260905);
        return intValue;
    }

    public final int diF() {
        AppMethodBeat.i(247761);
        int intValue = ((Number) this.uAe.getValue()).intValue();
        AppMethodBeat.o(247761);
        return intValue;
    }

    public final String diG() {
        AppMethodBeat.i(247762);
        String str = (String) this.uAl.getValue();
        AppMethodBeat.o(247762);
        return str;
    }

    public final String diH() {
        AppMethodBeat.i(247764);
        String str = (String) this.uAn.getValue();
        AppMethodBeat.o(247764);
        return str;
    }

    public final String diJ() {
        AppMethodBeat.i(247766);
        String str = (String) this.uAp.getValue();
        AppMethodBeat.o(247766);
        return str;
    }

    public final com.tencent.mm.plugin.finder.live.model.m hTM() {
        AppMethodBeat.i(260908);
        com.tencent.mm.plugin.finder.live.model.m mVar = (com.tencent.mm.plugin.finder.live.model.m) this.uAq.getValue();
        AppMethodBeat.o(260908);
        return mVar;
    }

    public final String hTN() {
        AppMethodBeat.i(260909);
        String str = (String) this.UOi.getValue();
        AppMethodBeat.o(260909);
        return str;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u0016\u0010\u0006\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u00072\u000e\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n¨\u0006\u000b"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete", "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$onBindComboLiveRewardMsg$3$1"})
    static final class f<T, R> implements com.tencent.mm.loader.f.e<com.tencent.mm.plugin.finder.loader.o, Bitmap> {
        final /* synthetic */ Context $context$inlined;
        final /* synthetic */ z.f UOo;
        final /* synthetic */ z.d UOp;
        final /* synthetic */ b uAA;
        final /* synthetic */ auy uAB;
        final /* synthetic */ c uAy;
        final /* synthetic */ String uAz;

        f(c cVar, String str, b bVar, auy auy, Context context, z.f fVar, z.d dVar) {
            this.uAy = cVar;
            this.uAz = str;
            this.uAA = bVar;
            this.uAB = auy;
            this.$context$inlined = context;
            this.UOo = fVar;
            this.UOp = dVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.h.a.a, com.tencent.mm.loader.e.b.g, java.lang.Object] */
        @Override // com.tencent.mm.loader.f.e
        public final /* synthetic */ void a(com.tencent.mm.loader.h.a.a<com.tencent.mm.plugin.finder.loader.o> aVar, com.tencent.mm.loader.e.b.g gVar, Bitmap bitmap) {
            AppMethodBeat.i(247744);
            final Bitmap bitmap2 = bitmap;
            View view = this.uAA.aus;
            kotlin.g.b.p.g(view, "holder.itemView");
            if (!kotlin.g.b.p.j(view.getTag(), this.uAB.LFP)) {
                String str = this.uAy.TAG;
                StringBuilder sb = new StringBuilder("onBindComboLiveRewardMsg tag:");
                View view2 = this.uAA.aus;
                kotlin.g.b.p.g(view2, "holder.itemView");
                Log.i(str, sb.append(view2.getTag()).append(",payload id:").append(this.uAB.LFP).toString());
                AppMethodBeat.o(247744);
            } else if (bitmap2 != null) {
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                    /* class com.tencent.mm.plugin.finder.live.view.adapter.c.f.AnonymousClass1 */
                    final /* synthetic */ f uAF;

                    {
                        this.uAF = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ kotlin.x invoke() {
                        AppMethodBeat.i(247743);
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(this.uAF.$context$inlined.getResources(), bitmap2);
                        bitmapDrawable.setBounds(0, 0, this.uAF.uAy.diF(), this.uAF.uAy.diF());
                        this.uAF.UOo.SYG.setSpan(new com.tencent.mm.ui.widget.a(bitmapDrawable, 1), this.uAF.UOp.SYE, this.uAF.UOp.SYE + 1, 33);
                        this.uAF.uAA.uAu.aw(this.uAF.UOo.SYG);
                        this.uAF.uAA.uAu.invalidate();
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(247743);
                        return xVar;
                    }
                });
                AppMethodBeat.o(247744);
            } else {
                Log.i(this.uAy.TAG, "onBindComboLiveRewardMsg resource is null!");
                AppMethodBeat.o(247744);
            }
        }
    }

    public c(com.tencent.mm.plugin.finder.live.viewmodel.g gVar) {
        int i2;
        kotlin.g.b.p.h(gVar, "roomData");
        AppMethodBeat.i(247770);
        this.uAs = gVar;
        Context context = MMApplicationContext.getContext();
        kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
        this.uAg = new ForegroundColorSpan(context.getResources().getColor(R.color.ua));
        this.uAh = kotlin.g.ah(q.uAI);
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
            i2 = 17;
        } else {
            i2 = 15;
        }
        this.uAf = i2;
        this.uAl = kotlin.g.ah(d.uAw);
        this.uAm = kotlin.g.ah(new p(this));
        this.uAn = kotlin.g.ah(s.uAJ);
        this.uAo = kotlin.g.ah(new r(this));
        this.uAp = kotlin.g.ah(e.uAx);
        this.uAq = kotlin.g.ah(new o(this));
        this.uAr = kotlin.g.ah(new n(this));
        this.UOi = kotlin.g.ah(w.UOn);
        this.UOj = kotlin.g.ah(new v(this));
        this.UOk = true;
        AppMethodBeat.o(247770);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ b a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(247767);
        kotlin.g.b.p.h(viewGroup, "viewGroup");
        View inflate = View.inflate(viewGroup.getContext(), R.layout.adf, null);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.topMargin = at.fromDPToPix(viewGroup.getContext(), 4);
        kotlin.g.b.p.g(inflate, "itemView");
        inflate.setLayoutParams(marginLayoutParams);
        ((HardTouchableLayout) inflate).setOnInterceptTouchEventCallback(new m());
        ((HardTouchableLayout) inflate).setEnableScale(false);
        b bVar = new b(inflate);
        AppMethodBeat.o(247767);
        return bVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    /* JADX DEBUG: Multi-variable search result rejected for r16v1, resolved type: com.tencent.mm.pluginsdk.ui.span.m */
    /* JADX DEBUG: Multi-variable search result rejected for r5v234, resolved type: com.tencent.mm.pluginsdk.ui.span.m */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0ae7  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0b1f  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x0e84  */
    @Override // android.support.v7.widget.RecyclerView.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void a(com.tencent.mm.plugin.finder.live.view.adapter.c.b r31, int r32) {
        /*
        // Method dump skipped, instructions count: 5110
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.view.adapter.c.a(android.support.v7.widget.RecyclerView$v, int):void");
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class h implements Runnable {
        final /* synthetic */ b uAG;
        final /* synthetic */ z.f uoL;
        final /* synthetic */ com.tencent.mm.pluginsdk.ui.span.m uoM;

        h(b bVar, z.f fVar, com.tencent.mm.pluginsdk.ui.span.m mVar) {
            this.uAG = bVar;
            this.uoL = fVar;
            this.uoM = mVar;
        }

        public final void run() {
            AppMethodBeat.i(247746);
            if (this.uAG.uAu.getLineCount() > 1) {
                ViewParent parent = this.uAG.uAu.getParent();
                if (parent == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
                    AppMethodBeat.o(247746);
                    throw tVar;
                }
                ((RelativeLayout) parent).setPadding(0, this.uoL.SYG.getPaddingTop(), 0, this.uoL.SYG.getPaddingBottom());
                this.uAG.uAu.setSpacingAdd(5);
                SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(this.uoM);
                valueOf.setSpan(new LeadingMarginSpan.Standard(0, at.fromDPToPix(MMApplicationContext.getContext(), 11)), 0, this.uoM.length(), 33);
                this.uAG.uAu.aw(valueOf);
            }
            AppMethodBeat.o(247746);
        }
    }

    private final void a(Context context, b bVar, awq awq) {
        AppMethodBeat.i(247763);
        com.tencent.mm.pluginsdk.ui.span.m mVar = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.c(context, context.getString(R.string.cr1, awq.content)));
        mVar.a((com.tencent.mm.plugin.finder.live.model.m) this.uAm.getValue(), diG(), 0);
        z.f fVar = new z.f();
        ViewParent parent = bVar.uAu.getParent();
        if (parent == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
            AppMethodBeat.o(247763);
            throw tVar;
        }
        fVar.SYG = (T) ((RelativeLayout) parent);
        bVar.uAu.aw(mVar);
        bVar.uAu.setTextSize((float) this.uAf);
        bVar.uAu.post(new g(bVar, fVar, mVar));
        bVar.cBH.setBackground(context.getResources().getDrawable(R.drawable.a0f));
        AppMethodBeat.o(247763);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class g implements Runnable {
        final /* synthetic */ b uAG;
        final /* synthetic */ z.f uoL;
        final /* synthetic */ com.tencent.mm.pluginsdk.ui.span.m uoM;

        g(b bVar, z.f fVar, com.tencent.mm.pluginsdk.ui.span.m mVar) {
            this.uAG = bVar;
            this.uoL = fVar;
            this.uoM = mVar;
        }

        public final void run() {
            AppMethodBeat.i(247745);
            if (this.uAG.uAu.getLineCount() > 1) {
                this.uoL.SYG.setPadding(0, this.uoL.SYG.getPaddingTop(), 0, this.uoL.SYG.getPaddingBottom());
                this.uAG.uAu.setSpacingAdd(5);
                SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(this.uoM);
                valueOf.setSpan(new LeadingMarginSpan.Standard(0, at.fromDPToPix(MMApplicationContext.getContext(), 6)), 0, this.uoM.length(), 33);
                this.uAG.uAu.aw(valueOf);
                AppMethodBeat.o(247745);
                return;
            }
            this.uoL.SYG.setPadding(0, this.uoL.SYG.getPaddingTop(), this.uoL.SYG.getPaddingRight(), this.uoL.SYG.getPaddingBottom());
            AppMethodBeat.o(247745);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class l implements Runnable {
        final /* synthetic */ b uAG;
        final /* synthetic */ z.f uoL;
        final /* synthetic */ com.tencent.mm.pluginsdk.ui.span.m uoM;

        l(b bVar, z.f fVar, com.tencent.mm.pluginsdk.ui.span.m mVar) {
            this.uAG = bVar;
            this.uoL = fVar;
            this.uoM = mVar;
        }

        public final void run() {
            AppMethodBeat.i(247750);
            if (this.uAG.uAu.getLineCount() > 1) {
                this.uoL.SYG.setPadding(0, this.uoL.SYG.getPaddingTop(), 0, this.uoL.SYG.getPaddingBottom());
                this.uAG.uAu.setSpacingAdd(5);
                SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(this.uoM);
                valueOf.setSpan(new LeadingMarginSpan.Standard(0, at.fromDPToPix(MMApplicationContext.getContext(), 11)), 0, this.uoM.length(), 33);
                this.uAG.uAu.aw(valueOf);
                AppMethodBeat.o(247750);
                return;
            }
            this.uoL.SYG.setPadding(0, this.uoL.SYG.getPaddingTop(), this.uoL.SYG.getPaddingRight(), this.uoL.SYG.getPaddingBottom());
            AppMethodBeat.o(247750);
        }
    }

    private final boolean a(CharSequence charSequence, NeatTextView neatTextView) {
        int i2;
        AppMethodBeat.i(260906);
        int paddingLeft = (this.UOf - neatTextView.getPaddingLeft()) - neatTextView.getPaddingRight();
        ViewParent parent = neatTextView.getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        int paddingLeft2 = paddingLeft - (viewGroup != null ? viewGroup.getPaddingLeft() : 0);
        ViewParent parent2 = neatTextView.getParent();
        if (!(parent2 instanceof ViewGroup)) {
            parent2 = null;
        }
        ViewGroup viewGroup2 = (ViewGroup) parent2;
        if (viewGroup2 != null) {
            i2 = viewGroup2.getPaddingRight();
        } else {
            i2 = 0;
        }
        int i3 = paddingLeft2 - i2;
        if (i3 > 0) {
            int maxLines = neatTextView.getMaxLines();
            neatTextView.setMaxLines(Integer.MAX_VALUE);
            neatTextView.aw(charSequence);
            com.tencent.neattextview.textview.layout.a mq = neatTextView.mq(i3, Integer.MAX_VALUE);
            kotlin.g.b.p.g(mq, "staticLayout");
            int hiG = mq.hiG();
            neatTextView.setMaxLines(maxLines);
            if (hiG <= 1) {
                AppMethodBeat.o(260906);
                return true;
            } else if (hiG > 2) {
                AppMethodBeat.o(260906);
                return false;
            } else if (((float) i3) - mq.getLineWidth(1) > ((float) diF())) {
                AppMethodBeat.o(260906);
                return true;
            } else {
                AppMethodBeat.o(260906);
                return false;
            }
        } else {
            Log.i(this.TAG, "matchRules " + i3 + ", " + charSequence);
            AppMethodBeat.o(260906);
            return true;
        }
    }

    private final boolean a(CharSequence charSequence, NeatTextView neatTextView, int i2) {
        AppMethodBeat.i(260907);
        try {
            int paddingLeft = (this.UOf - neatTextView.getPaddingLeft()) - neatTextView.getPaddingRight();
            ViewParent parent = neatTextView.getParent();
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            int paddingLeft2 = paddingLeft - (viewGroup != null ? viewGroup.getPaddingLeft() : 0);
            ViewParent parent2 = neatTextView.getParent();
            if (!(parent2 instanceof ViewGroup)) {
                parent2 = null;
            }
            ViewGroup viewGroup2 = (ViewGroup) parent2;
            int paddingRight = (paddingLeft2 - (viewGroup2 != null ? viewGroup2.getPaddingRight() : 0)) - 6;
            if (paddingRight <= 0 || paddingRight <= diF()) {
                Log.i(this.TAG, "giftSingleLine " + paddingRight + ", " + charSequence);
                AppMethodBeat.o(260907);
                return false;
            }
            int maxLines = neatTextView.getMaxLines();
            neatTextView.setMaxLines(Integer.MAX_VALUE);
            neatTextView.aw(charSequence);
            com.tencent.neattextview.textview.layout.a mq = neatTextView.mq(paddingRight - diF(), Integer.MAX_VALUE);
            kotlin.g.b.p.g(mq, "staticLayout");
            int hiG = mq.hiG();
            neatTextView.setMaxLines(maxLines);
            if (hiG <= 1 || mq.getLineStart(1) <= i2) {
                AppMethodBeat.o(260907);
                return false;
            }
            AppMethodBeat.o(260907);
            return true;
        } catch (Throwable th) {
            Log.printErrStackTrace(this.TAG, th, "", new Object[0]);
            AppMethodBeat.o(260907);
            return false;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$onBindSendLuckyMoneyMsg$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
    public static final class ad extends ClickableSpan {
        final /* synthetic */ Context $context;
        final /* synthetic */ com.tencent.mm.plugin.finder.live.model.t UOw;
        final /* synthetic */ c uAy;

        ad(c cVar, com.tencent.mm.plugin.finder.live.model.t tVar, Context context) {
            this.uAy = cVar;
            this.UOw = tVar;
            this.$context = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(260902);
            kotlin.g.b.p.h(view, "widget");
            if (this.UOw instanceof com.tencent.mm.plugin.finder.live.model.aa) {
                Object dft = this.UOw.dft();
                if (dft == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveAppMsgSendRedPacketInfo");
                    AppMethodBeat.o(260902);
                    throw tVar;
                }
                fgn fgn = (fgn) dft;
                kotlin.g.a.b<? super String, kotlin.x> bVar = this.uAy.UOh;
                if (bVar != null) {
                    bVar.invoke(fgn.ViT);
                    AppMethodBeat.o(260902);
                    return;
                }
            }
            AppMethodBeat.o(260902);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.i(260903);
            kotlin.g.b.p.h(textPaint, "ds");
            textPaint.setColor(this.$context.getResources().getColor(R.color.agq));
            textPaint.setUnderlineText(false);
            textPaint.clearShadowLayer();
            AppMethodBeat.o(260903);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$onBindRecvLuckyMoneyMsg$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
    public static final class ac extends ClickableSpan {
        final /* synthetic */ Context $context;
        final /* synthetic */ com.tencent.mm.plugin.finder.live.model.t UOw;
        final /* synthetic */ c uAy;

        ac(c cVar, com.tencent.mm.plugin.finder.live.model.t tVar, Context context) {
            this.uAy = cVar;
            this.UOw = tVar;
            this.$context = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(260900);
            kotlin.g.b.p.h(view, "widget");
            if (this.UOw instanceof com.tencent.mm.plugin.finder.live.model.z) {
                Object dft = this.UOw.dft();
                if (dft == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveAppMsgRecvRedPacketInfo");
                    AppMethodBeat.o(260900);
                    throw tVar;
                }
                fgm fgm = (fgm) dft;
                kotlin.g.a.b<? super String, kotlin.x> bVar = this.uAy.UOh;
                if (bVar != null) {
                    bVar.invoke(fgm.ViT);
                    AppMethodBeat.o(260900);
                    return;
                }
            }
            AppMethodBeat.o(260900);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.i(260901);
            kotlin.g.b.p.h(textPaint, "ds");
            textPaint.setColor(this.$context.getResources().getColor(R.color.agq));
            textPaint.setUnderlineText(false);
            textPaint.clearShadowLayer();
            AppMethodBeat.o(260901);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$onCreateViewHolder$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnInterceptTouchEventCallback;", "isIntercept", "", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"})
    public static final class m implements HardTouchableLayout.c {
        m() {
        }

        @Override // com.tencent.mm.view.HardTouchableLayout.c
        public final boolean S(MotionEvent motionEvent) {
            AppMethodBeat.i(247751);
            kotlin.g.b.p.h(motionEvent, "event");
            AppMethodBeat.o(247751);
            return false;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(247768);
        int size = this.hXy.size();
        AppMethodBeat.o(247768);
        return size;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$onBindViewHolder$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
    public static final class i implements HardTouchableLayout.g {
        final /* synthetic */ int gUj;
        final /* synthetic */ b uAG;
        final /* synthetic */ com.tencent.mm.plugin.finder.live.model.t uAH;
        final /* synthetic */ c uAy;

        i(c cVar, com.tencent.mm.plugin.finder.live.model.t tVar, int i2, b bVar) {
            this.uAy = cVar;
            this.uAH = tVar;
            this.gUj = i2;
            this.uAG = bVar;
        }

        @Override // com.tencent.mm.view.HardTouchableLayout.g
        public final void b(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(247747);
            kotlin.g.b.p.h(view, "view");
            if (this.uAH != null) {
                Log.i(this.uAy.TAG, "topComment,content:" + this.uAH.getContent() + ",position:" + this.gUj);
                kotlin.g.a.m<? super com.tencent.mm.plugin.finder.live.model.t, ? super View, kotlin.x> mVar = this.uAy.uAj;
                if (mVar != null) {
                    com.tencent.mm.plugin.finder.live.model.t tVar = this.uAH;
                    View view2 = this.uAG.aus;
                    kotlin.g.b.p.g(view2, "holder.itemView");
                    mVar.invoke(tVar, view2);
                    AppMethodBeat.o(247747);
                    return;
                }
                AppMethodBeat.o(247747);
                return;
            }
            Log.w(this.uAy.TAG, "OnClick IndexOutOfBounds! position:" + this.gUj + " commentList.size:" + this.uAy.hXy.size() + " view:" + view);
            AppMethodBeat.o(247747);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$onBindViewHolder$2", "Lcom/tencent/mm/view/HardTouchableLayout$OnLongClickListener;", "onLongClick", "", "view", "Landroid/view/View;", "plugin-finder_release"})
    public static final class j implements HardTouchableLayout.d {
        final /* synthetic */ int gUj;
        final /* synthetic */ b uAG;
        final /* synthetic */ com.tencent.mm.plugin.finder.live.model.t uAH;
        final /* synthetic */ c uAy;

        j(c cVar, b bVar, com.tencent.mm.plugin.finder.live.model.t tVar, int i2) {
            this.uAy = cVar;
            this.uAG = bVar;
            this.uAH = tVar;
            this.gUj = i2;
        }

        @Override // com.tencent.mm.view.HardTouchableLayout.d
        public final void ea(View view) {
            AppMethodBeat.i(247748);
            kotlin.g.b.p.h(view, "view");
            String obj = this.uAG.uAu.hiT().toString();
            if (this.uAH != null) {
                kotlin.g.a.m<? super com.tencent.mm.plugin.finder.live.model.t, ? super String, kotlin.x> mVar = this.uAy.uAi;
                if (mVar != null) {
                    mVar.invoke(this.uAH, obj);
                    AppMethodBeat.o(247748);
                    return;
                }
                AppMethodBeat.o(247748);
                return;
            }
            Log.w(this.uAy.TAG, "OnLongClick IndexOutOfBounds! position:" + this.gUj + " commentList.size:" + this.uAy.hXy.size() + " view:" + view);
            AppMethodBeat.o(247748);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$onBindViewHolder$3", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
    public static final class k implements HardTouchableLayout.b {
        final /* synthetic */ int gUj;
        final /* synthetic */ c uAy;

        k(c cVar, int i2) {
            this.uAy = cVar;
            this.gUj = i2;
        }

        @Override // com.tencent.mm.view.HardTouchableLayout.b
        public final void a(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(247749);
            kotlin.g.b.p.h(view, "view");
            kotlin.g.b.p.h(motionEvent, "e");
            com.tencent.mm.plugin.finder.live.model.t tVar = (com.tencent.mm.plugin.finder.live.model.t) kotlin.a.j.L(this.uAy.hXy, this.gUj);
            if (tVar != null) {
                kotlin.g.a.b<? super com.tencent.mm.plugin.finder.live.model.t, kotlin.x> bVar = this.uAy.uAk;
                if (bVar != null) {
                    bVar.invoke(tVar);
                    AppMethodBeat.o(247749);
                    return;
                }
                AppMethodBeat.o(247749);
                return;
            }
            Log.w(this.uAy.TAG, "onDoubleClick IndexOutOfBounds! position:" + this.gUj + " commentList.size:" + this.uAy.hXy.size() + " view:" + view);
            AppMethodBeat.o(247749);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$LiveCommentItemHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "arrow", "getArrow", "()Landroid/view/View;", "bgView", "getBgView", "contentTv", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "getContentTv", "()Lcom/tencent/neattextview/textview/view/NeatTextView;", "plugin-finder_release"})
    public static final class b extends RecyclerView.v {
        final View cBH;
        final NeatTextView uAu;
        final View uHi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            kotlin.g.b.p.h(view, "itemView");
            AppMethodBeat.i(247736);
            View findViewById = view.findViewById(R.id.egb);
            kotlin.g.b.p.g(findViewById, "itemView.findViewById(R.…_comment_item_content_tv)");
            this.uAu = (NeatTextView) findViewById;
            View findViewById2 = view.findViewById(R.id.eg9);
            kotlin.g.b.p.g(findViewById2, "itemView.findViewById(R.id.live_comment_container)");
            this.cBH = findViewById2;
            View findViewById3 = view.findViewById(R.id.k07);
            kotlin.g.b.p.g(findViewById3, "itemView.findViewById(R.id.live_comment_arrow)");
            this.uHi = findViewById3;
            AppMethodBeat.o(247736);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.finder.live.view.adapter.c$c  reason: collision with other inner class name */
    static final class C1197c extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        public static final C1197c uAv = new C1197c();

        static {
            AppMethodBeat.i(247738);
            AppMethodBeat.o(247738);
        }

        C1197c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(247737);
            Context context = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
            Integer valueOf = Integer.valueOf(context.getResources().getDimensionPixelSize(R.dimen.ct));
            AppMethodBeat.o(247737);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        public static final a uAt = new a();

        static {
            AppMethodBeat.i(247735);
            AppMethodBeat.o(247735);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(247734);
            Context context = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
            Integer valueOf = Integer.valueOf(context.getResources().getDimensionPixelSize(R.dimen.ce));
            AppMethodBeat.o(247734);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class u extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        public static final u UOm = new u();

        static {
            AppMethodBeat.i(260891);
            AppMethodBeat.o(260891);
        }

        u() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(260890);
            Integer valueOf = Integer.valueOf(at.fromDPToPix(MMApplicationContext.getContext(), 12));
            AppMethodBeat.o(260890);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class t extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        public static final t UOl = new t();

        static {
            AppMethodBeat.i(260889);
            AppMethodBeat.o(260889);
        }

        t() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(260888);
            Integer valueOf = Integer.valueOf(at.fromDPToPix(MMApplicationContext.getContext(), 16));
            AppMethodBeat.o(260888);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/os/Vibrator;", "invoke"})
    static final class q extends kotlin.g.b.q implements kotlin.g.a.a<Vibrator> {
        public static final q uAI = new q();

        static {
            AppMethodBeat.i(247756);
            AppMethodBeat.o(247756);
        }

        q() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Vibrator invoke() {
            AppMethodBeat.i(247755);
            Object systemService = MMApplicationContext.getContext().getSystemService("vibrator");
            if (systemService == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.os.Vibrator");
                AppMethodBeat.o(247755);
                throw tVar;
            }
            Vibrator vibrator = (Vibrator) systemService;
            AppMethodBeat.o(247755);
            return vibrator;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        public static final d uAw = new d();

        static {
            AppMethodBeat.i(247740);
            AppMethodBeat.o(247740);
        }

        d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(247739);
            Context context = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
            String string = context.getResources().getString(R.string.cr2);
            AppMethodBeat.o(247739);
            return string;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan;", "invoke"})
    static final class p extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.live.model.m> {
        final /* synthetic */ c uAy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(c cVar) {
            super(0);
            this.uAy = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.live.model.m invoke() {
            AppMethodBeat.i(247754);
            m.a aVar = com.tencent.mm.plugin.finder.live.model.m.ujk;
            String diG = this.uAy.diG();
            kotlin.g.b.p.g(diG, "annoucement");
            Drawable atF = m.a.atF(diG);
            String diG2 = this.uAy.diG();
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
            AppMethodBeat.o(247754);
            return mVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class s extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        public static final s uAJ = new s();

        static {
            AppMethodBeat.i(247759);
            AppMethodBeat.o(247759);
        }

        s() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(247758);
            Context context = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
            String string = context.getResources().getString(R.string.cr0);
            AppMethodBeat.o(247758);
            return string;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan;", "invoke"})
    static final class r extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.live.model.m> {
        final /* synthetic */ c uAy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(c cVar) {
            super(0);
            this.uAy = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.live.model.m invoke() {
            AppMethodBeat.i(247757);
            m.a aVar = com.tencent.mm.plugin.finder.live.model.m.ujk;
            String diH = this.uAy.diH();
            kotlin.g.b.p.g(diH, "welcomeTag");
            Drawable atF = m.a.atF(diH);
            String diH2 = this.uAy.diH();
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
            AppMethodBeat.o(247757);
            return mVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        public static final e uAx = new e();

        static {
            AppMethodBeat.i(247742);
            AppMethodBeat.o(247742);
        }

        e() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(247741);
            Context context = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
            String string = context.getResources().getString(R.string.cxl);
            AppMethodBeat.o(247741);
            return string;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan;", "invoke"})
    static final class o extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.live.model.m> {
        final /* synthetic */ c uAy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(c cVar) {
            super(0);
            this.uAy = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.live.model.m invoke() {
            AppMethodBeat.i(247753);
            m.a aVar = com.tencent.mm.plugin.finder.live.model.m.ujk;
            String diJ = this.uAy.diJ();
            kotlin.g.b.p.g(diJ, "giftStr");
            Drawable atF = m.a.atF(diJ);
            String diJ2 = this.uAy.diJ();
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
            AppMethodBeat.o(247753);
            return mVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpannableString;", "invoke"})
    static final class x extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.pluginsdk.ui.span.m> {
        final /* synthetic */ Context $context;
        final /* synthetic */ z.f UOq;
        final /* synthetic */ z.f UOr;
        final /* synthetic */ z.f UOs;
        final /* synthetic */ c uAy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        x(c cVar, Context context, z.f fVar, z.f fVar2, z.f fVar3) {
            super(0);
            this.uAy = cVar;
            this.$context = context;
            this.UOq = fVar;
            this.UOr = fVar2;
            this.UOs = fVar3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.pluginsdk.ui.span.m invoke() {
            AppMethodBeat.i(260895);
            com.tencent.mm.pluginsdk.ui.span.m mVar = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.c(this.$context, this.$context.getString(R.string.cxm, ((String) this.UOq.SYG) + ' ' + ((String) this.UOr.SYG) + ' ' + ((String) this.UOs.SYG))));
            mVar.a(this.uAy.hTM(), this.uAy.diJ(), 0);
            AppMethodBeat.o(260895);
            return mVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpannableString;", "invoke"})
    static final class z extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.pluginsdk.ui.span.m> {
        final /* synthetic */ Context $context;
        final /* synthetic */ z.f UOr;
        final /* synthetic */ z.f UOs;
        final /* synthetic */ z.f UOu;
        final /* synthetic */ c uAy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        z(c cVar, Context context, z.f fVar, z.f fVar2, z.f fVar3) {
            super(0);
            this.uAy = cVar;
            this.$context = context;
            this.UOu = fVar;
            this.UOr = fVar2;
            this.UOs = fVar3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.pluginsdk.ui.span.m invoke() {
            AppMethodBeat.i(260897);
            com.tencent.mm.pluginsdk.ui.span.m mVar = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.c(this.$context, this.$context.getString(R.string.cxm, ((CharSequence) this.UOu.SYG) + ' ' + ((String) this.UOr.SYG) + ' ' + ((String) this.UOs.SYG))));
            mVar.a(this.uAy.hTM(), this.uAy.diJ(), 0);
            AppMethodBeat.o(260897);
            return mVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpannableString;", "invoke"})
    static final class y extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.pluginsdk.ui.span.m> {
        final /* synthetic */ Context $context;
        final /* synthetic */ z.f UOq;
        final /* synthetic */ z.f UOr;
        final /* synthetic */ z.f UOs;
        final /* synthetic */ String UOt;
        final /* synthetic */ c uAy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        y(c cVar, Context context, z.f fVar, String str, z.f fVar2, z.f fVar3) {
            super(0);
            this.uAy = cVar;
            this.$context = context;
            this.UOq = fVar;
            this.UOt = str;
            this.UOr = fVar2;
            this.UOs = fVar3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.pluginsdk.ui.span.m invoke() {
            AppMethodBeat.i(260896);
            com.tencent.mm.pluginsdk.ui.span.m mVar = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.c(this.$context, this.$context.getString(R.string.cxm, ((String) this.UOq.SYG) + ' ' + this.UOt + ((String) this.UOr.SYG) + ' ' + ((String) this.UOs.SYG))));
            mVar.a(this.uAy.hTM(), this.uAy.diJ(), 0);
            AppMethodBeat.o(260896);
            return mVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpannableString;", "invoke"})
    static final class aa extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.pluginsdk.ui.span.m> {
        final /* synthetic */ Context $context;
        final /* synthetic */ z.f UOr;
        final /* synthetic */ z.f UOs;
        final /* synthetic */ String UOt;
        final /* synthetic */ z.f UOu;
        final /* synthetic */ c uAy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        aa(c cVar, Context context, z.f fVar, String str, z.f fVar2, z.f fVar3) {
            super(0);
            this.uAy = cVar;
            this.$context = context;
            this.UOu = fVar;
            this.UOt = str;
            this.UOr = fVar2;
            this.UOs = fVar3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.pluginsdk.ui.span.m invoke() {
            AppMethodBeat.i(260898);
            com.tencent.mm.pluginsdk.ui.span.m mVar = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.c(this.$context, this.$context.getString(R.string.cxm, ((CharSequence) this.UOu.SYG) + ' ' + this.UOt + ((String) this.UOr.SYG) + ' ' + ((String) this.UOs.SYG))));
            mVar.a(this.uAy.hTM(), this.uAy.diJ(), 0);
            AppMethodBeat.o(260898);
            return mVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpannableString;", "invoke"})
    static final class ab extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.pluginsdk.ui.span.m> {
        final /* synthetic */ Context $context;
        final /* synthetic */ z.f UOr;
        final /* synthetic */ z.f UOs;
        final /* synthetic */ z.f UOu;
        final /* synthetic */ String UOv;
        final /* synthetic */ c uAy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ab(c cVar, Context context, z.f fVar, String str, z.f fVar2, z.f fVar3) {
            super(0);
            this.uAy = cVar;
            this.$context = context;
            this.UOu = fVar;
            this.UOv = str;
            this.UOr = fVar2;
            this.UOs = fVar3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.pluginsdk.ui.span.m invoke() {
            AppMethodBeat.i(260899);
            com.tencent.mm.pluginsdk.ui.span.m mVar = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.c(this.$context, this.$context.getString(R.string.cxm, ((CharSequence) this.UOu.SYG) + ' ' + this.UOv + ((String) this.UOr.SYG) + ' ' + ((String) this.UOs.SYG))));
            mVar.a(this.uAy.hTM(), this.uAy.diJ(), 0);
            AppMethodBeat.o(260899);
            return mVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan;", "invoke"})
    static final class n extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.live.model.m> {
        final /* synthetic */ c uAy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(c cVar) {
            super(0);
            this.uAy = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.live.model.m invoke() {
            AppMethodBeat.i(247752);
            m.a aVar = com.tencent.mm.plugin.finder.live.model.m.ujk;
            String diG = this.uAy.diG();
            kotlin.g.b.p.g(diG, "annoucement");
            Drawable atF = m.a.atF(diG);
            String diG2 = this.uAy.diG();
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
            AppMethodBeat.o(247752);
            return mVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class w extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        public static final w UOn = new w();

        static {
            AppMethodBeat.i(260894);
            AppMethodBeat.o(260894);
        }

        w() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(260893);
            Context context = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
            String string = context.getResources().getString(R.string.jak);
            AppMethodBeat.o(260893);
            return string;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan;", "invoke"})
    static final class v extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.live.model.m> {
        final /* synthetic */ c uAy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v(c cVar) {
            super(0);
            this.uAy = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.live.model.m invoke() {
            AppMethodBeat.i(260892);
            m.a aVar = com.tencent.mm.plugin.finder.live.model.m.ujk;
            String hTN = this.uAy.hTN();
            kotlin.g.b.p.g(hTN, "locationTag");
            Drawable atF = m.a.atF(hTN);
            String hTN2 = this.uAy.hTN();
            kotlin.g.b.p.g(hTN2, "locationTag");
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
            com.tencent.mm.plugin.finder.live.model.m mVar = new com.tencent.mm.plugin.finder.live.model.m(atF, new com.tencent.mm.plugin.finder.live.model.n(hTN2, f2, f3, color, i2, color2, com.tencent.mm.plugin.finder.live.model.n.ujo));
            AppMethodBeat.o(260892);
            return mVar;
        }
    }
}
