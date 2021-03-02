package com.tencent.mm.plugin.finder.live.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.hilive.mediasdk.SdkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.f;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.c.aw;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.b.h;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.live.core.core.e;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.core.view.TRTCVideoLayoutManager;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.cgi.cn;
import com.tencent.mm.plugin.finder.live.component.j;
import com.tencent.mm.plugin.finder.live.model.e;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.model.q;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.plugin.aa;
import com.tencent.mm.plugin.finder.live.plugin.ac;
import com.tencent.mm.plugin.finder.live.plugin.ae;
import com.tencent.mm.plugin.finder.live.plugin.af;
import com.tencent.mm.plugin.finder.live.plugin.ah;
import com.tencent.mm.plugin.finder.live.plugin.aj;
import com.tencent.mm.plugin.finder.live.plugin.al;
import com.tencent.mm.plugin.finder.live.plugin.ap;
import com.tencent.mm.plugin.finder.live.plugin.aq;
import com.tencent.mm.plugin.finder.live.plugin.ar;
import com.tencent.mm.plugin.finder.live.plugin.as;
import com.tencent.mm.plugin.finder.live.plugin.at;
import com.tencent.mm.plugin.finder.live.plugin.av;
import com.tencent.mm.plugin.finder.live.plugin.ba;
import com.tencent.mm.plugin.finder.live.plugin.bb;
import com.tencent.mm.plugin.finder.live.plugin.bd;
import com.tencent.mm.plugin.finder.live.plugin.bf;
import com.tencent.mm.plugin.finder.live.plugin.bh;
import com.tencent.mm.plugin.finder.live.plugin.bj;
import com.tencent.mm.plugin.finder.live.plugin.bl;
import com.tencent.mm.plugin.finder.live.plugin.bm;
import com.tencent.mm.plugin.finder.live.plugin.bo;
import com.tencent.mm.plugin.finder.live.plugin.bp;
import com.tencent.mm.plugin.finder.live.plugin.br;
import com.tencent.mm.plugin.finder.live.plugin.bt;
import com.tencent.mm.plugin.finder.live.plugin.bu;
import com.tencent.mm.plugin.finder.live.plugin.bv;
import com.tencent.mm.plugin.finder.live.plugin.bw;
import com.tencent.mm.plugin.finder.live.plugin.by;
import com.tencent.mm.plugin.finder.live.plugin.bz;
import com.tencent.mm.plugin.finder.live.plugin.cb;
import com.tencent.mm.plugin.finder.live.plugin.ce;
import com.tencent.mm.plugin.finder.live.plugin.v;
import com.tencent.mm.plugin.finder.live.plugin.x;
import com.tencent.mm.plugin.finder.live.plugin.y;
import com.tencent.mm.plugin.finder.live.widget.f;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.utils.ad;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.avg;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awl;
import com.tencent.mm.protocal.protobuf.awm;
import com.tencent.mm.protocal.protobuf.awn;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.fgx;
import com.tencent.mm.protocal.protobuf.fhl;
import com.tencent.mm.protocal.protobuf.fhm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.trtc.TRTCCloudDef;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ0\u0010s\u001a\u00020B2\u0006\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020w2\u0006\u0010y\u001a\u00020w2\u0006\u0010z\u001a\u00020VH\u0016J\b\u0010{\u001a\u00020BH\u0002J\b\u0010|\u001a\u00020BH\u0002J\b\u0010}\u001a\u00020BH\u0002J%\u0010~\u001a\u00020B2\u0006\u0010\u001a\u00020V2\u0007\u0010\u0001\u001a\u00020V2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J$\u0010\u0001\u001a\u00020B2\u0006\u0010t\u001a\u00020u2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020wH\u0016J\t\u0010\u0001\u001a\u00020BH\u0002J\t\u0010\u0001\u001a\u00020BH\u0002J\u0015\u0010\u0001\u001a\u00020B2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\u0007\u0010\u0001\u001a\u00020BJ\t\u0010\u0001\u001a\u00020BH\u0002J\u0014\u0010\u0001\u001a\u00020B2\t\b\u0002\u0010\u0001\u001a\u00020wH\u0002J\t\u0010\u0001\u001a\u00020BH\u0002J\t\u0010\u0001\u001a\u00020BH\u0002J\t\u0010\u0001\u001a\u00020VH\u0016J\t\u0010\u0001\u001a\u00020VH\u0016J\t\u0010\u0001\u001a\u0004\u0018\u00010bJ\u000f\u0010\u0001\u001a\u0004\u0018\u00010V¢\u0006\u0003\u0010\u0001J\u001b\u0010\u0001\u001a\u00020B2\u0007\u0010\u0001\u001a\u00020V2\u0007\u0010\u0001\u001a\u00020\u000bH\u0002J9\u0010\u0001\u001a\u00020B2\u0007\u0010\u0001\u001a\u00020V2\u0007\u0010\u0001\u001a\u00020V2\u0007\u0010\u0001\u001a\u00020V2\t\u0010\u0001\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\t\u0010\u0001\u001a\u00020BH\u0002J\t\u0010 \u0001\u001a\u00020BH\u0002J\t\u0010¡\u0001\u001a\u00020BH\u0002J\u0007\u0010¢\u0001\u001a\u00020BJ\t\u0010£\u0001\u001a\u00020BH\u0002J\t\u0010¤\u0001\u001a\u00020BH\u0002J\t\u0010¥\u0001\u001a\u00020wH\u0002J\t\u0010¦\u0001\u001a\u00020wH\u0002J\t\u0010§\u0001\u001a\u00020BH\u0002J\t\u0010¨\u0001\u001a\u00020BH\u0002J\t\u0010©\u0001\u001a\u00020BH\u0016J\t\u0010ª\u0001\u001a\u00020\u000bH\u0016J\t\u0010«\u0001\u001a\u00020BH\u0002J\u001a\u0010¬\u0001\u001a\u00020B2\t\u0010\u0001\u001a\u0004\u0018\u00010VH\u0002¢\u0006\u0003\u0010­\u0001J\u0013\u0010®\u0001\u001a\u00020B2\b\u0010¯\u0001\u001a\u00030°\u0001H\u0002J\u0013\u0010±\u0001\u001a\u00020B2\b\u0010¯\u0001\u001a\u00030°\u0001H\u0016J\t\u0010²\u0001\u001a\u00020BH\u0016J\t\u0010³\u0001\u001a\u00020wH\u0016J\u001b\u0010´\u0001\u001a\u00020B2\u0007\u0010µ\u0001\u001a\u00020V2\u0007\u0010¶\u0001\u001a\u00020\u000bH\u0016J\u0012\u0010·\u0001\u001a\u00020B2\u0007\u0010\u0001\u001a\u00020VH\u0002J\u0012\u0010¸\u0001\u001a\u00020B2\u0007\u0010\u0001\u001a\u00020VH\u0002J\u0013\u0010¹\u0001\u001a\u00020B2\b\u0010¯\u0001\u001a\u00030º\u0001H\u0016J\u0013\u0010»\u0001\u001a\u00020B2\b\u0010¼\u0001\u001a\u00030½\u0001H\u0014J\u001e\u0010¾\u0001\u001a\u00020B2\u0007\u0010¿\u0001\u001a\u00020V2\n\u0010À\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\t\u0010Á\u0001\u001a\u00020BH\u0002J\u0012\u0010Â\u0001\u001a\u00020B2\u0007\u0010Ã\u0001\u001a\u00020wH\u0016J2\u0010Ä\u0001\u001a\u00020B2\u0007\u0010\u0001\u001a\u00020V2\u0007\u0010\u0001\u001a\u00020V2\t\u0010\u0001\u001a\u0004\u0018\u00010\u000b2\n\u0010Å\u0001\u001a\u0005\u0018\u00010Æ\u0001H\u0016J\t\u0010Ç\u0001\u001a\u00020BH\u0002J\t\u0010È\u0001\u001a\u00020BH\u0016J\t\u0010É\u0001\u001a\u00020BH\u0002J\t\u0010Ê\u0001\u001a\u00020BH\u0002J\t\u0010Ë\u0001\u001a\u00020BH\u0002J\t\u0010Ì\u0001\u001a\u00020BH\u0016J\t\u0010Í\u0001\u001a\u00020BH\u0002J\t\u0010Î\u0001\u001a\u00020BH\u0016J\u0012\u0010Ï\u0001\u001a\u00020B2\u0007\u0010Ð\u0001\u001a\u00020\u000bH\u0002J\t\u0010Ñ\u0001\u001a\u00020BH\u0016J\t\u0010Ò\u0001\u001a\u00020BH\u0002J\t\u0010Ó\u0001\u001a\u00020BH\u0002J\u001f\u0010Ô\u0001\u001a\u00020B2\b\u0010Õ\u0001\u001a\u00030Ö\u00012\n\u0010À\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\t\u0010×\u0001\u001a\u00020BH\u0016J\t\u0010Ø\u0001\u001a\u00020BH\u0002J\t\u0010Ù\u0001\u001a\u00020BH\u0002J\t\u0010Ú\u0001\u001a\u00020BH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010(\u001a\u0004\u0018\u00010)8BX\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b*\u0010+R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010HX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010LX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010PX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010TX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020VX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u0004\u0018\u00010XX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u0004\u0018\u00010ZX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\R\u0010\u0010]\u001a\u0004\u0018\u00010^X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010_\u001a\u0004\u0018\u00010`X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010a\u001a\u0004\u0018\u00010bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010c\u001a\u0004\u0018\u00010dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020hX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010i\u001a\u0004\u0018\u00010jX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010k\u001a\u0004\u0018\u00010lX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010m\u001a\u0004\u0018\u00010nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010o\u001a\u0004\u0018\u00010pX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010q\u001a\u0004\u0018\u00010rX\u000e¢\u0006\u0002\n\u0000¨\u0006Û\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout;", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "LOOPTAG", "", "TAG", "bottomOptionPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorBottomOptionPlugin;", "getBottomOptionPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorBottomOptionPlugin;", "setBottomOptionPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorBottomOptionPlugin;)V", "bottomTipPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBottomTipPlugin;", "closePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorClosePlugin;", "commentPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin;", "commentPluginInInput", "commentRealNamePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentRealNamePlugin;", "commonInfoPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin;", "getCommonInfoPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin;", "setCommonInfoPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin;)V", "confettiPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLikeConfettiPlugin;", "exceptionPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorExceptionPlugin;", "finderLiveAfterPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin;", "finderLiveHistoryTips", "Landroid/view/View;", "getFinderLiveHistoryTips", "()Landroid/view/View;", "finderLiveHistoryTips$delegate", "Lkotlin/Lazy;", "giftPanelPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftPanelPlugin;", "giftPlayPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftPlayPlugin;", "giftQueuePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin;", "giftSendPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin;", "identifyPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveIdentifyTipPlugin;", "inputPluigin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin;", "linkLisencePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLinkMicLisencePlugin;", "linkMicStatePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLinkMicStatePlugin;", "liveCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "liveMessageCallback", "Lkotlin/Function0;", "", "liveTXLivePlayerPlygin", "Lcom/tencent/mm/live/plugin/LiveTXLivePlayerPlygin;", "lotteryBubblePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryBubblePlugin;", "lotteryCardPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin;", "luckyMoneyPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLuckyMoneyBubblePlugin;", "memberListPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMemberListPlugin;", "micAudioPreviewPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMicAudioPreviewPlugin;", "micDecoratePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMicDecoratePlugin;", "moreActionPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreActionPlugin;", "moreLiveEntrancePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreLiveEntrancePlugin;", "originCommentBottomMargin", "", "postPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveNewVisitorPostPlugin;", "previewPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorPreviewPlugin;", "getReportObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "screenClearPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenClearPlugin;", "shadowPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShadowPlugin;", "shoppingBubblePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingBubblePlugin;", "shoppingListPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin;", "timerCallback", "Lcom/tencent/mm/plugin/finder/live/view/VisitorTimerCallbackImpl;", "timerThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "titleInfoPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin;", "topCommentPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTopCommentPlugin;", "videoOrientationPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVideoOrientationPlugin;", "visitorRoleGuidePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorRoleGuidePlugin;", "wecoinHotExplainPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorExplainWecoinHotPlugin;", "activate", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "isFinished", "", "isFromFloat", "restart", "curIndex", "adjustLayout", "adjustLayoutCDN", "adjustLayoutTRTC", "applyState", "liveState", "uiState", "extraMsg", "Landroid/os/Bundle;", "bindData", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "isInitPos", "checkAnchorContactInfo", "checkFinderObject", "checkLinkMicStateWhenJoin", "micInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMicInfo;", "checkMiniWindow", "checkVisitorRoleWhenDirectStart", "chooseAudienceMode", "fromMiniWin", "directStartLive", "exitLive", "getLiveRole", "getRelativeLayoutId", "getShoppingBubblePlugin", "getVideoOrientationPluginVisiableVisable", "()Ljava/lang/Integer;", "handleJoinErr", "errCode", "errMsg", "handleLinkMicRequest", "micType", "errType", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveApplyMicWithAudienceResponse;", "hideBottomAraePlugin", "hidePlugins", "initMemberListPlugin", "initPlugins", "initShoppingPlugin", "initVisitorRoleGuidePlugin", "isFloatMode", "isNormalMode", "joinLive", "miniWindow", "mount", "name", "notifyLiveFinish", "onAccepLinkMicOthers", "(Ljava/lang/Integer;)V", "onAcceptLinkMicSelf", "info", "Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "onAcceptLiveMic", "onApplyMicTimeout", "onBackPress", "onCallStateChanged", "state", "incomingNumber", "onCloseLinkMicOthers", "onCloseLinkMicSelf", "onCloseLiveMic", "Lcom/tencent/mm/live/model/CloseLiveMicInfo;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onLiveEventCallback", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "param", "onLiveStartedWait", "onRotationSwitchChange", "rotationEnable", "onSceneEnd", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "parseInjectEvent", "pause", "postCloseLinkMsg", "prepareFinish", "prepareShopping", "release", "restoreLinkMicUI", "resume", "showRealNameBottomSheet", "realNameUrl", "start", "startLiveVideo", "startTimer", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "stop", "stopLiveVideo", "stopTimer", "trySwitchCdnStream", "plugin-finder_release"})
public final class FinderLiveVisitorPluginLayout extends FinderBaseLivePluginLayout implements i {
    private final String LOOPTAG;
    private final String TAG;
    private HashMap _$_findViewCache;
    private bp bottomOptionPlugin;
    private aq bottomTipPlugin;
    private br closePlugin;
    private v commentPlugin;
    private v commentPluginInInput;
    private x commentRealNamePlugin;
    private y commonInfoPlugin;
    private aj confettiPlugin;
    private bt exceptionPlugin;
    private bo finderLiveAfterPlugin;
    private final f finderLiveHistoryTips$delegate;
    private aa giftPanelPlugin;
    private ac giftPlayPlugin;
    private ae giftQueuePlugin;
    private af giftSendPlugin;
    private ar identifyPlugin;
    private ah inputPluigin;
    private bv linkLisencePlugin;
    private bw linkMicStatePlugin;
    private b liveCore;
    private a<kotlin.x> liveMessageCallback;
    private aw liveTXLivePlayerPlygin;
    private al lotteryBubblePlugin;
    private by lotteryCardPlugin;
    private as luckyMoneyPlugin;
    private ap memberListPlugin;
    private bl micAudioPreviewPlugin;
    private cb micDecoratePlugin;
    private at moreActionPlugin;
    private av moreLiveEntrancePlugin;
    private int originCommentBottomMargin;
    private com.tencent.mm.plugin.finder.live.plugin.aw postPlugin;
    private bz previewPlugin;
    private final bbn reportObj;
    private ba screenClearPlugin;
    private bb shadowPlugin;
    private bd shoppingBubblePlugin;
    private bf shoppingListPlugin;
    private k timerCallback;
    private MTimerHandler timerThread;
    private bh titleInfoPlugin;
    private bj topCommentPlugin;
    private bm videoOrientationPlugin;
    private ce visitorRoleGuidePlugin;
    private bu wecoinHotExplainPlugin;

    @l(hxD = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            AppMethodBeat.i(247567);
            int[] iArr = new int[b.c.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[b.c.hLB.ordinal()] = 1;
            $EnumSwitchMapping$0[b.c.hLV.ordinal()] = 2;
            $EnumSwitchMapping$0[b.c.hLC.ordinal()] = 3;
            $EnumSwitchMapping$0[b.c.hLD.ordinal()] = 4;
            $EnumSwitchMapping$0[b.c.hLQ.ordinal()] = 5;
            $EnumSwitchMapping$0[b.c.hNh.ordinal()] = 6;
            $EnumSwitchMapping$0[b.c.hNl.ordinal()] = 7;
            $EnumSwitchMapping$0[b.c.hMB.ordinal()] = 8;
            $EnumSwitchMapping$0[b.c.hMb.ordinal()] = 9;
            $EnumSwitchMapping$0[b.c.hMa.ordinal()] = 10;
            $EnumSwitchMapping$0[b.c.hLT.ordinal()] = 11;
            $EnumSwitchMapping$0[b.c.hLU.ordinal()] = 12;
            $EnumSwitchMapping$0[b.c.hME.ordinal()] = 13;
            $EnumSwitchMapping$0[b.c.hMd.ordinal()] = 14;
            $EnumSwitchMapping$0[b.c.hNL.ordinal()] = 15;
            $EnumSwitchMapping$0[b.c.hNP.ordinal()] = 16;
            $EnumSwitchMapping$0[b.c.hNQ.ordinal()] = 17;
            $EnumSwitchMapping$0[b.c.hNR.ordinal()] = 18;
            $EnumSwitchMapping$0[b.c.hNV.ordinal()] = 19;
            $EnumSwitchMapping$0[b.c.hLR.ordinal()] = 20;
            $EnumSwitchMapping$0[b.c.hMV.ordinal()] = 21;
            $EnumSwitchMapping$0[b.c.wlu.ordinal()] = 22;
            AppMethodBeat.o(247567);
        }
    }

    private final View getFinderLiveHistoryTips() {
        AppMethodBeat.i(247643);
        View view = (View) this.finderLiveHistoryTips$delegate.getValue();
        AppMethodBeat.o(247643);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(247715);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(247715);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(247714);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(247714);
        return view;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveVisitorPluginLayout(Context context, AttributeSet attributeSet, bbn bbn) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(247704);
        this.reportObj = bbn;
        this.TAG = "Finder.LiveVisitorPluginLayout@" + hashCode();
        this.LOOPTAG = "Finder.LOOP_LiveVisitorPluginLayout@" + hashCode();
        this.finderLiveHistoryTips$delegate = g.ah(new FinderLiveVisitorPluginLayout$finderLiveHistoryTips$2(this));
        this.liveMessageCallback = new FinderLiveVisitorPluginLayout$liveMessageCallback$1(this);
        this.timerCallback = new k(this, this.LOOPTAG);
        this.timerThread = new MTimerHandler("LiveCommonInfoPlugin::Timer", (MTimerHandler.CallBack) this.timerCallback, true);
        AppMethodBeat.o(247704);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FinderLiveVisitorPluginLayout(Context context, AttributeSet attributeSet, bbn bbn, int i2, j jVar) {
        this(context, attributeSet, (i2 & 4) != 0 ? null : bbn);
        AppMethodBeat.i(247705);
        AppMethodBeat.o(247705);
    }

    public static final /* synthetic */ void access$checkLinkMicStateWhenJoin(FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout, awn awn) {
        AppMethodBeat.i(260871);
        finderLiveVisitorPluginLayout.checkLinkMicStateWhenJoin(awn);
        AppMethodBeat.o(260871);
    }

    public static final /* synthetic */ void access$handleJoinErr(FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout, int i2, String str) {
        AppMethodBeat.i(247707);
        finderLiveVisitorPluginLayout.handleJoinErr(i2, str);
        AppMethodBeat.o(247707);
    }

    public static final /* synthetic */ void access$handleLinkMicRequest(FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout, int i2, int i3, int i4, String str, avg avg) {
        AppMethodBeat.i(247711);
        finderLiveVisitorPluginLayout.handleLinkMicRequest(i2, i3, i4, str, avg);
        AppMethodBeat.o(247711);
    }

    public static final /* synthetic */ void access$joinLive(FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout) {
        AppMethodBeat.i(260870);
        finderLiveVisitorPluginLayout.joinLive();
        AppMethodBeat.o(260870);
    }

    public static final /* synthetic */ void access$restoreLinkMicUI(FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout) {
        AppMethodBeat.i(247708);
        finderLiveVisitorPluginLayout.restoreLinkMicUI();
        AppMethodBeat.o(247708);
    }

    public static final /* synthetic */ void access$showRealNameBottomSheet(FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout, String str) {
        AppMethodBeat.i(247710);
        finderLiveVisitorPluginLayout.showRealNameBottomSheet(str);
        AppMethodBeat.o(247710);
    }

    public static final /* synthetic */ void access$trySwitchCdnStream(FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout) {
        AppMethodBeat.i(247712);
        finderLiveVisitorPluginLayout.trySwitchCdnStream();
        AppMethodBeat.o(247712);
    }

    public final bbn getReportObj() {
        return this.reportObj;
    }

    public final y getCommonInfoPlugin() {
        return this.commonInfoPlugin;
    }

    public final void setCommonInfoPlugin(y yVar) {
        this.commonInfoPlugin = yVar;
    }

    public final bp getBottomOptionPlugin() {
        return this.bottomOptionPlugin;
    }

    public final void setBottomOptionPlugin(bp bpVar) {
        this.bottomOptionPlugin = bpVar;
    }

    public final void initPlugins() {
        View finderLiveHistoryTips;
        AppMethodBeat.i(247644);
        View findViewById = findViewById(R.id.emp);
        p.g(findViewById, "findViewById(R.id.live_tx_live_player_ui_root)");
        this.liveTXLivePlayerPlygin = new aw((ViewGroup) findViewById, this);
        View findViewById2 = findViewById(R.id.ek6);
        p.g(findViewById2, "findViewById(R.id.live_preview_ui_root)");
        this.previewPlugin = new bz((ViewGroup) findViewById2, this);
        if (this.shadowPlugin == null) {
            View findViewById3 = findViewById(R.id.elk);
            p.g(findViewById3, "findViewById(R.id.live_shadow_ui_root)");
            this.shadowPlugin = new bb((ViewGroup) findViewById3, this);
        }
        if (this.lotteryBubblePlugin == null) {
            View findViewById4 = findViewById(R.id.cu8);
            p.g(findViewById4, "findViewById(R.id.finder_live_lottery_bubble_root)");
            this.lotteryBubblePlugin = new al((ViewGroup) findViewById4, this);
        }
        if (this.titleInfoPlugin == null) {
            View findViewById5 = findViewById(R.id.emn);
            p.g(findViewById5, "findViewById(R.id.live_title_ui_root)");
            this.titleInfoPlugin = new bh((ViewGroup) findViewById5, this, this.reportObj);
        }
        if (this.commonInfoPlugin == null) {
            View findViewById6 = findViewById(R.id.egr);
            p.g(findViewById6, "findViewById(R.id.live_common_info_ui_root)");
            this.commonInfoPlugin = new y((ViewGroup) findViewById6, this);
        }
        if (this.topCommentPlugin == null) {
            View findViewById7 = findViewById(R.id.cyi);
            p.g(findViewById7, "findViewById(R.id.finder_live_top_comment_ui_root)");
            this.topCommentPlugin = new bj((ViewGroup) findViewById7, this);
        }
        if (this.finderLiveAfterPlugin == null) {
            View findViewById8 = findViewById(R.id.cyu);
            p.g(findViewById8, "findViewById(R.id.finder…ve_visitor_after_ui_root)");
            this.finderLiveAfterPlugin = new bo((ViewGroup) findViewById8, this);
        }
        if (this.postPlugin == null) {
            View findViewById9 = findViewById(R.id.cz7);
            p.g(findViewById9, "findViewById(R.id.finder…ive_visitor_post_ui_root)");
            this.postPlugin = new com.tencent.mm.plugin.finder.live.plugin.aw((ViewGroup) findViewById9, this);
        }
        if (this.identifyPlugin == null) {
            View findViewById10 = findViewById(R.id.jx5);
            p.g(findViewById10, "findViewById(R.id.finder…dentify_tips_layout_root)");
            this.identifyPlugin = new ar((ViewGroup) findViewById10, this);
        }
        if (this.commentPlugin == null) {
            View findViewById11 = findViewById(R.id.cps);
            p.g(findViewById11, "findViewById(R.id.finder_live_comment_ui_root)");
            this.commentPlugin = new v((ViewGroup) findViewById11, this);
        }
        if (this.inputPluigin == null) {
            View findViewById12 = findViewById(R.id.ehp);
            p.g(findViewById12, "findViewById(R.id.live_input_ui_root)");
            this.inputPluigin = new ah((ViewGroup) findViewById12, this);
        }
        if (this.closePlugin == null) {
            View findViewById13 = findViewById(R.id.ene);
            p.g(findViewById13, "findViewById(R.id.live_visitor_close_ui_root)");
            this.closePlugin = new br((ViewGroup) findViewById13, this);
        }
        if (this.confettiPlugin == null) {
            View findViewById14 = findViewById(R.id.ehv);
            p.g(findViewById14, "findViewById(R.id.live_like_confetti_ui_root)");
            this.confettiPlugin = new aj((ViewGroup) findViewById14, this);
        }
        if (this.videoOrientationPlugin == null) {
            View findViewById15 = findViewById(R.id.cyr);
            p.g(findViewById15, "findViewById(R.id.finder…e_video_orientation_root)");
            this.videoOrientationPlugin = new bm((ViewGroup) findViewById15, this);
        }
        if (this.moreActionPlugin == null) {
            View findViewById16 = findViewById(R.id.cvz);
            p.g(findViewById16, "findViewById(R.id.finder_live_more_action_ui_root)");
            ViewGroup viewGroup = (ViewGroup) findViewById16;
            FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout = this;
            Context context = getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(247644);
                throw tVar;
            }
            this.moreActionPlugin = new at(viewGroup, finderLiveVisitorPluginLayout, (MMActivity) context);
        }
        if (this.screenClearPlugin == null) {
            View findViewById17 = findViewById(R.id.cxb);
            p.g(findViewById17, "findViewById(R.id.finder_live_screen_clear_view)");
            this.screenClearPlugin = new ba((ViewGroup) findViewById17, this);
        }
        if (this.exceptionPlugin == null) {
            View findViewById18 = findViewById(R.id.cyz);
            p.g(findViewById18, "findViewById(R.id.finder_live_visitor_exception)");
            this.exceptionPlugin = new bt((ViewGroup) findViewById18, this);
        }
        if (this.lotteryCardPlugin == null) {
            View findViewById19 = findViewById(R.id.cu9);
            p.g(findViewById19, "findViewById(R.id.finder_live_lottery_card_root)");
            this.lotteryCardPlugin = new by((ViewGroup) findViewById19, this);
        }
        if (this.giftPanelPlugin == null) {
            View findViewById20 = findViewById(R.id.cqo);
            p.g(findViewById20, "findViewById(R.id.finder_live_gift_panel_ui_root)");
            this.giftPanelPlugin = new aa((ViewGroup) findViewById20, this);
        }
        if (this.giftPlayPlugin == null) {
            View findViewById21 = findViewById(R.id.cqt);
            p.g(findViewById21, "findViewById(R.id.finder_live_gift_play_ui_root)");
            this.giftPlayPlugin = new ac((ViewGroup) findViewById21, this);
        }
        ae aeVar = this.giftQueuePlugin;
        if (aeVar == null) {
            View findViewById22 = findViewById(R.id.cr1);
            p.g(findViewById22, "findViewById(R.id.finder_live_gift_queue_ui_root)");
            View findViewById23 = findViewById(R.id.jx4);
            p.g(findViewById23, "findViewById(R.id.finder…e_gift_queue_outer_space)");
            aeVar = new ae((ViewGroup) findViewById22, this, getLiveData().uDw, (ViewGroup) findViewById23, true);
        }
        this.giftQueuePlugin = aeVar;
        af afVar = this.giftSendPlugin;
        if (afVar == null) {
            View findViewById24 = findViewById(R.id.cr2);
            p.g(findViewById24, "findViewById(R.id.finder_live_gift_send_again)");
            afVar = new af((ViewGroup) findViewById24, this);
        }
        this.giftSendPlugin = afVar;
        if (this.wecoinHotExplainPlugin == null) {
            View findViewById25 = findViewById(R.id.cq0);
            p.g(findViewById25, "findViewById(R.id.finder…plain_wecoin_hot_ui_root)");
            this.wecoinHotExplainPlugin = new bu((ViewGroup) findViewById25, this);
        }
        if (this.linkMicStatePlugin == null) {
            View findViewById26 = findViewById(R.id.ctw);
            p.g(findViewById26, "findViewById(R.id.finder_live_link_state_ui_root)");
            this.linkMicStatePlugin = new bw((ViewGroup) findViewById26, this);
        }
        if (this.micDecoratePlugin == null) {
            View findViewById27 = findViewById(R.id.jy5);
            p.g(findViewById27, "findViewById(R.id.finder…ive_mic_decorate_ui_root)");
            this.micDecoratePlugin = new cb((ViewGroup) findViewById27, this, this.reportObj);
        }
        if (this.micAudioPreviewPlugin == null) {
            View findViewById28 = findViewById(R.id.jy3);
            p.g(findViewById28, "findViewById(R.id.finder…ic_audio_preview_ui_root)");
            this.micAudioPreviewPlugin = new bl((ViewGroup) findViewById28, this, (byte) 0);
        }
        if (this.linkLisencePlugin == null) {
            View findViewById29 = findViewById(R.id.cnz);
            p.g(findViewById29, "findViewById(R.id.finder…link_mic_lisence_ui_root)");
            this.linkLisencePlugin = new bv((ViewGroup) findViewById29, this);
        }
        if (this.bottomOptionPlugin == null) {
            View findViewById30 = findViewById(R.id.cyv);
            p.g(findViewById30, "findViewById(R.id.finder…or_bottom_option_ui_root)");
            this.bottomOptionPlugin = new bp((ViewGroup) findViewById30, this);
        }
        if (this.shoppingBubblePlugin == null) {
            bp bpVar = this.bottomOptionPlugin;
            if (bpVar == null) {
                p.hyc();
            }
            ViewGroup viewGroup2 = bpVar.uuX.hwr;
            View findViewById31 = findViewById(R.id.cxs);
            p.g(findViewById31, "findViewById(R.id.finder…ive_shopping_widget_root)");
            this.shoppingBubblePlugin = new bd(viewGroup2, (ViewGroup) findViewById31, this);
        }
        if (this.luckyMoneyPlugin == null) {
            View findViewById32 = findViewById(R.id.jy2);
            p.g(findViewById32, "findViewById(R.id.finder_live_lucky_money_ui_root)");
            this.luckyMoneyPlugin = new as((ViewGroup) findViewById32, this);
        }
        if (this.bottomTipPlugin == null) {
            View findViewById33 = findViewById(R.id.jwv);
            p.g(findViewById33, "findViewById(R.id.finder_live_bottom_tip_ui_root)");
            this.bottomTipPlugin = new aq((ViewGroup) findViewById33, this);
        }
        av avVar = this.moreLiveEntrancePlugin;
        if (avVar == null) {
            View findViewById34 = findViewById(R.id.cw0);
            p.g(findViewById34, "findViewById(R.id.finder…more_live_entrance_group)");
            avVar = new av((ViewGroup) findViewById34, this, this.reportObj);
        }
        this.moreLiveEntrancePlugin = avVar;
        initShoppingPlugin();
        initMemberListPlugin();
        aj ajVar = this.confettiPlugin;
        if (ajVar != null) {
            ajVar.a(getData().uCr);
        }
        y yVar = this.commonInfoPlugin;
        if (yVar != null) {
            getData();
            yVar.aHy();
        }
        c cVar = c.vCb;
        if (c.dwW().value().intValue() == 1 && !isCurLive()) {
            com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
            if (!com.tencent.mm.plugin.finder.utils.y.dCU() && (finderLiveHistoryTips = getFinderLiveHistoryTips()) != null) {
                finderLiveHistoryTips.setVisibility(0);
                AppMethodBeat.o(247644);
                return;
            }
        }
        AppMethodBeat.o(247644);
    }

    private final void initShoppingPlugin() {
        AppMethodBeat.i(247645);
        if (this.shoppingListPlugin == null) {
            Context context = getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(247645);
                throw tVar;
            }
            Activity activity = (Activity) context;
            FrameLayout frameLayout = (FrameLayout) activity.findViewById(R.id.cpt);
            if (frameLayout == null) {
                f.a.a(com.tencent.mm.plugin.finder.utils.c.vVc, "liveInitContentViewError", false, false, null, 28);
                Log.e(this.TAG, "initShoppingPlugin root is empty!");
            }
            View inflate = activity.getLayoutInflater().inflate(R.layout.afb, (ViewGroup) frameLayout, false);
            if (inflate == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(247645);
                throw tVar2;
            }
            ViewGroup viewGroup = (ViewGroup) inflate;
            if (frameLayout != null) {
                frameLayout.addView(viewGroup);
            }
            this.shoppingListPlugin = new bf(viewGroup, this);
        }
        AppMethodBeat.o(247645);
    }

    private final void initMemberListPlugin() {
        AppMethodBeat.i(247646);
        if (this.memberListPlugin == null) {
            Context context = getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(247646);
                throw tVar;
            }
            Activity activity = (Activity) context;
            FrameLayout frameLayout = (FrameLayout) activity.findViewById(R.id.cpt);
            View inflate = activity.getLayoutInflater().inflate(R.layout.aeq, (ViewGroup) frameLayout, false);
            if (inflate == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(247646);
                throw tVar2;
            }
            ViewGroup viewGroup = (ViewGroup) inflate;
            if (frameLayout != null) {
                frameLayout.addView(viewGroup);
            }
            this.memberListPlugin = new ap(viewGroup, this);
        }
        AppMethodBeat.o(247646);
    }

    private final void initVisitorRoleGuidePlugin() {
        AppMethodBeat.i(260864);
        if (this.visitorRoleGuidePlugin == null) {
            Context context = getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(260864);
                throw tVar;
            }
            Activity activity = (Activity) context;
            FrameLayout frameLayout = (FrameLayout) activity.findViewById(R.id.cpt);
            View inflate = activity.getLayoutInflater().inflate(R.layout.cfi, (ViewGroup) frameLayout, false);
            if (inflate == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(260864);
                throw tVar2;
            }
            ViewGroup viewGroup = (ViewGroup) inflate;
            frameLayout.addView(viewGroup);
            hideProgress();
            this.visitorRoleGuidePlugin = new ce(viewGroup, this, activity, this.reportObj);
            ce ceVar = this.visitorRoleGuidePlugin;
            if (ceVar != null) {
                ceVar.UNh = new FinderLiveVisitorPluginLayout$initVisitorRoleGuidePlugin$1(this);
                AppMethodBeat.o(260864);
                return;
            }
        }
        AppMethodBeat.o(260864);
    }

    private final void hidePlugins() {
        AppMethodBeat.i(247647);
        aw awVar = this.liveTXLivePlayerPlygin;
        if (awVar != null) {
            awVar.rg(8);
        }
        bz bzVar = this.previewPlugin;
        if (bzVar != null) {
            bzVar.rg(8);
        }
        bb bbVar = this.shadowPlugin;
        if (bbVar != null) {
            bbVar.rg(8);
        }
        bh bhVar = this.titleInfoPlugin;
        if (bhVar != null) {
            bhVar.rg(8);
        }
        y yVar = this.commonInfoPlugin;
        if (yVar != null) {
            yVar.rg(8);
        }
        v vVar = this.commentPlugin;
        if (vVar != null) {
            vVar.rg(8);
        }
        bj bjVar = this.topCommentPlugin;
        if (bjVar != null) {
            bjVar.rg(8);
        }
        bo boVar = this.finderLiveAfterPlugin;
        if (boVar != null) {
            boVar.rg(8);
        }
        com.tencent.mm.plugin.finder.live.plugin.aw awVar2 = this.postPlugin;
        if (awVar2 != null) {
            awVar2.rg(8);
        }
        ar arVar = this.identifyPlugin;
        if (arVar != null) {
            arVar.rg(8);
        }
        ah ahVar = this.inputPluigin;
        if (ahVar != null) {
            ahVar.rg(8);
        }
        br brVar = this.closePlugin;
        if (brVar != null) {
            brVar.rg(8);
        }
        aj ajVar = this.confettiPlugin;
        if (ajVar != null) {
            ajVar.rg(8);
        }
        at atVar = this.moreActionPlugin;
        if (atVar != null) {
            atVar.rg(8);
        }
        bd bdVar = this.shoppingBubblePlugin;
        if (bdVar != null) {
            bdVar.rg(8);
        }
        bf bfVar = this.shoppingListPlugin;
        if (bfVar != null) {
            bfVar.rg(8);
        }
        ba baVar = this.screenClearPlugin;
        if (baVar != null) {
            baVar.rg(8);
        }
        bt btVar = this.exceptionPlugin;
        if (btVar != null) {
            btVar.rg(8);
        }
        bm bmVar = this.videoOrientationPlugin;
        if (bmVar != null) {
            bmVar.rg(8);
        }
        al alVar = this.lotteryBubblePlugin;
        if (alVar != null) {
            alVar.rg(8);
        }
        by byVar = this.lotteryCardPlugin;
        if (byVar != null) {
            byVar.rg(8);
        }
        bw bwVar = this.linkMicStatePlugin;
        if (bwVar != null) {
            bwVar.rg(8);
        }
        cb cbVar = this.micDecoratePlugin;
        if (cbVar != null) {
            cbVar.rg(8);
        }
        bl blVar = this.micAudioPreviewPlugin;
        if (blVar != null) {
            blVar.rg(8);
        }
        bv bvVar = this.linkLisencePlugin;
        if (bvVar != null) {
            bvVar.rg(8);
        }
        aa aaVar = this.giftPanelPlugin;
        if (aaVar != null) {
            aaVar.rg(8);
        }
        ac acVar = this.giftPlayPlugin;
        if (acVar != null) {
            acVar.rg(8);
        }
        ae aeVar = this.giftQueuePlugin;
        if (aeVar != null) {
            aeVar.rg(8);
        }
        af afVar = this.giftSendPlugin;
        if (afVar != null) {
            afVar.rg(8);
        }
        bu buVar = this.wecoinHotExplainPlugin;
        if (buVar != null) {
            buVar.rg(8);
        }
        bp bpVar = this.bottomOptionPlugin;
        if (bpVar != null) {
            bpVar.rg(8);
        }
        ap apVar = this.memberListPlugin;
        if (apVar != null) {
            apVar.rg(8);
        }
        av avVar = this.moreLiveEntrancePlugin;
        if (avVar != null) {
            avVar.rg(8);
        }
        as asVar = this.luckyMoneyPlugin;
        if (asVar != null) {
            asVar.rg(8);
        }
        aq aqVar = this.bottomTipPlugin;
        if (aqVar != null) {
            aqVar.rg(8);
            AppMethodBeat.o(247647);
            return;
        }
        AppMethodBeat.o(247647);
    }

    private final void joinLive() {
        AppMethodBeat.i(247648);
        com.tencent.mm.plugin.finder.utils.af afVar = com.tencent.mm.plugin.finder.utils.af.waa;
        StringBuilder sb = new StringBuilder();
        com.tencent.mm.plugin.finder.utils.af afVar2 = com.tencent.mm.plugin.finder.utils.af.waa;
        String sb2 = sb.append(com.tencent.mm.plugin.finder.utils.af.dEm()).append(getData().uCr.getLiveId()).toString();
        ad.a aVar = ad.vZu;
        com.tencent.mm.plugin.finder.utils.af.a(afVar, sb2, ad.vYM.name, null, false, false, 28);
        e eVar = e.uiD;
        e.dfy();
        j.a aVar2 = com.tencent.mm.plugin.finder.live.component.j.UJU;
        j.a.RI(getLiveData().liveInfo.liveId);
        Log.i(this.TAG, "joinLive");
        s finderLiveAssistant = getFinderLiveAssistant();
        if (finderLiveAssistant != null) {
            finderLiveAssistant.a(2, new FinderLiveVisitorPluginLayout$joinLive$1(this));
            AppMethodBeat.o(247648);
            return;
        }
        AppMethodBeat.o(247648);
    }

    private final void directStartLive() {
        TRTCVideoLayoutManager renderLayout;
        AppMethodBeat.i(247649);
        checkVisitorRoleWhenDirectStart();
        hideLoadingLayer();
        com.tencent.mm.plugin.finder.live.plugin.aw awVar = this.postPlugin;
        if (awVar != null) {
            awVar.dhK();
        }
        chooseAudienceMode(true);
        b.C0376b.a(this, b.c.hNb);
        bz bzVar = this.previewPlugin;
        if (!(bzVar == null || (renderLayout = bzVar.hAs.getRenderLayout()) == null)) {
            renderLayout.post(new FinderLiveVisitorPluginLayout$directStartLive$1(this));
        }
        b.C0376b.a(this, b.c.hLR);
        d.a(200, new FinderLiveVisitorPluginLayout$directStartLive$2(this));
        Log.i(this.TAG, "directStartLive audienceMode:" + getLiveData().djc());
        AppMethodBeat.o(247649);
    }

    private final void checkVisitorRoleWhenDirectStart() {
        br brVar;
        AppMethodBeat.i(260865);
        m mVar = m.vVH;
        if (!m.hVq() || (brVar = this.closePlugin) == null) {
            AppMethodBeat.o(260865);
            return;
        }
        s finderLiveAssistant = getFinderLiveAssistant();
        if (finderLiveAssistant != null) {
            finderLiveAssistant.b(brVar);
            AppMethodBeat.o(260865);
            return;
        }
        AppMethodBeat.o(260865);
    }

    private final void checkLinkMicStateWhenJoin(awn awn) {
        LinkedList<awm> linkedList;
        FinderContact finderContact;
        FinderContact finderContact2;
        FinderContact finderContact3;
        FinderContact finderContact4;
        FinderContact finderContact5;
        FinderContact finderContact6;
        String str;
        String str2;
        String str3;
        FinderContact finderContact7;
        FinderContact finderContact8;
        FinderContact finderContact9;
        String str4;
        String str5;
        String str6;
        FinderContact finderContact10;
        FinderContact finderContact11;
        FinderContact finderContact12;
        avn avn;
        FinderContact finderContact13;
        AppMethodBeat.i(260866);
        if (awn == null || (linkedList = awn.LHo) == null) {
            linkedList = new LinkedList<>();
        }
        fgx fgx = awn != null ? awn.Vjl : null;
        Log.i(this.TAG, "checkLinkMicStateWhenJoin micUserList.size:" + linkedList.size() + " micInfo:[sessionId:" + (awn != null ? awn.KDS : null) + ", micUserList:" + linkedList + ']' + ", micPkInfo:[sessionId:" + (fgx != null ? fgx.KDS : null) + ", seq:" + (fgx != null ? Long.valueOf(fgx.LHk) : null) + ", micNickname:" + ((fgx == null || (avn = fgx.LFI) == null || (finderContact13 = avn.contact) == null) ? null : finderContact13.nickname) + ", status:" + (fgx != null ? Integer.valueOf(fgx.status) : null) + ']');
        if (fgx != null) {
            Log.i(this.TAG, "checkLinkMicStateWhenJoin has unfinished mic pk status:" + fgx.status);
            if (fgx.LFI != null && !Util.isEqual(fgx.Lmn, getLiveData().djq())) {
                switch (fgx.status) {
                    case 1:
                        com.tencent.mm.plugin.finder.live.viewmodel.g liveData = getLiveData();
                        String str7 = fgx.KDS;
                        avn avn2 = fgx.LFI;
                        if (avn2 == null || (finderContact12 = avn2.contact) == null) {
                            str4 = null;
                        } else {
                            str4 = finderContact12.username;
                        }
                        avn avn3 = fgx.LFI;
                        if (avn3 == null || (finderContact11 = avn3.contact) == null) {
                            str5 = null;
                        } else {
                            str5 = finderContact11.nickname;
                        }
                        avn avn4 = fgx.LFI;
                        if (avn4 == null || (finderContact10 = avn4.contact) == null) {
                            str6 = null;
                        } else {
                            str6 = finderContact10.headUrl;
                        }
                        liveData.UQb = new com.tencent.mm.plugin.finder.live.viewmodel.j(str7, str4, str5, str6);
                        AppMethodBeat.o(260866);
                        return;
                    case 2:
                        getLiveData().uEx = fgx.LHk;
                        com.tencent.mm.plugin.finder.live.viewmodel.g liveData2 = getLiveData();
                        String str8 = fgx.Lmn;
                        avn avn5 = fgx.LFI;
                        if (avn5 == null || (finderContact9 = avn5.contact) == null) {
                            str = null;
                        } else {
                            str = finderContact9.headUrl;
                        }
                        avn avn6 = fgx.LFI;
                        if (avn6 == null || (finderContact8 = avn6.contact) == null) {
                            str2 = null;
                        } else {
                            str2 = finderContact8.username;
                        }
                        avn avn7 = fgx.LFI;
                        if (avn7 == null || (finderContact7 = avn7.contact) == null) {
                            str3 = null;
                        } else {
                            str3 = finderContact7.nickname;
                        }
                        liveData2.uEB = new com.tencent.mm.plugin.finder.live.viewmodel.e(str8, str, str2, str3, 2, fgx.KDS, null, true, 0, null, null, 0, 0, 7936);
                        getLiveData().uEC = 4;
                        onAccepLinkMicOthers(2);
                        AppMethodBeat.o(260866);
                        return;
                    default:
                        AppMethodBeat.o(260866);
                        return;
                }
            }
        } else if (!linkedList.isEmpty()) {
            Log.i(this.TAG, "checkLinkMicStateWhenJoin has unfinished mic");
            for (awm awm : linkedList) {
                if ((awm != null ? awm.LFI : null) != null) {
                    if (!Util.isEqual(awm.Lmn, getLiveData().djq())) {
                        Log.i(this.TAG, "checkLinkMicStateWhenJoin has unfinished mic others. update mic status");
                        com.tencent.mm.plugin.finder.live.viewmodel.g liveData3 = getLiveData();
                        String str9 = awm.Lmn;
                        avn avn8 = awm.LFI;
                        String str10 = (avn8 == null || (finderContact6 = avn8.contact) == null) ? null : finderContact6.headUrl;
                        avn avn9 = awm.LFI;
                        String str11 = (avn9 == null || (finderContact5 = avn9.contact) == null) ? null : finderContact5.username;
                        avn avn10 = awm.LFI;
                        String str12 = (avn10 == null || (finderContact4 = avn10.contact) == null) ? null : finderContact4.nickname;
                        int i2 = awm.LFG;
                        String str13 = awm != null ? awm.KDS : null;
                        avn avn11 = awm.LFI;
                        liveData3.f(new com.tencent.mm.plugin.finder.live.viewmodel.e(str9, str10, str11, str12, i2, str13, null, false, 0, null, null, 0, avn11 != null ? avn11.LGj : 0, 4032));
                        onAccepLinkMicOthers(Integer.valueOf(awm.LFG));
                    } else {
                        Log.i(this.TAG, "checkLinkMicStateWhenJoin has unfinished mic self. will close mic");
                        com.tencent.mm.plugin.finder.live.viewmodel.g liveData4 = getLiveData();
                        String str14 = awm.Lmn;
                        avn avn12 = awm.LFI;
                        String str15 = (avn12 == null || (finderContact3 = avn12.contact) == null) ? null : finderContact3.headUrl;
                        avn avn13 = awm.LFI;
                        String str16 = (avn13 == null || (finderContact2 = avn13.contact) == null) ? null : finderContact2.username;
                        avn avn14 = awm.LFI;
                        String str17 = (avn14 == null || (finderContact = avn14.contact) == null) ? null : finderContact.nickname;
                        int i3 = awm.LFG;
                        String str18 = awm != null ? awm.KDS : null;
                        avn avn15 = awm.LFI;
                        liveData4.f(new com.tencent.mm.plugin.finder.live.viewmodel.e(str14, str15, str16, str17, i3, str18, null, false, 0, null, null, 0, avn15 != null ? avn15.LGj : 0, 4032));
                        postCloseLinkMsg();
                    }
                }
            }
        }
        AppMethodBeat.o(260866);
    }

    private final void onAcceptLinkMicSelf(com.tencent.mm.live.b.a aVar) {
        TRTCCloudDef.TRTCParams tRTCParams;
        AppMethodBeat.i(247651);
        Log.i(this.TAG, "onAcceptLinkMicSelf curLinkState:" + getLiveData().uEC + " curLiveUser:" + getLiveData().uEB + " audienceMode:" + getLiveData().djc() + " pmk:" + aVar.privateMapKey);
        com.tencent.mm.plugin.finder.live.model.a.b bVar = com.tencent.mm.plugin.finder.live.model.a.b.ULf;
        com.tencent.mm.plugin.finder.live.model.a.b.hTp();
        com.tencent.mm.live.core.core.b.f fVar = getLiveData().hIy;
        if (!(fVar == null || (tRTCParams = fVar.hzu) == null)) {
            tRTCParams.privateMapKey = aVar.privateMapKey;
        }
        com.tencent.mm.live.core.core.d.b bVar2 = this.liveCore;
        if (bVar2 != null) {
            String str = aVar.privateMapKey;
            if (str == null) {
                str = "";
            }
            bVar2.Go(str);
        }
        int djc = getLiveData().djc();
        e.a aVar2 = e.a.hxc;
        if (djc == e.a.aCe()) {
            d.h(new FinderLiveVisitorPluginLayout$onAcceptLinkMicSelf$1(this, aVar));
            AppMethodBeat.o(247651);
            return;
        }
        com.tencent.mm.live.core.core.b.f fVar2 = getLiveData().hIy;
        if (fVar2 != null) {
            bz bzVar = this.previewPlugin;
            if (bzVar != null) {
                bzVar.a(fVar2, new FinderLiveVisitorPluginLayout$onAcceptLinkMicSelf$$inlined$let$lambda$1(this, aVar));
                AppMethodBeat.o(247651);
                return;
            }
            AppMethodBeat.o(247651);
            return;
        }
        AppMethodBeat.o(247651);
    }

    private final void onAccepLinkMicOthers(Integer num) {
        AppMethodBeat.i(247652);
        Log.i(this.TAG, "onAccepLinkMicOthers curLinkState:" + getLiveData().uEC + " curLiveUser:" + getLiveData().uEB + " audienceLinkMicUserList:" + getLiveData().UPZ + " audienceMode:" + getLiveData().djc());
        com.tencent.mm.plugin.finder.live.viewmodel.e eVar = getLiveData().uEB;
        if (eVar != null && eVar.UPN) {
            notifyPKMicUserChange();
            b.C0376b.a(this, b.c.hNQ);
        }
        bp bpVar = this.bottomOptionPlugin;
        if (bpVar != null) {
            bpVar.dgP();
            AppMethodBeat.o(247652);
            return;
        }
        AppMethodBeat.o(247652);
    }

    private final void onCloseLinkMicSelf(int i2) {
        AppMethodBeat.i(247653);
        Log.i(this.TAG, "onCloseLinkMicSelf micType:".concat(String.valueOf(i2)));
        if (i2 == 1) {
            if (this.previewPlugin != null) {
                bz.dhZ();
            }
            bw bwVar = this.linkMicStatePlugin;
            if (bwVar != null) {
                bwVar.dgX();
            }
            com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
            com.tencent.mm.plugin.finder.report.live.m.ou(false);
            com.tencent.mm.plugin.finder.report.live.m.a(com.tencent.mm.plugin.finder.report.live.m.vli, s.ax.ACTIVE_STOP_AUDIO_LINKMIC, (s.z) null, 6);
        } else if (i2 == 2) {
            if (this.previewPlugin != null) {
                bz.dhZ();
            }
            com.tencent.mm.live.core.core.d.b bVar = this.liveCore;
            if (bVar != null) {
                bVar.aBS();
            }
            com.tencent.mm.plugin.finder.report.live.m mVar2 = com.tencent.mm.plugin.finder.report.live.m.vli;
            com.tencent.mm.plugin.finder.report.live.m.ou(false);
            com.tencent.mm.plugin.finder.report.live.m.a(com.tencent.mm.plugin.finder.report.live.m.vli, s.ax.ACTIVE_STOP_VIDEO_LINKMIC, (s.z) null, 6);
        }
        notifyAudienceMicUserChange();
        bp bpVar = this.bottomOptionPlugin;
        if (bpVar != null) {
            bpVar.dgP();
        }
        o oVar = o.ujN;
        o.dgi();
        d.h(new FinderLiveVisitorPluginLayout$onCloseLinkMicSelf$1(this));
        AppMethodBeat.o(247653);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006f, code lost:
        if (r3 != null) goto L_0x0071;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void onCloseLinkMicOthers(int r8) {
        /*
        // Method dump skipped, instructions count: 128
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.view.FinderLiveVisitorPluginLayout.onCloseLinkMicOthers(int):void");
    }

    static /* synthetic */ void chooseAudienceMode$default(FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout, boolean z, int i2, Object obj) {
        AppMethodBeat.i(247656);
        if ((i2 & 1) != 0) {
            z = false;
        }
        finderLiveVisitorPluginLayout.chooseAudienceMode(z);
        AppMethodBeat.o(247656);
    }

    private final void chooseAudienceMode(boolean z) {
        TXLivePlayer tXLivePlayer;
        bz bzVar;
        com.tencent.mm.live.core.core.d.b hTF;
        TXCloudVideoView tXCloudVideoView = null;
        AppMethodBeat.i(247655);
        int djc = getLiveData().djc();
        e.a aVar = e.a.hxc;
        if (djc == e.a.aCe()) {
            com.tencent.mm.plugin.finder.utils.af afVar = com.tencent.mm.plugin.finder.utils.af.waa;
            StringBuilder sb = new StringBuilder();
            com.tencent.mm.plugin.finder.utils.af afVar2 = com.tencent.mm.plugin.finder.utils.af.waa;
            String sb2 = sb.append(com.tencent.mm.plugin.finder.utils.af.dEm()).append(getData().uCr.getLiveId()).toString();
            ad.a aVar2 = ad.vZu;
            com.tencent.mm.plugin.finder.utils.af.a(afVar, sb2, ad.vYQ.name, null, false, false, 28);
            Log.i(this.TAG, "chooseAudienceMode TRTC fromMiniWin:" + z + ", liveRoomModel:" + getLiveData().hIy + ", liveExtFlag:" + getLiveData().uDU);
            com.tencent.mm.live.core.core.d.b bVar = this.liveCore;
            if (bVar != null) {
                m mVar = m.vVH;
                int a2 = m.a(getLiveData(), isLandscape());
                h Gy = bVar.hAm.Gy(bVar.hAz.hzG);
                if (Gy != null) {
                    Gy.qy(a2);
                }
            }
            if (z) {
                bz bzVar2 = this.previewPlugin;
                if (!(bzVar2 == null || (hTF = bz.hTF()) == null)) {
                    hTF.a(bzVar2.hAs);
                }
                com.tencent.mm.live.core.core.d.b bVar2 = this.liveCore;
                if (bVar2 != null) {
                    bVar2.aEb();
                }
                com.tencent.mm.live.core.core.d.b bVar3 = this.liveCore;
                if (bVar3 != null) {
                    bVar3.aEc();
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("PARAM_FINDER_LIVE_START_BY_MINI_WINDOW", z);
                statusChange(b.c.hLB, bundle);
            } else {
                com.tencent.mm.live.core.core.b.f fVar = getLiveData().hIy;
                if (!(fVar == null || (bzVar = this.previewPlugin) == null)) {
                    bzVar.a(fVar, new FinderLiveVisitorPluginLayout$chooseAudienceMode$$inlined$let$lambda$1(this, z));
                }
            }
            bz bzVar3 = this.previewPlugin;
            if (bzVar3 != null) {
                bzVar3.rg(0);
                AppMethodBeat.o(247655);
                return;
            }
            AppMethodBeat.o(247655);
            return;
        }
        e.a aVar3 = e.a.hxc;
        if (djc == e.a.aCf()) {
            Log.i(this.TAG, "chooseAudienceMode CDN fromMiniWin:" + z + ", liveRoomModel:" + getLiveData().hIy + ", liveExtFlag:" + getLiveData().uDU);
            com.tencent.mm.live.core.core.b.f fVar2 = getLiveData().hIy;
            if (fVar2 != null) {
                com.tencent.mm.live.core.core.d.b bVar4 = this.liveCore;
                if (bVar4 != null) {
                    bVar4.a(fVar2);
                }
                com.tencent.mm.live.core.core.d dVar = com.tencent.mm.live.core.core.d.hwY;
                com.tencent.mm.live.core.core.d.a(fVar2.hwP);
                aw awVar = this.liveTXLivePlayerPlygin;
                if (awVar != null) {
                    awVar.ev(false);
                }
                com.tencent.mm.plugin.finder.utils.af afVar3 = com.tencent.mm.plugin.finder.utils.af.waa;
                StringBuilder sb3 = new StringBuilder();
                com.tencent.mm.plugin.finder.utils.af afVar4 = com.tencent.mm.plugin.finder.utils.af.waa;
                String sb4 = sb3.append(com.tencent.mm.plugin.finder.utils.af.dEm()).append(getData().uCr.getLiveId()).toString();
                ad.a aVar4 = ad.vZu;
                com.tencent.mm.plugin.finder.utils.af.a(afVar3, sb4, ad.vYQ.name, null, false, false, 28);
                aw awVar2 = this.liveTXLivePlayerPlygin;
                if (awVar2 != null) {
                    m mVar2 = m.vVH;
                    TXLivePlayConfig dBO = m.dBO();
                    m mVar3 = m.vVH;
                    aw.a(awVar2, 0, dBO, m.a(getLiveData(), isLandscape()), new FinderLiveVisitorPluginLayout$chooseAudienceMode$$inlined$let$lambda$2(this, z), 1);
                }
                aw awVar3 = this.liveTXLivePlayerPlygin;
                if (awVar3 != null) {
                    awVar3.rg(0);
                }
                com.tencent.mm.live.core.core.d.b bVar5 = this.liveCore;
                if (bVar5 != null) {
                    long j2 = getLiveData().liveInfo.liveId;
                    aw awVar4 = this.liveTXLivePlayerPlygin;
                    if (awVar4 != null) {
                        tXLivePlayer = awVar4.hwO;
                    } else {
                        tXLivePlayer = null;
                    }
                    aw awVar5 = this.liveTXLivePlayerPlygin;
                    if (awVar5 != null) {
                        tXCloudVideoView = awVar5.aHJ();
                    }
                    bVar5.a(j2, tXLivePlayer, tXCloudVideoView);
                    AppMethodBeat.o(247655);
                    return;
                }
                AppMethodBeat.o(247655);
                return;
            }
        }
        AppMethodBeat.o(247655);
    }

    private final void handleJoinErr(int i2, String str) {
        s.n nVar;
        String str2;
        long ahy;
        AppMethodBeat.i(247657);
        Log.i(this.TAG, "join live room errCode:" + i2 + " errMsg:" + str);
        switch (i2) {
            case -200030:
                b.C0376b.a(this, b.c.hMm);
                nVar = s.n.LIVE_NO_ACCESS_PERMISSION;
                break;
            case -200001:
                b.C0376b.a(this, b.c.hMl);
                nVar = s.n.LIVE_IN_BLACK_LIST;
                break;
            case -100038:
                bo boVar = this.finderLiveAfterPlugin;
                if (boVar != null) {
                    boVar.uuV = false;
                }
                b.C0376b.a(this, b.c.hLV);
                nVar = s.n.LIVE_STOPPED;
                break;
            default:
                bo boVar2 = this.finderLiveAfterPlugin;
                if (boVar2 != null) {
                    boVar2.uuV = false;
                }
                b.C0376b.a(this, b.c.hLV);
                com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                if (com.tencent.mm.plugin.finder.utils.y.dCM()) {
                    Context context = getContext();
                    Context context2 = getContext();
                    p.g(context2, "context");
                    u.makeText(context, String.valueOf(context2.getResources().getString(R.string.dbd)), 0).show();
                }
                nVar = s.n.LIVE_STOPPED;
                break;
        }
        com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
        com.tencent.mm.plugin.finder.report.live.m.a(nVar);
        k kVar = k.vkd;
        long j2 = getLiveData().hFK;
        long j3 = getLiveData().liveInfo.liveId;
        if (TextUtils.isEmpty(getData().uCs.hwd)) {
            str2 = getLiveData().hwd;
        } else {
            str2 = getData().uCs.hwd;
        }
        k kVar2 = k.vkd;
        long j4 = k.dpl().vlw;
        long size = (long) getLiveData().uDn.size();
        s.p pVar = s.p.LIVE_AUDIENCE_ENTER_LIVE_ROOM_REAL;
        k kVar3 = k.vkd;
        String str3 = k.dpl().vlv;
        long j5 = nVar.jii;
        com.tencent.mm.plugin.finder.report.live.m mVar2 = com.tencent.mm.plugin.finder.report.live.m.vli;
        if (com.tencent.mm.plugin.finder.report.live.m.ahy() <= 0) {
            ahy = System.currentTimeMillis();
        } else {
            com.tencent.mm.plugin.finder.report.live.m mVar3 = com.tencent.mm.plugin.finder.report.live.m.vli;
            ahy = com.tencent.mm.plugin.finder.report.live.m.ahy();
        }
        k kVar4 = k.vkd;
        kVar.a(j2, j3, str2, j4, size, pVar, str3, j5, ahy, k.dpl().vma);
        AppMethodBeat.o(247657);
    }

    private final void startTimer() {
        AppMethodBeat.i(247658);
        if (!getLiveData().djl()) {
            this.timerThread.stopTimer();
            this.timerThread.startTimer(1000);
        }
        AppMethodBeat.o(247658);
    }

    private final void stopTimer() {
        AppMethodBeat.i(247659);
        this.timerThread.stopTimer();
        AppMethodBeat.o(247659);
    }

    private final void restoreLinkMicUI() {
        T t;
        com.tencent.mm.live.core.core.b.g gVar;
        bz bzVar;
        com.tencent.mm.live.core.core.b.g gVar2;
        AppMethodBeat.i(247662);
        Log.i(this.TAG, "restoreLinkMicUI curLinkMicUser:" + getLiveData().uEB + " audienceLinkMicUserList:" + getLiveData().UPZ + " audienceMode:" + getLiveData().djc());
        if (getLiveData().djr()) {
            bw bwVar = this.linkMicStatePlugin;
            if (bwVar != null) {
                bwVar.dgW();
                AppMethodBeat.o(247662);
                return;
            }
            AppMethodBeat.o(247662);
            return;
        }
        List<com.tencent.mm.plugin.finder.live.viewmodel.e> list = getLiveData().UPZ;
        p.g(list, "liveData.audienceLinkMicUserList");
        List<com.tencent.mm.plugin.finder.live.viewmodel.e> list2 = list;
        synchronized (list2) {
            try {
                Iterator<T> it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    T next = it.next();
                    if (Util.isEqual(next.uCo, getLiveData().djq())) {
                        t = next;
                        break;
                    }
                }
            } finally {
                AppMethodBeat.o(247662);
            }
        }
        T t2 = t;
        List<com.tencent.mm.plugin.finder.live.viewmodel.e> list3 = getLiveData().UPZ;
        p.g(list3, "liveData.audienceLinkMicUserList");
        List<com.tencent.mm.plugin.finder.live.viewmodel.e> list4 = list3;
        synchronized (list4) {
            try {
                for (T t3 : list4) {
                    if (Util.isEqual(t3.uCo, getLiveData().djq())) {
                        aw awVar = this.liveTXLivePlayerPlygin;
                        if (awVar != null) {
                            awVar.ev(true);
                        }
                        aw awVar2 = this.liveTXLivePlayerPlygin;
                        if (awVar2 != null) {
                            awVar2.rg(8);
                        }
                        bz bzVar2 = this.previewPlugin;
                        if (bzVar2 != null) {
                            bzVar2.rg(0);
                        }
                        bz bzVar3 = this.previewPlugin;
                        if (bzVar3 != null) {
                            bzVar3.dia();
                        }
                        com.tencent.mm.live.core.core.d.b bVar = this.liveCore;
                        if (bVar != null) {
                            com.tencent.mm.live.core.core.d.b bVar2 = this.liveCore;
                            bVar.Gp((bVar2 == null || (gVar2 = bVar2.hAz) == null) ? null : gVar2.hzG);
                        }
                        if (t3.uCx == 2 && (bzVar = this.previewPlugin) != null) {
                            bzVar.startPreview();
                        }
                    } else {
                        int djc = getLiveData().djc();
                        e.a aVar = e.a.hxc;
                        if (djc != e.a.aCe()) {
                            int djc2 = getLiveData().djc();
                            e.a aVar2 = e.a.hxc;
                            if (djc2 == e.a.aCf()) {
                                if (t2 == null) {
                                }
                            }
                        }
                        bz bzVar4 = this.previewPlugin;
                        if (bzVar4 != null) {
                            bzVar4.bxG(t3.uCo);
                        }
                        bz bzVar5 = this.previewPlugin;
                        if (bzVar5 != null) {
                            bzVar5.dia();
                        }
                        com.tencent.mm.live.core.core.d.b bVar3 = this.liveCore;
                        if (bVar3 != null) {
                            com.tencent.mm.live.core.core.d.b bVar4 = this.liveCore;
                            bVar3.Gp((bVar4 == null || (gVar = bVar4.hAz) == null) ? null : gVar.hzG);
                        }
                        com.tencent.mm.live.core.core.d.b bVar5 = this.liveCore;
                        if (bVar5 != null) {
                            bVar5.Gp(t3.uCo);
                        }
                    }
                }
                kotlin.x xVar = kotlin.x.SXb;
            } catch (Throwable th) {
                throw th;
            }
        }
        notifyAudienceMicUserChange();
        AppMethodBeat.o(247662);
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final int getRelativeLayoutId() {
        return R.layout.ag1;
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public final void bindData(com.tencent.mm.plugin.finder.live.viewmodel.c cVar, com.tencent.mm.plugin.finder.live.viewmodel.g gVar, boolean z) {
        AppMethodBeat.i(247663);
        p.h(cVar, "data");
        p.h(gVar, "liveData");
        super.bindData(cVar, gVar, z);
        initPlugins();
        hidePlugins();
        AppMethodBeat.o(247663);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public final void activate(com.tencent.mm.plugin.finder.live.viewmodel.c cVar, boolean z, boolean z2, boolean z3, int i2) {
        LiveBottomSheetPanel liveBottomSheetPanel;
        aj ajVar;
        AppMethodBeat.i(260867);
        p.h(cVar, "data");
        super.activate(cVar, z, z2, z3, i2);
        View finderLiveHistoryTips = getFinderLiveHistoryTips();
        if (finderLiveHistoryTips != null) {
            finderLiveHistoryTips.setVisibility(8);
        }
        aw awVar = this.liveTXLivePlayerPlygin;
        if (awVar != null) {
            awVar.aHy();
        }
        b.a aVar = com.tencent.mm.live.core.core.d.b.hCo;
        getContext();
        this.liveCore = b.a.aEf();
        fillBlurBg(getLiveData().hwd);
        boolean hUa = getLiveData().hUa();
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        int i3 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_LIVE_VISITOR_ROLE_INT_SYNC, 4);
        if (!getLiveData().UQe.isEmpty() && (ajVar = this.confettiPlugin) != null) {
            ajVar.bS(getLiveData().UQe);
        }
        String str = this.TAG;
        StringBuilder append = new StringBuilder("activate liveFinish:").append(getLiveData().uDN).append(", isFromFloat:").append(z2).append(", restart:").append(z3).append(", hasJoinLive:").append(hUa).append(", curIndex:").append(i2).append(", FinderLiveService.curLiveIndex:");
        o oVar = o.ujN;
        StringBuilder append2 = append.append(o.dga()).append(", liveId:");
        awe awe = getLiveData().liveInfo;
        Log.i(str, append2.append((awe != null ? Long.valueOf(awe.liveId) : null).longValue()).append(", anchorName:").append(getLiveData().hwd).append(",cache visitorRole:").append(getLiveData().UQh.LFy).append(",lastVisitorRoleType:").append(i3).toString());
        getLiveData().hUc();
        if (z2) {
            o oVar2 = o.ujN;
            if (i2 == o.dga() && hUa) {
                if (getLiveData().uDN) {
                    bo boVar = this.finderLiveAfterPlugin;
                    if (boVar != null) {
                        boVar.uuV = false;
                    }
                    b.C0376b.a(this, b.c.hLV);
                } else {
                    directStartLive();
                }
                q qVar = q.ukd;
                q.j(name(), new FinderLiveVisitorPluginLayout$activate$1(this));
                q qVar2 = q.ukd;
                q.k(name(), new FinderLiveVisitorPluginLayout$activate$2(this));
                q qVar3 = q.ukd;
                q.k(name(), new FinderLiveVisitorPluginLayout$activate$3(this));
                String str2 = this.TAG;
                StringBuilder append3 = new StringBuilder("liveId:").append(cVar.uCr.getLiveId()).append(" objectId:").append(cVar.uCr.aBH()).append(",nonceId:").append(cVar.uCr.aBI()).append(",username:").append(cVar.uCr.aBG()).append(",show name:");
                com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                Log.i(str2, append3.append(com.tencent.mm.plugin.finder.utils.y.hf(cVar.uCr.aBG(), "")).toString());
                AppMethodBeat.o(260867);
            }
        }
        com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh2, "MMKernel.storage()");
        Object obj = aAh2.azQ().get(ar.a.USERINFO_FINDER_LIVE_ALIAS_GUIDE_SHOW_BOOLEAN_SYNC, Boolean.FALSE);
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(260867);
            throw tVar;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        Log.i(this.TAG, "activate haveShowVisitorRoleGuide:".concat(String.valueOf(booleanValue)));
        if (!booleanValue) {
            m mVar = m.vVH;
            boolean hVq = m.hVq();
            Log.i(this.TAG, "activate enableVisitorRoleEntrance:".concat(String.valueOf(hVq)));
            if (hVq) {
                initVisitorRoleGuidePlugin();
                ce ceVar = this.visitorRoleGuidePlugin;
                if (!(ceVar == null || (liveBottomSheetPanel = ceVar.hRy) == null)) {
                    liveBottomSheetPanel.post(new ce.a(ceVar));
                }
                bh bhVar = this.titleInfoPlugin;
                if (bhVar != null) {
                    bh.a(bhVar);
                }
                bh bhVar2 = this.titleInfoPlugin;
                if (bhVar2 != null) {
                    bhVar2.rg(0);
                }
                q qVar4 = q.ukd;
                q.j(name(), new FinderLiveVisitorPluginLayout$activate$1(this));
                q qVar22 = q.ukd;
                q.k(name(), new FinderLiveVisitorPluginLayout$activate$2(this));
                q qVar32 = q.ukd;
                q.k(name(), new FinderLiveVisitorPluginLayout$activate$3(this));
                String str22 = this.TAG;
                StringBuilder append32 = new StringBuilder("liveId:").append(cVar.uCr.getLiveId()).append(" objectId:").append(cVar.uCr.aBH()).append(",nonceId:").append(cVar.uCr.aBI()).append(",username:").append(cVar.uCr.aBG()).append(",show name:");
                com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
                Log.i(str22, append32.append(com.tencent.mm.plugin.finder.utils.y.hf(cVar.uCr.aBG(), "")).toString());
                AppMethodBeat.o(260867);
            }
        }
        joinLive();
        q qVar42 = q.ukd;
        q.j(name(), new FinderLiveVisitorPluginLayout$activate$1(this));
        q qVar222 = q.ukd;
        q.k(name(), new FinderLiveVisitorPluginLayout$activate$2(this));
        q qVar322 = q.ukd;
        q.k(name(), new FinderLiveVisitorPluginLayout$activate$3(this));
        String str222 = this.TAG;
        StringBuilder append322 = new StringBuilder("liveId:").append(cVar.uCr.getLiveId()).append(" objectId:").append(cVar.uCr.aBH()).append(",nonceId:").append(cVar.uCr.aBI()).append(",username:").append(cVar.uCr.aBG()).append(",show name:");
        com.tencent.mm.plugin.finder.utils.y yVar22 = com.tencent.mm.plugin.finder.utils.y.vXH;
        Log.i(str222, append322.append(com.tencent.mm.plugin.finder.utils.y.hf(cVar.uCr.aBG(), "")).toString());
        AppMethodBeat.o(260867);
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final void onCallStateChanged(int i2, String str) {
        com.tencent.mm.live.core.core.b.g gVar;
        AppMethodBeat.i(247665);
        p.h(str, "incomingNumber");
        String str2 = this.TAG;
        StringBuilder append = new StringBuilder("onCallStateChanged state:").append(i2).append(", isFloatMode:");
        com.tencent.mm.live.core.core.d.b bVar = this.liveCore;
        Log.i(str2, append.append((bVar == null || (gVar = bVar.hAz) == null) ? null : Boolean.valueOf(gVar.isFloatMode())).toString());
        switch (i2) {
            case 1:
                AppMethodBeat.o(247665);
                return;
            case 2:
                setManualClosed(true);
                b.C0376b.a(this, b.c.hLC);
                break;
        }
        AppMethodBeat.o(247665);
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final void onRotationSwitchChange(boolean z) {
    }

    @Override // com.tencent.mm.live.view.a
    public final String name() {
        AppMethodBeat.i(247666);
        String simpleName = FinderLiveVisitorPluginLayout.class.getSimpleName();
        p.g(simpleName, "FinderLiveVisitorPluginL…ut::class.java.simpleName");
        AppMethodBeat.o(247666);
        return simpleName;
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout, com.tencent.mm.live.view.BaseLivePluginLayout
    public final void start() {
        AppMethodBeat.i(247667);
        super.start();
        startLiveVideo();
        startTimer();
        AppMethodBeat.o(247667);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout, com.tencent.mm.live.view.BaseLivePluginLayout
    public final void stop() {
        AppMethodBeat.i(247668);
        super.stop();
        checkMiniWindow();
        AppMethodBeat.o(247668);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout, com.tencent.mm.live.view.BaseLivePluginLayout
    public final void resume() {
        AppMethodBeat.i(247669);
        super.resume();
        if (getLiveData().isLiveStarted() && getLiveData().uEk && !getLiveData().uEr) {
            com.tencent.mm.plugin.finder.live.h hVar = com.tencent.mm.plugin.finder.live.h.ufY;
            com.tencent.mm.plugin.finder.live.viewmodel.g liveData = getLiveData();
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            com.tencent.mm.plugin.finder.live.h.a(liveData, com.tencent.mm.plugin.finder.utils.y.c(getLiveData().uEl));
        }
        if (!isManualClosed() && isLiveStarted() && !isLiveFinished()) {
            com.tencent.mm.plugin.finder.report.live.m.vli.a(false, s.r.LIVE_FLOAT_ACTION_MAXIMIZE);
        }
        AppMethodBeat.o(247669);
    }

    private final boolean isNormalMode() {
        com.tencent.mm.live.core.core.b.g gVar;
        AppMethodBeat.i(247670);
        com.tencent.mm.live.core.core.d.b bVar = this.liveCore;
        if (bVar == null || (gVar = bVar.hAz) == null || !gVar.isNormalMode()) {
            AppMethodBeat.o(247670);
            return false;
        }
        AppMethodBeat.o(247670);
        return true;
    }

    private final boolean isFloatMode() {
        com.tencent.mm.live.core.core.b.g gVar;
        AppMethodBeat.i(247671);
        com.tencent.mm.live.core.core.d.b bVar = this.liveCore;
        if (bVar == null || (gVar = bVar.hAz) == null || !gVar.isFloatMode()) {
            AppMethodBeat.o(247671);
            return false;
        }
        AppMethodBeat.o(247671);
        return true;
    }

    private final void trySwitchCdnStream() {
        awl awl;
        com.tencent.mm.live.core.core.b.e eVar;
        AppMethodBeat.i(247672);
        if (!getLiveData().uEU) {
            AppMethodBeat.o(247672);
            return;
        }
        int djc = getLiveData().djc();
        e.a aVar = e.a.hxc;
        if (djc != e.a.aCf() || (awl = getLiveData().liveInfo.LGS) == null) {
            AppMethodBeat.o(247672);
            return;
        }
        com.tencent.mm.live.core.core.b.f fVar = getLiveData().hIy;
        String qr = (fVar == null || (eVar = fVar.hwP) == null) ? null : eVar.qr(awl.LHi);
        if (Util.isNullOrNil(qr)) {
            qr = awl.LHj;
        }
        if (!Util.isNullOrNil(qr)) {
            com.tencent.mm.live.core.core.d dVar = com.tencent.mm.live.core.core.d.hwY;
            com.tencent.mm.live.core.core.d.Gm(qr);
        }
        AppMethodBeat.o(247672);
    }

    private final void startLiveVideo() {
        T t;
        Boolean bool;
        com.tencent.mm.live.core.core.b.g gVar;
        com.tencent.mm.live.core.core.b.g gVar2;
        com.tencent.mm.live.core.core.b.g gVar3;
        Boolean bool2 = null;
        AppMethodBeat.i(247673);
        List<com.tencent.mm.plugin.finder.live.viewmodel.e> list = getLiveData().UPZ;
        p.g(list, "liveData.audienceLinkMicUserList");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            if (Util.isEqual(next.uCo, getLiveData().djq())) {
                t = next;
                break;
            }
        }
        T t2 = t;
        String str = this.TAG;
        StringBuilder sb = new StringBuilder("startLiveVideo,float mode:");
        com.tencent.mm.live.core.core.d.b bVar = this.liveCore;
        if (bVar == null || (gVar3 = bVar.hAz) == null) {
            bool = null;
        } else {
            bool = Boolean.valueOf(gVar3.isFloatMode());
        }
        StringBuilder append = sb.append(bool).append(", normal mode:");
        com.tencent.mm.live.core.core.d.b bVar2 = this.liveCore;
        if (!(bVar2 == null || (gVar2 = bVar2.hAz) == null)) {
            bool2 = Boolean.valueOf(gVar2.isNormalMode());
        }
        Log.i(str, append.append(bool2).append(", selfMicUser:").append((Object) t2).append(" liveData.audienceLinkMicUserList:").append(getLiveData().UPZ).toString());
        com.tencent.mm.live.core.core.d.b bVar3 = this.liveCore;
        if (bVar3 == null || (gVar = bVar3.hAz) == null) {
            AppMethodBeat.o(247673);
            return;
        }
        if (gVar.isNormalMode() && t2 != null && t2.uCx == 2) {
            bz bzVar = this.previewPlugin;
            if (bzVar != null) {
                bzVar.startPreview();
            }
            bz bzVar2 = this.previewPlugin;
            if (bzVar2 != null) {
                bzVar2.hAs.hER.aFa();
                AppMethodBeat.o(247673);
                return;
            }
        }
        AppMethodBeat.o(247673);
    }

    private final void exitLive() {
        AppMethodBeat.i(247674);
        int djc = getLiveData().djc();
        e.a aVar = e.a.hxc;
        if (djc == e.a.aCe() || getLiveData().djs()) {
            com.tencent.mm.live.core.core.d.b bVar = this.liveCore;
            if (bVar != null) {
                bVar.aEa();
            }
            if (this.previewPlugin != null) {
                bz.exitRoom();
                AppMethodBeat.o(247674);
                return;
            }
            AppMethodBeat.o(247674);
            return;
        }
        aw awVar = this.liveTXLivePlayerPlygin;
        if (awVar != null) {
            awVar.ev(false);
            AppMethodBeat.o(247674);
            return;
        }
        AppMethodBeat.o(247674);
    }

    private final void stopLiveVideo() {
        Boolean bool;
        com.tencent.mm.live.core.core.d.b bVar;
        com.tencent.mm.live.core.core.b.g gVar;
        com.tencent.mm.live.core.core.b.g gVar2;
        Boolean bool2 = null;
        AppMethodBeat.i(247675);
        String str = this.TAG;
        StringBuilder sb = new StringBuilder("stopLiveVideo,float mode:");
        com.tencent.mm.live.core.core.d.b bVar2 = this.liveCore;
        if (bVar2 == null || (gVar2 = bVar2.hAz) == null) {
            bool = null;
        } else {
            bool = Boolean.valueOf(gVar2.isFloatMode());
        }
        StringBuilder append = sb.append(bool).append(", normal mode:");
        com.tencent.mm.live.core.core.d.b bVar3 = this.liveCore;
        if (!(bVar3 == null || (gVar = bVar3.hAz) == null)) {
            bool2 = Boolean.valueOf(gVar.isNormalMode());
        }
        Log.i(str, append.append(bool2).append(",manual closed:").append(isManualClosed()).append(", start:").append(isLiveStarted()).append(",finish:").append(isLiveFinished()).append(", needMiniWindow:").append(getLiveData().uDS).toString());
        if (isManualClosed() || !isLiveStarted() || isLiveFinished()) {
            if (isNormalMode() && (bVar = this.liveCore) != null) {
                bVar.aEa();
                AppMethodBeat.o(247675);
                return;
            }
        } else if (isNormalMode() && needMiniWindow() && !d.cW(getLiveData().uEf, 2048)) {
            miniWindow();
            AppMethodBeat.o(247675);
            return;
        }
        AppMethodBeat.o(247675);
    }

    private final void postCloseLinkMsg() {
        AppMethodBeat.i(247676);
        String djq = getLiveData().djq();
        String str = getLiveData().uEy;
        com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = getFinderLiveAssistant();
        if (finderLiveAssistant != null) {
            o.m mVar = o.m.hHB;
            finderLiveAssistant.a(o.m.aFW(), djq, str, new FinderLiveVisitorPluginLayout$postCloseLinkMsg$1(this, str));
            AppMethodBeat.o(247676);
            return;
        }
        AppMethodBeat.o(247676);
    }

    private final void miniWindow() {
        s.r rVar;
        AppMethodBeat.i(247677);
        Bundle bundle = new Bundle();
        bundle.putBoolean("PARAM_FINDER_LIVE_FORCE_TASK", needRemoveActivity());
        bundle.putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", isSwipeBack() ? 1 : 3);
        bundle.putInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 13);
        if (!com.tencent.mm.compatible.e.b.cx(getContext())) {
            Log.e(this.TAG, "showVideoTalking, permission denied");
            setMiniWinPermission(true);
            b.C0376b.a(this, b.c.hLS);
            RequestFloatWindowPermissionDialog.a(getContext(), getContext().getString(R.string.ej9), new FinderLiveVisitorPluginLayout$miniWindow$1(this), false, com.tencent.mm.bq.a.apJ());
            AppMethodBeat.o(247677);
            return;
        }
        setMiniWinPermission(false);
        if (isSwipeBack()) {
            rVar = s.r.LIVE_FLOAT_ACTION_MINIMIZE_INTERACTIVE;
        } else {
            com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
            if (com.tencent.mm.plugin.finder.report.live.m.dpn()) {
                rVar = s.r.VISITOR_CLICK_ENTER_LOTTERY_RECORD;
            } else {
                rVar = s.r.LIVE_FLOAT_ACTION_MINIMIZE_FOR_BG;
            }
        }
        com.tencent.mm.plugin.finder.report.live.m.vli.a(true, rVar);
        statusChange(b.c.hLQ, bundle);
        AppMethodBeat.o(247677);
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final void pause() {
        AppMethodBeat.i(247678);
        super.pause();
        disableRatation();
        AppMethodBeat.o(247678);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout, com.tencent.mm.live.view.BaseLivePluginLayout
    public final void mount() {
        AppMethodBeat.i(247679);
        super.mount();
        Log.i(this.TAG, "mount " + getLiveData());
        com.tencent.mm.live.b.m mVar = com.tencent.mm.live.b.m.hGg;
        com.tencent.mm.live.b.m.d(name(), this.liveMessageCallback);
        checkAnchorContactInfo();
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(3736, this);
        getRootView().post(new FinderLiveVisitorPluginLayout$mount$1(this));
        AppMethodBeat.o(247679);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public final void release() {
        com.tencent.mm.live.core.core.b.g gVar;
        AppMethodBeat.i(247680);
        Log.i(this.TAG, "release");
        com.tencent.mm.live.b.m mVar = com.tencent.mm.live.b.m.hGg;
        com.tencent.mm.live.b.m.aFh();
        stopTimer();
        q qVar = q.ukd;
        q.dgC();
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(3736, this);
        com.tencent.mm.live.core.core.d.b bVar = this.liveCore;
        if (bVar == null || (gVar = bVar.hAz) == null) {
            AppMethodBeat.o(247680);
            return;
        }
        if (!gVar.isFloatMode() && !getMiniWinPermission()) {
            if (!getLiveData().uEv) {
                com.tencent.mm.live.b.s sVar = com.tencent.mm.live.b.s.hIl;
                com.tencent.mm.live.b.s.release();
                com.tencent.mm.live.core.core.d.b bVar2 = this.liveCore;
                if (bVar2 != null) {
                    bVar2.aBS();
                }
                com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
                com.tencent.mm.plugin.finder.live.model.o.a(false, getMiniWinPermission(), null, 5);
                getLiveData().reset();
            }
            com.tencent.mm.live.core.core.d.b bVar3 = this.liveCore;
            if (bVar3 != null) {
                bVar3.aBW();
                AppMethodBeat.o(247680);
                return;
            }
        }
        AppMethodBeat.o(247680);
    }

    private final void notifyLiveFinish() {
        AppMethodBeat.i(247681);
        if (getLiveData().djl()) {
            hn hnVar = new hn();
            hnVar.dLW.id = getLiveData().liveInfo.liveId;
            hnVar.dLW.username = getLiveData().hwd;
            hnVar.dLW.liveStatus = 2;
            hnVar.dLW.dLY = 1;
            hnVar.dLW.type = 8;
            EventCenter.instance.publish(hnVar);
        }
        AppMethodBeat.o(247681);
    }

    @Override // com.tencent.mm.live.view.BaseLivePluginLayout
    public final boolean onBackPress() {
        AppMethodBeat.i(247682);
        boolean onBackPress = super.onBackPress();
        AppMethodBeat.o(247682);
        return onBackPress;
    }

    @Override // com.tencent.mm.live.c.b
    public final int getLiveRole() {
        return 0;
    }

    private final void prepareShopping() {
        AppMethodBeat.i(247683);
        bp bpVar = this.bottomOptionPlugin;
        if (bpVar != null) {
            bp.a aVar = bp.uvc;
            bpVar.Jn(bp.dhX());
        }
        bd bdVar = this.shoppingBubblePlugin;
        if (bdVar != null) {
            bdVar.rg(0);
        }
        com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
        com.tencent.mm.plugin.finder.report.live.m.dpm();
        if (!getLiveData().uEo) {
            getLiveData().uEo = true;
            com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = getFinderLiveAssistant();
            if (finderLiveAssistant != null) {
                s.a.a(finderLiveAssistant, getLiveData().liveInfo.liveId, getLiveData().hFK, new FinderLiveVisitorPluginLayout$prepareShopping$1(this));
                AppMethodBeat.o(247683);
                return;
            }
        }
        AppMethodBeat.o(247683);
    }

    private final void parseInjectEvent() {
        AppMethodBeat.i(260868);
        String str = getLiveData().UPV.event;
        Bundle bundle = getLiveData().UPV.bundle;
        Object obj = getLiveData().UPV.UPL;
        if (str == null) {
            AppMethodBeat.o(260868);
            return;
        }
        Log.i(this.TAG, "parseInjectEvent injectEvent:".concat(String.valueOf(str)));
        switch (str.hashCode()) {
            case -535820704:
                if (str.equals("EVENT_POST_PORTRAIT_ACTION")) {
                    onPortraitAction(getLiveData().uEg, getLiveData().uEf, bundle, obj);
                    break;
                }
                break;
            case 568836628:
                if (str.equals("EVENT_POST_LANDSCAPE_ACTION")) {
                    onLandscapeAction(getLiveData().uEg, getLiveData().uEf, bundle, obj);
                    break;
                }
                break;
        }
        getLiveData().UPV.event = null;
        getLiveData().UPV.bundle = null;
        getLiveData().UPV.UPL = null;
        AppMethodBeat.o(260868);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public final void applyState(int i2, int i3, Bundle bundle) {
        boolean z;
        ViewGroup viewGroup;
        String str;
        String str2;
        String string;
        ViewGroup viewGroup2;
        com.tencent.mm.plugin.finder.api.g gVar;
        String str3;
        String str4;
        String str5;
        FinderAuthInfo finderAuthInfo;
        String str6 = null;
        FinderAuthInfo finderAuthInfo2 = null;
        AppMethodBeat.i(247684);
        Log.i(this.TAG, "applyState liveState:" + i2 + ",uiState:" + i3);
        if (getLiveData().hTZ()) {
            hidePlugins();
            showBlurBg();
            v vVar = this.commentPlugin;
            if (vVar != null) {
                vVar.reset();
            }
            v vVar2 = this.commentPluginInInput;
            if (vVar2 != null) {
                vVar2.reset();
                AppMethodBeat.o(247684);
                return;
            }
            AppMethodBeat.o(247684);
            return;
        }
        if (getLiveData().uEg == 2) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            onLiveStartedWait();
            AppMethodBeat.o(247684);
        } else if (getLiveData().djl()) {
            forceScreenToPortrait();
            hideLoadingLayer();
            bz bzVar = this.previewPlugin;
            if (bzVar != null) {
                bzVar.rg(8);
            }
            bb bbVar = this.shadowPlugin;
            if (bbVar != null) {
                bbVar.rg(8);
            }
            bh bhVar = this.titleInfoPlugin;
            if (bhVar != null) {
                bhVar.rg(8);
            }
            y yVar = this.commonInfoPlugin;
            if (yVar != null) {
                yVar.rg(8);
            }
            v vVar3 = this.commentPlugin;
            if (vVar3 != null) {
                vVar3.rg(8);
            }
            bj bjVar = this.topCommentPlugin;
            if (bjVar != null) {
                bjVar.rg(8);
            }
            com.tencent.mm.plugin.finder.live.plugin.aw awVar = this.postPlugin;
            if (awVar != null) {
                awVar.rg(8);
            }
            com.tencent.mm.plugin.finder.live.plugin.ar arVar = this.identifyPlugin;
            if (arVar != null) {
                arVar.rg(8);
            }
            br brVar = this.closePlugin;
            if (brVar != null) {
                brVar.rg(8);
            }
            aj ajVar = this.confettiPlugin;
            if (ajVar != null) {
                ajVar.rg(8);
            }
            at atVar = this.moreActionPlugin;
            if (atVar != null) {
                atVar.rg(8);
            }
            bd bdVar = this.shoppingBubblePlugin;
            if (bdVar != null) {
                bdVar.rg(8);
            }
            bf bfVar = this.shoppingListPlugin;
            if (bfVar != null) {
                bfVar.rg(8);
            }
            bm bmVar = this.videoOrientationPlugin;
            if (bmVar != null) {
                bmVar.rg(8);
            }
            al alVar = this.lotteryBubblePlugin;
            if (alVar != null) {
                alVar.rg(8);
            }
            by byVar = this.lotteryCardPlugin;
            if (byVar != null) {
                byVar.rg(8);
            }
            bw bwVar = this.linkMicStatePlugin;
            if (bwVar != null) {
                bwVar.rg(8);
            }
            cb cbVar = this.micDecoratePlugin;
            if (cbVar != null) {
                cbVar.rg(8);
            }
            bl blVar = this.micAudioPreviewPlugin;
            if (blVar != null) {
                blVar.rg(8);
            }
            bv bvVar = this.linkLisencePlugin;
            if (bvVar != null) {
                bvVar.rg(8);
            }
            aa aaVar = this.giftPanelPlugin;
            if (aaVar != null) {
                aaVar.rg(8);
            }
            ac acVar = this.giftPlayPlugin;
            if (acVar != null) {
                acVar.rg(8);
            }
            ae aeVar = this.giftQueuePlugin;
            if (aeVar != null) {
                aeVar.rg(8);
            }
            af afVar = this.giftSendPlugin;
            if (afVar != null) {
                afVar.rg(8);
            }
            bu buVar = this.wecoinHotExplainPlugin;
            if (buVar != null) {
                buVar.rg(8);
            }
            bp bpVar = this.bottomOptionPlugin;
            if (bpVar != null) {
                bpVar.rg(8);
            }
            ap apVar = this.memberListPlugin;
            if (apVar != null) {
                apVar.rg(8);
            }
            av avVar = this.moreLiveEntrancePlugin;
            if (avVar != null) {
                avVar.rg(8);
            }
            as asVar = this.luckyMoneyPlugin;
            if (asVar != null) {
                asVar.rg(8);
            }
            aq aqVar = this.bottomTipPlugin;
            if (aqVar != null) {
                aqVar.rg(8);
            }
            bo boVar = this.finderLiveAfterPlugin;
            if (boVar != null) {
                RelativeLayout relativeLayout = boVar.hOm;
                Context context = boVar.hwr.getContext();
                p.g(context, "root.context");
                relativeLayout.setBackgroundColor(context.getResources().getColor(R.color.q3));
                if (boVar.getLiveData().hwd != null) {
                    c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
                    gVar = c.a.asG(boVar.getLiveData().hwd);
                } else {
                    gVar = null;
                }
                if (gVar != null) {
                    str3 = gVar.field_avatarUrl;
                } else {
                    str3 = null;
                }
                if (!Util.isNullOrNil(str3)) {
                    if (gVar == null || (str4 = gVar.field_avatarUrl) == null) {
                        str4 = "";
                    }
                    boVar.gL(str4, boVar.getLiveData().hwd);
                    if (gVar == null || (finderAuthInfo = gVar.field_authInfo) == null) {
                        str5 = null;
                    } else {
                        str5 = finderAuthInfo.authProfession;
                    }
                    int i4 = boVar.getLiveData().friendFollowCount;
                    if (gVar != null) {
                        finderAuthInfo2 = gVar.field_authInfo;
                    }
                    boVar.a(str5, i4, finderAuthInfo2);
                } else {
                    Log.i(boVar.TAG, "update bg fail,contact is null!");
                    com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
                    p.g(aAg, "MMKernel.network()");
                    aAg.azz().a(3736, boVar);
                    com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
                    com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
                    if (finderLiveAssistant != null) {
                        finderLiveAssistant.aty(boVar.getLiveData().hwd);
                    }
                    boVar.hOm.setVisibility(8);
                    boVar.uuU.setVisibility(0);
                }
            }
            bo boVar2 = this.finderLiveAfterPlugin;
            if (boVar2 != null) {
                if (boVar2.uuV) {
                    boVar2.hwr.animate().translationX(0.0f).setDuration(200).withStartAction(new bo.a(boVar2));
                } else {
                    boVar2.hwr.setTranslationX(0.0f);
                    boVar2.rg(0);
                }
            }
            com.tencent.mm.plugin.finder.report.live.m.vli.a(s.at.CloseTypeLiveOver);
            AppMethodBeat.o(247684);
        } else {
            if (getLiveData().isLiveStarted()) {
                com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant2 = getFinderLiveAssistant();
                if (finderLiveAssistant2 != null) {
                    finderLiveAssistant2.dfl();
                }
                if (!d.cW(getLiveData().uEf, SdkInfo.ErrCode.kErrCodeNotFound)) {
                    hideLoadingLayer();
                }
                bh bhVar2 = this.titleInfoPlugin;
                if (bhVar2 != null) {
                    bh.a(bhVar2);
                }
                v vVar4 = this.commentPlugin;
                if (vVar4 != null) {
                    vVar4.rg(0);
                }
                bh bhVar3 = this.titleInfoPlugin;
                if (bhVar3 != null) {
                    bhVar3.rg(0);
                }
                y yVar2 = this.commonInfoPlugin;
                if (yVar2 != null) {
                    yVar2.rg(0);
                }
                bb bbVar2 = this.shadowPlugin;
                if (bbVar2 != null) {
                    bbVar2.rg(0);
                }
                com.tencent.mm.plugin.finder.live.plugin.aw awVar2 = this.postPlugin;
                if (awVar2 != null) {
                    awVar2.rg(0);
                }
                com.tencent.mm.plugin.finder.live.plugin.ar arVar2 = this.identifyPlugin;
                if (arVar2 != null) {
                    arVar2.rg(0);
                }
                br brVar2 = this.closePlugin;
                if (brVar2 != null) {
                    brVar2.rg(0);
                }
                aj ajVar2 = this.confettiPlugin;
                if (ajVar2 != null) {
                    ajVar2.rg(0);
                }
                at atVar2 = this.moreActionPlugin;
                if (atVar2 != null) {
                    atVar2.rg(0);
                }
                bo boVar3 = this.finderLiveAfterPlugin;
                if (boVar3 != null) {
                    boVar3.rg(8);
                }
                if (getLiveData().uEk) {
                    bd bdVar2 = this.shoppingBubblePlugin;
                    if (bdVar2 != null) {
                        bdVar2.rg(0);
                    }
                    com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
                    com.tencent.mm.plugin.finder.report.live.m.dpm();
                } else {
                    bd bdVar3 = this.shoppingBubblePlugin;
                    if (bdVar3 != null) {
                        bdVar3.rg(8);
                    }
                }
                bf bfVar2 = this.shoppingListPlugin;
                if (bfVar2 != null) {
                    bfVar2.rg(8);
                }
                ba baVar = this.screenClearPlugin;
                if (baVar != null) {
                    baVar.rg(0);
                }
                bp bpVar2 = this.bottomOptionPlugin;
                if (bpVar2 != null) {
                    bp.a aVar2 = bp.uvc;
                    bpVar2.Jn(bp.dhW());
                }
                bp bpVar3 = this.bottomOptionPlugin;
                if (bpVar3 != null) {
                    bp.b(bpVar3);
                }
                av avVar2 = this.moreLiveEntrancePlugin;
                if (avVar2 != null) {
                    avVar2.dhJ();
                }
                if (isLandscape()) {
                    bh bhVar4 = this.titleInfoPlugin;
                    if (!(bhVar4 == null || (viewGroup2 = bhVar4.hwr) == null)) {
                        viewGroup2.post(new FinderLiveVisitorPluginLayout$applyState$1(this));
                    }
                } else {
                    y yVar3 = this.commonInfoPlugin;
                    if (!(yVar3 == null || (viewGroup = yVar3.hwr) == null)) {
                        viewGroup.post(new FinderLiveVisitorPluginLayout$applyState$2(this));
                    }
                }
                al alVar2 = this.lotteryBubblePlugin;
                if (alVar2 != null) {
                    alVar2.dht();
                }
                enableRotation();
                parseInjectEvent();
                if (d.cW(getLiveData().uEf, 128)) {
                    forceScreenToPortrait();
                    prepareFinish();
                    exitLive();
                    bt btVar = this.exceptionPlugin;
                    if (btVar != null) {
                        btVar.rg(0);
                    }
                    bt btVar2 = this.exceptionPlugin;
                    if (btVar2 != null) {
                        String str7 = getLiveData().hwd;
                        p.h(str7, "anchorUserName");
                        Log.i(btVar2.TAG, "showKickedMemberTip anchorUserName:".concat(String.valueOf(str7)));
                        btVar2.atI(str7);
                        com.tencent.mm.plugin.finder.live.widget.f fVar = btVar2.umS;
                        if (fVar != null) {
                            f.c cVar = com.tencent.mm.plugin.finder.live.widget.f.uGx;
                            com.tencent.mm.plugin.finder.live.widget.f.a(fVar, com.tencent.mm.plugin.finder.live.widget.f.djI(), null, new bt.a(btVar2), 6);
                        }
                    }
                    com.tencent.mm.plugin.finder.report.live.m.vli.a(s.at.CloseTypeKickedOut);
                    AppMethodBeat.o(247684);
                    return;
                } else if (d.cW(getLiveData().uEf, 256)) {
                    forceScreenToPortrait();
                    prepareFinish();
                    bt btVar3 = this.exceptionPlugin;
                    if (btVar3 != null) {
                        String str8 = getLiveData().hwd;
                        p.h(str8, "anchorUserName");
                        Log.i(btVar3.TAG, "showPrivateCount anchorUserName:".concat(String.valueOf(str8)));
                        btVar3.atI(str8);
                        com.tencent.mm.plugin.finder.live.widget.f fVar2 = btVar3.umS;
                        if (fVar2 != null) {
                            f.c cVar2 = com.tencent.mm.plugin.finder.live.widget.f.uGx;
                            com.tencent.mm.plugin.finder.live.widget.f.a(fVar2, com.tencent.mm.plugin.finder.live.widget.f.djH(), null, new bt.b(btVar3), 6);
                        }
                    }
                    bt btVar4 = this.exceptionPlugin;
                    if (btVar4 != null) {
                        btVar4.rg(0);
                    }
                    exitLive();
                    AppMethodBeat.o(247684);
                    return;
                } else if (d.cW(getLiveData().uEf, 32)) {
                    forceScreenToPortrait();
                    hideBottomAraePlugin();
                    String str9 = getLiveData().hwd;
                    Context context2 = getContext();
                    p.g(context2, "context");
                    String string2 = context2.getResources().getString(R.string.cuk);
                    p.g(string2, "context.resources.getStr…ng_exception_tip_network)");
                    showTipWithBlurBg(str9, string2);
                    AppMethodBeat.o(247684);
                    return;
                } else if (d.cW(getLiveData().uEf, 64)) {
                    forceScreenToPortrait();
                    hideBottomAraePlugin();
                    String str10 = getLiveData().hwd;
                    Context context3 = getContext();
                    p.g(context3, "context");
                    String string3 = context3.getResources().getString(R.string.cqs);
                    p.g(string3, "context.resources.getStr…er_live_anchor_exception)");
                    showTipWithBlurBg(str10, string3);
                    AppMethodBeat.o(247684);
                    return;
                } else if (d.cW(getLiveData().uEf, 512)) {
                    showProgress();
                    AppMethodBeat.o(247684);
                    return;
                } else if (d.cW(getLiveData().uEf, 4)) {
                    bf bfVar3 = this.shoppingListPlugin;
                    if (bfVar3 != null) {
                        bf.a(bfVar3, bundle);
                        AppMethodBeat.o(247684);
                        return;
                    }
                    AppMethodBeat.o(247684);
                    return;
                } else if (d.cW(getLiveData().uEf, 2)) {
                    at atVar3 = this.moreActionPlugin;
                    if (atVar3 != null) {
                        atVar3.dhD();
                        AppMethodBeat.o(247684);
                        return;
                    }
                    AppMethodBeat.o(247684);
                    return;
                } else if (d.cW(getLiveData().uEf, 32768)) {
                    bv bvVar2 = this.linkLisencePlugin;
                    if (bvVar2 != null) {
                        bvVar2.rg(0);
                    }
                    bv bvVar3 = this.linkLisencePlugin;
                    if (bvVar3 != null) {
                        bvVar3.hRy.post(new bv.c(bvVar3));
                        AppMethodBeat.o(247684);
                        return;
                    }
                    AppMethodBeat.o(247684);
                    return;
                } else if (d.cW(getLiveData().uEf, 4096)) {
                    if (bundle == null || (string = bundle.getString("PARAM_FINDER_LIVE_URL")) == null) {
                        str2 = "";
                    } else {
                        str2 = string;
                    }
                    p.g(str2, "extraMsg?.getString(ILiv…AM_FINDER_LIVE_URL) ?: \"\"");
                    if (Util.isNullOrNil(str2)) {
                        AppMethodBeat.o(247684);
                        return;
                    } else if (isLandscape()) {
                        forceScreenToPortrait();
                        post(new FinderLiveVisitorPluginLayout$applyState$3(this, str2));
                        AppMethodBeat.o(247684);
                        return;
                    } else {
                        showRealNameBottomSheet(str2);
                        AppMethodBeat.o(247684);
                        return;
                    }
                } else if (d.cW(getLiveData().uEf, 65536)) {
                    com.tencent.mm.plugin.finder.report.live.m mVar2 = com.tencent.mm.plugin.finder.report.live.m.vli;
                    com.tencent.mm.plugin.finder.report.live.m.a(s.aw.CLICK_GIFT_BOARD_ENTRY_START_GIFT_BOARD, "", 0);
                    String string4 = bundle != null ? bundle.getString("PARAM_FINDER_LIVE_LINK_USERNAME") : null;
                    if (bundle != null) {
                        str = bundle.getString("PARAM_FINDER_LIVE_LINK_NICKNAME");
                    } else {
                        str = null;
                    }
                    if (bundle != null) {
                        str6 = bundle.getString("PARAM_FINDER_LIVE_LINK_AVATAR");
                    }
                    Log.i(this.TAG, "UI_STATE_GIFT targetUsername:" + string4 + " targetNickname:" + str + " targetAvatar:" + str6);
                    if (!Util.isNullOrNil(string4)) {
                        aa.l lVar = new aa.l(string4, str, str6);
                        aa aaVar2 = this.giftPanelPlugin;
                        if (aaVar2 != null) {
                            aaVar2.a(lVar);
                            AppMethodBeat.o(247684);
                            return;
                        }
                        AppMethodBeat.o(247684);
                        return;
                    }
                    aa aaVar3 = this.giftPanelPlugin;
                    if (aaVar3 != null) {
                        aa.p(aaVar3);
                        AppMethodBeat.o(247684);
                        return;
                    }
                    AppMethodBeat.o(247684);
                    return;
                } else if (d.cW(getLiveData().uEf, 131072)) {
                    bu buVar2 = this.wecoinHotExplainPlugin;
                    if (buVar2 != null) {
                        buVar2.rg(0);
                        buVar2.hRy.post(new bu.a(buVar2));
                        AppMethodBeat.o(247684);
                        return;
                    }
                    AppMethodBeat.o(247684);
                    return;
                } else {
                    super.applyState(i2, i3, bundle);
                }
            }
            AppMethodBeat.o(247684);
        }
    }

    private final void onLiveStartedWait() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        AppMethodBeat.i(247685);
        com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = getFinderLiveAssistant();
        if (finderLiveAssistant != null) {
            finderLiveAssistant.dfl();
        }
        bh bhVar = this.titleInfoPlugin;
        if (bhVar != null) {
            bh.a(bhVar);
        }
        v vVar = this.commentPlugin;
        if (vVar != null) {
            vVar.rg(0);
        }
        bh bhVar2 = this.titleInfoPlugin;
        if (bhVar2 != null) {
            bhVar2.rg(0);
        }
        y yVar = this.commonInfoPlugin;
        if (yVar != null) {
            yVar.rg(0);
        }
        bb bbVar = this.shadowPlugin;
        if (bbVar != null) {
            bbVar.rg(0);
        }
        com.tencent.mm.plugin.finder.live.plugin.aw awVar = this.postPlugin;
        if (awVar != null) {
            awVar.rg(0);
        }
        com.tencent.mm.plugin.finder.live.plugin.ar arVar = this.identifyPlugin;
        if (arVar != null) {
            arVar.rg(0);
        }
        br brVar = this.closePlugin;
        if (brVar != null) {
            brVar.rg(0);
        }
        aj ajVar = this.confettiPlugin;
        if (ajVar != null) {
            ajVar.rg(0);
        }
        at atVar = this.moreActionPlugin;
        if (atVar != null) {
            atVar.rg(0);
        }
        bo boVar = this.finderLiveAfterPlugin;
        if (boVar != null) {
            boVar.rg(8);
        }
        if (getLiveData().uEk) {
            bd bdVar = this.shoppingBubblePlugin;
            if (bdVar != null) {
                bdVar.rg(0);
            }
            com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
            com.tencent.mm.plugin.finder.report.live.m.dpm();
        } else {
            bd bdVar2 = this.shoppingBubblePlugin;
            if (bdVar2 != null) {
                bdVar2.rg(8);
            }
        }
        bf bfVar = this.shoppingListPlugin;
        if (bfVar != null) {
            bfVar.rg(8);
        }
        ba baVar = this.screenClearPlugin;
        if (baVar != null) {
            baVar.rg(0);
        }
        bp bpVar = this.bottomOptionPlugin;
        if (bpVar != null) {
            bp.a aVar = bp.uvc;
            bpVar.Jn(bp.dhW());
        }
        bp bpVar2 = this.bottomOptionPlugin;
        if (bpVar2 != null) {
            bp.b(bpVar2);
        }
        av avVar = this.moreLiveEntrancePlugin;
        if (avVar != null) {
            avVar.dhJ();
        }
        if (isLandscape()) {
            bh bhVar3 = this.titleInfoPlugin;
            if (!(bhVar3 == null || (viewGroup2 = bhVar3.hwr) == null)) {
                viewGroup2.post(new FinderLiveVisitorPluginLayout$onLiveStartedWait$1(this));
            }
        } else {
            y yVar2 = this.commonInfoPlugin;
            if (!(yVar2 == null || (viewGroup = yVar2.hwr) == null)) {
                viewGroup.post(new FinderLiveVisitorPluginLayout$onLiveStartedWait$2(this));
            }
        }
        al alVar = this.lotteryBubblePlugin;
        if (alVar != null) {
            alVar.dht();
        }
        if (d.cW(getLiveData().uEf, 64)) {
            forceScreenToPortrait();
            hideBottomAraePlugin();
            String str = getLiveData().hwd;
            Context context = getContext();
            p.g(context, "context");
            String string = context.getResources().getString(R.string.cqs);
            p.g(string, "context.resources.getStr…er_live_anchor_exception)");
            showTipWithBlurBg(str, string);
        }
        AppMethodBeat.o(247685);
    }

    private final void showRealNameBottomSheet(String str) {
        AppMethodBeat.i(247686);
        Context context = getContext();
        p.g(context, "context");
        this.commentRealNamePlugin = new x(new FinderLiveCommentPostRealNamePanel(context), this);
        x xVar = this.commentRealNamePlugin;
        if (xVar != null) {
            xVar.l(str, new FinderLiveVisitorPluginLayout$showRealNameBottomSheet$1(this));
            AppMethodBeat.o(247686);
            return;
        }
        AppMethodBeat.o(247686);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0424, code lost:
        if (r0.intValue() == 1) goto L_0x0400;
     */
    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout, com.tencent.mm.live.view.BaseLivePluginLayout, com.tencent.mm.live.c.b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void statusChange(com.tencent.mm.live.c.b.c r14, android.os.Bundle r15) {
        /*
        // Method dump skipped, instructions count: 1112
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.view.FinderLiveVisitorPluginLayout.statusChange(com.tencent.mm.live.c.b$c, android.os.Bundle):void");
    }

    private final void handleLinkMicRequest(int i2, int i3, int i4, String str, avg avg) {
        int i5 = 1;
        AppMethodBeat.i(247689);
        Log.i(this.TAG, "[linkApplyMic result] ".concat(String.valueOf(i3)));
        String str2 = avg.LFw;
        if (i4 == 0 && i3 == 0) {
            com.tencent.mm.plugin.finder.utils.af afVar = com.tencent.mm.plugin.finder.utils.af.waa;
            com.tencent.mm.plugin.finder.utils.af.dEp();
            com.tencent.mm.plugin.finder.live.viewmodel.g liveData = getLiveData();
            if (i2 != 1) {
                i5 = 2;
            }
            liveData.uEC = i5;
            bw bwVar = this.linkMicStatePlugin;
            if (bwVar != null) {
                bwVar.dgW();
            }
            bp bpVar = this.bottomOptionPlugin;
            if (bpVar != null) {
                bpVar.dgP();
            }
            com.tencent.mm.plugin.finder.live.viewmodel.g liveData2 = getLiveData();
            String str3 = avg.session_id;
            if (str3 == null) {
                str3 = "";
            }
            liveData2.bxO(str3);
            com.tencent.mm.plugin.finder.live.model.a.b bVar = com.tencent.mm.plugin.finder.live.model.a.b.ULf;
            com.tencent.mm.plugin.finder.live.model.a.b.hTm();
            AppMethodBeat.o(247689);
        } else if (i3 == -200016) {
            Log.i(this.TAG, "[linkApplyMic Err] need realname, url:".concat(String.valueOf(str2)));
            if (str2 != null) {
                forceScreenToPortrait();
                Context context = getContext();
                p.g(context, "context");
                this.commentRealNamePlugin = new x(new FinderLiveCommentPostRealNamePanel(context), this);
                x xVar = this.commentRealNamePlugin;
                if (xVar != null) {
                    xVar.l(str2, new FinderLiveVisitorPluginLayout$handleLinkMicRequest$$inlined$let$lambda$1(this));
                    AppMethodBeat.o(247689);
                    return;
                }
                AppMethodBeat.o(247689);
                return;
            }
            AppMethodBeat.o(247689);
        } else if (i3 == -200009) {
            if (Util.isNullOrNil(str)) {
                Context context2 = getContext();
                p.g(context2, "context");
                str = context2.getResources().getString(R.string.cu0);
            }
            f.a hbu = new f.a(getContext()).hbu();
            Context context3 = getContext();
            p.g(context3, "context");
            hbu.boA(context3.getResources().getString(R.string.w0)).bow(str).show();
            AppMethodBeat.o(247689);
        } else if (i3 == -200018) {
            if (Util.isNullOrNil(str)) {
                Context context4 = getContext();
                p.g(context4, "context");
                str = context4.getResources().getString(R.string.cty);
            }
            f.a hbu2 = new f.a(getContext()).hbu();
            Context context5 = getContext();
            p.g(context5, "context");
            hbu2.boA(context5.getResources().getString(R.string.w0)).bow(str).show();
            AppMethodBeat.o(247689);
        } else if (i3 == -200010 || i3 == -200017) {
            if (Util.isNullOrNil(str)) {
                Context context6 = getContext();
                p.g(context6, "context");
                str = context6.getResources().getString(R.string.ctz);
            }
            f.a hbu3 = new f.a(getContext()).hbu();
            Context context7 = getContext();
            p.g(context7, "context");
            hbu3.boA(context7.getResources().getString(R.string.w0)).bow(str).show();
            AppMethodBeat.o(247689);
        } else {
            com.tencent.mm.plugin.finder.utils.af afVar2 = com.tencent.mm.plugin.finder.utils.af.waa;
            com.tencent.mm.plugin.finder.utils.af.dEq();
            Log.i(this.TAG, "[linkApplyMic Err] unkonwn errCode:$".concat(String.valueOf(i3)));
            AppMethodBeat.o(247689);
        }
    }

    private final void prepareFinish() {
        AppMethodBeat.i(247690);
        q qVar = q.ukd;
        q.dgC();
        hideLoadingLayer();
        bh bhVar = this.titleInfoPlugin;
        if (bhVar != null) {
            bhVar.rg(8);
        }
        bb bbVar = this.shadowPlugin;
        if (bbVar != null) {
            bbVar.rg(8);
        }
        bo boVar = this.finderLiveAfterPlugin;
        if (boVar != null) {
            boVar.rg(8);
        }
        v vVar = this.commentPlugin;
        if (vVar != null) {
            vVar.rg(8);
        }
        bj bjVar = this.topCommentPlugin;
        if (bjVar != null) {
            bjVar.rg(8);
        }
        y yVar = this.commonInfoPlugin;
        if (yVar != null) {
            yVar.rg(8);
        }
        ah ahVar = this.inputPluigin;
        if (ahVar != null) {
            ahVar.rg(8);
        }
        com.tencent.mm.plugin.finder.live.plugin.aw awVar = this.postPlugin;
        if (awVar != null) {
            awVar.rg(8);
        }
        com.tencent.mm.plugin.finder.live.plugin.ar arVar = this.identifyPlugin;
        if (arVar != null) {
            arVar.rg(8);
        }
        bz bzVar = this.previewPlugin;
        if (bzVar != null) {
            bzVar.rg(8);
        }
        aw awVar2 = this.liveTXLivePlayerPlygin;
        if (awVar2 != null) {
            awVar2.rg(8);
        }
        br brVar = this.closePlugin;
        if (brVar != null) {
            brVar.rg(8);
        }
        aj ajVar = this.confettiPlugin;
        if (ajVar != null) {
            ajVar.rg(8);
        }
        at atVar = this.moreActionPlugin;
        if (atVar != null) {
            atVar.rg(8);
        }
        bd bdVar = this.shoppingBubblePlugin;
        if (bdVar != null) {
            bdVar.rg(8);
        }
        bf bfVar = this.shoppingListPlugin;
        if (bfVar != null) {
            bfVar.rg(8);
        }
        bt btVar = this.exceptionPlugin;
        if (btVar != null) {
            btVar.rg(8);
        }
        bm bmVar = this.videoOrientationPlugin;
        if (bmVar != null) {
            bmVar.rg(8);
        }
        al alVar = this.lotteryBubblePlugin;
        if (alVar != null) {
            alVar.rg(8);
        }
        by byVar = this.lotteryCardPlugin;
        if (byVar != null) {
            byVar.rg(8);
        }
        bw bwVar = this.linkMicStatePlugin;
        if (bwVar != null) {
            bwVar.rg(8);
        }
        cb cbVar = this.micDecoratePlugin;
        if (cbVar != null) {
            cbVar.rg(8);
        }
        bl blVar = this.micAudioPreviewPlugin;
        if (blVar != null) {
            blVar.rg(8);
        }
        bv bvVar = this.linkLisencePlugin;
        if (bvVar != null) {
            bvVar.rg(8);
        }
        aa aaVar = this.giftPanelPlugin;
        if (aaVar != null) {
            aaVar.rg(8);
        }
        ac acVar = this.giftPlayPlugin;
        if (acVar != null) {
            acVar.rg(8);
        }
        ae aeVar = this.giftQueuePlugin;
        if (aeVar != null) {
            aeVar.rg(8);
        }
        af afVar = this.giftSendPlugin;
        if (afVar != null) {
            afVar.rg(8);
        }
        bu buVar = this.wecoinHotExplainPlugin;
        if (buVar != null) {
            buVar.rg(8);
        }
        bp bpVar = this.bottomOptionPlugin;
        if (bpVar != null) {
            bpVar.rg(8);
        }
        ap apVar = this.memberListPlugin;
        if (apVar != null) {
            apVar.rg(8);
        }
        av avVar = this.moreLiveEntrancePlugin;
        if (avVar != null) {
            avVar.rg(8);
        }
        as asVar = this.luckyMoneyPlugin;
        if (asVar != null) {
            asVar.rg(8);
        }
        aq aqVar = this.bottomTipPlugin;
        if (aqVar != null) {
            aqVar.rg(8);
            AppMethodBeat.o(247690);
            return;
        }
        AppMethodBeat.o(247690);
    }

    private final void hideBottomAraePlugin() {
        AppMethodBeat.i(247691);
        bf bfVar = this.shoppingListPlugin;
        if (bfVar != null) {
            bfVar.rg(8);
        }
        bd bdVar = this.shoppingBubblePlugin;
        if (bdVar != null) {
            bdVar.rg(8);
        }
        aj ajVar = this.confettiPlugin;
        if (ajVar != null) {
            ajVar.rg(8);
        }
        ah ahVar = this.inputPluigin;
        if (ahVar != null) {
            ahVar.rg(8);
        }
        com.tencent.mm.plugin.finder.live.plugin.aw awVar = this.postPlugin;
        if (awVar != null) {
            awVar.rg(8);
        }
        com.tencent.mm.plugin.finder.live.plugin.ar arVar = this.identifyPlugin;
        if (arVar != null) {
            arVar.rg(8);
        }
        v vVar = this.commentPlugin;
        if (vVar != null) {
            vVar.rg(8);
        }
        bj bjVar = this.topCommentPlugin;
        if (bjVar != null) {
            bjVar.rg(8);
        }
        bv bvVar = this.linkLisencePlugin;
        if (bvVar != null) {
            bvVar.rg(8);
        }
        by byVar = this.lotteryCardPlugin;
        if (byVar != null) {
            byVar.rg(8);
        }
        af afVar = this.giftSendPlugin;
        if (afVar != null) {
            afVar.rg(8);
        }
        bu buVar = this.wecoinHotExplainPlugin;
        if (buVar != null) {
            buVar.rg(8);
        }
        bp bpVar = this.bottomOptionPlugin;
        if (bpVar != null) {
            bpVar.rg(8);
        }
        bw bwVar = this.linkMicStatePlugin;
        if (bwVar != null) {
            bwVar.rg(8);
        }
        ap apVar = this.memberListPlugin;
        if (apVar != null) {
            apVar.rg(8);
            AppMethodBeat.o(247691);
            return;
        }
        AppMethodBeat.o(247691);
    }

    public final void checkMiniWindow() {
        AppMethodBeat.i(247692);
        Log.i(this.TAG, "checkMiniWindow:" + getCheckMiniWin());
        if (!getCheckMiniWin()) {
            stopLiveVideo();
            stopTimer();
            setCheckMiniWin(true);
        }
        AppMethodBeat.o(247692);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(247693);
        Log.i(this.TAG, "onSceneEnd errType:" + i2 + ", errCode:" + i3 + ", scene:" + qVar);
        if (qVar instanceof cn) {
            FinderContact cZk = ((cn) qVar).cZk();
            if (((cn) qVar).twC && cZk != null && p.j(((cn) qVar).tuH, getLiveData().hwd)) {
                bh bhVar = this.titleInfoPlugin;
                if (bhVar != null) {
                    String str2 = cZk.username;
                    if (str2 == null) {
                        str2 = "";
                    }
                    bhVar.atN(str2);
                }
                getLiveData().friendFollowCount = ((cn) qVar).friendFollowCount;
            }
        }
        AppMethodBeat.o(247693);
    }

    @Override // com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public final void onLiveEventCallback(int i2, Bundle bundle) {
        T t;
        String str;
        com.tencent.mm.live.core.core.b.g gVar;
        T t2;
        com.tencent.mm.live.core.core.b.g gVar2;
        String string;
        String str2;
        T t3;
        T t4;
        com.tencent.mm.live.core.core.b.g gVar3;
        String string2;
        com.tencent.mm.live.core.core.b.g gVar4;
        T t5;
        T t6;
        Object[] objArr = null;
        int i3 = 0;
        boolean z = false;
        String str3 = null;
        AppMethodBeat.i(247694);
        Log.i(this.LOOPTAG, "sdk callback errorCode:".concat(String.valueOf(i2)));
        e.d dVar = e.d.hxF;
        if (i2 == e.d.aCv()) {
            Log.i(this.TAG, "first I frame");
            if (Util.isEqual(bundle != null ? bundle.getString("live_user_id") : null, getLiveData().hIv.Mop)) {
                com.tencent.mm.plugin.finder.utils.af afVar = com.tencent.mm.plugin.finder.utils.af.waa;
                StringBuilder sb = new StringBuilder();
                com.tencent.mm.plugin.finder.utils.af afVar2 = com.tencent.mm.plugin.finder.utils.af.waa;
                String sb2 = sb.append(com.tencent.mm.plugin.finder.utils.af.dEm()).append(getData().uCr.getLiveId()).toString();
                ad.a aVar = ad.vZu;
                com.tencent.mm.plugin.finder.utils.af.a(afVar, sb2, ad.vYT.name, null, false, true, 12);
                b.C0376b.a(this, b.c.hMy);
                getLiveData().videoWidth = bundle != null ? bundle.getInt("live_first_frame_width") : 0;
                com.tencent.mm.plugin.finder.live.viewmodel.g liveData = getLiveData();
                if (bundle != null) {
                    i3 = bundle.getInt("live_first_frame_height");
                }
                liveData.videoHeight = i3;
                Log.i(this.TAG, "EVENT_RENDER_FIRST_I_FRAME videoWidth:" + getLiveData().videoWidth + ",videoHeight:" + getLiveData().videoHeight);
                AppMethodBeat.o(247694);
                return;
            }
        } else {
            e.d dVar2 = e.d.hxF;
            if (i2 != e.d.aCp()) {
                e.d dVar3 = e.d.hxF;
                if (i2 == e.d.aCr()) {
                    int curNetworkType = getCurNetworkType();
                    com.tencent.mm.live.core.core.d.b bVar = this.liveCore;
                    setCurNetworkType((bVar == null || (gVar4 = bVar.hAz) == null) ? -1 : gVar4.networkType);
                    if (!(curNetworkType != 0 || getCurNetworkType() == 0 || getCurNetworkType() == -1)) {
                        Context context = getContext();
                        Context context2 = getContext();
                        p.g(context2, "context");
                        u.makeText(context, context2.getResources().getString(R.string.cul), 0).show();
                        AppMethodBeat.o(247694);
                        return;
                    }
                } else {
                    e.d dVar4 = e.d.hxF;
                    if (i2 == e.d.aCy()) {
                        b.C0376b.a(this, b.c.hLB);
                        AppMethodBeat.o(247694);
                        return;
                    }
                    e.d dVar5 = e.d.hxF;
                    if (i2 == e.d.aCz()) {
                        statusChange(b.c.hNp, bundle);
                        AppMethodBeat.o(247694);
                        return;
                    }
                    e.d dVar6 = e.d.hxF;
                    if (i2 == e.d.aCA()) {
                        b.C0376b.a(this, b.c.hMp);
                        AppMethodBeat.o(247694);
                        return;
                    }
                    e.d dVar7 = e.d.hxF;
                    if (i2 == e.d.aCB()) {
                        b.C0376b.a(this, b.c.hMn);
                        AppMethodBeat.o(247694);
                        return;
                    }
                    e.d dVar8 = e.d.hxF;
                    if (i2 == e.d.aCC()) {
                        b.C0376b.a(this, b.c.hMo);
                        AppMethodBeat.o(247694);
                        return;
                    }
                    e.d dVar9 = e.d.hxF;
                    if (i2 == e.d.aCD()) {
                        statusChange(b.c.hME, bundle);
                        AppMethodBeat.o(247694);
                        return;
                    }
                    e.d dVar10 = e.d.hxF;
                    if (i2 == e.d.aCq()) {
                        if (bundle == null || (string2 = bundle.getString("live_user_id")) == null) {
                            str2 = "";
                        } else {
                            str2 = string2;
                        }
                        p.g(str2, "param?.getString(LiveErr…slate.LIVE_USER_ID) ?: \"\"");
                        if (bundle != null) {
                            z = bundle.getBoolean("live_media_enable");
                        }
                        com.tencent.mm.live.core.core.d.b bVar2 = this.liveCore;
                        if (Util.isEqual((bVar2 == null || (gVar3 = bVar2.hAz) == null) ? null : gVar3.hzG, str2)) {
                            List<com.tencent.mm.plugin.finder.live.viewmodel.e> list = getLiveData().UPZ;
                            p.g(list, "liveData.audienceLinkMicUserList");
                            List<com.tencent.mm.plugin.finder.live.viewmodel.e> list2 = list;
                            synchronized (list2) {
                                try {
                                    Iterator<T> it = list2.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            t4 = null;
                                            break;
                                        }
                                        t4 = it.next();
                                        if (Util.isEqual(t4.uCo, getLiveData().djq())) {
                                            break;
                                        }
                                    }
                                } catch (Throwable th) {
                                    AppMethodBeat.o(247694);
                                    throw th;
                                }
                            }
                            if (t4 != null && !z) {
                                com.tencent.mm.plugin.finder.live.model.a.b bVar3 = com.tencent.mm.plugin.finder.live.model.a.b.ULf;
                                com.tencent.mm.plugin.finder.live.model.a.b.hTp();
                                postCloseLinkMsg();
                            }
                        }
                        if (z) {
                            bz bzVar = this.previewPlugin;
                            if (bzVar != null) {
                                bzVar.bxG(str2);
                                kotlin.x xVar = kotlin.x.SXb;
                            }
                            List<com.tencent.mm.plugin.finder.live.viewmodel.e> list3 = getLiveData().UPZ;
                            p.g(list3, "liveData.audienceLinkMicUserList");
                            List<com.tencent.mm.plugin.finder.live.viewmodel.e> list4 = list3;
                            synchronized (list4) {
                                try {
                                    Iterator<T> it2 = list4.iterator();
                                    while (true) {
                                        if (!it2.hasNext()) {
                                            t3 = null;
                                            break;
                                        }
                                        t3 = it2.next();
                                        if (Util.isEqual(t3.uCo, str2)) {
                                            break;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    AppMethodBeat.o(247694);
                                    throw th2;
                                }
                            }
                            if (t3 != null) {
                                notifyAudienceMicUserChange();
                            } else {
                                getLiveData().UQd.add(str2);
                            }
                        }
                        Log.i(this.TAG, "EVENT_ROOM_USER_AUDIO_STATE linkState:" + getLiveData().uEC + " curLinkMic:" + getLiveData().uEB + " audienceLinkMicUserList:" + getLiveData().UPZ + " userId:" + str2 + " enable:" + z);
                        AppMethodBeat.o(247694);
                        return;
                    }
                    e.d dVar11 = e.d.hxF;
                    if (i2 == e.d.aCo()) {
                        if (bundle == null || (string = bundle.getString("live_user_id")) == null) {
                            str = "";
                        } else {
                            str = string;
                        }
                        p.g(str, "param?.getString(LiveErr…slate.LIVE_USER_ID) ?: \"\"");
                        int djc = getLiveData().djc();
                        e.a aVar2 = e.a.hxc;
                        if (djc == e.a.aCf()) {
                            List<com.tencent.mm.plugin.finder.live.viewmodel.e> list5 = getLiveData().UPZ;
                            p.g(list5, "liveData.audienceLinkMicUserList");
                            List<com.tencent.mm.plugin.finder.live.viewmodel.e> list6 = list5;
                            synchronized (list6) {
                                try {
                                    Iterator<T> it3 = list6.iterator();
                                    while (true) {
                                        if (!it3.hasNext()) {
                                            t2 = null;
                                            break;
                                        }
                                        T next = it3.next();
                                        if (Util.isEqual(next.uCo, getLiveData().djq())) {
                                            t2 = next;
                                            break;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    AppMethodBeat.o(247694);
                                    throw th3;
                                }
                            }
                            T t7 = t2;
                            if (t7 != null) {
                                com.tencent.mm.live.core.core.d.b bVar4 = this.liveCore;
                                if (!(bVar4 == null || (gVar2 = bVar4.hAz) == null)) {
                                    str3 = gVar2.hzG;
                                }
                                if (Util.isEqual(str3, str)) {
                                    if (t7.uCx == 2) {
                                        post(new FinderLiveVisitorPluginLayout$onLiveEventCallback$4(this));
                                        com.tencent.mm.live.core.core.d.b bVar5 = this.liveCore;
                                        if (bVar5 != null) {
                                            Integer.valueOf(bVar5.aBY());
                                        }
                                    } else {
                                        post(new FinderLiveVisitorPluginLayout$onLiveEventCallback$5(this));
                                    }
                                }
                            }
                        } else {
                            int djc2 = getLiveData().djc();
                            e.a aVar3 = e.a.hxc;
                            if (djc2 == e.a.aCe()) {
                                com.tencent.mm.live.core.core.d.b bVar6 = this.liveCore;
                                if (!(bVar6 == null || (gVar = bVar6.hAz) == null)) {
                                    str3 = gVar.hzG;
                                }
                                if (!Util.isEqual(str3, str)) {
                                    notifyAudienceMicUserChange();
                                }
                            }
                        }
                        Log.i(this.TAG, "EVENT_USER_VIDEO_AVAILABLE linkState:" + getLiveData().uEC + " curLinkMic:" + getLiveData().uEB + " audienceLinkMicUserList:" + getLiveData().UPZ + " userId:" + str);
                        AppMethodBeat.o(247694);
                        return;
                    }
                    e.d dVar12 = e.d.hxF;
                    if (i2 == e.d.aCE()) {
                        com.tencent.mm.plugin.finder.live.model.j jVar = com.tencent.mm.plugin.finder.live.model.j.ujh;
                        com.tencent.mm.plugin.finder.live.model.j.dfP();
                        AppMethodBeat.o(247694);
                        return;
                    }
                    e.d dVar13 = e.d.hxF;
                    if (i2 == e.d.aFS()) {
                        String string3 = bundle != null ? bundle.getString("live_cdn_sei_msg") : null;
                        if (string3 != null) {
                            fhl fhl = new fhl();
                            fhl fhl2 = fhl;
                            byte[] bytes = string3.getBytes(kotlin.n.d.UTF_8);
                            p.g(bytes, "(this as java.lang.String).getBytes(charset)");
                            try {
                                fhl2.parseFrom(bytes);
                            } catch (Exception e2) {
                                Log.printDebugStack("safeParser", "", e2);
                            }
                            kotlin.x xVar2 = kotlin.x.SXb;
                            LinkedList<fhm> linkedList = fhl.MTn;
                            p.g(linkedList, "micSEIMsg.infos");
                            for (T t8 : linkedList) {
                                List<com.tencent.mm.plugin.finder.live.viewmodel.e> list7 = getLiveData().UPZ;
                                p.g(list7, "liveData.audienceLinkMicUserList");
                                List<com.tencent.mm.plugin.finder.live.viewmodel.e> list8 = list7;
                                synchronized (list8) {
                                    try {
                                        Iterator<T> it4 = list8.iterator();
                                        while (true) {
                                            if (!it4.hasNext()) {
                                                t = null;
                                                break;
                                            }
                                            t = it4.next();
                                            if (Util.isEqual(t.uCo, t8.KTu)) {
                                                break;
                                            }
                                        }
                                    } catch (Throwable th4) {
                                        AppMethodBeat.o(247694);
                                        throw th4;
                                    }
                                }
                                if (t == null) {
                                    getLiveData().UQd.add(t8.KTu);
                                }
                            }
                            Log.i(this.TAG, "EVENT_CDN_SEI_MESSAGE_LINK_MIC micSEIMsg.infos:" + fhl.MTn + " liveData.audienceLinkMicUserList:" + getLiveData().UPZ);
                            LinkedList<fhm> linkedList2 = fhl.MTn;
                            if (linkedList2 == null || linkedList2.isEmpty()) {
                                objArr = 1;
                            }
                            if (objArr != null) {
                                b.C0376b.a(this, b.c.hNR);
                            } else {
                                b.C0376b.a(this, b.c.hNQ);
                            }
                            notifyAudienceMicUserChange();
                            kotlin.x xVar3 = kotlin.x.SXb;
                        }
                    }
                }
            } else if (bundle != null) {
                String string4 = bundle.getString("live_user_id");
                Log.i(this.TAG, "user exit sdkUid:" + string4 + ",reason:" + bundle.getString("live_user_exit_reason") + " linkState:" + getLiveData().uEC + " curLinkMic:" + getLiveData().uEB + " audienceLinkMicUserList:" + getLiveData().UPZ);
                if (p.j(string4, getLiveData().hIv.Mop)) {
                    b.C0376b.a(this, b.c.hMq);
                    List<com.tencent.mm.plugin.finder.live.viewmodel.e> list9 = getLiveData().UPZ;
                    p.g(list9, "liveData.audienceLinkMicUserList");
                    List<com.tencent.mm.plugin.finder.live.viewmodel.e> list10 = list9;
                    synchronized (list10) {
                        try {
                            Iterator<T> it5 = list10.iterator();
                            while (true) {
                                if (!it5.hasNext()) {
                                    t6 = null;
                                    break;
                                }
                                t6 = it5.next();
                                if (Util.isEqual(t6.uCo, getLiveData().djq())) {
                                    break;
                                }
                            }
                        } catch (Throwable th5) {
                            AppMethodBeat.o(247694);
                            throw th5;
                        }
                    }
                    if (t6 != null) {
                        com.tencent.mm.plugin.finder.live.model.a.b bVar7 = com.tencent.mm.plugin.finder.live.model.a.b.ULf;
                        com.tencent.mm.plugin.finder.live.model.a.b.hTp();
                        postCloseLinkMsg();
                    }
                }
                List<com.tencent.mm.plugin.finder.live.viewmodel.e> list11 = getLiveData().UPZ;
                p.g(list11, "liveData.audienceLinkMicUserList");
                List<com.tencent.mm.plugin.finder.live.viewmodel.e> list12 = list11;
                synchronized (list12) {
                    try {
                        Iterator<T> it6 = list12.iterator();
                        while (true) {
                            if (!it6.hasNext()) {
                                t5 = null;
                                break;
                            }
                            t5 = it6.next();
                            if (Util.isEqual(t5.uCo, string4)) {
                                break;
                            }
                        }
                    } catch (Throwable th6) {
                        AppMethodBeat.o(247694);
                        throw th6;
                    }
                }
                if (t5 != null) {
                    notifyAudienceMicUserChange();
                }
                kotlin.x xVar4 = kotlin.x.SXb;
                AppMethodBeat.o(247694);
                return;
            } else {
                AppMethodBeat.o(247694);
                return;
            }
        }
        AppMethodBeat.o(247694);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0062, code lost:
        if (((r2 == null || (r2 = r2.liveInfo) == null) ? null : r2.LGV) == null) goto L_0x0064;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void checkFinderObject() {
        /*
        // Method dump skipped, instructions count: 171
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.view.FinderLiveVisitorPluginLayout.checkFinderObject():void");
    }

    private final void checkAnchorContactInfo() {
        AppMethodBeat.i(247696);
        com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = getFinderLiveAssistant();
        if (finderLiveAssistant != null) {
            finderLiveAssistant.aty(getLiveData().hwd);
            AppMethodBeat.o(247696);
            return;
        }
        AppMethodBeat.o(247696);
    }

    /* access modifiers changed from: protected */
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(247697);
        p.h(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        Log.i(this.TAG, "onConfigurationChanged lastOrientation:" + getLastOrientation() + ",orientation:" + configuration.orientation);
        if (getLastOrientation() != configuration.orientation) {
            setLastOrientation(configuration.orientation);
        }
        AppMethodBeat.o(247697);
    }

    @Override // com.tencent.mm.live.b.j, com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public final void onAcceptLiveMic(com.tencent.mm.live.b.a aVar) {
        AppMethodBeat.i(247698);
        p.h(aVar, "info");
        Log.i(this.TAG, "onAcceptLiveMic self:" + getLiveData().djq() + " acceptInfo:" + aVar);
        if (Util.isEqual(getLiveData().djq(), aVar.userId)) {
            onAcceptLinkMicSelf(aVar);
            AppMethodBeat.o(247698);
            return;
        }
        onAccepLinkMicOthers(aVar.hFE);
        AppMethodBeat.o(247698);
    }

    @Override // com.tencent.mm.live.b.j, com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public final void onCloseLiveMic(com.tencent.mm.live.b.f fVar) {
        String str;
        AppMethodBeat.i(247699);
        p.h(fVar, "info");
        Log.i(this.TAG, "onCloseLiveMic self:" + getLiveData().djq() + " closeInfo:" + fVar + " liveData.curLinkMicUser:" + getLiveData().uEB + " liveData.audienceLinkMicUserList:" + getLiveData().UPZ);
        com.tencent.mm.plugin.finder.live.viewmodel.e eVar = getLiveData().uEB;
        if (eVar == null || !eVar.UPN) {
            if (Util.isEqual(getLiveData().djq(), fVar.uCo)) {
                onCloseLinkMicSelf(fVar.uCx);
            } else {
                onCloseLinkMicOthers(fVar.uCx);
            }
            getLiveData().uEC = 0;
        } else {
            com.tencent.mm.plugin.finder.live.viewmodel.e eVar2 = getLiveData().uEB;
            if (eVar2 != null) {
                str = eVar2.sessionId;
            } else {
                str = null;
            }
            if (Util.isEqual(str, fVar.hFz)) {
                getLiveData().uEC = 0;
                getLiveData().uEB = null;
                notifyPKMicUserChange();
                b.C0376b.a(this, b.c.hNR);
                AppMethodBeat.o(247699);
                return;
            }
        }
        AppMethodBeat.o(247699);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.a.a, com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
    public final void onApplyMicTimeout() {
        T t;
        AppMethodBeat.i(260869);
        Log.i(this.TAG, "apply link mic timeout, will auto cancel. curLinkUser:" + getLiveData().uEB + " liveData.audienceLinkMicUserList:" + getLiveData().UPZ);
        List<com.tencent.mm.plugin.finder.live.viewmodel.e> list = getLiveData().UPZ;
        p.g(list, "liveData.audienceLinkMicUserList");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Util.isEqual(t.uCo, getLiveData().djq())) {
                break;
            }
        }
        if (t == null) {
            bw bwVar = this.linkMicStatePlugin;
            if (bwVar != null) {
                bwVar.dgX();
            }
            getLiveData().uEC = 0;
            postCloseLinkMsg();
        }
        com.tencent.mm.plugin.finder.report.live.m.a(com.tencent.mm.plugin.finder.report.live.m.vli, s.ax.TIMEOUT_NO_LINK_HUNG_UP, (s.z) null, 6);
        AppMethodBeat.o(260869);
    }

    private final void adjustLayout() {
        AppMethodBeat.i(247700);
        if (getLiveData().uEB == null) {
            List<com.tencent.mm.plugin.finder.live.viewmodel.e> list = getLiveData().UPZ;
            p.g(list, "liveData.audienceLinkMicUserList");
            if (!(!list.isEmpty())) {
                int djc = getLiveData().djc();
                e.a aVar = e.a.hxc;
                if (djc == e.a.aCe()) {
                    adjustLayoutTRTC();
                    AppMethodBeat.o(247700);
                    return;
                }
                int djc2 = getLiveData().djc();
                e.a aVar2 = e.a.hxc;
                if (djc2 == e.a.aCf()) {
                    adjustLayoutCDN();
                    AppMethodBeat.o(247700);
                    return;
                }
                Log.i(this.TAG, "invalid audience mode:" + getLiveData().djc());
                AppMethodBeat.o(247700);
                return;
            }
        }
        Log.i(this.TAG, "skip adjust layout, is linking mic now");
        AppMethodBeat.o(247700);
    }

    private final void adjustLayoutCDN() {
        float f2;
        int i2;
        AppMethodBeat.i(247701);
        aw awVar = this.liveTXLivePlayerPlygin;
        TXCloudVideoView aHJ = awVar != null ? awVar.aHJ() : null;
        ViewGroup.LayoutParams layoutParams = aHJ != null ? aHJ.getLayoutParams() : null;
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        ViewGroup.LayoutParams layoutParams3 = getPreviewRoot().getLayoutParams();
        if (!(layoutParams3 instanceof RelativeLayout.LayoutParams)) {
            layoutParams3 = null;
        }
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
        int i3 = 0;
        int i4 = -1;
        Context context = getContext();
        p.g(context, "context");
        Resources resources = context.getResources();
        p.g(resources, "context.resources");
        int i5 = resources.getConfiguration().orientation;
        boolean djn = getLiveData().djn();
        int i6 = 0;
        float f3 = 0.0f;
        boolean djp = getLiveData().djp();
        bm bmVar = this.videoOrientationPlugin;
        if (bmVar != null) {
            bmVar.nx(getLiveData().djm());
        }
        if (!djn || 1 != i5 || !djp) {
            f2 = 0.0f;
            i2 = -1;
        } else {
            int i7 = (int) (((float) au.az(MMApplicationContext.getContext()).x) * (((float) getLiveData().videoHeight) / ((float) getLiveData().videoWidth)));
            f3 = ((float) au.az(MMApplicationContext.getContext()).y) * 0.68799996f;
            Context context2 = MMApplicationContext.getContext();
            p.g(context2, "MMApplicationContext.getContext()");
            float dimension = context2.getResources().getDimension(R.dimen.a4u);
            if (((float) i7) <= f3) {
                i3 = ((int) (0.156f * ((float) au.az(MMApplicationContext.getContext()).y))) + au.getStatusBarHeight(getContext());
                if (((float) i7) < dimension) {
                    i4 = (int) dimension;
                    if (layoutParams2 != null) {
                        layoutParams2.addRule(16);
                        f2 = dimension;
                        i6 = i7;
                        i2 = i7;
                    } else {
                        f2 = dimension;
                        i6 = i7;
                        i2 = i7;
                    }
                } else {
                    f2 = dimension;
                    i6 = i7;
                    i2 = i7;
                    i4 = i7;
                }
            } else {
                i3 = 0;
                i4 = -1;
                if (layoutParams2 != null) {
                    layoutParams2.addRule(16);
                    f2 = dimension;
                    i6 = i7;
                    i2 = i7;
                } else {
                    f2 = dimension;
                    i6 = i7;
                    i2 = i7;
                }
            }
        }
        if (layoutParams4 != null) {
            layoutParams4.topMargin = i3;
        }
        if (layoutParams4 != null) {
            layoutParams4.height = i4;
        }
        if (layoutParams2 != null) {
            layoutParams2.height = i2;
        }
        getPreviewRoot().setLayoutParams(layoutParams4);
        if (aHJ != null) {
            aHJ.setLayoutParams(layoutParams2);
        }
        Log.i(this.TAG, "adjustLayoutCDN fitLandscapeVideo:" + djn + ",curOrientation:" + i5 + ",videoSizeValid:" + djp + ",uiState:" + getLiveData().uEf + ",videoScaleHeight:" + i6 + ",limitHeight:" + f3 + ",landscapePlayerMiniHeight:" + f2 + ',' + "parentLp height:" + (layoutParams4 != null ? Integer.valueOf(layoutParams4.height) : null) + ",top:" + (layoutParams4 != null ? Integer.valueOf(layoutParams4.topMargin) : null) + ", height:" + (layoutParams2 != null ? Integer.valueOf(layoutParams2.height) : null) + ",top:" + (layoutParams2 != null ? Integer.valueOf(layoutParams2.topMargin) : null));
        AppMethodBeat.o(247701);
    }

    private final void adjustLayoutTRTC() {
        LivePreviewView livePreviewView;
        float f2;
        int i2;
        AppMethodBeat.i(247702);
        bz bzVar = this.previewPlugin;
        if (bzVar != null) {
            livePreviewView = bzVar.hAs;
        } else {
            livePreviewView = null;
        }
        ViewGroup.LayoutParams layoutParams = livePreviewView != null ? livePreviewView.getLayoutParams() : null;
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        ViewGroup.LayoutParams layoutParams3 = getPreviewRoot().getLayoutParams();
        if (!(layoutParams3 instanceof RelativeLayout.LayoutParams)) {
            layoutParams3 = null;
        }
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
        int i3 = 0;
        int i4 = -1;
        Context context = getContext();
        p.g(context, "context");
        Resources resources = context.getResources();
        p.g(resources, "context.resources");
        int i5 = resources.getConfiguration().orientation;
        boolean djn = getLiveData().djn();
        int i6 = 0;
        float f3 = 0.0f;
        boolean djp = getLiveData().djp();
        bm bmVar = this.videoOrientationPlugin;
        if (bmVar != null) {
            bmVar.nx(getLiveData().djm());
        }
        if (!djn || 1 != i5 || !djp) {
            f2 = 0.0f;
            i2 = -1;
        } else {
            int i7 = (int) (((float) au.az(MMApplicationContext.getContext()).x) * (((float) getLiveData().videoHeight) / ((float) getLiveData().videoWidth)));
            f3 = ((float) au.az(MMApplicationContext.getContext()).y) * 0.68799996f;
            Context context2 = MMApplicationContext.getContext();
            p.g(context2, "MMApplicationContext.getContext()");
            float dimension = context2.getResources().getDimension(R.dimen.a4u);
            if (((float) i7) <= f3) {
                i3 = ((int) (0.156f * ((float) au.az(MMApplicationContext.getContext()).y))) + au.getStatusBarHeight(getContext());
                if (((float) i7) < dimension) {
                    i4 = (int) dimension;
                    if (layoutParams2 != null) {
                        layoutParams2.addRule(16);
                        f2 = dimension;
                        i6 = i7;
                        i2 = i7;
                    } else {
                        f2 = dimension;
                        i6 = i7;
                        i2 = i7;
                    }
                } else {
                    f2 = dimension;
                    i6 = i7;
                    i2 = i7;
                    i4 = i7;
                }
            } else {
                i3 = 0;
                i4 = -1;
                if (layoutParams2 != null) {
                    layoutParams2.addRule(16);
                    f2 = dimension;
                    i6 = i7;
                    i2 = i7;
                } else {
                    f2 = dimension;
                    i6 = i7;
                    i2 = i7;
                }
            }
        }
        if (layoutParams4 != null) {
            layoutParams4.topMargin = i3;
        }
        if (layoutParams4 != null) {
            layoutParams4.height = i4;
        }
        if (layoutParams2 != null) {
            layoutParams2.height = i2;
        }
        getPreviewRoot().setLayoutParams(layoutParams4);
        if (livePreviewView != null) {
            livePreviewView.setLayoutParams(layoutParams2);
        }
        Log.i(this.TAG, "adjustLayoutTRTC fitLandscapeVideo:" + djn + ",curOrientation:" + i5 + ",videoSizeValid:" + djp + ",uiState:" + getLiveData().uEf + ",videoScaleHeight:" + i6 + ",limitHeight:" + f3 + ",landscapePlayerMiniHeight:" + f2 + ',' + "parentLp height:" + (layoutParams4 != null ? Integer.valueOf(layoutParams4.height) : null) + ",top:" + (layoutParams4 != null ? Integer.valueOf(layoutParams4.topMargin) : null) + ", height:" + (layoutParams2 != null ? Integer.valueOf(layoutParams2.height) : null) + ",top:" + (layoutParams2 != null ? Integer.valueOf(layoutParams2.topMargin) : null));
        AppMethodBeat.o(247702);
    }

    public final Integer getVideoOrientationPluginVisiableVisable() {
        AppMethodBeat.i(247703);
        bm bmVar = this.videoOrientationPlugin;
        if (bmVar != null) {
            Integer valueOf = Integer.valueOf(bmVar.hwr.getVisibility());
            AppMethodBeat.o(247703);
            return valueOf;
        }
        AppMethodBeat.o(247703);
        return null;
    }

    public final bd getShoppingBubblePlugin() {
        return this.shoppingBubblePlugin;
    }
}
