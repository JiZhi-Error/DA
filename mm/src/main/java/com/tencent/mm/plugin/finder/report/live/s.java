package com.tencent.mm.plugin.finder.report.live;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.e;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bA\u0018\u00002\u00020\u0001:z\u0002\u0002\u0002\u0002\u0002\u0002\u0002\u0002\u0002\u0002\u0002\u0002\u0002\u0002\u0002\u0002\u0002\u0002\u0002\u0002\u0002\u0002\u0002\u0002\u0002\u0002\u0002\u0002\u0002 \u0002¡\u0002¢\u0002£\u0002¤\u0002¥\u0002¦\u0002§\u0002¨\u0002©\u0002ª\u0002«\u0002¬\u0002­\u0002®\u0002¯\u0002°\u0002±\u0002²\u0002³\u0002´\u0002µ\u0002¶\u0002·\u0002¸\u0002¹\u0002º\u0002»\u0002¼\u0002½\u0002¾\u0002¿\u0002B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010ç\u0001\u001a\u00030è\u00012\b\u0010é\u0001\u001a\u00030ê\u0001J\u0007\u0010ë\u0001\u001a\u00020\u0004J\u0007\u0010ì\u0001\u001a\u00020\u0004J\u001b\u0010í\u0001\u001a\u00020'2\t\u0010î\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010ï\u0001\u001a\u00020'J\u0012\u0010M\u001a\u00030ð\u00012\t\u0010ñ\u0001\u001a\u0004\u0018\u00010\u0004J\u0007\u0010ò\u0001\u001a\u00020\u0004J\u0007\u0010ó\u0001\u001a\u00020\u0004J\u0007\u0010ô\u0001\u001a\u00020\u0004J\u0007\u0010õ\u0001\u001a\u00020\u0004J\u0007\u0010ö\u0001\u001a\u00020\u0004J\u0007\u0010÷\u0001\u001a\u00020\u001eJ\u0012\u0010ø\u0001\u001a\u00020\u001e2\t\u0010ù\u0001\u001a\u0004\u0018\u00010\u0004J\b\u0010ú\u0001\u001a\u00030û\u0001J\u001e\u0010ü\u0001\u001a\u00030û\u00012\t\u0010Á\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010ý\u0001\u001a\u0004\u0018\u00010\u0004J\u001d\u0010å\u0001\u001a\u00030û\u00012\b\u0010þ\u0001\u001a\u00030ÿ\u00012\t\b\u0002\u0010î\u0001\u001a\u00020\u0004J\u0011\u0010\u0002\u001a\u00030û\u00012\u0007\u0010\u0002\u001a\u00020'J\b\u0010\u0002\u001a\u00030û\u0001R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u001a\u0010\u001a\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\nR\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001a\u0010&\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\u001a\u0010/\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010)\"\u0004\b1\u0010+R \u00102\u001a\b\u0012\u0004\u0012\u00020'03X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00108\u001a\n\u0012\u0004\u0012\u00020:\u0018\u000109X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010?\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0011\u0010D\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bE\u0010AR\u001a\u0010F\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010)\"\u0004\bH\u0010+R\u001a\u0010I\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010 \"\u0004\bK\u0010\"R\u001a\u0010L\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010 \"\u0004\bN\u0010\"R\u001a\u0010O\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010 \"\u0004\bQ\u0010\"R\u001a\u0010R\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\b\"\u0004\bT\u0010\nR\u001a\u0010U\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\b\"\u0004\bW\u0010\nRE\u0010X\u001a6\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00060Z0Yj\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00060Z`[¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u001a\u0010^\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010A\"\u0004\b`\u0010CR\u001a\u0010a\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010)\"\u0004\bc\u0010+R\u000e\u0010d\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010f\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010 \"\u0004\bh\u0010\"RE\u0010i\u001a6\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020j\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00060Z0Yj\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020j\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00060Z`[¢\u0006\b\n\u0000\u001a\u0004\bk\u0010]R-\u0010l\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040mj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`n¢\u0006\b\n\u0000\u001a\u0004\bo\u0010pR-\u0010q\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040mj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`n¢\u0006\b\n\u0000\u001a\u0004\br\u0010pR\u001a\u0010s\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010A\"\u0004\bu\u0010CR\u001a\u0010v\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010\b\"\u0004\bx\u0010\nR\u001a\u0010y\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010\b\"\u0004\bz\u0010\nR\u001a\u0010{\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\b\"\u0004\b|\u0010\nR\u001c\u0010}\u001a\u00020~X\u000e¢\u0006\u0010\n\u0000\u001a\u0004\b}\u0010\"\u0006\b\u0001\u0010\u0001R \u0010\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R \u0010\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R \u0010\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R \u0010\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001d\u0010\u0001\u001a\u00020'X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010)\"\u0005\b\u0001\u0010+R\u001d\u0010\u0001\u001a\u00020\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\b\"\u0005\b\u0001\u0010\nR\u001d\u0010 \u0001\u001a\u00020\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¡\u0001\u0010\b\"\u0005\b¢\u0001\u0010\nR\u001d\u0010£\u0001\u001a\u00020\u001eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¤\u0001\u0010 \"\u0005\b¥\u0001\u0010\"R\u001d\u0010¦\u0001\u001a\u00020\u001eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b§\u0001\u0010 \"\u0005\b¨\u0001\u0010\"R\u001d\u0010©\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bª\u0001\u0010A\"\u0005\b«\u0001\u0010CR\"\u0010¬\u0001\u001a\u0005\u0018\u00010­\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R\u001d\u0010²\u0001\u001a\u00020\u001eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b³\u0001\u0010 \"\u0005\b´\u0001\u0010\"R\u001d\u0010µ\u0001\u001a\u00020\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¶\u0001\u0010\b\"\u0005\b·\u0001\u0010\nR\u001d\u0010¸\u0001\u001a\u00020\u001eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¹\u0001\u0010 \"\u0005\bº\u0001\u0010\"R\u001d\u0010»\u0001\u001a\u00020'X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¼\u0001\u0010)\"\u0005\b½\u0001\u0010+R\u001d\u0010¾\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¿\u0001\u0010A\"\u0005\bÀ\u0001\u0010CR\u0013\u0010Á\u0001\u001a\u00020\u00048F¢\u0006\u0007\u001a\u0005\bÂ\u0001\u0010AR\u001d\u0010Ã\u0001\u001a\u00020\u001eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÄ\u0001\u0010 \"\u0005\bÅ\u0001\u0010\"R\u001d\u0010Æ\u0001\u001a\u00020\u001eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÇ\u0001\u0010 \"\u0005\bÈ\u0001\u0010\"R \u0010É\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÊ\u0001\u0010\u0001\"\u0006\bË\u0001\u0010\u0001R\u001d\u0010Ì\u0001\u001a\u00020\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÍ\u0001\u0010\b\"\u0005\bÎ\u0001\u0010\nR\u001d\u0010Ï\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÐ\u0001\u0010A\"\u0005\bÑ\u0001\u0010CR\u001d\u0010Ò\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÓ\u0001\u0010A\"\u0005\bÔ\u0001\u0010CR\u001d\u0010Õ\u0001\u001a\u00020'X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÖ\u0001\u0010)\"\u0005\b×\u0001\u0010+R \u0010Ø\u0001\u001a\u00030Ù\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÚ\u0001\u0010Û\u0001\"\u0006\bÜ\u0001\u0010Ý\u0001R\u001d\u0010Þ\u0001\u001a\u00020'X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bß\u0001\u0010)\"\u0005\bà\u0001\u0010+R \u0010á\u0001\u001a\u00030â\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bã\u0001\u0010ä\u0001\"\u0006\bå\u0001\u0010æ\u0001¨\u0006À\u0002"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig;", "", "()V", "TAG", "", "addProductAction", "", "getAddProductAction", "()Z", "setAddProductAction", "(Z)V", "bookLiveSrc", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$BookLiveSrc;", "getBookLiveSrc", "()Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$BookLiveSrc;", "setBookLiveSrc", "(Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$BookLiveSrc;)V", "cacheExitEvent_21024", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExitType;", "getCacheExitEvent_21024", "()Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExitType;", "setCacheExitEvent_21024", "(Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExitType;)V", "closeLinkMicAudioByVisitor", "getCloseLinkMicAudioByVisitor", "setCloseLinkMicAudioByVisitor", "closeLinkMicVideoByVisitor", "getCloseLinkMicVideoByVisitor", "setCloseLinkMicVideoByVisitor", "commentSceneOnFinderHome", "", "getCommentSceneOnFinderHome", "()I", "setCommentSceneOnFinderHome", "(I)V", "coverType", "getCoverType", "setCoverType", "curLikeNumber", "", "getCurLikeNumber", "()J", "setCurLikeNumber", "(J)V", "curLiveDuration", "getCurLiveDuration", "setCurLiveDuration", "curLiveNumber", "getCurLiveNumber", "setCurLiveNumber", "curProductIds", "Ljava/util/LinkedList;", "getCurProductIds", "()Ljava/util/LinkedList;", "setCurProductIds", "(Ljava/util/LinkedList;)V", "curRecyclerViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/support/v7/widget/RecyclerView;", "getCurRecyclerViewRef", "()Ljava/lang/ref/WeakReference;", "setCurRecyclerViewRef", "(Ljava/lang/ref/WeakReference;)V", "desc", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "description", "getDescription", "enterSessionId", "getEnterSessionId", "setEnterSessionId", "errCode", "getErrCode", "setErrCode", "filterType", "getFilterType", "setFilterType", "filterValue", "getFilterValue", "setFilterValue", "fromWeconHotUI", "getFromWeconHotUI", "setFromWeconHotUI", "gAnchorLinkMicSucdess", "getGAnchorLinkMicSucdess", "setGAnchorLinkMicSucdess", "gAnchorLinkMicTimeList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/vending/tuple/Tuple3;", "Lkotlin/collections/ArrayList;", "getGAnchorLinkMicTimeList", "()Ljava/util/ArrayList;", "gCurCommentscene_temp", "getGCurCommentscene_temp", "setGCurCommentscene_temp", "gCurLiveFeedPos", "getGCurLiveFeedPos", "setGCurLiveFeedPos", "gCurShopAppId", "gCurShopSessionId", "gLinkMicCount", "getGLinkMicCount", "setGLinkMicCount", "gLinkMicTimeList", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$LinkType;", "getGLinkMicTimeList", "gLiveFeedFragmentPageMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getGLiveFeedFragmentPageMap", "()Ljava/util/HashMap;", "gLiveFeedPageMap", "getGLiveFeedPageMap", "gSceneNote", "getGSceneNote", "setGSceneNote", "getContactFromMemberList", "getGetContactFromMemberList", "setGetContactFromMemberList", "isEnterFromFloat", "setEnterFromFloat", "isExitToFloat", "setExitToFloat", "isGift", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$IsGift;", "()Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$IsGift;", "setGift", "(Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$IsGift;)V", "launcherSrc", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$StartLiveSource;", "getLauncherSrc", "()Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$StartLiveSource;", "setLauncherSrc", "(Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$StartLiveSource;)V", "linkMicStateOnPre", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$LinkSwitch;", "getLinkMicStateOnPre", "()Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$LinkSwitch;", "setLinkMicStateOnPre", "(Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$LinkSwitch;)V", "livePageTypeWhenEnter", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$NearbyPageType;", "getLivePageTypeWhenEnter", "()Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$NearbyPageType;", "setLivePageTypeWhenEnter", "(Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$NearbyPageType;)V", "liveStaticsData_21056", "Lcom/tencent/mm/plugin/finder/report/live/LiveStaticsData_21056;", "getLiveStaticsData_21056", "()Lcom/tencent/mm/plugin/finder/report/live/LiveStaticsData_21056;", "setLiveStaticsData_21056", "(Lcom/tencent/mm/plugin/finder/report/live/LiveStaticsData_21056;)V", "mAnchorLotteryCount", "getMAnchorLotteryCount", "setMAnchorLotteryCount", "mClickLotteryHistroy", "getMClickLotteryHistroy", "setMClickLotteryHistroy", "mClickLotteryIcon", "getMClickLotteryIcon", "setMClickLotteryIcon", "morpyEyes", "getMorpyEyes", "setMorpyEyes", "morpyFace", "getMorpyFace", "setMorpyFace", "nearbyCommenScene", "getNearbyCommenScene", "setNearbyCommenScene", "poiJSONObject", "Lorg/json/JSONObject;", "getPoiJSONObject", "()Lorg/json/JSONObject;", "setPoiJSONObject", "(Lorg/json/JSONObject;)V", "positionLiveFeedOnfull", "getPositionLiveFeedOnfull", "setPositionLiveFeedOnfull", "promoting", "getPromoting", "setPromoting", "rosy", "getRosy", "setRosy", "ruleType", "getRuleType", "setRuleType", "sessionBufOnTemp2", "getSessionBufOnTemp2", "setSessionBufOnTemp2", "shopAppId", "getShopAppId", "skinWhitening", "getSkinWhitening", "setSkinWhitening", "smoothFace", "getSmoothFace", "setSmoothFace", "startLiveSource", "getStartLiveSource", "setStartLiveSource", "startLiveVideo", "getStartLiveVideo", "setStartLiveVideo", "subTag", "getSubTag", "setSubTag", "tag", "getTag", "setTag", "timestampOfEnterLiveAnchorUI", "getTimestampOfEnterLiveAnchorUI", "setTimestampOfEnterLiveAnchorUI", "visibleRange", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisibleRangeType;", "getVisibleRange", "()Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisibleRangeType;", "setVisibleRange", "(Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisibleRangeType;)V", "visibleRangeNum", "getVisibleRangeNum", "setVisibleRangeNum", "visitorEnterType", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorEnterType;", "getVisitorEnterType", "()Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorEnterType;", "setVisitorEnterType", "(Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorEnterType;)V", "convert21919Action", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$CloseUISeeGiftList;", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$SEE_GIFT_LIST;", "getAnchorFeedId", "getAnchorLiveId", "getEnterIconType", "commenScene", "defVal", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$FilterType;", "filterPath", "getFinderUserName", "getPoi", "getPromoteGoodsStr", "getSessionPageId", "getdesc", "isPrivate", "isPrivateAccount4Visitor", "userName", "resetSomeData", "", "setShopParams", "shopSessionId", "clickType", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;", "stopPromoteGood", "productId", "stopPromoteGoods", "ActionType", "AllCommentType", "AnchorActionType", "AnchorFloatAction", "AnchorLiveClose", "AnchorLotteryType", "BookLiveSrc", "ClearScreenAction", "CloseUISeeGiftList", "CommentSceneExtend", "ComplaintVisitorSource", "CoverType", "CoverType2", "EnterRoomStatus", "ExitType", "ExploreType", "FilterType", "FloatActionType", "FollowBtnAction", "FollowState", "GIFT_SWITCCH", "GiftSwitch", "IdentityType", "InviteType", "IsGift", "JspiCommenScene", "LinkOp", "LinkSwitch", "LinkType", "LiveAnchorCommerceAction", "LiveBookAction", "LivePersonalAction", "LiveVerified", "Live_Enter_Type", "MicType", "NearbyAction2", "NearbyMoreActionResult", "NearbyPageType", "RedPacketSrc", "RedPacketType", "RuleType", "SCREEN_SWITCH_ACTION", "SEE_GIFT_LIST", "ScreenBtnEvent", "ScreenDirection", "ShopPermitAction", "StartLiveSource", "StartType", "VisibleRangeType", "VisitorAction", "VisitorAuthAction", "VisitorCloseType", "VisitorCommerceAction", "VisitorEnterType", "VisitorGift", "VisitorLinkMicAction", "VisitorLotteryType", "VisitorNoticeAction", "VisitorShareType", "VisitorShopBtnState", "VisitorWinResult", "plugin-finder_release"})
public final class s {
    private final String TAG = "HABBYGE-MALI.LiveReportConfig";
    boolean UTd;
    final ArrayList<com.tencent.mm.vending.j.d<String, Long, Boolean>> UTe = new ArrayList<>();
    String desc;
    int errCode;
    int hDg;
    int hDk;
    String tag = "";
    final ArrayList<com.tencent.mm.vending.j.d<z, Long, Boolean>> vkW = new ArrayList<>();
    long vlA;
    public boolean vlB;
    public boolean vlC;
    int vlD;
    int vlE;
    int vlF;
    int vlG;
    int vlH;
    int vlI;
    public String vlJ = "";
    public boolean vlK;
    y vlL = y.OPEN;
    public boolean vlM;
    v vlN = v.NO;
    long vlO;
    boolean vlP;
    public int vlQ;
    public int vlR;
    public String vlS = "";
    String vlT = "";
    ao vlU = ao.FINDER_PROFILE;
    public String vlV = "";
    aq vlW = aq.PUBLIC;
    long vlX;
    public final HashMap<String, String> vlY = kotlin.a.ae.g(new kotlin.o("com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI", "1"), new kotlin.o("FinderProfileTimeLineUI", "1"), new kotlin.o("com.tencent.mm.plugin.finder.feed.ui.FinderLbsStreamListUI", "16"), new kotlin.o("FinderLbsStreamListUI", "16"), new kotlin.o("com.tencent.mm.plugin.finder.ui.FinderFollowListUI", "12"), new kotlin.o("FinderFollowListUI", "12"), new kotlin.o("com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI", "27"), new kotlin.o("FinderTopicTimelineUI", "27"), new kotlin.o("com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI", "25"), new kotlin.o("FinderShareFeedRelUI", "25"), new kotlin.o("com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI", "2"), new kotlin.o("FinderLikedFeedUI", "2"), new kotlin.o("com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI", "21"), new kotlin.o("FinderFavTimelineUI", "21"), new kotlin.o("com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelatedTimelineUI", "40"), new kotlin.o("FinderFeedRelatedTimelineUI", "40"), new kotlin.o("com.tencent.mm.plugin.finder.search.FinderMixSearchUI", "23"), new kotlin.o("FinderMixSearchUI", "23"), new kotlin.o("com.tencent.mm.plugin.finder.search.FinderContactSearchUI", j.COMMENT_SCENE_SEARCH_MORE_CONTACT.scene), new kotlin.o("FinderContactSearchUI", j.COMMENT_SCENE_SEARCH_MORE_CONTACT.scene), new kotlin.o("com.tencent.mm.plugin.finder.search.FinderFeedSearchUI", "6"), new kotlin.o("FinderFeedSearchUI", "6"));
    public final HashMap<String, String> vlZ = kotlin.a.ae.g(new kotlin.o("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment", "17"), new kotlin.o("FinderFollowTabFragment", "17"), new kotlin.o("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment", "18"), new kotlin.o("FinderFriendTabFragment", "18"), new kotlin.o("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment", "20"), new kotlin.o("FinderMachineTabFragment", "20"));
    public String vlv = "";
    public long vlw;
    public boolean vlx;
    public String vly = "";
    public String vlz = "";
    public av vma = av.CLICK_LIVE_CARD;
    o vmb = o.LIVE_EXIT_NOTHING;
    long vmc;
    long vmd = 1;
    JSONObject vme;
    int vmf = m.LIVE_COVER_DEFAULT.type;
    public long vmg;
    public long vmh;
    public long vmi;
    public u vmj = new u();
    public boolean vmk;
    public boolean vml;
    public boolean vmm;
    public boolean vmn;
    public boolean vmo;
    public LinkedList<Long> vmp = new LinkedList<>();
    public WeakReference<RecyclerView> vmq;
    ah vmr = ah.START_LIVE_BY_FINDER_IDENTITY;
    ao vms = ao.FINDER_PROFILE;
    public g vmt = g.PROFILE;

