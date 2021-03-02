package com.tencent.mm.plugin.vlog.model;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Pair;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.d;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.o;
import com.tencent.mm.plugin.vlog.model.local.a;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.protocal.protobuf.aip;
import com.tencent.mm.protocal.protobuf.aiq;
import com.tencent.mm.protocal.protobuf.clz;
import com.tencent.mm.protocal.protobuf.cmv;
import com.tencent.mm.protocal.protobuf.dlh;
import com.tencent.mm.protocal.protobuf.ecy;
import com.tencent.mm.protocal.protobuf.ejf;
import com.tencent.mm.protocal.protobuf.ekn;
import com.tencent.mm.protocal.protobuf.eqy;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.mm.videocomposition.k;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.aa;
import com.tencent.mm.xeffect.effect.ad;
import com.tencent.mm.xeffect.effect.f;
import com.tencent.mm.xeffect.effect.h;
import com.tencent.mm.xeffect.effect.r;
import com.tencent.mm.xeffect.effect.u;
import com.tencent.mm.xeffect.effect.v;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¸\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u001a\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0016\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0015\u001a\u0016\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018\u001a\u0016\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b\u001a\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\b\u001a \u0010\u001e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002\u001a\u0016\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018\u001a\u0016\u0010 \u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0014\u001a\u0016\u0010!\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018\u001a\u0016\u0010\"\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020#2\u0006\u0010$\u001a\u00020%\u001a\u0016\u0010&\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018\u001a\u0016\u0010'\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020(2\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u0016\u0010)\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020*2\u0006\u0010+\u001a\u00020,\u001a\u0016\u0010-\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0018\u001a\u001e\u0010.\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\n\u001a\u0016\u0010/\u001a\u00020\u00062\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0010\u001a\u00020#\u001a\u0014\u00100\u001a\u00020\u00062\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000402\u001a\"\u00103\u001a\b\u0012\u0004\u0012\u00020\u000f042\u0006\u00105\u001a\u0002062\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000f04\u001a\u001c\u00108\u001a\u0002092\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000f042\u0006\u0010;\u001a\u000209\u001a\u0016\u0010<\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020(\u001a\u0016\u0010=\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0010\u001a\u00020*\u001a\u000e\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A\u001a\n\u0010B\u001a\u00020\u0001*\u00020\u0001\u001a\u0014\u0010C\u001a\u0004\u0018\u00010\u000f*\u00020\n2\u0006\u0010D\u001a\u00020E\u001a\n\u0010F\u001a\u00020G*\u00020H\"\u000e\u0010\u0000\u001a\u00020\u0001XD¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, hxF = {"TAG", "", "externalStickerEffectList", "", "Lcom/tencent/mm/protocal/protobuf/StickerEffectProto;", "clearStickerEffectList", "", "compositionToProto", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "outputConfig", "Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "cropInfoToProto", FFmpegMetadataRetriever.METADATA_KEY_TRACK, "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "proto", "Lcom/tencent/mm/protocal/protobuf/CropInfoProto;", "matrixToProto", "matrix", "Landroid/graphics/Matrix;", "Lcom/tencent/mm/protocal/protobuf/MatrixProto;", "protoToComposition", "effectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "protoToCropInfo", "cropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "protoToFrameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameSeeker;", "protoToImageEnhancementEffect", "protoToMagic", "protoToMatrix", "protoToPagSticker", "protoToRect", "Lcom/tencent/mm/protocal/protobuf/RectProto;", "rect", "Landroid/graphics/Rect;", "protoToSticker", "protoToTrack", "Lcom/tencent/mm/protocal/protobuf/TrackInfoProto;", "protoToTransitionInfo", "Lcom/tencent/mm/protocal/protobuf/TransitionInfoProto;", "transition", "Lcom/tencent/mm/videocomposition/TrackTransition;", "protoToVLogEffectMgr", "protoToVideoTemplate", "rectToProto", "saveStickerEffectList", "stickers", "", "scriptToTrackList", "", "script", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "sourceTrackList", "selectCompositionOutputFpsByTrackList", "", "trackList", "targetFps", "trackToProto", "transitionInfoToProto", "videoTemplateToProto", "Lcom/tencent/mm/protocal/protobuf/VideoTemplateInfoProto;", "videoTemplate", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", DownloadInfo.FILENAME, "getTrackByTimeMs", "timeMs", "", "toInputTexture", "Lcom/tencent/mm/xeffect/InputTexture;", "Lcom/tencent/tav/coremedia/TextureInfo;", "plugin-vlog_release"})
public final class i {
    private static final List<ecy> GxM = new ArrayList();
    private static final String TAG = TAG;

