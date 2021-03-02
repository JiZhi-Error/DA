package com.tencent.mm.plugin.finder;

import android.app.Activity;
import android.arch.lifecycle.ViewModelStore;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.Scopes;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.g.a.id;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.g.b.a.ec;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.cm;
import com.tencent.mm.kernel.e;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.model.af;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.d;
import com.tencent.mm.plugin.byp.b;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.cgi.bt;
import com.tencent.mm.plugin.finder.cgi.cd;
import com.tencent.mm.plugin.finder.conv.i;
import com.tencent.mm.plugin.finder.extension.reddot.c;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.feed.d;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI20;
import com.tencent.mm.plugin.finder.live.model.FinderLiveConfig;
import com.tencent.mm.plugin.finder.live.model.cgi.g;
import com.tencent.mm.plugin.finder.live.model.cgi.n;
import com.tencent.mm.plugin.finder.live.view.h;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.megavideo.floatball.a;
import com.tencent.mm.plugin.finder.megavideo.multitask.a;
import com.tencent.mm.plugin.finder.megavideo.uic.FinderMegaVideoNormalTLUIC;
import com.tencent.mm.plugin.finder.nearby.NearbyHomeUIC;
import com.tencent.mm.plugin.finder.preload.tabPreload.FinderStreamTabPreloadCore;
import com.tencent.mm.plugin.finder.preload.tabPreload.f;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.a;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.storage.ag;
import com.tencent.mm.plugin.finder.storage.ai;
import com.tencent.mm.plugin.finder.storage.aj;
import com.tencent.mm.plugin.finder.storage.ar;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.storage.data.b;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.g;
import com.tencent.mm.plugin.finder.storage.data.l;
import com.tencent.mm.plugin.finder.storage.data.v;
import com.tencent.mm.plugin.finder.storage.e;
import com.tencent.mm.plugin.finder.storage.l;
import com.tencent.mm.plugin.finder.storage.logic.b;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.storage.w;
import com.tencent.mm.plugin.finder.storage.y;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.upload.action.j;
import com.tencent.mm.plugin.finder.upload.b;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.plugin.i.a.af;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aox;
import com.tencent.mm.protocal.protobuf.ars;
import com.tencent.mm.protocal.protobuf.asm;
import com.tencent.mm.protocal.protobuf.asq;
import com.tencent.mm.protocal.protobuf.atx;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.azq;
import com.tencent.mm.protocal.protobuf.bbg;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cxr;
import com.tencent.mm.protocal.protobuf.dqh;
import com.tencent.mm.protocal.protobuf.dxx;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.widget.QImageView;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.xlog.app.XLogSetup;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.sqlitelint.config.SharePluginInfo;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.wcdb.database.SQLiteException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.z;
import org.json.JSONObject;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000ó\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0003\u0011*K\u0018\u0000 \u00032\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b:\u0002\u0003B\u0005¢\u0006\u0002\u0010\tJ\u001f\u0010¬\u0001\u001a\u00030­\u00012\u0007\u0010®\u0001\u001a\u00020b2\n\u0010¯\u0001\u001a\u0005\u0018\u00010°\u0001H\u0002JC\u0010±\u0001\u001a\u00030­\u00012\b\u0010²\u0001\u001a\u00030³\u00012\b\u0010´\u0001\u001a\u00030µ\u00012\u0011\u0010¶\u0001\u001a\f\u0012\u0005\u0012\u00030¸\u0001\u0018\u00010·\u00012\u0010\u0010¹\u0001\u001a\u000b\u0012\u0004\u0012\u00020n\u0018\u00010·\u0001H\u0002J1\u0010º\u0001\u001a\u00030­\u00012\u001b\u0010»\u0001\u001a\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020\u000b0½\u00010¼\u00012\b\u0010¯\u0001\u001a\u00030¾\u0001H\u0016J\t\u0010¿\u0001\u001a\u00020\u0016H\u0016J\n\u0010À\u0001\u001a\u00030­\u0001H\u0002J\n\u0010Á\u0001\u001a\u00030­\u0001H\u0016J\n\u0010Â\u0001\u001a\u00030­\u0001H\u0016J\n\u0010Ã\u0001\u001a\u00030­\u0001H\u0002J\n\u0010Ä\u0001\u001a\u00030­\u0001H\u0002J\n\u0010Å\u0001\u001a\u00030­\u0001H\u0002J\u001b\u0010Æ\u0001\u001a\u00030­\u00012\t\u0010®\u0001\u001a\u0004\u0018\u00010bH\u0016¢\u0006\u0003\u0010Ç\u0001J\t\u0010\u0015\u001a\u00030­\u0001H\u0016J\u0016\u0010È\u0001\u001a\u000f\u0012\u0004\u0012\u00020n\u0012\u0005\u0012\u00030É\u00010lH\u0016J'\u0010Ê\u0001\u001a \u0012\u0004\u0012\u00020n\u0012\u0005\u0012\u00030É\u00010lj\u000f\u0012\u0004\u0012\u00020n\u0012\u0005\u0012\u00030É\u0001`pH\u0002J'\u0010Ë\u0001\u001a \u0012\u0004\u0012\u00020n\u0012\u0005\u0012\u00030É\u00010lj\u000f\u0012\u0004\u0012\u00020n\u0012\u0005\u0012\u00030É\u0001`pH\u0002J'\u0010Ì\u0001\u001a \u0012\u0004\u0012\u00020n\u0012\u0005\u0012\u00030É\u00010lj\u000f\u0012\u0004\u0012\u00020n\u0012\u0005\u0012\u00030É\u0001`pH\u0002J\u0016\u0010Í\u0001\u001a\u00030­\u00012\n\u0010Î\u0001\u001a\u0005\u0018\u00010Ï\u0001H\u0016J\u001f\u0010Ð\u0001\u001a\u00030­\u00012\b\u0010´\u0001\u001a\u00030µ\u00012\t\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u000bH\u0016J\u001f\u0010Ò\u0001\u001a\u00030­\u00012\b\u0010´\u0001\u001a\u00030µ\u00012\t\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u000bH\u0002J\n\u0010Ó\u0001\u001a\u00030­\u0001H\u0016J\n\u0010Ô\u0001\u001a\u00030­\u0001H\u0002J\n\u0010Õ\u0001\u001a\u00030­\u0001H\u0002J\u001c\u0010Ö\u0001\u001a\u00030­\u00012\u0007\u0010×\u0001\u001a\u00020n2\u0007\u0010Ø\u0001\u001a\u00020\u000bH\u0002J\n\u0010Ù\u0001\u001a\u00030­\u0001H\u0002J\n\u0010Ú\u0001\u001a\u00030­\u0001H\u0016J \u0010Û\u0001\u001a\u00030­\u00012\b\u0010´\u0001\u001a\u00030µ\u00012\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u0001H\u0016J\u001e\u0010Þ\u0001\u001a\u00030­\u00012\b\u0010´\u0001\u001a\u00030µ\u00012\b\u0010Ü\u0001\u001a\u00030Ý\u0001H\u0016J\u0014\u0010ß\u0001\u001a\u00030­\u00012\b\u0010´\u0001\u001a\u00030µ\u0001H\u0016J \u0010à\u0001\u001a\u00030­\u00012\b\u0010´\u0001\u001a\u00030µ\u00012\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u0001H\u0016J \u0010á\u0001\u001a\u00030­\u00012\b\u0010´\u0001\u001a\u00030µ\u00012\n\u0010â\u0001\u001a\u0005\u0018\u00010Ý\u0001H\u0016Jc\u0010ã\u0001\u001a\u00030­\u00012\n\u0010´\u0001\u001a\u0005\u0018\u00010µ\u00012\u0007\u0010ä\u0001\u001a\u00020b2\t\u0010®\u0001\u001a\u0004\u0018\u00010b2\u0007\u0010å\u0001\u001a\u00020\u000b2\t\u0010æ\u0001\u001a\u0004\u0018\u00010\u000b2\u0007\u0010ç\u0001\u001a\u00020\u000b2\t\u0010è\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010é\u0001\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0003\u0010ê\u0001JK\u0010ë\u0001\u001a\u00030­\u00012\b\u0010´\u0001\u001a\u00030µ\u00012\t\u0010ì\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010í\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010î\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010ä\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010®\u0001\u001a\u0004\u0018\u00010\u000bH\u0016J \u0010ï\u0001\u001a\u00030­\u00012\b\u0010´\u0001\u001a\u00030µ\u00012\n\u0010â\u0001\u001a\u0005\u0018\u00010Ý\u0001H\u0016Ju\u0010ð\u0001\u001a\u00030­\u00012\n\u0010´\u0001\u001a\u0005\u0018\u00010µ\u00012\u0007\u0010ä\u0001\u001a\u00020b2\t\u0010®\u0001\u001a\u0004\u0018\u00010b2\u0007\u0010ñ\u0001\u001a\u00020\u000b2\u0007\u0010å\u0001\u001a\u00020\u000b2\t\u0010æ\u0001\u001a\u0004\u0018\u00010\u000b2\u0007\u0010ç\u0001\u001a\u00020\u000b2\t\u0010è\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010é\u0001\u001a\u0004\u0018\u00010\u000b2\u0007\u0010ò\u0001\u001a\u00020nH\u0016¢\u0006\u0003\u0010ó\u0001J \u0010ô\u0001\u001a\u00030­\u00012\b\u0010´\u0001\u001a\u00030µ\u00012\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u0001H\u0016J \u0010õ\u0001\u001a\u00030­\u00012\b\u0010´\u0001\u001a\u00030µ\u00012\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u0001H\u0016J \u0010ö\u0001\u001a\u00030­\u00012\b\u0010´\u0001\u001a\u00030µ\u00012\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u0001H\u0016J \u0010÷\u0001\u001a\u00030­\u00012\b\u0010´\u0001\u001a\u00030µ\u00012\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u0001H\u0016J0\u0010ø\u0001\u001a\u00030­\u00012\b\u0010´\u0001\u001a\u00030µ\u00012\b\u0010Ü\u0001\u001a\u00030Ý\u00012\u0007\u0010ù\u0001\u001a\u00020n2\u0007\u0010ú\u0001\u001a\u00020nH\u0016J \u0010û\u0001\u001a\u00030­\u00012\b\u0010´\u0001\u001a\u00030µ\u00012\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u0001H\u0016J)\u0010û\u0001\u001a\u00030­\u00012\b\u0010´\u0001\u001a\u00030µ\u00012\u0007\u0010ü\u0001\u001a\u00020\u000b2\n\u0010â\u0001\u001a\u0005\u0018\u00010Ý\u0001H\u0016J \u0010ý\u0001\u001a\u00030­\u00012\b\u0010´\u0001\u001a\u00030µ\u00012\n\u0010â\u0001\u001a\u0005\u0018\u00010Ý\u0001H\u0016J)\u0010ý\u0001\u001a\u00030­\u00012\b\u0010´\u0001\u001a\u00030µ\u00012\n\u0010â\u0001\u001a\u0005\u0018\u00010Ý\u00012\u0007\u0010þ\u0001\u001a\u00020\u0016H\u0016J\u001e\u0010ÿ\u0001\u001a\u00030­\u00012\b\u0010´\u0001\u001a\u00030µ\u00012\b\u0010Ü\u0001\u001a\u00030Ý\u0001H\u0016J \u0010\u0002\u001a\u00030­\u00012\b\u0010´\u0001\u001a\u00030µ\u00012\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u0001H\u0016J\u001f\u0010\u0002\u001a\u00030­\u00012\b\u0010´\u0001\u001a\u00030µ\u00012\t\u0010ü\u0001\u001a\u0004\u0018\u00010\u000bH\u0016JD\u0010\u0002\u001a\u00030­\u00012\b\u0010´\u0001\u001a\u00030µ\u00012\t\u0010ü\u0001\u001a\u0004\u0018\u00010\u000b2\u0011\u0010¶\u0001\u001a\f\u0012\u0005\u0012\u00030¸\u0001\u0018\u00010·\u00012\u0010\u0010¹\u0001\u001a\u000b\u0012\u0004\u0012\u00020n\u0018\u00010·\u0001H\u0016J\u0014\u0010\u0002\u001a\u00030­\u00012\b\u0010Î\u0001\u001a\u00030Ï\u0001H\u0016J0\u0010\u0002\u001a\u00020\u000b2\u0007\u0010ù\u0001\u001a\u00020n2\u0007\u0010ú\u0001\u001a\u00020n2\u0007\u0010\u0002\u001a\u00020n2\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u0001H\u0016J \u0010\u0002\u001a\u00020\u000b2\t\u0010\u0002\u001a\u0004\u0018\u00010\u000b2\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u0001H\u0016J\n\u0010\u0002\u001a\u00030­\u0001H\u0016J$\u0010\u0002\u001a\u00020\u000b2\u0007\u0010ù\u0001\u001a\u00020n2\u0007\u0010ú\u0001\u001a\u00020n2\u0007\u0010\u0002\u001a\u00020nH\u0016J\u0007\u0010\u0002\u001a\u00020\u0018J\u0007\u0010\u0002\u001a\u00020\u001aJ\t\u0010\u0002\u001a\u00020\"H\u0002J\u0007\u0010\u0002\u001a\u00020(J\u0007\u0010\u0002\u001a\u00020-J\u0007\u0010\u0002\u001a\u00020\u000fJ\u0007\u0010\u0002\u001a\u000205J\u0007\u0010\u0002\u001a\u00020dJ\n\u0010\u0002\u001a\u00030\u0002H\u0016J\n\u0010\u0002\u001a\u00030\u0002H\u0016J\b\u0010\u0002\u001a\u00030\u0002J\n\u0010\u0002\u001a\u00030\u0002H\u0016J\n\u0010\u0002\u001a\u00030\u0002H\u0016J\u0007\u0010\u0002\u001a\u00020fJ\u001f\u0010\u0002\u001a\u00030­\u00012\u0007\u0010®\u0001\u001a\u00020b2\n\u0010¯\u0001\u001a\u0005\u0018\u00010°\u0001H\u0016J\u0007\u0010\u0002\u001a\u00020jJ\u0007\u0010\u0002\u001a\u00020rJ\u0007\u0010\u0002\u001a\u00020xJ\u0018\u0010 \u0002\u001a\n\u0012\u0005\u0012\u00030¢\u00020¡\u00022\u0007\u0010£\u0002\u001a\u00020nJ\b\u0010¤\u0002\u001a\u00030\u0001J\b\u0010¥\u0002\u001a\u00030\u0001J\b\u0010¦\u0002\u001a\u00030\u0001J\n\u0010§\u0002\u001a\u00030\u0001H\u0016J\b\u0010¨\u0002\u001a\u00030 \u0001J\t\u0010©\u0002\u001a\u00020nH\u0016J\n\u0010ª\u0002\u001a\u00030¦\u0001H\u0016J\t\u0010«\u0002\u001a\u00020\u0016H\u0016J\t\u0010¬\u0002\u001a\u00020\u0016H\u0016J\t\u0010­\u0002\u001a\u00020\u0016H\u0016J\t\u0010®\u0002\u001a\u00020\u0016H\u0016J\t\u0010¯\u0002\u001a\u00020\u0016H\u0016J\t\u0010°\u0002\u001a\u00020\u0016H\u0016J\t\u0010±\u0002\u001a\u00020\u0016H\u0016J\t\u0010²\u0002\u001a\u00020\u0016H\u0016J\u0012\u0010³\u0002\u001a\u00020\u00162\t\u0010ì\u0001\u001a\u0004\u0018\u00010\u000bJ\t\u0010´\u0002\u001a\u00020\u0016H\u0016J\u0007\u0010µ\u0002\u001a\u00020\u0016J\u0007\u0010¶\u0002\u001a\u00020\u0016J\t\u0010·\u0002\u001a\u00020\u0016H\u0002J\t\u0010¸\u0002\u001a\u00020\u0016H\u0016J\t\u0010¹\u0002\u001a\u00020\u0016H\u0016J\t\u0010º\u0002\u001a\u00020\u0016H\u0016J\u001d\u0010»\u0002\u001a\u00030­\u00012\u0007\u0010¼\u0002\u001a\u00020\u000b2\b\u0010½\u0002\u001a\u00030¾\u0002H\u0016J\u001d\u0010¿\u0002\u001a\u00030­\u00012\u0007\u0010¼\u0002\u001a\u00020\u000b2\b\u0010À\u0002\u001a\u00030¾\u0002H\u0016J\u001f\u0010Á\u0002\u001a\u00030­\u00012\t\u0010¼\u0002\u001a\u0004\u0018\u00010\u000b2\b\u0010Â\u0002\u001a\u00030Ã\u0002H\u0016J\u0016\u0010Ä\u0002\u001a\u00030­\u00012\n\u0010Å\u0002\u001a\u0005\u0018\u00010Æ\u0002H\u0016J\n\u0010Ç\u0002\u001a\u00030­\u0001H\u0016J\u0015\u0010È\u0002\u001a\u00030­\u00012\t\u0010É\u0002\u001a\u0004\u0018\u00010\u000bH\u0016J\u0015\u0010Ê\u0002\u001a\u00030­\u00012\t\u0010É\u0002\u001a\u0004\u0018\u00010\u000bH\u0016J\u001f\u0010Ë\u0002\u001a\u00030­\u00012\b\u0010!\u001a\u0004\u0018\u00010\"2\t\u0010Ì\u0002\u001a\u0004\u0018\u00010\"H\u0016J\u001f\u0010Í\u0002\u001a\u00030­\u00012\b\u0010!\u001a\u0004\u0018\u00010\"2\t\u0010Ì\u0002\u001a\u0004\u0018\u00010\"H\u0016J\u0011\u0010Î\u0002\u001a\u00030­\u00012\u0007\u0010Ï\u0002\u001a\u000202J\u0011\u0010Ð\u0002\u001a\u00030­\u00012\u0007\u0010Ï\u0002\u001a\u000202J3\u0010Ñ\u0002\u001a\u00030­\u00012\u0007\u0010Ò\u0002\u001a\u00020n2\u0007\u0010Ó\u0002\u001a\u00020n2\t\u0010Ô\u0002\u001a\u0004\u0018\u00010\u000b2\n\u0010Õ\u0002\u001a\u0005\u0018\u00010Ö\u0002H\u0016J$\u0010×\u0002\u001a\u00030­\u00012\b\u0010É\u0002\u001a\u00030Ø\u00022\u000e\u0010Ù\u0002\u001a\t\u0012\u0004\u0012\u00020\u00160·\u0001H\u0016J\u0014\u0010Ú\u0002\u001a\u00030­\u00012\b\u0010É\u0002\u001a\u00030Ø\u0002H\u0016J<\u0010Û\u0002\u001a\u00030­\u00012\b\u0010²\u0001\u001a\u00030³\u00012\b\u0010´\u0001\u001a\u00030µ\u00012\u0011\u0010¶\u0001\u001a\f\u0012\u0005\u0012\u00030¸\u0001\u0018\u00010·\u00012\t\b\u0002\u0010Ü\u0002\u001a\u00020\u000bH\u0002JD\u0010Ý\u0002\u001a\u00030­\u00012\b\u0010²\u0001\u001a\u00030³\u00012\u0010\u0010¹\u0001\u001a\u000b\u0012\u0004\u0012\u00020n\u0018\u00010·\u00012\u0011\u0010¶\u0001\u001a\f\u0012\u0005\u0012\u00030¸\u0001\u0018\u00010·\u00012\t\b\u0002\u0010Þ\u0002\u001a\u00020\u000bH\u0002J<\u0010ß\u0002\u001a\u00030­\u00012\b\u0010²\u0001\u001a\u00030³\u00012\b\u0010´\u0001\u001a\u00030µ\u00012\u0011\u0010¶\u0001\u001a\f\u0012\u0005\u0012\u00030¸\u0001\u0018\u00010·\u00012\t\b\u0002\u0010Ü\u0002\u001a\u00020\u000bH\u0002J\u001f\u0010à\u0002\u001a\u00030­\u00012\u0007\u0010®\u0001\u001a\u00020b2\n\u0010¯\u0001\u001a\u0005\u0018\u00010°\u0001H\u0016Jc\u0010á\u0002\u001a\u00030­\u00012\n\u0010â\u0002\u001a\u0005\u0018\u00010Ã\u00022\n\u0010ã\u0002\u001a\u0005\u0018\u00010ä\u00022\u0007\u0010å\u0002\u001a\u00020n2\u0007\u0010æ\u0002\u001a\u00020n2\u0007\u0010ç\u0002\u001a\u00020n2\u0007\u0010è\u0002\u001a\u00020b2\t\u0010é\u0002\u001a\u0004\u0018\u00010\u000b2\u0007\u0010ê\u0002\u001a\u00020n2\u0007\u0010ë\u0002\u001a\u00020\u0016H\u0016J\u0001\u0010ì\u0002\u001a\u00030­\u00012\u0007\u0010í\u0002\u001a\u00020b2\u0007\u0010®\u0001\u001a\u00020b2\t\u0010î\u0002\u001a\u0004\u0018\u00010\u000b2\u0007\u0010ï\u0002\u001a\u00020n2\u0007\u0010ð\u0002\u001a\u00020n2\u0007\u0010è\u0002\u001a\u00020b2\t\u0010é\u0002\u001a\u0004\u0018\u00010\u000b2\u0007\u0010ñ\u0002\u001a\u00020n2\u0007\u0010ò\u0002\u001a\u00020n2\t\u0010ó\u0002\u001a\u0004\u0018\u00010\u000b2\t\u0010ô\u0002\u001a\u0004\u0018\u00010\u000b2\u0007\u0010õ\u0002\u001a\u00020b2\u0007\u0010ú\u0001\u001a\u00020nH\u0016J0\u0010ö\u0002\u001a\u00030­\u00012\u0007\u0010í\u0002\u001a\u00020b2\u0007\u0010®\u0001\u001a\u00020b2\t\u0010î\u0002\u001a\u0004\u0018\u00010\u000b2\u0007\u0010÷\u0002\u001a\u00020bH\u0016J\n\u0010ø\u0002\u001a\u00030­\u0001H\u0016J\u0013\u0010ù\u0002\u001a\u00030­\u00012\u0007\u0010ú\u0002\u001a\u00020nH\u0016J\n\u0010û\u0002\u001a\u00030­\u0001H\u0002J)\u0010ü\u0002\u001a\u0005\u0018\u00010ý\u00022\u0007\u0010ä\u0001\u001a\u00020b2\t\u0010þ\u0002\u001a\u0004\u0018\u00010\u000b2\u0007\u0010ÿ\u0002\u001a\u00020nH\u0016J\b\u0010\u0003\u001a\u00030­\u0001J\n\u0010\u0003\u001a\u00030­\u0001H\u0002J\b\u0010\u0003\u001a\u00030­\u0001J+\u0010\u0003\u001a\u00030­\u00012\t\u0010\u0003\u001a\u0004\u0018\u00010\u000b2\t\u0010Ü\u0002\u001a\u0004\u0018\u00010\u000b2\t\u0010²\u0001\u001a\u0004\u0018\u00010\u000bH\u0016J0\u0010\u0003\u001a\u00030­\u00012\u001b\u0010\u0003\u001a\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0½\u00010\u00032\u0007\u0010\u0003\u001a\u00020\u0016H\u0016J\t\u0010\u0003\u001a\u00020\u0016H\u0016J\t\u0010\u0003\u001a\u00020\u0016H\u0016Jd\u0010\u0003\u001a\u00030­\u00012\u0007\u0010\u0003\u001a\u00020\u000b2\u0007\u0010Õ\u0002\u001a\u00020n2\u0007\u0010\u0003\u001a\u00020\u000b2\u0007\u0010\u0003\u001a\u00020n2\u0007\u0010\u0003\u001a\u00020n2\u0007\u0010\u0003\u001a\u00020n2\u0007\u0010\u0003\u001a\u00020b2\u0007\u0010í\u0002\u001a\u00020b2\u0007\u0010\u0003\u001a\u00020b2\u0007\u0010\u0003\u001a\u00020nH\u0016J)\u0010\u0003\u001a\u0005\u0018\u00010ý\u00022\u0007\u0010ä\u0001\u001a\u00020b2\t\u0010þ\u0002\u001a\u0004\u0018\u00010\u000b2\u0007\u0010ÿ\u0002\u001a\u00020nH\u0016Ja\u0010\u0003\u001a\u0005\u0018\u00010ý\u00022\u0007\u0010ä\u0001\u001a\u00020b2\t\u0010þ\u0002\u001a\u0004\u0018\u00010\u000b2\u0007\u0010ÿ\u0002\u001a\u00020n2\u0007\u0010\u0003\u001a\u00020\u00162\u000b\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00162\u001c\b\u0002\u0010\u0003\u001a\u0015\u0012\u0007\u0012\u0005\u0018\u00010ý\u0002\u0012\u0005\u0012\u00030­\u0001\u0018\u00010\u0003¢\u0006\u0003\u0010\u0003R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\u0013\u001a\n \f*\u0004\u0018\u00010\u00140\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u00020*X\u0004¢\u0006\u0004\n\u0002\u0010+R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0004¢\u0006\u0002\n\u0000R2\u00100\u001a&\u0012\f\u0012\n \f*\u0004\u0018\u00010202 \f*\u0012\u0012\f\u0012\n \f*\u0004\u0018\u00010202\u0018\u00010301X\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0004¢\u0006\u0002\n\u0000R\u001b\u00106\u001a\u0002078BX\u0002¢\u0006\f\n\u0004\b:\u0010 \u001a\u0004\b8\u00109R\u000e\u0010;\u001a\u00020<X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010=\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010$\"\u0004\b?\u0010&R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020IX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u00020KX\u0004¢\u0006\u0004\n\u0002\u0010LR\u001b\u0010M\u001a\u00020N8BX\u0002¢\u0006\f\n\u0004\bQ\u0010 \u001a\u0004\bO\u0010PR\u000e\u0010R\u001a\u00020SX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010T\u001a\u00020U8FX\u0002¢\u0006\f\n\u0004\bX\u0010 \u001a\u0004\bV\u0010WR\u001b\u0010Y\u001a\u00020Z8BX\u0002¢\u0006\f\n\u0004\b]\u0010 \u001a\u0004\b[\u0010\\R\u000e\u0010^\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010_\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00160`X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010c\u001a\u0004\u0018\u00010dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010e\u001a\u0004\u0018\u00010fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020hX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010i\u001a\u0004\u0018\u00010jX\u000e¢\u0006\u0002\n\u0000RN\u0010k\u001aB\u0012\u0004\u0012\u00020b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020n\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020o0m0lj \u0012\u0004\u0012\u00020b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020n\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020o0m`pX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010q\u001a\u0004\u0018\u00010rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020tX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010u\u001a\u0006\u0012\u0002\b\u00030vX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010w\u001a\u0004\u0018\u00010xX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010y\u001a\u00020z8FX\u0002¢\u0006\f\n\u0004\b}\u0010 \u001a\u0004\b{\u0010|R\u001d\u0010~\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u0010$\"\u0005\b\u0001\u0010&R\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R3\u0010\u0001\u001a&\u0012\f\u0012\n \f*\u0004\u0018\u00010202 \f*\u0012\u0012\f\u0012\n \f*\u0004\u0018\u00010202\u0018\u00010301X\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0001\u001a\u0005\u0018\u00010 \u0001X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010¡\u0001\u001a\u00030¢\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010£\u0001\u001a\u00030¤\u0001X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010¥\u0001\u001a\u00030¦\u0001X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010§\u0001\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¨\u0001\u0010$\"\u0005\b©\u0001\u0010&R\u0012\u0010ª\u0001\u001a\u0005\u0018\u00010«\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/finder/PluginFinder;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/findersdk/api/IPluginFinder;", "Lcom/tencent/mm/kernel/api/ICoreStorageCallback;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Landroid/arch/lifecycle/ViewModelStoreOwner;", "Lcom/tencent/mm/app/IAppForegroundListener;", "()V", "CURRENT_DB_VERSION", "", "kotlin.jvm.PlatformType", "CURRENT_DB_VERSION_DEFAULT", "actionStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderActionStorage;", "appForegroundListener", "com/tencent/mm/plugin/finder/PluginFinder$appForegroundListener$1", "Lcom/tencent/mm/plugin/finder/PluginFinder$appForegroundListener$1;", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "closeFinderEntryForDebug", "", "contactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderContactStorage;", "conversationStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;", "conversationUpdater", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationUpdater;", "getConversationUpdater", "()Lcom/tencent/mm/plugin/finder/conv/FinderConversationUpdater;", "conversationUpdater$delegate", "Lkotlin/Lazy;", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "getDataDB", "()Lcom/tencent/mm/storagebase/SqliteDB;", "setDataDB", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "draftStorage", "Lcom/tencent/mm/plugin/finder/storage/logic/FinderDraftStorage;", "entryConfigChangeListener", "com/tencent/mm/plugin/finder/PluginFinder$entryConfigChangeListener$1", "Lcom/tencent/mm/plugin/finder/PluginFinder$entryConfigChangeListener$1;", "feedStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderFeedStorage;", "findDelFansService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderDelFansService;", "finderActivity", "", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "", "finderContactCache", "Lcom/tencent/mm/plugin/finder/api/FinderContactCache;", "finderContactService", "Lcom/tencent/mm/plugin/finder/service/FinderContactService;", "getFinderContactService", "()Lcom/tencent/mm/plugin/finder/service/FinderContactService;", "finderContactService$delegate", "finderEnterPersonalMsgService", "Lcom/tencent/mm/plugin/finder/service/FinderEnterPersonalMsgService;", "finderMentionDB", "getFinderMentionDB", "setFinderMentionDB", "finderMentionStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderFinderMentionStorage;", "finderModBlockPosterSetting", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModBlockPosterService;", "finderPrivateSysMsgConsumer", "Lcom/tencent/mm/plugin/finder/conv/FinderPrivateSysMsgConsumer;", "finderPromotionConsumer", "Lcom/tencent/mm/plugin/finder/newxml/FinderPromotionConsumer;", "finderReInitSysMsgConsumer", "Lcom/tencent/mm/plugin/finder/newxml/FinderReInitSysMsgConsumer;", "finderSyncEventListener", "com/tencent/mm/plugin/finder/PluginFinder$finderSyncEventListener$1", "Lcom/tencent/mm/plugin/finder/PluginFinder$finderSyncEventListener$1;", "finderTeenModeConfig", "Lcom/tencent/mm/plugin/finder/storage/FinderTeenModeConfig;", "getFinderTeenModeConfig", "()Lcom/tencent/mm/plugin/finder/storage/FinderTeenModeConfig;", "finderTeenModeConfig$delegate", "finderUtilApi", "Lcom/tencent/mm/plugin/finder/utils/FinderUtilApi;", "followTlSingleExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "getFollowTlSingleExecutor", "()Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "followTlSingleExecutor$delegate", "getContactInterceptor", "Lcom/tencent/mm/plugin/finder/service/FinderGetContactInterceptor;", "getGetContactInterceptor", "()Lcom/tencent/mm/plugin/finder/service/FinderGetContactInterceptor;", "getContactInterceptor$delegate", "isDoSomethingCompleted", "isFriendCache", "Ljava/util/concurrent/ConcurrentHashMap;", "lastFinderInitTime", "", "liveConfigStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderLiveConfigStorage;", "liveGiftStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderLiveGiftStorage;", "liveInfoHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "liveLuckyMoneyStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderLiveLuckyMoneyStorage;", "liveStatusMap", "Ljava/util/HashMap;", "Lkotlin/Triple;", "", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveInfoResp;", "Lkotlin/collections/HashMap;", "localLikeFeedStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperationStorage;", "lock", "", "logoutEvent", "Lcom/tencent/mm/sdk/event/IListener;", "mediaCacheStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaCacheStorage;", "mediaPreloadModel", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "getMediaPreloadModel", "()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "mediaPreloadModel$delegate", "messageDB", "getMessageDB", "setMessageDB", "messageStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMessageStorage;", "modifyBlackListService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyBlackListService;", "modifyFeedSettingService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyFeedSettingService;", "modifyFinderFeedProduce", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModFeedReproduce;", "modifyFinderMessageService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModMessageSetting;", "modifyFinderMessageSessionService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderMsgSessionMuteSetting;", "modifyFinderWxMessageSessionService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderWxMsgSessionMuteSetting;", "modifyLikeRecommendService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModRecommendSetting;", "modifyProfileStickyService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModProfileSticky;", "modifyUserService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyUserService;", "msgStrangerContactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "nearbyActivity", "needResetDb", "postManager", "Lcom/tencent/mm/plugin/finder/upload/FinderPostManager;", "redDotCtrInfoStorage", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;", "redDotManager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "sessionInfoStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "syncExtension", "Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension;", "teenModeDataChangedListener", "Lcom/tencent/mm/plugin/teenmode/api/TeenModeDataChangedListener;", "viewModelStore", "Landroid/arch/lifecycle/ViewModelStore;", "wxMentionDB", "getWxMentionDB", "setWxMentionDB", "wxMentionStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderWxMentionStorage;", "CgiGetLiveInfo", "", "liveId", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IPluginFinder$FinderLiveStatusCallback;", "autoOpenFinderLive", IssueStorage.COLUMN_EXT_INFO, "Lcom/tencent/mm/json/JSONObject;", "context", "Landroid/content/Context;", "succCallback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "", "failedCallback", "batchGetLiveStatus", "finderObjectList", "", "Landroid/util/Pair;", "Lcom/tencent/mm/plugin/findersdk/api/IPluginFinder$FinderBatchLiveStatusCallback;", "canEnterMvAndShowToast", "checkIfSameMsgTableName", "checkInsertLiveNewReddot", "checkLastLiveObject", "checkResetDb", "clearMentionDB", "clearReInit", "cleatLiveStatusCache", "(Ljava/lang/Long;)V", "collectDatabaseFactory", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "collectFinderDatabaseFactory", "collectMentionDatabaseFactory", "collectMessageDatabaseFactory", "configure", Scopes.PROFILE, "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "createLuckyMoneyLive", "chatroom", "createLuckyMoneyLiveImpl", "dependency", "doFinderInit", "doPrepareUser", "doReInit", "reInitVersion", "reInitUsername", "doSomethingImportantOnStart", "dumpAndMarkFinderFolder", "enterAlbumRelatedTimelineUI", "intent", "Landroid/content/Intent;", "enterFinderActivityProfileUI", "enterFinderConversationUI", "enterFinderFollowListUI", "enterFinderLbsLiveFriendsUI", "i", "enterFinderLiveAnchorUI", "objectId", "nonceId", "desc", "contextId", "sessionBuffer", "redPacketId", "(Landroid/content/Context;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "enterFinderLiveInvitedUI", ch.COL_USERNAME, "nickname", "avatar", "enterFinderLivePostUI", "enterFinderLiveVisitorUI", "anchorUserName", "extFlag", "(Landroid/content/Context;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "enterFinderPoiFeedUI", "enterFinderPostRouterUI", "enterFinderPostUI", "enterFinderProfileUI", "enterFinderSelfProfile", "enter", "enterType", "enterFinderShareFeedUI", "json", "enterFinderTimelineUI", "needPreFectch", "enterFinderTopicTimelineUI", "enterFinderTopicUI", "enterFinderUI", "enterFinderUIFromMiniApp", "execute", "fillContextIdToIntent", "toCommentScene", "newContextId", "forcestopCurLive", "genContextId", "getContactStorage", "getConversationStorage", "getDB", "getDraftStorage", "getFeedStorage", "getFinderActionStorage", "getFinderContactCache", "getFinderLiveConfigStorage", "getFinderOpenSdkApi", "Lcom/tencent/mm/plugin/findersdk/api/IFinderOpenSdkApi;", "getFinderSwitchApi", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSwitchApi;", "getFinderSyncExtension", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncExtension;", "getFinderUIApi", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUIApi;", "getFinderUtilApi", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi;", "getLiveGiftStorage", "getLiveInfo", "getLiveLuckyMoneyStorage", "getLocalLikeFeedStorage", "getMediaCacheStorage", "getMentionStorage", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderMention;", "localFlag", "getMessageStorage", "getMsgStrangerContactStorage", "getRedDotCtrInfoStorage", "getRedDotManager", "getSessionInfoStorage", "getTimelineCommentScene", "getViewModelStore", "hasFinderPosted", "isAllEnableFullScreenEnjoy", "isAllHomeTabEnableFullScreenEnjoy", "isAllowEditFillingFullScreen", "isAnchorLiving", "isAnyEnableFullScreenEnjoy", "isAnyHomeTabEnableFullScreenEnjoy", "isDisablePostHalfScreen", "isFriend", "isGlobalEnableFullScreenEnjoy", "isInFinder", "isInNearby", "isNeedDoReInit", "isOtherEnableFullScreenEnjoy", "isPagEnable", "isVisitorLiving", "loadAvatar", "url", "avatarIv", "Landroid/widget/ImageView;", "loadImage", "imageView", "loadImageForSns", "qImageView", "Landroid/view/View;", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "onAppBackground", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "onAppForeground", "onDataBaseClosed", "readOnlyDB", "onDataBaseOpened", "onEnterFinder", "finder", "onExitFinder", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "openChannelsCreateContact", "Landroid/app/Activity;", "didOpenCallback", "openChannelsPostPage", "openFinderFeed", "appid", "openFinderLive", "reportExtraInfo", com.tencent.mm.plugin.appbrand.jsapi.finder.h.NAME, "refreshLiveStatus", "report21053", "recyclerView", "adapter", "Landroid/widget/BaseAdapter;", "visibleState", "firstVisibleItem", "visibleItemCount", "actionType", "commentscene", "event", "headerShow", "report21053OnClick", "feedId", "userName", FirebaseAnalytics.b.INDEX, "onlineNum", "enterStatus", "shareType", "shareUserName", "snsFeedid", "enterTime", "report21053OnClickOnSnsAd", "pos", "reportGiftOnReturn", "reportPostRedDot", "key", "requestAudioFocus", "requestFinderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "objectNonceId", "commentScene", "resetConfig", "resetDb", "resetLastTimelineExitTime", "sdkShare", "businessType", "shareStatsReport", "feedIdList", "", "isMegaVideo", "showFinderEntry", "showPostEntry", "snsToFinderPostReport", "sessionID", "wording", "shootEntranceEndType", "entranceExposeMaxTimes", "entranceExposedTimes", "snsId", "timeStamp", "exposeType", "tryGetFinderObject", "force", "needLoading", "callBack", "Lkotlin/Function1;", "(JLjava/lang/String;IZLjava/lang/Boolean;Lkotlin/jvm/functions/Function1;)Lcom/tencent/mm/protocal/protobuf/FinderObject;", "Companion", "plugin-finder_release"})
public final class PluginFinder extends com.tencent.mm.kernel.b.f implements ViewModelStoreOwner, com.tencent.mm.ak.i, com.tencent.mm.app.o, com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.api.e, com.tencent.mm.plugin.i.a.aj {
    public static final b toR = new b((byte) 0);
    private final ViewModelStore FE;
    private com.tencent.mm.plugin.finder.storage.ar UGM;
    private final com.tencent.mm.plugin.finder.newxml.b UGN;
    private final com.tencent.mm.plugin.finder.service.g UGO;
    private final com.tencent.mm.model.d hWh;
    private com.tencent.mm.storagebase.h hqK;
    private final HashMap<Long, kotlin.r<Integer, Long, asq>> hvE = new HashMap<>();
    private final IListener<?> hvF;
    private com.tencent.mm.plugin.teenmode.a.c kIM;
    private final byte[] lock = new byte[0];
    private volatile boolean tnN;
    private com.tencent.mm.storagebase.h tnO;
    private com.tencent.mm.storagebase.h tnP;
    private com.tencent.mm.storagebase.h tnQ;
    private MMHandler tnR = new MMHandler("FinderLiveInfoHandler");
    private final com.tencent.mm.plugin.finder.upload.g tnS;
    private final com.tencent.mm.plugin.finder.extension.a tnT;
    private com.tencent.mm.plugin.finder.storage.d tnU;
    private com.tencent.mm.plugin.finder.storage.ab tnV;
    private com.tencent.mm.plugin.finder.storage.e tnW;
    private com.tencent.mm.plugin.finder.storage.ag tnX;
    private com.tencent.mm.plugin.finder.storage.y tnY;
    private com.tencent.mm.plugin.finder.storage.t tnZ;
    private final String toA;
    private final String toB;
    private final kotlin.f toC;
    private final kotlin.f toD;
    private final ae toE;
    private final kotlin.f toF;
    private final kotlin.f toG;
    private final kotlin.f toH;
    private final ac toI;
    private volatile boolean toJ;
    private final Set<MMFinderUI> toK;
    private final Set<MMFinderUI> toL;
    private long toM;
    private final c toN;
    private boolean toO;
    private final ConcurrentHashMap<String, Boolean> toP;
    private final com.tencent.mm.plugin.finder.utils.z toQ;
    private com.tencent.mm.plugin.finder.storage.l toa;
    private com.tencent.mm.plugin.finder.storage.logic.b tob;
    private com.tencent.mm.plugin.finder.storage.w toc;
    private com.tencent.mm.plugin.finder.extension.reddot.c tod;
    private com.tencent.mm.plugin.finder.storage.aj toe;
    private com.tencent.mm.plugin.finder.storage.m tof;
    private com.tencent.mm.plugin.finder.storage.a tog;
    private com.tencent.mm.plugin.finder.storage.v toh;
    private com.tencent.mm.plugin.finder.storage.r toi;
    private final com.tencent.mm.plugin.finder.cgi.oplog.i toj;
    private final com.tencent.mm.plugin.finder.cgi.oplog.f tok;
    private final com.tencent.mm.plugin.finder.cgi.oplog.d tol;
    private final com.tencent.mm.plugin.finder.cgi.oplog.c tom;
    private final com.tencent.mm.plugin.finder.cgi.oplog.j ton;
    private final com.tencent.mm.plugin.finder.cgi.oplog.l too;
    private final com.tencent.mm.plugin.finder.cgi.oplog.h toq;
    private final com.tencent.mm.plugin.finder.cgi.oplog.g tor;
    private final com.tencent.mm.plugin.finder.conv.j tos;
    private final com.tencent.mm.plugin.finder.newxml.a tot;
    private final com.tencent.mm.plugin.finder.cgi.oplog.e tou;
    private final com.tencent.mm.plugin.finder.cgi.oplog.b tov;
    private final com.tencent.mm.plugin.finder.cgi.oplog.a tow;
    private final com.tencent.mm.plugin.finder.api.a tox;
    private com.tencent.mm.plugin.finder.extension.reddot.f toy;
    private final kotlin.f toz;

    static {
        AppMethodBeat.i(162442);
        AppMethodBeat.o(162442);
    }

    private final com.tencent.mm.plugin.finder.conv.i getConversationUpdater() {
        AppMethodBeat.i(241911);
        com.tencent.mm.plugin.finder.conv.i iVar = (com.tencent.mm.plugin.finder.conv.i) this.toG.getValue();
        AppMethodBeat.o(241911);
        return iVar;
    }

    private final com.tencent.mm.plugin.finder.service.a getFinderContactService() {
        AppMethodBeat.i(241910);
        com.tencent.mm.plugin.finder.service.a aVar = (com.tencent.mm.plugin.finder.service.a) this.toF.getValue();
        AppMethodBeat.o(241910);
        return aVar;
    }

    private final com.tencent.mm.plugin.finder.storage.ai getFinderTeenModeConfig() {
        AppMethodBeat.i(241912);
        com.tencent.mm.plugin.finder.storage.ai aiVar = (com.tencent.mm.plugin.finder.storage.ai) this.toH.getValue();
        AppMethodBeat.o(241912);
        return aiVar;
    }

    private final com.tencent.mm.plugin.finder.service.c getGetContactInterceptor() {
        AppMethodBeat.i(241909);
        com.tencent.mm.plugin.finder.service.c cVar = (com.tencent.mm.plugin.finder.service.c) this.toD.getValue();
        AppMethodBeat.o(241909);
        return cVar;
    }

    public final com.tencent.mm.loader.g.i getFollowTlSingleExecutor() {
        AppMethodBeat.i(241907);
        com.tencent.mm.loader.g.i iVar = (com.tencent.mm.loader.g.i) this.toz.getValue();
        AppMethodBeat.o(241907);
        return iVar;
    }

    public final com.tencent.mm.plugin.finder.preload.model.a getMediaPreloadModel() {
        AppMethodBeat.i(241908);
        com.tencent.mm.plugin.finder.preload.model.a aVar = (com.tencent.mm.plugin.finder.preload.model.a) this.toC.getValue();
        AppMethodBeat.o(241908);
        return aVar;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class y extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ String UGQ;
        final /* synthetic */ String gZs;
        final /* synthetic */ PluginFinder toS;
        final /* synthetic */ String tpB;
        final /* synthetic */ long tpC;
        final /* synthetic */ String tpD;
        final /* synthetic */ String tpE;
        final /* synthetic */ Long tpj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        y(PluginFinder pluginFinder, Context context, String str, long j2, Long l, String str2, String str3, String str4, String str5) {
            super(0);
            this.toS = pluginFinder;
            this.$context = context;
            this.tpB = str;
            this.tpC = j2;
            this.tpj = l;
            this.tpD = str2;
            this.gZs = str3;
            this.tpE = str4;
            this.UGQ = str5;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "invoke"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.b<FinderObject, kotlin.x> {
            final /* synthetic */ AnonymousClass1 tpI;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(AnonymousClass1 r2) {
                super(1);
                this.tpI = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ kotlin.x invoke(FinderObject finderObject) {
                AppMethodBeat.i(241872);
                this.tpI.a(finderObject, true);
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(241872);
                return xVar;
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(241873);
            AnonymousClass1 r9 = new kotlin.g.a.m<FinderObject, Boolean, kotlin.x>(this) {
                /* class com.tencent.mm.plugin.finder.PluginFinder.y.AnonymousClass1 */
                final /* synthetic */ y tpF;

                {
                    this.tpF = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // kotlin.g.a.m
                public final /* synthetic */ kotlin.x invoke(FinderObject finderObject, Boolean bool) {
                    AppMethodBeat.i(241870);
                    a(finderObject, bool.booleanValue());
                    kotlin.x xVar = kotlin.x.SXb;
                    AppMethodBeat.o(241870);
                    return xVar;
                }

                public final void a(final FinderObject finderObject, boolean z) {
                    AppMethodBeat.i(241871);
                    if (finderObject == null) {
                        Log.e("Finder.PluginFinder", "enterFinderProfileUI requestFinderObject null");
                        if (z) {
                            com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                                /* class com.tencent.mm.plugin.finder.PluginFinder.y.AnonymousClass1.AnonymousClass1 */
                                final /* synthetic */ AnonymousClass1 tpG;

                                {
                                    this.tpG = r2;
                                }

                                /* Return type fixed from 'java.lang.Object' to match base method */
                                @Override // kotlin.g.a.a
                                public final /* synthetic */ kotlin.x invoke() {
                                    AppMethodBeat.i(241868);
                                    com.tencent.mm.ui.base.u.makeText(this.tpG.tpF.$context, (int) R.string.h76, 0).show();
                                    kotlin.x xVar = kotlin.x.SXb;
                                    AppMethodBeat.o(241868);
                                    return xVar;
                                }
                            });
                            AppMethodBeat.o(241871);
                            return;
                        }
                    } else {
                        com.tencent.mm.plugin.expt.hellhound.core.b.aoW(this.tpF.tpB);
                        com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                            /* class com.tencent.mm.plugin.finder.PluginFinder.y.AnonymousClass1.AnonymousClass2 */
                            final /* synthetic */ AnonymousClass1 tpG;

                            {
                                this.tpG = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ kotlin.x invoke() {
                                AppMethodBeat.i(241869);
                                if (kotlin.g.b.p.j(finderObject.username, com.tencent.mm.model.z.aUg())) {
                                    this.tpG.tpF.toS.enterFinderLiveAnchorUI(this.tpG.tpF.$context, this.tpG.tpF.tpC, this.tpG.tpF.tpj, this.tpG.tpF.tpD, this.tpG.tpF.gZs, this.tpG.tpF.tpB, this.tpG.tpF.tpE, this.tpG.tpF.UGQ);
                                } else {
                                    com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                                    Context context = this.tpG.tpF.$context;
                                    long j2 = this.tpG.tpF.tpC;
                                    long longValue = this.tpG.tpF.tpj.longValue();
                                    String str = finderObject.username;
                                    if (str == null) {
                                        str = "";
                                    }
                                    String str2 = this.tpG.tpF.tpD;
                                    String str3 = this.tpG.tpF.gZs;
                                    if (str3 == null) {
                                        str3 = "";
                                    }
                                    String str4 = this.tpG.tpF.tpB;
                                    awe awe = finderObject.liveInfo;
                                    com.tencent.mm.plugin.finder.utils.a.a(context, j2, longValue, str, str2, str3, str4, awe != null ? awe.LGU : 0, this.tpG.tpF.tpE, this.tpG.tpF.UGQ);
                                }
                                kotlin.x xVar = kotlin.x.SXb;
                                AppMethodBeat.o(241869);
                                return xVar;
                            }
                        });
                    }
                    AppMethodBeat.o(241871);
                }
            };
            if ((this.tpD.length() > 0) && (!kotlin.g.b.p.j(String.valueOf(this.tpC), this.tpD))) {
                r9.a(this.toS.tryGetFinderObject(this.tpC, this.tpD, 0, false, Boolean.TRUE, new a(r9)), false);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(241873);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u0016\u0010\u0006\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u00072\u000e\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
    static final class aj<T, R> implements com.tencent.mm.loader.f.e<com.tencent.mm.plugin.finder.loader.o, Bitmap> {
        final /* synthetic */ View tpR;

        aj(View view) {
            this.tpR = view;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.h.a.a, com.tencent.mm.loader.e.b.g, java.lang.Object] */
        @Override // com.tencent.mm.loader.f.e
        public final /* synthetic */ void a(com.tencent.mm.loader.h.a.a<com.tencent.mm.plugin.finder.loader.o> aVar, com.tencent.mm.loader.e.b.g gVar, Bitmap bitmap) {
            AppMethodBeat.i(241892);
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null) {
                final Bitmap copy = bitmap2.copy(bitmap2.getConfig(), true);
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                    /* class com.tencent.mm.plugin.finder.PluginFinder.aj.AnonymousClass1 */
                    final /* synthetic */ aj tpS;

                    {
                        this.tpS = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ kotlin.x invoke() {
                        AppMethodBeat.i(241891);
                        if (this.tpS.tpR instanceof QImageView) {
                            View view = this.tpS.tpR;
                            if (view == null) {
                                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.widget.QImageView");
                                AppMethodBeat.o(241891);
                                throw tVar;
                            }
                            ((QImageView) view).setImageBitmap(copy);
                        } else if (this.tpS.tpR instanceof MMImageView) {
                            View view2 = this.tpS.tpR;
                            if (view2 == null) {
                                kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMImageView");
                                AppMethodBeat.o(241891);
                                throw tVar2;
                            }
                            ((MMImageView) view2).setImageBitmap(copy);
                        }
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(241891);
                        return xVar;
                    }
                });
                AppMethodBeat.o(241892);
                return;
            }
            Log.i("Finder.PluginFinder", "setBlurBitmap error, result is null!");
            AppMethodBeat.o(241892);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class ar<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ long tpC;
        final /* synthetic */ z.f tpY;
        final /* synthetic */ Object tpZ;
        final /* synthetic */ z.a tqa;

        ar(z.f fVar, Object obj, z.a aVar, long j2) {
            this.tpY = fVar;
            this.tpZ = obj;
            this.tqa = aVar;
            this.tpC = j2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
            if (com.tencent.mm.plugin.finder.utils.y.gp(r6.errType, r6.errCode) != false) goto L_0x001d;
         */
        @Override // com.tencent.mm.vending.c.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ java.lang.Object call(java.lang.Object r6) {
            /*
            // Method dump skipped, instructions count: 117
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.PluginFinder.ar.call(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderStatsReportResponse;", "kotlin.jvm.PlatformType", "call"})
    static final class as<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ z.f tqb;

        as(z.f fVar) {
            this.tqb = fVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(241903);
            c.a aVar = (c.a) obj;
            if (aVar.errCode == 0 && aVar.errType == 0) {
                Log.i("Finder.PluginFinder", "successfully! size=" + this.tqb.SYG.size());
            } else {
                Log.w("Finder.PluginFinder", "fail to report! size=" + this.tqb.SYG.size());
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(241903);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class au<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ long tpC;
        final /* synthetic */ kotlin.g.a.b tqd;

        au(kotlin.g.a.b bVar, long j2) {
            this.tqd = bVar;
            this.tpC = j2;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(241906);
            c.a aVar = (c.a) obj;
            if (!(aVar.errType == 0 && aVar.errCode == 0)) {
                com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                if (!com.tencent.mm.plugin.finder.utils.y.gp(aVar.errType, aVar.errCode)) {
                    kotlin.g.a.b bVar = this.tqd;
                    if (bVar != null) {
                        bVar.invoke(null);
                    }
                    Log.i("Finder.PluginFinder", "tryGetFinderObject " + this.tpC + ", finish");
                    kotlin.x xVar = kotlin.x.SXb;
                    AppMethodBeat.o(241906);
                    return xVar;
                }
            }
            FinderObject finderObject = ((ars) aVar.iLC).feedObject;
            if (finderObject != null) {
                FinderItem.a aVar2 = FinderItem.Companion;
                kotlin.g.b.p.g(finderObject, "newFeed");
                FinderItem a2 = FinderItem.a.a(finderObject, 1);
                e.a aVar3 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
                e.a.n(a2);
                kotlin.g.a.b bVar2 = this.tqd;
                if (bVar2 != null) {
                    bVar2.invoke(finderObject);
                }
            }
            Log.i("Finder.PluginFinder", "tryGetFinderObject " + this.tpC + ", finish");
            kotlin.x xVar2 = kotlin.x.SXb;
            AppMethodBeat.o(241906);
            return xVar2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderBatchGetObjectAsyncLoadInfoResponse;", LocaleUtil.ITALIAN, "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.b<c.a<aox>, c.a<aox>> {
        final /* synthetic */ aj.a tpd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(aj.a aVar) {
            super(1);
            this.tpd = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ c.a<aox> invoke(c.a<aox> aVar) {
            LinkedHashMap linkedHashMap;
            LinkedList<azq> linkedList;
            int i2;
            AppMethodBeat.i(241836);
            c.a<aox> aVar2 = aVar;
            if (aVar2 != null) {
                if (aVar2.errType == 0 && aVar2.errCode == 0) {
                    aj.a aVar3 = this.tpd;
                    aox aox = (aox) aVar2.iLC;
                    if (aox == null || (linkedList = aox.LAV) == null) {
                        linkedHashMap = new HashMap();
                    } else {
                        LinkedList<azq> linkedList2 = linkedList;
                        linkedHashMap = new LinkedHashMap(kotlin.k.j.mZ(kotlin.a.ae.atJ(kotlin.a.j.a(linkedList2, 10)), 16));
                        for (T t : linkedList2) {
                            Long valueOf = Long.valueOf(t.object_id);
                            awe awe = t.LJv;
                            if (awe != null) {
                                i2 = awe.liveStatus;
                            } else {
                                i2 = 1;
                            }
                            kotlin.o U = kotlin.s.U(valueOf, Integer.valueOf(i2));
                            linkedHashMap.put(U.first, U.second);
                        }
                    }
                    aVar3.e(linkedHashMap, ((aox) aVar2.iLC).LAY);
                } else {
                    this.tpd.e(new HashMap(), 0);
                }
                AppMethodBeat.o(241836);
                return aVar2;
            }
            AppMethodBeat.o(241836);
            return null;
        }
    }

    public PluginFinder() {
        AppMethodBeat.i(165123);
        g.a aVar = com.tencent.mm.plugin.finder.upload.g.vSJ;
        this.tnS = com.tencent.mm.plugin.finder.upload.g.dBa();
        this.tnT = new com.tencent.mm.plugin.finder.extension.a();
        this.toj = new com.tencent.mm.plugin.finder.cgi.oplog.i();
        this.tok = new com.tencent.mm.plugin.finder.cgi.oplog.f();
        this.tol = new com.tencent.mm.plugin.finder.cgi.oplog.d();
        this.tom = new com.tencent.mm.plugin.finder.cgi.oplog.c();
        this.ton = new com.tencent.mm.plugin.finder.cgi.oplog.j();
        this.too = new com.tencent.mm.plugin.finder.cgi.oplog.l();
        this.toq = new com.tencent.mm.plugin.finder.cgi.oplog.h();
        this.tor = new com.tencent.mm.plugin.finder.cgi.oplog.g();
        this.tos = new com.tencent.mm.plugin.finder.conv.j();
        this.tot = new com.tencent.mm.plugin.finder.newxml.a();
        this.UGN = new com.tencent.mm.plugin.finder.newxml.b();
        this.tou = new com.tencent.mm.plugin.finder.cgi.oplog.e();
        this.tov = new com.tencent.mm.plugin.finder.cgi.oplog.b();
        this.tow = new com.tencent.mm.plugin.finder.cgi.oplog.a();
        this.UGO = new com.tencent.mm.plugin.finder.service.g();
        this.tox = new com.tencent.mm.plugin.finder.api.a();
        this.toz = kotlin.g.ah(ag.tpN);
        this.toA = MD5Util.getMD5String("FinderMM029.dbFinderMention001.db");
        this.toB = MD5Util.getMD5String("FinderMM029.dbFinderMention001.db");
        this.toC = kotlin.g.ah(al.tpU);
        this.toD = kotlin.g.ah(ah.tpO);
        this.toE = new ae(this);
        this.toF = kotlin.g.ah(ad.tpL);
        this.toG = kotlin.g.ah(w.tpz);
        this.toH = kotlin.g.ah(af.tpM);
        this.kIM = at.tqc;
        this.hvF = new ak();
        this.toI = new ac(this);
        this.toK = Collections.synchronizedSet(new HashSet());
        this.toL = Collections.synchronizedSet(new HashSet());
        this.hWh = com.tencent.mm.model.d.aTu();
        this.toN = new c(this);
        this.toP = new ConcurrentHashMap<>();
        this.FE = new ViewModelStore();
        this.toQ = new com.tencent.mm.plugin.finder.utils.z();
        AppMethodBeat.o(165123);
    }

    public static final /* synthetic */ void access$CgiGetLiveInfo(PluginFinder pluginFinder, long j2, aj.b bVar) {
        AppMethodBeat.i(241994);
        pluginFinder.CgiGetLiveInfo(j2, bVar);
        AppMethodBeat.o(241994);
    }

    public static final /* synthetic */ void access$doFinderInit(PluginFinder pluginFinder) {
        AppMethodBeat.i(165124);
        pluginFinder.doFinderInit();
        AppMethodBeat.o(165124);
    }

    public static final /* synthetic */ void access$doSomethingImportantOnStart(PluginFinder pluginFinder) {
        AppMethodBeat.i(241995);
        pluginFinder.doSomethingImportantOnStart();
        AppMethodBeat.o(241995);
    }

    public static final /* synthetic */ void access$requestAudioFocus(PluginFinder pluginFinder) {
        AppMethodBeat.i(165125);
        pluginFinder.requestAudioFocus();
        AppMethodBeat.o(165125);
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final /* synthetic */ void enterFinderTimelineUI(Context context, Intent intent, Boolean bool) {
        AppMethodBeat.i(241931);
        enterFinderTimelineUI(context, intent, bool.booleanValue());
        AppMethodBeat.o(241931);
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final /* synthetic */ void getLiveInfo(Long l2, aj.b bVar) {
        AppMethodBeat.i(241936);
        getLiveInfo(l2.longValue(), bVar);
        AppMethodBeat.o(241936);
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final /* synthetic */ void refreshLiveStatus(Long l2, aj.b bVar) {
        AppMethodBeat.i(241933);
        refreshLiveStatus(l2.longValue(), bVar);
        AppMethodBeat.o(241933);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/PluginFinder$Companion;", "", "()V", "ID_KEY_POST_RED_DOT", "", "KV_ID_POST_RED_DOT", "", "TAG", "", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public final com.tencent.mm.storagebase.h getDataDB() {
        return this.hqK;
    }

    public final void setDataDB(com.tencent.mm.storagebase.h hVar) {
        this.hqK = hVar;
    }

    public final com.tencent.mm.storagebase.h getFinderMentionDB() {
        return this.tnO;
    }

    public final void setFinderMentionDB(com.tencent.mm.storagebase.h hVar) {
        this.tnO = hVar;
    }

    public final com.tencent.mm.storagebase.h getWxMentionDB() {
        return this.tnP;
    }

    public final void setWxMentionDB(com.tencent.mm.storagebase.h hVar) {
        this.tnP = hVar;
    }

    public final com.tencent.mm.storagebase.h getMessageDB() {
        return this.tnQ;
    }

    public final void setMessageDB(com.tencent.mm.storagebase.h hVar) {
        this.tnQ = hVar;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/PluginFinder$finderSyncEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderSyncEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class ae extends IListener<id> {
        final /* synthetic */ PluginFinder toS;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        ae(PluginFinder pluginFinder) {
            this.toS = pluginFinder;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(id idVar) {
            AppMethodBeat.i(165069);
            id idVar2 = idVar;
            if (idVar2 == null || !idVar2.dMJ.dMK) {
                this.toS.tnT.fX(47613, 3);
                AppMethodBeat.o(165069);
            } else {
                this.toS.tnT.fX(idVar2.dMJ.dML, idVar2.dMJ.scene);
                AppMethodBeat.o(165069);
            }
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDataChanged"})
    static final class at implements com.tencent.mm.plugin.teenmode.a.c {
        public static final at tqc = new at();

        static {
            AppMethodBeat.i(241905);
            AppMethodBeat.o(241905);
        }

        at() {
        }

        @Override // com.tencent.mm.plugin.teenmode.a.c
        public final void onDataChanged() {
            com.tencent.mm.plugin.finder.extension.reddot.k kVar;
            com.tencent.mm.plugin.finder.extension.reddot.k kVar2;
            boolean z;
            AppMethodBeat.i(241904);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((FinderHomeTabStateVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).resetCache();
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class);
            kotlin.g.b.p.g(ah, "MMKernel.plugin(IPluginFinder::class.java)");
            com.tencent.mm.plugin.i.a.z redDotManager = ((com.tencent.mm.plugin.i.a.aj) ah).getRedDotManager();
            if (redDotManager == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.extension.reddot.FinderRedDotManager");
                AppMethodBeat.o(241904);
                throw tVar;
            }
            com.tencent.mm.plugin.finder.extension.reddot.f fVar = (com.tencent.mm.plugin.finder.extension.reddot.f) redDotManager;
            if (fVar != null) {
                Enumeration<String> keys = fVar.tJJ.keys();
                kotlin.g.b.p.g(keys, "pathToCtrInfoMap.keys()");
                ArrayList list = Collections.list(keys);
                kotlin.g.b.p.g(list, "java.util.Collections.list(this)");
                ArrayList<String> arrayList = list;
                Log.i("Finder.RedDotManager", "resetNotifyAllPathWithCrlInfo#reset, list:".concat(String.valueOf(arrayList)));
                for (String str : arrayList) {
                    List<com.tencent.mm.plugin.finder.extension.reddot.k> list2 = fVar.tJJ.get(str);
                    if (list2 != null) {
                        ListIterator<com.tencent.mm.plugin.finder.extension.reddot.k> listIterator = list2.listIterator(list2.size());
                        while (true) {
                            if (!listIterator.hasPrevious()) {
                                kVar2 = null;
                                break;
                            }
                            com.tencent.mm.plugin.finder.extension.reddot.k previous = listIterator.previous();
                            kotlin.g.b.p.g(str, "path");
                            if (previous.atl(str) != null) {
                                z = true;
                                continue;
                            } else {
                                z = false;
                                continue;
                            }
                            if (z) {
                                kVar2 = previous;
                                break;
                            }
                        }
                        kVar = kVar2;
                    } else {
                        kVar = null;
                    }
                    com.tencent.mm.plugin.finder.extension.reddot.h hVar = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
                    kotlin.g.b.p.g(str, "path");
                    com.tencent.mm.plugin.finder.extension.reddot.h.a(false, str, kVar != null ? kVar.atl(str) : null, kVar);
                }
                fVar.tJJ.clear();
                LinkedList<com.tencent.mm.plugin.finder.extension.reddot.k> daw = fVar.tJN.daw();
                int size = daw.size();
                com.tencent.mm.plugin.finder.extension.reddot.d dVar = com.tencent.mm.plugin.finder.extension.reddot.d.tJq;
                Log.i("Finder.RedDotManager", "resetNotifyAllPathWithCrlInfo#build checkRet=" + com.tencent.mm.plugin.finder.extension.reddot.d.a(daw, fVar.tJN) + " beforeCheckCount=" + size + " afterCheckCount=" + daw.size());
                for (T t : daw) {
                    if (t.dbz()) {
                        Log.w("Finder.RedDotManager", "[resetNotifyAllPathWithCrlInfo] showInfo is empty! ".concat(String.valueOf(t)));
                        t.b(fVar.tJN, false);
                    } else {
                        bbi bbi = ((com.tencent.mm.plugin.finder.extension.reddot.k) t).field_ctrInfo;
                        kotlin.g.b.p.g(bbi, "it.field_ctrInfo");
                        fVar.a(t.f(bbi), "resetNotifyAllPathWithCrlInfo");
                    }
                }
                Enumeration<String> keys2 = fVar.tJJ.keys();
                kotlin.g.b.p.g(keys2, "pathToCtrInfoMap.keys()");
                ArrayList list3 = Collections.list(keys2);
                kotlin.g.b.p.g(list3, "java.util.Collections.list(this)");
                ArrayList<String> arrayList2 = list3;
                Log.i("Finder.RedDotManager", "resetNotifyAllPathWithCrlInfo#notify, list:".concat(String.valueOf(arrayList2)));
                for (String str2 : arrayList2) {
                    kotlin.g.b.p.g(str2, LocaleUtil.ITALIAN);
                    com.tencent.mm.plugin.finder.extension.reddot.k asX = fVar.asX(str2);
                    com.tencent.mm.plugin.finder.extension.reddot.h hVar2 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
                    com.tencent.mm.plugin.finder.extension.reddot.h.a((asX != null ? asX.atl(str2) : null) != null, str2, asX != null ? asX.atl(str2) : null, asX);
                }
            }
            ((com.tencent.mm.plugin.i.a.m) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.m.class)).dqf();
            AppMethodBeat.o(241904);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/PluginFinder$logoutEvent$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/LogoutEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class ak extends IListener<ma> {
        ak() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ma maVar) {
            AppMethodBeat.i(241893);
            com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
            com.tencent.mm.plugin.finder.live.model.o.dgj();
            AppMethodBeat.o(241893);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final com.tencent.mm.plugin.finder.extension.reddot.f getRedDotManager() {
        AppMethodBeat.i(178072);
        com.tencent.mm.plugin.finder.extension.reddot.f fVar = this.toy;
        if (fVar == null) {
            fVar = new com.tencent.mm.plugin.finder.extension.reddot.f(getRedDotCtrInfoStorage());
        }
        this.toy = fVar;
        com.tencent.mm.plugin.finder.extension.reddot.f fVar2 = this.toy;
        if (fVar2 == null) {
            kotlin.g.b.p.hyc();
        }
        AppMethodBeat.o(178072);
        return fVar2;
    }

    private final void checkResetDb() {
        AppMethodBeat.i(165077);
        Log.v("Finder.PluginFinder", "checkResetDb1 " + this.tnN);
        if (this.tnN) {
            Log.v("Finder.PluginFinder", "checkResetDb2 " + this.tnN);
            synchronized (this.lock) {
                try {
                    StringBuilder sb = new StringBuilder("checkResetDb  need reset DB now ");
                    Thread currentThread = Thread.currentThread();
                    kotlin.g.b.p.g(currentThread, "Thread.currentThread()");
                    StringBuilder append = sb.append(currentThread.getName()).append(" ");
                    Thread currentThread2 = Thread.currentThread();
                    kotlin.g.b.p.g(currentThread2, "Thread.currentThread()");
                    Log.i("Finder.PluginFinder", append.append(currentThread2.getId()).append(" ").append(hashCode()).toString());
                    if (this.tnN) {
                        resetDb();
                        this.tnN = false;
                        Log.i("Finder.PluginFinder", "resetDB done");
                    }
                    kotlin.x xVar = kotlin.x.SXb;
                } finally {
                    AppMethodBeat.o(165077);
                }
            }
            return;
        }
        AppMethodBeat.o(165077);
    }

    private final boolean isNeedDoReInit() {
        boolean z2;
        AppMethodBeat.i(241913);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_USER_HARD_REINIT_INT_SYNC, -1);
        com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
        int i3 = aAh2.azQ().getInt(ar.a.USERINFO_FINDER_USER_VERSION_INT_SYNC, 0);
        com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh3, "MMKernel.storage()");
        int i4 = aAh3.azQ().getInt(ar.a.USERINFO_FINDER_REINIT_USER_VERSION_INT_SYNC, 0);
        com.tencent.mm.kernel.e aAh4 = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh4, "MMKernel.storage()");
        Object obj = aAh4.azQ().get(ar.a.USERINFO_MY_FINDER_REINIT_USERNAME_STRING_SYNC, "");
        if (obj == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(241913);
            throw tVar;
        }
        String str = (String) obj;
        if (!(i2 != -1 || i3 == i4 || i4 == 0)) {
            com.tencent.mm.kernel.e aAh5 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh5, "MMKernel.storage()");
            aAh5.azQ().set(ar.a.USERINFO_FINDER_USER_HARD_REINIT_INT_SYNC, (Object) 1);
            i2 = 1;
        }
        StringBuilder append = new StringBuilder("[isNeedDoReInit] userVersion=").append(i3).append(", reInitUserVersion=").append(i4).append(", reInitUsername=").append(str).append(" isNeedDoReInit=");
        if (i2 == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        Log.i("Finder.PluginFinder", append.append(z2).toString());
        if (i2 == 1) {
            AppMethodBeat.o(241913);
            return true;
        }
        AppMethodBeat.o(241913);
        return false;
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void loadImageForSns(String str, View view) {
        AppMethodBeat.i(241914);
        kotlin.g.b.p.h(view, "qImageView");
        com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
        com.tencent.mm.plugin.finder.loader.m.djY().bQ(new com.tencent.mm.plugin.finder.loader.p(str, com.tencent.mm.plugin.finder.storage.x.FULL_IMAGE)).a(new aj(view)).vC();
        AppMethodBeat.o(241914);
    }

    private final void resetDb() {
        AppMethodBeat.i(165078);
        if (this.hqK == null) {
            this.hqK = new com.tencent.mm.storagebase.h();
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            String str = aAh.azM() + "FinderMM029.db";
            com.tencent.mm.storagebase.h hVar = this.hqK;
            if (hVar == null) {
                kotlin.g.b.p.hyc();
            }
            if (!hVar.a(str, collectFinderDatabaseFactory(), true)) {
                SQLiteException sQLiteException = new SQLiteException("finder db init failed");
                AppMethodBeat.o(165078);
                throw sQLiteException;
            }
        }
        if (this.tnO == null) {
            this.tnO = new com.tencent.mm.storagebase.h();
            com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
            String str2 = aAh2.azM() + "FinderMention001.db";
            com.tencent.mm.storagebase.h hVar2 = this.tnO;
            if (hVar2 == null) {
                kotlin.g.b.p.hyc();
            }
            if (!hVar2.a(str2, collectMentionDatabaseFactory(), true)) {
                SQLiteException sQLiteException2 = new SQLiteException("finder finder mention db init failed");
                AppMethodBeat.o(165078);
                throw sQLiteException2;
            }
            checkIfSameMsgTableName();
            com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh3, "MMKernel.storage()");
            aAh3.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_MSG_TABLE_NAME_STRING_SYNC, cm.fFh);
            com.tencent.mm.kernel.e aAh4 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh4, "MMKernel.storage()");
            aAh4.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_WX_MSG_TABLE_NAME_STRING_SYNC, cm.fFi);
        }
        if (this.tnQ == null) {
            com.tencent.mm.storagebase.h hVar3 = new com.tencent.mm.storagebase.h();
            com.tencent.mm.kernel.e aAh5 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh5, "MMKernel.storage()");
            if (!hVar3.a(aAh5.azM() + "FinderMessage006.db", collectMessageDatabaseFactory(), true)) {
                SQLiteException sQLiteException3 = new SQLiteException("message db init failed");
                AppMethodBeat.o(165078);
                throw sQLiteException3;
            }
            this.tnQ = hVar3;
        }
        if (this.tnP == null) {
            this.tnP = new com.tencent.mm.storagebase.h();
            com.tencent.mm.kernel.e aAh6 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh6, "MMKernel.storage()");
            String str3 = aAh6.azM() + "FinderMention002.db";
            com.tencent.mm.storagebase.h hVar4 = this.tnP;
            if (hVar4 == null) {
                kotlin.g.b.p.hyc();
            }
            if (!hVar4.a(str3, collectMentionDatabaseFactory(), true)) {
                SQLiteException sQLiteException4 = new SQLiteException("finder wx mention db init failed");
                AppMethodBeat.o(165078);
                throw sQLiteException4;
            }
        }
        AppMethodBeat.o(165078);
    }

    private final void checkIfSameMsgTableName() {
        boolean z2;
        AppMethodBeat.i(241915);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(ar.a.USERINFO_FINDER_GET_FINDER_MSG_TABLE_NAME_STRING_SYNC, "");
        if (obj == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(241915);
            throw tVar;
        }
        String str = (String) obj;
        com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
        Object obj2 = aAh2.azQ().get(ar.a.USERINFO_FINDER_GET_FINDER_WX_MSG_TABLE_NAME_STRING_SYNC, "");
        if (obj2 == null) {
            kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(241915);
            throw tVar2;
        }
        String str2 = (String) obj2;
        if ((str.length() > 0) && (!kotlin.g.b.p.j(str, cm.fFh))) {
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            com.tencent.mm.plugin.finder.utils.y.dCJ();
        }
        if (str2.length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 && (!kotlin.g.b.p.j(str2, cm.fFi))) {
            com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
            com.tencent.mm.plugin.finder.utils.y.dCK();
        }
        AppMethodBeat.o(241915);
    }

    private final void clearMentionDB() {
        AppMethodBeat.i(165079);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        String azM = aAh.azM();
        com.tencent.mm.vfs.s.deleteFile(azM + "FinderMention001.db");
        com.tencent.mm.vfs.s.deleteFile(azM + "FinderMention002.db");
        this.tnO = null;
        this.tnP = null;
        AppMethodBeat.o(165079);
    }

    private final com.tencent.mm.storagebase.h getDB() {
        AppMethodBeat.i(165080);
        checkResetDb();
        com.tencent.mm.storagebase.h hVar = this.hqK;
        if (hVar == null) {
            kotlin.g.b.p.hyc();
        }
        AppMethodBeat.o(165080);
        return hVar;
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public final void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(162434);
        kotlin.g.b.p.h(gVar, Scopes.PROFILE);
        AppMethodBeat.o(162434);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "", "getSQLs", "()[Ljava/lang/String;"})
    static final class h implements h.b {
        public static final h tpk = new h();

        static {
            AppMethodBeat.i(165057);
            AppMethodBeat.o(165057);
        }

        h() {
        }

        @Override // com.tencent.mm.storagebase.h.b
        public final String[] getSQLs() {
            AppMethodBeat.i(165056);
            y.a aVar = com.tencent.mm.plugin.finder.storage.y.vEE;
            kotlin.g.b.p.h("findermessage006", SharePluginInfo.ISSUE_KEY_TABLE);
            b.a aVar2 = com.tencent.mm.plugin.byp.b.pOW;
            String createSQLs = MAutoStorage.getCreateSQLs(com.tencent.mm.plugin.byp.b.access$getInfo$cp(), "findermessage006");
            kotlin.g.b.p.g(createSQLs, "getCreateSQLs(BypMsgInfo.info, table)");
            String[] strArr = {createSQLs, "CREATE INDEX IF NOT EXISTS  " + "findermessage006" + "SvrIdIndex ON " + "findermessage006" + " ( msgSvrId )", "CREATE INDEX IF NOT EXISTS  " + "findermessage006" + "TalkerIndex ON " + "findermessage006" + " ( talker )", "CREATE INDEX IF NOT EXISTS  " + "findermessage006" + "TalkerStatusIndex ON " + "findermessage006" + " ( talker,status )", "CREATE INDEX IF NOT EXISTS  " + "findermessage006" + "CreateTimeIndex ON " + "findermessage006" + " ( createTime )", "CREATE INDEX IF NOT EXISTS  " + "findermessage006" + "CreateTalkerTimeIndex ON " + "findermessage006" + " ( talker,createTime )", "CREATE INDEX IF NOT EXISTS  " + "findermessage006" + "SendCreateTimeIndex ON " + "findermessage006" + " ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS  " + "findermessage006" + "TalkerTypeIndex ON " + "findermessage006" + " ( talker,type )"};
            AppMethodBeat.o(165056);
            return strArr;
        }
    }

    @Override // com.tencent.mm.kernel.api.a
    public final HashMap<Integer, h.b> collectDatabaseFactory() {
        AppMethodBeat.i(162433);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf("findermessage006".hashCode()), h.tpk);
        AppMethodBeat.o(162433);
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    public static final class i implements h.b {
        public static final i tpl = new i();

        static {
            AppMethodBeat.i(241841);
            AppMethodBeat.o(241841);
        }

        i() {
        }

        @Override // com.tencent.mm.storagebase.h.b
        public final String[] getSQLs() {
            AppMethodBeat.i(241840);
            d.a aVar = com.tencent.mm.plugin.finder.storage.d.vDj;
            String[] dax = com.tencent.mm.plugin.finder.storage.d.dax();
            AppMethodBeat.o(241840);
            return dax;
        }
    }

    private final HashMap<Integer, h.b> collectFinderDatabaseFactory() {
        AppMethodBeat.i(241916);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf("FINDER_CONTACT_TABLE".hashCode()), i.tpl);
        hashMap.put(Integer.valueOf("FinderMsgContactStorage".hashCode()), k.tpn);
        hashMap.put(Integer.valueOf("FINDER_FEED_TABLE".hashCode()), l.tpo);
        hashMap.put(Integer.valueOf("FINDER_DRAFT_TABLE".hashCode()), m.tpp);
        hashMap.put(Integer.valueOf("FinderMediaCacheInfoV2".hashCode()), n.tpq);
        hashMap.put(Integer.valueOf("FinderRedDotInfo".hashCode()), o.tpr);
        hashMap.put(Integer.valueOf("FinderAction".hashCode()), p.tps);
        v.a aVar = com.tencent.mm.plugin.finder.storage.v.vEl;
        hashMap.put(Integer.valueOf(com.tencent.mm.plugin.finder.storage.v.dxM().hashCode()), q.tpt);
        r.a aVar2 = com.tencent.mm.plugin.finder.storage.r.vEh;
        hashMap.put(Integer.valueOf(com.tencent.mm.plugin.finder.storage.r.dxM().hashCode()), r.tpu);
        hashMap.put(Integer.valueOf("FinderLiveGiftInfo".hashCode()), j.tpm);
        hashMap.put(Integer.valueOf("FinderLiveLuckyMoneyInfo".hashCode()), av.UGP);
        AppMethodBeat.o(241916);
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    public static final class k implements h.b {
        public static final k tpn = new k();

        static {
            AppMethodBeat.i(241845);
            AppMethodBeat.o(241845);
        }

        k() {
        }

        @Override // com.tencent.mm.storagebase.h.b
        public final String[] getSQLs() {
            AppMethodBeat.i(241844);
            ab.a aVar = com.tencent.mm.plugin.finder.storage.ab.vEP;
            String[] dax = com.tencent.mm.plugin.finder.storage.ab.dax();
            AppMethodBeat.o(241844);
            return dax;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    public static final class l implements h.b {
        public static final l tpo = new l();

        static {
            AppMethodBeat.i(241847);
            AppMethodBeat.o(241847);
        }

        l() {
        }

        @Override // com.tencent.mm.storagebase.h.b
        public final String[] getSQLs() {
            AppMethodBeat.i(241846);
            l.a aVar = com.tencent.mm.plugin.finder.storage.l.vDM;
            String[] dax = com.tencent.mm.plugin.finder.storage.l.dax();
            AppMethodBeat.o(241846);
            return dax;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    public static final class m implements h.b {
        public static final m tpp = new m();

        static {
            AppMethodBeat.i(241849);
            AppMethodBeat.o(241849);
        }

        m() {
        }

        @Override // com.tencent.mm.storagebase.h.b
        public final String[] getSQLs() {
            AppMethodBeat.i(241848);
            b.a aVar = com.tencent.mm.plugin.finder.storage.logic.b.vGL;
            String[] dax = com.tencent.mm.plugin.finder.storage.logic.b.dax();
            AppMethodBeat.o(241848);
            return dax;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    public static final class n implements h.b {
        public static final n tpq = new n();

        static {
            AppMethodBeat.i(241851);
            AppMethodBeat.o(241851);
        }

        n() {
        }

        @Override // com.tencent.mm.storagebase.h.b
        public final String[] getSQLs() {
            AppMethodBeat.i(241850);
            w.a aVar = com.tencent.mm.plugin.finder.storage.w.vEm;
            String[] dax = com.tencent.mm.plugin.finder.storage.w.dax();
            AppMethodBeat.o(241850);
            return dax;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    public static final class o implements h.b {
        public static final o tpr = new o();

        static {
            AppMethodBeat.i(241853);
            AppMethodBeat.o(241853);
        }

        o() {
        }

        @Override // com.tencent.mm.storagebase.h.b
        public final String[] getSQLs() {
            AppMethodBeat.i(241852);
            c.a aVar = com.tencent.mm.plugin.finder.extension.reddot.c.tJp;
            String[] dax = com.tencent.mm.plugin.finder.extension.reddot.c.dax();
            AppMethodBeat.o(241852);
            return dax;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    public static final class p implements h.b {
        public static final p tps = new p();

        static {
            AppMethodBeat.i(241855);
            AppMethodBeat.o(241855);
        }

        p() {
        }

        @Override // com.tencent.mm.storagebase.h.b
        public final String[] getSQLs() {
            AppMethodBeat.i(241854);
            a.C1279a aVar = com.tencent.mm.plugin.finder.storage.a.vwq;
            String[] dax = com.tencent.mm.plugin.finder.storage.a.dax();
            AppMethodBeat.o(241854);
            return dax;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    public static final class q implements h.b {
        public static final q tpt = new q();

        static {
            AppMethodBeat.i(241857);
            AppMethodBeat.o(241857);
        }

        q() {
        }

        @Override // com.tencent.mm.storagebase.h.b
        public final String[] getSQLs() {
            AppMethodBeat.i(241856);
            v.a aVar = com.tencent.mm.plugin.finder.storage.v.vEl;
            String[] dax = com.tencent.mm.plugin.finder.storage.v.dax();
            AppMethodBeat.o(241856);
            return dax;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    public static final class r implements h.b {
        public static final r tpu = new r();

        static {
            AppMethodBeat.i(241859);
            AppMethodBeat.o(241859);
        }

        r() {
        }

        @Override // com.tencent.mm.storagebase.h.b
        public final String[] getSQLs() {
            AppMethodBeat.i(241858);
            r.a aVar = com.tencent.mm.plugin.finder.storage.r.vEh;
            String[] dax = com.tencent.mm.plugin.finder.storage.r.dax();
            AppMethodBeat.o(241858);
            return dax;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    public static final class j implements h.b {
        public static final j tpm = new j();

        static {
            AppMethodBeat.i(241843);
            AppMethodBeat.o(241843);
        }

        j() {
        }

        @Override // com.tencent.mm.storagebase.h.b
        public final String[] getSQLs() {
            AppMethodBeat.i(241842);
            t.a aVar = com.tencent.mm.plugin.finder.storage.t.vEj;
            String[] dax = com.tencent.mm.plugin.finder.storage.t.dax();
            AppMethodBeat.o(241842);
            return dax;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    public static final class av implements h.b {
        public static final av UGP = new av();

        static {
            AppMethodBeat.i(260059);
            AppMethodBeat.o(260059);
        }

        av() {
        }

        @Override // com.tencent.mm.storagebase.h.b
        public final String[] getSQLs() {
            AppMethodBeat.i(260058);
            ar.a aVar = com.tencent.mm.plugin.finder.storage.ar.UUM;
            String[] dax = com.tencent.mm.plugin.finder.storage.ar.dax();
            AppMethodBeat.o(260058);
            return dax;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    public static final class s implements h.b {
        public static final s tpv = new s();

        static {
            AppMethodBeat.i(165065);
            AppMethodBeat.o(165065);
        }

        s() {
        }

        @Override // com.tencent.mm.storagebase.h.b
        public final String[] getSQLs() {
            AppMethodBeat.i(165064);
            m.a aVar = com.tencent.mm.plugin.finder.storage.m.vDN;
            String[] dax = com.tencent.mm.plugin.finder.storage.m.dax();
            AppMethodBeat.o(165064);
            return dax;
        }
    }

    private final HashMap<Integer, h.b> collectMentionDatabaseFactory() {
        AppMethodBeat.i(165081);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf("FINDER_FINDER_MENTION_TABLE".hashCode()), s.tpv);
        hashMap.put(Integer.valueOf("FINDER_WX_MENTION_TABLE".hashCode()), t.tpw);
        AppMethodBeat.o(165081);
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    public static final class t implements h.b {
        public static final t tpw = new t();

        static {
            AppMethodBeat.i(241861);
            AppMethodBeat.o(241861);
        }

        t() {
        }

        @Override // com.tencent.mm.storagebase.h.b
        public final String[] getSQLs() {
            AppMethodBeat.i(241860);
            aj.a aVar = com.tencent.mm.plugin.finder.storage.aj.vFp;
            String[] dax = com.tencent.mm.plugin.finder.storage.aj.dax();
            AppMethodBeat.o(241860);
            return dax;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    public static final class u implements h.b {
        public static final u tpx = new u();

        static {
            AppMethodBeat.i(241863);
            AppMethodBeat.o(241863);
        }

        u() {
        }

        @Override // com.tencent.mm.storagebase.h.b
        public final String[] getSQLs() {
            AppMethodBeat.i(241862);
            e.a aVar = com.tencent.mm.plugin.finder.storage.e.vDk;
            String[] dax = com.tencent.mm.plugin.finder.storage.e.dax();
            AppMethodBeat.o(241862);
            return dax;
        }
    }

    private final HashMap<Integer, h.b> collectMessageDatabaseFactory() {
        AppMethodBeat.i(241917);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf("FinderConversation".hashCode()), u.tpx);
        hashMap.put(Integer.valueOf("FinderSessionInfo".hashCode()), v.tpy);
        AppMethodBeat.o(241917);
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    public static final class v implements h.b {
        public static final v tpy = new v();

        static {
            AppMethodBeat.i(241865);
            AppMethodBeat.o(241865);
        }

        v() {
        }

        @Override // com.tencent.mm.storagebase.h.b
        public final String[] getSQLs() {
            AppMethodBeat.i(241864);
            ag.a aVar = com.tencent.mm.plugin.finder.storage.ag.vFc;
            String[] dax = com.tencent.mm.plugin.finder.storage.ag.dax();
            AppMethodBeat.o(241864);
            return dax;
        }
    }

    @Override // com.tencent.mm.kernel.api.e
    public final void onDataBaseOpened(com.tencent.mm.storagebase.h hVar, com.tencent.mm.storagebase.h hVar2) {
    }

    @Override // com.tencent.mm.kernel.api.e
    public final void onDataBaseClosed(com.tencent.mm.storagebase.h hVar, com.tencent.mm.storagebase.h hVar2) {
    }

    public final com.tencent.mm.plugin.finder.storage.d getContactStorage() {
        AppMethodBeat.i(165082);
        com.tencent.mm.kernel.g.aAf().azk();
        com.tencent.mm.plugin.finder.storage.d dVar = this.tnU;
        if (dVar == null) {
            dVar = new com.tencent.mm.plugin.finder.storage.d(getDB());
        }
        this.tnU = dVar;
        com.tencent.mm.plugin.finder.storage.d dVar2 = this.tnU;
        if (dVar2 == null) {
            kotlin.g.b.p.hyc();
        }
        AppMethodBeat.o(165082);
        return dVar2;
    }

    public final com.tencent.mm.plugin.finder.storage.ab getMsgStrangerContactStorage() {
        AppMethodBeat.i(241918);
        com.tencent.mm.kernel.g.aAf().azk();
        com.tencent.mm.plugin.finder.storage.ab abVar = this.tnV;
        if (abVar == null) {
            abVar = new com.tencent.mm.plugin.finder.storage.ab(getDB());
        }
        this.tnV = abVar;
        com.tencent.mm.plugin.finder.storage.ab abVar2 = this.tnV;
        if (abVar2 == null) {
            kotlin.g.b.p.hyc();
        }
        AppMethodBeat.o(241918);
        return abVar2;
    }

    public final com.tencent.mm.plugin.finder.storage.e getConversationStorage() {
        AppMethodBeat.i(241919);
        com.tencent.mm.plugin.finder.storage.e eVar = this.tnW;
        if (eVar == null) {
            com.tencent.mm.storagebase.h hVar = this.tnQ;
            if (hVar == null) {
                kotlin.g.b.p.hyc();
            }
            eVar = new com.tencent.mm.plugin.finder.storage.e(hVar);
        }
        this.tnW = eVar;
        com.tencent.mm.plugin.finder.storage.e eVar2 = this.tnW;
        if (eVar2 == null) {
            kotlin.g.b.p.hyc();
        }
        AppMethodBeat.o(241919);
        return eVar2;
    }

    public final com.tencent.mm.plugin.finder.storage.ag getSessionInfoStorage() {
        AppMethodBeat.i(241920);
        com.tencent.mm.kernel.g.aAf().azk();
        com.tencent.mm.plugin.finder.storage.ag agVar = this.tnX;
        if (agVar == null) {
            com.tencent.mm.storagebase.h hVar = this.tnQ;
            if (hVar == null) {
                kotlin.g.b.p.hyc();
            }
            agVar = new com.tencent.mm.plugin.finder.storage.ag(hVar);
        }
        this.tnX = agVar;
        com.tencent.mm.plugin.finder.storage.ag agVar2 = this.tnX;
        if (agVar2 == null) {
            kotlin.g.b.p.hyc();
        }
        AppMethodBeat.o(241920);
        return agVar2;
    }

    public final com.tencent.mm.plugin.finder.storage.y getMessageStorage() {
        AppMethodBeat.i(241921);
        com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        kotlin.g.b.p.g(af2, "MMKernel.service(IMessengerStorage::class.java)");
        com.tencent.mm.plugin.messenger.foundation.a.a.i eiy = ((com.tencent.mm.plugin.messenger.foundation.a.l) af2).eiy();
        com.tencent.mm.plugin.finder.storage.y yVar = this.tnY;
        if (yVar == null) {
            kotlin.g.b.p.g(eiy, "msgStg");
            yVar = new com.tencent.mm.plugin.finder.storage.y(eiy);
        }
        this.tnY = yVar;
        com.tencent.mm.plugin.finder.storage.y yVar2 = this.tnY;
        if (yVar2 == null) {
            kotlin.g.b.p.hyc();
        }
        AppMethodBeat.o(241921);
        return yVar2;
    }

    public final com.tencent.mm.plugin.finder.storage.l getFeedStorage() {
        AppMethodBeat.i(165083);
        com.tencent.mm.kernel.g.aAf().azk();
        com.tencent.mm.plugin.finder.storage.l lVar = this.toa;
        if (lVar == null) {
            lVar = new com.tencent.mm.plugin.finder.storage.l(getDB());
        }
        this.toa = lVar;
        com.tencent.mm.plugin.finder.storage.l lVar2 = this.toa;
        if (lVar2 == null) {
            kotlin.g.b.p.hyc();
        }
        AppMethodBeat.o(165083);
        return lVar2;
    }

    public final com.tencent.mm.plugin.finder.storage.logic.b getDraftStorage() {
        AppMethodBeat.i(241922);
        com.tencent.mm.kernel.g.aAf().azk();
        com.tencent.mm.plugin.finder.storage.logic.b bVar = this.tob;
        if (bVar == null) {
            bVar = new com.tencent.mm.plugin.finder.storage.logic.b(getDB());
        }
        this.tob = bVar;
        com.tencent.mm.plugin.finder.storage.logic.b bVar2 = this.tob;
        if (bVar2 == null) {
            kotlin.g.b.p.hyc();
        }
        AppMethodBeat.o(241922);
        return bVar2;
    }

    public final com.tencent.mm.plugin.finder.storage.w getMediaCacheStorage() {
        AppMethodBeat.i(165084);
        com.tencent.mm.kernel.g.aAf().azk();
        com.tencent.mm.plugin.finder.storage.w wVar = this.toc;
        if (wVar == null) {
            wVar = new com.tencent.mm.plugin.finder.storage.w(getDB());
        }
        this.toc = wVar;
        com.tencent.mm.plugin.finder.storage.w wVar2 = this.toc;
        if (wVar2 == null) {
            kotlin.g.b.p.hyc();
        }
        AppMethodBeat.o(165084);
        return wVar2;
    }

    public final com.tencent.mm.plugin.finder.extension.reddot.c getRedDotCtrInfoStorage() {
        AppMethodBeat.i(178074);
        com.tencent.mm.kernel.g.aAf().azk();
        com.tencent.mm.plugin.finder.extension.reddot.c cVar = this.tod;
        if (cVar == null) {
            cVar = new com.tencent.mm.plugin.finder.extension.reddot.c(getDB());
        }
        this.tod = cVar;
        com.tencent.mm.plugin.finder.extension.reddot.c cVar2 = this.tod;
        if (cVar2 == null) {
            kotlin.g.b.p.hyc();
        }
        AppMethodBeat.o(178074);
        return cVar2;
    }

    public final MAutoStorage<cm> getMentionStorage(int i2) {
        AppMethodBeat.i(241923);
        com.tencent.mm.kernel.g.aAf().azk();
        checkResetDb();
        if (i2 == 1) {
            com.tencent.mm.plugin.finder.storage.aj ajVar = this.toe;
            if (ajVar == null) {
                com.tencent.mm.storagebase.h hVar = this.tnP;
                if (hVar == null) {
                    kotlin.g.b.p.hyc();
                }
                ajVar = new com.tencent.mm.plugin.finder.storage.aj(hVar);
            }
            this.toe = ajVar;
            com.tencent.mm.plugin.finder.storage.aj ajVar2 = this.toe;
            if (ajVar2 == null) {
                kotlin.g.b.p.hyc();
            }
            com.tencent.mm.plugin.finder.storage.aj ajVar3 = ajVar2;
            AppMethodBeat.o(241923);
            return ajVar3;
        }
        com.tencent.mm.plugin.finder.storage.m mVar = this.tof;
        if (mVar == null) {
            com.tencent.mm.storagebase.h hVar2 = this.tnO;
            if (hVar2 == null) {
                kotlin.g.b.p.hyc();
            }
            mVar = new com.tencent.mm.plugin.finder.storage.m(hVar2);
        }
        this.tof = mVar;
        com.tencent.mm.plugin.finder.storage.m mVar2 = this.tof;
        if (mVar2 == null) {
            kotlin.g.b.p.hyc();
        }
        com.tencent.mm.plugin.finder.storage.m mVar3 = mVar2;
        AppMethodBeat.o(241923);
        return mVar3;
    }

    public final com.tencent.mm.plugin.finder.storage.a getFinderActionStorage() {
        AppMethodBeat.i(165086);
        com.tencent.mm.kernel.g.aAf().azk();
        com.tencent.mm.plugin.finder.storage.a aVar = this.tog;
        if (aVar == null) {
            aVar = new com.tencent.mm.plugin.finder.storage.a(getDB());
        }
        this.tog = aVar;
        com.tencent.mm.plugin.finder.storage.a aVar2 = this.tog;
        if (aVar2 == null) {
            kotlin.g.b.p.hyc();
        }
        AppMethodBeat.o(165086);
        return aVar2;
    }

    public final com.tencent.mm.plugin.finder.storage.v getLocalLikeFeedStorage() {
        AppMethodBeat.i(241924);
        com.tencent.mm.kernel.g.aAf().azk();
        com.tencent.mm.plugin.finder.storage.v vVar = this.toh;
        if (vVar == null) {
            vVar = new com.tencent.mm.plugin.finder.storage.v(getDB());
        }
        this.toh = vVar;
        com.tencent.mm.plugin.finder.storage.v vVar2 = this.toh;
        if (vVar2 == null) {
            kotlin.g.b.p.hyc();
        }
        AppMethodBeat.o(241924);
        return vVar2;
    }

    public final com.tencent.mm.plugin.finder.storage.r getFinderLiveConfigStorage() {
        AppMethodBeat.i(241925);
        com.tencent.mm.kernel.g.aAf().azk();
        com.tencent.mm.plugin.finder.storage.r rVar = this.toi;
        if (rVar == null) {
            rVar = new com.tencent.mm.plugin.finder.storage.r(getDB());
        }
        this.toi = rVar;
        com.tencent.mm.plugin.finder.storage.r rVar2 = this.toi;
        if (rVar2 == null) {
            kotlin.g.b.p.hyc();
        }
        AppMethodBeat.o(241925);
        return rVar2;
    }

    public final com.tencent.mm.plugin.finder.storage.t getLiveGiftStorage() {
        AppMethodBeat.i(241926);
        com.tencent.mm.kernel.g.aAf().azk();
        com.tencent.mm.plugin.finder.storage.t tVar = this.tnZ;
        if (tVar == null) {
            tVar = new com.tencent.mm.plugin.finder.storage.t(getDB());
        }
        this.tnZ = tVar;
        com.tencent.mm.plugin.finder.storage.t tVar2 = this.tnZ;
        if (tVar2 == null) {
            kotlin.g.b.p.hyc();
        }
        AppMethodBeat.o(241926);
        return tVar2;
    }

    public final com.tencent.mm.plugin.finder.storage.ar getLiveLuckyMoneyStorage() {
        AppMethodBeat.i(260060);
        com.tencent.mm.kernel.g.aAf().azk();
        com.tencent.mm.plugin.finder.storage.ar arVar = this.UGM;
        if (arVar == null) {
            arVar = new com.tencent.mm.plugin.finder.storage.ar(getDB());
        }
        this.UGM = arVar;
        com.tencent.mm.plugin.finder.storage.ar arVar2 = this.UGM;
        if (arVar2 == null) {
            kotlin.g.b.p.hyc();
        }
        AppMethodBeat.o(260060);
        return arVar2;
    }

    public final com.tencent.mm.plugin.finder.api.e getFinderSyncExtension() {
        return this.tnT;
    }

    public final com.tencent.mm.plugin.finder.api.a getFinderContactCache() {
        return this.tox;
    }

    private final void doFinderInit() {
        AppMethodBeat.i(165088);
        Log.i("Finder.PluginFinder", "[doFinderInit] ...");
        this.toM = SystemClock.uptimeMillis();
        com.tencent.mm.kernel.g.azz().b(new bt());
        AppMethodBeat.o(165088);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/PluginFinder$entryConfigChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class ac extends IListener<fp> {
        final /* synthetic */ PluginFinder toS;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        ac(PluginFinder pluginFinder) {
            this.toS = pluginFinder;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(fp fpVar) {
            AppMethodBeat.i(165068);
            PluginFinder.access$doSomethingImportantOnStart(this.toS);
            AppMethodBeat.o(165068);
            return false;
        }
    }

    private final void doSomethingImportantOnStart() {
        boolean z2;
        AppMethodBeat.i(241927);
        this.toI.alive();
        if (this.toJ) {
            AppMethodBeat.o(241927);
            return;
        }
        boolean showFinderEntry = showFinderEntry();
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dvQ().value().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        Log.i("Finder.PluginFinder", "[doSomethingImportantOnStart] " + com.tencent.mm.model.z.aUg() + " isDoSomethingCompleted=" + this.toJ + ", isShowFinderEntry=" + showFinderEntry + " FIX_REINIT_SELECTOR_ENABLE_VALUE=" + z2);
        if (!showFinderEntry) {
            AppMethodBeat.o(241927);
            return;
        }
        this.toJ = true;
        boolean isNeedDoReInit = isNeedDoReInit();
        if (!Util.isNullOrNil(com.tencent.mm.model.z.aUg())) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(1279, 34, 1);
        }
        if (isNeedDoReInit) {
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_REINIT_USER_VERSION_INT_SYNC, 0);
            com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
            Object obj = aAh2.azQ().get(ar.a.USERINFO_MY_FINDER_REINIT_USERNAME_STRING_SYNC, "");
            if (obj == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(241927);
                throw tVar;
            }
            doReInit(i2, (String) obj);
            doPrepareUser();
            if (!z2) {
                this.tnT.fX(48125, 6);
            }
        } else if (Util.isNullOrNil(com.tencent.mm.model.z.aUg())) {
            com.tencent.mm.kernel.g.azz().a(3930, this);
            com.tencent.mm.kernel.g.azz().a(3930, getRedDotManager());
            doFinderInit();
            if (!z2) {
                this.tnT.fX(47613, 6);
            }
        }
        if (z2) {
            this.tnT.fX(48125, 6);
        }
        getRedDotManager().prepare();
        AppMethodBeat.o(241927);
    }

    private final void doReInit(int i2, String str) {
        AppMethodBeat.i(165090);
        try {
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(1279, 21, 1);
            g.a aVar = com.tencent.mm.plugin.finder.storage.data.g.vGf;
            g.a.clearAll();
            l.a aVar2 = com.tencent.mm.plugin.finder.storage.data.l.vGw;
            l.a.clearAll();
            b.a aVar3 = com.tencent.mm.plugin.finder.storage.data.b.vFQ;
            b.a.clearAll();
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_SYNC_KEYBUF2_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
            aAh2.azQ().set(ar.a.USERINFO_FINDER_INIT_KEYBUF2_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh3, "MMKernel.storage()");
            aAh3.azQ().set(ar.a.USERINFO_FINDER_GET_WX_IDENTITY_NORMAL_MSG_LAST_BUF_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh4 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh4, "MMKernel.storage()");
            aAh4.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_NORMAL_MSG_LAST_BUF_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh5 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh5, "MMKernel.storage()");
            aAh5.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_SYSTEM_MSG_LAST_BUF_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh6 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh6, "MMKernel.storage()");
            aAh6.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_LIKE_MSG_LAST_BUF_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh7 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh7, "MMKernel.storage()");
            aAh7.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_COMMENT_MSG_LAST_BUF_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh8 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh8, "MMKernel.storage()");
            aAh8.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_FOLLOW_MSG_LAST_BUF_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh9 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh9, "MMKernel.storage()");
            aAh9.azQ().set(ar.a.USERINFO_FINDER_GET_WX_IDENTITY_NORMAL_MSG_LAST_BUF_WRITE_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh10 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh10, "MMKernel.storage()");
            aAh10.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_NORMAL_MSG_LAST_BUF_WRITE_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh11 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh11, "MMKernel.storage()");
            aAh11.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_SYSTEM_MSG_LAST_BUF_WRITE_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh12 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh12, "MMKernel.storage()");
            aAh12.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_LIKE_MSG_LAST_BUF_WRITE_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh13 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh13, "MMKernel.storage()");
            aAh13.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_COMMENT_MSG_LAST_BUF_WRITE_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh14 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh14, "MMKernel.storage()");
            aAh14.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_FOLLOW_MSG_LAST_BUF_WRITE_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh15 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh15, "MMKernel.storage()");
            aAh15.azQ().set(ar.a.USERINFO_FINDER_PREPARE_USER_FLAG_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh16 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh16, "MMKernel.storage()");
            aAh16.azQ().set(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh17 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh17, "MMKernel.storage()");
            aAh17.azQ().set(ar.a.USERINFO_FINDER_USER_VERSION_INT_SYNC, Integer.valueOf(i2));
            com.tencent.mm.kernel.e aAh18 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh18, "MMKernel.storage()");
            aAh18.azQ().set(ar.a.USERINFO_MY_FINDER_USERNAME_STRING_SYNC, str);
            com.tencent.mm.kernel.e aAh19 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh19, "MMKernel.storage()");
            aAh19.azQ().set(ar.a.USERINFO_FINDER_MSG_NORMAL_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh20 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh20, "MMKernel.storage()");
            aAh20.azQ().set(ar.a.USERINFO_FINDER_MSG_SYSTEM_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh21 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh21, "MMKernel.storage()");
            aAh21.azQ().set(ar.a.USERINFO_FINDER_USER_HARD_REINIT_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh22 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh22, "MMKernel.storage()");
            int i3 = aAh22.azQ().getInt(ar.a.USERINFO_FINDER_USER_AUTO_INCREMENT_ID_INT_SYNC, 0);
            com.tencent.mm.kernel.e aAh23 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh23, "MMKernel.storage()");
            aAh23.azQ().set(ar.a.USERINFO_FINDER_USER_AUTO_INCREMENT_ID_INT_SYNC, Integer.valueOf(i3 + 1));
            clearReInit();
            Log.i("Finder.PluginFinder", "[doReInit] reInit done. incrementId=" + (i3 + 1));
            AppMethodBeat.o(165090);
        } catch (Exception e2) {
            Log.printErrStackTrace("Finder.PluginFinder", e2, "do ReInit occur error!", new Object[0]);
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(1279, 22, 1);
            AppMethodBeat.o(165090);
        }
    }

    private final void doPrepareUser() {
        AppMethodBeat.i(165091);
        Log.i("Finder.PluginFinder", "[doPrepareUser]... ");
        com.tencent.mm.kernel.g.azz().b(new cd(1));
        AppMethodBeat.o(165091);
    }

    @Override // com.tencent.mm.kernel.b.f
    public final void configure(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(165092);
        com.tencent.mm.vfs.y.b("finder", "finder", 7776000000L, 19);
        AppMethodBeat.o(165092);
    }

    public final void resetConfig() {
        AppMethodBeat.i(165093);
        try {
            g.a aVar = com.tencent.mm.plugin.finder.storage.data.g.vGf;
            g.a.clearAll();
            l.a aVar2 = com.tencent.mm.plugin.finder.storage.data.l.vGw;
            l.a.clearAll();
            b.a aVar3 = com.tencent.mm.plugin.finder.storage.data.b.vFQ;
            b.a.clearAll();
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_SYNC_KEYBUF2_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
            aAh2.azQ().set(ar.a.USERINFO_FINDER_INIT_KEYBUF2_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh3, "MMKernel.storage()");
            aAh3.azQ().set(ar.a.USERINFO_FINDER_GET_WX_IDENTITY_NORMAL_MSG_LAST_BUF_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh4 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh4, "MMKernel.storage()");
            aAh4.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_NORMAL_MSG_LAST_BUF_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh5 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh5, "MMKernel.storage()");
            aAh5.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_SYSTEM_MSG_LAST_BUF_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh6 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh6, "MMKernel.storage()");
            aAh6.azQ().set(ar.a.USERINFO_FINDER_GET_WX_IDENTITY_NORMAL_MSG_LAST_BUF_WRITE_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh7 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh7, "MMKernel.storage()");
            aAh7.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_NORMAL_MSG_LAST_BUF_WRITE_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh8 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh8, "MMKernel.storage()");
            aAh8.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_SYSTEM_MSG_LAST_BUF_WRITE_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh9 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh9, "MMKernel.storage()");
            aAh9.azQ().set(ar.a.USERINFO_FINDER_FINDERITEM_MAXID_LONG_SYNC, (Object) 1L);
            com.tencent.mm.kernel.e aAh10 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh10, "MMKernel.storage()");
            aAh10.azQ().set(ar.a.USERINFO_MY_FINDER_USERNAME_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh11 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh11, "MMKernel.storage()");
            aAh11.azQ().set(ar.a.USERINFO_MY_FINDER_NICKNAME_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh12 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh12, "MMKernel.storage()");
            aAh12.azQ().set(ar.a.USERINFO_MY_FINDER_SIGNATURE_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh13 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh13, "MMKernel.storage()");
            aAh13.azQ().set(ar.a.USERINFO_MY_FINDER_AVATAR_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh14 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh14, "MMKernel.storage()");
            aAh14.azQ().set(ar.a.USERINFO_MY_FINDER_AUTH_INFO_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh15 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh15, "MMKernel.storage()");
            aAh15.azQ().set(ar.a.USERINFO_MY_FINDER_COVER_IMG_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh16 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh16, "MMKernel.storage()");
            aAh16.azQ().set(ar.a.USERINFO_MY_FINDER_LOCAL_COVER_IMG_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh17 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh17, "MMKernel.storage()");
            aAh17.azQ().set(ar.a.USERINFO_MY_FINDER_ORIGINAL_FLAG2_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh18 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh18, "MMKernel.storage()");
            aAh18.azQ().set(ar.a.USERINFO_MY_FINDER_ORIGINAL_ENTRANCE2_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh19 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh19, "MMKernel.storage()");
            aAh19.azQ().set(ar.a.USERINFO_FINDER_PREPARE_USER_FLAG_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh20 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh20, "MMKernel.storage()");
            aAh20.azQ().set(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh21 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh21, "MMKernel.storage()");
            aAh21.azQ().set(ar.a.USERINFO_FINDER_USER_VERSION_INT_SYNC, (Object) 0);
            clearReInit();
            com.tencent.mm.kernel.e aAh22 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh22, "MMKernel.storage()");
            aAh22.azQ().set(ar.a.USERINFO_FINDER_TIMELINE_ALL_LASTBUF_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh23 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh23, "MMKernel.storage()");
            aAh23.azQ().set(ar.a.USERINFO_FINDER_TIMELINE_HEADER_WORDING_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh24 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh24, "MMKernel.storage()");
            aAh24.azQ().set(ar.a.USERINFO_FINDER_TIMELINE_FOOTER_WORDING_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh25 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh25, "MMKernel.storage()");
            aAh25.azQ().set(ar.a.USERINFO_FINDER_MSG_NORMAL_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh26 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh26, "MMKernel.storage()");
            aAh26.azQ().set(ar.a.USERINFO_FINDER_MSG_SYSTEM_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh27 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh27, "MMKernel.storage()");
            aAh27.azQ().set(ar.a.USERINFO_FINDER_WX_MENTION_COMMENT_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh28 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh28, "MMKernel.storage()");
            aAh28.azQ().set(ar.a.USERINFO_FINDER_WX_MENTION_LIKE_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh29 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh29, "MMKernel.storage()");
            aAh29.azQ().set(ar.a.USERINFO_FINDER_WX_MENTION_OBJECT_LIEK_LIKE_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh30 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh30, "MMKernel.storage()");
            aAh30.azQ().set(ar.a.USERINFO_FINDER_WX_MENTION_OBJECT_RECOMMEND_LIKE_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh31 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh31, "MMKernel.storage()");
            aAh31.azQ().set(ar.a.USERINFO_FINDER_WX_MENTION_FOLLOW_ACCEPT_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh32 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh32, "MMKernel.storage()");
            aAh32.azQ().set(ar.a.USERINFO_FINDER_FIRST_CREATE_USER_BOOLEAN, Boolean.FALSE);
            com.tencent.mm.kernel.e aAh33 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh33, "MMKernel.storage()");
            aAh33.azQ().set(ar.a.USERINFO_FINDER_NOT_INTERESTED_CONFIG_STRING, "");
            com.tencent.mm.kernel.e aAh34 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh34, "MMKernel.storage()");
            aAh34.azQ().set(ar.a.USERINFO_FINDER_FOLLOW_COUNT_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh35 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh35, "MMKernel.storage()");
            aAh35.azQ().set(ar.a.USERINFO_FINDER_FANS_COUNT_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh36 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh36, "MMKernel.storage()");
            aAh36.azQ().set(ar.a.USERINFO_FINDER_FANS_ADDCOUNT_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh37 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh37, "MMKernel.storage()");
            aAh37.azQ().set(ar.a.USERINFO_FINDER_FIND_MORE_UI_RED_DOT_BOOLEAN_SYNC, Boolean.FALSE);
            AppMethodBeat.o(165093);
        } catch (Exception e2) {
            Log.printErrStackTrace("Finder.PluginFinder", e2, "resetConfig error", new Object[0]);
            AppMethodBeat.o(165093);
        }
    }

    private final void clearReInit() {
        AppMethodBeat.i(165094);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_FINDER_REINIT_USER_VERSION_INT_SYNC, (Object) 0);
        com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
        aAh2.azQ().set(ar.a.USERINFO_MY_FINDER_REINIT_USERNAME_STRING_SYNC, "");
        AppMethodBeat.o(165094);
    }

    @Override // com.tencent.mm.kernel.b.f
    public final void dependency() {
        AppMethodBeat.i(241928);
        super.dependency();
        dependsOn(com.tencent.mm.plugin.byp.a.c.class);
        dependsOn(com.tencent.mm.plugin.teenmode.a.a.class);
        AppMethodBeat.o(241928);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
        boolean z2;
        boolean z3;
        bbg bbg = null;
        AppMethodBeat.i(162435);
        com.tencent.mm.plugin.report.service.h.INSTANCE.n(1279, 40, 1);
        this.tnN = true;
        checkResetDb();
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(ar.a.USERINFO_FINDER_DB_VERSION_STRING_SYNC, this.toB);
        Log.i("Finder.PluginFinder", "[onAccountInitialized] Log appendIsSync=" + XLogSetup.appendIsSync + ' ' + this.tnN + ' ' + this.toA + ' ' + obj);
        com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
        if (!kotlin.g.b.p.j(aAh2.azQ().get(ar.a.USERINFO_FINDER_DB_VERSION_STRING_SYNC, this.toA), this.toA)) {
            Log.i("Finder.PluginFinder", "resetConfig oldVer:" + obj + " CURRENT_DB_VERSION:" + this.toA);
            resetConfig();
        }
        com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh3, "MMKernel.storage()");
        aAh3.azQ().set(ar.a.USERINFO_FINDER_DB_VERSION_STRING_SYNC, this.toA);
        com.tencent.mm.kernel.e aAh4 = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh4, "MMKernel.storage()");
        int i2 = aAh4.azQ().getInt(ar.a.USERINFO_FINDER_USER_AUTO_INCREMENT_ID_INT_SYNC, -1);
        if (i2 == -1) {
            com.tencent.mm.kernel.e aAh5 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh5, "MMKernel.storage()");
            int i3 = aAh5.azQ().getInt(ar.a.USERINFO_FINDER_USER_VERSION_INT_SYNC, 0);
            com.tencent.mm.kernel.e aAh6 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh6, "MMKernel.storage()");
            aAh6.azQ().set(ar.a.USERINFO_FINDER_USER_AUTO_INCREMENT_ID_INT_SYNC, Integer.valueOf(i3));
            Log.i("Finder.PluginFinder", "[onAccountInitialized] user auto increment id=" + i2 + " userVersion=" + i3);
        } else {
            Log.i("Finder.PluginFinder", "[onAccountInitialized] user auto increment id=".concat(String.valueOf(i2)));
        }
        com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        kotlin.g.b.p.g(af2, "MMKernel.service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.l) af2).eiy().a(getMessageStorage());
        com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.ad.class, getFinderTeenModeConfig());
        com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.an.class, this.UGO);
        ((com.tencent.mm.plugin.teenmode.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).a(this.kIM);
        com.tencent.mm.plugin.finder.cgi.ao aoVar = com.tencent.mm.plugin.finder.cgi.ao.tuE;
        com.tencent.mm.plugin.finder.cgi.ao.cYb();
        doSomethingImportantOnStart();
        com.tencent.mm.plugin.finder.shell.b bVar = com.tencent.mm.plugin.finder.shell.b.vwj;
        com.tencent.mm.plugin.finder.shell.b.setup();
        com.tencent.mm.plugin.finder.upload.g gVar = this.tnS;
        gVar.ibn.a(gVar.vSF);
        gVar.vSA.a(gVar.vSG);
        com.tencent.mm.kernel.e aAh7 = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh7, "MMKernel.storage()");
        aAh7.azQ().set(ar.a.USERINFO_MY_FINDER_LOCAL_COVER_IMG_STRING_SYNC, "");
        com.tencent.mm.kernel.g.azz().a(3565, this.tnT);
        com.tencent.mm.kernel.g.azz().a(3512, this);
        com.tencent.mm.kernel.g.azz().a(3870, this.toj);
        com.tencent.mm.kernel.g.azz().a(3870, this.tok);
        com.tencent.mm.kernel.g.azz().a(3870, this.tol);
        com.tencent.mm.kernel.g.azz().a(3870, this.tom);
        com.tencent.mm.kernel.g.azz().a(3870, this.ton);
        com.tencent.mm.kernel.g.azz().a(3870, this.too);
        com.tencent.mm.kernel.g.azz().a(3870, this.toq);
        com.tencent.mm.kernel.g.azz().a(3870, this.tor);
        com.tencent.mm.kernel.g.azz().a(3870, this.tou);
        com.tencent.mm.kernel.g.azz().a(3870, this.tov);
        com.tencent.mm.kernel.g.azz().a(3870, this.tow);
        com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.x.class, this.toj);
        com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.w.class, this.tok);
        com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.p.class, this.tol);
        com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.u.class, this.tom);
        com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.q.class, this.ton);
        com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.ag.class, this.too);
        com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.v.class, this.toq);
        com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.t.class, this.tor);
        com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.s.class, this.tou);
        com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.r.class, this.tov);
        com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.o.class, this.tow);
        com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class);
        kotlin.g.b.p.g(ah2, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.s) ah2).getSysCmdMsgExtension().a("FinderPersonalMsgSysMsg", this.tos);
        com.tencent.mm.kernel.b.a ah3 = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class);
        kotlin.g.b.p.g(ah3, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.s) ah3).getSysCmdMsgExtension().a("finderuserreinit", this.tot);
        com.tencent.mm.kernel.b.a ah4 = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class);
        kotlin.g.b.p.g(ah4, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.s) ah4).getSysCmdMsgExtension().a("FinderPromotion", this.UGN);
        Log.i(com.tencent.mm.plugin.finder.storage.a.TAG, "cleanCanRemoveFeed ret" + ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderActionStorage().db.execSQL("FinderAction", "DELETE FROM FinderAction WHERE actionType = 1") + ' ' + "DELETE FROM FinderAction WHERE actionType = 1");
        if (showFinderEntry()) {
            com.tencent.f.h.RTc.aX(am.tpV);
        }
        c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
        com.tencent.mm.plugin.finder.api.g cXF = c.a.cXF();
        cXF.tsv = true;
        c.a.e(cXF);
        this.toE.alive();
        j.a aVar2 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
        com.tencent.mm.plugin.finder.upload.action.j.dBt();
        g.a aVar3 = com.tencent.mm.plugin.finder.upload.g.vSJ;
        com.tencent.mm.plugin.finder.upload.g dBa = com.tencent.mm.plugin.finder.upload.g.dBa();
        com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
        dBa.a(com.tencent.mm.plugin.finder.report.i.dnZ());
        AppForegroundDelegate.INSTANCE.a(this.toN);
        com.tencent.mm.plugin.finder.model.as asVar = com.tencent.mm.plugin.finder.model.as.uOL;
        com.tencent.mm.plugin.finder.model.as.sy();
        com.tencent.mm.plugin.finder.storage.data.v vVar = com.tencent.mm.plugin.finder.storage.data.v.vGG;
        bbg bbg2 = new bbg();
        try {
            bbg2.parseFrom(com.tencent.mm.vfs.s.aW(com.tencent.mm.plugin.finder.storage.data.v.dyJ(), 0, -1));
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
            bbg2 = null;
        }
        bbg bbg3 = bbg2;
        Log.i("Finder.PageRecovery", "[setup] isExist=" + com.tencent.mm.vfs.s.YS(com.tencent.mm.plugin.finder.storage.data.v.dyJ()) + " touchFile=" + com.tencent.mm.plugin.finder.storage.data.v.dyJ() + " info: " + (bbg3 != null ? Integer.valueOf(bbg3.crashCount) : null) + ' ' + (bbg3 != null ? Long.valueOf(bbg3.LKH) : null));
        if (bbg3 != null) {
            if (bbg3.crashCount >= 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                bbg = bbg3;
            }
            if (bbg != null) {
                l.a aVar4 = com.tencent.mm.plugin.finder.storage.data.l.vGw;
                l.a.clearAll();
                com.tencent.mm.plugin.finder.storage.data.v vVar2 = com.tencent.mm.plugin.finder.storage.data.v.vGG;
                com.tencent.mm.vfs.s.deleteFile(com.tencent.mm.plugin.finder.storage.data.v.dyJ());
                bbg.crashCount = 0;
                bbg.LKH = 0;
            }
        }
        MMUncaughtExceptionHandler.addOnUncaughtExceptionListener(new v.a(bbg3));
        com.tencent.mm.ac.d.i(an.tpW);
        com.tencent.mm.ui.component.a aVar5 = com.tencent.mm.ui.component.a.PRN;
        FinderStreamTabPreloadCore finderStreamTabPreloadCore = (FinderStreamTabPreloadCore) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamTabPreloadCore.class);
        finderStreamTabPreloadCore.uUP.alive();
        com.tencent.mm.plugin.finder.extension.reddot.h hVar = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h hVar2 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.daK(), finderStreamTabPreloadCore);
        AppForegroundDelegate.INSTANCE.a(finderStreamTabPreloadCore);
        com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.aa.class, new com.tencent.mm.plugin.finder.service.e());
        com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.m.class, getFinderContactService());
        com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.n.class, new com.tencent.mm.plugin.finder.service.b());
        com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.y.class, new com.tencent.mm.plugin.finder.service.d());
        com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.ao.class, com.tencent.mm.plugin.finder.report.am.USY);
        ((com.tencent.mm.plugin.byp.a.c) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.byp.a.c.class)).addBypSyncHandler(1, new com.tencent.mm.plugin.finder.message.a());
        com.tencent.mm.kernel.c.a af3 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        kotlin.g.b.p.g(af3, "MMKernel.service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.l) af3).aST().a(getConversationUpdater());
        com.tencent.mm.kernel.c.a af4 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        kotlin.g.b.p.g(af4, "MMKernel.service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.l) af4).aSN().a(getFinderContactService().vvB);
        com.tencent.mm.ac.d.i(new i.b(getConversationUpdater()));
        j.a gov = a.b.gov();
        if (gov instanceof com.tencent.mm.pluginsdk.ui.b) {
            com.tencent.mm.plugin.finder.loader.b bVar2 = new com.tencent.mm.plugin.finder.loader.b(((com.tencent.mm.pluginsdk.ui.b) gov).gow());
            ((com.tencent.mm.pluginsdk.ui.b) gov).a("@findermsg", bVar2);
            ((com.tencent.mm.pluginsdk.ui.b) gov).a("@finder", bVar2);
            ((com.tencent.mm.pluginsdk.ui.b) gov).a("@findermsgstranger", bVar2);
        }
        af.a.a(getGetContactInterceptor());
        com.tencent.mm.plugin.finder.report.ad.doP().LW();
        com.tencent.mm.plugin.vlog.model.m mVar = com.tencent.mm.plugin.vlog.model.m.Gyi;
        com.tencent.mm.plugin.vlog.model.m.setup();
        a.C1215a aVar6 = com.tencent.mm.plugin.finder.megavideo.floatball.a.uKD;
        com.tencent.mm.plugin.ball.c.b bVar3 = (com.tencent.mm.plugin.ball.c.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class);
        if (bVar3 != null) {
            com.tencent.mm.ac.d.a(0, new a.C1215a.C1216a(bVar3));
            ((com.tencent.mm.plugin.ball.c.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).a(22, com.tencent.mm.plugin.finder.megavideo.floatball.a.dkh());
        }
        d.a aVar7 = com.tencent.mm.plugin.finder.feed.d.tMv;
        com.tencent.mm.kernel.e aAh8 = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh8, "MMKernel.storage()");
        if (!aAh8.azQ().getBoolean(ar.a.USERINFO_FINDER_FEED_BULLET_SUBTITLE_EXPT_HAS_SET_BOOLEAN_SYNC, false)) {
            com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
            int intValue = com.tencent.mm.plugin.finder.storage.c.dvv().value().intValue();
            Log.i("Finder.FinderBulletSubtitlePresenter", "initSwitch: exptValue = ".concat(String.valueOf(intValue)));
            if (intValue != 0) {
                com.tencent.mm.kernel.e aAh9 = com.tencent.mm.kernel.g.aAh();
                kotlin.g.b.p.g(aAh9, "MMKernel.storage()");
                aAh9.azQ().set(ar.a.USERINFO_FINDER_FEED_BULLET_SUBTITLE_EXPT_HAS_SET_BOOLEAN_SYNC, Boolean.TRUE);
                com.tencent.mm.kernel.e aAh10 = com.tencent.mm.kernel.g.aAh();
                kotlin.g.b.p.g(aAh10, "MMKernel.storage()");
                com.tencent.mm.storage.ao azQ = aAh10.azQ();
                ar.a aVar8 = ar.a.USERINFO_FINDER_FEED_BULLET_SUBTITLE_SWITCH_BOOLEAN;
                if (intValue != 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                azQ.set(aVar8, Boolean.valueOf(z2));
            }
        }
        a.C1220a aVar9 = com.tencent.mm.plugin.finder.megavideo.multitask.a.uLw;
        ((com.tencent.mm.plugin.taskbar.api.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.taskbar.api.c.class)).a(22, com.tencent.mm.plugin.finder.megavideo.multitask.a.dkl());
        h.a aVar10 = com.tencent.mm.plugin.finder.live.view.h.uzH;
        ((com.tencent.mm.plugin.taskbar.api.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.taskbar.api.c.class)).a(21, com.tencent.mm.plugin.finder.live.view.h.diA());
        ((com.tencent.mm.plugin.multitask.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.multitask.d.class)).registerMultiTaskUIC(22, FinderMegaVideoNormalTLUIC.class);
        EventCenter.instance.addListener(this.hvF);
        AppMethodBeat.o(162435);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class am implements Runnable {
        public static final am tpV = new am();

        static {
            AppMethodBeat.i(165072);
            AppMethodBeat.o(165072);
        }

        am() {
        }

        public final void run() {
            AppMethodBeat.i(165071);
            b.a aVar = com.tencent.mm.plugin.finder.upload.b.vRM;
            com.tencent.mm.plugin.finder.upload.b.dAQ().dAP();
            AppMethodBeat.o(165071);
        }
    }

    public final void onEnterFinder(MMFinderUI mMFinderUI) {
        AppMethodBeat.i(165095);
        kotlin.g.b.p.h(mMFinderUI, "finder");
        if (!mMFinderUI.getIntent().getBooleanExtra("key_not_request_focus", false)) {
            if (!isInFinder()) {
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                for (T t2 : ((FinderStreamTabPreloadCore) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamTabPreloadCore.class)).uUN) {
                    Log.i(t2.TAG, "[performEnterFinder]");
                    t2.uVa = true;
                    t2.uVb.aut("performEnterFinder");
                }
                requestAudioFocus();
            }
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            if (com.tencent.mm.plugin.i.a.k.MM(((FinderReporterUIC) com.tencent.mm.ui.component.a.b(mMFinderUI).get(FinderReporterUIC.class)).tCE) || mMFinderUI.containUIC(NearbyHomeUIC.class)) {
                if (!this.toL.contains(mMFinderUI)) {
                    this.toL.add(mMFinderUI);
                }
            } else if (!this.toK.contains(mMFinderUI)) {
                this.toK.add(mMFinderUI);
            }
            if (this.toK.size() == 1) {
                com.tencent.mm.plugin.finder.cgi.report.a aVar3 = com.tencent.mm.plugin.finder.cgi.report.a.tya;
                boolean z2 = SystemClock.elapsedRealtime() - com.tencent.mm.plugin.finder.cgi.report.a.txZ > 300000;
                Log.i("Finder.CgiStrategy", "tryMoreInit tryInit:".concat(String.valueOf(z2)));
                if (z2) {
                    com.tencent.mm.plugin.finder.cgi.report.a.init();
                    com.tencent.mm.plugin.finder.cgi.report.a.txZ = SystemClock.elapsedRealtime();
                }
            }
        }
        AppMethodBeat.o(165095);
    }

    public final void onExitFinder(MMFinderUI mMFinderUI) {
        AppMethodBeat.i(165096);
        kotlin.g.b.p.h(mMFinderUI, "finder");
        this.toK.remove(mMFinderUI);
        this.toL.remove(mMFinderUI);
        if (!isInFinder()) {
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            for (T t2 : ((FinderStreamTabPreloadCore) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamTabPreloadCore.class)).uUN) {
                Log.i(t2.TAG, "[performExitFinder]");
                t2.uVa = false;
                t2.uVb.a(t2.uVf, t2.dlK(), "performExitFinder");
            }
            this.hWh.apm();
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            com.tencent.mm.plugin.finder.utils.y.dCQ();
        }
        com.tencent.mm.plugin.finder.preload.model.a mediaPreloadModel = getMediaPreloadModel();
        if (mediaPreloadModel.uUF.size() >= 3000) {
            mediaPreloadModel.uUF.clear();
        }
        AppMethodBeat.o(165096);
    }

    public final boolean isInFinder() {
        AppMethodBeat.i(165097);
        if (this.toK.size() > 0) {
            AppMethodBeat.o(165097);
            return true;
        }
        AppMethodBeat.o(165097);
        return false;
    }

    public final boolean isInNearby() {
        AppMethodBeat.i(241929);
        if (this.toL.size() > 0) {
            AppMethodBeat.o(241929);
            return true;
        }
        AppMethodBeat.o(241929);
        return false;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/finder/PluginFinder$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener;", "onAppBackground", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "", "onAppForeground", "plugin-finder_release"})
    public static final class c implements com.tencent.mm.app.o {
        final /* synthetic */ PluginFinder toS;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(PluginFinder pluginFinder) {
            this.toS = pluginFinder;
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(165054);
            this.toS.hWh.apm();
            com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
            com.tencent.mm.plugin.finder.report.h.dnV();
            AppMethodBeat.o(165054);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(165055);
            if (this.toS.isInFinder()) {
                PluginFinder.access$requestAudioFocus(this.toS);
            }
            if (this.toS.showFinderEntry() && SystemClock.uptimeMillis() - this.toS.toM >= Util.MILLSECONDS_OF_DAY) {
                PluginFinder.access$doFinderInit(this.toS);
            }
            AppMethodBeat.o(165055);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/PluginFinder$requestAudioFocus$1", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "gain", "", "loss", "lossTransient", "lossTransientCanDuck", "unKown", "plugin-finder_release"})
    public static final class aq implements d.a {
        aq() {
        }

        @Override // com.tencent.mm.model.d.a
        public final void aTw() {
            AppMethodBeat.i(165073);
            Log.i("Finder.PluginFinder", "[audioHelperTool] gain");
            AppMethodBeat.o(165073);
        }

        @Override // com.tencent.mm.model.d.a
        public final void aTy() {
            AppMethodBeat.i(165074);
            Log.i("Finder.PluginFinder", "[audioHelperTool] lossTransient");
            AppMethodBeat.o(165074);
        }

        @Override // com.tencent.mm.model.d.a
        public final void aTx() {
            AppMethodBeat.i(165075);
            Log.i("Finder.PluginFinder", "[audioHelperTool] loss");
            AppMethodBeat.o(165075);
        }

        @Override // com.tencent.mm.model.d.a
        public final void aTz() {
            AppMethodBeat.i(165076);
            Log.i("Finder.PluginFinder", "[audioHelperTool] lossTransientCanDuck");
            AppMethodBeat.o(165076);
        }
    }

    private final void requestAudioFocus() {
        AppMethodBeat.i(165098);
        this.hWh.a(new aq());
        AppMethodBeat.o(165098);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
        AppMethodBeat.i(162436);
        Log.i("Finder.PluginFinder", "onAccountRelease");
        com.tencent.mm.kernel.g.azz().b(3520, com.tencent.mm.plugin.finder.model.as.uOL);
        com.tencent.mm.plugin.finder.upload.g gVar = this.tnS;
        gVar.ibn.b(gVar.vSF);
        gVar.vSA.b(gVar.vSG);
        g.a aVar = com.tencent.mm.plugin.finder.upload.g.vSJ;
        com.tencent.mm.plugin.finder.upload.g dBa = com.tencent.mm.plugin.finder.upload.g.dBa();
        com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
        dBa.b(com.tencent.mm.plugin.finder.report.i.dnZ());
        com.tencent.mm.kernel.g.azz().b(3565, this.tnT);
        com.tencent.mm.kernel.g.azz().b(3512, this);
        com.tencent.mm.kernel.g.azz().b(3870, this.toj);
        com.tencent.mm.kernel.g.azz().b(3870, this.tok);
        com.tencent.mm.kernel.g.azz().b(3870, this.tol);
        com.tencent.mm.kernel.g.azz().b(3870, this.tom);
        com.tencent.mm.kernel.g.azz().b(3870, this.ton);
        com.tencent.mm.kernel.g.azz().b(3870, this.too);
        com.tencent.mm.kernel.g.azz().b(3870, this.toq);
        com.tencent.mm.kernel.g.azz().b(3870, this.tor);
        com.tencent.mm.kernel.g.azz().b(3870, this.tou);
        com.tencent.mm.kernel.g.azz().b(3870, this.tov);
        com.tencent.mm.kernel.g.azz().b(3870, this.tow);
        com.tencent.mm.kernel.g.azz().b(665, this);
        com.tencent.mm.kernel.g.ag(com.tencent.mm.plugin.i.a.x.class);
        com.tencent.mm.kernel.g.ag(com.tencent.mm.plugin.i.a.an.class);
        com.tencent.mm.kernel.g.ag(com.tencent.mm.plugin.i.a.v.class);
        com.tencent.mm.kernel.g.ag(com.tencent.mm.plugin.i.a.t.class);
        com.tencent.mm.kernel.g.ag(com.tencent.mm.plugin.i.a.w.class);
        com.tencent.mm.kernel.g.ag(com.tencent.mm.plugin.i.a.p.class);
        com.tencent.mm.kernel.g.ag(com.tencent.mm.plugin.i.a.u.class);
        com.tencent.mm.kernel.g.ag(com.tencent.mm.plugin.i.a.q.class);
        com.tencent.mm.kernel.g.ag(com.tencent.mm.plugin.i.a.ag.class);
        this.toE.dead();
        AppForegroundDelegate.INSTANCE.b(this.toN);
        com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class);
        kotlin.g.b.p.g(ah2, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.s) ah2).getSysCmdMsgExtension().b("FinderPersonalMsgSysMsg", this.tos);
        com.tencent.mm.kernel.b.a ah3 = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class);
        kotlin.g.b.p.g(ah3, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.s) ah3).getSysCmdMsgExtension().b("finderuserreinit", this.tot);
        com.tencent.mm.kernel.b.a ah4 = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class);
        kotlin.g.b.p.g(ah4, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.s) ah4).getSysCmdMsgExtension().b("FinderPromotion", this.UGN);
        ((com.tencent.mm.plugin.byp.a.c) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.byp.a.c.class)).removeBypSyncHandler(1);
        com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        kotlin.g.b.p.g(af2, "MMKernel.service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.l) af2).aST().b(getConversationUpdater());
        com.tencent.mm.kernel.c.a af3 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        kotlin.g.b.p.g(af3, "MMKernel.service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.l) af3).aSN().b(getFinderContactService().vvB);
        com.tencent.mm.kernel.g.ag(com.tencent.mm.plugin.i.a.m.class);
        com.tencent.mm.kernel.g.ag(com.tencent.mm.plugin.i.a.aa.class);
        com.tencent.mm.kernel.g.ag(com.tencent.mm.plugin.i.a.n.class);
        com.tencent.mm.kernel.g.ag(com.tencent.mm.plugin.i.a.r.class);
        com.tencent.mm.kernel.g.ag(com.tencent.mm.plugin.i.a.ad.class);
        com.tencent.mm.kernel.g.ag(com.tencent.mm.plugin.i.a.o.class);
        com.tencent.mm.kernel.g.ag(com.tencent.mm.plugin.i.a.ao.class);
        ((com.tencent.mm.plugin.teenmode.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).b(this.kIM);
        af.a.b(getGetContactInterceptor());
        j.a gov = a.b.gov();
        if (gov instanceof com.tencent.mm.pluginsdk.ui.b) {
            ((com.tencent.mm.pluginsdk.ui.b) gov).beq("@findermsg");
            ((com.tencent.mm.pluginsdk.ui.b) gov).beq("@finder");
        }
        if (this.hqK != null) {
            com.tencent.mm.storagebase.h hVar = this.hqK;
            if (hVar != null) {
                hVar.closeDB();
            }
            this.hqK = null;
        }
        this.FE.clear();
        this.toI.dead();
        com.tencent.mm.plugin.finder.report.ad.doP().unregister();
        com.tencent.mm.plugin.finder.feed.model.e eVar = com.tencent.mm.plugin.finder.feed.model.e.tUY;
        com.tencent.mm.plugin.finder.feed.model.e.clear();
        com.tencent.mm.plugin.vlog.model.m mVar = com.tencent.mm.plugin.vlog.model.m.Gyi;
        com.tencent.mm.plugin.vlog.model.m.destroy();
        a.C1215a aVar2 = com.tencent.mm.plugin.finder.megavideo.floatball.a.uKD;
        if (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class) != null) {
            ((com.tencent.mm.plugin.ball.c.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).b(22, com.tencent.mm.plugin.finder.megavideo.floatball.a.dkh());
        }
        a.C1220a aVar3 = com.tencent.mm.plugin.finder.megavideo.multitask.a.uLw;
        ((com.tencent.mm.plugin.taskbar.api.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.taskbar.api.c.class)).b(22, com.tencent.mm.plugin.finder.megavideo.multitask.a.dkl());
        h.a aVar4 = com.tencent.mm.plugin.finder.live.view.h.uzH;
        ((com.tencent.mm.plugin.taskbar.api.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.taskbar.api.c.class)).b(21, com.tencent.mm.plugin.finder.live.view.h.diA());
        EventCenter.instance.removeListener(this.hvF);
        AppMethodBeat.o(162436);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(165099);
        if (qVar != null) {
            switch (qVar.getType()) {
                case 3512:
                    if (i2 == 0 && i3 == 0) {
                        com.tencent.mm.network.s reqResp = qVar.getReqResp();
                        if (reqResp == null) {
                            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
                            AppMethodBeat.o(165099);
                            throw tVar;
                        }
                        com.tencent.mm.bw.a aYK = ((com.tencent.mm.ak.d) reqResp).aYK();
                        if (aYK == null) {
                            kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetUserResponse");
                            AppMethodBeat.o(165099);
                            throw tVar2;
                        }
                        LinkedList<FinderContact> linkedList = ((atx) aYK).LCI;
                        if (linkedList != null) {
                            Iterator<T> it = linkedList.iterator();
                            while (it.hasNext()) {
                                c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
                                c.a.b((FinderContact) it.next());
                            }
                            AppMethodBeat.o(165099);
                            return;
                        }
                    }
                    break;
            }
        }
        AppMethodBeat.o(165099);
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void dumpAndMarkFinderFolder() {
        AppMethodBeat.i(165100);
        com.tencent.mm.ac.d.i(x.tpA);
        AppMethodBeat.o(165100);
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void enterFinderTimelineUI(Context context, Intent intent) {
        AppMethodBeat.i(162438);
        kotlin.g.b.p.h(context, "context");
        enterFinderTimelineUI(context, intent, false);
        AppMethodBeat.o(162438);
    }

    public final void enterFinderTimelineUI(Context context, Intent intent, boolean z2) {
        boolean z3;
        boolean z4;
        AppMethodBeat.i(241930);
        kotlin.g.b.p.h(context, "context");
        com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
        com.tencent.mm.plugin.finder.report.h.dnS();
        if (intent != null) {
            if (intent.getBooleanExtra("key_form_sns", false)) {
                String stringExtra = intent.getStringExtra("key_context_id");
                if (stringExtra == null) {
                    stringExtra = "";
                }
                i.a aVar = com.tencent.mm.plugin.finder.extension.reddot.i.tLi;
                z3 = !Util.isNullOrNil(i.a.dw(stringExtra, 1));
            } else {
                z3 = false;
            }
            if (z3 || (!Util.isNullOrNil(intent.getStringExtra("key_red_dot_id")))) {
                com.tencent.mm.plugin.finder.report.h hVar2 = com.tencent.mm.plugin.finder.report.h.veu;
                com.tencent.mm.plugin.finder.report.h.dnR();
            }
        }
        if (z2) {
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dwY()) {
                com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                FinderStreamTabPreloadCore finderStreamTabPreloadCore = (FinderStreamTabPreloadCore) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamTabPreloadCore.class);
                for (T t2 : finderStreamTabPreloadCore.uUN) {
                    int dHR = finderStreamTabPreloadCore.dlH().dHR();
                    Log.i(t2.TAG, "[performEnterFinderLoad] targetTab=" + dHR + ", cache.resp is null = " + (t2.uVg.uVi == null));
                    if (t2.dLS == dHR && t2.uVg.uVi == null && t2.uVh.JN(dHR)) {
                        t2.a(f.c.EnterLoad, intent, new f.C1257f(t2));
                    }
                }
            }
        }
        com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.v(context, intent);
        com.tencent.mm.plugin.secinforeport.a.d.INSTANCE.asyncReportFinderSecurityInfoThroughCgi(540999684);
        AppMethodBeat.o(241930);
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void loadImage(String str, ImageView imageView) {
        AppMethodBeat.i(178075);
        kotlin.g.b.p.h(str, "url");
        kotlin.g.b.p.h(imageView, "imageView");
        cjl cjl = new cjl();
        cjl.mediaId = MD5Util.getMD5String(str);
        cjl.url = str;
        cjl.thumbUrl = str;
        com.tencent.mm.plugin.finder.loader.k kVar = new com.tencent.mm.plugin.finder.loader.k(cjl, com.tencent.mm.plugin.finder.storage.x.THUMB_IMAGE, null, null, 12);
        com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
        com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> djY = com.tencent.mm.plugin.finder.loader.m.djY();
        com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
        djY.a(kVar, com.tencent.mm.plugin.finder.loader.m.a(m.a.TIMELINE)).c(imageView);
        AppMethodBeat.o(178075);
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void loadAvatar(String str, ImageView imageView) {
        AppMethodBeat.i(260061);
        kotlin.g.b.p.h(str, "url");
        kotlin.g.b.p.h(imageView, "avatarIv");
        cjl cjl = new cjl();
        cjl.mediaId = MD5Util.getMD5String(str);
        cjl.url = str;
        cjl.thumbUrl = str;
        com.tencent.mm.plugin.finder.loader.k kVar = new com.tencent.mm.plugin.finder.loader.k(cjl, com.tencent.mm.plugin.finder.storage.x.THUMB_IMAGE, null, null, 12);
        com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
        com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dka = com.tencent.mm.plugin.finder.loader.m.dka();
        com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
        dka.a(kVar, com.tencent.mm.plugin.finder.loader.m.a(m.a.AVATAR)).c(imageView);
        AppMethodBeat.o(260061);
    }

    public final void enterFinderPostUI(Context context, Intent intent) {
        AppMethodBeat.i(162439);
        kotlin.g.b.p.h(context, "context");
        com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI(context, intent);
        AppMethodBeat.o(162439);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class ap implements Runnable {
        final /* synthetic */ long hvK;
        final /* synthetic */ PluginFinder toS;
        final /* synthetic */ aj.b toT;

        ap(PluginFinder pluginFinder, long j2, aj.b bVar) {
            this.toS = pluginFinder;
            this.hvK = j2;
            this.toT = bVar;
        }

        public final void run() {
            long dve;
            AppMethodBeat.i(241901);
            final z.f fVar = new z.f();
            fVar.SYG = (T) ((kotlin.r) this.toS.hvE.get(Long.valueOf(this.hvK)));
            if (com.tencent.mm.plugin.i.a.k.wEa > 0) {
                dve = (long) (com.tencent.mm.plugin.i.a.k.wEa * 1000);
            } else {
                com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                dve = (long) (com.tencent.mm.plugin.finder.storage.c.dve() * 1000);
            }
            Log.i("Finder.PluginFinder", "cache: liveID:" + this.hvK + ",liveStatus:" + ((Object) fVar.SYG) + ",refreshDuration:" + dve + ",thread:" + Thread.currentThread());
            if (fVar.SYG == null || (2 != fVar.SYG.first.intValue() && System.currentTimeMillis() - fVar.SYG.second.longValue() >= dve)) {
                com.tencent.mm.ak.t azz = com.tencent.mm.kernel.g.azz();
                kotlin.g.b.p.g(azz, "MMKernel.getNetSceneQueue()");
                if (azz.azD() != null) {
                    PluginFinder.access$CgiGetLiveInfo(this.toS, this.hvK, this.toT);
                    AppMethodBeat.o(241901);
                    return;
                }
                Log.i("Finder.PluginFinder", "dispatcher is null!");
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                    /* class com.tencent.mm.plugin.finder.PluginFinder.ap.AnonymousClass2 */
                    final /* synthetic */ ap tpX;

                    {
                        this.tpX = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ kotlin.x invoke() {
                        AppMethodBeat.i(241900);
                        aj.b bVar = this.tpX.toT;
                        if (bVar != null) {
                            bVar.a(this.tpX.hvK, 1, new asq());
                        }
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(241900);
                        return xVar;
                    }
                });
                AppMethodBeat.o(241901);
                return;
            }
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                /* class com.tencent.mm.plugin.finder.PluginFinder.ap.AnonymousClass1 */
                final /* synthetic */ ap tpX;

                {
                    this.tpX = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ kotlin.x invoke() {
                    AppMethodBeat.i(241899);
                    aj.b bVar = this.tpX.toT;
                    if (bVar != null) {
                        bVar.a(this.tpX.hvK, fVar.SYG.first.intValue(), fVar.SYG.SWY);
                    }
                    kotlin.x xVar = kotlin.x.SXb;
                    AppMethodBeat.o(241899);
                    return xVar;
                }
            });
            AppMethodBeat.o(241901);
        }
    }

    public final void refreshLiveStatus(long j2, aj.b bVar) {
        AppMethodBeat.i(241932);
        this.tnR.post(new ap(this, j2, bVar));
        AppMethodBeat.o(241932);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class g implements Runnable {
        final /* synthetic */ PluginFinder toS;
        final /* synthetic */ Long tpj;

        g(PluginFinder pluginFinder, Long l) {
            this.toS = pluginFinder;
            this.tpj = l;
        }

        public final void run() {
            AppMethodBeat.i(241839);
            Log.i("Finder.PluginFinder", "cleatLiveStatusCache liveID:" + this.tpj + ",thread:" + Thread.currentThread());
            HashMap hashMap = this.toS.hvE;
            Long l = this.tpj;
            if (hashMap == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                AppMethodBeat.o(241839);
                throw tVar;
            }
            kotlin.g.b.af.fd(hashMap).remove(l);
            AppMethodBeat.o(241839);
        }
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void cleatLiveStatusCache(Long l2) {
        AppMethodBeat.i(241934);
        this.tnR.post(new g(this, l2));
        AppMethodBeat.o(241934);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class ai implements Runnable {
        final /* synthetic */ long hvK;
        final /* synthetic */ PluginFinder toS;
        final /* synthetic */ aj.b toT;

        ai(PluginFinder pluginFinder, long j2, aj.b bVar) {
            this.toS = pluginFinder;
            this.hvK = j2;
            this.toT = bVar;
        }

        public final void run() {
            C c2;
            AppMethodBeat.i(241890);
            final z.f fVar = new z.f();
            fVar.SYG = (T) ((kotlin.r) this.toS.hvE.get(Long.valueOf(this.hvK)));
            StringBuilder append = new StringBuilder("getLiveInfo cache: liveID:").append(this.hvK).append(",liveStatus:").append((Object) fVar.SYG).append(",resp is liveInfo:");
            T t = fVar.SYG;
            if (t != null) {
                c2 = t.SWY;
            } else {
                c2 = null;
            }
            Log.i("Finder.PluginFinder", append.append(c2 instanceof asq).append(",thread:").append(Thread.currentThread()).toString());
            if (fVar.SYG == null || fVar.SYG.first.intValue() != 2 || !(fVar.SYG.SWY instanceof asq)) {
                com.tencent.mm.ak.t azz = com.tencent.mm.kernel.g.azz();
                kotlin.g.b.p.g(azz, "MMKernel.getNetSceneQueue()");
                if (azz.azD() != null) {
                    PluginFinder.access$CgiGetLiveInfo(this.toS, this.hvK, this.toT);
                    AppMethodBeat.o(241890);
                    return;
                }
                Log.i("Finder.PluginFinder", "dispatcher is null!");
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                    /* class com.tencent.mm.plugin.finder.PluginFinder.ai.AnonymousClass2 */
                    final /* synthetic */ ai tpP;

                    {
                        this.tpP = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ kotlin.x invoke() {
                        AppMethodBeat.i(241889);
                        aj.b bVar = this.tpP.toT;
                        if (bVar != null) {
                            bVar.a(this.tpP.hvK, 1, new asq());
                        }
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(241889);
                        return xVar;
                    }
                });
                AppMethodBeat.o(241890);
                return;
            }
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                /* class com.tencent.mm.plugin.finder.PluginFinder.ai.AnonymousClass1 */
                final /* synthetic */ ai tpP;

                {
                    this.tpP = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ kotlin.x invoke() {
                    AppMethodBeat.i(241888);
                    aj.b bVar = this.tpP.toT;
                    if (bVar != null) {
                        bVar.a(this.tpP.hvK, fVar.SYG.first.intValue(), fVar.SYG.SWY);
                    }
                    kotlin.x xVar = kotlin.x.SXb;
                    AppMethodBeat.o(241888);
                    return xVar;
                }
            });
            AppMethodBeat.o(241890);
        }
    }

    public final void getLiveInfo(long j2, aj.b bVar) {
        AppMethodBeat.i(241935);
        this.tnR.post(new ai(this, j2, bVar));
        AppMethodBeat.o(241935);
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void batchGetLiveStatus(List<Pair<Long, String>> list, aj.a aVar) {
        AppMethodBeat.i(241937);
        kotlin.g.b.p.h(list, "finderObjectList");
        kotlin.g.b.p.h(aVar, "callback");
        if (list.isEmpty()) {
            Log.w("Finder.PluginFinder", "batchGetLiveInfo: finderObject list is null!");
            AppMethodBeat.o(241937);
            return;
        }
        List<Pair<Long, String>> list2 = list;
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(list2, 10));
        for (T t2 : list2) {
            arrayList.add(new kotlin.o(((Pair) t2).first, ((Pair) t2).second));
        }
        com.tencent.mm.plugin.finder.cgi.f fVar = new com.tencent.mm.plugin.finder.cgi.f(arrayList, 1);
        fVar.tuy = false;
        com.tencent.mm.ac.d.b(fVar.aYI(), new e(aVar));
        AppMethodBeat.o(241937);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/PluginFinder$CgiGetLiveInfo$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveInfo$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveInfoResp;", "plugin-finder_release"})
    public static final class a implements g.a {
        final /* synthetic */ long hvK;
        final /* synthetic */ PluginFinder toS;
        final /* synthetic */ aj.b toT;

        a(PluginFinder pluginFinder, aj.b bVar, long j2) {
            this.toS = pluginFinder;
            this.toT = bVar;
            this.hvK = j2;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.finder.PluginFinder$a$a  reason: collision with other inner class name */
        static final class RunnableC1085a implements Runnable {
            final /* synthetic */ int $errCode;
            final /* synthetic */ int $errType;
            final /* synthetic */ a toU;
            final /* synthetic */ asq toV;

            RunnableC1085a(a aVar, int i2, int i3, asq asq) {
                this.toU = aVar;
                this.$errType = i2;
                this.$errCode = i3;
                this.toV = asq;
            }

            public final void run() {
                AppMethodBeat.i(241832);
                if (this.$errType == 0 && this.$errCode == 0) {
                    final z.d dVar = new z.d();
                    awe awe = this.toV.liveInfo;
                    dVar.SYE = awe != null ? awe.liveStatus : 1;
                    com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                        /* class com.tencent.mm.plugin.finder.PluginFinder.a.RunnableC1085a.AnonymousClass1 */
                        final /* synthetic */ RunnableC1085a toW;

                        {
                            this.toW = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ kotlin.x invoke() {
                            AppMethodBeat.i(241830);
                            aj.b bVar = this.toW.toU.toT;
                            if (bVar != null) {
                                bVar.a(this.toW.toU.hvK, dVar.SYE, this.toW.toV);
                            }
                            kotlin.x xVar = kotlin.x.SXb;
                            AppMethodBeat.o(241830);
                            return xVar;
                        }
                    });
                    this.toU.toS.hvE.put(Long.valueOf(this.toU.hvK), new kotlin.r(Integer.valueOf(dVar.SYE), Long.valueOf(System.currentTimeMillis()), this.toV));
                    com.tencent.mm.plugin.i.a.k.wEa = this.toV.LAs;
                    AppMethodBeat.o(241832);
                    return;
                }
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                    /* class com.tencent.mm.plugin.finder.PluginFinder.a.RunnableC1085a.AnonymousClass2 */
                    final /* synthetic */ RunnableC1085a toW;

                    {
                        this.toW = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ kotlin.x invoke() {
                        AppMethodBeat.i(241831);
                        aj.b bVar = this.toW.toU.toT;
                        if (bVar != null) {
                            bVar.a(this.toW.toU.hvK, 1, new asq());
                        }
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(241831);
                        return xVar;
                    }
                });
                AppMethodBeat.o(241832);
            }
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.g.a
        public final void a(int i2, int i3, asq asq) {
            AppMethodBeat.i(241833);
            kotlin.g.b.p.h(asq, "resp");
            this.toS.tnR.post(new RunnableC1085a(this, i2, i3, asq));
            AppMethodBeat.o(241833);
        }
    }

    private final void CgiGetLiveInfo(long j2, aj.b bVar) {
        AppMethodBeat.i(241938);
        new com.tencent.mm.plugin.finder.live.model.cgi.g(j2, new a(this, bVar, j2)).aYI();
        AppMethodBeat.o(241938);
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void enterFinderProfileUI(Context context, Intent intent) {
        String str;
        String str2;
        String str3;
        int i2 = 25;
        AppMethodBeat.i(162440);
        kotlin.g.b.p.h(context, "context");
        Boolean valueOf = intent != null ? Boolean.valueOf(intent.getBooleanExtra("key_finder_teen_mode_check", false)) : null;
        if (valueOf == null || !valueOf.booleanValue()) {
            if (intent == null || (str = intent.getStringExtra("finder_username")) == null) {
                str = "";
            }
            if (Util.isNullOrNil(str)) {
                if (intent == null || (str2 = intent.getStringExtra("key_finder_object_Id")) == null) {
                    str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                }
                long Ga = com.tencent.mm.ac.d.Ga(str2);
                if (intent == null || (str3 = intent.getStringExtra("key_finder_object_nonce_id_key")) == null) {
                    str3 = "";
                }
                if (intent != null) {
                    i2 = intent.getIntExtra("share_enter_scene", 25);
                }
                if (Ga == 0) {
                    Log.e("Finder.PluginFinder", "enterFinderProfileUI username & objectId invalid");
                    AppMethodBeat.o(162440);
                    return;
                }
                com.tencent.mm.ac.d.i(new aa(this, Ga, str3, i2, context, intent));
                AppMethodBeat.o(162440);
                return;
            }
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(context, intent);
            com.tencent.mm.plugin.secinforeport.a.d.INSTANCE.asyncReportFinderSecurityInfoThroughCgi(540999686);
            AppMethodBeat.o(162440);
            return;
        }
        ai.a aVar2 = com.tencent.mm.plugin.finder.storage.ai.vFj;
        ai.a.a(context, intent, new z(this, intent, context));
        AppMethodBeat.o(162440);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "canGotoFinderPage", "", "onDone"})
    public static final class z implements ad.a {
        final /* synthetic */ Context $context;
        final /* synthetic */ Intent $intent;
        final /* synthetic */ PluginFinder toS;

        z(PluginFinder pluginFinder, Intent intent, Context context) {
            this.toS = pluginFinder;
            this.$intent = intent;
            this.$context = context;
        }

        @Override // com.tencent.mm.plugin.i.a.ad.a
        public final void mM(boolean z) {
            AppMethodBeat.i(241874);
            if (z) {
                Intent intent = this.$intent;
                if (intent == null) {
                    kotlin.g.b.p.hyc();
                }
                intent.putExtra("key_finder_teen_mode_check", false);
                this.toS.enterFinderProfileUI(this.$context, this.$intent);
            }
            AppMethodBeat.o(241874);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "invoke"})
    static final class ag extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.loader.g.i> {
        public static final ag tpN = new ag();

        static {
            AppMethodBeat.i(241885);
            AppMethodBeat.o(241885);
        }

        ag() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.loader.g.i invoke() {
            AppMethodBeat.i(241884);
            com.tencent.mm.loader.g.i iVar = new com.tencent.mm.loader.g.i("FinderFollowTlSingleExecutor");
            iVar.start();
            AppMethodBeat.o(241884);
            return iVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "invoke"})
    static final class al extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.model.a> {
        public static final al tpU = new al();

        static {
            AppMethodBeat.i(241895);
            AppMethodBeat.o(241895);
        }

        al() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.preload.model.a invoke() {
            AppMethodBeat.i(241894);
            com.tencent.mm.plugin.finder.preload.model.a aVar = new com.tencent.mm.plugin.finder.preload.model.a();
            com.tencent.mm.plugin.finder.preload.a aVar2 = com.tencent.mm.plugin.finder.preload.a.uTO;
            aVar.a(com.tencent.mm.plugin.finder.preload.a.a(null), new HashMap<>(0));
            AppMethodBeat.o(241894);
            return aVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/service/FinderGetContactInterceptor;", "invoke"})
    static final class ah extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.service.c> {
        public static final ah tpO = new ah();

        static {
            AppMethodBeat.i(241887);
            AppMethodBeat.o(241887);
        }

        ah() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.service.c invoke() {
            AppMethodBeat.i(241886);
            com.tencent.mm.plugin.finder.service.c cVar = new com.tencent.mm.plugin.finder.service.c();
            AppMethodBeat.o(241886);
            return cVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/service/FinderContactService;", "invoke"})
    static final class ad extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.service.a> {
        public static final ad tpL = new ad();

        static {
            AppMethodBeat.i(241881);
            AppMethodBeat.o(241881);
        }

        ad() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.service.a invoke() {
            AppMethodBeat.i(241880);
            com.tencent.mm.plugin.finder.service.a aVar = new com.tencent.mm.plugin.finder.service.a();
            AppMethodBeat.o(241880);
            return aVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationUpdater;", "invoke"})
    static final class w extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.conv.i> {
        public static final w tpz = new w();

        static {
            AppMethodBeat.i(241867);
            AppMethodBeat.o(241867);
        }

        w() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.conv.i invoke() {
            AppMethodBeat.i(241866);
            com.tencent.mm.plugin.finder.conv.i iVar = new com.tencent.mm.plugin.finder.conv.i();
            AppMethodBeat.o(241866);
            return iVar;
        }
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void enterFinderSelfProfile(Context context, Intent intent, int i2, int i3) {
        AppMethodBeat.i(241939);
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(intent, "intent");
        String aUg = com.tencent.mm.model.z.aUg();
        if (!Util.isNullOrNil(aUg)) {
            intent.putExtra("finder_username", aUg);
            intent.putExtra("KEY_FINDER_SELF_FLAG", true);
            fillContextIdToIntent(i2, i3, 33, intent);
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(context, intent);
            AppMethodBeat.o(241939);
            return;
        }
        if (context instanceof Activity) {
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            if (com.tencent.mm.plugin.finder.utils.y.bE((Activity) context)) {
                Intent intent2 = new Intent();
                intent2.putExtra("key_create_scene", 6);
                intent2.putExtra("scene", 2);
                intent2.putExtra("key_router_to_profile", false);
                com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.w(context, intent2);
            }
        }
        AppMethodBeat.o(241939);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderTeenModeConfig;", "invoke"})
    static final class af extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.storage.ai> {
        public static final af tpM = new af();

        static {
            AppMethodBeat.i(241883);
            AppMethodBeat.o(241883);
        }

        af() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.storage.ai invoke() {
            AppMethodBeat.i(241882);
            com.tencent.mm.plugin.finder.storage.ai aiVar = new com.tencent.mm.plugin.finder.storage.ai();
            AppMethodBeat.o(241882);
            return aiVar;
        }
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void enterFinderUI(Context context, String str) {
        AppMethodBeat.i(241940);
        kotlin.g.b.p.h(context, "context");
        try {
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (!com.tencent.mm.plugin.finder.storage.c.dqD()) {
                Log.i("Finder.PluginFinder", "enterFinderUI clicfg_ultron_finder_mp_jsapi switch close");
                AppMethodBeat.o(241940);
                return;
            }
            com.tencent.mm.ab.i FJ = new com.tencent.mm.ab.i(str).FJ(IssueStorage.COLUMN_EXT_INFO);
            String string = FJ.getString(NativeProtocol.WEB_DIALOG_ACTION);
            Log.i("Finder.PluginFinder", "json = ".concat(String.valueOf(str)));
            if (string != null) {
                switch (string.hashCode()) {
                    case -505354664:
                        if (string.equals("createLuckyLive")) {
                            String optString = FJ.optString("groupId");
                            if (optString == null) {
                                optString = "";
                            }
                            createLuckyMoneyLive(context, optString);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(22385, 4, Long.valueOf(System.currentTimeMillis()));
                            AppMethodBeat.o(241940);
                            return;
                        }
                        break;
                    case -412058418:
                        if (string.equals("openFinderFeed")) {
                            kotlin.g.b.p.g(FJ, IssueStorage.COLUMN_EXT_INFO);
                            openFinderFeed$default(this, FJ, context, null, null, 8, null);
                            AppMethodBeat.o(241940);
                            return;
                        }
                        break;
                    case 50881657:
                        if (string.equals(com.tencent.mm.plugin.appbrand.jsapi.finder.h.NAME)) {
                            kotlin.g.b.p.g(FJ, IssueStorage.COLUMN_EXT_INFO);
                            openFinderProfile$default(this, FJ, context, null, null, 8, null);
                            AppMethodBeat.o(241940);
                            return;
                        }
                        break;
                    case 819909547:
                        if (string.equals("autoOpenFinderLive")) {
                            kotlin.g.b.p.g(FJ, IssueStorage.COLUMN_EXT_INFO);
                            autoOpenFinderLive(FJ, context, null, null);
                            AppMethodBeat.o(241940);
                            return;
                        }
                        break;
                }
            }
            Log.i("Finder.PluginFinder", "unKnow action:".concat(String.valueOf(string)));
            AppMethodBeat.o(241940);
        } catch (Throwable th) {
            Log.printErrStackTrace("Finder.PluginFinder", th, "enterFinderUI exception", new Object[0]);
            AppMethodBeat.o(241940);
        }
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void enterFinderUIFromMiniApp(Context context, String str, af.a<Object> aVar, af.a<Integer> aVar2) {
        AppMethodBeat.i(241941);
        kotlin.g.b.p.h(context, "context");
        try {
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (!com.tencent.mm.plugin.finder.storage.c.dqD()) {
                Log.i("Finder.PluginFinder", "enterFinderUI clicfg_ultron_finder_mp_jsapi switch close");
                if (aVar2 != null) {
                    aVar2.bn(-1001);
                    AppMethodBeat.o(241941);
                    return;
                }
                AppMethodBeat.o(241941);
                return;
            }
            com.tencent.mm.ab.i FJ = new com.tencent.mm.ab.i(str).FJ(IssueStorage.COLUMN_EXT_INFO);
            String string = FJ.getString(NativeProtocol.WEB_DIALOG_ACTION);
            String optString = FJ.optString("sourceId", "");
            Log.i("Finder.PluginFinder", "json = " + str + ", appid:" + optString);
            if (string != null) {
                switch (string.hashCode()) {
                    case -412058418:
                        if (string.equals("openFinderFeed")) {
                            kotlin.g.b.p.g(FJ, IssueStorage.COLUMN_EXT_INFO);
                            kotlin.g.b.p.g(optString, "appid");
                            openFinderFeed(FJ, context, aVar, optString);
                            AppMethodBeat.o(241941);
                            return;
                        }
                        break;
                    case -411875300:
                        if (string.equals("openFinderLive")) {
                            kotlin.g.b.p.g(FJ, IssueStorage.COLUMN_EXT_INFO);
                            kotlin.g.b.p.g(optString, "appid");
                            openFinderLive(FJ, aVar2, aVar, optString);
                            AppMethodBeat.o(241941);
                            return;
                        }
                        break;
                    case 50881657:
                        if (string.equals(com.tencent.mm.plugin.appbrand.jsapi.finder.h.NAME)) {
                            kotlin.g.b.p.g(FJ, IssueStorage.COLUMN_EXT_INFO);
                            kotlin.g.b.p.g(optString, "appid");
                            openFinderProfile(FJ, context, aVar, optString);
                            AppMethodBeat.o(241941);
                            return;
                        }
                        break;
                    case 819909547:
                        if (string.equals("autoOpenFinderLive")) {
                            kotlin.g.b.p.g(FJ, IssueStorage.COLUMN_EXT_INFO);
                            autoOpenFinderLive(FJ, context, aVar, aVar2);
                            AppMethodBeat.o(241941);
                            return;
                        }
                        break;
                }
            }
            Log.i("Finder.PluginFinder", "unKnow action:".concat(String.valueOf(string)));
            if (aVar2 != null) {
                aVar2.bn(-1000);
                AppMethodBeat.o(241941);
                return;
            }
            AppMethodBeat.o(241941);
        } catch (Throwable th) {
            Log.printErrStackTrace("Finder.PluginFinder", th, "enterFinderUI exception", new Object[0]);
            if (aVar2 != null) {
                aVar2.bn(-1002);
                AppMethodBeat.o(241941);
                return;
            }
            AppMethodBeat.o(241941);
        }
    }

    static /* synthetic */ void openFinderLive$default(PluginFinder pluginFinder, com.tencent.mm.ab.i iVar, af.a aVar, af.a aVar2, String str, int i2, Object obj) {
        AppMethodBeat.i(241943);
        if ((i2 & 8) != 0) {
            str = "";
        }
        pluginFinder.openFinderLive(iVar, aVar, aVar2, str);
        AppMethodBeat.o(241943);
    }

    private final void openFinderLive(com.tencent.mm.ab.i iVar, af.a<Integer> aVar, af.a<Object> aVar2, String str) {
        String str2;
        AppMethodBeat.i(241942);
        String optString = iVar.optString("feedID");
        if (optString == null) {
            optString = "";
        }
        String optString2 = iVar.optString("nonceID");
        if (optString2 == null) {
            optString2 = "";
        }
        String genContextId = genContextId(iVar.optInt("commentScene"), 2, 65);
        if (!Util.isNullOrNil(str)) {
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
            Object[] objArr = new Object[4];
            if (genContextId == null) {
                str2 = "";
            } else {
                str2 = genContextId;
            }
            objArr[0] = str2;
            objArr[1] = str;
            objArr[2] = "";
            objArr[3] = "";
            hVar.a(21140, objArr);
        }
        com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
        com.tencent.mm.plugin.finder.report.live.m.auP(str);
        com.tencent.mm.plugin.expt.hellhound.core.b.aoW(genContextId);
        this.toQ.a("", optString, aVar, optString2, 0, new ao(aVar2), genContextId, str);
        AppMethodBeat.o(241942);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/PluginFinder$openFinderLive$1", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "Ljava/lang/Void;", "onCallback", "", "ret", "plugin-finder_release"})
    public static final class ao implements af.a<Void> {
        final /* synthetic */ af.a tpa;

        ao(af.a aVar) {
            this.tpa = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.i.a.af.a
        public final /* synthetic */ void bn(Void r4) {
            AppMethodBeat.i(241898);
            af.a aVar = this.tpa;
            if (aVar != null) {
                aVar.bn(0);
                AppMethodBeat.o(241898);
                return;
            }
            AppMethodBeat.o(241898);
        }
    }

    private final void autoOpenFinderLive(com.tencent.mm.ab.i iVar, Context context, af.a<Object> aVar, af.a<Integer> aVar2) {
        String str;
        AppMethodBeat.i(241944);
        String optString = iVar.optString("finderUserName");
        if (optString == null) {
            optString = "";
        }
        int optInt = iVar.optInt("commentScene");
        String optString2 = iVar.optString("reportExtraInfo", "");
        com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
        kotlin.g.b.p.g(optString2, "extraInfo");
        com.tencent.mm.plugin.finder.report.live.m.auP(optString2);
        if (!Util.isNullOrNil(optString)) {
            Log.i("Finder.PluginFinder", "autoOpenFinderLive anchorUsername:" + optString + ", commentScene:" + optInt);
            if (optString == null) {
                str = "";
            } else {
                str = optString;
            }
            new com.tencent.mm.plugin.finder.live.model.cgi.n(str, new d(this, optString, optString2, optInt, context, aVar)).aYI();
            AppMethodBeat.o(241944);
            return;
        }
        Log.w("Finder.PluginFinder", "autoOpenFinderLive anchorUsername empty");
        if (aVar2 != null) {
            aVar2.bn(-1000);
            AppMethodBeat.o(241944);
            return;
        }
        AppMethodBeat.o(241944);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/PluginFinder$autoOpenFinderLive$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLastObject$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLatestLiveObjectResponse;", "plugin-finder_release"})
    public static final class d implements n.a {
        final /* synthetic */ Context $context;
        final /* synthetic */ PluginFinder toS;
        final /* synthetic */ String toX;
        final /* synthetic */ String toY;
        final /* synthetic */ int toZ;
        final /* synthetic */ af.a tpa;

        d(PluginFinder pluginFinder, String str, String str2, int i2, Context context, af.a aVar) {
            this.toS = pluginFinder;
            this.toX = str;
            this.toY = str2;
            this.toZ = i2;
            this.$context = context;
            this.tpa = aVar;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.n.a
        public final void a(asm asm) {
            awe awe;
            AppMethodBeat.i(241835);
            kotlin.g.b.p.h(asm, "resp");
            z.f fVar = new z.f();
            fVar.SYG = (T) asm.LCD;
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            int intValue = com.tencent.mm.plugin.finder.storage.c.dqF().value().intValue();
            if (intValue == 1) {
                fVar.SYG = null;
                Log.i("Finder.PluginFinder", "autoOpenFinderLive mock 1");
            } else if (intValue == 2) {
                T t = fVar.SYG;
                if (!(t == null || (awe = t.liveInfo) == null)) {
                    awe.liveStatus = 2;
                }
                Log.i("Finder.PluginFinder", "autoOpenFinderLive mock 2");
            }
            com.tencent.mm.ac.d.h(new a(this, fVar));
            AppMethodBeat.o(241835);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ d tpb;
            final /* synthetic */ z.f tpc;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar, z.f fVar) {
                super(0);
                this.tpb = dVar;
                this.tpc = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                boolean z;
                awe awe;
                awe awe2;
                long j2;
                AppMethodBeat.i(241834);
                if (this.tpc.SYG == null || ((awe2 = this.tpc.SYG.liveInfo) != null && awe2.liveStatus == 2)) {
                    StringBuilder append = new StringBuilder().append(this.tpc.SYG == null).append(", ");
                    T t = this.tpc.SYG;
                    if (t == null || (awe = t.liveInfo) == null || awe.liveStatus != 2) {
                        z = false;
                    } else {
                        z = true;
                    }
                    Log.i("Finder.PluginFinder", append.append(z).toString());
                    Intent intent = new Intent();
                    intent.putExtra("finder_username", this.tpb.toX);
                    intent.putExtra("key_extra_info", this.tpb.toY);
                    if (this.tpb.toZ > 0) {
                        ((com.tencent.mm.plugin.i.a.aj) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).fillContextIdToIntent(this.tpb.toZ, 2, 32, intent);
                    }
                    com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                    com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(this.tpb.$context, intent);
                } else {
                    String genContextId = this.tpb.toS.genContextId(this.tpb.toZ, 2, 65);
                    com.tencent.mm.plugin.expt.hellhound.core.b.aoW(genContextId);
                    com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    long j3 = this.tpc.SYG.id;
                    awe awe3 = this.tpc.SYG.liveInfo;
                    long j4 = awe3 != null ? awe3.liveId : -1;
                    String str = this.tpc.SYG.username;
                    awe awe4 = this.tpc.SYG.liveInfo;
                    kVar.a(j3, j4, str, -1, awe4 != null ? (long) awe4.uBn : -1, s.p.LIVE_AUDIENCE_ENTER_LIVE_ROOM, String.valueOf(this.tpb.toZ));
                    if (Util.isEqual(this.tpb.toX, com.tencent.mm.model.z.aUg())) {
                        com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                        Context context = this.tpb.$context;
                        long j5 = this.tpc.SYG.id;
                        String str2 = this.tpc.SYG.objectNonceId;
                        if (str2 == null) {
                            str2 = "";
                        }
                        awe awe5 = this.tpc.SYG.liveInfo;
                        if (awe5 == null) {
                            awe5 = new awe();
                        }
                        com.tencent.mm.plugin.finder.utils.a.a(context, j5, str2, awe5, false, null, null, null, null, genContextId, this.tpc.SYG.sessionBuffer, null, null, 13296);
                    } else {
                        com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
                        Context context2 = this.tpb.$context;
                        long j6 = this.tpc.SYG.id;
                        awe awe6 = this.tpc.SYG.liveInfo;
                        if (awe6 != null) {
                            j2 = awe6.liveId;
                        } else {
                            j2 = 0;
                        }
                        String str3 = this.tpc.SYG.username;
                        if (str3 == null) {
                            str3 = "";
                        }
                        String str4 = this.tpc.SYG.objectNonceId;
                        if (str4 == null) {
                            str4 = "";
                        }
                        awe awe7 = this.tpc.SYG.liveInfo;
                        com.tencent.mm.plugin.finder.utils.a.a(aVar3, context2, j6, j2, str3, str4, "", genContextId, awe7 != null ? awe7.LGU : 0, this.tpc.SYG.sessionBuffer);
                    }
                }
                af.a aVar4 = this.tpb.tpa;
                if (aVar4 != null) {
                    aVar4.bn(0);
                }
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(241834);
                return xVar;
            }
        }
    }

    static /* synthetic */ void openFinderFeed$default(PluginFinder pluginFinder, com.tencent.mm.ab.i iVar, Context context, af.a aVar, String str, int i2, Object obj) {
        AppMethodBeat.i(241946);
        if ((i2 & 8) != 0) {
            str = "";
        }
        pluginFinder.openFinderFeed(iVar, context, aVar, str);
        AppMethodBeat.o(241946);
    }

    private final void openFinderFeed(com.tencent.mm.ab.i iVar, Context context, af.a<Object> aVar, String str) {
        AppMethodBeat.i(241945);
        String optString = iVar.optString("feedID");
        String optString2 = iVar.optString("nonceID");
        boolean z2 = iVar.optInt("notGetReleatedList") == 0;
        int optInt = iVar.optInt("shareScene", 0);
        String optString3 = iVar.optString("sessionId", "");
        int optInt2 = iVar.optInt("requestScene", 3);
        String optString4 = iVar.optString("reportExtraInfo", "");
        Intent intent = new Intent();
        intent.putExtra("from_user", com.tencent.mm.model.z.aTY());
        intent.putExtra("feed_encrypted_object_id", optString);
        intent.putExtra("feed_object_nonceId", optString2);
        intent.putExtra("key_need_related_list", z2);
        intent.putExtra("key_comment_scene", 39);
        intent.putExtra("key_reuqest_scene", optInt2);
        intent.putExtra("key_session_id", optString3);
        intent.putExtra("key_extra_info", optString4);
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        if (com.tencent.mm.plugin.finder.utils.y.LR(optInt) != -1) {
            com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
            String fillContextIdToIntent = ((com.tencent.mm.plugin.i.a.aj) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).fillContextIdToIntent(com.tencent.mm.plugin.finder.utils.y.LR(optInt), 2, 39, intent);
            if (!Util.isNullOrNil(str)) {
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr = new Object[4];
                if (fillContextIdToIntent == null) {
                    fillContextIdToIntent = "";
                }
                objArr[0] = fillContextIdToIntent;
                objArr[1] = str;
                objArr[2] = optString;
                objArr[3] = "";
                hVar.a(21140, objArr);
            }
        }
        intent.putExtra("report_scene", optInt);
        intent.putExtra("tab_type", 9);
        com.tencent.mm.plugin.finder.spam.a aVar2 = com.tencent.mm.plugin.finder.spam.a.vwk;
        if (com.tencent.mm.plugin.finder.spam.a.avn("entrance") != 0) {
            com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.fw(context);
        } else {
            com.tencent.mm.plugin.finder.utils.a aVar4 = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.F(context, intent);
            com.tencent.mm.plugin.secinforeport.a.d.INSTANCE.asyncReportFinderSecurityInfoThroughCgi(540999685);
        }
        if (aVar != null) {
            aVar.bn(0);
            AppMethodBeat.o(241945);
            return;
        }
        AppMethodBeat.o(241945);
    }

    static /* synthetic */ void openFinderProfile$default(PluginFinder pluginFinder, com.tencent.mm.ab.i iVar, Context context, af.a aVar, String str, int i2, Object obj) {
        AppMethodBeat.i(241948);
        if ((i2 & 8) != 0) {
            str = "";
        }
        pluginFinder.openFinderProfile(iVar, context, aVar, str);
        AppMethodBeat.o(241948);
    }

    private final void openFinderProfile(com.tencent.mm.ab.i iVar, Context context, af.a<Object> aVar, String str) {
        String str2;
        AppMethodBeat.i(241947);
        String optString = iVar.optString("feedID");
        String optString2 = iVar.optString("finderUserName");
        int optInt = iVar.optInt("commentScene");
        String optString3 = iVar.optString("reportExtraInfo", "");
        Intent intent = new Intent();
        intent.putExtra("finder_username", optString2);
        intent.putExtra("finder_read_feed_id", optString);
        intent.putExtra("key_extra_info", optString3);
        com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
        kotlin.g.b.p.g(optString3, "extraInfo");
        com.tencent.mm.plugin.finder.report.live.m.auP(optString3);
        if (optInt > 0) {
            String fillContextIdToIntent = ((com.tencent.mm.plugin.i.a.aj) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).fillContextIdToIntent(optInt, 2, 32, intent);
            if (!Util.isNullOrNil(str)) {
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr = new Object[4];
                if (fillContextIdToIntent == null) {
                    str2 = "";
                } else {
                    str2 = fillContextIdToIntent;
                }
                objArr[0] = str2;
                objArr[1] = str;
                objArr[2] = optString;
                objArr[3] = optString2;
                hVar.a(21140, objArr);
            }
            com.tencent.mm.plugin.expt.hellhound.core.b.aoW(fillContextIdToIntent);
        }
        com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(context, intent);
        if (aVar != null) {
            aVar.bn(0);
            AppMethodBeat.o(241947);
            return;
        }
        AppMethodBeat.o(241947);
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void enterFinderShareFeedUI(Context context, String str, Intent intent) {
        AppMethodBeat.i(241949);
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(str, "json");
        try {
            com.tencent.mm.ab.i iVar = new com.tencent.mm.ab.i(str);
            long Ga = com.tencent.mm.ac.d.Ga(iVar.optString("feedId", AppEventsConstants.EVENT_PARAM_VALUE_NO));
            com.tencent.mm.ab.i FJ = iVar.FJ(IssueStorage.COLUMN_EXT_INFO);
            Log.i("Finder.PluginFinder", "json = ".concat(String.valueOf(str)));
            String string = FJ.getString("feedNonceId");
            int optInt = FJ.optInt("reportScene", 11);
            String optString = FJ.optString("encryptedObjectId", "");
            boolean optBoolean = FJ.optBoolean("getRelatedList", false);
            String optString2 = FJ.optString("sessionId", "");
            String optString3 = FJ.optString("reportExtraInfo", "");
            int optInt2 = FJ.optInt("requestScene", 3);
            if (intent == null) {
                intent = new Intent();
            }
            intent.putExtra("report_scene", optInt);
            intent.putExtra("from_user", com.tencent.mm.model.z.aTY());
            intent.putExtra("feed_object_id", Ga);
            intent.putExtra("feed_encrypted_object_id", optString);
            intent.putExtra("feed_object_nonceId", string);
            intent.putExtra("key_need_related_list", optBoolean);
            intent.putExtra("key_session_id", optString2);
            intent.putExtra("key_comment_scene", 39);
            intent.putExtra("key_reuqest_scene", optInt2);
            String optString4 = iVar.optString("extraInfo", "");
            kotlin.g.b.p.g(optString4, "jsonObject.optString(\"extraInfo\", \"\")");
            if (!Util.isNullOrNil(optString3)) {
                kotlin.g.b.p.g(intent.putExtra("key_extra_info", optString3), "intent.putExtra(Constant…A_INFO, extraInfoFromExt)");
            } else if (!TextUtils.isEmpty(optString4)) {
                intent.putExtra("key_extra_info", optString4);
            }
            com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
            if (com.tencent.mm.plugin.finder.spam.a.avn("entrance") != 0) {
                com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.fw(context);
                AppMethodBeat.o(241949);
                return;
            }
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            fillContextIdToIntent(com.tencent.mm.plugin.finder.utils.y.LR(optInt), 2, 39, intent);
            com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.F(context, intent);
            com.tencent.mm.plugin.secinforeport.a.d.INSTANCE.asyncReportFinderSecurityInfoThroughCgi(540999685);
            AppMethodBeat.o(241949);
        } catch (Throwable th) {
            Log.printErrStackTrace("Finder.PluginFinder", th, "enterFinderProfileUI exception", new Object[0]);
            AppMethodBeat.o(241949);
        }
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void enterFinderShareFeedUI(Context context, Intent intent) {
        AppMethodBeat.i(162441);
        kotlin.g.b.p.h(context, "context");
        Boolean valueOf = intent != null ? Boolean.valueOf(intent.getBooleanExtra("key_finder_teen_mode_check", false)) : null;
        if (valueOf == null || !valueOf.booleanValue()) {
            com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
            if (com.tencent.mm.plugin.finder.spam.a.avn("entrance") != 0) {
                com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.fw(context);
                AppMethodBeat.o(162441);
            } else if (intent == null || intent.getIntExtra("business_type", 0) != 1) {
                com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.F(context, intent);
                com.tencent.mm.plugin.secinforeport.a.d.INSTANCE.asyncReportFinderSecurityInfoThroughCgi(540999685);
                AppMethodBeat.o(162441);
            } else {
                intent.putExtra("KEY_ROUTER_UI", 4);
                com.tencent.mm.plugin.finder.utils.a aVar4 = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.ag(context, intent);
                AppMethodBeat.o(162441);
            }
        } else {
            ai.a aVar5 = com.tencent.mm.plugin.finder.storage.ai.vFj;
            ai.a.a(context, intent, new ab(this, intent, context));
            AppMethodBeat.o(162441);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "canGotoFinderPage", "", "onDone"})
    public static final class ab implements ad.a {
        final /* synthetic */ Context $context;
        final /* synthetic */ Intent $intent;
        final /* synthetic */ PluginFinder toS;

        ab(PluginFinder pluginFinder, Intent intent, Context context) {
            this.toS = pluginFinder;
            this.$intent = intent;
            this.$context = context;
        }

        @Override // com.tencent.mm.plugin.i.a.ad.a
        public final void mM(boolean z) {
            AppMethodBeat.i(241879);
            if (z) {
                Intent intent = this.$intent;
                if (intent == null) {
                    kotlin.g.b.p.hyc();
                }
                intent.putExtra("key_finder_teen_mode_check", false);
                this.toS.enterFinderShareFeedUI(this.$context, this.$intent);
            }
            AppMethodBeat.o(241879);
        }
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void enterFinderTopicUI(Context context, Intent intent) {
        AppMethodBeat.i(165101);
        kotlin.g.b.p.h(context, "context");
        if (!showFinderEntry()) {
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.fw(context);
            AppMethodBeat.o(165101);
            return;
        }
        com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.O(context, intent);
        AppMethodBeat.o(165101);
    }

    public final void enterFinderTopicTimelineUI(Context context, Intent intent) {
        AppMethodBeat.i(241950);
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(intent, "intent");
        if (!showFinderEntry()) {
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.fw(context);
            AppMethodBeat.o(241950);
            return;
        }
        com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.P(context, intent);
        AppMethodBeat.o(241950);
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void enterFinderActivityProfileUI(Context context, Intent intent) {
        AppMethodBeat.i(241951);
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(intent, "intent");
        if (!showFinderEntry()) {
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.fw(context);
            AppMethodBeat.o(241951);
            return;
        }
        com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.aa(context, intent);
        AppMethodBeat.o(241951);
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void enterAlbumRelatedTimelineUI(Context context, Intent intent) {
        AppMethodBeat.i(241952);
        kotlin.g.b.p.h(context, "context");
        Log.i("Finder.PluginFinder", "[enterRelatedTimelineUI] " + context.getClass().getName());
        com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.enterAlbumRelatedTimelineUI(context, intent);
        AppMethodBeat.o(241952);
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void enterFinderPostRouterUI(Context context, Intent intent) {
        AppMethodBeat.i(241953);
        kotlin.g.b.p.h(context, "context");
        com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI(context, intent);
        AppMethodBeat.o(241953);
    }

    public final void enterFinderFollowListUI(Context context, Intent intent) {
        AppMethodBeat.i(241954);
        kotlin.g.b.p.h(context, "context");
        com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.enterFinderFollowListUI(context, intent);
        AppMethodBeat.o(241954);
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final boolean showFinderEntry() {
        AppMethodBeat.i(165102);
        boolean z2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_entry, 0) != 0;
        com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
        int avn = com.tencent.mm.plugin.finder.spam.a.avn("entrance");
        if (avn == 2) {
            Log.i("Finder.PluginFinder", "showFinderEntry ".concat(String.valueOf(avn)));
            z2 = false;
        }
        if (this.toO) {
            Log.i("Finder.PluginFinder", "closeFinderEntryForDebug");
            z2 = false;
        }
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        boolean z3 = com.tencent.mm.plugin.finder.storage.c.drq() != 0;
        if (!z3 || !z2) {
            Log.i("Finder.PluginFinder", "showFinder %s %s", Boolean.valueOf(z2), Boolean.valueOf(z3));
        }
        if (z2 || z3) {
            AppMethodBeat.o(165102);
            return true;
        }
        AppMethodBeat.o(165102);
        return false;
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void enterFinderLiveVisitorUI(Context context, long j2, Long l2, String str, String str2, String str3, String str4, String str5, String str6, int i2) {
        String str7;
        AppMethodBeat.i(260062);
        kotlin.g.b.p.h(str, "anchorUserName");
        kotlin.g.b.p.h(str2, "nonceId");
        kotlin.g.b.p.h(str4, "contextId");
        if (context == null || l2 == null) {
            AppMethodBeat.o(260062);
            return;
        }
        com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class);
        kotlin.g.b.p.g(af2, "MMKernel.service(ITeenModeService::class.java)");
        if (((com.tencent.mm.plugin.teenmode.a.b) af2).Vt()) {
            com.tencent.mm.kernel.c.a af3 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.ad.class);
            kotlin.g.b.p.g(af3, "MMKernel.service(IFinder…enModeConfig::class.java)");
            if (!((com.tencent.mm.plugin.i.a.ad) af3).dxY()) {
                ((com.tencent.mm.plugin.teenmode.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(context);
                AppMethodBeat.o(260062);
                return;
            }
        }
        if (str.length() == 0) {
            com.tencent.mm.ac.d.i(new y(this, context, str4, j2, l2, str2, str3, str5, str6));
            AppMethodBeat.o(260062);
            return;
        }
        com.tencent.mm.plugin.expt.hellhound.core.b.aoW(str4);
        com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
        long longValue = l2.longValue();
        if (str3 == null) {
            str7 = "";
        } else {
            str7 = str3;
        }
        com.tencent.mm.plugin.finder.utils.a.a(context, j2, longValue, str, str2, str7, str4, i2, str5, str6);
        AppMethodBeat.o(260062);
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void enterFinderLiveAnchorUI(Context context, long j2, Long l2, String str, String str2, String str3, String str4, String str5) {
        int i2;
        awe liveInfo;
        AppMethodBeat.i(260063);
        kotlin.g.b.p.h(str, "nonceId");
        kotlin.g.b.p.h(str3, "contextId");
        if (context == null || l2 == null) {
            AppMethodBeat.o(260063);
            return;
        }
        com.tencent.mm.plugin.expt.hellhound.core.b.aoW(str3);
        com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
        long longValue = l2.longValue();
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        boolean dBN = com.tencent.mm.plugin.finder.utils.m.dBN();
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(str, "nonceId");
        kotlin.g.b.p.h(str3, "contextId");
        LiveConfig aBR = new LiveConfig.a().qo(LiveConfig.hvT).zt(longValue).Gd(str).zu(j2).Gg(com.tencent.mm.model.z.aUg()).Gh(str2).bxf(str5).Gl(str4).aBR();
        kotlin.g.b.p.g(aBR, "builder.toWhere(LiveConf…fer)\n            .build()");
        FinderLiveConfig finderLiveConfig = new FinderLiveConfig();
        finderLiveConfig.uiu.add(aBR);
        finderLiveConfig.uit = dBN;
        e.a aVar2 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
        FinderItem Fy = e.a.Fy(j2);
        if (Fy == null || (liveInfo = Fy.getLiveInfo()) == null) {
            i2 = -1;
        } else {
            i2 = liveInfo.LEg;
        }
        finderLiveConfig.sourceType = i2;
        ((com.tencent.mm.plugin.i.a.aj) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).cleatLiveStatusCache(Long.valueOf(longValue));
        com.tencent.mm.plugin.finder.utils.a.b(context, finderLiveConfig, str3);
        AppMethodBeat.o(260063);
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final boolean isAnchorLiving() {
        AppMethodBeat.i(241957);
        com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
        boolean isAnchorLiving = com.tencent.mm.plugin.finder.live.model.o.isAnchorLiving();
        AppMethodBeat.o(241957);
        return isAnchorLiving;
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void createLuckyMoneyLive(Context context, String str) {
        AppMethodBeat.i(260064);
        kotlin.g.b.p.h(context, "context");
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        if (kotlin.g.b.p.j(aAh.azQ().get(ar.a.USERINFO_FINDER_LIVE_LUCKY_MONEY_GUIDE_INT_SYNC, (Object) 0), 0)) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(22385, 3, Long.valueOf(System.currentTimeMillis()));
            Intent intent = new Intent();
            com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
            String obj = aAh2.azQ().get(274436, "").toString();
            if (Util.isNullOrNil(obj)) {
                obj = LocaleUtil.getCurrentCountryCode();
            }
            if (!Util.isNullOrNil(obj) && !Util.isAllAlpha(obj)) {
                obj = "";
            }
            Object[] objArr = new Object[3];
            if (str == null) {
                str = "";
            }
            objArr[0] = URLEncoder.encode(str);
            objArr[1] = LocaleUtil.getApplicationLanguage();
            objArr[2] = obj;
            String string = context.getString(R.string.jbs, objArr);
            kotlin.g.b.p.g(string, "context.getString(R.stri…nLanguage(), countryCode)");
            Charset charset = kotlin.n.d.UTF_8;
            if (string == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(260064);
                throw tVar;
            }
            byte[] bytes = string.getBytes(charset);
            kotlin.g.b.p.g(bytes, "(this as java.lang.String).getBytes(charset)");
            byte[] encode = Base64.encode(bytes, 0);
            kotlin.g.b.p.g(encode, "Base64.encode(WILCOME_UR…eArray(), Base64.DEFAULT)");
            Log.i("Finder.PluginFinder", "WILCOME_URL:".concat(String.valueOf(new String(encode, kotlin.n.d.UTF_8))));
            intent.putExtra("rawUrl", string);
            intent.putExtra("showShare", false);
            com.tencent.mm.br.c.b(context, "webview", ".ui.tools.WebViewUI", intent);
            com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh3, "MMKernel.storage()");
            aAh3.azQ().set(ar.a.USERINFO_FINDER_LIVE_LUCKY_MONEY_GUIDE_INT_SYNC, (Object) 1);
            Log.i("Finder.PluginFinder", "createLuckyMoneyLive show guide");
            AppMethodBeat.o(260064);
            return;
        }
        createLuckyMoneyLiveImpl(context, str);
        AppMethodBeat.o(260064);
    }

    private final void createLuckyMoneyLiveImpl(Context context, String str) {
        AppMethodBeat.i(260065);
        Log.i("Finder.PluginFinder", "createLuckyMoneyLiveImpl");
        Intent intent = new Intent();
        if (str == null) {
            str = "";
        }
        intent.putExtra("KEY_LUCKY_MONEY_CHAT_ROOM_USERNAME", str);
        Intent intent2 = !(context instanceof Activity) ? intent : null;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a(context, intent, 0, 0, false, 124);
        intent.setClass(context, OccupyFinderUI20.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/PluginFinder", "createLuckyMoneyLiveImpl", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/PluginFinder", "createLuckyMoneyLiveImpl", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(260065);
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final boolean isVisitorLiving() {
        AppMethodBeat.i(241958);
        com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
        boolean isVisitorLiving = com.tencent.mm.plugin.finder.live.model.o.isVisitorLiving();
        AppMethodBeat.o(241958);
        return isVisitorLiving;
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final boolean showPostEntry() {
        AppMethodBeat.i(165103);
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_post_entry, 0) != 0) {
            AppMethodBeat.o(165103);
            return true;
        }
        AppMethodBeat.o(165103);
        return false;
    }

    public final void closeFinderEntryForDebug() {
        this.toO = true;
    }

    public final void resetLastTimelineExitTime() {
        AppMethodBeat.i(165110);
        Log.i("Finder.PluginFinder", "reset timeline auto refresh time");
        AppMethodBeat.o(165110);
    }

    public final boolean isFriend(String str) {
        AppMethodBeat.i(165116);
        if (str != null) {
            Boolean bool = this.toP.get(str);
            if (bool == null) {
                com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                Boolean valueOf = Boolean.valueOf(com.tencent.mm.plugin.finder.utils.y.isFriend(str));
                this.toP.put(str, valueOf);
                bool = valueOf;
            }
            boolean booleanValue = bool.booleanValue();
            AppMethodBeat.o(165116);
            return booleanValue;
        }
        AppMethodBeat.o(165116);
        return false;
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void reportPostRedDot(int i2) {
        AppMethodBeat.i(165122);
        com.tencent.mm.plugin.report.service.h.INSTANCE.n(1309, (long) i2, 1);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(19212, Integer.valueOf(i2), Long.valueOf(cl.aWy()));
        AppMethodBeat.o(165122);
    }

    @Override // android.arch.lifecycle.ViewModelStoreOwner
    public final ViewModelStore getViewModelStore() {
        return this.FE;
    }

    @Override // com.tencent.mm.app.o
    public final void onAppForeground(String str) {
    }

    @Override // com.tencent.mm.app.o
    public final void onAppBackground(String str) {
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void shareStatsReport(List<? extends Pair<String, String>> list, boolean z2) {
        AppMethodBeat.i(241959);
        kotlin.g.b.p.h(list, "feedIdList");
        z.f fVar = new z.f();
        fVar.SYG = (T) new LinkedList();
        for (T t2 : list) {
            ecq ecq = new ecq();
            if (z2) {
                ecq.NcU = com.tencent.mm.ac.d.Ga((String) ((Pair) t2).first);
                ecq.NcV = (String) ((Pair) t2).second;
            } else {
                ecq.hFK = com.tencent.mm.ac.d.Ga((String) ((Pair) t2).first);
                ecq.objectNonceId = (String) ((Pair) t2).second;
            }
            cxr cxr = new cxr();
            cxr.MCi++;
            cxr.MCk = 1;
            ecq.NcO = cxr;
            fVar.SYG.add(ecq);
        }
        new com.tencent.mm.plugin.finder.cgi.z(fVar.SYG, null).aYI().j(new as(fVar));
        AppMethodBeat.o(241959);
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final FinderObject tryGetFinderObject(long j2, String str, int i2) {
        AppMethodBeat.i(241960);
        FinderObject tryGetFinderObject$default = tryGetFinderObject$default(this, j2, str, i2, true, null, null, 48, null);
        AppMethodBeat.o(241960);
        return tryGetFinderObject$default;
    }

    public static /* synthetic */ FinderObject tryGetFinderObject$default(PluginFinder pluginFinder, long j2, String str, int i2, boolean z2, Boolean bool, kotlin.g.a.b bVar, int i3, Object obj) {
        AppMethodBeat.i(241963);
        FinderObject tryGetFinderObject = pluginFinder.tryGetFinderObject(j2, str, i2, z2, (i3 & 16) != 0 ? Boolean.FALSE : bool, (i3 & 32) != 0 ? null : bVar);
        AppMethodBeat.o(241963);
        return tryGetFinderObject;
    }

    public final FinderObject tryGetFinderObject(long j2, String str, int i2, boolean z2, Boolean bool, kotlin.g.a.b<? super FinderObject, kotlin.x> bVar) {
        AppMethodBeat.i(241962);
        Log.i("Finder.PluginFinder", "tryGetFinderObject " + j2 + ", enter");
        if (z2) {
            e.a aVar = com.tencent.mm.plugin.finder.storage.data.e.vFX;
            e.a.BX(j2);
        }
        e.a aVar2 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
        FinderItem Fy = e.a.Fy(j2);
        if (Fy == null) {
            Log.i("Finder.PluginFinder", "tryGetFinderObject " + j2 + ", start");
            com.tencent.mm.plugin.finder.cgi.af afVar = new com.tencent.mm.plugin.finder.cgi.af(j2, str, i2, 2, "", true, null, null, 0, null, false, false, null, null, 0, 24512);
            if (kotlin.g.b.p.j(bool, Boolean.TRUE)) {
                Context context = MMApplicationContext.getContext();
                kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
                Context context2 = MMApplicationContext.getContext();
                kotlin.g.b.p.g(context2, "MMApplicationContext.getContext()");
                afVar.c(context, context2.getResources().getString(R.string.cp4), 1000);
            }
            afVar.aYI().h(new au(bVar, j2));
        }
        if (Fy != null) {
            FinderObject feedObject = Fy.getFeedObject();
            AppMethodBeat.o(241962);
            return feedObject;
        }
        AppMethodBeat.o(241962);
        return null;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class an extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        public static final an tpW = new an();

        static {
            AppMethodBeat.i(241897);
            AppMethodBeat.o(241897);
        }

        an() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            boolean z;
            String str;
            AppMethodBeat.i(241896);
            com.tencent.mm.plugin.finder.cgi.report.c cVar = new com.tencent.mm.plugin.finder.cgi.report.c();
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            String a2 = aAh.azQ().a(ar.a.USERINFO_FINDER_LAST_WX_VERSION_STRING_SYNC, "");
            if (!kotlin.g.b.p.j(BuildInfo.CLIENT_VERSION, a2)) {
                Log.i("Finder.PluginFinder", "change version " + a2 + " => " + BuildInfo.CLIENT_VERSION);
                com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
                kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
                aAh2.azQ().set(ar.a.USERINFO_FINDER_LAST_WX_VERSION_STRING_SYNC, BuildInfo.CLIENT_VERSION);
                z = true;
            } else {
                z = false;
            }
            com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh3, "MMKernel.storage()");
            String a3 = aAh3.azQ().a(ar.a.USERINFO_FINDER_LAST_WX_VERSION2_STRING_SYNC, "");
            kotlin.g.b.ae aeVar = kotlin.g.b.ae.SYK;
            String format = String.format("%08x", Arrays.copyOf(new Object[]{Integer.valueOf(com.tencent.mm.protocal.d.KyO)}, 1));
            kotlin.g.b.p.g(format, "java.lang.String.format(format, *args)");
            if (!kotlin.g.b.p.j(format, a3)) {
                Log.i("Finder.PluginFinder", "change wechatv " + a3 + " => " + format);
                com.tencent.mm.kernel.e aAh4 = com.tencent.mm.kernel.g.aAh();
                kotlin.g.b.p.g(aAh4, "MMKernel.storage()");
                aAh4.azQ().set(ar.a.USERINFO_FINDER_LAST_WX_VERSION2_STRING_SYNC, format);
                z = true;
            }
            com.tencent.mm.kernel.e aAh5 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh5, "MMKernel.storage()");
            String a4 = aAh5.azQ().a(ar.a.USERINFO_FINDER_LAST_WX_TAG_STRING_SYNC, "");
            if (!kotlin.g.b.p.j(BuildInfo.BUILD_TAG, a4)) {
                Log.i("Finder.PluginFinder", "change tag " + a4 + " => " + BuildInfo.BUILD_TAG);
                com.tencent.mm.kernel.e aAh6 = com.tencent.mm.kernel.g.aAh();
                kotlin.g.b.p.g(aAh6, "MMKernel.storage()");
                aAh6.azQ().set(ar.a.USERINFO_FINDER_LAST_WX_TAG_STRING_SYNC, BuildInfo.BUILD_TAG);
                z = true;
            }
            if (z) {
                kotlin.g.b.p.g(a2, "lastVersion");
                kotlin.g.b.p.g(a3, "lastVersion2");
                kotlin.g.b.p.g(a4, "lastTag");
                cVar.costTime = cVar.hvh.apr();
                ec ecVar = new ec();
                ecVar.afx();
                ecVar.lz(10000);
                ecVar.qF("wx_change");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("lastVersion", a2);
                jSONObject.put("lastVersion2", a3);
                jSONObject.put("lastTag", a4);
                jSONObject.put("ver", BuildInfo.CLIENT_VERSION);
                jSONObject.put("ver_init", com.tencent.mm.loader.j.a.CLIENT_VERSION);
                kotlin.g.b.ae aeVar2 = kotlin.g.b.ae.SYK;
                String format2 = String.format("%08x", Arrays.copyOf(new Object[]{Integer.valueOf(com.tencent.mm.protocal.d.KyO)}, 1));
                kotlin.g.b.p.g(format2, "java.lang.String.format(format, *args)");
                jSONObject.put("CLIENT_VERSION", format2);
                jSONObject.put("tag", BuildInfo.BUILD_TAG);
                jSONObject.put("rev", BuildInfo.REV);
                String jSONObject2 = jSONObject.toString();
                kotlin.g.b.p.g(jSONObject2, "JSONObject().also { json…\n            }.toString()");
                ecVar.qG(kotlin.n.n.j(jSONObject2, ",", ";", false));
                ecVar.lC(cl.aWy());
                ecVar.le(0);
                JSONObject jSONObject3 = new JSONObject();
                String info = BuildInfo.info();
                if (info != null) {
                    str = kotlin.n.n.j(info, "\n", ";", false);
                } else {
                    str = null;
                }
                jSONObject3.put("result", str);
                String jSONObject4 = jSONObject3.toString();
                kotlin.g.b.p.g(jSONObject4, "JSONObject().also { json…\n            }.toString()");
                ecVar.qH(kotlin.n.n.j(jSONObject4, ",", ";", false));
                ecVar.lA((long) cVar.tyh);
                ecVar.lB(0);
                com.tencent.mm.kernel.e aAh7 = com.tencent.mm.kernel.g.aAh();
                kotlin.g.b.p.g(aAh7, "MMKernel.storage()");
                Object obj = aAh7.azQ().get(ar.a.USERINFO_MY_FINDER_NICKNAME_STRING_SYNC, "");
                if (obj == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(241896);
                    throw tVar;
                }
                ecVar.qI((String) obj);
                Log.i(cVar.TAG, "report value " + ecVar.abW());
                if (!BuildInfo.DEBUG) {
                    ecVar.bfK();
                }
            }
            com.tencent.mm.plugin.finder.utils.f fVar = com.tencent.mm.plugin.finder.utils.f.vVo;
            com.tencent.mm.plugin.finder.utils.f.dBC();
            StringBuilder sb = new StringBuilder();
            com.tencent.mm.plugin.finder.utils.al alVar = com.tencent.mm.plugin.finder.utils.al.waC;
            com.tencent.mm.vfs.s.deleteFile(sb.append(com.tencent.mm.plugin.finder.utils.al.dEE()).append("markread.info").toString());
            StringBuilder sb2 = new StringBuilder();
            com.tencent.mm.plugin.finder.utils.al alVar2 = com.tencent.mm.plugin.finder.utils.al.waC;
            com.tencent.mm.vfs.s.deleteFile(sb2.append(com.tencent.mm.plugin.finder.utils.al.dEE()).append("search-history.info").toString());
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(241896);
            return xVar;
        }
    }

    public final FinderObject requestFinderObject(long j2, String str, int i2) {
        AppMethodBeat.i(241964);
        Log.i("Finder.PluginFinder", "requestFinderObject " + j2 + ", enter");
        z.f fVar = new z.f();
        e.a aVar = com.tencent.mm.plugin.finder.storage.data.e.vFX;
        fVar.SYG = (T) e.a.Fy(j2);
        Object obj = new Object();
        z.a aVar2 = new z.a();
        aVar2.SYB = false;
        if (fVar.SYG == null) {
            Log.i("Finder.PluginFinder", "requestFinderObject " + j2 + ", start");
            new com.tencent.mm.plugin.finder.cgi.af(j2, str, i2, 2, "", true, null, null, 0, null, false, false, null, null, 0, 24512).aYI().h(new ar(fVar, obj, aVar2, j2));
        }
        if (fVar.SYG == null) {
            synchronized (obj) {
                try {
                    if (!aVar2.SYB) {
                        Log.i("Finder.PluginFinder", "requestFinderObject wait ".concat(String.valueOf(j2)));
                        obj.wait(2000);
                        Log.i("Finder.PluginFinder", "requestFinderObject notify ".concat(String.valueOf(j2)));
                    }
                    kotlin.x xVar = kotlin.x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(241964);
                    throw th;
                }
            }
        }
        T t2 = fVar.SYG;
        if (t2 != null) {
            FinderObject feedObject = t2.getFeedObject();
            AppMethodBeat.o(241964);
            return feedObject;
        }
        AppMethodBeat.o(241964);
        return null;
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void sdkShare(String str, String str2, String str3) {
        AppMethodBeat.i(241966);
        com.tencent.mm.plugin.finder.utils.r rVar = com.tencent.mm.plugin.finder.utils.r.vWn;
        Log.i(com.tencent.mm.plugin.finder.utils.r.TAG, "LogPost, dealShare, businessType:" + str + ", appid:" + str2 + ", extInfo:" + str3);
        if (str3 == null || Util.isNullOrNil(str3) || str == null || Util.isNullOrNil(str) || str2 == null || Util.isNullOrNil(str2)) {
            com.tencent.mm.plugin.finder.utils.r.e(-1, "appid or extInfo empty", str, str2);
            AppMethodBeat.o(241966);
            return;
        }
        Intent intent = new Intent();
        dxx dxx = new dxx();
        dxx.vjQ = 1;
        dqh dqh = new dqh();
        dqh.businessType = str;
        dqh.dNI = str2;
        dqh.extInfo = str3;
        dxx.MXA = dqh;
        intent.putExtra("KEY_POST_FROM_SHARE", dxx.toByteArray());
        com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
        Context context = MMApplicationContext.getContext();
        kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
        com.tencent.mm.plugin.finder.utils.a.x(context, intent);
        AppMethodBeat.o(241966);
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void enterFinderLbsLiveFriendsUI(Context context, Intent intent) {
        AppMethodBeat.i(241967);
        kotlin.g.b.p.h(context, "context");
        com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.enterFinderLbsLiveFriendsUI(context, intent);
        AppMethodBeat.o(241967);
    }

    public final void enterFinderLivePostUI(Context context, Intent intent) {
        AppMethodBeat.i(241968);
        kotlin.g.b.p.h(context, "context");
        new com.tencent.mm.plugin.finder.ui.f((Activity) context).prepare();
        AppMethodBeat.o(241968);
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void enterFinderConversationUI(Context context) {
        AppMethodBeat.i(241969);
        kotlin.g.b.p.h(context, "context");
        com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.fA(context);
        AppMethodBeat.o(241969);
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final int getTimelineCommentScene() {
        AppMethodBeat.i(241970);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        int dHR = ((FinderHomeTabStateVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).dHR();
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        int LB = com.tencent.mm.plugin.finder.utils.y.LB(dHR);
        if (-1 == LB) {
            AppMethodBeat.o(241970);
            return 1;
        }
        AppMethodBeat.o(241970);
        return LB;
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final boolean hasFinderPosted() {
        AppMethodBeat.i(241971);
        String aUg = com.tencent.mm.model.z.aUg();
        if (Util.isNullOrNil(com.tencent.mm.model.z.aUg())) {
            AppMethodBeat.o(241971);
            return false;
        }
        l.a aVar = com.tencent.mm.plugin.finder.storage.data.l.vGw;
        kotlin.g.b.p.g(aUg, ch.COL_USERNAME);
        if (!aVar.dG(aUg, 1).isEmpty()) {
            AppMethodBeat.o(241971);
            return true;
        }
        AppMethodBeat.o(241971);
        return false;
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void snsToFinderPostReport(String str, int i2, String str2, int i3, int i4, int i5, long j2, long j3, long j4, int i6) {
        AppMethodBeat.i(241972);
        kotlin.g.b.p.h(str, "sessionID");
        kotlin.g.b.p.h(str2, "wording");
        com.tencent.mm.plugin.finder.report.q qVar = com.tencent.mm.plugin.finder.report.q.vgE;
        com.tencent.mm.plugin.finder.report.q.a(str, i2, str2, i3, i4, i5, j2, j3, j4, i6);
        AppMethodBeat.o(241972);
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final String fillContextIdToIntent(int i2, int i3, int i4, Intent intent) {
        AppMethodBeat.i(241973);
        String fillContextIdToIntent = fillContextIdToIntent(genContextId(i2, i3, i4), intent);
        AppMethodBeat.o(241973);
        return fillContextIdToIntent;
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final String fillContextIdToIntent(String str, Intent intent) {
        AppMethodBeat.i(241974);
        if (intent != null) {
            intent.putExtra("key_context_id", str);
        }
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_FINDER_CONTEXT_ID_STRING, str);
        if (str == null) {
            str = "";
        }
        AppMethodBeat.o(241974);
        return str;
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final String genContextId(int i2, int i3, int i4) {
        AppMethodBeat.i(241975);
        String uuid = UUID.randomUUID().toString();
        kotlin.g.b.p.g(uuid, "UUID.randomUUID().toString()");
        String str = i2 + '-' + i3 + '-' + i4 + '-' + kotlin.n.n.j(uuid, "-", "", false);
        AppMethodBeat.o(241975);
        return str;
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void enterFinderLiveInvitedUI(Context context, String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(241976);
        kotlin.g.b.p.h(context, "context");
        com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
        if (str4 == null) {
            str4 = "";
        }
        long Ga = com.tencent.mm.ac.d.Ga(str4);
        if (str5 == null) {
            str5 = "";
        }
        com.tencent.mm.plugin.finder.utils.a.a(context, str, str2, str3, Ga, com.tencent.mm.ac.d.Ga(str5));
        AppMethodBeat.o(241976);
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void checkInsertLiveNewReddot() {
        AppMethodBeat.i(241977);
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        com.tencent.mm.plugin.finder.utils.m.checkInsertLiveNewReddot();
        AppMethodBeat.o(241977);
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final com.tencent.mm.plugin.i.a.af getFinderUtilApi() {
        return this.toQ;
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final com.tencent.mm.plugin.i.a.ac getFinderSwitchApi() {
        return com.tencent.mm.plugin.finder.utils.v.vXn;
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void checkLastLiveObject() {
        AppMethodBeat.i(241978);
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        boolean cW = com.tencent.mm.ac.d.cW(com.tencent.mm.plugin.finder.utils.m.VQ().getInt("live_status_flag", 0), 1);
        z.a aVar = new z.a();
        aVar.SYB = false;
        if (cW) {
            com.tencent.mm.plugin.finder.utils.m mVar2 = com.tencent.mm.plugin.finder.utils.m.vVH;
            com.tencent.mm.plugin.finder.utils.m.VQ().putInt("live_status_flag", 0);
            long currentTimeMillis = System.currentTimeMillis();
            String aUg = com.tencent.mm.model.z.aUg();
            kotlin.g.b.p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
            new com.tencent.mm.plugin.finder.live.model.cgi.n(aUg, new f(this, currentTimeMillis, aVar)).aYI();
        }
        Log.i("Finder.PluginFinder", "checkUnfinishLive localUnfinishLive:".concat(String.valueOf(cW)));
        AppMethodBeat.o(241978);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/PluginFinder$checkLastLiveObject$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLastObject$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLatestLiveObjectResponse;", "plugin-finder_release"})
    public static final class f implements n.a {
        final /* synthetic */ long kPc;
        final /* synthetic */ PluginFinder toS;
        final /* synthetic */ z.a tpe;

        f(PluginFinder pluginFinder, long j2, z.a aVar) {
            this.toS = pluginFinder;
            this.kPc = j2;
            this.tpe = aVar;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.n.a
        public final void a(asm asm) {
            awe awe;
            awe awe2;
            FinderContact finderContact;
            awe awe3;
            Integer num = null;
            AppMethodBeat.i(241838);
            kotlin.g.b.p.h(asm, "resp");
            long currentTimeMillis = System.currentTimeMillis() - this.kPc;
            FinderObject finderObject = asm.LCD;
            StringBuilder append = new StringBuilder("checkUnfinishLive duration:").append(currentTimeMillis).append(" finderObject:[objectId:").append(finderObject != null ? Long.valueOf(finderObject.id) : null).append(" liveId:").append((finderObject == null || (awe3 = finderObject.liveInfo) == null) ? null : Long.valueOf(awe3.liveId)).append(" anchorUsername:").append((finderObject == null || (finderContact = finderObject.contact) == null) ? null : finderContact.username).append(" liveStatus:");
            if (!(finderObject == null || (awe2 = finderObject.liveInfo) == null)) {
                num = Integer.valueOf(awe2.liveStatus);
            }
            Log.i("Finder.PluginFinder", append.append(num).append(']').toString());
            if (finderObject == null || (awe = finderObject.liveInfo) == null) {
                AppMethodBeat.o(241838);
                return;
            }
            if (currentTimeMillis < 5000) {
                this.tpe.SYB = awe.liveStatus == 1;
                Log.i("Finder.PluginFinder", "checkUnfinishLive remoteUnfinishLive:" + this.tpe.SYB);
                if (this.tpe.SYB) {
                    f.a aVar = new f.a(MMApplicationContext.getContext());
                    Context context = MMApplicationContext.getContext();
                    kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
                    f.a bow = aVar.bow(context.getResources().getString(R.string.csx));
                    Context context2 = MMApplicationContext.getContext();
                    kotlin.g.b.p.g(context2, "MMApplicationContext.getContext()");
                    f.a b2 = bow.boA(context2.getResources().getString(R.string.csw)).b(new a(awe, this, currentTimeMillis, finderObject));
                    Context context3 = MMApplicationContext.getContext();
                    kotlin.g.b.p.g(context3, "MMApplicationContext.getContext()");
                    b2.boB(context3.getResources().getString(R.string.sz)).show();
                    AppMethodBeat.o(241838);
                    return;
                }
            } else {
                Log.i("Finder.PluginFinder", "checkUnfinishLive timeout: duration:".concat(String.valueOf(currentTimeMillis)));
            }
            AppMethodBeat.o(241838);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick", "com/tencent/mm/plugin/finder/PluginFinder$checkLastLiveObject$1$onCgiBack$1$1"})
        static final class a implements f.c {
            final /* synthetic */ awe tpf;
            final /* synthetic */ f tpg;
            final /* synthetic */ long tph;
            final /* synthetic */ FinderObject tpi;

            a(awe awe, f fVar, long j2, FinderObject finderObject) {
                this.tpf = awe;
                this.tpg = fVar;
                this.tph = j2;
                this.tpi = finderObject;
            }

            @Override // com.tencent.mm.ui.widget.a.f.c
            public final void e(boolean z, String str) {
                String str2;
                AppMethodBeat.i(241837);
                PluginFinder pluginFinder = this.tpg.toS;
                Context context = MMApplicationContext.getContext();
                long j2 = this.tpi.id;
                Long valueOf = Long.valueOf(this.tpf.liveId);
                String str3 = this.tpi.objectNonceId;
                if (str3 == null) {
                    str3 = "";
                }
                com.tencent.mm.plugin.finder.search.i iVar = com.tencent.mm.plugin.finder.search.i.vvu;
                FinderObjectDesc finderObjectDesc = this.tpi.objectDesc;
                if (finderObjectDesc == null || (str2 = finderObjectDesc.description) == null) {
                    str2 = "";
                }
                pluginFinder.enterFinderLiveAnchorUI(context, j2, valueOf, str3, com.tencent.mm.plugin.finder.search.i.auY(str2), "", this.tpi.sessionBuffer, "");
                AppMethodBeat.o(241837);
            }
        }
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final com.tencent.mm.plugin.i.a.ae getFinderUIApi() {
        return com.tencent.mm.plugin.finder.utils.x.vXq;
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final com.tencent.mm.plugin.i.a.ap getFinderOpenSdkApi() {
        return com.tencent.mm.plugin.finder.utils.ao.UVd;
    }

    public final boolean isPagEnable() {
        AppMethodBeat.i(241979);
        com.tencent.mm.plugin.expansions.d dVar = com.tencent.mm.plugin.expansions.d.rNG;
        boolean aoc = com.tencent.mm.plugin.expansions.d.aoc("xlab");
        AppMethodBeat.o(241979);
        return aoc;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0022  */
    @Override // com.tencent.mm.plugin.i.a.aj
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void report21053(android.view.View r13, android.widget.BaseAdapter r14, int r15, int r16, int r17, long r18, java.lang.String r20, int r21, boolean r22) {
        /*
        // Method dump skipped, instructions count: 320
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.PluginFinder.report21053(android.view.View, android.widget.BaseAdapter, int, int, int, long, java.lang.String, int, boolean):void");
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class x extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        public static final x tpA = new x();

        static {
            AppMethodBeat.i(165067);
            AppMethodBeat.o(165067);
        }

        x() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(165066);
            com.tencent.mm.plugin.finder.utils.j jVar = com.tencent.mm.plugin.finder.utils.j.vVA;
            com.tencent.mm.plugin.finder.utils.j.dBI();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(165066);
            return xVar;
        }
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void report21053OnClick(long j2, long j3, String str, int i2, int i3, long j4, String str2, int i4, int i5, String str3, String str4, long j5, int i6) {
        s.p pVar;
        s.av avVar;
        String str5;
        String str6;
        String str7;
        String str8;
        AppMethodBeat.i(241982);
        if (j4 == s.p.LIVE_AUDIENCE_CLICK_SINGLE_AVATAR.dDw) {
            pVar = s.p.LIVE_AUDIENCE_CLICK_SINGLE_AVATAR;
        } else if (j4 == s.p.LIVE_AUDIENCE_CLICK_FEED_CARD_AVATAR_LIVING.dDw) {
            pVar = s.p.LIVE_AUDIENCE_CLICK_FEED_CARD_AVATAR_LIVING;
        } else if (j4 == s.p.LIVE_AUDIENCE_CLICK_FEED_CARD_AVATAR.dDw) {
            pVar = s.p.LIVE_AUDIENCE_CLICK_FEED_CARD_AVATAR;
        } else {
            if (j4 != s.p.LIVE_AUDIENCE_ENTER_LIVE_ROOM.dDw) {
                if (j4 == s.p.LIVE_AUDIENCE_CLICK_AVATAR_LIVING.dDw) {
                    pVar = s.p.LIVE_AUDIENCE_CLICK_AVATAR_LIVING;
                } else if (j4 == s.p.LIVE_AUDIENCE_CLICK_LIVE_FEED_AVATAR_LIVING.dDw) {
                    pVar = s.p.LIVE_AUDIENCE_CLICK_LIVE_FEED_AVATAR_LIVING;
                } else if (j4 == s.p.LIVE_AUDIENCE_CLICK_FEED_AVATAR_LIVING.dDw) {
                    pVar = s.p.LIVE_AUDIENCE_CLICK_FEED_AVATAR_LIVING;
                }
            }
            pVar = s.p.LIVE_AUDIENCE_ENTER_LIVE_ROOM;
        }
        if (i6 == s.av.CLICK_LIVE_CARD.type) {
            avVar = s.av.CLICK_LIVE_CARD;
        } else if (i6 == s.av.CLICK_LIVE_CARD_AVATAR_LIVING.type) {
            avVar = s.av.CLICK_LIVE_CARD_AVATAR_LIVING;
        } else if (i6 == s.av.CLICK_CARD_AVATAR_LIVING.type) {
            avVar = s.av.CLICK_CARD_AVATAR_LIVING;
        } else if (i6 == s.av.CLICK_AVATAR_LIVING.type) {
            avVar = s.av.CLICK_AVATAR_LIVING;
        } else {
            s.av avVar2 = s.av.CLICK_SNSAD_ENTER_LIVE_ROOM;
            avVar = s.av.CLICK_SNSAD_ENTER_LIVE_ROOM;
        }
        if (kotlin.g.b.p.j(s.j.COMMENT_SCENE_RED_PACKET_MSG_IN_GOUR_CHAT.scene, str2)) {
            com.tencent.mm.plugin.finder.report.live.k.vkd.a(j2, j3, str, (long) i2, (long) i3, s.p.LIVE_AUDIENCE_ENTER_LIVE_ROOM, str2);
            AppMethodBeat.o(241982);
            return;
        }
        com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
        if (str == null) {
            str5 = "";
        } else {
            str5 = str;
        }
        long j6 = (long) i2;
        long j7 = (long) i3;
        if (str2 == null) {
            str6 = "";
        } else {
            str6 = str2;
        }
        long j8 = (long) i4;
        long j9 = (long) i5;
        if (str3 == null) {
            str7 = "";
        } else {
            str7 = str3;
        }
        if (str4 == null) {
            str8 = "";
        } else {
            str8 = str4;
        }
        com.tencent.mm.plugin.finder.report.live.k.b(new com.tencent.mm.plugin.finder.report.live.q(j2, j3, str5, j6, j7, pVar, str6, j8, j9, str7, str8, j5, avVar));
        AppMethodBeat.o(241982);
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void reportGiftOnReturn() {
        AppMethodBeat.i(241983);
        com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
        com.tencent.mm.plugin.finder.report.live.m.a(s.aw.RETURN_GIFT_BOARD_FROM_EXCHARGE_UI, "", 0);
        AppMethodBeat.o(241983);
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void report21053OnClickOnSnsAd(long j2, long j3, String str, long j4) {
        AppMethodBeat.i(241984);
        com.tencent.mm.plugin.finder.report.live.k.vkd.a(j2, j3, str, j4, 0, s.p.LIVE_AUDIENCE_ENTER_LIVE_ROOM, "37");
        AppMethodBeat.o(241984);
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void enterFinderPoiFeedUI(Context context, Intent intent) {
        AppMethodBeat.i(241985);
        kotlin.g.b.p.h(context, "context");
        com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.aj(context, intent);
        AppMethodBeat.o(241985);
    }

    public final boolean isAnyHomeTabEnableFullScreenEnjoy() {
        AppMethodBeat.i(241986);
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        boolean isAnyHomeTabEnableFullScreenEnjoy = com.tencent.mm.plugin.finder.utils.y.isAnyHomeTabEnableFullScreenEnjoy();
        AppMethodBeat.o(241986);
        return isAnyHomeTabEnableFullScreenEnjoy;
    }

    public final boolean isAllHomeTabEnableFullScreenEnjoy() {
        AppMethodBeat.i(241987);
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        boolean isAllHomeTabEnableFullScreenEnjoy = com.tencent.mm.plugin.finder.utils.y.isAllHomeTabEnableFullScreenEnjoy();
        AppMethodBeat.o(241987);
        return isAllHomeTabEnableFullScreenEnjoy;
    }

    public final boolean isAnyEnableFullScreenEnjoy() {
        AppMethodBeat.i(241988);
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        boolean isAnyEnableFullScreenEnjoy = com.tencent.mm.plugin.finder.utils.y.isAnyEnableFullScreenEnjoy();
        AppMethodBeat.o(241988);
        return isAnyEnableFullScreenEnjoy;
    }

    public final boolean isAllEnableFullScreenEnjoy() {
        AppMethodBeat.i(241989);
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        boolean isAllEnableFullScreenEnjoy = com.tencent.mm.plugin.finder.utils.y.isAllEnableFullScreenEnjoy();
        AppMethodBeat.o(241989);
        return isAllEnableFullScreenEnjoy;
    }

    public final boolean isGlobalEnableFullScreenEnjoy() {
        AppMethodBeat.i(241990);
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        com.tencent.mm.plugin.finder.utils.y.dCS();
        if (com.tencent.mm.plugin.finder.utils.y.vXA == 1) {
            AppMethodBeat.o(241990);
            return true;
        }
        AppMethodBeat.o(241990);
        return false;
    }

    public final boolean isOtherEnableFullScreenEnjoy() {
        AppMethodBeat.i(241991);
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        boolean isOtherEnableFullScreenEnjoy = com.tencent.mm.plugin.finder.utils.y.isOtherEnableFullScreenEnjoy();
        AppMethodBeat.o(241991);
        return isOtherEnableFullScreenEnjoy;
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final boolean isDisablePostHalfScreen() {
        AppMethodBeat.i(241992);
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        boolean isDisablePostHalfScreen = com.tencent.mm.plugin.finder.utils.y.isDisablePostHalfScreen();
        AppMethodBeat.o(241992);
        return isDisablePostHalfScreen;
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final boolean isAllowEditFillingFullScreen() {
        AppMethodBeat.i(260066);
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        com.tencent.mm.plugin.finder.utils.y.dCS();
        if (com.tencent.mm.plugin.finder.utils.y.UVj == 1) {
            AppMethodBeat.o(260066);
            return true;
        }
        AppMethodBeat.o(260066);
        return false;
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void forcestopCurLive() {
        AppMethodBeat.i(260067);
        com.tencent.mm.plugin.finder.live.model.o.a(com.tencent.mm.plugin.finder.live.model.o.ujN);
        AppMethodBeat.o(260067);
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final boolean canEnterMvAndShowToast() {
        AppMethodBeat.i(241993);
        if (isAnchorLiving() || isVisitorLiving()) {
            Toast.makeText(MMApplicationContext.getContext(), (int) R.string.cio, 0).show();
            AppMethodBeat.o(241993);
            return false;
        }
        AppMethodBeat.o(241993);
        return true;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class aa extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ Intent $intent;
        final /* synthetic */ PluginFinder toS;
        final /* synthetic */ int toZ;
        final /* synthetic */ long tpC;
        final /* synthetic */ String tpD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        aa(PluginFinder pluginFinder, long j2, String str, int i2, Context context, Intent intent) {
            super(0);
            this.toS = pluginFinder;
            this.tpC = j2;
            this.tpD = str;
            this.toZ = i2;
            this.$context = context;
            this.$intent = intent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(241878);
            FinderObject requestFinderObject = this.toS.requestFinderObject(this.tpC, this.tpD, this.toZ);
            if (requestFinderObject == null) {
                Log.e("Finder.PluginFinder", "enterFinderProfileUI requestFinderObject null");
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                    /* class com.tencent.mm.plugin.finder.PluginFinder.aa.AnonymousClass1 */
                    final /* synthetic */ aa tpJ;

                    {
                        this.tpJ = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ kotlin.x invoke() {
                        AppMethodBeat.i(241875);
                        com.tencent.mm.ui.base.u.makeText(this.tpJ.$context, (int) R.string.h76, 0).show();
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(241875);
                        return xVar;
                    }
                });
            } else {
                Intent intent = this.$intent;
                if (intent != null) {
                    String str = requestFinderObject.username;
                    if (str == null) {
                        str = "";
                    }
                    intent.putExtra("finder_username", str);
                }
                Intent intent2 = this.$intent;
                if (intent2 != null) {
                    String str2 = requestFinderObject.username;
                    if (str2 == null) {
                        str2 = "";
                    }
                    intent2.putExtra("key_finder_teen_mode_user_id", str2);
                }
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                    /* class com.tencent.mm.plugin.finder.PluginFinder.aa.AnonymousClass2 */
                    final /* synthetic */ aa tpJ;

                    {
                        this.tpJ = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ kotlin.x invoke() {
                        AppMethodBeat.i(241877);
                        ai.a aVar = com.tencent.mm.plugin.finder.storage.ai.vFj;
                        ai.a.a(this.tpJ.$context, this.tpJ.$intent, new ad.a(this) {
                            /* class com.tencent.mm.plugin.finder.PluginFinder.aa.AnonymousClass2.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass2 tpK;

                            {
                                this.tpK = r1;
                            }

                            @Override // com.tencent.mm.plugin.i.a.ad.a
                            public final void mM(boolean z) {
                                AppMethodBeat.i(241876);
                                if (z) {
                                    com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                                    com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(this.tpK.tpJ.$context, this.tpK.tpJ.$intent);
                                }
                                AppMethodBeat.o(241876);
                            }
                        });
                        com.tencent.mm.plugin.secinforeport.a.d.INSTANCE.asyncReportFinderSecurityInfoThroughCgi(540999686);
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(241877);
                        return xVar;
                    }
                });
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(241878);
            return xVar;
        }
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void openChannelsPostPage(Activity activity) {
        AppMethodBeat.i(260068);
        kotlin.g.b.p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        Log.i("Finder.PluginFinder", "[openChannelsPostPage]");
        com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
        com.tencent.mm.plugin.finder.report.i.as(11, false);
        com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI(activity, null);
        AppMethodBeat.o(260068);
    }

    @Override // com.tencent.mm.plugin.i.a.aj
    public final void openChannelsCreateContact(Activity activity, af.a<Boolean> aVar) {
        AppMethodBeat.i(260069);
        kotlin.g.b.p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        kotlin.g.b.p.h(aVar, "didOpenCallback");
        String aUg = com.tencent.mm.model.z.aUg();
        Log.i("Finder.PluginFinder", "[openChannelsCreateContact] myFinderUsername".concat(String.valueOf(aUg)));
        String str = aUg;
        if (str == null || str.length() == 0) {
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            if (com.tencent.mm.plugin.finder.utils.y.a(activity, aVar)) {
                Intent intent = new Intent();
                intent.putExtra("key_create_scene", 8);
                com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.w(activity, intent);
                AppMethodBeat.o(260069);
                return;
            }
        } else {
            Intent intent2 = new Intent();
            com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.z(activity, intent2);
        }
        AppMethodBeat.o(260069);
    }
}