    public s() {
        AppMethodBeat.i(251205);
        AppMethodBeat.o(251205);
    }

    public final void auQ(String str) {
        AppMethodBeat.i(251182);
        kotlin.g.b.p.h(str, "<set-?>");
        this.vlv = str;
        AppMethodBeat.o(251182);
    }

    public final void auR(String str) {
        AppMethodBeat.i(251183);
        kotlin.g.b.p.h(str, "<set-?>");
        this.vlJ = str;
        AppMethodBeat.o(251183);
    }

    public final void a(y yVar) {
        AppMethodBeat.i(251184);
        kotlin.g.b.p.h(yVar, "<set-?>");
        this.vlL = yVar;
        AppMethodBeat.o(251184);
    }

    public final void a(v vVar) {
        AppMethodBeat.i(251185);
        kotlin.g.b.p.h(vVar, "<set-?>");
        this.vlN = vVar;
        AppMethodBeat.o(251185);
    }

    public final void setTag(String str) {
        AppMethodBeat.i(251186);
        kotlin.g.b.p.h(str, "<set-?>");
        this.tag = str;
        AppMethodBeat.o(251186);
    }

    public final void auS(String str) {
        AppMethodBeat.i(251187);
        kotlin.g.b.p.h(str, "<set-?>");
        this.vlT = str;
        AppMethodBeat.o(251187);
    }

    public final void a(ao aoVar) {
        AppMethodBeat.i(251188);
        kotlin.g.b.p.h(aoVar, "<set-?>");
        this.vlU = aoVar;
        AppMethodBeat.o(251188);
    }