    static {
        AppMethodBeat.i(190560);
        AppMethodBeat.o(190560);
    }

    public static final String aTT(String str) {
        int i2;
        AppMethodBeat.i(190543);
        p.h(str, "$this$fileName");
        String str2 = str;
        int length = str2.length() - 1;
        while (true) {
            if (length < 0) {
                i2 = -1;
                break;
            }
            if (str2.charAt(length) == '/') {
                i2 = length;
                break;
            }
            length--;
        }
        String substring = str.substring(i2 + 1);
        p.g(substring, "(this as java.lang.String).substring(startIndex)");
        AppMethodBeat.o(190543);
        return substring;
    }

    public static final void p(Collection<? extends ecy> collection) {
        AppMethodBeat.i(190544);
        p.h(collection, "stickers");
        GxM.clear();
        GxM.addAll(collection);
        AppMethodBeat.o(190544);
    }

    public static final void a(Rect rect, dlh dlh) {
        AppMethodBeat.i(190545);
        p.h(rect, "rect");
        p.h(dlh, "proto");
        dlh.Msu.clear();
        dlh.Msu.add(Integer.valueOf(rect.left));
        dlh.Msu.add(Integer.valueOf(rect.top));
        dlh.Msu.add(Integer.valueOf(rect.right));
        dlh.Msu.add(Integer.valueOf(rect.bottom));
        AppMethodBeat.o(190545);
    }

    public static final void a(dlh dlh, Rect rect) {
        AppMethodBeat.i(190546);
        p.h(dlh, "proto");
        p.h(rect, "rect");
        if (dlh.Msu.size() == 4) {
            Integer num = dlh.Msu.get(0);
            p.g(num, "proto.values[0]");
            int intValue = num.intValue();
            Integer num2 = dlh.Msu.get(1);
            p.g(num2, "proto.values[1]");
            int intValue2 = num2.intValue();
            Integer num3 = dlh.Msu.get(2);
            p.g(num3, "proto.values[2]");
            int intValue3 = num3.intValue();
            Integer num4 = dlh.Msu.get(3);
            p.g(num4, "proto.values[3]");
            rect.set(intValue, intValue2, intValue3, num4.intValue());
        }
        AppMethodBeat.o(190546);
    }

    private static void a(ejf ejf, ad adVar) {
        AppMethodBeat.i(190548);
        p.h(ejf, "proto");
        p.h(adVar, FFmpegMetadataRetriever.METADATA_KEY_TRACK);
        adVar.KO(ejf.startTimeMs);
        adVar.KP(ejf.endTimeMs);
        adVar.KQ(ejf.GGz);
        adVar.KR(ejf.GGA);
        adVar.Gzu = ejf.Gzu;
        adVar.Gzv = ejf.Gzv;
        adVar.Gzw = ejf.Gzw;
        adVar.setVolume(ejf.volume);
        aeo aeo = ejf.NiP;
        if (aeo != null) {
            j jVar = adVar.Gzx;
            p.h(aeo, "proto");
            p.h(jVar, "cropInfo");
            cmv cmv = aeo.LpQ;
            if (cmv != null) {
                Matrix matrix = jVar.gT;
                p.h(cmv, "proto");
                p.h(matrix, "matrix");
                if (cmv.Msu.size() == 9) {
                    LinkedList<Float> linkedList = cmv.Msu;
                    p.g(linkedList, "proto.values");
                    matrix.setValues(j.t((Collection<Float>) linkedList));
                }
            }
            dlh dlh = aeo.LpT;
            if (dlh != null) {
                a(dlh, jVar.rwL);
            }
            dlh dlh2 = aeo.LpR;
            if (dlh2 != null) {
                a(dlh2, jVar.iiw);
            }
            dlh dlh3 = aeo.LpS;
            if (dlh3 != null) {
                a(dlh3, jVar.viewRect);
            }
        }
        adVar.GzA.iiw.set(adVar.Gzx.rwL);
        ekn ekn = ejf.NiQ;
        if (ekn != null) {
            k kVar = adVar.GzA.Rhc;
            p.h(ekn, "proto");
            p.h(kVar, "transition");
            String str = ekn.path;
            p.g(str, "proto.path");
            kVar.setPath(str);
            kVar.duration = ekn.duration;
        }
        aeo aeo2 = ejf.NiP;
        if (aeo2 != null) {
            dlh dlh4 = aeo2.LpU;
            p.g(dlh4, "it.trackCropRect");
            a(dlh4, adVar.GzA.Rha);
            AppMethodBeat.o(190548);
            return;
        }
        AppMethodBeat.o(190548);
    }

