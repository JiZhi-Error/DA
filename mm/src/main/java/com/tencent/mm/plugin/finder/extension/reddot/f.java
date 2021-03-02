package com.tencent.mm.plugin.finder.extension.reddot;

import android.arch.lifecycle.ViewModel;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.e;
import com.tencent.mm.plugin.finder.preload.tabPreload.FinderStreamTabPreloadCore;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bbj;
import com.tencent.mm.protocal.protobuf.bbo;
import com.tencent.mm.protocal.protobuf.bbp;
import com.tencent.mm.protocal.protobuf.bbq;
import com.tencent.mm.protocal.protobuf.bbr;
import com.tencent.mm.protocal.protobuf.bdh;
import com.tencent.mm.protocal.protobuf.bdi;
import com.tencent.mm.protocal.protobuf.bdj;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.b.b;
import kotlin.g.b.z;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0018\u0018\u0000  \u00012\u00020\u00012\u00020\u0002:\u0006 \u0001¡\u0001¢\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005JX\u0010-\u001a\u0004\u0018\u00010\f2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\u00132\u0018\b\u0002\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u001302j\b\u0012\u0004\u0012\u00020\u0013`32\b\b\u0002\u00104\u001a\u00020\r2\u0018\b\u0002\u00105\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u000106\u0018\u00010\nJ(\u00107\u001a\u0012\u0012\u0004\u0012\u00020\u001302j\b\u0012\u0004\u0012\u00020\u0013`32\u0006\u00108\u001a\u00020\f2\u0006\u00100\u001a\u00020\u0013H\u0002J.\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00132\b\u0010<\u001a\u0004\u0018\u00010\f2\b\u0010=\u001a\u0004\u0018\u00010\f2\b\u0010>\u001a\u0004\u0018\u000106H\u0002J\u0010\u0010?\u001a\u00020\r2\u0006\u0010@\u001a\u00020\fH\u0002J\u000e\u0010?\u001a\u00020:2\u0006\u0010A\u001a\u00020\u0010J3\u0010?\u001a\u00020\r2\u0006\u0010A\u001a\u00020\u00102#\b\u0002\u0010B\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\r0\u000bJ\u0018\u0010E\u001a\u00020:2\b\u0010F\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\u0013J\u0018\u0010E\u001a\u0004\u0018\u00010G2\u0006\u0010;\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u0013J\u000e\u0010H\u001a\u00020\r2\u0006\u0010I\u001a\u00020\u0010J\u0010\u0010J\u001a\u0004\u0018\u00010\f2\u0006\u0010;\u001a\u00020\u0013J\u0010\u0010K\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0013H\u0016J1\u0010K\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00132!\u0010L\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\r0\u000bJ\u001a\u0010K\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00132\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\u0010\u0010O\u001a\u00020:2\b\b\u0002\u00100\u001a\u00020\u0010J\u0006\u0010P\u001a\u00020:J\u0006\u0010Q\u001a\u00020:J\u0010\u0010R\u001a\u00020\r2\u0006\u0010S\u001a\u00020TH\u0002J\u0014\u0010U\u001a\u0004\u0018\u00010\f2\b\u0010V\u001a\u0004\u0018\u00010\u0013H\u0002J\u000e\u0010W\u001a\u00020X2\u0006\u0010;\u001a\u00020\u0013J\b\u0010Y\u001a\u00020:H\u0002J\u0006\u0010Z\u001a\u00020\u0010J\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\f0\\J9\u0010]\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010;\u001a\u00020\u00132#\b\u0002\u0010B\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\r0\u000bJ]\u0010^\u001a*\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0`0_j\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0``a2\u0006\u0010A\u001a\u00020\u00102#\b\u0002\u0010B\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\r0\u000bH\u0002J\b\u0010b\u001a\u00020\u0016H\u0002J\u0010\u0010c\u001a\u0004\u0018\u00010G2\u0006\u0010;\u001a\u00020\u0013J\u0010\u0010d\u001a\u00020\u00102\u0006\u0010<\u001a\u00020\fH\u0002J:\u0010e\u001a\u0004\u0018\u00010\f2.\u0010f\u001a*\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0`0_j\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0``aH\u0002J \u0010g\u001a\u0004\u0018\u00010\f2\b\u0010h\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\fH\u0002J\u0006\u0010j\u001a\u00020\u0010J\b\u0010k\u001a\u00020\u0016H\u0002J\u000e\u0010l\u001a\u00020\u00132\u0006\u0010I\u001a\u00020\u0010J\u000e\u0010m\u001a\u00020X2\u0006\u0010I\u001a\u00020\u0010J\u000e\u0010n\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\u0013J\u0010\u0010o\u001a\u0004\u0018\u0001062\u0006\u0010;\u001a\u00020\u0013J\u000e\u0010p\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\u0013J\u000e\u0010q\u001a\u00020:2\u0006\u0010r\u001a\u00020\u0010J\b\u0010s\u001a\u00020\rH\u0016J\u0010\u0010t\u001a\u00020:2\u0006\u0010<\u001a\u00020/H\u0002J\u000e\u0010u\u001a\u00020:2\u0006\u0010r\u001a\u00020\u0010J\u001e\u0010v\u001a\u00020:2\u0006\u0010w\u001a\u00020\u00102\u0006\u0010x\u001a\u00020\u00102\u0006\u0010y\u001a\u00020\u0010J\u000e\u0010z\u001a\u00020:2\u0006\u0010{\u001a\u00020|J\u0016\u0010}\u001a\u00020:2\u0006\u0010~\u001a\u000202\u0006\u00100\u001a\u00020\u0013J\u0011\u0010\u0001\u001a\u00020:2\b\u0010\u0001\u001a\u00030\u0001J\u0012\u0010\u0001\u001a\u00020:2\u0007\u0010\u0001\u001a\u00020\bH\u0002J2\u0010\u0001\u001a\u00020:2\u0007\u0010\u0001\u001a\u00020\u00102\u0007\u0010\u0001\u001a\u00020\u00102\t\u0010\u0001\u001a\u0004\u0018\u00010\u00132\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0007\u0010\u0001\u001a\u00020:J\u0013\u0010\u0001\u001a\u00020\u00132\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J\u001c\u0010\u0001\u001a\u00020\u00132\b\u0010.\u001a\u0004\u0018\u0001062\u0007\u0010\u0001\u001a\u00020\u0010H\u0002J\u0017\u0010\u0001\u001a\u00020:2\u0006\u00108\u001a\u00020/2\u0006\u00100\u001a\u00020\u0013J!\u0010\u0001\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u000106\u0018\u00010\n2\u0006\u00108\u001a\u00020/H\u0002J!\u0010\u0001\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u000106\u0018\u00010\n2\u0006\u0010;\u001a\u00020\u0013H\u0002J(\u0010\u0001\u001a\u0004\u0018\u00010\f2\u0006\u0010;\u001a\u00020\u00132\b\u0010<\u001a\u0004\u0018\u00010/2\t\u0010\u0001\u001a\u0004\u0018\u00010\fH\u0002J\u0013\u0010\u0001\u001a\u00020:2\b\u0010<\u001a\u0004\u0018\u00010/H\u0002J\u0013\u0010\u0001\u001a\u00020:2\b\u0010<\u001a\u0004\u0018\u00010/H\u0002J,\u0010\u0001\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00132\u0019\u0010\u0001\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u000106\u0018\u00010\nH\u0002J\u0007\u0010\u0001\u001a\u00020:J\u0011\u0010\u0001\u001a\u00020:2\b\u0010\u0001\u001a\u00030\u0001J\u0011\u0010\u0001\u001a\u00020:2\b\u0010\u0001\u001a\u00030\u0001J\u000f\u0010\u0001\u001a\u00020:2\u0006\u0010F\u001a\u00020\fJ\u0012\u0010\u0001\u001a\u00020:2\u0007\u0010\u0001\u001a\u00020\rH\u0016J\t\u0010\u0001\u001a\u00020:H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R8\u0010\t\u001a,\u0012(\u0012&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\n0\u0007X\u0004¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\"0\u0012X\u0004¢\u0006\u0002\n\u0000R \u0010#\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0$0\u0012X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f0\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010)\u001a\u00020*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u0006£\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderRedDotManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "storage", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;)V", "careExptKey", "", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "ctrlInfoAtPathFilterList", "Lkotlin/Pair;", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "", "disposeRedDotAtPathIgnoreList", "enterSource", "", "enterTabTipsExtInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$EnterTabTipsExtInfo;", "enterTime", "", "entryConfigChangeListener", "com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$entryConfigChangeListener$1", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$entryConfigChangeListener$1;", "hasRedDotWhenEnter", "msgRedDotHandler", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderMsgRedDotHandler;", "getMsgRedDotHandler", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderMsgRedDotHandler;", "newTipsTransform", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderNewTipsTransform;", "noFoundRevokeIdSet", "Lcom/tencent/mm/protocal/protobuf/FinderRevokeTabTipsInfo;", "pathToCtrInfoMap", "", "revokeIdToCtrInfoMap", "stateCacheVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "stayDuration", "transform", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform;", "getTransform", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform;", "addNewRedDotCtrlInfo", "info", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotCtrlInfo;", "source", "changePathSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "isClearOldSameType", "clearedEntrancePair", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "buildPathWithCtrInfo", ImagesContract.LOCAL, "checkRedDotOverride", "", "path", "ctrlInfo", "lastCtrlInfo", "lastShowInfo", "clearCtrlInfo", "ctrInfo", "type", "filter", "Lkotlin/ParameterName;", "name", "clearEnterTabTipsExtInfo", "enterCtrlInfo", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;", "containsTabTipsExtInfo", "tabType", "ctrlInfoAtPath", "disposeRedDotAtPath", "call", "ctrlType", "", "enterFinder", "exitFinder", "exitFinderBefore", "filterNotifyTabTip", "tabTip", "Lcom/tencent/mm/protocal/protobuf/FinderTabTipsInfo;", "findByRevokeId", "revokeId", "findExtInfoAtCtrlInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowEntranceExtInfo;", "generateFullScreenRedDot", "getAliveTabType", "getAllCtrlInfo", "", "getCtrlInfoByPath", "getCtrlInfoMap", "Ljava/util/HashMap;", "Ljava/util/LinkedList;", "Lkotlin/collections/HashMap;", "getDiffExitTimeMs", "getEnterTabTipsExtInfo", "getEnterTabTypeInCtrlInfo", "getLastCtrlInfo", "ctrlInfoMap", "getLatestCtrlInfo", "ctrlInfo1", "ctrlInfo2", "getNearbyAliveTabType", "getNearbyDiffExitTimeMs", "getTabPathByTabType", "getTabTipsExtInfo", "getTabTypeByPath", "getTipsShowInfoAtPath", "increaseRedDotExpose", "insertDataForTest", "count", "isEnableShowEntranceRedDot", "mergeFinderMentionCtrlInfo", "notifyFinderFansAddCount", "notifyFinderMsgCount", "likeCount", "commentCount", "followCount", "notifyRedDot", "redDot", "Lcom/tencent/mm/protocal/protobuf/FinderRedDot;", "notifyTabTip", "tabTips", "Lcom/tencent/mm/protocal/protobuf/FinderTabTips;", "notifyWxMentionCount", "wxMention", "Lcom/tencent/mm/protocal/protobuf/FinderWxMentionCount;", "onExptChange", "key", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "prepare", "printCtrInfo", "printTipsShowInfo", FirebaseAnalytics.b.INDEX, "reBuildPathWithCtrInfo", "recordCtrlInfo", "clearedCtrlInfo", "removeFinderEntrance", "removeNearbyEntrance", "reportOverride", "beforePair", "resetNotifyAllPathWithCrlInfo", "revokePathRedDot", "revoke", "Lcom/tencent/mm/protocal/protobuf/FinderRevokePathRedDot;", "revokeTabTips", "Lcom/tencent/mm/protocal/protobuf/FinderRevokeTabTips;", "saveEnterTabTipsExtInfo", "setEnableShowEntranceRedDot", "isEnable", "updateFindMoreFriendUI", "Companion", "EnterTabTipsExtInfo", "FinderTipsShowTabExt", "plugin-finder_release"})
public final class f implements com.tencent.mm.ak.i, com.tencent.mm.plugin.i.a.z {
    private static boolean tJO;
    public static final a tJP = new a((byte) 0);
    private final List<kotlin.g.a.b<k, Boolean>> UIf;
    private final List<kotlin.o<kotlin.g.a.b<k, Boolean>, kotlin.g.a.b<k, Boolean>>> UIg;
    private long enterTime;
    public final j tJA = new j(this);
    public final a tJB = new a(this);
    private final b tJC = new b(this);
    private final FinderHomeTabStateVM tJD;
    private final List<b.a> tJE;
    private final l tJF;
    private long tJG;
    private int tJH;
    private boolean tJI;
    public final ConcurrentHashMap<String, List<k>> tJJ;
    private final ConcurrentHashMap<String, k> tJK;
    private final ConcurrentHashMap<String, b> tJL;
    private final ConcurrentHashMap<String, bbr> tJM;
    public final c tJN;