    public final void a(aq aqVar) {
        AppMethodBeat.i(251189);
        kotlin.g.b.p.h(aqVar, "<set-?>");
        this.vlW = aqVar;
        AppMethodBeat.o(251189);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;", "", "type", "", "(Ljava/lang/String;IJ)V", "getType", "()J", "LIVE_AUDIENCE_EXPLORE_SINGLE_AVATAR", "LIVE_AUDIENCE_EXPLORE_FEED_CARD", "LIVE_AUDIENCE_EXPLORE_FEED_CARD_LIVING_AVATAR", "LIVE_AUDIENCE_CLICK_SINGLE_AVATAR", "LIVE_AUDIENCE_CLICK_FEED_CARD_AVATAR_LIVING", "LIVE_AUDIENCE_CLICK_FEED_CARD_AVATAR", "LIVE_AUDIENCE_ENTER_LIVE_ROOM", "LIVE_AUDIENCE_ENTER_LIVE_ROOM_REAL", "LIVE_AUDIENCE_CLICK_AVATAR_LIVING", "LIVE_AUDIENCE_CLICK_LIVE_FEED_AVATAR_LIVING", "LIVE_AUDIENCE_CLICK_FEED_AVATAR_LIVING", "plugin-finder_release"})
    public enum p {
        LIVE_AUDIENCE_EXPLORE_SINGLE_AVATAR(1),
        LIVE_AUDIENCE_EXPLORE_FEED_CARD(2),
        LIVE_AUDIENCE_EXPLORE_FEED_CARD_LIVING_AVATAR(3),
        LIVE_AUDIENCE_CLICK_SINGLE_AVATAR(4),
        LIVE_AUDIENCE_CLICK_FEED_CARD_AVATAR_LIVING(5),
        LIVE_AUDIENCE_CLICK_FEED_CARD_AVATAR(6),
        LIVE_AUDIENCE_ENTER_LIVE_ROOM(7),
        LIVE_AUDIENCE_ENTER_LIVE_ROOM_REAL(8),
        LIVE_AUDIENCE_CLICK_AVATAR_LIVING(9),
        LIVE_AUDIENCE_CLICK_LIVE_FEED_AVATAR_LIVING(10),
        LIVE_AUDIENCE_CLICK_FEED_AVATAR_LIVING(11);
        
        public final long dDw;

        public static p valueOf(String str) {
            AppMethodBeat.i(251063);
            p pVar = (p) Enum.valueOf(p.class, str);
            AppMethodBeat.o(251063);
            return pVar;
        }

        private p(long j2) {
            this.dDw = j2;
        }

        static {
            AppMethodBeat.i(251061);
            AppMethodBeat.o(251061);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorEnterType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "CLICK_LIVE_DEFAULT", "CLICK_LIVE_CARD", "CLICK_LIVE_CARD_AVATAR_LIVING", "CLICK_CARD_AVATAR_LIVING", "CLICK_AVATAR_LIVING", "CLICK_SNSAD_ENTER_LIVE_ROOM", "plugin-finder_release"})
    public enum av {
        CLICK_LIVE_DEFAULT(0),
        CLICK_LIVE_CARD(1),
        CLICK_LIVE_CARD_AVATAR_LIVING(2),
        CLICK_CARD_AVATAR_LIVING(3),
        CLICK_AVATAR_LIVING(4),
        CLICK_SNSAD_ENTER_LIVE_ROOM(5);
        
        public final int type;

        public static av valueOf(String str) {
            AppMethodBeat.i(251159);
            av avVar = (av) Enum.valueOf(av.class, str);
            AppMethodBeat.o(251159);
            return avVar;
        }

        private av(int i2) {
            this.type = i2;
        }

        static {
            AppMethodBeat.i(251157);
            AppMethodBeat.o(251157);
        }
    }

    public final void a(p pVar, String str) {
        AppMethodBeat.i(251190);
        kotlin.g.b.p.h(pVar, "clickType");
        kotlin.g.b.p.h(str, "commenScene");
        switch (t.$EnumSwitchMapping$0[pVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
                if (kotlin.g.b.p.j(str, "37") || kotlin.g.b.p.j(str, String.valueOf(j.COMMENT_SCENE_APPBRAN))) {
                    this.vma = av.CLICK_SNSAD_ENTER_LIVE_ROOM;
                    AppMethodBeat.o(251190);
                    return;
                }
                this.vma = av.CLICK_LIVE_CARD;
                AppMethodBeat.o(251190);
                return;
            case 4:
                this.vma = av.CLICK_AVATAR_LIVING;
                AppMethodBeat.o(251190);
                return;
            case 5:
                this.vma = av.CLICK_LIVE_CARD_AVATAR_LIVING;
                AppMethodBeat.o(251190);
                return;
            case 6:
                this.vma = av.CLICK_CARD_AVATAR_LIVING;
                AppMethodBeat.o(251190);
                return;
            default:
                this.vma = av.CLICK_LIVE_DEFAULT;
                AppMethodBeat.o(251190);
                return;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$CommentSceneExtend;", "", "scene", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getScene", "()Ljava/lang/String;", "COMMENT_SCENE_FOLLOW_TAB_AVATAR_FLOW", "COMMENT_SCENE_LIVE_ROOM_SLIDE", "COMMENT_SCENE_SEARCH_MORE_CONTACT", "COMMENT_SCENE_SEARCH_RESULT_FLOW", "COMMENT_SCENE_PROFILE_PAGE", "COMMENT_SCENE_SHARE_PAGE", "COMMENT_SCENE_BOOK_NOTIFY", "COMMENT_SCENE_FRIEND_TAB_AVATAR_FLOW", "COMMENT_SCENE_LBS_TOP_LIVE_CARD", "COMMENT_SCENE_SEARCH_1_SEARCH", "COMMENT_SCENE_PUBLIC_NUMBER", "COMMENT_SCENE_APPBRAN", "COMMENT_SCENE_SEE_1_SEE", "COMMENT_SCENE_PULLDOWN_MENU", "COMMENT_SCENE_SLEF_STATUS", "COMMENT_SCENE_RED_PACKET_MSG_IN_GOUR_CHAT", "plugin-finder_release"})
    public enum j {
        COMMENT_SCENE_FOLLOW_TAB_AVATAR_FLOW("temp_1"),
        COMMENT_SCENE_LIVE_ROOM_SLIDE("temp_2"),
        COMMENT_SCENE_SEARCH_MORE_CONTACT("temp_3"),
        COMMENT_SCENE_SEARCH_RESULT_FLOW("temp_4"),
        COMMENT_SCENE_PROFILE_PAGE("temp_5"),
        COMMENT_SCENE_SHARE_PAGE("temp_6"),
        COMMENT_SCENE_BOOK_NOTIFY("temp_7"),
        COMMENT_SCENE_FRIEND_TAB_AVATAR_FLOW("temp_9"),
        COMMENT_SCENE_LBS_TOP_LIVE_CARD("temp_10"),
        COMMENT_SCENE_SEARCH_1_SEARCH("temp_11"),
        COMMENT_SCENE_PUBLIC_NUMBER("temp_12"),
        COMMENT_SCENE_APPBRAN("temp_13"),
        COMMENT_SCENE_SEE_1_SEE("temp_14"),
        COMMENT_SCENE_PULLDOWN_MENU("temp_15"),
        COMMENT_SCENE_SLEF_STATUS("temp_16"),
        COMMENT_SCENE_RED_PACKET_MSG_IN_GOUR_CHAT("temp_17");
        
        public final String scene;

        public static j valueOf(String str) {
            AppMethodBeat.i(251045);
            j jVar = (j) Enum.valueOf(j.class, str);
            AppMethodBeat.o(251045);
            return jVar;
        }

        private j(String str) {
            this.scene = str;
        }

        static {
            AppMethodBeat.i(251043);
            AppMethodBeat.o(251043);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$JspiCommenScene;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "PUBLIC_NUMBER", "SEARCH_1_SEARCH", "SEE_1_SEE", "GAME_CENTER", "LITTLE_APP", "plugin-finder_release"})
    public enum w {
        PUBLIC_NUMBER("5"),
        SEARCH_1_SEARCH("6"),
        SEE_1_SEE("7"),
        GAME_CENTER("9"),
        LITTLE_APP("15");
        
        final String type;

        public static w valueOf(String str) {
            AppMethodBeat.i(251084);
            w wVar = (w) Enum.valueOf(w.class, str);
            AppMethodBeat.o(251084);
            return wVar;
        }

        private w(String str) {
            this.type = str;
        }

        static {
            AppMethodBeat.i(251082);
            AppMethodBeat.o(251082);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$FollowState;", "", "state", "", "(Ljava/lang/String;II)V", "getState", "()I", "UNFOLLOW", "FOLLOWED", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.report.live.s$s  reason: collision with other inner class name */
    public enum EnumC1269s {
        UNFOLLOW(0),
        FOLLOWED(1);
        
        final int state;

        public static EnumC1269s valueOf(String str) {
            AppMethodBeat.i(251072);
            EnumC1269s sVar = (EnumC1269s) Enum.valueOf(EnumC1269s.class, str);
            AppMethodBeat.o(251072);
            return sVar;
        }

        private EnumC1269s(int i2) {
            this.state = i2;
        }

        static {
            AppMethodBeat.i(251070);
            AppMethodBeat.o(251070);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$LinkType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "INVALIDATE", "AUDIO", ShareConstants.VIDEO_URL, "plugin-finder_release"})
    public enum z {
        INVALIDATE(0),
        AUDIO(1),
        vpH(2);
        
        final int type;

        public static z valueOf(String str) {
            AppMethodBeat.i(251093);
            z zVar = (z) Enum.valueOf(z.class, str);
            AppMethodBeat.o(251093);
            return zVar;
        }

        private z(int i2) {
            this.type = i2;
        }

        static {
            AppMethodBeat.i(251091);
            AppMethodBeat.o(251091);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$EnterRoomStatus;", "", "status", "", "(Ljava/lang/String;IJ)V", "getStatus", "()J", "LIVE_LIVING", "LIVE_STOPPED", "LIVE_IN_BLACK_LIST", "LIVE_NO_ACCESS_PERMISSION", "plugin-finder_release"})
    public enum n {
        LIVE_LIVING(1),
        LIVE_STOPPED(2),
        LIVE_IN_BLACK_LIST(5),
        LIVE_NO_ACCESS_PERMISSION(6);
        
        public final long jii;

        public static n valueOf(String str) {
            AppMethodBeat.i(251057);
            n nVar = (n) Enum.valueOf(n.class, str);
            AppMethodBeat.o(251057);
            return nVar;
        }

        private n(long j2) {
            this.jii = j2;
        }

        static {
            AppMethodBeat.i(251055);
            AppMethodBeat.o(251055);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ActionType;", "", NativeProtocol.WEB_DIALOG_ACTION, "", "(Ljava/lang/String;IJ)V", "getAction", "()J", "PROFILE_LIVE_BTN_EXPOSE", "PROFILE_LIVE_BTN_CLICK", "LIVE_ENTER_UI", "LIVE_BTN_CLICK", "LIVE_EXCHANGE_CAMERA", "LIVE_COMMERCE", "LIVE_EDIT_COVER", "LIVE_DESCRIPTION", "LIVE_POI", "LIVE_RULE", "LIVE_TIMER", "LIVE_SUCCESS", "LIVE_OUT", "LIVE_CLICK_BTN_MENU", "LINKMIC_SWITCH", "GIFT_SWITCCH", "plugin-finder_release"})
    public enum a {
        PROFILE_LIVE_BTN_EXPOSE(1),
        PROFILE_LIVE_BTN_CLICK(2),
        LIVE_ENTER_UI(3),
        LIVE_BTN_CLICK(4),
        LIVE_EXCHANGE_CAMERA(5),
        LIVE_COMMERCE(6),
        LIVE_EDIT_COVER(7),
        LIVE_DESCRIPTION(8),
        LIVE_POI(9),
        LIVE_RULE(10),
        LIVE_TIMER(11),
        LIVE_SUCCESS(12),
        LIVE_OUT(13),
        LIVE_CLICK_BTN_MENU(14),
        LINKMIC_SWITCH(15),
        GIFT_SWITCCH(16);
        
        public final long hlf;

        public static a valueOf(String str) {
            AppMethodBeat.i(251018);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(251018);
            return aVar;
        }

        private a(long j2) {
            this.hlf = j2;
        }

        static {
            AppMethodBeat.i(251016);
            AppMethodBeat.o(251016);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$GIFT_SWITCCH;", "", NativeProtocol.WEB_DIALOG_ACTION, "", "(Ljava/lang/String;II)V", "getAction", "()I", "CLOSE_SEND_GIFT_BY_MORE", "OPEN_SEND_GIFT_BY_MORE", "plugin-finder_release"})
    public enum t {
        CLOSE_SEND_GIFT_BY_MORE(1),
        OPEN_SEND_GIFT_BY_MORE(2);
        
        public final int action;

        public static t valueOf(String str) {
            AppMethodBeat.i(251075);
            t tVar = (t) Enum.valueOf(t.class, str);
            AppMethodBeat.o(251075);
            return tVar;
        }

        private t(int i2) {
            this.action = i2;
        }

        static {
            AppMethodBeat.i(251073);
            AppMethodBeat.o(251073);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$Live_Enter_Type;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "ORDINARY_LAUNCH_UI", "INNER_NOTICE_TIME_LAUNCH_UI", "RETURN_LIVE_ROOM", "plugin-finder_release"})
    public enum ae {
        ORDINARY_LAUNCH_UI(1),
        INNER_NOTICE_TIME_LAUNCH_UI(2),
        RETURN_LIVE_ROOM(3);
        
        final int type;

        public static ae valueOf(String str) {
            AppMethodBeat.i(251108);
            ae aeVar = (ae) Enum.valueOf(ae.class, str);
            AppMethodBeat.o(251108);
            return aeVar;
        }

        private ae(int i2) {
            this.type = i2;
        }

        static {
            AppMethodBeat.i(251106);
            AppMethodBeat.o(251106);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$RuleType;", "", NativeProtocol.WEB_DIALOG_ACTION, "", "(Ljava/lang/String;II)V", "getAction", "()I", "LIVE_RULE_ALREADY_OK", "LIVE_RULE_SHOW", "LIVE_RULE_CHECK_YES", "LIVE_RULE_CHECK_NO", "plugin-finder_release"})
    public enum ai {
        LIVE_RULE_ALREADY_OK(1),
        LIVE_RULE_SHOW(2),
        LIVE_RULE_CHECK_YES(3),
        LIVE_RULE_CHECK_NO(4);
        
        public final int action;

        public static ai valueOf(String str) {
            AppMethodBeat.i(251120);
            ai aiVar = (ai) Enum.valueOf(ai.class, str);
            AppMethodBeat.o(251120);
            return aiVar;
        }

        private ai(int i2) {
            this.action = i2;
        }

        static {
            AppMethodBeat.i(251118);
            AppMethodBeat.o(251118);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$CoverType;", "", NativeProtocol.WEB_DIALOG_ACTION, "", "(Ljava/lang/String;II)V", "getAction", "()I", "LIVE_COVER_ALBUM_CANCEL", "LIVE_COVER_SHOOT_FRONT_TAKEN", "LIVE_COVER_SHOOT_BACK_TAKEN", "LIVE_COVER_ALBUM_TAKEN", "plugin-finder_release"})
    public enum l {
        LIVE_COVER_ALBUM_CANCEL(5),
        LIVE_COVER_SHOOT_FRONT_TAKEN(6),
        LIVE_COVER_SHOOT_BACK_TAKEN(7),
        LIVE_COVER_ALBUM_TAKEN(8);
        
        public final int action;

        public static l valueOf(String str) {
            AppMethodBeat.i(251051);
            l lVar = (l) Enum.valueOf(l.class, str);
            AppMethodBeat.o(251051);
            return lVar;
        }

        private l(int i2) {
            this.action = i2;
        }

        static {
            AppMethodBeat.i(251049);
            AppMethodBeat.o(251049);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$CoverType2;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "LIVE_COVER_DEFAULT", "LIVE_COVER_FRONT_CAMERA", "LIVE_COVER_ALBUM", "plugin-finder_release"})
    public enum m {
        LIVE_COVER_DEFAULT(0),
        LIVE_COVER_FRONT_CAMERA(6),
        LIVE_COVER_ALBUM(8);
        
        public final int type;

        public static m valueOf(String str) {
            AppMethodBeat.i(251054);
            m mVar = (m) Enum.valueOf(m.class, str);
            AppMethodBeat.o(251054);
            return mVar;
        }

        private m(int i2) {
            this.type = i2;
        }

        static {
            AppMethodBeat.i(251052);
            AppMethodBeat.o(251052);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$StartType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "LIVE_START_NETWORK_ERROR", "LIVE_START_OK", "plugin-finder_release"})
    public enum ap {
        LIVE_START_NETWORK_ERROR(1),
        LIVE_START_OK(2);
        
        public final int type;

        public static ap valueOf(String str) {
            AppMethodBeat.i(251141);
            ap apVar = (ap) Enum.valueOf(ap.class, str);
            AppMethodBeat.o(251141);
            return apVar;
        }

        private ap(int i2) {
            this.type = i2;
        }

        static {
            AppMethodBeat.i(251139);
            AppMethodBeat.o(251139);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExitType;", "", "type", "", "(Ljava/lang/String;IJ)V", "getType", "()J", "LIVE_EXIT_OK", "LIVE_EXIT_ERROR", "LIVE_EXIT_CANCEL_TIMER", "LIVE_EXIT_NOTHING", "plugin-finder_release"})
    public enum o {
        LIVE_EXIT_OK(1),
        LIVE_EXIT_ERROR(2),
        LIVE_EXIT_CANCEL_TIMER(3),
        LIVE_EXIT_NOTHING(4);
        
        final long dDw;

        public static o valueOf(String str) {
            AppMethodBeat.i(251060);
            o oVar = (o) Enum.valueOf(o.class, str);
            AppMethodBeat.o(251060);
            return oVar;
        }

        private o(long j2) {
            this.dDw = j2;
        }

        static {
            AppMethodBeat.i(251058);
            AppMethodBeat.o(251058);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$AnchorActionType;", "", NativeProtocol.WEB_DIALOG_ACTION, "", "(Ljava/lang/String;II)V", "getAction", "()I", "LIVE_ANCHOR_ACTION_BEGIN", "LIVE_ANCHOR_ACTION_EXCHANGE_CAMERA", "LIVE_ANCHOR_ACTION_MINIMIZE", "LIVE_ANCHOR_ACTION_COMMENT", "LIVE_ANCHOR_ACTION_BARRAGE", "LIVE_ANCHOR_ACTION_SHARE", "LIVE_ANCHOR_ACTION_AUDIENCE", "LIVE_ANCHOR_ACTION_COMMERCE", "LIVE_ANCHOR_ACTION_OUT", "LIVE_ANCHOR_TOP_COMMENT", "LIVE_ANCHOR_TICKLE", "LIVE_ANCHOR_LOTTERY", "CLICK_FAIRY_STICK", "BEAUTY", "FILTER", "CLICK_MIRROR", "LINKMIC_SWITCH", "LINKMIC_OP", "GIFT_SWITCH", "SEE_GIFT_LIST", "CLICK_LINKMIC_ANCHOR_PROFILE", "plugin-finder_release"})
    public enum c {
        LIVE_ANCHOR_ACTION_BEGIN(1),
        LIVE_ANCHOR_ACTION_EXCHANGE_CAMERA(2),
        LIVE_ANCHOR_ACTION_MINIMIZE(3),
        LIVE_ANCHOR_ACTION_COMMENT(4),
        LIVE_ANCHOR_ACTION_BARRAGE(5),
        LIVE_ANCHOR_ACTION_SHARE(6),
        LIVE_ANCHOR_ACTION_AUDIENCE(7),
        LIVE_ANCHOR_ACTION_COMMERCE(8),
        LIVE_ANCHOR_ACTION_OUT(9),
        LIVE_ANCHOR_TOP_COMMENT(10),
        LIVE_ANCHOR_TICKLE(11),
        LIVE_ANCHOR_LOTTERY(12),
        CLICK_FAIRY_STICK(13),
        BEAUTY(14),
        FILTER(15),
        CLICK_MIRROR(16),
        LINKMIC_SWITCH(17),
        LINKMIC_OP(18),
        GIFT_SWITCH(19),
        SEE_GIFT_LIST(20),
        CLICK_LINKMIC_ANCHOR_PROFILE(21);
        
        final int action;

        public static c valueOf(String str) {
            AppMethodBeat.i(251024);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(251024);
            return cVar;
        }

        private c(int i2) {
            this.action = i2;
        }

        static {
            AppMethodBeat.i(251022);
            AppMethodBeat.o(251022);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$GiftSwitch;", "", NativeProtocol.WEB_DIALOG_ACTION, "", "(Ljava/lang/String;II)V", "getAction", "()I", "BY_MORE_CLOSE_GIFT", "BY_MORE_OPEN_GIFT", "plugin-finder_release"})
    public enum u {
        BY_MORE_CLOSE_GIFT(1),
        BY_MORE_OPEN_GIFT(2);
        
        public final int action;

        public static u valueOf(String str) {
            AppMethodBeat.i(251078);
            u uVar = (u) Enum.valueOf(u.class, str);
            AppMethodBeat.o(251078);
            return uVar;
        }

        private u(int i2) {
            this.action = i2;
        }

        static {
            AppMethodBeat.i(251076);
            AppMethodBeat.o(251076);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$SEE_GIFT_LIST;", "", NativeProtocol.WEB_DIALOG_ACTION, "", "(Ljava/lang/String;II)V", "getAction", "()I", "CLICK_BEANSPROUTS_PULLUP_LIST_HALF_PAGE", "CLICK_HELF_PAGE_INSTRUCTION", "RETURN_LIVE_ROOM", "CLICK_LIST_ITEM_USER", "EXPOSE_USER_FINDER_HALF_BOARD", "CLICK_PRIVATE_MSG_USER", "CLICK_FOLLOW_USER", "CLICK_COMPLAIN_USER", "CLICK_FORBITTEN_USER", "CLICK_BLACK_USER", "CLICK_ENTER_USER_PROFILE", "plugin-finder_release"})
    public enum ak {
        CLICK_BEANSPROUTS_PULLUP_LIST_HALF_PAGE(1),
        CLICK_HELF_PAGE_INSTRUCTION(2),
        RETURN_LIVE_ROOM(3),
        CLICK_LIST_ITEM_USER(4),
        EXPOSE_USER_FINDER_HALF_BOARD(5),
        CLICK_PRIVATE_MSG_USER(6),
        CLICK_FOLLOW_USER(7),
        CLICK_COMPLAIN_USER(8),
        CLICK_FORBITTEN_USER(9),
        CLICK_BLACK_USER(10),
        CLICK_ENTER_USER_PROFILE(11);
        
        public final int action;

        public static ak valueOf(String str) {
            AppMethodBeat.i(251126);
            ak akVar = (ak) Enum.valueOf(ak.class, str);
            AppMethodBeat.o(251126);
            return akVar;
        }

        private ak(int i2) {
            this.action = i2;
        }

        static {
            AppMethodBeat.i(251124);
            AppMethodBeat.o(251124);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$LinkSwitch;", "", NativeProtocol.WEB_DIALOG_ACTION, "", "(Ljava/lang/String;II)V", "getAction", "()I", "OPEN", "CLOSE", "plugin-finder_release"})
    public enum y {
        OPEN(1),
        CLOSE(2);
        
        public final int action;

        public static y valueOf(String str) {
            AppMethodBeat.i(251090);
            y yVar = (y) Enum.valueOf(y.class, str);
            AppMethodBeat.o(251090);
            return yVar;
        }

        private y(int i2) {
            this.action = i2;
        }

        static {
            AppMethodBeat.i(251088);
            AppMethodBeat.o(251088);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$LinkOp;", "", NativeProtocol.WEB_DIALOG_ACTION, "", "(Ljava/lang/String;II)V", "getAction", "()I", "CLICK_LINKMIC_LOGO", "CONNECT_VOICE_TO_LINKMIC", "CONNECT_VIDEO_TO_LINKMIC", "DISCONNECT_VOICE_TO_LINKMIC", "DISCONNECT_VIDEO_TO_LINKMIC", "LINKMIC_ICON_READDOT_EXPOSE", "ENTER_VISITOR_LINKMIC_TAB", "ENTER_ANCHOR_LINKMIC_TAB", "ENTER_INVITE_ANCHOR_LINKMIC_TAB", "INVITE_ANCHOR_LINKMIC", "LINKMIC_CONNECT_SUCCESS", "STOP_LINKMIC_WHEN_WAITING_CONNECT", "STOP_LINKMIC_WHEN_SHOW_CONNECTING", "LINKMIC_FAILURE_WHEN_EXCEPTION_TOAST_SHOW", "plugin-finder_release"})
    public enum x {
        CLICK_LINKMIC_LOGO(1),
        CONNECT_VOICE_TO_LINKMIC(2),
        CONNECT_VIDEO_TO_LINKMIC(3),
        DISCONNECT_VOICE_TO_LINKMIC(4),
        DISCONNECT_VIDEO_TO_LINKMIC(5),
        LINKMIC_ICON_READDOT_EXPOSE(6),
        ENTER_VISITOR_LINKMIC_TAB(7),
        ENTER_ANCHOR_LINKMIC_TAB(8),
        ENTER_INVITE_ANCHOR_LINKMIC_TAB(9),
        INVITE_ANCHOR_LINKMIC(10),
        LINKMIC_CONNECT_SUCCESS(11),
        STOP_LINKMIC_WHEN_WAITING_CONNECT(12),
        STOP_LINKMIC_WHEN_SHOW_CONNECTING(13),
        LINKMIC_FAILURE_WHEN_EXCEPTION_TOAST_SHOW(14);
        
        final int action;

        public static x valueOf(String str) {
            AppMethodBeat.i(251087);
            x xVar = (x) Enum.valueOf(x.class, str);
            AppMethodBeat.o(251087);
            return xVar;
        }

        private x(int i2) {
            this.action = i2;
        }

        static {
            AppMethodBeat.i(251085);
            AppMethodBeat.o(251085);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$AnchorLotteryType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "setType", "(I)V", "CLICK_LOTTERY_ICON", "CLICK_JOIN_CONDITION", "CLICK_ANY_COMMENT", "CLICK_SPECIFY_COMMENT_CONTENT", "CLICK_LIKE", "WRITE_SPECIFY_COMMENT_CONTENT_SUCC", "START_LOTTERY_SUCCESS", "CLICK_ENTER_LOTTERY_RECORD_BY_RIGHT", "CLICK_LOTTERY_RECORD_LIST_ENTER_WINNER_LIST_UI", "CLICK_WINNER_AVATAR_ENTER_PRIVATE_MSG_UI", "CLICK_LUCKY_BAG", "CANCEL_LOTTERY", "plugin-finder_release"})
    public enum f {
        CLICK_LOTTERY_ICON(1),
        CLICK_JOIN_CONDITION(2),
        CLICK_ANY_COMMENT(3),
        CLICK_SPECIFY_COMMENT_CONTENT(4),
        CLICK_LIKE(5),
        WRITE_SPECIFY_COMMENT_CONTENT_SUCC(6),
        START_LOTTERY_SUCCESS(7),
        CLICK_ENTER_LOTTERY_RECORD_BY_RIGHT(8),
        CLICK_LOTTERY_RECORD_LIST_ENTER_WINNER_LIST_UI(9),
        CLICK_WINNER_AVATAR_ENTER_PRIVATE_MSG_UI(10),
        CLICK_LUCKY_BAG(11),
        CANCEL_LOTTERY(12);
        
        int type;

        public static f valueOf(String str) {
            AppMethodBeat.i(251033);
            f fVar = (f) Enum.valueOf(f.class, str);
            AppMethodBeat.o(251033);
            return fVar;
        }

        private f(int i2) {
            this.type = i2;
        }

        static {
            AppMethodBeat.i(251031);
            AppMethodBeat.o(251031);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$FilterType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "ORIGINAL_FILM", "NATURAL", "WHITE", "NOSTALGIA", "AUTUMN", "DELICIOUS", "BLUE", "FILM", "HONGKKONG_STYLE", "plugin-finder_release"})
    public enum q {
        ORIGINAL_FILM(1),
        NATURAL(2),
        WHITE(3),
        NOSTALGIA(4),
        AUTUMN(5),
        DELICIOUS(6),
        BLUE(7),
        FILM(8),
        HONGKKONG_STYLE(9);
        
        final int type;

        public static q valueOf(String str) {
            AppMethodBeat.i(251066);
            q qVar = (q) Enum.valueOf(q.class, str);
            AppMethodBeat.o(251066);
            return qVar;
        }

        private q(int i2) {
            this.type = i2;
        }

        static {
            AppMethodBeat.i(251064);
            AppMethodBeat.o(251064);
        }
    }

    public static q auT(String str) {
        AppMethodBeat.i(251191);
        com.tencent.mm.live.core.d.a aVar = com.tencent.mm.live.core.d.a.hEN;
        int GD = com.tencent.mm.live.core.d.a.GD(str);
        e.C0383e eVar = e.C0383e.hxP;
        if (GD == e.C0383e.aCF()) {
            q qVar = q.NATURAL;
            AppMethodBeat.o(251191);
            return qVar;
        }
        e.C0383e eVar2 = e.C0383e.hxP;
        if (GD == e.C0383e.aCG()) {
            q qVar2 = q.WHITE;
            AppMethodBeat.o(251191);
            return qVar2;
        }
        e.C0383e eVar3 = e.C0383e.hxP;
        if (GD == e.C0383e.aCM()) {
            q qVar3 = q.NOSTALGIA;
            AppMethodBeat.o(251191);
            return qVar3;
        }
        e.C0383e eVar4 = e.C0383e.hxP;
        if (GD == e.C0383e.aCH()) {
            q qVar4 = q.AUTUMN;
            AppMethodBeat.o(251191);
            return qVar4;
        }
        e.C0383e eVar5 = e.C0383e.hxP;
        if (GD == e.C0383e.aCI()) {
            q qVar5 = q.DELICIOUS;
            AppMethodBeat.o(251191);
            return qVar5;
        }
        e.C0383e eVar6 = e.C0383e.hxP;
        if (GD == e.C0383e.aCK()) {
            q qVar6 = q.FILM;
            AppMethodBeat.o(251191);
            return qVar6;
        }
        e.C0383e eVar7 = e.C0383e.hxP;
        if (GD == e.C0383e.aCL()) {
            q qVar7 = q.HONGKKONG_STYLE;
            AppMethodBeat.o(251191);
            return qVar7;
        }
        e.C0383e eVar8 = e.C0383e.hxP;
        if (GD == e.C0383e.aCJ()) {
            q qVar8 = q.BLUE;
            AppMethodBeat.o(251191);
            return qVar8;
        }
        q qVar9 = q.ORIGINAL_FILM;
        AppMethodBeat.o(251191);
        return qVar9;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$FloatActionType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "LIVE_FLOAT_ACTION_UNKNOWN", "LIVE_FLOAT_ACTION_MAXIMIZE", "LIVE_FLOAT_ACTION_COLLAPSE_ANIMATION", "LIVE_FLOAT_ACTION_MINIMIZE_INTERACTIVE", "LIVE_FLOAT_ACTION_MINIMIZE_FOR_WEAPP", "LIVE_FLOAT_ACTION_MINIMIZE_FOR_BG", "LIVE_FLOAT_ACTION_ENTER_PROFILE", "VISITOR_CLICK_ENTER_LOTTERY_RECORD", "plugin-finder_release"})
    public enum r {
        LIVE_FLOAT_ACTION_UNKNOWN(0),
        LIVE_FLOAT_ACTION_MAXIMIZE(1),
        LIVE_FLOAT_ACTION_COLLAPSE_ANIMATION(2),
        LIVE_FLOAT_ACTION_MINIMIZE_INTERACTIVE(3),
        LIVE_FLOAT_ACTION_MINIMIZE_FOR_WEAPP(4),
        LIVE_FLOAT_ACTION_MINIMIZE_FOR_BG(5),
        LIVE_FLOAT_ACTION_ENTER_PROFILE(6),
        VISITOR_CLICK_ENTER_LOTTERY_RECORD(7);
        
        public final int type;

        public static r valueOf(String str) {
            AppMethodBeat.i(251069);
            r rVar = (r) Enum.valueOf(r.class, str);
            AppMethodBeat.o(251069);
            return rVar;
        }

        private r(int i2) {
            this.type = i2;
        }

        static {
            AppMethodBeat.i(251067);
            AppMethodBeat.o(251067);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$AnchorFloatAction;", "", NativeProtocol.WEB_DIALOG_ACTION, "", "(Ljava/lang/String;II)V", "getAction", "()I", "CLICK_ENTER_LOTTERY_RECORD", "plugin-finder_release"})
    public enum d {
        CLICK_ENTER_LOTTERY_RECORD;
        
        public final int action = 6;

        public static d valueOf(String str) {
            AppMethodBeat.i(251027);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(251027);
            return dVar;
        }

        /* JADX WARN: Incorrect types in method signature: (I)V */
        private d(String str) {
        }

        static {
            AppMethodBeat.i(251025);
            AppMethodBeat.o(251025);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$AllCommentType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "LIVE_ALL_COMMENT_CLOSE", "LIVE_ALL_COMMENT_OPEN", "plugin-finder_release"})
    public enum b {
        LIVE_ALL_COMMENT_CLOSE(1),
        LIVE_ALL_COMMENT_OPEN(2);
        
        public final int type;

        public static b valueOf(String str) {
            AppMethodBeat.i(251021);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(251021);
            return bVar;
        }

        private b(int i2) {
            this.type = i2;
        }

        static {
            AppMethodBeat.i(251019);
            AppMethodBeat.o(251019);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$LivePersonalAction;", "", NativeProtocol.WEB_DIALOG_ACTION, "", "(Ljava/lang/String;II)V", "getAction", "()I", "LIVE_PERSONAL_VIEW_SHOW", "LIVE_PERSONAL_COMMENT_CLOSE", "LIVE_PERSONAL_COMMENT_OPEN", "LIVE_PERSONAL_COMPLAIN", "LIVE_PERSONAL_KICK_OUT", "plugin-finder_release"})
    public enum ac {
        LIVE_PERSONAL_VIEW_SHOW(1),
        LIVE_PERSONAL_COMMENT_CLOSE(2),
        LIVE_PERSONAL_COMMENT_OPEN(3),
        LIVE_PERSONAL_COMPLAIN(4),
        LIVE_PERSONAL_KICK_OUT(5);
        
        public final int action;

        public static ac valueOf(String str) {
            AppMethodBeat.i(251102);
            ac acVar = (ac) Enum.valueOf(ac.class, str);
            AppMethodBeat.o(251102);
            return acVar;
        }

        private ac(int i2) {
            this.action = i2;
        }

        static {
            AppMethodBeat.i(251100);
            AppMethodBeat.o(251100);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$LiveAnchorCommerceAction;", "", NativeProtocol.WEB_DIALOG_ACTION, "", "(Ljava/lang/String;II)V", "getAction", "()I", "LIVE_ENTER_SHOP", "LIVE_ADD_GOODS", "LIVE_CLICK_GOODS", "LIVE_DELETE_GOODS", "LIVE_SET_TOP_GOODS", "LIVE_START_PROMOTE_GOODS", "LIVE_FINISH_PROMOTE_GOODS", "LIVE_CLICK_PROMOTE_GOODS", "plugin-finder_release"})
    public enum aa {
        LIVE_ENTER_SHOP(1),
        LIVE_ADD_GOODS(2),
        LIVE_CLICK_GOODS(3),
        LIVE_DELETE_GOODS(4),
        LIVE_SET_TOP_GOODS(5),
        LIVE_START_PROMOTE_GOODS(7),
        LIVE_FINISH_PROMOTE_GOODS(8),
        LIVE_CLICK_PROMOTE_GOODS(9);
        
        public final int action;

        public static aa valueOf(String str) {
            AppMethodBeat.i(251096);
            aa aaVar = (aa) Enum.valueOf(aa.class, str);
            AppMethodBeat.o(251096);
            return aaVar;
        }

        private aa(int i2) {
            this.action = i2;
        }

        static {
            AppMethodBeat.i(251094);
            AppMethodBeat.o(251094);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$LiveBookAction;", "", NativeProtocol.WEB_DIALOG_ACTION, "", "(Ljava/lang/String;IJ)V", "getAction", "()J", "LIVE_SELF_PAGE_CLICK_BOOK_ITEM", "LIVE_ENTER_CRAETE_BOOK_PAGE", "LIVE_CREATE_BOOK_SUCC", "LIVE_JUMP_PROFILE_PAGE", "LIVE_CANCEL_BOOK", "plugin-finder_release"})
    public enum ab {
        LIVE_SELF_PAGE_CLICK_BOOK_ITEM(1),
        LIVE_ENTER_CRAETE_BOOK_PAGE(2),
        LIVE_CREATE_BOOK_SUCC(3),
        LIVE_JUMP_PROFILE_PAGE(4),
        LIVE_CANCEL_BOOK(5);
        
        final long hlf;

        public static ab valueOf(String str) {
            AppMethodBeat.i(251099);
            ab abVar = (ab) Enum.valueOf(ab.class, str);
            AppMethodBeat.o(251099);
            return abVar;
        }

        private ab(long j2) {
            this.hlf = j2;
        }

        static {
            AppMethodBeat.i(251097);
            AppMethodBeat.o(251097);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$LiveVerified;", "", NativeProtocol.WEB_DIALOG_ACTION, "", "(Ljava/lang/String;IJ)V", "getAction", "()J", "LIVE_VERIFIED_PAGE_EXPOSURE", "LIVE_ENTER_VERIFIED_PAGE", "LIVE_PASS_VERIFIED_SUCC", "LIVE_PASS_VERIFIED_FAIL", "plugin-finder_release"})
    public enum ad {
        LIVE_VERIFIED_PAGE_EXPOSURE(1),
        LIVE_ENTER_VERIFIED_PAGE(2),
        LIVE_PASS_VERIFIED_SUCC(3),
        LIVE_PASS_VERIFIED_FAIL(4);
        
        final long hlf;

        public static ad valueOf(String str) {
            AppMethodBeat.i(251105);
            ad adVar = (ad) Enum.valueOf(ad.class, str);
            AppMethodBeat.o(251105);
            return adVar;
        }

        private ad(long j2) {
            this.hlf = j2;
        }

        static {
            AppMethodBeat.i(251103);
            AppMethodBeat.o(251103);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorCloseType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "CloseTypeFloat", "CloseTypeFull", "CloseTypeKickedOut", "CloseTypeSlide", "CloseTypeOtherRoom", "CloseTypeLiveOver", "plugin-finder_release"})
    public enum at {
        CloseTypeFloat(1),
        CloseTypeFull(2),
        CloseTypeKickedOut(3),
        CloseTypeSlide(4),
        CloseTypeOtherRoom(5),
        CloseTypeLiveOver(6);
        
        final int type;

        public static at valueOf(String str) {
            AppMethodBeat.i(251153);
            at atVar = (at) Enum.valueOf(at.class, str);
            AppMethodBeat.o(251153);
            return atVar;
        }

        private at(int i2) {
            this.type = i2;
        }

        static {
            AppMethodBeat.i(251151);
            AppMethodBeat.o(251151);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorCommerceAction;", "", NativeProtocol.WEB_DIALOG_ACTION, "", "(Ljava/lang/String;II)V", "getAction", "()I", "CommerceActionBubbleTipShow", "CommerceActionBubbleTipClick", "CommerceActionShoppingButtonClick", "CommerceActionGoodsOrderButtonClick", "CommerceActionGoodsItemClick", "CommerceActionPurchaseButtonClick", "CommerceActionGoodsItemShow", "CommerceActionBubbleTipClose", "CommerceActionAnchorCloseBubble", "CommerceActionExitHalfPage", "plugin-finder_release"})
    public enum au {
        CommerceActionBubbleTipShow(1),
        CommerceActionBubbleTipClick(2),
        CommerceActionShoppingButtonClick(3),
        CommerceActionGoodsOrderButtonClick(4),
        CommerceActionGoodsItemClick(5),
        CommerceActionPurchaseButtonClick(6),
        CommerceActionGoodsItemShow(7),
        CommerceActionBubbleTipClose(8),
        CommerceActionAnchorCloseBubble(9),
        CommerceActionExitHalfPage(10);
        
        final int action;

        public static au valueOf(String str) {
            AppMethodBeat.i(251156);
            au auVar = (au) Enum.valueOf(au.class, str);
            AppMethodBeat.o(251156);
            return auVar;
        }

        private au(int i2) {
            this.action = i2;
        }

        static {
            AppMethodBeat.i(251154);
            AppMethodBeat.o(251154);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorAuthAction;", "", NativeProtocol.WEB_DIALOG_ACTION, "", "(Ljava/lang/String;II)V", "getAction", "()I", "AuthExposure", "AuthEnter", "AuthSucc", "AuthFail", "plugin-finder_release"})
    public enum as {
        AuthExposure(1),
        AuthEnter(2),
        AuthSucc(3),
        AuthFail(4);
        
        final int action;

        public static as valueOf(String str) {
            AppMethodBeat.i(251150);
            as asVar = (as) Enum.valueOf(as.class, str);
            AppMethodBeat.o(251150);
            return asVar;
        }

        private as(int i2) {
            this.action = i2;
        }

        static {
            AppMethodBeat.i(251148);
            AppMethodBeat.o(251148);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorAction;", "", NativeProtocol.WEB_DIALOG_ACTION, "", "(Ljava/lang/String;II)V", "getAction", "()I", "EnterRoom", "Message", "Like", "CommentExpose", "ComplaintEntry", "Float", "Share", "HideOpearation", "EnterProfile", "CopyComment", "SlideEnter", "Commerce", "QuitRoom", "Auth", "EXPLORE_SCREEN_SWITCH_BTN", "SWITCH_SCREEN", "REPLY", "LOTTERY", "GIFT", "LINKMIC", "NEARBY_LIVE_MORE", "FOLLOW_LIVE", "CLICK_ENTER_LINKMIC_ANCHOR_PROFILE", "RED_PACKET", "plugin-finder_release"})
    public enum ar {
        EnterRoom(1),
        Message(2),
        Like(3),
        CommentExpose(4),
        ComplaintEntry(5),
        Float(6),
        Share(7),
        HideOpearation(8),
        EnterProfile(9),
        CopyComment(10),
        SlideEnter(11),
        Commerce(12),
        QuitRoom(13),
        Auth(14),
        EXPLORE_SCREEN_SWITCH_BTN(15),
        SWITCH_SCREEN(16),
        REPLY(17),
        LOTTERY(18),
        GIFT(19),
        LINKMIC(20),
        NEARBY_LIVE_MORE(21),
        FOLLOW_LIVE(22),
        CLICK_ENTER_LINKMIC_ANCHOR_PROFILE(23),
        RED_PACKET(24);
        
        final int action;

        public static ar valueOf(String str) {
            AppMethodBeat.i(251147);
            ar arVar = (ar) Enum.valueOf(ar.class, str);
            AppMethodBeat.o(251147);
            return arVar;
        }

        private ar(int i2) {
            this.action = i2;
        }

        static {
            AppMethodBeat.i(251145);
            AppMethodBeat.o(251145);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$RedPacketType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "EXPOSE_RIGHT_UP_CORNER_RED_PACKET_", "CLICK_RED_PACKET", "CLICK_COMMENT_AREA_RED_PACKET_SYS_MSG", "EXPOSE_RED_PACKET_UI", "CLICK_OPEN_RED_PACKET", "EXPOSE_RED_PACKET_OVER_INTERCEPT_UI", "EXPOSE_ONLY_PART_USER_INTERCEPT_UI", "RED_PACKET_EXPIRED_NOTIFY", "ONLY_WX_IDENTIFY_INTERRUPT_NOTIFY", "SEE_DETAIL", "plugin-finder_release"})
    public enum bh {
        EXPOSE_RIGHT_UP_CORNER_RED_PACKET_(1),
        CLICK_RED_PACKET(2),
        CLICK_COMMENT_AREA_RED_PACKET_SYS_MSG(3),
        EXPOSE_RED_PACKET_UI(4),
        CLICK_OPEN_RED_PACKET(5),
        EXPOSE_RED_PACKET_OVER_INTERCEPT_UI(6),
        EXPOSE_ONLY_PART_USER_INTERCEPT_UI(7),
        RED_PACKET_EXPIRED_NOTIFY(8),
        ONLY_WX_IDENTIFY_INTERRUPT_NOTIFY(9),
        SEE_DETAIL(10);
        
        final int type;

        public static bh valueOf(String str) {
            AppMethodBeat.i(261361);
            bh bhVar = (bh) Enum.valueOf(bh.class, str);
            AppMethodBeat.o(261361);
            return bhVar;
        }

        private bh(int i2) {
            this.type = i2;
        }

        static {
            AppMethodBeat.i(261359);
            AppMethodBeat.o(261359);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$RedPacketSrc;", "", "src", "", "(Ljava/lang/String;II)V", "getSrc", "()I", "UNKNOWN", "ANCHOR", "LINKMIC_VISITOR", "plugin-finder_release"})
    public enum bg {
        UNKNOWN(-1),
        ANCHOR(1),
        LINKMIC_VISITOR(2);
        
        final int src;

        public static bg valueOf(String str) {
            AppMethodBeat.i(261358);
            bg bgVar = (bg) Enum.valueOf(bg.class, str);
            AppMethodBeat.o(261358);
            return bgVar;
        }

        private bg(int i2) {
            this.src = i2;
        }

        static {
            AppMethodBeat.i(261356);
            AppMethodBeat.o(261356);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ComplaintVisitorSource;", "", "source", "", "(Ljava/lang/String;II)V", "getSource", "()I", "COMMENT_ZONE", "HOT_LIST", "plugin-finder_release"})
    public enum k {
        COMMENT_ZONE(1),
        HOT_LIST(2);
        
        final int source;

        public static k valueOf(String str) {
            AppMethodBeat.i(251048);
            k kVar = (k) Enum.valueOf(k.class, str);
            AppMethodBeat.o(251048);
            return kVar;
        }

        private k(int i2) {
            this.source = i2;
        }

        static {
            AppMethodBeat.i(251046);
            AppMethodBeat.o(251046);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorGift;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "CLICK_GIFT_BOARD_ENTRY_START_GIFT_BOARD", "CLICK_GIFT_BOARD_INNER_GITF", "SINGLE_OR_CONTINUE_CLICK_SELECT_GITF_SEND", "CLICK_GIFT_BOARD_RIGHT_GREEN_ENTER_RECHARGE_UI", "SEND_GIFT_MONEY_NOT_ENOUGH_DIALOG_EXPLORE", "SEND_GIFT_MONEY_NOT_ENOUGH_CLICK_EXCHARGE_UI", "GIFT_ICON_EXPOSURE", "CLICK_HOT_LIST_SEE_CUR_DOU_YOU", "RETURN_GIFT_BOARD_FROM_EXCHARGE_UI", "RETURN_LIVE_ROOM_FROM_GIFT_BOARD", "GIFT_BOARD_TURN_PAGE", "CLICK_VISITOR_IN_HOT_LIST", "CLICK_Y_IN_HOT_LIST", "CLICK_READ_BTN_HOT_LIST", "EXPOSE_HALF_BOARD_HOT_LIST", "CLICK_PROFILE_HOT_LIST", "plugin-finder_release"})
    public enum aw {
        CLICK_GIFT_BOARD_ENTRY_START_GIFT_BOARD(1),
        CLICK_GIFT_BOARD_INNER_GITF(2),
        SINGLE_OR_CONTINUE_CLICK_SELECT_GITF_SEND(3),
        CLICK_GIFT_BOARD_RIGHT_GREEN_ENTER_RECHARGE_UI(4),
        SEND_GIFT_MONEY_NOT_ENOUGH_DIALOG_EXPLORE(5),
        SEND_GIFT_MONEY_NOT_ENOUGH_CLICK_EXCHARGE_UI(6),
        GIFT_ICON_EXPOSURE(7),
        CLICK_HOT_LIST_SEE_CUR_DOU_YOU(8),
        RETURN_GIFT_BOARD_FROM_EXCHARGE_UI(9),
        RETURN_LIVE_ROOM_FROM_GIFT_BOARD(10),
        GIFT_BOARD_TURN_PAGE(11),
        CLICK_VISITOR_IN_HOT_LIST(12),
        CLICK_Y_IN_HOT_LIST(13),
        CLICK_READ_BTN_HOT_LIST(14),
        EXPOSE_HALF_BOARD_HOT_LIST(15),
        CLICK_PROFILE_HOT_LIST(18);
        
        final int type;

        public static aw valueOf(String str) {
            AppMethodBeat.i(251162);
            aw awVar = (aw) Enum.valueOf(aw.class, str);
            AppMethodBeat.o(251162);
            return awVar;
        }

        private aw(int i2) {
            this.type = i2;
        }

        static {
            AppMethodBeat.i(251160);
            AppMethodBeat.o(251160);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorLinkMicAction;", "", NativeProtocol.WEB_DIALOG_ACTION, "", "(Ljava/lang/String;II)V", "getAction", "()I", "INVALIDATE", "APPLY_LINKMIC", "APPLY_AUDIO_LINKMIC", "APPLY_VIDEO_LINKMIC", "ANCHOR_PASS_LINKMIC_REQUEST", "TIMEOUT_NO_LINK_HUNG_UP", "POPUP_ANCHOR_LINKING_CONFLICT", "ACTIVE_STOP_AUDIO_LINKMIC", "ACTIVE_STOP_VIDEO_LINKMIC", "LINKMIC_ICON_EXPLORE", "plugin-finder_release"})
    public enum ax {
        INVALIDATE(0),
        APPLY_LINKMIC(1),
        APPLY_AUDIO_LINKMIC(2),
        APPLY_VIDEO_LINKMIC(3),
        ANCHOR_PASS_LINKMIC_REQUEST(4),
        TIMEOUT_NO_LINK_HUNG_UP(5),
        POPUP_ANCHOR_LINKING_CONFLICT(6),
        ACTIVE_STOP_AUDIO_LINKMIC(7),
        ACTIVE_STOP_VIDEO_LINKMIC(8),
        LINKMIC_ICON_EXPLORE(9);
        
        final int action;

        public static ax valueOf(String str) {
            AppMethodBeat.i(251165);
            ax axVar = (ax) Enum.valueOf(ax.class, str);
            AppMethodBeat.o(251165);
            return axVar;
        }

        private ax(int i2) {
            this.action = i2;
        }

        static {
            AppMethodBeat.i(251163);
            AppMethodBeat.o(251163);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorLotteryType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "EXPOSURE_BLESS_BAG", "CLICK_LUCKY_BAG", "CLICK_JOIN_LOTTERY", "SEND_SUCC_COMMENT", "POPUP_TOAST_JOINED", "SHOW_WIN_RESULT_CARD", "CLICK_WIN_LIST", "ENTER_WIN_RECORD_BY_RIGHH_CORNER", "CLICK_WIN_ITEM_ENTER_DETAIL", "CLICK_WIN_DETAIL_ENTER_PRIVATE_UI", "plugin-finder_release"})
    public enum ay {
        EXPOSURE_BLESS_BAG(1),
        CLICK_LUCKY_BAG(2),
        CLICK_JOIN_LOTTERY(3),
        SEND_SUCC_COMMENT(4),
        POPUP_TOAST_JOINED(5),
        SHOW_WIN_RESULT_CARD(6),
        CLICK_WIN_LIST(7),
        ENTER_WIN_RECORD_BY_RIGHH_CORNER(8),
        CLICK_WIN_ITEM_ENTER_DETAIL(9),
        CLICK_WIN_DETAIL_ENTER_PRIVATE_UI(10);
        
        final int type;

        public static ay valueOf(String str) {
            AppMethodBeat.i(251168);
            ay ayVar = (ay) Enum.valueOf(ay.class, str);
            AppMethodBeat.o(251168);
            return ayVar;
        }

        private ay(int i2) {
            this.type = i2;
        }

        static {
            AppMethodBeat.i(251166);
            AppMethodBeat.o(251166);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorWinResult;", "", "result", "", "(Ljava/lang/String;II)V", "getResult", "()I", "WIN", "NO_WIN", "NO_JOIN", "plugin-finder_release"})
    public enum bc {
        WIN(1),
        NO_WIN(2),
        NO_JOIN(3);
        
        public final int result;

        public static bc valueOf(String str) {
            AppMethodBeat.i(251180);
            bc bcVar = (bc) Enum.valueOf(bc.class, str);
            AppMethodBeat.o(251180);
            return bcVar;
        }

        private bc(int i2) {
            this.result = i2;
        }

        static {
            AppMethodBeat.i(251178);
            AppMethodBeat.o(251178);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$SCREEN_SWITCH_ACTION;", "", NativeProtocol.WEB_DIALOG_ACTION, "", "(Ljava/lang/String;II)V", "getAction", "()I", "HORIZONTAL_BY_CLICK_BTN", "HORIZONTAL_BY_ROTATE_PHONE", "PORTRAIT_BY_CLICK_BTN", "PORTRAIT_BY_ROTATE_PHONE", "plugin-finder_release"})
    public enum aj {
        HORIZONTAL_BY_CLICK_BTN(1),
        HORIZONTAL_BY_ROTATE_PHONE(2),
        PORTRAIT_BY_CLICK_BTN(3),
        PORTRAIT_BY_ROTATE_PHONE(4);
        
        final int action;

        public static aj valueOf(String str) {
            AppMethodBeat.i(251123);
            aj ajVar = (aj) Enum.valueOf(aj.class, str);
            AppMethodBeat.o(251123);
            return ajVar;
        }

        private aj(int i2) {
            this.action = i2;
        }

        static {
            AppMethodBeat.i(251121);
            AppMethodBeat.o(251121);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorNoticeAction;", "", NativeProtocol.WEB_DIALOG_ACTION, "", "(Ljava/lang/String;II)V", "getAction", "()I", "ExposeProfile", "Book", "Cancle", "ExposeMsg", "Click", "plugin-finder_release"})
    public enum az {
        ExposeProfile(1),
        Book(2),
        Cancle(3),
        ExposeMsg(4),
        Click(5);
        
        final int action;

        public static az valueOf(String str) {
            AppMethodBeat.i(251171);
            az azVar = (az) Enum.valueOf(az.class, str);
            AppMethodBeat.o(251171);
            return azVar;
        }

        private az(int i2) {
            this.action = i2;
        }

        static {
            AppMethodBeat.i(251169);
            AppMethodBeat.o(251169);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorShareType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "Chat", "Timeline", "PERSIONAL_STATE_SHARE_SUCC", "plugin-finder_release"})
    public enum ba {
        Chat(1),
        Timeline(2),
        PERSIONAL_STATE_SHARE_SUCC(5);
        
        final int type;

        public static ba valueOf(String str) {
            AppMethodBeat.i(251174);
            ba baVar = (ba) Enum.valueOf(ba.class, str);
            AppMethodBeat.o(251174);
            return baVar;
        }

        private ba(int i2) {
            this.type = i2;
        }

        static {
            AppMethodBeat.i(251172);
            AppMethodBeat.o(251172);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisitorShopBtnState;", "", "state", "", "(Ljava/lang/String;II)V", "getState", "()I", "NO_EXPOSURE", "EXPOSURE", "plugin-finder_release"})
    public enum bb {
        NO_EXPOSURE(0),
        EXPOSURE(1);
        
        final int state;

        public static bb valueOf(String str) {
            AppMethodBeat.i(251177);
            bb bbVar = (bb) Enum.valueOf(bb.class, str);
            AppMethodBeat.o(251177);
            return bbVar;
        }

        private bb(int i2) {
            this.state = i2;
        }

        static {
            AppMethodBeat.i(251175);
            AppMethodBeat.o(251175);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ShopPermitAction;", "", NativeProtocol.WEB_DIALOG_ACTION, "", "(Ljava/lang/String;II)V", "getAction", "()I", "LIVE_NO_SHOP_PERMIT", "LIVE_SHOP_PERMIT_NO_SMALL_STORE", "LIVE_SHOP_PERMIT_SMALL_STORE", "plugin-finder_release"})
    public enum an {
        LIVE_NO_SHOP_PERMIT(1),
        LIVE_SHOP_PERMIT_NO_SMALL_STORE(2),
        LIVE_SHOP_PERMIT_SMALL_STORE(3);
        
        final int action;

        public static an valueOf(String str) {
            AppMethodBeat.i(251135);
            an anVar = (an) Enum.valueOf(an.class, str);
            AppMethodBeat.o(251135);
            return anVar;
        }

        private an(int i2) {
            this.action = i2;
        }

        static {
            AppMethodBeat.i(251133);
            AppMethodBeat.o(251133);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ScreenDirection;", "", NativeProtocol.WEB_DIALOG_ACTION, "", "(Ljava/lang/String;II)V", "getAction", "()I", "LIVE_SCREEN_PORTRAIT", "LIVE_SCREEN_HORIZONTAL", "plugin-finder_release"})
    public enum am {
        LIVE_SCREEN_PORTRAIT(1),
        LIVE_SCREEN_HORIZONTAL(2);
        
        final int action;

        public static am valueOf(String str) {
            AppMethodBeat.i(251132);
            am amVar = (am) Enum.valueOf(am.class, str);
            AppMethodBeat.o(251132);
            return amVar;
        }

        private am(int i2) {
            this.action = i2;
        }

        static {
            AppMethodBeat.i(251130);
            AppMethodBeat.o(251130);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ClearScreenAction;", "", NativeProtocol.WEB_DIALOG_ACTION, "", "(Ljava/lang/String;II)V", "getAction", "()I", "CLICK_CLEAR_SCREEN", "CLICK_CLEAR_SCREEN_CANCEL", "CLICK_CLEAR_SCREEN_MENU", "plugin-finder_release"})
    public enum h {
        CLICK_CLEAR_SCREEN(1),
        CLICK_CLEAR_SCREEN_CANCEL(2),
        CLICK_CLEAR_SCREEN_MENU(3);
        
        final int action;

        public static h valueOf(String str) {
            AppMethodBeat.i(251039);
            h hVar = (h) Enum.valueOf(h.class, str);
            AppMethodBeat.o(251039);
            return hVar;
        }

        private h(int i2) {
            this.action = i2;
        }

        static {
            AppMethodBeat.i(251037);
            AppMethodBeat.o(251037);
        }
    }

    public static String getDescription() {
        String str;
        FinderObjectDesc finderObjectDesc;
        AppMethodBeat.i(251192);
        com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
        com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = com.tencent.mm.plugin.finder.live.model.o.dfZ();
        if (dfZ == null || (finderObjectDesc = dfZ.uDm) == null || (str = finderObjectDesc.description) == null) {
            str = "";
        }
        kotlin.g.b.p.g(str, "FinderLiveService.curLiv…Object?.description ?: \"\"");
        String encode = com.tencent.mm.compatible.util.q.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        kotlin.g.b.p.g(encode, "URLEncoder.encode(text, \"UTF-8\")");
        AppMethodBeat.o(251192);
        return encode;
    }

    public final String dpp() {
        awc awc;
        AppMethodBeat.i(251193);
        com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
        com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = com.tencent.mm.plugin.finder.live.model.o.dfZ();
        String str = (dfZ == null || (awc = dfZ.uEl) == null) ? null : awc.LGz;
        if (TextUtils.isEmpty(str)) {
            com.tencent.mm.plugin.finder.live.model.o oVar2 = com.tencent.mm.plugin.finder.live.model.o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ2 = com.tencent.mm.plugin.finder.live.model.o.dfZ();
            if (dfZ2 != null) {
                str = dfZ2.uEq;
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                str = this.vly;
            }
        }
        Log.i(this.TAG, "get shopAppid=".concat(String.valueOf(str)));
        if (str == null) {
            str = "";
        }
        AppMethodBeat.o(251193);
        return str;
    }

    public final void c(o oVar) {
        AppMethodBeat.i(251194);
        kotlin.g.b.p.h(oVar, "<set-?>");
        this.vmb = oVar;
        AppMethodBeat.o(251194);
    }

    public final String dpq() {
        long j2;
        awe awe;
        AppMethodBeat.i(251195);
        com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
        com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = com.tencent.mm.plugin.finder.live.model.o.dfZ();
        if (dfZ == null || (awe = dfZ.liveInfo) == null) {
            j2 = -1;
        } else {
            j2 = awe.liveId;
        }
        if (j2 == -1) {
            String str = this.vmj.hJs;
            AppMethodBeat.o(251195);
            return str;
        }
        String zs = com.tencent.mm.plugin.expt.hellhound.core.b.zs(j2);
        kotlin.g.b.p.g(zs, "HellhoundUtil.long2UnsignedString(liveId)");
        AppMethodBeat.o(251195);
        return zs;
    }

    public final String dpr() {
        long j2;
        AppMethodBeat.i(251196);
        com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
        com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = com.tencent.mm.plugin.finder.live.model.o.dfZ();
        if (dfZ != null) {
            j2 = dfZ.hFK;
        } else {
            j2 = 0;
        }
        if (j2 == 0) {
            String str = this.vmj.feedId;
            AppMethodBeat.o(251196);
            return str;
        }
        String zs = com.tencent.mm.plugin.expt.hellhound.core.b.zs(j2);
        kotlin.g.b.p.g(zs, "HellhoundUtil.long2UnsignedString(feedId)");
        AppMethodBeat.o(251196);
        return zs;
    }

    public static String dps() {
        AppMethodBeat.i(251197);
        String cMD = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU().cMD();
        if (cMD == null) {
            cMD = "";
        }
        AppMethodBeat.o(251197);
        return cMD;
    }

    public static int auU(String str) {
        AppMethodBeat.i(251198);
        if (str == null) {
            AppMethodBeat.o(251198);
            return 0;
        }
        c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
        com.tencent.mm.plugin.finder.api.g asG = c.a.asG(str);
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        if (com.tencent.mm.plugin.finder.utils.y.i(asG)) {
            AppMethodBeat.o(251198);
            return 1;
        }
        AppMethodBeat.o(251198);
        return 0;
    }

    public static String dpt() {
        AppMethodBeat.i(251199);
        String aUg = com.tencent.mm.model.z.aUg();
        if (aUg == null) {
            aUg = "";
        }
        AppMethodBeat.o(251199);
        return aUg;
    }

    public static int dpu() {
        AppMethodBeat.i(251200);
        String dpt = dpt();
        c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
        com.tencent.mm.plugin.finder.api.g asG = c.a.asG(dpt);
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        if (com.tencent.mm.plugin.finder.utils.y.i(asG)) {
            AppMethodBeat.o(251200);
            return 1;
        }
        AppMethodBeat.o(251200);
        return 0;
    }

    public final void dpv() {
        AppMethodBeat.i(251201);
        HashMap<Long, LinkedList<o>> hashMap = this.vmj.vtA;
        if (hashMap.isEmpty()) {
            AppMethodBeat.o(251201);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        for (Map.Entry<Long, LinkedList<o>> entry : hashMap.entrySet()) {
            Iterator<o> it = entry.getValue().iterator();
            while (it.hasNext()) {
                o next = it.next();
                if (!next.vlm) {
                    next.vlm = true;
                    long j2 = currentTimeMillis - next.time;
                    if (j2 <= 0) {
                        j2 = 0;
                    }
                    next.time = j2;
                }
            }
        }
        AppMethodBeat.o(251201);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ScreenBtnEvent;", "", NativeProtocol.WEB_DIALOG_ACTION, "", "(Ljava/lang/String;II)V", "getAction", "()I", "FROM_ONCREATE", "FROM_ONRESUME", "FROM_ONPLUGIN", "plugin-finder_release"})
    public enum al {
        FROM_ONCREATE(0),
        FROM_ONRESUME(1),
        FROM_ONPLUGIN(2);
        
        private final int action;

        public static al valueOf(String str) {
            AppMethodBeat.i(251129);
            al alVar = (al) Enum.valueOf(al.class, str);
            AppMethodBeat.o(251129);
            return alVar;
        }

        private al(int i2) {
            this.action = i2;
        }

        static {
            AppMethodBeat.i(251127);
            AppMethodBeat.o(251127);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$IsGift;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "YES", "NO", "plugin-finder_release"})
    public enum v {
        YES(1),
        NO(2);
        
        final int type;

        public static v valueOf(String str) {
            AppMethodBeat.i(251081);
            v vVar = (v) Enum.valueOf(v.class, str);
            AppMethodBeat.o(251081);
            return vVar;
        }

        private v(int i2) {
            this.type = i2;
        }

        static {
            AppMethodBeat.i(251079);
            AppMethodBeat.o(251079);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$NearbyPageType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "START_LIVE_BY_FINDER_IDENTITY", "CREATE_FINDER", "WECHAT_REALNAME_AUTH", "plugin-finder_release"})
    public enum ah {
        START_LIVE_BY_FINDER_IDENTITY(1),
        CREATE_FINDER(2),
        WECHAT_REALNAME_AUTH(3);
        
        final int type;

        public static ah valueOf(String str) {
            AppMethodBeat.i(251117);
            ah ahVar = (ah) Enum.valueOf(ah.class, str);
            AppMethodBeat.o(251117);
            return ahVar;
        }

        private ah(int i2) {
            this.type = i2;
        }

        static {
            AppMethodBeat.i(251115);
            AppMethodBeat.o(251115);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$NearbyAction2;", "", NativeProtocol.WEB_DIALOG_ACTION, "", "(Ljava/lang/String;II)V", "getAction", "()I", "ENTER_PAGE_EXPLORE", "CLICK_CANCEL_RETURN", "CLICK_START_LIVE", "plugin-finder_release"})
    public enum af {
        ENTER_PAGE_EXPLORE(1),
        CLICK_CANCEL_RETURN(2),
        CLICK_START_LIVE(3);
        
        final int action;

        public static af valueOf(String str) {
            AppMethodBeat.i(251111);
            af afVar = (af) Enum.valueOf(af.class, str);
            AppMethodBeat.o(251111);
            return afVar;
        }

        private af(int i2) {
            this.action = i2;
        }

        static {
            AppMethodBeat.i(251109);
            AppMethodBeat.o(251109);
        }
    }

    public final void a(ah ahVar) {
        AppMethodBeat.i(251202);
        kotlin.g.b.p.h(ahVar, "<set-?>");
        this.vmr = ahVar;
        AppMethodBeat.o(251202);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$StartLiveSource;", "", "source", "", "(Ljava/lang/String;II)V", "getSource", "()I", "FINDER_PROFILE", "NEARBY_LIVE", "FINDER_PROFILE_RIGHT_CORNER", "plugin-finder_release"})
    public enum ao {
        FINDER_PROFILE(1),
        NEARBY_LIVE(2),
        FINDER_PROFILE_RIGHT_CORNER(3);
        
        final int source;

        public static ao valueOf(String str) {
            AppMethodBeat.i(251138);
            ao aoVar = (ao) Enum.valueOf(ao.class, str);
            AppMethodBeat.o(251138);
            return aoVar;
        }

        private ao(int i2) {
            this.source = i2;
        }

        static {
            AppMethodBeat.i(251136);
            AppMethodBeat.o(251136);
        }
    }

    public final void b(ao aoVar) {
        AppMethodBeat.i(251203);
        kotlin.g.b.p.h(aoVar, "<set-?>");
        this.vms = aoVar;
        AppMethodBeat.o(251203);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$BookLiveSrc;", "", "source", "", "(Ljava/lang/String;II)V", "getSource", "()I", "PROFILE", "PROFILE_RIGHT_CORNER", "plugin-finder_release"})
    public enum g {
        PROFILE(1),
        PROFILE_RIGHT_CORNER(2);
        
        final int source;

        public static g valueOf(String str) {
            AppMethodBeat.i(251036);
            g gVar = (g) Enum.valueOf(g.class, str);
            AppMethodBeat.o(251036);
            return gVar;
        }

        private g(int i2) {
            this.source = i2;
        }

        static {
            AppMethodBeat.i(251034);
            AppMethodBeat.o(251034);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$AnchorLiveClose;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "ENTER_LIVE_CLOSE_UI", "SEE_GIFT_LIST", "CLICK_FINISH", "plugin-finder_release"})
    public enum e {
        ENTER_LIVE_CLOSE_UI(1),
        SEE_GIFT_LIST(2),
        CLICK_FINISH(3);
        
        final int type;

        public static e valueOf(String str) {
            AppMethodBeat.i(251030);
            e eVar = (e) Enum.valueOf(e.class, str);
            AppMethodBeat.o(251030);
            return eVar;
        }

        private e(int i2) {
            this.type = i2;
        }

        static {
            AppMethodBeat.i(251028);
            AppMethodBeat.o(251028);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$CloseUISeeGiftList;", "", NativeProtocol.WEB_DIALOG_ACTION, "", "(Ljava/lang/String;II)V", "getAction", "()I", "UNDEFINE", "ENTER_UI", "CLICK_FETCH_INCOME", "RETRUN_LIVE_CLOSE_UI", "CLICK_LIST_ITEM_USER", "EXPOSE_USER_FINDER_HALF_BOARD", "CLICK_PRIVATE_MSG_USER", "CLICK_FOLLOW_USER", "CLICK_ENTER_USER_PROFILE", "plugin-finder_release"})
    public enum i {
        UNDEFINE(-1),
        ENTER_UI(1),
        CLICK_FETCH_INCOME(2),
        RETRUN_LIVE_CLOSE_UI(3),
        CLICK_LIST_ITEM_USER(4),
        EXPOSE_USER_FINDER_HALF_BOARD(5),
        CLICK_PRIVATE_MSG_USER(6),
        CLICK_FOLLOW_USER(7),
        CLICK_ENTER_USER_PROFILE(8);
        
        public final int action;

        public static i valueOf(String str) {
            AppMethodBeat.i(251042);
            i iVar = (i) Enum.valueOf(i.class, str);
            AppMethodBeat.o(251042);
            return iVar;
        }

        private i(int i2) {
            this.action = i2;
        }

        static {
            AppMethodBeat.i(251040);
            AppMethodBeat.o(251040);
        }
    }

    public static long as(String str, long j2) {
        AppMethodBeat.i(251204);
        if (kotlin.g.b.p.j(str, j.COMMENT_SCENE_PULLDOWN_MENU.scene) || kotlin.g.b.p.j(str, j.COMMENT_SCENE_SLEF_STATUS.scene) || kotlin.g.b.p.j(str, w.PUBLIC_NUMBER.type) || kotlin.g.b.p.j(str, w.SEARCH_1_SEARCH.type) || kotlin.g.b.p.j(str, w.LITTLE_APP.type) || kotlin.g.b.p.j(str, w.SEE_1_SEE.type)) {
            long j3 = (long) av.CLICK_SNSAD_ENTER_LIVE_ROOM.type;
            AppMethodBeat.o(251204);
            return j3;
        }
        kotlin.g.b.p.j(str, w.GAME_CENTER.type);
        AppMethodBeat.o(251204);
        return j2;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$NearbyMoreActionResult;", "", "result", "", "(Ljava/lang/String;II)V", "getResult", "()I", "EXPLORE_MORE_LIVE", "CLICK_MORE_LIVE", "plugin-finder_release"})
    public enum ag {
        EXPLORE_MORE_LIVE(1),
        CLICK_MORE_LIVE(2);
        
        final int result;

        public static ag valueOf(String str) {
            AppMethodBeat.i(251114);
            ag agVar = (ag) Enum.valueOf(ag.class, str);
            AppMethodBeat.o(251114);
            return agVar;
        }

        private ag(int i2) {
            this.result = i2;
        }

        static {
            AppMethodBeat.i(251112);
            AppMethodBeat.o(251112);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$VisibleRangeType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "PUBLIC", "NUMBER_TO_SEE", "ONLY_ANCHOR_SHARE", "plugin-finder_release"})
    public enum aq {
        PUBLIC(0),
        NUMBER_TO_SEE(1),
        ONLY_ANCHOR_SHARE(2);
        
        final int type;

        public static aq valueOf(String str) {
            AppMethodBeat.i(251144);
            aq aqVar = (aq) Enum.valueOf(aq.class, str);
            AppMethodBeat.o(251144);
            return aqVar;
        }

        private aq(int i2) {
            this.type = i2;
        }

        static {
            AppMethodBeat.i(251142);
            AppMethodBeat.o(251142);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$MicType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "ANCHOR_ANCHOR", "ANCHOR_VISITOR", "plugin-finder_release"})
    public enum bf {
        ANCHOR_ANCHOR(1),
        ANCHOR_VISITOR(2);
        
        public final int type;

        public static bf valueOf(String str) {
            AppMethodBeat.i(261355);
            bf bfVar = (bf) Enum.valueOf(bf.class, str);
            AppMethodBeat.o(261355);
            return bfVar;
        }

        private bf(int i2) {
            this.type = i2;
        }

        static {
            AppMethodBeat.i(261353);
            AppMethodBeat.o(261353);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$InviteType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "INITIATIVE", "PASSIVE", "plugin-finder_release"})
    public enum be {
        INITIATIVE(1),
        PASSIVE(2);
        
        public final int type;

        public static be valueOf(String str) {
            AppMethodBeat.i(261352);
            be beVar = (be) Enum.valueOf(be.class, str);
            AppMethodBeat.o(261352);
            return beVar;
        }

        private be(int i2) {
            this.type = i2;
        }

        static {
            AppMethodBeat.i(261350);
            AppMethodBeat.o(261350);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$FollowBtnAction;", "", NativeProtocol.WEB_DIALOG_ACTION, "", "(Ljava/lang/String;II)V", "getAction", "()I", "EXPOSE", "CLICK_2_FOLLOW", "CLICK_2_PROFILE", "plugin-finder_release"})
    public enum bd {
        EXPOSE(1),
        CLICK_2_FOLLOW(2),
        CLICK_2_PROFILE(3);
        
        final int action;

        public static bd valueOf(String str) {
            AppMethodBeat.i(261349);
            bd bdVar = (bd) Enum.valueOf(bd.class, str);
            AppMethodBeat.o(261349);
            return bdVar;
        }

        private bd(int i2) {
            this.action = i2;
        }

        static {
            AppMethodBeat.i(261347);
            AppMethodBeat.o(261347);
        }
    }
}
