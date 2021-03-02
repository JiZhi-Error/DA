package com.tencent.mm.plugin.flutter.e.a.a;

import android.graphics.Bitmap;
import com.facebook.share.internal.ShareConstants;
import com.tencent.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.vlog.model.i;
import com.tencent.mm.protocal.protobuf.acm;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.protocal.protobuf.aip;
import com.tencent.mm.protocal.protobuf.aiq;
import com.tencent.mm.protocal.protobuf.cmv;
import com.tencent.mm.protocal.protobuf.dlh;
import com.tencent.mm.protocal.protobuf.ecy;
import com.tencent.mm.protocal.protobuf.ejf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;
import kotlinx.coroutines.f;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007\b\u0016¢\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/flutter/plugins/video/api/MMVideoEditorJumpToPostUI;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", ShareConstants.RESULT_POST_ID, "generateCompositionInfo", "", "compositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "originInfo", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$CompositionInfo;", "jumpToPostUI1", "jumpToPostUI2", "exportStartTime", "", "Companion", "plugin-flutter_release"})
public final class j {
    public static Bitmap wKi;
    public static b.g wKj;
    public static acn wKk;
    public static final a wKl = new a((byte) 0);
    public String TAG = "MMVideoEditorJumpToPostUI";
    public String postId = "";