    private static void a(acn acn, EffectManager effectManager) {
        ad adVar;
        AppMethodBeat.i(190550);
        p.h(acn, "proto");
        p.h(effectManager, "effectMgr");
        LinkedList<ecy> linkedList = acn.Lnl;
        p.g(linkedList, "proto.stickerEffectList");
        for (ecy ecy : j.b((Collection) linkedList, (Iterable) GxM)) {
            String str = ecy.path;
            if (!(str == null || str.length() == 0)) {
                com.tencent.mm.xeffect.effect.j jVar = com.tencent.mm.xeffect.effect.j.StickerEffect;
                String str2 = ecy.path;
                p.g(str2, "effectProto.path");
                adVar = effectManager.a(jVar, str2);
            } else if (ecy.Ndn != null) {
                com.tencent.mm.xeffect.effect.j jVar2 = com.tencent.mm.xeffect.effect.j.StickerEffect;
                b bVar = ecy.Ndn;
                p.g(bVar, "effectProto.bytes");
                byte[] bArr = bVar.zy;
                p.g(bArr, "effectProto.bytes.bytes");
                adVar = effectManager.a(jVar2, bArr);
            } else {
                adVar = null;
            }
            if (!(adVar instanceof aa)) {
                adVar = null;
            }
            aa aaVar = (aa) adVar;
            if (aaVar != null) {
                aiq aiq = ecy.Ndo;
                aip aip = ecy.Ndp;
                aaVar.aH(aiq.startTimeMs, aiq.endTimeMs);
                aaVar.a(new f(aip.centerX, aip.centerY, aip.scale, aip.mat));
                if (!(ecy.width == 0 || ecy.height == 0)) {
                    aaVar.setSize(ecy.width, ecy.height);
                }
                effectManager.a(aaVar);
            }
        }
        AppMethodBeat.o(190550);
    }

