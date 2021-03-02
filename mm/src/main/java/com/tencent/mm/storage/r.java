package com.tencent.mm.storage;

import android.net.Uri;
import android.util.Base64;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.protocal.protobuf.ehk;
import com.tencent.mm.protocal.protobuf.ehl;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.t;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004\u0001\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010]\u001a\u00020^J\u0006\u0010_\u001a\u00020^J\u0014\u0010_\u001a\u00020^2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020b0aJ\u000e\u0010c\u001a\u00020^2\u0006\u0010d\u001a\u00020\u0004J\u0006\u0010e\u001a\u00020^J\u0012\u0010f\u001a\u0004\u0018\u00010g2\b\u0010h\u001a\u0004\u0018\u00010\u000eJ\b\u0010i\u001a\u00020\u0004H\u0002J\b\u0010j\u001a\u00020\tH\u0002J\n\u0010k\u001a\u0004\u0018\u00010bH\u0002J\b\u0010l\u001a\u00020\u0004H\u0002J\u0012\u0010m\u001a\u00020\t2\b\b\u0002\u0010n\u001a\u00020\tH\u0002J\b\u0010o\u001a\u00020\tH\u0002J\u000e\u0010p\u001a\u00020\u000e2\u0006\u0010d\u001a\u00020\u0004J\u0010\u0010q\u001a\u00020^2\b\u0010r\u001a\u0004\u0018\u00010sJ\u0010\u0010q\u001a\u00020^2\b\u0010r\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010t\u001a\u00020#J\u000e\u0010u\u001a\u00020#2\u0006\u0010v\u001a\u00020\u000eJ\u0012\u0010w\u001a\u00020#2\b\u0010x\u001a\u0004\u0018\u00010gH\u0002J\u0006\u0010y\u001a\u00020^J\u0006\u0010z\u001a\u00020^J\u0006\u0010{\u001a\u00020^J\u000e\u0010|\u001a\u00020^2\u0006\u0010x\u001a\u00020gJ\u0010\u0010}\u001a\u00020#2\b\u0010~\u001a\u0004\u0018\u00010J\u000f\u0010}\u001a\u00020#2\u0007\u0010\u0001\u001a\u00020bJ\t\u0010\u0001\u001a\u00020^H\u0002J\t\u0010\u0001\u001a\u00020^H\u0002J\u0012\u0010\u0001\u001a\u00020^2\t\u0010\u0001\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0001\u001a\u00020#2\u0007\u0010\u0001\u001a\u00020\u000eJ\t\u0010\u0001\u001a\u00020^H\u0002J\u0012\u0010\u0001\u001a\u00020^2\t\u0010\u0001\u001a\u0004\u0018\u00010\u000eJ\t\u0010\u0001\u001a\u00020^H\u0002J\u0012\u0010\u0001\u001a\u00020^2\u0007\u0010\u0001\u001a\u00020\u0004H\u0002J\r\u0010\u0001\u001a\u00020\u000e*\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R*\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\u0018j\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t`\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R#\u0010\u001b\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8BX\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010\"\u001a\u00020#8FX\u0002¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b$\u0010%R\u001b\u0010'\u001a\u00020#8FX\u0002¢\u0006\f\n\u0004\b)\u0010!\u001a\u0004\b(\u0010%R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000e0+X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u00101\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u001c\u00105\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u000e\u0010:\u001a\u00020;X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010<\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b?\u0010!\u001a\u0004\b=\u0010>R\u000e\u0010@\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R#\u0010A\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8BX\u0002¢\u0006\f\n\u0004\bC\u0010!\u001a\u0004\bB\u0010\u001fR\u0014\u0010D\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\bE\u00107R\u000e\u0010F\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010H\u001a\u00020#8FX\u0002¢\u0006\f\n\u0004\bJ\u0010!\u001a\u0004\bI\u0010%R\u001b\u0010K\u001a\u00020#8FX\u0002¢\u0006\f\n\u0004\bM\u0010!\u001a\u0004\bL\u0010%R\u001b\u0010N\u001a\u00020#8FX\u0002¢\u0006\f\n\u0004\bP\u0010!\u001a\u0004\bO\u0010%R\u001a\u0010Q\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010.\"\u0004\bS\u00100R\u001b\u0010T\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\bV\u0010!\u001a\u0004\bU\u0010>R\u001b\u0010W\u001a\u00020#8FX\u0002¢\u0006\f\n\u0004\bY\u0010!\u001a\u0004\bX\u0010%R\u001b\u0010Z\u001a\u00020#8FX\u0002¢\u0006\f\n\u0004\b\\\u0010!\u001a\u0004\b[\u0010%¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/storage/BizCardLogic;", "", "()V", "AD_COUNT_ONE_DAY", "", "AD_COUNT_ONE_DAY_MAX", "BIZ_AD_CARD_INSERT_POS", "CHECK_AD_INTERVAL", "DEFAULT_REFRESH_INTERVAL", "", "FROM_MAIN_CELL_EXPOSE", "FROM_MSG_RESORT", "FROM_TEST_PUSH", "KEY_BIZ_AD_CARD_DATA", "", "KEY_BIZ_AD_INSERT_POS", "KEY_BIZ_CANVAS_EXPOSE_PRELOAD_CANVAS_LAST_TIME", "KEY_BIZ_CANVAS_EXPOSE_PRELOAD_CRASH_TIMES", "KEY_BIZ_MAX_AD_COUNT", "KEY_BIZ_REFRESH_INTERVAL", "KEY_BIZ_REFRESH_LAST_TIME", "KEY_BIZ_ResortRefreshIntervalSec", "TAG", "aIdMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "adCardPrefix", "adMmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getAdMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "adMmkv$delegate", "Lkotlin/Lazy;", "adOpen", "", "getAdOpen", "()Z", "adOpen$delegate", "canvasPreloadOpen", "getCanvasPreloadOpen", "canvasPreloadOpen$delegate", "checkedAIdSet", "Ljava/util/HashSet;", "exposeRefreshInterval", "getExposeRefreshInterval", "()J", "setExposeRefreshInterval", "(J)V", "hasPreload", "hasSetCrashFlag", "insertPos", "isForeGround", "lastAId", "getLastAId", "()Ljava/lang/String;", "setLastAId", "(Ljava/lang/String;)V", "limiter", "Lcom/tencent/mm/modelbiz/MpDataLimiter;", "localInsertPos", "getLocalInsertPos", "()I", "localInsertPos$delegate", "maxAdCount", "mmkv", "getMmkv", "mmkv$delegate", "mockAdData", "getMockAdData", "mockPicAdData", "mockVideoAdData", "prefetchOpen", "getPrefetchOpen", "prefetchOpen$delegate", "recConflictOpen", "getRecConflictOpen", "recConflictOpen$delegate", "recOpen", "getRecOpen", "recOpen$delegate", "resortRefreshInterval", "getResortRefreshInterval", "setResortRefreshInterval", "testMode", "getTestMode", "testMode$delegate", "triggerDownLoadPkgOnGetAdData", "getTriggerDownLoadPkgOnGetAdData", "triggerDownLoadPkgOnGetAdData$delegate", "triggerDownLoadPkgOnGetRecData", "getTriggerDownLoadPkgOnGetRecData", "triggerDownLoadPkgOnGetRecData$delegate", "bizBoxClick", "", "checkAd", "list", "", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "doBizCardCgi", "from", "exposePreload", "getAdDataObject", "Lorg/json/JSONObject;", "content", "getAdInsertPos", "getExposeInterval", "getLastUnExposedAd", "getMaxAdCount", "getOrderFlag", "defOrderFlag", "getResortInterval", "getTimeLineContext", "handleExtInfo", IssueStorage.COLUMN_EXT_INFO, "Lcom/tencent/mm/protocal/protobuf/AdvertisementExtInfo;", "insertAd", "isAdChecked", "aid", "isAdDataValid", "adData", "onAppBackground", "onAppForeground", "onMainCellExpose", "preloadAdCard", "preloadCanvasCard", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "info", "preloadUnInsertAdCard", "preloadUnInsertRecCard", "replaceAdData", "data", "replaceTimelineAd", "canvasId", "resetClashFlag", "saveAdData", "updateExtInfo", "updateInterval", "interval", "toAccountKey", "BizCardFlag", "BusinessId", "plugin-biz_release"})
public final class r {
    public static int Kmn = -1;
    private static final HashMap<String, Long> NOR = new HashMap<>();
    private static final HashSet<String> NOS = new HashSet<>();
    public static int NOT = -1;
    private static String NOU;
    private static final kotlin.f NOV = kotlin.g.ah(a.NPm);
    private static final kotlin.f NOW = kotlin.g.ah(n.NPz);
    private static final kotlin.f NOX = kotlin.g.ah(g.NPt);
    private static final kotlin.f NOY = kotlin.g.ah(b.NPn);
    private static final kotlin.f NOZ = kotlin.g.ah(k.NPx);
    private static final kotlin.f NPa = kotlin.g.ah(i.NPv);
    static final kotlin.f NPb = kotlin.g.ah(j.NPw);
    private static final kotlin.f NPc = kotlin.g.ah(o.NPA);
    private static final kotlin.f NPd = kotlin.g.ah(p.NPB);
    private static final kotlin.f NPe = kotlin.g.ah(c.NPo);
    private static long NPf;
    static long NPg;
    private static boolean NPh;
    private static boolean NPi = true;
    private static final String NPj = "  {\n  \"hint_txt\": \"创意-20200601_1\",\n  \"url\": \"http://e.cn.miaozhen.com/r/k=2173285&amp;p=7b4m8&amp;dx=__IPDX__&amp;rt=2&amp;pro=n&amp;vo=3cd6923c2&amp;vr=2&amp;o=https%3A%2F%2Fbqry3dlmx.act.qq.com%3FADTAG%3Dtx.wx.gzh.zd?weixinadkey=95e085c866db2ca4da4529b48423634da3737d13156ab08310b6c0d6b29adcaa89dc88172fab7fc8425d0e54f740947d&amp;gdt_vid=wx0p67bjetlwkdc200&amp;weixinadinfo=274376350.wx0p67bjetlwkdc200.75.1\",\n  \"type\": \"0\",\n  \"rl\": \"http://ad.wx.com:12638/cgi-bin/click?viewid=AQPMC0arUNf0CQPrHyjodCs5VFZMaHjNnFIkvHBOD390htHT0XdnqPm0BDH9MUkAoYB%2FfRByH7h%2FQQi2qWqz0QLZOGLM9Bso6lF8R1lt9UCYZgp52mrjKw2WxcN%2BAFL7nHFUUXOaZ4lsRVO3FZjYO0%2FcEz6vF%2BrurDtkNMXYELovcpgunw%2FBFFISwd51aammEdF8uXZUIVQDcU%2Bl4AZrNH3G%2FkRLptgyTuymd1XF86N57Hq4y9khOWAT%2FzVRPJg15eC3LNIe9EHfwYgAtIF58hJBBCqHGzylaZMQapirs0fWlA3nxLme5jCz8j6jiiYEGQZw1e6cPp9tBPMSjH2tOSpLgB0MYLsS5lXHbtgV%2Fq0aGJNqIrxB98G%2Fne473LTxtcmfpnbuEzz83FKEQmJvWwCkZ1Hdv%2BoMU78VGyUBju93WiHEgMZslX3jiKJ2gcIU3ql40m1RkoPbNeIY27ctHly%2Bwbyqp%2BkoNpr9uzDcvSPMOSxSsQ8u8m5adNKGQFVbC3rwtQ3rBgzyJSlD5mv0NqV%2FdE7PO4IbwfwZFSU%2BXrp42k4oUep1Xib5IZqGsj%2Ba0LRMgXdfpm%2F%2FzLMFMoTphu7exUWbRhX2%2ByK7wyC4jJYyYKcemQXO%2BeisMP7ELuqyORfqbUJSOgbZtsgl4zsfHFYz0%2FL%2F1LWzYTatNL65zTiTPA8opxB5BiZOXKTvyRfIvmX%2FcsMo0hz%2BgHoVZMUx2cPjWvrT7krP0h6UOg6Jl3ZaqrKhO4XAoZoV98xJg5sxMwPLeMCbYRgP1ihh5Dyqg7Ia189VXDWfjS7tfwOvSmvz5G4YvMZuXaBMxa89vN1W1QL7DppNAwChouNha0ACfdgBuyY5m4v9TIS%2Bn2jQ%2FuJO9qruZp59v9TRAkY8JN%2BRvyskcN%2FRTJuBOAo05lvaae76EeKSACD9jbstYfhZxRtp07XFFYYmtqKq8YtYtGAe3oNVI9QxII9y4ovw6apcYkh4u5T3ujfV2%2B82BaggnGoQf2Ihv2xxkZhRc%2FUhKISbD2iWveqd0egVgjwJLG%2FpNeqe22cUN%2FUImB0OOSbqe3tuwHtC3nuqg%2Bh1wxLklJo8s3cCkGcOG57TwSStqQ%2Bh2jBiQhrqetkhHhxOc4SQQMmV81i%2FNyeXAZM0s9o1uKnoROakPTo5j7rhcf5cbN%2FZNULpmEYaVTp85cdwk9cc4wxedVD8GXrtBG1WWHzR1Cq6Dnh9aAAKl%2BLw3Db%2Fpw6azbll0AfxDm%2F2PuI3JoXMWwM%2B8rHpv52Wd2XJtSkU5TLWWKUt6cDlbdRnNORO3w6K44IdaK%2BFcvZdn3YdawazK%2BneFfyzJtRYX6yNRDGkJ9Iuvm7YTzinp0%2Fk33OezBSzGjIxKClA2%2FrfZWZncoMpjwALmoHNGqVnj%2F21DaRFnu3zysSi%2BCrP7vOnY3kv6I4saVqPNfD%2FW43hs4zjGyPLrE%2FNJ7gb6Zi9P9vxfA%3D%3D\",\n  \"apurl\": \"http://ad.wx.com:12638/cgi-bin/exposure?viewid=AQPMC0arUNf0CQPrHyjodCs5VFZMaHjNnFIkvHBOD390htHT0XdnqPm0BDH9MUkAoYB%2FfRByH7h%2FQQi2qWqz0QLZOGLM9Bso6lF8R1lt9UCYZgp52mrjKw2WxcN%2BAFL7nHFUUXOaZ4lsRVO3FZjYO0%2FcEz6vF%2BrurDtkNMXYELovcpgunw%2FBFFISwd51aammEdF8uXZUIVQDcU%2Bl4AZrNH3G%2FkRLptgyTuymd1XF86N57Hq4y9khOWAT%2FzVRPJg15eC3LNIe9EHfwYgAtIF58hJBBCqHGzylaZMQapirs0fWlA3nxLme5jCz8j6jiiYEGQZw1e6cPp9tBPMSjH2tOSpLgB0MYLsS5lXHbtgV%2Fq0aGJNqIrxB98G%2Fne473LTxtcmfpnbuEzz83FKEQmJvWwCkZ1Hdv%2BoMU78VGyUBju93WiHEgMZslX3jiKJ2gcIU3ql40m1RkoPbNeIY27ctHly%2Bwbyqp%2BkoNpr9uzDcvSPMOSxSsQ8u8m5adNKGQFVbC3rwtQ3rBgzyJSlD5mv0NqV%2FdE7PO4IbwfwZFSU%2BXrp42k4oUep1Xib5IZqGsj%2Ba0LRMgXdfpm%2F%2FzLMFMoTphu7exUWbRhX2%2ByK7wyC4jJYyYKcemQXO%2BeisMP7ELuqyORfqbUJSOgbZtsgl4zsfHFYz0%2FL%2F1LWzYTatNL65zTiTPA8opxB5BiZOXKTvyRfIvmX%2FcsMo0hz%2BgHoVZMUx2cPjWvrT7krP0h6UOg6Jl3ZaqrKhO4XAoZoV98xJg5sxMwPLeMCbYRgP1ihh5Dyqg7Ia189VXDWfjS7tfwOvSmvz5G4YvMZuXaBMxa89vN1W1QL7DppNAwChouNha0ACfdgBuyY5m4v9TIS%2Bn2jQ%2FuJO9qruZp59v9TRAkY8JN%2BRvyskcN%2FRTJuBOAo05lvaae76EeKSACD9jbstYfhZxRtp07XFFYYmtqKq8YtYtGAe3oNVI9QxII9y4ovw6apcYkh4u5T3ujfV2%2B82BaggnGoQf2Ihv2xxkZhRc%2FUhKISbD2iWveqd0egVgjwJLG%2FpNeqe22cUN%2FUImB0OOSbqe3tuwHtC3nuqg%2Bh1wxLklJo8s3cCkGcOG57TwSStqQ%2Bh2jBiQhrqetkhHhxOc4SQQMmV81i%2FNyeXAZM0s9o1uKnoROakPTo5j7rhcf5cbN%2FZNULpmEYaVTp85cdwk9cc4wxedVD8GXrtBG1WWHzR1Cq6Dnh9aAAKl%2BLw3Db%2Fpw6azbll0AfxDm%2F2PuI3JoXMWwM%2B8rHpv52Wd2XJtSkU5TLWWKUt6cDlbdRnNORO3w6K44IdaK%2BFcvZdn3YdawazK%2BneFfyzJtRYX6yNRDGkJ9Iuvm7YTzinp0%2Fk33OezBSzGjIxKClA2%2FrfZWZncoMpjwALmoHNGqVnj%2F21DaRFnu3zysSi%2BCrP7vOnY3kv6I4saVqPNfD%2FW43hs4zjGyPLrE%2FNJ7gb6Zi9P9vxfA%3D%3D\",\n  \"traceid\": \"wx0p67bjetlwkdc200\",\n  \"group_id\": \"wx0p67bjetlwkdc200_wx0p67bjetlwkdc201\",\n  \"ticket\": \"\",\n  \"aid\": \"274376350\",\n  \"pathType\": \"ad\",\n  \"pt\": 2,\n  \"image_url\": \"http://wxsnsdythumb.wxs.qq.com/109/20204/snsvideodownload?m=7a9c01200bcb2dba6a07c98abad6a89d&amp;filekey=30340201010420301e02016d0402534804107a9c01200bcb2dba6a07c98abad6a89d0203012194040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303630313135323431323030306366656330313336666664393337383639343530393030303030303664&amp;bizid=1023\",\n  \"ad_desc\": \"\",\n  \"biz_appid\": \"wx2c1dad7332964d7d\",\n  \"biz_info\": {\n    \"user_name\": \"gh_f60cb6e1bbe0\",\n    \"nick_name\": \"新加坡旅游局\",\n    \"head_img\": \"http://wx.qlogo.cn/mmhead/Q3auHgzwzM7ibCaN09GMnHSZNhcA9G36v9vhgIUy8OYX4PmcPwvg5Mw/0\",\n    \"biz_uin\": 3580351467,\n    \"signature\": \"心想狮城\"\n  },\n  \"pos_type\": 0,\n  \"watermark_type\": 0,\n  \"logo\": \"\",\n  \"is_cpm\": 0,\n  \"dest_type\": 1,\n  \"material_width\": 690,\n  \"material_height\": 388,\n  \"ad_width\": 0,\n  \"ad_height\": 0,\n  \"use_new_protocol\": 2,\n  \"product_type\": 29,\n  \"material_type\": 0,\n  \"crt_exp_tid\": 0,\n  \"crt_exp_info\": \"\",\n  \"flow_exp_info\": \"[{&quot;exp_para&quot;:[{&quot;name&quot;:94574,&quot;value&quot;:&quot;fz&quot;}]}]\",\n  \"watermark_text\": \"活动推广\",\n  \"crt_size\": \"998\",\n  \"button_action\": \"{&quot;button_text&quot;:&quot;查看详情&quot;,&quot;jump_type&quot;:1,&quot;jump_url&quot;:&quot;http:\\\\/\\\\/e.cn.miaozhen.com\\\\/r\\\\/k=2173285&amp;p=7b4m8&amp;dx=__IPDX__&amp;rt=2&amp;pro=n&amp;vo=3cd6923c2&amp;vr=2&amp;o=https%3A%2F%2Fbqry3dlmx.act.qq.com%3FADTAG%3Dtx.wx.gzh.zd?weixinadkey=6d7c64459169785a1510691ed6578b66d61408173f47c29e364658492046fbd0f7f55ad59c1e22f9fc7b42b8c5a84314&amp;gdt_vid=wx0p67bjetlwkdc200&amp;weixinadinfo=274376350.wx0p67bjetlwkdc200.75.1&quot;,&quot;text_type&quot;:0}\",\n  \"shop_image\": [],\n  \"material_id_list\": [],\n  \"uxinfo\": \"274376350|wx0p67bjetlwkdc200|255437066|0|1594265023|0|0|72058780271891663||AgKTRVlIlM5171j831mAsV9KhXn1D6AO9t0OzsoUSabfNucHFl9DpvWA4VsIAsTV6Sg=|274376355\",\n  \"ext_info\": \"\",\n  \"ad_token\": \"e3e33b5e35db528bb081c41893ca14b2807a454eab3949815e663c37a38de2d32a0fb17d38d299f730fd35928b7f5bbf\",\n  \"crt_info\": \"[{&quot;image_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20204/snsvideodownload?m=7a9c01200bcb2dba6a07c98abad6a89d&amp;filekey=30340201010420301e02016d0402534804107a9c01200bcb2dba6a07c98abad6a89d0203012194040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303630313135323431323030306366656330313336666664393337383639343530393030303030303664&amp;bizid=1023&quot;,&quot;thumb_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20204/snsvideodownload?m=7a9c01200bcb2dba6a07c98abad6a89d&amp;filekey=30340201010420301e02016d0402534804107a9c01200bcb2dba6a07c98abad6a89d0203012194040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303630313135323431323030306366656330313336666664393337383639343530393030303030303664&amp;bizid=1023&quot;,&quot;height&quot;:540,&quot;width&quot;:960,&quot;size&quot;:74132,&quot;image_md5&quot;:&quot;7a9c01200bcb2dba6a07c98abad6a89d&quot;,&quot;materialId&quot;:&quot;102225575&quot;,&quot;card_info&quot;:{&quot;head_desc_type&quot;:1,&quot;mp_tag_type&quot;:0}}]\",\n  \"reranking_ext_info\": \"{\\\"tid\\\":2303720433,\\\"material_hash\\\":\\\"CMzm1scGEOCTyMQC\\\"}\",\n  \"ext_back_comm\": \"{&quot;pctr&quot;:0.0100109996274}\"\n}";
    private static final String NPk = "  {\n  \"hint_txt\": \"创意-20200619_1\",\n  \"url\": \"pages/Home/StartVideo?type=1&amp;channel=Display&amp;utm_campaign=Bzero1Rock2020&amp;utm_medium=Elegantbanner&amp;page=SeriesPlp&amp;id=24&amp;utm_source=Tencent&amp;utm_content=Krisvideo&amp;weixinadkey=227428a14b944e52c301d99d7769b9d5e6ccd7aa55aac2ca8ca514b5e77a73e83b1579fffef623a5d0972810be5e4fb7&amp;gdt_vid=wx0zfmndr7d35pjq00&amp;weixinadinfo=278576846.wx0zfmndr7d35pjq00.75.1\",\n  \"type\": \"0\",\n  \"rl\": \"http://ad.wx.com:12638/cgi-bin/click?viewid=AQMLjhK9%2BxvCL%2BbfVMG9545FYYZcjMHqO%2FH7kAcJXbOfJ3pI2lso5azF56NZsMbO9EO%2FpZavBO%2BR8alH3Ye8B%2BEbTJKOh7mYbYABZqI2z6CcOwXWVy2AXqo4vfRMXWJ50wY6kr9agFKX5HRWT84ry9jk0CtTy2msHQwO%2FnHjote3vTlUIaPU%2ByRtqbmU6XAa6tyFG5s6deOZgFBa%2Fd73mN1ed4kEmpTHPpxwM6ZyQu2oHU1ihOJkwHdwxdIiU2OAsfeusHQow2ZpIt9jMkFsXRbbeeRfl8ix3mE8pJwvHfVTTV7xl9VIN1nneiShpC59VJB9gXMk1hsGJ0D3zBvijgsvsP9la6CtLH82OqzCqCsWol6fkmiF7HnCYy7s%2FTx6Xvl%2F4rYCRASZMb1ze1N4vzX3ZgTrNtbWAZ2nYNgkajUfv0mrRNTmzMOEaGQBuyG%2BWRscyP%2FmRnjn322UguHb6doAKhC6aEBEmNzjCqwvfIhUB5Ic2thetrxWZeSZu9J3qJJoApv%2FTtUqyovAprpO5bpYDU2Wey%2FRDyzMUyDrgmKeyoCVUVBdxsotWfmee9D2v2V%2BzsfZT8nRP4T463aq5b9bU%2Bh%2Bs7AS2ZN0O0Mnx3pQJQmyHvEmtqbskbm33SaVbQ4HF8ZQYSema%2BNIPr4q0EdkYtzZumXyO0nhO5n09cLLlIzGtg7UcL%2B5GKRFvc9iUzTvvLTtYnIP6Y3kSj2cCu4684DljuUda1BHKdYx5cVH1g3gwb8AlKr9I7ds9Y%2FHf%2BMlxf2122JrKcenN%2FVKvhmzKDMBOhr%2FBsxdqLfmJqkoiYR%2BWKtO%2FrMNFz46GJbblhtf0tLs5%2FRyehTM6wtrClHEzVKafG0z7V17TSntDNkeoNtlgIPD%2BNEo94frMIPXXL1meuAkigvIjV6v4KYuHHOO6iHw83Ba%2BaHVKrzoMA7zz8Svjl8t9lJISj9v1fL9hzHGUwAXIsT%2FG380XdaI%2FU2qFN05tJrc3xWt8jL7Zesqm4SOYTeT6OVWLdNWpOGEkjQYN1E6%2FKy1AnKvEJf7l2PqGC7XyQGJhw8B5PEsy7kzF5eozswE3QNXHORxprtJVB4180D5vSA0vmoRwofP7rooKffbYffkNmHV07hZ1Bvlem%2FvrHY6trqgZB7GL2RWL62E25UeRwIf8fxS45mZJTZyycR6AibgzmHSoDPvg6feSMhsSXaL%2B6NO3nkGk02d3iplelNGJBrCzp6F9RBPFvTTw6%2BMUsMbiQ%3D%3D\",\n  \"apurl\": \"http://ad.wx.com:12638/cgi-bin/exposure?viewid=AQMLjhK9%2BxvCL%2BbfVMG9545FYYZcjMHqO%2FH7kAcJXbOfJ3pI2lso5azF56NZsMbO9EO%2FpZavBO%2BR8alH3Ye8B%2BEbTJKOh7mYbYABZqI2z6CcOwXWVy2AXqo4vfRMXWJ50wY6kr9agFKX5HRWT84ry9jk0CtTy2msHQwO%2FnHjote3vTlUIaPU%2ByRtqbmU6XAa6tyFG5s6deOZgFBa%2Fd73mN1ed4kEmpTHPpxwM6ZyQu2oHU1ihOJkwHdwxdIiU2OAsfeusHQow2ZpIt9jMkFsXRbbeeRfl8ix3mE8pJwvHfVTTV7xl9VIN1nneiShpC59VJB9gXMk1hsGJ0D3zBvijgsvsP9la6CtLH82OqzCqCsWol6fkmiF7HnCYy7s%2FTx6Xvl%2F4rYCRASZMb1ze1N4vzX3ZgTrNtbWAZ2nYNgkajUfv0mrRNTmzMOEaGQBuyG%2BWRscyP%2FmRnjn322UguHb6doAKhC6aEBEmNzjCqwvfIhUB5Ic2thetrxWZeSZu9J3qJJoApv%2FTtUqyovAprpO5bpYDU2Wey%2FRDyzMUyDrgmKeyoCVUVBdxsotWfmee9D2v2V%2BzsfZT8nRP4T463aq5b9bU%2Bh%2Bs7AS2ZN0O0Mnx3pQJQmyHvEmtqbskbm33SaVbQ4HF8ZQYSema%2BNIPr4q0EdkYtzZumXyO0nhO5n09cLLlIzGtg7UcL%2B5GKRFvc9iUzTvvLTtYnIP6Y3kSj2cCu4684DljuUda1BHKdYx5cVH1g3gwb8AlKr9I7ds9Y%2FHf%2BMlxf2122JrKcenN%2FVKvhmzKDMBOhr%2FBsxdqLfmJqkoiYR%2BWKtO%2FrMNFz46GJbblhtf0tLs5%2FRyehTM6wtrClHEzVKafG0z7V17TSntDNkeoNtlgIPD%2BNEo94frMIPXXL1meuAkigvIjV6v4KYuHHOO6iHw83Ba%2BaHVKrzoMA7zz8Svjl8t9lJISj9v1fL9hzHGUwAXIsT%2FG380XdaI%2FU2qFN05tJrc3xWt8jL7Zesqm4SOYTeT6OVWLdNWpOGEkjQYN1E6%2FKy1AnKvEJf7l2PqGC7XyQGJhw8B5PEsy7kzF5eozswE3QNXHORxprtJVB4180D5vSA0vmoRwofP7rooKffbYffkNmHV07hZ1Bvlem%2FvrHY6trqgZB7GL2RWL62E25UeRwIf8fxS45mZJTZyycR6AibgzmHSoDPvg6feSMhsSXaL%2B6NO3nkGk02d3iplelNGJBrCzp6F9RBPFvTTw6%2BMUsMbiQ%3D%3D\",\n  \"traceid\": \"wx0zfmndr7d35pjq00\",\n  \"group_id\": \"wx0zfmndr7d35pjq00_wx0zfmndr7d35pjq01_wx0zfmndr7d35pjq02\",\n  \"ticket\": \"\",\n  \"aid\": \"278576846\",\n  \"pathType\": \"ad\",\n  \"pt\": 9,\n  \"image_url\": \"[{&quot;short_video&quot;:{&quot;materialId&quot;:104596342,&quot;thumb_height&quot;:540,&quot;thumb_md5&quot;:&quot;52975caa35b7191ece431504e8a20d6c&quot;,&quot;thumb_size&quot;:40225,&quot;thumb_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20250/snsvideodownload?m=52975caa35b7191ece431504e8a20d6c&amp;filekey=30340201010420301e02016d04025348041052975caa35b7191ece431504e8a20d6c0203009d21040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303339326237313336666664393361303761343530393030303030303664&amp;bizid=1023&quot;,&quot;thumb_width&quot;:960,&quot;video_duration&quot;:15,&quot;video_duration_ms&quot;:15070,&quot;video_info&quot;:{&quot;AudioCodec&quot;:&quot;AAC&quot;,&quot;AudioProfile&quot;:&quot;LC&quot;,&quot;AudioSampleRate&quot;:44100,&quot;BitRate&quot;:1231820,&quot;Duration&quot;:15070,&quot;FileSize&quot;:2508599,&quot;Format&quot;:&quot;MOV,MP4,M4A,3GP,3G2,MJ2&quot;,&quot;Height&quot;:540,&quot;Profile&quot;:&quot;HIGH&quot;,&quot;VideoCodec&quot;:&quot;H264&quot;,&quot;Width&quot;:960,&quot;channels&quot;:2,&quot;scan_type&quot;:&quot;Progressive&quot;},&quot;video_md5&quot;:&quot;f77f07f637eabebaedc7b74e874d00ff&quot;,&quot;video_size&quot;:2508599,&quot;video_url&quot;:&quot;http://wxsnsdy.wxs.qq.com/105/20210/snsdyvideodownload?m=f77f07f637eabebaedc7b74e874d00ff&amp;filekey=30340201010420301e020169040253480410f77f07f637eabebaedc7b74e874d00ff0203264737040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303433636235313336666664393361303761343530393030303030303639&amp;bizid=1023&quot;,&quot;raw_thumb_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20250/snsvideodownload?m=52975caa35b7191ece431504e8a20d6c&amp;filekey=30340201010420301e02016d04025348041052975caa35b7191ece431504e8a20d6c0203009d21040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303339326237313336666664393361303761343530393030303030303664&amp;bizid=1023&quot;}}]\",\n  \"ad_desc\": \"\",\n  \"biz_appid\": \"wx032b61d035e02538\",\n  \"biz_info\": {\n    \"user_name\": \"gh_c5a5a55e74a5\",\n    \"nick_name\": \"BVLGARI宝格丽\",\n    \"head_img\": \"http://wx.qlogo.cn/mmhead/Q3auHgzwzM5hgUXh7XsHRGLHRribgcXlRGXKB4phZorcicBGVeDWCYQQ/0\",\n    \"biz_uin\": 3074666211,\n    \"signature\": \"于1884年在罗马建立的高端珠宝品牌BVLGARI宝格丽，始终代表着精美奢华的意大利风格。\"\n  },\n  \"pos_type\": 0,\n  \"watermark_type\": 0,\n  \"logo\": \"\",\n  \"is_cpm\": 1,\n  \"video_info\": {\n    \"displayWidth\": 960,\n    \"displayHeight\": 540,\n    \"thumbUrl\": \"http://wxsnsdythumb.wxs.qq.com/109/20250/snsvideodownload?m=52975caa35b7191ece431504e8a20d6c&amp;filekey=30340201010420301e02016d04025348041052975caa35b7191ece431504e8a20d6c0203009d21040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303339326237313336666664393361303761343530393030303030303664&amp;bizid=1023\",\n    \"videoUrl\": \"http://wxsnsdy.wxs.qq.com/105/20210/snsdyvideodownload?m=f77f07f637eabebaedc7b74e874d00ff&amp;filekey=30340201010420301e020169040253480410f77f07f637eabebaedc7b74e874d00ff0203264737040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303433636235313336666664393361303761343530393030303030303639&amp;bizid=1023\"\n  },\n  \"weapp_info\": {\n    \"original_id\": \"gh_e70774015690\",\n    \"appid\": \"wx56b4770737a7dddf\",\n    \"nick_name\": \"BVLGARI宝格丽精品店\",\n    \"head_img\": \"http://wx.qlogo.cn/mmhead/Q3auHgzwzM5pN0eR1LRZJzPxALx3mRPYSmiaPbibPE5fQKS8xTy6ichbQ/0\"\n  },\n  \"dest_type\": 6,\n  \"material_width\": 690,\n  \"material_height\": 388,\n  \"ad_width\": 0,\n  \"ad_height\": 0,\n  \"use_new_protocol\": 2,\n  \"product_type\": 29,\n  \"material_type\": 0,\n  \"crt_exp_tid\": 0,\n  \"crt_exp_info\": \"\",\n  \"flow_exp_info\": \"[{&quot;exp_para&quot;:[{&quot;name&quot;:94574,&quot;value&quot;:&quot;fz&quot;}]}]\",\n  \"watermark_text\": \"活动推广\",\n  \"crt_size\": \"538\",\n  \"button_action\": \"{&quot;button_text&quot;:&quot;查看详情&quot;,&quot;jump_type&quot;:6,&quot;jump_url&quot;:&quot;pages\\\\/Home\\\\/StartVideo?type=1&amp;channel=Display&amp;utm_campaign=Bzero1Rock2020&amp;utm_medium=Elegantbanner&amp;page=SeriesPlp&amp;id=24&amp;utm_source=Tencent&amp;utm_content=Krisvideo&amp;weixinadkey=5418655bc3dd454e4ed84dad6962668068661cb2009130ec86f3626ef4700e9b7a06ee64eb5d93f14e87b54ce39699c9&amp;gdt_vid=wx0zfmndr7d35pjq00&amp;weixinadinfo=278576846.wx0zfmndr7d35pjq00.75.1&quot;,&quot;text_type&quot;:0}\",\n  \"shop_image\": [],\n  \"material_id_list\": [],\n  \"uxinfo\": \"278576846|wx0zfmndr7d35pjq00||0|1594264005|0|0|72058780271891663||AgKNIqBiWhQxioBrueuTRKG/ZDGPF4ER7Im3GhiUj6HO7oRLhI/wSZTh3mxc7jqPZug=|278576919\",\n  \"ext_info\": \"{&quot;wx_app_type&quot;:2,&quot;gh_id&quot;:&quot;gh_e70774015690&quot;}\",\n  \"ad_token\": \"e3e33b5e35db528bb081c41893ca14b2807a454eab3949815e663c37a38de2d3779f0258b01c0503fbde6feda83a487b\",\n  \"crt_info\": \"[{&quot;short_video&quot;:{&quot;materialId&quot;:104596342,&quot;thumb_height&quot;:540,&quot;thumb_md5&quot;:&quot;52975caa35b7191ece431504e8a20d6c&quot;,&quot;thumb_size&quot;:40225,&quot;thumb_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20250/snsvideodownload?m=52975caa35b7191ece431504e8a20d6c&amp;filekey=30340201010420301e02016d04025348041052975caa35b7191ece431504e8a20d6c0203009d21040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303339326237313336666664393361303761343530393030303030303664&amp;bizid=1023&quot;,&quot;thumb_width&quot;:960,&quot;video_duration&quot;:15,&quot;video_duration_ms&quot;:15070,&quot;video_info&quot;:{&quot;AudioCodec&quot;:&quot;AAC&quot;,&quot;AudioProfile&quot;:&quot;LC&quot;,&quot;AudioSampleRate&quot;:44100,&quot;BitRate&quot;:1231820,&quot;Duration&quot;:15070,&quot;FileSize&quot;:2508599,&quot;Format&quot;:&quot;MOV,MP4,M4A,3GP,3G2,MJ2&quot;,&quot;Height&quot;:540,&quot;Profile&quot;:&quot;HIGH&quot;,&quot;VideoCodec&quot;:&quot;H264&quot;,&quot;Width&quot;:960,&quot;channels&quot;:2,&quot;scan_type&quot;:&quot;Progressive&quot;},&quot;video_md5&quot;:&quot;f77f07f637eabebaedc7b74e874d00ff&quot;,&quot;video_size&quot;:2508599,&quot;video_url&quot;:&quot;http://wxsnsdy.wxs.qq.com/105/20210/snsdyvideodownload?m=f77f07f637eabebaedc7b74e874d00ff&amp;filekey=30340201010420301e020169040253480410f77f07f637eabebaedc7b74e874d00ff0203264737040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303433636235313336666664393361303761343530393030303030303639&amp;bizid=1023&quot;,&quot;raw_thumb_url&quot;:&quot;http://wxsnsdythumb.wxs.qq.com/109/20250/snsvideodownload?m=52975caa35b7191ece431504e8a20d6c&amp;filekey=30340201010420301e02016d04025348041052975caa35b7191ece431504e8a20d6c0203009d21040d00000004627466730000000131&amp;hy=SH&amp;storeid=32303230303730313133343934343030303339326237313336666664393361303761343530393030303030303664&amp;bizid=1023&quot;}}]\",\n  \"reranking_ext_info\": \"{tid:278576919}\",\n  \"ext_back_comm\": \"{&quot;pctr&quot;:0.0134623190388}\"\n}";
    public static final r NPl = new r();
    private static final kotlin.f iBW = kotlin.g.ah(h.NPu);
    private static final com.tencent.mm.al.r pnt = new com.tencent.mm.al.r(600000);
    static boolean uft;

