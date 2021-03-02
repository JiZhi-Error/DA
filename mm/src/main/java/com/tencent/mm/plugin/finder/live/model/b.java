package com.tencent.mm.plugin.finder.live.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.w;
import com.tencent.mm.g.a.hi;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.core.core.b.f;
import com.tencent.mm.live.core.core.e;
import com.tencent.mm.model.cl;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.cgi.cn;
import com.tencent.mm.plugin.finder.cgi.t;
import com.tencent.mm.plugin.finder.cgi.u;
import com.tencent.mm.plugin.finder.cgi.x;
import com.tencent.mm.plugin.finder.live.model.cgi.a;
import com.tencent.mm.plugin.finder.live.model.cgi.ac;
import com.tencent.mm.plugin.finder.live.model.cgi.ad;
import com.tencent.mm.plugin.finder.live.model.cgi.ae;
import com.tencent.mm.plugin.finder.live.model.cgi.af;
import com.tencent.mm.plugin.finder.live.model.cgi.ag;
import com.tencent.mm.plugin.finder.live.model.cgi.ah;
import com.tencent.mm.plugin.finder.live.model.cgi.ai;
import com.tencent.mm.plugin.finder.live.model.cgi.b;
import com.tencent.mm.plugin.finder.live.model.cgi.c;
import com.tencent.mm.plugin.finder.live.model.cgi.d;
import com.tencent.mm.plugin.finder.live.model.cgi.e;
import com.tencent.mm.plugin.finder.live.model.cgi.f;
import com.tencent.mm.plugin.finder.live.model.cgi.h;
import com.tencent.mm.plugin.finder.live.model.cgi.i;
import com.tencent.mm.plugin.finder.live.model.cgi.j;
import com.tencent.mm.plugin.finder.live.model.cgi.l;
import com.tencent.mm.plugin.finder.live.model.cgi.o;
import com.tencent.mm.plugin.finder.live.model.cgi.p;
import com.tencent.mm.plugin.finder.live.model.cgi.q;
import com.tencent.mm.plugin.finder.live.model.cgi.u;
import com.tencent.mm.plugin.finder.live.model.cgi.v;
import com.tencent.mm.plugin.finder.live.model.cgi.x;
import com.tencent.mm.plugin.finder.live.model.cgi.y;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.plugin.af;
import com.tencent.mm.plugin.finder.live.plugin.y;
import com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.ae;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.ape;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.aqd;
import com.tencent.mm.protocal.protobuf.asq;
import com.tencent.mm.protocal.protobuf.ass;
import com.tencent.mm.protocal.protobuf.asu;
import com.tencent.mm.protocal.protobuf.ata;
import com.tencent.mm.protocal.protobuf.auf;
import com.tencent.mm.protocal.protobuf.aun;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.auu;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.awa;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.protocal.protobuf.awn;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.axo;
import com.tencent.mm.protocal.protobuf.ayd;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.ban;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.protocal.protobuf.ciz;
import com.tencent.mm.protocal.protobuf.cja;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.protocal.protobuf.cjc;
import com.tencent.mm.protocal.protobuf.cjd;
import com.tencent.mm.protocal.protobuf.fgg;
import com.tencent.mm.protocal.protobuf.fgh;
import com.tencent.mm.protocal.protobuf.fgi;
import com.tencent.mm.protocal.protobuf.fhq;
import com.tencent.mm.protocal.protobuf.vh;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.trtc.TRTCCloudDef;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.xwalk.core.XWalkEnvironment;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000î\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004Jd\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00062\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010\u00062\b\u0010'\u001a\u0004\u0018\u00010\u00062\b\u0010(\u001a\u0004\u0018\u00010)H\u0016Jd\u0010*\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00062\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010&\u001a\u0004\u0018\u00010\u00062\u0006\u0010+\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010\u00062\b\u0010(\u001a\u0004\u0018\u00010,H\u0016JH\u0010-\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00062\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010\u00062\b\u0010(\u001a\u0004\u0018\u00010.H\u0016J\u0010\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020\u001dH\u0016JP\u00101\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00062\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u000102H\u0016JZ\u00103\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00062\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u00104\u001a\u0004\u0018\u00010\u00062\u0006\u0010+\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u000105H\u0016J\u001e\u00106\u001a\u00020\u001b2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u0006082\u0006\u00109\u001a\u00020:H\u0016JL\u0010;\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00062\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\r2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00060=2\b\u0010(\u001a\u0004\u0018\u00010>H\u0016J\u0018\u0010?\u001a\u00020\u001b2\u0006\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020\rH\u0016J\b\u0010B\u001a\u00020\u0010H\u0016J\b\u0010C\u001a\u00020\u0010H\u0016J\b\u0010D\u001a\u00020\u0010H\u0016J\u001a\u0010E\u001a\u00020\u00102\b\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010H\u001a\u00020IH\u0016J\u0018\u0010J\u001a\u00020\u001b2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u0010H\u0016J8\u0010N\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u00104\u001a\u0004\u0018\u00010\u00062\b\u0010'\u001a\u0004\u0018\u00010\u00062\b\u0010(\u001a\u0004\u0018\u00010OH\u0016J@\u0010P\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\r2\b\u00104\u001a\u0004\u0018\u00010\u00062\b\u0010'\u001a\u0004\u0018\u00010\u00062\u0006\u0010Q\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010(\u001a\u0004\u0018\u00010RH\u0016J\b\u0010S\u001a\u00020\u001bH\u0016J2\u0010T\u001a\u00020\u001b2\u0006\u0010U\u001a\u00020V2\b\u0010W\u001a\u0004\u0018\u00010\u00062\b\u0010X\u001a\u0004\u0018\u00010!2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001d0YH\u0002J\u0001\u0010Z\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\r2y\u0010(\u001au\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(^\u0012\u0013\u0012\u00110\r¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(_\u0012\u0013\u0012\u00110\r¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(`\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(a\u0012\u0015\u0012\u0013\u0018\u00010b¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(c\u0012\u0004\u0012\u00020\u001b\u0018\u00010[H\u0016J\b\u0010d\u001a\u00020\u001bH\u0016J­\u0001\u0010e\u001a\u00020\u001b2¢\u0001\u0010(\u001a\u0001\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(^\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(g\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(h\u0012\u0013\u0012\u00110\r¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(`\u0012\u0013\u0012\u00110\r¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(_\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(a\u0012\u0013\u0012\u00110i¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(c\u0012\u0004\u0012\u00020\u001b\u0018\u00010fH\u0016JT\u0010j\u001a\u00020\u001b2\b\u0010k\u001a\u0004\u0018\u00010\u00062\u0006\u0010l\u001a\u00020\u001028\u0010(\u001a4\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(^\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(l\u0012\u0004\u0012\u00020\u001b\u0018\u00010mH\u0016J\u0012\u0010n\u001a\u00020\u001b2\b\u0010o\u001a\u0004\u0018\u00010\u0006H\u0016J\u0001\u0010p\u001a\u00020\u001b2\u0006\u0010q\u001a\u00020\u00102\u0006\u0010r\u001a\u00020\u00102y\u0010(\u001au\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(^\u0012\u0013\u0012\u00110\r¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(_\u0012\u0013\u0012\u00110\r¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(`\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(a\u0012\u0015\u0012\u0013\u0018\u00010s¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(t\u0012\u0004\u0012\u00020\u001b\u0018\u00010[H\u0016JV\u0010u\u001a\u00020\u001b2\b\u0010k\u001a\u0004\u0018\u00010\u00062\u0006\u0010\"\u001a\u00020\r2:\u0010(\u001a6\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(^\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(v\u0012\u0004\u0012\u00020\u001b\u0018\u00010mH\u0016J\\\u0010w\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000628\u0010(\u001a4\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(^\u0012\u0013\u0012\u00110\r¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(_\u0012\u0004\u0012\u00020\u001b\u0018\u00010mH\u0016Jx\u0010x\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\r2f\u0010(\u001ab\u0012\u0013\u0012\u00110\r¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(_\u0012\u0013\u0012\u00110\r¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(`\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(a\u0012\u0015\u0012\u0013\u0018\u00010z¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(c\u0012\u0004\u0012\u00020\u001b\u0018\u00010yH\u0016J\u0012\u0010{\u001a\u00020\u001b2\b\u0010(\u001a\u0004\u0018\u00010|H\u0016JH\u0010}\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010~\u001a\u0004\u0018\u000102$\u0010(\u001a \u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(^\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0001H\u0016Jp\u0010\u0001\u001a\u00020\u001b2e\u0010(\u001aa\u0012\u0013\u0012\u00110\r¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(`\u0012\u0013\u0012\u00110\r¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(_\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(a\u0012\u0014\u0012\u00120\u0001¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(c\u0012\u0004\u0012\u00020\u001b\u0018\u00010yH\u0016J¼\u0001\u0010\u0001\u001a\u00020\u001b2\u0007\u0010\u0001\u001a\u00020\r2§\u0001\u0010(\u001a¢\u0001\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(^\u0012\u0013\u0012\u00110\r¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(_\u0012\u0013\u0012\u00110\r¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(`\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(a\u0012\u0015\u0012\u00130\u0001¢\u0006\r\b\\\u0012\t\b]\u0012\u0005\b\b(\u0001\u0012\u0015\u0012\u00130\u0001¢\u0006\r\b\\\u0012\t\b]\u0012\u0005\b\b(\u0001\u0012\u0014\u0012\u00120\u0001¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(c\u0012\u0004\u0012\u00020\u001b\u0018\u00010fH\u0016J\u001a\u0010\u0001\u001a\u00020\u001b2\u0007\u0010\u0001\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\rH\u0016J\u0001\u0010\u0001\u001a\u00020\u001b2z\u0010(\u001av\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(^\u0012\u0013\u0012\u00110\r¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(_\u0012\u0013\u0012\u00110\r¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(`\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(a\u0012\u0016\u0012\u0014\u0018\u00010\u0001¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(c\u0012\u0004\u0012\u00020\u001b\u0018\u00010[H\u0016J\u0001\u0010\u0001\u001a\u00020\u001b2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\u00152g\u0010(\u001ac\u0012\u0013\u0012\u00110\r¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(_\u0012\u0013\u0012\u00110\r¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(`\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(a\u0012\u0016\u0012\u0014\u0018\u00010\u0001¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(c\u0012\u0004\u0012\u00020\u001b\u0018\u00010yH\u0016J&\u0010\u0001\u001a\u00020\u001b2\u0007\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\r2\t\u0010(\u001a\u0005\u0018\u00010\u0001H\u0016J]\u0010\u0001\u001a\u00020\u001b2\u0006\u0010U\u001a\u00020V2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u0001\u001a\u00020\r2\u0007\u0010\u0001\u001a\u00020\r2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u0001\u001a\u00020\u00062\t\u0010(\u001a\u0005\u0018\u00010\u0001H\u0016J&\u0010\u0001\u001a\u00020\u001b2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u0001\u001a\u00020\u001d2\u0007\u0010\u0001\u001a\u00020\u001dH\u0016J\t\u0010 \u0001\u001a\u00020\u001bH\u0016J:\u0010¡\u0001\u001a\u00020\u001b2\u0006\u0010U\u001a\u00020V2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010k\u001a\u00020\u00062\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\"\u001a\u00020\rH\u0016¢\u0006\u0003\u0010£\u0001J0\u0010¤\u0001\u001a\u00030\u00012\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010\u00062\b\u0010'\u001a\u0004\u0018\u00010\u0006H\u0002J0\u0010¥\u0001\u001a\u00030\u00012\b\u0010#\u001a\u0004\u0018\u00010$2\b\u00104\u001a\u0004\u0018\u00010\u00062\u0006\u0010+\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010\u0006H\u0002J\u001c\u0010¦\u0001\u001a\u00030\u00012\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\rH\u0002J&\u0010§\u0001\u001a\u00030\u00012\b\u0010#\u001a\u0004\u0018\u00010$2\b\u00104\u001a\u0004\u0018\u00010\u00062\u0006\u0010+\u001a\u00020\rH\u0002J(\u0010¨\u0001\u001a\u00030\u00012\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010&\u001a\u0004\u0018\u00010\u00062\b\u0010'\u001a\u0004\u0018\u00010\u0006H\u0002J0\u0010©\u0001\u001a\u00030\u00012\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010&\u001a\u0004\u0018\u00010\u00062\b\u0010'\u001a\u0004\u0018\u00010\u00062\u0006\u0010\"\u001a\u00020\rH\u0002J(\u0010ª\u0001\u001a\u00020\u001b2\u0007\u0010«\u0001\u001a\u00020\u00062\t\u0010¬\u0001\u001a\u0004\u0018\u000102\t\u0010(\u001a\u0005\u0018\u00010­\u0001H\u0016JO\u0010®\u0001\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0007\u0010¯\u0001\u001a\u00020\u00062\t\u0010°\u0001\u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\r2\r\u0010±\u0001\u001a\b\u0012\u0004\u0012\u00020\u0006082\t\u0010(\u001a\u0005\u0018\u00010²\u0001H\u0016J\u0013\u0010³\u0001\u001a\u00020\u001b2\b\u0010´\u0001\u001a\u00030µ\u0001H\u0016J0\u0010¶\u0001\u001a\u00020\u001b2%\u0010(\u001a!\u0012\u0014\u0012\u00120\u001d¢\u0006\r\b\\\u0012\t\b]\u0012\u0005\b\b(\u0001\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0001H\u0016J\t\u0010·\u0001\u001a\u00020\u001dH\u0016J\u0011\u0010¸\u0001\u001a\u00020\u001b2\u0006\u0010U\u001a\u00020LH\u0016JN\u0010¹\u0001\u001a\u00020\u001b2\u0006\u0010U\u001a\u00020L2\b\u0010º\u0001\u001a\u00030»\u00012\n\u0010¼\u0001\u001a\u0005\u0018\u00010½\u00012%\u0010¾\u0001\u001a \u0012\u0013\u0012\u00110\r¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(_\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0001H\u0016J&\u0010¿\u0001\u001a\u00020\u001b2\u0007\u0010À\u0001\u001a\u00020\u00102\u0006\u0010o\u001a\u00020\u00062\n\u0010Á\u0001\u001a\u0005\u0018\u00010Â\u0001H\u0016J+\u0010Ã\u0001\u001a\u00020\u001b2\u0006\u0010U\u001a\u00020V2\u0007\u0010Ä\u0001\u001a\u00020G2\t\u0010Å\u0001\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0003\u0010Æ\u0001JH\u0010Ç\u0001\u001a\u00020\u001b2\u0006\u0010U\u001a\u00020V2\u0018\u0010È\u0001\u001a\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00012\u001b\u0010É\u0001\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001b\u0018\u00010mH\u0016J\t\u0010Ê\u0001\u001a\u00020\u0010H\u0016J\t\u0010Ë\u0001\u001a\u00020\u001bH\u0016J9\u0010Ì\u0001\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\t\u0010¯\u0001\u001a\u0004\u0018\u00010\u00062\b\u0010 \u001a\u0004\u0018\u00010!2\t\u0010Í\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J*\u0010Î\u0001\u001a\u00020\u001b2\n\u0010Ï\u0001\u001a\u0005\u0018\u00010Ð\u00012\n\u0010Ñ\u0001\u001a\u0005\u0018\u00010Ò\u00012\u0007\u0010Ó\u0001\u001a\u00020\u0006H\u0016J$\u0010Ô\u0001\u001a\u00020\u001b2\u0006\u0010U\u001a\u00020V2\b\u0010Õ\u0001\u001a\u00030Ö\u00012\u0007\u0010×\u0001\u001a\u00020\u0010H\u0016J\u001b\u0010Ø\u0001\u001a\u00020\u001b2\u0006\u0010U\u001a\u00020V2\b\u0010Õ\u0001\u001a\u00030Ö\u0001H\u0016J&\u0010Ù\u0001\u001a\u00020\u001b2\u0006\u0010U\u001a\u00020V2\b\u0010Õ\u0001\u001a\u00030Ö\u00012\t\b\u0002\u0010×\u0001\u001a\u00020\u0010H\u0002J\u0012\u0010Ú\u0001\u001a\u00020\u001b2\u0007\u0010Û\u0001\u001a\u00020iH\u0002JÆ\u0001\u0010Ü\u0001\u001a\u00020\u001b2\b\u0010Û\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\r2§\u0001\u0010(\u001a¢\u0001\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(^\u0012\u0013\u0012\u00110\r¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(_\u0012\u0013\u0012\u00110\r¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(`\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(a\u0012\u0015\u0012\u00130\u0001¢\u0006\r\b\\\u0012\t\b]\u0012\u0005\b\b(\u0001\u0012\u0015\u0012\u00130\u0001¢\u0006\r\b\\\u0012\t\b]\u0012\u0005\b\b(\u0001\u0012\u0014\u0012\u00120\u0001¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(c\u0012\u0004\u0012\u00020\u001b\u0018\u00010fH\u0002JB\u0010Ý\u0001\u001a\u00020\u001b2\u0006\u0010]\u001a\u00020\u00062\b\u0010Þ\u0001\u001a\u00030ß\u00012\b\u0010à\u0001\u001a\u00030á\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\rH\u0002J)\u0010â\u0001\u001a\u00020\u001b2\b\u0010ã\u0001\u001a\u00030ä\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010å\u0001\u001a\u00020\u001b2\b\u0010Û\u0001\u001a\u00030\u0001H\u0002JQ\u0010æ\u0001\u001a\u00020\u001b2\b\u0010k\u001a\u0004\u0018\u00010\u00062<\u0010(\u001a8\u0012\u0015\u0012\u00130ç\u0001¢\u0006\r\b\\\u0012\t\b]\u0012\u0005\b\b(è\u0001\u0012\u0015\u0012\u00130é\u0001¢\u0006\r\b\\\u0012\t\b]\u0012\u0005\b\b(ê\u0001\u0012\u0004\u0012\u00020\u001b\u0018\u00010mH\u0016JJ\u0010ë\u0001\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00062\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\r2\b\u00104\u001a\u0004\u0018\u00010\u00062\t\u0010(\u001a\u0005\u0018\u00010ì\u0001H\u0016J\t\u0010í\u0001\u001a\u00020\u001bH\u0016J-\u0010î\u0001\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0007\u0010ï\u0001\u001a\u00020\r2\t\u0010(\u001a\u0005\u0018\u00010ð\u0001H\u0016J,\u0010ñ\u0001\u001a\u0005\u0018\u00010ò\u00012\u0007\u0010U\u001a\u00030ó\u00012\u0006\u0010\"\u001a\u00020\r2\r\u0010(\u001a\t\u0012\u0004\u0012\u00020\u001b0ô\u0001H\u0016J\u0014\u0010õ\u0001\u001a\u0005\u0018\u00010ö\u00012\u0006\u0010U\u001a\u00020LH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR6\u0010\t\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\nj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b`\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006÷\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveAssistant;", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "pluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "(Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cacheViewVisibilityList", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Landroid/view/View;", "", "Lkotlin/collections/ArrayList;", "isFestivalLive", "", "()Z", "setFestivalLive", "(Z)V", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "getPluginLayout", "()Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "rotationHelper", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRotationHelper;", "acceptLinkMic", "", "liveId", "", "objectId", "objectNonceId", "liveCookie", "", "scene", "toContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "micType", "userId", "sessionId", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMic$CallBack;", "acceptLinkMicPk", "sdkLiveId", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMicPk$CallBack;", "activateLiveMic", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderActivateLiveMic$CallBack;", "announceGotoShopping", "productId", "applyLinkMic", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMic$CallBack;", "applyLinkMicPk", "sdkUserId", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMicPk$CallBack;", "autoTransMmitLive", "toUser", "", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "batchGetMicContact", "usernameList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMicContact$CallBack;", "cacheViewVisibility", "view", "visibility", "changeScreenOrientation", "changeScreenToLandscape", "changeScreenToPortrait", "checkVisitorRoleType", "data", "Landroid/content/Intent;", "plugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "chooseVisitorRoleImpl", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "fromUserGuide", "closeLinkMic", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic$CallBack;", "closeLinkMicPk", "closeScene", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMicPk$CallBack;", "closeMiniProgram", "consumeGift", "context", "Landroid/content/Context;", "sessionID", "consumeWeCoin", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "doCloseLive", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "success", "errCode", "errType", "errMsg", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;", "resp", "doCloseVisitorLive", "doCreateLive", "Lkotlin/Function7;", "needFaceVerify", "verifyUrl", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveResp;", "doDisableComment", ch.COL_USERNAME, "enable", "Lkotlin/Function2;", "doFetchFinderContact", "finderUsername", "doFinishLive", "manualFinish", "isSecondDaryDevice", "Lcom/tencent/mm/plugin/finder/live/viewmodel/AnchorFinishInfo;", "info", "doGetFinderLiveContact", "contact", "doGetGiftList", "doGetMemberList", "Lkotlin/Function4;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveOnlineMemberResp;", "doGetMicCandidateList", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCandidate$CallBack;", "doGetProductList", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "Lkotlin/Function1;", "doHighLightLikeLive", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveAppMsgResponse;", "doJoinLive", "role", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "liveRoomInfo", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "trtcParams", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "doLikeLive", "count", "doManualCloseLive", "Lcom/tencent/mm/protocal/protobuf/FinderManualCloseLiveResp;", "doPostAppMsg", "appMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "doPostComment", "commentContent", "liveMsgType", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost$CallBack;", "doPostGift", "rewardGiftId", "rewardGiftCnt", "wecoin", "comboId", "sendGiftTargetUserName", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback;", "doPrepareLive", "micFinderUsername", "micFinderObjectId", "micLiveId", "enableAutoRotation", "expose", "commentSeq", "(Landroid/content/Context;JLjava/lang/String;Ljava/lang/Long;I)V", "genAcceptLinkMicMsg", "genAcceptLinkMicPkMsg", "genApplyLinkMicMsg", "genApplyLinkMicPkMsg", "genCloseLinkMicMsg", "genCloseLinkMicPkMsg", "getLotteryRecord", "lotteryId", "lastBuff", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "getLuckyMoneyInfo", "nonceId", "liveCookies", "sendIdList", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLuckyMoneyInfo$CallBack;", "getProductDetail", "product", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowProductItem;", "getWeCoinBalance", "getWeCoinBalanceFromCache", "goPrepareLuckyMoney", "goReceiveLuckyMoney", "luckyMoneySendInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRedPacketInfo;", "resultReceiver", "Landroid/os/ResultReceiver;", "actionCallback", "goToFinderProfileImpl", "isAnchor", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "gotoWebViewWithoutMiniWindow", "intent", "requestCode", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Integer;)V", "initEngine", "sucCallback", "failCallback", "isWeCoinEntranceAvailable", "lockScreenRotation", "luckyMoneyRewardNotify", "sendId", "onPostGoToFinderProfileResult", "extraMsg", "Landroid/os/Bundle;", "extraData", "", "keyUsername", "openFullScreenMiniProgram", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "luanchFromApp", "openHalfScreenMiniProgram", "openMiniProgram", "processCreateLiveResponse", "response", "processJoinLiveResponse", "processLiveCgiSDKResponse", "liveSdkInfo", "Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "processLiveSdkParams", "liveSdkParam", "Lcom/tencent/mm/protocal/protobuf/LiveSdkParams;", "processVisitorRoleResponse", "putInBlackList", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "req", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "ret", "refreshLinkMic", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshMic$CallBack;", "resumeViewVisibility", "setAnchorStatus", "flag", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveAnchorStatus$CallBack;", "showRechargeFoodsDialog", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinRechargeDialog;", "Landroid/support/v4/app/FragmentActivity;", "Lkotlin/Function0;", "showWeCoinEntranceTutorialDialog", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinEntranceTutorialDialog;", "plugin-finder_release"})
public final class b implements s {
    final String TAG = "Finder.FinderLiveAssistant";
    public boolean UKk;
    com.tencent.mm.plugin.finder.live.viewmodel.g liveData = this.uhN.getLiveData();
    ArrayList<kotlin.o<View, Integer>> uhL = new ArrayList<>();
    private l uhM;
    final FinderBaseLivePluginLayout uhN;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "success", "", "errCode", "", "errType", "errMsg", "", "errresp", "Lcom/tencent/mm/protocal/protobuf/FinderManualCloseLiveResp;", "invoke"})
    static final class g extends kotlin.g.b.q implements kotlin.g.a.s<Boolean, Integer, Integer, String, ayd, kotlin.x> {
        final /* synthetic */ b uhO;
        final /* synthetic */ kotlin.g.a.s uhQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(b bVar, kotlin.g.a.s sVar) {
            super(5);
            this.uhO = bVar;
            this.uhQ = sVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.s
        public final /* synthetic */ kotlin.x a(Boolean bool, Integer num, Integer num2, String str, ayd ayd) {
            int i2;
            int i3;
            int i4;
            int i5;
            long j2;
            AppMethodBeat.i(246004);
            boolean booleanValue = bool.booleanValue();
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            String str2 = str;
            ayd ayd2 = ayd;
            kotlin.g.b.p.h(str2, "errMsg");
            kotlin.g.a.s sVar = this.uhQ;
            if (sVar != null) {
                Boolean valueOf = Boolean.valueOf(booleanValue);
                Integer valueOf2 = Integer.valueOf(intValue);
                Integer valueOf3 = Integer.valueOf(intValue2);
                if (ayd2 != null) {
                    i2 = ayd2.LIo;
                } else {
                    i2 = 0;
                }
                if (ayd2 != null) {
                    i3 = ayd2.LIp;
                } else {
                    i3 = 0;
                }
                if (ayd2 != null) {
                    i4 = ayd2.LIq;
                } else {
                    i4 = 0;
                }
                if (ayd2 != null) {
                    i5 = ayd2.LIr;
                } else {
                    i5 = 0;
                }
                com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                Long a2 = com.tencent.mm.plugin.finder.utils.m.a(this.uhO.liveData.liveInfo);
                if (a2 != null) {
                    j2 = a2.longValue();
                } else {
                    j2 = 0;
                }
                sVar.a(valueOf, valueOf2, valueOf3, str2, new com.tencent.mm.plugin.finder.live.viewmodel.a(i2, i3, i4, i5, j2));
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(246004);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "success", "", "errCode", "", "errType", "errMsg", "", "errresp", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;", "invoke"})
    static final class h extends kotlin.g.b.q implements kotlin.g.a.s<Boolean, Integer, Integer, String, ape, kotlin.x> {
        final /* synthetic */ kotlin.g.a.s uhQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(kotlin.g.a.s sVar) {
            super(5);
            this.uhQ = sVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.s
        public final /* synthetic */ kotlin.x a(Boolean bool, Integer num, Integer num2, String str, ape ape) {
            int i2;
            int i3;
            int i4;
            int i5;
            AppMethodBeat.i(246005);
            boolean booleanValue = bool.booleanValue();
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            String str2 = str;
            ape ape2 = ape;
            kotlin.g.b.p.h(str2, "errMsg");
            kotlin.g.a.s sVar = this.uhQ;
            if (sVar != null) {
                Boolean valueOf = Boolean.valueOf(booleanValue);
                Integer valueOf2 = Integer.valueOf(intValue);
                Integer valueOf3 = Integer.valueOf(intValue2);
                if (ape2 != null) {
                    i2 = ape2.LBk;
                } else {
                    i2 = 0;
                }
                if (ape2 != null) {
                    i3 = ape2.LBl;
                } else {
                    i3 = 0;
                }
                if (ape2 != null) {
                    i4 = ape2.LBm;
                } else {
                    i4 = 0;
                }
                if (ape2 != null) {
                    i5 = ape2.LBn;
                } else {
                    i5 = 0;
                }
                sVar.a(valueOf, valueOf2, valueOf3, str2, new com.tencent.mm.plugin.finder.live.viewmodel.a(i2, i3, i4, i5, 16));
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(246005);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveAppMsgResponse;", "invoke"})
    static final class m extends kotlin.g.b.q implements kotlin.g.a.r<Integer, Integer, String, ban, kotlin.x> {
        final /* synthetic */ kotlin.g.a.r nyK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(kotlin.g.a.r rVar) {
            super(4);
            this.nyK = rVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ kotlin.x invoke(Integer num, Integer num2, String str, ban ban) {
            AppMethodBeat.i(246010);
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            String str2 = str;
            ban ban2 = ban;
            kotlin.g.b.p.h(ban2, "resp");
            kotlin.g.a.r rVar = this.nyK;
            if (rVar != null) {
                rVar.invoke(Integer.valueOf(intValue), Integer.valueOf(intValue2), str2, ban2);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(246010);
            return xVar;
        }
    }

    public b(FinderBaseLivePluginLayout finderBaseLivePluginLayout) {
        kotlin.g.b.p.h(finderBaseLivePluginLayout, "pluginLayout");
        AppMethodBeat.i(246073);
        this.uhN = finderBaseLivePluginLayout;
        Context context = this.uhN.getContext();
        if (context == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.MMFinderUI");
            AppMethodBeat.o(246073);
            throw tVar;
        }
        this.uhM = new l((MMFinderUI) context);
        AppMethodBeat.o(246073);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doJoinLive$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderJoinLive$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "plugin-finder_release"})
    public static final class n implements i.a {
        final /* synthetic */ b uhO;
        final /* synthetic */ kotlin.g.a.u uhR;
        final /* synthetic */ int uhU;

        n(b bVar, kotlin.g.a.u uVar, int i2) {
            this.uhO = bVar;
            this.uhR = uVar;
            this.uhU = i2;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.i.a
        public final void a(int i2, int i3, String str, auf auf) {
            AppMethodBeat.i(246012);
            kotlin.g.b.p.h(auf, "resp");
            com.tencent.mm.ac.d.h(new a(this, auf, i3, i2, str));
            AppMethodBeat.o(246012);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ int $errCode;
            final /* synthetic */ String $errMsg;
            final /* synthetic */ int $errType;
            final /* synthetic */ n uhV;
            final /* synthetic */ auf uhW;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(n nVar, auf auf, int i2, int i3, String str) {
                super(0);
                this.uhV = nVar;
                this.uhW = auf;
                this.$errCode = i2;
                this.$errType = i3;
                this.$errMsg = str;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                Long l;
                awe awe;
                awe awe2;
                boolean z;
                awe awe3;
                byte[] bArr;
                com.tencent.mm.plugin.finder.live.view.a.c cVar;
                Integer num;
                int i2;
                int aCe;
                com.tencent.mm.plugin.finder.live.view.a.c cVar2;
                awe awe4;
                AppMethodBeat.i(246011);
                auf auf = this.uhW;
                if (!(auf == null || (awe2 = auf.liveInfo) == null)) {
                    long j2 = awe2.liveId;
                    com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.uhV.uhO.liveData;
                    if (j2 == ((gVar == null || (awe4 = gVar.liveInfo) == null) ? null : Long.valueOf(awe4.liveId)).longValue()) {
                        if (this.$errType == 0 && this.$errCode == 0) {
                            this.uhV.uhO.liveData.uFc = this.uhW.LEZ;
                            auf auf2 = this.uhW;
                            if (auf2 != null) {
                                awe3 = auf2.liveInfo;
                            } else {
                                awe3 = null;
                            }
                            if (awe3 == null || this.uhV.uhO.liveData == null) {
                                kotlin.g.a.u uVar = this.uhV.uhR;
                                if (uVar != null) {
                                    Boolean bool = Boolean.FALSE;
                                    Integer valueOf = Integer.valueOf(this.$errCode);
                                    Integer valueOf2 = Integer.valueOf(this.$errType);
                                    String str = this.$errMsg;
                                    if (str == null) {
                                        str = "";
                                    }
                                    f.a aVar = com.tencent.mm.live.core.core.b.f.hzy;
                                    com.tencent.mm.live.core.core.b.e eVar = com.tencent.mm.live.core.core.b.f.hzx;
                                    f.a aVar2 = com.tencent.mm.live.core.core.b.f.hzy;
                                    uVar.invoke(bool, valueOf, valueOf2, str, eVar, com.tencent.mm.live.core.core.b.f.hzw, this.uhW);
                                }
                            } else {
                                b bVar = this.uhV.uhO;
                                auf auf3 = this.uhW;
                                int i3 = this.uhV.uhU;
                                kotlin.g.a.u uVar2 = this.uhV.uhR;
                                bVar.liveData.djg();
                                a aVar3 = a.uhJ;
                                a.a(bVar.liveData, auf3.LDJ, true);
                                cjb cjb = auf3.hIv;
                                if (cjb != null) {
                                    com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = bVar.liveData;
                                    kotlin.g.b.p.g(cjb, LocaleUtil.ITALIAN);
                                    gVar2.a(cjb);
                                    com.tencent.mm.plugin.finder.live.viewmodel.g gVar3 = bVar.liveData;
                                    awe awe5 = auf3.liveInfo;
                                    if (awe5 == null) {
                                        awe5 = new awe();
                                    }
                                    gVar3.setLiveInfo(awe5);
                                    if (bVar.liveData.liveInfo.dvv <= 0) {
                                        bVar.liveData.liveInfo.dvv = cl.aWB();
                                    }
                                    com.tencent.mm.plugin.finder.live.viewmodel.g gVar4 = bVar.liveData;
                                    com.tencent.mm.bw.b bVar2 = auf3.LDx;
                                    if (bVar2 != null) {
                                        bArr = bVar2.zy;
                                    } else {
                                        bArr = null;
                                    }
                                    gVar4.hIt = bArr;
                                    com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                                    com.tencent.mm.plugin.finder.utils.m.hd(bVar.TAG, "joinlive write liveCookies to:" + Util.encodeHexString(bVar.liveData.hIt));
                                    fhq fhq = auf3.ViL;
                                    if (fhq != null) {
                                        com.tencent.mm.plugin.finder.live.view.a.a aVar4 = com.tencent.mm.plugin.finder.live.view.a.a.UPD;
                                        cVar = com.tencent.mm.plugin.finder.live.view.a.a.a(fhq);
                                    } else {
                                        cVar = null;
                                    }
                                    if (cVar == null) {
                                        axg axg = auf3.uEm;
                                        if (axg != null) {
                                            com.tencent.mm.plugin.finder.live.view.a.a aVar5 = com.tencent.mm.plugin.finder.live.view.a.a.UPD;
                                            cVar2 = com.tencent.mm.plugin.finder.live.view.a.a.b(axg);
                                        } else {
                                            cVar2 = null;
                                        }
                                        cVar = cVar2;
                                    }
                                    bVar.liveData.f(cVar);
                                    com.tencent.mm.plugin.finder.live.viewmodel.g gVar5 = bVar.liveData;
                                    axo axo = auf3.LET;
                                    if (axo != null) {
                                        num = Integer.valueOf(axo.hFI);
                                    } else {
                                        num = null;
                                    }
                                    Log.i(gVar5.TAG, "join live enableComment:".concat(String.valueOf(num)));
                                    if (num != null) {
                                        num.intValue();
                                        if (num.intValue() == 1) {
                                            gVar5.uDC = true;
                                        } else if (num.intValue() == 0) {
                                            gVar5.uDC = false;
                                        }
                                    }
                                    bVar.liveData.uDy = auf3.LEU;
                                    bVar.liveData.uDV = bVar.liveData.liveInfo.LCy;
                                    bVar.liveData.location = auf3.location;
                                    if (cVar instanceof com.tencent.mm.plugin.finder.live.view.a.c) {
                                        bVar.a(((com.tencent.mm.plugin.finder.live.view.a.c) cVar).UPJ);
                                    }
                                    TRTCCloudDef.TRTCParams tRTCParams = new TRTCCloudDef.TRTCParams();
                                    long j3 = bVar.liveData.liveInfo.liveId;
                                    e.f fVar = e.f.hxS;
                                    com.tencent.mm.live.core.core.b.e eVar2 = new com.tencent.mm.live.core.core.b.e("", j3, 0, null, 0, 0, e.f.aCP(), null, null, 0, 8124);
                                    awe awe6 = bVar.liveData.liveInfo;
                                    cjb cjb2 = bVar.liveData.hIv;
                                    tRTCParams.roomId = cjb2.Mok;
                                    tRTCParams.sdkAppId = cjb2.Moj;
                                    tRTCParams.privateMapKey = z.a(cjb2.Mon);
                                    tRTCParams.userId = cjb2.MnL;
                                    tRTCParams.userSig = z.a(cjb2.Mom);
                                    switch (i3) {
                                        case 1:
                                            i2 = 20;
                                            break;
                                        case 2:
                                            i2 = 21;
                                            break;
                                        default:
                                            i2 = 20;
                                            break;
                                    }
                                    tRTCParams.role = i2;
                                    eVar2.Gn("");
                                    eVar2.liveId = awe6.liveId;
                                    String str2 = cjb2.Mos;
                                    kotlin.g.b.p.g(str2, "liveSdkInfo.live_cdn_url");
                                    eVar2.hzs.put(0, str2);
                                    eVar2.hzm = cjb2.Mop;
                                    cjc cjc = new cjc();
                                    com.tencent.mm.bw.b bVar3 = cjb2.Moo;
                                    kotlin.g.b.p.g(bVar3, "liveSdkInfo.sdk_params");
                                    com.tencent.mm.bw.a parseFrom = cjc.parseFrom(bVar3.zy);
                                    if (parseFrom == null) {
                                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LiveSdkParams");
                                        AppMethodBeat.o(246011);
                                        throw tVar;
                                    }
                                    cjc cjc2 = (cjc) parseFrom;
                                    com.tencent.mm.plugin.finder.utils.m mVar2 = com.tencent.mm.plugin.finder.utils.m.vVH;
                                    if (com.tencent.mm.plugin.finder.utils.m.i(bVar.liveData)) {
                                        axe axe = awe6.LGT;
                                        if (axe != null) {
                                            aCe = axe.hzl;
                                        } else {
                                            e.a aVar6 = e.a.hxc;
                                            aCe = e.a.aCe();
                                        }
                                        eVar2.hzl = aCe;
                                    } else {
                                        eVar2.hzl = cjc2.Mov.MnW;
                                    }
                                    com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
                                    int intValue = com.tencent.mm.plugin.finder.storage.c.dwi().value().intValue();
                                    if (!((!BuildInfo.DEBUG && !BuildInfo.IS_FLAVOR_PURPLE && !BuildInfo.IS_FLAVOR_RED && !CrashReportFactory.hasDebuger()) || intValue == -1 || i3 == 1)) {
                                        eVar2.hzl = intValue;
                                    }
                                    eVar2.appId = cjc2.Mov.MnY;
                                    eVar2.hzn = cjc2.Mov.MnZ;
                                    eVar2.uEz = cjc2.Mov.VjO;
                                    bVar.a(cjc2, tRTCParams, eVar2);
                                    Log.i(bVar.TAG, "processLiveCgiSDKResponse trtcParams.roomId" + tRTCParams.roomId + " trtcParams.userId:" + tRTCParams.userId + " debugAudienceMode:" + intValue + " liveRoomInfo:" + eVar2);
                                    long aM = kotlin.k.j.aM((bVar.liveData.hIv.Mor - 60) * 1000, Util.MILLSECONDS_OF_MINUTE);
                                    o oVar = o.ujN;
                                    o.EJ(aM);
                                    if (uVar2 != null) {
                                        uVar2.invoke(Boolean.TRUE, 0, 0, "", eVar2, tRTCParams, auf3);
                                    }
                                    String str3 = bVar.TAG;
                                    StringBuilder append = new StringBuilder("processJoinLiveResponse live_id:").append(bVar.liveData.liveInfo.liveId).append(",appId:").append(tRTCParams.sdkAppId).append(",roomId:").append(tRTCParams.roomId).append(",userId:").append(tRTCParams.userId).append(", micUser:$");
                                    awn awn = auf3.LES;
                                    Log.i(str3, append.append(awn != null ? awn.LHo : null).toString());
                                }
                                com.tencent.mm.plugin.finder.live.viewmodel.g gVar6 = bVar.liveData;
                                avn avn = auf3.LDQ;
                                gVar6.a(avn != null ? avn.LDK : null);
                                bVar.liveData.nD(com.tencent.mm.ac.d.cW(auf3.LEX, 1));
                                com.tencent.mm.plugin.finder.utils.m mVar3 = com.tencent.mm.plugin.finder.utils.m.vVH;
                                if (!com.tencent.mm.plugin.finder.utils.m.dBP()) {
                                    com.tencent.mm.plugin.finder.live.viewmodel.g gVar7 = bVar.liveData;
                                    LinkedList<aus> linkedList = auf3.LEV;
                                    kotlin.g.b.p.g(linkedList, "response.alias_info");
                                    kotlin.g.b.p.h(linkedList, "<set-?>");
                                    gVar7.UQj = linkedList;
                                    bVar.liveData.UQi = auf3.LEW;
                                    bVar.liveData.UQk = auf3.LEY;
                                    if (bVar.liveData.UQh.LFy != 4 || bVar.liveData.UQj.isEmpty()) {
                                        String str4 = bVar.TAG;
                                        StringBuilder sb = new StringBuilder("processVisitorRoleResponse ");
                                        com.tencent.mm.plugin.finder.utils.m mVar4 = com.tencent.mm.plugin.finder.utils.m.vVH;
                                        Log.i(str4, sb.append(com.tencent.mm.plugin.finder.utils.m.a("joinLive", bVar.liveData.UQj, bVar.liveData.UQi, bVar.liveData.UQk)).toString());
                                    } else {
                                        bVar.liveData.hUd();
                                        com.tencent.mm.plugin.finder.utils.m mVar5 = com.tencent.mm.plugin.finder.utils.m.vVH;
                                        com.tencent.mm.plugin.finder.utils.m.a(bVar.liveData.UQj, bVar.liveData.UQi, bVar.liveData.UQk);
                                    }
                                }
                            }
                        } else {
                            Log.i(this.uhV.uhO.TAG, "launch live room failed");
                            kotlin.g.a.u uVar3 = this.uhV.uhR;
                            if (uVar3 != null) {
                                Boolean bool2 = Boolean.FALSE;
                                Integer valueOf3 = Integer.valueOf(this.$errCode);
                                Integer valueOf4 = Integer.valueOf(this.$errType);
                                String str5 = this.$errMsg;
                                if (str5 == null) {
                                    str5 = "";
                                }
                                f.a aVar7 = com.tencent.mm.live.core.core.b.f.hzy;
                                com.tencent.mm.live.core.core.b.e eVar3 = com.tencent.mm.live.core.core.b.f.hzx;
                                f.a aVar8 = com.tencent.mm.live.core.core.b.f.hzy;
                                uVar3.invoke(bool2, valueOf3, valueOf4, str5, eVar3, com.tencent.mm.live.core.core.b.f.hzw, this.uhW);
                            }
                        }
                        awe awe7 = this.uhW.liveInfo;
                        if (awe7 != null) {
                            int i4 = awe7.LGU;
                            if (!this.uhV.uhO.liveData.uEd) {
                                com.tencent.mm.plugin.finder.live.viewmodel.g gVar8 = this.uhV.uhO.liveData;
                                if ((i4 & 1) > 0 || (i4 & 2) > 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                gVar8.uEd = z;
                            }
                            if (!this.uhV.uhO.UKk && (i4 & 4) > 0) {
                                com.tencent.mm.ac.d.h(new C1183a(this));
                            }
                        }
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(246011);
                        return xVar;
                    }
                }
                String str6 = this.uhV.uhO.TAG;
                StringBuilder sb2 = new StringBuilder("invalid live resp,liveId:");
                auf auf4 = this.uhW;
                if (auf4 == null || (awe = auf4.liveInfo) == null) {
                    l = null;
                } else {
                    l = Long.valueOf(awe.liveId);
                }
                StringBuilder append2 = sb2.append(l).append(",current liveId:");
                awe awe8 = this.uhV.uhO.liveData.liveInfo;
                Log.i(str6, append2.append((awe8 != null ? Long.valueOf(awe8.liveId) : null).longValue()).toString());
                kotlin.g.a.u uVar4 = this.uhV.uhR;
                if (uVar4 != null) {
                    Boolean bool3 = Boolean.FALSE;
                    Integer valueOf5 = Integer.valueOf(this.$errCode);
                    Integer valueOf6 = Integer.valueOf(this.$errType);
                    String str7 = this.$errMsg;
                    if (str7 == null) {
                        str7 = "";
                    }
                    f.a aVar9 = com.tencent.mm.live.core.core.b.f.hzy;
                    com.tencent.mm.live.core.core.b.e eVar4 = com.tencent.mm.live.core.core.b.f.hzx;
                    f.a aVar10 = com.tencent.mm.live.core.core.b.f.hzy;
                    uVar4.invoke(bool3, valueOf5, valueOf6, str7, eVar4, com.tencent.mm.live.core.core.b.f.hzw, this.uhW);
                }
                kotlin.x xVar2 = kotlin.x.SXb;
                AppMethodBeat.o(246011);
                return xVar2;
            }

            @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doJoinLive$1$onCgiBack$1$1$1"})
            /* renamed from: com.tencent.mm.plugin.finder.live.model.b$n$a$a  reason: collision with other inner class name */
            static final class C1183a extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
                final /* synthetic */ a UKl;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C1183a(a aVar) {
                    super(0);
                    this.UKl = aVar;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ kotlin.x invoke() {
                    int i2;
                    com.tencent.mm.plugin.finder.live.viewmodel.f fVar;
                    AppMethodBeat.i(260430);
                    com.tencent.mm.plugin.festival.a.a aVar = (com.tencent.mm.plugin.festival.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.festival.a.a.class);
                    Context context = this.UKl.uhV.uhO.uhN.getContext();
                    o oVar = o.ujN;
                    com.tencent.mm.plugin.finder.live.viewmodel.d dfY = o.dfY();
                    if (dfY == null || (fVar = dfY.ufx) == null) {
                        i2 = 0;
                    } else {
                        i2 = fVar.tCE;
                    }
                    aVar.ba(context, i2 + 100);
                    Context context2 = this.UKl.uhV.uhO.uhN.getContext();
                    if (context2 == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                        AppMethodBeat.o(260430);
                        throw tVar;
                    }
                    ((Activity) context2).finish();
                    kotlin.x xVar = kotlin.x.SXb;
                    AppMethodBeat.o(260430);
                    return xVar;
                }
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void a(int i2, kotlin.g.a.u<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super com.tencent.mm.live.core.core.b.e, ? super TRTCCloudDef.TRTCParams, ? super auf, kotlin.x> uVar) {
        AppMethodBeat.i(246030);
        new com.tencent.mm.plugin.finder.live.model.cgi.i(this.liveData.liveInfo.liveId, this.liveData.hIt, com.tencent.mm.model.z.aUg(), this.liveData.hFK, i2, this.liveData.hwg, this.liveData.sessionBuffer, new n(this, uVar, i2)).aYI();
        AppMethodBeat.o(246030);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void a(kotlin.g.a.u<? super Boolean, ? super Boolean, ? super String, ? super Integer, ? super Integer, ? super String, ? super aqd, kotlin.x> uVar) {
        AppMethodBeat.i(246031);
        LinkedList linkedList = new LinkedList();
        if (com.tencent.mm.ac.d.cW(this.liveData.uFa, 1)) {
            com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
            linkedList.addAll(com.tencent.mm.plugin.finder.utils.m.ez(this.liveData.uEZ));
        }
        LinkedList linkedList2 = new LinkedList();
        if (com.tencent.mm.ac.d.cW(this.liveData.uFa, 2)) {
            linkedList2.addAll(this.liveData.UQf);
        }
        LinkedList linkedList3 = new LinkedList();
        if (com.tencent.mm.ac.d.cW(this.liveData.uFa, 4)) {
            linkedList3.addAll(this.liveData.UQg);
        }
        Log.i(this.TAG, "doCreateLive luckyMoneyChatRoom:" + this.liveData.UQm.Mpi + " visibilityMode:" + this.liveData.uFa + " visibilityList:" + linkedList + " visibilityRoomList:" + linkedList2);
        new com.tencent.mm.plugin.finder.live.model.cgi.e(com.tencent.mm.model.z.aUg(), this.liveData.uDm, this.liveData.uix, this.liveData.uFa, linkedList, linkedList2, linkedList3, this.liveData.UQm.Mpi, new d(this, uVar), (byte) 0).aYI();
        AppMethodBeat.o(246031);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doCreateLive$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCreateLive$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveResp;", "plugin-finder_release"})
    public static final class d implements e.a {
        final /* synthetic */ b uhO;
        final /* synthetic */ kotlin.g.a.u uhR;

        d(b bVar, kotlin.g.a.u uVar) {
            this.uhO = bVar;
            this.uhR = uVar;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.e.a
        public final void a(int i2, int i3, String str, aqd aqd) {
            String str2;
            String str3;
            long j2;
            String str4;
            String str5;
            AppMethodBeat.i(246000);
            kotlin.g.b.p.h(aqd, "resp");
            if (i2 == 0 && i3 == 0) {
                b bVar = this.uhO;
                FinderObject finderObject = aqd.LCe;
                awe awe = finderObject != null ? finderObject.liveInfo : null;
                com.tencent.mm.plugin.finder.live.viewmodel.g gVar = bVar.liveData;
                if (awe == null) {
                    awe = new awe();
                }
                gVar.setLiveInfo(awe);
                bVar.liveData.uDz = aqd.LCe;
                com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = bVar.liveData;
                FinderObject finderObject2 = aqd.LCe;
                if (finderObject2 != null) {
                    j2 = finderObject2.id;
                } else {
                    j2 = 0;
                }
                gVar2.hFK = j2;
                com.tencent.mm.plugin.finder.live.viewmodel.g gVar3 = bVar.liveData;
                FinderObject finderObject3 = aqd.LCe;
                if (finderObject3 == null || (str4 = finderObject3.objectNonceId) == null) {
                    str4 = "";
                }
                gVar3.atS(str4);
                kotlin.g.a.u uVar = this.uhR;
                if (uVar != null) {
                    Boolean bool = Boolean.TRUE;
                    Boolean bool2 = Boolean.FALSE;
                    Integer valueOf = Integer.valueOf(i2);
                    Integer valueOf2 = Integer.valueOf(i3);
                    if (str == null) {
                        str5 = "";
                    } else {
                        str5 = str;
                    }
                    uVar.invoke(bool, bool2, "", valueOf, valueOf2, str5, aqd);
                    AppMethodBeat.o(246000);
                    return;
                }
                AppMethodBeat.o(246000);
                return;
            }
            Log.i(this.uhO.TAG, "launch live room failed");
            if (i3 == -200008) {
                kotlin.g.a.u uVar2 = this.uhR;
                if (uVar2 != null) {
                    Boolean bool3 = Boolean.FALSE;
                    Boolean bool4 = Boolean.TRUE;
                    String str6 = aqd.LCf;
                    if (str6 == null) {
                        str6 = "";
                    }
                    Integer valueOf3 = Integer.valueOf(i2);
                    Integer valueOf4 = Integer.valueOf(i3);
                    if (str == null) {
                        str3 = "";
                    } else {
                        str3 = str;
                    }
                    uVar2.invoke(bool3, bool4, str6, valueOf3, valueOf4, str3, aqd);
                }
            } else {
                kotlin.g.a.u uVar3 = this.uhR;
                if (uVar3 != null) {
                    Boolean bool5 = Boolean.FALSE;
                    Integer valueOf5 = Integer.valueOf(i2);
                    Integer valueOf6 = Integer.valueOf(i3);
                    if (str == null) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    uVar3.invoke(bool5, bool5, "", valueOf5, valueOf6, str2, aqd);
                }
            }
            ae aeVar = ae.vZW;
            String dEb = ae.dEb();
            if (str == null) {
                str = "";
            }
            ae.a(dEb, i3, i2, str, this.uhO.liveData);
            AppMethodBeat.o(246000);
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void a(boolean z, kotlin.g.a.s<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super com.tencent.mm.plugin.finder.live.viewmodel.a, kotlin.x> sVar) {
        AppMethodBeat.i(246032);
        Log.i(this.TAG, "doFinishLive manualFinish:" + z + " isSecondDaryDevice:false");
        if (!z) {
            ((aj) com.tencent.mm.kernel.g.ah(aj.class)).getLiveInfo(Long.valueOf(this.liveData.liveInfo.liveId), new f(this, sVar));
            AppMethodBeat.o(246032);
        } else if (z) {
            Log.i(this.TAG, "doManualCloseLive liveId:" + this.liveData.liveInfo.liveId + " objectId:" + this.liveData.hFK + " nonceId:" + this.liveData.hwg);
            new com.tencent.mm.plugin.finder.live.model.cgi.x(this.liveData.liveInfo.liveId, this.liveData.hFK, this.liveData.hwg, new p(this, new g(this, sVar))).aYI();
            EventCenter.instance.publish(new hi());
            AppMethodBeat.o(246032);
        } else {
            s.a.a(this, new h(sVar));
            AppMethodBeat.o(246032);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "respLiveId", "", "liveStatus", "", "resp", "", "kotlin.jvm.PlatformType", "onLiveStatusCallback"})
    static final class f implements aj.b {
        final /* synthetic */ b uhO;
        final /* synthetic */ kotlin.g.a.s uhQ;

        f(b bVar, kotlin.g.a.s sVar) {
            this.uhO = bVar;
            this.uhQ = sVar;
        }

        @Override // com.tencent.mm.plugin.i.a.aj.b
        public final void a(long j2, int i2, Object obj) {
            AppMethodBeat.i(246003);
            Log.i(this.uhO.TAG, "getLiveInfo,liveData.liveId:" + this.uhO.liveData.liveInfo.liveId + ",respLiveId:" + j2 + ",liveStatus:" + i2 + ",resp:" + obj);
            if (j2 != this.uhO.liveData.liveInfo.liveId || !(obj instanceof asq)) {
                kotlin.g.a.s sVar = this.uhQ;
                if (sVar != null) {
                    sVar.a(Boolean.FALSE, 0, 0, "", new com.tencent.mm.plugin.finder.live.viewmodel.a(0, 0, 0, 0, 31));
                    AppMethodBeat.o(246003);
                    return;
                }
                AppMethodBeat.o(246003);
                return;
            }
            awe awe = ((asq) obj).liveInfo;
            int i3 = awe != null ? awe.iqg : 0;
            awe awe2 = ((asq) obj).liveInfo;
            int i4 = i3 - (awe2 != null ? awe2.dvv : 0);
            awe awe3 = ((asq) obj).liveInfo;
            int i5 = awe3 != null ? awe3.uBn : 0;
            awe awe4 = ((asq) obj).liveInfo;
            int i6 = awe4 != null ? awe4.wBG : 0;
            int i7 = ((asq) obj).LBn;
            com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
            Long a2 = com.tencent.mm.plugin.finder.utils.m.a(((asq) obj).liveInfo);
            long longValue = a2 != null ? a2.longValue() : 0;
            kotlin.g.a.s sVar2 = this.uhQ;
            if (sVar2 != null) {
                sVar2.a(Boolean.TRUE, 0, 0, "", new com.tencent.mm.plugin.finder.live.viewmodel.a(i4, i5, i6, i7, longValue));
                AppMethodBeat.o(246003);
                return;
            }
            AppMethodBeat.o(246003);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doCloseLive$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLive$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.live.model.b$b  reason: collision with other inner class name */
    public static final class C1182b implements c.a {
        final /* synthetic */ b uhO;
        final /* synthetic */ kotlin.g.a.s uhQ;

        C1182b(b bVar, kotlin.g.a.s sVar) {
            this.uhO = bVar;
            this.uhQ = sVar;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.c.a
        public final void a(int i2, int i3, String str, ape ape) {
            String str2;
            String str3;
            AppMethodBeat.i(245998);
            kotlin.g.b.p.h(ape, "resp");
            if (i2 == 0 && i3 == 0) {
                kotlin.g.a.s sVar = this.uhQ;
                if (sVar != null) {
                    Boolean bool = Boolean.TRUE;
                    Integer valueOf = Integer.valueOf(i3);
                    Integer valueOf2 = Integer.valueOf(i2);
                    if (str == null) {
                        str3 = "";
                    } else {
                        str3 = str;
                    }
                    sVar.a(bool, valueOf, valueOf2, str3, ape);
                    AppMethodBeat.o(245998);
                    return;
                }
                AppMethodBeat.o(245998);
                return;
            }
            Log.i(this.uhO.TAG, "close live room failed");
            kotlin.g.a.s sVar2 = this.uhQ;
            if (sVar2 != null) {
                Boolean bool2 = Boolean.FALSE;
                Integer valueOf3 = Integer.valueOf(i3);
                Integer valueOf4 = Integer.valueOf(i2);
                if (str == null) {
                    str2 = "";
                } else {
                    str2 = str;
                }
                sVar2.a(bool2, valueOf3, valueOf4, str2, ape);
            }
            ae aeVar = ae.vZW;
            String dEg = ae.dEg();
            if (str == null) {
                str = "";
            }
            ae.a(dEg, i3, i2, str, this.uhO.liveData);
            AppMethodBeat.o(245998);
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void a(int i2, kotlin.g.a.s<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super ape, kotlin.x> sVar) {
        AppMethodBeat.i(246033);
        Log.i(this.TAG, "doCloseLive liveId:" + this.liveData.liveInfo.liveId + " objectId:" + this.liveData.hFK + " nonceId:" + this.liveData.hwg);
        long j2 = this.liveData.liveInfo.liveId;
        String aUg = com.tencent.mm.model.z.aUg();
        kotlin.g.b.p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
        new com.tencent.mm.plugin.finder.live.model.cgi.c(j2, aUg, this.liveData.hFK, this.liveData.hwg, i2, new C1182b(this, sVar)).aYI();
        EventCenter.instance.publish(new hi());
        AppMethodBeat.o(246033);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doCloseVisitorLive$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveMsg$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgResp;", "requestCode", "plugin-finder_release"})
    public static final class c implements h.a {
        c() {
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.h.a
        public final void a(int i2, int i3, ass ass, int i4) {
            AppMethodBeat.i(260429);
            kotlin.g.b.p.h(ass, "resp");
            AppMethodBeat.o(260429);
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void dfj() {
        AppMethodBeat.i(246034);
        Log.i(this.TAG, "doCloseVisitorLive liveId:" + this.liveData.liveInfo.liveId + " objectId:" + this.liveData.hFK + " nonceId:" + this.liveData.hwg);
        am amVar = am.tuw;
        new com.tencent.mm.plugin.finder.live.model.cgi.h(am.cXY(), com.tencent.mm.model.z.aUg(), this.liveData.hIt, this.liveData.liveInfo.liveId, this.liveData.hFK, this.liveData.hwg, 0, true, null, this.liveData.UQh.LFy, new c(), 256).aYI();
        AppMethodBeat.o(246034);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void Jf(int i2) {
        AppMethodBeat.i(246035);
        Log.i(this.TAG, "[likeInfo] doLikeLive:".concat(String.valueOf(i2)));
        if (i2 <= 0) {
            AppMethodBeat.o(246035);
            return;
        }
        this.liveData.UPT += (long) i2;
        am amVar = am.tuw;
        aov cXY = am.cXY();
        byte[] bArr = this.liveData.hIt;
        long j2 = this.liveData.liveInfo.liveId;
        long j3 = this.liveData.hFK;
        String str = this.liveData.hwg;
        String aUg = com.tencent.mm.model.z.aUg();
        kotlin.g.b.p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
        new com.tencent.mm.plugin.finder.live.model.cgi.j(cXY, bArr, j2, i2, j3, str, aUg, new o(this)).aYI();
        AppMethodBeat.o(246035);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doLikeLive$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLikeLive$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLikeLiveResp;", "plugin-finder_release"})
    public static final class o implements j.a {
        final /* synthetic */ b uhO;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        o(b bVar) {
            this.uhO = bVar;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.j.a
        public final void a(int i2, int i3, aun aun) {
            awi awi;
            AppMethodBeat.i(246013);
            kotlin.g.b.p.h(aun, "resp");
            Log.i(this.uhO.TAG, "onSceneEnd errType:" + i2 + " errCode:" + i3);
            if (i2 == 0 && i3 == 0 && com.tencent.mm.ac.d.cW(aun.LFs, 1)) {
                FinderBaseLivePluginLayout finderBaseLivePluginLayout = this.uhO.uhN;
                Context context = MMApplicationContext.getContext();
                kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
                String string = context.getResources().getString(R.string.cur);
                kotlin.g.b.p.g(string, "MMApplicationContext.get…er_live_lottery_attended)");
                finderBaseLivePluginLayout.showCenterCustomizeToast(string, R.raw.icons_outlined_done);
                String str = this.uhO.TAG;
                StringBuilder sb = new StringBuilder("doLikeLive attended lottery success,lotteryId:");
                com.tencent.mm.plugin.finder.live.viewmodel.i iVar = this.uhO.liveData.uEa;
                Log.i(str, sb.append((iVar == null || (awi = iVar.tWe) == null) ? null : awi.id).toString());
                if (this.uhO.uhN.getLiveRole() == 0) {
                    com.tencent.mm.plugin.finder.report.live.m.vli.a(s.ay.POPUP_TOAST_JOINED, "");
                }
            }
            AppMethodBeat.o(246013);
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void c(kotlin.g.a.r<? super Integer, ? super Integer, ? super String, ? super ban, kotlin.x> rVar) {
        AppMethodBeat.i(246036);
        x.a aVar = com.tencent.mm.plugin.finder.cgi.x.ttF;
        aut aut = new aut();
        aut.ybm = 20006;
        aut.LFr = com.tencent.mm.model.z.aTY() + System.currentTimeMillis();
        new com.tencent.mm.plugin.finder.cgi.x(aut, this.liveData, new m(rVar)).aYI();
        AppMethodBeat.o(246036);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void a(ah.a aVar) {
        AppMethodBeat.i(260431);
        am amVar = am.tuw;
        new ah(am.cXY(), com.tencent.mm.model.z.aUg(), this.liveData.uDM, this.liveData.hIt, aVar).aYI();
        AppMethodBeat.o(260431);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void a(long j2, long j3, com.tencent.mm.bw.b bVar, kotlin.g.a.b<? super Boolean, kotlin.x> bVar2) {
        int i2;
        AppMethodBeat.i(246039);
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        if (!com.tencent.mm.plugin.finder.utils.m.dBP()) {
            i2 = 0;
        } else if (!this.liveData.uEj) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        String aUg = com.tencent.mm.model.z.aUg();
        kotlin.g.b.p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
        com.tencent.mm.co.f aYI = new com.tencent.mm.plugin.finder.live.model.cgi.q(j2, j3, aUg, bVar, i2, this.liveData.dPI, new l(this, bVar2, i2)).aYI();
        Context context = this.uhN.getContext();
        if (context == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(246039);
            throw tVar;
        }
        aYI.a((MMActivity) context);
        AppMethodBeat.o(246039);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doGetProductList$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetShoppingList$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopWindowProductResponse;", "plugin-finder_release"})
    public static final class l implements q.a {
        final /* synthetic */ int $scene;
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ b uhO;

        l(b bVar, kotlin.g.a.b bVar2, int i2) {
            this.uhO = bVar;
            this.gWe = bVar2;
            this.$scene = i2;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.q.a
        public final void a(int i2, int i3, String str, awc awc) {
            AppMethodBeat.i(246009);
            kotlin.g.b.p.h(awc, "resp");
            long j2 = awc.liveId;
            awe awe = this.uhO.liveData.liveInfo;
            if (awe == null || j2 != awe.liveId) {
                String str2 = this.uhO.TAG;
                StringBuilder append = new StringBuilder("invalid live resp,liveId:").append(awc.liveId).append(",current liveId:");
                awe awe2 = this.uhO.liveData.liveInfo;
                Log.i(str2, append.append((awe2 != null ? Long.valueOf(awe2.liveId) : null).longValue()).toString());
                kotlin.g.a.b bVar = this.gWe;
                if (bVar != null) {
                    bVar.invoke(Boolean.FALSE);
                    AppMethodBeat.o(246009);
                    return;
                }
                AppMethodBeat.o(246009);
            } else if (i2 == 0 && i3 == 0) {
                this.uhO.liveData.uEj = true;
                String str3 = awc.LGw;
                if (str3 != null) {
                    com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.uhO.liveData;
                    kotlin.g.b.p.g(str3, LocaleUtil.ITALIAN);
                    gVar.atV(str3);
                }
                Log.i(this.uhO.TAG, "mergeProducts, resp list size:" + awc.Lhs.size());
                this.uhO.liveData.b(awc);
                kotlin.g.a.b bVar2 = this.gWe;
                if (bVar2 != null) {
                    bVar2.invoke(Boolean.TRUE);
                    AppMethodBeat.o(246009);
                    return;
                }
                AppMethodBeat.o(246009);
            } else {
                kotlin.g.a.b bVar3 = this.gWe;
                if (bVar3 != null) {
                    bVar3.invoke(Boolean.FALSE);
                }
                if (this.$scene != 0) {
                    ae aeVar = ae.vZW;
                    String dEj = ae.dEj();
                    if (str == null) {
                        str = "";
                    }
                    ae.a(dEj, i3, i2, str, this.uhO.liveData);
                }
                AppMethodBeat.o(246009);
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void a(axg axg) {
        AppMethodBeat.i(246040);
        kotlin.g.b.p.h(axg, "product");
        if (axg.LHK == 0) {
            Log.i(this.TAG, "[getProductDetail] product:" + axg.title + " is not promotting, return ");
            AppMethodBeat.o(246040);
            return;
        }
        new com.tencent.mm.plugin.finder.live.model.cgi.p(this.liveData, axg, new t(this)).aYI();
        AppMethodBeat.o(246040);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$getProductDetail$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetProductDetail$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopProductDetailResponse;", "plugin-finder_release"})
    public static final class t implements p.a {
        final /* synthetic */ b uhO;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        t(b bVar) {
            this.uhO = bVar;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.p.a
        public final void a(int i2, int i3, awa awa) {
            AppMethodBeat.i(246021);
            kotlin.g.b.p.h(awa, "resp");
            if (i2 == 0 && i3 == 0) {
                String str = awa.LGw;
                if (str != null) {
                    com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.uhO.liveData;
                    kotlin.g.b.p.g(str, LocaleUtil.ITALIAN);
                    gVar.atV(str);
                }
                axg axg = awa.LGx;
                if (axg != null) {
                    com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = this.uhO.liveData;
                    com.tencent.mm.plugin.finder.live.view.a.a aVar = com.tencent.mm.plugin.finder.live.view.a.a.UPD;
                    kotlin.g.b.p.g(axg, LocaleUtil.ITALIAN);
                    gVar2.f(com.tencent.mm.plugin.finder.live.view.a.a.b(axg));
                    AppMethodBeat.o(246021);
                    return;
                }
            }
            AppMethodBeat.o(246021);
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void aty(String str) {
        String str2;
        AppMethodBeat.i(246041);
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        cn cnVar = new cn(str2, 0, null, 0, null, 0, 0, 104);
        cnVar.twC = true;
        com.tencent.mm.kernel.g.azz().b(cnVar);
        AppMethodBeat.o(246041);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doPostComment$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveMsgResp;", "plugin-finder_release"})
    public static final class q implements l.a {
        final /* synthetic */ b uhO;
        final /* synthetic */ l.a uhX;

        q(b bVar, l.a aVar) {
            this.uhO = bVar;
            this.uhX = aVar;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.l.a
        public final void a(int i2, int i3, String str, bap bap) {
            awi awi;
            AppMethodBeat.i(246015);
            kotlin.g.b.p.h(bap, "resp");
            l.a aVar = this.uhX;
            if (aVar != null) {
                aVar.a(i2, i3, str, bap);
            }
            if (i2 != 0 || i3 != 0) {
                com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                if (com.tencent.mm.plugin.finder.utils.y.dCM()) {
                    com.tencent.mm.ui.base.u.makeText(this.uhO.uhN.getContext(), i3 + ':' + str, 0).show();
                }
            } else if (com.tencent.mm.ac.d.cW(bap.LFs, 1)) {
                FinderBaseLivePluginLayout finderBaseLivePluginLayout = this.uhO.uhN;
                Context context = MMApplicationContext.getContext();
                kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
                String string = context.getResources().getString(R.string.cur);
                kotlin.g.b.p.g(string, "MMApplicationContext.get…er_live_lottery_attended)");
                finderBaseLivePluginLayout.showCenterCustomizeToast(string, R.raw.icons_outlined_done);
                String str2 = this.uhO.TAG;
                StringBuilder sb = new StringBuilder("doPostComment attended lottery success,lotteryId:");
                com.tencent.mm.plugin.finder.live.viewmodel.i iVar = this.uhO.liveData.uEa;
                Log.i(str2, sb.append((iVar == null || (awi = iVar.tWe) == null) ? null : awi.id).toString());
                if (this.uhO.uhN.getLiveRole() == 0) {
                    com.tencent.mm.plugin.finder.report.live.m.vli.a(s.ay.POPUP_TOAST_JOINED, "");
                    AppMethodBeat.o(246015);
                    return;
                }
            }
            AppMethodBeat.o(246015);
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void a(String str, int i2, l.a aVar) {
        AppMethodBeat.i(246042);
        kotlin.g.b.p.h(str, "commentContent");
        long j2 = this.liveData.liveInfo.liveId;
        byte[] bArr = this.liveData.hIt;
        long j3 = this.liveData.hFK;
        String str2 = this.liveData.hwg;
        String aUg = com.tencent.mm.model.z.aUg();
        kotlin.g.b.p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
        new com.tencent.mm.plugin.finder.live.model.cgi.l(j2, str, i2, bArr, j3, str2, aUg, new q(this, aVar)).aYI();
        AppMethodBeat.o(246042);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\f¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doDisableComment$1$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveBanComment$CallBack;", "onFail", "", "errType", "", "errCode", "errMsg", "", "enable", "", "onSuccess", "plugin-finder_release"})
    public static final class e implements t.a {
        final /* synthetic */ kotlin.g.a.m hVl;
        final /* synthetic */ boolean ntM;
        final /* synthetic */ b uhO;
        final /* synthetic */ String uhS;

        e(b bVar, boolean z, String str, kotlin.g.a.m mVar) {
            this.uhO = bVar;
            this.ntM = z;
            this.uhS = str;
            this.hVl = mVar;
        }

        @Override // com.tencent.mm.plugin.finder.cgi.t.a
        public final void mO(boolean z) {
            AppMethodBeat.i(246001);
            Log.i(this.uhO.TAG, "doDisableComment success, enable:" + z + " username:" + this.uhS);
            this.uhO.liveData.uDX.put(this.uhS, Boolean.valueOf(!z));
            kotlin.g.a.m mVar = this.hVl;
            if (mVar != null) {
                mVar.invoke(Boolean.TRUE, Boolean.valueOf(z));
                AppMethodBeat.o(246001);
                return;
            }
            AppMethodBeat.o(246001);
        }

        @Override // com.tencent.mm.plugin.finder.cgi.t.a
        public final void t(int i2, int i3, boolean z) {
            AppMethodBeat.i(246002);
            Log.i(this.uhO.TAG, "doDisableComment fail, enable:" + z + " username:" + this.uhS + " errType:" + i2 + " errCode:" + i3);
            kotlin.g.a.m mVar = this.hVl;
            if (mVar != null) {
                mVar.invoke(Boolean.FALSE, Boolean.valueOf(z));
                AppMethodBeat.o(246002);
                return;
            }
            AppMethodBeat.o(246002);
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void a(String str, boolean z, kotlin.g.a.m<? super Boolean, ? super Boolean, kotlin.x> mVar) {
        AppMethodBeat.i(246043);
        if (str != null) {
            new com.tencent.mm.plugin.finder.cgi.t(this.liveData.liveInfo.liveId, this.liveData.hFK, str, z, new e(this, z, str, mVar)).aYI();
            AppMethodBeat.o(246043);
            return;
        }
        AppMethodBeat.o(246043);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doGetFinderLiveContact$1$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveGetContact$CallBack;", "onFinish", "", "success", "", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "plugin-finder_release"})
    public static final class i implements u.a {
        final /* synthetic */ kotlin.g.a.m hVl;
        final /* synthetic */ b uhO;
        final /* synthetic */ String uhS;
        final /* synthetic */ int uhT = 0;

        i(b bVar, String str) {
            this.uhO = bVar;
            this.uhS = str;
            this.hVl = null;
        }

        @Override // com.tencent.mm.plugin.finder.cgi.u.a
        public final void a(boolean z, avn avn) {
            HashMap<String, Boolean> hashMap;
            boolean z2 = true;
            AppMethodBeat.i(246006);
            Log.i(this.uhO.TAG, "doGetFinderLiveContact success:" + z + " username:" + this.uhS);
            if (z) {
                com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.uhO.liveData;
                if (gVar != null) {
                    hashMap = gVar.uDX;
                } else {
                    hashMap = null;
                }
                HashMap<String, Boolean> hashMap2 = hashMap;
                String str = this.uhS;
                if (avn == null || avn.LGh != 1) {
                    z2 = false;
                }
                hashMap2.put(str, Boolean.valueOf(z2));
            }
            kotlin.g.a.m mVar = this.hVl;
            if (mVar != null) {
                mVar.invoke(Boolean.valueOf(z), avn);
                AppMethodBeat.o(246006);
                return;
            }
            AppMethodBeat.o(246006);
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void bxD(String str) {
        AppMethodBeat.i(260432);
        if (str != null) {
            new com.tencent.mm.plugin.finder.cgi.u(this.liveData.liveInfo.liveId, this.liveData.hFK, str, new i(this, str)).aYI();
            AppMethodBeat.o(260432);
            return;
        }
        AppMethodBeat.o(260432);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void c(String str, kotlin.g.a.m<? super ayt, ? super apg, kotlin.x> mVar) {
        AppMethodBeat.i(246045);
        Log.i(this.TAG, "putInBlackList username:".concat(String.valueOf(str)));
        if (str != null) {
            ((com.tencent.mm.plugin.i.a.t) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.t.class)).b(str, new w(mVar));
            AppMethodBeat.o(246045);
            return;
        }
        AppMethodBeat.o(246045);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$putInBlackList$1$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
    public static final class w implements ai<ayt> {
        final /* synthetic */ kotlin.g.a.m hVl;

        w(kotlin.g.a.m mVar) {
            this.hVl = mVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.protocal.protobuf.apg] */
        @Override // com.tencent.mm.plugin.i.a.ai
        public final /* synthetic */ void a(ayt ayt, apg apg) {
            AppMethodBeat.i(246026);
            ayt ayt2 = ayt;
            kotlin.g.b.p.h(ayt2, "req");
            kotlin.g.b.p.h(apg, "ret");
            kotlin.g.a.m mVar = this.hVl;
            if (mVar != null) {
                mVar.invoke(ayt2, apg);
                AppMethodBeat.o(246026);
                return;
            }
            AppMethodBeat.o(246026);
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void h(long j2, long j3, int i2) {
        AppMethodBeat.i(246046);
        Log.i(this.TAG, "setAnchorStatus liveId:" + j2 + " objectId:" + j3 + " flag:" + i2);
        String aUg = com.tencent.mm.model.z.aUg();
        kotlin.g.b.p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
        new com.tencent.mm.plugin.finder.cgi.s(j2, j3, i2, aUg, null).aYI();
        AppMethodBeat.o(246046);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void f(kotlin.g.a.m<? super Boolean, ? super Integer, kotlin.x> mVar) {
        AppMethodBeat.i(246047);
        if (!this.liveData.uEJ) {
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            if (!com.tencent.mm.plugin.finder.utils.y.dCM()) {
                String str = this.TAG;
                StringBuilder append = new StringBuilder("doGetGiftList liveData.enableGiftSwitch:").append(this.liveData.uEJ).append(", FinderUtil.isTest():");
                com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
                Log.i(str, append.append(com.tencent.mm.plugin.finder.utils.y.dCM()).toString());
                AppMethodBeat.o(246047);
                return;
            }
        }
        e eVar = e.uiD;
        if (e.getDebug()) {
            Log.i(this.TAG, "doGetGiftList : enter debug");
            e eVar2 = e.uiD;
            e.dfB();
            AppMethodBeat.o(246047);
            return;
        }
        new com.tencent.mm.plugin.finder.live.model.cgi.f(this.liveData.liveInfo.liveId, this.liveData.hFK, this.liveData.hwg, com.tencent.mm.model.z.aUg(), new j(this, mVar)).aYI();
        AppMethodBeat.o(246047);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doGetGiftList$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveGiftList$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveRewardGiftListResponse;", "plugin-finder_release"})
    public static final class j implements f.a {
        final /* synthetic */ kotlin.g.a.m nzd;
        final /* synthetic */ b uhO;

        j(b bVar, kotlin.g.a.m mVar) {
            this.uhO = bVar;
            this.nzd = mVar;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.f.a
        public final void a(int i2, int i3, ata ata) {
            AppMethodBeat.i(246007);
            kotlin.g.b.p.h(ata, "resp");
            Log.i(this.uhO.TAG, "doGetGiftList errType:" + i2 + ", errCode:" + i3);
            if (i2 == 0 && i3 == 0) {
                o oVar = o.ujN;
                o.b(ata.LDs);
                o oVar2 = o.ujN;
                o.Jg(ata.LDW);
                o oVar3 = o.ujN;
                o.Jh(ata.LDX);
                kotlin.g.a.m mVar = this.nzd;
                if (mVar != null) {
                    mVar.invoke(Boolean.TRUE, Integer.valueOf(i3));
                    AppMethodBeat.o(246007);
                    return;
                }
                AppMethodBeat.o(246007);
                return;
            }
            kotlin.g.a.m mVar2 = this.nzd;
            if (mVar2 != null) {
                mVar2.invoke(Boolean.FALSE, Integer.valueOf(i3));
                AppMethodBeat.o(246007);
                return;
            }
            AppMethodBeat.o(246007);
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void a(Context context, String str, int i2, int i3, String str2, String str3, af.a aVar) {
        AppMethodBeat.i(260433);
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(str3, "sendGiftTargetUserName");
        if (this.liveData.dja()) {
            e eVar = e.uiD;
            if (!e.getDebug()) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1581, 70);
                String aUg = com.tencent.mm.model.z.aUg();
                com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                String dCV = com.tencent.mm.plugin.finder.utils.y.dCV();
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(22129, 1, dCV, "", 1, 1, 0, "");
                new com.tencent.mm.plugin.finder.live.model.cgi.v(this.liveData.liveInfo.liveId, this.liveData.hFK, str, i2, aUg, i3, dCV, str2, str3, new r(this, i3, context, dCV, aVar, str, i2, str2)).aYI();
            }
        }
        AppMethodBeat.o(260433);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doPostGift$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveReward$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardResponse;", "plugin-finder_release"})
    public static final class r implements v.a {
        final /* synthetic */ Context $context;
        final /* synthetic */ b uhO;
        final /* synthetic */ int uhY;
        final /* synthetic */ String uhZ;
        final /* synthetic */ af.a uia;
        final /* synthetic */ String uib;
        final /* synthetic */ int uic;
        final /* synthetic */ String uie;

        r(b bVar, int i2, Context context, String str, af.a aVar, String str2, int i3, String str3) {
            this.uhO = bVar;
            this.uhY = i2;
            this.$context = context;
            this.uhZ = str;
            this.uia = aVar;
            this.uib = str2;
            this.uic = i3;
            this.uie = str3;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.v.a
        public final void a(int i2, int i3, String str, axc axc) {
            byte[] bArr;
            AppMethodBeat.i(246018);
            kotlin.g.b.p.h(axc, "resp");
            Log.i(this.uhO.TAG, "doPostGift errType:" + i2 + ", errCode:" + i3 + ",errMsg:" + str);
            com.tencent.mm.plugin.finder.utils.af afVar = com.tencent.mm.plugin.finder.utils.af.waa;
            com.tencent.mm.plugin.finder.utils.af.LZ(this.uhY);
            if (!(i2 == 0 && i3 == 0)) {
                com.tencent.mm.plugin.finder.utils.af afVar2 = com.tencent.mm.plugin.finder.utils.af.waa;
                com.tencent.mm.plugin.finder.utils.af.dEu();
            }
            b bVar = this.uhO;
            Context context = this.$context;
            String str2 = this.uhZ;
            com.tencent.mm.bw.b bVar2 = axc.LHF;
            if (bVar2 != null) {
                bArr = bVar2.toByteArray();
            } else {
                bArr = null;
            }
            a aVar = new a(this);
            Log.i(bVar.TAG, "[WeCoin] consumeGift:".concat(String.valueOf(bArr)));
            com.tencent.mm.plugin.wallet.wecoin.a.c cVar = (com.tencent.mm.plugin.wallet.wecoin.a.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.wallet.wecoin.a.c.class);
            if (bArr == null) {
                bArr = new byte[0];
            }
            cVar.a(context, str2, bArr, aVar);
            AppMethodBeat.o(246018);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doPostGift$1$onCgiBack$1", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "", "onFailed", "", "errorType", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "msg", "", "onSuccess", "data", "plugin-finder_release"})
        public static final class a implements com.tencent.mm.plugin.wallet.wecoin.a.e<Long> {
            final /* synthetic */ r uif;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            a(r rVar) {
                this.uif = rVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.plugin.wallet.wecoin.a.e
            public final /* synthetic */ void onSuccess(Long l) {
                AppMethodBeat.i(246016);
                long longValue = l.longValue();
                Log.i(this.uif.uhO.TAG, "[WeCoin] consumeGift onSuccess");
                af.a aVar = this.uif.uia;
                if (aVar != null) {
                    aVar.a(true, 0, af.a.EnumC1189a.OK, this.uif.uib, Long.valueOf(longValue), this.uif.uic, this.uif.uie);
                }
                com.tencent.mm.plugin.finder.utils.af afVar = com.tencent.mm.plugin.finder.utils.af.waa;
                com.tencent.mm.plugin.finder.utils.af.dEt();
                AppMethodBeat.o(246016);
            }

            @Override // com.tencent.mm.plugin.wallet.wecoin.a.e
            public final void p(int i2, int i3, String str) {
                AppMethodBeat.i(246017);
                Log.i(this.uif.uhO.TAG, "[WeCoin] consumeGift onFailed errorType:" + i2 + ",errorCode:" + i3 + ",msg:" + str);
                af.a aVar = this.uif.uia;
                if (aVar != null) {
                    aVar.a(false, i3, af.a.EnumC1189a.WECOIN, this.uif.uib, null, this.uif.uic, this.uif.uie);
                }
                com.tencent.mm.plugin.finder.utils.af afVar = com.tencent.mm.plugin.finder.utils.af.waa;
                com.tencent.mm.plugin.finder.utils.af.dEv();
                AppMethodBeat.o(246017);
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doManualCloseLive$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderManualCloseLive$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderManualCloseLiveResp;", "plugin-finder_release"})
    public static final class p implements x.a {
        final /* synthetic */ b uhO;
        final /* synthetic */ kotlin.g.a.s uhQ;

        p(b bVar, kotlin.g.a.s sVar) {
            this.uhO = bVar;
            this.uhQ = sVar;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.x.a
        public final void a(int i2, int i3, String str, ayd ayd) {
            String str2;
            String str3;
            AppMethodBeat.i(246014);
            kotlin.g.b.p.h(ayd, "resp");
            if (i2 == 0 && i3 == 0) {
                kotlin.g.a.s sVar = this.uhQ;
                if (sVar != null) {
                    Boolean bool = Boolean.TRUE;
                    Integer valueOf = Integer.valueOf(i3);
                    Integer valueOf2 = Integer.valueOf(i2);
                    if (str == null) {
                        str3 = "";
                    } else {
                        str3 = str;
                    }
                    sVar.a(bool, valueOf, valueOf2, str3, ayd);
                    AppMethodBeat.o(246014);
                    return;
                }
                AppMethodBeat.o(246014);
                return;
            }
            Log.i(this.uhO.TAG, "manual close live room failed");
            kotlin.g.a.s sVar2 = this.uhQ;
            if (sVar2 != null) {
                Boolean bool2 = Boolean.FALSE;
                Integer valueOf3 = Integer.valueOf(i3);
                Integer valueOf4 = Integer.valueOf(i2);
                if (str == null) {
                    str2 = "";
                } else {
                    str2 = str;
                }
                sVar2.a(bool2, valueOf3, valueOf4, str2, ayd);
            }
            ae aeVar = ae.vZW;
            String dEh = ae.dEh();
            if (str == null) {
                str = "";
            }
            ae.a(dEh, i3, i2, str, this.uhO.liveData);
            AppMethodBeat.o(246014);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doGetMemberList$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderOnlineMember$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveOnlineMemberResp;", "plugin-finder_release"})
    public static final class k implements y.a {
        final /* synthetic */ kotlin.g.a.r nyK;
        final /* synthetic */ b uhO;

        k(b bVar, kotlin.g.a.r rVar) {
            this.uhO = bVar;
            this.nyK = rVar;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.y.a
        public final void a(int i2, int i3, String str, asu asu) {
            AppMethodBeat.i(246008);
            kotlin.g.b.p.h(asu, "resp");
            if (i2 == 0 && i3 == 0) {
                this.uhO.liveData.uDn.clear();
                y.a aVar = com.tencent.mm.plugin.finder.live.plugin.y.uoV;
                if (com.tencent.mm.plugin.finder.live.plugin.y.access$getDEBUG$cp()) {
                    com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                    LinkedList<avn> dBR = com.tencent.mm.plugin.finder.utils.m.dBR();
                    if (dBR != null) {
                        this.uhO.liveData.uDn.addAll(dBR);
                    }
                }
                this.uhO.liveData.uDn.addAll(asu.LDL);
                this.uhO.liveData.uDp.clear();
                this.uhO.liveData.uDp.addAll(asu.LDM);
                this.uhO.liveData.liveInfo.uBn = asu.LDO;
                this.uhO.liveData.uDq = asu.LDO;
                this.uhO.liveData.uDr = asu.LDP;
                this.uhO.liveData.uDo = asu.LDQ;
                this.uhO.liveData.UQp = asu.UQp;
                this.uhO.liveData.UQq = asu.UQq;
                com.tencent.mm.plugin.finder.utils.m mVar2 = com.tencent.mm.plugin.finder.utils.m.vVH;
                if (!com.tencent.mm.plugin.finder.utils.m.dBP()) {
                    com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.uhO.liveData;
                    String str2 = gVar.TAG;
                    StringBuilder sb = new StringBuilder("online member enableComment:");
                    avn avn = gVar.uDo;
                    Log.i(str2, sb.append(avn != null ? Integer.valueOf(avn.hFI) : null).toString());
                    avn avn2 = gVar.uDo;
                    if (avn2 != null) {
                        if (avn2.hFI == 1) {
                            gVar.uDC = true;
                        } else if (avn2.hFI == 0) {
                            gVar.uDC = false;
                        }
                    }
                }
            }
            kotlin.g.a.r rVar = this.nyK;
            if (rVar != null) {
                rVar.invoke(Integer.valueOf(i3), Integer.valueOf(i2), str, asu);
                AppMethodBeat.o(246008);
                return;
            }
            AppMethodBeat.o(246008);
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void d(kotlin.g.a.r<? super Integer, ? super Integer, ? super String, ? super asu, kotlin.x> rVar) {
        AppMethodBeat.i(246049);
        am amVar = am.tuw;
        aov cXY = am.cXY();
        long j2 = this.liveData.liveInfo.liveId;
        String aUg = com.tencent.mm.model.z.aUg();
        kotlin.g.b.p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
        com.tencent.mm.co.f aYI = new com.tencent.mm.plugin.finder.live.model.cgi.y(cXY, j2, aUg, this.liveData.hFK, new k(this, rVar)).aYI();
        Context context = this.uhN.getContext();
        if (context == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(246049);
            throw tVar;
        }
        aYI.a((MMActivity) context);
        AppMethodBeat.o(246049);
    }

    /* access modifiers changed from: package-private */
    public final void a(cjc cjc, TRTCCloudDef.TRTCParams tRTCParams, com.tencent.mm.live.core.core.b.e eVar) {
        Integer num;
        boolean z = false;
        AppMethodBeat.i(246050);
        cjd cjd = cjc.Mot;
        ciz ciz = cjc.Mou;
        cja cja = cjc.Mov;
        if (cjd != null) {
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            boolean z2 = com.tencent.mm.plugin.finder.storage.c.hUU() && cjd.VjQ > 0;
            boolean caG = com.tencent.mm.modelcontrol.e.caG();
            boolean z3 = z2 && caG;
            Log.i(this.TAG, "processLiveSdkParams enableHEVCEncFromSvr:" + z2 + ", sdkenable:" + cjd.VjQ + ", enableHEVCEncFromLocal:" + caG + ", isHEVCEncEnable:" + z3);
            com.tencent.mm.live.core.core.trtc.a.a aDC = com.tencent.mm.live.core.core.trtc.a.a.aDC();
            kotlin.g.b.p.g(aDC, "ConfigHelper.getInstance()");
            com.tencent.mm.live.core.core.trtc.a.a.d aDD = aDC.aDD();
            kotlin.g.b.p.g(aDD, "ConfigHelper.getInstance().videoConfig");
            aDD.jb(z3);
            if (cjd.Mow > 0) {
                com.tencent.mm.live.core.core.trtc.a.a aDC2 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                kotlin.g.b.p.g(aDC2, "ConfigHelper.getInstance()");
                com.tencent.mm.live.core.core.trtc.a.a.d aDD2 = aDC2.aDD();
                kotlin.g.b.p.g(aDD2, "ConfigHelper.getInstance().videoConfig");
                aDD2.setVideoResolution(cjd.Mow);
            }
            if (cjd.Moy > 0) {
                com.tencent.mm.live.core.core.trtc.a.a aDC3 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                kotlin.g.b.p.g(aDC3, "ConfigHelper.getInstance()");
                com.tencent.mm.live.core.core.trtc.a.a.d aDD3 = aDC3.aDD();
                kotlin.g.b.p.g(aDD3, "ConfigHelper.getInstance().videoConfig");
                aDD3.qu(cjd.Moy);
            }
            if (cjd.Moz > 0) {
                com.tencent.mm.live.core.core.trtc.a.a aDC4 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                kotlin.g.b.p.g(aDC4, "ConfigHelper.getInstance()");
                com.tencent.mm.live.core.core.trtc.a.a.d aDD4 = aDC4.aDD();
                kotlin.g.b.p.g(aDD4, "ConfigHelper.getInstance().videoConfig");
                aDD4.setVideoBitrate(cjd.Moz);
            }
            if (cjd.VjP > 0) {
                com.tencent.mm.live.core.core.trtc.a.a aDC5 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                kotlin.g.b.p.g(aDC5, "ConfigHelper.getInstance()");
                com.tencent.mm.live.core.core.trtc.a.a.d aDD5 = aDC5.aDD();
                kotlin.g.b.p.g(aDD5, "ConfigHelper.getInstance().videoConfig");
                aDD5.setMinVideoBitrate(cjd.VjP);
            }
            if (cjd.VjR > 0) {
                com.tencent.mm.live.core.core.trtc.a.a aDC6 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                kotlin.g.b.p.g(aDC6, "ConfigHelper.getInstance()");
                com.tencent.mm.live.core.core.trtc.a.a.d aDD6 = aDC6.aDD();
                kotlin.g.b.p.g(aDD6, "ConfigHelper.getInstance().videoConfig");
                aDD6.aws(cjd.VjR);
            }
            if (cjd.VjS > 0) {
                com.tencent.mm.live.core.core.trtc.a.a aDC7 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                kotlin.g.b.p.g(aDC7, "ConfigHelper.getInstance()");
                com.tencent.mm.live.core.core.trtc.a.a.d aDD7 = aDC7.aDD();
                kotlin.g.b.p.g(aDD7, "ConfigHelper.getInstance().videoConfig");
                aDD7.awt(cjd.VjS);
            }
            if (cjd.VjT > 0) {
                com.tencent.mm.live.core.core.trtc.a.a aDC8 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                kotlin.g.b.p.g(aDC8, "ConfigHelper.getInstance()");
                com.tencent.mm.live.core.core.trtc.a.a.d aDD8 = aDC8.aDD();
                kotlin.g.b.p.g(aDD8, "ConfigHelper.getInstance().videoConfig");
                aDD8.awu(cjd.VjT);
            }
            if (cjd.VjU > 0) {
                com.tencent.mm.live.core.core.trtc.a.a aDC9 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                kotlin.g.b.p.g(aDC9, "ConfigHelper.getInstance()");
                com.tencent.mm.live.core.core.trtc.a.a.d aDD9 = aDC9.aDD();
                kotlin.g.b.p.g(aDD9, "ConfigHelper.getInstance().videoConfig");
                aDD9.awv(cjd.VjU);
            }
            if (cjd.MoB > 0) {
                com.tencent.mm.live.core.core.trtc.a.a aDC10 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                kotlin.g.b.p.g(aDC10, "ConfigHelper.getInstance()");
                com.tencent.mm.live.core.core.trtc.a.a.d aDD10 = aDC10.aDD();
                kotlin.g.b.p.g(aDD10, "ConfigHelper.getInstance().videoConfig");
                aDD10.qv(cjd.MoB);
            }
            int i2 = cjd.MoC;
            if (i2 >= 0 && 1 >= i2) {
                com.tencent.mm.live.core.core.trtc.a.a aDC11 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                kotlin.g.b.p.g(aDC11, "ConfigHelper.getInstance()");
                com.tencent.mm.live.core.core.trtc.a.a.d aDD11 = aDC11.aDD();
                kotlin.g.b.p.g(aDD11, "ConfigHelper.getInstance().videoConfig");
                aDD11.qt(cjd.MoC);
            }
        }
        if (ciz != null) {
            if (ciz.MnT > 0) {
                com.tencent.mm.live.core.core.trtc.a.a aDC12 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                kotlin.g.b.p.g(aDC12, "ConfigHelper.getInstance()");
                com.tencent.mm.live.core.core.trtc.a.a.a aDE = aDC12.aDE();
                kotlin.g.b.p.g(aDE, "ConfigHelper.getInstance().audioConfig");
                aDE.setAudioQuality(ciz.MnT);
            }
            Log.i(this.TAG, "processLiveSdkParams audioQuality:" + ciz.MnT);
        }
        if (cja != null) {
            Log.i(this.TAG, "userDefineRecordId:" + cja.MnU);
            String str = cja.MnV;
            String str2 = cja.MnU;
            int i3 = cja.Moe;
            if (!com.tencent.mm.modelcontrol.e.sX(5) && i3 == com.tencent.mm.live.core.core.a.CDN_QUALITY_HEVC.value) {
                i3 = cja.Mof;
            }
            eVar.hzr = cja.Mof;
            if (i3 < 100) {
                eVar.a(com.tencent.mm.live.core.core.b.a.MMLiveStreamSwitchMode_Fixed);
                eVar.hzq = i3;
            } else if (i3 == com.tencent.mm.live.core.core.a.CDN_QUALITY_AUTO_CLIQOS.value) {
                eVar.a(com.tencent.mm.live.core.core.b.a.MMLiveStreamSwitchMode_Auto);
            } else if (i3 == com.tencent.mm.live.core.core.a.CDN_QUALITY_AUTO_SVRML.value) {
                eVar.a(com.tencent.mm.live.core.core.b.a.MMLiveStreamSwitchMode_ML);
            }
            LinkedList<vh> linkedList = cja.Moa;
            if (!(linkedList == null || linkedList.isEmpty())) {
                LinkedList<vh> linkedList2 = cja.Moa;
                kotlin.g.b.p.g(linkedList2, "channelParams.cdn_trans_info");
                for (T t2 : linkedList2) {
                    Integer valueOf = Integer.valueOf(t2.LfB);
                    String str3 = t2.url;
                    kotlin.g.b.p.g(str3, "it.url");
                    eVar.hzs.put(valueOf, str3);
                }
            }
            if (!Util.isNullOrNil(str) || !Util.isNullOrNil(str2)) {
                com.tencent.mm.ab.i iVar = new com.tencent.mm.ab.i();
                if (!Util.isNullOrNil(str)) {
                    iVar.h("userdefine_streamid_main", str);
                }
                if (!Util.isNullOrNil(str2)) {
                    iVar.h("userdefine_record_id", str2);
                }
                com.tencent.mm.ab.i iVar2 = new com.tencent.mm.ab.i();
                iVar2.h("Str_uc_params", iVar);
                tRTCParams.businessInfo = iVar2.toString();
            }
            Log.i(this.TAG, "processLiveSdkParams cdnQualitySvrcfg" + eVar.hzq + " cdnSwitchMode:" + eVar.hzp + " cdn_quality_h265backcfg:" + eVar.hzr);
        }
        if (cja != null) {
            this.liveData.uEt = cja.Mog;
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.liveData;
            gVar.uET = cjc.Mov.Moh == 1;
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = this.liveData;
            if (cjc.Mov.Moi == 1) {
                z = true;
            }
            gVar2.uEU = z;
        }
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        if (com.tencent.mm.plugin.finder.utils.y.dCM()) {
            com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dvj()) {
                this.liveData.uEt = 1;
            }
        }
        String str4 = this.TAG;
        StringBuilder sb = new StringBuilder("processLiveSdkParams support_screen_rotate:");
        if (cja != null) {
            num = Integer.valueOf(cja.Mog);
        } else {
            num = null;
        }
        StringBuilder append = sb.append(num).append(",config:");
        com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
        Log.i(str4, append.append(com.tencent.mm.plugin.finder.storage.c.dvj()).append(", qosReport:").append(this.liveData.uET).append(", qosControl:").append(this.liveData.uEU).toString());
        AppMethodBeat.o(246050);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void a(Context context, com.tencent.mm.plugin.appbrand.api.g gVar, boolean z) {
        AppMethodBeat.i(246051);
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(gVar, "bundle");
        String str = this.TAG;
        StringBuilder append = new StringBuilder("open fullscreen miniPro appId:").append(gVar.appId).append(",patch:").append(gVar.kHw).append(",luanchFromApp:").append(z).append(",is test:");
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        Log.i(str, append.append(com.tencent.mm.plugin.finder.storage.c.dvc()).toString());
        if (Util.isNullOrNil(gVar.appId) || Util.isNullOrNil(gVar.kHw)) {
            AppMethodBeat.o(246051);
            return;
        }
        gVar.kHM = true;
        b(context, gVar, z);
        AppMethodBeat.o(246051);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void c(Context context, com.tencent.mm.plugin.appbrand.api.g gVar) {
        HalfScreenConfig halfScreenConfig;
        AppMethodBeat.i(246052);
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(gVar, "bundle");
        String str = this.TAG;
        StringBuilder append = new StringBuilder("open halfscreen miniPro appId:").append(gVar.appId).append(",patch:").append(gVar.kHw).append(",is test:");
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        Log.i(str, append.append(com.tencent.mm.plugin.finder.storage.c.dvc()).toString());
        if (Util.isNullOrNil(gVar.appId) || Util.isNullOrNil(gVar.kHw)) {
            AppMethodBeat.o(246052);
            return;
        }
        HalfScreenConfig halfScreenConfig2 = gVar.kHL;
        if (halfScreenConfig2 != null) {
            HalfScreenConfig.b bVar = new HalfScreenConfig.b();
            bVar.enable = halfScreenConfig2.isEnable();
            bVar.height = halfScreenConfig2.height;
            bVar.lfm = halfScreenConfig2.lfm;
            HalfScreenConfig.a aVar = halfScreenConfig2.lfn;
            kotlin.g.b.p.h(aVar, "activityAnimStyle");
            bVar.lfn = aVar;
            bVar.lfo = halfScreenConfig2.lfo;
            bVar.a(halfScreenConfig2.lfq);
            HalfScreenConfig.BackgroundShapeConfig backgroundShapeConfig = halfScreenConfig2.lfp;
            kotlin.g.b.p.h(backgroundShapeConfig, "bgShapeConf");
            bVar.lfp = backgroundShapeConfig;
            bVar.kuZ = halfScreenConfig2.kuZ;
            String name = context.getClass().getName();
            kotlin.g.b.p.g(name, "context.javaClass.name");
            HalfScreenConfig.b a2 = bVar.a(new HalfScreenConfig.CloseWhenClickEmptyAreaConfig(name, HalfScreenConfig.a.POPUP));
            halfScreenConfig = new HalfScreenConfig(a2.enable, a2.height, a2.lfm, a2.lfn, a2.lfo, a2.lfp, a2.kuZ, a2.lfq);
        } else {
            halfScreenConfig = null;
        }
        gVar.kHL = halfScreenConfig;
        b(context, gVar, true);
        AppMethodBeat.o(246052);
    }

    private final void b(Context context, com.tencent.mm.plugin.appbrand.api.g gVar, boolean z) {
        AppMethodBeat.i(246053);
        com.tencent.mm.plugin.finder.live.j jVar = com.tencent.mm.plugin.finder.live.j.ugg;
        com.tencent.mm.plugin.finder.live.j.a(this.liveData, gVar, z);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dvc()) {
            gVar.iOo = 1;
        } else {
            gVar.iOo = 0;
        }
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = this.liveData;
        String str = gVar.appId;
        kotlin.g.b.p.g(str, "bundle.appId");
        gVar2.atU(str);
        FinderBaseLivePluginLayout finderBaseLivePluginLayout = this.uhN;
        String str2 = gVar.appId;
        kotlin.g.b.p.g(str2, "bundle.appId");
        gVar.kHB = new com.tencent.mm.plugin.finder.live.i(finderBaseLivePluginLayout, str2);
        gVar.kHC = 1000;
        o oVar = o.ujN;
        o.b(context, gVar);
        AppMethodBeat.o(246053);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void dfk() {
        AppMethodBeat.i(246054);
        Log.i(this.TAG, "close miniPro appId:" + this.liveData.uEq);
        o oVar = o.ujN;
        Context context = MMApplicationContext.getContext();
        kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
        o.fo(context);
        AppMethodBeat.o(246054);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void a(Context context, long j2, String str, Long l2) {
        AppMethodBeat.i(260434);
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(str, ch.COL_USERNAME);
        this.liveData.uDS = false;
        com.tencent.mm.plugin.finder.feed.logic.a aVar = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
        com.tencent.mm.plugin.finder.feed.logic.a.a(context, j2, str, l2, 62);
        AppMethodBeat.o(260434);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void a(Context context, Intent intent, Integer num) {
        AppMethodBeat.i(246056);
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(intent, "intent");
        this.liveData.uDS = false;
        if (num != null) {
            com.tencent.mm.br.c.b(context, "webview", ".ui.tools.WebViewUI", intent, num.intValue());
            AppMethodBeat.o(246056);
            return;
        }
        com.tencent.mm.br.c.b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(246056);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void EH(long j2) {
        AppMethodBeat.i(246057);
        boolean contains = this.liveData.uEn.contains(Long.valueOf(j2));
        Log.i(this.TAG, "announceGotoShopping productId:" + j2 + ", haveBug:" + contains);
        if (j2 != 0 && !contains) {
            this.liveData.uEn.add(Long.valueOf(j2));
            o.c cVar = o.c.hGH;
            a("", o.c.aFv(), (l.a) null);
        }
        AppMethodBeat.o(246057);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void ag(View view, int i2) {
        AppMethodBeat.i(246058);
        kotlin.g.b.p.h(view, "view");
        com.tencent.mm.ac.d.h(new a(this, view, i2));
        AppMethodBeat.o(246058);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void dfl() {
        AppMethodBeat.i(246059);
        com.tencent.mm.ac.d.h(new x(this));
        AppMethodBeat.o(246059);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void dfm() {
        boolean z = true;
        AppMethodBeat.i(246060);
        if (this.liveData.djm()) {
            l lVar = this.uhM;
            try {
                if (Settings.System.getInt(XWalkEnvironment.getContentResolver(), "accelerometer_rotation") == 1) {
                    MMFinderUI mMFinderUI = lVar.ujj;
                    if (!(mMFinderUI == null || mMFinderUI.getRequestedOrientation() == -1)) {
                        mMFinderUI.vPS = true;
                        mMFinderUI.setRequestedOrientation(-1);
                    }
                    String str = lVar.TAG;
                    StringBuilder sb = new StringBuilder("enableAutoRotation ACCELEROMETER_ROTATION context is null:");
                    if (lVar.ujj != null) {
                        z = false;
                    }
                    Log.i(str, sb.append(z).append('!').toString());
                    AppMethodBeat.o(246060);
                    return;
                }
                Log.i(lVar.TAG, "enableAutoRotation ACCELEROMETER_ROTATION failed!");
                AppMethodBeat.o(246060);
                return;
            } catch (Exception e2) {
                Log.e(lVar.TAG, "enableAutoRotation " + e2.getMessage());
            }
        }
        AppMethodBeat.o(246060);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void dfn() {
        MMFinderUI mMFinderUI;
        Integer num;
        AppMethodBeat.i(246061);
        if (this.liveData.djm()) {
            l lVar = this.uhM;
            Resources resources = lVar.ujj.getResources();
            kotlin.g.b.p.g(resources, "context.resources");
            int i2 = resources.getConfiguration().orientation;
            if (i2 == 2) {
                MMFinderUI mMFinderUI2 = lVar.ujj;
                if (mMFinderUI2 != null) {
                    mMFinderUI2.vPS = true;
                    AppCompatActivity context = mMFinderUI2.getContext();
                    kotlin.g.b.p.g(context, "context");
                    Window window = context.getWindow();
                    kotlin.g.b.p.g(window, "context.window");
                    WindowManager windowManager = window.getWindowManager();
                    kotlin.g.b.p.g(windowManager, "context.window.windowManager");
                    Display defaultDisplay = windowManager.getDefaultDisplay();
                    kotlin.g.b.p.g(defaultDisplay, "context.window.windowManager.defaultDisplay");
                    if (defaultDisplay.getRotation() == 1) {
                        mMFinderUI2.setRequestedOrientation(0);
                    } else {
                        AppCompatActivity context2 = mMFinderUI2.getContext();
                        kotlin.g.b.p.g(context2, "context");
                        Window window2 = context2.getWindow();
                        kotlin.g.b.p.g(window2, "context.window");
                        WindowManager windowManager2 = window2.getWindowManager();
                        kotlin.g.b.p.g(windowManager2, "context.window.windowManager");
                        Display defaultDisplay2 = windowManager2.getDefaultDisplay();
                        kotlin.g.b.p.g(defaultDisplay2, "context.window.windowManager.defaultDisplay");
                        if (defaultDisplay2.getRotation() == 3) {
                            mMFinderUI2.setRequestedOrientation(8);
                        }
                    }
                }
            } else if (i2 == 1 && (mMFinderUI = lVar.ujj) != null) {
                mMFinderUI.vPS = true;
                mMFinderUI.setRequestedOrientation(1);
            }
            String str = lVar.TAG;
            StringBuilder append = new StringBuilder("lockScreenRotation curOrientation:").append(i2).append(",requestOrientation:");
            MMFinderUI mMFinderUI3 = lVar.ujj;
            if (mMFinderUI3 != null) {
                num = Integer.valueOf(mMFinderUI3.getRequestedOrientation());
            } else {
                num = null;
            }
            Log.i(str, append.append(num.intValue()).toString());
        }
        AppMethodBeat.o(246061);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final boolean dfo() {
        MMFinderUI mMFinderUI;
        Integer num;
        Resources resources;
        Configuration configuration;
        boolean z = false;
        AppMethodBeat.i(246062);
        if (this.liveData.djm()) {
            l lVar = this.uhM;
            MMFinderUI mMFinderUI2 = lVar.ujj;
            Integer valueOf = (mMFinderUI2 == null || (resources = mMFinderUI2.getResources()) == null || (configuration = resources.getConfiguration()) == null) ? null : Integer.valueOf(configuration.orientation);
            if (!(valueOf == null || valueOf.intValue() != 2 || (mMFinderUI = lVar.ujj) == null)) {
                mMFinderUI.vPS = true;
                mMFinderUI.setRequestedOrientation(1);
                z = true;
            }
            String str = lVar.TAG;
            StringBuilder append = new StringBuilder("changeScreenToPortrait curOrientation:").append(valueOf).append(",requestOrientation:");
            MMFinderUI mMFinderUI3 = lVar.ujj;
            if (mMFinderUI3 != null) {
                num = Integer.valueOf(mMFinderUI3.getRequestedOrientation());
            } else {
                num = null;
            }
            Log.i(str, append.append(num.intValue()).append(",change:").append(z).toString());
            AppMethodBeat.o(246062);
        } else {
            AppMethodBeat.o(246062);
        }
        return z;
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final boolean dfp() {
        MMFinderUI mMFinderUI;
        Integer num;
        Resources resources;
        Configuration configuration;
        boolean z = false;
        AppMethodBeat.i(246063);
        if (this.liveData.djm()) {
            l lVar = this.uhM;
            MMFinderUI mMFinderUI2 = lVar.ujj;
            Integer valueOf = (mMFinderUI2 == null || (resources = mMFinderUI2.getResources()) == null || (configuration = resources.getConfiguration()) == null) ? null : Integer.valueOf(configuration.orientation);
            if (!(valueOf == null || valueOf.intValue() != 1 || (mMFinderUI = lVar.ujj) == null)) {
                mMFinderUI.vPS = true;
                mMFinderUI.setRequestedOrientation(0);
                z = true;
            }
            String str = lVar.TAG;
            StringBuilder append = new StringBuilder("changeScreenToLandscape curOrientation:").append(valueOf).append(",requestOrientation:");
            MMFinderUI mMFinderUI3 = lVar.ujj;
            if (mMFinderUI3 != null) {
                num = Integer.valueOf(mMFinderUI3.getRequestedOrientation());
            } else {
                num = null;
            }
            Log.i(str, append.append(num.intValue()).append(",change:").append(z).toString());
            AppMethodBeat.o(246063);
        } else {
            AppMethodBeat.o(246063);
        }
        return z;
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void a(String str, com.tencent.mm.bw.b bVar, o.a aVar) {
        int aFW;
        String str2;
        Long l2;
        AppMethodBeat.i(246064);
        kotlin.g.b.p.h(str, "lotteryId");
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
            o.m mVar2 = o.m.hHB;
            aFW = o.m.aFV();
            str2 = com.tencent.mm.model.z.aUg();
            kotlin.g.b.p.g(str2, "ConfigStorageLogic.getMyFinderUsername()");
        } else {
            o.m mVar3 = o.m.hHB;
            aFW = o.m.aFW();
            str2 = "";
        }
        awe awe = this.liveData.liveInfo;
        if (awe != null) {
            l2 = Long.valueOf(awe.liveId);
        } else {
            l2 = null;
        }
        new com.tencent.mm.plugin.finder.live.model.cgi.o(aFW, str2, l2.longValue(), this.liveData.hFK, this.liveData.hIt, this.liveData.hwg, str, bVar, new s(this, aVar)).aYI();
        AppMethodBeat.o(246064);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$getLotteryRecord$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder_release"})
    public static final class s implements o.a {
        final /* synthetic */ b uhO;
        final /* synthetic */ o.a uig;

        s(b bVar, o.a aVar) {
            this.uhO = bVar;
            this.uig = aVar;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.o.a
        public final void a(int i2, int i3, String str, avy avy) {
            AppMethodBeat.i(246020);
            kotlin.g.b.p.h(avy, "resp");
            com.tencent.mm.ac.d.h(new a(this, avy, i2, i3, str));
            AppMethodBeat.o(246020);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ int $errCode;
            final /* synthetic */ String $errMsg;
            final /* synthetic */ int $errType;
            final /* synthetic */ s uih;
            final /* synthetic */ avy uii;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(s sVar, avy avy, int i2, int i3, String str) {
                super(0);
                this.uih = sVar;
                this.uii = avy;
                this.$errType = i2;
                this.$errCode = i3;
                this.$errMsg = str;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                Long l;
                awe awe;
                Long l2 = null;
                AppMethodBeat.i(246019);
                avy avy = this.uii;
                if (avy != null) {
                    long j2 = avy.liveId;
                    com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.uih.uhO.liveData;
                    if (j2 == ((gVar == null || (awe = gVar.liveInfo) == null) ? null : Long.valueOf(awe.liveId)).longValue()) {
                        o.a aVar = this.uih.uig;
                        if (aVar != null) {
                            aVar.a(this.$errType, this.$errCode, this.$errMsg, this.uii);
                        }
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(246019);
                        return xVar;
                    }
                }
                String str = this.uih.uhO.TAG;
                StringBuilder sb = new StringBuilder("getLotteryRecord invalid resp,liveId:");
                avy avy2 = this.uii;
                if (avy2 != null) {
                    l = Long.valueOf(avy2.liveId);
                } else {
                    l = null;
                }
                StringBuilder append = sb.append(l.longValue()).append(",current liveId:");
                awe awe2 = this.uih.uhO.liveData.liveInfo;
                if (awe2 != null) {
                    l2 = Long.valueOf(awe2.liveId);
                }
                Log.i(str, append.append(l2.longValue()).toString());
                o.a aVar2 = this.uih.uig;
                if (aVar2 != null) {
                    aVar2.a(3, 10123, "invalid liveId", this.uii);
                }
                kotlin.x xVar2 = kotlin.x.SXb;
                AppMethodBeat.o(246019);
                return xVar2;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void a(long j2, long j3, String str, byte[] bArr, int i2, avn avn, int i3, b.a aVar) {
        AppMethodBeat.i(246065);
        Log.i(this.TAG, "applyLinkMic liveId:" + j2 + ", objectId:" + j3 + ", nonceId:" + str + ", scene:" + i2 + ", micType:" + i3);
        aut aut = new aut();
        aut.LFz = avn;
        LinkedList<avn> linkedList = new LinkedList<>();
        linkedList.add(avn);
        aut.LFD = linkedList;
        auw auw = new auw();
        auw.LFG = i3;
        aut.LFB = com.tencent.mm.bw.b.cD(auw.toByteArray());
        aut.ybm = 20003;
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        aut.LFr = com.tencent.mm.plugin.finder.utils.y.dCV();
        new com.tencent.mm.plugin.finder.live.model.cgi.b(j2, j3, str, bArr, i2, aut, aVar).aYI();
        AppMethodBeat.o(246065);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void a(long j2, long j3, String str, byte[] bArr, int i2, avn avn, int i3, String str2, String str3, a.AbstractC1184a aVar) {
        AppMethodBeat.i(246066);
        Log.i(this.TAG, "acceptLinkMic liveId:" + j2 + ", objectId:" + j3 + ", nonceId:" + str + ", scene:" + i2 + ", micType:" + i3 + ", userId:" + str2 + ", sessionId:" + str3);
        aut aut = new aut();
        aut.session_id = str3;
        aut.LFz = avn;
        auu auu = new auu();
        auu.LFG = i3;
        auu.Lmn = str2;
        aut.LFB = com.tencent.mm.bw.b.cD(auu.toByteArray());
        aut.ybm = 20004;
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        aut.LFr = com.tencent.mm.plugin.finder.utils.y.dCV();
        new com.tencent.mm.plugin.finder.live.model.cgi.a(j2, j3, str, bArr, i2, aut, aVar).aYI();
        AppMethodBeat.o(246066);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void a(int i2, String str, String str2, d.a aVar) {
        String str3;
        String str4;
        AppMethodBeat.i(260435);
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        boolean dBP = com.tencent.mm.plugin.finder.utils.m.dBP();
        String str5 = this.TAG;
        StringBuilder append = new StringBuilder("closeLinkMic isAnchor:").append(dBP).append(", linkMicState:").append(this.liveData.uEC).append(", liveId:").append(this.liveData.liveInfo.liveId).append(", objectId:").append(this.liveData.hFK).append(", nonceId:").append(this.liveData.hwg).append(", scene:").append(i2).append(", userId:");
        com.tencent.mm.plugin.finder.live.viewmodel.e eVar = this.liveData.uEB;
        if (eVar != null) {
            str3 = eVar.uCo;
        } else {
            str3 = null;
        }
        StringBuilder append2 = append.append(str3).append(", selfSdkId:").append(this.liveData.djq()).append(", sessionId:");
        com.tencent.mm.plugin.finder.live.viewmodel.e eVar2 = this.liveData.uEB;
        if (eVar2 == null || (str4 = eVar2.sessionId) == null) {
            str4 = "";
        }
        Log.i(str5, append2.append(str4).append(", applySessionId:").append(this.liveData.uEy).toString());
        long j2 = this.liveData.liveInfo.liveId;
        long j3 = this.liveData.hFK;
        String str6 = this.liveData.hwg;
        byte[] bArr = this.liveData.hIt;
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        aut aut = new aut();
        aut.session_id = str2;
        aux aux = new aux();
        aux.Lmn = str;
        aut.LFB = com.tencent.mm.bw.b.cD(aux.toByteArray());
        aut.ybm = 20005;
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        aut.LFr = com.tencent.mm.plugin.finder.utils.y.dCV();
        new com.tencent.mm.plugin.finder.live.model.cgi.d(j2, j3, str6, bArr, i2, aut, aVar).aYI();
        AppMethodBeat.o(260435);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void a(long j2, long j3, String str, byte[] bArr, int i2, String str2, u.a aVar) {
        AppMethodBeat.i(246068);
        Log.i(this.TAG, "refreshLinkMic liveId:" + j2 + ", objectId:" + j3 + ", nonceId:" + str + ", scene:" + i2 + ", sdkUserId:" + str2);
        new com.tencent.mm.plugin.finder.live.model.cgi.u(j2, j3, str, bArr, i2, str2, aVar).aYI();
        AppMethodBeat.o(246068);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void a(long j2, long j3, String str, byte[] bArr, LinkedList<String> linkedList, ag.a aVar) {
        AppMethodBeat.i(260436);
        kotlin.g.b.p.h(linkedList, "usernameList");
        Log.i(this.TAG, "batchGetMicContact liveId:" + j2 + ", objectId:" + j3 + ", nonceId:" + str + ", scene:1");
        new ag(j2, j3, str, bArr, linkedList, aVar).aYI();
        AppMethodBeat.o(260436);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void a(long j2, long j3, String str, byte[] bArr, int i2, avn avn, String str2, int i3, ae.a aVar) {
        AppMethodBeat.i(260437);
        Log.i(this.TAG, "applyLinkMicPk liveId:" + j2 + ", objectId:" + j3 + ", nonceId:" + str + ", scene:" + i2 + ", sdkUserId:" + str2 + ", sdkLiveId:" + i3);
        aut aut = new aut();
        aut.LFz = avn;
        LinkedList<avn> linkedList = new LinkedList<>();
        linkedList.add(avn);
        aut.LFD = linkedList;
        fgh fgh = new fgh();
        fgh.ViN = str2;
        fgh.ViO = i3;
        aut.LFB = com.tencent.mm.bw.b.cD(fgh.toByteArray());
        aut.ybm = 20015;
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        aut.LFr = com.tencent.mm.plugin.finder.utils.y.dCV();
        new com.tencent.mm.plugin.finder.live.model.cgi.ae(j2, j3, str, bArr, i2, aut, aVar).aYI();
        AppMethodBeat.o(260437);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void a(long j2, long j3, String str, byte[] bArr, int i2, avn avn, String str2, int i3, String str3, ac.a aVar) {
        AppMethodBeat.i(260438);
        Log.i(this.TAG, "acceptLinkMicPk liveId:" + j2 + ", objectId:" + j3 + ", nonceId:" + str + ", scene:" + i2 + ", sdkUserId:" + str2 + ", sdkLiveId:" + i3 + ", sessionId:" + str3);
        aut aut = new aut();
        aut.LFz = avn;
        LinkedList<avn> linkedList = new LinkedList<>();
        linkedList.add(avn);
        aut.LFD = linkedList;
        aut.session_id = str3;
        fgg fgg = new fgg();
        fgg.ViN = str2;
        fgg.ViO = i3;
        aut.LFB = com.tencent.mm.bw.b.cD(fgg.toByteArray());
        aut.ybm = 20016;
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        aut.LFr = com.tencent.mm.plugin.finder.utils.y.dCV();
        new ac(j2, j3, str, bArr, i2, aut, aVar).aYI();
        AppMethodBeat.o(260438);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void a(int i2, String str, String str2, avn avn, af.a aVar) {
        AppMethodBeat.i(260439);
        Log.i(this.TAG, "closeLinkMicPk liveId:" + this.liveData.liveInfo.liveId + ", objectId:" + this.liveData.hFK + ", nonceId:" + this.liveData.hwg + ", scene:" + i2 + ", closeScene:1, sdkUserId:" + str + ", sessionId:" + str2);
        long j2 = this.liveData.liveInfo.liveId;
        long j3 = this.liveData.hFK;
        String str3 = this.liveData.hwg;
        byte[] bArr = this.liveData.hIt;
        aut aut = new aut();
        aut.LFz = avn;
        LinkedList<avn> linkedList = new LinkedList<>();
        linkedList.add(avn);
        aut.LFD = linkedList;
        aut.session_id = str2;
        fgi fgi = new fgi();
        fgi.Lmn = str;
        fgi.scene = 1;
        aut.LFB = com.tencent.mm.bw.b.cD(fgi.toByteArray());
        aut.ybm = 20017;
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        aut.LFr = com.tencent.mm.plugin.finder.utils.y.dCV();
        new com.tencent.mm.plugin.finder.live.model.cgi.af(j2, j3, str3, bArr, i2, aut, aVar).aYI();
        AppMethodBeat.o(260439);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void a(long j2, long j3, String str, byte[] bArr, String str2, ad.a aVar) {
        AppMethodBeat.i(260440);
        Log.i(this.TAG, "activateLiveMic liveId:" + j2 + ", objectId:" + j3 + ", nonceId:" + str + ", scene:1, sessionId:" + str2);
        new ad(j2, j3, str, bArr, str2, aVar).aYI();
        AppMethodBeat.o(260440);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0017\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, hxF = {"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$initEngine$1", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "", "onFailed", "", "errorType", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "msg", "", "onSuccess", "data", "(Ljava/lang/Boolean;)V", "plugin-finder_release"})
    public static final class v implements com.tencent.mm.plugin.wallet.wecoin.a.e<Boolean> {
        final /* synthetic */ b uhO;
        final /* synthetic */ kotlin.g.a.b uij = null;
        final /* synthetic */ kotlin.g.a.m uik = null;

        /* JADX WARN: Incorrect types in method signature: (Lkotlin/g/a/b;)V */
        v(b bVar) {
            this.uhO = bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.wallet.wecoin.a.e
        public final /* synthetic */ void onSuccess(Boolean bool) {
            AppMethodBeat.i(246024);
            Boolean bool2 = bool;
            Log.i(this.uhO.TAG, "[WeCoin] initEngine onSuccess");
            kotlin.g.a.b bVar = this.uij;
            if (bVar != null) {
                bVar.invoke(bool2);
                AppMethodBeat.o(246024);
                return;
            }
            AppMethodBeat.o(246024);
        }

        @Override // com.tencent.mm.plugin.wallet.wecoin.a.e
        public final void p(int i2, int i3, String str) {
            AppMethodBeat.i(246025);
            Log.i(this.uhO.TAG, "[WeCoin] initEngine onFailed");
            kotlin.g.a.m mVar = this.uik;
            if (mVar != null) {
                mVar.invoke(Integer.valueOf(i2), Integer.valueOf(i3));
                AppMethodBeat.o(246025);
                return;
            }
            AppMethodBeat.o(246025);
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void fn(Context context) {
        AppMethodBeat.i(246069);
        kotlin.g.b.p.h(context, "context");
        Log.i(this.TAG, "[WeCoin] initEngine");
        ((com.tencent.mm.plugin.wallet.wecoin.a.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.wallet.wecoin.a.c.class)).a(context, new v(this));
        AppMethodBeat.o(246069);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$getWeCoinBalance$1", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "", "onFailed", "", "errorType", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "msg", "", "onSuccess", "data", "plugin-finder_release"})
    public static final class u implements com.tencent.mm.plugin.wallet.wecoin.a.e<Long> {
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ b uhO;

        u(b bVar, kotlin.g.a.b bVar2) {
            this.uhO = bVar;
            this.gWe = bVar2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.wallet.wecoin.a.e
        public final /* synthetic */ void onSuccess(Long l) {
            AppMethodBeat.i(246022);
            long longValue = l.longValue();
            Log.i(this.uhO.TAG, "[WeCoin] getWeCoinBalance onSuccess,data:".concat(String.valueOf(longValue)));
            kotlin.g.a.b bVar = this.gWe;
            if (bVar != null) {
                bVar.invoke(Long.valueOf(longValue));
                AppMethodBeat.o(246022);
                return;
            }
            AppMethodBeat.o(246022);
        }

        @Override // com.tencent.mm.plugin.wallet.wecoin.a.e
        public final void p(int i2, int i3, String str) {
            AppMethodBeat.i(246023);
            Log.i(this.uhO.TAG, "[WeCoin] getWeCoinBalance onFailed,errorType:" + i2 + ",errorCode:" + i3 + ",msg:" + str);
            kotlin.g.a.b bVar = this.gWe;
            if (bVar != null) {
                bVar.invoke(-1L);
                AppMethodBeat.o(246023);
                return;
            }
            AppMethodBeat.o(246023);
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void E(kotlin.g.a.b<? super Long, kotlin.x> bVar) {
        AppMethodBeat.i(246070);
        Log.i(this.TAG, "[WeCoin] getWeCoinBalance");
        ((com.tencent.mm.plugin.wallet.wecoin.a.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.wallet.wecoin.a.c.class)).a(new u(this, bVar));
        AppMethodBeat.o(246070);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final com.tencent.mm.plugin.wallet.wecoin.a.d a(FragmentActivity fragmentActivity, int i2, kotlin.g.a.a<kotlin.x> aVar) {
        String str;
        AppMethodBeat.i(246071);
        kotlin.g.b.p.h(fragmentActivity, "context");
        kotlin.g.b.p.h(aVar, "callback");
        String cMG = ((com.tencent.mm.plugin.expt.b.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class)).cMG();
        if (cMG == null) {
            str = "";
        } else {
            str = cMG;
        }
        Log.i(this.TAG, "showRechargeFoodsDialog sessionId:".concat(String.valueOf(str)));
        com.tencent.mm.plugin.wallet.wecoin.a.d a2 = ((com.tencent.mm.plugin.wallet.wecoin.a.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.wallet.wecoin.a.c.class)).a(fragmentActivity, i2, str, new y(this, fragmentActivity, aVar));
        AppMethodBeat.o(246071);
        return a2;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0017\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, hxF = {"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$showRechargeFoodsDialog$1", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "", "onFailed", "", "errorType", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, OpenSDKTool4Assistant.EXTRA_ERROR_MSG, "", "onSuccess", "data", "(Ljava/lang/Boolean;)V", "plugin-finder_release"})
    public static final class y implements com.tencent.mm.plugin.wallet.wecoin.a.e<Boolean> {
        final /* synthetic */ kotlin.g.a.a ihE;
        final /* synthetic */ b uhO;
        final /* synthetic */ FragmentActivity uil;

        y(b bVar, FragmentActivity fragmentActivity, kotlin.g.a.a aVar) {
            this.uhO = bVar;
            this.uil = fragmentActivity;
            this.ihE = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.wallet.wecoin.a.e
        public final /* synthetic */ void onSuccess(Boolean bool) {
            AppMethodBeat.i(246029);
            if (kotlin.g.b.p.j(Boolean.TRUE, bool)) {
                FragmentActivity fragmentActivity = this.uil;
                kotlin.g.b.p.h(fragmentActivity, "context");
                com.tencent.mm.plugin.wallet.wecoin.a.b aP = ((com.tencent.mm.plugin.wallet.wecoin.a.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.wallet.wecoin.a.c.class)).aP(fragmentActivity);
                if (aP != null) {
                    aP.a(new a(this));
                    AppMethodBeat.o(246029);
                    return;
                }
                AppMethodBeat.o(246029);
                return;
            }
            this.ihE.invoke();
            AppMethodBeat.o(246029);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onClick"})
        static final class a implements com.tencent.mm.plugin.wallet.wecoin.a.a {
            final /* synthetic */ y uim;

            a(y yVar) {
                this.uim = yVar;
            }

            @Override // com.tencent.mm.plugin.wallet.wecoin.a.a
            public final void onClick() {
                AppMethodBeat.i(246028);
                this.uim.ihE.invoke();
                AppMethodBeat.o(246028);
            }
        }

        @Override // com.tencent.mm.plugin.wallet.wecoin.a.e
        public final void p(int i2, int i3, String str) {
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final boolean dfq() {
        AppMethodBeat.i(246072);
        boolean dfq = ((com.tencent.mm.plugin.wallet.wecoin.a.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.wallet.wecoin.a.c.class)).dfq();
        AppMethodBeat.o(246072);
        return dfq;
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void bC(Activity activity) {
        AppMethodBeat.i(260441);
        kotlin.g.b.p.h(activity, "context");
        Intent intent = new Intent();
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class);
        kotlin.g.b.p.g(af, "MMKernel.service(IHellBizService::class.java)");
        String cMG = ((com.tencent.mm.plugin.expt.b.c) af).cMG();
        if (cMG == null) {
            cMG = "";
        }
        intent.putExtra("key_live_anchor_type", Util.isEqual(this.liveData.hIv.Mop, this.liveData.djq()) ? 1 : 2);
        intent.putExtra("key_live_id", com.tencent.mm.ac.d.zs(this.liveData.liveInfo.liveId));
        intent.putExtra("key_live_attach", this.liveData.UQm.UQM);
        intent.putExtra("key_from", 3);
        intent.putExtra("key_session_id", cMG);
        com.tencent.mm.br.c.b(activity, "luckymoney", ".ui.LuckyMoneyPrepareUI", intent);
        Log.i(this.TAG, "goPrepareLuckyMoney liveId:" + this.liveData.liveInfo.liveId + ", clientBuff:" + this.liveData.UQm.UQM + ", sessionId:" + cMG);
        AppMethodBeat.o(260441);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0172  */
    @Override // com.tencent.mm.plugin.finder.live.model.s
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.app.Activity r9, com.tencent.mm.protocal.protobuf.fgy r10, android.os.ResultReceiver r11, kotlin.g.a.b<? super java.lang.Integer, kotlin.x> r12) {
        /*
        // Method dump skipped, instructions count: 373
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.model.b.a(android.app.Activity, com.tencent.mm.protocal.protobuf.fgy, android.os.ResultReceiver, kotlin.g.a.b):void");
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void g(Activity activity, boolean z) {
        AppMethodBeat.i(260443);
        kotlin.g.b.p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
        Intent intent = new Intent();
        LinkedList<aus> linkedList = this.liveData.UQj;
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(linkedList, 10));
        Iterator<T> it = linkedList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toByteArray());
        }
        intent.putExtra("KEY_VISITOR_ROLE_LIST", arrayList);
        intent.putExtra("KEY_VISITOR_ROLE", this.liveData.UQi);
        intent.putExtra("KEY_MODIFY_TIME", this.liveData.UQk);
        com.tencent.mm.plugin.finder.utils.a.b(activity, intent, z);
        AppMethodBeat.o(260443);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final boolean b(com.tencent.mm.plugin.finder.live.plugin.d dVar) {
        AppMethodBeat.i(260444);
        kotlin.g.b.p.h(dVar, "plugin");
        int i2 = this.liveData.UQh.LFy;
        this.liveData.hUc();
        int i3 = this.liveData.UQh.LFy;
        Log.i(this.TAG, "checkVisitorRoleType oriVisitorRoleType:" + i2 + ",newVisitorRoleType:" + i3);
        if (i2 == i3 || i3 == 4) {
            AppMethodBeat.o(260444);
            return false;
        }
        hn hnVar = new hn();
        hnVar.dLW.id = this.liveData.liveInfo.liveId;
        hnVar.dLW.type = 14;
        EventCenter.instance.publish(hnVar);
        AppMethodBeat.o(260444);
        return true;
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void W(boolean z, String str) {
        AppMethodBeat.i(260445);
        kotlin.g.b.p.h(str, "finderUsername");
        Intent intent = new Intent();
        intent.putExtra("key_from_profile_share_scene", 0);
        if (!z) {
            intent.putExtra("finder_username", str);
        } else if (Util.isNullOrNil(this.liveData.hwd)) {
            intent.putExtra("finder_username", "");
            intent.putExtra("key_finder_object_Id", this.liveData.hFK);
            intent.putExtra("key_finder_object_nonce_id_key", this.liveData.hwg);
        } else {
            intent.putExtra("finder_username", this.liveData.hwd);
        }
        intent.putExtra("key_enter_profile_type", 11);
        ((aj) com.tencent.mm.kernel.g.ah(aj.class)).enterFinderProfileUI(this.uhN.getContext(), intent);
        AppMethodBeat.o(260445);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void k(Object obj, String str) {
        Object obj2;
        AppMethodBeat.i(260446);
        kotlin.g.b.p.h(str, "keyUsername");
        if (!(obj instanceof Bundle)) {
            obj2 = null;
        } else {
            obj2 = obj;
        }
        Bundle bundle = (Bundle) obj2;
        if (bundle != null) {
            String string = bundle.getString(str);
            String str2 = string;
            if (!(str2 == null || str2.length() == 0)) {
                s.a.a((s) this, false, string);
                AppMethodBeat.o(260446);
                return;
            }
            Log.i(this.TAG, "goToFinderProfileImpl finderUsername:".concat(String.valueOf(string)));
            AppMethodBeat.o(260446);
            return;
        }
        AppMethodBeat.o(260446);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void a(List<String> list, FinderItem finderItem) {
        AppMethodBeat.i(260447);
        kotlin.g.b.p.h(list, "toUser");
        kotlin.g.b.p.h(finderItem, "feedObject");
        Log.i(this.TAG, "[autoTransMmitLive] group size:" + list.size());
        k.b bVar = new k.b();
        com.tencent.mm.plugin.i.a.b bVar2 = new com.tencent.mm.plugin.i.a.b();
        bVar2.b(finderItem.getFinderLive());
        bVar.a(bVar2);
        bVar.type = 63;
        bVar.title = MMApplicationContext.getContext().getString(R.string.enf);
        bVar.url = MMApplicationContext.getContext().getString(R.string.eng);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            w.a.aSz().a(bVar, "", "", it.next(), "", null);
        }
        AppMethodBeat.o(260447);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void a(long j2, long j3, String str, byte[] bArr, String str2) {
        AppMethodBeat.i(260448);
        new com.tencent.mm.plugin.finder.live.model.cgi.aj(j2, j3, str, bArr, str2).aYI();
        AppMethodBeat.o(260448);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.s
    public final void a(long j2, long j3, String str, byte[] bArr, int i2, List<String> list, ai.a aVar) {
        AppMethodBeat.i(260449);
        kotlin.g.b.p.h(str, "nonceId");
        kotlin.g.b.p.h(list, "sendIdList");
        new com.tencent.mm.plugin.finder.live.model.cgi.ai(j2, j3, str, bArr, i2, list, aVar).aYI();
        AppMethodBeat.o(260449);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ View hCI;
        final /* synthetic */ b uhO;
        final /* synthetic */ int uhP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(b bVar, View view, int i2) {
            super(0);
            this.uhO = bVar;
            this.hCI = view;
            this.uhP = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(245997);
            this.uhO.uhL.add(new kotlin.o<>(this.hCI, Integer.valueOf(this.uhP)));
            Log.i(this.uhO.TAG, "cache view:" + this.hCI.getClass().getSimpleName() + " visibility:" + this.uhP);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(245997);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class x extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ b uhO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        x(b bVar) {
            super(0);
            this.uhO = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(246027);
            for (T t : this.uhO.uhL) {
                A a2 = t.first;
                int intValue = t.second.intValue();
                if (a2 != null) {
                    a2.setVisibility(intValue);
                }
                Log.i(this.uhO.TAG, "resume view:" + a2.getClass().getSimpleName() + " visibility:" + intValue);
            }
            this.uhO.uhL.clear();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(246027);
            return xVar;
        }
    }
}
