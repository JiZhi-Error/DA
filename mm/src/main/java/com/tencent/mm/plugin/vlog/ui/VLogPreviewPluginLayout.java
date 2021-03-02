package com.tencent.mm.plugin.vlog.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.recordvideo.b.i;
import com.tencent.mm.plugin.recordvideo.e.d;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.plugin.f;
import com.tencent.mm.plugin.recordvideo.plugin.h;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.model.ae;
import com.tencent.mm.plugin.vlog.model.ah;
import com.tencent.mm.plugin.vlog.model.al;
import com.tencent.mm.plugin.vlog.model.s;
import com.tencent.mm.plugin.vlog.ui.manager.a;
import com.tencent.mm.plugin.vlog.ui.plugin.ag;
import com.tencent.mm.plugin.vlog.ui.preview.VLogPreloadPlayView;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.bha;
import com.tencent.mm.protocal.protobuf.erh;
import com.tencent.mm.protocal.protobuf.ln;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0010H\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\u001c\u0010 \u001a\u00020\u00132\b\b\u0002\u0010!\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020\u0011H\u0002J\u001a\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R&\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/VLogPreviewPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "previewPlayerPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogPreviewPlayerPlugin;", "vLogDataManager", "Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "vLogGenerateManager", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager;", "videoGenerateCallback", "Lkotlin/Function3;", "", "", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$VLogOutputInfo;", "", "getPlayerView", "Landroid/view/View;", "initLogic", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "loadCurrentPage", "model", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onBackPress", "release", "requestVLogScript", "sid", "fid", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-vlog_release"})
public final class VLogPreviewPluginLayout extends BaseEditVideoPluginLayout implements d {
    public static final a GFM = new a((byte) 0);
    private q<? super Boolean, ? super Integer, ? super a.b, x> GFI;
    private ag GFJ;
    private com.tencent.mm.plugin.vlog.ui.manager.a GFK;
    private final ae GFL = com.tencent.mm.plugin.vlog.ui.manager.c.fCM();