    private static MultiProcessMMKV aTI() {
        AppMethodBeat.i(212511);
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) iBW.getValue();
        AppMethodBeat.o(212511);
        return multiProcessMMKV;
    }

    static MultiProcessMMKV gzI() {
        AppMethodBeat.i(212512);
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) NOV.getValue();
        AppMethodBeat.o(212512);
        return multiProcessMMKV;
    }

    public static int gzJ() {
        AppMethodBeat.i(212513);
        int intValue = ((Number) NOW.getValue()).intValue();
        AppMethodBeat.o(212513);
        return intValue;
    }

    private static int gzK() {
        AppMethodBeat.i(212514);
        int intValue = ((Number) NOX.getValue()).intValue();
        AppMethodBeat.o(212514);
        return intValue;
    }

    public static boolean gzL() {
        AppMethodBeat.i(212515);
        boolean booleanValue = ((Boolean) NOY.getValue()).booleanValue();
        AppMethodBeat.o(212515);
        return booleanValue;
    }

    public static boolean gzM() {
        AppMethodBeat.i(212516);
        boolean booleanValue = ((Boolean) NOZ.getValue()).booleanValue();
        AppMethodBeat.o(212516);
        return booleanValue;
    }

    public static boolean gzN() {
        AppMethodBeat.i(212517);
        boolean booleanValue = ((Boolean) NPa.getValue()).booleanValue();
        AppMethodBeat.o(212517);
        return booleanValue;
    }

    private static boolean gzO() {
        AppMethodBeat.i(212518);
        boolean booleanValue = ((Boolean) NPc.getValue()).booleanValue();
        AppMethodBeat.o(212518);
        return booleanValue;
    }

    public static boolean gzP() {
        AppMethodBeat.i(212519);
        boolean booleanValue = ((Boolean) NPd.getValue()).booleanValue();
        AppMethodBeat.o(212519);
        return booleanValue;
    }

    public static boolean gzQ() {
        AppMethodBeat.i(212520);
        boolean booleanValue = ((Boolean) NPe.getValue()).booleanValue();
        AppMethodBeat.o(212520);
        return booleanValue;
    }

    static {
        AppMethodBeat.i(212542);
        AppMethodBeat.o(212542);
    }

    private r() {
    }

    public static final /* synthetic */ String biL(String str) {
        AppMethodBeat.i(212549);
        String biG = biG(str);
        AppMethodBeat.o(212549);
        return biG;
    }

    public static final /* synthetic */ void gAa() {
        AppMethodBeat.i(212546);
        gzW();
        AppMethodBeat.o(212546);
    }

    public static final /* synthetic */ z gAd() {
        AppMethodBeat.i(212547);
        z gzX = gzX();
        AppMethodBeat.o(212547);
        return gzX;
    }

    public static final /* synthetic */ MultiProcessMMKV gAe() {
        AppMethodBeat.i(212548);
        MultiProcessMMKV gzI = gzI();
        AppMethodBeat.o(212548);
        return gzI;
    }

    public static final /* synthetic */ MultiProcessMMKV gAf() {
        AppMethodBeat.i(212550);
        MultiProcessMMKV aTI = aTI();
        AppMethodBeat.o(212550);
        return aTI;
    }

    static String biG(String str) {
        AppMethodBeat.i(212510);
        StringBuilder append = new StringBuilder().append(str).append('-');
        kotlin.g.b.p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
        String sb = append.append(com.tencent.mm.kernel.a.ayV()).toString();
        AppMethodBeat.o(212510);
        return sb;
    }

    public static String gzG() {
        return NOU;
    }

    public static void gzH() {
        NOU = null;
    }

    public final void ajP(int i2) {
        AppMethodBeat.i(212521);
        if (!gzL()) {
            AppMethodBeat.o(212521);
        } else if (gzJ() == 1) {
            biH(gzY());
            gzI().encode("biz_card_last_time", System.currentTimeMillis());
            AppMethodBeat.o(212521);
        } else if (gzN()) {
            Log.i("MicroMsg.BizCardLogic", "doBizCardCgi testMode=" + gzJ() + " from=" + i2);
            ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).P("wxa06c02b5c00ff39b", 2 == i2 ? "mainCellExpose" : "resortEnd", "from:".concat(String.valueOf(i2)));
            AppMethodBeat.o(212521);
        } else {
            long j2 = gzI().getLong("biz_card_last_time", 0);
            long currentTimeMillis = System.currentTimeMillis();
            long abs = Math.abs(currentTimeMillis - j2);
            long gzT = i2 == 1 ? gzT() : gzS();
            if (3 == i2 || ((gzJ() > 0 || abs >= gzT) && (gzJ() <= 0 || abs >= 10000))) {
                gzI().encode("biz_card_last_time", System.currentTimeMillis());
                d.a aVar = new d.a();
                aVar.c(new ehk());
                aVar.d(new ehl());
                aVar.MB("/cgi-bin/mmbiz-bin/recommend/timelinecard");
                aVar.sG(2781);
                com.tencent.mm.ak.d aXF = aVar.aXF();
                kotlin.g.b.p.g(aXF, "rr");
                com.tencent.mm.bw.a aYJ = aXF.aYJ();
                if (aYJ == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.TimeLineCardReq");
                    AppMethodBeat.o(212521);
                    throw tVar;
                }
                ehk ehk = (ehk) aYJ;
                ehk.KWz = System.currentTimeMillis();
                ehk.KWE = 1;
                ehk.KUk = "";
                ehk.KWF = ajQ(i2);
                Log.i("MicroMsg.BizCardLogic", "doBizCardCgi testMode=" + gzJ() + " from=" + i2 + " interval=" + gzT + " lastTime=" + j2 + " currentMills=" + currentTimeMillis);
                com.tencent.mm.plugin.webcanvas.l lVar = com.tencent.mm.plugin.webcanvas.l.IAx;
                com.tencent.mm.plugin.webcanvas.l.LV(0);
                aa.a(aXF, e.NPq);
                AppMethodBeat.o(212521);
                return;
            }
            Log.d("MicroMsg.BizCardLogic", "doBizCardCgi delta < interval, return from=".concat(String.valueOf(i2)));
            AppMethodBeat.o(212521);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\b2\u000e\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    public static final class e implements aa.a {
        public static final e NPq = new e();

        static {
            AppMethodBeat.i(212487);
            AppMethodBeat.o(212487);
        }

        e() {
        }

        @Override // com.tencent.mm.ak.aa.a
        public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, q qVar) {
            int optInt;
            Integer num = null;
            AppMethodBeat.i(212486);
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.plugin.webcanvas.l lVar = com.tencent.mm.plugin.webcanvas.l.IAx;
                com.tencent.mm.plugin.webcanvas.l.LV(2);
                kotlin.g.b.p.g(dVar, "rr");
                com.tencent.mm.bw.a aYK = dVar.aYK();
                if (!(aYK instanceof ehl)) {
                    aYK = null;
                }
                ehl ehl = (ehl) aYK;
                if (ehl == null) {
                    AppMethodBeat.o(212486);
                } else {
                    Log.d("MicroMsg.BizCardLogic", "doBizCardCgi callback " + (ehl != null ? ehl.KWF : null));
                    StringBuilder append = new StringBuilder("doBizCardCgi callback errType=").append(i2).append(", errCode=").append(i3).append(" interval=");
                    if (ehl != null) {
                        num = Integer.valueOf(ehl.KSO);
                    }
                    Log.i("MicroMsg.BizCardLogic", append.append(num.intValue()).toString());
                    r rVar = r.NPl;
                    r.ajR(ehl.KSO);
                    r rVar2 = r.NPl;
                    String str2 = ehl.xNU;
                    if (str2 != null) {
                        try {
                            Log.i("MicroMsg.BizCardLogic", "handleExtInfo extInfo ".concat(String.valueOf(str2)));
                            JSONObject jSONObject = new JSONObject(str2);
                            if (jSONObject.has("ResortRefreshIntervalSec") && (optInt = jSONObject.optInt("ResortRefreshIntervalSec", 0)) > 0 && optInt <= 259200) {
                                r.NPg = ((long) optInt) * 1000;
                                r.gzI().encode("biz_card_resort_Refresh_IntervalSec", r.NPg);
                            }
                            r.NOT = jSONObject.optInt("MaxAdCount", 1);
                            r.Kmn = jSONObject.optInt("AdInsertPos", 3);
                            r.gzR();
                        } catch (Exception e2) {
                            Log.e("MicroMsg.BizCardLogic", "handleExtInfo ex " + e2.getMessage());
                        }
                    }
                    if ((ehl.KHa & 1) == 0) {
                        r.NPl.biH(ehl.KWF);
                        com.tencent.mm.plugin.webcanvas.l lVar2 = com.tencent.mm.plugin.webcanvas.l.IAx;
                        com.tencent.mm.plugin.webcanvas.l.LV(6);
                    } else {
                        com.tencent.mm.plugin.webcanvas.l lVar3 = com.tencent.mm.plugin.webcanvas.l.IAx;
                        com.tencent.mm.plugin.webcanvas.l.LV(5);
                    }
                    AppMethodBeat.o(212486);
                }
            } else {
                Log.e("MicroMsg.BizCardLogic", "doBizCardCgi callback errType=" + i2 + ", errCode=" + i3);
                com.tencent.mm.plugin.webcanvas.l lVar4 = com.tencent.mm.plugin.webcanvas.l.IAx;
                com.tencent.mm.plugin.webcanvas.l.LV(1);
                if (i3 == 1004) {
                    com.tencent.mm.plugin.webcanvas.l lVar5 = com.tencent.mm.plugin.webcanvas.l.IAx;
                    com.tencent.mm.plugin.webcanvas.l.LV(7);
                }
                AppMethodBeat.o(212486);
            }
            return 0;
        }
    }

    public static String ajQ(int i2) {
        LinkedList linkedList;
        AppMethodBeat.i(212522);
        List<z> ajT = ag.ban().ajT(5);
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            kotlin.g.b.p.g(ajT, LocaleUtil.ITALIAN);
            int i3 = 0;
            for (T t : ajT) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    kotlin.a.j.hxH();
                }
                T t2 = t;
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(FirebaseAnalytics.b.INDEX, i3);
                kotlin.g.b.p.g(t2, "msg");
                if (t2.gAt()) {
                    jSONObject2.put("is_recommand", false);
                    JSONArray jSONArray2 = new JSONArray();
                    com.tencent.mm.plugin.biz.a.a aVar = (com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class);
                    u a2 = aVar != null ? aVar.a(((z) t2).field_msgId, ((z) t2).field_content) : null;
                    if (!(a2 == null || (linkedList = a2.iAd) == null)) {
                        int i5 = 0;
                        for (Object obj : linkedList) {
                            int i6 = i5 + 1;
                            if (i5 < 0) {
                                kotlin.a.j.hxH();
                            }
                            v vVar = (v) obj;
                            JSONObject jSONObject3 = new JSONObject();
                            if (!Util.isNullOrNil(vVar.url)) {
                                Uri parse = Uri.parse(vVar.url);
                                int i7 = Util.getInt(parse.getQueryParameter("idx"), 0);
                                long j2 = Util.getLong(parse.getQueryParameter("mid"), 0);
                                byte[] decode = Base64.decode(parse.getQueryParameter("__biz"), 2);
                                kotlin.g.b.p.g(decode, "Base64.decode(uri.getQue…\"__biz\"), Base64.NO_WRAP)");
                                jSONObject3.put("bizuin", Util.getLong(new String(decode, kotlin.n.d.UTF_8), 0));
                                jSONObject3.put("mid", j2);
                                jSONObject3.put("idx", i7);
                                jSONObject3.put("title", vVar.title);
                            }
                            jSONObject3.put(FirebaseAnalytics.b.INDEX, i5);
                            jSONObject3.put("msg_time", vVar.time);
                            jSONObject3.put("is_fold", i5 >= 2 && !((z) t2).field_isExpand);
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("type", ((z) t2).field_isRead == 1 ? 1 : 0);
                            x xVar = x.SXb;
                            jSONObject3.put("user_action", jSONObject4);
                            x xVar2 = x.SXb;
                            jSONArray2.put(jSONObject3);
                            i5 = i6;
                        }
                        x xVar3 = x.SXb;
                    }
                    x xVar4 = x.SXb;
                    jSONObject2.put("msg", jSONArray2);
                } else if (t2.gAu()) {
                    jSONObject2.put("is_recommend", true);
                    ege gAD = t2.gAD();
                    jSONObject2.put(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, gAD != null ? gAD.style : 0);
                    if (gAD == null || gAD.style != 1001) {
                        JSONArray jSONArray3 = new JSONArray();
                        int i8 = 0;
                        for (T t3 : af.F(t2)) {
                            int i9 = i8 + 1;
                            if (i8 < 0) {
                                kotlin.a.j.hxH();
                            }
                            T t4 = t3;
                            JSONObject jSONObject5 = new JSONObject();
                            if (!Util.isNullOrNil(t4.KSj)) {
                                Uri parse2 = Uri.parse(t4.KSj);
                                int i10 = Util.getInt(parse2.getQueryParameter("idx"), 0);
                                long j3 = Util.getLong(parse2.getQueryParameter("mid"), 0);
                                byte[] decode2 = Base64.decode(parse2.getQueryParameter("__biz"), 2);
                                kotlin.g.b.p.g(decode2, "Base64.decode(uri.getQue…\"__biz\"), Base64.NO_WRAP)");
                                jSONObject5.put("bizuin", Util.getLong(new String(decode2, kotlin.n.d.UTF_8), 0));
                                jSONObject5.put("mid", j3);
                                jSONObject5.put("idx", i10);
                                jSONObject5.put("title", t4.Title);
                            }
                            jSONObject5.put(FirebaseAnalytics.b.INDEX, i8);
                            jSONObject5.put("msg_time", ((z) t2).field_createTime);
                            jSONObject5.put("is_fold", false);
                            JSONObject jSONObject6 = new JSONObject();
                            jSONObject6.put("type", ((z) t2).field_isRead == 1 ? 1 : 0);
                            x xVar5 = x.SXb;
                            jSONObject5.put("user_action", jSONObject6);
                            x xVar6 = x.SXb;
                            jSONArray3.put(jSONObject5);
                            i8 = i9;
                        }
                        x xVar7 = x.SXb;
                        x xVar8 = x.SXb;
                        jSONObject2.put("msg", jSONArray3);
                    } else {
                        JSONObject jSONObject7 = new JSONObject();
                        jSONObject7.put("extra_data", gAD.dSJ);
                        jSONObject7.put("msg_time", ((z) t2).field_createTime);
                        JSONObject jSONObject8 = new JSONObject();
                        jSONObject8.put("type", ((z) t2).field_isRead == 1 ? 1 : 0);
                        x xVar9 = x.SXb;
                        jSONObject7.put("user_action", jSONObject8);
                        x xVar10 = x.SXb;
                        jSONObject2.put("ext_info", jSONObject7);
                    }
                }
                jSONArray.put(jSONObject2);
                i3 = i4;
            }
            jSONObject.put("timeline_context", jSONArray);
            jSONObject.put("timeline_request_type", i2);
            jSONObject.put("last_expose_time", gzI().decodeLong("BizLastExposeAdTime", 0));
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BizCardLogic", e2, "getTimeLineContext", new Object[0]);
        }
        String jSONObject9 = jSONObject.toString();
        kotlin.g.b.p.g(jSONObject9, "timelineContext.toString()");
        kotlin.g.b.p.g(jSONObject9, "SubCoreBiz.getBizTimeLin…text.toString()\n        }");
        AppMethodBeat.o(212522);
        return jSONObject9;
    }

    public final void biH(String str) {
        AppMethodBeat.i(212523);
        if (!com.tencent.mm.kernel.g.aAc()) {
            Log.i("MicroMsg.BizCardLogic", "saveAdData acc not ready");
        }
        String str2 = str;
        if (str2 == null || kotlin.n.n.aL(str2)) {
            Log.i("MicroMsg.BizCardLogic", "saveAdData data is null");
            com.tencent.mm.plugin.webcanvas.l lVar = com.tencent.mm.plugin.webcanvas.l.IAx;
            com.tencent.mm.plugin.webcanvas.l.LV(3);
            AppMethodBeat.o(212523);
            return;
        }
        com.tencent.mm.plugin.webcanvas.l lVar2 = com.tencent.mm.plugin.webcanvas.l.IAx;
        com.tencent.mm.plugin.webcanvas.l.LV(4);
        JSONObject biI = biI(str);
        if (biI == null) {
            Log.i("MicroMsg.BizCardLogic", "saveAdData adData is null");
            com.tencent.mm.plugin.webcanvas.l lVar3 = com.tencent.mm.plugin.webcanvas.l.IAx;
            com.tencent.mm.plugin.webcanvas.l.LV(91);
            AppMethodBeat.o(212523);
            return;
        }
        com.tencent.mm.plugin.webcanvas.l lVar4 = com.tencent.mm.plugin.webcanvas.l.IAx;
        com.tencent.mm.plugin.webcanvas.l.LV(92);
        if (gzO()) {
            com.tencent.mm.plugin.webcanvas.m.IAG.fWS();
        }
        ch(biI);
        NOU = biI.optString("aid");
        gzI().encode(biG("biz_ad_card_data"), str);
        AppMethodBeat.o(212523);
    }

    static boolean cg(JSONObject jSONObject) {
        boolean z = false;
        AppMethodBeat.i(212524);
        if (jSONObject == null) {
            AppMethodBeat.o(212524);
        } else {
            long aVP = bp.aVP() / 1000;
            long optLong = jSONObject.optLong("ad_expire_time", aVP);
            if (aVP <= optLong) {
                z = true;
            }
            if (!z) {
                com.tencent.mm.plugin.webcanvas.l lVar = com.tencent.mm.plugin.webcanvas.l.IAx;
                com.tencent.mm.plugin.webcanvas.l.LV(103);
                Log.i("MicroMsg.BizCardLogic", "isAdDataValid ad expire aid=" + jSONObject.optString("aid") + " adExpireTime=" + optLong);
            }
            AppMethodBeat.o(212524);
        }
        return z;
    }

    public static JSONObject biI(String str) {
        AppMethodBeat.i(212525);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(212525);
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("advertisement_info");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(0);
                AppMethodBeat.o(212525);
                return optJSONObject;
            }
        } catch (Exception e2) {
            Log.w("MicroMsg.BizCardLogic", "getAdData ex %s", e2.getMessage());
        }
        AppMethodBeat.o(212525);
        return null;
    }

    public static void gzR() {
        AppMethodBeat.i(212526);
        gzI().encode("biz_card_max_ad_count", NOT);
        int i2 = Kmn;
        if (2 > i2) {
            AppMethodBeat.o(212526);
            return;
        }
        if (10 >= i2) {
            gzI().encode("biz_card_ad_insert_pos", Kmn);
        }
        AppMethodBeat.o(212526);
    }

    private static long gzS() {
        AppMethodBeat.i(212527);
        if (NPf > 1000) {
            long j2 = NPf;
            AppMethodBeat.o(212527);
            return j2;
        }
        long j3 = gzI().getLong("biz_card_refresh_interval", Util.MILLSECONDS_OF_HOUR);
        NPf = j3;
        AppMethodBeat.o(212527);
        return j3;
    }

    private static long gzT() {
        AppMethodBeat.i(212528);
        if (NPg > 1000) {
            long j2 = NPg;
            AppMethodBeat.o(212528);
            return j2;
        }
        long j3 = gzI().getLong("biz_card_resort_Refresh_IntervalSec", Util.MILLSECONDS_OF_HOUR);
        NPg = j3;
        AppMethodBeat.o(212528);
        return j3;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class f implements Runnable {
        final /* synthetic */ int NPr;

        f(int i2) {
            this.NPr = i2;
        }

        public final void run() {
            boolean z;
            boolean z2;
            AppMethodBeat.i(212490);
            com.tencent.mm.plugin.biz.b.c cVar = com.tencent.mm.plugin.biz.b.c.pfv;
            com.tencent.mm.plugin.biz.b.c.cks().encode("biz_canvas_card_expose_preload_crash_times", this.NPr + 1);
            Log.i("MicroMsg.BizCardLogic", "exposePreload set crash flag");
            r rVar = r.NPl;
            r.NPh = true;
            List<z> kL = ag.ban().kL(637534257, 1);
            if (kL != null) {
                z = false;
                for (T t : kL) {
                    if (Math.abs(((z) t).field_createTime - System.currentTimeMillis()) < Util.MILLSECONDS_OF_DAY) {
                        r rVar2 = r.NPl;
                        kotlin.g.b.p.g(t, "info");
                        rVar2.z(t);
                        com.tencent.mm.plugin.webcanvas.l lVar = com.tencent.mm.plugin.webcanvas.l.IAx;
                        com.tencent.mm.plugin.webcanvas.l.LV(12);
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    z = z2;
                }
            } else {
                z = false;
            }
            List<z> kL2 = ag.ban().kL(620757041, 1);
            if (kL2 != null) {
                for (T t2 : kL2) {
                    if (Math.abs(((z) t2).field_createTime - System.currentTimeMillis()) < Util.MILLSECONDS_OF_DAY) {
                        r rVar3 = r.NPl;
                        kotlin.g.b.p.g(t2, "info");
                        if (rVar3.z(t2)) {
                            com.tencent.mm.plugin.webcanvas.l lVar2 = com.tencent.mm.plugin.webcanvas.l.IAx;
                            com.tencent.mm.plugin.webcanvas.l.LV(13);
                            z = true;
                        }
                    }
                }
            }
            r.a(r.NPl);
            r.b(r.NPl);
            ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).clk();
            if (z) {
                r rVar4 = r.NPl;
                if (r.NPi) {
                    com.tencent.f.h.RTc.o(AnonymousClass1.NPs, 3000);
                    AppMethodBeat.o(212490);
                    return;
                }
            }
            r rVar5 = r.NPl;
            r.NPh = false;
            r rVar6 = r.NPl;
            r.gAa();
            AppMethodBeat.o(212490);
        }
    }

    public static void gzU() {
        AppMethodBeat.i(212529);
        NPi = false;
        if (NPh) {
            gzW();
        }
        AppMethodBeat.o(212529);
    }

    public static void gzV() {
        NPi = true;
    }

    private static void gzW() {
        AppMethodBeat.i(212530);
        Log.i("MicroMsg.BizCardLogic", "exposePreload reset crash flag");
        com.tencent.mm.plugin.biz.b.c cVar = com.tencent.mm.plugin.biz.b.c.pfv;
        com.tencent.mm.plugin.biz.b.c.cks().encode("biz_canvas_card_expose_preload_crash_times", 0);
        AppMethodBeat.o(212530);
    }

    public static void eXq() {
        AppMethodBeat.i(212531);
        if (!gzL()) {
            AppMethodBeat.o(212531);
            return;
        }
        List<z> kL = ag.ban().kL(637534257, 1);
        if (kL != null) {
            ArrayList arrayList = new ArrayList();
            for (T t : kL) {
                if (Math.abs(((z) t).field_createTime - System.currentTimeMillis()) < Util.MILLSECONDS_OF_DAY) {
                    arrayList.add(t);
                }
            }
            iC(arrayList);
            AppMethodBeat.o(212531);
            return;
        }
        AppMethodBeat.o(212531);
    }

    private static void iC(List<? extends z> list) {
        AppMethodBeat.i(212532);
        kotlin.g.b.p.h(list, "list");
        if (!gzL() || Util.isNullOrNil(list)) {
            AppMethodBeat.o(212532);
        } else if (gzJ() == 1) {
            AppMethodBeat.o(212532);
        } else {
            LinkedList linkedList = new LinkedList();
            ArrayList<z> arrayList = new ArrayList();
            for (T t : list) {
                com.tencent.mm.al.r rVar = pnt;
                String gAG = t.gAG();
                kotlin.g.b.p.g(gAG, "it.aId");
                if (!rVar.contains(gAG)) {
                    arrayList.add(t);
                }
            }
            JSONArray jSONArray = new JSONArray();
            boolean z = false;
            for (z zVar : arrayList) {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject gAE = zVar.gAE();
                    String optString = gAE.optString("aid");
                    jSONObject.put("aid", optString);
                    String optString2 = gAE.optString("reranking_ext_info");
                    if (optString2 != null) {
                        JSONObject jSONObject2 = new JSONObject(optString2);
                        jSONObject.put("tid", String.valueOf(jSONObject2.optLong("tid", 0)));
                        jSONObject.put("material_hash", jSONObject2.optString("material_hash"));
                    }
                    jSONObject.put("trace_id", gAE.optString("traceid"));
                    kotlin.g.b.p.g(optString, "aid");
                    NOR.put(optString, Long.valueOf(zVar.field_msgId));
                    linkedList.add(optString);
                    jSONArray.put(jSONObject);
                    pnt.add(optString);
                    z = true;
                } catch (Exception e2) {
                    Log.e("MicroMsg.BizCardLogic", "checkAd ex " + e2.getMessage());
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(WeChatBrands.Business.GROUP_ADS, jSONArray);
            String jSONObject4 = jSONObject3.toString();
            kotlin.g.b.p.g(jSONObject4, "list?.filter {\n         …  }?.toString()\n        }");
            String str = jSONObject4;
            if ((str == null || kotlin.n.n.aL(str)) || !z) {
                AppMethodBeat.o(212532);
                return;
            }
            com.tencent.mm.plugin.webcanvas.l lVar = com.tencent.mm.plugin.webcanvas.l.IAx;
            com.tencent.mm.plugin.webcanvas.l.LV(16);
            d.a aVar = new d.a();
            aVar.c(new ehk());
            aVar.d(new ehl());
            aVar.MB("/cgi-bin/mmbiz-bin/recommend/timelinecard");
            aVar.sG(2781);
            com.tencent.mm.ak.d aXF = aVar.aXF();
            kotlin.g.b.p.g(aXF, "rr");
            com.tencent.mm.bw.a aYJ = aXF.aYJ();
            if (aYJ == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.TimeLineCardReq");
                AppMethodBeat.o(212532);
                throw tVar;
            }
            ehk ehk = (ehk) aYJ;
            ehk.KWz = System.currentTimeMillis();
            ehk.KWE = 2;
            ehk.KWF = jSONObject4;
            aa.a(aXF, new d(linkedList));
            AppMethodBeat.o(212532);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\b2\u000e\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    public static final class d implements aa.a {
        final /* synthetic */ LinkedList NPp;

        d(LinkedList linkedList) {
            this.NPp = linkedList;
        }

        @Override // com.tencent.mm.ak.aa.a
        public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, q qVar) {
            z MM;
            z MM2;
            AppMethodBeat.i(212485);
            if (i2 == 0 && i3 == 0) {
                kotlin.g.b.p.g(dVar, "rr");
                com.tencent.mm.bw.a aYK = dVar.aYK();
                if (!(aYK instanceof ehl)) {
                    aYK = null;
                }
                ehl ehl = (ehl) aYK;
                if (ehl == null) {
                    AppMethodBeat.o(212485);
                    return 0;
                } else if (Util.isNullOrNil(ehl.KWF)) {
                    Log.e("MicroMsg.BizCardLogic", "checkAd callback resp.Data is empty");
                    com.tencent.mm.plugin.webcanvas.l lVar = com.tencent.mm.plugin.webcanvas.l.IAx;
                    com.tencent.mm.plugin.webcanvas.l.LV(18);
                    AppMethodBeat.o(212485);
                    return 0;
                } else {
                    com.tencent.mm.plugin.webcanvas.l lVar2 = com.tencent.mm.plugin.webcanvas.l.IAx;
                    com.tencent.mm.plugin.webcanvas.l.LV(19);
                    try {
                        JSONObject jSONObject = new JSONObject(ehl.KWF);
                        String optString = jSONObject.optString("aid");
                        JSONArray optJSONArray = jSONObject.optJSONArray("del_aid");
                        Log.i("MicroMsg.BizCardLogic", "checkAd callback chooseAid=".concat(String.valueOf(optString)));
                        if ((optJSONArray != null ? optJSONArray.length() : 0) > 0) {
                            int length = optJSONArray.length();
                            for (int i4 = 0; i4 < length; i4++) {
                                String optString2 = optJSONArray.optString(i4);
                                String str2 = optString2;
                                if (!(str2 == null || kotlin.n.n.aL(str2))) {
                                    r rVar = r.NPl;
                                    Long l = (Long) r.NOR.get(optString2);
                                    if (!(l == null || (MM2 = ag.ban().MM(l.longValue())) == null)) {
                                        ag.ban().MX(l.longValue());
                                        Log.e("MicroMsg.BizCardLogic", "checkAd force delete ad ".concat(String.valueOf(optString2)));
                                        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                                        Object[] objArr = new Object[4];
                                        objArr[0] = optString2;
                                        objArr[1] = MM2.getTraceId();
                                        objArr[2] = 2;
                                        objArr[3] = Integer.valueOf(MM2.field_isRead == 1 ? 1 : 0);
                                        hVar.a(20635, objArr);
                                        com.tencent.mm.plugin.webcanvas.l lVar3 = com.tencent.mm.plugin.webcanvas.l.IAx;
                                        com.tencent.mm.plugin.webcanvas.l.LV(MM2.field_isRead == 1 ? 21 : 20);
                                        com.tencent.mm.plugin.webcanvas.l lVar4 = com.tencent.mm.plugin.webcanvas.l.IAx;
                                        com.tencent.mm.plugin.webcanvas.l.LV(23);
                                    }
                                }
                            }
                        }
                        for (String str3 : this.NPp) {
                            r rVar2 = r.NPl;
                            r.NOS.add(str3);
                            if (!kotlin.g.b.p.j(str3, optString)) {
                                r rVar3 = r.NPl;
                                Long l2 = (Long) r.NOR.get(str3);
                                if (!(l2 == null || (MM = ag.ban().MM(l2.longValue())) == null)) {
                                    if (MM.field_isRead == 0) {
                                        ag.ban().MX(l2.longValue());
                                        Log.e("MicroMsg.BizCardLogic", "checkAd delete ad " + MM.gAG());
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(20635, MM.gAG(), MM.getTraceId(), 1, 0);
                                        com.tencent.mm.plugin.webcanvas.l lVar5 = com.tencent.mm.plugin.webcanvas.l.IAx;
                                        com.tencent.mm.plugin.webcanvas.l.LV(22);
                                    } else {
                                        com.tencent.mm.plugin.webcanvas.l lVar6 = com.tencent.mm.plugin.webcanvas.l.IAx;
                                        com.tencent.mm.plugin.webcanvas.l.LV(24);
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(20635, MM.gAG(), MM.getTraceId(), 0, 1);
                                    }
                                }
                            }
                        }
                    } catch (Exception e2) {
                        Log.e("MicroMsg.BizCardLogic", "checkAd callback ex " + e2.getMessage());
                    }
                    AppMethodBeat.o(212485);
                    return 0;
                }
            } else {
                Log.e("MicroMsg.BizCardLogic", "checkAd callback errType=" + i2 + ", errCode=" + i3);
                com.tencent.mm.plugin.webcanvas.l lVar7 = com.tencent.mm.plugin.webcanvas.l.IAx;
                com.tencent.mm.plugin.webcanvas.l.LV(17);
                AppMethodBeat.o(212485);
                return 0;
            }
        }
    }

    public static boolean biJ(String str) {
        AppMethodBeat.i(212533);
        kotlin.g.b.p.h(str, "canvasId");
        String str2 = NOU;
        if (str2 == null || kotlin.n.n.aL(str2)) {
            AppMethodBeat.o(212533);
            return false;
        }
        String substring = str.substring(10);
        kotlin.g.b.p.g(substring, "(this as java.lang.String).substring(startIndex)");
        if (!ab.NQR) {
            if (Util.isEqual(NOU, substring)) {
                Log.i("MicroMsg.BizCardLogic", "replaceTimelineAd but not in timeline lastAId=" + NOU + ", canvasId=" + str);
                ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).P("wxa06c02b5c00ff39b", "adReplace", "err_code:2,err_msg:'not in timeline', aid:'" + NOU + '\'');
                NOU = null;
            }
            AppMethodBeat.o(212533);
            return false;
        } else if (!Util.isEqual(NOU, substring)) {
            AppMethodBeat.o(212533);
            return false;
        } else {
            com.tencent.f.h.RTc.b(m.NPy, "BizInsertTlRecCardThread");
            AppMethodBeat.o(212533);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class m implements Runnable {
        public static final m NPy = new m();

        static {
            AppMethodBeat.i(212503);
            AppMethodBeat.o(212503);
        }

        m() {
        }

        public final void run() {
            AppMethodBeat.i(212502);
            r rVar = r.NPl;
            z gAd = r.gAd();
            if (gAd != null) {
                String gAG = gAd.gAG();
                r rVar2 = r.NPl;
                if (Util.isEqual(gAG, r.gzG())) {
                    StringBuilder sb = new StringBuilder("replaceTimelineAd is same ad lastAId=");
                    r rVar3 = r.NPl;
                    Log.i("MicroMsg.BizCardLogic", sb.append(r.gzG()).append('}').toString());
                    AppMethodBeat.o(212502);
                    return;
                }
                r rVar4 = r.NPl;
                MultiProcessMMKV gAe = r.gAe();
                r rVar5 = r.NPl;
                gAd.field_content = gAe.decodeString(r.biL("biz_ad_card_data"));
                gAd.field_createTime = bp.aVP();
                boolean D = ag.ban().D(gAd);
                r rVar6 = r.NPl;
                MultiProcessMMKV gAe2 = r.gAe();
                r rVar7 = r.NPl;
                gAe2.encode(r.biL("biz_ad_card_data"), "");
                r rVar8 = r.NPl;
                r.gzH();
                StringBuilder sb2 = new StringBuilder("err_code:0,err_msg:'ok', aid:'");
                r rVar9 = r.NPl;
                ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).P("wxa06c02b5c00ff39b", "adReplace", sb2.append(r.gzG()).append('\'').toString());
                Log.i("MicroMsg.BizCardLogic", "replaceAd updateById result: " + D + ", msgId:" + gAd.field_msgId + " orderFlag:" + gAd.field_orderFlag + " aid: " + gAd.gAG());
                AppMethodBeat.o(212502);
                return;
            }
            StringBuilder sb3 = new StringBuilder("err_code:1,err_msg:'ad exposed', aid:'");
            r rVar10 = r.NPl;
            ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).P("wxa06c02b5c00ff39b", "adReplace", sb3.append(r.gzG()).append('\'').toString());
            AppMethodBeat.o(212502);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class l implements Runnable {
        final /* synthetic */ String pmq;

        l(String str) {
            this.pmq = str;
        }

        public final void run() {
            AppMethodBeat.i(212501);
            r rVar = r.NPl;
            String gzG = r.gzG();
            if (!(gzG == null || kotlin.n.n.aL(gzG))) {
                StringBuilder sb = new StringBuilder("replaceAdData replace lastAId=");
                r rVar2 = r.NPl;
                Log.d("MicroMsg.BizCardLogic", sb.append(r.gzG()).toString());
            }
            r.NPl.biH(this.pmq);
            AppMethodBeat.o(212501);
        }
    }

    public static void replaceAdData(String str) {
        AppMethodBeat.i(212534);
        com.tencent.f.h.RTc.b(new l(str), "BizInsertTlRecCardThread");
        AppMethodBeat.o(212534);
    }

    static z gzX() {
        AppMethodBeat.i(212536);
        z gAL = ag.ban().gAL();
        if (gAL == null || gAL.field_isRead != 0) {
            AppMethodBeat.o(212536);
            return null;
        }
        AppMethodBeat.o(212536);
        return gAL;
    }

    private synchronized void ch(JSONObject jSONObject) {
        AppMethodBeat.i(212537);
        kotlin.g.b.p.h(jSONObject, "adData");
        try {
            String optString = jSONObject.optString("aid");
            kotlin.g.b.p.g(optString, "adData.optString(\"aid\")");
            String optString2 = jSONObject.optString(Constants.EVENT_MAPPING_PATH_TYPE_KEY, "ad");
            kotlin.g.b.p.g(optString2, "adData.optString(\"path_type\", \"ad\")");
            Log.i("MicroMsg.BizCardLogic", "preloadAdCard aid=" + optString + ", pathType=" + optString2);
            String str = optString;
            if (!(str == null || kotlin.n.n.aL(str))) {
                String str2 = optString2;
                if (!(str2 == null || kotlin.n.n.aL(str2))) {
                    com.tencent.mm.plugin.webcanvas.l lVar = com.tencent.mm.plugin.webcanvas.l.IAx;
                    com.tencent.mm.plugin.webcanvas.l.LV(8);
                    ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).Q(optString2, "__ad_card_".concat(String.valueOf(optString)), jSONObject.toString());
                }
            }
            AppMethodBeat.o(212537);
        } catch (Exception e2) {
            Log.w("MicroMsg.BizCardLogic", "preloadAdCard ex %s", e2.getMessage());
            AppMethodBeat.o(212537);
        }
    }

    public final synchronized boolean z(z zVar) {
        boolean z;
        AppMethodBeat.i(212538);
        kotlin.g.b.p.h(zVar, "info");
        if (zVar.gAv()) {
            Log.d("MicroMsg.BizCardLogic", "preload ad card");
            com.tencent.mm.plugin.webcanvas.l lVar = com.tencent.mm.plugin.webcanvas.l.IAx;
            com.tencent.mm.plugin.webcanvas.l.LV(8);
            com.tencent.mm.plugin.brandservice.a.b bVar = (com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class);
            String pathType = zVar.getPathType();
            if (pathType == null) {
                pathType = "ad";
            }
            bVar.Q(pathType, "__ad_card_" + zVar.gAG(), zVar.acx());
            z = true;
            AppMethodBeat.o(212538);
        } else if (zVar.gAu()) {
            z = b(zVar.gAD());
            AppMethodBeat.o(212538);
        } else {
            z = false;
            AppMethodBeat.o(212538);
        }
        return z;
    }

    public final synchronized boolean b(ege ege) {
        boolean z;
        AppMethodBeat.i(212539);
        if (ege == null || ege.style != 1001 || ege.Ngc == null) {
            z = false;
            AppMethodBeat.o(212539);
        } else {
            Log.d("MicroMsg.BizCardLogic", "preload rec card");
            com.tencent.mm.plugin.webcanvas.l lVar = com.tencent.mm.plugin.webcanvas.l.IAx;
            com.tencent.mm.plugin.webcanvas.l.LV(9);
            com.tencent.mm.plugin.brandservice.a.b bVar = (com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class);
            String str = ege.Ngc.MOE;
            if (str == null) {
                str = "re";
            }
            bVar.Q(str, "__rec_card_" + ege.Ngc.cardId, ege.Ngc.data);
            z = true;
            AppMethodBeat.o(212539);
        }
        return z;
    }

    public static boolean biK(String str) {
        AppMethodBeat.i(212540);
        kotlin.g.b.p.h(str, "aid");
        boolean contains = NOS.contains(str);
        AppMethodBeat.o(212540);
        return contains;
    }

    private static String gzY() {
        String str;
        AppMethodBeat.i(212541);
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (aTI().getInt("BizTimeLineAdMockType", 0) == 0) {
            str = NPk;
        } else {
            str = NPj;
        }
        jSONArray.put(new JSONObject(str));
        jSONObject.put("advertisement_info", jSONArray);
        jSONObject.put("advertisement_num", 1);
        String jSONObject2 = jSONObject.toString();
        kotlin.g.b.p.g(jSONObject2, "adData.toString()");
        AppMethodBeat.o(212541);
        return jSONObject2;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
    static final class h extends kotlin.g.b.q implements kotlin.g.a.a<MultiProcessMMKV> {
        public static final h NPu = new h();

        static {
            AppMethodBeat.i(212494);
            AppMethodBeat.o(212494);
        }

        h() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MultiProcessMMKV invoke() {
            AppMethodBeat.i(212493);
            MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
            AppMethodBeat.o(212493);
            return singleMMKV;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a extends kotlin.g.b.q implements kotlin.g.a.a<MultiProcessMMKV> {
        public static final a NPm = new a();

        static {
            AppMethodBeat.i(212480);
            AppMethodBeat.o(212480);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MultiProcessMMKV invoke() {
            AppMethodBeat.i(212479);
            MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("biz_timeline_ad");
            AppMethodBeat.o(212479);
            return singleMMKV;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class n extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        public static final n NPz = new n();

        static {
            AppMethodBeat.i(212505);
            AppMethodBeat.o(212505);
        }

        n() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(212504);
            r rVar = r.NPl;
            Integer valueOf = Integer.valueOf(r.gAf().decodeInt("BizTimeLineAdTestMode", 0));
            AppMethodBeat.o(212504);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class g extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        public static final g NPt = new g();

        static {
            AppMethodBeat.i(212492);
            AppMethodBeat.o(212492);
        }

        g() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(212491);
            r rVar = r.NPl;
            Integer valueOf = Integer.valueOf(r.gAf().decodeInt("BizAdInsertPos", -1));
            AppMethodBeat.o(212491);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        public static final b NPn = new b();

        static {
            AppMethodBeat.i(212482);
            AppMethodBeat.o(212482);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0052, code lost:
            if (r0 == false) goto L_0x0054;
         */
        @Override // kotlin.g.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ java.lang.Boolean invoke() {
            /*
                r7 = this;
                r6 = 212481(0x33e01, float:2.97749E-40)
                r2 = 0
                r1 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
                com.tencent.mm.storage.r r0 = com.tencent.mm.storage.r.NPl
                com.tencent.mm.sdk.platformtools.MultiProcessMMKV r0 = com.tencent.mm.storage.r.gAf()
                java.lang.String r3 = "BizTimeLineAdOpen"
                r4 = -1
                int r0 = r0.decodeInt(r3, r4)
                if (r0 != r1) goto L_0x0020
            L_0x0018:
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                return r0
            L_0x0020:
                if (r0 == 0) goto L_0x0054
                boolean r0 = com.tencent.mm.sdk.platformtools.BuildInfo.DEBUG
                if (r0 != 0) goto L_0x0018
                boolean r0 = com.tencent.mm.sdk.platformtools.BuildInfo.IS_FLAVOR_RED
                if (r0 != 0) goto L_0x0018
                boolean r0 = com.tencent.mm.sdk.platformtools.WeChatEnvironment.hasDebugger()
                if (r0 != 0) goto L_0x0018
                java.lang.Class<com.tencent.mm.plugin.expt.b.b> r0 = com.tencent.mm.plugin.expt.b.b.class
                com.tencent.mm.kernel.c.a r0 = com.tencent.mm.kernel.g.af(r0)
                com.tencent.mm.plugin.expt.b.b r0 = (com.tencent.mm.plugin.expt.b.b) r0
                com.tencent.mm.plugin.expt.b.b$a r3 = com.tencent.mm.plugin.expt.b.b.a.clicfg_open_biz_time_line_ad
                int r0 = r0.a(r3, r2)
                if (r0 != r1) goto L_0x0056
                r0 = r1
            L_0x0041:
                java.lang.String r3 = "MicroMsg.BizCardLogic"
                java.lang.String r4 = "ad open "
                java.lang.String r5 = java.lang.String.valueOf(r0)
                java.lang.String r4 = r4.concat(r5)
                com.tencent.mm.sdk.platformtools.Log.i(r3, r4)
                if (r0 != 0) goto L_0x0018
            L_0x0054:
                r1 = r2
                goto L_0x0018
            L_0x0056:
                r0 = r2
                goto L_0x0041
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.r.b.invoke():java.lang.Object");
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class k extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        public static final k NPx = new k();

        static {
            AppMethodBeat.i(212500);
            AppMethodBeat.o(212500);
        }

        k() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0038, code lost:
            if (r0 != false) goto L_0x003a;
         */
        @Override // kotlin.g.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ java.lang.Boolean invoke() {
            /*
                r7 = this;
                r6 = 212499(0x33e13, float:2.97775E-40)
                r1 = 1
                r2 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
                boolean r0 = com.tencent.mm.sdk.platformtools.BuildInfo.DEBUG
                if (r0 != 0) goto L_0x003a
                boolean r0 = com.tencent.mm.sdk.platformtools.BuildInfo.IS_FLAVOR_RED
                if (r0 != 0) goto L_0x003a
                boolean r0 = com.tencent.mm.sdk.platformtools.WeChatEnvironment.hasDebugger()
                if (r0 != 0) goto L_0x003a
                java.lang.Class<com.tencent.mm.plugin.expt.b.b> r0 = com.tencent.mm.plugin.expt.b.b.class
                com.tencent.mm.kernel.c.a r0 = com.tencent.mm.kernel.g.af(r0)
                com.tencent.mm.plugin.expt.b.b r0 = (com.tencent.mm.plugin.expt.b.b) r0
                com.tencent.mm.plugin.expt.b.b$a r3 = com.tencent.mm.plugin.expt.b.b.a.clicfg_open_biz_time_line_canvas_rec_card
                int r0 = r0.a(r3, r2)
                if (r0 != r1) goto L_0x0043
                r0 = r1
            L_0x0027:
                java.lang.String r3 = "MicroMsg.BizCardLogic"
                java.lang.String r4 = "recOpen open "
                java.lang.String r5 = java.lang.String.valueOf(r0)
                java.lang.String r4 = r4.concat(r5)
                com.tencent.mm.sdk.platformtools.Log.i(r3, r4)
                if (r0 == 0) goto L_0x003b
            L_0x003a:
                r2 = r1
            L_0x003b:
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                return r0
            L_0x0043:
                r0 = r2
                goto L_0x0027
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.r.k.invoke():java.lang.Object");
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class i extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        public static final i NPv = new i();

        static {
            AppMethodBeat.i(212496);
            AppMethodBeat.o(212496);
        }

        i() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0052, code lost:
            if (r0 == false) goto L_0x0054;
         */
        @Override // kotlin.g.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ java.lang.Boolean invoke() {
            /*
                r7 = this;
                r6 = 212495(0x33e0f, float:2.97769E-40)
                r2 = 0
                r1 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
                com.tencent.mm.storage.r r0 = com.tencent.mm.storage.r.NPl
                com.tencent.mm.sdk.platformtools.MultiProcessMMKV r0 = com.tencent.mm.storage.r.gAf()
                java.lang.String r3 = "BizTimeLineAdPrefetcherOpen"
                r4 = -1
                int r0 = r0.decodeInt(r3, r4)
                if (r0 != r1) goto L_0x0020
            L_0x0018:
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                return r0
            L_0x0020:
                if (r0 == 0) goto L_0x0054
                boolean r0 = com.tencent.mm.sdk.platformtools.BuildInfo.DEBUG
                if (r0 != 0) goto L_0x0018
                boolean r0 = com.tencent.mm.sdk.platformtools.BuildInfo.IS_FLAVOR_RED
                if (r0 != 0) goto L_0x0018
                boolean r0 = com.tencent.mm.sdk.platformtools.WeChatEnvironment.hasDebugger()
                if (r0 != 0) goto L_0x0018
                java.lang.Class<com.tencent.mm.plugin.expt.b.b> r0 = com.tencent.mm.plugin.expt.b.b.class
                com.tencent.mm.kernel.c.a r0 = com.tencent.mm.kernel.g.af(r0)
                com.tencent.mm.plugin.expt.b.b r0 = (com.tencent.mm.plugin.expt.b.b) r0
                com.tencent.mm.plugin.expt.b.b$a r3 = com.tencent.mm.plugin.expt.b.b.a.clicfg_open_biz_time_line_canvas_prefetcher
                int r0 = r0.a(r3, r2)
                if (r0 != r1) goto L_0x0056
                r0 = r1
            L_0x0041:
                java.lang.String r3 = "MicroMsg.BizCardLogic"
                java.lang.String r4 = "prefetchOpen open "
                java.lang.String r5 = java.lang.String.valueOf(r0)
                java.lang.String r4 = r4.concat(r5)
                com.tencent.mm.sdk.platformtools.Log.i(r3, r4)
                if (r0 != 0) goto L_0x0018
            L_0x0054:
                r1 = r2
                goto L_0x0018
            L_0x0056:
                r0 = r2
                goto L_0x0041
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.r.i.invoke():java.lang.Object");
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class j extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        public static final j NPw = new j();

        static {
            AppMethodBeat.i(212498);
            AppMethodBeat.o(212498);
        }

        j() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(212497);
            boolean z = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_biz_time_line_canvas_rec_conflict, 1) == 1;
            Log.i("MicroMsg.BizCardLogic", "recConflictOpen open ".concat(String.valueOf(z)));
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(212497);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class o extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        public static final o NPA = new o();

        static {
            AppMethodBeat.i(212507);
            AppMethodBeat.o(212507);
        }

        o() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0038, code lost:
            if (r0 != false) goto L_0x003a;
         */
        @Override // kotlin.g.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ java.lang.Boolean invoke() {
            /*
                r7 = this;
                r6 = 212506(0x33e1a, float:2.97784E-40)
                r1 = 1
                r2 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
                boolean r0 = com.tencent.mm.sdk.platformtools.BuildInfo.DEBUG
                if (r0 != 0) goto L_0x003a
                boolean r0 = com.tencent.mm.sdk.platformtools.BuildInfo.IS_FLAVOR_RED
                if (r0 != 0) goto L_0x003a
                boolean r0 = com.tencent.mm.sdk.platformtools.WeChatEnvironment.hasDebugger()
                if (r0 != 0) goto L_0x003a
                java.lang.Class<com.tencent.mm.plugin.expt.b.b> r0 = com.tencent.mm.plugin.expt.b.b.class
                com.tencent.mm.kernel.c.a r0 = com.tencent.mm.kernel.g.af(r0)
                com.tencent.mm.plugin.expt.b.b r0 = (com.tencent.mm.plugin.expt.b.b) r0
                com.tencent.mm.plugin.expt.b.b$a r3 = com.tencent.mm.plugin.expt.b.b.a.clicfg_open_biz_trigger_download_pkg_on_get_ad_data
                int r0 = r0.a(r3, r2)
                if (r0 != r1) goto L_0x0043
                r0 = r1
            L_0x0027:
                java.lang.String r3 = "MicroMsg.BizCardLogic"
                java.lang.String r4 = "recOpen open "
                java.lang.String r5 = java.lang.String.valueOf(r0)
                java.lang.String r4 = r4.concat(r5)
                com.tencent.mm.sdk.platformtools.Log.i(r3, r4)
                if (r0 == 0) goto L_0x003b
            L_0x003a:
                r2 = r1
            L_0x003b:
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                return r0
            L_0x0043:
                r0 = r2
                goto L_0x0027
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.r.o.invoke():java.lang.Object");
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class p extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        public static final p NPB = new p();

        static {
            AppMethodBeat.i(212509);
            AppMethodBeat.o(212509);
        }

        p() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0038, code lost:
            if (r0 != false) goto L_0x003a;
         */
        @Override // kotlin.g.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ java.lang.Boolean invoke() {
            /*
                r7 = this;
                r6 = 212508(0x33e1c, float:2.97787E-40)
                r1 = 1
                r2 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
                boolean r0 = com.tencent.mm.sdk.platformtools.BuildInfo.DEBUG
                if (r0 != 0) goto L_0x003a
                boolean r0 = com.tencent.mm.sdk.platformtools.BuildInfo.IS_FLAVOR_RED
                if (r0 != 0) goto L_0x003a
                boolean r0 = com.tencent.mm.sdk.platformtools.WeChatEnvironment.hasDebugger()
                if (r0 != 0) goto L_0x003a
                java.lang.Class<com.tencent.mm.plugin.expt.b.b> r0 = com.tencent.mm.plugin.expt.b.b.class
                com.tencent.mm.kernel.c.a r0 = com.tencent.mm.kernel.g.af(r0)
                com.tencent.mm.plugin.expt.b.b r0 = (com.tencent.mm.plugin.expt.b.b) r0
                com.tencent.mm.plugin.expt.b.b$a r3 = com.tencent.mm.plugin.expt.b.b.a.clicfg_open_biz_trigger_download_pkg_on_get_rec_data
                int r0 = r0.a(r3, r2)
                if (r0 != r1) goto L_0x0043
                r0 = r1
            L_0x0027:
                java.lang.String r3 = "MicroMsg.BizCardLogic"
                java.lang.String r4 = "recOpen open "
                java.lang.String r5 = java.lang.String.valueOf(r0)
                java.lang.String r4 = r4.concat(r5)
                com.tencent.mm.sdk.platformtools.Log.i(r3, r4)
                if (r0 == 0) goto L_0x003b
            L_0x003a:
                r2 = r1
            L_0x003b:
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                return r0
            L_0x0043:
                r0 = r2
                goto L_0x0027
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.r.p.invoke():java.lang.Object");
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        public static final c NPo = new c();

        static {
            AppMethodBeat.i(212484);
            AppMethodBeat.o(212484);
        }

        c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0038, code lost:
            if (r0 != false) goto L_0x003a;
         */
        @Override // kotlin.g.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ java.lang.Boolean invoke() {
            /*
                r7 = this;
                r6 = 212483(0x33e03, float:2.97752E-40)
                r1 = 1
                r2 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
                boolean r0 = com.tencent.mm.sdk.platformtools.BuildInfo.DEBUG
                if (r0 != 0) goto L_0x003a
                boolean r0 = com.tencent.mm.sdk.platformtools.BuildInfo.IS_FLAVOR_RED
                if (r0 != 0) goto L_0x003a
                boolean r0 = com.tencent.mm.sdk.platformtools.WeChatEnvironment.hasDebugger()
                if (r0 != 0) goto L_0x003a
                java.lang.Class<com.tencent.mm.plugin.expt.b.b> r0 = com.tencent.mm.plugin.expt.b.b.class
                com.tencent.mm.kernel.c.a r0 = com.tencent.mm.kernel.g.af(r0)
                com.tencent.mm.plugin.expt.b.b r0 = (com.tencent.mm.plugin.expt.b.b) r0
                com.tencent.mm.plugin.expt.b.b$a r3 = com.tencent.mm.plugin.expt.b.b.a.clicfg_open_biz_time_line_canvas_preload
                int r0 = r0.a(r3, r2)
                if (r0 != r1) goto L_0x0043
                r0 = r1
            L_0x0027:
                java.lang.String r3 = "MicroMsg.BizCardLogic"
                java.lang.String r4 = "canvasPreloadOpen "
                java.lang.String r5 = java.lang.String.valueOf(r0)
                java.lang.String r4 = r4.concat(r5)
                com.tencent.mm.sdk.platformtools.Log.i(r3, r4)
                if (r0 == 0) goto L_0x003b
            L_0x003a:
                r2 = r1
            L_0x003b:
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                return r0
            L_0x0043:
                r0 = r2
                goto L_0x0027
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.r.c.invoke():java.lang.Object");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static long MJ(long r8) {
        /*
        // Method dump skipped, instructions count: 138
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.r.MJ(long):long");
    }

    public static final /* synthetic */ void ajR(int i2) {
        AppMethodBeat.i(212543);
        if (i2 <= 259200 && i2 > 60) {
            NPf = ((long) i2) * 1000;
            gzI().encode("biz_card_refresh_interval", ((long) i2) * 1000);
        }
        AppMethodBeat.o(212543);
    }

    public static final /* synthetic */ void a(r rVar) {
        JSONObject biI;
        AppMethodBeat.i(212544);
        String decodeString = gzI().decodeString(biG("biz_ad_card_data"));
        String str = decodeString;
        if (!(str == null || kotlin.n.n.aL(str)) && (biI = biI(decodeString)) != null) {
            rVar.ch(biI);
        }
        AppMethodBeat.o(212544);
    }

    public static final /* synthetic */ void b(r rVar) {
        AppMethodBeat.i(212545);
        StringBuilder sb = new StringBuilder("BizLatestRecommendCardInfo");
        kotlin.g.b.p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
        String decodeString = aTI().decodeString(sb.append(com.tencent.mm.kernel.a.ayV()).toString());
        if (!Util.isNullOrNil(decodeString)) {
            kotlin.g.b.p.g(decodeString, "msgContent");
            int a2 = kotlin.n.n.a((CharSequence) decodeString, "<sysmsg", 0, false, 6);
            if (a2 != -1) {
                String substring = decodeString.substring(a2);
                kotlin.g.b.p.g(substring, "(this as java.lang.String).substring(startIndex)");
                Map<String, String> parseXml = XmlParser.parseXml(substring, "sysmsg", null);
                if (parseXml == null) {
                    Log.e("MicroMsg.BizCardLogic", "XmlParser values is null, msgContent %s", decodeString);
                    AppMethodBeat.o(212545);
                    return;
                } else if (af.bU(parseXml)) {
                    ege bV = af.bV(parseXml);
                    if (bV == null) {
                        AppMethodBeat.o(212545);
                        return;
                    }
                    rVar.b(bV);
                }
            } else {
                AppMethodBeat.o(212545);
                return;
            }
        }
        AppMethodBeat.o(212545);
    }
}