    static {
        AppMethodBeat.i(241092);
        AppMethodBeat.o(241092);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
    public static final class b extends q implements kotlin.g.a.b<Bitmap, x> {
        final /* synthetic */ b.g wKm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(b.g gVar) {
            super(1);
            this.wKm = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Bitmap bitmap) {
            AppMethodBeat.i(241089);
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null) {
                a aVar = j.wKl;
                p.h(bitmap2, "<set-?>");
                j.wKi = bitmap2;
            }
            f.b(bn.TUK, ba.hMV(), new m<ai, d<? super x>, Object>(this, null) {
                /* class com.tencent.mm.plugin.flutter.e.a.a.j.b.AnonymousClass1 */
                int label;
                private ai p$;
                final /* synthetic */ b wKn;

                {
                    this.wKn = r2;
                }

                @Override // kotlin.d.b.a.a
                public final d<x> create(Object obj, d<?> dVar) {
                    AppMethodBeat.i(241087);
                    p.h(dVar, "completion");
                    AnonymousClass1 r0 = 

                    public j() {
                        AppMethodBeat.i(241091);
                        StringBuilder sb = new StringBuilder();
                        p.g(g.aAf(), "MMKernel.account()");
                        this.postId = sb.append(com.tencent.mm.kernel.a.ayV()).append('_').append(Util.nowMilliSecond()).toString();
                        AppMethodBeat.o(241091);
                    }

                    public final void a(acn acn, b.g gVar) {
                        AppMethodBeat.i(241090);
                        Log.i(this.TAG, "generateCompositionInfo");
                        acn.Gxx = new acm();
                        if (gVar.hjE() != null) {
                            HashMap hjE = gVar.hjE();
                            if (hjE == null) {
                                t tVar = new t("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.Any> /* = java.util.HashMap<kotlin.String, kotlin.Any> */");
                                AppMethodBeat.o(241090);
                                throw tVar;
                            }
                            Object obj = hjE.get("drawingRect");
                            if (obj == null) {
                                t tVar2 = new t("null cannot be cast to non-null type java.util.ArrayList<kotlin.Int>");
                                AppMethodBeat.o(241090);
                                throw tVar2;
                            }
                            ArrayList arrayList = (ArrayList) obj;
                            if (arrayList != null) {
                                acn.Gxx.LmZ = new dlh();
                                acn.Gxx.LmZ.Msu = new LinkedList<>();
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    acn.Gxx.LmZ.Msu.add((Integer) it.next());
                                }
                            }
                            acm acm = acn.Gxx;
                            Object obj2 = hjE.get("recordVideo");
                            if (obj2 == null) {
                                t tVar3 = new t("null cannot be cast to non-null type kotlin.Boolean");
                                AppMethodBeat.o(241090);
                                throw tVar3;
                            }
                            acm.Lnb = ((Boolean) obj2).booleanValue();
                            Object obj3 = hjE.get("validRect");
                            if (obj3 == null) {
                                t tVar4 = new t("null cannot be cast to non-null type java.util.ArrayList<kotlin.Int>");
                                AppMethodBeat.o(241090);
                                throw tVar4;
                            }
                            ArrayList arrayList2 = (ArrayList) obj3;
                            if (arrayList2 != null) {
                                acn.Gxx.Lnc = new dlh();
                                acn.Gxx.Lnc.Msu = new LinkedList<>();
                                Iterator it2 = arrayList2.iterator();
                                while (it2.hasNext()) {
                                    acn.Gxx.Lnc.Msu.add((Integer) it2.next());
                                }
                            }
                            Object obj4 = hjE.get("stickerEffectList");
                            if (obj4 == null) {
                                t tVar5 = new t("null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.HashMap<kotlin.Any, kotlin.Any> /* = java.util.HashMap<kotlin.Any, kotlin.Any> */>");
                                AppMethodBeat.o(241090);
                                throw tVar5;
                            }
                            LinkedList linkedList = new LinkedList();
                            for (HashMap hashMap : (List) obj4) {
                                ecy ecy = new ecy();
                                Object obj5 = hashMap.get("type");
                                Boolean valueOf = obj5 != null ? Boolean.valueOf(obj5.equals("emoji")) : null;
                                if (valueOf == null) {
                                    p.hyc();
                                }
                                if (valueOf.booleanValue()) {
                                    Object obj6 = hashMap.get("path");
                                    if (obj6 == null) {
                                        t tVar6 = new t("null cannot be cast to non-null type kotlin.String");
                                        AppMethodBeat.o(241090);
                                        throw tVar6;
                                    }
                                    ecy.path = (String) obj6;
                                } else {
                                    Object obj7 = hashMap.get("type");
                                    Boolean valueOf2 = obj7 != null ? Boolean.valueOf(obj7.equals("text")) : null;
                                    if (valueOf2 == null) {
                                        p.hyc();
                                    }
                                    if (valueOf2.booleanValue()) {
                                        Object obj8 = hashMap.get("width");
                                        if (obj8 == null) {
                                            t tVar7 = new t("null cannot be cast to non-null type kotlin.Int");
                                            AppMethodBeat.o(241090);
                                            throw tVar7;
                                        }
                                        int intValue = ((Integer) obj8).intValue();
                                        Object obj9 = hashMap.get("height");
                                        if (obj9 == null) {
                                            t tVar8 = new t("null cannot be cast to non-null type kotlin.Int");
                                            AppMethodBeat.o(241090);
                                            throw tVar8;
                                        }
                                        int intValue2 = ((Integer) obj9).intValue();
                                        Object obj10 = hashMap.get("bytes");
                                        if (obj10 == null) {
                                            t tVar9 = new t("null cannot be cast to non-null type kotlin.ByteArray");
                                            AppMethodBeat.o(241090);
                                            throw tVar9;
                                        }
                                        Bitmap createBitmap = Bitmap.createBitmap(intValue, intValue2, Bitmap.Config.ARGB_8888);
                                        createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap((byte[]) obj10));
                                        p.g(createBitmap, "bmp");
                                        int width = createBitmap.getWidth();
                                        int height = createBitmap.getHeight();
                                        ByteBuffer allocate = ByteBuffer.allocate(createBitmap.getByteCount());
                                        createBitmap.copyPixelsToBuffer(allocate);
                                        ecy.Ndn = com.tencent.mm.bw.b.cD(allocate.array());
                                        ecy.width = width;
                                        ecy.height = height;
                                        aiq aiq = new aiq();
                                        aiq.startTimeMs = 0;
                                        aiq.endTimeMs = 10000;
                                        x xVar = x.SXb;
                                        ecy.Ndo = aiq;
                                        aip aip = new aip();
                                        aip.centerX = 300;
                                        aip.centerY = 1000;
                                        aip.scale = 1.0f;
                                        aip.mat = 0.0f;
                                        x xVar2 = x.SXb;
                                        ecy.Ndp = aip;
                                    }
                                }
                                aiq aiq2 = new aiq();
                                Object obj11 = hashMap.get("startTime");
                                if (obj11 == null) {
                                    t tVar10 = new t("null cannot be cast to non-null type kotlin.Int");
                                    AppMethodBeat.o(241090);
                                    throw tVar10;
                                }
                                aiq2.startTimeMs = (long) ((Integer) obj11).intValue();
                                Object obj12 = hashMap.get("endTime");
                                if (obj12 == null) {
                                    t tVar11 = new t("null cannot be cast to non-null type kotlin.Int");
                                    AppMethodBeat.o(241090);
                                    throw tVar11;
                                }
                                aiq2.endTimeMs = (long) ((Integer) obj12).intValue();
                                ecy.Ndo = aiq2;
                                aip aip2 = new aip();
                                Object obj13 = hashMap.get("centerX");
                                if (obj13 == null) {
                                    t tVar12 = new t("null cannot be cast to non-null type kotlin.Int");
                                    AppMethodBeat.o(241090);
                                    throw tVar12;
                                }
                                aip2.centerX = ((Integer) obj13).intValue();
                                Object obj14 = hashMap.get("centerY");
                                if (obj14 == null) {
                                    t tVar13 = new t("null cannot be cast to non-null type kotlin.Int");
                                    AppMethodBeat.o(241090);
                                    throw tVar13;
                                }
                                aip2.centerY = ((Integer) obj14).intValue();
                                Object obj15 = hashMap.get("scale");
                                if (obj15 == null) {
                                    t tVar14 = new t("null cannot be cast to non-null type kotlin.Double");
                                    AppMethodBeat.o(241090);
                                    throw tVar14;
                                }
                                aip2.scale = (float) ((Double) obj15).doubleValue();
                                Object obj16 = hashMap.get(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION);
                                if (obj16 == null) {
                                    t tVar15 = new t("null cannot be cast to non-null type kotlin.Double");
                                    AppMethodBeat.o(241090);
                                    throw tVar15;
                                }
                                aip2.mat = (float) ((Double) obj16).doubleValue();
                                ecy.Ndp = aip2;
                                linkedList.add(ecy);
                            }
                            i.p(linkedList);
                        }
                        Boolean hjG = gVar.hjG();
                        p.g(hjG, "originInfo.enableVideoEnhanceMent");
                        acn.Gzp = hjG.booleanValue();
                        if (gVar.hjO() != null) {
                            Iterator it3 = gVar.hjO().iterator();
                            while (it3.hasNext()) {
                                Object next = it3.next();
                                acp acp = new acp();
                                if (next == null) {
                                    t tVar16 = new t("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.Any> /* = java.util.HashMap<kotlin.String, kotlin.Any> */");
                                    AppMethodBeat.o(241090);
                                    throw tVar16;
                                }
                                HashMap hashMap2 = (HashMap) next;
                                Object obj17 = hashMap2.get("path");
                                if (obj17 == null) {
                                    t tVar17 = new t("null cannot be cast to non-null type kotlin.String");
                                    AppMethodBeat.o(241090);
                                    throw tVar17;
                                }
                                acp.path = (String) obj17;
                                Object obj18 = hashMap2.get("label");
                                if (obj18 == null) {
                                    t tVar18 = new t("null cannot be cast to non-null type kotlin.Int");
                                    AppMethodBeat.o(241090);
                                    throw tVar18;
                                }
                                acp.label = ((Integer) obj18).intValue();
                                Object obj19 = hashMap2.get("cost");
                                if (obj19 == null) {
                                    t tVar19 = new t("null cannot be cast to non-null type kotlin.Int");
                                    AppMethodBeat.o(241090);
                                    throw tVar19;
                                }
                                acp.Lns = (long) ((Integer) obj19).intValue();
                                acn.Lnj.add(acp);
                            }
                        }
                        Boolean hjF = gVar.hjF();
                        p.g(hjF, "originInfo.enableOriginAudio");
                        acn.Gzo = hjF.booleanValue();
                        Boolean hjG2 = gVar.hjG();
                        p.g(hjG2, "originInfo.enableVideoEnhanceMent");
                        acn.Gzp = hjG2.booleanValue();
                        acn.iiv = gVar.hjH();
                        acn.editId = gVar.hjD();
                        Boolean hjI = gVar.hjI();
                        p.g(hjI, "originInfo.needPlay");
                        acn.Lng = hjI.booleanValue();
                        acn.Gxw = new aco();
                        if (gVar.hjM() != null) {
                            HashMap hjM = gVar.hjM();
                            if (hjM == null) {
                                t tVar20 = new t("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.Any> /* = java.util.HashMap<kotlin.String, kotlin.Any> */");
                                AppMethodBeat.o(241090);
                                throw tVar20;
                            }
                            aco aco = acn.Gxw;
                            Object obj20 = hjM.get("absSwitch");
                            if (obj20 == null) {
                                t tVar21 = new t("null cannot be cast to non-null type kotlin.Int");
                                AppMethodBeat.o(241090);
                                throw tVar21;
                            }
                            aco.iTg = ((Integer) obj20).intValue();
                            aco aco2 = acn.Gxw;
                            Object obj21 = hjM.get("outputPath");
                            if (obj21 == null) {
                                t tVar22 = new t("null cannot be cast to non-null type kotlin.String");
                                AppMethodBeat.o(241090);
                                throw tVar22;
                            }
                            aco2.rpE = (String) obj21;
                            aco aco3 = acn.Gxw;
                            Object obj22 = hjM.get("originWidth");
                            if (obj22 == null) {
                                t tVar23 = new t("null cannot be cast to non-null type kotlin.Int");
                                AppMethodBeat.o(241090);
                                throw tVar23;
                            }
                            aco3.xlg = ((Integer) obj22).intValue();
                            aco aco4 = acn.Gxw;
                            Object obj23 = hjM.get("originHeight");
                            if (obj23 == null) {
                                t tVar24 = new t("null cannot be cast to non-null type kotlin.Int");
                                AppMethodBeat.o(241090);
                                throw tVar24;
                            }
                            aco4.xlh = ((Integer) obj23).intValue();
                            aco aco5 = acn.Gxw;
                            Object obj24 = hjM.get("outputScale");
                            if (obj24 == null) {
                                t tVar25 = new t("null cannot be cast to non-null type kotlin.Double");
                                AppMethodBeat.o(241090);
                                throw tVar25;
                            }
                            aco5.Lnn = (float) ((Double) obj24).doubleValue();
                            aco aco6 = acn.Gxw;
                            Object obj25 = hjM.get("videoBitrate");
                            if (obj25 == null) {
                                t tVar26 = new t("null cannot be cast to non-null type kotlin.Int");
                                AppMethodBeat.o(241090);
                                throw tVar26;
                            }
                            aco6.videoBitrate = ((Integer) obj25).intValue();
                            aco aco7 = acn.Gxw;
                            Object obj26 = hjM.get("fps");
                            if (obj26 == null) {
                                t tVar27 = new t("null cannot be cast to non-null type kotlin.Int");
                                AppMethodBeat.o(241090);
                                throw tVar27;
                            }
                            aco7.fps = ((Integer) obj26).intValue();
                            aco aco8 = acn.Gxw;
                            Object obj27 = hjM.get("iFrame");
                            if (obj27 == null) {
                                t tVar28 = new t("null cannot be cast to non-null type kotlin.Int");
                                AppMethodBeat.o(241090);
                                throw tVar28;
                            }
                            aco8.iiH = ((Integer) obj27).intValue();
                            aco aco9 = acn.Gxw;
                            Object obj28 = hjM.get("audioBitrate");
                            if (obj28 == null) {
                                t tVar29 = new t("null cannot be cast to non-null type kotlin.Int");
                                AppMethodBeat.o(241090);
                                throw tVar29;
                            }
                            aco9.audioBitrate = ((Integer) obj28).intValue();
                            aco aco10 = acn.Gxw;
                            Object obj29 = hjM.get("audioSampleRate");
                            if (obj29 == null) {
                                t tVar30 = new t("null cannot be cast to non-null type kotlin.Int");
                                AppMethodBeat.o(241090);
                                throw tVar30;
                            }
                            aco10.audioSampleRate = ((Integer) obj29).intValue();
                            aco aco11 = acn.Gxw;
                            Object obj30 = hjM.get("audioChannelCount");
                            if (obj30 == null) {
                                t tVar31 = new t("null cannot be cast to non-null type kotlin.Int");
                                AppMethodBeat.o(241090);
                                throw tVar31;
                            }
                            aco11.audioChannelCount = ((Integer) obj30).intValue();
                            acn.Gxw.Lnm = new dlh();
                            acn.Gxw.Lnm.Msu = new LinkedList<>();
                            Object obj31 = hjM.get("originRect");
                            if (obj31 == null) {
                                t tVar32 = new t("null cannot be cast to non-null type java.util.ArrayList<kotlin.Int>");
                                AppMethodBeat.o(241090);
                                throw tVar32;
                            }
                            ArrayList arrayList3 = (ArrayList) obj31;
                            if (arrayList3 != null) {
                                Iterator it4 = arrayList3.iterator();
                                while (it4.hasNext()) {
                                    acn.Gxw.Lnm.Msu.add((Integer) it4.next());
                                }
                            }
                            acn.Gxw.Lno = new LinkedList<>();
                            aco aco12 = acn.Gxw;
                            int intValue3 = ((Number) arrayList3.get(2)).intValue();
                            Object obj32 = arrayList3.get(0);
                            p.g(obj32, "originRect[0]");
                            aco12.targetWidth = intValue3 - ((Number) obj32).intValue();
                            aco aco13 = acn.Gxw;
                            int intValue4 = ((Number) arrayList3.get(3)).intValue();
                            Object obj33 = arrayList3.get(1);
                            p.g(obj33, "originRect[1]");
                            aco13.targetHeight = intValue4 - ((Number) obj33).intValue();
                        }
                        Long hjJ = gVar.hjJ();
                        p.g(hjJ, "originInfo.playEndMs");
                        acn.Lnf = hjJ.longValue();
                        Long hjK = gVar.hjK();
                        p.g(hjK, "originInfo.playStartMs");
                        acn.Lne = hjK.longValue();
                        acn.Lnd = new LinkedList<>();
                        if (gVar.hjL() != null) {
                            Iterator it5 = gVar.hjL().iterator();
                            while (it5.hasNext()) {
                                Object next2 = it5.next();
                                ejf ejf = new ejf();
                                if (next2 == null) {
                                    t tVar33 = new t("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.Any> /* = java.util.HashMap<kotlin.String, kotlin.Any> */");
                                    AppMethodBeat.o(241090);
                                    throw tVar33;
                                }
                                HashMap hashMap3 = (HashMap) next2;
                                Object obj34 = hashMap3.get("path");
                                if (obj34 == null) {
                                    t tVar34 = new t("null cannot be cast to non-null type kotlin.String");
                                    AppMethodBeat.o(241090);
                                    throw tVar34;
                                }
                                ejf.path = (String) obj34;
                                Object obj35 = hashMap3.get("endTimeMs");
                                if (obj35 == null) {
                                    t tVar35 = new t("null cannot be cast to non-null type kotlin.Int");
                                    AppMethodBeat.o(241090);
                                    throw tVar35;
                                }
                                ejf.endTimeMs = (long) ((Integer) obj35).intValue();
                                Object obj36 = hashMap3.get("startTimeMs");
                                if (obj36 == null) {
                                    t tVar36 = new t("null cannot be cast to non-null type kotlin.Int");
                                    AppMethodBeat.o(241090);
                                    throw tVar36;
                                }
                                ejf.startTimeMs = (long) ((Integer) obj36).intValue();
                                Object obj37 = hashMap3.get("trackStartTimeMs");
                                if (obj37 == null) {
                                    t tVar37 = new t("null cannot be cast to non-null type kotlin.Int");
                                    AppMethodBeat.o(241090);
                                    throw tVar37;
                                }
                                ejf.GGz = (long) ((Integer) obj37).intValue();
                                Object obj38 = hashMap3.get("trackEndTimeMs");
                                if (obj38 == null) {
                                    t tVar38 = new t("null cannot be cast to non-null type kotlin.Int");
                                    AppMethodBeat.o(241090);
                                    throw tVar38;
                                }
                                ejf.GGA = (long) ((Integer) obj38).intValue();
                                Object obj39 = hashMap3.get("sourceDuration");
                                if (obj39 == null) {
                                    t tVar39 = new t("null cannot be cast to non-null type kotlin.Int");
                                    AppMethodBeat.o(241090);
                                    throw tVar39;
                                }
                                ejf.GJB = (long) ((Integer) obj39).intValue();
                                Object obj40 = hashMap3.get("volume");
                                if (obj40 == null) {
                                    t tVar40 = new t("null cannot be cast to non-null type kotlin.Double");
                                    AppMethodBeat.o(241090);
                                    throw tVar40;
                                }
                                ejf.volume = (float) ((Double) obj40).doubleValue();
                                Object obj41 = hashMap3.get("type");
                                if (obj41 == null) {
                                    t tVar41 = new t("null cannot be cast to non-null type kotlin.Int");
                                    AppMethodBeat.o(241090);
                                    throw tVar41;
                                }
                                ejf.type = ((Integer) obj41).intValue();
                                if (ejf.type == 2) {
                                    Object obj42 = hashMap3.get("sourceWidth");
                                    if (obj42 == null) {
                                        t tVar42 = new t("null cannot be cast to non-null type kotlin.Int");
                                        AppMethodBeat.o(241090);
                                        throw tVar42;
                                    }
                                    ejf.Gzu = ((Integer) obj42).intValue();
                                    Object obj43 = hashMap3.get("sourceHeight");
                                    if (obj43 == null) {
                                        t tVar43 = new t("null cannot be cast to non-null type kotlin.Int");
                                        AppMethodBeat.o(241090);
                                        throw tVar43;
                                    }
                                    ejf.Gzv = ((Integer) obj43).intValue();
                                    Object obj44 = hashMap3.get("sourceScale");
                                    if (obj44 == null) {
                                        t tVar44 = new t("null cannot be cast to non-null type kotlin.Double");
                                        AppMethodBeat.o(241090);
                                        throw tVar44;
                                    }
                                    ejf.Gzw = (float) ((Double) obj44).doubleValue();
                                    Object obj45 = hashMap3.get("fromCamera");
                                    if (obj45 == null) {
                                        t tVar45 = new t("null cannot be cast to non-null type kotlin.Int");
                                        AppMethodBeat.o(241090);
                                        throw tVar45;
                                    }
                                    ejf.Gze = ((Integer) obj45).intValue();
                                    ejf.NiP = new aeo();
                                    ejf.NiP.LpR = new dlh();
                                    ejf.NiP.LpR.Msu = new LinkedList<>();
                                    Object obj46 = hashMap3.get("cropInfo");
                                    if (obj46 == null) {
                                        t tVar46 = new t("null cannot be cast to non-null type kotlin.collections.HashMap<*, *> /* = java.util.HashMap<*, *> */");
                                        AppMethodBeat.o(241090);
                                        throw tVar46;
                                    }
                                    HashMap hashMap4 = (HashMap) obj46;
                                    LinkedList<Integer> linkedList2 = ejf.NiP.LpR.Msu;
                                    Object obj47 = hashMap4.get("left");
                                    if (obj47 == null) {
                                        t tVar47 = new t("null cannot be cast to non-null type kotlin.Int");
                                        AppMethodBeat.o(241090);
                                        throw tVar47;
                                    }
                                    linkedList2.add((Integer) obj47);
                                    LinkedList<Integer> linkedList3 = ejf.NiP.LpR.Msu;
                                    Object obj48 = hashMap4.get("top");
                                    if (obj48 == null) {
                                        t tVar48 = new t("null cannot be cast to non-null type kotlin.Int");
                                        AppMethodBeat.o(241090);
                                        throw tVar48;
                                    }
                                    linkedList3.add((Integer) obj48);
                                    LinkedList<Integer> linkedList4 = ejf.NiP.LpR.Msu;
                                    Object obj49 = hashMap4.get("width");
                                    if (obj49 == null) {
                                        t tVar49 = new t("null cannot be cast to non-null type kotlin.Int");
                                        AppMethodBeat.o(241090);
                                        throw tVar49;
                                    }
                                    linkedList4.add((Integer) obj49);
                                    LinkedList<Integer> linkedList5 = ejf.NiP.LpR.Msu;
                                    Object obj50 = hashMap4.get("height");
                                    if (obj50 == null) {
                                        t tVar50 = new t("null cannot be cast to non-null type kotlin.Int");
                                        AppMethodBeat.o(241090);
                                        throw tVar50;
                                    }
                                    linkedList5.add((Integer) obj50);
                                    ejf.NiP.LpT = new dlh();
                                    ejf.NiP.LpT.Msu = new LinkedList<>();
                                    Object obj51 = hashMap3.get("contentInfo");
                                    if (obj51 == null) {
                                        t tVar51 = new t("null cannot be cast to non-null type kotlin.collections.HashMap<*, *> /* = java.util.HashMap<*, *> */");
                                        AppMethodBeat.o(241090);
                                        throw tVar51;
                                    }
                                    HashMap hashMap5 = (HashMap) obj51;
                                    LinkedList<Integer> linkedList6 = ejf.NiP.LpT.Msu;
                                    Object obj52 = hashMap5.get("left");
                                    if (obj52 == null) {
                                        t tVar52 = new t("null cannot be cast to non-null type kotlin.Int");
                                        AppMethodBeat.o(241090);
                                        throw tVar52;
                                    }
                                    linkedList6.add((Integer) obj52);
                                    LinkedList<Integer> linkedList7 = ejf.NiP.LpT.Msu;
                                    Object obj53 = hashMap5.get("top");
                                    if (obj53 == null) {
                                        t tVar53 = new t("null cannot be cast to non-null type kotlin.Int");
                                        AppMethodBeat.o(241090);
                                        throw tVar53;
                                    }
                                    linkedList7.add((Integer) obj53);
                                    LinkedList<Integer> linkedList8 = ejf.NiP.LpT.Msu;
                                    Object obj54 = hashMap5.get("right");
                                    if (obj54 == null) {
                                        t tVar54 = new t("null cannot be cast to non-null type kotlin.Int");
                                        AppMethodBeat.o(241090);
                                        throw tVar54;
                                    }
                                    linkedList8.add((Integer) obj54);
                                    LinkedList<Integer> linkedList9 = ejf.NiP.LpT.Msu;
                                    Object obj55 = hashMap5.get("bottom");
                                    if (obj55 == null) {
                                        t tVar55 = new t("null cannot be cast to non-null type kotlin.Int");
                                        AppMethodBeat.o(241090);
                                        throw tVar55;
                                    }
                                    linkedList9.add((Integer) obj55);
                                    ejf.NiP.LpU = new dlh();
                                    ejf.NiP.LpU.Msu = new LinkedList<>();
                                    Object obj56 = hashMap3.get("trackCropInfo");
                                    if (obj56 == null) {
                                        t tVar56 = new t("null cannot be cast to non-null type kotlin.collections.HashMap<*, *> /* = java.util.HashMap<*, *> */");
                                        AppMethodBeat.o(241090);
                                        throw tVar56;
                                    }
                                    HashMap hashMap6 = (HashMap) obj56;
                                    LinkedList<Integer> linkedList10 = ejf.NiP.LpU.Msu;
                                    Object obj57 = hashMap6.get("left");
                                    if (obj57 == null) {
                                        t tVar57 = new t("null cannot be cast to non-null type kotlin.Int");
                                        AppMethodBeat.o(241090);
                                        throw tVar57;
                                    }
                                    linkedList10.add((Integer) obj57);
                                    LinkedList<Integer> linkedList11 = ejf.NiP.LpU.Msu;
                                    Object obj58 = hashMap6.get("top");
                                    if (obj58 == null) {
                                        t tVar58 = new t("null cannot be cast to non-null type kotlin.Int");
                                        AppMethodBeat.o(241090);
                                        throw tVar58;
                                    }
                                    linkedList11.add((Integer) obj58);
                                    LinkedList<Integer> linkedList12 = ejf.NiP.LpU.Msu;
                                    Object obj59 = hashMap6.get("right");
                                    if (obj59 == null) {
                                        t tVar59 = new t("null cannot be cast to non-null type kotlin.Int");
                                        AppMethodBeat.o(241090);
                                        throw tVar59;
                                    }
                                    linkedList12.add((Integer) obj59);
                                    LinkedList<Integer> linkedList13 = ejf.NiP.LpU.Msu;
                                    Object obj60 = hashMap6.get("bottom");
                                    if (obj60 == null) {
                                        t tVar60 = new t("null cannot be cast to non-null type kotlin.Int");
                                        AppMethodBeat.o(241090);
                                        throw tVar60;
                                    }
                                    linkedList13.add((Integer) obj60);
                                    ejf.NiP.LpS = new dlh();
                                    ejf.NiP.LpS.Msu = new LinkedList<>();
                                    ejf.NiP.LpS.Msu.add(0);
                                    ejf.NiP.LpS.Msu.add(0);
                                    ejf.NiP.LpS.Msu.add(0);
                                    ejf.NiP.LpS.Msu.add(0);
                                    ejf.NiP.LpQ = new cmv();
                                    ejf.NiP.LpQ.Msu = new LinkedList<>();
                                    ejf.NiP.LpQ.Msu.add(Float.valueOf(1.63f));
                                    ejf.NiP.LpQ.Msu.add(Float.valueOf(0.0f));
                                    ejf.NiP.LpQ.Msu.add(Float.valueOf(0.0f));
                                    ejf.NiP.LpQ.Msu.add(Float.valueOf(0.0f));
                                    ejf.NiP.LpQ.Msu.add(Float.valueOf(1.63f));
                                    ejf.NiP.LpQ.Msu.add(Float.valueOf(-12.833f));
                                    ejf.NiP.LpQ.Msu.add(Float.valueOf(0.0f));
                                    ejf.NiP.LpQ.Msu.add(Float.valueOf(0.0f));
                                    ejf.NiP.LpQ.Msu.add(Float.valueOf(1.0f));
                                }
                                acn.Lnd.add(ejf);
                            }
                        }
                        AppMethodBeat.o(241090);
                    }

                    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/flutter/plugins/video/api/MMVideoEditorJumpToPostUI$Companion;", "", "()V", "compositionInfo2", "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$CompositionInfo;", "getCompositionInfo2", "()Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$CompositionInfo;", "setCompositionInfo2", "(Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$CompositionInfo;)V", "cp", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "getCp", "()Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "setCp", "(Lcom/tencent/mm/protocal/protobuf/CompositionInfo;)V", "thumb", "Landroid/graphics/Bitmap;", "getThumb", "()Landroid/graphics/Bitmap;", "setThumb", "(Landroid/graphics/Bitmap;)V", "plugin-flutter_release"})
                    public static final class a {
                        private a() {
                        }

                        public /* synthetic */ a(byte b2) {
                            this();
                        }
                    }
                }