    private static void b(acn acn, EffectManager effectManager) {
        ad a2;
        Size size;
        long j2;
        AppMethodBeat.i(190551);
        p.h(acn, "proto");
        p.h(effectManager, "effectMgr");
        LinkedList<jn> linkedList = acn.Gxx.Lna;
        p.g(linkedList, "proto.editData.baseItemData");
        ArrayList<jn> arrayList = new ArrayList();
        for (T t : linkedList) {
            if (t.dataType == d.PAG_STICKER.value) {
                arrayList.add(t);
            }
        }
        for (jn jnVar : arrayList) {
            p.g(jnVar, LocaleUtil.ITALIAN);
            o oVar = new o(jnVar);
            if (n.J(oVar.Cga, "assets://", false)) {
                com.tencent.mm.xeffect.effect.j jVar = com.tencent.mm.xeffect.effect.j.PAGTextEffect;
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                AssetManager assets = context.getAssets();
                p.g(assets, "MMApplicationContext.getContext().assets");
                a2 = effectManager.a(jVar, assets, oVar.Cga);
            } else {
                a2 = effectManager.a(com.tencent.mm.xeffect.effect.j.PAGTextEffect, oVar.Cga);
            }
            effectManager.a(a2);
            v vVar = (v) (!(a2 instanceof v) ? null : a2);
            if (vVar != null) {
                vVar.aH(oVar.Cev.getStart(), oVar.Cev.getEnd());
                vVar.a(new f((int) oVar.centerX, (int) oVar.centerY, oVar.scale, oVar.mat));
                vVar.a(new h(oVar.text, null, 30));
            }
            r rVar = (r) (!(a2 instanceof r) ? null : a2);
            if (rVar == null || (size = rVar.ApT) == null) {
                size = new Size(0, 0);
            }
            oVar.width = size.getWidth();
            oVar.height = size.getHeight();
            Rect rect = new Rect();
            dlh dlh = acn.Gxx.LmZ;
            p.g(dlh, "proto.editData.drawingRect");
            a(dlh, rect);
            oVar.Cgb.set(rect);
            oVar.g(oVar.gT);
            if (a2 != null) {
                j2 = a2.id;
            } else {
                j2 = 0;
            }
            oVar.wKD = j2;
        }
        AppMethodBeat.o(190551);
    }

    private static void c(acn acn, EffectManager effectManager) {
        ad a2;
        AppMethodBeat.i(190552);
        p.h(acn, "proto");
        p.h(effectManager, "effectMgr");
        LinkedList<clz> linkedList = acn.Lnh;
        p.g(linkedList, "proto.magicInfoList");
        for (T t : linkedList) {
            String str = t.path;
            p.g(str, "it.path");
            if (n.J(str, "assets://", false)) {
                com.tencent.mm.xeffect.effect.j jVar = com.tencent.mm.xeffect.effect.j.PAGGlobalAnimateEffect;
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                AssetManager assets = context.getAssets();
                p.g(assets, "MMApplicationContext.getContext().assets");
                String str2 = t.path;
                p.g(str2, "it.path");
                a2 = effectManager.a(jVar, assets, str2);
            } else {
                com.tencent.mm.xeffect.effect.j jVar2 = com.tencent.mm.xeffect.effect.j.PAGGlobalAnimateEffect;
                String str3 = t.path;
                p.g(str3, "it.path");
                a2 = effectManager.a(jVar2, str3);
            }
            if (a2 != null) {
                a2.aH(t.start, t.boX);
            }
            effectManager.a(a2);
        }
        AppMethodBeat.o(190552);
    }

    public static final acn a(ac acVar, aco aco) {
        AppMethodBeat.i(190553);
        p.h(acVar, "composition");
        p.h(aco, "outputConfig");
        acn acn = new acn();
        acn.Lne = acVar.Gez.hfo().getStartUs() / 1000;
        acn.Lnf = acVar.Gez.hfo().getEndUs() / 1000;
        LinkedList<ejf> linkedList = acn.Lnd;
        ArrayList<ad> arrayList = acVar.Gzn;
        ArrayList arrayList2 = new ArrayList(j.a(arrayList, 10));
        for (T t : arrayList) {
            ejf ejf = new ejf();
            a(t, ejf);
            ejf.Gze = t.Gze;
            arrayList2.add(ejf);
        }
        linkedList.addAll(arrayList2);
        acn.Gzo = acVar.Gzo;
        acn.Lng = true;
        acn.Gxw = aco;
        acn.iiv = acVar.iiv;
        acn.Gzp = acVar.Gzp;
        acn.Lnj = new LinkedList<>();
        a aVar = a.GAD;
        for (Map.Entry<String, Pair<Integer, Long>> entry : a.fBS().entrySet()) {
            acp acp = new acp();
            acp.path = entry.getKey();
            Object obj = entry.getValue().first;
            p.g(obj, "it.value.first");
            acp.label = ((Number) obj).intValue();
            Object obj2 = entry.getValue().second;
            p.g(obj2, "it.value.second");
            acp.Lns = ((Number) obj2).longValue();
            acn.Lnj.add(acp);
        }
        AppMethodBeat.o(190553);
        return acn;
    }

