package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.j;
import com.tencent.mm.protocal.protobuf.eic;
import com.tencent.mm.protocal.protobuf.fn;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.ad;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;
import kotlin.s;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\bU\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bw\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0016\n\u0002\b\u0003\u0018\u0000 ô\u00012\u00020\u0001:\u0002ô\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010Ü\u0001\u001a\u00020\bH\u0002J\u0015\u0010Ý\u0001\u001a\u00020\b2\n\b\u0002\u0010Þ\u0001\u001a\u00030ß\u0001H\u0002J\t\u0010à\u0001\u001a\u00020\bH\u0002J\t\u0010á\u0001\u001a\u00020\bH\u0002J\t\u0010â\u0001\u001a\u00020\bH\u0002JA\u0010ã\u0001\u001a\u00030ä\u000127\b\u0002\u0010å\u0001\u001a0\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0018\u0012\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0è\u00010ç\u0001\u0012\u0005\u0012\u00030ä\u00010æ\u0001J\t\u0010é\u0001\u001a\u00020\bH\u0016J\u0017\u0010ê\u0001\u001a\u00020\b*\u00030ë\u00012\u0007\u0010ì\u0001\u001a\u00020\u0006H\u0002J\r\u0010í\u0001\u001a\u00020\u0004*\u00020\u0004H\u0002J\r\u0010î\u0001\u001a\u00020\b*\u00020\u0004H\u0002J\r\u0010ï\u0001\u001a\u00020\f*\u00020\u0004H\u0002J-\u0010ð\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040b*\b\u0012\u0004\u0012\u00020\u00040b2\f\u0010ñ\u0001\u001a\u00030ò\u0001\"\u00020\u0004H\u0002¢\u0006\u0003\u0010ó\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001b\u0010%\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b'\u0010\u001b\u001a\u0004\b&\u0010\u001fR\u001b\u0010(\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b*\u0010\u001b\u001a\u0004\b)\u0010\u0013R\u001a\u0010+\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001f\"\u0004\b-\u0010!R\u001a\u0010.\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001f\"\u0004\b0\u0010!R\u000e\u00101\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u000e\"\u0004\b6\u0010\u0010R\u001a\u00107\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u000e\"\u0004\b9\u0010\u0010R\u000e\u0010:\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010;\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u000e\"\u0004\b<\u0010\u0010R\u001a\u0010=\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u000e\"\u0004\b>\u0010\u0010R\u001a\u0010?\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u000e\"\u0004\b@\u0010\u0010R\u001a\u0010A\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u000e\"\u0004\bB\u0010\u0010R\u001a\u0010C\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u000e\"\u0004\bD\u0010\u0010R\u001a\u0010E\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u000e\"\u0004\bF\u0010\u0010R\u001a\u0010G\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u000e\"\u0004\bH\u0010\u0010R\u001a\u0010I\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u000e\"\u0004\bJ\u0010\u0010R\u001a\u0010K\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u000e\"\u0004\bL\u0010\u0010R\u001a\u0010M\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u000e\"\u0004\bN\u0010\u0010R\u001a\u0010O\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u000e\"\u0004\bP\u0010\u0010R\u001a\u0010Q\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0019\"\u0004\bS\u0010TR\u001a\u0010U\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u0013\"\u0004\bW\u0010\u0015R\u001b\u0010X\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\bZ\u0010\u001b\u001a\u0004\bY\u0010\u0013R\u000e\u0010[\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010^\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u0013\"\u0004\b`\u0010\u0015R!\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00040b8BX\u0002¢\u0006\f\n\u0004\be\u0010\u001b\u001a\u0004\bc\u0010dR\u001a\u0010f\u001a\u00020gX.¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u001a\u0010l\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\u001f\"\u0004\bn\u0010!R\u001a\u0010o\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010\u001f\"\u0004\bq\u0010!R\u001a\u0010r\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\u001f\"\u0004\bt\u0010!R\u001a\u0010u\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010\u001f\"\u0004\bw\u0010!R\u001a\u0010x\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010\u001f\"\u0004\bz\u0010!R\u001a\u0010{\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010\u001f\"\u0004\b}\u0010!R\u001b\u0010~\u001a\u00020\u0004X\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u0010\u001f\"\u0005\b\u0001\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b\u0001\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b\u0001\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b\u0001\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b\u0001\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b\u0001\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b\u0001\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b\u0001\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b\u0001\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b\u0001\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b\u0001\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b \u0001\u0010\u001f\"\u0005\b¡\u0001\u0010!R\u001d\u0010¢\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b£\u0001\u0010\u001f\"\u0005\b¤\u0001\u0010!R\u001d\u0010¥\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¦\u0001\u0010\u001f\"\u0005\b§\u0001\u0010!R\u001d\u0010¨\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b©\u0001\u0010\u001f\"\u0005\bª\u0001\u0010!R\u001d\u0010«\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¬\u0001\u0010\u001f\"\u0005\b­\u0001\u0010!R\u001d\u0010®\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¯\u0001\u0010\u001f\"\u0005\b°\u0001\u0010!R\u001d\u0010±\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b²\u0001\u0010\u001f\"\u0005\b³\u0001\u0010!R\u001d\u0010´\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bµ\u0001\u0010\u001f\"\u0005\b¶\u0001\u0010!R\u001d\u0010·\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¸\u0001\u0010\u001f\"\u0005\b¹\u0001\u0010!R\u001d\u0010º\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b»\u0001\u0010\u001f\"\u0005\b¼\u0001\u0010!R\u001d\u0010½\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¾\u0001\u0010\u001f\"\u0005\b¿\u0001\u0010!R\u001d\u0010À\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÁ\u0001\u0010\u001f\"\u0005\bÂ\u0001\u0010!R\u001d\u0010Ã\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÄ\u0001\u0010\u001f\"\u0005\bÅ\u0001\u0010!R\u001d\u0010Æ\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÇ\u0001\u0010\u001f\"\u0005\bÈ\u0001\u0010!R\u001d\u0010É\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÊ\u0001\u0010\u001f\"\u0005\bË\u0001\u0010!R\u001d\u0010Ì\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÍ\u0001\u0010\u001f\"\u0005\bÎ\u0001\u0010!R\u001d\u0010Ï\u0001\u001a\u00020\bX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÐ\u0001\u0010\u0019\"\u0005\bÑ\u0001\u0010TR\u001d\u0010Ò\u0001\u001a\u00020\fX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÓ\u0001\u0010\u000e\"\u0005\bÔ\u0001\u0010\u0010R\u000f\u0010Õ\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001f\u0010Ö\u0001\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b×\u0001\u0010\u0019\"\u0005\bØ\u0001\u0010TR\u001e\u0010Ù\u0001\u001a\u00020\b8BX\u0002¢\u0006\u000e\n\u0005\bÛ\u0001\u0010\u001b\u001a\u0005\bÚ\u0001\u0010\u0019¨\u0006õ\u0001"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "", "()V", "MAX_LIMIT", "", "MM_WEBIVEW_PRELOAD_LOAD_TIME", "", "TAG", "", "a8KeyFinishTime", "bindWebViewCostTime", "cacheItemShowType", "", "getCacheItemShowType", "()Z", "setCacheItemShowType", "(Z)V", "clientCachedTime", "getClientCachedTime", "()I", "setClientCachedTime", "(I)V", "clientFirstFinishTime", "contentId", "getContentId", "()Ljava/lang/String;", "contentId$delegate", "Lkotlin/Lazy;", "createWebViewCostTime", "ctWebCompile", "getCtWebCompile", "()J", "setCtWebCompile", "(J)V", "ctWebFirstScreen", "getCtWebFirstScreen", "setCtWebFirstScreen", "dataCachedTime", "getDataCachedTime", "dataCachedTime$delegate", "dataVersion", "getDataVersion", "dataVersion$delegate", "etWebFirstScreen", "getEtWebFirstScreen", "setEtWebFirstScreen", "evalCostTime", "getEvalCostTime", "setEvalCostTime", "evalPageDataCostTime", "getA8KeyCostTime", "getPageDataCostTime", "hasAuth", "getHasAuth", "setHasAuth", "hasInject", "getHasInject", "setHasInject", "injectCostTime", "isInjectSuccess", "setInjectSuccess", "isMounted", "setMounted", "isOnlineWebView", "setOnlineWebView", "isPrefixMP", "setPrefixMP", "isSyncGetPageData", "setSyncGetPageData", "isTimeoutRedirect", "setTimeoutRedirect", "isTmplReady", "setTmplReady", "isWebViewCreated", "setWebViewCreated", "isWebViewPreUpdated", "setWebViewPreUpdated", "isWebViewProcessCreated", "setWebViewProcessCreated", "isZip", "setZip", "key", "getKey", "setKey", "(Ljava/lang/String;)V", "openScene", "getOpenScene", "setOpenScene", "pageDataSize", "getPageDataSize", "pageDataSize$delegate", "pageFinishTime", "pageFinishTimeType", "pageFinishTimestamp", "relaunchState", "getRelaunchState", "setRelaunchState", "speedMatrix", "", "getSpeedMatrix", "()[Ljava/lang/Long;", "speedMatrix$delegate", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "getTmplParams", "()Lcom/tencent/mm/protocal/protobuf/TmplParams;", "setTmplParams", "(Lcom/tencent/mm/protocal/protobuf/TmplParams;)V", "tsEndAcGetData", "getTsEndAcGetData", "setTsEndAcGetData", "tsEndGetA8Key", "getTsEndGetA8Key", "setTsEndGetA8Key", "tsEndGetData", "getTsEndGetData", "setTsEndGetData", "tsEndInject", "getTsEndInject", "setTsEndInject", "tsEndNotifyPage", "getTsEndNotifyPage", "setTsEndNotifyPage", "tsEndPostBind", "getTsEndPostBind", "setTsEndPostBind", "tsEndProcessInit", "getTsEndProcessInit", "setTsEndProcessInit", "tsEndTmplLoad", "getTsEndTmplLoad", "setTsEndTmplLoad", "tsEndUIInit", "getTsEndUIInit", "setTsEndUIInit", "tsEndWebGetData", "getTsEndWebGetData", "setTsEndWebGetData", "tsEndWebInject", "getTsEndWebInject", "setTsEndWebInject", "tsEndWebViewCreate", "getTsEndWebViewCreate", "setTsEndWebViewCreate", "tsStartAcGetData", "getTsStartAcGetData", "setTsStartAcGetData", "tsStartEndBind", "getTsStartEndBind", "setTsStartEndBind", "tsStartGetA8Key", "getTsStartGetA8Key", "setTsStartGetA8Key", "tsStartGetData", "getTsStartGetData", "setTsStartGetData", "tsStartInject", "getTsStartInject", "setTsStartInject", "tsStartPage", "getTsStartPage", "setTsStartPage", "tsStartPostBind", "getTsStartPostBind", "setTsStartPostBind", "tsStartProcessConfiguration", "getTsStartProcessConfiguration", "setTsStartProcessConfiguration", "tsStartProcessDependency", "getTsStartProcessDependency", "setTsStartProcessDependency", "tsStartProcessExecution", "getTsStartProcessExecution", "setTsStartProcessExecution", "tsStartProcessExtensions", "getTsStartProcessExtensions", "setTsStartProcessExtensions", "tsStartProcessHello", "getTsStartProcessHello", "setTsStartProcessHello", "tsStartProcessInit", "getTsStartProcessInit", "setTsStartProcessInit", "tsStartProcessInstall", "getTsStartProcessInstall", "setTsStartProcessInstall", "tsStartProcessTerminate", "getTsStartProcessTerminate", "setTsStartProcessTerminate", "tsStartTmplLoad", "getTsStartTmplLoad", "setTsStartTmplLoad", "tsStartTryBind", "getTsStartTryBind", "setTsStartTryBind", "tsStartUICreate", "getTsStartUICreate", "setTsStartUICreate", "tsStartUIInit", "getTsStartUIInit", "setTsStartUIInit", "tsStartWebViewCreate", "getTsStartWebViewCreate", "setTsStartWebViewCreate", "tsWebFirstScreen", "getTsWebFirstScreen", "setTsWebFirstScreen", "url", "getUrl", "setUrl", "useLocalJs", "getUseLocalJs", "setUseLocalJs", "webReceivePageDataTime", "webviewKind", "getWebviewKind", "setWebviewKind", "webviewProcess", "getWebviewProcess", "webviewProcess$delegate", "printDataState", "printDebugger", "prefix", "", "printProcessState", "printTmplState", "printWebViewState", "report", "", "data", "Lkotlin/Function3;", "", "Lkotlin/Pair;", "toString", "format", "", "digits", "limit", "toDate", "valid", "verify", "vals", "", "([Ljava/lang/Long;[J)[Ljava/lang/Long;", "Companion", "plugin-brandservice_release"})
public final class i {
    public static final a pCy = new a((byte) 0);
    private final String TAG = "MicroMsg.Preload.Kv15862";
    private String key = "";
    public boolean kwO;
    public long pBA = -1;
    public long pBB = -1;
    public long pBC = -1;
    public long pBD = -1;
    public long pBE = -1;
    public long pBF = -1;
    long pBG;
    long pBH;
    long pBI;
    long pBJ;
    long pBK;
    public long pBL;
    public long pBM;
    public long pBN;
    public long pBO;
    public long pBP;
    public long pBQ;
    public long pBR;
    public long pBS;
    public long pBT;
    public boolean pBU;
    public boolean pBV;
    public boolean pBW;
    public boolean pBX;
    public boolean pBY;
    public boolean pBZ;
    private final int pBe = 15862;
    public eic pBf;
    public int pBg;
    private final kotlin.f pBh = kotlin.g.ah(new b(this));
    private final kotlin.f pBi = kotlin.g.ah(new e(this));
    private final kotlin.f pBj = kotlin.g.ah(new c(this));
    private final kotlin.f pBk = kotlin.g.ah(new d(this));
    private long pBl = -1;
    public long pBm;
    public long pBn;
    long pBo;
    public long pBp;
    public long pBq;
    public long pBr;
    public long pBs;
    public long pBt;
    public long pBu;
    public long pBv;
    long pBw;
    public long pBx;
    public long pBy = -1;
    public long pBz = -1;
    public boolean pCa;
    public boolean pCb;
    public boolean pCc;
    public int pCd;
    public boolean pCe;
    public boolean pCf;
    private long pCg;
    private int pCh;
    private long pCi;
    private long pCj;
    private long pCk;
    private long pCl;
    private long pCm;
    private long pCn;
    private long pCo;
    private long pCp;
    private long pCq;
    private long pCr;
    public String pCs = "";
    private final kotlin.f pCt = kotlin.g.ah(h.pCB);
    public boolean pCu;
    public boolean pCv;
    private final kotlin.f pCw = kotlin.g.ah(new f(this));
    private long pCx = Util.MILLSECONDS_OF_HOUR;
    public int pmM = 10000;
    public String url = "";

