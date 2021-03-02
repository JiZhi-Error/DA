package com.tencent.mm.plugin.finder.live.viewmodel;

import android.content.Context;
import android.graphics.Rect;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.core.core.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.r;
import com.tencent.mm.plugin.finder.live.model.t;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aug;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.avi;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awh;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.protocal.protobuf.awk;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.awr;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.protocal.protobuf.ffr;
import com.tencent.mm.protocal.protobuf.fgv;
import com.tencent.mm.protocal.protobuf.fgy;
import com.tencent.mm.protocal.protobuf.fhe;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.au;
import com.tencent.trtc.TRTCCloudDef;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.o;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000ì\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b8\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b^\n\u0002\u0010\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b@\u0018\u0000 \u00052\u00020\u0001:\u0002\u0005B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010£\u0004\u001a\u00030¤\u00042\u0007\u0010¥\u0004\u001a\u00020\u001eJ\u0012\u0010¦\u0004\u001a\u00020\u001e2\t\u0010§\u0004\u001a\u0004\u0018\u00010\nJ\u0012\u0010¨\u0004\u001a\u00020\u001e2\t\u0010§\u0004\u001a\u0004\u0018\u00010\nJ\u0007\u0010©\u0004\u001a\u00020\u0004J\b\u0010ª\u0004\u001a\u00030¤\u0004J\b\u0010«\u0004\u001a\u00030¤\u0004J\u0007\u0010¬\u0004\u001a\u00020\u001eJ\u0014\u0010­\u0004\u001a\u0004\u0018\u00010;2\t\u0010§\u0004\u001a\u0004\u0018\u00010\nJ\u0014\u0010®\u0004\u001a\u0004\u0018\u00010;2\t\u0010¯\u0004\u001a\u0004\u0018\u00010\nJ\u001b\u0010°\u0004\u001a\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\n0è\u00020ç\u0002J\u0007\u0010±\u0004\u001a\u00020\nJ\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020U0TH\u0002J\u0007\u0010²\u0004\u001a\u00020\u001eJ\u0007\u0010³\u0004\u001a\u00020\u001eJ\u0007\u0010´\u0004\u001a\u00020\nJ\b\u0010µ\u0004\u001a\u00030¤\u0004J\u0007\u0010¶\u0004\u001a\u00020\u001eJ\u0007\u0010·\u0004\u001a\u00020\u001eJ\u0007\u0010¸\u0004\u001a\u00020\u001eJ\u0007\u0010¹\u0004\u001a\u00020\u001eJ\u0007\u0010º\u0004\u001a\u00020\u001eJ\u0007\u0010»\u0004\u001a\u00020\u001eJ\u0007\u0010¼\u0004\u001a\u00020\u001eJ\u0007\u0010½\u0004\u001a\u00020\u001eJ\u0007\u0010¾\u0004\u001a\u00020\u001eJ\u0010\u0010¿\u0004\u001a\u00020\u001e2\u0007\u0010À\u0004\u001a\u00020\u0004J\u0010\u0010Á\u0004\u001a\u00020\u001e2\u0007\u0010À\u0004\u001a\u00020\u0004J\u0010\u0010Â\u0004\u001a\u00020\u001e2\u0007\u0010À\u0004\u001a\u00020\u0004J\u001b\u0010Ã\u0004\u001a\u00020\u001e2\b\u0010Ä\u0004\u001a\u00030Å\u00042\b\u0010Æ\u0004\u001a\u00030Å\u0004J\u0007\u0010Ç\u0004\u001a\u00020\u001eJ\u0007\u0010È\u0004\u001a\u00020\u001eJ\u0010\u0010É\u0004\u001a\u00020\u001e2\u0007\u0010Ê\u0004\u001a\u00020\nJ&\u0010Ë\u0004\u001a\u00020\n2\u001b\u0010Ì\u0004\u001a\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\n0è\u00020ç\u0002H\u0002J\u0014\u0010Í\u0004\u001a\u00030¤\u00042\n\u0010Î\u0004\u001a\u0005\u0018\u00010ó\u0002J\u0014\u0010Ï\u0004\u001a\u00030¤\u00042\n\u0010Ð\u0004\u001a\u0005\u0018\u00010Å\u0003J\u001c\u0010Ñ\u0004\u001a\u00030¤\u00042\u0007\u0010Ò\u0004\u001a\u00020\n2\t\b\u0002\u0010Ó\u0004\u001a\u00020\u001eJ\u001c\u0010Ô\u0004\u001a\u00030¤\u00042\u0007\u0010Ò\u0004\u001a\u00020\n2\t\b\u0002\u0010Ó\u0004\u001a\u00020\u001eJ\u0013\u0010Õ\u0004\u001a\u00030¤\u00042\t\u0010§\u0004\u001a\u0004\u0018\u00010\nJ\u001e\u0010Ö\u0004\u001a\u00030¤\u00042\t\u0010Ê\u0004\u001a\u0004\u0018\u00010\n2\t\b\u0002\u0010×\u0004\u001a\u00020\u001eJ\u0012\u0010Ø\u0004\u001a\u0004\u0018\u00010\f2\u0007\u0010Ù\u0004\u001a\u00020\nJ\u0012\u0010Ú\u0004\u001a\u00030¤\u00042\b\u0010Û\u0004\u001a\u00030Þ\u0002J\b\u0010Ü\u0004\u001a\u00030¤\u0004J#\u0010Ý\u0004\u001a\u00030¤\u00042\u000e\u0010Þ\u0004\u001a\t\u0012\u0005\u0012\u00030Å\u00040T2\t\b\u0002\u0010Ó\u0004\u001a\u00020\u001eJ\n\u0010ß\u0004\u001a\u00030¤\u0004H\u0002J\b\u0010à\u0004\u001a\u00030¤\u0004J#\u0010á\u0004\u001a\u00030¤\u00042\u000e\u0010â\u0004\u001a\t\u0012\u0005\u0012\u00030\u00030T2\t\b\u0002\u0010Ó\u0004\u001a\u00020\u001eJ\u0013\u0010ã\u0004\u001a\u00030¤\u00042\t\u0010ä\u0004\u001a\u0004\u0018\u00010;J\b\u0010å\u0004\u001a\u00030¤\u0004J\b\u0010æ\u0004\u001a\u00030¤\u0004J\u0012\u0010ç\u0004\u001a\u00030¤\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0013\u0010è\u0004\u001a\u00030¤\u00042\t\u0010Ê\u0004\u001a\u0004\u0018\u00010\nJ\u0007\u0010é\u0004\u001a\u00020\u0004J\u0007\u0010ê\u0004\u001a\u00020\u0004J\t\u0010ë\u0004\u001a\u0004\u0018\u00010\nJ\b\u0010ì\u0004\u001a\u00030¤\u0004J\u0007\u0010ô\u0003\u001a\u00020\u001eJ\t\u0010í\u0004\u001a\u00020\nH\u0016J\u001d\u0010î\u0004\u001a\u00030Þ\u00022\b\u0010ï\u0004\u001a\u00030Å\u00042\t\b\u0002\u0010ð\u0004\u001a\u00020\u001eJ\u0010\u0010ñ\u0004\u001a\u00030¤\u00042\u0006\u0010#\u001a\u00020\u0012J\u0011\u0010ò\u0004\u001a\u00030¤\u00042\u0007\u0010ó\u0004\u001a\u00020\u0012J\u0011\u0010ô\u0004\u001a\u00030¤\u00042\u0007\u0010õ\u0004\u001a\u00020\u0012J\u0019\u0010ö\u0004\u001a\u00030¤\u00042\t\u0010÷\u0004\u001a\u0004\u0018\u00010\u0004¢\u0006\u0003\u0010ø\u0004J\u0017\u0010ù\u0004\u001a\u00030¤\u00042\r\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020P0TJ\u0010\u0010ú\u0004\u001a\u00030¤\u00042\u0006\u0010#\u001a\u00020\u0012J\u0012\u0010û\u0004\u001a\u00030¤\u00042\b\u0010Û\u0004\u001a\u00030Þ\u0002J\u0011\u0010ü\u0004\u001a\u00030¤\u00042\u0007\u0010ó\u0004\u001a\u00020\u0012J\u0014\u0010ý\u0004\u001a\u00030¤\u00042\n\u0010þ\u0004\u001a\u0005\u0018\u00010Å\u0004J\u001e\u0010ÿ\u0004\u001a\t\u0012\u0005\u0012\u00030Å\u00040T2\u000e\u0010\u0005\u001a\t\u0012\u0005\u0012\u00030Å\u00040TJ\b\u0010\u0005\u001a\u00030¤\u0004J\b\u0010\u0005\u001a\u00030¤\u0004J\u0007\u0010\u0005\u001a\u00020\u001eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R*\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\f00j\b\u0012\u0004\u0012\u00020\f`1X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010)\"\u0004\b8\u0010+R>\u00109\u001a&\u0012\f\u0012\n <*\u0004\u0018\u00010;0; <*\u0012\u0012\f\u0012\n <*\u0004\u0018\u00010;0;\u0018\u00010=0:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001c\u0010B\u001a\u00020\u001e8FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010 \"\u0004\bD\u0010\"R(\u0010G\u001a\u0004\u0018\u00010F2\b\u0010E\u001a\u0004\u0018\u00010F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR$\u0010L\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020\u001e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010 \"\u0004\bN\u0010\"R>\u0010O\u001a&\u0012\f\u0012\n <*\u0004\u0018\u00010P0P <*\u0012\u0012\f\u0012\n <*\u0004\u0018\u00010P0P\u0018\u00010=0:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010?\"\u0004\bR\u0010AR \u0010S\u001a\b\u0012\u0004\u0012\u00020U0TX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001a\u0010Z\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u0014\"\u0004\b\\\u0010\u0016R\u001a\u0010]\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u0006\"\u0004\b_\u0010&R\u0017\u0010`\u001a\b\u0012\u0004\u0012\u00020a0T¢\u0006\b\n\u0000\u001a\u0004\bb\u0010WR\u001a\u0010c\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010 \"\u0004\be\u0010\"R\u001a\u0010f\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u0014\"\u0004\bh\u0010\u0016R\u001a\u0010i\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\u0014\"\u0004\bk\u0010\u0016R\u001a\u0010l\u001a\u00020mX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u001a\u0010r\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010)\"\u0004\bt\u0010+R\u001c\u0010u\u001a\u0004\u0018\u00010vX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR$\u0010{\u001a\u00020\u00122\u0006\u0010E\u001a\u00020\u0012@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010\u0014\"\u0004\b}\u0010\u0016R\u001f\u0010~\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0006\"\u0005\b\u0001\u0010&R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0006\"\u0005\b\u0001\u0010&R\u001d\u0010\u0001\u001a\u00020\u0012X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0014\"\u0005\b\u0001\u0010\u0016R\u001f\u0010\u0001\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010)\"\u0005\b\u0001\u0010+R.\u0010\u0001\u001a\u0011\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u001e0\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R$\u0010\u0001\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0015\n\u0003\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001d\u0010\u0001\u001a\u00020\u001eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010 \"\u0005\b\u0001\u0010\"R)\u0010\u0001\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020\u001e8F@FX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010 \"\u0005\b \u0001\u0010\"R\u001d\u0010¡\u0001\u001a\u00020\u001eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¢\u0001\u0010 \"\u0005\b£\u0001\u0010\"R\u001d\u0010¤\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¥\u0001\u0010\u0006\"\u0005\b¦\u0001\u0010&R\u001d\u0010§\u0001\u001a\u00020\u001eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¨\u0001\u0010 \"\u0005\b©\u0001\u0010\"R\u001f\u0010ª\u0001\u001a\u00020\u001e8FX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b«\u0001\u0010 \"\u0005\b¬\u0001\u0010\"R\u001d\u0010­\u0001\u001a\u00020\u001eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b®\u0001\u0010 \"\u0005\b¯\u0001\u0010\"R\u001d\u0010°\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b±\u0001\u0010\u0006\"\u0005\b²\u0001\u0010&R\u001d\u0010³\u0001\u001a\u00020\u001eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b´\u0001\u0010 \"\u0005\bµ\u0001\u0010\"R\u001d\u0010¶\u0001\u001a\u00020\u001eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b·\u0001\u0010 \"\u0005\b¸\u0001\u0010\"R\u001d\u0010¹\u0001\u001a\u00020\u001eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bº\u0001\u0010 \"\u0005\b»\u0001\u0010\"R\u001f\u0010¼\u0001\u001a\u00020\u001e8FX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b½\u0001\u0010 \"\u0005\b¾\u0001\u0010\"R'\u0010¿\u0001\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020\u001e@FX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÀ\u0001\u0010 \"\u0005\bÁ\u0001\u0010\"R\u001d\u0010Â\u0001\u001a\u00020\u001eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÃ\u0001\u0010 \"\u0005\bÄ\u0001\u0010\"R\u001d\u0010Å\u0001\u001a\u00020\u001eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÆ\u0001\u0010 \"\u0005\bÇ\u0001\u0010\"R\"\u0010È\u0001\u001a\u0005\u0018\u00010É\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÊ\u0001\u0010Ë\u0001\"\u0006\bÌ\u0001\u0010Í\u0001R-\u0010Î\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u001200j\b\u0012\u0004\u0012\u00020\u0012`1X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÏ\u0001\u00103\"\u0005\bÐ\u0001\u00105R\u001d\u0010Ñ\u0001\u001a\u00020\u001eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÒ\u0001\u0010 \"\u0005\bÓ\u0001\u0010\"R/\u0010Ô\u0001\u001a\u0014\u0012\u0005\u0012\u00030Õ\u000100j\t\u0012\u0005\u0012\u00030Õ\u0001`1X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÖ\u0001\u00103\"\u0005\b×\u0001\u00105R\u001d\u0010Ø\u0001\u001a\u00020\u001eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÙ\u0001\u0010 \"\u0005\bÚ\u0001\u0010\"R\u001d\u0010Û\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÜ\u0001\u0010\u0006\"\u0005\bÝ\u0001\u0010&R \u0010Þ\u0001\u001a\u00030ß\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bà\u0001\u0010á\u0001\"\u0006\bâ\u0001\u0010ã\u0001R\u001d\u0010ä\u0001\u001a\u00020\u001eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bå\u0001\u0010 \"\u0005\bæ\u0001\u0010\"R\u001d\u0010ç\u0001\u001a\u00020\u001eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bè\u0001\u0010 \"\u0005\bé\u0001\u0010\"RE\u0010ê\u0001\u001a*\u0012\u000e\u0012\f <*\u0005\u0018\u00010ë\u00010ë\u0001 <*\u0014\u0012\u000e\u0012\f <*\u0005\u0018\u00010ë\u00010ë\u0001\u0018\u00010=0:X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bì\u0001\u0010?\"\u0005\bí\u0001\u0010AR \u0010î\u0001\u001a\u00030ï\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bð\u0001\u0010ñ\u0001\"\u0006\bò\u0001\u0010ó\u0001R'\u0010ô\u0001\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020\u001e@FX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bô\u0001\u0010 \"\u0005\bõ\u0001\u0010\"R\u001d\u0010ö\u0001\u001a\u00020\u001eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bö\u0001\u0010 \"\u0005\b÷\u0001\u0010\"R\u001d\u0010ø\u0001\u001a\u00020\u001eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bø\u0001\u0010 \"\u0005\bù\u0001\u0010\"R\"\u0010ú\u0001\u001a\u0005\u0018\u00010û\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bü\u0001\u0010ý\u0001\"\u0006\bþ\u0001\u0010ÿ\u0001R\"\u0010\u0002\u001a\u0005\u0018\u00010\u0002X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R\"\u0010\u0002\u001a\u0005\u0018\u00010\u0002X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R-\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0005\u0012\u00030\u00020\u0002X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R\u001d\u0010\u0002\u001a\u00020\u0012X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0002\u0010\u0014\"\u0005\b\u0002\u0010\u0016R\u001d\u0010\u0002\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0002\u0010\u0006\"\u0005\b\u0002\u0010&R\"\u0010\u0002\u001a\u0005\u0018\u00010\u0002X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R\u001d\u0010\u0002\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b \u0002\u0010\u0006\"\u0005\b¡\u0002\u0010&R!\u0010¢\u0002\u001a\u000f\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\n\n\u0000\u001a\u0006\b£\u0002\u0010\u0001RA\u0010¤\u0002\u001a&\u0012\f\u0012\n <*\u0004\u0018\u00010;0; <*\u0012\u0012\f\u0012\n <*\u0004\u0018\u00010;0;\u0018\u00010=0:X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¥\u0002\u0010?\"\u0005\b¦\u0002\u0010AR\u001d\u0010§\u0002\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¨\u0002\u0010\u0006\"\u0005\b©\u0002\u0010&R\u001d\u0010ª\u0002\u001a\u00020\u001eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b«\u0002\u0010 \"\u0005\b¬\u0002\u0010\"R\"\u0010­\u0002\u001a\u0005\u0018\u00010\u0002X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b®\u0002\u0010\u0002\"\u0006\b¯\u0002\u0010\u0002R\u001d\u0010°\u0002\u001a\u00020\nX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b±\u0002\u0010)\"\u0005\b²\u0002\u0010+R\u001d\u0010³\u0002\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b´\u0002\u0010\u0006\"\u0005\bµ\u0002\u0010&R\"\u0010¶\u0002\u001a\u0005\u0018\u00010·\u0002X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¸\u0002\u0010¹\u0002\"\u0006\bº\u0002\u0010»\u0002R'\u0010¼\u0002\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020\u001e@FX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b½\u0002\u0010 \"\u0005\b¾\u0002\u0010\"R+\u0010À\u0002\u001a\u00030¿\u00022\u0007\u0010E\u001a\u00030¿\u0002@FX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÁ\u0002\u0010Â\u0002\"\u0006\bÃ\u0002\u0010Ä\u0002R\u001d\u0010Å\u0002\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÆ\u0002\u0010\u0006\"\u0005\bÇ\u0002\u0010&R\"\u0010È\u0002\u001a\u0005\u0018\u00010É\u0002X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÊ\u0002\u0010Ë\u0002\"\u0006\bÌ\u0002\u0010Í\u0002R \u0010Î\u0002\u001a\u00030Ï\u0002X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÐ\u0002\u0010Ñ\u0002\"\u0006\bÒ\u0002\u0010Ó\u0002R\u001d\u0010Ô\u0002\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÕ\u0002\u0010\u0006\"\u0005\bÖ\u0002\u0010&R\u001d\u0010×\u0002\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bØ\u0002\u0010\u0006\"\u0005\bÙ\u0002\u0010&R\u001d\u0010Ú\u0002\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÛ\u0002\u0010\u0006\"\u0005\bÜ\u0002\u0010&R\"\u0010Ý\u0002\u001a\u0005\u0018\u00010Þ\u0002X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bß\u0002\u0010à\u0002\"\u0006\bá\u0002\u0010â\u0002R$\u0010ã\u0002\u001a\t\u0012\u0005\u0012\u00030Þ\u00020TX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bä\u0002\u0010W\"\u0005\bå\u0002\u0010YR3\u0010æ\u0002\u001a\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\n0è\u00020ç\u0002X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bé\u0002\u0010ê\u0002\"\u0006\bë\u0002\u0010ì\u0002R\"\u0010í\u0002\u001a\u0005\u0018\u00010î\u0002X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bï\u0002\u0010ð\u0002\"\u0006\bñ\u0002\u0010ò\u0002R/\u0010ô\u0002\u001a\u0005\u0018\u00010ó\u00022\t\u0010E\u001a\u0005\u0018\u00010ó\u0002@FX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bõ\u0002\u0010ö\u0002\"\u0006\b÷\u0002\u0010ø\u0002R \u0010ù\u0002\u001a\u00030ú\u0002X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bû\u0002\u0010ü\u0002\"\u0006\bý\u0002\u0010þ\u0002RE\u0010ÿ\u0002\u001a*\u0012\u000e\u0012\f <*\u0005\u0018\u00010\u00030\u0003 <*\u0014\u0012\u000e\u0012\f <*\u0005\u0018\u00010\u00030\u0003\u0018\u00010=0:X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0003\u0010?\"\u0005\b\u0003\u0010ARA\u0010\u0003\u001a&\u0012\f\u0012\n <*\u0004\u0018\u00010P0P <*\u0012\u0012\f\u0012\n <*\u0004\u0018\u00010P0P\u0018\u00010=0:X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0003\u0010?\"\u0005\b\u0003\u0010AR \u0010\u0003\u001a\u00030\u0003X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0003\u0010\u0003\"\u0006\b\u0003\u0010\u0003R\u001d\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0003\u0010\u0006\"\u0005\b\u0003\u0010&R\u001d\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0003\u0010\u0006\"\u0005\b\u0003\u0010&RE\u0010\u0003\u001a*\u0012\u000e\u0012\f <*\u0005\u0018\u00010\u00020\u0002 <*\u0014\u0012\u000e\u0012\f <*\u0005\u0018\u00010\u00020\u0002\u0018\u00010=0:X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0003\u0010?\"\u0005\b\u0003\u0010AR\u001d\u0010\u0003\u001a\u00020\u001eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0003\u0010 \"\u0005\b\u0003\u0010\"R\u001f\u0010\u0003\u001a\u00020\u00048FX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0003\u0010\u0006\"\u0005\b\u0003\u0010&R-\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\n00j\b\u0012\u0004\u0012\u00020\n`1X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0003\u00103\"\u0005\b\u0003\u00105RA\u0010\u0003\u001a&\u0012\f\u0012\n <*\u0004\u0018\u00010;0; <*\u0012\u0012\f\u0012\n <*\u0004\u0018\u00010;0;\u0018\u00010=0:X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0003\u0010?\"\u0005\b \u0003\u0010AR\u001f\u0010¡\u0003\u001a\u00020\u00048FX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¢\u0003\u0010\u0006\"\u0005\b£\u0003\u0010&R\u001d\u0010¤\u0003\u001a\u00020\nX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¥\u0003\u0010)\"\u0005\b¦\u0003\u0010+R\u001d\u0010§\u0003\u001a\u00020\u0012X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¨\u0003\u0010\u0014\"\u0005\b©\u0003\u0010\u0016R\u001d\u0010ª\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b«\u0003\u0010\u0006\"\u0005\b¬\u0003\u0010&R/\u0010­\u0003\u001a\u0014\u0012\u0005\u0012\u00030®\u000300j\t\u0012\u0005\u0012\u00030®\u0003`1X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¯\u0003\u00103\"\u0005\b°\u0003\u00105R\u001d\u0010±\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b²\u0003\u0010\u0006\"\u0005\b³\u0003\u0010&R/\u0010´\u0003\u001a\u0014\u0012\u0005\u0012\u00030®\u000300j\t\u0012\u0005\u0012\u00030®\u0003`1X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bµ\u0003\u00103\"\u0005\b¶\u0003\u00105R\"\u0010·\u0003\u001a\u0005\u0018\u00010®\u0003X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¸\u0003\u0010¹\u0003\"\u0006\bº\u0003\u0010»\u0003R7\u0010¼\u0003\u001a&\u0012\f\u0012\n <*\u0004\u0018\u00010\n0\n <*\u0012\u0012\f\u0012\n <*\u0004\u0018\u00010\n0\n\u0018\u00010=0:¢\u0006\t\n\u0000\u001a\u0005\b½\u0003\u0010?R\u001d\u0010¾\u0003\u001a\u00020\u001eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¿\u0003\u0010 \"\u0005\bÀ\u0003\u0010\"R&\u0010Á\u0003\u001a\u000b\u0012\u0005\u0012\u00030Â\u0003\u0018\u00010TX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÃ\u0003\u0010W\"\u0005\bÄ\u0003\u0010YR/\u0010Æ\u0003\u001a\u0005\u0018\u00010Å\u00032\t\u0010E\u001a\u0005\u0018\u00010Å\u0003@FX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÇ\u0003\u0010È\u0003\"\u0006\bÉ\u0003\u0010Ê\u0003R/\u0010Ë\u0003\u001a\u0005\u0018\u00010Â\u00032\t\u0010E\u001a\u0005\u0018\u00010Â\u0003@FX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÌ\u0003\u0010Í\u0003\"\u0006\bÎ\u0003\u0010Ï\u0003R/\u0010Ð\u0003\u001a\u0014\u0012\u0005\u0012\u00030Õ\u000100j\t\u0012\u0005\u0012\u00030Õ\u0001`1X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÑ\u0003\u00103\"\u0005\bÒ\u0003\u00105R\u001d\u0010Ó\u0003\u001a\u00020\nX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÔ\u0003\u0010)\"\u0005\bÕ\u0003\u0010+R\u001d\u0010Ö\u0003\u001a\u00020\u001eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b×\u0003\u0010 \"\u0005\bØ\u0003\u0010\"R\u001d\u0010Ù\u0003\u001a\u00020\u001eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÚ\u0003\u0010 \"\u0005\bÛ\u0003\u0010\"R\u001d\u0010Ü\u0003\u001a\u00020\nX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÝ\u0003\u0010)\"\u0005\bÞ\u0003\u0010+R\u001d\u0010ß\u0003\u001a\u00020\u0012X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bà\u0003\u0010\u0014\"\u0005\bá\u0003\u0010\u0016R\u001d\u0010â\u0003\u001a\u00020\u001eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bã\u0003\u0010 \"\u0005\bä\u0003\u0010\"R\u001d\u0010å\u0003\u001a\u00020\u001eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bæ\u0003\u0010 \"\u0005\bç\u0003\u0010\"R\u001d\u0010è\u0003\u001a\u00020\u001eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bé\u0003\u0010 \"\u0005\bê\u0003\u0010\"R\u001d\u0010ë\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bì\u0003\u0010\u0006\"\u0005\bí\u0003\u0010&R\u001f\u0010î\u0003\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bï\u0003\u0010)\"\u0005\bð\u0003\u0010+R\u001f\u0010ñ\u0003\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bò\u0003\u0010)\"\u0005\bó\u0003\u0010+R\u001d\u0010ô\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bõ\u0003\u0010\u0006\"\u0005\bö\u0003\u0010&R&\u0010÷\u0003\u001a\u000b\u0012\u0005\u0012\u00030\u0002\u0018\u00010TX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bø\u0003\u0010W\"\u0005\bù\u0003\u0010YR,\u0010ú\u0003\u001a\u000f\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00120\u0002X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bû\u0003\u0010\u0002\"\u0006\bü\u0003\u0010\u0002RA\u0010ý\u0003\u001a&\u0012\f\u0012\n <*\u0004\u0018\u00010P0P <*\u0012\u0012\f\u0012\n <*\u0004\u0018\u00010P0P\u0018\u00010=0:X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bþ\u0003\u0010?\"\u0005\bÿ\u0003\u0010AR\u001d\u0010\u0004\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0004\u0010\u0006\"\u0005\b\u0004\u0010&R\u001d\u0010\u0004\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0004\u0010\u0006\"\u0005\b\u0004\u0010&R\u001d\u0010\u0004\u001a\u00020\u001eX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0004\u0010 \"\u0005\b\u0004\u0010\"R\u001d\u0010\u0004\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0004\u0010\u0006\"\u0005\b\u0004\u0010&R\u001d\u0010\u0004\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0004\u0010\u0006\"\u0005\b\u0004\u0010&R&\u0010\u0004\u001a\u000b\u0012\u0005\u0012\u00030\u0002\u0018\u00010:X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0004\u0010?\"\u0005\b\u0004\u0010AR\u001d\u0010\u0004\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0004\u0010\u0006\"\u0005\b\u0004\u0010&R-\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\n00j\b\u0012\u0004\u0012\u00020\n`1X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0004\u00103\"\u0005\b\u0004\u00105R-\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\n00j\b\u0012\u0004\u0012\u00020\n`1X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0004\u00103\"\u0005\b\u0004\u00105R\u001f\u0010\u0004\u001a\u00020UX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0004\u0010\u0004\"\u0006\b\u0004\u0010\u0004R&\u0010 \u0004\u001a\u000b\u0012\u0005\u0012\u00030\u0002\u0018\u00010=X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¡\u0004\u0010?\"\u0005\b¢\u0004\u0010A¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "", "()V", "DROP_LIST_SIZE", "", "getDROP_LIST_SIZE", "()I", "MAX_LOTTERY_ID_LIST", "getMAX_LOTTERY_ID_LIST", "TAG", "", "acceptLinkUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLinkMicUser;", "getAcceptLinkUser", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLinkMicUser;", "setAcceptLinkUser", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLinkMicUser;)V", "acceptSeq", "", "getAcceptSeq", "()J", "setAcceptSeq", "(J)V", "alertInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsgBoxInfo;", "getAlertInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveMsgBoxInfo;", "setAlertInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveMsgBoxInfo;)V", "anchorInitProduct", "", "getAnchorInitProduct", "()Z", "setAnchorInitProduct", "(Z)V", "anchorStatusFlag", "getAnchorStatusFlag", "setAnchorStatusFlag", "(I)V", "anchorUsername", "getAnchorUsername", "()Ljava/lang/String;", "setAnchorUsername", "(Ljava/lang/String;)V", "applyInviteUsername", "getApplyInviteUsername", "setApplyInviteUsername", "applyLinkList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getApplyLinkList", "()Ljava/util/ArrayList;", "setApplyLinkList", "(Ljava/util/ArrayList;)V", "applySessionId", "getApplySessionId", "setApplySessionId", "audienceLinkMicUserList", "", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType", "", "getAudienceLinkMicUserList", "()Ljava/util/List;", "setAudienceLinkMicUserList", "(Ljava/util/List;)V", "audienceMicOverFlow", "getAudienceMicOverFlow", "setAudienceMicOverFlow", "value", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBadgeInfo;", "badgeInfo", "getBadgeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveBadgeInfo;", "setBadgeInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveBadgeInfo;)V", "bindShop", "getBindShop", "setBindShop", "bulletCommetList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "getBulletCommetList", "setBulletCommetList", "cacheVisitorRoleList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;", "getCacheVisitorRoleList", "()Ljava/util/LinkedList;", "setCacheVisitorRoleList", "(Ljava/util/LinkedList;)V", "cacheVisitorRoleModifyTime", "getCacheVisitorRoleModifyTime", "setCacheVisitorRoleModifyTime", "cacheVisitorRoleType", "getCacheVisitorRoleType", "setCacheVisitorRoleType", "cheerIconInfos", "Lcom/tencent/mm/protocal/protobuf/CheerIconInfo;", "getCheerIconInfos", "commentReachLastOnViewDettach", "getCommentReachLastOnViewDettach", "setCommentReachLastOnViewDettach", "commentReadCount", "getCommentReadCount", "setCommentReadCount", "commentSize", "getCommentSize", "setCommentSize", "contentRect", "Landroid/graphics/Rect;", "getContentRect", "()Landroid/graphics/Rect;", "setContentRect", "(Landroid/graphics/Rect;)V", "curAppId", "getCurAppId", "setCurAppId", "curApplyPkAnchor", "Lcom/tencent/mm/plugin/finder/live/viewmodel/ApplyPkAnchorInfo;", "getCurApplyPkAnchor", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/ApplyPkAnchorInfo;", "setCurApplyPkAnchor", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/ApplyPkAnchorInfo;)V", "curBalance", "getCurBalance", "setCurBalance", "curLinkMicUser", "getCurLinkMicUser", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "setCurLinkMicUser", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;)V", "curVisiableFirstPosition", "getCurVisiableFirstPosition", "setCurVisiableFirstPosition", "curVisiableLastPosition", "getCurVisiableLastPosition", "setCurVisiableLastPosition", "curlLikeCount", "getCurlLikeCount", "setCurlLikeCount", "desc", "getDesc", "setDesc", "disableCommentCacheMap", "Ljava/util/HashMap;", "getDisableCommentCacheMap", "()Ljava/util/HashMap;", "setDisableCommentCacheMap", "(Ljava/util/HashMap;)V", "enableCommentSvr", "getEnableCommentSvr", "()Ljava/lang/Boolean;", "setEnableCommentSvr", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "enableCustomerComment", "getEnableCustomerComment", "setEnableCustomerComment", "enableGift", "getEnableGift", "setEnableGift", "enableGiftAntispam", "getEnableGiftAntispam", "setEnableGiftAntispam", "enableGiftFlag", "getEnableGiftFlag", "setEnableGiftFlag", "enableGiftSwitch", "getEnableGiftSwitch", "setEnableGiftSwitch", "enableLinkMic", "getEnableLinkMic", "setEnableLinkMic", "enableLinkMicAntispam", "getEnableLinkMicAntispam", "setEnableLinkMicAntispam", "enableLinkMicFlag", "getEnableLinkMicFlag", "setEnableLinkMicFlag", "enableLinkMicSwitch", "getEnableLinkMicSwitch", "setEnableLinkMicSwitch", "enableLiveRoomComment", "getEnableLiveRoomComment", "setEnableLiveRoomComment", "enableLottery", "getEnableLottery", "setEnableLottery", "enableLuckyMoney", "getEnableLuckyMoney", "setEnableLuckyMoney", "enableVisitorGiftSwitch", "getEnableVisitorGiftSwitch", "setEnableVisitorGiftSwitch", "exptBeautyEnable", "getExptBeautyEnable", "setExptBeautyEnable", "exptFilterEnable", "getExptFilterEnable", "setExptFilterEnable", "finderDescObject", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "getFinderDescObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "setFinderDescObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;)V", "firstBugProductList", "getFirstBugProductList", "setFirstBugProductList", "floatModeRemoveActivity", "getFloatModeRemoveActivity", "setFloatModeRemoveActivity", "followLinkUserList", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getFollowLinkUserList", "setFollowLinkUserList", "forceChangeOrientation", "getForceChangeOrientation", "setForceChangeOrientation", "friendFollowCount", "getFriendFollowCount", "setFriendFollowCount", "giftQueue", "Lcom/tencent/mm/plugin/finder/live/util/GiftQueueImpl;", "getGiftQueue", "()Lcom/tencent/mm/plugin/finder/live/util/GiftQueueImpl;", "setGiftQueue", "(Lcom/tencent/mm/plugin/finder/live/util/GiftQueueImpl;)V", "hasLotteryHistory", "getHasLotteryHistory", "setHasLotteryHistory", "haveMiniProInstance", "getHaveMiniProInstance", "setHaveMiniProInstance", "highLightCheerList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "getHighLightCheerList", "setHighLightCheerList", "injectEvent", "Lcom/tencent/mm/plugin/finder/live/viewmodel/EventWrapper;", "getInjectEvent", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/EventWrapper;", "setInjectEvent", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/EventWrapper;)V", "isBussinessVisitor", "setBussinessVisitor", "isLiveQosControlEnabled", "setLiveQosControlEnabled", "isLiveQosReportEnabled", "setLiveQosReportEnabled", "joinLiveTips", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveTips;", "getJoinLiveTips", "()Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveTips;", "setJoinLiveTips", "(Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveTips;)V", "lastCandidateBuffer", "", "getLastCandidateBuffer", "()[B", "setLastCandidateBuffer", "([B)V", "lastChosenTagInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "getLastChosenTagInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "setLastChosenTagInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;)V", "lastLiveCommentSeq", "Lcom/tencent/mm/algorithm/MMLRUMap;", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "getLastLiveCommentSeq", "()Lcom/tencent/mm/algorithm/MMLRUMap;", "setLastLiveCommentSeq", "(Lcom/tencent/mm/algorithm/MMLRUMap;)V", "likes", "getLikes", "setLikes", "linkApplyTimestamp", "getLinkApplyTimestamp", "setLinkApplyTimestamp", "linkInviteInfo", "Lcom/tencent/mm/plugin/finder/live/viewmodel/LinkInviteInfo;", "getLinkInviteInfo", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/LinkInviteInfo;", "setLinkInviteInfo", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/LinkInviteInfo;)V", "linkMicState", "getLinkMicState", "setLinkMicState", "linkMicStatusMap", "getLinkMicStatusMap", "linkMicUserList", "getLinkMicUserList", "setLinkMicUserList", "linkSucTimestamp", "getLinkSucTimestamp", "setLinkSucTimestamp", "liveBreakRule", "getLiveBreakRule", "setLiveBreakRule", "liveCookies", "getLiveCookies", "setLiveCookies", "liveCoverUrl", "getLiveCoverUrl", "setLiveCoverUrl", "liveExtFlag", "getLiveExtFlag", "setLiveExtFlag", "liveFinderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getLiveFinderObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setLiveFinderObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "liveFinish", "getLiveFinish", "setLiveFinish", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "liveInfo", "getLiveInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "setLiveInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;)V", "livePreState", "getLivePreState", "setLivePreState", "liveRoomModel", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "getLiveRoomModel", "()Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "setLiveRoomModel", "(Lcom/tencent/mm/live/core/core/model/LiveRoomModel;)V", "liveSdkInfo", "Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "getLiveSdkInfo", "()Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "setLiveSdkInfo", "(Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;)V", "liveState", "getLiveState", "setLiveState", "live_contacts_continue_flag", "getLive_contacts_continue_flag", "setLive_contacts_continue_flag", "live_contacts_max_display_count", "getLive_contacts_max_display_count", "setLive_contacts_max_display_count", "localLotteryInfoWrapper", "Lcom/tencent/mm/plugin/finder/live/viewmodel/LotteryInfoWrapper;", "getLocalLotteryInfoWrapper", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/LotteryInfoWrapper;", "setLocalLotteryInfoWrapper", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/LotteryInfoWrapper;)V", "localLotteryInfoWrapperList", "getLocalLotteryInfoWrapperList", "setLocalLotteryInfoWrapperList", "localSaveLotteryIdList", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lkotlin/Pair;", "getLocalSaveLotteryIdList", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "setLocalSaveLotteryIdList", "(Ljava/util/concurrent/ConcurrentLinkedDeque;)V", FirebaseAnalytics.b.LOCATION, "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", com.tencent.mm.plugin.appbrand.jsapi.i.m.NAME, "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/FinderLocation;)V", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "lotteryRecord", "getLotteryRecord", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "setLotteryRecord", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;)V", "luckyMoneyData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/LuckyMoneyLiveData;", "getLuckyMoneyData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/LuckyMoneyLiveData;", "setLuckyMoneyData", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/LuckyMoneyLiveData;)V", "luckyMoneyList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRedPacketInfo;", "getLuckyMoneyList", "setLuckyMoneyList", "luckyMoneyMsgList", "getLuckyMoneyMsgList", "setLuckyMoneyMsgList", "luckyMoneySvrConfig", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLuckyMoneySvrConfig;", "getLuckyMoneySvrConfig", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLuckyMoneySvrConfig;", "setLuckyMoneySvrConfig", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLuckyMoneySvrConfig;)V", "maxVisibleRoomCount", "getMaxVisibleRoomCount", "setMaxVisibleRoomCount", "maxVisibleUserCount", "getMaxVisibleUserCount", "setMaxVisibleUserCount", "msgList", "getMsgList", "setMsgList", "needMiniWindow", "getNeedMiniWindow", "setNeedMiniWindow", "newApplyCount", "getNewApplyCount", "setNewApplyCount", "newApplyLinkList", "getNewApplyLinkList", "setNewApplyLinkList", "newLinkMicUserList", "getNewLinkMicUserList", "setNewLinkMicUserList", "newPkApplyCount", "getNewPkApplyCount", "setNewPkApplyCount", "nonceId", "getNonceId", "setNonceId", "objectId", "getObjectId", "setObjectId", "offlineMemberCount", "getOfflineMemberCount", "setOfflineMemberCount", "offlineMemberList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "getOfflineMemberList", "setOfflineMemberList", "onlineMemberCount", "getOnlineMemberCount", "setOnlineMemberCount", "onlineMemberList", "getOnlineMemberList", "setOnlineMemberList", "onlineSelfContact", "getOnlineSelfContact", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "setOnlineSelfContact", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;)V", "pendingNotifyMicUserList", "getPendingNotifyMicUserList", "preloadMiniProgram", "getPreloadMiniProgram", "setPreloadMiniProgram", "productList", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getProductList", "setProductList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopWindowProductResponse;", "products", "getProducts", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopWindowProductResponse;", "setProducts", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopWindowProductResponse;)V", "promotingProduct", "getPromotingProduct", "()Lcom/tencent/mm/plugin/finder/model/RVFeed;", "setPromotingProduct", "(Lcom/tencent/mm/plugin/finder/model/RVFeed;)V", "rencentLinkUserList", "getRencentLinkUserList", "setRencentLinkUserList", "requestId", "getRequestId", "setRequestId", "riskControlEnableComment", "getRiskControlEnableComment", "setRiskControlEnableComment", "screenClear", "getScreenClear", "setScreenClear", "sessionBuffer", "getSessionBuffer", "setSessionBuffer", "sessionId", "getSessionId", "setSessionId", "shoppingAvailable", "getShoppingAvailable", "setShoppingAvailable", "shoppingInMiniProgram", "getShoppingInMiniProgram", "setShoppingInMiniProgram", "showStatistics", "getShowStatistics", "setShowStatistics", "sourceType", "getSourceType", "setSourceType", "statistics", "getStatistics", "setStatistics", "statusVerifyInfo", "getStatusVerifyInfo", "setStatusVerifyInfo", "supportScreenRotation", "getSupportScreenRotation", "setSupportScreenRotation", "tagInfo", "getTagInfo", "setTagInfo", "tickleUserCache", "getTickleUserCache", "setTickleUserCache", "topMsgList", "getTopMsgList", "setTopMsgList", "totalCnt", "getTotalCnt", "setTotalCnt", "uiState", "getUiState", "setUiState", "useUpdateStrategy", "getUseUpdateStrategy", "setUseUpdateStrategy", "videoHeight", "getVideoHeight", "setVideoHeight", "videoWidth", "getVideoWidth", "setVideoWidth", "visibilityChooseByteArray", "getVisibilityChooseByteArray", "setVisibilityChooseByteArray", "visibilityMode", "getVisibilityMode", "setVisibilityMode", "visibilityRoomChooseList", "getVisibilityRoomChooseList", "setVisibilityRoomChooseList", "visibilityUserChooseList", "getVisibilityUserChooseList", "setVisibilityUserChooseList", "visitorRole", "getVisitorRole", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;", "setVisitorRole", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;)V", "visitorWhiteList", "getVisitorWhiteList", "setVisitorWhiteList", "addLiveRoomCommentMsg", "", "liveRoomComment", "audienceMicLinking", "micId", "audienceMicWaiting", "audienceMode", "cancelLotteryInfo", "clearLotteryInfoList", "fitLandscapeVideo", "getAudienceLinkMicUserByMicId", "getAudienceLinkMicUserByUserId", "userId", "getLotteryIdList", "getTrtcKeyParams", "hasJoinLive", "haveParticipated", "info", "initVisitorRoleInfo", "isAnchorAliveExpired", "isLandscapeVideo", "isLinkingMicOrPk", "isLiveFinish", "isLiveIdle", "isLivePreStatusStarted", "isLivePrepare", "isLiveStarted", "isLiveStartedWait", "isLuckyMoneyEnable", "luckyMoneyConfig", "isLuckyMoneyFestival", "isLuckyMoneyNormal", "isRemoteItemValid", "remoteLotteryInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "localLotteryInfo", "linkMicWait", "linking", "lotteryIdHaveShow", "lotteryId", "lotteryIdListToString", "lotteryList", "mergeLotteryRecord", "record", "mergeProducts", "resp", "printLotteryInfoList", "prefix", "fromJoinLive", "printRedPacketInfoList", "removeAudienceLinkMicUser", "removeLotteryInfoFromList", "saveId", "removeTargetLinkUser", "finderUsername", "replaceLocalLotteryInfo", "lotteryInfoWrapper", "reset", "resetLotteryInfoToList", "liveMsgLotteryInfoList", "resetLotteryRecord", "resetProductList", "resetRedPackInfoToList", "liveMsgRedPacketInfoList", "safeAddAudienceMicUser", "micUser", "safeResetAlertInfo", "safeResetLocalLotteryInfo", "safeSetAlertInfo", "saveLastWinLotteryId", "sdkAppId", "selfSdkLiveId", "selfSdkUserId", "setupOnceExptConfig", "toString", "transLotteryInfo", "finderLiveLotteryInfo", "lastDoneLottery", "updateAnchorStatus", "updateFuncEnableAnchor", "switchFlag", "updateFuncEnableVisitor", "contactFlag", "updateJoinLiveCommentState", "enableComment", "(Ljava/lang/Integer;)V", "updateLiveMsgCommentState", "updateLocalAnchorStatus", "updateLocalLotteryInfo", "updateLocalSwitchFlag", "updateLotteryInfo", "lotteryInfo", "updateLotteryInfoList", "lotteryInfoList", "updateOnlineMemberCommentState", "updateVisitorRoleInfo", "validVideoSize", "Companion", "plugin-finder_release"})
public final class g {
    private static final com.tencent.mm.b.h<Long, Boolean> UQr = new com.tencent.mm.b.h<>(10);
    public static final a uFg = new a((byte) 0);
    public LinkedList<bo> LGy;
    public final String TAG = ("FinderLiveRoomData@" + hashCode());
    public int UKm;
    public int UKn;
    public long UPS;
    public long UPT;
    public int UPU;
    public k UPV = new k(null, null, null);
    public bo UPW;
    public List<e> UPX;
    public List<e> UPY;
    public List<e> UPZ;
    private int UQa;
    public j UQb;
    public final HashMap<String, Integer> UQc;
    public final List<String> UQd;
    public final LinkedList<ffr> UQe;
    public ArrayList<String> UQf;
    public ArrayList<String> UQg;
    public aus UQh;
    public int UQi;
    public LinkedList<aus> UQj;
    public long UQk;
    public fgv UQl;
    public m UQm;
    private List<awq> UQn;
    public List<fgy> UQo;
    public int UQp;
    public int UQq;
    public String dPI;
    public String desc;
    public int friendFollowCount;
    public long hFK;
    public byte[] hIt;
    public cjb hIv = new cjb();
    public com.tencent.mm.live.core.core.b.f hIy;
    public String hwd = "";
    public String hwg = "";
    public awe liveInfo = new awe();
    public axt location;
    private Rect rwL;
    public String sessionBuffer = "";
    public long sessionId;
    public int sourceType;
    private boolean uBc;
    public int uDA;
    public boolean uDB = true;
    public boolean uDC = true;
    public boolean uDD = true;
    public b uDE;
    public ArrayList<b> uDF = new ArrayList<>();
    public ArrayList<String> uDG = new ArrayList<>();
    private ArrayList<com.tencent.mm.plugin.finder.api.g> uDH = new ArrayList<>();
    private ArrayList<com.tencent.mm.plugin.finder.api.g> uDI = new ArrayList<>();
    public String uDJ = "";
    public int uDK;
    private int uDL;
    public byte[] uDM;
    public volatile boolean uDN;
    public h uDO;
    public boolean uDQ;
    public boolean uDR;
    public boolean uDS = true;
    public boolean uDT;
    public int uDU = -1;
    public int uDV;
    public long uDW;
    public HashMap<String, Boolean> uDX = new HashMap<>();
    public awr uDY;
    public LinkedList<i> uDZ = new LinkedList<>();
    public FinderObjectDesc uDm;
    public ArrayList<avn> uDn = new ArrayList<>();
    public avn uDo;
    public ArrayList<avn> uDp = new ArrayList<>();
    public int uDq;
    public int uDr;
    public List<t> uDs = Collections.synchronizedList(new ArrayList());
    public List<awq> uDt = Collections.synchronizedList(new ArrayList());
    public List<awq> uDu = Collections.synchronizedList(new ArrayList());
    public List<aut> uDv = Collections.synchronizedList(new ArrayList());
    public com.tencent.mm.plugin.finder.live.util.n uDw = new com.tencent.mm.plugin.finder.live.util.n();
    public avi uDx;
    public aug uDy;
    public FinderObject uDz;
    public e uEB;
    public int uEC;
    private int uED;
    public int uEE;
    private boolean uEF;
    public boolean uEG;
    public boolean uEH;
    public int uEI;
    public boolean uEJ;
    public boolean uEK;
    public boolean uEL;
    public long uEM;
    public boolean uEN;
    public int uEO;
    public int uEP;
    public boolean uEQ;
    public long uER;
    public Boolean uES;
    public boolean uET;
    public boolean uEU;
    public boolean uEV;
    public boolean uEW;
    public com.tencent.mm.b.h<Long, t> uEX;
    public List<byte[]> uEY;
    public List<byte[]> uEZ;
    public i uEa;
    private ConcurrentLinkedDeque<o<Long, String>> uEb = new ConcurrentLinkedDeque<>();
    public avy uEc;
    public boolean uEd;
    public boolean uEe;
    public int uEf;
    public int uEg;
    public boolean uEj;
    public boolean uEk;
    public awc uEl;
    public ArrayList<Long> uEn = new ArrayList<>();
    public boolean uEo;
    public boolean uEp;
    public String uEq = "";
    public boolean uEr;
    public String uEs;
    public int uEt;
    public String uEu;
    public boolean uEv;
    public com.tencent.mm.b.h<String, Long> uEw;
    public long uEx;
    public String uEy;
    public int uFa;
    public boolean uFb;
    public String uFc;
    public boolean uFd;
    private final int uFe;
    private final int uFf;
    public boolean uit;
    public LinkedList<axk> uiw;
    public axk uix;
    public int videoHeight;
    public int videoWidth;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ g uFh;
        final /* synthetic */ boolean uFj;
        final /* synthetic */ String uFk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(g gVar, boolean z, String str) {
            super(0);
            this.uFh = gVar;
            this.uFj = z;
            this.uFk = str;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "item", "Lcom/tencent/mm/plugin/finder/live/viewmodel/LotteryInfoWrapper;", "invoke"})
        static final class a extends q implements kotlin.g.a.b<i, Boolean> {
            final /* synthetic */ e uFl;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(e eVar) {
                super(1);
                this.uFl = eVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ Boolean invoke(i iVar) {
                String str;
                AppMethodBeat.i(247951);
                i iVar2 = iVar;
                p.h(iVar2, "item");
                awi awi = iVar2.tWe;
                if (awi != null) {
                    str = awi.id;
                } else {
                    str = null;
                }
                Boolean valueOf = Boolean.valueOf(p.j(str, this.uFl.uFk));
                AppMethodBeat.o(247951);
                return valueOf;
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(247952);
            if (this.uFj) {
                this.uFh.atY(this.uFk);
            }
            Log.i(this.uFh.TAG, "removeLotteryInfoFromList localLotteryInfo:" + this.uFh.uEa + " remove:" + com.tencent.mm.ac.d.a((LinkedList) this.uFh.uDZ, (kotlin.g.a.b) new a(this)) + ",saveId:" + this.uFj + '!');
            g.a(this.uFh, "remove");
            x xVar = x.SXb;
            AppMethodBeat.o(247952);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType", "invoke"})
    public static final class m extends q implements kotlin.g.a.b<e, Boolean> {
        final /* synthetic */ String UQs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(String str) {
            super(1);
            this.UQs = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(e eVar) {
            AppMethodBeat.i(261054);
            Boolean valueOf = Boolean.valueOf(Util.isEqual(eVar.sessionId, this.UQs));
            AppMethodBeat.o(261054);
            return valueOf;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x024d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public g() {
        /*
        // Method dump skipped, instructions count: 595
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.viewmodel.g.<init>():void");
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData$Companion;", "", "()V", "LIVE_STATE_DEFAULT", "", "LIVE_STATE_FINISHED", "LIVE_STATE_PREPARE", "LIVE_STATE_STARTED", "LIVE_STATE_STARTED_WAIT", "SUPPORT_SCREEN_ROTATION", "UI_STATE_ANCHOR_EXIT", "UI_STATE_ANCHOR_POST", "UI_STATE_CAMERA_OPT", "UI_STATE_COMMENT", "UI_STATE_DEFAULT", "UI_STATE_DISCONNECTION", "UI_STATE_DISPLAY_LINK_APPLY_LISENCE", "UI_STATE_DISPLAY_LINK_APPLY_LIST", "UI_STATE_EXPLAIN_WECOIN_HOT", "UI_STATE_GIFT", "UI_STATE_KICKED", "UI_STATE_MEMBER_LIST", "UI_STATE_MINI_WINDOW_PERMISSION", "UI_STATE_MORE_ACTION", "UI_STATE_NORMAL", "UI_STATE_PRIVATE_PERMISSION", "UI_STATE_REAL_NAME_COMMENT", "UI_STATE_RECONNECTING", "UI_STATE_SHOPPING_PANEL", "watchOneMinCache", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "", "getWatchOneMinCache", "()Lcom/tencent/mm/algorithm/MMLRUMap;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(248005);
        AppMethodBeat.o(248005);
    }

    public final void a(cjb cjb) {
        AppMethodBeat.i(247957);
        p.h(cjb, "<set-?>");
        this.hIv = cjb;
        AppMethodBeat.o(247957);
    }

    public final void setLiveInfo(awe awe) {
        AppMethodBeat.i(247958);
        p.h(awe, "value");
        Log.i(this.TAG, "write liveInfo to:[liveId:" + awe.liveId + ", liveStatus:" + awe.liveStatus + ']');
        this.liveInfo = awe;
        AppMethodBeat.o(247958);
    }

    public final void a(avi avi) {
        Object obj;
        AppMethodBeat.i(247959);
        String str = this.TAG;
        StringBuilder sb = new StringBuilder("set badgeInfo:");
        if (avi == null) {
            obj = "";
        } else {
            obj = avi;
        }
        Log.i(str, sb.append(com.tencent.mm.ac.g.bN(obj)).toString());
        this.uDx = avi;
        AppMethodBeat.o(247959);
    }

    public final void atT(String str) {
        AppMethodBeat.i(247960);
        p.h(str, "<set-?>");
        this.hwd = str;
        AppMethodBeat.o(247960);
    }

    public final void atS(String str) {
        AppMethodBeat.i(247961);
        p.h(str, "<set-?>");
        this.hwg = str;
        AppMethodBeat.o(247961);
    }

    public final void setSessionBuffer(String str) {
        AppMethodBeat.i(261056);
        p.h(str, "<set-?>");
        this.sessionBuffer = str;
        AppMethodBeat.o(261056);
    }

    public final void nB(boolean z) {
        AppMethodBeat.i(247962);
        String str = this.TAG;
        StringBuilder append = new StringBuilder("liveFinish:").append(this.uDN).append(",value:").append(z).append(",liveId:");
        awe awe = this.liveInfo;
        Log.i(str, append.append((awe != null ? Long.valueOf(awe.liveId) : null).longValue()).toString());
        this.uDN = z;
        AppMethodBeat.o(247962);
    }

    public final void c(avy avy) {
        AppMethodBeat.i(247963);
        String str = this.TAG;
        StringBuilder sb = new StringBuilder("lotteryRecord:");
        Object obj = this.uEc;
        if (obj == null) {
            obj = "";
        }
        Log.i(str, sb.append(com.tencent.mm.ac.g.bN(obj)).toString());
        this.uEc = avy;
        AppMethodBeat.o(247963);
    }

    public final void a(k kVar) {
        AppMethodBeat.i(261057);
        p.h(kVar, "<set-?>");
        this.UPV = kVar;
        AppMethodBeat.o(261057);
    }

    public final void FA(boolean z) {
        AppMethodBeat.i(261058);
        Log.i(this.TAG, "bindShop:".concat(String.valueOf(z)));
        this.uit = z;
        AppMethodBeat.o(261058);
    }

    private void a(awc awc) {
        Object obj;
        AppMethodBeat.i(247964);
        String str = this.TAG;
        StringBuilder sb = new StringBuilder("FinderLiveGetShopWindowProductResponse:");
        if (awc == null) {
            obj = "";
        } else {
            obj = awc;
        }
        Log.i(str, sb.append(com.tencent.mm.ac.g.bN(obj)).toString());
        this.uEl = awc;
        AppMethodBeat.o(247964);
    }

    public final void f(bo boVar) {
        boolean z = true;
        AppMethodBeat.i(261059);
        if (boVar instanceof com.tencent.mm.plugin.finder.live.view.a.c) {
            Log.i(this.TAG, "FinderLiveShopWindowProductItem:" + com.tencent.mm.ac.g.bN(boVar));
            this.uEk = (((com.tencent.mm.plugin.finder.live.view.a.c) boVar).LHK == 1) | this.uEk;
            this.UPW = boVar;
            AppMethodBeat.o(261059);
        } else if (boVar instanceof com.tencent.mm.plugin.finder.live.view.a.b) {
            Log.i(this.TAG, "FinderLiveShopWindowProductItem:" + com.tencent.mm.ac.g.bN(boVar));
            boolean z2 = this.uEk;
            if (((com.tencent.mm.plugin.finder.live.view.a.b) boVar).LHK != 1) {
                z = false;
            }
            this.uEk = z2 | z;
            this.UPW = boVar;
            AppMethodBeat.o(261059);
        } else {
            String str = this.TAG;
            StringBuilder sb = new StringBuilder("FinderLiveShopWindowProductItem: invalid or null, ");
            Object obj = boVar;
            if (boVar == null) {
                obj = "";
            }
            Log.i(str, sb.append(com.tencent.mm.ac.g.bN(obj)).toString());
            this.uEk |= false;
            this.UPW = null;
            AppMethodBeat.o(261059);
        }
    }

    public final void atU(String str) {
        AppMethodBeat.i(247966);
        p.h(str, "<set-?>");
        this.uEq = str;
        AppMethodBeat.o(247966);
    }

    public final void bxN(String str) {
        AppMethodBeat.i(261060);
        p.h(str, "<set-?>");
        this.uEu = str;
        AppMethodBeat.o(261060);
    }

    public final void bxO(String str) {
        AppMethodBeat.i(261061);
        p.h(str, "<set-?>");
        this.uEy = str;
        AppMethodBeat.o(261061);
    }

    public final int hTU() {
        ArrayList arrayList;
        boolean z;
        AppMethodBeat.i(261062);
        List<e> list = this.UPY;
        p.g(list, "newLinkMicUserList");
        List<e> list2 = list;
        synchronized (list2) {
            try {
                ArrayList arrayList2 = new ArrayList();
                for (T t : list2) {
                    if (!t.UPN) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        arrayList2.add(t);
                    }
                }
                arrayList = arrayList2;
            } catch (Throwable th) {
                AppMethodBeat.o(261062);
                throw th;
            }
        }
        int size = arrayList.size();
        AppMethodBeat.o(261062);
        return size;
    }

    public final int hTV() {
        ArrayList arrayList;
        AppMethodBeat.i(261063);
        List<e> list = this.UPY;
        p.g(list, "newLinkMicUserList");
        List<e> list2 = list;
        synchronized (list2) {
            try {
                ArrayList arrayList2 = new ArrayList();
                for (T t : list2) {
                    if (t.UPN) {
                        arrayList2.add(t);
                    }
                }
                arrayList = arrayList2;
            } catch (Throwable th) {
                AppMethodBeat.o(261063);
                throw th;
            }
        }
        int size = arrayList.size();
        AppMethodBeat.o(261063);
        return size;
    }

    public final boolean diZ() {
        return this.uEE == 1;
    }

    public final boolean hTW() {
        AppMethodBeat.i(261064);
        if (this.UPZ.size() >= 3) {
            AppMethodBeat.o(261064);
            return true;
        }
        AppMethodBeat.o(261064);
        return false;
    }

    public final boolean dja() {
        return this.uEI == 1;
    }

    private void djb() {
        AppMethodBeat.i(247967);
        Log.i(this.TAG, "set enableGift:false");
        this.uBc = false;
        AppMethodBeat.o(247967);
    }

    private void nC(boolean z) {
        AppMethodBeat.i(247968);
        Log.i(this.TAG, "set enableVisitorGiftSwitch:".concat(String.valueOf(z)));
        this.uEK = z;
        AppMethodBeat.o(247968);
    }

    public final void EN(long j2) {
        AppMethodBeat.i(247969);
        Log.i(this.TAG, "set curBalance:".concat(String.valueOf(j2)));
        this.uEM = j2;
        AppMethodBeat.o(247969);
    }

    public final void atV(String str) {
        AppMethodBeat.i(247970);
        p.h(str, "<set-?>");
        this.dPI = str;
        AppMethodBeat.o(247970);
    }

    public final void nD(boolean z) {
        AppMethodBeat.i(247971);
        Log.i(this.TAG, "set isBussinessVisitor:" + z + ",ori value:" + this.uFb);
        this.uFb = z;
        AppMethodBeat.o(247971);
    }

    public final boolean hTX() {
        AppMethodBeat.i(261065);
        LinkedList<String> linkedList = this.UQm.Mpi;
        if (!(linkedList == null || linkedList.isEmpty())) {
            AppMethodBeat.o(261065);
            return true;
        }
        AppMethodBeat.o(261065);
        return false;
    }

    public final String info() {
        AppMethodBeat.i(247972);
        String str = "liveId:" + this.liveInfo.liveId + ",objectId:" + this.hFK + ", " + com.tencent.mm.ac.d.zs(this.hFK) + ",uiState:" + this.uEf + ",liveState:" + this.uEg + ",bindShop:" + this.uit + ",shoppingAvailable:" + this.uEk + ",qosReport:" + this.uET + ",qosContrl:" + this.uEU + ",curRoleType:" + this.UQh.LFy;
        AppMethodBeat.o(247972);
        return str;
    }

    public final void reset() {
        AppMethodBeat.i(247973);
        Log.i(this.TAG, "reset");
        this.hFK = 0;
        setLiveInfo(new awe());
        this.hIv = new cjb();
        this.hIt = null;
        this.hIy = null;
        this.uDm = null;
        this.uDn.clear();
        this.uDo = null;
        this.uDp.clear();
        this.uDq = 0;
        this.uDr = 0;
        a((avi) null);
        this.uDs.clear();
        this.uDt.clear();
        this.uDw.clear();
        this.uDu.clear();
        this.uDy = null;
        this.uDE = null;
        this.uDF.clear();
        this.uDG.clear();
        this.uDz = null;
        this.hwg = "";
        this.sessionBuffer = "";
        this.hwd = "";
        this.uDA = 0;
        this.uDB = true;
        this.uDC = true;
        this.uDD = true;
        this.uDL = 0;
        this.uDM = null;
        this.uDK = 0;
        nB(false);
        this.uDO = null;
        this.uDH.clear();
        this.uDI.clear();
        this.uDJ = "";
        this.UPS = 0;
        this.uDQ = false;
        this.uDR = false;
        this.uDS = true;
        this.uDT = false;
        this.uDU = -1;
        this.uDV = 0;
        this.friendFollowCount = 0;
        this.desc = null;
        this.uDX.clear();
        dje();
        djf();
        djg();
        this.uEb = new ConcurrentLinkedDeque<>();
        this.uEe = false;
        c(null);
        this.uEd = false;
        this.uEf = 0;
        this.uEg = 0;
        this.UPU = 0;
        this.UPV = new k(null, null, null);
        FA(false);
        this.uEj = false;
        this.uEk = false;
        a((awc) null);
        f((bo) null);
        this.uEn.clear();
        this.uEo = false;
        this.uEp = false;
        this.uEq = "";
        this.sessionId = 0;
        this.uEs = null;
        this.uEt = 0;
        this.videoWidth = 0;
        this.videoHeight = 0;
        this.uDW = 0;
        this.uEu = "";
        this.uEv = false;
        this.UPX.clear();
        this.UPY.clear();
        this.uEB = null;
        this.uEC = 0;
        this.uED = 0;
        this.uEE = -1;
        this.uEF = false;
        this.uEG = false;
        this.uEH = true;
        this.uEy = "";
        this.uEx = 0;
        this.UQa = 0;
        this.UQc.clear();
        this.UQb = null;
        this.UQd.clear();
        this.uEI = -1;
        djb();
        this.uEJ = false;
        nC(false);
        this.uEL = true;
        EN(0);
        this.uEN = false;
        this.uEQ = true;
        this.uER = 0;
        this.uES = null;
        this.uET = false;
        this.uEU = false;
        this.dPI = "";
        this.uEV = true;
        this.uEW = true;
        this.uiw = null;
        this.uix = null;
        this.uEY = null;
        this.uFa = 0;
        this.uEZ = null;
        nD(false);
        this.UQf.clear();
        this.UQh = new aus();
        this.UQj.clear();
        this.UQi = 4;
        this.UQk = Long.MIN_VALUE;
        this.uFd = false;
        this.uFc = null;
        this.UQl = new fgv();
        this.UQn.clear();
        this.UQo.clear();
        this.UQm = new m();
        this.UKm = 0;
        this.UKn = 0;
        this.uEX.clear();
        this.uEw.clear();
        this.location = null;
        this.UQp = 0;
        this.UQq = 0;
        this.rwL.set(0, 0, au.az(MMApplicationContext.getContext()).x, au.az(MMApplicationContext.getContext()).y);
        AppMethodBeat.o(247973);
    }

    public final void EO(long j2) {
        AppMethodBeat.i(247974);
        this.uEG = com.tencent.mm.ac.d.cW((int) j2, 4);
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        this.uEJ = com.tencent.mm.plugin.finder.utils.m.Gd(j2);
        AppMethodBeat.o(247974);
    }

    public final void RK(long j2) {
        AppMethodBeat.i(261066);
        this.uEG = com.tencent.mm.ac.d.cW((int) j2, 2);
        nC(com.tencent.mm.ac.d.cW((int) j2, 8));
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        this.uEJ = com.tencent.mm.plugin.finder.utils.m.RM(j2);
        AppMethodBeat.o(261066);
    }

    public static void EP(long j2) {
        AppMethodBeat.i(247975);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_FINDER_LIVE_ANCHOR_STATUS_FLAG_LONG_SYNC, Long.valueOf(j2));
        AppMethodBeat.o(247975);
    }

    public static void EQ(long j2) {
        AppMethodBeat.i(247976);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_FINDER_LIVE_SWITCH_FLAG_LONG_SYNC, Long.valueOf(j2));
        AppMethodBeat.o(247976);
    }

    public final int djc() {
        com.tencent.mm.live.core.core.b.e eVar;
        AppMethodBeat.i(247977);
        com.tencent.mm.live.core.core.b.f fVar = this.hIy;
        if (fVar == null || (eVar = fVar.hwP) == null) {
            e.a aVar = e.a.hxc;
            int aCf = e.a.aCf();
            AppMethodBeat.o(247977);
            return aCf;
        }
        int i2 = eVar.hzl;
        AppMethodBeat.o(247977);
        return i2;
    }

    public final b atW(String str) {
        T t;
        AppMethodBeat.i(247978);
        p.h(str, "finderUsername");
        Iterator<T> it = this.uDF.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            if (Util.isEqual(next.finderUsername, str)) {
                t = next;
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            ArrayList<String> arrayList = this.uDG;
            String str2 = t2.uCo;
            if (arrayList == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                AppMethodBeat.o(247978);
                throw tVar;
            }
            af.eV(arrayList).remove(str2);
            this.uDF.remove(t2);
            AppMethodBeat.o(247978);
            return t2;
        }
        AppMethodBeat.o(247978);
        return null;
    }

    public final void RL(long j2) {
        int i2;
        int i3 = 1;
        AppMethodBeat.i(261067);
        boolean z = !com.tencent.mm.ac.d.cW((int) j2, 8);
        if (z != this.uDD) {
            FB(z);
        }
        this.uDD = z;
        this.uES = Boolean.valueOf(z);
        this.uDQ = com.tencent.mm.ac.d.cW((int) j2, 32);
        boolean cW = com.tencent.mm.ac.d.cW((int) j2, 16);
        this.uEk |= cW;
        if (!this.uEG || !this.uEH) {
            this.uEE = 0;
        } else {
            boolean cW2 = com.tencent.mm.ac.d.cW((int) j2, 64);
            if (!(cW2 == (this.uEE == 1) || this.uEE == -1)) {
                com.tencent.mm.plugin.finder.live.model.i iVar = com.tencent.mm.plugin.finder.live.model.i.uja;
                com.tencent.mm.plugin.finder.live.model.i.d(this);
            }
            if (cW2) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            this.uEE = i2;
        }
        if (!this.uEJ || !this.uEL) {
            this.uEI = 0;
        } else {
            boolean cW3 = com.tencent.mm.ac.d.cW((int) j2, 128);
            if (!(cW3 == dja() || this.uEI == -1)) {
                com.tencent.mm.plugin.finder.live.model.i iVar2 = com.tencent.mm.plugin.finder.live.model.i.uja;
                com.tencent.mm.plugin.finder.live.model.i.e(this);
            }
            if (!cW3) {
                i3 = 0;
            }
            this.uEI = i3;
        }
        this.uDA = (int) j2;
        Log.i(this.TAG, "updateLiveMsg anchorStatusFlag:" + j2 + ",enableLiveRoomComment:" + this.uDD + ",liveBreakRule:" + this.uDQ + ",shoppingAvailableStatus:" + cW + ", shoppingAvailable:" + this.uEk + ", enableLinkMic:" + diZ() + ", enableGift:" + dja());
        AppMethodBeat.o(261067);
    }

    private void FB(boolean z) {
        String string;
        AppMethodBeat.i(261068);
        if (z) {
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            string = context.getResources().getString(R.string.crh);
        } else {
            Context context2 = MMApplicationContext.getContext();
            p.g(context2, "MMApplicationContext.getContext()");
            string = context2.getResources().getString(R.string.crg);
        }
        p.g(string, "if (liveRoomComment) MMA…e_comment_anchor_disable)");
        awq awq = new awq();
        avn avn = new avn();
        FinderContact finderContact = new FinderContact();
        finderContact.username = "";
        finderContact.nickname = "";
        finderContact.headUrl = "";
        avn.contact = finderContact;
        awq.LHp = avn;
        awq.content = string;
        o.c cVar = o.c.hGH;
        awq.type = o.c.aFq();
        this.uDs.add(new r(awq));
        AppMethodBeat.o(261068);
    }

    public final void aq(LinkedList<awq> linkedList) {
        int i2;
        AppMethodBeat.i(247979);
        p.h(linkedList, "msgList");
        int i3 = 0;
        for (T t : linkedList) {
            int i4 = t.type;
            o.c cVar = o.c.hGH;
            if (i4 == o.c.aFs()) {
                int i5 = t.type;
                this.uDC = true;
                i3 = i5;
            } else {
                o.c cVar2 = o.c.hGH;
                if (i4 == o.c.aFr()) {
                    i2 = t.type;
                    this.uDC = false;
                } else {
                    i2 = i3;
                }
                i3 = i2;
            }
        }
        o.c cVar3 = o.c.hGH;
        if (i3 == o.c.aFr()) {
            com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
            com.tencent.mm.plugin.finder.report.live.m.dpo();
        }
        Log.i(this.TAG, "updateLiveMsg commentType:".concat(String.valueOf(i3)));
        AppMethodBeat.o(247979);
    }

    public final void d(avy avy) {
        AppMethodBeat.i(247980);
        com.tencent.mm.ac.d.h(new d(this, avy));
        AppMethodBeat.o(247980);
    }

    public final void b(awc awc) {
        int i2;
        Integer num;
        boolean z;
        Integer num2;
        boolean z2;
        LinkedList<bo> linkedList;
        AppMethodBeat.i(247981);
        if (awc != null) {
            if (this.LGy == null) {
                this.LGy = new LinkedList<>();
            }
            if (this.uEl == null) {
                a(awc);
                LinkedList<fhe> linkedList2 = awc.Lhs;
                p.g(linkedList2, "resp.item_list");
                for (T t : linkedList2) {
                    com.tencent.mm.plugin.finder.live.view.a.a aVar = com.tencent.mm.plugin.finder.live.view.a.a.UPD;
                    p.g(t, "remote");
                    bo a2 = com.tencent.mm.plugin.finder.live.view.a.a.a((fhe) t);
                    if (!(a2 == null || (linkedList = this.LGy) == null)) {
                        linkedList.add(a2);
                    }
                }
                LinkedList<bo> linkedList3 = this.LGy;
                if (linkedList3 == null || linkedList3.isEmpty()) {
                    Log.i(this.TAG, "item_list is Empty, resp.productList size:" + awc.LGy.size());
                    LinkedList<axg> linkedList4 = awc.LGy;
                    p.g(linkedList4, "resp.productList");
                    for (T t2 : linkedList4) {
                        com.tencent.mm.plugin.finder.live.view.a.a aVar2 = com.tencent.mm.plugin.finder.live.view.a.a.UPD;
                        p.g(t2, "remote");
                        com.tencent.mm.plugin.finder.live.view.a.c b2 = com.tencent.mm.plugin.finder.live.view.a.a.b(t2);
                        LinkedList<bo> linkedList5 = this.LGy;
                        if (linkedList5 != null) {
                            linkedList5.add(b2);
                        }
                    }
                }
                String str = this.TAG;
                StringBuilder sb = new StringBuilder("first merge, size:");
                LinkedList<bo> linkedList6 = this.LGy;
                Log.i(str, sb.append(linkedList6 != null ? Integer.valueOf(linkedList6.size()) : null).toString());
                AppMethodBeat.o(247981);
                return;
            }
            awc awc2 = this.uEl;
            if (awc2 != null) {
                awc2.continueFlag = awc.continueFlag;
                awc2.tVM = awc.tVM;
                awc2.LGC = awc.LGC;
                awc2.LGA = awc.LGA;
                awc2.LGz = awc.LGz;
                awc2.LGD = awc.LGD;
                awc2.LGB = awc.LGB;
                awc2.ukr = awc.ukr;
                awc2.vtD = awc.vtD;
                awc2.LGH = awc.LGH;
                awc2.LGI = awc.LGI;
                LinkedList linkedList7 = new LinkedList();
                if (!awc.Lhs.isEmpty()) {
                    LinkedList<fhe> linkedList8 = awc.Lhs;
                    p.g(linkedList8, "resp.item_list");
                    for (T t3 : linkedList8) {
                        com.tencent.mm.plugin.finder.live.view.a.a aVar3 = com.tencent.mm.plugin.finder.live.view.a.a.UPD;
                        p.g(t3, "remote");
                        bo a3 = com.tencent.mm.plugin.finder.live.view.a.a.a((fhe) t3);
                        if (a3 instanceof com.tencent.mm.plugin.finder.live.view.a.c) {
                            LinkedList<bo> linkedList9 = this.LGy;
                            if (linkedList9 != null) {
                                int i3 = 0;
                                Iterator<bo> it = linkedList9.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        i3 = -1;
                                        break;
                                    }
                                    bo next = it.next();
                                    if (!(next instanceof com.tencent.mm.plugin.finder.live.view.a.c) || ((com.tencent.mm.plugin.finder.live.view.a.c) next).uko != ((com.tencent.mm.plugin.finder.live.view.a.c) a3).uko) {
                                        z2 = false;
                                    } else {
                                        z2 = true;
                                    }
                                    if (z2) {
                                        break;
                                    }
                                    i3++;
                                }
                                num2 = Integer.valueOf(i3);
                            } else {
                                num2 = null;
                            }
                            if (num2 != null && num2.intValue() == -1) {
                                linkedList7.add(a3);
                            }
                        } else if (a3 instanceof com.tencent.mm.plugin.finder.live.view.a.b) {
                            LinkedList<bo> linkedList10 = this.LGy;
                            if (linkedList10 != null) {
                                int i4 = 0;
                                Iterator<bo> it2 = linkedList10.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        i4 = -1;
                                        break;
                                    }
                                    bo next2 = it2.next();
                                    if (!(next2 instanceof com.tencent.mm.plugin.finder.live.view.a.b) || ((com.tencent.mm.plugin.finder.live.view.a.b) next2).UPE != ((com.tencent.mm.plugin.finder.live.view.a.b) a3).UPE) {
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    if (z) {
                                        break;
                                    }
                                    i4++;
                                }
                                num = Integer.valueOf(i4);
                            } else {
                                num = null;
                            }
                            if (num != null && num.intValue() == -1) {
                                linkedList7.add(a3);
                                String str2 = this.TAG;
                                StringBuilder sb2 = new StringBuilder("add adItem, index:");
                                LinkedList<bo> linkedList11 = this.LGy;
                                Log.i(str2, sb2.append(((linkedList11 != null ? linkedList11.size() : 0) + linkedList7.size()) - 1).toString());
                            } else {
                                Log.i(this.TAG, "add adItem, exist:".concat(String.valueOf(num)));
                            }
                        }
                    }
                } else {
                    Log.i(this.TAG, "item_list is Empty, resp.productList size:" + awc.LGy.size());
                    LinkedList<axg> linkedList12 = awc.LGy;
                    p.g(linkedList12, "resp.productList");
                    for (T t4 : linkedList12) {
                        LinkedList<bo> linkedList13 = this.LGy;
                        if (linkedList13 != null) {
                            i2 = 0;
                            Iterator<bo> it3 = linkedList13.iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    i2 = -1;
                                    break;
                                }
                                bo next3 = it3.next();
                                if ((next3 instanceof com.tencent.mm.plugin.finder.live.view.a.c) && ((com.tencent.mm.plugin.finder.live.view.a.c) next3).uko == t4.uko) {
                                    break;
                                }
                                i2++;
                            }
                        } else {
                            i2 = -1;
                        }
                        if (i2 == -1) {
                            com.tencent.mm.plugin.finder.live.view.a.a aVar4 = com.tencent.mm.plugin.finder.live.view.a.a.UPD;
                            p.g(t4, "remote");
                            linkedList7.add(com.tencent.mm.plugin.finder.live.view.a.a.b(t4));
                        }
                    }
                }
                LinkedList<bo> linkedList14 = this.LGy;
                if (linkedList14 != null) {
                    linkedList14.addAll(linkedList7);
                }
                LinkedList<bo> linkedList15 = this.LGy;
                awc2.gAZ = linkedList15 != null ? linkedList15.size() : 0;
            }
            String str3 = this.TAG;
            StringBuilder sb3 = new StringBuilder("continue merge, size:");
            LinkedList<bo> linkedList16 = this.LGy;
            Log.i(str3, sb3.append(linkedList16 != null ? Integer.valueOf(linkedList16.size()) : null).toString());
        }
        AppMethodBeat.o(247981);
    }

    public final void djd() {
        AppMethodBeat.i(247982);
        LinkedList<bo> linkedList = this.LGy;
        if (linkedList != null) {
            linkedList.clear();
            AppMethodBeat.o(247982);
            return;
        }
        AppMethodBeat.o(247982);
    }

    public final void dje() {
        AppMethodBeat.i(247983);
        com.tencent.mm.ac.d.h(new h(this));
        AppMethodBeat.o(247983);
    }

    private void djf() {
        AppMethodBeat.i(247984);
        com.tencent.mm.ac.d.h(new i(this));
        AppMethodBeat.o(247984);
    }

    public final boolean a(awi awi, awi awi2) {
        AppMethodBeat.i(247985);
        p.h(awi, "remoteLotteryInfo");
        p.h(awi2, "localLotteryInfo");
        if (!p.j(awi.id, awi2.id)) {
            Log.i(this.TAG, "isRemoteItemValid invalid id:" + awi.id + ',' + awi2.id);
            AppMethodBeat.o(247985);
            return false;
        } else if (!this.uFd) {
            AppMethodBeat.o(247985);
            return true;
        } else {
            int i2 = awi2.uhE;
            int i3 = awi.uhE;
            int i4 = awi2.LHb;
            int i5 = awi.LHb;
            if (i5 >= i4) {
                if (i4 < i5) {
                    Log.i(this.TAG, "printLotteryInfoList RemoteItem:" + com.tencent.mm.ac.g.bN(Integer.valueOf(i3)) + " invalid");
                    AppMethodBeat.o(247985);
                    return false;
                } else if ((i3 == 1 && i2 != 1) || (i3 == 2 && i2 == 3)) {
                    Log.i(this.TAG, "printLotteryInfoList RemoteItem:" + com.tencent.mm.ac.g.bN(Integer.valueOf(i3)) + " invalid");
                    AppMethodBeat.o(247985);
                    return false;
                }
            }
            AppMethodBeat.o(247985);
            return true;
        }
    }

    public final void a(awi awi) {
        AppMethodBeat.i(247986);
        com.tencent.mm.ac.d.h(new l(this, awi));
        AppMethodBeat.o(247986);
    }

    public static /* synthetic */ void h(g gVar, LinkedList linkedList) {
        AppMethodBeat.i(247988);
        gVar.b((LinkedList<awi>) linkedList, false);
        AppMethodBeat.o(247988);
    }

    public final void b(LinkedList<awi> linkedList, boolean z) {
        AppMethodBeat.i(247987);
        p.h(linkedList, "liveMsgLotteryInfoList");
        com.tencent.mm.ac.d.h(new C1204g(this, linkedList, z));
        AppMethodBeat.o(247987);
    }

    public static i b(awi awi, boolean z) {
        AppMethodBeat.i(247989);
        p.h(awi, "finderLiveLotteryInfo");
        i iVar = new i(awi.uhE, awi.LHb, awi, z, 96);
        AppMethodBeat.o(247989);
        return iVar;
    }

    public final void djg() {
        AppMethodBeat.i(247990);
        com.tencent.mm.ac.d.h(new c(this));
        AppMethodBeat.o(247990);
    }

    public final void bj(String str, boolean z) {
        AppMethodBeat.i(247991);
        com.tencent.mm.ac.d.h(new e(this, z, str));
        AppMethodBeat.o(247991);
    }

    public final boolean djh() {
        awi awi;
        AppMethodBeat.i(247992);
        i iVar = this.uEa;
        boolean cW = com.tencent.mm.ac.d.cW((iVar == null || (awi = iVar.tWe) == null) ? 0 : awi.extFlag, 1);
        Log.i(this.TAG, "haveParticipated :".concat(String.valueOf(cW)));
        AppMethodBeat.o(247992);
        return cW;
    }

    public final boolean atX(String str) {
        AppMethodBeat.i(247993);
        p.h(str, "lotteryId");
        if (this.uEb.isEmpty()) {
            this.uEb = dji();
        }
        Iterator<kotlin.o<Long, String>> it = this.uEb.iterator();
        p.g(it, "localSaveLotteryIdList.iterator()");
        while (it.hasNext()) {
            kotlin.o<Long, String> next = it.next();
            if (next.first.longValue() == this.liveInfo.liveId && p.j(next.second, str)) {
                AppMethodBeat.o(247993);
                return true;
            }
        }
        AppMethodBeat.o(247993);
        return false;
    }

    public final void atY(String str) {
        AppMethodBeat.i(247994);
        if (str != null) {
            if (this.uEb.isEmpty()) {
                this.uEb = dji();
            }
            Iterator<kotlin.o<Long, String>> it = this.uEb.iterator();
            p.g(it, "localSaveLotteryIdList.iterator()");
            while (true) {
                if (it.hasNext()) {
                    if (it.next().first.longValue() == this.liveInfo.liveId) {
                        it.remove();
                        break;
                    }
                } else {
                    break;
                }
            }
            if (this.uEb.size() > this.uFe) {
                int i2 = this.uFf;
                for (int i3 = 0; i3 < i2; i3++) {
                    this.uEb.removeLast();
                }
            }
            this.uEb.add(new kotlin.o<>(Long.valueOf(this.liveInfo.liveId), str));
            ConcurrentLinkedDeque<kotlin.o<Long, String>> concurrentLinkedDeque = this.uEb;
            StringBuilder sb = new StringBuilder();
            Iterator<kotlin.o<Long, String>> it2 = concurrentLinkedDeque.iterator();
            p.g(it2, "lotteryList.iterator()");
            while (it2.hasNext()) {
                kotlin.o<Long, String> next = it2.next();
                sb.append(next.first.longValue() + ':' + ((String) next.second)).append("|");
            }
            if (!(sb.length() == 0)) {
                sb.deleteCharAt(sb.length() - 1);
            }
            String sb2 = sb.toString();
            p.g(sb2, "result.toString()");
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_LIVE_LAST_LOTTERYID_STRING_SYNC, sb2);
            Log.i(this.TAG, "saveLastWinLotteryId MAX_LOTTERY_ID_LIST:" + this.uFe + ",DROP_LIST_SIZE:" + this.uFf + ",liveId:" + this.liveInfo.liveId + ",lotteryId:" + str + ",lotteryList:" + this.uEb + ",cacheListStr:" + sb2);
        }
        AppMethodBeat.o(247994);
    }

    private ConcurrentLinkedDeque<kotlin.o<Long, String>> dji() {
        AppMethodBeat.i(247995);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(ar.a.USERINFO_FINDER_LIVE_LAST_LOTTERYID_STRING_SYNC, "");
        if (obj == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(247995);
            throw tVar;
        }
        String str = (String) obj;
        ConcurrentLinkedDeque<kotlin.o<Long, String>> concurrentLinkedDeque = new ConcurrentLinkedDeque<>();
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            Log.i(this.TAG, "getLotteryIdList lotteryList is empty!");
            AppMethodBeat.o(247995);
            return concurrentLinkedDeque;
        }
        List b2 = kotlin.n.n.b(str, new String[]{"|"});
        int size = b2.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str3 = (String) b2.get(i2);
            List b3 = kotlin.n.n.b(str3, new String[]{":"});
            if (b3.size() != 2) {
                y yVar = y.vXH;
                if (y.dCM()) {
                    Log.i(this.TAG, "getLotteryIdList invalid lotteryInfo:".concat(String.valueOf(str3)));
                }
            } else {
                long safeParseLong = Util.safeParseLong((String) b3.get(0));
                String str4 = (String) b3.get(1);
                if (safeParseLong != 0) {
                    String str5 = str4;
                    if (!(str5 == null || str5.length() == 0)) {
                        concurrentLinkedDeque.add(new kotlin.o<>(Long.valueOf(safeParseLong), str4));
                    }
                }
                y yVar2 = y.vXH;
                if (y.dCM()) {
                    Log.i(this.TAG, "getLotteryIdList invalid liveId lotteryInfo:".concat(String.valueOf(str3)));
                }
            }
        }
        Log.i(this.TAG, "getLotteryIdList lotteryList:".concat(String.valueOf(concurrentLinkedDeque)));
        AppMethodBeat.o(247995);
        return concurrentLinkedDeque;
    }

    public static /* synthetic */ void a(g gVar, String str) {
        AppMethodBeat.i(247997);
        gVar.bk(str, false);
        AppMethodBeat.o(247997);
    }

    public final void bk(String str, boolean z) {
        AppMethodBeat.i(247996);
        p.h(str, "prefix");
        StringBuilder sb = new StringBuilder("printLotteryInfoList(" + str + ",fromJoinLive:" + z + ")：");
        int i2 = 0;
        for (T t : this.uDZ) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.a.j.hxH();
            }
            sb.append("index:" + i2 + ',' + ((Object) t) + "};");
            i2 = i3;
        }
        Log.i(this.TAG, sb.toString());
        AppMethodBeat.o(247996);
    }

    public final String djj() {
        Integer num;
        TRTCCloudDef.TRTCParams tRTCParams;
        TRTCCloudDef.TRTCParams tRTCParams2;
        Integer num2 = null;
        AppMethodBeat.i(247998);
        StringBuilder sb = new StringBuilder("appId:");
        com.tencent.mm.live.core.core.b.f fVar = this.hIy;
        if (fVar == null || (tRTCParams2 = fVar.hzu) == null) {
            num = null;
        } else {
            num = Integer.valueOf(tRTCParams2.sdkAppId);
        }
        StringBuilder append = sb.append(num).append("\nroomId:");
        com.tencent.mm.live.core.core.b.f fVar2 = this.hIy;
        if (!(fVar2 == null || (tRTCParams = fVar2.hzu) == null)) {
            num2 = Integer.valueOf(tRTCParams.roomId);
        }
        String sb2 = append.append(num2).append('\n').toString();
        AppMethodBeat.o(247998);
        return sb2;
    }

    public final boolean djk() {
        boolean z = true;
        AppMethodBeat.i(247999);
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        boolean dBP = com.tencent.mm.plugin.finder.utils.m.dBP();
        if (this.uEg != 1) {
            z = false;
        }
        boolean z2 = z & dBP;
        AppMethodBeat.o(247999);
        return z2;
    }

    public final boolean isLiveStarted() {
        return this.uEg == 3 || this.uEg == 2;
    }

    public final boolean hTY() {
        return this.UPU == 3 || this.UPU == 2;
    }

    public final boolean djl() {
        return this.uEg == 4;
    }

    public final boolean hTZ() {
        return this.uEg == 0;
    }

    public final boolean djm() {
        return this.uEt == 1;
    }

    public final boolean djn() {
        AppMethodBeat.i(248000);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        boolean dvk = com.tencent.mm.plugin.finder.storage.c.dvk();
        boolean djo = djo();
        Log.i(this.TAG, "fitLandscapeVideo config:" + dvk + ",isLandscapeVideo:" + djo);
        boolean z = dvk & djo;
        AppMethodBeat.o(248000);
        return z;
    }

    private boolean djo() {
        AppMethodBeat.i(248001);
        boolean djp = djp();
        Log.i(this.TAG, "isLandscapeVideo validVideoSize:".concat(String.valueOf(djp)));
        if (!djp || this.videoWidth < this.videoHeight) {
            AppMethodBeat.o(248001);
            return false;
        }
        AppMethodBeat.o(248001);
        return true;
    }

    public final boolean djp() {
        AppMethodBeat.i(248002);
        Log.i(this.TAG, "validVideoSize videoWidth:" + this.videoWidth + ",videoHeight:" + this.videoHeight);
        if (this.videoWidth <= 0 || this.videoHeight <= 0) {
            AppMethodBeat.o(248002);
            return false;
        }
        AppMethodBeat.o(248002);
        return true;
    }

    public final boolean hUa() {
        AppMethodBeat.i(261069);
        boolean z = this.hIt != null;
        Log.i(this.TAG, "hasJoinLive :".concat(String.valueOf(z)));
        AppMethodBeat.o(261069);
        return z;
    }

    public final String djq() {
        TRTCCloudDef.TRTCParams tRTCParams;
        com.tencent.mm.live.core.core.b.f fVar = this.hIy;
        if (fVar == null || (tRTCParams = fVar.hzu) == null) {
            return null;
        }
        return tRTCParams.userId;
    }

    public final int hUb() {
        TRTCCloudDef.TRTCParams tRTCParams;
        com.tencent.mm.live.core.core.b.f fVar = this.hIy;
        if (fVar == null || (tRTCParams = fVar.hzu) == null) {
            return 0;
        }
        return tRTCParams.sdkAppId;
    }

    public final boolean djr() {
        return this.uEC == 1 || this.uEC == 2;
    }

    public final boolean djs() {
        return this.uEC == 3 || this.uEC == 4;
    }

    public final boolean bxP(String str) {
        ArrayList arrayList;
        AppMethodBeat.i(261070);
        List<e> list = this.UPZ;
        p.g(list, "audienceLinkMicUserList");
        List<e> list2 = list;
        synchronized (list2) {
            try {
                ArrayList arrayList2 = new ArrayList();
                for (T t : list2) {
                    if (Util.isEqual(t.sessionId, str)) {
                        arrayList2.add(t);
                    }
                }
                arrayList = arrayList2;
            } catch (Throwable th) {
                AppMethodBeat.o(261070);
                throw th;
            }
        }
        e eVar = (e) kotlin.a.j.kt(arrayList);
        if ((eVar == null || eVar.UPO != 1) && (eVar == null || eVar.UPO != 2)) {
            AppMethodBeat.o(261070);
            return false;
        }
        AppMethodBeat.o(261070);
        return true;
    }

    public final e bxQ(String str) {
        ArrayList arrayList;
        AppMethodBeat.i(261071);
        List<e> list = this.UPZ;
        p.g(list, "audienceLinkMicUserList");
        List<e> list2 = list;
        synchronized (list2) {
            try {
                ArrayList arrayList2 = new ArrayList();
                for (T t : list2) {
                    if (Util.isEqual(t.sessionId, str)) {
                        arrayList2.add(t);
                    }
                }
                arrayList = arrayList2;
            } catch (Throwable th) {
                AppMethodBeat.o(261071);
                throw th;
            }
        }
        e eVar = (e) kotlin.a.j.kt(arrayList);
        AppMethodBeat.o(261071);
        return eVar;
    }

    public final e bxR(String str) {
        ArrayList arrayList;
        AppMethodBeat.i(261072);
        List<e> list = this.UPZ;
        p.g(list, "audienceLinkMicUserList");
        List<e> list2 = list;
        synchronized (list2) {
            try {
                ArrayList arrayList2 = new ArrayList();
                for (T t : list2) {
                    if (Util.isEqual(t.uCo, str)) {
                        arrayList2.add(t);
                    }
                }
                arrayList = arrayList2;
            } catch (Throwable th) {
                AppMethodBeat.o(261072);
                throw th;
            }
        }
        e eVar = (e) kotlin.a.j.kt(arrayList);
        AppMethodBeat.o(261072);
        return eVar;
    }

    public final void hUc() {
        T t;
        boolean z;
        boolean z2;
        AppMethodBeat.i(261073);
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        LinkedList<aus> hVr = com.tencent.mm.plugin.finder.utils.m.hVr();
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_LIVE_VISITOR_ROLE_INT_SYNC, 4);
        Iterator<T> it = hVr.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            if (next.LFy == i2) {
                z2 = true;
                continue;
            } else {
                z2 = false;
                continue;
            }
            if (z2) {
                t = next;
                break;
            }
        }
        T t2 = t;
        if (t2 == null) {
            this.UQh.LFy = 4;
            this.UQh.nickname = z.aUa();
            aus aus = this.UQh;
            com.tencent.mm.aj.i Mx = com.tencent.mm.aj.p.aYB().Mx(z.aTY());
            p.g(Mx, "SubCoreAvatar.getImgFlag…etUsernameFromUserInfo())");
            aus.qFV = Mx.aYu();
        } else {
            this.UQh = t2;
            com.tencent.mm.plugin.finder.utils.m mVar2 = com.tencent.mm.plugin.finder.utils.m.vVH;
            this.UQj = com.tencent.mm.plugin.finder.utils.m.hVr();
            com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh2, "MMKernel.storage()");
            this.UQi = aAh2.azQ().getInt(ar.a.USERINFO_FINDER_LIVE_VISITOR_ROLE_INT_SYNC, 4);
            com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh3, "MMKernel.storage()");
            this.UQk = aAh3.azQ().a(ar.a.USERINFO_FINDER_LIVE_ALIAS_MODIFY_TIME_LONG_SYNC, Long.MIN_VALUE);
        }
        String str = this.TAG;
        StringBuilder sb = new StringBuilder("initVisitorRoleInfo local visitorRoleList:");
        com.tencent.mm.plugin.finder.utils.m mVar3 = com.tencent.mm.plugin.finder.utils.m.vVH;
        StringBuilder append = sb.append(com.tencent.mm.plugin.finder.utils.m.a("initVisitorRoleInfo", hVr, i2, 0)).append(",local VisitorRoleType:").append(i2).append(", local visitor role is empty:");
        if (t2 == null) {
            z = true;
        } else {
            z = false;
        }
        Log.i(str, append.append(z).append(",visitor Role:").append(com.tencent.mm.ac.g.bN(this.UQh)).toString());
        AppMethodBeat.o(261073);
    }

    public final void hUd() {
        T t;
        boolean z;
        AppMethodBeat.i(261074);
        Log.i(this.TAG, "updateVisitorRoleInfo,before udpate:" + com.tencent.mm.ac.g.bN(this.UQh));
        Iterator<T> it = this.UQj.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            if (next.LFy == this.UQi) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                t = next;
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            this.UQh = t2;
        }
        Log.i(this.TAG, "updateVisitorRoleInfo,after udpate:" + com.tencent.mm.ac.g.bN(this.UQh));
        AppMethodBeat.o(261074);
    }

    public static boolean awP(int i2) {
        return i2 != 1;
    }

    public static boolean awQ(int i2) {
        return i2 == 3;
    }

    public static boolean awR(int i2) {
        return i2 == 2;
    }

    public final void f(e eVar) {
        T t;
        AppMethodBeat.i(261075);
        List<e> list = this.UPZ;
        p.g(list, "audienceLinkMicUserList");
        List<e> list2 = list;
        synchronized (list2) {
            try {
                Iterator<T> it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    t = it.next();
                    if (Util.isEqual(eVar.uCo, t.uCo)) {
                        break;
                    }
                }
            } finally {
                AppMethodBeat.o(261075);
            }
        }
        if (t == null) {
            this.UPZ.add(eVar);
        }
    }

    public final String toString() {
        AppMethodBeat.i(248003);
        String info = info();
        AppMethodBeat.o(248003);
        return info;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ g uFh;
        final /* synthetic */ avy uFi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(g gVar, avy avy) {
            super(0);
            this.uFh = gVar;
            this.uFi = avy;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            LinkedList<awh> linkedList;
            LinkedList<awh> linkedList2;
            Integer num;
            LinkedList<awh> linkedList3;
            awi awi;
            AppMethodBeat.i(247950);
            if (this.uFi != null) {
                awi awi2 = this.uFi.tWe;
                String str = awi2 != null ? awi2.id : null;
                avy avy = this.uFh.uEc;
                String str2 = (avy == null || (awi = avy.tWe) == null) ? null : awi.id;
                Log.i(this.uFh.TAG, "mergeLotteryRecord localRecordLotteryId:" + str2 + ",remoteRecordId:" + str);
                String str3 = str;
                if (!(str3 == null || str3.length() == 0)) {
                    String str4 = str2;
                    if ((str4 == null || str4.length() == 0) || (!p.j(str2, str))) {
                        this.uFh.c(this.uFi);
                    } else {
                        avy avy2 = this.uFh.uEc;
                        if (avy2 != null) {
                            avy2.tWe = this.uFi.tWe;
                            avy2.lastBuffer = this.uFi.lastBuffer;
                            avy2.continueFlag = this.uFi.continueFlag;
                            LinkedList linkedList4 = new LinkedList();
                            awk awk = this.uFi.LGt;
                            if (!(awk == null || (linkedList2 = awk.LHf) == null)) {
                                for (T t : linkedList2) {
                                    awk awk2 = avy2.LGt;
                                    if (awk2 == null || (linkedList3 = awk2.LHf) == null) {
                                        num = null;
                                    } else {
                                        Iterator<awh> it = linkedList3.iterator();
                                        int i2 = 0;
                                        while (true) {
                                            if (!it.hasNext()) {
                                                i2 = -1;
                                                break;
                                            } else if (p.j(it.next().username, t.username)) {
                                                break;
                                            } else {
                                                i2++;
                                            }
                                        }
                                        num = Integer.valueOf(i2);
                                    }
                                    if (num != null && num.intValue() == -1) {
                                        linkedList4.add(t);
                                    }
                                }
                            }
                            awk awk3 = avy2.LGt;
                            if (!(awk3 == null || (linkedList = awk3.LHf) == null)) {
                                linkedList.addAll(linkedList4);
                            }
                        }
                        String str5 = this.uFh.TAG;
                        StringBuilder sb = new StringBuilder("after mergeLotteryRecord lotteryRecord:");
                        Object obj = this.uFh.uEc;
                        if (obj == null) {
                            obj = "";
                        }
                        Log.i(str5, sb.append(com.tencent.mm.ac.g.bN(obj)).toString());
                    }
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(247950);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class j extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ g uFh;
        final /* synthetic */ awr uFo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(g gVar, awr awr) {
            super(0);
            this.uFh = gVar;
            this.uFo = awr;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            this.uFh.uDY = this.uFo;
            return x.SXb;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ g uFh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(g gVar) {
            super(0);
            this.uFh = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            this.uFh.uDY = null;
            return x.SXb;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ g uFh;
        final /* synthetic */ i ugt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(g gVar, i iVar) {
            super(0);
            this.uFh = gVar;
            this.ugt = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(247953);
            this.uFh.uEa = this.ugt;
            g.h(this.uFh);
            Log.i(this.uFh.TAG, "replaceLocalLotteryInfo:" + this.uFh.uEa);
            x xVar = x.SXb;
            AppMethodBeat.o(247953);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class k extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ g uFh;
        final /* synthetic */ i ugt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(g gVar, i iVar) {
            super(0);
            this.uFh = gVar;
            this.ugt = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            int i2;
            String str;
            int i3;
            i iVar;
            awi awi;
            awi awi2;
            awi awi3;
            awi awi4;
            awi awi5;
            boolean z = false;
            AppMethodBeat.i(247955);
            i iVar2 = this.ugt;
            String str2 = (iVar2 == null || (awi5 = iVar2.tWe) == null) ? null : awi5.id;
            i iVar3 = this.ugt;
            if (iVar3 == null || (awi4 = iVar3.tWe) == null) {
                i2 = 0;
            } else {
                i2 = awi4.trl;
            }
            i iVar4 = this.uFh.uEa;
            if (iVar4 == null || (awi3 = iVar4.tWe) == null) {
                str = null;
            } else {
                str = awi3.id;
            }
            i iVar5 = this.uFh.uEa;
            if (iVar5 == null || (awi2 = iVar5.tWe) == null) {
                i3 = 0;
            } else {
                i3 = awi2.trl;
            }
            String str3 = str2;
            if (str3 == null || str3.length() == 0) {
                z = true;
            }
            if (!z && p.j(str, str2)) {
                i iVar6 = this.uFh.uEa;
                if (iVar6 != null) {
                    iVar6.tWe = this.ugt.tWe;
                }
                i iVar7 = this.uFh.uEa;
                if (iVar7 != null) {
                    iVar7.uFt = this.ugt.uFt;
                }
                if (!(i2 >= i3 || (iVar = this.uFh.uEa) == null || (awi = iVar.tWe) == null)) {
                    awi.trl = i3;
                }
            }
            Log.i(this.uFh.TAG, "updateLocalLotteryInfo:" + this.uFh.uEa + ",remoteParticipateCount:" + i2 + ",curParticipateCount:" + i3);
            x xVar = x.SXb;
            AppMethodBeat.o(247955);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class i extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ g uFh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(g gVar) {
            super(0);
            this.uFh = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            this.uFh.uEa = null;
            return x.SXb;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class l extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ g uFh;
        final /* synthetic */ awi uhK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(g gVar, awi awi) {
            super(0);
            this.uFh = gVar;
            this.uhK = awi;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            String str;
            T t;
            awi awi;
            AppMethodBeat.i(247956);
            awi awi2 = this.uhK;
            if (!(awi2 == null || (str = awi2.id) == null)) {
                Iterator<T> it = this.uFh.uDZ.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    T next = it.next();
                    awi awi3 = next.tWe;
                    if (p.j(awi3 != null ? awi3.id : null, str)) {
                        t = next;
                        break;
                    }
                }
                T t2 = t;
                if (t2 != null && ((awi = t2.tWe) == null || this.uFh.a(this.uhK, awi))) {
                    t2.tWe = this.uhK;
                }
            }
            g.a(this.uFh, "update");
            x xVar = x.SXb;
            AppMethodBeat.o(247956);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ g uFh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(g gVar) {
            super(0);
            this.uFh = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            awi awi;
            AppMethodBeat.i(247948);
            i iVar = (i) kotlin.a.j.kt(this.uFh.uDZ);
            if (!(iVar == null || (awi = iVar.tWe) == null)) {
                awi.uhE = 4;
            }
            g.a(this.uFh, "cancel");
            x xVar = x.SXb;
            AppMethodBeat.o(247948);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.finder.live.viewmodel.g$g  reason: collision with other inner class name */
    public static final class C1204g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ g uFh;
        final /* synthetic */ LinkedList uFm;
        final /* synthetic */ boolean uFn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1204g(g gVar, LinkedList linkedList, boolean z) {
            super(0);
            this.uFh = gVar;
            this.uFm = linkedList;
            this.uFn = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Removed duplicated region for block: B:113:0x00e4 A[SYNTHETIC] */
        @Override // kotlin.g.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ kotlin.x invoke() {
            /*
            // Method dump skipped, instructions count: 421
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.viewmodel.g.C1204g.invoke():java.lang.Object");
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class n extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ LinkedList UQt;
        final /* synthetic */ g uFh;
        final /* synthetic */ boolean uFn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(g gVar, LinkedList linkedList, boolean z) {
            super(0);
            this.uFh = gVar;
            this.UQt = linkedList;
            this.uFn = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(261055);
            this.uFh.UQo.clear();
            this.uFh.UQo.addAll(this.UQt);
            g gVar = this.uFh;
            boolean z = this.uFn;
            p.h("reset", "prefix");
            StringBuilder sb = new StringBuilder("printRedPacketInfoList(" + "reset" + ",fromJoinLive:" + z + ")：");
            List<fgy> list = gVar.UQo;
            if (list != null) {
                int i2 = 0;
                for (T t : list) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        kotlin.a.j.hxH();
                    }
                    sb.append("index:" + i2 + ',' + ((Object) t) + "};");
                    i2 = i3;
                }
            }
            Log.i(gVar.TAG, sb.toString());
            x xVar = x.SXb;
            AppMethodBeat.o(261055);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ g uFh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(g gVar) {
            super(0);
            this.uFh = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(247949);
            LinkedList<i> linkedList = this.uFh.uDZ;
            if (linkedList != null) {
                linkedList.clear();
            }
            g gVar = this.uFh;
            LinkedList<i> linkedList2 = new LinkedList<>();
            p.h(linkedList2, "<set-?>");
            gVar.uDZ = linkedList2;
            x xVar = x.SXb;
            AppMethodBeat.o(247949);
            return xVar;
        }
    }

    public static final /* synthetic */ void h(g gVar) {
        AppMethodBeat.i(248006);
        gVar.c(null);
        AppMethodBeat.o(248006);
    }
}