    public static final ac d(acn acn, EffectManager effectManager) {
        AppMethodBeat.i(190554);
        p.h(acn, "proto");
        p.h(effectManager, "effectMgr");
        LinkedList linkedList = new LinkedList();
        LinkedList<ejf> linkedList2 = acn.Lnd;
        p.g(linkedList2, "proto.tracks");
        LinkedList<ejf> linkedList3 = linkedList2;
        ArrayList arrayList = new ArrayList(j.a(linkedList3, 10));
        for (T t : linkedList3) {
            String str = t.path;
            p.g(str, "it.path");
            ad adVar = new ad(str, t.type);
            p.g(t, LocaleUtil.ITALIAN);
            a(t, adVar);
            arrayList.add(adVar);
        }
        linkedList.addAll(arrayList);
        ac acVar = new ac(linkedList);
        acVar.getComposition().lW(acn.Gxw.xlg, acn.Gxw.xlh);
        acVar.at(acn.Lne, acn.Lnf);
        if (!Util.isNullOrNil(acn.iiv)) {
            String str2 = acn.iiv;
            p.g(str2, "proto.musicPath");
            acVar.cB(str2, true);
        }
        acVar.wB(acn.Gzo);
        Rect rect = new Rect();
        dlh dlh = acn.Gxw.Lnm;
        p.g(dlh, "proto.outputConfig.originRect");
        a(dlh, rect);
        acVar.q(rect);
        a(acVar, effectManager);
        a(acn, effectManager);
        b(acn, effectManager);
        c(acn, effectManager);
        a(acn, effectManager, acVar);
        acVar.Gzp = acn.Gzp;
        if (acVar.Gzp) {
            a(acVar, acn, effectManager);
        }
        AppMethodBeat.o(190554);
        return acVar;
    }