    static {
        AppMethodBeat.i(6601);
        AppMethodBeat.o(6601);
    }

    private final String cnK() {
        AppMethodBeat.i(6602);
        String str = (String) this.pBh.getValue();
        AppMethodBeat.o(6602);
        return str;
    }

    private final int cnL() {
        AppMethodBeat.i(6603);
        int intValue = ((Number) this.pBi.getValue()).intValue();
        AppMethodBeat.o(6603);
        return intValue;
    }

    private final long cnM() {
        AppMethodBeat.i(6604);
        long longValue = ((Number) this.pBj.getValue()).longValue();
        AppMethodBeat.o(6604);
        return longValue;
    }

    private final int cnN() {
        AppMethodBeat.i(6605);
        int intValue = ((Number) this.pBk.getValue()).intValue();
        AppMethodBeat.o(6605);
        return intValue;
    }

    private final String cnO() {
        AppMethodBeat.i(6606);
        String str = (String) this.pCt.getValue();
        AppMethodBeat.o(6606);
        return str;
    }

    private final Long[] cnP() {
        AppMethodBeat.i(6607);
        Long[] lArr = (Long[]) this.pCw.getValue();
        AppMethodBeat.o(6607);
        return lArr;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"verify", "", "", "invoke"})
    static final class g extends q implements kotlin.g.a.b<Long, String> {
        final /* synthetic */ i pCz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(i iVar) {
            super(1);
            this.pCz = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(Long l) {
            AppMethodBeat.i(6597);
            String BJ = BJ(l.longValue());
            AppMethodBeat.o(6597);
            return BJ;
        }

        public final String BJ(long j2) {
            AppMethodBeat.i(6598);
            if (i.a(this.pCz, j2)) {
                String valueOf = String.valueOf(j2);
                AppMethodBeat.o(6598);
                return valueOf;
            }
            AppMethodBeat.o(6598);
            return "NaN";
        }
    }

    public i() {
        AppMethodBeat.i(6618);
        AppMethodBeat.o(6618);
    }

    public static final /* synthetic */ String a(i iVar) {
        AppMethodBeat.i(6620);
        String cnK = iVar.cnK();
        AppMethodBeat.o(6620);
        return cnK;
    }

    public final void a(eic eic) {
        AppMethodBeat.i(195601);
        p.h(eic, "<set-?>");
        this.pBf = eic;
        AppMethodBeat.o(195601);
    }

    public final void setKey(String str) {
        AppMethodBeat.i(195602);
        p.h(str, "<set-?>");
        this.key = str;
        AppMethodBeat.o(195602);
    }

    public final void b(kotlin.g.a.q<? super String, ? super String, ? super List<o<String, String>>, x> qVar) {
        String str;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z;
        int i6;
        boolean z2;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        AppMethodBeat.i(6608);
        p.h(qVar, "data");
        if (!this.pCe || !this.pCf) {
            AppMethodBeat.o(6608);
            return;
        }
        eic eic = this.pBf;
        if (eic == null) {
            p.btv("tmplParams");
        }
        com.tencent.mm.plugin.webview.h.a.gH(eic.reportId, 132);
        String netWorkType = f.getNetWorkType();
        this.pCg = Math.max(this.pBn, this.pBx);
        this.pCh = this.pBn < this.pBx ? 1 : 2;
        this.pCi = this.pCg - this.pBm;
        this.pCo = this.pBr - this.pBm;
        this.pCn = this.pBB - this.pBC;
        this.pCp = this.pBx - this.pBm;
        this.pCq = this.pBx - this.pBw;
        this.pBo = this.pBn - this.pBm;
        this.pCj = this.pBy - this.pBm;
        this.pCk = this.pBz - this.pBy;
        this.pCm = this.pBt - this.pBs;
        this.pCl = this.pBB - this.pBA;
        this.pBl = this.pBB - this.pBC;
        this.pCr = this.pCj + this.pCk + this.pCm + this.pCl + this.pBq + this.pBp;
        String str2 = this.TAG;
        Object[] objArr = new Object[23];
        eic eic2 = this.pBf;
        if (eic2 == null) {
            p.btv("tmplParams");
        }
        objArr[0] = Integer.valueOf(eic2.version);
        objArr[1] = this.url;
        objArr[2] = Integer.valueOf(cnL());
        objArr[3] = netWorkType;
        objArr[4] = Long.valueOf(this.pCi);
        objArr[5] = Integer.valueOf(this.pCh);
        objArr[6] = Long.valueOf(this.pBp);
        objArr[7] = Long.valueOf(this.pCp);
        objArr[8] = Boolean.valueOf(this.pBV);
        objArr[9] = Long.valueOf(this.pBE - this.pBD);
        objArr[10] = Boolean.valueOf(this.pBU);
        objArr[11] = Long.valueOf(this.pCm);
        objArr[12] = Long.valueOf(this.pCq);
        objArr[13] = Long.valueOf(this.pCo);
        objArr[14] = Long.valueOf(this.pBq);
        objArr[15] = Long.valueOf(this.pBp);
        eic eic3 = this.pBf;
        if (eic3 == null) {
            p.btv("tmplParams");
        }
        objArr[16] = Integer.valueOf(eic3.pCV);
        eic eic4 = this.pBf;
        if (eic4 == null) {
            p.btv("tmplParams");
        }
        objArr[17] = eic4.hFF;
        objArr[18] = this.pCs;
        objArr[19] = cnO();
        objArr[20] = Integer.valueOf(this.pmM);
        objArr[21] = Long.valueOf(this.pCn);
        objArr[22] = Boolean.valueOf(this.pCc);
        Log.d(str2, "templateVersion:%d, url:%s, size:%d, networkType:%s, pageFinishTime:%d, pageFinishTimeType:%d, ctWebFirstScreen:%d, a8KeyFinishTime:%d, isWebViewCreated:%b, ctTmplLoad:%d, isSyncGetPageData:%b, getPageDataCostTime:%d, getA8KeyCostTime:%d, webReceivePageDataTime:%d, ctWebCompile:%d, ctWebFirstScreen:%d, tmplType:%d tmplUid:%s webviewKind:%s webviewProcess:%s scene:%d evalPageDataCostTime:%d isWebViewProcessCreated:%b", objArr);
        if (!BuildInfo.IS_FLAVOR_RED) {
            boolean z3 = BuildInfo.DEBUG;
        }
        try {
            String str3 = this.url;
            if (str3 == null) {
                p.hyc();
            }
            str = com.tencent.mm.compatible.util.q.encode(str3, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e2) {
            Log.printErrStackTrace(this.TAG, e2, "url:%d", this.url);
            str = null;
        }
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
        int i12 = this.pBe;
        Object[] objArr2 = new Object[26];
        eic eic5 = this.pBf;
        if (eic5 == null) {
            p.btv("tmplParams");
        }
        objArr2[0] = Integer.valueOf(eic5.version);
        objArr2[1] = str;
        objArr2[2] = Integer.valueOf(cnL());
        objArr2[3] = netWorkType;
        objArr2[4] = Long.valueOf(BH(this.pCi));
        objArr2[5] = Integer.valueOf(this.pCh);
        objArr2[6] = Long.valueOf(BH(this.pBo));
        objArr2[7] = Long.valueOf(BH(this.pCp));
        if (this.pBV) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        objArr2[8] = Integer.valueOf(i2);
        objArr2[9] = Long.valueOf(BH(this.pBE - this.pBD));
        if (this.pBU) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        objArr2[10] = Integer.valueOf(i3);
        objArr2[11] = Long.valueOf(BH(this.pCm));
        objArr2[12] = Long.valueOf(BH(this.pCq));
        objArr2[13] = Long.valueOf(BH(this.pCo));
        objArr2[14] = Long.valueOf(BH(this.pBq));
        objArr2[15] = Long.valueOf(BH(this.pBp));
        eic eic6 = this.pBf;
        if (eic6 == null) {
            p.btv("tmplParams");
        }
        objArr2[16] = Integer.valueOf(eic6.pCV);
        eic eic7 = this.pBf;
        if (eic7 == null) {
            p.btv("tmplParams");
        }
        objArr2[17] = eic7.hFF;
        objArr2[18] = this.pCs;
        objArr2[19] = cnO();
        objArr2[20] = Integer.valueOf(this.pmM);
        objArr2[21] = Long.valueOf(BH(this.pCn));
        if (this.pCc) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        objArr2[22] = Integer.valueOf(i4);
        objArr2[23] = Long.valueOf(BH(this.pCj));
        objArr2[24] = Long.valueOf(BH(this.pCk));
        objArr2[25] = Long.valueOf(BH(this.pCl));
        hVar.a(i12, objArr2);
        com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.INSTANCE;
        ad adVar = new ad(19);
        adVar.add(str);
        adVar.add(Integer.valueOf(this.pmM));
        adVar.add(netWorkType);
        adVar.add(Integer.valueOf(cnL()));
        eic eic8 = this.pBf;
        if (eic8 == null) {
            p.btv("tmplParams");
        }
        adVar.add(eic8.hFF);
        adVar.add(cnO());
        adVar.add(this.pCs);
        if (this.pBU) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        adVar.add(Integer.valueOf(i5));
        if (!this.pCc) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            i6 = 1;
        } else {
            i6 = 0;
        }
        adVar.add(Integer.valueOf(i6));
        if (!this.pBV) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            i7 = 1;
        } else {
            i7 = 0;
        }
        adVar.add(Integer.valueOf(i7));
        adVar.add(Integer.valueOf(this.pCd));
        if (this.pBY) {
            i8 = 1;
        } else {
            i8 = 0;
        }
        adVar.add(Integer.valueOf(i8));
        if (this.pBW) {
            i9 = 1;
        } else {
            i9 = 0;
        }
        adVar.add(Integer.valueOf(i9));
        adVar.add(Long.valueOf(this.pCi));
        adVar.eS(cnP());
        adVar.add(this.key);
        if (this.kwO) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        adVar.add(Integer.valueOf(i10));
        if (this.pCa) {
            i11 = 1;
        } else {
            i11 = 0;
        }
        adVar.add(Integer.valueOf(i11));
        adVar.add(Long.valueOf(this.pBF));
        hVar2.a(16874, adVar.toArray(new Object[adVar.dtS.size()]));
        com.tencent.mm.plugin.webview.h.a.agi(0);
        if (this.kwO) {
            com.tencent.mm.plugin.webview.h.a.agi(111);
            eic eic9 = this.pBf;
            if (eic9 == null) {
                p.btv("tmplParams");
            }
            com.tencent.mm.plugin.webview.h.a.gH(eic9.reportId, 232);
        }
        if (this.pCa) {
            com.tencent.mm.plugin.webview.h.a.agi(113);
        }
        com.tencent.mm.plugin.webview.h.a.aP(1, this.pCi);
        com.tencent.mm.plugin.webview.h.a.aP(2, this.pBo);
        long j2 = this.pBy - this.pBm;
        if (this.pCc) {
            com.tencent.mm.plugin.webview.h.a.aP(10, this.pCi);
            com.tencent.mm.plugin.webview.h.a.aP(11, this.pBo);
            com.tencent.mm.plugin.webview.h.a.aP(12, j2);
            com.tencent.mm.plugin.webview.h.a.aP(13, this.pBH - this.pBG);
            com.tencent.mm.plugin.webview.h.a.aP(14, this.pBE - this.pBD);
            com.tencent.mm.plugin.webview.h.a.aP(15, this.pBB - this.pBA);
        } else {
            com.tencent.mm.plugin.webview.h.a.aP(20, this.pCi);
            com.tencent.mm.plugin.webview.h.a.aP(21, this.pBo);
            com.tencent.mm.plugin.webview.h.a.aP(22, j2);
            com.tencent.mm.plugin.webview.h.a.aP(23, this.pBH - this.pBG);
            if (!this.pBU) {
                com.tencent.mm.plugin.webview.h.a.aP(24, this.pBv - this.pBu);
                com.tencent.mm.plugin.webview.h.a.agi(107);
            }
        }
        String str4 = "[" + j.a(kotlin.a.e.U(cnP()), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 63) + ']';
        o[] oVarArr = new o[24];
        oVarArr[0] = s.U("section", "[debug]");
        oVarArr[1] = s.U("info", cnK());
        oVarArr[2] = s.U("settings", L(""));
        oVarArr[3] = s.U("section", "[process]");
        oVarArr[4] = s.U("process", cnO());
        oVarArr[5] = s.U("state", cnQ());
        oVarArr[6] = s.U("section", "[webview]");
        oVarArr[7] = s.U("kind", this.pCs);
        oVarArr[8] = s.U("state", cnR());
        oVarArr[9] = s.U("section", "[tmpl]");
        eic eic10 = this.pBf;
        if (eic10 == null) {
            p.btv("tmplParams");
        }
        oVarArr[10] = s.U("uid", eic10.hFF);
        eic eic11 = this.pBf;
        if (eic11 == null) {
            p.btv("tmplParams");
        }
        oVarArr[11] = s.U("tmplType", String.valueOf(eic11.pCV));
        eic eic12 = this.pBf;
        if (eic12 == null) {
            p.btv("tmplParams");
        }
        oVarArr[12] = s.U("version", String.valueOf(eic12.version));
        eic eic13 = this.pBf;
        if (eic13 == null) {
            p.btv("tmplParams");
        }
        oVarArr[13] = s.U("md5", eic13.md5);
        eic eic14 = this.pBf;
        if (eic14 == null) {
            p.btv("tmplParams");
        }
        oVarArr[14] = s.U("time", BI(eic14.DPz));
        oVarArr[15] = s.U("state", cnS());
        oVarArr[16] = s.U("section", "[data]");
        oVarArr[17] = s.U("dataSize", ba(((float) cnL()) / 1024.0f) + "Kb");
        oVarArr[18] = s.U("dataTime", String.valueOf(this.pCm));
        oVarArr[19] = s.U("cached", BI(cnM()));
        oVarArr[20] = s.U("version", String.valueOf(cnN()));
        oVarArr[21] = s.U("expire in", new StringBuilder().append(this.pBg).append('s').toString());
        oVarArr[22] = s.U("scene", String.valueOf(this.pmM));
        oVarArr[23] = s.U("state", cnT());
        List listOf = j.listOf((Object[]) oVarArr);
        if (listOf == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.collections.List<kotlin.Pair<kotlin.String, kotlin.String>>");
            AppMethodBeat.o(6608);
            throw tVar;
        }
        qVar.d("['FirstScreen', 'BindMP', 'WebView', 'WebViewUI', null, 'BindMM', 'JsAPI', 'GetA8Key', 'GetData', 'InjectData']", str4, listOf);
        Log.i(this.TAG, "terry performance report:" + this.pBm + '\n' + kotlin.a.e.a(cnP(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 63));
        AppMethodBeat.o(6608);
    }

    private final long BH(long j2) {
        AppMethodBeat.i(6609);
        long min = Math.min(Math.max(-this.pCx, j2), this.pCx);
        AppMethodBeat.o(6609);
        return min;
    }

    private final String L(CharSequence charSequence) {
        AppMethodBeat.i(6610);
        StringBuilder sb = new StringBuilder();
        j.a aVar = j.pCC;
        if (j.a.coa()) {
            sb.append(charSequence + "no re-direct;");
        }
        j.a aVar2 = j.pCC;
        if (!j.a.cnV()) {
            sb.append(charSequence + "no preload data;");
        }
        j.a aVar3 = j.pCC;
        if (j.a.cob()) {
            sb.append(charSequence + "no preload webview;");
        }
        j.a aVar4 = j.pCC;
        if (j.a.cnX()) {
            sb.append(charSequence + "data no expire;");
        }
        j.a aVar5 = j.pCC;
        if (j.a.coc()) {
            sb.append(charSequence + "no red;");
        }
        eic eic = this.pBf;
        if (eic == null) {
            p.btv("tmplParams");
        }
        String str = eic.Nhs;
        p.g(str, "tmplParams.headers");
        if (!n.aL(str)) {
            eic eic2 = this.pBf;
            if (eic2 == null) {
                p.btv("tmplParams");
            }
            sb.append(eic2.Nhs);
        }
        if (n.aL(sb)) {
            sb.append("none;");
        }
        String sb2 = sb.toString();
        p.g(sb2, "sb.toString()");
        AppMethodBeat.o(6610);
        return sb2;
    }

    private final String cnQ() {
        AppMethodBeat.i(6611);
        StringBuilder sb = new StringBuilder();
        if (this.pCd == 1) {
            sb.append("relanuch;");
        }
        if (!this.pCc) {
            sb.append("cold;");
        }
        if (n.aL(sb)) {
            sb.append("ok;");
        }
        String sb2 = sb.toString();
        p.g(sb2, "sb.toString()");
        AppMethodBeat.o(6611);
        return sb2;
    }

    private final String cnR() {
        AppMethodBeat.i(6612);
        StringBuilder sb = new StringBuilder();
        if (this.pCd == 2) {
            sb.append("relanuch;");
        }
        if (!this.pBV) {
            sb.append("cold;");
        }
        if (!this.pBX) {
            p.g(sb.append("tmpl fail;"), "sb.append(\"tmpl fail;\")");
        } else if (!this.pBW) {
            sb.append("inject fail;");
        }
        if (this.pCv) {
            p.g(sb.append("timeout;"), "sb.append(\"timeout;\")");
        } else if (this.pCu) {
            sb.append("h5;");
        }
        if (this.pCa) {
            sb.append("xweb_cc;");
        }
        if (n.aL(sb)) {
            sb.append("ok;");
        }
        String sb2 = sb.toString();
        p.g(sb2, "sb.toString()");
        AppMethodBeat.o(6612);
        return sb2;
    }

    private final String cnS() {
        AppMethodBeat.i(6613);
        StringBuilder sb = new StringBuilder();
        if (this.kwO) {
            sb.append("zip;");
        }
        if (this.pBZ) {
            sb.append("prefixMP;");
        }
        if (n.aL(sb)) {
            sb.append("none;");
        }
        String sb2 = sb.toString();
        p.g(sb2, "sb.toString()");
        AppMethodBeat.o(6613);
        return sb2;
    }

    private final String cnT() {
        AppMethodBeat.i(6614);
        StringBuilder sb = new StringBuilder();
        if (!this.pBU) {
            sb.append("async;");
        }
        if (this.pBY) {
            sb.append("mounted;");
        }
        if (this.pCb) {
            sb.append("cache_tmpl;");
        }
        if (n.aL(sb)) {
            sb.append("ok;");
        }
        String sb2 = sb.toString();
        p.g(sb2, "sb.toString()");
        AppMethodBeat.o(6614);
        return sb2;
    }

    private static String ba(float f2) {
        AppMethodBeat.i(6615);
        String format = String.format(new StringBuilder("%.2f").toString(), Float.valueOf(f2));
        p.g(format, "java.lang.String.format(\"%.${digits}f\", this)");
        AppMethodBeat.o(6615);
        return format;
    }

    private static String BI(long j2) {
        AppMethodBeat.i(6616);
        String format = new SimpleDateFormat("MM/dd HH:mm:ss").format(new Date(j2));
        p.g(format, "SimpleDateFormat(\"MM/dd …m:ss\").format(Date(this))");
        AppMethodBeat.o(6616);
        return format;
    }

    public final String toString() {
        AppMethodBeat.i(6617);
        g gVar = new g(this);
        Log.v(this.TAG, "terry performance log:\n" + this.pCj + ',' + this.pCk + ',' + (this.pBH - this.pBz) + ',' + (Math.max(this.pBH, this.pBE) - this.pBH) + ',' + (this.pBA - Math.max(this.pBH, this.pBE)) + ',' + this.pCl);
        Log.v(this.TAG, "terry performance timestamp:\n " + kotlin.a.e.a(cnP(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 63));
        StringBuilder append = new StringBuilder("\n            [debug]\n            info: ").append(cnK()).append("\n            settings: ").append(L("\n")).append("\n\n            [process]\n            process: ").append(cnO()).append("\n            state: ").append(cnQ()).append("\n\n            [webview]\n            kind: ").append(this.pCs).append("\n            state: ").append(cnR()).append("\n\n            [tmpl]\n            uid: ");
        eic eic = this.pBf;
        if (eic == null) {
            p.btv("tmplParams");
        }
        StringBuilder append2 = append.append(eic.hFF).append("\n            tmplType: ");
        eic eic2 = this.pBf;
        if (eic2 == null) {
            p.btv("tmplParams");
        }
        StringBuilder append3 = append2.append(eic2.pCV).append("\n            version: ");
        eic eic3 = this.pBf;
        if (eic3 == null) {
            p.btv("tmplParams");
        }
        StringBuilder append4 = append3.append(eic3.version).append("\n            md5: ");
        eic eic4 = this.pBf;
        if (eic4 == null) {
            p.btv("tmplParams");
        }
        StringBuilder append5 = append4.append(eic4.md5).append("\n            time: ");
        eic eic5 = this.pBf;
        if (eic5 == null) {
            p.btv("tmplParams");
        }
        String buv = n.buv(append5.append(BI(eic5.DPz)).append("\n            state: ").append(cnS()).append("\n\n            [data]\n            dataSize: ").append(ba(((float) cnL()) / 1024.0f)).append("Kb\n            dataTime: ").append(this.pCm).append("\n            cached: ").append(BI(cnM())).append("\n            version: ").append(cnN()).append("\n            expire in: ").append(this.pBg).append("s\n            scene: ").append(this.pmM).append("\n            state: ").append(cnT()).append("\n\n            [performance](ms)\n            finishType: ").append(this.pCh).append("\n            finishTime: ").append(this.pCi).append(this.pCi != Math.max(this.pCp, this.pCr) ? FilePathGenerator.ANDROID_DIR_SEP + gVar.BJ(this.pCr) : "").append("\n            firstScreenFinish: ").append(gVar.BJ(this.pBo)).append('/').append(gVar.BJ(this.pCr)).append("\n            a8keyFinish: ").append(this.pCp).append("\n\n            client:\n            TmplCostTime: ").append(this.pBE - this.pBD).append("\n            WebViewUICostTime: ").append(this.pBH - this.pBG).append("\n            NotifyPageCostTime: ").append(this.pBF - this.pBB).append("\n\n            1.bindWebViewCostTime: ").append(this.pCj).append("\n            2.createWebViewCostTime: ").append(this.pCk).append("\n            3.getPageDataCostTime: ").append(this.pCm).append("\n            4.injectCostTime: ").append(gVar.BJ(this.pCl)).append("\n            eval cost: ").append(this.pBl).append("\n\n            js:\n            4.1.onReceivePageData: ").append(this.pBC - this.pBr).append("\n            5.ctWebCompile: ").append(this.pBq).append("\n            6.renderTime: ").append(this.pBp).append("\n\n            [js]webReceivePageDataTime: ").append(this.pCo).append("\n            a8KeyFinishTime: ").append(this.pCp).append("\n            getA8KeyCostTime: ").append(this.pCq).append("\n        ").toString());
        AppMethodBeat.o(6617);
        return buv;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862$Companion;", "", "()V", "RELAUNCH_STATE_DEFAULT", "", "RELAUNCH_STATE_PROCESS", "RELAUNCH_STATE_WEBVIEW", "plugin-brandservice_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<String> {
        final /* synthetic */ i pCz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(i iVar) {
            super(0);
            this.pCz = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(6590);
            String aib = c.aib(this.pCz.url);
            AppMethodBeat.o(6590);
            return aib;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ i pCz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(i iVar) {
            super(0);
            this.pCz = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            int i2;
            AppMethodBeat.i(6593);
            String a2 = i.a(this.pCz);
            p.h(a2, "$this$getBuffSize");
            m mVar = m.pCU;
            com.tencent.mm.vfs.o b2 = c.b(m.coe(), a2);
            if (b2 != null) {
                i2 = (int) b2.length();
            } else {
                i2 = 0;
            }
            Integer valueOf = Integer.valueOf(i2);
            AppMethodBeat.o(6593);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<Long> {
        final /* synthetic */ i pCz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(i iVar) {
            super(0);
            this.pCz = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Long invoke() {
            AppMethodBeat.i(6591);
            m mVar = m.pCU;
            Long valueOf = Long.valueOf(m.aik(this.pCz.url));
            AppMethodBeat.o(6591);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ i pCz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(i iVar) {
            super(0);
            this.pCz = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            int i2;
            AppMethodBeat.i(6592);
            m mVar = m.pCU;
            fn ail = m.cof().ail(this.pCz.url);
            if (ail != null) {
                i2 = ail.KIU;
            } else {
                i2 = 0;
            }
            Integer valueOf = Integer.valueOf(i2);
            AppMethodBeat.o(6592);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class h extends q implements kotlin.g.a.a<String> {
        public static final h pCB = new h();

        static {
            AppMethodBeat.i(6600);
            AppMethodBeat.o(6600);
        }

        h() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(6599);
            if (MMApplicationContext.isMMProcess()) {
                AppMethodBeat.o(6599);
                return "mm";
            } else if (MMApplicationContext.isToolsProcess()) {
                AppMethodBeat.o(6599);
                return "tools";
            } else if (MMApplicationContext.isToolsMpProcess()) {
                AppMethodBeat.o(6599);
                return "toolsmp";
            } else {
                AppMethodBeat.o(6599);
                return "unknow";
            }
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "", "invoke", "()[Ljava/lang/Long;"})
    public static final class f extends q implements kotlin.g.a.a<Long[]> {
        final /* synthetic */ i pCz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(i iVar) {
            super(0);
            this.pCz = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Long[] invoke() {
            AppMethodBeat.i(6596);
            AnonymousClass1 r0 = new m<Long, Long, Long[]>(this) {
                /* class com.tencent.mm.plugin.brandservice.ui.timeline.preload.i.f.AnonymousClass1 */
                final /* synthetic */ f pCA;

                {
                    this.pCA = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // kotlin.g.a.m
                public final /* synthetic */ Long[] invoke(Long l, Long l2) {
                    AppMethodBeat.i(6594);
                    Long[] L = L(l.longValue(), l2.longValue());
                    AppMethodBeat.o(6594);
                    return L;
                }

                public final Long[] L(long j2, long j3) {
                    AppMethodBeat.i(6595);
                    Long[] a2 = i.a(new Long[]{Long.valueOf(j3 - j2), Long.valueOf(j3 - this.pCA.pCz.pBm)}, j2, j3);
                    AppMethodBeat.o(6595);
                    return a2;
                }
            };
            Log.v(this.pCz.TAG, "terry trace speedMatrix");
            if (this.pCz.pBm == -1) {
                this.pCz.pBm = this.pCz.pBy;
            }
            ad adVar = new ad(19);
            adVar.add(Long.valueOf(this.pCz.pBp));
            adVar.add(Long.valueOf(this.pCz.pBo));
            adVar.eS(i.a(new Long[]{Long.valueOf(this.pCz.pBy - this.pCz.pBm), Long.valueOf(this.pCz.pBy - this.pCz.pBm)}, this.pCz.pBy));
            adVar.eS(i.a(new Long[]{Long.valueOf(this.pCz.pBz - this.pCz.pBy), Long.valueOf(this.pCz.pBz - this.pCz.pBm)}, this.pCz.pBy, this.pCz.pBz));
            adVar.eS(i.a(new Long[]{Long.valueOf(this.pCz.pBH - this.pCz.pBG), Long.valueOf(this.pCz.pBH - this.pCz.pBm)}, this.pCz.pBG, this.pCz.pBH));
            adVar.eS(i.a(new Long[]{Long.valueOf(this.pCz.pBE - this.pCz.pBD), Long.valueOf(this.pCz.pBE - this.pCz.pBm)}, this.pCz.pBD, this.pCz.pBE));
            adVar.eS(i.a(new Long[]{Long.valueOf(this.pCz.pBJ - this.pCz.pBI), Long.valueOf(this.pCz.pBJ - this.pCz.pBm)}, this.pCz.pBJ, this.pCz.pBI));
            adVar.eS(i.a(new Long[]{Long.valueOf(this.pCz.pBK - this.pCz.pBJ), Long.valueOf(this.pCz.pBK - this.pCz.pBm)}, this.pCz.pBJ, this.pCz.pBK));
            adVar.eS(i.a(new Long[]{Long.valueOf(this.pCz.pBx - this.pCz.pBw), Long.valueOf(this.pCz.pBx - this.pCz.pBm)}, this.pCz.pBw, this.pCz.pBx));
            adVar.eS(i.a(new Long[]{Long.valueOf(this.pCz.pBv - this.pCz.pBu), Long.valueOf(this.pCz.pBv - this.pCz.pBm)}, this.pCz.pBu, this.pCz.pBv));
            adVar.eS(i.a(new Long[]{Long.valueOf(this.pCz.pBB - this.pCz.pBA), Long.valueOf(this.pCz.pBB - this.pCz.pBm)}, this.pCz.pBA, this.pCz.pBB));
            adVar.eS(r0.L(this.pCz.pBL, this.pCz.pBM));
            adVar.eS(r0.L(this.pCz.pBM, this.pCz.pBN));
            adVar.eS(r0.L(this.pCz.pBN, this.pCz.pBO));
            adVar.eS(r0.L(this.pCz.pBO, this.pCz.pBP));
            adVar.eS(r0.L(this.pCz.pBP, this.pCz.pBQ));
            adVar.eS(r0.L(this.pCz.pBQ, this.pCz.pBR));
            adVar.eS(r0.L(this.pCz.pBR, this.pCz.pBS));
            adVar.eS(r0.L(this.pCz.pBS, this.pCz.pBT));
            Long[] lArr = (Long[]) adVar.toArray(new Long[adVar.dtS.size()]);
            AppMethodBeat.o(6596);
            return lArr;
        }
    }

    public static final /* synthetic */ boolean a(i iVar, long j2) {
        AppMethodBeat.i(6619);
        if (iVar.BH(j2) == j2) {
            AppMethodBeat.o(6619);
            return true;
        }
        AppMethodBeat.o(6619);
        return false;
    }

    public static final /* synthetic */ Long[] a(Long[] lArr, long... jArr) {
        boolean z;
        int V;
        int i2 = 1;
        AppMethodBeat.i(6621);
        if (jArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Empty array can't be reduced.");
            AppMethodBeat.o(6621);
            throw unsupportedOperationException;
        }
        long j2 = jArr[0];
        p.h(jArr, "$this$lastIndex");
        int length = jArr.length - 1;
        if (length > 0) {
            while (true) {
                j2 *= jArr[i2];
                if (i2 == length) {
                    break;
                }
                i2++;
            }
        }
        if (j2 == 0 && (V = kotlin.a.e.V(lArr)) >= 0) {
            int i3 = 0;
            while (true) {
                lArr[i3] = -1L;
                if (i3 == V) {
                    break;
                }
                i3++;
            }
        }
        AppMethodBeat.o(6621);
        return lArr;
    }
}