    static {
        AppMethodBeat.i(178166);
        AppMethodBeat.o(178166);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "_info", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
    static final class aa extends kotlin.g.b.q implements kotlin.g.a.b<k, Boolean> {
        public static final aa UIj = new aa();

        static {
            AppMethodBeat.i(260223);
            AppMethodBeat.o(260223);
        }

        aa() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0048, code lost:
            if (r0 != false) goto L_0x004a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x004a, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x002b, code lost:
            if (r0 == false) goto L_0x002d;
         */
        @Override // kotlin.g.a.b
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ java.lang.Boolean invoke(com.tencent.mm.plugin.finder.extension.reddot.k r6) {
            /*
                r5 = this;
                r4 = 260222(0x3f87e, float:3.64649E-40)
                r2 = 1
                r1 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                com.tencent.mm.plugin.finder.extension.reddot.k r6 = (com.tencent.mm.plugin.finder.extension.reddot.k) r6
                java.lang.String r0 = "_info"
                kotlin.g.b.p.h(r6, r0)
                com.tencent.mm.protocal.protobuf.bbi r0 = r6.field_ctrInfo
                int r0 = r0.type
                r3 = 1015(0x3f7, float:1.422E-42)
                if (r0 != r3) goto L_0x002d
                java.lang.String r0 = com.tencent.mm.model.z.aUg()
                java.lang.String r3 = "ConfigStorageLogic.getMyFinderUsername()"
                kotlin.g.b.p.g(r0, r3)
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                int r0 = r0.length()
                if (r0 <= 0) goto L_0x0053
                r0 = r2
            L_0x002b:
                if (r0 != 0) goto L_0x004a
            L_0x002d:
                com.tencent.mm.protocal.protobuf.bbi r0 = r6.field_ctrInfo
                int r0 = r0.type
                r3 = 1016(0x3f8, float:1.424E-42)
                if (r0 != r3) goto L_0x0057
                java.lang.String r0 = com.tencent.mm.model.z.aUg()
                java.lang.String r3 = "ConfigStorageLogic.getMyFinderUsername()"
                kotlin.g.b.p.g(r0, r3)
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                int r0 = r0.length()
                if (r0 != 0) goto L_0x0055
                r0 = r2
            L_0x0048:
                if (r0 == 0) goto L_0x0057
            L_0x004a:
                r0 = r2
            L_0x004b:
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                return r0
            L_0x0053:
                r0 = r1
                goto L_0x002b
            L_0x0055:
                r0 = r1
                goto L_0x0048
            L_0x0057:
                r0 = r1
                goto L_0x004b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.extension.reddot.f.aa.invoke(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "_info", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
    static final class ab extends kotlin.g.b.q implements kotlin.g.a.b<k, Boolean> {
        public static final ab UIk = new ab();

        static {
            AppMethodBeat.i(260225);
            AppMethodBeat.o(260225);
        }

        ab() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(k kVar) {
            Integer num;
            boolean z = false;
            AppMethodBeat.i(260224);
            k kVar2 = kVar;
            kotlin.g.b.p.h(kVar2, "_info");
            bbi bbi = kVar2.field_ctrInfo;
            if (bbi == null || bbi.MQX != 0) {
                bbi bbi2 = kVar2.field_ctrInfo;
                if ((bbi2 != null ? bbi2.MQX : 0) <= cl.aWB()) {
                    z = true;
                }
            }
            StringBuilder append = new StringBuilder("[ctrlInfoAtPathFillterList] redPack fill result:").append(z).append(" , starttime:");
            bbi bbi3 = kVar2.field_ctrInfo;
            if (bbi3 != null) {
                num = Integer.valueOf(bbi3.MQX);
            } else {
                num = null;
            }
            Log.i("Finder.RedDotManager", append.append(num).append(", currentTime:").append(cl.aWB()).toString());
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(260224);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
    static final class ac extends kotlin.g.b.q implements kotlin.g.a.b<k, Boolean> {
        public static final ac UIl = new ac();

        static {
            AppMethodBeat.i(260227);
            AppMethodBeat.o(260227);
        }

        ac() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(k kVar) {
            AppMethodBeat.i(260226);
            k kVar2 = kVar;
            kotlin.g.b.p.h(kVar2, LocaleUtil.ITALIAN);
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.ad.class);
            kotlin.g.b.p.g(af, "MMKernel.service(IFinder…enModeConfig::class.java)");
            boolean z = ((com.tencent.mm.plugin.i.a.ad) af).dxX() && kVar2.field_ctrInfo.type != 8;
            if (z) {
                Log.i("Finder.RedDotManager", "[disposeRedDotAtPathIgnoreList]  match,青少年模式且只看关注的模式下只dispose关注的红点展示, ctrlType:" + kVar2.field_ctrInfo.type);
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(260226);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
    static final class ad extends kotlin.g.b.q implements kotlin.g.a.b<k, Boolean> {
        public static final ad UIm = new ad();

        static {
            AppMethodBeat.i(260229);
            AppMethodBeat.o(260229);
        }

        ad() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0048, code lost:
            if (r0 != false) goto L_0x004a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x004a, code lost:
            r0 = r7.field_ctrInfo;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x004c, code lost:
            if (r0 == null) goto L_0x0052;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0050, code lost:
            if (r0.MQX == 0) goto L_0x008b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0052, code lost:
            r0 = r7.field_ctrInfo;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0054, code lost:
            if (r0 == null) goto L_0x0089;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0056, code lost:
            r0 = r0.MQX;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x005c, code lost:
            if (r0 < com.tencent.mm.model.cl.aWB()) goto L_0x008b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x005e, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0089, code lost:
            r0 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x002b, code lost:
            if (r0 == false) goto L_0x002d;
         */
        @Override // kotlin.g.a.b
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ java.lang.Boolean invoke(com.tencent.mm.plugin.finder.extension.reddot.k r7) {
            /*
            // Method dump skipped, instructions count: 141
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.extension.reddot.f.ad.invoke(java.lang.Object):java.lang.Object");
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
    public static final class d extends kotlin.g.b.q implements kotlin.g.a.b<bdo, Boolean> {
        public static final d tJU = new d();

        static {
            AppMethodBeat.i(243539);
            AppMethodBeat.o(243539);
        }

        d() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(bdo bdo) {
            AppMethodBeat.i(243538);
            Boolean valueOf = Boolean.valueOf(kotlin.g.b.p.j(bdo.path, "Discovery"));
            AppMethodBeat.o(243538);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$buildPathWithCtrInfo$1$1"})
    public static final class e extends kotlin.g.b.q implements kotlin.g.a.b<k, Boolean> {
        final /* synthetic */ f tJV;
        final /* synthetic */ k tJW;
        final /* synthetic */ HashSet tJX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(f fVar, k kVar, HashSet hashSet) {
            super(1);
            this.tJV = fVar;
            this.tJW = kVar;
            this.tJX = hashSet;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(k kVar) {
            AppMethodBeat.i(178150);
            k kVar2 = kVar;
            kotlin.g.b.p.h(kVar2, LocaleUtil.ITALIAN);
            Boolean valueOf = Boolean.valueOf(kotlin.g.b.p.j(kVar2.field_tipsId, this.tJW.field_tipsId));
            AppMethodBeat.o(178150);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.finder.extension.reddot.f$f  reason: collision with other inner class name */
    public static final class C1114f extends kotlin.g.b.q implements kotlin.g.a.b<k, Integer> {
        public static final C1114f tJY = new C1114f();

        static {
            AppMethodBeat.i(178152);
            AppMethodBeat.o(178152);
        }

        C1114f() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Integer invoke(k kVar) {
            AppMethodBeat.i(178151);
            k kVar2 = kVar;
            kotlin.g.b.p.h(kVar2, LocaleUtil.ITALIAN);
            Integer valueOf = Integer.valueOf(kVar2.field_ctrInfo.priority);
            AppMethodBeat.o(178151);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
    public static final class g extends kotlin.g.b.q implements kotlin.g.a.b<k, Long> {
        public static final g tJZ = new g();

        static {
            AppMethodBeat.i(178154);
            AppMethodBeat.o(178154);
        }

        g() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Long invoke(k kVar) {
            AppMethodBeat.i(178153);
            k kVar2 = kVar;
            kotlin.g.b.p.h(kVar2, LocaleUtil.ITALIAN);
            Long valueOf = Long.valueOf(kVar2.field_time);
            AppMethodBeat.o(178153);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$clearCtrlInfo$1$1"})
    public static final class h extends kotlin.g.b.q implements kotlin.g.a.b<k, Boolean> {
        final /* synthetic */ f tJV;
        final /* synthetic */ k tKa;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(f fVar, k kVar) {
            super(1);
            this.tJV = fVar;
            this.tKa = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(k kVar) {
            AppMethodBeat.i(243540);
            k kVar2 = kVar;
            kotlin.g.b.p.h(kVar2, LocaleUtil.ITALIAN);
            Boolean valueOf = Boolean.valueOf(kotlin.g.b.p.j(kVar2.field_tipsId, this.tKa.field_tipsId));
            AppMethodBeat.o(243540);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
    public static final class i extends kotlin.g.b.q implements kotlin.g.a.b<k, Boolean> {
        public static final i tKb = new i();

        static {
            AppMethodBeat.i(243542);
            AppMethodBeat.o(243542);
        }

        i() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(k kVar) {
            AppMethodBeat.i(243541);
            kotlin.g.b.p.h(kVar, LocaleUtil.ITALIAN);
            Boolean bool = Boolean.TRUE;
            AppMethodBeat.o(243541);
            return bool;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
    public static final class j extends kotlin.g.b.q implements kotlin.g.a.b<k, Boolean> {
        final /* synthetic */ Map.Entry tIa;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(Map.Entry entry) {
            super(1);
            this.tIa = entry;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(k kVar) {
            boolean z;
            AppMethodBeat.i(243543);
            k kVar2 = kVar;
            kotlin.g.b.p.h(kVar2, LocaleUtil.ITALIAN);
            if (((LinkedList) this.tIa.getValue()).indexOf(kVar2) >= 0) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(243543);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "ctrlInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
    public static final class k extends kotlin.g.b.q implements kotlin.g.a.b<k, Boolean> {
        final /* synthetic */ int[] tKc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(int[] iArr) {
            super(1);
            this.tKc = iArr;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(k kVar) {
            boolean z;
            AppMethodBeat.i(243544);
            k kVar2 = kVar;
            kotlin.g.b.p.h(kVar2, "ctrlInfo");
            if (this.tKc == null || kotlin.a.e.contains(this.tKc, kVar2.field_ctrInfo.type)) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(243544);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
    public static final class m extends kotlin.g.b.q implements kotlin.g.a.b<bdo, Boolean> {
        public static final m tKd = new m();

        static {
            AppMethodBeat.i(243547);
            AppMethodBeat.o(243547);
        }

        m() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(bdo bdo) {
            AppMethodBeat.i(243546);
            Boolean valueOf = Boolean.valueOf(kotlin.g.b.p.j(bdo.path, "FinderEntrance"));
            AppMethodBeat.o(243546);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
    public static final class n extends kotlin.g.b.q implements kotlin.g.a.b<k, Boolean> {
        public static final n tKe = new n();

        static {
            AppMethodBeat.i(243549);
            AppMethodBeat.o(243549);
        }

        n() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(k kVar) {
            AppMethodBeat.i(243548);
            kotlin.g.b.p.h(kVar, LocaleUtil.ITALIAN);
            Boolean bool = Boolean.TRUE;
            AppMethodBeat.o(243548);
            return bool;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
    public static final class o extends kotlin.g.b.q implements kotlin.g.a.b<k, Boolean> {
        public static final o tKf = new o();

        static {
            AppMethodBeat.i(243551);
            AppMethodBeat.o(243551);
        }

        o() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(k kVar) {
            AppMethodBeat.i(243550);
            kotlin.g.b.p.h(kVar, LocaleUtil.ITALIAN);
            Boolean bool = Boolean.TRUE;
            AppMethodBeat.o(243550);
            return bool;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
    static final class q extends kotlin.g.b.q implements kotlin.g.a.b<bdo, Boolean> {
        public static final q tKg = new q();

        static {
            AppMethodBeat.i(178161);
            AppMethodBeat.o(178161);
        }

        q() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(bdo bdo) {
            AppMethodBeat.i(178160);
            Boolean valueOf = Boolean.valueOf(kotlin.g.b.p.j(bdo.path, "Discovery"));
            AppMethodBeat.o(178160);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
    public static final class r extends kotlin.g.b.q implements kotlin.g.a.b<bdo, Boolean> {
        public static final r tKh = new r();

        static {
            AppMethodBeat.i(243554);
            AppMethodBeat.o(243554);
        }

        r() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(bdo bdo) {
            boolean z;
            AppMethodBeat.i(243553);
            String str = bdo.path;
            if (str == null || str.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(243553);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
    public static final class s extends kotlin.g.b.q implements kotlin.g.a.b<bdo, Boolean> {
        public static final s tKi = new s();

        static {
            AppMethodBeat.i(243556);
            AppMethodBeat.o(243556);
        }

        s() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(bdo bdo) {
            AppMethodBeat.i(243555);
            Boolean valueOf = Boolean.valueOf(kotlin.g.b.p.j(bdo.path, "TLFollow"));
            AppMethodBeat.o(243555);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
    public static final class t extends kotlin.g.b.q implements kotlin.g.a.b<bdo, Boolean> {
        public static final t tKj = new t();

        static {
            AppMethodBeat.i(178163);
            AppMethodBeat.o(178163);
        }

        t() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(bdo bdo) {
            AppMethodBeat.i(178162);
            Boolean valueOf = Boolean.valueOf(kotlin.g.b.p.j(bdo.path, "Discovery"));
            AppMethodBeat.o(178162);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
    public static final class u extends kotlin.g.b.q implements kotlin.g.a.b<bdo, Boolean> {
        public static final u tKk = new u();

        static {
            AppMethodBeat.i(243558);
            AppMethodBeat.o(243558);
        }

        u() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(bdo bdo) {
            AppMethodBeat.i(243557);
            Boolean valueOf = Boolean.valueOf(kotlin.g.b.p.j(bdo.path, "FinderEntrance"));
            AppMethodBeat.o(243557);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke"})
    public static final class v extends kotlin.g.b.q implements kotlin.g.a.b<bdo, Boolean> {
        public static final v tKl = new v();

        static {
            AppMethodBeat.i(243560);
            AppMethodBeat.o(243560);
        }

        v() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(bdo bdo) {
            AppMethodBeat.i(243559);
            Boolean valueOf = Boolean.valueOf(kotlin.g.b.p.j(bdo.path, "NearbyEntrance"));
            AppMethodBeat.o(243559);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "ctrlInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$revokePathRedDot$2$2"})
    static final class w extends kotlin.g.b.q implements kotlin.g.a.b<k, Boolean> {
        final /* synthetic */ f tJV;
        final /* synthetic */ bbp tKm;
        final /* synthetic */ z.a tKn;
        final /* synthetic */ z.a tKo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w(bbp bbp, z.a aVar, z.a aVar2, f fVar) {
            super(1);
            this.tKm = bbp;
            this.tKn = aVar;
            this.tKo = aVar2;
            this.tJV = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(k kVar) {
            AppMethodBeat.i(243561);
            k kVar2 = kVar;
            kotlin.g.b.p.h(kVar2, "ctrlInfo");
            boolean contains = this.tKm.LKW.contains(kVar2.field_tipsId);
            if (!contains) {
                this.tKn.SYB = false;
            } else {
                this.tKo.SYB = true;
            }
            if (contains) {
                this.tJV.b(kVar2.field_ctrInfo, "revokePathRedDot#1");
            }
            Boolean valueOf = Boolean.valueOf(contains);
            AppMethodBeat.o(243561);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "_info", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
    static final class y extends kotlin.g.b.q implements kotlin.g.a.b<k, Boolean> {
        public static final y UIh = new y();

        static {
            AppMethodBeat.i(260219);
            AppMethodBeat.o(260219);
        }

        y() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(k kVar) {
            AppMethodBeat.i(260218);
            kotlin.g.b.p.h(kVar, "_info");
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.ad.class);
            kotlin.g.b.p.g(af, "MMKernel.service(IFinder…enModeConfig::class.java)");
            Boolean valueOf = Boolean.valueOf(((com.tencent.mm.plugin.i.a.ad) af).dxX());
            AppMethodBeat.o(260218);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "_info", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke"})
    static final class z extends kotlin.g.b.q implements kotlin.g.a.b<k, Boolean> {
        public static final z UIi = new z();

        static {
            AppMethodBeat.i(260221);
            AppMethodBeat.o(260221);
        }

        z() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(k kVar) {
            AppMethodBeat.i(260220);
            k kVar2 = kVar;
            kotlin.g.b.p.h(kVar2, "_info");
            boolean z = kVar2.field_ctrInfo.type == 8;
            Log.i("Finder.RedDotManager", "[ctrlInfoAtPathFillterList] teenMode fill reslut:".concat(String.valueOf(z)));
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(260220);
            return valueOf;
        }
    }

    public f(c cVar) {
        kotlin.g.b.p.h(cVar, "storage");
        AppMethodBeat.i(178184);
        this.tJN = cVar;
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
        kotlin.g.b.p.g(viewModel, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
        this.tJD = (FinderHomeTabStateVM) viewModel;
        this.tJE = kotlin.a.j.listOf(b.a.clicfg_finder_3_day_2_day_enable);
        this.tJF = new l(this);
        this.tJJ = new ConcurrentHashMap<>();
        this.tJK = new ConcurrentHashMap<>();
        this.UIf = kotlin.a.j.listOf((Object[]) new kotlin.g.a.b[]{ac.UIl, ad.UIm});
        this.UIg = kotlin.a.j.listOf((Object[]) new kotlin.o[]{new kotlin.o(y.UIh, z.UIi), new kotlin.o(aa.UIj, ab.UIk)});
        this.tJL = new ConcurrentHashMap<>();
        this.tJM = new ConcurrentHashMap<>();
        AppMethodBeat.o(178184);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$Companion;", "", "()V", "TAB_TIPS_TEST", "", "getTAB_TIPS_TEST", "()Z", "setTAB_TIPS_TEST", "(Z)V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$entryConfigChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class l extends IListener<fp> {
        final /* synthetic */ f tJV;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        l(f fVar) {
            this.tJV = fVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(fp fpVar) {
            AppMethodBeat.i(243545);
            kotlin.g.b.p.h(fpVar, "event");
            for (b.a aVar : this.tJV.tJE) {
                f.c(aVar);
            }
            AppMethodBeat.o(243545);
            return false;
        }
    }

    public final void prepare() {
        AppMethodBeat.i(178168);
        if (!MMApplicationContext.isMainProcess()) {
            AppMethodBeat.o(178168);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        LinkedList<k> daw = this.tJN.daw();
        int size = daw.size();
        d dVar = d.tJq;
        Log.i("Finder.RedDotManager", "[prepare] checkRet=" + d.a(daw, this.tJN) + " beforeCheckCount=" + size + " afterCheckCount=" + daw.size());
        for (T t2 : daw) {
            if (t2.dbz()) {
                Log.w("Finder.RedDotManager", "[prepare] showInfo is empty! ".concat(String.valueOf(t2)));
                t2.b(this.tJN, false);
            } else {
                bbi bbi = ((k) t2).field_ctrInfo;
                kotlin.g.b.p.g(bbi, "it.field_ctrInfo");
                a(t2.f(bbi), "prepare");
            }
        }
        this.tJF.alive();
        com.tencent.mm.plugin.newtips.a.exk().a("FinderNewTipsTransform", this.tJC);
        j jVar = this.tJA;
        k asX = jVar.tJh.asX("FinderEntrance");
        if (asX != null && asX.field_ctrInfo.type == -1) {
            bdo atl = asX.atl("FinderEntrance");
            Integer valueOf = atl != null ? Integer.valueOf(atl.LNm) : null;
            if (valueOf != null && valueOf.intValue() == 2) {
                jVar.tJh.Iy(-1);
                Log.i("Finder.RedDotTransform", "[checkPostRedDot] has old post red dot, ret=".concat(String.valueOf(kotlin.x.SXb)));
                jVar.dbr();
            }
        }
        jVar.tJh.Iy(1001);
        Log.i("Finder.RedDotTransform", "[checkPostRedDot] has old fav red dot, ret=".concat(String.valueOf(kotlin.x.SXb)));
        Iy(1005);
        m mVar = m.tLw;
        kotlin.g.b.p.h(this, "redDotManager");
        m.toy = this;
        Log.i("Finder.ThreeDayTwoDay", TMAssistantDownloadSDKClientBase.CONNTECTSTATE_INIT);
        mVar.dbW();
        e eVar = new e(this);
        eVar.tJr.alive();
        com.tencent.mm.ac.d.h(new e.f(eVar));
        e.a(eVar, "setup");
        Log.i("Finder.RedDotManager", "[prepare] " + (System.currentTimeMillis() - currentTimeMillis) + LocaleUtil.MALAY);
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        if (com.tencent.mm.plugin.finder.utils.y.dCR() == 1) {
            Log.i("Finder.RedDotManager", "FINDER_GLOBAL_FULLSCREEN_ENJOY");
            l lVar = l.tLu;
            if (!l.dbN()) {
                Log.i("Finder.RedDotManager", "fullScreenTabShowed showed");
                Log.i("Finder.RedDotManager", "generateFullScreenRedDot");
                bbi bbi2 = new bbi();
                bbi2.LKM = String.valueOf(cl.aWA());
                bbi2.priority = 10011000;
                bbi2.type = 1012;
                bbi2.pRN = 604800;
                bbj bbj = new bbj();
                bdi bdi = new bdi();
                bdi.LNf = 7;
                bbj.tabTipsByPassInfo = new com.tencent.mm.bw.b(bdi.toByteArray());
                bbj.tab_type = 4;
                bbi2.LKL = new com.tencent.mm.bw.b(bbj.toByteArray());
                bdo bdo = new bdo();
                bdo.xGz = 6;
                bdo.title = "NEW";
                bdo.LNm = 1;
                bdo.path = "finder_tl_hot_tab";
                bbi2.GaM.add(bdo);
                a(this, bbi2, "generateFullScreenRedDot", null, true, null, 20);
                l lVar2 = l.tLu;
                l.mU(true);
            }
        }
        AppMethodBeat.o(178168);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    public static final class p<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(243552);
            int a2 = kotlin.b.a.a(Long.valueOf(((k) t).field_time), Long.valueOf(((k) t2).field_time));
            AppMethodBeat.o(243552);
            return a2;
        }
    }

    @Override // com.tencent.mm.plugin.i.a.z
    public final void daA() {
        k asX;
        bdo atl;
        AppMethodBeat.i(178169);
        m mVar = m.tLw;
        Log.i("Finder.ThreeDayTwoDay", "enterFindMoreFriendTab");
        if (mVar.dbV()) {
            f fVar = m.toy;
            if (!(fVar == null || (asX = fVar.asX("FinderEntrance")) == null || (atl = asX.atl("FinderEntrance")) == null)) {
                com.tencent.mm.plugin.finder.report.j.a(com.tencent.mm.plugin.finder.report.j.vft, "1", asX, atl, 4);
            }
            f fVar2 = m.toy;
            if (fVar2 != null) {
                fVar2.asV("FinderEntrance");
                AppMethodBeat.o(178169);
                return;
            }
        }
        AppMethodBeat.o(178169);
    }

    public final void Iw(int i2) {
        AppMethodBeat.i(178170);
        k asX = asX("FinderEntrance");
        if (asX == null || asX.atl("FinderEntrance") == null) {
            this.tJI = false;
        } else {
            this.tJI = true;
            b(asX);
        }
        this.tJH = i2;
        this.enterTime = cl.aWA();
        asV("FinderEntrance");
        asV("Discovery");
        m mVar = m.tLw;
        Log.i("Finder.ThreeDayTwoDay", "enterFinder");
        m.dbX();
        this.tJA.dbq();
        Log.i("Finder.RedDotManager", "[enterFinder] hasRedDotWhenEnter=" + this.tJI);
        AppMethodBeat.o(178170);
    }

    public final void daB() {
        AppMethodBeat.i(243563);
        asV("FinderEntrance");
        asV("Discovery");
        AppMethodBeat.o(243563);
    }

    public final void daC() {
        AppMethodBeat.i(243564);
        this.tJG = cl.aWA() - this.enterTime;
        if (this.tJI && this.tJH == 2) {
            long j2 = this.tJG;
            l lVar = l.tLu;
            if (j2 <= l.dbI()) {
                l lVar2 = l.tLu;
                int na = kotlin.k.j.na(l.dbM() + 1, 3);
                Log.w("Finder.RedDotManager", "[exitFinder] current fastLevel=".concat(String.valueOf(na)));
                l lVar3 = l.tLu;
                l.ID(na);
                l lVar4 = l.tLu;
                l.dbQ();
                AppMethodBeat.o(243564);
            }
        }
        long j3 = this.tJG;
        l lVar5 = l.tLu;
        if (j3 > l.dbI()) {
            Log.w("Finder.RedDotManager", "[exitFinder] revert fastLevel=0");
            l lVar6 = l.tLu;
            l.ID(0);
        }
        l lVar42 = l.tLu;
        l.dbQ();
        AppMethodBeat.o(243564);
    }

    public final void a(bbh bbh) {
        LinkedList<bdo> linkedList;
        AppMethodBeat.i(178171);
        kotlin.g.b.p.h(bbh, "redDot");
        long aWA = cl.aWA();
        l lVar = l.tLu;
        long dbO = aWA - l.dbO();
        Log.i("Finder.RedDotManager", "[notifyRedDot] diffTime=" + dbO + " newMsgTipsEnterInterval=" + l.tLu.dbH() + " showRed=" + bbh.LKI + ' ' + c(bbh.LKJ));
        if (dbO < l.tLu.dbH()) {
            d(bbh.LKJ);
            bbi bbi = bbh.LKJ;
            if (!(bbi == null || (linkedList = bbi.GaM) == null)) {
                com.tencent.mm.ac.d.a((LinkedList) linkedList, (kotlin.g.a.b) q.tKg);
            }
        }
        LinkedList<bbi> linkedList2 = bbh.LKK;
        kotlin.g.b.p.g(linkedList2, "redDot.ctrl_info_list");
        for (T t2 : linkedList2) {
            if (t2.type == 2) {
                kotlin.g.b.p.g(t2, LocaleUtil.ITALIAN);
                a((bbi) t2);
            }
            a(this, t2, "notifyRedDot", null, true, null, 20);
        }
        AppMethodBeat.o(178171);
    }

    public final void a(bbi bbi) {
        boolean z2;
        bdo bdo;
        AppMethodBeat.i(243565);
        Log.i("Finder.RedDotManager", "mergeFinderMentionCtrlInfo enter:" + bbi.type);
        k j2 = j(b(2, o.tKf));
        Log.i("Finder.RedDotManager", "mergeFinderMentionCtrlInfo :" + (j2 != null ? Integer.valueOf(j2.field_ctrInfo.type) : null));
        if (j2 != null) {
            Set<String> keySet = j2.tLk.keySet();
            kotlin.g.b.p.g(keySet, "showInfoMap.keys");
            Set<String> set = keySet;
            synchronized (set) {
                try {
                    for (T t2 : set) {
                        LinkedList<bdo> linkedList = bbi.GaM;
                        kotlin.g.b.p.g(linkedList, "ctrlInfo.show_infos");
                        LinkedList<bdo> linkedList2 = linkedList;
                        if (!(linkedList2 instanceof Collection) || !linkedList2.isEmpty()) {
                            Iterator<T> it = linkedList2.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (kotlin.g.b.p.j(it.next().path, t2)) {
                                        z2 = false;
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                        z2 = true;
                        if (z2 && (bdo = j2.tLk.get(t2)) != null) {
                            bbi.GaM.add(bdo);
                        }
                    }
                    kotlin.x xVar = kotlin.x.SXb;
                } finally {
                    AppMethodBeat.o(243565);
                }
            }
            return;
        }
        AppMethodBeat.o(243565);
    }

    private static long daD() {
        AppMethodBeat.i(243566);
        long aWA = cl.aWA();
        l lVar = l.tLu;
        long dbO = aWA - l.dbO();
        AppMethodBeat.o(243566);
        return dbO;
    }

    private static long daE() {
        AppMethodBeat.i(243567);
        long aWA = cl.aWA();
        l lVar = l.tLu;
        long dbP = aWA - l.dbP();
        AppMethodBeat.o(243567);
        return dbP;
    }

    public static /* synthetic */ k a(f fVar, bbi bbi, String str, HashSet hashSet, boolean z2, kotlin.o oVar, int i2) {
        HashSet hashSet2;
        boolean z3;
        AppMethodBeat.i(243569);
        if ((i2 & 4) != 0) {
            hashSet2 = new HashSet();
        } else {
            hashSet2 = hashSet;
        }
        if ((i2 & 8) != 0) {
            z3 = true;
        } else {
            z3 = z2;
        }
        k a2 = fVar.a(bbi, str, hashSet2, z3, (i2 & 16) != 0 ? null : oVar);
        AppMethodBeat.o(243569);
        return a2;
    }

    private k a(bbi bbi, String str, HashSet<String> hashSet, boolean z2, kotlin.o<k, ? extends bdo> oVar) {
        A a2;
        A a3;
        B atl;
        A a4;
        String str2;
        String str3;
        boolean z3;
        f fVar;
        AppMethodBeat.i(243568);
        kotlin.g.b.p.h(str, "source");
        kotlin.g.b.p.h(hashSet, "changePathSet");
        if (bbi == null) {
            AppMethodBeat.o(243568);
            return null;
        }
        if (oVar != null) {
            a2 = oVar.first;
        } else {
            a2 = null;
        }
        k kVar = null;
        if (bbi != null) {
            LinkedList<bdo> linkedList = bbi.GaM;
            kotlin.g.b.p.g(linkedList, "show_infos");
            Iterator<T> it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (kotlin.g.b.p.j("FinderEntrance", it.next().path)) {
                    k asX = asX("FinderEntrance");
                    if (!kotlin.g.b.p.j(asX, a2) && a2 != null) {
                        if (asX == null) {
                            asX = a2;
                        } else if (asX.field_ctrInfo.priority < ((k) a2).field_ctrInfo.priority || (asX.field_ctrInfo.priority == asX.field_ctrInfo.priority && asX.field_time < ((k) a2).field_time)) {
                            asX = a2;
                        }
                    }
                    kVar = asX;
                }
            }
        }
        if (oVar != null) {
            a3 = oVar.first;
        } else {
            a3 = null;
        }
        if (kotlin.g.b.p.j(kVar, a3)) {
            atl = oVar != null ? oVar.second : null;
        } else {
            atl = kVar != null ? kVar.atl("FinderEntrance") : null;
        }
        if (z2) {
            Iy(bbi.type);
        }
        if (!daH()) {
            LinkedList<bdo> linkedList2 = bbi.GaM;
            kotlin.g.b.p.g(linkedList2, "info.show_infos");
            com.tencent.mm.ac.d.a((LinkedList) linkedList2, (kotlin.g.a.b) d.tJU);
            Log.i("Finder.RedDotManager", "[addNewRedDotCtrlInfo] remove DISCOVERY_TAB");
        }
        k f2 = new k().f(bbi);
        ConcurrentHashMap<String, bbr> concurrentHashMap = this.tJM;
        String str4 = f2.field_revokeId;
        if (str4 == null) {
            str4 = "";
        }
        if (concurrentHashMap.contains(str4)) {
            Log.e("Finder.RedDotManager", "[addNewRedDotCtrlInfo] has revoke. " + f2.field_revokeId + ' ' + c(f2.field_ctrInfo));
            AppMethodBeat.o(243568);
            return null;
        } else if (k.a(f2, this.tJN)) {
            hashSet.addAll(a(f2, str));
            kotlin.o oVar2 = new kotlin.o(kVar, atl);
            kotlin.o<k, bdo> atb = atb("FinderEntrance");
            if (atb != null) {
                a4 = atb.first;
            } else {
                a4 = null;
            }
            A a5 = oVar2.first;
            B b2 = oVar2.second;
            if (Util.isNullOrNil("FinderEntrance")) {
                Log.e("Finder.RedDotManager", "path: " + "FinderEntrance" + " is empty!");
            } else if (a5 != null && (!kotlin.g.b.p.j(a5, a4))) {
                StringBuilder append = new StringBuilder("20951, ").append(((k) a5).field_ctrInfo.type).append(" show_type:").append(b2 != null ? Integer.valueOf(b2.xGz) : null).append(" field_tipsId: ").append(((k) a5).field_tipsId).append(" ctrlInfo.field_tipsId: ");
                if (a4 != null) {
                    str2 = ((k) a4).field_tipsId;
                } else {
                    str2 = null;
                }
                Log.i("Finder.RedDotManager", append.append(str2).toString());
                com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                if (!(a5 == null || b2 == null)) {
                    com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                    if (a4 == null || (str3 = ((k) a4).field_tipsId) == null) {
                        str3 = "";
                    }
                    com.tencent.mm.plugin.finder.report.j.a(a5, b2, 6, 0, (String) null, str3, 24);
                }
            }
            m mVar = m.tLw;
            kotlin.g.b.p.h(bbi, "ctrlInfo");
            Log.i("Finder.ThreeDayTwoDay", "checkRedDotFilter");
            if (mVar.dbV()) {
                com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                kotlin.g.b.p.g(aAh, "MMKernel.storage()");
                long a6 = aAh.azQ().a(ar.a.USERINFO_FINDER_THREE_DAY_HIT_TIME_LONG_SYNC, 0);
                if (a6 != 0) {
                    long aWA = cl.aWA() - a6;
                    com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                    int intValue = com.tencent.mm.plugin.finder.storage.c.duK().value().intValue();
                    boolean z4 = ((long) intValue) >= aWA;
                    Log.i("Finder.ThreeDayTwoDay", "[checkInLimitTwoDay] isInLimit=" + z4 + " twoDayThreshold=" + intValue + " diffTime=" + aWA + " hitThreeDayTime=" + a6);
                    if (z4) {
                        z3 = true;
                        if (z3 && (fVar = m.toy) != null) {
                            fVar.asV("FinderEntrance");
                        }
                        AppMethodBeat.o(243568);
                        return f2;
                    }
                    m.reset(cl.aWA());
                }
            }
            z3 = false;
            fVar.asV("FinderEntrance");
            AppMethodBeat.o(243568);
            return f2;
        } else {
            AppMethodBeat.o(243568);
            return null;
        }
    }

    private static k j(HashMap<String, LinkedList<k>> hashMap) {
        k kVar;
        AppMethodBeat.i(243570);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Map.Entry<String, LinkedList<k>> entry : hashMap.entrySet()) {
            LinkedList<k> value = entry.getValue();
            synchronized (value) {
                try {
                    ListIterator<k> listIterator = value.listIterator(value.size());
                    if (listIterator.hasPrevious()) {
                        kVar = listIterator.previous();
                    } else {
                        kVar = null;
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(243570);
                    throw th;
                }
            }
            k kVar2 = kVar;
            if (kVar2 != null) {
                linkedHashSet.add(kVar2);
            }
        }
        kotlin.a.j.a((Iterable) linkedHashSet, (Comparator) new p());
        k kVar3 = (k) kotlin.a.j.h(linkedHashSet);
        AppMethodBeat.o(243570);
        return kVar3;
    }

    public final void e(String str, int[] iArr) {
        AppMethodBeat.i(243571);
        kotlin.g.b.p.h(str, "path");
        i(str, new k(iArr));
        AppMethodBeat.o(243571);
    }

    private void i(String str, kotlin.g.a.b<? super k, Boolean> bVar) {
        T t2;
        String str2 = null;
        AppMethodBeat.i(243572);
        kotlin.g.b.p.h(str, "path");
        kotlin.g.b.p.h(bVar, "call");
        HashSet<String> hashSet = new HashSet();
        k asX = asX(str);
        bdo atl = asX != null ? asX.atl(str) : null;
        List<k> list = this.tJJ.get(str);
        if (list != null) {
            kotlin.g.b.p.g(list, "this");
            synchronized (list) {
                try {
                    Iterator<k> it = list.iterator();
                    while (it.hasNext()) {
                        k next = it.next();
                        Iterator<T> it2 = this.UIf.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                t2 = null;
                                break;
                            }
                            T next2 = it2.next();
                            if (((Boolean) next2.invoke(next)).booleanValue()) {
                                t2 = next2;
                                break;
                            }
                        }
                        if (t2 == null && bVar.invoke(next).booleanValue()) {
                            LinkedList<String> atm = next.atm(str);
                            if (k.a(next, this.tJN)) {
                                hashSet.addAll(atm);
                            }
                            if (next.dbz()) {
                                it.remove();
                            }
                        }
                    }
                    kotlin.x xVar = kotlin.x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(243572);
                    throw th;
                }
            }
        }
        StringBuilder append = new StringBuilder("[disposeRedDotAtPath] path=").append(str).append(" tipsId=");
        if (asX != null) {
            str2 = asX.field_tipsId;
        }
        Log.i("Finder.RedDotManager", append.append(str2).append(" removePathSet=").append(hashSet).append(" maybeRemoveShowInfo=").append(a(atl, 0)).toString());
        for (String str3 : hashSet) {
            k asX2 = asX(str3);
            if (asX2 != null) {
                bdo atl2 = asX2.atl(str3);
                if (atl2 != null) {
                    h hVar = h.tKR;
                    h.a(false, str3, atl, asX);
                    h hVar2 = h.tKR;
                    h.a(true, str3, atl2, asX2);
                } else {
                    h hVar3 = h.tKR;
                    h.a(false, str3, atl, asX);
                }
            } else {
                h hVar4 = h.tKR;
                h.a(false, str3, atl, asX);
            }
        }
        AppMethodBeat.o(243572);
    }

    @Override // com.tencent.mm.plugin.i.a.z
    public final void asV(String str) {
        AppMethodBeat.i(178176);
        kotlin.g.b.p.h(str, "path");
        e(str, null);
        AppMethodBeat.o(178176);
    }

    public final void a(bbi bbi, String str) {
        boolean z2;
        AppMethodBeat.i(243573);
        kotlin.g.b.p.h(bbi, ImagesContract.LOCAL);
        kotlin.g.b.p.h(str, "source");
        int i2 = bbi.type;
        kotlin.o<k, bdo> b2 = b(bbi);
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<k>> entry : this.tJJ.entrySet()) {
            synchronized (entry.getValue()) {
                try {
                    String key = entry.getKey();
                    Iterator<k> it = entry.getValue().iterator();
                    while (it.hasNext()) {
                        k next = it.next();
                        if (next.field_ctrInfo.type == i2) {
                            LinkedList linkedList = (LinkedList) hashMap.get(key);
                            if (linkedList == null) {
                                LinkedList linkedList2 = new LinkedList();
                                hashMap.put(key, linkedList2);
                                linkedList = linkedList2;
                            }
                            kotlin.g.b.p.g(linkedList, "clearMap[path] ?: run {\n…                        }");
                            linkedList.add(next);
                            it.remove();
                        }
                    }
                    kotlin.x xVar = kotlin.x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(243573);
                    throw th;
                }
            }
        }
        if (!hashMap.isEmpty()) {
            Log.i("Finder.RedDotManager", "[reBuildPathWithCtrInfo] type=" + i2 + " clearMap=" + hashMap + " source=" + str);
        }
        for (Map.Entry entry2 : hashMap.entrySet()) {
            for (k kVar : (Iterable) entry2.getValue()) {
                k.b(kVar, this.tJN);
            }
        }
        HashSet<String> hashSet = new HashSet<>();
        a(bbi, str, hashSet, false, b2);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry3 : hashMap.entrySet()) {
            if (!hashSet.contains(entry3.getKey())) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                linkedHashMap.put(entry3.getKey(), entry3.getValue());
            }
        }
        for (Map.Entry entry4 : linkedHashMap.entrySet()) {
            String str2 = (String) entry4.getKey();
            for (k kVar2 : (Iterable) entry4.getValue()) {
                k.b(kVar2, this.tJN);
            }
            k asX = asX(str2);
            if (asX != null) {
                bdo atl = asX.atl(str2);
                if (atl != null) {
                    h hVar = h.tKR;
                    h.a(false, str2, null, null);
                    h hVar2 = h.tKR;
                    h.a(true, str2, atl, asX);
                } else {
                    h hVar3 = h.tKR;
                    h.a(false, str2, null, null);
                }
            } else {
                h hVar4 = h.tKR;
                h.a(false, str2, null, null);
            }
        }
        AppMethodBeat.o(243573);
    }

    private final kotlin.o<k, bdo> b(bbi bbi) {
        AppMethodBeat.i(243574);
        LinkedList<bdo> linkedList = bbi.GaM;
        if (linkedList != null) {
            Iterator<T> it = linkedList.iterator();
            while (it.hasNext()) {
                if (kotlin.g.b.p.j(it.next().path, "FinderEntrance")) {
                    kotlin.o<k, bdo> atb = atb("FinderEntrance");
                    AppMethodBeat.o(243574);
                    return atb;
                }
            }
        }
        AppMethodBeat.o(243574);
        return null;
    }

    public final HashSet<String> a(k kVar, String str) {
        List<k> list;
        AppMethodBeat.i(243575);
        Log.i("Finder.RedDotManager", "[buildPathWithCtrInfo] source=" + str + ' ' + c(kVar.field_ctrInfo) + " revokeId=" + kVar.field_revokeId);
        HashSet<String> hashSet = new HashSet<>();
        for (Map.Entry<String, bdo> entry : kVar.tLk.entrySet()) {
            List<k> list2 = this.tJJ.get(entry.getKey());
            if (list2 == null) {
                list = Collections.synchronizedList(new LinkedList());
                String key = entry.getKey();
                kotlin.g.b.p.g(list, "list");
                this.tJJ.put(key, list);
            } else {
                list = list2;
            }
            kotlin.g.b.p.g(list, "crlInfoList");
            com.tencent.mm.ac.d.a(list, new e(this, kVar, hashSet));
            list.add(kVar);
            kotlin.g.a.b[] bVarArr = {C1114f.tJY, g.tJZ};
            kotlin.g.b.p.h(bVarArr, "selectors");
            kotlin.a.j.a((List) list, (Comparator) new b.a(bVarArr));
            hashSet.add(entry.getKey());
        }
        String str2 = kVar.field_revokeId;
        if (str2 != null) {
            this.tJK.put(str2, kVar);
        }
        for (String str3 : hashSet) {
            k asX = asX(str3);
            bdo atl = asX != null ? asX.atl(str3) : null;
            Log.i("Finder.RedDotManager", "[buildPathWithCtrInfo] ctrlInfo:" + asX + " ,path:" + atl);
            if (!(asX == null || atl == null)) {
                h hVar = h.tKR;
                h.a(true, str3, atl, asX);
            }
        }
        AppMethodBeat.o(243575);
        return hashSet;
    }

    public final bdo asW(String str) {
        AppMethodBeat.i(178178);
        kotlin.g.b.p.h(str, "path");
        k asX = asX(str);
        if (asX != null) {
            bdo atl = asX.atl(str);
            AppMethodBeat.o(178178);
            return atl;
        }
        AppMethodBeat.o(178178);
        return null;
    }

    public final k asX(String str) {
        ArrayList arrayList;
        Object obj;
        boolean z2;
        T t2;
        B b2;
        Boolean bool;
        AppMethodBeat.i(178179);
        kotlin.g.b.p.h(str, "path");
        List<k> list = this.tJJ.get(str);
        if (list != null) {
            List<k> list2 = list;
            synchronized (list2) {
                try {
                    ArrayList arrayList2 = new ArrayList();
                    for (T t3 : list2) {
                        T t4 = t3;
                        Iterator<T> it = this.UIg.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                t2 = null;
                                break;
                            }
                            T next = it.next();
                            if (((Boolean) next.first.invoke(t4)).booleanValue()) {
                                t2 = next;
                                break;
                            }
                        }
                        T t5 = t2;
                        if ((t5 == null || (b2 = t5.second) == null || (bool = (Boolean) b2.invoke(t4)) == null) ? true : bool.booleanValue()) {
                            arrayList2.add(t3);
                        }
                    }
                    arrayList = arrayList2;
                } finally {
                    AppMethodBeat.o(178179);
                }
            }
            synchronized (arrayList) {
                try {
                    ListIterator listIterator = arrayList.listIterator(arrayList.size());
                    while (true) {
                        if (!listIterator.hasPrevious()) {
                            obj = null;
                            break;
                        }
                        Object previous = listIterator.previous();
                        if (((k) previous).atl(str) != null) {
                            z2 = true;
                            continue;
                        } else {
                            z2 = false;
                            continue;
                        }
                        if (z2) {
                            obj = previous;
                            break;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            k kVar = (k) obj;
            AppMethodBeat.o(178179);
            return kVar;
        }
        AppMethodBeat.o(178179);
        return null;
    }

    public static String Ix(int i2) {
        switch (i2) {
            case 1:
                return "TLRecommendTab";
            case 2:
                return "finder_tl_nearby_tab";
            case 3:
                return "TLFollow";
            case 4:
                return "finder_tl_hot_tab";
            case 1001:
                return "NearbyLiveTab";
            case 1002:
                return "NearbyFeedTab";
            case 1003:
                return "NearbyPeopleTab";
            default:
                return "";
        }
    }

    private static int asY(String str) {
        AppMethodBeat.i(243576);
        kotlin.g.b.p.h(str, "path");
        switch (str.hashCode()) {
            case -961813849:
                if (str.equals("NearbyPeopleTab")) {
                    AppMethodBeat.o(243576);
                    return 1003;
                }
                break;
            case -318065288:
                if (str.equals("NearbyFeedTab")) {
                    AppMethodBeat.o(243576);
                    return 1002;
                }
                break;
            case 345890211:
                if (str.equals("finder_tl_nearby_tab")) {
                    AppMethodBeat.o(243576);
                    return 2;
                }
                break;
            case 842235754:
                if (str.equals("NearbyLiveTab")) {
                    AppMethodBeat.o(243576);
                    return 1001;
                }
                break;
            case 1207859273:
                if (str.equals("TLFollow")) {
                    AppMethodBeat.o(243576);
                    return 3;
                }
                break;
            case 1397734293:
                if (str.equals("finder_tl_hot_tab")) {
                    AppMethodBeat.o(243576);
                    return 4;
                }
                break;
            case 1449007057:
                if (str.equals("TLRecommendTab")) {
                    AppMethodBeat.o(243576);
                    return 1;
                }
                break;
        }
        AppMethodBeat.o(243576);
        return -1;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$FinderTipsShowTabExt;", "", "tabType", "", "ext", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowTabExtInfo;", "(ILcom/tencent/mm/protocal/protobuf/FinderTipsShowTabExtInfo;)V", "getExt", "()Lcom/tencent/mm/protocal/protobuf/FinderTipsShowTabExtInfo;", "getTabType", "()I", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "Companion", "plugin-finder_release"})
    public static final class c {
        public static final a tJT = new a((byte) 0);
        final int dLS;
        final bdp tJS;

        static {
            AppMethodBeat.i(243534);
            AppMethodBeat.o(243534);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
            if (kotlin.g.b.p.j(r3.tJS, r4.tJS) != false) goto L_0x001e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 243537(0x3b751, float:3.41268E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x001e
                boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.extension.reddot.f.c
                if (r0 == 0) goto L_0x0023
                com.tencent.mm.plugin.finder.extension.reddot.f$c r4 = (com.tencent.mm.plugin.finder.extension.reddot.f.c) r4
                int r0 = r3.dLS
                int r1 = r4.dLS
                if (r0 != r1) goto L_0x0023
                com.tencent.mm.protocal.protobuf.bdp r0 = r3.tJS
                com.tencent.mm.protocal.protobuf.bdp r1 = r4.tJS
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0023
            L_0x001e:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0022:
                return r0
            L_0x0023:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0022
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.extension.reddot.f.c.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(243536);
            int i2 = this.dLS * 31;
            bdp bdp = this.tJS;
            int hashCode = (bdp != null ? bdp.hashCode() : 0) + i2;
            AppMethodBeat.o(243536);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(243535);
            String str = "FinderTipsShowTabExt(tabType=" + this.dLS + ", ext=" + this.tJS + ")";
            AppMethodBeat.o(243535);
            return str;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$FinderTipsShowTabExt$Companion;", "", "()V", "transform", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$FinderTipsShowTabExt;", "tabType", "", "manager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "plugin-finder_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }

            public static c a(int i2, f fVar) {
                Integer num;
                int i3 = 0;
                byte[] bArr = null;
                AppMethodBeat.i(243532);
                kotlin.g.b.p.h(fVar, "manager");
                String Ix = f.Ix(i2);
                k asX = fVar.asX(Ix);
                bdo atl = asX != null ? asX.atl(Ix) : null;
                bdp bdp = new bdp();
                StringBuilder append = new StringBuilder("[FinderTipsShowTabExt#transform] tabType=").append(i2).append(" path=").append(Ix).append(" show_ext_info_type=");
                if (atl != null) {
                    num = Integer.valueOf(atl.LNn);
                } else {
                    num = null;
                }
                Log.i("Finder.RedDotManager", append.append(num).append(" show_ext_info=").append((atl != null ? atl.LNo : null) != null).toString());
                if (atl != null && atl.LNn == 2 && atl.LNo != null) {
                    com.tencent.mm.bw.b bVar = atl.LNo;
                    if (bVar != null) {
                        bArr = bVar.toByteArray();
                    }
                    bdp.parseFrom(bArr);
                    Log.i("Finder.RedDotManager", "tabType=" + i2 + " serverJumpPriority=" + bdp.LNr);
                } else if (atl != null) {
                    switch (i2) {
                        case 1:
                            i3 = 700000;
                            break;
                        case 3:
                            i3 = 600000;
                            break;
                        case 4:
                            i3 = 500000;
                            break;
                    }
                    bdp.LNr = i3;
                }
                c cVar = new c(i2, bdp);
                AppMethodBeat.o(243532);
                return cVar;
            }
        }

        public c(int i2, bdp bdp) {
            kotlin.g.b.p.h(bdp, "ext");
            AppMethodBeat.i(243533);
            this.dLS = i2;
            this.tJS = bdp;
            AppMethodBeat.o(243533);
        }
    }

    public final int daF() {
        Object obj;
        AppMethodBeat.i(243577);
        long currentTimeMillis = System.currentTimeMillis();
        k asX = asX("FinderEntrance");
        if ((asX != null ? asX.atl("FinderEntrance") : null) == null || asX.atl("finder_private_msg_entrance") != null) {
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.hUR().value().intValue() == 1) {
                Log.i("Finder.RedDotManager", "[getAliveTabType] IS_HARD_JUMP_HOT_WITHOUT_ENTRANCE_REDDOT = true");
                AppMethodBeat.o(243577);
                return 4;
            }
            c.a aVar = c.tJT;
            c a2 = c.a.a(1, this);
            c.a aVar2 = c.tJT;
            c a3 = c.a.a(3, this);
            c.a aVar3 = c.tJT;
            List listOf = kotlin.a.j.listOf((Object[]) new c[]{a2, a3, c.a.a(4, this)});
            Iterator it = listOf.iterator();
            if (!it.hasNext()) {
                obj = null;
            } else {
                Object next = it.next();
                if (!it.hasNext()) {
                    obj = next;
                } else {
                    int i2 = ((c) next).tJS.LNr;
                    while (true) {
                        next = it.next();
                        int i3 = ((c) next).tJS.LNr;
                        if (i2 >= i3) {
                            i3 = i2;
                            next = next;
                        }
                        if (!it.hasNext()) {
                            break;
                        }
                        i2 = i3;
                    }
                    obj = next;
                }
            }
            if (obj == null) {
                kotlin.g.b.p.hyc();
            }
            c cVar2 = (c) obj;
            int i4 = cVar2.tJS.LNr <= 0 ? -1 : cVar2.dLS;
            StringBuilder append = new StringBuilder("[getAliveTabType] cost=").append(System.currentTimeMillis() - currentTimeMillis).append("ms aliveType=").append(i4).append(" maxPriorityTabType=").append(cVar2.dLS).append(' ');
            List<c> list = listOf;
            ArrayList arrayList = new ArrayList(kotlin.a.j.a(list, 10));
            for (c cVar3 : list) {
                arrayList.add(new StringBuilder().append(cVar3.dLS).append('=').append(cVar3.tJS.LNr).toString());
            }
            Log.i("Finder.RedDotManager", append.append(arrayList).toString());
            AppMethodBeat.o(243577);
            return i4;
        }
        int a4 = a(asX);
        Log.i("Finder.RedDotManager", "[getAliveTabType] getTabTypeInCtrlInfo=".concat(String.valueOf(a4)));
        if (a4 != -1) {
            AppMethodBeat.o(243577);
            return a4;
        }
        Log.i("Finder.RedDotManager", "[getAliveTabType] TAB_TYPE_INVALID");
        AppMethodBeat.o(243577);
        return -1;
    }

    public final void Iy(int i2) {
        AppMethodBeat.i(243578);
        a(i2, i.tKb);
        AppMethodBeat.o(243578);
    }

    public final boolean a(int i2, kotlin.g.a.b<? super k, Boolean> bVar) {
        AppMethodBeat.i(243579);
        kotlin.g.b.p.h(bVar, "filter");
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.ad.class);
        kotlin.g.b.p.g(af, "MMKernel.service(IFinder…enModeConfig::class.java)");
        if (!((com.tencent.mm.plugin.i.a.ad) af).dxX() || i2 == 8) {
            HashMap<String, LinkedList<k>> b2 = b(i2, bVar);
            if (!b2.isEmpty()) {
                Log.i("Finder.RedDotManager", "[clearCtrlInfo] type=" + i2 + " clearMap=" + b2);
            }
            for (Map.Entry<String, LinkedList<k>> entry : b2.entrySet()) {
                String key = entry.getKey();
                List<k> list = this.tJJ.get(key);
                if (list != null) {
                    com.tencent.mm.ac.d.a(list, new j(entry));
                }
                Iterator<T> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    k.b(it.next(), this.tJN);
                }
                k asX = asX(key);
                if (asX != null) {
                    bdo atl = asX.atl(key);
                    if (atl != null) {
                        h hVar = h.tKR;
                        h.a(false, key, null, null);
                        h hVar2 = h.tKR;
                        h.a(true, key, atl, asX);
                    } else {
                        h hVar3 = h.tKR;
                        h.a(false, key, null, null);
                    }
                } else {
                    h hVar4 = h.tKR;
                    h.a(false, key, null, null);
                }
            }
            if (!b2.isEmpty()) {
                AppMethodBeat.o(243579);
                return true;
            }
            AppMethodBeat.o(243579);
            return false;
        }
        Log.i("Finder.RedDotManager", "[clearCtrlInfo] 青少年模式且只看关注的模式下只clear关注的红点展示");
        AppMethodBeat.o(243579);
        return false;
    }

    private final HashMap<String, LinkedList<k>> b(int i2, kotlin.g.a.b<? super k, Boolean> bVar) {
        AppMethodBeat.i(243580);
        Log.i("Finder.RedDotManager", "getCtrlInfoMap type:".concat(String.valueOf(i2)));
        HashMap<String, LinkedList<k>> hashMap = new HashMap<>();
        for (Map.Entry<String, List<k>> entry : this.tJJ.entrySet()) {
            String key = entry.getKey();
            List<k> value = entry.getValue();
            synchronized (value) {
                try {
                    for (T t2 : value) {
                        if ((((k) t2).field_ctrInfo.type == i2 || i2 == Integer.MIN_VALUE) && bVar.invoke(t2).booleanValue()) {
                            LinkedList<k> linkedList = hashMap.get(key);
                            if (linkedList == null) {
                                LinkedList<k> linkedList2 = new LinkedList<>();
                                hashMap.put(key, linkedList2);
                                linkedList = linkedList2;
                            }
                            kotlin.g.b.p.g(linkedList, "ctrlInfoMap[path] ?: run…ist\n                    }");
                            linkedList.add(t2);
                        }
                    }
                    kotlin.x xVar = kotlin.x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(243580);
                    throw th;
                }
            }
        }
        AppMethodBeat.o(243580);
        return hashMap;
    }

    public static /* synthetic */ List a(f fVar, String str) {
        AppMethodBeat.i(243582);
        List<k> j2 = fVar.j(str, n.tKe);
        AppMethodBeat.o(243582);
        return j2;
    }

    private List<k> j(String str, kotlin.g.a.b<? super k, Boolean> bVar) {
        AppMethodBeat.i(243581);
        kotlin.g.b.p.h(str, "path");
        kotlin.g.b.p.h(bVar, "filter");
        HashSet hashSet = new HashSet();
        for (Map.Entry<String, List<k>> entry : this.tJJ.entrySet()) {
            synchronized (entry.getValue()) {
                try {
                    for (k kVar : entry.getValue()) {
                        if (bVar.invoke(kVar).booleanValue() && kVar.atl(str) != null) {
                            hashSet.add(kVar);
                        }
                    }
                    kotlin.x xVar = kotlin.x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(243581);
                    throw th;
                }
            }
        }
        List<k> p2 = kotlin.a.j.p(hashSet);
        AppMethodBeat.o(243581);
        return p2;
    }

    public static String c(bbi bbi) {
        AppMethodBeat.i(178180);
        if (bbi == null) {
            AppMethodBeat.o(178180);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        LinkedList<bdo> linkedList = bbi.GaM;
        kotlin.g.b.p.g(linkedList, "info.show_infos");
        int i2 = 0;
        for (T t2 : linkedList) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.a.j.hxH();
            }
            sb.append(a(t2, i2));
            i2 = i3;
        }
        String str = "CtrlInfo{tipsId=" + bbi.LKM + " priority=" + bbi.priority + " type=" + bbi.type + " starttime=" + bbi.MQX + " expired=" + bbi.pRN + " tipsShowInfo=" + ((Object) sb) + '}';
        AppMethodBeat.o(178180);
        return str;
    }

    private static String a(bdo bdo, int i2) {
        AppMethodBeat.i(178181);
        if (bdo == null) {
            AppMethodBeat.o(178181);
            return "[empty]";
        }
        bdp bdp = null;
        if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED) {
            bdp = new bdp();
            com.tencent.mm.bw.b bVar = bdo.LNo;
            if (bVar != null) {
                bdp.parseFrom(bVar.toByteArray());
            }
        }
        String str = "#" + i2 + "{showType=" + bdo.xGz + " count=" + bdo.count + " title=" + bdo.title + ' ' + "clearType=" + bdo.LNm + " iconUrl=" + bdo.qGB + " path=" + bdo.path + " show_ext_info_type=" + bdo.LNn + " parent=" + bdo.Bvg + ' ' + (bdp != null ? "jumpPriority=" + bdp.LNr : "") + "} ";
        AppMethodBeat.o(178181);
        return str;
    }

    private final boolean a(bdj bdj) {
        int i2;
        int i3;
        boolean z2;
        boolean z3;
        boolean z4;
        LinkedList<bdo> linkedList;
        LinkedList<bdo> linkedList2;
        Integer num = null;
        int i4 = -1;
        AppMethodBeat.i(243583);
        bbi bbi = bdj.LNi;
        Integer valueOf = bbi != null ? Integer.valueOf(bbi.type) : null;
        if ((valueOf != null && valueOf.intValue() == 8) || ((valueOf != null && valueOf.intValue() == 7) || ((valueOf != null && valueOf.intValue() == 9) || ((valueOf != null && valueOf.intValue() == 13) || (valueOf != null && valueOf.intValue() == 16))))) {
            if (tJO) {
                bbi bbi2 = bdj.LNi;
                if (!(bbi2 == null || (linkedList2 = bbi2.GaM) == null)) {
                    kotlin.a.j.c((List) linkedList2, (kotlin.g.a.b) m.tKd);
                }
                tJO = false;
            }
            bbi bbi3 = bdj.LNi;
            if (bbi3 != null && bbi3.VjD > 0) {
                int i5 = this.tJD.UVM;
                int i6 = this.tJD.wtW;
                boolean JN = this.tJD.JN(bbi3.VjD);
                Log.i("Finder.RedDotManager", "[filterNotifyTabTip] currentTabType=" + i6 + " lastTabType=" + i5 + "  ignore_tab_type=" + bbi3.VjD + " isAutoRefresh=" + JN);
                if (bbi3.VjE && ((i6 <= 0 && bbi3.VjD == i5 && !JN) || i6 == bbi3.VjD)) {
                    StringBuilder sb = new StringBuilder("[filterNotifyTabTip] remove this ctrlInfo type=");
                    bbi bbi4 = bdj.LNi;
                    Log.i("Finder.RedDotManager", sb.append(bbi4 != null ? Integer.valueOf(bbi4.type) : null).append(" currentTabType=").append(i6).append(" lastTabType=").append(i5).toString());
                    AppMethodBeat.o(243583);
                    return false;
                }
            }
            bbi bbi5 = bdj.LNi;
            if (bbi5 != null && (linkedList = bbi5.GaM) != null) {
                Iterator<bdo> it = linkedList.iterator();
                i2 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i2 = -1;
                        break;
                    }
                    bdo next = it.next();
                    if (kotlin.g.b.p.j(next.path, "FinderEntrance") || kotlin.g.b.p.j(next.path, "NearbyEntrance")) {
                        break;
                    }
                    i2++;
                }
            } else {
                i2 = -1;
            }
            if (i2 >= 0) {
                StringBuilder sb2 = new StringBuilder("[filterNotifyTabTip] has FINDER_ENTRANCE or NEARBY_ENTRANCE this tabTip type=");
                bbi bbi6 = bdj.LNi;
                if (bbi6 != null) {
                    num = Integer.valueOf(bbi6.type);
                }
                Log.i("Finder.RedDotManager", sb2.append(num).toString());
                AppMethodBeat.o(243583);
                return true;
            } else if ((valueOf != null && valueOf.intValue() == 8) || (valueOf != null && valueOf.intValue() == 9)) {
                List<k> list = this.tJJ.get("FinderEntrance");
                if (list != null) {
                    synchronized (list) {
                        try {
                            Iterator<k> it2 = list.iterator();
                            int i7 = 0;
                            while (true) {
                                if (!it2.hasNext()) {
                                    i3 = -1;
                                    break;
                                }
                                k next2 = it2.next();
                                if (next2.field_ctrInfo.type == 8 || next2.field_ctrInfo.type == 9) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (z2) {
                                    i3 = i7;
                                    break;
                                }
                                i7++;
                            }
                        } catch (Throwable th) {
                            AppMethodBeat.o(243583);
                            throw th;
                        }
                    }
                } else {
                    i3 = -1;
                }
                boolean z5 = i3 >= 0;
                Log.i("Finder.RedDotManager", "[filterNotifyTabTip] ignore[" + z5 + "] this tabTip type=" + valueOf);
                if (!z5) {
                    AppMethodBeat.o(243583);
                    return true;
                }
                AppMethodBeat.o(243583);
                return false;
            } else if ((valueOf != null && valueOf.intValue() == 7) || (valueOf != null && valueOf.intValue() == 13)) {
                List<k> list2 = this.tJJ.get("FinderEntrance");
                if (list2 != null) {
                    synchronized (list2) {
                        try {
                            Iterator<k> it3 = list2.iterator();
                            int i8 = 0;
                            while (true) {
                                if (!it3.hasNext()) {
                                    break;
                                }
                                if (it3.next().field_ctrInfo.type == 7 || (valueOf != null && valueOf.intValue() == 13)) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (z3) {
                                    i4 = i8;
                                    break;
                                }
                                i8++;
                            }
                        } catch (Throwable th2) {
                            AppMethodBeat.o(243583);
                            throw th2;
                        }
                    }
                }
                boolean z6 = i4 >= 0;
                StringBuilder append = new StringBuilder("[filterNotifyTabTip] ignore[").append(z6).append("] this tabTip type=");
                bbi bbi7 = bdj.LNi;
                if (bbi7 != null) {
                    num = Integer.valueOf(bbi7.type);
                }
                Log.i("Finder.RedDotManager", append.append(num).toString());
                if (!z6) {
                    AppMethodBeat.o(243583);
                    return true;
                }
                AppMethodBeat.o(243583);
                return false;
            } else if (valueOf != null && valueOf.intValue() == 16) {
                List<k> list3 = this.tJJ.get("NearbyEntrance");
                if (list3 != null) {
                    synchronized (list3) {
                        try {
                            Iterator<k> it4 = list3.iterator();
                            int i9 = 0;
                            while (true) {
                                if (!it4.hasNext()) {
                                    break;
                                }
                                if (it4.next().field_ctrInfo.type == 16) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                if (z4) {
                                    i4 = i9;
                                    break;
                                }
                                i9++;
                            }
                        } catch (Throwable th3) {
                            AppMethodBeat.o(243583);
                            throw th3;
                        }
                    }
                }
                boolean z7 = i4 >= 0;
                StringBuilder append2 = new StringBuilder("[filterNotifyTabTip] ignore[").append(z7).append("] this tabTip type=");
                bbi bbi8 = bdj.LNi;
                if (bbi8 != null) {
                    num = Integer.valueOf(bbi8.type);
                }
                Log.i("Finder.RedDotManager", append2.append(num).toString());
                if (!z7) {
                    AppMethodBeat.o(243583);
                    return true;
                }
                AppMethodBeat.o(243583);
                return false;
            }
        }
        AppMethodBeat.o(243583);
        return true;
    }

    public final void a(bdh bdh, String str) {
        LinkedList<bdo> linkedList;
        bbj bbj;
        LinkedList<bdo> linkedList2;
        bbi bbi;
        bbj bbj2;
        String str2;
        LinkedList<bdo> linkedList3;
        AppMethodBeat.i(243584);
        kotlin.g.b.p.h(bdh, "tabTips");
        kotlin.g.b.p.h(str, "source");
        long daD = daD();
        LinkedList<bdj> linkedList4 = bdh.LKY;
        kotlin.g.b.p.g(linkedList4, "tabTips.tab_tips_info");
        ArrayList<bdj> arrayList = new ArrayList();
        for (T t2 : linkedList4) {
            T t3 = t2;
            kotlin.g.b.p.g(t3, LocaleUtil.ITALIAN);
            if (a((bdj) t3)) {
                arrayList.add(t2);
            }
        }
        for (bdj bdj : arrayList) {
            bbi bbi2 = bdj.LNi;
            if (!(bbi2 == null || (linkedList3 = bbi2.GaM) == null)) {
                kotlin.a.j.c((List) linkedList3, (kotlin.g.a.b) r.tKh);
            }
            Log.i("Finder.RedDotManager", "[notifyTabTip] " + c(bdj.LNi));
            bbi bbi3 = bdj.LNi;
            Integer valueOf = bbi3 != null ? Integer.valueOf(bbi3.type) : null;
            if (valueOf != null && valueOf.intValue() == 8) {
                if (daD <= l.tLu.dbB()) {
                    bbi bbi4 = bdj.LNi;
                    if (!(bbi4 == null || (linkedList = bbi4.GaM) == null)) {
                        com.tencent.mm.ac.d.a((LinkedList) linkedList, (kotlin.g.a.b) s.tKi);
                    }
                    Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + daD + "ms, moreTabFollowTabTimeMs=" + l.tLu.dbB() + "ms, remove this ctrInfo");
                }
                if (daD <= l.tLu.dbA()) {
                    d(bdj.LNi);
                    Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + daD + "ms, moreTabFollowTabTimeMs=" + l.tLu.dbA() + "ms, remove entrance path red dot");
                }
            } else if (valueOf != null && valueOf.intValue() == 7) {
                if (daD <= l.tLu.dbC()) {
                    d(bdj.LNi);
                    Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + daD + "ms, moreTabFriendEntranceTimeMs=" + l.tLu.dbC() + "ms, remove entrance path red dot");
                }
            } else if (valueOf != null && valueOf.intValue() == 10) {
                if (daD <= l.tLu.dbD()) {
                    d(bdj.LNi);
                    Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + daD + "ms, moreTabHotEntranceTimeMs=" + l.tLu.dbD() + "ms, remove entrance path red dot");
                }
            } else if ((valueOf != null && valueOf.intValue() == 9) || (valueOf != null && valueOf.intValue() == 13)) {
                if (daD <= l.tLu.dbF()) {
                    d(bdj.LNi);
                    Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + daD + "ms, moreTabLiveEntranceTimeMs=" + l.tLu.dbF() + "ms, remove entrance path red dot");
                }
            } else if (valueOf != null && valueOf.intValue() == 14) {
                if (daD <= l.tLu.dbE()) {
                    d(bdj.LNi);
                    Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + daD + "ms, moreTabHotEntranceTimeMs=" + l.tLu.dbE() + "ms, remove entrance path red dot");
                }
            } else if (valueOf != null && valueOf.intValue() == 16) {
                long daE = daE();
                if (daE <= l.tLu.dbG()) {
                    e(bdj.LNi);
                    Log.w("Finder.RedDotManager", "[notifyTabTip] diffTime=" + daE + "ms, moreTabNearbyEntranceTimeMs=" + l.tLu.dbG() + "ms, remove entrance path red dot");
                }
            }
            boolean isInFinder = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).isInFinder();
            if (isInFinder) {
                d(bdj.LNi);
                StringBuilder append = new StringBuilder("[notifyTabTip] it is in finder now. just remove path of FINDER_ENTRANCE, currentTabType=").append(this.tJD.wtW).append(" type=");
                bbi bbi5 = bdj.LNi;
                Log.w("Finder.RedDotManager", append.append(bbi5 != null ? Integer.valueOf(bbi5.type) : null).toString());
            }
            if (((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).isInNearby()) {
                e(bdj.LNi);
                StringBuilder sb = new StringBuilder("[notifyTabTip] it is in nearby now. just remove path of NEARBY_ENTRANCE, type=");
                bbi bbi6 = bdj.LNi;
                Log.w("Finder.RedDotManager", sb.append(bbi6 != null ? Integer.valueOf(bbi6.type) : null).toString());
            }
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dwB().value().intValue() != 1 || valueOf == null || valueOf.intValue() != 10 || (!isInFinder && daD > ((long) this.tJD.wtX))) {
                kotlin.o<k, bdo> oVar = null;
                bbi bbi7 = bdj.LNi;
                if (bbi7 != null) {
                    kotlin.g.b.p.g(bbi7, "info");
                    oVar = b(bbi7);
                    Iy(bbi7.type);
                }
                b(bdj.LNi, "notifyTabTip");
                k a2 = a(this, bdj.LNi, "notifyTabTip#".concat(String.valueOf(str)), null, true, oVar, 4);
                StringBuilder append2 = new StringBuilder("[notifyTabTip] successfully! ctrlType=").append(a2 != null ? Integer.valueOf(a2.field_ctrInfo.type) : null).append(" tabType=").append((a2 == null || (bbj2 = a2.tLm) == null) ? null : Integer.valueOf(bbj2.tab_type)).append(" extInfo=");
                bbi bbi8 = bdj.LNi;
                StringBuilder append3 = append2.append((bbi8 != null ? bbi8.LKL : null) != null).append(' ').append("objectId=").append(com.tencent.mm.ac.d.zs((a2 == null || (bbi = a2.field_ctrInfo) == null) ? 0 : bbi.feedId)).append(' ').append("diffTime=").append(daD).append("ms isInFinder=").append(isInFinder).append(" currentTabType=").append(this.tJD.wtW).append(" showInfoSize=");
                bbi bbi9 = bdj.LNi;
                StringBuilder append4 = append3.append((bbi9 == null || (linkedList2 = bbi9.GaM) == null) ? 0 : linkedList2.size()).append(' ').append("tabTipsByPassInfo=").append(((a2 == null || (bbj = a2.tLm) == null) ? null : bbj.tabTipsByPassInfo) != null).append(" expiredTime=");
                bbi bbi10 = bdj.LNi;
                Log.i("Finder.RedDotManager", append4.append(bbi10 != null ? Integer.valueOf(bbi10.pRN) : null).toString());
            } else {
                StringBuilder append5 = new StringBuilder("ignore this reddot.ctrlType=").append(valueOf).append(" tips_id=");
                bbi bbi11 = bdj.LNi;
                if (bbi11 != null) {
                    str2 = bbi11.LKM;
                } else {
                    str2 = null;
                }
                Log.w("Finder.RedDotManager", append5.append(str2).append(" diffTime=").append(daD).append(" limit=").append(this.tJD.wtX).toString());
            }
        }
        AppMethodBeat.o(243584);
    }

    public final FinderTipsShowEntranceExtInfo asZ(String str) {
        FinderTipsShowEntranceExtInfo finderTipsShowEntranceExtInfo;
        AppMethodBeat.i(243585);
        kotlin.g.b.p.h(str, "path");
        k asX = asX(str);
        if (asX == null || (finderTipsShowEntranceExtInfo = asX.dbx()) == null) {
            finderTipsShowEntranceExtInfo = new FinderTipsShowEntranceExtInfo();
        }
        AppMethodBeat.o(243585);
        return finderTipsShowEntranceExtInfo;
    }

    public final boolean Iz(int i2) {
        boolean z2;
        AppMethodBeat.i(243586);
        FinderTipsShowEntranceExtInfo IA = IA(i2);
        StringBuilder append = new StringBuilder("[containsTabTipsExtInfo] tabType=").append(i2).append(" isContains=");
        if (IA.tab_type != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Log.i("Finder.RedDotManager", append.append(z2).toString());
        if (IA.tab_type != 0) {
            AppMethodBeat.o(243586);
            return true;
        }
        AppMethodBeat.o(243586);
        return false;
    }

    public final FinderTipsShowEntranceExtInfo IA(int i2) {
        AppMethodBeat.i(243587);
        FinderTipsShowEntranceExtInfo asZ = asZ(Ix(i2));
        Log.i("Finder.RedDotManager", "[getTabTipsExtInfo] tabType=" + i2 + " ext=" + g.a(asZ));
        AppMethodBeat.o(243587);
        return asZ;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$EnterTabTipsExtInfo;", "", "ext", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;", "tipsId", "", "(Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;Ljava/lang/String;)V", "getExt", "()Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;", "getTipsId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "plugin-finder_release"})
    public static final class b {
        final bbj tJQ;
        final String tJR;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
            if (kotlin.g.b.p.j(r3.tJR, r4.tJR) != false) goto L_0x0022;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 243531(0x3b74b, float:3.4126E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0022
                boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.extension.reddot.f.b
                if (r0 == 0) goto L_0x0027
                com.tencent.mm.plugin.finder.extension.reddot.f$b r4 = (com.tencent.mm.plugin.finder.extension.reddot.f.b) r4
                com.tencent.mm.protocal.protobuf.bbj r0 = r3.tJQ
                com.tencent.mm.protocal.protobuf.bbj r1 = r4.tJQ
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
                java.lang.String r0 = r3.tJR
                java.lang.String r1 = r4.tJR
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
            L_0x0022:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0026:
                return r0
            L_0x0027:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0026
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.extension.reddot.f.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(243530);
            bbj bbj = this.tJQ;
            int hashCode = (bbj != null ? bbj.hashCode() : 0) * 31;
            String str = this.tJR;
            if (str != null) {
                i2 = str.hashCode();
            }
            int i3 = hashCode + i2;
            AppMethodBeat.o(243530);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(243529);
            String str = "EnterTabTipsExtInfo(ext=" + this.tJQ + ", tipsId=" + this.tJR + ")";
            AppMethodBeat.o(243529);
            return str;
        }

        public b(bbj bbj, String str) {
            kotlin.g.b.p.h(bbj, "ext");
            kotlin.g.b.p.h(str, "tipsId");
            AppMethodBeat.i(243528);
            this.tJQ = bbj;
            this.tJR = str;
            AppMethodBeat.o(243528);
        }
    }

    public static int a(k kVar) {
        AppMethodBeat.i(243588);
        if (kVar.atl("TLWxPrivateMsgBubble") != null || kVar.atl("TLWxBubble") != null) {
            AppMethodBeat.o(243588);
            return 1;
        } else if (kVar.atl("TLFollow") != null) {
            int asY = asY("TLFollow");
            AppMethodBeat.o(243588);
            return asY;
        } else if (kVar.atl("TLRecommendTab") != null) {
            int asY2 = asY("TLRecommendTab");
            AppMethodBeat.o(243588);
            return asY2;
        } else if (kVar.atl("finder_tl_hot_tab") != null) {
            int asY3 = asY("finder_tl_hot_tab");
            AppMethodBeat.o(243588);
            return asY3;
        } else if (kVar.atl("finder_tl_nearby_tab") != null) {
            int asY4 = asY("finder_tl_nearby_tab");
            AppMethodBeat.o(243588);
            return asY4;
        } else if (kVar.atl("NearbyFeedTab") != null) {
            int asY5 = asY("NearbyFeedTab");
            AppMethodBeat.o(243588);
            return asY5;
        } else if (kVar.atl("NearbyLiveTab") != null) {
            int asY6 = asY("NearbyLiveTab");
            AppMethodBeat.o(243588);
            return asY6;
        } else if (kVar.atl("NearbyPeopleTab") != null) {
            int asY7 = asY("NearbyPeopleTab");
            AppMethodBeat.o(243588);
            return asY7;
        } else {
            int i2 = kVar.tLm.tab_type;
            if (i2 != 0) {
                AppMethodBeat.o(243588);
                return i2;
            }
            AppMethodBeat.o(243588);
            return -1;
        }
    }

    public final void b(k kVar) {
        AppMethodBeat.i(243589);
        kotlin.g.b.p.h(kVar, "enterCtrlInfo");
        String Ix = Ix(a(kVar));
        Log.i("Finder.RedDotManager", "[saveEnterTabTipsExtInfo] PATH=" + Ix + '=' + kVar.tLm);
        bbj bbj = kVar.tLm;
        String str = kVar.field_tipsId;
        kotlin.g.b.p.g(str, "enterCtrlInfo.field_tipsId");
        this.tJL.put(Ix, new b(bbj, str));
        AppMethodBeat.o(243589);
    }

    public final void b(bbi bbi, String str) {
        AppMethodBeat.i(243590);
        kotlin.g.b.p.h(str, "source");
        if (bbi != null) {
            String Ix = Ix(a(new k().f(bbi)));
            b bVar = this.tJL.get(Ix);
            if (bVar != null) {
                if (!kotlin.g.b.p.j(bVar.tJR, bbi.LKM)) {
                    bVar = null;
                }
                if (bVar != null) {
                    this.tJL.remove(Ix);
                    Log.i("Finder.RedDotManager", "[clearEnterTabTipsExtInfo] PATH=" + Ix + " tips_id=" + bbi.LKM + " source=" + str);
                    AppMethodBeat.o(243590);
                    return;
                }
            }
            AppMethodBeat.o(243590);
            return;
        }
        AppMethodBeat.o(243590);
    }

    public final bbj ata(String str) {
        AppMethodBeat.i(243591);
        kotlin.g.b.p.h(str, "path");
        b bVar = this.tJL.get(str);
        if (bVar != null) {
            bbj bbj = bVar.tJQ;
            AppMethodBeat.o(243591);
            return bbj;
        }
        AppMethodBeat.o(243591);
        return null;
    }

    public final bbj gI(String str, String str2) {
        AppMethodBeat.i(243592);
        kotlin.g.b.p.h(str, "path");
        kotlin.g.b.p.h(str2, "source");
        b remove = this.tJL.remove(str);
        Log.i("Finder.RedDotManager", "[clearEnterTabTipsExtInfo] result=" + remove + " source=" + str2);
        if (remove != null) {
            bbj bbj = remove.tJQ;
            AppMethodBeat.o(243592);
            return bbj;
        }
        AppMethodBeat.o(243592);
        return null;
    }

    public final Set<k> daG() {
        AppMethodBeat.i(243593);
        HashSet hashSet = new HashSet();
        for (Map.Entry<String, List<k>> entry : this.tJJ.entrySet()) {
            hashSet.addAll(entry.getValue());
        }
        HashSet hashSet2 = hashSet;
        AppMethodBeat.o(243593);
        return hashSet2;
    }

    @Override // com.tencent.mm.plugin.i.a.z
    public final boolean daH() {
        AppMethodBeat.i(243594);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        boolean z2 = aAh.azQ().getBoolean(ar.a.USERINFO_FINDER_ENABLE_SHOW_ENTRANCE_REDDOT_BOOLEAN_SYNC, true);
        AppMethodBeat.o(243594);
        return z2;
    }

    @Override // com.tencent.mm.plugin.i.a.z
    public final void mS(boolean z2) {
        AppMethodBeat.i(243595);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_FINDER_ENABLE_SHOW_ENTRANCE_REDDOT_BOOLEAN_SYNC, Boolean.valueOf(z2));
        com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.ge(1, z2 ? 1 : 2);
        AppMethodBeat.o(243595);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(243596);
        Log.i("Finder.RedDotManager", "scene = ".concat(String.valueOf(qVar)));
        if (qVar != null) {
            switch (qVar.getType()) {
                case 3930:
                    if (i2 == 0 && i3 == 0) {
                        this.tJA.dbq();
                        break;
                    }
            }
        }
        AppMethodBeat.o(243596);
    }

    public final void a(bbq bbq) {
        AppMethodBeat.i(243597);
        kotlin.g.b.p.h(bbq, "revoke");
        StringBuilder sb = new StringBuilder("[revokeTabTips] ");
        LinkedList<bbr> linkedList = bbq.LKX;
        kotlin.g.b.p.g(linkedList, "revoke.revoke_tab_tips_info");
        LinkedList<bbr> linkedList2 = linkedList;
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(linkedList2, 10));
        Iterator<T> it = linkedList2.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().LKO);
        }
        Log.i("Finder.RedDotManager", sb.append(arrayList).toString());
        com.tencent.mm.ac.d.c("Finder.RedDotManager", new x(this, bbq));
        AppMethodBeat.o(243597);
    }

    public final void a(bbo bbo) {
        String str;
        bdo bdo;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        AppMethodBeat.i(243598);
        kotlin.g.b.p.h(bbo, "revoke");
        StringBuilder sb = new StringBuilder("[revokePathRedDot] ");
        LinkedList<bbp> linkedList = bbo.LKU;
        kotlin.g.b.p.g(linkedList, "revoke.revoke_ctrl_info");
        LinkedList<bbp> linkedList2 = linkedList;
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(linkedList2, 10));
        for (T t2 : linkedList2) {
            arrayList.add(t2.path + '_' + t2.LKV + '_' + t2.LKW);
        }
        Log.i("Finder.RedDotManager", sb.append(arrayList).toString());
        LinkedList<bbp> linkedList3 = bbo.LKU;
        kotlin.g.b.p.g(linkedList3, "revoke.revoke_ctrl_info");
        for (T t3 : linkedList3) {
            if (t3 == null || (str = t3.path) == null) {
                str = "";
            }
            k asX = asX(str);
            if (asX != null) {
                if (t3 == null || (str6 = t3.path) == null) {
                    str6 = "";
                }
                bdo = asX.atl(str6);
            } else {
                bdo = null;
            }
            if (t3.LKV == 0) {
                if (bdo != null) {
                    com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                    com.tencent.mm.plugin.finder.report.j.a(asX, bdo, 1, t3.LKV, (String) null, (String) null, 48);
                } else {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(20951, 0, 0, 3, "", t3.path, Integer.valueOf(t3.LKV), "");
                }
                if (t3 == null || (str4 = t3.path) == null) {
                    str4 = "";
                }
                gI(str4, "revokePathRedDot#0");
                if (t3 == null || (str5 = t3.path) == null) {
                    str5 = "";
                }
                asV(str5);
            } else if (t3.LKV == 1) {
                String str7 = "";
                LinkedList<String> linkedList4 = t3.LKW;
                kotlin.g.b.p.g(linkedList4, "it.tips_id_list");
                Iterator<T> it = linkedList4.iterator();
                while (it.hasNext()) {
                    str7 = str7 + ((String) it.next()) + ';';
                }
                kotlin.n.n.b(str7, ";");
                z.a aVar = new z.a();
                aVar.SYB = true;
                z.a aVar2 = new z.a();
                aVar2.SYB = false;
                if (t3 == null || (str3 = t3.path) == null) {
                    str2 = "";
                } else {
                    str2 = str3;
                }
                i(str2, new w(t3, aVar, aVar2, this));
                Log.i("Finder.RedDotManager", "[revokePathRedDot] isHasDisposed=" + aVar2.SYB + " isAllDisposed=" + aVar.SYB + " tipsList=" + str7);
                if (aVar2.SYB && aVar.SYB) {
                    com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                    if (!(asX == null || bdo == null)) {
                        com.tencent.mm.plugin.finder.report.j jVar2 = com.tencent.mm.plugin.finder.report.j.vft;
                        com.tencent.mm.plugin.finder.report.j.a(asX, bdo, 1, t3.LKV, str7, (String) null, 32);
                    }
                } else if (aVar2.SYB && !aVar.SYB) {
                    com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
                    if (!(asX == null || bdo == null)) {
                        com.tencent.mm.plugin.finder.report.j jVar3 = com.tencent.mm.plugin.finder.report.j.vft;
                        com.tencent.mm.plugin.finder.report.j.a(asX, bdo, 2, t3.LKV, str7, (String) null, 32);
                    }
                } else if (!aVar2.SYB) {
                    com.tencent.mm.plugin.finder.utils.y yVar3 = com.tencent.mm.plugin.finder.utils.y.vXH;
                    if (!(asX == null || bdo == null)) {
                        com.tencent.mm.plugin.finder.report.j jVar4 = com.tencent.mm.plugin.finder.report.j.vft;
                        com.tencent.mm.plugin.finder.report.j.a(asX, bdo, 4, t3.LKV, str7, (String) null, 32);
                    }
                }
            }
        }
        AppMethodBeat.o(243598);
    }

    public static void d(bbi bbi) {
        bdo bdo;
        LinkedList<bdo> linkedList;
        LinkedList<bdo> linkedList2;
        T t2;
        AppMethodBeat.i(243599);
        if (bbi == null || (linkedList2 = bbi.GaM) == null) {
            bdo = null;
        } else {
            Iterator<T> it = linkedList2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t2 = null;
                    break;
                }
                T next = it.next();
                if (kotlin.g.b.p.j(next.path, "FinderEntrance")) {
                    t2 = next;
                    break;
                }
            }
            bdo = t2;
        }
        if ((bbi == null || (linkedList = bbi.GaM) == null) ? false : com.tencent.mm.ac.d.a((LinkedList) linkedList, (kotlin.g.a.b) u.tKk)) {
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            if (!(bbi == null || bdo == null)) {
                com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                com.tencent.mm.plugin.finder.report.j.a(new k().f(bbi), bdo, 5, 2, (String) null, (String) null, 48);
            }
        }
        AppMethodBeat.o(243599);
    }

    private static void e(bbi bbi) {
        bdo bdo;
        LinkedList<bdo> linkedList;
        LinkedList<bdo> linkedList2;
        T t2;
        AppMethodBeat.i(243600);
        if (bbi == null || (linkedList2 = bbi.GaM) == null) {
            bdo = null;
        } else {
            Iterator<T> it = linkedList2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t2 = null;
                    break;
                }
                T next = it.next();
                if (kotlin.g.b.p.j(next.path, "NearbyEntrance")) {
                    t2 = next;
                    break;
                }
            }
            bdo = t2;
        }
        if ((bbi == null || (linkedList = bbi.GaM) == null) ? false : com.tencent.mm.ac.d.a((LinkedList) linkedList, (kotlin.g.a.b) v.tKl)) {
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            if (!(bbi == null || bdo == null)) {
                com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                com.tencent.mm.plugin.finder.report.j.a(new k().f(bbi), bdo, 5, 2, (String) null, (String) null, 48);
            }
        }
        AppMethodBeat.o(243600);
    }

    private final kotlin.o<k, bdo> atb(String str) {
        AppMethodBeat.i(243601);
        k asX = asX(str);
        if (asX != null) {
            kotlin.o<k, bdo> oVar = new kotlin.o<>(asX, asX.atl("FinderEntrance"));
            AppMethodBeat.o(243601);
            return oVar;
        }
        AppMethodBeat.o(243601);
        return null;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class x extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ f tJV;
        final /* synthetic */ bbq tKp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        x(f fVar, bbq bbq) {
            super(0);
            this.tJV = fVar;
            this.tKp = bbq;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(243562);
            LinkedList<bdj> linkedList = new LinkedList<>();
            m mVar = m.tLw;
            m.dbU();
            LinkedList<bbr> linkedList2 = this.tKp.LKX;
            kotlin.g.b.p.g(linkedList2, "revoke.revoke_tab_tips_info");
            for (T t : linkedList2) {
                k b2 = f.b(this.tJV, t.LKO);
                if (b2 != null) {
                    this.tJV.b(b2.field_ctrInfo, "revokeTabTips");
                    linkedList.addAll(t.LKY);
                    boolean a2 = f.a(this.tJV, b2);
                    Log.i("Finder.RedDotManager", "[revokeRedDot] ret=" + a2 + " revokeId=" + t.LKO + ' ' + b2);
                    if (a2) {
                        com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                        int i2 = b2.field_ctrInfo.type;
                        String str = b2.field_tipsId;
                        if (str == null) {
                            str = "";
                        }
                        String str2 = t.LKO;
                        if (str2 == null) {
                            str2 = "";
                        }
                        com.tencent.mm.plugin.finder.report.k.f(i2, str, str2, 1);
                    } else {
                        com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                        int i3 = b2.field_ctrInfo.type;
                        String str3 = b2.field_tipsId;
                        if (str3 == null) {
                            str3 = "";
                        }
                        String str4 = t.LKO;
                        if (str4 == null) {
                            str4 = "";
                        }
                        com.tencent.mm.plugin.finder.report.k.f(i3, str3, str4, 0);
                    }
                } else {
                    f fVar = this.tJV;
                    Log.w("Finder.RedDotManager", "no found redDot. " + t.LKO);
                    ConcurrentHashMap concurrentHashMap = fVar.tJM;
                    String str5 = t.LKO;
                    if (str5 == null) {
                        str5 = "";
                    }
                    kotlin.g.b.p.g(t, LocaleUtil.ITALIAN);
                    concurrentHashMap.put(str5, t);
                    com.tencent.mm.plugin.finder.report.k kVar3 = com.tencent.mm.plugin.finder.report.k.vfA;
                    String str6 = t.LKO;
                    if (str6 == null) {
                        str6 = "";
                    }
                    com.tencent.mm.plugin.finder.report.k.f(0, "", str6, 0);
                }
            }
            f fVar2 = this.tJV;
            bdh bdh = new bdh();
            bdh.LKY = linkedList;
            fVar2.a(bdh, "FinderRevokeTabTips");
            m mVar2 = m.tLw;
            f fVar3 = m.toy;
            boolean z = (fVar3 != null ? fVar3.asX("FinderEntrance") : null) != null;
            Log.i("Finder.ThreeDayTwoDay", "afterRevokeRedDot hasRed=".concat(String.valueOf(z)));
            if (!z && m.tLv) {
                m.dbX();
            }
            m.tLv = false;
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(243562);
            return xVar;
        }
    }

    public static final /* synthetic */ k b(f fVar, String str) {
        AppMethodBeat.i(243602);
        ConcurrentHashMap<String, k> concurrentHashMap = fVar.tJK;
        if (str == null) {
            str = "";
        }
        k kVar = concurrentHashMap.get(str);
        AppMethodBeat.o(243602);
        return kVar;
    }

    public static final /* synthetic */ boolean a(f fVar, k kVar) {
        AppMethodBeat.i(243603);
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.ad.class);
        kotlin.g.b.p.g(af, "MMKernel.service(IFinder…enModeConfig::class.java)");
        if (!((com.tencent.mm.plugin.i.a.ad) af).dxX() || kVar.field_ctrInfo.type == 8) {
            Set<String> keySet = kVar.tLk.keySet();
            kotlin.g.b.p.g(keySet, "ctrInfo.showInfoMap.keys");
            for (T t2 : keySet) {
                List<k> list = fVar.tJJ.get(t2);
                if (list != null) {
                    com.tencent.mm.ac.d.a(list, new h(fVar, kVar));
                }
                kotlin.g.b.p.g(t2, "removePath");
                k asX = fVar.asX(t2);
                if (asX != null) {
                    bdo atl = asX.atl(t2);
                    if (atl != null) {
                        h hVar = h.tKR;
                        h.a(false, t2, null, null);
                        h hVar2 = h.tKR;
                        h.a(true, t2, atl, asX);
                    } else {
                        h hVar3 = h.tKR;
                        h.a(false, t2, null, null);
                    }
                } else {
                    h hVar4 = h.tKR;
                    h.a(false, t2, null, null);
                }
            }
            if (k.b(kVar, fVar.tJN)) {
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                ((FinderStreamTabPreloadCore) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamTabPreloadCore.class)).c(kVar);
                AppMethodBeat.o(243603);
                return true;
            }
        } else {
            Log.i("Finder.RedDotManager", "[clearCtrlInfo] 青少年模式且只看关注的模式下只delete关注的红点展示");
        }
        AppMethodBeat.o(243603);
        return false;
    }

    public static final /* synthetic */ void c(b.a aVar) {
        AppMethodBeat.i(243604);
        if (b.a.clicfg_finder_3_day_2_day_enable == aVar) {
            m mVar = m.tLw;
            Log.i("Finder.ThreeDayTwoDay", "onConfigChange");
            mVar.dbW();
        }
        AppMethodBeat.o(243604);
    }
}