    private static final void a(ac acVar, acn acn, EffectManager effectManager) {
        AppMethodBeat.i(190555);
        HashMap hashMap = new HashMap();
        LinkedList<acp> linkedList = acn.Lnj;
        p.g(linkedList, "proto.trackLabelInfoList");
        for (T t : linkedList) {
            String str = t.path;
            p.g(str, "it.path");
            hashMap.put(str, Integer.valueOf(t.label));
        }
        ad a2 = effectManager.a(com.tencent.mm.xeffect.effect.j.ImageEnhanceEffect);
        if (!(a2 instanceof com.tencent.mm.xeffect.effect.n)) {
            a2 = null;
        }
        com.tencent.mm.xeffect.effect.n nVar = (com.tencent.mm.xeffect.effect.n) a2;
        if (nVar != null) {
            nVar.aH(acVar.Gez.getPlayStart(), acVar.Gez.fBz());
        }
        effectManager.a(nVar);
        if ((MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_SHOW_IMAGE_ENHANCEMENT_FACE_LANDMARKS_INT_SYNC", 0) == 1) && nVar != null) {
            nVar.DL(true);
        }
        com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b bVar = com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.GLF;
        com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.a(nVar);
        acVar.a(new ai(acVar, hashMap, nVar));
        AppMethodBeat.o(190555);
    }

    public static final c d(acn acn) {
        AppMethodBeat.i(190556);
        p.h(acn, "proto");
        e eVar = e.BKp;
        LinkedList<jn> linkedList = acn.Gxx.Lna;
        p.g(linkedList, "proto.editData.baseItemData");
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> a2 = e.a(linkedList, context);
        LinkedList<Integer> linkedList2 = acn.Gxx.LmZ.Msu;
        p.g(linkedList2, "proto.editData.drawingRect.values");
        LinkedList<Integer> linkedList3 = linkedList2;
        ArrayList arrayList = new ArrayList(j.a(linkedList3, 10));
        Iterator<T> it = linkedList3.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf((float) it.next().intValue()));
        }
        float[] t = j.t((Collection<Float>) arrayList);
        dlh dlh = acn.Gxx.Lnc;
        if (dlh != null) {
            LinkedList<Integer> linkedList4 = dlh.Msu;
            p.g(linkedList4, "rectProto.values");
            LinkedList<Integer> linkedList5 = linkedList4;
            ArrayList arrayList2 = new ArrayList(j.a(linkedList5, 10));
            Iterator<T> it2 = linkedList5.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Float.valueOf((float) it2.next().intValue()));
            }
            j.t((Collection<Float>) arrayList2);
        }
        com.tencent.mm.plugin.recordvideo.ui.editor.b.f fVar = new com.tencent.mm.plugin.recordvideo.ui.editor.b.f(t, a2, acn.Gxw.xlg, acn.Gxw.xlh);
        AppMethodBeat.o(190556);
        return fVar;
    }

    public static final eqy b(a.c cVar) {
        AppMethodBeat.i(190557);
        p.h(cVar, "videoTemplate");
        eqy eqy = new eqy();
        eqy.IFw = cVar.path;
        String str = com.tencent.mm.loader.j.b.aKB() + System.currentTimeMillis() + ".mp3";
        s.nw(cVar.iiv, str);
        eqy.iiv = str;
        eqy.duration = cVar.duration;
        eqy.GAH = cVar.GAH;
        AppMethodBeat.o(190557);
        return eqy;
    }

    private static void a(acn acn, EffectManager effectManager, ac acVar) {
        ad a2;
        ad adVar;
        Size size;
        ad adVar2;
        int i2;
        long j2;
        AppMethodBeat.i(190558);
        p.h(acn, "proto");
        p.h(effectManager, "effectMgr");
        p.h(acVar, "composition");
        if (acn.Lni != null) {
            String str = acn.Lni.IFw;
            p.g(str, "proto.videoTemplate.templatePath");
            if (n.J(str, "assets://", false)) {
                com.tencent.mm.xeffect.effect.j jVar = com.tencent.mm.xeffect.effect.j.PAGVideoTemplateEffect;
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                AssetManager assets = context.getAssets();
                p.g(assets, "MMApplicationContext.getContext().assets");
                String str2 = acn.Lni.IFw;
                p.g(str2, "proto.videoTemplate.templatePath");
                a2 = effectManager.a(jVar, assets, str2);
            } else {
                com.tencent.mm.xeffect.effect.j jVar2 = com.tencent.mm.xeffect.effect.j.PAGVideoTemplateEffect;
                String str3 = acn.Lni.IFw;
                p.g(str3, "proto.videoTemplate.templatePath");
                a2 = effectManager.a(jVar2, str3);
            }
            effectManager.a(a2);
            if (!(a2 instanceof u)) {
                adVar = null;
            } else {
                adVar = a2;
            }
            u uVar = (u) adVar;
            if (uVar == null || (size = uVar.ApT) == null) {
                size = new Size(0, 0);
            }
            if (!(a2 instanceof u)) {
                adVar2 = null;
            } else {
                adVar2 = a2;
            }
            u uVar2 = (u) adVar2;
            if (uVar2 != null) {
                i2 = uVar2.RyV;
            } else {
                i2 = 0;
            }
            String str4 = acn.Lni.IFw;
            p.g(str4, "proto.videoTemplate.templatePath");
            String str5 = acn.Lni.iiv;
            p.g(str5, "proto.videoTemplate.musicPath");
            a.c cVar = new a.c(str4, str5, size, acn.Lni.duration, i2, acn.Lni.GAH);
            effectManager.hiv();
            if (a2 != null) {
                a2.aH(0, cVar.duration);
            }
            if (a2 != null) {
                j2 = a2.id;
            } else {
                j2 = 0;
            }
            cVar.GAI = j2;
            String str6 = acn.Lni.iiv;
            p.g(str6, "proto.videoTemplate.musicPath");
            ac.a(acVar, str6);
            Iterator<T> it = acVar.Gzn.iterator();
            while (it.hasNext()) {
                it.next().GzA.Rhb = false;
            }
        }
        AppMethodBeat.o(190558);
    }

    private static void a(ad adVar, ejf ejf) {
        AppMethodBeat.i(190547);
        p.h(adVar, FFmpegMetadataRetriever.METADATA_KEY_TRACK);
        p.h(ejf, "proto");
        ejf.path = adVar.path;
        ejf.type = adVar.type;
        ejf.startTimeMs = adVar.GzA.startTimeMs;
        ejf.endTimeMs = adVar.GzA.endTimeMs;
        ejf.GGz = adVar.GzA.GGz;
        ejf.GGA = adVar.GzA.GGA;
        ejf.GJB = adVar.GzA.GJB;
        ejf.Gzu = adVar.Gzu;
        ejf.Gzv = adVar.Gzv;
        ejf.Gzw = adVar.Gzw;
        ejf.volume = adVar.GzA.volume;
        ejf.NiP = new aeo();
        aeo aeo = ejf.NiP;
        p.g(aeo, "proto.cropInfo");
        p.h(adVar, FFmpegMetadataRetriever.METADATA_KEY_TRACK);
        p.h(aeo, "proto");
        aeo.LpQ = new cmv();
        aeo.LpT = new dlh();
        aeo.LpR = new dlh();
        aeo.LpS = new dlh();
        aeo.LpU = new dlh();
        Matrix matrix = adVar.Gzx.gT;
        cmv cmv = aeo.LpQ;
        p.g(cmv, "proto.matrix");
        p.h(matrix, "matrix");
        p.h(cmv, "proto");
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        cmv.Msu.clear();
        for (int i2 = 0; i2 < 9; i2++) {
            cmv.Msu.add(Float.valueOf(fArr[i2]));
        }
        Rect rect = adVar.Gzx.rwL;
        dlh dlh = aeo.LpT;
        p.g(dlh, "proto.contentRect");
        a(rect, dlh);
        Rect rect2 = adVar.Gzx.iiw;
        dlh dlh2 = aeo.LpR;
        p.g(dlh2, "proto.cropRect");
        a(rect2, dlh2);
        Rect rect3 = adVar.Gzx.viewRect;
        dlh dlh3 = aeo.LpS;
        p.g(dlh3, "proto.viewRect");
        a(rect3, dlh3);
        Rect rect4 = adVar.GzA.Rha;
        dlh dlh4 = aeo.LpU;
        p.g(dlh4, "proto.trackCropRect");
        a(rect4, dlh4);
        ejf.NiQ = new ekn();
        k kVar = adVar.GzA.Rhc;
        ekn ekn = ejf.NiQ;
        p.g(ekn, "proto.transitionInfo");
        p.h(kVar, "transition");
        p.h(ekn, "proto");
        ekn.path = kVar.path;
        ekn.duration = kVar.duration;
        AppMethodBeat.o(190547);
    }

    private static void a(ac acVar, EffectManager effectManager) {
        ad a2;
        AppMethodBeat.i(190549);
        p.h(acVar, "composition");
        p.h(effectManager, "effectMgr");
        for (T t : acVar.Gzn) {
            if (t.fBG()) {
                if (n.J(t.fBH(), "assets://", false)) {
                    com.tencent.mm.xeffect.effect.j jVar = com.tencent.mm.xeffect.effect.j.PAGTransitionEffect;
                    Context context = MMApplicationContext.getContext();
                    p.g(context, "MMApplicationContext.getContext()");
                    AssetManager assets = context.getAssets();
                    p.g(assets, "MMApplicationContext.getContext().assets");
                    a2 = effectManager.a(jVar, assets, t.fBH());
                } else {
                    a2 = effectManager.a(com.tencent.mm.xeffect.effect.j.PAGTransitionEffect, t.fBH());
                }
                t.GzA.Rhc.GAn = a2;
                effectManager.a(a2);
            }
        }
        acVar.a(effectManager);
        AppMethodBeat.o(190549);
    }

    public static final ad a(ac acVar, long j2) {
        T t;
        boolean z;
        AppMethodBeat.i(190559);
        p.h(acVar, "$this$getTrackByTimeMs");
        Iterator<T> it = acVar.Gzn.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            T t2 = next;
            if (t2.GzA.startTimeMs > j2 || t2.GzA.endTimeMs <= j2) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                t = next;
                break;
            }
        }
        T t3 = t;
        AppMethodBeat.o(190559);
        return t3;
    }
}
