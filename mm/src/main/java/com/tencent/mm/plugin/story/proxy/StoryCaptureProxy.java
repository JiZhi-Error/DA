package com.tencent.mm.plugin.story.proxy;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.clm;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.protocal.protobuf.dlg;
import com.tencent.mm.protocal.protobuf.eds;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001:B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005Jb\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0!2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0!H\u0016Jr\u0010\u0016\u001a\u00020\b2\u0006\u0010$\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0!2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0!H\u0016J6\u0010)\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020'2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0!H\u0007J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020+H\u0002J\b\u0010/\u001a\u00020\rH\u0016J\b\u00100\u001a\u00020\rH\u0007J\b\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u000202H\u0007J \u00104\u001a\u00020\u00112\u0006\u00105\u001a\u00020\r2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020'H\u0016J\u0019\u00109\u001a\u00020\u00112\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020+H\u0002Rx\u0010\u0006\u001a`\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006;"}, hxF = {"Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "Lcom/tencent/mm/plugin/story/proxy/IProxyAction;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "musicCallback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "errType", "errCode", "", "errMsg", "Lcom/tencent/mm/protocal/protobuf/MMSPRGetRecommendedMusicResponse;", "resp", "", "getMusicCallback", "()Lkotlin/jvm/functions/Function4;", "setMusicCallback", "(Lkotlin/jvm/functions/Function4;)V", "commitStory", "taskId", "thumbPath", FirebaseAnalytics.b.LOCATION, "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "captureInfo", "Lcom/tencent/mm/protocal/protobuf/CommonCaptureParams;", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "scope", "groupList", "", "blackList", "srcMd5List", "videoPath", "mediaDes", "isCaptureVideo", "", "favorite", "commitStoryRemote", "get", "", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defva", "getAccPath", "getAccPathRemote", "getVideoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getVideoParaRemote", "onCallback", "methodName", "data", "Landroid/os/Bundle;", "clientCall", "set", "Companion", "plugin-story_release"})
public final class StoryCaptureProxy extends com.tencent.mm.remoteservice.a implements a {
    public static StoryCaptureProxy FsX = null;
    public static final a FsY = new a((byte) 0);
    private static final String RESULT_KEY = RESULT_KEY;
    private static final String TAG = TAG;
    private r<? super Integer, ? super Integer, ? super String, ? super clm, x> FsW;

    public StoryCaptureProxy(d dVar) {
        super(dVar);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy$Companion;", "", "()V", "RESULT_KEY", "", "TAG", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "getInstance", "()Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "setInstance", "(Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;)V", "createInstance", "", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static StoryCaptureProxy fpI() {
            AppMethodBeat.i(119354);
            StoryCaptureProxy storyCaptureProxy = StoryCaptureProxy.FsX;
            if (storyCaptureProxy == null) {
                p.btv("instance");
            }
            AppMethodBeat.o(119354);
            return storyCaptureProxy;
        }
    }

    static {
        AppMethodBeat.i(119365);
        AppMethodBeat.o(119365);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.r<? super java.lang.Integer, ? super java.lang.Integer, ? super java.lang.String, ? super com.tencent.mm.protocal.protobuf.clm, kotlin.x>, kotlin.g.a.r<java.lang.Integer, java.lang.Integer, java.lang.String, com.tencent.mm.protocal.protobuf.clm, kotlin.x> */
    public final r<Integer, Integer, String, clm, x> getMusicCallback() {
        return this.FsW;
    }

    public final void setMusicCallback(r<? super Integer, ? super Integer, ? super String, ? super clm, x> rVar) {
        this.FsW = rVar;
    }

    public final String getAccPath() {
        AppMethodBeat.i(119355);
        String obj = REMOTE_CALL("getAccPathRemote", new Object[0]).toString();
        AppMethodBeat.o(119355);
        return obj;
    }

    @f
    public final String getAccPathRemote() {
        AppMethodBeat.i(119356);
        e aAh = g.aAh();
        p.g(aAh, "storage()");
        String accPath = aAh.getAccPath();
        p.g(accPath, "storage().accPath");
        AppMethodBeat.o(119356);
        return accPath;
    }

    public final VideoTransPara getVideoPara() {
        AppMethodBeat.i(119357);
        VideoTransPara videoTransPara = (VideoTransPara) REMOTE_CALL("getVideoParaRemote", new Object[0]);
        if (videoTransPara == null) {
            p.hyc();
        }
        AppMethodBeat.o(119357);
        return videoTransPara;
    }

    @f
    public final VideoTransPara getVideoParaRemote() {
        AppMethodBeat.i(119358);
        com.tencent.mm.modelcontrol.e baZ = com.tencent.mm.modelcontrol.e.baZ();
        p.g(baZ, "SubCoreVideoControl.getCore()");
        VideoTransPara bbd = baZ.bbd();
        p.g(bbd, "para");
        AppMethodBeat.o(119358);
        return bbd;
    }

    @Override // com.tencent.mm.plugin.story.proxy.a
    public final int commitStory(String str, String str2, String str3, dlg dlg, boolean z, eds eds, int i2, int i3, List<String> list, List<String> list2, List<String> list3) {
        AppMethodBeat.i(222914);
        p.h(str, "videoPath");
        p.h(str2, "thumbPath");
        p.h(str3, "mediaDes");
        p.h(dlg, FirebaseAnalytics.b.LOCATION);
        p.h(eds, "editorInfo");
        p.h(list, "groupList");
        p.h(list2, "blackList");
        p.h(list3, "srcMd5List");
        String md5 = com.tencent.mm.d.g.getMD5(str);
        com.tencent.mm.plugin.story.f.g.d dVar = new com.tencent.mm.plugin.story.f.g.d();
        cly cly = new cly();
        Log.d(TAG, "videoPath:" + str + " thumbPath:" + str2 + " mediaDes:" + str3 + " videoMd5:" + md5 + " isCaptureVideo:" + z);
        cly.Mrn = z;
        p.g(md5, "md5");
        dVar.aV(str, str2, md5);
        dVar.a(eds);
        dVar.b(dlg);
        dVar.a(cly);
        dVar.aaJ(i2);
        dVar.hs(list);
        dVar.ht(list2);
        dVar.hu(list3);
        int commit = dVar.commit();
        j.b bVar = j.Fmy;
        j.b.foi().checkPost();
        AppMethodBeat.o(222914);
        return commit;
    }

    @Override // com.tencent.mm.plugin.story.proxy.a
    public final int commitStory(String str, String str2, dlg dlg, acg acg, eds eds, int i2, List<String> list, List<String> list2, List<String> list3) {
        AppMethodBeat.i(222915);
        p.h(str, "taskId");
        p.h(str2, "thumbPath");
        p.h(dlg, FirebaseAnalytics.b.LOCATION);
        p.h(acg, "captureInfo");
        p.h(eds, "editorInfo");
        p.h(list, "groupList");
        p.h(list2, "blackList");
        p.h(list3, "srcMd5List");
        com.tencent.mm.plugin.story.f.g.d dVar = new com.tencent.mm.plugin.story.f.g.d();
        cly cly = new cly();
        Log.d(TAG, "storyEditorData " + str + " isCaptureVideo:" + acg.iqf);
        cly.Mrn = acg.iqf;
        dVar.kZ(str, str2);
        dVar.a(eds);
        dVar.b(dlg);
        dVar.a(cly);
        dVar.aaJ(i2);
        dVar.hs(list);
        dVar.ht(list2);
        dVar.ht(list2);
        dVar.vO(acg.BMX);
        dVar.hu(list3);
        int commit = dVar.commit();
        j.b bVar = j.Fmy;
        j.b.foi().checkPost();
        AppMethodBeat.o(222915);
        return commit;
    }

    @f
    public final void commitStoryRemote(String str, String str2, String str3, boolean z, List<String> list) {
        AppMethodBeat.i(222916);
        p.h(str, "videoPath");
        p.h(str2, "thumbPath");
        p.h(str3, "mediaDes");
        p.h(list, "srcMd5List");
        String md5 = com.tencent.mm.d.g.getMD5(str);
        com.tencent.mm.plugin.story.f.g.d dVar = new com.tencent.mm.plugin.story.f.g.d();
        cly cly = new cly();
        Log.d(TAG, "videoPath:" + str + " thumbPath:" + str2 + " mediaDes:" + str3 + " videoMd5:" + md5 + " isCaptureVideo:" + z);
        cly.Mrn = z;
        p.g(md5, "md5");
        dVar.aV(str, str2, md5);
        dVar.a(cly);
        dVar.hu(list);
        dVar.commit();
        j.b bVar = j.Fmy;
        j.b.foi().checkPost();
        AppMethodBeat.o(222916);
    }

    public final void set(ar.a aVar, Object obj) {
        AppMethodBeat.i(119362);
        p.h(aVar, "key");
        p.h(obj, "defva");
        Log.i(TAG, "get %s %s", aVar, obj);
        ar.a[] aVarArr = (ar.a[]) ar.a.class.getEnumConstants();
        ar.a aVar2 = aVarArr != null ? aVarArr[aVar.ordinal()] : null;
        Log.i(TAG, "setConfigStorage, %s %s", aVar2, obj);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(aVar2, obj);
        AppMethodBeat.o(119362);
    }

    public final Object get(ar.a aVar, Object obj) {
        AppMethodBeat.i(119363);
        p.h(aVar, "key");
        p.h(obj, "defva");
        ar.a[] aVarArr = (ar.a[]) ar.a.class.getEnumConstants();
        ar.a aVar2 = aVarArr != null ? aVarArr[aVar.ordinal()] : null;
        Log.i(TAG, "getConfigStorage, %s %s", aVar2, obj);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        Object obj2 = aAh.azQ().get(aVar2, obj);
        p.g(obj2, "MMKernel.storage().configStg.get(index, defva)");
        AppMethodBeat.o(119363);
        return obj2;
    }

    @Override // com.tencent.mm.remoteservice.a, com.tencent.mm.remoteservice.b
    public final void onCallback(String str, Bundle bundle, boolean z) {
        AppMethodBeat.i(119364);
        p.h(str, "methodName");
        p.h(bundle, "data");
        Log.i(TAG, "class:%s, method:%s, clientCall:%B", getClass().getName(), str, Boolean.valueOf(z));
        Method method = null;
        try {
            Method[] methods = getClass().getMethods();
            p.g(methods, "this.javaClass.methods");
            int length = methods.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                Method method2 = methods[i2];
                p.g(method2, "mth");
                if (n.I(method2.getName(), str, true)) {
                    method = method2;
                    break;
                }
                i2++;
            }
            if (method != null) {
                if (method.isAnnotationPresent(z ? com.tencent.mm.remoteservice.e.class : f.class)) {
                    Object[] args = getArgs(bundle);
                    Object invoke = method.invoke(this, Arrays.copyOf(args, args.length));
                    if (!p.j(method.getReturnType(), Void.TYPE)) {
                        if (invoke instanceof Parcelable) {
                            bundle.putParcelable(RESULT_KEY, (Parcelable) invoke);
                            AppMethodBeat.o(119364);
                            return;
                        }
                        String str2 = RESULT_KEY;
                        if (invoke == null) {
                            t tVar = new t("null cannot be cast to non-null type java.io.Serializable");
                            AppMethodBeat.o(119364);
                            throw tVar;
                        }
                        bundle.putSerializable(str2, (Serializable) invoke);
                        AppMethodBeat.o(119364);
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            Log.e(TAG, "exception:%s", Util.stackTraceToString(e2));
        }
        AppMethodBeat.o(119364);
    }

    public static final void createInstance(d dVar) {
        AppMethodBeat.i(119366);
        StoryCaptureProxy storyCaptureProxy = new StoryCaptureProxy(dVar);
        p.h(storyCaptureProxy, "<set-?>");
        FsX = storyCaptureProxy;
        AppMethodBeat.o(119366);
    }
}