    static {
        AppMethodBeat.i(111121);
        AppMethodBeat.o(111121);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "invoke"})
    public static final class b extends kotlin.g.b.q implements kotlin.g.a.b<bha, x> {
        final /* synthetic */ VLogPreviewPluginLayout GFN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(VLogPreviewPluginLayout vLogPreviewPluginLayout) {
            super(1);
            this.GFN = vLogPreviewPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(bha bha) {
            AppMethodBeat.i(111112);
            Log.i("MicroMsg.VLogPreviewPluginLayout", "requestVLogScript finish ,size:".concat(String.valueOf(bha)));
            VLogPreviewPluginLayout.a(this.GFN);
            this.GFN.a(d.c.BVY, (Bundle) null);
            x xVar = x.SXb;
            AppMethodBeat.o(111112);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "success", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "", "model", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$VLogOutputInfo;", "invoke"})
    static final class c extends kotlin.g.b.q implements q<Boolean, Integer, a.b, x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ VLogPreviewPluginLayout GFN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(VLogPreviewPluginLayout vLogPreviewPluginLayout, Context context) {
            super(3);
            this.GFN = vLogPreviewPluginLayout;
            this.$context = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ x d(Boolean bool, Integer num, a.b bVar) {
            int i2;
            AppMethodBeat.i(111113);
            boolean booleanValue = bool.booleanValue();
            int intValue = num.intValue();
            a.b bVar2 = bVar;
            p.h(bVar2, "model");
            Log.i("MicroMsg.VLogPreviewPluginLayout", "videoGenerateCallback success:" + booleanValue + "  errorCode:" + intValue + " model:" + bVar2);
            VLogPreviewPluginLayout.a(this.GFN);
            if (booleanValue) {
                SightVideoJNI.optimizeMP4VFS(bVar2.videoPath);
                com.tencent.mm.plugin.recordvideo.e.c cVar = com.tencent.mm.plugin.recordvideo.e.c.Cic;
                com.tencent.mm.plugin.recordvideo.e.c.jG(bVar2.videoPath, bVar2.videoPath + "_thumb");
                com.tencent.mm.plugin.recordvideo.e.d dVar = com.tencent.mm.plugin.recordvideo.e.d.Cin;
                d.a aLQ = com.tencent.mm.plugin.recordvideo.e.d.aLQ(bVar2.videoPath);
                Log.i("MicroMsg.VLogPreviewPluginLayout", "vlog video output info:".concat(String.valueOf(aLQ)));
                Boolean valueOf = Boolean.valueOf(booleanValue);
                String str = bVar2.videoPath;
                String str2 = bVar2.thumbPath;
                if (aLQ != null) {
                    i2 = aLQ.duration;
                } else {
                    i2 = 0;
                }
                Long valueOf2 = Long.valueOf((long) i2);
                Boolean bool2 = Boolean.FALSE;
                com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                CaptureDataManager.BOb.a(this.$context, new CaptureDataManager.CaptureVideoNormalModel(valueOf, str, str2, valueOf2, bool2, com.tencent.mm.plugin.recordvideo.d.c.eKW()));
            } else {
                Context context = this.$context;
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(111113);
                    throw tVar;
                }
                ((Activity) context).finish();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(111113);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VLogPreviewPluginLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(111120);
        this.GFI = new c(this, context);
        com.tencent.mm.plugin.vlog.ui.manager.c cVar = com.tencent.mm.plugin.vlog.ui.manager.c.GGi;
        Log.i("MicroMsg.VLogPreviewPluginLayout", "VLogPreviewPluginLayout invoke init");
        AppMethodBeat.o(111120);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/VLogPreviewPluginLayout$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void a(com.tencent.mm.plugin.recordvideo.activity.a aVar, RecordConfigProvider recordConfigProvider) {
        Integer num;
        String str;
        Integer num2;
        Integer num3;
        Integer num4;
        String str2;
        Integer num5;
        int i2;
        Integer num6 = null;
        AppMethodBeat.i(111114);
        p.h(aVar, "navigator");
        p.h(recordConfigProvider, "configProvider");
        super.a(aVar, recordConfigProvider);
        getCropVideoPlugin().setVisibility(8);
        f editFinishPlugin = getEditFinishPlugin();
        UICustomParam uICustomParam = recordConfigProvider.BOn;
        Integer valueOf = uICustomParam != null ? Integer.valueOf(uICustomParam.gLM) : null;
        UICustomParam uICustomParam2 = recordConfigProvider.BOn;
        if (uICustomParam2 != null) {
            num = Integer.valueOf(uICustomParam2.gLN);
        } else {
            num = null;
        }
        UICustomParam uICustomParam3 = recordConfigProvider.BOn;
        if (uICustomParam3 != null) {
            str = uICustomParam3.text;
        } else {
            str = null;
        }
        UICustomParam uICustomParam4 = recordConfigProvider.BOn;
        if (uICustomParam4 != null) {
            num2 = Integer.valueOf(uICustomParam4.gLO);
        } else {
            num2 = null;
        }
        editFinishPlugin.a(valueOf, num, str, num2);
        com.tencent.mm.plugin.recordvideo.plugin.a.a addMusicPlugin = getAddMusicPlugin();
        UICustomParam uICustomParam5 = recordConfigProvider.BOn;
        if (uICustomParam5 != null) {
            num3 = Integer.valueOf(uICustomParam5.gLM);
        } else {
            num3 = null;
        }
        UICustomParam uICustomParam6 = recordConfigProvider.BOn;
        if (uICustomParam6 != null) {
            num4 = Integer.valueOf(uICustomParam6.gLN);
        } else {
            num4 = null;
        }
        com.tencent.mm.plugin.recordvideo.plugin.a.a.a(addMusicPlugin, num3, num4);
        com.tencent.mm.plugin.recordvideo.plugin.p addonTextPlugin = getAddonTextPlugin();
        UICustomParam uICustomParam7 = recordConfigProvider.BOn;
        if (uICustomParam7 != null) {
            str2 = uICustomParam7.gLP;
        } else {
            str2 = null;
        }
        addonTextPlugin.setText(str2);
        com.tencent.mm.plugin.recordvideo.plugin.c addTextPlugin = getAddTextPlugin();
        UICustomParam uICustomParam8 = recordConfigProvider.BOn;
        if (uICustomParam8 != null) {
            num5 = Integer.valueOf(uICustomParam8.gLM);
        } else {
            num5 = null;
        }
        UICustomParam uICustomParam9 = recordConfigProvider.BOn;
        if (uICustomParam9 != null) {
            num6 = Integer.valueOf(uICustomParam9.gLN);
        }
        addTextPlugin.a(num5, num6);
        getMoreMenuPlugin().setScene(recordConfigProvider.scene);
        com.tencent.mm.plugin.recordvideo.plugin.d addTipPlugin = getAddTipPlugin();
        Map<String, Boolean> map = recordConfigProvider.BOn.gLL;
        p.g(map, "configProvider.uiParam.pluginHiddenMap");
        if (map.containsKey("plugin_tip")) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        addTipPlugin.BQc = i2;
        AppMethodBeat.o(111114);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void a(com.tencent.mm.media.widget.camerarecordview.b.b bVar) {
        AppMethodBeat.i(111115);
        Log.i("MicroMsg.VLogPreviewPluginLayout", "loadCurrentPage model:".concat(String.valueOf(bVar)));
        super.a(bVar);
        d.b.a(this, d.c.BVW);
        AppMethodBeat.o(111115);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.d
    public final void a(d.c cVar, Bundle bundle) {
        int i2;
        ah ahVar;
        boolean z;
        AudioCacheInfo audioCacheInfo;
        AudioCacheInfo audioCacheInfo2;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(111116);
        p.h(cVar, "status");
        Log.i("MicroMsg.VLogPreviewPluginLayout", "statusChange " + cVar + "  param:" + bundle);
        switch (e.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                getItemContainerPlugin().setVisibility(0);
                getVideoControlContainerPlugin().setVisibility(0);
                com.tencent.mm.plugin.recordvideo.plugin.a.a addMusicPlugin = getAddMusicPlugin();
                RecordConfigProvider configProvider = getConfigProvider();
                if (!this.GFL.GzH) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                com.tencent.mm.plugin.recordvideo.b.d dVar = new com.tencent.mm.plugin.recordvideo.b.d();
                Log.i("MicroMsg.EditAddMusicPlugin", "editorConfig : ".concat(String.valueOf(dVar)));
                Integer valueOf = configProvider != null ? Integer.valueOf(configProvider.scene) : null;
                if (valueOf != null && valueOf.intValue() == 2) {
                    dVar.a(i.SNSComm);
                    dVar.BNc = true;
                    dVar.BNb = true;
                } else if (valueOf != null && valueOf.intValue() == 3) {
                    dVar.a(i.StoryComm);
                    dVar.BNb = true;
                    dVar.BNc = true;
                } else if (valueOf != null && valueOf.intValue() == 11) {
                    dVar.a(i.Finder);
                    dVar.BNb = true;
                    dVar.BNc = true;
                }
                addMusicPlugin.setPlayMusicWhenSearchFinish(false);
                EditorAudioView editorAudioView = addMusicPlugin.wgL;
                p.h(dVar, "config");
                editorAudioView.b(dVar);
                editorAudioView.a(dVar);
                editorAudioView.Cce.setSelection(-1);
                if (z2) {
                    editorAudioView.Cbk.setVisibility(0);
                } else {
                    editorAudioView.Cbk.setVisibility(8);
                }
                editorAudioView.eLS();
                getAddMusicPlugin().gh(this.GFL.eua());
                AppMethodBeat.o(111116);
                return;
            case 2:
                if (bundle == null || (audioCacheInfo2 = (AudioCacheInfo) bundle.getParcelable("EDIT_SELECT_MUSIC_PARCELABLE")) == null) {
                    AppMethodBeat.o(111116);
                    return;
                }
                int i3 = audioCacheInfo2.source;
                AudioCacheInfo.a aVar = AudioCacheInfo.BPo;
                if (i3 == AudioCacheInfo.BPm) {
                    Log.i("MicroMsg.VLogPreviewPluginLayout", "current script index is :" + audioCacheInfo2.position);
                    ae aeVar = this.GFL;
                    aeVar.currentIndex = audioCacheInfo2.position;
                    long j2 = aeVar.GzG.get(aeVar.currentIndex).KPe;
                    List<s> a2 = aeVar.a(aeVar.GzG.get(aeVar.currentIndex));
                    String str = aeVar.GzG.get(aeVar.currentIndex).NoU.MqU;
                    p.g(str, "scripts[currentIndex].music.music_url");
                    ah ahVar2 = new ah(j2, a2, str, aeVar.GzG.get(aeVar.currentIndex));
                    ag agVar = this.GFJ;
                    if (agVar == null) {
                        p.btv("previewPlayerPlugin");
                    }
                    p.h(ahVar2, "model");
                    VLogPreloadPlayView vLogPreloadPlayView = agVar.GIT;
                    p.h(ahVar2, "model");
                    Log.i("MicroMsg.VLogPreloadPlayView", "renderScript:".concat(String.valueOf(ahVar2)));
                    if (vLogPreloadPlayView.GCP == null) {
                        vLogPreloadPlayView.GFW = ahVar2;
                    }
                    com.tencent.mm.plugin.vlog.player.c cVar2 = vLogPreloadPlayView.GCP;
                    if (cVar2 != null) {
                        cVar2.a(ahVar2, ahVar2.getVideoDurationMs(), ahVar2.GzR);
                    }
                    al alVar = al.GAc;
                    al.a(ahVar2);
                }
                AppMethodBeat.o(111116);
                return;
            case 3:
                if (bundle == null || (audioCacheInfo = (AudioCacheInfo) bundle.getParcelable("EDIT_VLOG_SEARCH_MUSIC_FINISH_PARCELABLE")) == null) {
                    AppMethodBeat.o(111116);
                    return;
                }
                int i4 = audioCacheInfo.BOX;
                Log.i("MicroMsg.VLogPreviewPluginLayout", "requestVLogScript prepare:true");
                String string = getContext().getString(R.string.hyh);
                p.g(string, "context.getString(R.string.vlog_dialog_tip)");
                aLt(string);
                ae aeVar2 = this.GFL;
                aeVar2.GzF = new b(this);
                aeVar2.DYl = i4;
                if (i4 == 0) {
                    aeVar2.GzG.clear();
                }
                byte[] decodeBytes = aeVar2.cQe.decodeBytes("VLOG_CONF");
                if (decodeBytes != null) {
                    if (decodeBytes.length != 0) {
                        z3 = false;
                    }
                    if (!z3) {
                        com.tencent.mm.bw.a parseFrom = new aar().parseFrom(decodeBytes);
                        if (parseFrom == null) {
                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ClientConfFromServer");
                            AppMethodBeat.o(111116);
                            throw tVar;
                        }
                        aeVar2.GzD = (aar) parseFrom;
                        aeVar2.hN(aeVar2.Gyw);
                        AppMethodBeat.o(111116);
                        return;
                    }
                }
                g.azz().b(new com.tencent.mm.plugin.vlog.model.cgi.b());
                AppMethodBeat.o(111116);
                return;
            case 4:
                getAddMusicPlugin().gi(this.GFL.eua());
                AppMethodBeat.o(111116);
                return;
            case 5:
                al alVar2 = al.GAc;
                ah ahVar3 = al.GAb;
                if (ahVar3 != null) {
                    al.a(null);
                    al alVar3 = al.GAc;
                    p.h(ahVar3, "vLogScriptModel");
                    ln lnVar = new ln();
                    lnVar.KPe = ahVar3.GzP;
                    lnVar.KPf = 2;
                    lnVar.KPh = System.currentTimeMillis();
                    lnVar.dNP = ahVar3.fBK();
                    lnVar.DYl = ahVar3.fBJ();
                    lnVar.KPi = ahVar3.fBL();
                    al.GAa.add(lnVar);
                    Log.i(al.TAG, "record select: vlogScriptModel = ".concat(String.valueOf(ahVar3)));
                    al.a(ahVar3);
                }
                Log.i(al.TAG, "record send");
                al.eKh();
                onPause();
                com.tencent.mm.plugin.vlog.ui.manager.a aVar2 = this.GFK;
                if (aVar2 != null) {
                    Log.i("MicroMsg.VLogGenerateManager", "release");
                    aVar2.GFT.release();
                }
                if (getMoreMenuPlugin().BQn) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                CaptureDataManager captureDataManager = CaptureDataManager.BOb;
                p.g(captureDataManager, "CaptureDataManager.INSTANCE");
                captureDataManager.getExtData().putInt("key_extra_feature_flag", i2);
                if (getMoreMenuPlugin().bxP == 2) {
                    CaptureDataManager captureDataManager2 = CaptureDataManager.BOb;
                    p.g(captureDataManager2, "CaptureDataManager.INSTANCE");
                    captureDataManager2.getExtData().putString("key_group_list", getMoreMenuPlugin().eKy());
                } else if (getMoreMenuPlugin().bxP == 3) {
                    CaptureDataManager captureDataManager3 = CaptureDataManager.BOb;
                    p.g(captureDataManager3, "CaptureDataManager.INSTANCE");
                    captureDataManager3.getExtData().putString("key_black_list", getMoreMenuPlugin().eKy());
                }
                ae aeVar3 = this.GFL;
                if (aeVar3.GzG.isEmpty()) {
                    ah.a aVar3 = ah.GzT;
                    ahVar = new ah(0, new ArrayList(), "", new erh());
                } else {
                    long j3 = aeVar3.GzG.get(aeVar3.currentIndex).KPe;
                    List<s> a3 = aeVar3.a(aeVar3.GzG.get(aeVar3.currentIndex));
                    String str2 = aeVar3.GzG.get(aeVar3.currentIndex).NoU.MqU;
                    p.g(str2, "scripts[currentIndex].music.music_url");
                    ahVar = new ah(j3, a3, str2, aeVar3.GzG.get(aeVar3.currentIndex));
                }
                if (!ahVar.GzQ.isEmpty()) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    Log.e("MicroMsg.VLogPreviewPluginLayout", "model is not valid");
                    AppMethodBeat.o(111116);
                    return;
                }
                ahVar.p(getItemContainerPlugin().eKr());
                getItemContainerPlugin();
                ahVar.BKW = h.eKs();
                ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> editorDataList = getItemContainerPlugin().getEditorDataList();
                p.h(editorDataList, "<set-?>");
                ahVar.BNo = editorDataList;
                ahVar.aT(h.a(getItemContainerPlugin()));
                if (getContext() != null) {
                    Context context = getContext();
                    RecordConfigProvider configProvider2 = getConfigProvider();
                    if (configProvider2 == null) {
                        p.hyc();
                    }
                    this.GFK = new com.tencent.mm.plugin.vlog.ui.manager.a(context, ahVar, configProvider2, getAddMusicPlugin().wgL.getMuteOrigin(), getAddMusicPlugin().wgG);
                    String string2 = getContext().getString(R.string.hyh);
                    p.g(string2, "context.getString(R.string.vlog_dialog_tip)");
                    aLt(string2);
                    e aAh = g.aAh();
                    p.g(aAh, "MMKernel.storage()");
                    int i5 = aAh.azQ().getInt(ar.a.USERINFO_TOP_STORY_REMUX_TYPE_INT, 0);
                    StringBuilder sb = new StringBuilder("remux foreground? ");
                    if (i5 != 0) {
                        z3 = false;
                    }
                    Log.i("MicroMsg.VLogPreviewPluginLayout", sb.append(z3).toString());
                    if (i5 == 0) {
                        com.tencent.mm.plugin.vlog.ui.manager.a aVar4 = this.GFK;
                        if (aVar4 != null) {
                            ag agVar2 = this.GFJ;
                            if (agVar2 == null) {
                                p.btv("previewPlayerPlugin");
                            }
                            int width = agVar2.GIT.getWidth();
                            ag agVar3 = this.GFJ;
                            if (agVar3 == null) {
                                p.btv("previewPlayerPlugin");
                            }
                            int height = agVar3.GIT.getHeight();
                            q<? super Boolean, ? super Integer, ? super a.b, x> qVar = this.GFI;
                            p.h(qVar, "callback");
                            Log.i("MicroMsg.VLogGenerateManager", "generate path :" + aVar4.wdm.BOA);
                            aVar4.xlr = qVar;
                            aVar4.GFT.jw(width, height);
                            if (TextUtils.isEmpty(aVar4.GFW.GzR)) {
                                aVar4.GFT.e(aVar4.GFV);
                                AppMethodBeat.o(111116);
                                return;
                            }
                            aVar4.GFS.d(aVar4.GFW.GzR, new a.e(aVar4));
                            AppMethodBeat.o(111116);
                            return;
                        }
                        AppMethodBeat.o(111116);
                        return;
                    }
                    com.tencent.mm.plugin.vlog.ui.manager.a aVar5 = this.GFK;
                    if (aVar5 != null) {
                        ag agVar4 = this.GFJ;
                        if (agVar4 == null) {
                            p.btv("previewPlayerPlugin");
                        }
                        int width2 = agVar4.GIT.getWidth();
                        ag agVar5 = this.GFJ;
                        if (agVar5 == null) {
                            p.btv("previewPlayerPlugin");
                        }
                        int height2 = agVar5.GIT.getHeight();
                        q<? super Boolean, ? super Integer, ? super a.b, x> qVar2 = this.GFI;
                        p.h(qVar2, "callback");
                        Log.i("MicroMsg.VLogGenerateManager", "generate path :" + aVar5.wdm.BOA);
                        aVar5.xlr = qVar2;
                        aVar5.GFT.jw(width2, height2);
                        com.tencent.mm.plugin.vlog.remux.d.a(aVar5.GFT, new a.d(aVar5, width2, height2));
                        AppMethodBeat.o(111116);
                        return;
                    }
                }
                AppMethodBeat.o(111116);
                return;
            case 6:
                if (bundle != null) {
                    boolean z4 = bundle.getBoolean("PARAM_EDIT_ORIGIN_VOICE_MUTE_BOOLEAN");
                    ag agVar6 = this.GFJ;
                    if (agVar6 == null) {
                        p.btv("previewPlayerPlugin");
                    }
                    agVar6.GIT.setMute(z4);
                    AppMethodBeat.o(111116);
                    return;
                }
                AppMethodBeat.o(111116);
                return;
            default:
                Log.i("MicroMsg.VLogPreviewPluginLayout", "unknown key ".concat(String.valueOf(cVar)));
                super.a(cVar, bundle);
                AppMethodBeat.o(111116);
                return;
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout
    public final View getPlayerView() {
        AppMethodBeat.i(111117);
        VLogPreloadPlayView vLogPreloadPlayView = new VLogPreloadPlayView(getContext());
        this.GFJ = new ag(vLogPreloadPlayView, this);
        ArrayList<com.tencent.mm.plugin.recordvideo.plugin.t> pluginList = getPluginList();
        ag agVar = this.GFJ;
        if (agVar == null) {
            p.btv("previewPlayerPlugin");
        }
        pluginList.add(agVar);
        VLogPreloadPlayView vLogPreloadPlayView2 = vLogPreloadPlayView;
        AppMethodBeat.o(111117);
        return vLogPreloadPlayView2;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final boolean onBackPress() {
        AppMethodBeat.i(111118);
        Log.i("MicroMsg.VLogPreviewPluginLayout", "onBackPress");
        if (!super.onBackPress()) {
            al alVar = al.GAc;
            al.a(null);
            Log.i(al.TAG, "record cancel");
            al.eKh();
            com.tencent.mm.plugin.recordvideo.activity.a navigator = getNavigator();
            if (navigator != null) {
                navigator.a(0, null);
            }
        }
        AppMethodBeat.o(111118);
        return true;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void release() {
        AppMethodBeat.i(111119);
        super.release();
        AppMethodBeat.o(111119);
    }

    public static final /* synthetic */ void a(VLogPreviewPluginLayout vLogPreviewPluginLayout) {
        AppMethodBeat.i(111122);
        if (vLogPreviewPluginLayout.nUq != null) {
            Log.i("MicroMsg.EditorVideoPluginLayout", "hideDialog");
            Context context = vLogPreviewPluginLayout.getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(111122);
                throw tVar;
            }
            ((Activity) context).runOnUiThread(new BaseEditVideoPluginLayout.b(vLogPreviewPluginLayout));
        }
        AppMethodBeat.o(111122);
    }
}
