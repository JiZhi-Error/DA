package com.tencent.mm.plugin.finder.live.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.b.v;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.live.core.core.e;
import com.tencent.mm.live.view.BaseLivePluginLayout;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorWithoutAffinityUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitor;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorWithoutAffinityUI;
import com.tencent.mm.plugin.finder.live.component.j;
import com.tencent.mm.plugin.finder.live.model.cgi.ai;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.widget.m;
import com.tencent.mm.plugin.finder.storage.ar;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.ad;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.mmsight.model.d;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.avq;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awr;
import com.tencent.mm.protocal.protobuf.fgt;
import com.tencent.mm.protocal.protobuf.fgy;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000Æ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ0\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020'2\u0006\u0010k\u001a\u00020\u00132\u0006\u0010l\u001a\u00020\u00132\u0006\u0010m\u001a\u00020\u00132\u0006\u0010n\u001a\u00020\u0019H\u0016J\"\u0010o\u001a\u00020i2\u0006\u0010p\u001a\u00020\u00192\u0006\u0010q\u001a\u00020\u00192\b\u0010r\u001a\u0004\u0018\u00010sH\u0016J\"\u0010t\u001a\u00020i2\u0006\u0010&\u001a\u00020'2\u0006\u0010H\u001a\u00020I2\b\b\u0002\u00100\u001a\u00020\u0013H\u0016J\b\u0010u\u001a\u00020\u0013H\u0002J\u0006\u0010v\u001a\u00020iJ\u0006\u0010w\u001a\u00020iJ\u0010\u0010x\u001a\u00020i2\b\u0010y\u001a\u0004\u0018\u00010\rJ\b\u0010z\u001a\u00020iH\u0016J\u0006\u0010{\u001a\u00020iJ\u0006\u0010|\u001a\u00020iJ-\u0010}\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002050~j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u000205`2\u0007\u0010\u0001\u001a\u00020\u0019H\u0002J.\u0010\u0001\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002050~j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u000205`2\u0007\u0010\u0001\u001a\u00020\u0019H\u0002J\u0019\u0010\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u00010:j\t\u0012\u0005\u0012\u00030\u0001`<J\u001c\u0010\u0001\u001a\u00020i2\b\u0010\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010\rJ\u0012\u0010\u0001\u001a\u00020i2\u0007\u0010\u0001\u001a\u00020\u0019H\u0002J\u0007\u0010\u0001\u001a\u00020iJ\u0007\u0010\u0001\u001a\u00020iJ\u0007\u0010\u0001\u001a\u00020iJ\u001a\u0010\u0001\u001a\u00020i2\u0007\u0010j\u001a\u00030\u00012\u0006\u0010k\u001a\u00020\u0013H\u0016J\u0007\u0010\u0001\u001a\u00020\u0013J\u0007\u0010\u0001\u001a\u00020\u0013J\u0007\u0010\u0001\u001a\u00020\u0013J\t\u0010\u0001\u001a\u00020\u0013H\u0016J\t\u0010\u0001\u001a\u00020iH\u0016J\u0007\u0010\u0001\u001a\u00020\u0013J\u0007\u0010\u0001\u001a\u00020\u0013J\u0007\u0010\u0001\u001a\u00020iJ\u0007\u0010\u0001\u001a\u00020iJ\u0013\u0010\u0001\u001a\u00020i2\b\u0010\u0001\u001a\u00030\u0001H\u0017J\t\u0010\u0001\u001a\u00020iH\u0016J\u0014\u0010\u0001\u001a\u00020i2\t\u0010\u0001\u001a\u0004\u0018\u00010\rH\u0016J&\u0010\u0001\u001a\u00020i2\u0007\u0010\u0001\u001a\u00020\u00192\u0007\u0010 \u0001\u001a\u00020\u00192\t\u0010&\u001a\u0005\u0018\u00010¡\u0001H\u0016J\u0012\u0010¢\u0001\u001a\u00020i2\u0007\u0010£\u0001\u001a\u00020\u0013H\u0016J\u0013\u0010¤\u0001\u001a\u00020i2\b\u0010\u0001\u001a\u00030¥\u0001H\u0016J\t\u0010¦\u0001\u001a\u00020iH\u0016J\t\u0010§\u0001\u001a\u00020iH\u0016J\u0013\u0010¨\u0001\u001a\u00020i2\b\u0010\u0001\u001a\u00030©\u0001H\u0016J\u0013\u0010ª\u0001\u001a\u00020i2\b\u0010\u0001\u001a\u00030«\u0001H\u0016J\u0013\u0010¬\u0001\u001a\u00020i2\b\u0010\u0001\u001a\u00030­\u0001H\u0016J\u0013\u0010®\u0001\u001a\u00020i2\b\u0010\u0001\u001a\u00030¯\u0001H\u0016J\u0013\u0010°\u0001\u001a\u00020i2\b\u0010\u0001\u001a\u00030±\u0001H\u0016J\u0013\u0010²\u0001\u001a\u00020i2\b\u0010\u0001\u001a\u00030³\u0001H\u0016J\u0013\u0010´\u0001\u001a\u00020i2\b\u0010\u0001\u001a\u00030µ\u0001H\u0016J-\u0010¶\u0001\u001a\u00020i2\u0006\u0010p\u001a\u00020\u00192\u0006\u0010q\u001a\u00020\u00192\b\u0010r\u001a\u0004\u0018\u00010s2\n\u0010·\u0001\u001a\u0005\u0018\u00010¸\u0001J/\u0010¹\u0001\u001a\u00020i2\u0006\u0010p\u001a\u00020\u00192\u0006\u0010q\u001a\u00020\u00192\b\u0010r\u001a\u0004\u0018\u00010s2\n\u0010·\u0001\u001a\u0005\u0018\u00010¸\u0001H\u0002J\u001d\u0010º\u0001\u001a\u00020i2\u0007\u0010»\u0001\u001a\u00020\u00192\t\u0010¼\u0001\u001a\u0004\u0018\u00010sH&J\u0013\u0010½\u0001\u001a\u00020i2\b\u0010\u0001\u001a\u00030¾\u0001H\u0016J\u0015\u0010¿\u0001\u001a\u00020i2\n\u0010À\u0001\u001a\u0005\u0018\u00010¡\u0001H\u0016J\u0013\u0010Á\u0001\u001a\u00020i2\b\u0010\u0001\u001a\u00030Â\u0001H\u0017J\u0012\u0010Ã\u0001\u001a\u00020i2\u0007\u0010Ä\u0001\u001a\u00020\u0019H\u0016J-\u0010Å\u0001\u001a\u00020i2\u0006\u0010p\u001a\u00020\u00192\u0006\u0010q\u001a\u00020\u00192\b\u0010r\u001a\u0004\u0018\u00010s2\n\u0010·\u0001\u001a\u0005\u0018\u00010¸\u0001J/\u0010Æ\u0001\u001a\u00020i2\u0006\u0010p\u001a\u00020\u00192\u0006\u0010q\u001a\u00020\u00192\b\u0010r\u001a\u0004\u0018\u00010s2\n\u0010·\u0001\u001a\u0005\u0018\u00010¸\u0001H\u0002J\u0012\u0010Ç\u0001\u001a\u00020i2\u0007\u0010È\u0001\u001a\u00020\u0013H\u0016J\t\u0010É\u0001\u001a\u00020iH&J\u0011\u0010Ê\u0001\u001a\u00020i2\u0006\u0010l\u001a\u00020\u0013H\u0016J\t\u0010Ë\u0001\u001a\u00020iH\u0016J2\u0010Ì\u0001\u001a\u00020\u00132\b\u0010\u0001\u001a\u00030\u00012\t\u0010Í\u0001\u001a\u0004\u0018\u00010\r2\t\u0010Î\u0001\u001a\u0004\u0018\u00010\r2\t\u0010Ï\u0001\u001a\u0004\u0018\u00010\rJ\u0011\u0010Ð\u0001\u001a\u00020i2\b\u0010\u0001\u001a\u00030\u0001J\u0007\u0010Ñ\u0001\u001a\u00020iJ\u0013\u0010Ò\u0001\u001a\u00020i2\n\u0010Ó\u0001\u001a\u0005\u0018\u00010Ô\u0001J\u0019\u0010Õ\u0001\u001a\u00020i2\u0007\u0010Ö\u0001\u001a\u00020\r2\u0007\u0010×\u0001\u001a\u00020\u0019J\u0010\u0010Ø\u0001\u001a\u00020i2\u0007\u0010Î\u0001\u001a\u00020\rJ\u0007\u0010Ù\u0001\u001a\u00020iJ\u0013\u0010Ú\u0001\u001a\u00020i2\n\b\u0002\u0010y\u001a\u0004\u0018\u00010\rJ\u0010\u0010Û\u0001\u001a\u00020i2\u0007\u0010Ü\u0001\u001a\u00020\rJ\u0015\u0010Ý\u0001\u001a\u00020i2\n\u0010Ó\u0001\u001a\u0005\u0018\u00010Ô\u0001H\u0004J\u001c\u0010Þ\u0001\u001a\u00020i2\n\b\u0002\u0010y\u001a\u0004\u0018\u00010\r2\u0007\u0010ß\u0001\u001a\u00020\rJ\u001a\u0010à\u0001\u001a\u00020i2\u0006\u0010\u0005\u001a\u00020\u00062\t\u0010Î\u0001\u001a\u0004\u0018\u00010\rJ\u0013\u0010á\u0001\u001a\u00020i2\n\u0010Ó\u0001\u001a\u0005\u0018\u00010Ô\u0001J\t\u0010â\u0001\u001a\u00020iH\u0016J\u001e\u0010ã\u0001\u001a\u00020i2\b\u0010ä\u0001\u001a\u00030å\u00012\t\u0010¼\u0001\u001a\u0004\u0018\u00010sH\u0016J\t\u0010æ\u0001\u001a\u00020iH\u0016J\t\u0010ç\u0001\u001a\u00020iH\u0016R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001a\u0010!\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0016\u0010,\u001a\u0004\u0018\u00010-8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0015\"\u0004\b1\u0010\u0017R\u001a\u00102\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0015\"\u0004\b3\u0010\u0017R\u000e\u00104\u001a\u000205X\u000e¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001b\"\u0004\b8\u0010\u001dR$\u00109\u001a\u0012\u0012\u0004\u0012\u00020;0:j\b\u0012\u0004\u0012\u00020;`<X\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001b\"\u0004\bA\u0010\u001dR\u001a\u0010B\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001b\"\u0004\bD\u0010\u001dR\u001a\u0010E\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u001b\"\u0004\bG\u0010\u001dR\u001a\u0010H\u001a\u00020IX.¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001a\u0010N\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0015\"\u0004\bP\u0010\u0017R\u001c\u0010Q\u001a\u0004\u0018\u00010RX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u000e\u0010W\u001a\u00020XX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010Y\u001a\u00020ZX\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\R\u000e\u0010]\u001a\u00020^X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020`X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010a\u001a\u0004\u0018\u00010bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u000e\u0010g\u001a\u00020^X\u0004¢\u0006\u0002\n\u0000¨\u0006è\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "Lcom/tencent/mm/live/view/BaseLivePluginLayout;", "Lcom/tencent/mm/plugin/finder/live/view/IFinderLivePluginLayout;", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener$OrienChangeCallback;", "Lcom/tencent/mm/plugin/finder/live/model/mic/ILinkMicTimeoutTimer;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "FADE_OUT_DURATION", "", "TAG", "", "alertDialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "blurBgView", "Landroid/widget/ImageView;", "checkMiniWin", "", "getCheckMiniWin", "()Z", "setCheckMiniWin", "(Z)V", "curNetworkQuality", "", "getCurNetworkQuality", "()I", "setCurNetworkQuality", "(I)V", "curNetworkType", "getCurNetworkType", "setCurNetworkType", "currentAppId", "getCurrentAppId", "()Ljava/lang/String;", "setCurrentAppId", "(Ljava/lang/String;)V", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "getData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "setData", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;)V", "finderLiveAssistant", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "getFinderLiveAssistant", "()Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "isCurLive", "setCurLive", "isManualClosed", "setManualClosed", "lastContentRect", "Landroid/graphics/Rect;", "lastLiveState", "getLastLiveState", "setLastLiveState", "lastMicUserList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "Lkotlin/collections/ArrayList;", "getLastMicUserList", "()Ljava/util/ArrayList;", "lastOrientation", "getLastOrientation", "setLastOrientation", "lastRotationFromSensor", "getLastRotationFromSensor", "setLastRotationFromSensor", "lastUIState", "getLastUIState", "setLastUIState", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;)V", "miniWinPermission", "getMiniWinPermission", "setMiniWinPermission", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "getOrientationEventListener", "()Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "setOrientationEventListener", "(Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;)V", "phoneStatelistener", "Landroid/telephony/PhoneStateListener;", "previewRoot", "Landroid/widget/RelativeLayout;", "getPreviewRoot", "()Landroid/widget/RelativeLayout;", "progressTips", "Landroid/widget/TextView;", "progressView", "Landroid/view/View;", "statisticsWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveStatisticsWidget;", "getStatisticsWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveStatisticsWidget;", "setStatisticsWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveStatisticsWidget;)V", "tipView", "activate", "", "config", "isFinished", "isFromFloat", "restart", "curIndex", "applyState", "liveState", "uiState", "extraMsg", "Landroid/os/Bundle;", "bindData", "diffMicUsers", "disableRatation", "enableRotation", "fillBlurBg", ch.COL_USERNAME, "finish", "forceScreenToLandscape", "forceScreenToPortrait", "genAudienceMicMap", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "topMargin", "genPkMicMap", "getPlugins", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "goGetLuckMoney", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "redPacketId", "handleRecvLuckyMoneyErr", "errCode", "hideLoadingLayer", "hideProgress", "hideStatistics", "initLogic", "Lcom/tencent/mm/live/api/LiveConfig;", "isDestroyed", "isLiveFinished", "isLiveStarted", "isSwipeBack", "mount", "needMiniWindow", "needRemoveActivity", "notifyAudienceMicUserChange", "notifyPKMicUserChange", "onAcceptLiveMic", "info", "Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "onAcceptMicPkTimeout", "onAcceptMicTimeout", "micId", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "onAnchorConnectionChange", "anchorConnectionChange", "onApplyLiveMic", "Lcom/tencent/mm/live/model/ApplyLiveMicInfo;", "onApplyMicPkTimeout", "onApplyMicTimeout", "onBanLiveComment", "Lcom/tencent/mm/live/model/BanLiveCommentInfo;", "onCloseApplyLiveMic", "Lcom/tencent/mm/live/model/CloseApplyLiveMicInfo;", "onCloseLive", "Lcom/tencent/mm/live/model/CloseLiveInfo;", "onCloseLiveMic", "Lcom/tencent/mm/live/model/CloseLiveMicInfo;", "onFinderLiveAcceptLiveMic", "Lcom/tencent/mm/live/model/FinderLiveAcceptLiveMicInfo;", "onFinderLiveApplyLiveMic", "Lcom/tencent/mm/live/model/FinderLiveApplyLiveMicInfo;", "onFinderLiveCloseLiveMic", "Lcom/tencent/mm/live/model/FinderLiveCloseLiveMicInfo;", "onLandscapeAction", "extraData", "", "onLandscapeActionImpl", "onLiveEventCallback", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "param", "onLiveMicSucc", "Lcom/tencent/mm/live/model/LiveMicSuccessInfo;", "onNewIntent", "intent", "onOnlineLiveList", "Lcom/tencent/mm/live/model/OnlineLiveListInfo;", "onOrientationChange", "orientation", "onPortraitAction", "onPortraitActionImpl", "onScreenClear", "clear", "release", "reset", "resume", "showAlertDialog", "title", "content", "buttonTitle", "showAlertInfo", "showBlurBg", "showCDNStatistics", "qosInfo", "Lcom/tencent/mm/live/core/core/model/LiveQosInfo;", "showCenterCustomizeToast", "msg", ShareConstants.RES_PATH, "showDebugToast", "showProgress", "showProgressWithBlurBg", "showProgressWithTips", "tips", "showStatistics", "showTipWithBlurBg", "tip", "showToast", "showTrtcStatistics", "start", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "stop", "unMount", "plugin-finder_release"})
public abstract class FinderBaseLivePluginLayout extends BaseLivePluginLayout implements com.tencent.mm.plugin.finder.live.model.a.a, d.a {
    private final long FADE_OUT_DURATION = 300;
    private final String TAG = "Finder.FinderBaseLivePluginLayout";
    private HashMap _$_findViewCache;
    private byte _hellAccFlag_;
    private com.tencent.mm.ui.widget.a.d alertDialog;
    private final ImageView blurBgView;
    private boolean checkMiniWin;
    private int curNetworkQuality;
    private int curNetworkType;
    private String currentAppId = "";
    public com.tencent.mm.plugin.finder.live.viewmodel.c data;
    private boolean isCurLive;
    private boolean isManualClosed;
    private Rect lastContentRect;
    private int lastLiveState;
    private final ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.e> lastMicUserList;
    private int lastOrientation;
    private int lastRotationFromSensor;
    private int lastUIState;
    public com.tencent.mm.plugin.finder.live.viewmodel.g liveData;
    private boolean miniWinPermission;
    private com.tencent.mm.plugin.mmsight.model.d orientationEventListener;
    private final PhoneStateListener phoneStatelistener;
    private final RelativeLayout previewRoot;
    private final TextView progressTips;
    private final View progressView;
    private m statisticsWidget;
    private final TextView tipView;

    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    public View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public abstract void onLiveEventCallback(int i2, Bundle bundle);

    public abstract void release();

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class a extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ String hLl;
        final /* synthetic */ FinderBaseLivePluginLayout uxy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(FinderBaseLivePluginLayout finderBaseLivePluginLayout, String str) {
            super(1);
            this.uxy = finderBaseLivePluginLayout;
            this.hLl = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(247311);
            bool.booleanValue();
            Log.i(this.uxy.TAG, "showBlurBg username:" + this.hLl);
            x xVar = x.SXb;
            AppMethodBeat.o(247311);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderBaseLivePluginLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        e.h hVar = e.h.hya;
        this.curNetworkQuality = e.h.aCT();
        this.curNetworkType = -1;
        this.lastRotationFromSensor = -1;
        this.lastOrientation = -1;
        this.lastMicUserList = new ArrayList<>();
        this.lastLiveState = -1;
        this.lastUIState = -1;
        this.lastContentRect = new Rect(0, 0, au.az(context).x, au.az(context).y);
        this.phoneStatelistener = new d(this);
        View findViewById = findViewById(R.id.ei4);
        p.g(findViewById, "findViewById(R.id.live_loading_blur)");
        this.blurBgView = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.ei3);
        p.g(findViewById2, "findViewById(R.id.live_loading_bar)");
        this.progressView = findViewById2;
        View findViewById3 = findViewById(R.id.k09);
        p.g(findViewById3, "findViewById(R.id.live_loading_tips)");
        this.progressTips = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.fuw);
        p.g(findViewById4, "findViewById(R.id.network_error_tip)");
        this.tipView = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.jyn);
        p.g(findViewById5, "findViewById(R.id.finder_live_preview_root)");
        this.previewRoot = (RelativeLayout) findViewById5;
    }

    public final com.tencent.mm.plugin.finder.live.viewmodel.c getData() {
        com.tencent.mm.plugin.finder.live.viewmodel.c cVar = this.data;
        if (cVar == null) {
            p.btv("data");
        }
        return cVar;
    }

    public final void setData(com.tencent.mm.plugin.finder.live.viewmodel.c cVar) {
        p.h(cVar, "<set-?>");
        this.data = cVar;
    }

    public final com.tencent.mm.plugin.finder.live.viewmodel.g getLiveData() {
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.liveData;
        if (gVar == null) {
            p.btv("liveData");
        }
        return gVar;
    }

    public final void setLiveData(com.tencent.mm.plugin.finder.live.viewmodel.g gVar) {
        p.h(gVar, "<set-?>");
        this.liveData = gVar;
    }

    public s getFinderLiveAssistant() {
        o oVar = o.ujN;
        return o.getFinderLiveAssistant();
    }

    public final String getCurrentAppId() {
        return this.currentAppId;
    }

    public final void setCurrentAppId(String str) {
        p.h(str, "<set-?>");
        this.currentAppId = str;
    }

    public final int getCurNetworkQuality() {
        return this.curNetworkQuality;
    }

    public final void setCurNetworkQuality(int i2) {
        this.curNetworkQuality = i2;
    }

    public final int getCurNetworkType() {
        return this.curNetworkType;
    }

    public final void setCurNetworkType(int i2) {
        this.curNetworkType = i2;
    }

    public final com.tencent.mm.plugin.mmsight.model.d getOrientationEventListener() {
        return this.orientationEventListener;
    }

    public final void setOrientationEventListener(com.tencent.mm.plugin.mmsight.model.d dVar) {
        this.orientationEventListener = dVar;
    }

    public final int getLastRotationFromSensor() {
        return this.lastRotationFromSensor;
    }

    public final void setLastRotationFromSensor(int i2) {
        this.lastRotationFromSensor = i2;
    }

    public final int getLastOrientation() {
        return this.lastOrientation;
    }

    public final void setLastOrientation(int i2) {
        this.lastOrientation = i2;
    }

    /* access modifiers changed from: protected */
    public final RelativeLayout getPreviewRoot() {
        return this.previewRoot;
    }

    /* access modifiers changed from: protected */
    public final ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.e> getLastMicUserList() {
        return this.lastMicUserList;
    }

    public final int getLastLiveState() {
        return this.lastLiveState;
    }

    public final void setLastLiveState(int i2) {
        this.lastLiveState = i2;
    }

    public final int getLastUIState() {
        return this.lastUIState;
    }

    public final void setLastUIState(int i2) {
        this.lastUIState = i2;
    }

    /* access modifiers changed from: protected */
    public final boolean isManualClosed() {
        return this.isManualClosed;
    }

    /* access modifiers changed from: protected */
    public final void setManualClosed(boolean z) {
        this.isManualClosed = z;
    }

    /* access modifiers changed from: protected */
    public final boolean getCheckMiniWin() {
        return this.checkMiniWin;
    }

    /* access modifiers changed from: protected */
    public final void setCheckMiniWin(boolean z) {
        this.checkMiniWin = z;
    }

    /* access modifiers changed from: protected */
    public final boolean getMiniWinPermission() {
        return this.miniWinPermission;
    }

    /* access modifiers changed from: protected */
    public final void setMiniWinPermission(boolean z) {
        this.miniWinPermission = z;
    }

    /* access modifiers changed from: protected */
    public final boolean isCurLive() {
        return this.isCurLive;
    }

    /* access modifiers changed from: protected */
    public final void setCurLive(boolean z) {
        this.isCurLive = z;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout$phoneStatelistener$1", "Landroid/telephony/PhoneStateListener;", "onCallStateChanged", "", "state", "", "incomingNumber", "", "plugin-finder_release"})
    public static final class d extends PhoneStateListener {
        final /* synthetic */ FinderBaseLivePluginLayout uxy;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(FinderBaseLivePluginLayout finderBaseLivePluginLayout) {
            this.uxy = finderBaseLivePluginLayout;
        }

        public final void onCallStateChanged(int i2, String str) {
            AppMethodBeat.i(247315);
            p.h(str, "incomingNumber");
            this.uxy.onCallStateChanged(i2, str);
            AppMethodBeat.o(247315);
        }
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        Log.i(this.TAG, "onActivityResult,requestCode:" + i2 + ",resultCode:" + i3);
    }

    public final void fillBlurBg(String str) {
        awe awe;
        FinderObjectDesc finderObjectDesc;
        avq avq;
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.liveData;
        if (gVar == null) {
            p.btv("liveData");
        }
        FinderObject finderObject = gVar.uDz;
        String str2 = (finderObject == null || (finderObjectDesc = finderObject.objectDesc) == null || (avq = finderObjectDesc.liveDesc) == null) ? null : avq.uEu;
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = this.liveData;
        if (gVar2 == null) {
            p.btv("liveData");
        }
        FinderObject finderObject2 = gVar2.uDz;
        if (!(finderObject2 == null || (awe = finderObject2.liveInfo) == null || awe.Vjf != 1)) {
            String str3 = str2;
            if (!(str3 == null || str3.length() == 0)) {
                ((aj) com.tencent.mm.kernel.g.ah(aj.class)).loadImage(str2, this.blurBgView);
                Log.i(this.TAG, "showThumbUrlBg username:" + str + ", url:" + str2);
                return;
            }
        }
        com.tencent.mm.plugin.finder.live.util.g gVar3 = com.tencent.mm.plugin.finder.live.util.g.uwd;
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar4 = this.liveData;
        if (gVar4 == null) {
            p.btv("liveData");
        }
        com.tencent.mm.plugin.finder.live.util.g.a(str, gVar4.uEu, this.blurBgView, new a(this, str));
    }

    public static /* synthetic */ void showProgressWithBlurBg$default(FinderBaseLivePluginLayout finderBaseLivePluginLayout, String str, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showProgressWithBlurBg");
        }
        if ((i2 & 1) != 0) {
            str = "";
        }
        finderBaseLivePluginLayout.showProgressWithBlurBg(str);
    }

    public final void showProgressWithBlurBg(String str) {
        ImageView imageView = this.blurBgView;
        Context context = getContext();
        p.g(context, "context");
        imageView.setElevation((float) context.getResources().getDimensionPixelSize(R.dimen.a_x));
        this.progressView.setVisibility(0);
        this.progressTips.setVisibility(8);
        this.tipView.setVisibility(8);
        requestLayout();
    }

    public static /* synthetic */ void showTipWithBlurBg$default(FinderBaseLivePluginLayout finderBaseLivePluginLayout, String str, String str2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showTipWithBlurBg");
        }
        if ((i2 & 1) != 0) {
            str = "";
        }
        finderBaseLivePluginLayout.showTipWithBlurBg(str, str2);
    }

    public final void showTipWithBlurBg(String str, String str2) {
        p.h(str2, "tip");
        ImageView imageView = this.blurBgView;
        Context context = getContext();
        p.g(context, "context");
        imageView.setElevation((float) context.getResources().getDimensionPixelSize(R.dimen.a_x));
        this.progressView.setVisibility(8);
        this.progressTips.setVisibility(8);
        this.tipView.setVisibility(0);
        this.tipView.setText(str2);
        requestLayout();
    }

    public final void showProgress() {
        ImageView imageView = this.blurBgView;
        Context context = getContext();
        p.g(context, "context");
        imageView.setElevation((float) context.getResources().getDimensionPixelSize(R.dimen.a_w));
        this.progressView.setVisibility(0);
        this.progressTips.setVisibility(8);
        this.tipView.setVisibility(8);
        requestLayout();
    }

    public final void showProgressWithTips(String str) {
        p.h(str, "tips");
        ImageView imageView = this.blurBgView;
        Context context = getContext();
        p.g(context, "context");
        imageView.setElevation((float) context.getResources().getDimensionPixelSize(R.dimen.a_w));
        this.progressView.setVisibility(0);
        this.progressTips.setVisibility(0);
        this.progressTips.setText(str);
        this.tipView.setVisibility(8);
        requestLayout();
    }

    public final void hideProgress() {
        this.progressView.setVisibility(8);
        this.progressTips.setVisibility(8);
    }

    public final void showBlurBg() {
        ImageView imageView = this.blurBgView;
        Context context = getContext();
        p.g(context, "context");
        imageView.setElevation((float) context.getResources().getDimensionPixelSize(R.dimen.a_x));
        this.tipView.setVisibility(8);
    }

    public final void hideLoadingLayer() {
        Log.printInfoStack(this.TAG, "hideLoading", new Object[0]);
        ValueAnimator ofFloat = ObjectAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addUpdateListener(new b(this));
        ofFloat.addListener(new c(this));
        ofFloat.start();
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout$hideLoadingLayer$1$1"})
    static final class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ FinderBaseLivePluginLayout uxy;

        b(FinderBaseLivePluginLayout finderBaseLivePluginLayout) {
            this.uxy = finderBaseLivePluginLayout;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(247312);
            p.g(valueAnimator, LocaleUtil.ITALIAN);
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(247312);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            this.uxy.blurBgView.setAlpha(floatValue);
            this.uxy.progressView.setAlpha(floatValue);
            this.uxy.tipView.setAlpha(floatValue);
            AppMethodBeat.o(247312);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout$hideLoadingLayer$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-finder_release"})
    public static final class c extends AnimatorListenerAdapter {
        final /* synthetic */ FinderBaseLivePluginLayout uxy;

        c(FinderBaseLivePluginLayout finderBaseLivePluginLayout) {
            this.uxy = finderBaseLivePluginLayout;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(247313);
            this.uxy.blurBgView.setAlpha(1.0f);
            this.uxy.progressView.setAlpha(1.0f);
            this.uxy.tipView.setAlpha(1.0f);
            ImageView imageView = this.uxy.blurBgView;
            Context context = this.uxy.getContext();
            p.g(context, "context");
            imageView.setElevation((float) context.getResources().getDimensionPixelSize(R.dimen.a_w));
            this.uxy.progressView.setVisibility(8);
            this.uxy.progressTips.setVisibility(8);
            this.uxy.tipView.setVisibility(8);
            AppMethodBeat.o(247313);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(247314);
            this.uxy.blurBgView.setAlpha(1.0f);
            this.uxy.progressView.setAlpha(1.0f);
            this.uxy.tipView.setAlpha(1.0f);
            ImageView imageView = this.uxy.blurBgView;
            Context context = this.uxy.getContext();
            p.g(context, "context");
            imageView.setElevation((float) context.getResources().getDimensionPixelSize(R.dimen.a_w));
            this.uxy.progressView.setVisibility(8);
            this.uxy.progressTips.setVisibility(8);
            this.uxy.tipView.setVisibility(8);
            AppMethodBeat.o(247314);
        }
    }

    public void reset(boolean z) {
        if (!z) {
            b.C0376b.a(this, b.c.hNm);
        }
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public void initLogic(LiveConfig liveConfig, boolean z) {
        p.h(liveConfig, "config");
    }

    public void activate(com.tencent.mm.plugin.finder.live.viewmodel.c cVar, boolean z, boolean z2, boolean z3, int i2) {
        p.h(cVar, "config");
        this.checkMiniWin = false;
        if (z3) {
            com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
            if (!com.tencent.mm.plugin.finder.utils.m.dBP()) {
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                String string = context.getResources().getString(R.string.jcb);
                p.g(string, "MMApplicationContext.get…sitor_role_changing_tips)");
                showProgressWithTips(string);
            }
        }
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout, com.tencent.mm.live.c.b
    public void statusChange(b.c cVar, Bundle bundle) {
        p.h(cVar, "status");
        com.tencent.mm.ac.d.h(new g(this, cVar, bundle));
    }

    public final void showStatistics(com.tencent.mm.live.core.core.b.c cVar) {
        if (cVar != null) {
            int i2 = cVar.mode;
            e.a aVar = e.a.hxc;
            if (i2 == e.a.aCf()) {
                showCDNStatistics(cVar);
                return;
            }
        }
        showTrtcStatistics(cVar);
    }

    private final void onPortraitActionImpl(int i2, int i3, Bundle bundle, Object obj) {
        int i4;
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.liveData;
        if (gVar == null) {
            p.btv("liveData");
        }
        gVar.uEv = false;
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = this.liveData;
        if (gVar2 == null) {
            p.btv("liveData");
        }
        gVar2.uDS = true;
        if (bundle == null) {
            i4 = 0;
        } else if (bundle.containsKey("ACTION_POST_PORTRAIT_DELAY")) {
            i4 = bundle.getInt("ACTION_POST_PORTRAIT_DELAY");
        } else {
            i4 = 0;
        }
        String str = this.TAG;
        StringBuilder append = new StringBuilder("onPortraitAction action:").append(bundle).append(", orientation:");
        Context context = getContext();
        p.g(context, "context");
        Resources resources = context.getResources();
        p.g(resources, "context.resources");
        Log.i(str, append.append(resources.getConfiguration().orientation).append(",delayMs:").append(i4).toString());
        for (T t : getPluginList()) {
            if (t instanceof com.tencent.mm.plugin.finder.live.plugin.d) {
                if (i4 > 0) {
                    t.a(bundle, obj, (long) i4);
                } else {
                    t.ai(bundle);
                }
            }
        }
    }

    public final void onPortraitAction(int i2, int i3, Bundle bundle, Object obj) {
        if (isLandscape()) {
            forceScreenToPortrait();
        } else {
            onPortraitActionImpl(i2, i3, bundle, obj);
        }
    }

    private final void onLandscapeActionImpl(int i2, int i3, Bundle bundle, Object obj) {
        int i4 = 0;
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.liveData;
        if (gVar == null) {
            p.btv("liveData");
        }
        gVar.uEv = false;
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = this.liveData;
        if (gVar2 == null) {
            p.btv("liveData");
        }
        gVar2.uDS = true;
        if (bundle != null && bundle.containsKey("ACTION_POST_LANDSCAPE_DELAY")) {
            i4 = bundle.getInt("ACTION_POST_LANDSCAPE_DELAY");
        }
        String str = this.TAG;
        StringBuilder append = new StringBuilder("onLandscapeAction action:").append(bundle).append(", orientation:");
        Context context = getContext();
        p.g(context, "context");
        Resources resources = context.getResources();
        p.g(resources, "context.resources");
        Log.i(str, append.append(resources.getConfiguration().orientation).append(",delayMs:").append(i4).toString());
        Iterator<T> it = getPluginList().iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public final void onLandscapeAction(int i2, int i3, Bundle bundle, Object obj) {
        if (!isLandscape()) {
            forceScreenToLandscape();
        } else {
            onLandscapeActionImpl(i2, i3, bundle, obj);
        }
    }

    public void applyState(int i2, int i3, Bundle bundle) {
        Iterator<T> it = getPluginList().iterator();
        while (it.hasNext()) {
            it.next().B(i3, bundle);
        }
    }

    public void finish() {
        if (getContext() instanceof MMFinderUI) {
            this.isManualClosed = true;
            Context context = getContext();
            if (context == null) {
                throw new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.MMFinderUI");
            }
            ((MMFinderUI) context).finish();
        }
    }

    public boolean isSwipeBack() {
        if (getContext() instanceof FinderLiveVisitor) {
            Context context = getContext();
            if (context != null) {
                return ((FinderLiveVisitor) context).ubn;
            }
            throw new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitor");
        } else if (getContext() instanceof FinderLiveAnchorUI) {
            Context context2 = getContext();
            if (context2 != null) {
                return ((FinderLiveAnchorUI) context2).ubn;
            }
            throw new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI");
        } else if (getContext() instanceof FinderLiveAnchorWithoutAffinityUI) {
            Context context3 = getContext();
            if (context3 != null) {
                return ((FinderLiveAnchorWithoutAffinityUI) context3).ubn;
            }
            throw new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorWithoutAffinityUI");
        } else if (!(getContext() instanceof FinderLiveVisitorWithoutAffinityUI)) {
            return false;
        } else {
            Context context4 = getContext();
            if (context4 != null) {
                return ((FinderLiveVisitorWithoutAffinityUI) context4).ubn;
            }
            throw new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorWithoutAffinityUI");
        }
    }

    public static /* synthetic */ void bindData$default(FinderBaseLivePluginLayout finderBaseLivePluginLayout, com.tencent.mm.plugin.finder.live.viewmodel.c cVar, com.tencent.mm.plugin.finder.live.viewmodel.g gVar, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindData");
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        finderBaseLivePluginLayout.bindData(cVar, gVar, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0074, code lost:
        if (com.tencent.mm.plugin.finder.utils.y.dCM() != false) goto L_0x0076;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindData(com.tencent.mm.plugin.finder.live.viewmodel.c r6, com.tencent.mm.plugin.finder.live.viewmodel.g r7, boolean r8) {
        /*
        // Method dump skipped, instructions count: 128
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout.bindData(com.tencent.mm.plugin.finder.live.viewmodel.c, com.tencent.mm.plugin.finder.live.viewmodel.g, boolean):void");
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public void mount() {
        super.mount();
        Object systemService = getContext().getSystemService("phone");
        if (systemService == null) {
            throw new t("null cannot be cast to non-null type android.telephony.TelephonyManager");
        }
        TelephonyManager telephonyManager = (TelephonyManager) systemService;
        com.tencent.mm.hellhoundlib.b.a bl = com.tencent.mm.hellhoundlib.b.c.a(32, new com.tencent.mm.hellhoundlib.b.a()).bl(this.phoneStatelistener);
        com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout", "mount", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
        telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout", "mount", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
        com.tencent.mm.live.b.s sVar = com.tencent.mm.live.b.s.hIl;
        com.tencent.mm.live.b.s.a(this);
        com.tencent.mm.plugin.finder.live.model.a.b bVar = com.tencent.mm.plugin.finder.live.model.a.b.ULf;
        com.tencent.mm.plugin.finder.live.model.a.b.a(this);
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public void resume() {
        super.resume();
        this.checkMiniWin = false;
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.liveData;
        if (gVar == null) {
            p.btv("liveData");
        }
        gVar.uDS = true;
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = this.liveData;
        if (gVar2 == null) {
            p.btv("liveData");
        }
        gVar2.uDT = false;
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar3 = this.liveData;
        if (gVar3 == null) {
            p.btv("liveData");
        }
        gVar3.uEv = false;
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public void start() {
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.liveData;
        if (gVar == null) {
            p.btv("liveData");
        }
        gVar.uDS = true;
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = this.liveData;
        if (gVar2 == null) {
            p.btv("liveData");
        }
        gVar2.uDT = false;
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar3 = this.liveData;
        if (gVar3 == null) {
            p.btv("liveData");
        }
        gVar3.uEv = false;
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public void stop() {
        super.stop();
        com.tencent.mm.ac.d.i(l.UNm);
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public void unMount() {
        super.unMount();
        String str = this.TAG;
        StringBuilder sb = new StringBuilder("unMount ");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.liveData;
        if (gVar == null) {
            p.btv("liveData");
        }
        Log.i(str, sb.append(gVar).toString());
        Object systemService = getContext().getSystemService("phone");
        if (systemService == null) {
            throw new t("null cannot be cast to non-null type android.telephony.TelephonyManager");
        }
        TelephonyManager telephonyManager = (TelephonyManager) systemService;
        com.tencent.mm.hellhoundlib.b.a bl = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bl(this.phoneStatelistener);
        com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout", "unMount", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
        telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout", "unMount", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
        com.tencent.mm.ui.widget.a.d dVar = this.alertDialog;
        if (dVar != null) {
            dVar.dismiss();
        }
        com.tencent.mm.plugin.finder.live.model.a.b bVar = com.tencent.mm.plugin.finder.live.model.a.b.ULf;
        com.tencent.mm.plugin.finder.live.model.a.b.release();
        release();
    }

    @Override // com.tencent.mm.live.b.j
    public void onApplyLiveMic(com.tencent.mm.live.b.b bVar) {
        p.h(bVar, "info");
    }

    @Override // com.tencent.mm.live.b.j
    public void onAcceptLiveMic(com.tencent.mm.live.b.a aVar) {
        p.h(aVar, "info");
    }

    @Override // com.tencent.mm.live.b.j
    public void onCloseLive(com.tencent.mm.live.b.e eVar) {
        p.h(eVar, "info");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.liveData;
        if (gVar == null) {
            p.btv("liveData");
        }
        if (gVar.liveInfo.liveId == eVar.liveId) {
            com.tencent.mm.plugin.finder.live.model.q qVar = com.tencent.mm.plugin.finder.live.model.q.ukd;
            com.tencent.mm.plugin.finder.live.model.q.dgA();
        }
    }

    @Override // com.tencent.mm.live.b.j
    public void onCloseLiveMic(com.tencent.mm.live.b.f fVar) {
        p.h(fVar, "info");
    }

    @Override // com.tencent.mm.live.b.j
    public void onCloseApplyLiveMic(com.tencent.mm.live.b.d dVar) {
        p.h(dVar, "info");
    }

    @Override // com.tencent.mm.live.b.j
    public void onBanLiveComment(com.tencent.mm.live.b.c cVar) {
        p.h(cVar, "info");
    }

    @Override // com.tencent.mm.live.b.j
    public void onLiveMicSucc(com.tencent.mm.live.b.q qVar) {
        p.h(qVar, "info");
    }

    @Override // com.tencent.mm.live.b.j
    public void onOnlineLiveList(v vVar) {
        p.h(vVar, "info");
    }

    @Override // com.tencent.mm.live.b.j
    public void onFinderLiveCloseLiveMic(com.tencent.mm.live.b.i iVar) {
        T t;
        p.h(iVar, "info");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.liveData;
        if (gVar == null) {
            p.btv("liveData");
        }
        gVar.uDE = null;
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = this.liveData;
        if (gVar2 == null) {
            p.btv("liveData");
        }
        Iterator<T> it = gVar2.uDF.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            if (Util.isEqual(next.hFO, iVar.hFO)) {
                t = next;
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar3 = this.liveData;
            if (gVar3 == null) {
                p.btv("liveData");
            }
            gVar3.uDF.remove(t2);
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar4 = this.liveData;
            if (gVar4 == null) {
                p.btv("liveData");
            }
            ArrayList<String> arrayList = gVar4.uDG;
            String str = t2.uCo;
            if (arrayList == null) {
                throw new t("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
            }
            af.eV(arrayList).remove(str);
        }
        com.tencent.mm.plugin.finder.live.model.q qVar = com.tencent.mm.plugin.finder.live.model.q.ukd;
        com.tencent.mm.plugin.finder.live.model.q.dgz();
    }

    @Override // com.tencent.mm.live.b.j
    public void onAnchorConnectionChange(boolean z) {
        com.tencent.mm.plugin.finder.live.model.q qVar = com.tencent.mm.plugin.finder.live.model.q.ukd;
        com.tencent.mm.plugin.finder.live.model.q.no(z);
    }

    public final boolean isLiveStarted() {
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.liveData;
        if (gVar == null) {
            p.btv("liveData");
        }
        return gVar.isLiveStarted();
    }

    public final boolean isLiveFinished() {
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.liveData;
        if (gVar == null) {
            p.btv("liveData");
        }
        return gVar.djl();
    }

    public final boolean needMiniWindow() {
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.liveData;
        if (gVar == null) {
            p.btv("liveData");
        }
        return gVar.uDS;
    }

    public final boolean needRemoveActivity() {
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.liveData;
        if (gVar == null) {
            p.btv("liveData");
        }
        return gVar.uDT;
    }

    public void onScreenClear(boolean z) {
        int i2;
        for (T t : getPluginList()) {
            if ((t instanceof com.tencent.mm.plugin.finder.live.plugin.d) && t.dgK()) {
                Log.i(this.TAG, t.name() + " screen switch, visibility:" + t.hwr.getVisibility() + ", cacheVisibility:" + t.ulV + ", clear:" + z);
                T t2 = t;
                if (z) {
                    i2 = 8;
                } else {
                    i2 = 65535;
                }
                t2.ulW = i2;
                if (z) {
                    t.epk();
                } else {
                    t.dCW();
                }
            }
        }
    }

    public void onNewIntent(Intent intent) {
        for (T t : getPluginList()) {
            if (!(t instanceof com.tencent.mm.plugin.finder.live.plugin.d)) {
                t = null;
            }
            T t2 = t;
            if (t2 != null) {
                t2.onNewIntent(intent);
            }
        }
    }

    public final m getStatisticsWidget() {
        return this.statisticsWidget;
    }

    public final void setStatisticsWidget(m mVar) {
        this.statisticsWidget = mVar;
    }

    public final void showTrtcStatistics(com.tencent.mm.live.core.core.b.c cVar) {
        String str;
        Long l2;
        Long l3;
        Long l4;
        Long l5;
        Long l6;
        Long l7;
        Long l8;
        Long l9;
        String str2 = null;
        y yVar = y.vXH;
        if (y.dCM() && cVar != null) {
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.liveData;
            if (gVar == null) {
                p.btv("liveData");
            }
            if (gVar.uEN) {
                com.tencent.mm.plugin.finder.live.util.q qVar = com.tencent.mm.plugin.finder.live.util.q.uxj;
                com.tencent.mm.plugin.finder.live.util.q.a(cVar);
                com.tencent.mm.plugin.finder.live.util.q qVar2 = com.tencent.mm.plugin.finder.live.util.q.uxj;
                com.tencent.mm.plugin.finder.live.util.y din = com.tencent.mm.plugin.finder.live.util.q.din();
                if (din != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(din.uwk.uxm.key + ':' + din.uwk.uxm.value + '\n');
                    sb.append(din.uwl.uxm.key + ':' + din.uwl.uxm.value + '\n');
                    StringBuilder append = new StringBuilder().append(din.uwj.uxm.key).append(':').append(din.uwj.uxm.value).append('(');
                    com.tencent.mm.plugin.finder.live.util.e eVar = din.uwj.uxn;
                    sb.append(append.append(eVar != null ? Long.valueOf(eVar.uwa) : null).append(")\n").toString());
                    StringBuilder append2 = new StringBuilder().append(din.uwg.uxm.key).append(':').append(din.uwg.uxm.value).append('(');
                    com.tencent.mm.plugin.finder.live.util.e eVar2 = din.uwg.uxn;
                    if (eVar2 != null) {
                        l2 = Long.valueOf(eVar2.uwa);
                    } else {
                        l2 = null;
                    }
                    sb.append(append2.append(l2).append(")\n").toString());
                    StringBuilder append3 = new StringBuilder().append(din.uxp.uxm.key).append(':').append(din.uxp.uxm.value).append('(');
                    com.tencent.mm.plugin.finder.live.util.e eVar3 = din.uxp.uxn;
                    if (eVar3 != null) {
                        l3 = Long.valueOf(eVar3.uwa);
                    } else {
                        l3 = null;
                    }
                    sb.append(append3.append(l3).append(")\n").toString());
                    StringBuilder append4 = new StringBuilder().append(din.uxq.uxm.key).append(':').append(din.uxq.uxm.value).append('(');
                    com.tencent.mm.plugin.finder.live.util.e eVar4 = din.uxq.uxn;
                    if (eVar4 != null) {
                        l4 = Long.valueOf(eVar4.uwa);
                    } else {
                        l4 = null;
                    }
                    sb.append(append4.append(l4).append(")\n").toString());
                    StringBuilder append5 = new StringBuilder().append(din.uxr.uxm.key).append(':').append(din.uxr.uxm.value).append('(');
                    com.tencent.mm.plugin.finder.live.util.e eVar5 = din.uxr.uxn;
                    if (eVar5 != null) {
                        l5 = Long.valueOf(eVar5.uwa);
                    } else {
                        l5 = null;
                    }
                    sb.append(append5.append(l5).append(")\n").toString());
                    StringBuilder append6 = new StringBuilder().append(din.uxs.uxm.key).append(':').append(din.uxs.uxm.value).append('(');
                    com.tencent.mm.plugin.finder.live.util.e eVar6 = din.uxs.uxn;
                    if (eVar6 != null) {
                        l6 = Long.valueOf(eVar6.uwa);
                    } else {
                        l6 = null;
                    }
                    sb.append(append6.append(l6).append(")\n").toString());
                    StringBuilder append7 = new StringBuilder().append(din.uxt.uxm.key).append(':').append(din.uxt.uxm.value).append('(');
                    com.tencent.mm.plugin.finder.live.util.e eVar7 = din.uxt.uxn;
                    if (eVar7 != null) {
                        l7 = Long.valueOf(eVar7.uwa);
                    } else {
                        l7 = null;
                    }
                    sb.append(append7.append(l7).append(")\n").toString());
                    StringBuilder append8 = new StringBuilder().append(din.uwh.uxm.key).append(':').append(din.uwh.uxm.value).append('(');
                    com.tencent.mm.plugin.finder.live.util.e eVar8 = din.uwh.uxn;
                    if (eVar8 != null) {
                        l8 = Long.valueOf(eVar8.uwa);
                    } else {
                        l8 = null;
                    }
                    sb.append(append8.append(l8).append(")\n").toString());
                    StringBuilder append9 = new StringBuilder().append(din.uwi.uxm.key).append(':').append(din.uwi.uxm.value).append('(');
                    com.tencent.mm.plugin.finder.live.util.e eVar9 = din.uwi.uxn;
                    if (eVar9 != null) {
                        l9 = Long.valueOf(eVar9.uwa);
                    } else {
                        l9 = null;
                    }
                    sb.append(append9.append(l9).append(")\n").toString());
                    str = sb.toString();
                    p.g(str, "sb.toString()");
                } else {
                    str = null;
                }
                if (!Util.isNullOrNil(str)) {
                    if (str == null) {
                        str = "";
                    }
                    StringBuilder sb2 = new StringBuilder(str);
                    sb2.append("liveId:" + cVar.hyH + '\n');
                    String sb3 = sb2.toString();
                    if (this.statisticsWidget == null) {
                        Context context = getContext();
                        p.g(context, "context");
                        this.statisticsWidget = new m(context, this);
                    }
                    m mVar = this.statisticsWidget;
                    if (mVar != null) {
                        StringBuilder sb4 = new StringBuilder("Mode Trtc\n");
                        com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = this.liveData;
                        if (gVar2 == null) {
                            p.btv("liveData");
                        }
                        String sb5 = sb4.append(gVar2.djj()).append(sb3).toString();
                        if (sb5 == null) {
                            sb5 = "";
                        }
                        mVar.atZ(sb5);
                    }
                    String str3 = this.TAG;
                    StringBuilder sb6 = new StringBuilder("showTrtcStatistics:");
                    com.tencent.mm.plugin.finder.live.util.q qVar3 = com.tencent.mm.plugin.finder.live.util.q.uxj;
                    com.tencent.mm.plugin.finder.live.util.y din2 = com.tencent.mm.plugin.finder.live.util.q.din();
                    if (din2 != null) {
                        str2 = din2.dif();
                    }
                    Log.i(str3, sb6.append(str2).toString());
                    return;
                }
                return;
            }
            hideStatistics();
        }
    }

    public final void showCDNStatistics(com.tencent.mm.live.core.core.b.c cVar) {
        String str;
        Long l2;
        Long l3;
        Long l4;
        Long l5;
        Long l6;
        Long l7;
        Long l8;
        Long l9;
        Long l10;
        String str2 = null;
        y yVar = y.vXH;
        if (y.dCM() && cVar != null) {
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.liveData;
            if (gVar == null) {
                p.btv("liveData");
            }
            if (gVar.uEN) {
                com.tencent.mm.plugin.finder.live.util.q qVar = com.tencent.mm.plugin.finder.live.util.q.uxj;
                com.tencent.mm.plugin.finder.live.util.q.b(cVar);
                com.tencent.mm.plugin.finder.live.util.q qVar2 = com.tencent.mm.plugin.finder.live.util.q.uxj;
                com.tencent.mm.plugin.finder.live.util.h dio = com.tencent.mm.plugin.finder.live.util.q.dio();
                if (dio != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(dio.uwk.uxm.key + ':' + dio.uwk.uxm.value + '\n');
                    sb.append(dio.uwl.uxm.key + ':' + dio.uwl.uxm.value + '\n');
                    StringBuilder append = new StringBuilder().append(dio.uwg.uxm.key).append(':').append(dio.uwg.uxm.value).append('(');
                    com.tencent.mm.plugin.finder.live.util.e eVar = dio.uwg.uxn;
                    sb.append(append.append(eVar != null ? Long.valueOf(eVar.uwa) : null).append(")\n").toString());
                    StringBuilder append2 = new StringBuilder().append(dio.uwj.uxm.key).append(':').append(dio.uwj.uxm.value).append('(');
                    com.tencent.mm.plugin.finder.live.util.e eVar2 = dio.uwj.uxn;
                    if (eVar2 != null) {
                        l2 = Long.valueOf(eVar2.uwa);
                    } else {
                        l2 = null;
                    }
                    sb.append(append2.append(l2).append(")\n").toString());
                    StringBuilder append3 = new StringBuilder().append(dio.uwh.uxm.key).append(':').append(dio.uwh.uxm.value).append('(');
                    com.tencent.mm.plugin.finder.live.util.e eVar3 = dio.uwh.uxn;
                    if (eVar3 != null) {
                        l3 = Long.valueOf(eVar3.uwa);
                    } else {
                        l3 = null;
                    }
                    sb.append(append3.append(l3).append(")\n").toString());
                    StringBuilder append4 = new StringBuilder().append(dio.uwi.uxm.key).append(':').append(dio.uwi.uxm.value).append('(');
                    com.tencent.mm.plugin.finder.live.util.e eVar4 = dio.uwi.uxn;
                    if (eVar4 != null) {
                        l4 = Long.valueOf(eVar4.uwa);
                    } else {
                        l4 = null;
                    }
                    sb.append(append4.append(l4).append(")\n").toString());
                    StringBuilder append5 = new StringBuilder().append(dio.uwm.uxm.key).append(':').append(dio.uwm.uxm.value).append('(');
                    com.tencent.mm.plugin.finder.live.util.e eVar5 = dio.uwm.uxn;
                    if (eVar5 != null) {
                        l5 = Long.valueOf(eVar5.uwa);
                    } else {
                        l5 = null;
                    }
                    sb.append(append5.append(l5).append(")\n").toString());
                    StringBuilder append6 = new StringBuilder().append(dio.uwn.uxm.key).append(':').append(dio.uwn.uxm.value).append('(');
                    com.tencent.mm.plugin.finder.live.util.e eVar6 = dio.uwn.uxn;
                    if (eVar6 != null) {
                        l6 = Long.valueOf(eVar6.uwa);
                    } else {
                        l6 = null;
                    }
                    sb.append(append6.append(l6).append(")\n").toString());
                    StringBuilder append7 = new StringBuilder().append(dio.uwo.uxm.key).append(':').append(dio.uwo.uxm.value).append('(');
                    com.tencent.mm.plugin.finder.live.util.e eVar7 = dio.uwo.uxn;
                    if (eVar7 != null) {
                        l7 = Long.valueOf(eVar7.uwa);
                    } else {
                        l7 = null;
                    }
                    sb.append(append7.append(l7).append(")\n").toString());
                    StringBuilder append8 = new StringBuilder().append(dio.uwp.uxm.key).append(':').append(dio.uwp.uxm.value).append('(');
                    com.tencent.mm.plugin.finder.live.util.e eVar8 = dio.uwp.uxn;
                    if (eVar8 != null) {
                        l8 = Long.valueOf(eVar8.uwa);
                    } else {
                        l8 = null;
                    }
                    sb.append(append8.append(l8).append(")\n").toString());
                    StringBuilder append9 = new StringBuilder().append(dio.uwq.uxm.key).append(':').append(dio.uwq.uxm.value).append('(');
                    com.tencent.mm.plugin.finder.live.util.e eVar9 = dio.uwq.uxn;
                    if (eVar9 != null) {
                        l9 = Long.valueOf(eVar9.uwa);
                    } else {
                        l9 = null;
                    }
                    sb.append(append9.append(l9).append(")\n").toString());
                    StringBuilder append10 = new StringBuilder().append(dio.uwr.uxm.key).append(':').append(dio.uwr.uxm.value).append('(');
                    com.tencent.mm.plugin.finder.live.util.e eVar10 = dio.uwr.uxn;
                    if (eVar10 != null) {
                        l10 = Long.valueOf(eVar10.uwa);
                    } else {
                        l10 = null;
                    }
                    sb.append(append10.append(l10).append(")\n").toString());
                    str = sb.toString();
                    p.g(str, "sb.toString()");
                } else {
                    str = null;
                }
                if (!Util.isNullOrNil(str)) {
                    if (str == null) {
                        str = "";
                    }
                    StringBuilder sb2 = new StringBuilder(str);
                    sb2.append("liveId:" + cVar.hyH + '\n');
                    String sb3 = sb2.toString();
                    if (this.statisticsWidget == null) {
                        Context context = getContext();
                        p.g(context, "context");
                        this.statisticsWidget = new m(context, this);
                    }
                    m mVar = this.statisticsWidget;
                    if (mVar != null) {
                        StringBuilder sb4 = new StringBuilder("Mode CDN\n");
                        com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = this.liveData;
                        if (gVar2 == null) {
                            p.btv("liveData");
                        }
                        String sb5 = sb4.append(gVar2.djj()).append(sb3).toString();
                        if (sb5 == null) {
                            sb5 = "";
                        }
                        mVar.atZ(sb5);
                    }
                    String str3 = this.TAG;
                    StringBuilder sb6 = new StringBuilder("showCDNStatistics:");
                    com.tencent.mm.plugin.finder.live.util.q qVar3 = com.tencent.mm.plugin.finder.live.util.q.uxj;
                    com.tencent.mm.plugin.finder.live.util.h dio2 = com.tencent.mm.plugin.finder.live.util.q.dio();
                    if (dio2 != null) {
                        str2 = dio2.dif();
                    }
                    Log.i(str3, sb6.append(str2).toString());
                    return;
                }
                return;
            }
            hideStatistics();
        }
    }

    public final void hideStatistics() {
        m mVar = this.statisticsWidget;
        if (mVar != null) {
            mVar.uHs.setVisibility(8);
        }
    }

    public final boolean isDestroyed() {
        if (getContext() == null || !(getContext() instanceof Activity)) {
            return false;
        }
        Context context = getContext();
        if (context != null) {
            return ((Activity) context).isDestroyed();
        }
        throw new t("null cannot be cast to non-null type android.app.Activity");
    }

    @Override // com.tencent.mm.plugin.mmsight.model.d.a
    public void onOrientationChange(int i2) {
        if (this.lastRotationFromSensor == -1 || this.lastRotationFromSensor != i2) {
            if (this.lastRotationFromSensor != -1) {
                s finderLiveAssistant = getFinderLiveAssistant();
                if (finderLiveAssistant != null) {
                    finderLiveAssistant.dfm();
                }
                if (getCurrentOrientation() == 1 || getCurrentOrientation() == 3) {
                    b.C0376b.a(this, b.c.hMC);
                }
            }
            Log.i(this.TAG, "onOrientationChange lastRotationFromSensor:" + this.lastRotationFromSensor + ",cur orientation:" + i2);
            this.lastRotationFromSensor = i2;
        }
    }

    public final void enableRotation() {
        s finderLiveAssistant;
        Log.i(this.TAG, "enableOritation");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.liveData;
        if (gVar == null) {
            p.btv("liveData");
        }
        if (gVar.djm()) {
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = this.liveData;
            if (gVar2 == null) {
                p.btv("liveData");
            }
            if (gVar2.uEv && (finderLiveAssistant = getFinderLiveAssistant()) != null) {
                finderLiveAssistant.dfn();
            }
            if (this.orientationEventListener == null) {
                this.orientationEventListener = new com.tencent.mm.plugin.mmsight.model.d(getContext(), (byte) 0);
            }
            com.tencent.mm.plugin.mmsight.model.d dVar = this.orientationEventListener;
            if (dVar != null) {
                dVar.a(this);
            }
            com.tencent.mm.plugin.mmsight.model.d dVar2 = this.orientationEventListener;
            if (dVar2 != null) {
                dVar2.enable();
            }
        }
    }

    public final void disableRatation() {
        Log.i(this.TAG, "disableOritation");
        com.tencent.mm.plugin.mmsight.model.d dVar = this.orientationEventListener;
        if (dVar != null) {
            dVar.disable();
        }
        com.tencent.mm.plugin.mmsight.model.d dVar2 = this.orientationEventListener;
        if (dVar2 != null) {
            dVar2.a(null);
        }
        this.orientationEventListener = null;
    }

    public final void forceScreenToPortrait() {
        disableRatation();
        s finderLiveAssistant = getFinderLiveAssistant();
        if (p.j(finderLiveAssistant != null ? Boolean.valueOf(finderLiveAssistant.dfo()) : null, Boolean.TRUE)) {
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.liveData;
            if (gVar == null) {
                p.btv("liveData");
            }
            gVar.uEv = true;
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = this.liveData;
            if (gVar2 == null) {
                p.btv("liveData");
            }
            gVar2.uDS = false;
        }
    }

    public final void forceScreenToLandscape() {
        disableRatation();
        s finderLiveAssistant = getFinderLiveAssistant();
        if (p.j(finderLiveAssistant != null ? Boolean.valueOf(finderLiveAssistant.dfp()) : null, Boolean.TRUE)) {
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.liveData;
            if (gVar == null) {
                p.btv("liveData");
            }
            gVar.uEv = true;
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = this.liveData;
            if (gVar2 == null) {
                p.btv("liveData");
            }
            gVar2.uDS = false;
        }
    }

    public final void showCenterCustomizeToast(String str, int i2) {
        p.h(str, "msg");
        com.tencent.mm.ac.d.h(new f(this, str, i2));
    }

    public final boolean showAlertDialog(Activity activity, String str, String str2, String str3) {
        boolean z = false;
        p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        com.tencent.mm.ui.widget.a.d dVar = this.alertDialog;
        if (p.j(dVar != null ? Boolean.valueOf(dVar.isShowing()) : null, Boolean.TRUE) || isDestroyed()) {
            return false;
        }
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.liveData;
        if (gVar == null) {
            p.btv("liveData");
        }
        gVar.dje();
        if (str2 == null) {
            return false;
        }
        f.a aVar = new f.a(activity);
        String str4 = str;
        if (str4 == null || str4.length() == 0) {
            aVar.bow(str2);
        } else {
            aVar.aC(str).bow(str2);
        }
        aVar.hbu();
        String string = activity.getResources().getString(R.string.cqo);
        p.g(string, "activity.resources.getSt…ive_alert_dialog_btn_txt)");
        String str5 = str3;
        if (str5 == null || str5.length() == 0) {
            z = true;
        }
        if (z) {
            str3 = string;
        }
        aVar.boA(str3);
        aVar.b(new e(this)).show();
        this.alertDialog = aVar.hbv();
        return true;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    public static final class e implements f.c {
        final /* synthetic */ FinderBaseLivePluginLayout uxy;

        e(FinderBaseLivePluginLayout finderBaseLivePluginLayout) {
            this.uxy = finderBaseLivePluginLayout;
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
            AppMethodBeat.i(247316);
            Log.i(this.uxy.TAG, "showAlertDialog click bOk:".concat(String.valueOf(z)));
            AppMethodBeat.o(247316);
        }
    }

    public final void showToast(Context context, String str) {
        p.h(context, "context");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.liveData;
        if (gVar == null) {
            p.btv("liveData");
        }
        gVar.dje();
        if (str != null) {
            u.makeText(context, str, 1).show();
        }
    }

    public final void showAlertInfo(Activity activity) {
        String str;
        String str2;
        String str3;
        String str4 = null;
        p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.liveData;
        if (gVar == null) {
            p.btv("liveData");
        }
        awr awr = gVar.uDY;
        Integer valueOf = awr != null ? Integer.valueOf(awr.type) : null;
        if (awr != null) {
            str = awr.title;
        } else {
            str = null;
        }
        if (awr != null) {
            str2 = awr.content;
        } else {
            str2 = null;
        }
        if (awr != null) {
            str3 = awr.LHs;
        } else {
            str3 = null;
        }
        if (awr != null) {
            str4 = awr.LHr;
        }
        if (valueOf != null && valueOf.intValue() == 1) {
            Log.i(this.TAG, "showAlertInfo type:" + valueOf + ",title:" + str + ",content:" + str2 + ",buttonTitle:" + str3);
            showAlertDialog(activity, str, str2, str3);
        } else if (valueOf != null && valueOf.intValue() == 0) {
            Log.i(this.TAG, "showAlertInfo type:" + valueOf + ",title:" + str + ",content:" + str2 + ",buttonTitle:" + str3 + ",iconName:" + str4);
            if (str != null) {
                try {
                    Context context = getContext();
                    p.g(context, "context");
                    Resources resources = context.getResources();
                    Context context2 = getContext();
                    p.g(context2, "context");
                    int identifier = resources.getIdentifier(str4, "drawable", context2.getPackageName());
                    Context context3 = getContext();
                    p.g(context3, "context");
                    Resources resources2 = context3.getResources();
                    Context context4 = getContext();
                    p.g(context4, "context");
                    int identifier2 = resources2.getIdentifier(str4, ShareConstants.DEXMODE_RAW, context4.getPackageName());
                    if (identifier2 == 0) {
                        identifier2 = identifier;
                    }
                    if (identifier2 != 0) {
                        showCenterCustomizeToast(str, identifier2);
                    } else {
                        showToast(activity, str);
                    }
                } catch (Exception e2) {
                    Log.i(this.TAG, "showAlertInfo exception:" + e2.getMessage());
                    showToast(activity, str);
                }
            }
        }
    }

    public final void showDebugToast(String str) {
        p.h(str, "content");
        if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
            u.makeText(getContext(), str, 0).show();
        }
    }

    public final ArrayList<com.tencent.mm.live.c.a> getPlugins() {
        return getPluginList();
    }

    public final void goGetLuckMoney(Activity activity, String str) {
        int aFW;
        p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        Log.i(this.TAG, "goGetLuckMoney redPacketId:".concat(String.valueOf(str)));
        if (str != null) {
            com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
            if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
                o.m mVar2 = o.m.hHB;
                aFW = o.m.aFV();
            } else {
                b.a aVar = com.tencent.mm.live.core.core.d.b.hCo;
                if (b.a.aDp()) {
                    o.m mVar3 = o.m.hHB;
                    aFW = o.m.aFW();
                } else {
                    o.m mVar4 = o.m.hHB;
                    aFW = o.m.aFW();
                }
            }
            s finderLiveAssistant = getFinderLiveAssistant();
            if (finderLiveAssistant != null) {
                com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.liveData;
                if (gVar == null) {
                    p.btv("liveData");
                }
                long j2 = gVar.liveInfo.liveId;
                com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = this.liveData;
                if (gVar2 == null) {
                    p.btv("liveData");
                }
                long j3 = gVar2.hFK;
                com.tencent.mm.plugin.finder.live.viewmodel.g gVar3 = this.liveData;
                if (gVar3 == null) {
                    p.btv("liveData");
                }
                String str2 = gVar3.hwg;
                com.tencent.mm.plugin.finder.live.viewmodel.g gVar4 = this.liveData;
                if (gVar4 == null) {
                    p.btv("liveData");
                }
                finderLiveAssistant.a(j2, j3, str2, gVar4.hIt, aFW, kotlin.a.j.listOf(str), new h(this, activity));
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout$goGetLuckMoney$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLuckyMoneyInfo$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetRedPacketInfoResponse;", "plugin-finder_release"})
    public static final class h implements ai.a {
        final /* synthetic */ Activity nfZ;
        final /* synthetic */ FinderBaseLivePluginLayout uxy;

        h(FinderBaseLivePluginLayout finderBaseLivePluginLayout, Activity activity) {
            this.uxy = finderBaseLivePluginLayout;
            this.nfZ = activity;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.ai.a
        public final void a(int i2, int i3, fgt fgt) {
            boolean z;
            LinkedList<fgy> linkedList;
            AppMethodBeat.i(260765);
            p.h(fgt, "resp");
            Log.i(this.uxy.TAG, "[goGetLuckMoney] errType:" + i2 + "  errCode:" + i3 + ' ');
            if (i3 == 0 && i2 == 0) {
                LinkedList<fgy> linkedList2 = fgt.Vjc;
                LinkedList<fgy> linkedList3 = linkedList2;
                if (!(linkedList3 == null || linkedList3.isEmpty())) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    linkedList = linkedList2;
                } else {
                    linkedList = null;
                }
                if (linkedList != null) {
                    s finderLiveAssistant = this.uxy.getFinderLiveAssistant();
                    if (finderLiveAssistant != null) {
                        Activity activity = this.nfZ;
                        fgy fgy = linkedList.get(0);
                        p.g(fgy, "it[0]");
                        finderLiveAssistant.a(activity, fgy, new FinderBaseLivePluginLayout$goGetLuckMoney$$inlined$let$lambda$1$1(linkedList, MMHandler.createFreeHandler(Looper.getMainLooper()), this), new kotlin.g.a.b<Integer, x>(this) {
                            /* class com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout.h.AnonymousClass1 */
                            final /* synthetic */ h UNl;

                            {
                                this.UNl = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // kotlin.g.a.b
                            public final /* synthetic */ x invoke(Integer num) {
                                AppMethodBeat.i(260764);
                                this.UNl.uxy.handleRecvLuckyMoneyErr(num.intValue());
                                x xVar = x.SXb;
                                AppMethodBeat.o(260764);
                                return xVar;
                            }
                        });
                        AppMethodBeat.o(260765);
                        return;
                    }
                    AppMethodBeat.o(260765);
                    return;
                }
            }
            AppMethodBeat.o(260765);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final LinkedHashMap<String, Rect> genPkMicMap(int i2) {
        String str;
        LinkedHashMap<String, Rect> linkedHashMap = new LinkedHashMap<>();
        int i3 = au.az(getContext()).x;
        int i4 = au.az(getContext()).y;
        int i5 = (int) (1.7777778f * ((float) (i3 / 2)));
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.liveData;
        if (gVar == null) {
            p.btv("liveData");
        }
        com.tencent.mm.plugin.finder.live.viewmodel.e eVar = gVar.uEB;
        if (eVar == null || !eVar.UPN) {
            LinkedHashMap<String, Rect> linkedHashMap2 = linkedHashMap;
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = this.liveData;
            if (gVar2 == null) {
                p.btv("liveData");
            }
            String str2 = gVar2.hIv.Mop;
            p.g(str2, "liveData.liveSdkInfo.sdk_create_user_id");
            linkedHashMap2.put(str2, new Rect(0, 0, i3, i4));
        } else {
            LinkedHashMap<String, Rect> linkedHashMap3 = linkedHashMap;
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar3 = this.liveData;
            if (gVar3 == null) {
                p.btv("liveData");
            }
            String str3 = gVar3.hIv.Mop;
            p.g(str3, "liveData.liveSdkInfo.sdk_create_user_id");
            linkedHashMap3.put(str3, new Rect(0, i2, i3 / 2, i2 + i5));
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar4 = this.liveData;
            if (gVar4 == null) {
                p.btv("liveData");
            }
            com.tencent.mm.plugin.finder.live.viewmodel.e eVar2 = gVar4.uEB;
            if (!(eVar2 == null || (str = eVar2.uCo) == null)) {
                linkedHashMap.put(str, new Rect(i3 / 2, i2, i3, i5 + i2));
            }
        }
        return linkedHashMap;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final LinkedHashMap<String, Rect> genAudienceMicMap(int i2) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        LinkedHashMap<String, Rect> linkedHashMap = new LinkedHashMap<>();
        int i3 = au.az(getContext()).x;
        int i4 = au.az(getContext()).y;
        int i5 = (int) (1.7777778f * ((float) (i3 / 2)));
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.liveData;
        if (gVar == null) {
            p.btv("liveData");
        }
        switch (gVar.UPZ.size()) {
            case 0:
                LinkedHashMap<String, Rect> linkedHashMap2 = linkedHashMap;
                com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = this.liveData;
                if (gVar2 == null) {
                    p.btv("liveData");
                }
                String str7 = gVar2.hIv.Mop;
                p.g(str7, "liveData.liveSdkInfo.sdk_create_user_id");
                linkedHashMap2.put(str7, new Rect(0, 0, i3, i4));
                break;
            case 1:
                LinkedHashMap<String, Rect> linkedHashMap3 = linkedHashMap;
                com.tencent.mm.plugin.finder.live.viewmodel.g gVar3 = this.liveData;
                if (gVar3 == null) {
                    p.btv("liveData");
                }
                String str8 = gVar3.hIv.Mop;
                p.g(str8, "liveData.liveSdkInfo.sdk_create_user_id");
                linkedHashMap3.put(str8, new Rect(0, i2, i3 / 2, i2 + i5));
                com.tencent.mm.plugin.finder.live.viewmodel.g gVar4 = this.liveData;
                if (gVar4 == null) {
                    p.btv("liveData");
                }
                List<com.tencent.mm.plugin.finder.live.viewmodel.e> list = gVar4.UPZ;
                p.g(list, "liveData.audienceLinkMicUserList");
                com.tencent.mm.plugin.finder.live.viewmodel.e eVar = (com.tencent.mm.plugin.finder.live.viewmodel.e) kotlin.a.j.L(list, 0);
                if (!(eVar == null || (str6 = eVar.uCo) == null)) {
                    linkedHashMap.put(str6, new Rect(i3 / 2, i2, i3, i5 + i2));
                    break;
                }
            case 2:
                LinkedHashMap<String, Rect> linkedHashMap4 = linkedHashMap;
                com.tencent.mm.plugin.finder.live.viewmodel.g gVar5 = this.liveData;
                if (gVar5 == null) {
                    p.btv("liveData");
                }
                String str9 = gVar5.hIv.Mop;
                p.g(str9, "liveData.liveSdkInfo.sdk_create_user_id");
                linkedHashMap4.put(str9, new Rect(0, i2, i3 / 2, i2 + i5));
                com.tencent.mm.plugin.finder.live.viewmodel.g gVar6 = this.liveData;
                if (gVar6 == null) {
                    p.btv("liveData");
                }
                List<com.tencent.mm.plugin.finder.live.viewmodel.e> list2 = gVar6.UPZ;
                p.g(list2, "liveData.audienceLinkMicUserList");
                com.tencent.mm.plugin.finder.live.viewmodel.e eVar2 = (com.tencent.mm.plugin.finder.live.viewmodel.e) kotlin.a.j.L(list2, 0);
                if (!(eVar2 == null || (str5 = eVar2.uCo) == null)) {
                    linkedHashMap.put(str5, new Rect(i3 / 2, i2, i3, (i5 / 2) + i2));
                }
                com.tencent.mm.plugin.finder.live.viewmodel.g gVar7 = this.liveData;
                if (gVar7 == null) {
                    p.btv("liveData");
                }
                List<com.tencent.mm.plugin.finder.live.viewmodel.e> list3 = gVar7.UPZ;
                p.g(list3, "liveData.audienceLinkMicUserList");
                com.tencent.mm.plugin.finder.live.viewmodel.e eVar3 = (com.tencent.mm.plugin.finder.live.viewmodel.e) kotlin.a.j.L(list3, 1);
                if (!(eVar3 == null || (str4 = eVar3.uCo) == null)) {
                    linkedHashMap.put(str4, new Rect(i3 / 2, (i5 / 2) + i2, i3, i5 + i2));
                    break;
                }
            case 3:
                LinkedHashMap<String, Rect> linkedHashMap5 = linkedHashMap;
                com.tencent.mm.plugin.finder.live.viewmodel.g gVar8 = this.liveData;
                if (gVar8 == null) {
                    p.btv("liveData");
                }
                String str10 = gVar8.hIv.Mop;
                p.g(str10, "liveData.liveSdkInfo.sdk_create_user_id");
                linkedHashMap5.put(str10, new Rect(0, i2, i3 / 2, (i5 / 2) + i2));
                com.tencent.mm.plugin.finder.live.viewmodel.g gVar9 = this.liveData;
                if (gVar9 == null) {
                    p.btv("liveData");
                }
                List<com.tencent.mm.plugin.finder.live.viewmodel.e> list4 = gVar9.UPZ;
                p.g(list4, "liveData.audienceLinkMicUserList");
                com.tencent.mm.plugin.finder.live.viewmodel.e eVar4 = (com.tencent.mm.plugin.finder.live.viewmodel.e) kotlin.a.j.L(list4, 0);
                if (!(eVar4 == null || (str3 = eVar4.uCo) == null)) {
                    linkedHashMap.put(str3, new Rect(i3 / 2, i2, i3, (i5 / 2) + i2));
                }
                com.tencent.mm.plugin.finder.live.viewmodel.g gVar10 = this.liveData;
                if (gVar10 == null) {
                    p.btv("liveData");
                }
                List<com.tencent.mm.plugin.finder.live.viewmodel.e> list5 = gVar10.UPZ;
                p.g(list5, "liveData.audienceLinkMicUserList");
                com.tencent.mm.plugin.finder.live.viewmodel.e eVar5 = (com.tencent.mm.plugin.finder.live.viewmodel.e) kotlin.a.j.L(list5, 1);
                if (!(eVar5 == null || (str2 = eVar5.uCo) == null)) {
                    linkedHashMap.put(str2, new Rect(0, (i5 / 2) + i2, i3 / 2, i2 + i5));
                }
                com.tencent.mm.plugin.finder.live.viewmodel.g gVar11 = this.liveData;
                if (gVar11 == null) {
                    p.btv("liveData");
                }
                List<com.tencent.mm.plugin.finder.live.viewmodel.e> list6 = gVar11.UPZ;
                p.g(list6, "liveData.audienceLinkMicUserList");
                com.tencent.mm.plugin.finder.live.viewmodel.e eVar6 = (com.tencent.mm.plugin.finder.live.viewmodel.e) kotlin.a.j.L(list6, 2);
                if (!(eVar6 == null || (str = eVar6.uCo) == null)) {
                    linkedHashMap.put(str, new Rect(i3 / 2, (i5 / 2) + i2, i3, i5 + i2));
                    break;
                }
        }
        Log.i(this.TAG, "genAudienceMicMap result:".concat(String.valueOf(linkedHashMap)));
        return linkedHashMap;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final boolean diffMicUsers() {
        boolean z;
        int size = this.lastMicUserList.size();
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.liveData;
        if (gVar == null) {
            p.btv("liveData");
        }
        if (size != gVar.UPZ.size()) {
            return true;
        }
        int size2 = this.lastMicUserList.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size2) {
            String str = this.lastMicUserList.get(i2).sessionId;
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = this.liveData;
            if (gVar2 == null) {
                p.btv("liveData");
            }
            if (!Util.isEqual(str, gVar2.UPZ.get(i2).sessionId)) {
                z = true;
            } else {
                z = z2;
            }
            i2++;
            z2 = z;
        }
        return z2;
    }

    public final void notifyAudienceMicUserChange() {
        com.tencent.mm.ac.d.h(new j(this));
    }

    public final void notifyPKMicUserChange() {
        com.tencent.mm.ac.d.h(new k(this));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void handleRecvLuckyMoneyErr(int i2) {
        com.tencent.mm.ac.d.h(new i(this, i2));
    }

    @Override // com.tencent.mm.plugin.finder.live.model.a.a
    public void onApplyMicTimeout() {
    }

    @Override // com.tencent.mm.plugin.finder.live.model.a.a
    public void onApplyMicPkTimeout() {
    }

    @Override // com.tencent.mm.plugin.finder.live.model.a.a
    public void onAcceptMicTimeout(String str) {
    }

    @Override // com.tencent.mm.plugin.finder.live.model.a.a
    public void onAcceptMicPkTimeout() {
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b.c uxB;
        final /* synthetic */ Bundle uxC;
        final /* synthetic */ FinderBaseLivePluginLayout uxy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(FinderBaseLivePluginLayout finderBaseLivePluginLayout, b.c cVar, Bundle bundle) {
            super(0);
            this.uxy = finderBaseLivePluginLayout;
            this.uxB = cVar;
            this.uxC = bundle;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            boolean z;
            String str;
            String str2;
            String str3;
            Long l;
            awe awe;
            awe awe2;
            AppMethodBeat.i(247319);
            Log.i(this.uxy.TAG, "this:" + this.uxy + " isDestroy:" + this.uxy.isDestroyed() + " lastUIState:" + this.uxy.getLastUIState());
            if (!this.uxy.isDestroyed()) {
                FinderBaseLivePluginLayout.super.statusChange(this.uxB, this.uxC);
                com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
                com.tencent.mm.plugin.finder.live.model.o.a(this.uxB, this.uxC, this.uxy.getLiveData().liveInfo.liveId);
                if (this.uxy.getLastLiveState() == this.uxy.getLiveData().uEg && this.uxy.getLastUIState() == this.uxy.getLiveData().uEf) {
                    z = false;
                } else {
                    this.uxy.setLastUIState(this.uxy.getLiveData().uEf);
                    this.uxy.setLastLiveState(this.uxy.getLiveData().uEg);
                    this.uxy.applyState(this.uxy.getLiveData().uEg, this.uxy.getLiveData().uEf, this.uxC);
                    z = true;
                }
                if (z) {
                    String str4 = this.uxy.TAG;
                    StringBuilder append = new StringBuilder("statusChange lastLiveState:").append(this.uxy.getLastLiveState()).append(",lastUIState:").append(this.uxy.getLastUIState()).append(",set status:").append(this.uxB.name()).append(",liveId:");
                    com.tencent.mm.plugin.finder.live.viewmodel.g liveData = this.uxy.getLiveData();
                    if (liveData == null || (awe2 = liveData.liveInfo) == null) {
                        l = null;
                    } else {
                        l = Long.valueOf(awe2.liveId);
                    }
                    StringBuilder append2 = append.append(l.longValue()).append(",service liveId:");
                    com.tencent.mm.plugin.finder.live.model.o oVar2 = com.tencent.mm.plugin.finder.live.model.o.ujN;
                    com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = com.tencent.mm.plugin.finder.live.model.o.dfZ();
                    Log.i(str4, append2.append((dfZ == null || (awe = dfZ.liveInfo) == null) ? null : Long.valueOf(awe.liveId)).toString());
                }
                if (this.uxB == b.c.hMp) {
                    com.tencent.mm.plugin.finder.utils.af afVar = com.tencent.mm.plugin.finder.utils.af.waa;
                    StringBuilder sb = new StringBuilder();
                    com.tencent.mm.plugin.finder.utils.af afVar2 = com.tencent.mm.plugin.finder.utils.af.waa;
                    String sb2 = sb.append(com.tencent.mm.plugin.finder.utils.af.dEm()).append(this.uxy.getData().uCr.getLiveId()).toString();
                    ad.a aVar = ad.vZu;
                    com.tencent.mm.plugin.finder.utils.af.a(afVar, sb2, ad.dDK().name, null, false, true, 12);
                }
                if (this.uxB == b.c.hNp) {
                    com.tencent.mm.plugin.finder.live.viewmodel.g liveData2 = this.uxy.getLiveData();
                    Bundle bundle = this.uxC;
                    if (bundle != null) {
                        e.j jVar = e.j.hyq;
                        str3 = bundle.getString(e.j.aDj());
                    } else {
                        str3 = null;
                    }
                    liveData2.uEs = str3;
                    Log.i(this.uxy.TAG, "printStatistics:" + this.uxy.getLiveData().uEs);
                    com.tencent.mm.live.core.core.f.hys.w(this.uxC);
                    this.uxy.showStatistics(com.tencent.mm.live.core.core.f.hys.aDl());
                }
                if (this.uxB == b.c.hNJ) {
                    Bundle bundle2 = this.uxC;
                    if (bundle2 != null) {
                        str = bundle2.getString("PARAM_FINDER_LIVE_ALERT_DIALOG_TITLE", "");
                    } else {
                        str = null;
                    }
                    Bundle bundle3 = this.uxC;
                    if (bundle3 != null) {
                        str2 = bundle3.getString("PARAM_FINDER_LIVE_ALERT_DIALOG_CONTENT", "");
                    } else {
                        str2 = null;
                    }
                    Context context = this.uxy.getContext();
                    if (!(context instanceof MMActivity)) {
                        context = null;
                    }
                    MMActivity mMActivity = (MMActivity) context;
                    if (mMActivity != null) {
                        this.uxy.showAlertDialog(mMActivity, str, str2, "");
                    }
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(247319);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class l extends q implements kotlin.g.a.a<x> {
        public static final l UNm = new l();

        static {
            AppMethodBeat.i(260770);
            AppMethodBeat.o(260770);
        }

        l() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(260769);
            j.a aVar = com.tencent.mm.plugin.finder.live.component.j.UJU;
            ar liveLuckyMoneyStorage = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getLiveLuckyMoneyStorage();
            for (Map.Entry<Long, Set<String>> entry : liveLuckyMoneyStorage.tVA.entrySet()) {
                liveLuckyMoneyStorage.a(entry.getKey().longValue(), entry.getValue());
            }
            x xVar = x.SXb;
            AppMethodBeat.o(260769);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ String uhA;
        final /* synthetic */ FinderBaseLivePluginLayout uxy;
        final /* synthetic */ int uxz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(FinderBaseLivePluginLayout finderBaseLivePluginLayout, String str, int i2) {
            super(0);
            this.uxy = finderBaseLivePluginLayout;
            this.uhA = str;
            this.uxz = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(247318);
            u.a(this.uxy.getContext(), this.uhA, new u.b(this) {
                /* class com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout.f.AnonymousClass1 */
                final /* synthetic */ f uxA;

                {
                    this.uxA = r1;
                }

                @Override // com.tencent.mm.ui.base.u.b
                public final void dU(View view) {
                    WeImageView weImageView;
                    TextView textView;
                    AppMethodBeat.i(247317);
                    if (!(view == null || (textView = (TextView) view.findViewById(R.id.ird)) == null)) {
                        textView.setTextSize(1, 14.0f);
                    }
                    if (view == null || (weImageView = (WeImageView) view.findViewById(R.id.irc)) == null) {
                        AppMethodBeat.o(247317);
                        return;
                    }
                    weImageView.setImageResource(this.uxA.uxz);
                    AppMethodBeat.o(247317);
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(247318);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class j extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderBaseLivePluginLayout uxy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(FinderBaseLivePluginLayout finderBaseLivePluginLayout) {
            super(0);
            this.uxy = finderBaseLivePluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(260767);
            Log.i(this.uxy.TAG, "notifyAudienceMicUserChange");
            if (!this.uxy.diffMicUsers() || this.uxy.getLiveData().hIv.Mop == null) {
                Log.i(this.uxy.TAG, "notifyAudienceMicUserChange, but mic users no change");
            } else {
                if (this.uxy.getLastMicUserList().isEmpty()) {
                    this.uxy.fillBlurBg(this.uxy.getLiveData().hwd);
                }
                int fromDPToPix = at.fromDPToPix(this.uxy.getContext(), r.CTRL_INDEX);
                this.uxy.getLastMicUserList().clear();
                this.uxy.getLastMicUserList().addAll(this.uxy.getLiveData().UPZ);
                ViewGroup.LayoutParams layoutParams = this.uxy.getPreviewRoot().getLayoutParams();
                if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
                    layoutParams = null;
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (layoutParams2 != null) {
                    List<com.tencent.mm.plugin.finder.live.viewmodel.e> list = this.uxy.getLiveData().UPZ;
                    p.g(list, "liveData.audienceLinkMicUserList");
                    if (!list.isEmpty()) {
                        layoutParams2.topMargin = fromDPToPix;
                        layoutParams2.bottomMargin = (au.az(this.uxy.getContext()).y - ((int) (((float) (au.az(this.uxy.getContext()).x / 2)) * 1.7777778f))) - fromDPToPix;
                    } else {
                        layoutParams2.topMargin = 0;
                        layoutParams2.bottomMargin = 0;
                    }
                }
                for (com.tencent.mm.live.c.a aVar : this.uxy.getPluginList()) {
                    aVar.a(this.uxy.genAudienceMicMap(fromDPToPix), false);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(260767);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class k extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderBaseLivePluginLayout uxy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(FinderBaseLivePluginLayout finderBaseLivePluginLayout) {
            super(0);
            this.uxy = finderBaseLivePluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(260768);
            int fromDPToPix = at.fromDPToPix(this.uxy.getContext(), r.CTRL_INDEX);
            ViewGroup.LayoutParams layoutParams = this.uxy.getPreviewRoot().getLayoutParams();
            if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
                layoutParams = null;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (layoutParams2 != null) {
                com.tencent.mm.plugin.finder.live.viewmodel.e eVar = this.uxy.getLiveData().uEB;
                if (eVar == null || !eVar.UPN) {
                    layoutParams2.topMargin = 0;
                    layoutParams2.bottomMargin = 0;
                } else {
                    layoutParams2.topMargin = fromDPToPix;
                    layoutParams2.bottomMargin = (au.az(this.uxy.getContext()).y - ((int) (((float) (au.az(this.uxy.getContext()).x / 2)) * 1.7777778f))) - fromDPToPix;
                }
            }
            for (com.tencent.mm.live.c.a aVar : this.uxy.getPluginList()) {
                aVar.a(this.uxy.genPkMicMap(fromDPToPix), true);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(260768);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class i extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ int $errCode;
        final /* synthetic */ FinderBaseLivePluginLayout uxy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(FinderBaseLivePluginLayout finderBaseLivePluginLayout, int i2) {
            super(0);
            this.uxy = finderBaseLivePluginLayout;
            this.$errCode = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(260766);
            Log.i(this.uxy.TAG, "handleRecvLuckyMoneyErr errCode:" + this.$errCode);
            switch (this.$errCode) {
                case 1:
                    Bundle bundle = new Bundle();
                    bundle.putInt("PARAM_FINDER_BOTTOM_TIP_SCENE", 1);
                    this.uxy.statusChange(b.c.wlu, bundle);
                    break;
                case 2:
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("PARAM_FINDER_BOTTOM_TIP_SCENE", 2);
                    this.uxy.statusChange(b.c.wlu, bundle2);
                    break;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(260766);
            return xVar;
        }
    }

    @Override // com.tencent.mm.live.b.j
    public void onFinderLiveApplyLiveMic(com.tencent.mm.live.b.h hVar) {
        p.h(hVar, "info");
        long j2 = hVar.liveId;
        long j3 = hVar.hFK;
        String str = hVar.hFQ;
        if (str == null) {
            str = "";
        }
        String str2 = hVar.hFR;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = hVar.hFS;
        if (str3 == null) {
            str3 = "";
        }
        String str4 = hVar.hFO;
        if (str4 == null) {
            str4 = "";
        }
        int i2 = hVar.scene;
        int i3 = hVar.businessType;
        String str5 = hVar.hFT;
        if (str5 == null) {
            str5 = "";
        }
        String str6 = hVar.hFU;
        if (str6 == null) {
            str6 = "";
        }
        boolean z = true;
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = this.liveData;
        if (gVar == null) {
            p.btv("liveData");
        }
        Iterator<T> it = gVar.uDF.iterator();
        while (it.hasNext()) {
            if (Util.isEqual(it.next().finderUsername, str3)) {
                z = false;
            }
        }
        if (z) {
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = this.liveData;
            if (gVar2 == null) {
                p.btv("liveData");
            }
            gVar2.uDG.add(str);
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar3 = this.liveData;
            if (gVar3 == null) {
                p.btv("liveData");
            }
            gVar3.uDF.add(new com.tencent.mm.plugin.finder.live.viewmodel.b(j2, j3, str4, str3, str2, str, i2, i3, null, str6, str5, 256));
            com.tencent.mm.plugin.finder.live.model.q qVar = com.tencent.mm.plugin.finder.live.model.q.ukd;
            com.tencent.mm.plugin.finder.live.model.q.dgx();
        }
    }

    @Override // com.tencent.mm.live.b.j
    public void onFinderLiveAcceptLiveMic(com.tencent.mm.live.b.g gVar) {
        p.h(gVar, "info");
        long j2 = gVar.liveId;
        long j3 = gVar.hFK;
        String str = gVar.hFL;
        if (str == null) {
            str = "";
        }
        String str2 = gVar.hFN;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = gVar.hFM;
        if (str3 == null) {
            str3 = "";
        }
        String str4 = gVar.hFO;
        if (str4 == null) {
            str4 = "";
        }
        int i2 = gVar.scene;
        int i3 = gVar.businessType;
        String str5 = gVar.hFP;
        if (str5 == null) {
            str5 = "";
        }
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = this.liveData;
        if (gVar2 == null) {
            p.btv("liveData");
        }
        com.tencent.mm.plugin.finder.live.viewmodel.b bVar = gVar2.uDE;
        if (bVar != null) {
            bVar.liveId = j2;
        }
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar3 = this.liveData;
        if (gVar3 == null) {
            p.btv("liveData");
        }
        com.tencent.mm.plugin.finder.live.viewmodel.b bVar2 = gVar3.uDE;
        if (bVar2 != null) {
            bVar2.hFK = j3;
        }
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar4 = this.liveData;
        if (gVar4 == null) {
            p.btv("liveData");
        }
        com.tencent.mm.plugin.finder.live.viewmodel.b bVar3 = gVar4.uDE;
        if (bVar3 != null) {
            bVar3.uCo = str;
        }
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar5 = this.liveData;
        if (gVar5 == null) {
            p.btv("liveData");
        }
        com.tencent.mm.plugin.finder.live.viewmodel.b bVar4 = gVar5.uDE;
        if (bVar4 != null) {
            bVar4.finderUsername = str2;
        }
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar6 = this.liveData;
        if (gVar6 == null) {
            p.btv("liveData");
        }
        com.tencent.mm.plugin.finder.live.viewmodel.b bVar5 = gVar6.uDE;
        if (bVar5 != null) {
            bVar5.uCn = str3;
        }
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar7 = this.liveData;
        if (gVar7 == null) {
            p.btv("liveData");
        }
        com.tencent.mm.plugin.finder.live.viewmodel.b bVar6 = gVar7.uDE;
        if (bVar6 != null) {
            bVar6.hFO = str4;
        }
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar8 = this.liveData;
        if (gVar8 == null) {
            p.btv("liveData");
        }
        com.tencent.mm.plugin.finder.live.viewmodel.b bVar7 = gVar8.uDE;
        if (bVar7 != null) {
            bVar7.scene = i2;
        }
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar9 = this.liveData;
        if (gVar9 == null) {
            p.btv("liveData");
        }
        com.tencent.mm.plugin.finder.live.viewmodel.b bVar8 = gVar9.uDE;
        if (bVar8 != null) {
            bVar8.businessType = i3;
        }
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar10 = this.liveData;
        if (gVar10 == null) {
            p.btv("liveData");
        }
        com.tencent.mm.plugin.finder.live.viewmodel.b bVar9 = gVar10.uDE;
        if (bVar9 != null) {
            bVar9.uCp = str5;
        }
        com.tencent.mm.plugin.finder.live.model.q qVar = com.tencent.mm.plugin.finder.live.model.q.ukd;
        com.tencent.mm.plugin.finder.live.model.q.dgy();
    }
}
